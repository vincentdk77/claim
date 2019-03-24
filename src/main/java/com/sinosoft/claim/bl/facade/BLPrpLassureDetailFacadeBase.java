package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLassureDetailAction;
import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLassureDetail-担保函明细（船舶）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.515<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLassureDetailFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLassureDetailFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLassureDetailFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void insert(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLassureDetailAction.insert(dbManager,prpLassureDetailDto);
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
     * @param assureNo 担保号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String assureNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLassureDetailAction.delete(dbManager,assureNo, serialNo);
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLassureDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void update(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLassureDetailAction.update(dbManager,prpLassureDetailDto);
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
     * @param assureNo 担保号
     * @param serialNo 序号
     * @return prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public PrpLassureDetailDto findByPrimaryKey(String assureNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        //声明DTO
        PrpLassureDetailDto prpLassureDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLassureDetailDto = blPrpLassureDetailAction.findByPrimaryKey(dbManager,assureNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLassureDetailDto;
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLassureDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLassureDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLassureDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpLassureDetailAction blPrpLassureDetailAction = new BLPrpLassureDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLassureDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
