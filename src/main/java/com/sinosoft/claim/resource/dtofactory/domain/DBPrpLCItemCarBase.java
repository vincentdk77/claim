package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCItemCarDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCItemCar-代赔保单车辆附表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLCItemCarBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLCItemCarBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLCItemCarBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void insert(PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        String mainStatement = " Insert Into PrpLCItemCar (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " CarInsuredRelation," + 
                           " CarOwner," + 
                           " ClauseType," + 
                           " AgreeDriverFlag," + 
                           " NewDeviceFlag," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " HKFlag," + 
                           " HKLicenseNo," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " RunAreaCode," + 
                           " RunAreaName," + 
                           " RunMiles," + 
                           " EnrollDate," + 
                           " UseYears," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " ExhaustScale," + 
                           " ColorCode," + 
                           " SafeDevice," + 
                           " OtherNature," + 
                           " RateCode," + 
                           " ParkSite," + 
                           " PurchasePrice," + 
                           " CarLoanFlag," + 
                           " Currency," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLCItemCarDto.getClaimNo() + "'," + 
                           "'" + prpLCItemCarDto.getRegistNo() + "'," + 
                           "'" + prpLCItemCarDto.getPolicyNo() + "'," + 
                           "'" + prpLCItemCarDto.getRiskCode() + "'," + 
                           "'" + prpLCItemCarDto.getCarInsuredRelation() + "'," + 
                           "'" + prpLCItemCarDto.getCarOwner() + "'," + 
                           "'" + prpLCItemCarDto.getClauseType() + "'," + 
                           "'" + prpLCItemCarDto.getAgreeDriverFlag() + "'," + 
                           "'" + prpLCItemCarDto.getNewDeviceFlag() + "'," + 
                           "'" + prpLCItemCarDto.getLicenseNo() + "'," + 
                           "'" + prpLCItemCarDto.getLicenseColorCode() + "'," + 
                           "'" + prpLCItemCarDto.getCarKindCode() + "'," + 
                           "'" + prpLCItemCarDto.getHKFlag() + "'," + 
                           "'" + prpLCItemCarDto.getHKLicenseNo() + "'," + 
                           "'" + prpLCItemCarDto.getEngineNo() + "'," + 
                           "'" + prpLCItemCarDto.getVINNo() + "'," + 
                           "'" + prpLCItemCarDto.getFrameNo() + "'," + 
                           "'" + prpLCItemCarDto.getRunAreaCode() + "'," + 
                           "'" + prpLCItemCarDto.getRunAreaName() + "'," + 
                           "'" + prpLCItemCarDto.getRunMiles() + "'," + 
                           "'" + prpLCItemCarDto.getEnrollDate() + "'," + 
                           "" + prpLCItemCarDto.getUseYears() + "," + 
                           "'" + prpLCItemCarDto.getBrandName() + "'," + 
                           "'" + prpLCItemCarDto.getUseNatureCode() + "'," + 
                           "" + prpLCItemCarDto.getSeatCount() + "," + 
                           "'" + prpLCItemCarDto.getTonCount() + "'," + 
                           "'" + prpLCItemCarDto.getExhaustScale() + "'," + 
                           "'" + prpLCItemCarDto.getColorCode() + "'," + 
                           "'" + prpLCItemCarDto.getSafeDevice() + "'," + 
                           "'" + prpLCItemCarDto.getOtherNature() + "'," + 
                           "'" + prpLCItemCarDto.getRateCode() + "'," + 
                           "'" + prpLCItemCarDto.getParkSite() + "'," + 
                           "'" + prpLCItemCarDto.getPurchasePrice() + "'," + 
                           "'" + prpLCItemCarDto.getCarLoanFlag() + "'," + 
                           "'" + prpLCItemCarDto.getCurrency() + "'," + 
                           "'" + prpLCItemCarDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLCItemCarDto.getClaimNo());
        dbManager.setString(2,prpLCItemCarDto.getRegistNo());
        dbManager.setString(3,prpLCItemCarDto.getPolicyNo());
        dbManager.setString(4,prpLCItemCarDto.getRiskCode());
        dbManager.setString(5,prpLCItemCarDto.getCarInsuredRelation());
        dbManager.setString(6,prpLCItemCarDto.getCarOwner());
        dbManager.setString(7,prpLCItemCarDto.getClauseType());
        dbManager.setString(8,prpLCItemCarDto.getAgreeDriverFlag());
        dbManager.setString(9,prpLCItemCarDto.getNewDeviceFlag());
        dbManager.setString(10,prpLCItemCarDto.getLicenseNo());
        dbManager.setString(11,prpLCItemCarDto.getLicenseColorCode());
        dbManager.setString(12,prpLCItemCarDto.getCarKindCode());
        dbManager.setString(13,prpLCItemCarDto.getHKFlag());
        dbManager.setString(14,prpLCItemCarDto.getHKLicenseNo());
        dbManager.setString(15,prpLCItemCarDto.getEngineNo());
        dbManager.setString(16,prpLCItemCarDto.getVINNo());
        dbManager.setString(17,prpLCItemCarDto.getFrameNo());
        dbManager.setString(18,prpLCItemCarDto.getRunAreaCode());
        dbManager.setString(19,prpLCItemCarDto.getRunAreaName());
        dbManager.setDouble(20,prpLCItemCarDto.getRunMiles());
        dbManager.setDateTime(21,prpLCItemCarDto.getEnrollDate());
        dbManager.setInt(22,prpLCItemCarDto.getUseYears());
        dbManager.setString(23,prpLCItemCarDto.getBrandName());
        dbManager.setString(24,prpLCItemCarDto.getUseNatureCode());
        dbManager.setInt(25,prpLCItemCarDto.getSeatCount());
        dbManager.setDouble(26,prpLCItemCarDto.getTonCount());
        dbManager.setDouble(27,prpLCItemCarDto.getExhaustScale());
        dbManager.setString(28,prpLCItemCarDto.getColorCode());
        dbManager.setString(29,prpLCItemCarDto.getSafeDevice());
        dbManager.setString(30,prpLCItemCarDto.getOtherNature());
        dbManager.setString(31,prpLCItemCarDto.getRateCode());
        dbManager.setString(32,prpLCItemCarDto.getParkSite());
        dbManager.setDouble(33,prpLCItemCarDto.getPurchasePrice());
        dbManager.setString(34,prpLCItemCarDto.getCarLoanFlag());
        dbManager.setString(35,prpLCItemCarDto.getCurrency());
        dbManager.setString(36,prpLCItemCarDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCItemCarBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLCItemCar (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " CarInsuredRelation," + 
                           " CarOwner," + 
                           " ClauseType," + 
                           " AgreeDriverFlag," + 
                           " NewDeviceFlag," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " HKFlag," + 
                           " HKLicenseNo," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " RunAreaCode," + 
                           " RunAreaName," + 
                           " RunMiles," + 
                           " EnrollDate," + 
                           " UseYears," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " ExhaustScale," + 
                           " ColorCode," + 
                           " SafeDevice," + 
                           " OtherNature," + 
                           " RateCode," + 
                           " ParkSite," + 
                           " PurchasePrice," + 
                           " CarLoanFlag," + 
                           " Currency," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLCItemCarDto prpLCItemCarDto = (PrpLCItemCarDto)i.next();
            dbManager.setString(1,prpLCItemCarDto.getClaimNo());
            dbManager.setString(2,prpLCItemCarDto.getRegistNo());
            dbManager.setString(3,prpLCItemCarDto.getPolicyNo());
            dbManager.setString(4,prpLCItemCarDto.getRiskCode());
            dbManager.setString(5,prpLCItemCarDto.getCarInsuredRelation());
            dbManager.setString(6,prpLCItemCarDto.getCarOwner());
            dbManager.setString(7,prpLCItemCarDto.getClauseType());
            dbManager.setString(8,prpLCItemCarDto.getAgreeDriverFlag());
            dbManager.setString(9,prpLCItemCarDto.getNewDeviceFlag());
            dbManager.setString(10,prpLCItemCarDto.getLicenseNo());
            dbManager.setString(11,prpLCItemCarDto.getLicenseColorCode());
            dbManager.setString(12,prpLCItemCarDto.getCarKindCode());
            dbManager.setString(13,prpLCItemCarDto.getHKFlag());
            dbManager.setString(14,prpLCItemCarDto.getHKLicenseNo());
            dbManager.setString(15,prpLCItemCarDto.getEngineNo());
            dbManager.setString(16,prpLCItemCarDto.getVINNo());
            dbManager.setString(17,prpLCItemCarDto.getFrameNo());
            dbManager.setString(18,prpLCItemCarDto.getRunAreaCode());
            dbManager.setString(19,prpLCItemCarDto.getRunAreaName());
            dbManager.setDouble(20,prpLCItemCarDto.getRunMiles());
            dbManager.setDateTime(21,prpLCItemCarDto.getEnrollDate());
            dbManager.setInt(22,prpLCItemCarDto.getUseYears());
            dbManager.setString(23,prpLCItemCarDto.getBrandName());
            dbManager.setString(24,prpLCItemCarDto.getUseNatureCode());
            dbManager.setInt(25,prpLCItemCarDto.getSeatCount());
            dbManager.setDouble(26,prpLCItemCarDto.getTonCount());
            dbManager.setDouble(27,prpLCItemCarDto.getExhaustScale());
            dbManager.setString(28,prpLCItemCarDto.getColorCode());
            dbManager.setString(29,prpLCItemCarDto.getSafeDevice());
            dbManager.setString(30,prpLCItemCarDto.getOtherNature());
            dbManager.setString(31,prpLCItemCarDto.getRateCode());
            dbManager.setString(32,prpLCItemCarDto.getParkSite());
            dbManager.setDouble(33,prpLCItemCarDto.getPurchasePrice());
            dbManager.setString(34,prpLCItemCarDto.getCarLoanFlag());
            dbManager.setString(35,prpLCItemCarDto.getCurrency());
            dbManager.setString(36,prpLCItemCarDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLCItemCarBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(String registNo,String policyNo) throws Exception{
        String statement = " Delete From PrpLCItemCar" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLCItemCar Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLCItemCarBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLCItemCarDto prpLCItemCarDto
     * @throws Exception
     */
    public void update(PrpLCItemCarDto prpLCItemCarDto) throws Exception{
        String statement = " Update PrpLCItemCar Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " CarInsuredRelation = ?," + 
                           " CarOwner = ?," + 
                           " ClauseType = ?," + 
                           " AgreeDriverFlag = ?," + 
                           " NewDeviceFlag = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " CarKindCode = ?," + 
                           " HKFlag = ?," + 
                           " HKLicenseNo = ?," + 
                           " EngineNo = ?," + 
                           " VINNo = ?," + 
                           " FrameNo = ?," + 
                           " RunAreaCode = ?," + 
                           " RunAreaName = ?," + 
                           " RunMiles = ?," + 
                           " EnrollDate = ?," + 
                           " UseYears = ?," + 
                           " BrandName = ?," + 
                           " UseNatureCode = ?," + 
                           " SeatCount = ?," + 
                           " TonCount = ?," + 
                           " ExhaustScale = ?," + 
                           " ColorCode = ?," + 
                           " SafeDevice = ?," + 
                           " OtherNature = ?," + 
                           " RateCode = ?," + 
                           " ParkSite = ?," + 
                           " PurchasePrice = ?," + 
                           " CarLoanFlag = ?," + 
                           " Currency = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLCItemCar Set " + 
                           " ClaimNo = '" + prpLCItemCarDto.getClaimNo() + "'," + 
                           " RegistNo = '" + prpLCItemCarDto.getRegistNo() + "'," + 
                           " PolicyNo = '" + prpLCItemCarDto.getPolicyNo() + "'," + 
                           " RiskCode = '" + prpLCItemCarDto.getRiskCode() + "'," + 
                           " CarInsuredRelation = '" + prpLCItemCarDto.getCarInsuredRelation() + "'," + 
                           " CarOwner = '" + prpLCItemCarDto.getCarOwner() + "'," + 
                           " ClauseType = '" + prpLCItemCarDto.getClauseType() + "'," + 
                           " AgreeDriverFlag = '" + prpLCItemCarDto.getAgreeDriverFlag() + "'," + 
                           " NewDeviceFlag = '" + prpLCItemCarDto.getNewDeviceFlag() + "'," + 
                           " LicenseNo = '" + prpLCItemCarDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLCItemCarDto.getLicenseColorCode() + "'," + 
                           " CarKindCode = '" + prpLCItemCarDto.getCarKindCode() + "'," + 
                           " HKFlag = '" + prpLCItemCarDto.getHKFlag() + "'," + 
                           " HKLicenseNo = '" + prpLCItemCarDto.getHKLicenseNo() + "'," + 
                           " EngineNo = '" + prpLCItemCarDto.getEngineNo() + "'," + 
                           " VINNo = '" + prpLCItemCarDto.getVINNo() + "'," + 
                           " FrameNo = '" + prpLCItemCarDto.getFrameNo() + "'," + 
                           " RunAreaCode = '" + prpLCItemCarDto.getRunAreaCode() + "'," + 
                           " RunAreaName = '" + prpLCItemCarDto.getRunAreaName() + "'," + 
                           " RunMiles = '" + prpLCItemCarDto.getRunMiles() + "'," + 
                           " EnrollDate = '" + prpLCItemCarDto.getEnrollDate() + "'," + 
                           " UseYears = " + prpLCItemCarDto.getUseYears() + "," + 
                           " BrandName = '" + prpLCItemCarDto.getBrandName() + "'," + 
                           " UseNatureCode = '" + prpLCItemCarDto.getUseNatureCode() + "'," + 
                           " SeatCount = " + prpLCItemCarDto.getSeatCount() + "," + 
                           " TonCount = '" + prpLCItemCarDto.getTonCount() + "'," + 
                           " ExhaustScale = '" + prpLCItemCarDto.getExhaustScale() + "'," + 
                           " ColorCode = '" + prpLCItemCarDto.getColorCode() + "'," + 
                           " SafeDevice = '" + prpLCItemCarDto.getSafeDevice() + "'," + 
                           " OtherNature = '" + prpLCItemCarDto.getOtherNature() + "'," + 
                           " RateCode = '" + prpLCItemCarDto.getRateCode() + "'," + 
                           " ParkSite = '" + prpLCItemCarDto.getParkSite() + "'," + 
                           " PurchasePrice = '" + prpLCItemCarDto.getPurchasePrice() + "'," + 
                           " CarLoanFlag = '" + prpLCItemCarDto.getCarLoanFlag() + "'," + 
                           " Currency = '" + prpLCItemCarDto.getCurrency() + "'," + 
                           " Flag = '" + prpLCItemCarDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLCItemCarDto.getRegistNo() + "' And " + 
                           " PolicyNo = '" + prpLCItemCarDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLCItemCarDto.getClaimNo());
        dbManager.setString(2,prpLCItemCarDto.getRiskCode());
        dbManager.setString(3,prpLCItemCarDto.getCarInsuredRelation());
        dbManager.setString(4,prpLCItemCarDto.getCarOwner());
        dbManager.setString(5,prpLCItemCarDto.getClauseType());
        dbManager.setString(6,prpLCItemCarDto.getAgreeDriverFlag());
        dbManager.setString(7,prpLCItemCarDto.getNewDeviceFlag());
        dbManager.setString(8,prpLCItemCarDto.getLicenseNo());
        dbManager.setString(9,prpLCItemCarDto.getLicenseColorCode());
        dbManager.setString(10,prpLCItemCarDto.getCarKindCode());
        dbManager.setString(11,prpLCItemCarDto.getHKFlag());
        dbManager.setString(12,prpLCItemCarDto.getHKLicenseNo());
        dbManager.setString(13,prpLCItemCarDto.getEngineNo());
        dbManager.setString(14,prpLCItemCarDto.getVINNo());
        dbManager.setString(15,prpLCItemCarDto.getFrameNo());
        dbManager.setString(16,prpLCItemCarDto.getRunAreaCode());
        dbManager.setString(17,prpLCItemCarDto.getRunAreaName());
        dbManager.setDouble(18,prpLCItemCarDto.getRunMiles());
        dbManager.setDateTime(19,prpLCItemCarDto.getEnrollDate());
        dbManager.setInt(20,prpLCItemCarDto.getUseYears());
        dbManager.setString(21,prpLCItemCarDto.getBrandName());
        dbManager.setString(22,prpLCItemCarDto.getUseNatureCode());
        dbManager.setInt(23,prpLCItemCarDto.getSeatCount());
        dbManager.setDouble(24,prpLCItemCarDto.getTonCount());
        dbManager.setDouble(25,prpLCItemCarDto.getExhaustScale());
        dbManager.setString(26,prpLCItemCarDto.getColorCode());
        dbManager.setString(27,prpLCItemCarDto.getSafeDevice());
        dbManager.setString(28,prpLCItemCarDto.getOtherNature());
        dbManager.setString(29,prpLCItemCarDto.getRateCode());
        dbManager.setString(30,prpLCItemCarDto.getParkSite());
        dbManager.setDouble(31,prpLCItemCarDto.getPurchasePrice());
        dbManager.setString(32,prpLCItemCarDto.getCarLoanFlag());
        dbManager.setString(33,prpLCItemCarDto.getCurrency());
        dbManager.setString(34,prpLCItemCarDto.getFlag());
        //设置条件字段;
        dbManager.setString(35,prpLCItemCarDto.getRegistNo());
        dbManager.setString(36,prpLCItemCarDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCItemCarBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @return PrpLCItemCarDto
     * @throws Exception
     */
    public PrpLCItemCarDto findByPrimaryKey(String registNo,String policyNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " CarInsuredRelation," + 
                           " CarOwner," + 
                           " ClauseType," + 
                           " AgreeDriverFlag," + 
                           " NewDeviceFlag," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " HKFlag," + 
                           " HKLicenseNo," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " RunAreaCode," + 
                           " RunAreaName," + 
                           " RunMiles," + 
                           " EnrollDate," + 
                           " UseYears," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " ExhaustScale," + 
                           " ColorCode," + 
                           " SafeDevice," + 
                           " OtherNature," + 
                           " RateCode," + 
                           " ParkSite," + 
                           " PurchasePrice," + 
                           " CarLoanFlag," + 
                           " Currency," + 
                           " Flag From PrpLCItemCar";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        PrpLCItemCarDto prpLCItemCarDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLCItemCarDto = new PrpLCItemCarDto();
            prpLCItemCarDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCItemCarDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCItemCarDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCItemCarDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLCItemCarDto.setCarInsuredRelation(dbManager.getString(resultSet,5));
            prpLCItemCarDto.setCarOwner(dbManager.getString(resultSet,6));
            prpLCItemCarDto.setClauseType(dbManager.getString(resultSet,7));
            prpLCItemCarDto.setAgreeDriverFlag(dbManager.getString(resultSet,8));
            prpLCItemCarDto.setNewDeviceFlag(dbManager.getString(resultSet,9));
            prpLCItemCarDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLCItemCarDto.setLicenseColorCode(dbManager.getString(resultSet,11));
            prpLCItemCarDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLCItemCarDto.setHKFlag(dbManager.getString(resultSet,13));
            prpLCItemCarDto.setHKLicenseNo(dbManager.getString(resultSet,14));
            prpLCItemCarDto.setEngineNo(dbManager.getString(resultSet,15));
            prpLCItemCarDto.setVINNo(dbManager.getString(resultSet,16));
            prpLCItemCarDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLCItemCarDto.setRunAreaCode(dbManager.getString(resultSet,18));
            prpLCItemCarDto.setRunAreaName(dbManager.getString(resultSet,19));
            prpLCItemCarDto.setRunMiles(dbManager.getDouble(resultSet,20));
            prpLCItemCarDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLCItemCarDto.setUseYears(dbManager.getInt(resultSet,22));
            prpLCItemCarDto.setBrandName(dbManager.getString(resultSet,23));
            prpLCItemCarDto.setUseNatureCode(dbManager.getString(resultSet,24));
            prpLCItemCarDto.setSeatCount(dbManager.getInt(resultSet,25));
            prpLCItemCarDto.setTonCount(dbManager.getDouble(resultSet,26));
            prpLCItemCarDto.setExhaustScale(dbManager.getDouble(resultSet,27));
            prpLCItemCarDto.setColorCode(dbManager.getString(resultSet,28));
            prpLCItemCarDto.setSafeDevice(dbManager.getString(resultSet,29));
            prpLCItemCarDto.setOtherNature(dbManager.getString(resultSet,30));
            prpLCItemCarDto.setRateCode(dbManager.getString(resultSet,31));
            prpLCItemCarDto.setParkSite(dbManager.getString(resultSet,32));
            prpLCItemCarDto.setPurchasePrice(dbManager.getDouble(resultSet,33));
            prpLCItemCarDto.setCarLoanFlag(dbManager.getString(resultSet,34));
            prpLCItemCarDto.setCurrency(dbManager.getString(resultSet,35));
            prpLCItemCarDto.setFlag(dbManager.getString(resultSet,36));
            logger.info("DBPrpLCItemCarBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLCItemCarBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLCItemCarDto;
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
        String statement = "Select ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " CarInsuredRelation," + 
                           " CarOwner," + 
                           " ClauseType," + 
                           " AgreeDriverFlag," + 
                           " NewDeviceFlag," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " HKFlag," + 
                           " HKLicenseNo," + 
                           " EngineNo," + 
                           " VINNo," + 
                           " FrameNo," + 
                           " RunAreaCode," + 
                           " RunAreaName," + 
                           " RunMiles," + 
                           " EnrollDate," + 
                           " UseYears," + 
                           " BrandName," + 
                           " UseNatureCode," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " ExhaustScale," + 
                           " ColorCode," + 
                           " SafeDevice," + 
                           " OtherNature," + 
                           " RateCode," + 
                           " ParkSite," + 
                           " PurchasePrice," + 
                           " CarLoanFlag," + 
                           " Currency," + 
                           " Flag From PrpLCItemCar Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLCItemCarDto prpLCItemCarDto = null;
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

            prpLCItemCarDto = new PrpLCItemCarDto();
            prpLCItemCarDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCItemCarDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCItemCarDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCItemCarDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLCItemCarDto.setCarInsuredRelation(dbManager.getString(resultSet,5));
            prpLCItemCarDto.setCarOwner(dbManager.getString(resultSet,6));
            prpLCItemCarDto.setClauseType(dbManager.getString(resultSet,7));
            prpLCItemCarDto.setAgreeDriverFlag(dbManager.getString(resultSet,8));
            prpLCItemCarDto.setNewDeviceFlag(dbManager.getString(resultSet,9));
            prpLCItemCarDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLCItemCarDto.setLicenseColorCode(dbManager.getString(resultSet,11));
            prpLCItemCarDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLCItemCarDto.setHKFlag(dbManager.getString(resultSet,13));
            prpLCItemCarDto.setHKLicenseNo(dbManager.getString(resultSet,14));
            prpLCItemCarDto.setEngineNo(dbManager.getString(resultSet,15));
            prpLCItemCarDto.setVINNo(dbManager.getString(resultSet,16));
            prpLCItemCarDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLCItemCarDto.setRunAreaCode(dbManager.getString(resultSet,18));
            prpLCItemCarDto.setRunAreaName(dbManager.getString(resultSet,19));
            prpLCItemCarDto.setRunMiles(dbManager.getDouble(resultSet,20));
            prpLCItemCarDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpLCItemCarDto.setUseYears(dbManager.getInt(resultSet,22));
            prpLCItemCarDto.setBrandName(dbManager.getString(resultSet,23));
            prpLCItemCarDto.setUseNatureCode(dbManager.getString(resultSet,24));
            prpLCItemCarDto.setSeatCount(dbManager.getInt(resultSet,25));
            prpLCItemCarDto.setTonCount(dbManager.getDouble(resultSet,26));
            prpLCItemCarDto.setExhaustScale(dbManager.getDouble(resultSet,27));
            prpLCItemCarDto.setColorCode(dbManager.getString(resultSet,28));
            prpLCItemCarDto.setSafeDevice(dbManager.getString(resultSet,29));
            prpLCItemCarDto.setOtherNature(dbManager.getString(resultSet,30));
            prpLCItemCarDto.setRateCode(dbManager.getString(resultSet,31));
            prpLCItemCarDto.setParkSite(dbManager.getString(resultSet,32));
            prpLCItemCarDto.setPurchasePrice(dbManager.getDouble(resultSet,33));
            prpLCItemCarDto.setCarLoanFlag(dbManager.getString(resultSet,34));
            prpLCItemCarDto.setCurrency(dbManager.getString(resultSet,35));
            prpLCItemCarDto.setFlag(dbManager.getString(resultSet,36));
            collection.add(prpLCItemCarDto);
        }
        resultSet.close();
        logger.info("DBPrpLCItemCarBase.findByConditions() success!");
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
        String statement = "Delete From PrpLCItemCar Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLCItemCarBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLCItemCar Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLCItemCarBase.getCount() success!");
        return count;
    }
}
