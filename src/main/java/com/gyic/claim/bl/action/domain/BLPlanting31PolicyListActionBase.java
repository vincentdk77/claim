package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31PolicyList;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingpolicylist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31PolicyList的业务逻辑对象类<br>
 */
public class BLPlanting31PolicyListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31PolicyListActionBase.class);

    /**
     * 构造函数
     */
    public BLPlanting31PolicyListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //插入记录
        dbPlanting31PolicyList.insert(planting31PolicyListDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //删除记录
        dbPlanting31PolicyList.delete(inusreListCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //按条件删除记录
        dbPlanting31PolicyList.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //更新记录
        dbPlanting31PolicyList.update(planting31PolicyListDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @return planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public Planting31PolicyListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        //声明DTO
        Planting31PolicyListDto planting31PolicyListDto = null;
        //查询数据,赋值给DTO
        planting31PolicyListDto = dbPlanting31PolicyList.findByPrimaryKey(inusreListCode);
        return planting31PolicyListDto;
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31PolicyList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31PolicyList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含planting31PolicyListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31PolicyList.findByConditions(conditions);
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31PolicyList.getCount(conditions);
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
        DBPlanting31PolicyList dbPlanting31PolicyList = new DBPlanting31PolicyList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31PolicyList.getSum(conditions,fieldName);
        return sum;
    }
}
