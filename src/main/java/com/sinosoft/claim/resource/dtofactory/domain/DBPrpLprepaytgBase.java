package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLprepay－预赔登记表的数据访问对象基类<br>
 * 创建于 2006-08-23 10:45:29.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLprepaytgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLprepaytgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLprepaytgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void insert(PrpLprepaytgDto prpLprepaytgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLprepaytg (");
        buffer.append("PreCompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("ArrearageTimes,");
        buffer.append("SumArrearage,");
        buffer.append("SumBeforePrePaid,");
        buffer.append("BlockUpTimes,");
        buffer.append("SumPrePaid,");
        buffer.append("SumTotalPrepaid,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("UnderWriteFlag,");
        buffer.append("Flag,");
        buffer.append("CaseType, ");
        buffer.append("uploadSerialNo, ");
        buffer.append("payRefDate,  ");
        buffer.append("sumPreChargePaid ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLprepaytgDto.getPreCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLprepaytgDto.getArrearageTimes()).append(",");
            debugBuffer.append("").append(prpLprepaytgDto.getSumArrearage()).append(",");
            debugBuffer.append("").append(prpLprepaytgDto.getSumBeforePrePaid()).append(",");
            debugBuffer.append("").append(prpLprepaytgDto.getBlockUpTimes()).append(",");
            debugBuffer.append("").append(prpLprepaytgDto.getSumPrePaid()).append(",");
            debugBuffer.append("").append(prpLprepaytgDto.getSumTotalPrepaid()).append(",");
            debugBuffer.append("'").append(prpLprepaytgDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getApproverCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getUnderWriteCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getUnderWriteName()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getStatisticsYM()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getUnderWriteEndDate()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getUnderWriteFlag()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getUploadSerialNo()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getPayRefDate()).append("',");
            debugBuffer.append("'").append(prpLprepaytgDto.getSumPreChargePaid()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLprepaytgDto.getPreCompensateNo());
        dbManager.setString(2,prpLprepaytgDto.getClaimNo());
        dbManager.setString(3,prpLprepaytgDto.getRiskCode());
        dbManager.setString(4,prpLprepaytgDto.getPolicyNo());
        dbManager.setString(5,prpLprepaytgDto.getCurrency());
        dbManager.setInt(6,prpLprepaytgDto.getArrearageTimes());
        dbManager.setDouble(7,prpLprepaytgDto.getSumArrearage());
        dbManager.setDouble(8,prpLprepaytgDto.getSumBeforePrePaid());
        dbManager.setInt(9,prpLprepaytgDto.getBlockUpTimes());
        dbManager.setDouble(10,prpLprepaytgDto.getSumPrePaid());
        dbManager.setDouble(11,prpLprepaytgDto.getSumTotalPrepaid());
        dbManager.setString(12,prpLprepaytgDto.getMakeCom());
        dbManager.setString(13,prpLprepaytgDto.getComCode());
        dbManager.setString(14,prpLprepaytgDto.getHandlerCode());
        dbManager.setString(15,prpLprepaytgDto.getHandler1Code());
        dbManager.setString(16,prpLprepaytgDto.getApproverCode());
        dbManager.setString(17,prpLprepaytgDto.getUnderWriteCode());
        dbManager.setString(18,prpLprepaytgDto.getUnderWriteName());
        dbManager.setDateTime(19,prpLprepaytgDto.getStatisticsYM());
        dbManager.setString(20,prpLprepaytgDto.getOperatorCode());
        dbManager.setDateTime(21,prpLprepaytgDto.getInputDate());
        dbManager.setDateTime(22,prpLprepaytgDto.getUnderWriteEndDate());
        dbManager.setString(23,prpLprepaytgDto.getUnderWriteFlag());
        dbManager.setString(24,prpLprepaytgDto.getFlag());
        dbManager.setString(25,prpLprepaytgDto.getCaseType());
        dbManager.setString(26,prpLprepaytgDto.getUploadSerialNo());
        dbManager.setDateTime(27,prpLprepaytgDto.getPayRefDate());
        dbManager.setDouble(28,prpLprepaytgDto.getSumPreChargePaid());
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
        buffer.append("INSERT INTO PrpLprepaytg (");
        buffer.append("PreCompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("ArrearageTimes,");
        buffer.append("SumArrearage,");
        buffer.append("SumBeforePrePaid,");
        buffer.append("BlockUpTimes,");
        buffer.append("SumPrePaid,");
        buffer.append("SumTotalPrepaid,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("UnderWriteFlag,");
        buffer.append("Flag,");
        buffer.append("CaseType, ");
        buffer.append("uploadSerialNo, ");
        buffer.append("payRefDate,  ");
        buffer.append("sumPreChargePaid ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLprepaytgDto prpLprepaytgDto = (PrpLprepaytgDto)i.next();
            dbManager.setString(1,prpLprepaytgDto.getPreCompensateNo());
            dbManager.setString(2,prpLprepaytgDto.getClaimNo());
            dbManager.setString(3,prpLprepaytgDto.getRiskCode());
            dbManager.setString(4,prpLprepaytgDto.getPolicyNo());
            dbManager.setString(5,prpLprepaytgDto.getCurrency());
            dbManager.setInt(6,prpLprepaytgDto.getArrearageTimes());
            dbManager.setDouble(7,prpLprepaytgDto.getSumArrearage());
            dbManager.setDouble(8,prpLprepaytgDto.getSumBeforePrePaid());
            dbManager.setInt(9,prpLprepaytgDto.getBlockUpTimes());
            dbManager.setDouble(10,prpLprepaytgDto.getSumPrePaid());
            dbManager.setDouble(11,prpLprepaytgDto.getSumTotalPrepaid());
            dbManager.setString(12,prpLprepaytgDto.getMakeCom());
            dbManager.setString(13,prpLprepaytgDto.getComCode());
            dbManager.setString(14,prpLprepaytgDto.getHandlerCode());
            dbManager.setString(15,prpLprepaytgDto.getHandler1Code());
            dbManager.setString(16,prpLprepaytgDto.getApproverCode());
            dbManager.setString(17,prpLprepaytgDto.getUnderWriteCode());
            dbManager.setString(18,prpLprepaytgDto.getUnderWriteName());
            dbManager.setDateTime(19,prpLprepaytgDto.getStatisticsYM());
            dbManager.setString(20,prpLprepaytgDto.getOperatorCode());
            dbManager.setDateTime(21,prpLprepaytgDto.getInputDate());
            dbManager.setDateTime(22,prpLprepaytgDto.getUnderWriteEndDate());
            dbManager.setString(23,prpLprepaytgDto.getUnderWriteFlag());
            dbManager.setString(24,prpLprepaytgDto.getFlag());
            dbManager.setString(25,prpLprepaytgDto.getCaseType());
            dbManager.setString(26,prpLprepaytgDto.getUploadSerialNo());
            dbManager.setDateTime(27,prpLprepaytgDto.getPayRefDate());
            dbManager.setDouble(28, prpLprepaytgDto.getSumPreChargePaid());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param preCompensateNo 预赔登记号
     * @throws Exception
     */
    public void delete(String preCompensateNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLprepaytg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PreCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PreCompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,preCompensateNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void update(PrpLprepaytgDto prpLprepaytgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLprepaytg SET ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("PolicyNo = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("ArrearageTimes = ?, ");
        buffer.append("SumArrearage = ?, ");
        buffer.append("SumBeforePrePaid = ?, ");
        buffer.append("BlockUpTimes = ?, ");
        buffer.append("SumPrePaid = ?, ");
        buffer.append("SumTotalPrepaid = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("Handler1Code = ?, ");
        buffer.append("ApproverCode = ?, ");
        buffer.append("UnderWriteCode = ?, ");
        buffer.append("UnderWriteName = ?, ");
        buffer.append("StatisticsYM = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("UnderWriteEndDate = ?, ");
        buffer.append("UnderWriteFlag = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("CaseType = ?, ");
        buffer.append("uploadSerialNo = ?, ");
        buffer.append("payRefDate = ?, ");
        buffer.append("sumPreChargePaid = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLprepaytg SET ");
            debugBuffer.append("ClaimNo = '" + prpLprepaytgDto.getClaimNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLprepaytgDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLprepaytgDto.getPolicyNo() + "', ");
            debugBuffer.append("Currency = '" + prpLprepaytgDto.getCurrency() + "', ");
            debugBuffer.append("ArrearageTimes = " + prpLprepaytgDto.getArrearageTimes() + ", ");
            debugBuffer.append("SumArrearage = " + prpLprepaytgDto.getSumArrearage() + ", ");
            debugBuffer.append("SumBeforePrePaid = " + prpLprepaytgDto.getSumBeforePrePaid() + ", ");
            debugBuffer.append("BlockUpTimes = " + prpLprepaytgDto.getBlockUpTimes() + ", ");
            debugBuffer.append("SumPrePaid = " + prpLprepaytgDto.getSumPrePaid() + ", ");
            debugBuffer.append("SumTotalPrepaid = " + prpLprepaytgDto.getSumTotalPrepaid() + ", ");
            debugBuffer.append("MakeCom = '" + prpLprepaytgDto.getMakeCom() + "', ");
            debugBuffer.append("ComCode = '" + prpLprepaytgDto.getComCode() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLprepaytgDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLprepaytgDto.getHandler1Code() + "', ");
            debugBuffer.append("ApproverCode = '" + prpLprepaytgDto.getApproverCode() + "', ");
            debugBuffer.append("UnderWriteCode = '" + prpLprepaytgDto.getUnderWriteCode() + "', ");
            debugBuffer.append("UnderWriteName = '" + prpLprepaytgDto.getUnderWriteName() + "', ");
            debugBuffer.append("StatisticsYM = '" + prpLprepaytgDto.getStatisticsYM() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLprepaytgDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLprepaytgDto.getInputDate() + "', ");
            debugBuffer.append("UnderWriteEndDate = '" + prpLprepaytgDto.getUnderWriteEndDate() + "', ");
            debugBuffer.append("UnderWriteFlag = '" + prpLprepaytgDto.getUnderWriteFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLprepaytgDto.getFlag() + "', ");
            debugBuffer.append("CaseType = '" + prpLprepaytgDto.getCaseType() + "', ");
            debugBuffer.append("sumPreChargePaid = '" + prpLprepaytgDto.getSumPreChargePaid() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PreCompensateNo=").append("'").append(prpLprepaytgDto.getPreCompensateNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PreCompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLprepaytgDto.getClaimNo());
        dbManager.setString(2,prpLprepaytgDto.getRiskCode());
        dbManager.setString(3,prpLprepaytgDto.getPolicyNo());
        dbManager.setString(4,prpLprepaytgDto.getCurrency());
        dbManager.setInt(5,prpLprepaytgDto.getArrearageTimes());
        dbManager.setDouble(6,prpLprepaytgDto.getSumArrearage());
        dbManager.setDouble(7,prpLprepaytgDto.getSumBeforePrePaid());
        dbManager.setInt(8,prpLprepaytgDto.getBlockUpTimes());
        dbManager.setDouble(9,prpLprepaytgDto.getSumPrePaid());
        dbManager.setDouble(10,prpLprepaytgDto.getSumTotalPrepaid());
        dbManager.setString(11,prpLprepaytgDto.getMakeCom());
        dbManager.setString(12,prpLprepaytgDto.getComCode());
        dbManager.setString(13,prpLprepaytgDto.getHandlerCode());
        dbManager.setString(14,prpLprepaytgDto.getHandler1Code());
        dbManager.setString(15,prpLprepaytgDto.getApproverCode());
        dbManager.setString(16,prpLprepaytgDto.getUnderWriteCode());
        dbManager.setString(17,prpLprepaytgDto.getUnderWriteName());
        dbManager.setDateTime(18,prpLprepaytgDto.getStatisticsYM());
        dbManager.setString(19,prpLprepaytgDto.getOperatorCode());
        dbManager.setDateTime(20,prpLprepaytgDto.getInputDate());
        dbManager.setDateTime(21,prpLprepaytgDto.getUnderWriteEndDate());
        dbManager.setString(22,prpLprepaytgDto.getUnderWriteFlag());
        dbManager.setString(23,prpLprepaytgDto.getFlag());
        dbManager.setString(24,prpLprepaytgDto.getCaseType());
        dbManager.setString(25,prpLprepaytgDto.getUploadSerialNo());
        dbManager.setDateTime(26,prpLprepaytgDto.getPayRefDate());
        dbManager.setDouble(27, prpLprepaytgDto.getSumPreChargePaid());
        //设置条件字段;
        dbManager.setString(28,prpLprepaytgDto.getPreCompensateNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param preCompensateNo 预赔登记号
     * @return PrpLprepaytgDto
     * @throws Exception
     */
    public PrpLprepaytgDto findByPrimaryKey(String preCompensateNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PreCompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("ArrearageTimes,");
        buffer.append("SumArrearage,");
        buffer.append("SumBeforePrePaid,");
        buffer.append("BlockUpTimes,");
        buffer.append("SumPrePaid,");
        buffer.append("SumTotalPrepaid,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("UnderWriteFlag,");
        buffer.append("Flag,");
        buffer.append("CaseType, ");
        buffer.append("uploadSerialNo, ");
        buffer.append("payRefDate, ");
        buffer.append("sumPreChargePaid ");
        buffer.append("FROM PrpLprepaytg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PreCompensateNo=").append("'").append(preCompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PreCompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,preCompensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLprepaytgDto prpLprepaytgDto = null;
        if(resultSet.next()){
            prpLprepaytgDto = new PrpLprepaytgDto();
            prpLprepaytgDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepaytgDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLprepaytgDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLprepaytgDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLprepaytgDto.setCurrency(dbManager.getString(resultSet,5));
            prpLprepaytgDto.setArrearageTimes(dbManager.getInt(resultSet,6));
            prpLprepaytgDto.setSumArrearage(dbManager.getDouble(resultSet,7));
            prpLprepaytgDto.setSumBeforePrePaid(dbManager.getDouble(resultSet,8));
            prpLprepaytgDto.setBlockUpTimes(dbManager.getInt(resultSet,9));
            prpLprepaytgDto.setSumPrePaid(dbManager.getDouble(resultSet,10));
            prpLprepaytgDto.setSumTotalPrepaid(dbManager.getDouble(resultSet,11));
            prpLprepaytgDto.setMakeCom(dbManager.getString(resultSet,12));
            prpLprepaytgDto.setComCode(dbManager.getString(resultSet,13));
            prpLprepaytgDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpLprepaytgDto.setHandler1Code(dbManager.getString(resultSet,15));
            prpLprepaytgDto.setApproverCode(dbManager.getString(resultSet,16));
            prpLprepaytgDto.setUnderWriteCode(dbManager.getString(resultSet,17));
            prpLprepaytgDto.setUnderWriteName(dbManager.getString(resultSet,18));
            prpLprepaytgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLprepaytgDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLprepaytgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLprepaytgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLprepaytgDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLprepaytgDto.setFlag(dbManager.getString(resultSet,24));
            prpLprepaytgDto.setCaseType(dbManager.getString(resultSet,25));
            prpLprepaytgDto.setUploadSerialNo(dbManager.getString(resultSet,26));
            prpLprepaytgDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,27));
            prpLprepaytgDto.setSumPreChargePaid(dbManager.getDouble(resultSet, 28));
        }
        resultSet.close();
        return prpLprepaytgDto;
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
        buffer.append("PreCompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("PolicyNo,");
        buffer.append("Currency,");
        buffer.append("ArrearageTimes,");
        buffer.append("SumArrearage,");
        buffer.append("SumBeforePrePaid,");
        buffer.append("BlockUpTimes,");
        buffer.append("SumPrePaid,");
        buffer.append("SumTotalPrepaid,");
        buffer.append("MakeCom,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("StatisticsYM,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("UnderWriteFlag,");
        buffer.append("Flag,");
        buffer.append("CaseType, ");
        buffer.append("uploadSerialNo, ");
        buffer.append("payRefDate, ");
        buffer.append("sumPreChargePaid ");
        buffer.append("FROM PrpLprepaytg WHERE ");
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
        PrpLprepaytgDto prpLprepaytgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLprepaytgDto = new PrpLprepaytgDto();
            prpLprepaytgDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepaytgDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLprepaytgDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLprepaytgDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLprepaytgDto.setCurrency(dbManager.getString(resultSet,5));
            prpLprepaytgDto.setArrearageTimes(dbManager.getInt(resultSet,6));
            prpLprepaytgDto.setSumArrearage(dbManager.getDouble(resultSet,7));
            prpLprepaytgDto.setSumBeforePrePaid(dbManager.getDouble(resultSet,8));
            prpLprepaytgDto.setBlockUpTimes(dbManager.getInt(resultSet,9));
            prpLprepaytgDto.setSumPrePaid(dbManager.getDouble(resultSet,10));
            prpLprepaytgDto.setSumTotalPrepaid(dbManager.getDouble(resultSet,11));
            prpLprepaytgDto.setMakeCom(dbManager.getString(resultSet,12));
            prpLprepaytgDto.setComCode(dbManager.getString(resultSet,13));
            prpLprepaytgDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpLprepaytgDto.setHandler1Code(dbManager.getString(resultSet,15));
            prpLprepaytgDto.setApproverCode(dbManager.getString(resultSet,16));
            prpLprepaytgDto.setUnderWriteCode(dbManager.getString(resultSet,17));
            prpLprepaytgDto.setUnderWriteName(dbManager.getString(resultSet,18));
            prpLprepaytgDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLprepaytgDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLprepaytgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLprepaytgDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLprepaytgDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLprepaytgDto.setFlag(dbManager.getString(resultSet,24));
            prpLprepaytgDto.setCaseType(dbManager.getString(resultSet,25));
            prpLprepaytgDto.setUploadSerialNo(dbManager.getString(resultSet,26));
            prpLprepaytgDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,27));
            prpLprepaytgDto.setSumPreChargePaid(dbManager.getDouble(resultSet, 28));
            collection.add(prpLprepaytgDto);
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
        buffer.append("DELETE FROM PrpLprepaytg WHERE ");
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
        String statement ;
          statement = "SELECT count(1) FROM PrpLprepaytg WHERE ";
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
