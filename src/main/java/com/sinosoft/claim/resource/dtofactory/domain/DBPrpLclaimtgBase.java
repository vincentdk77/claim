package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaim-立案基本信息表的数据访问对象基类<br>
 * 创建于 2005-08-03 13:52:44.109<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimtgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimtgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimtgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void insert(PrpLclaimtgDto prpLclaimtgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimtg (");
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
            debugBuffer.append("'").append(prpLclaimtgDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getLFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCaseNo()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getBusinessNature()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getLanguage()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getPolicyType()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getStartDate()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getStartHour()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getEndDate()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getEndHour()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getSumAmount()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumPremium()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageEndDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageEndHour()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageName()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageTypeCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageAreaCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageAreaName()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageAddressType()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getAddressCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getLossName()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageKind()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getClaimDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getIndemnityDuty()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getIndemnityDutyRate()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumClaim()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumDefLoss()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumPaid()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getSumReplevy()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getAgentCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getStatisticsYM()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getEndCaseDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getEndCaserCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCancelDate()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCancelReason()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getDealerCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getEscapeFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getReplevyFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getThirdComFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getEndCaseFlag()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getCIndemnityDutyRate()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getDamageAreaPostCode()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCatastropheCode1()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCatastropheName1()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCatastropheCode2()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getClaimType()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getLossesUnitCode()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getDamageInsured()).append(",");
            debugBuffer.append("").append(prpLclaimtgDto.getDisasterArea()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getDisasterUnit()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getAffectedArea()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getAffectedUnit()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getNoProductionArea()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getNoProductionUnit()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getDeathQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getDeathUnit()).append("',");
            debugBuffer.append("").append(prpLclaimtgDto.getKillQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimtgDto.getKillUnit()).append("',"); 
            debugBuffer.append("'").append(prpLclaimtgDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getBusinessType1()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCatastropheName2()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getMedicalType()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getBusinessFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getOtherFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimtgDto.getCancelReasonExplan()).append("')");
            debugBuffer.append("'").append(prpLclaimtgDto.getClaimTime()).append("',");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimtgDto.getClaimNo());
        dbManager.setString(2,prpLclaimtgDto.getLFlag());
        dbManager.setString(3,prpLclaimtgDto.getCaseNo());
        dbManager.setString(4,prpLclaimtgDto.getClassCode());
        dbManager.setString(5,prpLclaimtgDto.getRiskCode());
        dbManager.setString(6,prpLclaimtgDto.getRegistNo());
        dbManager.setString(7,prpLclaimtgDto.getPolicyNo());
        dbManager.setString(8,prpLclaimtgDto.getBusinessNature());
        dbManager.setString(9,prpLclaimtgDto.getLanguage());
        dbManager.setString(10,prpLclaimtgDto.getPolicyType());
        dbManager.setString(11,prpLclaimtgDto.getInsuredCode());
        dbManager.setString(12,prpLclaimtgDto.getInsuredName());
        dbManager.setDateTime(13,prpLclaimtgDto.getStartDate());
        dbManager.setInt(14,prpLclaimtgDto.getStartHour());
        dbManager.setDateTime(15,prpLclaimtgDto.getEndDate());
        dbManager.setInt(16,prpLclaimtgDto.getEndHour());
        dbManager.setString(17,prpLclaimtgDto.getCurrency());
        dbManager.setDouble(18,prpLclaimtgDto.getSumAmount());
        dbManager.setDouble(19,prpLclaimtgDto.getSumPremium());
        dbManager.setInt(20,prpLclaimtgDto.getSumQuantity());
        dbManager.setDateTime(21,prpLclaimtgDto.getDamageStartDate());
        dbManager.setString(22,prpLclaimtgDto.getDamageStartHour());
        dbManager.setDateTime(23,prpLclaimtgDto.getDamageEndDate());
        dbManager.setString(24,prpLclaimtgDto.getDamageEndHour());
        dbManager.setString(25,prpLclaimtgDto.getDamageCode());
        dbManager.setString(26,prpLclaimtgDto.getDamageName());
        dbManager.setString(27,prpLclaimtgDto.getDamageTypeCode());
        dbManager.setString(28,prpLclaimtgDto.getDamageTypeName());
        dbManager.setString(29,prpLclaimtgDto.getDamageAreaCode());
        dbManager.setString(30,prpLclaimtgDto.getDamageAreaName());
        dbManager.setString(31,prpLclaimtgDto.getDamageAddressType());
        dbManager.setString(32,prpLclaimtgDto.getAddressCode());
        dbManager.setString(33,prpLclaimtgDto.getDamageAddress());
        dbManager.setString(34,prpLclaimtgDto.getLossName());
        dbManager.setInt(35,prpLclaimtgDto.getLossQuantity());
        dbManager.setString(36,prpLclaimtgDto.getDamageKind());
        dbManager.setDateTime(37,prpLclaimtgDto.getClaimDate());
        dbManager.setString(38,prpLclaimtgDto.getIndemnityDuty());
        dbManager.setDouble(39,prpLclaimtgDto.getIndemnityDutyRate());
        dbManager.setDouble(40,prpLclaimtgDto.getDeductibleRate());
        dbManager.setDouble(41,prpLclaimtgDto.getSumClaim());
        dbManager.setDouble(42,prpLclaimtgDto.getSumDefLoss());
        dbManager.setDouble(43,prpLclaimtgDto.getSumPaid());
        dbManager.setDouble(44,prpLclaimtgDto.getSumReplevy());
        dbManager.setString(45,prpLclaimtgDto.getRemark());
        dbManager.setString(46,prpLclaimtgDto.getCaseType());
        dbManager.setString(47,prpLclaimtgDto.getMakeCom());
        dbManager.setString(48,prpLclaimtgDto.getComCode());
        dbManager.setString(49,prpLclaimtgDto.getAgentCode());
        dbManager.setString(50,prpLclaimtgDto.getHandlerCode());
        dbManager.setString(51,prpLclaimtgDto.getHandler1Code());
        dbManager.setDateTime(52,prpLclaimtgDto.getStatisticsYM());
        dbManager.setString(53,prpLclaimtgDto.getOperatorCode());
        dbManager.setDateTime(54,prpLclaimtgDto.getInputDate());
        dbManager.setDateTime(55,prpLclaimtgDto.getEndCaseDate());
        dbManager.setString(56,prpLclaimtgDto.getEndCaserCode());
        dbManager.setDateTime(57,prpLclaimtgDto.getCancelDate());
        dbManager.setString(58,prpLclaimtgDto.getCancelReason());
        dbManager.setString(59,prpLclaimtgDto.getDealerCode());
        dbManager.setString(60,prpLclaimtgDto.getEscapeFlag());
        dbManager.setString(61,prpLclaimtgDto.getFlag());
        dbManager.setString(62,prpLclaimtgDto.getReplevyFlag());
        dbManager.setString(63,prpLclaimtgDto.getThirdComFlag());
        dbManager.setString(64,prpLclaimtgDto.getEndCaseFlag());
        dbManager.setDouble(65,prpLclaimtgDto.getCIndemnityDutyRate());
        dbManager.setString(66,prpLclaimtgDto.getDamageAreaPostCode());
        dbManager.setString(67,prpLclaimtgDto.getCatastropheCode1());
        dbManager.setString(68,prpLclaimtgDto.getCatastropheName1());
        dbManager.setString(69,prpLclaimtgDto.getCatastropheCode2());
        dbManager.setString(70,prpLclaimtgDto.getClaimType());
        dbManager.setDouble(71,prpLclaimtgDto.getLossesNumber());
        dbManager.setString(72,prpLclaimtgDto.getLossesUnitCode());
        dbManager.setDouble(73,prpLclaimtgDto.getDamageInsured());
        dbManager.setDouble(74,prpLclaimtgDto.getDisasterArea());
        dbManager.setString(75,prpLclaimtgDto.getDisasterUnit());
        dbManager.setDouble(76,prpLclaimtgDto.getAffectedArea());
        dbManager.setString(77,prpLclaimtgDto.getAffectedUnit());
        dbManager.setDouble(78,prpLclaimtgDto.getNoProductionArea());
        dbManager.setString(79,prpLclaimtgDto.getNoProductionUnit());        
        dbManager.setDouble(80,prpLclaimtgDto.getDeathQuantity());
        dbManager.setString(81,prpLclaimtgDto.getDeathUnit());
        dbManager.setDouble(82,prpLclaimtgDto.getKillQuantity());
        dbManager.setString(83,prpLclaimtgDto.getKillUnit());
        dbManager.setString(84,prpLclaimtgDto.getBusinessType());
        dbManager.setString(85,prpLclaimtgDto.getBusinessType1());
        dbManager.setString(86,prpLclaimtgDto.getCatastropheName2());
        dbManager.setString(87,prpLclaimtgDto.getMedicalType());
        dbManager.setString(88,prpLclaimtgDto.getBusinessFlag());
        dbManager.setString(89,prpLclaimtgDto.getOtherFlag());
        dbManager.setString(90,prpLclaimtgDto.getCancelReasonExplan());
        dbManager.setDateTime(91,prpLclaimtgDto.getClaimTime());
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
        buffer.append("INSERT INTO PrpLclaimtg (");
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
            PrpLclaimDto prpLclaimtgDto = (PrpLclaimDto)i.next();
            dbManager.setString(1,prpLclaimtgDto.getClaimNo());
            dbManager.setString(2,prpLclaimtgDto.getLFlag());
            dbManager.setString(3,prpLclaimtgDto.getCaseNo());
            dbManager.setString(4,prpLclaimtgDto.getClassCode());
            dbManager.setString(5,prpLclaimtgDto.getRiskCode());
            dbManager.setString(6,prpLclaimtgDto.getRegistNo());
            dbManager.setString(7,prpLclaimtgDto.getPolicyNo());
            dbManager.setString(8,prpLclaimtgDto.getBusinessNature());
            dbManager.setString(9,prpLclaimtgDto.getLanguage());
            dbManager.setString(10,prpLclaimtgDto.getPolicyType());
            dbManager.setString(11,prpLclaimtgDto.getInsuredCode());
            dbManager.setString(12,prpLclaimtgDto.getInsuredName());
            dbManager.setDateTime(13,prpLclaimtgDto.getStartDate());
            dbManager.setInt(14,prpLclaimtgDto.getStartHour());
            dbManager.setDateTime(15,prpLclaimtgDto.getEndDate());
            dbManager.setInt(16,prpLclaimtgDto.getEndHour());
            dbManager.setString(17,prpLclaimtgDto.getCurrency());
            dbManager.setDouble(18,prpLclaimtgDto.getSumAmount());
            dbManager.setDouble(19,prpLclaimtgDto.getSumPremium());
            dbManager.setInt(20,prpLclaimtgDto.getSumQuantity());
            dbManager.setDateTime(21,prpLclaimtgDto.getDamageStartDate());
            dbManager.setString(22,prpLclaimtgDto.getDamageStartHour());
            dbManager.setDateTime(23,prpLclaimtgDto.getDamageEndDate());
            dbManager.setString(24,prpLclaimtgDto.getDamageEndHour());
            dbManager.setString(25,prpLclaimtgDto.getDamageCode());
            dbManager.setString(26,prpLclaimtgDto.getDamageName());
            dbManager.setString(27,prpLclaimtgDto.getDamageTypeCode());
            dbManager.setString(28,prpLclaimtgDto.getDamageTypeName());
            dbManager.setString(29,prpLclaimtgDto.getDamageAreaCode());
            dbManager.setString(30,prpLclaimtgDto.getDamageAreaName());
            dbManager.setString(31,prpLclaimtgDto.getDamageAddressType());
            dbManager.setString(32,prpLclaimtgDto.getAddressCode());
            dbManager.setString(33,prpLclaimtgDto.getDamageAddress());
            dbManager.setString(34,prpLclaimtgDto.getLossName());
            dbManager.setInt(35,prpLclaimtgDto.getLossQuantity());
            dbManager.setString(36,prpLclaimtgDto.getDamageKind());
            dbManager.setDateTime(37,prpLclaimtgDto.getClaimDate());
            dbManager.setString(38,prpLclaimtgDto.getIndemnityDuty());
            dbManager.setDouble(39,prpLclaimtgDto.getIndemnityDutyRate());
            dbManager.setDouble(40,prpLclaimtgDto.getDeductibleRate());
            dbManager.setDouble(41,prpLclaimtgDto.getSumClaim());
            dbManager.setDouble(42,prpLclaimtgDto.getSumDefLoss());
            dbManager.setDouble(43,prpLclaimtgDto.getSumPaid());
            dbManager.setDouble(44,prpLclaimtgDto.getSumReplevy());
            dbManager.setString(45,prpLclaimtgDto.getRemark());
            dbManager.setString(46,prpLclaimtgDto.getCaseType());
            dbManager.setString(47,prpLclaimtgDto.getMakeCom());
            dbManager.setString(48,prpLclaimtgDto.getComCode());
            dbManager.setString(49,prpLclaimtgDto.getAgentCode());
            dbManager.setString(50,prpLclaimtgDto.getHandlerCode());
            dbManager.setString(51,prpLclaimtgDto.getHandler1Code());
            dbManager.setDateTime(52,prpLclaimtgDto.getStatisticsYM());
            dbManager.setString(53,prpLclaimtgDto.getOperatorCode());
            dbManager.setDateTime(54,prpLclaimtgDto.getInputDate());
            dbManager.setDateTime(55,prpLclaimtgDto.getEndCaseDate());
            dbManager.setString(56,prpLclaimtgDto.getEndCaserCode());
            dbManager.setDateTime(57,prpLclaimtgDto.getCancelDate());
            dbManager.setString(58,prpLclaimtgDto.getCancelReason());
            dbManager.setString(59,prpLclaimtgDto.getDealerCode());
            dbManager.setString(60,prpLclaimtgDto.getEscapeFlag());
            dbManager.setString(61,prpLclaimtgDto.getFlag());
            dbManager.setString(62,prpLclaimtgDto.getReplevyFlag());
            dbManager.setString(63,prpLclaimtgDto.getThirdComFlag());
            dbManager.setString(64,prpLclaimtgDto.getEndCaseFlag());
            dbManager.setDouble(65,prpLclaimtgDto.getCIndemnityDutyRate());
            dbManager.setString(66,prpLclaimtgDto.getDamageAreaPostCode());
            dbManager.setString(67,prpLclaimtgDto.getCatastropheCode1());
            dbManager.setString(68,prpLclaimtgDto.getCatastropheName1());
            dbManager.setString(69,prpLclaimtgDto.getCatastropheCode2());
            dbManager.setString(70,prpLclaimtgDto.getClaimType());
            dbManager.setDouble(71,prpLclaimtgDto.getLossesNumber());
            dbManager.setString(72,prpLclaimtgDto.getLossesUnitCode());
            dbManager.setDouble(73,prpLclaimtgDto.getDamageInsured());
            dbManager.setDouble(74,prpLclaimtgDto.getDisasterArea());
            dbManager.setString(75,prpLclaimtgDto.getDisasterUnit());
            dbManager.setDouble(76,prpLclaimtgDto.getAffectedArea());
            dbManager.setString(77,prpLclaimtgDto.getAffectedUnit());
            dbManager.setDouble(78,prpLclaimtgDto.getNoProductionArea());
            dbManager.setString(79,prpLclaimtgDto.getNoProductionUnit());
            dbManager.setDouble(80,prpLclaimtgDto.getDeathQuantity());
            dbManager.setString(81,prpLclaimtgDto.getDeathUnit());
            dbManager.setDouble(82,prpLclaimtgDto.getKillQuantity());
            dbManager.setString(83,prpLclaimtgDto.getKillUnit());
            dbManager.setString(84,prpLclaimtgDto.getBusinessType());
            dbManager.setString(85,prpLclaimtgDto.getBusinessType1());
            dbManager.setString(86,prpLclaimtgDto.getCatastropheName2());
            dbManager.setString(87,prpLclaimtgDto.getMedicalType());
            dbManager.setString(88,prpLclaimtgDto.getBusinessFlag());
            dbManager.setString(89,prpLclaimtgDto.getOtherFlag());
            dbManager.setString(90,prpLclaimtgDto.getCancelReasonExplan());
            dbManager.setDateTime(91,prpLclaimtgDto.getClaimTime());
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
        buffer.append("DELETE FROM PrpLclaimtg ");
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
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void update(PrpLclaimtgDto prpLclaimtgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimtg SET ");
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
            debugBuffer.append("UPDATE PrpLclaimtg SET ");
            debugBuffer.append("LFlag = '" + prpLclaimtgDto.getLFlag() + "', ");
            debugBuffer.append("CaseNo = '" + prpLclaimtgDto.getCaseNo() + "', ");
            debugBuffer.append("ClassCode = '" + prpLclaimtgDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpLclaimtgDto.getRiskCode() + "', ");
            debugBuffer.append("RegistNo = '" + prpLclaimtgDto.getRegistNo() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLclaimtgDto.getPolicyNo() + "', ");
            debugBuffer.append("BusinessNature = '" + prpLclaimtgDto.getBusinessNature() + "', ");
            debugBuffer.append("Language = '" + prpLclaimtgDto.getLanguage() + "', ");
            debugBuffer.append("PolicyType = '" + prpLclaimtgDto.getPolicyType() + "', ");
            debugBuffer.append("InsuredCode = '" + prpLclaimtgDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpLclaimtgDto.getInsuredName() + "', ");
            debugBuffer.append("StartDate = '" + prpLclaimtgDto.getStartDate() + "', ");
            debugBuffer.append("StartHour = " + prpLclaimtgDto.getStartHour() + ", ");
            debugBuffer.append("EndDate = '" + prpLclaimtgDto.getEndDate() + "', ");
            debugBuffer.append("EndHour = " + prpLclaimtgDto.getEndHour() + ", ");
            debugBuffer.append("Currency = '" + prpLclaimtgDto.getCurrency() + "', ");
            debugBuffer.append("SumAmount = " + prpLclaimtgDto.getSumAmount() + ", ");
            debugBuffer.append("SumPremium = " + prpLclaimtgDto.getSumPremium() + ", ");
            debugBuffer.append("SumQuantity = " + prpLclaimtgDto.getSumQuantity() + ", ");
            debugBuffer.append("DamageStartDate = '" + prpLclaimtgDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLclaimtgDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageEndDate = '" + prpLclaimtgDto.getDamageEndDate() + "', ");
            debugBuffer.append("DamageEndHour = '" + prpLclaimtgDto.getDamageEndHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLclaimtgDto.getDamageCode() + "', ");
            debugBuffer.append("DamageName = '" + prpLclaimtgDto.getDamageName() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLclaimtgDto.getDamageTypeCode() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLclaimtgDto.getDamageTypeName() + "', ");
            debugBuffer.append("DamageAreaCode = '" + prpLclaimtgDto.getDamageAreaCode() + "', ");
            debugBuffer.append("DamageAreaName = '" + prpLclaimtgDto.getDamageAreaName() + "', ");
            debugBuffer.append("DamageAddressType = '" + prpLclaimtgDto.getDamageAddressType() + "', ");
            debugBuffer.append("AddressCode = '" + prpLclaimtgDto.getAddressCode() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLclaimtgDto.getDamageAddress() + "', ");
            debugBuffer.append("LossName = '" + prpLclaimtgDto.getLossName() + "', ");
            debugBuffer.append("LossQuantity = " + prpLclaimtgDto.getLossQuantity() + ", ");
            debugBuffer.append("DamageKind = '" + prpLclaimtgDto.getDamageKind() + "', ");
            debugBuffer.append("ClaimDate = '" + prpLclaimtgDto.getClaimDate() + "', ");
            debugBuffer.append("IndemnityDuty = '" + prpLclaimtgDto.getIndemnityDuty() + "', ");
            debugBuffer.append("IndemnityDutyRate = " + prpLclaimtgDto.getIndemnityDutyRate() + ", ");
            debugBuffer.append("DeductibleRate = " + prpLclaimtgDto.getDeductibleRate() + ", ");
            debugBuffer.append("SumClaim = " + prpLclaimtgDto.getSumClaim() + ", ");
            debugBuffer.append("SumDefLoss = " + prpLclaimtgDto.getSumDefLoss() + ", ");
            debugBuffer.append("SumPaid = " + prpLclaimtgDto.getSumPaid() + ", ");
            debugBuffer.append("SumReplevy = " + prpLclaimtgDto.getSumReplevy() + ", ");
            debugBuffer.append("Remark = '" + prpLclaimtgDto.getRemark() + "', ");
            debugBuffer.append("CaseType = '" + prpLclaimtgDto.getCaseType() + "', ");
            debugBuffer.append("MakeCom = '" + prpLclaimtgDto.getMakeCom() + "', ");
            debugBuffer.append("ComCode = '" + prpLclaimtgDto.getComCode() + "', ");
            debugBuffer.append("AgentCode = '" + prpLclaimtgDto.getAgentCode() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLclaimtgDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLclaimtgDto.getHandler1Code() + "', ");
            debugBuffer.append("StatisticsYM = '" + prpLclaimtgDto.getStatisticsYM() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLclaimtgDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLclaimtgDto.getInputDate() + "', ");
            debugBuffer.append("EndCaseDate = '" + prpLclaimtgDto.getEndCaseDate() + "', ");
            debugBuffer.append("EndCaserCode = '" + prpLclaimtgDto.getEndCaserCode() + "', ");
            debugBuffer.append("CancelDate = '" + prpLclaimtgDto.getCancelDate() + "', ");
            debugBuffer.append("CancelReason = '" + prpLclaimtgDto.getCancelReason() + "', ");
            debugBuffer.append("DealerCode = '" + prpLclaimtgDto.getDealerCode() + "', ");
            debugBuffer.append("EscapeFlag = '" + prpLclaimtgDto.getEscapeFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimtgDto.getFlag() + "', ");
            debugBuffer.append("ReplevyFlag = '" + prpLclaimtgDto.getReplevyFlag() + "', ");
            debugBuffer.append("ThirdComFlag = '" + prpLclaimtgDto.getThirdComFlag() + "', ");
            debugBuffer.append("EndCaseFlag = '" + prpLclaimtgDto.getEndCaseFlag() + "', ");
            debugBuffer.append("cIndemnityDutyRate = " + prpLclaimtgDto.getCIndemnityDutyRate() + ", ");
            debugBuffer.append("DamageAreaPostCode = '" + prpLclaimtgDto.getDamageAreaPostCode() + "', ");
            debugBuffer.append("CatastropheCode1 = '" + prpLclaimtgDto.getCatastropheCode1() + "', ");
            debugBuffer.append("CatastropheName1 = '" + prpLclaimtgDto.getCatastropheName1() + "', ");
            debugBuffer.append("CatastropheCode2 = '" + prpLclaimtgDto.getCatastropheCode2() + "', ");
            debugBuffer.append("ClaimType = '" + prpLclaimtgDto.getClaimType() + "', ");
            debugBuffer.append("LossesNumber = " + prpLclaimtgDto.getLossesNumber() + ", ");
            debugBuffer.append("LossesUnitCode = '" + prpLclaimtgDto.getLossesUnitCode() + "', ");
            debugBuffer.append("DamageInsured = " + prpLclaimtgDto.getDamageInsured() + ", ");
            debugBuffer.append("DisasterArea = " + prpLclaimtgDto.getDisasterArea() + ", ");
            debugBuffer.append("DisasterUnit = '" + prpLclaimtgDto.getDisasterUnit() + "', ");
            debugBuffer.append("AffectedArea = " + prpLclaimtgDto.getAffectedArea() + ", ");
            debugBuffer.append("AffectedUnit = '" + prpLclaimtgDto.getAffectedUnit() + "', ");
            debugBuffer.append("AffectedArea = " + prpLclaimtgDto.getNoProductionArea() + ", ");
            debugBuffer.append("AffectedUnit = '" + prpLclaimtgDto.getNoProductionUnit() + "', ");        
            debugBuffer.append("DeathQuantity = " + prpLclaimtgDto.getDeathQuantity() + ", ");
            debugBuffer.append("DeathUnit = '" + prpLclaimtgDto.getDeathUnit() + "', ");
            debugBuffer.append("KillQuantity = " + prpLclaimtgDto.getKillQuantity() + ", ");
            debugBuffer.append("KillUnit = '" + prpLclaimtgDto.getKillUnit() + "', ");
            debugBuffer.append("BusinessType = '" + prpLclaimtgDto.getBusinessType() + "', ");
            debugBuffer.append("BusinessType1 = '" + prpLclaimtgDto.getBusinessType1() + "', ");
            debugBuffer.append("CatastropheName2 = '" + prpLclaimtgDto.getCatastropheName2() + "', ");
            debugBuffer.append("MedicalType = '" + prpLclaimtgDto.getMedicalType() + "', ");
            debugBuffer.append("BusinessFlag = '" + prpLclaimtgDto.getBusinessFlag() + "', ");
            debugBuffer.append("OtherFlag = '" + prpLclaimtgDto.getOtherFlag() + "', ");
            debugBuffer.append("CancelReasonExplan = '" + prpLclaimtgDto.getCancelReasonExplan() + "', ");
            debugBuffer.append("ClaimTime = '" + prpLclaimtgDto.getClaimTime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(prpLclaimtgDto.getClaimNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimtgDto.getLFlag());
        dbManager.setString(2,prpLclaimtgDto.getCaseNo());
        dbManager.setString(3,prpLclaimtgDto.getClassCode());
        dbManager.setString(4,prpLclaimtgDto.getRiskCode());
        dbManager.setString(5,prpLclaimtgDto.getRegistNo());
        dbManager.setString(6,prpLclaimtgDto.getPolicyNo());
        dbManager.setString(7,prpLclaimtgDto.getBusinessNature());
        dbManager.setString(8,prpLclaimtgDto.getLanguage());
        dbManager.setString(9,prpLclaimtgDto.getPolicyType());
        dbManager.setString(10,prpLclaimtgDto.getInsuredCode());
        dbManager.setString(11,prpLclaimtgDto.getInsuredName());
        dbManager.setDateTime(12,prpLclaimtgDto.getStartDate());
        dbManager.setInt(13,prpLclaimtgDto.getStartHour());
        dbManager.setDateTime(14,prpLclaimtgDto.getEndDate());
        dbManager.setInt(15,prpLclaimtgDto.getEndHour());
        dbManager.setString(16,prpLclaimtgDto.getCurrency());
        dbManager.setDouble(17,prpLclaimtgDto.getSumAmount());
        dbManager.setDouble(18,prpLclaimtgDto.getSumPremium());
        dbManager.setInt(19,prpLclaimtgDto.getSumQuantity());
        dbManager.setDateTime(20,prpLclaimtgDto.getDamageStartDate());
        dbManager.setString(21,prpLclaimtgDto.getDamageStartHour());
        dbManager.setDateTime(22,prpLclaimtgDto.getDamageEndDate());
        dbManager.setString(23,prpLclaimtgDto.getDamageEndHour());
        dbManager.setString(24,prpLclaimtgDto.getDamageCode());
        dbManager.setString(25,prpLclaimtgDto.getDamageName());
        dbManager.setString(26,prpLclaimtgDto.getDamageTypeCode());
        dbManager.setString(27,prpLclaimtgDto.getDamageTypeName());
        dbManager.setString(28,prpLclaimtgDto.getDamageAreaCode());
        dbManager.setString(29,prpLclaimtgDto.getDamageAreaName());
        dbManager.setString(30,prpLclaimtgDto.getDamageAddressType());
        dbManager.setString(31,prpLclaimtgDto.getAddressCode());
        dbManager.setString(32,prpLclaimtgDto.getDamageAddress());
        dbManager.setString(33,prpLclaimtgDto.getLossName());
        dbManager.setInt(34,prpLclaimtgDto.getLossQuantity());
        dbManager.setString(35,prpLclaimtgDto.getDamageKind());
        dbManager.setDateTime(36,prpLclaimtgDto.getClaimDate());
        dbManager.setString(37,prpLclaimtgDto.getIndemnityDuty());
        dbManager.setDouble(38,prpLclaimtgDto.getIndemnityDutyRate());
        dbManager.setDouble(39,prpLclaimtgDto.getDeductibleRate());
        dbManager.setDouble(40,prpLclaimtgDto.getSumClaim());
        dbManager.setDouble(41,prpLclaimtgDto.getSumDefLoss());
        dbManager.setDouble(42,prpLclaimtgDto.getSumPaid());
        dbManager.setDouble(43,prpLclaimtgDto.getSumReplevy());
        dbManager.setString(44,prpLclaimtgDto.getRemark());
        dbManager.setString(45,prpLclaimtgDto.getCaseType());
        dbManager.setString(46,prpLclaimtgDto.getMakeCom());
        dbManager.setString(47,prpLclaimtgDto.getComCode());
        dbManager.setString(48,prpLclaimtgDto.getAgentCode());
        dbManager.setString(49,prpLclaimtgDto.getHandlerCode());
        dbManager.setString(50,prpLclaimtgDto.getHandler1Code());
        dbManager.setDateTime(51,prpLclaimtgDto.getStatisticsYM());
        dbManager.setString(52,prpLclaimtgDto.getOperatorCode());
        dbManager.setDateTime(53,prpLclaimtgDto.getInputDate());
        dbManager.setDateTime(54,prpLclaimtgDto.getEndCaseDate());
        dbManager.setString(55,prpLclaimtgDto.getEndCaserCode());
        dbManager.setDateTime(56,prpLclaimtgDto.getCancelDate());
        dbManager.setString(57,prpLclaimtgDto.getCancelReason());
        dbManager.setString(58,prpLclaimtgDto.getDealerCode());
        dbManager.setString(59,prpLclaimtgDto.getEscapeFlag());
        dbManager.setString(60,prpLclaimtgDto.getFlag());
        dbManager.setString(61,prpLclaimtgDto.getReplevyFlag());
        dbManager.setString(62,prpLclaimtgDto.getThirdComFlag());
        dbManager.setString(63,prpLclaimtgDto.getEndCaseFlag());
        dbManager.setDouble(64,prpLclaimtgDto.getCIndemnityDutyRate());
        dbManager.setString(65,prpLclaimtgDto.getDamageAreaPostCode());
        dbManager.setString(66,prpLclaimtgDto.getCatastropheCode1());
        dbManager.setString(67,prpLclaimtgDto.getCatastropheName1());
        dbManager.setString(68,prpLclaimtgDto.getCatastropheCode2());
        dbManager.setString(69,prpLclaimtgDto.getClaimType());
        dbManager.setDouble(70,prpLclaimtgDto.getLossesNumber());
        dbManager.setString(71,prpLclaimtgDto.getLossesUnitCode());
        dbManager.setDouble(72,prpLclaimtgDto.getDamageInsured());
        dbManager.setDouble(73,prpLclaimtgDto.getDisasterArea());
        dbManager.setString(74,prpLclaimtgDto.getDisasterUnit());
        dbManager.setDouble(75,prpLclaimtgDto.getAffectedArea());
        dbManager.setString(76,prpLclaimtgDto.getAffectedUnit());
        dbManager.setDouble(77,prpLclaimtgDto.getNoProductionArea());
        dbManager.setString(78,prpLclaimtgDto.getNoProductionUnit());   
        dbManager.setDouble(79,prpLclaimtgDto.getDeathQuantity());
        dbManager.setString(80,prpLclaimtgDto.getDeathUnit());
        dbManager.setDouble(81,prpLclaimtgDto.getKillQuantity());
        dbManager.setString(82,prpLclaimtgDto.getKillUnit());
        dbManager.setString(83,prpLclaimtgDto.getBusinessType());
        dbManager.setString(84,prpLclaimtgDto.getBusinessType1());
        dbManager.setString(85,prpLclaimtgDto.getCatastropheName2());
        dbManager.setString(86,prpLclaimtgDto.getMedicalType());
        dbManager.setString(87,prpLclaimtgDto.getBusinessFlag());
        dbManager.setString(88,prpLclaimtgDto.getOtherFlag());
        dbManager.setString(89,prpLclaimtgDto.getCancelReasonExplan());
        dbManager.setDateTime(90,prpLclaimtgDto.getClaimTime());
        //设置条件字段;
        dbManager.setString(91,prpLclaimtgDto.getClaimNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号码
     * @return PrpLclaimDto
     * @throws Exception
     */
    public PrpLclaimtgDto findByPrimaryKey(String claimNo)
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
        buffer.append("FROM PrpLclaimtg ");
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
        PrpLclaimtgDto prpLclaimtgDto = null;
        if(resultSet.next()){
            prpLclaimtgDto = new PrpLclaimtgDto();
            prpLclaimtgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimtgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLclaimtgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLclaimtgDto.setClassCode(dbManager.getString(resultSet,4));
            prpLclaimtgDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimtgDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLclaimtgDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLclaimtgDto.setBusinessNature(dbManager.getString(resultSet,8));
            prpLclaimtgDto.setLanguage(dbManager.getString(resultSet,9));
            prpLclaimtgDto.setPolicyType(dbManager.getString(resultSet,10));
            prpLclaimtgDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpLclaimtgDto.setInsuredName(dbManager.getString(resultSet,12));
            prpLclaimtgDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLclaimtgDto.setStartHour(dbManager.getInt(resultSet,14));
            prpLclaimtgDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLclaimtgDto.setEndHour(dbManager.getInt(resultSet,16));
            prpLclaimtgDto.setCurrency(dbManager.getString(resultSet,17));
            prpLclaimtgDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpLclaimtgDto.setSumPremium(dbManager.getDouble(resultSet,19));
            prpLclaimtgDto.setSumQuantity(dbManager.getInt(resultSet,20));
            prpLclaimtgDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLclaimtgDto.setDamageStartHour(dbManager.getString(resultSet,22));
            prpLclaimtgDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLclaimtgDto.setDamageEndHour(dbManager.getString(resultSet,24));
            prpLclaimtgDto.setDamageCode(dbManager.getString(resultSet,25));
            prpLclaimtgDto.setDamageName(dbManager.getString(resultSet,26));
            prpLclaimtgDto.setDamageTypeCode(dbManager.getString(resultSet,27));
            prpLclaimtgDto.setDamageTypeName(dbManager.getString(resultSet,28));
            prpLclaimtgDto.setDamageAreaCode(dbManager.getString(resultSet,29));
            prpLclaimtgDto.setDamageAreaName(dbManager.getString(resultSet,30));
            prpLclaimtgDto.setDamageAddressType(dbManager.getString(resultSet,31));
            prpLclaimtgDto.setAddressCode(dbManager.getString(resultSet,32));
            prpLclaimtgDto.setDamageAddress(dbManager.getString(resultSet,33));
            prpLclaimtgDto.setLossName(dbManager.getString(resultSet,34));
            prpLclaimtgDto.setLossQuantity(dbManager.getInt(resultSet,35));
            prpLclaimtgDto.setDamageKind(dbManager.getString(resultSet,36));
            prpLclaimtgDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLclaimtgDto.setIndemnityDuty(dbManager.getString(resultSet,38));
            prpLclaimtgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,39));
            prpLclaimtgDto.setDeductibleRate(dbManager.getDouble(resultSet,40));
            prpLclaimtgDto.setSumClaim(dbManager.getDouble(resultSet,41));
            prpLclaimtgDto.setSumDefLoss(dbManager.getDouble(resultSet,42));
            prpLclaimtgDto.setSumPaid(dbManager.getDouble(resultSet,43));
            prpLclaimtgDto.setSumReplevy(dbManager.getDouble(resultSet,44));
            prpLclaimtgDto.setRemark(dbManager.getString(resultSet,45));
            prpLclaimtgDto.setCaseType(dbManager.getString(resultSet,46));
            prpLclaimtgDto.setMakeCom(dbManager.getString(resultSet,47));
            prpLclaimtgDto.setComCode(dbManager.getString(resultSet,48));
            prpLclaimtgDto.setAgentCode(dbManager.getString(resultSet,49));
            prpLclaimtgDto.setHandlerCode(dbManager.getString(resultSet,50));
            prpLclaimtgDto.setHandler1Code(dbManager.getString(resultSet,51));
            prpLclaimtgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,52));
            prpLclaimtgDto.setOperatorCode(dbManager.getString(resultSet,53));
            prpLclaimtgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,54));
            prpLclaimtgDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,55));
            prpLclaimtgDto.setEndCaserCode(dbManager.getString(resultSet,56));
            prpLclaimtgDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,57));
            prpLclaimtgDto.setCancelReason(dbManager.getString(resultSet,58));
            prpLclaimtgDto.setDealerCode(dbManager.getString(resultSet,59));
            prpLclaimtgDto.setEscapeFlag(dbManager.getString(resultSet,60));
            prpLclaimtgDto.setFlag(dbManager.getString(resultSet,61));
            prpLclaimtgDto.setReplevyFlag(dbManager.getString(resultSet,62));
            prpLclaimtgDto.setThirdComFlag(dbManager.getString(resultSet,63));
            prpLclaimtgDto.setEndCaseFlag(dbManager.getString(resultSet,64));
            prpLclaimtgDto.setCIndemnityDutyRate(dbManager.getDouble(resultSet,65));
            prpLclaimtgDto.setDamageAreaPostCode(dbManager.getString(resultSet,66));
            prpLclaimtgDto.setCatastropheCode1(dbManager.getString(resultSet,67));
            prpLclaimtgDto.setCatastropheName1(dbManager.getString(resultSet,68));
            prpLclaimtgDto.setCatastropheCode2(dbManager.getString(resultSet,69));
            prpLclaimtgDto.setClaimType(dbManager.getString(resultSet,70));
            prpLclaimtgDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLclaimtgDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLclaimtgDto.setDamageInsured(dbManager.getDouble(resultSet,73));
            prpLclaimtgDto.setDisasterArea(dbManager.getDouble(resultSet,74));
            prpLclaimtgDto.setDisasterUnit(dbManager.getString(resultSet,75));
            prpLclaimtgDto.setAffectedArea(dbManager.getDouble(resultSet,76));
            prpLclaimtgDto.setAffectedUnit(dbManager.getString(resultSet,77));
            prpLclaimtgDto.setNoProductionArea(dbManager.getDouble(resultSet,78));
            prpLclaimtgDto.setNoProductionUnit(dbManager.getString(resultSet,79));          
            prpLclaimtgDto.setDeathQuantity(dbManager.getDouble(resultSet,80));
            prpLclaimtgDto.setDeathUnit(dbManager.getString(resultSet,81));
            prpLclaimtgDto.setKillQuantity(dbManager.getDouble(resultSet,82));
            prpLclaimtgDto.setKillUnit(dbManager.getString(resultSet,83));
            prpLclaimtgDto.setBusinessType(dbManager.getString(resultSet,84));
            prpLclaimtgDto.setBusinessType1(dbManager.getString(resultSet,85));
            prpLclaimtgDto.setCatastropheName2(dbManager.getString(resultSet,86));
            prpLclaimtgDto.setMedicalType(dbManager.getString(resultSet,87));
            prpLclaimtgDto.setBusinessFlag(dbManager.getString(resultSet,88));
            prpLclaimtgDto.setOtherFlag(dbManager.getString(resultSet,89));
            prpLclaimtgDto.setCancelReasonExplan(dbManager.getString(resultSet,90));
            prpLclaimtgDto.setClaimTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,91));
        }else{
            logger.info("DBPrpLclaimBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimtgDto;
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
        buffer.append("FROM PrpLclaimtg WHERE ");
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
        PrpLclaimDto prpLclaimtgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimtgDto = new PrpLclaimDto();
            prpLclaimtgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimtgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLclaimtgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLclaimtgDto.setClassCode(dbManager.getString(resultSet,4));
            prpLclaimtgDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLclaimtgDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLclaimtgDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLclaimtgDto.setBusinessNature(dbManager.getString(resultSet,8));
            prpLclaimtgDto.setLanguage(dbManager.getString(resultSet,9));
            prpLclaimtgDto.setPolicyType(dbManager.getString(resultSet,10));
            prpLclaimtgDto.setInsuredCode(dbManager.getString(resultSet,11));
            prpLclaimtgDto.setInsuredName(dbManager.getString(resultSet,12));
            prpLclaimtgDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLclaimtgDto.setStartHour(dbManager.getInt(resultSet,14));
            prpLclaimtgDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLclaimtgDto.setEndHour(dbManager.getInt(resultSet,16));
            prpLclaimtgDto.setCurrency(dbManager.getString(resultSet,17));
            prpLclaimtgDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpLclaimtgDto.setSumPremium(dbManager.getDouble(resultSet,19));
            prpLclaimtgDto.setSumQuantity(dbManager.getInt(resultSet,20));
            prpLclaimtgDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLclaimtgDto.setDamageStartHour(dbManager.getString(resultSet,22));
            prpLclaimtgDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpLclaimtgDto.setDamageEndHour(dbManager.getString(resultSet,24));
            prpLclaimtgDto.setDamageCode(dbManager.getString(resultSet,25));
            prpLclaimtgDto.setDamageName(dbManager.getString(resultSet,26));
            prpLclaimtgDto.setDamageTypeCode(dbManager.getString(resultSet,27));
            prpLclaimtgDto.setDamageTypeName(dbManager.getString(resultSet,28));
            prpLclaimtgDto.setDamageAreaCode(dbManager.getString(resultSet,29));
            prpLclaimtgDto.setDamageAreaName(dbManager.getString(resultSet,30));
            prpLclaimtgDto.setDamageAddressType(dbManager.getString(resultSet,31));
            prpLclaimtgDto.setAddressCode(dbManager.getString(resultSet,32));
            prpLclaimtgDto.setDamageAddress(dbManager.getString(resultSet,33));
            prpLclaimtgDto.setLossName(dbManager.getString(resultSet,34));
            prpLclaimtgDto.setLossQuantity(dbManager.getInt(resultSet,35));
            prpLclaimtgDto.setDamageKind(dbManager.getString(resultSet,36));
            prpLclaimtgDto.setClaimDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLclaimtgDto.setIndemnityDuty(dbManager.getString(resultSet,38));
            prpLclaimtgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,39));
            prpLclaimtgDto.setDeductibleRate(dbManager.getDouble(resultSet,40));
            prpLclaimtgDto.setSumClaim(dbManager.getDouble(resultSet,41));
            prpLclaimtgDto.setSumDefLoss(dbManager.getDouble(resultSet,42));
            prpLclaimtgDto.setSumPaid(dbManager.getDouble(resultSet,43));
            prpLclaimtgDto.setSumReplevy(dbManager.getDouble(resultSet,44));
            prpLclaimtgDto.setRemark(dbManager.getString(resultSet,45));
            prpLclaimtgDto.setCaseType(dbManager.getString(resultSet,46));
            prpLclaimtgDto.setMakeCom(dbManager.getString(resultSet,47));
            prpLclaimtgDto.setComCode(dbManager.getString(resultSet,48));
            prpLclaimtgDto.setAgentCode(dbManager.getString(resultSet,49));
            prpLclaimtgDto.setHandlerCode(dbManager.getString(resultSet,50));
            prpLclaimtgDto.setHandler1Code(dbManager.getString(resultSet,51));
            prpLclaimtgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,52));
            prpLclaimtgDto.setOperatorCode(dbManager.getString(resultSet,53));
            prpLclaimtgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,54));
            prpLclaimtgDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,55));
            prpLclaimtgDto.setEndCaserCode(dbManager.getString(resultSet,56));
            prpLclaimtgDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,57));
            prpLclaimtgDto.setCancelReason(dbManager.getString(resultSet,58));
            prpLclaimtgDto.setDealerCode(dbManager.getString(resultSet,59));
            prpLclaimtgDto.setEscapeFlag(dbManager.getString(resultSet,60));
            prpLclaimtgDto.setFlag(dbManager.getString(resultSet,61));
            prpLclaimtgDto.setReplevyFlag(dbManager.getString(resultSet,62));
            prpLclaimtgDto.setThirdComFlag(dbManager.getString(resultSet,63));
            prpLclaimtgDto.setEndCaseFlag(dbManager.getString(resultSet,64));
            prpLclaimtgDto.setCIndemnityDutyRate(dbManager.getDouble(resultSet,65));
            prpLclaimtgDto.setDamageAreaPostCode(dbManager.getString(resultSet,66));
            prpLclaimtgDto.setCatastropheCode1(dbManager.getString(resultSet,67));
            prpLclaimtgDto.setCatastropheName1(dbManager.getString(resultSet,68));
            prpLclaimtgDto.setCatastropheCode2(dbManager.getString(resultSet,69));
            prpLclaimtgDto.setClaimType(dbManager.getString(resultSet,70));
            prpLclaimtgDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLclaimtgDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLclaimtgDto.setDamageInsured(dbManager.getDouble(resultSet,73));
            prpLclaimtgDto.setDisasterArea(dbManager.getDouble(resultSet,74));
            prpLclaimtgDto.setDisasterUnit(dbManager.getString(resultSet,75));
            prpLclaimtgDto.setAffectedArea(dbManager.getDouble(resultSet,76));
            prpLclaimtgDto.setAffectedUnit(dbManager.getString(resultSet,77));
            prpLclaimtgDto.setNoProductionArea(dbManager.getDouble(resultSet,78));
            prpLclaimtgDto.setNoProductionUnit(dbManager.getString(resultSet,79));            
            prpLclaimtgDto.setDeathQuantity(dbManager.getDouble(resultSet,80));
            prpLclaimtgDto.setDeathUnit(dbManager.getString(resultSet,81));
            prpLclaimtgDto.setKillQuantity(dbManager.getDouble(resultSet,82));
            prpLclaimtgDto.setKillUnit(dbManager.getString(resultSet,83)); 
            prpLclaimtgDto.setBusinessType(dbManager.getString(resultSet,84));
            prpLclaimtgDto.setBusinessType1(dbManager.getString(resultSet,85));
            prpLclaimtgDto.setCatastropheName2(dbManager.getString(resultSet,86));
            prpLclaimtgDto.setMedicalType(dbManager.getString(resultSet,87));
            prpLclaimtgDto.setBusinessFlag(dbManager.getString(resultSet,88));
            prpLclaimtgDto.setOtherFlag(dbManager.getString(resultSet,89));
            prpLclaimtgDto.setCancelReasonExplan(dbManager.getString(resultSet,90));
            prpLclaimtgDto.setClaimTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,91));
            collection.add(prpLclaimtgDto);
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
        buffer.append("DELETE FROM PrpLclaimtg WHERE ");
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
           statement = "SELECT count(1) FROM PrpLclaimtg WHERE ";
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
