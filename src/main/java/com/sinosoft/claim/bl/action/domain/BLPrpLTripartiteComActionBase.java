package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLTripartiteCom;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDTripartiteCom第三方数据维护修理厂表的业务逻辑对象类<br>
 * 创建于 2012/11/9
 */
public class BLPrpLTripartiteComActionBase {
	 private static Log log = LogFactory.getLog(BLPrpLTripartiteComActionBase.class.getName());
	   
	 /**
	  * 构造函数
	  */
	 public BLPrpLTripartiteComActionBase(){
		 
	 }
	 
	 /**
	  * 插入一条数据
	  * @param dbManager DB管理器
	  * @param prpCreditAssureDto prpCreditAssureDto
	  * @throws Exception
	  */
	  public void insert(DBManager dbManager,PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
	      //插入记录
	      dbPrpLTripartiteCom.insert(prpLTripartiteComDto);
	  }
	  
	  public void insertAll(DBManager dbManager,Collection<PrpLTripartiteComDto> prpLTripartiteComDtos)throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		  //插入记录
		  dbPrpLTripartiteCom.insertAll(prpLTripartiteComDtos);
	  }
	  
	  public void update(DBManager dbManager,String enterpriseCode,String approveFlag,String suggestion) throws Exception{
		  DBPrpLTripartiteCom dbPrpDTripartiteCom = new DBPrpLTripartiteCom(dbManager);
	      //插入记录
	      dbPrpDTripartiteCom.update(enterpriseCode, approveFlag, suggestion);
	  }
	  
	  public void update(DBManager dbManager,String enterpriseCode,PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
	      //插入记录
		  dbPrpLTripartiteCom.update(enterpriseCode,prpLTripartiteComDto);
	  }
	  
	  public void delete(DBManager dbManager,String enterpriseCode) throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		  dbPrpLTripartiteCom.delete(enterpriseCode);
	  }
	    
	  public static Collection findConditions(DBManager dbManager,String conditions) throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		  Collection collection = new ArrayList();
		  collection = dbPrpLTripartiteCom.findByConditions(conditions, 0, 0);
		  return collection;
	  }
	  
	  public static Collection findTripartiteInfoByConditions(DBManager dbManager,String conditions) throws Exception{
		  DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		  Collection collection = new ArrayList();
		  collection = dbPrpLTripartiteCom.findTripartiteInfoByConditions(conditions, 0, 0);
		  return collection;
	  }
	    
	  public PrpLTripartiteComDto findByKeys(DBManager dbManager,String conditions) throws Exception{
		  PrpLTripartiteComDto prpLTripartiteComDto = new PrpLTripartiteComDto();
		  DBPrpLTripartiteCom dbPrpDTripartiteCom = new DBPrpLTripartiteCom(dbManager);
		  prpLTripartiteComDto = dbPrpDTripartiteCom.findByKeys(conditions);
		  return prpLTripartiteComDto;
	  }
	  /**
	     * 按条件查询多条数据
	     * @param dbManager DB管理器
	     * @param conditions 查询条件
	     * @param pageNo 页号
	     * @param rowsPerPage 每页的行数
	     * @return PageRecord 查询的一页的结果
	     * @throws Exception
	     */
	    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
	            throws Exception{
	    	DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);
	        Collection collection = new ArrayList();
	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }
	        PageRecord pageRecord = null;
	        int count = dbPrpLTripartiteCom.getCount(SqlUtils.getWherePartForGetCount(conditions));
		    collection = dbPrpLTripartiteCom.findByConditions(conditions,pageNo,rowsPerPage);
		    pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	        return pageRecord;
	    }
	    
	    /**
	     * 查询满足模糊查询条件的记录数
	     * @param dbManager DB管理器
	     * @param conditions 模糊查询条件
	     * @return 满足模糊查询条件的记录数
	     * @throws Exception
	     */
	    public int getCount(DBManager dbManager,String conditions) 
	        throws Exception{
	    	DBPrpLTripartiteCom dbPrpLTripartiteCom = new DBPrpLTripartiteCom(dbManager);

	    	if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }
	    	int count = dbPrpLTripartiteCom.getCount(conditions);
	        return count;
	    }   
}
