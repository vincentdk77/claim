package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorchgdetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORENDORCHGDETAIL的数据访问对象基类<br>
 */
public class DBTemblorendorchgdetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorendorchgdetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorendorchgdetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void insert(TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Endorseno,");
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
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Flag,");
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
            debugBuffer.append("'").append(temblorendorchgdetailDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getEndorseno()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getRiskcode()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getAmount()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getRate()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getPremium()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getShortrate()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getSumamount()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getStartdate()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getEnddate()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getStarttime()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getEndtime()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getValidity()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getFpremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getCitypremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getTownpremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getChgsumamount()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getChgsumpremium()).append(",");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getFlag()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getTemp1()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getTemp2()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getTemp3()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getTemp4()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getTemp5()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorendorchgdetailDto.getName()).append("',");
            debugBuffer.append("").append(temblorendorchgdetailDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(temblorendorchgdetailDto.getRateadjust2()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorendorchgdetailDto.getInusrelistcode());
        dbManager.setString(2,temblorendorchgdetailDto.getBusinessno());
        dbManager.setString(3,temblorendorchgdetailDto.getEndorseno());
        dbManager.setString(4,temblorendorchgdetailDto.getKindcode());
        dbManager.setString(5,temblorendorchgdetailDto.getItemcode());
        dbManager.setString(6,temblorendorchgdetailDto.getIndexcode());
        dbManager.setString(7,temblorendorchgdetailDto.getCountrycode());
        dbManager.setString(8,temblorendorchgdetailDto.getCitycode());
        dbManager.setString(9,temblorendorchgdetailDto.getAddress());
        dbManager.setString(10,temblorendorchgdetailDto.getZipcode());
        dbManager.setDouble(11,temblorendorchgdetailDto.getLongitude());
        dbManager.setDouble(12,temblorendorchgdetailDto.getLatitude());
        dbManager.setString(13,temblorendorchgdetailDto.getItemtype());
        dbManager.setString(14,temblorendorchgdetailDto.getBuilding());
        dbManager.setInt(15,temblorendorchgdetailDto.getFloor());
        dbManager.setString(16,temblorendorchgdetailDto.getArchitecture());
        dbManager.setString(17,temblorendorchgdetailDto.getRemark());
        dbManager.setDouble(18,temblorendorchgdetailDto.getArea());
        dbManager.setString(19,temblorendorchgdetailDto.getBuildtime());
        dbManager.setString(20,temblorendorchgdetailDto.getRepair());
        dbManager.setString(21,temblorendorchgdetailDto.getRepairtime());
        dbManager.setString(22,temblorendorchgdetailDto.getPropcerttype());
        dbManager.setString(23,temblorendorchgdetailDto.getPropcertno());
        dbManager.setString(24,temblorendorchgdetailDto.getClasscode());
        dbManager.setString(25,temblorendorchgdetailDto.getRiskcode());
        dbManager.setDouble(26,temblorendorchgdetailDto.getAmount());
        dbManager.setDouble(27,temblorendorchgdetailDto.getRate());
        dbManager.setDouble(28,temblorendorchgdetailDto.getPremium());
        dbManager.setString(29,temblorendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(30,temblorendorchgdetailDto.getShortrate());
        dbManager.setDouble(31,temblorendorchgdetailDto.getSumamount());
        dbManager.setDouble(32,temblorendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(33,temblorendorchgdetailDto.getStartdate());
        dbManager.setDateTime(34,temblorendorchgdetailDto.getEnddate());
        dbManager.setString(35,temblorendorchgdetailDto.getStarttime());
        dbManager.setString(36,temblorendorchgdetailDto.getEndtime());
        dbManager.setString(37,temblorendorchgdetailDto.getCalculateflag());
        dbManager.setString(38,temblorendorchgdetailDto.getOpcode());
        dbManager.setDateTime(39,temblorendorchgdetailDto.getOptime());
        dbManager.setString(40,temblorendorchgdetailDto.getValidity());
        dbManager.setDouble(41,temblorendorchgdetailDto.getFpremium());
        dbManager.setDouble(42,temblorendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(43,temblorendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(44,temblorendorchgdetailDto.getCitypremium());
        dbManager.setDouble(45,temblorendorchgdetailDto.getTownpremium());
        dbManager.setDouble(46,temblorendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(47,temblorendorchgdetailDto.getChgsumamount());
        dbManager.setDouble(48,temblorendorchgdetailDto.getChgsumpremium());
        dbManager.setString(49,temblorendorchgdetailDto.getFlag());
        dbManager.setString(50,temblorendorchgdetailDto.getTemp1());
        dbManager.setString(51,temblorendorchgdetailDto.getTemp2());
        dbManager.setString(52,temblorendorchgdetailDto.getTemp3());
        dbManager.setString(53,temblorendorchgdetailDto.getTemp4());
        dbManager.setString(54,temblorendorchgdetailDto.getTemp5());
        dbManager.setString(55,temblorendorchgdetailDto.getCardtype());
        dbManager.setString(56,temblorendorchgdetailDto.getIdcard());
        dbManager.setString(57,temblorendorchgdetailDto.getName());
        dbManager.setDouble(58,temblorendorchgdetailDto.getRateadjust1());
        dbManager.setDouble(59,temblorendorchgdetailDto.getRateadjust2());
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
        buffer.append("INSERT INTO Temblorendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Endorseno,");
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
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Flag,");
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
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TemblorendorchgdetailDto temblorendorchgdetailDto = (TemblorendorchgdetailDto)i.next();
            dbManager.setString(1,temblorendorchgdetailDto.getInusrelistcode());
            dbManager.setString(2,temblorendorchgdetailDto.getBusinessno());
            dbManager.setString(3,temblorendorchgdetailDto.getEndorseno());
            dbManager.setString(4,temblorendorchgdetailDto.getKindcode());
            dbManager.setString(5,temblorendorchgdetailDto.getItemcode());
            dbManager.setString(6,temblorendorchgdetailDto.getIndexcode());
            dbManager.setString(7,temblorendorchgdetailDto.getCountrycode());
            dbManager.setString(8,temblorendorchgdetailDto.getCitycode());
            dbManager.setString(9,temblorendorchgdetailDto.getAddress());
            dbManager.setString(10,temblorendorchgdetailDto.getZipcode());
            dbManager.setDouble(11,temblorendorchgdetailDto.getLongitude());
            dbManager.setDouble(12,temblorendorchgdetailDto.getLatitude());
            dbManager.setString(13,temblorendorchgdetailDto.getItemtype());
            dbManager.setString(14,temblorendorchgdetailDto.getBuilding());
            dbManager.setInt(15,temblorendorchgdetailDto.getFloor());
            dbManager.setString(16,temblorendorchgdetailDto.getArchitecture());
            dbManager.setString(17,temblorendorchgdetailDto.getRemark());
            dbManager.setDouble(18,temblorendorchgdetailDto.getArea());
            dbManager.setString(19,temblorendorchgdetailDto.getBuildtime());
            dbManager.setString(20,temblorendorchgdetailDto.getRepair());
            dbManager.setString(21,temblorendorchgdetailDto.getRepairtime());
            dbManager.setString(22,temblorendorchgdetailDto.getPropcerttype());
            dbManager.setString(23,temblorendorchgdetailDto.getPropcertno());
            dbManager.setString(24,temblorendorchgdetailDto.getClasscode());
            dbManager.setString(25,temblorendorchgdetailDto.getRiskcode());
            dbManager.setDouble(26,temblorendorchgdetailDto.getAmount());
            dbManager.setDouble(27,temblorendorchgdetailDto.getRate());
            dbManager.setDouble(28,temblorendorchgdetailDto.getPremium());
            dbManager.setString(29,temblorendorchgdetailDto.getShortrateflag());
            dbManager.setDouble(30,temblorendorchgdetailDto.getShortrate());
            dbManager.setDouble(31,temblorendorchgdetailDto.getSumamount());
            dbManager.setDouble(32,temblorendorchgdetailDto.getSumpremium());
            dbManager.setDateTime(33,temblorendorchgdetailDto.getStartdate());
            dbManager.setDateTime(34,temblorendorchgdetailDto.getEnddate());
            dbManager.setString(35,temblorendorchgdetailDto.getStarttime());
            dbManager.setString(36,temblorendorchgdetailDto.getEndtime());
            dbManager.setString(37,temblorendorchgdetailDto.getCalculateflag());
            dbManager.setString(38,temblorendorchgdetailDto.getOpcode());
            dbManager.setDateTime(39,temblorendorchgdetailDto.getOptime());
            dbManager.setString(40,temblorendorchgdetailDto.getValidity());
            dbManager.setDouble(41,temblorendorchgdetailDto.getFpremium());
            dbManager.setDouble(42,temblorendorchgdetailDto.getCentralpremium());
            dbManager.setDouble(43,temblorendorchgdetailDto.getProvincepremium());
            dbManager.setDouble(44,temblorendorchgdetailDto.getCitypremium());
            dbManager.setDouble(45,temblorendorchgdetailDto.getTownpremium());
            dbManager.setDouble(46,temblorendorchgdetailDto.getOtherpremium());
            dbManager.setDouble(47,temblorendorchgdetailDto.getChgsumamount());
            dbManager.setDouble(48,temblorendorchgdetailDto.getChgsumpremium());
            dbManager.setString(49,temblorendorchgdetailDto.getFlag());
            dbManager.setString(50,temblorendorchgdetailDto.getTemp1());
            dbManager.setString(51,temblorendorchgdetailDto.getTemp2());
            dbManager.setString(52,temblorendorchgdetailDto.getTemp3());
            dbManager.setString(53,temblorendorchgdetailDto.getTemp4());
            dbManager.setString(54,temblorendorchgdetailDto.getTemp5());
            dbManager.setString(55,temblorendorchgdetailDto.getCardtype());
            dbManager.setString(56,temblorendorchgdetailDto.getIdcard());
            dbManager.setString(57,temblorendorchgdetailDto.getName());
            dbManager.setDouble(58,temblorendorchgdetailDto.getRateadjust1());
            dbManager.setDouble(59,temblorendorchgdetailDto.getRateadjust2());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorendorchgdetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,endorseno);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,address);
        dbManager.setString(6,idcard);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param temblorendorchgdetailDto temblorendorchgdetailDto
     * @throws Exception
     */
    public void update(TemblorendorchgdetailDto temblorendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorendorchgdetail SET ");
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
        buffer.append("Chgsumamount = ?, ");
        buffer.append("Chgsumpremium = ?, ");
        buffer.append("Flag = ?, ");
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
            debugBuffer.append("UPDATE Temblorendorchgdetail SET ");
            debugBuffer.append("Businessno = '" + temblorendorchgdetailDto.getBusinessno() + "', ");
            debugBuffer.append("Indexcode = '" + temblorendorchgdetailDto.getIndexcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorendorchgdetailDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorendorchgdetailDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + temblorendorchgdetailDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorendorchgdetailDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorendorchgdetailDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorendorchgdetailDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorendorchgdetailDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorendorchgdetailDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorendorchgdetailDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorendorchgdetailDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorendorchgdetailDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorendorchgdetailDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorendorchgdetailDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorendorchgdetailDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorendorchgdetailDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorendorchgdetailDto.getPropcertno() + "', ");
            debugBuffer.append("Classcode = '" + temblorendorchgdetailDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorendorchgdetailDto.getRiskcode() + "', ");
            debugBuffer.append("Amount = " + temblorendorchgdetailDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + temblorendorchgdetailDto.getRate() + ", ");
            debugBuffer.append("Premium = " + temblorendorchgdetailDto.getPremium() + ", ");
            debugBuffer.append("Shortrateflag = '" + temblorendorchgdetailDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + temblorendorchgdetailDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + temblorendorchgdetailDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + temblorendorchgdetailDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + temblorendorchgdetailDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + temblorendorchgdetailDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + temblorendorchgdetailDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + temblorendorchgdetailDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + temblorendorchgdetailDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + temblorendorchgdetailDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorendorchgdetailDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorendorchgdetailDto.getValidity() + "', ");
            debugBuffer.append("Fpremium = " + temblorendorchgdetailDto.getFpremium() + ", ");
            debugBuffer.append("Centralpremium = " + temblorendorchgdetailDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + temblorendorchgdetailDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + temblorendorchgdetailDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + temblorendorchgdetailDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + temblorendorchgdetailDto.getOtherpremium() + ", ");
            debugBuffer.append("Chgsumamount = " + temblorendorchgdetailDto.getChgsumamount() + ", ");
            debugBuffer.append("Chgsumpremium = " + temblorendorchgdetailDto.getChgsumpremium() + ", ");
            debugBuffer.append("Flag = '" + temblorendorchgdetailDto.getFlag() + "', ");
            debugBuffer.append("Temp1 = '" + temblorendorchgdetailDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + temblorendorchgdetailDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + temblorendorchgdetailDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + temblorendorchgdetailDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + temblorendorchgdetailDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + temblorendorchgdetailDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + temblorendorchgdetailDto.getName() + "', ");
            debugBuffer.append("Rateadjust1 = " + temblorendorchgdetailDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + temblorendorchgdetailDto.getRateadjust2() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(temblorendorchgdetailDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(temblorendorchgdetailDto.getEndorseno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorendorchgdetailDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorendorchgdetailDto.getItemcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(temblorendorchgdetailDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(temblorendorchgdetailDto.getIdcard()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,temblorendorchgdetailDto.getBusinessno());
        dbManager.setString(2,temblorendorchgdetailDto.getIndexcode());
        dbManager.setString(3,temblorendorchgdetailDto.getCountrycode());
        dbManager.setString(4,temblorendorchgdetailDto.getCitycode());
        dbManager.setString(5,temblorendorchgdetailDto.getZipcode());
        dbManager.setDouble(6,temblorendorchgdetailDto.getLongitude());
        dbManager.setDouble(7,temblorendorchgdetailDto.getLatitude());
        dbManager.setString(8,temblorendorchgdetailDto.getItemtype());
        dbManager.setString(9,temblorendorchgdetailDto.getBuilding());
        dbManager.setInt(10,temblorendorchgdetailDto.getFloor());
        dbManager.setString(11,temblorendorchgdetailDto.getArchitecture());
        dbManager.setString(12,temblorendorchgdetailDto.getRemark());
        dbManager.setDouble(13,temblorendorchgdetailDto.getArea());
        dbManager.setString(14,temblorendorchgdetailDto.getBuildtime());
        dbManager.setString(15,temblorendorchgdetailDto.getRepair());
        dbManager.setString(16,temblorendorchgdetailDto.getRepairtime());
        dbManager.setString(17,temblorendorchgdetailDto.getPropcerttype());
        dbManager.setString(18,temblorendorchgdetailDto.getPropcertno());
        dbManager.setString(19,temblorendorchgdetailDto.getClasscode());
        dbManager.setString(20,temblorendorchgdetailDto.getRiskcode());
        dbManager.setDouble(21,temblorendorchgdetailDto.getAmount());
        dbManager.setDouble(22,temblorendorchgdetailDto.getRate());
        dbManager.setDouble(23,temblorendorchgdetailDto.getPremium());
        dbManager.setString(24,temblorendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(25,temblorendorchgdetailDto.getShortrate());
        dbManager.setDouble(26,temblorendorchgdetailDto.getSumamount());
        dbManager.setDouble(27,temblorendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(28,temblorendorchgdetailDto.getStartdate());
        dbManager.setDateTime(29,temblorendorchgdetailDto.getEnddate());
        dbManager.setString(30,temblorendorchgdetailDto.getStarttime());
        dbManager.setString(31,temblorendorchgdetailDto.getEndtime());
        dbManager.setString(32,temblorendorchgdetailDto.getCalculateflag());
        dbManager.setString(33,temblorendorchgdetailDto.getOpcode());
        dbManager.setDateTime(34,temblorendorchgdetailDto.getOptime());
        dbManager.setString(35,temblorendorchgdetailDto.getValidity());
        dbManager.setDouble(36,temblorendorchgdetailDto.getFpremium());
        dbManager.setDouble(37,temblorendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(38,temblorendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(39,temblorendorchgdetailDto.getCitypremium());
        dbManager.setDouble(40,temblorendorchgdetailDto.getTownpremium());
        dbManager.setDouble(41,temblorendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(42,temblorendorchgdetailDto.getChgsumamount());
        dbManager.setDouble(43,temblorendorchgdetailDto.getChgsumpremium());
        dbManager.setString(44,temblorendorchgdetailDto.getFlag());
        dbManager.setString(45,temblorendorchgdetailDto.getTemp1());
        dbManager.setString(46,temblorendorchgdetailDto.getTemp2());
        dbManager.setString(47,temblorendorchgdetailDto.getTemp3());
        dbManager.setString(48,temblorendorchgdetailDto.getTemp4());
        dbManager.setString(49,temblorendorchgdetailDto.getTemp5());
        dbManager.setString(50,temblorendorchgdetailDto.getCardtype());
        dbManager.setString(51,temblorendorchgdetailDto.getName());
        dbManager.setDouble(52,temblorendorchgdetailDto.getRateadjust1());
        dbManager.setDouble(53,temblorendorchgdetailDto.getRateadjust2());
        //设置条件字段;
        dbManager.setString(54,temblorendorchgdetailDto.getInusrelistcode());
        dbManager.setString(55,temblorendorchgdetailDto.getEndorseno());
        dbManager.setString(56,temblorendorchgdetailDto.getKindcode());
        dbManager.setString(57,temblorendorchgdetailDto.getItemcode());
        dbManager.setString(58,temblorendorchgdetailDto.getAddress());
        dbManager.setString(59,temblorendorchgdetailDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TemblorendorchgdetailDto
     * @throws Exception
     */
    public TemblorendorchgdetailDto findByPrimaryKey(String inusrelistcode,String endorseno,String kindcode,String itemcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Endorseno,");
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
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Flag,");
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
        buffer.append("FROM Temblorendorchgdetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,endorseno);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,address);
        dbManager.setString(6,idcard);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TemblorendorchgdetailDto temblorendorchgdetailDto = null;
        if(resultSet.next()){
            temblorendorchgdetailDto = new TemblorendorchgdetailDto();
            temblorendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,1));
            temblorendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,2));
            temblorendorchgdetailDto.setEndorseno(dbManager.getString(resultSet,3));
            temblorendorchgdetailDto.setKindcode(dbManager.getString(resultSet,4));
            temblorendorchgdetailDto.setItemcode(dbManager.getString(resultSet,5));
            temblorendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,6));
            temblorendorchgdetailDto.setCountrycode(dbManager.getString(resultSet,7));
            temblorendorchgdetailDto.setCitycode(dbManager.getString(resultSet,8));
            temblorendorchgdetailDto.setAddress(dbManager.getString(resultSet,9));
            temblorendorchgdetailDto.setZipcode(dbManager.getString(resultSet,10));
            temblorendorchgdetailDto.setLongitude(dbManager.getDouble(resultSet,11));
            temblorendorchgdetailDto.setLatitude(dbManager.getDouble(resultSet,12));
            temblorendorchgdetailDto.setItemtype(dbManager.getString(resultSet,13));
            temblorendorchgdetailDto.setBuilding(dbManager.getString(resultSet,14));
            temblorendorchgdetailDto.setFloor(dbManager.getInt(resultSet,15));
            temblorendorchgdetailDto.setArchitecture(dbManager.getString(resultSet,16));
            temblorendorchgdetailDto.setRemark(dbManager.getString(resultSet,17));
            temblorendorchgdetailDto.setArea(dbManager.getDouble(resultSet,18));
            temblorendorchgdetailDto.setBuildtime(dbManager.getString(resultSet,19));
            temblorendorchgdetailDto.setRepair(dbManager.getString(resultSet,20));
            temblorendorchgdetailDto.setRepairtime(dbManager.getString(resultSet,21));
            temblorendorchgdetailDto.setPropcerttype(dbManager.getString(resultSet,22));
            temblorendorchgdetailDto.setPropcertno(dbManager.getString(resultSet,23));
            temblorendorchgdetailDto.setClasscode(dbManager.getString(resultSet,24));
            temblorendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,25));
            temblorendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,26));
            temblorendorchgdetailDto.setRate(dbManager.getDouble(resultSet,27));
            temblorendorchgdetailDto.setPremium(dbManager.getDouble(resultSet,28));
            temblorendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,29));
            temblorendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,30));
            temblorendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,31));
            temblorendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,32));
            temblorendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            temblorendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,34));
            temblorendorchgdetailDto.setStarttime(dbManager.getString(resultSet,35));
            temblorendorchgdetailDto.setEndtime(dbManager.getString(resultSet,36));
            temblorendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,37));
            temblorendorchgdetailDto.setOpcode(dbManager.getString(resultSet,38));
            temblorendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,39));
            temblorendorchgdetailDto.setValidity(dbManager.getString(resultSet,40));
            temblorendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,41));
            temblorendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,42));
            temblorendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,43));
            temblorendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,44));
            temblorendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,45));
            temblorendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,46));
            temblorendorchgdetailDto.setChgsumamount(dbManager.getDouble(resultSet,47));
            temblorendorchgdetailDto.setChgsumpremium(dbManager.getDouble(resultSet,48));
            temblorendorchgdetailDto.setFlag(dbManager.getString(resultSet,49));
            temblorendorchgdetailDto.setTemp1(dbManager.getString(resultSet,50));
            temblorendorchgdetailDto.setTemp2(dbManager.getString(resultSet,51));
            temblorendorchgdetailDto.setTemp3(dbManager.getString(resultSet,52));
            temblorendorchgdetailDto.setTemp4(dbManager.getString(resultSet,53));
            temblorendorchgdetailDto.setTemp5(dbManager.getString(resultSet,54));
            temblorendorchgdetailDto.setCardtype(dbManager.getString(resultSet,55));
            temblorendorchgdetailDto.setIdcard(dbManager.getString(resultSet,56));
            temblorendorchgdetailDto.setName(dbManager.getString(resultSet,57));
            temblorendorchgdetailDto.setRateadjust1(dbManager.getDouble(resultSet,58));
            temblorendorchgdetailDto.setRateadjust2(dbManager.getDouble(resultSet,59));
        }
        resultSet.close();
        return temblorendorchgdetailDto;
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
        buffer.append("Endorseno,");
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
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Flag,");
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
        buffer.append("FROM Temblorendorchgdetail WHERE ");
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
        TemblorendorchgdetailDto temblorendorchgdetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorendorchgdetailDto = new TemblorendorchgdetailDto();
            temblorendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            temblorendorchgdetailDto.setEndorseno(dbManager.getString(resultSet,"Endorseno"));
            temblorendorchgdetailDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorendorchgdetailDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            temblorendorchgdetailDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorendorchgdetailDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorendorchgdetailDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorendorchgdetailDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorendorchgdetailDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorendorchgdetailDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorendorchgdetailDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorendorchgdetailDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorendorchgdetailDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorendorchgdetailDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorendorchgdetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorendorchgdetailDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorendorchgdetailDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorendorchgdetailDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorendorchgdetailDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorendorchgdetailDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorendorchgdetailDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorendorchgdetailDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            temblorendorchgdetailDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            temblorendorchgdetailDto.setPremium(dbManager.getDouble(resultSet,"Premium"));
            temblorendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            temblorendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            temblorendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            temblorendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            temblorendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            temblorendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            temblorendorchgdetailDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            temblorendorchgdetailDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            temblorendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            temblorendorchgdetailDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorendorchgdetailDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            temblorendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            temblorendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            temblorendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            temblorendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            temblorendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            temblorendorchgdetailDto.setChgsumamount(dbManager.getDouble(resultSet,"Chgsumamount"));
            temblorendorchgdetailDto.setChgsumpremium(dbManager.getDouble(resultSet,"Chgsumpremium"));
            temblorendorchgdetailDto.setFlag(dbManager.getString(resultSet,"Flag"));
            temblorendorchgdetailDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            temblorendorchgdetailDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            temblorendorchgdetailDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            temblorendorchgdetailDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            temblorendorchgdetailDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            temblorendorchgdetailDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorendorchgdetailDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorendorchgdetailDto.setName(dbManager.getString(resultSet,"Name"));
            temblorendorchgdetailDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            temblorendorchgdetailDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            collection.add(temblorendorchgdetailDto);
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
        buffer.append("DELETE FROM Temblorendorchgdetail WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorendorchgdetail WHERE ");
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
