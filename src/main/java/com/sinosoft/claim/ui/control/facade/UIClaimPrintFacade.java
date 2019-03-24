package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinjuryFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.ClaimPrintViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ������ѯ
 * <p>Title: ��������������ѯ��Ϣ</p>
 * <p>Description: ������������������ѯ��Ϣϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0 
 */ 

public class UIClaimPrintFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {


    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ 
    String printType   = httpServletRequest.getParameter("printType");  //��ӡ����
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //������
    String claimNo   = httpServletRequest.getParameter("ClaimNo") ; //�ⰸ��
    String registNo = httpServletRequest.getParameter("RegistNo") ; //������
    String compensateNo = httpServletRequest.getParameter("CompensateNo") ; //�������
    String preCompensateNo = httpServletRequest.getParameter("PreCompensateNo") ; //�������
    String caseNo = httpServletRequest.getParameter("CaseNo") ; //�ⰸ����
    String lossItemCode = httpServletRequest.getParameter("lossItemCode") ; //�ⰸ����
    String strPaymentFlag  = httpServletRequest.getParameter("PaymentFlag"); //���ƴ�ӡ��ť�Ƿ���ʾ
    String startDate = httpServletRequest.getParameter("startDate");
    String endDate = httpServletRequest.getParameter("endDate");
   //HttpSession session = httpServletRequest.getSession();
    //User    user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                         //����
    UICodeAction uiCodeAction = new UICodeAction();
    String strRiskCode = "";
	String strRiskType = "";
	
	//��ѯ��Ϣ---��ӡҳ�������Ϣ
	BLPrpLinjuryFacadeBase bLPrpLinjuryFacadeBase = new BLPrpLinjuryFacadeBase();
	PrpLinjuryPersonDto prpLinjuryPersonDto = new PrpLinjuryPersonDto();
	prpLinjuryPersonDto = bLPrpLinjuryFacadeBase.findByPrimaryKey(compensateNo);
	/***************************���ӳ�������ϸ��Ϣ********************************/
	String acciName = null;String sex = null;String identifyNumber = null;
	if(prpLinjuryPersonDto!=null){
		acciName = prpLinjuryPersonDto.getAcciName();
		sex = prpLinjuryPersonDto.getSex();
		identifyNumber = prpLinjuryPersonDto.getIdentifyNumber();
		httpServletRequest.setAttribute("acciName",acciName);
		httpServletRequest.setAttribute("sex",sex);
		httpServletRequest.setAttribute("identifyNumber",identifyNumber);
	}else{
		httpServletRequest.setAttribute("acciName","");
		httpServletRequest.setAttribute("sex","");
		httpServletRequest.setAttribute("identifyNumber","");
	}
	
	if (printType.equals("Compensate")) {
		
		BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
		PrpLcompensateDto prpLcompensateDto = blPrpLcompensateFacade
				.findByPrimaryKey(compensateNo);
		strRiskCode = prpLcompensateDto.getRiskCode();
		strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
		if ("Q".equals(strRiskType)) {
			printType = "PropCompensate";
		}
		if ("Y".equals(strRiskType)) {
			printType = "FreightInportCompensate";
		}
		if ("Z".equals(strRiskType)) {
			printType = "LiabCompensate";
		}
		if ("E".equals(strRiskType)) {
			printType = "CompensateAuditBook";
		}
		if ("I".equals(strRiskType)||"H".equals(strRiskType)) {
			printType = "LiabCompensate";
		}
	}

    if (printType.equals("CheckReport")) {
    	BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = blPrpLregistFacade
				.findByPrimaryKey(registNo);
		strRiskCode = prpLregistDto.getRiskCode();
		strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
		if ("Q".equals(strRiskType)) {
			printType = "PropLocalCheck";
		}
		if ("Y".equals(strRiskType)) {
			printType = "FreightCheckReport";
		}
		if ("Z".equals(strRiskType)) {
			printType = "LiabLocaleCheck";
		}
		if ("I".equals(strRiskType)||"H".equals(strRiskType)) {
			printType = "LocalCheck";
		}
	}
    if (printType.equals("Cancel")) {
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
		strRiskCode = prpLclaimDto.getRiskCode();
		strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
		if ("E".equals(strRiskType)) {
			printType = "AcciCancelNotice";
		}
		if ("D".equals(strRiskType)) {
			printType = "Cancelnotice";
		}
		if ("Y".equals(strRiskType)) {
			printType = "FreightRefuseCancel";
		}
		if  ("Z".equals(strRiskType)||"I".equals(strRiskType)||"H".equals(strRiskType)||"Q".equals(strRiskType)){
			printType = "PropCancelNotice";
		}
	}
    if (printType.equals("CopyPrint")) {
    	BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade(); 
    	registNo = compensateNo;
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(compensateNo);
		strRiskCode = prpLregistDto.getRiskCode();
		strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);		
		if ("D".equals(strRiskType)) {
			printType = "Regist";
		}		
	}
       
    if (!( registNo==null || registNo.equals("") )){
    	
    	 UIRegistAction  uiRegistAction =new UIRegistAction();
    	 RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
    	 policyNo= registDto.getPrpLregistDto().getPolicyNo();
     	
    	 String conditions="registNo='"+registNo+"'";
    	 UIClaimAction  uiClaimAction = new UIClaimAction();
    	 Collection claimDtoList = new ArrayList();
    	 claimDtoList= uiClaimAction.findByConditions(conditions);
    	
    	 if (claimDtoList!=null &&claimDtoList.size()>0 ) {
    	 	Iterator it = claimDtoList.iterator();
    	 	  while(it.hasNext()){
    	           PrpLclaimDto prpLclaimDto = (PrpLclaimDto)it.next();
    	           claimNo=  prpLclaimDto.getClaimNo();
    	         
    	       }
    	 }
      }
    
     if (!( claimNo==null || claimNo.equals(""))) {
		 registNo = uiCodeAction.translateBusinessCode(claimNo, false);
	 }
    
    
    String forward  = "";                                          //��ǰ
    try
    {
     ClaimPrintViewHelper claimPrintViewHelper = new ClaimPrintViewHelper();
      //��ӡ
      if (printType.equals("Regist")){ //1.������¼����������
        /*
        DAARegistViewHelper dAARegistViewHelper=new DAARegistViewHelper ();
        dAARegistViewHelper.setRegistDtoView(httpServletRequest,registNo);*/
        claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      } else if(printType.equals("Pilfer")){   //2.���գ�������֤��
        claimPrintViewHelper.getPilfer(httpServletRequest,claimNo);
      } else if(printType.equals("Cancelnotice")){ //3.����֪ͨ��
        claimPrintViewHelper.getCancelnotice(httpServletRequest,claimNo);
      } else if(printType.equals("Canceltrans")){//4.���ⰸ��������
        claimPrintViewHelper.getCanceltrans(httpServletRequest,claimNo);
      } else if(printType.equals("LossSimple")){ //5.��ʧ�������ȷ����
        claimPrintViewHelper.getLossSimple(httpServletRequest,claimNo);
      } else if(printType.equals("Loss")){ //6.��ʧ���ȷ����
        claimPrintViewHelper.getLoss(httpServletRequest,claimNo,registNo);
      } else if(printType.equals("LossPrint")){
    	  claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      //modify 20060302************************************************
      } else if(printType.equals("ComponentList")||printType.equals("CetainLossList")){//7.�㲿��������Ŀ�嵥
      	 claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("ComponentListPrint")){//9.������Ŀ�嵥  //modify 20060302 ��ӡ
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      } else if(printType.equals("CetainLossListPrint")||printType.equals("CetainLossListDetail")){
          claimPrintViewHelper.getCetainLossList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      }else if(printType.equals("ComponentAdd")){ //8.�㲿��������Ŀ�嵥����
      	claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("ComponentAddPrint")){//9.������Ŀ�嵥  //modify 20060302 ��ӡ
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
    
        
      } else if(printType.equals("RepairList")){//9.������Ŀ�嵥  //modify 20060302
      	
        claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("RepairListPrint")){//9.������Ŀ�嵥  //modify 20060302 ��ӡ
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
        
      } else if(printType.equals("RepairAdd")){ //10.������Ŀ�嵥����
      	 claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
       // claimPrintViewHelper.getRepairAdd(httpServletRequest,claimNo);
      } else if(printType.equals("RepairAddPrint")){ //10.������Ŀ�嵥����
      	 claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType); 
        
      //****************************************************************
      	  // add by zhouliu start 2006-6-12
         //
         } else if(printType.equals("Cancelcompel")){
       	 claimPrintViewHelper.getPilfer(httpServletRequest,claimNo);
         // add by zhouliu end 2006-6-12 
        
      } else if(printType.equals("PropList")){//11.�Ʋ���ʧȷ����
        claimPrintViewHelper.getPropList(httpServletRequest,claimNo);
      } else if(printType.equals("Compensate")){//12.��������
        claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      } else if(printType.equals("CompensateAdd")){//13.�������鸽ҳ
        claimPrintViewHelper.getCompensateAdd(httpServletRequest,compensateNo);
      } else if(printType.equals("PayStatList")){//14.���ͳ����ϸ��
        claimPrintViewHelper.getPayStatList(httpServletRequest,caseNo);
      } else if(printType.equals("Drawnotice")){//15.��ȡ���֪ͨ��
        claimPrintViewHelper.getDrawnotice(httpServletRequest,compensateNo);
      } else if(printType.equals("Prepay")){//16.Ԥ�����������
        claimPrintViewHelper.getPrepay(httpServletRequest,preCompensateNo);
      } else if(printType.equals("Pressnotice")){//17.ע��/���ⰸ��֪ͨ�� modify by zhuly 20051111
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("ClaimRefuse")){//23.ע��(����)����֪ͨ��
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("PressnoticeEnd")){//17.�᰸�߸�֪ͨ��
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("Endcase")){ //18.�᰸������
        claimPrintViewHelper.getEndcase(httpServletRequest,claimNo);
      } else if(printType.equals("EndcaseAdd")){ //18.�᰸�����鸽ҳ
        claimPrintViewHelper.getEndcase(httpServletRequest,claimNo);
      } else if(printType.equals("HistoryFile")){//19.ԭʼ����������ǰ����
        claimPrintViewHelper.getHistoryFile(httpServletRequest,policyNo);
        
      //************************************************************************ 
      } else if(printType.equals("FileOnRisk")){//20.����ʱ����
       
      	claimPrintViewHelper.getFileOnRisk(httpServletRequest,policyNo);
      
        
        //*********************************************************************
        
      }else if(printType.equals("HistoryPolicy")){//21 ԭʼ����
        claimPrintViewHelper.getHistoryPolicy(httpServletRequest,policyNo);
      }else if(printType.equals("HistoryEndorse")){//22
        claimPrintViewHelper.getHistoryEndorse(httpServletRequest,policyNo);
      }else if(printType.equals("Check")){//23���ֳ��鿱��¼ add by wuxiaodong 050916�����ղ鿱���� modify by zhuly 20051107
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);
      }else if(printType.equals("DAAPilfer")){//23�����յ����ղ鿱���� add by zhuly 20051107
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);    
      }else if(printType.equals("DAAClaimDocument")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //������������������Ͻ��ӵ� add by zhuly 20051109 
      }else if(printType.equals("PersonLoss")){//24����Ա���������嵥 add by wuxiaodong 050916
        claimPrintViewHelper.getPersonList(httpServletRequest,claimNo);
      }else if(printType.equals("FreightNationalCompensate")){//���ڻ��������������
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightInportCompensate")){//���ڻ��������������
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightExportCompensate")){//���ڻ��������������
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightRefuseCancel")){//�����վ���/ע������֪ͨ��
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      }else if(printType.equals("PropLocalCheck")){//�Ʋ����ֳ��鿱����
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);
      }else if(printType.equals("LiabCompensate")){//���������������
        claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightHeresyCheck")){//�����մ��鿱ί����
      	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }else if(printType.equals("HeresyCheckSubmit")){//�����������մ��鿱ί����
      	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }
      //add by caopeng start 2005-12-2
      else if(printType.equals("IndemnityReceipt")){//������������վ�
    	  String printNo   = httpServletRequest.getParameter("printNo");  //��ӡ��֤����ˮ��
    	  String ret = claimPrintViewHelper.getIndemnityReceiptAndUsedVisa(httpServletRequest,compensateNo,printNo);
      }
      //add by caopeng end 2005-12-2
      //add by caopeng start 2005-12-6
      else if(printType.equals("ClaimNotice")){
         	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //������������������֪
      }
      else if(printType.equals("InvesNotes")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //�����������յ��鱨������¼
      }
      else if(printType.equals("RobInvesNotes")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //�����յ����¼
      }
      else if(printType.equals("ClaimApply")){
         	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //����������
      }
      else if(printType.equals("PersonDamageInvesReport")){
       	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //���˵��鱨��
     }
      else if(printType.equals("PersonDamageInvesNotes")){
       	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //���˵����¼
     }
      else if(printType.equals("RefuseCancelReport")){
          claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);//ע��/���ⰸ������
      }
       else if(printType.equals("AccidentTotalLossCard")){
          claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);//�¹ʳ���ȫ��
      }
       else if(printType.equals("IndemnityNotice")){//�����������֪ͨ��
          claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }
       else if(printType.equals("PrepareIndemnityExamineCard")){//Ԥ�����ͨ���⸶������
          claimPrintViewHelper.getPrepareIndemnity(httpServletRequest,compensateNo);
      }
       else if(printType.equals("AuthorizationTrustBook")){//��Ȩί����
          claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }
       else if(printType.equals("AccidentPhotoCard")){//�¹���Ƭճ����
           claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);
      }
       else if(printType.equals("OriginNoteCard")){//ԭʼ��֤ճ��ҳ
           claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);
       }
       //add by caopeng end 2005-12-9
	  //modify by wangli add start 20050330
	  //reason:���Ӽ��鶨�𱨸�
      else if(printType.equals("CheckCertainLoss")){
        claimPrintViewHelper.getCheckCertainLoss(httpServletRequest,claimNo);
      }
	  //modify by wangli add end 20050330
      //reason:��ӷǳ��յ�һЩ��ӡ
      if (printType.equals("FreightCompensate")) {               //1.��������������
      	  claimPrintViewHelper.getCompensate(httpServletRequest, compensateNo);
      } else if (printType.equals("FreightCompensateNotice")) {  //2.�������ⰸ�սᱨ����
          claimPrintViewHelper.getCanceltrans(httpServletRequest, compensateNo);
      } else if (printType.equals("FreightDamageNotice")) {      //3.�����ճ���֪ͨ��
      	  claimPrintViewHelper.getRegist(httpServletRequest, compensateNo);
      }  else if (printType.equals("ClaimDispose")) {            //4.���⴦����
      	 claimPrintViewHelper.getPilfer(httpServletRequest, claimNo);
      }

      if (printType.equals("CopyPrint")) {
      	  claimPrintViewHelper.getRegist(httpServletRequest,compensateNo);
      }

	  //modify by luqin add end 2005-06-16 start
      if (printType.equals("PropCancelNotice")){
      	  claimPrintViewHelper.getPropCancelNotice(httpServletRequest,claimNo);
      }
      if (printType.equals("PropCompensate")){
    	  claimPrintViewHelper.getPropCompensate(httpServletRequest,compensateNo);
      }
      if (printType.equals("AcciReview")){
    	  claimPrintViewHelper.getAcciReview(httpServletRequest,compensateNo);
      }
      if (printType.equals("AcciCancelNotice")){
      	  claimPrintViewHelper.getAcciCancelNotice(httpServletRequest,claimNo);
      }
      if (printType.equals("ShipCopyPrint")){
      	  claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }
      //modify by luqin add end 2005-06-16 start

      //modify by dongchengliang add start 20050615
       else if (printType.equals("AcciCheck")) {		  //�����⽡�յĵ��鱨��
	     claimPrintViewHelper.getAcciCheck(httpServletRequest, compensateNo);
      }else if (printType.equals("LocalCheck")) {               //6.�ֳ��鿱����
      	     claimPrintViewHelper.getAcciCheck(httpServletRequest, compensateNo);
      }
      //modify by dongchengliang add start 20050616
      else if (printType.equals("ShipEndcase")) {		  //���Ӵ����յĽ᰸����
             DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
	     dAAEndcaseViewHelper.endcaseDtoView(httpServletRequest, claimNo);
      }
      else if (printType.equals("PropCompensateNotice")) {		  //���ӲƲ��յ��ⰸ֪ͨ
		  claimPrintViewHelper.getPropCompensateNotice(httpServletRequest, compensateNo);
      }
      else if (printType.equals("AcciNotClaim")) {		        //�����⽡�ղ�������֪ͨ��
		  claimPrintViewHelper.getAcciNotClaim(httpServletRequest, registNo);
      }else if (printType.equals("FreightCheckReport")) {       //4.�����ղ鿱����
      	  claimPrintViewHelper.getShipCheck(httpServletRequest,registNo );
      }
      //modify by dongchengliang add end 20050616
      //modify by hanliang add start 2005-12-12
        else if (printType.equals("LiabLocaleCheck")) {         //�������ֳ��鿱����
      	  claimPrintViewHelper.getCheck(httpServletRequest, registNo);
      }
        else if (printType.equals("PropLocaleHeresy")) {         //�������ֳ��鿱����
        	  claimPrintViewHelper.getCheck(httpServletRequest, registNo);
        }
        else if(printType.equals("PropLocaleHeresy")){//�Ʋ��մ��鿱ί����
          	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
        }   
      //add by hanliang add start 2005-12-14
        else if(printType.equals("FreightClaimApply")){//����������������
          	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
        }   

      //add by hanliang add start 2005-12-14
		//modify by hanliang add end 2005-12-12
      if (printType.equals("ReparationsList")) {                 //�⽡������������ӡ
      	  claimPrintViewHelper.getAcciReparationsList(httpServletRequest, compensateNo);
      }
      //add by caopeng start at 2005-12-13
      else if (printType.equals("ClaimDocumentHandinCredence")) {                 //�����������ļ�����ƾ֤��ӡ
      	  claimPrintViewHelper.getLossSimple(httpServletRequest, claimNo);
      }
      else if (printType.equals("InvesReport")) {		  //�⽡��������鱨��
 	     claimPrintViewHelper.getAcciCheck(httpServletRequest, registNo);
      }
      else if (printType.equals("CompensateAuditBook")) {		  //���������
  	     claimPrintViewHelper.getCompensate(httpServletRequest, compensateNo);
       }
      //add by caopeng end at 2005-12-13
      
      //add by zhaolu start at 2006-06-12
      else if(printType.equals("PromisesFeeForService")){   //��ŵ֧��ҽ�Ʒ��õ�������ӡ
      	 claimPrintViewHelper.getCheck(httpServletRequest,registNo);
      	}
      //add by zhaolu end at 2006-06-12
      if(printType.equals("CompensateHosp")){
    	  claimPrintViewHelper.getCompensateHosp(httpServletRequest,compensateNo);
      }
      if(printType.equals("AgriCompensate")){
    	  claimPrintViewHelper.getAgriCompensate(httpServletRequest,compensateNo);
      }
      //add by kangzhen 070129 start
      if(printType.equals("ReduceAmountEndorse")){//����������Ĵ�ӡ
    	  claimPrintViewHelper.getReduce(httpServletRequest, compensateNo);
      }
      //add by kangzhen 070129 end
      
      //add by miaowenjun 20070130 start
      if(printType.equals("AgriRegist")){//ũ�մ�����
    	  claimPrintViewHelper.getRegist(httpServletRequest, compensateNo);
      }
      //add by miaowenjun 20070130 end
      
      //add by sinosoft 20070524 begin
      //reason:���ⲹ�䱣�Ѵ�ӡ
      if(printType.equals("AddPremium")){
    	  claimPrintViewHelper.getReduce(httpServletRequest, compensateNo);
      }
      //add by sinosoft 20070524 end
      
      if(printType.equals("timeListing")){
    	  claimPrintViewHelper.getTimeListing(httpServletRequest,startDate,endDate);
      }
      if (printType.equals("CoverPrint")) {		  //ũ���ⰸ���ڷ����ӡ
          httpServletRequest.setAttribute("CompensateNo", compensateNo);
        }
      //add by machunming 20070604 ���ƴ�ӡ��ť�Ƿ���ʾ
      httpServletRequest.setAttribute("PaymentFlag", strPaymentFlag);
      
      forward=printType;
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionMessages msgs = new ActionMessages();
      ActionMessage msg = new ActionMessage("title.certifyPrint.info");
      msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, msgs);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionMessages msgs = new ActionMessages();
      ActionMessage msg = new ActionMessage("title.certifyPrint.info");
      msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, msgs);
      forward = "error";
    }
    return actionMapping.findForward(forward);
  }

}

