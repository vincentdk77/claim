package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomRepairBill;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcomRepairBill-赔款计算书表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcomRepairBillActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomRepairBillActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcomRepairBillActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
        DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //插入记录
        dbPrpLcomRepairBill.insert(prpLcomRepairBillDto);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //按条件删除记录
    	dbPrpLcomRepairBill.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcomRepairBillDto prpLcomRepairBillDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcomRepairBillDto prpLcomRepairBillDto) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        //更新记录
    	dbPrpLcomRepairBill.update(prpLcomRepairBillDto);
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomRepairBill.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcomRepairBill.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcomRepairBillDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcomRepairBill.findByConditions(conditions);
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
    	DBPrpLcomRepairBill dbPrpLcomRepairBill = new DBPrpLcomRepairBill(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomRepairBill.getCount(conditions);
        return count;
    }
}
