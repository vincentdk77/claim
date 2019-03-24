package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLrtextAction;
import com.sinosoft.claim.dto.domain.PrpLrtextDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrtext-追偿损余文字说明的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrtextFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLrtextFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLrtextFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void insert(PrpLrtextDto prpLrtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLrtextAction.insert(dbManager,prpLrtextDto);
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
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @throws Exception
     */
    public void delete(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLrtextAction.delete(dbManager,claimNo, textType, serialNo, lineNo);
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLrtextAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public void update(PrpLrtextDto prpLrtextDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLrtextAction.update(dbManager,prpLrtextDto);
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
     * @param claimNo 赔案号码
     * @param textType 文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param serialNo 序号
     * @param lineNo 行号
     * @return prpLrtextDto prpLrtextDto
     * @throws Exception
     */
    public PrpLrtextDto findByPrimaryKey(String claimNo,String textType,int serialNo,int lineNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        //声明DTO
        PrpLrtextDto prpLrtextDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLrtextDto = blPrpLrtextAction.findByPrimaryKey(dbManager,claimNo, textType, serialNo, lineNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLrtextDto;
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLrtextAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLrtextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLrtextAction.findByConditions(dbManager,conditions);
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
        BLPrpLrtextAction blPrpLrtextAction = new BLPrpLrtextAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLrtextAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
