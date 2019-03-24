package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBHousepolicylist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HOUSEPOLICYLIST的业务逻辑对象类<br>
 */
public class BLHousepolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHousepolicylistActionBase.class);

    /**
     * 构造函数
     */
    public BLHousepolicylistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HousepolicylistDto housepolicylistDto)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //插入记录
        dbHousepolicylist.insert(housepolicylistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //删除记录
        dbHousepolicylist.delete(inusrelistcode, idcard);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //按条件删除记录
        dbHousepolicylist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HousepolicylistDto housepolicylistDto)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //更新记录
        dbHousepolicylist.update(housepolicylistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @return housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public HousepolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String idcard)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        //声明DTO
        HousepolicylistDto housepolicylistDto = null;
        //查询数据,赋值给DTO
        housepolicylistDto = dbHousepolicylist.findByPrimaryKey(inusrelistcode, idcard);
        return housepolicylistDto;
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
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHousepolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含housepolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHousepolicylist.findByConditions(conditions);
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
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHousepolicylist.getCount(conditions);
        return count;
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
    public PageRecord findIdcardByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHousepolicylist.getIdcardCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findIdcardByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findIdcardByConditions1(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHousepolicylist.getIdcardCount1(SqlUtils.getWherePartForGetCount(conditions));
collection = dbHousepolicylist.findIdcardByConditions1(conditions,pageNo,rowsPerPage);
PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
return pageRecord;
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
    public PageRecord findAreacodeByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHousepolicylist.getAreacodeCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHousepolicylist.findAreacodeByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findAreacodeByConditions1(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHousepolicylist dbHousepolicylist = new DBHousepolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHousepolicylist.getAreacodeCount1(SqlUtils.getWherePartForGetCount(conditions));
//System.err.println("conditions:"+ conditions);
collection = dbHousepolicylist.findAreacodeByConditions1(conditions,pageNo,rowsPerPage);
PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
return pageRecord;
}
}
