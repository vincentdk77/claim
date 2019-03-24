package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import java.text.DecimalFormat;
/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELISTTEMP的数据访问对象基类<br>
 */
public class DBPlantingsettlelisttempBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlantingsettlelisttempBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlantingsettlelisttempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void insert(PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Plantingsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Stringtimestamp,");
        buffer.append("Taxarea,");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append(") ");
       
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getRegistcode()).append("',");
            debugBuffer.append("").append(plantingsettlelisttempDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getFcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getKindcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getClasscode()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getRiskcode()).append("',");
            debugBuffer.append("").append(plantingsettlelisttempDto.getInsurearea()).append(",");
            debugBuffer.append("").append(plantingsettlelisttempDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getFname()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getFidcard()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getFareacode()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(plantingsettlelisttempDto.getGrowingseason()).append(",");
            debugBuffer.append("").append(plantingsettlelisttempDto.getLossrate()).append(",");
            debugBuffer.append("").append(plantingsettlelisttempDto.getSettlearea()).append(",");
            debugBuffer.append("").append(plantingsettlelisttempDto.getSettlesum()).append(",");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getOpcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getOptime()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getRemark()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getValidity()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getSettledate()).append("',");
            debugBuffer.append("").append(plantingsettlelisttempDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getNodetype()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getPhone()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getBank()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getStringtimestamp()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getTaxarea()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getWarrant()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getAtarea()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getWoodlandArea()).append("',");
            debugBuffer.append("'").append(plantingsettlelisttempDto.getLitterArea()).append("')");
            logger.debug(debugBuffer.toString());
        System.out.println(debugBuffer.toString());

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,plantingsettlelisttempDto.getRegistcode());
        dbManager.setInt(2,plantingsettlelisttempDto.getIndexofsettle());
        dbManager.setString(3,plantingsettlelisttempDto.getFcode());
        dbManager.setString(4,plantingsettlelisttempDto.getKindcode());
        dbManager.setString(5,plantingsettlelisttempDto.getClasscode());
        dbManager.setString(6,plantingsettlelisttempDto.getRiskcode());
        dbManager.setDouble(7,plantingsettlelisttempDto.getInsurearea());
        //DecimalFormat df = new DecimalFormat("##0.00");
		// String strSumAmount = df.format(plantingsettlelisttempDto.getSuminsured());
        //System.err.println("^^^^^^^^^^^^^^"+plantingsettlelisttempDto.getSuminsured());
        dbManager.setString(8,plantingsettlelisttempDto.getSuminsured());
        dbManager.setString(9,plantingsettlelisttempDto.getZhibuka());
        dbManager.setString(10,plantingsettlelisttempDto.getFname());
        dbManager.setString(11,plantingsettlelisttempDto.getFidcard());
        dbManager.setString(12,plantingsettlelisttempDto.getFareacode());
        dbManager.setString(13,plantingsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(14,plantingsettlelisttempDto.getGrowingseason());
        dbManager.setDouble(15,plantingsettlelisttempDto.getLossrate());
        dbManager.setDouble(16,plantingsettlelisttempDto.getSettlearea());
        dbManager.setString(17,plantingsettlelisttempDto.getSettlesum());
        dbManager.setString(18,plantingsettlelisttempDto.getOpcode());
        dbManager.setDateTime(19,plantingsettlelisttempDto.getOptime());
        dbManager.setString(20,plantingsettlelisttempDto.getRemark());
        dbManager.setString(21,plantingsettlelisttempDto.getValidity());
        dbManager.setDateTime(22,plantingsettlelisttempDto.getSettledate());
        dbManager.setDouble(23,plantingsettlelisttempDto.getClaimrate());
        dbManager.setString(24,plantingsettlelisttempDto.getNodetype());
        dbManager.setString(25,plantingsettlelisttempDto.getPhone());
        dbManager.setString(26,plantingsettlelisttempDto.getBank());
        dbManager.setString(27,plantingsettlelisttempDto.getFieldsource());
        dbManager.setString(28,plantingsettlelisttempDto.getStringtimestamp());
        dbManager.setDouble(29,plantingsettlelisttempDto.getTaxarea());
        dbManager.setString(30,plantingsettlelisttempDto.getWarrant());
        dbManager.setString(31,plantingsettlelisttempDto.getAtarea());
        dbManager.setDouble(32,plantingsettlelisttempDto.getWoodlandArea());
        dbManager.setString(33,plantingsettlelisttempDto.getLitterArea());
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
        buffer.append("INSERT INTO Plantingsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Stringtimestamp,");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PlantingsettlelisttempDto plantingsettlelisttempDto = (PlantingsettlelisttempDto)i.next();
            dbManager.setString(1,plantingsettlelisttempDto.getRegistcode());
            dbManager.setInt(2,plantingsettlelisttempDto.getIndexofsettle());
            dbManager.setString(3,plantingsettlelisttempDto.getFcode());
            dbManager.setString(4,plantingsettlelisttempDto.getKindcode());
            dbManager.setString(5,plantingsettlelisttempDto.getClasscode());
            dbManager.setString(6,plantingsettlelisttempDto.getRiskcode());
            dbManager.setDouble(7,plantingsettlelisttempDto.getInsurearea());
            dbManager.setString(8,plantingsettlelisttempDto.getSuminsured());
            dbManager.setString(9,plantingsettlelisttempDto.getZhibuka());
            dbManager.setString(10,plantingsettlelisttempDto.getFname());
            dbManager.setString(11,plantingsettlelisttempDto.getFidcard());
            dbManager.setString(12,plantingsettlelisttempDto.getFareacode());
            dbManager.setString(13,plantingsettlelisttempDto.getInusrelistcode());
            dbManager.setDouble(14,plantingsettlelisttempDto.getGrowingseason());
            dbManager.setDouble(15,plantingsettlelisttempDto.getLossrate());
            dbManager.setDouble(16,plantingsettlelisttempDto.getSettlearea());
            dbManager.setString(17,plantingsettlelisttempDto.getSettlesum());
            dbManager.setString(18,plantingsettlelisttempDto.getOpcode());
            dbManager.setDateTime(19,plantingsettlelisttempDto.getOptime());
            dbManager.setString(20,plantingsettlelisttempDto.getRemark());
            dbManager.setString(21,plantingsettlelisttempDto.getValidity());
            dbManager.setDateTime(22,plantingsettlelisttempDto.getSettledate());
            dbManager.setDouble(23,plantingsettlelisttempDto.getClaimrate());
            dbManager.setString(24,plantingsettlelisttempDto.getNodetype());
            dbManager.setString(25,plantingsettlelisttempDto.getPhone());
            dbManager.setString(26,plantingsettlelisttempDto.getBank());
            dbManager.setString(27,plantingsettlelisttempDto.getFieldsource());
            dbManager.setString(28,plantingsettlelisttempDto.getStringtimestamp());
            dbManager.setDouble(29,plantingsettlelisttempDto.getTaxarea());
            dbManager.setString(30,plantingsettlelisttempDto.getWarrant());
            dbManager.setString(31,plantingsettlelisttempDto.getAtarea());
            dbManager.setDouble(32,plantingsettlelisttempDto.getWoodlandArea());
            dbManager.setString(33,plantingsettlelisttempDto.getLitterArea());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Plantingsettlelisttemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(registcode).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append(" AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(stringtimestamp).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Stringtimestamp = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registcode);
        dbManager.setInt(2,indexofsettle);
        dbManager.setString(3,stringtimestamp);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void update(PlantingsettlelisttempDto plantingsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Plantingsettlelisttemp SET ");
        buffer.append("Fcode = ?, ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Insurearea = ?, ");
        buffer.append("Suminsured = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Growingseason = ?, ");
        buffer.append("Lossrate = ?, ");
        buffer.append("Settlearea = ?, ");
        buffer.append("Settlesum = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Settledate = ?, ");
        buffer.append("Claimrate = ?, ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Fieldsource = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Warrant = ?,");
        buffer.append("AtArea = ?,");
        buffer.append("WoodlandArea = ?,");
        buffer.append("LittleAreaName = ? "); 
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Plantingsettlelisttemp SET ");
            debugBuffer.append("Fcode = '" + plantingsettlelisttempDto.getFcode() + "', ");
            debugBuffer.append("Kindcode = '" + plantingsettlelisttempDto.getKindcode() + "', ");
            debugBuffer.append("Classcode = '" + plantingsettlelisttempDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + plantingsettlelisttempDto.getRiskcode() + "', ");
            debugBuffer.append("Insurearea = " + plantingsettlelisttempDto.getInsurearea() + ", ");
            debugBuffer.append("Suminsured = " + plantingsettlelisttempDto.getSuminsured() + ", ");
            debugBuffer.append("Zhibuka = '" + plantingsettlelisttempDto.getZhibuka() + "', ");
            debugBuffer.append("Fname = '" + plantingsettlelisttempDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + plantingsettlelisttempDto.getFidcard() + "', ");
            debugBuffer.append("Fareacode = '" + plantingsettlelisttempDto.getFareacode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + plantingsettlelisttempDto.getInusrelistcode() + "', ");
            debugBuffer.append("Growingseason = " + plantingsettlelisttempDto.getGrowingseason() + ", ");
            debugBuffer.append("Lossrate = " + plantingsettlelisttempDto.getLossrate() + ", ");
            debugBuffer.append("Settlearea = " + plantingsettlelisttempDto.getSettlearea() + ", ");
            debugBuffer.append("Settlesum = " + plantingsettlelisttempDto.getSettlesum() + ", ");
            debugBuffer.append("Opcode = '" + plantingsettlelisttempDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + plantingsettlelisttempDto.getOptime() + "', ");
            debugBuffer.append("Remark = '" + plantingsettlelisttempDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + plantingsettlelisttempDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + plantingsettlelisttempDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + plantingsettlelisttempDto.getClaimrate() + ", ");
            debugBuffer.append("Nodetype = '" + plantingsettlelisttempDto.getNodetype() + "', ");
            debugBuffer.append("Phone = '" + plantingsettlelisttempDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + plantingsettlelisttempDto.getBank() + "', ");
            debugBuffer.append("Fieldsource = '" + plantingsettlelisttempDto.getFieldsource() + "', ");
            debugBuffer.append("Taxarea = '" + plantingsettlelisttempDto.getTaxarea() + "' ");
            debugBuffer.append("Warrant = '" + plantingsettlelisttempDto.getWarrant() + "' ");
            debugBuffer.append("AtArea = '" + plantingsettlelisttempDto.getAtarea() + "' ");
            debugBuffer.append("LittleAreaName = '" + plantingsettlelisttempDto.getLitterArea() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(plantingsettlelisttempDto.getRegistcode()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(plantingsettlelisttempDto.getIndexofsettle()).append(" AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(plantingsettlelisttempDto.getStringtimestamp()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Stringtimestamp = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,plantingsettlelisttempDto.getFcode());
        dbManager.setString(2,plantingsettlelisttempDto.getKindcode());
        dbManager.setString(3,plantingsettlelisttempDto.getClasscode());
        dbManager.setString(4,plantingsettlelisttempDto.getRiskcode());
        dbManager.setDouble(5,plantingsettlelisttempDto.getInsurearea());
        dbManager.setString(6,plantingsettlelisttempDto.getSuminsured());
        dbManager.setString(7,plantingsettlelisttempDto.getZhibuka());
        dbManager.setString(8,plantingsettlelisttempDto.getFname());
        dbManager.setString(9,plantingsettlelisttempDto.getFidcard());
        dbManager.setString(10,plantingsettlelisttempDto.getFareacode());
        dbManager.setString(11,plantingsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(12,plantingsettlelisttempDto.getGrowingseason());
        dbManager.setDouble(13,plantingsettlelisttempDto.getLossrate());
        dbManager.setDouble(14,plantingsettlelisttempDto.getSettlearea());
        dbManager.setString(15,plantingsettlelisttempDto.getSettlesum());
        dbManager.setString(16,plantingsettlelisttempDto.getOpcode());
        dbManager.setDateTime(17,plantingsettlelisttempDto.getOptime());
        dbManager.setString(18,plantingsettlelisttempDto.getRemark());
        dbManager.setString(19,plantingsettlelisttempDto.getValidity());
        dbManager.setDateTime(20,plantingsettlelisttempDto.getSettledate());
        dbManager.setDouble(21,plantingsettlelisttempDto.getClaimrate());
        dbManager.setString(22,plantingsettlelisttempDto.getNodetype());
        dbManager.setString(23,plantingsettlelisttempDto.getPhone());
        dbManager.setString(24,plantingsettlelisttempDto.getBank());
        dbManager.setString(25,plantingsettlelisttempDto.getFieldsource());
        dbManager.setDouble(26,plantingsettlelisttempDto.getTaxarea());
        dbManager.setString(27,plantingsettlelisttempDto.getWarrant());
        dbManager.setString(28,plantingsettlelisttempDto.getAtarea());
        dbManager.setDouble(29,plantingsettlelisttempDto.getWoodlandArea());
        dbManager.setString(30,plantingsettlelisttempDto.getLitterArea());
        //设置条件字段;
        dbManager.setString(31,plantingsettlelisttempDto.getRegistcode());
        dbManager.setInt(32,plantingsettlelisttempDto.getIndexofsettle());
        dbManager.setString(33,plantingsettlelisttempDto.getStringtimestamp());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return PlantingsettlelisttempDto
     * @throws Exception
     */
    public PlantingsettlelisttempDto findByPrimaryKey(String registcode,int indexofsettle,String stringtimestamp)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Registcode,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Stringtimestamp, ");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append("FROM Plantingsettlelisttemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(registcode).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append(" AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(stringtimestamp).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Stringtimestamp = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registcode);
        dbManager.setInt(2,indexofsettle);
        dbManager.setString(3,stringtimestamp);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PlantingsettlelisttempDto plantingsettlelisttempDto = null;
        if(resultSet.next()){
            plantingsettlelisttempDto = new PlantingsettlelisttempDto();
            plantingsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,1));
            plantingsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,2));
            plantingsettlelisttempDto.setFcode(dbManager.getString(resultSet,3));
            plantingsettlelisttempDto.setKindcode(dbManager.getString(resultSet,4));
            plantingsettlelisttempDto.setClasscode(dbManager.getString(resultSet,5));
            plantingsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,6));
            plantingsettlelisttempDto.setInsurearea(dbManager.getDouble(resultSet,7));
            plantingsettlelisttempDto.setSuminsured(dbManager.getString(resultSet,8));
            plantingsettlelisttempDto.setZhibuka(dbManager.getString(resultSet,9));
            plantingsettlelisttempDto.setFname(dbManager.getString(resultSet,10));
            plantingsettlelisttempDto.setFidcard(dbManager.getString(resultSet,11));
            plantingsettlelisttempDto.setFareacode(dbManager.getString(resultSet,12));
            plantingsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,13));
            plantingsettlelisttempDto.setGrowingseason(dbManager.getDouble(resultSet,14));
            plantingsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,15));
            plantingsettlelisttempDto.setSettlearea(dbManager.getDouble(resultSet,16));
            plantingsettlelisttempDto.setSettlesum(dbManager.getString(resultSet,17));
            plantingsettlelisttempDto.setOpcode(dbManager.getString(resultSet,18));
            plantingsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,19));
            plantingsettlelisttempDto.setRemark(dbManager.getString(resultSet,20));
            plantingsettlelisttempDto.setValidity(dbManager.getString(resultSet,21));
            plantingsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            plantingsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,23));
            plantingsettlelisttempDto.setNodetype(dbManager.getString(resultSet,24));
            plantingsettlelisttempDto.setPhone(dbManager.getString(resultSet,25));
            plantingsettlelisttempDto.setBank(dbManager.getString(resultSet,26));
            plantingsettlelisttempDto.setFieldsource(dbManager.getString(resultSet,27));
            plantingsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,28));
            plantingsettlelisttempDto.setTaxarea(dbManager.getDouble(resultSet,29));
            plantingsettlelisttempDto.setWarrant(dbManager.getString(resultSet,30));
            plantingsettlelisttempDto.setAtarea(dbManager.getString(resultSet,31));
            plantingsettlelisttempDto.setWoodlandArea(dbManager.getDouble(resultSet,32));
            plantingsettlelisttempDto.setLitterArea(dbManager.getString(resultSet,33));
        }
        resultSet.close();
        return plantingsettlelisttempDto;
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
        buffer.append("Registcode,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Stringtimestamp, ");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName ");
        buffer.append("FROM Plantingsettlelisttemp WHERE ");
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
        PlantingsettlelisttempDto plantingsettlelisttempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            plantingsettlelisttempDto = new PlantingsettlelisttempDto();
            plantingsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,"Registcode"));
            plantingsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            plantingsettlelisttempDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            plantingsettlelisttempDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            plantingsettlelisttempDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            plantingsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            plantingsettlelisttempDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            plantingsettlelisttempDto.setSuminsured(dbManager.getString(resultSet,"Suminsured"));
            plantingsettlelisttempDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            plantingsettlelisttempDto.setFname(dbManager.getString(resultSet,"Fname"));
            plantingsettlelisttempDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            plantingsettlelisttempDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            plantingsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            plantingsettlelisttempDto.setGrowingseason(dbManager.getDouble(resultSet,"Growingseason"));
            plantingsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            plantingsettlelisttempDto.setSettlearea(dbManager.getDouble(resultSet,"Settlearea"));
            plantingsettlelisttempDto.setSettlesum(dbManager.getString(resultSet,"Settlesum"));
            plantingsettlelisttempDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            plantingsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            plantingsettlelisttempDto.setRemark(dbManager.getString(resultSet,"Remark"));
            plantingsettlelisttempDto.setValidity(dbManager.getString(resultSet,"Validity"));
            plantingsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            plantingsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            plantingsettlelisttempDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            plantingsettlelisttempDto.setPhone(dbManager.getString(resultSet,"Phone"));
            plantingsettlelisttempDto.setBank(dbManager.getString(resultSet,"Bank"));
            plantingsettlelisttempDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            plantingsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,"Stringtimestamp"));
            plantingsettlelisttempDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            plantingsettlelisttempDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            plantingsettlelisttempDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            plantingsettlelisttempDto.setWoodlandArea(dbManager.getDouble(resultSet,"WoodlandArea"));
            plantingsettlelisttempDto.setLitterArea(dbManager.getString(resultSet,"LittleAreaName"));
            collection.add(plantingsettlelisttempDto);
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
        buffer.append("DELETE FROM Plantingsettlelisttemp WHERE ");
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
        buffer.append("SELECT count(*) FROM Plantingsettlelisttemp WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM Plantingsettlelisttemp WHERE ");
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
