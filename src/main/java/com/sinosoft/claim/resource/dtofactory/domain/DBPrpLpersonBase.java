package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLperson－人员伤亡明细信息表的数据访问对象基类<br>
 * 创建于 2006-04-24 10:56:42.989<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpersonBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLpersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void insert(PrpLpersonDto prpLpersonDto) throws Exception{
        String mainStatement = " Insert Into PrpLperson (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " MonthStdWage," + 
                           " MonthBonus," + 
                           " Allowance," + 
                           " MonthWage," + 
                           " Hospital," + 
                           " NursePersons," + 
                           " NurseDays," + 
                           " Diagnose," + 
                           " WoundGrade," + 
                           " HospitalDays," + 
                           " CureDays," + 
                           " ChangeHospital," + 
                           " RelatePersonNo," + 
                           " UnitLoss," + 
                           " Quantity," + 
                           " Unit," + 
                           " Times," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " VeriUnitLoss," + 
                           " VeriQuantity," + 
                           " VeriUnit," + 
                           " VeriTimes," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " Flag," + 
                           " FllowHospRemark," + 
                           " InHospDate," + 
                           " OutHospDate," + 
                           " RestDate," + 
                           " CompensateBackFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLpersonDto.getClaimNo() + "'," + 
                           "'" + prpLpersonDto.getRiskCode() + "'," + 
                           "'" + prpLpersonDto.getPolicyNo() + "'," + 
                           "" + prpLpersonDto.getSerialNo() + "," + 
                           "'" + prpLpersonDto.getRegistNo() + "'," + 
                           "" + prpLpersonDto.getItemKindNo() + "," + 
                           "" + prpLpersonDto.getFamilyNo() + "," + 
                           "'" + prpLpersonDto.getFamilyName() + "'," + 
                           "'" + prpLpersonDto.getKindCode() + "'," + 
                           "'" + prpLpersonDto.getItemCode() + "'," + 
                           "'" + prpLpersonDto.getAreaCode() + "'," + 
                           "'" + prpLpersonDto.getFixedIncomeFlag() + "'," + 
                           "'" + prpLpersonDto.getJobCode() + "'," + 
                           "'" + prpLpersonDto.getJobName() + "'," + 
                           "'" + prpLpersonDto.getPayPersonType() + "'," + 
                           "'" + prpLpersonDto.getFeeTypeCode() + "'," + 
                           "'" + prpLpersonDto.getFeeTypeName() + "'," + 
                           "" + prpLpersonDto.getPersonNo() + "," + 
                           "'" + prpLpersonDto.getPersonName() + "'," + 
                           "'" + prpLpersonDto.getPersonSex() + "'," + 
                           "" + prpLpersonDto.getPersonAge() + "," + 
                           "'" + prpLpersonDto.getCurrency() + "'," + 
                           "'" + prpLpersonDto.getIdentifyNumber() + "'," + 
                           "'" + prpLpersonDto.getJobUnit() + "'," + 
                           "'" + prpLpersonDto.getMonthStdWage() + "'," + 
                           "'" + prpLpersonDto.getMonthBonus() + "'," + 
                           "'" + prpLpersonDto.getAllowance() + "'," + 
                           "'" + prpLpersonDto.getMonthWage() + "'," + 
                           "'" + prpLpersonDto.getHospital() + "'," + 
                           "" + prpLpersonDto.getNursePersons() + "," + 
                           "" + prpLpersonDto.getNurseDays() + "," + 
                           "'" + prpLpersonDto.getDiagnose() + "'," + 
                           "'" + prpLpersonDto.getWoundGrade() + "'," + 
                           "" + prpLpersonDto.getHospitalDays() + "," + 
                           "" + prpLpersonDto.getCureDays() + "," + 
                           "'" + prpLpersonDto.getChangeHospital() + "'," + 
                           "" + prpLpersonDto.getRelatePersonNo() + "," + 
                           "'" + prpLpersonDto.getUnitLoss() + "'," + 
                           "'" + prpLpersonDto.getQuantity() + "'," + 
                           "'" + prpLpersonDto.getUnit() + "'," + 
                           "'" + prpLpersonDto.getTimes() + "'," + 
                           "'" + prpLpersonDto.getSumLoss() + "'," + 
                           "'" + prpLpersonDto.getSumReject() + "'," + 
                           "'" + prpLpersonDto.getRejectReason() + "'," + 
                           "'" + prpLpersonDto.getLossRate() + "'," + 
                           "'" + prpLpersonDto.getSumDefLoss() + "'," + 
                           "'" + prpLpersonDto.getRemark() + "'," + 
                           "'" + prpLpersonDto.getVeriUnitLoss() + "'," + 
                           "'" + prpLpersonDto.getVeriQuantity() + "'," + 
                           "'" + prpLpersonDto.getVeriUnit() + "'," + 
                           "'" + prpLpersonDto.getVeriTimes() + "'," + 
                           "'" + prpLpersonDto.getVeriSumLoss() + "'," + 
                           "'" + prpLpersonDto.getVeriSumReject() + "'," + 
                           "'" + prpLpersonDto.getVeriRejectReason() + "'," + 
                           "'" + prpLpersonDto.getVeriLossRate() + "'," + 
                           "'" + prpLpersonDto.getVeriSumDefLoss() + "'," + 
                           "'" + prpLpersonDto.getVeriRemark() + "'," + 
                           "'" + prpLpersonDto.getFlag() + "'," + 
                           "'" + prpLpersonDto.getFllowHospRemark() + "'," + 
                           "'" + prpLpersonDto.getInHospDate() + "'," + 
                           "'" + prpLpersonDto.getOutHospDate() + "'," + 
                           "'" + prpLpersonDto.getRestDate() + "'," + 
                           "'" + prpLpersonDto.getCompensateBackFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpersonDto.getClaimNo());
        dbManager.setString(2,prpLpersonDto.getRiskCode());
        dbManager.setString(3,prpLpersonDto.getPolicyNo());
        dbManager.setInt(4,prpLpersonDto.getSerialNo());
        dbManager.setString(5,prpLpersonDto.getRegistNo());
        dbManager.setInt(6,prpLpersonDto.getItemKindNo());
        dbManager.setInt(7,prpLpersonDto.getFamilyNo());
        dbManager.setString(8,prpLpersonDto.getFamilyName());
        dbManager.setString(9,prpLpersonDto.getKindCode());
        dbManager.setString(10,prpLpersonDto.getItemCode());
        dbManager.setString(11,prpLpersonDto.getAreaCode());
        dbManager.setString(12,prpLpersonDto.getFixedIncomeFlag());
        dbManager.setString(13,prpLpersonDto.getJobCode());
        dbManager.setString(14,prpLpersonDto.getJobName());
        dbManager.setString(15,prpLpersonDto.getPayPersonType());
        dbManager.setString(16,prpLpersonDto.getFeeTypeCode());
        dbManager.setString(17,prpLpersonDto.getFeeTypeName());
        dbManager.setInt(18,prpLpersonDto.getPersonNo());
        dbManager.setString(19,prpLpersonDto.getPersonName());
        dbManager.setString(20,prpLpersonDto.getPersonSex());
        dbManager.setInt(21,prpLpersonDto.getPersonAge());
        dbManager.setString(22,prpLpersonDto.getCurrency());
        dbManager.setString(23,prpLpersonDto.getIdentifyNumber());
        dbManager.setString(24,prpLpersonDto.getJobUnit());
        dbManager.setDouble(25,prpLpersonDto.getMonthStdWage());
        dbManager.setDouble(26,prpLpersonDto.getMonthBonus());
        dbManager.setDouble(27,prpLpersonDto.getAllowance());
        dbManager.setDouble(28,prpLpersonDto.getMonthWage());
        dbManager.setString(29,prpLpersonDto.getHospital());
        dbManager.setInt(30,prpLpersonDto.getNursePersons());
        dbManager.setInt(31,prpLpersonDto.getNurseDays());
        dbManager.setString(32,prpLpersonDto.getDiagnose());
        dbManager.setString(33,prpLpersonDto.getWoundGrade());
        dbManager.setInt(34,prpLpersonDto.getHospitalDays());
        dbManager.setInt(35,prpLpersonDto.getCureDays());
        dbManager.setString(36,prpLpersonDto.getChangeHospital());
        dbManager.setInt(37,prpLpersonDto.getRelatePersonNo());
        dbManager.setDouble(38,prpLpersonDto.getUnitLoss());
        dbManager.setDouble(39,prpLpersonDto.getQuantity());
        dbManager.setString(40,prpLpersonDto.getUnit());
        dbManager.setDouble(41,prpLpersonDto.getTimes());
        dbManager.setDouble(42,prpLpersonDto.getSumLoss());
        dbManager.setDouble(43,prpLpersonDto.getSumReject());
        dbManager.setString(44,prpLpersonDto.getRejectReason());
        dbManager.setDouble(45,prpLpersonDto.getLossRate());
        dbManager.setDouble(46,prpLpersonDto.getSumDefLoss());
        dbManager.setString(47,prpLpersonDto.getRemark());
        dbManager.setDouble(48,prpLpersonDto.getVeriUnitLoss());
        dbManager.setDouble(49,prpLpersonDto.getVeriQuantity());
        dbManager.setString(50,prpLpersonDto.getVeriUnit());
        dbManager.setDouble(51,prpLpersonDto.getVeriTimes());
        dbManager.setDouble(52,prpLpersonDto.getVeriSumLoss());
        dbManager.setDouble(53,prpLpersonDto.getVeriSumReject());
        dbManager.setString(54,prpLpersonDto.getVeriRejectReason());
        dbManager.setDouble(55,prpLpersonDto.getVeriLossRate());
        dbManager.setDouble(56,prpLpersonDto.getVeriSumDefLoss());
        dbManager.setString(57,prpLpersonDto.getVeriRemark());
        dbManager.setString(58,prpLpersonDto.getFlag());
        dbManager.setString(59,prpLpersonDto.getFllowHospRemark());
        dbManager.setDateTime(60,prpLpersonDto.getInHospDate());
        dbManager.setDateTime(61,prpLpersonDto.getOutHospDate());
        dbManager.setDateTime(62,prpLpersonDto.getRestDate());
        dbManager.setString(63,prpLpersonDto.getCompensateBackFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpersonDto prpLpersonDto = (PrpLpersonDto)i.next();
            insert(prpLpersonDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(int serialNo,String registNo) throws Exception{
        String statement = " Delete From PrpLperson" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLperson Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpersonBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void update(PrpLpersonDto prpLpersonDto) throws Exception{
        String statement = " Update PrpLperson Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " FamilyNo = ?," + 
                           " FamilyName = ?," + 
                           " KindCode = ?," + 
                           " ItemCode = ?," + 
                           " AreaCode = ?," + 
                           " FixedIncomeFlag = ?," + 
                           " JobCode = ?," + 
                           " JobName = ?," + 
                           " PayPersonType = ?," + 
                           " FeeTypeCode = ?," + 
                           " FeeTypeName = ?," + 
                           " PersonNo = ?," + 
                           " PersonName = ?," + 
                           " PersonSex = ?," + 
                           " PersonAge = ?," + 
                           " Currency = ?," + 
                           " IdentifyNumber = ?," + 
                           " JobUnit = ?," + 
                           " MonthStdWage = ?," + 
                           " MonthBonus = ?," + 
                           " Allowance = ?," + 
                           " MonthWage = ?," + 
                           " Hospital = ?," + 
                           " NursePersons = ?," + 
                           " NurseDays = ?," + 
                           " Diagnose = ?," + 
                           " WoundGrade = ?," + 
                           " HospitalDays = ?," + 
                           " CureDays = ?," + 
                           " ChangeHospital = ?," + 
                           " RelatePersonNo = ?," + 
                           " UnitLoss = ?," + 
                           " Quantity = ?," + 
                           " Unit = ?," + 
                           " Times = ?," + 
                           " SumLoss = ?," + 
                           " SumReject = ?," + 
                           " RejectReason = ?," + 
                           " LossRate = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " VeriUnitLoss = ?," + 
                           " VeriQuantity = ?," + 
                           " VeriUnit = ?," + 
                           " VeriTimes = ?," + 
                           " VeriSumLoss = ?," + 
                           " VeriSumReject = ?," + 
                           " VeriRejectReason = ?," + 
                           " VeriLossRate = ?," + 
                           " VeriSumDefLoss = ?," + 
                           " VeriRemark = ?," + 
                           " Flag = ?," + 
                           " FllowHospRemark = ?," + 
                           " InHospDate = ?," + 
                           " OutHospDate = ?," + 
                           " RestDate = ?," + 
                           " CompensateBackFlag = ?" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLperson Set " + 
                           " ClaimNo = '" + prpLpersonDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLpersonDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLpersonDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLpersonDto.getSerialNo() + "," + 
                           " RegistNo = '" + prpLpersonDto.getRegistNo() + "'," + 
                           " ItemKindNo = " + prpLpersonDto.getItemKindNo() + "," + 
                           " FamilyNo = " + prpLpersonDto.getFamilyNo() + "," + 
                           " FamilyName = '" + prpLpersonDto.getFamilyName() + "'," + 
                           " KindCode = '" + prpLpersonDto.getKindCode() + "'," + 
                           " ItemCode = '" + prpLpersonDto.getItemCode() + "'," + 
                           " AreaCode = '" + prpLpersonDto.getAreaCode() + "'," + 
                           " FixedIncomeFlag = '" + prpLpersonDto.getFixedIncomeFlag() + "'," + 
                           " JobCode = '" + prpLpersonDto.getJobCode() + "'," + 
                           " JobName = '" + prpLpersonDto.getJobName() + "'," + 
                           " PayPersonType = '" + prpLpersonDto.getPayPersonType() + "'," + 
                           " FeeTypeCode = '" + prpLpersonDto.getFeeTypeCode() + "'," + 
                           " FeeTypeName = '" + prpLpersonDto.getFeeTypeName() + "'," + 
                           " PersonNo = " + prpLpersonDto.getPersonNo() + "," + 
                           " PersonName = '" + prpLpersonDto.getPersonName() + "'," + 
                           " PersonSex = '" + prpLpersonDto.getPersonSex() + "'," + 
                           " PersonAge = " + prpLpersonDto.getPersonAge() + "," + 
                           " Currency = '" + prpLpersonDto.getCurrency() + "'," + 
                           " IdentifyNumber = '" + prpLpersonDto.getIdentifyNumber() + "'," + 
                           " JobUnit = '" + prpLpersonDto.getJobUnit() + "'," + 
                           " MonthStdWage = '" + prpLpersonDto.getMonthStdWage() + "'," + 
                           " MonthBonus = '" + prpLpersonDto.getMonthBonus() + "'," + 
                           " Allowance = '" + prpLpersonDto.getAllowance() + "'," + 
                           " MonthWage = '" + prpLpersonDto.getMonthWage() + "'," + 
                           " Hospital = '" + prpLpersonDto.getHospital() + "'," + 
                           " NursePersons = " + prpLpersonDto.getNursePersons() + "," + 
                           " NurseDays = " + prpLpersonDto.getNurseDays() + "," + 
                           " Diagnose = '" + prpLpersonDto.getDiagnose() + "'," + 
                           " WoundGrade = '" + prpLpersonDto.getWoundGrade() + "'," + 
                           " HospitalDays = " + prpLpersonDto.getHospitalDays() + "," + 
                           " CureDays = " + prpLpersonDto.getCureDays() + "," + 
                           " ChangeHospital = '" + prpLpersonDto.getChangeHospital() + "'," + 
                           " RelatePersonNo = " + prpLpersonDto.getRelatePersonNo() + "," + 
                           " UnitLoss = '" + prpLpersonDto.getUnitLoss() + "'," + 
                           " Quantity = '" + prpLpersonDto.getQuantity() + "'," + 
                           " Unit = '" + prpLpersonDto.getUnit() + "'," + 
                           " Times = '" + prpLpersonDto.getTimes() + "'," + 
                           " SumLoss = '" + prpLpersonDto.getSumLoss() + "'," + 
                           " SumReject = '" + prpLpersonDto.getSumReject() + "'," + 
                           " RejectReason = '" + prpLpersonDto.getRejectReason() + "'," + 
                           " LossRate = '" + prpLpersonDto.getLossRate() + "'," + 
                           " SumDefLoss = '" + prpLpersonDto.getSumDefLoss() + "'," + 
                           " Remark = '" + prpLpersonDto.getRemark() + "'," + 
                           " VeriUnitLoss = '" + prpLpersonDto.getVeriUnitLoss() + "'," + 
                           " VeriQuantity = '" + prpLpersonDto.getVeriQuantity() + "'," + 
                           " VeriUnit = '" + prpLpersonDto.getVeriUnit() + "'," + 
                           " VeriTimes = '" + prpLpersonDto.getVeriTimes() + "'," + 
                           " VeriSumLoss = '" + prpLpersonDto.getVeriSumLoss() + "'," + 
                           " VeriSumReject = '" + prpLpersonDto.getVeriSumReject() + "'," + 
                           " VeriRejectReason = '" + prpLpersonDto.getVeriRejectReason() + "'," + 
                           " VeriLossRate = '" + prpLpersonDto.getVeriLossRate() + "'," + 
                           " VeriSumDefLoss = '" + prpLpersonDto.getVeriSumDefLoss() + "'," + 
                           " VeriRemark = '" + prpLpersonDto.getVeriRemark() + "'," + 
                           " Flag = '" + prpLpersonDto.getFlag() + "'," + 
                           " FllowHospRemark = '" + prpLpersonDto.getFllowHospRemark() + "'," + 
                           " InHospDate = '" + prpLpersonDto.getInHospDate() + "'," + 
                           " OutHospDate = '" + prpLpersonDto.getOutHospDate() + "'," + 
                           " RestDate = '" + prpLpersonDto.getRestDate() + "'," + 
                           " CompensateBackFlag = '" + prpLpersonDto.getCompensateBackFlag() + "'" + 
			               " Where " +
                           " SerialNo = " + prpLpersonDto.getSerialNo() + " And " + 
                           " RegistNo = '" + prpLpersonDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLpersonDto.getClaimNo());
        dbManager.setString(2,prpLpersonDto.getRiskCode());
        dbManager.setString(3,prpLpersonDto.getPolicyNo());
        dbManager.setInt(4,prpLpersonDto.getItemKindNo());
        dbManager.setInt(5,prpLpersonDto.getFamilyNo());
        dbManager.setString(6,prpLpersonDto.getFamilyName());
        dbManager.setString(7,prpLpersonDto.getKindCode());
        dbManager.setString(8,prpLpersonDto.getItemCode());
        dbManager.setString(9,prpLpersonDto.getAreaCode());
        dbManager.setString(10,prpLpersonDto.getFixedIncomeFlag());
        dbManager.setString(11,prpLpersonDto.getJobCode());
        dbManager.setString(12,prpLpersonDto.getJobName());
        dbManager.setString(13,prpLpersonDto.getPayPersonType());
        dbManager.setString(14,prpLpersonDto.getFeeTypeCode());
        dbManager.setString(15,prpLpersonDto.getFeeTypeName());
        dbManager.setInt(16,prpLpersonDto.getPersonNo());
        dbManager.setString(17,prpLpersonDto.getPersonName());
        dbManager.setString(18,prpLpersonDto.getPersonSex());
        dbManager.setInt(19,prpLpersonDto.getPersonAge());
        dbManager.setString(20,prpLpersonDto.getCurrency());
        dbManager.setString(21,prpLpersonDto.getIdentifyNumber());
        dbManager.setString(22,prpLpersonDto.getJobUnit());
        dbManager.setDouble(23,prpLpersonDto.getMonthStdWage());
        dbManager.setDouble(24,prpLpersonDto.getMonthBonus());
        dbManager.setDouble(25,prpLpersonDto.getAllowance());
        dbManager.setDouble(26,prpLpersonDto.getMonthWage());
        dbManager.setString(27,prpLpersonDto.getHospital());
        dbManager.setInt(28,prpLpersonDto.getNursePersons());
        dbManager.setInt(29,prpLpersonDto.getNurseDays());
        dbManager.setString(30,prpLpersonDto.getDiagnose());
        dbManager.setString(31,prpLpersonDto.getWoundGrade());
        dbManager.setInt(32,prpLpersonDto.getHospitalDays());
        dbManager.setInt(33,prpLpersonDto.getCureDays());
        dbManager.setString(34,prpLpersonDto.getChangeHospital());
        dbManager.setInt(35,prpLpersonDto.getRelatePersonNo());
        dbManager.setDouble(36,prpLpersonDto.getUnitLoss());
        dbManager.setDouble(37,prpLpersonDto.getQuantity());
        dbManager.setString(38,prpLpersonDto.getUnit());
        dbManager.setDouble(39,prpLpersonDto.getTimes());
        dbManager.setDouble(40,prpLpersonDto.getSumLoss());
        dbManager.setDouble(41,prpLpersonDto.getSumReject());
        dbManager.setString(42,prpLpersonDto.getRejectReason());
        dbManager.setDouble(43,prpLpersonDto.getLossRate());
        dbManager.setDouble(44,prpLpersonDto.getSumDefLoss());
        dbManager.setString(45,prpLpersonDto.getRemark());
        dbManager.setDouble(46,prpLpersonDto.getVeriUnitLoss());
        dbManager.setDouble(47,prpLpersonDto.getVeriQuantity());
        dbManager.setString(48,prpLpersonDto.getVeriUnit());
        dbManager.setDouble(49,prpLpersonDto.getVeriTimes());
        dbManager.setDouble(50,prpLpersonDto.getVeriSumLoss());
        dbManager.setDouble(51,prpLpersonDto.getVeriSumReject());
        dbManager.setString(52,prpLpersonDto.getVeriRejectReason());
        dbManager.setDouble(53,prpLpersonDto.getVeriLossRate());
        dbManager.setDouble(54,prpLpersonDto.getVeriSumDefLoss());
        dbManager.setString(55,prpLpersonDto.getVeriRemark());
        dbManager.setString(56,prpLpersonDto.getFlag());
        dbManager.setString(57,prpLpersonDto.getFllowHospRemark());
        dbManager.setDateTime(58,prpLpersonDto.getInHospDate());
        dbManager.setDateTime(59,prpLpersonDto.getOutHospDate());
        dbManager.setDateTime(60,prpLpersonDto.getRestDate());
        dbManager.setString(61,prpLpersonDto.getCompensateBackFlag());
        //设置条件字段;
        dbManager.setInt(62,prpLpersonDto.getSerialNo());
        dbManager.setString(63,prpLpersonDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @return PrpLpersonDto
     * @throws Exception
     */
    public PrpLpersonDto findByPrimaryKey(int serialNo,String registNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " MonthStdWage," + 
                           " MonthBonus," + 
                           " Allowance," + 
                           " MonthWage," + 
                           " Hospital," + 
                           " NursePersons," + 
                           " NurseDays," + 
                           " Diagnose," + 
                           " WoundGrade," + 
                           " HospitalDays," + 
                           " CureDays," + 
                           " ChangeHospital," + 
                           " RelatePersonNo," + 
                           " UnitLoss," + 
                           " Quantity," + 
                           " Unit," + 
                           " Times," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " VeriUnitLoss," + 
                           " VeriQuantity," + 
                           " VeriUnit," + 
                           " VeriTimes," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " Flag," + 
                           " FllowHospRemark," + 
                           " InHospDate," + 
                           " OutHospDate," + 
                           " RestDate," + 
                           " CompensateBackFlag From PrpLperson";
        String statement = mainStatement + " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        PrpLpersonDto prpLpersonDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpersonDto = new PrpLpersonDto();
            prpLpersonDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLpersonDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpersonDto.setFamilyNo(dbManager.getInt(resultSet,7));
            prpLpersonDto.setFamilyName(dbManager.getString(resultSet,8));
            prpLpersonDto.setKindCode(dbManager.getString(resultSet,9));
            prpLpersonDto.setItemCode(dbManager.getString(resultSet,10));
            prpLpersonDto.setAreaCode(dbManager.getString(resultSet,11));
            prpLpersonDto.setFixedIncomeFlag(dbManager.getString(resultSet,12));
            prpLpersonDto.setJobCode(dbManager.getString(resultSet,13));
            prpLpersonDto.setJobName(dbManager.getString(resultSet,14));
            prpLpersonDto.setPayPersonType(dbManager.getString(resultSet,15));
            prpLpersonDto.setFeeTypeCode(dbManager.getString(resultSet,16));
            prpLpersonDto.setFeeTypeName(dbManager.getString(resultSet,17));
            prpLpersonDto.setPersonNo(dbManager.getInt(resultSet,18));
            prpLpersonDto.setPersonName(dbManager.getString(resultSet,19));
            prpLpersonDto.setPersonSex(dbManager.getString(resultSet,20));
            prpLpersonDto.setPersonAge(dbManager.getInt(resultSet,21));
            prpLpersonDto.setCurrency(dbManager.getString(resultSet,22));
            prpLpersonDto.setIdentifyNumber(dbManager.getString(resultSet,23));
            prpLpersonDto.setJobUnit(dbManager.getString(resultSet,24));
            prpLpersonDto.setMonthStdWage(dbManager.getDouble(resultSet,25));
            prpLpersonDto.setMonthBonus(dbManager.getDouble(resultSet,26));
            prpLpersonDto.setAllowance(dbManager.getDouble(resultSet,27));
            prpLpersonDto.setMonthWage(dbManager.getDouble(resultSet,28));
            prpLpersonDto.setHospital(dbManager.getString(resultSet,29));
            prpLpersonDto.setNursePersons(dbManager.getInt(resultSet,30));
            prpLpersonDto.setNurseDays(dbManager.getInt(resultSet,31));
            prpLpersonDto.setDiagnose(dbManager.getString(resultSet,32));
            prpLpersonDto.setWoundGrade(dbManager.getString(resultSet,33));
            prpLpersonDto.setHospitalDays(dbManager.getInt(resultSet,34));
            prpLpersonDto.setCureDays(dbManager.getInt(resultSet,35));
            prpLpersonDto.setChangeHospital(dbManager.getString(resultSet,36));
            prpLpersonDto.setRelatePersonNo(dbManager.getInt(resultSet,37));
            prpLpersonDto.setUnitLoss(dbManager.getDouble(resultSet,38));
            prpLpersonDto.setQuantity(dbManager.getDouble(resultSet,39));
            prpLpersonDto.setUnit(dbManager.getString(resultSet,40));
            prpLpersonDto.setTimes(dbManager.getDouble(resultSet,41));
            prpLpersonDto.setSumLoss(dbManager.getDouble(resultSet,42));
            prpLpersonDto.setSumReject(dbManager.getDouble(resultSet,43));
            prpLpersonDto.setRejectReason(dbManager.getString(resultSet,44));
            prpLpersonDto.setLossRate(dbManager.getDouble(resultSet,45));
            prpLpersonDto.setSumDefLoss(dbManager.getDouble(resultSet,46));
            prpLpersonDto.setRemark(dbManager.getString(resultSet,47));
            prpLpersonDto.setVeriUnitLoss(dbManager.getDouble(resultSet,48));
            prpLpersonDto.setVeriQuantity(dbManager.getDouble(resultSet,49));
            prpLpersonDto.setVeriUnit(dbManager.getString(resultSet,50));
            prpLpersonDto.setVeriTimes(dbManager.getDouble(resultSet,51));
            prpLpersonDto.setVeriSumLoss(dbManager.getDouble(resultSet,52));
            prpLpersonDto.setVeriSumReject(dbManager.getDouble(resultSet,53));
            prpLpersonDto.setVeriRejectReason(dbManager.getString(resultSet,54));
            prpLpersonDto.setVeriLossRate(dbManager.getDouble(resultSet,55));
            prpLpersonDto.setVeriSumDefLoss(dbManager.getDouble(resultSet,56));
            prpLpersonDto.setVeriRemark(dbManager.getString(resultSet,57));
            prpLpersonDto.setFlag(dbManager.getString(resultSet,58));
            prpLpersonDto.setFllowHospRemark(dbManager.getString(resultSet,59));
            prpLpersonDto.setInHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,60));
            prpLpersonDto.setOutHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,61));
            prpLpersonDto.setRestDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,62));
            prpLpersonDto.setCompensateBackFlag(dbManager.getString(resultSet,63));
        }
        resultSet.close();
        logger.info("DBPrpLpersonBase.findByPrimaryKey() success!");
        return prpLpersonDto;
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
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " AreaCode," + 
                           " FixedIncomeFlag," + 
                           " JobCode," + 
                           " JobName," + 
                           " PayPersonType," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " Currency," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " MonthStdWage," + 
                           " MonthBonus," + 
                           " Allowance," + 
                           " MonthWage," + 
                           " Hospital," + 
                           " NursePersons," + 
                           " NurseDays," + 
                           " Diagnose," + 
                           " WoundGrade," + 
                           " HospitalDays," + 
                           " CureDays," + 
                           " ChangeHospital," + 
                           " RelatePersonNo," + 
                           " UnitLoss," + 
                           " Quantity," + 
                           " Unit," + 
                           " Times," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " VeriUnitLoss," + 
                           " VeriQuantity," + 
                           " VeriUnit," + 
                           " VeriTimes," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " Flag," + 
                           " FllowHospRemark," + 
                           " InHospDate," + 
                           " OutHospDate," + 
                           " RestDate," + 
                           " CompensateBackFlag From PrpLperson Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpersonDto prpLpersonDto = null;
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

            prpLpersonDto = new PrpLpersonDto();
            prpLpersonDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpersonDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpersonDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLpersonDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpersonDto.setFamilyNo(dbManager.getInt(resultSet,7));
            prpLpersonDto.setFamilyName(dbManager.getString(resultSet,8));
            prpLpersonDto.setKindCode(dbManager.getString(resultSet,9));
            prpLpersonDto.setItemCode(dbManager.getString(resultSet,10));
            prpLpersonDto.setAreaCode(dbManager.getString(resultSet,11));
            prpLpersonDto.setFixedIncomeFlag(dbManager.getString(resultSet,12));
            prpLpersonDto.setJobCode(dbManager.getString(resultSet,13));
            prpLpersonDto.setJobName(dbManager.getString(resultSet,14));
            prpLpersonDto.setPayPersonType(dbManager.getString(resultSet,15));
            prpLpersonDto.setFeeTypeCode(dbManager.getString(resultSet,16));
            prpLpersonDto.setFeeTypeName(dbManager.getString(resultSet,17));
            prpLpersonDto.setPersonNo(dbManager.getInt(resultSet,18));
            prpLpersonDto.setPersonName(dbManager.getString(resultSet,19));
            prpLpersonDto.setPersonSex(dbManager.getString(resultSet,20));
            prpLpersonDto.setPersonAge(dbManager.getInt(resultSet,21));
            prpLpersonDto.setCurrency(dbManager.getString(resultSet,22));
            prpLpersonDto.setIdentifyNumber(dbManager.getString(resultSet,23));
            prpLpersonDto.setJobUnit(dbManager.getString(resultSet,24));
            prpLpersonDto.setMonthStdWage(dbManager.getDouble(resultSet,25));
            prpLpersonDto.setMonthBonus(dbManager.getDouble(resultSet,26));
            prpLpersonDto.setAllowance(dbManager.getDouble(resultSet,27));
            prpLpersonDto.setMonthWage(dbManager.getDouble(resultSet,28));
            prpLpersonDto.setHospital(dbManager.getString(resultSet,29));
            prpLpersonDto.setNursePersons(dbManager.getInt(resultSet,30));
            prpLpersonDto.setNurseDays(dbManager.getInt(resultSet,31));
            prpLpersonDto.setDiagnose(dbManager.getString(resultSet,32));
            prpLpersonDto.setWoundGrade(dbManager.getString(resultSet,33));
            prpLpersonDto.setHospitalDays(dbManager.getInt(resultSet,34));
            prpLpersonDto.setCureDays(dbManager.getInt(resultSet,35));
            prpLpersonDto.setChangeHospital(dbManager.getString(resultSet,36));
            prpLpersonDto.setRelatePersonNo(dbManager.getInt(resultSet,37));
            prpLpersonDto.setUnitLoss(dbManager.getDouble(resultSet,38));
            prpLpersonDto.setQuantity(dbManager.getDouble(resultSet,39));
            prpLpersonDto.setUnit(dbManager.getString(resultSet,40));
            prpLpersonDto.setTimes(dbManager.getDouble(resultSet,41));
            prpLpersonDto.setSumLoss(dbManager.getDouble(resultSet,42));
            prpLpersonDto.setSumReject(dbManager.getDouble(resultSet,43));
            prpLpersonDto.setRejectReason(dbManager.getString(resultSet,44));
            prpLpersonDto.setLossRate(dbManager.getDouble(resultSet,45));
            prpLpersonDto.setSumDefLoss(dbManager.getDouble(resultSet,46));
            prpLpersonDto.setRemark(dbManager.getString(resultSet,47));
            prpLpersonDto.setVeriUnitLoss(dbManager.getDouble(resultSet,48));
            prpLpersonDto.setVeriQuantity(dbManager.getDouble(resultSet,49));
            prpLpersonDto.setVeriUnit(dbManager.getString(resultSet,50));
            prpLpersonDto.setVeriTimes(dbManager.getDouble(resultSet,51));
            prpLpersonDto.setVeriSumLoss(dbManager.getDouble(resultSet,52));
            prpLpersonDto.setVeriSumReject(dbManager.getDouble(resultSet,53));
            prpLpersonDto.setVeriRejectReason(dbManager.getString(resultSet,54));
            prpLpersonDto.setVeriLossRate(dbManager.getDouble(resultSet,55));
            prpLpersonDto.setVeriSumDefLoss(dbManager.getDouble(resultSet,56));
            prpLpersonDto.setVeriRemark(dbManager.getString(resultSet,57));
            prpLpersonDto.setFlag(dbManager.getString(resultSet,58));
            prpLpersonDto.setFllowHospRemark(dbManager.getString(resultSet,59));
            prpLpersonDto.setInHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,60));
            prpLpersonDto.setOutHospDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,61));
            prpLpersonDto.setRestDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,62));
            prpLpersonDto.setCompensateBackFlag(dbManager.getString(resultSet,63));
            collection.add(prpLpersonDto);
        }
        resultSet.close();
        logger.info("DBPrpLpersonBase.findByConditions() success!");
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
        String statement = "Delete From PrpLperson Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpersonBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLperson Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpersonBase.getCount() success!");
        return count;
    }
}
