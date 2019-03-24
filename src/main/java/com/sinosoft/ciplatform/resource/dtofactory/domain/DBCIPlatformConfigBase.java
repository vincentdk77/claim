package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIPlatformConfig的数据访问对象基类<br>
 * 创建于 2011-05-18 08:42:38.640<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIPlatformConfigBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCIPlatformConfigBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIPlatformConfigBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void insert(CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIPlatformConfig (");
        buffer.append("configCode,");
        buffer.append("configName,");
        buffer.append("comCode,");
        buffer.append("riskCode,");
        buffer.append("version,");
        buffer.append("url,");
        buffer.append("userName,");
        buffer.append("pwd,");
        buffer.append("configValue,");
        buffer.append("configValueDes,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIPlatformConfigDto.getConfigCode()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getConfigName()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getComCode()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getVersion()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getUrl()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getUserName()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getPwd()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getConfigValue()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getConfigValueDes()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(cIPlatformConfigDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIPlatformConfigDto.getConfigCode());
        dbManager.setString(2,cIPlatformConfigDto.getConfigName());
        dbManager.setString(3,cIPlatformConfigDto.getComCode());
        dbManager.setString(4,cIPlatformConfigDto.getRiskCode());
        dbManager.setString(5,cIPlatformConfigDto.getVersion());
        dbManager.setString(6,cIPlatformConfigDto.getUrl());
        dbManager.setString(7,cIPlatformConfigDto.getUserName());
        dbManager.setString(8,cIPlatformConfigDto.getPwd());
        dbManager.setString(9,cIPlatformConfigDto.getConfigValue());
        dbManager.setString(10,cIPlatformConfigDto.getConfigValueDes());
        dbManager.setString(11,cIPlatformConfigDto.getValidStatus());
        dbManager.setString(12,cIPlatformConfigDto.getFlag());
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
        buffer.append("INSERT INTO CIPlatformConfig (");
        buffer.append("configCode,");
        buffer.append("configName,");
        buffer.append("comCode,");
        buffer.append("riskCode,");
        buffer.append("version,");
        buffer.append("url,");
        buffer.append("userName,");
        buffer.append("pwd,");
        buffer.append("configValue,");
        buffer.append("configValueDes,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIPlatformConfigDto cIPlatformConfigDto = (CIPlatformConfigDto)i.next();
            dbManager.setString(1,cIPlatformConfigDto.getConfigCode());
            dbManager.setString(2,cIPlatformConfigDto.getConfigName());
            dbManager.setString(3,cIPlatformConfigDto.getComCode());
            dbManager.setString(4,cIPlatformConfigDto.getRiskCode());
            dbManager.setString(5,cIPlatformConfigDto.getVersion());
            dbManager.setString(6,cIPlatformConfigDto.getUrl());
            dbManager.setString(7,cIPlatformConfigDto.getUserName());
            dbManager.setString(8,cIPlatformConfigDto.getPwd());
            dbManager.setString(9,cIPlatformConfigDto.getConfigValue());
            dbManager.setString(10,cIPlatformConfigDto.getConfigValueDes());
            dbManager.setString(11,cIPlatformConfigDto.getValidStatus());
            dbManager.setString(12,cIPlatformConfigDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @throws Exception
     */
    public void delete(String configCode,String comCode,String riskCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIPlatformConfig ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(configCode).append("' AND ");
            debugBuffer.append("comCode=").append("'").append(comCode).append("' AND ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ? And ");
        buffer.append("comCode = ? And ");
        buffer.append("riskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,configCode);
        dbManager.setString(2,comCode);
        dbManager.setString(3,riskCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void update(CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIPlatformConfig SET ");
        buffer.append("configName = ?, ");
        buffer.append("version = ?, ");
        buffer.append("url = ?, ");
        buffer.append("userName = ?, ");
        buffer.append("pwd = ?, ");
        buffer.append("configValue = ?, ");
        buffer.append("configValueDes = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIPlatformConfig SET ");
            debugBuffer.append("configName = '" + cIPlatformConfigDto.getConfigName() + "', ");
            debugBuffer.append("version = '" + cIPlatformConfigDto.getVersion() + "', ");
            debugBuffer.append("url = '" + cIPlatformConfigDto.getUrl() + "', ");
            debugBuffer.append("userName = '" + cIPlatformConfigDto.getUserName() + "', ");
            debugBuffer.append("pwd = '" + cIPlatformConfigDto.getPwd() + "', ");
            debugBuffer.append("configValue = '" + cIPlatformConfigDto.getConfigValue() + "', ");
            debugBuffer.append("configValueDes = '" + cIPlatformConfigDto.getConfigValueDes() + "', ");
            debugBuffer.append("validStatus = '" + cIPlatformConfigDto.getValidStatus() + "', ");
            debugBuffer.append("flag = '" + cIPlatformConfigDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(cIPlatformConfigDto.getConfigCode()).append("' AND ");
            debugBuffer.append("comCode=").append("'").append(cIPlatformConfigDto.getComCode()).append("' AND ");
            debugBuffer.append("riskCode=").append("'").append(cIPlatformConfigDto.getRiskCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ? And ");
        buffer.append("comCode = ? And ");
        buffer.append("riskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,cIPlatformConfigDto.getConfigName());
        dbManager.setString(2,cIPlatformConfigDto.getVersion());
        dbManager.setString(3,cIPlatformConfigDto.getUrl());
        dbManager.setString(4,cIPlatformConfigDto.getUserName());
        dbManager.setString(5,cIPlatformConfigDto.getPwd());
        dbManager.setString(6,cIPlatformConfigDto.getConfigValue());
        dbManager.setString(7,cIPlatformConfigDto.getConfigValueDes());
        dbManager.setString(8,cIPlatformConfigDto.getValidStatus());
        dbManager.setString(9,cIPlatformConfigDto.getFlag());
        //设置条件字段;
        dbManager.setString(10,cIPlatformConfigDto.getConfigCode());
        dbManager.setString(11,cIPlatformConfigDto.getComCode());
        dbManager.setString(12,cIPlatformConfigDto.getRiskCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @return CIPlatformConfigDto
     * @throws Exception
     */
    public CIPlatformConfigDto findByPrimaryKey(String configCode,String comCode,String riskCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("configCode,");
        buffer.append("configName,");
        buffer.append("comCode,");
        buffer.append("riskCode,");
        buffer.append("version,");
        buffer.append("url,");
        buffer.append("userName,");
        buffer.append("pwd,");
        buffer.append("configValue,");
        buffer.append("configValueDes,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append("FROM CIPlatformConfig ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(configCode).append("' AND ");
            debugBuffer.append("comCode=").append("'").append(comCode).append("' AND ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ? And ");
        buffer.append("comCode = ? And ");
        buffer.append("riskCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,configCode);
        dbManager.setString(2,comCode);
        dbManager.setString(3,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIPlatformConfigDto cIPlatformConfigDto = null;
        if(resultSet.next()){
            cIPlatformConfigDto = new CIPlatformConfigDto();
            cIPlatformConfigDto.setConfigCode(dbManager.getString(resultSet,1));
            cIPlatformConfigDto.setConfigName(dbManager.getString(resultSet,2));
            cIPlatformConfigDto.setComCode(dbManager.getString(resultSet,3));
            cIPlatformConfigDto.setRiskCode(dbManager.getString(resultSet,4));
            cIPlatformConfigDto.setVersion(dbManager.getString(resultSet,5));
            cIPlatformConfigDto.setUrl(dbManager.getString(resultSet,6));
            cIPlatformConfigDto.setUserName(dbManager.getString(resultSet,7));
            cIPlatformConfigDto.setPwd(dbManager.getString(resultSet,8));
            cIPlatformConfigDto.setConfigValue(dbManager.getString(resultSet,9));
            cIPlatformConfigDto.setConfigValueDes(dbManager.getString(resultSet,10));
            cIPlatformConfigDto.setValidStatus(dbManager.getString(resultSet,11));
            cIPlatformConfigDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return cIPlatformConfigDto;
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
        buffer.append("configCode,");
        buffer.append("configName,");
        buffer.append("comCode,");
        buffer.append("riskCode,");
        buffer.append("version,");
        buffer.append("url,");
        buffer.append("userName,");
        buffer.append("pwd,");
        buffer.append("configValue,");
        buffer.append("configValueDes,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append("FROM CIPlatformConfig WHERE ");
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
        CIPlatformConfigDto cIPlatformConfigDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIPlatformConfigDto = new CIPlatformConfigDto();
            cIPlatformConfigDto.setConfigCode(dbManager.getString(resultSet,1));
            cIPlatformConfigDto.setConfigName(dbManager.getString(resultSet,2));
            cIPlatformConfigDto.setComCode(dbManager.getString(resultSet,3));
            cIPlatformConfigDto.setRiskCode(dbManager.getString(resultSet,4));
            cIPlatformConfigDto.setVersion(dbManager.getString(resultSet,5));
            cIPlatformConfigDto.setUrl(dbManager.getString(resultSet,6));
            cIPlatformConfigDto.setUserName(dbManager.getString(resultSet,7));
            cIPlatformConfigDto.setPwd(dbManager.getString(resultSet,8));
            cIPlatformConfigDto.setConfigValue(dbManager.getString(resultSet,9));
            cIPlatformConfigDto.setConfigValueDes(dbManager.getString(resultSet,10));
            cIPlatformConfigDto.setValidStatus(dbManager.getString(resultSet,11));
            cIPlatformConfigDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(cIPlatformConfigDto);
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
        buffer.append("DELETE FROM CIPlatformConfig WHERE ");
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
        buffer.append("SELECT count(*) FROM CIPlatformConfig WHERE ");
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
