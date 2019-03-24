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
	 * ��ѯ�Ѿ����������ݣ�������ִ�����������ʾ
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
		int intRecentCount = 0; // �������ĳ��մ���
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// ת��������Ա�����ƣ��Լ��������,ȥ�����ڳ��ղ�λ���������
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null)
			rowCount = registList.size(); // �������ݵ���Ŀ

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
			 
			// ���Ϊ��һ�У������м��У����ұ����Ų�������һ�еģ�����С�����һ�еģ�
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
				// ���ž�continue�ˣ�������Ҫ����intPerilCount����
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 ���ž�continue�ˣ�������Ҫ����intPerilCount����
				continue;
			}
			// ������м�¼

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// modify by wangli update start 20050420
			// reason:����ǵ�һ�γ��� intPerilCount�Ͳ�Ӧ��������
			// ���γ��ղ���������
			
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
