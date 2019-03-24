package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistTgDto;
import com.sinosoft.claim.dto.domain.PrpLRegistTgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLregist－报案信息表的数据访问对象基类<br>
 * 创建于 2006-03-16 11:57:09.640<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLRegistTgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLRegistTgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLRegistTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLregisttgDto prpLregisttgDto
     * @throws Exception
     */
    public void insert(PrpLRegistTgDto prpLregisttgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLregisttg (");
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
            debugBuffer.append("'").append(prpLregisttgDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLanguage()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getInsuredAddress()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLicenseColorCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getCarKindCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getModelCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getBrandName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getEngineNo()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getFrameNo()).append("',");
            debugBuffer.append("").append(prpLregisttgDto.getRunDistance()).append(",");
            debugBuffer.append("").append(prpLregisttgDto.getUseYears()).append(",");
            debugBuffer.append("'").append(prpLregisttgDto.getReportDate()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportHour()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportAddress()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportorName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportType()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLinkerName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageEndDate()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageEndHour()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getFirstSiteFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageAreaCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageAreaName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageAddressType()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getAddressCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDamageAreaPostCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getHandleUnit()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLossName()).append("',");
            debugBuffer.append("").append(prpLregisttgDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLregisttgDto.getUnit()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getEstiCurrency()).append("',");
            debugBuffer.append("").append(prpLregisttgDto.getEstimateLoss()).append(",");
            debugBuffer.append("'").append(prpLregisttgDto.getReceiverName()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getAcceptFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getRepeatInsureFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getClaimType()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getCancelDate()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getDealerCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportorPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLinkerPostCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getLinkerAddress()).append("',");
            debugBuffer.append("").append(prpLregisttgDto.getEstimateFee()).append(",");
            debugBuffer.append("'").append(prpLregisttgDto.getCatastropheCode1()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getCatastropheName1()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getCatastropheCode2()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getCatastropheName2()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getReportFlag()).append("',");
            debugBuffer.append("").append(prpLregisttgDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLregisttgDto.getLossesUnitCode()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getBusinessType1()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getIndemnityDuty()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getBusinessFlag()).append("',");
            debugBuffer.append("'").append(prpLregisttgDto.getOtherFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLregisttgDto.getRegistNo());
        dbManager.setString(2,prpLregisttgDto.getLFlag());
        dbManager.setString(3,prpLregisttgDto.getClassCode());
        dbManager.setString(4,prpLregisttgDto.getRiskCode());
        dbManager.setString(5,prpLregisttgDto.getPolicyNo());
        dbManager.setString(6,prpLregisttgDto.getLanguage());
        dbManager.setString(7,prpLregisttgDto.getInsuredCode());
        dbManager.setString(8,prpLregisttgDto.getInsuredName());
        dbManager.setString(9,prpLregisttgDto.getInsuredAddress());
        dbManager.setString(10,prpLregisttgDto.getClauseType());
        dbManager.setString(11,prpLregisttgDto.getLicenseNo());
        dbManager.setString(12,prpLregisttgDto.getLicenseColorCode());
        dbManager.setString(13,prpLregisttgDto.getCarKindCode());
        dbManager.setString(14,prpLregisttgDto.getModelCode());
        dbManager.setString(15,prpLregisttgDto.getBrandName());
        dbManager.setString(16,prpLregisttgDto.getEngineNo());
        dbManager.setString(17,prpLregisttgDto.getFrameNo());
        dbManager.setDouble(18,prpLregisttgDto.getRunDistance());
        dbManager.setInt(19,prpLregisttgDto.getUseYears());
        dbManager.setDateTime(20,prpLregisttgDto.getReportDate());
        dbManager.setString(21,prpLregisttgDto.getReportHour());
        dbManager.setString(22,prpLregisttgDto.getReportAddress());
        dbManager.setString(23,prpLregisttgDto.getReportorName());
        dbManager.setString(24,prpLregisttgDto.getReportType());
        dbManager.setString(25,prpLregisttgDto.getPhoneNumber());
        dbManager.setString(26,prpLregisttgDto.getLinkerName());
        dbManager.setDateTime(27,prpLregisttgDto.getDamageStartDate());
        dbManager.setString(28,prpLregisttgDto.getDamageStartHour());
        dbManager.setDateTime(29,prpLregisttgDto.getDamageEndDate());
        dbManager.setString(30,prpLregisttgDto.getDamageEndHour());
        dbManager.setString(31,prpLregisttgDto.getDamageCode());
        dbManager.setString(32,prpLregisttgDto.getDamageName());
        dbManager.setString(33,prpLregisttgDto.getDamageTypeCode());
        dbManager.setString(34,prpLregisttgDto.getDamageTypeName());
        dbManager.setString(35,prpLregisttgDto.getFirstSiteFlag());
        dbManager.setString(36,prpLregisttgDto.getDamageAreaCode());
        dbManager.setString(37,prpLregisttgDto.getDamageAreaName());
        dbManager.setString(38,prpLregisttgDto.getDamageAddressType());
        dbManager.setString(39,prpLregisttgDto.getAddressCode());
        dbManager.setString(40,prpLregisttgDto.getDamageAddress());
        dbManager.setString(41,prpLregisttgDto.getDamageAreaPostCode());
        dbManager.setString(42,prpLregisttgDto.getHandleUnit());
        dbManager.setString(43,prpLregisttgDto.getLossName());
        dbManager.setDouble(44,prpLregisttgDto.getLossQuantity());
        dbManager.setString(45,prpLregisttgDto.getUnit());
        dbManager.setString(46,prpLregisttgDto.getEstiCurrency());
        dbManager.setDouble(47,prpLregisttgDto.getEstimateLoss());
        dbManager.setString(48,prpLregisttgDto.getReceiverName());
        dbManager.setString(49,prpLregisttgDto.getHandlerCode());
        dbManager.setString(50,prpLregisttgDto.getHandler1Code());
        dbManager.setString(51,prpLregisttgDto.getComCode());
        dbManager.setDateTime(52,prpLregisttgDto.getInputDate());
        dbManager.setString(53,prpLregisttgDto.getAcceptFlag());
        dbManager.setString(54,prpLregisttgDto.getRepeatInsureFlag());
        dbManager.setString(55,prpLregisttgDto.getClaimType());
        dbManager.setDateTime(56,prpLregisttgDto.getCancelDate());
        dbManager.setString(57,prpLregisttgDto.getDealerCode());
        dbManager.setString(58,prpLregisttgDto.getRemark());
        dbManager.setString(59,prpLregisttgDto.getOperatorCode());
        dbManager.setString(60,prpLregisttgDto.getMakeCom());
        dbManager.setString(61,prpLregisttgDto.getFlag());
        dbManager.setString(62,prpLregisttgDto.getReportorPhoneNumber());
        dbManager.setString(63,prpLregisttgDto.getLinkerPostCode());
        dbManager.setString(64,prpLregisttgDto.getLinkerAddress());
        dbManager.setDouble(65,prpLregisttgDto.getEstimateFee());
        dbManager.setString(66,prpLregisttgDto.getCatastropheCode1());
        dbManager.setString(67,prpLregisttgDto.getCatastropheName1());
        dbManager.setString(68,prpLregisttgDto.getCatastropheCode2());
        dbManager.setString(69,prpLregisttgDto.getCatastropheName2());
        dbManager.setString(70,prpLregisttgDto.getReportFlag());
        dbManager.setDouble(71,prpLregisttgDto.getLossesNumber());
        dbManager.setString(72,prpLregisttgDto.getLossesUnitCode());
        dbManager.setString(73,prpLregisttgDto.getBusinessType());
        dbManager.setString(74,prpLregisttgDto.getBusinessType1());
        dbManager.setString(75,prpLregisttgDto.getIndemnityDuty());
        dbManager.setString(76,prpLregisttgDto.getBusinessFlag());
        dbManager.setString(77,prpLregisttgDto.getOtherFlag());
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregisttgBase insert Success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLregisttg (");
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
            PrpLRegistTgDto prpLregisttgDto = (PrpLRegistTgDto)i.next();
            dbManager.setString(1,prpLregisttgDto.getRegistNo());
            dbManager.setString(2,prpLregisttgDto.getLFlag());
            dbManager.setString(3,prpLregisttgDto.getClassCode());
            dbManager.setString(4,prpLregisttgDto.getRiskCode());
            dbManager.setString(5,prpLregisttgDto.getPolicyNo());
            dbManager.setString(6,prpLregisttgDto.getLanguage());
            dbManager.setString(7,prpLregisttgDto.getInsuredCode());
            dbManager.setString(8,prpLregisttgDto.getInsuredName());
            dbManager.setString(9,prpLregisttgDto.getInsuredAddress());
            dbManager.setString(10,prpLregisttgDto.getClauseType());
            dbManager.setString(11,prpLregisttgDto.getLicenseNo());
            dbManager.setString(12,prpLregisttgDto.getLicenseColorCode());
            dbManager.setString(13,prpLregisttgDto.getCarKindCode());
            dbManager.setString(14,prpLregisttgDto.getModelCode());
            dbManager.setString(15,prpLregisttgDto.getBrandName());
            dbManager.setString(16,prpLregisttgDto.getEngineNo());
            dbManager.setString(17,prpLregisttgDto.getFrameNo());
            dbManager.setDouble(18,prpLregisttgDto.getRunDistance());
            dbManager.setInt(19,prpLregisttgDto.getUseYears());
            dbManager.setDateTime(20,prpLregisttgDto.getReportDate());
            dbManager.setString(21,prpLregisttgDto.getReportHour());
            dbManager.setString(22,prpLregisttgDto.getReportAddress());
            dbManager.setString(23,prpLregisttgDto.getReportorName());
            dbManager.setString(24,prpLregisttgDto.getReportType());
            dbManager.setString(25,prpLregisttgDto.getPhoneNumber());
            dbManager.setString(26,prpLregisttgDto.getLinkerName());
            dbManager.setDateTime(27,prpLregisttgDto.getDamageStartDate());
            dbManager.setString(28,prpLregisttgDto.getDamageStartHour());
            dbManager.setDateTime(29,prpLregisttgDto.getDamageEndDate());
            dbManager.setString(30,prpLregisttgDto.getDamageEndHour());
            dbManager.setString(31,prpLregisttgDto.getDamageCode());
            dbManager.setString(32,prpLregisttgDto.getDamageName());
            dbManager.setString(33,prpLregisttgDto.getDamageTypeCode());
            dbManager.setString(34,prpLregisttgDto.getDamageTypeName());
            dbManager.setString(35,prpLregisttgDto.getFirstSiteFlag());
            dbManager.setString(36,prpLregisttgDto.getDamageAreaCode());
            dbManager.setString(37,prpLregisttgDto.getDamageAreaName());
            dbManager.setString(38,prpLregisttgDto.getDamageAddressType());
            dbManager.setString(39,prpLregisttgDto.getAddressCode());
            dbManager.setString(40,prpLregisttgDto.getDamageAddress());
            dbManager.setString(41,prpLregisttgDto.getDamageAreaPostCode());
            dbManager.setString(42,prpLregisttgDto.getHandleUnit());
            dbManager.setString(43,prpLregisttgDto.getLossName());
            dbManager.setDouble(44,prpLregisttgDto.getLossQuantity());
            dbManager.setString(45,prpLregisttgDto.getUnit());
            dbManager.setString(46,prpLregisttgDto.getEstiCurrency());
            dbManager.setDouble(47,prpLregisttgDto.getEstimateLoss());
            dbManager.setString(48,prpLregisttgDto.getReceiverName());
            dbManager.setString(49,prpLregisttgDto.getHandlerCode());
            dbManager.setString(50,prpLregisttgDto.getHandler1Code());
            dbManager.setString(51,prpLregisttgDto.getComCode());
            dbManager.setDateTime(52,prpLregisttgDto.getInputDate());
            dbManager.setString(53,prpLregisttgDto.getAcceptFlag());
            dbManager.setString(54,prpLregisttgDto.getRepeatInsureFlag());
            dbManager.setString(55,prpLregisttgDto.getClaimType());
            dbManager.setDateTime(56,prpLregisttgDto.getCancelDate());
            dbManager.setString(57,prpLregisttgDto.getDealerCode());
            dbManager.setString(58,prpLregisttgDto.getRemark());
            dbManager.setString(59,prpLregisttgDto.getOperatorCode());
            dbManager.setString(60,prpLregisttgDto.getMakeCom());
            dbManager.setString(61,prpLregisttgDto.getFlag());
            dbManager.setString(62,prpLregisttgDto.getReportorPhoneNumber());
            dbManager.setString(63,prpLregisttgDto.getLinkerPostCode());
            dbManager.setString(64,prpLregisttgDto.getLinkerAddress());
            dbManager.setDouble(65,prpLregisttgDto.getEstimateFee());
            dbManager.setString(66,prpLregisttgDto.getCatastropheCode1());
            dbManager.setString(67,prpLregisttgDto.getCatastropheName1());
            dbManager.setString(68,prpLregisttgDto.getCatastropheCode2());
            dbManager.setString(69,prpLregisttgDto.getCatastropheName2());
            dbManager.setString(70,prpLregisttgDto.getReportFlag());
            dbManager.setDouble(71,prpLregisttgDto.getLossesNumber());
            dbManager.setString(72,prpLregisttgDto.getLossesUnitCode());
            dbManager.setString(73,prpLregisttgDto.getBusinessType());
            dbManager.setString(74,prpLregisttgDto.getBusinessType1());
            dbManager.setString(75,prpLregisttgDto.getIndemnityDuty());
            dbManager.setString(76,prpLregisttgDto.getBusinessFlag());
            dbManager.setString(77,prpLregisttgDto.getOtherFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLregisttgBase insertAll Success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(String registNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLregisttg ");
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
        logger.info("DBPrpLregisttgBase delete Success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLregisttgDto prpLregisttgDto
     * @throws Exception
     */
    public void update(PrpLRegistTgDto prpLregisttgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLregisttg SET ");
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
            debugBuffer.append("UPDATE PrpLregisttg SET ");
            debugBuffer.append("lFlag = '" + prpLregisttgDto.getLFlag() + "', ");
            debugBuffer.append("ClassCode = '" + prpLregisttgDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpLregisttgDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLregisttgDto.getPolicyNo() + "', ");
            debugBuffer.append("Language = '" + prpLregisttgDto.getLanguage() + "', ");
            debugBuffer.append("InsuredCode = '" + prpLregisttgDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpLregisttgDto.getInsuredName() + "', ");
            debugBuffer.append("InsuredAddress = '" + prpLregisttgDto.getInsuredAddress() + "', ");
            debugBuffer.append("ClauseType = '" + prpLregisttgDto.getClauseType() + "', ");
            debugBuffer.append("LicenseNo = '" + prpLregisttgDto.getLicenseNo() + "', ");
            debugBuffer.append("LicenseColorCode = '" + prpLregisttgDto.getLicenseColorCode() + "', ");
            debugBuffer.append("CarKindCode = '" + prpLregisttgDto.getCarKindCode() + "', ");
            debugBuffer.append("ModelCode = '" + prpLregisttgDto.getModelCode() + "', ");
            debugBuffer.append("BrandName = '" + prpLregisttgDto.getBrandName() + "', ");
            debugBuffer.append("EngineNo = '" + prpLregisttgDto.getEngineNo() + "', ");
            debugBuffer.append("FrameNo = '" + prpLregisttgDto.getFrameNo() + "', ");
            debugBuffer.append("RunDistance = " + prpLregisttgDto.getRunDistance() + ", ");
            debugBuffer.append("UseYears = " + prpLregisttgDto.getUseYears() + ", ");
            debugBuffer.append("ReportDate = '" + prpLregisttgDto.getReportDate() + "', ");
            debugBuffer.append("ReportHour = '" + prpLregisttgDto.getReportHour() + "', ");
            debugBuffer.append("ReportAddress = '" + prpLregisttgDto.getReportAddress() + "', ");
            debugBuffer.append("ReportorName = '" + prpLregisttgDto.getReportorName() + "', ");
            debugBuffer.append("ReportType = '" + prpLregisttgDto.getReportType() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpLregisttgDto.getPhoneNumber() + "', ");
            debugBuffer.append("LinkerName = '" + prpLregisttgDto.getLinkerName() + "', ");
            debugBuffer.append("DamageStartDate = '" + prpLregisttgDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLregisttgDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageEndDate = '" + prpLregisttgDto.getDamageEndDate() + "', ");
            debugBuffer.append("DamageEndHour = '" + prpLregisttgDto.getDamageEndHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLregisttgDto.getDamageCode() + "', ");
            debugBuffer.append("DamageName = '" + prpLregisttgDto.getDamageName() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLregisttgDto.getDamageTypeCode() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLregisttgDto.getDamageTypeName() + "', ");
            debugBuffer.append("FirstSiteFlag = '" + prpLregisttgDto.getFirstSiteFlag() + "', ");
            debugBuffer.append("DamageAreaCode = '" + prpLregisttgDto.getDamageAreaCode() + "', ");
            debugBuffer.append("DamageAreaName = '" + prpLregisttgDto.getDamageAreaName() + "', ");
            debugBuffer.append("DamageAddressType = '" + prpLregisttgDto.getDamageAddressType() + "', ");
            debugBuffer.append("AddressCode = '" + prpLregisttgDto.getAddressCode() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLregisttgDto.getDamageAddress() + "', ");
            debugBuffer.append("DamageAreaPostCode = '" + prpLregisttgDto.getDamageAreaPostCode() + "', ");
            debugBuffer.append("HandleUnit = '" + prpLregisttgDto.getHandleUnit() + "', ");
            debugBuffer.append("LossName = '" + prpLregisttgDto.getLossName() + "', ");
            debugBuffer.append("LossQuantity = " + prpLregisttgDto.getLossQuantity() + ", ");
            debugBuffer.append("Unit = '" + prpLregisttgDto.getUnit() + "', ");
            debugBuffer.append("EstiCurrency = '" + prpLregisttgDto.getEstiCurrency() + "', ");
            debugBuffer.append("EstimateLoss = " + prpLregisttgDto.getEstimateLoss() + ", ");
            debugBuffer.append("ReceiverName = '" + prpLregisttgDto.getReceiverName() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLregisttgDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLregisttgDto.getHandler1Code() + "', ");
            debugBuffer.append("ComCode = '" + prpLregisttgDto.getComCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLregisttgDto.getInputDate() + "', ");
            debugBuffer.append("AcceptFlag = '" + prpLregisttgDto.getAcceptFlag() + "', ");
            debugBuffer.append("RepeatInsureFlag = '" + prpLregisttgDto.getRepeatInsureFlag() + "', ");
            debugBuffer.append("ClaimType = '" + prpLregisttgDto.getClaimType() + "', ");
            debugBuffer.append("CancelDate = '" + prpLregisttgDto.getCancelDate() + "', ");
            debugBuffer.append("DealerCode = '" + prpLregisttgDto.getDealerCode() + "', ");
            debugBuffer.append("Remark = '" + prpLregisttgDto.getRemark() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLregisttgDto.getOperatorCode() + "', ");
            debugBuffer.append("MakeCom = '" + prpLregisttgDto.getMakeCom() + "', ");
            debugBuffer.append("Flag = '" + prpLregisttgDto.getFlag() + "', ");
            debugBuffer.append("ReportorPhoneNumber = '" + prpLregisttgDto.getReportorPhoneNumber() + "', ");
            debugBuffer.append("LinkerPostCode = '" + prpLregisttgDto.getLinkerPostCode() + "', ");
            debugBuffer.append("LinkerAddress = '" + prpLregisttgDto.getLinkerAddress() + "', ");
            debugBuffer.append("EstimateFee = " + prpLregisttgDto.getEstimateFee() + ", ");
            debugBuffer.append("CatastropheCode1 = '" + prpLregisttgDto.getCatastropheCode1() + "', ");
            debugBuffer.append("CatastropheName1 = '" + prpLregisttgDto.getCatastropheName1() + "', ");
            debugBuffer.append("CatastropheCode2 = '" + prpLregisttgDto.getCatastropheCode2() + "', ");
            debugBuffer.append("CatastropheName2 = '" + prpLregisttgDto.getCatastropheName2() + "', ");
            debugBuffer.append("ReportFlag = '" + prpLregisttgDto.getReportFlag() + "', ");
            debugBuffer.append("LossesNumber = " + prpLregisttgDto.getLossesNumber()+", ");
            debugBuffer.append("LossesUnitCode = '" + prpLregisttgDto.getLossesUnitCode()+"', ");
            debugBuffer.append("BusinessType = '" + prpLregisttgDto.getBusinessType()+"', ");
            debugBuffer.append("BusinessType1 = '" + prpLregisttgDto.getBusinessType1()+"', ");
            debugBuffer.append("IndemnityDuty = '" + prpLregisttgDto.getIndemnityDuty() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLregisttgDto.getBusinessFlag() + "', ");
            debugBuffer.append("OtherFlag = '" + prpLregisttgDto.getOtherFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("registNo=").append("'").append(prpLregisttgDto.getRegistNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("registNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLregisttgDto.getLFlag());
        dbManager.setString(2,prpLregisttgDto.getClassCode());
        dbManager.setString(3,prpLregisttgDto.getRiskCode());
        dbManager.setString(4,prpLregisttgDto.getPolicyNo());
        dbManager.setString(5,prpLregisttgDto.getLanguage());
        dbManager.setString(6,prpLregisttgDto.getInsuredCode());
        dbManager.setString(7,prpLregisttgDto.getInsuredName());
        dbManager.setString(8,prpLregisttgDto.getInsuredAddress());
        dbManager.setString(9,prpLregisttgDto.getClauseType());
        dbManager.setString(10,prpLregisttgDto.getLicenseNo());
        dbManager.setString(11,prpLregisttgDto.getLicenseColorCode());
        dbManager.setString(12,prpLregisttgDto.getCarKindCode());
        dbManager.setString(13,prpLregisttgDto.getModelCode());
        dbManager.setString(14,prpLregisttgDto.getBrandName());
        dbManager.setString(15,prpLregisttgDto.getEngineNo());
        dbManager.setString(16,prpLregisttgDto.getFrameNo());
        dbManager.setDouble(17,prpLregisttgDto.getRunDistance());
        dbManager.setInt(18,prpLregisttgDto.getUseYears());
        dbManager.setDateTime(19,prpLregisttgDto.getReportDate());
        dbManager.setString(20,prpLregisttgDto.getReportHour());
        dbManager.setString(21,prpLregisttgDto.getReportAddress());
        dbManager.setString(22,prpLregisttgDto.getReportorName());
        dbManager.setString(23,prpLregisttgDto.getReportType());
        dbManager.setString(24,prpLregisttgDto.getPhoneNumber());
        dbManager.setString(25,prpLregisttgDto.getLinkerName());
        dbManager.setDateTime(26,prpLregisttgDto.getDamageStartDate());
        dbManager.setString(27,prpLregisttgDto.getDamageStartHour());
        dbManager.setDateTime(28,prpLregisttgDto.getDamageEndDate());
        dbManager.setString(29,prpLregisttgDto.getDamageEndHour());
        dbManager.setString(30,prpLregisttgDto.getDamageCode());
        dbManager.setString(31,prpLregisttgDto.getDamageName());
        dbManager.setString(32,prpLregisttgDto.getDamageTypeCode());
        dbManager.setString(33,prpLregisttgDto.getDamageTypeName());
        dbManager.setString(34,prpLregisttgDto.getFirstSiteFlag());
        dbManager.setString(35,prpLregisttgDto.getDamageAreaCode());
        dbManager.setString(36,prpLregisttgDto.getDamageAreaName());
        dbManager.setString(37,prpLregisttgDto.getDamageAddressType());
        dbManager.setString(38,prpLregisttgDto.getAddressCode());
        dbManager.setString(39,prpLregisttgDto.getDamageAddress());
        dbManager.setString(40,prpLregisttgDto.getDamageAreaPostCode());
        dbManager.setString(41,prpLregisttgDto.getHandleUnit());
        dbManager.setString(42,prpLregisttgDto.getLossName());
        dbManager.setDouble(43,prpLregisttgDto.getLossQuantity());
        dbManager.setString(44,prpLregisttgDto.getUnit());
        dbManager.setString(45,prpLregisttgDto.getEstiCurrency());
        dbManager.setDouble(46,prpLregisttgDto.getEstimateLoss());
        dbManager.setString(47,prpLregisttgDto.getReceiverName());
        dbManager.setString(48,prpLregisttgDto.getHandlerCode());
        dbManager.setString(49,prpLregisttgDto.getHandler1Code());
        dbManager.setString(50,prpLregisttgDto.getComCode());
        dbManager.setDateTime(51,prpLregisttgDto.getInputDate());
        dbManager.setString(52,prpLregisttgDto.getAcceptFlag());
        dbManager.setString(53,prpLregisttgDto.getRepeatInsureFlag());
        dbManager.setString(54,prpLregisttgDto.getClaimType());
        dbManager.setDateTime(55,prpLregisttgDto.getCancelDate());
        dbManager.setString(56,prpLregisttgDto.getDealerCode());
        dbManager.setString(57,prpLregisttgDto.getRemark());
        dbManager.setString(58,prpLregisttgDto.getOperatorCode());
        dbManager.setString(59,prpLregisttgDto.getMakeCom());
        dbManager.setString(60,prpLregisttgDto.getFlag());
        dbManager.setString(61,prpLregisttgDto.getReportorPhoneNumber());
        dbManager.setString(62,prpLregisttgDto.getLinkerPostCode());
        dbManager.setString(63,prpLregisttgDto.getLinkerAddress());
        dbManager.setDouble(64,prpLregisttgDto.getEstimateFee());
        dbManager.setString(65,prpLregisttgDto.getCatastropheCode1());
        dbManager.setString(66,prpLregisttgDto.getCatastropheName1());
        dbManager.setString(67,prpLregisttgDto.getCatastropheCode2());
        dbManager.setString(68,prpLregisttgDto.getCatastropheName2());
        dbManager.setString(69,prpLregisttgDto.getReportFlag());
        dbManager.setDouble(70,prpLregisttgDto.getLossesNumber());
        dbManager.setString(71,prpLregisttgDto.getLossesUnitCode());
        dbManager.setString(72,prpLregisttgDto.getBusinessType());
        dbManager.setString(73,prpLregisttgDto.getBusinessType1());
        dbManager.setString(74,prpLregisttgDto.getIndemnityDuty());
        dbManager.setString(75,prpLregisttgDto.getBusinessFlag());
        dbManager.setString(76,prpLregisttgDto.getOtherFlag());
        //设置条件字段;
        dbManager.setString(77,prpLregisttgDto.getRegistNo());
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregisttgBase update Success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @return PrpLRegistTgDto
     * @throws Exception
     */
    public PrpLRegistTgDto findByPrimaryKey(String registNo)
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
        buffer.append("FROM PrpLregisttg ");
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
        PrpLRegistTgDto prpLregisttgDto = null;
        if(resultSet.next()){
            prpLregisttgDto = new PrpLRegistTgDto();
            prpLregisttgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregisttgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregisttgDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregisttgDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregisttgDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregisttgDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregisttgDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregisttgDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregisttgDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregisttgDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregisttgDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregisttgDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregisttgDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregisttgDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregisttgDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregisttgDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregisttgDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregisttgDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregisttgDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregisttgDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregisttgDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregisttgDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregisttgDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregisttgDto.setReportType(dbManager.getString(resultSet,24));
            prpLregisttgDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregisttgDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregisttgDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregisttgDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregisttgDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregisttgDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregisttgDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregisttgDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregisttgDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregisttgDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregisttgDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregisttgDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregisttgDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregisttgDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregisttgDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregisttgDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregisttgDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregisttgDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregisttgDto.setLossName(dbManager.getString(resultSet,43));
            prpLregisttgDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregisttgDto.setUnit(dbManager.getString(resultSet,45));
            prpLregisttgDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregisttgDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregisttgDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregisttgDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregisttgDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregisttgDto.setComCode(dbManager.getString(resultSet,51));
            prpLregisttgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregisttgDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregisttgDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregisttgDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregisttgDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregisttgDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregisttgDto.setRemark(dbManager.getString(resultSet,58));
            prpLregisttgDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregisttgDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregisttgDto.setFlag(dbManager.getString(resultSet,61));
            prpLregisttgDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregisttgDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregisttgDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregisttgDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregisttgDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregisttgDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregisttgDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregisttgDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregisttgDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregisttgDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregisttgDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregisttgDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregisttgDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregisttgDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregisttgDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregisttgDto.setOtherFlag(dbManager.getString(resultSet,77));
        }
        resultSet.close();
        logger.info("DBPrpLregisttgBase findByPrimaryKey Success!");
        return prpLregisttgDto;
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
        buffer.append("FROM PrpLregisttg WHERE ");
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
        PrpLRegistTgDto prpLregisttgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLregisttgDto = new PrpLRegistTgDto();
            prpLregisttgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregisttgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregisttgDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregisttgDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregisttgDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregisttgDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregisttgDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregisttgDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregisttgDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregisttgDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregisttgDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregisttgDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregisttgDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregisttgDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregisttgDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregisttgDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregisttgDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregisttgDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregisttgDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregisttgDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregisttgDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregisttgDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregisttgDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregisttgDto.setReportType(dbManager.getString(resultSet,24));
            prpLregisttgDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregisttgDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregisttgDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregisttgDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregisttgDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregisttgDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregisttgDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregisttgDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregisttgDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregisttgDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregisttgDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregisttgDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregisttgDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregisttgDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregisttgDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregisttgDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregisttgDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregisttgDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregisttgDto.setLossName(dbManager.getString(resultSet,43));
            prpLregisttgDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregisttgDto.setUnit(dbManager.getString(resultSet,45));
            prpLregisttgDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregisttgDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregisttgDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregisttgDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregisttgDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregisttgDto.setComCode(dbManager.getString(resultSet,51));
            prpLregisttgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregisttgDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregisttgDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregisttgDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregisttgDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregisttgDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregisttgDto.setRemark(dbManager.getString(resultSet,58));
            prpLregisttgDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregisttgDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregisttgDto.setFlag(dbManager.getString(resultSet,61));
            prpLregisttgDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregisttgDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregisttgDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregisttgDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregisttgDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregisttgDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregisttgDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregisttgDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregisttgDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregisttgDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregisttgDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregisttgDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregisttgDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregisttgDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregisttgDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregisttgDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregisttgDto);
        }
        resultSet.close();
        logger.info("DBPrpLregisttgBase findByConditions Success!");
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
        buffer.append("distinct PrpLregisttg.registNo,");
        buffer.append("PrpLregisttg.lFlag,");
        buffer.append("PrpLregisttg.ClassCode,");
        buffer.append("PrpLregisttg.RiskCode,");
        buffer.append("PrpLregisttg.PolicyNo,");
        buffer.append("PrpLregisttg.Language,");
        buffer.append("PrpLregisttg.InsuredCode,");
        buffer.append("PrpLregisttg.InsuredName,");
        buffer.append("PrpLregisttg.InsuredAddress,");
        buffer.append("PrpLregisttg.ClauseType,");
        buffer.append("PrpLregisttg.LicenseNo,");
        buffer.append("PrpLregisttg.LicenseColorCode,");
        buffer.append("PrpLregisttg.CarKindCode,");
        buffer.append("PrpLregisttg.ModelCode,");
        buffer.append("PrpLregisttg.BrandName,");
        buffer.append("PrpLregisttg.EngineNo,");
        buffer.append("PrpLregisttg.FrameNo,");
        buffer.append("PrpLregisttg.RunDistance,");
        buffer.append("PrpLregisttg.UseYears,");
        buffer.append("PrpLregisttg.ReportDate,");
        buffer.append("PrpLregisttg.ReportHour,");
        buffer.append("PrpLregisttg.ReportAddress,");
        buffer.append("PrpLregisttg.ReportorName,");
        buffer.append("PrpLregisttg.ReportType,");
        buffer.append("PrpLregisttg.PhoneNumber,");
        buffer.append("PrpLregisttg.LinkerName,");
        buffer.append("PrpLregisttg.DamageStartDate,");
        buffer.append("PrpLregisttg.DamageStartHour,");
        buffer.append("PrpLregisttg.DamageEndDate,");
        buffer.append("PrpLregisttg.DamageEndHour,");
        buffer.append("PrpLregisttg.DamageCode,");
        buffer.append("PrpLregisttg.DamageName,");
        buffer.append("PrpLregisttg.DamageTypeCode,");
        buffer.append("PrpLregisttg.DamageTypeName,");
        buffer.append("PrpLregisttg.FirstSiteFlag,");
        buffer.append("PrpLregisttg.DamageAreaCode,");
        buffer.append("PrpLregisttg.DamageAreaName,");
        buffer.append("PrpLregisttg.DamageAddressType,");
        buffer.append("PrpLregisttg.AddressCode,");
        buffer.append("PrpLregisttg.DamageAddress,");
        buffer.append("PrpLregisttg.DamageAreaPostCode,");
        buffer.append("PrpLregisttg.HandleUnit,");
        buffer.append("PrpLregisttg.LossName,");
        buffer.append("PrpLregisttg.LossQuantity,");
        buffer.append("PrpLregisttg.Unit,");
        buffer.append("PrpLregisttg.EstiCurrency,");
        buffer.append("PrpLregisttg.EstimateLoss,");
        buffer.append("PrpLregisttg.ReceiverName,");
        buffer.append("PrpLregisttg.HandlerCode,");
        buffer.append("PrpLregisttg.Handler1Code,");
        buffer.append("PrpLregisttg.ComCode,");
        buffer.append("PrpLregisttg.InputDate,");
        buffer.append("PrpLregisttg.AcceptFlag,");
        buffer.append("PrpLregisttg.RepeatInsureFlag,");
        buffer.append("PrpLregisttg.ClaimType,");
        buffer.append("PrpLregisttg.CancelDate,");
        buffer.append("PrpLregisttg.DealerCode,");
        buffer.append("PrpLregisttg.Remark,");
        buffer.append("PrpLregisttg.OperatorCode,");
        buffer.append("PrpLregisttg.MakeCom,");
        buffer.append("PrpLregisttg.Flag,");
        buffer.append("PrpLregisttg.ReportorPhoneNumber,");
        buffer.append("PrpLregisttg.LinkerPostCode,");
        buffer.append("PrpLregisttg.LinkerAddress,");
        buffer.append("PrpLregisttg.EstimateFee,");
        buffer.append("PrpLregisttg.CatastropheCode1,");
        buffer.append("PrpLregisttg.CatastropheName1,");
        buffer.append("PrpLregisttg.CatastropheCode2,");
        buffer.append("PrpLregisttg.CatastropheName2,");
        buffer.append("PrpLregisttg.ReportFlag,");
        buffer.append("PrpLregisttg.LossesNumber,");
        buffer.append("PrpLregisttg.LossesUnitCode,");
        buffer.append("PrpLregisttg.BusinessType,");
        buffer.append("PrpLregisttg.BusinessType1,");
        buffer.append("PrpLregisttg.IndemnityDuty, ");
        buffer.append("PrpLregisttg.BusinessFlag, ");
        buffer.append("PrpLregisttg.OtherFlag ");
        buffer.append("FROM PrpLregisttg,prplcompensatehousetg WHERE PrpLregisttg.registno=prplcompensatehousetg.registno and prplcompensatehousetg.nodetype='regis' and ");
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
        PrpLRegistTgDto prpLregisttgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLregisttgDto = new PrpLRegistTgDto();
            prpLregisttgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregisttgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregisttgDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregisttgDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregisttgDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregisttgDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregisttgDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregisttgDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregisttgDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregisttgDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregisttgDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregisttgDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregisttgDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregisttgDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregisttgDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregisttgDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregisttgDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregisttgDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregisttgDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregisttgDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregisttgDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregisttgDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregisttgDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregisttgDto.setReportType(dbManager.getString(resultSet,24));
            prpLregisttgDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregisttgDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregisttgDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregisttgDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregisttgDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregisttgDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregisttgDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregisttgDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregisttgDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregisttgDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregisttgDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregisttgDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregisttgDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregisttgDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregisttgDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregisttgDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregisttgDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregisttgDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregisttgDto.setLossName(dbManager.getString(resultSet,43));
            prpLregisttgDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregisttgDto.setUnit(dbManager.getString(resultSet,45));
            prpLregisttgDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregisttgDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregisttgDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregisttgDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregisttgDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregisttgDto.setComCode(dbManager.getString(resultSet,51));
            prpLregisttgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregisttgDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregisttgDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregisttgDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregisttgDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregisttgDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregisttgDto.setRemark(dbManager.getString(resultSet,58));
            prpLregisttgDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregisttgDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregisttgDto.setFlag(dbManager.getString(resultSet,61));
            prpLregisttgDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregisttgDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregisttgDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregisttgDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregisttgDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregisttgDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregisttgDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregisttgDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregisttgDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregisttgDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregisttgDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregisttgDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregisttgDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregisttgDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregisttgDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregisttgDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregisttgDto);
        }
        resultSet.close();
        logger.info("DBPrpLregisttgBase findByConditions Success!");
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
        buffer.append("DELETE FROM PrpLregisttg WHERE ");
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
          statement = "SELECT count(1) FROM PrpLregisttg WHERE ";
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
     * @return PrpLRegistTgDto
     * @throws Exception
     */
    public PrpLRegistTgDto findByPrimaryKeyToLinkManInfo(String registNo)
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
        buffer.append("FROM PrpLregisttg ");
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
        PrpLRegistTgDto prpLregisttgDto = null;
        if(resultSet.next()){
            prpLregisttgDto = new PrpLRegistTgDto();
            prpLregisttgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregisttgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLregisttgDto.setReportorName(dbManager.getString(resultSet,3));
            prpLregisttgDto.setReportorPhoneNumber(dbManager.getString(resultSet,4));
            prpLregisttgDto.setInsuredName(dbManager.getString(resultSet,5));
            prpLregisttgDto.setInsuredPhone(dbManager.getString(resultSet,6));
            prpLregisttgDto.setInsuredMobilePhone(dbManager.getString(resultSet,7));
            prpLregisttgDto.setDriverName(dbManager.getString(resultSet,8));
            prpLregisttgDto.setDriverPhone(dbManager.getString(resultSet,9));
            prpLregisttgDto.setLinkerName(dbManager.getString(resultSet,10));
            prpLregisttgDto.setPhoneNumber(dbManager.getString(resultSet,11));
            prpLregisttgDto.setClassCode(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        logger.info("DBPrpLregisttgBase findByPrimaryKey Success!");
        return prpLregisttgDto;
    }
}
