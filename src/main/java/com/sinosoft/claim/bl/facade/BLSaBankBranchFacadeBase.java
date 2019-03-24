package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.bl.action.domain.BLSaBankBranchAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SaBankBranch的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSaBankBranchFacadeBase{
    private static Logger logger = Logger.getLogger(BLSaBankBranchFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSaBankBranchFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void insert(SaBankBranchDto saBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSaBankBranchAction.insert(dbManager,saBankBranchDto);
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
     * @param bankCode bankCode
     * @throws Exception
     */
    public void delete(String bankCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSaBankBranchAction.delete(dbManager,bankCode);
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSaBankBranchAction.deleteByConditions(dbManager,conditions);
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
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void update(SaBankBranchDto saBankBranchDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSaBankBranchAction.update(dbManager,saBankBranchDto);
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
     * @param bankCode bankCode
     * @return saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public SaBankBranchDto findByPrimaryKey(String bankCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        //声明DTO
        SaBankBranchDto saBankBranchDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            saBankBranchDto = blSaBankBranchAction.findByPrimaryKey(dbManager,bankCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return saBankBranchDto;
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSaBankBranchAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含saBankBranchDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSaBankBranchAction.findByConditions(dbManager,conditions);
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
        BLSaBankBranchAction blSaBankBranchAction = new BLSaBankBranchAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSaBankBranchAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
