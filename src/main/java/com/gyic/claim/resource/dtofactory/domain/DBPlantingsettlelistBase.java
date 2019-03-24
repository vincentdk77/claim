package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的数据访问对象基类<br>
 */
public class DBPlantingsettlelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlantingsettlelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlantingsettlelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Plantingsettlelist (");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank, ");
        buffer.append("Fieldsource, ");
        buffer.append("Taxarea,");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(plantingsettlelistDto.getSettlelistcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getFcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getRiskcode()).append("',");
            debugBuffer.append("").append(plantingsettlelistDto.getInsurearea()).append(",");
            debugBuffer.append("").append(plantingsettlelistDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(plantingsettlelistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getFname()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getFareacode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(plantingsettlelistDto.getGrowingseason()).append(",");
            debugBuffer.append("").append(plantingsettlelistDto.getLossrate()).append(",");
            debugBuffer.append("").append(plantingsettlelistDto.getSettlearea()).append(",");
            debugBuffer.append("").append(plantingsettlelistDto.getSettlesum()).append(",");
            debugBuffer.append("'").append(plantingsettlelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getRemark()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getSettledate()).append("',");
            debugBuffer.append("").append(plantingsettlelistDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(plantingsettlelistDto.getNodetype()).append("',");
            debugBuffer.append("").append(plantingsettlelistDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(plantingsettlelistDto.getPhone()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getBank()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getTaxarea()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getWarrant()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getAtarea()).append("',");
            debugBuffer.append("'").append(plantingsettlelistDto.getLitterArea()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,plantingsettlelistDto.getSettlelistcode());
        dbManager.setString(2,plantingsettlelistDto.getFcode());
        dbManager.setString(3,plantingsettlelistDto.getKindcode());
        dbManager.setString(4,plantingsettlelistDto.getClasscode());
        dbManager.setString(5,plantingsettlelistDto.getRiskcode());
        dbManager.setDouble(6,plantingsettlelistDto.getInsurearea());
        dbManager.setString(7,plantingsettlelistDto.getSuminsured());
        dbManager.setString(8,plantingsettlelistDto.getZhibuka());
        dbManager.setString(9,plantingsettlelistDto.getFname());
        dbManager.setString(10,plantingsettlelistDto.getFidcard());
        dbManager.setString(11,plantingsettlelistDto.getFareacode());
        dbManager.setString(12,plantingsettlelistDto.getInusrelistcode());
        dbManager.setDouble(13,plantingsettlelistDto.getGrowingseason());
        dbManager.setDouble(14,plantingsettlelistDto.getLossrate());
        dbManager.setDouble(15,plantingsettlelistDto.getSettlearea());
        dbManager.setString(16,plantingsettlelistDto.getSettlesum());
        dbManager.setString(17,plantingsettlelistDto.getOpcode());
        dbManager.setDateTime(18,plantingsettlelistDto.getOptime());
        dbManager.setString(19,plantingsettlelistDto.getRemark());
        dbManager.setString(20,plantingsettlelistDto.getValidity());
        dbManager.setDateTime(21,plantingsettlelistDto.getSettledate());
        dbManager.setDouble(22,plantingsettlelistDto.getClaimrate());
        dbManager.setString(23,plantingsettlelistDto.getNodetype());
        dbManager.setInt(24,plantingsettlelistDto.getIndexofsettle());
        dbManager.setString(25,plantingsettlelistDto.getPhone());
        dbManager.setString(26,plantingsettlelistDto.getBank());
        dbManager.setString(27,plantingsettlelistDto.getFieldsource());
        dbManager.setDouble(28,plantingsettlelistDto.getTaxarea());
        dbManager.setString(29,plantingsettlelistDto.getWarrant());
        dbManager.setString(30,plantingsettlelistDto.getAtarea());
        dbManager.setDouble(31,plantingsettlelistDto.getWoodlandArea());
        dbManager.setString(32,plantingsettlelistDto.getLitterArea());
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
        buffer.append("INSERT INTO Plantingsettlelist (");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank, ");
        buffer.append("Fieldsource, ");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PlantingsettlelistDto plantingsettlelistDto = (PlantingsettlelistDto)i.next();
            dbManager.setString(1,plantingsettlelistDto.getSettlelistcode());
            dbManager.setString(2,plantingsettlelistDto.getFcode());
            dbManager.setString(3,plantingsettlelistDto.getKindcode());
            dbManager.setString(4,plantingsettlelistDto.getClasscode());
            dbManager.setString(5,plantingsettlelistDto.getRiskcode());
            dbManager.setDouble(6,plantingsettlelistDto.getInsurearea());
            dbManager.setString(7,plantingsettlelistDto.getSuminsured());
            dbManager.setString(8,plantingsettlelistDto.getZhibuka());
            dbManager.setString(9,plantingsettlelistDto.getFname());
            dbManager.setString(10,plantingsettlelistDto.getFidcard());
            dbManager.setString(11,plantingsettlelistDto.getFareacode());
            dbManager.setString(12,plantingsettlelistDto.getInusrelistcode());
            dbManager.setDouble(13,plantingsettlelistDto.getGrowingseason());
            dbManager.setDouble(14,plantingsettlelistDto.getLossrate());
            dbManager.setDouble(15,plantingsettlelistDto.getSettlearea());
            dbManager.setString(16,plantingsettlelistDto.getSettlesum());
            dbManager.setString(17,plantingsettlelistDto.getOpcode());
            dbManager.setDateTime(18,plantingsettlelistDto.getOptime());
            dbManager.setString(19,plantingsettlelistDto.getRemark());
            dbManager.setString(20,plantingsettlelistDto.getValidity());
            dbManager.setDateTime(21,plantingsettlelistDto.getSettledate());
            dbManager.setDouble(22,plantingsettlelistDto.getClaimrate());
            dbManager.setString(23,plantingsettlelistDto.getNodetype());
            dbManager.setInt(24,plantingsettlelistDto.getIndexofsettle());
            dbManager.setString(25,plantingsettlelistDto.getPhone());
            dbManager.setString(26,plantingsettlelistDto.getBank());
            dbManager.setString(26,plantingsettlelistDto.getFieldsource());
            dbManager.setDouble(27,plantingsettlelistDto.getTaxarea());
            dbManager.setString(28,plantingsettlelistDto.getWarrant());
            dbManager.setString(29,plantingsettlelistDto.getAtarea());
            dbManager.setDouble(30,plantingsettlelistDto.getWoodlandArea());
            dbManager.setString(31,plantingsettlelistDto.getLitterArea());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Plantingsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,nodetype);
        dbManager.setInt(5,indexofsettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void update(PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Plantingsettlelist SET ");
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
            debugBuffer.append("UPDATE Plantingsettlelist SET ");
            debugBuffer.append("Classcode = '" + plantingsettlelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + plantingsettlelistDto.getRiskcode() + "', ");
            debugBuffer.append("Insurearea = " + plantingsettlelistDto.getInsurearea() + ", ");
            debugBuffer.append("Suminsured = " + plantingsettlelistDto.getSuminsured() + ", ");
            debugBuffer.append("Zhibuka = '" + plantingsettlelistDto.getZhibuka() + "', ");
            debugBuffer.append("Fname = '" + plantingsettlelistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + plantingsettlelistDto.getFidcard() + "', ");
            debugBuffer.append("Fareacode = '" + plantingsettlelistDto.getFareacode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + plantingsettlelistDto.getInusrelistcode() + "', ");
            debugBuffer.append("Growingseason = " + plantingsettlelistDto.getGrowingseason() + ", ");
            debugBuffer.append("Lossrate = " + plantingsettlelistDto.getLossrate() + ", ");
            debugBuffer.append("Settlearea = " + plantingsettlelistDto.getSettlearea() + ", ");
            debugBuffer.append("Settlesum = " + plantingsettlelistDto.getSettlesum() + ", ");
            debugBuffer.append("Opcode = '" + plantingsettlelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + plantingsettlelistDto.getOptime() + "', ");
            debugBuffer.append("Remark = '" + plantingsettlelistDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + plantingsettlelistDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + plantingsettlelistDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + plantingsettlelistDto.getClaimrate() + ", ");
            debugBuffer.append("Phone = '" + plantingsettlelistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + plantingsettlelistDto.getBank() + "', ");
            debugBuffer.append("Fieldsource = '" + plantingsettlelistDto.getFieldsource() + "' ");
            debugBuffer.append("Taxarea = '" + plantingsettlelistDto.getTaxarea() + "' ");
            debugBuffer.append("Warrant = '" + plantingsettlelistDto.getWarrant() + "' ");
            debugBuffer.append("AtArea = '" + plantingsettlelistDto.getAtarea() + "' ");
            debugBuffer.append("LittleAreaName = '" + plantingsettlelistDto.getLitterArea() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(plantingsettlelistDto.getSettlelistcode()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(plantingsettlelistDto.getFcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(plantingsettlelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(plantingsettlelistDto.getNodetype()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(plantingsettlelistDto.getIndexofsettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,plantingsettlelistDto.getClasscode());
        dbManager.setString(2,plantingsettlelistDto.getRiskcode());
        dbManager.setDouble(3,plantingsettlelistDto.getInsurearea());
        dbManager.setString(4,plantingsettlelistDto.getSuminsured());
        dbManager.setString(5,plantingsettlelistDto.getZhibuka());
        dbManager.setString(6,plantingsettlelistDto.getFname());
        dbManager.setString(7,plantingsettlelistDto.getFidcard());
        dbManager.setString(8,plantingsettlelistDto.getFareacode());
        dbManager.setString(9,plantingsettlelistDto.getInusrelistcode());
        dbManager.setDouble(10,plantingsettlelistDto.getGrowingseason());
        dbManager.setDouble(11,plantingsettlelistDto.getLossrate());
        dbManager.setDouble(12,plantingsettlelistDto.getSettlearea());
        dbManager.setString(13,plantingsettlelistDto.getSettlesum());
        dbManager.setString(14,plantingsettlelistDto.getOpcode());
        dbManager.setDateTime(15,plantingsettlelistDto.getOptime());
        dbManager.setString(16,plantingsettlelistDto.getRemark());
        dbManager.setString(17,plantingsettlelistDto.getValidity());
        dbManager.setDateTime(18,plantingsettlelistDto.getSettledate());
        dbManager.setDouble(19,plantingsettlelistDto.getClaimrate());
        dbManager.setString(20,plantingsettlelistDto.getPhone());
        dbManager.setString(21,plantingsettlelistDto.getBank());
        dbManager.setString(22,plantingsettlelistDto.getFieldsource());
        dbManager.setDouble(23,plantingsettlelistDto.getTaxarea());
        dbManager.setString(24,plantingsettlelistDto.getWarrant());
        dbManager.setString(25,plantingsettlelistDto.getAtarea());
		dbManager.setDouble(26,plantingsettlelistDto.getWoodlandArea());
        dbManager.setString(27,plantingsettlelistDto.getLitterArea());
        //设置条件字段;
        dbManager.setString(28,plantingsettlelistDto.getSettlelistcode());
        dbManager.setString(29,plantingsettlelistDto.getFcode());
        dbManager.setString(30,plantingsettlelistDto.getKindcode());
        dbManager.setString(31,plantingsettlelistDto.getNodetype());
        dbManager.setInt(32,plantingsettlelistDto.getIndexofsettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return PlantingsettlelistDto
     * @throws Exception
     */
    public PlantingsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank, ");
        buffer.append("Fieldsource, ");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append("FROM Plantingsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,nodetype);
        dbManager.setInt(5,indexofsettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PlantingsettlelistDto plantingsettlelistDto = null;
        if(resultSet.next()){
            plantingsettlelistDto = new PlantingsettlelistDto();
            plantingsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,1));
            plantingsettlelistDto.setFcode(dbManager.getString(resultSet,2));
            plantingsettlelistDto.setKindcode(dbManager.getString(resultSet,3));
            plantingsettlelistDto.setClasscode(dbManager.getString(resultSet,4));
            plantingsettlelistDto.setRiskcode(dbManager.getString(resultSet,5));
            plantingsettlelistDto.setInsurearea(dbManager.getDouble(resultSet,6));
            plantingsettlelistDto.setSuminsured(dbManager.getString(resultSet,7));
            plantingsettlelistDto.setZhibuka(dbManager.getString(resultSet,8));
            plantingsettlelistDto.setFname(dbManager.getString(resultSet,9));
            plantingsettlelistDto.setFidcard(dbManager.getString(resultSet,10));
            plantingsettlelistDto.setFareacode(dbManager.getString(resultSet,11));
            plantingsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,12));
            plantingsettlelistDto.setGrowingseason(dbManager.getDouble(resultSet,13));
            plantingsettlelistDto.setLossrate(dbManager.getDouble(resultSet,14));
            plantingsettlelistDto.setSettlearea(dbManager.getDouble(resultSet,15));
            plantingsettlelistDto.setSettlesum(dbManager.getString(resultSet,16));
            plantingsettlelistDto.setOpcode(dbManager.getString(resultSet,17));
            plantingsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,18));
            plantingsettlelistDto.setRemark(dbManager.getString(resultSet,19));
            plantingsettlelistDto.setValidity(dbManager.getString(resultSet,20));
            plantingsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            plantingsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,22));
            plantingsettlelistDto.setNodetype(dbManager.getString(resultSet,23));
            plantingsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,24));
            plantingsettlelistDto.setPhone(dbManager.getString(resultSet,25));
            plantingsettlelistDto.setBank(dbManager.getString(resultSet,26));
            plantingsettlelistDto.setFieldsource(dbManager.getString(resultSet,27));
            plantingsettlelistDto.setTaxarea(dbManager.getDouble(resultSet,28));
            plantingsettlelistDto.setWarrant(dbManager.getString(resultSet,29));
            plantingsettlelistDto.setAtarea(dbManager.getString(resultSet,30));
            plantingsettlelistDto.setWoodlandArea(dbManager.getDouble(resultSet,31));
            plantingsettlelistDto.setLitterArea(dbManager.getString(resultSet,32));
        }
        resultSet.close();
        return plantingsettlelistDto;
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
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank, ");
        buffer.append("Fieldsource, ");
        buffer.append("Taxarea, ");
        buffer.append("Warrant,");
        buffer.append("AtArea,");
        buffer.append("WoodlandArea,");
        buffer.append("LittleAreaName "); 
        buffer.append("FROM Plantingsettlelist WHERE ");
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
        PlantingsettlelistDto plantingsettlelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            plantingsettlelistDto = new PlantingsettlelistDto();
            plantingsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            plantingsettlelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            plantingsettlelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            plantingsettlelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            plantingsettlelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            plantingsettlelistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            plantingsettlelistDto.setSuminsured(dbManager.getString(resultSet,"Suminsured"));
            plantingsettlelistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            plantingsettlelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            plantingsettlelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            plantingsettlelistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            plantingsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            plantingsettlelistDto.setGrowingseason(dbManager.getDouble(resultSet,"Growingseason"));
            plantingsettlelistDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            plantingsettlelistDto.setSettlearea(dbManager.getDouble(resultSet,"Settlearea"));
            plantingsettlelistDto.setSettlesum(dbManager.getString(resultSet,"Settlesum"));
            plantingsettlelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            plantingsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            plantingsettlelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            plantingsettlelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            plantingsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            plantingsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            plantingsettlelistDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            plantingsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            plantingsettlelistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            plantingsettlelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            plantingsettlelistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            plantingsettlelistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            plantingsettlelistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            plantingsettlelistDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            plantingsettlelistDto.setWoodlandArea(dbManager.getDouble(resultSet,"WoodlandArea"));
            plantingsettlelistDto.setLitterArea(dbManager.getString(resultSet,"LittleAreaName"));
            collection.add(plantingsettlelistDto);
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
        buffer.append("DELETE FROM Plantingsettlelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Plantingsettlelist WHERE ");
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
     * 查询不同损失率的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getDistinctLossRateCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(Lossrate)) FROM Plantingsettlelist WHERE ");
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
     * 统计户次
     * @param conditions conditions
     * @return  统计户次
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
        double count = 0.00;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(FCODE)) FROM Plantingsettlelist WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM Plantingsettlelist WHERE ");
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
        buffer.append("SELECT max(INDEXOFSETTLE) FROM Plantingsettlelist WHERE ");
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
     * 将数据从临时表 PLANTINGSETTLELISTTEMP 存入正式表 PLANTINGSETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("insert into PLANTINGSETTLELIST "+
    					"(SETTLELISTCODE, INDEXOFSETTLE, FCODE, KINDCODE, CLASSCODE, RISKCODE, INSUREAREA, "+ 
    					"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+ 
    					"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    					"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE, TAXAREA , WARRANT,WoodlandArea , ATAREA ,LITTLEAREANAME )");
    	stringBuffer.append("select '"+ settleListCode +"', '"+indexOfSettle+"',FCODE, KINDCODE, CLASSCODE, RISKCODE, INSUREAREA, "+ 
    			  		"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+
    			  		"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    			  		"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE, TAXAREA ,WARRANT,WoodlandArea ,ATAREA ,LITTLEAREANAME "+ 
    			  		"from PLANTINGSETTLELISTTEMP where ");
    	stringBuffer.append(whereCondition);
    	if(logger.isDebugEnabled()){
            logger.debug(stringBuffer.toString());
        }
    	dbManager.prepareStatement(stringBuffer.toString());
    	dbManager.executePreparedUpdate();
    }
}
