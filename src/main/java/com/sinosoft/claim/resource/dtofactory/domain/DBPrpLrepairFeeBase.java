package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrepairFee－修理费用清单修理费用清单的数据访问对象基类<br>
 * 创建于 2006-04-24 10:56:43.680<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLrepairFeeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLrepairFeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLrepairFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void insert(PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        String mainStatement = " Insert Into PrpLrepairFee (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriManHour," + 
                           " VeriManUnitPrice," + 
                           " VeriManHourFee," + 
                           " VeriMaterQuantity," + 
                           " VeriMaterUnitPrice," + 
                           " VeriMaterialFee," + 
                           " VeriLossRate," + 
                           " VeriSumLoss," + 
                           " VeriRemark," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " BackCheckRemark," + 
                           " LossItemCode," + 
                           " PartCode," + 
                           " PartName," + 
                           " RepairType," + 
                           " FirstSumDefLoss," + 
                           " CompensateBackFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLrepairFeeDto.getClaimNo() + "'," + 
                           "'" + prpLrepairFeeDto.getRiskCode() + "'," + 
                           "'" + prpLrepairFeeDto.getPolicyNo() + "'," + 
                           "" + prpLrepairFeeDto.getSerialNo() + "," + 
                           "'" + prpLrepairFeeDto.getRegistNo() + "'," + 
                           "" + prpLrepairFeeDto.getItemKindNo() + "," + 
                           "'" + prpLrepairFeeDto.getKindCode() + "'," + 
                           "'" + prpLrepairFeeDto.getLicenseNo() + "'," + 
                           "'" + prpLrepairFeeDto.getLicenseColorCode() + "'," + 
                           "'" + prpLrepairFeeDto.getCarKindCode() + "'," + 
                           "'" + prpLrepairFeeDto.getRepairFactoryCode() + "'," + 
                           "'" + prpLrepairFeeDto.getRepairFactoryName() + "'," + 
                           "'" + prpLrepairFeeDto.getHandlerCode() + "'," + 
                           "'" + prpLrepairFeeDto.getRepairStartDate() + "'," + 
                           "'" + prpLrepairFeeDto.getRepairEndDate() + "'," + 
                           "'" + prpLrepairFeeDto.getSanctioner() + "'," + 
                           "'" + prpLrepairFeeDto.getApproverCode() + "'," + 
                           "'" + prpLrepairFeeDto.getOperatorCode() + "'," + 
                           "'" + prpLrepairFeeDto.getCompCode() + "'," + 
                           "'" + prpLrepairFeeDto.getCompName() + "'," + 
                           "'" + prpLrepairFeeDto.getManHour() + "'," + 
                           "'" + prpLrepairFeeDto.getManHourUnitPrice() + "'," + 
                           "'" + prpLrepairFeeDto.getManHourFee() + "'," + 
                           "'" + prpLrepairFeeDto.getMaterialFee() + "'," + 
                           "'" + prpLrepairFeeDto.getLossRate() + "'," + 
                           "'" + prpLrepairFeeDto.getCurrency() + "'," + 
                           "'" + prpLrepairFeeDto.getSumDefLoss() + "'," + 
                           "'" + prpLrepairFeeDto.getRemark() + "'," + 
                           "'" + prpLrepairFeeDto.getFlag() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriManHour() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriManUnitPrice() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriManHourFee() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriMaterQuantity() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriMaterUnitPrice() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriMaterialFee() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriLossRate() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriSumLoss() + "'," + 
                           "'" + prpLrepairFeeDto.getVeriRemark() + "'," + 
                           "'" + prpLrepairFeeDto.getMaterialQuantity() + "'," + 
                           "'" + prpLrepairFeeDto.getMaterialUnitPrice() + "'," + 
                           "'" + prpLrepairFeeDto.getSumCheckLoss() + "'," + 
                           "'" + prpLrepairFeeDto.getBackCheckRemark() + "'," + 
                           "'" + prpLrepairFeeDto.getLossItemCode() + "'," + 
                           "'" + prpLrepairFeeDto.getPartCode() + "'," + 
                           "'" + prpLrepairFeeDto.getPartName() + "'," + 
                           "'" + prpLrepairFeeDto.getRepairType() + "'," + 
                           "'" + prpLrepairFeeDto.getFirstSumDefLoss() + "'," + 
                           "'" + prpLrepairFeeDto.getCompensateBackFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLrepairFeeDto.getClaimNo());
        dbManager.setString(2,prpLrepairFeeDto.getRiskCode());
        dbManager.setString(3,prpLrepairFeeDto.getPolicyNo());
        dbManager.setInt(4,prpLrepairFeeDto.getSerialNo());
        dbManager.setString(5,prpLrepairFeeDto.getRegistNo());
        dbManager.setInt(6,prpLrepairFeeDto.getItemKindNo());
        dbManager.setString(7,prpLrepairFeeDto.getKindCode());
        dbManager.setString(8,prpLrepairFeeDto.getLicenseNo());
        dbManager.setString(9,prpLrepairFeeDto.getLicenseColorCode());
        dbManager.setString(10,prpLrepairFeeDto.getCarKindCode());
        dbManager.setString(11,prpLrepairFeeDto.getRepairFactoryCode());
        dbManager.setString(12,prpLrepairFeeDto.getRepairFactoryName());
        dbManager.setString(13,prpLrepairFeeDto.getHandlerCode());
        dbManager.setDateTime(14,prpLrepairFeeDto.getRepairStartDate());
        dbManager.setDateTime(15,prpLrepairFeeDto.getRepairEndDate());
        dbManager.setString(16,prpLrepairFeeDto.getSanctioner());
        dbManager.setString(17,prpLrepairFeeDto.getApproverCode());
        dbManager.setString(18,prpLrepairFeeDto.getOperatorCode());
        dbManager.setString(19,prpLrepairFeeDto.getCompCode());
        dbManager.setString(20,prpLrepairFeeDto.getCompName());
        dbManager.setDouble(21,prpLrepairFeeDto.getManHour());
        dbManager.setDouble(22,prpLrepairFeeDto.getManHourUnitPrice());
        dbManager.setDouble(23,prpLrepairFeeDto.getManHourFee());
        dbManager.setDouble(24,prpLrepairFeeDto.getMaterialFee());
        dbManager.setDouble(25,prpLrepairFeeDto.getLossRate());
        dbManager.setString(26,prpLrepairFeeDto.getCurrency());
        dbManager.setDouble(27,prpLrepairFeeDto.getSumDefLoss());
        dbManager.setString(28,prpLrepairFeeDto.getRemark());
        dbManager.setString(29,prpLrepairFeeDto.getFlag());
        dbManager.setDouble(30,prpLrepairFeeDto.getVeriManHour());
        dbManager.setDouble(31,prpLrepairFeeDto.getVeriManUnitPrice());
        dbManager.setDouble(32,prpLrepairFeeDto.getVeriManHourFee());
        dbManager.setDouble(33,prpLrepairFeeDto.getVeriMaterQuantity());
        dbManager.setDouble(34,prpLrepairFeeDto.getVeriMaterUnitPrice());
        dbManager.setDouble(35,prpLrepairFeeDto.getVeriMaterialFee());
        dbManager.setDouble(36,prpLrepairFeeDto.getVeriLossRate());
        dbManager.setDouble(37,prpLrepairFeeDto.getVeriSumLoss());
        dbManager.setString(38,prpLrepairFeeDto.getVeriRemark());
        dbManager.setDouble(39,prpLrepairFeeDto.getMaterialQuantity());
        dbManager.setDouble(40,prpLrepairFeeDto.getMaterialUnitPrice());
        dbManager.setDouble(41,prpLrepairFeeDto.getSumCheckLoss());
        dbManager.setString(42,prpLrepairFeeDto.getBackCheckRemark());
        dbManager.setString(43,prpLrepairFeeDto.getLossItemCode());
        dbManager.setString(44,prpLrepairFeeDto.getPartCode());
        dbManager.setString(45,prpLrepairFeeDto.getPartName());
        dbManager.setString(46,prpLrepairFeeDto.getRepairType());
        dbManager.setDouble(47,prpLrepairFeeDto.getFirstSumDefLoss());
        dbManager.setString(48,prpLrepairFeeDto.getCompensateBackFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrepairFeeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto)i.next();
            insert(prpLrepairFeeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(int serialNo,String registNo,String lossItemCode) throws Exception{
        String statement = " Delete From PrpLrepairFee" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLrepairFee Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLrepairFeeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void update(PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        String statement = " Update PrpLrepairFee Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " CarKindCode = ?," + 
                           " RepairFactoryCode = ?," + 
                           " RepairFactoryName = ?," + 
                           " HandlerCode = ?," + 
                           " RepairStartDate = ?," + 
                           " RepairEndDate = ?," + 
                           " Sanctioner = ?," + 
                           " ApproverCode = ?," + 
                           " OperatorCode = ?," + 
                           " CompCode = ?," + 
                           " CompName = ?," + 
                           " ManHour = ?," + 
                           " ManHourUnitPrice = ?," + 
                           " ManHourFee = ?," + 
                           " MaterialFee = ?," + 
                           " LossRate = ?," + 
                           " Currency = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " VeriManHour = ?," + 
                           " VeriManUnitPrice = ?," + 
                           " VeriManHourFee = ?," + 
                           " VeriMaterQuantity = ?," + 
                           " VeriMaterUnitPrice = ?," + 
                           " VeriMaterialFee = ?," + 
                           " VeriLossRate = ?," + 
                           " VeriSumLoss = ?," + 
                           " VeriRemark = ?," + 
                           " MaterialQuantity = ?," + 
                           " MaterialUnitPrice = ?," + 
                           " SumCheckLoss = ?," + 
                           " BackCheckRemark = ?," + 
                           " PartCode = ?," + 
                           " PartName = ?," + 
                           " RepairType = ?," + 
                           " FirstSumDefLoss = ?," + 
                           " CompensateBackFlag = ?" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLrepairFee Set " + 
                           " ClaimNo = '" + prpLrepairFeeDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLrepairFeeDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLrepairFeeDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLrepairFeeDto.getSerialNo() + "," + 
                           " RegistNo = '" + prpLrepairFeeDto.getRegistNo() + "'," + 
                           " ItemKindNo = " + prpLrepairFeeDto.getItemKindNo() + "," + 
                           " KindCode = '" + prpLrepairFeeDto.getKindCode() + "'," + 
                           " LicenseNo = '" + prpLrepairFeeDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLrepairFeeDto.getLicenseColorCode() + "'," + 
                           " CarKindCode = '" + prpLrepairFeeDto.getCarKindCode() + "'," + 
                           " RepairFactoryCode = '" + prpLrepairFeeDto.getRepairFactoryCode() + "'," + 
                           " RepairFactoryName = '" + prpLrepairFeeDto.getRepairFactoryName() + "'," + 
                           " HandlerCode = '" + prpLrepairFeeDto.getHandlerCode() + "'," + 
                           " RepairStartDate = '" + prpLrepairFeeDto.getRepairStartDate() + "'," + 
                           " RepairEndDate = '" + prpLrepairFeeDto.getRepairEndDate() + "'," + 
                           " Sanctioner = '" + prpLrepairFeeDto.getSanctioner() + "'," + 
                           " ApproverCode = '" + prpLrepairFeeDto.getApproverCode() + "'," + 
                           " OperatorCode = '" + prpLrepairFeeDto.getOperatorCode() + "'," + 
                           " CompCode = '" + prpLrepairFeeDto.getCompCode() + "'," + 
                           " CompName = '" + prpLrepairFeeDto.getCompName() + "'," + 
                           " ManHour = '" + prpLrepairFeeDto.getManHour() + "'," + 
                           " ManHourUnitPrice = '" + prpLrepairFeeDto.getManHourUnitPrice() + "'," + 
                           " ManHourFee = '" + prpLrepairFeeDto.getManHourFee() + "'," + 
                           " MaterialFee = '" + prpLrepairFeeDto.getMaterialFee() + "'," + 
                           " LossRate = '" + prpLrepairFeeDto.getLossRate() + "'," + 
                           " Currency = '" + prpLrepairFeeDto.getCurrency() + "'," + 
                           " SumDefLoss = '" + prpLrepairFeeDto.getSumDefLoss() + "'," + 
                           " Remark = '" + prpLrepairFeeDto.getRemark() + "'," + 
                           " Flag = '" + prpLrepairFeeDto.getFlag() + "'," + 
                           " VeriManHour = '" + prpLrepairFeeDto.getVeriManHour() + "'," + 
                           " VeriManUnitPrice = '" + prpLrepairFeeDto.getVeriManUnitPrice() + "'," + 
                           " VeriManHourFee = '" + prpLrepairFeeDto.getVeriManHourFee() + "'," + 
                           " VeriMaterQuantity = '" + prpLrepairFeeDto.getVeriMaterQuantity() + "'," + 
                           " VeriMaterUnitPrice = '" + prpLrepairFeeDto.getVeriMaterUnitPrice() + "'," + 
                           " VeriMaterialFee = '" + prpLrepairFeeDto.getVeriMaterialFee() + "'," + 
                           " VeriLossRate = '" + prpLrepairFeeDto.getVeriLossRate() + "'," + 
                           " VeriSumLoss = '" + prpLrepairFeeDto.getVeriSumLoss() + "'," + 
                           " VeriRemark = '" + prpLrepairFeeDto.getVeriRemark() + "'," + 
                           " MaterialQuantity = '" + prpLrepairFeeDto.getMaterialQuantity() + "'," + 
                           " MaterialUnitPrice = '" + prpLrepairFeeDto.getMaterialUnitPrice() + "'," + 
                           " SumCheckLoss = '" + prpLrepairFeeDto.getSumCheckLoss() + "'," + 
                           " BackCheckRemark = '" + prpLrepairFeeDto.getBackCheckRemark() + "'," + 
                           " LossItemCode = '" + prpLrepairFeeDto.getLossItemCode() + "'," + 
                           " PartCode = '" + prpLrepairFeeDto.getPartCode() + "'," + 
                           " PartName = '" + prpLrepairFeeDto.getPartName() + "'," + 
                           " RepairType = '" + prpLrepairFeeDto.getRepairType() + "'," + 
                           " FirstSumDefLoss = '" + prpLrepairFeeDto.getFirstSumDefLoss() + "'," + 
                           " CompensateBackFlag = '" + prpLrepairFeeDto.getCompensateBackFlag() + "'" + 
			               " Where " +
                           " SerialNo = " + prpLrepairFeeDto.getSerialNo() + " And " + 
                           " RegistNo = '" + prpLrepairFeeDto.getRegistNo() + "' And " + 
                           " LossItemCode = '" + prpLrepairFeeDto.getLossItemCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLrepairFeeDto.getClaimNo());
        dbManager.setString(2,prpLrepairFeeDto.getRiskCode());
        dbManager.setString(3,prpLrepairFeeDto.getPolicyNo());
        dbManager.setInt(4,prpLrepairFeeDto.getItemKindNo());
        dbManager.setString(5,prpLrepairFeeDto.getKindCode());
        dbManager.setString(6,prpLrepairFeeDto.getLicenseNo());
        dbManager.setString(7,prpLrepairFeeDto.getLicenseColorCode());
        dbManager.setString(8,prpLrepairFeeDto.getCarKindCode());
        dbManager.setString(9,prpLrepairFeeDto.getRepairFactoryCode());
        dbManager.setString(10,prpLrepairFeeDto.getRepairFactoryName());
        dbManager.setString(11,prpLrepairFeeDto.getHandlerCode());
        dbManager.setDateTime(12,prpLrepairFeeDto.getRepairStartDate());
        dbManager.setDateTime(13,prpLrepairFeeDto.getRepairEndDate());
        dbManager.setString(14,prpLrepairFeeDto.getSanctioner());
        dbManager.setString(15,prpLrepairFeeDto.getApproverCode());
        dbManager.setString(16,prpLrepairFeeDto.getOperatorCode());
        dbManager.setString(17,prpLrepairFeeDto.getCompCode());
        dbManager.setString(18,prpLrepairFeeDto.getCompName());
        dbManager.setDouble(19,prpLrepairFeeDto.getManHour());
        dbManager.setDouble(20,prpLrepairFeeDto.getManHourUnitPrice());
        dbManager.setDouble(21,prpLrepairFeeDto.getManHourFee());
        dbManager.setDouble(22,prpLrepairFeeDto.getMaterialFee());
        dbManager.setDouble(23,prpLrepairFeeDto.getLossRate());
        dbManager.setString(24,prpLrepairFeeDto.getCurrency());
        dbManager.setDouble(25,prpLrepairFeeDto.getSumDefLoss());
        dbManager.setString(26,prpLrepairFeeDto.getRemark());
        dbManager.setString(27,prpLrepairFeeDto.getFlag());
        dbManager.setDouble(28,prpLrepairFeeDto.getVeriManHour());
        dbManager.setDouble(29,prpLrepairFeeDto.getVeriManUnitPrice());
        dbManager.setDouble(30,prpLrepairFeeDto.getVeriManHourFee());
        dbManager.setDouble(31,prpLrepairFeeDto.getVeriMaterQuantity());
        dbManager.setDouble(32,prpLrepairFeeDto.getVeriMaterUnitPrice());
        dbManager.setDouble(33,prpLrepairFeeDto.getVeriMaterialFee());
        dbManager.setDouble(34,prpLrepairFeeDto.getVeriLossRate());
        dbManager.setDouble(35,prpLrepairFeeDto.getVeriSumLoss());
        dbManager.setString(36,prpLrepairFeeDto.getVeriRemark());
        dbManager.setDouble(37,prpLrepairFeeDto.getMaterialQuantity());
        dbManager.setDouble(38,prpLrepairFeeDto.getMaterialUnitPrice());
        dbManager.setDouble(39,prpLrepairFeeDto.getSumCheckLoss());
        dbManager.setString(40,prpLrepairFeeDto.getBackCheckRemark());
        dbManager.setString(41,prpLrepairFeeDto.getPartCode());
        dbManager.setString(42,prpLrepairFeeDto.getPartName());
        dbManager.setString(43,prpLrepairFeeDto.getRepairType());
        dbManager.setDouble(44,prpLrepairFeeDto.getFirstSumDefLoss());
        dbManager.setString(45,prpLrepairFeeDto.getCompensateBackFlag());
        //设置条件字段;
        dbManager.setInt(46,prpLrepairFeeDto.getSerialNo());
        dbManager.setString(47,prpLrepairFeeDto.getRegistNo());
        dbManager.setString(48,prpLrepairFeeDto.getLossItemCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrepairFeeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @param lossItemCode 标的代码
     * @return PrpLrepairFeeDto
     * @throws Exception
     */
    public PrpLrepairFeeDto findByPrimaryKey(int serialNo,String registNo,String lossItemCode) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriManHour," + 
                           " VeriManUnitPrice," + 
                           " VeriManHourFee," + 
                           " VeriMaterQuantity," + 
                           " VeriMaterUnitPrice," + 
                           " VeriMaterialFee," + 
                           " VeriLossRate," + 
                           " VeriSumLoss," + 
                           " VeriRemark," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " BackCheckRemark," + 
                           " LossItemCode," + 
                           " PartCode," + 
                           " PartName," + 
                           " RepairType," + 
                           " FirstSumDefLoss," + 
                           " CompensateBackFlag From PrpLrepairFee";
        String statement = mainStatement + " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ? And " + 
                           " LossItemCode = ?";
        PrpLrepairFeeDto prpLrepairFeeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLrepairFeeDto = new PrpLrepairFeeDto();
            prpLrepairFeeDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrepairFeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLrepairFeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLrepairFeeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLrepairFeeDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLrepairFeeDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLrepairFeeDto.setKindCode(dbManager.getString(resultSet,7));
            prpLrepairFeeDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLrepairFeeDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLrepairFeeDto.setCarKindCode(dbManager.getString(resultSet,10));
            prpLrepairFeeDto.setRepairFactoryCode(dbManager.getString(resultSet,11));
            prpLrepairFeeDto.setRepairFactoryName(dbManager.getString(resultSet,12));
            prpLrepairFeeDto.setHandlerCode(dbManager.getString(resultSet,13));
            prpLrepairFeeDto.setRepairStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLrepairFeeDto.setRepairEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLrepairFeeDto.setSanctioner(dbManager.getString(resultSet,16));
            prpLrepairFeeDto.setApproverCode(dbManager.getString(resultSet,17));
            prpLrepairFeeDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLrepairFeeDto.setCompCode(dbManager.getString(resultSet,19));
            prpLrepairFeeDto.setCompName(dbManager.getString(resultSet,20));
            prpLrepairFeeDto.setManHour(dbManager.getDouble(resultSet,21));
            prpLrepairFeeDto.setManHourUnitPrice(dbManager.getDouble(resultSet,22));
            prpLrepairFeeDto.setManHourFee(dbManager.getDouble(resultSet,23));
            prpLrepairFeeDto.setMaterialFee(dbManager.getDouble(resultSet,24));
            prpLrepairFeeDto.setLossRate(dbManager.getDouble(resultSet,25));
            prpLrepairFeeDto.setCurrency(dbManager.getString(resultSet,26));
            prpLrepairFeeDto.setSumDefLoss(dbManager.getDouble(resultSet,27));
            prpLrepairFeeDto.setRemark(dbManager.getString(resultSet,28));
            prpLrepairFeeDto.setFlag(dbManager.getString(resultSet,29));
            prpLrepairFeeDto.setVeriManHour(dbManager.getDouble(resultSet,30));
            prpLrepairFeeDto.setVeriManUnitPrice(dbManager.getDouble(resultSet,31));
            prpLrepairFeeDto.setVeriManHourFee(dbManager.getDouble(resultSet,32));
            prpLrepairFeeDto.setVeriMaterQuantity(dbManager.getDouble(resultSet,33));
            prpLrepairFeeDto.setVeriMaterUnitPrice(dbManager.getDouble(resultSet,34));
            prpLrepairFeeDto.setVeriMaterialFee(dbManager.getDouble(resultSet,35));
            prpLrepairFeeDto.setVeriLossRate(dbManager.getDouble(resultSet,36));
            prpLrepairFeeDto.setVeriSumLoss(dbManager.getDouble(resultSet,37));
            prpLrepairFeeDto.setVeriRemark(dbManager.getString(resultSet,38));
            prpLrepairFeeDto.setMaterialQuantity(dbManager.getDouble(resultSet,39));
            prpLrepairFeeDto.setMaterialUnitPrice(dbManager.getDouble(resultSet,40));
            prpLrepairFeeDto.setSumCheckLoss(dbManager.getDouble(resultSet,41));
            prpLrepairFeeDto.setBackCheckRemark(dbManager.getString(resultSet,42));
            prpLrepairFeeDto.setLossItemCode(dbManager.getString(resultSet,43));
            prpLrepairFeeDto.setPartCode(dbManager.getString(resultSet,44));
            prpLrepairFeeDto.setPartName(dbManager.getString(resultSet,45));
            prpLrepairFeeDto.setRepairType(dbManager.getString(resultSet,46));
            prpLrepairFeeDto.setFirstSumDefLoss(dbManager.getDouble(resultSet,47));
            prpLrepairFeeDto.setCompensateBackFlag(dbManager.getString(resultSet,48));
        }
        resultSet.close();
        logger.info("DBPrpLrepairFeeBase.findByPrimaryKey() success!");
        return prpLrepairFeeDto;
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
        String statement = "Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " RepairFactoryCode," + 
                           " RepairFactoryName," + 
                           " HandlerCode," + 
                           " RepairStartDate," + 
                           " RepairEndDate," + 
                           " Sanctioner," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " LossRate," + 
                           " Currency," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriManHour," + 
                           " VeriManUnitPrice," + 
                           " VeriManHourFee," + 
                           " VeriMaterQuantity," + 
                           " VeriMaterUnitPrice," + 
                           " VeriMaterialFee," + 
                           " VeriLossRate," + 
                           " VeriSumLoss," + 
                           " VeriRemark," + 
                           " MaterialQuantity," + 
                           " MaterialUnitPrice," + 
                           " SumCheckLoss," + 
                           " BackCheckRemark," + 
                           " LossItemCode," + 
                           " PartCode," + 
                           " PartName," + 
                           " RepairType," + 
                           " FirstSumDefLoss," + 
                           " CompensateBackFlag  From PrpLrepairFee Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLrepairFeeDto prpLrepairFeeDto = null;
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

            prpLrepairFeeDto = new PrpLrepairFeeDto();
            prpLrepairFeeDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrepairFeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLrepairFeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLrepairFeeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLrepairFeeDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLrepairFeeDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLrepairFeeDto.setKindCode(dbManager.getString(resultSet,7));
            prpLrepairFeeDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLrepairFeeDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLrepairFeeDto.setCarKindCode(dbManager.getString(resultSet,10));
            prpLrepairFeeDto.setRepairFactoryCode(dbManager.getString(resultSet,11));
            prpLrepairFeeDto.setRepairFactoryName(dbManager.getString(resultSet,12));
            prpLrepairFeeDto.setHandlerCode(dbManager.getString(resultSet,13));
            prpLrepairFeeDto.setRepairStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLrepairFeeDto.setRepairEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpLrepairFeeDto.setSanctioner(dbManager.getString(resultSet,16));
            prpLrepairFeeDto.setApproverCode(dbManager.getString(resultSet,17));
            prpLrepairFeeDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpLrepairFeeDto.setCompCode(dbManager.getString(resultSet,19));
            prpLrepairFeeDto.setCompName(dbManager.getString(resultSet,20));
            prpLrepairFeeDto.setManHour(dbManager.getDouble(resultSet,21));
            prpLrepairFeeDto.setManHourUnitPrice(dbManager.getDouble(resultSet,22));
            prpLrepairFeeDto.setManHourFee(dbManager.getDouble(resultSet,23));
            prpLrepairFeeDto.setMaterialFee(dbManager.getDouble(resultSet,24));
            prpLrepairFeeDto.setLossRate(dbManager.getDouble(resultSet,25));
            prpLrepairFeeDto.setCurrency(dbManager.getString(resultSet,26));
            prpLrepairFeeDto.setSumDefLoss(dbManager.getDouble(resultSet,27));
            prpLrepairFeeDto.setRemark(dbManager.getString(resultSet,28));
            prpLrepairFeeDto.setFlag(dbManager.getString(resultSet,29));
            prpLrepairFeeDto.setVeriManHour(dbManager.getDouble(resultSet,30));
            prpLrepairFeeDto.setVeriManUnitPrice(dbManager.getDouble(resultSet,31));
            prpLrepairFeeDto.setVeriManHourFee(dbManager.getDouble(resultSet,32));
            prpLrepairFeeDto.setVeriMaterQuantity(dbManager.getDouble(resultSet,33));
            prpLrepairFeeDto.setVeriMaterUnitPrice(dbManager.getDouble(resultSet,34));
            prpLrepairFeeDto.setVeriMaterialFee(dbManager.getDouble(resultSet,35));
            prpLrepairFeeDto.setVeriLossRate(dbManager.getDouble(resultSet,36));
            prpLrepairFeeDto.setVeriSumLoss(dbManager.getDouble(resultSet,37));
            prpLrepairFeeDto.setVeriRemark(dbManager.getString(resultSet,38));
            prpLrepairFeeDto.setMaterialQuantity(dbManager.getDouble(resultSet,39));
            prpLrepairFeeDto.setMaterialUnitPrice(dbManager.getDouble(resultSet,40));
            prpLrepairFeeDto.setSumCheckLoss(dbManager.getDouble(resultSet,41));
            prpLrepairFeeDto.setBackCheckRemark(dbManager.getString(resultSet,42));
            prpLrepairFeeDto.setLossItemCode(dbManager.getString(resultSet,43));
            prpLrepairFeeDto.setPartCode(dbManager.getString(resultSet,44));
            prpLrepairFeeDto.setPartName(dbManager.getString(resultSet,45));
            prpLrepairFeeDto.setRepairType(dbManager.getString(resultSet,46));
            prpLrepairFeeDto.setFirstSumDefLoss(dbManager.getDouble(resultSet,47));
            prpLrepairFeeDto.setCompensateBackFlag(dbManager.getString(resultSet,48));
            collection.add(prpLrepairFeeDto);
        }
        resultSet.close();
        logger.info("DBPrpLrepairFeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpLrepairFee Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLrepairFeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLrepairFee Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLrepairFeeBase.getCount() success!");
        return count;
    }
}
