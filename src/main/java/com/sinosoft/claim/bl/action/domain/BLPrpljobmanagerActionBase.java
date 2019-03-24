package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGER的业务逻辑对象类<br>
 */
public class BLPrpljobmanagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagerActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpljobmanagerActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //插入记录
        dbPrpljobmanager.insert(prpljobmanagerDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id ID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //删除记录
        dbPrpljobmanager.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //按条件删除记录
        dbPrpljobmanager.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpljobmanagerDto prpljobmanagerDto)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //更新记录
        dbPrpljobmanager.update(prpljobmanagerDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id ID
     * @return prpljobmanagerDto prpljobmanagerDto
     * @throws Exception
     */
    public PrpljobmanagerDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        //声明DTO
        PrpljobmanagerDto prpljobmanagerDto = null;
        //查询数据,赋值给DTO
        prpljobmanagerDto = dbPrpljobmanager.findByPrimaryKey(id);
        return prpljobmanagerDto;
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
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanager.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpljobmanager.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpljobmanagerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpljobmanager.findByConditions(conditions);
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
        DBPrpljobmanager dbPrpljobmanager = new DBPrpljobmanager(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanager.getCount(conditions);
        return count;
    }
}
