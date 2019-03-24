package com.sinosoft.claim.ui.control.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UIDeductCondAction {
	private static final Log logger = LogFactory.getLog(UIDeductCondAction.class);
	private UIDeductCondAction(){
		//禁止实例化
	}
	private static UIDeductCondAction uiDeductCondAction = new UIDeductCondAction();

	public static UIDeductCondAction getInstance() {
		return uiDeductCondAction;
	}
	
	/**
	 * 获取免赔条件list
	 * @param httpServletRequest
	 * @return prpLdeductCondList
	 */
	public ArrayList getDeductCondList(HttpServletRequest httpServletRequest ,boolean flag){
		String[] deductCode = httpServletRequest.getParameterValues("deductCondition");  //绝对免赔条件名称代码
		String[] deductCodeTemp = httpServletRequest.getParameterValues("deductConditionTemp");
		String[] times = httpServletRequest.getParameterValues("Times");  //输入的缺少单证个数或出险次数
		String[] deductName = httpServletRequest.getParameterValues("deductName");
		String[] newTimes = new String[deductCode.length];
		String[] newDeductName = new String[deductCode.length];
		String driverDeductCode = httpServletRequest.getParameter("driverDeductCondition");  //驾驶员免赔
		String driverTimes = httpServletRequest.getParameter("driverTimes"); 
		String driverDeductName = httpServletRequest.getParameter("driverDeductName"); 
		PrpLdeductCondDto prplDriverdeductCondDto = null;
		if(driverDeductCode != null && driverDeductCode.length() > 0){
			prplDriverdeductCondDto = new PrpLdeductCondDto();
			prplDriverdeductCondDto.setDeductCondCode(driverDeductCode);
			prplDriverdeductCondDto.setDeductCondName(driverDeductName);
			prplDriverdeductCondDto.setTimes(Integer.parseInt(driverTimes));
		}
		ArrayList prpLdeductCondList = new ArrayList();
		int j = 2;
		for(int i=2;i<times.length;i++){
			PrpLdeductCondDto prpldeductCondDto = new PrpLdeductCondDto();
				if(flag){
			if(Integer.valueOf(times[i]).intValue()!=0){
				newTimes[j] = times[i];
				newDeductName[j] = deductName[i]; 
				if(deductCode.length<times.length)
					prpldeductCondDto.setDeductCondCode(deductCode[j]);
				else
					prpldeductCondDto.setDeductCondCode(deductCode[i]);
				prpldeductCondDto.setDeductCondName(newDeductName[j]);
				prpldeductCondDto.setTimes(Integer.parseInt(newTimes[j]));
				j++;
						prpLdeductCondList.add(prpldeductCondDto);
					}
				}else{
					prpldeductCondDto.setDeductCondCode(deductCodeTemp[i]);
					prpldeductCondDto.setDeductCondName(deductName[i]);
					prpldeductCondDto.setTimes(Integer.parseInt(times[i]));
				prpLdeductCondList.add(prpldeductCondDto);
			}
		}
		if(prplDriverdeductCondDto != null){
			prpLdeductCondList.add(prplDriverdeductCondDto);
		}
		return prpLdeductCondList;
	}
	
	/**
	 * 获取事故责任免赔率 
	 * parm clauseType 
	 * parm kindCode 
	 * parm indemnityDuty 
	 * parm deductCond 
	 * parm escapeFlag 
	 * parm riskCode 
	 * parm modeCode return
	 * return deductibleRateOfAccident
	 * @throws Exception
	 */
	public double getDeductibleRateOfAccident(
			String riskCode, //险种
			String kindCode, //险别
			String indemnityDuty, //责任
			String dangerLevel,//风险水平
			String validDate // 保单生效日期
			) throws Exception {
		double dblDutyDeductibleRate = 0d;
		UIPrpDaccidentDeductAction uiPrpDaccidentDeductAction = new UIPrpDaccidentDeductAction();
		dblDutyDeductibleRate = uiPrpDaccidentDeductAction.findAccidentDeductRate(
				riskCode,kindCode,indemnityDuty,dangerLevel,validDate);
		return dblDutyDeductibleRate;
	}
	
	public Map getDeductibleRateOfAccident(
			String riskCode, //险别
			String kindCode, //险种
			String dangerLevel,//风险水平
			String validDate // 保单生效日期
			) throws Exception {
		Map deductibleRateOfAccident = new HashMap();
		Collection indemnityDutyList = UICodeAction.getInstance().findByConditions("  codeType='IndemnityDuty'"); 
		Double dutyDeductibleRate;
		
		for (Iterator iter = indemnityDutyList.iterator(); iter.hasNext();) {
			PrpDcodeDto prpDcodeDto = (PrpDcodeDto) iter.next();
		    String 	indemnityDutyCode=prpDcodeDto.getCodeCode();
			dutyDeductibleRate = new Double(getDeductibleRateOfAccident(riskCode,kindCode,indemnityDutyCode,dangerLevel,validDate));
			deductibleRateOfAccident.put(indemnityDutyCode,dutyDeductibleRate);
		}
		return deductibleRateOfAccident;
	}
	
	/**
	 * 获取绝对免赔额
	 * @param clauseType
	 * @param kindCode
	 * @param deductCond
	 * @param riskCode
	 * @param indemnityDuty
	 * @return
	 * @throws Exception
	 */
	public double getDeductibleRateOfAbsolute(
			String clauseType, 
			String kindCode, 
			ArrayList deductConditionList, 
			String riskCode,
			String validDate
			)
	throws Exception {
		double deductibleRateOfAbsoluteSum = 0;
		UIPrpDdeductCondAction uiPrpDdeductCondAction = new UIPrpDdeductCondAction();
		deductibleRateOfAbsoluteSum = uiPrpDdeductCondAction.findDeductibleRateOfAbsolute(clauseType,kindCode,deductConditionList,riskCode,validDate);
		return deductibleRateOfAbsoluteSum;
	}

	/**
	 * 获取驾驶员免赔率
	 * parm clauseType
	 * parm kindCode
	 * parm deductCond
	 * parm riskCode
	 * return deductibleRateOfAbsolute
	 * @throws Exception
	 */
	public double getDeductibleRateOfDriver(String clauseType, String kindCode, String deductCond, String riskCode)
			throws Exception {
		double deductibleRateOfDriver = 0;
		return deductibleRateOfDriver;
	}
	
	/**
	 * 免赔条件常量类
	 * @author mdd
	 *
	 */
	public static class DeductCondCode {
		/**
		 * 单方肇事
		 */
		public final static String NO_APPOINT_DRIVER = "170";

	}	
}
