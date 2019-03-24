package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLearFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.prpall.bl.facade.BLPrpCmainFacade;
import com.sinosoft.prpall.dbsvr.cb.DBPrpCitemCarExt;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.utility.string.Str;

/**
 * �ַ�HTTP GET �������ⱨ��ǰ��ѯ��������
 * <p>Title: �������ⱨ��ǰ��ѯ������Ϣ</p>
 * <p>Description: �������ⱨ��ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILRegistBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception {
	  
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    String policyNo     = httpServletRequest.getParameter("prpCmainPolicyNo");   //������
    String registNo     = httpServletRequest.getParameter("prpLregistRegistNo"); //������
    String damageDate   = httpServletRequest.getParameter("damageDate");//��������
    String damageHour   = httpServletRequest.getParameter("damageHour");//����Сʱ
    String damageMinute = httpServletRequest.getParameter("damageMinute");//���շ���
    String flashPage    = httpServletRequest.getParameter("FlashPage");//�Ƿ���ajaxˢ��ҳ��
    String editForward  = editType;                 //�������ת�ı�־
    String riskCode = "";                           //����
    String forward  = "";                           //��ǰ
    String licenseNo    = httpServletRequest.getParameter("prpCmainLicenseNo");   //��������
    HttpSession session = httpServletRequest.getSession();
    UserDto   user     = (UserDto)session.getAttribute("user");
  /*
   * ��Ԫ�µ�����,�����־λʱΪ��ʶ���Ƿ�����ֲ�յĶ��α���
   * editRegistFlag=ADD ��������
   * editRegistFlag=editH ��ֲ�ն��α���
   */
    String editRegistFlag = httpServletRequest.getParameter("editRegistFlag");
    

    try
    { 
    	//add by lym 20060604 for ǿ�� -----start>>>>>
      	//�������ҵ������ѯ-----------------
      	//ע�� 1����ȡ�Ƿ�ǿ����־qsflag 
      	//    2����ȡǿ������ mainPolicyNo  
      	String  mainPolicyNo =""; 
      	String  quaryPolicyNo=policyNo;
      	String  relateMainPolicyNo =""; //����ǿ������
      	String  relatePolicyNo="";  //������ҵ����
      	String  flag =""; 
      	String  qsFlag ="N";  //N��û�й���  Y���й���
      	
        int intPayFee  =0;
      	
      	 boolean qs_valid=false;
      	 boolean sy_valid=false;
      	 PrpCmainDto qs_prpCmainDto  = new  PrpCmainDto();
      	//ȡ��ǿ�Ʊ��յ����ִ���
        
        	//System.out.println("RISKCODE_DAZ:"+compelRiskCode);	
        if(policyNo == null){
        	riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        }
        if(registNo == null||registNo.equals("")){
        	riskCode = BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo");
        }
        if(!"Y".equals(flashPage)){//������Ǹ���ҳ�����ʱ��ʱ������ˢ��ҳ�����󣬳���ʱ��Ϊ��ǰʱ��
        	ChgDate chg = new ChgDate();
        	String currentTime = chg.getCurrentTime("yyyy-MM-dd HH:mm:ss");
        	damageDate = currentTime.substring(0,10);
        	damageHour = currentTime.substring(11,13);
        	damageMinute = currentTime.substring(14,16);
        }
        damageMinute = Str.chgStrZero(damageMinute);
        //ת�ɶ�Ӧ�Ľ�ǿ�����ֺ�
        TransCodeCI transCodeCI = new TransCodeCI();
        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode);
        
        String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
    	if("TimeOut".equals(editType))editType="SHOW";
    	/**
    	 * ��ֲ�շ��������ı����Ų�ѯ000
    	 * ��Ԫ ���� ��ʼ
    	 */
    	if("H".equals(riskType)&& "ADDFLAG".equals(editRegistFlag)){
    		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
    		Collection collection = null;
    		collection = dAARegistViewHelper.registNoListToView(httpServletRequest);
    		if(collection.size()!=0){
	    		httpServletRequest.setAttribute("policyNo",policyNo);
	    		httpServletRequest.setAttribute("registNoList",collection);
				forward="CheckAgri";
				return actionMapping.findForward(forward);
    		}
    	}
    	/**
    	 * ��ֲ�շ��������ı����Ų�ѯ
    	 * ��Ԫ ���� ����
    	 */
      //��δ����type�쳣����{}��������������쳣����{}
      //1����ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
      if (editType.equals("ADD")) {
       	 PolicyDto  policySubDto = new PolicyDto();
      	 PrpCmainSubDto prpCmainSubDto  = new  PrpCmainSubDto();
      	 PrpCmainDto qs_prpCmainDtoTemp  = new  PrpCmainDto();
       
      	EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
      	UIPolicyAction  uiPolicyAction = new UIPolicyAction();
      	DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
      	PolicyDto  policyDto  =  uiPolicyAction.findByPrimaryKey(policyNo);
		String strFlag = policyDto.getPrpCmainDto().getFlag();
		String propssalNo = policyDto.getPrpCmainDto().getProposalNo();
		httpServletRequest.setAttribute("acciFlag", strFlag);
		httpServletRequest.setAttribute("propssalNo", propssalNo);
		//�Ϻ������ҳ����ʾ�жϣ����Ϊ�Ϻ�����������յ��ţ�����ʾ��������Ϣ;
		String comcode = policyDto.getPrpCmainDto().getComCode().substring(0,2);
		httpServletRequest.setAttribute("comCode", comcode);
		ArrayList  prpCmainSubDtoList = policyDto.getPrpCmainSubDtoList();       	
       	String isStoppingCI = "N";//��ǿ����ͣʻ�ڼ�ı�־
       	String isStoppingBusiness = "N";//��ҵ����ͣʻ�ڼ�ı�־
       	String isValidRelatedFlag = "N";//��ǿ�ա���ҵ����Ч��������ñ�־
       	if((policyDto.getPrpCmainDto().getRiskCode().equals("0507")||policyDto.getPrpCmainDto().getRiskCode().equals("0577")
       			||policyDto.getPrpCmainDto().getRiskCode().equals("0587")) && dAARegistViewHelper.checkIsStopping(policyNo, damageDate,damageHour)){
       		isStoppingCI = "Y";
       	}
       	if((policyDto.getPrpCmainDto().getRiskCode().equals("0506")||policyDto.getPrpCmainDto().getRiskCode().equals("0576")
       			||policyDto.getPrpCmainDto().getRiskCode().equals("0586")) && dAARegistViewHelper.checkIsStopping(policyNo, damageDate,damageHour)){
       		isStoppingBusiness = "Y";
       	}
      	 if (prpCmainSubDtoList !=null && prpCmainSubDtoList.size()>0) {
      		 for ( int i=0;i < prpCmainSubDtoList.size();i++){
      		  //����ʱ���ڱ���������  && flag[2]=1 
      		  prpCmainSubDto  = (PrpCmainSubDto) prpCmainSubDtoList.get(i);
      		  relateMainPolicyNo = prpCmainSubDto.getMainPolicyNo();
      		  relatePolicyNo = prpCmainSubDto.getPolicyNo();
      		  flag = prpCmainSubDto.getFlag();
      		  //add by lixiang start at 2006-6-18
      		  //reason:���ǿ�Ʊ��������Ǵ���ģ��򲻼���ᡣ
      		   if (!uiPolicyAction.isExist(relateMainPolicyNo) ) continue; 
      		  //add by lixiang end at 2006-6-18
      		  //System.out.println("�ж�ǿ���������::" +flag.substring(1,2) );
      		  if(flag !=null&&flag.length()>=3){
      		   if (flag.substring(0,1).equals("1") ) {
      		     if (relatePolicyNo.equals(policyNo)){  //����ҵ������ѯ      		    	 
      		    	  policySubDto = endorseViewHelper.findForEndorBefore(relateMainPolicyNo,damageDate, damageHour);    		       
      		    	  
      		    	  if (policySubDto !=null){
      		    		  qs_prpCmainDtoTemp= policySubDto.getPrpCmainDto();
      		    		  sy_valid = dAARegistViewHelper.checkDate(httpServletRequest,relatePolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute));
      		    		  qs_valid = dAARegistViewHelper.checkDate(httpServletRequest,relateMainPolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute) );
      		    		  PolicyDto mainPolicyDto = uiPolicyAction.findByPrimaryKey(relateMainPolicyNo);
      		    		  if ( mainPolicyDto != null 
      		    			&& qs_valid && sy_valid
      		    			&& ("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
      		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))) {  //��ѯ����������Чǿ������,��Ч����������ʱ���ڱ����ڼ��ڣ��ѽɷ�
      		    			isValidRelatedFlag = "Y";
      		    			  //��ǿ���Ƿ���ͣʻ�ڼ���
            		    	  if(dAARegistViewHelper.checkIsStopping(relateMainPolicyNo, damageDate,damageHour)){
               		       		  isStoppingCI = "Y";
               		       		  if("Y".equals(isStoppingBusiness)){
               		       			  //���򵽴�ʱ��˵�����������ű�������ͣʻ�ڼ䣬��ʱ��ʾ���ű�������Ϣ����ҳ����ȥ���Ʋ����ύ����
               		       			  policyNo= relatePolicyNo;
               		       			  mainPolicyNo  =  relateMainPolicyNo ;
               		       			  qs_prpCmainDto=qs_prpCmainDtoTemp;
               		       			  intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
               		       			  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
               		       		  }
               		       		  break;
               		       	  }
            		    	  if("Y".equals(isStoppingBusiness)){
            		    		  //���򵽴�ʱ��˵������Ч�ù������⣬����ҵ����ͣʻ�ڼ䣬�����ý�ǿ�ղ���ͣʻ�ڼ䣬ֻ���ý�ǿ�ձ���
            		    		  policyNo = relateMainPolicyNo;
            		    		  qs_prpCmainDto=qs_prpCmainDtoTemp;
              		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
                 		    	  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
            		    		  break;
            		    	  }
      		    			  policyNo= relatePolicyNo;
          		    	      mainPolicyNo  =  relateMainPolicyNo ;
          		    	      qsFlag ="Y";
          		    	      qs_prpCmainDto=qs_prpCmainDtoTemp;
          		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
             		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
      		    			  break;
      		    		  }
      		    		  if(!sy_valid){
      		    			qsFlag ="OutInsureDate";	//����ʱ�䲻�ڱ����ڼ���
      		    			break;
      		    		  }
      		    		  if(  !("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
      		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))){
      		    			  	qsFlag ="NotCheckin";  //�����ı���δ����
      		    			  	break;
      		    		  }
      		    		  
      		    	  }
      		    	  
      		    	  
      		     }else {  //��ǿ��������ѯ
      		    	  policySubDto = endorseViewHelper.findForEndorBefore(relatePolicyNo,damageDate, damageHour);    		    	 
      		    	  
      		    	 if ( policySubDto !=null) {
      		    		// qs_prpCmainDtoTemp= policySubDto.getPrpCmainDto();
      		    		 qs_prpCmainDtoTemp = policyDto.getPrpCmainDto();
      		    		 qs_valid = dAARegistViewHelper.checkDate(httpServletRequest,relateMainPolicyNo, damageDate, Integer.parseInt(damageHour),Integer.parseInt(damageMinute) );
      		    		 sy_valid = dAARegistViewHelper.checkDate(httpServletRequest,relatePolicyNo, damageDate, Integer.parseInt(damageHour) ,Integer.parseInt(damageMinute));
      		    		PolicyDto mainPolicyDto = uiPolicyAction.findByPrimaryKey(relatePolicyNo);
      		    	    if (   mainPolicyDto != null 
          		    		&& qs_valid && sy_valid 
          		    		&& ("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
          		    		|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))
          		    	  ) {  //��ѯ����������Ч��ҵ����,��Ч����������ʱ���ڱ����ڼ��ڣ��ѽɷ�
      		    	    	isValidRelatedFlag = "Y";
      		    	      //��ҵ���Ƿ���ͣʻ�ڼ���
        		    		 if(dAARegistViewHelper.checkIsStopping(relatePolicyNo, damageDate,damageHour)){
           		       		  isStoppingBusiness = "Y";
           		       		  if("Y".equals(isStoppingCI)){
           		       			  //���򵽴�ʱ��˵�����������ű�������ͣʻ�ڼ䣬��ʱ��ʾ���ű�������Ϣ����ҳ����ȥ���Ʋ����ύ����
           		       			  policyNo= relatePolicyNo;
           		       			  mainPolicyNo  =  relateMainPolicyNo ;
           		       			  qs_prpCmainDto=qs_prpCmainDtoTemp;
           		       			  intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
           		       			  dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ; 
           		       		  }
           		       		  break;
           		       	  }
        		    	  if("Y".equals(isStoppingCI)){
           		    		  //���򵽴�ʱ��˵������Ч�ù������⣬����ǿ����ͣʻ�ڼ䣬��������ҵ�ղ���ͣʻ�ڼ䣬ֻ������ҵ�ձ���
           		    		  policyNo = relatePolicyNo;
           		    		  qs_prpCmainDto=qs_prpCmainDtoTemp;
        		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
           		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
           		    		  break;
           		    	  }
      		    	      policyNo= relatePolicyNo;
      		    	      mainPolicyNo  =  relateMainPolicyNo ;
      		    	      qsFlag ="Y";
      		    	      qs_prpCmainDto=qs_prpCmainDtoTemp;
      		    	      intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
         		    	      dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
         		    	  
         		    	      break;
         		    	      
      		    	    }
      		    	   if(!sy_valid){
    		    			qsFlag ="OutInsureDate";	//����ʱ�䲻�ڱ����ڼ���
    		    			break;
    		    		  }
    		    	   if(  !("1".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()) 
    		    			|| "3".equals(mainPolicyDto.getPrpCmainDto().getUnderWriteFlag()))){
    		    			  	qsFlag ="NotCheckin";  //�����ı���δ����
    		    			  	break;
    		    		  }
    		    	   
      		    	 }
      		     }
      		  }//end flag 
      		  }
      		 }//end for 
      	 }  //end fi
      	if("Y".equals(isStoppingCI) || "Y".equals(isStoppingBusiness)){
     		 qsFlag = "inStopping";
     	 }
      	if("Y".equals(isStoppingCI) && "Y".equals(isStoppingBusiness)){
      		qsFlag = "Y";
      	}
      	 httpServletRequest.setAttribute("isValidRelatedFlag", isValidRelatedFlag);
      	 httpServletRequest.setAttribute("isStoppingCI", isStoppingCI);
      	 httpServletRequest.setAttribute("isStoppingBusiness", isStoppingBusiness);
       	 httpServletRequest.setAttribute("quaryPolicyNo", quaryPolicyNo);
      	 httpServletRequest.setAttribute("intPayFee", String.valueOf(intPayFee));
      	 httpServletRequest.setAttribute("qs_prpCmainDto", qs_prpCmainDto );
      	 if(!"".equals(mainPolicyNo) && !"".equals(relatePolicyNo)){
	      	 if(quaryPolicyNo.substring(1,5).equals("0506") || quaryPolicyNo.substring(1,5).equals("0586")||quaryPolicyNo.substring(1,5).equals("0576")){
	      		httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
	      	 }else{
	      		httpServletRequest.setAttribute("mainPolicyNo", relatePolicyNo);
	      	 }
      	 }else{
      		httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
      	 }
      	 httpServletRequest.setAttribute("qsFlag", qsFlag);
      	 //��ʱ��Ч�ı���ͨ��prpcitemcarExt�б����������ж�
      	 String immediateValidPeriod = "";
      	 if("05".equals(policyDto.getPrpCmainDto().getClassCode())){
      	   DBPrpCitemCarExt dbPrpCitemCarExt = new DBPrpCitemCarExt();
      	   dbPrpCitemCarExt.getInfo(policyNo);
      	   //��ʱ��Ч�ı���������������prpcitemCarExt�еı������޽����ж�      	   
      	   if("1".equals(dbPrpCitemCarExt.getImmediateValidFlag())){
      		   String strWhere = " policyno='" + policyNo + "' And to_date('" + damageDate + " " + damageHour + 
      		        ":" + damageMinute + ":00','yyyy-MM-dd HH24:MI:SS') " +
      		   		"  Between startdate And enddate";
      		   if(dbPrpCitemCarExt.getCount(strWhere) > 0){
      			   immediateValidPeriod = "Y";	//Y-��ʾ�ڼ�ʱ��Ч�ı��������ڣ�N��֮
      		   }else{
      			   immediateValidPeriod = "N"; 
      		   }
      	   }
      	 }
      	httpServletRequest.setAttribute("immediateValidPeriod", immediateValidPeriod); 
//      	add by zhaolu start at 2006-06-09
 		//reason ǿ�Ʊ���������Ϣд��������      	 
      	PrpLRegistRPolicyDto prpLRegistRPolicyDtoOfCompel=null; 
      	 if ("Y".equals(qsFlag)){
      	 	prpLRegistRPolicyDtoOfCompel=new PrpLRegistRPolicyDto(); 
      	 	prpLRegistRPolicyDtoOfCompel.setPolicyNo(mainPolicyNo);  
      	 	prpLRegistRPolicyDtoOfCompel.setRiskCode(compelRiskCode ); //����ʱд�������Ժ��޸�
 		 }
 		httpServletRequest.setAttribute("prpLregistRPolicyNo", prpLRegistRPolicyDtoOfCompel); 
 		
 		//ˢ�±���ҳ��
 		if(flashPage != null && flashPage.equals("Y")){ 
 	 	    
 			// ��ѯ����ʱ������Ϣ 			
 			PolicyDto DamagePolicyDto = endorseViewHelper.findForEndorBefore(quaryPolicyNo,
 					damageDate, damageHour);
 			httpServletRequest.setAttribute("prpCmainDto", DamagePolicyDto.getPrpCmainDto());
 			forward = "DAARegistFlashPage";
 			return actionMapping.findForward(forward);
 		}
 		//add by zhaolu end at 2006-06-09
          	//add by lym 20060604 for ǿ�� -----end>>>>>
 		//add by miaowenjun 20060925 ũ�����Լ���viewhelper
 		AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
 		
 		if("I".equals(riskType)||"H".equals(riskType)){
 			agriRegistViewHelper.policyDtoToView(httpServletRequest, policyNo, damageDate, damageHour);
 		}else{
 			dAARegistViewHelper.policyDtoToView(httpServletRequest,quaryPolicyNo,damageDate,damageHour);
 		}
        policyNo = policyNo.trim() ;
        
        //add by wunier 20071228
        //reason���������⸶������Ӧ�ĵ�λ��Ϣ
        riskCode = policyNo.substring(1,5);
        String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
        UICodeAction uiCodeAction = new UICodeAction();
        Collection collection = uiCodeAction.findByConditions(conditions);
        httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
        //end by wunier 20071228
        
        
        //2012-12-17�ܷ�ֱ�ӵ���   Ȩ��У��   start
		PrpDuserDto platformPrpDuserDto = new PrpDuserDto();
		platformPrpDuserDto.setUserCode(user.getUserCode());
		platformPrpDuserDto.setLoginComCode(user.getComCode());
		String checkPower = "false" ; //�Ƿ�ͨ��У��
		if("Y".equals(riskType)||"Q".equals(riskType)||"I".equals(riskType)|| "Z".equals(riskType)){
			checkPower = String.valueOf(UIPowerAction.checkPowerReturn(platformPrpDuserDto, "claim.schedule"));
		}
		
		httpServletRequest.setAttribute("checkPower", checkPower);
        //2012-12-17�ܷ�ֱ�ӵ���   Ȩ��У��   end
      }
      //2����ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
      if(editType.equals("EDIT")||editType.equals("SHOW")||editType.equals("DELETE")||editType.equals("TimeOut"))
      {
    	  AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
//      ------------------------------------
    	PrpLRegistRPolicyDto  prpLRegistRPolicyDto=new PrpLRegistRPolicyDto();
        UIPrpLregistRPolicyAction  uiPrpLrgistRPolicyAction =new UIPrpLregistRPolicyAction();
        Collection collection=   uiPrpLrgistRPolicyAction.findByConditions(" registno= '" + registNo+"'");
        if (collection !=null &&collection.size()>1){
        	   qsFlag ="Y";
        	   Iterator it= collection.iterator();
        	   while ( it.hasNext()){
        	    prpLRegistRPolicyDto=(PrpLRegistRPolicyDto) it.next();
        		if( prpLRegistRPolicyDto.getRegistFlag().equals("0")){
        			mainPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
           	       	policyNo = mainPolicyNo;
        			UIPolicyAction  uiPolicyAction = new UIPolicyAction();
        	       	PolicyDto  policyDto  =  uiPolicyAction.findByPrimaryKey(mainPolicyNo);
        	       	qs_prpCmainDto = policyDto.getPrpCmainDto();
        	        intPayFee = dAARegistViewHelper.checkPay(httpServletRequest, mainPolicyNo);
        	        //dAARegistViewHelper.getQsRegistInfo(httpServletRequest, mainPolicyNo) ;
        	        
        		}
        		if ( prpLRegistRPolicyDto.getRegistFlag().equals("1")){
        			quaryPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
        			
        		}
        		
        	}
        	
        }else if (collection !=null && collection.size()==1){
         	 Iterator it= collection.iterator();
      	   while ( it.hasNext()){
      	    prpLRegistRPolicyDto=(PrpLRegistRPolicyDto) it.next();
        	quaryPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
        	policyNo = prpLRegistRPolicyDto.getPolicyNo();
      	   }
        }else {
        	//��ʷ���ݣ�
        }
         //
         httpServletRequest.setAttribute("quaryPolicyNo", quaryPolicyNo);
     	 httpServletRequest.setAttribute("intPayFee", String.valueOf(intPayFee));
     	 httpServletRequest.setAttribute("qs_prpCmainDto", qs_prpCmainDto );
     	 httpServletRequest.setAttribute("mainPolicyNo", mainPolicyNo);
     	 httpServletRequest.setAttribute("qsFlag", qsFlag);
        
//   	add by zhaolu start at 2006-06-09
  		//reason ǿ�Ʊ���������Ϣд��������
       	PrpLRegistRPolicyDto prpLRegistRPolicyDtoOfCompel=null; 
       	 if ("Y".equals(qsFlag)){
       	 	prpLRegistRPolicyDtoOfCompel=new PrpLRegistRPolicyDto(); 
       	 	prpLRegistRPolicyDtoOfCompel.setPolicyNo(mainPolicyNo);  
       	 	prpLRegistRPolicyDtoOfCompel.setRiskCode(compelRiskCode); //����ʱд�������Ժ��޸�
  		 }
  		httpServletRequest.setAttribute("prpLregistRPolicyNo", prpLRegistRPolicyDtoOfCompel);
  		//modify by miaowenjun 20060928 ũ�����Լ���viewhelper
  		if("I".equals(riskType)||"H".equals(riskType)){
  			agriRegistViewHelper.setRegistDtoView(httpServletRequest, registNo);
  		}
  		else{
            dAARegistViewHelper.setRegistDtoView(httpServletRequest,registNo);
  		}
        registNo = registNo.trim() ;
        riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        //add by wunier 20071228
        //reason���������⸶������Ӧ�ĵ�λ��Ϣ
        String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
        UICodeAction uiCodeAction = new UICodeAction();
        Collection collection1 = uiCodeAction.findByConditions(conditions);
        httpServletRequest.setAttribute("lossesUnitCodeCollection",collection1);
        //end by wunier 20071228
        
      }
     
      if (registNo != null && (!"".equals(registNo))) {
				riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
			}
      //����Ƿ�������
      UIEndorseAction uiEndorseAction = new UIEndorseAction();
       int checkFlag =0;
       checkFlag = uiEndorseAction.checkStatus(policyNo);
       httpServletRequest.setAttribute("checkFlag", checkFlag+"");
       
    
      //ȡ��forward
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"regis",editType,1);
      httpServletRequest.setAttribute("com.sinosoft.forward", forward);
     
      saveToken(httpServletRequest);
      
      
      //start�����־
      String businessFlag = "0";
      BLPrpCmainFacade  blPrpCmainFacade = new BLPrpCmainFacade();
      com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtoTem = blPrpCmainFacade.findByPrimaryKey(policyNo);
      if(prpCmainDtoTem!=null){
    	  businessFlag = prpCmainDtoTem.getBusinessFlag();
      }
	  httpServletRequest.setAttribute("businessFlag", businessFlag);
      //end�����־
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
      //throw usee;
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {
    }
    return actionMapping.findForward(forward);
  }
}
