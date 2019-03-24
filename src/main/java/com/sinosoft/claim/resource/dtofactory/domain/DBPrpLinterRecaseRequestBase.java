package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案参数中间表的数据访问对象基类<br>
 */
public class DBPrpLinterRecaseRequestBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterRecaseRequestBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterRecaseRequestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterRecaseRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("RelationOutId,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("AppRecaseReason,");
        buffer.append("ReClaimNotion,");
        buffer.append("ReClaimHandleText,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("ApplyRecaseTime,");
        buffer.append("ApplyRecaseUser,");
        buffer.append("AuditRecaseTime,");
        buffer.append("AuditUser,");
        buffer.append("VericTime,");
        buffer.append("VericUser,");
        buffer.append("MutualFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getRelationOutId()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getAppRecaseReason()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getReClaimNotion()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getReClaimHandleText()).append("',");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getMakeComName()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getReceiverName()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getAccount()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getAccountOK()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getZeroLossType()).append("',");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getSumNoDutyFee()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getPrplCompensateSumPaid()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getPrplCompensateSumPrePaid()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getSumChargePaid()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getSumThisPaid()).append(",");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getCompeContext()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getNotion()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getHandleText()).append("',");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getApplyRecaseTime()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getApplyRecaseUser()).append(",");
            debugBuffer.append("").append(prpLinterRecaseRequestDto.getAuditRecaseTime()).append(",");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getAuditUser()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getVericTime()).append("',");
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getVericUser()).append("',");
            
            
            debugBuffer.append("'").append(prpLinterRecaseRequestDto.getMutualFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterRecaseRequestDto.getId());
        dbManager.setString(2,prpLinterRecaseRequestDto.getOutId());
        dbManager.setString(3,prpLinterRecaseRequestDto.getRelationOutId());
        dbManager.setDateTime(4,prpLinterRecaseRequestDto.getInputDate());
        dbManager.setString(5,prpLinterRecaseRequestDto.getPolicyno());
        dbManager.setString(6,prpLinterRecaseRequestDto.getRegistno());
        dbManager.setString(7,prpLinterRecaseRequestDto.getClaimno());
        dbManager.setString(8,prpLinterRecaseRequestDto.getAppRecaseReason());
        dbManager.setString(9,prpLinterRecaseRequestDto.getReClaimNotion());
        dbManager.setString(10,prpLinterRecaseRequestDto.getReClaimHandleText());
        dbManager.setDouble(11,prpLinterRecaseRequestDto.getLossesNumber());
        dbManager.setString(12,prpLinterRecaseRequestDto.getOperatorCode());
        dbManager.setString(13,prpLinterRecaseRequestDto.getOperatorName());
        dbManager.setString(14,prpLinterRecaseRequestDto.getMakeCom());
        dbManager.setString(15,prpLinterRecaseRequestDto.getMakeComName());
        dbManager.setString(16,prpLinterRecaseRequestDto.getBank());
        dbManager.setString(17,prpLinterRecaseRequestDto.getReceiverName());
        dbManager.setString(18,prpLinterRecaseRequestDto.getAccount());
        dbManager.setString(19,prpLinterRecaseRequestDto.getAccountOK());
        dbManager.setString(20,prpLinterRecaseRequestDto.getZeroLossType());
        dbManager.setDouble(21,prpLinterRecaseRequestDto.getSumNoDutyFee());
        dbManager.setDouble(22,prpLinterRecaseRequestDto.getPrplCompensateSumPaid());
        dbManager.setDouble(23,prpLinterRecaseRequestDto.getPrplCompensateSumPrePaid());
        dbManager.setDouble(24,prpLinterRecaseRequestDto.getSumChargePaid());
        dbManager.setDouble(25,prpLinterRecaseRequestDto.getSumThisPaid());
        dbManager.setString(26,prpLinterRecaseRequestDto.getCompeContext());
        dbManager.setString(27,prpLinterRecaseRequestDto.getNotion());
        dbManager.setString(28,prpLinterRecaseRequestDto.getHandleText());
        dbManager.setDateTime(29,prpLinterRecaseRequestDto.getApplyRecaseTime());
        dbManager.setString(30,prpLinterRecaseRequestDto.getApplyRecaseUser());
        dbManager.setDateTime(31,prpLinterRecaseRequestDto.getAuditRecaseTime());
        dbManager.setString(32,prpLinterRecaseRequestDto.getAuditUser());
        dbManager.setDateTime(33,prpLinterRecaseRequestDto.getVericTime());
        dbManager.setString(34,prpLinterRecaseRequestDto.getVericUser());
        dbManager.setString(35,prpLinterRecaseRequestDto.getMutualFlag());
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
        buffer.append("INSERT INTO PrpLinterRecaseRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("RelationOutId,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("AppRecaseReason,");
        buffer.append("ReClaimNotion,");
        buffer.append("ReClaimHandleText,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("ApplyRecaseTime,");
        buffer.append("ApplyRecaseUser,");
        buffer.append("AuditRecaseTime,");
        buffer.append("AuditUser,");
        buffer.append("VericTime,");
        buffer.append("VericUser,");
        buffer.append("MutualFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)i.next();
            dbManager.setString(1,prpLinterRecaseRequestDto.getId());
            dbManager.setString(2,prpLinterRecaseRequestDto.getOutId());
            dbManager.setString(3,prpLinterRecaseRequestDto.getRelationOutId());
            dbManager.setDateTime(4,prpLinterRecaseRequestDto.getInputDate());
            dbManager.setString(5,prpLinterRecaseRequestDto.getPolicyno());
            dbManager.setString(6,prpLinterRecaseRequestDto.getRegistno());
            dbManager.setString(7,prpLinterRecaseRequestDto.getClaimno());
            dbManager.setString(8,prpLinterRecaseRequestDto.getAppRecaseReason());
            dbManager.setString(9,prpLinterRecaseRequestDto.getReClaimNotion());
            dbManager.setString(10,prpLinterRecaseRequestDto.getReClaimHandleText());
            dbManager.setDouble(11,prpLinterRecaseRequestDto.getLossesNumber());
            dbManager.setString(12,prpLinterRecaseRequestDto.getOperatorCode());
            dbManager.setString(13,prpLinterRecaseRequestDto.getOperatorName());
            dbManager.setString(14,prpLinterRecaseRequestDto.getMakeCom());
            dbManager.setString(15,prpLinterRecaseRequestDto.getMakeComName());
            dbManager.setString(16,prpLinterRecaseRequestDto.getBank());
            dbManager.setString(17,prpLinterRecaseRequestDto.getReceiverName());
            dbManager.setString(18,prpLinterRecaseRequestDto.getAccount());
            dbManager.setString(19,prpLinterRecaseRequestDto.getAccountOK());
            dbManager.setString(20,prpLinterRecaseRequestDto.getZeroLossType());
            dbManager.setDouble(21,prpLinterRecaseRequestDto.getSumNoDutyFee());
            dbManager.setDouble(22,prpLinterRecaseRequestDto.getPrplCompensateSumPaid());
            dbManager.setDouble(23,prpLinterRecaseRequestDto.getPrplCompensateSumPrePaid());
            dbManager.setDouble(24,prpLinterRecaseRequestDto.getSumChargePaid());
            dbManager.setDouble(25,prpLinterRecaseRequestDto.getSumThisPaid());
            dbManager.setString(26,prpLinterRecaseRequestDto.getCompeContext());
            dbManager.setString(27,prpLinterRecaseRequestDto.getNotion());
            dbManager.setString(28,prpLinterRecaseRequestDto.getHandleText());
            dbManager.setDateTime(29,prpLinterRecaseRequestDto.getApplyRecaseTime());
            dbManager.setString(30,prpLinterRecaseRequestDto.getApplyRecaseUser());
            dbManager.setDateTime(31,prpLinterRecaseRequestDto.getAuditRecaseTime());
            dbManager.setString(32,prpLinterRecaseRequestDto.getAuditUser());
            dbManager.setDateTime(33,prpLinterRecaseRequestDto.getVericTime());
            dbManager.setString(34,prpLinterRecaseRequestDto.getVericUser());
            dbManager.setString(35,prpLinterRecaseRequestDto.getMutualFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterRecaseRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void update(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterRecaseRequest SET ");
        buffer.append("OutId = ?, ");
        buffer.append("RelationOutId = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Registno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("AppRecaseReason = ?, ");
        buffer.append("ReClaimNotion = ?, ");
        buffer.append("ReClaimHandleText = ?, ");
        buffer.append("LossesNumber = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("OperatorName = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("MakeComName = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("ReceiverName = ?, ");
        buffer.append("Account = ?, ");
        buffer.append("AccountOK = ?, ");
        buffer.append("ZeroLossType = ?, ");
        buffer.append("SumNoDutyFee = ?, ");
        buffer.append("PrplCompensateSumPaid = ?, ");
        buffer.append("PrplCompensateSumPrePaid = ?, ");
        buffer.append("SumChargePaid = ?, ");
        buffer.append("SumThisPaid = ?, ");
        buffer.append("CompeContext = ?, ");
        buffer.append("Notion = ?, ");
        buffer.append("HandleText = ?, ");
        buffer.append("ApplyRecaseTime = ?, ");
        buffer.append("ApplyRecaseUser = ?, ");
        buffer.append("AuditRecaseTime = ?, ");
        buffer.append("AuditUser = ?, ");
        buffer.append("VericTime = ?, ");
        buffer.append("VericUser = ?, ");
        buffer.append("MutualFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterRecaseRequest SET ");
            debugBuffer.append("OutId = '" + prpLinterRecaseRequestDto.getOutId() + "', ");
            debugBuffer.append("RelationOutId = '" + prpLinterRecaseRequestDto.getRelationOutId() + "', ");
            debugBuffer.append("InputDate = '" + prpLinterRecaseRequestDto.getInputDate() + "', ");
            debugBuffer.append("Policyno = '" + prpLinterRecaseRequestDto.getPolicyno() + "', ");
            debugBuffer.append("Registno = '" + prpLinterRecaseRequestDto.getRegistno() + "', ");
            debugBuffer.append("Claimno = '" + prpLinterRecaseRequestDto.getClaimno() + "', ");
            debugBuffer.append("AppRecaseReason = '" + prpLinterRecaseRequestDto.getAppRecaseReason() + "', ");
            debugBuffer.append("ReClaimNotion = '" + prpLinterRecaseRequestDto.getReClaimNotion() + "', ");
            debugBuffer.append("ReClaimHandleText = '" + prpLinterRecaseRequestDto.getReClaimHandleText() + "', ");
            debugBuffer.append("LossesNumber = " + prpLinterRecaseRequestDto.getLossesNumber() + ", ");
            debugBuffer.append("OperatorCode = '" + prpLinterRecaseRequestDto.getOperatorCode() + "', ");
            debugBuffer.append("OperatorName = '" + prpLinterRecaseRequestDto.getOperatorName() + "', ");
            debugBuffer.append("MakeCom = '" + prpLinterRecaseRequestDto.getMakeCom() + "', ");
            debugBuffer.append("MakeComName = '" + prpLinterRecaseRequestDto.getMakeComName() + "', ");
            debugBuffer.append("Bank = '" + prpLinterRecaseRequestDto.getBank() + "', ");
            debugBuffer.append("ReceiverName = '" + prpLinterRecaseRequestDto.getReceiverName() + "', ");
            debugBuffer.append("Account = '" + prpLinterRecaseRequestDto.getAccount() + "', ");
            debugBuffer.append("AccountOK = '" + prpLinterRecaseRequestDto.getAccountOK() + "', ");
            debugBuffer.append("ZeroLossType = '" + prpLinterRecaseRequestDto.getZeroLossType() + "', ");
            debugBuffer.append("SumNoDutyFee = " + prpLinterRecaseRequestDto.getSumNoDutyFee() + ", ");
            debugBuffer.append("PrplCompensateSumPaid = " + prpLinterRecaseRequestDto.getPrplCompensateSumPaid() + ", ");
            debugBuffer.append("PrplCompensateSumPrePaid = " + prpLinterRecaseRequestDto.getPrplCompensateSumPrePaid() + ", ");
            debugBuffer.append("SumChargePaid = " + prpLinterRecaseRequestDto.getSumChargePaid() + ", ");
            debugBuffer.append("SumThisPaid = " + prpLinterRecaseRequestDto.getSumThisPaid() + ", ");
            debugBuffer.append("CompeContext = '" + prpLinterRecaseRequestDto.getCompeContext() + "', ");
            debugBuffer.append("Notion = '" + prpLinterRecaseRequestDto.getNotion() + "', ");
            debugBuffer.append("HandleText = '" + prpLinterRecaseRequestDto.getHandleText() + "', ");
            debugBuffer.append("ApplyRecaseTime = '" + prpLinterRecaseRequestDto.getApplyRecaseTime() + "', ");
            debugBuffer.append("ApplyRecaseUser = '" + prpLinterRecaseRequestDto.getApplyRecaseUser() + "', ");
            debugBuffer.append("AuditRecaseTime = '" + prpLinterRecaseRequestDto.getAuditRecaseTime() + "', ");
            debugBuffer.append("AuditUser = '" + prpLinterRecaseRequestDto.getAuditUser() + "', ");
            debugBuffer.append("VericTime = '" + prpLinterRecaseRequestDto.getVericTime() + "', ");
            debugBuffer.append("VericUser = '" + prpLinterRecaseRequestDto.getVericUser() + "', ");
            debugBuffer.append("MutualFlag = '" + prpLinterRecaseRequestDto.getMutualFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterRecaseRequestDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterRecaseRequestDto.getOutId());
        dbManager.setString(2,prpLinterRecaseRequestDto.getRelationOutId());
        dbManager.setDateTime(3,prpLinterRecaseRequestDto.getInputDate());
        dbManager.setString(4,prpLinterRecaseRequestDto.getPolicyno());
        dbManager.setString(5,prpLinterRecaseRequestDto.getRegistno());
        dbManager.setString(6,prpLinterRecaseRequestDto.getClaimno());
        dbManager.setString(7,prpLinterRecaseRequestDto.getAppRecaseReason());
        dbManager.setString(8,prpLinterRecaseRequestDto.getReClaimNotion());
        dbManager.setString(9,prpLinterRecaseRequestDto.getReClaimHandleText());
        dbManager.setDouble(10,prpLinterRecaseRequestDto.getLossesNumber());
        dbManager.setString(11,prpLinterRecaseRequestDto.getOperatorCode());
        dbManager.setString(12,prpLinterRecaseRequestDto.getOperatorName());
        dbManager.setString(13,prpLinterRecaseRequestDto.getMakeCom());
        dbManager.setString(14,prpLinterRecaseRequestDto.getMakeComName());
        dbManager.setString(15,prpLinterRecaseRequestDto.getBank());
        dbManager.setString(16,prpLinterRecaseRequestDto.getReceiverName());
        dbManager.setString(17,prpLinterRecaseRequestDto.getAccount());
        dbManager.setString(18,prpLinterRecaseRequestDto.getAccountOK());
        dbManager.setString(19,prpLinterRecaseRequestDto.getZeroLossType());
        dbManager.setDouble(20,prpLinterRecaseRequestDto.getSumNoDutyFee());
        dbManager.setDouble(21,prpLinterRecaseRequestDto.getPrplCompensateSumPaid());
        dbManager.setDouble(22,prpLinterRecaseRequestDto.getPrplCompensateSumPrePaid());
        dbManager.setDouble(23,prpLinterRecaseRequestDto.getSumChargePaid());
        dbManager.setDouble(24,prpLinterRecaseRequestDto.getSumThisPaid());
        dbManager.setString(25,prpLinterRecaseRequestDto.getCompeContext());
        dbManager.setString(26,prpLinterRecaseRequestDto.getNotion());
        dbManager.setString(27,prpLinterRecaseRequestDto.getHandleText());
        dbManager.setDateTime(28,prpLinterRecaseRequestDto.getApplyRecaseTime());
        dbManager.setString(29,prpLinterRecaseRequestDto.getApplyRecaseUser());
        dbManager.setDateTime(30,prpLinterRecaseRequestDto.getAuditRecaseTime());
        dbManager.setString(31,prpLinterRecaseRequestDto.getAuditUser());
        dbManager.setDateTime(32,prpLinterRecaseRequestDto.getVericTime());
        dbManager.setString(33,prpLinterRecaseRequestDto.getVericUser());
        dbManager.setString(34,prpLinterRecaseRequestDto.getMutualFlag());
        //设置条件字段;
        dbManager.setString(35,prpLinterRecaseRequestDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterRecaseRequestDto
     * @throws Exception
     */
    public PrpLinterRecaseRequestDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("RelationOutId,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("AppRecaseReason,");
        buffer.append("ReClaimNotion,");
        buffer.append("ReClaimHandleText,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("ApplyRecaseTime,");
        buffer.append("ApplyRecaseUser,");
        buffer.append("AuditRecaseTime,");
        buffer.append("AuditUser,");
        buffer.append("VericTime,");
        buffer.append("VericUser,");
        buffer.append("MutualFlag ");
        buffer.append("FROM PrpLinterRecaseRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        if(resultSet.next()){
            prpLinterRecaseRequestDto = new PrpLinterRecaseRequestDto();
            prpLinterRecaseRequestDto.setId(dbManager.getString(resultSet,1));
            prpLinterRecaseRequestDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterRecaseRequestDto.setRelationOutId(dbManager.getString(resultSet,3));
            prpLinterRecaseRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,4));
            prpLinterRecaseRequestDto.setPolicyno(dbManager.getString(resultSet,5));
            prpLinterRecaseRequestDto.setRegistno(dbManager.getString(resultSet,6));
            prpLinterRecaseRequestDto.setClaimno(dbManager.getString(resultSet,7));
            prpLinterRecaseRequestDto.setAppRecaseReason(dbManager.getString(resultSet,8));
            prpLinterRecaseRequestDto.setReClaimNotion(dbManager.getString(resultSet,9));
            prpLinterRecaseRequestDto.setReClaimHandleText(dbManager.getString(resultSet,10));
            prpLinterRecaseRequestDto.setLossesNumber(dbManager.getDouble(resultSet,11));
            prpLinterRecaseRequestDto.setOperatorCode(dbManager.getString(resultSet,12));
            prpLinterRecaseRequestDto.setOperatorName(dbManager.getString(resultSet,13));
            prpLinterRecaseRequestDto.setMakeCom(dbManager.getString(resultSet,14));
            prpLinterRecaseRequestDto.setMakeComName(dbManager.getString(resultSet,15));
            prpLinterRecaseRequestDto.setBank(dbManager.getString(resultSet,16));
            prpLinterRecaseRequestDto.setReceiverName(dbManager.getString(resultSet,17));
            prpLinterRecaseRequestDto.setAccount(dbManager.getString(resultSet,18));
            prpLinterRecaseRequestDto.setAccountOK(dbManager.getString(resultSet,19));
            prpLinterRecaseRequestDto.setZeroLossType(dbManager.getString(resultSet,20));
            prpLinterRecaseRequestDto.setSumNoDutyFee(dbManager.getDouble(resultSet,21));
            prpLinterRecaseRequestDto.setPrplCompensateSumPaid(dbManager.getDouble(resultSet,22));
            prpLinterRecaseRequestDto.setPrplCompensateSumPrePaid(dbManager.getDouble(resultSet,23));
            prpLinterRecaseRequestDto.setSumChargePaid(dbManager.getDouble(resultSet,24));
            prpLinterRecaseRequestDto.setSumThisPaid(dbManager.getDouble(resultSet,25));
            prpLinterRecaseRequestDto.setCompeContext(dbManager.getString(resultSet,26));
            prpLinterRecaseRequestDto.setNotion(dbManager.getString(resultSet,27));
            prpLinterRecaseRequestDto.setHandleText(dbManager.getString(resultSet,28));
            prpLinterRecaseRequestDto.setApplyRecaseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,29));
            prpLinterRecaseRequestDto.setApplyRecaseUser(dbManager.getString(resultSet,30));
            prpLinterRecaseRequestDto.setAuditRecaseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,31));
            prpLinterRecaseRequestDto.setAuditUser(dbManager.getString(resultSet,32));
            prpLinterRecaseRequestDto.setVericTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,33));
            prpLinterRecaseRequestDto.setVericUser(dbManager.getString(resultSet,34));
            prpLinterRecaseRequestDto.setMutualFlag(dbManager.getString(resultSet,35));
        }
        resultSet.close();
        return prpLinterRecaseRequestDto;
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
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("RelationOutId,");
        buffer.append("InputDate,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("AppRecaseReason,");
        buffer.append("ReClaimNotion,");
        buffer.append("ReClaimHandleText,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("Bank,");
        buffer.append("ReceiverName,");
        buffer.append("Account,");
        buffer.append("AccountOK,");
        buffer.append("ZeroLossType,");
        buffer.append("SumNoDutyFee,");
        buffer.append("PrplCompensateSumPaid,");
        buffer.append("PrplCompensateSumPrePaid,");
        buffer.append("SumChargePaid,");
        buffer.append("SumThisPaid,");
        buffer.append("CompeContext,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("ApplyRecaseTime,");
        buffer.append("ApplyRecaseUser,");
        buffer.append("AuditRecaseTime,");
        buffer.append("AuditUser,");
        buffer.append("VericTime,");
        buffer.append("VericUser,");
        buffer.append("MutualFlag ");
        buffer.append("FROM PrpLinterRecaseRequest WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterRecaseRequestDto = new PrpLinterRecaseRequestDto();
            prpLinterRecaseRequestDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterRecaseRequestDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterRecaseRequestDto.setRelationOutId(dbManager.getString(resultSet,"RelationOutId"));
            prpLinterRecaseRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prpLinterRecaseRequestDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prpLinterRecaseRequestDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prpLinterRecaseRequestDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prpLinterRecaseRequestDto.setAppRecaseReason(dbManager.getString(resultSet,"AppRecaseReason"));
            prpLinterRecaseRequestDto.setReClaimNotion(dbManager.getString(resultSet,"ReClaimNotion"));
            prpLinterRecaseRequestDto.setReClaimHandleText(dbManager.getString(resultSet,"ReClaimHandleText"));
            prpLinterRecaseRequestDto.setLossesNumber(dbManager.getDouble(resultSet,"LossesNumber"));
            prpLinterRecaseRequestDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLinterRecaseRequestDto.setOperatorName(dbManager.getString(resultSet,"OperatorName"));
            prpLinterRecaseRequestDto.setMakeCom(dbManager.getString(resultSet,"MakeCom"));
            prpLinterRecaseRequestDto.setMakeComName(dbManager.getString(resultSet,"MakeComName"));
            prpLinterRecaseRequestDto.setBank(dbManager.getString(resultSet,"Bank"));
            prpLinterRecaseRequestDto.setReceiverName(dbManager.getString(resultSet,"ReceiverName"));
            prpLinterRecaseRequestDto.setAccount(dbManager.getString(resultSet,"Account"));
            prpLinterRecaseRequestDto.setAccountOK(dbManager.getString(resultSet,"AccountOK"));
            prpLinterRecaseRequestDto.setZeroLossType(dbManager.getString(resultSet,"ZeroLossType"));
            prpLinterRecaseRequestDto.setSumNoDutyFee(dbManager.getDouble(resultSet,"SumNoDutyFee"));
            prpLinterRecaseRequestDto.setPrplCompensateSumPaid(dbManager.getDouble(resultSet,"PrplCompensateSumPaid"));
            prpLinterRecaseRequestDto.setPrplCompensateSumPrePaid(dbManager.getDouble(resultSet,"PrplCompensateSumPrePaid"));
            prpLinterRecaseRequestDto.setSumChargePaid(dbManager.getDouble(resultSet,"SumChargePaid"));
            prpLinterRecaseRequestDto.setSumThisPaid(dbManager.getDouble(resultSet,"SumThisPaid"));
            prpLinterRecaseRequestDto.setCompeContext(dbManager.getString(resultSet,"CompeContext"));
            prpLinterRecaseRequestDto.setNotion(dbManager.getString(resultSet,"Notion"));
            prpLinterRecaseRequestDto.setHandleText(dbManager.getString(resultSet,"HandleText"));
            prpLinterRecaseRequestDto.setApplyRecaseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"ApplyRecaseTime"));
            prpLinterRecaseRequestDto.setApplyRecaseUser(dbManager.getString(resultSet,"ApplyRecaseUser"));
            prpLinterRecaseRequestDto.setAuditRecaseTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"AuditRecaseTime"));
            prpLinterRecaseRequestDto.setAuditUser(dbManager.getString(resultSet,"AuditUser"));
            prpLinterRecaseRequestDto.setVericTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"VericTime"));
            prpLinterRecaseRequestDto.setVericUser(dbManager.getString(resultSet,"VericUser"));
            prpLinterRecaseRequestDto.setMutualFlag(dbManager.getString(resultSet,"MutualFlag"));
            collection.add(prpLinterRecaseRequestDto);
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
        buffer.append("DELETE FROM PrpLinterRecaseRequest WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterRecaseRequest WHERE ");
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
