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
 * 分发HTTP GET 立案查询
 * <p>Title: 车险理赔立案查询信息</p>
 * <p>Description: 车险理赔立案立案查询信息系统</p>
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


    //业务类型：ADD-新增  EDIT-修改  SHOW-显示 
    String printType   = httpServletRequest.getParameter("printType");  //打印类型
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
    String claimNo   = httpServletRequest.getParameter("ClaimNo") ; //赔案号
    String registNo = httpServletRequest.getParameter("RegistNo") ; //报案号
    String compensateNo = httpServletRequest.getParameter("CompensateNo") ; //计算书号
    String preCompensateNo = httpServletRequest.getParameter("PreCompensateNo") ; //计算书号
    String caseNo = httpServletRequest.getParameter("CaseNo") ; //赔案案号
    String lossItemCode = httpServletRequest.getParameter("lossItemCode") ; //赔案案号
    String strPaymentFlag  = httpServletRequest.getParameter("PaymentFlag"); //控制打印按钮是否显示
    String startDate = httpServletRequest.getParameter("startDate");
    String endDate = httpServletRequest.getParameter("endDate");
   //HttpSession session = httpServletRequest.getSession();
    //User    user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                         //险种
    UICodeAction uiCodeAction = new UICodeAction();
    String strRiskCode = "";
	String strRiskType = "";
	
	//查询信息---打印页面添加信息
	BLPrpLinjuryFacadeBase bLPrpLinjuryFacadeBase = new BLPrpLinjuryFacadeBase();
	PrpLinjuryPersonDto prpLinjuryPersonDto = new PrpLinjuryPersonDto();
	prpLinjuryPersonDto = bLPrpLinjuryFacadeBase.findByPrimaryKey(compensateNo);
	/***************************增加出险人详细信息********************************/
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
    
    
    String forward  = "";                                          //向前
    try
    {
     ClaimPrintViewHelper claimPrintViewHelper = new ClaimPrintViewHelper();
      //打印
      if (printType.equals("Regist")){ //1.报案记录（代抄单）
        /*
        DAARegistViewHelper dAARegistViewHelper=new DAARegistViewHelper ();
        dAARegistViewHelper.setRegistDtoView(httpServletRequest,registNo);*/
        claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      } else if(printType.equals("Pilfer")){   //2.出险（盗抢）证明
        claimPrintViewHelper.getPilfer(httpServletRequest,claimNo);
      } else if(printType.equals("Cancelnotice")){ //3.拒赔通知书
        claimPrintViewHelper.getCancelnotice(httpServletRequest,claimNo);
      } else if(printType.equals("Canceltrans")){//4.拒赔案件报告书
        claimPrintViewHelper.getCanceltrans(httpServletRequest,claimNo);
      } else if(printType.equals("LossSimple")){ //5.损失情况简易确认书
        claimPrintViewHelper.getLossSimple(httpServletRequest,claimNo);
      } else if(printType.equals("Loss")){ //6.损失情况确认书
        claimPrintViewHelper.getLoss(httpServletRequest,claimNo,registNo);
      } else if(printType.equals("LossPrint")){
    	  claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      //modify 20060302************************************************
      } else if(printType.equals("ComponentList")||printType.equals("CetainLossList")){//7.零部件更换项目清单
      	 claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("ComponentListPrint")){//9.修理项目清单  //modify 20060302 打印
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      } else if(printType.equals("CetainLossListPrint")||printType.equals("CetainLossListDetail")){
          claimPrintViewHelper.getCetainLossList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
      }else if(printType.equals("ComponentAdd")){ //8.零部件更换项目清单附表
      	claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("ComponentAddPrint")){//9.修理项目清单  //modify 20060302 打印
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
    
        
      } else if(printType.equals("RepairList")){//9.修理项目清单  //modify 20060302
      	
        claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
      } else if(printType.equals("RepairListPrint")){//9.修理项目清单  //modify 20060302 打印
      	
        claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType);
        
      } else if(printType.equals("RepairAdd")){ //10.修理项目清单附表
      	 claimPrintViewHelper.getRepairCarList(httpServletRequest,registNo,printType);
       // claimPrintViewHelper.getRepairAdd(httpServletRequest,claimNo);
      } else if(printType.equals("RepairAddPrint")){ //10.修理项目清单附表
      	 claimPrintViewHelper.getList(httpServletRequest,registNo,claimNo,lossItemCode,printType); 
        
      //****************************************************************
      	  // add by zhouliu start 2006-6-12
         //
         } else if(printType.equals("Cancelcompel")){
       	 claimPrintViewHelper.getPilfer(httpServletRequest,claimNo);
         // add by zhouliu end 2006-6-12 
        
      } else if(printType.equals("PropList")){//11.财产损失确认书
        claimPrintViewHelper.getPropList(httpServletRequest,claimNo);
      } else if(printType.equals("Compensate")){//12.赔款计算书
        claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      } else if(printType.equals("CompensateAdd")){//13.赔款计算书附页
        claimPrintViewHelper.getCompensateAdd(httpServletRequest,compensateNo);
      } else if(printType.equals("PayStatList")){//14.赔款统计明细表
        claimPrintViewHelper.getPayStatList(httpServletRequest,caseNo);
      } else if(printType.equals("Drawnotice")){//15.领取赔款通知书
        claimPrintViewHelper.getDrawnotice(httpServletRequest,compensateNo);
      } else if(printType.equals("Prepay")){//16.预付赔款审批表
        claimPrintViewHelper.getPrepay(httpServletRequest,preCompensateNo);
      } else if(printType.equals("Pressnotice")){//17.注销/拒赔案件通知书 modify by zhuly 20051111
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("ClaimRefuse")){//23.注销(拒赔)案件通知书
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("PressnoticeEnd")){//17.结案催告通知书
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      } else if(printType.equals("Endcase")){ //18.结案报告书
        claimPrintViewHelper.getEndcase(httpServletRequest,claimNo);
      } else if(printType.equals("EndcaseAdd")){ //18.结案报告书附页
        claimPrintViewHelper.getEndcase(httpServletRequest,claimNo);
      } else if(printType.equals("HistoryFile")){//19.原始保单及出险前批单
        claimPrintViewHelper.getHistoryFile(httpServletRequest,policyNo);
        
      //************************************************************************ 
      } else if(printType.equals("FileOnRisk")){//20.出险时保单
       
      	claimPrintViewHelper.getFileOnRisk(httpServletRequest,policyNo);
      
        
        //*********************************************************************
        
      }else if(printType.equals("HistoryPolicy")){//21 原始保单
        claimPrintViewHelper.getHistoryPolicy(httpServletRequest,policyNo);
      }else if(printType.equals("HistoryEndorse")){//22
        claimPrintViewHelper.getHistoryEndorse(httpServletRequest,policyNo);
      }else if(printType.equals("Check")){//23　现场查勘记录 add by wuxiaodong 050916　车险查勘报告 modify by zhuly 20051107
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);
      }else if(printType.equals("DAAPilfer")){//23　车险盗抢险查勘报告 add by zhuly 20051107
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);    
      }else if(printType.equals("DAAClaimDocument")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //机动车辆保险索赔材料交接单 add by zhuly 20051109 
      }else if(printType.equals("PersonLoss")){//24　人员伤亡费用清单 add by wuxiaodong 050916
        claimPrintViewHelper.getPersonList(httpServletRequest,claimNo);
      }else if(printType.equals("FreightNationalCompensate")){//国内货运险赔款理算书
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightInportCompensate")){//进口货运险赔款理算书
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightExportCompensate")){//出口货运险赔款理算书
      	claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightRefuseCancel")){//货运险拒赔/注销案件通知书
        claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);
      }else if(printType.equals("PropLocalCheck")){//财产险现场查勘报告
        claimPrintViewHelper.getCheck(httpServletRequest,registNo);
      }else if(printType.equals("LiabCompensate")){//责任险赔款理算书
        claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }else if(printType.equals("FreightHeresyCheck")){//货运险代查勘委托书
      	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }else if(printType.equals("HeresyCheckSubmit")){//机动车辆保险代查勘委托书
      	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }
      //add by caopeng start 2005-12-2
      else if(printType.equals("IndemnityReceipt")){//机动车辆赔款收据
    	  String printNo   = httpServletRequest.getParameter("printNo");  //打印单证的流水号
    	  String ret = claimPrintViewHelper.getIndemnityReceiptAndUsedVisa(httpServletRequest,compensateNo,printNo);
      }
      //add by caopeng end 2005-12-2
      //add by caopeng start 2005-12-6
      else if(printType.equals("ClaimNotice")){
         	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //机动车辆保险索赔须知
      }
      else if(printType.equals("InvesNotes")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //机动车辆保险调查报告调查笔录
      }
      else if(printType.equals("RobInvesNotes")){
       	claimPrintViewHelper.getRegist(httpServletRequest,registNo); //盗抢险调查笔录
      }
      else if(printType.equals("ClaimApply")){
         	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //索赔申请书
      }
      else if(printType.equals("PersonDamageInvesReport")){
       	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //人伤调查报告
     }
      else if(printType.equals("PersonDamageInvesNotes")){
       	claimPrintViewHelper.getCheck(httpServletRequest,registNo); //人伤调查笔录
     }
      else if(printType.equals("RefuseCancelReport")){
          claimPrintViewHelper.getPressnotice(httpServletRequest,claimNo);//注销/拒赔案件报告
      }
       else if(printType.equals("AccidentTotalLossCard")){
          claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);//事故车辆全损单
      }
       else if(printType.equals("IndemnityNotice")){//机动车辆赔款通知书
          claimPrintViewHelper.getCompensate(httpServletRequest,compensateNo);
      }
       else if(printType.equals("PrepareIndemnityExamineCard")){//预付赔款通融赔付审批单
          claimPrintViewHelper.getPrepareIndemnity(httpServletRequest,compensateNo);
      }
       else if(printType.equals("AuthorizationTrustBook")){//授权委托书
          claimPrintViewHelper.getRegist(httpServletRequest,registNo);
      }
       else if(printType.equals("AccidentPhotoCard")){//事故照片粘贴单
           claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);
      }
       else if(printType.equals("OriginNoteCard")){//原始单证粘贴页
           claimPrintViewHelper.getRepairList(httpServletRequest,claimNo);
       }
       //add by caopeng end 2005-12-9
	  //modify by wangli add start 20050330
	  //reason:增加检验定损报告
      else if(printType.equals("CheckCertainLoss")){
        claimPrintViewHelper.getCheckCertainLoss(httpServletRequest,claimNo);
      }
	  //modify by wangli add end 20050330
      //reason:添加非车险的一些打印
      if (printType.equals("FreightCompensate")) {               //1.货运险赔款计算书
      	  claimPrintViewHelper.getCompensate(httpServletRequest, compensateNo);
      } else if (printType.equals("FreightCompensateNotice")) {  //2.货运险赔案终结报告书
          claimPrintViewHelper.getCanceltrans(httpServletRequest, compensateNo);
      } else if (printType.equals("FreightDamageNotice")) {      //3.货运险出险通知书
      	  claimPrintViewHelper.getRegist(httpServletRequest, compensateNo);
      }  else if (printType.equals("ClaimDispose")) {            //4.理赔处理报告
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
       else if (printType.equals("AcciCheck")) {		  //增加意健险的调查报告
	     claimPrintViewHelper.getAcciCheck(httpServletRequest, compensateNo);
      }else if (printType.equals("LocalCheck")) {               //6.现场查勘报告
      	     claimPrintViewHelper.getAcciCheck(httpServletRequest, compensateNo);
      }
      //modify by dongchengliang add start 20050616
      else if (printType.equals("ShipEndcase")) {		  //增加船货险的结案报告
             DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
	     dAAEndcaseViewHelper.endcaseDtoView(httpServletRequest, claimNo);
      }
      else if (printType.equals("PropCompensateNotice")) {		  //增加财产险的赔案通知
		  claimPrintViewHelper.getPropCompensateNotice(httpServletRequest, compensateNo);
      }
      else if (printType.equals("AcciNotClaim")) {		        //增加意健险不予立案通知书
		  claimPrintViewHelper.getAcciNotClaim(httpServletRequest, registNo);
      }else if (printType.equals("FreightCheckReport")) {       //4.货运险查勘报告
      	  claimPrintViewHelper.getShipCheck(httpServletRequest,registNo );
      }
      //modify by dongchengliang add end 20050616
      //modify by hanliang add start 2005-12-12
        else if (printType.equals("LiabLocaleCheck")) {         //责任险现场查勘报告
      	  claimPrintViewHelper.getCheck(httpServletRequest, registNo);
      }
        else if (printType.equals("PropLocaleHeresy")) {         //责任险现场查勘报告
        	  claimPrintViewHelper.getCheck(httpServletRequest, registNo);
        }
        else if(printType.equals("PropLocaleHeresy")){//财产险代查勘委托书
          	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
        }   
      //add by hanliang add start 2005-12-14
        else if(printType.equals("FreightClaimApply")){//货运险索赔申请书
          	claimPrintViewHelper.getRegist(httpServletRequest,registNo);
        }   

      //add by hanliang add start 2005-12-14
		//modify by hanliang add end 2005-12-12
      if (printType.equals("ReparationsList")) {                 //意健险理赔批单打印
      	  claimPrintViewHelper.getAcciReparationsList(httpServletRequest, compensateNo);
      }
      //add by caopeng start at 2005-12-13
      else if (printType.equals("ClaimDocumentHandinCredence")) {                 //人身险索赔文件交接凭证打印
      	  claimPrintViewHelper.getLossSimple(httpServletRequest, claimNo);
      }
      else if (printType.equals("InvesReport")) {		  //意健险理赔调查报告
 	     claimPrintViewHelper.getAcciCheck(httpServletRequest, registNo);
      }
      else if (printType.equals("CompensateAuditBook")) {		  //理赔审核书
  	     claimPrintViewHelper.getCompensate(httpServletRequest, compensateNo);
       }
      //add by caopeng end at 2005-12-13
      
      //add by zhaolu start at 2006-06-12
      else if(printType.equals("PromisesFeeForService")){   //承诺支付医疗费用担保函打印
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
      if(printType.equals("ReduceAmountEndorse")){//冲减保额批文打印
    	  claimPrintViewHelper.getReduce(httpServletRequest, compensateNo);
      }
      //add by kangzhen 070129 end
      
      //add by miaowenjun 20070130 start
      if(printType.equals("AgriRegist")){//农险代抄单
    	  claimPrintViewHelper.getRegist(httpServletRequest, compensateNo);
      }
      //add by miaowenjun 20070130 end
      
      //add by sinosoft 20070524 begin
      //reason:理赔补充保费打印
      if(printType.equals("AddPremium")){
    	  claimPrintViewHelper.getReduce(httpServletRequest, compensateNo);
      }
      //add by sinosoft 20070524 end
      
      if(printType.equals("timeListing")){
    	  claimPrintViewHelper.getTimeListing(httpServletRequest,startDate,endDate);
      }
      if (printType.equals("CoverPrint")) {		  //农险赔案卷宗封面打印
          httpServletRequest.setAttribute("CompensateNo", compensateNo);
        }
      //add by machunming 20070604 控制打印按钮是否显示
      httpServletRequest.setAttribute("PaymentFlag", strPaymentFlag);
      
      forward=printType;
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
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

