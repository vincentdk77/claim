package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMain-调度任务主表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleMainBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleMainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void insert(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleMain (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectTSend," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ScheduleDeptCode," + 
                           " ScheduleDeptName," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " SurveyAddress," + 
                           " LicenseNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ResultInfo," + 
                           " TransFlag," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLscheduleMainDto.getScheduleID() + "," + 
                           "'" + prpLscheduleMainDto.getRegistNo() + "'," + 
                           "" + prpLscheduleMainDto.getSerialNo() + "," + 
                           "'" + prpLscheduleMainDto.getInsureCarFlag() + "'," + 
                           "'" + prpLscheduleMainDto.getClaimComCode() + "'," + 
                           "'" + prpLscheduleMainDto.getSelectTSend() + "'," + 
                           "'" + prpLscheduleMainDto.getRiskCode() + "'," + 
                           "'" + prpLscheduleMainDto.getPolicyNo() + "'," + 
                           "'" + prpLscheduleMainDto.getScheduleDeptCode() + "'," + 
                           "'" + prpLscheduleMainDto.getScheduleDeptName() + "'," + 
                           "'" + prpLscheduleMainDto.getOperatorCode() + "'," + 
                           "'" + prpLscheduleMainDto.getOperatorName() + "'," + 
                           "" + prpLscheduleMainDto.getSurveyTimes() + "," + 
                           "'" + prpLscheduleMainDto.getSurveyType() + "'," + 
                           "'" + prpLscheduleMainDto.getSurveyAddress() + "'," + 
                           "'" + prpLscheduleMainDto.getLicenseNo() + "'," + 
                           "'" + prpLscheduleMainDto.getInputDate() + "'," + 
                           "" + prpLscheduleMainDto.getInputHour() + "," + 
                           "'" + prpLscheduleMainDto.getResultInfo() + "'," + 
                           "'" + prpLscheduleMainDto.getTransFlag() + "'," + 
                           "'" + prpLscheduleMainDto.getBookFlag() + "'," + 
                           "'" + prpLscheduleMainDto.getScheduleFlag() + "'," + 
                           "'" + prpLscheduleMainDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLscheduleMainDto.getScheduleID());
        dbManager.setString(2,prpLscheduleMainDto.getRegistNo());
        dbManager.setInt(3,prpLscheduleMainDto.getSerialNo());
        dbManager.setString(4,prpLscheduleMainDto.getInsureCarFlag());
        dbManager.setString(5,prpLscheduleMainDto.getClaimComCode());
        dbManager.setString(6,prpLscheduleMainDto.getSelectTSend());
        dbManager.setString(7,prpLscheduleMainDto.getRiskCode());
        dbManager.setString(8,prpLscheduleMainDto.getPolicyNo());
        dbManager.setString(9,prpLscheduleMainDto.getScheduleDeptCode());
        dbManager.setString(10,prpLscheduleMainDto.getScheduleDeptName());
        dbManager.setString(11,prpLscheduleMainDto.getOperatorCode());
        dbManager.setString(12,prpLscheduleMainDto.getOperatorName());
        dbManager.setInt(13,prpLscheduleMainDto.getSurveyTimes());
        dbManager.setString(14,prpLscheduleMainDto.getSurveyType());
        dbManager.setString(15,prpLscheduleMainDto.getSurveyAddress());
        dbManager.setString(16,prpLscheduleMainDto.getLicenseNo());
        dbManager.setDateTime(17,prpLscheduleMainDto.getInputDate());
        dbManager.setInt(18,prpLscheduleMainDto.getInputHour());
        dbManager.setString(19,prpLscheduleMainDto.getResultInfo());
        dbManager.setString(20,prpLscheduleMainDto.getTransFlag());
        dbManager.setString(21,prpLscheduleMainDto.getBookFlag());
        dbManager.setString(22,prpLscheduleMainDto.getScheduleFlag());
        dbManager.setString(23,prpLscheduleMainDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleMainBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleMain (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectTSend," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ScheduleDeptCode," + 
                           " ScheduleDeptName," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " SurveyAddress," + 
                           " LicenseNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ResultInfo," + 
                           " TransFlag," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLscheduleMainDto prpLscheduleMainDto = (PrpLscheduleMainDto)i.next();
            dbManager.setInt(1,prpLscheduleMainDto.getScheduleID());
            dbManager.setString(2,prpLscheduleMainDto.getRegistNo());
            dbManager.setInt(3,prpLscheduleMainDto.getSerialNo());
            dbManager.setString(4,prpLscheduleMainDto.getInsureCarFlag());
            dbManager.setString(5,prpLscheduleMainDto.getClaimComCode());
            dbManager.setString(6,prpLscheduleMainDto.getSelectTSend());
            dbManager.setString(7,prpLscheduleMainDto.getRiskCode());
            dbManager.setString(8,prpLscheduleMainDto.getPolicyNo());
            dbManager.setString(9,prpLscheduleMainDto.getScheduleDeptCode());
            dbManager.setString(10,prpLscheduleMainDto.getScheduleDeptName());
            dbManager.setString(11,prpLscheduleMainDto.getOperatorCode());
            dbManager.setString(12,prpLscheduleMainDto.getOperatorName());
            dbManager.setInt(13,prpLscheduleMainDto.getSurveyTimes());
            dbManager.setString(14,prpLscheduleMainDto.getSurveyType());
            dbManager.setString(15,prpLscheduleMainDto.getSurveyAddress());
            dbManager.setString(16,prpLscheduleMainDto.getLicenseNo());
            dbManager.setDateTime(17,prpLscheduleMainDto.getInputDate());
            dbManager.setInt(18,prpLscheduleMainDto.getInputHour());
            dbManager.setString(19,prpLscheduleMainDto.getResultInfo());
            dbManager.setString(20,prpLscheduleMainDto.getTransFlag());
            dbManager.setString(21,prpLscheduleMainDto.getBookFlag());
            dbManager.setString(22,prpLscheduleMainDto.getScheduleFlag());
            dbManager.setString(23,prpLscheduleMainDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLscheduleMainBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLscheduleMain" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleMain Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleMainBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void update(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        String statement = " Update PrpLscheduleMain Set InsureCarFlag = ?," + 
                           " ClaimComCode = ?," + 
                           " SelectTSend = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ScheduleDeptCode = ?," + 
                           " ScheduleDeptName = ?," + 
                           " OperatorCode = ?," + 
                           " OperatorName = ?," + 
                           " SurveyTimes = ?," + 
                           " SurveyType = ?," + 
                           " SurveyAddress = ?," + 
                           " LicenseNo = ?," + 
                           " InputDate = ?," + 
                           " InputHour = ?," + 
                           " ResultInfo = ?," + 
                           " TransFlag = ?," + 
                           " BookFlag = ?," + 
                           " ScheduleFlag = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleMain Set " + 
                           " ScheduleID = " + prpLscheduleMainDto.getScheduleID() + "," + 
                           " RegistNo = '" + prpLscheduleMainDto.getRegistNo() + "'," + 
                           " SerialNo = " + prpLscheduleMainDto.getSerialNo() + "," + 
                           " InsureCarFlag = '" + prpLscheduleMainDto.getInsureCarFlag() + "'," + 
                           " ClaimComCode = '" + prpLscheduleMainDto.getClaimComCode() + "'," + 
                           " SelectTSend = '" + prpLscheduleMainDto.getSelectTSend() + "'," + 
                           " RiskCode = '" + prpLscheduleMainDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLscheduleMainDto.getPolicyNo() + "'," + 
                           " ScheduleDeptCode = '" + prpLscheduleMainDto.getScheduleDeptCode() + "'," + 
                           " ScheduleDeptName = '" + prpLscheduleMainDto.getScheduleDeptName() + "'," + 
                           " OperatorCode = '" + prpLscheduleMainDto.getOperatorCode() + "'," + 
                           " OperatorName = '" + prpLscheduleMainDto.getOperatorName() + "'," + 
                           " SurveyTimes = " + prpLscheduleMainDto.getSurveyTimes() + "," + 
                           " SurveyType = '" + prpLscheduleMainDto.getSurveyType() + "'," + 
                           " SurveyAddress = '" + prpLscheduleMainDto.getSurveyAddress() + "'," + 
                           " LicenseNo = '" + prpLscheduleMainDto.getLicenseNo() + "'," + 
                           " InputDate = '" + prpLscheduleMainDto.getInputDate() + "'," + 
                           " InputHour = " + prpLscheduleMainDto.getInputHour() + "," + 
                           " ResultInfo = '" + prpLscheduleMainDto.getResultInfo() + "'," + 
                           " TransFlag = '" + prpLscheduleMainDto.getTransFlag() + "'," + 
                           " BookFlag = '" + prpLscheduleMainDto.getBookFlag() + "'," + 
                           " ScheduleFlag = '" + prpLscheduleMainDto.getScheduleFlag() + "'," + 
                           " Flag = '" + prpLscheduleMainDto.getFlag() + "'" + 
			               " Where " +
                           " ScheduleID = " + prpLscheduleMainDto.getScheduleID() + " And " + 
                           " RegistNo = '" + prpLscheduleMainDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLscheduleMainDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLscheduleMainDto.getInsureCarFlag());
        dbManager.setString(2,prpLscheduleMainDto.getClaimComCode());
        dbManager.setString(3,prpLscheduleMainDto.getSelectTSend());
        dbManager.setString(4,prpLscheduleMainDto.getRiskCode());
        dbManager.setString(5,prpLscheduleMainDto.getPolicyNo());
        dbManager.setString(6,prpLscheduleMainDto.getScheduleDeptCode());
        dbManager.setString(7,prpLscheduleMainDto.getScheduleDeptName());
        dbManager.setString(8,prpLscheduleMainDto.getOperatorCode());
        dbManager.setString(9,prpLscheduleMainDto.getOperatorName());
        dbManager.setInt(10,prpLscheduleMainDto.getSurveyTimes());
        dbManager.setString(11,prpLscheduleMainDto.getSurveyType());
        dbManager.setString(12,prpLscheduleMainDto.getSurveyAddress());
        dbManager.setString(13,prpLscheduleMainDto.getLicenseNo());
        dbManager.setDateTime(14,prpLscheduleMainDto.getInputDate());
        dbManager.setInt(15,prpLscheduleMainDto.getInputHour());
        dbManager.setString(16,prpLscheduleMainDto.getResultInfo());
        dbManager.setString(17,prpLscheduleMainDto.getTransFlag());
        dbManager.setString(18,prpLscheduleMainDto.getBookFlag());
        dbManager.setString(19,prpLscheduleMainDto.getScheduleFlag());
        dbManager.setString(20,prpLscheduleMainDto.getFlag());
        //设置条件字段;
        dbManager.setInt(21,prpLscheduleMainDto.getScheduleID());
        dbManager.setString(22,prpLscheduleMainDto.getRegistNo());
        dbManager.setInt(23,prpLscheduleMainDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleMainBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return PrpLscheduleMainDto
     * @throws Exception
     */
    public PrpLscheduleMainDto findByPrimaryKey(int scheduleID,String registNo,int serialNo) throws Exception{
        String mainStatement = " Select ScheduleID," + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectTSend," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ScheduleDeptCode," + 
                           " ScheduleDeptName," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " SurveyAddress," + 
                           " LicenseNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ResultInfo," + 
                           " TransFlag," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " Flag From PrpLscheduleMain";
        String statement = mainStatement + " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLscheduleMainDto prpLscheduleMainDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLscheduleMainDto = new PrpLscheduleMainDto();
            prpLscheduleMainDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleMainDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleMainDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLscheduleMainDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLscheduleMainDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLscheduleMainDto.setSelectTSend(dbManager.getString(resultSet,6));
            prpLscheduleMainDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLscheduleMainDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLscheduleMainDto.setScheduleDeptCode(dbManager.getString(resultSet,9));
            prpLscheduleMainDto.setScheduleDeptName(dbManager.getString(resultSet,10));
            prpLscheduleMainDto.setOperatorCode(dbManager.getString(resultSet,11));
            prpLscheduleMainDto.setOperatorName(dbManager.getString(resultSet,12));
            prpLscheduleMainDto.setSurveyTimes(dbManager.getInt(resultSet,13));
            prpLscheduleMainDto.setSurveyType(dbManager.getString(resultSet,14));
            prpLscheduleMainDto.setSurveyAddress(dbManager.getString(resultSet,15));
            prpLscheduleMainDto.setLicenseNo(dbManager.getString(resultSet,16));
            prpLscheduleMainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLscheduleMainDto.setInputHour(dbManager.getInt(resultSet,18));
            prpLscheduleMainDto.setResultInfo(dbManager.getString(resultSet,19));
            prpLscheduleMainDto.setTransFlag(dbManager.getString(resultSet,20));
            prpLscheduleMainDto.setBookFlag(dbManager.getString(resultSet,21));
            prpLscheduleMainDto.setScheduleFlag(dbManager.getString(resultSet,22));
            prpLscheduleMainDto.setFlag(dbManager.getString(resultSet,23));
            logger.info("DBPrpLscheduleMainBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLscheduleMainBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLscheduleMainDto;
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
        String statement = "Select ScheduleID," + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectTSend," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ScheduleDeptCode," + 
                           " ScheduleDeptName," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " SurveyAddress," + 
                           " LicenseNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ResultInfo," + 
                           " TransFlag," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " Flag From PrpLscheduleMain Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleMainDto prpLscheduleMainDto = null;
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

            prpLscheduleMainDto = new PrpLscheduleMainDto();
            prpLscheduleMainDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleMainDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleMainDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLscheduleMainDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLscheduleMainDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLscheduleMainDto.setSelectTSend(dbManager.getString(resultSet,6));
            prpLscheduleMainDto.setRiskCode(dbManager.getString(resultSet,7));
            prpLscheduleMainDto.setPolicyNo(dbManager.getString(resultSet,8));
            prpLscheduleMainDto.setScheduleDeptCode(dbManager.getString(resultSet,9));
            prpLscheduleMainDto.setScheduleDeptName(dbManager.getString(resultSet,10));
            prpLscheduleMainDto.setOperatorCode(dbManager.getString(resultSet,11));
            prpLscheduleMainDto.setOperatorName(dbManager.getString(resultSet,12));
            prpLscheduleMainDto.setSurveyTimes(dbManager.getInt(resultSet,13));
            prpLscheduleMainDto.setSurveyType(dbManager.getString(resultSet,14));
            prpLscheduleMainDto.setSurveyAddress(dbManager.getString(resultSet,15));
            prpLscheduleMainDto.setLicenseNo(dbManager.getString(resultSet,16));
            prpLscheduleMainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLscheduleMainDto.setInputHour(dbManager.getInt(resultSet,18));
            prpLscheduleMainDto.setResultInfo(dbManager.getString(resultSet,19));
            prpLscheduleMainDto.setTransFlag(dbManager.getString(resultSet,20));
            prpLscheduleMainDto.setBookFlag(dbManager.getString(resultSet,21));
            prpLscheduleMainDto.setScheduleFlag(dbManager.getString(resultSet,22));
            prpLscheduleMainDto.setFlag(dbManager.getString(resultSet,23));
            collection.add(prpLscheduleMainDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleMainBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleMain Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleMainBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleMain Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleMainBase.getCount() success!");
        return count;
    }
}
