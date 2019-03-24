package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcarLoss的数据访问对象基类<br>
 * 创建于 2006-03-07 16:50:46.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcarLossBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLcarLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcarLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcarLossDto prpLcarLossDto
     * @throws Exception
     */
    public void insert(PrpLcarLossDto prpLcarLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcarLoss (");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("SumRest,");
        buffer.append("SumManager,");
        buffer.append("SumCertainLoss,");
        buffer.append("SumVeriRest,");
        buffer.append("SumVeriManager,");
        buffer.append("SumVerifyLoss,");
        buffer.append("LossDesc,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("VeriIndeDutyRate,");
        buffer.append("Remark,");
        buffer.append("ApproverCode,");
        buffer.append("CaseFlag,");
        buffer.append("Flag,");
        buffer.append("VINNo,");
        buffer.append("SumManageFeeRate,");
        buffer.append("BackCheckRemark,");
        buffer.append("BackCheckFlag,");
        buffer.append("HandlerRange,");
        buffer.append("SumTransFee,");
        buffer.append("SumTax,");
        buffer.append("OperatorCode, ");
        buffer.append("repairFactoryCode, ");
        buffer.append("repairFactoryName ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcarLossDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getLossItemName()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLcarLossDto.getSumRest()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumManager()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumCertainLoss()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumVeriRest()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumVeriManager()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumVerifyLoss()).append(",");
            debugBuffer.append("'").append(prpLcarLossDto.getLossDesc()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getIndemnityDuty()).append("',");
            debugBuffer.append("").append(prpLcarLossDto.getIndemnityDutyRate()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getVeriIndeDutyRate()).append(",");
            debugBuffer.append("'").append(prpLcarLossDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getApproverCode()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getCaseFlag()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getVINNo()).append("',");
            debugBuffer.append("").append(prpLcarLossDto.getSumManageFeeRate()).append(",");
            debugBuffer.append("'").append(prpLcarLossDto.getBackCheckRemark()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getBackCheckFlag()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getHandlerRange()).append("',");
            debugBuffer.append("").append(prpLcarLossDto.getSumTransFee()).append(",");
            debugBuffer.append("").append(prpLcarLossDto.getSumTax()).append(",");
            debugBuffer.append("'").append(prpLcarLossDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getRepairFactoryCode()).append("',");
            debugBuffer.append("'").append(prpLcarLossDto.getRepairFactoryName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcarLossDto.getClaimNo());
        dbManager.setString(2,prpLcarLossDto.getRiskCode());
        dbManager.setString(3,prpLcarLossDto.getRegistNo());
        dbManager.setString(4,prpLcarLossDto.getLossItemCode());
        dbManager.setString(5,prpLcarLossDto.getLossItemName());
        dbManager.setString(6,prpLcarLossDto.getPolicyNo());
        dbManager.setString(7,prpLcarLossDto.getCurrency());
        dbManager.setDouble(8,prpLcarLossDto.getSumRest());
        dbManager.setDouble(9,prpLcarLossDto.getSumManager());
        dbManager.setDouble(10,prpLcarLossDto.getSumCertainLoss());
        dbManager.setDouble(11,prpLcarLossDto.getSumVeriRest());
        dbManager.setDouble(12,prpLcarLossDto.getSumVeriManager());
        dbManager.setDouble(13,prpLcarLossDto.getSumVerifyLoss());
        dbManager.setString(14,prpLcarLossDto.getLossDesc());
        dbManager.setString(15,prpLcarLossDto.getIndemnityDuty());
        dbManager.setDouble(16,prpLcarLossDto.getIndemnityDutyRate());
        dbManager.setDouble(17,prpLcarLossDto.getVeriIndeDutyRate());
        dbManager.setString(18,prpLcarLossDto.getRemark());
        dbManager.setString(19,prpLcarLossDto.getApproverCode());
        dbManager.setString(20,prpLcarLossDto.getCaseFlag());
        dbManager.setString(21,prpLcarLossDto.getFlag());
        dbManager.setString(22,prpLcarLossDto.getVINNo());
        dbManager.setDouble(23,prpLcarLossDto.getSumManageFeeRate());
        dbManager.setString(24,prpLcarLossDto.getBackCheckRemark());
        dbManager.setString(25,prpLcarLossDto.getBackCheckFlag());
        dbManager.setString(26,prpLcarLossDto.getHandlerRange());
        dbManager.setDouble(27,prpLcarLossDto.getSumTransFee());
        dbManager.setDouble(28,prpLcarLossDto.getSumTax());
        dbManager.setString(29,prpLcarLossDto.getOperatorCode());
        dbManager.setString(30,prpLcarLossDto.getRepairFactoryCode());
        dbManager.setString(31,prpLcarLossDto.getRepairFactoryName());
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
        buffer.append("INSERT INTO PrpLcarLoss (");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("SumRest,");
        buffer.append("SumManager,");
        buffer.append("SumCertainLoss,");
        buffer.append("SumVeriRest,");
        buffer.append("SumVeriManager,");
        buffer.append("SumVerifyLoss,");
        buffer.append("LossDesc,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("VeriIndeDutyRate,");
        buffer.append("Remark,");
        buffer.append("ApproverCode,");
        buffer.append("CaseFlag,");
        buffer.append("Flag,");
        buffer.append("VINNo,");
        buffer.append("SumManageFeeRate,");
        buffer.append("BackCheckRemark,");
        buffer.append("BackCheckFlag,");
        buffer.append("HandlerRange,");
        buffer.append("SumTransFee,");
        buffer.append("SumTax,");
        buffer.append("OperatorCode,");
        buffer.append("repairFactoryCode,");
        buffer.append("repairFactoryName");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto)i.next();
            dbManager.setString(1,prpLcarLossDto.getClaimNo());
            dbManager.setString(2,prpLcarLossDto.getRiskCode());
            dbManager.setString(3,prpLcarLossDto.getRegistNo());
            dbManager.setString(4,prpLcarLossDto.getLossItemCode());
            dbManager.setString(5,prpLcarLossDto.getLossItemName());
            dbManager.setString(6,prpLcarLossDto.getPolicyNo());
            dbManager.setString(7,prpLcarLossDto.getCurrency());
            dbManager.setDouble(8,prpLcarLossDto.getSumRest());
            dbManager.setDouble(9,prpLcarLossDto.getSumManager());
            dbManager.setDouble(10,prpLcarLossDto.getSumCertainLoss());
            dbManager.setDouble(11,prpLcarLossDto.getSumVeriRest());
            dbManager.setDouble(12,prpLcarLossDto.getSumVeriManager());
            dbManager.setDouble(13,prpLcarLossDto.getSumVerifyLoss());
            dbManager.setString(14,prpLcarLossDto.getLossDesc());
            dbManager.setString(15,prpLcarLossDto.getIndemnityDuty());
            dbManager.setDouble(16,prpLcarLossDto.getIndemnityDutyRate());
            dbManager.setDouble(17,prpLcarLossDto.getVeriIndeDutyRate());
            dbManager.setString(18,prpLcarLossDto.getRemark());
            dbManager.setString(19,prpLcarLossDto.getApproverCode());
            dbManager.setString(20,prpLcarLossDto.getCaseFlag());
            dbManager.setString(21,prpLcarLossDto.getFlag());
            dbManager.setString(22,prpLcarLossDto.getVINNo());
            dbManager.setDouble(23,prpLcarLossDto.getSumManageFeeRate());
            dbManager.setString(24,prpLcarLossDto.getBackCheckRemark());
            dbManager.setString(25,prpLcarLossDto.getBackCheckFlag());
            dbManager.setString(26,prpLcarLossDto.getHandlerRange());
            dbManager.setDouble(27,prpLcarLossDto.getSumTransFee());
            dbManager.setDouble(28,prpLcarLossDto.getSumTax());
            dbManager.setString(29,prpLcarLossDto.getOperatorCode());
            dbManager.setString(30,prpLcarLossDto.getRepairFactoryCode());
            dbManager.setString(31,prpLcarLossDto.getRepairFactoryName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo RegistNo
     * @param lossItemCode LossItemCode
     * @throws Exception
     */
    public void delete(String registNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcarLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcarLossDto prpLcarLossDto
     * @throws Exception
     */
    public void update(PrpLcarLossDto prpLcarLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcarLoss SET ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("LossItemName = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumRest = ?, ");
        buffer.append("SumManager = ?, ");
        buffer.append("SumCertainLoss = ?, ");
        buffer.append("SumVeriRest = ?, ");
        buffer.append("SumVeriManager = ?, ");
        buffer.append("SumVerifyLoss = ?, ");
        buffer.append("LossDesc = ?, ");
        buffer.append("IndemnityDuty = ?, ");
        buffer.append("IndemnityDutyRate = ?, ");
        buffer.append("VeriIndeDutyRate = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("ApproverCode = ?, ");
        buffer.append("CaseFlag = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("VINNo = ?, ");
        buffer.append("SumManageFeeRate = ?, ");
        buffer.append("BackCheckRemark = ?, ");
        buffer.append("BackCheckFlag = ?, ");
        buffer.append("HandlerRange = ?, ");
        buffer.append("SumTransFee = ?, ");
        buffer.append("SumTax = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("repairFactoryCode = ?, ");
        buffer.append("repairFactoryName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcarLoss SET ");
            debugBuffer.append("ClaimNo = '" + prpLcarLossDto.getClaimNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLcarLossDto.getRiskCode() + "', ");
            debugBuffer.append("LossItemName = '" + prpLcarLossDto.getLossItemName() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLcarLossDto.getPolicyNo() + "', ");
            debugBuffer.append("Currency = '" + prpLcarLossDto.getCurrency() + "', ");
            debugBuffer.append("SumRest = " + prpLcarLossDto.getSumRest() + ", ");
            debugBuffer.append("SumManager = " + prpLcarLossDto.getSumManager() + ", ");
            debugBuffer.append("SumCertainLoss = " + prpLcarLossDto.getSumCertainLoss() + ", ");
            debugBuffer.append("SumVeriRest = " + prpLcarLossDto.getSumVeriRest() + ", ");
            debugBuffer.append("SumVeriManager = " + prpLcarLossDto.getSumVeriManager() + ", ");
            debugBuffer.append("SumVerifyLoss = " + prpLcarLossDto.getSumVerifyLoss() + ", ");
            debugBuffer.append("LossDesc = '" + prpLcarLossDto.getLossDesc() + "', ");
            debugBuffer.append("IndemnityDuty = '" + prpLcarLossDto.getIndemnityDuty() + "', ");
            debugBuffer.append("IndemnityDutyRate = " + prpLcarLossDto.getIndemnityDutyRate() + ", ");
            debugBuffer.append("VeriIndeDutyRate = " + prpLcarLossDto.getVeriIndeDutyRate() + ", ");
            debugBuffer.append("Remark = '" + prpLcarLossDto.getRemark() + "', ");
            debugBuffer.append("ApproverCode = '" + prpLcarLossDto.getApproverCode() + "', ");
            debugBuffer.append("CaseFlag = '" + prpLcarLossDto.getCaseFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLcarLossDto.getFlag() + "', ");
            debugBuffer.append("VINNo = '" + prpLcarLossDto.getVINNo() + "', ");
            debugBuffer.append("SumManageFeeRate = " + prpLcarLossDto.getSumManageFeeRate() + ", ");
            debugBuffer.append("BackCheckRemark = '" + prpLcarLossDto.getBackCheckRemark() + "', ");
            debugBuffer.append("BackCheckFlag = '" + prpLcarLossDto.getBackCheckFlag() + "', ");
            debugBuffer.append("HandlerRange = '" + prpLcarLossDto.getHandlerRange() + "', ");
            debugBuffer.append("SumTransFee = " + prpLcarLossDto.getSumTransFee() + ", ");
            debugBuffer.append("SumTax = " + prpLcarLossDto.getSumTax() + ", ");
            debugBuffer.append("OperatorCode = '" + prpLcarLossDto.getOperatorCode() + "', ");
            debugBuffer.append("repairFactoryCode= '" + prpLcarLossDto.getRepairFactoryCode() + "', ");
            debugBuffer.append("repairFactoryName= '" + prpLcarLossDto.getRepairFactoryName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLcarLossDto.getRegistNo()).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLcarLossDto.getLossItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLcarLossDto.getClaimNo());
        dbManager.setString(2,prpLcarLossDto.getRiskCode());
        dbManager.setString(3,prpLcarLossDto.getLossItemName());
        dbManager.setString(4,prpLcarLossDto.getPolicyNo());
        dbManager.setString(5,prpLcarLossDto.getCurrency());
        dbManager.setDouble(6,prpLcarLossDto.getSumRest());
        dbManager.setDouble(7,prpLcarLossDto.getSumManager());
        dbManager.setDouble(8,prpLcarLossDto.getSumCertainLoss());
        dbManager.setDouble(9,prpLcarLossDto.getSumVeriRest());
        dbManager.setDouble(10,prpLcarLossDto.getSumVeriManager());
        dbManager.setDouble(11,prpLcarLossDto.getSumVerifyLoss());
        dbManager.setString(12,prpLcarLossDto.getLossDesc());
        dbManager.setString(13,prpLcarLossDto.getIndemnityDuty());
        dbManager.setDouble(14,prpLcarLossDto.getIndemnityDutyRate());
        dbManager.setDouble(15,prpLcarLossDto.getVeriIndeDutyRate());
        dbManager.setString(16,prpLcarLossDto.getRemark());
        dbManager.setString(17,prpLcarLossDto.getApproverCode());
        dbManager.setString(18,prpLcarLossDto.getCaseFlag());
        dbManager.setString(19,prpLcarLossDto.getFlag());
        dbManager.setString(20,prpLcarLossDto.getVINNo());
        dbManager.setDouble(21,prpLcarLossDto.getSumManageFeeRate());
        dbManager.setString(22,prpLcarLossDto.getBackCheckRemark());
        dbManager.setString(23,prpLcarLossDto.getBackCheckFlag());
        dbManager.setString(24,prpLcarLossDto.getHandlerRange());
        dbManager.setDouble(25,prpLcarLossDto.getSumTransFee());
        dbManager.setDouble(26,prpLcarLossDto.getSumTax());
        dbManager.setString(27,prpLcarLossDto.getOperatorCode());
        dbManager.setString(28,prpLcarLossDto.getRepairFactoryCode());
        dbManager.setString(29,prpLcarLossDto.getRepairFactoryName());
        //设置条件字段;
        dbManager.setString(30,prpLcarLossDto.getRegistNo());
        dbManager.setString(31,prpLcarLossDto.getLossItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo RegistNo
     * @param lossItemCode LossItemCode
     * @return PrpLcarLossDto
     * @throws Exception
     */
    public PrpLcarLossDto findByPrimaryKey(String registNo,String lossItemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("SumRest,");
        buffer.append("SumManager,");
        buffer.append("SumCertainLoss,");
        buffer.append("SumVeriRest,");
        buffer.append("SumVeriManager,");
        buffer.append("SumVerifyLoss,");
        buffer.append("LossDesc,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("VeriIndeDutyRate,");
        buffer.append("Remark,");
        buffer.append("ApproverCode,");
        buffer.append("CaseFlag,");
        buffer.append("Flag,");
        buffer.append("VINNo,");
        buffer.append("SumManageFeeRate,");
        buffer.append("BackCheckRemark,");
        buffer.append("BackCheckFlag,");
        buffer.append("HandlerRange,");
        buffer.append("SumTransFee,");
        buffer.append("SumTax,");
        buffer.append("OperatorCode,");
        buffer.append("repairFactoryCode,");
        buffer.append("repairFactoryName ");
        buffer.append("FROM PrpLcarLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcarLossDto prpLcarLossDto = null;
        if(resultSet.next()){
            prpLcarLossDto = new PrpLcarLossDto();
            prpLcarLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcarLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcarLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcarLossDto.setLossItemCode(dbManager.getString(resultSet,4));
            prpLcarLossDto.setLossItemName(dbManager.getString(resultSet,5));
            prpLcarLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcarLossDto.setCurrency(dbManager.getString(resultSet,7));
            prpLcarLossDto.setSumRest(dbManager.getDouble(resultSet,8));
            prpLcarLossDto.setSumManager(dbManager.getDouble(resultSet,9));
            prpLcarLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,10));
            prpLcarLossDto.setSumVeriRest(dbManager.getDouble(resultSet,11));
            prpLcarLossDto.setSumVeriManager(dbManager.getDouble(resultSet,12));
            prpLcarLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,13));
            prpLcarLossDto.setLossDesc(dbManager.getString(resultSet,14));
            prpLcarLossDto.setIndemnityDuty(dbManager.getString(resultSet,15));
            prpLcarLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,16));
            prpLcarLossDto.setVeriIndeDutyRate(dbManager.getDouble(resultSet,17));
            prpLcarLossDto.setRemark(dbManager.getString(resultSet,18));
            prpLcarLossDto.setApproverCode(dbManager.getString(resultSet,19));
            prpLcarLossDto.setCaseFlag(dbManager.getString(resultSet,20));
            prpLcarLossDto.setFlag(dbManager.getString(resultSet,21));
            prpLcarLossDto.setVINNo(dbManager.getString(resultSet,22));
            prpLcarLossDto.setSumManageFeeRate(dbManager.getDouble(resultSet,23));
            prpLcarLossDto.setBackCheckRemark(dbManager.getString(resultSet,24));
            prpLcarLossDto.setBackCheckFlag(dbManager.getString(resultSet,25));
            prpLcarLossDto.setHandlerRange(dbManager.getString(resultSet,26));
            prpLcarLossDto.setSumTransFee(dbManager.getDouble(resultSet,27));
            prpLcarLossDto.setSumTax(dbManager.getDouble(resultSet,28));
            prpLcarLossDto.setOperatorCode(dbManager.getString(resultSet,29));
            prpLcarLossDto.setRepairFactoryCode(dbManager.getString(resultSet,30));
            prpLcarLossDto.setRepairFactoryName(dbManager.getString(resultSet,31));
        }
        resultSet.close();
        return prpLcarLossDto;
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
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("LossItemName,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("SumRest,");
        buffer.append("SumManager,");
        buffer.append("SumCertainLoss,");
        buffer.append("SumVeriRest,");
        buffer.append("SumVeriManager,");
        buffer.append("SumVerifyLoss,");
        buffer.append("LossDesc,");
        buffer.append("IndemnityDuty,");
        buffer.append("IndemnityDutyRate,");
        buffer.append("VeriIndeDutyRate,");
        buffer.append("Remark,");
        buffer.append("ApproverCode,");
        buffer.append("CaseFlag,");
        buffer.append("Flag,");
        buffer.append("VINNo,");
        buffer.append("SumManageFeeRate,");
        buffer.append("BackCheckRemark,");
        buffer.append("BackCheckFlag,");
        buffer.append("HandlerRange,");
        buffer.append("SumTransFee,");
        buffer.append("SumTax,");
        buffer.append("OperatorCode,");
        buffer.append("repairFactoryCode,");
        buffer.append("repairFactoryName ");
        buffer.append("FROM PrpLcarLoss WHERE ");
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
        PrpLcarLossDto prpLcarLossDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcarLossDto = new PrpLcarLossDto();
            prpLcarLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcarLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcarLossDto.setRegistNo(dbManager.getString(resultSet,3));
            prpLcarLossDto.setLossItemCode(dbManager.getString(resultSet,4));
            prpLcarLossDto.setLossItemName(dbManager.getString(resultSet,5));
            prpLcarLossDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLcarLossDto.setCurrency(dbManager.getString(resultSet,7));
            prpLcarLossDto.setSumRest(dbManager.getDouble(resultSet,8));
            prpLcarLossDto.setSumManager(dbManager.getDouble(resultSet,9));
            prpLcarLossDto.setSumCertainLoss(dbManager.getDouble(resultSet,10));
            prpLcarLossDto.setSumVeriRest(dbManager.getDouble(resultSet,11));
            prpLcarLossDto.setSumVeriManager(dbManager.getDouble(resultSet,12));
            prpLcarLossDto.setSumVerifyLoss(dbManager.getDouble(resultSet,13));
            prpLcarLossDto.setLossDesc(dbManager.getString(resultSet,14));
            prpLcarLossDto.setIndemnityDuty(dbManager.getString(resultSet,15));
            prpLcarLossDto.setIndemnityDutyRate(dbManager.getDouble(resultSet,16));
            prpLcarLossDto.setVeriIndeDutyRate(dbManager.getDouble(resultSet,17));
            prpLcarLossDto.setRemark(dbManager.getString(resultSet,18));
            prpLcarLossDto.setApproverCode(dbManager.getString(resultSet,19));
            prpLcarLossDto.setCaseFlag(dbManager.getString(resultSet,20));
            prpLcarLossDto.setFlag(dbManager.getString(resultSet,21));
            prpLcarLossDto.setVINNo(dbManager.getString(resultSet,22));
            prpLcarLossDto.setSumManageFeeRate(dbManager.getDouble(resultSet,23));
            prpLcarLossDto.setBackCheckRemark(dbManager.getString(resultSet,24));
            prpLcarLossDto.setBackCheckFlag(dbManager.getString(resultSet,25));
            prpLcarLossDto.setHandlerRange(dbManager.getString(resultSet,26));
            prpLcarLossDto.setSumTransFee(dbManager.getDouble(resultSet,27));
            prpLcarLossDto.setSumTax(dbManager.getDouble(resultSet,28));
            prpLcarLossDto.setOperatorCode(dbManager.getString(resultSet,29));
            prpLcarLossDto.setRepairFactoryCode(dbManager.getString(resultSet,30));
            prpLcarLossDto.setRepairFactoryName(dbManager.getString(resultSet,31));
            collection.add(prpLcarLossDto);
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
        buffer.append("DELETE FROM PrpLcarLoss WHERE ");
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
            statement = "SELECT count(1) FROM PrpLcarLoss WHERE ";
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
