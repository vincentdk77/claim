package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLsalvationDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLsalvation-特约救助表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.062<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLsalvationBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLsalvationBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLsalvationBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void insert(PrpLsalvationDto prpLsalvationDto) throws Exception{
        String mainStatement = " Insert Into PrpLsalvation (" + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " SalvationNo," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " EngineNo," + 
                           " ColorCode," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " DriverName," + 
                           " Phone," + 
                           " SalvaType," + 
                           " DamageTime," + 
                           " MoneyFlag," + 
                           " SalvaItemCode," + 
                           " SalvaItemName," + 
                           " SalvaSite," + 
                           " SendSite," + 
                           " SalvaAssistUnit," + 
                           " SalvaUnitHandler," + 
                           " SalvaRoute," + 
                           " SalvaMile," + 
                           " InsureUnitCode," + 
                           " InsureUnitName," + 
                           " FeeStandard," + 
                           " SalvaFee," + 
                           " ArriveDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " VerifyDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLsalvationDto.getRegistNo() + "'," + 
                           "" + prpLsalvationDto.getSerialNo() + "," + 
                           "'" + prpLsalvationDto.getSalvationNo() + "'," + 
                           "'" + prpLsalvationDto.getPolicyNo() + "'," + 
                           "'" + prpLsalvationDto.getLicenseNo() + "'," + 
                           "'" + prpLsalvationDto.getLicenseColorCode() + "'," + 
                           "'" + prpLsalvationDto.getEngineNo() + "'," + 
                           "'" + prpLsalvationDto.getColorCode() + "'," + 
                           "'" + prpLsalvationDto.getModelCode() + "'," + 
                           "'" + prpLsalvationDto.getBrandName() + "'," + 
                           "'" + prpLsalvationDto.getDriverName() + "'," + 
                           "'" + prpLsalvationDto.getPhone() + "'," + 
                           "'" + prpLsalvationDto.getSalvaType() + "'," + 
                           "'" + prpLsalvationDto.getDamageTime() + "'," + 
                           "'" + prpLsalvationDto.getMoneyFlag() + "'," + 
                           "'" + prpLsalvationDto.getSalvaItemCode() + "'," + 
                           "'" + prpLsalvationDto.getSalvaItemName() + "'," + 
                           "'" + prpLsalvationDto.getSalvaSite() + "'," + 
                           "'" + prpLsalvationDto.getSendSite() + "'," + 
                           "'" + prpLsalvationDto.getSalvaAssistUnit() + "'," + 
                           "'" + prpLsalvationDto.getSalvaUnitHandler() + "'," + 
                           "'" + prpLsalvationDto.getSalvaRoute() + "'," + 
                           "'" + prpLsalvationDto.getSalvaMile() + "'," + 
                           "'" + prpLsalvationDto.getInsureUnitCode() + "'," + 
                           "'" + prpLsalvationDto.getInsureUnitName() + "'," + 
                           "'" + prpLsalvationDto.getFeeStandard() + "'," + 
                           "'" + prpLsalvationDto.getSalvaFee() + "'," + 
                           "'" + prpLsalvationDto.getArriveDate() + "'," + 
                           "'" + prpLsalvationDto.getHandlerCode() + "'," + 
                           "'" + prpLsalvationDto.getOperatorCode() + "'," + 
                           "'" + prpLsalvationDto.getInputDate() + "'," + 
                           "'" + prpLsalvationDto.getVerifyDate() + "'," + 
                           "'" + prpLsalvationDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLsalvationDto.getRegistNo());
        dbManager.setInt(2,prpLsalvationDto.getSerialNo());
        dbManager.setString(3,prpLsalvationDto.getSalvationNo());
        dbManager.setString(4,prpLsalvationDto.getPolicyNo());
        dbManager.setString(5,prpLsalvationDto.getLicenseNo());
        dbManager.setString(6,prpLsalvationDto.getLicenseColorCode());
        dbManager.setString(7,prpLsalvationDto.getEngineNo());
        dbManager.setString(8,prpLsalvationDto.getColorCode());
        dbManager.setString(9,prpLsalvationDto.getModelCode());
        dbManager.setString(10,prpLsalvationDto.getBrandName());
        dbManager.setString(11,prpLsalvationDto.getDriverName());
        dbManager.setString(12,prpLsalvationDto.getPhone());
        dbManager.setString(13,prpLsalvationDto.getSalvaType());
        dbManager.setDateTime(14,prpLsalvationDto.getDamageTime());
        dbManager.setString(15,prpLsalvationDto.getMoneyFlag());
        dbManager.setString(16,prpLsalvationDto.getSalvaItemCode());
        dbManager.setString(17,prpLsalvationDto.getSalvaItemName());
        dbManager.setString(18,prpLsalvationDto.getSalvaSite());
        dbManager.setString(19,prpLsalvationDto.getSendSite());
        dbManager.setString(20,prpLsalvationDto.getSalvaAssistUnit());
        dbManager.setString(21,prpLsalvationDto.getSalvaUnitHandler());
        dbManager.setString(22,prpLsalvationDto.getSalvaRoute());
        dbManager.setDouble(23,prpLsalvationDto.getSalvaMile());
        dbManager.setString(24,prpLsalvationDto.getInsureUnitCode());
        dbManager.setString(25,prpLsalvationDto.getInsureUnitName());
        dbManager.setString(26,prpLsalvationDto.getFeeStandard());
        dbManager.setDouble(27,prpLsalvationDto.getSalvaFee());
        dbManager.setDateTime(28,prpLsalvationDto.getArriveDate());
        dbManager.setString(29,prpLsalvationDto.getHandlerCode());
        dbManager.setString(30,prpLsalvationDto.getOperatorCode());
        dbManager.setDateTime(31,prpLsalvationDto.getInputDate());
        dbManager.setDateTime(32,prpLsalvationDto.getVerifyDate());
        dbManager.setString(33,prpLsalvationDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLsalvationBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLsalvation (" + 
                           " RegistNo," + 
                           " SerialNo," + 
                           " SalvationNo," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " EngineNo," + 
                           " ColorCode," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " DriverName," + 
                           " Phone," + 
                           " SalvaType," + 
                           " DamageTime," + 
                           " MoneyFlag," + 
                           " SalvaItemCode," + 
                           " SalvaItemName," + 
                           " SalvaSite," + 
                           " SendSite," + 
                           " SalvaAssistUnit," + 
                           " SalvaUnitHandler," + 
                           " SalvaRoute," + 
                           " SalvaMile," + 
                           " InsureUnitCode," + 
                           " InsureUnitName," + 
                           " FeeStandard," + 
                           " SalvaFee," + 
                           " ArriveDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " VerifyDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLsalvationDto prpLsalvationDto = (PrpLsalvationDto)i.next();
            dbManager.setString(1,prpLsalvationDto.getRegistNo());
            dbManager.setInt(2,prpLsalvationDto.getSerialNo());
            dbManager.setString(3,prpLsalvationDto.getSalvationNo());
            dbManager.setString(4,prpLsalvationDto.getPolicyNo());
            dbManager.setString(5,prpLsalvationDto.getLicenseNo());
            dbManager.setString(6,prpLsalvationDto.getLicenseColorCode());
            dbManager.setString(7,prpLsalvationDto.getEngineNo());
            dbManager.setString(8,prpLsalvationDto.getColorCode());
            dbManager.setString(9,prpLsalvationDto.getModelCode());
            dbManager.setString(10,prpLsalvationDto.getBrandName());
            dbManager.setString(11,prpLsalvationDto.getDriverName());
            dbManager.setString(12,prpLsalvationDto.getPhone());
            dbManager.setString(13,prpLsalvationDto.getSalvaType());
            dbManager.setDateTime(14,prpLsalvationDto.getDamageTime());
            dbManager.setString(15,prpLsalvationDto.getMoneyFlag());
            dbManager.setString(16,prpLsalvationDto.getSalvaItemCode());
            dbManager.setString(17,prpLsalvationDto.getSalvaItemName());
            dbManager.setString(18,prpLsalvationDto.getSalvaSite());
            dbManager.setString(19,prpLsalvationDto.getSendSite());
            dbManager.setString(20,prpLsalvationDto.getSalvaAssistUnit());
            dbManager.setString(21,prpLsalvationDto.getSalvaUnitHandler());
            dbManager.setString(22,prpLsalvationDto.getSalvaRoute());
            dbManager.setDouble(23,prpLsalvationDto.getSalvaMile());
            dbManager.setString(24,prpLsalvationDto.getInsureUnitCode());
            dbManager.setString(25,prpLsalvationDto.getInsureUnitName());
            dbManager.setString(26,prpLsalvationDto.getFeeStandard());
            dbManager.setDouble(27,prpLsalvationDto.getSalvaFee());
            dbManager.setDateTime(28,prpLsalvationDto.getArriveDate());
            dbManager.setString(29,prpLsalvationDto.getHandlerCode());
            dbManager.setString(30,prpLsalvationDto.getOperatorCode());
            dbManager.setDateTime(31,prpLsalvationDto.getInputDate());
            dbManager.setDateTime(32,prpLsalvationDto.getVerifyDate());
            dbManager.setString(33,prpLsalvationDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLsalvationBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLsalvation" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLsalvation Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLsalvationBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void update(PrpLsalvationDto prpLsalvationDto) throws Exception{
        String statement = " Update PrpLsalvation Set SalvationNo = ?," + 
                           " PolicyNo = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " EngineNo = ?," + 
                           " ColorCode = ?," + 
                           " ModelCode = ?," + 
                           " BrandName = ?," + 
                           " DriverName = ?," + 
                           " Phone = ?," + 
                           " SalvaType = ?," + 
                           " DamageTime = ?," + 
                           " MoneyFlag = ?," + 
                           " SalvaItemCode = ?," + 
                           " SalvaItemName = ?," + 
                           " SalvaSite = ?," + 
                           " SendSite = ?," + 
                           " SalvaAssistUnit = ?," + 
                           " SalvaUnitHandler = ?," + 
                           " SalvaRoute = ?," + 
                           " SalvaMile = ?," + 
                           " InsureUnitCode = ?," + 
                           " InsureUnitName = ?," + 
                           " FeeStandard = ?," + 
                           " SalvaFee = ?," + 
                           " ArriveDate = ?," + 
                           " HandlerCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " VerifyDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLsalvation Set " + 
                           " RegistNo = '" + prpLsalvationDto.getRegistNo() + "'," + 
                           " SerialNo = " + prpLsalvationDto.getSerialNo() + "," + 
                           " SalvationNo = '" + prpLsalvationDto.getSalvationNo() + "'," + 
                           " PolicyNo = '" + prpLsalvationDto.getPolicyNo() + "'," + 
                           " LicenseNo = '" + prpLsalvationDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLsalvationDto.getLicenseColorCode() + "'," + 
                           " EngineNo = '" + prpLsalvationDto.getEngineNo() + "'," + 
                           " ColorCode = '" + prpLsalvationDto.getColorCode() + "'," + 
                           " ModelCode = '" + prpLsalvationDto.getModelCode() + "'," + 
                           " BrandName = '" + prpLsalvationDto.getBrandName() + "'," + 
                           " DriverName = '" + prpLsalvationDto.getDriverName() + "'," + 
                           " Phone = '" + prpLsalvationDto.getPhone() + "'," + 
                           " SalvaType = '" + prpLsalvationDto.getSalvaType() + "'," + 
                           " DamageTime = '" + prpLsalvationDto.getDamageTime() + "'," + 
                           " MoneyFlag = '" + prpLsalvationDto.getMoneyFlag() + "'," + 
                           " SalvaItemCode = '" + prpLsalvationDto.getSalvaItemCode() + "'," + 
                           " SalvaItemName = '" + prpLsalvationDto.getSalvaItemName() + "'," + 
                           " SalvaSite = '" + prpLsalvationDto.getSalvaSite() + "'," + 
                           " SendSite = '" + prpLsalvationDto.getSendSite() + "'," + 
                           " SalvaAssistUnit = '" + prpLsalvationDto.getSalvaAssistUnit() + "'," + 
                           " SalvaUnitHandler = '" + prpLsalvationDto.getSalvaUnitHandler() + "'," + 
                           " SalvaRoute = '" + prpLsalvationDto.getSalvaRoute() + "'," + 
                           " SalvaMile = '" + prpLsalvationDto.getSalvaMile() + "'," + 
                           " InsureUnitCode = '" + prpLsalvationDto.getInsureUnitCode() + "'," + 
                           " InsureUnitName = '" + prpLsalvationDto.getInsureUnitName() + "'," + 
                           " FeeStandard = '" + prpLsalvationDto.getFeeStandard() + "'," + 
                           " SalvaFee = '" + prpLsalvationDto.getSalvaFee() + "'," + 
                           " ArriveDate = '" + prpLsalvationDto.getArriveDate() + "'," + 
                           " HandlerCode = '" + prpLsalvationDto.getHandlerCode() + "'," + 
                           " OperatorCode = '" + prpLsalvationDto.getOperatorCode() + "'," + 
                           " InputDate = '" + prpLsalvationDto.getInputDate() + "'," + 
                           " VerifyDate = '" + prpLsalvationDto.getVerifyDate() + "'," + 
                           " Flag = '" + prpLsalvationDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLsalvationDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLsalvationDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLsalvationDto.getSalvationNo());
        dbManager.setString(2,prpLsalvationDto.getPolicyNo());
        dbManager.setString(3,prpLsalvationDto.getLicenseNo());
        dbManager.setString(4,prpLsalvationDto.getLicenseColorCode());
        dbManager.setString(5,prpLsalvationDto.getEngineNo());
        dbManager.setString(6,prpLsalvationDto.getColorCode());
        dbManager.setString(7,prpLsalvationDto.getModelCode());
        dbManager.setString(8,prpLsalvationDto.getBrandName());
        dbManager.setString(9,prpLsalvationDto.getDriverName());
        dbManager.setString(10,prpLsalvationDto.getPhone());
        dbManager.setString(11,prpLsalvationDto.getSalvaType());
        dbManager.setDateTime(12,prpLsalvationDto.getDamageTime());
        dbManager.setString(13,prpLsalvationDto.getMoneyFlag());
        dbManager.setString(14,prpLsalvationDto.getSalvaItemCode());
        dbManager.setString(15,prpLsalvationDto.getSalvaItemName());
        dbManager.setString(16,prpLsalvationDto.getSalvaSite());
        dbManager.setString(17,prpLsalvationDto.getSendSite());
        dbManager.setString(18,prpLsalvationDto.getSalvaAssistUnit());
        dbManager.setString(19,prpLsalvationDto.getSalvaUnitHandler());
        dbManager.setString(20,prpLsalvationDto.getSalvaRoute());
        dbManager.setDouble(21,prpLsalvationDto.getSalvaMile());
        dbManager.setString(22,prpLsalvationDto.getInsureUnitCode());
        dbManager.setString(23,prpLsalvationDto.getInsureUnitName());
        dbManager.setString(24,prpLsalvationDto.getFeeStandard());
        dbManager.setDouble(25,prpLsalvationDto.getSalvaFee());
        dbManager.setDateTime(26,prpLsalvationDto.getArriveDate());
        dbManager.setString(27,prpLsalvationDto.getHandlerCode());
        dbManager.setString(28,prpLsalvationDto.getOperatorCode());
        dbManager.setDateTime(29,prpLsalvationDto.getInputDate());
        dbManager.setDateTime(30,prpLsalvationDto.getVerifyDate());
        dbManager.setString(31,prpLsalvationDto.getFlag());
        //设置条件字段;
        dbManager.setString(32,prpLsalvationDto.getRegistNo());
        dbManager.setInt(33,prpLsalvationDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLsalvationBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @return PrpLsalvationDto
     * @throws Exception
     */
    public PrpLsalvationDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " SerialNo," + 
                           " SalvationNo," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " EngineNo," + 
                           " ColorCode," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " DriverName," + 
                           " Phone," + 
                           " SalvaType," + 
                           " DamageTime," + 
                           " MoneyFlag," + 
                           " SalvaItemCode," + 
                           " SalvaItemName," + 
                           " SalvaSite," + 
                           " SendSite," + 
                           " SalvaAssistUnit," + 
                           " SalvaUnitHandler," + 
                           " SalvaRoute," + 
                           " SalvaMile," + 
                           " InsureUnitCode," + 
                           " InsureUnitName," + 
                           " FeeStandard," + 
                           " SalvaFee," + 
                           " ArriveDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " VerifyDate," + 
                           " Flag From PrpLsalvation";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLsalvationDto prpLsalvationDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLsalvationDto = new PrpLsalvationDto();
            prpLsalvationDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLsalvationDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLsalvationDto.setSalvationNo(dbManager.getString(resultSet,3));
            prpLsalvationDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLsalvationDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLsalvationDto.setLicenseColorCode(dbManager.getString(resultSet,6));
            prpLsalvationDto.setEngineNo(dbManager.getString(resultSet,7));
            prpLsalvationDto.setColorCode(dbManager.getString(resultSet,8));
            prpLsalvationDto.setModelCode(dbManager.getString(resultSet,9));
            prpLsalvationDto.setBrandName(dbManager.getString(resultSet,10));
            prpLsalvationDto.setDriverName(dbManager.getString(resultSet,11));
            prpLsalvationDto.setPhone(dbManager.getString(resultSet,12));
            prpLsalvationDto.setSalvaType(dbManager.getString(resultSet,13));
            prpLsalvationDto.setDamageTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLsalvationDto.setMoneyFlag(dbManager.getString(resultSet,15));
            prpLsalvationDto.setSalvaItemCode(dbManager.getString(resultSet,16));
            prpLsalvationDto.setSalvaItemName(dbManager.getString(resultSet,17));
            prpLsalvationDto.setSalvaSite(dbManager.getString(resultSet,18));
            prpLsalvationDto.setSendSite(dbManager.getString(resultSet,19));
            prpLsalvationDto.setSalvaAssistUnit(dbManager.getString(resultSet,20));
            prpLsalvationDto.setSalvaUnitHandler(dbManager.getString(resultSet,21));
            prpLsalvationDto.setSalvaRoute(dbManager.getString(resultSet,22));
            prpLsalvationDto.setSalvaMile(dbManager.getDouble(resultSet,23));
            prpLsalvationDto.setInsureUnitCode(dbManager.getString(resultSet,24));
            prpLsalvationDto.setInsureUnitName(dbManager.getString(resultSet,25));
            prpLsalvationDto.setFeeStandard(dbManager.getString(resultSet,26));
            prpLsalvationDto.setSalvaFee(dbManager.getDouble(resultSet,27));
            prpLsalvationDto.setArriveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpLsalvationDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLsalvationDto.setOperatorCode(dbManager.getString(resultSet,30));
            prpLsalvationDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            prpLsalvationDto.setVerifyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            prpLsalvationDto.setFlag(dbManager.getString(resultSet,33));
            logger.info("DBPrpLsalvationBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLsalvationBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLsalvationDto;
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
                           " SerialNo," + 
                           " SalvationNo," + 
                           " PolicyNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " EngineNo," + 
                           " ColorCode," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " DriverName," + 
                           " Phone," + 
                           " SalvaType," + 
                           " DamageTime," + 
                           " MoneyFlag," + 
                           " SalvaItemCode," + 
                           " SalvaItemName," + 
                           " SalvaSite," + 
                           " SendSite," + 
                           " SalvaAssistUnit," + 
                           " SalvaUnitHandler," + 
                           " SalvaRoute," + 
                           " SalvaMile," + 
                           " InsureUnitCode," + 
                           " InsureUnitName," + 
                           " FeeStandard," + 
                           " SalvaFee," + 
                           " ArriveDate," + 
                           " HandlerCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " VerifyDate," + 
                           " Flag From PrpLsalvation Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLsalvationDto prpLsalvationDto = null;
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

            prpLsalvationDto = new PrpLsalvationDto();
            prpLsalvationDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLsalvationDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLsalvationDto.setSalvationNo(dbManager.getString(resultSet,3));
            prpLsalvationDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLsalvationDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLsalvationDto.setLicenseColorCode(dbManager.getString(resultSet,6));
            prpLsalvationDto.setEngineNo(dbManager.getString(resultSet,7));
            prpLsalvationDto.setColorCode(dbManager.getString(resultSet,8));
            prpLsalvationDto.setModelCode(dbManager.getString(resultSet,9));
            prpLsalvationDto.setBrandName(dbManager.getString(resultSet,10));
            prpLsalvationDto.setDriverName(dbManager.getString(resultSet,11));
            prpLsalvationDto.setPhone(dbManager.getString(resultSet,12));
            prpLsalvationDto.setSalvaType(dbManager.getString(resultSet,13));
            prpLsalvationDto.setDamageTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLsalvationDto.setMoneyFlag(dbManager.getString(resultSet,15));
            prpLsalvationDto.setSalvaItemCode(dbManager.getString(resultSet,16));
            prpLsalvationDto.setSalvaItemName(dbManager.getString(resultSet,17));
            prpLsalvationDto.setSalvaSite(dbManager.getString(resultSet,18));
            prpLsalvationDto.setSendSite(dbManager.getString(resultSet,19));
            prpLsalvationDto.setSalvaAssistUnit(dbManager.getString(resultSet,20));
            prpLsalvationDto.setSalvaUnitHandler(dbManager.getString(resultSet,21));
            prpLsalvationDto.setSalvaRoute(dbManager.getString(resultSet,22));
            prpLsalvationDto.setSalvaMile(dbManager.getDouble(resultSet,23));
            prpLsalvationDto.setInsureUnitCode(dbManager.getString(resultSet,24));
            prpLsalvationDto.setInsureUnitName(dbManager.getString(resultSet,25));
            prpLsalvationDto.setFeeStandard(dbManager.getString(resultSet,26));
            prpLsalvationDto.setSalvaFee(dbManager.getDouble(resultSet,27));
            prpLsalvationDto.setArriveDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,28));
            prpLsalvationDto.setHandlerCode(dbManager.getString(resultSet,29));
            prpLsalvationDto.setOperatorCode(dbManager.getString(resultSet,30));
            prpLsalvationDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            prpLsalvationDto.setVerifyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            prpLsalvationDto.setFlag(dbManager.getString(resultSet,33));
            collection.add(prpLsalvationDto);
        }
        resultSet.close();
        logger.info("DBPrpLsalvationBase.findByConditions() success!");
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
        String statement = "Delete From PrpLsalvation Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLsalvationBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLsalvation Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLsalvationBase.getCount() success!");
        return count;
    }
}
