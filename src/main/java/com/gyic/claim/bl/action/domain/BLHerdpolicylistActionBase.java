package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBHerdpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDPOLICYLIST的业务逻辑对象类<br>
 */
public class BLHerdpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistActionBase.class);

    /**
     * 构造函数
     */
    public BLHerdpolicylistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //插入记录
        dbHerdpolicylist.insert(herdpolicylistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //删除记录
        dbHerdpolicylist.delete(inusrelistcode, earlabel, kindcode, fcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //按条件删除记录
        dbHerdpolicylist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //更新记录
        dbHerdpolicylist.update(herdpolicylistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @return herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public HerdpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        //声明DTO
        HerdpolicylistDto herdpolicylistDto = null;
        //查询数据,赋值给DTO
        herdpolicylistDto = dbHerdpolicylist.findByPrimaryKey(inusrelistcode, earlabel, kindcode, fcode);
        return herdpolicylistDto;
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
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbHerdpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
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
    public PageRecord findEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHerdpolicylist.getEarCount(SqlUtils.getWherePartForGetCount(conditions),fname,earno);
        collection = dbHerdpolicylist.findEarByConditions(conditions,pageNo,rowsPerPage,fname,earno);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    public PageRecord findEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    throws Exception{
DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
Collection collection = new ArrayList();

if(conditions.trim().length()==0){
    conditions = "1=1";
}
int count = dbHerdpolicylist.getEarCount(SqlUtils.getWherePartForGetCount(conditions));
collection = dbHerdpolicylist.findEarByConditions(conditions,pageNo,rowsPerPage);
PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
return pageRecord;
}
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含herdpolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbHerdpolicylist.findByConditions(conditions);
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
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbHerdpolicylist.getCount(conditions);
        return count;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
    	DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbHerdpolicylist.getSum(conditions,fieldName);
        return sum;
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
    public PageRecord findNEWEarByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
        DBHerdpolicylist dbHerdpolicylist = new DBHerdpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbHerdpolicylist.getNEWEarCount(SqlUtils.getWherePartForGetCount(conditions),fname,earno);
        collection = dbHerdpolicylist.findNEWEarByConditions(conditions,pageNo,rowsPerPage,fname,earno);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
}
