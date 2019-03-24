
package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;

/**
 * <p>Title: ThirdPartyViewHelper</p>
 * <p>Description:�����������ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2005</p>
 * @author ����������Ŀ�� wangli
 * @version 1.0
 * <br>
 */
public class ThirdPartyViewHelper  {
	
	
	public ThirdPartyViewHelper(){
		
	}

	
	/**
	    * ����鿱ʱ�鿱ҳ����������.
	    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	    * @param httpServletRequest
	    * @return checkDto �鿱���ݴ������ݽṹ
	    * @throws Exception
	    */
	  
	    public CheckDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
	    {
	    	//add by liyanjie 2005-12-17 start �ж�˫������,�����Ķ�������ָ����յ�(��ί�з�)
	    	String commiFlag = "";//httpServletRequest.getParameter("commiFlag");
	    	System.out.println("----- ����������ȱ��� ==˫����־:"+commiFlag);
	    	UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
	    	//add by liyanjie 2005-12-17 end
	    	
	    	
	      //�̳ж�check,checkText��ĸ�ֵ
	       CheckDto checkDto = new CheckDto();
	    	//CheckDto checkDto = super.viewToDto(httpServletRequest);
		    int intCheckLossIndex = 1;//���
		    ArrayList prpLcheckLossDtoList = null;
		    boolean newScheduleItem=false;
		    
		  httpServletRequest.setAttribute("prpLnodeType","check");
		  String prplregistDamageAddress =httpServletRequest.getParameter("prplregistDamageAddress");
		    
	      ArrayList thirdPartyDtoList = new ArrayList();
	      PrpLthirdPartyDto prpLthirdPartyDto = null ;
	      //�ӽ���õ���������
	      String   prpLthirdPartyClaimNo          = httpServletRequest.getParameter("prpLcheckClaimNo");
	      String   prpLthirdPartyRiskCode         = httpServletRequest.getParameter("prpLcheckRiskCode");
	     // String   prpLthirdPartyRiskCode = "DAA";
	      String   prpLthirdPartyRegistNo          = (String)httpServletRequest.getParameter("businessNo");
	      String   prpLcheckLossPolicyNo  = httpServletRequest.getParameter("policyNo");
	      //ע��˴����浽checkDto��
	      PrpLcheckDto prpLcheckDto1 = new PrpLcheckDto();
	      prpLcheckDto1.setRegistNo(prpLthirdPartyRegistNo);
	      checkDto.setPrpLcheckDto(prpLcheckDto1);
	      
	        //��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
        String claimNo=prpLthirdPartyClaimNo;
        String registNo  = prpLthirdPartyRegistNo;
  
        //add by lixiang start 20051010
     	  //reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
      	if (claimNo==null||claimNo.length()<2){
      	  UICodeAction uiCodeAction = new UICodeAction();
          claimNo=uiCodeAction.translateBusinessCode(registNo,true);
      	}
        //add by lixiang end 20051010
      
	      ////System.out.println("********�����Ĳ���  �����Ĳ��� 2222 ************prpLthirdPartyRegistNo is :"+prpLthirdPartyRegistNo);
	      
	  String   prpLthirdPartyClauseType       = httpServletRequest.getParameter      ("prpLcheckClauseType"        );
	  String[] prpLthirdPartySerialNo         = httpServletRequest.getParameterValues("prpLthirdPartySerialNo"          );
	  String[] prpLthirdPartyLicenseNo        = httpServletRequest.getParameterValues("prpLthirdPartyLicenseNo"         );
	  String[] prpLthirdPartyLicenseColorCode = httpServletRequest.getParameterValues("licenseColorCode"  );
	  String[] prpLthirdPartyCarKindCode      = httpServletRequest.getParameterValues("carKindCode"       );
	  String[] prpLthirdPartyInsureCarFlag    = httpServletRequest.getParameterValues("insureCarFlag"     );
	  String[] prpLthirdPartyCarOwner         = httpServletRequest.getParameterValues("prpLthirdPartyCarOwner"          );
	  String[] prpLthirdPartyEngineNo         = httpServletRequest.getParameterValues("prpLthirdPartyEngineNo"          );
	  String[] prpLthirdPartyFrameNo          = httpServletRequest.getParameterValues("prpLthirdPartyFrameNo"           );
	  String[] prpLthirdPartyModelCode        = httpServletRequest.getParameterValues("prpLthirdPartyModelCode"         );
	  String[] prpLthirdPartyBrandName        = httpServletRequest.getParameterValues("prpLthirdPartyBrandName"         );
	  String[] prpLthirdPartyRunDistance      = httpServletRequest.getParameterValues("prpLthirdPartyRunDistance"       );
	  String[] prpLthirdPartyUseYears         = httpServletRequest.getParameterValues("prpLthirdPartyUseYears"          );
	  String[] prpLthirdPartyDutyPercent      = httpServletRequest.getParameterValues("prpLthirdPartyDutyPercent"       );
	  String[] prpLthirdPartyInsuredFlag      = httpServletRequest.getParameterValues("insuredFlag"       );
	  String[] prpLthirdPartyInsureComCode    = httpServletRequest.getParameterValues("prpLthirdPartyInsureComCode"     );
	  String[] prpLthirdPartyInsureComName    = httpServletRequest.getParameterValues("prpLthirdPartyInsureComName"     );
	  String[] prpLthirdPartyFlag             = httpServletRequest.getParameterValues("prpLthirdPartyFlag"              );
	  String[] prpLthirdPartyVINNo            = httpServletRequest.getParameterValues("prpLthirdPartyVINNo"    );
	   //�õ����صı�־��Ϊnew ��Ҫ���浽���� ����Ϊ����Ҫ
	  String[] prpLthirdPartyNewAddFlag       = httpServletRequest.getParameterValues("prpLthirdPartyNewAddFlag"        );
      
	  //���ȱ���õ�
	  ArrayList scheduleItemDtoList= new ArrayList();
	  PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
	  //����ֵ
	  if (prpLthirdPartySerialNo==null)
	  {
	  }else
	  {
	    //���߳������ֿ�ʼ
	    for(int index=1;index<prpLthirdPartySerialNo.length;index++)
	    {
	      //ֻ��������� ��ǰ�Ĳ����� �ڴ˴��ж�
	      //if(prpLthirdPartyNewAddFlag[index].equals("new")){
	      	prpLthirdPartyDto = new PrpLthirdPartyDto();
	        prpLthirdPartyDto.setRegistNo          (prpLthirdPartyRegistNo               );
	        prpLthirdPartyDto.setRiskCode          (prpLthirdPartyRiskCode               );
	        prpLthirdPartyDto.setSerialNo          (Integer.parseInt(DataUtils.nullToZero(prpLthirdPartySerialNo[index])));
	        prpLthirdPartyDto.setClaimNo           (claimNo                );
	        prpLthirdPartyDto.setClauseType        (prpLthirdPartyClauseType             );
	        prpLthirdPartyDto.setLicenseNo         (prpLthirdPartyLicenseNo       [index].trim());
	        if(prpLthirdPartyLicenseColorCode!=null){
	        prpLthirdPartyDto.setLicenseColorCode  (prpLthirdPartyLicenseColorCode[index]);
	        }
	        if(prpLthirdPartyCarKindCode!=null){
	        prpLthirdPartyDto.setCarKindCode       (prpLthirdPartyCarKindCode     [index]);
	        }
	        prpLthirdPartyDto.setInsureCarFlag     (prpLthirdPartyInsureCarFlag   [index]);
	        prpLthirdPartyDto.setEngineNo          (prpLthirdPartyEngineNo        [index]);
	        prpLthirdPartyDto.setFrameNo           (prpLthirdPartyFrameNo         [index]);
	        prpLthirdPartyDto.setBrandName         (prpLthirdPartyBrandName       [index]);
	        prpLthirdPartyDto.setRunDistance       (Double.parseDouble(DataUtils.nullToZero(prpLthirdPartyRunDistance[index])));
	        prpLthirdPartyDto.setUseYears          (Integer.parseInt(DataUtils.nullToZero(prpLthirdPartyUseYears[index])));
	        prpLthirdPartyDto.setDutyPercent       (Double.parseDouble(DataUtils.nullToZero(prpLthirdPartyDutyPercent[index])));
	        prpLthirdPartyDto.setInsuredFlag       (prpLthirdPartyInsuredFlag     [index]);
	        prpLthirdPartyDto.setInsureComCode     (prpLthirdPartyInsureComCode   [index]);
	        prpLthirdPartyDto.setInsureComName     (prpLthirdPartyInsureComName   [index]);
	        prpLthirdPartyDto.setVINNo     (prpLthirdPartyVINNo   [index]);
	        
	        //���뼯��
	        thirdPartyDtoList.add(prpLthirdPartyDto);
	        
	      
	        //����������
	        prpLscheduleItemDto = new PrpLscheduleItemDto();
	        prpLscheduleItemDto.setScheduleID         (1);
	        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyRegistNo);
	        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
	        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
	        
	        //modify by liyanjie 2005-12-17 start �����˫������,���շ������������,�����Ķ�����������յ�;
	        System.out.println("------ ���Ӷ��� scheduleitem--- "+prpLthirdPartyDto.getLicenseNo());
	        System.out.println("------ ���Ӷ��� ---commiFlag:"+commiFlag);
	       // if( (!(commiFlag == null )) && "1".equals(commiFlag)){
	      //  	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
	       // 	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
	       // }else{
	       // 	prpLscheduleItemDto.setClaimComCode       (user.getScheduleComCode()  );
	       // }
	        prpLscheduleItemDto.setClaimComCode(user.getComCode() );
	        System.out.println("------ ���Ӷ��� ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
	        
	        //modify by liyanjie 2005-12-17 end
	        //��ʾ�Ƿ�ѡ��
	        prpLscheduleItemDto.setSelectSend         ("1");
	        //��ʾû�е��ȳɶ����
	        prpLscheduleItemDto.setSurveyTimes        (0);
	        prpLscheduleItemDto.setSurveyType         ("1");
	       // prpLscheduleItemDto.setCheckSite          (checkDto.getPrpLcheckDto().getCheckSite());
	        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
	        prpLscheduleItemDto.setScheduleObjectID   ("_");
	        prpLscheduleItemDto.setScheduleObjectName (" ");
	        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current() ,DateTime.YEAR_TO_DAY ));
	        prpLscheduleItemDto.setScheduleType       ("schel");
	        prpLscheduleItemDto.setCheckSite( prplregistDamageAddress);
	        if(prpLthirdPartyNewAddFlag[index].equals("new")){			//����������Ķ���,���� add if���� by liyanjie
	          //������ȱ�ļ���
	          scheduleItemDtoList.add(prpLscheduleItemDto);
	        }
	        //���õ��ȵı�ǩ��ʾ shcheduleItemNote
	        String strTemp ="���:";
	        if (prpLscheduleItemDto.getItemNo()!=1) strTemp ="����:";
	        checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
	            +strTemp+prpLscheduleItemDto.getLicenseNo()+"/");

	      //}
	    }

	    //�鿱�����м������߳���
	    checkDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
	    //�鿱�����м������������
	    checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
	  }
	      

        
	      //Modify by chenrenda add begin 20050408
		     //Reason:��ʧ��λģ����Ϣ�������永������Ϣ�У���Ӧģ��������
		     //---------------------��ʧ��λ PrpLthirdCarLoss begin------------------------------------
		     ArrayList thirdCarLossDtoList = new ArrayList();
		     PrpLthirdCarLossDto prpLthirdCarLossDto = null ;
		     //�ӽ���õ���������
		     String   prpLthirdCarLossRegistNo         = (String)httpServletRequest.getParameter("businessNo");
		     String   prpLthirdCarLossRiskCode         = httpServletRequest.getParameter("prpLcheckRiskCode");
		    // String   prpLthirdCarLossRiskCode         =  "DAA";
		     String[] prpLthirdCarLossSerialNo         = httpServletRequest.getParameterValues("RelateSerialNo");
		     String[] prpLthirdCarLossItemNo         = httpServletRequest.getParameterValues("prpLthirdCarLossItemNo");
		     String[] prpLthirdCarLossLicenseNo         = httpServletRequest.getParameterValues("prpLthirdCarLossLicenseNo");
		     //Modify by chenrenda update begin 20050407
		     String[] prpLthirdCarLossPartCode        = httpServletRequest.getParameterValues("partCode"); //��������
		     String[] prpLthirdCarLossPartName         = httpServletRequest.getParameterValues("partName"); //��������
		     String[] prpLthirdCarLossCompCode         = httpServletRequest.getParameterValues("compCode");//�������
		     String[] prpLthirdCarLossCompName        = httpServletRequest.getParameterValues("compName");//�������
		     String[] prpLthirdCarLossLossGrade         = httpServletRequest.getParameterValues("prpLthirdCarLossLossGrade");
		     String[] prpLthirdCarLossLossDesc         = httpServletRequest.getParameterValues("prpLthirdCarLossLossDesc");
		     String[] prpLthirdCarLossFlag         = httpServletRequest.getParameterValues("prpLthirdCarLossFlag");

		     //����ֵ
		     //��ʧ��λ���ֿ�ʼ
		    if (prpLthirdCarLossSerialNo==null)
		     {}
		     else
		     {
		       for(int index2=1;index2<prpLthirdCarLossSerialNo.length;index2++)
		       {

		         prpLthirdCarLossDto = new PrpLthirdCarLossDto();
		         prpLthirdCarLossDto.setRegistNo          (prpLthirdCarLossRegistNo               );
		         prpLthirdCarLossDto.setRiskCode          (prpLthirdCarLossRiskCode               );
		         prpLthirdCarLossDto.setSerialNo          (Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossSerialNo[index2])));
		         prpLthirdCarLossDto.setItemNo            (Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossItemNo [index2])));
		         prpLthirdCarLossDto.setLicenseNo         (prpLthirdCarLossLicenseNo       [index2]);
		         prpLthirdCarLossDto.setCompCode          (prpLthirdCarLossCompCode       [index2]);
		         prpLthirdCarLossDto.setCompName          (prpLthirdCarLossCompName       [index2]);
		         prpLthirdCarLossDto.setLossGrade         (prpLthirdCarLossLossGrade       [index2]);
		         prpLthirdCarLossDto.setLossDesc          (prpLthirdCarLossLossDesc       [index2]);
		         prpLthirdCarLossDto.setFlag              (prpLthirdCarLossFlag           [index2]);
		         prpLthirdCarLossDto.setPartCode          (prpLthirdCarLossPartCode       [index2]);
		         prpLthirdCarLossDto.setPartName          (prpLthirdCarLossPartName       [index2]);

		         //���뼯��
		         thirdCarLossDtoList.add(prpLthirdCarLossDto);
		       }
		       //�鿱�����м�����ʧ��λ
		       checkDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
		     }
		    //Modify by chenrenda add begin 20050407

		    //Reason:ҳ��������������ʧģ��
		    /*---------------------������ʧ��λ PrpLthirdProp begin------------------------------------*/
		    ArrayList thirdPropDtoList = new ArrayList();
		    PrpLthirdPropDto prpLthirdPropDto = null ;

		    //�ӽ���õ���������
		  //  String   prpLthirdPropRegistNo         = (String)httpServletRequest.getAttribute("businessNo");
		   // String   prpLthirdPropRiskCode         = httpServletRequest.getParameter      ("prpLcheckRiskCode");
		    String[] prpLthirdPropItemNo           = httpServletRequest.getParameterValues("prpLthirdPropItemNo");
		    String[] prpLthirdPropLicenseNo        = httpServletRequest.getParameterValues("prpLthirdPropLicenseNo");
		    String[] lossItemCode        = httpServletRequest.getParameterValues("prpLthirdLossItemCode");
		    String[] LossItemName         = httpServletRequest.getParameterValues("prpLthirdLossItemName");
		    String[] prpLthirdPropLossDesc         = httpServletRequest.getParameterValues("prpLthirdPropLossDesc");
		    String[] prpLthirdPropFlag         = httpServletRequest.getParameterValues("prpLthirdPropFlag");
		    
		    //Modify by chenrenda add begin 20050418
		    //Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		    String[] prpLthirdPropKindCode    = httpServletRequest.getParameterValues("prpLthirdPropKindCode"     );
		    String[] prpLthirdPropLossFee             = httpServletRequest.getParameterValues("prpLthirdPropLossFee"              );
		    //Modify by chenrenda add end 20050418
		    
		    //����ֵ
		    //��ʧ��λ���ֿ�ʼ
		    if (prpLthirdPropItemNo==null)
		    {}
		    else
		    { prpLcheckLossDtoList = new ArrayList();
		      for(int index=1;index<prpLthirdPropItemNo.length;index++)
		      {

		        prpLthirdPropDto = new PrpLthirdPropDto();
		        
		        //Modify by chenrenda update begin 20050418
		        //Reason:Ԥ����ʧģ��ϵ��永������Ϣ��
		        PrpLcheckLossDto   prpLcheckLossDto  = new PrpLcheckLossDto();
		        prpLcheckLossDto.setRegistNo(prpLthirdPartyRegistNo);
		        prpLcheckLossDto.setClaimNo(claimNo);
		        prpLcheckLossDto.setRiskCode(prpLthirdPartyRiskCode);
		        prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
		        //System.out.println("**********prpLthirdProp****:"+intCheckLossIndex);
		        prpLcheckLossDto.setSerialNo(intCheckLossIndex);
		        prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
		        
		        prpLcheckLossDto.setKindCode(prpLthirdPropKindCode[index]);
		        
		        prpLcheckLossDto.setLossFeeType("3");
		        prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLthirdPropLossFee[index])));
		        prpLcheckLossDto.setFlag("");
		        intCheckLossIndex++;
		        prpLcheckLossDtoList.add(prpLcheckLossDto);
		        //Modify by chenrenda update end 20050418
		        
		        prpLthirdPropDto.setRegistNo          (prpLthirdPartyRegistNo               );
		        prpLthirdPropDto.setRiskCode          (prpLthirdPartyRiskCode               );
		        prpLthirdPropDto.setSerialNo           (Integer.parseInt(DataUtils.nullToZero(prpLthirdPropItemNo      [index])));
		        prpLthirdPropDto.setLicenseNo         (prpLthirdPropLicenseNo       [index]);
		        prpLthirdPropDto.setLossItemCode          (lossItemCode       [index]);
		        prpLthirdPropDto.setLossItemName        (LossItemName       [index]);
		        prpLthirdPropDto.setLossItemDesc          (prpLthirdPropLossDesc       [index]);
		        //prpLthirdPropDto.setlo          (prpLthirdPropLossDesc       [index]);
			       
		        prpLthirdPropDto.setFlag              (prpLthirdPropFlag           [index]);

		        //���뼯��
		        thirdPropDtoList.add(prpLthirdPropDto);
		      }

		      
		      //���������м���������ʧ
		      checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
		      checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		      
		      //�������˶��������Ϣ��������ˣ��ͽ��е���

		         if (thirdPropDtoList!=null&&thirdPropDtoList.size() >0){
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //��ʾ�Ƿ�ѡ��
		         prpLscheduleItemDto.setSelectSend("1");
		         //��ʾû�е��ȳɶ����
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         
		         //modify by liyanjie 2005-12-17 start �����˫������,���շ������������,�����Ķ�����������յ�;
		         
		            System.out.println("------ ���Ӷ��� scheduleitem---�Ʋ���ʧ ");
			        System.out.println("------ ���Ӷ��� ---commiFlag:"+commiFlag);
			        //if( (!(commiFlag == null )) && "1".equals(commiFlag)){
			        //	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        //	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
			        //}else{
			        //	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			       // }
			        //System.out.println("------ ���Ӷ��� ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
		         prpLscheduleItemDto.setClaimComCode(user.getComCode() );
			     //modify by liyanjie 2005-12-17 end
		         
		         scheduleItemDtoList.add(prpLscheduleItemDto);

		         
		      //��ʾ���
		         checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
		                + prpLscheduleItemDto.getLicenseNo() + "/");
		         }
		       
		    }
		    
	       
		    /*---------------------��Ա�������� PrpLpersonTrace --------begin----------------------------*/
		    
		    
		      ArrayList personTraceDtoList = new ArrayList();
		      PrpLpersonTraceDto prpLpersonTraceDto = null ;
		      //�ӽ���õ���������
		  //   String   prpLpersonTraceRegistNo         =(String)httpServletRequest.getAttribute("businessNo"                   );
		  //   String   prpLpersonTraceClaimNo          =httpServletRequest.getParameter      ("prpLcheckRiskCode"            );
		  //   String   prpLpersonTracePolicyNo         =httpServletRequest.getParameter      ("policyNo"            );
		     String[] prpLpersonTracePersonNo         =httpServletRequest.getParameterValues("prpLpersonTracePersonNo"       );
		     String[] prpLpersonTracePersonName       =httpServletRequest.getParameterValues("prpLpersonTracePersonName"     );
		     String[] prpLpersonTracePersonSex        =httpServletRequest.getParameterValues("personSex"      );
		     String[] prpLpersonTracePersonAge        =httpServletRequest.getParameterValues("prpLpersonTracePersonAge"      );
		     String[] prpLpersonTraceIdentifyNumber   =httpServletRequest.getParameterValues("prpLpersonTraceIdentifyNumber" );
		     String[] prpLpersonTraceRelatePersonNo   =httpServletRequest.getParameterValues("prpLpersonTraceRelatePersonNo" );
		     String[] prpLpersonTraceJobCode          =httpServletRequest.getParameterValues("prpLpersonTraceJobCode"        );
		     String[] prpLpersonTraceJobName          =httpServletRequest.getParameterValues("prpLpersonTraceJobName"        );
		     String[] prpLpersonTraceReferKind        =httpServletRequest.getParameterValues("prpLpersonTraceReferKind"      );
		     String[] prpLpersonTracePartDesc         =httpServletRequest.getParameterValues("prpLpersonTracePartDesc"       );
		     String[] prpLpersonTraceHospital         =httpServletRequest.getParameterValues("prpLpersonTraceHospital"       );
		     String[] prpLpersonTraceMotionFlag       =httpServletRequest.getParameterValues("motionFlag"     );
		     String[] prpLpersonTraceWoundRemark      =httpServletRequest.getParameterValues("prpLpersonTraceWoundRemark"    );
		     String[] prpLpersonTraceRemark           =httpServletRequest.getParameterValues("prpLpersonTraceRemark"         );
		     String[] prpLpersonTraceFlag             =httpServletRequest.getParameterValues("prpLpersonTraceFlag"           );

		     //Modify by chenrenda add begin 20050418
		     //Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		     String[] prpLpersonTraceLossFee             = httpServletRequest.getParameterValues("prpLpersonTraceLossFee"              );
		     //Modify by chenrenda add end 20050418

		      //����ֵ
		      //��Ա�������� ���ֿ�ʼ
		      if (prpLpersonTracePersonNo==null)
		      {}
		      else
		      {
		        //System.out.println("��Ա�������ٲ��ֿ�ʼ ");
		        for(int index=1;index<prpLpersonTracePersonNo.length;index++)
		        {
		          prpLpersonTraceDto = new PrpLpersonTraceDto();
		      	          
		          prpLpersonTraceDto.setRegistNo       (prpLthirdPartyRegistNo         );
		          prpLpersonTraceDto.setClaimNo        (claimNo          );
		          prpLpersonTraceDto.setPolicyNo       (prpLcheckLossPolicyNo         );
		          prpLpersonTraceDto.setPersonNo       (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonNo       [index] )) );
		          prpLpersonTraceDto.setPersonName     (prpLpersonTracePersonName     [index]  );
		          prpLpersonTraceDto.setPersonSex      (prpLpersonTracePersonSex      [index]  );
		          prpLpersonTraceDto.setPersonAge      (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonAge      [index]))  );
		          prpLpersonTraceDto.setIdentifyNumber (prpLpersonTraceIdentifyNumber [index]  );
		          prpLpersonTraceDto.setRelatePersonNo (Integer.parseInt(DataUtils.nullToZero(prpLpersonTraceRelatePersonNo [index]) ) );
		          prpLpersonTraceDto.setJobCode        (prpLpersonTraceJobCode        [index]  );
		          prpLpersonTraceDto.setJobName        (prpLpersonTraceJobName        [index]  );
		      //    prpLpersonTraceDto.setReferKind      (prpLpersonTraceReferKind      [index]  );
		          prpLpersonTraceDto.setPartDesc       (prpLpersonTracePartDesc       [index]  );
		          prpLpersonTraceDto.setHospital       (prpLpersonTraceHospital       [index]  );
		          prpLpersonTraceDto.setMotionFlag     (prpLpersonTraceMotionFlag     [index]  );
		          prpLpersonTraceDto.setWoundRemark    (prpLpersonTraceWoundRemark    [index]  );
		          prpLpersonTraceDto.setRemark         (prpLpersonTraceRemark         [index]  );
		          prpLpersonTraceDto.setFlag           (prpLpersonTraceFlag           [index]  );
		          //���뼯��
		          personTraceDtoList.add(prpLpersonTraceDto);
		        }
		        //���������м�����ʧ��λ
		        checkDto.setPrpLpersonTraceDtoList(personTraceDtoList);

		        //�������˶��������Ϣ��������ˣ��ͽ��е���

		         if (personTraceDtoList!=null&&personTraceDtoList.size() >0){
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(0);
		         //��ʾ�Ƿ�ѡ��
		         prpLscheduleItemDto.setSelectSend("1");
		         //��ʾû�е��ȳɶ����
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("����");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         
		         // modify by liyanjie 2005-12-17 start �����˫������,���շ������������,�����Ķ�����������յ�;
		            System.out.println("------ ���Ӷ��� scheduleitem---���� ");
			        System.out.println("------ ���Ӷ��� ---commiFlag:"+commiFlag);
			        /*if(!(commiFlag == null) && "1".equals(commiFlag)){
			        	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
			        }else{
			        	prpLscheduleItemDto.setClaimComCode(user.getScheduleComCode());
			        }*/
			        System.out.println("------ ���Ӷ��� ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
			     //modify by liyanjie 2005-12-17 end
		         scheduleItemDtoList.add(prpLscheduleItemDto);
		         //��ʾ���
		         checkDto.setScheduleItemNote(checkDto.getScheduleItemNote()
		                + prpLscheduleItemDto.getLicenseNo() + "/");
		         
		         }
		      }

		      //��������õı����Ϣ,ȥ������һ��"/"
		        if (checkDto.getScheduleItemNote().length() >1)
		        { String strTemp=checkDto.getScheduleItemNote();
		          strTemp = strTemp.substring(0,strTemp.length()-1) ;
		          checkDto.setScheduleItemNote(strTemp );
		        }
		        
		      //�������ݣ���������ȵ����ݣ�������ύ��ʱ�򡣡����µ����ݷ���prplscheduleItem�У��������Ѿ����ȹ�������
		         //��鶨����ȵ������������ڶ�����ȣ�����Ƿ��Ѿ����ȹ������û�е��ȹ�������û�е��ȹ�����
		         Collection prpLscheduleItemList = new ArrayList();
		         //��ѯ���ȹ���
		         String strSql =" registno ='"+checkDto.getPrpLcheckDto().getRegistNo()+"'";
		         ////System.out.println("***********������������*********policyNo************:"+checkDto.getPrpLcheckDto().getRegistNo());
		         //��ѯ����
		         UIScheduleAction uiScheduleAction=new UIScheduleAction();
		         prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
		         PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
		         ArrayList scheduleItemLastList = new ArrayList();
		         if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
		            //���ü��scheduleITem�ġ���
		            checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
		         }else
		         { //�������õ������У��Ƿ��Ѿ����Ѿ����ȹ�������

		       //      //System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
		           boolean findit=false;
		         	for (int i =0;i<scheduleItemDtoList.size() ;i++)
		           {
		             prpLscheduleItemDto = new PrpLscheduleItemDto();
		             prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
		             //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
		             findit=false;
		              for (int j =0;j<prpLscheduleItemList.size() ;j++)
		             {
		               prpLscheduleItemoldDto= new PrpLscheduleItemDto();
		               prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
		               if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
		               { //������ھɵ����ݣ���Ҫ�þɵ����ݣ���Ҫ���µ�����
		                 prpLscheduleItemDto= prpLscheduleItemoldDto;
		                 findit=true;
		                 break;
		               }
		               //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
		              
			             
		             }
		             
		              //�������ı��
		             if (findit==false)newScheduleItem=true;
		              
		             scheduleItemLastList.add(prpLscheduleItemDto) ;
		           }
		          checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
		         }
		
		          checkDto.setNewScheduleItem( newScheduleItem);
	    
	     //Modify by chenrenda add end 20050408
	      return checkDto;
	    }
	

	
	    /**
	     * ��д�鿱ҳ�漰��ѯ�鿱request������.
	     * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	     * @param httpServletRequest ���ظ�ҳ���request
	     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
	     * @throws Exception
	     */
	    public void registDtoToView(HttpServletRequest httpServletRequest,
	                                          String registNo,String editType) throws Exception
	    {
	      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
	      HttpSession session = httpServletRequest.getSession();
	      UserDto   user     = (UserDto)session.getAttribute("user");
	      UIRegistAction uiRegistAction = new UIRegistAction();
	      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
	      UICheckAction uiCheckAction = new UICheckAction();
	      	
	      CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
	   //   UICheckAction uiCheckAction = new UICheckAction();
	   //   UICodeAction uiCodeAction = new UICodeAction();
	    //  String claimNo=uiCodeAction.translateBusinessCode(registNo,true);
	       String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
	       String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
	      String insureCarFlag=httpServletRequest.getParameter("insureCarFlag"); //�Ƿ�Ϊ����������
	      String lossItemCode=httpServletRequest.getParameter("lossItemCode");   //��ʧ���
	      String lossItemName=httpServletRequest.getParameter("lossItemName");   //��������
	      
	      

	   //�������ֵ�Ļ������¸����渴��

	      //���ݲ�ѯ�������������ݣ���PrpLcheckDto��ֵ
	      PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
	      //������ֵ
	      //prpLcheckDto.setInsureCarFlag(insureCarFlag);
	      prpLcheckDto.setReferSerialNo(1);
	      //prpLcheckDto.setLossItemCode(lossItemCode);
	      //prpLcheckDto.setLossItemName(lossItemName);
	      prpLcheckDto.setRegistNo(registNo);
	      prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto() .getDamageStartDate());
	      prpLcheckDto.setDamageStartHour(registDto.getPrpLregistDto() .getDamageStartHour());
		  prpLcheckDto.setRiskCode(registDto.getPrpLregistDto() .getRiskCode()  );   
	      //���ô�����и�����ѡ�����б���Ϣ������
	      setSelectionList(httpServletRequest,prpLcheckDto);

	      //���ø����ӱ���Ϣ������
	      CheckDto checkDto = new CheckDto();
	      checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList() );
	      checkDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
	      checkDto.setPrpLthirdCarLossDtoList(registDto.getPrpLthirdCarLossDtoList());
 checkDto.setPrpLpersonTraceDtoList(checkDtoTemp.getPrpLpersonTraceDtoList());
	      checkDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
	      checkDto.setPrpLcheckDto( prpLcheckDto);
	      
	      
	      //���ø����ӱ��е���Ϣ����ʾ
	      setSubInfo(httpServletRequest,checkDto);      
	      //���汨���ŵ�ҳ��
	      httpServletRequest.setAttribute("businessNo",registNo);
	      httpServletRequest.setAttribute("prpLregistDto",registDto.getPrpLregistDto() );
	    }
	    
	

	 /**
     * ����PrpCheckDto�еĸ��ӱ��ڵ���Ϣ������
     * @param httpServletRequest ���ظ�ҳ���request
     * @param checkDto    �鿱��������
     * @throws Exception
     */
   private void setSubInfo(HttpServletRequest httpServletRequest,
                          CheckDto checkDto) throws Exception
   {

       //[�永����]�����߳��������б�׼������
       Collection arrayList = new ArrayList();
       PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
       arrayList = checkDto.getPrpLthirdPartyDtoList();
       prpLthirdPartyDto.setThirdPartyList(arrayList) ;
       prpLthirdPartyDto.setNodeType("check");
       httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);



      //Modify by chenrenda add begin 20050408
      //Reason:��ʧ��λģ��ϵ��浽������Ϣ�к�������Ӧģ��������
      //����ʧ��λ���ж����б�׼������

      Collection arrayListThirdCarLoss = new ArrayList();
      PrpLthirdCarLossDto prpLthirdCarLossDto  = new PrpLthirdCarLossDto();
      arrayListThirdCarLoss = checkDto.getPrpLthirdCarLossDtoList();
      prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss) ;
      httpServletRequest.setAttribute("prpLthirdCarLossDto", prpLthirdCarLossDto);

      //Reason:��ʧ��λ��ʾ��Ϊ�б��ʽ
      httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
      //Modify by chenrenda add end 20050408
      
      
      //�¹ʹ���������б�׼������
      ArrayList arrayList2 = new ArrayList();
      PrpLcheckLossDto prpLcheckLossDto  = new PrpLcheckLossDto();
      arrayList2 = checkDto.getPrpLcheckLossDtoList() ;
      if(arrayList2 != null){
        for(int indexCheck = 0;indexCheck<arrayList2.size();indexCheck++){
          PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
          prpLcheckLossDto1 = (PrpLcheckLossDto)arrayList2.get(indexCheck);

         UICodeAction uiCodeAction = new UICodeAction();
         //���ձ����ת��
         String  kindCode = prpLcheckLossDto1.getKindCode();
         String  kindName = uiCodeAction.translateKindCode(checkDto.getPrpLcheckDto().getRiskCode()  ,kindCode,true) ;
         prpLcheckLossDto1.setKindName(kindName);
        }
      }
      prpLcheckLossDto.setPrpLcheckLossList(arrayList2) ;
      httpServletRequest.setAttribute("prpLcheckLossDto", prpLcheckLossDto);
    //    Modify by chenrenda 20050409 end

      
      //����Ա�������ٶ��ж����б�׼������
      Collection arrayListPersonTrace = new ArrayList();
      PrpLpersonTraceDto prpLpersonTraceDto  = new PrpLpersonTraceDto();
      arrayListPersonTrace = checkDto.getPrpLpersonTraceDtoList();
      prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace) ;
     // prpLpersonTraceDto.setNodeType("check");
      //Modify by chenrenda 20050409 begin
      
      if(checkDto.getPrpLpersonTraceDtoList() != null){
      	
      	//System.out.println("���˸��ٲ�Ϊ�գ�"+arrayListPersonTrace.size());
       Iterator personTraceDtoList = arrayListPersonTrace.iterator();
       while(personTraceDtoList.hasNext()){
         PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto)personTraceDtoList.next();
         String strReferKind = prplpersonTraceDto.getReferKind();
         prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
       }
     }
     //Modify by chenrenda 20050409 end
    
      httpServletRequest.setAttribute("prpLpersonTraceDto", prpLpersonTraceDto);
      
      
      //Modify by chenrenda add 20050409 begin
      //Reason:���˸�����Ϣģ�����漰�������б���ѡ��ʽ��ʾ
      //���ձ����Ƹĳ�D1-������Ա�����յķ�ʽ,ֻ�����������복����Ա������
      Collection prpLcheckItemKindNew = new ArrayList();
      ArrayList itemKindList = new ArrayList();
      Collection itemKindListNew = new ArrayList();
      
      String policyNo  = httpServletRequest.getParameter("policyNo");
      //System.out.println("***********������������*********policyNo************:"+policyNo);
      if(!policyNo.equals("")&&policyNo!=null)
      {
      	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
				,checkDto.getPrpLcheckDto().getDamageStartDate().toString()
				,checkDto.getPrpLcheckDto().getDamageStartHour()); 
		
        itemKindList = policyDto.getPrpCitemKindDtoList();
      }
      
      for(int i=0;i<itemKindList.size();i++)
      {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)itemKindList.get(i);
        prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-" + prpCitemKindDto.getKindName()) ;
        if(prpCitemKindDto.getKindCode().equalsIgnoreCase("B")||prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")
           ||prpCitemKindDto.getKindCode().equalsIgnoreCase("D1")||prpCitemKindDto.getKindCode().equalsIgnoreCase("001"))
        {
          itemKindListNew.add(prpCitemKindDto) ;
        }
        prpLcheckItemKindNew.add(prpCitemKindDto);
      }
      httpServletRequest.setAttribute("referKindList",itemKindListNew);
      httpServletRequest.setAttribute("prpLcheckItemKindList",prpLcheckItemKindNew);
      //Modify by chenrenda add 20050409 end
      
      
      
      
      
      
      //Modify by chenrenda add begin 20050412
      //Reason:�ڲ鿱ҳ���м���������ʧģ��
      Collection arrayListThirdProp = new ArrayList();
      PrpLthirdPropDto prpLthirdPropDto  = new PrpLthirdPropDto();
      arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
      prpLthirdPropDto.setThirdPropList(arrayListThirdProp) ;
      //prpLthirdPropDto.setPrpLthirdPropKindCode("B");
      httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);

      //Modify by chenrenda add end 20050412
      
      
    }

   /**
     * ��ȡѡ�����б���е���������
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpLcheckDto    �鿱��������
     * @throws Exception
     */
   private void setSelectionList(HttpServletRequest httpServletRequest,
                          PrpLcheckDto prpLcheckDto) throws Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();

     //�鿱�����б�
     Collection checkNatures = uiCodeAction.getCodeType("CheckNature", prpLcheckDto.getRiskCode() );
     httpServletRequest.setAttribute("checkNatures", checkNatures);
     //�ⰸ���
     Collection caseCodes = uiCodeAction.getCodeType("CaseCode", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("caseCodes", caseCodes);
     //���յص����
     Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddresss", damageAddresss);
     //�¹��⳥����
     Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);

     //�õ�ʵ�������б�
     Collection reportTypes = uiCodeAction.getCodeType("ReportType", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("reportTypes", reportTypes);
     //�õ����������б��б�
     Collection claimTypes = uiCodeAction.getCodeType("CaseCode", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("claimTypes", claimTypes);
     //�õ����յ�ַ�����б�
     Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
     //�õ����������б�
     Collection carKindCodes = uiCodeAction.getCodeType("CarKind", prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("carKindCodes", carKindCodes);
     //�õ����Ƶ�ɫ�б�
     Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
     //�õ��⳥�����б�
     Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("indemnityDutys",indemnityDuty);
     //�õ��ⰸ����б�
     Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("escapeFlags",escapeFlags);
     //�õ��õ��Ա�
     Collection driverSex = uiCodeAction.getCodeType("SexCode",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("driverSexs",driverSex);
     //�õ�ְҵ����
     Collection driverOccupation = uiCodeAction.getCodeType("Occupation",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("driverOccupations",driverOccupation) ;
     //�õ��Ļ��̶�
     Collection education = uiCodeAction.getCodeType("Education",prpLcheckDto.getRiskCode());
     httpServletRequest.setAttribute("educations",education) ;
  }
}
