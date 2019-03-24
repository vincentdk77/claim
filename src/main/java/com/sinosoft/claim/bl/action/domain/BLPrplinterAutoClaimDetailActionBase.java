package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterAutoClaimDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗理赔自动流程状态查询表的业务逻辑对象类<br>
 */
public class BLPrplinterAutoClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplinterAutoClaimDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //插入记录
        dbPrplinterAutoClaimDetail.insert(prplinterAutoClaimDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,String registNo)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //删除记录
        dbPrplinterAutoClaimDetail.delete(id, registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //按条件删除记录
        dbPrplinterAutoClaimDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //更新记录
        dbPrplinterAutoClaimDetail.update(prplinterAutoClaimDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键
     * @param registNo 报案号码
     * @return prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public PrplinterAutoClaimDetailDto findByPrimaryKey(DBManager dbManager,String id,String registNo)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //声明DTO
        PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
        //查询数据,赋值给DTO
        prplinterAutoClaimDetailDto = dbPrplinterAutoClaimDetail.findByPrimaryKey(id, registNo);
        return prplinterAutoClaimDetailDto;
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
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterAutoClaimDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterAutoClaimDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplinterAutoClaimDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterAutoClaimDetail.findByConditions(conditions);
        return collection;
    }
    
    /**
     * 按SQL更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void updateBySQL(DBManager dbManager,String sql)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //更新记录
        dbPrplinterAutoClaimDetail.updateBySQL(sql);
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
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterAutoClaimDetail.getCount(conditions);
        return count;
    }
}
