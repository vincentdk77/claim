package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsurednature自然人信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsuredNatureBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCinsuredNatureBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCinsuredNatureBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void insert(PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        String statement = " Insert Into PrpCinsuredNature(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " Sex," + 
                           " Age," + 
                           " birthday," + 
                           " health," + 
                           " JobTitle," + 
                           " LoacalWorkYears," + 
                           " Education," + 
                           " TotalWorkYears," + 
                           " Unit," + 
                           " UnitPhoneNumber," + 
                           " UnitAddress," + 
                           " UnitPostCode," + 
                           " UnitType," + 
                           " DutyLevel," + 
                           " DutyType," + 
                           " occupationcode," + 
                           " HouseProperty," + 
                           " LocalPoliceStation," + 
                           " RoomAddress," + 
                           " roompostcode," + 
                           " SelfMonthIncome," + 
                           " FamilyMonthIncome," + 
                           " IncomeSource," + 
                           " RoomPhone," + 
                           " Mobile," + 
                           " FamilySumQuantity," + 
                           " Marriage," + 
                           " SpouseName," + 
                           " SpouseBornDate," + 
                           " SpouseID," + 
                           " SpouseUnit," + 
                           " SpouseJobTitle," + 
                           " SpouseUnitPhone," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCinsuredNatureDto.getPolicyNo());
        dbManager.setInt(2,prpCinsuredNatureDto.getSerialNo());
        dbManager.setString(3,prpCinsuredNatureDto.getInsuredFlag());
        dbManager.setString(4,prpCinsuredNatureDto.getSex());
        dbManager.setInt(5,prpCinsuredNatureDto.getAge());
        dbManager.setDateTime(6,prpCinsuredNatureDto.getBirthday());
        dbManager.setString(7,prpCinsuredNatureDto.getHealth());
        dbManager.setString(8,prpCinsuredNatureDto.getJobTitle());
        dbManager.setInt(9,prpCinsuredNatureDto.getLoacalWorkYears());
        dbManager.setString(10,prpCinsuredNatureDto.getEducation());
        dbManager.setInt(11,prpCinsuredNatureDto.getTotalWorkYears());
        dbManager.setString(12,prpCinsuredNatureDto.getUnit());
        dbManager.setString(13,prpCinsuredNatureDto.getUnitPhoneNumber());
        dbManager.setString(14,prpCinsuredNatureDto.getUnitAddress());
        dbManager.setString(15,prpCinsuredNatureDto.getUnitPostCode());
        dbManager.setString(16,prpCinsuredNatureDto.getUnitType());
        dbManager.setString(17,prpCinsuredNatureDto.getDutyLevel());
        dbManager.setString(18,prpCinsuredNatureDto.getDutyType());
        dbManager.setString(19,prpCinsuredNatureDto.getOccupationcode());
        dbManager.setString(20,prpCinsuredNatureDto.getHouseProperty());
        dbManager.setString(21,prpCinsuredNatureDto.getLocalPoliceStation());
        dbManager.setString(22,prpCinsuredNatureDto.getRoomAddress());
        dbManager.setString(23,prpCinsuredNatureDto.getRoompostcode());
        dbManager.setDouble(24,prpCinsuredNatureDto.getSelfMonthIncome());
        dbManager.setDouble(25,prpCinsuredNatureDto.getFamilyMonthIncome());
        dbManager.setString(26,prpCinsuredNatureDto.getIncomeSource());
        dbManager.setString(27,prpCinsuredNatureDto.getRoomPhone());
        dbManager.setString(28,prpCinsuredNatureDto.getMobile());
        dbManager.setInt(29,prpCinsuredNatureDto.getFamilySumQuantity());
        dbManager.setString(30,prpCinsuredNatureDto.getMarriage());
        dbManager.setString(31,prpCinsuredNatureDto.getSpouseName());
        dbManager.setDateTime(32,prpCinsuredNatureDto.getSpouseBornDate());
        dbManager.setString(33,prpCinsuredNatureDto.getSpouseID());
        dbManager.setString(34,prpCinsuredNatureDto.getSpouseUnit());
        dbManager.setString(35,prpCinsuredNatureDto.getSpouseJobTitle());
        dbManager.setString(36,prpCinsuredNatureDto.getSpouseUnitPhone());
        dbManager.setString(37,prpCinsuredNatureDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredNatureBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCinsuredNatureDto prpCinsuredNatureDto = (PrpCinsuredNatureDto)i.next();
            insert(prpCinsuredNatureDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCinsuredNature Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCinsuredNatureBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void update(PrpCinsuredNatureDto prpCinsuredNatureDto) throws Exception{
        String statement = " Update PrpCinsuredNature Set InsuredFlag = ?," + 
                           " Sex = ?," + 
                           " Age = ?," + 
                           " birthday = ?," + 
                           " health = ?," + 
                           " JobTitle = ?," + 
                           " LoacalWorkYears = ?," + 
                           " Education = ?," + 
                           " TotalWorkYears = ?," + 
                           " Unit = ?," + 
                           " UnitPhoneNumber = ?," + 
                           " UnitAddress = ?," + 
                           " UnitPostCode = ?," + 
                           " UnitType = ?," + 
                           " DutyLevel = ?," + 
                           " DutyType = ?," + 
                           " occupationcode = ?," + 
                           " HouseProperty = ?," + 
                           " LocalPoliceStation = ?," + 
                           " RoomAddress = ?," + 
                           " roompostcode = ?," + 
                           " SelfMonthIncome = ?," + 
                           " FamilyMonthIncome = ?," + 
                           " IncomeSource = ?," + 
                           " RoomPhone = ?," + 
                           " Mobile = ?," + 
                           " FamilySumQuantity = ?," + 
                           " Marriage = ?," + 
                           " SpouseName = ?," + 
                           " SpouseBornDate = ?," + 
                           " SpouseID = ?," + 
                           " SpouseUnit = ?," + 
                           " SpouseJobTitle = ?," + 
                           " SpouseUnitPhone = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCinsuredNatureDto.getInsuredFlag());
        dbManager.setString(2,prpCinsuredNatureDto.getSex());
        dbManager.setInt(3,prpCinsuredNatureDto.getAge());
        dbManager.setDateTime(4,prpCinsuredNatureDto.getBirthday());
        dbManager.setString(5,prpCinsuredNatureDto.getHealth());
        dbManager.setString(6,prpCinsuredNatureDto.getJobTitle());
        dbManager.setInt(7,prpCinsuredNatureDto.getLoacalWorkYears());
        dbManager.setString(8,prpCinsuredNatureDto.getEducation());
        dbManager.setInt(9,prpCinsuredNatureDto.getTotalWorkYears());
        dbManager.setString(10,prpCinsuredNatureDto.getUnit());
        dbManager.setString(11,prpCinsuredNatureDto.getUnitPhoneNumber());
        dbManager.setString(12,prpCinsuredNatureDto.getUnitAddress());
        dbManager.setString(13,prpCinsuredNatureDto.getUnitPostCode());
        dbManager.setString(14,prpCinsuredNatureDto.getUnitType());
        dbManager.setString(15,prpCinsuredNatureDto.getDutyLevel());
        dbManager.setString(16,prpCinsuredNatureDto.getDutyType());
        dbManager.setString(17,prpCinsuredNatureDto.getOccupationcode());
        dbManager.setString(18,prpCinsuredNatureDto.getHouseProperty());
        dbManager.setString(19,prpCinsuredNatureDto.getLocalPoliceStation());
        dbManager.setString(20,prpCinsuredNatureDto.getRoomAddress());
        dbManager.setString(21,prpCinsuredNatureDto.getRoompostcode());
        dbManager.setDouble(22,prpCinsuredNatureDto.getSelfMonthIncome());
        dbManager.setDouble(23,prpCinsuredNatureDto.getFamilyMonthIncome());
        dbManager.setString(24,prpCinsuredNatureDto.getIncomeSource());
        dbManager.setString(25,prpCinsuredNatureDto.getRoomPhone());
        dbManager.setString(26,prpCinsuredNatureDto.getMobile());
        dbManager.setInt(27,prpCinsuredNatureDto.getFamilySumQuantity());
        dbManager.setString(28,prpCinsuredNatureDto.getMarriage());
        dbManager.setString(29,prpCinsuredNatureDto.getSpouseName());
        dbManager.setDateTime(30,prpCinsuredNatureDto.getSpouseBornDate());
        dbManager.setString(31,prpCinsuredNatureDto.getSpouseID());
        dbManager.setString(32,prpCinsuredNatureDto.getSpouseUnit());
        dbManager.setString(33,prpCinsuredNatureDto.getSpouseJobTitle());
        dbManager.setString(34,prpCinsuredNatureDto.getSpouseUnitPhone());
        dbManager.setString(35,prpCinsuredNatureDto.getFlag());
        //设置条件字段;
        dbManager.setString(36,prpCinsuredNatureDto.getPolicyNo());
        dbManager.setInt(37,prpCinsuredNatureDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredNatureBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return PrpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredNatureDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " Sex," + 
                           " Age," + 
                           " birthday," + 
                           " health," + 
                           " JobTitle," + 
                           " LoacalWorkYears," + 
                           " Education," + 
                           " TotalWorkYears," + 
                           " Unit," + 
                           " UnitPhoneNumber," + 
                           " UnitAddress," + 
                           " UnitPostCode," + 
                           " UnitType," + 
                           " DutyLevel," + 
                           " DutyType," + 
                           " occupationcode," + 
                           " HouseProperty," + 
                           " LocalPoliceStation," + 
                           " RoomAddress," + 
                           " roompostcode," + 
                           " SelfMonthIncome," + 
                           " FamilyMonthIncome," + 
                           " IncomeSource," + 
                           " RoomPhone," + 
                           " Mobile," + 
                           " FamilySumQuantity," + 
                           " Marriage," + 
                           " SpouseName," + 
                           " SpouseBornDate," + 
                           " SpouseID," + 
                           " SpouseUnit," + 
                           " SpouseJobTitle," + 
                           " SpouseUnitPhone," + 
                           " Flag From PrpCinsuredNature Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCinsuredNatureDto = new PrpCinsuredNatureDto();
            prpCinsuredNatureDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredNatureDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredNatureDto.setInsuredFlag(dbManager.getString(resultSet,3));
            prpCinsuredNatureDto.setSex(dbManager.getString(resultSet,4));
            prpCinsuredNatureDto.setAge(dbManager.getInt(resultSet,5));
            prpCinsuredNatureDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCinsuredNatureDto.setHealth(dbManager.getString(resultSet,7));
            prpCinsuredNatureDto.setJobTitle(dbManager.getString(resultSet,8));
            prpCinsuredNatureDto.setLoacalWorkYears(dbManager.getInt(resultSet,9));
            prpCinsuredNatureDto.setEducation(dbManager.getString(resultSet,10));
            prpCinsuredNatureDto.setTotalWorkYears(dbManager.getInt(resultSet,11));
            prpCinsuredNatureDto.setUnit(dbManager.getString(resultSet,12));
            prpCinsuredNatureDto.setUnitPhoneNumber(dbManager.getString(resultSet,13));
            prpCinsuredNatureDto.setUnitAddress(dbManager.getString(resultSet,14));
            prpCinsuredNatureDto.setUnitPostCode(dbManager.getString(resultSet,15));
            prpCinsuredNatureDto.setUnitType(dbManager.getString(resultSet,16));
            prpCinsuredNatureDto.setDutyLevel(dbManager.getString(resultSet,17));
            prpCinsuredNatureDto.setDutyType(dbManager.getString(resultSet,18));
            prpCinsuredNatureDto.setOccupationcode(dbManager.getString(resultSet,19));
            prpCinsuredNatureDto.setHouseProperty(dbManager.getString(resultSet,20));
            prpCinsuredNatureDto.setLocalPoliceStation(dbManager.getString(resultSet,21));
            prpCinsuredNatureDto.setRoomAddress(dbManager.getString(resultSet,22));
            prpCinsuredNatureDto.setRoompostcode(dbManager.getString(resultSet,23));
            prpCinsuredNatureDto.setSelfMonthIncome(dbManager.getDouble(resultSet,24));
            prpCinsuredNatureDto.setFamilyMonthIncome(dbManager.getDouble(resultSet,25));
            prpCinsuredNatureDto.setIncomeSource(dbManager.getString(resultSet,26));
            prpCinsuredNatureDto.setRoomPhone(dbManager.getString(resultSet,27));
            prpCinsuredNatureDto.setMobile(dbManager.getString(resultSet,28));
            prpCinsuredNatureDto.setFamilySumQuantity(dbManager.getInt(resultSet,29));
            prpCinsuredNatureDto.setMarriage(dbManager.getString(resultSet,30));
            prpCinsuredNatureDto.setSpouseName(dbManager.getString(resultSet,31));
            prpCinsuredNatureDto.setSpouseBornDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            prpCinsuredNatureDto.setSpouseID(dbManager.getString(resultSet,33));
            prpCinsuredNatureDto.setSpouseUnit(dbManager.getString(resultSet,34));
            prpCinsuredNatureDto.setSpouseJobTitle(dbManager.getString(resultSet,35));
            prpCinsuredNatureDto.setSpouseUnitPhone(dbManager.getString(resultSet,36));
            prpCinsuredNatureDto.setFlag(dbManager.getString(resultSet,37));
        }
        resultSet.close();
        log.info("DBPrpCinsuredNatureBase.findByPrimaryKey() success!");
        return prpCinsuredNatureDto;
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
        String statement = "Select PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " Sex," + 
                           " Age," + 
                           " birthday," + 
                           " health," + 
                           " JobTitle," + 
                           " LoacalWorkYears," + 
                           " Education," + 
                           " TotalWorkYears," + 
                           " Unit," + 
                           " UnitPhoneNumber," + 
                           " UnitAddress," + 
                           " UnitPostCode," + 
                           " UnitType," + 
                           " DutyLevel," + 
                           " DutyType," + 
                           " occupationcode," + 
                           " HouseProperty," + 
                           " LocalPoliceStation," + 
                           " RoomAddress," + 
                           " roompostcode," + 
                           " SelfMonthIncome," + 
                           " FamilyMonthIncome," + 
                           " IncomeSource," + 
                           " RoomPhone," + 
                           " Mobile," + 
                           " FamilySumQuantity," + 
                           " Marriage," + 
                           " SpouseName," + 
                           " SpouseBornDate," + 
                           " SpouseID," + 
                           " SpouseUnit," + 
                           " SpouseJobTitle," + 
                           " SpouseUnitPhone," + 
                           " Flag From PrpCinsuredNature Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
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

            prpCinsuredNatureDto = new PrpCinsuredNatureDto();
            prpCinsuredNatureDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredNatureDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredNatureDto.setInsuredFlag(dbManager.getString(resultSet,3));
            prpCinsuredNatureDto.setSex(dbManager.getString(resultSet,4));
            prpCinsuredNatureDto.setAge(dbManager.getInt(resultSet,5));
            prpCinsuredNatureDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCinsuredNatureDto.setHealth(dbManager.getString(resultSet,7));
            prpCinsuredNatureDto.setJobTitle(dbManager.getString(resultSet,8));
            prpCinsuredNatureDto.setLoacalWorkYears(dbManager.getInt(resultSet,9));
            prpCinsuredNatureDto.setEducation(dbManager.getString(resultSet,10));
            prpCinsuredNatureDto.setTotalWorkYears(dbManager.getInt(resultSet,11));
            prpCinsuredNatureDto.setUnit(dbManager.getString(resultSet,12));
            prpCinsuredNatureDto.setUnitPhoneNumber(dbManager.getString(resultSet,13));
            prpCinsuredNatureDto.setUnitAddress(dbManager.getString(resultSet,14));
            prpCinsuredNatureDto.setUnitPostCode(dbManager.getString(resultSet,15));
            prpCinsuredNatureDto.setUnitType(dbManager.getString(resultSet,16));
            prpCinsuredNatureDto.setDutyLevel(dbManager.getString(resultSet,17));
            prpCinsuredNatureDto.setDutyType(dbManager.getString(resultSet,18));
            prpCinsuredNatureDto.setOccupationcode(dbManager.getString(resultSet,19));
            prpCinsuredNatureDto.setHouseProperty(dbManager.getString(resultSet,20));
            prpCinsuredNatureDto.setLocalPoliceStation(dbManager.getString(resultSet,21));
            prpCinsuredNatureDto.setRoomAddress(dbManager.getString(resultSet,22));
            prpCinsuredNatureDto.setRoompostcode(dbManager.getString(resultSet,23));
            prpCinsuredNatureDto.setSelfMonthIncome(dbManager.getDouble(resultSet,24));
            prpCinsuredNatureDto.setFamilyMonthIncome(dbManager.getDouble(resultSet,25));
            prpCinsuredNatureDto.setIncomeSource(dbManager.getString(resultSet,26));
            prpCinsuredNatureDto.setRoomPhone(dbManager.getString(resultSet,27));
            prpCinsuredNatureDto.setMobile(dbManager.getString(resultSet,28));
            prpCinsuredNatureDto.setFamilySumQuantity(dbManager.getInt(resultSet,29));
            prpCinsuredNatureDto.setMarriage(dbManager.getString(resultSet,30));
            prpCinsuredNatureDto.setSpouseName(dbManager.getString(resultSet,31));
            prpCinsuredNatureDto.setSpouseBornDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            prpCinsuredNatureDto.setSpouseID(dbManager.getString(resultSet,33));
            prpCinsuredNatureDto.setSpouseUnit(dbManager.getString(resultSet,34));
            prpCinsuredNatureDto.setSpouseJobTitle(dbManager.getString(resultSet,35));
            prpCinsuredNatureDto.setSpouseUnitPhone(dbManager.getString(resultSet,36));
            prpCinsuredNatureDto.setFlag(dbManager.getString(resultSet,37));
            collection.add(prpCinsuredNatureDto);
        }
        resultSet.close();
        log.info("DBPrpCinsuredNatureBase.findByConditions() success!");
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
        String statement = "Delete From PrpCinsuredNature Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCinsuredNatureBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCinsuredNature Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredNatureBase.getCount() success!");
        return count;
    }
}
