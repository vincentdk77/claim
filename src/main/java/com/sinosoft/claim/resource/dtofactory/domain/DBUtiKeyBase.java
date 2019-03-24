package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiKeyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utikey键值信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiKeyBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiKeyBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiKeyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void insert(UtiKeyDto utiKeyDto) throws Exception{
        String statement = " Insert Into UtiKey(" + 
                           " TableName," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiKeyDto.getTableName());
        dbManager.setString(2,utiKeyDto.getFieldName());
        dbManager.setString(3,utiKeyDto.getFieldMeaning());
        dbManager.setString(4,utiKeyDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiKeyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiKeyDto utiKeyDto = (UtiKeyDto)i.next();
            insert(utiKeyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param tableName 表名
     * @throws Exception
     */
    public void delete(String tableName) throws Exception{
        String statement = " Delete From UtiKey Where " +
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,tableName);
        dbManager.executePreparedUpdate();
        log.info("DBUtiKeyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiKeyDto utiKeyDto
     * @throws Exception
     */
    public void update(UtiKeyDto utiKeyDto) throws Exception{
        String statement = " Update UtiKey Set FieldName = ?," + 
                           " FieldMeaning = ?," + 
                           " Flag = ? Where " +
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiKeyDto.getFieldName());
        dbManager.setString(2,utiKeyDto.getFieldMeaning());
        dbManager.setString(3,utiKeyDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,utiKeyDto.getTableName());
        dbManager.executePreparedUpdate();

        log.info("DBUtiKeyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param tableName 表名
     * @return UtiKeyDto
     * @throws Exception
     */
    public UtiKeyDto findByPrimaryKey(String tableName) throws Exception{
        String statement = " Select TableName," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " Flag From UtiKey Where " +
                           " TableName = ?";
        UtiKeyDto utiKeyDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,tableName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiKeyDto = new UtiKeyDto();
            utiKeyDto.setTableName(dbManager.getString(resultSet,1));
            utiKeyDto.setFieldName(dbManager.getString(resultSet,2));
            utiKeyDto.setFieldMeaning(dbManager.getString(resultSet,3));
            utiKeyDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBUtiKeyBase.findByPrimaryKey() success!");
        return utiKeyDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select TableName," + 
                           " FieldName," + 
                           " FieldMeaning," + 
                           " Flag From UtiKey Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiKeyDto utiKeyDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            utiKeyDto = new UtiKeyDto();
            utiKeyDto.setTableName(dbManager.getString(resultSet,1));
            utiKeyDto.setFieldName(dbManager.getString(resultSet,2));
            utiKeyDto.setFieldMeaning(dbManager.getString(resultSet,3));
            utiKeyDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(utiKeyDto);
        }
        resultSet.close();
        log.info("DBUtiKeyBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From UtiKey Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiKeyBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from UtiKey Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiKeyBase.getCount() success!");
        return count;
    }
}
