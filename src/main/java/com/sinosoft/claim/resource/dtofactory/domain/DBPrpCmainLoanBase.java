package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainLoanDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpCmainLoan的数据访问对象基类<br>
 * 创建于 2006-04-30 11:46:20.265<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainLoanBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCmainLoanBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainLoanBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCmainLoanDto prpCmainLoanDto
     * @throws Exception
     */
    public void insert(PrpCmainLoanDto prpCmainLoanDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCmainLoan (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("GuaranteeType,");
        buffer.append("GuaranteeName,");
        buffer.append("MortgageNo,");
        buffer.append("WarrantorCode,");
        buffer.append("WarrantorName,");
        buffer.append("LoanNo1,");
        buffer.append("LoanNo2,");
        buffer.append("InstallmentFlag,");
        buffer.append("DeliverDate,");
        buffer.append("LoanContractNo,");
        buffer.append("LoanWay,");
        buffer.append("LoanNature,");
        buffer.append("LoanBankCode,");
        buffer.append("LoanBankName,");
        buffer.append("LoanUsage,");
        buffer.append("LoanStartDate,");
        buffer.append("LoanEndDate,");
        buffer.append("LoanYear,");
        buffer.append("PlanAmount,");
        buffer.append("FirstRate,");
        buffer.append("FirstPaid,");
        buffer.append("Currency,");
        buffer.append("LoanAmount,");
        buffer.append("LoanRate,");
        buffer.append("RepaidType,");
        buffer.append("PaidTimes,");
        buffer.append("PerRepaidAmount,");
        buffer.append("Remark,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCmainLoanDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getRiskKind()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getGuaranteeType()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getGuaranteeName()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getMortgageNo()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getWarrantorCode()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getWarrantorName()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanNo1()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanNo2()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getInstallmentFlag()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getDeliverDate()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanContractNo()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanWay()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanNature()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanBankCode()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanBankName()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanUsage()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanStartDate()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getLoanEndDate()).append("',");
            debugBuffer.append("").append(prpCmainLoanDto.getLoanYear()).append(",");
            debugBuffer.append("").append(prpCmainLoanDto.getPlanAmount()).append(",");
            debugBuffer.append("").append(prpCmainLoanDto.getFirstRate()).append(",");
            debugBuffer.append("").append(prpCmainLoanDto.getFirstPaid()).append(",");
            debugBuffer.append("'").append(prpCmainLoanDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpCmainLoanDto.getLoanAmount()).append(",");
            debugBuffer.append("").append(prpCmainLoanDto.getLoanRate()).append(",");
            debugBuffer.append("'").append(prpCmainLoanDto.getRepaidType()).append("',");
            debugBuffer.append("").append(prpCmainLoanDto.getPaidTimes()).append(",");
            debugBuffer.append("").append(prpCmainLoanDto.getPerRepaidAmount()).append(",");
            debugBuffer.append("'").append(prpCmainLoanDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCmainLoanDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCmainLoanDto.getPolicyNo());
        dbManager.setString(2,prpCmainLoanDto.getRiskCode());
        dbManager.setString(3,prpCmainLoanDto.getRiskKind());
        dbManager.setString(4,prpCmainLoanDto.getGuaranteeType());
        dbManager.setString(5,prpCmainLoanDto.getGuaranteeName());
        dbManager.setString(6,prpCmainLoanDto.getMortgageNo());
        dbManager.setString(7,prpCmainLoanDto.getWarrantorCode());
        dbManager.setString(8,prpCmainLoanDto.getWarrantorName());
        dbManager.setString(9,prpCmainLoanDto.getLoanNo1());
        dbManager.setString(10,prpCmainLoanDto.getLoanNo2());
        dbManager.setString(11,prpCmainLoanDto.getInstallmentFlag());
        dbManager.setDateTime(12,prpCmainLoanDto.getDeliverDate());
        dbManager.setString(13,prpCmainLoanDto.getLoanContractNo());
        dbManager.setString(14,prpCmainLoanDto.getLoanWay());
        dbManager.setString(15,prpCmainLoanDto.getLoanNature());
        dbManager.setString(16,prpCmainLoanDto.getLoanBankCode());
        dbManager.setString(17,prpCmainLoanDto.getLoanBankName());
        dbManager.setString(18,prpCmainLoanDto.getLoanUsage());
        dbManager.setDateTime(19,prpCmainLoanDto.getLoanStartDate());
        dbManager.setDateTime(20,prpCmainLoanDto.getLoanEndDate());
        dbManager.setInt(21,prpCmainLoanDto.getLoanYear());
        dbManager.setDouble(22,prpCmainLoanDto.getPlanAmount());
        dbManager.setDouble(23,prpCmainLoanDto.getFirstRate());
        dbManager.setDouble(24,prpCmainLoanDto.getFirstPaid());
        dbManager.setString(25,prpCmainLoanDto.getCurrency());
        dbManager.setDouble(26,prpCmainLoanDto.getLoanAmount());
        dbManager.setDouble(27,prpCmainLoanDto.getLoanRate());
        dbManager.setString(28,prpCmainLoanDto.getRepaidType());
        dbManager.setLong(29,prpCmainLoanDto.getPaidTimes());
        dbManager.setDouble(30,prpCmainLoanDto.getPerRepaidAmount());
        dbManager.setString(31,prpCmainLoanDto.getRemark());
        dbManager.setString(32,prpCmainLoanDto.getFlag());
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
        buffer.append("INSERT INTO PrpCmainLoan (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("GuaranteeType,");
        buffer.append("GuaranteeName,");
        buffer.append("MortgageNo,");
        buffer.append("WarrantorCode,");
        buffer.append("WarrantorName,");
        buffer.append("LoanNo1,");
        buffer.append("LoanNo2,");
        buffer.append("InstallmentFlag,");
        buffer.append("DeliverDate,");
        buffer.append("LoanContractNo,");
        buffer.append("LoanWay,");
        buffer.append("LoanNature,");
        buffer.append("LoanBankCode,");
        buffer.append("LoanBankName,");
        buffer.append("LoanUsage,");
        buffer.append("LoanStartDate,");
        buffer.append("LoanEndDate,");
        buffer.append("LoanYear,");
        buffer.append("PlanAmount,");
        buffer.append("FirstRate,");
        buffer.append("FirstPaid,");
        buffer.append("Currency,");
        buffer.append("LoanAmount,");
        buffer.append("LoanRate,");
        buffer.append("RepaidType,");
        buffer.append("PaidTimes,");
        buffer.append("PerRepaidAmount,");
        buffer.append("Remark,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCmainLoanDto prpCmainLoanDto = (PrpCmainLoanDto)i.next();
            dbManager.setString(1,prpCmainLoanDto.getPolicyNo());
            dbManager.setString(2,prpCmainLoanDto.getRiskCode());
            dbManager.setString(3,prpCmainLoanDto.getRiskKind());
            dbManager.setString(4,prpCmainLoanDto.getGuaranteeType());
            dbManager.setString(5,prpCmainLoanDto.getGuaranteeName());
            dbManager.setString(6,prpCmainLoanDto.getMortgageNo());
            dbManager.setString(7,prpCmainLoanDto.getWarrantorCode());
            dbManager.setString(8,prpCmainLoanDto.getWarrantorName());
            dbManager.setString(9,prpCmainLoanDto.getLoanNo1());
            dbManager.setString(10,prpCmainLoanDto.getLoanNo2());
            dbManager.setString(11,prpCmainLoanDto.getInstallmentFlag());
            dbManager.setDateTime(12,prpCmainLoanDto.getDeliverDate());
            dbManager.setString(13,prpCmainLoanDto.getLoanContractNo());
            dbManager.setString(14,prpCmainLoanDto.getLoanWay());
            dbManager.setString(15,prpCmainLoanDto.getLoanNature());
            dbManager.setString(16,prpCmainLoanDto.getLoanBankCode());
            dbManager.setString(17,prpCmainLoanDto.getLoanBankName());
            dbManager.setString(18,prpCmainLoanDto.getLoanUsage());
            dbManager.setDateTime(19,prpCmainLoanDto.getLoanStartDate());
            dbManager.setDateTime(20,prpCmainLoanDto.getLoanEndDate());
            dbManager.setInt(21,prpCmainLoanDto.getLoanYear());
            dbManager.setDouble(22,prpCmainLoanDto.getPlanAmount());
            dbManager.setDouble(23,prpCmainLoanDto.getFirstRate());
            dbManager.setDouble(24,prpCmainLoanDto.getFirstPaid());
            dbManager.setString(25,prpCmainLoanDto.getCurrency());
            dbManager.setDouble(26,prpCmainLoanDto.getLoanAmount());
            dbManager.setDouble(27,prpCmainLoanDto.getLoanRate());
            dbManager.setString(28,prpCmainLoanDto.getRepaidType());
            dbManager.setLong(29,prpCmainLoanDto.getPaidTimes());
            dbManager.setDouble(30,prpCmainLoanDto.getPerRepaidAmount());
            dbManager.setString(31,prpCmainLoanDto.getRemark());
            dbManager.setString(32,prpCmainLoanDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param policyNo PolicyNo
     * @throws Exception
     */
    public void delete(String policyNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCmainLoan ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCmainLoanDto prpCmainLoanDto
     * @throws Exception
     */
    public void update(PrpCmainLoanDto prpCmainLoanDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCmainLoan SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("RiskKind = ?, ");
        buffer.append("GuaranteeType = ?, ");
        buffer.append("GuaranteeName = ?, ");
        buffer.append("MortgageNo = ?, ");
        buffer.append("WarrantorCode = ?, ");
        buffer.append("WarrantorName = ?, ");
        buffer.append("LoanNo1 = ?, ");
        buffer.append("LoanNo2 = ?, ");
        buffer.append("InstallmentFlag = ?, ");
        buffer.append("DeliverDate = ?, ");
        buffer.append("LoanContractNo = ?, ");
        buffer.append("LoanWay = ?, ");
        buffer.append("LoanNature = ?, ");
        buffer.append("LoanBankCode = ?, ");
        buffer.append("LoanBankName = ?, ");
        buffer.append("LoanUsage = ?, ");
        buffer.append("LoanStartDate = ?, ");
        buffer.append("LoanEndDate = ?, ");
        buffer.append("LoanYear = ?, ");
        buffer.append("PlanAmount = ?, ");
        buffer.append("FirstRate = ?, ");
        buffer.append("FirstPaid = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("LoanAmount = ?, ");
        buffer.append("LoanRate = ?, ");
        buffer.append("RepaidType = ?, ");
        buffer.append("PaidTimes = ?, ");
        buffer.append("PerRepaidAmount = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCmainLoan SET ");
            debugBuffer.append("RiskCode = '" + prpCmainLoanDto.getRiskCode() + "', ");
            debugBuffer.append("RiskKind = '" + prpCmainLoanDto.getRiskKind() + "', ");
            debugBuffer.append("GuaranteeType = '" + prpCmainLoanDto.getGuaranteeType() + "', ");
            debugBuffer.append("GuaranteeName = '" + prpCmainLoanDto.getGuaranteeName() + "', ");
            debugBuffer.append("MortgageNo = '" + prpCmainLoanDto.getMortgageNo() + "', ");
            debugBuffer.append("WarrantorCode = '" + prpCmainLoanDto.getWarrantorCode() + "', ");
            debugBuffer.append("WarrantorName = '" + prpCmainLoanDto.getWarrantorName() + "', ");
            debugBuffer.append("LoanNo1 = '" + prpCmainLoanDto.getLoanNo1() + "', ");
            debugBuffer.append("LoanNo2 = '" + prpCmainLoanDto.getLoanNo2() + "', ");
            debugBuffer.append("InstallmentFlag = '" + prpCmainLoanDto.getInstallmentFlag() + "', ");
            debugBuffer.append("DeliverDate = '" + prpCmainLoanDto.getDeliverDate() + "', ");
            debugBuffer.append("LoanContractNo = '" + prpCmainLoanDto.getLoanContractNo() + "', ");
            debugBuffer.append("LoanWay = '" + prpCmainLoanDto.getLoanWay() + "', ");
            debugBuffer.append("LoanNature = '" + prpCmainLoanDto.getLoanNature() + "', ");
            debugBuffer.append("LoanBankCode = '" + prpCmainLoanDto.getLoanBankCode() + "', ");
            debugBuffer.append("LoanBankName = '" + prpCmainLoanDto.getLoanBankName() + "', ");
            debugBuffer.append("LoanUsage = '" + prpCmainLoanDto.getLoanUsage() + "', ");
            debugBuffer.append("LoanStartDate = '" + prpCmainLoanDto.getLoanStartDate() + "', ");
            debugBuffer.append("LoanEndDate = '" + prpCmainLoanDto.getLoanEndDate() + "', ");
            debugBuffer.append("LoanYear = " + prpCmainLoanDto.getLoanYear() + ", ");
            debugBuffer.append("PlanAmount = " + prpCmainLoanDto.getPlanAmount() + ", ");
            debugBuffer.append("FirstRate = " + prpCmainLoanDto.getFirstRate() + ", ");
            debugBuffer.append("FirstPaid = " + prpCmainLoanDto.getFirstPaid() + ", ");
            debugBuffer.append("Currency = '" + prpCmainLoanDto.getCurrency() + "', ");
            debugBuffer.append("LoanAmount = " + prpCmainLoanDto.getLoanAmount() + ", ");
            debugBuffer.append("LoanRate = " + prpCmainLoanDto.getLoanRate() + ", ");
            debugBuffer.append("RepaidType = '" + prpCmainLoanDto.getRepaidType() + "', ");
            debugBuffer.append("PaidTimes = " + prpCmainLoanDto.getPaidTimes() + ", ");
            debugBuffer.append("PerRepaidAmount = " + prpCmainLoanDto.getPerRepaidAmount() + ", ");
            debugBuffer.append("Remark = '" + prpCmainLoanDto.getRemark() + "', ");
            debugBuffer.append("flag = '" + prpCmainLoanDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCmainLoanDto.getPolicyNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpCmainLoanDto.getRiskCode());
        dbManager.setString(2,prpCmainLoanDto.getRiskKind());
        dbManager.setString(3,prpCmainLoanDto.getGuaranteeType());
        dbManager.setString(4,prpCmainLoanDto.getGuaranteeName());
        dbManager.setString(5,prpCmainLoanDto.getMortgageNo());
        dbManager.setString(6,prpCmainLoanDto.getWarrantorCode());
        dbManager.setString(7,prpCmainLoanDto.getWarrantorName());
        dbManager.setString(8,prpCmainLoanDto.getLoanNo1());
        dbManager.setString(9,prpCmainLoanDto.getLoanNo2());
        dbManager.setString(10,prpCmainLoanDto.getInstallmentFlag());
        dbManager.setDateTime(11,prpCmainLoanDto.getDeliverDate());
        dbManager.setString(12,prpCmainLoanDto.getLoanContractNo());
        dbManager.setString(13,prpCmainLoanDto.getLoanWay());
        dbManager.setString(14,prpCmainLoanDto.getLoanNature());
        dbManager.setString(15,prpCmainLoanDto.getLoanBankCode());
        dbManager.setString(16,prpCmainLoanDto.getLoanBankName());
        dbManager.setString(17,prpCmainLoanDto.getLoanUsage());
        dbManager.setDateTime(18,prpCmainLoanDto.getLoanStartDate());
        dbManager.setDateTime(19,prpCmainLoanDto.getLoanEndDate());
        dbManager.setInt(20,prpCmainLoanDto.getLoanYear());
        dbManager.setDouble(21,prpCmainLoanDto.getPlanAmount());
        dbManager.setDouble(22,prpCmainLoanDto.getFirstRate());
        dbManager.setDouble(23,prpCmainLoanDto.getFirstPaid());
        dbManager.setString(24,prpCmainLoanDto.getCurrency());
        dbManager.setDouble(25,prpCmainLoanDto.getLoanAmount());
        dbManager.setDouble(26,prpCmainLoanDto.getLoanRate());
        dbManager.setString(27,prpCmainLoanDto.getRepaidType());
        dbManager.setLong(28,prpCmainLoanDto.getPaidTimes());
        dbManager.setDouble(29,prpCmainLoanDto.getPerRepaidAmount());
        dbManager.setString(30,prpCmainLoanDto.getRemark());
        dbManager.setString(31,prpCmainLoanDto.getFlag());
        //设置条件字段;
        dbManager.setString(32,prpCmainLoanDto.getPolicyNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param policyNo PolicyNo
     * @return PrpCmainLoanDto
     * @throws Exception
     */
    public PrpCmainLoanDto findByPrimaryKey(String policyNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("GuaranteeType,");
        buffer.append("GuaranteeName,");
        buffer.append("MortgageNo,");
        buffer.append("WarrantorCode,");
        buffer.append("WarrantorName,");
        buffer.append("LoanNo1,");
        buffer.append("LoanNo2,");
        buffer.append("InstallmentFlag,");
        buffer.append("DeliverDate,");
        buffer.append("LoanContractNo,");
        buffer.append("LoanWay,");
        buffer.append("LoanNature,");
        buffer.append("LoanBankCode,");
        buffer.append("LoanBankName,");
        buffer.append("LoanUsage,");
        buffer.append("LoanStartDate,");
        buffer.append("LoanEndDate,");
        buffer.append("LoanYear,");
        buffer.append("PlanAmount,");
        buffer.append("FirstRate,");
        buffer.append("FirstPaid,");
        buffer.append("Currency,");
        buffer.append("LoanAmount,");
        buffer.append("LoanRate,");
        buffer.append("RepaidType,");
        buffer.append("PaidTimes,");
        buffer.append("PerRepaidAmount,");
        buffer.append("Remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpCmainLoan ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCmainLoanDto prpCmainLoanDto = null;
        if(resultSet.next()){
            prpCmainLoanDto = new PrpCmainLoanDto();
            prpCmainLoanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainLoanDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainLoanDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainLoanDto.setGuaranteeType(dbManager.getString(resultSet,4));
            prpCmainLoanDto.setGuaranteeName(dbManager.getString(resultSet,5));
            prpCmainLoanDto.setMortgageNo(dbManager.getString(resultSet,6));
            prpCmainLoanDto.setWarrantorCode(dbManager.getString(resultSet,7));
            prpCmainLoanDto.setWarrantorName(dbManager.getString(resultSet,8));
            prpCmainLoanDto.setLoanNo1(dbManager.getString(resultSet,9));
            prpCmainLoanDto.setLoanNo2(dbManager.getString(resultSet,10));
            prpCmainLoanDto.setInstallmentFlag(dbManager.getString(resultSet,11));
            prpCmainLoanDto.setDeliverDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpCmainLoanDto.setLoanContractNo(dbManager.getString(resultSet,13));
            prpCmainLoanDto.setLoanWay(dbManager.getString(resultSet,14));
            prpCmainLoanDto.setLoanNature(dbManager.getString(resultSet,15));
            prpCmainLoanDto.setLoanBankCode(dbManager.getString(resultSet,16));
            prpCmainLoanDto.setLoanBankName(dbManager.getString(resultSet,17));
            prpCmainLoanDto.setLoanUsage(dbManager.getString(resultSet,18));
            prpCmainLoanDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpCmainLoanDto.setLoanEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpCmainLoanDto.setLoanYear(dbManager.getInt(resultSet,21));
            prpCmainLoanDto.setPlanAmount(dbManager.getDouble(resultSet,22));
            prpCmainLoanDto.setFirstRate(dbManager.getDouble(resultSet,23));
            prpCmainLoanDto.setFirstPaid(dbManager.getDouble(resultSet,24));
            prpCmainLoanDto.setCurrency(dbManager.getString(resultSet,25));
            prpCmainLoanDto.setLoanAmount(dbManager.getDouble(resultSet,26));
            prpCmainLoanDto.setLoanRate(dbManager.getDouble(resultSet,27));
            prpCmainLoanDto.setRepaidType(dbManager.getString(resultSet,28));
            prpCmainLoanDto.setPaidTimes(dbManager.getLong(resultSet,29));
            prpCmainLoanDto.setPerRepaidAmount(dbManager.getDouble(resultSet,30));
            prpCmainLoanDto.setRemark(dbManager.getString(resultSet,31));
            prpCmainLoanDto.setFlag(dbManager.getString(resultSet,32));
        }
        resultSet.close();
        return prpCmainLoanDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("RiskKind,");
        buffer.append("GuaranteeType,");
        buffer.append("GuaranteeName,");
        buffer.append("MortgageNo,");
        buffer.append("WarrantorCode,");
        buffer.append("WarrantorName,");
        buffer.append("LoanNo1,");
        buffer.append("LoanNo2,");
        buffer.append("InstallmentFlag,");
        buffer.append("DeliverDate,");
        buffer.append("LoanContractNo,");
        buffer.append("LoanWay,");
        buffer.append("LoanNature,");
        buffer.append("LoanBankCode,");
        buffer.append("LoanBankName,");
        buffer.append("LoanUsage,");
        buffer.append("LoanStartDate,");
        buffer.append("LoanEndDate,");
        buffer.append("LoanYear,");
        buffer.append("PlanAmount,");
        buffer.append("FirstRate,");
        buffer.append("FirstPaid,");
        buffer.append("Currency,");
        buffer.append("LoanAmount,");
        buffer.append("LoanRate,");
        buffer.append("RepaidType,");
        buffer.append("PaidTimes,");
        buffer.append("PerRepaidAmount,");
        buffer.append("Remark,");
        buffer.append("flag ");
        buffer.append("FROM PrpCmainLoan WHERE ");
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
        PrpCmainLoanDto prpCmainLoanDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCmainLoanDto = new PrpCmainLoanDto();
            prpCmainLoanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainLoanDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCmainLoanDto.setRiskKind(dbManager.getString(resultSet,3));
            prpCmainLoanDto.setGuaranteeType(dbManager.getString(resultSet,4));
            prpCmainLoanDto.setGuaranteeName(dbManager.getString(resultSet,5));
            prpCmainLoanDto.setMortgageNo(dbManager.getString(resultSet,6));
            prpCmainLoanDto.setWarrantorCode(dbManager.getString(resultSet,7));
            prpCmainLoanDto.setWarrantorName(dbManager.getString(resultSet,8));
            prpCmainLoanDto.setLoanNo1(dbManager.getString(resultSet,9));
            prpCmainLoanDto.setLoanNo2(dbManager.getString(resultSet,10));
            prpCmainLoanDto.setInstallmentFlag(dbManager.getString(resultSet,11));
            prpCmainLoanDto.setDeliverDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpCmainLoanDto.setLoanContractNo(dbManager.getString(resultSet,13));
            prpCmainLoanDto.setLoanWay(dbManager.getString(resultSet,14));
            prpCmainLoanDto.setLoanNature(dbManager.getString(resultSet,15));
            prpCmainLoanDto.setLoanBankCode(dbManager.getString(resultSet,16));
            prpCmainLoanDto.setLoanBankName(dbManager.getString(resultSet,17));
            prpCmainLoanDto.setLoanUsage(dbManager.getString(resultSet,18));
            prpCmainLoanDto.setLoanStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpCmainLoanDto.setLoanEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpCmainLoanDto.setLoanYear(dbManager.getInt(resultSet,21));
            prpCmainLoanDto.setPlanAmount(dbManager.getDouble(resultSet,22));
            prpCmainLoanDto.setFirstRate(dbManager.getDouble(resultSet,23));
            prpCmainLoanDto.setFirstPaid(dbManager.getDouble(resultSet,24));
            prpCmainLoanDto.setCurrency(dbManager.getString(resultSet,25));
            prpCmainLoanDto.setLoanAmount(dbManager.getDouble(resultSet,26));
            prpCmainLoanDto.setLoanRate(dbManager.getDouble(resultSet,27));
            prpCmainLoanDto.setRepaidType(dbManager.getString(resultSet,28));
            prpCmainLoanDto.setPaidTimes(dbManager.getLong(resultSet,29));
            prpCmainLoanDto.setPerRepaidAmount(dbManager.getDouble(resultSet,30));
            prpCmainLoanDto.setRemark(dbManager.getString(resultSet,31));
            prpCmainLoanDto.setFlag(dbManager.getString(resultSet,32));
            collection.add(prpCmainLoanDto);
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
        buffer.append("DELETE FROM PrpCmainLoan WHERE ");
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
        statement="SELECT count(1) FROM PrpCmainLoan WHERE ";
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
