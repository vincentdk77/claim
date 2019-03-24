package com.sinosoft.claim.query.util;
/****************************************************************************
 * DESC       ��ҵ��������
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2005-03-22
 * MODIFYLIST ��  Name       Date            Reason/Contents
 ****************************************************************************/



import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.query.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.query.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIUtiCodeTransferAction;
import com.sinosoft.claim.query.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 *  ����������ش������� 
 */
public class BusinessRuleUtil
{

  /**
   * ȡ�����ֵĴ���
   * @param    policyNo   �ֶ���
   * @return   riskCode   ����
   */
  public static String getRiskCode(String businessNo,String businessType)throws Exception
  {
    String riskCode  = "";
    String condition = "";
    if(businessType.equals("PolicyNo")){//-----------------------������
        EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
        PolicyDto policyDto = null;
        policyDto = endorseViewHelper.findForEndorBefore(businessNo);
        riskCode = policyDto.getPrpCmainDto().getRiskCode();
        //System.out.println("----------------------------"+riskCode);
        return riskCode;
    }else if(businessType.equals("RegistNo")){//-------------------������
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("ClaimNo")){//------------------������
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(businessNo);
        riskCode = prpLclaimDto.getRiskCode(); 
        return riskCode;   
    }else if(businessType.equals("CompensateNo")){//----------------�������
        BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
        PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
        ArrayList compensateList = new ArrayList();
        condition = "compensateno = '"+businessNo+"'" ;
        compensateList = (ArrayList)blPrpLcompensateFacade.findByConditions(condition);
        prpLcompensateDto = (PrpLcompensateDto)compensateList.get(0);
        riskCode = prpLcompensateDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CaseNo")){//-------------------�᰸��
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        ArrayList claimList = new ArrayList(); 
        condition = "caseno = '"+businessNo+"'" ;
        claimList = (ArrayList)blPrpLclaimFacade.findByConditions(condition);
        prpLclaimDto = (PrpLclaimDto)claimList.get(0);
        riskCode = prpLclaimDto.getRiskCode(); 
        return riskCode;
    }else if(businessType.equals("ScheduleNo")){//-----------------���Ⱥ�
        //Ŀǰ��ϵͳû�е��Ⱥţ�����������û�е��Ⱥţ������ź͵������Ϊ����
        //���ԣ����Ⱥż�Ϊ������
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CheckNo")){//--------------------�鿱��
        //Ŀǰ��ϵͳû�в鿱�ţ��鿱������û�в鿱�ţ�����Ϊ�����ź͹������⳵�����
        //���ԣ��鿱�ż�Ϊ������
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("CertifyNo")){//--------------------��֤��
        //Ŀǰϵͳû�е����ĵ�֤�ţ����õ��Ǳ�����
        BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
        PrpLregistDto prpLregistDto = new PrpLregistDto(); 
        prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
        riskCode = prpLregistDto.getRiskCode();
        return riskCode;
    }else if(businessType.equals("PrepayNo")){//--------------------Ԥ���
        //Ŀǰϵͳû��Ԥ�⣬���ƣ��Ժ���У�����Ԥ���ӿ�
        UIPrepayAction uiPrepayAction = new UIPrepayAction();
        PrepayDto prepayDto = new PrepayDto(); 
        prepayDto = uiPrepayAction.findByPrimaryKey(businessNo);
        riskCode = prepayDto.getPrpLprepayDto().getRiskCode();
        return riskCode;
    }
    if(riskCode.equals("")){
        throw new UserException(-6,-109,"getRiskCode","��ȡ���ִ���ʧ��,����ϵϵͳ����Ա��");
    }
    return riskCode;
    }

  /**
   * ȡ��UI��forward
   * @param    httpServletRequest   httpServletRequest
   * @param    riskCode             ����
   * @param    nodeType             �ڵ����(regis,check��)
   * @param    editType             �༭����(SHOW,EDIT,ADD,DELETE��)
   * @param    lossItemCode         ��ĺ�(0Ϊ���ˣ���1Ϊ���𣬳���Ϊ1��2��3...�ȣ���֪����ʱ����1)
   * @return   forward              ��ǰ
   */
  public static String getForward(HttpServletRequest httpServletRequest,String riskCode,String nodeType,String editType,int lossItemCode) throws Exception
  {  
    String forward = ""; //��ǰ
    String originalRisk = riskCode;
    //System.err.println("originalRisk:" + originalRisk);
   //���������Ƿ�Ӻ���ҵ��ϵͳ�ĵ���
    //System.err.println("paramPrpallRegist:" + httpServletRequest.getParameter("paramPrpallRegist"));
    //System.err.println("paramUndwrtCompe:" + httpServletRequest.getParameter("paramUndwrtCompe"));
    if (httpServletRequest.getParameter("paramPrpallRegist") != null && httpServletRequest.getParameter("paramPrpallRegist").equals("DAA")) {
    	riskCode = "DAA";
    } else if (httpServletRequest.getParameter("paramUndwrtCompe") != null && httpServletRequest.getParameter("paramUndwrtCompe").equals("DAA")) {
    	riskCode = "DAA";
    } else {          //�������ִ���ת�� 
	  ArrayList transferList =(ArrayList)httpServletRequest.getSession().getAttribute("transferList");
	  
	  if (transferList == null) {  //��������ϵͳ������ϵͳ���ã���Ҫ��ʼ��һЩ��Ϣ��
	  	UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
	  	transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");	  	
	  }
	  //System.out.println("transferList.size()"+transferList.size());
	  //add by lixiang start at 2006-7-20
	  //reason:���û����ת�����в�ѯ�������֣��ǲ������������ģ�Ӧ��ֻ����������uitocodetransfer�ı����ݣ����ܽ��в�����
	  boolean findTheRiskCode=false;//Ĭ��Ϊfalse�ġ�
      //add by lixiang end at 2006-7-20
	  
	  for(int i = 0;i<transferList.size();i++){
	  	UtiCodeTransferDto utiCodeTransferDto = (UtiCodeTransferDto)transferList.get(i);
	  	//System.out.println("utiCodeTransferDto.getOuterCode()"+utiCodeTransferDto.getOuterCode());
	  	if(riskCode.equals(utiCodeTransferDto.getOuterCode())){
	  		riskCode = utiCodeTransferDto.getInnerCode();
	  		findTheRiskCode=true;
	  		break;
	  	}
	  }
	  //System.out.println("findTheRiskCode:" + findTheRiskCode);
	  
	  //System.out.println("InnerCode:" + riskCode);
	  
      //add by lixiang start at 2006-7-20
	  //reason:���û����ת�����в�ѯ�������֣��ǲ������������ģ�Ӧ��ֻ����������uitocodetransfer�ı����ݣ����ܽ��в�����
      if (!findTheRiskCode){
       	throw new UserException(1,3,"claim","" +
    			"����ϵϵͳ����Ա����������'"+riskCode+"'��UICODETRANSFER��ĳ�ʼ����");
       }
      //add by lixiang end at 2006-7-20
	 
    }
        System.out.println("nodeType:" + nodeType);
        System.out.println("lossItemCode:" + lossItemCode);
	    String riskCodeForward = "";//�������ļ�����ȡ��ϵͳ������������Ϣ
	    try{
	      riskCodeForward = AppConfig.get("sysconst.RiskCodeForward");
	    }catch(Exception ex){
	      ex.printStackTrace(); 
	    }
	    if(nodeType.equals("commo")){
	
	    }if(nodeType.equals("certa")||nodeType.equals("verip")||nodeType.equals("verpo")||nodeType.equals("verif")){
	      if (lossItemCode > 1) {
	        lossItemCode = 1;
	      }
	      //3�������SHOW���͵ģ�Ŀǰ��EDIT��ͬһ��Ŀ��jsp����
	      if (editType.equals("SHOW") || editType.equals("DELETE")||editType.equals("TimeOut")) {
	        editType = "EDIT";
	      }
	      //4���������DAA���ģ�Ŀǰ���鵽"Prop"�������Ҫ�ǲƲ���
	      if ((riskCode==null)||(riskCode.length() <1) ) riskCode="DAA";
	      String subRiskCode = riskCode.substring(0, 1);
	      if ( (riskCodeForward.indexOf(subRiskCode)) >= 0) {
	        forward = editType + lossItemCode+subRiskCode + "AA";
	      }
	      else {
	    	  //modify by miaowenjun 20060921 ũ���߲�ͬ��forward start
	    	if("I".equals(subRiskCode)||"H".equals(subRiskCode)){
	    		forward = editType + "Agri";
	    	}else{
	    		if(("0310".equals(originalRisk)||"0312".equals(originalRisk)) && nodeType.equals("verif"))
	    		{
	    			forward = editType + "-1DAA";
	    		}
	    		else
	    		{
	    			forward = editType + "Prop";
	    		}
	    	}
	    	//modify by miaowenjun 20060921 ũ���߲�ͬ��forward end
	      }
	    } else {
	      //3�������SHOW���͵ģ�Ŀǰ��EDIT��ͬһ��Ŀ��jsp����
	      if (editType.equals("SHOW") || editType.equals("DELETE")||editType.equals("TimeOut")) {
	        editType = "EDIT";
	      }
	      //4���������DAA���ģ�Ŀǰ���鵽"Prop"�������Ҫ�ǲƲ���
	      if ((riskCode==null)||(riskCode.length() <1) ) riskCode="DAA";
	      String subRiskCode = riskCode.substring(0,1);
	
	          System.out.println("--riskCodeForward---="+riskCodeForward+"-subRiskCode--="+subRiskCode+"--�Ƿ���ڵı�־��������ڵ���0�����--="+riskCodeForward.indexOf(subRiskCode));
	      if ((riskCodeForward.indexOf(subRiskCode))>=0) {
	        forward = editType + subRiskCode+"AA";
	        //System.out.println("forword=="+forward);
	      }else {
	    	  	//modify by miaowenjun 20060921 ũ���߲�ͬ��forward start
		    	if("I".equals(subRiskCode)||"H".equals(subRiskCode)){
		    		forward = editType + "Agri";
		    	}else{


		    			forward = editType + "Prop";

		    		
		    	}
		    	//modify by miaowenjun 20060921 ũ���߲�ͬ��forward end
	      }
	    }
   
    System.out.println("-������-getForward----=" + forward);
    return forward;
  }

  /**
   * ȡ��UI��forward
   * @param    nodeType         �ڵ����� 
   * @return   iTaskCode        taskCode
   */  
  public static String transTaskCode(String nodeType){
  	String iTaskCode=""; 
	if("regis".equals(nodeType)){
		iTaskCode="lpba";
	} else if("sched".equals(nodeType)){
		iTaskCode="lpdd";
	} else if("check".equals(nodeType)){
		iTaskCode="lpck";
	} else if("certa".equals(nodeType)){
		iTaskCode="lpds";
	} else if("claim".equals(nodeType)){
		iTaskCode="lpla";
	} else if("quote".equals(nodeType)){ 
		iTaskCode="lpbj";
	} else if("verip".equals(nodeType) || "verpo".equals(nodeType)){
		iTaskCode="lphj";
	} else if("verif".equals(nodeType)){
		iTaskCode="lphs";
	} else if("wound".equals(nodeType)){
		iTaskCode="lprd";
	} else if("veriw".equals(nodeType)){
		iTaskCode="lprh";
	} else if("certi".equals(nodeType)){
		iTaskCode="lpdz";
	} else if("prepa".equals(nodeType)){
		iTaskCode="lppa";
	} else if("compe".equals(nodeType)){
		iTaskCode="lppa"; 
	}else if("compp".equals(nodeType)){
		iTaskCode="lppa"; 
	} else if("speci".equals(nodeType)){
		iTaskCode="lpts"; 
	} else if("right".equals(nodeType)){
		iTaskCode="lpzc"; 
	} else if("endca".equals(nodeType)){
		iTaskCode="lpja"; 
	} else if("cance".equals(nodeType)){
		iTaskCode="lpzx"; 
	} else if("veric".equals(nodeType)){
		iTaskCode="lphp"; 
	} else if("veric".equals(nodeType)){
		iTaskCode="lphp"; 
	} else if("propc".equals(nodeType)){
		iTaskCode="lpcd"; 
	} else if("propv".equals(nodeType)){
		iTaskCode="lpch"; 
	} else if("backc".equals(nodeType)){
		iTaskCode="lpxy"; 
	} else if("backv".equals(nodeType)){
		iTaskCode="lphf"; 
	}
	return iTaskCode;
  }

  /**
   * ����ConfigCode�����ֶ��ձ�ȡ������
   * @param    configCode   �ֶ���    
   * @return   riskCode   ����
   */
  public static String getOuterCode(HttpServletRequest httpServletRequest,String configCode) throws Exception
  {
  	  String riskCode=""; 
	  //�������ִ���ת��
	  ArrayList transferList =(ArrayList)httpServletRequest.getSession().getAttribute("transferList");
	  
	  if (transferList == null) {  //��������ϵͳ������ϵͳ���ã���Ҫ��ʼ��һЩ��Ϣ��
	  	UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
	  	transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");
	  	//httpServletRequest.getSession().setAttribute("transferList", transferList); 
	  }
	  
	  for(int i = 0;i<transferList.size();i++){
	  	UtiCodeTransferDto utiCodeTransferDto = (UtiCodeTransferDto)transferList.get(i);
	  	if(configCode.equals(utiCodeTransferDto.getConfigCode())){
	  		riskCode = utiCodeTransferDto.getOuterCode();
	  		break;
	  	} 
	  }  
	  
	  return riskCode;
  } 
  
  
  /**
   * ����kindCode���ж��ǲ�����������ձ�
   * @param kindType   �ձ����� �����ò��� MainCarLoss:����ĳ�����ʧ��
   *                                       ThirdLoss(�����˳���)��
   *                                       ThirdCarLoss:���߳�
   *                                       ThirdPropLoss:������
   *                                       ThirdPersonLoss:�����ˣ�
   * @param kindCode   �ձ�
   * @return boolean
   */
  public static boolean checkKindType(String kindType,String kindCode) throws Exception
  {
  	  boolean blReturn= false; 
	  //�������ִ���ת��
  	  //MainCarLoss:����ĳ�����ʧ��
  	  
  	  if (kindType==null) return false;
  	  
  	  if (kindCode==null) return false;
  	  
  	  if (kindType.equals("MainCarLoss")){//:����ĳ�����ʧ��
  	  	 if (kindCode.equalsIgnoreCase( "A")
  	  			||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("002")){
  	     	blReturn= true; 
  	  	 }
  	  }
  	  if (kindType.equals("ThirdLoss")){//:(�����˳���)��
  		if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D3")||kindCode.equalsIgnoreCase( "D4")
				||kindCode.equalsIgnoreCase( "D2")||kindCode.equalsIgnoreCase( "H")
				||kindCode.equalsIgnoreCase( "D1")
				||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")
				||kindCode.equalsIgnoreCase("004")){
 	  		blReturn= true; 
 	       }
	  }
  	  
  	  if (kindType.equals("ThirdCarLoss")){//:���߳�
  	     if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
  	    		||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
     	    blReturn= true; 
  	    }
  	  }
  	 
 	  if (kindType.equals("ThirdPropLoss")){//:�����
 	  	if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D2")||kindCode.equalsIgnoreCase( "H")
 	  			||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
 	  		blReturn= true; 
 	       }
	  }
 	  if (kindType.equals("ThirdPersonLoss")){//:�����ˣ�
 	  	if (kindCode.equalsIgnoreCase( "B")||kindCode.equalsIgnoreCase( "BZ")
 	  			||kindCode.equalsIgnoreCase( "D3")||kindCode.equalsIgnoreCase( "D4")
				||kindCode.equalsIgnoreCase( "R")
				||kindCode.equalsIgnoreCase("001")||kindCode.equalsIgnoreCase("003")){
 	  		blReturn= true; 
 	       }
 	  }
 	  	
 	  
	  return blReturn;
  } 
  
  /**
   * ����kindType����kindItem�б�
   * @param kindType   �ձ����� �����ò��� MainCarLoss:����ĳ�����ʧ��
   *                                       ThirdLoss(�����˳���)��
   *                                       ThirdCarLoss:���߳�
   *                                       ThirdPropLoss:������
   *                                       ThirdPersonLoss:�����ˣ�
   * @param kindCode   �ձ�
   * @return boolean
   */
  public static Collection getReferItemKindListByKindType(String kindType,ArrayList itemKindList) throws Exception
  {
  	Collection itemKindListNew = new ArrayList();
	  //�������ִ���ת��
  	  //MainCarLoss:����ĳ�����ʧ��
  	  if (kindType==null) return itemKindListNew;
  	  if (itemKindList==null) return itemKindListNew;
  	  
  	  for (int i = 0; i < itemKindList.size(); i++) {
		PrpCitemKindDto prpCitemKindDto1 = new PrpCitemKindDto();  //ԭ����д�����֣�A-A-A-������  �������
		PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemKindList.get(i);
		prpCitemKindDto1.setPolicyNo(prpCitemKindDto.getPolicyNo());
		prpCitemKindDto1.setRiskCode(prpCitemKindDto.getRiskCode());
		prpCitemKindDto1.setKindCode(prpCitemKindDto.getKindCode());
		prpCitemKindDto1.setKindName(prpCitemKindDto.getKindCode() + "-"
				+ prpCitemKindDto.getKindName());
		
		if (checkKindType(kindType,prpCitemKindDto1.getKindCode())){
			itemKindListNew.add(prpCitemKindDto1);
		}
  	 
 	  }
 	  return itemKindListNew;
  } 
  
}
