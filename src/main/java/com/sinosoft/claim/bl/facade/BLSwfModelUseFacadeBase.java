package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfModelUseAction;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfModelUse模板使用设置（新增）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.718<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfModelUseFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfModelUseFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void insert(SwfModelUseDto swfModelUseDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSwfModelUseAction.insert(dbManager,swfModelUseDto);
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
     * @param riskCode 险种代码
     * @param comCode 部门编码
     * @throws Exception
     */
    public void delete(int modelNo,String riskCode,String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSwfModelUseAction.delete(dbManager,modelNo, riskCode, comCode);
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfModelUseAction.deleteByConditions(dbManager,conditions);
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
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void update(SwfModelUseDto swfModelUseDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfModelUseAction.update(dbManager,swfModelUseDto);
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
     * @param riskCode 险种代码
     * @param comCode 部门编码
     * @return swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public SwfModelUseDto findByPrimaryKey(int modelNo,String riskCode,String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        //声明DTO
        SwfModelUseDto swfModelUseDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            swfModelUseDto = blSwfModelUseAction.findByPrimaryKey(dbManager,modelNo, riskCode, comCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfModelUseDto;
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfModelUseAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含swfModelUseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfModelUseAction.findByConditions(dbManager,conditions);
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
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfModelUseAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
