package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLprepay－预赔登记表的数据访问对象基类<br>
 * 创建于 2006-08-23 10:45:29.468<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLprepayBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLprepayBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLprepayBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void insert(PrpLprepayDto prpLprepayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLprepay (");
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
            debugBuffer.append("'").append(prpLprepayDto.getPreCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLprepayDto.getArrearageTimes()).append(",");
            debugBuffer.append("").append(prpLprepayDto.getSumArrearage()).append(",");
            debugBuffer.append("").append(prpLprepayDto.getSumBeforePrePaid()).append(",");
            debugBuffer.append("").append(prpLprepayDto.getBlockUpTimes()).append(",");
            debugBuffer.append("").append(prpLprepayDto.getSumPrePaid()).append(",");
            debugBuffer.append("").append(prpLprepayDto.getSumTotalPrepaid()).append(",");
            debugBuffer.append("'").append(prpLprepayDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getApproverCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getUnderWriteCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getUnderWriteName()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getStatisticsYM()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getUnderWriteEndDate()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getUnderWriteFlag()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getCaseType()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getUploadSerialNo()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getPayRefDate()).append("',");
            debugBuffer.append("'").append(prpLprepayDto.getSumPreChargePaid()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLprepayDto.getPreCompensateNo());
        dbManager.setString(2,prpLprepayDto.getClaimNo());
        dbManager.setString(3,prpLprepayDto.getRiskCode());
        dbManager.setString(4,prpLprepayDto.getPolicyNo());
        dbManager.setString(5,prpLprepayDto.getCurrency());
        dbManager.setInt(6,prpLprepayDto.getArrearageTimes());
        dbManager.setDouble(7,prpLprepayDto.getSumArrearage());
        dbManager.setDouble(8,prpLprepayDto.getSumBeforePrePaid());
        dbManager.setInt(9,prpLprepayDto.getBlockUpTimes());
        dbManager.setDouble(10,prpLprepayDto.getSumPrePaid());
        dbManager.setDouble(11,prpLprepayDto.getSumTotalPrepaid());
        dbManager.setString(12,prpLprepayDto.getMakeCom());
        dbManager.setString(13,prpLprepayDto.getComCode());
        dbManager.setString(14,prpLprepayDto.getHandlerCode());
        dbManager.setString(15,prpLprepayDto.getHandler1Code());
        dbManager.setString(16,prpLprepayDto.getApproverCode());
        dbManager.setString(17,prpLprepayDto.getUnderWriteCode());
        dbManager.setString(18,prpLprepayDto.getUnderWriteName());
        dbManager.setDateTime(19,prpLprepayDto.getStatisticsYM());
        dbManager.setString(20,prpLprepayDto.getOperatorCode());
        dbManager.setDateTime(21,prpLprepayDto.getInputDate());
        dbManager.setDateTime(22,prpLprepayDto.getUnderWriteEndDate());
        dbManager.setString(23,prpLprepayDto.getUnderWriteFlag());
        dbManager.setString(24,prpLprepayDto.getFlag());
        dbManager.setString(25,prpLprepayDto.getCaseType());
        dbManager.setString(26,prpLprepayDto.getUploadSerialNo());
        dbManager.setDateTime(27,prpLprepayDto.getPayRefDate());
        dbManager.setDouble(28,prpLprepayDto.getSumPreChargePaid());
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
        buffer.append("INSERT INTO PrpLprepay (");
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
            PrpLprepayDto prpLprepayDto = (PrpLprepayDto)i.next();
            dbManager.setString(1,prpLprepayDto.getPreCompensateNo());
            dbManager.setString(2,prpLprepayDto.getClaimNo());
            dbManager.setString(3,prpLprepayDto.getRiskCode());
            dbManager.setString(4,prpLprepayDto.getPolicyNo());
            dbManager.setString(5,prpLprepayDto.getCurrency());
            dbManager.setInt(6,prpLprepayDto.getArrearageTimes());
            dbManager.setDouble(7,prpLprepayDto.getSumArrearage());
            dbManager.setDouble(8,prpLprepayDto.getSumBeforePrePaid());
            dbManager.setInt(9,prpLprepayDto.getBlockUpTimes());
            dbManager.setDouble(10,prpLprepayDto.getSumPrePaid());
            dbManager.setDouble(11,prpLprepayDto.getSumTotalPrepaid());
            dbManager.setString(12,prpLprepayDto.getMakeCom());
            dbManager.setString(13,prpLprepayDto.getComCode());
            dbManager.setString(14,prpLprepayDto.getHandlerCode());
            dbManager.setString(15,prpLprepayDto.getHandler1Code());
            dbManager.setString(16,prpLprepayDto.getApproverCode());
            dbManager.setString(17,prpLprepayDto.getUnderWriteCode());
            dbManager.setString(18,prpLprepayDto.getUnderWriteName());
            dbManager.setDateTime(19,prpLprepayDto.getStatisticsYM());
            dbManager.setString(20,prpLprepayDto.getOperatorCode());
            dbManager.setDateTime(21,prpLprepayDto.getInputDate());
            dbManager.setDateTime(22,prpLprepayDto.getUnderWriteEndDate());
            dbManager.setString(23,prpLprepayDto.getUnderWriteFlag());
            dbManager.setString(24,prpLprepayDto.getFlag());
            dbManager.setString(25,prpLprepayDto.getCaseType());
            dbManager.setString(26,prpLprepayDto.getUploadSerialNo());
            dbManager.setDateTime(27,prpLprepayDto.getPayRefDate());
            dbManager.setDouble(28, prpLprepayDto.getSumPreChargePaid());
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
        buffer.append("DELETE FROM PrpLprepay ");
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
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void update(PrpLprepayDto prpLprepayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLprepay SET ");
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
            debugBuffer.append("UPDATE PrpLprepay SET ");
            debugBuffer.append("ClaimNo = '" + prpLprepayDto.getClaimNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLprepayDto.getRiskCode() + "', ");
            debugBuffer.append("PolicyNo = '" + prpLprepayDto.getPolicyNo() + "', ");
            debugBuffer.append("Currency = '" + prpLprepayDto.getCurrency() + "', ");
            debugBuffer.append("ArrearageTimes = " + prpLprepayDto.getArrearageTimes() + ", ");
            debugBuffer.append("SumArrearage = " + prpLprepayDto.getSumArrearage() + ", ");
            debugBuffer.append("SumBeforePrePaid = " + prpLprepayDto.getSumBeforePrePaid() + ", ");
            debugBuffer.append("BlockUpTimes = " + prpLprepayDto.getBlockUpTimes() + ", ");
            debugBuffer.append("SumPrePaid = " + prpLprepayDto.getSumPrePaid() + ", ");
            debugBuffer.append("SumTotalPrepaid = " + prpLprepayDto.getSumTotalPrepaid() + ", ");
            debugBuffer.append("MakeCom = '" + prpLprepayDto.getMakeCom() + "', ");
            debugBuffer.append("ComCode = '" + prpLprepayDto.getComCode() + "', ");
            debugBuffer.append("HandlerCode = '" + prpLprepayDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpLprepayDto.getHandler1Code() + "', ");
            debugBuffer.append("ApproverCode = '" + prpLprepayDto.getApproverCode() + "', ");
            debugBuffer.append("UnderWriteCode = '" + prpLprepayDto.getUnderWriteCode() + "', ");
            debugBuffer.append("UnderWriteName = '" + prpLprepayDto.getUnderWriteName() + "', ");
            debugBuffer.append("StatisticsYM = '" + prpLprepayDto.getStatisticsYM() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLprepayDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLprepayDto.getInputDate() + "', ");
            debugBuffer.append("UnderWriteEndDate = '" + prpLprepayDto.getUnderWriteEndDate() + "', ");
            debugBuffer.append("UnderWriteFlag = '" + prpLprepayDto.getUnderWriteFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLprepayDto.getFlag() + "', ");
            debugBuffer.append("CaseType = '" + prpLprepayDto.getCaseType() + "', ");
            debugBuffer.append("sumPreChargePaid = '" + prpLprepayDto.getSumPreChargePaid() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PreCompensateNo=").append("'").append(prpLprepayDto.getPreCompensateNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PreCompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLprepayDto.getClaimNo());
        dbManager.setString(2,prpLprepayDto.getRiskCode());
        dbManager.setString(3,prpLprepayDto.getPolicyNo());
        dbManager.setString(4,prpLprepayDto.getCurrency());
        dbManager.setInt(5,prpLprepayDto.getArrearageTimes());
        dbManager.setDouble(6,prpLprepayDto.getSumArrearage());
        dbManager.setDouble(7,prpLprepayDto.getSumBeforePrePaid());
        dbManager.setInt(8,prpLprepayDto.getBlockUpTimes());
        dbManager.setDouble(9,prpLprepayDto.getSumPrePaid());
        dbManager.setDouble(10,prpLprepayDto.getSumTotalPrepaid());
        dbManager.setString(11,prpLprepayDto.getMakeCom());
        dbManager.setString(12,prpLprepayDto.getComCode());
        dbManager.setString(13,prpLprepayDto.getHandlerCode());
        dbManager.setString(14,prpLprepayDto.getHandler1Code());
        dbManager.setString(15,prpLprepayDto.getApproverCode());
        dbManager.setString(16,prpLprepayDto.getUnderWriteCode());
        dbManager.setString(17,prpLprepayDto.getUnderWriteName());
        dbManager.setDateTime(18,prpLprepayDto.getStatisticsYM());
        dbManager.setString(19,prpLprepayDto.getOperatorCode());
        dbManager.setDateTime(20,prpLprepayDto.getInputDate());
        dbManager.setDateTime(21,prpLprepayDto.getUnderWriteEndDate());
        dbManager.setString(22,prpLprepayDto.getUnderWriteFlag());
        dbManager.setString(23,prpLprepayDto.getFlag());
        dbManager.setString(24,prpLprepayDto.getCaseType());
        dbManager.setString(25,prpLprepayDto.getUploadSerialNo());
        dbManager.setDateTime(26,prpLprepayDto.getPayRefDate());
        dbManager.setDouble(27, prpLprepayDto.getSumPreChargePaid());
        //设置条件字段;
        dbManager.setString(28,prpLprepayDto.getPreCompensateNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param preCompensateNo 预赔登记号
     * @return PrpLprepayDto
     * @throws Exception
     */
    public PrpLprepayDto findByPrimaryKey(String preCompensateNo)
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
        buffer.append("FROM PrpLprepay ");
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
        PrpLprepayDto prpLprepayDto = null;
        if(resultSet.next()){
            prpLprepayDto = new PrpLprepayDto();
            prpLprepayDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepayDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLprepayDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLprepayDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLprepayDto.setCurrency(dbManager.getString(resultSet,5));
            prpLprepayDto.setArrearageTimes(dbManager.getInt(resultSet,6));
            prpLprepayDto.setSumArrearage(dbManager.getDouble(resultSet,7));
            prpLprepayDto.setSumBeforePrePaid(dbManager.getDouble(resultSet,8));
            prpLprepayDto.setBlockUpTimes(dbManager.getInt(resultSet,9));
            prpLprepayDto.setSumPrePaid(dbManager.getDouble(resultSet,10));
            prpLprepayDto.setSumTotalPrepaid(dbManager.getDouble(resultSet,11));
            prpLprepayDto.setMakeCom(dbManager.getString(resultSet,12));
            prpLprepayDto.setComCode(dbManager.getString(resultSet,13));
            prpLprepayDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpLprepayDto.setHandler1Code(dbManager.getString(resultSet,15));
            prpLprepayDto.setApproverCode(dbManager.getString(resultSet,16));
            prpLprepayDto.setUnderWriteCode(dbManager.getString(resultSet,17));
            prpLprepayDto.setUnderWriteName(dbManager.getString(resultSet,18));
            prpLprepayDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLprepayDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLprepayDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLprepayDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLprepayDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLprepayDto.setFlag(dbManager.getString(resultSet,24));
            prpLprepayDto.setCaseType(dbManager.getString(resultSet,25));
            prpLprepayDto.setUploadSerialNo(dbManager.getString(resultSet,26));
            prpLprepayDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,27));
            prpLprepayDto.setSumPreChargePaid(dbManager.getDouble(resultSet, 28));
        }
        resultSet.close();
        return prpLprepayDto;
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
        buffer.append("FROM PrpLprepay WHERE ");
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
        PrpLprepayDto prpLprepayDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLprepayDto = new PrpLprepayDto();
            prpLprepayDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepayDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLprepayDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLprepayDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLprepayDto.setCurrency(dbManager.getString(resultSet,5));
            prpLprepayDto.setArrearageTimes(dbManager.getInt(resultSet,6));
            prpLprepayDto.setSumArrearage(dbManager.getDouble(resultSet,7));
            prpLprepayDto.setSumBeforePrePaid(dbManager.getDouble(resultSet,8));
            prpLprepayDto.setBlockUpTimes(dbManager.getInt(resultSet,9));
            prpLprepayDto.setSumPrePaid(dbManager.getDouble(resultSet,10));
            prpLprepayDto.setSumTotalPrepaid(dbManager.getDouble(resultSet,11));
            prpLprepayDto.setMakeCom(dbManager.getString(resultSet,12));
            prpLprepayDto.setComCode(dbManager.getString(resultSet,13));
            prpLprepayDto.setHandlerCode(dbManager.getString(resultSet,14));
            prpLprepayDto.setHandler1Code(dbManager.getString(resultSet,15));
            prpLprepayDto.setApproverCode(dbManager.getString(resultSet,16));
            prpLprepayDto.setUnderWriteCode(dbManager.getString(resultSet,17));
            prpLprepayDto.setUnderWriteName(dbManager.getString(resultSet,18));
            prpLprepayDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLprepayDto.setOperatorCode(dbManager.getString(resultSet,20));
            prpLprepayDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLprepayDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpLprepayDto.setUnderWriteFlag(dbManager.getString(resultSet,23));
            prpLprepayDto.setFlag(dbManager.getString(resultSet,24));
            prpLprepayDto.setCaseType(dbManager.getString(resultSet,25));
            prpLprepayDto.setUploadSerialNo(dbManager.getString(resultSet,26));
            prpLprepayDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,27));
            prpLprepayDto.setSumPreChargePaid(dbManager.getDouble(resultSet, 28));
            collection.add(prpLprepayDto);
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
        buffer.append("DELETE FROM PrpLprepay WHERE ");
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
          statement = "SELECT count(1) FROM PrpLprepay WHERE ";
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
