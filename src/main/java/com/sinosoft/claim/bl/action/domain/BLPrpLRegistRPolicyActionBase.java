package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistRPolicy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的业务逻辑对象类<br>
 * 创建于 2006-06-04 15:22:15.007<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLRegistRPolicyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //插入记录
        dbPrpLRegistRPolicy.insert(prpLRegistRPolicyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //删除记录
        dbPrpLRegistRPolicy.delete(registNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //按条件删除记录
        dbPrpLRegistRPolicy.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //更新记录
        dbPrpLRegistRPolicy.update(prpLRegistRPolicyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param policyNo 保单号
     * @return prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public PrpLRegistRPolicyDto findByPrimaryKey(DBManager dbManager,String registNo,String policyNo) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        //声明DTO
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
        //查询数据,赋值给DTO
        prpLRegistRPolicyDto = dbPrpLRegistRPolicy.findByPrimaryKey(registNo, policyNo);
        return prpLRegistRPolicyDto;
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
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRegistRPolicy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLRegistRPolicy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLRegistRPolicyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLRegistRPolicy.findByConditions(conditions);
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
        DBPrpLRegistRPolicy dbPrpLRegistRPolicy = new DBPrpLRegistRPolicy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLRegistRPolicy.getCount(conditions);
        return count;
    }
}
