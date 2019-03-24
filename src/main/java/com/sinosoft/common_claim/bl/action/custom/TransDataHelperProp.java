package com.sinosoft.common_claim.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sinosoft.claim.bl.action.domain.BLPrpLcheckAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrecaseAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLltextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossForSHDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claimprop.common.bl.facade.BLCiClaimPropDemandFacade;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.common_claim.dto.domain.CIPropCancelCaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimInsuredInfoDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimPolicyInfoDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropRegistRequestInDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 上海平台意健险组装数据业务类
 * @author feigai1
 *
 */
public class TransDataHelperProp {

	public TransDataHelperProp() {
		
	}
	/**
	 * 组装意健险报案接口所需要的业务数据
	 * @param businessNo
	 * @param policyNo
	 * @return
	 * @throws Exception
	 */
	public CIPropRegistRequestInDto getRegist(DBManager dbManager,String businessNo,String policyNo,String groupFlag,String secodeComCode) throws Exception{
		CIPropRegistRequestInDto ciPropRegistRequestInDto = new CIPropRegistRequestInDto();
		//保单编码
		String policySequenceNo = ""; 
	
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}

		String acciName=""; //出险人姓名
		String identifyType=""; //出险人证件类型
		String identifyNumber=""; //出险人证件	
		String customerSequenceNo = ""; //客户编码
		ArrayList<PrpLacciPersonDto> prpLacciPersonList  = (ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(" CertiNo='"+businessNo+"'");
		if(prpLacciPersonList.size()>0){
			Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					customerSequenceNo = "";
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					acciName = acciPerson.getAcciName();
					if(acciName.length()>16){
						acciName = acciName.substring(0,16);
					}
					identifyType = getIdentifyType(acciPerson.getIdentifyType());
					identifyNumber = acciPerson.getIdentifyNumber();
					
					String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpCinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
					while(resultSetCus.next()){
						customerSequenceNo = resultSetCus.getString(1);
					}
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
						while(resultSetCus1.next()){
							customerSequenceNo = resultSetCus1.getString(1);
						}
					}					
					//团单客户编码从这里获取;
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
						if(resultSetCus2.next()){
							customerSequenceNo = resultSetCus2.getString(1);
						}
					}					
					acciPerson.setAcciCode(customerSequenceNo);
				}
		}
		String damagerText = "";//出险经过		
		Date damageStartDate = new Date();
		String damageStartHour = null;
		Date reportStartDate = new Date();
		String reportStartHour = null;	
		PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(businessNo);
		//出险时间（年月日时分）
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+ businessNo +"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("意外")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("病")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("身故")>-1 || prpLregistDto.getDamageTypeName().indexOf("死亡")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("残疾")>-1 || prpLregistDto.getDamageTypeName().indexOf("烧伤")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("重大疾病")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("医疗")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("疾病")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		
		//封装数据
		ciPropRegistRequestInDto.setIsGroup(groupFlag);
		ciPropRegistRequestInDto.setCustomerSequenceNo(customerSequenceNo);//客户编码
		ciPropRegistRequestInDto.setAccidentDate(new SimpleDateFormat("yyyyMMdd").format(damageStartDate));//出险日期
		ciPropRegistRequestInDto.setSurveyOrNot("1");//是否调查
		ciPropRegistRequestInDto.setCloseDate("");//结案日期
		ciPropRegistRequestInDto.setClaimStatus("01");////理赔状态
		ciPropRegistRequestInDto.setIsReopen("0");//是否重开
		ciPropRegistRequestInDto.setReopenNum("");//重开次数
		ciPropRegistRequestInDto.setReopenReason("");//重开原因
		ciPropRegistRequestInDto.setReportDate(new SimpleDateFormat("yyyyMMdd").format(reportStartDate));////报案日期
		ciPropRegistRequestInDto.setReportNo(businessNo);//报案号
		ciPropRegistRequestInDto.setRegistrationDate("");//立案日期
		ciPropRegistRequestInDto.setRegistrationNo("");//立案号
		ciPropRegistRequestInDto.setAccidentReason(DamageName);////出险原因
		ciPropRegistRequestInDto.setAccidentPlace(prpLregistDto.getDamageAddress());//出险地点
		ciPropRegistRequestInDto.setReportName(prpLregistDto.getReportorName());//报案人姓名
		ciPropRegistRequestInDto.setReportGender("");//报案人性别
		ciPropRegistRequestInDto.setReportBirthday("");//报案人出生日期
		if(ClauseType.equals("00")){
			ciPropRegistRequestInDto.setReportCertNo(identifyNumber);//报案人证件号码
			ciPropRegistRequestInDto.setReportCertType("01");//报案人证件类别
		}else{
			ciPropRegistRequestInDto.setReportCertNo("");//报案人证件号码
			ciPropRegistRequestInDto.setReportCertType("");//报案人证件类别
		}
		ciPropRegistRequestInDto.setReportPhone(prpLregistDto.getReportorPhoneNumber());//报案人联系电话
		ciPropRegistRequestInDto.setReportAddr(prpLregistDto.getReportAddress());//报案人具体联系地址
		ciPropRegistRequestInDto.setAccName(acciName);//出险人姓名
		ciPropRegistRequestInDto.setAccCertType(identifyType);////出险人证件类别
		ciPropRegistRequestInDto.setAccCertNo(identifyNumber);////出险人证件号码
		ciPropRegistRequestInDto.setAccResult(DamageTypeName);//出险结果
		ciPropRegistRequestInDto.setAccResultDate(new SimpleDateFormat("yyyyMMdd").format(reportStartDate));////出险结果时间
		ciPropRegistRequestInDto.setStatus("1");//业务流程状态
		ciPropRegistRequestInDto.setInvestigationStartDate("");//理赔调查开始日期
		ciPropRegistRequestInDto.setInvestigationEndDate("");//理赔调查结束日期
		ciPropRegistRequestInDto.setRemoteClaimInvestigation("");//异地理赔调查标识
		ciPropRegistRequestInDto.setRelationship(ClauseType);//报案人与出险人关系
		ciPropRegistRequestInDto.setMedicalCareLable("");//医保标识
		ciPropRegistRequestInDto.setSocialNumber("");//社保卡号
		ciPropRegistRequestInDto.setAllClaimAmount("");//赔付总金额	
		ciPropRegistRequestInDto.setPolicyNo(policyNo);//保单号
		//团险
		if("1".equals(groupFlag)){
			if(prpLacciPersonList.size() > 0){
				Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					CIPropClaimInsuredInfoDto ciPropClaimInsuredInfoDto = new CIPropClaimInsuredInfoDto();					
					ciPropClaimInsuredInfoDto.setCustomerNo(String.valueOf(acciPerson.getFamilyNo()));
					ciPropClaimInsuredInfoDto.setAccidentDate(new SimpleDateFormat("yyyyMMddHH").parse(new SimpleDateFormat("yyyyMMdd").format(damageStartDate)+damageStartHour));
					ciPropClaimInsuredInfoDto.setCustomerSequenceNo(acciPerson.getAcciCode());//为满足团单多事故者出险情况，修改客户编码的取值BY CDB
					ciPropRegistRequestInDto.getCiPropClaimInsuredList().add(ciPropClaimInsuredInfoDto);
				}
			}
		}//else{//个险
			//CIPropClaimPolicyInfoDto ciPropClaimPolicyInfoDto = new CIPropClaimPolicyInfoDto();
			//ciPropClaimPolicyInfoDto.setPolicySequenceNo(policySequenceNo);
			//ciPropRegistRequestInDto.getCiPropClaimPolicyList().add(ciPropClaimPolicyInfoDto);
			ciPropRegistRequestInDto.setPolicySequenceNo(policySequenceNo);
		//}
		
		return ciPropRegistRequestInDto;
	}
	
	/**
	 * 上海平台意健险立案组装数据业务类
	 * @param dbManager
	 * @param claimNo
	 * @param policyNo
	 * @param groupFlag
	 * @param secodeComCode
	 * @return
	 * @throws Exception
	 */
	public CIPropClaimRequestInDto getCIPropClaimRequestInDto(
			DBManager dbManager, String claimNo, String policyNo,String groupFlag,String secodeComCode) throws Exception {
		String policySequenceNo = ""; //保单编码
		String isGroup = "";
		String remoteCheckType = "";//异地理赔调查代码
		String checkDate = "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CIPropClaimRequestInDto ciPropClaimRequestInDto = new CIPropClaimRequestInDto();
		CIPropClaimInsuredInfoDto ciPropClaimInsuredInfoDto = null;
		CIPropClaimPolicyInfoDto ciPropClaimPolicyInfoDto = new CIPropClaimPolicyInfoDto();
		PrpLclaimDto prpLClaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		String registNo = prpLClaimDto.getRegistNo();
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager,registNo);
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}

		isGroup = groupFlag;//团、个险标志;
		String acciName=""; //出险人姓名
		String identifyType=""; //出险人证件类型
		String identifyNumber=""; //出险人证件	
		String customerSequenceNo = ""; //客户编码
		List prpLacciPersonList = new ArrayList();
		prpLacciPersonList = (ArrayList) new BLPrpLaccipersonFacade().findByConditions(dbManager, " certino = '"+registNo+"'");
		if(prpLacciPersonList.size()>0){
			Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					customerSequenceNo = "";
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					acciName = acciPerson.getAcciName();
					if(acciName.length()>16){
						acciName = acciName.substring(0,16);
					}
					identifyType = getIdentifyType(acciPerson.getIdentifyType());
					identifyNumber = acciPerson.getIdentifyNumber();
					
					String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
					while(resultSetCus.next()){
						customerSequenceNo = resultSetCus.getString(1);
					}
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){
						 SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
						 ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
							while(resultSetCus1.next()){
								customerSequenceNo = resultSetCus1.getString(1);
							}
					}					
					//团单客户编码从这里获取;
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
						if(resultSetCus2.next()){
							customerSequenceNo = resultSetCus2.getString(1);
						}
					}					
					acciPerson.setAcciCode(customerSequenceNo);
				}
		}
		//String strCheckno = registNo+"-001";
		PrpLcheckDto prpLcheckDto = new BLPrpLcheckAction().findByPrimaryKey(dbManager,registNo,1);
		if(prpLcheckDto  != null){
			checkDate = new SimpleDateFormat("yyyy-MM-dd").format(prpLcheckDto.getCheckDate());
			if(prpLcheckDto.getHandleUnitCode().startsWith("31") || prpLcheckDto.getHandleUnitCode().equals("00000000")){
				remoteCheckType = "04";
			}else{
				remoteCheckType = "01";
			}
		}
		
		String damagerText = "";//出险经过
		Date claimDate =new Date();
		Date damageStartDate = new Date();
		String damageStartHour = null;
		Date reportStartDate = new Date();
		String reportStartHour = null;		
		//出险时间（年月日时分）
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		if(prpLClaimDto  != null){
			claimDate = prpLClaimDto.getClaimDate();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+registNo+"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("意外")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("病")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("身故")>-1 || prpLregistDto.getDamageTypeName().indexOf("死亡")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("残疾")>-1 || prpLregistDto.getDamageTypeName().indexOf("烧伤")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("重大疾病")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("医疗")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("疾病")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);
		ciPropClaimRequestInDto.setCenterCode(secodeComCode);
		ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);//保单编号
		ciPropClaimRequestInDto.setClaimNo(claimNo);	   //赔案号
		ciPropClaimRequestInDto.setCustomerSequenceNo(customerSequenceNo);//客户编码
		ciPropClaimRequestInDto.setAccidentDate(damageStartDate);//出险日期
		ciPropClaimRequestInDto.setSurveyOrNot("1");//是否调查
		//ciPropClaimRequestInDto.setCloseDate("");//结案日期
		ciPropClaimRequestInDto.setClaimStatus("02");//理赔状态
		ciPropClaimRequestInDto.setIsReopen("");//是否重开
		//ciPropClaimRequestInDto.setReopenNum("");//重开次数	
		ciPropClaimRequestInDto.setReopenReason("");//重开原因	
		ciPropClaimRequestInDto.setReportDate(reportStartDate);//报案日期	
		ciPropClaimRequestInDto.setReportNo(registNo);//报案号	
		ciPropClaimRequestInDto.setRegistrationDate(claimDate);//立案日期	
		ciPropClaimRequestInDto.setRegistrationNo(claimNo);//立案号		
		ciPropClaimRequestInDto.setAccidentReason(DamageName);//出险原因		
		ciPropClaimRequestInDto.setAccidentPlace(prpLregistDto.getDamageAddress());//出险地点	
		ciPropClaimRequestInDto.setReportName(prpLregistDto.getReportorName());//报案人姓名	
		ciPropClaimRequestInDto.setReportGender("");//性别	
		//ciPropClaimRequestInDto.setReportBirthday("") ;//出生日期	
		if(ClauseType.equals("00")){
			ciPropClaimRequestInDto.setReportCerttype("01") ;//证件类别	
			ciPropClaimRequestInDto.setReportCertno(identifyNumber);//报案人证件号码
		}else{
			ciPropClaimRequestInDto.setReportCerttype("") ;//证件类别	
			ciPropClaimRequestInDto.setReportCertno("") ;//证件号码	
		}
		ciPropClaimRequestInDto.setReportPhone(prpLregistDto.getReportorPhoneNumber()) ;//联系电话	
		ciPropClaimRequestInDto.setReportAddr(prpLregistDto.getReportAddress()) ;//具体联系地址	
		ciPropClaimRequestInDto.setAccName(acciName) ;//出险人姓名	
		ciPropClaimRequestInDto.setAccCertType(identifyType) ;//证件类别	
		ciPropClaimRequestInDto.setAccCertNo(identifyNumber) ;//证件号码	
		ciPropClaimRequestInDto.setAccResult(DamageTypeName) ;//出险结果	
		ciPropClaimRequestInDto.setAccResultDate(reportStartDate) ;//出险结果时间	
		ciPropClaimRequestInDto.setStatus("1") ;//业务流程状态
		if(checkDate != null && !"".equals(checkDate)){
			ciPropClaimRequestInDto.setInvestigationStartDate(format.parse(checkDate)) ;//理赔调查开始日期	
			ciPropClaimRequestInDto.setInvestigationEndDate(format.parse(checkDate));//理赔调查结束日期	
		}		
		ciPropClaimRequestInDto.setRemoteClaimInvestigation(remoteCheckType) ;//异地理赔调查标识	
		ciPropClaimRequestInDto.setRelationShip(ClauseType) ;//报案人与出险人关系	
		ciPropClaimRequestInDto.setMedicalCareLable("") ;//医保标识	
		ciPropClaimRequestInDto.setSocialNumber("") ;//社保卡号	
		ciPropClaimRequestInDto.setAllClaimAmount("") ;//赔付总金额	
		
		if(groupFlag.equals("1")){
			ciPropClaimRequestInDto.setIsGroup(groupFlag);
			ArrayList<CIPropClaimInsuredInfoDto> claimInsuredList= new ArrayList<CIPropClaimInsuredInfoDto>();
			for (int i = 0; i < prpLacciPersonList.size(); i++) {
				ciPropClaimInsuredInfoDto = new CIPropClaimInsuredInfoDto();//为满足团单多事故者车险上传平台成功，修改赋值
				PrpLacciPersonDto acciPerson = (PrpLacciPersonDto) prpLacciPersonList.get(i);				
				ciPropClaimInsuredInfoDto.setCustomerNo(acciPerson.getFamilyNo()+"");//客户序号
				ciPropClaimInsuredInfoDto.setCustomerSequenceNo(acciPerson.getAcciCode());//客户编号
				ciPropClaimInsuredInfoDto.setAccidentDate(new SimpleDateFormat("yyyyMMddHH").parse(new SimpleDateFormat("yyyyMMdd").format(damageStartDate)+damageStartHour));//出险日期
				ciPropClaimInsuredInfoDto.setName(acciPerson.getAcciName());//客户姓名
				//ciPropClaimInsuredInfoDto.setGender("");//性别
				//ciPropClaimInsuredInfoDto.setBirthDay(birthDay);//出生年月
				ciPropClaimInsuredInfoDto.setCertNo(acciPerson.getIdentifyNumber());//身份证号码
				ciPropClaimInsuredInfoDto.setCertificateType(acciPerson.getIdentifyType());//证件类别
				ciPropClaimInsuredInfoDto.setCertificateNo(acciPerson.getIdentifyNumber());//证件号码
				//ciPropClaimInsuredInfoDto.setNation("");//民族
				//ciPropClaimInsuredInfoDto.setEffectiveDate("");//有效期限起始日期
				//ciPropClaimInsuredInfoDto.setExpireDate("");//有效期限截止日期
				claimInsuredList.add(ciPropClaimInsuredInfoDto);
			}
			ciPropClaimRequestInDto.setCiPropClaimInsuredList(claimInsuredList);
		}//else{
			//ArrayList<CIPropClaimPolicyInfoDto> claimPolicyList = new ArrayList<CIPropClaimPolicyInfoDto>();
			//ciPropClaimPolicyInfoDto.setPolicySequenceNo(ciPropClaimRequestInDto.getPolicySequenceNo());  //保单编号
			//claimPolicyList.add(ciPropClaimPolicyInfoDto);
			//ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);
		//}
		return ciPropClaimRequestInDto;
	}
	
	
	
	
	/**
	 * 上海平台意健险结案组装数据业务类
	 * @param dbManager
	 * @param claimNo
	 * @param policyNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public CIPropEndcaseRequestInDto getEndCaseProp(DBManager dbManager, String claimNo,String policyNo,String groupFlag) throws SQLException, Exception {
		String policySequenceNo = "";//保单编号
		String customerSequenceNo = "";//客户编码
		String isGroup = groupFlag;//是否团单
		String registNo = "";//报案号
		String CaseNo = "";//赔案号
		String isReopen = "0";//是否重开
		int reopenNum = 0;       //重开次数
		String reopenReason="";  //重开原因
		double sumPaid = 0d; // 赔款金额
		double sumdutyPaid = 0d; // 赔款金额
		String acciName=""; //出险人姓名
		String identifyType=""; //出险人证件类型
		String identifyNumber=""; //出险人证件
		String damagerText = "";//出险经过
		String claimAccount = "";//赔款帐号
		String claimBank = "";//赔款账户开户行
		String claimName = "";//赔款帐号所有人
		String remoteCheckType = "";//异地理赔调查代码
		String hospitalCode = "";//医疗机构代码
		String diseaseCode = "";//疾病代码
		SwfLogDto swfLogDto = null;
		DateTime claimDate =new DateTime();
		DateTime checkDate =new DateTime();
		DateTime damageStartDate = new DateTime();
		String damageStartHour = null;
		DateTime reportStartDate = new DateTime();
		String reportStartHour = null;	
		ArrayList prpLpersonLossList = new ArrayList();
		ArrayList prpLacciPersonList = new ArrayList();
		CIPropEndcaseRequestInDto propEndcase = new CIPropEndcaseRequestInDto();
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		BLPrpCmain blPrpCmain = new BLPrpCmain();
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}
//		String SQLConditions1 = "select flag from prpcmain where policyno = '"+policyNo+"'";
//		ResultSet resultSet1 = dbManager.executeQuery(SQLConditions1);
//		while(resultSet1.next()){
//			isGroup = resultSet1.getString(1);
//			if(isGroup.length()>1){
//				isGroup = "1";
//			}
//		}
		PrpLclaimDto prpLClaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		if(prpLClaimDto  != null){
			claimDate = prpLClaimDto.getClaimDate();
			registNo = prpLClaimDto.getRegistNo();
		}
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager,registNo);
		BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
		Collection collection = blPrpLcompensateAction.findByConditions(dbManager," claimno = '"+claimNo+"'");
		if(collection.size()>0){
			Iterator iteratorOfCompensate = collection.iterator();
			while(iteratorOfCompensate.hasNext()){
				PrpLcompensateDto prpLcompensateDto =(PrpLcompensateDto)iteratorOfCompensate.next();
				CaseNo= prpLcompensateDto.getCaseNo();
				sumPaid = sumPaid +prpLcompensateDto.getSumPaid();
				sumdutyPaid = sumdutyPaid +prpLcompensateDto.getSumDutyPaid();
				claimAccount = prpLcompensateDto.getAccount();
				claimBank = prpLcompensateDto.getBank();
				claimName = prpLcompensateDto.getReceiverName();
				hospitalCode = prpLcompensateDto.getHospitalCode();
				diseaseCode = prpLcompensateDto.getDiseaseCode();
			}
		}
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("意外")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("病")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String personLossConditions = "policyno='" + policyNo+ "' and compensateno in (select compensateno from prplcompensate where claimNo='"+claimNo+"')";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction().findByConditions(dbManager, personLossConditions);
		//组合险从prpLloss中取值;
		blPrpCmain.getData(policyNo);
		
		ArrayList prpLlossDtoList = new ArrayList();
		ArrayList prpLpersonLossListForSH = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(prpLpersonLossList.size()>0){
			Iterator itLoss = prpLpersonLossList.iterator();
			
			while(itLoss.hasNext()){
				PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)itLoss.next();
				PrpLpersonLossForSHDto personLoss = new PrpLpersonLossForSHDto();
				new BeanUtils().copyProperties(personLoss, prpLpersonLossDto);
				if(personLoss.getLiabDetailName().equals("意外身故")){
					personLoss.setLiabDetailCode("01");
				}else if(personLoss.getLiabDetailName().equals("疾病身故")){
					personLoss.setLiabDetailCode("02");
				}else if(personLoss.getLiabDetailName().equals("意外身故伤残") || personLoss.getLiabDetailName().equals("意外身故/残疾") || personLoss.getLiabDetailName().equals("意外残疾")){
					personLoss.setLiabDetailCode("04");
				}else if(personLoss.getLiabDetailName().equals("医疗补贴")){
					personLoss.setLiabDetailCode("06");
				}else if(personLoss.getLiabDetailName().equals("重大疾病")){
					personLoss.setLiabDetailCode("07");
				}else if(personLoss.getLiabDetailName().equals("意外住院医疗") || personLoss.getLiabDetailName().equals("意外伤害医疗费用")){
					personLoss.setLiabDetailCode("10");
				}else if(personLoss.getLiabDetailName().equals("意外住院津贴")){
					personLoss.setLiabDetailCode("11");
				}else if(personLoss.getLiabDetailName().equals("疾病医疗")){
					personLoss.setLiabDetailCode("13");
				}else if(personLoss.getLiabDetailName().equals("疾病医疗")){
					personLoss.setLiabDetailCode("21");
				}else{
					personLoss.setLiabDetailCode("99");
				}
				prpLpersonLossListForSH.add(personLoss);
			}
		}
//		if(prpLlossDtoList.size() > 0){
//			Iterator itPrpLlossDtoList =  prpLlossDtoList.iterator();
//			while(itPrpLlossDtoList.hasNext()){
//				PrpLlossDto prpLlossDto = (PrpLlossDto)itPrpLlossDtoList.next();
//				//只上传意健险险别
//				if("26,27,28".indexOf(prpLlossDto.getKindCode().substring(0, 2)) > -1){
//					PrpLpersonLossForSHDto personLoss = new PrpLpersonLossForSHDto();
//					personLoss.setRiskCode(prpLlossDto.getRiskCode());
//					personLoss.setKindCode(prpLlossDto.getKindCode());
//					personLoss.setSumRealPay(prpLlossDto.getSumRealPay());
//					personLoss.setFamilyNo(prpLlossDto.getFamilyNo());
//					personLoss.setInHospDate("");
//					personLoss.setOutHospDate("");
//					if(prpLregistDto.getDamageName().equals("意外身故")){
//						personLoss.setLiabDetailCode("01");
//					}else if(prpLregistDto.getDamageName().equals("疾病身故")){
//						personLoss.setLiabDetailCode("02");
//					}else if(prpLregistDto.getDamageName().equals("意外身故伤残") || prpLregistDto.getDamageName().equals("意外身故/残疾") || prpLregistDto.getDamageName().equals("意外残疾")){
//						personLoss.setLiabDetailCode("04");
//					}else if(prpLregistDto.getDamageName().equals("医疗补贴")){
//						personLoss.setLiabDetailCode("06");
//					}else if(prpLregistDto.getDamageName().equals("重大疾病")){
//						personLoss.setLiabDetailCode("07");
//					}else if(prpLregistDto.getDamageName().equals("意外住院医疗") || prpLregistDto.getDamageName().equals("意外伤害医疗费用")){
//						personLoss.setLiabDetailCode("10");
//					}else if(prpLregistDto.getDamageName().equals("意外住院津贴")){
//						personLoss.setLiabDetailCode("11");
//					}else if(prpLregistDto.getDamageName().equals("疾病医疗")){
//						personLoss.setLiabDetailCode("13");
//					}else if(prpLregistDto.getDamageName().equals("疾病医疗")){
//						personLoss.setLiabDetailCode("21");
//					}else{
//						personLoss.setLiabDetailCode("99");
//					}
//					prpLpersonLossListForSH.add(personLoss);
//				}
//			}
//		}
		
		prpLacciPersonList = (ArrayList) new BLPrpLaccipersonFacade().findByConditions(dbManager, " certino = '"+registNo+"'");
		
		if(prpLacciPersonList.size()>0){
		Iterator it = prpLacciPersonList.iterator();
			while(it.hasNext()){
				customerSequenceNo = "";//结案上传平台报"保单下客户编码和客户序号不匹配！"问题修改
				PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
				acciName = acciPerson.getAcciName();
				if(acciName.length()>16){
					acciName = acciName.substring(0,16);
				}
				identifyType = getIdentifyType(acciPerson.getIdentifyType());
				identifyNumber = acciPerson.getIdentifyNumber();

				String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
				ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
				while(resultSetCus.next()){
					customerSequenceNo = resultSetCus.getString(1);
				}
				if(customerSequenceNo ==null || customerSequenceNo.equals("")){
					 SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					 ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
						while(resultSetCus1.next()){
							customerSequenceNo = resultSetCus1.getString(1);
						}
				}				
				//团单客户编码从这里获取;
				if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
					SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
					if(resultSetCus2.next()){
						customerSequenceNo = resultSetCus2.getString(1);
					}
				}				
				acciPerson.setAcciCode(customerSequenceNo);
			}
		}
		Collection collection1 = new BLPrpLrecaseAction().findByConditions(dbManager, " claimno = '"+claimNo+"'");
		if(collection1.size()>0){
			reopenNum = collection1.size();
			isReopen = "1";
			Iterator ite = collection1.iterator();
			while(ite.hasNext()){
				PrpLrecaseDto prpLrecaseDto = (PrpLrecaseDto)ite.next();
				reopenReason = prpLrecaseDto.getReCaseReason();
			}
		}
		if(CaseNo.equals("")){
			String conditions  = " NODETYPE = 'endca' and NODESTATUS = '4' and BUSINESSNO='"+claimNo+"' and REGISTNO = '"+registNo+"' order by logno asc "; 
			ArrayList swfEndcaList = (ArrayList) new BLSwfLogAction().findByConditions(dbManager, conditions);
			if(swfEndcaList!= null && swfEndcaList.size()>0){
				swfLogDto = new SwfLogDto();
				swfLogDto = (SwfLogDto) swfEndcaList.get(0);
				if(swfLogDto != null){
					CaseNo = swfLogDto.getKeyOut();
				}
			}
		}
		//String strCheckno = registNo+"-001";
		PrpLcheckDto prpLcheckDto = new BLPrpLcheckAction().findByPrimaryKey(dbManager,registNo,1);
		if(prpLcheckDto  != null){
			checkDate = prpLcheckDto.getCheckDate();
			if(prpLcheckDto.getHandleUnitCode().startsWith("31") || prpLcheckDto.getHandleUnitCode().equals("00000000")){
				remoteCheckType = "04";
			}else{
				remoteCheckType = "01";
			}
		}
		
		//出险时间（年月日时分）
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+registNo+"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("身故")>-1 || prpLregistDto.getDamageTypeName().indexOf("死亡")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("残疾")>-1 || prpLregistDto.getDamageTypeName().indexOf("烧伤")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("重大疾病")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("医疗")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("疾病")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		propEndcase.setPolicySequenceNo(policySequenceNo);//保单编号
		propEndcase.setPolicyNO(policyNo);   //保单号
		propEndcase.setRegistNo(registNo);   //报案号
		propEndcase.setClaimNo(claimNo);	 //立案号
		propEndcase.setEndCaseNo(CaseNo);    //赔案号
		propEndcase.setReopenNum(reopenNum); //重开次数
		propEndcase.setIsReopen(isReopen); //是否重开
		propEndcase.setReopenReason(reopenReason);//重开原因
		propEndcase.setClaimDate(sdf.format(claimDate));
		propEndcase.setDamageDate(sdf.format(damageStartDate));
		propEndcase.setDamageHour(prpLregistDto.getDamageStartHour());
		propEndcase.setReportDate(sdf.format(reportStartDate));//报案时间
		propEndcase.setEndCaseDate(sdf.format(new Date()));
		propEndcase.setReportHour(prpLregistDto.getReportHour());
		propEndcase.setReportName(prpLregistDto.getReportorName());//报案人
		propEndcase.setPhoneNumber(prpLregistDto.getPhoneNumber());//报案人电话
		propEndcase.setLinkerName(prpLregistDto.getLinkerName());//联系人
		propEndcase.setLinkerAddress(prpLregistDto.getLinkerAddress());//联系人地址
		propEndcase.setDamagerArrea(prpLregistDto.getDamageAddress());//出现地点
		propEndcase.setDamageName(DamageName);//出险原因
		propEndcase.setDamagerText(damagerText);//出险经过
		propEndcase.setDamageTypeName(DamageTypeName);//出现结果（事故类型）
		propEndcase.setClauseType(ClauseType);//报案人与出险人关系
		propEndcase.setCheckDate(sdf.format(checkDate));//查勘时间
		propEndcase.setRemoteCheckType(remoteCheckType);//异地理赔调查
		propEndcase.setSumPaid(sumPaid);
		propEndcase.setIsGroup(isGroup);
		propEndcase.setClaimAccount(claimAccount);
		propEndcase.setClaimBank(claimBank);
		propEndcase.setClaimName(claimName);
		
		propEndcase.setCustomerSequenceNo(customerSequenceNo);
		propEndcase.setAcciName(acciName);//出险人名称
		propEndcase.setIdentifyType(identifyType);//出险人证件类型
		propEndcase.setIdentifyNumber(identifyNumber);//出险人证件号码
		propEndcase.setAcciPersonList(prpLacciPersonList);
		propEndcase.setPersonLossList(prpLpersonLossListForSH);
		
		return propEndcase;
	}
	
	/**
	 * 注销
	 * @param dbManager
	 * @param businessNo
	 * @param policyNo
	 * @param claimStatus
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public CIPropCancelCaseRequestInDto getCancelClaimCase(DBManager dbManager, String businessNo,String policyNo,String groupFlag,String claimStatus) throws SQLException, Exception {
		CIPropCancelCaseRequestInDto propcancelCase = new CIPropCancelCaseRequestInDto();
		String registNo = "";
		String claimNo = "";
		String tempContext = "";
		String condition = "";
		String conditions = "";
		if(businessNo!=null){
			if(businessNo.substring(0, 1).equals("4")){
				registNo = businessNo;
			}else if(businessNo.substring(0, 1).equals("5")){
				registNo = new BLPrpLclaimFacade().findByPrimaryKey(businessNo).getRegistNo();
				claimNo = businessNo;
			}
		}
		if(claimNo ==""){//报案注销
			condition = " RegistNo='" + registNo + "'  and texttype = '2'";
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			ArrayList prplRegistTextList = (ArrayList)blPrpLregistTextFacade.findByConditions(condition);
			if (prplRegistTextList != null) {
	            Iterator iterator = prplRegistTextList.iterator();
	            while (iterator.hasNext()) {
	            	PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
	                tempContext = tempContext + prpLregistTextDto.getContext();
	            }
	        }
			claimStatus = "01";//注销状态，报案注销
		}else{//立案注销
			condition = " claimno = '"+claimNo+"' and texttype = '10' ";
			BLPrpLltextFacade blPrpLltextFacade = new BLPrpLltextFacade();
			ArrayList prplltextList = (ArrayList)blPrpLltextFacade.findByConditions(condition);
			if (prplltextList != null) {
				Iterator iterator = prplltextList.iterator();
				while (iterator.hasNext()) {
					PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
					tempContext = tempContext + prpLltextDtoTemp.getContext();
				}
			}
			claimStatus = "02";//注销状态，立案注销
		}
		propcancelCase.setPolicyNO(policyNo);
		propcancelCase.setRegistNo(registNo);
		propcancelCase.setCanceReason(tempContext);
		propcancelCase.setCancelType(claimStatus);
		propcancelCase.setIsGroup(groupFlag);
		
		return propcancelCase;
	}
	
	
	/**
	 * 证件类型转换成平台编码
	 * @param strIdentifyType
	 * @return
	 */
	public String getIdentifyType(String strIdentifyType){
    	String IdentifyType = "";   	
    	if(strIdentifyType.equals("03")){  //07	中国护照
    		IdentifyType = "07";
    	}else if(strIdentifyType.equals("05")){ //03 驾驶证
    		IdentifyType = "03";
    	}else if(strIdentifyType.equals("06")){ //11 回乡证
    		IdentifyType = "11";
    	}else{
    		IdentifyType = "01";
    	}    	
    	return IdentifyType;
    }
}	
