package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;
import com.sinosoft.claim.bl.facade.BLPrpLltextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIReturnVisitAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.dto.CaseClaimListMainInfo;
import com.sinosoft.claim.webservice.dto.HouseCaseListInfo;
import com.sinosoft.claim.webservice.dto.PaymentListInfo;
import com.sinosoft.claim.webservice.dto.PaymentListMainInfo;
import com.sinosoft.claim.webservice.dto.PlantingCaseListInfo;
import com.sinosoft.claim.webservice.dto.PlantingCaseListMainInfo;
import com.sinosoft.claim.webservice.dto.ReturnListDtoInfo;
import com.sinosoft.claim.webservice.dto.ReturnListDtoMainInfo;
import com.sinosoft.claim.webservice.dto.ReturnListDtoQuery;
import com.sinosoft.claim.webservice.dto.ReturnVisitInfo;
import com.sinosoft.claim.webservice.dto.ZH03CaseListInfo;
import com.sinosoft.claim.webservice.dto.ZH03CaseListMainInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.SysConfig;
/**
 * 待回访清单接口
 * 数据获取
 * @author Administrator
 *
 */
public class ListInformationServiceHelper {

	public ReturnListDtoMainInfo getReturnList(ReturnListDtoQuery returnListDtoQuery) throws Exception {
		ReturnListDtoMainInfo returnListDtoMainInfo = null;
		String comCode = returnListDtoQuery.getComCode();
		String comName = returnListDtoQuery.getComName();
		String registNo = returnListDtoQuery.getRegistNo();
		String policyNo = returnListDtoQuery.getPolicyNo();
		String riskCode = returnListDtoQuery.getRiskCode();
		String InsuredName = returnListDtoQuery.getInsuredName();
		String damageStartDate = returnListDtoQuery.getDamageStartDate();
		String damageEndDate = returnListDtoQuery.getDamageEndDate();
		String reportStartDate = returnListDtoQuery.getReportStartDate();
		String reportEndDate = returnListDtoQuery.getReportEndDate();
		String endCaseStartDate = returnListDtoQuery.getEndCaseStartDate();
		String endCaseEndDate = returnListDtoQuery.getEndCaseEndDate();
		String payrefStartDate = returnListDtoQuery.getPayrefStartDate();
		String payrefEndDate = returnListDtoQuery.getPayrefEndDate();
		String policyType = returnListDtoQuery.getPolicyType();
		String policyType2 = returnListDtoQuery.getPolicyType2();
		if(policyType!=null&&policyType.trim().length()>0&&policyType2!=null&&policyType2.trim().length()>0){
			throw new Exception("保单类型（意健险专用）,投保方式(农险专用)不能同时存在");
		}
		int pageNo = returnListDtoQuery.getPageNo();
		int recordPerPage = returnListDtoQuery.getRecordPerPage();
		
		DBManager dbManager = new DBManager();
		String conditions ="";
		String conditions2 = "";
		conditions += StringConvert.convertString(" r.comcode", comCode,"*");
		conditions2 += StringConvert.convertString(" m.comName", comName,"*");
		conditions += StringConvert.convertString(" r.registNo", registNo,"*");
		conditions += StringConvert.convertString(" r.policyNo", policyNo,"*");
		conditions += StringConvert.convertString(" r.riskCode", riskCode,"*");
		conditions += StringConvert.convertString(" r.InsuredName", InsuredName,"*");
		if(!isEmpty(damageStartDate)){conditions += " and r.damagestartdate >= date'"+damageStartDate+"'";}
		if(!isEmpty(damageEndDate)){conditions += " and r.damagestartdate <= date'"+damageEndDate+"'";}
		if(!isEmpty(reportStartDate)){conditions += " and r.reportdate  >= date'"+reportStartDate+"'";}
		if(!isEmpty(reportEndDate)){conditions += " and r.reportdate  <= date'"+reportEndDate+"'";}
		if(!isEmpty(endCaseStartDate)){conditions += " and c.endcasedate >= date'"+endCaseStartDate+"'";}
		if(!isEmpty(endCaseEndDate)){conditions += " and c.endcasedate <= date'"+endCaseEndDate+"'";}
		if(!isEmpty(payrefStartDate)){conditions2 += " and m.payrefDate >= date'"+payrefStartDate+"'";}
		if(!isEmpty(payrefEndDate)){conditions2 += " and m.payrefDate <= date'"+payrefEndDate+"'";}
		if(policyType!=null&&policyType.trim().length()>0){
			conditions += " and cm.policytype = '"+policyType+"'";
			conditions += " and cm.classcode in ('26','27','28')";
		}
		if(policyType2!=null&&policyType2.trim().length()>0){
			conditions += " and cm.policytype = '"+policyType2+"'";
			conditions += " and cm.classcode in ('31','32')";
		}
		
		int maxRows = pageNo*recordPerPage;
		int minRows = (pageNo-1)*recordPerPage;
		ResultSet countResultSet = null;
		ResultSet resultSet = null;
		try {
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		//查询记录数
    		StringBuffer countSql = new StringBuffer();
    		countSql.append(" SELECT COUNT(*) FROM ( ");
    		countSql.append("        SELECT m.* FROM (   ");
    		countSql.append("             SELECT r.comcode,  ");
    		countSql.append("                 (select p.comcname from prpdcompany p where p.comcode = r.comcode) as comname,  ");
    		countSql.append("                 r.registno,  ");
    		countSql.append("                 r.policyno,  ");
    		countSql.append("                 r.riskcode,  ");
    		countSql.append("                 r.insuredname,  ");
    		countSql.append("                 (select i.Mobile from prpcinsured i where i.policyno = r.policyno and i.insuredflag ='1') as InsuredPhoneNumber, "); 
    		countSql.append("                 r.damagename, "); 
    		countSql.append("                 r.damagestartdate, ");
    		countSql.append("                 r.damagestarthour,  ");
    		countSql.append("                 r.reportdate, ");
    		countSql.append("                 r.reporthour,  ");
    		countSql.append("                 c.endcasedate,  ");
    		countSql.append("                  ( ");
    		countSql.append("                   SELECT decode(max(f.payrefdatetime),Date'1970-1-1',max(f.payrefdate),max(f.payrefdatetime)) FROM prpjpayrefrec f  ");
    		countSql.append("                  WHERE f.claimno=c.claimno  ");
    		countSql.append("                   and f.certitype ='C'  ");
    		countSql.append("                   and f.payrefreason ='P60'  ");
    		countSql.append("                   and f.payrefstate in('10','11')  ");
    		countSql.append("                 ) as payrefDate,  ");
    		countSql.append("                r.reportorname,  ");
    		countSql.append("                 r.reportorphonenumber,  ");
    		countSql.append("                 r.linkername,  ");
    		countSql.append("                 r.phonenumber    ");
    		countSql.append("             FROM prplregist r,prplclaim c,prpcmain cm  ");
    		countSql.append("             where r.registno = c.registno  ");
    		countSql.append("             and cm.policyno = r.policyno  ");
    		countSql.append("             and r.classcode != '05' ");
    		countSql.append("             and not exists (SELECT 1 from prplCallcenterreturnvisitFlag cr  ");
    		countSql.append("                         where r.registno = cr.registno and cr.returnvisitflag = '1' ) ");
    		countSql.append("             and not exists( ");
    		countSql.append("                  Select 1 ");
    		countSql.append("                    From Prpjplanfee Ee ");
    		countSql.append("                   Where 1 = 1 ");
    		countSql.append("                     And Ee.Planfee != Ee.Realpayreffee ");
    		countSql.append("                     And Ee.certitype = 'C' ");
    		countSql.append("                     and Ee.payrefreason = 'P60' ");
    		countSql.append("                     and c.claimno = Ee.Claimno ");
    		countSql.append("              ) ");
    		countSql.append("              and exists( ");
    		countSql.append("                  Select 1 ");
    		countSql.append("                    From Prpjplanfee Ee ");
    		countSql.append("                  Where 1 = 1 ");
    		countSql.append("                     And Ee.certitype = 'C' ");
    		countSql.append("                     and Ee.payrefreason = 'P60' ");
    		countSql.append("                     and c.claimno = Ee.Claimno ");
    		countSql.append("              ) ");
    		countSql.append(conditions);
    		countSql.append("         ) m  ");
    		countSql.append("         where 1=1  ");
    		countSql.append(conditions2);
    		countSql.append(" ) ");
    		System.out.println(countSql.toString());
    		countResultSet = dbManager.executeQuery(countSql.toString());
    		int count = 0;
    		if(countResultSet.next()){
    			count = dbManager.getInt(countResultSet,1);
    		}
    		//分页查询数据
    		StringBuffer sql = new StringBuffer();
    		sql.append(" SELECT * FROM ( ");
    		sql.append("        SELECT m.* ,rownum rn FROM (  ");
    		sql.append("            SELECT r.comcode, ");
    		sql.append("                (select p.comcname from prpdcompany p where p.comcode = r.comcode) as comname, ");
    		sql.append("                r.registno, ");
    		sql.append("                r.policyno, ");
    		sql.append("                r.riskcode, ");
    		sql.append("                r.insuredname, ");
    		sql.append("                (select i.Mobile from prpcinsured i where i.policyno = r.policyno and i.insuredflag ='1') as InsuredPhoneNumber, ");
    		sql.append("                r.damagename, ");
    		sql.append("                r.damagestartdate, ");
    		sql.append("                r.damagestarthour, ");
    		sql.append("                r.reportdate, ");
    		sql.append("                r.reporthour, ");
    		sql.append("                c.endcasedate, ");
    		sql.append("                ( ");
    		sql.append("                  SELECT decode(max(f.payrefdatetime),Date'1970-1-1',max(f.payrefdate),max(f.payrefdatetime)) FROM prpjpayrefrec f ");
    		sql.append("                  WHERE f.claimno=c.claimno ");
    		sql.append("                  and f.certitype ='C' ");
    		sql.append("                  and f.payrefreason ='P60' ");
    		sql.append("                  and f.payrefstate in('10','11') ");
    		sql.append("                ) as payrefDate, ");
    		sql.append("               r.reportorname, ");
    		sql.append("                r.reportorphonenumber, ");
    		sql.append("                r.linkername, ");
    		sql.append("                r.phonenumber,   ");
    		sql.append("                r.operatorcode   ");
    		sql.append("            FROM prplregist r,prplclaim c,prpcmain cm ");
    		sql.append("            where r.registno = c.registno ");
    		sql.append("              and cm.policyno = r.policyno ");
    		sql.append(" 			  and r.classcode != '05' ");
    		sql.append("              and not exists (SELECT 1 from prplCallcenterreturnvisitFlag cr  ");
    		sql.append("                         where r.registno = cr.registno and cr.returnvisitflag = '1' ) ");
    		sql.append("              and not exists( ");
    		sql.append("                  Select 1 ");
    		sql.append("                    From Prpjplanfee Ee ");
    		sql.append("                   Where 1 = 1 ");
    		sql.append("                     And Ee.Planfee != Ee.Realpayreffee ");
    		sql.append("                     And Ee.certitype = 'C' ");
    		sql.append("                     and Ee.payrefreason = 'P60' ");
    		sql.append("                     and c.claimno = Ee.Claimno ");
    		sql.append("               ) ");
    		sql.append("              and exists( ");
    		sql.append("                  Select 1 ");
    		sql.append("                    From Prpjplanfee Ee ");
    		sql.append("                  Where 1 = 1 ");
    		sql.append("                     And Ee.certitype = 'C' ");
    		sql.append("                     and Ee.payrefreason = 'P60' ");
    		sql.append("                     and c.claimno = Ee.Claimno ");
    		sql.append("              ) ");
    		sql.append(conditions);
    		sql.append("        ) m ");
    		sql.append("        where 1=1 ");
    		sql.append(conditions2);
    		sql.append("        and rownum <="+maxRows+" ");
    		sql.append(" ) ");
    		sql.append(" WHERE rn>"+minRows+" ");
    		System.out.println(sql.toString());
    		resultSet = dbManager.executeQuery(sql.toString());
    		ArrayList<ReturnListDtoInfo> returnListDtoInfolist = new ArrayList<ReturnListDtoInfo>();
    		while(resultSet.next()){
    			ReturnListDtoInfo returnListDtoInfo = new ReturnListDtoInfo();
    			int index=1;
    			returnListDtoInfo.setComCode(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setComName(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setRegistNo(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setPolicyNo(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setRiskCode(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setInsuredName(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setInsuredPhoneNumber(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setDamageReason(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setDamageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++).toString(DateTime.YEAR_TO_DAY)+" "+dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++).toString(DateTime.YEAR_TO_DAY)+" "+dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++).toString(DateTime.YEAR_TO_SECOND));
    			returnListDtoInfo.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,index++).toString(DateTime.YEAR_TO_SECOND));
    			returnListDtoInfo.setReportorName(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setReportorPhoneNumber(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setLinkerName(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setLinkerPhoneNumber(dbManager.getString(resultSet,index++));
    			returnListDtoInfo.setRegistOperator(dbManager.getString(resultSet,index++));
    			returnListDtoInfolist.add(returnListDtoInfo);
    		}
    		ReturnListDtoInfo[] returnListDtoInfos = new ReturnListDtoInfo[returnListDtoInfolist.size()];
    		UICodeAction uiCodeAction = new UICodeAction();
    		for(int i = 0;i<returnListDtoInfolist.size();i++){
    			returnListDtoInfos[i] = returnListDtoInfolist.get(i);
    			String registOperator = uiCodeAction.translateUserCode(returnListDtoInfos[i].getRegistOperator(), true)+" "+ returnListDtoInfos[i].getRegistOperator();
    			returnListDtoInfos[i].setRegistOperator(registOperator);
    		}
    		
    		int intTotalPage = count%recordPerPage==0?count/recordPerPage:count/recordPerPage+1;
    		returnListDtoMainInfo = new ReturnListDtoMainInfo();
    		returnListDtoMainInfo.setReturnListDtoInfoList(returnListDtoInfos);
    		returnListDtoMainInfo.setPageNo(pageNo);
    		returnListDtoMainInfo.setRecordPerPage(recordPerPage);
    		returnListDtoMainInfo.setTotalCount(count);
    		returnListDtoMainInfo.setTotalPage(intTotalPage);
    		
    		return returnListDtoMainInfo;
		} catch (Exception exception) {
			throw exception;
		}finally{
			if(countResultSet!=null){countResultSet.close();}
			if(resultSet!=null){resultSet.close();}
			dbManager.close();
		}
	}
	private boolean isEmpty(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
	public PlantingCaseListMainInfo transPlantingCaseList(
			Collection arrayListForRelateList, int intCount, int pageNo,
			int recordPerPage)throws Exception {
		PlantingCaseListMainInfo plantingCaseListMainInfo= new PlantingCaseListMainInfo();
		PlantingCaseListInfo[] plantingCaseListInfos = new PlantingCaseListInfo[arrayListForRelateList.size()];
		Iterator it = arrayListForRelateList.iterator();
		int i = 0;
		while(it.hasNext()){
			ArrayList list = (ArrayList) it.next();
			PlantingCaseListInfo plantingCaseListInfo = new PlantingCaseListInfo();
			int index = 0;
			plantingCaseListInfo.setFCode(String.valueOf(list.get(index++)));
			plantingCaseListInfo.setFName(String.valueOf(list.get(index++)));
			plantingCaseListInfo.setInsureArea(String.valueOf(list.get(index++)));
			plantingCaseListInfo.setKindCode(String.valueOf(list.get(index++)));
			plantingCaseListInfo.setAmount(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setSumAmount(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setSumPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setRate(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setShortRateFlag(""+String.valueOf(list.get(index++)));
			plantingCaseListInfo.setShortRate(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setFPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setCentralPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setProvincePremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setCityPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setTownPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setOtherPremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
			plantingCaseListInfo.setStartDate(String.valueOf(list.get(index++)));
			plantingCaseListInfo.setEndDate(String.valueOf(list.get(index++)));
			
			plantingCaseListInfos[i++] = plantingCaseListInfo;
		}
		int intPageCount = 0;
		if(intCount>0)
		{
		  intPageCount = (intCount-1)/recordPerPage+1;
		}
		else
		{
		  intCount= 0;
		  intPageCount = 0;
		  pageNo = 0;
		}
		plantingCaseListMainInfo.setPlantingCaseListInfoList(plantingCaseListInfos);
		plantingCaseListMainInfo.setPageNo(pageNo);
		plantingCaseListMainInfo.setRecordPerPage(recordPerPage);
		plantingCaseListMainInfo.setTotalCount(intCount);
		plantingCaseListMainInfo.setTotalPage(intPageCount);
		return plantingCaseListMainInfo;
	}
	public ZH03CaseListMainInfo transZH03CaseList(
			Collection arrayListForRelateList, int intCount, int pageNo,
			int recordPerPage) throws Exception {
		ZH03CaseListMainInfo zh03CaseListMainInfo = new ZH03CaseListMainInfo();
		ZH03CaseListInfo[] zh03CaseListInfos = new ZH03CaseListInfo[arrayListForRelateList.size()];
		Iterator it = arrayListForRelateList.iterator();
		int i = 0;
		while(it.hasNext()){
			ArrayList list = (ArrayList) it.next();
			ZH03CaseListInfo zh03CaseListInfo = new ZH03CaseListInfo();
			zh03CaseListInfo.setSerial(String.valueOf(i));
			int index = 0;
			zh03CaseListInfo.setFamilyNo(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setFamilyName(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setFamilySex(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setFamilyIdCard(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setP1(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setP2(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setP3(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setP4(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setP5(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setAddress(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setCount(String.valueOf(list.get(index++)));
			zh03CaseListInfo.setRemark(String.valueOf(list.get(index++)));
			zh03CaseListInfos[i++] = zh03CaseListInfo;
		}
		int intPageCount = 0;
		if(intCount>0)
		{
		  intPageCount = (intCount-1)/recordPerPage+1;
		}
		else
		{
		  intCount= 0;
		  intPageCount = 0;
		  pageNo = 0;
		}
		zh03CaseListMainInfo.setZh03CaseListInfoList(zh03CaseListInfos);
		zh03CaseListMainInfo.setPageNo(pageNo);
		zh03CaseListMainInfo.setRecordPerPage(recordPerPage);
		zh03CaseListMainInfo.setTotalCount(intCount);
		zh03CaseListMainInfo.setTotalPage(intPageCount);
		return zh03CaseListMainInfo;
	}
	/**
	 * 理赔信息回访清单 数据转换
	 * @param prpLregistDto
	 * @param endCaseTime
	 * @param houseIdCard
	 * @param zh03FamilyNo
	 * @return
	 */
	public CaseClaimListMainInfo transCaseClaimList(
			PrpLregistDto prpLregistDto, String endCaseDate,
			String houseIdCard, String zh03FamilyNo, String context) throws Exception {
		CaseClaimListMainInfo caseClaimListMainInfo = new CaseClaimListMainInfo();
		caseClaimListMainInfo.setReportorName(prpLregistDto.getReportorName());
		caseClaimListMainInfo.setLinkerName(prpLregistDto.getLinkerName());
		caseClaimListMainInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
		caseClaimListMainInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY)+" "+prpLregistDto.getDamageStartHour());
		caseClaimListMainInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY)+" "+prpLregistDto.getReportHour());
		caseClaimListMainInfo.setEndCaseDate(endCaseDate);
		caseClaimListMainInfo.setDamageName(prpLregistDto.getDamageName());
		caseClaimListMainInfo.setDamageAddress(prpLregistDto.getDamageAddress());
		caseClaimListMainInfo.setContext(context);
		caseClaimListMainInfo.setHouseIdCard(houseIdCard);
		caseClaimListMainInfo.setZh03FamilyNo(zh03FamilyNo);
		return caseClaimListMainInfo;
	}
	/**
	 * 根据保单号计算出险次数
	 * @param policyNo
	 * @return
	 * @throws Exception
	 */
	public int getDamageTime(String policyNo) throws Exception {
		int DamageTime = 0;
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append(" SELECT count(1) from( ");
			sqlBuffer.append(" SELECT registno FROM prplregist ");
			sqlBuffer.append(" WHERE policyno = '"+policyNo+"' ");
			sqlBuffer.append(" group by registno ");
			sqlBuffer.append(" ) ");
			resultSet = dbManager.executeQuery(sqlBuffer.toString());
			if(resultSet.next()){
				DamageTime = dbManager.getInt(resultSet, 1);
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		if(DamageTime <= 0){
			return 0;
		}else{
			return DamageTime-1;
		}
	}
	/**
	 * 根据立案号获取 预赔费用和预赔金额
	 * @param claimNo
	 * @return preMessage[0] = sumPrePaid; preMessage[1] = preSosMedicFee;
	 * @throws SQLException
	 * @throws Exception
	 */
	public double[] getPreMessage(String claimNo) throws SQLException, Exception{
		double[] preMessage = new double[2];
		double sumPrePaid = 0.0;
    	double preSosMedicFee = 0.0;
    	UIPrepayAction uiPrePayAction = new UIPrepayAction();
        PrpLprepayDto  prpLprepayDto = null;
        String underWriteFlag = "";
        ArrayList PrepayList = (ArrayList)uiPrePayAction.findByConditions("claimNo = '" + claimNo+"'");
        if(PrepayList!=null){
        	for(Iterator its = PrepayList.iterator();its.hasNext();){
        		prpLprepayDto = new PrpLprepayDto();
        		prpLprepayDto = (PrpLprepayDto)its.next();
        		underWriteFlag = prpLprepayDto.getUnderWriteFlag();
           		if(underWriteFlag.equals("1")||underWriteFlag.equals("3")){
           			sumPrePaid += prpLprepayDto.getSumPrePaid();
            		preSosMedicFee += prpLprepayDto.getSumPreChargePaid();
           		}else{
            		throw new Exception("还有未核赔通过的预赔案件");
           		}
        	}
        }
    	preMessage[0] = sumPrePaid;
    	preMessage[1] = preSosMedicFee;
    	return preMessage;
	}
	/**
	 * 支付信息回访清单数据获取
	 * @param trim
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 * @throws Exception 
	 */
	public PaymentListMainInfo getPaymentList(String registNo, int pageNo,
			int recordPerPage,int intPerilCount,String riskcode) throws Exception {
		PaymentListMainInfo paymentListMainInfo = null;
		DBManager dbManager = new DBManager();
		int maxRows = pageNo*recordPerPage;
		int minRows = (pageNo-1)*recordPerPage;
		ResultSet countResultSet = null;
		ResultSet resultSet = null;
		ArrayList<String> claimnoList = new ArrayList<String>();
		ArrayList<PaymentListInfo> paymentListInfoList = new ArrayList<PaymentListInfo>(); 
		int intCount = 0;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			
			StringBuffer countsql = new StringBuffer();
			countsql.append(" SELECT count(1) FROM ( ");
			countsql.append("   SELECT c.claimno, ");
			countsql.append("          c.insuredname, ");
			countsql.append("          p.bank, ");
			countsql.append("          p.account, ");
			countsql.append("          p.receiverName, ");
			countsql.append("          p.times, ");
			countsql.append("          p.sumdutyPaid, ");
			countsql.append("          p.sumnodutyFee, ");
			countsql.append("          p.sumpaid, ");
			countsql.append("          p.sumthispaid, ");
			countsql.append("          ( ");
			countsql.append("              SELECT decode(max(f.payrefdatetime),Date'1970-1-1',max(f.payrefdate),max(f.payrefdatetime)) FROM prpjpayrefrec f  ");
			countsql.append("              WHERE f.certino=p.compensateno  ");
			countsql.append("              and certitype ='C'  ");
			countsql.append("              and payrefreason ='P60'  ");
			countsql.append("          ) as payrefDate ");
			countsql.append("       FROM prplclaim c,prplcompensate p ");
			countsql.append("       where  c.claimno = p.claimno ");
			countsql.append("       and (p.underwriteflag = '1' or  p.underwriteflag = '3') ");
			countsql.append("       and c.registno = '"+registNo+"' ");
			countsql.append("       order by compensateno   ");  
			countsql.append(" ) ");
			countResultSet = dbManager.executeQuery(countsql.toString());
			if(countResultSet.next()){
				intCount = dbManager.getInt(countResultSet, 1);
			}
			
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * FROM ( ");
			sql.append("   SELECT m.*,rownum rn FROM ( ");
			sql.append("      SELECT c.claimno, ");
			sql.append("          p.compensateno, ");
			sql.append("          c.insuredname, ");
			sql.append("          p.bank, ");
			sql.append("          p.account, ");
			sql.append("          p.receiverName, ");
			sql.append("          p.times, ");
			sql.append("          p.sumdutyPaid, ");
			sql.append("          p.sumnodutyFee, ");
			sql.append("          p.sumpaid, ");
			sql.append("          p.sumthispaid, ");
			sql.append("          ( ");
			sql.append("              SELECT decode(max(f.payrefdatetime),Date'1970-1-1',max(f.payrefdate),max(f.payrefdatetime)) FROM prpjpayrefrec f  ");
			sql.append("              WHERE f.certino=p.compensateno  ");
			sql.append("              and certitype ='C'  ");
			sql.append("              and payrefreason ='P60'  ");
			sql.append("          ) as payrefDate ");
			sql.append("       FROM prplclaim c,prplcompensate p ");
			sql.append("       where  c.claimno = p.claimno ");
			sql.append("       and (p.underwriteflag = '1' or  p.underwriteflag = '3') ");
			sql.append("       and c.registno = '"+registNo+"' ");
			sql.append("       order by compensateno  ");   
			sql.append("   ) m ");
			sql.append("   where rownum<="+maxRows+" ");
			sql.append(" ) ");
			sql.append(" where rn>"+minRows+" ");
			resultSet = dbManager.executeQuery(sql.toString());
			while(resultSet.next()){
				PaymentListInfo paymentListInfo = new PaymentListInfo();
				int index =1; 
				String claimno = dbManager.getString(resultSet, index++);
				String compensateNo = dbManager.getString(resultSet, index++);
				claimnoList.add(claimno);
				paymentListInfo.setInsuredname(dbManager.getString(resultSet, index++));
				paymentListInfo.setBank(dbManager.getString(resultSet, index++));
				paymentListInfo.setAccount(dbManager.getString(resultSet, index++));
				paymentListInfo.setReceiverName(dbManager.getString(resultSet, index++));
				paymentListInfo.setTimes(""+dbManager.getInt(resultSet, index++));
				paymentListInfo.setIntPerilCount(""+intPerilCount);
				paymentListInfo.setSumdutyPaid(""+dbManager.getDouble(resultSet, index++));
				paymentListInfo.setSumnodutyFee(""+dbManager.getDouble(resultSet, index++));
				paymentListInfo.setSumpaid(""+dbManager.getDouble(resultSet, index++));
				paymentListInfo.setSumthispaid(""+dbManager.getDouble(resultSet, index++));
				paymentListInfo.setContext(getPrplltextContext(claimno,riskcode,registNo,compensateNo));
				paymentListInfo.setPayrefDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,index++).toString(DateTime.YEAR_TO_SECOND));
				paymentListInfoList.add(paymentListInfo);
			}
			if(pageNo==1&&claimnoList.size()>0){
				double[] preMessage =  getPreMessage(claimnoList.get(0));
				paymentListInfoList.get(0).setSumprepaid(""+preMessage[0]);
				paymentListInfoList.get(0).setSumPreChargeAmount(""+preMessage[1]);
			}
			int intTotalPage = intCount%recordPerPage==0?intCount/recordPerPage:intCount/recordPerPage+1;
			//数据转换
			PaymentListInfo[] paymentListInfos = new PaymentListInfo[paymentListInfoList.size()];
			for(int i = 0;i<paymentListInfoList.size();i++){
				paymentListInfos[i] = paymentListInfoList.get(i);
			}
			paymentListMainInfo = new PaymentListMainInfo();
			paymentListMainInfo.setPaymentListInfoList(paymentListInfos);
			paymentListMainInfo.setPageNo(pageNo);
			paymentListMainInfo.setRecordPerPage(recordPerPage);
			paymentListMainInfo.setTotalCount(intCount);
			paymentListMainInfo.setTotalPage(intTotalPage);
			
		} catch (Exception e) {
			throw e;
		} finally{
			if(countResultSet!=null){
				countResultSet.close();//关闭结果集
			}
			if(resultSet!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return paymentListMainInfo;
	}
	/**
	 * 获理算报告
	 * @param claimNo
	 * @return
	 * @throws Exception
	 */
	public String getPrplltextContext(String claimNo,String riskCode,String registNo,String compensateNo) throws Exception{
		BLPrpLltextFacade blPrpLltextFacade = new BLPrpLltextFacade();
		String conditions = "claimno = '"+claimNo+"' and texttype = '08' order by lineno";
		ArrayList<PrpLltextDto>  prpLltextDtoList = (ArrayList<PrpLltextDto>) blPrpLltextFacade.findByConditions(conditions);
		String context = "";
		String prpltextForEar = "";
		if(prpLltextDtoList!=null&&prpLltextDtoList.size()>0){
			for(PrpLltextDto prpLltextDto:prpLltextDtoList){
				context += prpLltextDto.getContext();
			}
		}
		
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (taskCode.indexOf(riskCode) > -1) {
 			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
 				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
 				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "compe",compensateNo);
 				
 				Iterator ite = prplCompensateEarDtoList.iterator();
 				double sumloss = 0.00;
 	    		while(ite.hasNext())
 	    		{
 	    			PrplcompensateearDto prplCompensateEarDtotemp2 = (PrplcompensateearDto)ite.next();
 	    			double claimloss = prplCompensateEarDtotemp2.getEstimateloss();
 	    			sumloss = sumloss + claimloss;
 	    			prpltextForEar = prpltextForEar + "耳标号：" + prplCompensateEarDtotemp2.getEarno() + " 赔付金额=" + claimloss + "\r\n";
 	    		}
 	    		prpltextForEar = prpltextForEar + "\r\n" + "总赔付金额=" + sumloss;
 		}
		
		if (taskCode.indexOf(riskCode) > -1 && !prpltextForEar.equals(""))
	    {
	       return prpltextForEar;
	    }
	    else
	    {
	       return context;
	    }
	}
	/**
	 * 已回访状态保存
	 * @param registNo
	 * @param returnVisitFlag
	 * @return
	 * @throws Exception 
	 */
	public String saveReturnVisitFlag(String registNo, String returnVisitFlag) throws Exception {
		String flag = "0";
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(prpLregistDto==null){
				throw new Exception("案件号："+registNo+" 不存在");
			}
			String querySql = "SELECT * FROM prplcallcenterreturnvisitflag WHERE registno = '"+registNo+"'";
			resultSet = dbManager.executeQuery(querySql);
			if(resultSet.next()){
				String updateSql = "update prplcallcenterreturnvisitflag set returnvisitflag  = '"+
									returnVisitFlag+"' WHERE registno = '"+registNo+"'";
				dbManager.executeUpdate(updateSql);
			}else{
				String insertSql = "insert into prplcallcenterreturnvisitflag(registno,returnvisitflag)"
									+" values ('"+registNo+"','"+returnVisitFlag+"')";
				dbManager.executeUpdate(insertSql);
			}
			dbManager.commitTransaction();
			flag = "1";
		} catch (Exception e) {
			flag = "0";
			dbManager.rollbackTransaction();
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			dbManager.close();
		}
		return flag;
	}
	public void checkSaveReturnVisitInfo(ReturnVisitInfo returnVisitInfo) throws Exception {
		if(isEmpty(returnVisitInfo.getBusinessNo())){throw new Exception("业务号是必传参数，请检查！");}
		if(isEmpty(returnVisitInfo.getNodeType())){throw new Exception("节点类型是必传参数，请检查！");}
		if(isEmpty(returnVisitInfo.getVisitSuccess())){throw new Exception("是否回访成功是必传参数，请检查！");}
		if(isEmpty(returnVisitInfo.getEnteringTime())){throw new Exception("录入时间是必传参数，请检查！");}
		if(isEmpty(returnVisitInfo.getClasscode())){throw new Exception("险类是必传参数，请检查！");}
		if(isEmpty(returnVisitInfo.getState())){throw new Exception("state--回访状态是必传参数，请检查！");}
	}
	public String saveReturnVisit(ReturnVisitInfo returnVisitInfo) throws Exception {
		String flag = "0";
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			
			PrplreturnvisitDto prplreturnvisitDto = new PrplreturnvisitDto();
			prplreturnvisitDto.setBusinessNo(returnVisitInfo.getBusinessNo());
			prplreturnvisitDto.setNodetype(returnVisitInfo.getNodeType());
			//序号处理
			BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
			int a = blPrplreturnvisitAction.getCount(dbManager," businessNo='"+returnVisitInfo.getBusinessNo()+"'");
			prplreturnvisitDto.setSerialno(String.valueOf(a+1));
				
			prplreturnvisitDto.setVisitname(returnVisitInfo.getVisitName());
			prplreturnvisitDto.setContact(returnVisitInfo.getContact());
			prplreturnvisitDto.setRecorderno(returnVisitInfo.getRecorderno());
			prplreturnvisitDto.setService(returnVisitInfo.getService());
			prplreturnvisitDto.setExistissue(returnVisitInfo.getExistissue());
			prplreturnvisitDto.setVisitsuccess(returnVisitInfo.getVisitSuccess());
			prplreturnvisitDto.setVisitnocause(returnVisitInfo.getVisitnocause());
			prplreturnvisitDto.setVisitopinion(returnVisitInfo.getVisitopinion());
			prplreturnvisitDto.setEnteringcode(returnVisitInfo.getEnteringCode());
			prplreturnvisitDto.setEnteringname(returnVisitInfo.getEnteringName());
			prplreturnvisitDto.setEnteringcomcode(returnVisitInfo.getEnteringComcode());
			prplreturnvisitDto.setEnteringtime(new DateTime(returnVisitInfo.getEnteringTime(),DateTime.YEAR_TO_SECOND));
			prplreturnvisitDto.setClasscode("05");
			
			BLPrplreturnvisitswflogAction blPrplreturnvisitswflogAction = new BLPrplreturnvisitswflogAction();
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
			prplreturnvisitswflogDto.setBusinessno(returnVisitInfo.getBusinessNo());
			prplreturnvisitswflogDto.setNodetype(returnVisitInfo.getNodeType());
			prplreturnvisitswflogDto.setRegistno(returnVisitInfo.getBusinessNo());
			prplreturnvisitswflogDto.setPolicyno(returnVisitInfo.getPolicyno());
			prplreturnvisitswflogDto.setComcode(returnVisitInfo.getComcode());
			prplreturnvisitswflogDto.setComcodename(returnVisitInfo.getComcodename());
			prplreturnvisitswflogDto.setInsuredname(returnVisitInfo.getInsuredname());
			prplreturnvisitswflogDto.setReportdate(new DateTime(returnVisitInfo.getReportdate(),DateTime.YEAR_TO_SECOND));
			prplreturnvisitswflogDto.setCeasedate(new DateTime(returnVisitInfo.getCeasedate(),DateTime.YEAR_TO_SECOND));
			prplreturnvisitswflogDto.setLicenseno(returnVisitInfo.getLicenseno());
			prplreturnvisitswflogDto.setHandlercode(returnVisitInfo.getEnteringCode());
			prplreturnvisitswflogDto.setHandlername(returnVisitInfo.getEnteringName());
			prplreturnvisitswflogDto.setHandlercomcode(returnVisitInfo.getEnteringComcode());
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(returnVisitInfo.getFlowInTime(),DateTime.YEAR_TO_SECOND));
			prplreturnvisitswflogDto.setCeasetime(new DateTime(returnVisitInfo.getCeasetime(),DateTime.YEAR_TO_SECOND));
			prplreturnvisitswflogDto.setClasscode(returnVisitInfo.getClasscode());
			prplreturnvisitswflogDto.setState(returnVisitInfo.getState());
			
			blPrplreturnvisitAction.insert(dbManager,prplreturnvisitDto);
			blPrplreturnvisitswflogAction.delete(dbManager, returnVisitInfo.getBusinessNo(), returnVisitInfo.getNodeType());
			blPrplreturnvisitswflogAction.insert(dbManager, prplreturnvisitswflogDto);
			dbManager.commitTransaction();
			flag = "1";
			
		
		} catch (Exception e) {
			dbManager.rollbackTransaction();
			e.printStackTrace();
			throw e;
		}finally{
            dbManager.close();
        }
		return flag;
	}
	
	
	
}
