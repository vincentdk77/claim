package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemCarDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppitem_car机动车险标的信息的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:17.937<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPitemCarBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPitemCarBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPitemCarBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPitem_carDto prpPitem_carDto
     * @throws Exception
     */
    public void insert(PrpPitemCarDto prpPitem_carDto) throws Exception{
        String mainStatement = " Insert Into PrpPitemcar (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemNo," +
                           " InsuredTypeCode," +
                           " CarInsuredRelation," +
                           " CarOwner," +
                           " ClauseType," +
                           " AgreeDriverFlag," +
                           " NewDeviceFlag," +
                           " CarPolicyno," +
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
                           " ModelCode," +
                           " BrandName," +
                           " CountryNature," +
                           " CountryCode," +
                           " UseNatureCode," +
                           " BusinessClassCode," +
                           " SeatCount," +
                           " TonCount," +
                           " ExhaustScale," +
                           " ColorCode," +
                           " SafeDevice," +
                           " ParkSite," +
                           " OwnerAddress," +
                           " OtherNature," +
                           " RateCode," +
                           " MakeDate," +
                           " CarUsage," +
                           " Currency," +
                           " PurchasePrice," +
                           " ActualValue," +
                           " InvoiceNo," +
                           " CarLoanFlag," +
                           " InsurerCode," +
                           " LastInsurer," +
                           " CarCheckStatus," +
                           " CarChecker," +
                           " CarCheckTime," +
                           " SpecialTreat," +
                           " RelievingAreaCode," +
                           " AddonCount," +
                           " CarDealerCode," +
                           " CarDealerName," +
                           " Remark," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPitem_carDto.getEndorseNo() + "'," +
                           "'" + prpPitem_carDto.getPolicyNo() + "'," +
                           "'" + prpPitem_carDto.getRiskCode() + "'," +
                           "" + prpPitem_carDto.getItemNo() + "," +
                           "'" + prpPitem_carDto.getInsuredTypeCode() + "'," +
                           "'" + prpPitem_carDto.getCarInsuredRelation() + "'," +
                           "'" + prpPitem_carDto.getCarOwner() + "'," +
                           "'" + prpPitem_carDto.getClauseType() + "'," +
                           "'" + prpPitem_carDto.getAgreeDriverFlag() + "'," +
                           "'" + prpPitem_carDto.getNewDeviceFlag() + "'," +
                           "'" + prpPitem_carDto.getCarPolicyno() + "'," +
                           "'" + prpPitem_carDto.getLicenseNo() + "'," +
                           "'" + prpPitem_carDto.getLicenseColorCode() + "'," +
                           "'" + prpPitem_carDto.getCarKindCode() + "'," +
                           "'" + prpPitem_carDto.getHKFlag() + "'," +
                           "'" + prpPitem_carDto.getHKLicenseNo() + "'," +
                           "'" + prpPitem_carDto.getEngineNo() + "'," +
                           "'" + prpPitem_carDto.getVINNo() + "'," +
                           "'" + prpPitem_carDto.getFrameNo() + "'," +
                           "'" + prpPitem_carDto.getRunAreaCode() + "'," +
                           "'" + prpPitem_carDto.getRunAreaName() + "'," +
                           "'" + prpPitem_carDto.getRunMiles() + "'," +
                           "'" + prpPitem_carDto.getEnrollDate() + "'," +
                           "" + prpPitem_carDto.getUseYears() + "," +
                           "'" + prpPitem_carDto.getModelCode() + "'," +
                           "'" + prpPitem_carDto.getBrandName() + "'," +
                           "'" + prpPitem_carDto.getCountryNature() + "'," +
                           "'" + prpPitem_carDto.getCountryCode() + "'," +
                           "'" + prpPitem_carDto.getUseNatureCode() + "'," +
                           "'" + prpPitem_carDto.getBusinessClassCode() + "'," +
                           "" + prpPitem_carDto.getSeatCount() + "," +
                           "'" + prpPitem_carDto.getTonCount() + "'," +
                           "'" + prpPitem_carDto.getExhaustScale() + "'," +
                           "'" + prpPitem_carDto.getColorCode() + "'," +
                           "'" + prpPitem_carDto.getSafeDevice() + "'," +
                           "'" + prpPitem_carDto.getParkSite() + "'," +
                           "'" + prpPitem_carDto.getOwnerAddress() + "'," +
                           "'" + prpPitem_carDto.getOtherNature() + "'," +
                           "'" + prpPitem_carDto.getRateCode() + "'," +
                           "'" + prpPitem_carDto.getMakeDate() + "'," +
                           "'" + prpPitem_carDto.getCarUsage() + "'," +
                           "'" + prpPitem_carDto.getCurrency() + "'," +
                           "'" + prpPitem_carDto.getPurchasePrice() + "'," +
                           "'" + prpPitem_carDto.getActualValue() + "'," +
                           "'" + prpPitem_carDto.getInvoiceNo() + "'," +
                           "'" + prpPitem_carDto.getCarLoanFlag() + "'," +
                           "'" + prpPitem_carDto.getInsurerCode() + "'," +
                           "'" + prpPitem_carDto.getLastInsurer() + "'," +
                           "'" + prpPitem_carDto.getCarCheckStatus() + "'," +
                           "'" + prpPitem_carDto.getCarChecker() + "'," +
                           "'" + prpPitem_carDto.getCarCheckTime() + "'," +
                           "'" + prpPitem_carDto.getSpecialTreat() + "'," +
                           "'" + prpPitem_carDto.getRelievingAreaCode() + "'," +
                           "" + prpPitem_carDto.getAddonCount() + "," +
                           "'" + prpPitem_carDto.getCarDealerCode() + "'," +
                           "'" + prpPitem_carDto.getCarDealerName() + "'," +
                           "'" + prpPitem_carDto.getRemark() + "'," +
                           "'" + prpPitem_carDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPitem_carDto.getEndorseNo());
        dbManager.setString(2,prpPitem_carDto.getPolicyNo());
        dbManager.setString(3,prpPitem_carDto.getRiskCode());
        dbManager.setInt(4,prpPitem_carDto.getItemNo());
        dbManager.setString(5,prpPitem_carDto.getInsuredTypeCode());
        dbManager.setString(6,prpPitem_carDto.getCarInsuredRelation());
        dbManager.setString(7,prpPitem_carDto.getCarOwner());
        dbManager.setString(8,prpPitem_carDto.getClauseType());
        dbManager.setString(9,prpPitem_carDto.getAgreeDriverFlag());
        dbManager.setString(10,prpPitem_carDto.getNewDeviceFlag());
        dbManager.setString(11,prpPitem_carDto.getCarPolicyno());
        dbManager.setString(12,prpPitem_carDto.getLicenseNo());
        dbManager.setString(13,prpPitem_carDto.getLicenseColorCode());
        dbManager.setString(14,prpPitem_carDto.getCarKindCode());
        dbManager.setString(15,prpPitem_carDto.getHKFlag());
        dbManager.setString(16,prpPitem_carDto.getHKLicenseNo());
        dbManager.setString(17,prpPitem_carDto.getEngineNo());
        dbManager.setString(18,prpPitem_carDto.getVINNo());
        dbManager.setString(19,prpPitem_carDto.getFrameNo());
        dbManager.setString(20,prpPitem_carDto.getRunAreaCode());
        dbManager.setString(21,prpPitem_carDto.getRunAreaName());
        dbManager.setDouble(22,prpPitem_carDto.getRunMiles());
        dbManager.setDateTime(23,prpPitem_carDto.getEnrollDate());
        dbManager.setInt(24,prpPitem_carDto.getUseYears());
        dbManager.setString(25,prpPitem_carDto.getModelCode());
        dbManager.setString(26,prpPitem_carDto.getBrandName());
        dbManager.setString(27,prpPitem_carDto.getCountryNature());
        dbManager.setString(28,prpPitem_carDto.getCountryCode());
        dbManager.setString(29,prpPitem_carDto.getUseNatureCode());
        dbManager.setString(30,prpPitem_carDto.getBusinessClassCode());
        dbManager.setInt(31,prpPitem_carDto.getSeatCount());
        dbManager.setDouble(32,prpPitem_carDto.getTonCount());
        dbManager.setDouble(33,prpPitem_carDto.getExhaustScale());
        dbManager.setString(34,prpPitem_carDto.getColorCode());
        dbManager.setString(35,prpPitem_carDto.getSafeDevice());
        dbManager.setString(36,prpPitem_carDto.getParkSite());
        dbManager.setString(37,prpPitem_carDto.getOwnerAddress());
        dbManager.setString(38,prpPitem_carDto.getOtherNature());
        dbManager.setString(39,prpPitem_carDto.getRateCode());
        dbManager.setDateTime(40,prpPitem_carDto.getMakeDate());
        dbManager.setString(41,prpPitem_carDto.getCarUsage());
        dbManager.setString(42,prpPitem_carDto.getCurrency());
        dbManager.setDouble(43,prpPitem_carDto.getPurchasePrice());
        dbManager.setDouble(44,prpPitem_carDto.getActualValue());
        dbManager.setString(45,prpPitem_carDto.getInvoiceNo());
        dbManager.setString(46,prpPitem_carDto.getCarLoanFlag());
        dbManager.setString(47,prpPitem_carDto.getInsurerCode());
        dbManager.setString(48,prpPitem_carDto.getLastInsurer());
        dbManager.setString(49,prpPitem_carDto.getCarCheckStatus());
        dbManager.setString(50,prpPitem_carDto.getCarChecker());
        dbManager.setString(51,prpPitem_carDto.getCarCheckTime());
        dbManager.setDouble(52,prpPitem_carDto.getSpecialTreat());
        dbManager.setString(53,prpPitem_carDto.getRelievingAreaCode());
        dbManager.setInt(54,prpPitem_carDto.getAddonCount());
        dbManager.setString(55,prpPitem_carDto.getCarDealerCode());
        dbManager.setString(56,prpPitem_carDto.getCarDealerName());
        dbManager.setString(57,prpPitem_carDto.getRemark());
        dbManager.setString(58,prpPitem_carDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPitem_carBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPitemCarDto prpPitem_carDto = (PrpPitemCarDto)i.next();
            insert(prpPitem_carDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(String endorseNo,int itemNo) throws Exception{
        String statement = " Delete From PrpPitemcar" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPitemcar Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,itemNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPitem_carBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPitem_carDto prpPitem_carDto
     * @throws Exception
     */
    public void update(PrpPitemCarDto prpPitem_carDto) throws Exception{
        String statement = " Update PrpPitemcar Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " InsuredTypeCode = ?," +
                           " CarInsuredRelation = ?," +
                           " CarOwner = ?," +
                           " ClauseType = ?," +
                           " AgreeDriverFlag = ?," +
                           " NewDeviceFlag = ?," +
                           " CarPolicyno = ?," +
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
                           " ModelCode = ?," +
                           " BrandName = ?," +
                           " CountryNature = ?," +
                           " CountryCode = ?," +
                           " UseNatureCode = ?," +
                           " BusinessClassCode = ?," +
                           " SeatCount = ?," +
                           " TonCount = ?," +
                           " ExhaustScale = ?," +
                           " ColorCode = ?," +
                           " SafeDevice = ?," +
                           " ParkSite = ?," +
                           " OwnerAddress = ?," +
                           " OtherNature = ?," +
                           " RateCode = ?," +
                           " MakeDate = ?," +
                           " CarUsage = ?," +
                           " Currency = ?," +
                           " PurchasePrice = ?," +
                           " ActualValue = ?," +
                           " InvoiceNo = ?," +
                           " CarLoanFlag = ?," +
                           " InsurerCode = ?," +
                           " LastInsurer = ?," +
                           " CarCheckStatus = ?," +
                           " CarChecker = ?," +
                           " CarCheckTime = ?," +
                           " SpecialTreat = ?," +
                           " RelievingAreaCode = ?," +
                           " AddonCount = ?," +
                           " CarDealerCode = ?," +
                           " CarDealerName = ?," +
                           " Remark = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPitemcar Set " +
                           " EndorseNo = '" + prpPitem_carDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPitem_carDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPitem_carDto.getRiskCode() + "'," +
                           " ItemNo = " + prpPitem_carDto.getItemNo() + "," +
                           " InsuredTypeCode = '" + prpPitem_carDto.getInsuredTypeCode() + "'," +
                           " CarInsuredRelation = '" + prpPitem_carDto.getCarInsuredRelation() + "'," +
                           " CarOwner = '" + prpPitem_carDto.getCarOwner() + "'," +
                           " ClauseType = '" + prpPitem_carDto.getClauseType() + "'," +
                           " AgreeDriverFlag = '" + prpPitem_carDto.getAgreeDriverFlag() + "'," +
                           " NewDeviceFlag = '" + prpPitem_carDto.getNewDeviceFlag() + "'," +
                           " CarPolicyno = '" + prpPitem_carDto.getCarPolicyno() + "'," +
                           " LicenseNo = '" + prpPitem_carDto.getLicenseNo() + "'," +
                           " LicenseColorCode = '" + prpPitem_carDto.getLicenseColorCode() + "'," +
                           " CarKindCode = '" + prpPitem_carDto.getCarKindCode() + "'," +
                           " HKFlag = '" + prpPitem_carDto.getHKFlag() + "'," +
                           " HKLicenseNo = '" + prpPitem_carDto.getHKLicenseNo() + "'," +
                           " EngineNo = '" + prpPitem_carDto.getEngineNo() + "'," +
                           " VINNo = '" + prpPitem_carDto.getVINNo() + "'," +
                           " FrameNo = '" + prpPitem_carDto.getFrameNo() + "'," +
                           " RunAreaCode = '" + prpPitem_carDto.getRunAreaCode() + "'," +
                           " RunAreaName = '" + prpPitem_carDto.getRunAreaName() + "'," +
                           " RunMiles = '" + prpPitem_carDto.getRunMiles() + "'," +
                           " EnrollDate = '" + prpPitem_carDto.getEnrollDate() + "'," +
                           " UseYears = " + prpPitem_carDto.getUseYears() + "," +
                           " ModelCode = '" + prpPitem_carDto.getModelCode() + "'," +
                           " BrandName = '" + prpPitem_carDto.getBrandName() + "'," +
                           " CountryNature = '" + prpPitem_carDto.getCountryNature() + "'," +
                           " CountryCode = '" + prpPitem_carDto.getCountryCode() + "'," +
                           " UseNatureCode = '" + prpPitem_carDto.getUseNatureCode() + "'," +
                           " BusinessClassCode = '" + prpPitem_carDto.getBusinessClassCode() + "'," +
                           " SeatCount = " + prpPitem_carDto.getSeatCount() + "," +
                           " TonCount = '" + prpPitem_carDto.getTonCount() + "'," +
                           " ExhaustScale = '" + prpPitem_carDto.getExhaustScale() + "'," +
                           " ColorCode = '" + prpPitem_carDto.getColorCode() + "'," +
                           " SafeDevice = '" + prpPitem_carDto.getSafeDevice() + "'," +
                           " ParkSite = '" + prpPitem_carDto.getParkSite() + "'," +
                           " OwnerAddress = '" + prpPitem_carDto.getOwnerAddress() + "'," +
                           " OtherNature = '" + prpPitem_carDto.getOtherNature() + "'," +
                           " RateCode = '" + prpPitem_carDto.getRateCode() + "'," +
                           " MakeDate = '" + prpPitem_carDto.getMakeDate() + "'," +
                           " CarUsage = '" + prpPitem_carDto.getCarUsage() + "'," +
                           " Currency = '" + prpPitem_carDto.getCurrency() + "'," +
                           " PurchasePrice = '" + prpPitem_carDto.getPurchasePrice() + "'," +
                           " ActualValue = '" + prpPitem_carDto.getActualValue() + "'," +
                           " InvoiceNo = '" + prpPitem_carDto.getInvoiceNo() + "'," +
                           " CarLoanFlag = '" + prpPitem_carDto.getCarLoanFlag() + "'," +
                           " InsurerCode = '" + prpPitem_carDto.getInsurerCode() + "'," +
                           " LastInsurer = '" + prpPitem_carDto.getLastInsurer() + "'," +
                           " CarCheckStatus = '" + prpPitem_carDto.getCarCheckStatus() + "'," +
                           " CarChecker = '" + prpPitem_carDto.getCarChecker() + "'," +
                           " CarCheckTime = '" + prpPitem_carDto.getCarCheckTime() + "'," +
                           " SpecialTreat = '" + prpPitem_carDto.getSpecialTreat() + "'," +
                           " RelievingAreaCode = '" + prpPitem_carDto.getRelievingAreaCode() + "'," +
                           " AddonCount = " + prpPitem_carDto.getAddonCount() + "," +
                           " CarDealerCode = '" + prpPitem_carDto.getCarDealerCode() + "'," +
                           " CarDealerName = '" + prpPitem_carDto.getCarDealerName() + "'," +
                           " Remark = '" + prpPitem_carDto.getRemark() + "'," +
                           " Flag = '" + prpPitem_carDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPitem_carDto.getEndorseNo() + "' And " +
                           " ItemNo = " + prpPitem_carDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPitem_carDto.getPolicyNo());
        dbManager.setString(2,prpPitem_carDto.getRiskCode());
        dbManager.setString(3,prpPitem_carDto.getInsuredTypeCode());
        dbManager.setString(4,prpPitem_carDto.getCarInsuredRelation());
        dbManager.setString(5,prpPitem_carDto.getCarOwner());
        dbManager.setString(6,prpPitem_carDto.getClauseType());
        dbManager.setString(7,prpPitem_carDto.getAgreeDriverFlag());
        dbManager.setString(8,prpPitem_carDto.getNewDeviceFlag());
        dbManager.setString(9,prpPitem_carDto.getCarPolicyno());
        dbManager.setString(10,prpPitem_carDto.getLicenseNo());
        dbManager.setString(11,prpPitem_carDto.getLicenseColorCode());
        dbManager.setString(12,prpPitem_carDto.getCarKindCode());
        dbManager.setString(13,prpPitem_carDto.getHKFlag());
        dbManager.setString(14,prpPitem_carDto.getHKLicenseNo());
        dbManager.setString(15,prpPitem_carDto.getEngineNo());
        dbManager.setString(16,prpPitem_carDto.getVINNo());
        dbManager.setString(17,prpPitem_carDto.getFrameNo());
        dbManager.setString(18,prpPitem_carDto.getRunAreaCode());
        dbManager.setString(19,prpPitem_carDto.getRunAreaName());
        dbManager.setDouble(20,prpPitem_carDto.getRunMiles());
        dbManager.setDateTime(21,prpPitem_carDto.getEnrollDate());
        dbManager.setInt(22,prpPitem_carDto.getUseYears());
        dbManager.setString(23,prpPitem_carDto.getModelCode());
        dbManager.setString(24,prpPitem_carDto.getBrandName());
        dbManager.setString(25,prpPitem_carDto.getCountryNature());
        dbManager.setString(26,prpPitem_carDto.getCountryCode());
        dbManager.setString(27,prpPitem_carDto.getUseNatureCode());
        dbManager.setString(28,prpPitem_carDto.getBusinessClassCode());
        dbManager.setInt(29,prpPitem_carDto.getSeatCount());
        dbManager.setDouble(30,prpPitem_carDto.getTonCount());
        dbManager.setDouble(31,prpPitem_carDto.getExhaustScale());
        dbManager.setString(32,prpPitem_carDto.getColorCode());
        dbManager.setString(33,prpPitem_carDto.getSafeDevice());
        dbManager.setString(34,prpPitem_carDto.getParkSite());
        dbManager.setString(35,prpPitem_carDto.getOwnerAddress());
        dbManager.setString(36,prpPitem_carDto.getOtherNature());
        dbManager.setString(37,prpPitem_carDto.getRateCode());
        dbManager.setDateTime(38,prpPitem_carDto.getMakeDate());
        dbManager.setString(39,prpPitem_carDto.getCarUsage());
        dbManager.setString(40,prpPitem_carDto.getCurrency());
        dbManager.setDouble(41,prpPitem_carDto.getPurchasePrice());
        dbManager.setDouble(42,prpPitem_carDto.getActualValue());
        dbManager.setString(43,prpPitem_carDto.getInvoiceNo());
        dbManager.setString(44,prpPitem_carDto.getCarLoanFlag());
        dbManager.setString(45,prpPitem_carDto.getInsurerCode());
        dbManager.setString(46,prpPitem_carDto.getLastInsurer());
        dbManager.setString(47,prpPitem_carDto.getCarCheckStatus());
        dbManager.setString(48,prpPitem_carDto.getCarChecker());
        dbManager.setString(49,prpPitem_carDto.getCarCheckTime());
        dbManager.setDouble(50,prpPitem_carDto.getSpecialTreat());
        dbManager.setString(51,prpPitem_carDto.getRelievingAreaCode());
        dbManager.setInt(52,prpPitem_carDto.getAddonCount());
        dbManager.setString(53,prpPitem_carDto.getCarDealerCode());
        dbManager.setString(54,prpPitem_carDto.getCarDealerName());
        dbManager.setString(55,prpPitem_carDto.getRemark());
        dbManager.setString(56,prpPitem_carDto.getFlag());
        //设置条件字段;
        dbManager.setString(57,prpPitem_carDto.getEndorseNo());
        dbManager.setInt(58,prpPitem_carDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPitem_carBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @param itemNo 标的序号
     * @return PrpPitemCarDto
     * @throws Exception
     */
    public PrpPitemCarDto findByPrimaryKey(String endorseNo,int itemNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemNo," +
                           " InsuredTypeCode," +
                           " CarInsuredRelation," +
                           " CarOwner," +
                           " ClauseType," +
                           " AgreeDriverFlag," +
                           " NewDeviceFlag," +
                           " CarPolicyno," +
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
                           " ModelCode," +
                           " BrandName," +
                           " CountryNature," +
                           " CountryCode," +
                           " UseNatureCode," +
                           " BusinessClassCode," +
                           " SeatCount," +
                           " TonCount," +
                           " ExhaustScale," +
                           " ColorCode," +
                           " SafeDevice," +
                           " ParkSite," +
                           " OwnerAddress," +
                           " OtherNature," +
                           " RateCode," +
                           " MakeDate," +
                           " CarUsage," +
                           " Currency," +
                           " PurchasePrice," +
                           " ActualValue," +
                           " InvoiceNo," +
                           " CarLoanFlag," +
                           " InsurerCode," +
                           " LastInsurer," +
                           " CarCheckStatus," +
                           " CarChecker," +
                           " CarCheckTime," +
                           " SpecialTreat," +
                           " RelievingAreaCode," +
                           " AddonCount," +
                           " CarDealerCode," +
                           " CarDealerName," +
                           " Remark," +
                           " Flag From PrpPitemcar";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " ItemNo = ?";
        PrpPitemCarDto prpPitem_carDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPitem_carDto = new PrpPitemCarDto();
            prpPitem_carDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPitem_carDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPitem_carDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPitem_carDto.setItemNo(dbManager.getInt(resultSet,4));
            prpPitem_carDto.setInsuredTypeCode(dbManager.getString(resultSet,5));
            prpPitem_carDto.setCarInsuredRelation(dbManager.getString(resultSet,6));
            prpPitem_carDto.setCarOwner(dbManager.getString(resultSet,7));
            prpPitem_carDto.setClauseType(dbManager.getString(resultSet,8));
            prpPitem_carDto.setAgreeDriverFlag(dbManager.getString(resultSet,9));
            prpPitem_carDto.setNewDeviceFlag(dbManager.getString(resultSet,10));
            prpPitem_carDto.setCarPolicyno(dbManager.getString(resultSet,11));
            prpPitem_carDto.setLicenseNo(dbManager.getString(resultSet,12));
            prpPitem_carDto.setLicenseColorCode(dbManager.getString(resultSet,13));
            prpPitem_carDto.setCarKindCode(dbManager.getString(resultSet,14));
            prpPitem_carDto.setHKFlag(dbManager.getString(resultSet,15));
            prpPitem_carDto.setHKLicenseNo(dbManager.getString(resultSet,16));
            prpPitem_carDto.setEngineNo(dbManager.getString(resultSet,17));
            prpPitem_carDto.setVINNo(dbManager.getString(resultSet,18));
            prpPitem_carDto.setFrameNo(dbManager.getString(resultSet,19));
            prpPitem_carDto.setRunAreaCode(dbManager.getString(resultSet,20));
            prpPitem_carDto.setRunAreaName(dbManager.getString(resultSet,21));
            prpPitem_carDto.setRunMiles(dbManager.getDouble(resultSet,22));
            prpPitem_carDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpPitem_carDto.setUseYears(dbManager.getInt(resultSet,24));
            prpPitem_carDto.setModelCode(dbManager.getString(resultSet,25));
            prpPitem_carDto.setBrandName(dbManager.getString(resultSet,26));
            prpPitem_carDto.setCountryNature(dbManager.getString(resultSet,27));
            prpPitem_carDto.setCountryCode(dbManager.getString(resultSet,28));
            prpPitem_carDto.setUseNatureCode(dbManager.getString(resultSet,29));
            prpPitem_carDto.setBusinessClassCode(dbManager.getString(resultSet,30));
            prpPitem_carDto.setSeatCount(dbManager.getInt(resultSet,31));
            prpPitem_carDto.setTonCount(dbManager.getDouble(resultSet,32));
            prpPitem_carDto.setExhaustScale(dbManager.getDouble(resultSet,33));
            prpPitem_carDto.setColorCode(dbManager.getString(resultSet,34));
            prpPitem_carDto.setSafeDevice(dbManager.getString(resultSet,35));
            prpPitem_carDto.setParkSite(dbManager.getString(resultSet,36));
            prpPitem_carDto.setOwnerAddress(dbManager.getString(resultSet,37));
            prpPitem_carDto.setOtherNature(dbManager.getString(resultSet,38));
            prpPitem_carDto.setRateCode(dbManager.getString(resultSet,39));
            prpPitem_carDto.setMakeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,40));
            prpPitem_carDto.setCarUsage(dbManager.getString(resultSet,41));
            prpPitem_carDto.setCurrency(dbManager.getString(resultSet,42));
            prpPitem_carDto.setPurchasePrice(dbManager.getDouble(resultSet,43));
            prpPitem_carDto.setActualValue(dbManager.getDouble(resultSet,44));
            prpPitem_carDto.setInvoiceNo(dbManager.getString(resultSet,45));
            prpPitem_carDto.setCarLoanFlag(dbManager.getString(resultSet,46));
            prpPitem_carDto.setInsurerCode(dbManager.getString(resultSet,47));
            prpPitem_carDto.setLastInsurer(dbManager.getString(resultSet,48));
            prpPitem_carDto.setCarCheckStatus(dbManager.getString(resultSet,49));
            prpPitem_carDto.setCarChecker(dbManager.getString(resultSet,50));
            prpPitem_carDto.setCarCheckTime(dbManager.getString(resultSet,51));
            prpPitem_carDto.setSpecialTreat(dbManager.getDouble(resultSet,52));
            prpPitem_carDto.setRelievingAreaCode(dbManager.getString(resultSet,53));
            prpPitem_carDto.setAddonCount(dbManager.getInt(resultSet,54));
            prpPitem_carDto.setCarDealerCode(dbManager.getString(resultSet,55));
            prpPitem_carDto.setCarDealerName(dbManager.getString(resultSet,56));
            prpPitem_carDto.setRemark(dbManager.getString(resultSet,57));
            prpPitem_carDto.setFlag(dbManager.getString(resultSet,58));
        }
        resultSet.close();
        logger.info("DBPrpPitem_carBase.findByPrimaryKey() success!");
        return prpPitem_carDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemNo," +
                           " InsuredTypeCode," +
                           " CarInsuredRelation," +
                           " CarOwner," +
                           " ClauseType," +
                           " AgreeDriverFlag," +
                           " NewDeviceFlag," +
                           " CarPolicyno," +
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
                           " ModelCode," +
                           " BrandName," +
                           " CountryNature," +
                           " CountryCode," +
                           " UseNatureCode," +
                           " BusinessClassCode," +
                           " SeatCount," +
                           " TonCount," +
                           " ExhaustScale," +
                           " ColorCode," +
                           " SafeDevice," +
                           " ParkSite," +
                           " OwnerAddress," +
                           " OtherNature," +
                           " RateCode," +
                           " MakeDate," +
                           " CarUsage," +
                           " Currency," +
                           " PurchasePrice," +
                           " ActualValue," +
                           " InvoiceNo," +
                           " CarLoanFlag," +
                           " InsurerCode," +
                           " LastInsurer," +
                           " CarCheckStatus," +
                           " CarChecker," +
                           " CarCheckTime," +
                           " SpecialTreat," +
                           " RelievingAreaCode," +
                           " AddonCount," +
                           " CarDealerCode," +
                           " CarDealerName," +
                           " Remark," +
                           " Flag From PrpPitemcar Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPitemCarDto prpPitem_carDto = null;
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

            prpPitem_carDto = new PrpPitemCarDto();
            prpPitem_carDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPitem_carDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPitem_carDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPitem_carDto.setItemNo(dbManager.getInt(resultSet,4));
            prpPitem_carDto.setInsuredTypeCode(dbManager.getString(resultSet,5));
            prpPitem_carDto.setCarInsuredRelation(dbManager.getString(resultSet,6));
            prpPitem_carDto.setCarOwner(dbManager.getString(resultSet,7));
            prpPitem_carDto.setClauseType(dbManager.getString(resultSet,8));
            prpPitem_carDto.setAgreeDriverFlag(dbManager.getString(resultSet,9));
            prpPitem_carDto.setNewDeviceFlag(dbManager.getString(resultSet,10));
            prpPitem_carDto.setCarPolicyno(dbManager.getString(resultSet,11));
            prpPitem_carDto.setLicenseNo(dbManager.getString(resultSet,12));
            prpPitem_carDto.setLicenseColorCode(dbManager.getString(resultSet,13));
            prpPitem_carDto.setCarKindCode(dbManager.getString(resultSet,14));
            prpPitem_carDto.setHKFlag(dbManager.getString(resultSet,15));
            prpPitem_carDto.setHKLicenseNo(dbManager.getString(resultSet,16));
            prpPitem_carDto.setEngineNo(dbManager.getString(resultSet,17));
            prpPitem_carDto.setVINNo(dbManager.getString(resultSet,18));
            prpPitem_carDto.setFrameNo(dbManager.getString(resultSet,19));
            prpPitem_carDto.setRunAreaCode(dbManager.getString(resultSet,20));
            prpPitem_carDto.setRunAreaName(dbManager.getString(resultSet,21));
            prpPitem_carDto.setRunMiles(dbManager.getDouble(resultSet,22));
            prpPitem_carDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpPitem_carDto.setUseYears(dbManager.getInt(resultSet,24));
            prpPitem_carDto.setModelCode(dbManager.getString(resultSet,25));
            prpPitem_carDto.setBrandName(dbManager.getString(resultSet,26));
            prpPitem_carDto.setCountryNature(dbManager.getString(resultSet,27));
            prpPitem_carDto.setCountryCode(dbManager.getString(resultSet,28));
            prpPitem_carDto.setUseNatureCode(dbManager.getString(resultSet,29));
            prpPitem_carDto.setBusinessClassCode(dbManager.getString(resultSet,30));
            prpPitem_carDto.setSeatCount(dbManager.getInt(resultSet,31));
            prpPitem_carDto.setTonCount(dbManager.getDouble(resultSet,32));
            prpPitem_carDto.setExhaustScale(dbManager.getDouble(resultSet,33));
            prpPitem_carDto.setColorCode(dbManager.getString(resultSet,34));
            prpPitem_carDto.setSafeDevice(dbManager.getString(resultSet,35));
            prpPitem_carDto.setParkSite(dbManager.getString(resultSet,36));
            prpPitem_carDto.setOwnerAddress(dbManager.getString(resultSet,37));
            prpPitem_carDto.setOtherNature(dbManager.getString(resultSet,38));
            prpPitem_carDto.setRateCode(dbManager.getString(resultSet,39));
            prpPitem_carDto.setMakeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,40));
            prpPitem_carDto.setCarUsage(dbManager.getString(resultSet,41));
            prpPitem_carDto.setCurrency(dbManager.getString(resultSet,42));
            prpPitem_carDto.setPurchasePrice(dbManager.getDouble(resultSet,43));
            prpPitem_carDto.setActualValue(dbManager.getDouble(resultSet,44));
            prpPitem_carDto.setInvoiceNo(dbManager.getString(resultSet,45));
            prpPitem_carDto.setCarLoanFlag(dbManager.getString(resultSet,46));
            prpPitem_carDto.setInsurerCode(dbManager.getString(resultSet,47));
            prpPitem_carDto.setLastInsurer(dbManager.getString(resultSet,48));
            prpPitem_carDto.setCarCheckStatus(dbManager.getString(resultSet,49));
            prpPitem_carDto.setCarChecker(dbManager.getString(resultSet,50));
            prpPitem_carDto.setCarCheckTime(dbManager.getString(resultSet,51));
            prpPitem_carDto.setSpecialTreat(dbManager.getDouble(resultSet,52));
            prpPitem_carDto.setRelievingAreaCode(dbManager.getString(resultSet,53));
            prpPitem_carDto.setAddonCount(dbManager.getInt(resultSet,54));
            prpPitem_carDto.setCarDealerCode(dbManager.getString(resultSet,55));
            prpPitem_carDto.setCarDealerName(dbManager.getString(resultSet,56));
            prpPitem_carDto.setRemark(dbManager.getString(resultSet,57));
            prpPitem_carDto.setFlag(dbManager.getString(resultSet,58));
            collection.add(prpPitem_carDto);
        }
        resultSet.close();
        logger.info("DBPrpPitem_carBase.findByConditions() success!");
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
        String statement = "Delete From PrpPitemcar Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPitem_carBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPitemcar Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPitem_carBase.getCount() success!");
        return count;
    }
}
