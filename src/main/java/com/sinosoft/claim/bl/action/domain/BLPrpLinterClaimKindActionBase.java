package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimKind;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案估损金额信息的业务逻辑对象类<br>
 */
public class BLPrpLinterClaimKindActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimKindActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterClaimKindActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //插入记录
        dbPrpLinterClaimKind.insert(prpLinterClaimKindDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键 PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //删除记录
        dbPrpLinterClaimKind.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //按条件删除记录
        dbPrpLinterClaimKind.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterClaimKindDto prpLinterClaimKindDto)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //更新记录
        dbPrpLinterClaimKind.update(prpLinterClaimKindDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键 PK
     * @return prpLinterClaimKindDto prpLinterClaimKindDto
     * @throws Exception
     */
    public PrpLinterClaimKindDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        //声明DTO
        PrpLinterClaimKindDto prpLinterClaimKindDto = null;
        //查询数据,赋值给DTO
        prpLinterClaimKindDto = dbPrpLinterClaimKind.findByPrimaryKey(id);
        return prpLinterClaimKindDto;
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
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimKind.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterClaimKind.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterClaimKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterClaimKind.findByConditions(conditions);
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
        DBPrpLinterClaimKind dbPrpLinterClaimKind = new DBPrpLinterClaimKind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterClaimKind.getCount(conditions);
        return count;
    }
}
