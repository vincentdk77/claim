package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaComplainMainAction;
import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainMain投诉信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-08-20 17:56:02.116<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainFacadeBase.class);

    /**
     * 构造函数
     */
    public BLEdaComplainMainFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void insert(EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blEdaComplainMainAction.insert(dbManager,edaComplainMainDto);
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
     * @param acceptNo 投诉登记号
     * @throws Exception
     */
    public void delete(int acceptNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blEdaComplainMainAction.delete(dbManager,acceptNo);
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blEdaComplainMainAction.deleteByConditions(dbManager,conditions);
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
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void update(EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blEdaComplainMainAction.update(dbManager,edaComplainMainDto);
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
     * @param acceptNo 投诉登记号
     * @return edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public EdaComplainMainDto findByPrimaryKey(int acceptNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        //声明DTO
        EdaComplainMainDto edaComplainMainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            edaComplainMainDto = blEdaComplainMainAction.findByPrimaryKey(dbManager,acceptNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaComplainMainDto;
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blEdaComplainMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含edaComplainMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blEdaComplainMainAction.findByConditions(dbManager,conditions);
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
        BLEdaComplainMainAction blEdaComplainMainAction = new BLEdaComplainMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blEdaComplainMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
