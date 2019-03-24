package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SwfLogStore的数据访问对象基类<br>
 * 创建于 2006-12-08 11:24:40.343<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfLogStoreBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBSwfLogStoreBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfLogStoreBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void insert(SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO SwfLogStore (");
        buffer.append("flowID,");
        buffer.append("logNo,");
        buffer.append("modelNo,");
        buffer.append("nodeNo,");
        buffer.append("nodeName,");
        buffer.append("businessNo,");
        buffer.append("handleDept,");
        buffer.append("handlerCode,");
        buffer.append("handlerName,");
        buffer.append("flowInTime,");
        buffer.append("timeLimit,");
        buffer.append("handleTime,");
        buffer.append("submitTime,");
        buffer.append("nodeStatus,");
        buffer.append("flowStatus,");
        buffer.append("packageID,");
        buffer.append("flag,");
        buffer.append("taskNo,");
        buffer.append("taskType,");
        buffer.append("nodeType,");
        buffer.append("titleStr,");
        buffer.append("businessType,");
        buffer.append("riskCode,");
        buffer.append("keyIn,");
        buffer.append("keyOut,");
        buffer.append("deptName,");
        buffer.append("mainFlowID,");
        buffer.append("subFlowID,");
        buffer.append("posX,");
        buffer.append("posY,");
        buffer.append("endFlag,");
        buffer.append("beforeHandlerCode,");
        buffer.append("beforeHandlerName,");
        buffer.append("policyNo,");
        buffer.append("typeFlag,");
        buffer.append("comCode,");
        buffer.append("scheduleID,");
        buffer.append("lossItemCode,");
        buffer.append("lossItemName,");
        buffer.append("insureCarFlag,");
        buffer.append("handlerRange,");
        buffer.append("exigenceGree,");
        buffer.append("insuredName,");
        buffer.append("registNo,medicalTransitFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(swfLogStoreDto.getFlowID()).append("',");
            debugBuffer.append("").append(swfLogStoreDto.getLogNo()).append(",");
            debugBuffer.append("").append(swfLogStoreDto.getModelNo()).append(",");
            debugBuffer.append("").append(swfLogStoreDto.getNodeNo()).append(",");
            debugBuffer.append("'").append(swfLogStoreDto.getNodeName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getHandleDept()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getHandlerName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getFlowInTime()).append("',");
            debugBuffer.append("").append(swfLogStoreDto.getTimeLimit()).append(",");
            debugBuffer.append("'").append(swfLogStoreDto.getHandleTime()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getSubmitTime()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getNodeStatus()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getFlowStatus()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getPackageID()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getFlag()).append("',");
            debugBuffer.append("").append(swfLogStoreDto.getTaskNo()).append(",");
            debugBuffer.append("'").append(swfLogStoreDto.getTaskType()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getNodeType()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getTitleStr()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getKeyIn()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getKeyOut()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getDeptName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getMainFlowID()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getSubFlowID()).append("',");
            debugBuffer.append("").append(swfLogStoreDto.getPosX()).append(",");
            debugBuffer.append("").append(swfLogStoreDto.getPosY()).append(",");
            debugBuffer.append("'").append(swfLogStoreDto.getEndFlag()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getBeforeHandlerCode()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getBeforeHandlerName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getTypeFlag()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getComCode()).append("',");
            debugBuffer.append("").append(swfLogStoreDto.getScheduleID()).append(",");
            debugBuffer.append("'").append(swfLogStoreDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getLossItemName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getInsureCarFlag()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getHandlerRange()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getExigenceGree()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(swfLogStoreDto.getRegistNo()).append("')");
            debugBuffer.append("'").append(swfLogStoreDto.getMedicalTransitFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,swfLogStoreDto.getFlowID());
        dbManager.setInt(2,swfLogStoreDto.getLogNo());
        dbManager.setInt(3,swfLogStoreDto.getModelNo());
        dbManager.setInt(4,swfLogStoreDto.getNodeNo());
        dbManager.setString(5,swfLogStoreDto.getNodeName());
        dbManager.setString(6,swfLogStoreDto.getBusinessNo());
        dbManager.setString(7,swfLogStoreDto.getHandleDept());
        dbManager.setString(8,swfLogStoreDto.getHandlerCode());
        dbManager.setString(9,swfLogStoreDto.getHandlerName());
        dbManager.setString(10,swfLogStoreDto.getFlowInTime());
        dbManager.setInt(11,swfLogStoreDto.getTimeLimit());
        dbManager.setString(12,swfLogStoreDto.getHandleTime());
        dbManager.setString(13,swfLogStoreDto.getSubmitTime());
        dbManager.setString(14,swfLogStoreDto.getNodeStatus());
        dbManager.setString(15,swfLogStoreDto.getFlowStatus());
        dbManager.setString(16,swfLogStoreDto.getPackageID());
        dbManager.setString(17,swfLogStoreDto.getFlag());
        dbManager.setInt(18,swfLogStoreDto.getTaskNo());
        dbManager.setString(19,swfLogStoreDto.getTaskType());
        dbManager.setString(20,swfLogStoreDto.getNodeType());
        dbManager.setString(21,swfLogStoreDto.getTitleStr());
        dbManager.setString(22,swfLogStoreDto.getBusinessType());
        dbManager.setString(23,swfLogStoreDto.getRiskCode());
        dbManager.setString(24,swfLogStoreDto.getKeyIn());
        dbManager.setString(25,swfLogStoreDto.getKeyOut());
        dbManager.setString(26,swfLogStoreDto.getDeptName());
        dbManager.setString(27,swfLogStoreDto.getMainFlowID());
        dbManager.setString(28,swfLogStoreDto.getSubFlowID());
        dbManager.setInt(29,swfLogStoreDto.getPosX());
        dbManager.setInt(30,swfLogStoreDto.getPosY());
        dbManager.setString(31,swfLogStoreDto.getEndFlag());
        dbManager.setString(32,swfLogStoreDto.getBeforeHandlerCode());
        dbManager.setString(33,swfLogStoreDto.getBeforeHandlerName());
        dbManager.setString(34,swfLogStoreDto.getPolicyNo());
        dbManager.setString(35,swfLogStoreDto.getTypeFlag());
        dbManager.setString(36,swfLogStoreDto.getComCode());
        dbManager.setInt(37,swfLogStoreDto.getScheduleID());
        dbManager.setString(38,swfLogStoreDto.getLossItemCode());
        dbManager.setString(39,swfLogStoreDto.getLossItemName());
        dbManager.setString(40,swfLogStoreDto.getInsureCarFlag());
        dbManager.setString(41,swfLogStoreDto.getHandlerRange());
        dbManager.setString(42,swfLogStoreDto.getExigenceGree());
        dbManager.setString(43,swfLogStoreDto.getInsuredName());
        dbManager.setString(44,swfLogStoreDto.getRegistNo());
        dbManager.setString(45, swfLogStoreDto.getMedicalTransitFlag());
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
        buffer.append("INSERT INTO SwfLogStore (");
        buffer.append("flowID,");
        buffer.append("logNo,");
        buffer.append("modelNo,");
        buffer.append("nodeNo,");
        buffer.append("nodeName,");
        buffer.append("businessNo,");
        buffer.append("handleDept,");
        buffer.append("handlerCode,");
        buffer.append("handlerName,");
        buffer.append("flowInTime,");
        buffer.append("timeLimit,");
        buffer.append("handleTime,");
        buffer.append("submitTime,");
        buffer.append("nodeStatus,");
        buffer.append("flowStatus,");
        buffer.append("packageID,");
        buffer.append("flag,");
        buffer.append("taskNo,");
        buffer.append("taskType,");
        buffer.append("nodeType,");
        buffer.append("titleStr,");
        buffer.append("businessType,");
        buffer.append("riskCode,");
        buffer.append("keyIn,");
        buffer.append("keyOut,");
        buffer.append("deptName,");
        buffer.append("mainFlowID,");
        buffer.append("subFlowID,");
        buffer.append("posX,");
        buffer.append("posY,");
        buffer.append("endFlag,");
        buffer.append("beforeHandlerCode,");
        buffer.append("beforeHandlerName,");
        buffer.append("policyNo,");
        buffer.append("typeFlag,");
        buffer.append("comCode,");
        buffer.append("scheduleID,");
        buffer.append("lossItemCode,");
        buffer.append("lossItemName,");
        buffer.append("insureCarFlag,");
        buffer.append("handlerRange,");
        buffer.append("exigenceGree,");
        buffer.append("insuredName,");
        buffer.append("registNo, ");
        buffer.append("medicalTransitFlag");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfLogStoreDto swfLogStoreDto = (SwfLogStoreDto)i.next();
            dbManager.setString(1,swfLogStoreDto.getFlowID());
            dbManager.setInt(2,swfLogStoreDto.getLogNo());
            dbManager.setInt(3,swfLogStoreDto.getModelNo());
            dbManager.setInt(4,swfLogStoreDto.getNodeNo());
            dbManager.setString(5,swfLogStoreDto.getNodeName());
            dbManager.setString(6,swfLogStoreDto.getBusinessNo());
            dbManager.setString(7,swfLogStoreDto.getHandleDept());
            dbManager.setString(8,swfLogStoreDto.getHandlerCode());
            dbManager.setString(9,swfLogStoreDto.getHandlerName());
            dbManager.setString(10,swfLogStoreDto.getFlowInTime());
            dbManager.setInt(11,swfLogStoreDto.getTimeLimit());
            dbManager.setString(12,swfLogStoreDto.getHandleTime());
            dbManager.setString(13,swfLogStoreDto.getSubmitTime());
            dbManager.setString(14,swfLogStoreDto.getNodeStatus());
            dbManager.setString(15,swfLogStoreDto.getFlowStatus());
            dbManager.setString(16,swfLogStoreDto.getPackageID());
            dbManager.setString(17,swfLogStoreDto.getFlag());
            dbManager.setInt(18,swfLogStoreDto.getTaskNo());
            dbManager.setString(19,swfLogStoreDto.getTaskType());
            dbManager.setString(20,swfLogStoreDto.getNodeType());
            dbManager.setString(21,swfLogStoreDto.getTitleStr());
            dbManager.setString(22,swfLogStoreDto.getBusinessType());
            dbManager.setString(23,swfLogStoreDto.getRiskCode());
            dbManager.setString(24,swfLogStoreDto.getKeyIn());
            dbManager.setString(25,swfLogStoreDto.getKeyOut());
            dbManager.setString(26,swfLogStoreDto.getDeptName());
            dbManager.setString(27,swfLogStoreDto.getMainFlowID());
            dbManager.setString(28,swfLogStoreDto.getSubFlowID());
            dbManager.setInt(29,swfLogStoreDto.getPosX());
            dbManager.setInt(30,swfLogStoreDto.getPosY());
            dbManager.setString(31,swfLogStoreDto.getEndFlag());
            dbManager.setString(32,swfLogStoreDto.getBeforeHandlerCode());
            dbManager.setString(33,swfLogStoreDto.getBeforeHandlerName());
            dbManager.setString(34,swfLogStoreDto.getPolicyNo());
            dbManager.setString(35,swfLogStoreDto.getTypeFlag());
            dbManager.setString(36,swfLogStoreDto.getComCode());
            dbManager.setInt(37,swfLogStoreDto.getScheduleID());
            dbManager.setString(38,swfLogStoreDto.getLossItemCode());
            dbManager.setString(39,swfLogStoreDto.getLossItemName());
            dbManager.setString(40,swfLogStoreDto.getInsureCarFlag());
            dbManager.setString(41,swfLogStoreDto.getHandlerRange());
            dbManager.setString(42,swfLogStoreDto.getExigenceGree());
            dbManager.setString(43,swfLogStoreDto.getInsuredName());
            dbManager.setString(44,swfLogStoreDto.getRegistNo());
            dbManager.setString(45,swfLogStoreDto.getMedicalTransitFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(String flowID)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM SwfLogStore ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,flowID);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param swfLogStoreDto swfLogStoreDto
     * @throws Exception
     */
    public void update(SwfLogStoreDto swfLogStoreDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE SwfLogStore SET ");
        buffer.append("logNo = ?, ");
        buffer.append("modelNo = ?, ");
        buffer.append("nodeNo = ?, ");
        buffer.append("nodeName = ?, ");
        buffer.append("businessNo = ?, ");
        buffer.append("handleDept = ?, ");
        buffer.append("handlerCode = ?, ");
        buffer.append("handlerName = ?, ");
        buffer.append("flowInTime = ?, ");
        buffer.append("timeLimit = ?, ");
        buffer.append("handleTime = ?, ");
        buffer.append("submitTime = ?, ");
        buffer.append("nodeStatus = ?, ");
        buffer.append("flowStatus = ?, ");
        buffer.append("packageID = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("taskNo = ?, ");
        buffer.append("taskType = ?, ");
        buffer.append("nodeType = ?, ");
        buffer.append("titleStr = ?, ");
        buffer.append("businessType = ?, ");
        buffer.append("riskCode = ?, ");
        buffer.append("keyIn = ?, ");
        buffer.append("keyOut = ?, ");
        buffer.append("deptName = ?, ");
        buffer.append("mainFlowID = ?, ");
        buffer.append("subFlowID = ?, ");
        buffer.append("posX = ?, ");
        buffer.append("posY = ?, ");
        buffer.append("endFlag = ?, ");
        buffer.append("beforeHandlerCode = ?, ");
        buffer.append("beforeHandlerName = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("typeFlag = ?, ");
        buffer.append("comCode = ?, ");
        buffer.append("scheduleID = ?, ");
        buffer.append("lossItemCode = ?, ");
        buffer.append("lossItemName = ?, ");
        buffer.append("insureCarFlag = ?, ");
        buffer.append("handlerRange = ?, ");
        buffer.append("exigenceGree = ?, ");
        buffer.append("insuredName = ?, ");
        buffer.append("registNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE SwfLogStore SET ");
            debugBuffer.append("logNo = " + swfLogStoreDto.getLogNo() + ", ");
            debugBuffer.append("modelNo = " + swfLogStoreDto.getModelNo() + ", ");
            debugBuffer.append("nodeNo = " + swfLogStoreDto.getNodeNo() + ", ");
            debugBuffer.append("nodeName = '" + swfLogStoreDto.getNodeName() + "', ");
            debugBuffer.append("businessNo = '" + swfLogStoreDto.getBusinessNo() + "', ");
            debugBuffer.append("handleDept = '" + swfLogStoreDto.getHandleDept() + "', ");
            debugBuffer.append("handlerCode = '" + swfLogStoreDto.getHandlerCode() + "', ");
            debugBuffer.append("handlerName = '" + swfLogStoreDto.getHandlerName() + "', ");
            debugBuffer.append("flowInTime = '" + swfLogStoreDto.getFlowInTime() + "', ");
            debugBuffer.append("timeLimit = " + swfLogStoreDto.getTimeLimit() + ", ");
            debugBuffer.append("handleTime = '" + swfLogStoreDto.getHandleTime() + "', ");
            debugBuffer.append("submitTime = '" + swfLogStoreDto.getSubmitTime() + "', ");
            debugBuffer.append("nodeStatus = '" + swfLogStoreDto.getNodeStatus() + "', ");
            debugBuffer.append("flowStatus = '" + swfLogStoreDto.getFlowStatus() + "', ");
            debugBuffer.append("packageID = '" + swfLogStoreDto.getPackageID() + "', ");
            debugBuffer.append("flag = '" + swfLogStoreDto.getFlag() + "', ");
            debugBuffer.append("taskNo = " + swfLogStoreDto.getTaskNo() + ", ");
            debugBuffer.append("taskType = '" + swfLogStoreDto.getTaskType() + "', ");
            debugBuffer.append("nodeType = '" + swfLogStoreDto.getNodeType() + "', ");
            debugBuffer.append("titleStr = '" + swfLogStoreDto.getTitleStr() + "', ");
            debugBuffer.append("businessType = '" + swfLogStoreDto.getBusinessType() + "', ");
            debugBuffer.append("riskCode = '" + swfLogStoreDto.getRiskCode() + "', ");
            debugBuffer.append("keyIn = '" + swfLogStoreDto.getKeyIn() + "', ");
            debugBuffer.append("keyOut = '" + swfLogStoreDto.getKeyOut() + "', ");
            debugBuffer.append("deptName = '" + swfLogStoreDto.getDeptName() + "', ");
            debugBuffer.append("mainFlowID = '" + swfLogStoreDto.getMainFlowID() + "', ");
            debugBuffer.append("subFlowID = '" + swfLogStoreDto.getSubFlowID() + "', ");
            debugBuffer.append("posX = " + swfLogStoreDto.getPosX() + ", ");
            debugBuffer.append("posY = " + swfLogStoreDto.getPosY() + ", ");
            debugBuffer.append("endFlag = '" + swfLogStoreDto.getEndFlag() + "', ");
            debugBuffer.append("beforeHandlerCode = '" + swfLogStoreDto.getBeforeHandlerCode() + "', ");
            debugBuffer.append("beforeHandlerName = '" + swfLogStoreDto.getBeforeHandlerName() + "', ");
            debugBuffer.append("policyNo = '" + swfLogStoreDto.getPolicyNo() + "', ");
            debugBuffer.append("typeFlag = '" + swfLogStoreDto.getTypeFlag() + "', ");
            debugBuffer.append("comCode = '" + swfLogStoreDto.getComCode() + "', ");
            debugBuffer.append("scheduleID = " + swfLogStoreDto.getScheduleID() + ", ");
            debugBuffer.append("lossItemCode = '" + swfLogStoreDto.getLossItemCode() + "', ");
            debugBuffer.append("lossItemName = '" + swfLogStoreDto.getLossItemName() + "', ");
            debugBuffer.append("insureCarFlag = '" + swfLogStoreDto.getInsureCarFlag() + "', ");
            debugBuffer.append("handlerRange = '" + swfLogStoreDto.getHandlerRange() + "', ");
            debugBuffer.append("exigenceGree = '" + swfLogStoreDto.getExigenceGree() + "', ");
            debugBuffer.append("insuredName = '" + swfLogStoreDto.getInsuredName() + "', ");
            debugBuffer.append("registNo = '" + swfLogStoreDto.getRegistNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(swfLogStoreDto.getFlowID()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");
        buffer.append(" and logno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setInt(1,swfLogStoreDto.getLogNo());
        dbManager.setInt(2,swfLogStoreDto.getModelNo());
        dbManager.setInt(3,swfLogStoreDto.getNodeNo());
        dbManager.setString(4,swfLogStoreDto.getNodeName());
        dbManager.setString(5,swfLogStoreDto.getBusinessNo());
        dbManager.setString(6,swfLogStoreDto.getHandleDept());
        dbManager.setString(7,swfLogStoreDto.getHandlerCode());
        dbManager.setString(8,swfLogStoreDto.getHandlerName());
        dbManager.setString(9,swfLogStoreDto.getFlowInTime());
        dbManager.setInt(10,swfLogStoreDto.getTimeLimit());
        dbManager.setString(11,swfLogStoreDto.getHandleTime());
        dbManager.setString(12,swfLogStoreDto.getSubmitTime());
        dbManager.setString(13,swfLogStoreDto.getNodeStatus());
        dbManager.setString(14,swfLogStoreDto.getFlowStatus());
        dbManager.setString(15,swfLogStoreDto.getPackageID());
        dbManager.setString(16,swfLogStoreDto.getFlag());
        dbManager.setInt(17,swfLogStoreDto.getTaskNo());
        dbManager.setString(18,swfLogStoreDto.getTaskType());
        dbManager.setString(19,swfLogStoreDto.getNodeType());
        dbManager.setString(20,swfLogStoreDto.getTitleStr());
        dbManager.setString(21,swfLogStoreDto.getBusinessType());
        dbManager.setString(22,swfLogStoreDto.getRiskCode());
        dbManager.setString(23,swfLogStoreDto.getKeyIn());
        dbManager.setString(24,swfLogStoreDto.getKeyOut());
        dbManager.setString(25,swfLogStoreDto.getDeptName());
        dbManager.setString(26,swfLogStoreDto.getMainFlowID());
        dbManager.setString(27,swfLogStoreDto.getSubFlowID());
        dbManager.setInt(28,swfLogStoreDto.getPosX());
        dbManager.setInt(29,swfLogStoreDto.getPosY());
        dbManager.setString(30,swfLogStoreDto.getEndFlag());
        dbManager.setString(31,swfLogStoreDto.getBeforeHandlerCode());
        dbManager.setString(32,swfLogStoreDto.getBeforeHandlerName());
        dbManager.setString(33,swfLogStoreDto.getPolicyNo());
        dbManager.setString(34,swfLogStoreDto.getTypeFlag());
        dbManager.setString(35,swfLogStoreDto.getComCode());
        dbManager.setInt(36,swfLogStoreDto.getScheduleID());
        dbManager.setString(37,swfLogStoreDto.getLossItemCode());
        dbManager.setString(38,swfLogStoreDto.getLossItemName());
        dbManager.setString(39,swfLogStoreDto.getInsureCarFlag());
        dbManager.setString(40,swfLogStoreDto.getHandlerRange());
        dbManager.setString(41,swfLogStoreDto.getExigenceGree());
        dbManager.setString(42,swfLogStoreDto.getInsuredName());
        dbManager.setString(43,swfLogStoreDto.getRegistNo());
        //设置条件字段;
        dbManager.setString(44,swfLogStoreDto.getFlowID());
        dbManager.setInt(45,swfLogStoreDto.getLogNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param flowID flowID
     * @return SwfLogStoreDto
     * @throws Exception
     */
    public SwfLogStoreDto findByPrimaryKey(String flowID,int logNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("flowID,");
        buffer.append("logNo,");
        buffer.append("modelNo,");
        buffer.append("nodeNo,");
        buffer.append("nodeName,");
        buffer.append("businessNo,");
        buffer.append("handleDept,");
        buffer.append("handlerCode,");
        buffer.append("handlerName,");
        buffer.append("flowInTime,");
        buffer.append("timeLimit,");
        buffer.append("handleTime,");
        buffer.append("submitTime,");
        buffer.append("nodeStatus,");
        buffer.append("flowStatus,");
        buffer.append("packageID,");
        buffer.append("flag,");
        buffer.append("taskNo,");
        buffer.append("taskType,");
        buffer.append("nodeType,");
        buffer.append("titleStr,");
        buffer.append("businessType,");
        buffer.append("riskCode,");
        buffer.append("keyIn,");
        buffer.append("keyOut,");
        buffer.append("deptName,");
        buffer.append("mainFlowID,");
        buffer.append("subFlowID,");
        buffer.append("posX,");
        buffer.append("posY,");
        buffer.append("endFlag,");
        buffer.append("beforeHandlerCode,");
        buffer.append("beforeHandlerName,");
        buffer.append("policyNo,");
        buffer.append("typeFlag,");
        buffer.append("comCode,");
        buffer.append("scheduleID,");
        buffer.append("lossItemCode,");
        buffer.append("lossItemName,");
        buffer.append("insureCarFlag,");
        buffer.append("handlerRange,");
        buffer.append("exigenceGree,");
        buffer.append("insuredName,");
        buffer.append("registNo ");
        buffer.append("FROM SwfLogStore ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            debugBuffer.append("and logno=").append("'").append(logNo + "").append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");
        buffer.append("and logno = ?");
        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,logNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        SwfLogStoreDto swfLogStoreDto = null;
        if(resultSet.next()){
            swfLogStoreDto = new SwfLogStoreDto();
            swfLogStoreDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogStoreDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogStoreDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogStoreDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogStoreDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogStoreDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogStoreDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogStoreDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogStoreDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogStoreDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogStoreDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogStoreDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogStoreDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogStoreDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogStoreDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogStoreDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogStoreDto.setFlag(dbManager.getString(resultSet,17));
            swfLogStoreDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogStoreDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogStoreDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogStoreDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogStoreDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogStoreDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogStoreDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogStoreDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogStoreDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogStoreDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogStoreDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogStoreDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogStoreDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogStoreDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogStoreDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogStoreDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogStoreDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogStoreDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogStoreDto.setComCode(dbManager.getString(resultSet,36));
            swfLogStoreDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogStoreDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogStoreDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogStoreDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogStoreDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogStoreDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogStoreDto.setInsuredName(dbManager.getString(resultSet,43));
            swfLogStoreDto.setRegistNo(dbManager.getString(resultSet,44));
        }
        resultSet.close();
        return swfLogStoreDto;
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
    	//添加转义字符
		if (conditions.indexOf("swflog") > 0)
			conditions = conditions.replaceAll("swflog\\.", " ");
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("flowID,");
        buffer.append("logNo,");
        buffer.append("modelNo,");
        buffer.append("nodeNo,");
        buffer.append("nodeName,");
        buffer.append("businessNo,");
        buffer.append("handleDept,");
        buffer.append("handlerCode,");
        buffer.append("handlerName,");
        buffer.append("flowInTime,");
        buffer.append("timeLimit,");
        buffer.append("handleTime,");
        buffer.append("submitTime,");
        buffer.append("nodeStatus,");
        buffer.append("flowStatus,");
        buffer.append("packageID,");
        buffer.append("flag,");
        buffer.append("taskNo,");
        buffer.append("taskType,");
        buffer.append("nodeType,");
        buffer.append("titleStr,");
        buffer.append("businessType,");
        buffer.append("riskCode,");
        buffer.append("keyIn,");
        buffer.append("keyOut,");
        buffer.append("deptName,");
        buffer.append("mainFlowID,");
        buffer.append("subFlowID,");
        buffer.append("posX,");
        buffer.append("posY,");
        buffer.append("endFlag,");
        buffer.append("beforeHandlerCode,");
        buffer.append("beforeHandlerName,");
        buffer.append("policyNo,");
        buffer.append("typeFlag,");
        buffer.append("comCode,");
        buffer.append("scheduleID,");
        buffer.append("lossItemCode,");
        buffer.append("lossItemName,");
        buffer.append("insureCarFlag,");
        buffer.append("handlerRange,");
        buffer.append("exigenceGree,");
        buffer.append("insuredName,");
        buffer.append("registNo, ");
        buffer.append("medicalTransitFlag ");
        buffer.append("FROM SwfLogStore WHERE ");
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
        SwfLogStoreDto swfLogStoreDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            swfLogStoreDto = new SwfLogStoreDto();
            swfLogStoreDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogStoreDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogStoreDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogStoreDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogStoreDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogStoreDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogStoreDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogStoreDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogStoreDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogStoreDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogStoreDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogStoreDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogStoreDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogStoreDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogStoreDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogStoreDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogStoreDto.setFlag(dbManager.getString(resultSet,17));
            swfLogStoreDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogStoreDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogStoreDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogStoreDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogStoreDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogStoreDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogStoreDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogStoreDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogStoreDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogStoreDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogStoreDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogStoreDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogStoreDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogStoreDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogStoreDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogStoreDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogStoreDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogStoreDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogStoreDto.setComCode(dbManager.getString(resultSet,36));
            swfLogStoreDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogStoreDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogStoreDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogStoreDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogStoreDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogStoreDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogStoreDto.setInsuredName(dbManager.getString(resultSet,43));
            swfLogStoreDto.setRegistNo(dbManager.getString(resultSet,44));
            swfLogStoreDto.setMedicalTransitFlag(dbManager.getString(resultSet, 45));
            collection.add(swfLogStoreDto);
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
        buffer.append("DELETE FROM SwfLogStore WHERE ");
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
		if (conditions.indexOf("swflog") > 0)
			conditions = conditions.replaceAll("swflog.", " ");
        statement = "SELECT count(1) FROM SwfLogStore WHERE ";
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
