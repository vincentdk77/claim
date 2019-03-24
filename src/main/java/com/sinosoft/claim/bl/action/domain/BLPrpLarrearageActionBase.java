package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLarrearageDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLarrearage;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLarrearage-逾款欠款清单表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLarrearageActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLarrearageActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLarrearageActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //插入记录
        dbPrpLarrearage.insert(prpLarrearageDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param arrearageEndDate 本期应还款截止日期
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,DateTime arrearageEndDate) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //删除记录
        dbPrpLarrearage.delete(policyNo, arrearageEndDate);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //按条件删除记录
        dbPrpLarrearage.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLarrearageDto prpLarrearageDto) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //更新记录
        dbPrpLarrearage.update(prpLarrearageDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param arrearageEndDate 本期应还款截止日期
     * @return prpLarrearageDto prpLarrearageDto
     * @throws Exception
     */
    public PrpLarrearageDto findByPrimaryKey(DBManager dbManager,String policyNo,DateTime arrearageEndDate) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        //声明DTO
        PrpLarrearageDto prpLarrearageDto = null;
        //查询数据,赋值给DTO
        prpLarrearageDto = dbPrpLarrearage.findByPrimaryKey(policyNo, arrearageEndDate);
        return prpLarrearageDto;
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
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLarrearage.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLarrearage.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLarrearageDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLarrearage.findByConditions(conditions);
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
        DBPrpLarrearage dbPrpLarrearage = new DBPrpLarrearage(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLarrearage.getCount(conditions);
        return count;
    }
}
