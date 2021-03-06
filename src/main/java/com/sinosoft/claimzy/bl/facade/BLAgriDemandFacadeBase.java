package com.sinosoft.claimzy.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimDemandAction;
import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimUploadLogAction;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLAgriDemandFacadeBase {
	 private static Logger logger = Logger.getLogger(BLAgriDemandFacadeBase.class);

	    /**
	     * 构造函数
	     */
	    public BLAgriDemandFacadeBase(){
	    }

	    /**
	     * 插入一条数据
	     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
	     * @throws Exception
	     */
	    public void insert(AgriClaimDemandDto agriClaimDemandDto)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //插入记录
	            blAgriClaimDemandAction.insert(dbManager,agriClaimDemandDto);
	            dbManager.commitTransaction();
	        }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	    }

	    /**
	     * 按主键删除一条数据
	     * @param claimCode 理赔编码
	     * @throws Exception
	     */
	    public void delete(String batchNo)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //删除记录
	            blAgriClaimUploadLogAction.delete(dbManager,batchNo);
	            dbManager.commitTransaction();
	        }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	    }

	    /**
	     * 按条件删除数据
	     * @param conditions 删除条件
	     * @throws Exception
	     */
	    public void deleteByConditions(String conditions)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //按条件删除记录
	            blAgriClaimUploadLogAction.deleteByConditions(dbManager,conditions);
	            dbManager.commitTransaction();
	        }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	    }

	    /**
	     * 按主键更新一条数据(主键本身无法变更)
	     * @param AgriClaimDemandDto AgriClaimDemandDto
	     * @throws Exception
	     */
	    public void update(AgriClaimDemandDto AgriClaimDemandDto)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            dbManager.beginTransaction();
	            //更新记录
	            blAgriClaimDemandAction.update(dbManager,AgriClaimDemandDto);
	            dbManager.commitTransaction();
	        }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	    }

	    /**
	     * 按主键查找一条数据
	     * @param claimCode 理赔编码
	     * @return AgriClaimDemandDto AgriClaimDemandDto
	     * @throws Exception
	     */
	    public AgriClaimDemandDto findByPrimaryKey(String batchNo)
	        throws Exception{
	        DBManager dbManager = new DBManager();
	        BLAgriClaimDemandAction blAgriClaimDemandAction = new BLAgriClaimDemandAction();
	        //声明DTO
	        AgriClaimDemandDto agriClaimDemandDto = null;
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            //查询数据,赋值给DTO
	            agriClaimDemandDto = blAgriClaimDemandAction.findByPrimaryKey(dbManager,batchNo);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return agriClaimDemandDto;
	    }

	    /**
	     * 按条件查询多条数据
	     * @param conditions 查询条件
	     * @param pageNo 页号
	     * @param rowsPerPage 每页的行数
	     * @return PageRecord 查询的一页的结果
	     * @throws Exception
	     */
	    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
	        throws Exception{
	        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            pageRecord = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return pageRecord;
	    }

	    /**
	     * 按条件查询多条数据
	     * @param conditions 查询条件
	     * @return Collection 包含AgriClaimDemandDto的集合
	     * @throws Exception
	     */
	    public Collection findByConditions(String conditions)
	        throws Exception{
	        Collection collection = new ArrayList();

	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            collection = blAgriClaimUploadLogAction.findByConditions(dbManager,conditions);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return collection;
	    }

	    /**
	     * 查询满足模糊查询条件的记录数
	     * @param conditions conditions
	     * @return 满足模糊查询条件的记录数
	     * @throws Exception
	     */
	    public int getCount(String conditions) 
	        throws Exception{
	        int rowCount=0;
	        if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }

	        DBManager dbManager = new DBManager();
	        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
	        try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            rowCount = blAgriClaimUploadLogAction.getCount(dbManager,conditions);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
	        return rowCount;
	    }
}
