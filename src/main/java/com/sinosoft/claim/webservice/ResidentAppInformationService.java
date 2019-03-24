package com.sinosoft.claim.webservice;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

import com.sinosoft.claim.webservice.ResidentAppInfor;
import com.sinosoft.claim.webservice.ResidentAppInforList;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;

public class ResidentAppInformationService {
	public ResidentAppInfor getResidentAppInforList(String fName,String fCode,String fIdcard,String registNo,String claimNo,String BusinessZone,String BusinessZoneTown,String riskCode,String startOperateDate,String endOperateDate,String startDate,String endDate,String userCode,int intPageNum, int intPageCount) throws Exception{
		ResidentAppInfor residentAppInfor = null;
		
		ArrayList<ResidentAppInforList> collection = null;
		
		DBManager dbManager = new DBManager();
		
		ResultSet resultSet = null;
		//ResultSet resultSet2 = null;
		String strWhere ="";
	
	    if(riskCode == null || riskCode.trim().equals(""))
	    {
	       residentAppInfor = new ResidentAppInfor();
	       residentAppInfor.setErrorMessage("险种号不能为空");
	    	
		   return residentAppInfor;
	    }
	    if(startOperateDate == null || startOperateDate.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("报案起始时间不能为空");
	    	return residentAppInfor;
		   
	    }
	    
	    if(endOperateDate == null || endOperateDate.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("报案终止时间不能为空");
	    	return residentAppInfor;
		   
	    }
	    if(startDate == null || startDate.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("保单起始时间不能为空");
	    	return residentAppInfor;
		   
	    }
	    if(endDate == null || endDate.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("保单终止时间不能为空");
	    	return residentAppInfor;
		   
	    }
	  
	    if(BusinessZone == null || BusinessZone.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("镇不能为空");
	    	return residentAppInfor;
		   
	    }
	    
	    if(BusinessZoneTown == null || BusinessZoneTown.trim().equals(""))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("村不能为空");
	    	return residentAppInfor;
		   
	    }
	    
	    if(intPageNum<1)
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("页数不能小于1");
	    	return residentAppInfor;
		   
	    }
	    
	    if(intPageCount<1)
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("每页个数不能小于1");
	    	return residentAppInfor;
	    }
	    
//	    if((fName == null || fName.trim().equals(""))&&(fCode == null || fCode.trim().equals(""))&&(fIdcard == null || fIdcard.trim().equals("")))
//	    {
//	    	residentAppInfor = new ResidentAppInfor();
//	    	residentAppInfor.setErrorMessage("农户姓名、身份证、农户代码不能都为空");
//	    	return residentAppInfor;
//	    }
	    if(!"31".equals(riskCode.substring(0, 2)))
	    {
	    	residentAppInfor = new ResidentAppInfor();
	    	residentAppInfor.setErrorMessage("险种必须为种植险");
	    	return residentAppInfor;
	    }
	    
		//String payMentno = null;
		//DateTime payrefDate = null ;
	   
		
		try{
			if(registNo != null && !registNo.trim().equals(""))
			{
				strWhere = " and m.REPORTCODE='" + registNo + "' ";
				strWhere += " and p.NODETYPE='compe'";
				if(fName != null && !fName.trim().equals(""))
				{
					strWhere += " and p.fName='"+fName +"' ";
				}
				if(fCode != null && !fCode.trim().equals(""))
				{
					strWhere += " and p.fCode='"+fCode +"' ";
				}
				if(fIdcard != null && !fIdcard.trim().equals(""))
				{
					strWhere += " and p.fIdcard='"+fIdcard +"' ";
				}
				if("3141".equals(riskCode)||"3140".equals(riskCode))
				{
					BLPlanting31SettleListFacade blPlanting31settlelistFacade = new BLPlanting31SettleListFacade();
					collection = blPlanting31settlelistFacade.query(strWhere, intPageNum, intPageCount);
					
				}
				else
				{
					BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
					collection = blPlantingsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0)
				{
					
					ResidentAppInforList[] residentResult = new ResidentAppInforList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						residentResult[i] = collection.get(i);
					}
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setResidentAppInforList(residentResult);
				}
				else
				{
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setErrorMessage("数据为空");
				}
				
			}
			else if(claimNo != null && !claimNo.trim().equals(""))
			{
				strWhere = " and m.REGISTERCODE='" + claimNo + "' ";
				strWhere += " and p.NODETYPE='compe'";
				if(fName != null && !fName.trim().equals(""))
				{
					strWhere += " and p.fName='"+fName +"' ";
				}
				if(fCode != null && !fCode.trim().equals(""))
				{
					strWhere += " and p.fCode='"+fCode +"' ";
				}
				if(fIdcard != null && !fIdcard.trim().equals(""))
				{
					strWhere += " and p.fIdcard='"+fIdcard +"' ";
				}
				if("3141".equals(riskCode)||"3140".equals(riskCode))
				{
					BLPlanting31SettleListFacade blPlanting31settlelistFacade = new BLPlanting31SettleListFacade();
					collection = blPlanting31settlelistFacade.query(strWhere, intPageNum, intPageCount);
					
				}
				else
				{
					BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
					collection = blPlantingsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0)
				{
					
					ResidentAppInforList[] residentResult = new ResidentAppInforList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						residentResult[i] = collection.get(i);
					}
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setResidentAppInforList(residentResult);
				}
				else
				{
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setErrorMessage("数据为空");
				}
				
			}
			else
			{
				String registNos = "";
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				StringBuffer bufsql = new StringBuffer();
				bufsql.append("select l.registno from prpcmain c,prplregist l ");
				bufsql.append(" where c.policyno=l.policyno ");
				bufsql.append(" and c.businesscity='");
				bufsql.append(BusinessZone);
				bufsql.append("' and c.businessarea='");
				bufsql.append(BusinessZoneTown);
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
				bufsql.append("'");
				resultSet = dbManager.executeQuery(bufsql.toString());
				if(!resultSet.next())
				{
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setErrorMessage("数据为空");
					return residentAppInfor;
				}
				else
				{
					registNos +="'";
					registNos +=dbManager.getString(resultSet, 1);
					registNos +="'";
					while(resultSet.next()){
						registNos +=",'";
						registNos +=dbManager.getString(resultSet, 1);
						registNos +="'";
					}
				}
				strWhere = " and m.REPORTCODE in(";
				strWhere +=registNos;
				strWhere +=")";
				strWhere += " and p.NODETYPE='compe'";
				
				if(fName != null && !fName.trim().equals(""))
				{
					strWhere += " and p.fName='"+fName +"' ";
				}
				if(fCode != null && !fCode.trim().equals(""))
				{
					strWhere += " and p.fCode='"+fCode +"' ";
				}
				if(fIdcard != null && !fIdcard.trim().equals(""))
				{
					strWhere += " and p.fIdcard='"+fIdcard +"' ";
				}
				if("3141".equals(riskCode)||"3140".equals(riskCode))
				{
					BLPlanting31SettleListFacade blPlanting31settlelistFacade = new BLPlanting31SettleListFacade();
					collection = blPlanting31settlelistFacade.query(strWhere, intPageNum, intPageCount);
					
				}
				else
				{
					BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
					collection = blPlantingsettlelistFacade.query(strWhere, intPageNum, intPageCount);
				}
				if(collection != null && collection.size() >0)
				{
					
					ResidentAppInforList[] residentResult = new ResidentAppInforList[collection.size()];
					for(int i = 0;i<collection.size();i++){
						residentResult[i] = collection.get(i);
					}
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setResidentAppInforList(residentResult);
				}
				else
				{
					residentAppInfor = new ResidentAppInfor();
					residentAppInfor.setErrorMessage("数据为空");
				}
				
			}
			
			
		}catch(Exception e){
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return residentAppInfor;
		
	}
	
}
