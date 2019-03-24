package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.action.UserToPrpDuser;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>Title: ScheduleViewHelper</p>
 * <p>Description:�鿱ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 * 
 */
 public class DAAScheduleViewHelper extends ScheduleViewHelper
 {  
   /**
    * Ĭ�Ϲ��췽��
    */
    public DAAScheduleViewHelper()
    {
    }

   /**
    * ����鿱ʱ�鿱ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return scheduleDto �鿱���ݴ������ݽṹ
    * @throws Exception
    */ 
    public ScheduleDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      //�̳ж�schedule,scheduleText��ĸ�ֵ
      ScheduleDto scheduleDto = super.viewToDto(httpServletRequest);

      /*---------------------���ȱ��prpLScheduleItem------------------------------------*/
      /*---------------------�鿱���prpLcheckItem------------------------------------*/

      ArrayList scheduleItemDtoList = new ArrayList();
      PrpLscheduleItemDto prpLscheduleItemDto = null ;
      ArrayList checkItemDtoList = new ArrayList();
      PrpLcheckItemDto prpLcheckItemDto = null ;
      //�ӽ���õ��������� ����shceudleid����Ҫ�Զ���1��
      //String prpLscheduleItemScheduleID           =(String)httpServletRequest.getAttribute("scheduleID"           );
      String prpLscheduleItemScheduleID           =(String)httpServletRequest.getParameter("prpLscheduleItemScheduleID"           );
      String prpLscheduleItemRegistNo             =(String)httpServletRequest.getAttribute("registNo"             );
      String[] prpLscheduleItemItemNo             =httpServletRequest.getParameterValues("prpLscheduleItemItemNo"         );
      String[] prpLscheduleItemInsureCarFlag      =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag"                  );
      
      String[] prpLscheduleItemSelectSend         =httpServletRequest.getParameterValues("prpLscheduleItemSelectSend"     );
      //add by liyanjie 2005-12-12 start ����˫����־λ,�������Ĵ���
      //δ��˫��ǰ,�鿱�붨����Ŀ�ĵ�������Ϊͬһ��,������˫����,����ÿ������ͬ,����Ҫ��������
      String[] prpLscheduleItemClaimComCode         =httpServletRequest.getParameterValues("prpLscheduleItemClaimComCode"  );
      String[] prpLscheduleItemCommiItemFlag         =httpServletRequest.getParameterValues("prpLscheduleItemCommiItemFlag"     );
      //add by liyanjie 2005-12-12 end
      String[] prpLscheduleItemSurveyTimes        =httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes"    );
      String[] prpLscheduleItemSurveyType         =httpServletRequest.getParameterValues("surveyType"     );
      String[] prpLscheduleItemCheckSite          =httpServletRequest.getParameterValues("prpLscheduleItemCheckSite"      );
      String[] prpLscheduleItemLicenseNo          =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo"      );
      String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID"     );
      String[] prpLscheduleItemScheduleObjectName   =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectName"   );

      String[] prpLscheduleItemCommendRepairFactoryCode     =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryCode"     );
      String[] prpLscheduleItemCommendRepairFactoryName   =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryName"   );
	  
      String prpLscheduleMainWFInputDate            =httpServletRequest.getParameter("prpLscheduleMainWFInputDate"            );
      String prpLscheduleMainWFOperatorCode         =httpServletRequest.getParameter("prpLscheduleMainWFOperatorCode"            );

      //Modify by chenrenda add begin 20050415
      //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
      String[] prpLscheduleItemFactoryEstimateLoss          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryEstimateLoss"      );
      String[] prpLscheduleItemFactoryPhone          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryPhone"      );
      String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
      //Modify by chenrenda add end 20050415

      String[] prpLscheduleItemResultInfo         =httpServletRequest.getParameterValues("prpLscheduleItemResultInfo"     );
      String[] prpLscheduleItemBookFlag           =httpServletRequest.getParameterValues("prpLscheduleItemBookFlag"       );
      String[] prpLscheduleItemScheduleType       =httpServletRequest.getParameterValues("prpLscheduleItemScheduleType"   );
      String[] prpLscheduleItemFlag               =httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );
      String[] newHandlerCode=httpServletRequest.getParameterValues("newHandlerCode"           );
      String[] surveyTimes=httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes");//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
      
      String[] prpLscheduleItemInputDate       =httpServletRequest.getParameterValues("prpLscheduleItemInputDate"   );
      String[] prpLscheduleItemOperatorCode         =httpServletRequest.getParameterValues("prpLscheduleItemOperatorCode"            );

      
      int maxRow =Integer.parseInt((String)httpServletRequest.getParameter("maxrow")) ;
      
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

     
     //String[] nextHandleCode==httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );

    //modify by lixiang add 20050311 start
    //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����
    String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //ָ����һ���ڵ�����˴���
    String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //ָ����һ���ڵ����������
    String[] strNextNode=httpServletRequest.getParameterValues("nextNodeNo");               //ָ����һ���ڵ���
    //modify by lixiang add 20050311 end
      
     //����ʱ���ͻ���������Ա���Ͷ��� Beign
     //��ʼ������
     ArrayList sMCComCodeInfoDtoList = new ArrayList();
     //SMCComCodeInfoDto sMCComCodeInfoDto = null ;
     ArrayList sMSendSMListDtoList = new ArrayList();
     //SM_Send_SM_ListDto sM_Send_SM_ListDto = null ;
     ArrayList smcResultDtoList = new ArrayList();
     //SmcResultDto smcResultDto  = null;
    
     String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//ȡ�༭����
     
     String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //�Ƿ�ѡ�и�ѡ��
     String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//�Ƿ񱻵��ȹ�
     //ȡ��ϵ���ֻ�
     String strMobile = StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLossName")); 	
     String strLicenseNo =  StringUtils.rightTrim(httpServletRequest.getParameter("prpLregistLicenseNo"));
     String strLinkerName = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFLinkerName"));
     String strPhoneNumber = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFPhoneNumber"));
     
     // Ϊ�˽�Լ���ͳɱ����������֣������Ž��нش�
     String strRegistNoTemp = "";
 	 if(prpLscheduleItemRegistNo.length()==22){
 		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
 	 }
 	/*
      if (("on".equals(strCheckSmcSend)&&"0".equals(prpLscheduleMainWFScheduleFlag))||("GETBACKEDIT".equals(editType)&&"on".equals(strCheckSmcSend))){
      	
      	String prpLscheduleMainWFNextHandlerName=StringUtils.rightTrim(httpServletRequest.getParameter("nextHandlerName1"));
        String prpLscheduleMainWFNextHandlerCode=StringUtils.rightTrim(httpServletRequest.getParameter("nextHandlerCode1"));
      
        //BLEdaUserFacade blEdaUserFacade = new BLEdaUserFacade();
        //����������ĵ��û�����
        //PrpDuserDto prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(prpLscheduleMainWFNextHandlerCode);
        
        //ȡ�鿱��Ա�ֻ�
        String strCheckMobile = "";
        if(prpDuserDto!=null){
          strCheckMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
        }
        if(!strCheckMobile.equals("")){
        	//ȡ�鿱�ص�͵�����Ϣ
            String strCheckSite = StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFCheckSite"));
            String strCheckInfo =  StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFCheckInfo"));
        	
        	String strContent = "�鿱"+strRegistNoTemp+","+strLicenseNo+","
			                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
        	
        	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
     		sM_Send_SM_ListDto.setServiceID("claim");
         	sM_Send_SM_ListDto.setSMContent(strContent);
         	sM_Send_SM_ListDto.setSendTarget(strCheckMobile);//Ŀ���ֻ���
         	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
         	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
         	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
         	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
         	sM_Send_SM_ListDto.setFeeValue(0);
         	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
         	
//         	��ҵ�������Ϣ
         	sMCComCodeInfoDto = new SMCComCodeInfoDto();
         	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
         	sMCComCodeInfoDto.setComCode(user.getComCode());
         	sMCComCodeInfoDto.setFlag("");
         	//sMCComCodeInfoDto.setLineNo("");
         	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
         	sMCComCodeInfoDto.setRemark("");
         	//sMCComCodeInfoDto.setReplyDate();
         	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         	sMCComCodeInfoDto.setTextType("1");
         	sMCComCodeInfoDto.setValidStatus("1");
         	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto); 	
         	
         	
         	if(!strMobile.equals("")){
         		
         		String strCheckContent = "�𾴵Ŀͻ������ı�������Ϊ"+strRegistNoTemp+";���ǵĲ鿱��Ա"+prpLscheduleMainWFNextHandlerName+"("+strCheckMobile+")���ڸ����������Ժ�;"
        		                        +"��ر���95590";
         		sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
         		sM_Send_SM_ListDto.setServiceID("claim");
             	sM_Send_SM_ListDto.setSMContent(strCheckContent);
             	sM_Send_SM_ListDto.setSendTarget(strMobile);//Ŀ���ֻ���
             	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
             	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
             	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
             	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
             	sM_Send_SM_ListDto.setFeeValue(0);
             	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
             	
                //��ҵ�������Ϣ
             	sMCComCodeInfoDto = new SMCComCodeInfoDto();
             	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
             	sMCComCodeInfoDto.setComCode(user.getComCode());
             	sMCComCodeInfoDto.setFlag("");
             	//sMCComCodeInfoDto.setLineNo("");
             	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
             	sMCComCodeInfoDto.setRemark("");
             	//sMCComCodeInfoDto.setReplyDate();
             	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
             	sMCComCodeInfoDto.setTextType("0");
             	sMCComCodeInfoDto.setValidStatus("1");
             	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);
         	}

         	
        }else{
         smcResultDto = new SmcResultDto();
         smcResultDto.setUserCode(prpLscheduleMainWFNextHandlerCode);
         smcResultDto.setUserName(prpLscheduleMainWFNextHandlerName);
         smcResultDto.setSmcType("�鿱��Ա");
         smcResultDtoList.add(smcResultDto);
        }
      }
      */
      
      
      //����ʱ���ͻ���������Ա���Ͷ��� end
      //����ֵ
      //���ȱ�Ĳ��ֿ�ʼ
      //��������Ȳ��ֵı������
      //BLEdaUserFacade blEdaUserFacade = new BLEdaUserFacade();
      PrpDuserDto prpDuserDto = null;
      for(int index=0;index<maxRow;index++)
      {
          prpLscheduleItemDto = new PrpLscheduleItemDto();
          prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
          prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
          prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo[index]));
          prpLscheduleItemDto.setInsureCarFlag      (prpLscheduleItemInsureCarFlag     [index]);
          
          prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode[index]   );
           //��ʾ�Ƿ�ѡ��
          prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend        [index]);
//        20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
          //���ѡ�еĻ���surveyTimes=1
          prpLscheduleItemDto.setSurveyTimes        (0);
          
          //��������Ա���ͻ����Ͷ��� begin
          String strSelectSend = prpLscheduleItemSelectSend [index];           //�Ƿ�ѡ��
          String strInsureCarFlag = prpLscheduleItemInsureCarFlag     [index]; //�Ƿ񱾱�������
          String strSurveyTimes = surveyTimes[index];//�Ƿ񱻵��ȹ�
          String[] strScheduleSmcSend  =httpServletRequest.getParameterValues("prpLCheckSelectSend");
          String txtScheduleSmcSend = strScheduleSmcSend[index];
          /*
          if(("1".equals(txtScheduleSmcSend)&&"0".equals(strSurveyTimes))||( "GETBACKEDIT".equals(editType)&&"1".equals(txtScheduleSmcSend))){
          	 
          	 //��ĳ������ͻ���������Ա���Ͷ���
          	 if("1".equals(strInsureCarFlag)){
          	 	String strHandlerName=StringUtils.rightTrim(nextHandlerName[index]);
                String strHandlerCode=StringUtils.rightTrim(nextHandlerCode[index]);
               
            	prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(strHandlerCode);
                //ȡ������Ա�ֻ�
                String strCertaMobile = "";
                if(prpDuserDto!=null){
                  strCertaMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
                }
                if(!strCertaMobile.equals("")){
                    strLicenseNo =  prpLscheduleItemLicenseNo [index];
                	String strCheckSite = prpLscheduleItemCheckSite [index];
                	
                	String strContent = "��������"+strRegistNoTemp+","+strLicenseNo+","
                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
                	
                	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
             		sM_Send_SM_ListDto.setServiceID("claim");
                 	sM_Send_SM_ListDto.setSMContent(strContent);
                 	sM_Send_SM_ListDto.setSendTarget(strCertaMobile);//Ŀ���ֻ���
                 	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                 	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                 	sM_Send_SM_ListDto.setFeeValue(0);
                 	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                    
                 	//��ҵ�������Ϣ
                 	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                 	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                 	sMCComCodeInfoDto.setComCode(user.getComCode());
                 	sMCComCodeInfoDto.setFlag("");
                 	//sMCComCodeInfoDto.setLineNo("");
                 	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                 	sMCComCodeInfoDto.setRemark("");
                 	//sMCComCodeInfoDto.setReplyDate();
                 	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                 	sMCComCodeInfoDto.setTextType("1");
                 	sMCComCodeInfoDto.setValidStatus("1");
                 	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);  	
                 	
                 	
                 	 //��ĳ���Ҫ���ͻ����Ͷ���
                    if(!strMobile.equals("")){
                 		
                 		String strCustomContent = "�𾴵Ŀͻ������ı�������Ϊ"+strRegistNoTemp+";���ǵĶ�����Ա"+strHandlerName+"("+strCertaMobile+")���ڸ����������Ժ�;"
                        +"��ر���95590";
                    	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
                 		sM_Send_SM_ListDto.setServiceID("claim");
                     	sM_Send_SM_ListDto.setSMContent(strCustomContent);
                     	sM_Send_SM_ListDto.setSendTarget(strMobile);//Ŀ���ֻ���
                     	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                     	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                     	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                     	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                     	sM_Send_SM_ListDto.setFeeValue(0);
                     	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                        
                     	//��ҵ�������Ϣ
                     	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                     	
                     	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                     	sMCComCodeInfoDto.setComCode(user.getComCode());
                     	sMCComCodeInfoDto.setFlag("");
                     	//sMCComCodeInfoDto.setLineNo("");
                     	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                     	sMCComCodeInfoDto.setRemark("");
                     	//sMCComCodeInfoDto.setReplyDate();
                     	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                     	sMCComCodeInfoDto.setTextType("0");
                     	sMCComCodeInfoDto.setValidStatus("1");
                     	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);
                 	}
                    
                    
                }else{
                    smcResultDto = new SmcResultDto();
                    smcResultDto.setUserCode(strHandlerCode);
                    smcResultDto.setUserName(strHandlerName);
                    smcResultDto.setSmcType("��ĳ�������Ա");
                    smcResultDtoList.add(smcResultDto);
                   }
             }else{
             	
                //���߳������ˡ��Ʋ�ʱֻ���Ͷ�����Ա
              	String strHandlerName=StringUtils.rightTrim(nextHandlerName[index]);
                String strHandlerCode=StringUtils.rightTrim(nextHandlerCode[index]);
                String strItemNo = StringUtils.rightTrim(prpLscheduleItemItemNo[index]);
                prpDuserDto = blEdaUserFacade.findPrpDUserByPrimaryKey(strHandlerCode);
                String strCertaMobile = "";
                String strType = "";
                if(prpDuserDto!=null){
                	strCertaMobile = StringUtils.rightTrim(prpDuserDto.getMobile());
                }
            	int intItemNo = Integer.parseInt(strItemNo);
            	if(intItemNo>1){
            		strType = "���߳�����";	
            		strLicenseNo =  prpLscheduleItemLicenseNo [index];
            	}else if(intItemNo==0){
            		strType = "���˶���";	
            	}else{
            		strType = "�Ʋ�����";	
            	}
                if(!strCertaMobile.equals("")){
                 
                	String strCheckSite = prpLscheduleItemCheckSite [index];
                	
                     
                	String strContent = strType+strRegistNoTemp+","+strLicenseNo+","
                    +strLinkerName+strPhoneNumber+" "+strMobile+","+strCheckSite;
                	
                    
                	sM_Send_SM_ListDto = new SM_Send_SM_ListDto();
             		sM_Send_SM_ListDto.setServiceID("claim");
                 	sM_Send_SM_ListDto.setSMContent(strContent);
                 	sM_Send_SM_ListDto.setSendTarget(strCertaMobile);//Ŀ���ֻ���
                 	sM_Send_SM_ListDto.setRCompleteTimeBegin(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteTimeEnd(DateTime.current().toString());
                 	sM_Send_SM_ListDto.setRCompleteHourBegin(0);
                 	sM_Send_SM_ListDto.setRCompleteHourEnd(1439);
                 	sM_Send_SM_ListDto.setFeeValue(0);
                 	sMSendSMListDtoList.add(sM_Send_SM_ListDto);
                    
                 	//��ҵ�������Ϣ
                 	sMCComCodeInfoDto = new SMCComCodeInfoDto();
                 	sMCComCodeInfoDto.setBusinessno(prpLscheduleItemRegistNo);
                 	sMCComCodeInfoDto.setComCode(user.getComCode());
                 	sMCComCodeInfoDto.setFlag("");
                 	//sMCComCodeInfoDto.setLineNo("");
                 	sMCComCodeInfoDto.setOperatorCode(user.getUserCode());
                 	sMCComCodeInfoDto.setRemark("");
                 	//sMCComCodeInfoDto.setReplyDate();
                 	sMCComCodeInfoDto.setSendDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
                 	sMCComCodeInfoDto.setTextType("1");
                 	sMCComCodeInfoDto.setValidStatus("1");
                 	sMCComCodeInfoDtoList.add(sMCComCodeInfoDto);  	
                }else{
                    smcResultDto = new SmcResultDto();
                    smcResultDto.setUserCode(strHandlerCode);
                    smcResultDto.setUserName(strHandlerName);
                    smcResultDto.setSmcType(strType);
                    smcResultDtoList.add(smcResultDto);
                   }
             } 
          }
          
        */
          //��������Ա���Ͷ���  end
          
          //�ж��ǲ��ǽ������µĵ���ѡ���ж�
          //add by lixiang start at 2005-8-17
          //reason:���ȴ�������ǲ�һ���ģ���Ҫ����ԭ������
          prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
          //�Ѿ����ȹ������ڴ���
          if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("1")  )
          {
          	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
          	 if(prpLscheduleItemInputDate[index]!=null&&prpLscheduleItemInputDate[index].length()==10){
          	  prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleItemInputDate[index],DateTime.YEAR_TO_DAY ));
              	
          	 }
          	prpLscheduleItemDto.setOperatorCode(prpLscheduleItemOperatorCode[index]);
          }
          if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("0")  )
          {
          	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
          	prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ) );
          	
          }
          
          //add by lixiang end at 2005-8-17
           
          if (prpLscheduleItemDto.getSelectSend().equals("1")){
            prpLscheduleItemDto.setSurveyTimes(1);
          }
       
          prpLscheduleItemDto.setSurveyType         (prpLscheduleItemSurveyType        [index]);
          prpLscheduleItemDto.setCheckSite          (prpLscheduleItemCheckSite         [index]);

          //Modify by chenrenda add begin 20050415
          //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
          prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss      [index])));
          prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone[index]);
          prpLscheduleItemDto.setExigenceGree(exigenceGree[index]);
		  //Modify by chenrenda add end 20050415
          prpLscheduleItemDto.setLicenseNo          (prpLscheduleItemLicenseNo         [index]);

          if (prpLscheduleItemScheduleObjectID [index].trim().length() <1) prpLscheduleItemScheduleObjectID [index]="_";
          prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID [index]);
          prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName[index]);

          
          prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo        [index]);
          prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag          [index]);
          prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType      [index]);

          prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag              [index]);
//modify by lixiang add 20050311 start
//reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����,Ŀǰ���
          prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
          prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
          prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
          
          prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName [index]);
         // if (!newHandlerCode[index].equals("")&&newHandlerCode[index].length() >0 ){
            //���������޸ĵ�����
         //   scheduleDto.getPrpLscheduleMainWFDto().setNewHandlerCode(newHandlerCode[index]) ;
       //   };
//modify by lixiang add 20050311 end
          
         /* if (!"".equals( scheduleDto.getPrpLscheduleMainWFDto().getCheckFlag()) ){
          	prpLscheduleItemDto.setScheduleStatus( scheduleDto.getPrpLscheduleMainWFDto().getCheckFlag());
          }*/
          //������ȱ�ļ���
          scheduleItemDtoList.add(prpLscheduleItemDto);
      }
      //���ȼ����мӵ��ȱ��
      scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
      // ���ȼ����мӲ鿱���
      //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
      
      //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ begin
      
      scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
      scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
      
      httpServletRequest.setAttribute("smcResultDtoList",smcResultDtoList);
      //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ end
    

      /*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
           ArrayList prpLregistExtDtoList = new ArrayList();
           PrpLregistExtDto prpLregistExtDto = null ;
           //�ӽ���õ���������
           String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
           String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
           String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
           String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
           String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
           String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
           String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

           //����ֵ
           //������չ��Ϣ ���ֿ�ʼ
           if (prpLregistExtSerialNo==null)
           {}
           else
           {
           
             for(int index=1;index<prpLregistExtSerialNo.length;index++)
             {
                prpLregistExtDto = new PrpLregistExtDto();
               prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
               prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
               prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
               prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
               prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
               prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
               prpLregistExtDto.setContext(prpLregistExtContext[index]);
               //���뼯��
               prpLregistExtDtoList.add(prpLregistExtDto);
             }
             //���������м�����ʧ��λ
             scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
           }

      return scheduleDto;
    }
    /**
     * ����鿱ʱ�鿱ҳ����������.
     * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
     * @param httpServletRequest
     * @return scheduleDto �鿱���ݴ������ݽṹ
     * @throws Exception
     */ 
     public ScheduleDto viewToDtoNew_One(
    		  String prpLscheduleItemScheduleID
    		 ,String registNo
    		 ,String []prpLscheduleItemItemNo
    		 ,String []prpLscheduleItemSelectSend
    		 ,String []prpLscheduleItemClaimComCode
    		 ,String []prpLscheduleItemCommiItemFlag
    		 ,String []prpLscheduleItemSurveyTimes
    		 ,String []surveyType
    		 ,String []prpLscheduleItemCheckSite
    		 ,String []prpLscheduleItemScheduleObjectID
    		 ,String []prpLscheduleItemScheduleObjectName
    		 ,String []prpLscheduleItemCommendRepairFactoryName
    		 ,String prpLscheduleMainWFInputDate
    		 ,String prpLscheduleMainWFOperatorCode
    		 ,String []prpLscheduleItemFactoryEstimateLoss
    		 ,String []prpLscheduleItemFactoryPhone
    		 ,String []exigenceGree
    		 ,String []prpLscheduleItemResultInfo
    		 ,String []prpLscheduleItemBookFlag
    		 ,String []prpLscheduleItemScheduleType
    		 ,String []prpLscheduleItemFlag
    		 ,String []newHandlerCode
    		 ,String []prpLscheduleItemInputDate
    		 ,String []prpLscheduleItemOperatorCode
    		 ,String  maxrow
    		 ,String []nextHandlerCode      //ָ����һ���ڵ�����˴���
    	     ,String []nextHandlerName     	//ָ����һ���ڵ����������
    	     ,String []nextNodeNo           //ָ����һ���ڵ��� 
    	     ,UserDto   user
    	     ,String saveType
    	     ,String txtCheckSmcSend
    	     ,String prpLscheduleMainWFScheduleFlag
    	     ,String prpLregistLossName	
    	     ,String prpLregistLicenseNo
    	     ,String prpLscheduleMainWFLinkerName
    	     ,String prpLscheduleMainWFPhoneNumber
    	     ,String []prpLCheckSelectSend
    	     ,String prpLregistExtRegistNo
             ,String prpLregistExtRiskCode
             ,String []prpLregistExtSerialNo
             ,String []prpLregistExtInputDate
             ,String []prpLregistExtInputHour
             ,String []prpLregistExtOperatorCode
             ,String []prpLregistExtContext

     		,String prpLscheduleMainWFScheduleID
     		,String prpLscheduleMainWFRegistNo
     		,String prpLscheduleMainWFCheckClaimComCode
     		,String prpLscheduleMainWFRiskCode
     		,String flag
     		,String prpLscheduleMainWFPolicyNo
     		,String prpLscheduleMainWFScheduleObjectID
     		,String prpLscheduleMainWFCheckSite
     		,String prpLscheduleMainWFScheduleObjectName
     		,String prpLscheduleMainWFCheckInfo
     		,String nextHandlerCode1
     		,String nextHandlerName1
     		,String nextNodeNo1
     		,String prpLscheduleMainWFScheduleType
     		,String checkCommiItemFlag
     		,String prpLscheduleMainWFDtoCommiFlag
     		,String checkSelectSend
    		 ) throws Exception
     {
       //�̳ж�schedule,scheduleText��ĸ�ֵ1

       ScheduleDto scheduleDto = null;

       /*---------------------���ȱ��prpLScheduleItem------------------------------------*/
       /*---------------------�鿱���prpLcheckItem------------------------------------*/

       ArrayList scheduleItemDtoList = new ArrayList();
       PrpLscheduleItemDto prpLscheduleItemDto = null ;
       ArrayList checkItemDtoList = new ArrayList();
       PrpLcheckItemDto prpLcheckItemDto = null ;
       //�ӽ���õ��������� ����shceudleid����Ҫ�Զ���1��
       //String prpLscheduleItemScheduleID         =(String)httpServletRequest.getAttribute("scheduleID"           );
       //String prpLscheduleItemScheduleID           =prpLscheduleItemScheduleID
       	 String prpLscheduleItemRegistNo             =registNo;
       //String[] prpLscheduleItemItemNo             =httpServletRequest.getParameterValues("prpLscheduleItemItemNo"         );
       //String[] prpLscheduleItemInsureCarFlag      =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag"                  );
       
       //String[] prpLscheduleItemSelectSend         =httpServletRequest.getParameterValues("prpLscheduleItemSelectSend"     );
       //add by liyanjie 2005-12-12 start ����˫����־λ,�������Ĵ���
       //δ��˫��ǰ,�鿱�붨����Ŀ�ĵ�������Ϊͬһ��,������˫����,����ÿ������ͬ,����Ҫ��������
       //String[] prpLscheduleItemClaimComCode         =httpServletRequest.getParameterValues("prpLscheduleItemClaimComCode"  );
       //String[] prpLscheduleItemCommiItemFlag         =httpServletRequest.getParameterValues("prpLscheduleItemCommiItemFlag"     );
       //add by liyanjie 2005-12-12 end
       //String[] prpLscheduleItemSurveyTimes        =httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes"    );
       String[] prpLscheduleItemSurveyType         =surveyType;
       //String[] prpLscheduleItemCheckSite          =httpServletRequest.getParameterValues("prpLscheduleItemCheckSite"      );
       //String[] prpLscheduleItemLicenseNo          =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo"      );
       //String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID"     );
       //String[] prpLscheduleItemScheduleObjectName   =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectName"   );

       //String[] prpLscheduleItemCommendRepairFactoryCode     =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryCode"     );
       //String[] prpLscheduleItemCommendRepairFactoryName   =httpServletRequest.getParameterValues("prpLscheduleItemCommendRepairFactoryName"   );
 	  
       //String prpLscheduleMainWFInputDate            =httpServletRequest.getParameter("prpLscheduleMainWFInputDate"            );
       //String prpLscheduleMainWFOperatorCode         =httpServletRequest.getParameter("prpLscheduleMainWFOperatorCode"            );

       //Modify by chenrenda add begin 20050415
       //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
       //String[] prpLscheduleItemFactoryEstimateLoss          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryEstimateLoss"      );
       //String[] prpLscheduleItemFactoryPhone          =httpServletRequest.getParameterValues("prpLscheduleItemFactoryPhone"      );
       //String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
       //Modify by chenrenda add end 20050415

       //String[] prpLscheduleItemResultInfo         =httpServletRequest.getParameterValues("prpLscheduleItemResultInfo"     );
       //String[] prpLscheduleItemBookFlag           =httpServletRequest.getParameterValues("prpLscheduleItemBookFlag"       );
       //String[] prpLscheduleItemScheduleType       =httpServletRequest.getParameterValues("prpLscheduleItemScheduleType"   );
       //String[] prpLscheduleItemFlag               =httpServletRequest.getParameterValues("prpLscheduleItemFlag"           );
       //String[] newHandlerCode=httpServletRequest.getParameterValues("newHandlerCode"           );
         String[] surveyTimes=prpLscheduleItemSurveyTimes;//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
       
       //String[] prpLscheduleItemInputDate       =httpServletRequest.getParameterValues("prpLscheduleItemInputDate"   );
       //String[] prpLscheduleItemOperatorCode    =httpServletRequest.getParameterValues("prpLscheduleItemOperatorCode"            );

       
       int maxRow =Integer.parseInt(maxrow) ;
       
//       HttpSession session = httpServletRequest.getSession();
//       UserDto   user     = (UserDto)session.getAttribute("user");

      

     //modify by lixiang add 20050311 start
     //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����
//     String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //ָ����һ���ڵ�����˴���
//     String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //ָ����һ���ڵ����������
       String[] strNextNode=nextNodeNo;               //ָ����һ���ڵ���
     //modify by lixiang add 20050311 end
       
      //����ʱ���ͻ���������Ա���Ͷ��� Beign
      //��ʼ������
      ArrayList sMCComCodeInfoDtoList = new ArrayList();
      ArrayList sMSendSMListDtoList = new ArrayList();
      ArrayList smcResultDtoList = new ArrayList();
     
      //String editType=StringUtils.rightTrim(httpServletRequest.getParameter("saveType"));//ȡ�༭����
      
      //String  strCheckSmcSend  = StringUtils.rightTrim(httpServletRequest.getParameter("txtCheckSmcSend")); //�Ƿ�ѡ�и�ѡ��
      //String  prpLscheduleMainWFScheduleFlag=StringUtils.rightTrim(httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag"));//�Ƿ񱻵��ȹ�
      //ȡ��ϵ���ֻ�
      String strMobile = StringUtils.rightTrim(prpLregistLossName); 	
      String strLicenseNo =  StringUtils.rightTrim(prpLregistLicenseNo);
      String strLinkerName = StringUtils.rightTrim(prpLscheduleMainWFLinkerName);
      String strPhoneNumber = StringUtils.rightTrim(prpLscheduleMainWFPhoneNumber);
      
      // Ϊ�˽�Լ���ͳɱ����������֣������Ž��нش�
      String strRegistNoTemp = "";
  	 if(prpLscheduleItemRegistNo.length()==22){
  		strRegistNoTemp = prpLscheduleItemRegistNo.substring(3,8)+prpLscheduleItemRegistNo.substring(16);
  	 }
                
       //����ʱ���ͻ���������Ա���Ͷ��� end
       //����ֵ
       //���ȱ�Ĳ��ֿ�ʼ
       //��������Ȳ��ֵı������
       PrpDuserDto prpDuserDto = null;
       for(int index=0;index<maxRow;index++)
       {
           prpLscheduleItemDto = new PrpLscheduleItemDto();
           prpLscheduleItemDto.setScheduleID         (Integer.parseInt(prpLscheduleItemScheduleID) );
           prpLscheduleItemDto.setRegistNo           (prpLscheduleItemRegistNo     );
           prpLscheduleItemDto.setItemNo             (Integer.parseInt(prpLscheduleItemItemNo[index]));
          // prpLscheduleItemDto.setInsureCarFlag      (prpLscheduleItemInsureCarFlag     [index]);
           
           prpLscheduleItemDto.setClaimComCode       (prpLscheduleItemClaimComCode[index]   );
            //��ʾ�Ƿ�ѡ��
           prpLscheduleItemDto.setSelectSend         (prpLscheduleItemSelectSend        [index]);
//         20060807prpLscheduleItemDto.setCommiItemFlag      (prpLscheduleItemCommiItemFlag[index] );  //add by ilyanjie 2005-12-12
           //���ѡ�еĻ���surveyTimes=1
           prpLscheduleItemDto.setSurveyTimes        (0);
           
           //��������Ա���ͻ����Ͷ��� begin
           String strSelectSend = prpLscheduleItemSelectSend [index];           //�Ƿ�ѡ��
           //String strInsureCarFlag = prpLscheduleItemInsureCarFlag     [index]; //�Ƿ񱾱�������
           String strSurveyTimes = surveyTimes[index];//�Ƿ񱻵��ȹ�
           String[] strScheduleSmcSend  =prpLCheckSelectSend;
           String txtScheduleSmcSend = strScheduleSmcSend[index];
           
           //�ж��ǲ��ǽ������µĵ���ѡ���ж�
           //add by lixiang start at 2005-8-17
           //reason:���ȴ�������ǲ�һ���ģ���Ҫ����ԭ������
           prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ));
           //�Ѿ����ȹ������ڴ���
           if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("1")  )
           {
           	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
           	 if(prpLscheduleItemInputDate[index]!=null&&prpLscheduleItemInputDate[index].length()==10){
           	  prpLscheduleItemDto.setInputDate          (new DateTime(prpLscheduleItemInputDate[index],DateTime.YEAR_TO_DAY ));
               	
           	 }
           	prpLscheduleItemDto.setOperatorCode(prpLscheduleItemOperatorCode[index]);
           }
           if (prpLscheduleItemDto.getSelectSend().equals("1")&&surveyTimes[index].equals("0")  )
           {
           	prpLscheduleItemDto.setOperatorCode(user.getUserCode() );
           	prpLscheduleItemDto.setInputDate(new DateTime(prpLscheduleMainWFInputDate,DateTime.YEAR_TO_DAY ) );
           	
           }
           
           //add by lixiang end at 2005-8-17
            
           if (prpLscheduleItemDto.getSelectSend().equals("1")){
             prpLscheduleItemDto.setSurveyTimes(1);
           }
        
           prpLscheduleItemDto.setSurveyType         (prpLscheduleItemSurveyType        [index]);
           prpLscheduleItemDto.setCheckSite          (prpLscheduleItemCheckSite         [index]);

           //Modify by chenrenda add begin 20050415
           //Reason:�ڶ������ҳ�����������������������ϵ�绰������λ��־λ
           prpLscheduleItemDto.setFactoryEstimateLoss( Double.parseDouble(DataUtils.nullToZero(prpLscheduleItemFactoryEstimateLoss      [index])));
           prpLscheduleItemDto.setFactoryPhone(prpLscheduleItemFactoryPhone[index]);
           prpLscheduleItemDto.setExigenceGree(exigenceGree[index]);
 		  //Modify by chenrenda add end 20050415
          // prpLscheduleItemDto.setLicenseNo          (prpLscheduleItemLicenseNo         [index]);

           if (prpLscheduleItemScheduleObjectID [index].trim().length() <1) prpLscheduleItemScheduleObjectID [index]="_";
           prpLscheduleItemDto.setScheduleObjectID   (prpLscheduleItemScheduleObjectID [index]);
           prpLscheduleItemDto.setScheduleObjectName (prpLscheduleItemScheduleObjectName[index]);

           
           prpLscheduleItemDto.setResultInfo         (prpLscheduleItemResultInfo        [index]);
           prpLscheduleItemDto.setBookFlag           (prpLscheduleItemBookFlag          [index]);
           prpLscheduleItemDto.setScheduleType       (prpLscheduleItemScheduleType      [index]);

           prpLscheduleItemDto.setFlag               (prpLscheduleItemFlag              [index]);
 //modify by lixiang add 20050311 start
 //reason:���ȱ����ύ����һ���ڵ����Ա�ͽڵ�����,Ŀǰ���
           prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
           prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
           prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
           
           prpLscheduleItemDto.setCommendRepairFactoryName(prpLscheduleItemCommendRepairFactoryName [index]);
           //������ȱ�ļ���
           scheduleItemDtoList.add(prpLscheduleItemDto);
       }
       //���ȼ����мӵ��ȱ��
       	   scheduleDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
       // ���ȼ����мӲ鿱���
       //scheduleDto.setPrpLcheckItemDtoList(checkItemDtoList);
       
       //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ begin
       
       	   scheduleDto.setSmSendSMListDtoList(sMSendSMListDtoList);
       	   scheduleDto.setSmcComCodeInfoDtoList(sMCComCodeInfoDtoList);
       
       //httpServletRequest.setAttribute("smcResultDtoList",smcResultDtoList);
       //���Ͷ���ʱ�鿱���߶�����Աû���ֻ�����ʱ��������ʾ end
     

       /*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
            ArrayList prpLregistExtDtoList = new ArrayList();
            PrpLregistExtDto prpLregistExtDto = null ;
            //�ӽ���õ���������
//            String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo");
//            String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
//            String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
//            String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
//            String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
//            String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
//            String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

            //����ֵ
            //������չ��Ϣ ���ֿ�ʼ
            if (prpLregistExtSerialNo==null)
            {}
            else
            {
              for(int index=1;index<prpLregistExtSerialNo.length;index++)
              {
                 prpLregistExtDto = new PrpLregistExtDto();
                prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
                prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
                prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
                prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
                prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
                prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
                prpLregistExtDto.setContext(prpLregistExtContext[index]);
                //���뼯��
                prpLregistExtDtoList.add(prpLregistExtDto);
              }
              //���������м�����ʧ��λ
              scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
            }

       return scheduleDto;
     }
     
   /**
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д�鿱��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */
   public ScheduleDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
   {
      ScheduleDto scheduleDto = new ScheduleDto();
      return scheduleDto;

   }

   /**
    * ��д�鿱ҳ�漰��ѯ�鿱request������.
    * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public void dtoToView(HttpServletRequest httpServletRequest, ScheduleDto scheduleDto) throws Exception
    {
      //�õ�request��PrpLsheduleForm������ʾ
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();

      httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
      //�õ�request��prpscheduleItemForm ������ʾ
      PrpLscheduleItemDto prpLscheduleItemDto =new PrpLscheduleItemDto();
      prpLscheduleItemDto.setScheduleItemList( scheduleDto.getPrpLscheduleItemDtoList())  ;
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }

    public void scheduleDtoToView(HttpServletRequest httpServletRequest,String registNo,String editType,String scheduleID) throws Exception
    {
    
   
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      //add by zhaolu 20060816 start
      //reasonȨ���ж�
      if(!"SHOW".equals(editType)){
    	  UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_SCHEDULE_QUERY);
      }
      //add by zhaolu 20060816 end
      int intscheduleID= Integer.parseInt(scheduleID);

      //Modify by wangwei add start 2006-02-16
      //Reason��������������Ҫ���ݲ�ͬ��������ʾһ�����˰�ť(�Ѱ��������ڴ����Ϊ������)��
      String handlerCode = httpServletRequest.getParameter("handlerCode");
      String flagBit = "false";
      if ("EDIT".equals(editType) && !user.getUserCode().equals(handlerCode)) {
          flagBit = "false";
      } else {
      	  flagBit = "true"; 
      }
      httpServletRequest.setAttribute("schedule.flag", flagBit);
      //Modify by wangwei add end 2006-02-16
      
      UIScheduleAction uiScheduleAction = new UIScheduleAction();
      ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(intscheduleID,registNo);

      //���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
      PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto() ;

      UIRegistAction uiRegistAction = new UIRegistAction();
      RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
	  //reason ǿ�Ʊ���������Ϣд��������
      httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
      //add by zhaolu end at 2006-06-10
		
      //modify by wangli add start 20050416
      //��������˴��뼰����
      String policyNo = httpServletRequest.getParameter("policyNo");
      //��ѯ������Ϣ
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      UICodeAction uiCodeAction = new UICodeAction();
      
      //����鲻����ô�죿 д����Ҫע���
      String agentCode="";
      
      if (policyDto.getPrpCmainDto()!=null){
         agentCode = policyDto.getPrpCmainDto().getAgentCode();         //�����˴���
      }

      if (agentCode==null) agentCode="";
      
      prpLscheduleMainWFDto.setAgentCode(agentCode);
      prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));//�õ�����������
    
      // modify by wangli add start 20050416
      PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
      prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto.getReportHour()));
      prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(3,5));
      prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,2));
      prpLregistDto.setDamageStartHour(StringConvert.toStandardTime(prpLregistDto.getDamageStartHour()));
      prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour().substring(3,5));
      prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour().substring(0,2));
      httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
      //���Ͷ��� begin
     
      //���Ͷ��� end
      
      //������չ����
      prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName()  ) ;
      prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()  ) ;
      if(user != null){
    	  prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
      }
      prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto() .getLicenseNo() );
      //add by lixiang start at 2005-8-9
      //���ӵ��ȱ�����
      
      prpLscheduleMainWFDto.setEstimateLoss( registDto.getPrpLregistDto() .getEstimateLoss() );
	  //add by lixiang end at 2005-8-9
      if ("_".equals(prpLscheduleMainWFDto.getScheduleObjectID())){
      	prpLscheduleMainWFDto.setScheduleObjectID("");
      }
      //���õ�����ʲô���͵ı���,������ȡ�����͵�
      
      prpLscheduleMainWFDto.setSaveType(editType);

           
       //�������ļ������б�׼������
      PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
      String tempContext = "";
      if(registDto.getPrpLregistTextDtoList() != null){
        Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
        while(iterator.hasNext()){
          PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
          if(StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1"))
          {
    				prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+prpLregistTextDtoTemp.getContext() );
    		}
        }
      } 
       //prpLscheduleMainWFDto.setRegistText(tempContext);
    
    

      //���ò鿱������״̬Ϊ �����޸� (����������)
      if (scheduleDto.getPrpLclaimStatusDto()!=null ) {
       if (scheduleDto.getPrpLclaimStatusDto().getStatus().equals("7")) {
           scheduleDto.getPrpLclaimStatusDto().setStatus("3");
       }
       prpLscheduleMainWFDto.setStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
      } else {
        //���ύ���Ѿ�������ϵ�״̬
       prpLscheduleMainWFDto.setStatus("4");
      }
      
      //add by liyanjie 2005-12-10 start �ж�claimcomcode�ǲ��Ǳ����ȹ�˾,���ǵľ���Ȩ���Ȳ鿱����
      //��Ҫ�ж�ClaimComCodeΪ�յ����
      String nodeType = (String)httpServletRequest.getParameter("nodeType");
	  String riskCode = httpServletRequest.getParameter("riskCode");
	  String riskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);

      if(!"SHOW".equals(editType)){
    	  if("D".equals(riskType)){
    	    	//�жϱ������Ƿ������ˡ��Ʋ�����ĵ��ձ𡣵���ʱ����һ�¼�����ʶ��ʾ��Ϣ
    	    	PrpCitemKindDto prpCitemKindDto = null;
    	    	String havePersonKind = "false";	//�Ƿ��������ձ�ı�ʶ
    	    	String havePropKind = "false";		//�Ƿ��вƲ��ձ�ı�ʶ
    	    	String haveCarKind = "false";		//�Ƿ��б���ձ�ı�ʶ
    	    	String haveThirdCarKind = "false";  //�Ƿ������߳��ձ�ı�ʶ
    	    	for(int i = 0;i < policyDto.getPrpCitemKindDtoList().size();i++){
    	    		prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(i);    	
    	    		//�ж��Ƿ�������˵��ձ�
    	    		if("false".equals(havePersonKind) &&
    	    		    ( "D3".equals(prpCitemKindDto.getKindCode())
    	    		   || "D4".equals(prpCitemKindDto.getKindCode())
    	    		   || "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   )){
    	    			havePersonKind = "true";    	    			
    	    		}
    	    		//�ж��Ƿ������߳����ձ�
    	    		if("false".equals(haveThirdCarKind) &&
    	    		    ( "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   )){
    	    			haveThirdCarKind = "true";    	    			
    	    		}
    	    		//�ж��Ƿ��вƲ����ձ�
    	    		if("false".equals(havePropKind) && 
    	    		    ( "BZ".equals(prpCitemKindDto.getKindCode())
    	    		   || "B".equals(prpCitemKindDto.getKindCode())
    	    		   || "G0".equals(prpCitemKindDto.getKindCode())
    	    		   || "NZ".equals(prpCitemKindDto.getKindCode())
    	    		   || "K10".equals(prpCitemKindDto.getKindCode())
    	    		    )){
    	    			havePropKind = "true";
    	    		}
    	    		//�ж��Ƿ��б�ĵ��ձ�
    	    		if("false".equals(haveCarKind) &&
    	    		    ("A".equals(prpCitemKindDto.getKindCode())
    	    		   || "G".equals(prpCitemKindDto.getKindCode()))
    	    		    ){
    	    			 haveCarKind = "true";
    	    		}
    	    	}
    		  httpServletRequest.setAttribute("havePersonKind", havePersonKind);
    		  httpServletRequest.setAttribute("haveThirdCarKind", haveThirdCarKind);
    		  httpServletRequest.setAttribute("havePropKind", havePropKind);
    		  httpServletRequest.setAttribute("haveCarKind", haveCarKind);
    		  
    	  }
        if(prpLscheduleMainWFDto.getClaimComCode().trim().length()>0){
      	 
//        	20060807	if(!user.getScheduleComCode().equals(prpLscheduleMainWFDto.getClaimComCode())){
//        	20060807 prpLscheduleMainWFDto.setScheduleType("NOCK");
//        	20060807}
        }
      }
      
      //��������˫����ʶ: 0 or null:��˫������; 1:˫�������Ȱ���(���շ�)  2:˫������ί���������Ȱ���(�б���) add 2005-12-17
      String commiFlag = httpServletRequest.getParameter("commiFlag"); 
     
      //��Ϊ˫����������ʱ,��ʾ��ϢҲ���ô˺���,��Ҫ����һ��,˫��������û��˫����־��.
      if(!(nodeType == null)){
      	if("commi".equals(nodeType)){
      	} else {
      		prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      	}
      } else {
      	prpLscheduleMainWFDto.setCommiFlag(commiFlag);
      }
     
      //add by liyanjie 2005-12-10 end
      
      scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);

      //������ش��������ת��
      changeCodeToName(httpServletRequest,scheduleDto);
     //���ô�����и�����ѡ�����б���Ϣ������
      setSelectionList(httpServletRequest,scheduleDto);
      //�������鿱��Ϣ���ݵ������
      httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
      //���ø����ӱ���Ϣ������
      setSubInfo(httpServletRequest,scheduleDto,editType);
      //���ù�������һ���ڵ��ύ��������Ϣ
      if (!prpLscheduleMainWFDto.getStatus().equals("4"))  {
        getSubmitNodes(httpServletRequest);
      }else
      {
          //�Ѿ���չ����
          httpServletRequest.setAttribute("finishSubmit","");
      }
      setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
   	
      //��������Ϣ����˵�������б�׼������
      Collection arrayListRegistExt = new ArrayList();
      PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
      prpLregistExtDto.setRegistNo(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
      prpLregistExtDto.setRiskCode(scheduleDto.getPrpLscheduleMainWFDto().getRiskCode());
      arrayListRegistExt = scheduleDto.getPrpLregistExtDtoList();
      prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
      httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
      setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
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
                                          String registNo,String editType) throws Exception{
     scheduleDtoToView(httpServletRequest,registNo,editType,"1") ;
    }

/*
    public void registDtoToView(HttpServletRequest httpServletRequest,
                                          String registNo,String editType,String surveyNo) throws Exception
    {
        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
        HttpSession session = httpServletRequest.getSession();
        UserDto   user     = (UserDto)session.getAttribute("user");
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
        //���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
        PrpLscheduleMainWFDto prpLscheduleMainWFDto= new PrpLscheduleMainWFDto ();
        user.getComCode();
        int inputHour=0;
        DateTime dtnow = new DateTime(DateTime.current());

       //prpLscheduleMainWFDto.setScheduleID    (registDto.getPrpLregistDto().getScheduleID  ());
        prpLscheduleMainWFDto.setRegistNo      (registDto.getPrpLregistDto().getRegistNo    ());
        prpLscheduleMainWFDto.setSurveyNo  (Integer.parseInt(surveyNo));

        prpLscheduleMainWFDto.setClaimComCode  (registDto.getPrpLregistDto().getComCode());
        prpLscheduleMainWFDto.setRiskCode      (registDto.getPrpLregistDto().getRiskCode    ());
        prpLscheduleMainWFDto.setPolicyNo      (registDto.getPrpLregistDto().getPolicyNo    ());
        prpLscheduleMainWFDto.setOperatorCode  (user.getUserCode() );
        prpLscheduleMainWFDto.setInputDate     (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        inputHour = dtnow.HOUR_TO_HOUR ;
        prpLscheduleMainWFDto.setInputHour     (DateTime.current().getHour());
       // prpLscheduleMainWFDto.setScheduleArea  (registDto.getPrpLregistDto().getScheduleArea());
        prpLscheduleMainWFDto.setFlag          (registDto.getPrpLregistDto().getFlag        ());

        //prpLscheduleMainWFDto.setInputHour(dtnow.getHour() );
        prpLscheduleMainWFDto.setStatus("0");
        //������չ����
        prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName()  ) ;
        prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber()  ) ;
        prpLscheduleMainWFDto.setOperatorName(user.getUserName() );

       if  (registDto.getPrpLregistTextDtoList().size() > 0)
        {
            PrpLregistTextDto prpLregistTextDto= new PrpLregistTextDto();
            prpLregistTextDto=(PrpLregistTextDto)registDto.getPrpLregistTextDtoList().iterator().next()  ;
            prpLscheduleMainWFDto.setRegistText(prpLregistTextDto.getContext() );
        }
        //���ò鿱������״̬Ϊ �°����Ǽ� (δ��������)
        //prpLscheduleMainWFDto.setStatus("1");
        //������ش��������ת��
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
        changeCodeToName(httpServletRequest,scheduleDto);
        //���ô�����и�����ѡ�����б���Ϣ������
        setSelectionList(httpServletRequest,scheduleDto);
        //�������鿱��Ϣ���ݵ������
        httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
        //���ø����ӱ���Ϣ������
        //(1).[�永����]�����߳��������б�׼������
        ArrayList arrayList = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto  = new PrpLthirdPartyDto();
        arrayList = registDto.getPrpLthirdPartyDtoList();
        prpLthirdPartyDto.setThirdPartyList(arrayList) ;
        scheduleDto.setPrpLthirdPartyDtoList(arrayList);

        // �������ת�����߳��͵��ȵı������
        httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

        ArrayList scheduleItemList = new ArrayList();

        Iterator it = arrayList.iterator() ;
        int i =1;
        PrpLthirdPartyDto prpLthirdPartyTempDto  = new PrpLthirdPartyDto();
        arrayList.contains(it);

        while (it.hasNext() )
        {
           PrpLscheduleItemDto prpLscheduleItemDto =new PrpLscheduleItemDto();
           prpLthirdPartyTempDto =(PrpLthirdPartyDto)it.next() ;
           prpLscheduleItemDto.setScheduleID         (scheduleDto.getPrpLscheduleMainWFDto().getScheduleID()  );
           prpLscheduleItemDto.setRegistNo           (scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
           prpLscheduleItemDto.setItemNo             (prpLthirdPartyTempDto.getSerialNo    ());
           prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyTempDto.getInsureCarFlag     ()  );
           prpLscheduleItemDto.setClaimComCode       (scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode ());
           prpLscheduleItemDto.setSelectSend         ("0");
           prpLscheduleItemDto.setSurveyTimes        (1);
           prpLscheduleItemDto.setSurveyType         (registDto.getPrpLregistDto () .getFirstSiteFlag() );
       //modify by lixiang add 20050309 start
       //reason:�鿱��ַĬ��Ϊ���յ�ַ���Զ�����
           if (i==1){ //ֻ�е�һ����ʾ�鿱��ַ
          prpLscheduleItemDto.setCheckSite          (registDto.getPrpLregistDto () .getDamageAddress() );

        }
       //modify by lixiang add 20050309 end

           //�鿱��ַ
           //prpLscheduleItemDto.setCheckSite          ( );
           prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyTempDto.getLicenseNo         ());
           //prpLscheduleItemDto.setScheduleObjectID   (0d);
           //prpLscheduleItemDto.setScheduleObjectName (prpLthirdPartyTempDto.getScheduleObjectName());
           prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
           // prpLscheduleItemDto.setResultInfo         (prpLthirdPartyTempDto.getResultInfo        ());
           // prpLscheduleItemDto.setBookFlag           (prpLthirdPartyTempDto.getBookFlag          ());
           // prpLscheduleItemDto.setScheduleType       (prpLthirdPartyTempDto.getScheduleType      ());
           //���뼯��
           scheduleItemList.add(prpLscheduleItemDto);
           i++;
         }

         scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
         PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
         prpLscheduleItemDto.setScheduleItemList(scheduleItemList);
         httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);

         //���ù�������һ���ڵ��ύ��������Ϣ
         getSubmitNodes(httpServletRequest);
    }
 */
    /**
     * ��ѯ��������������ѡ��Ľڵ�����
     * @param modelNo String
     * @param nodeNo String
     * @throws Exception
     */
    private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
    {
      String modelNo= httpServletRequest.getParameter("modelNo"); //ģ���
      String nodeNo= httpServletRequest.getParameter("nodeNo");   //�ڵ��
      int nextNodeNo=0;
      Collection pathList = new ArrayList();
      SwfPathDto swfPathDto  = new SwfPathDto() ;
      WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
      if (modelNo!=null&& nodeNo!=null)
      {
      pathList = workFlowViewHelper.getNextSumbitNodes(modelNo,nodeNo);
         if (pathList.iterator() .hasNext() )
          {
            SwfPathDto swfPathDtoTemp = new SwfPathDto();
            swfPathDtoTemp=(SwfPathDto)pathList.iterator().next();
            nextNodeNo = swfPathDtoTemp.getEndNodeNo();
            swfPathDto.setNextNodeNo(nextNodeNo);
          }
      }
      swfPathDto.setPathList(pathList);
      httpServletRequest.setAttribute("pathList",pathList);
      httpServletRequest.setAttribute("swfPathDto",swfPathDto);
    }

    /**
     * ���ݱ����Ų�ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo      ������
     * @param claimNo       ������
     * @throws Exception
     */

   
    /**
      * ����Dto�еĸ��ӱ��ڵ���Ϣ������
      * @param httpServletRequest ���ظ�ҳ���request
      * @param scheduleDto    �鿱��������
      * @throws Exception
      */
    private void setSubInfo(HttpServletRequest httpServletRequest,
                           ScheduleDto scheduleDto,String editType) throws Exception
    {


    	ArrayList scheduleItemListTemp = new ArrayList();
    	ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
    	scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
    	  //Ҫ���˵���ͬ��scheduleType������,ֻ�в鿱����Ź��˵ġ��������������_,���""
    	for (int i =0;i<scheduleItemList.size();i++) {
    		PrpLscheduleItemDto prpLscheduleItemDtoTemp =new PrpLscheduleItemDto();
            prpLscheduleItemDtoTemp =(PrpLscheduleItemDto)((ArrayList)scheduleItemList).get(i)  ;
            if (prpLscheduleItemDtoTemp.getScheduleObjectID().equals("_") ){
	            prpLscheduleItemDtoTemp.setScheduleObjectID   ("");
	            prpLscheduleItemDtoTemp.setScheduleObjectName ("");
            }
            	/*
	          if (prpLscheduleItemDtoTemp.getScheduleType().equals("sched")  ){
	            prpLscheduleItemDtoTemp.setSelectSend("0");
	            prpLscheduleItemDtoTemp.setSurveyTimes(0);
	            //��������ǵ��鿱ȥ�˵Ļ����ڶ�������ﲻ��ѡ�񣬳��ǲ鿱�Ѿ��ύ�ˡ���
	             }*/
            	//���û�е��ȹ���Ĭ�Ͻ�ȥΪ0,����û�б�ѡ��
            if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
            {
            	prpLscheduleItemDtoTemp.setSelectSend("0");
            }
            //add by liyanjie 2005-12-11 start �Ƚ�ClaimComCode�Ƿ񱾵��ȹ�˾,���ǵ���Ȩ����
            HttpSession session = httpServletRequest.getSession();
            UserDto   user     = (UserDto)session.getAttribute("user");
            
            if( (!"SHOW".equals(editType)) && prpLscheduleItemDtoTemp.getClaimComCode() != null && prpLscheduleItemDtoTemp.getClaimComCode().length()>0){
//            	20060807if(user.getScheduleComCode().equals(prpLscheduleItemDtoTemp.getClaimComCode())){
            	 //���뼯��
//            	20060807           	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
//            	20060807             }
//            	add by lixiang start at 2006-08-09
                //reason:�������Ŀǰ����˫���������Ȳ�����������⡣�����κι�������
                	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
                //add by lixiang start at 2006-08-09
            }else{
            	scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
            }
            
            //add by liyanjie 2005-12-11 end
          
           
    	}

    	PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
    	prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
    	httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
	}

    

    /**
     * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpLscheduleDto    �鿱��������
     * @throws Exception
     */
   private void changeCodeToName(HttpServletRequest httpServletRequest,
                          ScheduleDto scheduleDto) throws Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();

     //(1)��ҵ������ṹ����ת��
     String claimComCode = scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode();
     String claimComName = uiCodeAction.translateComCode(claimComCode,true) ;
     scheduleDto.getPrpLscheduleMainWFDto().setClaimComName(claimComName);
     //(2)�Բ���Ա���д���
     String operatorCode = scheduleDto.getPrpLscheduleMainWFDto().getOperatorCode() ;
     String operatorName = uiCodeAction.translateUserCode(operatorCode,true);
     scheduleDto.getPrpLscheduleMainWFDto().setOperatorName(operatorName);
  }
  public void  getScheuleGetBackQueryList(HttpServletRequest httpServletRequest,
                          String conditions,String scheduleType) throws Exception{
  //��õ���ȡ�ص�������б�
   getScheuleCheckList(httpServletRequest,conditions,"schel");

}



/**
* ��ѯ�鿱���ȵ���Ϣ
* @param httpServletRequest HttpServletRequest
* @param conditions String
* @throws Exception
*/

 public void getScheuleCheckList(HttpServletRequest httpServletRequest,
                          String conditions,String scheduleType) throws Exception
  {
    UIScheduleAction uiScheduleAction  = new UIScheduleAction ();
    PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
    PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
    ArrayList scheduleList = new ArrayList();
    Collection scheduleListTemp = new ArrayList();
    UICodeAction uiCodeAction = new UICodeAction();
    
    //ÿҳ��ʾ������
        String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        //
        if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";

      int intRecordPerPage=Integer.parseInt(recordPerPage) ;
      int intPageNo=Integer.parseInt(pageNo) ;
      TurnPageDto turnPageDto = new TurnPageDto();//��ҳ����
      
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      int count=0;
      
    if (scheduleType.equals("sched") ){
        
    	//��������!!!
    	//�ж���������
         	  count= uiScheduleAction.findScheduleMainWFCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
            }
    	
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      
      
         
      //1.ת������Ա������,�͵���Ա
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleMainWFDto prpLscheduleMainWFDto1 = new PrpLscheduleMainWFDto();
     prpLscheduleMainWFDto1 =(PrpLscheduleMainWFDto) it.next();
     prpLscheduleMainWFDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleMainWFDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleMainWFDto1);
   }
   prpLscheduleMainWFDto.setScheduleList(scheduleList);
   
   //��ѯ������һҳ�Ľṹ��
         turnPageDto.setResultList(scheduleList);
          //��ҳ������
      //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
         turnPageDto.setCondition(conditions);
    prpLscheduleMainWFDto.setTurnPageDto(turnPageDto) ;
         
    httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto);
    }else{
    
     //��������
     //�ж���������
         	  count= uiScheduleAction.findScheduleItemCountByConditon(conditions);
         	  if(maxQueryCount!=0&&count>maxQueryCount){   
                 throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
            }
     
    	PageRecord pageRecord = (PageRecord)uiScheduleAction.findItemByConditions(conditions,intPageNo,intRecordPerPage) ;
    	
      scheduleListTemp = (ArrayList)pageRecord.getResult();
      //1.ת������Ա������,�͵���Ա
   Iterator it = scheduleListTemp.iterator() ;

   while (it.hasNext() )
   {
     PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
     prpLscheduleItemDto1 =(PrpLscheduleItemDto) it.next();
     prpLscheduleItemDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleItemDto1.getOperatorCode(),true)) ;
     scheduleList.add(prpLscheduleItemDto1);
   }
      prpLscheduleItemDto.setScheduleItemList(scheduleList);
      //��ѯ������һҳ�Ľṹ��
         turnPageDto.setResultList(scheduleList);
          //��ҳ������
      //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
         turnPageDto.setCondition(conditions);
         prpLscheduleItemDto.setTurnPageDto(turnPageDto) ;
    
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
    }
    
    
   

    

   }

      /**
     * ��ѯ������ȵ���Ϣ
     * @param httpServletRequest HttpServletRequest
     * @param conditions String
     * @throws Exception
     */
    public void getScheuleCertainLossList(HttpServletRequest httpServletRequest,
                            String conditions) throws Exception
    {
      UIScheduleAction uiScheduleAction  = new UIScheduleAction ();
      PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
      Collection scheduleList = new ArrayList();
      Collection scheduleListTemp = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      scheduleListTemp=uiScheduleAction.findItemByConditions(conditions);
      //1.ת������Ա������,�͵���Ա
      Iterator it = scheduleListTemp.iterator() ;

      while (it.hasNext() )
      {
        PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
        prpLscheduleItemDto1 =(PrpLscheduleItemDto) it.next();
        prpLscheduleItemDto1.setOperatorName(uiCodeAction.translateUserCode(prpLscheduleItemDto1.getOperatorCode() ,true)) ;

        scheduleList.add(prpLscheduleItemDto1);
      }

      prpLscheduleItemDto.setScheduleItemList(scheduleList);
      httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
      httpServletRequest.setAttribute("scheduleType","schel") ;
     	
     }

     /**
        * ��ѯ�Ѿ����ȳ�ȥ�ģ����Խ��д������Ϣ������ӹ������ϻ���ˣ�
        * @param httpServletRequest HttpServletRequest
        * @param conditions String
        * @throws Exception
        */
       public void getNextTaskList(HttpServletRequest httpServletRequest,String conditions,String nodeType) throws Exception
       {
         UIWorkFlowAction uiWorkFlowAction= new UIWorkFlowAction();
         SwfLogDto swfLogDto = new SwfLogDto();
         ArrayList swfLogList = new ArrayList();
         UICodeAction uiCodeAction = new UICodeAction();
//       ÿҳ��ʾ������
         String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
         String pageNo     = httpServletRequest.getParameter("pageNo");
         //
         if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";

       int intRecordPerPage=Integer.parseInt(recordPerPage) ;
       int intPageNo=Integer.parseInt(pageNo) ;
       TurnPageDto turnPageDto = new TurnPageDto();//��ҳ����
       
       
       PageRecord pageRecord = (PageRecord)uiWorkFlowAction.findNodesByConditions(conditions,intPageNo,intRecordPerPage) ;
       
         swfLogList=(ArrayList)pageRecord.getResult();
         String editType     = httpServletRequest.getParameter("editType");
         
      
         swfLogDto.setSwfLogList(swfLogList);
         swfLogDto.setNodeType(nodeType);
         swfLogDto.setEditType(editType);
         swfLogDto.setNodeName(uiCodeAction.translateCodeCode("ClaimNodeType",nodeType,true) );
         //��ѯ������һҳ�Ľṹ��
         turnPageDto.setResultList(swfLogList);
         //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
         turnPageDto.setCondition(conditions);
         swfLogDto.setTurnPageDto(turnPageDto );
         
         httpServletRequest.setAttribute("swfLogDto",swfLogDto);
        
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
   			String scheduleType,String registNo,String editType) throws Exception{
   		//�������ͽ��нڵ�Ĳ�ѯ����Ϊ�������ݶ��Ѿ��ڱ����б����ˡ�
   		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
   		HttpSession session = httpServletRequest.getSession();
   		UserDto   user     = (UserDto)session.getAttribute("user");
   		UIScheduleAction uiScheduleAction = new UIScheduleAction();
   		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(1,registNo);
   		//System.out.println("@@@@@@@@@@@@@@�����Ĳ��� ��registNo ������"+registNo);
   		String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
   		String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
   		String riskCode = httpServletRequest.getParameter("riskCode"); //������logno
   		
   		
   		//modify by luqin update 2005-05-16 start
   		//reason: Ϊ�ǳ��ռ���鿱���Ƚڵ�
   		UIRegistAction uiRegistAction = new UIRegistAction();
   		System.out.println("registNo"+registNo);
   		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
   		
   	     //add by zhaolu start at 2006-06-10
   		  //reason ǿ�Ʊ���������Ϣд��������
   			System.out.println("ǿ�Ʊ���������Ϣд��������----------440");
   			System.out.println(registDto.getPrpLRegistRPolicyList().size());
   			System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
   			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
   			//add by zhaolu end at 2006-06-10
   		
   		String policyNo = httpServletRequest.getParameter("policyNo");
   		
   		//���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
   		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
   		if(scheduleDto.getPrpLscheduleMainWFDto()==null){
   			prpLscheduleMainWFDto.setRegistNo(registNo);
   			prpLscheduleMainWFDto.setPolicyNo(policyNo);
   			prpLscheduleMainWFDto.setClaimComCode(registDto.getPrpLregistDto().getComCode());
   			prpLscheduleMainWFDto.setClaimComName(registDto.getPrpLregistDto().getComName());
   			
   		}
   		else{
   			prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
   		}
   		//modify by luqin update 2005-05-16 end
   		
   		
   		//������չ����
   		prpLscheduleMainWFDto.setRiskCode(riskCode);
   		prpLscheduleMainWFDto.setLinkerName(DataUtils.nullToEmpty(registDto.getPrpLregistDto().getLinkerName() ) ) ;
   		prpLscheduleMainWFDto.setPhoneNumber(DataUtils.nullToEmpty(registDto.getPrpLregistDto().getPhoneNumber() ) ) ;;
   		prpLscheduleMainWFDto.setOperatorCode(user.getUserCode() );
   		prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
   		prpLscheduleMainWFDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
   		prpLscheduleMainWFDto.setInputHour(DateTime.current().getHour());
   		prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo() );
   		prpLscheduleMainWFDto.setScheduleObjectID("");
   		prpLscheduleMainWFDto.setEstimateLoss(registDto.getPrpLregistDto().getEstimateLoss());
   		
   		//�õ������б�
   		PrpDcompanyDto prpDcompanyDto = new 	PrpDcompanyDto ();
   	 //20060807  		prpDcompanyDto = (PrpDcompanyDto)new UICompanyAction().findByPrimaryKey(user .getComCode()) ;
   		if (prpDcompanyDto!=null){
   			prpLscheduleMainWFDto.setScheduleObjectID(prpDcompanyDto.getComCode());
   			prpLscheduleMainWFDto.setScheduleObjectName(prpDcompanyDto.getComCName());
   		}
   		
   		//modify by wangwei add start 205-6-13
   		//ԭ�����ӹ��������Ϣ
   		//modify by wangwei add end 2005-6-13
 //20060807  		prpLscheduleMainWFDto.setEstimateFee(registDto.getPrpLregistDto().getEstimateFee());
   		
   		//modify by wangli add start 20050416
   		//��������˴��뼰����
   		//System.out.println("�����Ĳ��ԣ�������shedule policyNo �� "+policyNo+"policyNo ");
   		//��ѯ������Ϣ
   		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
   		
   		if(policyNo!=null&&policyNo.length()>0)
   		{
   			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
   					,registDto.getPrpLregistDto().getDamageStartDate().toString()
   					,registDto.getPrpLregistDto().getDamageStartHour()); 
   			
   			UICodeAction uiCodeAction = new UICodeAction();
   			String agentCode="";
   			if (policyDto.getPrpCmainDto()!=null){
   				agentCode = policyDto.getPrpCmainDto().getAgentCode();         //�����˴���
   			}
   			prpLscheduleMainWFDto.setAgentCode(agentCode);
   			prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));//�õ�����������
   			//  System.out.println("�����Ĳ��ԣ�������shedule agentCode �� "+agentCode+"shedule ");
   			
   		}
   		// modify by wangli add start 20050416
   		//Ĭ�ϵ��ȵ�ַΪ���յ�ַ
   		prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto() .getDamageAddress() );
   		
   		//���õ�����ʲô���͵ı���
   		prpLscheduleMainWFDto.setSaveType(editType);
   		
   		if  (registDto.getPrpLregistTextDtoList().size() > 0)
   		{
   			for(int i = 0;i<registDto.getPrpLregistTextDtoList().size();i++){
   				PrpLregistTextDto prpLregistTextDto= new PrpLregistTextDto();
   				prpLregistTextDto=(PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i)  ;
   				prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+prpLregistTextDto.getContext() );
   			}
   		}
   		
   		//�Ѿ�������ϵ�״̬
   		prpLscheduleMainWFDto.setStatus("2");
   		
   		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
   		
   		//������ش��������ת��
   		changeCodeToName(httpServletRequest,scheduleDto);
   		//���ô�����и�����ѡ�����б���Ϣ������
   		setSelectionList(httpServletRequest,scheduleDto);
   		//�������鿱��Ϣ���ݵ������
   		httpServletRequest.setAttribute("prpLscheduleMainWFDto", prpLscheduleMainWFDto);
   		//ֻ�ж�����Ȳźͱ���й�ϵ���鿱���ȣ�ֻҪ����������Ϣ���Ϳ����ˡ�
   		//���ø����ӱ���Ϣ������
   		setSubInfo(httpServletRequest,scheduleDto);
   			//���ڵ��ǲ��ǿ����ύ
   			WorkFlowViewHelper workFlowViewHelper= new WorkFlowViewHelper();
   			String msg=workFlowViewHelper.checkNodeSubmit(swfLogFlowID,swfLogLogNo);
   			httpServletRequest.setAttribute("finishSubmit",msg);
   			//httpServletRequest.setAttribute("prpLscheduleItemDto",scheduleDto.getPrpLscheduleMainWFDto());
   			
   		
   		//������������scheduleItem
   		//���ù�������һ���ڵ��ύ��������Ϣ
   		getSubmitNodes(httpServletRequest);
   		
   		//��������Ϣ����˵�������б�׼������
   		Collection arrayListRegistExt = new ArrayList();
   		PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
   		prpLregistExtDto.setRegistNo(scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
   		prpLregistExtDto.setRiskCode(scheduleDto.getPrpLscheduleMainWFDto().getRiskCode());
   		arrayListRegistExt = scheduleDto.getPrpLregistExtDtoList();
   		prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
   		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
   		
   		setProvinceCode(httpServletRequest,registDto.getPrpLregistDto().getComCode());
   		
   		//scheduleDtoToView(httpServletRequest,registNo,editType,"1") ;
   		
   	}
	
	/**
	 * ����Dto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param scheduleDto    �鿱��������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		
		
		ArrayList scheduleItemListTemp = new ArrayList();
		ArrayList scheduleItemList = scheduleDto.getPrpLscheduleItemDtoList() ;
		scheduleDto.setPrpLscheduleItemDtoList(scheduleItemList);
		//Ҫ���˵���ͬ��scheduleType������,ֻ�в鿱����Ź��˵ġ��������������_,���""
		for (int i =0;i<scheduleItemList.size();i++) {
			PrpLscheduleItemDto prpLscheduleItemDtoTemp =new PrpLscheduleItemDto();
			prpLscheduleItemDtoTemp =(PrpLscheduleItemDto)((ArrayList)scheduleItemList).get(i)  ;
			if (prpLscheduleItemDtoTemp.getScheduleObjectID().equals("_") ){
				prpLscheduleItemDtoTemp.setScheduleObjectID   ("");
				prpLscheduleItemDtoTemp.setScheduleObjectName ("");
				
			}
			if (prpLscheduleItemDtoTemp.getScheduleType().equals("sched")  ){
				prpLscheduleItemDtoTemp.setSelectSend("0");
				prpLscheduleItemDtoTemp.setSurveyTimes(0);
				//��������ǵ��鿱ȥ�˵Ļ����ڶ�������ﲻ��ѡ�񣬳��ǲ鿱�Ѿ��ύ�ˡ���
			}
//			���û�е��ȹ���Ĭ�Ͻ�ȥΪ0,����û�б�ѡ��
			if (prpLscheduleItemDtoTemp.getSurveyTimes()==0 )
			{
				prpLscheduleItemDtoTemp.setSelectSend("0");
			}
			//���뼯��
			scheduleItemListTemp.add(prpLscheduleItemDtoTemp);
		}
//		System.out .println("scheduleItemListTemp.size()"+scheduleItemListTemp.size()) ;
		PrpLscheduleItemDto prpLscheduleItemDto= new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleItemList(scheduleItemListTemp);
		httpServletRequest.setAttribute("prpLscheduleItemDto",prpLscheduleItemDto);
		 
			}
	
	/**
	 * ��ȡѡ�����б���е���������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLscheduleDto    �鿱��������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception
			{
		UICodeAction uiCodeAction = new UICodeAction();
		
		
		//�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//�õ����Ƶ�ɫ�б�
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		httpServletRequest.setAttribute("licenseColorCodes",licenseColorCode);
			}
	

	
	
	
	//add by zhaolu 20060724 start
	//reason:��ѯ������Ϣ��ѯ��ҳ
	public void getScheuleCheckList(HttpServletRequest httpServletRequest,
			String conditions, String scheduleType,int pageNo,int recordPerPage) throws Exception {
		
		
		PageRecord pageRecord = null;
		
		
		String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	        }
	       
	     
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		ArrayList scheduleList = new ArrayList();
		ArrayList scheduleListTemp = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();
		
		if (scheduleType.equals("sched")) {
			
			
			
			//scheduleListTemp = uiScheduleAction.findByConditions(conditions);
            pageRecord = (PageRecord)uiScheduleAction.findForRegistConditions(conditions,pageNo,recordPerPage);
            scheduleListTemp = (ArrayList)pageRecord.getResult();
            
          PrpLscheduleMainWFDto prpLscheduleMainWFDtoTemp = new PrpLscheduleMainWFDto();
            
          
          httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDtoTemp);
            
			//1.ת������Ա������,�͵���Ա
			Iterator it = scheduleListTemp.iterator();

			while (it.hasNext()) {
				PrpLscheduleMainWFDto prpLscheduleMainWFDto1 = new PrpLscheduleMainWFDto();
				prpLscheduleMainWFDto1 = (PrpLscheduleMainWFDto) it.next();
				prpLscheduleMainWFDto1.setOperatorName(uiCodeAction
						.translateUserCode(prpLscheduleMainWFDto1
								.getOperatorCode(), true));
				scheduleList.add(prpLscheduleMainWFDto1);
			}
			  TurnPageDto turnPageDto = new TurnPageDto();
		       //��ѯ������һҳ�Ľṹ�� 
		       turnPageDto.setResultList(scheduleList);
		       //��ǰҳ��
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //һҳ������
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //��ѯ�����Ľ��������
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //�����ܵ�ҳ��
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //��������
		       turnPageDto.setCondition(conditions); 
			prpLscheduleMainWFDto.setScheduleList(scheduleList);
			prpLscheduleMainWFDto.setTurnPageDto(turnPageDto);
			httpServletRequest.setAttribute("prpLscheduleMainWFDto",
					prpLscheduleMainWFDto);
		} else {
			//scheduleListTemp = uiScheduleAction
					//.findItemByConditions(conditions);
			
			pageRecord = (PageRecord)uiScheduleAction.findItemByConditions(conditions,pageNo,recordPerPage);
			scheduleListTemp = (ArrayList)pageRecord.getResult();
			
			
          
            PrpLscheduleMainWFDto prpLscheduleMainWFDtoTemp = new PrpLscheduleMainWFDto();
            
           
           
            httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDtoTemp);
			
			//1.ת������Ա������,�͵���Ա
			Iterator it = scheduleListTemp.iterator();

			while (it.hasNext()) {
				PrpLscheduleItemDto prpLscheduleItemDto1 = new PrpLscheduleItemDto();
				prpLscheduleItemDto1 = (PrpLscheduleItemDto) it.next();
				prpLscheduleItemDto1.setOperatorName(uiCodeAction
						.translateUserCode(prpLscheduleItemDto1
								.getOperatorCode(), true));
				scheduleList.add(prpLscheduleItemDto1);
			}
			TurnPageDto turnPageDto = new TurnPageDto();
		       //��ѯ������һҳ�Ľṹ�� 
		       turnPageDto.setResultList(scheduleList);
		       //��ǰҳ��
		       turnPageDto.setPageNo(pageRecord.getPageNo());
		       //һҳ������
		       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		       //��ѯ�����Ľ��������
		       turnPageDto.setTotalCount(pageRecord.getCount());
		       //�����ܵ�ҳ��
		       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		       //��������
		       turnPageDto.setCondition(conditions); 
			prpLscheduleItemDto.setScheduleItemList(scheduleList);
			prpLscheduleItemDto.setTurnPageDto(turnPageDto);
			httpServletRequest.setAttribute("prpLscheduleItemDto",
					prpLscheduleItemDto);
		}
		

	}
	
  //add by zhaolu 20060724 end
	
	
	
	private void setProvinceCode(HttpServletRequest httpServletRequest,String comCode){
		/**
		 * ��ñ���������������Ӧʡ�ݴ���,���� ��ҵ�����󡣣�Ҫ���ڵ���ʱֻ��ѡ��÷ֹ�˾��ص����й�˾���е��ȣ�
		 * ComCode�ĵ�1��2��λ����Ӧ��ʡ�ݴ��룬��"3400000000"�е�"34"����ʡ�ݴ���
		 */
		String provinceCode = comCode.substring(0,2);
		httpServletRequest.setAttribute("provinceCode",provinceCode);
	}	


 }
