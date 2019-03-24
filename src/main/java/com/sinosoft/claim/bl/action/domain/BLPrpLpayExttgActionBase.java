package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayExttg;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付处理意见表的业务逻辑对象类<br>
 */
public class BLPrpLpayExttgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExttgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayExttgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //插入记录
        dbPrpLpayExt.insert(prpLpayExtDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param paymentNo 收付编号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo,int serialNo)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //删除记录
        dbPrpLpayExt.delete(paymentNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //按条件删除记录
        dbPrpLpayExt.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //更新记录
        dbPrpLpayExt.update(prpLpayExtDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param paymentNo 收付编号
     * @param serialNo 序号
     * @return prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public PrpLpayExtDto findByPrimaryKey(DBManager dbManager,String paymentNo,int serialNo)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //声明DTO
        PrpLpayExtDto prpLpayExtDto = null;
        //查询数据,赋值给DTO
        prpLpayExtDto = dbPrpLpayExt.findByPrimaryKey(paymentNo, serialNo);
        return prpLpayExtDto;
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
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpayExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpayExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayExt.findByConditions(conditions);
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
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayExt.getCount(conditions);
        return count;
    }
    /***************************优化修改：start*****************************/
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditionsByPrepered(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayExttg dbPrpLpayExt = new DBPrpLpayExttg(dbManager);
        //按条件删除记录
        dbPrpLpayExt.deleteByConditionsByPrepered(conditions);
    }
    /***************************优化修改：end*****************************/
}
