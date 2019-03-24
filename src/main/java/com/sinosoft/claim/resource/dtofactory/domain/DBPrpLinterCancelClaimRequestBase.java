package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案注销传入参主数的数据访问对象基类<br>
 */
public class DBPrpLinterCancelClaimRequestBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCancelClaimRequestBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterCancelClaimRequestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCancelClaimRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportorName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("InputDate,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("OutRegistNo,");
        buffer.append("CaseType,");
        buffer.append("CancelReson,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("CancelContext ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDamageStartDate()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDamageStartHour()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDamageCode()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getReportorName()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getReportDate()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getReportHour()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getReportType()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getLinkerName()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getLinkerAddress()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDamageAddress()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDamageTypeCode()).append("',");
            debugBuffer.append("").append(prpLinterCancelClaimRequestDto.getLossesNumber()).append(",");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getMakeComName()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getContext()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getCancelDate()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getDealerCode()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getOutRegistNo()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getCancelReson()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getNotion()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getHandleText()).append("',");
            debugBuffer.append("'").append(prpLinterCancelClaimRequestDto.getCancelContext()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCancelClaimRequestDto.getId());
        dbManager.setString(2,prpLinterCancelClaimRequestDto.getOutId());
        dbManager.setString(3,prpLinterCancelClaimRequestDto.getPolicyno());
        dbManager.setString(4,prpLinterCancelClaimRequestDto.getRegistNo());
        dbManager.setString(5,prpLinterCancelClaimRequestDto.getClaimNo());
        dbManager.setDateTime(6,prpLinterCancelClaimRequestDto.getDamageStartDate());
        dbManager.setString(7,prpLinterCancelClaimRequestDto.getDamageStartHour());
        dbManager.setString(8,prpLinterCancelClaimRequestDto.getDamageCode());
        dbManager.setString(9,prpLinterCancelClaimRequestDto.getReportorName());
        dbManager.setDateTime(10,prpLinterCancelClaimRequestDto.getReportDate());
        dbManager.setString(11,prpLinterCancelClaimRequestDto.getReportHour());
        dbManager.setString(12,prpLinterCancelClaimRequestDto.getReportType());
        dbManager.setString(13,prpLinterCancelClaimRequestDto.getLinkerName());
        dbManager.setString(14,prpLinterCancelClaimRequestDto.getPhoneNumber());
        dbManager.setString(15,prpLinterCancelClaimRequestDto.getLinkerAddress());
        dbManager.setString(16,prpLinterCancelClaimRequestDto.getClauseType());
        dbManager.setString(17,prpLinterCancelClaimRequestDto.getDamageAddress());
        dbManager.setString(18,prpLinterCancelClaimRequestDto.getDamageTypeCode());
        dbManager.setDouble(19,prpLinterCancelClaimRequestDto.getLossesNumber());
        dbManager.setString(20,prpLinterCancelClaimRequestDto.getOperatorCode());
        dbManager.setString(21,prpLinterCancelClaimRequestDto.getOperatorName());
        dbManager.setString(22,prpLinterCancelClaimRequestDto.getMakeCom());
        dbManager.setString(23,prpLinterCancelClaimRequestDto.getMakeComName());
        dbManager.setDateTime(24,prpLinterCancelClaimRequestDto.getInputDate());
        dbManager.setString(25,prpLinterCancelClaimRequestDto.getRemark());
        dbManager.setString(26,prpLinterCancelClaimRequestDto.getContext());
        dbManager.setDateTime(27,prpLinterCancelClaimRequestDto.getCancelDate());
        dbManager.setString(28,prpLinterCancelClaimRequestDto.getDealerCode());
        dbManager.setString(29,prpLinterCancelClaimRequestDto.getOutRegistNo());
        dbManager.setString(30,prpLinterCancelClaimRequestDto.getCaseType());
        dbManager.setString(31,prpLinterCancelClaimRequestDto.getCancelReson());
        dbManager.setString(32,prpLinterCancelClaimRequestDto.getNotion());
        dbManager.setString(33,prpLinterCancelClaimRequestDto.getHandleText());
        dbManager.setString(34,prpLinterCancelClaimRequestDto.getCancelContext());
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
        buffer.append("INSERT INTO PrpLinterCancelClaimRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportorName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("InputDate,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("OutRegistNo,");
        buffer.append("CaseType,");
        buffer.append("CancelReson,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("CancelContext ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = (PrpLinterCancelClaimRequestDto)i.next();
            dbManager.setString(1,prpLinterCancelClaimRequestDto.getId());
            dbManager.setString(2,prpLinterCancelClaimRequestDto.getOutId());
            dbManager.setString(3,prpLinterCancelClaimRequestDto.getPolicyno());
            dbManager.setString(4,prpLinterCancelClaimRequestDto.getRegistNo());
            dbManager.setString(5,prpLinterCancelClaimRequestDto.getClaimNo());
            dbManager.setDateTime(6,prpLinterCancelClaimRequestDto.getDamageStartDate());
            dbManager.setString(7,prpLinterCancelClaimRequestDto.getDamageStartHour());
            dbManager.setString(8,prpLinterCancelClaimRequestDto.getDamageCode());
            dbManager.setString(9,prpLinterCancelClaimRequestDto.getReportorName());
            dbManager.setDateTime(10,prpLinterCancelClaimRequestDto.getReportDate());
            dbManager.setString(11,prpLinterCancelClaimRequestDto.getReportHour());
            dbManager.setString(12,prpLinterCancelClaimRequestDto.getReportType());
            dbManager.setString(13,prpLinterCancelClaimRequestDto.getLinkerName());
            dbManager.setString(14,prpLinterCancelClaimRequestDto.getPhoneNumber());
            dbManager.setString(15,prpLinterCancelClaimRequestDto.getLinkerAddress());
            dbManager.setString(16,prpLinterCancelClaimRequestDto.getClauseType());
            dbManager.setString(17,prpLinterCancelClaimRequestDto.getDamageAddress());
            dbManager.setString(18,prpLinterCancelClaimRequestDto.getDamageTypeCode());
            dbManager.setDouble(19,prpLinterCancelClaimRequestDto.getLossesNumber());
            dbManager.setString(20,prpLinterCancelClaimRequestDto.getOperatorCode());
            dbManager.setString(21,prpLinterCancelClaimRequestDto.getOperatorName());
            dbManager.setString(22,prpLinterCancelClaimRequestDto.getMakeCom());
            dbManager.setString(23,prpLinterCancelClaimRequestDto.getMakeComName());
            dbManager.setDateTime(24,prpLinterCancelClaimRequestDto.getInputDate());
            dbManager.setString(25,prpLinterCancelClaimRequestDto.getRemark());
            dbManager.setString(26,prpLinterCancelClaimRequestDto.getContext());
            dbManager.setDateTime(27,prpLinterCancelClaimRequestDto.getCancelDate());
            dbManager.setString(28,prpLinterCancelClaimRequestDto.getDealerCode());
            dbManager.setString(29,prpLinterCancelClaimRequestDto.getOutRegistNo());
            dbManager.setString(30,prpLinterCancelClaimRequestDto.getCaseType());
            dbManager.setString(31,prpLinterCancelClaimRequestDto.getCancelReson());
            dbManager.setString(32,prpLinterCancelClaimRequestDto.getNotion());
            dbManager.setString(33,prpLinterCancelClaimRequestDto.getHandleText());
            dbManager.setString(34,prpLinterCancelClaimRequestDto.getCancelContext());
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
        buffer.append("DELETE FROM PrpLinterCancelClaimRequest ");
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
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void update(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCancelClaimRequest SET ");
        buffer.append("OutId = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("RegistNo = ?, ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("DamageStartDate = ?, ");
        buffer.append("DamageStartHour = ?, ");
        buffer.append("DamageCode = ?, ");
        buffer.append("ReportorName = ?, ");
        buffer.append("ReportDate = ?, ");
        buffer.append("ReportHour = ?, ");
        buffer.append("ReportType = ?, ");
        buffer.append("LinkerName = ?, ");
        buffer.append("PhoneNumber = ?, ");
        buffer.append("LinkerAddress = ?, ");
        buffer.append("ClauseType = ?, ");
        buffer.append("DamageAddress = ?, ");
        buffer.append("DamageTypeCode = ?, ");
        buffer.append("LossesNumber = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("OperatorName = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("MakeComName = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Context = ?, ");
        buffer.append("CancelDate = ?, ");
        buffer.append("DealerCode = ?, ");
        buffer.append("OutRegistNo = ?, ");
        buffer.append("CaseType = ?, ");
        buffer.append("CancelReson = ?, ");
        buffer.append("Notion = ?, ");
        buffer.append("HandleText = ?, ");
        buffer.append("CancelContext = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCancelClaimRequest SET ");
            debugBuffer.append("OutId = '" + prpLinterCancelClaimRequestDto.getOutId() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLinterCancelClaimRequestDto.getPolicyno() + "', ");
            debugBuffer.append("RegistNo = '" + prpLinterCancelClaimRequestDto.getRegistNo() + "', ");
            debugBuffer.append("ClaimNo = '" + prpLinterCancelClaimRequestDto.getClaimNo() + "', ");
            debugBuffer.append("DamageStartDate = '" + prpLinterCancelClaimRequestDto.getDamageStartDate() + "', ");
            debugBuffer.append("DamageStartHour = '" + prpLinterCancelClaimRequestDto.getDamageStartHour() + "', ");
            debugBuffer.append("DamageCode = '" + prpLinterCancelClaimRequestDto.getDamageCode() + "', ");
            debugBuffer.append("ReportorName = '" + prpLinterCancelClaimRequestDto.getReportorName() + "', ");
            debugBuffer.append("ReportDate = '" + prpLinterCancelClaimRequestDto.getReportDate() + "', ");
            debugBuffer.append("ReportHour = '" + prpLinterCancelClaimRequestDto.getReportHour() + "', ");
            debugBuffer.append("ReportType = '" + prpLinterCancelClaimRequestDto.getReportType() + "', ");
            debugBuffer.append("LinkerName = '" + prpLinterCancelClaimRequestDto.getLinkerName() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpLinterCancelClaimRequestDto.getPhoneNumber() + "', ");
            debugBuffer.append("LinkerAddress = '" + prpLinterCancelClaimRequestDto.getLinkerAddress() + "', ");
            debugBuffer.append("ClauseType = '" + prpLinterCancelClaimRequestDto.getClauseType() + "', ");
            debugBuffer.append("DamageAddress = '" + prpLinterCancelClaimRequestDto.getDamageAddress() + "', ");
            debugBuffer.append("DamageTypeCode = '" + prpLinterCancelClaimRequestDto.getDamageTypeCode() + "', ");
            debugBuffer.append("LossesNumber = " + prpLinterCancelClaimRequestDto.getLossesNumber() + ", ");
            debugBuffer.append("OperatorCode = '" + prpLinterCancelClaimRequestDto.getOperatorCode() + "', ");
            debugBuffer.append("OperatorName = '" + prpLinterCancelClaimRequestDto.getOperatorName() + "', ");
            debugBuffer.append("MakeCom = '" + prpLinterCancelClaimRequestDto.getMakeCom() + "', ");
            debugBuffer.append("MakeComName = '" + prpLinterCancelClaimRequestDto.getMakeComName() + "', ");
            debugBuffer.append("InputDate = '" + prpLinterCancelClaimRequestDto.getInputDate() + "', ");
            debugBuffer.append("Remark = '" + prpLinterCancelClaimRequestDto.getRemark() + "', ");
            debugBuffer.append("Context = '" + prpLinterCancelClaimRequestDto.getContext() + "', ");
            debugBuffer.append("CancelDate = '" + prpLinterCancelClaimRequestDto.getCancelDate() + "', ");
            debugBuffer.append("DealerCode = '" + prpLinterCancelClaimRequestDto.getDealerCode() + "', ");
            debugBuffer.append("OutRegistNo= '" + prpLinterCancelClaimRequestDto.getOutRegistNo()+ "', ");
            debugBuffer.append("CaseType= '" + prpLinterCancelClaimRequestDto.getCaseType()+ "', ");
            debugBuffer.append("CancelReson= '" + prpLinterCancelClaimRequestDto.getCancelReson()+ "', ");
            debugBuffer.append("Notion= '" + prpLinterCancelClaimRequestDto.getNotion()+ "', ");
            debugBuffer.append("HandleText= '" + prpLinterCancelClaimRequestDto.getHandleText()+ "', ");
            debugBuffer.append("CancelContext = '" + prpLinterCancelClaimRequestDto.getCancelContext() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCancelClaimRequestDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterCancelClaimRequestDto.getOutId());
        dbManager.setString(2,prpLinterCancelClaimRequestDto.getPolicyno());
        dbManager.setString(3,prpLinterCancelClaimRequestDto.getRegistNo());
        dbManager.setString(4,prpLinterCancelClaimRequestDto.getClaimNo());
        dbManager.setDateTime(5,prpLinterCancelClaimRequestDto.getDamageStartDate());
        dbManager.setString(6,prpLinterCancelClaimRequestDto.getDamageStartHour());
        dbManager.setString(7,prpLinterCancelClaimRequestDto.getDamageCode());
        dbManager.setString(8,prpLinterCancelClaimRequestDto.getReportorName());
        dbManager.setDateTime(9,prpLinterCancelClaimRequestDto.getReportDate());
        dbManager.setString(10,prpLinterCancelClaimRequestDto.getReportHour());
        dbManager.setString(11,prpLinterCancelClaimRequestDto.getReportType());
        dbManager.setString(12,prpLinterCancelClaimRequestDto.getLinkerName());
        dbManager.setString(13,prpLinterCancelClaimRequestDto.getPhoneNumber());
        dbManager.setString(14,prpLinterCancelClaimRequestDto.getLinkerAddress());
        dbManager.setString(15,prpLinterCancelClaimRequestDto.getClauseType());
        dbManager.setString(16,prpLinterCancelClaimRequestDto.getDamageAddress());
        dbManager.setString(17,prpLinterCancelClaimRequestDto.getDamageTypeCode());
        dbManager.setDouble(18,prpLinterCancelClaimRequestDto.getLossesNumber());
        dbManager.setString(19,prpLinterCancelClaimRequestDto.getOperatorCode());
        dbManager.setString(20,prpLinterCancelClaimRequestDto.getOperatorName());
        dbManager.setString(21,prpLinterCancelClaimRequestDto.getMakeCom());
        dbManager.setString(22,prpLinterCancelClaimRequestDto.getMakeComName());
        dbManager.setDateTime(23,prpLinterCancelClaimRequestDto.getInputDate());
        dbManager.setString(24,prpLinterCancelClaimRequestDto.getRemark());
        dbManager.setString(25,prpLinterCancelClaimRequestDto.getContext());
        dbManager.setDateTime(26,prpLinterCancelClaimRequestDto.getCancelDate());
        dbManager.setString(27,prpLinterCancelClaimRequestDto.getDealerCode());
        dbManager.setString(28,prpLinterCancelClaimRequestDto.getOutRegistNo());
        dbManager.setString(29,prpLinterCancelClaimRequestDto.getCaseType());
        dbManager.setString(30,prpLinterCancelClaimRequestDto.getCancelReson());
        dbManager.setString(31,prpLinterCancelClaimRequestDto.getNotion());
        dbManager.setString(32,prpLinterCancelClaimRequestDto.getHandleText());
        dbManager.setString(33,prpLinterCancelClaimRequestDto.getCancelContext());
        //设置条件字段;
        dbManager.setString(34,prpLinterCancelClaimRequestDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public PrpLinterCancelClaimRequestDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportorName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("InputDate,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("OutRegistNo,");
        buffer.append("CaseType,");
        buffer.append("CancelReson,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("CancelContext ");
        buffer.append("FROM PrpLinterCancelClaimRequest ");
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
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        if(resultSet.next()){
            prpLinterCancelClaimRequestDto = new PrpLinterCancelClaimRequestDto();
            prpLinterCancelClaimRequestDto.setId(dbManager.getString(resultSet,1));
            prpLinterCancelClaimRequestDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterCancelClaimRequestDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLinterCancelClaimRequestDto.setRegistNo(dbManager.getString(resultSet,4));
            prpLinterCancelClaimRequestDto.setClaimNo(dbManager.getString(resultSet,5));
            prpLinterCancelClaimRequestDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLinterCancelClaimRequestDto.setDamageStartHour(dbManager.getString(resultSet,7));
            prpLinterCancelClaimRequestDto.setDamageCode(dbManager.getString(resultSet,8));
            prpLinterCancelClaimRequestDto.setReportorName(dbManager.getString(resultSet,9));
            prpLinterCancelClaimRequestDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLinterCancelClaimRequestDto.setReportHour(dbManager.getString(resultSet,11));
            prpLinterCancelClaimRequestDto.setReportType(dbManager.getString(resultSet,12));
            prpLinterCancelClaimRequestDto.setLinkerName(dbManager.getString(resultSet,13));
            prpLinterCancelClaimRequestDto.setPhoneNumber(dbManager.getString(resultSet,14));
            prpLinterCancelClaimRequestDto.setLinkerAddress(dbManager.getString(resultSet,15));
            prpLinterCancelClaimRequestDto.setClauseType(dbManager.getString(resultSet,16));
            prpLinterCancelClaimRequestDto.setDamageAddress(dbManager.getString(resultSet,17));
            prpLinterCancelClaimRequestDto.setDamageTypeCode(dbManager.getString(resultSet,18));
            prpLinterCancelClaimRequestDto.setLossesNumber(dbManager.getDouble(resultSet,19));
            prpLinterCancelClaimRequestDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLinterCancelClaimRequestDto.setOperatorName(dbManager.getString(resultSet,21));
            prpLinterCancelClaimRequestDto.setMakeCom(dbManager.getString(resultSet,22));
            prpLinterCancelClaimRequestDto.setMakeComName(dbManager.getString(resultSet,23));
            prpLinterCancelClaimRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prpLinterCancelClaimRequestDto.setRemark(dbManager.getString(resultSet,25));
            prpLinterCancelClaimRequestDto.setContext(dbManager.getString(resultSet,26));
            prpLinterCancelClaimRequestDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLinterCancelClaimRequestDto.setDealerCode(dbManager.getString(resultSet,28));
            prpLinterCancelClaimRequestDto.setOutRegistNo(dbManager.getString(resultSet,29));
            prpLinterCancelClaimRequestDto.setCaseType(dbManager.getString(resultSet,30));
            prpLinterCancelClaimRequestDto.setCancelReson(dbManager.getString(resultSet,31));
            prpLinterCancelClaimRequestDto.setNotion(dbManager.getString(resultSet,32));
            prpLinterCancelClaimRequestDto.setHandleText(dbManager.getString(resultSet,33));
            prpLinterCancelClaimRequestDto.setCancelContext(dbManager.getString(resultSet,29));
        }
        resultSet.close();
        return prpLinterCancelClaimRequestDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RegistNo,");
        buffer.append("ClaimNo,");
        buffer.append("DamageStartDate,");
        buffer.append("DamageStartHour,");
        buffer.append("DamageCode,");
        buffer.append("ReportorName,");
        buffer.append("ReportDate,");
        buffer.append("ReportHour,");
        buffer.append("ReportType,");
        buffer.append("LinkerName,");
        buffer.append("PhoneNumber,");
        buffer.append("LinkerAddress,");
        buffer.append("ClauseType,");
        buffer.append("DamageAddress,");
        buffer.append("DamageTypeCode,");
        buffer.append("LossesNumber,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("InputDate,");
        buffer.append("Remark,");
        buffer.append("Context,");
        buffer.append("CancelDate,");
        buffer.append("DealerCode,");
        buffer.append("OutRegistNo,");
        buffer.append("CaseType,");
        buffer.append("CancelReson,");
        buffer.append("Notion,");
        buffer.append("HandleText,");
        buffer.append("CancelContext ");
        buffer.append("FROM PrpLinterCancelClaimRequest WHERE ");
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
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCancelClaimRequestDto = new PrpLinterCancelClaimRequestDto();
            prpLinterCancelClaimRequestDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCancelClaimRequestDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterCancelClaimRequestDto.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpLinterCancelClaimRequestDto.setRegistNo(dbManager.getString(resultSet,"RegistNo"));
            prpLinterCancelClaimRequestDto.setClaimNo(dbManager.getString(resultSet,"ClaimNo"));
            prpLinterCancelClaimRequestDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"DamageStartDate"));
            prpLinterCancelClaimRequestDto.setDamageStartHour(dbManager.getString(resultSet,"DamageStartHour"));
            prpLinterCancelClaimRequestDto.setDamageCode(dbManager.getString(resultSet,"DamageCode"));
            prpLinterCancelClaimRequestDto.setReportorName(dbManager.getString(resultSet,"ReportorName"));
            prpLinterCancelClaimRequestDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"ReportDate"));
            prpLinterCancelClaimRequestDto.setReportHour(dbManager.getString(resultSet,"ReportHour"));
            prpLinterCancelClaimRequestDto.setReportType(dbManager.getString(resultSet,"ReportType"));
            prpLinterCancelClaimRequestDto.setLinkerName(dbManager.getString(resultSet,"LinkerName"));
            prpLinterCancelClaimRequestDto.setPhoneNumber(dbManager.getString(resultSet,"PhoneNumber"));
            prpLinterCancelClaimRequestDto.setLinkerAddress(dbManager.getString(resultSet,"LinkerAddress"));
            prpLinterCancelClaimRequestDto.setClauseType(dbManager.getString(resultSet,"ClauseType"));
            prpLinterCancelClaimRequestDto.setDamageAddress(dbManager.getString(resultSet,"DamageAddress"));
            prpLinterCancelClaimRequestDto.setDamageTypeCode(dbManager.getString(resultSet,"DamageTypeCode"));
            prpLinterCancelClaimRequestDto.setLossesNumber(dbManager.getDouble(resultSet,"LossesNumber"));
            prpLinterCancelClaimRequestDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLinterCancelClaimRequestDto.setOperatorName(dbManager.getString(resultSet,"OperatorName"));
            prpLinterCancelClaimRequestDto.setMakeCom(dbManager.getString(resultSet,"MakeCom"));
            prpLinterCancelClaimRequestDto.setMakeComName(dbManager.getString(resultSet,"MakeComName"));
            prpLinterCancelClaimRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"InputDate"));
            prpLinterCancelClaimRequestDto.setRemark(dbManager.getString(resultSet,"Remark"));
            prpLinterCancelClaimRequestDto.setContext(dbManager.getString(resultSet,"Context"));
            prpLinterCancelClaimRequestDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"CancelDate"));
            prpLinterCancelClaimRequestDto.setDealerCode(dbManager.getString(resultSet,"DealerCode"));
            prpLinterCancelClaimRequestDto.setOutRegistNo(dbManager.getString(resultSet,"OutRegistNo"));
            prpLinterCancelClaimRequestDto.setCaseType(dbManager.getString(resultSet,"CaseType"));
            prpLinterCancelClaimRequestDto.setCancelReson(dbManager.getString(resultSet,"CancelReson"));
            prpLinterCancelClaimRequestDto.setNotion(dbManager.getString(resultSet,"Notion"));
            prpLinterCancelClaimRequestDto.setHandleText(dbManager.getString(resultSet,"HandleText"));
            prpLinterCancelClaimRequestDto.setCancelContext(dbManager.getString(resultSet,"CancelContext"));
            collection.add(prpLinterCancelClaimRequestDto);
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
        buffer.append("DELETE FROM PrpLinterCancelClaimRequest WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCancelClaimRequest WHERE ");
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
