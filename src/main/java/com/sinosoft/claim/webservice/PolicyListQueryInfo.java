package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class PolicyListQueryInfo {
	
	/**
	 * 查询已经报案的数据，计算出现次数来进行显示
	 * 
	 * @param registDto
	 *            RegistDto
	 * @throws Exception
	 */
	
	public String getSamePolicyRegistInfo(String policyNo, String curRegistNo) throws Exception {
		UIRegistAction uiRegistAction = new UIRegistAction();
		ArrayList registList = new ArrayList();
		ArrayList registLastList = new ArrayList();
		PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
		PrpLregistDto prpLregistDtoPre = new PrpLregistDto();
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		UICodeAction uiCodeAction = new UICodeAction();
		String strOperatorCode = "";
		String strOperatorName = "";
		registList = (ArrayList) uiRegistAction.findSamePolicyRegist(policyNo);
		int intPerilCount = 0;
		int intRecentCount = 0; // 最近几天的出险次数
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null)
			rowCount = registList.size(); // 计算数据的数目

		if (curRegistNo == null)
			curRegistNo = "";
		for (rowNo = 0; rowNo < rowCount; rowNo++) {
			oldRegistNo = nowRegistNo;
			prpLregistDtoPre = prpLregistDtoTemp;
			prpLregistDtoTemp = (PrpLregistDto) registList.get(rowNo);
			nowRegistNo = prpLregistDtoTemp.getRegistNo();
			intervalDay = DateTime.intervalDay(prpLregistDtoTemp
					.getDamageStartDate(), 0, dateTime, 0);
            
			 if (intervalDay <= Integer.parseInt(priorDate)) {
				intRecentCount++;
			 }
			 
			// 如果为第一行，或者中间行，并且报案号不等于上一行的，或者小于最后一行的，
			if (rowNo == 0
					&& rowCount != 1
					|| ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo
							.equals(nowRegistNo)))) {
				if (oldRegistNo.equals(nowRegistNo)) {
					prpLregistDtoTemp.setBrandName(prpLregistDtoPre
							.getBrandName()
							+ " " + prpLregistDtoTemp.getBrandName());
				}
				// add by zhulei begin 20050901
				// 接着就continue了，这里需要补个intPerilCount记数
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 接着就continue了，这里需要补个intPerilCount记数
				continue;
			}
			// 添加上行记录

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// modify by wangli update start 20050420
			// reason:如果是第一次出险 intPerilCount就不应该再增加
			// 本次出险不计算在内
			
			if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo)
					&& (!oldRegistNo.equals(nowRegistNo))) {
				
				intPerilCount++;
				strOperatorCode = prpLregistDtoTemp.getOperatorCode();
				strOperatorName = uiCodeAction.translateUserCode(
						strOperatorCode, true);
				prpLregistDtoTemp.setOperatorName(strOperatorName);
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setSerialNo(intPerilCount);
				registLastList.add(prpLregistDtoTemp);
			} else {
				if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
					intPerilCount++;
					strOperatorCode = prpLregistDtoPre.getOperatorCode();
					strOperatorName = uiCodeAction.translateUserCode(
							strOperatorCode, true);
					prpLregistDtoPre.setOperatorName(strOperatorName);
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setSerialNo(intPerilCount);
					registLastList.add(prpLregistDtoPre);
				}
				// modify by wangli update end 20050420
			}
		}
		return String.valueOf(intPerilCount);
	}
	
	
	
}
