package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorcpendorchgdetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORCPENDORCHGDETAIL的数据访问对象基类<br>
 */
public class DBTemblorcpendorchgdetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorcpendorchgdetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorcpendorchgdetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorcpendorchgdetail (");
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
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getRiskcode()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getAmount()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getRate()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getPremium()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getShortrate()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getSumamount()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getStartdate()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getEnddate()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getStarttime()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getEndtime()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getValidity()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getFpremium()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getCitypremium()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getTownpremium()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getOtherpremium()).append(",");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getTemp1()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getTemp2()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getTemp3()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getTemp4()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getTemp5()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorcpendorchgdetailDto.getName()).append("',");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(temblorcpendorchgdetailDto.getRateadjust2()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorcpendorchgdetailDto.getInusrelistcode());
        dbManager.setString(2,temblorcpendorchgdetailDto.getBusinessno());
        dbManager.setString(3,temblorcpendorchgdetailDto.getKindcode());
        dbManager.setString(4,temblorcpendorchgdetailDto.getItemcode());
        dbManager.setString(5,temblorcpendorchgdetailDto.getIndexcode());
        dbManager.setString(6,temblorcpendorchgdetailDto.getCountrycode());
        dbManager.setString(7,temblorcpendorchgdetailDto.getCitycode());
        dbManager.setString(8,temblorcpendorchgdetailDto.getAddress());
        dbManager.setString(9,temblorcpendorchgdetailDto.getZipcode());
        dbManager.setDouble(10,temblorcpendorchgdetailDto.getLongitude());
        dbManager.setDouble(11,temblorcpendorchgdetailDto.getLatitude());
        dbManager.setString(12,temblorcpendorchgdetailDto.getItemtype());
        dbManager.setString(13,temblorcpendorchgdetailDto.getBuilding());
        dbManager.setInt(14,temblorcpendorchgdetailDto.getFloor());
        dbManager.setString(15,temblorcpendorchgdetailDto.getArchitecture());
        dbManager.setString(16,temblorcpendorchgdetailDto.getRemark());
        dbManager.setDouble(17,temblorcpendorchgdetailDto.getArea());
        dbManager.setString(18,temblorcpendorchgdetailDto.getBuildtime());
        dbManager.setString(19,temblorcpendorchgdetailDto.getRepair());
        dbManager.setString(20,temblorcpendorchgdetailDto.getRepairtime());
        dbManager.setString(21,temblorcpendorchgdetailDto.getPropcerttype());
        dbManager.setString(22,temblorcpendorchgdetailDto.getPropcertno());
        dbManager.setString(23,temblorcpendorchgdetailDto.getClasscode());
        dbManager.setString(24,temblorcpendorchgdetailDto.getRiskcode());
        dbManager.setDouble(25,temblorcpendorchgdetailDto.getAmount());
        dbManager.setDouble(26,temblorcpendorchgdetailDto.getRate());
        dbManager.setDouble(27,temblorcpendorchgdetailDto.getPremium());
        dbManager.setString(28,temblorcpendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(29,temblorcpendorchgdetailDto.getShortrate());
        dbManager.setDouble(30,temblorcpendorchgdetailDto.getSumamount());
        dbManager.setDouble(31,temblorcpendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(32,temblorcpendorchgdetailDto.getStartdate());
        dbManager.setDateTime(33,temblorcpendorchgdetailDto.getEnddate());
        dbManager.setString(34,temblorcpendorchgdetailDto.getStarttime());
        dbManager.setString(35,temblorcpendorchgdetailDto.getEndtime());
        dbManager.setString(36,temblorcpendorchgdetailDto.getCalculateflag());
        dbManager.setString(37,temblorcpendorchgdetailDto.getOpcode());
        dbManager.setDateTime(38,temblorcpendorchgdetailDto.getOptime());
        dbManager.setString(39,temblorcpendorchgdetailDto.getValidity());
        dbManager.setDouble(40,temblorcpendorchgdetailDto.getFpremium());
        dbManager.setDouble(41,temblorcpendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(42,temblorcpendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(43,temblorcpendorchgdetailDto.getCitypremium());
        dbManager.setDouble(44,temblorcpendorchgdetailDto.getTownpremium());
        dbManager.setDouble(45,temblorcpendorchgdetailDto.getOtherpremium());
        dbManager.setString(46,temblorcpendorchgdetailDto.getTemp1());
        dbManager.setString(47,temblorcpendorchgdetailDto.getTemp2());
        dbManager.setString(48,temblorcpendorchgdetailDto.getTemp3());
        dbManager.setString(49,temblorcpendorchgdetailDto.getTemp4());
        dbManager.setString(50,temblorcpendorchgdetailDto.getTemp5());
        dbManager.setString(51,temblorcpendorchgdetailDto.getCardtype());
        dbManager.setString(52,temblorcpendorchgdetailDto.getIdcard());
        dbManager.setString(53,temblorcpendorchgdetailDto.getName());
        dbManager.setDouble(54,temblorcpendorchgdetailDto.getRateadjust1());
        dbManager.setDouble(55,temblorcpendorchgdetailDto.getRateadjust2());
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
        buffer.append("INSERT INTO Temblorcpendorchgdetail (");
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
            TemblorcpendorchgdetailDto temblorcpendorchgdetailDto = (TemblorcpendorchgdetailDto)i.next();
            dbManager.setString(1,temblorcpendorchgdetailDto.getInusrelistcode());
            dbManager.setString(2,temblorcpendorchgdetailDto.getBusinessno());
            dbManager.setString(3,temblorcpendorchgdetailDto.getKindcode());
            dbManager.setString(4,temblorcpendorchgdetailDto.getItemcode());
            dbManager.setString(5,temblorcpendorchgdetailDto.getIndexcode());
            dbManager.setString(6,temblorcpendorchgdetailDto.getCountrycode());
            dbManager.setString(7,temblorcpendorchgdetailDto.getCitycode());
            dbManager.setString(8,temblorcpendorchgdetailDto.getAddress());
            dbManager.setString(9,temblorcpendorchgdetailDto.getZipcode());
            dbManager.setDouble(10,temblorcpendorchgdetailDto.getLongitude());
            dbManager.setDouble(11,temblorcpendorchgdetailDto.getLatitude());
            dbManager.setString(12,temblorcpendorchgdetailDto.getItemtype());
            dbManager.setString(13,temblorcpendorchgdetailDto.getBuilding());
            dbManager.setInt(14,temblorcpendorchgdetailDto.getFloor());
            dbManager.setString(15,temblorcpendorchgdetailDto.getArchitecture());
            dbManager.setString(16,temblorcpendorchgdetailDto.getRemark());
            dbManager.setDouble(17,temblorcpendorchgdetailDto.getArea());
            dbManager.setString(18,temblorcpendorchgdetailDto.getBuildtime());
            dbManager.setString(19,temblorcpendorchgdetailDto.getRepair());
            dbManager.setString(20,temblorcpendorchgdetailDto.getRepairtime());
            dbManager.setString(21,temblorcpendorchgdetailDto.getPropcerttype());
            dbManager.setString(22,temblorcpendorchgdetailDto.getPropcertno());
            dbManager.setString(23,temblorcpendorchgdetailDto.getClasscode());
            dbManager.setString(24,temblorcpendorchgdetailDto.getRiskcode());
            dbManager.setDouble(25,temblorcpendorchgdetailDto.getAmount());
            dbManager.setDouble(26,temblorcpendorchgdetailDto.getRate());
            dbManager.setDouble(27,temblorcpendorchgdetailDto.getPremium());
            dbManager.setString(28,temblorcpendorchgdetailDto.getShortrateflag());
            dbManager.setDouble(29,temblorcpendorchgdetailDto.getShortrate());
            dbManager.setDouble(30,temblorcpendorchgdetailDto.getSumamount());
            dbManager.setDouble(31,temblorcpendorchgdetailDto.getSumpremium());
            dbManager.setDateTime(32,temblorcpendorchgdetailDto.getStartdate());
            dbManager.setDateTime(33,temblorcpendorchgdetailDto.getEnddate());
            dbManager.setString(34,temblorcpendorchgdetailDto.getStarttime());
            dbManager.setString(35,temblorcpendorchgdetailDto.getEndtime());
            dbManager.setString(36,temblorcpendorchgdetailDto.getCalculateflag());
            dbManager.setString(37,temblorcpendorchgdetailDto.getOpcode());
            dbManager.setDateTime(38,temblorcpendorchgdetailDto.getOptime());
            dbManager.setString(39,temblorcpendorchgdetailDto.getValidity());
            dbManager.setDouble(40,temblorcpendorchgdetailDto.getFpremium());
            dbManager.setDouble(41,temblorcpendorchgdetailDto.getCentralpremium());
            dbManager.setDouble(42,temblorcpendorchgdetailDto.getProvincepremium());
            dbManager.setDouble(43,temblorcpendorchgdetailDto.getCitypremium());
            dbManager.setDouble(44,temblorcpendorchgdetailDto.getTownpremium());
            dbManager.setDouble(45,temblorcpendorchgdetailDto.getOtherpremium());
            dbManager.setString(46,temblorcpendorchgdetailDto.getTemp1());
            dbManager.setString(47,temblorcpendorchgdetailDto.getTemp2());
            dbManager.setString(48,temblorcpendorchgdetailDto.getTemp3());
            dbManager.setString(49,temblorcpendorchgdetailDto.getTemp4());
            dbManager.setString(50,temblorcpendorchgdetailDto.getTemp5());
            dbManager.setString(51,temblorcpendorchgdetailDto.getCardtype());
            dbManager.setString(52,temblorcpendorchgdetailDto.getIdcard());
            dbManager.setString(53,temblorcpendorchgdetailDto.getName());
            dbManager.setDouble(54,temblorcpendorchgdetailDto.getRateadjust1());
            dbManager.setDouble(55,temblorcpendorchgdetailDto.getRateadjust2());
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
        buffer.append("DELETE FROM Temblorcpendorchgdetail ");
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
     * @param temblorcpendorchgdetailDto temblorcpendorchgdetailDto
     * @throws Exception
     */
    public void update(TemblorcpendorchgdetailDto temblorcpendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorcpendorchgdetail SET ");
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
            debugBuffer.append("UPDATE Temblorcpendorchgdetail SET ");
            debugBuffer.append("Businessno = '" + temblorcpendorchgdetailDto.getBusinessno() + "', ");
            debugBuffer.append("Indexcode = '" + temblorcpendorchgdetailDto.getIndexcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorcpendorchgdetailDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorcpendorchgdetailDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + temblorcpendorchgdetailDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorcpendorchgdetailDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorcpendorchgdetailDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorcpendorchgdetailDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorcpendorchgdetailDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorcpendorchgdetailDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorcpendorchgdetailDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorcpendorchgdetailDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorcpendorchgdetailDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorcpendorchgdetailDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorcpendorchgdetailDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorcpendorchgdetailDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorcpendorchgdetailDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorcpendorchgdetailDto.getPropcertno() + "', ");
            debugBuffer.append("Classcode = '" + temblorcpendorchgdetailDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorcpendorchgdetailDto.getRiskcode() + "', ");
            debugBuffer.append("Amount = " + temblorcpendorchgdetailDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + temblorcpendorchgdetailDto.getRate() + ", ");
            debugBuffer.append("Premium = " + temblorcpendorchgdetailDto.getPremium() + ", ");
            debugBuffer.append("Shortrateflag = '" + temblorcpendorchgdetailDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + temblorcpendorchgdetailDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + temblorcpendorchgdetailDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + temblorcpendorchgdetailDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + temblorcpendorchgdetailDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + temblorcpendorchgdetailDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + temblorcpendorchgdetailDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + temblorcpendorchgdetailDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + temblorcpendorchgdetailDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + temblorcpendorchgdetailDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorcpendorchgdetailDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorcpendorchgdetailDto.getValidity() + "', ");
            debugBuffer.append("Fpremium = " + temblorcpendorchgdetailDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + temblorcpendorchgdetailDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + temblorcpendorchgdetailDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + temblorcpendorchgdetailDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + temblorcpendorchgdetailDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + temblorcpendorchgdetailDto.getOtherpremium() + ", ");
            debugBuffer.append("Temp1 = '" + temblorcpendorchgdetailDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + temblorcpendorchgdetailDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + temblorcpendorchgdetailDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + temblorcpendorchgdetailDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + temblorcpendorchgdetailDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + temblorcpendorchgdetailDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + temblorcpendorchgdetailDto.getName() + "', ");
            debugBuffer.append("Rateadjust1 = " + temblorcpendorchgdetailDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + temblorcpendorchgdetailDto.getRateadjust2() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(temblorcpendorchgdetailDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorcpendorchgdetailDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorcpendorchgdetailDto.getItemcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(temblorcpendorchgdetailDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(temblorcpendorchgdetailDto.getIdcard()).append("'");
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
        dbManager.setString(1,temblorcpendorchgdetailDto.getBusinessno());
        dbManager.setString(2,temblorcpendorchgdetailDto.getIndexcode());
        dbManager.setString(3,temblorcpendorchgdetailDto.getCountrycode());
        dbManager.setString(4,temblorcpendorchgdetailDto.getCitycode());
        dbManager.setString(5,temblorcpendorchgdetailDto.getZipcode());
        dbManager.setDouble(6,temblorcpendorchgdetailDto.getLongitude());
        dbManager.setDouble(7,temblorcpendorchgdetailDto.getLatitude());
        dbManager.setString(8,temblorcpendorchgdetailDto.getItemtype());
        dbManager.setString(9,temblorcpendorchgdetailDto.getBuilding());
        dbManager.setInt(10,temblorcpendorchgdetailDto.getFloor());
        dbManager.setString(11,temblorcpendorchgdetailDto.getArchitecture());
        dbManager.setString(12,temblorcpendorchgdetailDto.getRemark());
        dbManager.setDouble(13,temblorcpendorchgdetailDto.getArea());
        dbManager.setString(14,temblorcpendorchgdetailDto.getBuildtime());
        dbManager.setString(15,temblorcpendorchgdetailDto.getRepair());
        dbManager.setString(16,temblorcpendorchgdetailDto.getRepairtime());
        dbManager.setString(17,temblorcpendorchgdetailDto.getPropcerttype());
        dbManager.setString(18,temblorcpendorchgdetailDto.getPropcertno());
        dbManager.setString(19,temblorcpendorchgdetailDto.getClasscode());
        dbManager.setString(20,temblorcpendorchgdetailDto.getRiskcode());
        dbManager.setDouble(21,temblorcpendorchgdetailDto.getAmount());
        dbManager.setDouble(22,temblorcpendorchgdetailDto.getRate());
        dbManager.setDouble(23,temblorcpendorchgdetailDto.getPremium());
        dbManager.setString(24,temblorcpendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(25,temblorcpendorchgdetailDto.getShortrate());
        dbManager.setDouble(26,temblorcpendorchgdetailDto.getSumamount());
        dbManager.setDouble(27,temblorcpendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(28,temblorcpendorchgdetailDto.getStartdate());
        dbManager.setDateTime(29,temblorcpendorchgdetailDto.getEnddate());
        dbManager.setString(30,temblorcpendorchgdetailDto.getStarttime());
        dbManager.setString(31,temblorcpendorchgdetailDto.getEndtime());
        dbManager.setString(32,temblorcpendorchgdetailDto.getCalculateflag());
        dbManager.setString(33,temblorcpendorchgdetailDto.getOpcode());
        dbManager.setDateTime(34,temblorcpendorchgdetailDto.getOptime());
        dbManager.setString(35,temblorcpendorchgdetailDto.getValidity());
        dbManager.setDouble(36,temblorcpendorchgdetailDto.getFpremium());
        dbManager.setDouble(37,temblorcpendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(38,temblorcpendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(39,temblorcpendorchgdetailDto.getCitypremium());
        dbManager.setDouble(40,temblorcpendorchgdetailDto.getTownpremium());
        dbManager.setDouble(41,temblorcpendorchgdetailDto.getOtherpremium());
        dbManager.setString(42,temblorcpendorchgdetailDto.getTemp1());
        dbManager.setString(43,temblorcpendorchgdetailDto.getTemp2());
        dbManager.setString(44,temblorcpendorchgdetailDto.getTemp3());
        dbManager.setString(45,temblorcpendorchgdetailDto.getTemp4());
        dbManager.setString(46,temblorcpendorchgdetailDto.getTemp5());
        dbManager.setString(47,temblorcpendorchgdetailDto.getCardtype());
        dbManager.setString(48,temblorcpendorchgdetailDto.getName());
        dbManager.setDouble(49,temblorcpendorchgdetailDto.getRateadjust1());
        dbManager.setDouble(50,temblorcpendorchgdetailDto.getRateadjust2());
        //设置条件字段;
        dbManager.setString(51,temblorcpendorchgdetailDto.getInusrelistcode());
        dbManager.setString(52,temblorcpendorchgdetailDto.getKindcode());
        dbManager.setString(53,temblorcpendorchgdetailDto.getItemcode());
        dbManager.setString(54,temblorcpendorchgdetailDto.getAddress());
        dbManager.setString(55,temblorcpendorchgdetailDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TemblorcpendorchgdetailDto
     * @throws Exception
     */
    public TemblorcpendorchgdetailDto findByPrimaryKey(String inusrelistcode,String kindcode,String itemcode,String address,String idcard)
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
        buffer.append("FROM Temblorcpendorchgdetail ");
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
        TemblorcpendorchgdetailDto temblorcpendorchgdetailDto = null;
        if(resultSet.next()){
            temblorcpendorchgdetailDto = new TemblorcpendorchgdetailDto();
            temblorcpendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorcpendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,2));
            temblorcpendorchgdetailDto.setKindcode(dbManager.getString(resultSet,3));
            temblorcpendorchgdetailDto.setItemcode(dbManager.getString(resultSet,4));
            temblorcpendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,5));
            temblorcpendorchgdetailDto.setCountrycode(dbManager.getString(resultSet,6));
            temblorcpendorchgdetailDto.setCitycode(dbManager.getString(resultSet,7));
            temblorcpendorchgdetailDto.setAddress(dbManager.getString(resultSet,8));
            temblorcpendorchgdetailDto.setZipcode(dbManager.getString(resultSet,9));
            temblorcpendorchgdetailDto.setLongitude(dbManager.getDouble(resultSet,10));
            temblorcpendorchgdetailDto.setLatitude(dbManager.getDouble(resultSet,11));
            temblorcpendorchgdetailDto.setItemtype(dbManager.getString(resultSet,12));
            temblorcpendorchgdetailDto.setBuilding(dbManager.getString(resultSet,13));
            temblorcpendorchgdetailDto.setFloor(dbManager.getInt(resultSet,14));
            temblorcpendorchgdetailDto.setArchitecture(dbManager.getString(resultSet,15));
            temblorcpendorchgdetailDto.setRemark(dbManager.getString(resultSet,16));
            temblorcpendorchgdetailDto.setArea(dbManager.getDouble(resultSet,17));
            temblorcpendorchgdetailDto.setBuildtime(dbManager.getString(resultSet,18));
            temblorcpendorchgdetailDto.setRepair(dbManager.getString(resultSet,19));
            temblorcpendorchgdetailDto.setRepairtime(dbManager.getString(resultSet,20));
            temblorcpendorchgdetailDto.setPropcerttype(dbManager.getString(resultSet,21));
            temblorcpendorchgdetailDto.setPropcertno(dbManager.getString(resultSet,22));
            temblorcpendorchgdetailDto.setClasscode(dbManager.getString(resultSet,23));
            temblorcpendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,24));
            temblorcpendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,25));
            temblorcpendorchgdetailDto.setRate(dbManager.getDouble(resultSet,26));
            temblorcpendorchgdetailDto.setPremium(dbManager.getDouble(resultSet,27));
            temblorcpendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,28));
            temblorcpendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,29));
            temblorcpendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,30));
            temblorcpendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,31));
            temblorcpendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            temblorcpendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            temblorcpendorchgdetailDto.setStarttime(dbManager.getString(resultSet,34));
            temblorcpendorchgdetailDto.setEndtime(dbManager.getString(resultSet,35));
            temblorcpendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,36));
            temblorcpendorchgdetailDto.setOpcode(dbManager.getString(resultSet,37));
            temblorcpendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,38));
            temblorcpendorchgdetailDto.setValidity(dbManager.getString(resultSet,39));
            temblorcpendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,40));
            temblorcpendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,41));
            temblorcpendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,42));
            temblorcpendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,43));
            temblorcpendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,44));
            temblorcpendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,45));
            temblorcpendorchgdetailDto.setTemp1(dbManager.getString(resultSet,46));
            temblorcpendorchgdetailDto.setTemp2(dbManager.getString(resultSet,47));
            temblorcpendorchgdetailDto.setTemp3(dbManager.getString(resultSet,48));
            temblorcpendorchgdetailDto.setTemp4(dbManager.getString(resultSet,49));
            temblorcpendorchgdetailDto.setTemp5(dbManager.getString(resultSet,50));
            temblorcpendorchgdetailDto.setCardtype(dbManager.getString(resultSet,51));
            temblorcpendorchgdetailDto.setIdcard(dbManager.getString(resultSet,52));
            temblorcpendorchgdetailDto.setName(dbManager.getString(resultSet,53));
            temblorcpendorchgdetailDto.setRateadjust1(dbManager.getDouble(resultSet,54));
            temblorcpendorchgdetailDto.setRateadjust2(dbManager.getDouble(resultSet,55));
        }
        resultSet.close();
        return temblorcpendorchgdetailDto;
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
        buffer.append("FROM Temblorcpendorchgdetail WHERE ");
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
        TemblorcpendorchgdetailDto temblorcpendorchgdetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorcpendorchgdetailDto = new TemblorcpendorchgdetailDto();
            temblorcpendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorcpendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            temblorcpendorchgdetailDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorcpendorchgdetailDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorcpendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            temblorcpendorchgdetailDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorcpendorchgdetailDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorcpendorchgdetailDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorcpendorchgdetailDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorcpendorchgdetailDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorcpendorchgdetailDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorcpendorchgdetailDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorcpendorchgdetailDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorcpendorchgdetailDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorcpendorchgdetailDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorcpendorchgdetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorcpendorchgdetailDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorcpendorchgdetailDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorcpendorchgdetailDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorcpendorchgdetailDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorcpendorchgdetailDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorcpendorchgdetailDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorcpendorchgdetailDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorcpendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorcpendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            temblorcpendorchgdetailDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            temblorcpendorchgdetailDto.setPremium(dbManager.getDouble(resultSet,"Premium"));
            temblorcpendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            temblorcpendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            temblorcpendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            temblorcpendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            temblorcpendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            temblorcpendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            temblorcpendorchgdetailDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            temblorcpendorchgdetailDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            temblorcpendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            temblorcpendorchgdetailDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorcpendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorcpendorchgdetailDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorcpendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            temblorcpendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            temblorcpendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            temblorcpendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            temblorcpendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            temblorcpendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            temblorcpendorchgdetailDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            temblorcpendorchgdetailDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            temblorcpendorchgdetailDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            temblorcpendorchgdetailDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            temblorcpendorchgdetailDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            temblorcpendorchgdetailDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorcpendorchgdetailDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorcpendorchgdetailDto.setName(dbManager.getString(resultSet,"Name"));
            temblorcpendorchgdetailDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            temblorcpendorchgdetailDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            collection.add(temblorcpendorchgdetailDto);
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
        buffer.append("DELETE FROM Temblorcpendorchgdetail WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorcpendorchgdetail WHERE ");
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
