package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLCiClaimCompelcrashAction;
import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIClaimCompelcrash 理赔车车互碰数据表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCiClaimCompelcrashFacadeBase{
    private static Log logger = LogFactory.getLog(BLCiClaimCompelcrashFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCiClaimCompelcrashFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void insert(CiClaimCompelcrashDto ciClaimCompelcrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCiClaimCompelcrashAction.insert(dbManager,ciClaimCompelcrashDto);
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
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCiClaimCompelcrashAction.delete(dbManager,registNo, policyNo);
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCiClaimCompelcrashAction.deleteByConditions(dbManager,conditions);
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
     * @param ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public void update(CiClaimCompelcrashDto ciClaimCompelcrashDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCiClaimCompelcrashAction.update(dbManager,ciClaimCompelcrashDto);
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
     * @param registNo 报案号
     * @param policyNo 保单号
     * @return ciClaimCompelcrashDto ciClaimCompelcrashDto
     * @throws Exception
     */
    public CiClaimCompelcrashDto findByPrimaryKey(String registNo,String policyNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        //声明DTO
        CiClaimCompelcrashDto ciClaimCompelcrashDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            ciClaimCompelcrashDto = blCiClaimCompelcrashAction.findByPrimaryKey(dbManager,registNo, policyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimCompelcrashDto;
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blCiClaimCompelcrashAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含ciClaimCompelcrashDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            collection = blCiClaimCompelcrashAction.findByConditions(dbManager,conditions);
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
        BLCiClaimCompelcrashAction blCiClaimCompelcrashAction = new BLCiClaimCompelcrashAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blCiClaimCompelcrashAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
