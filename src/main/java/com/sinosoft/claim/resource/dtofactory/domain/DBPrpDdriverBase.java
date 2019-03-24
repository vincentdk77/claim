package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdriverDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddriver机动车险司机代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdriverBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDdriverBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDdriverBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void insert(PrpDdriverDto prpDdriverDto) throws Exception{
        String statement = " Insert Into PrpDdriver(" + 
                           " DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " Birthday," + 
                           " DriverAddress," + 
                           " IdentifyNumber," + 
                           " ReceiveLicenseDate," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDdriverDto.getDrivingLicenseNo());
        dbManager.setString(2,prpDdriverDto.getDriverName());
        dbManager.setString(3,prpDdriverDto.getDriverSex());
        dbManager.setDateTime(4,prpDdriverDto.getBirthday());
        dbManager.setString(5,prpDdriverDto.getDriverAddress());
        dbManager.setString(6,prpDdriverDto.getIdentifyNumber());
        dbManager.setDateTime(7,prpDdriverDto.getReceiveLicenseDate());
        dbManager.setString(8,prpDdriverDto.getAwardLicenseOrgan());
        dbManager.setString(9,prpDdriverDto.getDrivingCarType());
        dbManager.setString(10,prpDdriverDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdriverBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDdriverDto prpDdriverDto = (PrpDdriverDto)i.next();
            insert(prpDdriverDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param drivingLicenseNo 驾驶员驾驶证号码
     * @throws Exception
     */
    public void delete(String drivingLicenseNo) throws Exception{
        String statement = " Delete From PrpDdriver Where " +
                           " DrivingLicenseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,drivingLicenseNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDdriverBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDdriverDto prpDdriverDto
     * @throws Exception
     */
    public void update(PrpDdriverDto prpDdriverDto) throws Exception{
        String statement = " Update PrpDdriver Set DriverName = ?," + 
                           " DriverSex = ?," + 
                           " Birthday = ?," + 
                           " DriverAddress = ?," + 
                           " IdentifyNumber = ?," + 
                           " ReceiveLicenseDate = ?," + 
                           " AwardLicenseOrgan = ?," + 
                           " DrivingCarType = ?," + 
                           " Flag = ? Where " +
                           " DrivingLicenseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDdriverDto.getDriverName());
        dbManager.setString(2,prpDdriverDto.getDriverSex());
        dbManager.setDateTime(3,prpDdriverDto.getBirthday());
        dbManager.setString(4,prpDdriverDto.getDriverAddress());
        dbManager.setString(5,prpDdriverDto.getIdentifyNumber());
        dbManager.setDateTime(6,prpDdriverDto.getReceiveLicenseDate());
        dbManager.setString(7,prpDdriverDto.getAwardLicenseOrgan());
        dbManager.setString(8,prpDdriverDto.getDrivingCarType());
        dbManager.setString(9,prpDdriverDto.getFlag());
        //设置条件字段;
        dbManager.setString(10,prpDdriverDto.getDrivingLicenseNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdriverBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param drivingLicenseNo 驾驶员驾驶证号码
     * @return PrpDdriverDto
     * @throws Exception
     */
    public PrpDdriverDto findByPrimaryKey(String drivingLicenseNo) throws Exception{
        String statement = " Select DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " Birthday," + 
                           " DriverAddress," + 
                           " IdentifyNumber," + 
                           " ReceiveLicenseDate," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag From PrpDdriver Where " +
                           " DrivingLicenseNo = ?";
        PrpDdriverDto prpDdriverDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,drivingLicenseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDdriverDto = new PrpDdriverDto();
            prpDdriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,1));
            prpDdriverDto.setDriverName(dbManager.getString(resultSet,2));
            prpDdriverDto.setDriverSex(dbManager.getString(resultSet,3));
            prpDdriverDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDdriverDto.setDriverAddress(dbManager.getString(resultSet,5));
            prpDdriverDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpDdriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDdriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,8));
            prpDdriverDto.setDrivingCarType(dbManager.getString(resultSet,9));
            prpDdriverDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDdriverBase.findByPrimaryKey() success!");
        return prpDdriverDto;
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
        String statement = "Select DrivingLicenseNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " Birthday," + 
                           " DriverAddress," + 
                           " IdentifyNumber," + 
                           " ReceiveLicenseDate," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag From PrpDdriver Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDdriverDto prpDdriverDto = null;
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

            prpDdriverDto = new PrpDdriverDto();
            prpDdriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,1));
            prpDdriverDto.setDriverName(dbManager.getString(resultSet,2));
            prpDdriverDto.setDriverSex(dbManager.getString(resultSet,3));
            prpDdriverDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDdriverDto.setDriverAddress(dbManager.getString(resultSet,5));
            prpDdriverDto.setIdentifyNumber(dbManager.getString(resultSet,6));
            prpDdriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpDdriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,8));
            prpDdriverDto.setDrivingCarType(dbManager.getString(resultSet,9));
            prpDdriverDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDdriverDto);
        }
        resultSet.close();
        log.info("DBPrpDdriverBase.findByConditions() success!");
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
        String statement = "Delete From PrpDdriver Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDdriverBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDdriver Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDdriverBase.getCount() success!");
        return count;
    }
}
