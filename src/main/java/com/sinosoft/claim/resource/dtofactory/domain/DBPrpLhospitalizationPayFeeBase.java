package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLhospitalizationPayFeeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLhospitalizationPayFee的数据访问对象基类<br>
 * 创建于 2007-05-23 14:10:25.882<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLhospitalizationPayFeeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLhospitalizationPayFeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLhospitalizationPayFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto
     * @throws Exception
     */
    public void insert(PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLhospitalizationPayFee (");
        buffer.append("compensateNo,");
        buffer.append("unitType,");
        buffer.append("serialNo,");
        buffer.append("feeType,");
        buffer.append("feeRate,");
        buffer.append("fee,");
        buffer.append("inputDate,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getUnitType()).append("',");
            debugBuffer.append("").append(prpLhospitalizationPayFeeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getFeeType()).append("',");
            debugBuffer.append("").append(prpLhospitalizationPayFeeDto.getFeeRate()).append(",");
            debugBuffer.append("").append(prpLhospitalizationPayFeeDto.getFee()).append(",");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLhospitalizationPayFeeDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLhospitalizationPayFeeDto.getCompensateNo());
        dbManager.setString(2,prpLhospitalizationPayFeeDto.getUnitType());
        dbManager.setLong(3,prpLhospitalizationPayFeeDto.getSerialNo());
        dbManager.setString(4,prpLhospitalizationPayFeeDto.getFeeType());
        dbManager.setDouble(5,prpLhospitalizationPayFeeDto.getFeeRate());
        dbManager.setDouble(6,prpLhospitalizationPayFeeDto.getFee());
        dbManager.setDateTime(7,prpLhospitalizationPayFeeDto.getInputDate());
        dbManager.setString(8,prpLhospitalizationPayFeeDto.getRemark());
        dbManager.setString(9,prpLhospitalizationPayFeeDto.getFlag());
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
        buffer.append("INSERT INTO PrpLhospitalizationPayFee (");
        buffer.append("compensateNo,");
        buffer.append("unitType,");
        buffer.append("serialNo,");
        buffer.append("feeType,");
        buffer.append("feeRate,");
        buffer.append("fee,");
        buffer.append("inputDate,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto = (PrpLhospitalizationPayFeeDto)i.next();
            dbManager.setString(1,prpLhospitalizationPayFeeDto.getCompensateNo());
            dbManager.setString(2,prpLhospitalizationPayFeeDto.getUnitType());
            dbManager.setLong(3,prpLhospitalizationPayFeeDto.getSerialNo());
            dbManager.setString(4,prpLhospitalizationPayFeeDto.getFeeType());
            dbManager.setDouble(5,prpLhospitalizationPayFeeDto.getFeeRate());
            dbManager.setDouble(6,prpLhospitalizationPayFeeDto.getFee());
            dbManager.setDateTime(7,prpLhospitalizationPayFeeDto.getInputDate());
            dbManager.setString(8,prpLhospitalizationPayFeeDto.getRemark());
            dbManager.setString(9,prpLhospitalizationPayFeeDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo compensateNo
     * @param unitType unitType
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String compensateNo,String unitType,long serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLhospitalizationPayFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("unitType=").append("'").append(unitType).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("unitType = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,unitType);
        dbManager.setLong(3,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto
     * @throws Exception
     */
    public void update(PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLhospitalizationPayFee SET ");
        buffer.append("feeType = ?, ");
        buffer.append("feeRate = ?, ");
        buffer.append("fee = ?, ");
        buffer.append("inputDate = ?, ");
        buffer.append("remark = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLhospitalizationPayFee SET ");
            debugBuffer.append("feeType = '" + prpLhospitalizationPayFeeDto.getFeeType() + "', ");
            debugBuffer.append("feeRate = " + prpLhospitalizationPayFeeDto.getFeeRate() + ", ");
            debugBuffer.append("fee = " + prpLhospitalizationPayFeeDto.getFee() + ", ");
            debugBuffer.append("inputDate = '" + prpLhospitalizationPayFeeDto.getInputDate() + "', ");
            debugBuffer.append("remark = '" + prpLhospitalizationPayFeeDto.getRemark() + "', ");
            debugBuffer.append("flag = '" + prpLhospitalizationPayFeeDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(prpLhospitalizationPayFeeDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("unitType=").append("'").append(prpLhospitalizationPayFeeDto.getUnitType()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpLhospitalizationPayFeeDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("unitType = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLhospitalizationPayFeeDto.getFeeType());
        dbManager.setDouble(2,prpLhospitalizationPayFeeDto.getFeeRate());
        dbManager.setDouble(3,prpLhospitalizationPayFeeDto.getFee());
        dbManager.setDateTime(4,prpLhospitalizationPayFeeDto.getInputDate());
        dbManager.setString(5,prpLhospitalizationPayFeeDto.getRemark());
        dbManager.setString(6,prpLhospitalizationPayFeeDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpLhospitalizationPayFeeDto.getCompensateNo());
        dbManager.setString(8,prpLhospitalizationPayFeeDto.getUnitType());
        dbManager.setLong(9,prpLhospitalizationPayFeeDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo compensateNo
     * @param unitType unitType
     * @param serialNo serialNo
     * @return PrpLhospitalizationPayFeeDto
     * @throws Exception
     */
    public PrpLhospitalizationPayFeeDto findByPrimaryKey(String compensateNo,String unitType,long serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("compensateNo,");
        buffer.append("unitType,");
        buffer.append("serialNo,");
        buffer.append("feeType,");
        buffer.append("feeRate,");
        buffer.append("fee,");
        buffer.append("inputDate,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpLhospitalizationPayFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("unitType=").append("'").append(unitType).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("unitType = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,unitType);
        dbManager.setLong(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto = null;
        if(resultSet.next()){
            prpLhospitalizationPayFeeDto = new PrpLhospitalizationPayFeeDto();
            prpLhospitalizationPayFeeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLhospitalizationPayFeeDto.setUnitType(dbManager.getString(resultSet,2));
            prpLhospitalizationPayFeeDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpLhospitalizationPayFeeDto.setFeeType(dbManager.getString(resultSet,4));
            prpLhospitalizationPayFeeDto.setFeeRate(dbManager.getDouble(resultSet,5));
            prpLhospitalizationPayFeeDto.setFee(dbManager.getDouble(resultSet,6));
            prpLhospitalizationPayFeeDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLhospitalizationPayFeeDto.setRemark(dbManager.getString(resultSet,8));
            prpLhospitalizationPayFeeDto.setFlag(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prpLhospitalizationPayFeeDto;
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
        buffer.append("compensateNo,");
        buffer.append("unitType,");
        buffer.append("serialNo,");
        buffer.append("feeType,");
        buffer.append("feeRate,");
        buffer.append("fee,");
        buffer.append("inputDate,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpLhospitalizationPayFee WHERE ");
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
        PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLhospitalizationPayFeeDto = new PrpLhospitalizationPayFeeDto();
            prpLhospitalizationPayFeeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLhospitalizationPayFeeDto.setUnitType(dbManager.getString(resultSet,2));
            prpLhospitalizationPayFeeDto.setSerialNo(dbManager.getLong(resultSet,3));
            prpLhospitalizationPayFeeDto.setFeeType(dbManager.getString(resultSet,4));
            prpLhospitalizationPayFeeDto.setFeeRate(dbManager.getDouble(resultSet,5));
            prpLhospitalizationPayFeeDto.setFee(dbManager.getDouble(resultSet,6));
            prpLhospitalizationPayFeeDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLhospitalizationPayFeeDto.setRemark(dbManager.getString(resultSet,8));
            prpLhospitalizationPayFeeDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpLhospitalizationPayFeeDto);
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
        buffer.append("DELETE FROM PrpLhospitalizationPayFee WHERE ");
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
  statement = "SELECT count(1) FROM PrpLhospitalizationPayFee WHERE ";
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
