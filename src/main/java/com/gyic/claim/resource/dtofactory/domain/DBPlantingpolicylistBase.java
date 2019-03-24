package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGPOLICYLIST的数据访问对象基类<br>
 */
public class DBPlantingpolicylistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPlantingpolicylistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPlantingpolicylistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void insert(PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Plantingpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(plantingpolicylistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getFcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getPhone()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getBank()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getFname()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getFareacode()).append("',");
            debugBuffer.append("").append(plantingpolicylistDto.getTaxarea()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getInsurearea()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getAmount()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getRate()).append(",");
            debugBuffer.append("'").append(plantingpolicylistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(plantingpolicylistDto.getShortrate()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getSumamount()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(plantingpolicylistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getOptime()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getValidity()).append("',");
            debugBuffer.append("'").append(plantingpolicylistDto.getRemark()).append("',");
            debugBuffer.append("").append(plantingpolicylistDto.getFpremium()).append(",");
            debugBuffer.append("'").append(plantingpolicylistDto.getTeamname()).append("',");
            debugBuffer.append("").append(plantingpolicylistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(plantingpolicylistDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(plantingpolicylistDto.getFieldsource()).append("')");
            debugBuffer.append("'").append(plantingpolicylistDto.getWarrant()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,plantingpolicylistDto.getInusrelistcode());
        dbManager.setString(2,plantingpolicylistDto.getFcode());
        dbManager.setString(3,plantingpolicylistDto.getKindcode());
        dbManager.setString(4,plantingpolicylistDto.getIndexcode());
        dbManager.setString(5,plantingpolicylistDto.getPhone());
        dbManager.setString(6,plantingpolicylistDto.getBank());
        dbManager.setString(7,plantingpolicylistDto.getZhibuka());
        dbManager.setString(8,plantingpolicylistDto.getFname());
        dbManager.setString(9,plantingpolicylistDto.getFidcard());
        dbManager.setString(10,plantingpolicylistDto.getClasscode());
        dbManager.setString(11,plantingpolicylistDto.getRiskcode());
        dbManager.setString(12,plantingpolicylistDto.getFareacode());
        dbManager.setDouble(13,plantingpolicylistDto.getTaxarea());
        dbManager.setDouble(14,plantingpolicylistDto.getInsurearea());
        dbManager.setDouble(15,plantingpolicylistDto.getAmount());
        dbManager.setDouble(16,plantingpolicylistDto.getRate());
        dbManager.setString(17,plantingpolicylistDto.getShortrateflag());
        dbManager.setDouble(18,plantingpolicylistDto.getShortrate());
        dbManager.setDouble(19,plantingpolicylistDto.getSumamount());
        dbManager.setDouble(20,plantingpolicylistDto.getSumpremium());
        dbManager.setDateTime(21,plantingpolicylistDto.getStartdate());
        dbManager.setDateTime(22,plantingpolicylistDto.getEnddate());
        dbManager.setString(23,plantingpolicylistDto.getCalculateflag());
        dbManager.setString(24,plantingpolicylistDto.getOpcode());
        dbManager.setDateTime(25,plantingpolicylistDto.getOptime());
        dbManager.setString(26,plantingpolicylistDto.getValidity());
        dbManager.setString(27,plantingpolicylistDto.getRemark());
        dbManager.setDouble(28,plantingpolicylistDto.getFpremium());
        dbManager.setString(29,plantingpolicylistDto.getTeamname());
        dbManager.setDouble(30,plantingpolicylistDto.getCentralpremium());
        dbManager.setDouble(31,plantingpolicylistDto.getProvincepremium());
        dbManager.setDouble(32,plantingpolicylistDto.getCitypremium());
        dbManager.setDouble(33,plantingpolicylistDto.getTownpremium());
        dbManager.setDouble(34,plantingpolicylistDto.getOtherpremium());
        dbManager.setString(35,plantingpolicylistDto.getFieldsource());
        dbManager.setDouble(36,plantingpolicylistDto.getWoodlandArea());
        dbManager.setString(37,plantingpolicylistDto.getWarrant());
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
        buffer.append("INSERT INTO Plantingpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PlantingpolicylistDto plantingpolicylistDto = (PlantingpolicylistDto)i.next();
            dbManager.setString(1,plantingpolicylistDto.getInusrelistcode());
            dbManager.setString(2,plantingpolicylistDto.getFcode());
            dbManager.setString(3,plantingpolicylistDto.getKindcode());
            dbManager.setString(4,plantingpolicylistDto.getIndexcode());
            dbManager.setString(5,plantingpolicylistDto.getPhone());
            dbManager.setString(6,plantingpolicylistDto.getBank());
            dbManager.setString(7,plantingpolicylistDto.getZhibuka());
            dbManager.setString(8,plantingpolicylistDto.getFname());
            dbManager.setString(9,plantingpolicylistDto.getFidcard());
            dbManager.setString(10,plantingpolicylistDto.getClasscode());
            dbManager.setString(11,plantingpolicylistDto.getRiskcode());
            dbManager.setString(12,plantingpolicylistDto.getFareacode());
            dbManager.setDouble(13,plantingpolicylistDto.getTaxarea());
            dbManager.setDouble(14,plantingpolicylistDto.getInsurearea());
            dbManager.setDouble(15,plantingpolicylistDto.getAmount());
            dbManager.setDouble(16,plantingpolicylistDto.getRate());
            dbManager.setString(17,plantingpolicylistDto.getShortrateflag());
            dbManager.setDouble(18,plantingpolicylistDto.getShortrate());
            dbManager.setDouble(19,plantingpolicylistDto.getSumamount());
            dbManager.setDouble(20,plantingpolicylistDto.getSumpremium());
            dbManager.setDateTime(21,plantingpolicylistDto.getStartdate());
            dbManager.setDateTime(22,plantingpolicylistDto.getEnddate());
            dbManager.setString(23,plantingpolicylistDto.getCalculateflag());
            dbManager.setString(24,plantingpolicylistDto.getOpcode());
            dbManager.setDateTime(25,plantingpolicylistDto.getOptime());
            dbManager.setString(26,plantingpolicylistDto.getValidity());
            dbManager.setString(27,plantingpolicylistDto.getRemark());
            dbManager.setDouble(28,plantingpolicylistDto.getFpremium());
            dbManager.setString(29,plantingpolicylistDto.getTeamname());
            dbManager.setDouble(30,plantingpolicylistDto.getCentralpremium());
            dbManager.setDouble(31,plantingpolicylistDto.getProvincepremium());
            dbManager.setDouble(32,plantingpolicylistDto.getCitypremium());
            dbManager.setDouble(33,plantingpolicylistDto.getTownpremium());
            dbManager.setDouble(34,plantingpolicylistDto.getOtherpremium());
            dbManager.setString(35,plantingpolicylistDto.getFieldsource());
            dbManager.setDouble(36,plantingpolicylistDto.getWoodlandArea());
            dbManager.setString(37,plantingpolicylistDto.getWarrant());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Plantingpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void update(PlantingpolicylistDto plantingpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Plantingpolicylist SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Insurearea = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("Shortrateflag = ?, ");
        buffer.append("Shortrate = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Sumpremium = ?, ");
        buffer.append("Startdate = ?, ");
        buffer.append("Enddate = ?, ");
        buffer.append("Calculateflag = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Fpremium = ?, ");
        buffer.append("Teamname = ?, ");
        buffer.append("Centralpremium = ?, ");
        buffer.append("Provincepremium = ?, ");
        buffer.append("Citypremium = ?, ");
        buffer.append("Townpremium = ?, ");
        buffer.append("Otherpremium = ?, ");
        buffer.append("Fieldsource = ?, ");
        buffer.append("WoodlandArea = ?,");
        buffer.append("Warrant = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Plantingpolicylist SET ");
            debugBuffer.append("Indexcode = '" + plantingpolicylistDto.getIndexcode() + "', ");
            debugBuffer.append("Phone = '" + plantingpolicylistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + plantingpolicylistDto.getBank() + "', ");
            debugBuffer.append("Zhibuka = '" + plantingpolicylistDto.getZhibuka() + "', ");
            debugBuffer.append("Fname = '" + plantingpolicylistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + plantingpolicylistDto.getFidcard() + "', ");
            debugBuffer.append("Classcode = '" + plantingpolicylistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + plantingpolicylistDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + plantingpolicylistDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + plantingpolicylistDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + plantingpolicylistDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + plantingpolicylistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + plantingpolicylistDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + plantingpolicylistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + plantingpolicylistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + plantingpolicylistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + plantingpolicylistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + plantingpolicylistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + plantingpolicylistDto.getEnddate() + "', ");
            debugBuffer.append("Calculateflag = '" + plantingpolicylistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + plantingpolicylistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + plantingpolicylistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + plantingpolicylistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + plantingpolicylistDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + plantingpolicylistDto.getFpremium() + ", ");
            debugBuffer.append("Teamname = '" + plantingpolicylistDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + plantingpolicylistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + plantingpolicylistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + plantingpolicylistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + plantingpolicylistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + plantingpolicylistDto.getOtherpremium() + ", ");
            debugBuffer.append("Fieldsource = '" + plantingpolicylistDto.getFieldsource() + "', ");
            debugBuffer.append("Warrant = '" + plantingpolicylistDto.getWarrant() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(plantingpolicylistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(plantingpolicylistDto.getFcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(plantingpolicylistDto.getKindcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,plantingpolicylistDto.getIndexcode());
        dbManager.setString(2,plantingpolicylistDto.getPhone());
        dbManager.setString(3,plantingpolicylistDto.getBank());
        dbManager.setString(4,plantingpolicylistDto.getZhibuka());
        dbManager.setString(5,plantingpolicylistDto.getFname());
        dbManager.setString(6,plantingpolicylistDto.getFidcard());
        dbManager.setString(7,plantingpolicylistDto.getClasscode());
        dbManager.setString(8,plantingpolicylistDto.getRiskcode());
        dbManager.setString(9,plantingpolicylistDto.getFareacode());
        dbManager.setDouble(10,plantingpolicylistDto.getTaxarea());
        dbManager.setDouble(11,plantingpolicylistDto.getInsurearea());
        dbManager.setDouble(12,plantingpolicylistDto.getAmount());
        dbManager.setDouble(13,plantingpolicylistDto.getRate());
        dbManager.setString(14,plantingpolicylistDto.getShortrateflag());
        dbManager.setDouble(15,plantingpolicylistDto.getShortrate());
        dbManager.setDouble(16,plantingpolicylistDto.getSumamount());
        dbManager.setDouble(17,plantingpolicylistDto.getSumpremium());
        dbManager.setDateTime(18,plantingpolicylistDto.getStartdate());
        dbManager.setDateTime(19,plantingpolicylistDto.getEnddate());
        dbManager.setString(20,plantingpolicylistDto.getCalculateflag());
        dbManager.setString(21,plantingpolicylistDto.getOpcode());
        dbManager.setDateTime(22,plantingpolicylistDto.getOptime());
        dbManager.setString(23,plantingpolicylistDto.getValidity());
        dbManager.setString(24,plantingpolicylistDto.getRemark());
        dbManager.setDouble(25,plantingpolicylistDto.getFpremium());
        dbManager.setString(26,plantingpolicylistDto.getTeamname());
        dbManager.setDouble(27,plantingpolicylistDto.getCentralpremium());
        dbManager.setDouble(28,plantingpolicylistDto.getProvincepremium());
        dbManager.setDouble(29,plantingpolicylistDto.getCitypremium());
        dbManager.setDouble(30,plantingpolicylistDto.getTownpremium());
        dbManager.setDouble(31,plantingpolicylistDto.getOtherpremium());
        dbManager.setString(32,plantingpolicylistDto.getFieldsource());
        dbManager.setDouble(33,plantingpolicylistDto.getWoodlandArea());
        dbManager.setString(34,plantingpolicylistDto.getWarrant());
        //设置条件字段;
        dbManager.setString(35,plantingpolicylistDto.getInusrelistcode());
        dbManager.setString(36,plantingpolicylistDto.getFcode());
        dbManager.setString(37,plantingpolicylistDto.getKindcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return PlantingpolicylistDto
     * @throws Exception
     */
    public PlantingpolicylistDto findByPrimaryKey(String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append("FROM Plantingpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PlantingpolicylistDto plantingpolicylistDto = null;
        if(resultSet.next()){
            plantingpolicylistDto = new PlantingpolicylistDto();
            plantingpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            plantingpolicylistDto.setFcode(dbManager.getString(resultSet,2));
            plantingpolicylistDto.setKindcode(dbManager.getString(resultSet,3));
            plantingpolicylistDto.setIndexcode(dbManager.getString(resultSet,4));
            plantingpolicylistDto.setPhone(dbManager.getString(resultSet,5));
            plantingpolicylistDto.setBank(dbManager.getString(resultSet,6));
            plantingpolicylistDto.setZhibuka(dbManager.getString(resultSet,7));
            plantingpolicylistDto.setFname(dbManager.getString(resultSet,8));
            plantingpolicylistDto.setFidcard(dbManager.getString(resultSet,9));
            plantingpolicylistDto.setClasscode(dbManager.getString(resultSet,10));
            plantingpolicylistDto.setRiskcode(dbManager.getString(resultSet,11));
            plantingpolicylistDto.setFareacode(dbManager.getString(resultSet,12));
            plantingpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,13));
            plantingpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,14));
            plantingpolicylistDto.setAmount(dbManager.getDouble(resultSet,15));
            plantingpolicylistDto.setRate(dbManager.getDouble(resultSet,16));
            plantingpolicylistDto.setShortrateflag(dbManager.getString(resultSet,17));
            plantingpolicylistDto.setShortrate(dbManager.getDouble(resultSet,18));
            plantingpolicylistDto.setSumamount(dbManager.getDouble(resultSet,19));
            plantingpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,20));
            plantingpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            plantingpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            plantingpolicylistDto.setCalculateflag(dbManager.getString(resultSet,23));
            plantingpolicylistDto.setOpcode(dbManager.getString(resultSet,24));
            plantingpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,25));
            plantingpolicylistDto.setValidity(dbManager.getString(resultSet,26));
            plantingpolicylistDto.setRemark(dbManager.getString(resultSet,27));
            plantingpolicylistDto.setFpremium(dbManager.getDouble(resultSet,28));
            plantingpolicylistDto.setTeamname(dbManager.getString(resultSet,29));
            plantingpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,30));
            plantingpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,31));
            plantingpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,32));
            plantingpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,33));
            plantingpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,34));
            plantingpolicylistDto.setFieldsource(dbManager.getString(resultSet,35));
            plantingpolicylistDto.setWoodlandArea(dbManager.getDouble(resultSet,36));
            plantingpolicylistDto.setWarrant(dbManager.getString(resultSet,37));
        }else{
        	plantingpolicylistDto = findByPrimaryKeyInStoreTable(inusrelistcode, fcode, kindcode);
        }
        resultSet.close();
        return plantingpolicylistDto;
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
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append("FROM Plantingpolicylist WHERE ");
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
        PlantingpolicylistDto plantingpolicylistDto = null;
        boolean isNullResult = true;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            plantingpolicylistDto = new PlantingpolicylistDto();
            plantingpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            plantingpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            plantingpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            plantingpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            plantingpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            plantingpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
            plantingpolicylistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            plantingpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
            plantingpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            plantingpolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            plantingpolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            plantingpolicylistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            plantingpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            plantingpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            plantingpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            plantingpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            plantingpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            plantingpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            plantingpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            plantingpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            plantingpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            plantingpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            plantingpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            plantingpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            plantingpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,"Optime"));
            plantingpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            plantingpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            plantingpolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            plantingpolicylistDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            plantingpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            plantingpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            plantingpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            plantingpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            plantingpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            plantingpolicylistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            plantingpolicylistDto.setWoodlandArea(dbManager.getDouble(resultSet,"WoodlandArea"));
            plantingpolicylistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            collection.add(plantingpolicylistDto);
            isNullResult = false;
        }
        if(isNullResult){
        	collection = findByConditionsInStoreTable(conditions, pageNo, rowsPerPage);
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
        buffer.append("DELETE FROM Plantingpolicylist WHERE ");
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
        buffer.append("SELECT count(*) FROM Plantingpolicylist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        if(count <= 0)
        	count = getCountInStoreTable(conditions);
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
	        buffer.append("SELECT sum("+fieldName+") FROM Plantingpolicylist WHERE ");
	        buffer.append(conditions);
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        sum = dbManager.getDouble(resultSet,1);
	        resultSet.close();
    	}
        if(sum == 0)
        	sum = getSumInStoreTable(conditions, fieldName);
        return sum;
    }
    
    /**
     * 根据数据转储规则，在转储表中按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return PlantingpolicylistDto
     * @throws Exception
     */
    public PlantingpolicylistDto findByPrimaryKeyInStoreTable(String inusrelistcode,String fcode,String kindcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append("FROM Plantingpolicylist_old ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PlantingpolicylistDto plantingpolicylistDto = null;
        if(resultSet.next()){
            plantingpolicylistDto = new PlantingpolicylistDto();
            plantingpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            plantingpolicylistDto.setFcode(dbManager.getString(resultSet,2));
            plantingpolicylistDto.setKindcode(dbManager.getString(resultSet,3));
            plantingpolicylistDto.setIndexcode(dbManager.getString(resultSet,4));
            plantingpolicylistDto.setPhone(dbManager.getString(resultSet,5));
            plantingpolicylistDto.setBank(dbManager.getString(resultSet,6));
            plantingpolicylistDto.setZhibuka(dbManager.getString(resultSet,7));
            plantingpolicylistDto.setFname(dbManager.getString(resultSet,8));
            plantingpolicylistDto.setFidcard(dbManager.getString(resultSet,9));
            plantingpolicylistDto.setClasscode(dbManager.getString(resultSet,10));
            plantingpolicylistDto.setRiskcode(dbManager.getString(resultSet,11));
            plantingpolicylistDto.setFareacode(dbManager.getString(resultSet,12));
            plantingpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,13));
            plantingpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,14));
            plantingpolicylistDto.setAmount(dbManager.getDouble(resultSet,15));
            plantingpolicylistDto.setRate(dbManager.getDouble(resultSet,16));
            plantingpolicylistDto.setShortrateflag(dbManager.getString(resultSet,17));
            plantingpolicylistDto.setShortrate(dbManager.getDouble(resultSet,18));
            plantingpolicylistDto.setSumamount(dbManager.getDouble(resultSet,19));
            plantingpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,20));
            plantingpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            plantingpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            plantingpolicylistDto.setCalculateflag(dbManager.getString(resultSet,23));
            plantingpolicylistDto.setOpcode(dbManager.getString(resultSet,24));
            plantingpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,25));
            plantingpolicylistDto.setValidity(dbManager.getString(resultSet,26));
            plantingpolicylistDto.setRemark(dbManager.getString(resultSet,27));
            plantingpolicylistDto.setFpremium(dbManager.getDouble(resultSet,28));
            plantingpolicylistDto.setTeamname(dbManager.getString(resultSet,29));
            plantingpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,30));
            plantingpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,31));
            plantingpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,32));
            plantingpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,33));
            plantingpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,34));
            plantingpolicylistDto.setFieldsource(dbManager.getString(resultSet,35));
            plantingpolicylistDto.setWoodlandArea(dbManager.getDouble(resultSet,36));
            plantingpolicylistDto.setWarrant(dbManager.getString(resultSet,37));
        }
        resultSet.close();
        return plantingpolicylistDto;
    }

    /**
     * 根据数据转储规则，在转储表中按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsInStoreTable(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Fieldsource, ");
        buffer.append("WoodlandArea,");
        buffer.append("Warrant ");
        buffer.append("FROM Plantingpolicylist_old WHERE ");
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
        PlantingpolicylistDto plantingpolicylistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            plantingpolicylistDto = new PlantingpolicylistDto();
            plantingpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            plantingpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            plantingpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            plantingpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            plantingpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            plantingpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
            plantingpolicylistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            plantingpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
            plantingpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            plantingpolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            plantingpolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            plantingpolicylistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            plantingpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            plantingpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            plantingpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            plantingpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            plantingpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            plantingpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            plantingpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            plantingpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            plantingpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            plantingpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            plantingpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            plantingpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            plantingpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MILLISECOND,"Optime"));
            plantingpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            plantingpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            plantingpolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            plantingpolicylistDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            plantingpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            plantingpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            plantingpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            plantingpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            plantingpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            plantingpolicylistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            plantingpolicylistDto.setWoodlandArea(dbManager.getDouble(resultSet,"WoodlandArea"));
            plantingpolicylistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            collection.add(plantingpolicylistDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 根据数据转储规则，在转储表中按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsInStoreTable(String conditions)
            throws Exception{
        return findByConditionsInStoreTable(conditions,0,0);
    }

    /**
     * 根据数据转储规则，在转储表中查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountInStoreTable(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Plantingpolicylist_old WHERE ");
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
     * 根据数据转储规则，在转储表中查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSumInStoreTable(String conditions, String fieldName)
        throws Exception{
    	double sum = 0;
    	if(null!=fieldName && !"".equals(fieldName)){
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT sum("+fieldName+") FROM Plantingpolicylist_old WHERE ");
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
