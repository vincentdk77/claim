package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBReturnVisit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcomplaint;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLReturnVisitAction {
	
	/**
	 * 投诉查询
	 * @param dbManager
	 * @param conditions
	 * @param pageNo
	 * @param rowsPerPage
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQueryComplaint(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
		DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
		
		Collection collection = new ArrayList();
		
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    int count = dbPrplcomplaint.getCount(SqlUtils.getWherePartForGetCount(conditions));
	    
	    int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    
	    if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = dbPrplcomplaint.findByConditions(conditions, pageNo, rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
	}

	public PageRecord findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception {
		
		DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
		Collection collection = new ArrayList();
		
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    int count = dbPrplreturnvisitswflog.getCountQuery(SqlUtils.getWherePartForGetCount(conditions));
	    
	    int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    
	    if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = dbPrplreturnvisitswflog.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
		// TODO Auto-generated method stub
		
	}
	
	//导出excel
	public Collection findByQueryExpConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception {
		
		DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
		Collection collection = new ArrayList();
		
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    int count = dbPrplreturnvisitswflog.getCountQuery(SqlUtils.getWherePartForGetCount(conditions));
	    
	    int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    
	    if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = dbPrplreturnvisitswflog.findByQueryExpConditions(conditions,pageNo,rowsPerPage);
	    //PageRecord pageRecord = new PageRecord(count,1,1,rowsPerPage,collection);
	    return collection;
		// TODO Auto-generated method stub
		
	}
	
	
	public void save(DBManager dbManager,ReturnVisitDto returnVisitDto) throws Exception{
		DBReturnVisit dbReturnVisit = new DBReturnVisit();
		dbReturnVisit.delete(dbManager, returnVisitDto);
		dbReturnVisit.insert(dbManager, returnVisitDto);
	}
	
	
	/**
	 * 结案回访回访查询，按照支付日期排序
	 * @param dbManager
	 * @param conditions
	 * @param pageNo
	 * @param rowsPerPage
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQueryConditionsEndca(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception {
		
		DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
		Collection collection = new ArrayList();
		
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    int count = dbPrplreturnvisitswflog.getCountQuery(SqlUtils.getWherePartForGetCount(conditions));
	    
	    int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    
	    if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = dbPrplreturnvisitswflog.findByQueryConditionsEndca(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    return pageRecord;
		
	}
	//导出excel
	public Collection findByQueryExpConditionsEndca(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception {
		
		DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
		Collection collection = new ArrayList();
		
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    
	    int count = dbPrplreturnvisitswflog.getCountQuery(SqlUtils.getWherePartForGetCount(conditions));
	    
	    int maxQueryCount = Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    
	    if (maxQueryCount != 0 && count > maxQueryCount) {
			throw new UserException(1, 3, "0000", "查询结果个数超过系统限制");
		}
	    collection = dbPrplreturnvisitswflog.findByQueryConditionsEndca(conditions,pageNo,rowsPerPage);
	    return collection;
		
	}
}
