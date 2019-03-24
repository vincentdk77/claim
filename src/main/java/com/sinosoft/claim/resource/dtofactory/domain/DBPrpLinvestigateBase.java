package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinvestigateDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLinvestigate-案情调查信息表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.359<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLinvestigateBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLinvestigateBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinvestigateBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void insert(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        String mainStatement = " Insert Into PrpLinvestigate (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ObjectType," + 
                           " InformantName," + 
                           " InformantStatus," + 
                           " ObjectName," + 
                           " ObjectUnit," + 
                           " ObjectAddress," + 
                           " ObjectPhone," + 
                           " YearIncome," + 
                           " IdentifyNumber," + 
                           " BusinessCode," + 
                           " LoanAmount," + 
                           " SumRePaid," + 
                           " ArrearageCorpus," + 
                           " LastRepaidDate," + 
                           " ArrearageDate," + 
                           " LicenseNo," + 
                           " BrandName," + 
                           " PurchasePrice," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " UseNature," + 
                           " PurchaseDate," + 
                           " EnrollDate," + 
                           " InpawnEnrollDept," + 
                           " InpawnEnrollDate," + 
                           " GuarantyName," + 
                           " GuarantyRetractFlg," + 
                           " GuarantyAssessment," + 
                           " GatheringWay," + 
                           " ArrearReasonCode," + 
                           " ArrearReasonName," + 
                           " Remark," + 
                           " Conclution," + 
                           " Investigator," + 
                           " InvestigateDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLinvestigateDto.getRegistNo() + "'," + 
                           "'" + prpLinvestigateDto.getRiskCode() + "'," + 
                           "'" + prpLinvestigateDto.getPolicyNo() + "'," + 
                           "" + prpLinvestigateDto.getSerialNo() + "," + 
                           "'" + prpLinvestigateDto.getObjectType() + "'," + 
                           "'" + prpLinvestigateDto.getInformantName() + "'," + 
                           "'" + prpLinvestigateDto.getInformantStatus() + "'," + 
                           "'" + prpLinvestigateDto.getObjectName() + "'," + 
                           "'" + prpLinvestigateDto.getObjectUnit() + "'," + 
                           "'" + prpLinvestigateDto.getObjectAddress() + "'," + 
                           "'" + prpLinvestigateDto.getObjectPhone() + "'," + 
                           "'" + prpLinvestigateDto.getYearIncome() + "'," + 
                           "'" + prpLinvestigateDto.getIdentifyNumber() + "'," + 
                           "'" + prpLinvestigateDto.getBusinessCode() + "'," + 
                           "'" + prpLinvestigateDto.getLoanAmount() + "'," + 
                           "'" + prpLinvestigateDto.getSumRePaid() + "'," + 
                           "'" + prpLinvestigateDto.getArrearageCorpus() + "'," + 
                           "'" + prpLinvestigateDto.getLastRepaidDate() + "'," + 
                           "'" + prpLinvestigateDto.getArrearageDate() + "'," + 
                           "'" + prpLinvestigateDto.getLicenseNo() + "'," + 
                           "'" + prpLinvestigateDto.getBrandName() + "'," + 
                           "'" + prpLinvestigateDto.getPurchasePrice() + "'," + 
                           "'" + prpLinvestigateDto.getEngineNo() + "'," + 
                           "'" + prpLinvestigateDto.getFrameNo() + "'," + 
                           "'" + prpLinvestigateDto.getUseNature() + "'," + 
                           "'" + prpLinvestigateDto.getPurchaseDate() + "'," + 
                           "'" + prpLinvestigateDto.getEnrollDate() + "'," + 
                           "'" + prpLinvestigateDto.getInpawnEnrollDept() + "'," + 
                           "'" + prpLinvestigateDto.getInpawnEnrollDate() + "'," + 
                           "'" + prpLinvestigateDto.getGuarantyName() + "'," + 
                           "'" + prpLinvestigateDto.getGuarantyRetractFlg() + "'," + 
                           "'" + prpLinvestigateDto.getGuarantyAssessment() + "'," + 
                           "'" + prpLinvestigateDto.getGatheringWay() + "'," + 
                           "'" + prpLinvestigateDto.getArrearReasonCode() + "'," + 
                           "'" + prpLinvestigateDto.getArrearReasonName() + "'," + 
                           "'" + prpLinvestigateDto.getRemark() + "'," + 
                           "'" + prpLinvestigateDto.getConclution() + "'," + 
                           "'" + prpLinvestigateDto.getInvestigator() + "'," + 
                           "'" + prpLinvestigateDto.getInvestigateDate() + "'," + 
                           "'" + prpLinvestigateDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLinvestigateDto.getRegistNo());
        dbManager.setString(2,prpLinvestigateDto.getRiskCode());
        dbManager.setString(3,prpLinvestigateDto.getPolicyNo());
        dbManager.setInt(4,prpLinvestigateDto.getSerialNo());
        dbManager.setString(5,prpLinvestigateDto.getObjectType());
        dbManager.setString(6,prpLinvestigateDto.getInformantName());
        dbManager.setString(7,prpLinvestigateDto.getInformantStatus());
        dbManager.setString(8,prpLinvestigateDto.getObjectName());
        dbManager.setString(9,prpLinvestigateDto.getObjectUnit());
        dbManager.setString(10,prpLinvestigateDto.getObjectAddress());
        dbManager.setString(11,prpLinvestigateDto.getObjectPhone());
        dbManager.setDouble(12,prpLinvestigateDto.getYearIncome());
        dbManager.setString(13,prpLinvestigateDto.getIdentifyNumber());
        dbManager.setString(14,prpLinvestigateDto.getBusinessCode());
        dbManager.setDouble(15,prpLinvestigateDto.getLoanAmount());
        dbManager.setDouble(16,prpLinvestigateDto.getSumRePaid());
        dbManager.setDouble(17,prpLinvestigateDto.getArrearageCorpus());
        dbManager.setDateTime(18,prpLinvestigateDto.getLastRepaidDate());
        dbManager.setDateTime(19,prpLinvestigateDto.getArrearageDate());
        dbManager.setString(20,prpLinvestigateDto.getLicenseNo());
        dbManager.setString(21,prpLinvestigateDto.getBrandName());
        dbManager.setDouble(22,prpLinvestigateDto.getPurchasePrice());
        dbManager.setString(23,prpLinvestigateDto.getEngineNo());
        dbManager.setString(24,prpLinvestigateDto.getFrameNo());
        dbManager.setString(25,prpLinvestigateDto.getUseNature());
        dbManager.setDateTime(26,prpLinvestigateDto.getPurchaseDate());
        dbManager.setDateTime(27,prpLinvestigateDto.getEnrollDate());
        dbManager.setString(28,prpLinvestigateDto.getInpawnEnrollDept());
        dbManager.setDateTime(29,prpLinvestigateDto.getInpawnEnrollDate());
        dbManager.setString(30,prpLinvestigateDto.getGuarantyName());
        dbManager.setString(31,prpLinvestigateDto.getGuarantyRetractFlg());
        dbManager.setDouble(32,prpLinvestigateDto.getGuarantyAssessment());
        dbManager.setString(33,prpLinvestigateDto.getGatheringWay());
        dbManager.setString(34,prpLinvestigateDto.getArrearReasonCode());
        dbManager.setString(35,prpLinvestigateDto.getArrearReasonName());
        dbManager.setString(36,prpLinvestigateDto.getRemark());
        dbManager.setString(37,prpLinvestigateDto.getConclution());
        dbManager.setString(38,prpLinvestigateDto.getInvestigator());
        dbManager.setDateTime(39,prpLinvestigateDto.getInvestigateDate());
        dbManager.setString(40,prpLinvestigateDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLinvestigateBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLinvestigate (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ObjectType," + 
                           " InformantName," + 
                           " InformantStatus," + 
                           " ObjectName," + 
                           " ObjectUnit," + 
                           " ObjectAddress," + 
                           " ObjectPhone," + 
                           " YearIncome," + 
                           " IdentifyNumber," + 
                           " BusinessCode," + 
                           " LoanAmount," + 
                           " SumRePaid," + 
                           " ArrearageCorpus," + 
                           " LastRepaidDate," + 
                           " ArrearageDate," + 
                           " LicenseNo," + 
                           " BrandName," + 
                           " PurchasePrice," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " UseNature," + 
                           " PurchaseDate," + 
                           " EnrollDate," + 
                           " InpawnEnrollDept," + 
                           " InpawnEnrollDate," + 
                           " GuarantyName," + 
                           " GuarantyRetractFlg," + 
                           " GuarantyAssessment," + 
                           " GatheringWay," + 
                           " ArrearReasonCode," + 
                           " ArrearReasonName," + 
                           " Remark," + 
                           " Conclution," + 
                           " Investigator," + 
                           " InvestigateDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinvestigateDto prpLinvestigateDto = (PrpLinvestigateDto)i.next();
            dbManager.setString(1,prpLinvestigateDto.getRegistNo());
            dbManager.setString(2,prpLinvestigateDto.getRiskCode());
            dbManager.setString(3,prpLinvestigateDto.getPolicyNo());
            dbManager.setInt(4,prpLinvestigateDto.getSerialNo());
            dbManager.setString(5,prpLinvestigateDto.getObjectType());
            dbManager.setString(6,prpLinvestigateDto.getInformantName());
            dbManager.setString(7,prpLinvestigateDto.getInformantStatus());
            dbManager.setString(8,prpLinvestigateDto.getObjectName());
            dbManager.setString(9,prpLinvestigateDto.getObjectUnit());
            dbManager.setString(10,prpLinvestigateDto.getObjectAddress());
            dbManager.setString(11,prpLinvestigateDto.getObjectPhone());
            dbManager.setDouble(12,prpLinvestigateDto.getYearIncome());
            dbManager.setString(13,prpLinvestigateDto.getIdentifyNumber());
            dbManager.setString(14,prpLinvestigateDto.getBusinessCode());
            dbManager.setDouble(15,prpLinvestigateDto.getLoanAmount());
            dbManager.setDouble(16,prpLinvestigateDto.getSumRePaid());
            dbManager.setDouble(17,prpLinvestigateDto.getArrearageCorpus());
            dbManager.setDateTime(18,prpLinvestigateDto.getLastRepaidDate());
            dbManager.setDateTime(19,prpLinvestigateDto.getArrearageDate());
            dbManager.setString(20,prpLinvestigateDto.getLicenseNo());
            dbManager.setString(21,prpLinvestigateDto.getBrandName());
            dbManager.setDouble(22,prpLinvestigateDto.getPurchasePrice());
            dbManager.setString(23,prpLinvestigateDto.getEngineNo());
            dbManager.setString(24,prpLinvestigateDto.getFrameNo());
            dbManager.setString(25,prpLinvestigateDto.getUseNature());
            dbManager.setDateTime(26,prpLinvestigateDto.getPurchaseDate());
            dbManager.setDateTime(27,prpLinvestigateDto.getEnrollDate());
            dbManager.setString(28,prpLinvestigateDto.getInpawnEnrollDept());
            dbManager.setDateTime(29,prpLinvestigateDto.getInpawnEnrollDate());
            dbManager.setString(30,prpLinvestigateDto.getGuarantyName());
            dbManager.setString(31,prpLinvestigateDto.getGuarantyRetractFlg());
            dbManager.setDouble(32,prpLinvestigateDto.getGuarantyAssessment());
            dbManager.setString(33,prpLinvestigateDto.getGatheringWay());
            dbManager.setString(34,prpLinvestigateDto.getArrearReasonCode());
            dbManager.setString(35,prpLinvestigateDto.getArrearReasonName());
            dbManager.setString(36,prpLinvestigateDto.getRemark());
            dbManager.setString(37,prpLinvestigateDto.getConclution());
            dbManager.setString(38,prpLinvestigateDto.getInvestigator());
            dbManager.setDateTime(39,prpLinvestigateDto.getInvestigateDate());
            dbManager.setString(40,prpLinvestigateDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLinvestigateBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String objectType) throws Exception{
        String statement = " Delete From PrpLinvestigate" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ObjectType = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLinvestigate Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " ObjectType = '" + objectType + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,objectType);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLinvestigateBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinvestigateDto prpLinvestigateDto
     * @throws Exception
     */
    public void update(PrpLinvestigateDto prpLinvestigateDto) throws Exception{
        String statement = " Update PrpLinvestigate Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " InformantName = ?," + 
                           " InformantStatus = ?," + 
                           " ObjectName = ?," + 
                           " ObjectUnit = ?," + 
                           " ObjectAddress = ?," + 
                           " ObjectPhone = ?," + 
                           " YearIncome = ?," + 
                           " IdentifyNumber = ?," + 
                           " BusinessCode = ?," + 
                           " LoanAmount = ?," + 
                           " SumRePaid = ?," + 
                           " ArrearageCorpus = ?," + 
                           " LastRepaidDate = ?," + 
                           " ArrearageDate = ?," + 
                           " LicenseNo = ?," + 
                           " BrandName = ?," + 
                           " PurchasePrice = ?," + 
                           " EngineNo = ?," + 
                           " FrameNo = ?," + 
                           " UseNature = ?," + 
                           " PurchaseDate = ?," + 
                           " EnrollDate = ?," + 
                           " InpawnEnrollDept = ?," + 
                           " InpawnEnrollDate = ?," + 
                           " GuarantyName = ?," + 
                           " GuarantyRetractFlg = ?," + 
                           " GuarantyAssessment = ?," + 
                           " GatheringWay = ?," + 
                           " ArrearReasonCode = ?," + 
                           " ArrearReasonName = ?," + 
                           " Remark = ?," + 
                           " Conclution = ?," + 
                           " Investigator = ?," + 
                           " InvestigateDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ObjectType = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLinvestigate Set " + 
                           " RegistNo = '" + prpLinvestigateDto.getRegistNo() + "'," + 
                           " RiskCode = '" + prpLinvestigateDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLinvestigateDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLinvestigateDto.getSerialNo() + "," + 
                           " ObjectType = '" + prpLinvestigateDto.getObjectType() + "'," + 
                           " InformantName = '" + prpLinvestigateDto.getInformantName() + "'," + 
                           " InformantStatus = '" + prpLinvestigateDto.getInformantStatus() + "'," + 
                           " ObjectName = '" + prpLinvestigateDto.getObjectName() + "'," + 
                           " ObjectUnit = '" + prpLinvestigateDto.getObjectUnit() + "'," + 
                           " ObjectAddress = '" + prpLinvestigateDto.getObjectAddress() + "'," + 
                           " ObjectPhone = '" + prpLinvestigateDto.getObjectPhone() + "'," + 
                           " YearIncome = '" + prpLinvestigateDto.getYearIncome() + "'," + 
                           " IdentifyNumber = '" + prpLinvestigateDto.getIdentifyNumber() + "'," + 
                           " BusinessCode = '" + prpLinvestigateDto.getBusinessCode() + "'," + 
                           " LoanAmount = '" + prpLinvestigateDto.getLoanAmount() + "'," + 
                           " SumRePaid = '" + prpLinvestigateDto.getSumRePaid() + "'," + 
                           " ArrearageCorpus = '" + prpLinvestigateDto.getArrearageCorpus() + "'," + 
                           " LastRepaidDate = '" + prpLinvestigateDto.getLastRepaidDate() + "'," + 
                           " ArrearageDate = '" + prpLinvestigateDto.getArrearageDate() + "'," + 
                           " LicenseNo = '" + prpLinvestigateDto.getLicenseNo() + "'," + 
                           " BrandName = '" + prpLinvestigateDto.getBrandName() + "'," + 
                           " PurchasePrice = '" + prpLinvestigateDto.getPurchasePrice() + "'," + 
                           " EngineNo = '" + prpLinvestigateDto.getEngineNo() + "'," + 
                           " FrameNo = '" + prpLinvestigateDto.getFrameNo() + "'," + 
                           " UseNature = '" + prpLinvestigateDto.getUseNature() + "'," + 
                           " PurchaseDate = '" + prpLinvestigateDto.getPurchaseDate() + "'," + 
                           " EnrollDate = '" + prpLinvestigateDto.getEnrollDate() + "'," + 
                           " InpawnEnrollDept = '" + prpLinvestigateDto.getInpawnEnrollDept() + "'," + 
                           " InpawnEnrollDate = '" + prpLinvestigateDto.getInpawnEnrollDate() + "'," + 
                           " GuarantyName = '" + prpLinvestigateDto.getGuarantyName() + "'," + 
                           " GuarantyRetractFlg = '" + prpLinvestigateDto.getGuarantyRetractFlg() + "'," + 
                           " GuarantyAssessment = '" + prpLinvestigateDto.getGuarantyAssessment() + "'," + 
                           " GatheringWay = '" + prpLinvestigateDto.getGatheringWay() + "'," + 
                           " ArrearReasonCode = '" + prpLinvestigateDto.getArrearReasonCode() + "'," + 
                           " ArrearReasonName = '" + prpLinvestigateDto.getArrearReasonName() + "'," + 
                           " Remark = '" + prpLinvestigateDto.getRemark() + "'," + 
                           " Conclution = '" + prpLinvestigateDto.getConclution() + "'," + 
                           " Investigator = '" + prpLinvestigateDto.getInvestigator() + "'," + 
                           " InvestigateDate = '" + prpLinvestigateDto.getInvestigateDate() + "'," + 
                           " Flag = '" + prpLinvestigateDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLinvestigateDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLinvestigateDto.getSerialNo() + " And " + 
                           " ObjectType = '" + prpLinvestigateDto.getObjectType() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLinvestigateDto.getRiskCode());
        dbManager.setString(2,prpLinvestigateDto.getPolicyNo());
        dbManager.setString(3,prpLinvestigateDto.getInformantName());
        dbManager.setString(4,prpLinvestigateDto.getInformantStatus());
        dbManager.setString(5,prpLinvestigateDto.getObjectName());
        dbManager.setString(6,prpLinvestigateDto.getObjectUnit());
        dbManager.setString(7,prpLinvestigateDto.getObjectAddress());
        dbManager.setString(8,prpLinvestigateDto.getObjectPhone());
        dbManager.setDouble(9,prpLinvestigateDto.getYearIncome());
        dbManager.setString(10,prpLinvestigateDto.getIdentifyNumber());
        dbManager.setString(11,prpLinvestigateDto.getBusinessCode());
        dbManager.setDouble(12,prpLinvestigateDto.getLoanAmount());
        dbManager.setDouble(13,prpLinvestigateDto.getSumRePaid());
        dbManager.setDouble(14,prpLinvestigateDto.getArrearageCorpus());
        dbManager.setDateTime(15,prpLinvestigateDto.getLastRepaidDate());
        dbManager.setDateTime(16,prpLinvestigateDto.getArrearageDate());
        dbManager.setString(17,prpLinvestigateDto.getLicenseNo());
        dbManager.setString(18,prpLinvestigateDto.getBrandName());
        dbManager.setDouble(19,prpLinvestigateDto.getPurchasePrice());
        dbManager.setString(20,prpLinvestigateDto.getEngineNo());
        dbManager.setString(21,prpLinvestigateDto.getFrameNo());
        dbManager.setString(22,prpLinvestigateDto.getUseNature());
        dbManager.setDateTime(23,prpLinvestigateDto.getPurchaseDate());
        dbManager.setDateTime(24,prpLinvestigateDto.getEnrollDate());
        dbManager.setString(25,prpLinvestigateDto.getInpawnEnrollDept());
        dbManager.setDateTime(26,prpLinvestigateDto.getInpawnEnrollDate());
        dbManager.setString(27,prpLinvestigateDto.getGuarantyName());
        dbManager.setString(28,prpLinvestigateDto.getGuarantyRetractFlg());
        dbManager.setDouble(29,prpLinvestigateDto.getGuarantyAssessment());
        dbManager.setString(30,prpLinvestigateDto.getGatheringWay());
        dbManager.setString(31,prpLinvestigateDto.getArrearReasonCode());
        dbManager.setString(32,prpLinvestigateDto.getArrearReasonName());
        dbManager.setString(33,prpLinvestigateDto.getRemark());
        dbManager.setString(34,prpLinvestigateDto.getConclution());
        dbManager.setString(35,prpLinvestigateDto.getInvestigator());
        dbManager.setDateTime(36,prpLinvestigateDto.getInvestigateDate());
        dbManager.setString(37,prpLinvestigateDto.getFlag());
        //设置条件字段;
        dbManager.setString(38,prpLinvestigateDto.getRegistNo());
        dbManager.setInt(39,prpLinvestigateDto.getSerialNo());
        dbManager.setString(40,prpLinvestigateDto.getObjectType());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLinvestigateBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param serialNo 序号
     * @param objectType 调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @return PrpLinvestigateDto
     * @throws Exception
     */
    public PrpLinvestigateDto findByPrimaryKey(String registNo,int serialNo,String objectType) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ObjectType," + 
                           " InformantName," + 
                           " InformantStatus," + 
                           " ObjectName," + 
                           " ObjectUnit," + 
                           " ObjectAddress," + 
                           " ObjectPhone," + 
                           " YearIncome," + 
                           " IdentifyNumber," + 
                           " BusinessCode," + 
                           " LoanAmount," + 
                           " SumRePaid," + 
                           " ArrearageCorpus," + 
                           " LastRepaidDate," + 
                           " ArrearageDate," + 
                           " LicenseNo," + 
                           " BrandName," + 
                           " PurchasePrice," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " UseNature," + 
                           " PurchaseDate," + 
                           " EnrollDate," + 
                           " InpawnEnrollDept," + 
                           " InpawnEnrollDate," + 
                           " GuarantyName," + 
                           " GuarantyRetractFlg," + 
                           " GuarantyAssessment," + 
                           " GatheringWay," + 
                           " ArrearReasonCode," + 
                           " ArrearReasonName," + 
                           " Remark," + 
                           " Conclution," + 
                           " Investigator," + 
                           " InvestigateDate," + 
                           " Flag From PrpLinvestigate";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ObjectType = ?";
        PrpLinvestigateDto prpLinvestigateDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " ObjectType = '" + objectType + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,objectType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLinvestigateDto = new PrpLinvestigateDto();
            prpLinvestigateDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLinvestigateDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLinvestigateDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLinvestigateDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLinvestigateDto.setObjectType(dbManager.getString(resultSet,5));
            prpLinvestigateDto.setInformantName(dbManager.getString(resultSet,6));
            prpLinvestigateDto.setInformantStatus(dbManager.getString(resultSet,7));
            prpLinvestigateDto.setObjectName(dbManager.getString(resultSet,8));
            prpLinvestigateDto.setObjectUnit(dbManager.getString(resultSet,9));
            prpLinvestigateDto.setObjectAddress(dbManager.getString(resultSet,10));
            prpLinvestigateDto.setObjectPhone(dbManager.getString(resultSet,11));
            prpLinvestigateDto.setYearIncome(dbManager.getDouble(resultSet,12));
            prpLinvestigateDto.setIdentifyNumber(dbManager.getString(resultSet,13));
            prpLinvestigateDto.setBusinessCode(dbManager.getString(resultSet,14));
            prpLinvestigateDto.setLoanAmount(dbManager.getDouble(resultSet,15));
            prpLinvestigateDto.setSumRePaid(dbManager.getDouble(resultSet,16));
            prpLinvestigateDto.setArrearageCorpus(dbManager.getDouble(resultSet,17));
            prpLinvestigateDto.setLastRepaidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLinvestigateDto.setArrearageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLinvestigateDto.setLicenseNo(dbManager.getString(resultSet,20));
            prpLinvestigateDto.setBrandName(dbManager.getString(resultSet,21));
            prpLinvestigateDto.setPurchasePrice(dbManager.getDouble(resultSet,22));
            prpLinvestigateDto.setEngineNo(dbManager.getString(resultSet,23));
            prpLinvestigateDto.setFrameNo(dbManager.getString(resultSet,24));
            prpLinvestigateDto.setUseNature(dbManager.getString(resultSet,25));
            prpLinvestigateDto.setPurchaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpLinvestigateDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLinvestigateDto.setInpawnEnrollDept(dbManager.getString(resultSet,28));
            prpLinvestigateDto.setInpawnEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLinvestigateDto.setGuarantyName(dbManager.getString(resultSet,30));
            prpLinvestigateDto.setGuarantyRetractFlg(dbManager.getString(resultSet,31));
            prpLinvestigateDto.setGuarantyAssessment(dbManager.getDouble(resultSet,32));
            prpLinvestigateDto.setGatheringWay(dbManager.getString(resultSet,33));
            prpLinvestigateDto.setArrearReasonCode(dbManager.getString(resultSet,34));
            prpLinvestigateDto.setArrearReasonName(dbManager.getString(resultSet,35));
            prpLinvestigateDto.setRemark(dbManager.getString(resultSet,36));
            prpLinvestigateDto.setConclution(dbManager.getString(resultSet,37));
            prpLinvestigateDto.setInvestigator(dbManager.getString(resultSet,38));
            prpLinvestigateDto.setInvestigateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,39));
            prpLinvestigateDto.setFlag(dbManager.getString(resultSet,40));
            logger.info("DBPrpLinvestigateBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLinvestigateBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLinvestigateDto;
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
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ObjectType," + 
                           " InformantName," + 
                           " InformantStatus," + 
                           " ObjectName," + 
                           " ObjectUnit," + 
                           " ObjectAddress," + 
                           " ObjectPhone," + 
                           " YearIncome," + 
                           " IdentifyNumber," + 
                           " BusinessCode," + 
                           " LoanAmount," + 
                           " SumRePaid," + 
                           " ArrearageCorpus," + 
                           " LastRepaidDate," + 
                           " ArrearageDate," + 
                           " LicenseNo," + 
                           " BrandName," + 
                           " PurchasePrice," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " UseNature," + 
                           " PurchaseDate," + 
                           " EnrollDate," + 
                           " InpawnEnrollDept," + 
                           " InpawnEnrollDate," + 
                           " GuarantyName," + 
                           " GuarantyRetractFlg," + 
                           " GuarantyAssessment," + 
                           " GatheringWay," + 
                           " ArrearReasonCode," + 
                           " ArrearReasonName," + 
                           " Remark," + 
                           " Conclution," + 
                           " Investigator," + 
                           " InvestigateDate," + 
                           " Flag From PrpLinvestigate Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLinvestigateDto prpLinvestigateDto = null;
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

            prpLinvestigateDto = new PrpLinvestigateDto();
            prpLinvestigateDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLinvestigateDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLinvestigateDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLinvestigateDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLinvestigateDto.setObjectType(dbManager.getString(resultSet,5));
            prpLinvestigateDto.setInformantName(dbManager.getString(resultSet,6));
            prpLinvestigateDto.setInformantStatus(dbManager.getString(resultSet,7));
            prpLinvestigateDto.setObjectName(dbManager.getString(resultSet,8));
            prpLinvestigateDto.setObjectUnit(dbManager.getString(resultSet,9));
            prpLinvestigateDto.setObjectAddress(dbManager.getString(resultSet,10));
            prpLinvestigateDto.setObjectPhone(dbManager.getString(resultSet,11));
            prpLinvestigateDto.setYearIncome(dbManager.getDouble(resultSet,12));
            prpLinvestigateDto.setIdentifyNumber(dbManager.getString(resultSet,13));
            prpLinvestigateDto.setBusinessCode(dbManager.getString(resultSet,14));
            prpLinvestigateDto.setLoanAmount(dbManager.getDouble(resultSet,15));
            prpLinvestigateDto.setSumRePaid(dbManager.getDouble(resultSet,16));
            prpLinvestigateDto.setArrearageCorpus(dbManager.getDouble(resultSet,17));
            prpLinvestigateDto.setLastRepaidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLinvestigateDto.setArrearageDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLinvestigateDto.setLicenseNo(dbManager.getString(resultSet,20));
            prpLinvestigateDto.setBrandName(dbManager.getString(resultSet,21));
            prpLinvestigateDto.setPurchasePrice(dbManager.getDouble(resultSet,22));
            prpLinvestigateDto.setEngineNo(dbManager.getString(resultSet,23));
            prpLinvestigateDto.setFrameNo(dbManager.getString(resultSet,24));
            prpLinvestigateDto.setUseNature(dbManager.getString(resultSet,25));
            prpLinvestigateDto.setPurchaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpLinvestigateDto.setEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLinvestigateDto.setInpawnEnrollDept(dbManager.getString(resultSet,28));
            prpLinvestigateDto.setInpawnEnrollDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLinvestigateDto.setGuarantyName(dbManager.getString(resultSet,30));
            prpLinvestigateDto.setGuarantyRetractFlg(dbManager.getString(resultSet,31));
            prpLinvestigateDto.setGuarantyAssessment(dbManager.getDouble(resultSet,32));
            prpLinvestigateDto.setGatheringWay(dbManager.getString(resultSet,33));
            prpLinvestigateDto.setArrearReasonCode(dbManager.getString(resultSet,34));
            prpLinvestigateDto.setArrearReasonName(dbManager.getString(resultSet,35));
            prpLinvestigateDto.setRemark(dbManager.getString(resultSet,36));
            prpLinvestigateDto.setConclution(dbManager.getString(resultSet,37));
            prpLinvestigateDto.setInvestigator(dbManager.getString(resultSet,38));
            prpLinvestigateDto.setInvestigateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,39));
            prpLinvestigateDto.setFlag(dbManager.getString(resultSet,40));
            collection.add(prpLinvestigateDto);
        }
        resultSet.close();
        logger.info("DBPrpLinvestigateBase.findByConditions() success!");
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
        String statement = "Delete From PrpLinvestigate Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLinvestigateBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLinvestigate Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLinvestigateBase.getCount() success!");
        return count;
    }
}
