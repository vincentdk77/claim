package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelisttempDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelisttemp;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MEDICALSETTLELISTTEMP的业务逻辑对象类<br>
 */
public class BLMedicalsettlelisttempActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelisttempActionBase.class);

    /**
     * 构造函数
     */
    public BLMedicalsettlelisttempActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalsettlelisttempDto medicalsettlelisttempDto)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //插入记录
        dbMedicalsettlelisttemp.insert(medicalsettlelisttempDto);
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
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //删除记录
        dbMedicalsettlelisttemp.delete(registcode, indexofsettle, stringtimestamp);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //按条件删除记录
        dbMedicalsettlelisttemp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalsettlelisttempDto medicalsettlelisttempDto)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //更新记录
        dbMedicalsettlelisttemp.update(medicalsettlelisttempDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public MedicalsettlelisttempDto findByPrimaryKey(DBManager dbManager,String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        //声明DTO
        MedicalsettlelisttempDto medicalsettlelisttempDto = null;
        //查询数据,赋值给DTO
        medicalsettlelisttempDto = dbMedicalsettlelisttemp.findByPrimaryKey(registcode, indexofsettle, stringtimestamp);
        return medicalsettlelisttempDto;
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
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelisttemp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMedicalsettlelisttemp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含medicalsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalsettlelisttemp.findByConditions(conditions);
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
        DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelisttemp.getCount(conditions);
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
    	DBMedicalsettlelisttemp dbMedicalsettlelisttemp = new DBMedicalsettlelisttemp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbMedicalsettlelisttemp.getSum(conditions,fieldName);
        return sum;
    }
}
