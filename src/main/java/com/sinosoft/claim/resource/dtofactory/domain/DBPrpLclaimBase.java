package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaim-立案基本信息表的数据访问对象基类<br>
 * 创建于 2005-08-03 13:52:44.109<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(PrpLclaimDto prpLclaimDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaim (");
        buffer.append("ClaimNo,");
        buffer.append("LFlag,");
        buffer.append("CaseNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("Currency,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("SumQuantity,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("DamageKind,");
        buffer.append("ClaimDate,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("DeductibleRate,");
        buffer.append("SumClaim,");
        buffer.append("SumDefLoss,");
        buffer.append("SumPaid,");
        buffer.append("SumReplevy,");
        buffer.append("Remark,");
        buffer.append("CaseType,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("AgentCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("EndCaseDate,");
        buffer.append("EndCaserCode,");
        buffer.append("CancelDate,");
        buffer.append("CancelReason,");
        buffer.append("DealerCode,");
        buffer.append("EscapeFlag,");
        buffer.append("Flag,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("EndCaseFlag,");
        buffer.append("cIndemnityDutyRate,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("ClaimType,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("DamageInsured,");
        buffer.append("DisasterArea,");
        buffer.append("DisasterUnit,");
        buffer.append("AffectedArea,");
        buffer.append("AffectedUnit,");
        buffer.append("NoProductionArea,");
        buffer.append("NoProductionUnit,");
        buffer.append("DeathQuantity,");
        buffer.append("DeathUnit,");
        buffer.append("KillQuantity,");
        buffer.append("KillUnit,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("CatastropheName2,");
        buffer.append("MedicalType, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag, ");
        buffer.append("CancelReasonExplan, ");
        buffer.append("claimTime ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getLFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCaseNo()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getBusinessNature()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getLanguage()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getPolicyType()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getStartDate()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getStartHour()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getEndDate()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getEndHour()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getSumAmount()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumPremium()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageEndDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageEndHour()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageAreaCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageAreaName()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageAddressType()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getAddressCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getLossName()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getDamageKind()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getClaimDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getIndemnityDuty()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getIndemnityDutyRate()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumClaim()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumDefLoss()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumPaid()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getSumReplevy()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getAgentCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getStatisticsYM()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getEndCaseDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getEndCaserCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCancelDate()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCancelReason()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getDealerCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getEscapeFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getReplevyFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getThirdComFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getEndCaseFlag()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getCIndemnityDutyRate()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getDamageAreaPostCode()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCatastropheCode1()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCatastropheName1()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCatastropheCode2()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getClaimType()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getLossesUnitCode()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getDamageInsured()).append(",");
            debugBuffer.append("").append(prpLclaimDto.getDisasterArea()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getDisasterUnit()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getAffectedArea()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getAffectedUnit()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getNoProductionArea()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getNoProductionUnit()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getDeathQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getDeathUnit()).append("',");
            debugBuffer.append("").append(prpLclaimDto.getKillQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimDto.getKillUnit()).append("',"); 
            debugBuffer.append("'").append(prpLclaimDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getBusinessType1()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCatastropheName2()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getMedicalType()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getBusinessFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getOtherFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimDto.getCancelReasonExplan()).append("')");
            debugBuffer.append("'").append(prpLclaimDto.getClaimTime()).append("',");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimDto.getClaimNo());
        dbManager.setString(2,prpLclaimDto.getLFlag());
        dbManager.setString(3,prpLclaimDto.getCaseNo());
        dbManager.setString(4,prpLclaimDto.getClassCode());
        dbManager.setString(5,prpLclaimDto.getRiskCode());
        dbManager.setString(6,prpLclaimDto.getRegistNo());
        dbManager.setString(7,prpLclaimDto.getPolicyNo());
        dbManager.setString(8,prpLclaimDto.getBusinessNature());
        dbManager.setString(9,prpLclaimDto.getLanguage());
        dbManager.setString(10,prpLclaimDto.getPolicyType());
        dbManager.setString(11,prpLclaimDto.getInsuredCode());
        dbManager.setString(12,prpLclaimDto.getInsuredName());
        dbManager.setDateTime(13,prpLclaimDto.getStartDate());
        dbManager.setInt(14,prpLclaimDto.getStartHour());
        dbManager.setDateTime(15,prpLclaimDto.getEndDate());
        dbManager.setInt(16,prpLclaimDto.getEndHour());
        dbManager.setString(17,prpLclaimDto.getCurrency());
        dbManager.setDouble(18,prpLclaimDto.getSumAmount());
        dbManager.setDouble(19,prpLclaimDto.getSumPremium());
        dbManager.setInt(20,prpLclaimDto.getSumQuantity());
        dbManager.setDateTime(21,prpLclaimDto.getDamageStartDate());
        dbManager.setString(22,prpLclaimDto.getDamageStartHour());
        dbManager.setDateTime(23,prpLclaimDto.getDamageEndDate());
        dbManager.setString(24,prpLclaimDto.getDamageEndHour());
        dbManager.setString(25,prpLclaimDto.getDamageCode());
        dbManager.setString(26,prpLclaimDto.getDamageName());
        dbManager.setString(27,prpLclaimDto.getDamageTypeCode());
        dbManager.setString(28,prpLclaimDto.getDamageTypeName());
        dbManager.setString(29,prpLclaimDto.getDamageAreaCode());
        dbManager.setString(30,prpLclaimDto.getDamageAreaName());
        dbManager.setString(31,prpLclaimDto.getDamageAddressType());
        dbManager.setString(32,prpLclaimDto.getAddressCode());
        dbManager.setString(33,prpLclaimDto.getDamageAddress());
        dbManager.setString(34,prpLclaimDto.getLossName());
        dbManager.setInt(35,prpLclaimDto.getLossQuantity());
        dbManager.setString(36,prpLclaimDto.getDamageKind());
        dbManager.setDateTime(37,prpLclaimDto.getClaimDate());
        dbManager.setString(38,prpLclaimDto.getIndemnityDuty());
        dbManager.setDouble(39,prpLclaimDto.getIndemnityDutyRate());
        dbManager.setDouble(40,prpLclaimDto.getDeductibleRate());
        dbManager.setDouble(41,prpLclaimDto.getSumClaim());
        dbManager.setDouble(42,prpLclaimDto.getSumDefLoss());
        dbManager.setDouble(43,prpLclaimDto.getSumPaid());
        dbManager.setDouble(44,prpLclaimDto.getSumReplevy());
        dbManager.setString(45,prpLclaimDto.getRemark());
        dbManager.setString(46,prpLclaimDto.getCaseType());
        dbManager.setString(47,prpLclaimDto.getMakeCom());
        dbManager.setString(48,prpLclaimDto.getComCode());
        dbManager.setString(49,prpLclaimDto.getAgentCode());
        dbManager.setString(50,prpLclaimDto.getHandlerCode());
        dbManager.setString(51,prpLclaimDto.getHandler1Code());
        dbManager.setDateTime(52,prpLclaimDto.getStatisticsYM());
        dbManager.setString(53,prpLclaimDto.getOperatorCode());
        dbManager.setDateTime(54,prpLclaimDto.getInputDate());
        dbManager.setDateTime(55,prpLclaimDto.getEndCaseDate());
        dbManager.setString(56,prpLclaimDto.getEndCaserCode());
        dbManager.setDateTime(57,prpLclaimDto.getCancelDate());
        dbManager.setString(58,prpLclaimDto.getCancelReason());
        dbManager.setString(59,prpLclaimDto.getDealerCode());
        dbManager.setString(60,prpLclaimDto.getEscapeFlag());
        dbManager.setString(61,prpLclaimDto.getFlag());
        dbManager.setString(62,prpLclaimDto.getReplevyFlag());
        dbManager.setString(63,prpLclaimDto.getThirdComFlag());
        dbManager.setString(64,prpLclaimDto.getEndCaseFlag());
        dbManager.setDouble(65,prpLclaimDto.getCIndemnityDutyRate());
        dbManager.setString(66,prpLclaimDto.getDamageAreaPostCode());
        dbManager.setString(67,prpLclaimDto.getCatastropheCode1());
        dbManager.setString(68,prpLclaimDto.getCatastropheName1());
        dbManager.setString(69,prpLclaimDto.getCatastropheCode2());
        dbManager.setString(70,prpLclaimDto.getClaimType());
        dbManager.setDouble(71,prpLclaimDto.getLossesNumber());
        dbManager.setString(72,prpLclaimDto.getLossesUnitCode());
        dbManager.setDouble(73,prpLclaimDto.getDamageInsured());
        dbManager.setDouble(74,prpLclaimDto.getDisasterArea());
        dbManager.setString(75,prpLclaimDto.getDisasterUnit());
        dbManager.setDouble(76,prpLclaimDto.getAffectedArea());
        dbManager.setString(77,prpLclaimDto.getAffectedUnit());
        dbManager.setDouble(78,prpLclaimDto.getNoProductionArea());
        dbManager.setString(79,prpLclaimDto.getNoProductionUnit());        
        dbManager.setDouble(80,prpLclaimDto.getDeathQuantity());
        dbManager.setString(81,prpLclaimDto.getDeathUnit());
        dbManager.setDouble(82,prpLclaimDto.getKillQuantity());
        dbManager.setString(83,prpLclaimDto.getKillUnit());
        dbManager.setString(84,prpLclaimDto.getBusinessType());
        dbManager.setString(85,prpLclaimDto.getBusinessType1());
        dbManager.setString(86,prpLclaimDto.getCatastropheName2());
        dbManager.setString(87,prpLclaimDto.getMedicalType());
        dbManager.setString(88,prpLclaimDto.getBusinessFlag());
        dbManager.setString(89,prpLclaimDto.getOtherFlag());
        dbManager.setString(90,prpLclaimDto.getCancelReasonExplan());
        dbManager.setDateTime(91,prpLclaimDto.getClaimTime());
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
        buffer.append("INSERT INTO PrpLclaim (");
        buffer.append("ClaimNo,");
        buffer.append("LFlag,");
        buffer.append("CaseNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("Currency,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("SumQuantity,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("DamageKind,");
        buffer.append("ClaimDate,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("DeductibleRate,");
        buffer.append("SumClaim,");
        buffer.append("SumDefLoss,");
        buffer.append("SumPaid,");
        buffer.append("SumReplevy,");
        buffer.append("Remark,");
        buffer.append("CaseType,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("AgentCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("EndCaseDate,");
        buffer.append("EndCaserCode,");
        buffer.append("CancelDate,");
        buffer.append("CancelReason,");
        buffer.append("DealerCode,");
        buffer.append("EscapeFlag,");
        buffer.append("Flag,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("EndCaseFlag,");
        buffer.append("cIndemnityDutyRate,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("ClaimType,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("DamageInsured,");
        buffer.append("DisasterArea,");
        buffer.append("DisasterUnit,");
        buffer.append("AffectedArea,");
        buffer.append("AffectedUnit,");
        buffer.append("NoProductionArea,");
        buffer.append("NoProductionUnit,");
        buffer.append("DeathQuantity,");
        buffer.append("DeathUnit,");
        buffer.append("KillQuantity,");
        buffer.append("KillUnit,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("CatastropheName2,");
        buffer.append("MedicalType, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag, ");
        buffer.append("CancelReasonExplan, ");
        buffer.append("ClaimTime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimDto prpLclaimDto = (PrpLclaimDto)i.next();
            dbManager.setString(1,prpLclaimDto.getClaimNo());
            dbManager.setString(2,prpLclaimDto.getLFlag());
            dbManager.setString(3,prpLclaimDto.getCaseNo());
            dbManager.setString(4,prpLclaimDto.getClassCode());
            dbManager.setString(5,prpLclaimDto.getRiskCode());
            dbManager.setString(6,prpLclaimDto.getRegistNo());
            dbManager.setString(7,prpLclaimDto.getPolicyNo());
            dbManager.setString(8,prpLclaimDto.getBusinessNature());
            dbManager.setString(9,prpLclaimDto.getLanguage());
            dbManager.setString(10,prpLclaimDto.getPolicyType());
            dbManager.setString(11,prpLclaimDto.getInsuredCode());
            dbManager.setString(12,prpLclaimDto.getInsuredName());
            dbManager.setDateTime(13,prpLclaimDto.getStartDate());
            dbManager.setInt(14,prpLclaimDto.getStartHour());
            dbManager.setDateTime(15,prpLclaimDto.getEndDate());
            dbManager.setInt(16,prpLclaimDto.getEndHour());
            dbManager.setString(17,prpLclaimDto.getCurrency());
            dbManager.setDouble(18,prpLclaimDto.getSumAmount());
            dbManager.setDouble(19,prpLclaimDto.getSumPremium());
            dbManager.setInt(20,prpLclaimDto.getSumQuantity());
            dbManager.setDateTime(21,prpLclaimDto.getDamageStartDate());
            dbManager.setString(22,prpLclaimDto.getDamageStartHour());
            dbManager.setDateTime(23,prpLclaimDto.getDamageEndDate());
            dbManager.setString(24,prpLclaimDto.getDamageEndHour());
            dbManager.setString(25,prpLclaimDto.getDamageCode());
            dbManager.setString(26,prpLclaimDto.getDamageName());
            dbManager.setString(27,prpLclaimDto.getDamageTypeCode());
            dbManager.setString(28,prpLclaimDto.getDamageTypeName());
            dbManager.setString(29,prpLclaimDto.getDamageAreaCode());
            dbManager.setString(30,prpLclaimDto.getDamageAreaName());
            dbManager.setString(31,prpLclaimDto.getDamageAddressType());
            dbManager.setString(32,prpLclaimDto.getAddressCode());
            dbManager.setString(33,prpLclaimDto.getDamageAddress());
            dbManager.setString(34,prpLclaimDto.getLossName());
            dbManager.setInt(35,prpLclaimDto.getLossQuantity());
            dbManager.setString(36,prpLclaimDto.getDamageKind());
            dbManager.setDateTime(37,prpLclaimDto.getClaimDate());
            dbManager.setString(38,prpLclaimDto.getIndemnityDuty());
            dbManager.setDouble(39,prpLclaimDto.getIndemnityDutyRate());
            dbManager.setDouble(40,prpLclaimDto.getDeductibleRate());
            dbManager.setDouble(41,prpLclaimDto.getSumClaim());
            dbManager.setDouble(42,prpLclaimDto.getSumDefLoss());
            dbManager.setDouble(43,prpLclaimDto.getSumPaid());
            dbManager.setDouble(44,prpLclaimDto.getSumReplevy());
            dbManager.setString(45,prpLclaimDto.getRemark());
            dbManager.setString(46,prpLclaimDto.getCaseType());
            dbManager.setString(47,prpLclaimDto.getMakeCom());
            dbManager.setString(48,prpLclaimDto.getComCode());
            dbManager.setString(49,prpLclaimDto.getAgentCode());
            dbManager.setString(50,prpLclaimDto.getHandlerCode());
            dbManager.setString(51,prpLclaimDto.getHandler1Code());
            dbManager.setDateTime(52,prpLclaimDto.getStatisticsYM());
            dbManager.setString(53,prpLclaimDto.getOperatorCode());
            dbManager.setDateTime(54,prpLclaimDto.getInputDate());
            dbManager.setDateTime(55,prpLclaimDto.getEndCaseDate());
            dbManager.setString(56,prpLclaimDto.getEndCaserCode());
            dbManager.setDateTime(57,prpLclaimDto.getCancelDate());
            dbManager.setString(58,prpLclaimDto.getCancelReason());
            dbManager.setString(59,prpLclaimDto.getDealerCode());
            dbManager.setString(60,prpLclaimDto.getEscapeFlag());
            dbManager.setString(61,prpLclaimDto.getFlag());
            dbManager.setString(62,prpLclaimDto.getReplevyFlag());
            dbManager.setString(63,prpLclaimDto.getThirdComFlag());
            dbManager.setString(64,prpLclaimDto.getEndCaseFlag());
            dbManager.setDouble(65,prpLclaimDto.getCIndemnityDutyRate());
            dbManager.setString(66,prpLclaimDto.getDamageAreaPostCode());
            dbManager.setString(67,prpLclaimDto.getCatastropheCode1());
            dbManager.setString(68,prpLclaimDto.getCatastropheName1());
            dbManager.setString(69,prpLclaimDto.getCatastropheCode2());
            dbManager.setString(70,prpLclaimDto.getClaimType());
            dbManager.setDouble(71,prpLclaimDto.getLossesNumber());
            dbManager.setString(72,prpLclaimDto.getLossesUnitCode());
            dbManager.setDouble(73,prpLclaimDto.getDamageInsured());
            dbManager.setDouble(74,prpLclaimDto.getDisasterArea());
            dbManager.setString(75,prpLclaimDto.getDisasterUnit());
            dbManager.setDouble(76,prpLclaimDto.getAffectedArea());
            dbManager.setString(77,prpLclaimDto.getAffectedUnit());
            dbManager.setDouble(78,prpLclaimDto.getNoProductionArea());
            dbManager.setString(79,prpLclaimDto.getNoProductionUnit());
            dbManager.setDouble(80,prpLclaimDto.getDeathQuantity());
            dbManager.setString(81,prpLclaimDto.getDeathUnit());
            dbManager.setDouble(82,prpLclaimDto.getKillQuantity());
            dbManager.setString(83,prpLclaimDto.getKillUnit());
            dbManager.setString(84,prpLclaimDto.getBusinessType());
            dbManager.setString(85,prpLclaimDto.getBusinessType1());
            dbManager.setString(86,prpLclaimDto.getCatastropheName2());
            dbManager.setString(87,prpLclaimDto.getMedicalType());
            dbManager.setString(88,prpLclaimDto.getBusinessFlag());
            dbManager.setString(89,prpLclaimDto.getOtherFlag());
            dbManager.setString(90,prpLclaimDto.getCancelReasonExplan());
            dbManager.setDateTime(91,prpLclaimDto.getClaimTime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(String claimNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaim ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(PrpLclaimDto prpLclaimDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaim SET ");
        buffer.append("LFlag = ?, ");
        buffer.append("CaseNo = ?, ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("RegistNo = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("BusinessNature = ?, ");
        buffer.append("Language = ?, ");
        buffer.append("PolicyType = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("StartHour = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("EndHour = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumAmount = ?, ");
        buffer.append("SumPremium = ?, ");
        buffer.append("SumQuantity = ?, ");
        buffer.append("DamageStartDate = ?, ");
        buffer.append("DamageStartHour = ?, ");
        buffer.append("DamageEndDate = ?, ");
        buffer.append("DamageEndHour = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("DamageName = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("DamageTypeName = ?, ");
        buffer.append("DamageAreaCode = ?, ");
        buffer.append("DamageAreaName = ?, ");
        buffer.append("DamageAddressType = ?, ");
        buffer.append("AddressCode = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("LossName = ?, ");
        buffer.append("LossQuantity = ?, ");
        buffer.append("DamageKind = ?, ");
        buffer.append("ClaimDate = ?, ");
        buffer.append("IndemnityDuty = ?, ");
        buffer.append("IndemnityDutyRate = ?, ");
        buffer.append("DeductibleRate = ?, ");
        buffer.append("SumClaim = ?, ");
        buffer.append("SumDefLoss = ?, ");
        buffer.append("SumPaid = ?, ");
        buffer.append("SumReplevy = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("CaseType = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("AgentCode = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("Handler1Code = ?, ");
        buffer.append("StatisticsYM = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("EndCaseDate = ?, ");
        buffer.append("EndCaserCode = ?, ");
        buffer.append("CancelDate = ?, ");
        buffer.append("CancelReason = ?, ");
        buffer.append("DealerCode = ?, ");
        buffer.append("EscapeFlag = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ReplevyFlag = ?, ");
        buffer.append("ThirdComFlag = ?, ");
        buffer.append("EndCaseFlag = ?, ");
        buffer.append("cIndemnityDutyRate = ?, ");
        buffer.append("DamageAreaPostCode = ?, ");
        buffer.append("CatastropheCode1 = ?, ");
        buffer.append("CatastropheName1 = ?, ");
        buffer.append("CatastropheCode2 = ?, ");
        buffer.append("ClaimType = ?, ");
        buffer.append("LossesNumber = ?, ");
        buffer.append("LossesUnitCode = ?, ");
        buffer.append("DamageInsured = ?, ");
        buffer.append("DisasterArea = ?, ");
        buffer.append("DisasterUnit = ?, ");
        buffer.append("AffectedArea = ?, ");
        buffer.append("AffectedUnit = ?, ");
        buffer.append("NoProductionArea = ?, ");
        buffer.append("NoProductionUnit = ?, ");     
        buffer.append("DeathQuantity = ?, ");
        buffer.append("DeathUnit = ?, ");
        buffer.append("KillQuantity = ?, ");
        buffer.append("KillUnit = ?, ");
        buffer.append("BusinessType = ?, ");
        buffer.append("BusinessType1 = ?, ");
        buffer.append("CatastropheName2 = ?, ");
        buffer.append("MedicalType = ?, ");
        buffer.append("BusinessFlag = ?, ");
        buffer.append("OtherFlag = ?, ");
        buffer.append("CancelReasonExplan = ?, ");
        buffer.append("ClaimTime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaim SET ");
            debugBuffer.append("LFlag = '" + prpLclaimDto.getLFlag() + "', ");
            debugBuffer.append("CaseNo = '" + prpLclaimDto.getCaseNo() + "', ");
            debugBuffer.append("ClassCode = '" + prpLclaimDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpLclaimDto.getRiskCode() + "', ");
            debugBuffer.append("RegistNo = '" + prpLclaimDto.getRegistNo() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLclaimDto.getPolicyNo() + "', ");
            debugBuffer.append("BusinessNature = '" + prpLclaimDto.getBusinessNature() + "', ");
            debugBuffer.append("Language = '" + prpLclaimDto.getLanguage() + "', ");
            debugBuffer.append("PolicyType = '" + prpLclaimDto.getPolicyType() + "', ");
            debugBuffer.append("InsuredCode = '" + prpLclaimDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpLclaimDto.getInsuredName() + "', ");
            debugBuffer.append("StartDate = '" + prpLclaimDto.getStartDate() + "', ");
            debugBuffer.append("StartHour = " + prpLclaimDto.getStartHour() + ", ");
            debugBuffer.append("EndDate = '" + prpLclaimDto.getEndDate() + "', ");
            debugBuffer.append("EndHour = " + prpLclaimDto.getEndHour() + ", ");
            debugBuffer.append("Currency = '" + prpLclaimDto.getCurrency() + "', ");
            debugBuffer.append("SumAmount = " + prpLclaimDto.getSumAmount() + ", ");
            debugBuffer.append("SumPremium = " + prpLclaimDto.getSumPremium() + ", ");
            debugBuffer.append("SumQuantity = " + prpLclaimDto.getSumQuantity() + ", ");
            debugBuffer.append("DamageStartDate = '" + prpLclaimDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLclaimDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageEndDate = '" + prpLclaimDto.getDamageEndDate() + "', ");
            debugBuffer.append("DamageEndHour = '" + prpLclaimDto.getDamageEndHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLclaimDto.getDamageCode() + "', ");
            debugBuffer.append("DamageName = '" + prpLclaimDto.getDamageName() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLclaimDto.getDamageTypeCode() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLclaimDto.getDamageTypeName() + "', ");
            debugBuffer.append("DamageAreaCode = '" + prpLclaimDto.getDamageAreaCode() + "', ");
            debugBuffer.append("DamageAreaName = '" + prpLclaimDto.getDamageAreaName() + "', ");
            debugBuffer.append("DamageAddressType = '" + prpLclaimDto.getDamageAddressType() + "', ");
            debugBuffer.append("AddressCode = '" + prpLclaimDto.getAddressCode() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLclaimDto.getDamageAddress() + "', ");
            debugBuffer.append("LossName = '" + prpLclaimDto.getLossName() + "', ");
            debugBuffer.append("LossQuantity = " + prpLclaimDto.getLossQuantity() + ", ");
            debugBuffer.append("DamageKind = '" + prpLclaimDto.getDamageKind() + "', ");
            debugBuffer.append("ClaimDate = '" + prpLclaimDto.getClaimDate() + "', ");
            debugBuffer.append("IndemnityDuty = '" + prpLclaimDto.getIndemnityDuty() + "', ");
            debugBuffer.append("IndemnityDutyRate = " + prpLclaimDto.getIndemnityDutyRate() + ", ");
            debugBuffer.append("DeductibleRate = " + prpLclaimDto.getDeductibleRate() + ", ");
            debugBuffer.append("SumClaim = " + prpLclaimDto.getSumClaim() + ", ");
            debugBuffer.append("SumDefLoss = " + prpLclaimDto.getSumDefLoss() + ", ");
            debugBuffer.append("SumPaid = " + prpLclaimDto.getSumPaid() + ", ");
            debugBuffer.append("SumReplevy = " + prpLclaimDto.getSumReplevy() + ", ");
            debugBuffer.append("Remark = '" + prpLclaimDto.getRemark() + "', ");
            debugBuffer.append("CaseType = '" + prpLclaimDto.getCaseType() + "', ");
            debugBuffer.append("MakeCom = '" + prpLclaimDto.getMakeCom() + "', ");
            debugBuffer.append("ComCode = '" + prpLclaimDto.getComCode() + "', ");
            debugBuffer.append("AgentCode = '" + prpLclaimDto.getAgentCode() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLclaimDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLclaimDto.getHandler1Code() + "', ");
            debugBuffer.append("StatisticsYM = '" + prpLclaimDto.getStatisticsYM() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLclaimDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLclaimDto.getInputDate() + "', ");
            debugBuffer.append("EndCaseDate = '" + prpLclaimDto.getEndCaseDate() + "', ");
            debugBuffer.append("EndCaserCode = '" + prpLclaimDto.getEndCaserCode() + "', ");
            debugBuffer.append("CancelDate = '" + prpLclaimDto.getCancelDate() + "', ");
            debugBuffer.append("CancelReason = '" + prpLclaimDto.getCancelReason() + "', ");
            debugBuffer.append("DealerCode = '" + prpLclaimDto.getDealerCode() + "', ");
            debugBuffer.append("EscapeFlag = '" + prpLclaimDto.getEscapeFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimDto.getFlag() + "', ");
            debugBuffer.append("ReplevyFlag = '" + prpLclaimDto.getReplevyFlag() + "', ");
            debugBuffer.append("ThirdComFlag = '" + prpLclaimDto.getThirdComFlag() + "', ");
            debugBuffer.append("EndCaseFlag = '" + prpLclaimDto.getEndCaseFlag() + "', ");
            debugBuffer.append("cIndemnityDutyRate = " + prpLclaimDto.getCIndemnityDutyRate() + ", ");
            debugBuffer.append("DamageAreaPostCode = '" + prpLclaimDto.getDamageAreaPostCode() + "', ");
            debugBuffer.append("CatastropheCode1 = '" + prpLclaimDto.getCatastropheCode1() + "', ");
            debugBuffer.append("CatastropheName1 = '" + prpLclaimDto.getCatastropheName1() + "', ");
            debugBuffer.append("CatastropheCode2 = '" + prpLclaimDto.getCatastropheCode2() + "', ");
            debugBuffer.append("ClaimType = '" + prpLclaimDto.getClaimType() + "', ");
            debugBuffer.append("LossesNumber = " + prpLclaimDto.getLossesNumber() + ", ");
            debugBuffer.append("LossesUnitCode = '" + prpLclaimDto.getLossesUnitCode() + "', ");
            debugBuffer.append("DamageInsured = " + prpLclaimDto.getDamageInsured() + ", ");
            debugBuffer.append("DisasterArea = " + prpLclaimDto.getDisasterArea() + ", ");
            debugBuffer.append("DisasterUnit = '" + prpLclaimDto.getDisasterUnit() + "', ");
            debugBuffer.append("AffectedArea = " + prpLclaimDto.getAffectedArea() + ", ");
            debugBuffer.append("AffectedUnit = '" + prpLclaimDto.getAffectedUnit() + "', ");
            debugBuffer.append("AffectedArea = " + prpLclaimDto.getNoProductionArea() + ", ");
            debugBuffer.append("AffectedUnit = '" + prpLclaimDto.getNoProductionUnit() + "', ");        
            debugBuffer.append("DeathQuantity = " + prpLclaimDto.getDeathQuantity() + ", ");
            debugBuffer.append("DeathUnit = '" + prpLclaimDto.getDeathUnit() + "', ");
            debugBuffer.append("KillQuantity = " + prpLclaimDto.getKillQuantity() + ", ");
            debugBuffer.append("KillUnit = '" + prpLclaimDto.getKillUnit() + "', ");
            debugBuffer.append("BusinessType = '" + prpLclaimDto.getBusinessType() + "', ");
            debugBuffer.append("BusinessType1 = '" + prpLclaimDto.getBusinessType1() + "', ");
            debugBuffer.append("CatastropheName2 = '" + prpLclaimDto.getCatastropheName2() + "', ");
            debugBuffer.append("MedicalType = '" + prpLclaimDto.getMedicalType() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLclaimDto.getBusinessFlag() + "', ");
            debugBuffer.append("OtherFlag = '" + prpLclaimDto.getOtherFlag() + "', ");
            debugBuffer.append("CancelReasonExplan = '" + prpLclaimDto.getCancelReasonExplan() + "', ");
            debugBuffer.append("ClaimTime = '" + prpLclaimDto.getClaimTime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(prpLclaimDto.getClaimNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimDto.getLFlag());
        dbManager.setString(2,prpLclaimDto.getCaseNo());
        dbManager.setString(3,prpLclaimDto.getClassCode());
        dbManager.setString(4,prpLclaimDto.getRiskCode());
        dbManager.setString(5,prpLclaimDto.getRegistNo());
        dbManager.setString(6,prpLclaimDto.getPolicyNo());
        dbManager.setString(7,prpLclaimDto.getBusinessNature());
        dbManager.setString(8,prpLclaimDto.getLanguage());
        dbManager.setString(9,prpLclaimDto.getPolicyType());
        dbManager.setString(10,prpLclaimDto.getInsuredCode());
        dbManager.setString(11,prpLclaimDto.getInsuredName());
        dbManager.setDateTime(12,prpLclaimDto.getStartDate());
        dbManager.setInt(13,prpLclaimDto.getStartHour());
        dbManager.setDateTime(14,prpLclaimDto.getEndDate());
        dbManager.setInt(15,prpLclaimDto.getEndHour());
        dbManager.setString(16,prpLclaimDto.getCurrency());
        dbManager.setDouble(17,prpLclaimDto.getSumAmount());
        dbManager.setDouble(18,prpLclaimDto.getSumPremium());
        dbManager.setInt(19,prpLclaimDto.getSumQuantity());
        dbManager.setDateTime(20,prpLclaimDto.getDamageStartDate());
        dbManager.setString(21,prpLclaimDto.getDamageStartHour());
        dbManager.setDateTime(22,prpLclaimDto.getDamageEndDate());
        dbManager.setString(23,prpLclaimDto.getDamageEndHour());
        dbManager.setString(24,prpLclaimDto.getDamageCode());
        dbManager.setString(25,prpLclaimDto.getDamageName());
        dbManager.setString(26,prpLclaimDto.getDamageTypeCode());
        dbManager.setString(27,prpLclaimDto.getDamageTypeName());
        dbManager.setString(28,prpLclaimDto.getDamageAreaCode());
        dbManager.setString(29,prpLclaimDto.getDamageAreaName());
        dbManager.setString(30,prpLclaimDto.getDamageAddressType());
        dbManager.setString(31,prpLclaimDto.getAddressCode());
        dbManager.setString(32,prpLclaimDto.getDamageAddress());
        dbManager.setString(33,prpLclaimDto.getLossName());
        dbManager.setInt(34,prpLclaimDto.getLossQuantity());
        dbManager.setString(35,prpLclaimDto.getDamageKind());
        dbManager.setDateTime(36,prpLclaimDto.getClaimDate());
        dbManager.setString(37,prpLclaimDto.getIndemnityDuty());
        dbManager.setDouble(38,prpLclaimDto.getIndemnityDutyRate());
        dbManager.setDouble(39,prpLclaimDto.getDeductibleRate());
        dbManager.setDouble(40,prpLclaimDto.getSumClaim());
        dbManager.setDouble(41,prpLclaimDto.getSumDefLoss());
        dbManager.setDouble(42,prpLclaimDto.getSumPaid());
        dbManager.setDouble(43,prpLclaimDto.getSumReplevy());
        dbManager.setString(44,prpLclaimDto.getRemark());
        dbManager.setString(45,prpLclaimDto.getCaseType());
        dbManager.setString(46,prpLclaimDto.getMakeCom());
        dbManager.setString(47,prpLclaimDto.getComCode());
        dbManager.setString(48,prpLclaimDto.getAgentCode());
        dbManager.setString(49,prpLclaimDto.getHandlerCode());
        dbManager.setString(50,prpLclaimDto.getHandler1Code());
        dbManager.setDateTime(51,prpLclaimDto.getStatisticsYM());
        dbManager.setString(52,prpLclaimDto.getOperatorCode());
        dbManager.setDateTime(53,prpLclaimDto.getInputDate());
        dbManager.setDateTime(54,prpLclaimDto.getEndCaseDate());
        dbManager.setString(55,prpLclaimDto.getEndCaserCode());
        dbManager.setDateTime(56,prpLclaimDto.getCancelDate());
        dbManager.setString(57,prpLclaimDto.getCancelReason());
        dbManager.setString(58,prpLclaimDto.getDealerCode());
        dbManager.setString(59,prpLclaimDto.getEscapeFlag());
        dbManager.setString(60,prpLclaimDto.getFlag());
        dbManager.setString(61,prpLclaimDto.getReplevyFlag());
        dbManager.setString(62,prpLclaimDto.getThirdComFlag());
        dbManager.setString(63,prpLclaimDto.getEndCaseFlag());
        dbManager.setDouble(64,prpLclaimDto.getCIndemnityDutyRate());
        dbManager.setString(65,prpLclaimDto.getDamageAreaPostCode());
        dbManager.setString(66,prpLclaimDto.getCatastropheCode1());
        dbManager.setString(67,prpLclaimDto.getCatastropheName1());
        dbManager.setString(68,prpLclaimDto.getCatastropheCode2());
        dbManager.setString(69,prpLclaimDto.getClaimType());
        dbManager.setDouble(70,prpLclaimDto.getLossesNumber());
        dbManager.setString(71,prpLclaimDto.getLossesUnitCode());
        dbManager.setDouble(72,prpLclaimDto.getDamageInsured());
        dbManager.setDouble(73,prpLclaimDto.getDisasterArea());
        dbManager.setString(74,prpLclaimDto.getDisasterUnit());
        dbManager.setDouble(75,prpLclaimDto.getAffectedArea());
        dbManager.setString(76,prpLclaimDto.getAffectedUnit());
        dbManager.setDouble(77,prpLclaimDto.getNoProductionArea());
        dbManager.setString(78,prpLclaimDto.getNoProductionUnit());   
        dbManager.setDouble(79,prpLclaimDto.getDeathQuantity());
        dbManager.setString(80,prpLclaimDto.getDeathUnit());
        dbManager.setDouble(81,prpLclaimDto.getKillQuantity());
        dbManager.setString(82,prpLclaimDto.getKillUnit());
        dbManager.setString(83,prpLclaimDto.getBusinessType());
        dbManager.setString(84,prpLclaimDto.getBusinessType1());
        dbManager.setString(85,prpLclaimDto.getCatastropheName2());
        dbManager.setString(86,prpLclaimDto.getMedicalType());
        dbManager.setString(87,prpLclaimDto.getBusinessFlag());
        dbManager.setString(88,prpLclaimDto.getOtherFlag());
        dbManager.setString(89,prpLclaimDto.getCancelReasonExplan());
        dbManager.setDateTime(90,prpLclaimDto.getClaimTime());
        //设置条件字段;
        dbManager.setString(91,prpLclaimDto.getClaimNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @return PrpLclaimDto
     * @throws Exception
     */
    public PrpLclaimDto findByPrimaryKey(String claimNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimNo,");
        buffer.append("LFlag,");
        buffer.append("CaseNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("Currency,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("SumQuantity,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("DamageKind,");
        buffer.append("ClaimDate,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("DeductibleRate,");
        buffer.append("SumClaim,");
        buffer.append("SumDefLoss,");
        buffer.append("SumPaid,");
        buffer.append("SumReplevy,");
        buffer.append("Remark,");
        buffer.append("CaseType,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("AgentCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("EndCaseDate,");
        buffer.append("EndCaserCode,");
        buffer.append("CancelDate,");
        buffer.append("CancelReason,");
        buffer.append("DealerCode,");
        buffer.append("EscapeFlag,");
        buffer.append("Flag,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("EndCaseFlag,");
        buffer.append("cIndemnityDutyRate,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("ClaimType,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("DamageInsured,");
        buffer.append("DisasterArea,");
        buffer.append("DisasterUnit,");
        buffer.append("AffectedArea,");
        buffer.append("AffectedUnit,");
        buffer.append("NoProductionArea,");
        buffer.append("NoProductionUnit,");
        buffer.append("DeathQuantity,");
        buffer.append("DeathUnit,");
        buffer.append("KillQuantity,");
        buffer.append("KillUnit,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("CatastropheName2,");
        buffer.append("MedicalType, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag, ");
        buffer.append("CancelReasonExplan, ");
        buffer.append("ClaimTime ");
        buffer.append("FROM PrpLclaim ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(claimNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimDto prpLclaimDto = null;
        if(resultSet.next()){
            prpLclaimDto = new PrpLclaimDto();
            prpLclaimDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimDto.setLFlag(dbManager.getString(resultSet,2));
            prpLclaimDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLclaimDto.setClassCode(dbManager.getString(resultSet,4));
            prpLclaimDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLclaimDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLclaimDto.setBusinessNature(dbManager.getString(resultSet,8));
            prpLclaimDto.setLanguage(dbManager.getString(resultSet,9));
            prpLclaimDto.setPolicyType(dbManager.getString(resultSet,10));
            prpLclaimDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpLclaimDto.setInsuredName(dbManager.getString(resultSet,12));
            prpLclaimDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLclaimDto.setStartHour(dbManager.getInt(resultSet,14));
            prpLclaimDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLclaimDto.setEndHour(dbManager.getInt(resultSet,16));
            prpLclaimDto.setCurrency(dbManager.getString(resultSet,17));
            prpLclaimDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpLclaimDto.setSumPremium(dbManager.getDouble(resultSet,19));
            prpLclaimDto.setSumQuantity(dbManager.getInt(resultSet,20));
            prpLclaimDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLclaimDto.setDamageStartHour(dbManager.getString(resultSet,22));
            prpLclaimDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLclaimDto.setDamageEndHour(dbManager.getString(resultSet,24));
            prpLclaimDto.setDamageCode(dbManager.getString(resultSet,25));
            prpLclaimDto.setDamageName(dbManager.getString(resultSet,26));
            prpLclaimDto.setDamageTypeCode(dbManager.getString(resultSet,27));
            prpLclaimDto.setDamageTypeName(dbManager.getString(resultSet,28));
            prpLclaimDto.setDamageAreaCode(dbManager.getString(resultSet,29));
            prpLclaimDto.setDamageAreaName(dbManager.getString(resultSet,30));
            prpLclaimDto.setDamageAddressType(dbManager.getString(resultSet,31));
            prpLclaimDto.setAddressCode(dbManager.getString(resultSet,32));
            prpLclaimDto.setDamageAddress(dbManager.getString(resultSet,33));
            prpLclaimDto.setLossName(dbManager.getString(resultSet,34));
            prpLclaimDto.setLossQuantity(dbManager.getInt(resultSet,35));
            prpLclaimDto.setDamageKind(dbManager.getString(resultSet,36));
            prpLclaimDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLclaimDto.setIndemnityDuty(dbManager.getString(resultSet,38));
            prpLclaimDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,39));
            prpLclaimDto.setDeductibleRate(dbManager.getDouble(resultSet,40));
            prpLclaimDto.setSumClaim(dbManager.getDouble(resultSet,41));
            prpLclaimDto.setSumDefLoss(dbManager.getDouble(resultSet,42));
            prpLclaimDto.setSumPaid(dbManager.getDouble(resultSet,43));
            prpLclaimDto.setSumReplevy(dbManager.getDouble(resultSet,44));
            prpLclaimDto.setRemark(dbManager.getString(resultSet,45));
            prpLclaimDto.setCaseType(dbManager.getString(resultSet,46));
            prpLclaimDto.setMakeCom(dbManager.getString(resultSet,47));
            prpLclaimDto.setComCode(dbManager.getString(resultSet,48));
            prpLclaimDto.setAgentCode(dbManager.getString(resultSet,49));
            prpLclaimDto.setHandlerCode(dbManager.getString(resultSet,50));
            prpLclaimDto.setHandler1Code(dbManager.getString(resultSet,51));
            prpLclaimDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,52));
            prpLclaimDto.setOperatorCode(dbManager.getString(resultSet,53));
            prpLclaimDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,54));
            prpLclaimDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,55));
            prpLclaimDto.setEndCaserCode(dbManager.getString(resultSet,56));
            prpLclaimDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,57));
            prpLclaimDto.setCancelReason(dbManager.getString(resultSet,58));
            prpLclaimDto.setDealerCode(dbManager.getString(resultSet,59));
            prpLclaimDto.setEscapeFlag(dbManager.getString(resultSet,60));
            prpLclaimDto.setFlag(dbManager.getString(resultSet,61));
            prpLclaimDto.setReplevyFlag(dbManager.getString(resultSet,62));
            prpLclaimDto.setThirdComFlag(dbManager.getString(resultSet,63));
            prpLclaimDto.setEndCaseFlag(dbManager.getString(resultSet,64));
            prpLclaimDto.setCIndemnityDutyRate(dbManager.getDouble(resultSet,65));
            prpLclaimDto.setDamageAreaPostCode(dbManager.getString(resultSet,66));
            prpLclaimDto.setCatastropheCode1(dbManager.getString(resultSet,67));
            prpLclaimDto.setCatastropheName1(dbManager.getString(resultSet,68));
            prpLclaimDto.setCatastropheCode2(dbManager.getString(resultSet,69));
            prpLclaimDto.setClaimType(dbManager.getString(resultSet,70));
            prpLclaimDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLclaimDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLclaimDto.setDamageInsured(dbManager.getDouble(resultSet,73));
            prpLclaimDto.setDisasterArea(dbManager.getDouble(resultSet,74));
            prpLclaimDto.setDisasterUnit(dbManager.getString(resultSet,75));
            prpLclaimDto.setAffectedArea(dbManager.getDouble(resultSet,76));
            prpLclaimDto.setAffectedUnit(dbManager.getString(resultSet,77));
            prpLclaimDto.setNoProductionArea(dbManager.getDouble(resultSet,78));
            prpLclaimDto.setNoProductionUnit(dbManager.getString(resultSet,79));          
            prpLclaimDto.setDeathQuantity(dbManager.getDouble(resultSet,80));
            prpLclaimDto.setDeathUnit(dbManager.getString(resultSet,81));
            prpLclaimDto.setKillQuantity(dbManager.getDouble(resultSet,82));
            prpLclaimDto.setKillUnit(dbManager.getString(resultSet,83));
            prpLclaimDto.setBusinessType(dbManager.getString(resultSet,84));
            prpLclaimDto.setBusinessType1(dbManager.getString(resultSet,85));
            prpLclaimDto.setCatastropheName2(dbManager.getString(resultSet,86));
            prpLclaimDto.setMedicalType(dbManager.getString(resultSet,87));
            prpLclaimDto.setBusinessFlag(dbManager.getString(resultSet,88));
            prpLclaimDto.setOtherFlag(dbManager.getString(resultSet,89));
            prpLclaimDto.setCancelReasonExplan(dbManager.getString(resultSet,90));
            prpLclaimDto.setClaimTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,91));
        }else{
            logger.info("DBPrpLclaimBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimDto;
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
        buffer.append("ClaimNo,");
        buffer.append("LFlag,");
        buffer.append("CaseNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("PolicyNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("Currency,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("SumQuantity,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageEndDate,");
        buffer.append("DamageEndHour,");
        buffer.append("DamageCode,");
        buffer.append("DamageName,");
        buffer.append("DamageTypeCode,");
        buffer.append("DamageTypeName,");
        buffer.append("DamageAreaCode,");
        buffer.append("DamageAreaName,");
        buffer.append("DamageAddressType,");
        buffer.append("AddressCode,");
        buffer.append("DamageAddress,");
        buffer.append("LossName,");
        buffer.append("LossQuantity,");
        buffer.append("DamageKind,");
        buffer.append("ClaimDate,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("DeductibleRate,");
        buffer.append("SumClaim,");
        buffer.append("SumDefLoss,");
        buffer.append("SumPaid,");
        buffer.append("SumReplevy,");
        buffer.append("Remark,");
        buffer.append("CaseType,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("AgentCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("EndCaseDate,");
        buffer.append("EndCaserCode,");
        buffer.append("CancelDate,");
        buffer.append("CancelReason,");
        buffer.append("DealerCode,");
        buffer.append("EscapeFlag,");
        buffer.append("Flag,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("EndCaseFlag,");
        buffer.append("cIndemnityDutyRate,");
        buffer.append("DamageAreaPostCode,");
        buffer.append("CatastropheCode1,");
        buffer.append("CatastropheName1,");
        buffer.append("CatastropheCode2,");
        buffer.append("ClaimType,");
        buffer.append("LossesNumber,");
        buffer.append("LossesUnitCode,");
        buffer.append("DamageInsured,");
        buffer.append("DisasterArea,");
        buffer.append("DisasterUnit,");
        buffer.append("AffectedArea,");
        buffer.append("AffectedUnit,");
        buffer.append("NoProductionArea,");
        buffer.append("NoProductionUnit,");
        buffer.append("DeathQuantity,");
        buffer.append("DeathUnit,");
        buffer.append("KillQuantity,");
        buffer.append("KillUnit,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("CatastropheName2,");
        buffer.append("MedicalType, ");
        buffer.append("BusinessFlag, ");
        buffer.append("OtherFlag, ");
        buffer.append("CancelReasonExplan, ");
        buffer.append("ClaimTime ");
        buffer.append("FROM PrpLclaim WHERE ");
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
        PrpLclaimDto prpLclaimDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimDto = new PrpLclaimDto();
            prpLclaimDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimDto.setLFlag(dbManager.getString(resultSet,2));
            prpLclaimDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLclaimDto.setClassCode(dbManager.getString(resultSet,4));
            prpLclaimDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLclaimDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLclaimDto.setBusinessNature(dbManager.getString(resultSet,8));
            prpLclaimDto.setLanguage(dbManager.getString(resultSet,9));
            prpLclaimDto.setPolicyType(dbManager.getString(resultSet,10));
            prpLclaimDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpLclaimDto.setInsuredName(dbManager.getString(resultSet,12));
            prpLclaimDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLclaimDto.setStartHour(dbManager.getInt(resultSet,14));
            prpLclaimDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLclaimDto.setEndHour(dbManager.getInt(resultSet,16));
            prpLclaimDto.setCurrency(dbManager.getString(resultSet,17));
            prpLclaimDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpLclaimDto.setSumPremium(dbManager.getDouble(resultSet,19));
            prpLclaimDto.setSumQuantity(dbManager.getInt(resultSet,20));
            prpLclaimDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLclaimDto.setDamageStartHour(dbManager.getString(resultSet,22));
            prpLclaimDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLclaimDto.setDamageEndHour(dbManager.getString(resultSet,24));
            prpLclaimDto.setDamageCode(dbManager.getString(resultSet,25));
            prpLclaimDto.setDamageName(dbManager.getString(resultSet,26));
            prpLclaimDto.setDamageTypeCode(dbManager.getString(resultSet,27));
            prpLclaimDto.setDamageTypeName(dbManager.getString(resultSet,28));
            prpLclaimDto.setDamageAreaCode(dbManager.getString(resultSet,29));
            prpLclaimDto.setDamageAreaName(dbManager.getString(resultSet,30));
            prpLclaimDto.setDamageAddressType(dbManager.getString(resultSet,31));
            prpLclaimDto.setAddressCode(dbManager.getString(resultSet,32));
            prpLclaimDto.setDamageAddress(dbManager.getString(resultSet,33));
            prpLclaimDto.setLossName(dbManager.getString(resultSet,34));
            prpLclaimDto.setLossQuantity(dbManager.getInt(resultSet,35));
            prpLclaimDto.setDamageKind(dbManager.getString(resultSet,36));
            prpLclaimDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLclaimDto.setIndemnityDuty(dbManager.getString(resultSet,38));
            prpLclaimDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,39));
            prpLclaimDto.setDeductibleRate(dbManager.getDouble(resultSet,40));
            prpLclaimDto.setSumClaim(dbManager.getDouble(resultSet,41));
            prpLclaimDto.setSumDefLoss(dbManager.getDouble(resultSet,42));
            prpLclaimDto.setSumPaid(dbManager.getDouble(resultSet,43));
            prpLclaimDto.setSumReplevy(dbManager.getDouble(resultSet,44));
            prpLclaimDto.setRemark(dbManager.getString(resultSet,45));
            prpLclaimDto.setCaseType(dbManager.getString(resultSet,46));
            prpLclaimDto.setMakeCom(dbManager.getString(resultSet,47));
            prpLclaimDto.setComCode(dbManager.getString(resultSet,48));
            prpLclaimDto.setAgentCode(dbManager.getString(resultSet,49));
            prpLclaimDto.setHandlerCode(dbManager.getString(resultSet,50));
            prpLclaimDto.setHandler1Code(dbManager.getString(resultSet,51));
            prpLclaimDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,52));
            prpLclaimDto.setOperatorCode(dbManager.getString(resultSet,53));
            prpLclaimDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,54));
            prpLclaimDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,55));
            prpLclaimDto.setEndCaserCode(dbManager.getString(resultSet,56));
            prpLclaimDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,57));
            prpLclaimDto.setCancelReason(dbManager.getString(resultSet,58));
            prpLclaimDto.setDealerCode(dbManager.getString(resultSet,59));
            prpLclaimDto.setEscapeFlag(dbManager.getString(resultSet,60));
            prpLclaimDto.setFlag(dbManager.getString(resultSet,61));
            prpLclaimDto.setReplevyFlag(dbManager.getString(resultSet,62));
            prpLclaimDto.setThirdComFlag(dbManager.getString(resultSet,63));
            prpLclaimDto.setEndCaseFlag(dbManager.getString(resultSet,64));
            prpLclaimDto.setCIndemnityDutyRate(dbManager.getDouble(resultSet,65));
            prpLclaimDto.setDamageAreaPostCode(dbManager.getString(resultSet,66));
            prpLclaimDto.setCatastropheCode1(dbManager.getString(resultSet,67));
            prpLclaimDto.setCatastropheName1(dbManager.getString(resultSet,68));
            prpLclaimDto.setCatastropheCode2(dbManager.getString(resultSet,69));
            prpLclaimDto.setClaimType(dbManager.getString(resultSet,70));
            prpLclaimDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLclaimDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLclaimDto.setDamageInsured(dbManager.getDouble(resultSet,73));
            prpLclaimDto.setDisasterArea(dbManager.getDouble(resultSet,74));
            prpLclaimDto.setDisasterUnit(dbManager.getString(resultSet,75));
            prpLclaimDto.setAffectedArea(dbManager.getDouble(resultSet,76));
            prpLclaimDto.setAffectedUnit(dbManager.getString(resultSet,77));
            prpLclaimDto.setNoProductionArea(dbManager.getDouble(resultSet,78));
            prpLclaimDto.setNoProductionUnit(dbManager.getString(resultSet,79));            
            prpLclaimDto.setDeathQuantity(dbManager.getDouble(resultSet,80));
            prpLclaimDto.setDeathUnit(dbManager.getString(resultSet,81));
            prpLclaimDto.setKillQuantity(dbManager.getDouble(resultSet,82));
            prpLclaimDto.setKillUnit(dbManager.getString(resultSet,83)); 
            prpLclaimDto.setBusinessType(dbManager.getString(resultSet,84));
            prpLclaimDto.setBusinessType1(dbManager.getString(resultSet,85));
            prpLclaimDto.setCatastropheName2(dbManager.getString(resultSet,86));
            prpLclaimDto.setMedicalType(dbManager.getString(resultSet,87));
            prpLclaimDto.setBusinessFlag(dbManager.getString(resultSet,88));
            prpLclaimDto.setOtherFlag(dbManager.getString(resultSet,89));
            prpLclaimDto.setCancelReasonExplan(dbManager.getString(resultSet,90));
            prpLclaimDto.setClaimTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,91));
            collection.add(prpLclaimDto);
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
        buffer.append("DELETE FROM PrpLclaim WHERE ");
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
           statement = "SELECT count(1) FROM PrpLclaim WHERE ";
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
