package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLpersonLoss－人员赔付信息表的数据访问对象基类<br>
 * 创建于 2006-06-20 15:18:35.734<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpersonLossBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLpersonLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpersonLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void insert(PrpLpersonLossDto prpLpersonLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpersonLoss (");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PersonNo,");
        buffer.append("PersonName,");
        buffer.append("IdentifyNumber,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LiabCode,");
        buffer.append("LiabName,");
        buffer.append("JobCode,");
        buffer.append("JobName,");
        buffer.append("LiabDetailCode,");
        buffer.append("LiabDetailName,");
        buffer.append("ItemAddress,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitAmount,");
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
        buffer.append("DutyDeductibleRate,");
        buffer.append("InjuryGrade,");
        buffer.append("InjuryScopeDesc,");
        buffer.append("InHospDate,");
        buffer.append("OutHospDate,");
        buffer.append("Hospital,");
        buffer.append("HospitalDays,");
        buffer.append("RejectReason,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Maxpaid,");
        buffer.append("Hispaid,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay,");
        buffer.append("FeeCategory, ");
        buffer.append("CISumRealPay  ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpersonLossDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getPersonNo()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getPersonName()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getIdentifyNumber()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getSex()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getAge()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getItemKindNo()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getFamilyNo()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getFamilyName()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getLiabCode()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getLiabName()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getJobCode()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getJobName()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getLiabDetailCode()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getLiabDetailName()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getItemAddress()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getLossQuantity()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getUnit()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getUnitAmount()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getAmount()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getCurrency1()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getItemValue()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getCurrency2()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getSumLoss()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getSumRest()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getIndemnityDutyRate()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getClaimRate()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getCurrency3()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getDeductible()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getCurrency4()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getSumRealPay()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getFlag()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getDutyDeductibleRate()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getInjuryGrade()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getInjuryScopeDesc()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getInHospDate()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getOutHospDate()).append("',");
            debugBuffer.append("'").append(prpLpersonLossDto.getHospital()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getHospitalDays()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getRejectReason()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getDriverDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getMaxpaid()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getHispaid()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getRemark()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getArrangeRate()).append(",");
            debugBuffer.append("").append(prpLpersonLossDto.getSumDefPay()).append(",");
            debugBuffer.append("'").append(prpLpersonLossDto.getFeeCategory()).append("',");
            debugBuffer.append("").append(prpLpersonLossDto.getCISumRealPay()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpersonLossDto.getCompensateNo());
        dbManager.setString(2,prpLpersonLossDto.getRiskCode());
        dbManager.setString(3,prpLpersonLossDto.getPolicyNo());
        dbManager.setInt(4,prpLpersonLossDto.getSerialNo());
        dbManager.setInt(5,prpLpersonLossDto.getPersonNo());
        dbManager.setString(6,prpLpersonLossDto.getPersonName());
        dbManager.setString(7,prpLpersonLossDto.getIdentifyNumber());
        dbManager.setString(8,prpLpersonLossDto.getSex());
        dbManager.setInt(9,prpLpersonLossDto.getAge());
        dbManager.setInt(10,prpLpersonLossDto.getItemKindNo());
        dbManager.setInt(11,prpLpersonLossDto.getFamilyNo());
        dbManager.setString(12,prpLpersonLossDto.getFamilyName());
        dbManager.setString(13,prpLpersonLossDto.getKindCode());
        dbManager.setString(14,prpLpersonLossDto.getLiabCode());
        dbManager.setString(15,prpLpersonLossDto.getLiabName());
        dbManager.setString(16,prpLpersonLossDto.getJobCode());
        dbManager.setString(17,prpLpersonLossDto.getJobName());
        dbManager.setString(18,prpLpersonLossDto.getLiabDetailCode());
        dbManager.setString(19,prpLpersonLossDto.getLiabDetailName());
        dbManager.setString(20,prpLpersonLossDto.getItemAddress());
        dbManager.setInt(21,prpLpersonLossDto.getLossQuantity());
        dbManager.setString(22,prpLpersonLossDto.getUnit());
        dbManager.setDouble(23,prpLpersonLossDto.getUnitAmount());
        dbManager.setString(24,prpLpersonLossDto.getCurrency());
        dbManager.setDouble(25,prpLpersonLossDto.getAmount());
        dbManager.setString(26,prpLpersonLossDto.getCurrency1());
        dbManager.setDouble(27,prpLpersonLossDto.getItemValue());
        dbManager.setString(28,prpLpersonLossDto.getCurrency2());
        dbManager.setDouble(29,prpLpersonLossDto.getSumLoss());
        dbManager.setDouble(30,prpLpersonLossDto.getSumRest());
        dbManager.setDouble(31,prpLpersonLossDto.getIndemnityDutyRate());
        dbManager.setDouble(32,prpLpersonLossDto.getClaimRate());
        dbManager.setString(33,prpLpersonLossDto.getCurrency3());
        dbManager.setDouble(34,prpLpersonLossDto.getDeductibleRate());
        dbManager.setDouble(35,prpLpersonLossDto.getDeductible());
        dbManager.setString(36,prpLpersonLossDto.getCurrency4());
        dbManager.setDouble(37,prpLpersonLossDto.getSumRealPay());
        dbManager.setString(38,prpLpersonLossDto.getFlag());
        dbManager.setDouble(39,prpLpersonLossDto.getDutyDeductibleRate());
        dbManager.setString(40,prpLpersonLossDto.getInjuryGrade());
        dbManager.setString(41,prpLpersonLossDto.getInjuryScopeDesc());
        dbManager.setDateTime(42,prpLpersonLossDto.getInHospDate());
        dbManager.setDateTime(43,prpLpersonLossDto.getOutHospDate());
        dbManager.setString(44,prpLpersonLossDto.getHospital());
        dbManager.setInt(45,prpLpersonLossDto.getHospitalDays());
        dbManager.setString(46,prpLpersonLossDto.getRejectReason());
        dbManager.setDouble(47,prpLpersonLossDto.getDriverDeductibleRate());
        dbManager.setDouble(48,prpLpersonLossDto.getMaxpaid());
        dbManager.setDouble(49,prpLpersonLossDto.getHispaid());
        dbManager.setString(50,prpLpersonLossDto.getRemark());
        dbManager.setDouble(51,prpLpersonLossDto.getArrangeRate());
        dbManager.setDouble(52,prpLpersonLossDto.getSumDefPay());
        dbManager.setString(53,prpLpersonLossDto.getFeeCategory());
        dbManager.setDouble(54,prpLpersonLossDto.getCISumRealPay());
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
        buffer.append("INSERT INTO PrpLpersonLoss (");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PersonNo,");
        buffer.append("PersonName,");
        buffer.append("IdentifyNumber,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LiabCode,");
        buffer.append("LiabName,");
        buffer.append("JobCode,");
        buffer.append("JobName,");
        buffer.append("LiabDetailCode,");
        buffer.append("LiabDetailName,");
        buffer.append("ItemAddress,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitAmount,");
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
        buffer.append("DutyDeductibleRate,");
        buffer.append("InjuryGrade,");
        buffer.append("InjuryScopeDesc,");
        buffer.append("InHospDate,");
        buffer.append("OutHospDate,");
        buffer.append("Hospital,");
        buffer.append("HospitalDays,");
        buffer.append("RejectReason,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Maxpaid,");
        buffer.append("Hispaid,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay,");
        buffer.append("FeeCategory, ");
        buffer.append("CISumRealPay, ");
        buffer.append("hospitalCode, ");
        buffer.append("diseaseCode  ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)i.next();
            dbManager.setString(1,prpLpersonLossDto.getCompensateNo());
            dbManager.setString(2,prpLpersonLossDto.getRiskCode());
            dbManager.setString(3,prpLpersonLossDto.getPolicyNo());
            dbManager.setInt(4,prpLpersonLossDto.getSerialNo());
            dbManager.setInt(5,prpLpersonLossDto.getPersonNo());
            dbManager.setString(6,prpLpersonLossDto.getPersonName());
            dbManager.setString(7,prpLpersonLossDto.getIdentifyNumber());
            dbManager.setString(8,prpLpersonLossDto.getSex());
            dbManager.setInt(9,prpLpersonLossDto.getAge());
            dbManager.setInt(10,prpLpersonLossDto.getItemKindNo());
            dbManager.setInt(11,prpLpersonLossDto.getFamilyNo());
            dbManager.setString(12,prpLpersonLossDto.getFamilyName());
            dbManager.setString(13,prpLpersonLossDto.getKindCode());
            dbManager.setString(14,prpLpersonLossDto.getLiabCode());
            dbManager.setString(15,prpLpersonLossDto.getLiabName());
            dbManager.setString(16,prpLpersonLossDto.getJobCode());
            dbManager.setString(17,prpLpersonLossDto.getJobName());
            dbManager.setString(18,prpLpersonLossDto.getLiabDetailCode());
            dbManager.setString(19,prpLpersonLossDto.getLiabDetailName());
            dbManager.setString(20,prpLpersonLossDto.getItemAddress());
            dbManager.setInt(21,prpLpersonLossDto.getLossQuantity());
            dbManager.setString(22,prpLpersonLossDto.getUnit());
            dbManager.setDouble(23,prpLpersonLossDto.getUnitAmount());
            dbManager.setString(24,prpLpersonLossDto.getCurrency());
            dbManager.setDouble(25,prpLpersonLossDto.getAmount());
            dbManager.setString(26,prpLpersonLossDto.getCurrency1());
            dbManager.setDouble(27,prpLpersonLossDto.getItemValue());
            dbManager.setString(28,prpLpersonLossDto.getCurrency2());
            dbManager.setDouble(29,prpLpersonLossDto.getSumLoss());
            dbManager.setDouble(30,prpLpersonLossDto.getSumRest());
            dbManager.setDouble(31,prpLpersonLossDto.getIndemnityDutyRate());
            dbManager.setDouble(32,prpLpersonLossDto.getClaimRate());
            dbManager.setString(33,prpLpersonLossDto.getCurrency3());
            dbManager.setDouble(34,prpLpersonLossDto.getDeductibleRate());
            dbManager.setDouble(35,prpLpersonLossDto.getDeductible());
            dbManager.setString(36,prpLpersonLossDto.getCurrency4());
            dbManager.setDouble(37,prpLpersonLossDto.getSumRealPay());
            dbManager.setString(38,prpLpersonLossDto.getFlag());
            dbManager.setDouble(39,prpLpersonLossDto.getDutyDeductibleRate());
            dbManager.setString(40,prpLpersonLossDto.getInjuryGrade());
            dbManager.setString(41,prpLpersonLossDto.getInjuryScopeDesc());
            dbManager.setDateTime(42,prpLpersonLossDto.getInHospDate());
            dbManager.setDateTime(43,prpLpersonLossDto.getOutHospDate());
            dbManager.setString(44,prpLpersonLossDto.getHospital());
            dbManager.setInt(45,prpLpersonLossDto.getHospitalDays());
            dbManager.setString(46,prpLpersonLossDto.getRejectReason());
            dbManager.setDouble(47,prpLpersonLossDto.getDriverDeductibleRate());
            dbManager.setDouble(48,prpLpersonLossDto.getMaxpaid());
            dbManager.setDouble(49,prpLpersonLossDto.getHispaid());
            dbManager.setString(50,prpLpersonLossDto.getRemark());
            dbManager.setDouble(51,prpLpersonLossDto.getArrangeRate());
            dbManager.setDouble(52,prpLpersonLossDto.getSumDefPay());
            dbManager.setString(53,prpLpersonLossDto.getFeeCategory());
            dbManager.setDouble(54,prpLpersonLossDto.getCISumRealPay());
            dbManager.setString(55,prpLpersonLossDto.getHospitalCode());
            dbManager.setString(56,prpLpersonLossDto.getDiseaseCode());
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
        buffer.append("DELETE FROM PrpLpersonLoss ");
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
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void update(PrpLpersonLossDto prpLpersonLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpersonLoss SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("PersonNo = ?, ");
        buffer.append("PersonName = ?, ");
        buffer.append("IdentifyNumber = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("Age = ?, ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("FamilyName = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("LiabCode = ?, ");
        buffer.append("LiabName = ?, ");
        buffer.append("JobCode = ?, ");
        buffer.append("JobName = ?, ");
        buffer.append("LiabDetailCode = ?, ");
        buffer.append("LiabDetailName = ?, ");
        buffer.append("ItemAddress = ?, ");
        buffer.append("LossQuantity = ?, ");
        buffer.append("Unit = ?, ");
        buffer.append("UnitAmount = ?, ");
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
        buffer.append("DutyDeductibleRate = ?, ");
        buffer.append("InjuryGrade = ?, ");
        buffer.append("InjuryScopeDesc = ?, ");
        buffer.append("InHospDate = ?, ");
        buffer.append("OutHospDate = ?, ");
        buffer.append("Hospital = ?, ");
        buffer.append("HospitalDays = ?, ");
        buffer.append("RejectReason = ?, ");
        buffer.append("DriverDeductibleRate = ?, ");
        buffer.append("Maxpaid = ?, ");
        buffer.append("Hispaid = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("ArrangeRate = ?, ");
        buffer.append("SumDefPay = ?, ");
        buffer.append("FeeCategory = ?, ");
        buffer.append("CISumRealPay = ?  ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpersonLoss SET ");
            debugBuffer.append("RiskCode = '" + prpLpersonLossDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLpersonLossDto.getPolicyNo() + "', ");
            debugBuffer.append("PersonNo = " + prpLpersonLossDto.getPersonNo() + ", ");
            debugBuffer.append("PersonName = '" + prpLpersonLossDto.getPersonName() + "', ");
            debugBuffer.append("IdentifyNumber = '" + prpLpersonLossDto.getIdentifyNumber() + "', ");
            debugBuffer.append("Sex = '" + prpLpersonLossDto.getSex() + "', ");
            debugBuffer.append("Age = " + prpLpersonLossDto.getAge() + ", ");
            debugBuffer.append("ItemKindNo = " + prpLpersonLossDto.getItemKindNo() + ", ");
            debugBuffer.append("FamilyNo = " + prpLpersonLossDto.getFamilyNo() + ", ");
            debugBuffer.append("FamilyName = '" + prpLpersonLossDto.getFamilyName() + "', ");
            debugBuffer.append("KindCode = '" + prpLpersonLossDto.getKindCode() + "', ");
            debugBuffer.append("LiabCode = '" + prpLpersonLossDto.getLiabCode() + "', ");
            debugBuffer.append("LiabName = '" + prpLpersonLossDto.getLiabName() + "', ");
            debugBuffer.append("JobCode = '" + prpLpersonLossDto.getJobCode() + "', ");
            debugBuffer.append("JobName = '" + prpLpersonLossDto.getJobName() + "', ");
            debugBuffer.append("LiabDetailCode = '" + prpLpersonLossDto.getLiabDetailCode() + "', ");
            debugBuffer.append("LiabDetailName = '" + prpLpersonLossDto.getLiabDetailName() + "', ");
            debugBuffer.append("ItemAddress = '" + prpLpersonLossDto.getItemAddress() + "', ");
            debugBuffer.append("LossQuantity = " + prpLpersonLossDto.getLossQuantity() + ", ");
            debugBuffer.append("Unit = '" + prpLpersonLossDto.getUnit() + "', ");
            debugBuffer.append("UnitAmount = " + prpLpersonLossDto.getUnitAmount() + ", ");
            debugBuffer.append("Currency = '" + prpLpersonLossDto.getCurrency() + "', ");
            debugBuffer.append("Amount = " + prpLpersonLossDto.getAmount() + ", ");
            debugBuffer.append("Currency1 = '" + prpLpersonLossDto.getCurrency1() + "', ");
            debugBuffer.append("ItemValue = " + prpLpersonLossDto.getItemValue() + ", ");
            debugBuffer.append("Currency2 = '" + prpLpersonLossDto.getCurrency2() + "', ");
            debugBuffer.append("SumLoss = " + prpLpersonLossDto.getSumLoss() + ", ");
            debugBuffer.append("SumRest = " + prpLpersonLossDto.getSumRest() + ", ");
            debugBuffer.append("IndemnityDutyRate = " + prpLpersonLossDto.getIndemnityDutyRate() + ", ");
            debugBuffer.append("ClaimRate = " + prpLpersonLossDto.getClaimRate() + ", ");
            debugBuffer.append("Currency3 = '" + prpLpersonLossDto.getCurrency3() + "', ");
            debugBuffer.append("DeductibleRate = " + prpLpersonLossDto.getDeductibleRate() + ", ");
            debugBuffer.append("Deductible = " + prpLpersonLossDto.getDeductible() + ", ");
            debugBuffer.append("Currency4 = '" + prpLpersonLossDto.getCurrency4() + "', ");
            debugBuffer.append("SumRealPay = " + prpLpersonLossDto.getSumRealPay() + ", ");
            debugBuffer.append("Flag = '" + prpLpersonLossDto.getFlag() + "', ");
            debugBuffer.append("DutyDeductibleRate = " + prpLpersonLossDto.getDutyDeductibleRate() + ", ");
            debugBuffer.append("InjuryGrade = '" + prpLpersonLossDto.getInjuryGrade() + "', ");
            debugBuffer.append("InjuryScopeDesc = '" + prpLpersonLossDto.getInjuryScopeDesc() + "', ");
            debugBuffer.append("InHospDate = '" + prpLpersonLossDto.getInHospDate() + "', ");
            debugBuffer.append("OutHospDate = '" + prpLpersonLossDto.getOutHospDate() + "', ");
            debugBuffer.append("Hospital = '" + prpLpersonLossDto.getHospital() + "', ");
            debugBuffer.append("HospitalDays = " + prpLpersonLossDto.getHospitalDays() + ", ");
            debugBuffer.append("RejectReason = '" + prpLpersonLossDto.getRejectReason() + "', ");
            debugBuffer.append("DriverDeductibleRate = " + prpLpersonLossDto.getDriverDeductibleRate() + ", ");
            debugBuffer.append("Maxpaid = " + prpLpersonLossDto.getMaxpaid() + ", ");
            debugBuffer.append("Hispaid = " + prpLpersonLossDto.getHispaid() + ", ");
            debugBuffer.append("Remark = '" + prpLpersonLossDto.getRemark() + "', ");
            debugBuffer.append("ArrangeRate = " + prpLpersonLossDto.getArrangeRate() + ", ");
            debugBuffer.append("SumDefPay = " + prpLpersonLossDto.getSumDefPay() + ", ");
            debugBuffer.append("FeeCategory = '" + prpLpersonLossDto.getFeeCategory() + "', ");
            debugBuffer.append("CISumRealPay = " + prpLpersonLossDto.getCISumRealPay() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLpersonLossDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLpersonLossDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLpersonLossDto.getRiskCode());
        dbManager.setString(2,prpLpersonLossDto.getPolicyNo());
        dbManager.setInt(3,prpLpersonLossDto.getPersonNo());
        dbManager.setString(4,prpLpersonLossDto.getPersonName());
        dbManager.setString(5,prpLpersonLossDto.getIdentifyNumber());
        dbManager.setString(6,prpLpersonLossDto.getSex());
        dbManager.setInt(7,prpLpersonLossDto.getAge());
        dbManager.setInt(8,prpLpersonLossDto.getItemKindNo());
        dbManager.setInt(9,prpLpersonLossDto.getFamilyNo());
        dbManager.setString(10,prpLpersonLossDto.getFamilyName());
        dbManager.setString(11,prpLpersonLossDto.getKindCode());
        dbManager.setString(12,prpLpersonLossDto.getLiabCode());
        dbManager.setString(13,prpLpersonLossDto.getLiabName());
        dbManager.setString(14,prpLpersonLossDto.getJobCode());
        dbManager.setString(15,prpLpersonLossDto.getJobName());
        dbManager.setString(16,prpLpersonLossDto.getLiabDetailCode());
        dbManager.setString(17,prpLpersonLossDto.getLiabDetailName());
        dbManager.setString(18,prpLpersonLossDto.getItemAddress());
        dbManager.setInt(19,prpLpersonLossDto.getLossQuantity());
        dbManager.setString(20,prpLpersonLossDto.getUnit());
        dbManager.setDouble(21,prpLpersonLossDto.getUnitAmount());
        dbManager.setString(22,prpLpersonLossDto.getCurrency());
        dbManager.setDouble(23,prpLpersonLossDto.getAmount());
        dbManager.setString(24,prpLpersonLossDto.getCurrency1());
        dbManager.setDouble(25,prpLpersonLossDto.getItemValue());
        dbManager.setString(26,prpLpersonLossDto.getCurrency2());
        dbManager.setDouble(27,prpLpersonLossDto.getSumLoss());
        dbManager.setDouble(28,prpLpersonLossDto.getSumRest());
        dbManager.setDouble(29,prpLpersonLossDto.getIndemnityDutyRate());
        dbManager.setDouble(30,prpLpersonLossDto.getClaimRate());
        dbManager.setString(31,prpLpersonLossDto.getCurrency3());
        dbManager.setDouble(32,prpLpersonLossDto.getDeductibleRate());
        dbManager.setDouble(33,prpLpersonLossDto.getDeductible());
        dbManager.setString(34,prpLpersonLossDto.getCurrency4());
        dbManager.setDouble(35,prpLpersonLossDto.getSumRealPay());
        dbManager.setString(36,prpLpersonLossDto.getFlag());
        dbManager.setDouble(37,prpLpersonLossDto.getDutyDeductibleRate());
        dbManager.setString(38,prpLpersonLossDto.getInjuryGrade());
        dbManager.setString(39,prpLpersonLossDto.getInjuryScopeDesc());
        dbManager.setDateTime(40,prpLpersonLossDto.getInHospDate());
        dbManager.setDateTime(41,prpLpersonLossDto.getOutHospDate());
        dbManager.setString(42,prpLpersonLossDto.getHospital());
        dbManager.setInt(43,prpLpersonLossDto.getHospitalDays());
        dbManager.setString(44,prpLpersonLossDto.getRejectReason());
        dbManager.setDouble(45,prpLpersonLossDto.getDriverDeductibleRate());
        dbManager.setDouble(46,prpLpersonLossDto.getMaxpaid());
        dbManager.setDouble(47,prpLpersonLossDto.getHispaid());
        dbManager.setString(48,prpLpersonLossDto.getRemark());
        dbManager.setDouble(49,prpLpersonLossDto.getArrangeRate());
        dbManager.setDouble(50,prpLpersonLossDto.getSumDefPay());
        dbManager.setString(51,prpLpersonLossDto.getFeeCategory());
        dbManager.setDouble(52,prpLpersonLossDto.getCISumRealPay());
        //设置条件字段;
        dbManager.setString(53,prpLpersonLossDto.getCompensateNo());
        dbManager.setInt(54,prpLpersonLossDto.getSerialNo());
        
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return PrpLpersonLossDto
     * @throws Exception
     */
    public PrpLpersonLossDto findByPrimaryKey(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PersonNo,");
        buffer.append("PersonName,");
        buffer.append("IdentifyNumber,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LiabCode,");
        buffer.append("LiabName,");
        buffer.append("JobCode,");
        buffer.append("JobName,");
        buffer.append("LiabDetailCode,");
        buffer.append("LiabDetailName,");
        buffer.append("ItemAddress,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitAmount,");
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
        buffer.append("DutyDeductibleRate,");
        buffer.append("InjuryGrade,");
        buffer.append("InjuryScopeDesc,");
        buffer.append("InHospDate,");
        buffer.append("OutHospDate,");
        buffer.append("Hospital,");
        buffer.append("HospitalDays,");
        buffer.append("RejectReason,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Maxpaid,");
        buffer.append("Hispaid,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay,");
        buffer.append("FeeCategory, ");
        buffer.append("CISumRealPay,  ");
        buffer.append("sumallrealpay  ");
        buffer.append("FROM PrpLpersonLoss ");
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
        PrpLpersonLossDto prpLpersonLossDto = null;
        if(resultSet.next()){
            prpLpersonLossDto = new PrpLpersonLossDto();
            prpLpersonLossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLpersonLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpersonLossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonLossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonLossDto.setPersonNo(dbManager.getInt(resultSet,5));
            prpLpersonLossDto.setPersonName(dbManager.getString(resultSet,6));
            prpLpersonLossDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpLpersonLossDto.setSex(dbManager.getString(resultSet,8));
            prpLpersonLossDto.setAge(dbManager.getInt(resultSet,9));
            prpLpersonLossDto.setItemKindNo(dbManager.getInt(resultSet,10));
            prpLpersonLossDto.setFamilyNo(dbManager.getInt(resultSet,11));
            prpLpersonLossDto.setFamilyName(dbManager.getString(resultSet,12));
            prpLpersonLossDto.setKindCode(dbManager.getString(resultSet,13));
            prpLpersonLossDto.setLiabCode(dbManager.getString(resultSet,14));
            prpLpersonLossDto.setLiabName(dbManager.getString(resultSet,15));
            prpLpersonLossDto.setJobCode(dbManager.getString(resultSet,16));
            prpLpersonLossDto.setJobName(dbManager.getString(resultSet,17));
            prpLpersonLossDto.setLiabDetailCode(dbManager.getString(resultSet,18));
            prpLpersonLossDto.setLiabDetailName(dbManager.getString(resultSet,19));
            prpLpersonLossDto.setItemAddress(dbManager.getString(resultSet,20));
            prpLpersonLossDto.setLossQuantity(dbManager.getInt(resultSet,21));
            prpLpersonLossDto.setUnit(dbManager.getString(resultSet,22));
            prpLpersonLossDto.setUnitAmount(dbManager.getDouble(resultSet,23));
            prpLpersonLossDto.setCurrency(dbManager.getString(resultSet,24));
            prpLpersonLossDto.setAmount(dbManager.getDouble(resultSet,25));
            prpLpersonLossDto.setCurrency1(dbManager.getString(resultSet,26));
            prpLpersonLossDto.setItemValue(dbManager.getDouble(resultSet,27));
            prpLpersonLossDto.setCurrency2(dbManager.getString(resultSet,28));
            prpLpersonLossDto.setSumLoss(dbManager.getDouble(resultSet,29));
            prpLpersonLossDto.setSumRest(dbManager.getDouble(resultSet,30));
            prpLpersonLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,31));
            prpLpersonLossDto.setClaimRate(dbManager.getDouble(resultSet,32));
            prpLpersonLossDto.setCurrency3(dbManager.getString(resultSet,33));
            prpLpersonLossDto.setDeductibleRate(dbManager.getDouble(resultSet,34));
            prpLpersonLossDto.setDeductible(dbManager.getDouble(resultSet,35));
            prpLpersonLossDto.setCurrency4(dbManager.getString(resultSet,36));
            prpLpersonLossDto.setSumRealPay(dbManager.getDouble(resultSet,37));
            prpLpersonLossDto.setFlag(dbManager.getString(resultSet,38));
            prpLpersonLossDto.setDutyDeductibleRate(dbManager.getDouble(resultSet,39));
            prpLpersonLossDto.setInjuryGrade(dbManager.getString(resultSet,40));
            prpLpersonLossDto.setInjuryScopeDesc(dbManager.getString(resultSet,41));
            prpLpersonLossDto.setInHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,42));
            prpLpersonLossDto.setOutHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,43));
            prpLpersonLossDto.setHospital(dbManager.getString(resultSet,44));
            prpLpersonLossDto.setHospitalDays(dbManager.getInt(resultSet,45));
            prpLpersonLossDto.setRejectReason(dbManager.getString(resultSet,46));
            prpLpersonLossDto.setDriverDeductibleRate(dbManager.getDouble(resultSet,47));
            prpLpersonLossDto.setMaxpaid(dbManager.getDouble(resultSet,48));
            prpLpersonLossDto.setHispaid(dbManager.getDouble(resultSet,49));
            prpLpersonLossDto.setRemark(dbManager.getString(resultSet,50));
            prpLpersonLossDto.setArrangeRate(dbManager.getDouble(resultSet,51));
            prpLpersonLossDto.setCISumRealPay(dbManager.getDouble(resultSet,52));
            prpLpersonLossDto.setSumDefPay(dbManager.getDouble(resultSet,53));
            prpLpersonLossDto.setFeeCategory(dbManager.getString(resultSet,54));
            prpLpersonLossDto.setSumAllRealPay(dbManager.getDouble(resultSet,55));
        }
        resultSet.close();
        return prpLpersonLossDto;
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
        buffer.append("PersonNo,");
        buffer.append("PersonName,");
        buffer.append("IdentifyNumber,");
        buffer.append("Sex,");
        buffer.append("Age,");
        buffer.append("ItemKindNo,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName,");
        buffer.append("KindCode,");
        buffer.append("LiabCode,");
        buffer.append("LiabName,");
        buffer.append("JobCode,");
        buffer.append("JobName,");
        buffer.append("LiabDetailCode,");
        buffer.append("LiabDetailName,");
        buffer.append("ItemAddress,");
        buffer.append("LossQuantity,");
        buffer.append("Unit,");
        buffer.append("UnitAmount,");
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
        buffer.append("DutyDeductibleRate,");
        buffer.append("InjuryGrade,");
        buffer.append("InjuryScopeDesc,");
        buffer.append("InHospDate,");
        buffer.append("OutHospDate,");
        buffer.append("Hospital,");
        buffer.append("HospitalDays,");
        buffer.append("RejectReason,");
        buffer.append("DriverDeductibleRate,");
        buffer.append("Maxpaid,");
        buffer.append("Hispaid,");
        buffer.append("Remark,");
        buffer.append("ArrangeRate,");
        buffer.append("SumDefPay,");
        buffer.append("FeeCategory, ");
        buffer.append("CISumRealPay,  ");
        buffer.append("sumallrealpay, ");
        buffer.append("hospitalCode, ");
        buffer.append("diseaseCode ");
        buffer.append("FROM PrpLpersonLoss WHERE ");
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
        PrpLpersonLossDto prpLpersonLossDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpersonLossDto = new PrpLpersonLossDto();
            prpLpersonLossDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLpersonLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpersonLossDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonLossDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonLossDto.setPersonNo(dbManager.getInt(resultSet,5));
            prpLpersonLossDto.setPersonName(dbManager.getString(resultSet,6));
            prpLpersonLossDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpLpersonLossDto.setSex(dbManager.getString(resultSet,8));
            prpLpersonLossDto.setAge(dbManager.getInt(resultSet,9));
            prpLpersonLossDto.setItemKindNo(dbManager.getInt(resultSet,10));
            prpLpersonLossDto.setFamilyNo(dbManager.getInt(resultSet,11));
            prpLpersonLossDto.setFamilyName(dbManager.getString(resultSet,12));
            prpLpersonLossDto.setKindCode(dbManager.getString(resultSet,13));
            prpLpersonLossDto.setLiabCode(dbManager.getString(resultSet,14));
            prpLpersonLossDto.setLiabName(dbManager.getString(resultSet,15));
            prpLpersonLossDto.setJobCode(dbManager.getString(resultSet,16));
            prpLpersonLossDto.setJobName(dbManager.getString(resultSet,17));
            prpLpersonLossDto.setLiabDetailCode(dbManager.getString(resultSet,18));
            prpLpersonLossDto.setLiabDetailName(dbManager.getString(resultSet,19));
            prpLpersonLossDto.setItemAddress(dbManager.getString(resultSet,20));
            prpLpersonLossDto.setLossQuantity(dbManager.getInt(resultSet,21));
            prpLpersonLossDto.setUnit(dbManager.getString(resultSet,22));
            prpLpersonLossDto.setUnitAmount(dbManager.getDouble(resultSet,23));
            prpLpersonLossDto.setCurrency(dbManager.getString(resultSet,24));
            prpLpersonLossDto.setAmount(dbManager.getDouble(resultSet,25));
            prpLpersonLossDto.setCurrency1(dbManager.getString(resultSet,26));
            prpLpersonLossDto.setItemValue(dbManager.getDouble(resultSet,27));
            prpLpersonLossDto.setCurrency2(dbManager.getString(resultSet,28));
            prpLpersonLossDto.setSumLoss(dbManager.getDouble(resultSet,29));
            prpLpersonLossDto.setSumRest(dbManager.getDouble(resultSet,30));
            prpLpersonLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,31));
            prpLpersonLossDto.setClaimRate(dbManager.getDouble(resultSet,32));
            prpLpersonLossDto.setCurrency3(dbManager.getString(resultSet,33));
            prpLpersonLossDto.setDeductibleRate(dbManager.getDouble(resultSet,34));
            prpLpersonLossDto.setDeductible(dbManager.getDouble(resultSet,35));
            prpLpersonLossDto.setCurrency4(dbManager.getString(resultSet,36));
            prpLpersonLossDto.setSumRealPay(dbManager.getDouble(resultSet,37));
            prpLpersonLossDto.setFlag(dbManager.getString(resultSet,38));
            prpLpersonLossDto.setDutyDeductibleRate(dbManager.getDouble(resultSet,39));
            prpLpersonLossDto.setInjuryGrade(dbManager.getString(resultSet,40));
            prpLpersonLossDto.setInjuryScopeDesc(dbManager.getString(resultSet,41));
            prpLpersonLossDto.setInHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,42));
            prpLpersonLossDto.setOutHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,43));
            prpLpersonLossDto.setHospital(dbManager.getString(resultSet,44));
            prpLpersonLossDto.setHospitalDays(dbManager.getInt(resultSet,45));
            prpLpersonLossDto.setRejectReason(dbManager.getString(resultSet,46));
            prpLpersonLossDto.setDriverDeductibleRate(dbManager.getDouble(resultSet,47));
            prpLpersonLossDto.setMaxpaid(dbManager.getDouble(resultSet,48));
            prpLpersonLossDto.setHispaid(dbManager.getDouble(resultSet,49));
            prpLpersonLossDto.setRemark(dbManager.getString(resultSet,50));
            prpLpersonLossDto.setArrangeRate(dbManager.getDouble(resultSet,51));
            prpLpersonLossDto.setSumDefPay(dbManager.getDouble(resultSet,52));
            prpLpersonLossDto.setFeeCategory(dbManager.getString(resultSet,53));
            prpLpersonLossDto.setCISumRealPay(dbManager.getDouble(resultSet, 54));
            prpLpersonLossDto.setSumAllRealPay(dbManager.getDouble(resultSet,55));
            prpLpersonLossDto.setHospitalCode(dbManager.getString(resultSet,56));
            prpLpersonLossDto.setDiseaseCode(dbManager.getString(resultSet,57));
            collection.add(prpLpersonLossDto);
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
        buffer.append("DELETE FROM PrpLpersonLoss WHERE ");
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
        String statement;
          statement = "SELECT count(1) FROM PrpLpersonLoss WHERE ";
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
    
    /**山东意外险查询重开信息同之前理算信息合并方法
     * findByRecase
     * @param conditions
     * @return
     * @throws Exception
     */
    public Collection findByRecase(String conditions) throws Exception {
		return findByRecase(conditions, 0, 0);
    }
    
    /**
     * 山东意外险查询重开信息同之前理算信息合并方法
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findByRecase(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		StringBuffer buffer = new StringBuffer(200);
		// 拼SQL语句
		buffer.append("SELECT ");
		buffer.append("loss.CompensateNo,");
		buffer.append("loss.RiskCode,");
		buffer.append("loss.PolicyNo,");
		buffer.append("loss.SerialNo,");
		buffer.append("loss.PersonNo,");
		buffer.append("loss.PersonName,");
		buffer.append("loss.IdentifyNumber,");
		buffer.append("loss.Sex,");
		buffer.append("loss.Age,");
		buffer.append("loss.ItemKindNo,");
		buffer.append("loss.SumRealPay,");
		buffer.append("loss.KindCode,");
		buffer.append("ck.rationtype ");
		buffer.append("FROM PrpLpersonLoss loss,prpcitemkind ck WHERE ");
		buffer.append(conditions);
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		int count = 0;
		if (pageNo > 1) {
			dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
		}

		// 定义返回结果集合
		Collection collection = new ArrayList(rowsPerPage);
		PrpLpersonLossDto prpLpersonLossDto = null;
		while (resultSet.next()) {
			count++;
			if (pageNo > 0) {
				if (count > rowsPerPage) {
					break;
				}
			}

			prpLpersonLossDto = new PrpLpersonLossDto();
			prpLpersonLossDto
					.setCompensateNo(dbManager.getString(resultSet, 1));
			prpLpersonLossDto.setRiskCode(dbManager.getString(resultSet, 2));
			prpLpersonLossDto.setPolicyNo(dbManager.getString(resultSet, 3));
			prpLpersonLossDto.setSerialNo(dbManager.getInt(resultSet, 4));
			prpLpersonLossDto.setPersonNo(dbManager.getInt(resultSet, 5));
			prpLpersonLossDto.setPersonName(dbManager.getString(resultSet, 6));
			prpLpersonLossDto.setIdentifyNumber(dbManager.getString(resultSet,
					7));
			prpLpersonLossDto.setSex(dbManager.getString(resultSet, 8));
			prpLpersonLossDto.setAge(dbManager.getInt(resultSet, 9));
			prpLpersonLossDto.setItemKindNo(dbManager.getInt(resultSet, 10));
			prpLpersonLossDto.setSumRealPay(dbManager.getDouble(resultSet, 11));
			prpLpersonLossDto.setKindCode(dbManager.getString(resultSet, 12) + dbManager.getString(resultSet, 13));
			collection.add(prpLpersonLossDto);
		}
		resultSet.close();
		return collection;
	}
}
