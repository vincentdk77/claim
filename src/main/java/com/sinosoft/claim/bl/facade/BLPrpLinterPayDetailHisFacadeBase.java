package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailHisDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailHisAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是交互信息关联表------轨迹历史表的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterPayDetailHisFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDetailHisFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDetailHisFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterPayDetailHisAction.insert(dbManager,prpLinterPayDetailHisDto);
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
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterPayDetailHisAction.delete(dbManager,id);
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterPayDetailHisAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public void update(PrpLinterPayDetailHisDto prpLinterPayDetailHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterPayDetailHisAction.update(dbManager,prpLinterPayDetailHisDto);
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
     * @param id 主键pk
     * @return prpLinterPayDetailHisDto prpLinterPayDetailHisDto
     * @throws Exception
     */
    public PrpLinterPayDetailHisDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        //声明DTO
        PrpLinterPayDetailHisDto prpLinterPayDetailHisDto = null;
        try{
            dbManager.open("prplinterpaydetailDataSource");
            //查询数据,赋值给DTO
            prpLinterPayDetailHisDto = blPrpLinterPayDetailHisAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPayDetailHisDto;
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            pageRecord = blPrpLinterPayDetailHisAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterPayDetailHisDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            collection = blPrpLinterPayDetailHisAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPayDetailHisAction blPrpLinterPayDetailHisAction = new BLPrpLinterPayDetailHisAction();
        try{
            dbManager.open("prplinterpaydetailDataSource");
            rowCount = blPrpLinterPayDetailHisAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
