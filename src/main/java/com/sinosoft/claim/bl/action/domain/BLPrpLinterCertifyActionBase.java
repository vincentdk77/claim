package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCertify;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是单证信息表的业务逻辑对象类<br>
 */
public class BLPrpLinterCertifyActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCertifyActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCertifyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //插入记录
        dbPrpLinterCertify.insert(prpLinterCertifyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键 PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //删除记录
        dbPrpLinterCertify.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //按条件删除记录
        dbPrpLinterCertify.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCertifyDto prpLinterCertifyDto)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //更新记录
        dbPrpLinterCertify.update(prpLinterCertifyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键 PK
     * @return prpLinterCertifyDto prpLinterCertifyDto
     * @throws Exception
     */
    public PrpLinterCertifyDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        //声明DTO
        PrpLinterCertifyDto prpLinterCertifyDto = null;
        //查询数据,赋值给DTO
        prpLinterCertifyDto = dbPrpLinterCertify.findByPrimaryKey(id);
        return prpLinterCertifyDto;
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
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCertify.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCertify.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCertifyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCertify.findByConditions(conditions);
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
        DBPrpLinterCertify dbPrpLinterCertify = new DBPrpLinterCertify(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCertify.getCount(conditions);
        return count;
    }
}
