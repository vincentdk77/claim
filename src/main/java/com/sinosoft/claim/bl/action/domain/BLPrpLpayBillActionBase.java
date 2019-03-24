package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayBill;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayBill的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayBillActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //插入记录
        dbPrpLpayBill.insert(prpLpayBillDto);
    }
    
    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //插入记录
        dbPrpLpayBill.insertAll(collection);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //删除记录
        dbPrpLpayBill.delete(paymentNo, registNo, compensateNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //按条件删除记录
        dbPrpLpayBill.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayBillDto prpLpayBillDto)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //更新记录
        dbPrpLpayBill.update(prpLpayBillDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(DBManager dbManager,String paymentNo,String registNo,String compensateNo,int serialNo)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //声明DTO
        PrpLpayBillDto prpLpayBillDto = null;
        //查询数据,赋值给DTO
        prpLpayBillDto = dbPrpLpayBill.findByPrimaryKey(paymentNo, registNo, compensateNo, serialNo);
        return prpLpayBillDto;
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayBill.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayBill.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpayBillDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayBill.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayBill.getCount(conditions);
        return count;
    }
    /*********************优化修改：start********************/
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayBill dbPrpLpayBill = new DBPrpLpayBill(dbManager);
        //按条件删除记录
        dbPrpLpayBill.deleteByConditionsByPrepered(conditions);
    }
    /***********************优化修改：end******************/
}
