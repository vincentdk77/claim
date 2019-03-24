package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔平台查询表的数据访问对象基类<br>
 * 创建于 2006-06-23 16:43:16.718<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimDemandBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimDemandBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBCIClaimDemandBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void insert(CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIClaimDemand (");
        buffer.append("ClaimCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RegistUploadFlag,");
        buffer.append("ClaimUploadFlag,");
        buffer.append("EndCaseUploadFlag,");
        buffer.append("CancelUploadFlag,");
        buffer.append("EndCaseAppendFlag,");
        buffer.append("CaseCheckNo,");
        //2011
        buffer.append("riskcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIClaimDemandDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getRegistUploadFlag()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getClaimUploadFlag()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getEndCaseUploadFlag()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getCancelUploadFlag()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getEndCaseAppendUploadFlag()).append("',");
            debugBuffer.append("'").append(cIClaimDemandDto.getCaseCheckNo()).append("',");
            //2011
            debugBuffer.append("'").append(cIClaimDemandDto.getRiskcode()).append("',");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIClaimDemandDto.getClaimCode());
        dbManager.setString(2,cIClaimDemandDto.getRegistNo());
        dbManager.setString(3,cIClaimDemandDto.getClaimNo());
        dbManager.setString(4,cIClaimDemandDto.getRegistUploadFlag());
        dbManager.setString(5,cIClaimDemandDto.getClaimUploadFlag());
        dbManager.setString(6,cIClaimDemandDto.getEndCaseUploadFlag());
        dbManager.setString(7,cIClaimDemandDto.getCancelUploadFlag());
        dbManager.setString(8,cIClaimDemandDto.getEndCaseAppendUploadFlag());
        dbManager.setString(9,cIClaimDemandDto.getCaseCheckNo());
        //2011
        dbManager.setString(10,cIClaimDemandDto.getRiskcode());
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
        buffer.append("INSERT INTO CIClaimDemand (");
        buffer.append("ClaimCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RegistUploadFlag,");
        buffer.append("ClaimUploadFlag,");
        buffer.append("EndCaseUploadFlag,");
        buffer.append("CancelUploadFlag,");
        buffer.append("EndCaseAppendFlag,");
        buffer.append("CaseCheckNo,");
        //2011
        buffer.append("riskcode ");
        
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIClaimDemandDto cIClaimDemandDto = (CIClaimDemandDto)i.next();
            dbManager.setString(1,cIClaimDemandDto.getClaimCode());
            dbManager.setString(2,cIClaimDemandDto.getRegistNo());
            dbManager.setString(3,cIClaimDemandDto.getClaimNo());
            dbManager.setString(4,cIClaimDemandDto.getRegistUploadFlag());
            dbManager.setString(5,cIClaimDemandDto.getClaimUploadFlag());
            dbManager.setString(6,cIClaimDemandDto.getEndCaseUploadFlag());
            dbManager.setString(7,cIClaimDemandDto.getCancelUploadFlag());
            dbManager.setString(8,cIClaimDemandDto.getEndCaseAppendUploadFlag());
            dbManager.setString(9,cIClaimDemandDto.getCaseCheckNo());
            //2011
            dbManager.setString(10,cIClaimDemandDto.getRiskcode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param claimCode 理赔编码
     * @throws Exception
     */
    public void delete(String claimCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimDemand ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimCode=").append("'").append(claimCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void update(CIClaimDemandDto cIClaimDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimDemand SET ");
        buffer.append("RegistNo = ?, ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("RegistUploadFlag = ?, ");
        buffer.append("ClaimUploadFlag = ?, ");
        buffer.append("EndCaseUploadFlag = ?, ");
        buffer.append("CancelUploadFlag = ?, ");
        buffer.append("EndCaseAppendFlag = ?,");
        buffer.append("CaseCheckNo = ?,");
      //2011
        buffer.append("riskcode=? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimDemand SET ");
            debugBuffer.append("RegistNo = '" + cIClaimDemandDto.getRegistNo() + "', ");
            debugBuffer.append("ClaimNo = '" + cIClaimDemandDto.getClaimNo() + "', ");
            debugBuffer.append("RegistUploadFlag = '" + cIClaimDemandDto.getRegistUploadFlag() + "', ");
            debugBuffer.append("ClaimUploadFlag = '" + cIClaimDemandDto.getClaimUploadFlag() + "', ");
            debugBuffer.append("EndCaseUploadFlag = '" + cIClaimDemandDto.getEndCaseUploadFlag() + "', ");
            debugBuffer.append("CancelUploadFlag = '" + cIClaimDemandDto.getCancelUploadFlag() + "', ");
            debugBuffer.append("EndCaseAppendFlag = '" + cIClaimDemandDto.getEndCaseAppendUploadFlag() + "', ");
            debugBuffer.append("CaseCheckNo = '" + cIClaimDemandDto.getCaseCheckNo() + "',");
            //2011
            debugBuffer.append("riskcode = '" + cIClaimDemandDto.getRiskcode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimCode=").append("'").append(cIClaimDemandDto.getClaimCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,cIClaimDemandDto.getRegistNo());
        dbManager.setString(2,cIClaimDemandDto.getClaimNo());
        dbManager.setString(3,cIClaimDemandDto.getRegistUploadFlag());
        dbManager.setString(4,cIClaimDemandDto.getClaimUploadFlag());
        dbManager.setString(5,cIClaimDemandDto.getEndCaseUploadFlag());
        dbManager.setString(6,cIClaimDemandDto.getCancelUploadFlag());
        dbManager.setString(7,cIClaimDemandDto.getEndCaseAppendUploadFlag());
        dbManager.setString(8,cIClaimDemandDto.getCaseCheckNo());
      //2011
        dbManager.setString(9,cIClaimDemandDto.getRiskcode());
        //设置条件字段;
        dbManager.setString(10,cIClaimDemandDto.getClaimCode());
        dbManager.executePreparedUpdate();

    }
    
    /**
     * 按条件更新一条记录
     * @param conditions
     * @throws Exception
     */
    public void update(String conditions)
    	throws Exception{
    	String updateSql = "UPDATE CIClaimDemand "+conditions;
    	dbManager.executeUpdate(updateSql);
    }

    /**
     * 按主键查找一条数据
     * @param claimCode 理赔编码
     * @return CIClaimDemandDto
     * @throws Exception
     */
    public CIClaimDemandDto findByPrimaryKey(String claimCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RegistUploadFlag,");
        buffer.append("ClaimUploadFlag,");
        buffer.append("EndCaseUploadFlag,");
        buffer.append("CancelUploadFlag,");
        buffer.append("EndCaseAppendFlag,");
        buffer.append("CaseCheckNo,");
      //2011
        buffer.append("riskcode ");
        buffer.append("FROM CIClaimDemand ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimCode=").append("'").append(claimCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIClaimDemandDto cIClaimDemandDto = null;
        if(resultSet.next()){
            cIClaimDemandDto = new CIClaimDemandDto();
            cIClaimDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            cIClaimDemandDto.setRegistNo(dbManager.getString(resultSet,2));
            cIClaimDemandDto.setClaimNo(dbManager.getString(resultSet,3));
            cIClaimDemandDto.setRegistUploadFlag(dbManager.getString(resultSet,4));
            cIClaimDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,5));
            cIClaimDemandDto.setEndCaseUploadFlag(dbManager.getString(resultSet,6));
            cIClaimDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,7));
            cIClaimDemandDto.setEndCaseAppendUploadFlag(dbManager.getString(resultSet,8));
            cIClaimDemandDto.setCaseCheckNo(dbManager.getString(resultSet,9));
            //2011
            cIClaimDemandDto.setRiskcode(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return cIClaimDemandDto;
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
        buffer.append("ClaimCode,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RegistUploadFlag,");
        buffer.append("ClaimUploadFlag,");
        buffer.append("EndCaseUploadFlag,");
        buffer.append("CancelUploadFlag,");
        buffer.append("EndCaseAppendFlag,");
        buffer.append("CaseCheckNo,");
      //2011
        buffer.append("riskcode ");
        buffer.append("FROM CIClaimDemand WHERE ");
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
        CIClaimDemandDto cIClaimDemandDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIClaimDemandDto = new CIClaimDemandDto();
            cIClaimDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            cIClaimDemandDto.setRegistNo(dbManager.getString(resultSet,2));
            cIClaimDemandDto.setClaimNo(dbManager.getString(resultSet,3));
            cIClaimDemandDto.setRegistUploadFlag(dbManager.getString(resultSet,4));
            cIClaimDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,5));
            cIClaimDemandDto.setEndCaseUploadFlag(dbManager.getString(resultSet,6));
            cIClaimDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,7));
            cIClaimDemandDto.setEndCaseAppendUploadFlag(dbManager.getString(resultSet,8));
            cIClaimDemandDto.setCaseCheckNo(dbManager.getString(resultSet,9));
          //2011
            cIClaimDemandDto.setRiskcode(dbManager.getString(resultSet,10));
            collection.add(cIClaimDemandDto);
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
        buffer.append("DELETE FROM CIClaimDemand WHERE ");
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
        buffer.append("SELECT count(*) FROM CIClaimDemand WHERE ");
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
