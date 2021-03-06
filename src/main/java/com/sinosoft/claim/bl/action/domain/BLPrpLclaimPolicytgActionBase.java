package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicytgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimPolicytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimPolicy-立案保单清单表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.171<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimPolicytgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimPolicytgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimPolicytgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //插入记录
        dbPrpLclaimPolicytg.insert(prpLclaimPolicytgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //删除记录
        dbPrpLclaimPolicytg.delete(claimNo, policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //按条件删除记录
        dbPrpLclaimPolicytg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //更新记录
        dbPrpLclaimPolicytg.update(prpLclaimPolicytgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @return prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public PrpLclaimPolicytgDto findByPrimaryKey(DBManager dbManager,String claimNo,String policyNo) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        //声明DTO
        PrpLclaimPolicytgDto prpLclaimPolicytgDto = null;
        //查询数据,赋值给DTO
        prpLclaimPolicytgDto = dbPrpLclaimPolicytg.findByPrimaryKey(claimNo, policyNo);
        return prpLclaimPolicytgDto;
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
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimPolicytg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimPolicytgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimPolicytg.findByConditions(conditions);
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
        DBPrpLclaimPolicytg dbPrpLclaimPolicytg = new DBPrpLclaimPolicytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimPolicytg.getCount(conditions);
        return count;
    }
}
