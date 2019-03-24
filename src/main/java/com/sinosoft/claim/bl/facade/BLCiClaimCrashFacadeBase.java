package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLCiClaimCrashAction;
import com.sinosoft.claim.dto.domain.CiClaimCrashDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCrash 车辆理赔记录的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCrashFacadeBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCrashFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimCrashFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void insert(CiClaimCrashDto ciClaimCrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCiClaimCrashAction.insert(dbManager,ciClaimCrashDto);
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
     * @param policyNo 保单号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCiClaimCrashAction.delete(dbManager,policyNo, serialNo);
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCiClaimCrashAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public void update(CiClaimCrashDto ciClaimCrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCiClaimCrashAction.update(dbManager,ciClaimCrashDto);
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
     * @param policyNo 保单号
     * @param serialNo 序号
     * @return ciClaimCrashDto ciClaimCrashDto
     * @throws Exception
     */
    public CiClaimCrashDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        //声明DTO
        CiClaimCrashDto ciClaimCrashDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            ciClaimCrashDto = blCiClaimCrashAction.findByPrimaryKey(dbManager,policyNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimCrashDto;
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blCiClaimCrashAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含ciClaimCrashDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            collection = blCiClaimCrashAction.findByConditions(dbManager,conditions);
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
        BLCiClaimCrashAction blCiClaimCrashAction = new BLCiClaimCrashAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blCiClaimCrashAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
