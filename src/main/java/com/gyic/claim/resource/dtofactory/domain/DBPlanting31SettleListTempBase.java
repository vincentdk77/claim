package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListTempDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleListTemp的数据访问对象基类<br>
 */
public class DBPlanting31SettleListTempBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlanting31SettleListTempBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlanting31SettleListTempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void insert(Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Planting31SettleListTemp (");
        buffer.append("RegistCode,");
        buffer.append("StringTimeStamp,");
        buffer.append("IndexOfSettle,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("InsureArea,");
        buffer.append("SumInsured,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("FareaCode,");
        buffer.append("InusreListCode,");
        buffer.append("GrowingSeason,");
        buffer.append("LossRate,");
        buffer.append("SettleArea,");
        buffer.append("SettleSum,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("SettleDate,");
        buffer.append("ClaimRate,");
        buffer.append("NodeType,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(planting31SettleListTempDto.getRegistCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getStringTimeStamp()).append("',");
            debugBuffer.append("").append(planting31SettleListTempDto.getIndexOfSettle()).append(",");
            debugBuffer.append("'").append(planting31SettleListTempDto.getFcode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getKindCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getItemCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getClassCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getRiskCode()).append("',");
            debugBuffer.append("").append(planting31SettleListTempDto.getInsureArea()).append(",");
            debugBuffer.append("").append(planting31SettleListTempDto.getSumInsured()).append(",");
            debugBuffer.append("'").append(planting31SettleListTempDto.getZhiBuKa()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getFname()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getFidCard()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getFareaCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getInusreListCode()).append("',");
            debugBuffer.append("").append(planting31SettleListTempDto.getGrowingSeason()).append(",");
            debugBuffer.append("").append(planting31SettleListTempDto.getLossRate()).append(",");
            debugBuffer.append("").append(planting31SettleListTempDto.getSettleArea()).append(",");
            debugBuffer.append("").append(planting31SettleListTempDto.getSettleSum()).append(",");
            debugBuffer.append("'").append(planting31SettleListTempDto.getOpCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getOpTime()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getRemark()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getValidity()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getSettleDate()).append("',");
            debugBuffer.append("").append(planting31SettleListTempDto.getClaimRate()).append(",");
            debugBuffer.append("'").append(planting31SettleListTempDto.getNodeType()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getPhone()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getBank()).append("',");
            debugBuffer.append("'").append(planting31SettleListTempDto.getFieldSource()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,planting31SettleListTempDto.getRegistCode());
        dbManager.setString(2,planting31SettleListTempDto.getStringTimeStamp());
        dbManager.setInt(3,planting31SettleListTempDto.getIndexOfSettle());
        dbManager.setString(4,planting31SettleListTempDto.getFcode());
        dbManager.setString(5,planting31SettleListTempDto.getKindCode());
        dbManager.setString(6,planting31SettleListTempDto.getItemCode());
        dbManager.setString(7,planting31SettleListTempDto.getClassCode());
        dbManager.setString(8,planting31SettleListTempDto.getRiskCode());
        dbManager.setDouble(9,planting31SettleListTempDto.getInsureArea());
        dbManager.setDouble(10,planting31SettleListTempDto.getSumInsured());
        dbManager.setString(11,planting31SettleListTempDto.getZhiBuKa());
        dbManager.setString(12,planting31SettleListTempDto.getFname());
        dbManager.setString(13,planting31SettleListTempDto.getFidCard());
        dbManager.setString(14,planting31SettleListTempDto.getFareaCode());
        dbManager.setString(15,planting31SettleListTempDto.getInusreListCode());
        dbManager.setDouble(16,planting31SettleListTempDto.getGrowingSeason());
        dbManager.setDouble(17,planting31SettleListTempDto.getLossRate());
        dbManager.setDouble(18,planting31SettleListTempDto.getSettleArea());
        dbManager.setDouble(19,planting31SettleListTempDto.getSettleSum());
        dbManager.setString(20,planting31SettleListTempDto.getOpCode());
        dbManager.setDateTime(21,planting31SettleListTempDto.getOpTime());
        dbManager.setString(22,planting31SettleListTempDto.getRemark());
        dbManager.setString(23,planting31SettleListTempDto.getValidity());
        dbManager.setDateTime(24,planting31SettleListTempDto.getSettleDate());
        dbManager.setDouble(25,planting31SettleListTempDto.getClaimRate());
        dbManager.setString(26,planting31SettleListTempDto.getNodeType());
        dbManager.setString(27,planting31SettleListTempDto.getPhone());
        dbManager.setString(28,planting31SettleListTempDto.getBank());
        dbManager.setString(29,planting31SettleListTempDto.getFieldSource());
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
        buffer.append("INSERT INTO Planting31SettleListTemp (");
        buffer.append("RegistCode,");
        buffer.append("StringTimeStamp,");
        buffer.append("IndexOfSettle,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("InsureArea,");
        buffer.append("SumInsured,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("FareaCode,");
        buffer.append("InusreListCode,");
        buffer.append("GrowingSeason,");
        buffer.append("LossRate,");
        buffer.append("SettleArea,");
        buffer.append("SettleSum,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("SettleDate,");
        buffer.append("ClaimRate,");
        buffer.append("NodeType,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            Planting31SettleListTempDto planting31SettleListTempDto = (Planting31SettleListTempDto)i.next();
            dbManager.setString(1,planting31SettleListTempDto.getRegistCode());
            dbManager.setString(2,planting31SettleListTempDto.getStringTimeStamp());
            dbManager.setInt(3,planting31SettleListTempDto.getIndexOfSettle());
            dbManager.setString(4,planting31SettleListTempDto.getFcode());
            dbManager.setString(5,planting31SettleListTempDto.getKindCode());
            dbManager.setString(6,planting31SettleListTempDto.getItemCode());
            dbManager.setString(7,planting31SettleListTempDto.getClassCode());
            dbManager.setString(8,planting31SettleListTempDto.getRiskCode());
            dbManager.setDouble(9,planting31SettleListTempDto.getInsureArea());
            dbManager.setDouble(10,planting31SettleListTempDto.getSumInsured());
            dbManager.setString(11,planting31SettleListTempDto.getZhiBuKa());
            dbManager.setString(12,planting31SettleListTempDto.getFname());
            dbManager.setString(13,planting31SettleListTempDto.getFidCard());
            dbManager.setString(14,planting31SettleListTempDto.getFareaCode());
            dbManager.setString(15,planting31SettleListTempDto.getInusreListCode());
            dbManager.setDouble(16,planting31SettleListTempDto.getGrowingSeason());
            dbManager.setDouble(17,planting31SettleListTempDto.getLossRate());
            dbManager.setDouble(18,planting31SettleListTempDto.getSettleArea());
            dbManager.setDouble(19,planting31SettleListTempDto.getSettleSum());
            dbManager.setString(20,planting31SettleListTempDto.getOpCode());
            dbManager.setDateTime(21,planting31SettleListTempDto.getOpTime());
            dbManager.setString(22,planting31SettleListTempDto.getRemark());
            dbManager.setString(23,planting31SettleListTempDto.getValidity());
            dbManager.setDateTime(24,planting31SettleListTempDto.getSettleDate());
            dbManager.setDouble(25,planting31SettleListTempDto.getClaimRate());
            dbManager.setString(26,planting31SettleListTempDto.getNodeType());
            dbManager.setString(27,planting31SettleListTempDto.getPhone());
            dbManager.setString(28,planting31SettleListTempDto.getBank());
            dbManager.setString(29,planting31SettleListTempDto.getFieldSource());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Planting31SettleListTemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistCode=").append("'").append(registCode).append("' AND ");
            debugBuffer.append("StringTimeStamp=").append("'").append(stringTimeStamp).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(indexOfSettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistCode = ? And ");
        buffer.append("StringTimeStamp = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registCode);
        dbManager.setString(2,stringTimeStamp);
        dbManager.setInt(3,indexOfSettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param planting31SettleListTempDto planting31SettleListTempDto
     * @throws Exception
     */
    public void update(Planting31SettleListTempDto planting31SettleListTempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Planting31SettleListTemp SET ");
        buffer.append("Fcode = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("ItemCode = ?, ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("InsureArea = ?, ");
        buffer.append("SumInsured = ?, ");
        buffer.append("ZhiBuKa = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("FidCard = ?, ");
        buffer.append("FareaCode = ?, ");
        buffer.append("InusreListCode = ?, ");
        buffer.append("GrowingSeason = ?, ");
        buffer.append("LossRate = ?, ");
        buffer.append("SettleArea = ?, ");
        buffer.append("SettleSum = ?, ");
        buffer.append("OpCode = ?, ");
        buffer.append("OpTime = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("SettleDate = ?, ");
        buffer.append("ClaimRate = ?, ");
        buffer.append("NodeType = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("FieldSource = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Planting31SettleListTemp SET ");
            debugBuffer.append("Fcode = '" + planting31SettleListTempDto.getFcode() + "', ");
            debugBuffer.append("KindCode = '" + planting31SettleListTempDto.getKindCode() + "', ");
            debugBuffer.append("ItemCode = '" + planting31SettleListTempDto.getItemCode() + "', ");
            debugBuffer.append("ClassCode = '" + planting31SettleListTempDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + planting31SettleListTempDto.getRiskCode() + "', ");
            debugBuffer.append("InsureArea = " + planting31SettleListTempDto.getInsureArea() + ", ");
            debugBuffer.append("SumInsured = " + planting31SettleListTempDto.getSumInsured() + ", ");
            debugBuffer.append("ZhiBuKa = '" + planting31SettleListTempDto.getZhiBuKa() + "', ");
            debugBuffer.append("Fname = '" + planting31SettleListTempDto.getFname() + "', ");
            debugBuffer.append("FidCard = '" + planting31SettleListTempDto.getFidCard() + "', ");
            debugBuffer.append("FareaCode = '" + planting31SettleListTempDto.getFareaCode() + "', ");
            debugBuffer.append("InusreListCode = '" + planting31SettleListTempDto.getInusreListCode() + "', ");
            debugBuffer.append("GrowingSeason = " + planting31SettleListTempDto.getGrowingSeason() + ", ");
            debugBuffer.append("LossRate = " + planting31SettleListTempDto.getLossRate() + ", ");
            debugBuffer.append("SettleArea = " + planting31SettleListTempDto.getSettleArea() + ", ");
            debugBuffer.append("SettleSum = " + planting31SettleListTempDto.getSettleSum() + ", ");
            debugBuffer.append("OpCode = '" + planting31SettleListTempDto.getOpCode() + "', ");
            debugBuffer.append("OpTime = '" + planting31SettleListTempDto.getOpTime() + "', ");
            debugBuffer.append("Remark = '" + planting31SettleListTempDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + planting31SettleListTempDto.getValidity() + "', ");
            debugBuffer.append("SettleDate = '" + planting31SettleListTempDto.getSettleDate() + "', ");
            debugBuffer.append("ClaimRate = " + planting31SettleListTempDto.getClaimRate() + ", ");
            debugBuffer.append("NodeType = '" + planting31SettleListTempDto.getNodeType() + "', ");
            debugBuffer.append("Phone = '" + planting31SettleListTempDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + planting31SettleListTempDto.getBank() + "', ");
            debugBuffer.append("FieldSource = '" + planting31SettleListTempDto.getFieldSource() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistCode=").append("'").append(planting31SettleListTempDto.getRegistCode()).append("' AND ");
            debugBuffer.append("StringTimeStamp=").append("'").append(planting31SettleListTempDto.getStringTimeStamp()).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(planting31SettleListTempDto.getIndexOfSettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistCode = ? And ");
        buffer.append("StringTimeStamp = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,planting31SettleListTempDto.getFcode());
        dbManager.setString(2,planting31SettleListTempDto.getKindCode());
        dbManager.setString(3,planting31SettleListTempDto.getItemCode());
        dbManager.setString(4,planting31SettleListTempDto.getClassCode());
        dbManager.setString(5,planting31SettleListTempDto.getRiskCode());
        dbManager.setDouble(6,planting31SettleListTempDto.getInsureArea());
        dbManager.setDouble(7,planting31SettleListTempDto.getSumInsured());
        dbManager.setString(8,planting31SettleListTempDto.getZhiBuKa());
        dbManager.setString(9,planting31SettleListTempDto.getFname());
        dbManager.setString(10,planting31SettleListTempDto.getFidCard());
        dbManager.setString(11,planting31SettleListTempDto.getFareaCode());
        dbManager.setString(12,planting31SettleListTempDto.getInusreListCode());
        dbManager.setDouble(13,planting31SettleListTempDto.getGrowingSeason());
        dbManager.setDouble(14,planting31SettleListTempDto.getLossRate());
        dbManager.setDouble(15,planting31SettleListTempDto.getSettleArea());
        dbManager.setDouble(16,planting31SettleListTempDto.getSettleSum());
        dbManager.setString(17,planting31SettleListTempDto.getOpCode());
        dbManager.setDateTime(18,planting31SettleListTempDto.getOpTime());
        dbManager.setString(19,planting31SettleListTempDto.getRemark());
        dbManager.setString(20,planting31SettleListTempDto.getValidity());
        dbManager.setDateTime(21,planting31SettleListTempDto.getSettleDate());
        dbManager.setDouble(22,planting31SettleListTempDto.getClaimRate());
        dbManager.setString(23,planting31SettleListTempDto.getNodeType());
        dbManager.setString(24,planting31SettleListTempDto.getPhone());
        dbManager.setString(25,planting31SettleListTempDto.getBank());
        dbManager.setString(26,planting31SettleListTempDto.getFieldSource());
        //设置条件字段;
        dbManager.setString(27,planting31SettleListTempDto.getRegistCode());
        dbManager.setString(28,planting31SettleListTempDto.getStringTimeStamp());
        dbManager.setInt(29,planting31SettleListTempDto.getIndexOfSettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registCode RegistCode
     * @param stringTimeStamp StringTimeStamp
     * @param indexOfSettle IndexOfSettle
     * @return Planting31SettleListTempDto
     * @throws Exception
     */
    public Planting31SettleListTempDto findByPrimaryKey(String registCode,String stringTimeStamp,int indexOfSettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistCode,");
        buffer.append("StringTimeStamp,");
        buffer.append("IndexOfSettle,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("InsureArea,");
        buffer.append("SumInsured,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("FareaCode,");
        buffer.append("InusreListCode,");
        buffer.append("GrowingSeason,");
        buffer.append("LossRate,");
        buffer.append("SettleArea,");
        buffer.append("SettleSum,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("SettleDate,");
        buffer.append("ClaimRate,");
        buffer.append("NodeType,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource ");
        buffer.append("FROM Planting31SettleListTemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistCode=").append("'").append(registCode).append("' AND ");
            debugBuffer.append("StringTimeStamp=").append("'").append(stringTimeStamp).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(indexOfSettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistCode = ? And ");
        buffer.append("StringTimeStamp = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registCode);
        dbManager.setString(2,stringTimeStamp);
        dbManager.setInt(3,indexOfSettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        Planting31SettleListTempDto planting31SettleListTempDto = null;
        if(resultSet.next()){
            planting31SettleListTempDto = new Planting31SettleListTempDto();
            planting31SettleListTempDto.setRegistCode(dbManager.getString(resultSet,1));
            planting31SettleListTempDto.setStringTimeStamp(dbManager.getString(resultSet,2));
            planting31SettleListTempDto.setIndexOfSettle(dbManager.getInt(resultSet,3));
            planting31SettleListTempDto.setFcode(dbManager.getString(resultSet,4));
            planting31SettleListTempDto.setKindCode(dbManager.getString(resultSet,5));
            planting31SettleListTempDto.setItemCode(dbManager.getString(resultSet,6));
            planting31SettleListTempDto.setClassCode(dbManager.getString(resultSet,7));
            planting31SettleListTempDto.setRiskCode(dbManager.getString(resultSet,8));
            planting31SettleListTempDto.setInsureArea(dbManager.getDouble(resultSet,9));
            planting31SettleListTempDto.setSumInsured(dbManager.getDouble(resultSet,10));
            planting31SettleListTempDto.setZhiBuKa(dbManager.getString(resultSet,11));
            planting31SettleListTempDto.setFname(dbManager.getString(resultSet,12));
            planting31SettleListTempDto.setFidCard(dbManager.getString(resultSet,13));
            planting31SettleListTempDto.setFareaCode(dbManager.getString(resultSet,14));
            planting31SettleListTempDto.setInusreListCode(dbManager.getString(resultSet,15));
            planting31SettleListTempDto.setGrowingSeason(dbManager.getDouble(resultSet,16));
            planting31SettleListTempDto.setLossRate(dbManager.getDouble(resultSet,17));
            planting31SettleListTempDto.setSettleArea(dbManager.getDouble(resultSet,18));
            planting31SettleListTempDto.setSettleSum(dbManager.getDouble(resultSet,19));
            planting31SettleListTempDto.setOpCode(dbManager.getString(resultSet,20));
            planting31SettleListTempDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,21));
            planting31SettleListTempDto.setRemark(dbManager.getString(resultSet,22));
            planting31SettleListTempDto.setValidity(dbManager.getString(resultSet,23));
            planting31SettleListTempDto.setSettleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            planting31SettleListTempDto.setClaimRate(dbManager.getDouble(resultSet,25));
            planting31SettleListTempDto.setNodeType(dbManager.getString(resultSet,26));
            planting31SettleListTempDto.setPhone(dbManager.getString(resultSet,27));
            planting31SettleListTempDto.setBank(dbManager.getString(resultSet,28));
            planting31SettleListTempDto.setFieldSource(dbManager.getString(resultSet,29));
        }
        resultSet.close();
        return planting31SettleListTempDto;
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
        buffer.append("RegistCode,");
        buffer.append("StringTimeStamp,");
        buffer.append("IndexOfSettle,");
        buffer.append("Fcode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("InsureArea,");
        buffer.append("SumInsured,");
        buffer.append("ZhiBuKa,");
        buffer.append("Fname,");
        buffer.append("FidCard,");
        buffer.append("FareaCode,");
        buffer.append("InusreListCode,");
        buffer.append("GrowingSeason,");
        buffer.append("LossRate,");
        buffer.append("SettleArea,");
        buffer.append("SettleSum,");
        buffer.append("OpCode,");
        buffer.append("OpTime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("SettleDate,");
        buffer.append("ClaimRate,");
        buffer.append("NodeType,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource ");
        buffer.append("FROM Planting31SettleListTemp WHERE ");
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
        Planting31SettleListTempDto planting31SettleListTempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            planting31SettleListTempDto = new Planting31SettleListTempDto();
            planting31SettleListTempDto.setRegistCode(dbManager.getString(resultSet,"RegistCode"));
            planting31SettleListTempDto.setStringTimeStamp(dbManager.getString(resultSet,"StringTimeStamp"));
            planting31SettleListTempDto.setIndexOfSettle(dbManager.getInt(resultSet,"IndexOfSettle"));
            planting31SettleListTempDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            planting31SettleListTempDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            planting31SettleListTempDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            planting31SettleListTempDto.setClassCode(dbManager.getString(resultSet,"ClassCode"));
            planting31SettleListTempDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            planting31SettleListTempDto.setInsureArea(dbManager.getDouble(resultSet,"InsureArea"));
            planting31SettleListTempDto.setSumInsured(dbManager.getDouble(resultSet,"SumInsured"));
            planting31SettleListTempDto.setZhiBuKa(dbManager.getString(resultSet,"ZhiBuKa"));
            planting31SettleListTempDto.setFname(dbManager.getString(resultSet,"Fname"));
            planting31SettleListTempDto.setFidCard(dbManager.getString(resultSet,"FidCard"));
            planting31SettleListTempDto.setFareaCode(dbManager.getString(resultSet,"FareaCode"));
            planting31SettleListTempDto.setInusreListCode(dbManager.getString(resultSet,"InusreListCode"));
            planting31SettleListTempDto.setGrowingSeason(dbManager.getDouble(resultSet,"GrowingSeason"));
            planting31SettleListTempDto.setLossRate(dbManager.getDouble(resultSet,"LossRate"));
            planting31SettleListTempDto.setSettleArea(dbManager.getDouble(resultSet,"SettleArea"));
            planting31SettleListTempDto.setSettleSum(dbManager.getDouble(resultSet,"SettleSum"));
            planting31SettleListTempDto.setOpCode(dbManager.getString(resultSet,"OpCode"));
            planting31SettleListTempDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"OpTime"));
            planting31SettleListTempDto.setRemark(dbManager.getString(resultSet,"Remark"));
            planting31SettleListTempDto.setValidity(dbManager.getString(resultSet,"Validity"));
            planting31SettleListTempDto.setSettleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"SettleDate"));
            planting31SettleListTempDto.setClaimRate(dbManager.getDouble(resultSet,"ClaimRate"));
            planting31SettleListTempDto.setNodeType(dbManager.getString(resultSet,"NodeType"));
            planting31SettleListTempDto.setPhone(dbManager.getString(resultSet,"Phone"));
            planting31SettleListTempDto.setBank(dbManager.getString(resultSet,"Bank"));
            planting31SettleListTempDto.setFieldSource(dbManager.getString(resultSet,"FieldSource"));
            collection.add(planting31SettleListTempDto);
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
        buffer.append("DELETE FROM Planting31SettleListTemp WHERE ");
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
        buffer.append("SELECT count(*) FROM Planting31SettleListTemp WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM Planting31SettleListTemp WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        while(resultSet.next()){
	        	sum = dbManager.getDouble(resultSet,1);
	        	continue;
	        }
	        resultSet.close();
    	}
        return sum;
    }
}
