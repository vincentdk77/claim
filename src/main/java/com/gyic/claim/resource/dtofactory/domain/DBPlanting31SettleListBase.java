package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleList的数据访问对象基类<br>
 */
public class DBPlanting31SettleListBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlanting31SettleListBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlanting31SettleListBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void insert(Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Planting31SettleList (");
        buffer.append("SettleListCode,");
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
        buffer.append("IndexOfSettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource,");
        buffer.append("FcodeModify ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(planting31SettleListDto.getSettleListCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFcode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getKindCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getItemCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getClassCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getRiskCode()).append("',");
            debugBuffer.append("").append(planting31SettleListDto.getInsureArea()).append(",");
            debugBuffer.append("").append(planting31SettleListDto.getSumInsured()).append(",");
            debugBuffer.append("'").append(planting31SettleListDto.getZhiBuKa()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFname()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFidCard()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFareaCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getInusreListCode()).append("',");
            debugBuffer.append("").append(planting31SettleListDto.getGrowingSeason()).append(",");
            debugBuffer.append("").append(planting31SettleListDto.getLossRate()).append(",");
            debugBuffer.append("").append(planting31SettleListDto.getSettleArea()).append(",");
            debugBuffer.append("").append(planting31SettleListDto.getSettleSum()).append(",");
            debugBuffer.append("'").append(planting31SettleListDto.getOpCode()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getOpTime()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getRemark()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getValidity()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getSettleDate()).append("',");
            debugBuffer.append("").append(planting31SettleListDto.getClaimRate()).append(",");
            debugBuffer.append("'").append(planting31SettleListDto.getNodeType()).append("',");
            debugBuffer.append("").append(planting31SettleListDto.getIndexOfSettle()).append(",");
            debugBuffer.append("'").append(planting31SettleListDto.getPhone()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getBank()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFieldSource()).append("',");
            debugBuffer.append("'").append(planting31SettleListDto.getFcodeModify()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,planting31SettleListDto.getSettleListCode());
        dbManager.setString(2,planting31SettleListDto.getFcode());
        dbManager.setString(3,planting31SettleListDto.getKindCode());
        dbManager.setString(4,planting31SettleListDto.getItemCode());
        dbManager.setString(5,planting31SettleListDto.getClassCode());
        dbManager.setString(6,planting31SettleListDto.getRiskCode());
        dbManager.setDouble(7,planting31SettleListDto.getInsureArea());
        dbManager.setDouble(8,planting31SettleListDto.getSumInsured());
        dbManager.setString(9,planting31SettleListDto.getZhiBuKa());
        dbManager.setString(10,planting31SettleListDto.getFname());
        dbManager.setString(11,planting31SettleListDto.getFidCard());
        dbManager.setString(12,planting31SettleListDto.getFareaCode());
        dbManager.setString(13,planting31SettleListDto.getInusreListCode());
        dbManager.setDouble(14,planting31SettleListDto.getGrowingSeason());
        dbManager.setDouble(15,planting31SettleListDto.getLossRate());
        dbManager.setDouble(16,planting31SettleListDto.getSettleArea());
        dbManager.setDouble(17,planting31SettleListDto.getSettleSum());
        dbManager.setString(18,planting31SettleListDto.getOpCode());
        dbManager.setDateTime(19,planting31SettleListDto.getOpTime());
        dbManager.setString(20,planting31SettleListDto.getRemark());
        dbManager.setString(21,planting31SettleListDto.getValidity());
        dbManager.setDateTime(22,planting31SettleListDto.getSettleDate());
        dbManager.setDouble(23,planting31SettleListDto.getClaimRate());
        dbManager.setString(24,planting31SettleListDto.getNodeType());
        dbManager.setInt(25,planting31SettleListDto.getIndexOfSettle());
        dbManager.setString(26,planting31SettleListDto.getPhone());
        dbManager.setString(27,planting31SettleListDto.getBank());
        dbManager.setString(28,planting31SettleListDto.getFieldSource());
        dbManager.setString(29,planting31SettleListDto.getFcodeModify());
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
        buffer.append("INSERT INTO Planting31SettleList (");
        buffer.append("SettleListCode,");
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
        buffer.append("IndexOfSettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource,");
        buffer.append("FcodeModify ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            Planting31SettleListDto planting31SettleListDto = (Planting31SettleListDto)i.next();
            dbManager.setString(1,planting31SettleListDto.getSettleListCode());
            dbManager.setString(2,planting31SettleListDto.getFcode());
            dbManager.setString(3,planting31SettleListDto.getKindCode());
            dbManager.setString(4,planting31SettleListDto.getItemCode());
            dbManager.setString(5,planting31SettleListDto.getClassCode());
            dbManager.setString(6,planting31SettleListDto.getRiskCode());
            dbManager.setDouble(7,planting31SettleListDto.getInsureArea());
            dbManager.setDouble(8,planting31SettleListDto.getSumInsured());
            dbManager.setString(9,planting31SettleListDto.getZhiBuKa());
            dbManager.setString(10,planting31SettleListDto.getFname());
            dbManager.setString(11,planting31SettleListDto.getFidCard());
            dbManager.setString(12,planting31SettleListDto.getFareaCode());
            dbManager.setString(13,planting31SettleListDto.getInusreListCode());
            dbManager.setDouble(14,planting31SettleListDto.getGrowingSeason());
            dbManager.setDouble(15,planting31SettleListDto.getLossRate());
            dbManager.setDouble(16,planting31SettleListDto.getSettleArea());
            dbManager.setDouble(17,planting31SettleListDto.getSettleSum());
            dbManager.setString(18,planting31SettleListDto.getOpCode());
            dbManager.setDateTime(19,planting31SettleListDto.getOpTime());
            dbManager.setString(20,planting31SettleListDto.getRemark());
            dbManager.setString(21,planting31SettleListDto.getValidity());
            dbManager.setDateTime(22,planting31SettleListDto.getSettleDate());
            dbManager.setDouble(23,planting31SettleListDto.getClaimRate());
            dbManager.setString(24,planting31SettleListDto.getNodeType());
            dbManager.setInt(25,planting31SettleListDto.getIndexOfSettle());
            dbManager.setString(26,planting31SettleListDto.getPhone());
            dbManager.setString(27,planting31SettleListDto.getBank());
            dbManager.setString(28,planting31SettleListDto.getFieldSource());
            dbManager.setString(29,planting31SettleListDto.getFcodeModify());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Planting31SettleList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("SettleListCode=").append("'").append(settleListCode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(itemCode).append("' AND ");
            debugBuffer.append("NodeType=").append("'").append(nodeType).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(indexOfSettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("SettleListCode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ? And ");
        buffer.append("NodeType = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settleListCode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,itemCode);
        dbManager.setString(5,nodeType);
        dbManager.setInt(6,indexOfSettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void update(Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Planting31SettleList SET ");
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
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("FieldSource = ?, ");
        buffer.append("FcodeModify = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Planting31SettleList SET ");
            debugBuffer.append("ClassCode = '" + planting31SettleListDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + planting31SettleListDto.getRiskCode() + "', ");
            debugBuffer.append("InsureArea = " + planting31SettleListDto.getInsureArea() + ", ");
            debugBuffer.append("SumInsured = " + planting31SettleListDto.getSumInsured() + ", ");
            debugBuffer.append("ZhiBuKa = '" + planting31SettleListDto.getZhiBuKa() + "', ");
            debugBuffer.append("Fname = '" + planting31SettleListDto.getFname() + "', ");
            debugBuffer.append("FidCard = '" + planting31SettleListDto.getFidCard() + "', ");
            debugBuffer.append("FareaCode = '" + planting31SettleListDto.getFareaCode() + "', ");
            debugBuffer.append("InusreListCode = '" + planting31SettleListDto.getInusreListCode() + "', ");
            debugBuffer.append("GrowingSeason = " + planting31SettleListDto.getGrowingSeason() + ", ");
            debugBuffer.append("LossRate = " + planting31SettleListDto.getLossRate() + ", ");
            debugBuffer.append("SettleArea = " + planting31SettleListDto.getSettleArea() + ", ");
            debugBuffer.append("SettleSum = " + planting31SettleListDto.getSettleSum() + ", ");
            debugBuffer.append("OpCode = '" + planting31SettleListDto.getOpCode() + "', ");
            debugBuffer.append("OpTime = '" + planting31SettleListDto.getOpTime() + "', ");
            debugBuffer.append("Remark = '" + planting31SettleListDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + planting31SettleListDto.getValidity() + "', ");
            debugBuffer.append("SettleDate = '" + planting31SettleListDto.getSettleDate() + "', ");
            debugBuffer.append("ClaimRate = " + planting31SettleListDto.getClaimRate() + ", ");
            debugBuffer.append("Phone = '" + planting31SettleListDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + planting31SettleListDto.getBank() + "', ");
            debugBuffer.append("FieldSource = '" + planting31SettleListDto.getFieldSource() + "', ");
            debugBuffer.append("FcodeModify = '" + planting31SettleListDto.getFcodeModify() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("SettleListCode=").append("'").append(planting31SettleListDto.getSettleListCode()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(planting31SettleListDto.getFcode()).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(planting31SettleListDto.getKindCode()).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(planting31SettleListDto.getItemCode()).append("' AND ");
            debugBuffer.append("NodeType=").append("'").append(planting31SettleListDto.getNodeType()).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(planting31SettleListDto.getIndexOfSettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("SettleListCode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ? And ");
        buffer.append("NodeType = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,planting31SettleListDto.getClassCode());
        dbManager.setString(2,planting31SettleListDto.getRiskCode());
        dbManager.setDouble(3,planting31SettleListDto.getInsureArea());
        dbManager.setDouble(4,planting31SettleListDto.getSumInsured());
        dbManager.setString(5,planting31SettleListDto.getZhiBuKa());
        dbManager.setString(6,planting31SettleListDto.getFname());
        dbManager.setString(7,planting31SettleListDto.getFidCard());
        dbManager.setString(8,planting31SettleListDto.getFareaCode());
        dbManager.setString(9,planting31SettleListDto.getInusreListCode());
        dbManager.setDouble(10,planting31SettleListDto.getGrowingSeason());
        dbManager.setDouble(11,planting31SettleListDto.getLossRate());
        dbManager.setDouble(12,planting31SettleListDto.getSettleArea());
        dbManager.setDouble(13,planting31SettleListDto.getSettleSum());
        dbManager.setString(14,planting31SettleListDto.getOpCode());
        dbManager.setDateTime(15,planting31SettleListDto.getOpTime());
        dbManager.setString(16,planting31SettleListDto.getRemark());
        dbManager.setString(17,planting31SettleListDto.getValidity());
        dbManager.setDateTime(18,planting31SettleListDto.getSettleDate());
        dbManager.setDouble(19,planting31SettleListDto.getClaimRate());
        dbManager.setString(20,planting31SettleListDto.getPhone());
        dbManager.setString(21,planting31SettleListDto.getBank());
        dbManager.setString(22,planting31SettleListDto.getFieldSource());
        dbManager.setString(23,planting31SettleListDto.getFcodeModify());
        //设置条件字段;
        dbManager.setString(24,planting31SettleListDto.getSettleListCode());
        dbManager.setString(25,planting31SettleListDto.getFcode());
        dbManager.setString(26,planting31SettleListDto.getKindCode());
        dbManager.setString(27,planting31SettleListDto.getItemCode());
        dbManager.setString(28,planting31SettleListDto.getNodeType());
        dbManager.setInt(29,planting31SettleListDto.getIndexOfSettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @return Planting31SettleListDto
     * @throws Exception
     */
    public Planting31SettleListDto findByPrimaryKey(String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("SettleListCode,");
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
        buffer.append("IndexOfSettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource,");
        buffer.append("FcodeModify ");
        buffer.append("FROM Planting31SettleList ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("SettleListCode=").append("'").append(settleListCode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(itemCode).append("' AND ");
            debugBuffer.append("NodeType=").append("'").append(nodeType).append("' AND ");
            debugBuffer.append("IndexOfSettle=").append("").append(indexOfSettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("SettleListCode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ? And ");
        buffer.append("NodeType = ? And ");
        buffer.append("IndexOfSettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settleListCode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,itemCode);
        dbManager.setString(5,nodeType);
        dbManager.setInt(6,indexOfSettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        Planting31SettleListDto planting31SettleListDto = null;
        if(resultSet.next()){
            planting31SettleListDto = new Planting31SettleListDto();
            planting31SettleListDto.setSettleListCode(dbManager.getString(resultSet,1));
            planting31SettleListDto.setFcode(dbManager.getString(resultSet,2));
            planting31SettleListDto.setKindCode(dbManager.getString(resultSet,3));
            planting31SettleListDto.setItemCode(dbManager.getString(resultSet,4));
            planting31SettleListDto.setClassCode(dbManager.getString(resultSet,5));
            planting31SettleListDto.setRiskCode(dbManager.getString(resultSet,6));
            planting31SettleListDto.setInsureArea(dbManager.getDouble(resultSet,7));
            planting31SettleListDto.setSumInsured(dbManager.getDouble(resultSet,8));
            planting31SettleListDto.setZhiBuKa(dbManager.getString(resultSet,9));
            planting31SettleListDto.setFname(dbManager.getString(resultSet,10));
            planting31SettleListDto.setFidCard(dbManager.getString(resultSet,11));
            planting31SettleListDto.setFareaCode(dbManager.getString(resultSet,12));
            planting31SettleListDto.setInusreListCode(dbManager.getString(resultSet,13));
            planting31SettleListDto.setGrowingSeason(dbManager.getDouble(resultSet,14));
            planting31SettleListDto.setLossRate(dbManager.getDouble(resultSet,15));
            planting31SettleListDto.setSettleArea(dbManager.getDouble(resultSet,16));
            planting31SettleListDto.setSettleSum(dbManager.getDouble(resultSet,17));
            planting31SettleListDto.setOpCode(dbManager.getString(resultSet,18));
            planting31SettleListDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,19));
            planting31SettleListDto.setRemark(dbManager.getString(resultSet,20));
            planting31SettleListDto.setValidity(dbManager.getString(resultSet,21));
            planting31SettleListDto.setSettleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            planting31SettleListDto.setClaimRate(dbManager.getDouble(resultSet,23));
            planting31SettleListDto.setNodeType(dbManager.getString(resultSet,24));
            planting31SettleListDto.setIndexOfSettle(dbManager.getInt(resultSet,25));
            planting31SettleListDto.setPhone(dbManager.getString(resultSet,26));
            planting31SettleListDto.setBank(dbManager.getString(resultSet,27));
            planting31SettleListDto.setFieldSource(dbManager.getString(resultSet,28));
            planting31SettleListDto.setFcodeModify(dbManager.getString(resultSet,29));
        }
        resultSet.close();
        return planting31SettleListDto;
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
        buffer.append("SettleListCode,");
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
        buffer.append("IndexOfSettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("FieldSource,");
        buffer.append("FcodeModify ");
        buffer.append("FROM Planting31SettleList WHERE ");
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
        Planting31SettleListDto planting31SettleListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            planting31SettleListDto = new Planting31SettleListDto();
            planting31SettleListDto.setSettleListCode(dbManager.getString(resultSet,"SettleListCode"));
            planting31SettleListDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            planting31SettleListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            planting31SettleListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            planting31SettleListDto.setClassCode(dbManager.getString(resultSet,"ClassCode"));
            planting31SettleListDto.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            planting31SettleListDto.setInsureArea(dbManager.getDouble(resultSet,"InsureArea"));
            planting31SettleListDto.setSumInsured(dbManager.getDouble(resultSet,"SumInsured"));
            planting31SettleListDto.setZhiBuKa(dbManager.getString(resultSet,"ZhiBuKa"));
            planting31SettleListDto.setFname(dbManager.getString(resultSet,"Fname"));
            planting31SettleListDto.setFidCard(dbManager.getString(resultSet,"FidCard"));
            planting31SettleListDto.setFareaCode(dbManager.getString(resultSet,"FareaCode"));
            planting31SettleListDto.setInusreListCode(dbManager.getString(resultSet,"InusreListCode"));
            planting31SettleListDto.setGrowingSeason(dbManager.getDouble(resultSet,"GrowingSeason"));
            planting31SettleListDto.setLossRate(dbManager.getDouble(resultSet,"LossRate"));
            planting31SettleListDto.setSettleArea(dbManager.getDouble(resultSet,"SettleArea"));
            planting31SettleListDto.setSettleSum(dbManager.getDouble(resultSet,"SettleSum"));
            planting31SettleListDto.setOpCode(dbManager.getString(resultSet,"OpCode"));
            planting31SettleListDto.setOpTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            planting31SettleListDto.setRemark(dbManager.getString(resultSet,"Remark"));
            planting31SettleListDto.setValidity(dbManager.getString(resultSet,"Validity"));
            planting31SettleListDto.setSettleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"SettleDate"));
            planting31SettleListDto.setClaimRate(dbManager.getDouble(resultSet,"ClaimRate"));
            planting31SettleListDto.setNodeType(dbManager.getString(resultSet,"NodeType"));
            planting31SettleListDto.setIndexOfSettle(dbManager.getInt(resultSet,"IndexOfSettle"));
            planting31SettleListDto.setPhone(dbManager.getString(resultSet,"Phone"));
            planting31SettleListDto.setBank(dbManager.getString(resultSet,"Bank"));
            planting31SettleListDto.setFieldSource(dbManager.getString(resultSet,"FieldSource"));
            planting31SettleListDto.setFcodeModify(dbManager.getString(resultSet,"FcodeModify"));
            collection.add(planting31SettleListDto);
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
        buffer.append("DELETE FROM Planting31SettleList WHERE ");
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
        buffer.append("SELECT count(*) FROM Planting31SettleList WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM Planting31SettleList WHERE ");
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
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxIndex(String conditions)
        throws Exception{
    	int max = 0;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT max(INDEXOFSETTLE) FROM Planting31SettleList WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        while(resultSet.next()){
	        max = dbManager.getInt(resultSet,1);
	        continue;
        }
        resultSet.close();
        return max;
    }
    /**
     * 将数据从临时表 PLANTING31SETTLELISTTEMP 存入正式表 PLANTING31SETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("insert into PLANTING31SETTLELIST "+
    					"(SETTLELISTCODE, INDEXOFSETTLE, FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
    					"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+ 
    					"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    					"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE)");
    	stringBuffer.append("select '"+ settleListCode +"', '"+indexOfSettle+"',FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
    			  		"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+
    			  		"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    			  		"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE "+ 
    			  		"from PLANTING31SETTLELISTTEMP where ");
    	stringBuffer.append(whereCondition);
    	if(logger.isDebugEnabled()){
            logger.debug(stringBuffer.toString());
        }
    	dbManager.prepareStatement(stringBuffer.toString());
    	dbManager.executePreparedUpdate();
    }
    /**
     * 统计户次
     * @param conditions conditions
     * @return  统计户次
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
        double count = 0.00;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(FIDCARD)) FROM PLANTING31SETTLELIST WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getDouble(resultSet,1);
        resultSet.close();
        return count;
    }
    /**
     * 转储理赔清单数据
     * @param settleListCode 理赔清单号
     * @param nodeTypeFrom 清单来源节点名称
     * @param nodeTypeTo 清单目的节点名称
     * @return  
     * @throws Exception
     */
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)throws Exception{
    	try {
			//删除当前环节已有的理赔清单
			String deleteSql = " SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeTo+"'";
			deleteByConditions(deleteSql);
			//转储理赔清单
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("insert into PLANTING31SETTLELIST "+
					"(SETTLELISTCODE, INDEXOFSETTLE, FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
					"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+ 
					"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
					"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE)");
			stringBuffer.append("select SETTLELISTCODE, INDEXOFSETTLE,FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
			  		"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+
			  		"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
			  		"CLAIMRATE, '"+nodeTypeTo+"', PHONE, BANK, FIELDSOURCE "+ 
			  		"from PLANTING31SETTLELIST where ");
			stringBuffer.append(" SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeFrom+"'");
			dbManager.executeUpdate(stringBuffer.toString());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 分险别，标的，损失率汇总理赔清单
     * @param sqlCondition 查询条件
     * @return  collection 结果列表
     * @throws Exception
     */
    public Collection getGroupedSumData( String sqlCondition, boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        if(groupByKindCode || groupByItemCode || groupByLossRate){
        	boolean moreThanOneGroup = false;
	        buffer.append("SELECT ");
	        if(groupByKindCode)
	        	buffer.append("KINDCODE, ");
	        if(groupByItemCode)
	        	buffer.append("ITEMCODE, ");
	        if(groupByLossRate)
	        	buffer.append("LOSSRATE, ");
	        if(groupByClaimRate)
	        	buffer.append("CLAIMRATE, ");
	        buffer.append("sum(SETTLESUM), ");
	        buffer.append("sum(SETTLEAREA), ");
	        buffer.append("sum(INSUREAREA), ");
	        buffer.append("sum(SUMINSURED) ");
	        buffer.append("FROM PLANTING31SETTLELIST WHERE ");
	        buffer.append(sqlCondition);
	        buffer.append(" group by ");
	        
        	if(groupByKindCode){
        		buffer.append(" KINDCODE");
        		moreThanOneGroup = true;
        	}
        	if(groupByItemCode){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" ITEMCODE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByLossRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" LOSSRATE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByClaimRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" CLAIMRATE ");
        		moreThanOneGroup = true;
        	}
	        buffer.append(" order by ");
	        
        	if(groupByKindCode){
        		buffer.append(" KINDCODE");
        		moreThanOneGroup = true;
        	}
        	if(groupByItemCode){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" ITEMCODE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByLossRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" LOSSRATE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByClaimRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" CLAIMRATE ");
        		moreThanOneGroup = true;
        	}
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        Collection collection = new ArrayList();
        Planting31SettleListDto planting31SettleListDto = null;
        while(resultSet.next()){

            planting31SettleListDto = new Planting31SettleListDto();
	        if(groupByKindCode)
	            planting31SettleListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
	        if(groupByItemCode)
	            planting31SettleListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
	        if(groupByLossRate)
	            planting31SettleListDto.setLossRate(dbManager.getDouble(resultSet,"LossRate"));
	        if(groupByClaimRate)
	            planting31SettleListDto.setClaimRate(dbManager.getDouble(resultSet,"ClaimRate"));
            planting31SettleListDto.setSettleSum(dbManager.getDouble(resultSet,"sum(SETTLESUM)"));//将赔款汇总暂时存在赔款中
            planting31SettleListDto.setSettleArea(dbManager.getDouble(resultSet,"sum(SETTLEAREA)"));//将赔款面积汇总暂时存在赔款面积中
            planting31SettleListDto.setInsureArea(dbManager.getDouble(resultSet,"sum(INSUREAREA)"));//将保险面积汇总暂时存在保险面积中
            planting31SettleListDto.setSumInsured(dbManager.getDouble(resultSet,"sum(SUMINSURED)"));//将保额汇总暂时存在保额中
            collection.add(planting31SettleListDto);
        }
        resultSet.close();
        return collection;
    }
    /**
     * 分险别，标的，损失率，农户代码，按照条件汇总理赔清单
     * @param sqlCondition 查询条件
     * @return  collection 结果列表
     * @throws Exception
     */
    public Collection getGroupedSumDataByFcode( String sqlCondition)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("FCODE, ");
        buffer.append("KINDCODE, ");
        buffer.append("ITEMCODE, ");
        buffer.append("LOSSRATE, ");
        buffer.append("sum(SETTLESUM), ");
        buffer.append("sum(SETTLEAREA), ");
        buffer.append("sum(INSUREAREA), ");
        buffer.append("sum(SUMINSURED) ");
        buffer.append("FROM PLANTING31SETTLELIST WHERE ");
        buffer.append(sqlCondition);
        buffer.append(" group by KINDCODE, ITEMCODE, LOSSRATE, FCODE");
        buffer.append(" order by KINDCODE, ITEMCODE, LOSSRATE, FCODE");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        Collection collection = new ArrayList();
        Planting31SettleListDto planting31SettleListDto = null;
        while(resultSet.next()){

            planting31SettleListDto = new Planting31SettleListDto();
            planting31SettleListDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            planting31SettleListDto.setKindCode(dbManager.getString(resultSet,"KindCode"));
            planting31SettleListDto.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            planting31SettleListDto.setLossRate(dbManager.getDouble(resultSet,"LossRate"));
            planting31SettleListDto.setSettleSum(dbManager.getDouble(resultSet,"sum(SETTLESUM)"));//将赔款汇总暂时存在赔款中
            planting31SettleListDto.setSettleArea(dbManager.getDouble(resultSet,"sum(SETTLEAREA)"));//将赔款面积汇总暂时存在赔款面积中
            planting31SettleListDto.setInsureArea(dbManager.getDouble(resultSet,"sum(INSUREAREA)"));//将保险面积汇总暂时存在保险面积中
            planting31SettleListDto.setSumInsured(dbManager.getDouble(resultSet,"sum(SUMINSURED)"));//将保额汇总暂时存在保额中
            collection.add(planting31SettleListDto);
        }
        resultSet.close();
        return collection;
    }
    
    /**
     * 汇总某一农户的总赔款额
     * @param settleListCode 理赔清单号
     * @param fIdCard 农户身份证号
     * @return  result 结果
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("sum(SETTLESUM) ");
        buffer.append("FROM PLANTING31SETTLELIST WHERE ");
        buffer.append("SettleListCode = '"+settleListCode+"' And fIdCard = '"+fIdCard+"' And nodeType = '"+nodeType+"'");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //定义返回结果集合
        double result = 0.0;
        Planting31SettleListDto planting31SettleListDto = null;
        while(resultSet.next()){
            result = dbManager.getDouble(resultSet,"sum(SETTLESUM)");
        }
        resultSet.close();
        return result;
    }
}
