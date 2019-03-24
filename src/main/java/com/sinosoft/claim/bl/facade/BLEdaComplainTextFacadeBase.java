package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLEdaComplainTextAction;
import com.sinosoft.claim.dto.domain.EdaComplainTextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainText投诉文字表的业务逻辑对象Facade基类<br>
 * 创建于 2005-08-20 17:56:02.116<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainTextFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainTextFacadeBase.class);

    /**
     * 构造函数
     */
    public BLEdaComplainTextFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void insert(EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blEdaComplainTextAction.insert(dbManager,edaComplainTextDto);
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
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blEdaComplainTextAction.delete(dbManager,acceptNo, textType, serialNo, lineNo);
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blEdaComplainTextAction.deleteByConditions(dbManager,conditions);
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
     * @param edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public void update(EdaComplainTextDto edaComplainTextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blEdaComplainTextAction.update(dbManager,edaComplainTextDto);
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
     * @param textType 文本类型
     * @param serialNo 序号
     * @param lineNo 行号
     * @return edaComplainTextDto edaComplainTextDto
     * @throws Exception
     */
    public EdaComplainTextDto findByPrimaryKey(double acceptNo,String textType,double serialNo,double lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        //声明DTO
        EdaComplainTextDto edaComplainTextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            edaComplainTextDto = blEdaComplainTextAction.findByPrimaryKey(dbManager,acceptNo, textType, serialNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return edaComplainTextDto;
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blEdaComplainTextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含edaComplainTextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blEdaComplainTextAction.findByConditions(dbManager,conditions);
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
        BLEdaComplainTextAction blEdaComplainTextAction = new BLEdaComplainTextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blEdaComplainTextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
