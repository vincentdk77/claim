package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLCertainLossFacade;
import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLctextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLUwNotionFacade;
import com.sinosoft.claim.bl.facade.BLWfLogFacade;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.dto.custom.HospTimeListingDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLhospitalizationPayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIIndemnityReceiptAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIVisaAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.dto.domain.UwNotionDto;
import com.sinosoft.undwrt.dto.domain.WfLogDto;
import com.sinosoft.visa.dto.custom.CodeNameDto;

/** 
 * <p>
 * Title: ClaimStatusViewHelper
 * </p> 
 * <p>
 * Description:理赔节点状态ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 *
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class ClaimPrintViewHelper {
	private Log log = LogFactory.getLog(ClaimPrintViewHelper.class);
	private UIIndemnityReceiptAction uiIndemnityReceiptAction = new UIIndemnityReceiptAction();
	private UICompensateAction uiCompensateAction = new UICompensateAction();
	/**
	 * 默认构造方法
	 */
	public ClaimPrintViewHelper() {
	}
	
	/**
	 * 1 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getRegist(HttpServletRequest httpServletRequest, String registNo)
	throws Exception {
		// 取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		UICodeAction uiCodeAction = new UICodeAction();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto =  new PolicyDto();
		//add by zhaolu 20060902 start
		//关联保单加上BZ险
		String riskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		String prpLRegistRPolicyNo = "";
		if("RISKCODE_DAZ".equals(riskType) == false&&"RISKCODE_DAY".equals(riskType) == false
				&&"RISKCODE_DAU".equals(riskType) == false)
		{
			if(registDto.getPrpLRegistRPolicyDtoOfCompel() != null && registDto.getPrpLRegistRPolicyList().size()>1){
			  prpLRegistRPolicyNo = registDto.getPrpLRegistRPolicyDtoOfCompel().getPolicyNo();
			  policyDto = endorseViewHelper.findForEndorBefore(prpLRegistRPolicyNo);
			  if (policyDto.getPrpCitemKindDtoList() != null)
			  {
				  
				 ArrayList rPrpCitemKindDtoList = (ArrayList)policyDto.getPrpCitemKindDtoList();
				  httpServletRequest.setAttribute("rPrpCitemKindDto",rPrpCitemKindDtoList);
				  
               }
			}
		}
		//add by zhaolu 20060902 end
		if (registDto != null) {
			// 保单号码
			String policyNo = "";
			if (registDto.getPrpLregistDto() != null) {
				policyNo = registDto.getPrpLregistDto().getPolicyNo();
			}
			

		
			
			//代抄单打印还原到出险时保单情况 2005-08-15
			if ("Regist".equals(httpServletRequest.getParameter("printType"))||"AgriRegist".equals(httpServletRequest.getParameter("printType"))) {
				String strDamageStartDate = String.valueOf(registDto.getPrpLregistDto().getDamageStartDate());
				String strDamageStartHour = registDto.getPrpLregistDto().getDamageStartHour();
				policyDto = endorseViewHelper.findForEndorBefore(policyNo, strDamageStartDate, strDamageStartHour);
			
			} else { //取得保单的信息
				policyDto = endorseViewHelper.findForEndorBefore(policyNo);
				
				if(registDto.getPrplacciBenPersonDtoList()!=null&&registDto.getPrplacciBenPersonDtoList().size()>0)
				{
	    			int intPersonCount = 0;
	    			int intFamilyNo = 0;
	    			int intItemKindNo = 0;
	    			String strPolicyno = "";
	    			String strItemKindQueryCon= "";
	    			PrpLacciPersonDto  prpLacciPersonDto = null;
	    			PrpCitemKindDto   prpCitemKindDto1 = null;
	    			BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
	    			ArrayList benPersonKindList =  new ArrayList();
	    			ArrayList prpCitemKindDtoCopyList = new ArrayList();
	    			String strRiskCode = registDto.getPrpLregistDto().getRiskCode();
	    			String strModel = "";
	    			String strFamilyName = "";
	    			String strInsuredName = "";
	    			intPersonCount = registDto.getPrplacciBenPersonDtoList().size();
	    			for(int j=0;j<intPersonCount;j++){
	    				prpLacciPersonDto =  (PrpLacciPersonDto)registDto.getPrplacciBenPersonDtoList().get(j);
	    				intFamilyNo = prpLacciPersonDto.getFamilyNo();
	    				strPolicyno = prpLacciPersonDto.getPolicyNo();
	    				strModel = prpLacciPersonDto.getAddress();//牛号
	    				strFamilyName = prpLacciPersonDto.getAcciName();
	    				if(j+1==intPersonCount){
	    					strInsuredName = strInsuredName+strFamilyName;
	    				}else{
	    					strInsuredName = strInsuredName+strFamilyName+"、";	
	    				}
	    				
	    				//根据安信理赔的特殊情况，在理算取保单信息时直接取当时最新保单信息，不进行倒批单
	    				if("3202".equals(strRiskCode)){
	    					strItemKindQueryCon = " policyno = '"+strPolicyno+"' and model = '"+strModel+"'";
	    				}else{
	    					strItemKindQueryCon = " policyno = '"+strPolicyno+"' and familyno = "+intFamilyNo;	
	    				}
	    				
	    				benPersonKindList = (ArrayList)blPrpCitemKindFacade.findByConditions(strItemKindQueryCon);
	    				if(benPersonKindList!=null&&benPersonKindList.size()>0){
	    					for(int m=0;m<benPersonKindList.size();m++){
	    						prpCitemKindDto1  = (PrpCitemKindDto)benPersonKindList.get(m);
	    						prpCitemKindDtoCopyList.add(prpCitemKindDto1);
	    					}
	    					
	    				}
	    			}
	    			policyDto.setPrpCitemKindDtoList(prpCitemKindDtoCopyList);
	    			if("3202".equals(strRiskCode)){
    				}else{
    					policyDto.getPrpCmainDto().setInsuredName(strInsuredName);//对于团单，被保险人取自出险者中选择的被保险人	
    				}
	    			
	    			
	    		}
				
			}
			// 进行代码转换
			
			//add by miaowenjun 20070130 start
			if ("AgriRegist".equals(httpServletRequest.getParameter("printType"))) {
				for (Iterator iter = policyDto.getPrpCitemKindDtoList().iterator(); iter.hasNext();) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
					PrpCitemKindAgriDto prpCitemKindAgriDto = new PrpCitemKindAgriDto(); 
					prpCitemKindAgriDto = new BLPrpCitemKindAgriFacade().findByPrimaryKey(policyNo, prpCitemKindDto.getItemKindNo(), prpCitemKindDto.getKindCode());
					prpCitemKindDto.setQuantity(prpCitemKindAgriDto.getGrossQuantity());
				}				
			}
			//add by miaowenjun 20070130 end
			
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if (prpLregistDto != null) {
				prpLregistDto.setReportType(uiCodeAction.translateCodeCode(
						"ReportType", prpLregistDto.getReportType(), true));
				prpLregistDto.setComName(uiCodeAction.translateComCode(
						prpLregistDto.getComCode(), true));
			}
			UIEndorseAction uiEndorseAction = new UIEndorseAction();
			EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
			httpServletRequest.setAttribute("registDto", registDto);
			httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
			httpServletRequest.setAttribute("policyDto", policyDto);
			httpServletRequest.setAttribute("endorseDto", endorseDto);
			// 给报案文件多行列表准备数据
			PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
			String tempContext = "";
			if (registDto.getPrpLregistTextDtoList() != null) {
				Iterator iterator = registDto.getPrpLregistTextDtoList()
				.iterator();
				while (iterator.hasNext()) {
					PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
					.next();
					tempContext = tempContext
					+ prpLregistTextDtoTemp.getContext();
				}
			}
			// prpLregistTextDto =
			// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
			prpLregistTextDto.setContext(tempContext);
			prpLregistTextDto.setTextType("1");
			// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
			httpServletRequest.setAttribute("prpLregistTextDto",
					prpLregistTextDto);
		}
		
	}
	
	/**
	 * 2 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPilfer(HttpServletRequest httpServletRequest, String claimNo)
	throws Exception {
		// 取得立案的信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
		String registNo = claimDto.getPrpLclaimDto().getRegistNo();
		// 取得保单的信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		// 取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("claimDto", claimDto);
		httpServletRequest.setAttribute("policyDto", policyDto);
		// 给报案文件多行列表准备数据
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (registDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
				.next();
				tempContext = tempContext + prpLregistTextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
	}
	
	/**
	 * 3 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCancelnotice(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		// 取得立案的信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		httpServletRequest.setAttribute("claimDto", claimDto);
		
	}
	
	/**
	 * 4 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCanceltrans(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		// 取得立案的信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
		String registNo = claimDto.getPrpLclaimDto().getRegistNo();
		// 取得保单的信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		// 取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("claimDto", claimDto);
		httpServletRequest.setAttribute("policyDto", policyDto);
		
	}
	
	/**
	 * 5 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getLossSimple(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		// 进行代码转换
		UICodeAction uiCodeAction = new UICodeAction();
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);
		// 取得立案的信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
		// 取得保单的信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		// 取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction
		.findByPrimaryKey(registNo);
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("claimDto", claimDto);
		httpServletRequest.setAttribute("checkDto", checkDto);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		// modify by zhaozhuo add 20050412 start
		// reason: 取得实赔信息
		CompensateDto compensateDto = new CompensateDto();
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		// modify by zhaozhuo add 20050412 end
	}
	
 
	public void getLossSimple(HttpServletRequest httpServletRequest,
			String claimNo,String registNo) throws Exception {
		
		if (!(  claimNo==null ||  claimNo.equals(""))) { //claimNo
		 	   
				UICodeAction uiCodeAction = new UICodeAction();
			    registNo = uiCodeAction.translateBusinessCode(claimNo, false);
	            
			    //取得立案的信息
			    UIClaimAction uiClaimAction = new UIClaimAction();
				ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
				httpServletRequest.setAttribute("claimDto", claimDto);
			 }
       //取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		 
       //取得保单的信息
		String policyNo = registDto.getPrpLregistDto().getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		//定损信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction
		.findByPrimaryKey(registNo);
		
		//查勘信息
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
	
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("checkDto", checkDto);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		CompensateDto compensateDto = new CompensateDto();
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		
	}
	
	
	
	
	
	
	
	//add 200600302 start
	
	public void getLossSimple(HttpServletRequest httpServletRequest,
			String registNo,String claimNo,String lossItemCode,String printType) throws Exception {
		
		if (!(  claimNo==null ||  claimNo.equals(""))) { //claimNo
	 	   
			UICodeAction uiCodeAction = new UICodeAction();
		    registNo = uiCodeAction.translateBusinessCode(claimNo, false);
            
		    //取得立案的信息
		    UIClaimAction uiClaimAction = new UIClaimAction();
			ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
			httpServletRequest.setAttribute("claimDto", claimDto);
		 }
	    
		 
	     	//取得报案的信息
		    UIRegistAction uiRegistAction = new UIRegistAction();
		    RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		    
		    
            // 取得保单的信息
		    String policyNo = registDto.getPrpLregistDto().getPolicyNo();
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		  
			//定损信息
			UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		    CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo,lossItemCode);
		
   	        //查勘信息
		    UICheckAction uiCheckAction = new UICheckAction();
			CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo); 
		    
	    	httpServletRequest.setAttribute("registDto", registDto);
		    httpServletRequest.setAttribute("checkDto", checkDto);
		    httpServletRequest.setAttribute("policyDto", policyDto);
		    httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		    httpServletRequest.setAttribute("printType", printType);
		   
		    // reason: 取得实赔信息
		    CompensateDto compensateDto = new CompensateDto();
		    httpServletRequest.setAttribute("compensateDto", compensateDto);
	
	}
	
	public void getCertainList(HttpServletRequest httpServletRequest,
			String registNo ,String printType) throws Exception {
		// 进行代码转换
		UICodeAction uiCodeAction = new UICodeAction();
		//String registNo = uiCodeAction.translateBusinessCode(claimNo, false);
		//获取定损信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo);
		
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		httpServletRequest.setAttribute("printType", printType);
		
	}
	public void getCertainList(HttpServletRequest httpServletRequest,
			String registNo ,String lossItemCode,String printType) throws Exception {
		// 进行代码转换
		UICodeAction uiCodeAction = new UICodeAction();
		//String registNo = uiCodeAction.translateBusinessCode(claimNo, false);
		//获取定损信息
		BLCertainLossFacade blCertainLossFacade = new BLCertainLossFacade();
		BLPrpLregistFacade blPrpLregistFacade =  new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		CertainLossDto certainLossDto = blCertainLossFacade.findByPrimaryKey(registNo,lossItemCode);
		RegistDto  registDto = new RegistDto();
        BLPrpLRegistRPolicyFacade facade = new BLPrpLRegistRPolicyFacade();
		registDto.setPrpLRegistRPolicyList((List) facade.findByRegistNo(registNo));
        httpServletRequest.setAttribute("prpLregistRPolicyNoBz",registDto.getPrpLRegistRPolicyBZ());
        httpServletRequest.setAttribute("prpLregistRPolicyNoBu",registDto.getPrpLRegistRPolicyBusiness());
		
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
		httpServletRequest.setAttribute("printType", printType);
		
	}
	//add 200600302 end 
	
	/**
	 * 6 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getLoss(HttpServletRequest httpServletRequest, String claimNo,String registNo)
	throws Exception {
		getLossSimple(httpServletRequest,claimNo, registNo);
	}
	
	/**
	 * 7 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getComponentList(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	/**
	 * 8 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getComponentAdd(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	/**
	 * 9 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getRepairList(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	} 
	//add by liuyanmei 20060302 atart
	public void getList(HttpServletRequest httpServletRequest,
			String registNo,String claimNo,String lossItemCode,String printType) throws Exception {
		getLossSimple(httpServletRequest, registNo,claimNo,lossItemCode,printType);
	}
	public void getCetainLossList(HttpServletRequest httpServletRequest,
			String registNo,String claimNo,String lossItemCode,String printType) throws Exception {
		getCertainList(httpServletRequest, registNo,lossItemCode,printType);
	}
	
	public void getRepairCarList(HttpServletRequest httpServletRequest,
			String registNo,String printType) throws Exception {
		getCertainList(httpServletRequest, registNo,printType);  //modify 20060302
	}
	//add by liuyanmei 20060302 end
	/**
	 * 10 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getRepairAdd(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	/**
	 * 11 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPropList(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	/**
	 * 12 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCompensate(HttpServletRequest httpServletRequest,
			String compensateNo) throws Exception {
		
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		
		//add by miaowenjun 20060519  获取1级到5级核赔人意见
		String flowId = "";
		int logno;
		List wflogDtoList = (ArrayList)new BLWfLogFacade().findByConditions("select * from wflog where businessno='"+compensateNo+"'");
		List uwNotionDtoList = new ArrayList();
		UwNotionDto uwNotionDto = new UwNotionDto();
		if(wflogDtoList != null && wflogDtoList.size() != 0){
			for(int i=0;i<wflogDtoList.size();i++){
				WfLogDto wflogDto = new WfLogDto();
				wflogDto = (WfLogDto)wflogDtoList.get(i);
				flowId = wflogDto.getFlowID();
				logno = wflogDto.getLogNo();
				List uwNotionDtoListTemp = (ArrayList)new BLUwNotionFacade().findByConditions("flowid='"+flowId+"' and logno="+logno+" ");
				if(uwNotionDtoListTemp != null && uwNotionDtoListTemp.size() != 0){
					uwNotionDto = (UwNotionDto)uwNotionDtoListTemp.get(0);
					uwNotionDtoList.add(uwNotionDto);
				}
			}
		}
		httpServletRequest.setAttribute("wflogDtoList",wflogDtoList);
		httpServletRequest.setAttribute("uwNotionDtoList",uwNotionDtoList);
		//add end by miaowenjun 20060519
		
		//设置PrpLlossDto的kindName
		for (Iterator iter = compensateDto.getPrpLlossDtoList().iterator(); iter.hasNext();) {
			PrpLlossDto lossDto = (PrpLlossDto) iter.next();
			String kindName = new UICodeAction().translateKindCode(lossDto.getRiskCode(), lossDto.getKindCode(), true);
			lossDto.setKindName(kindName);
		}
		
		/**
		 * 取计算过程
		 */
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		String conditions = " compensateno='"+compensateNo+"' and texttype = '1'";
		List prpLctextList = new ArrayList();
		prpLctextList = (ArrayList)new BLPrpLctextFacade().findByConditions(conditions);
		httpServletRequest.setAttribute("prpLctextList",prpLctextList);
		
		/**
		 * 计算PrplLoss表中的损失(SumRealPay)
		 */
		double sumLossRealPay = 0;
		List prplLossList = compensateDto.getPrpLlossDtoList();
		for (Iterator iter = prplLossList.iterator(); iter.hasNext();) {
			PrpLlossDto lossDto = (PrpLlossDto) iter.next();
			if(lossDto!=null){
				sumLossRealPay += lossDto.getSumRealPay();
			}
		}
		compensateDto.getPrpLcompensateDto().setLossSumRealPay(sumLossRealPay);
		
		/**
		 * 计算PrplPersonLoss表中的损失(SumRealPay)
		 */
		double sumPersonLossRealPay = 0;
		List prplPersonList = compensateDto.getPrpLpersonLossDtoList();
		for (Iterator iter = prplPersonList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto personLoss = (PrpLpersonLossDto) iter.next();
			if(personLoss!=null){
				sumPersonLossRealPay += personLoss.getSumRealPay();
			}
		}		
		compensateDto.getPrpLcompensateDto().setPersonLossSumRealPay(sumPersonLossRealPay);
		getLossSimple(httpServletRequest, claimNo);
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		//add by miaowenjun 20070129 start
		httpServletRequest.setAttribute("prplPersonList", prplPersonList);
		//add by miaowenjun 20070129 start
		String policyNo = compensateDto.getPrpLcompensateDto().getPolicyNo();
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("endorseDto",endorseDto);
		// 给报案文件多行列表准备数据
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		String tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
			.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				tempContext = tempContext + prpLctextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		
		/**
		 * 获取收款信息
		 */
		PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = uiIndemnityReceiptAction.findPrpLIndemnityReceiptDtoByBusinessNo(compensateNo);
		if(prpLIndemnityReceiptDto==null){
			prpLIndemnityReceiptDto = new PrpLIndemnityReceiptDto();
			prpLIndemnityReceiptDto.setBusinessNo(compensateNo);
			prpLIndemnityReceiptDto.setPolicyNo(policyNo);
			prpLIndemnityReceiptDto.setInsuredCode(compensateDto.getPrpLcompensateDto().getInsuredCode());
			prpLIndemnityReceiptDto.setInsuredName(compensateDto.getPrpLcompensateDto().getInsuredName());
		}
		httpServletRequest.setAttribute("prpLIndemnityReceiptDto", prpLIndemnityReceiptDto);
		//add by zhaolu 20060912 start
		//判断险别
		String riskCode = compensateDto.getPrpLcompensateDto().getRiskCode();
		UICodeAction uiCodeAction = new UICodeAction();
		String configCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
		httpServletRequest.setAttribute("configCode",configCode);
		//add by zhaolu 20060912 end
		
		/**
		 * 增加理赔计算书需要在赔款支付后才能打印的控制点
		 * added by zhangli 20070423
		 */
		//uiCompensateAction.compensatePaymentResult(httpServletRequest,compensateNo);
		/**added by zhangli 20070520
		    * 增加理算书的核赔通过为其打印控制点;
		    * 适用于除车险类（险类代码为05）、农机具综合保险（险种代码为3119）之外的所有险种。
		    * 仅核赔标志为1时，理算书可以打印。
		*/
		 
		uiCompensateAction.compensateUndwrtFlag(httpServletRequest, compensateNo);
	}
	 
	/**
	 * 13 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCompensateAdd(HttpServletRequest httpServletRequest,
			String compensateNo) throws Exception {
		CompensateDto compensateDto = uiCompensateAction
		.findByPrimaryKey(compensateNo);
		// getLossSimple(httpServletRequest,claimNo);
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		// 给报案文件多行列表准备数据
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		String tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
			.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				tempContext = tempContext + prpLctextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		
	}
	
	/**
	 * 14 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPayStatList(HttpServletRequest httpServletRequest,
			String caseNo) throws Exception {
		
	}
	
	/**
	 * 15 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getDrawnotice(HttpServletRequest httpServletRequest,
			String compensateNo) throws Exception {
		CompensateDto compensateDto = uiCompensateAction
		.findByPrimaryKey(compensateNo);
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		// 给报案文件多行列表准备数据
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		String tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
			.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				tempContext = tempContext + prpLctextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		
	}
	
	/**
	 * 16 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPrepay(HttpServletRequest httpServletRequest,
			String preCompensateNo) throws Exception {
		UIPrepayAction uiPrepayAction = new UIPrepayAction();
		PrepayDto prepayDto = uiPrepayAction.findByPrimaryKey(preCompensateNo);
		String claimNo = prepayDto.getPrpLprepayDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		httpServletRequest.setAttribute("prepayDto", prepayDto);
	}
	
	/**
	 * 17 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPressnotice(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	/**
	 * 18 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getEndcase(HttpServletRequest httpServletRequest, String claimNo)
	throws Exception {
		
		
		/*if( claimNo==null || claimNo.equals("") ) {
			String registNo = httpServletRequest.getParameter("RegistNo");	
			
		}*/
		
		getLossSimple(httpServletRequest, claimNo);
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(claimNo);
		httpServletRequest.setAttribute("endcaseDto", endcaseDto);
		
		String compensateNo = "";
		String conditions =  "claimNo ='"+claimNo.trim()+"'" ;
		ArrayList arrayCompensate = (ArrayList)uiCompensateAction.findByConditions(conditions);
		for(int j = 0;j<arrayCompensate.size();j++){
			PrpLcompensateDto prpLcompensateDto = null;
			prpLcompensateDto = (PrpLcompensateDto)arrayCompensate.get(j);
			compensateNo = prpLcompensateDto.getCompensateNo();
		}
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		httpServletRequest.setAttribute("compensateDto",compensateDto);
		
		// 给报案文件多行列表准备数据
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		String tempContext = "";
		if (endcaseDto.getPrpLltextDtoList() != null) {
			Iterator iterator = endcaseDto.getPrpLltextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
				tempContext = tempContext + prpLltextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLltextDto.setContext(tempContext);
		prpLltextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		
	}
	
	/**
	 * 19 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getHistoryFile(HttpServletRequest httpServletRequest,
			String policyNo) throws Exception {
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
	}
	
	/**
	 * 20 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getFileOnRisk(HttpServletRequest httpServletRequest,
			String policyNo) throws Exception {
		System.out.println("=======policyNo=======||||||****==="+policyNo);
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
		httpServletRequest.setAttribute("policyNo", policyNo);
		
	}
	
	/**
	 * 21 原始保单 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getHistoryPolicy(HttpServletRequest httpServletRequest,
			String policyNo) throws Exception {
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
		
	}
	
	/**
	 * 22 原始批单 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getHistoryEndorse(HttpServletRequest httpServletRequest,
			String policyNo) throws Exception {
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
		
	}
	
	// modify by wangli add start 20050330
	// reason:增加检验定损报告
	
	/**
	 * 23 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCheckCertainLoss(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
		
	}
	// modify by wangli add end 20050330
	
	// modify by dongchengliang add start 20050615
	// reason:增加意健险的调查报告
	/**
	 * 24 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getAcciCheck(HttpServletRequest httpServletRequest,String
			checkNo) throws Exception {
		String registNo  = "";
		String policyNo = "";
		
		UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
		AcciCheckDto acciCheckDto = uiAcciCheckAction.findByPrimaryKey(checkNo);
		PrpLacciCheckDto prpLacciCheckDto = new PrpLacciCheckDto();;
		PrpCmainDto prpCmainDto = new PrpCmainDto();
		if(acciCheckDto != null){
			prpLacciCheckDto = acciCheckDto.getPrpLacciCheckDto();
			if(prpLacciCheckDto != null){
				registNo = prpLacciCheckDto.getRegistNo();
				policyNo = prpLacciCheckDto.getPolicyNo();
				httpServletRequest.setAttribute("prpLacciCheckTextDtoList",
						acciCheckDto.getPrpLacciCheckTextDtoList());
				// 取得保单的信息
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
				
				if(policyDto != null){
					prpCmainDto =policyDto.getPrpCmainDto();
				}
			}
		}
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		httpServletRequest.setAttribute("prpLregistDto", registDto.getPrpLregistDto());
		httpServletRequest.setAttribute("prpCmainDto", prpCmainDto);
		httpServletRequest.setAttribute("prpLacciCheckDto", prpLacciCheckDto);
	}
	/**
	 * 24 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getShipCheck(HttpServletRequest httpServletRequest,String
			checkNo) throws Exception {
		String registNo  = "";
		String policyNo = "";
		
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(checkNo);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();;
		PrpCmainDto prpCmainDto = new PrpCmainDto();
		PrpCmainCargoDto prpCmainCargoDto = new PrpCmainCargoDto();
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		Collection prpCinsuredDtoList = null;
		RegistDto registDto = null;
		if(checkDto != null){
			prpLcheckDto = checkDto.getPrpLcheckDto();
			if(prpLcheckDto != null){
				registNo = prpLcheckDto.getRegistNo();
				UIRegistAction uiRegistAction = new UIRegistAction();
				registDto = uiRegistAction.findByPrimaryKey(registNo);
				if(registDto != null){
					prpLregistDto = registDto.getPrpLregistDto();
				}
				policyNo = prpLcheckDto.getPolicyNo();
				// 取得保单的信息
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
				
				// 进行代码转换
				if(policyDto != null){
					prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
					prpCmainDto =policyDto.getPrpCmainDto();
					prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
				}
			}
		}
		httpServletRequest.setAttribute("prpCmainDto", prpCmainDto);
		httpServletRequest.setAttribute("prpCmainCargoDto", prpCmainCargoDto);
		httpServletRequest.setAttribute("prpCinsuredDtoList", prpCinsuredDtoList);
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	// reason:增加船货险结案报告
	/**
	 * 24 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getShipEndcase(HttpServletRequest httpServletRequest,String
			endcaseNo) throws Exception {
		// 取得报案的信息
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(endcaseNo);
		if(endcaseDto != null){
			Collection prpLcaseNoDtoList = endcaseDto.getPrpLcaseNoDtoList();
			PrpLclaimDto prpLclaimDto = endcaseDto.getPrpLclaimDto();
			Collection PrpLcompensateDtoList = endcaseDto.getPrpLcompensateDtoList();
			Collection PrpLltextDtoList = endcaseDto.getPrpLltextDtoList();
			httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
			httpServletRequest.setAttribute("prpLcaseNoDtoList", prpLcaseNoDtoList);
			httpServletRequest.setAttribute("PrpLcompensateDtoList", PrpLcompensateDtoList);
			httpServletRequest.setAttribute("PrpLltextDtoList", PrpLltextDtoList);
		}
	}
	
	
	// reason:增加财产险赔案通知
	/**
	 * 24 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPropCompensateNotice(HttpServletRequest httpServletRequest,String
			compensateNo) throws Exception {
		// 取得报案的信息
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		if(compensateDto != null){
			PrpLclaimDto prpLclaimDto= compensateDto.getPrpLclaimDto();
			if(prpLclaimDto ==null){
				UIClaimAction uiClaimAction = new UIClaimAction();
				ClaimDto claimDto = uiClaimAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getClaimNo());
				if(claimDto != null){
					prpLclaimDto = claimDto.getPrpLclaimDto();
				}else{
					prpLclaimDto = new PrpLclaimDto();
				}
			}
			PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
			httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
			httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
		}else{
			httpServletRequest.setAttribute("prpLclaimDto", new PrpLclaimDto());
			httpServletRequest.setAttribute("prpLcompensateDto", new PrpLcompensateDto());
			
		}
	}
	
	/** 25
	 * 打印功能画面内容显示.处理意健险不予立案
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getAcciNotClaim(HttpServletRequest httpServletRequest,String registNo) throws Exception
	{
//		UIClaimAction uiClaimAction = new UIClaimAction();
//		String strClaimNo = "";
//		
//		//取得立案的信息
//		ArrayList prpLclaimDtoList = (ArrayList) uiClaimAction.findByConditions(" registNo='" + registNo + "'");
//		if (prpLclaimDtoList != null && prpLclaimDtoList.size() > 0) {
//		PrpLclaimDto prpLclaimDto = (PrpLclaimDto) prpLclaimDtoList.get(0);
//		strClaimNo = prpLclaimDto.getClaimNo();
//		}
//		
//		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(strClaimNo);
//		
//		httpServletRequest.setAttribute("claimDto", claimDto);
//		
////		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
////		PrpCmainDto prpCmainDto = new PrpCmainDto();
//////	PolicyDto policyDto = null;
////		if(claimDto != null && claimDto.getPrpLclaimDto()!= null ){
////		prpLclaimDto = claimDto.getPrpLclaimDto();
//////	UIPolicyAction uiPolicyAction = new UIPolicyAction();
//////	policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimDto.getPolicyNo());
////		String registNo = prpLclaimDto.getRegistNo();
////		
////		if(registDto!=null && registDto.getPrpLacciPersonDto()!=null){
////		prpLclaimDto.setIdentifyNumber(registDto.getPrpLacciPersonDto().getIdentifyNumber());
////		}
////		}
////		httpServletRequest.setAttribute("prpLclaimDto",prpLclaimDto);
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = new RegistDto();
		registDto = uiRegistAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registDto", registDto);
	}
	
	
	// modify by dongchengliang add start 20050615
	
	
	
	//modify by luqin add 2005-06-16 start
	/** 25
	 * 打印功能画面内容显示.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPropCancelNotice(HttpServletRequest httpServletRequest,String claimNo) throws Exception
	{
		
		
		//取得立案的信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String registNo = claimDto.getPrpLclaimDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
		String tempContext = "";
		if(registDto.getPrpLregistTextDtoList() != null){
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while(iterator.hasNext()){
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
				tempContext = tempContext + prpLregistTextDtoTemp.getContext();
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("1");
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
		
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("registDto",registDto);
	}
	
	/** 26
	 * 打印功能画面内容显示.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPropCompensate(HttpServletRequest httpServletRequest,String compensateNo) throws Exception
	{
		
		//取得立案的信息
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		
		/**
		 * 计算PrplLoss表中的损失(SumRealPay)
		 */
		double sumLossRealPay = 0;
		List prplLossList = compensateDto.getPrpLlossDtoList();
		for (Iterator iter = prplLossList.iterator(); iter.hasNext();) {
			PrpLlossDto lossDto = (PrpLlossDto) iter.next();
			if(lossDto!=null){
				sumLossRealPay += lossDto.getSumRealPay();
			}
		}
		compensateDto.getPrpLcompensateDto().setLossSumRealPay(sumLossRealPay);
		
		/**
		 * 计算PrplPersonLoss表中的损失(SumRealPay)
		 */
		double sumPersonLossRealPay = 0;
		List prplPersonList = compensateDto.getPrpLpersonLossDtoList();
		for (Iterator iter = prplPersonList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto personLoss = (PrpLpersonLossDto) iter.next();
			if(personLoss!=null){
				sumPersonLossRealPay += personLoss.getSumRealPay();
			}
		}		
		compensateDto.getPrpLcompensateDto().setPersonLossSumRealPay(sumPersonLossRealPay);
		
		
		
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("compensateDto",compensateDto);
		 /**
		 * 增加理赔计算书需要在赔款支付后才能打印的控制点
		 * added by zhangli 20070423
		 */		
		//uiCompensateAction.compensatePaymentResult(httpServletRequest,compensateNo);
		/**added by zhangli 20070520
		    * 增加理算书的核赔通过为其打印控制点;
		    * 适用于除车险类（险类代码为05）、农机具综合保险（险种代码为3119）之外的所有险种。
		    * 仅核赔标志为1时，理算书可以打印。
		*/
		 
		uiCompensateAction.compensateUndwrtFlag(httpServletRequest, compensateNo);
	}
	
	/** 27
	 * 打印功能画面内容显示.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getAcciReview(HttpServletRequest httpServletRequest,String compensateNo) throws Exception
	{
		
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String policyNo = compensateDto.getPrpLcompensateDto().getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		httpServletRequest.setAttribute("policyDto",policyDto);
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("compensateDto",compensateDto);
	}
	
	/** 30
	 * 打印功能画面内容显示.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getAcciCancelNotice(HttpServletRequest httpServletRequest,String claimNo) throws Exception
	{
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("policyDto",policyDto);
	}
	//modify by luqin add 2005-06-16 end
	
	/**
	 * 用于意健险理赔批单打印
	 * @param httpServletRequest
	 * @param compensateNo 计算书号
	 * @throws Exception
	 * */
	public void getAcciReparationsList(HttpServletRequest httpServletRequest, String compensateNo) throws Exception {
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		ArrayList prpLctextDtoDtoList = new ArrayList();
		for (Iterator iter = compensateDto.getPrpLctextDtoDtoList().iterator(); iter.hasNext();) {
			PrpLctextDto element = (PrpLctextDto) iter.next();
			if(element.getTextType().equals("7")){
				prpLctextDtoDtoList.add(element);
			}
		}
		compensateDto.setPrpLctextDtoDtoList(prpLctextDtoDtoList);
		httpServletRequest.setAttribute("compensateDto", compensateDto);
	}
	
	/** 25
	 * 打印功能画面内容显示.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getCheck(HttpServletRequest httpServletRequest,String registNo) throws Exception
	{
		// 取得报案的信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		//add by zhaolu 20060904 start
		//reason判断是否进行了查堪
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
		if(checkDto==null || checkDto.getPrpLcheckDto()==null)
		{
			throw new UserException(1,3,"0000","此报案" + registNo + "还没有进行查堪，不能生成查堪报告");
		}
		
		//add by zhaolu 20060904 end
		//reason添加强制保单信息
		String prpLRegistRPolicyNo = "";
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto =  new PolicyDto();
			if(registDto.getPrpLRegistRPolicyDtoOfCompel() != null){
			  prpLRegistRPolicyNo = registDto.getPrpLRegistRPolicyDtoOfCompel().getPolicyNo();
			  httpServletRequest.setAttribute("prpLRegistRPolicyNo",prpLRegistRPolicyNo);
			  policyDto = endorseViewHelper.findForEndorBefore(prpLRegistRPolicyNo);
			  if (policyDto.getPrpCitemKindDtoList() != null)
			  {
				  
				 PrpCitemKindDto rPrpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(0);
				 httpServletRequest.setAttribute("rPrpCitemKindDto",rPrpCitemKindDto);
				 
               }
			}
	
		//add by zhaolu 20060905 start
		
		//add by zhaolu 20060905 end
		//Modify By 孟冬冬 Start at 20051227
		//reason    若找不到相应的信息，则应抛出异常，否则会出现空指针错误
		if(registDto==null || registDto.getPrpLregistDto()==null){
			throw new UserException(-98,-1000,"uiRegistAction.findByPrimaryKey("+registNo+")");
		}
		//Modify By 孟冬冬 End at 20051227
		
		httpServletRequest.setAttribute("registDto",registDto);
	}
	
	/**
	 * 26 打印功能画面内容显示.人员伤亡费用清单
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPersonList(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		getLossSimple(httpServletRequest, claimNo);
	}
	
	//add by caopeng start at 2005-12-30
	/**
	 * 48 打印功能画面内容显示.
	 *
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void getPrepareIndemnity(HttpServletRequest httpServletRequest,
			String compensateNo) throws Exception {
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		httpServletRequest.setAttribute("ClaimNo", claimNo);
		httpServletRequest.setAttribute("compensateDto", compensateDto);
		getPilfer(httpServletRequest,claimNo);
		String policyNo = compensateDto.getPrpLcompensateDto().getPolicyNo();
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByConditions(policyNo);
		httpServletRequest.setAttribute("endorseDto",endorseDto);
		
		// 给报案文件多行列表准备数据
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		String tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList()
			.iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				tempContext = tempContext + prpLctextDtoTemp.getContext();
			}
		}
		// prpLregistTextDto =
		// (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("1");
		// prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		
	}
	//add by caopeng end at 2005-12-30
	
	/**
	 * 赔款通知书/收据打印时调用的方法
	 */
	public String getIndemnityReceiptAndUsedVisa(HttpServletRequest httpServletRequest,
			String compensateNo,String printNo) throws Exception {
		String rt=null;
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);	

		if (compensateDto.getPrpLcompensateDto().getUnderWriteFlag().equals("1")||compensateDto.getPrpLcompensateDto().getUnderWriteFlag().equals("3")){
			
		}else{
			throw new UserException(1,3,"claim","本案尚感未核赔通过,不允许打印赔款通知书。");
		}
		//首先获得相应的单证类型
		UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
		UIVisaAction uiVisaAction = new UIVisaAction();
		log.debug("comcode:"+userDto.getComCode());
		log.debug("riskCode:"+compensateDto.getPrpLcompensateDto().getRiskCode());
		log.debug("CERTI_TYPE:"+PrpLIndemnityReceiptDto.DEFAULT_CERTI_TYPE);
		
		/*
		 * 因单证目前还未改成可以自动按通用险种、总公司统一管理赔款收据单证流水号的模式，目前暂时从理赔中限定险种为通用险种“0000”，单位为"2000000000"
		 */
		Iterator iter = uiVisaAction.getVsCode("2000000000","0000",PrpLIndemnityReceiptDto.DEFAULT_CERTI_TYPE).iterator();
//		Iterator iter = uiVisaAction.getVsCode(userDto.getComCode(),compensateDto.getPrpLcompensateDto().getRiskCode(),PrpLIndemnityReceiptDto.DEFAULT_CERTI_TYPE).iterator();
		CodeNameDto codeNameDto = null;
		
		//从中取出一条作为默认的类型(一般情况下只有一条)
		if(iter.hasNext()){
			codeNameDto = (CodeNameDto) iter.next();
		}
		
		if(codeNameDto==null){
			//若没有该单证类型
			throw new UserException(1,3,"platform","单证类型 赔款收据 未配置，请与单证管理员联系！单位："+userDto.getComName()+"；险种："+compensateDto.getPrpLcompensateDto().getRiskCode());
			
		}
		
		//首先判断该流水号是否可用
		log.debug("visaCode:"+codeNameDto.getCodeCode());
		log.debug("printNo:"+printNo);
		log.debug("userCode"+userDto.getUserCode());
		if(uiVisaAction.checkVisaCodeValid(codeNameDto.getCodeCode(),printNo,userDto.getUserCode())){
			//若可用,则进行下一步的判断
			httpServletRequest.setAttribute("printNo",printNo);
			httpServletRequest.setAttribute("visaCode",codeNameDto.getCodeCode());
			httpServletRequest.setAttribute("visaName",codeNameDto.getCodeName());
			
			//获得相应的收款信息
			PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = getIndemnityReceiptByCompensateNo(compensateNo);
			
			if(prpLIndemnityReceiptDto.getPrintNo()!=null&&prpLIndemnityReceiptDto.getPrintNo().trim().length()>0){
	    		  httpServletRequest.setAttribute("isHavePrintNo",Boolean.TRUE);
	    		  rt = "havePrintNo";
			}else{   					
	    		  httpServletRequest.setAttribute("isHavePrintNo",Boolean.FALSE);
			}
			
			getCompensate(httpServletRequest,compensateNo);
			return rt;
		}else{
			throw new UserException(1,3,"claim","该单证打印流水号不可用,请与单证管理员联系!");
		}
	}
	
	/**
	 * 根据理算书号获得相应的收款信息
	 * @param compensateNo
	 * @return
	 * @throws Exception
	 */
	private PrpLIndemnityReceiptDto getIndemnityReceiptByCompensateNo(String compensateNo)throws Exception {
		PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = uiIndemnityReceiptAction.findPrpLIndemnityReceiptDtoByBusinessNo(compensateNo);
		
		if(prpLIndemnityReceiptDto==null){
			//无此收款打印信息,则新增一条收款信息
			CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
			
			prpLIndemnityReceiptDto = new PrpLIndemnityReceiptDto();
			prpLIndemnityReceiptDto.setBusinessNo(compensateNo);
			//默认该类型为"C"
			prpLIndemnityReceiptDto.setCertiType(PrpLIndemnityReceiptDto.DEFAULT_CERTI_TYPE);
			prpLIndemnityReceiptDto.setPolicyNo(compensateDto.getPrpLclaimDto().getPolicyNo());
			prpLIndemnityReceiptDto.setInsuredCode(compensateDto.getPrpLcompensateDto().getInsuredCode());
			prpLIndemnityReceiptDto.setInsuredName(compensateDto.getPrpLcompensateDto().getInsuredName());
			uiIndemnityReceiptAction.insertPrpLIndemnityReceiptDto(prpLIndemnityReceiptDto);
		}
		return prpLIndemnityReceiptDto;
	} 
	
	public void getAgriCompensate(HttpServletRequest httpServletRequest,String compensateNo) throws Exception
	{
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		double sumLossRealPay = 0;
		List prplLossList = compensateDto.getPrpLlossDtoList();
		for (Iterator iter = prplLossList.iterator(); iter.hasNext();) {
			PrpLlossDto lossDto = (PrpLlossDto) iter.next();
			if(lossDto!=null){
				sumLossRealPay += lossDto.getSumRealPay(); 
			}
		}
		compensateDto.getPrpLcompensateDto().setLossSumRealPay(sumLossRealPay);
		
		
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("compensateDto",compensateDto);
		/**
		 * 增加理赔计算书需要在赔款支付后才能打印的控制点
		 * added by zhangli 20070423
		 */		
		//uiCompensateAction.compensatePaymentResult(httpServletRequest,compensateNo);
		/**added by zhangli 20070520
		    * 增加理算书的核赔通过为其打印控制点;
		    * 适用于除车险类（险类代码为05）、农机具综合保险（险种代码为3119）之外的所有险种。
		    * 仅核赔标志为1时，理算书可以打印。
		*/
		 
		uiCompensateAction.compensateUndwrtFlag(httpServletRequest, compensateNo);
	}
	
	
	//add by kangzhen 070129 start
	public void getReduce(HttpServletRequest httpServletRequest,String endorseNo) throws Exception
	{
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByPrimaryKey(endorseNo);
		
		String policyNo = endorseDto.getPrpPmainDto().getPolicyNo();
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
	}
	//add by kangzhen 070129 end
	
    //add by sinosoft 20070524 begin
	public void getAddPremium(HttpServletRequest httpServletRequest,String endorseNo) throws Exception
	{
		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		EndorseDto endorseDto = uiEndorseAction.findByPrimaryKey(endorseNo);
		
		String policyNo = endorseDto.getPrpPmainDto().getPolicyNo();
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
		httpServletRequest.setAttribute("policyDto", policyDto);
		httpServletRequest.setAttribute("endorseDto", endorseDto);
	}
	//add by sinosoft 20070524 end
	
	public void getCompensateHosp(HttpServletRequest httpServletRequest,String compensateNo)throws Exception
	{
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
		double sumPersonLossRealPay = 0;
		List prplPersonLossList = compensateDto.getPrpLpersonLossDtoList();
		for (Iterator iter = prplPersonLossList.iterator(); iter.hasNext();) {
			PrpLpersonLossDto lossDto = (PrpLpersonLossDto) iter.next();
			if(lossDto!=null){
				sumPersonLossRealPay += lossDto.getSumRealPay(); 
			}
		}
		compensateDto.getPrpLcompensateDto().setPersonLossSumRealPay(sumPersonLossRealPay);
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		getLossSimple(httpServletRequest, claimNo);
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		httpServletRequest.setAttribute("claimDto",claimDto);
		httpServletRequest.setAttribute("compensateDto",compensateDto);
	}
	
	public void getTimeListing(HttpServletRequest httpServletRequest,String startDate,String endDate)throws Exception
	{
		DBManager dbManager = new DBManager();
		try{
			dbManager.open("ddccDataSource");
			HashMap hashMap = new HashMap();
			ArrayList compensateNoList = new ArrayList();
			String strSQL = "Select CompensateNo from PrpLcompensate where riskCode = '2601'" +
					" and underWriteFlag = '1'" +
					" and underWriteEndDate>='"+startDate+"'" +
					" and underWriteEndDate<='"+endDate+"'";
			ResultSet rs = dbManager.executeQuery(strSQL);
			while(rs.next()){
				String strCompensateNo = rs.getString("CompensateNo");
				compensateNoList.add(strCompensateNo);
			}
			rs.close();
			
			if(compensateNoList!=null&&compensateNoList.size()>0){
				for (Iterator it = compensateNoList.iterator(); it.hasNext();){
					double fee = 0d;
					double quFee= 0d;
					double anxinFee = 0d;
					double payFee = 0d;
					String compensateNo = (String)it.next();
					HospTimeListingDto hospTimeListingDto = new HospTimeListingDto();
					BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
					CompensateDto compensateDto = new CompensateDto();
					compensateDto = blCompensateFacade.findByPrimaryKey(compensateNo);
					fee = compensateDto.getPrpLcompensateDto().getSumLoss();
					anxinFee = compensateDto.getPrpLcompensateDto().getSumThisPaid();
					hospTimeListingDto.setFee(new DecimalFormat("#,##0.00").format(fee-5000));
					hospTimeListingDto.setAnxinFee(new DecimalFormat("#,##0.00").format(anxinFee));
					
					if(compensateDto.getPrpLhospitalizationPayFeeDtoList()!=null
							&&compensateDto.getPrpLhospitalizationPayFeeDtoList().size()>0){
						for(int i=0;i<compensateDto.getPrpLhospitalizationPayFeeDtoList().size();i++){
							PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto = new PrpLhospitalizationPayFeeDto();
							prpLhospitalizationPayFeeDto = (PrpLhospitalizationPayFeeDto)compensateDto.getPrpLhospitalizationPayFeeDtoList().get(i);
							if("02".equals(prpLhospitalizationPayFeeDto.getUnitType())){
								quFee = quFee + prpLhospitalizationPayFeeDto.getFee();
							}
						}
					}
					hospTimeListingDto.setQuFee(new DecimalFormat("#,##0.00").format(quFee));
					hospTimeListingDto.setPayFee(new DecimalFormat("#,##0.00").format(quFee+anxinFee));
					
					String registNo = compensateDto.getPrpLclaimDto().getRegistNo();
					BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
					PrpLregistDto prpLregistDto = new PrpLregistDto();
					prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
					hospTimeListingDto.setInsuredName(prpLregistDto.getInsuredName());
					hospTimeListingDto.setTownName(prpLregistDto.getLicenseNo());
					hospTimeListingDto.setAddress(prpLregistDto.getInsuredAddress());
					hospTimeListingDto.setContent(prpLregistDto.getBrandName());
					hospTimeListingDto.setCompensateNo(compensateNo);
					
					hashMap.put(compensateNo, hospTimeListingDto);
					
				}
			}
			httpServletRequest.setAttribute("hashMap",hashMap);
			httpServletRequest.setAttribute("startDate",startDate);
			httpServletRequest.setAttribute("endDate",endDate);
			
		}
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            dbManager.close();
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
