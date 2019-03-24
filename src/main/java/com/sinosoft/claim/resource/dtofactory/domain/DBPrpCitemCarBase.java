package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCitemCar-机动车险标的信息的数据访问对象基类<br>
 * 创建于 2006-06-22 12:08:33.859<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemCarBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCitemCarBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemCarBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCitemCarDto prpCitemCarDto
     * @throws Exception
     */
    public void insert(PrpCitemCarDto prpCitemCarDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCitemCar (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("InsuredTypeCode,");
        buffer.append("CarInsuredRelation,");
        buffer.append("CarOwner,");
        buffer.append("ClauseType,");
        buffer.append("AgreeDriverFlag,");
        buffer.append("NewDeviceFlag,");
        buffer.append("CarPolicyno,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("HKFlag,");
        buffer.append("HKLicenseNo,");
        buffer.append("EngineNo,");
        buffer.append("VINNo,");
        buffer.append("FrameNo,");
        buffer.append("RunAreaCode,");
        buffer.append("RunAreaName,");
        buffer.append("RunMiles,");
        buffer.append("EnrollDate,");
        buffer.append("UseYears,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("CountryNature,");
        buffer.append("CountryCode,");
        buffer.append("UseNatureCode,");
        buffer.append("BusinessClassCode,");
        buffer.append("SeatCount,");
        buffer.append("TonCount,");
        buffer.append("ExhaustScale,");
        buffer.append("ColorCode,");
        buffer.append("SafeDevice,");
        buffer.append("ParkSite,");
        buffer.append("OwnerAddress,");
        buffer.append("OtherNature,");
        buffer.append("RateCode,");
        buffer.append("MakeDate,");
        buffer.append("CarUsage,");
        buffer.append("Currency,");
        buffer.append("PurchasePrice,");
        buffer.append("ActualValue,");
        buffer.append("InvoiceNo,");
        buffer.append("CarLoanFlag,");
        buffer.append("InsurerCode,");
        buffer.append("LastInsurer,");
        buffer.append("CarCheckStatus,");
        buffer.append("CarChecker,");
        buffer.append("CarCheckTime,");
        buffer.append("SpecialTreat,");
        buffer.append("RelievingAreaCode,");
        buffer.append("AddonCount,");
        buffer.append("CarDealerCode,");
        buffer.append("CarDealerName,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("CarCheckReason,");
        buffer.append("SvioLatedTimes,");
        buffer.append("LvioLatedTimes,");
        buffer.append("LicenseKindCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCitemCarDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getItemNo()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getInsuredTypeCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarInsuredRelation()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarOwner()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getAgreeDriverFlag()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getNewDeviceFlag()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarPolicyno()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getLicenseColorCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarKindCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getHKFlag()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getHKLicenseNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getEngineNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getVINNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getFrameNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getRunAreaCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getRunAreaName()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getRunMiles()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getEnrollDate()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getUseYears()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getModelCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getBrandName()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCountryNature()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCountryCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getUseNatureCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getBusinessClassCode()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getSeatCount()).append(",");
            debugBuffer.append("").append(prpCitemCarDto.getTonCount()).append(",");
            debugBuffer.append("").append(prpCitemCarDto.getExhaustScale()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getColorCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getSafeDevice()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getParkSite()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getOwnerAddress()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getOtherNature()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getRateCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getMakeDate()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarUsage()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getPurchasePrice()).append(",");
            debugBuffer.append("").append(prpCitemCarDto.getActualValue()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getInvoiceNo()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarLoanFlag()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getInsurerCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getLastInsurer()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarCheckStatus()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarChecker()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarCheckTime()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getSpecialTreat()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getRelievingAreaCode()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getAddonCount()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getCarDealerCode()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarDealerName()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpCitemCarDto.getCarCheckReason()).append("',");
            debugBuffer.append("").append(prpCitemCarDto.getSvioLatedTimes()).append(",");
            debugBuffer.append("").append(prpCitemCarDto.getLvioLatedTimes()).append(",");
            debugBuffer.append("'").append(prpCitemCarDto.getLicenseKindCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCitemCarDto.getPolicyNo());
        dbManager.setString(2,prpCitemCarDto.getRiskCode());
        dbManager.setLong(3,prpCitemCarDto.getItemNo());
        dbManager.setString(4,prpCitemCarDto.getInsuredTypeCode());
        dbManager.setString(5,prpCitemCarDto.getCarInsuredRelation());
        dbManager.setString(6,prpCitemCarDto.getCarOwner());
        dbManager.setString(7,prpCitemCarDto.getClauseType());
        dbManager.setString(8,prpCitemCarDto.getAgreeDriverFlag());
        dbManager.setString(9,prpCitemCarDto.getNewDeviceFlag());
        dbManager.setString(10,prpCitemCarDto.getCarPolicyno());
        dbManager.setString(11,prpCitemCarDto.getLicenseNo());
        dbManager.setString(12,prpCitemCarDto.getLicenseColorCode());
        dbManager.setString(13,prpCitemCarDto.getCarKindCode());
        dbManager.setString(14,prpCitemCarDto.getHKFlag());
        dbManager.setString(15,prpCitemCarDto.getHKLicenseNo());
        dbManager.setString(16,prpCitemCarDto.getEngineNo());
        dbManager.setString(17,prpCitemCarDto.getVINNo());
        dbManager.setString(18,prpCitemCarDto.getFrameNo());
        dbManager.setString(19,prpCitemCarDto.getRunAreaCode());
        dbManager.setString(20,prpCitemCarDto.getRunAreaName());
        dbManager.setDouble(21,prpCitemCarDto.getRunMiles());
        dbManager.setDateTime(22,prpCitemCarDto.getEnrollDate());
        dbManager.setInt(23,prpCitemCarDto.getUseYears());
        dbManager.setString(24,prpCitemCarDto.getModelCode());
        dbManager.setString(25,prpCitemCarDto.getBrandName());
        dbManager.setString(26,prpCitemCarDto.getCountryNature());
        dbManager.setString(27,prpCitemCarDto.getCountryCode());
        dbManager.setString(28,prpCitemCarDto.getUseNatureCode());
        dbManager.setString(29,prpCitemCarDto.getBusinessClassCode());
        dbManager.setLong(30,prpCitemCarDto.getSeatCount());
        dbManager.setDouble(31,prpCitemCarDto.getTonCount());
        dbManager.setDouble(32,prpCitemCarDto.getExhaustScale());
        dbManager.setString(33,prpCitemCarDto.getColorCode());
        dbManager.setString(34,prpCitemCarDto.getSafeDevice());
        dbManager.setString(35,prpCitemCarDto.getParkSite());
        dbManager.setString(36,prpCitemCarDto.getOwnerAddress());
        dbManager.setString(37,prpCitemCarDto.getOtherNature());
        dbManager.setString(38,prpCitemCarDto.getRateCode());
        dbManager.setDateTime(39,prpCitemCarDto.getMakeDate());
        dbManager.setString(40,prpCitemCarDto.getCarUsage());
        dbManager.setString(41,prpCitemCarDto.getCurrency());
        dbManager.setDouble(42,prpCitemCarDto.getPurchasePrice());
        dbManager.setDouble(43,prpCitemCarDto.getActualValue());
        dbManager.setString(44,prpCitemCarDto.getInvoiceNo());
        dbManager.setString(45,prpCitemCarDto.getCarLoanFlag());
        dbManager.setString(46,prpCitemCarDto.getInsurerCode());
        dbManager.setString(47,prpCitemCarDto.getLastInsurer());
        dbManager.setString(48,prpCitemCarDto.getCarCheckStatus());
        dbManager.setString(49,prpCitemCarDto.getCarChecker());
        dbManager.setString(50,prpCitemCarDto.getCarCheckTime());
        dbManager.setDouble(51,prpCitemCarDto.getSpecialTreat());
        dbManager.setString(52,prpCitemCarDto.getRelievingAreaCode());
        dbManager.setLong(53,prpCitemCarDto.getAddonCount());
        dbManager.setString(54,prpCitemCarDto.getCarDealerCode());
        dbManager.setString(55,prpCitemCarDto.getCarDealerName());
        dbManager.setString(56,prpCitemCarDto.getRemark());
        dbManager.setString(57,prpCitemCarDto.getFlag());
        dbManager.setString(58,prpCitemCarDto.getCarCheckReason());
        dbManager.setLong(59,prpCitemCarDto.getSvioLatedTimes());
        dbManager.setLong(60,prpCitemCarDto.getLvioLatedTimes());
        dbManager.setString(61,prpCitemCarDto.getLicenseKindCode());
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
        buffer.append("INSERT INTO PrpCitemCar (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("InsuredTypeCode,");
        buffer.append("CarInsuredRelation,");
        buffer.append("CarOwner,");
        buffer.append("ClauseType,");
        buffer.append("AgreeDriverFlag,");
        buffer.append("NewDeviceFlag,");
        buffer.append("CarPolicyno,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("HKFlag,");
        buffer.append("HKLicenseNo,");
        buffer.append("EngineNo,");
        buffer.append("VINNo,");
        buffer.append("FrameNo,");
        buffer.append("RunAreaCode,");
        buffer.append("RunAreaName,");
        buffer.append("RunMiles,");
        buffer.append("EnrollDate,");
        buffer.append("UseYears,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("CountryNature,");
        buffer.append("CountryCode,");
        buffer.append("UseNatureCode,");
        buffer.append("BusinessClassCode,");
        buffer.append("SeatCount,");
        buffer.append("TonCount,");
        buffer.append("ExhaustScale,");
        buffer.append("ColorCode,");
        buffer.append("SafeDevice,");
        buffer.append("ParkSite,");
        buffer.append("OwnerAddress,");
        buffer.append("OtherNature,");
        buffer.append("RateCode,");
        buffer.append("MakeDate,");
        buffer.append("CarUsage,");
        buffer.append("Currency,");
        buffer.append("PurchasePrice,");
        buffer.append("ActualValue,");
        buffer.append("InvoiceNo,");
        buffer.append("CarLoanFlag,");
        buffer.append("InsurerCode,");
        buffer.append("LastInsurer,");
        buffer.append("CarCheckStatus,");
        buffer.append("CarChecker,");
        buffer.append("CarCheckTime,");
        buffer.append("SpecialTreat,");
        buffer.append("RelievingAreaCode,");
        buffer.append("AddonCount,");
        buffer.append("CarDealerCode,");
        buffer.append("CarDealerName,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("CarCheckReason,");
        buffer.append("SvioLatedTimes,");
        buffer.append("LvioLatedTimes,");
        buffer.append("LicenseKindCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto)i.next();
            dbManager.setString(1,prpCitemCarDto.getPolicyNo());
            dbManager.setString(2,prpCitemCarDto.getRiskCode());
            dbManager.setLong(3,prpCitemCarDto.getItemNo());
            dbManager.setString(4,prpCitemCarDto.getInsuredTypeCode());
            dbManager.setString(5,prpCitemCarDto.getCarInsuredRelation());
            dbManager.setString(6,prpCitemCarDto.getCarOwner());
            dbManager.setString(7,prpCitemCarDto.getClauseType());
            dbManager.setString(8,prpCitemCarDto.getAgreeDriverFlag());
            dbManager.setString(9,prpCitemCarDto.getNewDeviceFlag());
            dbManager.setString(10,prpCitemCarDto.getCarPolicyno());
            dbManager.setString(11,prpCitemCarDto.getLicenseNo());
            dbManager.setString(12,prpCitemCarDto.getLicenseColorCode());
            dbManager.setString(13,prpCitemCarDto.getCarKindCode());
            dbManager.setString(14,prpCitemCarDto.getHKFlag());
            dbManager.setString(15,prpCitemCarDto.getHKLicenseNo());
            dbManager.setString(16,prpCitemCarDto.getEngineNo());
            dbManager.setString(17,prpCitemCarDto.getVINNo());
            dbManager.setString(18,prpCitemCarDto.getFrameNo());
            dbManager.setString(19,prpCitemCarDto.getRunAreaCode());
            dbManager.setString(20,prpCitemCarDto.getRunAreaName());
            dbManager.setDouble(21,prpCitemCarDto.getRunMiles());
            dbManager.setDateTime(22,prpCitemCarDto.getEnrollDate());
            dbManager.setInt(23,prpCitemCarDto.getUseYears());
            dbManager.setString(24,prpCitemCarDto.getModelCode());
            dbManager.setString(25,prpCitemCarDto.getBrandName());
            dbManager.setString(26,prpCitemCarDto.getCountryNature());
            dbManager.setString(27,prpCitemCarDto.getCountryCode());
            dbManager.setString(28,prpCitemCarDto.getUseNatureCode());
            dbManager.setString(29,prpCitemCarDto.getBusinessClassCode());
            dbManager.setLong(30,prpCitemCarDto.getSeatCount());
            dbManager.setDouble(31,prpCitemCarDto.getTonCount());
            dbManager.setDouble(32,prpCitemCarDto.getExhaustScale());
            dbManager.setString(33,prpCitemCarDto.getColorCode());
            dbManager.setString(34,prpCitemCarDto.getSafeDevice());
            dbManager.setString(35,prpCitemCarDto.getParkSite());
            dbManager.setString(36,prpCitemCarDto.getOwnerAddress());
            dbManager.setString(37,prpCitemCarDto.getOtherNature());
            dbManager.setString(38,prpCitemCarDto.getRateCode());
            dbManager.setDateTime(39,prpCitemCarDto.getMakeDate());
            dbManager.setString(40,prpCitemCarDto.getCarUsage());
            dbManager.setString(41,prpCitemCarDto.getCurrency());
            dbManager.setDouble(42,prpCitemCarDto.getPurchasePrice());
            dbManager.setDouble(43,prpCitemCarDto.getActualValue());
            dbManager.setString(44,prpCitemCarDto.getInvoiceNo());
            dbManager.setString(45,prpCitemCarDto.getCarLoanFlag());
            dbManager.setString(46,prpCitemCarDto.getInsurerCode());
            dbManager.setString(47,prpCitemCarDto.getLastInsurer());
            dbManager.setString(48,prpCitemCarDto.getCarCheckStatus());
            dbManager.setString(49,prpCitemCarDto.getCarChecker());
            dbManager.setString(50,prpCitemCarDto.getCarCheckTime());
            dbManager.setDouble(51,prpCitemCarDto.getSpecialTreat());
            dbManager.setString(52,prpCitemCarDto.getRelievingAreaCode());
            dbManager.setLong(53,prpCitemCarDto.getAddonCount());
            dbManager.setString(54,prpCitemCarDto.getCarDealerCode());
            dbManager.setString(55,prpCitemCarDto.getCarDealerName());
            dbManager.setString(56,prpCitemCarDto.getRemark());
            dbManager.setString(57,prpCitemCarDto.getFlag());
            dbManager.setString(58,prpCitemCarDto.getCarCheckReason());
            dbManager.setLong(59,prpCitemCarDto.getSvioLatedTimes());
            dbManager.setLong(60,prpCitemCarDto.getLvioLatedTimes());
            dbManager.setString(61,prpCitemCarDto.getLicenseKindCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCitemCar ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCitemCarDto prpCitemCarDto
     * @throws Exception
     */
    public void update(PrpCitemCarDto prpCitemCarDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCitemCar SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("InsuredTypeCode = ?, ");
        buffer.append("CarInsuredRelation = ?, ");
        buffer.append("CarOwner = ?, ");
        buffer.append("ClauseType = ?, ");
        buffer.append("AgreeDriverFlag = ?, ");
        buffer.append("NewDeviceFlag = ?, ");
        buffer.append("CarPolicyno = ?, ");
        buffer.append("LicenseNo = ?, ");
        buffer.append("LicenseColorCode = ?, ");
        buffer.append("CarKindCode = ?, ");
        buffer.append("HKFlag = ?, ");
        buffer.append("HKLicenseNo = ?, ");
        buffer.append("EngineNo = ?, ");
        buffer.append("VINNo = ?, ");
        buffer.append("FrameNo = ?, ");
        buffer.append("RunAreaCode = ?, ");
        buffer.append("RunAreaName = ?, ");
        buffer.append("RunMiles = ?, ");
        buffer.append("EnrollDate = ?, ");
        buffer.append("UseYears = ?, ");
        buffer.append("ModelCode = ?, ");
        buffer.append("BrandName = ?, ");
        buffer.append("CountryNature = ?, ");
        buffer.append("CountryCode = ?, ");
        buffer.append("UseNatureCode = ?, ");
        buffer.append("BusinessClassCode = ?, ");
        buffer.append("SeatCount = ?, ");
        buffer.append("TonCount = ?, ");
        buffer.append("ExhaustScale = ?, ");
        buffer.append("ColorCode = ?, ");
        buffer.append("SafeDevice = ?, ");
        buffer.append("ParkSite = ?, ");
        buffer.append("OwnerAddress = ?, ");
        buffer.append("OtherNature = ?, ");
        buffer.append("RateCode = ?, ");
        buffer.append("MakeDate = ?, ");
        buffer.append("CarUsage = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("PurchasePrice = ?, ");
        buffer.append("ActualValue = ?, ");
        buffer.append("InvoiceNo = ?, ");
        buffer.append("CarLoanFlag = ?, ");
        buffer.append("InsurerCode = ?, ");
        buffer.append("LastInsurer = ?, ");
        buffer.append("CarCheckStatus = ?, ");
        buffer.append("CarChecker = ?, ");
        buffer.append("CarCheckTime = ?, ");
        buffer.append("SpecialTreat = ?, ");
        buffer.append("RelievingAreaCode = ?, ");
        buffer.append("AddonCount = ?, ");
        buffer.append("CarDealerCode = ?, ");
        buffer.append("CarDealerName = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("CarCheckReason = ?, ");
        buffer.append("SvioLatedTimes = ?, ");
        buffer.append("LvioLatedTimes = ?, ");
        buffer.append("LicenseKindCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCitemCar SET ");
            debugBuffer.append("RiskCode = '" + prpCitemCarDto.getRiskCode() + "', ");
            debugBuffer.append("InsuredTypeCode = '" + prpCitemCarDto.getInsuredTypeCode() + "', ");
            debugBuffer.append("CarInsuredRelation = '" + prpCitemCarDto.getCarInsuredRelation() + "', ");
            debugBuffer.append("CarOwner = '" + prpCitemCarDto.getCarOwner() + "', ");
            debugBuffer.append("ClauseType = '" + prpCitemCarDto.getClauseType() + "', ");
            debugBuffer.append("AgreeDriverFlag = '" + prpCitemCarDto.getAgreeDriverFlag() + "', ");
            debugBuffer.append("NewDeviceFlag = '" + prpCitemCarDto.getNewDeviceFlag() + "', ");
            debugBuffer.append("CarPolicyno = '" + prpCitemCarDto.getCarPolicyno() + "', ");
            debugBuffer.append("LicenseNo = '" + prpCitemCarDto.getLicenseNo() + "', ");
            debugBuffer.append("LicenseColorCode = '" + prpCitemCarDto.getLicenseColorCode() + "', ");
            debugBuffer.append("CarKindCode = '" + prpCitemCarDto.getCarKindCode() + "', ");
            debugBuffer.append("HKFlag = '" + prpCitemCarDto.getHKFlag() + "', ");
            debugBuffer.append("HKLicenseNo = '" + prpCitemCarDto.getHKLicenseNo() + "', ");
            debugBuffer.append("EngineNo = '" + prpCitemCarDto.getEngineNo() + "', ");
            debugBuffer.append("VINNo = '" + prpCitemCarDto.getVINNo() + "', ");
            debugBuffer.append("FrameNo = '" + prpCitemCarDto.getFrameNo() + "', ");
            debugBuffer.append("RunAreaCode = '" + prpCitemCarDto.getRunAreaCode() + "', ");
            debugBuffer.append("RunAreaName = '" + prpCitemCarDto.getRunAreaName() + "', ");
            debugBuffer.append("RunMiles = " + prpCitemCarDto.getRunMiles() + ", ");
            debugBuffer.append("EnrollDate = '" + prpCitemCarDto.getEnrollDate() + "', ");
            debugBuffer.append("UseYears = " + prpCitemCarDto.getUseYears() + ", ");
            debugBuffer.append("ModelCode = '" + prpCitemCarDto.getModelCode() + "', ");
            debugBuffer.append("BrandName = '" + prpCitemCarDto.getBrandName() + "', ");
            debugBuffer.append("CountryNature = '" + prpCitemCarDto.getCountryNature() + "', ");
            debugBuffer.append("CountryCode = '" + prpCitemCarDto.getCountryCode() + "', ");
            debugBuffer.append("UseNatureCode = '" + prpCitemCarDto.getUseNatureCode() + "', ");
            debugBuffer.append("BusinessClassCode = '" + prpCitemCarDto.getBusinessClassCode() + "', ");
            debugBuffer.append("SeatCount = " + prpCitemCarDto.getSeatCount() + ", ");
            debugBuffer.append("TonCount = " + prpCitemCarDto.getTonCount() + ", ");
            debugBuffer.append("ExhaustScale = " + prpCitemCarDto.getExhaustScale() + ", ");
            debugBuffer.append("ColorCode = '" + prpCitemCarDto.getColorCode() + "', ");
            debugBuffer.append("SafeDevice = '" + prpCitemCarDto.getSafeDevice() + "', ");
            debugBuffer.append("ParkSite = '" + prpCitemCarDto.getParkSite() + "', ");
            debugBuffer.append("OwnerAddress = '" + prpCitemCarDto.getOwnerAddress() + "', ");
            debugBuffer.append("OtherNature = '" + prpCitemCarDto.getOtherNature() + "', ");
            debugBuffer.append("RateCode = '" + prpCitemCarDto.getRateCode() + "', ");
            debugBuffer.append("MakeDate = '" + prpCitemCarDto.getMakeDate() + "', ");
            debugBuffer.append("CarUsage = '" + prpCitemCarDto.getCarUsage() + "', ");
            debugBuffer.append("Currency = '" + prpCitemCarDto.getCurrency() + "', ");
            debugBuffer.append("PurchasePrice = " + prpCitemCarDto.getPurchasePrice() + ", ");
            debugBuffer.append("ActualValue = " + prpCitemCarDto.getActualValue() + ", ");
            debugBuffer.append("InvoiceNo = '" + prpCitemCarDto.getInvoiceNo() + "', ");
            debugBuffer.append("CarLoanFlag = '" + prpCitemCarDto.getCarLoanFlag() + "', ");
            debugBuffer.append("InsurerCode = '" + prpCitemCarDto.getInsurerCode() + "', ");
            debugBuffer.append("LastInsurer = '" + prpCitemCarDto.getLastInsurer() + "', ");
            debugBuffer.append("CarCheckStatus = '" + prpCitemCarDto.getCarCheckStatus() + "', ");
            debugBuffer.append("CarChecker = '" + prpCitemCarDto.getCarChecker() + "', ");
            debugBuffer.append("CarCheckTime = '" + prpCitemCarDto.getCarCheckTime() + "', ");
            debugBuffer.append("SpecialTreat = " + prpCitemCarDto.getSpecialTreat() + ", ");
            debugBuffer.append("RelievingAreaCode = '" + prpCitemCarDto.getRelievingAreaCode() + "', ");
            debugBuffer.append("AddonCount = " + prpCitemCarDto.getAddonCount() + ", ");
            debugBuffer.append("CarDealerCode = '" + prpCitemCarDto.getCarDealerCode() + "', ");
            debugBuffer.append("CarDealerName = '" + prpCitemCarDto.getCarDealerName() + "', ");
            debugBuffer.append("Remark = '" + prpCitemCarDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + prpCitemCarDto.getFlag() + "', ");
            debugBuffer.append("CarCheckReason = '" + prpCitemCarDto.getCarCheckReason() + "', ");
            debugBuffer.append("SvioLatedTimes = " + prpCitemCarDto.getSvioLatedTimes() + ", ");
            debugBuffer.append("LvioLatedTimes = " + prpCitemCarDto.getLvioLatedTimes() + ", ");
            debugBuffer.append("LicenseKindCode = '" + prpCitemCarDto.getLicenseKindCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCitemCarDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(prpCitemCarDto.getItemNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpCitemCarDto.getRiskCode());
        dbManager.setString(2,prpCitemCarDto.getInsuredTypeCode());
        dbManager.setString(3,prpCitemCarDto.getCarInsuredRelation());
        dbManager.setString(4,prpCitemCarDto.getCarOwner());
        dbManager.setString(5,prpCitemCarDto.getClauseType());
        dbManager.setString(6,prpCitemCarDto.getAgreeDriverFlag());
        dbManager.setString(7,prpCitemCarDto.getNewDeviceFlag());
        dbManager.setString(8,prpCitemCarDto.getCarPolicyno());
        dbManager.setString(9,prpCitemCarDto.getLicenseNo());
        dbManager.setString(10,prpCitemCarDto.getLicenseColorCode());
        dbManager.setString(11,prpCitemCarDto.getCarKindCode());
        dbManager.setString(12,prpCitemCarDto.getHKFlag());
        dbManager.setString(13,prpCitemCarDto.getHKLicenseNo());
        dbManager.setString(14,prpCitemCarDto.getEngineNo());
        dbManager.setString(15,prpCitemCarDto.getVINNo());
        dbManager.setString(16,prpCitemCarDto.getFrameNo());
        dbManager.setString(17,prpCitemCarDto.getRunAreaCode());
        dbManager.setString(18,prpCitemCarDto.getRunAreaName());
        dbManager.setDouble(19,prpCitemCarDto.getRunMiles());
        dbManager.setDateTime(20,prpCitemCarDto.getEnrollDate());
        dbManager.setInt(21,prpCitemCarDto.getUseYears());
        dbManager.setString(22,prpCitemCarDto.getModelCode());
        dbManager.setString(23,prpCitemCarDto.getBrandName());
        dbManager.setString(24,prpCitemCarDto.getCountryNature());
        dbManager.setString(25,prpCitemCarDto.getCountryCode());
        dbManager.setString(26,prpCitemCarDto.getUseNatureCode());
        dbManager.setString(27,prpCitemCarDto.getBusinessClassCode());
        dbManager.setLong(28,prpCitemCarDto.getSeatCount());
        dbManager.setDouble(29,prpCitemCarDto.getTonCount());
        dbManager.setDouble(30,prpCitemCarDto.getExhaustScale());
        dbManager.setString(31,prpCitemCarDto.getColorCode());
        dbManager.setString(32,prpCitemCarDto.getSafeDevice());
        dbManager.setString(33,prpCitemCarDto.getParkSite());
        dbManager.setString(34,prpCitemCarDto.getOwnerAddress());
        dbManager.setString(35,prpCitemCarDto.getOtherNature());
        dbManager.setString(36,prpCitemCarDto.getRateCode());
        dbManager.setDateTime(37,prpCitemCarDto.getMakeDate());
        dbManager.setString(38,prpCitemCarDto.getCarUsage());
        dbManager.setString(39,prpCitemCarDto.getCurrency());
        dbManager.setDouble(40,prpCitemCarDto.getPurchasePrice());
        dbManager.setDouble(41,prpCitemCarDto.getActualValue());
        dbManager.setString(42,prpCitemCarDto.getInvoiceNo());
        dbManager.setString(43,prpCitemCarDto.getCarLoanFlag());
        dbManager.setString(44,prpCitemCarDto.getInsurerCode());
        dbManager.setString(45,prpCitemCarDto.getLastInsurer());
        dbManager.setString(46,prpCitemCarDto.getCarCheckStatus());
        dbManager.setString(47,prpCitemCarDto.getCarChecker());
        dbManager.setString(48,prpCitemCarDto.getCarCheckTime());
        dbManager.setDouble(49,prpCitemCarDto.getSpecialTreat());
        dbManager.setString(50,prpCitemCarDto.getRelievingAreaCode());
        dbManager.setLong(51,prpCitemCarDto.getAddonCount());
        dbManager.setString(52,prpCitemCarDto.getCarDealerCode());
        dbManager.setString(53,prpCitemCarDto.getCarDealerName());
        dbManager.setString(54,prpCitemCarDto.getRemark());
        dbManager.setString(55,prpCitemCarDto.getFlag());
        dbManager.setString(56,prpCitemCarDto.getCarCheckReason());
        dbManager.setLong(57,prpCitemCarDto.getSvioLatedTimes());
        dbManager.setLong(58,prpCitemCarDto.getLvioLatedTimes());
        dbManager.setString(59,prpCitemCarDto.getLicenseKindCode());
        //设置条件字段;
        dbManager.setString(60,prpCitemCarDto.getPolicyNo());
        dbManager.setLong(61,prpCitemCarDto.getItemNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param itemNo 标的序号
     * @return PrpCitemCarDto
     * @throws Exception
     */
    public PrpCitemCarDto findByPrimaryKey(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("InsuredTypeCode,");
        buffer.append("CarInsuredRelation,");
        buffer.append("CarOwner,");
        buffer.append("ClauseType,");
        buffer.append("AgreeDriverFlag,");
        buffer.append("NewDeviceFlag,");
        buffer.append("CarPolicyno,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("HKFlag,");
        buffer.append("HKLicenseNo,");
        buffer.append("EngineNo,");
        buffer.append("VINNo,");
        buffer.append("FrameNo,");
        buffer.append("RunAreaCode,");
        buffer.append("RunAreaName,");
        buffer.append("RunMiles,");
        buffer.append("EnrollDate,");
        buffer.append("UseYears,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("CountryNature,");
        buffer.append("CountryCode,");
        buffer.append("UseNatureCode,");
        buffer.append("BusinessClassCode,");
        buffer.append("SeatCount,");
        buffer.append("TonCount,");
        buffer.append("ExhaustScale,");
        buffer.append("ColorCode,");
        buffer.append("SafeDevice,");
        buffer.append("ParkSite,");
        buffer.append("OwnerAddress,");
        buffer.append("OtherNature,");
        buffer.append("RateCode,");
        buffer.append("MakeDate,");
        buffer.append("CarUsage,");
        buffer.append("Currency,");
        buffer.append("PurchasePrice,");
        buffer.append("ActualValue,");
        buffer.append("InvoiceNo,");
        buffer.append("CarLoanFlag,");
        buffer.append("InsurerCode,");
        buffer.append("LastInsurer,");
        buffer.append("CarCheckStatus,");
        buffer.append("CarChecker,");
        buffer.append("CarCheckTime,");
        buffer.append("SpecialTreat,");
        buffer.append("RelievingAreaCode,");
        buffer.append("AddonCount,");
        buffer.append("CarDealerCode,");
        buffer.append("CarDealerName,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("CarCheckReason,");
        buffer.append("SvioLatedTimes,");
        buffer.append("LvioLatedTimes,");
        buffer.append("LicenseKindCode ");
        buffer.append("FROM PrpCitemCar ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCitemCarDto prpCitemCarDto = null;
        if(resultSet.next()){
            prpCitemCarDto = new PrpCitemCarDto();
            prpCitemCarDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemCarDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemCarDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemCarDto.setInsuredTypeCode(dbManager.getString(resultSet,4));
            prpCitemCarDto.setCarInsuredRelation(dbManager.getString(resultSet,5));
            prpCitemCarDto.setCarOwner(dbManager.getString(resultSet,6));
            prpCitemCarDto.setClauseType(dbManager.getString(resultSet,7));
            prpCitemCarDto.setAgreeDriverFlag(dbManager.getString(resultSet,8));
            prpCitemCarDto.setNewDeviceFlag(dbManager.getString(resultSet,9));
            prpCitemCarDto.setCarPolicyno(dbManager.getString(resultSet,10));
            prpCitemCarDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpCitemCarDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpCitemCarDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpCitemCarDto.setHKFlag(dbManager.getString(resultSet,14));
            prpCitemCarDto.setHKLicenseNo(dbManager.getString(resultSet,15));
            prpCitemCarDto.setEngineNo(dbManager.getString(resultSet,16));
            prpCitemCarDto.setVINNo(dbManager.getString(resultSet,17));
            prpCitemCarDto.setFrameNo(dbManager.getString(resultSet,18));
            prpCitemCarDto.setRunAreaCode(dbManager.getString(resultSet,19));
            prpCitemCarDto.setRunAreaName(dbManager.getString(resultSet,20));
            prpCitemCarDto.setRunMiles(dbManager.getDouble(resultSet,21));
            prpCitemCarDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpCitemCarDto.setUseYears(dbManager.getInt(resultSet,23));
            prpCitemCarDto.setModelCode(dbManager.getString(resultSet,24));
            prpCitemCarDto.setBrandName(dbManager.getString(resultSet,25));
            prpCitemCarDto.setCountryNature(dbManager.getString(resultSet,26));
            prpCitemCarDto.setCountryCode(dbManager.getString(resultSet,27));
            prpCitemCarDto.setUseNatureCode(dbManager.getString(resultSet,28));
            prpCitemCarDto.setBusinessClassCode(dbManager.getString(resultSet,29));
            prpCitemCarDto.setSeatCount(dbManager.getLong(resultSet,30));
            prpCitemCarDto.setTonCount(dbManager.getDouble(resultSet,31));
            prpCitemCarDto.setExhaustScale(dbManager.getDouble(resultSet,32));
            prpCitemCarDto.setColorCode(dbManager.getString(resultSet,33));
            prpCitemCarDto.setSafeDevice(dbManager.getString(resultSet,34));
            prpCitemCarDto.setParkSite(dbManager.getString(resultSet,35));
            prpCitemCarDto.setOwnerAddress(dbManager.getString(resultSet,36));
            prpCitemCarDto.setOtherNature(dbManager.getString(resultSet,37));
            prpCitemCarDto.setRateCode(dbManager.getString(resultSet,38));
            prpCitemCarDto.setMakeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,39));
            prpCitemCarDto.setCarUsage(dbManager.getString(resultSet,40));
            prpCitemCarDto.setCurrency(dbManager.getString(resultSet,41));
            prpCitemCarDto.setPurchasePrice(dbManager.getDouble(resultSet,42));
            prpCitemCarDto.setActualValue(dbManager.getDouble(resultSet,43));
            prpCitemCarDto.setInvoiceNo(dbManager.getString(resultSet,44));
            prpCitemCarDto.setCarLoanFlag(dbManager.getString(resultSet,45));
            prpCitemCarDto.setInsurerCode(dbManager.getString(resultSet,46));
            prpCitemCarDto.setLastInsurer(dbManager.getString(resultSet,47));
            prpCitemCarDto.setCarCheckStatus(dbManager.getString(resultSet,48));
            prpCitemCarDto.setCarChecker(dbManager.getString(resultSet,49));
            prpCitemCarDto.setCarCheckTime(dbManager.getString(resultSet,50));
            prpCitemCarDto.setSpecialTreat(dbManager.getDouble(resultSet,51));
            prpCitemCarDto.setRelievingAreaCode(dbManager.getString(resultSet,52));
            prpCitemCarDto.setAddonCount(dbManager.getLong(resultSet,53));
            prpCitemCarDto.setCarDealerCode(dbManager.getString(resultSet,54));
            prpCitemCarDto.setCarDealerName(dbManager.getString(resultSet,55));
            prpCitemCarDto.setRemark(dbManager.getString(resultSet,56));
            prpCitemCarDto.setFlag(dbManager.getString(resultSet,57));
            prpCitemCarDto.setCarCheckReason(dbManager.getString(resultSet,58));
            prpCitemCarDto.setSvioLatedTimes(dbManager.getLong(resultSet,59));
            prpCitemCarDto.setLvioLatedTimes(dbManager.getLong(resultSet,60));
            prpCitemCarDto.setLicenseKindCode(dbManager.getString(resultSet,61));
        }
        resultSet.close();
        return prpCitemCarDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("InsuredTypeCode,");
        buffer.append("CarInsuredRelation,");
        buffer.append("CarOwner,");
        buffer.append("ClauseType,");
        buffer.append("AgreeDriverFlag,");
        buffer.append("NewDeviceFlag,");
        buffer.append("CarPolicyno,");
        buffer.append("LicenseNo,");
        buffer.append("LicenseColorCode,");
        buffer.append("CarKindCode,");
        buffer.append("HKFlag,");
        buffer.append("HKLicenseNo,");
        buffer.append("EngineNo,");
        buffer.append("VINNo,");
        buffer.append("FrameNo,");
        buffer.append("RunAreaCode,");
        buffer.append("RunAreaName,");
        buffer.append("RunMiles,");
        buffer.append("EnrollDate,");
        buffer.append("UseYears,");
        buffer.append("ModelCode,");
        buffer.append("BrandName,");
        buffer.append("CountryNature,");
        buffer.append("CountryCode,");
        buffer.append("UseNatureCode,");
        buffer.append("BusinessClassCode,");
        buffer.append("SeatCount,");
        buffer.append("TonCount,");
        buffer.append("ExhaustScale,");
        buffer.append("ColorCode,");
        buffer.append("SafeDevice,");
        buffer.append("ParkSite,");
        buffer.append("OwnerAddress,");
        buffer.append("OtherNature,");
        buffer.append("RateCode,");
        buffer.append("MakeDate,");
        buffer.append("CarUsage,");
        buffer.append("Currency,");
        buffer.append("PurchasePrice,");
        buffer.append("ActualValue,");
        buffer.append("InvoiceNo,");
        buffer.append("CarLoanFlag,");
        buffer.append("InsurerCode,");
        buffer.append("LastInsurer,");
        buffer.append("CarCheckStatus,");
        buffer.append("CarChecker,");
        buffer.append("CarCheckTime,");
        buffer.append("SpecialTreat,");
        buffer.append("RelievingAreaCode,");
        buffer.append("AddonCount,");
        buffer.append("CarDealerCode,");
        buffer.append("CarDealerName,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("CarCheckReason,");
        buffer.append("SvioLatedTimes,");
        buffer.append("LvioLatedTimes,");
        buffer.append("LicenseKindCode ");
        buffer.append("FROM PrpCitemCar WHERE ");
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
        PrpCitemCarDto prpCitemCarDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCitemCarDto = new PrpCitemCarDto();
            prpCitemCarDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemCarDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemCarDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemCarDto.setInsuredTypeCode(dbManager.getString(resultSet,4));
            prpCitemCarDto.setCarInsuredRelation(dbManager.getString(resultSet,5));
            prpCitemCarDto.setCarOwner(dbManager.getString(resultSet,6));
            prpCitemCarDto.setClauseType(dbManager.getString(resultSet,7));
            prpCitemCarDto.setAgreeDriverFlag(dbManager.getString(resultSet,8));
            prpCitemCarDto.setNewDeviceFlag(dbManager.getString(resultSet,9));
            prpCitemCarDto.setCarPolicyno(dbManager.getString(resultSet,10));
            prpCitemCarDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpCitemCarDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpCitemCarDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpCitemCarDto.setHKFlag(dbManager.getString(resultSet,14));
            prpCitemCarDto.setHKLicenseNo(dbManager.getString(resultSet,15));
            prpCitemCarDto.setEngineNo(dbManager.getString(resultSet,16));
            prpCitemCarDto.setVINNo(dbManager.getString(resultSet,17));
            prpCitemCarDto.setFrameNo(dbManager.getString(resultSet,18));
            prpCitemCarDto.setRunAreaCode(dbManager.getString(resultSet,19));
            prpCitemCarDto.setRunAreaName(dbManager.getString(resultSet,20));
            prpCitemCarDto.setRunMiles(dbManager.getDouble(resultSet,21));
            prpCitemCarDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            prpCitemCarDto.setUseYears(dbManager.getInt(resultSet,23));
            prpCitemCarDto.setModelCode(dbManager.getString(resultSet,24));
            prpCitemCarDto.setBrandName(dbManager.getString(resultSet,25));
            prpCitemCarDto.setCountryNature(dbManager.getString(resultSet,26));
            prpCitemCarDto.setCountryCode(dbManager.getString(resultSet,27));
            prpCitemCarDto.setUseNatureCode(dbManager.getString(resultSet,28));
            prpCitemCarDto.setBusinessClassCode(dbManager.getString(resultSet,29));
            prpCitemCarDto.setSeatCount(dbManager.getLong(resultSet,30));
            prpCitemCarDto.setTonCount(dbManager.getDouble(resultSet,31));
            prpCitemCarDto.setExhaustScale(dbManager.getDouble(resultSet,32));
            prpCitemCarDto.setColorCode(dbManager.getString(resultSet,33));
            prpCitemCarDto.setSafeDevice(dbManager.getString(resultSet,34));
            prpCitemCarDto.setParkSite(dbManager.getString(resultSet,35));
            prpCitemCarDto.setOwnerAddress(dbManager.getString(resultSet,36));
            prpCitemCarDto.setOtherNature(dbManager.getString(resultSet,37));
            prpCitemCarDto.setRateCode(dbManager.getString(resultSet,38));
            prpCitemCarDto.setMakeDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,39));
            prpCitemCarDto.setCarUsage(dbManager.getString(resultSet,40));
            prpCitemCarDto.setCurrency(dbManager.getString(resultSet,41));
            prpCitemCarDto.setPurchasePrice(dbManager.getDouble(resultSet,42));
            prpCitemCarDto.setActualValue(dbManager.getDouble(resultSet,43));
            prpCitemCarDto.setInvoiceNo(dbManager.getString(resultSet,44));
            prpCitemCarDto.setCarLoanFlag(dbManager.getString(resultSet,45));
            prpCitemCarDto.setInsurerCode(dbManager.getString(resultSet,46));
            prpCitemCarDto.setLastInsurer(dbManager.getString(resultSet,47));
            prpCitemCarDto.setCarCheckStatus(dbManager.getString(resultSet,48));
            prpCitemCarDto.setCarChecker(dbManager.getString(resultSet,49));
            prpCitemCarDto.setCarCheckTime(dbManager.getString(resultSet,50));
            prpCitemCarDto.setSpecialTreat(dbManager.getDouble(resultSet,51));
            prpCitemCarDto.setRelievingAreaCode(dbManager.getString(resultSet,52));
            prpCitemCarDto.setAddonCount(dbManager.getLong(resultSet,53));
            prpCitemCarDto.setCarDealerCode(dbManager.getString(resultSet,54));
            prpCitemCarDto.setCarDealerName(dbManager.getString(resultSet,55));
            prpCitemCarDto.setRemark(dbManager.getString(resultSet,56));
            prpCitemCarDto.setFlag(dbManager.getString(resultSet,57));
            prpCitemCarDto.setCarCheckReason(dbManager.getString(resultSet,58));
            prpCitemCarDto.setSvioLatedTimes(dbManager.getLong(resultSet,59));
            prpCitemCarDto.setLvioLatedTimes(dbManager.getLong(resultSet,60));
            prpCitemCarDto.setLicenseKindCode(dbManager.getString(resultSet,61));
            collection.add(prpCitemCarDto);
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
        buffer.append("DELETE FROM PrpCitemCar WHERE ");
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
        statement="SELECT count(1) FROM PrpCitemCar WHERE ";
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
