package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorpolicylistoriginDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORPOLICYLISTORIGIN的数据访问对象基类<br>
 */
public class DBTemblorpolicylistoriginBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorpolicylistoriginBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorpolicylistoriginBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void insert(TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorpolicylistorigin (");
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
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getRiskcode()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getAmount()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getRate()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getPremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getShortrate()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getSumamount()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getStartdate()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getEnddate()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getStarttime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getEndtime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getValidity()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getFpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getCitypremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getTownpremium()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getTemp1()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getTemp2()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getTemp3()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getTemp4()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getTemp5()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorpolicylistoriginDto.getName()).append("',");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(temblorpolicylistoriginDto.getRateadjust2()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorpolicylistoriginDto.getInusrelistcode());
        dbManager.setString(2,temblorpolicylistoriginDto.getBusinessno());
        dbManager.setString(3,temblorpolicylistoriginDto.getKindcode());
        dbManager.setString(4,temblorpolicylistoriginDto.getItemcode());
        dbManager.setString(5,temblorpolicylistoriginDto.getIndexcode());
        dbManager.setString(6,temblorpolicylistoriginDto.getCountrycode());
        dbManager.setString(7,temblorpolicylistoriginDto.getCitycode());
        dbManager.setString(8,temblorpolicylistoriginDto.getAddress());
        dbManager.setString(9,temblorpolicylistoriginDto.getZipcode());
        dbManager.setDouble(10,temblorpolicylistoriginDto.getLongitude());
        dbManager.setDouble(11,temblorpolicylistoriginDto.getLatitude());
        dbManager.setString(12,temblorpolicylistoriginDto.getItemtype());
        dbManager.setString(13,temblorpolicylistoriginDto.getBuilding());
        dbManager.setInt(14,temblorpolicylistoriginDto.getFloor());
        dbManager.setString(15,temblorpolicylistoriginDto.getArchitecture());
        dbManager.setString(16,temblorpolicylistoriginDto.getRemark());
        dbManager.setDouble(17,temblorpolicylistoriginDto.getArea());
        dbManager.setString(18,temblorpolicylistoriginDto.getBuildtime());
        dbManager.setString(19,temblorpolicylistoriginDto.getRepair());
        dbManager.setString(20,temblorpolicylistoriginDto.getRepairtime());
        dbManager.setString(21,temblorpolicylistoriginDto.getPropcerttype());
        dbManager.setString(22,temblorpolicylistoriginDto.getPropcertno());
        dbManager.setString(23,temblorpolicylistoriginDto.getClasscode());
        dbManager.setString(24,temblorpolicylistoriginDto.getRiskcode());
        dbManager.setDouble(25,temblorpolicylistoriginDto.getAmount());
        dbManager.setDouble(26,temblorpolicylistoriginDto.getRate());
        dbManager.setDouble(27,temblorpolicylistoriginDto.getPremium());
        dbManager.setString(28,temblorpolicylistoriginDto.getShortrateflag());
        dbManager.setDouble(29,temblorpolicylistoriginDto.getShortrate());
        dbManager.setDouble(30,temblorpolicylistoriginDto.getSumamount());
        dbManager.setDouble(31,temblorpolicylistoriginDto.getSumpremium());
        dbManager.setDateTime(32,temblorpolicylistoriginDto.getStartdate());
        dbManager.setDateTime(33,temblorpolicylistoriginDto.getEnddate());
        dbManager.setString(34,temblorpolicylistoriginDto.getStarttime());
        dbManager.setString(35,temblorpolicylistoriginDto.getEndtime());
        dbManager.setString(36,temblorpolicylistoriginDto.getCalculateflag());
        dbManager.setString(37,temblorpolicylistoriginDto.getOpcode());
        dbManager.setDateTime(38,temblorpolicylistoriginDto.getOptime());
        dbManager.setString(39,temblorpolicylistoriginDto.getValidity());
        dbManager.setDouble(40,temblorpolicylistoriginDto.getFpremium());
        dbManager.setDouble(41,temblorpolicylistoriginDto.getCentralpremium());
        dbManager.setDouble(42,temblorpolicylistoriginDto.getProvincepremium());
        dbManager.setDouble(43,temblorpolicylistoriginDto.getCitypremium());
        dbManager.setDouble(44,temblorpolicylistoriginDto.getTownpremium());
        dbManager.setDouble(45,temblorpolicylistoriginDto.getOtherpremium());
        dbManager.setString(46,temblorpolicylistoriginDto.getTemp1());
        dbManager.setString(47,temblorpolicylistoriginDto.getTemp2());
        dbManager.setString(48,temblorpolicylistoriginDto.getTemp3());
        dbManager.setString(49,temblorpolicylistoriginDto.getTemp4());
        dbManager.setString(50,temblorpolicylistoriginDto.getTemp5());
        dbManager.setString(51,temblorpolicylistoriginDto.getCardtype());
        dbManager.setString(52,temblorpolicylistoriginDto.getIdcard());
        dbManager.setString(53,temblorpolicylistoriginDto.getName());
        dbManager.setDouble(54,temblorpolicylistoriginDto.getRateadjust1());
        dbManager.setDouble(55,temblorpolicylistoriginDto.getRateadjust2());
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
        buffer.append("INSERT INTO Temblorpolicylistorigin (");
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
            TemblorpolicylistoriginDto temblorpolicylistoriginDto = (TemblorpolicylistoriginDto)i.next();
            dbManager.setString(1,temblorpolicylistoriginDto.getInusrelistcode());
            dbManager.setString(2,temblorpolicylistoriginDto.getBusinessno());
            dbManager.setString(3,temblorpolicylistoriginDto.getKindcode());
            dbManager.setString(4,temblorpolicylistoriginDto.getItemcode());
            dbManager.setString(5,temblorpolicylistoriginDto.getIndexcode());
            dbManager.setString(6,temblorpolicylistoriginDto.getCountrycode());
            dbManager.setString(7,temblorpolicylistoriginDto.getCitycode());
            dbManager.setString(8,temblorpolicylistoriginDto.getAddress());
            dbManager.setString(9,temblorpolicylistoriginDto.getZipcode());
            dbManager.setDouble(10,temblorpolicylistoriginDto.getLongitude());
            dbManager.setDouble(11,temblorpolicylistoriginDto.getLatitude());
            dbManager.setString(12,temblorpolicylistoriginDto.getItemtype());
            dbManager.setString(13,temblorpolicylistoriginDto.getBuilding());
            dbManager.setInt(14,temblorpolicylistoriginDto.getFloor());
            dbManager.setString(15,temblorpolicylistoriginDto.getArchitecture());
            dbManager.setString(16,temblorpolicylistoriginDto.getRemark());
            dbManager.setDouble(17,temblorpolicylistoriginDto.getArea());
            dbManager.setString(18,temblorpolicylistoriginDto.getBuildtime());
            dbManager.setString(19,temblorpolicylistoriginDto.getRepair());
            dbManager.setString(20,temblorpolicylistoriginDto.getRepairtime());
            dbManager.setString(21,temblorpolicylistoriginDto.getPropcerttype());
            dbManager.setString(22,temblorpolicylistoriginDto.getPropcertno());
            dbManager.setString(23,temblorpolicylistoriginDto.getClasscode());
            dbManager.setString(24,temblorpolicylistoriginDto.getRiskcode());
            dbManager.setDouble(25,temblorpolicylistoriginDto.getAmount());
            dbManager.setDouble(26,temblorpolicylistoriginDto.getRate());
            dbManager.setDouble(27,temblorpolicylistoriginDto.getPremium());
            dbManager.setString(28,temblorpolicylistoriginDto.getShortrateflag());
            dbManager.setDouble(29,temblorpolicylistoriginDto.getShortrate());
            dbManager.setDouble(30,temblorpolicylistoriginDto.getSumamount());
            dbManager.setDouble(31,temblorpolicylistoriginDto.getSumpremium());
            dbManager.setDateTime(32,temblorpolicylistoriginDto.getStartdate());
            dbManager.setDateTime(33,temblorpolicylistoriginDto.getEnddate());
            dbManager.setString(34,temblorpolicylistoriginDto.getStarttime());
            dbManager.setString(35,temblorpolicylistoriginDto.getEndtime());
            dbManager.setString(36,temblorpolicylistoriginDto.getCalculateflag());
            dbManager.setString(37,temblorpolicylistoriginDto.getOpcode());
            dbManager.setDateTime(38,temblorpolicylistoriginDto.getOptime());
            dbManager.setString(39,temblorpolicylistoriginDto.getValidity());
            dbManager.setDouble(40,temblorpolicylistoriginDto.getFpremium());
            dbManager.setDouble(41,temblorpolicylistoriginDto.getCentralpremium());
            dbManager.setDouble(42,temblorpolicylistoriginDto.getProvincepremium());
            dbManager.setDouble(43,temblorpolicylistoriginDto.getCitypremium());
            dbManager.setDouble(44,temblorpolicylistoriginDto.getTownpremium());
            dbManager.setDouble(45,temblorpolicylistoriginDto.getOtherpremium());
            dbManager.setString(46,temblorpolicylistoriginDto.getTemp1());
            dbManager.setString(47,temblorpolicylistoriginDto.getTemp2());
            dbManager.setString(48,temblorpolicylistoriginDto.getTemp3());
            dbManager.setString(49,temblorpolicylistoriginDto.getTemp4());
            dbManager.setString(50,temblorpolicylistoriginDto.getTemp5());
            dbManager.setString(51,temblorpolicylistoriginDto.getCardtype());
            dbManager.setString(52,temblorpolicylistoriginDto.getIdcard());
            dbManager.setString(53,temblorpolicylistoriginDto.getName());
            dbManager.setDouble(54,temblorpolicylistoriginDto.getRateadjust1());
            dbManager.setDouble(55,temblorpolicylistoriginDto.getRateadjust2());
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
        buffer.append("DELETE FROM Temblorpolicylistorigin ");
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
     * @param temblorpolicylistoriginDto temblorpolicylistoriginDto
     * @throws Exception
     */
    public void update(TemblorpolicylistoriginDto temblorpolicylistoriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorpolicylistorigin SET ");
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
            debugBuffer.append("UPDATE Temblorpolicylistorigin SET ");
            debugBuffer.append("Businessno = '" + temblorpolicylistoriginDto.getBusinessno() + "', ");
            debugBuffer.append("Indexcode = '" + temblorpolicylistoriginDto.getIndexcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorpolicylistoriginDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorpolicylistoriginDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + temblorpolicylistoriginDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorpolicylistoriginDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorpolicylistoriginDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorpolicylistoriginDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorpolicylistoriginDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorpolicylistoriginDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorpolicylistoriginDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorpolicylistoriginDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorpolicylistoriginDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorpolicylistoriginDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorpolicylistoriginDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorpolicylistoriginDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorpolicylistoriginDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorpolicylistoriginDto.getPropcertno() + "', ");
            debugBuffer.append("Classcode = '" + temblorpolicylistoriginDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorpolicylistoriginDto.getRiskcode() + "', ");
            debugBuffer.append("Amount = " + temblorpolicylistoriginDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + temblorpolicylistoriginDto.getRate() + ", ");
            debugBuffer.append("Premium = " + temblorpolicylistoriginDto.getPremium() + ", ");
            debugBuffer.append("Shortrateflag = '" + temblorpolicylistoriginDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + temblorpolicylistoriginDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + temblorpolicylistoriginDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + temblorpolicylistoriginDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + temblorpolicylistoriginDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + temblorpolicylistoriginDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + temblorpolicylistoriginDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + temblorpolicylistoriginDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + temblorpolicylistoriginDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + temblorpolicylistoriginDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorpolicylistoriginDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorpolicylistoriginDto.getValidity() + "', ");
            debugBuffer.append("Fpremium = " + temblorpolicylistoriginDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + temblorpolicylistoriginDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + temblorpolicylistoriginDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + temblorpolicylistoriginDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + temblorpolicylistoriginDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + temblorpolicylistoriginDto.getOtherpremium() + ", ");
            debugBuffer.append("Temp1 = '" + temblorpolicylistoriginDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + temblorpolicylistoriginDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + temblorpolicylistoriginDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + temblorpolicylistoriginDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + temblorpolicylistoriginDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + temblorpolicylistoriginDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + temblorpolicylistoriginDto.getName() + "', ");
            debugBuffer.append("Rateadjust1 = " + temblorpolicylistoriginDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + temblorpolicylistoriginDto.getRateadjust2() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(temblorpolicylistoriginDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorpolicylistoriginDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorpolicylistoriginDto.getItemcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(temblorpolicylistoriginDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(temblorpolicylistoriginDto.getIdcard()).append("'");
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
        dbManager.setString(1,temblorpolicylistoriginDto.getBusinessno());
        dbManager.setString(2,temblorpolicylistoriginDto.getIndexcode());
        dbManager.setString(3,temblorpolicylistoriginDto.getCountrycode());
        dbManager.setString(4,temblorpolicylistoriginDto.getCitycode());
        dbManager.setString(5,temblorpolicylistoriginDto.getZipcode());
        dbManager.setDouble(6,temblorpolicylistoriginDto.getLongitude());
        dbManager.setDouble(7,temblorpolicylistoriginDto.getLatitude());
        dbManager.setString(8,temblorpolicylistoriginDto.getItemtype());
        dbManager.setString(9,temblorpolicylistoriginDto.getBuilding());
        dbManager.setInt(10,temblorpolicylistoriginDto.getFloor());
        dbManager.setString(11,temblorpolicylistoriginDto.getArchitecture());
        dbManager.setString(12,temblorpolicylistoriginDto.getRemark());
        dbManager.setDouble(13,temblorpolicylistoriginDto.getArea());
        dbManager.setString(14,temblorpolicylistoriginDto.getBuildtime());
        dbManager.setString(15,temblorpolicylistoriginDto.getRepair());
        dbManager.setString(16,temblorpolicylistoriginDto.getRepairtime());
        dbManager.setString(17,temblorpolicylistoriginDto.getPropcerttype());
        dbManager.setString(18,temblorpolicylistoriginDto.getPropcertno());
        dbManager.setString(19,temblorpolicylistoriginDto.getClasscode());
        dbManager.setString(20,temblorpolicylistoriginDto.getRiskcode());
        dbManager.setDouble(21,temblorpolicylistoriginDto.getAmount());
        dbManager.setDouble(22,temblorpolicylistoriginDto.getRate());
        dbManager.setDouble(23,temblorpolicylistoriginDto.getPremium());
        dbManager.setString(24,temblorpolicylistoriginDto.getShortrateflag());
        dbManager.setDouble(25,temblorpolicylistoriginDto.getShortrate());
        dbManager.setDouble(26,temblorpolicylistoriginDto.getSumamount());
        dbManager.setDouble(27,temblorpolicylistoriginDto.getSumpremium());
        dbManager.setDateTime(28,temblorpolicylistoriginDto.getStartdate());
        dbManager.setDateTime(29,temblorpolicylistoriginDto.getEnddate());
        dbManager.setString(30,temblorpolicylistoriginDto.getStarttime());
        dbManager.setString(31,temblorpolicylistoriginDto.getEndtime());
        dbManager.setString(32,temblorpolicylistoriginDto.getCalculateflag());
        dbManager.setString(33,temblorpolicylistoriginDto.getOpcode());
        dbManager.setDateTime(34,temblorpolicylistoriginDto.getOptime());
        dbManager.setString(35,temblorpolicylistoriginDto.getValidity());
        dbManager.setDouble(36,temblorpolicylistoriginDto.getFpremium());
        dbManager.setDouble(37,temblorpolicylistoriginDto.getCentralpremium());
        dbManager.setDouble(38,temblorpolicylistoriginDto.getProvincepremium());
        dbManager.setDouble(39,temblorpolicylistoriginDto.getCitypremium());
        dbManager.setDouble(40,temblorpolicylistoriginDto.getTownpremium());
        dbManager.setDouble(41,temblorpolicylistoriginDto.getOtherpremium());
        dbManager.setString(42,temblorpolicylistoriginDto.getTemp1());
        dbManager.setString(43,temblorpolicylistoriginDto.getTemp2());
        dbManager.setString(44,temblorpolicylistoriginDto.getTemp3());
        dbManager.setString(45,temblorpolicylistoriginDto.getTemp4());
        dbManager.setString(46,temblorpolicylistoriginDto.getTemp5());
        dbManager.setString(47,temblorpolicylistoriginDto.getCardtype());
        dbManager.setString(48,temblorpolicylistoriginDto.getName());
        dbManager.setDouble(49,temblorpolicylistoriginDto.getRateadjust1());
        dbManager.setDouble(50,temblorpolicylistoriginDto.getRateadjust2());
        //设置条件字段;
        dbManager.setString(51,temblorpolicylistoriginDto.getInusrelistcode());
        dbManager.setString(52,temblorpolicylistoriginDto.getKindcode());
        dbManager.setString(53,temblorpolicylistoriginDto.getItemcode());
        dbManager.setString(54,temblorpolicylistoriginDto.getAddress());
        dbManager.setString(55,temblorpolicylistoriginDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TemblorpolicylistoriginDto
     * @throws Exception
     */
    public TemblorpolicylistoriginDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
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
        buffer.append("FROM Temblorpolicylistorigin ");
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
        TemblorpolicylistoriginDto temblorpolicylistoriginDto = null;
        if(resultSet.next()){
            temblorpolicylistoriginDto = new TemblorpolicylistoriginDto();
            temblorpolicylistoriginDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorpolicylistoriginDto.setBusinessno(dbManager.getString(resultSet,2));
            temblorpolicylistoriginDto.setKindcode(dbManager.getString(resultSet,3));
            temblorpolicylistoriginDto.setItemcode(dbManager.getString(resultSet,4));
            temblorpolicylistoriginDto.setIndexcode(dbManager.getString(resultSet,5));
            temblorpolicylistoriginDto.setCountrycode(dbManager.getString(resultSet,6));
            temblorpolicylistoriginDto.setCitycode(dbManager.getString(resultSet,7));
            temblorpolicylistoriginDto.setAddress(dbManager.getString(resultSet,8));
            temblorpolicylistoriginDto.setZipcode(dbManager.getString(resultSet,9));
            temblorpolicylistoriginDto.setLongitude(dbManager.getDouble(resultSet,10));
            temblorpolicylistoriginDto.setLatitude(dbManager.getDouble(resultSet,11));
            temblorpolicylistoriginDto.setItemtype(dbManager.getString(resultSet,12));
            temblorpolicylistoriginDto.setBuilding(dbManager.getString(resultSet,13));
            temblorpolicylistoriginDto.setFloor(dbManager.getInt(resultSet,14));
            temblorpolicylistoriginDto.setArchitecture(dbManager.getString(resultSet,15));
            temblorpolicylistoriginDto.setRemark(dbManager.getString(resultSet,16));
            temblorpolicylistoriginDto.setArea(dbManager.getDouble(resultSet,17));
            temblorpolicylistoriginDto.setBuildtime(dbManager.getString(resultSet,18));
            temblorpolicylistoriginDto.setRepair(dbManager.getString(resultSet,19));
            temblorpolicylistoriginDto.setRepairtime(dbManager.getString(resultSet,20));
            temblorpolicylistoriginDto.setPropcerttype(dbManager.getString(resultSet,21));
            temblorpolicylistoriginDto.setPropcertno(dbManager.getString(resultSet,22));
            temblorpolicylistoriginDto.setClasscode(dbManager.getString(resultSet,23));
            temblorpolicylistoriginDto.setRiskcode(dbManager.getString(resultSet,24));
            temblorpolicylistoriginDto.setAmount(dbManager.getDouble(resultSet,25));
            temblorpolicylistoriginDto.setRate(dbManager.getDouble(resultSet,26));
            temblorpolicylistoriginDto.setPremium(dbManager.getDouble(resultSet,27));
            temblorpolicylistoriginDto.setShortrateflag(dbManager.getString(resultSet,28));
            temblorpolicylistoriginDto.setShortrate(dbManager.getDouble(resultSet,29));
            temblorpolicylistoriginDto.setSumamount(dbManager.getDouble(resultSet,30));
            temblorpolicylistoriginDto.setSumpremium(dbManager.getDouble(resultSet,31));
            temblorpolicylistoriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            temblorpolicylistoriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            temblorpolicylistoriginDto.setStarttime(dbManager.getString(resultSet,34));
            temblorpolicylistoriginDto.setEndtime(dbManager.getString(resultSet,35));
            temblorpolicylistoriginDto.setCalculateflag(dbManager.getString(resultSet,36));
            temblorpolicylistoriginDto.setOpcode(dbManager.getString(resultSet,37));
            temblorpolicylistoriginDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,38));
            temblorpolicylistoriginDto.setValidity(dbManager.getString(resultSet,39));
            temblorpolicylistoriginDto.setFpremium(dbManager.getDouble(resultSet,40));
            temblorpolicylistoriginDto.setCentralpremium(dbManager.getDouble(resultSet,41));
            temblorpolicylistoriginDto.setProvincepremium(dbManager.getDouble(resultSet,42));
            temblorpolicylistoriginDto.setCitypremium(dbManager.getDouble(resultSet,43));
            temblorpolicylistoriginDto.setTownpremium(dbManager.getDouble(resultSet,44));
            temblorpolicylistoriginDto.setOtherpremium(dbManager.getDouble(resultSet,45));
            temblorpolicylistoriginDto.setTemp1(dbManager.getString(resultSet,46));
            temblorpolicylistoriginDto.setTemp2(dbManager.getString(resultSet,47));
            temblorpolicylistoriginDto.setTemp3(dbManager.getString(resultSet,48));
            temblorpolicylistoriginDto.setTemp4(dbManager.getString(resultSet,49));
            temblorpolicylistoriginDto.setTemp5(dbManager.getString(resultSet,50));
            temblorpolicylistoriginDto.setCardtype(dbManager.getString(resultSet,51));
            temblorpolicylistoriginDto.setIdcard(dbManager.getString(resultSet,52));
            temblorpolicylistoriginDto.setName(dbManager.getString(resultSet,53));
            temblorpolicylistoriginDto.setRateadjust1(dbManager.getDouble(resultSet,54));
            temblorpolicylistoriginDto.setRateadjust2(dbManager.getDouble(resultSet,55));
        }
        resultSet.close();
        return temblorpolicylistoriginDto;
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
        buffer.append("FROM Temblorpolicylistorigin WHERE ");
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
        TemblorpolicylistoriginDto temblorpolicylistoriginDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorpolicylistoriginDto = new TemblorpolicylistoriginDto();
            temblorpolicylistoriginDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorpolicylistoriginDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            temblorpolicylistoriginDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorpolicylistoriginDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorpolicylistoriginDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            temblorpolicylistoriginDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorpolicylistoriginDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorpolicylistoriginDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorpolicylistoriginDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorpolicylistoriginDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorpolicylistoriginDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorpolicylistoriginDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorpolicylistoriginDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorpolicylistoriginDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorpolicylistoriginDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorpolicylistoriginDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorpolicylistoriginDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorpolicylistoriginDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorpolicylistoriginDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorpolicylistoriginDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorpolicylistoriginDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorpolicylistoriginDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorpolicylistoriginDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorpolicylistoriginDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorpolicylistoriginDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            temblorpolicylistoriginDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            temblorpolicylistoriginDto.setPremium(dbManager.getDouble(resultSet,"Premium"));
            temblorpolicylistoriginDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            temblorpolicylistoriginDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            temblorpolicylistoriginDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            temblorpolicylistoriginDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            temblorpolicylistoriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            temblorpolicylistoriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            temblorpolicylistoriginDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            temblorpolicylistoriginDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            temblorpolicylistoriginDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            temblorpolicylistoriginDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorpolicylistoriginDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorpolicylistoriginDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorpolicylistoriginDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            temblorpolicylistoriginDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            temblorpolicylistoriginDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            temblorpolicylistoriginDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            temblorpolicylistoriginDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            temblorpolicylistoriginDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            temblorpolicylistoriginDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            temblorpolicylistoriginDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            temblorpolicylistoriginDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            temblorpolicylistoriginDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            temblorpolicylistoriginDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            temblorpolicylistoriginDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorpolicylistoriginDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorpolicylistoriginDto.setName(dbManager.getString(resultSet,"Name"));
            temblorpolicylistoriginDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            temblorpolicylistoriginDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            collection.add(temblorpolicylistoriginDto);
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
        buffer.append("DELETE FROM Temblorpolicylistorigin WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorpolicylistorigin WHERE ");
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
