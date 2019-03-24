package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimPolicy;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimPolicy-立案保单清单表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimPolicyActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimPolicyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimPolicyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //插入记录
        dbPrpLclaimPolicy.insert(prpLclaimPolicyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //删除记录
        dbPrpLclaimPolicy.delete(claimNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //按条件删除记录
        dbPrpLclaimPolicy.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //更新记录
        dbPrpLclaimPolicy.update(prpLclaimPolicyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @return prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public PrpLclaimPolicyDto findByPrimaryKey(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        //声明DTO
        PrpLclaimPolicyDto prpLclaimPolicyDto = null;
        //查询数据,赋值给DTO
        prpLclaimPolicyDto = dbPrpLclaimPolicy.findByPrimaryKey(claimNo, policyNo);
        return prpLclaimPolicyDto;
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
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicy.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimPolicy.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimPolicyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimPolicy.findByConditions(conditions);
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
        DBPrpLclaimPolicy dbPrpLclaimPolicy = new DBPrpLclaimPolicy(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicy.getCount(conditions);
        return count;
    }
}
