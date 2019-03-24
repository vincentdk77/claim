package com.sinosoft.claim.webservice.paymentinformatino;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISITLOG的业务逻辑对象类
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitlogActionBase {
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitlogActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplAgrireturnvisitlogActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param PrplAgrireturnvisitlogDto PrplAgrireturnvisitlogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
        DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //插入记录
        dbPrplagrireturnvisitlog.insert(prplagrireturnvisitlogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessno)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //删除记录
    	dbPrplagrireturnvisitlog.delete(businessno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //按条件删除记录
    	dbPrplagrireturnvisitlog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param PrplAgrireturnvisitlogDto PrplAgrireturnvisitlogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //更新记录
    	dbPrplagrireturnvisitlog.update(prplagrireturnvisitlogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return prplagrireturnvisitlogDto prplagrireturnvisitlogDto
     * @throws Exception
     */
    public PrplAgrireturnvisitlogDto findByPrimaryKey(DBManager dbManager,String businessno)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        //声明DTO
    	PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = null;
        //查询数据,赋值给DTO
    	prplagrireturnvisitlogDto = dbPrplagrireturnvisitlog.findByPrimaryKey(businessno);
        return prplagrireturnvisitlogDto;
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
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplagrireturnvisitlog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplagrireturnvisitlog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含PrplAgrireturnvisitlogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplagrireturnvisitlog.findByConditions(conditions);
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
    	DBPrplagrireturnvisitlog dbPrplagrireturnvisitlog = new DBPrplagrireturnvisitlog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplagrireturnvisitlog.getCount(conditions);
        return count;
    }
}
