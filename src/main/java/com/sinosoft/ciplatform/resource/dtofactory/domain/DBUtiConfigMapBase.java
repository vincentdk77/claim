package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是商业险平台配置表的数据访问对象基类<br>
 * 创建于 2010-09-01 10:52:44.328<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBUtiConfigMapBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBUtiConfigMapBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiConfigMapBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void insert(UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO UtiConfigMap (");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(utiConfigMapDto.getSystemName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getClassName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getMapName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getKeyValue()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getValue()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getFlag()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getInputDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,utiConfigMapDto.getSystemName());
        dbManager.setString(2,utiConfigMapDto.getClassName());
        dbManager.setString(3,utiConfigMapDto.getMapName());
        dbManager.setString(4,utiConfigMapDto.getKeyValue());
        dbManager.setString(5,utiConfigMapDto.getValue());
        dbManager.setString(6,utiConfigMapDto.getValidStatus());
        dbManager.setString(7,utiConfigMapDto.getFlag());
        dbManager.setDateTime(8,utiConfigMapDto.getInputDate());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO UtiConfigMap (");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            UtiConfigMapDto utiConfigMapDto = (UtiConfigMapDto)i.next();
            dbManager.setString(1,utiConfigMapDto.getSystemName());
            dbManager.setString(2,utiConfigMapDto.getClassName());
            dbManager.setString(3,utiConfigMapDto.getMapName());
            dbManager.setString(4,utiConfigMapDto.getKeyValue());
            dbManager.setString(5,utiConfigMapDto.getValue());
            dbManager.setString(6,utiConfigMapDto.getValidStatus());
            dbManager.setString(7,utiConfigMapDto.getFlag());
            dbManager.setDateTime(8,utiConfigMapDto.getInputDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param systemName 系统名
     * @param className 类名
     * @param mapName HashMap名
     * @param keyValue 键
     * @throws Exception
     */
    public void delete(String systemName,String className,String mapName,String keyValue)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM UtiConfigMap ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(systemName).append("' AND ");
            debugBuffer.append("className=").append("'").append(className).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(mapName).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(keyValue).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,systemName);
        dbManager.setString(2,className);
        dbManager.setString(3,mapName);
        dbManager.setString(4,keyValue);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void update(UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE UtiConfigMap SET ");
        buffer.append("value = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("inputDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE UtiConfigMap SET ");
            debugBuffer.append("value = '" + utiConfigMapDto.getValue() + "', ");
            debugBuffer.append("validStatus = '" + utiConfigMapDto.getValidStatus() + "', ");
            debugBuffer.append("flag = '" + utiConfigMapDto.getFlag() + "', ");
            debugBuffer.append("inputDate = '" + utiConfigMapDto.getInputDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(utiConfigMapDto.getSystemName()).append("' AND ");
            debugBuffer.append("className=").append("'").append(utiConfigMapDto.getClassName()).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(utiConfigMapDto.getMapName()).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(utiConfigMapDto.getKeyValue()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,utiConfigMapDto.getValue());
        dbManager.setString(2,utiConfigMapDto.getValidStatus());
        dbManager.setString(3,utiConfigMapDto.getFlag());
        dbManager.setDateTime(4,utiConfigMapDto.getInputDate());
        //设置条件字段;
        dbManager.setString(5,utiConfigMapDto.getSystemName());
        dbManager.setString(6,utiConfigMapDto.getClassName());
        dbManager.setString(7,utiConfigMapDto.getMapName());
        dbManager.setString(8,utiConfigMapDto.getKeyValue());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param systemName 系统名
     * @param className 类名
     * @param mapName HashMap名
     * @param keyValue 键
     * @return UtiConfigMapDto
     * @throws Exception
     */
    public UtiConfigMapDto findByPrimaryKey(String systemName,String className,String mapName,String keyValue)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append("FROM UtiConfigMap ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(systemName).append("' AND ");
            debugBuffer.append("className=").append("'").append(className).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(mapName).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(keyValue).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,systemName);
        dbManager.setString(2,className);
        dbManager.setString(3,mapName);
        dbManager.setString(4,keyValue);
        ResultSet resultSet = dbManager.executePreparedQuery();
        UtiConfigMapDto utiConfigMapDto = null;
        if(resultSet.next()){
            utiConfigMapDto = new UtiConfigMapDto();
            utiConfigMapDto.setSystemName(dbManager.getString(resultSet,1));
            utiConfigMapDto.setClassName(dbManager.getString(resultSet,2));
            utiConfigMapDto.setMapName(dbManager.getString(resultSet,3));
            utiConfigMapDto.setKeyValue(dbManager.getString(resultSet,4));
            utiConfigMapDto.setValue(dbManager.getString(resultSet,5));
            utiConfigMapDto.setValidStatus(dbManager.getString(resultSet,6));
            utiConfigMapDto.setFlag(dbManager.getString(resultSet,7));
            utiConfigMapDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
        }
        resultSet.close();
        return utiConfigMapDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append("FROM UtiConfigMap WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        UtiConfigMapDto utiConfigMapDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            utiConfigMapDto = new UtiConfigMapDto();
            utiConfigMapDto.setSystemName(dbManager.getString(resultSet,1));
            utiConfigMapDto.setClassName(dbManager.getString(resultSet,2));
            utiConfigMapDto.setMapName(dbManager.getString(resultSet,3));
            utiConfigMapDto.setKeyValue(dbManager.getString(resultSet,4));
            utiConfigMapDto.setValue(dbManager.getString(resultSet,5));
            utiConfigMapDto.setValidStatus(dbManager.getString(resultSet,6));
            utiConfigMapDto.setFlag(dbManager.getString(resultSet,7));
            utiConfigMapDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            collection.add(utiConfigMapDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM UtiConfigMap WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM UtiConfigMap WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
