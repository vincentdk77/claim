package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdParty-理赔车辆信息(修改)的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdPartyBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLthirdPartyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLthirdPartyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @throws Exception
     */
    public void insert(PrpLthirdPartyDto prpLthirdPartyDto) throws Exception{
        String mainStatement = " Insert Into PrpLthirdParty (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " ClaimNo," + 
                           " ClauseType," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " InsureCarFlag," + 
                           " CarOwner," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " RunDistance," + 
                           " UseYears," + 
                           " DutyPercent," + 
                           " InsuredFlag," + 
                           " InsureComCode," + 
                           " InsureComName," + 
                           " Flag," + 
                           " VINNo," +
                           " LossFlag," + 
                           " DriveName," +
                           " DriveLicensNo," +
                           " CarPolicyNo)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLthirdPartyDto.getRegistNo() + "'," + 
                           "'" + prpLthirdPartyDto.getRiskCode() + "'," + 
                           "" + prpLthirdPartyDto.getSerialNo() + "," + 
                           "'" + prpLthirdPartyDto.getClaimNo() + "'," + 
                           "'" + prpLthirdPartyDto.getClauseType() + "'," + 
                           "'" + prpLthirdPartyDto.getLicenseNo() + "'," + 
                           "'" + prpLthirdPartyDto.getLicenseColorCode() + "'," + 
                           "'" + prpLthirdPartyDto.getCarKindCode() + "'," + 
                           "'" + prpLthirdPartyDto.getInsureCarFlag() + "'," + 
                           "'" + prpLthirdPartyDto.getCarOwner() + "'," + 
                           "'" + prpLthirdPartyDto.getEngineNo() + "'," + 
                           "'" + prpLthirdPartyDto.getFrameNo() + "'," + 
                           "'" + prpLthirdPartyDto.getModelCode() + "'," + 
                           "'" + prpLthirdPartyDto.getBrandName() + "'," + 
                           "'" + prpLthirdPartyDto.getRunDistance() + "'," + 
                           "" + prpLthirdPartyDto.getUseYears() + "," + 
                           "'" + prpLthirdPartyDto.getDutyPercent() + "'," + 
                           "'" + prpLthirdPartyDto.getInsuredFlag() + "'," + 
                           "'" + prpLthirdPartyDto.getInsureComCode() + "'," + 
                           "'" + prpLthirdPartyDto.getInsureComName() + "'," + 
                           "'" + prpLthirdPartyDto.getFlag() + "'," + 
                           "'" + prpLthirdPartyDto.getVINNo() + "',"+
                           "'" + prpLthirdPartyDto.getLossFlag() + "'," + 
                           "'" + prpLthirdPartyDto.getPrpLthirdPartyDriveName() + "',"+
                           "'" + prpLthirdPartyDto.getPrpLthirdPartyDriveLicensNo() + "'," +
                           "'" + prpLthirdPartyDto.getCarPolicyNo() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLthirdPartyDto.getRegistNo());
        dbManager.setString(2,prpLthirdPartyDto.getRiskCode());
        dbManager.setInt(3,prpLthirdPartyDto.getSerialNo());
        dbManager.setString(4,prpLthirdPartyDto.getClaimNo());
        dbManager.setString(5,prpLthirdPartyDto.getClauseType());
        dbManager.setString(6,prpLthirdPartyDto.getLicenseNo());
        dbManager.setString(7,prpLthirdPartyDto.getLicenseColorCode());
        dbManager.setString(8,prpLthirdPartyDto.getCarKindCode());
        dbManager.setString(9,prpLthirdPartyDto.getInsureCarFlag());
        dbManager.setString(10,prpLthirdPartyDto.getCarOwner());
        dbManager.setString(11,prpLthirdPartyDto.getEngineNo());
        dbManager.setString(12,prpLthirdPartyDto.getFrameNo());
        dbManager.setString(13,prpLthirdPartyDto.getModelCode());
        dbManager.setString(14,prpLthirdPartyDto.getBrandName());
        dbManager.setDouble(15,prpLthirdPartyDto.getRunDistance());
        dbManager.setInt(16,prpLthirdPartyDto.getUseYears());
        dbManager.setDouble(17,prpLthirdPartyDto.getDutyPercent());
        dbManager.setString(18,prpLthirdPartyDto.getInsuredFlag());
        dbManager.setString(19,prpLthirdPartyDto.getInsureComCode());
        dbManager.setString(20,prpLthirdPartyDto.getInsureComName());
        dbManager.setString(21,prpLthirdPartyDto.getFlag());
        dbManager.setString(22,prpLthirdPartyDto.getVINNo());
        dbManager.setString(23,prpLthirdPartyDto.getLossFlag());
        dbManager.setString(24,prpLthirdPartyDto.getPrpLthirdPartyDriveName());
        dbManager.setString(25,prpLthirdPartyDto.getPrpLthirdPartyDriveLicensNo());
        dbManager.setString(26, prpLthirdPartyDto.getCarPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdPartyBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLthirdParty (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " ClaimNo," + 
                           " ClauseType," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " InsureCarFlag," + 
                           " CarOwner," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " RunDistance," + 
                           " UseYears," + 
                           " DutyPercent," + 
                           " InsuredFlag," + 
                           " InsureComCode," + 
                           " InsureComName," + 
                           " Flag," + 
                           " VINNo," +
                           " LossFlag," + 
                           " DriveName," +
                           " DriveLicensNo," +
                           " CarPolicyNo)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)i.next();
            dbManager.setString(1,prpLthirdPartyDto.getRegistNo());
            dbManager.setString(2,prpLthirdPartyDto.getRiskCode());
            dbManager.setInt(3,prpLthirdPartyDto.getSerialNo());
            dbManager.setString(4,prpLthirdPartyDto.getClaimNo());
            dbManager.setString(5,prpLthirdPartyDto.getClauseType());
            dbManager.setString(6,prpLthirdPartyDto.getLicenseNo());
            dbManager.setString(7,prpLthirdPartyDto.getLicenseColorCode());
            dbManager.setString(8,prpLthirdPartyDto.getCarKindCode());
            dbManager.setString(9,prpLthirdPartyDto.getInsureCarFlag());
            dbManager.setString(10,prpLthirdPartyDto.getCarOwner());
            dbManager.setString(11,prpLthirdPartyDto.getEngineNo());
            dbManager.setString(12,prpLthirdPartyDto.getFrameNo());
            dbManager.setString(13,prpLthirdPartyDto.getModelCode());
            dbManager.setString(14,prpLthirdPartyDto.getBrandName());
            dbManager.setDouble(15,prpLthirdPartyDto.getRunDistance());
            dbManager.setInt(16,prpLthirdPartyDto.getUseYears());
            dbManager.setDouble(17,prpLthirdPartyDto.getDutyPercent());
            dbManager.setString(18,prpLthirdPartyDto.getInsuredFlag());
            dbManager.setString(19,prpLthirdPartyDto.getInsureComCode());
            dbManager.setString(20,prpLthirdPartyDto.getInsureComName());
            dbManager.setString(21,prpLthirdPartyDto.getFlag());
            dbManager.setString(22,prpLthirdPartyDto.getVINNo());
            dbManager.setString(23,prpLthirdPartyDto.getLossFlag());
            dbManager.setString(24,prpLthirdPartyDto.getPrpLthirdPartyDriveName());
            dbManager.setString(25,prpLthirdPartyDto.getPrpLthirdPartyDriveLicensNo());
            dbManager.setString(26, prpLthirdPartyDto.getCarPolicyNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLthirdPartyBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLthirdParty" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLthirdParty Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLthirdPartyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLthirdPartyDto prpLthirdPartyDto
     * @throws Exception
     */
    public void update(PrpLthirdPartyDto prpLthirdPartyDto) throws Exception{
        String statement = " Update PrpLthirdParty Set RiskCode = ?," + 
                           " ClaimNo = ?," + 
                           " ClauseType = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " CarKindCode = ?," + 
                           " InsureCarFlag = ?," + 
                           " CarOwner = ?," + 
                           " EngineNo = ?," + 
                           " FrameNo = ?," + 
                           " ModelCode = ?," + 
                           " BrandName = ?," + 
                           " RunDistance = ?," + 
                           " UseYears = ?," + 
                           " DutyPercent = ?," + 
                           " InsuredFlag = ?," + 
                           " InsureComCode = ?," + 
                           " InsureComName = ?," + 
                           " Flag = ?," + 
                           " VINNo = ?," + 
                           " LossFlag = ?," +
                           " CarPolicyNo = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLthirdParty Set " + 
                           " RegistNo = '" + prpLthirdPartyDto.getRegistNo() + "'," + 
                           " RiskCode = '" + prpLthirdPartyDto.getRiskCode() + "'," + 
                           " SerialNo = " + prpLthirdPartyDto.getSerialNo() + "," + 
                           " ClaimNo = '" + prpLthirdPartyDto.getClaimNo() + "'," + 
                           " ClauseType = '" + prpLthirdPartyDto.getClauseType() + "'," + 
                           " LicenseNo = '" + prpLthirdPartyDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLthirdPartyDto.getLicenseColorCode() + "'," + 
                           " CarKindCode = '" + prpLthirdPartyDto.getCarKindCode() + "'," + 
                           " InsureCarFlag = '" + prpLthirdPartyDto.getInsureCarFlag() + "'," + 
                           " CarOwner = '" + prpLthirdPartyDto.getCarOwner() + "'," + 
                           " EngineNo = '" + prpLthirdPartyDto.getEngineNo() + "'," + 
                           " FrameNo = '" + prpLthirdPartyDto.getFrameNo() + "'," + 
                           " ModelCode = '" + prpLthirdPartyDto.getModelCode() + "'," + 
                           " BrandName = '" + prpLthirdPartyDto.getBrandName() + "'," + 
                           " RunDistance = '" + prpLthirdPartyDto.getRunDistance() + "'," + 
                           " UseYears = " + prpLthirdPartyDto.getUseYears() + "," + 
                           " DutyPercent = '" + prpLthirdPartyDto.getDutyPercent() + "'," + 
                           " InsuredFlag = '" + prpLthirdPartyDto.getInsuredFlag() + "'," + 
                           " InsureComCode = '" + prpLthirdPartyDto.getInsureComCode() + "'," + 
                           " InsureComName = '" + prpLthirdPartyDto.getInsureComName() + "'," + 
                           " Flag = '" + prpLthirdPartyDto.getFlag() + "'," + 
                           " VINNo = '" + prpLthirdPartyDto.getVINNo() + "'," + 
                           " LossFlag = '" + prpLthirdPartyDto.getLossFlag() + "'" +
                           " CarPolicyNo = '" + prpLthirdPartyDto.getCarPolicyNo() + "'" +
			               " Where " +
                           " RegistNo = '" + prpLthirdPartyDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLthirdPartyDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLthirdPartyDto.getRiskCode());
        dbManager.setString(2,prpLthirdPartyDto.getClaimNo());
        dbManager.setString(3,prpLthirdPartyDto.getClauseType());
        dbManager.setString(4,prpLthirdPartyDto.getLicenseNo());
        dbManager.setString(5,prpLthirdPartyDto.getLicenseColorCode());
        dbManager.setString(6,prpLthirdPartyDto.getCarKindCode());
        dbManager.setString(7,prpLthirdPartyDto.getInsureCarFlag());
        dbManager.setString(8,prpLthirdPartyDto.getCarOwner());
        dbManager.setString(9,prpLthirdPartyDto.getEngineNo());
        dbManager.setString(10,prpLthirdPartyDto.getFrameNo());
        dbManager.setString(11,prpLthirdPartyDto.getModelCode());
        dbManager.setString(12,prpLthirdPartyDto.getBrandName());
        dbManager.setDouble(13,prpLthirdPartyDto.getRunDistance());
        dbManager.setInt(14,prpLthirdPartyDto.getUseYears());
        dbManager.setDouble(15,prpLthirdPartyDto.getDutyPercent());
        dbManager.setString(16,prpLthirdPartyDto.getInsuredFlag());
        dbManager.setString(17,prpLthirdPartyDto.getInsureComCode());
        dbManager.setString(18,prpLthirdPartyDto.getInsureComName());
        dbManager.setString(19,prpLthirdPartyDto.getFlag());
        dbManager.setString(20,prpLthirdPartyDto.getVINNo());
        dbManager.setString(21,prpLthirdPartyDto.getLossFlag());
        dbManager.setString(22, prpLthirdPartyDto.getCarPolicyNo());
        //设置条件字段;
        dbManager.setString(23,prpLthirdPartyDto.getRegistNo());
        dbManager.setInt(24,prpLthirdPartyDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdPartyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return PrpLthirdPartyDto
     * @throws Exception
     */
    public PrpLthirdPartyDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " ClaimNo," + 
                           " ClauseType," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " InsureCarFlag," + 
                           " CarOwner," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " RunDistance," + 
                           " UseYears," + 
                           " DutyPercent," + 
                           " InsuredFlag," + 
                           " InsureComCode," + 
                           " InsureComName," + 
                           " Flag," + 
                           " VINNo," + 
                           " LossFlag," +
                           " CarPolicyNo  From PrpLthirdParty";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLthirdPartyDto prpLthirdPartyDto = null;
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
            prpLthirdPartyDto = new PrpLthirdPartyDto();
            prpLthirdPartyDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdPartyDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdPartyDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdPartyDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLthirdPartyDto.setClauseType(dbManager.getString(resultSet,5));
            prpLthirdPartyDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLthirdPartyDto.setLicenseColorCode(dbManager.getString(resultSet,7));
            prpLthirdPartyDto.setCarKindCode(dbManager.getString(resultSet,8));
            prpLthirdPartyDto.setInsureCarFlag(dbManager.getString(resultSet,9));
            prpLthirdPartyDto.setCarOwner(dbManager.getString(resultSet,10));
            prpLthirdPartyDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLthirdPartyDto.setFrameNo(dbManager.getString(resultSet,12));
            prpLthirdPartyDto.setModelCode(dbManager.getString(resultSet,13));
            prpLthirdPartyDto.setBrandName(dbManager.getString(resultSet,14));
            prpLthirdPartyDto.setRunDistance(dbManager.getDouble(resultSet,15));
            prpLthirdPartyDto.setUseYears(dbManager.getInt(resultSet,16));
            prpLthirdPartyDto.setDutyPercent(dbManager.getDouble(resultSet,17));
            prpLthirdPartyDto.setInsuredFlag(dbManager.getString(resultSet,18));
            prpLthirdPartyDto.setInsureComCode(dbManager.getString(resultSet,19));
            prpLthirdPartyDto.setInsureComName(dbManager.getString(resultSet,20));
            prpLthirdPartyDto.setFlag(dbManager.getString(resultSet,21));
            prpLthirdPartyDto.setVINNo(dbManager.getString(resultSet,22));
            prpLthirdPartyDto.setLossFlag(dbManager.getString(resultSet,23));
            prpLthirdPartyDto.setCarPolicyNo(dbManager.getString(resultSet, 24));
            logger.info("DBPrpLthirdPartyBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLthirdPartyBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLthirdPartyDto;
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
                           " SerialNo," + 
                           " ClaimNo," + 
                           " ClauseType," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " CarKindCode," + 
                           " InsureCarFlag," + 
                           " CarOwner," + 
                           " EngineNo," + 
                           " FrameNo," + 
                           " ModelCode," + 
                           " BrandName," + 
                           " RunDistance," + 
                           " UseYears," + 
                           " DutyPercent," + 
                           " InsuredFlag," + 
                           " InsureComCode," + 
                           " InsureComName," + 
                           " Flag," + 
                           " VINNo," + 
                           " LossFlag," +
                           " DRIVENAME, " +
                           " DRIVELICENSNO ," +
                           " CarPolicyNo From PrpLthirdParty Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto = null;
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

            prpLthirdPartyDto = new PrpLthirdPartyDto();
            prpLthirdPartyDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdPartyDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdPartyDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdPartyDto.setClaimNo(dbManager.getString(resultSet,4));
            prpLthirdPartyDto.setClauseType(dbManager.getString(resultSet,5));
            prpLthirdPartyDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLthirdPartyDto.setLicenseColorCode(dbManager.getString(resultSet,7));
            prpLthirdPartyDto.setCarKindCode(dbManager.getString(resultSet,8));
            prpLthirdPartyDto.setInsureCarFlag(dbManager.getString(resultSet,9));
            prpLthirdPartyDto.setCarOwner(dbManager.getString(resultSet,10));
            prpLthirdPartyDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLthirdPartyDto.setFrameNo(dbManager.getString(resultSet,12));
            prpLthirdPartyDto.setModelCode(dbManager.getString(resultSet,13));
            prpLthirdPartyDto.setBrandName(dbManager.getString(resultSet,14));
            prpLthirdPartyDto.setRunDistance(dbManager.getDouble(resultSet,15));
            prpLthirdPartyDto.setUseYears(dbManager.getInt(resultSet,16));
            prpLthirdPartyDto.setDutyPercent(dbManager.getDouble(resultSet,17));
            prpLthirdPartyDto.setInsuredFlag(dbManager.getString(resultSet,18));
            prpLthirdPartyDto.setInsureComCode(dbManager.getString(resultSet,19));
            prpLthirdPartyDto.setInsureComName(dbManager.getString(resultSet,20));
            prpLthirdPartyDto.setFlag(dbManager.getString(resultSet,21));
            prpLthirdPartyDto.setVINNo(dbManager.getString(resultSet,22));
            prpLthirdPartyDto.setLossFlag(dbManager.getString(resultSet,23));
            prpLthirdPartyDto.setPrpLthirdPartyDriveName(dbManager.getString(resultSet,24));
            prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(dbManager.getString(resultSet,25));
            prpLthirdPartyDto.setCarPolicyNo(dbManager.getString(resultSet, 26));
            collection.add(prpLthirdPartyDto);
        }
        resultSet.close();
        logger.info("DBPrpLthirdPartyBase.findByConditions() success!");
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
        String statement = "Delete From PrpLthirdParty Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLthirdPartyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLthirdParty Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLthirdPartyBase.getCount() success!");
        return count;
    }
}
