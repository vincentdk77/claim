package com.sinosoft.claimprop.common.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.claimprop.common.bl.action.domain.BLCiClaimPropDemandAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropDemand的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimPropDemandFacadeBase{
    private static Logger logger = Logger.getLogger(BLCiClaimPropDemandFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimPropDemandFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void insert(CiClaimPropDemandDto ciClaimPropDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCiClaimPropDemandAction.insert(dbManager,ciClaimPropDemandDto);
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
     * @param claimCode claimCode
     * @throws Exception
     */
    public void delete(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCiClaimPropDemandAction.delete(dbManager,claimCode);
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCiClaimPropDemandAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void update(CiClaimPropDemandDto ciClaimPropDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCiClaimPropDemandAction.update(dbManager,ciClaimPropDemandDto);
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
     * @param claimCode claimCode
     * @return ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public CiClaimPropDemandDto findByPrimaryKey(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        //声明DTO
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        try{
            dbManager.open("daaplatformDataSource");
            //查询数据,赋值给DTO
            ciClaimPropDemandDto = blCiClaimPropDemandAction.findByPrimaryKey(dbManager,claimCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimPropDemandDto;
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            pageRecord = blCiClaimPropDemandAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含ciClaimPropDemandDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCiClaimPropDemandAction.findByConditions(dbManager,conditions);
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
        BLCiClaimPropDemandAction blCiClaimPropDemandAction = new BLCiClaimPropDemandAction();
        try{
            dbManager.open("daaplatformDataSource");
            rowCount = blCiClaimPropDemandAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
