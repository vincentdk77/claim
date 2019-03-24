package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELISTTEMP的业务逻辑对象类<br>
 */
public class BLPlantingsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelisttempActionBase.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelisttempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //插入记录
        dbPlantingsettlelisttemp.insert(plantingsettlelisttempDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //删除记录
        dbPlantingsettlelisttemp.delete(registcode, indexofsettle, stringtimestamp);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //按条件删除记录
        dbPlantingsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //更新记录
        dbPlantingsettlelisttemp.update(plantingsettlelisttempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public PlantingsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        //声明DTO
        PlantingsettlelisttempDto plantingsettlelisttempDto = null;
        //查询数据,赋值给DTO
        plantingsettlelisttempDto = dbPlantingsettlelisttemp.findByPrimaryKey(registcode, indexofsettle, stringtimestamp);
        return plantingsettlelisttempDto;
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
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含plantingsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingsettlelisttemp.findByConditions(conditions);
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
        DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelisttemp.getCount(conditions);
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
    	DBPlantingsettlelisttemp dbPlantingsettlelisttemp = new DBPlantingsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
