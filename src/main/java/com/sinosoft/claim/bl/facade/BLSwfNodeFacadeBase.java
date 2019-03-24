package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfNodeAction;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfNode工作流节点定义表（新增）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.734<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNodeFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfNodeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfNodeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void insert(SwfNodeDto swfNodeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSwfNodeAction.insert(dbManager,swfNodeDto);
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
     * @param modelNo 模板编号
     * @param nodeNo 节点编号
     * @throws Exception
     */
    public void delete(int modelNo,int nodeNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSwfNodeAction.delete(dbManager,modelNo, nodeNo);
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
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfNodeAction.deleteByConditions(dbManager,conditions);
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
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void update(SwfNodeDto swfNodeDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfNodeAction.update(dbManager,swfNodeDto);
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
     * @param modelNo 模板编号
     * @param nodeNo 节点编号
     * @return swfNodeDto swfNodeDto
     * @throws Exception
     */
    public SwfNodeDto findByPrimaryKey(int modelNo,int nodeNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        //声明DTO
        SwfNodeDto swfNodeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            swfNodeDto = blSwfNodeAction.findByPrimaryKey(dbManager,modelNo, nodeNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfNodeDto;
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
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfNodeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含swfNodeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfNodeAction.findByConditions(dbManager,conditions);
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
        BLSwfNodeAction blSwfNodeAction = new BLSwfNodeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfNodeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
