package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCnameDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcname雇员清单表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCnameBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCnameBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCnameBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCnameDto prpCnameDto
     * @throws Exception
     */
    public void insert(PrpCnameDto prpCnameDto) throws Exception{
        String statement = " Insert Into PrpCname(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " JobCode," + 
                           " JobName," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " Currency," + 
                           " MonthWage," + 
                           " Currency1," + 
                           " SumLimit," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCnameDto.getPolicyNo());
        dbManager.setString(2,prpCnameDto.getRiskCode());
        dbManager.setInt(3,prpCnameDto.getSerialNo());
        dbManager.setString(4,prpCnameDto.getEmployeeCode());
        dbManager.setString(5,prpCnameDto.getEmployeeName());
        dbManager.setString(6,prpCnameDto.getSex());
        dbManager.setInt(7,prpCnameDto.getAge());
        dbManager.setString(8,prpCnameDto.getHealth());
        dbManager.setString(9,prpCnameDto.getKindCode());
        dbManager.setString(10,prpCnameDto.getKindName());
        dbManager.setString(11,prpCnameDto.getItemCode());
        dbManager.setString(12,prpCnameDto.getItemDetailName());
        dbManager.setString(13,prpCnameDto.getJobCode());
        dbManager.setString(14,prpCnameDto.getJobName());
        dbManager.setString(15,prpCnameDto.getIdentifyNumber());
        dbManager.setString(16,prpCnameDto.getJobUnit());
        dbManager.setString(17,prpCnameDto.getCurrency());
        dbManager.setDouble(18,prpCnameDto.getMonthWage());
        dbManager.setString(19,prpCnameDto.getCurrency1());
        dbManager.setDouble(20,prpCnameDto.getSumLimit());
        dbManager.setDateTime(21,prpCnameDto.getStartDate());
        dbManager.setInt(22,prpCnameDto.getStartHour());
        dbManager.setDateTime(23,prpCnameDto.getEndDate());
        dbManager.setInt(24,prpCnameDto.getEndHour());
        dbManager.setString(25,prpCnameDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCnameBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCnameDto prpCnameDto = (PrpCnameDto)i.next();
            insert(prpCnameDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCname Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCnameBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCnameDto prpCnameDto
     * @throws Exception
     */
    public void update(PrpCnameDto prpCnameDto) throws Exception{
        String statement = " Update PrpCname Set RiskCode = ?," + 
                           " EmployeeCode = ?," + 
                           " EmployeeName = ?," + 
                           " Sex = ?," + 
                           " Age = ?," + 
                           " Health = ?," + 
                           " KindCode = ?," + 
                           " KindName = ?," + 
                           " ItemCode = ?," + 
                           " ItemDetailName = ?," + 
                           " JobCode = ?," + 
                           " JobName = ?," + 
                           " IdentifyNumber = ?," + 
                           " JobUnit = ?," + 
                           " Currency = ?," + 
                           " MonthWage = ?," + 
                           " Currency1 = ?," + 
                           " SumLimit = ?," + 
                           " StartDate = ?," + 
                           " StartHour = ?," + 
                           " EndDate = ?," + 
                           " EndHour = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCnameDto.getRiskCode());
        dbManager.setString(2,prpCnameDto.getEmployeeCode());
        dbManager.setString(3,prpCnameDto.getEmployeeName());
        dbManager.setString(4,prpCnameDto.getSex());
        dbManager.setInt(5,prpCnameDto.getAge());
        dbManager.setString(6,prpCnameDto.getHealth());
        dbManager.setString(7,prpCnameDto.getKindCode());
        dbManager.setString(8,prpCnameDto.getKindName());
        dbManager.setString(9,prpCnameDto.getItemCode());
        dbManager.setString(10,prpCnameDto.getItemDetailName());
        dbManager.setString(11,prpCnameDto.getJobCode());
        dbManager.setString(12,prpCnameDto.getJobName());
        dbManager.setString(13,prpCnameDto.getIdentifyNumber());
        dbManager.setString(14,prpCnameDto.getJobUnit());
        dbManager.setString(15,prpCnameDto.getCurrency());
        dbManager.setDouble(16,prpCnameDto.getMonthWage());
        dbManager.setString(17,prpCnameDto.getCurrency1());
        dbManager.setDouble(18,prpCnameDto.getSumLimit());
        dbManager.setDateTime(19,prpCnameDto.getStartDate());
        dbManager.setInt(20,prpCnameDto.getStartHour());
        dbManager.setDateTime(21,prpCnameDto.getEndDate());
        dbManager.setInt(22,prpCnameDto.getEndHour());
        dbManager.setString(23,prpCnameDto.getFlag());
        //设置条件字段;
        dbManager.setString(24,prpCnameDto.getPolicyNo());
        dbManager.setInt(25,prpCnameDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCnameBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return PrpCnameDto
     * @throws Exception
     */
    public PrpCnameDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " JobCode," + 
                           " JobName," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " Currency," + 
                           " MonthWage," + 
                           " Currency1," + 
                           " SumLimit," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Flag From PrpCname Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCnameDto prpCnameDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCnameDto = new PrpCnameDto();
            prpCnameDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCnameDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCnameDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCnameDto.setEmployeeCode(dbManager.getString(resultSet,4));
            prpCnameDto.setEmployeeName(dbManager.getString(resultSet,5));
            prpCnameDto.setSex(dbManager.getString(resultSet,6));
            prpCnameDto.setAge(dbManager.getInt(resultSet,7));
            prpCnameDto.setHealth(dbManager.getString(resultSet,8));
            prpCnameDto.setKindCode(dbManager.getString(resultSet,9));
            prpCnameDto.setKindName(dbManager.getString(resultSet,10));
            prpCnameDto.setItemCode(dbManager.getString(resultSet,11));
            prpCnameDto.setItemDetailName(dbManager.getString(resultSet,12));
            prpCnameDto.setJobCode(dbManager.getString(resultSet,13));
            prpCnameDto.setJobName(dbManager.getString(resultSet,14));
            prpCnameDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpCnameDto.setJobUnit(dbManager.getString(resultSet,16));
            prpCnameDto.setCurrency(dbManager.getString(resultSet,17));
            prpCnameDto.setMonthWage(dbManager.getDouble(resultSet,18));
            prpCnameDto.setCurrency1(dbManager.getString(resultSet,19));
            prpCnameDto.setSumLimit(dbManager.getDouble(resultSet,20));
            prpCnameDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpCnameDto.setStartHour(dbManager.getInt(resultSet,22));
            prpCnameDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpCnameDto.setEndHour(dbManager.getInt(resultSet,24));
            prpCnameDto.setFlag(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        log.info("DBPrpCnameBase.findByPrimaryKey() success!");
        return prpCnameDto;
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
                           " RiskCode," + 
                           " SerialNo," + 
                           " EmployeeCode," + 
                           " EmployeeName," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " KindCode," + 
                           " KindName," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " JobCode," + 
                           " JobName," + 
                           " IdentifyNumber," + 
                           " JobUnit," + 
                           " Currency," + 
                           " MonthWage," + 
                           " Currency1," + 
                           " SumLimit," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Flag From PrpCname Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCnameDto prpCnameDto = null;
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

            prpCnameDto = new PrpCnameDto();
            prpCnameDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCnameDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCnameDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCnameDto.setEmployeeCode(dbManager.getString(resultSet,4));
            prpCnameDto.setEmployeeName(dbManager.getString(resultSet,5));
            prpCnameDto.setSex(dbManager.getString(resultSet,6));
            prpCnameDto.setAge(dbManager.getInt(resultSet,7));
            prpCnameDto.setHealth(dbManager.getString(resultSet,8));
            prpCnameDto.setKindCode(dbManager.getString(resultSet,9));
            prpCnameDto.setKindName(dbManager.getString(resultSet,10));
            prpCnameDto.setItemCode(dbManager.getString(resultSet,11));
            prpCnameDto.setItemDetailName(dbManager.getString(resultSet,12));
            prpCnameDto.setJobCode(dbManager.getString(resultSet,13));
            prpCnameDto.setJobName(dbManager.getString(resultSet,14));
            prpCnameDto.setIdentifyNumber(dbManager.getString(resultSet,15));
            prpCnameDto.setJobUnit(dbManager.getString(resultSet,16));
            prpCnameDto.setCurrency(dbManager.getString(resultSet,17));
            prpCnameDto.setMonthWage(dbManager.getDouble(resultSet,18));
            prpCnameDto.setCurrency1(dbManager.getString(resultSet,19));
            prpCnameDto.setSumLimit(dbManager.getDouble(resultSet,20));
            prpCnameDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpCnameDto.setStartHour(dbManager.getInt(resultSet,22));
            prpCnameDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpCnameDto.setEndHour(dbManager.getInt(resultSet,24));
            prpCnameDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpCnameDto);
        }
        resultSet.close();
        log.info("DBPrpCnameBase.findByConditions() success!");
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
        String statement = "Delete From PrpCname Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCnameBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCname Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCnameBase.getCount() success!");
        return count;
    }
}
