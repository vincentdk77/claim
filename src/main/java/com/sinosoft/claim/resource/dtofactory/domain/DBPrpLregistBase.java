package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLregist－报案信息表的数据访问对象基类<br>
 * 创建于 2006-03-16 11:57:09.640<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLregistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLregistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLregistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void insert(PrpLregistDto prpLregistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLregist (");
        buffer.append("registNo,");
        buffer.append("lFlag,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Language,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("ClauseType,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("EngineNo,");
        buffer.append("FrameNo,");
        buffer.append("RunDistance,");
        buffer.append("UseYears,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportAddress,");
        buffer.append("ReportorName,");
        buffer.append("ReportType,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerName,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("FirstSiteFlag,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("HandleUnit,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("EstiCurrency,");
        buffer.append("EstimateLoss,");
        buffer.append("ReceiverName,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ComCode,");
        buffer.append("InputDate,");
        buffer.append("AcceptFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("ClaimType,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("Remark,");
        buffer.append("OperatorCode,");
        buffer.append("MakeCom,");
        buffer.append("Flag,");
        buffer.append("ReportorPhoneNumber,");
        buffer.append("LinkerPostCode,");
        buffer.append("LinkerAddress,");
        buffer.append("EstimateFee,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("CatastropheName2,");
        buffer.append("ReportFlag,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("IndemnityDuty, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLregistDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLanguage()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getInsuredAddress()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLicenseColorCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getCarKindCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getModelCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getBrandName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getEngineNo()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getFrameNo()).append("',");
            debugBuffer.append("").append(prpLregistDto.getRunDistance()).append(",");
            debugBuffer.append("").append(prpLregistDto.getUseYears()).append(",");
            debugBuffer.append("'").append(prpLregistDto.getReportDate()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportHour()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportAddress()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportorName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportType()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLinkerName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageEndDate()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageEndHour()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getFirstSiteFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageAreaCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageAreaName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageAddressType()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getAddressCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDamageAreaPostCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getHandleUnit()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLossName()).append("',");
            debugBuffer.append("").append(prpLregistDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLregistDto.getUnit()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getEstiCurrency()).append("',");
            debugBuffer.append("").append(prpLregistDto.getEstimateLoss()).append(",");
            debugBuffer.append("'").append(prpLregistDto.getReceiverName()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getAcceptFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getRepeatInsureFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getClaimType()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getCancelDate()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getDealerCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportorPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLinkerPostCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getLinkerAddress()).append("',");
            debugBuffer.append("").append(prpLregistDto.getEstimateFee()).append(",");
            debugBuffer.append("'").append(prpLregistDto.getCatastropheCode1()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getCatastropheName1()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getCatastropheCode2()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getCatastropheName2()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getReportFlag()).append("',");
            debugBuffer.append("").append(prpLregistDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLregistDto.getLossesUnitCode()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getBusinessType1()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getIndemnityDuty()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getBusinessFlag()).append("',");
            debugBuffer.append("'").append(prpLregistDto.getOtherFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLregistDto.getRegistNo());
        dbManager.setString(2,prpLregistDto.getLFlag());
        dbManager.setString(3,prpLregistDto.getClassCode());
        dbManager.setString(4,prpLregistDto.getRiskCode());
        dbManager.setString(5,prpLregistDto.getPolicyNo());
        dbManager.setString(6,prpLregistDto.getLanguage());
        dbManager.setString(7,prpLregistDto.getInsuredCode());
        dbManager.setString(8,prpLregistDto.getInsuredName());
        dbManager.setString(9,prpLregistDto.getInsuredAddress());
        dbManager.setString(10,prpLregistDto.getClauseType());
        dbManager.setString(11,prpLregistDto.getLicenseNo());
        dbManager.setString(12,prpLregistDto.getLicenseColorCode());
        dbManager.setString(13,prpLregistDto.getCarKindCode());
        dbManager.setString(14,prpLregistDto.getModelCode());
        dbManager.setString(15,prpLregistDto.getBrandName());
        dbManager.setString(16,prpLregistDto.getEngineNo());
        dbManager.setString(17,prpLregistDto.getFrameNo());
        dbManager.setDouble(18,prpLregistDto.getRunDistance());
        dbManager.setInt(19,prpLregistDto.getUseYears());
        dbManager.setDateTime(20,prpLregistDto.getReportDate());
        dbManager.setString(21,prpLregistDto.getReportHour());
        dbManager.setString(22,prpLregistDto.getReportAddress());
        dbManager.setString(23,prpLregistDto.getReportorName());
        dbManager.setString(24,prpLregistDto.getReportType());
        dbManager.setString(25,prpLregistDto.getPhoneNumber());
        dbManager.setString(26,prpLregistDto.getLinkerName());
        dbManager.setDateTime(27,prpLregistDto.getDamageStartDate());
        dbManager.setString(28,prpLregistDto.getDamageStartHour());
        dbManager.setDateTime(29,prpLregistDto.getDamageEndDate());
        dbManager.setString(30,prpLregistDto.getDamageEndHour());
        dbManager.setString(31,prpLregistDto.getDamageCode());
        dbManager.setString(32,prpLregistDto.getDamageName());
        dbManager.setString(33,prpLregistDto.getDamageTypeCode());
        dbManager.setString(34,prpLregistDto.getDamageTypeName());
        dbManager.setString(35,prpLregistDto.getFirstSiteFlag());
        dbManager.setString(36,prpLregistDto.getDamageAreaCode());
        dbManager.setString(37,prpLregistDto.getDamageAreaName());
        dbManager.setString(38,prpLregistDto.getDamageAddressType());
        dbManager.setString(39,prpLregistDto.getAddressCode());
        dbManager.setString(40,prpLregistDto.getDamageAddress());
        dbManager.setString(41,prpLregistDto.getDamageAreaPostCode());
        dbManager.setString(42,prpLregistDto.getHandleUnit());
        dbManager.setString(43,prpLregistDto.getLossName());
        dbManager.setDouble(44,prpLregistDto.getLossQuantity());
        dbManager.setString(45,prpLregistDto.getUnit());
        dbManager.setString(46,prpLregistDto.getEstiCurrency());
        dbManager.setDouble(47,prpLregistDto.getEstimateLoss());
        dbManager.setString(48,prpLregistDto.getReceiverName());
        dbManager.setString(49,prpLregistDto.getHandlerCode());
        dbManager.setString(50,prpLregistDto.getHandler1Code());
        dbManager.setString(51,prpLregistDto.getComCode());
        dbManager.setDateTime(52,prpLregistDto.getInputDate());
        dbManager.setString(53,prpLregistDto.getAcceptFlag());
        dbManager.setString(54,prpLregistDto.getRepeatInsureFlag());
        dbManager.setString(55,prpLregistDto.getClaimType());
        dbManager.setDateTime(56,prpLregistDto.getCancelDate());
        dbManager.setString(57,prpLregistDto.getDealerCode());
        dbManager.setString(58,prpLregistDto.getRemark());
        dbManager.setString(59,prpLregistDto.getOperatorCode());
        dbManager.setString(60,prpLregistDto.getMakeCom());
        dbManager.setString(61,prpLregistDto.getFlag());
        dbManager.setString(62,prpLregistDto.getReportorPhoneNumber());
        dbManager.setString(63,prpLregistDto.getLinkerPostCode());
        dbManager.setString(64,prpLregistDto.getLinkerAddress());
        dbManager.setDouble(65,prpLregistDto.getEstimateFee());
        dbManager.setString(66,prpLregistDto.getCatastropheCode1());
        dbManager.setString(67,prpLregistDto.getCatastropheName1());
        dbManager.setString(68,prpLregistDto.getCatastropheCode2());
        dbManager.setString(69,prpLregistDto.getCatastropheName2());
        dbManager.setString(70,prpLregistDto.getReportFlag());
        dbManager.setDouble(71,prpLregistDto.getLossesNumber());
        dbManager.setString(72,prpLregistDto.getLossesUnitCode());
        dbManager.setString(73,prpLregistDto.getBusinessType());
        dbManager.setString(74,prpLregistDto.getBusinessType1());
        dbManager.setString(75,prpLregistDto.getIndemnityDuty());
        dbManager.setString(76,prpLregistDto.getBusinessFlag());
        dbManager.setString(77,prpLregistDto.getOtherFlag());
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregistBase insert Success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLregist (");
        buffer.append("registNo,");
        buffer.append("lFlag,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Language,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("ClauseType,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("EngineNo,");
        buffer.append("FrameNo,");
        buffer.append("RunDistance,");
        buffer.append("UseYears,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportAddress,");
        buffer.append("ReportorName,");
        buffer.append("ReportType,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerName,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("FirstSiteFlag,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("HandleUnit,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("EstiCurrency,");
        buffer.append("EstimateLoss,");
        buffer.append("ReceiverName,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ComCode,");
        buffer.append("InputDate,");
        buffer.append("AcceptFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("ClaimType,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("Remark,");
        buffer.append("OperatorCode,");
        buffer.append("MakeCom,");
        buffer.append("Flag,");
        buffer.append("ReportorPhoneNumber,");
        buffer.append("LinkerPostCode,");
        buffer.append("LinkerAddress,");
        buffer.append("EstimateFee,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("CatastropheName2,");
        buffer.append("ReportFlag,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("IndemnityDuty ,");
        buffer.append("BusinessFlag ,");
        buffer.append("OtherFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLregistDto prpLregistDto = (PrpLregistDto)i.next();
            dbManager.setString(1,prpLregistDto.getRegistNo());
            dbManager.setString(2,prpLregistDto.getLFlag());
            dbManager.setString(3,prpLregistDto.getClassCode());
            dbManager.setString(4,prpLregistDto.getRiskCode());
            dbManager.setString(5,prpLregistDto.getPolicyNo());
            dbManager.setString(6,prpLregistDto.getLanguage());
            dbManager.setString(7,prpLregistDto.getInsuredCode());
            dbManager.setString(8,prpLregistDto.getInsuredName());
            dbManager.setString(9,prpLregistDto.getInsuredAddress());
            dbManager.setString(10,prpLregistDto.getClauseType());
            dbManager.setString(11,prpLregistDto.getLicenseNo());
            dbManager.setString(12,prpLregistDto.getLicenseColorCode());
            dbManager.setString(13,prpLregistDto.getCarKindCode());
            dbManager.setString(14,prpLregistDto.getModelCode());
            dbManager.setString(15,prpLregistDto.getBrandName());
            dbManager.setString(16,prpLregistDto.getEngineNo());
            dbManager.setString(17,prpLregistDto.getFrameNo());
            dbManager.setDouble(18,prpLregistDto.getRunDistance());
            dbManager.setInt(19,prpLregistDto.getUseYears());
            dbManager.setDateTime(20,prpLregistDto.getReportDate());
            dbManager.setString(21,prpLregistDto.getReportHour());
            dbManager.setString(22,prpLregistDto.getReportAddress());
            dbManager.setString(23,prpLregistDto.getReportorName());
            dbManager.setString(24,prpLregistDto.getReportType());
            dbManager.setString(25,prpLregistDto.getPhoneNumber());
            dbManager.setString(26,prpLregistDto.getLinkerName());
            dbManager.setDateTime(27,prpLregistDto.getDamageStartDate());
            dbManager.setString(28,prpLregistDto.getDamageStartHour());
            dbManager.setDateTime(29,prpLregistDto.getDamageEndDate());
            dbManager.setString(30,prpLregistDto.getDamageEndHour());
            dbManager.setString(31,prpLregistDto.getDamageCode());
            dbManager.setString(32,prpLregistDto.getDamageName());
            dbManager.setString(33,prpLregistDto.getDamageTypeCode());
            dbManager.setString(34,prpLregistDto.getDamageTypeName());
            dbManager.setString(35,prpLregistDto.getFirstSiteFlag());
            dbManager.setString(36,prpLregistDto.getDamageAreaCode());
            dbManager.setString(37,prpLregistDto.getDamageAreaName());
            dbManager.setString(38,prpLregistDto.getDamageAddressType());
            dbManager.setString(39,prpLregistDto.getAddressCode());
            dbManager.setString(40,prpLregistDto.getDamageAddress());
            dbManager.setString(41,prpLregistDto.getDamageAreaPostCode());
            dbManager.setString(42,prpLregistDto.getHandleUnit());
            dbManager.setString(43,prpLregistDto.getLossName());
            dbManager.setDouble(44,prpLregistDto.getLossQuantity());
            dbManager.setString(45,prpLregistDto.getUnit());
            dbManager.setString(46,prpLregistDto.getEstiCurrency());
            dbManager.setDouble(47,prpLregistDto.getEstimateLoss());
            dbManager.setString(48,prpLregistDto.getReceiverName());
            dbManager.setString(49,prpLregistDto.getHandlerCode());
            dbManager.setString(50,prpLregistDto.getHandler1Code());
            dbManager.setString(51,prpLregistDto.getComCode());
            dbManager.setDateTime(52,prpLregistDto.getInputDate());
            dbManager.setString(53,prpLregistDto.getAcceptFlag());
            dbManager.setString(54,prpLregistDto.getRepeatInsureFlag());
            dbManager.setString(55,prpLregistDto.getClaimType());
            dbManager.setDateTime(56,prpLregistDto.getCancelDate());
            dbManager.setString(57,prpLregistDto.getDealerCode());
            dbManager.setString(58,prpLregistDto.getRemark());
            dbManager.setString(59,prpLregistDto.getOperatorCode());
            dbManager.setString(60,prpLregistDto.getMakeCom());
            dbManager.setString(61,prpLregistDto.getFlag());
            dbManager.setString(62,prpLregistDto.getReportorPhoneNumber());
            dbManager.setString(63,prpLregistDto.getLinkerPostCode());
            dbManager.setString(64,prpLregistDto.getLinkerAddress());
            dbManager.setDouble(65,prpLregistDto.getEstimateFee());
            dbManager.setString(66,prpLregistDto.getCatastropheCode1());
            dbManager.setString(67,prpLregistDto.getCatastropheName1());
            dbManager.setString(68,prpLregistDto.getCatastropheCode2());
            dbManager.setString(69,prpLregistDto.getCatastropheName2());
            dbManager.setString(70,prpLregistDto.getReportFlag());
            dbManager.setDouble(71,prpLregistDto.getLossesNumber());
            dbManager.setString(72,prpLregistDto.getLossesUnitCode());
            dbManager.setString(73,prpLregistDto.getBusinessType());
            dbManager.setString(74,prpLregistDto.getBusinessType1());
            dbManager.setString(75,prpLregistDto.getIndemnityDuty());
            dbManager.setString(76,prpLregistDto.getBusinessFlag());
            dbManager.setString(77,prpLregistDto.getOtherFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLregistBase insertAll Success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLregist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregistBase delete Success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void update(PrpLregistDto prpLregistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLregist SET ");
        buffer.append("lFlag = ?, ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("Language = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("InsuredAddress = ?, ");
        buffer.append("ClauseType = ?, ");
        buffer.append("LicenseNo = ?, ");
        buffer.append("LicenseColorCode = ?, ");
        buffer.append("CarKindCode = ?, ");
        buffer.append("ModelCode = ?, ");
        buffer.append("BrandName = ?, ");
        buffer.append("EngineNo = ?, ");
        buffer.append("FrameNo = ?, ");
        buffer.append("RunDistance = ?, ");
        buffer.append("UseYears = ?, ");
        buffer.append("ReportDate = ?, ");
        buffer.append("ReportHour = ?, ");
        buffer.append("ReportAddress = ?, ");
        buffer.append("ReportorName = ?, ");
        buffer.append("ReportType = ?, ");
        buffer.append("PhoneNumber = ?, ");
        buffer.append("LinkerName = ?, ");
        buffer.append("DamageStartDate = ?, ");
        buffer.append("DamageStartHour = ?, ");
        buffer.append("DamageEndDate = ?, ");
        buffer.append("DamageEndHour = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("DamageName = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("DamageTypeName = ?, ");
        buffer.append("FirstSiteFlag = ?, ");
        buffer.append("DamageAreaCode = ?, ");
        buffer.append("DamageAreaName = ?, ");
        buffer.append("DamageAddressType = ?, ");
        buffer.append("AddressCode = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("DamageAreaPostCode = ?, ");
        buffer.append("HandleUnit = ?, ");
        buffer.append("LossName = ?, ");
        buffer.append("LossQuantity = ?, ");
        buffer.append("Unit = ?, ");
        buffer.append("EstiCurrency = ?, ");
        buffer.append("EstimateLoss = ?, ");
        buffer.append("ReceiverName = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("Handler1Code = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("AcceptFlag = ?, ");
        buffer.append("RepeatInsureFlag = ?, ");
        buffer.append("ClaimType = ?, ");
        buffer.append("CancelDate = ?, ");
        buffer.append("DealerCode = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ReportorPhoneNumber = ?, ");
        buffer.append("LinkerPostCode = ?, ");
        buffer.append("LinkerAddress = ?, ");
        buffer.append("EstimateFee = ?, ");
        buffer.append("CatastropheCode1 = ?, ");
        buffer.append("CatastropheName1 = ?, ");
        buffer.append("CatastropheCode2 = ?, ");
        buffer.append("CatastropheName2 = ?, ");
        buffer.append("ReportFlag = ?, ");
        buffer.append("LossesNumber = ?, ");
        buffer.append("LossesUnitCode = ?, ");
        buffer.append("BusinessType = ?, ");
        buffer.append("BusinessType1 = ?, ");
        buffer.append("IndemnityDuty = ?, ");
        buffer.append("BusinessFlag = ?, ");
        buffer.append("OtherFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLregist SET ");
            debugBuffer.append("lFlag = '" + prpLregistDto.getLFlag() + "', ");
            debugBuffer.append("ClassCode = '" + prpLregistDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpLregistDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLregistDto.getPolicyNo() + "', ");
            debugBuffer.append("Language = '" + prpLregistDto.getLanguage() + "', ");
            debugBuffer.append("InsuredCode = '" + prpLregistDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpLregistDto.getInsuredName() + "', ");
            debugBuffer.append("InsuredAddress = '" + prpLregistDto.getInsuredAddress() + "', ");
            debugBuffer.append("ClauseType = '" + prpLregistDto.getClauseType() + "', ");
            debugBuffer.append("LicenseNo = '" + prpLregistDto.getLicenseNo() + "', ");
            debugBuffer.append("LicenseColorCode = '" + prpLregistDto.getLicenseColorCode() + "', ");
            debugBuffer.append("CarKindCode = '" + prpLregistDto.getCarKindCode() + "', ");
            debugBuffer.append("ModelCode = '" + prpLregistDto.getModelCode() + "', ");
            debugBuffer.append("BrandName = '" + prpLregistDto.getBrandName() + "', ");
            debugBuffer.append("EngineNo = '" + prpLregistDto.getEngineNo() + "', ");
            debugBuffer.append("FrameNo = '" + prpLregistDto.getFrameNo() + "', ");
            debugBuffer.append("RunDistance = " + prpLregistDto.getRunDistance() + ", ");
            debugBuffer.append("UseYears = " + prpLregistDto.getUseYears() + ", ");
            debugBuffer.append("ReportDate = '" + prpLregistDto.getReportDate() + "', ");
            debugBuffer.append("ReportHour = '" + prpLregistDto.getReportHour() + "', ");
            debugBuffer.append("ReportAddress = '" + prpLregistDto.getReportAddress() + "', ");
            debugBuffer.append("ReportorName = '" + prpLregistDto.getReportorName() + "', ");
            debugBuffer.append("ReportType = '" + prpLregistDto.getReportType() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpLregistDto.getPhoneNumber() + "', ");
            debugBuffer.append("LinkerName = '" + prpLregistDto.getLinkerName() + "', ");
            debugBuffer.append("DamageStartDate = '" + prpLregistDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLregistDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageEndDate = '" + prpLregistDto.getDamageEndDate() + "', ");
            debugBuffer.append("DamageEndHour = '" + prpLregistDto.getDamageEndHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLregistDto.getDamageCode() + "', ");
            debugBuffer.append("DamageName = '" + prpLregistDto.getDamageName() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLregistDto.getDamageTypeCode() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLregistDto.getDamageTypeName() + "', ");
            debugBuffer.append("FirstSiteFlag = '" + prpLregistDto.getFirstSiteFlag() + "', ");
            debugBuffer.append("DamageAreaCode = '" + prpLregistDto.getDamageAreaCode() + "', ");
            debugBuffer.append("DamageAreaName = '" + prpLregistDto.getDamageAreaName() + "', ");
            debugBuffer.append("DamageAddressType = '" + prpLregistDto.getDamageAddressType() + "', ");
            debugBuffer.append("AddressCode = '" + prpLregistDto.getAddressCode() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLregistDto.getDamageAddress() + "', ");
            debugBuffer.append("DamageAreaPostCode = '" + prpLregistDto.getDamageAreaPostCode() + "', ");
            debugBuffer.append("HandleUnit = '" + prpLregistDto.getHandleUnit() + "', ");
            debugBuffer.append("LossName = '" + prpLregistDto.getLossName() + "', ");
            debugBuffer.append("LossQuantity = " + prpLregistDto.getLossQuantity() + ", ");
            debugBuffer.append("Unit = '" + prpLregistDto.getUnit() + "', ");
            debugBuffer.append("EstiCurrency = '" + prpLregistDto.getEstiCurrency() + "', ");
            debugBuffer.append("EstimateLoss = " + prpLregistDto.getEstimateLoss() + ", ");
            debugBuffer.append("ReceiverName = '" + prpLregistDto.getReceiverName() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLregistDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLregistDto.getHandler1Code() + "', ");
            debugBuffer.append("ComCode = '" + prpLregistDto.getComCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLregistDto.getInputDate() + "', ");
            debugBuffer.append("AcceptFlag = '" + prpLregistDto.getAcceptFlag() + "', ");
            debugBuffer.append("RepeatInsureFlag = '" + prpLregistDto.getRepeatInsureFlag() + "', ");
            debugBuffer.append("ClaimType = '" + prpLregistDto.getClaimType() + "', ");
            debugBuffer.append("CancelDate = '" + prpLregistDto.getCancelDate() + "', ");
            debugBuffer.append("DealerCode = '" + prpLregistDto.getDealerCode() + "', ");
            debugBuffer.append("Remark = '" + prpLregistDto.getRemark() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLregistDto.getOperatorCode() + "', ");
            debugBuffer.append("MakeCom = '" + prpLregistDto.getMakeCom() + "', ");
            debugBuffer.append("Flag = '" + prpLregistDto.getFlag() + "', ");
            debugBuffer.append("ReportorPhoneNumber = '" + prpLregistDto.getReportorPhoneNumber() + "', ");
            debugBuffer.append("LinkerPostCode = '" + prpLregistDto.getLinkerPostCode() + "', ");
            debugBuffer.append("LinkerAddress = '" + prpLregistDto.getLinkerAddress() + "', ");
            debugBuffer.append("EstimateFee = " + prpLregistDto.getEstimateFee() + ", ");
            debugBuffer.append("CatastropheCode1 = '" + prpLregistDto.getCatastropheCode1() + "', ");
            debugBuffer.append("CatastropheName1 = '" + prpLregistDto.getCatastropheName1() + "', ");
            debugBuffer.append("CatastropheCode2 = '" + prpLregistDto.getCatastropheCode2() + "', ");
            debugBuffer.append("CatastropheName2 = '" + prpLregistDto.getCatastropheName2() + "', ");
            debugBuffer.append("ReportFlag = '" + prpLregistDto.getReportFlag() + "', ");
            debugBuffer.append("LossesNumber = " + prpLregistDto.getLossesNumber()+", ");
            debugBuffer.append("LossesUnitCode = '" + prpLregistDto.getLossesUnitCode()+"', ");
            debugBuffer.append("BusinessType = '" + prpLregistDto.getBusinessType()+"', ");
            debugBuffer.append("BusinessType1 = '" + prpLregistDto.getBusinessType1()+"', ");
            debugBuffer.append("IndemnityDuty = '" + prpLregistDto.getIndemnityDuty() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLregistDto.getBusinessFlag() + "', ");
            debugBuffer.append("OtherFlag = '" + prpLregistDto.getOtherFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(prpLregistDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLregistDto.getLFlag());
        dbManager.setString(2,prpLregistDto.getClassCode());
        dbManager.setString(3,prpLregistDto.getRiskCode());
        dbManager.setString(4,prpLregistDto.getPolicyNo());
        dbManager.setString(5,prpLregistDto.getLanguage());
        dbManager.setString(6,prpLregistDto.getInsuredCode());
        dbManager.setString(7,prpLregistDto.getInsuredName());
        dbManager.setString(8,prpLregistDto.getInsuredAddress());
        dbManager.setString(9,prpLregistDto.getClauseType());
        dbManager.setString(10,prpLregistDto.getLicenseNo());
        dbManager.setString(11,prpLregistDto.getLicenseColorCode());
        dbManager.setString(12,prpLregistDto.getCarKindCode());
        dbManager.setString(13,prpLregistDto.getModelCode());
        dbManager.setString(14,prpLregistDto.getBrandName());
        dbManager.setString(15,prpLregistDto.getEngineNo());
        dbManager.setString(16,prpLregistDto.getFrameNo());
        dbManager.setDouble(17,prpLregistDto.getRunDistance());
        dbManager.setInt(18,prpLregistDto.getUseYears());
        dbManager.setDateTime(19,prpLregistDto.getReportDate());
        dbManager.setString(20,prpLregistDto.getReportHour());
        dbManager.setString(21,prpLregistDto.getReportAddress());
        dbManager.setString(22,prpLregistDto.getReportorName());
        dbManager.setString(23,prpLregistDto.getReportType());
        dbManager.setString(24,prpLregistDto.getPhoneNumber());
        dbManager.setString(25,prpLregistDto.getLinkerName());
        dbManager.setDateTime(26,prpLregistDto.getDamageStartDate());
        dbManager.setString(27,prpLregistDto.getDamageStartHour());
        dbManager.setDateTime(28,prpLregistDto.getDamageEndDate());
        dbManager.setString(29,prpLregistDto.getDamageEndHour());
        dbManager.setString(30,prpLregistDto.getDamageCode());
        dbManager.setString(31,prpLregistDto.getDamageName());
        dbManager.setString(32,prpLregistDto.getDamageTypeCode());
        dbManager.setString(33,prpLregistDto.getDamageTypeName());
        dbManager.setString(34,prpLregistDto.getFirstSiteFlag());
        dbManager.setString(35,prpLregistDto.getDamageAreaCode());
        dbManager.setString(36,prpLregistDto.getDamageAreaName());
        dbManager.setString(37,prpLregistDto.getDamageAddressType());
        dbManager.setString(38,prpLregistDto.getAddressCode());
        dbManager.setString(39,prpLregistDto.getDamageAddress());
        dbManager.setString(40,prpLregistDto.getDamageAreaPostCode());
        dbManager.setString(41,prpLregistDto.getHandleUnit());
        dbManager.setString(42,prpLregistDto.getLossName());
        dbManager.setDouble(43,prpLregistDto.getLossQuantity());
        dbManager.setString(44,prpLregistDto.getUnit());
        dbManager.setString(45,prpLregistDto.getEstiCurrency());
        dbManager.setDouble(46,prpLregistDto.getEstimateLoss());
        dbManager.setString(47,prpLregistDto.getReceiverName());
        dbManager.setString(48,prpLregistDto.getHandlerCode());
        dbManager.setString(49,prpLregistDto.getHandler1Code());
        dbManager.setString(50,prpLregistDto.getComCode());
        dbManager.setDateTime(51,prpLregistDto.getInputDate());
        dbManager.setString(52,prpLregistDto.getAcceptFlag());
        dbManager.setString(53,prpLregistDto.getRepeatInsureFlag());
        dbManager.setString(54,prpLregistDto.getClaimType());
        dbManager.setDateTime(55,prpLregistDto.getCancelDate());
        dbManager.setString(56,prpLregistDto.getDealerCode());
        dbManager.setString(57,prpLregistDto.getRemark());
        dbManager.setString(58,prpLregistDto.getOperatorCode());
        dbManager.setString(59,prpLregistDto.getMakeCom());
        dbManager.setString(60,prpLregistDto.getFlag());
        dbManager.setString(61,prpLregistDto.getReportorPhoneNumber());
        dbManager.setString(62,prpLregistDto.getLinkerPostCode());
        dbManager.setString(63,prpLregistDto.getLinkerAddress());
        dbManager.setDouble(64,prpLregistDto.getEstimateFee());
        dbManager.setString(65,prpLregistDto.getCatastropheCode1());
        dbManager.setString(66,prpLregistDto.getCatastropheName1());
        dbManager.setString(67,prpLregistDto.getCatastropheCode2());
        dbManager.setString(68,prpLregistDto.getCatastropheName2());
        dbManager.setString(69,prpLregistDto.getReportFlag());
        dbManager.setDouble(70,prpLregistDto.getLossesNumber());
        dbManager.setString(71,prpLregistDto.getLossesUnitCode());
        dbManager.setString(72,prpLregistDto.getBusinessType());
        dbManager.setString(73,prpLregistDto.getBusinessType1());
        dbManager.setString(74,prpLregistDto.getIndemnityDuty());
        dbManager.setString(75,prpLregistDto.getBusinessFlag());
        dbManager.setString(76,prpLregistDto.getOtherFlag());
        //设置条件字段;
        dbManager.setString(77,prpLregistDto.getRegistNo());
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregistBase update Success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @return PrpLregistDto
     * @throws Exception
     */
    public PrpLregistDto findByPrimaryKey(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("registNo,");
        buffer.append("lFlag,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Language,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("ClauseType,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("EngineNo,");
        buffer.append("FrameNo,");
        buffer.append("RunDistance,");
        buffer.append("UseYears,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportAddress,");
        buffer.append("ReportorName,");
        buffer.append("ReportType,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerName,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("FirstSiteFlag,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("HandleUnit,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("EstiCurrency,");
        buffer.append("EstimateLoss,");
        buffer.append("ReceiverName,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ComCode,");
        buffer.append("InputDate,");
        buffer.append("AcceptFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("ClaimType,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("Remark,");
        buffer.append("OperatorCode,");
        buffer.append("MakeCom,");
        buffer.append("Flag,");
        buffer.append("ReportorPhoneNumber,");
        buffer.append("LinkerPostCode,");
        buffer.append("LinkerAddress,");
        buffer.append("EstimateFee,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("CatastropheName2,");
        buffer.append("ReportFlag,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("Businesstype,");
        buffer.append("Businesstype1,");
        buffer.append("IndemnityDuty, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag ");
        buffer.append("FROM PrpLregist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");
         
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLregistDto prpLregistDto = null;
        if(resultSet.next()){
            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregistDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregistDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregistDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregistDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregistDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregistDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregistDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregistDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregistDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregistDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregistDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregistDto.setReportType(dbManager.getString(resultSet,24));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregistDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregistDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregistDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregistDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregistDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregistDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregistDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregistDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregistDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregistDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregistDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregistDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregistDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregistDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregistDto.setLossName(dbManager.getString(resultSet,43));
            prpLregistDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregistDto.setUnit(dbManager.getString(resultSet,45));
            prpLregistDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregistDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregistDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregistDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregistDto.setComCode(dbManager.getString(resultSet,51));
            prpLregistDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregistDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregistDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregistDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregistDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregistDto.setRemark(dbManager.getString(resultSet,58));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregistDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregistDto.setFlag(dbManager.getString(resultSet,61));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregistDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregistDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregistDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregistDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregistDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregistDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregistDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregistDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregistDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregistDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregistDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregistDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregistDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregistDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregistDto.setOtherFlag(dbManager.getString(resultSet,77));
        }
        resultSet.close();
        logger.info("DBPrpLregistBase findByPrimaryKey Success!");
        return prpLregistDto;
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
        buffer.append("registNo,");
        buffer.append("lFlag,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Language,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("ClauseType,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("EngineNo,");
        buffer.append("FrameNo,");
        buffer.append("RunDistance,");
        buffer.append("UseYears,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportAddress,");
        buffer.append("ReportorName,");
        buffer.append("ReportType,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerName,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("FirstSiteFlag,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("HandleUnit,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("EstiCurrency,");
        buffer.append("EstimateLoss,");
        buffer.append("ReceiverName,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ComCode,");
        buffer.append("InputDate,");
        buffer.append("AcceptFlag,");
        buffer.append("RepeatInsureFlag,");
        buffer.append("ClaimType,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("Remark,");
        buffer.append("OperatorCode,");
        buffer.append("MakeCom,");
        buffer.append("Flag,");
        buffer.append("ReportorPhoneNumber,");
        buffer.append("LinkerPostCode,");
        buffer.append("LinkerAddress,");
        buffer.append("EstimateFee,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("CatastropheName2,");
        buffer.append("ReportFlag,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("IndemnityDuty, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag ");
        buffer.append("FROM PrpLregist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //System.err.println("sql:" + buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLregistDto prpLregistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregistDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregistDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregistDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregistDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregistDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregistDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregistDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregistDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregistDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregistDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregistDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregistDto.setReportType(dbManager.getString(resultSet,24));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregistDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregistDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregistDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregistDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregistDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregistDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregistDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregistDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregistDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregistDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregistDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregistDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregistDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregistDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregistDto.setLossName(dbManager.getString(resultSet,43));
            prpLregistDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregistDto.setUnit(dbManager.getString(resultSet,45));
            prpLregistDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregistDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregistDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregistDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregistDto.setComCode(dbManager.getString(resultSet,51));
            prpLregistDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregistDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregistDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregistDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregistDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregistDto.setRemark(dbManager.getString(resultSet,58));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregistDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregistDto.setFlag(dbManager.getString(resultSet,61));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregistDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregistDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregistDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregistDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregistDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregistDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregistDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregistDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregistDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregistDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregistDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregistDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregistDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregistDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregistDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregistDto);
        }
        resultSet.close();
        logger.info("DBPrpLregistBase findByConditions Success!");
        return collection;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions0310(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("distinct PrpLregist.registNo,");
        buffer.append("PrpLregist.lFlag,");
        buffer.append("PrpLregist.ClassCode,");
        buffer.append("PrpLregist.RiskCode,");
        buffer.append("PrpLregist.PolicyNo,");
        buffer.append("PrpLregist.Language,");
        buffer.append("PrpLregist.InsuredCode,");
        buffer.append("PrpLregist.InsuredName,");
        buffer.append("PrpLregist.InsuredAddress,");
        buffer.append("PrpLregist.ClauseType,");
        buffer.append("PrpLregist.LicenseNo,");
        buffer.append("PrpLregist.LicenseColorCode,");
        buffer.append("PrpLregist.CarKindCode,");
        buffer.append("PrpLregist.ModelCode,");
        buffer.append("PrpLregist.BrandName,");
        buffer.append("PrpLregist.EngineNo,");
        buffer.append("PrpLregist.FrameNo,");
        buffer.append("PrpLregist.RunDistance,");
        buffer.append("PrpLregist.UseYears,");
        buffer.append("PrpLregist.ReportDate,");
        buffer.append("PrpLregist.ReportHour,");
        buffer.append("PrpLregist.ReportAddress,");
        buffer.append("PrpLregist.ReportorName,");
        buffer.append("PrpLregist.ReportType,");
        buffer.append("PrpLregist.PhoneNumber,");
        buffer.append("PrpLregist.LinkerName,");
        buffer.append("PrpLregist.DamageStartDate,");
        buffer.append("PrpLregist.DamageStartHour,");
        buffer.append("PrpLregist.DamageEndDate,");
        buffer.append("PrpLregist.DamageEndHour,");
        buffer.append("PrpLregist.DamageCode,");
        buffer.append("PrpLregist.DamageName,");
        buffer.append("PrpLregist.DamageTypeCode,");
        buffer.append("PrpLregist.DamageTypeName,");
        buffer.append("PrpLregist.FirstSiteFlag,");
        buffer.append("PrpLregist.DamageAreaCode,");
        buffer.append("PrpLregist.DamageAreaName,");
        buffer.append("PrpLregist.DamageAddressType,");
        buffer.append("PrpLregist.AddressCode,");
        buffer.append("PrpLregist.DamageAddress,");
        buffer.append("PrpLregist.DamageAreaPostCode,");
        buffer.append("PrpLregist.HandleUnit,");
        buffer.append("PrpLregist.LossName,");
        buffer.append("PrpLregist.LossQuantity,");
        buffer.append("PrpLregist.Unit,");
        buffer.append("PrpLregist.EstiCurrency,");
        buffer.append("PrpLregist.EstimateLoss,");
        buffer.append("PrpLregist.ReceiverName,");
        buffer.append("PrpLregist.HandlerCode,");
        buffer.append("PrpLregist.Handler1Code,");
        buffer.append("PrpLregist.ComCode,");
        buffer.append("PrpLregist.InputDate,");
        buffer.append("PrpLregist.AcceptFlag,");
        buffer.append("PrpLregist.RepeatInsureFlag,");
        buffer.append("PrpLregist.ClaimType,");
        buffer.append("PrpLregist.CancelDate,");
        buffer.append("PrpLregist.DealerCode,");
        buffer.append("PrpLregist.Remark,");
        buffer.append("PrpLregist.OperatorCode,");
        buffer.append("PrpLregist.MakeCom,");
        buffer.append("PrpLregist.Flag,");
        buffer.append("PrpLregist.ReportorPhoneNumber,");
        buffer.append("PrpLregist.LinkerPostCode,");
        buffer.append("PrpLregist.LinkerAddress,");
        buffer.append("PrpLregist.EstimateFee,");
        buffer.append("PrpLregist.CatastropheCode1,");
        buffer.append("PrpLregist.CatastropheName1,");
        buffer.append("PrpLregist.CatastropheCode2,");
        buffer.append("PrpLregist.CatastropheName2,");
        buffer.append("PrpLregist.ReportFlag,");
        buffer.append("PrpLregist.LossesNumber,");
        buffer.append("PrpLregist.LossesUnitCode,");
        buffer.append("PrpLregist.BusinessType,");
        buffer.append("PrpLregist.BusinessType1,");
        buffer.append("PrpLregist.IndemnityDuty, ");
        buffer.append("PrpLregist.BusinessFlag, ");
        buffer.append("PrpLregist.OtherFlag ");
        buffer.append("FROM PrpLregist,prplcompensatehouse WHERE PrpLregist.registno=prplcompensatehouse.registno and prplcompensatehouse.nodetype='regis' and ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        
        System.err.println("sql:"+ buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLregistDto prpLregistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregistDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregistDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregistDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregistDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregistDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregistDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregistDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregistDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregistDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregistDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregistDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregistDto.setReportType(dbManager.getString(resultSet,24));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregistDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregistDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregistDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregistDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregistDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregistDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregistDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregistDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregistDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregistDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregistDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregistDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregistDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregistDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregistDto.setLossName(dbManager.getString(resultSet,43));
            prpLregistDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregistDto.setUnit(dbManager.getString(resultSet,45));
            prpLregistDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregistDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregistDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregistDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregistDto.setComCode(dbManager.getString(resultSet,51));
            prpLregistDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregistDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregistDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregistDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregistDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregistDto.setRemark(dbManager.getString(resultSet,58));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregistDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregistDto.setFlag(dbManager.getString(resultSet,61));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregistDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregistDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregistDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregistDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregistDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregistDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregistDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregistDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregistDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregistDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregistDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregistDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregistDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregistDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregistDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregistDto);
        }
        resultSet.close();
        logger.info("DBPrpLregistBase findByConditions Success!");
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
    
    public Collection findByConditions0310(String conditions)
    throws Exception{
return findByConditions0310(conditions,0,0);
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
        buffer.append("DELETE FROM PrpLregist WHERE ");
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
       String  statement ;
          statement = "SELECT count(1) FROM PrpLregist WHERE ";
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
    
    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @return PrpLregistDto
     * @throws Exception
     */
    public PrpLregistDto findByPrimaryKeyToLinkManInfo(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("reportorname,");
        buffer.append("reportorphonenumber,");
        buffer.append("insuredname,");
        buffer.append("insuredphone,");
        buffer.append("insuredmobilephone,");
        buffer.append("drivername,");
        buffer.append("driverphone, ");
        buffer.append("linkername, ");
        buffer.append("phonenumber, ");
        buffer.append("classcode ");
        buffer.append("FROM PrpLregist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(registNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");
         
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLregistDto prpLregistDto = null;
        if(resultSet.next()){
            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,3));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,4));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,5));
            prpLregistDto.setInsuredPhone(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredMobilePhone(dbManager.getString(resultSet,7));
            prpLregistDto.setDriverName(dbManager.getString(resultSet,8));
            prpLregistDto.setDriverPhone(dbManager.getString(resultSet,9));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,10));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,11));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        logger.info("DBPrpLregistBase findByPrimaryKey Success!");
        return prpLregistDto;
    }
}
