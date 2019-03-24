package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLcfeecoinsAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcfeecoins的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcfeecoinsFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void insert(PrpLcfeecoinsDto prpLcfeecoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLcfeecoinsAction.insert(dbManager,prpLcfeecoinsDto);
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
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLcfeecoinsAction.delete(dbManager,businessNo, serialNo);
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLcfeecoinsAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void update(PrpLcfeecoinsDto prpLcfeecoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLcfeecoinsAction.update(dbManager,prpLcfeecoinsDto);
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
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @return prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public PrpLcfeecoinsDto findByPrimaryKey(String businessNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        //声明DTO
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLcfeecoinsDto = blPrpLcfeecoinsAction.findByPrimaryKey(dbManager,businessNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcfeecoinsDto;
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcfeecoinsAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLcfeecoinsDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcfeecoinsAction.findByConditions(dbManager,conditions);
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
        BLPrpLcfeecoinsAction blPrpLcfeecoinsAction = new BLPrpLcfeecoinsAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcfeecoinsAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
