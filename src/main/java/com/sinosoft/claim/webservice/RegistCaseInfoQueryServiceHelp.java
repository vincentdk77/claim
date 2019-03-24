package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLrelatePersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrelatePerson;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.dto.AcciPersonDto;
import com.sinosoft.claim.webservice.dto.AgriRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.EarLabelDto;
import com.sinosoft.claim.webservice.dto.HealthRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.PropRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.RegistCaseDto;
import com.sinosoft.claim.webservice.dto.RegistCaseDtoInfo;
import com.sinosoft.claim.webservice.dto.RegistCaseQuery;
import com.sinosoft.claim.webservice.dto.RelatePersonDto;
import com.sinosoft.claim.webservice.dto.RespRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.TransportRegistCaseDetailInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 呼叫中心接口  十一、报案查询相关接口
 * @author Administrator
 *
 */
public class RegistCaseInfoQueryServiceHelp {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	
	/**
	 * 报案任务查询
	 * @param registCaseQuery查询入参对象
	 * @return 返回案件列表，分页返回
	 * @throws Exception 
	 */
	public RegistCaseDtoInfo getRegistCaseList(RegistCaseQuery registCaseQuery) throws Exception{
		//1.取数据
		String registNo = StringUtils.rightTrim(registCaseQuery.getRegistNo());
		String policyNo = StringUtils.rightTrim(registCaseQuery.getPolicyNo());
		String licenseNo = StringUtils.rightTrim(registCaseQuery.getLicenseNo());
		String comCode = StringUtils.rightTrim(registCaseQuery.getComcode());
		String insuredName = StringUtils.rightTrim(registCaseQuery.getInsuredName());
		String cancelFlag = StringUtils.rightTrim(registCaseQuery.getCancelFlag());
		String registStartCancelDate = StringUtils.rightTrim(registCaseQuery.getRegistStartCancelDate());
		String registEndCancelDate = StringUtils.rightTrim(registCaseQuery.getRegistStartCancelDate());
		String[] caseFlags = registCaseQuery.getCaseFlag();
		String strEarLabel = StringUtils.rightTrim(registCaseQuery.getEarLabel());
		String strFname = StringUtils.rightTrim(registCaseQuery.getFName());
		String strFCardID = StringUtils.rightTrim(registCaseQuery.getFCardID());
		String strFname1 = StringUtils.rightTrim(registCaseQuery.getFName1());
		String operateDate = StringUtils.rightTrim(registCaseQuery.getOperateDate());
		String operateDateEnd = StringUtils.rightTrim(registCaseQuery.getOperateDateEnd());
		String riskCategory = StringUtils.rightTrim(registCaseQuery.getRiskCategory());
		String queryRiskCode = StringUtils.rightTrim(registCaseQuery.getQueryRiskCode());
		
		String callInPhoneNumber = StringUtils.rightTrim(registCaseQuery.getCallInPhoneNumber());
		String engineNo = StringUtils.rightTrim(registCaseQuery.getEngineNo());
		String frameNo = StringUtils.rightTrim(registCaseQuery.getFrameNo());
		String conditions_temp = "1=1";
		if((engineNo!=null&&engineNo.trim().length()>0)||(frameNo!=null&&frameNo.trim().length()>0)){
			 conditions_temp = getInsqlRegistnoAndPolicy(engineNo,frameNo);
		}
		
//		//新增车架号和发动机号查询
//		String conditions_temp = " 1=1";
//		if(engineNo!=null&&engineNo.trim().length()!=0){
//			conditions_temp += " and  engineno = '"+engineNo+"' ";
//		}
//		if(frameNo!=null&&frameNo.trim().length()!=0){
//			conditions_temp += " and  frameno = '"+frameNo+"' ";
//		}
		
		
		
		int pageNo = registCaseQuery.getPageNo();
		int recordPerPage = registCaseQuery.getRecordPerPage();
		//检验数据正确性
		if(pageNo < 0 ){ throw new Exception("页数有问题，请检查！"); }
		if(recordPerPage < 0 ){ throw new Exception("每页记录数有问题，请检查！"); }
		if(pageNo == 0 ){ pageNo = 1; }
		if(recordPerPage == 0 ){ recordPerPage = 20 ; }
		String conditions = " 1=1 ";
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.registNo", registNo,"=");
		}
		if(cancelFlag!=null){
			if(cancelFlag.equals("1")){
				if(registStartCancelDate != null && registStartCancelDate.length()>0){
			        conditions = conditions +" AND a.cancelDate >= '" + registStartCancelDate +"'";
			    }
				if(registEndCancelDate != null && registEndCancelDate.length()>0){
			        conditions = conditions +" AND a.cancelDate <= '" + registEndCancelDate +"'";
			    }
				if("".equals(registStartCancelDate) && "".equals(registEndCancelDate)){
					conditions = conditions + " AND (a.cancelDate is not null)";
				}
			}else if(cancelFlag.equals("0")){
				conditions = conditions + " AND a.cancelDate is null ";
			}
		}
		if(callInPhoneNumber!=null&&callInPhoneNumber.trim().length()!=0){
			conditions = conditions + " AND (a.phonenumber = '"+callInPhoneNumber+"' or reportorphonenumber = '"+callInPhoneNumber+"') ";
		}
		String conditions_temp2 = " ";
		if((engineNo!=null&&engineNo.trim().length()!=0)||(frameNo!=null&&frameNo.trim().length()!=0)){
			conditions_temp2 = " and ( "+conditions_temp+"  )       " ;
			conditions = conditions + conditions_temp2;
		}
		
		if (policyNo.length() > 0) {
			conditions = conditions+ StringConvert.convertString(" c.policyNo", policyNo,"=");
		}
		if (queryRiskCode != null && !queryRiskCode.trim().equals("")) {
			conditions = conditions+ StringConvert.convertString("a.riskCode", queryRiskCode,"=");
		}
		if (insuredName.length() > 0) {
			conditions = conditions + StringConvert.convertString(" a.insuredName",insuredName, "=");
		}
        if(licenseNo.length() > 0){
        	conditions = conditions+ StringConvert.convertString(" a.licenseNo",licenseNo,"=");
        }
        String caseFlag = "";
        if(caseFlags!=null){
        	for(int i = 0;i<caseFlags.length;i++){
        		if(i == caseFlags.length-1){
        			caseFlag += "'"+caseFlags[i]+"'";
        		}else{
        			caseFlag += "'"+caseFlags[i]+"',";
        		}
        	}
        }
        
		if (caseFlag.trim().length() > 0) {
			conditions = conditions + " AND b.status in (" + caseFlag + ")  AND (a.cancelDate is  null) ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions + StringConvert.convertDate("b.operateDate", operateDate,">=");
		}
		if (operateDateEnd != null && !operateDateEnd.trim().equals("")) {
			conditions = conditions + StringConvert.convertDate("b.operateDate", operateDateEnd,"<=");
		}
		if(comCode!=null&&comCode.length()>0){
			 conditions = conditions +"  and exists (select 1  from prpdcompany  where uppercomcode = '"+comCode+"' and a.comcode = comcode) ";
		}
		
		//start 用于电子档案数据库和核心数据库跨库查询条件拼接 
		String strDZDACondition = "";
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			strDZDACondition = " and a.registno  in (" +
			" SELECT registno FROM prplcompensateear e" +
			" WHERE  e.nodetype='regis' " +
			StringConvert.convertString("e.Earno", strEarLabel, "%") + StringConvert.convertString("e.name", strFname,"=")//中央政策性养殖险专用
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and a.policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,"=") + StringConvert.convertString("d.FIDCARD", strFCardID,"=")//中央政策性种植险专用
			+ ")";
		}

//		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
//			strDZDACondition = "and a.policyno in (" +
//			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
//			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
//			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//农家福组合保险专用
//			+ ")";
//		}
		conditions = conditions + strDZDACondition;
		
		UIRegistAction uiRegistAction = new UIRegistAction();

		ArrayList registList = new ArrayList();
		PageRecord pageRecord = (PageRecord) uiRegistAction.findByQueryConditions(conditions, String.valueOf(pageNo), String.valueOf(recordPerPage));
		registList = (ArrayList) pageRecord.getResult();
		
		RegistCaseDto[] registCaseDtos = new RegistCaseDto[registList.size()];
		for(int i = 0;i<registList.size();i++){
			RegistCaseDto registCaseDto = new RegistCaseDto();
			PrpLregistDto prpLregistDto = (PrpLregistDto)registList.get(i);
			String caseFlagName = "";
			String status = "";
			if(prpLregistDto.getCancelDate()==null||prpLregistDto.getCancelDate().isEmpty()){
				status = prpLregistDto.getStatus();
				if("1".equals(status)){
					caseFlagName = "未处理";
				}else if("2".equals(status)){
					caseFlagName = "正处理";
				}else if("3".equals(status)){
					caseFlagName = "已处理";
				}else if("4".equals(status)){
					caseFlagName = "已提交";
				}else if("5".equals(status)){
					caseFlagName = "已撤消";
				}
			}else{
				caseFlagName = "已注销";
			}
			registCaseDto.setCaseFlag(caseFlagName);
			registCaseDto.setRegistNo(prpLregistDto.getRegistNo());
			registCaseDto.setPolicyNo(prpLregistDto.getPolicyNo());
			registCaseDto.setInsuredName(prpLregistDto.getInsuredName());
			registCaseDto.setOperateName(prpLregistDto.getReceiverName());
			registCaseDto.setOperateDate(prpLregistDto.getOperateDate().toString(DateTime.YEAR_TO_DAY));
			registCaseDtos[i] = registCaseDto;
		}
		
		RegistCaseDtoInfo registCaseDtoInfo = new RegistCaseDtoInfo();
		registCaseDtoInfo.setRegistCaseDtoList(registCaseDtos);
		registCaseDtoInfo.setPageNo(pageRecord.getPageNo());
		registCaseDtoInfo.setRecordPerPage(pageRecord.getRowsPerPage());
		registCaseDtoInfo.setTotalCount(pageRecord.getCount());
		registCaseDtoInfo.setTotalPage(pageRecord.getTotalPageCount());
		return registCaseDtoInfo;
	}
	private String getInsqlRegistnoAndPolicy(String engineNo, String frameNo) throws Exception {
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            String sql1 = " SELECT policyno                                   "+
				            "   FROM prpcitemcar                                "+
				            "  where 1 = 1                                      ";
			if(engineNo!=null&&engineNo.trim().length()>0){
				sql1 += "    and reverse(engineno) like reverse('%"+engineNo+"')  ";
			}
			if(frameNo!=null&&frameNo.trim().length()>0){
				sql1 +=   "    and reverse(frameno) like reverse('%"+frameNo+"')   ";
			}
			resultSet = dbManager.executeQuery(sql1);	 
			List<String> policyList = new ArrayList<String>();
			while(resultSet.next()){
				policyList.add(dbManager.getString(resultSet,1));
			}
			
			String sql2 = " SELECT registno                                   "+
            "   FROM prplregist                                "+
            "  where 1 = 1                                      ";
			if(engineNo!=null&&engineNo.trim().length()>0){
			sql2 += "    and reverse(engineno) like reverse('%"+engineNo+"')  ";
			}
			if(frameNo!=null&&frameNo.trim().length()>0){
			sql2 +=   "    and reverse(frameno) like reverse('%"+frameNo+"')   ";
			} 
			
			resultSet2 = dbManager.executeQuery(sql2);
			List<String> registNoList = new ArrayList<String>();
			while(resultSet2.next()){
				registNoList.add(dbManager.getString(resultSet2,1));
			}
            StringBuffer sqlconditions = new StringBuffer();
			int index = 0;
            for(int i =0;i<policyList.size();i++){
            	String policyNo = policyList.get(i);
            	if(index == 0){
            		sqlconditions.append("or a.policyno in ( '"+policyNo+"'");
            		if(policyList.size()==1){
            			sqlconditions.append(") ");
            		}
            		index++;
            	}else if(index == 999||i==policyList.size()-1){
            		sqlconditions.append(",'"+policyNo+"') ");
            		index =0;
            	}else{
            		sqlconditions.append(",'"+policyNo+"'");
            		index++;
            	}
            }
            
            index = 0;
            for(int i =0;i<registNoList.size();i++){
            	String registNo = registNoList.get(i);
            	if(index == 0){
            		sqlconditions.append("or a.registno in ( '"+registNo+"'");
            		if(registNoList.size()==1){
            			sqlconditions.append(") ");
            		}
            		index++;
            	}else if(index == 999||i==registNoList.size()-1){
            		sqlconditions.append(",'"+registNo+"') ");
            		index =0;
            	}else{
            		sqlconditions.append(",'"+registNo+"'");
            		index++;
            	}
            }
            
            String sqlconditionsstr  = sqlconditions.toString();
            if(sqlconditionsstr!=null&&sqlconditionsstr.length()>=2){
            	return sqlconditionsstr.substring(2,sqlconditionsstr.length()-1);
            }else{
            	return " 1=1";
            }
            
        }catch(Exception exception){
            throw exception;
        }finally{
            if(resultSet!=null){
		      resultSet.close();//结果集关闭
		    }
		    if(resultSet2!=null){
		      resultSet2.close();//结果集关闭
		    }
            dbManager.close();
        }
		
	}
	private boolean isEmpty(String str){
		if(str!=null&&str.trim().length()>0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 农险案件信息查询
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	public AgriRegistCaseDetailInfo getAgriRegistCaseDetailInfo(String registNo) throws Exception {
		if(isEmpty(registNo)){ throw new Exception("案件号是必传参数，请检查！");}
		registNo = registNo.trim();
		DBManager dbManager = new DBManager();
		AgriRegistCaseDetailInfo agriRegistCaseDetailInfo = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			//获取案件信息
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			//获取事故者信息
			AcciPersonDto[] acciPersonDtos = getAcciPersonDto(dbManager,registNo);
			//获取耳标号信息
			BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
			String conditions2 = " registno = '"+registNo+"' and nodetype = 'regis'";
			ArrayList<PrplcompensateearDto>   prplcompensateearDtoList =  (ArrayList<PrplcompensateearDto>) blPrplcompensateearFacade.findByConditions(conditions2);
			//获取出险详细信息
			String[] damageMessages = getDamageMessage(registNo);
			//获取出险摘要
			String strTextContext = getTextContext(registNo);
			
			
			//数据转换(耳标号清单信息)
			EarLabelDto[] earNos = new EarLabelDto[prplcompensateearDtoList.size()];
			for(int i = 0;i<prplcompensateearDtoList.size();i++){
				EarLabelDto earLabelDto = new EarLabelDto();
				PrplcompensateearDto prplcompensateearDto = prplcompensateearDtoList.get(i);
				earLabelDto.setEarNo(prplcompensateearDto.getEarno());
				earLabelDto.setEarInusreListCode(prplcompensateearDto.getInusrelistcode());
				earLabelDto.setEarKindCode(prplcompensateearDto.getKindcode());
				earLabelDto.setFcode(prplcompensateearDto.getFcode());
				earLabelDto.setIdCard(prplcompensateearDto.getId_card());
				earLabelDto.setName(prplcompensateearDto.getName());
				earLabelDto.setBank(prplcompensateearDto.getBank());
				earLabelDto.setAccount(prplcompensateearDto.getAccount());
				earLabelDto.setEstimateloss(String.valueOf(prplcompensateearDto.getEstimateloss()));
				earLabelDto.setAreaCode(prplcompensateearDto.getBreedingareacode());
				earLabelDto.setAreaName(prplcompensateearDto.getBreedingareaname());
				earLabelDto.setEarUnitAmount(String.valueOf(prplcompensateearDto.getUnitamount()));
				earNos[i] = earLabelDto;
			}
			
			//数据转换(主数据)
			agriRegistCaseDetailInfo = new AgriRegistCaseDetailInfo();
			agriRegistCaseDetailInfo.setRiskCode(prpLregistDto.getRiskCode());
			agriRegistCaseDetailInfo.setPolicyNo(prpLregistDto.getPolicyNo());
			agriRegistCaseDetailInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY));
			String damageStartHour = prpLregistDto.getDamageStartHour();
			String[] damageStartTime = null;
			if(damageStartHour!=null){
				damageStartTime = damageStartHour.split(":");
			}
			if(damageStartTime!=null){
				if(damageStartTime.length>0){
					agriRegistCaseDetailInfo.setDamageStartHour(damageStartTime[0]);
				}
				if(damageStartTime.length>1){
					agriRegistCaseDetailInfo.setDamageStartMinute(damageStartTime[1]);
				}
			}
			agriRegistCaseDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
			agriRegistCaseDetailInfo.setDamageName(prpLregistDto.getDamageName());
			agriRegistCaseDetailInfo.setDamageMessage(damageMessages);
			agriRegistCaseDetailInfo.setReportorName(prpLregistDto.getReportorName());
			agriRegistCaseDetailInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY));
			agriRegistCaseDetailInfo.setReportHour(transTimeToHourMinute(prpLregistDto.getReportHour()));
			agriRegistCaseDetailInfo.setReportType(prpLregistDto.getReportType());
			agriRegistCaseDetailInfo.setLinkerName(prpLregistDto.getLinkerName());
			agriRegistCaseDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			agriRegistCaseDetailInfo.setLossesNumber(String.valueOf(prpLregistDto.getLossesNumber()));
			agriRegistCaseDetailInfo.setLossesUnitCode(prpLregistDto.getLossesUnitCode());
			agriRegistCaseDetailInfo.setAddressCode(prpLregistDto.getAddressCode());
			agriRegistCaseDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			agriRegistCaseDetailInfo.setEstiCurrency(prpLregistDto.getEstiCurrency());
			agriRegistCaseDetailInfo.setEstimateLoss(String.valueOf(prpLregistDto.getEstimateLoss()));
			agriRegistCaseDetailInfo.setLossName(prpLregistDto.getLossName());
			agriRegistCaseDetailInfo.setOperatorCode(prpLregistDto.getOperatorCode());
			UICodeAction uiCodeAction = new UICodeAction();
			agriRegistCaseDetailInfo.setOperatorName(uiCodeAction.translateUserCode(prpLregistDto.getOperatorCode(), true));
			agriRegistCaseDetailInfo.setMakeCom(prpLregistDto.getMakeCom());
			agriRegistCaseDetailInfo.setMakeComName(uiCodeAction.translateComCode(prpLregistDto.getMakeCom(), true));
			agriRegistCaseDetailInfo.setRemark(prpLregistDto.getRemark());
			agriRegistCaseDetailInfo.setTextContext(strTextContext);
			agriRegistCaseDetailInfo.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
			agriRegistCaseDetailInfo.setCatastropheName1(prpLregistDto.getCatastropheName1());
			agriRegistCaseDetailInfo.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
			agriRegistCaseDetailInfo.setCatastropheName2(prpLregistDto.getCatastropheName2());
			agriRegistCaseDetailInfo.setAcciPersonDtoList(acciPersonDtos);
			agriRegistCaseDetailInfo.setEarNoList(earNos);
		} catch (Exception e) {
			throw e;
		}finally{
			dbManager.close();
		}
		return agriRegistCaseDetailInfo;
	}
	
	
	
	/**
	 * 货运险案件信息获取
	 * @param registNo
	 * @return
	 * @throws Exception
	 */
	public TransportRegistCaseDetailInfo getTransportRegistCaseDetailInfo(String registNo) throws Exception {
		if(isEmpty(registNo)){ throw new Exception("案件号是必传参数，请检查！");}
		registNo = registNo.trim();
		TransportRegistCaseDetailInfo transportRegistCaseDetailInfo = null;
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			//获取案件信息
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			//获取出险摘要
			String strTextContext = getTextContext(registNo);
			//获取联系人信息
			RelatePersonDto[] relatePersonDtos = getRelatePersonDtos(dbManager,registNo);
			
			
			//数据转换（主信息）
			transportRegistCaseDetailInfo = new TransportRegistCaseDetailInfo();
			transportRegistCaseDetailInfo.setRiskCode(prpLregistDto.getRiskCode());
			transportRegistCaseDetailInfo.setPolicyNo(prpLregistDto.getPolicyNo());
			transportRegistCaseDetailInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY));
			transportRegistCaseDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
			transportRegistCaseDetailInfo.setDamageName(prpLregistDto.getDamageName());
			transportRegistCaseDetailInfo.setReportorName(prpLregistDto.getReportorName());
			transportRegistCaseDetailInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY));
			transportRegistCaseDetailInfo.setReportHour(transTimeToHourMinute(prpLregistDto.getReportHour()));
			transportRegistCaseDetailInfo.setReportType(prpLregistDto.getReportType());
			transportRegistCaseDetailInfo.setLinkerName(prpLregistDto.getLinkerName());
			transportRegistCaseDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			transportRegistCaseDetailInfo.setAddressCode(prpLregistDto.getAddressCode());
			transportRegistCaseDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			transportRegistCaseDetailInfo.setEstiCurrency(prpLregistDto.getEstiCurrency());
			transportRegistCaseDetailInfo.setEstimateLoss(String.valueOf(prpLregistDto.getEstimateLoss()));
			transportRegistCaseDetailInfo.setLossName(prpLregistDto.getLossName());
			transportRegistCaseDetailInfo.setRemark(prpLregistDto.getRemark());
			transportRegistCaseDetailInfo.setRelatePersonDtoList(relatePersonDtos);
			transportRegistCaseDetailInfo.setOperatorCode(prpLregistDto.getOperatorCode());
			UICodeAction uiCodeAction = new UICodeAction();
			transportRegistCaseDetailInfo.setOperatorName(uiCodeAction.translateUserCode(prpLregistDto.getOperatorCode(),true));
			transportRegistCaseDetailInfo.setMakeCom(prpLregistDto.getMakeCom());
			transportRegistCaseDetailInfo.setMakeComName(uiCodeAction.translateComCode(prpLregistDto.getMakeCom(), true));
			transportRegistCaseDetailInfo.setTextContext(strTextContext);
			transportRegistCaseDetailInfo.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
			transportRegistCaseDetailInfo.setCatastropheName1(prpLregistDto.getCatastropheName1());
			transportRegistCaseDetailInfo.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
			transportRegistCaseDetailInfo.setCatastropheName2(prpLregistDto.getCatastropheName2());
		} catch (Exception e) {
			throw e;
		} finally{
			dbManager.close();
		}
		return transportRegistCaseDetailInfo;
	}
	
	/**
	 * 财产险案件信息
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	public PropRegistCaseDetailInfo getPropRegistCaseDetailInfo(String registNo) throws Exception {
		if(isEmpty(registNo)){ throw new Exception("案件号是必传参数，请检查！");}
		registNo = registNo.trim();
		PropRegistCaseDetailInfo propRegistCaseDetailInfo = null;
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			//获取案件信息
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			//获取出险摘要
			String strTextContext = getTextContext(registNo);
			//获取联系人信息
			RelatePersonDto[] relatePersonDtos = getRelatePersonDtos(dbManager,registNo);
			
			//数据转换（主信息）
			propRegistCaseDetailInfo = new PropRegistCaseDetailInfo();
			propRegistCaseDetailInfo.setRiskCode(prpLregistDto.getRiskCode());
			propRegistCaseDetailInfo.setPolicyNo(prpLregistDto.getPolicyNo()); 
			propRegistCaseDetailInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY)); 
			String damageStartHour = prpLregistDto.getDamageStartHour();
			String[] damageStartTime = null;
			if(damageStartHour!=null){
				damageStartTime = damageStartHour.split(":");
			}
			if(damageStartTime!=null){
				if(damageStartTime.length>0){
					propRegistCaseDetailInfo.setDamageStartHour(damageStartTime[0]); 
				}
				if(damageStartTime.length>1){
					propRegistCaseDetailInfo.setDamageStartMinute(damageStartTime[1]); 
				}
			}
			propRegistCaseDetailInfo.setDamageCode(prpLregistDto.getDamageCode()); 
			propRegistCaseDetailInfo.setDamageName(prpLregistDto.getDamageName()); 
			propRegistCaseDetailInfo.setReportorName (prpLregistDto.getReportorName()); 
			propRegistCaseDetailInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY)); 
			propRegistCaseDetailInfo.setReportHour(transTimeToHourMinute(prpLregistDto.getReportHour())); 
			propRegistCaseDetailInfo.setReportType(prpLregistDto.getReportType()); 
			propRegistCaseDetailInfo.setLinkerName(prpLregistDto.getLinkerName()); 
			propRegistCaseDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber()); 
			propRegistCaseDetailInfo.setAddressCode(prpLregistDto.getAddressCode()); 
			propRegistCaseDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress()); 
			propRegistCaseDetailInfo.setEstiCurrency(prpLregistDto.getEstiCurrency()); 
			propRegistCaseDetailInfo.setEstimateLoss(String.valueOf(prpLregistDto.getEstimateLoss())); 
			propRegistCaseDetailInfo.setLossName(prpLregistDto.getLossName()); 
			propRegistCaseDetailInfo.setRelatePersonDtoList(relatePersonDtos); 
			propRegistCaseDetailInfo.setOperatorCode(prpLregistDto.getOperatorCode()); 
			UICodeAction uiCodeAction = new UICodeAction();
			propRegistCaseDetailInfo.setOperatorName(uiCodeAction.translateUserCode(prpLregistDto.getOperatorCode(), true)); 
			propRegistCaseDetailInfo.setMakeCom(prpLregistDto.getMakeCom()); 
			propRegistCaseDetailInfo.setMakeComName(uiCodeAction.translateComCode(prpLregistDto.getMakeCom(), true)); 
			propRegistCaseDetailInfo.setRemark(prpLregistDto.getRemark()); 
			//暂时无法获取
			propRegistCaseDetailInfo.setInsuredCodeRemark(""); 
			propRegistCaseDetailInfo.setTextContext(getTextContext(registNo)); 
			propRegistCaseDetailInfo.setCatastropheCode1(prpLregistDto.getCatastropheCode1()); 
			propRegistCaseDetailInfo.setCatastropheName1(prpLregistDto.getCatastropheName1()); 
			propRegistCaseDetailInfo.setCatastropheCode2(prpLregistDto.getCatastropheCode2()); 
			propRegistCaseDetailInfo.setCatastropheName2(prpLregistDto.getCatastropheName2()); 
			
		} catch (Exception e) {
			throw e;
		} finally{
			dbManager.close();
		}
		
		return propRegistCaseDetailInfo;
	}
	/**
	 * 意健险案件详细信息
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	public HealthRegistCaseDetailInfo getHealthRegistCaseDetailInfo(String registNo) throws Exception {
		if(isEmpty(registNo)){ throw new Exception("案件号是必传参数，请检查！");}
		registNo = registNo.trim();
		HealthRegistCaseDetailInfo healthRegistCaseDetailInfo = null;
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			//获取案件信息
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			//获取事故者信息
			AcciPersonDto[] acciPersonDtos = getAcciPersonDto(dbManager,registNo);
			//数据转换（主信息）
			healthRegistCaseDetailInfo = new HealthRegistCaseDetailInfo();
			healthRegistCaseDetailInfo.setRiskCode(prpLregistDto.getRiskCode());
			healthRegistCaseDetailInfo.setPolicyNo(prpLregistDto.getPolicyNo());
			healthRegistCaseDetailInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY));
			String damageStartHour = prpLregistDto.getDamageStartHour();
			String[] damageStartTime = null;
			if(damageStartHour!=null){
				damageStartTime = damageStartHour.split(":");
			}
			if(damageStartTime!=null){
				if(damageStartTime.length>0){
					healthRegistCaseDetailInfo.setDamageStartHour(damageStartTime[0]);
				}
				if(damageStartTime.length>1){
					healthRegistCaseDetailInfo.setDamageStartMinute(damageStartTime[1]);
				}
			}
			healthRegistCaseDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
			healthRegistCaseDetailInfo.setDamageName(prpLregistDto.getDamageName());
			healthRegistCaseDetailInfo.setReportorName(prpLregistDto.getReportorName());
			healthRegistCaseDetailInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY));
			healthRegistCaseDetailInfo.setReportHour(transTimeToHourMinute(prpLregistDto.getReportHour()));
			healthRegistCaseDetailInfo.setReportType(prpLregistDto.getReportType());
			healthRegistCaseDetailInfo.setLinkerName(prpLregistDto.getLinkerName());
			healthRegistCaseDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			healthRegistCaseDetailInfo.setLinkerAddress(prpLregistDto.getLinkerAddress());
			healthRegistCaseDetailInfo.setClauseType(prpLregistDto.getClauseType());
			healthRegistCaseDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			healthRegistCaseDetailInfo.setDamageTypeCode(prpLregistDto.getDamageTypeCode());
			healthRegistCaseDetailInfo.setDamageTypeName(prpLregistDto.getDamageTypeName());
			healthRegistCaseDetailInfo.setLossesNumber(String.valueOf(prpLregistDto.getLossesNumber()));
			healthRegistCaseDetailInfo.setReportFlag(prpLregistDto.getReportFlag());
			healthRegistCaseDetailInfo.setEstiCurrency(prpLregistDto.getEstiCurrency());
			healthRegistCaseDetailInfo.setAcciPersonDtoList(acciPersonDtos);
			healthRegistCaseDetailInfo.setOperatorCode(prpLregistDto.getOperatorCode());
			UICodeAction uiCodeAction = new UICodeAction();
			healthRegistCaseDetailInfo.setOperatorName(uiCodeAction.translateUserCode(prpLregistDto.getOperatorCode(), true));
			healthRegistCaseDetailInfo.setMakeCom(prpLregistDto.getMakeCom());
			healthRegistCaseDetailInfo.setMakeComName(uiCodeAction.translateComCode(prpLregistDto.getMakeCom(), true));
			healthRegistCaseDetailInfo.setRemark(prpLregistDto.getRemark());
			healthRegistCaseDetailInfo.setContext(getTextContext(registNo));
			healthRegistCaseDetailInfo.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
			healthRegistCaseDetailInfo.setCatastropheName1(prpLregistDto.getCatastropheName1());
			healthRegistCaseDetailInfo.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
			healthRegistCaseDetailInfo.setCatastropheName2(prpLregistDto.getCatastropheName2());
		} catch (Exception e) {
			throw e;
		} finally{
			dbManager.close();
		}
		return healthRegistCaseDetailInfo;
	}
	/**
	 * 责任险案件详细信息
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	public RespRegistCaseDetailInfo getRespRegistCaseDetailInfo(String registNo) throws Exception {
		if(isEmpty(registNo)){ throw new Exception("案件号是必传参数，请检查！");}
		registNo = registNo.trim();
		//获取案件信息
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		
		//数据转换（主信息）
		RespRegistCaseDetailInfo respRegistCaseDetailInfo = new RespRegistCaseDetailInfo();
		respRegistCaseDetailInfo.setRiskCode(prpLregistDto.getRiskCode());
		respRegistCaseDetailInfo.setPolicyNo(prpLregistDto.getPolicyNo());
		respRegistCaseDetailInfo.setDamageStartDate(prpLregistDto.getDamageStartDate().toString(DateTime.YEAR_TO_DAY));
		String damageStartHour = prpLregistDto.getDamageStartHour();
		String[] damageStartTime = null;
		if(damageStartHour!=null){
			damageStartTime = damageStartHour.split(":");
		}
		if(damageStartTime!=null){
			if(damageStartTime.length>0){
				respRegistCaseDetailInfo.setDamageStartHour(damageStartTime[0]);
			}
			if(damageStartTime.length>1){
				respRegistCaseDetailInfo.setDamageStartMinute(damageStartTime[1]);
			}
		}
		respRegistCaseDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
		respRegistCaseDetailInfo.setDamageName(prpLregistDto.getDamageName());
		respRegistCaseDetailInfo.setReportorName(prpLregistDto.getReportorName());
		respRegistCaseDetailInfo.setReportDate(prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY));
		respRegistCaseDetailInfo.setReportHour(transTimeToHourMinute(prpLregistDto.getReportHour()));
		respRegistCaseDetailInfo.setReportType(prpLregistDto.getReportType());
		respRegistCaseDetailInfo.setLinkerName(prpLregistDto.getLinkerName());
		respRegistCaseDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
		respRegistCaseDetailInfo.setAddressCode(prpLregistDto.getAddressCode());
		respRegistCaseDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
		respRegistCaseDetailInfo.setEstiCurrency(prpLregistDto.getEstiCurrency());
		respRegistCaseDetailInfo.setEstimateLoss(String.valueOf(prpLregistDto.getEstimateLoss()));
		respRegistCaseDetailInfo.setLossName(prpLregistDto.getLossName());
		respRegistCaseDetailInfo.setOperatorCode(prpLregistDto.getOperatorCode());
		UICodeAction uiCodeAction = new UICodeAction();
		respRegistCaseDetailInfo.setOperatorName(uiCodeAction.translateUserCode(prpLregistDto.getOperatorCode(), true));
		respRegistCaseDetailInfo.setMakeComName(uiCodeAction.translateComCode(prpLregistDto.getMakeCom(), true));
		respRegistCaseDetailInfo.setMakeCom(prpLregistDto.getMakeCom());
		respRegistCaseDetailInfo.setRemark(prpLregistDto.getRemark());
		respRegistCaseDetailInfo.setContext(getTextContext(registNo));
		respRegistCaseDetailInfo.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
		respRegistCaseDetailInfo.setCatastropheName1(prpLregistDto.getCatastropheName1());
		respRegistCaseDetailInfo.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
		respRegistCaseDetailInfo.setCatastropheName2(prpLregistDto.getCatastropheName2());
		
		return respRegistCaseDetailInfo;
	}
	/**
	 * 获取事故者信息
	 * @param dbManager 
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	private AcciPersonDto[] getAcciPersonDto(DBManager dbManager, String registNo) throws Exception {
		String conditions1 = "certino = '"+registNo+"'";
		DBPrpLacciPerson dbPrpLacciPerson = new DBPrpLacciPerson(dbManager);
		ArrayList<PrpLacciPersonDto>  prpLacciPersonDtoList = (ArrayList<PrpLacciPersonDto>) dbPrpLacciPerson.findByConditions(conditions1);
		//数据转换(事故者信息)
		AcciPersonDto[] acciPersonDtos = new AcciPersonDto[prpLacciPersonDtoList.size()];
		for(int i = 0;i<prpLacciPersonDtoList.size();i++){
			AcciPersonDto acciPersonDto = new AcciPersonDto();
			PrpLacciPersonDto prpLacciPersonDto = prpLacciPersonDtoList.get(i);
			acciPersonDto.setSerialNo(String.valueOf(prpLacciPersonDto.getSerialNo()));
			acciPersonDto.setFamilyNo(String.valueOf(prpLacciPersonDto.getFamilyNo()));
			acciPersonDto.setAcciCode(prpLacciPersonDto.getAcciCode());
			acciPersonDto.setAcciName(prpLacciPersonDto.getAcciName());
			acciPersonDto.setSex(prpLacciPersonDto.getSex());
			acciPersonDto.setAge(String.valueOf( prpLacciPersonDto.getAge()));
			acciPersonDto.setIdentifyNumber(prpLacciPersonDto.getIdentifyNumber());
			acciPersonDtos[i] = acciPersonDto;
		}
		return acciPersonDtos;
	}
	/**
	 * 获取联系人信息
	 * @param dbManager
	 * @param registNo 报案号
	 * @return
	 * @throws Exception 
	 */
	private RelatePersonDto[] getRelatePersonDtos(DBManager dbManager,
			String registNo) throws Exception {
		//查询数据
		DBPrpLrelatePerson dbPrpLrelatePerson = new DBPrpLrelatePerson(dbManager);
		String conditions = " registno = '"+registNo+"'";
		ArrayList<PrpLrelatePersonDto> prpLrelatePersonDtoList = new ArrayList<PrpLrelatePersonDto>();
		prpLrelatePersonDtoList = (ArrayList<PrpLrelatePersonDto>) dbPrpLrelatePerson.findByConditions(conditions);
		//数据转换
		RelatePersonDto[] relatePersonDtos = new RelatePersonDto[prpLrelatePersonDtoList.size()];
		for(int i = 0; i<prpLrelatePersonDtoList.size();i++){
			PrpLrelatePersonDto prpLrelatePersonDto = prpLrelatePersonDtoList.get(i);
			RelatePersonDto relatePersonDto = new RelatePersonDto();
			relatePersonDto.setSerialNo(String.valueOf(prpLrelatePersonDto.getSerialNo()));
			relatePersonDto.setPersonName(prpLrelatePersonDto.getPersonName());
			relatePersonDto.setPhoneNumber(prpLrelatePersonDto.getPhoneNumber());
			relatePersonDto.setMobile(prpLrelatePersonDto.getMobile());
			relatePersonDto.setRemark(prpLrelatePersonDto.getRemark());
			relatePersonDtos[i] = relatePersonDto;
		}
		return relatePersonDtos;
	}
	/**
	 * 将时间  hh:mm:ss  转换为需要的 hh:mm
	 * @param reportHour
	 * @return
	 */
	private String transTimeToHourMinute(String reportHour) {
		String time = reportHour;
		if(time != null){
			String[] times = time.split(":");
			if(times.length>=2){
				time = times[0]+":"+times[1];
			}else{
				time = "";
			}
		}
		return time;
	}
	/**
	 * 获取详细出险原因
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	private String[] getDamageMessage(String registNo) throws Exception {
		String conditions = "texttype = '06' and registno = '"+registNo+"'";
		BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList<PrpLregistTextDto>  prpLregistTextDtoList = (ArrayList<PrpLregistTextDto>) blPrpLregistTextFacade.findByConditions(conditions);
		String[] damageMessages = new String[prpLregistTextDtoList.size()];
		for(int i = 0;i<prpLregistTextDtoList.size();i++){
			damageMessages[i] = prpLregistTextDtoList.get(i).getContext();
		}
		return damageMessages;
	}
	/**
	 * 获取出险摘要
	 * @param registNo
	 * @return
	 * @throws Exception 
	 */
	private String getTextContext(String registNo) throws Exception {
		BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
		String conditions = "texttype = '1' and registno = '"+registNo+"'";
		ArrayList<PrpLregistTextDto> prpLregistTextDtoList = (ArrayList<PrpLregistTextDto>) blPrpLregistTextFacade.findByConditions(conditions);
		String strTextContext = "";
		for(int i = 0;i<prpLregistTextDtoList.size();i++){
			strTextContext += prpLregistTextDtoList.get(i).getContext();
		}
		return strTextContext;
	}
	
	

	
}
