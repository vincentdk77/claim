package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplfiscalpaydetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplfiscalpaydetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLFISCALDETAILPAY的业务逻辑对象类<br>
 */
public class BLPrplfiscalpaydetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaydetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplfiscalpaydetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //插入记录
        dbPrplfiscaldetailpay.insert(prplfiscaldetailpayDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fiscalno,String serialno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //删除记录
        dbPrplfiscaldetailpay.delete(fiscalno, serialno);
    }
    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fiscalno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //删除记录
        dbPrplfiscaldetailpay.delete(fiscalno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //按条件删除记录
        dbPrplfiscaldetailpay.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplfiscalpaydetailDto prplfiscaldetailpayDto)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //更新记录
        dbPrplfiscaldetailpay.update(prplfiscaldetailpayDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fiscalno 财政打卡文件清单号
     * @param serialno 序号
     * @return prplfiscaldetailpayDto prplfiscaldetailpayDto
     * @throws Exception
     */
    public PrplfiscalpaydetailDto findByPrimaryKey(DBManager dbManager,String fiscalno,String serialno)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        //声明DTO
        PrplfiscalpaydetailDto prplfiscaldetailpayDto = null;
        //查询数据,赋值给DTO
        prplfiscaldetailpayDto = dbPrplfiscaldetailpay.findByPrimaryKey(fiscalno, serialno);
        return prplfiscaldetailpayDto;
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
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscaldetailpay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplfiscaldetailpay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplfiscaldetailpayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplfiscaldetailpay.findByConditions(conditions);
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
        DBPrplfiscalpaydetail dbPrplfiscaldetailpay = new DBPrplfiscalpaydetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplfiscaldetailpay.getCount(conditions);
        return count;
    }
}
