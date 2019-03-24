package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLoss－定核损主表的数据访问对象基类<br>
 * 创建于 2006-04-17 15:58:45.177<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLverifyLossBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void insert(PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        String mainStatement = " Insert Into PrpLverifyLoss (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " InsuredName," + 
                           " LicenseNo," + 
                           " LicenseColorcode," + 
                           " CarKindCode," + 
                           " Currency," + 
                           " SumPreDefLoss," + 
                           " SumDefLoss," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " DefLossDate," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " VerifyRemark," + 
                           " Flag," + 
                           " BackCheckRemark," + 
                           " VeriwReturnReason," + 
                           " VerifyOpinion," + 
                           " FirstDefLoss," + 
                           " WarpDefLoss," + 
                           " VerpApproverCode," + 
                           " VerpDate," + 
                           " VerpOpinion," + 
                           " VerpRemark," + 
                           " CompensateFlag," + 
                           " CompensateOpinion," + 
                           " CompensateBackDate," + 
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

                           " CompensateApproverCode)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLverifyLossDto.getRegistNo() + "'," + 
                           "'" + prpLverifyLossDto.getClaimNo() + "'," + 
                           "'" + prpLverifyLossDto.getRiskCode() + "'," + 
                           "'" + prpLverifyLossDto.getPolicyNo() + "'," + 
                           "'" + prpLverifyLossDto.getLossItemCode() + "'," + 
                           "'" + prpLverifyLossDto.getLossItemName() + "'," + 
                           "'" + prpLverifyLossDto.getInsureCarFlag() + "'," + 
                           "'" + prpLverifyLossDto.getInsuredName() + "'," + 
                           "'" + prpLverifyLossDto.getLicenseNo() + "'," + 
                           "'" + prpLverifyLossDto.getLicenseColorcode() + "'," + 
                           "'" + prpLverifyLossDto.getCarKindCode() + "'," + 
                           "'" + prpLverifyLossDto.getCurrency() + "'," + 
                           "'" + prpLverifyLossDto.getSumPreDefLoss() + "'," + 
                           "'" + prpLverifyLossDto.getSumDefLoss() + "'," + 
                           "'" + prpLverifyLossDto.getMakeCom() + "'," + 
                           "'" + prpLverifyLossDto.getComCode() + "'," + 
                           "'" + prpLverifyLossDto.getHandlerCode() + "'," + 
                           "'" + prpLverifyLossDto.getHandlerName() + "'," + 
                           "'" + prpLverifyLossDto.getDefLossDate() + "'," + 
                           "'" + prpLverifyLossDto.getUnderWriteCode() + "'," + 
                           "'" + prpLverifyLossDto.getUnderWriteName() + "'," + 
                           "'" + prpLverifyLossDto.getUnderWriteEndDate() + "'," + 
                           "'" + prpLverifyLossDto.getUnderWriteFlag() + "'," + 
                           "'" + prpLverifyLossDto.getRemark() + "'," + 
                           "'" + prpLverifyLossDto.getVerifyRemark() + "'," + 
                           "'" + prpLverifyLossDto.getFlag() + "'," + 
                           "'" + prpLverifyLossDto.getBackCheckRemark() + "'," + 
                           "'" + prpLverifyLossDto.getVeriwReturnReason() + "'," + 
                           "'" + prpLverifyLossDto.getVerifyOpinion() + "'," + 
                           "'" + prpLverifyLossDto.getFirstDefLoss() + "'," + 
                           "'" + prpLverifyLossDto.getWarpDefLoss() + "'," + 
                           "'" + prpLverifyLossDto.getVerpApproverCode() + "'," + 
                           "'" + prpLverifyLossDto.getVerpDate() + "'," + 
                           "'" + prpLverifyLossDto.getVerpOpinion() + "'," + 
                           "'" + prpLverifyLossDto.getVerpRemark() + "'," + 
                           "'" + prpLverifyLossDto.getCompensateFlag() + "'," + 
                           "'" + prpLverifyLossDto.getCompensateOpinion() + "'," + 
                           "'" + prpLverifyLossDto.getCompensateBackDate() + "'," + 
                           "" + prpLverifyLossDto.getLossesNumber() + "," + 
                           "'" + prpLverifyLossDto.getLossesUnitCode() + "'," + 
                           "" + prpLverifyLossDto.getDamageInsured() + "," + 
                           "" + prpLverifyLossDto.getDisasterArea() + "," + 
                           "'" + prpLverifyLossDto.getDisasterUnit() + "'," + 
                           "" + prpLverifyLossDto.getAffectedArea() + "," + 
                           "'" + prpLverifyLossDto.getAffectedUnit() + "'," + 
                           "" + prpLverifyLossDto.getNoProductionArea() + "," + 
                           "'" + prpLverifyLossDto.getNoProductionUnit() + "'," + 
                           "" + prpLverifyLossDto.getDeathQuantity() + "," + 
                           "'" + prpLverifyLossDto.getDeathUnit() + "'," + 
                           "" + prpLverifyLossDto.getKillQuantity() + "," + 
                           "'" + prpLverifyLossDto.getKillUnit() + "'," + 
                           "'" + prpLverifyLossDto.getBusinessType() + "'," + 
                           "'" + prpLverifyLossDto.getBusinessType1() + "'," + 

                           "'" + prpLverifyLossDto.getCompensateApproverCode() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLverifyLossDto.getRegistNo());
        dbManager.setString(2,prpLverifyLossDto.getClaimNo());
        dbManager.setString(3,prpLverifyLossDto.getRiskCode());
        dbManager.setString(4,prpLverifyLossDto.getPolicyNo());
        dbManager.setString(5,prpLverifyLossDto.getLossItemCode());
        dbManager.setString(6,prpLverifyLossDto.getLossItemName());
        dbManager.setString(7,prpLverifyLossDto.getInsureCarFlag());
        dbManager.setString(8,prpLverifyLossDto.getInsuredName());
        dbManager.setString(9,prpLverifyLossDto.getLicenseNo());
        dbManager.setString(10,prpLverifyLossDto.getLicenseColorcode());
        dbManager.setString(11,prpLverifyLossDto.getCarKindCode());
        dbManager.setString(12,prpLverifyLossDto.getCurrency());
        dbManager.setDouble(13,prpLverifyLossDto.getSumPreDefLoss());
        dbManager.setDouble(14,prpLverifyLossDto.getSumDefLoss());
        dbManager.setString(15,prpLverifyLossDto.getMakeCom());
        dbManager.setString(16,prpLverifyLossDto.getComCode());
        dbManager.setString(17,prpLverifyLossDto.getHandlerCode());
        dbManager.setString(18,prpLverifyLossDto.getHandlerName());
        dbManager.setDateTime(19,prpLverifyLossDto.getDefLossDate());
        dbManager.setString(20,prpLverifyLossDto.getUnderWriteCode());
        dbManager.setString(21,prpLverifyLossDto.getUnderWriteName());
        dbManager.setDateTime(22,prpLverifyLossDto.getUnderWriteEndDate());
        dbManager.setString(23,prpLverifyLossDto.getUnderWriteFlag());
        dbManager.setString(24,prpLverifyLossDto.getRemark());
        dbManager.setString(25,prpLverifyLossDto.getVerifyRemark());
        dbManager.setString(26,prpLverifyLossDto.getFlag());
        dbManager.setString(27,prpLverifyLossDto.getBackCheckRemark());
        dbManager.setString(28,prpLverifyLossDto.getVeriwReturnReason());
        dbManager.setString(29,prpLverifyLossDto.getVerifyOpinion());
        dbManager.setDouble(30,prpLverifyLossDto.getFirstDefLoss());
        dbManager.setDouble(31,prpLverifyLossDto.getWarpDefLoss());
        dbManager.setString(32,prpLverifyLossDto.getVerpApproverCode());
        dbManager.setDateTime(33,prpLverifyLossDto.getVerpDate());
        dbManager.setString(34,prpLverifyLossDto.getVerpOpinion());
        dbManager.setString(35,prpLverifyLossDto.getVerpRemark());
        dbManager.setString(36,prpLverifyLossDto.getCompensateFlag());
        dbManager.setString(37,prpLverifyLossDto.getCompensateOpinion());
        dbManager.setDateTime(38,prpLverifyLossDto.getCompensateBackDate());
        dbManager.setDouble(39,prpLverifyLossDto.getLossesNumber());
        dbManager.setString(40,prpLverifyLossDto.getLossesUnitCode());
        dbManager.setDouble(41,prpLverifyLossDto.getDamageInsured());
        dbManager.setDouble(42,prpLverifyLossDto.getDisasterArea());
        dbManager.setString(43,prpLverifyLossDto.getDisasterUnit());
        dbManager.setDouble(44,prpLverifyLossDto.getAffectedArea());
        dbManager.setString(45,prpLverifyLossDto.getAffectedUnit());
        dbManager.setDouble(46,prpLverifyLossDto.getNoProductionArea());
        dbManager.setString(47,prpLverifyLossDto.getNoProductionUnit());
        dbManager.setDouble(48,prpLverifyLossDto.getDeathQuantity());
        dbManager.setString(49,prpLverifyLossDto.getDeathUnit());
        dbManager.setDouble(50,prpLverifyLossDto.getKillQuantity());
        dbManager.setString(51,prpLverifyLossDto.getKillUnit());
        dbManager.setString(52,prpLverifyLossDto.getBusinessType());
        dbManager.setString(53,prpLverifyLossDto.getBusinessType1());

        dbManager.setString(54,prpLverifyLossDto.getCompensateApproverCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLverifyLossBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)i.next();
            insert(prpLverifyLossDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param lossItemCode 标的序号
     * @throws Exception
     */
    public void delete(String registNo,String lossItemCode) throws Exception{
        String statement = " Delete From PrpLverifyLoss" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLverifyLoss Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLverifyLossBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLverifyLossDto prpLverifyLossDto
     * @throws Exception
     */
    public void update(PrpLverifyLossDto prpLverifyLossDto) throws Exception{
        String statement = " Update PrpLverifyLoss Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " LossItemName = ?," + 
                           " InsureCarFlag = ?," + 
                           " InsuredName = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorcode = ?," + 
                           " CarKindCode = ?," + 
                           " Currency = ?," + 
                           " SumPreDefLoss = ?," + 
                           " SumDefLoss = ?," + 
                           " MakeCom = ?," + 
                           " ComCode = ?," + 
                           " HandlerCode = ?," + 
                           " HandlerName = ?," + 
                           " DefLossDate = ?," + 
                           " UnderWriteCode = ?," + 
                           " UnderWriteName = ?," + 
                           " UnderWriteEndDate = ?," + 
                           " UnderWriteFlag = ?," + 
                           " Remark = ?," + 
                           " VerifyRemark = ?," + 
                           " Flag = ?," + 
                           " BackCheckRemark = ?," + 
                           " VeriwReturnReason = ?," + 
                           " VerifyOpinion = ?," + 
                           " FirstDefLoss = ?," + 
                           " WarpDefLoss = ?," + 
                           " VerpApproverCode = ?," + 
                           " VerpDate = ?," + 
                           " VerpOpinion = ?," + 
                           " VerpRemark = ?," + 
                           " CompensateFlag = ?," + 
                           " CompensateOpinion = ?," + 
                           " CompensateBackDate = ?," + 
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

                           " CompensateApproverCode = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLverifyLoss Set " + 
                           " RegistNo = '" + prpLverifyLossDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLverifyLossDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLverifyLossDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLverifyLossDto.getPolicyNo() + "'," + 
                           " LossItemCode = '" + prpLverifyLossDto.getLossItemCode() + "'," + 
                           " LossItemName = '" + prpLverifyLossDto.getLossItemName() + "'," + 
                           " InsureCarFlag = '" + prpLverifyLossDto.getInsureCarFlag() + "'," + 
                           " InsuredName = '" + prpLverifyLossDto.getInsuredName() + "'," + 
                           " LicenseNo = '" + prpLverifyLossDto.getLicenseNo() + "'," + 
                           " LicenseColorcode = '" + prpLverifyLossDto.getLicenseColorcode() + "'," + 
                           " CarKindCode = '" + prpLverifyLossDto.getCarKindCode() + "'," + 
                           " Currency = '" + prpLverifyLossDto.getCurrency() + "'," + 
                           " SumPreDefLoss = '" + prpLverifyLossDto.getSumPreDefLoss() + "'," + 
                           " SumDefLoss = '" + prpLverifyLossDto.getSumDefLoss() + "'," + 
                           " MakeCom = '" + prpLverifyLossDto.getMakeCom() + "'," + 
                           " ComCode = '" + prpLverifyLossDto.getComCode() + "'," + 
                           " HandlerCode = '" + prpLverifyLossDto.getHandlerCode() + "'," + 
                           " HandlerName = '" + prpLverifyLossDto.getHandlerName() + "'," + 
                           " DefLossDate = '" + prpLverifyLossDto.getDefLossDate() + "'," + 
                           " UnderWriteCode = '" + prpLverifyLossDto.getUnderWriteCode() + "'," + 
                           " UnderWriteName = '" + prpLverifyLossDto.getUnderWriteName() + "'," + 
                           " UnderWriteEndDate = '" + prpLverifyLossDto.getUnderWriteEndDate() + "'," + 
                           " UnderWriteFlag = '" + prpLverifyLossDto.getUnderWriteFlag() + "'," + 
                           " Remark = '" + prpLverifyLossDto.getRemark() + "'," + 
                           " VerifyRemark = '" + prpLverifyLossDto.getVerifyRemark() + "'," + 
                           " Flag = '" + prpLverifyLossDto.getFlag() + "'," + 
                           " BackCheckRemark = '" + prpLverifyLossDto.getBackCheckRemark() + "'," + 
                           " VeriwReturnReason = '" + prpLverifyLossDto.getVeriwReturnReason() + "'," + 
                           " VerifyOpinion = '" + prpLverifyLossDto.getVerifyOpinion() + "'," + 
                           " FirstDefLoss = '" + prpLverifyLossDto.getFirstDefLoss() + "'," + 
                           " WarpDefLoss = '" + prpLverifyLossDto.getWarpDefLoss() + "'," + 
                           " VerpApproverCode = '" + prpLverifyLossDto.getVerpApproverCode() + "'," + 
                           " VerpDate = '" + prpLverifyLossDto.getVerpDate() + "'," + 
                           " VerpOpinion = '" + prpLverifyLossDto.getVerpOpinion() + "'," + 
                           " VerpRemark = '" + prpLverifyLossDto.getVerpRemark() + "'," + 
                           " CompensateFlag = '" + prpLverifyLossDto.getCompensateFlag() + "'," + 
                           " CompensateOpinion = '" + prpLverifyLossDto.getCompensateOpinion() + "'," + 
                           " CompensateBackDate = '" + prpLverifyLossDto.getCompensateBackDate() + "'," +
                           " LossesNumber = " + prpLverifyLossDto.getLossesNumber() + "," + 
                           " LossesUnitCode = '" + prpLverifyLossDto.getLossesUnitCode() + "'," + 
                           " DamageInsured = " + prpLverifyLossDto.getDamageInsured() + "," + 
                           " DisasterArea = " + prpLverifyLossDto.getDisasterArea() + "," + 
                           " DisasterUnit = '" + prpLverifyLossDto.getDisasterUnit() + "'," + 
                           " AffectedArea = " + prpLverifyLossDto.getAffectedArea() + "," + 
                           " AffectedUnit = '" + prpLverifyLossDto.getAffectedUnit() + "'," + 
                           " NoProductionArea = " + prpLverifyLossDto.getNoProductionArea() + "," + 
                           " NoProductionUnit = '" + prpLverifyLossDto.getNoProductionUnit() + "'," + 
                           " DeathQuantity = " + prpLverifyLossDto.getDeathQuantity() + "," + 
                           " DeathUnit = '" + prpLverifyLossDto.getDeathUnit() + "'," + 
                           " KillQuantity = " + prpLverifyLossDto.getKillQuantity() + "," + 
                           " KillUnit = '" + prpLverifyLossDto.getKillUnit() + "'," + 
                           " BusinessType = '" + prpLverifyLossDto.getBusinessType() + "'," + 
                           " BusinessType1 = '" + prpLverifyLossDto.getBusinessType1() + "'," + 

                           " CompensateApproverCode = '" + prpLverifyLossDto.getCompensateApproverCode() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLverifyLossDto.getRegistNo() + "' And " + 
                           " LossItemCode = '" + prpLverifyLossDto.getLossItemCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLverifyLossDto.getClaimNo());
        dbManager.setString(2,prpLverifyLossDto.getRiskCode());
        dbManager.setString(3,prpLverifyLossDto.getPolicyNo());
        dbManager.setString(4,prpLverifyLossDto.getLossItemName());
        dbManager.setString(5,prpLverifyLossDto.getInsureCarFlag());
        dbManager.setString(6,prpLverifyLossDto.getInsuredName());
        dbManager.setString(7,prpLverifyLossDto.getLicenseNo());
        dbManager.setString(8,prpLverifyLossDto.getLicenseColorcode());
        dbManager.setString(9,prpLverifyLossDto.getCarKindCode());
        dbManager.setString(10,prpLverifyLossDto.getCurrency());
        dbManager.setDouble(11,prpLverifyLossDto.getSumPreDefLoss());
        dbManager.setDouble(12,prpLverifyLossDto.getSumDefLoss());
        dbManager.setString(13,prpLverifyLossDto.getMakeCom());
        dbManager.setString(14,prpLverifyLossDto.getComCode());
        dbManager.setString(15,prpLverifyLossDto.getHandlerCode());
        dbManager.setString(16,prpLverifyLossDto.getHandlerName());
        dbManager.setDateTime(17,prpLverifyLossDto.getDefLossDate());
        dbManager.setString(18,prpLverifyLossDto.getUnderWriteCode());
        dbManager.setString(19,prpLverifyLossDto.getUnderWriteName());
        dbManager.setDateTime(20,prpLverifyLossDto.getUnderWriteEndDate());
        dbManager.setString(21,prpLverifyLossDto.getUnderWriteFlag());
        dbManager.setString(22,prpLverifyLossDto.getRemark());
        dbManager.setString(23,prpLverifyLossDto.getVerifyRemark());
        dbManager.setString(24,prpLverifyLossDto.getFlag());
        dbManager.setString(25,prpLverifyLossDto.getBackCheckRemark());
        dbManager.setString(26,prpLverifyLossDto.getVeriwReturnReason());
        dbManager.setString(27,prpLverifyLossDto.getVerifyOpinion());
        dbManager.setDouble(28,prpLverifyLossDto.getFirstDefLoss());
        dbManager.setDouble(29,prpLverifyLossDto.getWarpDefLoss());
        dbManager.setString(30,prpLverifyLossDto.getVerpApproverCode());
        dbManager.setDateTime(31,prpLverifyLossDto.getVerpDate());
        dbManager.setString(32,prpLverifyLossDto.getVerpOpinion());
        dbManager.setString(33,prpLverifyLossDto.getVerpRemark());
        dbManager.setString(34,prpLverifyLossDto.getCompensateFlag());
        dbManager.setString(35,prpLverifyLossDto.getCompensateOpinion());
        dbManager.setDateTime(36,prpLverifyLossDto.getCompensateBackDate());
        dbManager.setDouble(37,prpLverifyLossDto.getLossesNumber());
        dbManager.setString(38,prpLverifyLossDto.getLossesUnitCode());
        dbManager.setDouble(39,prpLverifyLossDto.getDamageInsured());
        dbManager.setDouble(40,prpLverifyLossDto.getDisasterArea());
        dbManager.setString(41,prpLverifyLossDto.getDisasterUnit());
        dbManager.setDouble(42,prpLverifyLossDto.getAffectedArea());
        dbManager.setString(43,prpLverifyLossDto.getAffectedUnit());
        dbManager.setDouble(44,prpLverifyLossDto.getNoProductionArea());
        dbManager.setString(45,prpLverifyLossDto.getNoProductionUnit());
        dbManager.setDouble(46,prpLverifyLossDto.getDeathQuantity());
        dbManager.setString(47,prpLverifyLossDto.getDeathUnit());
        dbManager.setDouble(48,prpLverifyLossDto.getKillQuantity());
        dbManager.setString(49,prpLverifyLossDto.getKillUnit());
        dbManager.setString(50,prpLverifyLossDto.getBusinessType());
        dbManager.setString(51,prpLverifyLossDto.getBusinessType1());

        dbManager.setString(52,prpLverifyLossDto.getCompensateApproverCode());
        //设置条件字段;
        dbManager.setString(53,prpLverifyLossDto.getRegistNo());
        dbManager.setString(54,prpLverifyLossDto.getLossItemCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLverifyLossBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param lossItemCode 标的序号
     * @return PrpLverifyLossDto
     * @throws Exception
     */
    public PrpLverifyLossDto findByPrimaryKey(String registNo,String lossItemCode) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " InsuredName," + 
                           " LicenseNo," + 
                           " LicenseColorcode," + 
                           " CarKindCode," + 
                           " Currency," + 
                           " SumPreDefLoss," + 
                           " SumDefLoss," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " DefLossDate," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " VerifyRemark," + 
                           " Flag," + 
                           " BackCheckRemark," + 
                           " VeriwReturnReason," + 
                           " VerifyOpinion," + 
                           " FirstDefLoss," + 
                           " WarpDefLoss," + 
                           " VerpApproverCode," + 
                           " VerpDate," + 
                           " VerpOpinion," + 
                           " VerpRemark," + 
                           " CompensateFlag," + 
                           " CompensateOpinion," + 
                           " CompensateBackDate," + 
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

                           " CompensateApproverCode From PrpLverifyLoss";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        PrpLverifyLossDto prpLverifyLossDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLverifyLossDto = new PrpLverifyLossDto();
            prpLverifyLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLverifyLossDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLverifyLossDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLverifyLossDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLverifyLossDto.setLossItemName(dbManager.getString(resultSet,6));
            prpLverifyLossDto.setInsureCarFlag(dbManager.getString(resultSet,7));
            prpLverifyLossDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLverifyLossDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLverifyLossDto.setLicenseColorcode(dbManager.getString(resultSet,10));
            prpLverifyLossDto.setCarKindCode(dbManager.getString(resultSet,11));
            prpLverifyLossDto.setCurrency(dbManager.getString(resultSet,12));
            prpLverifyLossDto.setSumPreDefLoss(dbManager.getDouble(resultSet,13));
            prpLverifyLossDto.setSumDefLoss(dbManager.getDouble(resultSet,14));
            prpLverifyLossDto.setMakeCom(dbManager.getString(resultSet,15));
            prpLverifyLossDto.setComCode(dbManager.getString(resultSet,16));
            prpLverifyLossDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpLverifyLossDto.setHandlerName(dbManager.getString(resultSet,18));
            prpLverifyLossDto.setDefLossDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLverifyLossDto.setUnderWriteCode(dbManager.getString(resultSet,20));
            prpLverifyLossDto.setUnderWriteName(dbManager.getString(resultSet,21));
            prpLverifyLossDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLverifyLossDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLverifyLossDto.setRemark(dbManager.getString(resultSet,24));
            prpLverifyLossDto.setVerifyRemark(dbManager.getString(resultSet,25));
            prpLverifyLossDto.setFlag(dbManager.getString(resultSet,26));
            prpLverifyLossDto.setBackCheckRemark(dbManager.getString(resultSet,27));
            prpLverifyLossDto.setVeriwReturnReason(dbManager.getString(resultSet,28));
            prpLverifyLossDto.setVerifyOpinion(dbManager.getString(resultSet,29));
            prpLverifyLossDto.setFirstDefLoss(dbManager.getDouble(resultSet,30));
            prpLverifyLossDto.setWarpDefLoss(dbManager.getDouble(resultSet,31));
            prpLverifyLossDto.setVerpApproverCode(dbManager.getString(resultSet,32));
            prpLverifyLossDto.setVerpDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            prpLverifyLossDto.setVerpOpinion(dbManager.getString(resultSet,34));
            prpLverifyLossDto.setVerpRemark(dbManager.getString(resultSet,35));
            prpLverifyLossDto.setCompensateFlag(dbManager.getString(resultSet,36));
            prpLverifyLossDto.setCompensateOpinion(dbManager.getString(resultSet,37));
            prpLverifyLossDto.setCompensateBackDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,38));
            prpLverifyLossDto.setLossesNumber(dbManager.getDouble(resultSet,39));
            prpLverifyLossDto.setLossesUnitCode(dbManager.getString(resultSet,40));
            prpLverifyLossDto.setDamageInsured(dbManager.getDouble(resultSet,41));
            prpLverifyLossDto.setDisasterArea(dbManager.getDouble(resultSet,42));
            prpLverifyLossDto.setDisasterUnit(dbManager.getString(resultSet,43));
            prpLverifyLossDto.setAffectedArea(dbManager.getDouble(resultSet,44));
            prpLverifyLossDto.setAffectedUnit(dbManager.getString(resultSet,45));
            prpLverifyLossDto.setNoProductionArea(dbManager.getDouble(resultSet,46));
            prpLverifyLossDto.setNoProductionUnit(dbManager.getString(resultSet,47));
            prpLverifyLossDto.setDeathQuantity(dbManager.getDouble(resultSet,48));
            prpLverifyLossDto.setDeathUnit(dbManager.getString(resultSet,49));
            prpLverifyLossDto.setKillQuantity(dbManager.getDouble(resultSet,50));
            prpLverifyLossDto.setKillUnit(dbManager.getString(resultSet,51));
            prpLverifyLossDto.setBusinessType(dbManager.getString(resultSet,52));
            prpLverifyLossDto.setBusinessType1(dbManager.getString(resultSet,53));

            prpLverifyLossDto.setCompensateApproverCode(dbManager.getString(resultSet,54));
        }
        resultSet.close();
        logger.info("DBPrpLverifyLossBase.findByPrimaryKey() success!");
        return prpLverifyLossDto;
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
        String statement = "Select RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " InsuredName," + 
                           " LicenseNo," + 
                           " LicenseColorcode," + 
                           " CarKindCode," + 
                           " Currency," + 
                           " SumPreDefLoss," + 
                           " SumDefLoss," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " DefLossDate," + 
                           " UnderWriteCode," + 
                           " UnderWriteName," + 
                           " UnderWriteEndDate," + 
                           " UnderWriteFlag," + 
                           " Remark," + 
                           " VerifyRemark," + 
                           " Flag," + 
                           " BackCheckRemark," + 
                           " VeriwReturnReason," + 
                           " VerifyOpinion," + 
                           " FirstDefLoss," + 
                           " WarpDefLoss," + 
                           " VerpApproverCode," + 
                           " VerpDate," + 
                           " VerpOpinion," + 
                           " VerpRemark," + 
                           " CompensateFlag," + 
                           " CompensateOpinion," + 
                           " CompensateBackDate," + 
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

                           " CompensateApproverCode From PrpLverifyLoss Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLverifyLossDto prpLverifyLossDto = null;
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

            prpLverifyLossDto = new PrpLverifyLossDto();
            prpLverifyLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLverifyLossDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLverifyLossDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLverifyLossDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLverifyLossDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLverifyLossDto.setLossItemName(dbManager.getString(resultSet,6));
            prpLverifyLossDto.setInsureCarFlag(dbManager.getString(resultSet,7));
            prpLverifyLossDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLverifyLossDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLverifyLossDto.setLicenseColorcode(dbManager.getString(resultSet,10));
            prpLverifyLossDto.setCarKindCode(dbManager.getString(resultSet,11));
            prpLverifyLossDto.setCurrency(dbManager.getString(resultSet,12));
            prpLverifyLossDto.setSumPreDefLoss(dbManager.getDouble(resultSet,13));
            prpLverifyLossDto.setSumDefLoss(dbManager.getDouble(resultSet,14));
            prpLverifyLossDto.setMakeCom(dbManager.getString(resultSet,15));
            prpLverifyLossDto.setComCode(dbManager.getString(resultSet,16));
            prpLverifyLossDto.setHandlerCode(dbManager.getString(resultSet,17));
            prpLverifyLossDto.setHandlerName(dbManager.getString(resultSet,18));
            prpLverifyLossDto.setDefLossDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLverifyLossDto.setUnderWriteCode(dbManager.getString(resultSet,20));
            prpLverifyLossDto.setUnderWriteName(dbManager.getString(resultSet,21));
            prpLverifyLossDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLverifyLossDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLverifyLossDto.setRemark(dbManager.getString(resultSet,24));
            prpLverifyLossDto.setVerifyRemark(dbManager.getString(resultSet,25));
            prpLverifyLossDto.setFlag(dbManager.getString(resultSet,26));
            prpLverifyLossDto.setBackCheckRemark(dbManager.getString(resultSet,27));
            prpLverifyLossDto.setVeriwReturnReason(dbManager.getString(resultSet,28));
            prpLverifyLossDto.setVerifyOpinion(dbManager.getString(resultSet,29));
            prpLverifyLossDto.setFirstDefLoss(dbManager.getDouble(resultSet,30));
            prpLverifyLossDto.setWarpDefLoss(dbManager.getDouble(resultSet,31));
            prpLverifyLossDto.setVerpApproverCode(dbManager.getString(resultSet,32));
            prpLverifyLossDto.setVerpDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            prpLverifyLossDto.setVerpOpinion(dbManager.getString(resultSet,34));
            prpLverifyLossDto.setVerpRemark(dbManager.getString(resultSet,35));
            prpLverifyLossDto.setCompensateFlag(dbManager.getString(resultSet,36));
            prpLverifyLossDto.setCompensateOpinion(dbManager.getString(resultSet,37));
            prpLverifyLossDto.setCompensateBackDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,38));
            prpLverifyLossDto.setLossesNumber(dbManager.getDouble(resultSet,39));
            prpLverifyLossDto.setLossesUnitCode(dbManager.getString(resultSet,40));
            prpLverifyLossDto.setDamageInsured(dbManager.getDouble(resultSet,41));
            prpLverifyLossDto.setDisasterArea(dbManager.getDouble(resultSet,42));
            prpLverifyLossDto.setDisasterUnit(dbManager.getString(resultSet,43));
            prpLverifyLossDto.setAffectedArea(dbManager.getDouble(resultSet,44));
            prpLverifyLossDto.setAffectedUnit(dbManager.getString(resultSet,45));
            prpLverifyLossDto.setNoProductionArea(dbManager.getDouble(resultSet,46));
            prpLverifyLossDto.setNoProductionUnit(dbManager.getString(resultSet,47));
            prpLverifyLossDto.setDeathQuantity(dbManager.getDouble(resultSet,48));
            prpLverifyLossDto.setDeathUnit(dbManager.getString(resultSet,49));
            prpLverifyLossDto.setKillQuantity(dbManager.getDouble(resultSet,50));
            prpLverifyLossDto.setKillUnit(dbManager.getString(resultSet,51));
            prpLverifyLossDto.setBusinessType(dbManager.getString(resultSet,52));
            prpLverifyLossDto.setBusinessType1(dbManager.getString(resultSet,53));

            prpLverifyLossDto.setCompensateApproverCode(dbManager.getString(resultSet,54));
            collection.add(prpLverifyLossDto);
        }
        resultSet.close();
        logger.info("DBPrpLverifyLossBase.findByConditions() success!");
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
        String statement = "Delete From PrpLverifyLoss Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLverifyLossBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLverifyLoss Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLverifyLossBase.getCount() success!");
        return count;
    }
}
