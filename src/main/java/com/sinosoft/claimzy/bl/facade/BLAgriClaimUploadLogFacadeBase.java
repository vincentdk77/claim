package com.sinosoft.claimzy.bl.facade;

import java.sql.ResultSet;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

import com.sinosoft.claimzy.bl.action.domain.BLAgriClaimUploadLogAction;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是AGRICLAIMUPLOADLOG的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLAgriClaimUploadLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLAgriClaimUploadLogFacadeBase.class);

    /**
     * 构造函数
     */
    public BLAgriClaimUploadLogFacadeBase(){
    }
    
    
    /**
     * 方法用于获取flag
     * @throws Exception 
     */
//    public int query() throws Exception{
//    	DBManager dbManager = new DBManager();
//    	int number=0;
//    	try{
//           dbManager.open(AppConfig.get("sysconst.DBJNDI"));
//           dbManager.beginTransaction();
//           String str = "Select MAX(flag) from agriclaimuploadlog";
//           dbManager.prepareStatement(str);
//           ResultSet resultSet = dbManager.executePreparedQuery();
//           number = dbManager.getInt(resultSet,1);
//           dbManager.commitTransaction();
//        }catch(Exception exception){
//           dbManager.rollbackTransaction();
//            throw exception;
//        }finally{
//           dbManager.close();
//        }
		
//		return number;
//    }
    
   
    /**
     * 插入一条数据
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(AgriClaimUploadLogDto agriClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blAgriClaimUploadLogAction.insert(dbManager,agriClaimUploadLogDto);
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
    public void delete(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blAgriClaimUploadLogAction.delete(dbManager,claimCode);
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
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void update(AgriClaimUploadLogDto agriClaimUploadLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blAgriClaimUploadLogAction.update(dbManager,agriClaimUploadLogDto);
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
     * @return agriClaimUploadLogDto agriClaimUploadLogDto
     * @throws Exception
     */
    public AgriClaimUploadLogDto findByPrimaryKey(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLAgriClaimUploadLogAction blAgriClaimUploadLogAction = new BLAgriClaimUploadLogAction();
        //声明DTO
        AgriClaimUploadLogDto agriClaimUploadLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            agriClaimUploadLogDto = blAgriClaimUploadLogAction.findByPrimaryKey(dbManager,claimCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return agriClaimUploadLogDto;
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
     * @return Collection 包含agriClaimUploadLogDto的集合
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
