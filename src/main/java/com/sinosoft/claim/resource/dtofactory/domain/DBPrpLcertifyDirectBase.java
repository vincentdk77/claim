package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcertifyDirect－索赔指引的数据访问对象基类<br>
 * 创建于 2006-06-20 15:15:26.875<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcertifyDirectBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLcertifyDirectBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertifyDirectBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcertifyDirect (");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getRegistNo()).append("',");
            debugBuffer.append("").append(prpLcertifyDirectDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getTypeCode()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getTypeName()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getColumnValue()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getCompelFlag()).append("',");
            debugBuffer.append("'").append(prpLcertifyDirectDto.getBusinessFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcertifyDirectDto.getRegistNo());
        dbManager.setInt(2,prpLcertifyDirectDto.getSerialNo());
        dbManager.setString(3,prpLcertifyDirectDto.getRiskCode());
        dbManager.setString(4,prpLcertifyDirectDto.getPolicyNo());
        dbManager.setString(5,prpLcertifyDirectDto.getLossItemCode());
        dbManager.setString(6,prpLcertifyDirectDto.getTypeCode());
        dbManager.setString(7,prpLcertifyDirectDto.getTypeName());
        dbManager.setString(8,prpLcertifyDirectDto.getColumnValue());
        dbManager.setString(9,prpLcertifyDirectDto.getFlag());
        dbManager.setString(10,prpLcertifyDirectDto.getCompelFlag());
        dbManager.setString(11,prpLcertifyDirectDto.getBusinessFlag());
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
        buffer.append("INSERT INTO PrpLcertifyDirect (");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)i.next();
            dbManager.setString(1,prpLcertifyDirectDto.getRegistNo());
            dbManager.setInt(2,prpLcertifyDirectDto.getSerialNo());
            dbManager.setString(3,prpLcertifyDirectDto.getRiskCode());
            dbManager.setString(4,prpLcertifyDirectDto.getPolicyNo());
            dbManager.setString(5,prpLcertifyDirectDto.getLossItemCode());
            dbManager.setString(6,prpLcertifyDirectDto.getTypeCode());
            dbManager.setString(7,prpLcertifyDirectDto.getTypeName());
            dbManager.setString(8,prpLcertifyDirectDto.getColumnValue());
            dbManager.setString(9,prpLcertifyDirectDto.getFlag());
            dbManager.setString(10,prpLcertifyDirectDto.getCompelFlag());
            dbManager.setString(11,prpLcertifyDirectDto.getBusinessFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcertifyDirect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void update(PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcertifyDirect SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("TypeCode = ?, ");
        buffer.append("TypeName = ?, ");
        buffer.append("ColumnValue = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("CompelFlag = ?, ");
        buffer.append("BusinessFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcertifyDirect SET ");
            debugBuffer.append("RiskCode = '" + prpLcertifyDirectDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLcertifyDirectDto.getPolicyNo() + "', ");
            debugBuffer.append("TypeCode = '" + prpLcertifyDirectDto.getTypeCode() + "', ");
            debugBuffer.append("TypeName = '" + prpLcertifyDirectDto.getTypeName() + "', ");
            debugBuffer.append("ColumnValue = '" + prpLcertifyDirectDto.getColumnValue() + "', ");
            debugBuffer.append("Flag = '" + prpLcertifyDirectDto.getFlag() + "', ");
            debugBuffer.append("CompelFlag = '" + prpLcertifyDirectDto.getCompelFlag() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLcertifyDirectDto.getBusinessFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLcertifyDirectDto.getRegistNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLcertifyDirectDto.getSerialNo()).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLcertifyDirectDto.getLossItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLcertifyDirectDto.getRiskCode());
        dbManager.setString(2,prpLcertifyDirectDto.getPolicyNo());
        dbManager.setString(3,prpLcertifyDirectDto.getTypeCode());
        dbManager.setString(4,prpLcertifyDirectDto.getTypeName());
        dbManager.setString(5,prpLcertifyDirectDto.getColumnValue());
        dbManager.setString(6,prpLcertifyDirectDto.getFlag());
        dbManager.setString(7,prpLcertifyDirectDto.getCompelFlag());
        dbManager.setString(8,prpLcertifyDirectDto.getBusinessFlag());
        //设置条件字段;
        dbManager.setString(9,prpLcertifyDirectDto.getRegistNo());
        dbManager.setInt(10,prpLcertifyDirectDto.getSerialNo());
        dbManager.setString(11,prpLcertifyDirectDto.getLossItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return PrpLcertifyDirectDto
     * @throws Exception
     */
    public PrpLcertifyDirectDto findByPrimaryKey(String registNo,int serialNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append("FROM PrpLcertifyDirect ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        if(resultSet.next()){
            prpLcertifyDirectDto = new PrpLcertifyDirectDto();
            prpLcertifyDirectDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcertifyDirectDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyDirectDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcertifyDirectDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcertifyDirectDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLcertifyDirectDto.setTypeCode(dbManager.getString(resultSet,6));
            prpLcertifyDirectDto.setTypeName(dbManager.getString(resultSet,7));
            prpLcertifyDirectDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcertifyDirectDto.setFlag(dbManager.getString(resultSet,9));
            prpLcertifyDirectDto.setCompelFlag(dbManager.getString(resultSet,10));
            prpLcertifyDirectDto.setBusinessFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpLcertifyDirectDto;
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
        buffer.append("RegistNo,");
        buffer.append("SerialNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("LossItemCode,");
        buffer.append("TypeCode,");
        buffer.append("TypeName,");
        buffer.append("ColumnValue,");
        buffer.append("Flag,");
        buffer.append("CompelFlag,");
        buffer.append("BusinessFlag ");
        buffer.append("FROM PrpLcertifyDirect WHERE ");
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
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcertifyDirectDto = new PrpLcertifyDirectDto();
            prpLcertifyDirectDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcertifyDirectDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyDirectDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcertifyDirectDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcertifyDirectDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLcertifyDirectDto.setTypeCode(dbManager.getString(resultSet,6));
            prpLcertifyDirectDto.setTypeName(dbManager.getString(resultSet,7));
            prpLcertifyDirectDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcertifyDirectDto.setFlag(dbManager.getString(resultSet,9));
            prpLcertifyDirectDto.setCompelFlag(dbManager.getString(resultSet,10));
            prpLcertifyDirectDto.setBusinessFlag(dbManager.getString(resultSet,11));
            collection.add(prpLcertifyDirectDto);
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
        buffer.append("DELETE FROM PrpLcertifyDirect WHERE ");
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
         String statement ;
          statement = "SELECT count(1) FROM PrpLcertifyDirect WHERE ";
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
