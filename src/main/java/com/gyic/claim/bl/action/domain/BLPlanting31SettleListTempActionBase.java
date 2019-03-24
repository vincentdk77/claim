package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleListTemp;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelisttemp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleListTemp的业务逻辑对象类<br>
 */
public class BLPlanting31SettleListTempActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListTempActionBase.class);

    /**
     * 构造函数
     */
    public BLPlanting31SettleListTempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //插入记录
        dbPlanting31SettleListTemp.insert(planting31SettleListTempDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //删除记录
        dbPlanting31SettleListTemp.delete(registCode, stringTimeStamp, indexOfSettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //按条件删除记录
        dbPlanting31SettleListTemp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //更新记录
        dbPlanting31SettleListTemp.update(planting31SettleListTempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public Planting31SettleListTempDto findByPrimaryKey(DBManager dbManager,String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        //声明DTO
        Planting31SettleListTempDto planting31SettleListTempDto = null;
        //查询数据,赋值给DTO
        planting31SettleListTempDto = dbPlanting31SettleListTemp.findByPrimaryKey(registCode, stringTimeStamp, indexOfSettle);
        return planting31SettleListTempDto;
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleListTemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31SettleListTemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含planting31SettleListTempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31SettleListTemp.findByConditions(conditions);
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleListTemp.getCount(conditions);
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
        DBPlanting31SettleListTemp dbPlanting31SettleListTemp = new DBPlanting31SettleListTemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleListTemp.getSum(conditions,fieldName);
        return sum;
    }

}
