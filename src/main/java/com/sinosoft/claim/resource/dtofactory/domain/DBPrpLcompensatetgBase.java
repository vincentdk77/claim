package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcompensate-赔款计算书表的数据访问对象基类<br>
 * 创建于 2005-05-26 09:04:13.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcompensatetgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcompensatetgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    
    public DBPrpLcompensatetgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void insert(PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        String mainStatement = " Insert Into PrpLcompensatetg (" + 
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
                           "'" + prpLcompensatetgDto.getCompensateNo() + "'," + 
                           "'" + prpLcompensatetgDto.getLFlag() + "'," + 
                           "'" + prpLcompensatetgDto.getCaseNo() + "'," + 
                           "" + prpLcompensatetgDto.getTimes() + "," + 
                           "'" + prpLcompensatetgDto.getClassCode() + "'," + 
                           "'" + prpLcompensatetgDto.getRiskCode() + "'," + 
                           "'" + prpLcompensatetgDto.getClaimNo() + "'," + 
                           "'" + prpLcompensatetgDto.getPolicyNo() + "'," + 
                           "'" + prpLcompensatetgDto.getDeductCond() + "'," + 
                           "'" + prpLcompensatetgDto.getPreserveDate() + "'," + 
                           "'" + prpLcompensatetgDto.getCheckAgentCode() + "'," + 
                           "'" + prpLcompensatetgDto.getCheckAgentName() + "'," + 
                           "'" + prpLcompensatetgDto.getSurveyorName() + "'," + 
                           "'" + prpLcompensatetgDto.getCounterClaimerName() + "'," + 
                           "'" + prpLcompensatetgDto.getDutyDescription() + "'," + 
                           "'" + prpLcompensatetgDto.getCurrency() + "'," + 
                           "'" + prpLcompensatetgDto.getSumLoss() + "'," + 
                           "'" + prpLcompensatetgDto.getSumRest() + "'," + 
                           "'" + prpLcompensatetgDto.getSumDutyPaid() + "'," + 
                           "'" + prpLcompensatetgDto.getSumNoDutyFee() + "'," + 
                           "'" + prpLcompensatetgDto.getSumPaid() + "'," + 
                           "'" + prpLcompensatetgDto.getSumPrePaid() + "'," + 
                           "'" + prpLcompensatetgDto.getSumThisPaid() + "'," + 
                           "'" + prpLcompensatetgDto.getReceiverName() + "'," + 
                           "'" + prpLcompensatetgDto.getBank() + "'," + 
                           "'" + prpLcompensatetgDto.getAccount() + "'," + 
                           "'" + prpLcompensatetgDto.getMakeCom() + "'," + 
                           "'" + prpLcompensatetgDto.getComCode() + "'," + 
                           "'" + prpLcompensatetgDto.getHandlerCode() + "'," + 
                           "'" + prpLcompensatetgDto.getHandler1Code() + "'," + 
                           "'" + prpLcompensatetgDto.getApproverCode() + "'," + 
                           "'" + prpLcompensatetgDto.getUnderWriteCode() + "'," + 
                           "'" + prpLcompensatetgDto.getUnderWriteName() + "'," + 
                           "'" + prpLcompensatetgDto.getStatisticsYM() + "'," + 
                           "'" + prpLcompensatetgDto.getOperatorCode() + "'," + 
                           "'" + prpLcompensatetgDto.getInputDate() + "'," + 
                           "'" + prpLcompensatetgDto.getUnderWriteEndDate() + "'," + 
                           "'" + prpLcompensatetgDto.getUnderWriteFlag() + "'," + 
                           "'" + prpLcompensatetgDto.getRemark() + "'," + 
                           "'" + prpLcompensatetgDto.getFlag() + "'," + 
                           "'" + prpLcompensatetgDto.getCaseType() + "'," + 
                           "'" + prpLcompensatetgDto.getIndemnityDutyRate() + "'," + 
                           "'" + prpLcompensatetgDto.getIndemnityDuty() + "'," + 
                           "'" + prpLcompensatetgDto.getResult() + "'," + 
                           "" + prpLcompensatetgDto.getLossesNumber() + "," + 
                           "'" + prpLcompensatetgDto.getLossesUnitCode() + "'," + 
                           "" + prpLcompensatetgDto.getDamageInsured() + "," + 
                           "" + prpLcompensatetgDto.getDisasterArea() + "," + 
                           "'" + prpLcompensatetgDto.getDisasterUnit() + "'," + 
                           "" + prpLcompensatetgDto.getAffectedArea() + "," + 
                           "'" + prpLcompensatetgDto.getAffectedUnit() + "'," + 
                           "" + prpLcompensatetgDto.getNoProductionArea() + "," + 
                           "'" + prpLcompensatetgDto.getNoProductionUnit() + "'," + 
                           "" + prpLcompensatetgDto.getDeathQuantity() + "," + 
                           "'" + prpLcompensatetgDto.getDeathUnit() + "'," + 
                           "" + prpLcompensatetgDto.getKillQuantity() + "," + 
                           "'" + prpLcompensatetgDto.getKillUnit() + "'," + 
                           "'" + prpLcompensatetgDto.getBusinessType() + "'," + 
                           "'" + prpLcompensatetgDto.getBusinessType1() + "'," + 
                           "'" + prpLcompensatetgDto.getFinallyFlag() + "'," + 
                           "'" + prpLcompensatetgDto.getMedicalType() + "'," +
                           "'" + prpLcompensatetgDto.getWoundGrade() +"'," +
            			   "'" + prpLcompensatetgDto.getClaimType() +"'," +
            			   "'" + prpLcompensatetgDto.getThridLicenseNos() +"'," +
            			   "'" + prpLcompensatetgDto.getThridCompanys() +"'," +
            			   "'" + prpLcompensatetgDto.getBusinessFlag() +"'," +
            			   "'" + prpLcompensatetgDto.getOtherFlag() +"')," +
            			   "'" + prpLcompensatetgDto.getClaimRelationNo() +"', " +
            			   "'" + prpLcompensatetgDto.getCoinsPaidLossType() +"', " +
            			   "'" + prpLcompensatetgDto.getCoinsSumPaid() +"', "+
            			   "'" + prpLcompensatetgDto.getClaimNotification() +"', "+
            			   "'" + prpLcompensatetgDto.getInncentTreatment() +"', "+
                           "'" + prpLcompensatetgDto.getLawsuitFlag()+"') ";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcompensatetgDto.getCompensateNo());
        dbManager.setString(2,prpLcompensatetgDto.getLFlag());
        dbManager.setString(3,prpLcompensatetgDto.getCaseNo());
        dbManager.setInt(4,prpLcompensatetgDto.getTimes());
        dbManager.setString(5,prpLcompensatetgDto.getClassCode());
        dbManager.setString(6,prpLcompensatetgDto.getRiskCode());
        dbManager.setString(7,prpLcompensatetgDto.getClaimNo());
        dbManager.setString(8,prpLcompensatetgDto.getPolicyNo());
        dbManager.setString(9,prpLcompensatetgDto.getDeductCond());
        dbManager.setDateTime(10,prpLcompensatetgDto.getPreserveDate());
        dbManager.setString(11,prpLcompensatetgDto.getCheckAgentCode());
        dbManager.setString(12,prpLcompensatetgDto.getCheckAgentName());
        dbManager.setString(13,prpLcompensatetgDto.getSurveyorName());
        dbManager.setString(14,prpLcompensatetgDto.getCounterClaimerName());
        dbManager.setString(15,prpLcompensatetgDto.getDutyDescription());
        dbManager.setString(16,prpLcompensatetgDto.getCurrency());
        dbManager.setDouble(17,prpLcompensatetgDto.getSumLoss());
        dbManager.setDouble(18,prpLcompensatetgDto.getSumRest());
        dbManager.setDouble(19,prpLcompensatetgDto.getSumDutyPaid());
        dbManager.setDouble(20,prpLcompensatetgDto.getSumNoDutyFee());
        dbManager.setDouble(21,prpLcompensatetgDto.getSumPaid());
        dbManager.setDouble(22,prpLcompensatetgDto.getSumPrePaid());
        dbManager.setDouble(23,prpLcompensatetgDto.getSumThisPaid());
        dbManager.setString(24,prpLcompensatetgDto.getReceiverName());
        dbManager.setString(25,prpLcompensatetgDto.getBank());
        dbManager.setString(26,prpLcompensatetgDto.getAccount());
        dbManager.setString(27,prpLcompensatetgDto.getMakeCom());
        dbManager.setString(28,prpLcompensatetgDto.getComCode());
        dbManager.setString(29,prpLcompensatetgDto.getHandlerCode());
        dbManager.setString(30,prpLcompensatetgDto.getHandler1Code());
        dbManager.setString(31,prpLcompensatetgDto.getApproverCode());
        dbManager.setString(32,prpLcompensatetgDto.getUnderWriteCode());
        dbManager.setString(33,prpLcompensatetgDto.getUnderWriteName());
        dbManager.setDateTime(34,prpLcompensatetgDto.getStatisticsYM());
        dbManager.setString(35,prpLcompensatetgDto.getOperatorCode());
        dbManager.setDateTime(36,prpLcompensatetgDto.getInputDate());
        dbManager.setDateTime(37,prpLcompensatetgDto.getUnderWriteEndDate());
        dbManager.setString(38,prpLcompensatetgDto.getUnderWriteFlag());
        dbManager.setString(39,prpLcompensatetgDto.getRemark());
        dbManager.setString(40,prpLcompensatetgDto.getFlag());
        dbManager.setString(41,prpLcompensatetgDto.getCaseType());
        dbManager.setDouble(42,prpLcompensatetgDto.getIndemnityDutyRate());
        dbManager.setString(43,prpLcompensatetgDto.getIndemnityDuty());
        dbManager.setString(44,prpLcompensatetgDto.getResult());
        dbManager.setDouble(45,prpLcompensatetgDto.getLossesNumber());
        dbManager.setString(46,prpLcompensatetgDto.getLossesUnitCode());
        dbManager.setDouble(47,prpLcompensatetgDto.getDamageInsured());
        dbManager.setDouble(48,prpLcompensatetgDto.getDisasterArea());
        dbManager.setString(49,prpLcompensatetgDto.getDisasterUnit());
        dbManager.setDouble(50,prpLcompensatetgDto.getAffectedArea());
        dbManager.setString(51,prpLcompensatetgDto.getAffectedUnit());
        dbManager.setDouble(52,prpLcompensatetgDto.getNoProductionArea());
        dbManager.setString(53,prpLcompensatetgDto.getNoProductionUnit());
        dbManager.setDouble(54,prpLcompensatetgDto.getDeathQuantity());
        dbManager.setString(55,prpLcompensatetgDto.getDeathUnit());
        dbManager.setDouble(56,prpLcompensatetgDto.getKillQuantity());
        dbManager.setString(57,prpLcompensatetgDto.getKillUnit());
        dbManager.setString(58,prpLcompensatetgDto.getBusinessType());
        dbManager.setString(59,prpLcompensatetgDto.getBusinessType1());

        dbManager.setString(60,prpLcompensatetgDto.getFinallyFlag());
        dbManager.setString(61,prpLcompensatetgDto.getMedicalType());
        dbManager.setString(62,prpLcompensatetgDto.getWoundGrade());
        dbManager.setString(63,prpLcompensatetgDto.getClaimType());
        dbManager.setString(64,prpLcompensatetgDto.getThridLicenseNos());
        dbManager.setString(65,prpLcompensatetgDto.getThridCompanys());
        dbManager.setString(66,prpLcompensatetgDto.getBusinessFlag());
        dbManager.setString(67,prpLcompensatetgDto.getOtherFlag());
        dbManager.setString(68,prpLcompensatetgDto.getOjectName());
        dbManager.setString(69,prpLcompensatetgDto.getOjectType());
        dbManager.setString(70,prpLcompensatetgDto.getOjectCode());
        dbManager.setString(71,prpLcompensatetgDto.getUploadSerialNo());
        dbManager.setDateTime(72,prpLcompensatetgDto.getPayrefDate());
        dbManager.setString(73, prpLcompensatetgDto.getClaimRelationNo());
        dbManager.setString(74, prpLcompensatetgDto.getZeroLossType());
        dbManager.setString(75, prpLcompensatetgDto.getZeroLossCaseType());
        dbManager.setString(76, prpLcompensatetgDto.getZeroLossDetailReason());
        
        dbManager.setString(77, prpLcompensatetgDto.getCoinsPaidLossType());
        dbManager.setDouble(78, prpLcompensatetgDto.getCoinsSumPaid());
        dbManager.setString(79, prpLcompensatetgDto.getClaimNotification());
        dbManager.setString(80, prpLcompensatetgDto.getInncentTreatment());
        
        dbManager.setString(81,prpLcompensatetgDto.getLawsuitFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcompensatetgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcompensatetg (" + 
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
            PrpLcompensatetgDto prpLcompensatetgDto = (PrpLcompensatetgDto)i.next();
            dbManager.setString(1,prpLcompensatetgDto.getCompensateNo());
            dbManager.setString(2,prpLcompensatetgDto.getLFlag());
            dbManager.setString(3,prpLcompensatetgDto.getCaseNo());
            dbManager.setInt(4,prpLcompensatetgDto.getTimes());
            dbManager.setString(5,prpLcompensatetgDto.getClassCode());
            dbManager.setString(6,prpLcompensatetgDto.getRiskCode());
            dbManager.setString(7,prpLcompensatetgDto.getClaimNo());
            dbManager.setString(8,prpLcompensatetgDto.getPolicyNo());
            dbManager.setString(9,prpLcompensatetgDto.getDeductCond());
            dbManager.setDateTime(10,prpLcompensatetgDto.getPreserveDate());
            dbManager.setString(11,prpLcompensatetgDto.getCheckAgentCode());
            dbManager.setString(12,prpLcompensatetgDto.getCheckAgentName());
            dbManager.setString(13,prpLcompensatetgDto.getSurveyorName());
            dbManager.setString(14,prpLcompensatetgDto.getCounterClaimerName());
            dbManager.setString(15,prpLcompensatetgDto.getDutyDescription());
            dbManager.setString(16,prpLcompensatetgDto.getCurrency());
            dbManager.setDouble(17,prpLcompensatetgDto.getSumLoss());
            dbManager.setDouble(18,prpLcompensatetgDto.getSumRest());
            dbManager.setDouble(19,prpLcompensatetgDto.getSumDutyPaid());
            dbManager.setDouble(20,prpLcompensatetgDto.getSumNoDutyFee());
            dbManager.setDouble(21,prpLcompensatetgDto.getSumPaid());
            dbManager.setDouble(22,prpLcompensatetgDto.getSumPrePaid());
            dbManager.setDouble(23,prpLcompensatetgDto.getSumThisPaid());
            dbManager.setString(24,prpLcompensatetgDto.getReceiverName());
            dbManager.setString(25,prpLcompensatetgDto.getBank());
            dbManager.setString(26,prpLcompensatetgDto.getAccount());
            dbManager.setString(27,prpLcompensatetgDto.getMakeCom());
            dbManager.setString(28,prpLcompensatetgDto.getComCode());
            dbManager.setString(29,prpLcompensatetgDto.getHandlerCode());
            dbManager.setString(30,prpLcompensatetgDto.getHandler1Code());
            dbManager.setString(31,prpLcompensatetgDto.getApproverCode());
            dbManager.setString(32,prpLcompensatetgDto.getUnderWriteCode());
            dbManager.setString(33,prpLcompensatetgDto.getUnderWriteName());
            dbManager.setDateTime(34,prpLcompensatetgDto.getStatisticsYM());
            dbManager.setString(35,prpLcompensatetgDto.getOperatorCode());
            dbManager.setDateTime(36,prpLcompensatetgDto.getInputDate());
            dbManager.setDateTime(37,prpLcompensatetgDto.getUnderWriteEndDate());
            dbManager.setString(38,prpLcompensatetgDto.getUnderWriteFlag());
            dbManager.setString(39,prpLcompensatetgDto.getRemark());
            dbManager.setString(40,prpLcompensatetgDto.getFlag());
            dbManager.setString(41,prpLcompensatetgDto.getCaseType());
            dbManager.setDouble(42,prpLcompensatetgDto.getIndemnityDutyRate());
            dbManager.setString(43,prpLcompensatetgDto.getIndemnityDuty());
            dbManager.setString(44,prpLcompensatetgDto.getResult());
            dbManager.setDouble(45,prpLcompensatetgDto.getLossesNumber());
            dbManager.setString(46,prpLcompensatetgDto.getLossesUnitCode());
            dbManager.setDouble(47,prpLcompensatetgDto.getDamageInsured());
            dbManager.setDouble(48,prpLcompensatetgDto.getDisasterArea());
            dbManager.setString(49,prpLcompensatetgDto.getDisasterUnit());
            dbManager.setDouble(50,prpLcompensatetgDto.getAffectedArea());
            dbManager.setString(51,prpLcompensatetgDto.getAffectedUnit());
            dbManager.setDouble(52,prpLcompensatetgDto.getNoProductionArea());
            dbManager.setString(53,prpLcompensatetgDto.getNoProductionUnit());
            dbManager.setDouble(54,prpLcompensatetgDto.getDeathQuantity());
            dbManager.setString(55,prpLcompensatetgDto.getDeathUnit());
            dbManager.setDouble(56,prpLcompensatetgDto.getKillQuantity());
            dbManager.setString(57,prpLcompensatetgDto.getKillUnit());
            dbManager.setString(58,prpLcompensatetgDto.getBusinessType());
            dbManager.setString(59,prpLcompensatetgDto.getBusinessType1());

            dbManager.setString(60,prpLcompensatetgDto.getFinallyFlag());
            dbManager.setString(61,prpLcompensatetgDto.getMedicalType());
            dbManager.setString(62,prpLcompensatetgDto.getWoundGrade());
            dbManager.setString(63,prpLcompensatetgDto.getClaimType());
        	dbManager.setString(64,prpLcompensatetgDto.getThridLicenseNos());
        	dbManager.setString(65,prpLcompensatetgDto.getThridCompanys());
        	dbManager.setString(66,prpLcompensatetgDto.getBusinessFlag());
        	dbManager.setString(67,prpLcompensatetgDto.getOtherFlag());
            dbManager.setString(68,prpLcompensatetgDto.getOjectName());
            dbManager.setString(69,prpLcompensatetgDto.getOjectType());
            dbManager.setString(70,prpLcompensatetgDto.getOjectCode());
            dbManager.setString(71,prpLcompensatetgDto.getUploadSerialNo());
            dbManager.setDateTime(72,prpLcompensatetgDto.getPayrefDate());
            dbManager.setString(73, prpLcompensatetgDto.getClaimRelationNo());
            dbManager.setString(74, prpLcompensatetgDto.getZeroLossType());
            dbManager.setString(75, prpLcompensatetgDto.getZeroLossCaseType());
            dbManager.setString(76, prpLcompensatetgDto.getZeroLossDetailReason());
            dbManager.setString(77, prpLcompensatetgDto.getCoinsPaidLossType());
            dbManager.setDouble(78, prpLcompensatetgDto.getCoinsSumPaid());
            dbManager.setString(79, prpLcompensatetgDto.getClaimNotification());
            dbManager.setString(80, prpLcompensatetgDto.getInncentTreatment());
            dbManager.setString(81, prpLcompensatetgDto.getLawsuitFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcompensatetgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号码
     * @throws Exception
     */
    public void delete(String compensateNo) throws Exception{
        String statement = " Delete From PrpLcompensatetg" + 
	            		   " Where " +
                           " CompensateNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcompensatetg Where " +
                           " CompensateNo = '" + compensateNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcompensatetgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcompensatetgDto prpLcompensatetgDto
     * @throws Exception
     */
    public void update(PrpLcompensatetgDto prpLcompensatetgDto) throws Exception{
        String statement = " Update PrpLcompensatetg Set LFlag = ?," + 
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
            String debugStatement = "Update PrpLcompensatetg Set " + 
                           " CompensateNo = '" + prpLcompensatetgDto.getCompensateNo() + "'," + 
                           " LFlag = '" + prpLcompensatetgDto.getLFlag() + "'," + 
                           " CaseNo = '" + prpLcompensatetgDto.getCaseNo() + "'," + 
                           " Times = " + prpLcompensatetgDto.getTimes() + "," + 
                           " ClassCode = '" + prpLcompensatetgDto.getClassCode() + "'," + 
                           " RiskCode = '" + prpLcompensatetgDto.getRiskCode() + "'," + 
                           " ClaimNo = '" + prpLcompensatetgDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLcompensatetgDto.getPolicyNo() + "'," + 
                           " DeductCond = '" + prpLcompensatetgDto.getDeductCond() + "'," + 
                           " PreserveDate = '" + prpLcompensatetgDto.getPreserveDate() + "'," + 
                           " CheckAgentCode = '" + prpLcompensatetgDto.getCheckAgentCode() + "'," + 
                           " CheckAgentName = '" + prpLcompensatetgDto.getCheckAgentName() + "'," + 
                           " SurveyorName = '" + prpLcompensatetgDto.getSurveyorName() + "'," + 
                           " CounterClaimerName = '" + prpLcompensatetgDto.getCounterClaimerName() + "'," + 
                           " DutyDescription = '" + prpLcompensatetgDto.getDutyDescription() + "'," + 
                           " Currency = '" + prpLcompensatetgDto.getCurrency() + "'," + 
                           " SumLoss = '" + prpLcompensatetgDto.getSumLoss() + "'," + 
                           " SumRest = '" + prpLcompensatetgDto.getSumRest() + "'," + 
                           " SumDutyPaid = '" + prpLcompensatetgDto.getSumDutyPaid() + "'," + 
                           " SumNoDutyFee = '" + prpLcompensatetgDto.getSumNoDutyFee() + "'," + 
                           " SumPaid = '" + prpLcompensatetgDto.getSumPaid() + "'," + 
                           " SumPrePaid = '" + prpLcompensatetgDto.getSumPrePaid() + "'," + 
                           " SumThisPaid = '" + prpLcompensatetgDto.getSumThisPaid() + "'," + 
                           " ReceiverName = '" + prpLcompensatetgDto.getReceiverName() + "'," + 
                           " Bank = '" + prpLcompensatetgDto.getBank() + "'," + 
                           " Account = '" + prpLcompensatetgDto.getAccount() + "'," + 
                           " MakeCom = '" + prpLcompensatetgDto.getMakeCom() + "'," + 
                           " ComCode = '" + prpLcompensatetgDto.getComCode() + "'," + 
                           " HandlerCode = '" + prpLcompensatetgDto.getHandlerCode() + "'," + 
                           " Handler1Code = '" + prpLcompensatetgDto.getHandler1Code() + "'," + 
                           " ApproverCode = '" + prpLcompensatetgDto.getApproverCode() + "'," + 
                           " UnderWriteCode = '" + prpLcompensatetgDto.getUnderWriteCode() + "'," + 
                           " UnderWriteName = '" + prpLcompensatetgDto.getUnderWriteName() + "'," + 
                           " StatisticsYM = '" + prpLcompensatetgDto.getStatisticsYM() + "'," + 
                           " OperatorCode = '" + prpLcompensatetgDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLcompensatetgDto.getInputDate() + "'," + 
                           " UnderWriteEndDate = '" + prpLcompensatetgDto.getUnderWriteEndDate() + "'," + 
                           " UnderWriteFlag = '" + prpLcompensatetgDto.getUnderWriteFlag() + "'," + 
                           " Remark = '" + prpLcompensatetgDto.getRemark() + "'," + 
                           " Flag = '" + prpLcompensatetgDto.getFlag() + "'," + 
                           " CaseType = '" + prpLcompensatetgDto.getCaseType() + "'," + 
                           " IndemnityDutyRate = '" + prpLcompensatetgDto.getIndemnityDutyRate() + "'," + 
                           " IndemnityDuty = '" + prpLcompensatetgDto.getIndemnityDuty() + "'," + 
                           " Result = '" + prpLcompensatetgDto.getResult() + "'" + 
                           " LossesNumber = " + prpLcompensatetgDto.getLossesNumber() + "," + 
                           " LossesUnitCode = '" + prpLcompensatetgDto.getLossesUnitCode() + "'," + 
                           " DamageInsured = " + prpLcompensatetgDto.getDamageInsured() + "," + 
                           " DisasterArea = " + prpLcompensatetgDto.getDisasterArea() + "," + 
                           " DisasterUnit = '" + prpLcompensatetgDto.getDisasterUnit() + "'," + 
                           " AffectedArea = " + prpLcompensatetgDto.getAffectedArea() + "," + 
                           " AffectedUnit = '" + prpLcompensatetgDto.getAffectedUnit() + "'," + 
                           " NoProductionArea = " + prpLcompensatetgDto.getNoProductionArea() + "," + 
                           " NoProductionUnit = '" + prpLcompensatetgDto.getNoProductionUnit() + "'," + 
                           " DeathQuantity = " + prpLcompensatetgDto.getDeathQuantity() + "," + 
                           " DeathUnit = '" + prpLcompensatetgDto.getDeathUnit() + "'," + 
                           " KillQuantity = " + prpLcompensatetgDto.getKillQuantity() + "," + 
                           " KillUnit = '" + prpLcompensatetgDto.getKillUnit() + "'," + 
                           " BusinessType = '" + prpLcompensatetgDto.getBusinessType() + "'," + 
                           " BusinessType1 = '" + prpLcompensatetgDto.getBusinessType1() + "'," + 
                           " FinallyFlag = '" + prpLcompensatetgDto.getFinallyFlag() + "'," + 
                           " MedicalType = '" + prpLcompensatetgDto.getMedicalType() + "'," +
                           " WoundGrade = '" + prpLcompensatetgDto.getWoundGrade() + "'," + 
                           " claimType = '" + prpLcompensatetgDto.getClaimType() + "'," + 
                           " thridLicenseNo = '" + prpLcompensatetgDto.getThridLicenseNos() + "'," + 
                           " thridCompany = '" + prpLcompensatetgDto.getThridCompanys() + "'" + 
                           " BusinessFlag = '" + prpLcompensatetgDto.getBusinessFlag() + "'" + 
                           " OtherFlag = '" + prpLcompensatetgDto.getOtherFlag() + "'" + 
                           " claimRelationNo = '"+ prpLcompensatetgDto.getClaimRelationNo() + "'"+
                           " zeroLossType = '"+ prpLcompensatetgDto.getZeroLossType() + "'"+
                           " zeroLossCaseType = '"+ prpLcompensatetgDto.getZeroLossCaseType() + "'"+
                           " zeroLossDetailReason = '"+ prpLcompensatetgDto.getZeroLossDetailReason() + "'"+
                           " lawsuitFlag = '"+prpLcompensatetgDto.getLawsuitFlag() + "'"+
			               " Where " +
                           " CompensateNo = '" + prpLcompensatetgDto.getCompensateNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcompensatetgDto.getLFlag());
        dbManager.setString(2,prpLcompensatetgDto.getCaseNo());
        dbManager.setInt(3,prpLcompensatetgDto.getTimes());
        dbManager.setString(4,prpLcompensatetgDto.getClassCode());
        dbManager.setString(5,prpLcompensatetgDto.getRiskCode());
        dbManager.setString(6,prpLcompensatetgDto.getClaimNo());
        dbManager.setString(7,prpLcompensatetgDto.getPolicyNo());
        dbManager.setString(8,prpLcompensatetgDto.getDeductCond());
        dbManager.setDateTime(9,prpLcompensatetgDto.getPreserveDate());
        dbManager.setString(10,prpLcompensatetgDto.getCheckAgentCode());
        dbManager.setString(11,prpLcompensatetgDto.getCheckAgentName());
        dbManager.setString(12,prpLcompensatetgDto.getSurveyorName());
        dbManager.setString(13,prpLcompensatetgDto.getCounterClaimerName());
        dbManager.setString(14,prpLcompensatetgDto.getDutyDescription());
        dbManager.setString(15,prpLcompensatetgDto.getCurrency());
        dbManager.setDouble(16,prpLcompensatetgDto.getSumLoss());
        dbManager.setDouble(17,prpLcompensatetgDto.getSumRest());
        dbManager.setDouble(18,prpLcompensatetgDto.getSumDutyPaid());
        dbManager.setDouble(19,prpLcompensatetgDto.getSumNoDutyFee());
        dbManager.setDouble(20,prpLcompensatetgDto.getSumPaid());
        dbManager.setDouble(21,prpLcompensatetgDto.getSumPrePaid());
        dbManager.setDouble(22,prpLcompensatetgDto.getSumThisPaid());
        dbManager.setString(23,prpLcompensatetgDto.getReceiverName());
        dbManager.setString(24,prpLcompensatetgDto.getBank());
        dbManager.setString(25,prpLcompensatetgDto.getAccount());
        dbManager.setString(26,prpLcompensatetgDto.getMakeCom());
        dbManager.setString(27,prpLcompensatetgDto.getComCode());
        dbManager.setString(28,prpLcompensatetgDto.getHandlerCode());
        dbManager.setString(29,prpLcompensatetgDto.getHandler1Code());
        dbManager.setString(30,prpLcompensatetgDto.getApproverCode());
        dbManager.setString(31,prpLcompensatetgDto.getUnderWriteCode());
        dbManager.setString(32,prpLcompensatetgDto.getUnderWriteName());
        dbManager.setDateTime(33,prpLcompensatetgDto.getStatisticsYM());
        dbManager.setString(34,prpLcompensatetgDto.getOperatorCode());
        dbManager.setDateTime(35,prpLcompensatetgDto.getInputDate());
        dbManager.setDateTime(36,prpLcompensatetgDto.getUnderWriteEndDate());
        dbManager.setString(37,prpLcompensatetgDto.getUnderWriteFlag());
        dbManager.setString(38,prpLcompensatetgDto.getRemark());
        dbManager.setString(39,prpLcompensatetgDto.getFlag());
        dbManager.setString(40,prpLcompensatetgDto.getCaseType());
        dbManager.setDouble(41,prpLcompensatetgDto.getIndemnityDutyRate());
        dbManager.setString(42,prpLcompensatetgDto.getIndemnityDuty());
        dbManager.setString(43,prpLcompensatetgDto.getResult());
        dbManager.setDouble(44,prpLcompensatetgDto.getLossesNumber());
        dbManager.setString(45,prpLcompensatetgDto.getLossesUnitCode());
        dbManager.setDouble(46,prpLcompensatetgDto.getDamageInsured());
        dbManager.setDouble(47,prpLcompensatetgDto.getDisasterArea());
        dbManager.setString(48,prpLcompensatetgDto.getDisasterUnit());
        dbManager.setDouble(49,prpLcompensatetgDto.getAffectedArea());
        dbManager.setString(50,prpLcompensatetgDto.getAffectedUnit());
        dbManager.setDouble(51,prpLcompensatetgDto.getNoProductionArea());
        dbManager.setString(52,prpLcompensatetgDto.getNoProductionUnit());
        dbManager.setDouble(53,prpLcompensatetgDto.getDeathQuantity());
        dbManager.setString(54,prpLcompensatetgDto.getDeathUnit());
        dbManager.setDouble(55,prpLcompensatetgDto.getKillQuantity());
        dbManager.setString(56,prpLcompensatetgDto.getKillUnit());
        dbManager.setString(57,prpLcompensatetgDto.getBusinessType());
        dbManager.setString(58,prpLcompensatetgDto.getBusinessType1());

        dbManager.setString(59,prpLcompensatetgDto.getFinallyFlag());
        dbManager.setString(60,prpLcompensatetgDto.getMedicalType());
        //设置条件字段;
        
        dbManager.setString(61,prpLcompensatetgDto.getWoundGrade());
        dbManager.setString(62,prpLcompensatetgDto.getClaimType());
        dbManager.setString(63,prpLcompensatetgDto.getThridLicenseNos());
        dbManager.setString(64,prpLcompensatetgDto.getThridLicenseNos());
        dbManager.setString(65,prpLcompensatetgDto.getBusinessFlag());
        dbManager.setString(66,prpLcompensatetgDto.getOtherFlag());
        dbManager.setString(67,prpLcompensatetgDto.getOjectName());
        dbManager.setString(68,prpLcompensatetgDto.getOjectType());
        dbManager.setString(69,prpLcompensatetgDto.getOjectCode());
        dbManager.setString(70,prpLcompensatetgDto.getUploadSerialNo());
        dbManager.setDateTime(71,prpLcompensatetgDto.getPayrefDate());
        dbManager.setString(72, prpLcompensatetgDto.getClaimRelationNo());
        dbManager.setString(73,prpLcompensatetgDto.getZeroLossType());
        dbManager.setString(74,prpLcompensatetgDto.getZeroLossCaseType());
        dbManager.setString(75,prpLcompensatetgDto.getZeroLossDetailReason());
        dbManager.setString(76, prpLcompensatetgDto.getCoinsPaidLossType());
        
        dbManager.setDouble(77, prpLcompensatetgDto.getCoinsSumPaid());
        
        dbManager.setString(78,prpLcompensatetgDto.getClaimNotification());
        dbManager.setString(79,prpLcompensatetgDto.getInncentTreatment());
        
        dbManager.setString(80,prpLcompensatetgDto.getLawsuitFlag());
        dbManager.setString(81,prpLcompensatetgDto.getCompensateNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcompensatetgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号码
     * @return PrpLcompensatetgDto
     * @throws Exception
     */
    public PrpLcompensatetgDto findByPrimaryKey(String compensateNo) throws Exception{
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
                           " From PrpLcompensatetg";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ?";
        PrpLcompensatetgDto prpLcompensatetgDto = null;
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
            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensatetgDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensatetgDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensatetgDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensatetgDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensatetgDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensatetgDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensatetgDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensatetgDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensatetgDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensatetgDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensatetgDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensatetgDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensatetgDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensatetgDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensatetgDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensatetgDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensatetgDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensatetgDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensatetgDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensatetgDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensatetgDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensatetgDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensatetgDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensatetgDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensatetgDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensatetgDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensatetgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensatetgDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensatetgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensatetgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensatetgDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensatetgDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensatetgDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensatetgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensatetgDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensatetgDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensatetgDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensatetgDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensatetgDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensatetgDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensatetgDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensatetgDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensatetgDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensatetgDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensatetgDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensatetgDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensatetgDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensatetgDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensatetgDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensatetgDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensatetgDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensatetgDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensatetgDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensatetgDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensatetgDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensatetgDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensatetgDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensatetgDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensatetgDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensatetgDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensatetgDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensatetgDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensatetgDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensatetgDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensatetgDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensatetgDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensatetgDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensatetgDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensatetgDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensatetgDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensatetgDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensatetgDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            
            prpLcompensatetgDto.setLawsuitFlag(dbManager.getString(resultSet,81));
            //ObjectName,ObjectType,ObjectCode
            
            
            logger.info("DBPrpLcompensatetgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcompensatetgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcompensatetgDto;
    }
    /**
     * 按立案号查找一条数据
     * @param compensateNo 赔款计算书号码
     * @return PrpLcompensatetgDto
     * @throws Exception
     */
    public PrpLcompensatetgDto findByClaimNo(String claimNo) throws Exception{
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
                           " From PrpLcompensatetg";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ?";
        PrpLcompensatetgDto prpLcompensatetgDto = null;
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
            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensatetgDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensatetgDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensatetgDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensatetgDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensatetgDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensatetgDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensatetgDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensatetgDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensatetgDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensatetgDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensatetgDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensatetgDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensatetgDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensatetgDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensatetgDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensatetgDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensatetgDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensatetgDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensatetgDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensatetgDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensatetgDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensatetgDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensatetgDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensatetgDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensatetgDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensatetgDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensatetgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensatetgDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensatetgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensatetgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensatetgDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensatetgDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensatetgDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensatetgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensatetgDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensatetgDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensatetgDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensatetgDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensatetgDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensatetgDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensatetgDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensatetgDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensatetgDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensatetgDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensatetgDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensatetgDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensatetgDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensatetgDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensatetgDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensatetgDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensatetgDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensatetgDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensatetgDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensatetgDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensatetgDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensatetgDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensatetgDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensatetgDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensatetgDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensatetgDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensatetgDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensatetgDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensatetgDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensatetgDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensatetgDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensatetgDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensatetgDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensatetgDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensatetgDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensatetgDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensatetgDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensatetgDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensatetgDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            //ObjectName,ObjectType,ObjectCode
            
            
            logger.info("DBPrpLcompensatetgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcompensatetgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcompensatetgDto;
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
                           " From PrpLcompensatetg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensatetgDto prpLcompensatetgDto = null;
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

            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensatetgDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensatetgDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensatetgDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensatetgDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensatetgDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensatetgDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensatetgDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensatetgDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensatetgDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensatetgDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensatetgDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensatetgDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensatetgDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensatetgDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensatetgDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensatetgDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensatetgDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensatetgDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensatetgDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensatetgDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensatetgDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensatetgDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensatetgDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensatetgDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensatetgDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensatetgDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensatetgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensatetgDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensatetgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensatetgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensatetgDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensatetgDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensatetgDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensatetgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensatetgDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensatetgDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensatetgDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensatetgDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensatetgDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensatetgDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensatetgDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensatetgDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensatetgDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensatetgDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensatetgDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensatetgDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensatetgDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensatetgDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensatetgDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensatetgDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensatetgDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensatetgDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensatetgDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensatetgDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensatetgDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensatetgDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensatetgDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensatetgDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensatetgDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensatetgDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensatetgDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensatetgDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensatetgDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensatetgDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensatetgDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensatetgDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensatetgDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensatetgDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensatetgDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensatetgDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensatetgDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensatetgDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensatetgDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            collection.add(prpLcompensatetgDto);
        }
        resultSet.close();
        logger.info("DBPrpLcompensatetgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcompensatetg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcompensatetgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcompensatetg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcompensatetgBase.getCount() success!");
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
                           " From PrpLcompensatetg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensatetgDto prpLcompensatetgDto = null;
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

            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setLFlag(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setTimes(dbManager.getInt(resultSet,4));
            prpLcompensatetgDto.setClassCode(dbManager.getString(resultSet,5));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,7));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLcompensatetgDto.setDeductCond(dbManager.getString(resultSet,9));
            prpLcompensatetgDto.setPreserveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLcompensatetgDto.setCheckAgentCode(dbManager.getString(resultSet,11));
            prpLcompensatetgDto.setCheckAgentName(dbManager.getString(resultSet,12));
            prpLcompensatetgDto.setSurveyorName(dbManager.getString(resultSet,13));
            prpLcompensatetgDto.setCounterClaimerName(dbManager.getString(resultSet,14));
            prpLcompensatetgDto.setDutyDescription(dbManager.getString(resultSet,15));
            prpLcompensatetgDto.setCurrency(dbManager.getString(resultSet,16));
            prpLcompensatetgDto.setSumLoss(dbManager.getDouble(resultSet,17));
            prpLcompensatetgDto.setSumRest(dbManager.getDouble(resultSet,18));
            prpLcompensatetgDto.setSumDutyPaid(dbManager.getDouble(resultSet,19));
            prpLcompensatetgDto.setSumNoDutyFee(dbManager.getDouble(resultSet,20));
            prpLcompensatetgDto.setSumPaid(dbManager.getDouble(resultSet,21));
            prpLcompensatetgDto.setSumPrePaid(dbManager.getDouble(resultSet,22));
            prpLcompensatetgDto.setSumThisPaid(dbManager.getDouble(resultSet,23));
            prpLcompensatetgDto.setReceiverName(dbManager.getString(resultSet,24));
            prpLcompensatetgDto.setBank(dbManager.getString(resultSet,25));
            prpLcompensatetgDto.setAccount(dbManager.getString(resultSet,26));
            prpLcompensatetgDto.setMakeCom(dbManager.getString(resultSet,27));
            prpLcompensatetgDto.setComCode(dbManager.getString(resultSet,28));
            prpLcompensatetgDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLcompensatetgDto.setHandler1Code(dbManager.getString(resultSet,30));
            prpLcompensatetgDto.setApproverCode(dbManager.getString(resultSet,31));
            prpLcompensatetgDto.setUnderWriteCode(dbManager.getString(resultSet,32));
            prpLcompensatetgDto.setUnderWriteName(dbManager.getString(resultSet,33));
            prpLcompensatetgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            prpLcompensatetgDto.setOperatorCode(dbManager.getString(resultSet,35));
            prpLcompensatetgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,36));
            prpLcompensatetgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,38));
            prpLcompensatetgDto.setRemark(dbManager.getString(resultSet,39));
            prpLcompensatetgDto.setFlag(dbManager.getString(resultSet,40));
            prpLcompensatetgDto.setCaseType(dbManager.getString(resultSet,41));
            prpLcompensatetgDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,42));
            prpLcompensatetgDto.setIndemnityDuty(dbManager.getString(resultSet,43));
            prpLcompensatetgDto.setResult(dbManager.getString(resultSet,44));
            prpLcompensatetgDto.setLossesNumber(dbManager.getDouble(resultSet,45));
            prpLcompensatetgDto.setLossesUnitCode(dbManager.getString(resultSet,46));
            prpLcompensatetgDto.setDamageInsured(dbManager.getDouble(resultSet,47));
            prpLcompensatetgDto.setDisasterArea(dbManager.getDouble(resultSet,48));
            prpLcompensatetgDto.setDisasterUnit(dbManager.getString(resultSet,49));
            prpLcompensatetgDto.setAffectedArea(dbManager.getDouble(resultSet,50));
            prpLcompensatetgDto.setAffectedUnit(dbManager.getString(resultSet,51));
            prpLcompensatetgDto.setNoProductionArea(dbManager.getDouble(resultSet,52));
            prpLcompensatetgDto.setNoProductionUnit(dbManager.getString(resultSet,53));
            prpLcompensatetgDto.setDeathQuantity(dbManager.getDouble(resultSet,54));
            prpLcompensatetgDto.setDeathUnit(dbManager.getString(resultSet,55));
            prpLcompensatetgDto.setKillQuantity(dbManager.getDouble(resultSet,56));
            prpLcompensatetgDto.setKillUnit(dbManager.getString(resultSet,57));
            prpLcompensatetgDto.setBusinessType(dbManager.getString(resultSet,58));
            prpLcompensatetgDto.setBusinessType1(dbManager.getString(resultSet,59));

            prpLcompensatetgDto.setFinallyFlag(dbManager.getString(resultSet,60));
            prpLcompensatetgDto.setMedicalType(dbManager.getString(resultSet,61));
            prpLcompensatetgDto.setWoundGrade(dbManager.getString(resultSet,62));
            prpLcompensatetgDto.setClaimType(dbManager.getString(resultSet,63));
            prpLcompensatetgDto.setThridLicenseNos(dbManager.getString(resultSet,64));
            prpLcompensatetgDto.setThridCompanys(dbManager.getString(resultSet,65));
            prpLcompensatetgDto.setBusinessFlag(dbManager.getString(resultSet,66));
            prpLcompensatetgDto.setOtherFlag(dbManager.getString(resultSet,67));
            prpLcompensatetgDto.setOjectName(dbManager.getString(resultSet,68));
            prpLcompensatetgDto.setOjectType(dbManager.getString(resultSet,69));
            prpLcompensatetgDto.setOjectCode(dbManager.getString(resultSet,70));
            prpLcompensatetgDto.setUploadSerialNo(dbManager.getString(resultSet,71));
            prpLcompensatetgDto.setPayrefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,72));
            prpLcompensatetgDto.setClaimRelationNo(dbManager.getString(resultSet, 73));
            prpLcompensatetgDto.setZeroLossType(dbManager.getString(resultSet, 74));
            prpLcompensatetgDto.setZeroLossCaseType(dbManager.getString(resultSet, 75));
            prpLcompensatetgDto.setZeroLossDetailReason(dbManager.getString(resultSet, 76));
            prpLcompensatetgDto.setCoinsPaidLossType(dbManager.getString(resultSet, 77));
            prpLcompensatetgDto.setCoinsSumPaid(dbManager.getDouble(resultSet, 78));
            prpLcompensatetgDto.setClaimNotification(dbManager.getString(resultSet, 79));
            prpLcompensatetgDto.setInncentTreatment(dbManager.getString(resultSet, 80));
            prpLcompensatetgDto.setLawsuitFlag(dbManager.getString(resultSet, 81));
            collection.add(prpLcompensatetgDto);
        }
        resultSet.close();
        logger.info("DBPrpLcompensatetgBase.findByConditions() success!");
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


