package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemHouseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpCitemHouse的数据访问对象基类<br>
 * 创建于 2006-04-30 14:20:10.171<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemHouseBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCitemHouseBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemHouseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCitemHouseDto prpCitemHouseDto
     * @throws Exception
     */
    public void insert(PrpCitemHouseDto prpCitemHouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCitemHouse (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCitemHouseDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getItemNo()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getStructure()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getBuildArea()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getFlag()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getUnitValue()).append(",");
            debugBuffer.append("").append(prpCitemHouseDto.getSumValue()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getBuildTime()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getUseAge()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCitemHouseDto.getPolicyNo());
        dbManager.setString(2,prpCitemHouseDto.getRiskCode());
        dbManager.setLong(3,prpCitemHouseDto.getItemNo());
        dbManager.setString(4,prpCitemHouseDto.getStructure());
        dbManager.setDouble(5,prpCitemHouseDto.getBuildArea());
        dbManager.setString(6,prpCitemHouseDto.getRemark());
        dbManager.setString(7,prpCitemHouseDto.getFlag());
        dbManager.setDouble(8,prpCitemHouseDto.getUnitValue());
        dbManager.setDouble(9,prpCitemHouseDto.getSumValue());
        dbManager.setDateTime(10,prpCitemHouseDto.getBuildTime());
        dbManager.setString(11,prpCitemHouseDto.getUseAge());
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
        buffer.append("INSERT INTO PrpCitemHouse (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCitemHouseDto prpCitemHouseDto = (PrpCitemHouseDto)i.next();
            dbManager.setString(1,prpCitemHouseDto.getPolicyNo());
            dbManager.setString(2,prpCitemHouseDto.getRiskCode());
            dbManager.setLong(3,prpCitemHouseDto.getItemNo());
            dbManager.setString(4,prpCitemHouseDto.getStructure());
            dbManager.setDouble(5,prpCitemHouseDto.getBuildArea());
            dbManager.setString(6,prpCitemHouseDto.getRemark());
            dbManager.setString(7,prpCitemHouseDto.getFlag());
            dbManager.setDouble(8,prpCitemHouseDto.getUnitValue());
            dbManager.setDouble(9,prpCitemHouseDto.getSumValue());
            dbManager.setDateTime(10,prpCitemHouseDto.getBuildTime());
            dbManager.setString(11,prpCitemHouseDto.getUseAge());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param policyNo PolicyNo
     * @param itemNo ItemNo
     * @throws Exception
     */
    public void delete(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCitemHouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCitemHouseDto prpCitemHouseDto
     * @throws Exception
     */
    public void update(PrpCitemHouseDto prpCitemHouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCitemHouse SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("Structure = ?, ");
        buffer.append("BuildArea = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("UnitValue = ?, ");
        buffer.append("SumValue = ?, ");
        buffer.append("BuildTime = ?, ");
        buffer.append("UseAge = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCitemHouse SET ");
            debugBuffer.append("RiskCode = '" + prpCitemHouseDto.getRiskCode() + "', ");
            debugBuffer.append("Structure = '" + prpCitemHouseDto.getStructure() + "', ");
            debugBuffer.append("BuildArea = " + prpCitemHouseDto.getBuildArea() + ", ");
            debugBuffer.append("Remark = '" + prpCitemHouseDto.getRemark() + "', ");
            debugBuffer.append("flag = '" + prpCitemHouseDto.getFlag() + "', ");
            debugBuffer.append("UnitValue = " + prpCitemHouseDto.getUnitValue() + ", ");
            debugBuffer.append("SumValue = " + prpCitemHouseDto.getSumValue() + ", ");
            debugBuffer.append("BuildTime = '" + prpCitemHouseDto.getBuildTime() + "', ");
            debugBuffer.append("UseAge = '" + prpCitemHouseDto.getUseAge() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCitemHouseDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(prpCitemHouseDto.getItemNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpCitemHouseDto.getRiskCode());
        dbManager.setString(2,prpCitemHouseDto.getStructure());
        dbManager.setDouble(3,prpCitemHouseDto.getBuildArea());
        dbManager.setString(4,prpCitemHouseDto.getRemark());
        dbManager.setString(5,prpCitemHouseDto.getFlag());
        dbManager.setDouble(6,prpCitemHouseDto.getUnitValue());
        dbManager.setDouble(7,prpCitemHouseDto.getSumValue());
        dbManager.setDateTime(8,prpCitemHouseDto.getBuildTime());
        dbManager.setString(9,prpCitemHouseDto.getUseAge());
        //设置条件字段;
        dbManager.setString(10,prpCitemHouseDto.getPolicyNo());
        dbManager.setLong(11,prpCitemHouseDto.getItemNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param policyNo PolicyNo
     * @param itemNo ItemNo
     * @return PrpCitemHouseDto
     * @throws Exception
     */
    public PrpCitemHouseDto findByPrimaryKey(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append("FROM PrpCitemHouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCitemHouseDto prpCitemHouseDto = null;
        if(resultSet.next()){
            prpCitemHouseDto = new PrpCitemHouseDto();
            prpCitemHouseDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemHouseDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemHouseDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemHouseDto.setStructure(dbManager.getString(resultSet,4));
            prpCitemHouseDto.setBuildArea(dbManager.getDouble(resultSet,5));
            prpCitemHouseDto.setRemark(dbManager.getString(resultSet,6));
            prpCitemHouseDto.setFlag(dbManager.getString(resultSet,7));
            prpCitemHouseDto.setUnitValue(dbManager.getDouble(resultSet,8));
            prpCitemHouseDto.setSumValue(dbManager.getDouble(resultSet,9));
            prpCitemHouseDto.setBuildTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpCitemHouseDto.setUseAge(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpCitemHouseDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append("FROM PrpCitemHouse WHERE ");
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
        PrpCitemHouseDto prpCitemHouseDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCitemHouseDto = new PrpCitemHouseDto();
            prpCitemHouseDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemHouseDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemHouseDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemHouseDto.setStructure(dbManager.getString(resultSet,4));
            prpCitemHouseDto.setBuildArea(dbManager.getDouble(resultSet,5));
            prpCitemHouseDto.setRemark(dbManager.getString(resultSet,6));
            prpCitemHouseDto.setFlag(dbManager.getString(resultSet,7));
            prpCitemHouseDto.setUnitValue(dbManager.getDouble(resultSet,8));
            prpCitemHouseDto.setSumValue(dbManager.getDouble(resultSet,9));
            prpCitemHouseDto.setBuildTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpCitemHouseDto.setUseAge(dbManager.getString(resultSet,11));
            collection.add(prpCitemHouseDto);
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
        buffer.append("DELETE FROM PrpCitemHouse WHERE ");
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
        statement="SELECT count(1) FROM PrpCitemHouse WHERE ";
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
