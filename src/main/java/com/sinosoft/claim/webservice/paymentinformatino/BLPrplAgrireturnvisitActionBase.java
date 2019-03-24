package com.sinosoft.claim.webservice.paymentinformatino;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitActionBase;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISIT的业务逻辑对象类
 * @author Administrator
 *
 */
public class BLPrplAgrireturnvisitActionBase {
	private static Logger logger = Logger.getLogger(BLPrplAgrireturnvisitActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplAgrireturnvisitActionBase(){
    }
    
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
        DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //插入记录
        dbPrplAgrireturnvisit.insert(prplagrireturnvisitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String serialno)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //删除记录
    	dbPrplAgrireturnvisit.delete(registno, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //按条件删除记录
    	dbPrplAgrireturnvisit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param PrplagrireturnvisitDto PrplagrireturnvisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplagrireturnvisitDto prplagrireturnvisitDto)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //更新记录
    	dbPrplAgrireturnvisit.update(prplagrireturnvisitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return PrplagrireturnvisitDto PrplagrireturnvisitDto
     * @throws Exception
     */
    public PrplagrireturnvisitDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplreturnvisit = new DBPrplAgrireturnvisit(dbManager);
        //声明DTO
        PrplagrireturnvisitDto prplagrireturnvisitDto = null;
        //查询数据,赋值给DTO
        prplagrireturnvisitDto = dbPrplreturnvisit.findByPrimaryKey(registno, serialno);
        return prplagrireturnvisitDto;
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
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplAgrireturnvisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplAgrireturnvisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含PrplagrireturnvisitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplAgrireturnvisit.findByConditions(conditions);
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
    	DBPrplAgrireturnvisit dbPrplAgrireturnvisit = new DBPrplAgrireturnvisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplAgrireturnvisit.getCount(conditions);
        return count;
    }
    
}
