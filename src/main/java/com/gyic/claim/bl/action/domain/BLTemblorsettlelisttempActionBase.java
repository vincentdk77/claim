package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelisttemp;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorsettlelisttemp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELISTTEMP的业务逻辑对象类<br>
 */
public class BLTemblorsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelisttempActionBase.class);

    /**
     * 构造函数
     */
    public BLTemblorsettlelisttempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //插入记录
        dbTemblorsettlelisttemp.insert(temblorsettlelisttempDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //删除记录
        dbTemblorsettlelisttemp.delete(registcode, stringtimestamp, indexofsettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //按条件删除记录
        dbTemblorsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //更新记录
        dbTemblorsettlelisttemp.update(temblorsettlelisttempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public TemblorsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        //声明DTO
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        //查询数据,赋值给DTO
        temblorsettlelisttempDto = dbTemblorsettlelisttemp.findByPrimaryKey(registcode, stringtimestamp, indexofsettle);
        return temblorsettlelisttempDto;
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
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含temblorsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorsettlelisttemp.findByConditions(conditions);
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
        DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelisttemp.getCount(conditions);
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
    	DBTemblorsettlelisttemp dbTemblorsettlelisttemp = new DBTemblorsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbTemblorsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
