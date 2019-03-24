package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口参数中间表主表的数据访问对象基类<br>
 */
public class DBPrpLinterRequestBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterRequestBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterRequestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterRequestDto prpLinterRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterRequest (");
        buffer.append("Id,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("EstimateLoss,");
        buffer.append("ScheduleObjectId,");
        buffer.append("CheckSite,");
        buffer.append("CheckInfo,");
        buffer.append("NextHandlerCode,");
        buffer.append("NextHandlerName,");
        buffer.append("Checker2,");
        buffer.append("CheckType,");
        buffer.append("CheckDate,");
        buffer.append("CheckNature,");
        buffer.append("CheckEstimateLoss,");
        buffer.append("EstimateFee,");
        buffer.append("UnitType,");
        buffer.append("CheckRemark,");
        buffer.append("CheckContext,");
        buffer.append("Currency,");
        buffer.append("DamageTypeName,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("SumClaim,");
        buffer.append("ClaimType,");
        buffer.append("CaseType,");
        buffer.append("PayAppContext,");
        buffer.append("SumPrePaid,");
        buffer.append("PrepayReport,");
        buffer.append("CertifyContext,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("MutualFlag,");
        buffer.append("OutRigstNo,"); 
        buffer.append("InputRegistDate,");
        buffer.append("InputCompeDate,");
        buffer.append("RegistAutoFlag,"); 
        buffer.append("CompeAutoFlag,"); 
        buffer.append("ClaimAutoFlag,"); 
        buffer.append("RegistUser,"); 
        buffer.append("RegistTime,"); 
        buffer.append("CompeUser,"); 
        buffer.append("CompeTime,"); 
        buffer.append("VericUser,"); 
        buffer.append("VericTime,"); 
        buffer.append("OutId ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterRequestDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReportName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReportDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReportHour()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReportType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getLinkerName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getLinkerAddress()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageTypeCode()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getMakeComName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getContext()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getEstimateLoss()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getScheduleObjectId()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckSite()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckInfo()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getNextHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getNextHandlerName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getChecker2()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckNature()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getCheckEstimateLoss()).append(",");
            debugBuffer.append("").append(prpLinterRequestDto.getEstimateFee()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getUnitType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckRemark()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCheckContext()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCurrency()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getDamageTypeName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReplevyFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getThirdComFlag()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getSumClaim()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getClaimType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getPayAppContext()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getSumPrePaid()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getPrepayReport()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCertifyContext()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getReceiverName()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getAccount()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getAccountOK()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getZeroLossType()).append("',");
            debugBuffer.append("").append(prpLinterRequestDto.getSumNoDutyFee()).append(",");
            debugBuffer.append("").append(prpLinterRequestDto.getPrplCompensateSumPaid()).append(",");
            debugBuffer.append("").append(prpLinterRequestDto.getPrplCompensateSumPrePaid()).append(",");
            debugBuffer.append("").append(prpLinterRequestDto.getSumChargePaid()).append(",");
            debugBuffer.append("").append(prpLinterRequestDto.getSumThisPaid()).append(",");
            debugBuffer.append("'").append(prpLinterRequestDto.getCompeContext()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getNotion()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getHandleText()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getMutualFlag()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getOutRigstNo()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getInputRegistDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getInputCompeDate()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getRegistAutoFlag()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getCompeAutoFlag()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getClaimAutoFlag()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getRegistUser()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getRegistTime()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getCompeUser()).append("',");
            debugBuffer.append("'").append(prpLinterRequestDto.getCompeTime()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getVericUser()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getVericTime()).append("',"); 
            debugBuffer.append("'").append(prpLinterRequestDto.getOutId()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterRequestDto.getId());
        dbManager.setDateTime(2,prpLinterRequestDto.getInputDate());
        dbManager.setString(3,prpLinterRequestDto.getPolicyno());
        dbManager.setString(4,prpLinterRequestDto.getRegistno());
        dbManager.setString(5,prpLinterRequestDto.getClaimno());
        dbManager.setDateTime(6,prpLinterRequestDto.getDamageStartDate());
        dbManager.setString(7,prpLinterRequestDto.getDamageStartHour());
        dbManager.setString(8,prpLinterRequestDto.getDamageCode());
        dbManager.setString(9,prpLinterRequestDto.getReportName());
        dbManager.setDateTime(10,prpLinterRequestDto.getReportDate());
        dbManager.setString(11,prpLinterRequestDto.getReportHour());
        dbManager.setString(12,prpLinterRequestDto.getReportType());
        dbManager.setString(13,prpLinterRequestDto.getLinkerName());
        dbManager.setString(14,prpLinterRequestDto.getPhoneNumber());
        dbManager.setString(15,prpLinterRequestDto.getLinkerAddress());
        dbManager.setString(16,prpLinterRequestDto.getClauseType());
        dbManager.setString(17,prpLinterRequestDto.getDamageAddress());
        dbManager.setString(18,prpLinterRequestDto.getDamageTypeCode());
        dbManager.setDouble(19,prpLinterRequestDto.getLossesNumber());
        dbManager.setString(20,prpLinterRequestDto.getOperatorCode());
        dbManager.setString(21,prpLinterRequestDto.getOperatorName());
        dbManager.setString(22,prpLinterRequestDto.getMakeCom());
        dbManager.setString(23,prpLinterRequestDto.getMakeComName());
        dbManager.setString(24,prpLinterRequestDto.getRemark());
        dbManager.setString(25,prpLinterRequestDto.getContext());
        dbManager.setDouble(26,prpLinterRequestDto.getEstimateLoss());
        dbManager.setString(27,prpLinterRequestDto.getScheduleObjectId());
        dbManager.setString(28,prpLinterRequestDto.getCheckSite());
        dbManager.setString(29,prpLinterRequestDto.getCheckInfo());
        dbManager.setString(30,prpLinterRequestDto.getNextHandlerCode());
        dbManager.setString(31,prpLinterRequestDto.getNextHandlerName());
        dbManager.setString(32,prpLinterRequestDto.getChecker2());
        dbManager.setString(33,prpLinterRequestDto.getCheckType());
        dbManager.setDateTime(34,prpLinterRequestDto.getCheckDate());
        dbManager.setString(35,prpLinterRequestDto.getCheckNature());
        dbManager.setDouble(36,prpLinterRequestDto.getCheckEstimateLoss());
        dbManager.setDouble(37,prpLinterRequestDto.getEstimateFee());
        dbManager.setString(38,prpLinterRequestDto.getUnitType());
        dbManager.setString(39,prpLinterRequestDto.getCheckRemark());
        dbManager.setString(40,prpLinterRequestDto.getCheckContext());
        dbManager.setString(41,prpLinterRequestDto.getCurrency());
        dbManager.setString(42,prpLinterRequestDto.getDamageTypeName());
        dbManager.setString(43,prpLinterRequestDto.getReplevyFlag());
        dbManager.setString(44,prpLinterRequestDto.getThirdComFlag());
        dbManager.setDouble(45,prpLinterRequestDto.getSumClaim());
        dbManager.setString(46,prpLinterRequestDto.getClaimType());
        dbManager.setString(47,prpLinterRequestDto.getCaseType());
        dbManager.setString(48,prpLinterRequestDto.getPayAppContext());
        dbManager.setDouble(49,prpLinterRequestDto.getSumPrePaid());
        dbManager.setString(50,prpLinterRequestDto.getPrepayReport());
        dbManager.setString(51,prpLinterRequestDto.getCertifyContext());
        dbManager.setString(52,prpLinterRequestDto.getBank());
        dbManager.setString(53,prpLinterRequestDto.getReceiverName());
        dbManager.setString(54,prpLinterRequestDto.getAccount());
        dbManager.setString(55,prpLinterRequestDto.getAccountOK());
        dbManager.setString(56,prpLinterRequestDto.getZeroLossType());
        dbManager.setDouble(57,prpLinterRequestDto.getSumNoDutyFee());
        dbManager.setDouble(58,prpLinterRequestDto.getPrplCompensateSumPaid());
        dbManager.setDouble(59,prpLinterRequestDto.getPrplCompensateSumPrePaid());
        dbManager.setDouble(60,prpLinterRequestDto.getSumChargePaid());
        dbManager.setDouble(61,prpLinterRequestDto.getSumThisPaid());
        dbManager.setString(62,prpLinterRequestDto.getCompeContext());
        dbManager.setString(63,prpLinterRequestDto.getNotion());
        dbManager.setString(64,prpLinterRequestDto.getHandleText());
        dbManager.setString(65,prpLinterRequestDto.getMutualFlag());
        dbManager.setString(66,prpLinterRequestDto.getOutRigstNo());
        dbManager.setDateTime(67,prpLinterRequestDto.getInputRegistDate());
        dbManager.setDateTime(68,prpLinterRequestDto.getInputCompeDate());
        dbManager.setString(69,prpLinterRequestDto.getRegistAutoFlag());
        dbManager.setString(70,prpLinterRequestDto.getCompeAutoFlag());
        dbManager.setString(71,prpLinterRequestDto.getClaimAutoFlag());
        dbManager.setString(72,prpLinterRequestDto.getRegistUser());
        dbManager.setDateTime(73,prpLinterRequestDto.getRegistTime());
        dbManager.setString(74,prpLinterRequestDto.getCompeUser());
        dbManager.setDateTime(75,prpLinterRequestDto.getCompeTime());
        dbManager.setString(76,prpLinterRequestDto.getVericUser());
        dbManager.setDateTime(77,prpLinterRequestDto.getVericTime());
        dbManager.setString(78,prpLinterRequestDto.getOutId());
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
        buffer.append("INSERT INTO PrpLinterRequest (");
        buffer.append("Id,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("EstimateLoss,");
        buffer.append("ScheduleObjectId,");
        buffer.append("CheckSite,");
        buffer.append("CheckInfo,");
        buffer.append("NextHandlerCode,");
        buffer.append("NextHandlerName,");
        buffer.append("Checker2,");
        buffer.append("CheckType,");
        buffer.append("CheckDate,");
        buffer.append("CheckNature,");
        buffer.append("CheckEstimateLoss,");
        buffer.append("EstimateFee,");
        buffer.append("UnitType,");
        buffer.append("CheckRemark,");
        buffer.append("CheckContext,");
        buffer.append("Currency,");
        buffer.append("DamageTypeName,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("SumClaim,");
        buffer.append("ClaimType,");
        buffer.append("CaseType,");
        buffer.append("PayAppContext,");
        buffer.append("SumPrePaid,");
        buffer.append("PrepayReport,");
        buffer.append("CertifyContext,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("MutualFlag,");
        buffer.append("OutRigstNo,"); 
        buffer.append("InputRegistDate,");
        buffer.append("InputCompeDate,");
        buffer.append("RegistAutoFlag,"); 
        buffer.append("CompeAutoFlag,"); 
        buffer.append("ClaimAutoFlag,"); 
        buffer.append("RegistUser,"); 
        buffer.append("RegistTime,"); 
        buffer.append("CompeUser,"); 
        buffer.append("CompeTime,"); 
        buffer.append("VericUser,"); 
        buffer.append("VericTime,"); 
        buffer.append("OutId ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)i.next();
            dbManager.setString(1,prpLinterRequestDto.getId());
            dbManager.setDateTime(2,prpLinterRequestDto.getInputDate());
            dbManager.setString(3,prpLinterRequestDto.getPolicyno());
            dbManager.setString(4,prpLinterRequestDto.getRegistno());
            dbManager.setString(5,prpLinterRequestDto.getClaimno());
            dbManager.setDateTime(6,prpLinterRequestDto.getDamageStartDate());
            dbManager.setString(7,prpLinterRequestDto.getDamageStartHour());
            dbManager.setString(8,prpLinterRequestDto.getDamageCode());
            dbManager.setString(9,prpLinterRequestDto.getReportName());
            dbManager.setDateTime(10,prpLinterRequestDto.getReportDate());
            dbManager.setString(11,prpLinterRequestDto.getReportHour());
            dbManager.setString(12,prpLinterRequestDto.getReportType());
            dbManager.setString(13,prpLinterRequestDto.getLinkerName());
            dbManager.setString(14,prpLinterRequestDto.getPhoneNumber());
            dbManager.setString(15,prpLinterRequestDto.getLinkerAddress());
            dbManager.setString(16,prpLinterRequestDto.getClauseType());
            dbManager.setString(17,prpLinterRequestDto.getDamageAddress());
            dbManager.setString(18,prpLinterRequestDto.getDamageTypeCode());
            dbManager.setDouble(19,prpLinterRequestDto.getLossesNumber());
            dbManager.setString(20,prpLinterRequestDto.getOperatorCode());
            dbManager.setString(21,prpLinterRequestDto.getOperatorName());
            dbManager.setString(22,prpLinterRequestDto.getMakeCom());
            dbManager.setString(23,prpLinterRequestDto.getMakeComName());
            dbManager.setString(24,prpLinterRequestDto.getRemark());
            dbManager.setString(25,prpLinterRequestDto.getContext());
            dbManager.setDouble(26,prpLinterRequestDto.getEstimateLoss());
            dbManager.setString(27,prpLinterRequestDto.getScheduleObjectId());
            dbManager.setString(28,prpLinterRequestDto.getCheckSite());
            dbManager.setString(29,prpLinterRequestDto.getCheckInfo());
            dbManager.setString(30,prpLinterRequestDto.getNextHandlerCode());
            dbManager.setString(31,prpLinterRequestDto.getNextHandlerName());
            dbManager.setString(32,prpLinterRequestDto.getChecker2());
            dbManager.setString(33,prpLinterRequestDto.getCheckType());
            dbManager.setDateTime(34,prpLinterRequestDto.getCheckDate());
            dbManager.setString(35,prpLinterRequestDto.getCheckNature());
            dbManager.setDouble(36,prpLinterRequestDto.getCheckEstimateLoss());
            dbManager.setDouble(37,prpLinterRequestDto.getEstimateFee());
            dbManager.setString(38,prpLinterRequestDto.getUnitType());
            dbManager.setString(39,prpLinterRequestDto.getCheckRemark());
            dbManager.setString(40,prpLinterRequestDto.getCheckContext());
            dbManager.setString(41,prpLinterRequestDto.getCurrency());
            dbManager.setString(42,prpLinterRequestDto.getDamageTypeName());
            dbManager.setString(43,prpLinterRequestDto.getReplevyFlag());
            dbManager.setString(44,prpLinterRequestDto.getThirdComFlag());
            dbManager.setDouble(45,prpLinterRequestDto.getSumClaim());
            dbManager.setString(46,prpLinterRequestDto.getClaimType());
            dbManager.setString(47,prpLinterRequestDto.getCaseType());
            dbManager.setString(48,prpLinterRequestDto.getPayAppContext());
            dbManager.setDouble(49,prpLinterRequestDto.getSumPrePaid());
            dbManager.setString(50,prpLinterRequestDto.getPrepayReport());
            dbManager.setString(51,prpLinterRequestDto.getCertifyContext());
            dbManager.setString(52,prpLinterRequestDto.getBank());
            dbManager.setString(53,prpLinterRequestDto.getReceiverName());
            dbManager.setString(54,prpLinterRequestDto.getAccount());
            dbManager.setString(55,prpLinterRequestDto.getAccountOK());
            dbManager.setString(56,prpLinterRequestDto.getZeroLossType());
            dbManager.setDouble(57,prpLinterRequestDto.getSumNoDutyFee());
            dbManager.setDouble(58,prpLinterRequestDto.getPrplCompensateSumPaid());
            dbManager.setDouble(59,prpLinterRequestDto.getPrplCompensateSumPrePaid());
            dbManager.setDouble(60,prpLinterRequestDto.getSumChargePaid());
            dbManager.setDouble(61,prpLinterRequestDto.getSumThisPaid());
            dbManager.setString(62,prpLinterRequestDto.getCompeContext());
            dbManager.setString(63,prpLinterRequestDto.getNotion());
            dbManager.setString(64,prpLinterRequestDto.getHandleText());
            dbManager.setString(65,prpLinterRequestDto.getMutualFlag());
            dbManager.setString(66,prpLinterRequestDto.getOutRigstNo());
            dbManager.setDateTime(67,prpLinterRequestDto.getInputRegistDate());
            dbManager.setDateTime(68,prpLinterRequestDto.getInputCompeDate());
            dbManager.setString(69,prpLinterRequestDto.getRegistAutoFlag());
            dbManager.setString(70,prpLinterRequestDto.getCompeAutoFlag());
            dbManager.setString(71,prpLinterRequestDto.getClaimAutoFlag());
            dbManager.setString(72,prpLinterRequestDto.getRegistUser());
            dbManager.setDateTime(73,prpLinterRequestDto.getRegistTime());
            dbManager.setString(74,prpLinterRequestDto.getCompeUser());
            dbManager.setDateTime(75,prpLinterRequestDto.getCompeTime());
            dbManager.setString(76,prpLinterRequestDto.getVericUser());
            dbManager.setDateTime(77,prpLinterRequestDto.getVericTime());
            dbManager.setString(78,prpLinterRequestDto.getOutId());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void update(PrpLinterRequestDto prpLinterRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterRequest SET ");
        buffer.append("InputDate = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Registno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("DamageStartDate = ?, ");
        buffer.append("DamageStartHour = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("ReportName = ?, ");
        buffer.append("ReportDate = ?, ");
        buffer.append("ReportHour = ?, ");
        buffer.append("ReportType = ?, ");
        buffer.append("LinkerName = ?, ");
        buffer.append("PhoneNumber = ?, ");
        buffer.append("LinkerAddress = ?, ");
        buffer.append("ClauseType = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("LossesNumber = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("OperatorName = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("MakeComName = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Context = ?, ");
        buffer.append("EstimateLoss = ?, ");
        buffer.append("ScheduleObjectId = ?, ");
        buffer.append("CheckSite = ?, ");
        buffer.append("CheckInfo = ?, ");
        buffer.append("NextHandlerCode = ?, ");
        buffer.append("NextHandlerName = ?, ");
        buffer.append("Checker2 = ?, ");
        buffer.append("CheckType = ?, ");
        buffer.append("CheckDate = ?, ");
        buffer.append("CheckNature = ?, ");
        buffer.append("CheckEstimateLoss = ?, ");
        buffer.append("EstimateFee = ?, ");
        buffer.append("UnitType = ?, ");
        buffer.append("CheckRemark = ?, ");
        buffer.append("CheckContext = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("DamageTypeName = ?, ");
        buffer.append("ReplevyFlag = ?, ");
        buffer.append("ThirdComFlag = ?, ");
        buffer.append("SumClaim = ?, ");
        buffer.append("ClaimType = ?, ");
        buffer.append("CaseType = ?, ");
        buffer.append("PayAppContext = ?, ");
        buffer.append("SumPrePaid = ?, ");
        buffer.append("PrepayReport = ?, ");
        buffer.append("CertifyContext = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("ReceiverName = ?, ");
        buffer.append("Account = ?, ");
        buffer.append("AccountOK = ?, ");
        buffer.append("ZeroLossType = ?, ");
        buffer.append("SumNoDutyFee = ?, ");
        buffer.append("PrplCompensateSumPaid = ?, ");
        buffer.append("PrplCompensateSumPrePaid = ?, ");
        buffer.append("SumChargePaid = ?, ");
        buffer.append("SumThisPaid = ?, ");
        buffer.append("CompeContext = ?, ");
        buffer.append("Notion = ?, ");
        buffer.append("HandleText = ?, ");
        buffer.append("MutualFlag = ?, ");
        buffer.append("OutRigstNo = ?, "); 
        buffer.append("InputRegistDate = ?, ");
        buffer.append("InputCompeDate = ?, ");
        buffer.append("RegistAutoFlag = ?, "); 
        buffer.append("CompeAutoFlag = ?, "); 
        buffer.append("ClaimAutoFlag = ?, "); 
        buffer.append("RegistUser = ?, "); 
        buffer.append("RegistTime = ?, "); 
        buffer.append("CompeUser = ?, "); 
        buffer.append("CompeTime = ?, "); 
        buffer.append("VericUser = ?, "); 
        buffer.append("VericTime = ?, "); 
        buffer.append("OutId = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterRequest SET ");
            debugBuffer.append("InputDate = '" + prpLinterRequestDto.getInputDate() + "', ");
            debugBuffer.append("Policyno = '" + prpLinterRequestDto.getPolicyno() + "', ");
            debugBuffer.append("Registno = '" + prpLinterRequestDto.getRegistno() + "', ");
            debugBuffer.append("Claimno = '" + prpLinterRequestDto.getClaimno() + "', ");
            debugBuffer.append("DamageStartDate = '" + prpLinterRequestDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLinterRequestDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLinterRequestDto.getDamageCode() + "', ");
            debugBuffer.append("ReportName = '" + prpLinterRequestDto.getReportName() + "', ");
            debugBuffer.append("ReportDate = '" + prpLinterRequestDto.getReportDate() + "', ");
            debugBuffer.append("ReportHour = '" + prpLinterRequestDto.getReportHour() + "', ");
            debugBuffer.append("ReportType = '" + prpLinterRequestDto.getReportType() + "', ");
            debugBuffer.append("LinkerName = '" + prpLinterRequestDto.getLinkerName() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpLinterRequestDto.getPhoneNumber() + "', ");
            debugBuffer.append("LinkerAddress = '" + prpLinterRequestDto.getLinkerAddress() + "', ");
            debugBuffer.append("ClauseType = '" + prpLinterRequestDto.getClauseType() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLinterRequestDto.getDamageAddress() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLinterRequestDto.getDamageTypeCode() + "', ");
            debugBuffer.append("LossesNumber = " + prpLinterRequestDto.getLossesNumber() + ", ");
            debugBuffer.append("OperatorCode = '" + prpLinterRequestDto.getOperatorCode() + "', ");
            debugBuffer.append("OperatorName = '" + prpLinterRequestDto.getOperatorName() + "', ");
            debugBuffer.append("MakeCom = '" + prpLinterRequestDto.getMakeCom() + "', ");
            debugBuffer.append("MakeComName = '" + prpLinterRequestDto.getMakeComName() + "', ");
            debugBuffer.append("Remark = '" + prpLinterRequestDto.getRemark() + "', ");
            debugBuffer.append("Context = '" + prpLinterRequestDto.getContext() + "', ");
            debugBuffer.append("EstimateLoss = " + prpLinterRequestDto.getEstimateLoss() + ", ");
            debugBuffer.append("ScheduleObjectId = '" + prpLinterRequestDto.getScheduleObjectId() + "', ");
            debugBuffer.append("CheckSite = '" + prpLinterRequestDto.getCheckSite() + "', ");
            debugBuffer.append("CheckInfo = '" + prpLinterRequestDto.getCheckInfo() + "', ");
            debugBuffer.append("NextHandlerCode = '" + prpLinterRequestDto.getNextHandlerCode() + "', ");
            debugBuffer.append("NextHandlerName = '" + prpLinterRequestDto.getNextHandlerName() + "', ");
            debugBuffer.append("Checker2 = '" + prpLinterRequestDto.getChecker2() + "', ");
            debugBuffer.append("CheckType = '" + prpLinterRequestDto.getCheckType() + "', ");
            debugBuffer.append("CheckDate = '" + prpLinterRequestDto.getCheckDate() + "', ");
            debugBuffer.append("CheckNature = '" + prpLinterRequestDto.getCheckNature() + "', ");
            debugBuffer.append("CheckEstimateLoss = " + prpLinterRequestDto.getCheckEstimateLoss() + ", ");
            debugBuffer.append("EstimateFee = " + prpLinterRequestDto.getEstimateFee() + ", ");
            debugBuffer.append("UnitType = '" + prpLinterRequestDto.getUnitType() + "', ");
            debugBuffer.append("CheckRemark = '" + prpLinterRequestDto.getCheckRemark() + "', ");
            debugBuffer.append("CheckContext = '" + prpLinterRequestDto.getCheckContext() + "', ");
            debugBuffer.append("Currency = '" + prpLinterRequestDto.getCurrency() + "', ");
            debugBuffer.append("DamageTypeName = '" + prpLinterRequestDto.getDamageTypeName() + "', ");
            debugBuffer.append("ReplevyFlag = '" + prpLinterRequestDto.getReplevyFlag() + "', ");
            debugBuffer.append("ThirdComFlag = '" + prpLinterRequestDto.getThirdComFlag() + "', ");
            debugBuffer.append("SumClaim = " + prpLinterRequestDto.getSumClaim() + ", ");
            debugBuffer.append("ClaimType = '" + prpLinterRequestDto.getClaimType() + "', ");
            debugBuffer.append("CaseType = '" + prpLinterRequestDto.getCaseType() + "', ");
            debugBuffer.append("PayAppContext = '" + prpLinterRequestDto.getPayAppContext() + "', ");
            debugBuffer.append("SumPrePaid = " + prpLinterRequestDto.getSumPrePaid() + ", ");
            debugBuffer.append("PrepayReport = '" + prpLinterRequestDto.getPrepayReport() + "', ");
            debugBuffer.append("CertifyContext = '" + prpLinterRequestDto.getCertifyContext() + "', ");
            debugBuffer.append("Bank = '" + prpLinterRequestDto.getBank() + "', ");
            debugBuffer.append("ReceiverName = '" + prpLinterRequestDto.getReceiverName() + "', ");
            debugBuffer.append("Account = '" + prpLinterRequestDto.getAccount() + "', ");
            debugBuffer.append("AccountOK = '" + prpLinterRequestDto.getAccountOK() + "', ");
            debugBuffer.append("ZeroLossType = '" + prpLinterRequestDto.getZeroLossType() + "', ");
            debugBuffer.append("SumNoDutyFee = " + prpLinterRequestDto.getSumNoDutyFee() + ", ");
            debugBuffer.append("PrplCompensateSumPaid = " + prpLinterRequestDto.getPrplCompensateSumPaid() + ", ");
            debugBuffer.append("PrplCompensateSumPrePaid = " + prpLinterRequestDto.getPrplCompensateSumPrePaid() + ", ");
            debugBuffer.append("SumChargePaid = " + prpLinterRequestDto.getSumChargePaid() + ", ");
            debugBuffer.append("SumThisPaid = " + prpLinterRequestDto.getSumThisPaid() + ", ");
            debugBuffer.append("CompeContext = '" + prpLinterRequestDto.getCompeContext() + "', ");
            debugBuffer.append("Notion = '" + prpLinterRequestDto.getNotion() + "', ");
            debugBuffer.append("HandleText = '" + prpLinterRequestDto.getHandleText() + "', ");
            debugBuffer.append("MutualFlag = '" + prpLinterRequestDto.getMutualFlag() + "', ");
            debugBuffer.append("OutRigstNo = '" + prpLinterRequestDto.getOutRigstNo() + "', ");
            debugBuffer.append("InputRegistDate = '" + prpLinterRequestDto.getInputRegistDate() + "', ");
            debugBuffer.append("InputCompeDate = '" + prpLinterRequestDto.getInputCompeDate() + "', ");
            debugBuffer.append("RegistAutoFlag = '" + prpLinterRequestDto.getRegistAutoFlag()+ "', ");
            debugBuffer.append("CompeAutoFlag = '" + prpLinterRequestDto.getCompeAutoFlag() + "', ");
            debugBuffer.append("ClaimAutoFlag = '" + prpLinterRequestDto.getClaimAutoFlag() + "', ");
            debugBuffer.append("RegistUser = '" + prpLinterRequestDto.getRegistUser() + "', ");
            debugBuffer.append("RegistTime = '" + prpLinterRequestDto.getRegistTime() + "', ");
            debugBuffer.append("CompeUser = '" + prpLinterRequestDto.getCompeUser() + "', ");
            debugBuffer.append("CompeTime = '" + prpLinterRequestDto.getCompeTime() + "', ");
            debugBuffer.append("VericUser = '" + prpLinterRequestDto.getVericUser() + "', ");
            debugBuffer.append("VericTime = '" + prpLinterRequestDto.getVericTime() + "', ");
            debugBuffer.append("OutId = '" + prpLinterRequestDto.getOutId() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterRequestDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setDateTime(1,prpLinterRequestDto.getInputDate());
        dbManager.setString(2,prpLinterRequestDto.getPolicyno());
        dbManager.setString(3,prpLinterRequestDto.getRegistno());
        dbManager.setString(4,prpLinterRequestDto.getClaimno());
        dbManager.setDateTime(5,prpLinterRequestDto.getDamageStartDate());
        dbManager.setString(6,prpLinterRequestDto.getDamageStartHour());
        dbManager.setString(7,prpLinterRequestDto.getDamageCode());
        dbManager.setString(8,prpLinterRequestDto.getReportName());
        dbManager.setDateTime(9,prpLinterRequestDto.getReportDate());
        dbManager.setString(10,prpLinterRequestDto.getReportHour());
        dbManager.setString(11,prpLinterRequestDto.getReportType());
        dbManager.setString(12,prpLinterRequestDto.getLinkerName());
        dbManager.setString(13,prpLinterRequestDto.getPhoneNumber());
        dbManager.setString(14,prpLinterRequestDto.getLinkerAddress());
        dbManager.setString(15,prpLinterRequestDto.getClauseType());
        dbManager.setString(16,prpLinterRequestDto.getDamageAddress());
        dbManager.setString(17,prpLinterRequestDto.getDamageTypeCode());
        dbManager.setDouble(18,prpLinterRequestDto.getLossesNumber());
        dbManager.setString(19,prpLinterRequestDto.getOperatorCode());
        dbManager.setString(20,prpLinterRequestDto.getOperatorName());
        dbManager.setString(21,prpLinterRequestDto.getMakeCom());
        dbManager.setString(22,prpLinterRequestDto.getMakeComName());
        dbManager.setString(23,prpLinterRequestDto.getRemark());
        dbManager.setString(24,prpLinterRequestDto.getContext());
        dbManager.setDouble(25,prpLinterRequestDto.getEstimateLoss());
        dbManager.setString(26,prpLinterRequestDto.getScheduleObjectId());
        dbManager.setString(27,prpLinterRequestDto.getCheckSite());
        dbManager.setString(28,prpLinterRequestDto.getCheckInfo());
        dbManager.setString(29,prpLinterRequestDto.getNextHandlerCode());
        dbManager.setString(30,prpLinterRequestDto.getNextHandlerName());
        dbManager.setString(31,prpLinterRequestDto.getChecker2());
        dbManager.setString(32,prpLinterRequestDto.getCheckType());
        dbManager.setDateTime(33,prpLinterRequestDto.getCheckDate());
        dbManager.setString(34,prpLinterRequestDto.getCheckNature());
        dbManager.setDouble(35,prpLinterRequestDto.getCheckEstimateLoss());
        dbManager.setDouble(36,prpLinterRequestDto.getEstimateFee());
        dbManager.setString(37,prpLinterRequestDto.getUnitType());
        dbManager.setString(38,prpLinterRequestDto.getCheckRemark());
        dbManager.setString(39,prpLinterRequestDto.getCheckContext());
        dbManager.setString(40,prpLinterRequestDto.getCurrency());
        dbManager.setString(41,prpLinterRequestDto.getDamageTypeName());
        dbManager.setString(42,prpLinterRequestDto.getReplevyFlag());
        dbManager.setString(43,prpLinterRequestDto.getThirdComFlag());
        dbManager.setDouble(44,prpLinterRequestDto.getSumClaim());
        dbManager.setString(45,prpLinterRequestDto.getClaimType());
        dbManager.setString(46,prpLinterRequestDto.getCaseType());
        dbManager.setString(47,prpLinterRequestDto.getPayAppContext());
        dbManager.setDouble(48,prpLinterRequestDto.getSumPrePaid());
        dbManager.setString(49,prpLinterRequestDto.getPrepayReport());
        dbManager.setString(50,prpLinterRequestDto.getCertifyContext());
        dbManager.setString(51,prpLinterRequestDto.getBank());
        dbManager.setString(52,prpLinterRequestDto.getReceiverName());
        dbManager.setString(53,prpLinterRequestDto.getAccount());
        dbManager.setString(54,prpLinterRequestDto.getAccountOK());
        dbManager.setString(55,prpLinterRequestDto.getZeroLossType());
        dbManager.setDouble(56,prpLinterRequestDto.getSumNoDutyFee());
        dbManager.setDouble(57,prpLinterRequestDto.getPrplCompensateSumPaid());
        dbManager.setDouble(58,prpLinterRequestDto.getPrplCompensateSumPrePaid());
        dbManager.setDouble(59,prpLinterRequestDto.getSumChargePaid());
        dbManager.setDouble(60,prpLinterRequestDto.getSumThisPaid());
        dbManager.setString(61,prpLinterRequestDto.getCompeContext());
        dbManager.setString(62,prpLinterRequestDto.getNotion());
        dbManager.setString(63,prpLinterRequestDto.getHandleText());
        dbManager.setString(64,prpLinterRequestDto.getMutualFlag());
        dbManager.setString(65,prpLinterRequestDto.getOutRigstNo());
        dbManager.setDateTime(66,prpLinterRequestDto.getInputRegistDate());
        dbManager.setDateTime(67,prpLinterRequestDto.getInputCompeDate());
        dbManager.setString(68,prpLinterRequestDto.getRegistAutoFlag());
        dbManager.setString(69,prpLinterRequestDto.getCompeAutoFlag());
        dbManager.setString(70,prpLinterRequestDto.getClaimAutoFlag());
        dbManager.setString(71,prpLinterRequestDto.getRegistUser());
        dbManager.setDateTime(72,prpLinterRequestDto.getRegistTime());
        dbManager.setString(73,prpLinterRequestDto.getCompeUser());
        dbManager.setDateTime(74,prpLinterRequestDto.getCompeTime());
        dbManager.setString(75,prpLinterRequestDto.getVericUser());
        dbManager.setDateTime(76,prpLinterRequestDto.getVericTime());
        dbManager.setString(77,prpLinterRequestDto.getOutId());
        //设置条件字段;
        dbManager.setString(78,prpLinterRequestDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterRequestDto
     * @throws Exception
     */
    public PrpLinterRequestDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("EstimateLoss,");
        buffer.append("ScheduleObjectId,");
        buffer.append("CheckSite,");
        buffer.append("CheckInfo,");
        buffer.append("NextHandlerCode,");
        buffer.append("NextHandlerName,");
        buffer.append("Checker2,");
        buffer.append("CheckType,");
        buffer.append("CheckDate,");
        buffer.append("CheckNature,");
        buffer.append("CheckEstimateLoss,");
        buffer.append("EstimateFee,");
        buffer.append("UnitType,");
        buffer.append("CheckRemark,");
        buffer.append("CheckContext,");
        buffer.append("Currency,");
        buffer.append("DamageTypeName,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("SumClaim,");
        buffer.append("ClaimType,");
        buffer.append("CaseType,");
        buffer.append("PayAppContext,");
        buffer.append("SumPrePaid,");
        buffer.append("PrepayReport,");
        buffer.append("CertifyContext,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("MutualFlag,");
        buffer.append("OutRigstNo,"); 
        buffer.append("InputRegistDate,");
        buffer.append("InputCompeDate,");
        buffer.append("RegistAutoFlag,"); 
        buffer.append("CompeAutoFlag,"); 
        buffer.append("ClaimAutoFlag,"); 
        buffer.append("RegistUser,"); 
        buffer.append("RegistTime,"); 
        buffer.append("CompeUser,"); 
        buffer.append("CompeTime,"); 
        buffer.append("VericUser,"); 
        buffer.append("VericTime,"); 
        buffer.append("OutId ");
        buffer.append("FROM PrpLinterRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterRequestDto prpLinterRequestDto = null;
        if(resultSet.next()){
            prpLinterRequestDto = new PrpLinterRequestDto();
            prpLinterRequestDto.setId(dbManager.getString(resultSet,1));
            prpLinterRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,2));
            prpLinterRequestDto.setPolicyno(dbManager.getString(resultSet,3));
            prpLinterRequestDto.setRegistno(dbManager.getString(resultSet,4));
            prpLinterRequestDto.setClaimno(dbManager.getString(resultSet,5));
            prpLinterRequestDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLinterRequestDto.setDamageStartHour(dbManager.getString(resultSet,7));
            prpLinterRequestDto.setDamageCode(dbManager.getString(resultSet,8));
            prpLinterRequestDto.setReportName(dbManager.getString(resultSet,9));
            prpLinterRequestDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLinterRequestDto.setReportHour(dbManager.getString(resultSet,11));
            prpLinterRequestDto.setReportType(dbManager.getString(resultSet,12));
            prpLinterRequestDto.setLinkerName(dbManager.getString(resultSet,13));
            prpLinterRequestDto.setPhoneNumber(dbManager.getString(resultSet,14));
            prpLinterRequestDto.setLinkerAddress(dbManager.getString(resultSet,15));
            prpLinterRequestDto.setClauseType(dbManager.getString(resultSet,16));
            prpLinterRequestDto.setDamageAddress(dbManager.getString(resultSet,17));
            prpLinterRequestDto.setDamageTypeCode(dbManager.getString(resultSet,18));
            prpLinterRequestDto.setLossesNumber(dbManager.getDouble(resultSet,19));
            prpLinterRequestDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLinterRequestDto.setOperatorName(dbManager.getString(resultSet,21));
            prpLinterRequestDto.setMakeCom(dbManager.getString(resultSet,22));
            prpLinterRequestDto.setMakeComName(dbManager.getString(resultSet,23));
            prpLinterRequestDto.setRemark(dbManager.getString(resultSet,24));
            prpLinterRequestDto.setContext(dbManager.getString(resultSet,25));
            prpLinterRequestDto.setEstimateLoss(dbManager.getDouble(resultSet,26));
            prpLinterRequestDto.setScheduleObjectId(dbManager.getString(resultSet,27));
            prpLinterRequestDto.setCheckSite(dbManager.getString(resultSet,28));
            prpLinterRequestDto.setCheckInfo(dbManager.getString(resultSet,29));
            prpLinterRequestDto.setNextHandlerCode(dbManager.getString(resultSet,30));
            prpLinterRequestDto.setNextHandlerName(dbManager.getString(resultSet,31));
            prpLinterRequestDto.setChecker2(dbManager.getString(resultSet,32));
            prpLinterRequestDto.setCheckType(dbManager.getString(resultSet,33));
            prpLinterRequestDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLinterRequestDto.setCheckNature(dbManager.getString(resultSet,35));
            prpLinterRequestDto.setCheckEstimateLoss(dbManager.getDouble(resultSet,36));
            prpLinterRequestDto.setEstimateFee(dbManager.getDouble(resultSet,37));
            prpLinterRequestDto.setUnitType(dbManager.getString(resultSet,38));
            prpLinterRequestDto.setCheckRemark(dbManager.getString(resultSet,39));
            prpLinterRequestDto.setCheckContext(dbManager.getString(resultSet,40));
            prpLinterRequestDto.setCurrency(dbManager.getString(resultSet,41));
            prpLinterRequestDto.setDamageTypeName(dbManager.getString(resultSet,42));
            prpLinterRequestDto.setReplevyFlag(dbManager.getString(resultSet,43));
            prpLinterRequestDto.setThirdComFlag(dbManager.getString(resultSet,44));
            prpLinterRequestDto.setSumClaim(dbManager.getDouble(resultSet,45));
            prpLinterRequestDto.setClaimType(dbManager.getString(resultSet,46));
            prpLinterRequestDto.setCaseType(dbManager.getString(resultSet,47));
            prpLinterRequestDto.setPayAppContext(dbManager.getString(resultSet,48));
            prpLinterRequestDto.setSumPrePaid(dbManager.getDouble(resultSet,49));
            prpLinterRequestDto.setPrepayReport(dbManager.getString(resultSet,50));
            prpLinterRequestDto.setCertifyContext(dbManager.getString(resultSet,51));
            prpLinterRequestDto.setBank(dbManager.getString(resultSet,52));
            prpLinterRequestDto.setReceiverName(dbManager.getString(resultSet,53));
            prpLinterRequestDto.setAccount(dbManager.getString(resultSet,54));
            prpLinterRequestDto.setAccountOK(dbManager.getString(resultSet,55));
            prpLinterRequestDto.setZeroLossType(dbManager.getString(resultSet,56));
            prpLinterRequestDto.setSumNoDutyFee(dbManager.getDouble(resultSet,57));
            prpLinterRequestDto.setPrplCompensateSumPaid(dbManager.getDouble(resultSet,58));
            prpLinterRequestDto.setPrplCompensateSumPrePaid(dbManager.getDouble(resultSet,59));
            prpLinterRequestDto.setSumChargePaid(dbManager.getDouble(resultSet,60));
            prpLinterRequestDto.setSumThisPaid(dbManager.getDouble(resultSet,61));
            prpLinterRequestDto.setCompeContext(dbManager.getString(resultSet,62));
            prpLinterRequestDto.setNotion(dbManager.getString(resultSet,63));
            prpLinterRequestDto.setHandleText(dbManager.getString(resultSet,64));
            prpLinterRequestDto.setMutualFlag(dbManager.getString(resultSet,65));
            prpLinterRequestDto.setOutRigstNo(dbManager.getString(resultSet,66));
            prpLinterRequestDto.setInputRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,67));
            prpLinterRequestDto.setInputCompeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,68));
            prpLinterRequestDto.setRegistAutoFlag(dbManager.getString(resultSet,69));
            prpLinterRequestDto.setCompeAutoFlag(dbManager.getString(resultSet,70));
            prpLinterRequestDto.setClaimAutoFlag(dbManager.getString(resultSet,71));
            prpLinterRequestDto.setRegistUser(dbManager.getString(resultSet,72));
            prpLinterRequestDto.setRegistTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,73));
            prpLinterRequestDto.setCompeUser(dbManager.getString(resultSet,74));
            prpLinterRequestDto.setCompeTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,75));
            prpLinterRequestDto.setVericUser(dbManager.getString(resultSet,76));
            prpLinterRequestDto.setVericTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,77));
            prpLinterRequestDto.setOutId(dbManager.getString(resultSet,78));
        }
        resultSet.close();
        return prpLinterRequestDto;
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
        buffer.append("Id,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("EstimateLoss,");
        buffer.append("ScheduleObjectId,");
        buffer.append("CheckSite,");
        buffer.append("CheckInfo,");
        buffer.append("NextHandlerCode,");
        buffer.append("NextHandlerName,");
        buffer.append("Checker2,");
        buffer.append("CheckType,");
        buffer.append("CheckDate,");
        buffer.append("CheckNature,");
        buffer.append("CheckEstimateLoss,");
        buffer.append("EstimateFee,");
        buffer.append("UnitType,");
        buffer.append("CheckRemark,");
        buffer.append("CheckContext,");
        buffer.append("Currency,");
        buffer.append("DamageTypeName,");
        buffer.append("ReplevyFlag,");
        buffer.append("ThirdComFlag,");
        buffer.append("SumClaim,");
        buffer.append("ClaimType,");
        buffer.append("CaseType,");
        buffer.append("PayAppContext,");
        buffer.append("SumPrePaid,");
        buffer.append("PrepayReport,");
        buffer.append("CertifyContext,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("MutualFlag,");
        buffer.append("OutRigstNo,"); 
        buffer.append("InputRegistDate,");
        buffer.append("InputCompeDate,");
        buffer.append("RegistAutoFlag,"); 
        buffer.append("CompeAutoFlag,"); 
        buffer.append("ClaimAutoFlag,"); 
        buffer.append("RegistUser,"); 
        buffer.append("RegistTime,"); 
        buffer.append("CompeUser,"); 
        buffer.append("CompeTime,"); 
        buffer.append("VericUser,"); 
        buffer.append("VericTime,"); 
        buffer.append("OutId ");
        buffer.append("FROM PrpLinterRequest WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLinterRequestDto prpLinterRequestDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterRequestDto = new PrpLinterRequestDto();
            prpLinterRequestDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prpLinterRequestDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prpLinterRequestDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prpLinterRequestDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prpLinterRequestDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"DamageStartDate"));
            prpLinterRequestDto.setDamageStartHour(dbManager.getString(resultSet,"DamageStartHour"));
            prpLinterRequestDto.setDamageCode(dbManager.getString(resultSet,"DamageCode"));
            prpLinterRequestDto.setReportName(dbManager.getString(resultSet,"ReportName"));
            prpLinterRequestDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"ReportDate"));
            prpLinterRequestDto.setReportHour(dbManager.getString(resultSet,"ReportHour"));
            prpLinterRequestDto.setReportType(dbManager.getString(resultSet,"ReportType"));
            prpLinterRequestDto.setLinkerName(dbManager.getString(resultSet,"LinkerName"));
            prpLinterRequestDto.setPhoneNumber(dbManager.getString(resultSet,"PhoneNumber"));
            prpLinterRequestDto.setLinkerAddress(dbManager.getString(resultSet,"LinkerAddress"));
            prpLinterRequestDto.setClauseType(dbManager.getString(resultSet,"ClauseType"));
            prpLinterRequestDto.setDamageAddress(dbManager.getString(resultSet,"DamageAddress"));
            prpLinterRequestDto.setDamageTypeCode(dbManager.getString(resultSet,"DamageTypeCode"));
            prpLinterRequestDto.setLossesNumber(dbManager.getDouble(resultSet,"LossesNumber"));
            prpLinterRequestDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLinterRequestDto.setOperatorName(dbManager.getString(resultSet,"OperatorName"));
            prpLinterRequestDto.setMakeCom(dbManager.getString(resultSet,"MakeCom"));
            prpLinterRequestDto.setMakeComName(dbManager.getString(resultSet,"MakeComName"));
            prpLinterRequestDto.setRemark(dbManager.getString(resultSet,"Remark"));
            prpLinterRequestDto.setContext(dbManager.getString(resultSet,"Context"));
            prpLinterRequestDto.setEstimateLoss(dbManager.getDouble(resultSet,"EstimateLoss"));
            prpLinterRequestDto.setScheduleObjectId(dbManager.getString(resultSet,"ScheduleObjectId"));
            prpLinterRequestDto.setCheckSite(dbManager.getString(resultSet,"CheckSite"));
            prpLinterRequestDto.setCheckInfo(dbManager.getString(resultSet,"CheckInfo"));
            prpLinterRequestDto.setNextHandlerCode(dbManager.getString(resultSet,"NextHandlerCode"));
            prpLinterRequestDto.setNextHandlerName(dbManager.getString(resultSet,"NextHandlerName"));
            prpLinterRequestDto.setChecker2(dbManager.getString(resultSet,"Checker2"));
            prpLinterRequestDto.setCheckType(dbManager.getString(resultSet,"CheckType"));
            prpLinterRequestDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"CheckDate"));
            prpLinterRequestDto.setCheckNature(dbManager.getString(resultSet,"CheckNature"));
            prpLinterRequestDto.setCheckEstimateLoss(dbManager.getDouble(resultSet,"CheckEstimateLoss"));
            prpLinterRequestDto.setEstimateFee(dbManager.getDouble(resultSet,"EstimateFee"));
            prpLinterRequestDto.setUnitType(dbManager.getString(resultSet,"UnitType"));
            prpLinterRequestDto.setCheckRemark(dbManager.getString(resultSet,"CheckRemark"));
            prpLinterRequestDto.setCheckContext(dbManager.getString(resultSet,"CheckContext"));
            prpLinterRequestDto.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpLinterRequestDto.setDamageTypeName(dbManager.getString(resultSet,"DamageTypeName"));
            prpLinterRequestDto.setReplevyFlag(dbManager.getString(resultSet,"ReplevyFlag"));
            prpLinterRequestDto.setThirdComFlag(dbManager.getString(resultSet,"ThirdComFlag"));
            prpLinterRequestDto.setSumClaim(dbManager.getDouble(resultSet,"SumClaim"));
            prpLinterRequestDto.setClaimType(dbManager.getString(resultSet,"ClaimType"));
            prpLinterRequestDto.setCaseType(dbManager.getString(resultSet,"CaseType"));
            prpLinterRequestDto.setPayAppContext(dbManager.getString(resultSet,"PayAppContext"));
            prpLinterRequestDto.setSumPrePaid(dbManager.getDouble(resultSet,"SumPrePaid"));
            prpLinterRequestDto.setPrepayReport(dbManager.getString(resultSet,"PrepayReport"));
            prpLinterRequestDto.setCertifyContext(dbManager.getString(resultSet,"CertifyContext"));
            prpLinterRequestDto.setBank(dbManager.getString(resultSet,"Bank"));
            prpLinterRequestDto.setReceiverName(dbManager.getString(resultSet,"ReceiverName"));
            prpLinterRequestDto.setAccount(dbManager.getString(resultSet,"Account"));
            prpLinterRequestDto.setAccountOK(dbManager.getString(resultSet,"AccountOK"));
            prpLinterRequestDto.setZeroLossType(dbManager.getString(resultSet,"ZeroLossType"));
            prpLinterRequestDto.setSumNoDutyFee(dbManager.getDouble(resultSet,"SumNoDutyFee"));
            prpLinterRequestDto.setPrplCompensateSumPaid(dbManager.getDouble(resultSet,"PrplCompensateSumPaid"));
            prpLinterRequestDto.setPrplCompensateSumPrePaid(dbManager.getDouble(resultSet,"PrplCompensateSumPrePaid"));
            prpLinterRequestDto.setSumChargePaid(dbManager.getDouble(resultSet,"SumChargePaid"));
            prpLinterRequestDto.setSumThisPaid(dbManager.getDouble(resultSet,"SumThisPaid"));
            prpLinterRequestDto.setCompeContext(dbManager.getString(resultSet,"CompeContext"));
            prpLinterRequestDto.setNotion(dbManager.getString(resultSet,"Notion"));
            prpLinterRequestDto.setHandleText(dbManager.getString(resultSet,"HandleText"));
            prpLinterRequestDto.setMutualFlag(dbManager.getString(resultSet,"MutualFlag"));
            prpLinterRequestDto.setOutRigstNo(dbManager.getString(resultSet,"OutRigstNo"));
            prpLinterRequestDto.setInputRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputRegistDate"));
            prpLinterRequestDto.setInputCompeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputCompeDate"));
            prpLinterRequestDto.setRegistAutoFlag(dbManager.getString(resultSet,"RegistAutoFlag"));
            prpLinterRequestDto.setCompeAutoFlag(dbManager.getString(resultSet,"CompeAutoFlag"));
            prpLinterRequestDto.setClaimAutoFlag(dbManager.getString(resultSet,"ClaimAutoFlag"));
            prpLinterRequestDto.setRegistUser(dbManager.getString(resultSet,"RegistUser"));
            prpLinterRequestDto.setRegistTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"RegistTime"));
            prpLinterRequestDto.setCompeUser(dbManager.getString(resultSet,"CompeUser"));
            prpLinterRequestDto.setCompeTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"CompeTime"));
            prpLinterRequestDto.setVericUser(dbManager.getString(resultSet,"VericUser"));
            prpLinterRequestDto.setVericTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"VericTime"));
            prpLinterRequestDto.setOutId(dbManager.getString(resultSet,"OutId"));
            collection.add(prpLinterRequestDto);
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
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findBySQL(String conditions)
            throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
    	ResultSet resultSet = dbManager.executeQuery(conditions);
        int count=0;

        //定义返回结果集合
        Collection collection = new ArrayList();
        PrpLinterRequestDto prpLinterRequestDto = null;
        while(resultSet.next()){

            prpLinterRequestDto = new PrpLinterRequestDto();
            prpLinterRequestDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLinterRequestDto.setClaimno(dbManager.getString(resultSet,2));
            prpLinterRequestDto.setRegistno(dbManager.getString(resultSet,3));
            collection.add(prpLinterRequestDto);
        }
        resultSet.close();
        return collection;
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
        buffer.append("DELETE FROM PrpLinterRequest WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterRequest WHERE ");
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
