package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLdriver-车险驾驶员信息表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLdriverBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLdriverBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLdriverBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLdriverDto prpLdriverDto
     * @throws Exception
     */
    public void insert(PrpLdriverDto prpLdriverDto) throws Exception{
        String mainStatement = " Insert Into PrpLdriver (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverAge," + 
                           " DriverOccupation," + 
                           " Education," + 
                           " UnitAddress," + 
                           " IdentifyNumber," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " ReceiveLicenseDate," + 
                           " DrivingCarType," + 
                           " DrivingYear," + 
                           " AwardLicenseOrgan," + 
                           " SpecialCertificate," + 
                           " Flag," +
                           " IdentifyType)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLdriverDto.getRegistNo() + "'," + 
                           "'" + prpLdriverDto.getClaimNo() + "'," + 
                           "'" + prpLdriverDto.getRiskCode() + "'," + 
                           "'" + prpLdriverDto.getPolicyNo() + "'," + 
                           "" + prpLdriverDto.getSerialNo() + "," + 
                           "'" + prpLdriverDto.getLicenseNo() + "'," + 
                           "'" + prpLdriverDto.getLicenseColorCode() + "'," + 
                           "'" + prpLdriverDto.getDrivingLicenseNo() + "'," + 
                           "'" + prpLdriverDto.getDriverName() + "'," + 
                           "'" + prpLdriverDto.getDriverSex() + "'," + 
                           "" + prpLdriverDto.getDriverAge() + "," + 
                           "'" + prpLdriverDto.getDriverOccupation() + "'," + 
                           "'" + prpLdriverDto.getEducation() + "'," + 
                           "'" + prpLdriverDto.getUnitAddress() + "'," + 
                           "'" + prpLdriverDto.getIdentifyNumber() + "'," + 
                           "" + prpLdriverDto.getDriverGrade() + "," + 
                           "'" + prpLdriverDto.getDriverSeaRoute() + "'," + 
                           "'" + prpLdriverDto.getReceiveLicenseDate() + "'," + 
                           "'" + prpLdriverDto.getDrivingCarType() + "'," + 
                           "" + prpLdriverDto.getDrivingYear() + "," + 
                           "'" + prpLdriverDto.getAwardLicenseOrgan() + "'," + 
                           "'" + prpLdriverDto.getSpecialCertificate() + "'," + 
                           "'" + prpLdriverDto.getFlag() + "'," +
                           "'" + prpLdriverDto.getIdentifyType() + ")";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLdriverDto.getRegistNo());
        dbManager.setString(2,prpLdriverDto.getClaimNo());
        dbManager.setString(3,prpLdriverDto.getRiskCode());
        dbManager.setString(4,prpLdriverDto.getPolicyNo());
        dbManager.setInt(5,prpLdriverDto.getSerialNo());
        dbManager.setString(6,prpLdriverDto.getLicenseNo());
        dbManager.setString(7,prpLdriverDto.getLicenseColorCode());
        dbManager.setString(8,prpLdriverDto.getDrivingLicenseNo());
        dbManager.setString(9,prpLdriverDto.getDriverName());
        dbManager.setString(10,prpLdriverDto.getDriverSex());
        dbManager.setInt(11,prpLdriverDto.getDriverAge());
        dbManager.setString(12,prpLdriverDto.getDriverOccupation());
        dbManager.setString(13,prpLdriverDto.getEducation());
        dbManager.setString(14,prpLdriverDto.getUnitAddress());
        dbManager.setString(15,prpLdriverDto.getIdentifyNumber());
        dbManager.setInt(16,prpLdriverDto.getDriverGrade());
        dbManager.setString(17,prpLdriverDto.getDriverSeaRoute());
        dbManager.setDateTime(18,prpLdriverDto.getReceiveLicenseDate());
        dbManager.setString(19,prpLdriverDto.getDrivingCarType());
        dbManager.setInt(20,prpLdriverDto.getDrivingYear());
        dbManager.setString(21,prpLdriverDto.getAwardLicenseOrgan());
        dbManager.setString(22,prpLdriverDto.getSpecialCertificate());
        dbManager.setString(23,prpLdriverDto.getFlag());
        dbManager.setString(24, prpLdriverDto.getIdentifyType());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLdriverBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLdriver (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverAge," + 
                           " DriverOccupation," + 
                           " Education," + 
                           " UnitAddress," + 
                           " IdentifyNumber," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " ReceiveLicenseDate," + 
                           " DrivingCarType," + 
                           " DrivingYear," + 
                           " AwardLicenseOrgan," + 
                           " SpecialCertificate," + 
                           " Flag," +
                           " IdentifyType)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLdriverDto prpLdriverDto = (PrpLdriverDto)i.next();
            dbManager.setString(1,prpLdriverDto.getRegistNo());
            dbManager.setString(2,prpLdriverDto.getClaimNo());
            dbManager.setString(3,prpLdriverDto.getRiskCode());
            dbManager.setString(4,prpLdriverDto.getPolicyNo());
            dbManager.setInt(5,prpLdriverDto.getSerialNo());
            dbManager.setString(6,prpLdriverDto.getLicenseNo());
            dbManager.setString(7,prpLdriverDto.getLicenseColorCode());
            dbManager.setString(8,prpLdriverDto.getDrivingLicenseNo());
            dbManager.setString(9,prpLdriverDto.getDriverName());
            dbManager.setString(10,prpLdriverDto.getDriverSex());
            dbManager.setInt(11,prpLdriverDto.getDriverAge());
            dbManager.setString(12,prpLdriverDto.getDriverOccupation());
            dbManager.setString(13,prpLdriverDto.getEducation());
            dbManager.setString(14,prpLdriverDto.getUnitAddress());
            dbManager.setString(15,prpLdriverDto.getIdentifyNumber());
            dbManager.setInt(16,prpLdriverDto.getDriverGrade());
            dbManager.setString(17,prpLdriverDto.getDriverSeaRoute());
            dbManager.setDateTime(18,prpLdriverDto.getReceiveLicenseDate());
            dbManager.setString(19,prpLdriverDto.getDrivingCarType());
            dbManager.setInt(20,prpLdriverDto.getDrivingYear());
            dbManager.setString(21,prpLdriverDto.getAwardLicenseOrgan());
            dbManager.setString(22,prpLdriverDto.getSpecialCertificate());
            dbManager.setString(23,prpLdriverDto.getFlag());
            dbManager.setString(24, prpLdriverDto.getIdentifyType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLdriverBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLdriver" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLdriver Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLdriverBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLdriverDto prpLdriverDto
     * @throws Exception
     */
    public void update(PrpLdriverDto prpLdriverDto) throws Exception{
        String statement = " Update PrpLdriver Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " DrivingLicenseNo = ?," + 
                           " DriverName = ?," + 
                           " DriverSex = ?," + 
                           " DriverAge = ?," + 
                           " DriverOccupation = ?," + 
                           " Education = ?," + 
                           " UnitAddress = ?," + 
                           " IdentifyNumber = ?," + 
                           " DriverGrade = ?," + 
                           " DriverSeaRoute = ?," + 
                           " ReceiveLicenseDate = ?," + 
                           " DrivingCarType = ?," + 
                           " DrivingYear = ?," + 
                           " AwardLicenseOrgan = ?," + 
                           " SpecialCertificate = ?," + 
                           " Flag = ?," +
                           " IdentifyType = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLdriver Set " + 
                           " RegistNo = '" + prpLdriverDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLdriverDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLdriverDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLdriverDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLdriverDto.getSerialNo() + "," + 
                           " LicenseNo = '" + prpLdriverDto.getLicenseNo() + "'," + 
                           " LicenseColorCode = '" + prpLdriverDto.getLicenseColorCode() + "'," + 
                           " DrivingLicenseNo = '" + prpLdriverDto.getDrivingLicenseNo() + "'," + 
                           " DriverName = '" + prpLdriverDto.getDriverName() + "'," + 
                           " DriverSex = '" + prpLdriverDto.getDriverSex() + "'," + 
                           " DriverAge = " + prpLdriverDto.getDriverAge() + "," + 
                           " DriverOccupation = '" + prpLdriverDto.getDriverOccupation() + "'," + 
                           " Education = '" + prpLdriverDto.getEducation() + "'," + 
                           " UnitAddress = '" + prpLdriverDto.getUnitAddress() + "'," + 
                           " IdentifyNumber = '" + prpLdriverDto.getIdentifyNumber() + "'," + 
                           " DriverGrade = " + prpLdriverDto.getDriverGrade() + "," + 
                           " DriverSeaRoute = '" + prpLdriverDto.getDriverSeaRoute() + "'," + 
                           " ReceiveLicenseDate = '" + prpLdriverDto.getReceiveLicenseDate() + "'," + 
                           " DrivingCarType = '" + prpLdriverDto.getDrivingCarType() + "'," + 
                           " DrivingYear = " + prpLdriverDto.getDrivingYear() + "," + 
                           " AwardLicenseOrgan = '" + prpLdriverDto.getAwardLicenseOrgan() + "'," + 
                           " SpecialCertificate = '" + prpLdriverDto.getSpecialCertificate() + "'," + 
                           " Flag = '" + prpLdriverDto.getFlag() + "'" +
                           " IdentifyType = '" + prpLdriverDto.getIdentifyType() + "'" +
			               " Where " +
                           " RegistNo = '" + prpLdriverDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLdriverDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLdriverDto.getClaimNo());
        dbManager.setString(2,prpLdriverDto.getRiskCode());
        dbManager.setString(3,prpLdriverDto.getPolicyNo());
        dbManager.setString(4,prpLdriverDto.getLicenseNo());
        dbManager.setString(5,prpLdriverDto.getLicenseColorCode());
        dbManager.setString(6,prpLdriverDto.getDrivingLicenseNo());
        dbManager.setString(7,prpLdriverDto.getDriverName());
        dbManager.setString(8,prpLdriverDto.getDriverSex());
        dbManager.setInt(9,prpLdriverDto.getDriverAge());
        dbManager.setString(10,prpLdriverDto.getDriverOccupation());
        dbManager.setString(11,prpLdriverDto.getEducation());
        dbManager.setString(12,prpLdriverDto.getUnitAddress());
        dbManager.setString(13,prpLdriverDto.getIdentifyNumber());
        dbManager.setInt(14,prpLdriverDto.getDriverGrade());
        dbManager.setString(15,prpLdriverDto.getDriverSeaRoute());
        dbManager.setDateTime(16,prpLdriverDto.getReceiveLicenseDate());
        dbManager.setString(17,prpLdriverDto.getDrivingCarType());
        dbManager.setInt(18,prpLdriverDto.getDrivingYear());
        dbManager.setString(19,prpLdriverDto.getAwardLicenseOrgan());
        dbManager.setString(20,prpLdriverDto.getSpecialCertificate());
        dbManager.setString(21,prpLdriverDto.getFlag());
        dbManager.setString(22, prpLdriverDto.getIdentifyType());
        //设置条件字段;
        dbManager.setString(23,prpLdriverDto.getRegistNo());
        dbManager.setInt(24,prpLdriverDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLdriverBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return PrpLdriverDto
     * @throws Exception
     */
    public PrpLdriverDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverAge," + 
                           " DriverOccupation," + 
                           " Education," + 
                           " UnitAddress," + 
                           " IdentifyNumber," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " ReceiveLicenseDate," + 
                           " DrivingCarType," + 
                           " DrivingYear," + 
                           " AwardLicenseOrgan," + 
                           " SpecialCertificate," + 
                           " Flag," +
                           " IdentifyType From PrpLdriver";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLdriverDto prpLdriverDto = null;
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
            prpLdriverDto = new PrpLdriverDto();
            prpLdriverDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLdriverDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLdriverDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLdriverDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLdriverDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLdriverDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLdriverDto.setLicenseColorCode(dbManager.getString(resultSet,7));
            prpLdriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,8));
            prpLdriverDto.setDriverName(dbManager.getString(resultSet,9));
            prpLdriverDto.setDriverSex(dbManager.getString(resultSet,10));
            prpLdriverDto.setDriverAge(dbManager.getInt(resultSet,11));
            prpLdriverDto.setDriverOccupation(dbManager.getString(resultSet,12));
            prpLdriverDto.setEducation(dbManager.getString(resultSet,13));
            prpLdriverDto.setUnitAddress(dbManager.getString(resultSet,14));
            prpLdriverDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpLdriverDto.setDriverGrade(dbManager.getInt(resultSet,16));
            prpLdriverDto.setDriverSeaRoute(dbManager.getString(resultSet,17));
            prpLdriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLdriverDto.setDrivingCarType(dbManager.getString(resultSet,19));
            prpLdriverDto.setDrivingYear(dbManager.getInt(resultSet,20));
            prpLdriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,21));
            prpLdriverDto.setSpecialCertificate(dbManager.getString(resultSet,22));
            prpLdriverDto.setFlag(dbManager.getString(resultSet,23));
            prpLdriverDto.setIdentifyType(dbManager.getString(resultSet, 24));
            logger.info("DBPrpLdriverBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLdriverBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLdriverDto;
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
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverAge," + 
                           " DriverOccupation," + 
                           " Education," + 
                           " UnitAddress," + 
                           " IdentifyNumber," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " ReceiveLicenseDate," + 
                           " DrivingCarType," + 
                           " DrivingYear," + 
                           " AwardLicenseOrgan," + 
                           " SpecialCertificate," + 
                           " Flag," +
                           " IdentifyType From PrpLdriver Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLdriverDto prpLdriverDto = null;
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

            prpLdriverDto = new PrpLdriverDto();
            prpLdriverDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLdriverDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLdriverDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLdriverDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLdriverDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLdriverDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLdriverDto.setLicenseColorCode(dbManager.getString(resultSet,7));
            prpLdriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,8));
            prpLdriverDto.setDriverName(dbManager.getString(resultSet,9));
            prpLdriverDto.setDriverSex(dbManager.getString(resultSet,10));
            prpLdriverDto.setDriverAge(dbManager.getInt(resultSet,11));
            prpLdriverDto.setDriverOccupation(dbManager.getString(resultSet,12));
            prpLdriverDto.setEducation(dbManager.getString(resultSet,13));
            prpLdriverDto.setUnitAddress(dbManager.getString(resultSet,14));
            prpLdriverDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpLdriverDto.setDriverGrade(dbManager.getInt(resultSet,16));
            prpLdriverDto.setDriverSeaRoute(dbManager.getString(resultSet,17));
            prpLdriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLdriverDto.setDrivingCarType(dbManager.getString(resultSet,19));
            prpLdriverDto.setDrivingYear(dbManager.getInt(resultSet,20));
            prpLdriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,21));
            prpLdriverDto.setSpecialCertificate(dbManager.getString(resultSet,22));
            prpLdriverDto.setFlag(dbManager.getString(resultSet,23));
            prpLdriverDto.setIdentifyType(dbManager.getString(resultSet, 24));
            collection.add(prpLdriverDto);
        }
        resultSet.close();
        logger.info("DBPrpLdriverBase.findByConditions() success!");
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
        String statement = "Delete From PrpLdriver Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLdriverBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLdriver Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLdriverBase.getCount() success!");
        return count;
    }
}
