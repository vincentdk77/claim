package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleNew-新案件调度提示表(新增)的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLscheduleNewBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleNewBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleNewBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void insert(PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleNew (" + 
                           " RegistNo," + 
                           " OperatorCode," + 
                           " LostLicenseNo," + 
                           " SurveyLicenseNo," + 
                           " SurveyNo," + 
                           " PolicyNo," + 
                           " ContactName," + 
                           " PhoneNumber," + 
                           " DamageCode," + 
                           " DamageName," + 
                           " DamageTypeCode," + 
                           " DamageTypeName," + 
                           " DamageAreaCode," + 
                           " DamageAreaName," + 
                           " DamageAddressType," + 
                           " AddressCode," + 
                           " DamageAddress," + 
                           " DamageAreaPostCode," + 
                           " AccidentDetail," + 
                           " SurveyType," + 
                           " SigncustType," + 
                           " CustomerName," + 
                           " SurveyAddress," + 
                           " ReportWay," + 
                           " RiskCode," + 
                           " InsureComCode," + 
                           " SurveyDate," + 
                           " ScheduleInfo," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " AllKindCode," + 
                           " Flag," + 
                           " OperateDate)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLscheduleNewDto.getRegistNo() + "'," + 
                           "'" + prpLscheduleNewDto.getOperatorCode() + "'," + 
                           "'" + prpLscheduleNewDto.getLostLicenseNo() + "'," + 
                           "'" + prpLscheduleNewDto.getSurveyLicenseNo() + "'," + 
                           "" + prpLscheduleNewDto.getSurveyNo() + "," + 
                           "'" + prpLscheduleNewDto.getPolicyNo() + "'," + 
                           "'" + prpLscheduleNewDto.getContactName() + "'," + 
                           "'" + prpLscheduleNewDto.getPhoneNumber() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageCode() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageName() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageTypeCode() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageTypeName() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageAreaCode() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageAreaName() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageAddressType() + "'," + 
                           "'" + prpLscheduleNewDto.getAddressCode() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageAddress() + "'," + 
                           "'" + prpLscheduleNewDto.getDamageAreaPostCode() + "'," + 
                           "'" + prpLscheduleNewDto.getAccidentDetail() + "'," + 
                           "'" + prpLscheduleNewDto.getSurveyType() + "'," + 
                           "'" + prpLscheduleNewDto.getSigncustType() + "'," + 
                           "'" + prpLscheduleNewDto.getCustomerName() + "'," + 
                           "'" + prpLscheduleNewDto.getSurveyAddress() + "'," + 
                           "'" + prpLscheduleNewDto.getReportWay() + "'," + 
                           "'" + prpLscheduleNewDto.getRiskCode() + "'," + 
                           "'" + prpLscheduleNewDto.getInsureComCode() + "'," + 
                           "'" + prpLscheduleNewDto.getSurveyDate() + "'," + 
                           "'" + prpLscheduleNewDto.getScheduleInfo() + "'," + 
                           "'" + prpLscheduleNewDto.getBookFlag() + "'," + 
                           "'" + prpLscheduleNewDto.getScheduleFlag() + "'," + 
                           "'" + prpLscheduleNewDto.getAllKindCode() + "'," + 
                           "'" + prpLscheduleNewDto.getFlag() + "'," + 
                           "'" + prpLscheduleNewDto.getOperateDate() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLscheduleNewDto.getRegistNo());
        dbManager.setString(2,prpLscheduleNewDto.getOperatorCode());
        dbManager.setString(3,prpLscheduleNewDto.getLostLicenseNo());
        dbManager.setString(4,prpLscheduleNewDto.getSurveyLicenseNo());
        dbManager.setInt(5,prpLscheduleNewDto.getSurveyNo());
        dbManager.setString(6,prpLscheduleNewDto.getPolicyNo());
        dbManager.setString(7,prpLscheduleNewDto.getContactName());
        dbManager.setString(8,prpLscheduleNewDto.getPhoneNumber());
        dbManager.setString(9,prpLscheduleNewDto.getDamageCode());
        dbManager.setString(10,prpLscheduleNewDto.getDamageName());
        dbManager.setString(11,prpLscheduleNewDto.getDamageTypeCode());
        dbManager.setString(12,prpLscheduleNewDto.getDamageTypeName());
        dbManager.setString(13,prpLscheduleNewDto.getDamageAreaCode());
        dbManager.setString(14,prpLscheduleNewDto.getDamageAreaName());
        dbManager.setString(15,prpLscheduleNewDto.getDamageAddressType());
        dbManager.setString(16,prpLscheduleNewDto.getAddressCode());
        dbManager.setString(17,prpLscheduleNewDto.getDamageAddress());
        dbManager.setString(18,prpLscheduleNewDto.getDamageAreaPostCode());
        dbManager.setString(19,prpLscheduleNewDto.getAccidentDetail());
        dbManager.setString(20,prpLscheduleNewDto.getSurveyType());
        dbManager.setString(21,prpLscheduleNewDto.getSigncustType());
        dbManager.setString(22,prpLscheduleNewDto.getCustomerName());
        dbManager.setString(23,prpLscheduleNewDto.getSurveyAddress());
        dbManager.setString(24,prpLscheduleNewDto.getReportWay());
        dbManager.setString(25,prpLscheduleNewDto.getRiskCode());
        dbManager.setString(26,prpLscheduleNewDto.getInsureComCode());
        dbManager.setDateTime(27,prpLscheduleNewDto.getSurveyDate());
        dbManager.setString(28,prpLscheduleNewDto.getScheduleInfo());
        dbManager.setString(29,prpLscheduleNewDto.getBookFlag());
        dbManager.setString(30,prpLscheduleNewDto.getScheduleFlag());
        dbManager.setString(31,prpLscheduleNewDto.getAllKindCode());
        dbManager.setString(32,prpLscheduleNewDto.getFlag());
        dbManager.setString(33,prpLscheduleNewDto.getOperateDate());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleNewBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleNew (" + 
                           " RegistNo," + 
                           " OperatorCode," + 
                           " LostLicenseNo," + 
                           " SurveyLicenseNo," + 
                           " SurveyNo," + 
                           " PolicyNo," + 
                           " ContactName," + 
                           " PhoneNumber," + 
                           " DamageCode," + 
                           " DamageName," + 
                           " DamageTypeCode," + 
                           " DamageTypeName," + 
                           " DamageAreaCode," + 
                           " DamageAreaName," + 
                           " DamageAddressType," + 
                           " AddressCode," + 
                           " DamageAddress," + 
                           " DamageAreaPostCode," + 
                           " AccidentDetail," + 
                           " SurveyType," + 
                           " SigncustType," + 
                           " CustomerName," + 
                           " SurveyAddress," + 
                           " ReportWay," + 
                           " RiskCode," + 
                           " InsureComCode," + 
                           " SurveyDate," + 
                           " ScheduleInfo," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " AllKindCode," + 
                           " Flag," + 
                           " OperateDate)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLscheduleNewDto prpLscheduleNewDto = (PrpLscheduleNewDto)i.next();
            dbManager.setString(1,prpLscheduleNewDto.getRegistNo());
            dbManager.setString(2,prpLscheduleNewDto.getOperatorCode());
            dbManager.setString(3,prpLscheduleNewDto.getLostLicenseNo());
            dbManager.setString(4,prpLscheduleNewDto.getSurveyLicenseNo());
            dbManager.setInt(5,prpLscheduleNewDto.getSurveyNo());
            dbManager.setString(6,prpLscheduleNewDto.getPolicyNo());
            dbManager.setString(7,prpLscheduleNewDto.getContactName());
            dbManager.setString(8,prpLscheduleNewDto.getPhoneNumber());
            dbManager.setString(9,prpLscheduleNewDto.getDamageCode());
            dbManager.setString(10,prpLscheduleNewDto.getDamageName());
            dbManager.setString(11,prpLscheduleNewDto.getDamageTypeCode());
            dbManager.setString(12,prpLscheduleNewDto.getDamageTypeName());
            dbManager.setString(13,prpLscheduleNewDto.getDamageAreaCode());
            dbManager.setString(14,prpLscheduleNewDto.getDamageAreaName());
            dbManager.setString(15,prpLscheduleNewDto.getDamageAddressType());
            dbManager.setString(16,prpLscheduleNewDto.getAddressCode());
            dbManager.setString(17,prpLscheduleNewDto.getDamageAddress());
            dbManager.setString(18,prpLscheduleNewDto.getDamageAreaPostCode());
            dbManager.setString(19,prpLscheduleNewDto.getAccidentDetail());
            dbManager.setString(20,prpLscheduleNewDto.getSurveyType());
            dbManager.setString(21,prpLscheduleNewDto.getSigncustType());
            dbManager.setString(22,prpLscheduleNewDto.getCustomerName());
            dbManager.setString(23,prpLscheduleNewDto.getSurveyAddress());
            dbManager.setString(24,prpLscheduleNewDto.getReportWay());
            dbManager.setString(25,prpLscheduleNewDto.getRiskCode());
            dbManager.setString(26,prpLscheduleNewDto.getInsureComCode());
            dbManager.setDateTime(27,prpLscheduleNewDto.getSurveyDate());
            dbManager.setString(28,prpLscheduleNewDto.getScheduleInfo());
            dbManager.setString(29,prpLscheduleNewDto.getBookFlag());
            dbManager.setString(30,prpLscheduleNewDto.getScheduleFlag());
            dbManager.setString(31,prpLscheduleNewDto.getAllKindCode());
            dbManager.setString(32,prpLscheduleNewDto.getFlag());
            dbManager.setString(33,prpLscheduleNewDto.getOperateDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLscheduleNewBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案受理号
     * @param surveyNo 已查勘次数
     * @throws Exception
     */
    public void delete(String registNo,int surveyNo) throws Exception{
        String statement = " Delete From PrpLscheduleNew" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SurveyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleNew Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SurveyNo = " + surveyNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,surveyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLscheduleNewBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleNewDto prpLscheduleNewDto
     * @throws Exception
     */
    public void update(PrpLscheduleNewDto prpLscheduleNewDto) throws Exception{
        String statement = " Update PrpLscheduleNew Set OperatorCode = ?," + 
                           " LostLicenseNo = ?," + 
                           " SurveyLicenseNo = ?," + 
                           " PolicyNo = ?," + 
                           " ContactName = ?," + 
                           " PhoneNumber = ?," + 
                           " DamageCode = ?," + 
                           " DamageName = ?," + 
                           " DamageTypeCode = ?," + 
                           " DamageTypeName = ?," + 
                           " DamageAreaCode = ?," + 
                           " DamageAreaName = ?," + 
                           " DamageAddressType = ?," + 
                           " AddressCode = ?," + 
                           " DamageAddress = ?," + 
                           " DamageAreaPostCode = ?," + 
                           " AccidentDetail = ?," + 
                           " SurveyType = ?," + 
                           " SigncustType = ?," + 
                           " CustomerName = ?," + 
                           " SurveyAddress = ?," + 
                           " ReportWay = ?," + 
                           " RiskCode = ?," + 
                           " InsureComCode = ?," + 
                           " SurveyDate = ?," + 
                           " ScheduleInfo = ?," + 
                           " BookFlag = ?," + 
                           " ScheduleFlag = ?," + 
                           " AllKindCode = ?," + 
                           " Flag = ?," + 
                           " OperateDate = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SurveyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleNew Set " + 
                           " RegistNo = '" + prpLscheduleNewDto.getRegistNo() + "'," + 
                           " OperatorCode = '" + prpLscheduleNewDto.getOperatorCode() + "'," + 
                           " LostLicenseNo = '" + prpLscheduleNewDto.getLostLicenseNo() + "'," + 
                           " SurveyLicenseNo = '" + prpLscheduleNewDto.getSurveyLicenseNo() + "'," + 
                           " SurveyNo = " + prpLscheduleNewDto.getSurveyNo() + "," + 
                           " PolicyNo = '" + prpLscheduleNewDto.getPolicyNo() + "'," + 
                           " ContactName = '" + prpLscheduleNewDto.getContactName() + "'," + 
                           " PhoneNumber = '" + prpLscheduleNewDto.getPhoneNumber() + "'," + 
                           " DamageCode = '" + prpLscheduleNewDto.getDamageCode() + "'," + 
                           " DamageName = '" + prpLscheduleNewDto.getDamageName() + "'," + 
                           " DamageTypeCode = '" + prpLscheduleNewDto.getDamageTypeCode() + "'," + 
                           " DamageTypeName = '" + prpLscheduleNewDto.getDamageTypeName() + "'," + 
                           " DamageAreaCode = '" + prpLscheduleNewDto.getDamageAreaCode() + "'," + 
                           " DamageAreaName = '" + prpLscheduleNewDto.getDamageAreaName() + "'," + 
                           " DamageAddressType = '" + prpLscheduleNewDto.getDamageAddressType() + "'," + 
                           " AddressCode = '" + prpLscheduleNewDto.getAddressCode() + "'," + 
                           " DamageAddress = '" + prpLscheduleNewDto.getDamageAddress() + "'," + 
                           " DamageAreaPostCode = '" + prpLscheduleNewDto.getDamageAreaPostCode() + "'," + 
                           " AccidentDetail = '" + prpLscheduleNewDto.getAccidentDetail() + "'," + 
                           " SurveyType = '" + prpLscheduleNewDto.getSurveyType() + "'," + 
                           " SigncustType = '" + prpLscheduleNewDto.getSigncustType() + "'," + 
                           " CustomerName = '" + prpLscheduleNewDto.getCustomerName() + "'," + 
                           " SurveyAddress = '" + prpLscheduleNewDto.getSurveyAddress() + "'," + 
                           " ReportWay = '" + prpLscheduleNewDto.getReportWay() + "'," + 
                           " RiskCode = '" + prpLscheduleNewDto.getRiskCode() + "'," + 
                           " InsureComCode = '" + prpLscheduleNewDto.getInsureComCode() + "'," + 
                           " SurveyDate = '" + prpLscheduleNewDto.getSurveyDate() + "'," + 
                           " ScheduleInfo = '" + prpLscheduleNewDto.getScheduleInfo() + "'," + 
                           " BookFlag = '" + prpLscheduleNewDto.getBookFlag() + "'," + 
                           " ScheduleFlag = '" + prpLscheduleNewDto.getScheduleFlag() + "'," + 
                           " AllKindCode = '" + prpLscheduleNewDto.getAllKindCode() + "'," + 
                           " Flag = '" + prpLscheduleNewDto.getFlag() + "'," + 
                           " OperateDate = '" + prpLscheduleNewDto.getOperateDate() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLscheduleNewDto.getRegistNo() + "' And " + 
                           " SurveyNo = " + prpLscheduleNewDto.getSurveyNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLscheduleNewDto.getOperatorCode());
        dbManager.setString(2,prpLscheduleNewDto.getLostLicenseNo());
        dbManager.setString(3,prpLscheduleNewDto.getSurveyLicenseNo());
        dbManager.setString(4,prpLscheduleNewDto.getPolicyNo());
        dbManager.setString(5,prpLscheduleNewDto.getContactName());
        dbManager.setString(6,prpLscheduleNewDto.getPhoneNumber());
        dbManager.setString(7,prpLscheduleNewDto.getDamageCode());
        dbManager.setString(8,prpLscheduleNewDto.getDamageName());
        dbManager.setString(9,prpLscheduleNewDto.getDamageTypeCode());
        dbManager.setString(10,prpLscheduleNewDto.getDamageTypeName());
        dbManager.setString(11,prpLscheduleNewDto.getDamageAreaCode());
        dbManager.setString(12,prpLscheduleNewDto.getDamageAreaName());
        dbManager.setString(13,prpLscheduleNewDto.getDamageAddressType());
        dbManager.setString(14,prpLscheduleNewDto.getAddressCode());
        dbManager.setString(15,prpLscheduleNewDto.getDamageAddress());
        dbManager.setString(16,prpLscheduleNewDto.getDamageAreaPostCode());
        dbManager.setString(17,prpLscheduleNewDto.getAccidentDetail());
        dbManager.setString(18,prpLscheduleNewDto.getSurveyType());
        dbManager.setString(19,prpLscheduleNewDto.getSigncustType());
        dbManager.setString(20,prpLscheduleNewDto.getCustomerName());
        dbManager.setString(21,prpLscheduleNewDto.getSurveyAddress());
        dbManager.setString(22,prpLscheduleNewDto.getReportWay());
        dbManager.setString(23,prpLscheduleNewDto.getRiskCode());
        dbManager.setString(24,prpLscheduleNewDto.getInsureComCode());
        dbManager.setDateTime(25,prpLscheduleNewDto.getSurveyDate());
        dbManager.setString(26,prpLscheduleNewDto.getScheduleInfo());
        dbManager.setString(27,prpLscheduleNewDto.getBookFlag());
        dbManager.setString(28,prpLscheduleNewDto.getScheduleFlag());
        dbManager.setString(29,prpLscheduleNewDto.getAllKindCode());
        dbManager.setString(30,prpLscheduleNewDto.getFlag());
        dbManager.setString(31,prpLscheduleNewDto.getOperateDate());
        //设置条件字段;
        dbManager.setString(32,prpLscheduleNewDto.getRegistNo());
        dbManager.setInt(33,prpLscheduleNewDto.getSurveyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleNewBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案受理号
     * @param surveyNo 已查勘次数
     * @return PrpLscheduleNewDto
     * @throws Exception
     */
    public PrpLscheduleNewDto findByPrimaryKey(String registNo,int surveyNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " OperatorCode," + 
                           " LostLicenseNo," + 
                           " SurveyLicenseNo," + 
                           " SurveyNo," + 
                           " PolicyNo," + 
                           " ContactName," + 
                           " PhoneNumber," + 
                           " DamageCode," + 
                           " DamageName," + 
                           " DamageTypeCode," + 
                           " DamageTypeName," + 
                           " DamageAreaCode," + 
                           " DamageAreaName," + 
                           " DamageAddressType," + 
                           " AddressCode," + 
                           " DamageAddress," + 
                           " DamageAreaPostCode," + 
                           " AccidentDetail," + 
                           " SurveyType," + 
                           " SigncustType," + 
                           " CustomerName," + 
                           " SurveyAddress," + 
                           " ReportWay," + 
                           " RiskCode," + 
                           " InsureComCode," + 
                           " SurveyDate," + 
                           " ScheduleInfo," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " AllKindCode," + 
                           " Flag," + 
                           " OperateDate From PrpLscheduleNew";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SurveyNo = ?";
        PrpLscheduleNewDto prpLscheduleNewDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SurveyNo = " + surveyNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,surveyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLscheduleNewDto = new PrpLscheduleNewDto();
            prpLscheduleNewDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLscheduleNewDto.setOperatorCode(dbManager.getString(resultSet,2));
            prpLscheduleNewDto.setLostLicenseNo(dbManager.getString(resultSet,3));
            prpLscheduleNewDto.setSurveyLicenseNo(dbManager.getString(resultSet,4));
            prpLscheduleNewDto.setSurveyNo(dbManager.getInt(resultSet,5));
            prpLscheduleNewDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLscheduleNewDto.setContactName(dbManager.getString(resultSet,7));
            prpLscheduleNewDto.setPhoneNumber(dbManager.getString(resultSet,8));
            prpLscheduleNewDto.setDamageCode(dbManager.getString(resultSet,9));
            prpLscheduleNewDto.setDamageName(dbManager.getString(resultSet,10));
            prpLscheduleNewDto.setDamageTypeCode(dbManager.getString(resultSet,11));
            prpLscheduleNewDto.setDamageTypeName(dbManager.getString(resultSet,12));
            prpLscheduleNewDto.setDamageAreaCode(dbManager.getString(resultSet,13));
            prpLscheduleNewDto.setDamageAreaName(dbManager.getString(resultSet,14));
            prpLscheduleNewDto.setDamageAddressType(dbManager.getString(resultSet,15));
            prpLscheduleNewDto.setAddressCode(dbManager.getString(resultSet,16));
            prpLscheduleNewDto.setDamageAddress(dbManager.getString(resultSet,17));
            prpLscheduleNewDto.setDamageAreaPostCode(dbManager.getString(resultSet,18));
            prpLscheduleNewDto.setAccidentDetail(dbManager.getString(resultSet,19));
            prpLscheduleNewDto.setSurveyType(dbManager.getString(resultSet,20));
            prpLscheduleNewDto.setSigncustType(dbManager.getString(resultSet,21));
            prpLscheduleNewDto.setCustomerName(dbManager.getString(resultSet,22));
            prpLscheduleNewDto.setSurveyAddress(dbManager.getString(resultSet,23));
            prpLscheduleNewDto.setReportWay(dbManager.getString(resultSet,24));
            prpLscheduleNewDto.setRiskCode(dbManager.getString(resultSet,25));
            prpLscheduleNewDto.setInsureComCode(dbManager.getString(resultSet,26));
            prpLscheduleNewDto.setSurveyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLscheduleNewDto.setScheduleInfo(dbManager.getString(resultSet,28));
            prpLscheduleNewDto.setBookFlag(dbManager.getString(resultSet,29));
            prpLscheduleNewDto.setScheduleFlag(dbManager.getString(resultSet,30));
            prpLscheduleNewDto.setAllKindCode(dbManager.getString(resultSet,31));
            prpLscheduleNewDto.setFlag(dbManager.getString(resultSet,32));
            prpLscheduleNewDto.setOperateDate(dbManager.getString(resultSet,33));
            logger.info("DBPrpLscheduleNewBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLscheduleNewBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLscheduleNewDto;
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
        String statement = "Select RegistNo," + 
                           " OperatorCode," + 
                           " LostLicenseNo," + 
                           " SurveyLicenseNo," + 
                           " SurveyNo," + 
                           " PolicyNo," + 
                           " ContactName," + 
                           " PhoneNumber," + 
                           " DamageCode," + 
                           " DamageName," + 
                           " DamageTypeCode," + 
                           " DamageTypeName," + 
                           " DamageAreaCode," + 
                           " DamageAreaName," + 
                           " DamageAddressType," + 
                           " AddressCode," + 
                           " DamageAddress," + 
                           " DamageAreaPostCode," + 
                           " AccidentDetail," + 
                           " SurveyType," + 
                           " SigncustType," + 
                           " CustomerName," + 
                           " SurveyAddress," + 
                           " ReportWay," + 
                           " RiskCode," + 
                           " InsureComCode," + 
                           " SurveyDate," + 
                           " ScheduleInfo," + 
                           " BookFlag," + 
                           " ScheduleFlag," + 
                           " AllKindCode," + 
                           " Flag," + 
                           " OperateDate From PrpLscheduleNew Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleNewDto prpLscheduleNewDto = null;
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

            prpLscheduleNewDto = new PrpLscheduleNewDto();
            prpLscheduleNewDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLscheduleNewDto.setOperatorCode(dbManager.getString(resultSet,2));
            prpLscheduleNewDto.setLostLicenseNo(dbManager.getString(resultSet,3));
            prpLscheduleNewDto.setSurveyLicenseNo(dbManager.getString(resultSet,4));
            prpLscheduleNewDto.setSurveyNo(dbManager.getInt(resultSet,5));
            prpLscheduleNewDto.setPolicyNo(dbManager.getString(resultSet,6));
            prpLscheduleNewDto.setContactName(dbManager.getString(resultSet,7));
            prpLscheduleNewDto.setPhoneNumber(dbManager.getString(resultSet,8));
            prpLscheduleNewDto.setDamageCode(dbManager.getString(resultSet,9));
            prpLscheduleNewDto.setDamageName(dbManager.getString(resultSet,10));
            prpLscheduleNewDto.setDamageTypeCode(dbManager.getString(resultSet,11));
            prpLscheduleNewDto.setDamageTypeName(dbManager.getString(resultSet,12));
            prpLscheduleNewDto.setDamageAreaCode(dbManager.getString(resultSet,13));
            prpLscheduleNewDto.setDamageAreaName(dbManager.getString(resultSet,14));
            prpLscheduleNewDto.setDamageAddressType(dbManager.getString(resultSet,15));
            prpLscheduleNewDto.setAddressCode(dbManager.getString(resultSet,16));
            prpLscheduleNewDto.setDamageAddress(dbManager.getString(resultSet,17));
            prpLscheduleNewDto.setDamageAreaPostCode(dbManager.getString(resultSet,18));
            prpLscheduleNewDto.setAccidentDetail(dbManager.getString(resultSet,19));
            prpLscheduleNewDto.setSurveyType(dbManager.getString(resultSet,20));
            prpLscheduleNewDto.setSigncustType(dbManager.getString(resultSet,21));
            prpLscheduleNewDto.setCustomerName(dbManager.getString(resultSet,22));
            prpLscheduleNewDto.setSurveyAddress(dbManager.getString(resultSet,23));
            prpLscheduleNewDto.setReportWay(dbManager.getString(resultSet,24));
            prpLscheduleNewDto.setRiskCode(dbManager.getString(resultSet,25));
            prpLscheduleNewDto.setInsureComCode(dbManager.getString(resultSet,26));
            prpLscheduleNewDto.setSurveyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLscheduleNewDto.setScheduleInfo(dbManager.getString(resultSet,28));
            prpLscheduleNewDto.setBookFlag(dbManager.getString(resultSet,29));
            prpLscheduleNewDto.setScheduleFlag(dbManager.getString(resultSet,30));
            prpLscheduleNewDto.setAllKindCode(dbManager.getString(resultSet,31));
            prpLscheduleNewDto.setFlag(dbManager.getString(resultSet,32));
            prpLscheduleNewDto.setOperateDate(dbManager.getString(resultSet,33));
            collection.add(prpLscheduleNewDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleNewBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleNew Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleNewBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleNew Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleNewBase.getCount() success!");
        return count;
    }
}
