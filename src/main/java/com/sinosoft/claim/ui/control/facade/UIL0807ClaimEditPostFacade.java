package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP Post 车险理赔立案编辑界面
 * <p>Title: 车险理赔立案编辑界面信息</p>
 * <p>Description: 车险理赔立案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lijiyuan,lixiang
 * @version 1.0
 */
public class UIL0807ClaimEditPostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILClaimEditPostFacade.class);
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //向前流转
		String claimNo = "";
        String registNo = "";

		try {
			String comCode = "";
			String userCode = "";
			ClaimDto claimDto = new ClaimDto();
			String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); 
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); 

			String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldClaimLastAccessedTime");
			if (oldLastAccessedTime.trim().equals("")) {
				httpServletRequest.getSession().setAttribute("oldClaimLastAccessedTime", strLastAccessedTime);
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); 
				registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
				String riskCode = "2601";
				String userLastActionNow = "claimAdd?regist=" + registNo; 
				int year = DateTime.current().getYear();

				UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
				userCode = user.getUserCode();
				UIClaimAction uiClaimAction1 = new UIClaimAction();
				PrpCmainDto prpCmainDto = uiClaimAction1.findByPolicyNoKey(httpServletRequest.getParameter("prpLclaimPolicyNo"));
				comCode = prpCmainDto.getComCode();

				if (claimNo.length() < 1 || claimNo == null) {
					UIBillAction uiBillAction = new UIBillAction();
					String tableName = "prplclaim";
					claimNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				}

				
				PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
				prpLclaimDto.setClaimNo(claimNo);
		        prpLclaimDto.setLFlag("L");
		        //prpLclaimDto.setCaseNo(httpServletRequest.getParameter("prpLclaimCaseNo"));
		        prpLclaimDto.setClassCode("08");
		        prpLclaimDto.setRiskCode("2601");
		        prpLclaimDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        prpLclaimDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        prpLclaimDto.setBusinessNature("0");
		        prpLclaimDto.setLanguage("C");
		        //prpLclaimDto.setPolicyType(httpServletRequest.getParameter("prpLclaimPolicyType"));
		        prpLclaimDto.setInsuredCode("9999999999999999");
		        prpLclaimDto.setInsuredName(httpServletRequest.getParameter("insuredName"));
		        prpLclaimDto.setStartDate(new DateTime(prpCmainDto.getStartDate(),DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setStartHour(0);
		        prpLclaimDto.setEndHour(24);
		        prpLclaimDto.setEndDate(new DateTime(prpCmainDto.getEndDate(), DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setCurrency("CNY");
		        //prpLclaimDto.setSumAmount(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumAmount"))));
		        //prpLclaimDto.setSumPremium(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumPremium"))));
		        //prpLclaimDto.setSumQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumQuantity"))));
		        prpLclaimDto.setDamageStartHour("0");
		        prpLclaimDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("damageStartDate"),
		                DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setDamageEndDate(new DateTime(httpServletRequest.getParameter("damageEndDate"),
		                DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setDamageEndHour("24");
		        //prpLclaimDto.setDamageCode(httpServletRequest.getParameter("prpLclaimDamageCode"));
		        prpLclaimDto.setDamageName("住院医疗");
		        //prpLclaimDto.setDamageTypeCode(httpServletRequest.getParameter("prpLclaimDamageTypeCode"));
		        //prpLclaimDto.setDamageTypeName(httpServletRequest.getParameter("prpLclaimDamageTypeName"));
		        //prpLclaimDto.setDamageAreaCode(httpServletRequest.getParameter("prpLclaimDamageAreaCode"));
		        //prpLclaimDto.setDamageAreaName(httpServletRequest.getParameter("prpLclaimDamageAreaName"));
		        //prpLclaimDto.setDamageAddressType(httpServletRequest.getParameter("prpLclaimDamageAddressType"));
		        //prpLclaimDto.setDamageAddress(httpServletRequest.getParameter("prpLclaimDamageAddress"));
		        //prpLclaimDto.setLossName(httpServletRequest.getParameter("prpLclaimLossName"));
		        //prpLclaimDto.setLossQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimLossQuantity"))));
		        //prpLclaimDto.setDamageKind(httpServletRequest.getParameter("prpLclaimDamageKind"));
		        prpLclaimDto.setClaimDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setClaimTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		        //prpLclaimDto.setIndemnityDuty(httpServletRequest.getParameter("indemnityDuty"));
		        //prpLclaimDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimIndemnityDutyRate"))));
		        //prpLclaimDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimDeductibleRate"))));
		        prpLclaimDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("fee"))));
		        prpLclaimDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("buchangFee"))));
		        //prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumPaid"))));
		        //prpLclaimDto.setSumReplevy(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumReplevy"))));
		        //prpLclaimDto.setRemark(httpServletRequest.getParameter("prpLclaimRemark"));
		        //prpLclaimDto.setCaseType(httpServletRequest.getParameter("prpLclaimCaseType"));
		        prpLclaimDto.setMakeCom(prpCmainDto.getMakeCom());
		        prpLclaimDto.setComCode(comCode);
		        //prpLclaimDto.setAgentCode(httpServletRequest.getParameter("prpLclaimAgentCode"));
		        prpLclaimDto.setHandlerCode(userCode);
		        prpLclaimDto.setHandler1Code(userCode);
		        //prpLclaimDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLclaimStatisticsYM"),DateTime.YEAR_TO_DAY));
		        prpLclaimDto.setOperatorCode(userCode);
		        prpLclaimDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY));
		        //prpLclaimDto.setEndCaseDate(new DateTime(httpServletRequest.getParameter("prpLclaimEndCaseDate"),DateTime.YEAR_TO_DAY));
		        //prpLclaimDto.setEndCaserCode(httpServletRequest.getParameter("prpLclaimEndCaserCode"));
		        //prpLclaimDto.setCancelDate(new DateTime(httpServletRequest.getParameter("prpLclaimCancelDate"), DateTime.YEAR_TO_DAY));
		        //prpLclaimDto.setCancelReason(httpServletRequest.getParameter("prpLclaimCancelReason"));
		        prpLclaimDto.setDealerCode(userCode);
		        //prpLclaimDto.setDamageAreaPostCode(httpServletRequest.getParameter("prpDamageAreaPostCode"));
		        //prpLclaimDto.setCatastropheCode1(httpServletRequest.getParameter("prpCatastropheCode1"));
		        //prpLclaimDto.setCatastropheName1(httpServletRequest.getParameter("prpCatastropheName1"));
		        //prpLclaimDto.setCatastropheCode2(httpServletRequest.getParameter("prpCatastropheCode2"));
		        //prpLclaimDto.setCatastropheName2(httpServletRequest.getParameter("prpCatastropheName2"));
		        //prpLclaimDto.setClaimType(httpServletRequest.getParameter("escapeFlag"));
		        //String escapeFlag = httpServletRequest.getParameter("escapeFlag");
		        //if (escapeFlag == null) {
		           //escapeFlag = "";
		        //}
		        //String escapeFlag2 = "";
		        //escapeFlag2 = httpServletRequest.getParameter("escapeFlag2");
		        //if (escapeFlag2 == null) {
		           // escapeFlag2 = "";
		        //}
		        //prpLclaimDto.setEscapeFlag2(escapeFlag2);
		        //prpLclaimDto.setEscapeFlag(escapeFlag + escapeFlag2);
		        //prpLclaimDto.setFlag(httpServletRequest.getParameter("prpLclaimFlag"));
		        //prpLclaimDto.setReplevyFlag(httpServletRequest.getParameter("replevyFlag"));
		        //prpLclaimDto.setThirdComFlag(httpServletRequest.getParameter("thirdComFlag"));
		        //prpLclaimDto.setAddressCode(httpServletRequest.getParameter("prpLclaimAddressCode"));
		        //if ((prpLclaimDto.getEscapeFlag().length() > 0) && (prpLclaimDto.getEscapeFlag2().length() > 0)) {
		        //    String strTemp = prpLclaimDto.getEscapeFlag().substring(0, 1)
		         //           + prpLclaimDto.getEscapeFlag2().substring(0, 1);
		        //    prpLclaimDto.setEscapeFlag(strTemp);
		        //}
		        prpLclaimDto.setComName(comCode);
		        claimDto.setPrpLclaimDto(prpLclaimDto);
				
		        
				
		        double chuangweiFee     = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("chuangweiFee")));    
		        double zhenliaoFee      = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("zhenliaoFee")));     
		        double zhiliaoFee       = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("zhiliaoFee")));      
		        double huliFee          = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("huliFee")));        
		        double cailiaoFee       = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("cailiaoFee")));     
		        double jianchaFee       = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("jianchaFee")));      
		        double huayanFee        = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("huayanFee")));       
		        double shepianFee       = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("shepianFee")));      
		        double qiangjiuFee      = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("qiangjiuFee")));     
		        double shuxieFee        = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("shuxieFee")));       
		        double yangqiFee        = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("yangqiFee")));       
		        double xiyaoFee         = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("xiyaoFee")));        
		        double zhongchengyaoFee = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("zhongchengyaoFee")));
		        double zhongcaoyaoFee   = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("zhongcaoyaoFee")));  
		        double zifuFee          = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("zifuFee")));         
		        double qitaFee          = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("qitaFee")));
				
		        ArrayList prpLpersonDtoList = new ArrayList();
		        int i = 0;
		        if(chuangweiFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("01");
		        	prpLpersonDto.setFeeTypeName("床位费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(chuangweiFee);
		        	prpLpersonDto.setSumDefLoss(chuangweiFee);
		        	prpLpersonDto.setVeriSumLoss(chuangweiFee);
		        	prpLpersonDto.setVeriSumDefLoss(chuangweiFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(zhenliaoFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("02");
		        	prpLpersonDto.setFeeTypeName("诊疗费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(zhenliaoFee);
		        	prpLpersonDto.setSumDefLoss(zhenliaoFee);
		        	prpLpersonDto.setVeriSumLoss(zhenliaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(zhenliaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(zhiliaoFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("03");
		        	prpLpersonDto.setFeeTypeName("治疗费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(zhiliaoFee);
		        	prpLpersonDto.setSumDefLoss(zhiliaoFee);
		        	prpLpersonDto.setVeriSumLoss(zhiliaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(zhiliaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(huliFee != 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("04");
		        	prpLpersonDto.setFeeTypeName("护理费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(huliFee);
		        	prpLpersonDto.setSumDefLoss(huliFee);
		        	prpLpersonDto.setVeriSumLoss(huliFee);
		        	prpLpersonDto.setVeriSumDefLoss(huliFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(cailiaoFee != 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("05");
		        	prpLpersonDto.setFeeTypeName("手术材料费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(cailiaoFee);
		        	prpLpersonDto.setSumDefLoss(cailiaoFee);
		        	prpLpersonDto.setVeriSumLoss(cailiaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(cailiaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(jianchaFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("06");
		        	prpLpersonDto.setFeeTypeName("检查费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(jianchaFee);
		        	prpLpersonDto.setSumDefLoss(jianchaFee);
		        	prpLpersonDto.setVeriSumLoss(jianchaFee);
		        	prpLpersonDto.setVeriSumDefLoss(jianchaFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(huayanFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("07");
		        	prpLpersonDto.setFeeTypeName("化验费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(huayanFee);
		        	prpLpersonDto.setSumDefLoss(huayanFee);
		        	prpLpersonDto.setVeriSumLoss(huayanFee);
		        	prpLpersonDto.setVeriSumDefLoss(huayanFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(shepianFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("08");
		        	prpLpersonDto.setFeeTypeName("摄片费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(shepianFee);
		        	prpLpersonDto.setSumDefLoss(shepianFee);
		        	prpLpersonDto.setVeriSumLoss(shepianFee);
		        	prpLpersonDto.setVeriSumDefLoss(shepianFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(qiangjiuFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("09");
		        	prpLpersonDto.setFeeTypeName("抢救费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(qiangjiuFee);
		        	prpLpersonDto.setSumDefLoss(qiangjiuFee);
		        	prpLpersonDto.setVeriSumLoss(qiangjiuFee);
		        	prpLpersonDto.setVeriSumDefLoss(qiangjiuFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(shuxieFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("10");
		        	prpLpersonDto.setFeeTypeName("输血费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(shuxieFee);
		        	prpLpersonDto.setSumDefLoss(shuxieFee);
		        	prpLpersonDto.setVeriSumLoss(shuxieFee);
		        	prpLpersonDto.setVeriSumDefLoss(shuxieFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(yangqiFee != 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("11");
		        	prpLpersonDto.setFeeTypeName("氧气费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(yangqiFee);
		        	prpLpersonDto.setSumDefLoss(yangqiFee);
		        	prpLpersonDto.setVeriSumLoss(yangqiFee);
		        	prpLpersonDto.setVeriSumDefLoss(yangqiFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(xiyaoFee != 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("12");
		        	prpLpersonDto.setFeeTypeName("西药费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(xiyaoFee);
		        	prpLpersonDto.setSumDefLoss(xiyaoFee);
		        	prpLpersonDto.setVeriSumLoss(xiyaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(xiyaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(zhongchengyaoFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("13");
		        	prpLpersonDto.setFeeTypeName("中成药费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(zhongchengyaoFee);
		        	prpLpersonDto.setSumDefLoss(zhongchengyaoFee);
		        	prpLpersonDto.setVeriSumLoss(zhongchengyaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(zhongchengyaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(zhongcaoyaoFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("14");
		        	prpLpersonDto.setFeeTypeName("中草药费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(zhongcaoyaoFee);
		        	prpLpersonDto.setSumDefLoss(zhongcaoyaoFee);
		        	prpLpersonDto.setVeriSumLoss(zhongcaoyaoFee);
		        	prpLpersonDto.setVeriSumDefLoss(zhongcaoyaoFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(zifuFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("15");
		        	prpLpersonDto.setFeeTypeName("自负费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(zifuFee);
		        	prpLpersonDto.setSumDefLoss(zifuFee);
		        	prpLpersonDto.setVeriSumLoss(zifuFee);
		        	prpLpersonDto.setVeriSumDefLoss(zifuFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(qitaFee!= 0){
		        	i++;
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(i);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeCode("16");
		        	prpLpersonDto.setFeeTypeName("其他费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(qitaFee);
		        	prpLpersonDto.setSumDefLoss(qitaFee);
		        	prpLpersonDto.setVeriSumLoss(qitaFee);
		        	prpLpersonDto.setVeriSumDefLoss(qitaFee);
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
		        if(chuangweiFee == 0 && zhenliaoFee == 0 && zhiliaoFee == 0 && huliFee  == 0 &&
		           cailiaoFee  == 0 && jianchaFee == 0 && huayanFee == 0 && shepianFee == 0 &&
		           qiangjiuFee == 0 && shuxieFee == 0 && yangqiFee == 0 && xiyaoFee == 0 &&
		           zhongchengyaoFee == 0 && zhongcaoyaoFee == 0 && zifuFee == 0 && qitaFee == 0){
		        	PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
		        	prpLpersonDto.setClaimNo(claimNo);
		        	prpLpersonDto.setRiskCode("2601");
		        	prpLpersonDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		        	prpLpersonDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
		        	prpLpersonDto.setSerialNo(1);
		        	prpLpersonDto.setItemKindNo(1);
		        	prpLpersonDto.setFamilyNo(2);
		        	prpLpersonDto.setKindCode("001");
		        	prpLpersonDto.setPayPersonType("1");
		        	prpLpersonDto.setFeeTypeName("总费");
		        	prpLpersonDto.setPersonNo(1);
		        	prpLpersonDto.setPersonName(httpServletRequest.getParameter("insuredName"));
		        	prpLpersonDto.setPersonSex(httpServletRequest.getParameter("sexCode"));
		        	prpLpersonDto.setPersonAge(Integer.parseInt(httpServletRequest.getParameter("age")));
		        	prpLpersonDto.setCurrency("CNY");
		        	prpLpersonDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("buchangFee"))));
		        	prpLpersonDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("buchangFee"))));
		        	prpLpersonDto.setVeriSumLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("buchangFee"))));
		        	prpLpersonDto.setVeriSumDefLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("buchangFee"))));
		        	prpLpersonDtoList.add(prpLpersonDto);
		        }
				claimDto.setPrpLpersonDtoList(prpLpersonDtoList);
				
				PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
		        prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo());
		        prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
		        prpLclaimStatusDto.setNodeType("claim");
		        prpLclaimStatusDto.setSerialNo(0);
		        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode());
		        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
		        prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate());
		        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
				
				
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				SwfLogDto swfLogDtoDealNode = new SwfLogDto();

				
				if (!(swfLogFlowID == null || swfLogFlowID.equals("")) && !(swfLogLogNo == null || swfLogLogNo.equals(""))) {
					swfLogDtoDealNode.setFlowID(swfLogFlowID);
					swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
				}

				swfLogDtoDealNode.setNodeType("claim");
				swfLogDtoDealNode.setNodeStatus(claimDto.getPrpLclaimStatusDto().getStatus());
				swfLogDtoDealNode.setBusinessNo(registNo);
				swfLogDtoDealNode.setNextBusinessNo(claimNo);
				swfLogDtoDealNode.setKeyIn(claimNo);
				swfLogDtoDealNode.setKeyOut(claimNo);

				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);


				UIClaimAction uiClaimAction = new UIClaimAction();

				if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
						|| (workFlowDto.getSubmit())
						|| (workFlowDto.getClose())) {
					uiClaimAction.save(claimDto, workFlowDto);
					user.setUserMessage(claimNo);
				} else {
					user.setUserMessage(claimNo + ";注意:没有发现与工作流流程相关任何数据！！");

				}

				//防止重复刷新
				user.setUserLastAction(userLastActionNow);
				httpServletRequest.setAttribute("claimDto", claimDto);
			}

			ActionMessages messages = new ActionMessages();
			 
			if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
				Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimNo + "'");
				if (dangerTrial == null || dangerTrial.size() == 0) {
					new UIReinsTrialAction().simulateRepayByDangerNo(claimNo,claimNo);
				}
				Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimNo + "'");
				if (dangerUnit != null) {
					Iterator iter = dangerUnit.iterator();
					while (iter.hasNext()) {
						PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
						String newRepayNo = new BLRepayFacade().genRepay(
								claimNo, 
								prpLdangerUnitDto.getDangerNo(),
								comCode, 
								userCode,
								prpLdangerUnitDto.getClaimADDTimes()
								);
						if (!newRepayNo.equals("")) {
							new BLRepayFacade().checkRepay(newRepayNo, userCode);
						}
					}
				}
				
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLafterward.claimNo"));
			saveMessages(httpServletRequest, messages);
			httpServletRequest.setAttribute("claimNo", claimNo);
			httpServletRequest.setAttribute("registNo", registNo);
			httpServletRequest.setAttribute("swfLogFlowID", swfLogFlowID);
			  //再保中的现金赔款、共同理赔处理: 需要给予提示. 2005-9-28
			  //httpServletRequest.setAttribute("com.sinosoft.flag", getControlFlag(claimDto));
			
			forward = "ADD";
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			putNoback(claimNo);
		}  catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			putNoback(claimNo);
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * 处理再保的现金赔款、共同理赔方案
	 * @param ClaimDto 立案Dto
	 * @return String 提示信息:是否需要现金赔款、共同理赔
	 */
	private String getControlFlag(ClaimDto claimDto) {
		String setControlFlagMsg = ""; //返回提示信息
		String reinsMode = ""; //分保方式 [1]=2：合约
		String treatyNo = ""; //合约编码
		String strControlFlag = ""; //是否“共同理赔/理赔控制”
		boolean blnLargeLoss = false;
		boolean blnCashLoss = false;
		PrpCreinsTrialDto prpCreinsTrialDto = new PrpCreinsTrialDto();
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		BLCTrialFacade blCTrialFacade = new BLCTrialFacade();

		try {
			CReinsTrialDto cReinsTrialDto = blCTrialFacade.getCTrialInfo(
					claimDto.getPrpLclaimDto().getPolicyNo(), 
					1, 
					claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					);

			ArrayList prpCreinsTrialDtoList = (ArrayList) cReinsTrialDto.getPrpCreinsTrialDtoList();
			Iterator itTrial = prpCreinsTrialDtoList.iterator();

			while (itTrial.hasNext()) {
				prpCreinsTrialDto = (PrpCreinsTrialDto) itTrial.next();
				reinsMode = prpCreinsTrialDto.getReinsMode().substring(0, 1);

				if (reinsMode.equals("2")) { //为合约分保
					treatyNo = prpCreinsTrialDto.getTreatyNo();

					//根据合约号到fhTreaty表中获取合约信息
					fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
					strControlFlag = fhTreatyDto.getControlFlag();

					//判断赔案的估损金额是否超过重大赔案通知额
					//如果超过，则提示操作员，需要共同理赔
					if (strControlFlag.equals("1")
							&& claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getLargeLossValue()
							&& blnLargeLoss == false) {
						setControlFlagMsg = "此案需要共同理赔.";
						blnLargeLoss = true;
					}

					//判断估损金额是否超过现金赔款通知额
					//如果超过，则提示操作员，需要现金赔款
					if (claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getCashLossValue()
							&& blnCashLoss == false) {
						setControlFlagMsg = setControlFlagMsg + "此案需要现金赔款.";
						blnCashLoss = true;
					}
				}
				if (blnLargeLoss == true && blnCashLoss == true) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}

	//add by huangyunzhong 增加出错后放号回归函数 20051208
	private boolean putNoback(String claimNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplclaim";
		if (uiBillAction.putNo(tableName, claimNo)) {
			logger.debug("单号放回成功" + claimNo);
		} else {
			logger.debug("单号放回失败" + claimNo);
		}
		return true;
	}
	//add end by huangyunzhong 20051208
}
