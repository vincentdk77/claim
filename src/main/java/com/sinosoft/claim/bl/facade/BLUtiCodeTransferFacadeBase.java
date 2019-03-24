package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLUtiCodeTransferAction;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiCodeTransfer -险种险类代码对照表的业务逻辑对象Facade基类<br>
 * 创建于 2005-05-09 09:01:24.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLUtiCodeTransferFacadeBase{
    private static Log logger = LogFactory.getLog(BLUtiCodeTransferFacadeBase.class);

    /**
     * 构造函数
     */
    public BLUtiCodeTransferFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void insert(UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blUtiCodeTransferAction.insert(dbManager,utiCodeTransferDto);
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
     * @param configCode 程序中代码
     * @throws Exception
     */
    public void delete(String configCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blUtiCodeTransferAction.delete(dbManager,configCode);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blUtiCodeTransferAction.deleteByConditions(dbManager,conditions);
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
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void update(UtiCodeTransferDto utiCodeTransferDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blUtiCodeTransferAction.update(dbManager,utiCodeTransferDto);
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
     * @param configCode 程序中代码
     * @return utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public UtiCodeTransferDto findByPrimaryKey(String configCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        //声明DTO
        UtiCodeTransferDto utiCodeTransferDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            utiCodeTransferDto = blUtiCodeTransferAction.findByPrimaryKey(dbManager,configCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return utiCodeTransferDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blUtiCodeTransferAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含utiCodeTransferDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blUtiCodeTransferAction.findByConditions(dbManager,conditions);
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
        BLUtiCodeTransferAction blUtiCodeTransferAction = new BLUtiCodeTransferAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blUtiCodeTransferAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
