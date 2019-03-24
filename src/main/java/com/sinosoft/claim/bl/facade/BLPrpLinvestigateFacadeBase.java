package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLinvestigateAction;
import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLinvestigate-案情调查信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLinvestigateFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLinvestigateFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinvestigateFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void insert(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinvestigateAction.insert(dbManager,prpLinvestigateDto);
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
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String objectType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinvestigateAction.delete(dbManager,registNo, serialNo, objectType);
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinvestigateAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void update(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinvestigateAction.update(dbManager,prpLinvestigateDto);
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
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @return prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public PrpLinvestigateDto findByPrimaryKey(String registNo,int serialNo,String objectType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        //声明DTO
        PrpLinvestigateDto prpLinvestigateDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinvestigateDto = blPrpLinvestigateAction.findByPrimaryKey(dbManager,registNo, serialNo, objectType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinvestigateDto;
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinvestigateAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinvestigateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinvestigateAction.findByConditions(dbManager,conditions);
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
        BLPrpLinvestigateAction blPrpLinvestigateAction = new BLPrpLinvestigateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinvestigateAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
