package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案注销交互信息关联表的业务逻辑对象类<br>
 */
public class BLPrpLinterCancelClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCancelClaimDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //插入记录
        dbPrpLinterCancelClaimDetail.insert(prpLinterCancelClaimDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //删除记录
        dbPrpLinterCancelClaimDetail.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //按条件删除记录
        dbPrpLinterCancelClaimDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //更新记录
        dbPrpLinterCancelClaimDetail.update(prpLinterCancelClaimDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @return prpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto
     * @throws Exception
     */
    public PrpLinterCancelClaimDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        //声明DTO
        PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = null;
        //查询数据,赋值给DTO
        prpLinterCancelClaimDetailDto = dbPrpLinterCancelClaimDetail.findByPrimaryKey(id);
        return prpLinterCancelClaimDetailDto;
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
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCancelClaimDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCancelClaimDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCancelClaimDetail.findByConditions(conditions);
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
        DBPrpLinterCancelClaimDetail dbPrpLinterCancelClaimDetail = new DBPrpLinterCancelClaimDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimDetail.getCount(conditions);
        return count;
    }
}
