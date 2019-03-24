package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcheck－查勘/代查勘信息表的数据访问对象基类<br>
 * 创建于 2006-03-16 11:05:19.453<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcheckBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLcheckBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcheckBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void insert(PrpLcheckDto prpLcheckDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcheck (");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckSite,");
        buffer.append("FirstSiteFlag,");
        buffer.append("ClaimType,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("ReferKind,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAddressType,");
        buffer.append("IndemnityDuty,");
        buffer.append("ClaimFlag,");
        buffer.append("Checker1,");
        buffer.append("Checker2,");
        buffer.append("CheckUnitName,");
        buffer.append("HandleUnit,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("ReferSerialNo,");
        buffer.append("InsureCarFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("HandleUnitCode,");
        buffer.append("UnitType,");
        buffer.append("EstimateFee,");
        buffer.append("EstimateLoss,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageAddress,");
        buffer.append("CheckLinker ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcheckDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckType()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckNature()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckDate()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckSite()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getFirstSiteFlag()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getClaimType()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getReferKind()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageAreaCode()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageAddressType()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getIndemnityDuty()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getClaimFlag()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getChecker1()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getChecker2()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckUnitName()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getHandleUnit()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getFlag()).append("',");
            debugBuffer.append("").append(prpLcheckDto.getReferSerialNo()).append(",");
            debugBuffer.append("'").append(prpLcheckDto.getInsureCarFlag()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getRepeatInsureFlag()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getHandleUnitCode()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getUnitType()).append("',");
            debugBuffer.append("").append(prpLcheckDto.getEstimateFee()).append(",");
            debugBuffer.append("").append(prpLcheckDto.getEstimateLoss()).append(",");
            debugBuffer.append("'").append(prpLcheckDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLcheckDto.getCheckLinker()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcheckDto.getRegistNo());
        dbManager.setString(2,prpLcheckDto.getClaimNo());
        dbManager.setString(3,prpLcheckDto.getRiskCode());
        dbManager.setString(4,prpLcheckDto.getPolicyNo());
        dbManager.setString(5,prpLcheckDto.getCheckType());
        dbManager.setString(6,prpLcheckDto.getCheckNature());
        dbManager.setDateTime(7,prpLcheckDto.getCheckDate());
        dbManager.setString(8,prpLcheckDto.getCheckSite());
        dbManager.setString(9,prpLcheckDto.getFirstSiteFlag());
        dbManager.setString(10,prpLcheckDto.getClaimType());
        dbManager.setString(11,prpLcheckDto.getDamageCode());
        dbManager.setString(12,prpLcheckDto.getDamageName());
        dbManager.setString(13,prpLcheckDto.getDamageTypeCode());
        dbManager.setString(14,prpLcheckDto.getDamageTypeName());
        dbManager.setString(15,prpLcheckDto.getReferKind());
        dbManager.setString(16,prpLcheckDto.getDamageAreaCode());
        dbManager.setString(17,prpLcheckDto.getDamageAddressType());
        dbManager.setString(18,prpLcheckDto.getIndemnityDuty());
        dbManager.setString(19,prpLcheckDto.getClaimFlag());
        dbManager.setString(20,prpLcheckDto.getChecker1());
        dbManager.setString(21,prpLcheckDto.getChecker2());
        dbManager.setString(22,prpLcheckDto.getCheckUnitName());
        dbManager.setString(23,prpLcheckDto.getHandleUnit());
        dbManager.setString(24,prpLcheckDto.getRemark());
        dbManager.setString(25,prpLcheckDto.getFlag());
        dbManager.setInt(26,prpLcheckDto.getReferSerialNo());
        dbManager.setString(27,prpLcheckDto.getInsureCarFlag());
        dbManager.setString(28,prpLcheckDto.getRepeatInsureFlag());
        dbManager.setString(29,prpLcheckDto.getHandleUnitCode());
        dbManager.setString(30,prpLcheckDto.getUnitType());
        dbManager.setDouble(31,prpLcheckDto.getEstimateFee());
        dbManager.setDouble(32,prpLcheckDto.getEstimateLoss());
        dbManager.setDateTime(33,prpLcheckDto.getDamageStartDate());
        dbManager.setString(34,prpLcheckDto.getDamageStartHour());
        dbManager.setString(35,prpLcheckDto.getDamageAddress());
        dbManager.setString(36,prpLcheckDto.getCheckLinker());
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
        buffer.append("INSERT INTO PrpLcheck (");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckSite,");
        buffer.append("FirstSiteFlag,");
        buffer.append("ClaimType,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("ReferKind,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAddressType,");
        buffer.append("IndemnityDuty,");
        buffer.append("ClaimFlag,");
        buffer.append("Checker1,");
        buffer.append("Checker2,");
        buffer.append("CheckUnitName,");
        buffer.append("HandleUnit,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("ReferSerialNo,");
        buffer.append("InsureCarFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("HandleUnitCode,");
        buffer.append("UnitType,");
        buffer.append("EstimateFee,");
        buffer.append("EstimateLoss,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageAddress,");
        buffer.append("CheckLinker ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcheckDto prpLcheckDto = (PrpLcheckDto)i.next();
            dbManager.setString(1,prpLcheckDto.getRegistNo());
            dbManager.setString(2,prpLcheckDto.getClaimNo());
            dbManager.setString(3,prpLcheckDto.getRiskCode());
            dbManager.setString(4,prpLcheckDto.getPolicyNo());
            dbManager.setString(5,prpLcheckDto.getCheckType());
            dbManager.setString(6,prpLcheckDto.getCheckNature());
            dbManager.setDateTime(7,prpLcheckDto.getCheckDate());
            dbManager.setString(8,prpLcheckDto.getCheckSite());
            dbManager.setString(9,prpLcheckDto.getFirstSiteFlag());
            dbManager.setString(10,prpLcheckDto.getClaimType());
            dbManager.setString(11,prpLcheckDto.getDamageCode());
            dbManager.setString(12,prpLcheckDto.getDamageName());
            dbManager.setString(13,prpLcheckDto.getDamageTypeCode());
            dbManager.setString(14,prpLcheckDto.getDamageTypeName());
            dbManager.setString(15,prpLcheckDto.getReferKind());
            dbManager.setString(16,prpLcheckDto.getDamageAreaCode());
            dbManager.setString(17,prpLcheckDto.getDamageAddressType());
            dbManager.setString(18,prpLcheckDto.getIndemnityDuty());
            dbManager.setString(19,prpLcheckDto.getClaimFlag());
            dbManager.setString(20,prpLcheckDto.getChecker1());
            dbManager.setString(21,prpLcheckDto.getChecker2());
            dbManager.setString(22,prpLcheckDto.getCheckUnitName());
            dbManager.setString(23,prpLcheckDto.getHandleUnit());
            dbManager.setString(24,prpLcheckDto.getRemark());
            dbManager.setString(25,prpLcheckDto.getFlag());
            dbManager.setInt(26,prpLcheckDto.getReferSerialNo());
            dbManager.setString(27,prpLcheckDto.getInsureCarFlag());
            dbManager.setString(28,prpLcheckDto.getRepeatInsureFlag());
            dbManager.setString(29,prpLcheckDto.getHandleUnitCode());
            dbManager.setString(30,prpLcheckDto.getUnitType());
            dbManager.setDouble(31,prpLcheckDto.getEstimateFee());
            dbManager.setDouble(32,prpLcheckDto.getEstimateLoss());
            dbManager.setDateTime(33,prpLcheckDto.getDamageStartDate());
            dbManager.setString(34,prpLcheckDto.getDamageStartHour());
            dbManager.setString(35,prpLcheckDto.getDamageAddress());
            dbManager.setString(36,prpLcheckDto.getCheckLinker());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param referSerialNo 关联理赔车辆序号
     * @throws Exception
     */
    public void delete(String registNo,int referSerialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcheck ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("ReferSerialNo=").append("").append(referSerialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("ReferSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,referSerialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void update(PrpLcheckDto prpLcheckDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcheck SET ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("CheckType = ?, ");
        buffer.append("CheckNature = ?, ");
        buffer.append("CheckDate = ?, ");
        buffer.append("CheckSite = ?, ");
        buffer.append("FirstSiteFlag = ?, ");
        buffer.append("ClaimType = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("DamageName = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("DamageTypeName = ?, ");
        buffer.append("ReferKind = ?, ");
        buffer.append("DamageAreaCode = ?, ");
        buffer.append("DamageAddressType = ?, ");
        buffer.append("IndemnityDuty = ?, ");
        buffer.append("ClaimFlag = ?, ");
        buffer.append("Checker1 = ?, ");
        buffer.append("Checker2 = ?, ");
        buffer.append("CheckUnitName = ?, ");
        buffer.append("HandleUnit = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("InsureCarFlag = ?, ");
        buffer.append("RepeatInsureFlag = ?, ");
        buffer.append("HandleUnitCode = ?, ");
        buffer.append("UnitType = ?, ");
        buffer.append("EstimateFee = ?, ");
        buffer.append("EstimateLoss = ?, ");
        buffer.append("DamageStartDate = ?, ");
        buffer.append("DamageStartHour = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("CheckLinker = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcheck SET ");
            debugBuffer.append("ClaimNo = '" + prpLcheckDto.getClaimNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLcheckDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLcheckDto.getPolicyNo() + "', ");
            debugBuffer.append("CheckType = '" + prpLcheckDto.getCheckType() + "', ");
            debugBuffer.append("CheckNature = '" + prpLcheckDto.getCheckNature() + "', ");
            debugBuffer.append("CheckDate = '" + prpLcheckDto.getCheckDate() + "', ");
            debugBuffer.append("CheckSite = '" + prpLcheckDto.getCheckSite() + "', ");
            debugBuffer.append("FirstSiteFlag = '" + prpLcheckDto.getFirstSiteFlag() + "', ");
            debugBuffer.append("ClaimType = '" + prpLcheckDto.getClaimType() + "', ");
            debugBuffer.append("DamageCode = '" + prpLcheckDto.getDamageCode() + "', ");
            debugBuffer.append("DamageName = '" + prpLcheckDto.getDamageName() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLcheckDto.getDamageTypeCode() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLcheckDto.getDamageTypeName() + "', ");
            debugBuffer.append("ReferKind = '" + prpLcheckDto.getReferKind() + "', ");
            debugBuffer.append("DamageAreaCode = '" + prpLcheckDto.getDamageAreaCode() + "', ");
            debugBuffer.append("DamageAddressType = '" + prpLcheckDto.getDamageAddressType() + "', ");
            debugBuffer.append("IndemnityDuty = '" + prpLcheckDto.getIndemnityDuty() + "', ");
            debugBuffer.append("ClaimFlag = '" + prpLcheckDto.getClaimFlag() + "', ");
            debugBuffer.append("Checker1 = '" + prpLcheckDto.getChecker1() + "', ");
            debugBuffer.append("Checker2 = '" + prpLcheckDto.getChecker2() + "', ");
            debugBuffer.append("CheckUnitName = '" + prpLcheckDto.getCheckUnitName() + "', ");
            debugBuffer.append("HandleUnit = '" + prpLcheckDto.getHandleUnit() + "', ");
            debugBuffer.append("Remark = '" + prpLcheckDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + prpLcheckDto.getFlag() + "', ");
            debugBuffer.append("InsureCarFlag = '" + prpLcheckDto.getInsureCarFlag() + "', ");
            debugBuffer.append("RepeatInsureFlag = '" + prpLcheckDto.getRepeatInsureFlag() + "', ");
            debugBuffer.append("HandleUnitCode = '" + prpLcheckDto.getHandleUnitCode() + "', ");
            debugBuffer.append("UnitType = '" + prpLcheckDto.getUnitType() + "', ");
            debugBuffer.append("EstimateFee = " + prpLcheckDto.getEstimateFee() + ", ");
            debugBuffer.append("EstimateLoss = " + prpLcheckDto.getEstimateLoss() + ", ");
            debugBuffer.append("DamageStartDate = '" + prpLcheckDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLcheckDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLcheckDto.getDamageAddress() + "', ");
            debugBuffer.append("CheckLinker = '" + prpLcheckDto.getCheckLinker() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLcheckDto.getRegistNo()).append("' AND ");
            debugBuffer.append("ReferSerialNo=").append("").append(prpLcheckDto.getReferSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("ReferSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLcheckDto.getClaimNo());
        dbManager.setString(2,prpLcheckDto.getRiskCode());
        dbManager.setString(3,prpLcheckDto.getPolicyNo());
        dbManager.setString(4,prpLcheckDto.getCheckType());
        dbManager.setString(5,prpLcheckDto.getCheckNature());
        dbManager.setDateTime(6,prpLcheckDto.getCheckDate());
        dbManager.setString(7,prpLcheckDto.getCheckSite());
        dbManager.setString(8,prpLcheckDto.getFirstSiteFlag());
        dbManager.setString(9,prpLcheckDto.getClaimType());
        dbManager.setString(10,prpLcheckDto.getDamageCode());
        dbManager.setString(11,prpLcheckDto.getDamageName());
        dbManager.setString(12,prpLcheckDto.getDamageTypeCode());
        dbManager.setString(13,prpLcheckDto.getDamageTypeName());
        dbManager.setString(14,prpLcheckDto.getReferKind());
        dbManager.setString(15,prpLcheckDto.getDamageAreaCode());
        dbManager.setString(16,prpLcheckDto.getDamageAddressType());
        dbManager.setString(17,prpLcheckDto.getIndemnityDuty());
        dbManager.setString(18,prpLcheckDto.getClaimFlag());
        dbManager.setString(19,prpLcheckDto.getChecker1());
        dbManager.setString(20,prpLcheckDto.getChecker2());
        dbManager.setString(21,prpLcheckDto.getCheckUnitName());
        dbManager.setString(22,prpLcheckDto.getHandleUnit());
        dbManager.setString(23,prpLcheckDto.getRemark());
        dbManager.setString(24,prpLcheckDto.getFlag());
        dbManager.setString(25,prpLcheckDto.getInsureCarFlag());
        dbManager.setString(26,prpLcheckDto.getRepeatInsureFlag());
        dbManager.setString(27,prpLcheckDto.getHandleUnitCode());
        dbManager.setString(28,prpLcheckDto.getUnitType());
        dbManager.setDouble(29,prpLcheckDto.getEstimateFee());
        dbManager.setDouble(30,prpLcheckDto.getEstimateLoss());
        dbManager.setDateTime(31,prpLcheckDto.getDamageStartDate());
        dbManager.setString(32,prpLcheckDto.getDamageStartHour());
        dbManager.setString(33,prpLcheckDto.getDamageAddress());
        dbManager.setString(34,prpLcheckDto.getCheckLinker());
        //设置条件字段;
        dbManager.setString(35,prpLcheckDto.getRegistNo());
        dbManager.setInt(36,prpLcheckDto.getReferSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param referSerialNo 关联理赔车辆序号
     * @return PrpLcheckDto
     * @throws Exception
     */
    public PrpLcheckDto findByPrimaryKey(String registNo,int referSerialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckSite,");
        buffer.append("FirstSiteFlag,");
        buffer.append("ClaimType,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("ReferKind,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAddressType,");
        buffer.append("IndemnityDuty,");
        buffer.append("ClaimFlag,");
        buffer.append("Checker1,");
        buffer.append("Checker2,");
        buffer.append("CheckUnitName,");
        buffer.append("HandleUnit,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("ReferSerialNo,");
        buffer.append("InsureCarFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("HandleUnitCode,");
        buffer.append("UnitType,");
        buffer.append("EstimateFee,");
        buffer.append("EstimateLoss,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageAddress,");
        buffer.append("CheckLinker ");
        buffer.append("FROM PrpLcheck ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("ReferSerialNo=").append("").append(referSerialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("ReferSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,referSerialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcheckDto prpLcheckDto = null;
        if(resultSet.next()){
            prpLcheckDto = new PrpLcheckDto();
            prpLcheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckDto.setCheckType(dbManager.getString(resultSet,5));
            prpLcheckDto.setCheckNature(dbManager.getString(resultSet,6));
            prpLcheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcheckDto.setCheckSite(dbManager.getString(resultSet,8));
            prpLcheckDto.setFirstSiteFlag(dbManager.getString(resultSet,9));
            prpLcheckDto.setClaimType(dbManager.getString(resultSet,10));
            prpLcheckDto.setDamageCode(dbManager.getString(resultSet,11));
            prpLcheckDto.setDamageName(dbManager.getString(resultSet,12));
            prpLcheckDto.setDamageTypeCode(dbManager.getString(resultSet,13));
            prpLcheckDto.setDamageTypeName(dbManager.getString(resultSet,14));
            prpLcheckDto.setReferKind(dbManager.getString(resultSet,15));
            prpLcheckDto.setDamageAreaCode(dbManager.getString(resultSet,16));
            prpLcheckDto.setDamageAddressType(dbManager.getString(resultSet,17));
            prpLcheckDto.setIndemnityDuty(dbManager.getString(resultSet,18));
            prpLcheckDto.setClaimFlag(dbManager.getString(resultSet,19));
            prpLcheckDto.setChecker1(dbManager.getString(resultSet,20));
            prpLcheckDto.setChecker2(dbManager.getString(resultSet,21));
            prpLcheckDto.setCheckUnitName(dbManager.getString(resultSet,22));
            prpLcheckDto.setHandleUnit(dbManager.getString(resultSet,23));
            prpLcheckDto.setRemark(dbManager.getString(resultSet,24));
            prpLcheckDto.setFlag(dbManager.getString(resultSet,25));
            prpLcheckDto.setReferSerialNo(dbManager.getInt(resultSet,26));
            prpLcheckDto.setInsureCarFlag(dbManager.getString(resultSet,27));
            prpLcheckDto.setRepeatInsureFlag(dbManager.getString(resultSet,28));
            prpLcheckDto.setHandleUnitCode(dbManager.getString(resultSet,29));
            prpLcheckDto.setUnitType(dbManager.getString(resultSet,30));
            prpLcheckDto.setEstimateFee(dbManager.getDouble(resultSet,31));
            prpLcheckDto.setEstimateLoss(dbManager.getDouble(resultSet,32));
            prpLcheckDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            prpLcheckDto.setDamageStartHour(dbManager.getString(resultSet,34));
            prpLcheckDto.setDamageAddress(dbManager.getString(resultSet,35));
            prpLcheckDto.setCheckLinker(dbManager.getString(resultSet,36));
        }
        resultSet.close();
        return prpLcheckDto;
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
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("CheckType,");
        buffer.append("CheckNature,");
        buffer.append("CheckDate,");
        buffer.append("CheckSite,");
        buffer.append("FirstSiteFlag,");
        buffer.append("ClaimType,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("ReferKind,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAddressType,");
        buffer.append("IndemnityDuty,");
        buffer.append("ClaimFlag,");
        buffer.append("Checker1,");
        buffer.append("Checker2,");
        buffer.append("CheckUnitName,");
        buffer.append("HandleUnit,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("ReferSerialNo,");
        buffer.append("InsureCarFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("HandleUnitCode,");
        buffer.append("UnitType,");
        buffer.append("EstimateFee,");
        buffer.append("EstimateLoss,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageAddress,");
        buffer.append("CheckLinker ");
        buffer.append("FROM PrpLcheck WHERE ");
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
        PrpLcheckDto prpLcheckDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcheckDto = new PrpLcheckDto();
            prpLcheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckDto.setCheckType(dbManager.getString(resultSet,5));
            prpLcheckDto.setCheckNature(dbManager.getString(resultSet,6));
            prpLcheckDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcheckDto.setCheckSite(dbManager.getString(resultSet,8));
            prpLcheckDto.setFirstSiteFlag(dbManager.getString(resultSet,9));
            prpLcheckDto.setClaimType(dbManager.getString(resultSet,10));
            prpLcheckDto.setDamageCode(dbManager.getString(resultSet,11));
            prpLcheckDto.setDamageName(dbManager.getString(resultSet,12));
            prpLcheckDto.setDamageTypeCode(dbManager.getString(resultSet,13));
            prpLcheckDto.setDamageTypeName(dbManager.getString(resultSet,14));
            prpLcheckDto.setReferKind(dbManager.getString(resultSet,15));
            prpLcheckDto.setDamageAreaCode(dbManager.getString(resultSet,16));
            prpLcheckDto.setDamageAddressType(dbManager.getString(resultSet,17));
            prpLcheckDto.setIndemnityDuty(dbManager.getString(resultSet,18));
            prpLcheckDto.setClaimFlag(dbManager.getString(resultSet,19));
            prpLcheckDto.setChecker1(dbManager.getString(resultSet,20));
            prpLcheckDto.setChecker2(dbManager.getString(resultSet,21));
            prpLcheckDto.setCheckUnitName(dbManager.getString(resultSet,22));
            prpLcheckDto.setHandleUnit(dbManager.getString(resultSet,23));
            prpLcheckDto.setRemark(dbManager.getString(resultSet,24));
            prpLcheckDto.setFlag(dbManager.getString(resultSet,25));
            prpLcheckDto.setReferSerialNo(dbManager.getInt(resultSet,26));
            prpLcheckDto.setInsureCarFlag(dbManager.getString(resultSet,27));
            prpLcheckDto.setRepeatInsureFlag(dbManager.getString(resultSet,28));
            prpLcheckDto.setHandleUnitCode(dbManager.getString(resultSet,29));
            prpLcheckDto.setUnitType(dbManager.getString(resultSet,30));
            prpLcheckDto.setEstimateFee(dbManager.getDouble(resultSet,31));
            prpLcheckDto.setEstimateLoss(dbManager.getDouble(resultSet,32));
            prpLcheckDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            prpLcheckDto.setDamageStartHour(dbManager.getString(resultSet,34));
            prpLcheckDto.setDamageAddress(dbManager.getString(resultSet,35));
            prpLcheckDto.setCheckLinker(dbManager.getString(resultSet,36));
            collection.add(prpLcheckDto);
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
        buffer.append("DELETE FROM PrpLcheck WHERE ");
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
        statement = "SELECT count(1) FROM PrpLcheck WHERE ";
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
