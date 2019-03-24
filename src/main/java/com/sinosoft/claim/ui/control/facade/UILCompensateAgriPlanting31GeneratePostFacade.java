package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.ui.control.facade.UIClaimPlanting31SettleLoadFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.AccidentCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateImplCompelViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateImplDubangViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.CompensateGenerateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.sysframework.exceptionlog.UserException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 分发HTTP Post 中央政策性六大农险实赔编辑界面
 * <p>
 * Title: 中央政策性六大农险实赔编辑界面
 * </p>
 * <p>
 * Description: 中央政策性六大农险实赔编辑界面
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILCompensateAgriPlanting31GeneratePostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILCompensateAgriPlanting31GeneratePostFacade.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String KindCode[]=httpServletRequest.getParameterValues("prpLlossDtoKindCode");
		String policyNo=httpServletRequest.getParameter("PolicyNo");
		String damageDate = httpServletRequest.getParameter("damageDate");
		String conditions="";
		String forward = ""; // 向前流转
		Map deductibleRateMap = new HashMap();
		Map kindNameMap = new HashMap();
		Map unitAmountMap = new HashMap();
		Map itemNameMap = new HashMap();
		Map paraMap = new HashMap();
		paraMap.put("damageDate", damageDate);
		try {
			   if((!"".equals(KindCode[KindCode.length-1])&&null!=KindCode[KindCode.length-1])&&(!"".equals(policyNo)&&null!=policyNo)){
				   conditions=" policyNo='"+policyNo+"'";
			   }
			   BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			   blPrpCitemKind.query(conditions);
			   List itemKindList = blPrpCitemKind.getSchemas();
			   if(null != itemKindList && itemKindList.size()>0){
				   PrpCitemKindSchema prpCitemKindSchema=new PrpCitemKindSchema();
				   double unitAmount = 0.0;
				   double deductibleRate = 0.0;
				   String kindName = "";
				   String kindCode = "";
				   String itemCode = "";
				   String itemName = "";
				   for(int i=0;i<itemKindList.size();i++){
					   prpCitemKindSchema=(PrpCitemKindSchema)itemKindList.get(i);
					   unitAmount=Double.parseDouble(prpCitemKindSchema.getUnitAmount());
					   //对单位保额做调整
					   unitAmount = adjustUnitAmount(unitAmount, paraMap, prpCitemKindSchema);
					   deductibleRate=Double.parseDouble(prpCitemKindSchema.getDeductibleRate());
					   kindName = prpCitemKindSchema.getKindName();
					   kindCode = prpCitemKindSchema.getKindCode();
					   itemCode = prpCitemKindSchema.getItemCode();
					   itemName = prpCitemKindSchema.getItemDetailName();
					   deductibleRateMap.put(""+kindCode+"_"+itemCode, deductibleRate);
					   unitAmountMap.put(""+kindCode+"_"+itemCode, unitAmount);
					   kindNameMap.put(kindCode, kindName);
					   itemNameMap.put(itemCode, itemName);
				   }
			   }
			   httpServletRequest.setAttribute("deductibleRateMap", deductibleRateMap);
			   httpServletRequest.setAttribute("unitAmountMap", unitAmountMap);
			   httpServletRequest.setAttribute("kindNameMap", kindNameMap);
			   httpServletRequest.setAttribute("itemNameMap", itemNameMap);
			   Map totalLossRatePointMap = generateTotalLossRatePointMap(policyNo);
			   httpServletRequest.setAttribute("totalLossRatePointMap", totalLossRatePointMap);
			   httpServletRequest.setAttribute("paraMap", paraMap);
			   AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
			   accidentCompensateViewHelper.generateAgriPlanting31Ctext(httpServletRequest);
			   forward = "generate";
		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
	
	public Map generateTotalLossRatePointMap(String policyNo)throws Exception{
		Map totalLossRatePointMap = new HashMap();
		try {
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			String policyConditions = "";
			if(!"".equals(policyNo)&&null!=policyNo){
				policyConditions=" policyno='"+policyNo+"' ";
			    blPrpCitemKind.query(policyConditions);
			    if(null != blPrpCitemKind && blPrpCitemKind.getSize() > 0){
			    	for(int index=0; index < blPrpCitemKind.getSize(); index++){
			            PrpCitemKindSchema prpCitemKindSchema = (PrpCitemKindSchema)blPrpCitemKind.getArr(index);
			            String strKindCode=prpCitemKindSchema.getKindCode();
			            String strItemCode=prpCitemKindSchema.getItemCode();
			            double totalLossRatePoint = Double.parseDouble(prpCitemKindSchema.getTotalLossRatio());
			            if(0==totalLossRatePoint)
			            	totalLossRatePoint = 100;
			            if(policyNo.startsWith("2317334") && prpCitemKindSchema.getItemCode().equals("p001")) {
			            	totalLossRatePoint = 80;
			            }
			            totalLossRatePointMap.put(""+strKindCode+"_"+strItemCode, totalLossRatePoint);
			    	}

			    }
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalLossRatePointMap;
	}
	public Map generateUnitAmountMap(Map paraMap, String policyNo)throws Exception{
		Map unitAmountMap = new HashMap();
		try {
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
			String policyConditions = "";
			if(!"".equals(policyNo)&&null!=policyNo){
				policyConditions=" policyno='"+policyNo+"' ";
			    blPrpCitemKind.query(policyConditions);
			    if(null != blPrpCitemKind && blPrpCitemKind.getSize() > 0){
			    	for(int index=0; index < blPrpCitemKind.getSize(); index++){
			            PrpCitemKindSchema prpCitemKindSchema = (PrpCitemKindSchema)blPrpCitemKind.getArr(index);
			            String strKindCode=prpCitemKindSchema.getKindCode();
			            String strItemCode=prpCitemKindSchema.getItemCode();
			            double unitAmount = Double.parseDouble(prpCitemKindSchema.getUnitAmount());
			            unitAmountMap.put(""+strKindCode+"_"+strItemCode, unitAmount);
			    	}
			    }
			}
		} catch (com.sinosoft.utility.error.UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unitAmountMap;
	}
	//有些险种险别标的需要调整单位保额。
	public double adjustUnitAmount(double unitAmount, Map paraMap, PrpCitemKindSchema prpCitemKindSchema)throws Exception{
		String riskCode = prpCitemKindSchema.getRiskCode();
		String kindCode = prpCitemKindSchema.getKindCode();
		String itemCode = prpCitemKindSchema.getItemCode();
		if("3141".equals(riskCode) && (itemCode.indexOf("032")>-1||itemCode.equals("6330"))){
			//大棚蔬菜保险(B)款，蔬菜含有茬次信息，所以调整单位保额。
			try {
				String damageDate = String.valueOf(paraMap.get("damageDate"));
				UIClaimPlanting31SettleLoadFacade uiClaimPlanting31SettleLoadFacade = new UIClaimPlanting31SettleLoadFacade();
				unitAmount = uiClaimPlanting31SettleLoadFacade.adjustAmount(prpCitemKindSchema, unitAmount, damageDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("3140".equals(riskCode) && itemCode.indexOf("032")>-1){
			try {
				String damageDate = String.valueOf(paraMap.get("damageDate"));
				UIClaimPlanting31SettleLoadFacade uiClaimPlanting31SettleLoadFacade = new UIClaimPlanting31SettleLoadFacade();
				unitAmount = uiClaimPlanting31SettleLoadFacade.adjustAmount(prpCitemKindSchema, unitAmount, damageDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("3147".equals(riskCode) && itemCode.indexOf("032")>-1){
			//大棚蔬菜保险(A)款，蔬菜含有茬次信息，所以调整单位保额。
			try {
				String damageDate = String.valueOf(paraMap.get("damageDate"));
				UIClaimPlanting31SettleLoadFacade uiClaimPlanting31SettleLoadFacade = new UIClaimPlanting31SettleLoadFacade();
				unitAmount = uiClaimPlanting31SettleLoadFacade.adjustAmount(prpCitemKindSchema, unitAmount, damageDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return unitAmount;
	}
}
