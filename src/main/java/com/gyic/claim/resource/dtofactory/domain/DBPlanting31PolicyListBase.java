package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31PolicyList的数据访问对象基类<br>
 */
public class DBPlanting31PolicyListBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlanting31PolicyListBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlanting31PolicyListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void insert(Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Planting31PolicyList (");
        buffer.append("InusreListCode,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("IndexCode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("FareaCode,");
        buffer.append("TaxArea,");
        buffer.append("InsureArea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("ShortRateFlag,");
        buffer.append("ShortRate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("CalculateFlag,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("TeamName,");
        buffer.append("CentralPremium,");
        buffer.append("ProvincePremium,");
        buffer.append("CityPremium,");
        buffer.append("TownPremium,");
        buffer.append("OtherPremium,");
        buffer.append("FieldSource,");
        buffer.append("MulChDate,");
        buffer.append("MulChType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(planting31PolicyListDto.getInusreListCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getFcode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getKindCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getItemCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getIndexCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getPhone()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getBank()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getZhiBuKa()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getFname()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getFidCard()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getClassCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getFareaCode()).append("',");
            debugBuffer.append("").append(planting31PolicyListDto.getTaxArea()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getInsureArea()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getAmount()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getRate()).append(",");
            debugBuffer.append("'").append(planting31PolicyListDto.getShortRateFlag()).append("',");
            debugBuffer.append("").append(planting31PolicyListDto.getShortRate()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getSumAmount()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getSumPremium()).append(",");
            debugBuffer.append("'").append(planting31PolicyListDto.getStartDate()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getEndDate()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getCalculateFlag()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getOpCode()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getOpTime()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getValidity()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getRemark()).append("',");
            debugBuffer.append("").append(planting31PolicyListDto.getFpremium()).append(",");
            debugBuffer.append("'").append(planting31PolicyListDto.getTeamName()).append("',");
            debugBuffer.append("").append(planting31PolicyListDto.getCentralPremium()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getProvincePremium()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getCityPremium()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getTownPremium()).append(",");
            debugBuffer.append("").append(planting31PolicyListDto.getOtherPremium()).append(",");
            debugBuffer.append("'").append(planting31PolicyListDto.getFieldSource()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getMulChDate()).append("',");
            debugBuffer.append("'").append(planting31PolicyListDto.getMulChType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,planting31PolicyListDto.getInusreListCode());
        dbManager.setString(2,planting31PolicyListDto.getFcode());
        dbManager.setString(3,planting31PolicyListDto.getKindCode());
        dbManager.setString(4,planting31PolicyListDto.getItemCode());
        dbManager.setString(5,planting31PolicyListDto.getIndexCode());
        dbManager.setString(6,planting31PolicyListDto.getPhone());
        dbManager.setString(7,planting31PolicyListDto.getBank());
        dbManager.setString(8,planting31PolicyListDto.getZhiBuKa());
        dbManager.setString(9,planting31PolicyListDto.getFname());
        dbManager.setString(10,planting31PolicyListDto.getFidCard());
        dbManager.setString(11,planting31PolicyListDto.getClassCode());
        dbManager.setString(12,planting31PolicyListDto.getRiskCode());
        dbManager.setString(13,planting31PolicyListDto.getFareaCode());
        dbManager.setDouble(14,planting31PolicyListDto.getTaxArea());
        dbManager.setDouble(15,planting31PolicyListDto.getInsureArea());
        dbManager.setDouble(16,planting31PolicyListDto.getAmount());
        dbManager.setDouble(17,planting31PolicyListDto.getRate());
        dbManager.setString(18,planting31PolicyListDto.getShortRateFlag());
        dbManager.setDouble(19,planting31PolicyListDto.getShortRate());
        dbManager.setDouble(20,planting31PolicyListDto.getSumAmount());
        dbManager.setDouble(21,planting31PolicyListDto.getSumPremium());
        dbManager.setDateTime(22,planting31PolicyListDto.getStartDate());
        dbManager.setDateTime(23,planting31PolicyListDto.getEndDate());
        dbManager.setString(24,planting31PolicyListDto.getCalculateFlag());
        dbManager.setString(25,planting31PolicyListDto.getOpCode());
        dbManager.setDateTime(26,planting31PolicyListDto.getOpTime());
        dbManager.setString(27,planting31PolicyListDto.getValidity());
        dbManager.setString(28,planting31PolicyListDto.getRemark());
        dbManager.setDouble(29,planting31PolicyListDto.getFpremium());
        dbManager.setString(30,planting31PolicyListDto.getTeamName());
        dbManager.setDouble(31,planting31PolicyListDto.getCentralPremium());
        dbManager.setDouble(32,planting31PolicyListDto.getProvincePremium());
        dbManager.setDouble(33,planting31PolicyListDto.getCityPremium());
        dbManager.setDouble(34,planting31PolicyListDto.getTownPremium());
        dbManager.setDouble(35,planting31PolicyListDto.getOtherPremium());
        dbManager.setString(36,planting31PolicyListDto.getFieldSource());
        dbManager.setString(37,planting31PolicyListDto.getMulChDate());
        dbManager.setString(38,planting31PolicyListDto.getMulChType());
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
        buffer.append("INSERT INTO Planting31PolicyList (");
        buffer.append("InusreListCode,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("IndexCode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("FareaCode,");
        buffer.append("TaxArea,");
        buffer.append("InsureArea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("ShortRateFlag,");
        buffer.append("ShortRate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("CalculateFlag,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("TeamName,");
        buffer.append("CentralPremium,");
        buffer.append("ProvincePremium,");
        buffer.append("CityPremium,");
        buffer.append("TownPremium,");
        buffer.append("OtherPremium,");
        buffer.append("FieldSource,");
        buffer.append("MulChDate,");
        buffer.append("MulChType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            Planting31PolicyListDto planting31PolicyListDto = (Planting31PolicyListDto)i.next();
            dbManager.setString(1,planting31PolicyListDto.getInusreListCode());
            dbManager.setString(2,planting31PolicyListDto.getFcode());
            dbManager.setString(3,planting31PolicyListDto.getKindCode());
            dbManager.setString(4,planting31PolicyListDto.getItemCode());
            dbManager.setString(5,planting31PolicyListDto.getIndexCode());
            dbManager.setString(6,planting31PolicyListDto.getPhone());
            dbManager.setString(7,planting31PolicyListDto.getBank());
            dbManager.setString(8,planting31PolicyListDto.getZhiBuKa());
            dbManager.setString(9,planting31PolicyListDto.getFname());
            dbManager.setString(10,planting31PolicyListDto.getFidCard());
            dbManager.setString(11,planting31PolicyListDto.getClassCode());
            dbManager.setString(12,planting31PolicyListDto.getRiskCode());
            dbManager.setString(13,planting31PolicyListDto.getFareaCode());
            dbManager.setDouble(14,planting31PolicyListDto.getTaxArea());
            dbManager.setDouble(15,planting31PolicyListDto.getInsureArea());
            dbManager.setDouble(16,planting31PolicyListDto.getAmount());
            dbManager.setDouble(17,planting31PolicyListDto.getRate());
            dbManager.setString(18,planting31PolicyListDto.getShortRateFlag());
            dbManager.setDouble(19,planting31PolicyListDto.getShortRate());
            dbManager.setDouble(20,planting31PolicyListDto.getSumAmount());
            dbManager.setDouble(21,planting31PolicyListDto.getSumPremium());
            dbManager.setDateTime(22,planting31PolicyListDto.getStartDate());
            dbManager.setDateTime(23,planting31PolicyListDto.getEndDate());
            dbManager.setString(24,planting31PolicyListDto.getCalculateFlag());
            dbManager.setString(25,planting31PolicyListDto.getOpCode());
            dbManager.setDateTime(26,planting31PolicyListDto.getOpTime());
            dbManager.setString(27,planting31PolicyListDto.getValidity());
            dbManager.setString(28,planting31PolicyListDto.getRemark());
            dbManager.setDouble(29,planting31PolicyListDto.getFpremium());
            dbManager.setString(30,planting31PolicyListDto.getTeamName());
            dbManager.setDouble(31,planting31PolicyListDto.getCentralPremium());
            dbManager.setDouble(32,planting31PolicyListDto.getProvincePremium());
            dbManager.setDouble(33,planting31PolicyListDto.getCityPremium());
            dbManager.setDouble(34,planting31PolicyListDto.getTownPremium());
            dbManager.setDouble(35,planting31PolicyListDto.getOtherPremium());
            dbManager.setString(36,planting31PolicyListDto.getFieldSource());
            dbManager.setString(37,planting31PolicyListDto.getMulChDate());
            dbManager.setString(38,planting31PolicyListDto.getMulChType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Planting31PolicyList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(inusreListCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusreListCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void update(Planting31PolicyListDto planting31PolicyListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Planting31PolicyList SET ");
        buffer.append("Fcode = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("ItemCode = ?, ");
        buffer.append("IndexCode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("ZhiBuKa = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("FidCard = ?, ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("FareaCode = ?, ");
        buffer.append("TaxArea = ?, ");
        buffer.append("InsureArea = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("ShortRateFlag = ?, ");
        buffer.append("ShortRate = ?, ");
        buffer.append("SumAmount = ?, ");
        buffer.append("SumPremium = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("CalculateFlag = ?, ");
        buffer.append("OpCode = ?, ");
        buffer.append("OpTime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Fpremium = ?, ");
        buffer.append("TeamName = ?, ");
        buffer.append("CentralPremium = ?, ");
        buffer.append("ProvincePremium = ?, ");
        buffer.append("CityPremium = ?, ");
        buffer.append("TownPremium = ?, ");
        buffer.append("OtherPremium = ?, ");
        buffer.append("FieldSource = ?, ");
        buffer.append("MulChDate = ?, ");
        buffer.append("MulChType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Planting31PolicyList SET ");
            debugBuffer.append("Fcode = '" + planting31PolicyListDto.getFcode() + "', ");
            debugBuffer.append("KindCode = '" + planting31PolicyListDto.getKindCode() + "', ");
            debugBuffer.append("ItemCode = '" + planting31PolicyListDto.getItemCode() + "', ");
            debugBuffer.append("IndexCode = '" + planting31PolicyListDto.getIndexCode() + "', ");
            debugBuffer.append("Phone = '" + planting31PolicyListDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + planting31PolicyListDto.getBank() + "', ");
            debugBuffer.append("ZhiBuKa = '" + planting31PolicyListDto.getZhiBuKa() + "', ");
            debugBuffer.append("Fname = '" + planting31PolicyListDto.getFname() + "', ");
            debugBuffer.append("FidCard = '" + planting31PolicyListDto.getFidCard() + "', ");
            debugBuffer.append("ClassCode = '" + planting31PolicyListDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + planting31PolicyListDto.getRiskCode() + "', ");
            debugBuffer.append("FareaCode = '" + planting31PolicyListDto.getFareaCode() + "', ");
            debugBuffer.append("TaxArea = " + planting31PolicyListDto.getTaxArea() + ", ");
            debugBuffer.append("InsureArea = " + planting31PolicyListDto.getInsureArea() + ", ");
            debugBuffer.append("Amount = " + planting31PolicyListDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + planting31PolicyListDto.getRate() + ", ");
            debugBuffer.append("ShortRateFlag = '" + planting31PolicyListDto.getShortRateFlag() + "', ");
            debugBuffer.append("ShortRate = " + planting31PolicyListDto.getShortRate() + ", ");
            debugBuffer.append("SumAmount = " + planting31PolicyListDto.getSumAmount() + ", ");
            debugBuffer.append("SumPremium = " + planting31PolicyListDto.getSumPremium() + ", ");
            debugBuffer.append("StartDate = '" + planting31PolicyListDto.getStartDate() + "', ");
            debugBuffer.append("EndDate = '" + planting31PolicyListDto.getEndDate() + "', ");
            debugBuffer.append("CalculateFlag = '" + planting31PolicyListDto.getCalculateFlag() + "', ");
            debugBuffer.append("OpCode = '" + planting31PolicyListDto.getOpCode() + "', ");
            debugBuffer.append("OpTime = '" + planting31PolicyListDto.getOpTime() + "', ");
            debugBuffer.append("Validity = '" + planting31PolicyListDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + planting31PolicyListDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + planting31PolicyListDto.getFpremium() + ", ");
            debugBuffer.append("TeamName = '" + planting31PolicyListDto.getTeamName() + "', ");
            debugBuffer.append("CentralPremium = " + planting31PolicyListDto.getCentralPremium() + ", ");
            debugBuffer.append("ProvincePremium = " + planting31PolicyListDto.getProvincePremium() + ", ");
            debugBuffer.append("CityPremium = " + planting31PolicyListDto.getCityPremium() + ", ");
            debugBuffer.append("TownPremium = " + planting31PolicyListDto.getTownPremium() + ", ");
            debugBuffer.append("OtherPremium = " + planting31PolicyListDto.getOtherPremium() + ", ");
            debugBuffer.append("FieldSource = '" + planting31PolicyListDto.getFieldSource() + "', ");
            debugBuffer.append("MulChDate = '" + planting31PolicyListDto.getMulChDate() + "', ");
            debugBuffer.append("MulChType = '" + planting31PolicyListDto.getMulChType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(planting31PolicyListDto.getInusreListCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,planting31PolicyListDto.getFcode());
        dbManager.setString(2,planting31PolicyListDto.getKindCode());
        dbManager.setString(3,planting31PolicyListDto.getItemCode());
        dbManager.setString(4,planting31PolicyListDto.getIndexCode());
        dbManager.setString(5,planting31PolicyListDto.getPhone());
        dbManager.setString(6,planting31PolicyListDto.getBank());
        dbManager.setString(7,planting31PolicyListDto.getZhiBuKa());
        dbManager.setString(8,planting31PolicyListDto.getFname());
        dbManager.setString(9,planting31PolicyListDto.getFidCard());
        dbManager.setString(10,planting31PolicyListDto.getClassCode());
        dbManager.setString(11,planting31PolicyListDto.getRiskCode());
        dbManager.setString(12,planting31PolicyListDto.getFareaCode());
        dbManager.setDouble(13,planting31PolicyListDto.getTaxArea());
        dbManager.setDouble(14,planting31PolicyListDto.getInsureArea());
        dbManager.setDouble(15,planting31PolicyListDto.getAmount());
        dbManager.setDouble(16,planting31PolicyListDto.getRate());
        dbManager.setString(17,planting31PolicyListDto.getShortRateFlag());
        dbManager.setDouble(18,planting31PolicyListDto.getShortRate());
        dbManager.setDouble(19,planting31PolicyListDto.getSumAmount());
        dbManager.setDouble(20,planting31PolicyListDto.getSumPremium());
        dbManager.setDateTime(21,planting31PolicyListDto.getStartDate());
        dbManager.setDateTime(22,planting31PolicyListDto.getEndDate());
        dbManager.setString(23,planting31PolicyListDto.getCalculateFlag());
        dbManager.setString(24,planting31PolicyListDto.getOpCode());
        dbManager.setDateTime(25,planting31PolicyListDto.getOpTime());
        dbManager.setString(26,planting31PolicyListDto.getValidity());
        dbManager.setString(27,planting31PolicyListDto.getRemark());
        dbManager.setDouble(28,planting31PolicyListDto.getFpremium());
        dbManager.setString(29,planting31PolicyListDto.getTeamName());
        dbManager.setDouble(30,planting31PolicyListDto.getCentralPremium());
        dbManager.setDouble(31,planting31PolicyListDto.getProvincePremium());
        dbManager.setDouble(32,planting31PolicyListDto.getCityPremium());
        dbManager.setDouble(33,planting31PolicyListDto.getTownPremium());
        dbManager.setDouble(34,planting31PolicyListDto.getOtherPremium());
        dbManager.setString(35,planting31PolicyListDto.getFieldSource());
        dbManager.setString(36,planting31PolicyListDto.getMulChDate());
        dbManager.setString(37,planting31PolicyListDto.getMulChType());
        //设置条件字段;
        dbManager.setString(38,planting31PolicyListDto.getInusreListCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusreListCode InusreListCode
     * @return Planting31PolicyListDto
     * @throws Exception
     */
    public Planting31PolicyListDto findByPrimaryKey(String inusreListCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("InusreListCode,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("IndexCode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("FareaCode,");
        buffer.append("TaxArea,");
        buffer.append("InsureArea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("ShortRateFlag,");
        buffer.append("ShortRate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("CalculateFlag,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("TeamName,");
        buffer.append("CentralPremium,");
        buffer.append("ProvincePremium,");
        buffer.append("CityPremium,");
        buffer.append("TownPremium,");
        buffer.append("OtherPremium,");
        buffer.append("FieldSource,");
        buffer.append("MulChDate,");
        buffer.append("MulChType ");
        buffer.append("FROM Planting31PolicyList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("InusreListCode=").append("'").append(inusreListCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("InusreListCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusreListCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        Planting31PolicyListDto planting31PolicyListDto = null;
        if(resultSet.next()){
            planting31PolicyListDto = new Planting31PolicyListDto();
            planting31PolicyListDto.setInusreListCode(dbManager.getString(resultSet,1));
            planting31PolicyListDto.setFcode(dbManager.getString(resultSet,2));
            planting31PolicyListDto.setKindCode(dbManager.getString(resultSet,3));
            planting31PolicyListDto.setItemCode(dbManager.getString(resultSet,4));
            planting31PolicyListDto.setIndexCode(dbManager.getString(resultSet,5));
            planting31PolicyListDto.setPhone(dbManager.getString(resultSet,6));
            planting31PolicyListDto.setBank(dbManager.getString(resultSet,7));
            planting31PolicyListDto.setZhiBuKa(dbManager.getString(resultSet,8));
            planting31PolicyListDto.setFname(dbManager.getString(resultSet,9));
            planting31PolicyListDto.setFidCard(dbManager.getString(resultSet,10));
            planting31PolicyListDto.setClassCode(dbManager.getString(resultSet,11));
            planting31PolicyListDto.setRiskCode(dbManager.getString(resultSet,12));
            planting31PolicyListDto.setFareaCode(dbManager.getString(resultSet,13));
            planting31PolicyListDto.setTaxArea(dbManager.getDouble(resultSet,14));
            planting31PolicyListDto.setInsureArea(dbManager.getDouble(resultSet,15));
            planting31PolicyListDto.setAmount(dbManager.getDouble(resultSet,16));
            planting31PolicyListDto.setRate(dbManager.getDouble(resultSet,17));
            planting31PolicyListDto.setShortRateFlag(dbManager.getString(resultSet,18));
            planting31PolicyListDto.setShortRate(dbManager.getDouble(resultSet,19));
            planting31PolicyListDto.setSumAmount(dbManager.getDouble(resultSet,20));
            planting31PolicyListDto.setSumPremium(dbManager.getDouble(resultSet,21));
            planting31PolicyListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            planting31PolicyListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            planting31PolicyListDto.setCalculateFlag(dbManager.getString(resultSet,24));
            planting31PolicyListDto.setOpCode(dbManager.getString(resultSet,25));
            planting31PolicyListDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,26));
            planting31PolicyListDto.setValidity(dbManager.getString(resultSet,27));
            planting31PolicyListDto.setRemark(dbManager.getString(resultSet,28));
            planting31PolicyListDto.setFpremium(dbManager.getDouble(resultSet,29));
            planting31PolicyListDto.setTeamName(dbManager.getString(resultSet,30));
            planting31PolicyListDto.setCentralPremium(dbManager.getDouble(resultSet,31));
            planting31PolicyListDto.setProvincePremium(dbManager.getDouble(resultSet,32));
            planting31PolicyListDto.setCityPremium(dbManager.getDouble(resultSet,33));
            planting31PolicyListDto.setTownPremium(dbManager.getDouble(resultSet,34));
            planting31PolicyListDto.setOtherPremium(dbManager.getDouble(resultSet,35));
            planting31PolicyListDto.setFieldSource(dbManager.getString(resultSet,36));
            planting31PolicyListDto.setMulChDate(dbManager.getString(resultSet,37));
            planting31PolicyListDto.setMulChType(dbManager.getString(resultSet,38));
        }
        resultSet.close();
        return planting31PolicyListDto;
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
        buffer.append("InusreListCode,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("IndexCode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("FareaCode,");
        buffer.append("TaxArea,");
        buffer.append("InsureArea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("ShortRateFlag,");
        buffer.append("ShortRate,");
        buffer.append("SumAmount,");
        buffer.append("SumPremium,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("CalculateFlag,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("TeamName,");
        buffer.append("CentralPremium,");
        buffer.append("ProvincePremium,");
        buffer.append("CityPremium,");
        buffer.append("TownPremium,");
        buffer.append("OtherPremium,");
        buffer.append("FieldSource,");
        buffer.append("MulChDate,");
        buffer.append("MulChType ");
        buffer.append("FROM Planting31PolicyList WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        Planting31PolicyListDto planting31PolicyListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            planting31PolicyListDto = new Planting31PolicyListDto();
            planting31PolicyListDto.setInusreListCode(dbManager.getString(resultSet,"InusreListCode"));
            planting31PolicyListDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            planting31PolicyListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            planting31PolicyListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            planting31PolicyListDto.setIndexCode(dbManager.getString(resultSet,"IndexCode"));
            planting31PolicyListDto.setPhone(dbManager.getString(resultSet,"Phone"));
            planting31PolicyListDto.setBank(dbManager.getString(resultSet,"Bank"));
            planting31PolicyListDto.setZhiBuKa(dbManager.getString(resultSet,"ZhiBuKa"));
            planting31PolicyListDto.setFname(dbManager.getString(resultSet,"Fname"));
            planting31PolicyListDto.setFidCard(dbManager.getString(resultSet,"FidCard"));
            planting31PolicyListDto.setClassCode(dbManager.getString(resultSet,"ClassCode"));
            planting31PolicyListDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            planting31PolicyListDto.setFareaCode(dbManager.getString(resultSet,"FareaCode"));
            planting31PolicyListDto.setTaxArea(dbManager.getDouble(resultSet,"TaxArea"));
            planting31PolicyListDto.setInsureArea(dbManager.getDouble(resultSet,"InsureArea"));
            planting31PolicyListDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            planting31PolicyListDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            planting31PolicyListDto.setShortRateFlag(dbManager.getString(resultSet,"ShortRateFlag"));
            planting31PolicyListDto.setShortRate(dbManager.getDouble(resultSet,"ShortRate"));
            planting31PolicyListDto.setSumAmount(dbManager.getDouble(resultSet,"SumAmount"));
            planting31PolicyListDto.setSumPremium(dbManager.getDouble(resultSet,"SumPremium"));
            planting31PolicyListDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"StartDate"));
            planting31PolicyListDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"EndDate"));
            planting31PolicyListDto.setCalculateFlag(dbManager.getString(resultSet,"CalculateFlag"));
            planting31PolicyListDto.setOpCode(dbManager.getString(resultSet,"OpCode"));
            planting31PolicyListDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"OpTime"));
            planting31PolicyListDto.setValidity(dbManager.getString(resultSet,"Validity"));
            planting31PolicyListDto.setRemark(dbManager.getString(resultSet,"Remark"));
            planting31PolicyListDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            planting31PolicyListDto.setTeamName(dbManager.getString(resultSet,"TeamName"));
            planting31PolicyListDto.setCentralPremium(dbManager.getDouble(resultSet,"CentralPremium"));
            planting31PolicyListDto.setProvincePremium(dbManager.getDouble(resultSet,"ProvincePremium"));
            planting31PolicyListDto.setCityPremium(dbManager.getDouble(resultSet,"CityPremium"));
            planting31PolicyListDto.setTownPremium(dbManager.getDouble(resultSet,"TownPremium"));
            planting31PolicyListDto.setOtherPremium(dbManager.getDouble(resultSet,"OtherPremium"));
            planting31PolicyListDto.setFieldSource(dbManager.getString(resultSet,"FieldSource"));
            planting31PolicyListDto.setMulChDate(dbManager.getString(resultSet,"MulChDate"));
            planting31PolicyListDto.setMulChType(dbManager.getString(resultSet,"MulChType"));
            collection.add(planting31PolicyListDto);
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
        buffer.append("DELETE FROM Planting31PolicyList WHERE ");
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
        buffer.append("SELECT count(*) FROM Planting31PolicyList WHERE ");
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
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
    	double sum = 0;
    	if(null!=fieldName && !"".equals(fieldName)){
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT sum("+fieldName+") FROM Planting31PolicyList WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        sum = dbManager.getDouble(resultSet,1);
	        resultSet.close();
    	}
        return sum;
    }
}
