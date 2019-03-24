package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcompensate-赔款计算书表的数据访问对象基类<br>
 * 创建于 2005-05-26 09:04:13.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcompensateBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcompensateBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    
    public DBPrpLcompensateBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void insert(PrpLcompensateDto prpLcompensateDto) throws Exception{
        String mainStatement = " Insert Into PrpLcompensate (" + 
                           " CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " FinallyFlag," +
                           " MedicalType," +
                           " WoundGrade,"  +
        				   " claimType,"  +
        				   " thridLicenseNo,"  +
        				   " thridCompany," +
        				   " BusinessFlag," +
        				   " OtherFlag,"  +
        				   " ObjectName," +
        				   " ObjectType," +
        				   " ObjectCode," + 
        				   " UploadSerialNo," +
        				   " payRefDate," +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason ," +
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
        				   " )";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcompensateDto.getCompensateNo() + "'," + 
                           "'" + prpLcompensateDto.getLFlag() + "'," + 
                           "'" + prpLcompensateDto.getCaseNo() + "'," + 
                           "" + prpLcompensateDto.getTimes() + "," + 
                           "'" + prpLcompensateDto.getClassCode() + "'," + 
                           "'" + prpLcompensateDto.getRiskCode() + "'," + 
                           "'" + prpLcompensateDto.getClaimNo() + "'," + 
                           "'" + prpLcompensateDto.getPolicyNo() + "'," + 
                           "'" + prpLcompensateDto.getDeductCond() + "'," + 
                           "'" + prpLcompensateDto.getPreserveDate() + "'," + 
                           "'" + prpLcompensateDto.getCheckAgentCode() + "'," + 
                           "'" + prpLcompensateDto.getCheckAgentName() + "'," + 
                           "'" + prpLcompensateDto.getSurveyorName() + "'," + 
                           "'" + prpLcompensateDto.getCounterClaimerName() + "'," + 
                           "'" + prpLcompensateDto.getDutyDescription() + "'," + 
                           "'" + prpLcompensateDto.getCurrency() + "'," + 
                           "'" + prpLcompensateDto.getSumLoss() + "'," + 
                           "'" + prpLcompensateDto.getSumRest() + "'," + 
                           "'" + prpLcompensateDto.getSumDutyPaid() + "'," + 
                           "'" + prpLcompensateDto.getSumNoDutyFee() + "'," + 
                           "'" + prpLcompensateDto.getSumPaid() + "'," + 
                           "'" + prpLcompensateDto.getSumPrePaid() + "'," + 
                           "'" + prpLcompensateDto.getSumThisPaid() + "'," + 
                           "'" + prpLcompensateDto.getReceiverName() + "'," + 
                           "'" + prpLcompensateDto.getBank() + "'," + 
                           "'" + prpLcompensateDto.getAccount() + "'," + 
                           "'" + prpLcompensateDto.getMakeCom() + "'," + 
                           "'" + prpLcompensateDto.getComCode() + "'," + 
                           "'" + prpLcompensateDto.getHandlerCode() + "'," + 
                           "'" + prpLcompensateDto.getHandler1Code() + "'," + 
                           "'" + prpLcompensateDto.getApproverCode() + "'," + 
                           "'" + prpLcompensateDto.getUnderWriteCode() + "'," + 
                           "'" + prpLcompensateDto.getUnderWriteName() + "'," + 
                           "'" + prpLcompensateDto.getStatisticsYM() + "'," + 
                           "'" + prpLcompensateDto.getOperatorCode() + "'," + 
                           "'" + prpLcompensateDto.getInputDate() + "'," + 
                           "'" + prpLcompensateDto.getUnderWriteEndDate() + "'," + 
                           "'" + prpLcompensateDto.getUnderWriteFlag() + "'," + 
                           "'" + prpLcompensateDto.getRemark() + "'," + 
                           "'" + prpLcompensateDto.getFlag() + "'," + 
                           "'" + prpLcompensateDto.getCaseType() + "'," + 
                           "'" + prpLcompensateDto.getIndemnityDutyRate() + "'," + 
                           "'" + prpLcompensateDto.getIndemnityDuty() + "'," + 
                           "'" + prpLcompensateDto.getResult() + "'," + 
                           "" + prpLcompensateDto.getLossesNumber() + "," + 
                           "'" + prpLcompensateDto.getLossesUnitCode() + "'," + 
                           "" + prpLcompensateDto.getDamageInsured() + "," + 
                           "" + prpLcompensateDto.getDisasterArea() + "," + 
                           "'" + prpLcompensateDto.getDisasterUnit() + "'," + 
                           "" + prpLcompensateDto.getAffectedArea() + "," + 
                           "'" + prpLcompensateDto.getAffectedUnit() + "'," + 
                           "" + prpLcompensateDto.getNoProductionArea() + "," + 
                           "'" + prpLcompensateDto.getNoProductionUnit() + "'," + 
                           "" + prpLcompensateDto.getDeathQuantity() + "," + 
                           "'" + prpLcompensateDto.getDeathUnit() + "'," + 
                           "" + prpLcompensateDto.getKillQuantity() + "," + 
                           "'" + prpLcompensateDto.getKillUnit() + "'," + 
                           "'" + prpLcompensateDto.getBusinessType() + "'," + 
                           "'" + prpLcompensateDto.getBusinessType1() + "'," + 
                           "'" + prpLcompensateDto.getFinallyFlag() + "'," + 
                           "'" + prpLcompensateDto.getMedicalType() + "'," +
                           "'" + prpLcompensateDto.getWoundGrade() +"'," +
            			   "'" + prpLcompensateDto.getClaimType() +"'," +
            			   "'" + prpLcompensateDto.getThridLicenseNos() +"'," +
            			   "'" + prpLcompensateDto.getThridCompanys() +"'," +
            			   "'" + prpLcompensateDto.getBusinessFlag() +"'," +
            			   "'" + prpLcompensateDto.getOtherFlag() +"')," +
            			   "'" + prpLcompensateDto.getClaimRelationNo() +"', " +
            			   "'" + prpLcompensateDto.getCoinsPaidLossType() +"', " +
            			   "'" + prpLcompensateDto.getCoinsSumPaid() +"', "+
            			   "'" + prpLcompensateDto.getClaimNotification() +"', "+
            			   "'" + prpLcompensateDto.getInncentTreatment() +"', "+
                           "'" + prpLcompensateDto.getLawsuitFlag()+"') ";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcompensateDto.getCompensateNo());
        dbManager.setString(2,prpLcompensateDto.getLFlag());
        dbManager.setString(3,prpLcompensateDto.getCaseNo());
        dbManager.setInt(4,prpLcompensateDto.getTimes());
        dbManager.setString(5,prpLcompensateDto.getClassCode());
        dbManager.setString(6,prpLcompensateDto.getRiskCode());
        dbManager.setString(7,prpLcompensateDto.getClaimNo());
        dbManager.setString(8,prpLcompensateDto.getPolicyNo());
        dbManager.setString(9,prpLcompensateDto.getDeductCond());
        dbManager.setDateTime(10,prpLcompensateDto.getPreserveDate());
        dbManager.setString(11,prpLcompensateDto.getCheckAgentCode());
        dbManager.setString(12,prpLcompensateDto.getCheckAgentName());
        dbManager.setString(13,prpLcompensateDto.getSurveyorName());
        dbManager.setString(14,prpLcompensateDto.getCounterClaimerName());
        dbManager.setString(15,prpLcompensateDto.getDutyDescription());
        dbManager.setString(16,prpLcompensateDto.getCurrency());
        dbManager.setDouble(17,prpLcompensateDto.getSumLoss());
        dbManager.setDouble(18,prpLcompensateDto.getSumRest());
        dbManager.setDouble(19,prpLcompensateDto.getSumDutyPaid());
        dbManager.setDouble(20,prpLcompensateDto.getSumNoDutyFee());
        dbManager.setDouble(21,prpLcompensateDto.getSumPaid());
        dbManager.setDouble(22,prpLcompensateDto.getSumPrePaid());
        dbManager.setDouble(23,prpLcompensateDto.getSumThisPaid());
        dbManager.setString(24,prpLcompensateDto.getReceiverName());
        dbManager.setString(25,prpLcompensateDto.getBank());
        dbManager.setString(26,prpLcompensateDto.getAccount());
        dbManager.setString(27,prpLcompensateDto.getMakeCom());
        dbManager.setString(28,prpLcompensateDto.getComCode());
        dbManager.setString(29,prpLcompensateDto.getHandlerCode());
        dbManager.setString(30,prpLcompensateDto.getHandler1Code());
        dbManager.setString(31,prpLcompensateDto.getApproverCode());
        dbManager.setString(32,prpLcompensateDto.getUnderWriteCode());
        dbManager.setString(33,prpLcompensateDto.getUnderWriteName());
        dbManager.setDateTime(34,prpLcompensateDto.getStatisticsYM());
        dbManager.setString(35,prpLcompensateDto.getOperatorCode());
        dbManager.setDateTime(36,prpLcompensateDto.getInputDate());
        dbManager.setDateTime(37,prpLcompensateDto.getUnderWriteEndDate());
        dbManager.setString(38,prpLcompensateDto.getUnderWriteFlag());
        dbManager.setString(39,prpLcompensateDto.getRemark());
        dbManager.setString(40,prpLcompensateDto.getFlag());
        dbManager.setString(41,prpLcompensateDto.getCaseType());
        dbManager.setDouble(42,prpLcompensateDto.getIndemnityDutyRate());
        dbManager.setString(43,prpLcompensateDto.getIndemnityDuty());
        dbManager.setString(44,prpLcompensateDto.getResult());
        dbManager.setDouble(45,prpLcompensateDto.getLossesNumber());
        dbManager.setString(46,prpLcompensateDto.getLossesUnitCode());
        dbManager.setDouble(47,prpLcompensateDto.getDamageInsured());
        dbManager.setDouble(48,prpLcompensateDto.getDisasterArea());
        dbManager.setString(49,prpLcompensateDto.getDisasterUnit());
        dbManager.setDouble(50,prpLcompensateDto.getAffectedArea());
        dbManager.setString(51,prpLcompensateDto.getAffectedUnit());
        dbManager.setDouble(52,prpLcompensateDto.getNoProductionArea());
        dbManager.setString(53,prpLcompensateDto.getNoProductionUnit());
        dbManager.setDouble(54,prpLcompensateDto.getDeathQuantity());
        dbManager.setString(55,prpLcompensateDto.getDeathUnit());
        dbManager.setDouble(56,prpLcompensateDto.getKillQuantity());
        dbManager.setString(57,prpLcompensateDto.getKillUnit());
        dbManager.setString(58,prpLcompensateDto.getBusinessType());
        dbManager.setString(59,prpLcompensateDto.getBusinessType1());

        dbManager.setString(60,prpLcompensateDto.getFinallyFlag());
        dbManager.setString(61,prpLcompensateDto.getMedicalType());
        dbManager.setString(62,prpLcompensateDto.getWoundGrade());
        dbManager.setString(63,prpLcompensateDto.getClaimType());
        dbManager.setString(64,prpLcompensateDto.getThridLicenseNos());
        dbManager.setString(65,prpLcompensateDto.getThridCompanys());
        dbManager.setString(66,prpLcompensateDto.getBusinessFlag());
        dbManager.setString(67,prpLcompensateDto.getOtherFlag());
        dbManager.setString(68,prpLcompensateDto.getOjectName());
        dbManager.setString(69,prpLcompensateDto.getOjectType());
        dbManager.setString(70,prpLcompensateDto.getOjectCode());
        dbManager.setString(71,prpLcompensateDto.getUploadSerialNo());
        dbManager.setDateTime(72,prpLcompensateDto.getPayrefDate());
        dbManager.setString(73, prpLcompensateDto.getClaimRelationNo());
        dbManager.setString(74, prpLcompensateDto.getZeroLossType());
        dbManager.setString(75, prpLcompensateDto.getZeroLossCaseType());
        dbManager.setString(76, prpLcompensateDto.getZeroLossDetailReason());
        
        dbManager.setString(77, prpLcompensateDto.getCoinsPaidLossType());
        dbManager.setDouble(78, prpLcompensateDto.getCoinsSumPaid());
        dbManager.setString(79, prpLcompensateDto.getClaimNotification());
        dbManager.setString(80, prpLcompensateDto.getInncentTreatment());
        
        dbManager.setString(81,prpLcompensateDto.getLawsuitFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcompensateBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcompensate (" + 
                           " CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " Result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " MedicalType," +
                           " WoundGrade,"  +
        				   " claimType,"  +
        				   " thridLicenseNo,"  +
        				   " thridCompany," +
        				   " BusinessFlag," +
        				   " OtherFLag,"  +
        				   " ObjectName," +
        				   " ObjectType," +
        				   " ObjectCode," +
        				   " uploadSerialNo," +
        				   " payRefDate," +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason ," +
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
        				   ")";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)i.next();
            dbManager.setString(1,prpLcompensateDto.getCompensateNo());
            dbManager.setString(2,prpLcompensateDto.getLFlag());
            dbManager.setString(3,prpLcompensateDto.getCaseNo());
            dbManager.setInt(4,prpLcompensateDto.getTimes());
            dbManager.setString(5,prpLcompensateDto.getClassCode());
            dbManager.setString(6,prpLcompensateDto.getRiskCode());
            dbManager.setString(7,prpLcompensateDto.getClaimNo());
            dbManager.setString(8,prpLcompensateDto.getPolicyNo());
            dbManager.setString(9,prpLcompensateDto.getDeductCond());
            dbManager.setDateTime(10,prpLcompensateDto.getPreserveDate());
            dbManager.setString(11,prpLcompensateDto.getCheckAgentCode());
            dbManager.setString(12,prpLcompensateDto.getCheckAgentName());
            dbManager.setString(13,prpLcompensateDto.getSurveyorName());
            dbManager.setString(14,prpLcompensateDto.getCounterClaimerName());
            dbManager.setString(15,prpLcompensateDto.getDutyDescription());
            dbManager.setString(16,prpLcompensateDto.getCurrency());
            dbManager.setDouble(17,prpLcompensateDto.getSumLoss());
            dbManager.setDouble(18,prpLcompensateDto.getSumRest());
            dbManager.setDouble(19,prpLcompensateDto.getSumDutyPaid());
            dbManager.setDouble(20,prpLcompensateDto.getSumNoDutyFee());
            dbManager.setDouble(21,prpLcompensateDto.getSumPaid());
            dbManager.setDouble(22,prpLcompensateDto.getSumPrePaid());
            dbManager.setDouble(23,prpLcompensateDto.getSumThisPaid());
            dbManager.setString(24,prpLcompensateDto.getReceiverName());
            dbManager.setString(25,prpLcompensateDto.getBank());
            dbManager.setString(26,prpLcompensateDto.getAccount());
            dbManager.setString(27,prpLcompensateDto.getMakeCom());
            dbManager.setString(28,prpLcompensateDto.getComCode());
            dbManager.setString(29,prpLcompensateDto.getHandlerCode());
            dbManager.setString(30,prpLcompensateDto.getHandler1Code());
            dbManager.setString(31,prpLcompensateDto.getApproverCode());
            dbManager.setString(32,prpLcompensateDto.getUnderWriteCode());
            dbManager.setString(33,prpLcompensateDto.getUnderWriteName());
            dbManager.setDateTime(34,prpLcompensateDto.getStatisticsYM());
            dbManager.setString(35,prpLcompensateDto.getOperatorCode());
            dbManager.setDateTime(36,prpLcompensateDto.getInputDate());
            dbManager.setDateTime(37,prpLcompensateDto.getUnderWriteEndDate());
            dbManager.setString(38,prpLcompensateDto.getUnderWriteFlag());
            dbManager.setString(39,prpLcompensateDto.getRemark());
            dbManager.setString(40,prpLcompensateDto.getFlag());
            dbManager.setString(41,prpLcompensateDto.getCaseType());
            dbManager.setDouble(42,prpLcompensateDto.getIndemnityDutyRate());
            dbManager.setString(43,prpLcompensateDto.getIndemnityDuty());
            dbManager.setString(44,prpLcompensateDto.getResult());
            dbManager.setDouble(45,prpLcompensateDto.getLossesNumber());
            dbManager.setString(46,prpLcompensateDto.getLossesUnitCode());
            dbManager.setDouble(47,prpLcompensateDto.getDamageInsured());
            dbManager.setDouble(48,prpLcompensateDto.getDisasterArea());
            dbManager.setString(49,prpLcompensateDto.getDisasterUnit());
            dbManager.setDouble(50,prpLcompensateDto.getAffectedArea());
            dbManager.setString(51,prpLcompensateDto.getAffectedUnit());
            dbManager.setDouble(52,prpLcompensateDto.getNoProductionArea());
            dbManager.setString(53,prpLcompensateDto.getNoProductionUnit());
            dbManager.setDouble(54,prpLcompensateDto.getDeathQuantity());
            dbManager.setString(55,prpLcompensateDto.getDeathUnit());
            dbManager.setDouble(56,prpLcompensateDto.getKillQuantity());
            dbManager.setString(57,prpLcompensateDto.getKillUnit());
            dbManager.setString(58,prpLcompensateDto.getBusinessType());
            dbManager.setString(59,prpLcompensateDto.getBusinessType1());

            dbManager.setString(60,prpLcompensateDto.getFinallyFlag());
            dbManager.setString(61,prpLcompensateDto.getMedicalType());
            dbManager.setString(62,prpLcompensateDto.getWoundGrade());
            dbManager.setString(63,prpLcompensateDto.getClaimType());
        	dbManager.setString(64,prpLcompensateDto.getThridLicenseNos());
        	dbManager.setString(65,prpLcompensateDto.getThridCompanys());
        	dbManager.setString(66,prpLcompensateDto.getBusinessFlag());
        	dbManager.setString(67,prpLcompensateDto.getOtherFlag());
            dbManager.setString(68,prpLcompensateDto.getOjectName());
            dbManager.setString(69,prpLcompensateDto.getOjectType());
            dbManager.setString(70,prpLcompensateDto.getOjectCode());
            dbManager.setString(71,prpLcompensateDto.getUploadSerialNo());
            dbManager.setDateTime(72,prpLcompensateDto.getPayrefDate());
            dbManager.setString(73, prpLcompensateDto.getClaimRelationNo());
            dbManager.setString(74, prpLcompensateDto.getZeroLossType());
            dbManager.setString(75, prpLcompensateDto.getZeroLossCaseType());
            dbManager.setString(76, prpLcompensateDto.getZeroLossDetailReason());
            dbManager.setString(77, prpLcompensateDto.getCoinsPaidLossType());
            dbManager.setDouble(78, prpLcompensateDto.getCoinsSumPaid());
            dbManager.setString(79, prpLcompensateDto.getClaimNotification());
            dbManager.setString(80, prpLcompensateDto.getInncentTreatment());
            dbManager.setString(81, prpLcompensateDto.getLawsuitFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcompensateBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号码
     * @throws Exception
     */
    public void delete(String compensateNo) throws Exception{
        String statement = " Delete From PrpLcompensate" + 
	            		   " Where " +
                           " CompensateNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcompensate Where " +
                           " CompensateNo = '" + compensateNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcompensateBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void update(PrpLcompensateDto prpLcompensateDto) throws Exception{
        String statement = " Update PrpLcompensate Set LFlag = ?," + 
                           " CaseNo = ?," + 
                           " Times = ?," + 
                           " ClassCode = ?," + 
                           " RiskCode = ?," + 
                           " ClaimNo = ?," + 
                           " PolicyNo = ?," + 
                           " DeductCond = ?," + 
                           " PreserveDate = ?," + 
                           " CheckAgentCode = ?," + 
                           " CheckAgentName = ?," + 
                           " SurveyorName = ?," + 
                           " CounterClaimerName = ?," + 
                           " DutyDescription = ?," + 
                           " Currency = ?," + 
                           " SumLoss = ?," + 
                           " SumRest = ?," + 
                           " SumDutyPaid = ?," + 
                           " SumNoDutyFee = ?," + 
                           " SumPaid = ?," + 
                           " SumPrePaid = ?," + 
                           " SumThisPaid = ?," + 
                           " ReceiverName = ?," + 
                           " Bank = ?," + 
                           " Account = ?," + 
                           " MakeCom = ?," + 
                           " ComCode = ?," + 
                           " HandlerCode = ?," + 
                           " Handler1Code = ?," + 
                           " ApproverCode = ?," + 
                           " UnderWriteCode = ?," + 
                           " UnderWriteName = ?," + 
                           " StatisticsYM = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " UnderWriteEndDate = ?," + 
                           " UnderWriteFlag = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " CaseType = ?," + 
                           " IndemnityDutyRate = ?," + 
                           " IndemnityDuty = ?," + 
                           " Result = ?," + 
                           " LossesNumber = ?," + 
                           " LossesUnitCode = ?," + 
                           " DamageInsured = ?," + 
                           " DisasterArea = ?," + 
                           " DisasterUnit = ?," + 
                           " AffectedArea = ?," + 
                           " AffectedUnit = ?," + 
                           " NoProductionArea = ?," + 
                           " NoProductionUnit = ?," + 
                           " DeathQuantity = ?," + 
                           " DeathUnit = ?," + 
                           " KillQuantity = ?," + 
                           " KillUnit = ?," +
                           " BusinessType = ?," +
                           " BusinessType1 = ?," +
                           " FinallyFlag = ?," +
                           " MedicalType = ?," + 
                           " WoundGrade = ?," +
                           " claimType = ?," +
                           " thridLicenseNo = ?," +
                           " thridCompany = ?," +
                           " BusinessFlag = ?," +
                           " OtherFlag = ?, " +
                           " ObjectName = ?," +
                           " ObjectType = ?," +
                           " ObjectCode = ?," +
                           " uploadSerialNo = ?," +
                           " payRefDate = ?, " +
                           " claimRelationNo = ?, " +
                           " zeroLossType = ?, " +
                           " zeroLossCaseType = ?, " +
                           " zeroLossDetailReason = ? , " +
        				   " coinsPaidLossType = ? ," +
        				   " coinsSumPaid = ? ," +
        				   " claimNotification = ? ," +
        				   " inncentTreatment = ? ," +
        				   " lawsuitFlag = ?  " +
	            		   " Where " +
                           " CompensateNo = ?";
                           //ObjectName,ObjectType,ObjectCode
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcompensate Set " + 
                           " CompensateNo = '" + prpLcompensateDto.getCompensateNo() + "'," + 
                           " LFlag = '" + prpLcompensateDto.getLFlag() + "'," + 
                           " CaseNo = '" + prpLcompensateDto.getCaseNo() + "'," + 
                           " Times = " + prpLcompensateDto.getTimes() + "," + 
                           " ClassCode = '" + prpLcompensateDto.getClassCode() + "'," + 
                           " RiskCode = '" + prpLcompensateDto.getRiskCode() + "'," + 
                           " ClaimNo = '" + prpLcompensateDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLcompensateDto.getPolicyNo() + "'," + 
                           " DeductCond = '" + prpLcompensateDto.getDeductCond() + "'," + 
                           " PreserveDate = '" + prpLcompensateDto.getPreserveDate() + "'," + 
                           " CheckAgentCode = '" + prpLcompensateDto.getCheckAgentCode() + "'," + 
                           " CheckAgentName = '" + prpLcompensateDto.getCheckAgentName() + "'," + 
                           " SurveyorName = '" + prpLcompensateDto.getSurveyorName() + "'," + 
                           " CounterClaimerName = '" + prpLcompensateDto.getCounterClaimerName() + "'," + 
                           " DutyDescription = '" + prpLcompensateDto.getDutyDescription() + "'," + 
                           " Currency = '" + prpLcompensateDto.getCurrency() + "'," + 
                           " SumLoss = '" + prpLcompensateDto.getSumLoss() + "'," + 
                           " SumRest = '" + prpLcompensateDto.getSumRest() + "'," + 
                           " SumDutyPaid = '" + prpLcompensateDto.getSumDutyPaid() + "'," + 
                           " SumNoDutyFee = '" + prpLcompensateDto.getSumNoDutyFee() + "'," + 
                           " SumPaid = '" + prpLcompensateDto.getSumPaid() + "'," + 
                           " SumPrePaid = '" + prpLcompensateDto.getSumPrePaid() + "'," + 
                           " SumThisPaid = '" + prpLcompensateDto.getSumThisPaid() + "'," + 
                           " ReceiverName = '" + prpLcompensateDto.getReceiverName() + "'," + 
                           " Bank = '" + prpLcompensateDto.getBank() + "'," + 
                           " Account = '" + prpLcompensateDto.getAccount() + "'," + 
                           " MakeCom = '" + prpLcompensateDto.getMakeCom() + "'," + 
                           " ComCode = '" + prpLcompensateDto.getComCode() + "'," + 
                           " HandlerCode = '" + prpLcompensateDto.getHandlerCode() + "'," + 
                           " Handler1Code = '" + prpLcompensateDto.getHandler1Code() + "'," + 
                           " ApproverCode = '" + prpLcompensateDto.getApproverCode() + "'," + 
                           " UnderWriteCode = '" + prpLcompensateDto.getUnderWriteCode() + "'," + 
                           " UnderWriteName = '" + prpLcompensateDto.getUnderWriteName() + "'," + 
                           " StatisticsYM = '" + prpLcompensateDto.getStatisticsYM() + "'," + 
                           " OperatorCode = '" + prpLcompensateDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLcompensateDto.getInputDate() + "'," + 
                           " UnderWriteEndDate = '" + prpLcompensateDto.getUnderWriteEndDate() + "'," + 
                           " UnderWriteFlag = '" + prpLcompensateDto.getUnderWriteFlag() + "'," + 
                           " Remark = '" + prpLcompensateDto.getRemark() + "'," + 
                           " Flag = '" + prpLcompensateDto.getFlag() + "'," + 
                           " CaseType = '" + prpLcompensateDto.getCaseType() + "'," + 
                           " IndemnityDutyRate = '" + prpLcompensateDto.getIndemnityDutyRate() + "'," + 
                           " IndemnityDuty = '" + prpLcompensateDto.getIndemnityDuty() + "'," + 
                           " Result = '" + prpLcompensateDto.getResult() + "'" + 
                           " LossesNumber = " + prpLcompensateDto.getLossesNumber() + "," + 
                           " LossesUnitCode = '" + prpLcompensateDto.getLossesUnitCode() + "'," + 
                           " DamageInsured = " + prpLcompensateDto.getDamageInsured() + "," + 
                           " DisasterArea = " + prpLcompensateDto.getDisasterArea() + "," + 
                           " DisasterUnit = '" + prpLcompensateDto.getDisasterUnit() + "'," + 
                           " AffectedArea = " + prpLcompensateDto.getAffectedArea() + "," + 
                           " AffectedUnit = '" + prpLcompensateDto.getAffectedUnit() + "'," + 
                           " NoProductionArea = " + prpLcompensateDto.getNoProductionArea() + "," + 
                           " NoProductionUnit = '" + prpLcompensateDto.getNoProductionUnit() + "'," + 
                           " DeathQuantity = " + prpLcompensateDto.getDeathQuantity() + "," + 
                           " DeathUnit = '" + prpLcompensateDto.getDeathUnit() + "'," + 
                           " KillQuantity = " + prpLcompensateDto.getKillQuantity() + "," + 
                           " KillUnit = '" + prpLcompensateDto.getKillUnit() + "'," + 
                           " BusinessType = '" + prpLcompensateDto.getBusinessType() + "'," + 
                           " BusinessType1 = '" + prpLcompensateDto.getBusinessType1() + "'," + 
                           " FinallyFlag = '" + prpLcompensateDto.getFinallyFlag() + "'," + 
                           " MedicalType = '" + prpLcompensateDto.getMedicalType() + "'," +
                           " WoundGrade = '" + prpLcompensateDto.getWoundGrade() + "'," + 
                           " claimType = '" + prpLcompensateDto.getClaimType() + "'," + 
                           " thridLicenseNo = '" + prpLcompensateDto.getThridLicenseNos() + "'," + 
                           " thridCompany = '" + prpLcompensateDto.getThridCompanys() + "'" + 
                           " BusinessFlag = '" + prpLcompensateDto.getBusinessFlag() + "'" + 
                           " OtherFlag = '" + prpLcompensateDto.getOtherFlag() + "'" + 
                           " claimRelationNo = '"+ prpLcompensateDto.getClaimRelationNo() + "'"+
                           " zeroLossType = '"+ prpLcompensateDto.getZeroLossType() + "'"+
                           " zeroLossCaseType = '"+ prpLcompensateDto.getZeroLossCaseType() + "'"+
                           " zeroLossDetailReason = '"+ prpLcompensateDto.getZeroLossDetailReason() + "'"+
                           " lawsuitFlag = '"+prpLcompensateDto.getLawsuitFlag() + "'"+
			               " Where " +
                           " CompensateNo = '" + prpLcompensateDto.getCompensateNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcompensateDto.getLFlag());
        dbManager.setString(2,prpLcompensateDto.getCaseNo());
        dbManager.setInt(3,prpLcompensateDto.getTimes());
        dbManager.setString(4,prpLcompensateDto.getClassCode());
        dbManager.setString(5,prpLcompensateDto.getRiskCode());
        dbManager.setString(6,prpLcompensateDto.getClaimNo());
        dbManager.setString(7,prpLcompensateDto.getPolicyNo());
        dbManager.setString(8,prpLcompensateDto.getDeductCond());
        dbManager.setDateTime(9,prpLcompensateDto.getPreserveDate());
        dbManager.setString(10,prpLcompensateDto.getCheckAgentCode());
        dbManager.setString(11,prpLcompensateDto.getCheckAgentName());
        dbManager.setString(12,prpLcompensateDto.getSurveyorName());
        dbManager.setString(13,prpLcompensateDto.getCounterClaimerName());
        dbManager.setString(14,prpLcompensateDto.getDutyDescription());
        dbManager.setString(15,prpLcompensateDto.getCurrency());
        dbManager.setDouble(16,prpLcompensateDto.getSumLoss());
        dbManager.setDouble(17,prpLcompensateDto.getSumRest());
        dbManager.setDouble(18,prpLcompensateDto.getSumDutyPaid());
        dbManager.setDouble(19,prpLcompensateDto.getSumNoDutyFee());
        dbManager.setDouble(20,prpLcompensateDto.getSumPaid());
        dbManager.setDouble(21,prpLcompensateDto.getSumPrePaid());
        dbManager.setDouble(22,prpLcompensateDto.getSumThisPaid());
        dbManager.setString(23,prpLcompensateDto.getReceiverName());
        dbManager.setString(24,prpLcompensateDto.getBank());
        dbManager.setString(25,prpLcompensateDto.getAccount());
        dbManager.setString(26,prpLcompensateDto.getMakeCom());
        dbManager.setString(27,prpLcompensateDto.getComCode());
        dbManager.setString(28,prpLcompensateDto.getHandlerCode());
        dbManager.setString(29,prpLcompensateDto.getHandler1Code());
        dbManager.setString(30,prpLcompensateDto.getApproverCode());
        dbManager.setString(31,prpLcompensateDto.getUnderWriteCode());
        dbManager.setString(32,prpLcompensateDto.getUnderWriteName());
        dbManager.setDateTime(33,prpLcompensateDto.getStatisticsYM());
        dbManager.setString(34,prpLcompensateDto.getOperatorCode());
        dbManager.setDateTime(35,prpLcompensateDto.getInputDate());
        dbManager.setDateTime(36,prpLcompensateDto.getUnderWriteEndDate());
        dbManager.setString(37,prpLcompensateDto.getUnderWriteFlag());
        dbManager.setString(38,prpLcompensateDto.getRemark());
        dbManager.setString(39,prpLcompensateDto.getFlag());
        dbManager.setString(40,prpLcompensateDto.getCaseType());
        dbManager.setDouble(41,prpLcompensateDto.getIndemnityDutyRate());
        dbManager.setString(42,prpLcompensateDto.getIndemnityDuty());
        dbManager.setString(43,prpLcompensateDto.getResult());
        dbManager.setDouble(44,prpLcompensateDto.getLossesNumber());
        dbManager.setString(45,prpLcompensateDto.getLossesUnitCode());
        dbManager.setDouble(46,prpLcompensateDto.getDamageInsured());
        dbManager.setDouble(47,prpLcompensateDto.getDisasterArea());
        dbManager.setString(48,prpLcompensateDto.getDisasterUnit());
        dbManager.setDouble(49,prpLcompensateDto.getAffectedArea());
        dbManager.setString(50,prpLcompensateDto.getAffectedUnit());
        dbManager.setDouble(51,prpLcompensateDto.getNoProductionArea());
        dbManager.setString(52,prpLcompensateDto.getNoProductionUnit());
        dbManager.setDouble(53,prpLcompensateDto.getDeathQuantity());
        dbManager.setString(54,prpLcompensateDto.getDeathUnit());
        dbManager.setDouble(55,prpLcompensateDto.getKillQuantity());
        dbManager.setString(56,prpLcompensateDto.getKillUnit());
        dbManager.setString(57,prpLcompensateDto.getBusinessType());
        dbManager.setString(58,prpLcompensateDto.getBusinessType1());

        dbManager.setString(59,prpLcompensateDto.getFinallyFlag());
        dbManager.setString(60,prpLcompensateDto.getMedicalType());
        //设置条件字段;
        
        dbManager.setString(61,prpLcompensateDto.getWoundGrade());
        dbManager.setString(62,prpLcompensateDto.getClaimType());
        dbManager.setString(63,prpLcompensateDto.getThridLicenseNos());
        dbManager.setString(64,prpLcompensateDto.getThridLicenseNos());
        dbManager.setString(65,prpLcompensateDto.getBusinessFlag());
        dbManager.setString(66,prpLcompensateDto.getOtherFlag());
        dbManager.setString(67,prpLcompensateDto.getOjectName());
        dbManager.setString(68,prpLcompensateDto.getOjectType());
        dbManager.setString(69,prpLcompensateDto.getOjectCode());
        dbManager.setString(70,prpLcompensateDto.getUploadSerialNo());
        dbManager.setDateTime(71,prpLcompensateDto.getPayrefDate());
        dbManager.setString(72, prpLcompensateDto.getClaimRelationNo());
        dbManager.setString(73,prpLcompensateDto.getZeroLossType());
        dbManager.setString(74,prpLcompensateDto.getZeroLossCaseType());
        dbManager.setString(75,prpLcompensateDto.getZeroLossDetailReason());
        dbManager.setString(76, prpLcompensateDto.getCoinsPaidLossType());
        
        dbManager.setDouble(77, prpLcompensateDto.getCoinsSumPaid());
        
        dbManager.setString(78,prpLcompensateDto.getClaimNotification());
        dbManager.setString(79,prpLcompensateDto.getInncentTreatment());
        
        dbManager.setString(80,prpLcompensateDto.getLawsuitFlag());
        dbManager.setString(81,prpLcompensateDto.getCompensateNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcompensateBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号码
     * @return PrpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByPrimaryKey(String compensateNo) throws Exception{
        String mainStatement = " Select CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " Result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " FinallyFlag," + 
                           " MedicalType," +
                           " WoundGrade, " +
                           " ClaimType," +
                           " ThridLicenseNo, " +
                           " ThridCompany," +
                           " BusinessFlag," +
                           " OtherFlag ,ObjectName,ObjectType,ObjectCode," +
                           " uploadSerialNo," +
                           " payRefDate, " +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason, "+
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
                           " From PrpLcompensate";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ?";
        PrpLcompensateDto prpLcompensateDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CompensateNo = '" + compensateNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensateDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensateDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensateDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensateDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensateDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensateDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensateDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensateDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensateDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensateDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensateDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensateDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensateDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensateDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensateDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensateDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensateDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensateDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensateDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensateDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensateDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensateDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensateDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensateDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensateDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensateDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensateDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensateDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensateDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensateDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensateDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensateDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensateDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensateDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensateDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensateDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensateDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensateDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensateDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensateDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensateDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensateDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensateDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensateDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensateDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensateDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensateDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensateDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensateDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensateDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensateDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensateDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensateDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensateDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensateDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensateDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensateDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensateDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensateDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensateDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensateDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensateDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensateDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensateDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensateDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensateDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensateDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensateDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensateDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensateDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensateDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensateDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensateDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            
            prpLcompensateDto.setLawsuitFlag(dbManager.getString(resultSet,81));
            //ObjectName,ObjectType,ObjectCode
            
            
            logger.info("DBPrpLcompensateBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcompensateBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcompensateDto;
    }
    /**
     * 按立案号查找一条数据
     * @param compensateNo 赔款计算书号码
     * @return PrpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByClaimNo(String claimNo) throws Exception{
        String mainStatement = " Select CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " Result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " FinallyFlag," + 
                           " MedicalType," +
                           " WoundGrade, " +
                           " ClaimType," +
                           " ThridLicenseNo, " +
                           " ThridCompany," +
                           " BusinessFlag," +
                           " OtherFlag ,ObjectName,ObjectType,ObjectCode," +
                           " uploadSerialNo," +
                           " payRefDate, " +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason, "+
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
                           " From PrpLcompensate";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ?";
        PrpLcompensateDto prpLcompensateDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CompensateNo = '" + claimNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensateDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensateDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensateDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensateDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensateDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensateDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensateDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensateDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensateDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensateDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensateDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensateDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensateDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensateDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensateDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensateDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensateDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensateDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensateDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensateDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensateDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensateDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensateDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensateDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensateDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensateDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensateDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensateDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensateDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensateDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensateDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensateDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensateDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensateDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensateDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensateDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensateDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensateDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensateDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensateDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensateDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensateDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensateDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensateDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensateDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensateDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensateDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensateDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensateDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensateDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensateDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensateDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensateDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensateDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensateDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensateDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensateDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensateDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensateDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensateDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensateDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensateDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensateDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensateDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensateDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensateDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensateDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensateDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensateDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensateDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensateDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensateDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensateDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensateDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            //ObjectName,ObjectType,ObjectCode
            
            
            logger.info("DBPrpLcompensateBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcompensateBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcompensateDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " Result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " FinallyFlag," + 
                           " MedicalType," +
                           " WoundGrade, " +
                           " ClaimType," +
                           " ThridLicenseNo, " +
                           " ThridCompany," +
                           " BusinessFlag," +
                           " OtherFlag ,ObjectName,ObjectType,ObjectCode," +
                           " uploadSerialNo," +
                           " payRefDate, " +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason, "+
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
                           " From PrpLcompensate Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensateDto prpLcompensateDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensateDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensateDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensateDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensateDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensateDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensateDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensateDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensateDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensateDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensateDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensateDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensateDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensateDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensateDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensateDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensateDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensateDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensateDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensateDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensateDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensateDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensateDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensateDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensateDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensateDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensateDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensateDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensateDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensateDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensateDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensateDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensateDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensateDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensateDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensateDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensateDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensateDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensateDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensateDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensateDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensateDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensateDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensateDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensateDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensateDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensateDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensateDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensateDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensateDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensateDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensateDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensateDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensateDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensateDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensateDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensateDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensateDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensateDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensateDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensateDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensateDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensateDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensateDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensateDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensateDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensateDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensateDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensateDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensateDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensateDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensateDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensateDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensateDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensateDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            collection.add(prpLcompensateDto);
        }
        resultSet.close();
        logger.info("DBPrpLcompensateBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLcompensate Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcompensateBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcompensate Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcompensateBase.getCount() success!");
        return count;
    }
    /*******************************优化修改：start**********************************/
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsByPrepered(String conditions,String param,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select CompensateNo," + 
                           " LFlag," + 
                           " CaseNo," + 
                           " Times," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " DeductCond," + 
                           " PreserveDate," + 
                           " CheckAgentCode," + 
                           " CheckAgentName," + 
                           " SurveyorName," + 
                           " CounterClaimerName," + 
                           " DutyDescription," + 
                           " Currency," + 
                           " SumLoss," + 
                           " SumRest," + 
                           " SumDutyPaid," + 
                           " SumNoDutyFee," + 
                           " SumPaid," + 
                           " SumPrePaid," + 
                           " SumThisPaid," + 
                           " ReceiverName," + 
                           " Bank," + 
                           " Account," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " ApproverCode," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " StatisticsYM," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " Flag," + 
                           " CaseType," + 
                           " IndemnityDutyRate," + 
                           " IndemnityDuty," + 
                           " Result," + 
                           " LossesNumber," + 
                           " LossesUnitCode," + 
                           " DamageInsured," + 
                           " DisasterArea," + 
                           " DisasterUnit," + 
                           " AffectedArea," + 
                           " AffectedUnit," + 
                           " NoProductionArea," + 
                           " NoProductionUnit," + 
                           " DeathQuantity," + 
                           " DeathUnit," + 
                           " KillQuantity," + 
                           " KillUnit," + 
                           " BusinessType," + 
                           " BusinessType1," + 
                           " FinallyFlag," + 
                           " MedicalType," +
                           " WoundGrade, " +
                           " ClaimType," +
                           " ThridLicenseNo, " +
                           " ThridCompany," +
                           " BusinessFlag," +
                           " OtherFlag ,ObjectName,ObjectType,ObjectCode," +
                           " uploadSerialNo," +
                           " payRefDate, " +
        				   " claimRelationNo," +
        				   " zeroLossType," +
        				   " zeroLossCaseType," +
        				   " zeroLossDetailReason, "+
        				   " coinsPaidLossType ," +
        				   " coinsSumPaid ," +
        				   " claimNotification ," +
        				   " inncentTreatment ," +
        				   " lawsuitFlag " +
                           " From PrpLcompensate Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensateDto prpLcompensateDto = null;
        dbManager.prepareStatement(statement);
        dbManager.setString(1, param);
        ResultSet resultSet = dbManager.executePreparedQuery();
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLcompensateDto = new PrpLcompensateDto();
            prpLcompensateDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensateDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensateDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensateDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensateDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensateDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensateDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensateDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensateDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensateDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensateDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensateDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensateDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensateDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensateDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensateDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensateDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensateDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensateDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensateDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensateDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensateDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensateDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensateDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensateDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensateDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensateDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensateDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensateDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensateDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensateDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensateDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensateDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensateDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensateDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensateDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensateDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensateDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensateDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensateDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensateDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensateDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensateDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensateDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensateDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensateDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensateDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensateDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensateDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensateDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensateDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensateDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensateDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensateDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensateDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensateDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensateDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensateDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensateDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensateDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensateDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensateDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensateDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensateDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensateDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensateDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensateDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensateDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensateDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensateDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensateDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensateDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensateDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensateDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensateDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensateDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensateDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensateDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensateDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensateDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensateDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            collection.add(prpLcompensateDto);
        }
        resultSet.close();
        logger.info("DBPrpLcompensateBase.findByConditions() success!");
        return collection;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsByPrepered(String conditions,String param) throws Exception{
        return findByConditionsByPrepered(conditions,param,0,0);
    }
    /*******************************优化修改：end**********************************/
   
}


