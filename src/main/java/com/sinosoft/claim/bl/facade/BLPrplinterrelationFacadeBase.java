package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplinterrelationAction;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是中间表关联报案号的业务逻辑对象Facade基类<br>
 */
public class BLPrplinterrelationFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplinterrelationFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void insert(PrplinterrelationDto prplinterrelationDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplinterrelationAction.insert(dbManager,prplinterrelationDto);
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
     * @param id 主键id
     * @param outId 客户端主键
     * @throws Exception
     */
    public void delete(String id,String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplinterrelationAction.delete(dbManager,id, outId);
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
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplinterrelationAction.deleteByConditions(dbManager,conditions);
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
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void update(PrplinterrelationDto prplinterrelationDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplinterrelationAction.update(dbManager,prplinterrelationDto);
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
     * @param id 主键id
     * @param outId 客户端主键
     * @return prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public PrplinterrelationDto findByPrimaryKey(String id,String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        //声明DTO
        PrplinterrelationDto prplinterrelationDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplinterrelationDto = blPrplinterrelationAction.findByPrimaryKey(dbManager,id, outId);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplinterrelationDto;
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
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplinterrelationAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplinterrelationDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplinterrelationAction.findByConditions(dbManager,conditions);
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
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplinterrelationAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
