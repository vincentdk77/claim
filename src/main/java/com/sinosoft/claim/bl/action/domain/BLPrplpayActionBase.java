package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplpay;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPAY的业务逻辑对象类<br>
 */
public class BLPrplpayActionBase{
    private static Logger logger = Logger.getLogger(BLPrplpayActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplpayActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplpayDto prplpayDto)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //插入记录
        dbPrplpay.insert(prplpayDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
//        //删除记录
//        dbPrplpay.delete(serialno, compensateno);
//    }
    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //删除记录
        dbPrplpay.delete(serialno, compensateno, serialno2);
    }
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //按条件删除记录
        dbPrplpay.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplpayDto prplpayDto)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //更新记录
        dbPrplpay.update(prplpayDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno)
//            throws Exception{
//        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
//        //声明DTO
//        PrplpayDto prplpayDto = null;
//        //查询数据,赋值给DTO
//        prplpayDto = dbPrplpay.findByPrimaryKey(serialno, compensateno);
//        return prplpayDto;
//    }
    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpayDto prplpayDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(DBManager dbManager,String serialno,String compensateno,String serialno2)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //声明DTO
        PrplpayDto prplpayDto = null;
        //查询数据,赋值给DTO
        prplpayDto = dbPrplpay.findByPrimaryKey(serialno, compensateno, serialno2);
        return prplpayDto;
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
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplpay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.findByConditions(conditions);
        return collection;
    }
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection getSumPayamount(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplpay.getSumPayamount(conditions);
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
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplpay.getCount(conditions);
        return count;
    }
    /******************************优化修改:start***********************************/
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplpay dbPrplpay = new DBPrplpay(dbManager);
        //按条件删除记录
        dbPrplpay.deleteByConditionsByPrepered(conditions);
    }
    /******************************优化修改:end***********************************/
}
