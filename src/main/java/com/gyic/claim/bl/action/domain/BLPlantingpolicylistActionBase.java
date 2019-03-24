package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGPOLICYLIST的业务逻辑对象类<br>
 */
public class BLPlantingpolicylistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistActionBase.class);

    /**
     * 构造函数
     */
    public BLPlantingpolicylistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //插入记录
        dbPlantingpolicylist.insert(plantingpolicylistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //删除记录
        dbPlantingpolicylist.delete(inusrelistcode, fcode, kindcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //按条件删除记录
        dbPlantingpolicylist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //更新记录
        dbPlantingpolicylist.update(plantingpolicylistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public PlantingpolicylistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        //声明DTO
        PlantingpolicylistDto plantingpolicylistDto = null;
        //查询数据,赋值给DTO
        plantingpolicylistDto = dbPlantingpolicylist.findByPrimaryKey(inusrelistcode, fcode, kindcode);
        return plantingpolicylistDto;
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingpolicylist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingpolicylist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含plantingpolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingpolicylist.findByConditions(conditions);
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingpolicylist.getCount(conditions);
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
        DBPlantingpolicylist dbPlantingpolicylist = new DBPlantingpolicylist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingpolicylist.getSum(conditions,fieldName);
        return sum;
    }
}
