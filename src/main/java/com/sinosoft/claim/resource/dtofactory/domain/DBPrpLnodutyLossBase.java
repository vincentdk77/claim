package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLnodutyLoss的数据访问对象基类<br>
 * 创建于 2008-01-28 10:57:22.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLnodutyLossBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLnodutyLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLnodutyLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLnodutyLossDto prpLnodutyLossDto
     * @throws Exception
     */
    public void insert(PrpLnodutyLossDto prpLnodutyLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLnodutyLoss (");
        buffer.append("compensateNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("kindCode,");
        buffer.append("licenseNo,");
        buffer.append("insuredName,");
        buffer.append("driverLicenseNo,");
        buffer.append("insuredCompanyCode,");
        buffer.append("insuredCompanyName,");
        buffer.append("dutyPercent,");
        buffer.append("paidType,");
        buffer.append("paidName,");
        buffer.append("currency,");
        buffer.append("verifyPaid,");
        buffer.append("limitPaid,");
        buffer.append("realPaid,");
        buffer.append("dutyType,");
        buffer.append("replaceFlag,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLnodutyLossDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpLnodutyLossDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLnodutyLossDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getDriverLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getInsuredCompanyCode()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getInsuredCompanyName()).append("',");
            debugBuffer.append("").append(prpLnodutyLossDto.getDutyPercent()).append(",");
            debugBuffer.append("'").append(prpLnodutyLossDto.getPaidType()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getPaidName()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLnodutyLossDto.getVerifyPaid()).append(",");
            debugBuffer.append("").append(prpLnodutyLossDto.getLimitPaid()).append(",");
            debugBuffer.append("").append(prpLnodutyLossDto.getRealPaid()).append(",");
            debugBuffer.append("'").append(prpLnodutyLossDto.getDutyType()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getReplaceFlag()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLnodutyLossDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLnodutyLossDto.getCompensateNo());
        dbManager.setString(2,prpLnodutyLossDto.getRiskCode());
        dbManager.setString(3,prpLnodutyLossDto.getPolicyNo());
        dbManager.setInt(4,prpLnodutyLossDto.getSerialNo());
        dbManager.setString(5,prpLnodutyLossDto.getKindCode());
        dbManager.setString(6,prpLnodutyLossDto.getLicenseNo());
        dbManager.setString(7,prpLnodutyLossDto.getInsuredName());
        dbManager.setString(8,prpLnodutyLossDto.getDriverLicenseNo());
        dbManager.setString(9,prpLnodutyLossDto.getInsuredCompanyCode());
        dbManager.setString(10,prpLnodutyLossDto.getInsuredCompanyName());
        dbManager.setDouble(11,prpLnodutyLossDto.getDutyPercent());
        dbManager.setString(12,prpLnodutyLossDto.getPaidType());
        dbManager.setString(13,prpLnodutyLossDto.getPaidName());
        dbManager.setString(14,prpLnodutyLossDto.getCurrency());
        dbManager.setDouble(15,prpLnodutyLossDto.getVerifyPaid());
        dbManager.setDouble(16,prpLnodutyLossDto.getLimitPaid());
        dbManager.setDouble(17,prpLnodutyLossDto.getRealPaid());
        dbManager.setString(18,prpLnodutyLossDto.getDutyType());
        dbManager.setString(19,prpLnodutyLossDto.getReplaceFlag());
        dbManager.setString(20,prpLnodutyLossDto.getRemark());
        dbManager.setString(21,prpLnodutyLossDto.getFlag());
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
        buffer.append("INSERT INTO PrpLnodutyLoss (");
        buffer.append("compensateNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("kindCode,");
        buffer.append("licenseNo,");
        buffer.append("insuredName,");
        buffer.append("driverLicenseNo,");
        buffer.append("insuredCompanyCode,");
        buffer.append("insuredCompanyName,");
        buffer.append("dutyPercent,");
        buffer.append("paidType,");
        buffer.append("paidName,");
        buffer.append("currency,");
        buffer.append("verifyPaid,");
        buffer.append("limitPaid,");
        buffer.append("realPaid,");
        buffer.append("dutyType,");
        buffer.append("replaceFlag,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)i.next();
            dbManager.setString(1,prpLnodutyLossDto.getCompensateNo());
            dbManager.setString(2,prpLnodutyLossDto.getRiskCode());
            dbManager.setString(3,prpLnodutyLossDto.getPolicyNo());
            dbManager.setInt(4,prpLnodutyLossDto.getSerialNo());
            dbManager.setString(5,prpLnodutyLossDto.getKindCode());
            dbManager.setString(6,prpLnodutyLossDto.getLicenseNo());
            dbManager.setString(7,prpLnodutyLossDto.getInsuredName());
            dbManager.setString(8,prpLnodutyLossDto.getDriverLicenseNo());
            dbManager.setString(9,prpLnodutyLossDto.getInsuredCompanyCode());
            dbManager.setString(10,prpLnodutyLossDto.getInsuredCompanyName());
            dbManager.setDouble(11,prpLnodutyLossDto.getDutyPercent());
            dbManager.setString(12,prpLnodutyLossDto.getPaidType());
            dbManager.setString(13,prpLnodutyLossDto.getPaidName());
            dbManager.setString(14,prpLnodutyLossDto.getCurrency());
            dbManager.setDouble(15,prpLnodutyLossDto.getVerifyPaid());
            dbManager.setDouble(16,prpLnodutyLossDto.getLimitPaid());
            dbManager.setDouble(17,prpLnodutyLossDto.getRealPaid());
            dbManager.setString(18,prpLnodutyLossDto.getDutyType());
            dbManager.setString(19,prpLnodutyLossDto.getReplaceFlag());
            dbManager.setString(20,prpLnodutyLossDto.getRemark());
            dbManager.setString(21,prpLnodutyLossDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLnodutyLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLnodutyLossDto prpLnodutyLossDto
     * @throws Exception
     */
    public void update(PrpLnodutyLossDto prpLnodutyLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLnodutyLoss SET ");
        buffer.append("riskCode = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("kindCode = ?, ");
        buffer.append("licenseNo = ?, ");
        buffer.append("insuredName = ?, ");
        buffer.append("driverLicenseNo = ?, ");
        buffer.append("insuredCompanyCode = ?, ");
        buffer.append("insuredCompanyName = ?, ");
        buffer.append("dutyPercent = ?, ");
        buffer.append("paidType = ?, ");
        buffer.append("paidName = ?, ");
        buffer.append("currency = ?, ");
        buffer.append("verifyPaid = ?, ");
        buffer.append("limitPaid = ?, ");
        buffer.append("realPaid = ?, ");
        buffer.append("dutyType = ?, ");
        buffer.append("replaceFlag = ?, ");
        buffer.append("remark = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLnodutyLoss SET ");
            debugBuffer.append("riskCode = '" + prpLnodutyLossDto.getRiskCode() + "', ");
            debugBuffer.append("policyNo = '" + prpLnodutyLossDto.getPolicyNo() + "', ");
            debugBuffer.append("kindCode = '" + prpLnodutyLossDto.getKindCode() + "', ");
            debugBuffer.append("licenseNo = '" + prpLnodutyLossDto.getLicenseNo() + "', ");
            debugBuffer.append("insuredName = '" + prpLnodutyLossDto.getInsuredName() + "', ");
            debugBuffer.append("driverLicenseNo = '" + prpLnodutyLossDto.getDriverLicenseNo() + "', ");
            debugBuffer.append("insuredCompanyCode = '" + prpLnodutyLossDto.getInsuredCompanyCode() + "', ");
            debugBuffer.append("insuredCompanyName = '" + prpLnodutyLossDto.getInsuredCompanyName() + "', ");
            debugBuffer.append("dutyPercent = " + prpLnodutyLossDto.getDutyPercent() + ", ");
            debugBuffer.append("paidType = '" + prpLnodutyLossDto.getPaidType() + "', ");
            debugBuffer.append("paidName = '" + prpLnodutyLossDto.getPaidName() + "', ");
            debugBuffer.append("currency = '" + prpLnodutyLossDto.getCurrency() + "', ");
            debugBuffer.append("verifyPaid = " + prpLnodutyLossDto.getVerifyPaid() + ", ");
            debugBuffer.append("limitPaid = " + prpLnodutyLossDto.getLimitPaid() + ", ");
            debugBuffer.append("realPaid = " + prpLnodutyLossDto.getRealPaid() + ", ");
            debugBuffer.append("dutyType = '" + prpLnodutyLossDto.getDutyType() + "', ");
            debugBuffer.append("replaceFlag = '" + prpLnodutyLossDto.getReplaceFlag() + "', ");
            debugBuffer.append("remark = '" + prpLnodutyLossDto.getRemark() + "', ");
            debugBuffer.append("flag = '" + prpLnodutyLossDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(prpLnodutyLossDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpLnodutyLossDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLnodutyLossDto.getRiskCode());
        dbManager.setString(2,prpLnodutyLossDto.getPolicyNo());
        dbManager.setString(3,prpLnodutyLossDto.getKindCode());
        dbManager.setString(4,prpLnodutyLossDto.getLicenseNo());
        dbManager.setString(5,prpLnodutyLossDto.getInsuredName());
        dbManager.setString(6,prpLnodutyLossDto.getDriverLicenseNo());
        dbManager.setString(7,prpLnodutyLossDto.getInsuredCompanyCode());
        dbManager.setString(8,prpLnodutyLossDto.getInsuredCompanyName());
        dbManager.setDouble(9,prpLnodutyLossDto.getDutyPercent());
        dbManager.setString(10,prpLnodutyLossDto.getPaidType());
        dbManager.setString(11,prpLnodutyLossDto.getPaidName());
        dbManager.setString(12,prpLnodutyLossDto.getCurrency());
        dbManager.setDouble(13,prpLnodutyLossDto.getVerifyPaid());
        dbManager.setDouble(14,prpLnodutyLossDto.getLimitPaid());
        dbManager.setDouble(15,prpLnodutyLossDto.getRealPaid());
        dbManager.setString(16,prpLnodutyLossDto.getDutyType());
        dbManager.setString(17,prpLnodutyLossDto.getReplaceFlag());
        dbManager.setString(18,prpLnodutyLossDto.getRemark());
        dbManager.setString(19,prpLnodutyLossDto.getFlag());
        //设置条件字段;
        dbManager.setString(20,prpLnodutyLossDto.getCompensateNo());
        dbManager.setInt(21,prpLnodutyLossDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return PrpLnodutyLossDto
     * @throws Exception
     */
    public PrpLnodutyLossDto findByPrimaryKey(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("compensateNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("kindCode,");
        buffer.append("licenseNo,");
        buffer.append("insuredName,");
        buffer.append("driverLicenseNo,");
        buffer.append("insuredCompanyCode,");
        buffer.append("insuredCompanyName,");
        buffer.append("dutyPercent,");
        buffer.append("paidType,");
        buffer.append("paidName,");
        buffer.append("currency,");
        buffer.append("verifyPaid,");
        buffer.append("limitPaid,");
        buffer.append("realPaid,");
        buffer.append("dutyType,");
        buffer.append("replaceFlag,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpLnodutyLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLnodutyLossDto prpLnodutyLossDto = null;
        if(resultSet.next()){
            prpLnodutyLossDto = new PrpLnodutyLossDto();
            prpLnodutyLossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLnodutyLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLnodutyLossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLnodutyLossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLnodutyLossDto.setKindCode(dbManager.getString(resultSet,5));
            prpLnodutyLossDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLnodutyLossDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLnodutyLossDto.setDriverLicenseNo(dbManager.getString(resultSet,8));
            prpLnodutyLossDto.setInsuredCompanyCode(dbManager.getString(resultSet,9));
            prpLnodutyLossDto.setInsuredCompanyName(dbManager.getString(resultSet,10));
            prpLnodutyLossDto.setDutyPercent(dbManager.getDouble(resultSet,11));
            prpLnodutyLossDto.setPaidType(dbManager.getString(resultSet,12));
            prpLnodutyLossDto.setPaidName(dbManager.getString(resultSet,13));
            prpLnodutyLossDto.setCurrency(dbManager.getString(resultSet,14));
            prpLnodutyLossDto.setVerifyPaid(dbManager.getDouble(resultSet,15));
            prpLnodutyLossDto.setLimitPaid(dbManager.getDouble(resultSet,16));
            prpLnodutyLossDto.setRealPaid(dbManager.getDouble(resultSet,17));
            prpLnodutyLossDto.setDutyType(dbManager.getString(resultSet,18));
            prpLnodutyLossDto.setReplaceFlag(dbManager.getString(resultSet,19));
            prpLnodutyLossDto.setRemark(dbManager.getString(resultSet,20));
            prpLnodutyLossDto.setFlag(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        return prpLnodutyLossDto;
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
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("kindCode,");
        buffer.append("licenseNo,");
        buffer.append("insuredName,");
        buffer.append("driverLicenseNo,");
        buffer.append("insuredCompanyCode,");
        buffer.append("insuredCompanyName,");
        buffer.append("dutyPercent,");
        buffer.append("paidType,");
        buffer.append("paidName,");
        buffer.append("currency,");
        buffer.append("verifyPaid,");
        buffer.append("limitPaid,");
        buffer.append("realPaid,");
        buffer.append("dutyType,");
        buffer.append("replaceFlag,");
        buffer.append("remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpLnodutyLoss WHERE ");
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
        PrpLnodutyLossDto prpLnodutyLossDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLnodutyLossDto = new PrpLnodutyLossDto();
            prpLnodutyLossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLnodutyLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLnodutyLossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLnodutyLossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLnodutyLossDto.setKindCode(dbManager.getString(resultSet,5));
            prpLnodutyLossDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLnodutyLossDto.setInsuredName(dbManager.getString(resultSet,7));
            prpLnodutyLossDto.setDriverLicenseNo(dbManager.getString(resultSet,8));
            prpLnodutyLossDto.setInsuredCompanyCode(dbManager.getString(resultSet,9));
            prpLnodutyLossDto.setInsuredCompanyName(dbManager.getString(resultSet,10));
            prpLnodutyLossDto.setDutyPercent(dbManager.getDouble(resultSet,11));
            prpLnodutyLossDto.setPaidType(dbManager.getString(resultSet,12));
            prpLnodutyLossDto.setPaidName(dbManager.getString(resultSet,13));
            prpLnodutyLossDto.setCurrency(dbManager.getString(resultSet,14));
            prpLnodutyLossDto.setVerifyPaid(dbManager.getDouble(resultSet,15));
            prpLnodutyLossDto.setLimitPaid(dbManager.getDouble(resultSet,16));
            prpLnodutyLossDto.setRealPaid(dbManager.getDouble(resultSet,17));
            prpLnodutyLossDto.setDutyType(dbManager.getString(resultSet,18));
            prpLnodutyLossDto.setReplaceFlag(dbManager.getString(resultSet,19));
            prpLnodutyLossDto.setRemark(dbManager.getString(resultSet,20));
            prpLnodutyLossDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpLnodutyLossDto);
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
        buffer.append("DELETE FROM PrpLnodutyLoss WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLnodutyLoss WHERE ");
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
