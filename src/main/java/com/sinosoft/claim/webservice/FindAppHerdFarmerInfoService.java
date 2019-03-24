package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.bl.facade.BLHerdsettlelistFacade;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 驻点员App农户查询理赔部分接口（养殖险）
 * @author CDB
 *
 */
public class FindAppHerdFarmerInfoService {
	public FindAppFarmerInfo findAppHerdFarmerInfoList(String fName,String fCode,String fIdcard,String registNo,String claimNo,String earNo,String businessCity,String businessArea,String riskCode,String startOperateDate,String endOperateDate,String startDate,String endDate,String userCode,int intPageNum, int intPageCount) throws Exception{
		FindAppFarmerInfo findAppFarmerInfo = null;
		ArrayList<FindAppFarmerInfoList> collection = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		String strWhere ="";
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
	    if(riskCode == null || riskCode.trim().equals("")){
	    	findAppFarmerInfo = new FindAppFarmerInfo();
	    	findAppFarmerInfo.setErrorMessage("险种号不能为空");
		   return findAppFarmerInfo;
	    }
	    if(intPageNum<1){
	    	findAppFarmerInfo = new FindAppFarmerInfo();
	    	findAppFarmerInfo.setErrorMessage("页数不能小于1");
	    	return findAppFarmerInfo;
	    }
	    if(intPageCount<1){
	    	findAppFarmerInfo = new FindAppFarmerInfo();
	    	findAppFarmerInfo.setErrorMessage("每页个数不能小于1");
	    	return findAppFarmerInfo;
	    }
	    
//	    if((fName == null || fName.trim().equals(""))&&(fCode == null || fCode.trim().equals(""))&&(fIdcard == null || fIdcard.trim().equals("")))
//	    {
//	    	residentAppInfor = new ResidentAppInfor();
//	    	residentAppInfor.setErrorMessage("农户姓名、身份证、农户代码不能都为空");
//	    	return residentAppInfor;
//	    }
	    if(!"32".equals(riskCode.substring(0, 2))){
	    	findAppFarmerInfo = new FindAppFarmerInfo();
	    	findAppFarmerInfo.setErrorMessage("险种必须为养殖险");
	    	return findAppFarmerInfo;
	    }
		try{
			if(registNo != null && !registNo.trim().equals("")){//根据报案号查询
				if(riskCode!=null && riskCode.trim().equals("3224")){
				//if(riskCode!=null && (riskCode.trim().equals("3228")||riskCode.trim().equals("3224"))){//险种为3228、3224的查询，3228、3224险种没有耳标号
					strWhere = " and m.REPORTCODE='" + registNo + "' ";
					strWhere += " and p.NODETYPE='compe'";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.HerdSpeciquery(strWhere,  riskCode,  intPageNum, intPageCount);
				}else{//其他有清单险种的查询
					strWhere = " and m.REPORTCODE='" + registNo + "' ";
					//strWhere += " and p.NODETYPE='compe'";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					if(earNo!=null && !earNo.trim().equals("")){
						strWhere += " and p.earlabel='"+earNo+"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0){
					FindAppFarmerInfoList[] findAppResult = new FindAppFarmerInfoList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						findAppResult[i] = collection.get(i);
					}
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setFindAppFarmerInfoList(findAppResult);
				}
				else{
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setErrorMessage("数据为空");
				}
				
			}else if(claimNo != null && !claimNo.trim().equals("")){//根据立案号查询
				prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
				String registNumber = prpLclaimDto.getRegistNo();
				if(riskCode!=null && riskCode.trim().equals("3224")){
				//if(riskCode!=null && (riskCode.trim().equals("3228")||riskCode.trim().equals("3224"))){//险种为3228、3224的查询，3228、3224险种没有耳标号
					strWhere = " and m.REPORTCODE='" + registNumber + "' ";
					strWhere += " and p.NODETYPE='compe'";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.HerdSpeciquery(strWhere,  riskCode, intPageNum, intPageCount);
				}else{//其他有清单险种的查询
					strWhere = " and m.REPORTCODE='" + registNumber + "' ";
					//strWhere += " and p.NODETYPE='compe'";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					if(earNo!=null && !earNo.trim().equals("")){
						strWhere += " and p.earlabel='"+earNo+"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0){
					FindAppFarmerInfoList[] findAppResult = new FindAppFarmerInfoList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						findAppResult[i] = collection.get(i);
					}
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setFindAppFarmerInfoList(findAppResult);
				}
				else{
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setErrorMessage("数据为空");
				}
				
			}else{//报案号、立案号都不输入时的操作
				if(startOperateDate == null || startOperateDate.trim().equals("")){
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setErrorMessage("报案查询起始时间不能为空");
			    	return findAppFarmerInfo;
			    }
			    if(endOperateDate == null || endOperateDate.trim().equals("")){
			    	findAppFarmerInfo = new FindAppFarmerInfo();
			    	findAppFarmerInfo.setErrorMessage("报案查询终止时间不能为空");
			    	return findAppFarmerInfo;
			    }
			    if(startDate == null || startDate.trim().equals("")){
			    	findAppFarmerInfo = new FindAppFarmerInfo();
			    	findAppFarmerInfo.setErrorMessage("起保时间不能为空");
			    	return findAppFarmerInfo;
			    }
			    if(endDate == null || endDate.trim().equals("")){
			    	findAppFarmerInfo = new FindAppFarmerInfo();
			    	findAppFarmerInfo.setErrorMessage("终保时间不能为空");
			    	return findAppFarmerInfo;
			    }
			    if(businessCity == null || businessCity.trim().equals("")){
			    	findAppFarmerInfo = new FindAppFarmerInfo();
			    	findAppFarmerInfo.setErrorMessage("镇不能为空");
			    	return findAppFarmerInfo;
			    }
			    if(businessArea == null || businessArea.trim().equals("")){
			    	findAppFarmerInfo = new FindAppFarmerInfo();
			    	findAppFarmerInfo.setErrorMessage("村不能为空");
			    	return findAppFarmerInfo;
			    }
				String registNos = "";
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				StringBuffer bufsql = new StringBuffer();
				bufsql.append("select l.registno from prpcmain c,prplregist l ");
				bufsql.append(" where c.policyno=l.policyno ");
				bufsql.append(" and c.businesscity='");
				bufsql.append(businessCity);
				bufsql.append("' and c.businessarea='");
				bufsql.append(businessArea);
				bufsql.append("' and (c.startdate  between date'");
				bufsql.append(startDate);
				bufsql.append("' and date'");
				bufsql.append(endDate);
				bufsql.append("' or c.enddate  between date'");
				bufsql.append(startDate);
				bufsql.append("' and date'");
				bufsql.append(endDate);
				bufsql.append("')");
				bufsql.append(" and l.reportdate between date'");
				bufsql.append(startOperateDate);
				bufsql.append("' and date'");
				bufsql.append(endOperateDate);
				bufsql.append("' and c.riskcode='");
				bufsql.append(riskCode);
				bufsql.append("'");
				resultSet = dbManager.executeQuery(bufsql.toString());
				if(!resultSet.next()){
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setErrorMessage("数据为空");
					return findAppFarmerInfo;
				}else{
					registNos +="'";
					registNos +=dbManager.getString(resultSet, 1);
					registNos +="'";
					while(resultSet.next()){
						registNos +=",'";
						registNos +=dbManager.getString(resultSet, 1);
						registNos +="'";
					}
				}
				if(riskCode!=null && riskCode.trim().equals("3224")){
				//if(riskCode!=null && (riskCode.trim().equals("3228")||riskCode.trim().equals("3224"))){//险种为3228、3224的查询，3228、3224险种没有耳标号
					strWhere = " and m.REPORTCODE in(";
					strWhere +=registNos;
					strWhere +=")";
					strWhere += " and p.NODETYPE='compe'";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.HerdSpeciquery(strWhere,  riskCode, intPageNum, intPageCount);
				}else{//其他有清单险种的查询
					strWhere = " and m.REPORTCODE in(";
					strWhere +=registNos;
					strWhere +=")";
					if(fName != null && !fName.trim().equals("")){
						strWhere += " and p.fName='"+fName +"' ";
					}
					if(fCode != null && !fCode.trim().equals("")){
						strWhere += " and p.fCode='"+fCode +"' ";
					}
					if(fIdcard != null && !fIdcard.trim().equals("")){
						strWhere += " and p.fIdcard='"+fIdcard +"' ";
					}
					if(earNo!=null && !earNo.trim().equals("")){
						strWhere += " and p.earlabel='"+earNo+"' ";
					}
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					collection = blHerdsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0){
					FindAppFarmerInfoList[] findAppResult = new FindAppFarmerInfoList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						findAppResult[i] = collection.get(i);
					}
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setFindAppFarmerInfoList(findAppResult);
				}
				else{
					findAppFarmerInfo = new FindAppFarmerInfo();
					findAppFarmerInfo.setErrorMessage("数据为空");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return findAppFarmerInfo;
		
	}
}
