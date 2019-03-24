package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UILClaimFittingsAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.PrpallUtility;
import com.sinosoft.utility.string.Str;

/**
 * 车险理赔与配件系统接口类
 * <p>
 * Title: 车险理赔与配件系统接口类
 * </p>
 * <p>
 * Description: 车险理赔与配件系统接口类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author sunchenggang
 * @version 1.0
 */
public class UILClaimFittingsInterFaceFacade extends Action {
	private static Log logger = LogFactory.getLog(UILClaimFittingsInterFaceFacade.class);

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; //向前流转

		try {
			String queryType = httpServletRequest.getParameter("queryType"); //查询类型
			String registNo = httpServletRequest.getParameter("registNo"); //报案号码
			String policyNo = httpServletRequest.getParameter("policyNo"); //保单号
			String insurant = httpServletRequest.getParameter("insurant"); //被保险人
			String lossItemCode = httpServletRequest.getParameter("lossItemCode"); //损失车辆
			String licenseNo = httpServletRequest.getParameter("licenseNo"); //车牌号码
			String systemAreaCode = httpServletRequest.getParameter("systemAreaCode"); //系统价地区
			String localAreaCode = httpServletRequest.getParameter("localAreaCode"); //本地价地区（填写当前用户所在的分公司代码）
			String vehCode = httpServletRequest.getParameter("vehCode"); //车型编码
			String vehName = httpServletRequest.getParameter("vehName"); //车型名称
			String selectedCarFittings = httpServletRequest.getParameter("selectCarFittings"); //车型名称
			
			String kindCode = "A";//险别代码
			String kindName = "车辆损失险";//险别名称
			String estimateNo = httpServletRequest.getParameter("policyNo");;//定损单号
			String lossNo = httpServletRequest.getParameter("lossItemCode");//损失项目编号
			String caseNo =  httpServletRequest.getParameter("registNo");//事故号码
			String plateNo = httpServletRequest.getParameter("licenseNo");//车牌号
			BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			String conditions = " registNo = '" + caseNo + "' and serialNo = '" + estimateNo + "'";
			ArrayList prpLthirdPartyDtoList = (ArrayList)blPrpLthirdPartyFacade.findByConditions(conditions);
			PrpLthirdPartyDto prpLthirdPartyDto = null;
			String markColor = "";//牌照颜色
			String engineNo = "";//发动机号
			String frameNo = "";//车驾号
			if(prpLthirdPartyDtoList.size() > 0){
				prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyDtoList.get(0);
				BLCodeFacade blCodeFacade = new BLCodeFacade();
				markColor = blCodeFacade.translateCodeCode("ColorCode", prpLthirdPartyDto.getLicenseColorCode(), true);
				engineNo = prpLthirdPartyDto.getEngineNo();
				frameNo = prpLthirdPartyDto.getFrameNo();
			}
			
			String plateColor = "";//车辆颜色
			
			String insureVehicleName = httpServletRequest.getParameter("vehName");;//承保车型名称
			String insureVehicleCode = httpServletRequest.getParameter("vehCode");;//承保车型代码
			String comCode = "0000000000";//定损员所属分公司代码
			String company = "国元农业保险股份有限公司";//定损员所属分公司名称
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String handlerCode = user.getUserCode();//定损员代码
			String handlerName = user.getUserName();//定损员名称
			String manHour = "";//修理厂工时费率
			
			String showPriceFlag = httpServletRequest.getParameter("showpriceflag");
			String repairFactoryType = httpServletRequest.getParameter("repairfactorytype");
			

			String returnparam = "";
			String errMsg = "";
			Map infoMap = new HashMap();
			//vehCode = "ABJAD5014";
			//vehName = "帕萨特SVW7203BPi";
			if(registNo==null||registNo.trim().length()==0){
				errMsg = "缺少报案号registNo,请与系统管理员联系";
			}else if(lossItemCode==null||lossItemCode.trim().length()==0){
				errMsg = "缺少损失车辆代码lossItemCode,请与系统管理员联系";
			}else if(systemAreaCode==null||systemAreaCode.trim().length()==0){
				errMsg = "缺少系统地区代码systemAreaCode,请与系统管理员联系";
			}else if(localAreaCode==null||localAreaCode.trim().length()==0){
				errMsg = "缺少本地地区代码localAreaCode,请与系统管理员联系";
			}else if(vehCode==null||vehCode.trim().length()==0){
				errMsg = "车型 "+vehName+" 缺少车型编码vehCode，请在理赔车辆的【厂牌型号】中双击选择相应车型再重试。手工输入的车型无法从配件系统获取配件数据。";
			}
			if(errMsg.trim().length()>0){
				throw new UserException(-98, -998, "数据检查", errMsg);
			}
			
			
			infoMap.put("400", "系统认证错误!");
			infoMap.put("401", "数据包格式错误（即：XML包格式错误）!");
			infoMap.put("402", "数据完整性错误（如：缺少报案号、损失车辆编号、缺少保单号、缺少被保人）!");
			infoMap.put("403", "当前车型不存在，或者当前车型在配件库中没有配件!");
			infoMap.put("499", "其它异常错误!");

			UIClaimFittingsClientFacade uiClaimFittingsClientFacade = new UIClaimFittingsClientFacade();
            Utils util=new Utils();
            util.getPhisicaMemory("旧理赔提交配件系统接口开始---start");
			returnparam = uiClaimFittingsClientFacade.sendXMLData(
					kindCode,
					kindName,
					lossNo,
					estimateNo,
					caseNo,
					plateNo,
					markColor,
					plateColor,
					engineNo,
					frameNo,
					insureVehicleName,
					insureVehicleCode,
					comCode,
					company,
					handlerCode,
					handlerName,
					manHour);
			util.getPhisicaMemory("旧理赔提交配件系统接口结束---end");
			logger.debug("returnparam=" + returnparam);
 
			if (returnparam.trim().equals("")) {
				throw new UserException(-98, -998, "提交配件系统", "配件系统没有响应,请联系系统管理员!");
			}

			errMsg = returnparam.substring(0, 3);
			if (!errMsg.equals("000")) {
				logger.debug("errMsg:" + errMsg);
				if (infoMap.containsKey(errMsg)) {
					throw new UserException(-98, -998, "提交配件系统", (String) infoMap.get(errMsg));
				} else {
					throw new UserException(-98, -998, "提交配件系统", "未知错误,配件系统返回错误码为:"+errMsg);
				}
			}
			returnparam = returnparam.substring(3);
			logger.debug("重定向的配件URL="+returnparam);
//			forward = "success";
			
			httpServletResponse.sendRedirect(returnparam);
			return null;
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理 
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * 双核流程流转中对理赔中的核赔节点的内容变更
	 * 
	 * @param LflowID String 理赔工作流号码
	 * @param LlogNo int 理赔工作流节点号码
	 * @param businessNo String 业务号码
	 * @param notionInfo String 审批意见 人员名 时间时间
	 * @param handlerCode String 操作员
	 * @throws Exception
	 * @return boolean
	 */

	public String addFittings(String registNo, String lossItemCode, String vehCode, String licenseNo,
			String selectedFittings) throws Exception {

		UILClaimFittingsAction uiLClaimFittingsAction = new UILClaimFittingsAction();
		PrpLclaimFittingsDto prpLclaimFittingsDto = null;
		Collection fittingsList = new ArrayList();
		PrpallUtility util=new PrpallUtility();
		String[] selectedFittingsArr = null;
		String[] fittingsArr = null;

		try {
			if(!"".equals(selectedFittings)){
				selectedFittingsArr = Str.split(selectedFittings, "_|");
	
				for (int i = 0; i < selectedFittingsArr.length; i++) {
	
					logger.debug("selectedFittingsArr[i]====" + selectedFittingsArr[i]);
	
					fittingsArr = Str.split(selectedFittingsArr[i], "^");
	
					prpLclaimFittingsDto = new PrpLclaimFittingsDto();
					prpLclaimFittingsDto.setPartId(fittingsArr[0]);
					prpLclaimFittingsDto.setSerialNo(Integer.parseInt(fittingsArr[1]));
					prpLclaimFittingsDto.setOriginalID(fittingsArr[2]);
					prpLclaimFittingsDto.setOriginalName(fittingsArr[3]);
					prpLclaimFittingsDto.setFittingCode(fittingsArr[4]);
					prpLclaimFittingsDto.setFittingName(fittingsArr[5]);
					prpLclaimFittingsDto.setPartGroupCode(fittingsArr[6]);
					prpLclaimFittingsDto.setPartGroupName(fittingsArr[7]);
					prpLclaimFittingsDto.setCertaPrice(Double.parseDouble(NullToZero(fittingsArr[8])));
					prpLclaimFittingsDto.setRepairSitePrice(Double.parseDouble(NullToZero(fittingsArr[9])));
					long certaQuantity = (long)Double.parseDouble(NullToZero(fittingsArr[10]));
					prpLclaimFittingsDto.setCertaQuantity(certaQuantity);
					prpLclaimFittingsDto.setSumPrice(Double.parseDouble(NullToZero(fittingsArr[11])));
					prpLclaimFittingsDto.setSelfConfigFlag(fittingsArr[12]);
					prpLclaimFittingsDto.setChgCompSetCode(fittingsArr[13]);
					prpLclaimFittingsDto.setChgCompSetName(fittingsArr[14]);
					prpLclaimFittingsDto.setChgRefPrice(Double.parseDouble(NullToZero(fittingsArr[15])));
					prpLclaimFittingsDto.setChgLocPrice(Double.parseDouble(NullToZero(fittingsArr[16])));
					prpLclaimFittingsDto.setSys4SPrice(Double.parseDouble(NullToZero(fittingsArr[17])));
					prpLclaimFittingsDto.setSysMarketPrice(Double.parseDouble(NullToZero(fittingsArr[18])));
					prpLclaimFittingsDto.setSysmatchPrice(Double.parseDouble(NullToZero(fittingsArr[19])));
					prpLclaimFittingsDto.setNative4SPrice(Double.parseDouble(NullToZero(fittingsArr[20])));
					prpLclaimFittingsDto.setNativeMarketPrice(Double.parseDouble(NullToZero(fittingsArr[21])));
					prpLclaimFittingsDto.setNativeMatchPrice(Double.parseDouble(NullToZero(fittingsArr[22])));
					prpLclaimFittingsDto.setCertaSaved(fittingsArr[23]);
					prpLclaimFittingsDto.setRemnant(Double.parseDouble(NullToZero(fittingsArr[24])));
					prpLclaimFittingsDto.setStatus(fittingsArr[25]);
					prpLclaimFittingsDto.setRemark(fittingsArr[26]);
					prpLclaimFittingsDto.setRegistNo(registNo);
					prpLclaimFittingsDto.setLossItemCode(lossItemCode);
					prpLclaimFittingsDto.setModelCode(vehCode);
					prpLclaimFittingsDto.setLicenseNo(licenseNo);
					prpLclaimFittingsDto.setResultType("Compent");
					prpLclaimFittingsDto.setFlag("1");
	
					fittingsList.add(prpLclaimFittingsDto);
				}
			}
			util.getPhisicaMemory("双核流程流转中对理赔中的核赔节点的内容变更开始---start");
			uiLClaimFittingsAction.save(fittingsList);
			util.getPhisicaMemory("双核流程流转中对理赔中的核赔节点的内容变更结束---end");
			return "000";
		} catch (Exception exception) {
			exception.printStackTrace();
			return "499";

		}

	}

	private static String NullToZero(String strNum) {
		if (strNum == null || strNum.equals("")) {
			return "0";
		}
		return strNum;
	}
}
