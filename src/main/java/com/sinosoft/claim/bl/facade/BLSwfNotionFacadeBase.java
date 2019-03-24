package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfNotionAction;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是工作流意见处理表的业务逻辑对象Facade基类<br>
 * 创建于 2005-04-05 10:45:06.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfNotionFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void insert(SwfNotionDto swfNotionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blSwfNotionAction.insert(dbManager,swfNotionDto);
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
     * @param flowID 工作流ID
     * @param logNo 日志序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String flowID,int logNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blSwfNotionAction.delete(dbManager,flowID, logNo, lineNo);
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfNotionAction.deleteByConditions(dbManager,conditions);
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
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void update(SwfNotionDto swfNotionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blSwfNotionAction.update(dbManager,swfNotionDto);
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
     * @param flowID 工作流ID
     * @param logNo 日志序号
     * @param lineNo 行号
     * @return swfNotionDto swfNotionDto
     * @throws Exception
     */
    public SwfNotionDto findByPrimaryKey(String flowID,int logNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        //声明DTO
        SwfNotionDto swfNotionDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            swfNotionDto = blSwfNotionAction.findByPrimaryKey(dbManager,flowID, logNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfNotionDto;
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blSwfNotionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含swfNotionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            collection = blSwfNotionAction.findByConditions(dbManager,conditions);
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
        BLSwfNotionAction blSwfNotionAction = new BLSwfNotionAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blSwfNotionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
