package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorinsurancelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORINSURANCELIST的数据访问对象基类<br>
 */
public class DBTemblorinsurancelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorinsurancelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorinsurancelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorinsurancelistDto temblorinsurancelistDto
     * @throws Exception
     */
    public void insert(TemblorinsurancelistDto temblorinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorinsurancelist (");
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
            debugBuffer.append("'").append(temblorinsurancelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getRiskcode()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getAmount()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getRate()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getPremium()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getShortrate()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getSumamount()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getEndtime()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getValidity()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getFpremium()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(temblorinsurancelistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getTemp5()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorinsurancelistDto.getName()).append("',");
            debugBuffer.append("").append(temblorinsurancelistDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(temblorinsurancelistDto.getRateadjust2()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorinsurancelistDto.getInusrelistcode());
        dbManager.setString(2,temblorinsurancelistDto.getBusinessno());
        dbManager.setString(3,temblorinsurancelistDto.getKindcode());
        dbManager.setString(4,temblorinsurancelistDto.getItemcode());
        dbManager.setString(5,temblorinsurancelistDto.getIndexcode());
        dbManager.setString(6,temblorinsurancelistDto.getCountrycode());
        dbManager.setString(7,temblorinsurancelistDto.getCitycode());
        dbManager.setString(8,temblorinsurancelistDto.getAddress());
        dbManager.setString(9,temblorinsurancelistDto.getZipcode());
        dbManager.setDouble(10,temblorinsurancelistDto.getLongitude());
        dbManager.setDouble(11,temblorinsurancelistDto.getLatitude());
        dbManager.setString(12,temblorinsurancelistDto.getItemtype());
        dbManager.setString(13,temblorinsurancelistDto.getBuilding());
        dbManager.setInt(14,temblorinsurancelistDto.getFloor());
        dbManager.setString(15,temblorinsurancelistDto.getArchitecture());
        dbManager.setString(16,temblorinsurancelistDto.getRemark());
        dbManager.setDouble(17,temblorinsurancelistDto.getArea());
        dbManager.setString(18,temblorinsurancelistDto.getBuildtime());
        dbManager.setString(19,temblorinsurancelistDto.getRepair());
        dbManager.setString(20,temblorinsurancelistDto.getRepairtime());
        dbManager.setString(21,temblorinsurancelistDto.getPropcerttype());
        dbManager.setString(22,temblorinsurancelistDto.getPropcertno());
        dbManager.setString(23,temblorinsurancelistDto.getClasscode());
        dbManager.setString(24,temblorinsurancelistDto.getRiskcode());
        dbManager.setDouble(25,temblorinsurancelistDto.getAmount());
        dbManager.setDouble(26,temblorinsurancelistDto.getRate());
        dbManager.setDouble(27,temblorinsurancelistDto.getPremium());
        dbManager.setString(28,temblorinsurancelistDto.getShortrateflag());
        dbManager.setDouble(29,temblorinsurancelistDto.getShortrate());
        dbManager.setDouble(30,temblorinsurancelistDto.getSumamount());
        dbManager.setDouble(31,temblorinsurancelistDto.getSumpremium());
        dbManager.setDateTime(32,temblorinsurancelistDto.getStartdate());
        dbManager.setDateTime(33,temblorinsurancelistDto.getEnddate());
        dbManager.setString(34,temblorinsurancelistDto.getStarttime());
        dbManager.setString(35,temblorinsurancelistDto.getEndtime());
        dbManager.setString(36,temblorinsurancelistDto.getCalculateflag());
        dbManager.setString(37,temblorinsurancelistDto.getOpcode());
        dbManager.setDateTime(38,temblorinsurancelistDto.getOptime());
        dbManager.setString(39,temblorinsurancelistDto.getValidity());
        dbManager.setDouble(40,temblorinsurancelistDto.getFpremium());
        dbManager.setDouble(41,temblorinsurancelistDto.getCentralpremium());
        dbManager.setDouble(42,temblorinsurancelistDto.getProvincepremium());
        dbManager.setDouble(43,temblorinsurancelistDto.getCitypremium());
        dbManager.setDouble(44,temblorinsurancelistDto.getTownpremium());
        dbManager.setDouble(45,temblorinsurancelistDto.getOtherpremium());
        dbManager.setString(46,temblorinsurancelistDto.getTemp1());
        dbManager.setString(47,temblorinsurancelistDto.getTemp2());
        dbManager.setString(48,temblorinsurancelistDto.getTemp3());
        dbManager.setString(49,temblorinsurancelistDto.getTemp4());
        dbManager.setString(50,temblorinsurancelistDto.getTemp5());
        dbManager.setString(51,temblorinsurancelistDto.getCardtype());
        dbManager.setString(52,temblorinsurancelistDto.getIdcard());
        dbManager.setString(53,temblorinsurancelistDto.getName());
        dbManager.setDouble(54,temblorinsurancelistDto.getRateadjust1());
        dbManager.setDouble(55,temblorinsurancelistDto.getRateadjust2());
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
        buffer.append("INSERT INTO Temblorinsurancelist (");
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
            TemblorinsurancelistDto temblorinsurancelistDto = (TemblorinsurancelistDto)i.next();
            dbManager.setString(1,temblorinsurancelistDto.getInusrelistcode());
            dbManager.setString(2,temblorinsurancelistDto.getBusinessno());
            dbManager.setString(3,temblorinsurancelistDto.getKindcode());
            dbManager.setString(4,temblorinsurancelistDto.getItemcode());
            dbManager.setString(5,temblorinsurancelistDto.getIndexcode());
            dbManager.setString(6,temblorinsurancelistDto.getCountrycode());
            dbManager.setString(7,temblorinsurancelistDto.getCitycode());
            dbManager.setString(8,temblorinsurancelistDto.getAddress());
            dbManager.setString(9,temblorinsurancelistDto.getZipcode());
            dbManager.setDouble(10,temblorinsurancelistDto.getLongitude());
            dbManager.setDouble(11,temblorinsurancelistDto.getLatitude());
            dbManager.setString(12,temblorinsurancelistDto.getItemtype());
            dbManager.setString(13,temblorinsurancelistDto.getBuilding());
            dbManager.setInt(14,temblorinsurancelistDto.getFloor());
            dbManager.setString(15,temblorinsurancelistDto.getArchitecture());
            dbManager.setString(16,temblorinsurancelistDto.getRemark());
            dbManager.setDouble(17,temblorinsurancelistDto.getArea());
            dbManager.setString(18,temblorinsurancelistDto.getBuildtime());
            dbManager.setString(19,temblorinsurancelistDto.getRepair());
            dbManager.setString(20,temblorinsurancelistDto.getRepairtime());
            dbManager.setString(21,temblorinsurancelistDto.getPropcerttype());
            dbManager.setString(22,temblorinsurancelistDto.getPropcertno());
            dbManager.setString(23,temblorinsurancelistDto.getClasscode());
            dbManager.setString(24,temblorinsurancelistDto.getRiskcode());
            dbManager.setDouble(25,temblorinsurancelistDto.getAmount());
            dbManager.setDouble(26,temblorinsurancelistDto.getRate());
            dbManager.setDouble(27,temblorinsurancelistDto.getPremium());
            dbManager.setString(28,temblorinsurancelistDto.getShortrateflag());
            dbManager.setDouble(29,temblorinsurancelistDto.getShortrate());
            dbManager.setDouble(30,temblorinsurancelistDto.getSumamount());
            dbManager.setDouble(31,temblorinsurancelistDto.getSumpremium());
            dbManager.setDateTime(32,temblorinsurancelistDto.getStartdate());
            dbManager.setDateTime(33,temblorinsurancelistDto.getEnddate());
            dbManager.setString(34,temblorinsurancelistDto.getStarttime());
            dbManager.setString(35,temblorinsurancelistDto.getEndtime());
            dbManager.setString(36,temblorinsurancelistDto.getCalculateflag());
            dbManager.setString(37,temblorinsurancelistDto.getOpcode());
            dbManager.setDateTime(38,temblorinsurancelistDto.getOptime());
            dbManager.setString(39,temblorinsurancelistDto.getValidity());
            dbManager.setDouble(40,temblorinsurancelistDto.getFpremium());
            dbManager.setDouble(41,temblorinsurancelistDto.getCentralpremium());
            dbManager.setDouble(42,temblorinsurancelistDto.getProvincepremium());
            dbManager.setDouble(43,temblorinsurancelistDto.getCitypremium());
            dbManager.setDouble(44,temblorinsurancelistDto.getTownpremium());
            dbManager.setDouble(45,temblorinsurancelistDto.getOtherpremium());
            dbManager.setString(46,temblorinsurancelistDto.getTemp1());
            dbManager.setString(47,temblorinsurancelistDto.getTemp2());
            dbManager.setString(48,temblorinsurancelistDto.getTemp3());
            dbManager.setString(49,temblorinsurancelistDto.getTemp4());
            dbManager.setString(50,temblorinsurancelistDto.getTemp5());
            dbManager.setString(51,temblorinsurancelistDto.getCardtype());
            dbManager.setString(52,temblorinsurancelistDto.getIdcard());
            dbManager.setString(53,temblorinsurancelistDto.getName());
            dbManager.setDouble(54,temblorinsurancelistDto.getRateadjust1());
            dbManager.setDouble(55,temblorinsurancelistDto.getRateadjust2());
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
        buffer.append("DELETE FROM Temblorinsurancelist ");
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
     * @param temblorinsurancelistDto temblorinsurancelistDto
     * @throws Exception
     */
    public void update(TemblorinsurancelistDto temblorinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorinsurancelist SET ");
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
            debugBuffer.append("UPDATE Temblorinsurancelist SET ");
            debugBuffer.append("Businessno = '" + temblorinsurancelistDto.getBusinessno() + "', ");
            debugBuffer.append("Indexcode = '" + temblorinsurancelistDto.getIndexcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorinsurancelistDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorinsurancelistDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + temblorinsurancelistDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorinsurancelistDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorinsurancelistDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorinsurancelistDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorinsurancelistDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorinsurancelistDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorinsurancelistDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorinsurancelistDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorinsurancelistDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorinsurancelistDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorinsurancelistDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorinsurancelistDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorinsurancelistDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorinsurancelistDto.getPropcertno() + "', ");
            debugBuffer.append("Classcode = '" + temblorinsurancelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorinsurancelistDto.getRiskcode() + "', ");
            debugBuffer.append("Amount = " + temblorinsurancelistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + temblorinsurancelistDto.getRate() + ", ");
            debugBuffer.append("Premium = " + temblorinsurancelistDto.getPremium() + ", ");
            debugBuffer.append("Shortrateflag = '" + temblorinsurancelistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + temblorinsurancelistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + temblorinsurancelistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + temblorinsurancelistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + temblorinsurancelistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + temblorinsurancelistDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + temblorinsurancelistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + temblorinsurancelistDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + temblorinsurancelistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + temblorinsurancelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorinsurancelistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorinsurancelistDto.getValidity() + "', ");
            debugBuffer.append("Fpremium = " + temblorinsurancelistDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + temblorinsurancelistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + temblorinsurancelistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + temblorinsurancelistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + temblorinsurancelistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + temblorinsurancelistDto.getOtherpremium() + ", ");
            debugBuffer.append("Temp1 = '" + temblorinsurancelistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + temblorinsurancelistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + temblorinsurancelistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + temblorinsurancelistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + temblorinsurancelistDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + temblorinsurancelistDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + temblorinsurancelistDto.getName() + "', ");
            debugBuffer.append("Rateadjust1 = " + temblorinsurancelistDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + temblorinsurancelistDto.getRateadjust2() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(temblorinsurancelistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorinsurancelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorinsurancelistDto.getItemcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(temblorinsurancelistDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(temblorinsurancelistDto.getIdcard()).append("'");
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
        dbManager.setString(1,temblorinsurancelistDto.getBusinessno());
        dbManager.setString(2,temblorinsurancelistDto.getIndexcode());
        dbManager.setString(3,temblorinsurancelistDto.getCountrycode());
        dbManager.setString(4,temblorinsurancelistDto.getCitycode());
        dbManager.setString(5,temblorinsurancelistDto.getZipcode());
        dbManager.setDouble(6,temblorinsurancelistDto.getLongitude());
        dbManager.setDouble(7,temblorinsurancelistDto.getLatitude());
        dbManager.setString(8,temblorinsurancelistDto.getItemtype());
        dbManager.setString(9,temblorinsurancelistDto.getBuilding());
        dbManager.setInt(10,temblorinsurancelistDto.getFloor());
        dbManager.setString(11,temblorinsurancelistDto.getArchitecture());
        dbManager.setString(12,temblorinsurancelistDto.getRemark());
        dbManager.setDouble(13,temblorinsurancelistDto.getArea());
        dbManager.setString(14,temblorinsurancelistDto.getBuildtime());
        dbManager.setString(15,temblorinsurancelistDto.getRepair());
        dbManager.setString(16,temblorinsurancelistDto.getRepairtime());
        dbManager.setString(17,temblorinsurancelistDto.getPropcerttype());
        dbManager.setString(18,temblorinsurancelistDto.getPropcertno());
        dbManager.setString(19,temblorinsurancelistDto.getClasscode());
        dbManager.setString(20,temblorinsurancelistDto.getRiskcode());
        dbManager.setDouble(21,temblorinsurancelistDto.getAmount());
        dbManager.setDouble(22,temblorinsurancelistDto.getRate());
        dbManager.setDouble(23,temblorinsurancelistDto.getPremium());
        dbManager.setString(24,temblorinsurancelistDto.getShortrateflag());
        dbManager.setDouble(25,temblorinsurancelistDto.getShortrate());
        dbManager.setDouble(26,temblorinsurancelistDto.getSumamount());
        dbManager.setDouble(27,temblorinsurancelistDto.getSumpremium());
        dbManager.setDateTime(28,temblorinsurancelistDto.getStartdate());
        dbManager.setDateTime(29,temblorinsurancelistDto.getEnddate());
        dbManager.setString(30,temblorinsurancelistDto.getStarttime());
        dbManager.setString(31,temblorinsurancelistDto.getEndtime());
        dbManager.setString(32,temblorinsurancelistDto.getCalculateflag());
        dbManager.setString(33,temblorinsurancelistDto.getOpcode());
        dbManager.setDateTime(34,temblorinsurancelistDto.getOptime());
        dbManager.setString(35,temblorinsurancelistDto.getValidity());
        dbManager.setDouble(36,temblorinsurancelistDto.getFpremium());
        dbManager.setDouble(37,temblorinsurancelistDto.getCentralpremium());
        dbManager.setDouble(38,temblorinsurancelistDto.getProvincepremium());
        dbManager.setDouble(39,temblorinsurancelistDto.getCitypremium());
        dbManager.setDouble(40,temblorinsurancelistDto.getTownpremium());
        dbManager.setDouble(41,temblorinsurancelistDto.getOtherpremium());
        dbManager.setString(42,temblorinsurancelistDto.getTemp1());
        dbManager.setString(43,temblorinsurancelistDto.getTemp2());
        dbManager.setString(44,temblorinsurancelistDto.getTemp3());
        dbManager.setString(45,temblorinsurancelistDto.getTemp4());
        dbManager.setString(46,temblorinsurancelistDto.getTemp5());
        dbManager.setString(47,temblorinsurancelistDto.getCardtype());
        dbManager.setString(48,temblorinsurancelistDto.getName());
        dbManager.setDouble(49,temblorinsurancelistDto.getRateadjust1());
        dbManager.setDouble(50,temblorinsurancelistDto.getRateadjust2());
        //设置条件字段;
        dbManager.setString(51,temblorinsurancelistDto.getInusrelistcode());
        dbManager.setString(52,temblorinsurancelistDto.getKindcode());
        dbManager.setString(53,temblorinsurancelistDto.getItemcode());
        dbManager.setString(54,temblorinsurancelistDto.getAddress());
        dbManager.setString(55,temblorinsurancelistDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TemblorinsurancelistDto
     * @throws Exception
     */
    public TemblorinsurancelistDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
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
        buffer.append("FROM Temblorinsurancelist ");
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
        TemblorinsurancelistDto temblorinsurancelistDto = null;
        if(resultSet.next()){
            temblorinsurancelistDto = new TemblorinsurancelistDto();
            temblorinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorinsurancelistDto.setBusinessno(dbManager.getString(resultSet,2));
            temblorinsurancelistDto.setKindcode(dbManager.getString(resultSet,3));
            temblorinsurancelistDto.setItemcode(dbManager.getString(resultSet,4));
            temblorinsurancelistDto.setIndexcode(dbManager.getString(resultSet,5));
            temblorinsurancelistDto.setCountrycode(dbManager.getString(resultSet,6));
            temblorinsurancelistDto.setCitycode(dbManager.getString(resultSet,7));
            temblorinsurancelistDto.setAddress(dbManager.getString(resultSet,8));
            temblorinsurancelistDto.setZipcode(dbManager.getString(resultSet,9));
            temblorinsurancelistDto.setLongitude(dbManager.getDouble(resultSet,10));
            temblorinsurancelistDto.setLatitude(dbManager.getDouble(resultSet,11));
            temblorinsurancelistDto.setItemtype(dbManager.getString(resultSet,12));
            temblorinsurancelistDto.setBuilding(dbManager.getString(resultSet,13));
            temblorinsurancelistDto.setFloor(dbManager.getInt(resultSet,14));
            temblorinsurancelistDto.setArchitecture(dbManager.getString(resultSet,15));
            temblorinsurancelistDto.setRemark(dbManager.getString(resultSet,16));
            temblorinsurancelistDto.setArea(dbManager.getDouble(resultSet,17));
            temblorinsurancelistDto.setBuildtime(dbManager.getString(resultSet,18));
            temblorinsurancelistDto.setRepair(dbManager.getString(resultSet,19));
            temblorinsurancelistDto.setRepairtime(dbManager.getString(resultSet,20));
            temblorinsurancelistDto.setPropcerttype(dbManager.getString(resultSet,21));
            temblorinsurancelistDto.setPropcertno(dbManager.getString(resultSet,22));
            temblorinsurancelistDto.setClasscode(dbManager.getString(resultSet,23));
            temblorinsurancelistDto.setRiskcode(dbManager.getString(resultSet,24));
            temblorinsurancelistDto.setAmount(dbManager.getDouble(resultSet,25));
            temblorinsurancelistDto.setRate(dbManager.getDouble(resultSet,26));
            temblorinsurancelistDto.setPremium(dbManager.getDouble(resultSet,27));
            temblorinsurancelistDto.setShortrateflag(dbManager.getString(resultSet,28));
            temblorinsurancelistDto.setShortrate(dbManager.getDouble(resultSet,29));
            temblorinsurancelistDto.setSumamount(dbManager.getDouble(resultSet,30));
            temblorinsurancelistDto.setSumpremium(dbManager.getDouble(resultSet,31));
            temblorinsurancelistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            temblorinsurancelistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            temblorinsurancelistDto.setStarttime(dbManager.getString(resultSet,34));
            temblorinsurancelistDto.setEndtime(dbManager.getString(resultSet,35));
            temblorinsurancelistDto.setCalculateflag(dbManager.getString(resultSet,36));
            temblorinsurancelistDto.setOpcode(dbManager.getString(resultSet,37));
            temblorinsurancelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,38));
            temblorinsurancelistDto.setValidity(dbManager.getString(resultSet,39));
            temblorinsurancelistDto.setFpremium(dbManager.getDouble(resultSet,40));
            temblorinsurancelistDto.setCentralpremium(dbManager.getDouble(resultSet,41));
            temblorinsurancelistDto.setProvincepremium(dbManager.getDouble(resultSet,42));
            temblorinsurancelistDto.setCitypremium(dbManager.getDouble(resultSet,43));
            temblorinsurancelistDto.setTownpremium(dbManager.getDouble(resultSet,44));
            temblorinsurancelistDto.setOtherpremium(dbManager.getDouble(resultSet,45));
            temblorinsurancelistDto.setTemp1(dbManager.getString(resultSet,46));
            temblorinsurancelistDto.setTemp2(dbManager.getString(resultSet,47));
            temblorinsurancelistDto.setTemp3(dbManager.getString(resultSet,48));
            temblorinsurancelistDto.setTemp4(dbManager.getString(resultSet,49));
            temblorinsurancelistDto.setTemp5(dbManager.getString(resultSet,50));
            temblorinsurancelistDto.setCardtype(dbManager.getString(resultSet,51));
            temblorinsurancelistDto.setIdcard(dbManager.getString(resultSet,52));
            temblorinsurancelistDto.setName(dbManager.getString(resultSet,53));
            temblorinsurancelistDto.setRateadjust1(dbManager.getDouble(resultSet,54));
            temblorinsurancelistDto.setRateadjust2(dbManager.getDouble(resultSet,55));
        }
        resultSet.close();
        return temblorinsurancelistDto;
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
        buffer.append("FROM Temblorinsurancelist WHERE ");
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
        TemblorinsurancelistDto temblorinsurancelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorinsurancelistDto = new TemblorinsurancelistDto();
            temblorinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorinsurancelistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            temblorinsurancelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorinsurancelistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorinsurancelistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            temblorinsurancelistDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorinsurancelistDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorinsurancelistDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorinsurancelistDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorinsurancelistDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorinsurancelistDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorinsurancelistDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorinsurancelistDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorinsurancelistDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorinsurancelistDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorinsurancelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorinsurancelistDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorinsurancelistDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorinsurancelistDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorinsurancelistDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorinsurancelistDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorinsurancelistDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorinsurancelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorinsurancelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorinsurancelistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            temblorinsurancelistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            temblorinsurancelistDto.setPremium(dbManager.getDouble(resultSet,"Premium"));
            temblorinsurancelistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            temblorinsurancelistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            temblorinsurancelistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            temblorinsurancelistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            temblorinsurancelistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            temblorinsurancelistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            temblorinsurancelistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            temblorinsurancelistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            temblorinsurancelistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            temblorinsurancelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorinsurancelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorinsurancelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorinsurancelistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            temblorinsurancelistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            temblorinsurancelistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            temblorinsurancelistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            temblorinsurancelistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            temblorinsurancelistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            temblorinsurancelistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            temblorinsurancelistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            temblorinsurancelistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            temblorinsurancelistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            temblorinsurancelistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            temblorinsurancelistDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorinsurancelistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorinsurancelistDto.setName(dbManager.getString(resultSet,"Name"));
            temblorinsurancelistDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            temblorinsurancelistDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            collection.add(temblorinsurancelistDto);
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
        buffer.append("DELETE FROM Temblorinsurancelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorinsurancelist WHERE ");
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
