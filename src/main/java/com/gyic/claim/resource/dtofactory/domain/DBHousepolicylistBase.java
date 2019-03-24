package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.nyx.blsvr.BLAreas;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;
import com.gyic.claim.dto.custom.IdcardRegistDto;
import com.gyic.claim.dto.domain.HousepolicylistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HOUSEPOLICYLIST的数据访问对象基类<br>
 */
public class DBHousepolicylistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBHousepolicylistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBHousepolicylistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void insert(HousepolicylistDto housepolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Housepolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Address,");
        buffer.append("Areacode,");
        buffer.append("Rate,");
        buffer.append("Riskcode,");
        buffer.append("Classcode,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Calculateflag,");
        buffer.append("Validity,");
        buffer.append("Hukoubu,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber,");
        buffer.append("Phone,");
        buffer.append("Remark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(housepolicylistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getName()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getIdcard()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getAddress()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getAreacode()).append("',");
            debugBuffer.append("").append(housepolicylistDto.getRate()).append(",");
            debugBuffer.append("'").append(housepolicylistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(housepolicylistDto.getShortrate()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getSumamount()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getSumpremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getFpremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(housepolicylistDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(housepolicylistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getOptime()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getValidity()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getHukoubu()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getFloor()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getBuildingnumber()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getZhuannumber()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getWanumber()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getKitchennumber()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getOthernumber()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getPhone()).append("',");
            debugBuffer.append("'").append(housepolicylistDto.getRemark()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,housepolicylistDto.getInusrelistcode());
        dbManager.setString(2,housepolicylistDto.getKindcode());
        dbManager.setString(3,housepolicylistDto.getIndexcode());
        dbManager.setString(4,housepolicylistDto.getName());
        dbManager.setString(5,housepolicylistDto.getIdcard());
        dbManager.setString(6,housepolicylistDto.getAddress());
        dbManager.setString(7,housepolicylistDto.getAreacode());
        dbManager.setDouble(8,housepolicylistDto.getRate());
        dbManager.setString(9,housepolicylistDto.getRiskcode());
        dbManager.setString(10,housepolicylistDto.getClasscode());
        dbManager.setString(11,housepolicylistDto.getShortrateflag());
        dbManager.setDouble(12,housepolicylistDto.getShortrate());
        dbManager.setDouble(13,housepolicylistDto.getSumamount());
        dbManager.setDouble(14,housepolicylistDto.getSumpremium());
        dbManager.setDouble(15,housepolicylistDto.getFpremium());
        dbManager.setDouble(16,housepolicylistDto.getCentralpremium());
        dbManager.setDouble(17,housepolicylistDto.getProvincepremium());
        dbManager.setDouble(18,housepolicylistDto.getCitypremium());
        dbManager.setDouble(19,housepolicylistDto.getTownpremium());
        dbManager.setDouble(20,housepolicylistDto.getOtherpremium());
        dbManager.setDateTime(21,housepolicylistDto.getStartdate());
        dbManager.setDateTime(22,housepolicylistDto.getEnddate());
        dbManager.setString(23,housepolicylistDto.getOpcode());
        dbManager.setDateTime(24,housepolicylistDto.getOptime());
        dbManager.setString(25,housepolicylistDto.getCalculateflag());
        dbManager.setString(26,housepolicylistDto.getValidity());
        dbManager.setString(27,housepolicylistDto.getHukoubu());
        dbManager.setString(28,housepolicylistDto.getFloor());
        dbManager.setString(29,housepolicylistDto.getBuildingnumber());
        dbManager.setString(30,housepolicylistDto.getZhuannumber());
        dbManager.setString(31,housepolicylistDto.getWanumber());
        dbManager.setString(32,housepolicylistDto.getKitchennumber());
        dbManager.setString(33,housepolicylistDto.getOthernumber());
        dbManager.setString(34,housepolicylistDto.getPhone());
        dbManager.setString(35,housepolicylistDto.getRemark());
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
        buffer.append("INSERT INTO Housepolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Address,");
        buffer.append("Areacode,");
        buffer.append("Rate,");
        buffer.append("Riskcode,");
        buffer.append("Classcode,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Calculateflag,");
        buffer.append("Validity,");
        buffer.append("Hukoubu,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber,");
        buffer.append("Phone,");
        buffer.append("Remark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            HousepolicylistDto housepolicylistDto = (HousepolicylistDto)i.next();
            dbManager.setString(1,housepolicylistDto.getInusrelistcode());
            dbManager.setString(2,housepolicylistDto.getKindcode());
            dbManager.setString(3,housepolicylistDto.getIndexcode());
            dbManager.setString(4,housepolicylistDto.getName());
            dbManager.setString(5,housepolicylistDto.getIdcard());
            dbManager.setString(6,housepolicylistDto.getAddress());
            dbManager.setString(7,housepolicylistDto.getAreacode());
            dbManager.setDouble(8,housepolicylistDto.getRate());
            dbManager.setString(9,housepolicylistDto.getRiskcode());
            dbManager.setString(10,housepolicylistDto.getClasscode());
            dbManager.setString(11,housepolicylistDto.getShortrateflag());
            dbManager.setDouble(12,housepolicylistDto.getShortrate());
            dbManager.setDouble(13,housepolicylistDto.getSumamount());
            dbManager.setDouble(14,housepolicylistDto.getSumpremium());
            dbManager.setDouble(15,housepolicylistDto.getFpremium());
            dbManager.setDouble(16,housepolicylistDto.getCentralpremium());
            dbManager.setDouble(17,housepolicylistDto.getProvincepremium());
            dbManager.setDouble(18,housepolicylistDto.getCitypremium());
            dbManager.setDouble(19,housepolicylistDto.getTownpremium());
            dbManager.setDouble(20,housepolicylistDto.getOtherpremium());
            dbManager.setDateTime(21,housepolicylistDto.getStartdate());
            dbManager.setDateTime(22,housepolicylistDto.getEnddate());
            dbManager.setString(23,housepolicylistDto.getOpcode());
            dbManager.setDateTime(24,housepolicylistDto.getOptime());
            dbManager.setString(25,housepolicylistDto.getCalculateflag());
            dbManager.setString(26,housepolicylistDto.getValidity());
            dbManager.setString(27,housepolicylistDto.getHukoubu());
            dbManager.setString(28,housepolicylistDto.getFloor());
            dbManager.setString(29,housepolicylistDto.getBuildingnumber());
            dbManager.setString(30,housepolicylistDto.getZhuannumber());
            dbManager.setString(31,housepolicylistDto.getWanumber());
            dbManager.setString(32,housepolicylistDto.getKitchennumber());
            dbManager.setString(33,housepolicylistDto.getOthernumber());
            dbManager.setString(34,housepolicylistDto.getPhone());
            dbManager.setString(35,housepolicylistDto.getRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Housepolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,idcard);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param housepolicylistDto housepolicylistDto
     * @throws Exception
     */
    public void update(HousepolicylistDto housepolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Housepolicylist SET ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("Areacode = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Shortrateflag = ?, ");
        buffer.append("Shortrate = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Sumpremium = ?, ");
        buffer.append("Fpremium = ?, ");
        buffer.append("Centralpremium = ?, ");
        buffer.append("Provincepremium = ?, ");
        buffer.append("Citypremium = ?, ");
        buffer.append("Townpremium = ?, ");
        buffer.append("Otherpremium = ?, ");
        buffer.append("Startdate = ?, ");
        buffer.append("Enddate = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Calculateflag = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Hukoubu = ?, ");
        buffer.append("Floor = ?, ");
        buffer.append("Buildingnumber = ?, ");
        buffer.append("Zhuannumber = ?, ");
        buffer.append("Wanumber = ?, ");
        buffer.append("Kitchennumber = ?, ");
        buffer.append("Othernumber = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Housepolicylist SET ");
            debugBuffer.append("Kindcode = '" + housepolicylistDto.getKindcode() + "', ");
            debugBuffer.append("Indexcode = '" + housepolicylistDto.getIndexcode() + "', ");
            debugBuffer.append("Name = '" + housepolicylistDto.getName() + "', ");
            debugBuffer.append("Address = '" + housepolicylistDto.getAddress() + "', ");
            debugBuffer.append("Areacode = '" + housepolicylistDto.getAreacode() + "', ");
            debugBuffer.append("Rate = " + housepolicylistDto.getRate() + ", ");
            debugBuffer.append("Riskcode = '" + housepolicylistDto.getRiskcode() + "', ");
            debugBuffer.append("Classcode = '" + housepolicylistDto.getClasscode() + "', ");
            debugBuffer.append("Shortrateflag = '" + housepolicylistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + housepolicylistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + housepolicylistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + housepolicylistDto.getSumpremium() + ", ");
            debugBuffer.append("Fpremium = " + housepolicylistDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + housepolicylistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + housepolicylistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + housepolicylistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + housepolicylistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + housepolicylistDto.getOtherpremium() + ", ");
            debugBuffer.append("Startdate = '" + housepolicylistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + housepolicylistDto.getEnddate() + "', ");
            debugBuffer.append("Opcode = '" + housepolicylistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + housepolicylistDto.getOptime() + "', ");
            debugBuffer.append("Calculateflag = '" + housepolicylistDto.getCalculateflag() + "', ");
            debugBuffer.append("Validity = '" + housepolicylistDto.getValidity() + "', ");
            debugBuffer.append("Hukoubu = '" + housepolicylistDto.getHukoubu() + "', ");
            debugBuffer.append("Floor = '" + housepolicylistDto.getFloor() + "', ");
            debugBuffer.append("Buildingnumber = '" + housepolicylistDto.getBuildingnumber() + "', ");
            debugBuffer.append("Zhuannumber = '" + housepolicylistDto.getZhuannumber() + "', ");
            debugBuffer.append("Wanumber = '" + housepolicylistDto.getWanumber() + "', ");
            debugBuffer.append("Kitchennumber = '" + housepolicylistDto.getKitchennumber() + "', ");
            debugBuffer.append("Othernumber = '" + housepolicylistDto.getOthernumber() + "', ");
            debugBuffer.append("Phone = '" + housepolicylistDto.getPhone() + "', ");
            debugBuffer.append("Remark = '" + housepolicylistDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(housepolicylistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(housepolicylistDto.getIdcard()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,housepolicylistDto.getKindcode());
        dbManager.setString(2,housepolicylistDto.getIndexcode());
        dbManager.setString(3,housepolicylistDto.getName());
        dbManager.setString(4,housepolicylistDto.getAddress());
        dbManager.setString(5,housepolicylistDto.getAreacode());
        dbManager.setDouble(6,housepolicylistDto.getRate());
        dbManager.setString(7,housepolicylistDto.getRiskcode());
        dbManager.setString(8,housepolicylistDto.getClasscode());
        dbManager.setString(9,housepolicylistDto.getShortrateflag());
        dbManager.setDouble(10,housepolicylistDto.getShortrate());
        dbManager.setDouble(11,housepolicylistDto.getSumamount());
        dbManager.setDouble(12,housepolicylistDto.getSumpremium());
        dbManager.setDouble(13,housepolicylistDto.getFpremium());
        dbManager.setDouble(14,housepolicylistDto.getCentralpremium());
        dbManager.setDouble(15,housepolicylistDto.getProvincepremium());
        dbManager.setDouble(16,housepolicylistDto.getCitypremium());
        dbManager.setDouble(17,housepolicylistDto.getTownpremium());
        dbManager.setDouble(18,housepolicylistDto.getOtherpremium());
        dbManager.setDateTime(19,housepolicylistDto.getStartdate());
        dbManager.setDateTime(20,housepolicylistDto.getEnddate());
        dbManager.setString(21,housepolicylistDto.getOpcode());
        dbManager.setDateTime(22,housepolicylistDto.getOptime());
        dbManager.setString(23,housepolicylistDto.getCalculateflag());
        dbManager.setString(24,housepolicylistDto.getValidity());
        dbManager.setString(25,housepolicylistDto.getHukoubu());
        dbManager.setString(26,housepolicylistDto.getFloor());
        dbManager.setString(27,housepolicylistDto.getBuildingnumber());
        dbManager.setString(28,housepolicylistDto.getZhuannumber());
        dbManager.setString(29,housepolicylistDto.getWanumber());
        dbManager.setString(30,housepolicylistDto.getKitchennumber());
        dbManager.setString(31,housepolicylistDto.getOthernumber());
        dbManager.setString(32,housepolicylistDto.getPhone());
        dbManager.setString(33,housepolicylistDto.getRemark());
        //设置条件字段;
        dbManager.setString(34,housepolicylistDto.getInusrelistcode());
        dbManager.setString(35,housepolicylistDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param idcard IDCARD
     * @return HousepolicylistDto
     * @throws Exception
     */
    public HousepolicylistDto findByPrimaryKey(String inusrelistcode,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Address,");
        buffer.append("Areacode,");
        buffer.append("Rate,");
        buffer.append("Riskcode,");
        buffer.append("Classcode,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Calculateflag,");
        buffer.append("Validity,");
        buffer.append("Hukoubu,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber,");
        buffer.append("Phone,");
        buffer.append("Remark ");
        buffer.append("FROM Housepolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,idcard);
        ResultSet resultSet = null;
        HousepolicylistDto housepolicylistDto = null;
        try{
            resultSet = dbManager.executePreparedQuery();
            if(resultSet.next()){
                housepolicylistDto = new HousepolicylistDto();
                housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
                housepolicylistDto.setKindcode(dbManager.getString(resultSet,2));
                housepolicylistDto.setIndexcode(dbManager.getString(resultSet,3));
                housepolicylistDto.setName(dbManager.getString(resultSet,4));
                housepolicylistDto.setIdcard(dbManager.getString(resultSet,5));
                housepolicylistDto.setAddress(dbManager.getString(resultSet,6));
                housepolicylistDto.setAreacode(dbManager.getString(resultSet,7));
                housepolicylistDto.setRate(dbManager.getDouble(resultSet,8));
                housepolicylistDto.setRiskcode(dbManager.getString(resultSet,9));
                housepolicylistDto.setClasscode(dbManager.getString(resultSet,10));
                housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,11));
                housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,12));
                housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,13));
                housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,14));
                housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,15));
                housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,16));
                housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,17));
                housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,18));
                housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,19));
                housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,20));
                housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
                housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
                housepolicylistDto.setOpcode(dbManager.getString(resultSet,23));
                //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,24));
                housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,25));
                housepolicylistDto.setValidity(dbManager.getString(resultSet,26));
                housepolicylistDto.setHukoubu(dbManager.getString(resultSet,27));
                housepolicylistDto.setFloor(dbManager.getString(resultSet,28));
                housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,29));
                housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,30));
                housepolicylistDto.setWanumber(dbManager.getString(resultSet,31));
                housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,32));
                housepolicylistDto.setOthernumber(dbManager.getString(resultSet,33));
                housepolicylistDto.setPhone(dbManager.getString(resultSet,34));
                housepolicylistDto.setRemark(dbManager.getString(resultSet,35));
            }
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
        return housepolicylistDto;
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
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Name,");
        buffer.append("Idcard,");
        buffer.append("Address,");
        buffer.append("Areacode,");
        buffer.append("Rate,");
        buffer.append("Riskcode,");
        buffer.append("Classcode,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Calculateflag,");
        buffer.append("Validity,");
        buffer.append("Hukoubu,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber,");
        buffer.append("Phone,");
        buffer.append("Remark ");
        buffer.append("FROM Housepolicylist WHERE ");
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
        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            int count=0;
            if(supportPaging==false && pageNo>1){
                dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
            }

            HousepolicylistDto housepolicylistDto = null;
            while(resultSet.next()){
                if (supportPaging == false && pageNo>0) {
                    count++;
                    if(count > rowsPerPage){
                        break;
                    }
                }

                housepolicylistDto = new HousepolicylistDto();
                housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
                housepolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
                housepolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
                housepolicylistDto.setName(dbManager.getString(resultSet,"Name"));
                housepolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
                housepolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
                housepolicylistDto.setAreacode(dbManager.getString(resultSet,"Areacode"));
                housepolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
                housepolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
                housepolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
                housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
                housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
                housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
                housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
                housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
                housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
                housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
                housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
                housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
                housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
                housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
                housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
                housepolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
                //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,"Optime"));
                housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
                housepolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
                housepolicylistDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
                housepolicylistDto.setFloor(dbManager.getString(resultSet,"Floor"));
                housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
                housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
                housepolicylistDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
                housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
                housepolicylistDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
                housepolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
                housepolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
                collection.add(housepolicylistDto);
            }
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
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
        buffer.append("DELETE FROM Housepolicylist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        return dbManager.executeUpdate(buffer.toString());
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
        buffer.append("SELECT count(*) FROM Housepolicylist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            resultSet.next();
            count = dbManager.getInt(resultSet,1);
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
        return count;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getIdcardCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Housepolicylist d,insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try
        {
	        resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        count = dbManager.getInt(resultSet,1);
	        resultSet.close();
	        return count;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }
    }
    
    public int getIdcardCount1(String conditions) 
    throws Exception{
    int count = -1;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT COUNT (*) FROM housepolicylist d,INSUREMAINLIST e where d.inusrelistcode=e.inusrelistcode and  e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
    buffer.append(conditions);
    if(logger.isDebugEnabled()){
        logger.debug(buffer.toString());
    }
    ResultSet resultSet = null;
    //System.err.println("sql:"+buffer.toString() );
    try
    {
        resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    catch(Exception exception){
        resultSet.close();
        throw exception;
    }
    finally{
    	resultSet.close();
    }
}
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getAreacodeCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(count(d.inusrelistcode)) FROM Housepolicylist d,insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
	" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
        buffer.append(conditions);
        System.err.println("sql2:" + buffer.toString());
        buffer.append(" group by d.areacode ");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try
        {
	        resultSet = dbManager.executeQuery(buffer.toString());
	        resultSet.next();
	        count = dbManager.getInt(resultSet,1);
	        resultSet.close();
	        return count;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }
    }
    
    public int getAreacodeCount1(String conditions) 
    throws Exception{
    int count = -1;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT count(count(d.inusrelistcode)) FROM housepolicylist d,INSUREMAINLIST e where d.inusrelistcode=e.inusrelistcode and  e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
    buffer.append(conditions);
    buffer.append(" group by d.areacode ");
    if(logger.isDebugEnabled()){
        logger.debug(buffer.toString());
    }
    //System.err.println("sql:"+ buffer.toString());
    ResultSet resultSet = null;
    try
    {
        resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    catch(Exception exception){
        resultSet.close();
        throw exception;
    }
    finally{
    	resultSet.close();
    }
}
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findIdcardByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        String areaName = "";//blAreas.getAreaFullName(strAreaCode);
        BLAreas blAreas = new BLAreas();
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("a.PolicyNo,");
    	buffer.append("b.LicenseNo,");
    	buffer.append("a.InsuredName,");
    	buffer.append("a.StartDate,");
    	buffer.append("a.EndDate,");
    	buffer.append("b.BrandName,");
    	buffer.append("a.OthFlag,");
    	buffer.append("a.riskcode,");
    	buffer.append("a.classcode,");
    	buffer.append("a.sumquantity,");
    	buffer.append("a.flag,");
    	buffer.append("a.underwriteflag,");
    	//buffer.append("b.licenseno,");
        buffer.append("d.Inusrelistcode,");
        buffer.append("d.Kindcode,");
        buffer.append("d.Indexcode,");
        buffer.append("d.Name,");
        buffer.append("d.Idcard,");
        buffer.append("d.Address,");
        buffer.append("d.Areacode,");
        buffer.append("d.Rate,");
        buffer.append("d.Riskcode as Riskcodeb,");
        buffer.append("d.Classcode as Classcodeb,");
        buffer.append("d.Shortrateflag,");
        buffer.append("d.Shortrate,");
        buffer.append("d.Sumamount,");
        buffer.append("d.Sumpremium,");
        buffer.append("d.Fpremium,");
        buffer.append("d.Centralpremium,");
        buffer.append("d.Provincepremium,");
        buffer.append("d.Citypremium,");
        buffer.append("d.Townpremium,");
        buffer.append("d.Otherpremium,");
        buffer.append("d.Startdate as Startdateb,");
        buffer.append("d.Enddate as Enddateb,");
        buffer.append("d.Opcode,");
        buffer.append("d.Optime,");
        buffer.append("d.Calculateflag,");
        buffer.append("d.Validity,");
        buffer.append("d.Hukoubu,");
        buffer.append("d.Floor,");
        buffer.append("d.Buildingnumber,");
        buffer.append("d.Zhuannumber,");
        buffer.append("d.Wanumber,");
        buffer.append("d.Kitchennumber,");
        buffer.append("d.Othernumber,");
        buffer.append("d.Phone,");
        buffer.append("d.Remark ");
	buffer.append("FROM Housepolicylist d,insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
			" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
		buffer.append(" order by rownum");
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
        System.err.println(buffer);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //定义返回结果集合
        //Collection collection = new ArrayList(rowsPerPage);
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            int count=0;
            if(supportPaging==false && pageNo>1){
                dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
            }

	    Collection collection = new ArrayList(rowsPerPage);
            HousepolicylistDto housepolicylistDto = null;
            while(resultSet.next()){
                if (supportPaging == false && pageNo>0) {
                    count++;
                    if(count > rowsPerPage){
                        break;
                    }
                }

                housepolicylistDto = new HousepolicylistDto();
            PrpCmainDto prpCmainDto = new PrpCmainDto();
			prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
			prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
			prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
			prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
			prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
			prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
			//添加保单是否已经注销标志
			prpCmainDto.setOthFlag(dbManager.getString(resultSet,7));
			prpCmainDto.setRiskCode( dbManager.getString(resultSet,8));
			prpCmainDto.setClassCode( dbManager.getString(resultSet,9));
			 //add by guolei  20070519 增加团单
            if(dbManager.getString(resultSet,11).length()>=2){
            	prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
            }
	    //添加见费出单的标志
            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
            //增加车牌号码
            prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
            	housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
                housepolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
                housepolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
                housepolicylistDto.setName(dbManager.getString(resultSet,"Name"));
                housepolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
                housepolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
                housepolicylistDto.setAreacode(dbManager.getString(resultSet,"Areacode"));
                housepolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
                housepolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcodeb"));
                housepolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcodeb"));
                housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
                housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
                housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
                housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
                housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
                housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
                housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
                housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
                housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
                housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
                housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdateb"));
                housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddateb"));
                housepolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
                //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,"Optime"));
                housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
                housepolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
                housepolicylistDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
                housepolicylistDto.setFloor(dbManager.getString(resultSet,"Floor"));
                housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
                housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
                housepolicylistDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
                housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
                housepolicylistDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
                housepolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
                //housepolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
                areaName = blAreas.getAreaFullName(dbManager.getString(resultSet,"Areacode"));
                housepolicylistDto.setRemark(areaName);
                IdcardRegistDto idcardRegistDto = new IdcardRegistDto();
                idcardRegistDto.setHousepolicylistDto(housepolicylistDto);
                idcardRegistDto.setPrpCmainDto(prpCmainDto);
                collection.add(idcardRegistDto);
		
	        }
	        return collection;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }

    }
    
    public Collection findIdcardByConditions1(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
StringBuffer buffer = new StringBuffer(200);
String areaName = "";//blAreas.getAreaFullName(strAreaCode);
BLAreas blAreas = new BLAreas();
//拼SQL语句
buffer.append("SELECT ");

buffer.append("e.PolicyNo,");
//buffer.append("b.LicenseNo,");
//buffer.append("a.InsuredName,");
buffer.append("e.Starttime as startdate,");
buffer.append("e.Endtime as enddate,");
//buffer.append("b.BrandName,");
//buffer.append("a.OthFlag,");
buffer.append("e.riskcode,");
buffer.append("e.classcode,");
buffer.append("e.FAREACODE,");

//buffer.append("b.licenseno,");
buffer.append("d.Inusrelistcode,");
buffer.append("d.Kindcode,");
buffer.append("d.Indexcode,");
buffer.append("d.Name,");
buffer.append("d.Idcard,");
buffer.append("d.Address,");
buffer.append("d.Areacode,");
buffer.append("d.Rate,");
buffer.append("d.Shortrateflag,");
buffer.append("d.Shortrate,");
buffer.append("d.Sumamount,");
buffer.append("d.Sumpremium,");
buffer.append("d.Fpremium,");
buffer.append("d.Centralpremium,");
buffer.append("d.Provincepremium,");
buffer.append("d.Citypremium,");
buffer.append("d.Townpremium,");
buffer.append("d.Otherpremium,");
buffer.append("d.Opcode,");
buffer.append("d.Optime,");
buffer.append("d.Calculateflag,");
buffer.append("d.Validity,");
buffer.append("d.Hukoubu,");
buffer.append("d.Floor,");
buffer.append("d.Buildingnumber,");
buffer.append("d.Zhuannumber,");
buffer.append("d.Wanumber,");
buffer.append("d.Kitchennumber,");
buffer.append("d.Othernumber,");
buffer.append("d.Phone,");
buffer.append("d.Remark ");
buffer.append("FROM Housepolicylist d,insuremainlist e " +
	        		" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
buffer.append(conditions);
boolean supportPaging = false;//数据库是否支持分页
if (pageNo > 0){
    //对Oracle优化
    if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
        buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
        buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
buffer.append(" order by rownum");
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
//System.err.println(buffer);
if(logger.isDebugEnabled()){
    logger.debug(buffer.toString());
}
//定义返回结果集合
//Collection collection = new ArrayList(rowsPerPage);
ResultSet resultSet = null;
try{
    resultSet = dbManager.executeQuery(buffer.toString());
    int count=0;
    if(supportPaging==false && pageNo>1){
        dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
    }

Collection collection = new ArrayList(rowsPerPage);
    HousepolicylistDto housepolicylistDto = null;
    while(resultSet.next()){
        if (supportPaging == false && pageNo>0) {
            count++;
            if(count > rowsPerPage){
                break;
            }
        }

        housepolicylistDto = new HousepolicylistDto();
    PrpCmainDto prpCmainDto = new PrpCmainDto();
	prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
	//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
	prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
	prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
	prpCmainDto.setRiskCode( dbManager.getString(resultSet,4));
	prpCmainDto.setClassCode( dbManager.getString(resultSet,5));
	prpCmainDto.setComCode(dbManager.getString(resultSet,6));
	 //add by guolei  20070519 增加团单
    //if(dbManager.getString(resultSet,11).length()>=2){
    	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
    //}
//添加见费出单的标志
    //prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
    //增加车牌号码
    //prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
    	housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
        housepolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
        housepolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
        housepolicylistDto.setName(dbManager.getString(resultSet,"Name"));
        housepolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
        housepolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
        housepolicylistDto.setAreacode(dbManager.getString(resultSet,"Areacode"));
        housepolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
        housepolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
        housepolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
        housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
        housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
        housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
        housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
        housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
        housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
        housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
        housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
        housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
        housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
        housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
        housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
        housepolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
        //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,"Optime"));
        housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
        housepolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
        housepolicylistDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
        housepolicylistDto.setFloor(dbManager.getString(resultSet,"Floor"));
        housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
        housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
        housepolicylistDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
        housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
        housepolicylistDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
        housepolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
        //housepolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
        areaName = blAreas.getAreaFullName(dbManager.getString(resultSet,"Areacode"));
        housepolicylistDto.setRemark(areaName);
        IdcardRegistDto idcardRegistDto = new IdcardRegistDto();
        idcardRegistDto.setHousepolicylistDto(housepolicylistDto);
        idcardRegistDto.setPrpCmainDto(prpCmainDto);
        collection.add(idcardRegistDto);

    }
    return collection;
}
catch(Exception exception){
    resultSet.close();
    throw exception;
}
finally{
	resultSet.close();
}

}
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findAreacodeByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        String areaName = "";//blAreas.getAreaFullName(strAreaCode);
        BLAreas blAreas = new BLAreas();
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("distinct a.PolicyNo,");
    	buffer.append("b.LicenseNo,");
    	buffer.append("a.InsuredName,");
    	buffer.append("a.StartDate,");
    	buffer.append("a.EndDate,");
    	buffer.append("b.BrandName,");
    	buffer.append("a.OthFlag,");
    	buffer.append("a.riskcode,");
    	buffer.append("a.classcode,");
    	buffer.append("a.sumquantity,");
    	buffer.append("a.flag,");
    	buffer.append("a.underwriteflag, ");
    	//buffer.append("b.licenseno,");
        buffer.append("e.Inusrelistcode,");
        buffer.append("e.fareacode ");
//        buffer.append("d.Indexcode,");
//        buffer.append("d.Name,");
//        buffer.append("d.Idcard,");
//        buffer.append("d.Address,");
//        buffer.append("d.Areacode,");
//        buffer.append("d.Rate,");
//        buffer.append("d.Riskcode as Riskcodeb,");
//        buffer.append("d.Classcode as Classcodeb,");
//        buffer.append("d.Shortrateflag,");
//        buffer.append("d.Shortrate,");
//        buffer.append("d.Sumamount,");
//        buffer.append("d.Sumpremium,");
//        buffer.append("d.Fpremium,");
//        buffer.append("d.Centralpremium,");
//        buffer.append("d.Provincepremium,");
//        buffer.append("d.Citypremium,");
//        buffer.append("d.Townpremium,");
//        buffer.append("d.Otherpremium,");
//        buffer.append("d.Startdate as Startdateb,");
//        buffer.append("d.Enddate as Enddateb,");
//        buffer.append("d.Opcode,");
//        buffer.append("d.Optime,");
//        buffer.append("d.Calculateflag,");
//        buffer.append("d.Validity,");
//        buffer.append("d.Hukoubu,");
//        buffer.append("d.Floor,");
//        buffer.append("d.Buildingnumber,");
//        buffer.append("d.Zhuannumber,");
//        buffer.append("d.Wanumber,");
//        buffer.append("d.Kitchennumber,");
//        buffer.append("d.Othernumber,");
//        buffer.append("d.Phone,");
//        buffer.append("d.Remark ");
	buffer.append("FROM insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
			" WHERE e.policyno = a.policyno and e.VALIDITY in ('2') and (e.riskcode = '0310' or e.riskcode = '0312')  and ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
		buffer.append(" order by rownum");
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
        System.err.println(buffer);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //定义返回结果集合
        //Collection collection = new ArrayList(rowsPerPage);
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            int count=0;
            if(supportPaging==false && pageNo>1){
                dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
            }

	    Collection collection = new ArrayList(rowsPerPage);
            HousepolicylistDto housepolicylistDto = null;
            while(resultSet.next()){
                if (supportPaging == false && pageNo>0) {
                    count++;
                    if(count > rowsPerPage){
                        break;
                    }
                }

                housepolicylistDto = new HousepolicylistDto();
            PrpCmainDto prpCmainDto = new PrpCmainDto();
			prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
			prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
			prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
			prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
			prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
			prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
			//添加保单是否已经注销标志
			prpCmainDto.setOthFlag(dbManager.getString(resultSet,7));
			prpCmainDto.setRiskCode( dbManager.getString(resultSet,8));
			prpCmainDto.setClassCode( dbManager.getString(resultSet,9));
			 //add by guolei  20070519 增加团单
            if(dbManager.getString(resultSet,11).length()>=2){
            	prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
            }
	    //添加见费出单的标志
            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
            //增加车牌号码
            prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
            	housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
//                housepolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
//                housepolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
//                housepolicylistDto.setName(dbManager.getString(resultSet,"Name"));
//                housepolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
//                housepolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
                housepolicylistDto.setAreacode(dbManager.getString(resultSet,"fAreacode"));
//                housepolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
//                housepolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcodeb"));
//                housepolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcodeb"));
//                housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
//                housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
//                housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
//                housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
//                housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
//                housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
//                housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
//                housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
//                housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
//                housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
//                housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdateb"));
//                housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddateb"));
//                housepolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
//                //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,"Optime"));
//                housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
//                housepolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
//                housepolicylistDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
//                housepolicylistDto.setFloor(dbManager.getString(resultSet,"Floor"));
//                housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
//                housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
//                housepolicylistDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
//                housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
//                housepolicylistDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
//                housepolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
                areaName = blAreas.getAreaFullName(dbManager.getString(resultSet,"fAreacode"));
                housepolicylistDto.setRemark(areaName);
                IdcardRegistDto idcardRegistDto = new IdcardRegistDto();
                idcardRegistDto.setHousepolicylistDto(housepolicylistDto);
                idcardRegistDto.setPrpCmainDto(prpCmainDto);
                collection.add(idcardRegistDto);
		
	        }
	        return collection;
        }
        catch(Exception exception){
            resultSet.close();
            throw exception;
        }
        finally{
        	resultSet.close();
        }

    }
    
    public Collection findAreacodeByConditions1(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
StringBuffer buffer = new StringBuffer(200);
String areaName = "";//blAreas.getAreaFullName(strAreaCode);
BLAreas blAreas = new BLAreas();
//拼SQL语句
buffer.append("SELECT ");
buffer.append("distinct e.PolicyNo,");
buffer.append("e.Starttime as startdate,");
buffer.append("e.Endtime as enddate,");
//buffer.append("b.licenseno,");

buffer.append("e.riskcode,");
buffer.append("e.classcode,");
buffer.append("e.FAREACODE,");

buffer.append("e.Inusrelistcode ");
//buffer.append("d.Indexcode,");
//buffer.append("d.Name,");
//buffer.append("d.Idcard,");
//buffer.append("d.Address,");
//buffer.append("d.Areacode,");
//buffer.append("d.Rate,");
//buffer.append("d.Riskcode as Riskcodeb,");
//buffer.append("d.Classcode as Classcodeb,");
//buffer.append("d.Shortrateflag,");
//buffer.append("d.Shortrate,");
//buffer.append("d.Sumamount,");
//buffer.append("d.Sumpremium,");
//buffer.append("d.Fpremium,");
//buffer.append("d.Centralpremium,");
//buffer.append("d.Provincepremium,");
//buffer.append("d.Citypremium,");
//buffer.append("d.Townpremium,");
//buffer.append("d.Otherpremium,");
//buffer.append("d.Startdate as Startdateb,");
//buffer.append("d.Enddate as Enddateb,");
//buffer.append("d.Opcode,");
//buffer.append("d.Optime,");
//buffer.append("d.Calculateflag,");
//buffer.append("d.Validity,");
//buffer.append("d.Hukoubu,");
//buffer.append("d.Floor,");
//buffer.append("d.Buildingnumber,");
//buffer.append("d.Zhuannumber,");
//buffer.append("d.Wanumber,");
//buffer.append("d.Kitchennumber,");
//buffer.append("d.Othernumber,");
//buffer.append("d.Phone,");
//buffer.append("d.Remark ");
buffer.append(" FROM Housepolicylist d,insuremainlist e " +
	        		" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
buffer.append(conditions);
boolean supportPaging = false;//数据库是否支持分页
if (pageNo > 0){
    //对Oracle优化
    if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
        buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
        buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
buffer.append(" order by rownum");
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
System.err.println(buffer);
if(logger.isDebugEnabled()){
    logger.debug(buffer.toString());
}
//定义返回结果集合
//Collection collection = new ArrayList(rowsPerPage);
ResultSet resultSet = null;
try{
    resultSet = dbManager.executeQuery(buffer.toString());
    int count=0;
    if(supportPaging==false && pageNo>1){
        dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
    }

Collection collection = new ArrayList(rowsPerPage);
    HousepolicylistDto housepolicylistDto = null;
    while(resultSet.next()){
        if (supportPaging == false && pageNo>0) {
            count++;
            if(count > rowsPerPage){
                break;
            }
        }

        housepolicylistDto = new HousepolicylistDto();
    PrpCmainDto prpCmainDto = new PrpCmainDto();
	prpCmainDto.setPolicyNo(dbManager.getString(resultSet,1));
	//prpCmainDto.setLicenseNo(dbManager.getString(resultSet,2));
	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3));
	prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
	prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
	//prpCmainDto.setBrandName(dbManager.getString(resultSet,6));
	//添加保单是否已经注销标志
	//prpCmainDto.setOthFlag(dbManager.getString(resultSet,7));
	prpCmainDto.setRiskCode( dbManager.getString(resultSet,4));
	prpCmainDto.setClassCode( dbManager.getString(resultSet,5));
	prpCmainDto.setComCode(dbManager.getString(resultSet,6));
	//添加保单是否已经注销标志
	
	 //add by guolei  20070519 增加团单
    //if(dbManager.getString(resultSet,11).length()>=2){
    	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
    //}
//添加见费出单的标志
    //prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
    //增加车牌号码
    //prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
    	housepolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
//        housepolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
//        housepolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
//        housepolicylistDto.setName(dbManager.getString(resultSet,"Name"));
//        housepolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
//        housepolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
        housepolicylistDto.setAreacode(dbManager.getString(resultSet,"fAreacode"));
//        housepolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
//        housepolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcodeb"));
//        housepolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcodeb"));
//        housepolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
//        housepolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
//        housepolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
//        housepolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
//        housepolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
//        housepolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
//        housepolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
//        housepolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
//        housepolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
//        housepolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
//        housepolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdateb"));
//        housepolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddateb"));
//        housepolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
//        //housepolicylistDto.setOptime(dbManager.getDateTime(resultSet,null,"Optime"));
//        housepolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
//        housepolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
//        housepolicylistDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
//        housepolicylistDto.setFloor(dbManager.getString(resultSet,"Floor"));
//        housepolicylistDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
//        housepolicylistDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
//        housepolicylistDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
//        housepolicylistDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
//        housepolicylistDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
//        housepolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
        areaName = blAreas.getAreaFullName(dbManager.getString(resultSet,"fAreacode"));
        housepolicylistDto.setRemark(areaName);
        IdcardRegistDto idcardRegistDto = new IdcardRegistDto();
        idcardRegistDto.setHousepolicylistDto(housepolicylistDto);
        idcardRegistDto.setPrpCmainDto(prpCmainDto);
        collection.add(idcardRegistDto);

    }
    return collection;
}
catch(Exception exception){
    resultSet.close();
    throw exception;
}
finally{
	resultSet.close();
}

}
}
