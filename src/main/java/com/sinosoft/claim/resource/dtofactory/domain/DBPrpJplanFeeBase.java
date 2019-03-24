package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是应收应付费信息表的数据访问对象基类<br>
 */
public class DBPrpJplanFeeBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpJplanFeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJplanFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void insert(PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpJplanFee (");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PayRefReason,");
        buffer.append("ClaimNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ContractNo,");
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("ValidDate,");
        buffer.append("PayNo,");
        buffer.append("Currency1,");
        buffer.append("PlanFee,");
        buffer.append("PlanDate,");
        buffer.append("ComCode,");
        buffer.append("MakeCom,");
        buffer.append("AgentCode,");
        buffer.append("Handler1Code,");
        buffer.append("HandlerCode,");
        buffer.append("UnderWriteDate,");
        buffer.append("CoinsFlag,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CenterCode,");
        buffer.append("BranchCode,");
        buffer.append("AccBookType,");
        buffer.append("AccBookCode,");
        buffer.append("YearMonth,");
        buffer.append("VoucherNo,");
        buffer.append("ExchangeRate,");
        buffer.append("PlanFeeCNY,");
        buffer.append("PayRefFee,");
        buffer.append("RealPayRefFee,");
        buffer.append("Flag,");
        buffer.append("BusinessNature,");
        buffer.append("OthFlag,");
        buffer.append("CarNatureCode,");
        buffer.append("UseNatureCode,");
        buffer.append("CarProperty, ");
        buffer.append("PayComCode, ");
        buffer.append("BusinessType, ");
        buffer.append("BusinessType1 ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpJplanFeeDto.getCertiType()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCertiNo()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpJplanFeeDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpJplanFeeDto.getPayRefReason()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getContractNo()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getAppliCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getAppliName()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getStartDate()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getEndDate()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getValidDate()).append("',");
            debugBuffer.append("").append(prpJplanFeeDto.getPayNo()).append(",");
            debugBuffer.append("'").append(prpJplanFeeDto.getCurrency1()).append("',");
            debugBuffer.append("").append(prpJplanFeeDto.getPlanFee()).append(",");
            debugBuffer.append("'").append(prpJplanFeeDto.getPlanDate()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getAgentCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getUnderWriteDate()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCoinsFlag()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCoinsType()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCenterCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getBranchCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getAccBookType()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getAccBookCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getYearMonth()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getVoucherNo()).append("',");
            debugBuffer.append("").append(prpJplanFeeDto.getExchangeRate()).append(",");
            debugBuffer.append("").append(prpJplanFeeDto.getPlanFeeCNY()).append(",");
            debugBuffer.append("").append(prpJplanFeeDto.getPayRefFee()).append(",");
            debugBuffer.append("").append(prpJplanFeeDto.getRealPayRefFee()).append(",");
            debugBuffer.append("'").append(prpJplanFeeDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getBusinessNature()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getOthFlag()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getCarNatureCode()).append("',");
            debugBuffer.append("'").append(prpJplanFeeDto.getUseNatureCode()).append("',");
            debugBuffer.append("").append(prpJplanFeeDto.getCarProperty()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpJplanFeeDto.getCertiType());
        dbManager.setString(2,prpJplanFeeDto.getCertiNo());
        dbManager.setString(3,prpJplanFeeDto.getPolicyNo());
        dbManager.setInt(4,prpJplanFeeDto.getSerialNo());
        dbManager.setString(5,prpJplanFeeDto.getPayRefReason());
        dbManager.setString(6,prpJplanFeeDto.getClaimNo());
        dbManager.setString(7,prpJplanFeeDto.getClassCode());
        dbManager.setString(8,prpJplanFeeDto.getRiskCode());
        dbManager.setString(9,prpJplanFeeDto.getContractNo());
        dbManager.setString(10,prpJplanFeeDto.getAppliCode());
        dbManager.setString(11,prpJplanFeeDto.getAppliName());
        dbManager.setString(12,prpJplanFeeDto.getInsuredCode());
        dbManager.setString(13,prpJplanFeeDto.getInsuredName());
        dbManager.setDateTime(14,prpJplanFeeDto.getStartDate());
        dbManager.setDateTime(15,prpJplanFeeDto.getEndDate());
        dbManager.setDateTime(16,prpJplanFeeDto.getValidDate());
        dbManager.setInt(17,prpJplanFeeDto.getPayNo());
        dbManager.setString(18,prpJplanFeeDto.getCurrency1());
        dbManager.setDouble(19,prpJplanFeeDto.getPlanFee());
        dbManager.setDateTime(20,prpJplanFeeDto.getPlanDate());
        dbManager.setString(21,prpJplanFeeDto.getComCode());
        dbManager.setString(22,prpJplanFeeDto.getMakeCom());
        dbManager.setString(23,prpJplanFeeDto.getAgentCode());
        dbManager.setString(24,prpJplanFeeDto.getHandler1Code());
        dbManager.setString(25,prpJplanFeeDto.getHandlerCode());
        dbManager.setDateTime(26,prpJplanFeeDto.getUnderWriteDate());
        dbManager.setString(27,prpJplanFeeDto.getCoinsFlag());
        dbManager.setString(28,prpJplanFeeDto.getCoinsCode());
        dbManager.setString(29,prpJplanFeeDto.getCoinsName());
        dbManager.setString(30,prpJplanFeeDto.getCoinsType());
        dbManager.setString(31,prpJplanFeeDto.getCenterCode());
        dbManager.setString(32,prpJplanFeeDto.getBranchCode());
        dbManager.setString(33,prpJplanFeeDto.getAccBookType());
        dbManager.setString(34,prpJplanFeeDto.getAccBookCode());
        dbManager.setString(35,prpJplanFeeDto.getYearMonth());
        dbManager.setString(36,prpJplanFeeDto.getVoucherNo());
        dbManager.setDouble(37,prpJplanFeeDto.getExchangeRate());
        dbManager.setDouble(38,prpJplanFeeDto.getPlanFeeCNY());
        dbManager.setDouble(39,prpJplanFeeDto.getPayRefFee());
        dbManager.setDouble(40,prpJplanFeeDto.getRealPayRefFee());
        dbManager.setString(41,prpJplanFeeDto.getFlag());
        dbManager.setString(42,prpJplanFeeDto.getBusinessNature());
        dbManager.setString(43,prpJplanFeeDto.getOthFlag());
        dbManager.setString(44,prpJplanFeeDto.getCarNatureCode());
        dbManager.setString(45,prpJplanFeeDto.getUseNatureCode());
        dbManager.setDouble(46,prpJplanFeeDto.getCarProperty());
        dbManager.setString(47,prpJplanFeeDto.getPayComCode());
        dbManager.setString(48,prpJplanFeeDto.getBusinessType());
        dbManager.setString(49,prpJplanFeeDto.getBusinessType());
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
        buffer.append("INSERT INTO PrpJplanFee (");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PayRefReason,");
        buffer.append("ClaimNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ContractNo,");
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("ValidDate,");
        buffer.append("PayNo,");
        buffer.append("Currency1,");
        buffer.append("PlanFee,");
        buffer.append("PlanDate,");
        buffer.append("ComCode,");
        buffer.append("MakeCom,");
        buffer.append("AgentCode,");
        buffer.append("Handler1Code,");
        buffer.append("HandlerCode,");
        buffer.append("UnderWriteDate,");
        buffer.append("CoinsFlag,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CenterCode,");
        buffer.append("BranchCode,");
        buffer.append("AccBookType,");
        buffer.append("AccBookCode,");
        buffer.append("YearMonth,");
        buffer.append("VoucherNo,");
        buffer.append("ExchangeRate,");
        buffer.append("PlanFeeCNY,");
        buffer.append("PayRefFee,");
        buffer.append("RealPayRefFee,");
        buffer.append("Flag,");
        buffer.append("BusinessNature,");
        buffer.append("OthFlag,");
        buffer.append("CarNatureCode,");
        buffer.append("UseNatureCode,");
        buffer.append("CarProperty,");
        buffer.append("PayComCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1 ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpJplanFeeDto prpJplanFeeDto = (PrpJplanFeeDto)i.next();
            dbManager.setString(1,prpJplanFeeDto.getCertiType());
            dbManager.setString(2,prpJplanFeeDto.getCertiNo());
            dbManager.setString(3,prpJplanFeeDto.getPolicyNo());
            dbManager.setInt(4,prpJplanFeeDto.getSerialNo());
            dbManager.setString(5,prpJplanFeeDto.getPayRefReason());
            dbManager.setString(6,prpJplanFeeDto.getClaimNo());
            dbManager.setString(7,prpJplanFeeDto.getClassCode());
            dbManager.setString(8,prpJplanFeeDto.getRiskCode());
            dbManager.setString(9,prpJplanFeeDto.getContractNo());
            dbManager.setString(10,prpJplanFeeDto.getAppliCode());
            dbManager.setString(11,prpJplanFeeDto.getAppliName());
            dbManager.setString(12,prpJplanFeeDto.getInsuredCode());
            dbManager.setString(13,prpJplanFeeDto.getInsuredName());
            dbManager.setDateTime(14,prpJplanFeeDto.getStartDate());
            dbManager.setDateTime(15,prpJplanFeeDto.getEndDate());
            dbManager.setDateTime(16,prpJplanFeeDto.getValidDate());
            dbManager.setInt(17,prpJplanFeeDto.getPayNo());
            dbManager.setString(18,prpJplanFeeDto.getCurrency1());
            dbManager.setDouble(19,prpJplanFeeDto.getPlanFee());
            dbManager.setDateTime(20,prpJplanFeeDto.getPlanDate());
            dbManager.setString(21,prpJplanFeeDto.getComCode());
            dbManager.setString(22,prpJplanFeeDto.getMakeCom());
            dbManager.setString(23,prpJplanFeeDto.getAgentCode());
            dbManager.setString(24,prpJplanFeeDto.getHandler1Code());
            dbManager.setString(25,prpJplanFeeDto.getHandlerCode());
            dbManager.setDateTime(26,prpJplanFeeDto.getUnderWriteDate());
            dbManager.setString(27,prpJplanFeeDto.getCoinsFlag());
            dbManager.setString(28,prpJplanFeeDto.getCoinsCode());
            dbManager.setString(29,prpJplanFeeDto.getCoinsName());
            dbManager.setString(30,prpJplanFeeDto.getCoinsType());
            dbManager.setString(31,prpJplanFeeDto.getCenterCode());
            dbManager.setString(32,prpJplanFeeDto.getBranchCode());
            dbManager.setString(33,prpJplanFeeDto.getAccBookType());
            dbManager.setString(34,prpJplanFeeDto.getAccBookCode());
            dbManager.setString(35,prpJplanFeeDto.getYearMonth());
            dbManager.setString(36,prpJplanFeeDto.getVoucherNo());
            dbManager.setDouble(37,prpJplanFeeDto.getExchangeRate());
            dbManager.setDouble(38,prpJplanFeeDto.getPlanFeeCNY());
            dbManager.setDouble(39,prpJplanFeeDto.getPayRefFee());
            dbManager.setDouble(40,prpJplanFeeDto.getRealPayRefFee());
            dbManager.setString(41,prpJplanFeeDto.getFlag());
            dbManager.setString(42,prpJplanFeeDto.getBusinessNature());
            dbManager.setString(43,prpJplanFeeDto.getOthFlag());
            dbManager.setString(44,prpJplanFeeDto.getCarNatureCode());
            dbManager.setString(45,prpJplanFeeDto.getUseNatureCode());
            dbManager.setDouble(46,prpJplanFeeDto.getCarProperty());
            dbManager.setString(47,prpJplanFeeDto.getPayComCode());
            dbManager.setString(48,prpJplanFeeDto.getBusinessType());
            dbManager.setString(49,prpJplanFeeDto.getBusinessType1());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @throws Exception
     */
    public void delete(String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpJplanFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("' AND ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("PayRefReason=").append("'").append(payRefReason).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiType = ? And ");
        buffer.append("CertiNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("PayRefReason = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiType);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.setString(4,payRefReason);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void update(PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpJplanFee SET ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("ContractNo = ?, ");
        buffer.append("AppliCode = ?, ");
        buffer.append("AppliName = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("ValidDate = ?, ");
        buffer.append("PayNo = ?, ");
        buffer.append("Currency1 = ?, ");
        buffer.append("PlanFee = ?, ");
        buffer.append("PlanDate = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("AgentCode = ?, ");
        buffer.append("Handler1Code = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("UnderWriteDate = ?, ");
        buffer.append("CoinsFlag = ?, ");
        buffer.append("CoinsCode = ?, ");
        buffer.append("CoinsName = ?, ");
        buffer.append("CoinsType = ?, ");
        buffer.append("CenterCode = ?, ");
        buffer.append("BranchCode = ?, ");
        buffer.append("AccBookType = ?, ");
        buffer.append("AccBookCode = ?, ");
        buffer.append("YearMonth = ?, ");
        buffer.append("VoucherNo = ?, ");
        buffer.append("ExchangeRate = ?, ");
        buffer.append("PlanFeeCNY = ?, ");
        buffer.append("PayRefFee = ?, ");
        buffer.append("RealPayRefFee = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("BusinessNature = ?, ");
        buffer.append("OthFlag = ?, ");
        buffer.append("CarNatureCode = ?, ");
        buffer.append("UseNatureCode = ?, ");
        buffer.append("CarProperty = ?, ");
        buffer.append("PayComCode = ?, ");
        buffer.append("BusinessType = ?, ");
        buffer.append("BusinessType1 = ? ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpJplanFee SET ");
            debugBuffer.append("PolicyNo = '" + prpJplanFeeDto.getPolicyNo() + "', ");
            debugBuffer.append("ClaimNo = '" + prpJplanFeeDto.getClaimNo() + "', ");
            debugBuffer.append("ClassCode = '" + prpJplanFeeDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpJplanFeeDto.getRiskCode() + "', ");
            debugBuffer.append("ContractNo = '" + prpJplanFeeDto.getContractNo() + "', ");
            debugBuffer.append("AppliCode = '" + prpJplanFeeDto.getAppliCode() + "', ");
            debugBuffer.append("AppliName = '" + prpJplanFeeDto.getAppliName() + "', ");
            debugBuffer.append("InsuredCode = '" + prpJplanFeeDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpJplanFeeDto.getInsuredName() + "', ");
            debugBuffer.append("StartDate = '" + prpJplanFeeDto.getStartDate() + "', ");
            debugBuffer.append("EndDate = '" + prpJplanFeeDto.getEndDate() + "', ");
            debugBuffer.append("ValidDate = '" + prpJplanFeeDto.getValidDate() + "', ");
            debugBuffer.append("PayNo = " + prpJplanFeeDto.getPayNo() + ", ");
            debugBuffer.append("Currency1 = '" + prpJplanFeeDto.getCurrency1() + "', ");
            debugBuffer.append("PlanFee = " + prpJplanFeeDto.getPlanFee() + ", ");
            debugBuffer.append("PlanDate = '" + prpJplanFeeDto.getPlanDate() + "', ");
            debugBuffer.append("ComCode = '" + prpJplanFeeDto.getComCode() + "', ");
            debugBuffer.append("MakeCom = '" + prpJplanFeeDto.getMakeCom() + "', ");
            debugBuffer.append("AgentCode = '" + prpJplanFeeDto.getAgentCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpJplanFeeDto.getHandler1Code() + "', ");
            debugBuffer.append("HandlerCode = '" + prpJplanFeeDto.getHandlerCode() + "', ");
            debugBuffer.append("UnderWriteDate = '" + prpJplanFeeDto.getUnderWriteDate() + "', ");
            debugBuffer.append("CoinsFlag = '" + prpJplanFeeDto.getCoinsFlag() + "', ");
            debugBuffer.append("CoinsCode = '" + prpJplanFeeDto.getCoinsCode() + "', ");
            debugBuffer.append("CoinsName = '" + prpJplanFeeDto.getCoinsName() + "', ");
            debugBuffer.append("CoinsType = '" + prpJplanFeeDto.getCoinsType() + "', ");
            debugBuffer.append("CenterCode = '" + prpJplanFeeDto.getCenterCode() + "', ");
            debugBuffer.append("BranchCode = '" + prpJplanFeeDto.getBranchCode() + "', ");
            debugBuffer.append("AccBookType = '" + prpJplanFeeDto.getAccBookType() + "', ");
            debugBuffer.append("AccBookCode = '" + prpJplanFeeDto.getAccBookCode() + "', ");
            debugBuffer.append("YearMonth = '" + prpJplanFeeDto.getYearMonth() + "', ");
            debugBuffer.append("VoucherNo = '" + prpJplanFeeDto.getVoucherNo() + "', ");
            debugBuffer.append("ExchangeRate = " + prpJplanFeeDto.getExchangeRate() + ", ");
            debugBuffer.append("PlanFeeCNY = " + prpJplanFeeDto.getPlanFeeCNY() + ", ");
            debugBuffer.append("PayRefFee = " + prpJplanFeeDto.getPayRefFee() + ", ");
            debugBuffer.append("RealPayRefFee = " + prpJplanFeeDto.getRealPayRefFee() + ", ");
            debugBuffer.append("Flag = '" + prpJplanFeeDto.getFlag() + "', ");
            debugBuffer.append("BusinessNature = '" + prpJplanFeeDto.getBusinessNature() + "', ");
            debugBuffer.append("OthFlag = '" + prpJplanFeeDto.getOthFlag() + "', ");
            debugBuffer.append("CarNatureCode = '" + prpJplanFeeDto.getCarNatureCode() + "', ");
            debugBuffer.append("UseNatureCode = '" + prpJplanFeeDto.getUseNatureCode() + "', ");
            debugBuffer.append("CarProperty = " + prpJplanFeeDto.getCarProperty() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiType=").append("'").append(prpJplanFeeDto.getCertiType()).append("' AND ");
            debugBuffer.append("CertiNo=").append("'").append(prpJplanFeeDto.getCertiNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpJplanFeeDto.getSerialNo()).append(" AND ");
            debugBuffer.append("PayRefReason=").append("'").append(prpJplanFeeDto.getPayRefReason()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiType = ? And ");
        buffer.append("CertiNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("PayRefReason = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpJplanFeeDto.getPolicyNo());
        dbManager.setString(2,prpJplanFeeDto.getClaimNo());
        dbManager.setString(3,prpJplanFeeDto.getClassCode());
        dbManager.setString(4,prpJplanFeeDto.getRiskCode());
        dbManager.setString(5,prpJplanFeeDto.getContractNo());
        dbManager.setString(6,prpJplanFeeDto.getAppliCode());
        dbManager.setString(7,prpJplanFeeDto.getAppliName());
        dbManager.setString(8,prpJplanFeeDto.getInsuredCode());
        dbManager.setString(9,prpJplanFeeDto.getInsuredName());
        dbManager.setDateTime(10,prpJplanFeeDto.getStartDate());
        dbManager.setDateTime(11,prpJplanFeeDto.getEndDate());
        dbManager.setDateTime(12,prpJplanFeeDto.getValidDate());
        dbManager.setInt(13,prpJplanFeeDto.getPayNo());
        dbManager.setString(14,prpJplanFeeDto.getCurrency1());
        dbManager.setDouble(15,prpJplanFeeDto.getPlanFee());
        dbManager.setDateTime(16,prpJplanFeeDto.getPlanDate());
        dbManager.setString(17,prpJplanFeeDto.getComCode());
        dbManager.setString(18,prpJplanFeeDto.getMakeCom());
        dbManager.setString(19,prpJplanFeeDto.getAgentCode());
        dbManager.setString(20,prpJplanFeeDto.getHandler1Code());
        dbManager.setString(21,prpJplanFeeDto.getHandlerCode());
        dbManager.setDateTime(22,prpJplanFeeDto.getUnderWriteDate());
        dbManager.setString(23,prpJplanFeeDto.getCoinsFlag());
        dbManager.setString(24,prpJplanFeeDto.getCoinsCode());
        dbManager.setString(25,prpJplanFeeDto.getCoinsName());
        dbManager.setString(26,prpJplanFeeDto.getCoinsType());
        dbManager.setString(27,prpJplanFeeDto.getCenterCode());
        dbManager.setString(28,prpJplanFeeDto.getBranchCode());
        dbManager.setString(29,prpJplanFeeDto.getAccBookType());
        dbManager.setString(30,prpJplanFeeDto.getAccBookCode());
        dbManager.setString(31,prpJplanFeeDto.getYearMonth());
        dbManager.setString(32,prpJplanFeeDto.getVoucherNo());
        dbManager.setDouble(33,prpJplanFeeDto.getExchangeRate());
        dbManager.setDouble(34,prpJplanFeeDto.getPlanFeeCNY());
        dbManager.setDouble(35,prpJplanFeeDto.getPayRefFee());
        dbManager.setDouble(36,prpJplanFeeDto.getRealPayRefFee());
        dbManager.setString(37,prpJplanFeeDto.getFlag());
        dbManager.setString(38,prpJplanFeeDto.getBusinessNature());
        dbManager.setString(39,prpJplanFeeDto.getOthFlag());
        dbManager.setString(40,prpJplanFeeDto.getCarNatureCode());
        dbManager.setString(41,prpJplanFeeDto.getUseNatureCode());
        dbManager.setDouble(42,prpJplanFeeDto.getCarProperty());
        dbManager.setString(43,prpJplanFeeDto.getPayComCode());
        dbManager.setString(44,prpJplanFeeDto.getBusinessType());
        dbManager.setString(45,prpJplanFeeDto.getBusinessType1());
        
        //设置条件字段;
        dbManager.setString(46,prpJplanFeeDto.getCertiType());
        dbManager.setString(47,prpJplanFeeDto.getCertiNo());
        dbManager.setInt(48,prpJplanFeeDto.getSerialNo());
        dbManager.setString(49,prpJplanFeeDto.getPayRefReason());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @return PrpJplanFeeDto
     * @throws Exception
     */
    public PrpJplanFeeDto findByPrimaryKey(String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PayRefReason,");
        buffer.append("ClaimNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ContractNo,");
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("ValidDate,");
        buffer.append("PayNo,");
        buffer.append("Currency1,");
        buffer.append("PlanFee,");
        buffer.append("PlanDate,");
        buffer.append("ComCode,");
        buffer.append("MakeCom,");
        buffer.append("AgentCode,");
        buffer.append("Handler1Code,");
        buffer.append("HandlerCode,");
        buffer.append("UnderWriteDate,");
        buffer.append("CoinsFlag,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CenterCode,");
        buffer.append("BranchCode,");
        buffer.append("AccBookType,");
        buffer.append("AccBookCode,");
        buffer.append("YearMonth,");
        buffer.append("VoucherNo,");
        buffer.append("ExchangeRate,");
        buffer.append("PlanFeeCNY,");
        buffer.append("PayRefFee,");
        buffer.append("RealPayRefFee,");
        buffer.append("Flag,");
        buffer.append("BusinessNature,");
        buffer.append("OthFlag,");
        buffer.append("CarNatureCode,");
        buffer.append("UseNatureCode,");
        buffer.append("CarProperty,");
        buffer.append("PayComCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1 ");
        buffer.append("FROM PrpJplanFee ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CertiType=").append("'").append(certiType).append("' AND ");
            debugBuffer.append("CertiNo=").append("'").append(certiNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("PayRefReason=").append("'").append(payRefReason).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CertiType = ? And ");
        buffer.append("CertiNo = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("PayRefReason = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,certiType);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.setString(4,payRefReason);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpJplanFeeDto prpJplanFeeDto = null;
        if(resultSet.next()){
            prpJplanFeeDto = new PrpJplanFeeDto();
            prpJplanFeeDto.setCertiType(dbManager.getString(resultSet,1));
            prpJplanFeeDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJplanFeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJplanFeeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJplanFeeDto.setPayRefReason(dbManager.getString(resultSet,5));
            prpJplanFeeDto.setClaimNo(dbManager.getString(resultSet,6));
            prpJplanFeeDto.setClassCode(dbManager.getString(resultSet,7));
            prpJplanFeeDto.setRiskCode(dbManager.getString(resultSet,8));
            prpJplanFeeDto.setContractNo(dbManager.getString(resultSet,9));
            prpJplanFeeDto.setAppliCode(dbManager.getString(resultSet,10));
            prpJplanFeeDto.setAppliName(dbManager.getString(resultSet,11));
            prpJplanFeeDto.setInsuredCode(dbManager.getString(resultSet,12));
            prpJplanFeeDto.setInsuredName(dbManager.getString(resultSet,13));
            prpJplanFeeDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpJplanFeeDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJplanFeeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJplanFeeDto.setPayNo(dbManager.getInt(resultSet,17));
            prpJplanFeeDto.setCurrency1(dbManager.getString(resultSet,18));
            prpJplanFeeDto.setPlanFee(dbManager.getDouble(resultSet,19));
            prpJplanFeeDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpJplanFeeDto.setComCode(dbManager.getString(resultSet,21));
            prpJplanFeeDto.setMakeCom(dbManager.getString(resultSet,22));
            prpJplanFeeDto.setAgentCode(dbManager.getString(resultSet,23));
            prpJplanFeeDto.setHandler1Code(dbManager.getString(resultSet,24));
            prpJplanFeeDto.setHandlerCode(dbManager.getString(resultSet,25));
            prpJplanFeeDto.setUnderWriteDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpJplanFeeDto.setCoinsFlag(dbManager.getString(resultSet,27));
            prpJplanFeeDto.setCoinsCode(dbManager.getString(resultSet,28));
            prpJplanFeeDto.setCoinsName(dbManager.getString(resultSet,29));
            prpJplanFeeDto.setCoinsType(dbManager.getString(resultSet,30));
            prpJplanFeeDto.setCenterCode(dbManager.getString(resultSet,31));
            prpJplanFeeDto.setBranchCode(dbManager.getString(resultSet,32));
            prpJplanFeeDto.setAccBookType(dbManager.getString(resultSet,33));
            prpJplanFeeDto.setAccBookCode(dbManager.getString(resultSet,34));
            prpJplanFeeDto.setYearMonth(dbManager.getString(resultSet,35));
            prpJplanFeeDto.setVoucherNo(dbManager.getString(resultSet,36));
            prpJplanFeeDto.setExchangeRate(dbManager.getDouble(resultSet,37));
            prpJplanFeeDto.setPlanFeeCNY(dbManager.getDouble(resultSet,38));
            prpJplanFeeDto.setPayRefFee(dbManager.getDouble(resultSet,39));
            prpJplanFeeDto.setRealPayRefFee(dbManager.getDouble(resultSet,40));
            prpJplanFeeDto.setFlag(dbManager.getString(resultSet,41));
            prpJplanFeeDto.setBusinessNature(dbManager.getString(resultSet,42));
            prpJplanFeeDto.setOthFlag(dbManager.getString(resultSet,43));
            prpJplanFeeDto.setCarNatureCode(dbManager.getString(resultSet,44));
            prpJplanFeeDto.setUseNatureCode(dbManager.getString(resultSet,45));
            prpJplanFeeDto.setCarProperty(dbManager.getDouble(resultSet,46));
            prpJplanFeeDto.setPayComCode(dbManager.getString(resultSet,47));
            prpJplanFeeDto.setBusinessType(dbManager.getString(resultSet,48));
            prpJplanFeeDto.setBusinessType1(dbManager.getString(resultSet,49));
        }
        resultSet.close();
        return prpJplanFeeDto;
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
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PayRefReason,");
        buffer.append("ClaimNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ContractNo,");
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("ValidDate,");
        buffer.append("PayNo,");
        buffer.append("Currency1,");
        buffer.append("PlanFee,");
        buffer.append("PlanDate,");
        buffer.append("ComCode,");
        buffer.append("MakeCom,");
        buffer.append("AgentCode,");
        buffer.append("Handler1Code,");
        buffer.append("HandlerCode,");
        buffer.append("UnderWriteDate,");
        buffer.append("CoinsFlag,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("CenterCode,");
        buffer.append("BranchCode,");
        buffer.append("AccBookType,");
        buffer.append("AccBookCode,");
        buffer.append("YearMonth,");
        buffer.append("VoucherNo,");
        buffer.append("ExchangeRate,");
        buffer.append("PlanFeeCNY,");
        buffer.append("PayRefFee,");
        buffer.append("RealPayRefFee,");
        buffer.append("Flag,");
        buffer.append("BusinessNature,");
        buffer.append("OthFlag,");
        buffer.append("CarNatureCode,");
        buffer.append("UseNatureCode,");
        buffer.append("CarProperty,");
        buffer.append("PayComCode,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1 ");
        buffer.append("FROM PrpJplanFee WHERE ");
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
        PrpJplanFeeDto prpJplanFeeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpJplanFeeDto = new PrpJplanFeeDto();
            prpJplanFeeDto.setCertiType(dbManager.getString(resultSet,1));
            prpJplanFeeDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJplanFeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJplanFeeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJplanFeeDto.setPayRefReason(dbManager.getString(resultSet,5));
            prpJplanFeeDto.setClaimNo(dbManager.getString(resultSet,6));
            prpJplanFeeDto.setClassCode(dbManager.getString(resultSet,7));
            prpJplanFeeDto.setRiskCode(dbManager.getString(resultSet,8));
            prpJplanFeeDto.setContractNo(dbManager.getString(resultSet,9));
            prpJplanFeeDto.setAppliCode(dbManager.getString(resultSet,10));
            prpJplanFeeDto.setAppliName(dbManager.getString(resultSet,11));
            prpJplanFeeDto.setInsuredCode(dbManager.getString(resultSet,12));
            prpJplanFeeDto.setInsuredName(dbManager.getString(resultSet,13));
            prpJplanFeeDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpJplanFeeDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJplanFeeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJplanFeeDto.setPayNo(dbManager.getInt(resultSet,17));
            prpJplanFeeDto.setCurrency1(dbManager.getString(resultSet,18));
            prpJplanFeeDto.setPlanFee(dbManager.getDouble(resultSet,19));
            prpJplanFeeDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpJplanFeeDto.setComCode(dbManager.getString(resultSet,21));
            prpJplanFeeDto.setMakeCom(dbManager.getString(resultSet,22));
            prpJplanFeeDto.setAgentCode(dbManager.getString(resultSet,23));
            prpJplanFeeDto.setHandler1Code(dbManager.getString(resultSet,24));
            prpJplanFeeDto.setHandlerCode(dbManager.getString(resultSet,25));
            prpJplanFeeDto.setUnderWriteDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpJplanFeeDto.setCoinsFlag(dbManager.getString(resultSet,27));
            prpJplanFeeDto.setCoinsCode(dbManager.getString(resultSet,28));
            prpJplanFeeDto.setCoinsName(dbManager.getString(resultSet,29));
            prpJplanFeeDto.setCoinsType(dbManager.getString(resultSet,30));
            prpJplanFeeDto.setCenterCode(dbManager.getString(resultSet,31));
            prpJplanFeeDto.setBranchCode(dbManager.getString(resultSet,32));
            prpJplanFeeDto.setAccBookType(dbManager.getString(resultSet,33));
            prpJplanFeeDto.setAccBookCode(dbManager.getString(resultSet,34));
            prpJplanFeeDto.setYearMonth(dbManager.getString(resultSet,35));
            prpJplanFeeDto.setVoucherNo(dbManager.getString(resultSet,36));
            prpJplanFeeDto.setExchangeRate(dbManager.getDouble(resultSet,37));
            prpJplanFeeDto.setPlanFeeCNY(dbManager.getDouble(resultSet,38));
            prpJplanFeeDto.setPayRefFee(dbManager.getDouble(resultSet,39));
            prpJplanFeeDto.setRealPayRefFee(dbManager.getDouble(resultSet,40));
            prpJplanFeeDto.setFlag(dbManager.getString(resultSet,41));
            prpJplanFeeDto.setBusinessNature(dbManager.getString(resultSet,42));
            prpJplanFeeDto.setOthFlag(dbManager.getString(resultSet,43));
            prpJplanFeeDto.setCarNatureCode(dbManager.getString(resultSet,44));
            prpJplanFeeDto.setUseNatureCode(dbManager.getString(resultSet,45));
            prpJplanFeeDto.setCarProperty(dbManager.getDouble(resultSet,46));
            prpJplanFeeDto.setPayComCode(dbManager.getString(resultSet,47));
            prpJplanFeeDto.setBusinessType(dbManager.getString(resultSet,48));
            prpJplanFeeDto.setBusinessType1(dbManager.getString(resultSet,49));
            collection.add(prpJplanFeeDto);
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
        buffer.append("DELETE FROM PrpJplanFee WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpJplanFee WHERE ");
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
