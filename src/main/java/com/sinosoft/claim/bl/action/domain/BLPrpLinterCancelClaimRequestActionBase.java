package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCancelClaimRequest;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案注销传入参主数的业务逻辑对象类<br>
 */
public class BLPrpLinterCancelClaimRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCancelClaimRequestActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //插入记录
        dbPrpLinterCancelClaimRequest.insert(prpLinterCancelClaimRequestDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //删除记录
        dbPrpLinterCancelClaimRequest.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //按条件删除记录
        dbPrpLinterCancelClaimRequest.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //更新记录
        dbPrpLinterCancelClaimRequest.update(prpLinterCancelClaimRequestDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @return prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public PrpLinterCancelClaimRequestDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        //声明DTO
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        //查询数据,赋值给DTO
        prpLinterCancelClaimRequestDto = dbPrpLinterCancelClaimRequest.findByPrimaryKey(id);
        return prpLinterCancelClaimRequestDto;
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
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimRequest.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCancelClaimRequest.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCancelClaimRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCancelClaimRequest.findByConditions(conditions);
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
        DBPrpLinterCancelClaimRequest dbPrpLinterCancelClaimRequest = new DBPrpLinterCancelClaimRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCancelClaimRequest.getCount(conditions);
        return count;
    }
}
