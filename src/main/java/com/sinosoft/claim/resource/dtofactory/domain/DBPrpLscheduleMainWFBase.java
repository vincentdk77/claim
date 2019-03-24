package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMainWF的数据访问对象基类<br>
 * 创建于 2005-06-30 16:57:30.565<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleMainWFBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleMainWFBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleMainWFBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void insert(PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleMainWF (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " SurveyNo," + 
                           " ClaimComCode," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ScheduleArea," + 
                           " ScheduleMoreFlag," + 
                           " ScheduleFlag," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " ScheduleType," + 
                           " CheckInputDate," + 
                           " CheckOperatorCode," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag," + 
                           " CheckSite," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " InputMinute," + 
                           " ScheduleStatus)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLscheduleMainWFDto.getScheduleID() + "," + 
                           "'" + prpLscheduleMainWFDto.getRegistNo() + "'," + 
                           "" + prpLscheduleMainWFDto.getSurveyNo() + "," + 
                           "'" + prpLscheduleMainWFDto.getClaimComCode() + "'," + 
                           "'" + prpLscheduleMainWFDto.getRiskCode() + "'," + 
                           "'" + prpLscheduleMainWFDto.getPolicyNo() + "'," + 
                           "'" + prpLscheduleMainWFDto.getOperatorCode() + "'," + 
                           "'" + prpLscheduleMainWFDto.getInputDate() + "'," + 
                           "" + prpLscheduleMainWFDto.getInputHour() + "," + 
                           "" + prpLscheduleMainWFDto.getScheduleArea() + "," + 
                           "'" + prpLscheduleMainWFDto.getScheduleMoreFlag() + "'," + 
                           "'" + prpLscheduleMainWFDto.getScheduleFlag() + "'," + 
                           "'" + prpLscheduleMainWFDto.getScheduleObjectID() + "'," + 
                           "'" + prpLscheduleMainWFDto.getScheduleObjectName() + "'," + 
                           "'" + prpLscheduleMainWFDto.getScheduleType() + "'," + 
                           "'" + prpLscheduleMainWFDto.getCheckInputDate() + "'," + 
                           "'" + prpLscheduleMainWFDto.getCheckOperatorCode() + "'," + 
                           "'" + prpLscheduleMainWFDto.getCheckFlag() + "'," + 
                           "'" + prpLscheduleMainWFDto.getCheckInfo() + "'," + 
                           "'" + prpLscheduleMainWFDto.getFlag() + "'," + 
                           "'" + prpLscheduleMainWFDto.getCheckSite() + "'," + 
                           "'" + prpLscheduleMainWFDto.getNextHandlerCode() + "'," + 
                           "'" + prpLscheduleMainWFDto.getNextHandlerName() + "'," + 
                           "'" + prpLscheduleMainWFDto.getNextNodeNo() + "'," + 
                           "" + prpLscheduleMainWFDto.getInputMinute() + "," + 
                           "'" + prpLscheduleMainWFDto.getScheduleStatus() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLscheduleMainWFDto.getScheduleID());
        dbManager.setString(2,prpLscheduleMainWFDto.getRegistNo());
        dbManager.setInt(3,prpLscheduleMainWFDto.getSurveyNo());
        dbManager.setString(4,prpLscheduleMainWFDto.getClaimComCode());
        dbManager.setString(5,prpLscheduleMainWFDto.getRiskCode());
        dbManager.setString(6,prpLscheduleMainWFDto.getPolicyNo());
        dbManager.setString(7,prpLscheduleMainWFDto.getOperatorCode());
        dbManager.setDateTime(8,prpLscheduleMainWFDto.getInputDate());
        dbManager.setInt(9,prpLscheduleMainWFDto.getInputHour());
        dbManager.setInt(10,prpLscheduleMainWFDto.getScheduleArea());
        dbManager.setString(11,prpLscheduleMainWFDto.getScheduleMoreFlag());
        dbManager.setString(12,prpLscheduleMainWFDto.getScheduleFlag());
        dbManager.setString(13,prpLscheduleMainWFDto.getScheduleObjectID());
        dbManager.setString(14,prpLscheduleMainWFDto.getScheduleObjectName());
        dbManager.setString(15,prpLscheduleMainWFDto.getScheduleType());
        dbManager.setDateTime(16,prpLscheduleMainWFDto.getCheckInputDate());
        dbManager.setString(17,prpLscheduleMainWFDto.getCheckOperatorCode());
        dbManager.setString(18,prpLscheduleMainWFDto.getCheckFlag());
        dbManager.setString(19,prpLscheduleMainWFDto.getCheckInfo());
        dbManager.setString(20,prpLscheduleMainWFDto.getFlag());
        dbManager.setString(21,prpLscheduleMainWFDto.getCheckSite());
        dbManager.setString(22,prpLscheduleMainWFDto.getNextHandlerCode());
        dbManager.setString(23,prpLscheduleMainWFDto.getNextHandlerName());
        dbManager.setString(24,prpLscheduleMainWFDto.getNextNodeNo());
        dbManager.setInt(25,prpLscheduleMainWFDto.getInputMinute());
        dbManager.setString(26,prpLscheduleMainWFDto.getScheduleStatus());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleMainWFBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)i.next();
            insert(prpLscheduleMainWFDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo) throws Exception{
        String statement = " Delete From PrpLscheduleMainWF" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleMainWF Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleMainWFBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleMainWFDto prpLscheduleMainWFDto
     * @throws Exception
     */
    public void update(PrpLscheduleMainWFDto prpLscheduleMainWFDto) throws Exception{
        String statement = " Update PrpLscheduleMainWF Set SurveyNo = ?," + 
                           " ClaimComCode = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " InputHour = ?," + 
                           " ScheduleArea = ?," + 
                           " ScheduleMoreFlag = ?," + 
                           " ScheduleFlag = ?," + 
                           " ScheduleObjectID = ?," + 
                           " ScheduleObjectName = ?," + 
                           " ScheduleType = ?," + 
                           " CheckInputDate = ?," + 
                           " CheckOperatorCode = ?," + 
                           " CheckFlag = ?," + 
                           " CheckInfo = ?," + 
                           " Flag = ?," + 
                           " CheckSite = ?," + 
                           " NextHandlerCode = ?," + 
                           " NextHandlerName = ?," + 
                           " NextNodeNo = ?," + 
                           " InputMinute = ?," + 
                           " ScheduleStatus = ?" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleMainWF Set " + 
                           " ScheduleID = " + prpLscheduleMainWFDto.getScheduleID() + "," + 
                           " RegistNo = '" + prpLscheduleMainWFDto.getRegistNo() + "'," + 
                           " SurveyNo = " + prpLscheduleMainWFDto.getSurveyNo() + "," + 
                           " ClaimComCode = '" + prpLscheduleMainWFDto.getClaimComCode() + "'," + 
                           " RiskCode = '" + prpLscheduleMainWFDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLscheduleMainWFDto.getPolicyNo() + "'," + 
                           " OperatorCode = '" + prpLscheduleMainWFDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLscheduleMainWFDto.getInputDate() + "'," + 
                           " InputHour = " + prpLscheduleMainWFDto.getInputHour() + "," + 
                           " ScheduleArea = " + prpLscheduleMainWFDto.getScheduleArea() + "," + 
                           " ScheduleMoreFlag = '" + prpLscheduleMainWFDto.getScheduleMoreFlag() + "'," + 
                           " ScheduleFlag = '" + prpLscheduleMainWFDto.getScheduleFlag() + "'," + 
                           " ScheduleObjectID = '" + prpLscheduleMainWFDto.getScheduleObjectID() + "'," + 
                           " ScheduleObjectName = '" + prpLscheduleMainWFDto.getScheduleObjectName() + "'," + 
                           " ScheduleType = '" + prpLscheduleMainWFDto.getScheduleType() + "'," + 
                           " CheckInputDate = '" + prpLscheduleMainWFDto.getCheckInputDate() + "'," + 
                           " CheckOperatorCode = '" + prpLscheduleMainWFDto.getCheckOperatorCode() + "'," + 
                           " CheckFlag = '" + prpLscheduleMainWFDto.getCheckFlag() + "'," + 
                           " CheckInfo = '" + prpLscheduleMainWFDto.getCheckInfo() + "'," + 
                           " Flag = '" + prpLscheduleMainWFDto.getFlag() + "'," + 
                           " CheckSite = '" + prpLscheduleMainWFDto.getCheckSite() + "'," + 
                           " NextHandlerCode = '" + prpLscheduleMainWFDto.getNextHandlerCode() + "'," + 
                           " NextHandlerName = '" + prpLscheduleMainWFDto.getNextHandlerName() + "'," + 
                           " NextNodeNo = '" + prpLscheduleMainWFDto.getNextNodeNo() + "'," + 
                           " InputMinute = " + prpLscheduleMainWFDto.getInputMinute() + "," + 
                           " ScheduleStatus = '" + prpLscheduleMainWFDto.getScheduleStatus() + "'" + 
			               " Where " +
                           " ScheduleID = " + prpLscheduleMainWFDto.getScheduleID() + " And " + 
                           " RegistNo = '" + prpLscheduleMainWFDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setInt(1,prpLscheduleMainWFDto.getSurveyNo());
        dbManager.setString(2,prpLscheduleMainWFDto.getClaimComCode());
        dbManager.setString(3,prpLscheduleMainWFDto.getRiskCode());
        dbManager.setString(4,prpLscheduleMainWFDto.getPolicyNo());
        dbManager.setString(5,prpLscheduleMainWFDto.getOperatorCode());
        dbManager.setDateTime(6,prpLscheduleMainWFDto.getInputDate());
        dbManager.setInt(7,prpLscheduleMainWFDto.getInputHour());
        dbManager.setInt(8,prpLscheduleMainWFDto.getScheduleArea());
        dbManager.setString(9,prpLscheduleMainWFDto.getScheduleMoreFlag());
        dbManager.setString(10,prpLscheduleMainWFDto.getScheduleFlag());
        dbManager.setString(11,prpLscheduleMainWFDto.getScheduleObjectID());
        dbManager.setString(12,prpLscheduleMainWFDto.getScheduleObjectName());
        dbManager.setString(13,prpLscheduleMainWFDto.getScheduleType());
        dbManager.setDateTime(14,prpLscheduleMainWFDto.getCheckInputDate());
        dbManager.setString(15,prpLscheduleMainWFDto.getCheckOperatorCode());
        dbManager.setString(16,prpLscheduleMainWFDto.getCheckFlag());
        dbManager.setString(17,prpLscheduleMainWFDto.getCheckInfo());
        dbManager.setString(18,prpLscheduleMainWFDto.getFlag());
        dbManager.setString(19,prpLscheduleMainWFDto.getCheckSite());
        dbManager.setString(20,prpLscheduleMainWFDto.getNextHandlerCode());
        dbManager.setString(21,prpLscheduleMainWFDto.getNextHandlerName());
        dbManager.setString(22,prpLscheduleMainWFDto.getNextNodeNo());
        dbManager.setInt(23,prpLscheduleMainWFDto.getInputMinute());
        dbManager.setString(24,prpLscheduleMainWFDto.getScheduleStatus());
        //设置条件字段;
        dbManager.setInt(25,prpLscheduleMainWFDto.getScheduleID());
        dbManager.setString(26,prpLscheduleMainWFDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleMainWFBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @return PrpLscheduleMainWFDto
     * @throws Exception
     */
    public PrpLscheduleMainWFDto findByPrimaryKey(int scheduleID,String registNo) throws Exception{
        String mainStatement = " Select ScheduleID," + 
                           " RegistNo," + 
                           " SurveyNo," + 
                           " ClaimComCode," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ScheduleArea," + 
                           " ScheduleMoreFlag," + 
                           " ScheduleFlag," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " ScheduleType," + 
                           " CheckInputDate," + 
                           " CheckOperatorCode," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag," + 
                           " CheckSite," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " InputMinute," + 
                           " ScheduleStatus," + 
                           " CommiItemFlag From PrpLscheduleMainWF";
        String statement = mainStatement + " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ?";
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
            prpLscheduleMainWFDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleMainWFDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleMainWFDto.setSurveyNo(dbManager.getInt(resultSet,3));
            prpLscheduleMainWFDto.setClaimComCode(dbManager.getString(resultSet,4));
            prpLscheduleMainWFDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLscheduleMainWFDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLscheduleMainWFDto.setOperatorCode(dbManager.getString(resultSet,7));
            prpLscheduleMainWFDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLscheduleMainWFDto.setInputHour(dbManager.getInt(resultSet,9));
            prpLscheduleMainWFDto.setScheduleArea(dbManager.getInt(resultSet,10));
            prpLscheduleMainWFDto.setScheduleMoreFlag(dbManager.getString(resultSet,11));
            prpLscheduleMainWFDto.setScheduleFlag(dbManager.getString(resultSet,12));
            prpLscheduleMainWFDto.setScheduleObjectID(dbManager.getString(resultSet,13));
            prpLscheduleMainWFDto.setScheduleObjectName(dbManager.getString(resultSet,14));
            prpLscheduleMainWFDto.setScheduleType(dbManager.getString(resultSet,15));
            prpLscheduleMainWFDto.setCheckInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpLscheduleMainWFDto.setCheckOperatorCode(dbManager.getString(resultSet,17));
            prpLscheduleMainWFDto.setCheckFlag(dbManager.getString(resultSet,18));
            prpLscheduleMainWFDto.setCheckInfo(dbManager.getString(resultSet,19));
            prpLscheduleMainWFDto.setFlag(dbManager.getString(resultSet,20));
            prpLscheduleMainWFDto.setCheckSite(dbManager.getString(resultSet,21));
            prpLscheduleMainWFDto.setNextHandlerCode(dbManager.getString(resultSet,22));
            prpLscheduleMainWFDto.setNextHandlerName(dbManager.getString(resultSet,23));
            prpLscheduleMainWFDto.setNextNodeNo(dbManager.getString(resultSet,24));
            prpLscheduleMainWFDto.setInputMinute(dbManager.getInt(resultSet,25));
            prpLscheduleMainWFDto.setScheduleStatus(dbManager.getString(resultSet,26));
            prpLscheduleMainWFDto.setCommiItemFlag(dbManager.getString(resultSet,27));  //2005-12-11 add by liyanjie
        }
        resultSet.close();
        logger.info("DBPrpLscheduleMainWFBase.findByPrimaryKey() success!");
        return prpLscheduleMainWFDto;
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
                           " SurveyNo," + 
                           " ClaimComCode," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " InputHour," + 
                           " ScheduleArea," + 
                           " ScheduleMoreFlag," + 
                           " ScheduleFlag," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " ScheduleType," + 
                           " CheckInputDate," + 
                           " CheckOperatorCode," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag," + 
                           " CheckSite," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " InputMinute," + 
                           " ScheduleStatus," + 
                           " CommiItemFlag From PrpLscheduleMainWF Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
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

            prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
            prpLscheduleMainWFDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleMainWFDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleMainWFDto.setSurveyNo(dbManager.getInt(resultSet,3));
            prpLscheduleMainWFDto.setClaimComCode(dbManager.getString(resultSet,4));
            prpLscheduleMainWFDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLscheduleMainWFDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLscheduleMainWFDto.setOperatorCode(dbManager.getString(resultSet,7));
            prpLscheduleMainWFDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLscheduleMainWFDto.setInputHour(dbManager.getInt(resultSet,9));
            prpLscheduleMainWFDto.setScheduleArea(dbManager.getInt(resultSet,10));
            prpLscheduleMainWFDto.setScheduleMoreFlag(dbManager.getString(resultSet,11));
            prpLscheduleMainWFDto.setScheduleFlag(dbManager.getString(resultSet,12));
            prpLscheduleMainWFDto.setScheduleObjectID(dbManager.getString(resultSet,13));
            prpLscheduleMainWFDto.setScheduleObjectName(dbManager.getString(resultSet,14));
            prpLscheduleMainWFDto.setScheduleType(dbManager.getString(resultSet,15));
            prpLscheduleMainWFDto.setCheckInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpLscheduleMainWFDto.setCheckOperatorCode(dbManager.getString(resultSet,17));
            prpLscheduleMainWFDto.setCheckFlag(dbManager.getString(resultSet,18));
            prpLscheduleMainWFDto.setCheckInfo(dbManager.getString(resultSet,19));
            prpLscheduleMainWFDto.setFlag(dbManager.getString(resultSet,20));
            prpLscheduleMainWFDto.setCheckSite(dbManager.getString(resultSet,21));
            prpLscheduleMainWFDto.setNextHandlerCode(dbManager.getString(resultSet,22));
            prpLscheduleMainWFDto.setNextHandlerName(dbManager.getString(resultSet,23));
            prpLscheduleMainWFDto.setNextNodeNo(dbManager.getString(resultSet,24));
            prpLscheduleMainWFDto.setInputMinute(dbManager.getInt(resultSet,25));
            prpLscheduleMainWFDto.setScheduleStatus(dbManager.getString(resultSet,26));
            prpLscheduleMainWFDto.setCommiItemFlag(dbManager.getString(resultSet,27)); // add by liyanjie 2005-12-11
            collection.add(prpLscheduleMainWFDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleMainWFBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleMainWF Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleMainWFBase.deleteByConditions() success!");
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
        conditions = SqlUtils.getWherePartForGetCount(conditions);
        String statement = "Select count(1) from PrpLscheduleMainWF Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleMainWFBase.getCount() success!");
        return count;
    } 
}
