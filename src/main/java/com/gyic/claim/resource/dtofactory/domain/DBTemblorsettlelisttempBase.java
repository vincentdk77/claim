package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELISTTEMP的数据访问对象基类<br>
 */
public class DBTemblorsettlelisttempBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorsettlelisttempBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTemblorsettlelisttempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void insert(TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
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
        buffer.append("Inusrelistcode,");
        buffer.append("Lossrate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Damagelevel,");
        buffer.append("Lossamount,");
        buffer.append("Settlesum,");
        buffer.append("Prepay,");
        buffer.append("Supplyprepay,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Suminsured,");
        buffer.append("Name ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getRegistcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getStringtimestamp()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorsettlelisttempDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getLossrate()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getValidity()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getSettledate()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getNodetype()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getDamagelevel()).append("',");
            debugBuffer.append("").append(temblorsettlelisttempDto.getLossamount()).append(",");
            debugBuffer.append("").append(temblorsettlelisttempDto.getSettlesum()).append(",");
            debugBuffer.append("").append(temblorsettlelisttempDto.getPrepay()).append(",");
            debugBuffer.append("").append(temblorsettlelisttempDto.getSupplyprepay()).append(",");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getIdcard()).append("',");
            debugBuffer.append("'").append(temblorsettlelisttempDto.getName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorsettlelisttempDto.getRegistcode());
        dbManager.setString(2,temblorsettlelisttempDto.getStringtimestamp());
        dbManager.setInt(3,temblorsettlelisttempDto.getIndexofsettle());
        dbManager.setString(4,temblorsettlelisttempDto.getKindcode());
        dbManager.setString(5,temblorsettlelisttempDto.getItemcode());
        dbManager.setString(6,temblorsettlelisttempDto.getClasscode());
        dbManager.setString(7,temblorsettlelisttempDto.getRiskcode());
        dbManager.setString(8,temblorsettlelisttempDto.getCountrycode());
        dbManager.setString(9,temblorsettlelisttempDto.getCitycode());
        dbManager.setString(10,temblorsettlelisttempDto.getAddress());
        dbManager.setString(11,temblorsettlelisttempDto.getZipcode());
        dbManager.setDouble(12,temblorsettlelisttempDto.getLongitude());
        dbManager.setDouble(13,temblorsettlelisttempDto.getLatitude());
        dbManager.setString(14,temblorsettlelisttempDto.getItemtype());
        dbManager.setString(15,temblorsettlelisttempDto.getBuilding());
        dbManager.setInt(16,temblorsettlelisttempDto.getFloor());
        dbManager.setString(17,temblorsettlelisttempDto.getArchitecture());
        dbManager.setString(18,temblorsettlelisttempDto.getRemark());
        dbManager.setDouble(19,temblorsettlelisttempDto.getArea());
        dbManager.setString(20,temblorsettlelisttempDto.getBuildtime());
        dbManager.setString(21,temblorsettlelisttempDto.getRepair());
        dbManager.setString(22,temblorsettlelisttempDto.getRepairtime());
        dbManager.setString(23,temblorsettlelisttempDto.getPropcerttype());
        dbManager.setString(24,temblorsettlelisttempDto.getPropcertno());
        dbManager.setString(25,temblorsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(26,temblorsettlelisttempDto.getLossrate());
        dbManager.setString(27,temblorsettlelisttempDto.getOpcode());
        dbManager.setDateTime(28,temblorsettlelisttempDto.getOptime());
        dbManager.setString(29,temblorsettlelisttempDto.getValidity());
        dbManager.setDateTime(30,temblorsettlelisttempDto.getSettledate());
        dbManager.setDouble(31,temblorsettlelisttempDto.getClaimrate());
        dbManager.setString(32,temblorsettlelisttempDto.getNodetype());
        dbManager.setString(33,temblorsettlelisttempDto.getDamagelevel());
        dbManager.setDouble(34,temblorsettlelisttempDto.getLossamount());
        dbManager.setDouble(35,temblorsettlelisttempDto.getSettlesum());
        dbManager.setDouble(36,temblorsettlelisttempDto.getPrepay());
        dbManager.setDouble(37,temblorsettlelisttempDto.getSupplyprepay());
        dbManager.setString(38,temblorsettlelisttempDto.getCardtype());
        dbManager.setString(39,temblorsettlelisttempDto.getIdcard());
        dbManager.setDouble(40,temblorsettlelisttempDto.getSuminsured());
        dbManager.setString(41,temblorsettlelisttempDto.getName());
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
        buffer.append("INSERT INTO Temblorsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
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
        buffer.append("Inusrelistcode,");
        buffer.append("Lossrate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Damagelevel,");
        buffer.append("Lossamount,");
        buffer.append("Settlesum,");
        buffer.append("Prepay,");
        buffer.append("Supplyprepay,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Suminsured,");
        buffer.append("Name ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TemblorsettlelisttempDto temblorsettlelisttempDto = (TemblorsettlelisttempDto)i.next();
            dbManager.setString(1,temblorsettlelisttempDto.getRegistcode());
            dbManager.setString(2,temblorsettlelisttempDto.getStringtimestamp());
            dbManager.setInt(3,temblorsettlelisttempDto.getIndexofsettle());
            dbManager.setString(4,temblorsettlelisttempDto.getKindcode());
            dbManager.setString(5,temblorsettlelisttempDto.getItemcode());
            dbManager.setString(6,temblorsettlelisttempDto.getClasscode());
            dbManager.setString(7,temblorsettlelisttempDto.getRiskcode());
            dbManager.setString(8,temblorsettlelisttempDto.getCountrycode());
            dbManager.setString(9,temblorsettlelisttempDto.getCitycode());
            dbManager.setString(10,temblorsettlelisttempDto.getAddress());
            dbManager.setString(11,temblorsettlelisttempDto.getZipcode());
            dbManager.setDouble(12,temblorsettlelisttempDto.getLongitude());
            dbManager.setDouble(13,temblorsettlelisttempDto.getLatitude());
            dbManager.setString(14,temblorsettlelisttempDto.getItemtype());
            dbManager.setString(15,temblorsettlelisttempDto.getBuilding());
            dbManager.setInt(16,temblorsettlelisttempDto.getFloor());
            dbManager.setString(17,temblorsettlelisttempDto.getArchitecture());
            dbManager.setString(18,temblorsettlelisttempDto.getRemark());
            dbManager.setDouble(19,temblorsettlelisttempDto.getArea());
            dbManager.setString(20,temblorsettlelisttempDto.getBuildtime());
            dbManager.setString(21,temblorsettlelisttempDto.getRepair());
            dbManager.setString(22,temblorsettlelisttempDto.getRepairtime());
            dbManager.setString(23,temblorsettlelisttempDto.getPropcerttype());
            dbManager.setString(24,temblorsettlelisttempDto.getPropcertno());
            dbManager.setString(25,temblorsettlelisttempDto.getInusrelistcode());
            dbManager.setDouble(26,temblorsettlelisttempDto.getLossrate());
            dbManager.setString(27,temblorsettlelisttempDto.getOpcode());
            dbManager.setDateTime(28,temblorsettlelisttempDto.getOptime());
            dbManager.setString(29,temblorsettlelisttempDto.getValidity());
            dbManager.setDateTime(30,temblorsettlelisttempDto.getSettledate());
            dbManager.setDouble(31,temblorsettlelisttempDto.getClaimrate());
            dbManager.setString(32,temblorsettlelisttempDto.getNodetype());
            dbManager.setString(33,temblorsettlelisttempDto.getDamagelevel());
            dbManager.setDouble(34,temblorsettlelisttempDto.getLossamount());
            dbManager.setDouble(35,temblorsettlelisttempDto.getSettlesum());
            dbManager.setDouble(36,temblorsettlelisttempDto.getPrepay());
            dbManager.setDouble(37,temblorsettlelisttempDto.getSupplyprepay());
            dbManager.setString(38,temblorsettlelisttempDto.getCardtype());
            dbManager.setString(39,temblorsettlelisttempDto.getIdcard());
            dbManager.setDouble(40,temblorsettlelisttempDto.getSuminsured());
            dbManager.setString(41,temblorsettlelisttempDto.getName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorsettlelisttemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(registcode).append("' AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(stringtimestamp).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Stringtimestamp = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registcode);
        dbManager.setString(2,stringtimestamp);
        dbManager.setInt(3,indexofsettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void update(TemblorsettlelisttempDto temblorsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorsettlelisttemp SET ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Itemcode = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Countrycode = ?, ");
        buffer.append("Citycode = ?, ");
        buffer.append("Address = ?, ");
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
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Lossrate = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Settledate = ?, ");
        buffer.append("Claimrate = ?, ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Damagelevel = ?, ");
        buffer.append("Lossamount = ?, ");
        buffer.append("Settlesum = ?, ");
        buffer.append("Prepay = ?, ");
        buffer.append("Supplyprepay = ?, ");
        buffer.append("Cardtype = ?, ");
        buffer.append("Idcard = ?, ");
        buffer.append("Suminsured = ?, ");
        buffer.append("Name = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Temblorsettlelisttemp SET ");
            debugBuffer.append("Kindcode = '" + temblorsettlelisttempDto.getKindcode() + "', ");
            debugBuffer.append("Itemcode = '" + temblorsettlelisttempDto.getItemcode() + "', ");
            debugBuffer.append("Classcode = '" + temblorsettlelisttempDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorsettlelisttempDto.getRiskcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorsettlelisttempDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorsettlelisttempDto.getCitycode() + "', ");
            debugBuffer.append("Address = '" + temblorsettlelisttempDto.getAddress() + "', ");
            debugBuffer.append("Zipcode = '" + temblorsettlelisttempDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorsettlelisttempDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorsettlelisttempDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorsettlelisttempDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorsettlelisttempDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorsettlelisttempDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorsettlelisttempDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorsettlelisttempDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorsettlelisttempDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorsettlelisttempDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorsettlelisttempDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorsettlelisttempDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorsettlelisttempDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorsettlelisttempDto.getPropcertno() + "', ");
            debugBuffer.append("Inusrelistcode = '" + temblorsettlelisttempDto.getInusrelistcode() + "', ");
            debugBuffer.append("Lossrate = " + temblorsettlelisttempDto.getLossrate() + ", ");
            debugBuffer.append("Opcode = '" + temblorsettlelisttempDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorsettlelisttempDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorsettlelisttempDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + temblorsettlelisttempDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + temblorsettlelisttempDto.getClaimrate() + ", ");
            debugBuffer.append("Nodetype = '" + temblorsettlelisttempDto.getNodetype() + "', ");
            debugBuffer.append("Damagelevel = '" + temblorsettlelisttempDto.getDamagelevel() + "', ");
            debugBuffer.append("Lossamount = " + temblorsettlelisttempDto.getLossamount() + ", ");
            debugBuffer.append("Settlesum = " + temblorsettlelisttempDto.getSettlesum() + ", ");
            debugBuffer.append("Prepay = " + temblorsettlelisttempDto.getPrepay() + ", ");
            debugBuffer.append("Supplyprepay = " + temblorsettlelisttempDto.getSupplyprepay() + ", ");
            debugBuffer.append("Cardtype = '" + temblorsettlelisttempDto.getCardtype() + "', ");
            debugBuffer.append("Idcard = '" + temblorsettlelisttempDto.getIdcard() + "', ");
            debugBuffer.append("Name = '" + temblorsettlelisttempDto.getName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(temblorsettlelisttempDto.getRegistcode()).append("' AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(temblorsettlelisttempDto.getStringtimestamp()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(temblorsettlelisttempDto.getIndexofsettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Stringtimestamp = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,temblorsettlelisttempDto.getKindcode());
        dbManager.setString(2,temblorsettlelisttempDto.getItemcode());
        dbManager.setString(3,temblorsettlelisttempDto.getClasscode());
        dbManager.setString(4,temblorsettlelisttempDto.getRiskcode());
        dbManager.setString(5,temblorsettlelisttempDto.getCountrycode());
        dbManager.setString(6,temblorsettlelisttempDto.getCitycode());
        dbManager.setString(7,temblorsettlelisttempDto.getAddress());
        dbManager.setString(8,temblorsettlelisttempDto.getZipcode());
        dbManager.setDouble(9,temblorsettlelisttempDto.getLongitude());
        dbManager.setDouble(10,temblorsettlelisttempDto.getLatitude());
        dbManager.setString(11,temblorsettlelisttempDto.getItemtype());
        dbManager.setString(12,temblorsettlelisttempDto.getBuilding());
        dbManager.setInt(13,temblorsettlelisttempDto.getFloor());
        dbManager.setString(14,temblorsettlelisttempDto.getArchitecture());
        dbManager.setString(15,temblorsettlelisttempDto.getRemark());
        dbManager.setDouble(16,temblorsettlelisttempDto.getArea());
        dbManager.setString(17,temblorsettlelisttempDto.getBuildtime());
        dbManager.setString(18,temblorsettlelisttempDto.getRepair());
        dbManager.setString(19,temblorsettlelisttempDto.getRepairtime());
        dbManager.setString(20,temblorsettlelisttempDto.getPropcerttype());
        dbManager.setString(21,temblorsettlelisttempDto.getPropcertno());
        dbManager.setString(22,temblorsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(23,temblorsettlelisttempDto.getLossrate());
        dbManager.setString(24,temblorsettlelisttempDto.getOpcode());
        dbManager.setDateTime(25,temblorsettlelisttempDto.getOptime());
        dbManager.setString(26,temblorsettlelisttempDto.getValidity());
        dbManager.setDateTime(27,temblorsettlelisttempDto.getSettledate());
        dbManager.setDouble(28,temblorsettlelisttempDto.getClaimrate());
        dbManager.setString(29,temblorsettlelisttempDto.getNodetype());
        dbManager.setString(30,temblorsettlelisttempDto.getDamagelevel());
        dbManager.setDouble(31,temblorsettlelisttempDto.getLossamount());
        dbManager.setDouble(32,temblorsettlelisttempDto.getSettlesum());
        dbManager.setDouble(33,temblorsettlelisttempDto.getPrepay());
        dbManager.setDouble(34,temblorsettlelisttempDto.getSupplyprepay());
        dbManager.setString(35,temblorsettlelisttempDto.getCardtype());
        dbManager.setString(36,temblorsettlelisttempDto.getIdcard());
        dbManager.setDouble(37,temblorsettlelisttempDto.getSuminsured());
        dbManager.setString(38,temblorsettlelisttempDto.getName());
        //设置条件字段;
        dbManager.setString(39,temblorsettlelisttempDto.getRegistcode());
        dbManager.setString(40,temblorsettlelisttempDto.getStringtimestamp());
        dbManager.setInt(41,temblorsettlelisttempDto.getIndexofsettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return TemblorsettlelisttempDto
     * @throws Exception
     */
    public TemblorsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
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
        buffer.append("Inusrelistcode,");
        buffer.append("Lossrate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Damagelevel,");
        buffer.append("Lossamount,");
        buffer.append("Settlesum,");
        buffer.append("Prepay,");
        buffer.append("Supplyprepay,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Suminsured,");
        buffer.append("Name ");
        buffer.append("FROM Temblorsettlelisttemp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(registcode).append("' AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(stringtimestamp).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Stringtimestamp = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registcode);
        dbManager.setString(2,stringtimestamp);
        dbManager.setInt(3,indexofsettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        if(resultSet.next()){
            temblorsettlelisttempDto = new TemblorsettlelisttempDto();
            temblorsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,1));
            temblorsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,2));
            temblorsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,3));
            temblorsettlelisttempDto.setKindcode(dbManager.getString(resultSet,4));
            temblorsettlelisttempDto.setItemcode(dbManager.getString(resultSet,5));
            temblorsettlelisttempDto.setClasscode(dbManager.getString(resultSet,6));
            temblorsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,7));
            temblorsettlelisttempDto.setCountrycode(dbManager.getString(resultSet,8));
            temblorsettlelisttempDto.setCitycode(dbManager.getString(resultSet,9));
            temblorsettlelisttempDto.setAddress(dbManager.getString(resultSet,10));
            temblorsettlelisttempDto.setZipcode(dbManager.getString(resultSet,11));
            temblorsettlelisttempDto.setLongitude(dbManager.getDouble(resultSet,12));
            temblorsettlelisttempDto.setLatitude(dbManager.getDouble(resultSet,13));
            temblorsettlelisttempDto.setItemtype(dbManager.getString(resultSet,14));
            temblorsettlelisttempDto.setBuilding(dbManager.getString(resultSet,15));
            temblorsettlelisttempDto.setFloor(dbManager.getInt(resultSet,16));
            temblorsettlelisttempDto.setArchitecture(dbManager.getString(resultSet,17));
            temblorsettlelisttempDto.setRemark(dbManager.getString(resultSet,18));
            temblorsettlelisttempDto.setArea(dbManager.getDouble(resultSet,19));
            temblorsettlelisttempDto.setBuildtime(dbManager.getString(resultSet,20));
            temblorsettlelisttempDto.setRepair(dbManager.getString(resultSet,21));
            temblorsettlelisttempDto.setRepairtime(dbManager.getString(resultSet,22));
            temblorsettlelisttempDto.setPropcerttype(dbManager.getString(resultSet,23));
            temblorsettlelisttempDto.setPropcertno(dbManager.getString(resultSet,24));
            temblorsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,25));
            temblorsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,26));
            temblorsettlelisttempDto.setOpcode(dbManager.getString(resultSet,27));
            temblorsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,28));
            temblorsettlelisttempDto.setValidity(dbManager.getString(resultSet,29));
            temblorsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            temblorsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,31));
            temblorsettlelisttempDto.setNodetype(dbManager.getString(resultSet,32));
            temblorsettlelisttempDto.setDamagelevel(dbManager.getString(resultSet,33));
            temblorsettlelisttempDto.setLossamount(dbManager.getDouble(resultSet,34));
            temblorsettlelisttempDto.setSettlesum(dbManager.getDouble(resultSet,35));
            temblorsettlelisttempDto.setPrepay(dbManager.getDouble(resultSet,36));
            temblorsettlelisttempDto.setSupplyprepay(dbManager.getDouble(resultSet,37));
            temblorsettlelisttempDto.setCardtype(dbManager.getString(resultSet,38));
            temblorsettlelisttempDto.setIdcard(dbManager.getString(resultSet,39));
            temblorsettlelisttempDto.setSuminsured(dbManager.getDouble(resultSet,40));
            temblorsettlelisttempDto.setName(dbManager.getString(resultSet,41));
        }
        resultSet.close();
        return temblorsettlelisttempDto;
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
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
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
        buffer.append("Inusrelistcode,");
        buffer.append("Lossrate,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Damagelevel,");
        buffer.append("Lossamount,");
        buffer.append("Settlesum,");
        buffer.append("Prepay,");
        buffer.append("Supplyprepay,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Suminsured,");
        buffer.append("Name ");
        buffer.append("FROM Temblorsettlelisttemp WHERE ");
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
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorsettlelisttempDto = new TemblorsettlelisttempDto();
            temblorsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,"Registcode"));
            temblorsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,"Stringtimestamp"));
            temblorsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            temblorsettlelisttempDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorsettlelisttempDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorsettlelisttempDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorsettlelisttempDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorsettlelisttempDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorsettlelisttempDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorsettlelisttempDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorsettlelisttempDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorsettlelisttempDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorsettlelisttempDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorsettlelisttempDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorsettlelisttempDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorsettlelisttempDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorsettlelisttempDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorsettlelisttempDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorsettlelisttempDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorsettlelisttempDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorsettlelisttempDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorsettlelisttempDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorsettlelisttempDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            temblorsettlelisttempDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorsettlelisttempDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            temblorsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            temblorsettlelisttempDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            temblorsettlelisttempDto.setDamagelevel(dbManager.getString(resultSet,"Damagelevel"));
            temblorsettlelisttempDto.setLossamount(dbManager.getDouble(resultSet,"Lossamount"));
            temblorsettlelisttempDto.setSettlesum(dbManager.getDouble(resultSet,"Settlesum"));
            temblorsettlelisttempDto.setPrepay(dbManager.getDouble(resultSet,"Prepay"));
            temblorsettlelisttempDto.setSupplyprepay(dbManager.getDouble(resultSet,"Supplyprepay"));
            temblorsettlelisttempDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorsettlelisttempDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorsettlelisttempDto.setSuminsured(dbManager.getDouble(resultSet,"Suminsured"));
            temblorsettlelisttempDto.setName(dbManager.getString(resultSet,"Name"));
            collection.add(temblorsettlelisttempDto);
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
        buffer.append("DELETE FROM Temblorsettlelisttemp WHERE ");
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
        buffer.append("SELECT count(*) FROM Temblorsettlelisttemp WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM TemblorSettleListTemp WHERE ");
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
