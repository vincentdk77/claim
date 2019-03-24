package com.sinosoft.claimzy.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是AGRICLAIMUPLOADLOG的数据访问对象基类<br>
 * 创建于 2015-07-06 11:11:59.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBAgriClaimUploadLogBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBAgriClaimUploadLogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBAgriClaimUploadLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO AGRICLAIMUPLOADLOG (");
        buffer.append("claimCode,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("responseCode,");
        buffer.append("errorCode,");
        buffer.append("batchNo,");
        buffer.append("errorDesc,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("responseMXCode,");
        buffer.append("errorMXCode,");
        buffer.append("errorMXDesc");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getCaseNo()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getPreCompensateNo()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getResponseCode()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getErrorCode()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getBatchNo()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getErrorDesc()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getUploadDate()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getFlag()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getResponseMXCode()).append("',");
            debugBuffer.append("'").append(agriClaimUploadLogDto.getErrorMXCode()).append("',");
            debugBuffer.append("").append(agriClaimUploadLogDto.getErrorMXDesc()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,agriClaimUploadLogDto.getClaimCode());
        dbManager.setString(2,agriClaimUploadLogDto.getClaimNo());
        dbManager.setString(3,agriClaimUploadLogDto.getCaseNo());
        dbManager.setString(4,agriClaimUploadLogDto.getPreCompensateNo());
        dbManager.setString(5,agriClaimUploadLogDto.getResponseCode());
        dbManager.setString(6,agriClaimUploadLogDto.getErrorCode());
        dbManager.setString(7,agriClaimUploadLogDto.getBatchNo());
        dbManager.setString(8,agriClaimUploadLogDto.getErrorDesc());
        dbManager.setDateTime(9,agriClaimUploadLogDto.getUploadDate());
        dbManager.setInt(10,agriClaimUploadLogDto.getFlag());
        dbManager.setString(11,agriClaimUploadLogDto.getResponseMXCode());
        dbManager.setString(12,agriClaimUploadLogDto.getErrorMXCode());
        dbManager.setString(13,agriClaimUploadLogDto.getErrorMXDesc());
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
        buffer.append("INSERT INTO AGRICLAIMUPLOADLOG (");
        buffer.append("claimCode,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("responseCode,");
        buffer.append("errorCode,");
        buffer.append("batchNo,");
        buffer.append("errorDesc,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("responseMXCode,");
        buffer.append("errorMXCode,");
        buffer.append("errorMXDesc");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	AgriClaimUploadLogDto agriClaimUploadLogDto = (AgriClaimUploadLogDto)i.next();
            dbManager.setString(1,agriClaimUploadLogDto.getClaimCode());
            dbManager.setString(2,agriClaimUploadLogDto.getClaimNo());
            dbManager.setString(3,agriClaimUploadLogDto.getCaseNo());
            dbManager.setString(4,agriClaimUploadLogDto.getPreCompensateNo());
            dbManager.setString(5,agriClaimUploadLogDto.getResponseCode());
            dbManager.setString(6,agriClaimUploadLogDto.getErrorCode());
            dbManager.setString(7,agriClaimUploadLogDto.getBatchNo());
            dbManager.setString(8,agriClaimUploadLogDto.getErrorDesc());
            dbManager.setDateTime(9,agriClaimUploadLogDto.getUploadDate());
            dbManager.setInt(10,agriClaimUploadLogDto.getFlag());
            dbManager.setString(11, agriClaimUploadLogDto.getResponseMXCode());
            dbManager.setString(12,agriClaimUploadLogDto.getErrorMXCode());
            dbManager.setString(13,agriClaimUploadLogDto.getErrorMXDesc());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param claimCode 理赔编码
     * @throws Exception
     */
    public void delete(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM AGRICLAIMUPLOADLOG ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("claimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,batchNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param agriClaimUploadLogDto agriClaimUploadLogDto
     * @throws Exception
     */
    public void update(AgriClaimUploadLogDto agriClaimUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE AGRICLAIMUPLOADLOG SET ");
        buffer.append("claimNo = ?, ");
        buffer.append("caseNo = ?, ");
        buffer.append("preCompensateNo = ?, ");
        buffer.append("responseCode = ?, ");
        buffer.append("errorCode = ?, ");
        buffer.append("batchNo = ?, ");
        buffer.append("errorDesc = ?, ");
        buffer.append("uploadDate = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("responseMXCode = ?, ");
        buffer.append("errorMXCode = ?, ");
        buffer.append("errorMXDesc = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE AGRICLAIMUPLOADLOG SET ");
            debugBuffer.append("claimNo = '" + agriClaimUploadLogDto.getClaimNo() + "', ");
            debugBuffer.append("caseNo = '" + agriClaimUploadLogDto.getCaseNo() + "', ");
            debugBuffer.append("preCompensateNo = '" + agriClaimUploadLogDto.getPreCompensateNo() + "', ");
            debugBuffer.append("responseCode = '" + agriClaimUploadLogDto.getResponseCode() + "', ");
            debugBuffer.append("errorCode = '" + agriClaimUploadLogDto.getErrorCode() + "', ");
            debugBuffer.append("batchNo = '" + agriClaimUploadLogDto.getBatchNo() + "', ");
            debugBuffer.append("errorDesc = '" + agriClaimUploadLogDto.getErrorDesc() + "', ");
            debugBuffer.append("uploadDate = '" + agriClaimUploadLogDto.getUploadDate() + "', ");
            debugBuffer.append("flag = '" + agriClaimUploadLogDto.getFlag() + "', ");
            debugBuffer.append("responseMXCOde'"+ agriClaimUploadLogDto.getResponseMXCode() + "', ");
            debugBuffer.append("erroMXCode'"+ agriClaimUploadLogDto.getErrorMXCode() + "', ");
            debugBuffer.append("errorMXDesc"+ agriClaimUploadLogDto.getErrorMXDesc() +" ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(agriClaimUploadLogDto.getBatchNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("batchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,agriClaimUploadLogDto.getClaimNo());
        dbManager.setString(2,agriClaimUploadLogDto.getCaseNo());
        dbManager.setString(3,agriClaimUploadLogDto.getPreCompensateNo());
        dbManager.setString(4,agriClaimUploadLogDto.getResponseCode());
        dbManager.setString(5,agriClaimUploadLogDto.getErrorCode());
        dbManager.setString(6,agriClaimUploadLogDto.getBatchNo());
        dbManager.setString(7,agriClaimUploadLogDto.getErrorDesc());
        dbManager.setDateTime(8,agriClaimUploadLogDto.getUploadDate());
        dbManager.setInt(9,agriClaimUploadLogDto.getFlag());
        dbManager.setString(10, agriClaimUploadLogDto.getResponseMXCode());
        dbManager.setString(11,agriClaimUploadLogDto.getErrorMXCode());
        dbManager.setString(12,agriClaimUploadLogDto.getErrorMXDesc());
        //设置条件字段;
        dbManager.setString(13,agriClaimUploadLogDto.getClaimCode());
        dbManager.executePreparedUpdate();

    }
    

    /**
     * 按主键查找一条数据
     * @param claimCode 理赔编码
     * @return agriClaimUploadLogDto
     * @throws Exception
     */
    public AgriClaimUploadLogDto findByPrimaryKey(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("claimCode,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("responseCode,");
        buffer.append("errorCode,");
        buffer.append("batchNo,");
        buffer.append("errorDesc,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("responseMXCode,");
        buffer.append("errorMXCode,");
        buffer.append("errorMXDesc");
        buffer.append("FROM AGRICLAIMUPLOADLOG ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("batchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,batchNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        AgriClaimUploadLogDto agriClaimUploadLogDto = null;
        if(resultSet.next()){
            agriClaimUploadLogDto = new AgriClaimUploadLogDto();
            agriClaimUploadLogDto.setClaimCode(dbManager.getString(resultSet,1));
            agriClaimUploadLogDto.setClaimNo(dbManager.getString(resultSet,2));
            agriClaimUploadLogDto.setCaseNo(dbManager.getString(resultSet,3));
            agriClaimUploadLogDto.setPreCompensateNo(dbManager.getString(resultSet,4));
            agriClaimUploadLogDto.setResponseCode(dbManager.getString(resultSet,5));
            agriClaimUploadLogDto.setErrorCode(dbManager.getString(resultSet,6));
            agriClaimUploadLogDto.setBatchNo(dbManager.getString(resultSet,7));
            agriClaimUploadLogDto.setErrorDesc(dbManager.getString(resultSet,8));
            agriClaimUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,9));
            agriClaimUploadLogDto.setFlag(dbManager.getInt(resultSet,10));
            agriClaimUploadLogDto.setResponseMXCode(dbManager.getString(resultSet, 11));
            agriClaimUploadLogDto.setErrorMXCode(dbManager.getString(resultSet, 12));
            agriClaimUploadLogDto.setErrorMXDesc(dbManager.getString(resultSet, 13));
        }
        resultSet.close();
        return agriClaimUploadLogDto;
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
        buffer.append("claimCode,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("responseCode,");
        buffer.append("errorCode,");
        buffer.append("batchNo,");
        buffer.append("errorDesc,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("responseMXCode,");
        buffer.append("errorMXCode,");
        buffer.append("errorMXDesc ");
        buffer.append("FROM AGRICLAIMUPLOADLOG WHERE ");
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
        AgriClaimUploadLogDto agriClaimUploadLogDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            agriClaimUploadLogDto = new AgriClaimUploadLogDto();
            agriClaimUploadLogDto.setClaimCode(dbManager.getString(resultSet,1));
            agriClaimUploadLogDto.setClaimNo(dbManager.getString(resultSet,2));
            agriClaimUploadLogDto.setCaseNo(dbManager.getString(resultSet,3));
            agriClaimUploadLogDto.setPreCompensateNo(dbManager.getString(resultSet,4));
            agriClaimUploadLogDto.setResponseCode(dbManager.getString(resultSet,5));
            agriClaimUploadLogDto.setErrorCode(dbManager.getString(resultSet,6));
            agriClaimUploadLogDto.setBatchNo(dbManager.getString(resultSet,7));
            agriClaimUploadLogDto.setErrorDesc(dbManager.getString(resultSet,8));
            agriClaimUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,9));
            agriClaimUploadLogDto.setFlag(dbManager.getInt(resultSet,10));
            agriClaimUploadLogDto.setResponseMXCode(dbManager.getString(resultSet, 11));
            agriClaimUploadLogDto.setErrorMXCode(dbManager.getString(resultSet, 12));
            agriClaimUploadLogDto.setErrorMXDesc(dbManager.getString(resultSet, 13));
            collection.add(agriClaimUploadLogDto);
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
        buffer.append("DELETE FROM AGRICLAIMUPLOADLOG WHERE ");
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
        buffer.append("SELECT count(*) FROM AGRICLAIMUPLOADLOG WHERE ");
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
