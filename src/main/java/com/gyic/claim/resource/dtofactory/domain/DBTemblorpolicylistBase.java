package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORPOLICYLIST的数据访问对象基类<br>
 */
public class DBTemblorpolicylistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorpolicylistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorpolicylistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void insert(TemblorpolicylistDto temblorpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Countrycode,");
        buffer.append("Citycode,");
        buffer.append("Address,");
        buffer.append("Zipcode,");
        buffer.append("Longitude,");
        buffer.append("Latitude,");
        buffer.append("Itemtype,");
        buffer.append("Building,");
        buffer.append("Floor,");
        buffer.append("Architecture,");
        buffer.append("Remark,");
        buffer.append("Area,");
        buffer.append("Buildtime,");
        buffer.append("Repair,");
        buffer.append("Repairtime,");
        buffer.append("Propcerttype,");
        buffer.append("Propcertno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Premium,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2 ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(temblorpolicylistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getRiskcode()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getAmount()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getRate()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getPremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getShortrate()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getSumamount()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getEndtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getValidity()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getFpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getTemp5()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorpolicylistDto.getName()).append("',");
            debugBuffer.append("").append(temblorpolicylistDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(temblorpolicylistDto.getRateadjust2()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorpolicylistDto.getInusrelistcode());
        dbManager.setString(2,temblorpolicylistDto.getBusinessno());
        dbManager.setString(3,temblorpolicylistDto.getKindcode());
        dbManager.setString(4,temblorpolicylistDto.getItemcode());
        dbManager.setString(5,temblorpolicylistDto.getIndexcode());
        dbManager.setString(6,temblorpolicylistDto.getCountrycode());
        dbManager.setString(7,temblorpolicylistDto.getCitycode());
        dbManager.setString(8,temblorpolicylistDto.getAddress());
        dbManager.setString(9,temblorpolicylistDto.getZipcode());
        dbManager.setDouble(10,temblorpolicylistDto.getLongitude());
        dbManager.setDouble(11,temblorpolicylistDto.getLatitude());
        dbManager.setString(12,temblorpolicylistDto.getItemtype());
        dbManager.setString(13,temblorpolicylistDto.getBuilding());
        dbManager.setInt(14,temblorpolicylistDto.getFloor());
        dbManager.setString(15,temblorpolicylistDto.getArchitecture());
        dbManager.setString(16,temblorpolicylistDto.getRemark());
        dbManager.setDouble(17,temblorpolicylistDto.getArea());
        dbManager.setString(18,temblorpolicylistDto.getBuildtime());
        dbManager.setString(19,temblorpolicylistDto.getRepair());
        dbManager.setString(20,temblorpolicylistDto.getRepairtime());
        dbManager.setString(21,temblorpolicylistDto.getPropcerttype());
        dbManager.setString(22,temblorpolicylistDto.getPropcertno());
        dbManager.setString(23,temblorpolicylistDto.getClasscode());
        dbManager.setString(24,temblorpolicylistDto.getRiskcode());
        dbManager.setDouble(25,temblorpolicylistDto.getAmount());
        dbManager.setDouble(26,temblorpolicylistDto.getRate());
        dbManager.setDouble(27,temblorpolicylistDto.getPremium());
        dbManager.setString(28,temblorpolicylistDto.getShortrateflag());
        dbManager.setDouble(29,temblorpolicylistDto.getShortrate());
        dbManager.setDouble(30,temblorpolicylistDto.getSumamount());
        dbManager.setDouble(31,temblorpolicylistDto.getSumpremium());
        dbManager.setDateTime(32,temblorpolicylistDto.getStartdate());
        dbManager.setDateTime(33,temblorpolicylistDto.getEnddate());
        dbManager.setString(34,temblorpolicylistDto.getStarttime());
        dbManager.setString(35,temblorpolicylistDto.getEndtime());
        dbManager.setString(36,temblorpolicylistDto.getCalculateflag());
        dbManager.setString(37,temblorpolicylistDto.getOpcode());
        dbManager.setDateTime(38,temblorpolicylistDto.getOptime());
        dbManager.setString(39,temblorpolicylistDto.getValidity());
        dbManager.setDouble(40,temblorpolicylistDto.getFpremium());
        dbManager.setDouble(41,temblorpolicylistDto.getCentralpremium());
        dbManager.setDouble(42,temblorpolicylistDto.getProvincepremium());
        dbManager.setDouble(43,temblorpolicylistDto.getCitypremium());
        dbManager.setDouble(44,temblorpolicylistDto.getTownpremium());
        dbManager.setDouble(45,temblorpolicylistDto.getOtherpremium());
        dbManager.setString(46,temblorpolicylistDto.getTemp1());
        dbManager.setString(47,temblorpolicylistDto.getTemp2());
        dbManager.setString(48,temblorpolicylistDto.getTemp3());
        dbManager.setString(49,temblorpolicylistDto.getTemp4());
        dbManager.setString(50,temblorpolicylistDto.getTemp5());
        dbManager.setString(51,temblorpolicylistDto.getCardtype());
        dbManager.setString(52,temblorpolicylistDto.getIdcard());
        dbManager.setString(53,temblorpolicylistDto.getName());
        dbManager.setDouble(54,temblorpolicylistDto.getRateadjust1());
        dbManager.setDouble(55,temblorpolicylistDto.getRateadjust2());
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
        buffer.append("INSERT INTO Temblorpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Countrycode,");
        buffer.append("Citycode,");
        buffer.append("Address,");
        buffer.append("Zipcode,");
        buffer.append("Longitude,");
        buffer.append("Latitude,");
        buffer.append("Itemtype,");
        buffer.append("Building,");
        buffer.append("Floor,");
        buffer.append("Architecture,");
        buffer.append("Remark,");
        buffer.append("Area,");
        buffer.append("Buildtime,");
        buffer.append("Repair,");
        buffer.append("Repairtime,");
        buffer.append("Propcerttype,");
        buffer.append("Propcertno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Premium,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2 ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TemblorpolicylistDto temblorpolicylistDto = (TemblorpolicylistDto)i.next();
            dbManager.setString(1,temblorpolicylistDto.getInusrelistcode());
            dbManager.setString(2,temblorpolicylistDto.getBusinessno());
            dbManager.setString(3,temblorpolicylistDto.getKindcode());
            dbManager.setString(4,temblorpolicylistDto.getItemcode());
            dbManager.setString(5,temblorpolicylistDto.getIndexcode());
            dbManager.setString(6,temblorpolicylistDto.getCountrycode());
            dbManager.setString(7,temblorpolicylistDto.getCitycode());
            dbManager.setString(8,temblorpolicylistDto.getAddress());
            dbManager.setString(9,temblorpolicylistDto.getZipcode());
            dbManager.setDouble(10,temblorpolicylistDto.getLongitude());
            dbManager.setDouble(11,temblorpolicylistDto.getLatitude());
            dbManager.setString(12,temblorpolicylistDto.getItemtype());
            dbManager.setString(13,temblorpolicylistDto.getBuilding());
            dbManager.setInt(14,temblorpolicylistDto.getFloor());
            dbManager.setString(15,temblorpolicylistDto.getArchitecture());
            dbManager.setString(16,temblorpolicylistDto.getRemark());
            dbManager.setDouble(17,temblorpolicylistDto.getArea());
            dbManager.setString(18,temblorpolicylistDto.getBuildtime());
            dbManager.setString(19,temblorpolicylistDto.getRepair());
            dbManager.setString(20,temblorpolicylistDto.getRepairtime());
            dbManager.setString(21,temblorpolicylistDto.getPropcerttype());
            dbManager.setString(22,temblorpolicylistDto.getPropcertno());
            dbManager.setString(23,temblorpolicylistDto.getClasscode());
            dbManager.setString(24,temblorpolicylistDto.getRiskcode());
            dbManager.setDouble(25,temblorpolicylistDto.getAmount());
            dbManager.setDouble(26,temblorpolicylistDto.getRate());
            dbManager.setDouble(27,temblorpolicylistDto.getPremium());
            dbManager.setString(28,temblorpolicylistDto.getShortrateflag());
            dbManager.setDouble(29,temblorpolicylistDto.getShortrate());
            dbManager.setDouble(30,temblorpolicylistDto.getSumamount());
            dbManager.setDouble(31,temblorpolicylistDto.getSumpremium());
            dbManager.setDateTime(32,temblorpolicylistDto.getStartdate());
            dbManager.setDateTime(33,temblorpolicylistDto.getEnddate());
            dbManager.setString(34,temblorpolicylistDto.getStarttime());
            dbManager.setString(35,temblorpolicylistDto.getEndtime());
            dbManager.setString(36,temblorpolicylistDto.getCalculateflag());
            dbManager.setString(37,temblorpolicylistDto.getOpcode());
            dbManager.setDateTime(38,temblorpolicylistDto.getOptime());
            dbManager.setString(39,temblorpolicylistDto.getValidity());
            dbManager.setDouble(40,temblorpolicylistDto.getFpremium());
            dbManager.setDouble(41,temblorpolicylistDto.getCentralpremium());
            dbManager.setDouble(42,temblorpolicylistDto.getProvincepremium());
            dbManager.setDouble(43,temblorpolicylistDto.getCitypremium());
            dbManager.setDouble(44,temblorpolicylistDto.getTownpremium());
            dbManager.setDouble(45,temblorpolicylistDto.getOtherpremium());
            dbManager.setString(46,temblorpolicylistDto.getTemp1());
            dbManager.setString(47,temblorpolicylistDto.getTemp2());
            dbManager.setString(48,temblorpolicylistDto.getTemp3());
            dbManager.setString(49,temblorpolicylistDto.getTemp4());
            dbManager.setString(50,temblorpolicylistDto.getTemp5());
            dbManager.setString(51,temblorpolicylistDto.getCardtype());
            dbManager.setString(52,temblorpolicylistDto.getIdcard());
            dbManager.setString(53,temblorpolicylistDto.getName());
            dbManager.setDouble(54,temblorpolicylistDto.getRateadjust1());
            dbManager.setDouble(55,temblorpolicylistDto.getRateadjust2());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,kindcode);
        dbManager.setString(3,itemcode);
        dbManager.setString(4,address);
        dbManager.setString(5,idcard);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param temblorpolicylistDto temblorpolicylistDto
     * @throws Exception
     */
    public void update(TemblorpolicylistDto temblorpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorpolicylist SET ");
        buffer.append("Businessno = ?, ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Countrycode = ?, ");
        buffer.append("Citycode = ?, ");
        buffer.append("Zipcode = ?, ");
        buffer.append("Longitude = ?, ");
        buffer.append("Latitude = ?, ");
        buffer.append("Itemtype = ?, ");
        buffer.append("Building = ?, ");
        buffer.append("Floor = ?, ");
        buffer.append("Architecture = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Area = ?, ");
        buffer.append("Buildtime = ?, ");
        buffer.append("Repair = ?, ");
        buffer.append("Repairtime = ?, ");
        buffer.append("Propcerttype = ?, ");
        buffer.append("Propcertno = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Rate = ?, ");
        buffer.append("Premium = ?, ");
        buffer.append("Shortrateflag = ?, ");
        buffer.append("Shortrate = ?, ");
        buffer.append("Sumamount = ?, ");
        buffer.append("Sumpremium = ?, ");
        buffer.append("Startdate = ?, ");
        buffer.append("Enddate = ?, ");
        buffer.append("Starttime = ?, ");
        buffer.append("Endtime = ?, ");
        buffer.append("Calculateflag = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Fpremium = ?, ");
        buffer.append("Centralpremium = ?, ");
        buffer.append("Provincepremium = ?, ");
        buffer.append("Citypremium = ?, ");
        buffer.append("Townpremium = ?, ");
        buffer.append("Otherpremium = ?, ");
        buffer.append("Temp1 = ?, ");
        buffer.append("Temp2 = ?, ");
        buffer.append("Temp3 = ?, ");
        buffer.append("Temp4 = ?, ");
        buffer.append("Temp5 = ?, ");
        buffer.append("Cardtype = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Rateadjust1 = ?, ");
        buffer.append("Rateadjust2 = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Temblorpolicylist SET ");
            debugBuffer.append("Businessno = '" + temblorpolicylistDto.getBusinessno() + "', ");
            debugBuffer.append("Indexcode = '" + temblorpolicylistDto.getIndexcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorpolicylistDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorpolicylistDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + temblorpolicylistDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorpolicylistDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorpolicylistDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorpolicylistDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorpolicylistDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorpolicylistDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorpolicylistDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorpolicylistDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorpolicylistDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorpolicylistDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorpolicylistDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorpolicylistDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorpolicylistDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorpolicylistDto.getPropcertno() + "', ");
            debugBuffer.append("Classcode = '" + temblorpolicylistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorpolicylistDto.getRiskcode() + "', ");
            debugBuffer.append("Amount = " + temblorpolicylistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + temblorpolicylistDto.getRate() + ", ");
            debugBuffer.append("Premium = " + temblorpolicylistDto.getPremium() + ", ");
            debugBuffer.append("Shortrateflag = '" + temblorpolicylistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + temblorpolicylistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + temblorpolicylistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + temblorpolicylistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + temblorpolicylistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + temblorpolicylistDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + temblorpolicylistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + temblorpolicylistDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + temblorpolicylistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + temblorpolicylistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorpolicylistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorpolicylistDto.getValidity() + "', ");
            debugBuffer.append("Fpremium = " + temblorpolicylistDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + temblorpolicylistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + temblorpolicylistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + temblorpolicylistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + temblorpolicylistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + temblorpolicylistDto.getOtherpremium() + ", ");
            debugBuffer.append("Temp1 = '" + temblorpolicylistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + temblorpolicylistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + temblorpolicylistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + temblorpolicylistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + temblorpolicylistDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + temblorpolicylistDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + temblorpolicylistDto.getName() + "', ");
            debugBuffer.append("Rateadjust1 = " + temblorpolicylistDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + temblorpolicylistDto.getRateadjust2() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(temblorpolicylistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorpolicylistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorpolicylistDto.getItemcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(temblorpolicylistDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(temblorpolicylistDto.getIdcard()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,temblorpolicylistDto.getBusinessno());
        dbManager.setString(2,temblorpolicylistDto.getIndexcode());
        dbManager.setString(3,temblorpolicylistDto.getCountrycode());
        dbManager.setString(4,temblorpolicylistDto.getCitycode());
        dbManager.setString(5,temblorpolicylistDto.getZipcode());
        dbManager.setDouble(6,temblorpolicylistDto.getLongitude());
        dbManager.setDouble(7,temblorpolicylistDto.getLatitude());
        dbManager.setString(8,temblorpolicylistDto.getItemtype());
        dbManager.setString(9,temblorpolicylistDto.getBuilding());
        dbManager.setInt(10,temblorpolicylistDto.getFloor());
        dbManager.setString(11,temblorpolicylistDto.getArchitecture());
        dbManager.setString(12,temblorpolicylistDto.getRemark());
        dbManager.setDouble(13,temblorpolicylistDto.getArea());
        dbManager.setString(14,temblorpolicylistDto.getBuildtime());
        dbManager.setString(15,temblorpolicylistDto.getRepair());
        dbManager.setString(16,temblorpolicylistDto.getRepairtime());
        dbManager.setString(17,temblorpolicylistDto.getPropcerttype());
        dbManager.setString(18,temblorpolicylistDto.getPropcertno());
        dbManager.setString(19,temblorpolicylistDto.getClasscode());
        dbManager.setString(20,temblorpolicylistDto.getRiskcode());
        dbManager.setDouble(21,temblorpolicylistDto.getAmount());
        dbManager.setDouble(22,temblorpolicylistDto.getRate());
        dbManager.setDouble(23,temblorpolicylistDto.getPremium());
        dbManager.setString(24,temblorpolicylistDto.getShortrateflag());
        dbManager.setDouble(25,temblorpolicylistDto.getShortrate());
        dbManager.setDouble(26,temblorpolicylistDto.getSumamount());
        dbManager.setDouble(27,temblorpolicylistDto.getSumpremium());
        dbManager.setDateTime(28,temblorpolicylistDto.getStartdate());
        dbManager.setDateTime(29,temblorpolicylistDto.getEnddate());
        dbManager.setString(30,temblorpolicylistDto.getStarttime());
        dbManager.setString(31,temblorpolicylistDto.getEndtime());
        dbManager.setString(32,temblorpolicylistDto.getCalculateflag());
        dbManager.setString(33,temblorpolicylistDto.getOpcode());
        dbManager.setDateTime(34,temblorpolicylistDto.getOptime());
        dbManager.setString(35,temblorpolicylistDto.getValidity());
        dbManager.setDouble(36,temblorpolicylistDto.getFpremium());
        dbManager.setDouble(37,temblorpolicylistDto.getCentralpremium());
        dbManager.setDouble(38,temblorpolicylistDto.getProvincepremium());
        dbManager.setDouble(39,temblorpolicylistDto.getCitypremium());
        dbManager.setDouble(40,temblorpolicylistDto.getTownpremium());
        dbManager.setDouble(41,temblorpolicylistDto.getOtherpremium());
        dbManager.setString(42,temblorpolicylistDto.getTemp1());
        dbManager.setString(43,temblorpolicylistDto.getTemp2());
        dbManager.setString(44,temblorpolicylistDto.getTemp3());
        dbManager.setString(45,temblorpolicylistDto.getTemp4());
        dbManager.setString(46,temblorpolicylistDto.getTemp5());
        dbManager.setString(47,temblorpolicylistDto.getCardtype());
        dbManager.setString(48,temblorpolicylistDto.getName());
        dbManager.setDouble(49,temblorpolicylistDto.getRateadjust1());
        dbManager.setDouble(50,temblorpolicylistDto.getRateadjust2());
        //设置条件字段;
        dbManager.setString(51,temblorpolicylistDto.getInusrelistcode());
        dbManager.setString(52,temblorpolicylistDto.getKindcode());
        dbManager.setString(53,temblorpolicylistDto.getItemcode());
        dbManager.setString(54,temblorpolicylistDto.getAddress());
        dbManager.setString(55,temblorpolicylistDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TemblorpolicylistDto
     * @throws Exception
     */
    public TemblorpolicylistDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Countrycode,");
        buffer.append("Citycode,");
        buffer.append("Address,");
        buffer.append("Zipcode,");
        buffer.append("Longitude,");
        buffer.append("Latitude,");
        buffer.append("Itemtype,");
        buffer.append("Building,");
        buffer.append("Floor,");
        buffer.append("Architecture,");
        buffer.append("Remark,");
        buffer.append("Area,");
        buffer.append("Buildtime,");
        buffer.append("Repair,");
        buffer.append("Repairtime,");
        buffer.append("Propcerttype,");
        buffer.append("Propcertno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Premium,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2 ");
        buffer.append("FROM Temblorpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,kindcode);
        dbManager.setString(3,itemcode);
        dbManager.setString(4,address);
        dbManager.setString(5,idcard);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TemblorpolicylistDto temblorpolicylistDto = null;
        if(resultSet.next()){
            temblorpolicylistDto = new TemblorpolicylistDto();
            temblorpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorpolicylistDto.setBusinessno(dbManager.getString(resultSet,2));
            temblorpolicylistDto.setKindcode(dbManager.getString(resultSet,3));
            temblorpolicylistDto.setItemcode(dbManager.getString(resultSet,4));
            temblorpolicylistDto.setIndexcode(dbManager.getString(resultSet,5));
            temblorpolicylistDto.setCountrycode(dbManager.getString(resultSet,6));
            temblorpolicylistDto.setCitycode(dbManager.getString(resultSet,7));
            temblorpolicylistDto.setAddress(dbManager.getString(resultSet,8));
            temblorpolicylistDto.setZipcode(dbManager.getString(resultSet,9));
            temblorpolicylistDto.setLongitude(dbManager.getDouble(resultSet,10));
            temblorpolicylistDto.setLatitude(dbManager.getDouble(resultSet,11));
            temblorpolicylistDto.setItemtype(dbManager.getString(resultSet,12));
            temblorpolicylistDto.setBuilding(dbManager.getString(resultSet,13));
            temblorpolicylistDto.setFloor(dbManager.getInt(resultSet,14));
            temblorpolicylistDto.setArchitecture(dbManager.getString(resultSet,15));
            temblorpolicylistDto.setRemark(dbManager.getString(resultSet,16));
            temblorpolicylistDto.setArea(dbManager.getDouble(resultSet,17));
            temblorpolicylistDto.setBuildtime(dbManager.getString(resultSet,18));
            temblorpolicylistDto.setRepair(dbManager.getString(resultSet,19));
            temblorpolicylistDto.setRepairtime(dbManager.getString(resultSet,20));
            temblorpolicylistDto.setPropcerttype(dbManager.getString(resultSet,21));
            temblorpolicylistDto.setPropcertno(dbManager.getString(resultSet,22));
            temblorpolicylistDto.setClasscode(dbManager.getString(resultSet,23));
            temblorpolicylistDto.setRiskcode(dbManager.getString(resultSet,24));
            temblorpolicylistDto.setAmount(dbManager.getDouble(resultSet,25));
            temblorpolicylistDto.setRate(dbManager.getDouble(resultSet,26));
            temblorpolicylistDto.setPremium(dbManager.getDouble(resultSet,27));
            temblorpolicylistDto.setShortrateflag(dbManager.getString(resultSet,28));
            temblorpolicylistDto.setShortrate(dbManager.getDouble(resultSet,29));
            temblorpolicylistDto.setSumamount(dbManager.getDouble(resultSet,30));
            temblorpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,31));
            temblorpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            temblorpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            temblorpolicylistDto.setStarttime(dbManager.getString(resultSet,34));
            temblorpolicylistDto.setEndtime(dbManager.getString(resultSet,35));
            temblorpolicylistDto.setCalculateflag(dbManager.getString(resultSet,36));
            temblorpolicylistDto.setOpcode(dbManager.getString(resultSet,37));
            temblorpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,38));
            temblorpolicylistDto.setValidity(dbManager.getString(resultSet,39));
            temblorpolicylistDto.setFpremium(dbManager.getDouble(resultSet,40));
            temblorpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,41));
            temblorpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,42));
            temblorpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,43));
            temblorpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,44));
            temblorpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,45));
            temblorpolicylistDto.setTemp1(dbManager.getString(resultSet,46));
            temblorpolicylistDto.setTemp2(dbManager.getString(resultSet,47));
            temblorpolicylistDto.setTemp3(dbManager.getString(resultSet,48));
            temblorpolicylistDto.setTemp4(dbManager.getString(resultSet,49));
            temblorpolicylistDto.setTemp5(dbManager.getString(resultSet,50));
            temblorpolicylistDto.setCardtype(dbManager.getString(resultSet,51));
            temblorpolicylistDto.setIdcard(dbManager.getString(resultSet,52));
            temblorpolicylistDto.setName(dbManager.getString(resultSet,53));
            temblorpolicylistDto.setRateadjust1(dbManager.getDouble(resultSet,54));
            temblorpolicylistDto.setRateadjust2(dbManager.getDouble(resultSet,55));
        }
        resultSet.close();
        return temblorpolicylistDto;
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
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Countrycode,");
        buffer.append("Citycode,");
        buffer.append("Address,");
        buffer.append("Zipcode,");
        buffer.append("Longitude,");
        buffer.append("Latitude,");
        buffer.append("Itemtype,");
        buffer.append("Building,");
        buffer.append("Floor,");
        buffer.append("Architecture,");
        buffer.append("Remark,");
        buffer.append("Area,");
        buffer.append("Buildtime,");
        buffer.append("Repair,");
        buffer.append("Repairtime,");
        buffer.append("Propcerttype,");
        buffer.append("Propcertno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Amount,");
        buffer.append("Rate,");
        buffer.append("Premium,");
        buffer.append("Shortrateflag,");
        buffer.append("Shortrate,");
        buffer.append("Sumamount,");
        buffer.append("Sumpremium,");
        buffer.append("Startdate,");
        buffer.append("Enddate,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Calculateflag,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Fpremium,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2 ");
        buffer.append("FROM Temblorpolicylist WHERE ");
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
        TemblorpolicylistDto temblorpolicylistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorpolicylistDto = new TemblorpolicylistDto();
            temblorpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorpolicylistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            temblorpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorpolicylistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            temblorpolicylistDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorpolicylistDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorpolicylistDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorpolicylistDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorpolicylistDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorpolicylistDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorpolicylistDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorpolicylistDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorpolicylistDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorpolicylistDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorpolicylistDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorpolicylistDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorpolicylistDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorpolicylistDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorpolicylistDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorpolicylistDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorpolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorpolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            temblorpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            temblorpolicylistDto.setPremium(dbManager.getDouble(resultSet,"Premium"));
            temblorpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            temblorpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            temblorpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            temblorpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            temblorpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            temblorpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            temblorpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            temblorpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            temblorpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            temblorpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorpolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            temblorpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            temblorpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            temblorpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            temblorpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            temblorpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            temblorpolicylistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            temblorpolicylistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            temblorpolicylistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            temblorpolicylistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            temblorpolicylistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            temblorpolicylistDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorpolicylistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorpolicylistDto.setName(dbManager.getString(resultSet,"Name"));
            temblorpolicylistDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            temblorpolicylistDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            collection.add(temblorpolicylistDto);
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
        buffer.append("DELETE FROM Temblorpolicylist WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorpolicylist WHERE ");
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
}
