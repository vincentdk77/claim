package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRecoveryOrPay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLRecoveryOrPayActionBase {
	private static Log logger = LogFactory.getLog(BLPrpLRecoveryOrPayActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLRecoveryOrPayActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLRecoveryOrPayDto prpLRecoveryOrPaysDto) throws Exception{
        DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //插入记录
        dbPrpLRecoveryOrPay.insert(prpLRecoveryOrPaysDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //删除记录
    	dbPrpLRecoveryOrPay.delete(compensateNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //按条件删除记录
    	dbPrpLRecoveryOrPay.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLRecoveryOrPayDto prpLRecoveryOrPayDto) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //更新记录
    	dbPrpLRecoveryOrPay.update(prpLRecoveryOrPayDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return prpLlossDto prpLlossDto
     * @throws Exception
     */
    public PrpLRecoveryOrPayDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        //声明DTO
    	PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        //查询数据,赋值给DTO
    	prpLRecoveryOrPayDto = dbPrpLRecoveryOrPay.findByPrimaryKey(compensateNo, serialNo);
        return prpLRecoveryOrPayDto;
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
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRecoveryOrPay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLRecoveryOrPay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLlossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLRecoveryOrPay.findByConditions(conditions);
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
    	DBPrpLRecoveryOrPay dbPrpLRecoveryOrPay = new DBPrpLRecoveryOrPay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRecoveryOrPay.getCount(conditions);
        return count;
    }
}
