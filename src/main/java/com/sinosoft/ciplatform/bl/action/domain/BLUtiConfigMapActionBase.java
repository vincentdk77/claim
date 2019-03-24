package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBUtiConfigMap;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是商业险平台配置表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLUtiConfigMapActionBase{
    private static Logger logger = Logger.getLogger(BLUtiConfigMapActionBase.class);

    /**
     * 构造函数
     */
    public BLUtiConfigMapActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //插入记录
        dbUtiConfigMap.insert(utiConfigMapDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param systemName 系统名
     * @param className 类名
     * @param mapName HashMap名
     * @param keyValue 键
     * @throws Exception
     */
    public void delete(DBManager dbManager,String systemName,String className,String mapName,String keyValue)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //删除记录
        dbUtiConfigMap.delete(systemName, className, mapName, keyValue);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //按条件删除记录
        dbUtiConfigMap.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //更新记录
        dbUtiConfigMap.update(utiConfigMapDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param systemName 系统名
     * @param className 类名
     * @param mapName HashMap名
     * @param keyValue 键
     * @return utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public UtiConfigMapDto findByPrimaryKey(DBManager dbManager,String systemName,String className,String mapName,String keyValue)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        //声明DTO
        UtiConfigMapDto utiConfigMapDto = null;
        //查询数据,赋值给DTO
        utiConfigMapDto = dbUtiConfigMap.findByPrimaryKey(systemName, className, mapName, keyValue);
        return utiConfigMapDto;
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
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfigMap.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbUtiConfigMap.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含utiConfigMapDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbUtiConfigMap.findByConditions(conditions);
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
        DBUtiConfigMap dbUtiConfigMap = new DBUtiConfigMap(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiConfigMap.getCount(conditions);
        return count;
    }
}
