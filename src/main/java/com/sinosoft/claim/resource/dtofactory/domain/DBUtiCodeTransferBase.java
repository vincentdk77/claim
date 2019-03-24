package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是UtiCodeTransfer-险种险类代码对照表的数据访问对象基类<br>
 * 创建于 2006-05-27 13:19:14.593<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBUtiCodeTransferBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBUtiCodeTransferBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiCodeTransferBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void insert(UtiCodeTransferDto utiCodeTransferDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO UtiCodeTransfer (");
        buffer.append("configCode,");
        buffer.append("outerCode,");
        buffer.append("innerCode,");
        buffer.append("codeType,");
        buffer.append("validStatus,");
        buffer.append("riskType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(utiCodeTransferDto.getConfigCode()).append("',");
            debugBuffer.append("'").append(utiCodeTransferDto.getOuterCode()).append("',");
            debugBuffer.append("'").append(utiCodeTransferDto.getInnerCode()).append("',");
            debugBuffer.append("'").append(utiCodeTransferDto.getCodeType()).append("',");
            debugBuffer.append("'").append(utiCodeTransferDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(utiCodeTransferDto.getRiskType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,utiCodeTransferDto.getConfigCode());
        dbManager.setString(2,utiCodeTransferDto.getOuterCode());
        dbManager.setString(3,utiCodeTransferDto.getInnerCode());
        dbManager.setString(4,utiCodeTransferDto.getCodeType());
        dbManager.setString(5,utiCodeTransferDto.getValidStatus());
        dbManager.setString(6,utiCodeTransferDto.getRiskType());
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
        buffer.append("INSERT INTO UtiCodeTransfer (");
        buffer.append("configCode,");
        buffer.append("outerCode,");
        buffer.append("innerCode,");
        buffer.append("codeType,");
        buffer.append("validStatus,");
        buffer.append("riskType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            UtiCodeTransferDto utiCodeTransferDto = (UtiCodeTransferDto)i.next();
            dbManager.setString(1,utiCodeTransferDto.getConfigCode());
            dbManager.setString(2,utiCodeTransferDto.getOuterCode());
            dbManager.setString(3,utiCodeTransferDto.getInnerCode());
            dbManager.setString(4,utiCodeTransferDto.getCodeType());
            dbManager.setString(5,utiCodeTransferDto.getValidStatus());
            dbManager.setString(6,utiCodeTransferDto.getRiskType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param configCode 程序中代码
     * @throws Exception
     */
    public void delete(String configCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM UtiCodeTransfer ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(configCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,configCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiCodeTransferDto utiCodeTransferDto
     * @throws Exception
     */
    public void update(UtiCodeTransferDto utiCodeTransferDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE UtiCodeTransfer SET ");
        buffer.append("outerCode = ?, ");
        buffer.append("innerCode = ?, ");
        buffer.append("codeType = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("riskType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE UtiCodeTransfer SET ");
            debugBuffer.append("outerCode = '" + utiCodeTransferDto.getOuterCode() + "', ");
            debugBuffer.append("innerCode = '" + utiCodeTransferDto.getInnerCode() + "', ");
            debugBuffer.append("codeType = '" + utiCodeTransferDto.getCodeType() + "', ");
            debugBuffer.append("validStatus = '" + utiCodeTransferDto.getValidStatus() + "', ");
            debugBuffer.append("riskType = '" + utiCodeTransferDto.getRiskType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(utiCodeTransferDto.getConfigCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,utiCodeTransferDto.getOuterCode());
        dbManager.setString(2,utiCodeTransferDto.getInnerCode());
        dbManager.setString(3,utiCodeTransferDto.getCodeType());
        dbManager.setString(4,utiCodeTransferDto.getValidStatus());
        dbManager.setString(5,utiCodeTransferDto.getRiskType());
        //设置条件字段;
        dbManager.setString(6,utiCodeTransferDto.getConfigCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param configCode 程序中代码
     * @return UtiCodeTransferDto
     * @throws Exception
     */
    public UtiCodeTransferDto findByPrimaryKey(String configCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("configCode,");
        buffer.append("outerCode,");
        buffer.append("innerCode,");
        buffer.append("codeType,");
        buffer.append("validStatus,");
        buffer.append("riskType ");
        buffer.append("FROM UtiCodeTransfer ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("configCode=").append("'").append(configCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("configCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,configCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        UtiCodeTransferDto utiCodeTransferDto = null;
        if(resultSet.next()){
            utiCodeTransferDto = new UtiCodeTransferDto();
            utiCodeTransferDto.setConfigCode(dbManager.getString(resultSet,1));
            utiCodeTransferDto.setOuterCode(dbManager.getString(resultSet,2));
            utiCodeTransferDto.setInnerCode(dbManager.getString(resultSet,3));
            utiCodeTransferDto.setCodeType(dbManager.getString(resultSet,4));
            utiCodeTransferDto.setValidStatus(dbManager.getString(resultSet,5));
            utiCodeTransferDto.setRiskType(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return utiCodeTransferDto;
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
        buffer.append("outerCode,");
        buffer.append("innerCode,");
        buffer.append("codeType,");
        buffer.append("validStatus,");
        buffer.append("riskType ");
        buffer.append("FROM UtiCodeTransfer WHERE ");
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
        UtiCodeTransferDto utiCodeTransferDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            utiCodeTransferDto = new UtiCodeTransferDto();
            utiCodeTransferDto.setConfigCode(dbManager.getString(resultSet,1));
            utiCodeTransferDto.setOuterCode(dbManager.getString(resultSet,2));
            utiCodeTransferDto.setInnerCode(dbManager.getString(resultSet,3));
            utiCodeTransferDto.setCodeType(dbManager.getString(resultSet,4));
            utiCodeTransferDto.setValidStatus(dbManager.getString(resultSet,5));
            utiCodeTransferDto.setRiskType(dbManager.getString(resultSet,6));
            collection.add(utiCodeTransferDto);
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
        buffer.append("DELETE FROM UtiCodeTransfer WHERE ");
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
        String statement;
          statement = "SELECT count(1) FROM UtiCodeTransfer WHERE ";
           statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
