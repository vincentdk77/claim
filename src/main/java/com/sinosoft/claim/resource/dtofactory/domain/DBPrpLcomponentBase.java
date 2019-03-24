package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcomponent－换件项目清单的数据访问对象基类<br>
 * 创建于 2006-04-24 19:02:09.421<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcomponentBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcomponentBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcomponentBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void insert(PrpLcomponentDto prpLcomponentDto) throws Exception{
        String mainStatement = " Insert Into PrpLcomponent (" + 
                           " RiskCode," + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LossItemCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " MakeYear," + 
                           " GearboxType," + 
                           " QuoteCompanyGrade," + 
                           " ManageFeeRate," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " PartDesc," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " QueryPrice," + 
                           " QuotedPrice," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " VeriQuantity," + 
                           " VeriManHourFee," + 
                           " VeriMaterFee," + 
                           " VeriLossRate," + 
                           " SumVeriLoss," + 
                           " VeriRemark," + 
                           " VeriRestFee," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " RestFee," + 
                           " BackCheckRemark," + 
                           " PartCode," + 
                           " PartName," + 
                           " OriginalId," + 
                           " Sys4SPrice," + 
                           " SysMarketPrice," + 
                           " SysMatchPrice," + 
                           " Native4SPrice," + 
                           " NativeMarketPrice," + 
                           " NativeMatchPrice," + 
                           " VerpCompPrice," + 
                           " IndId," + 
                           " FirstMaterialFee," + 
                           " VerpoFlag," + 
                           " CompensateBackFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcomponentDto.getRiskCode() + "'," + 
                           "'" + prpLcomponentDto.getClaimNo() + "'," + 
                           "'" + prpLcomponentDto.getRegistNo() + "'," + 
                           "'" + prpLcomponentDto.getPolicyNo() + "'," + 
                           "" + prpLcomponentDto.getSerialNo() + "," + 
                           "" + prpLcomponentDto.getItemKindNo() + "," + 
                           "'" + prpLcomponentDto.getKindCode() + "'," + 
                           "'" + prpLcomponentDto.getLossItemCode() + "'," + 
                           "'" + prpLcomponentDto.getLicenseNo() + "'," + 
                           "'" + prpLcomponentDto.getLicenseColorCode() + "'," + 
                           "'" + prpLcomponentDto.getCarKindCode() + "'," + 
                           "'" + prpLcomponentDto.getMakeYear() + "'," + 
                           "'" + prpLcomponentDto.getGearboxType() + "'," + 
                           "'" + prpLcomponentDto.getQuoteCompanyGrade() + "'," + 
                           "'" + prpLcomponentDto.getManageFeeRate() + "'," + 
                           "'" + prpLcomponentDto.getRepairFactoryCode() + "'," + 
                           "'" + prpLcomponentDto.getRepairFactoryName() + "'," + 
                           "'" + prpLcomponentDto.getHandlerCode() + "'," + 
                           "'" + prpLcomponentDto.getRepairStartDate() + "'," + 
                           "'" + prpLcomponentDto.getRepairEndDate() + "'," + 
                           "'" + prpLcomponentDto.getPartDesc() + "'," + 
                           "'" + prpLcomponentDto.getSanctioner() + "'," + 
                           "'" + prpLcomponentDto.getApproverCode() + "'," + 
                           "'" + prpLcomponentDto.getOperatorCode() + "'," + 
                           "'" + prpLcomponentDto.getCompCode() + "'," + 
                           "'" + prpLcomponentDto.getCompName() + "'," + 
                           "" + prpLcomponentDto.getQuantity() + "," + 
                           "'" + prpLcomponentDto.getManHourFee() + "'," + 
                           "'" + prpLcomponentDto.getMaterialFee() + "'," + 
                           "'" + prpLcomponentDto.getQueryPrice() + "'," + 
                           "'" + prpLcomponentDto.getQuotedPrice() + "'," + 
                           "'" + prpLcomponentDto.getLossRate() + "'," + 
                           "'" + prpLcomponentDto.getCurrency() + "'," + 
                           "'" + prpLcomponentDto.getSumDefLoss() + "'," + 
                           "'" + prpLcomponentDto.getRemark() + "'," + 
                           "'" + prpLcomponentDto.getFlag() + "'," + 
                           "'" + prpLcomponentDto.getManHour() + "'," + 
                           "'" + prpLcomponentDto.getManHourUnitPrice() + "'," + 
                           "'" + prpLcomponentDto.getMaterialQuantity() + "'," + 
                           "'" + prpLcomponentDto.getMaterialUnitPrice() + "'," + 
                           "'" + prpLcomponentDto.getSumCheckLoss() + "'," + 
                           "" + prpLcomponentDto.getVeriQuantity() + "," + 
                           "'" + prpLcomponentDto.getVeriManHourFee() + "'," + 
                           "'" + prpLcomponentDto.getVeriMaterFee() + "'," + 
                           "'" + prpLcomponentDto.getVeriLossRate() + "'," + 
                           "'" + prpLcomponentDto.getSumVeriLoss() + "'," + 
                           "'" + prpLcomponentDto.getVeriRemark() + "'," + 
                           "'" + prpLcomponentDto.getVeriRestFee() + "'," + 
                           "'" + prpLcomponentDto.getSumReject() + "'," + 
                           "'" + prpLcomponentDto.getRejectReason() + "'," + 
                           "'" + prpLcomponentDto.getRestFee() + "'," + 
                           "'" + prpLcomponentDto.getBackCheckRemark() + "'," + 
                           "'" + prpLcomponentDto.getPartCode() + "'," + 
                           "'" + prpLcomponentDto.getPartName() + "'," + 
                           "'" + prpLcomponentDto.getOriginalId() + "'," + 
                           "'" + prpLcomponentDto.getSys4SPrice() + "'," + 
                           "'" + prpLcomponentDto.getSysMarketPrice() + "'," + 
                           "'" + prpLcomponentDto.getSysMatchPrice() + "'," + 
                           "'" + prpLcomponentDto.getNative4SPrice() + "'," + 
                           "'" + prpLcomponentDto.getNativeMarketPrice() + "'," + 
                           "'" + prpLcomponentDto.getNativeMatchPrice() + "'," + 
                           "'" + prpLcomponentDto.getVerpCompPrice() + "'," + 
                           "" + prpLcomponentDto.getIndId() + "," + 
                           "'" + prpLcomponentDto.getFirstMaterialFee() + "'," + 
                           "'" + prpLcomponentDto.getVerpoFlag() + "'," + 
                           "'" + prpLcomponentDto.getCompensateBackFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcomponentDto.getRiskCode());
        dbManager.setString(2,prpLcomponentDto.getClaimNo());
        dbManager.setString(3,prpLcomponentDto.getRegistNo());
        dbManager.setString(4,prpLcomponentDto.getPolicyNo());
        dbManager.setInt(5,prpLcomponentDto.getSerialNo());
        dbManager.setInt(6,prpLcomponentDto.getItemKindNo());
        dbManager.setString(7,prpLcomponentDto.getKindCode());
        dbManager.setString(8,prpLcomponentDto.getLossItemCode());
        dbManager.setString(9,prpLcomponentDto.getLicenseNo());
        dbManager.setString(10,prpLcomponentDto.getLicenseColorCode());
        dbManager.setString(11,prpLcomponentDto.getCarKindCode());
        dbManager.setString(12,prpLcomponentDto.getMakeYear());
        dbManager.setString(13,prpLcomponentDto.getGearboxType());
        dbManager.setString(14,prpLcomponentDto.getQuoteCompanyGrade());
        dbManager.setDouble(15,prpLcomponentDto.getManageFeeRate());
        dbManager.setString(16,prpLcomponentDto.getRepairFactoryCode());
        dbManager.setString(17,prpLcomponentDto.getRepairFactoryName());
        dbManager.setString(18,prpLcomponentDto.getHandlerCode());
        dbManager.setDateTime(19,prpLcomponentDto.getRepairStartDate());
        dbManager.setDateTime(20,prpLcomponentDto.getRepairEndDate());
        dbManager.setString(21,prpLcomponentDto.getPartDesc());
        dbManager.setString(22,prpLcomponentDto.getSanctioner());
        dbManager.setString(23,prpLcomponentDto.getApproverCode());
        dbManager.setString(24,prpLcomponentDto.getOperatorCode());
        dbManager.setString(25,prpLcomponentDto.getCompCode());
        dbManager.setString(26,prpLcomponentDto.getCompName());
        dbManager.setInt(27,prpLcomponentDto.getQuantity());
        dbManager.setDouble(28,prpLcomponentDto.getManHourFee());
        dbManager.setDouble(29,prpLcomponentDto.getMaterialFee());
        dbManager.setDouble(30,prpLcomponentDto.getQueryPrice());
        dbManager.setDouble(31,prpLcomponentDto.getQuotedPrice());
        dbManager.setDouble(32,prpLcomponentDto.getLossRate());
        dbManager.setString(33,prpLcomponentDto.getCurrency());
        dbManager.setDouble(34,prpLcomponentDto.getSumDefLoss());
        dbManager.setString(35,prpLcomponentDto.getRemark());
        dbManager.setString(36,prpLcomponentDto.getFlag());
        dbManager.setDouble(37,prpLcomponentDto.getManHour());
        dbManager.setDouble(38,prpLcomponentDto.getManHourUnitPrice());
        dbManager.setDouble(39,prpLcomponentDto.getMaterialQuantity());
        dbManager.setDouble(40,prpLcomponentDto.getMaterialUnitPrice());
        dbManager.setDouble(41,prpLcomponentDto.getSumCheckLoss());
        dbManager.setInt(42,prpLcomponentDto.getVeriQuantity());
        dbManager.setDouble(43,prpLcomponentDto.getVeriManHourFee());
        dbManager.setDouble(44,prpLcomponentDto.getVeriMaterFee());
        dbManager.setDouble(45,prpLcomponentDto.getVeriLossRate());
        dbManager.setDouble(46,prpLcomponentDto.getSumVeriLoss());
        dbManager.setString(47,prpLcomponentDto.getVeriRemark());
        dbManager.setDouble(48,prpLcomponentDto.getVeriRestFee());
        dbManager.setDouble(49,prpLcomponentDto.getSumReject());
        dbManager.setString(50,prpLcomponentDto.getRejectReason());
        dbManager.setDouble(51,prpLcomponentDto.getRestFee());
        dbManager.setString(52,prpLcomponentDto.getBackCheckRemark());
        dbManager.setString(53,prpLcomponentDto.getPartCode());
        dbManager.setString(54,prpLcomponentDto.getPartName());
        dbManager.setString(55,prpLcomponentDto.getOriginalId());
        dbManager.setDouble(56,prpLcomponentDto.getSys4SPrice());
        dbManager.setDouble(57,prpLcomponentDto.getSysMarketPrice());
        dbManager.setDouble(58,prpLcomponentDto.getSysMatchPrice());
        dbManager.setDouble(59,prpLcomponentDto.getNative4SPrice());
        dbManager.setDouble(60,prpLcomponentDto.getNativeMarketPrice());
        dbManager.setDouble(61,prpLcomponentDto.getNativeMatchPrice());
        dbManager.setDouble(62,prpLcomponentDto.getVerpCompPrice());
        dbManager.setInt(63,prpLcomponentDto.getIndId());
        dbManager.setDouble(64,prpLcomponentDto.getFirstMaterialFee());
        dbManager.setString(65,prpLcomponentDto.getVerpoFlag());
        dbManager.setString(66,prpLcomponentDto.getCompensateBackFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcomponentBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto)i.next();
            insert(prpLcomponentDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String lossItemCode) throws Exception{
        String statement = " Delete From PrpLcomponent" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcomponent Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcomponentBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void update(PrpLcomponentDto prpLcomponentDto) throws Exception{
        String statement = " Update PrpLcomponent Set RiskCode = ?," + 
                           " ClaimNo = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " CarKindCode = ?," + 
                           " MakeYear = ?," + 
                           " GearboxType = ?," + 
                           " QuoteCompanyGrade = ?," + 
                           " ManageFeeRate = ?," + 
                           " RepairFactoryCode = ?," + 
                           " RepairFactoryName = ?," + 
                           " HandlerCode = ?," + 
                           " RepairStartDate = ?," + 
                           " RepairEndDate = ?," + 
                           " PartDesc = ?," + 
                           " Sanctioner = ?," + 
                           " ApproverCode = ?," + 
                           " OperatorCode = ?," + 
                           " CompCode = ?," + 
                           " CompName = ?," + 
                           " Quantity = ?," + 
                           " ManHourFee = ?," + 
                           " MaterialFee = ?," + 
                           " QueryPrice = ?," + 
                           " QuotedPrice = ?," + 
                           " LossRate = ?," + 
                           " Currency = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " ManHour = ?," + 
                           " ManHourUnitPrice = ?," + 
                           " MaterialQuantity = ?," + 
                           " MaterialUnitPrice = ?," + 
                           " SumCheckLoss = ?," + 
                           " VeriQuantity = ?," + 
                           " VeriManHourFee = ?," + 
                           " VeriMaterFee = ?," + 
                           " VeriLossRate = ?," + 
                           " SumVeriLoss = ?," + 
                           " VeriRemark = ?," + 
                           " VeriRestFee = ?," + 
                           " SumReject = ?," + 
                           " RejectReason = ?," + 
                           " RestFee = ?," + 
                           " BackCheckRemark = ?," + 
                           " PartCode = ?," + 
                           " PartName = ?," + 
                           " OriginalId = ?," + 
                           " Sys4SPrice = ?," + 
                           " SysMarketPrice = ?," + 
                           " SysMatchPrice = ?," + 
                           " Native4SPrice = ?," + 
                           " NativeMarketPrice = ?," + 
                           " NativeMatchPrice = ?," + 
                           " VerpCompPrice = ?," + 
                           " IndId = ?," + 
                           " FirstMaterialFee = ?," + 
                           " VerpoFlag = ?," + 
                           " CompensateBackFlag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcomponent Set " + 
                           " RiskCode = '" + prpLcomponentDto.getRiskCode() + "'," + 
                           " ClaimNo = '" + prpLcomponentDto.getClaimNo() + "'," + 
                           " RegistNo = '" + prpLcomponentDto.getRegistNo() + "'," + 
                           " PolicyNo = '" + prpLcomponentDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLcomponentDto.getSerialNo() + "," + 
                           " ItemKindNo = " + prpLcomponentDto.getItemKindNo() + "," + 
                           " KindCode = '" + prpLcomponentDto.getKindCode() + "'," + 
                           " LossItemCode = '" + prpLcomponentDto.getLossItemCode() + "'," + 
                           " LicenseNo = '" + prpLcomponentDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLcomponentDto.getLicenseColorCode() + "'," + 
                           " CarKindCode = '" + prpLcomponentDto.getCarKindCode() + "'," + 
                           " MakeYear = '" + prpLcomponentDto.getMakeYear() + "'," + 
                           " GearboxType = '" + prpLcomponentDto.getGearboxType() + "'," + 
                           " QuoteCompanyGrade = '" + prpLcomponentDto.getQuoteCompanyGrade() + "'," + 
                           " ManageFeeRate = '" + prpLcomponentDto.getManageFeeRate() + "'," + 
                           " RepairFactoryCode = '" + prpLcomponentDto.getRepairFactoryCode() + "'," + 
                           " RepairFactoryName = '" + prpLcomponentDto.getRepairFactoryName() + "'," + 
                           " HandlerCode = '" + prpLcomponentDto.getHandlerCode() + "'," + 
                           " RepairStartDate = '" + prpLcomponentDto.getRepairStartDate() + "'," + 
                           " RepairEndDate = '" + prpLcomponentDto.getRepairEndDate() + "'," + 
                           " PartDesc = '" + prpLcomponentDto.getPartDesc() + "'," + 
                           " Sanctioner = '" + prpLcomponentDto.getSanctioner() + "'," + 
                           " ApproverCode = '" + prpLcomponentDto.getApproverCode() + "'," + 
                           " OperatorCode = '" + prpLcomponentDto.getOperatorCode() + "'," + 
                           " CompCode = '" + prpLcomponentDto.getCompCode() + "'," + 
                           " CompName = '" + prpLcomponentDto.getCompName() + "'," + 
                           " Quantity = " + prpLcomponentDto.getQuantity() + "," + 
                           " ManHourFee = '" + prpLcomponentDto.getManHourFee() + "'," + 
                           " MaterialFee = '" + prpLcomponentDto.getMaterialFee() + "'," + 
                           " QueryPrice = '" + prpLcomponentDto.getQueryPrice() + "'," + 
                           " QuotedPrice = '" + prpLcomponentDto.getQuotedPrice() + "'," + 
                           " LossRate = '" + prpLcomponentDto.getLossRate() + "'," + 
                           " Currency = '" + prpLcomponentDto.getCurrency() + "'," + 
                           " SumDefLoss = '" + prpLcomponentDto.getSumDefLoss() + "'," + 
                           " Remark = '" + prpLcomponentDto.getRemark() + "'," + 
                           " Flag = '" + prpLcomponentDto.getFlag() + "'," + 
                           " ManHour = '" + prpLcomponentDto.getManHour() + "'," + 
                           " ManHourUnitPrice = '" + prpLcomponentDto.getManHourUnitPrice() + "'," + 
                           " MaterialQuantity = '" + prpLcomponentDto.getMaterialQuantity() + "'," + 
                           " MaterialUnitPrice = '" + prpLcomponentDto.getMaterialUnitPrice() + "'," + 
                           " SumCheckLoss = '" + prpLcomponentDto.getSumCheckLoss() + "'," + 
                           " VeriQuantity = " + prpLcomponentDto.getVeriQuantity() + "," + 
                           " VeriManHourFee = '" + prpLcomponentDto.getVeriManHourFee() + "'," + 
                           " VeriMaterFee = '" + prpLcomponentDto.getVeriMaterFee() + "'," + 
                           " VeriLossRate = '" + prpLcomponentDto.getVeriLossRate() + "'," + 
                           " SumVeriLoss = '" + prpLcomponentDto.getSumVeriLoss() + "'," + 
                           " VeriRemark = '" + prpLcomponentDto.getVeriRemark() + "'," + 
                           " VeriRestFee = '" + prpLcomponentDto.getVeriRestFee() + "'," + 
                           " SumReject = '" + prpLcomponentDto.getSumReject() + "'," + 
                           " RejectReason = '" + prpLcomponentDto.getRejectReason() + "'," + 
                           " RestFee = '" + prpLcomponentDto.getRestFee() + "'," + 
                           " BackCheckRemark = '" + prpLcomponentDto.getBackCheckRemark() + "'," + 
                           " PartCode = '" + prpLcomponentDto.getPartCode() + "'," + 
                           " PartName = '" + prpLcomponentDto.getPartName() + "'," + 
                           " OriginalId = '" + prpLcomponentDto.getOriginalId() + "'," + 
                           " Sys4SPrice = '" + prpLcomponentDto.getSys4SPrice() + "'," + 
                           " SysMarketPrice = '" + prpLcomponentDto.getSysMarketPrice() + "'," + 
                           " SysMatchPrice = '" + prpLcomponentDto.getSysMatchPrice() + "'," + 
                           " Native4SPrice = '" + prpLcomponentDto.getNative4SPrice() + "'," + 
                           " NativeMarketPrice = '" + prpLcomponentDto.getNativeMarketPrice() + "'," + 
                           " NativeMatchPrice = '" + prpLcomponentDto.getNativeMatchPrice() + "'," + 
                           " VerpCompPrice = '" + prpLcomponentDto.getVerpCompPrice() + "'," + 
                           " IndId = " + prpLcomponentDto.getIndId() + "," + 
                           " FirstMaterialFee = '" + prpLcomponentDto.getFirstMaterialFee() + "'," + 
                           " VerpoFlag = '" + prpLcomponentDto.getVerpoFlag() + "'," + 
                           " CompensateBackFlag = '" + prpLcomponentDto.getCompensateBackFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLcomponentDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLcomponentDto.getSerialNo() + " And " + 
                           " LossItemCode = '" + prpLcomponentDto.getLossItemCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcomponentDto.getRiskCode());
        dbManager.setString(2,prpLcomponentDto.getClaimNo());
        dbManager.setString(3,prpLcomponentDto.getPolicyNo());
        dbManager.setInt(4,prpLcomponentDto.getItemKindNo());
        dbManager.setString(5,prpLcomponentDto.getKindCode());
        dbManager.setString(6,prpLcomponentDto.getLicenseNo());
        dbManager.setString(7,prpLcomponentDto.getLicenseColorCode());
        dbManager.setString(8,prpLcomponentDto.getCarKindCode());
        dbManager.setString(9,prpLcomponentDto.getMakeYear());
        dbManager.setString(10,prpLcomponentDto.getGearboxType());
        dbManager.setString(11,prpLcomponentDto.getQuoteCompanyGrade());
        dbManager.setDouble(12,prpLcomponentDto.getManageFeeRate());
        dbManager.setString(13,prpLcomponentDto.getRepairFactoryCode());
        dbManager.setString(14,prpLcomponentDto.getRepairFactoryName());
        dbManager.setString(15,prpLcomponentDto.getHandlerCode());
        dbManager.setDateTime(16,prpLcomponentDto.getRepairStartDate());
        dbManager.setDateTime(17,prpLcomponentDto.getRepairEndDate());
        dbManager.setString(18,prpLcomponentDto.getPartDesc());
        dbManager.setString(19,prpLcomponentDto.getSanctioner());
        dbManager.setString(20,prpLcomponentDto.getApproverCode());
        dbManager.setString(21,prpLcomponentDto.getOperatorCode());
        dbManager.setString(22,prpLcomponentDto.getCompCode());
        dbManager.setString(23,prpLcomponentDto.getCompName());
        dbManager.setInt(24,prpLcomponentDto.getQuantity());
        dbManager.setDouble(25,prpLcomponentDto.getManHourFee());
        dbManager.setDouble(26,prpLcomponentDto.getMaterialFee());
        dbManager.setDouble(27,prpLcomponentDto.getQueryPrice());
        dbManager.setDouble(28,prpLcomponentDto.getQuotedPrice());
        dbManager.setDouble(29,prpLcomponentDto.getLossRate());
        dbManager.setString(30,prpLcomponentDto.getCurrency());
        dbManager.setDouble(31,prpLcomponentDto.getSumDefLoss());
        dbManager.setString(32,prpLcomponentDto.getRemark());
        dbManager.setString(33,prpLcomponentDto.getFlag());
        dbManager.setDouble(34,prpLcomponentDto.getManHour());
        dbManager.setDouble(35,prpLcomponentDto.getManHourUnitPrice());
        dbManager.setDouble(36,prpLcomponentDto.getMaterialQuantity());
        dbManager.setDouble(37,prpLcomponentDto.getMaterialUnitPrice());
        dbManager.setDouble(38,prpLcomponentDto.getSumCheckLoss());
        dbManager.setInt(39,prpLcomponentDto.getVeriQuantity());
        dbManager.setDouble(40,prpLcomponentDto.getVeriManHourFee());
        dbManager.setDouble(41,prpLcomponentDto.getVeriMaterFee());
        dbManager.setDouble(42,prpLcomponentDto.getVeriLossRate());
        dbManager.setDouble(43,prpLcomponentDto.getSumVeriLoss());
        dbManager.setString(44,prpLcomponentDto.getVeriRemark());
        dbManager.setDouble(45,prpLcomponentDto.getVeriRestFee());
        dbManager.setDouble(46,prpLcomponentDto.getSumReject());
        dbManager.setString(47,prpLcomponentDto.getRejectReason());
        dbManager.setDouble(48,prpLcomponentDto.getRestFee());
        dbManager.setString(49,prpLcomponentDto.getBackCheckRemark());
        dbManager.setString(50,prpLcomponentDto.getPartCode());
        dbManager.setString(51,prpLcomponentDto.getPartName());
        dbManager.setString(52,prpLcomponentDto.getOriginalId());
        dbManager.setDouble(53,prpLcomponentDto.getSys4SPrice());
        dbManager.setDouble(54,prpLcomponentDto.getSysMarketPrice());
        dbManager.setDouble(55,prpLcomponentDto.getSysMatchPrice());
        dbManager.setDouble(56,prpLcomponentDto.getNative4SPrice());
        dbManager.setDouble(57,prpLcomponentDto.getNativeMarketPrice());
        dbManager.setDouble(58,prpLcomponentDto.getNativeMatchPrice());
        dbManager.setDouble(59,prpLcomponentDto.getVerpCompPrice());
        dbManager.setInt(60,prpLcomponentDto.getIndId());
        dbManager.setDouble(61,prpLcomponentDto.getFirstMaterialFee());
        dbManager.setString(62,prpLcomponentDto.getVerpoFlag());
        dbManager.setString(63,prpLcomponentDto.getCompensateBackFlag());
        //设置条件字段;
        dbManager.setString(64,prpLcomponentDto.getRegistNo());
        dbManager.setInt(65,prpLcomponentDto.getSerialNo());
        dbManager.setString(66,prpLcomponentDto.getLossItemCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcomponentBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return PrpLcomponentDto
     * @throws Exception
     */
    public PrpLcomponentDto findByPrimaryKey(String registNo,int serialNo,String lossItemCode) throws Exception{
        String mainStatement = " Select RiskCode," + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LossItemCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " MakeYear," + 
                           " GearboxType," + 
                           " QuoteCompanyGrade," + 
                           " ManageFeeRate," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " PartDesc," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " QueryPrice," + 
                           " QuotedPrice," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " VeriQuantity," + 
                           " VeriManHourFee," + 
                           " VeriMaterFee," + 
                           " VeriLossRate," + 
                           " SumVeriLoss," + 
                           " VeriRemark," + 
                           " VeriRestFee," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " RestFee," + 
                           " BackCheckRemark," + 
                           " PartCode," + 
                           " PartName," + 
                           " OriginalId," + 
                           " Sys4SPrice," + 
                           " SysMarketPrice," + 
                           " SysMatchPrice," + 
                           " Native4SPrice," + 
                           " NativeMarketPrice," + 
                           " NativeMatchPrice," + 
                           " VerpCompPrice," + 
                           " IndId," + 
                           " FirstMaterialFee," + 
                           " VerpoFlag," + 
                           " CompensateBackFlag From PrpLcomponent";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        PrpLcomponentDto prpLcomponentDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcomponentDto = new PrpLcomponentDto();
            prpLcomponentDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLcomponentDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcomponentDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcomponentDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcomponentDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcomponentDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLcomponentDto.setKindCode(dbManager.getString(resultSet,7));
            prpLcomponentDto.setLossItemCode(dbManager.getString(resultSet,8));
            prpLcomponentDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLcomponentDto.setLicenseColorCode(dbManager.getString(resultSet,10));
            prpLcomponentDto.setCarKindCode(dbManager.getString(resultSet,11));
            prpLcomponentDto.setMakeYear(dbManager.getString(resultSet,12));
            prpLcomponentDto.setGearboxType(dbManager.getString(resultSet,13));
            prpLcomponentDto.setQuoteCompanyGrade(dbManager.getString(resultSet,14));
            prpLcomponentDto.setManageFeeRate(dbManager.getDouble(resultSet,15));
            prpLcomponentDto.setRepairFactoryCode(dbManager.getString(resultSet,16));
            prpLcomponentDto.setRepairFactoryName(dbManager.getString(resultSet,17));
            prpLcomponentDto.setHandlerCode(dbManager.getString(resultSet,18));
            prpLcomponentDto.setRepairStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLcomponentDto.setRepairEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLcomponentDto.setPartDesc(dbManager.getString(resultSet,21));
            prpLcomponentDto.setSanctioner(dbManager.getString(resultSet,22));
            prpLcomponentDto.setApproverCode(dbManager.getString(resultSet,23));
            prpLcomponentDto.setOperatorCode(dbManager.getString(resultSet,24));
            prpLcomponentDto.setCompCode(dbManager.getString(resultSet,25));
            prpLcomponentDto.setCompName(dbManager.getString(resultSet,26));
            prpLcomponentDto.setQuantity(dbManager.getInt(resultSet,27));
            prpLcomponentDto.setManHourFee(dbManager.getDouble(resultSet,28));
            prpLcomponentDto.setMaterialFee(dbManager.getDouble(resultSet,29));
            prpLcomponentDto.setQueryPrice(dbManager.getDouble(resultSet,30));
            prpLcomponentDto.setQuotedPrice(dbManager.getDouble(resultSet,31));
            prpLcomponentDto.setLossRate(dbManager.getDouble(resultSet,32));
            prpLcomponentDto.setCurrency(dbManager.getString(resultSet,33));
            prpLcomponentDto.setSumDefLoss(dbManager.getDouble(resultSet,34));
            prpLcomponentDto.setRemark(dbManager.getString(resultSet,35));
            prpLcomponentDto.setFlag(dbManager.getString(resultSet,36));
            prpLcomponentDto.setManHour(dbManager.getDouble(resultSet,37));
            prpLcomponentDto.setManHourUnitPrice(dbManager.getDouble(resultSet,38));
            prpLcomponentDto.setMaterialQuantity(dbManager.getDouble(resultSet,39));
            prpLcomponentDto.setMaterialUnitPrice(dbManager.getDouble(resultSet,40));
            prpLcomponentDto.setSumCheckLoss(dbManager.getDouble(resultSet,41));
            prpLcomponentDto.setVeriQuantity(dbManager.getInt(resultSet,42));
            prpLcomponentDto.setVeriManHourFee(dbManager.getDouble(resultSet,43));
            prpLcomponentDto.setVeriMaterFee(dbManager.getDouble(resultSet,44));
            prpLcomponentDto.setVeriLossRate(dbManager.getDouble(resultSet,45));
            prpLcomponentDto.setSumVeriLoss(dbManager.getDouble(resultSet,46));
            prpLcomponentDto.setVeriRemark(dbManager.getString(resultSet,47));
            prpLcomponentDto.setVeriRestFee(dbManager.getDouble(resultSet,48));
            prpLcomponentDto.setSumReject(dbManager.getDouble(resultSet,49));
            prpLcomponentDto.setRejectReason(dbManager.getString(resultSet,50));
            prpLcomponentDto.setRestFee(dbManager.getDouble(resultSet,51));
            prpLcomponentDto.setBackCheckRemark(dbManager.getString(resultSet,52));
            prpLcomponentDto.setPartCode(dbManager.getString(resultSet,53));
            prpLcomponentDto.setPartName(dbManager.getString(resultSet,54));
            prpLcomponentDto.setOriginalId(dbManager.getString(resultSet,55));
            prpLcomponentDto.setSys4SPrice(dbManager.getDouble(resultSet,56));
            prpLcomponentDto.setSysMarketPrice(dbManager.getDouble(resultSet,57));
            prpLcomponentDto.setSysMatchPrice(dbManager.getDouble(resultSet,58));
            prpLcomponentDto.setNative4SPrice(dbManager.getDouble(resultSet,59));
            prpLcomponentDto.setNativeMarketPrice(dbManager.getDouble(resultSet,60));
            prpLcomponentDto.setNativeMatchPrice(dbManager.getDouble(resultSet,61));
            prpLcomponentDto.setVerpCompPrice(dbManager.getDouble(resultSet,62));
            prpLcomponentDto.setIndId(dbManager.getInt(resultSet,63));
            prpLcomponentDto.setFirstMaterialFee(dbManager.getDouble(resultSet,64));
            prpLcomponentDto.setVerpoFlag(dbManager.getString(resultSet,65));
            prpLcomponentDto.setCompensateBackFlag(dbManager.getString(resultSet,66));
        }
        resultSet.close();
        logger.info("DBPrpLcomponentBase.findByPrimaryKey() success!");
        return prpLcomponentDto;
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
        String statement = "Select RiskCode," + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LossItemCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " MakeYear," + 
                           " GearboxType," + 
                           " QuoteCompanyGrade," + 
                           " ManageFeeRate," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " PartDesc," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " QueryPrice," + 
                           " QuotedPrice," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " VeriQuantity," + 
                           " VeriManHourFee," + 
                           " VeriMaterFee," + 
                           " VeriLossRate," + 
                           " SumVeriLoss," + 
                           " VeriRemark," + 
                           " VeriRestFee," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " RestFee," + 
                           " BackCheckRemark," + 
                           " PartCode," + 
                           " PartName," + 
                           " OriginalId," + 
                           " Sys4SPrice," + 
                           " SysMarketPrice," + 
                           " SysMatchPrice," + 
                           " Native4SPrice," + 
                           " NativeMarketPrice," + 
                           " NativeMatchPrice," + 
                           " VerpCompPrice," + 
                           " IndId," + 
                           " FirstMaterialFee," + 
                           " VerpoFlag," + 
                           " CompensateBackFlag From PrpLcomponent Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcomponentDto prpLcomponentDto = null;
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

            prpLcomponentDto = new PrpLcomponentDto();
            prpLcomponentDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLcomponentDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcomponentDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcomponentDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcomponentDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcomponentDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLcomponentDto.setKindCode(dbManager.getString(resultSet,7));
            prpLcomponentDto.setLossItemCode(dbManager.getString(resultSet,8));
            prpLcomponentDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLcomponentDto.setLicenseColorCode(dbManager.getString(resultSet,10));
            prpLcomponentDto.setCarKindCode(dbManager.getString(resultSet,11));
            prpLcomponentDto.setMakeYear(dbManager.getString(resultSet,12));
            prpLcomponentDto.setGearboxType(dbManager.getString(resultSet,13));
            prpLcomponentDto.setQuoteCompanyGrade(dbManager.getString(resultSet,14));
            prpLcomponentDto.setManageFeeRate(dbManager.getDouble(resultSet,15));
            prpLcomponentDto.setRepairFactoryCode(dbManager.getString(resultSet,16));
            prpLcomponentDto.setRepairFactoryName(dbManager.getString(resultSet,17));
            prpLcomponentDto.setHandlerCode(dbManager.getString(resultSet,18));
            prpLcomponentDto.setRepairStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLcomponentDto.setRepairEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLcomponentDto.setPartDesc(dbManager.getString(resultSet,21));
            prpLcomponentDto.setSanctioner(dbManager.getString(resultSet,22));
            prpLcomponentDto.setApproverCode(dbManager.getString(resultSet,23));
            prpLcomponentDto.setOperatorCode(dbManager.getString(resultSet,24));
            prpLcomponentDto.setCompCode(dbManager.getString(resultSet,25));
            prpLcomponentDto.setCompName(dbManager.getString(resultSet,26));
            prpLcomponentDto.setQuantity(dbManager.getInt(resultSet,27));
            prpLcomponentDto.setManHourFee(dbManager.getDouble(resultSet,28));
            prpLcomponentDto.setMaterialFee(dbManager.getDouble(resultSet,29));
            prpLcomponentDto.setQueryPrice(dbManager.getDouble(resultSet,30));
            prpLcomponentDto.setQuotedPrice(dbManager.getDouble(resultSet,31));
            prpLcomponentDto.setLossRate(dbManager.getDouble(resultSet,32));
            prpLcomponentDto.setCurrency(dbManager.getString(resultSet,33));
            prpLcomponentDto.setSumDefLoss(dbManager.getDouble(resultSet,34));
            prpLcomponentDto.setRemark(dbManager.getString(resultSet,35));
            prpLcomponentDto.setFlag(dbManager.getString(resultSet,36));
            prpLcomponentDto.setManHour(dbManager.getDouble(resultSet,37));
            prpLcomponentDto.setManHourUnitPrice(dbManager.getDouble(resultSet,38));
            prpLcomponentDto.setMaterialQuantity(dbManager.getDouble(resultSet,39));
            prpLcomponentDto.setMaterialUnitPrice(dbManager.getDouble(resultSet,40));
            prpLcomponentDto.setSumCheckLoss(dbManager.getDouble(resultSet,41));
            prpLcomponentDto.setVeriQuantity(dbManager.getInt(resultSet,42));
            prpLcomponentDto.setVeriManHourFee(dbManager.getDouble(resultSet,43));
            prpLcomponentDto.setVeriMaterFee(dbManager.getDouble(resultSet,44));
            prpLcomponentDto.setVeriLossRate(dbManager.getDouble(resultSet,45));
            prpLcomponentDto.setSumVeriLoss(dbManager.getDouble(resultSet,46));
            prpLcomponentDto.setVeriRemark(dbManager.getString(resultSet,47));
            prpLcomponentDto.setVeriRestFee(dbManager.getDouble(resultSet,48));
            prpLcomponentDto.setSumReject(dbManager.getDouble(resultSet,49));
            prpLcomponentDto.setRejectReason(dbManager.getString(resultSet,50));
            prpLcomponentDto.setRestFee(dbManager.getDouble(resultSet,51));
            prpLcomponentDto.setBackCheckRemark(dbManager.getString(resultSet,52));
            prpLcomponentDto.setPartCode(dbManager.getString(resultSet,53));
            prpLcomponentDto.setPartName(dbManager.getString(resultSet,54));
            prpLcomponentDto.setOriginalId(dbManager.getString(resultSet,55));
            prpLcomponentDto.setSys4SPrice(dbManager.getDouble(resultSet,56));
            prpLcomponentDto.setSysMarketPrice(dbManager.getDouble(resultSet,57));
            prpLcomponentDto.setSysMatchPrice(dbManager.getDouble(resultSet,58));
            prpLcomponentDto.setNative4SPrice(dbManager.getDouble(resultSet,59));
            prpLcomponentDto.setNativeMarketPrice(dbManager.getDouble(resultSet,60));
            prpLcomponentDto.setNativeMatchPrice(dbManager.getDouble(resultSet,61));
            prpLcomponentDto.setVerpCompPrice(dbManager.getDouble(resultSet,62));
            prpLcomponentDto.setIndId(dbManager.getInt(resultSet,63));
            prpLcomponentDto.setFirstMaterialFee(dbManager.getDouble(resultSet,64));
            prpLcomponentDto.setVerpoFlag(dbManager.getString(resultSet,65));
            prpLcomponentDto.setCompensateBackFlag(dbManager.getString(resultSet,66));
            collection.add(prpLcomponentDto);
        }
        resultSet.close();
        logger.info("DBPrpLcomponentBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcomponent Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcomponentBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcomponent Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcomponentBase.getCount() success!");
        return count;
    }
}
