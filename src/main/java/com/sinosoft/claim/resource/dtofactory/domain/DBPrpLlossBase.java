package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLloss－赔付标的信息表的数据访问对象基类<br>
 * 创建于 2006-06-20 15:50:43.046<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLlossBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLlossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLlossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(PrpLlossDto prpLlossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLloss (");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LicenseNo,");
        buffer.append("ItemCode,");
        buffer.append("LossName,");
        buffer.append("ItemAddress,");
        buffer.append("FeeTypeCode,");
        buffer.append("FeeTypeName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitPrice,");
        buffer.append("BuyDate,");
        buffer.append("DepreRate,");
        buffer.append("Currency,");
        buffer.append("Amount,");
        buffer.append("Currency1,");
        buffer.append("ItemValue,");
        buffer.append("Currency2,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("ClaimRate,");
        buffer.append("Currency3,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("Currency4,");
        buffer.append("SumRealPay,");
        buffer.append("Flag,");
        buffer.append("RejectReason,");
        buffer.append("DutyDeductibleRate,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay, ");
        buffer.append("settleArea, ");
        buffer.append("lossrate, ");
        buffer.append("CISumRealPay,  ");
        buffer.append("BrandCode,  ");
        buffer.append("FamilyNoZH , ");
        buffer.append("coinsSumRealPaid,  ");
        buffer.append("Imei  ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLlossDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpLlossDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLlossDto.getItemKindNo()).append(",");
            debugBuffer.append("").append(prpLlossDto.getFamilyNo()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getFamilyName()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getItemCode()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getLossName()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getItemAddress()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getFeeTypeCode()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getFeeTypeName()).append("',");
            debugBuffer.append("").append(prpLlossDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getUnit()).append("',");
            debugBuffer.append("").append(prpLlossDto.getUnitPrice()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getBuyDate()).append("',");
            debugBuffer.append("").append(prpLlossDto.getDepreRate()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLlossDto.getAmount()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getCurrency1()).append("',");
            debugBuffer.append("").append(prpLlossDto.getItemValue()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getCurrency2()).append("',");
            debugBuffer.append("").append(prpLlossDto.getSumLoss()).append(",");
            debugBuffer.append("").append(prpLlossDto.getSumRest()).append(",");
            debugBuffer.append("").append(prpLlossDto.getIndemnityDutyRate()).append(",");
            debugBuffer.append("").append(prpLlossDto.getClaimRate()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getCurrency3()).append("',");
            debugBuffer.append("").append(prpLlossDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLlossDto.getDeductible()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getCurrency4()).append("',");
            debugBuffer.append("").append(prpLlossDto.getSumRealPay()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLlossDto.getRejectReason()).append("',");
            debugBuffer.append("").append(prpLlossDto.getDutyDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLlossDto.getDriverDeductibleRate()).append(",");
            debugBuffer.append("'").append(prpLlossDto.getRemark()).append("',");
            debugBuffer.append("").append(prpLlossDto.getArrangeRate()).append(",");
            debugBuffer.append("").append(prpLlossDto.getSumDefPay()).append(",");
            debugBuffer.append("").append(prpLlossDto.getSettleArea()).append(",");
            debugBuffer.append("").append(prpLlossDto.getLossrate()).append(",");
            debugBuffer.append("").append(prpLlossDto.getCISumRealPay()).append(",");
            debugBuffer.append("").append(prpLlossDto.getFamilyNoZH()).append(",");
            debugBuffer.append("").append(prpLlossDto.getImei()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLlossDto.getCompensateNo());
        dbManager.setString(2,prpLlossDto.getRiskCode());
        dbManager.setString(3,prpLlossDto.getPolicyNo());
        dbManager.setInt(4,prpLlossDto.getSerialNo());
        dbManager.setInt(5,prpLlossDto.getItemKindNo());
        dbManager.setInt(6,prpLlossDto.getFamilyNo());
        dbManager.setString(7,prpLlossDto.getFamilyName());
        dbManager.setString(8,prpLlossDto.getKindCode());
        dbManager.setString(9,prpLlossDto.getLicenseNo());
        dbManager.setString(10,prpLlossDto.getItemCode());
        dbManager.setString(11,prpLlossDto.getLossName());
        dbManager.setString(12,prpLlossDto.getItemAddress());
        dbManager.setString(13,prpLlossDto.getFeeTypeCode());
        dbManager.setString(14,prpLlossDto.getFeeTypeName());
        dbManager.setDouble(15,prpLlossDto.getLossQuantity());
        dbManager.setString(16,prpLlossDto.getUnit());
        dbManager.setDouble(17,prpLlossDto.getUnitPrice());
        dbManager.setDateTime(18,prpLlossDto.getBuyDate());
        dbManager.setDouble(19,prpLlossDto.getDepreRate());
        dbManager.setString(20,prpLlossDto.getCurrency());
        dbManager.setDouble(21,prpLlossDto.getAmount());
        dbManager.setString(22,prpLlossDto.getCurrency1());
        dbManager.setDouble(23,prpLlossDto.getItemValue());
        dbManager.setString(24,prpLlossDto.getCurrency2());
        dbManager.setDouble(25,prpLlossDto.getSumLoss());
        dbManager.setDouble(26,prpLlossDto.getSumRest());
        dbManager.setDouble(27,prpLlossDto.getIndemnityDutyRate());
        dbManager.setDouble(28,prpLlossDto.getClaimRate());
        dbManager.setString(29,prpLlossDto.getCurrency3());
        dbManager.setDouble(30,prpLlossDto.getDeductibleRate());
        dbManager.setDouble(31,prpLlossDto.getDeductible());
        dbManager.setString(32,prpLlossDto.getCurrency4());
        dbManager.setDouble(33,prpLlossDto.getSumRealPay());
        dbManager.setString(34,prpLlossDto.getFlag());
        dbManager.setString(35,prpLlossDto.getRejectReason());
        dbManager.setDouble(36,prpLlossDto.getDutyDeductibleRate());
        dbManager.setDouble(37,prpLlossDto.getDriverDeductibleRate());
        dbManager.setString(38,prpLlossDto.getRemark());
        dbManager.setDouble(39,prpLlossDto.getArrangeRate());
        dbManager.setDouble(40,prpLlossDto.getSumDefPay());
        dbManager.setDouble(41,prpLlossDto.getSettleArea());
        dbManager.setDouble(42,prpLlossDto.getLossrate());
        dbManager.setDouble(43,prpLlossDto.getCISumRealPay());
        dbManager.setString(44,prpLlossDto.getBrandCode());
        dbManager.setString(45,prpLlossDto.getFamilyNoZH());
        dbManager.setDouble(46,prpLlossDto.getCoinsSumRealPaid());
        dbManager.setString(46,prpLlossDto.getImei());
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
        buffer.append("INSERT INTO PrpLloss (");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LicenseNo,");
        buffer.append("ItemCode,");
        buffer.append("LossName,");
        buffer.append("ItemAddress,");
        buffer.append("FeeTypeCode,");
        buffer.append("FeeTypeName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitPrice,");
        buffer.append("BuyDate,");
        buffer.append("DepreRate,");
        buffer.append("Currency,");
        buffer.append("Amount,");
        buffer.append("Currency1,");
        buffer.append("ItemValue,");
        buffer.append("Currency2,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("ClaimRate,");
        buffer.append("Currency3,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("Currency4,");
        buffer.append("SumRealPay,");
        buffer.append("Flag,");
        buffer.append("RejectReason,");
        buffer.append("DutyDeductibleRate,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay, ");
        buffer.append("SettleArea, ");
        buffer.append("Lossrate, ");
        buffer.append("CISumRealPay,  ");
        buffer.append("BrandCode,  ");
        buffer.append("FamilyNoZH , ");
        buffer.append("coinsSumRealPaid,  ");
        buffer.append("Imei ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLlossDto prpLlossDto = (PrpLlossDto)i.next();
            dbManager.setString(1,prpLlossDto.getCompensateNo());
            dbManager.setString(2,prpLlossDto.getRiskCode());
            dbManager.setString(3,prpLlossDto.getPolicyNo());
            dbManager.setInt(4,prpLlossDto.getSerialNo());
            dbManager.setInt(5,prpLlossDto.getItemKindNo());
            dbManager.setInt(6,prpLlossDto.getFamilyNo());
            dbManager.setString(7,prpLlossDto.getFamilyName());
            dbManager.setString(8,prpLlossDto.getKindCode());
            dbManager.setString(9,prpLlossDto.getLicenseNo());
            dbManager.setString(10,prpLlossDto.getItemCode());
            dbManager.setString(11,prpLlossDto.getLossName());
            dbManager.setString(12,prpLlossDto.getItemAddress());
            dbManager.setString(13,prpLlossDto.getFeeTypeCode());
            dbManager.setString(14,prpLlossDto.getFeeTypeName());
            dbManager.setDouble(15,prpLlossDto.getLossQuantity());
            dbManager.setString(16,prpLlossDto.getUnit());
            dbManager.setDouble(17,prpLlossDto.getUnitPrice());
            dbManager.setDateTime(18,prpLlossDto.getBuyDate());
            dbManager.setDouble(19,prpLlossDto.getDepreRate());
            dbManager.setString(20,prpLlossDto.getCurrency());
            dbManager.setDouble(21,prpLlossDto.getAmount());
            dbManager.setString(22,prpLlossDto.getCurrency1());
            dbManager.setDouble(23,prpLlossDto.getItemValue());
            dbManager.setString(24,prpLlossDto.getCurrency2());
            dbManager.setDouble(25,prpLlossDto.getSumLoss());
            dbManager.setDouble(26,prpLlossDto.getSumRest());
            dbManager.setDouble(27,prpLlossDto.getIndemnityDutyRate());
            dbManager.setDouble(28,prpLlossDto.getClaimRate());
            dbManager.setString(29,prpLlossDto.getCurrency3());
            dbManager.setDouble(30,prpLlossDto.getDeductibleRate());
            dbManager.setDouble(31,prpLlossDto.getDeductible());
            dbManager.setString(32,prpLlossDto.getCurrency4());
            dbManager.setDouble(33,prpLlossDto.getSumRealPay());
            dbManager.setString(34,prpLlossDto.getFlag());
            dbManager.setString(35,prpLlossDto.getRejectReason());
            dbManager.setDouble(36,prpLlossDto.getDutyDeductibleRate());
            dbManager.setDouble(37,prpLlossDto.getDriverDeductibleRate());
            dbManager.setString(38,prpLlossDto.getRemark());
            dbManager.setDouble(39,prpLlossDto.getArrangeRate());
            dbManager.setDouble(40,prpLlossDto.getSumDefPay());
            dbManager.setDouble(41,prpLlossDto.getSettleArea());
            dbManager.setDouble(42,prpLlossDto.getLossrate());
            dbManager.setDouble(43,prpLlossDto.getCISumRealPay());
            dbManager.setString(44,prpLlossDto.getBrandCode());
            dbManager.setString(45,prpLlossDto.getFamilyNoZH());
            dbManager.setDouble(46, prpLlossDto.getCoinsSumRealPaid()) ; 
            dbManager.setString(47, prpLlossDto.getImei()) ; 
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLloss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(PrpLlossDto prpLlossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLloss SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("FamilyName = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("LicenseNo = ?, ");
        buffer.append("ItemCode = ?, ");
        buffer.append("LossName = ?, ");
        buffer.append("ItemAddress = ?, ");
        buffer.append("FeeTypeCode = ?, ");
        buffer.append("FeeTypeName = ?, ");
        buffer.append("LossQuantity = ?, ");
        buffer.append("Unit = ?, ");
        buffer.append("UnitPrice = ?, ");
        buffer.append("BuyDate = ?, ");
        buffer.append("DepreRate = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Currency1 = ?, ");
        buffer.append("ItemValue = ?, ");
        buffer.append("Currency2 = ?, ");
        buffer.append("SumLoss = ?, ");
        buffer.append("SumRest = ?, ");
        buffer.append("IndemnityDutyRate = ?, ");
        buffer.append("ClaimRate = ?, ");
        buffer.append("Currency3 = ?, ");
        buffer.append("DeductibleRate = ?, ");
        buffer.append("Deductible = ?, ");
        buffer.append("Currency4 = ?, ");
        buffer.append("SumRealPay = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("RejectReason = ?, ");
        buffer.append("DutyDeductibleRate = ?, ");
        buffer.append("DriverDeductibleRate = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("ArrangeRate = ?, ");
        buffer.append("SumDefPay = ?, ");
        buffer.append("SettleArea = ?, ");
        buffer.append("Lossrate = ?, ");
        buffer.append("CISumRealPay = ?,");
        buffer.append("BrandCode = ?,");
        buffer.append("FamilyNoZH = ? , ");
        buffer.append("coinsSumRealPaid = ?,  ");
        buffer.append("Imei = ?  ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLloss SET ");
            debugBuffer.append("RiskCode = '" + prpLlossDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLlossDto.getPolicyNo() + "', ");
            debugBuffer.append("ItemKindNo = " + prpLlossDto.getItemKindNo() + ", ");
            debugBuffer.append("FamilyNo = " + prpLlossDto.getFamilyNo() + ", ");
            debugBuffer.append("FamilyName = '" + prpLlossDto.getFamilyName() + "', ");
            debugBuffer.append("KindCode = '" + prpLlossDto.getKindCode() + "', ");
            debugBuffer.append("LicenseNo = '" + prpLlossDto.getLicenseNo() + "', ");
            debugBuffer.append("ItemCode = '" + prpLlossDto.getItemCode() + "', ");
            debugBuffer.append("LossName = '" + prpLlossDto.getLossName() + "', ");
            debugBuffer.append("ItemAddress = '" + prpLlossDto.getItemAddress() + "', ");
            debugBuffer.append("FeeTypeCode = '" + prpLlossDto.getFeeTypeCode() + "', ");
            debugBuffer.append("FeeTypeName = '" + prpLlossDto.getFeeTypeName() + "', ");
            debugBuffer.append("LossQuantity = " + prpLlossDto.getLossQuantity() + ", ");
            debugBuffer.append("Unit = '" + prpLlossDto.getUnit() + "', ");
            debugBuffer.append("UnitPrice = " + prpLlossDto.getUnitPrice() + ", ");
            debugBuffer.append("BuyDate = '" + prpLlossDto.getBuyDate() + "', ");
            debugBuffer.append("DepreRate = " + prpLlossDto.getDepreRate() + ", ");
            debugBuffer.append("Currency = '" + prpLlossDto.getCurrency() + "', ");
            debugBuffer.append("Amount = " + prpLlossDto.getAmount() + ", ");
            debugBuffer.append("Currency1 = '" + prpLlossDto.getCurrency1() + "', ");
            debugBuffer.append("ItemValue = " + prpLlossDto.getItemValue() + ", ");
            debugBuffer.append("Currency2 = '" + prpLlossDto.getCurrency2() + "', ");
            debugBuffer.append("SumLoss = " + prpLlossDto.getSumLoss() + ", ");
            debugBuffer.append("SumRest = " + prpLlossDto.getSumRest() + ", ");
            debugBuffer.append("IndemnityDutyRate = " + prpLlossDto.getIndemnityDutyRate() + ", ");
            debugBuffer.append("ClaimRate = " + prpLlossDto.getClaimRate() + ", ");
            debugBuffer.append("Currency3 = '" + prpLlossDto.getCurrency3() + "', ");
            debugBuffer.append("DeductibleRate = " + prpLlossDto.getDeductibleRate() + ", ");
            debugBuffer.append("Deductible = " + prpLlossDto.getDeductible() + ", ");
            debugBuffer.append("Currency4 = '" + prpLlossDto.getCurrency4() + "', ");
            debugBuffer.append("SumRealPay = " + prpLlossDto.getSumRealPay() + ", ");
            debugBuffer.append("Flag = '" + prpLlossDto.getFlag() + "', ");
            debugBuffer.append("RejectReason = '" + prpLlossDto.getRejectReason() + "', ");
            debugBuffer.append("DutyDeductibleRate = " + prpLlossDto.getDutyDeductibleRate() + ", ");
            debugBuffer.append("DriverDeductibleRate = " + prpLlossDto.getDriverDeductibleRate() + ", ");
            debugBuffer.append("Remark = '" + prpLlossDto.getRemark() + "', ");
            debugBuffer.append("ArrangeRate = " + prpLlossDto.getArrangeRate() + ", ");
            debugBuffer.append("SumDefPay = " + prpLlossDto.getSumDefPay() + ", ");
            debugBuffer.append("SettleArea = " + prpLlossDto.getSettleArea() + ", ");
            debugBuffer.append("Lossrate = " + prpLlossDto.getLossrate() + ", ");
            debugBuffer.append("CISumRealPay = " + prpLlossDto.getCISumRealPay() + ", ");
            debugBuffer.append("FamilyNoZH = " + prpLlossDto.getFamilyNo() + ", ");
            debugBuffer.append("Imei = " + prpLlossDto.getImei() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLlossDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLlossDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLlossDto.getRiskCode());
        dbManager.setString(2,prpLlossDto.getPolicyNo());
        dbManager.setInt(3,prpLlossDto.getItemKindNo());
        dbManager.setInt(4,prpLlossDto.getFamilyNo());
        dbManager.setString(5,prpLlossDto.getFamilyName());
        dbManager.setString(6,prpLlossDto.getKindCode());
        dbManager.setString(7,prpLlossDto.getLicenseNo());
        dbManager.setString(8,prpLlossDto.getItemCode());
        dbManager.setString(9,prpLlossDto.getLossName());
        dbManager.setString(10,prpLlossDto.getItemAddress());
        dbManager.setString(11,prpLlossDto.getFeeTypeCode());
        dbManager.setString(12,prpLlossDto.getFeeTypeName());
        dbManager.setDouble(13,prpLlossDto.getLossQuantity());
        dbManager.setString(14,prpLlossDto.getUnit());
        dbManager.setDouble(15,prpLlossDto.getUnitPrice());
        dbManager.setDateTime(16,prpLlossDto.getBuyDate());
        dbManager.setDouble(17,prpLlossDto.getDepreRate());
        dbManager.setString(18,prpLlossDto.getCurrency());
        dbManager.setDouble(19,prpLlossDto.getAmount());
        dbManager.setString(20,prpLlossDto.getCurrency1());
        dbManager.setDouble(21,prpLlossDto.getItemValue());
        dbManager.setString(22,prpLlossDto.getCurrency2());
        dbManager.setDouble(23,prpLlossDto.getSumLoss());
        dbManager.setDouble(24,prpLlossDto.getSumRest());
        dbManager.setDouble(25,prpLlossDto.getIndemnityDutyRate());
        dbManager.setDouble(26,prpLlossDto.getClaimRate());
        dbManager.setString(27,prpLlossDto.getCurrency3());
        dbManager.setDouble(28,prpLlossDto.getDeductibleRate());
        dbManager.setDouble(29,prpLlossDto.getDeductible());
        dbManager.setString(30,prpLlossDto.getCurrency4());
        dbManager.setDouble(31,prpLlossDto.getSumRealPay());
        dbManager.setString(32,prpLlossDto.getFlag());
        dbManager.setString(33,prpLlossDto.getRejectReason());
        dbManager.setDouble(34,prpLlossDto.getDutyDeductibleRate());
        dbManager.setDouble(35,prpLlossDto.getDriverDeductibleRate());
        dbManager.setString(36,prpLlossDto.getRemark());
        dbManager.setDouble(37,prpLlossDto.getArrangeRate());
        dbManager.setDouble(38,prpLlossDto.getSumDefPay());
        dbManager.setDouble(39,prpLlossDto.getSettleArea());
        dbManager.setDouble(40,prpLlossDto.getLossrate());
        dbManager.setDouble(41,prpLlossDto.getCISumRealPay());
        dbManager.setString(42,prpLlossDto.getBrandCode());
        dbManager.setString(43,prpLlossDto.getFamilyNoZH());
        dbManager.setDouble(44,prpLlossDto.getCoinsSumRealPaid());
        dbManager.setString(45,prpLlossDto.getImei());
        //设置条件字段;
        dbManager.setString(46,prpLlossDto.getCompensateNo());
        dbManager.setInt(47,prpLlossDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return PrpLlossDto
     * @throws Exception
     */
    public PrpLlossDto findByPrimaryKey(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LicenseNo,");
        buffer.append("ItemCode,");
        buffer.append("LossName,");
        buffer.append("ItemAddress,");
        buffer.append("FeeTypeCode,");
        buffer.append("FeeTypeName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitPrice,");
        buffer.append("BuyDate,");
        buffer.append("DepreRate,");
        buffer.append("Currency,");
        buffer.append("Amount,");
        buffer.append("Currency1,");
        buffer.append("ItemValue,");
        buffer.append("Currency2,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("ClaimRate,");
        buffer.append("Currency3,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("Currency4,");
        buffer.append("SumRealPay,");
        buffer.append("Flag,");
        buffer.append("RejectReason,");
        buffer.append("DutyDeductibleRate,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay, ");
        buffer.append("SettleArea, ");
        buffer.append("Lossrate, ");
        buffer.append("CISumRealPay, ");
        buffer.append("BrandCode, ");
        buffer.append("FamilyNoZH, ");
        buffer.append("sumallrealpay , ");
        buffer.append("coinsSumRealPaid , ");
        buffer.append("Imei  ");
        buffer.append("FROM PrpLloss ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLlossDto prpLlossDto = null;
        if(resultSet.next()){
            prpLlossDto = new PrpLlossDto();
            prpLlossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLlossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLlossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLlossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLlossDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLlossDto.setFamilyNo(dbManager.getInt(resultSet,6));
            prpLlossDto.setFamilyName(dbManager.getString(resultSet,7));
            prpLlossDto.setKindCode(dbManager.getString(resultSet,8));
            prpLlossDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLlossDto.setItemCode(dbManager.getString(resultSet,10));
            prpLlossDto.setLossName(dbManager.getString(resultSet,11));
            prpLlossDto.setItemAddress(dbManager.getString(resultSet,12));
            prpLlossDto.setFeeTypeCode(dbManager.getString(resultSet,13));
            prpLlossDto.setFeeTypeName(dbManager.getString(resultSet,14));
            prpLlossDto.setLossQuantity(dbManager.getDouble(resultSet,15));
            prpLlossDto.setUnit(dbManager.getString(resultSet,16));
            prpLlossDto.setUnitPrice(dbManager.getDouble(resultSet,17));
            prpLlossDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLlossDto.setDepreRate(dbManager.getDouble(resultSet,19));
            prpLlossDto.setCurrency(dbManager.getString(resultSet,20));
            prpLlossDto.setAmount(dbManager.getDouble(resultSet,21));
            prpLlossDto.setCurrency1(dbManager.getString(resultSet,22));
            prpLlossDto.setItemValue(dbManager.getDouble(resultSet,23));
            prpLlossDto.setCurrency2(dbManager.getString(resultSet,24));
            prpLlossDto.setSumLoss(dbManager.getDouble(resultSet,25));
            prpLlossDto.setSumRest(dbManager.getDouble(resultSet,26));
            prpLlossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,27));
            prpLlossDto.setClaimRate(dbManager.getDouble(resultSet,28));
            prpLlossDto.setCurrency3(dbManager.getString(resultSet,29));
            prpLlossDto.setDeductibleRate(dbManager.getDouble(resultSet,30));
            prpLlossDto.setDeductible(dbManager.getDouble(resultSet,31));
            prpLlossDto.setCurrency4(dbManager.getString(resultSet,32));
            prpLlossDto.setSumRealPay(dbManager.getDouble(resultSet,33));
            prpLlossDto.setFlag(dbManager.getString(resultSet,34));
            prpLlossDto.setRejectReason(dbManager.getString(resultSet,35));
            prpLlossDto.setDutyDeductibleRate(dbManager.getDouble(resultSet,36));
            prpLlossDto.setDriverDeductibleRate(dbManager.getDouble(resultSet,37));
            prpLlossDto.setRemark(dbManager.getString(resultSet,38));
            prpLlossDto.setArrangeRate(dbManager.getDouble(resultSet,39));
            prpLlossDto.setSumDefPay(dbManager.getDouble(resultSet,40));
            prpLlossDto.setSettleArea(dbManager.getDouble(resultSet,41));
            prpLlossDto.setLossrate(dbManager.getDouble(resultSet,42));
            prpLlossDto.setCISumRealPay(dbManager.getDouble(resultSet,43));
            prpLlossDto.setBrandCode(dbManager.getString(resultSet,44));
            prpLlossDto.setFamilyNoZH(dbManager.getString(resultSet,45));
            prpLlossDto.setSumAllRealpay(dbManager.getDouble(resultSet,46));
            prpLlossDto.setCoinsSumRealPaid(dbManager.getDouble(resultSet,47));
            prpLlossDto.setImei(dbManager.getString(resultSet,48));
        }
        resultSet.close();
        return prpLlossDto;
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
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LicenseNo,");
        buffer.append("ItemCode,");
        buffer.append("LossName,");
        buffer.append("ItemAddress,");
        buffer.append("FeeTypeCode,");
        buffer.append("FeeTypeName,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitPrice,");
        buffer.append("BuyDate,");
        buffer.append("DepreRate,");
        buffer.append("Currency,");
        buffer.append("Amount,");
        buffer.append("Currency1,");
        buffer.append("ItemValue,");
        buffer.append("Currency2,");
        buffer.append("SumLoss,");
        buffer.append("SumRest,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("ClaimRate,");
        buffer.append("Currency3,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("Currency4,");
        buffer.append("SumRealPay,");
        buffer.append("Flag,");
        buffer.append("RejectReason,");
        buffer.append("DutyDeductibleRate,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay, ");
        buffer.append("SettleArea, ");
        buffer.append("Lossrate, ");
        buffer.append("CISumRealPay,  ");
        buffer.append("BrandCode,  ");
        buffer.append("FamilyNoZH, ");
        buffer.append("sumallrealpay , ");
        buffer.append("coinsSumRealPaid , ");
        buffer.append("Imei  ");
        buffer.append("FROM PrpLloss WHERE ");
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
        PrpLlossDto prpLlossDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLlossDto = new PrpLlossDto();
            prpLlossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLlossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLlossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLlossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLlossDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpLlossDto.setFamilyNo(dbManager.getInt(resultSet,6));
            prpLlossDto.setFamilyName(dbManager.getString(resultSet,7));
            prpLlossDto.setKindCode(dbManager.getString(resultSet,8));
            prpLlossDto.setLicenseNo(dbManager.getString(resultSet,9));
            prpLlossDto.setItemCode(dbManager.getString(resultSet,10));
            prpLlossDto.setLossName(dbManager.getString(resultSet,11));
            prpLlossDto.setItemAddress(dbManager.getString(resultSet,12));
            prpLlossDto.setFeeTypeCode(dbManager.getString(resultSet,13));
            prpLlossDto.setFeeTypeName(dbManager.getString(resultSet,14));
            prpLlossDto.setLossQuantity(dbManager.getDouble(resultSet,15));
            prpLlossDto.setUnit(dbManager.getString(resultSet,16));
            prpLlossDto.setUnitPrice(dbManager.getDouble(resultSet,17));
            prpLlossDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLlossDto.setDepreRate(dbManager.getDouble(resultSet,19));
            prpLlossDto.setCurrency(dbManager.getString(resultSet,20));
            prpLlossDto.setAmount(dbManager.getDouble(resultSet,21));
            prpLlossDto.setCurrency1(dbManager.getString(resultSet,22));
            prpLlossDto.setItemValue(dbManager.getDouble(resultSet,23));
            prpLlossDto.setCurrency2(dbManager.getString(resultSet,24));
            prpLlossDto.setSumLoss(dbManager.getDouble(resultSet,25));
            prpLlossDto.setSumRest(dbManager.getDouble(resultSet,26));
            prpLlossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,27));
            prpLlossDto.setClaimRate(dbManager.getDouble(resultSet,28));
            prpLlossDto.setCurrency3(dbManager.getString(resultSet,29));
            prpLlossDto.setDeductibleRate(dbManager.getDouble(resultSet,30));
            prpLlossDto.setDeductible(dbManager.getDouble(resultSet,31));
            prpLlossDto.setCurrency4(dbManager.getString(resultSet,32));
            prpLlossDto.setSumRealPay(dbManager.getDouble(resultSet,33));
            prpLlossDto.setFlag(dbManager.getString(resultSet,34));
            prpLlossDto.setRejectReason(dbManager.getString(resultSet,35));
            prpLlossDto.setDutyDeductibleRate(dbManager.getDouble(resultSet,36));
            prpLlossDto.setDriverDeductibleRate(dbManager.getDouble(resultSet,37));
            prpLlossDto.setRemark(dbManager.getString(resultSet,38));
            prpLlossDto.setArrangeRate(dbManager.getDouble(resultSet,39));
            prpLlossDto.setSumDefPay(dbManager.getDouble(resultSet,40));
            prpLlossDto.setSettleArea(dbManager.getDouble(resultSet,41));
            prpLlossDto.setLossrate(dbManager.getDouble(resultSet,42));
            prpLlossDto.setCISumRealPay(dbManager.getDouble(resultSet, 43));
            prpLlossDto.setBrandCode(dbManager.getString(resultSet,44));
            prpLlossDto.setFamilyNoZH(dbManager.getString(resultSet,45));
            prpLlossDto.setSumAllRealpay(dbManager.getDouble(resultSet,46));
            prpLlossDto.setCoinsSumRealPaid(dbManager.getDouble(resultSet,47));
            prpLlossDto.setImei(dbManager.getString(resultSet,48));
            collection.add(prpLlossDto);
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
        buffer.append("DELETE FROM PrpLloss WHERE ");
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
        statement = "SELECT count(1) FROM PrpLloss WHERE ";
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
