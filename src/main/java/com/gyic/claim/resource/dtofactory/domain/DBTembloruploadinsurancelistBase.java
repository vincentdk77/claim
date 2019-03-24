package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TembloruploadinsurancelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORUPLOADINSURANCELIST的数据访问对象基类<br>
 */
public class DBTembloruploadinsurancelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTembloruploadinsurancelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBTembloruploadinsurancelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void insert(TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Tembloruploadinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
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
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Amount,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2,");
        buffer.append("Rate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getCitycode()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getAddress()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getZipcode()).append("',");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getLongitude()).append(",");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getLatitude()).append(",");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getItemtype()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getBuilding()).append("',");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getFloor()).append(",");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getRemark()).append("',");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getArea()).append(",");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getRepair()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getBreedingareacode()).append("',");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getFlag1()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getOperatedate()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getTemp5()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getCardtype()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getIdcard()).append("',");
            debugBuffer.append("'").append(tembloruploadinsurancelistDto.getName()).append("',");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getAmount()).append(",");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getRateadjust1()).append(",");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getRateadjust2()).append(",");
            debugBuffer.append("").append(tembloruploadinsurancelistDto.getRate()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,tembloruploadinsurancelistDto.getInusrelistcode());
        dbManager.setString(2,tembloruploadinsurancelistDto.getBusinessno());
        dbManager.setString(3,tembloruploadinsurancelistDto.getCountrycode());
        dbManager.setString(4,tembloruploadinsurancelistDto.getCitycode());
        dbManager.setString(5,tembloruploadinsurancelistDto.getAddress());
        dbManager.setString(6,tembloruploadinsurancelistDto.getZipcode());
        dbManager.setDouble(7,tembloruploadinsurancelistDto.getLongitude());
        dbManager.setDouble(8,tembloruploadinsurancelistDto.getLatitude());
        dbManager.setString(9,tembloruploadinsurancelistDto.getItemtype());
        dbManager.setString(10,tembloruploadinsurancelistDto.getBuilding());
        dbManager.setInt(11,tembloruploadinsurancelistDto.getFloor());
        dbManager.setString(12,tembloruploadinsurancelistDto.getArchitecture());
        dbManager.setString(13,tembloruploadinsurancelistDto.getRemark());
        dbManager.setDouble(14,tembloruploadinsurancelistDto.getArea());
        dbManager.setString(15,tembloruploadinsurancelistDto.getBuildtime());
        dbManager.setString(16,tembloruploadinsurancelistDto.getRepair());
        dbManager.setString(17,tembloruploadinsurancelistDto.getRepairtime());
        dbManager.setString(18,tembloruploadinsurancelistDto.getPropcerttype());
        dbManager.setString(19,tembloruploadinsurancelistDto.getPropcertno());
        dbManager.setString(20,tembloruploadinsurancelistDto.getIndexcode());
        dbManager.setString(21,tembloruploadinsurancelistDto.getBreedingareacode());
        dbManager.setDouble(22,tembloruploadinsurancelistDto.getAreanumber());
        dbManager.setString(23,tembloruploadinsurancelistDto.getFlag1());
        dbManager.setDateTime(24,tembloruploadinsurancelistDto.getOperatedate());
        dbManager.setString(25,tembloruploadinsurancelistDto.getTemp1());
        dbManager.setString(26,tembloruploadinsurancelistDto.getTemp2());
        dbManager.setString(27,tembloruploadinsurancelistDto.getTemp3());
        dbManager.setString(28,tembloruploadinsurancelistDto.getTemp4());
        dbManager.setString(29,tembloruploadinsurancelistDto.getTemp5());
        dbManager.setString(30,tembloruploadinsurancelistDto.getCardtype());
        dbManager.setString(31,tembloruploadinsurancelistDto.getIdcard());
        dbManager.setString(32,tembloruploadinsurancelistDto.getName());
        dbManager.setDouble(33,tembloruploadinsurancelistDto.getAmount());
        dbManager.setDouble(34,tembloruploadinsurancelistDto.getRateadjust1());
        dbManager.setDouble(35,tembloruploadinsurancelistDto.getRateadjust2());
        dbManager.setDouble(36,tembloruploadinsurancelistDto.getRate());
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
        buffer.append("INSERT INTO Tembloruploadinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
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
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Amount,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2,");
        buffer.append("Rate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TembloruploadinsurancelistDto tembloruploadinsurancelistDto = (TembloruploadinsurancelistDto)i.next();
            dbManager.setString(1,tembloruploadinsurancelistDto.getInusrelistcode());
            dbManager.setString(2,tembloruploadinsurancelistDto.getBusinessno());
            dbManager.setString(3,tembloruploadinsurancelistDto.getCountrycode());
            dbManager.setString(4,tembloruploadinsurancelistDto.getCitycode());
            dbManager.setString(5,tembloruploadinsurancelistDto.getAddress());
            dbManager.setString(6,tembloruploadinsurancelistDto.getZipcode());
            dbManager.setDouble(7,tembloruploadinsurancelistDto.getLongitude());
            dbManager.setDouble(8,tembloruploadinsurancelistDto.getLatitude());
            dbManager.setString(9,tembloruploadinsurancelistDto.getItemtype());
            dbManager.setString(10,tembloruploadinsurancelistDto.getBuilding());
            dbManager.setInt(11,tembloruploadinsurancelistDto.getFloor());
            dbManager.setString(12,tembloruploadinsurancelistDto.getArchitecture());
            dbManager.setString(13,tembloruploadinsurancelistDto.getRemark());
            dbManager.setDouble(14,tembloruploadinsurancelistDto.getArea());
            dbManager.setString(15,tembloruploadinsurancelistDto.getBuildtime());
            dbManager.setString(16,tembloruploadinsurancelistDto.getRepair());
            dbManager.setString(17,tembloruploadinsurancelistDto.getRepairtime());
            dbManager.setString(18,tembloruploadinsurancelistDto.getPropcerttype());
            dbManager.setString(19,tembloruploadinsurancelistDto.getPropcertno());
            dbManager.setString(20,tembloruploadinsurancelistDto.getIndexcode());
            dbManager.setString(21,tembloruploadinsurancelistDto.getBreedingareacode());
            dbManager.setDouble(22,tembloruploadinsurancelistDto.getAreanumber());
            dbManager.setString(23,tembloruploadinsurancelistDto.getFlag1());
            dbManager.setDateTime(24,tembloruploadinsurancelistDto.getOperatedate());
            dbManager.setString(25,tembloruploadinsurancelistDto.getTemp1());
            dbManager.setString(26,tembloruploadinsurancelistDto.getTemp2());
            dbManager.setString(27,tembloruploadinsurancelistDto.getTemp3());
            dbManager.setString(28,tembloruploadinsurancelistDto.getTemp4());
            dbManager.setString(29,tembloruploadinsurancelistDto.getTemp5());
            dbManager.setString(30,tembloruploadinsurancelistDto.getCardtype());
            dbManager.setString(31,tembloruploadinsurancelistDto.getIdcard());
            dbManager.setString(32,tembloruploadinsurancelistDto.getName());
            dbManager.setDouble(33,tembloruploadinsurancelistDto.getAmount());
            dbManager.setDouble(34,tembloruploadinsurancelistDto.getRateadjust1());
            dbManager.setDouble(35,tembloruploadinsurancelistDto.getRateadjust2());
            dbManager.setDouble(36,tembloruploadinsurancelistDto.getRate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(String inusrelistcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Tembloruploadinsurancelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,address);
        dbManager.setString(3,idcard);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void update(TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Tembloruploadinsurancelist SET ");
        buffer.append("Businessno = ?, ");
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
        buffer.append("Indexcode = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Areanumber = ?, ");
        buffer.append("Flag1 = ?, ");
        buffer.append("Operatedate = ?, ");
        buffer.append("Temp1 = ?, ");
        buffer.append("Temp2 = ?, ");
        buffer.append("Temp3 = ?, ");
        buffer.append("Temp4 = ?, ");
        buffer.append("Temp5 = ?, ");
        buffer.append("Cardtype = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Rateadjust1 = ?, ");
        buffer.append("Rateadjust2 = ?, ");
        buffer.append("Rate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Tembloruploadinsurancelist SET ");
            debugBuffer.append("Businessno = '" + tembloruploadinsurancelistDto.getBusinessno() + "', ");
            debugBuffer.append("Countrycode = '" + tembloruploadinsurancelistDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + tembloruploadinsurancelistDto.getCitycode() + "', ");
            debugBuffer.append("Zipcode = '" + tembloruploadinsurancelistDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + tembloruploadinsurancelistDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + tembloruploadinsurancelistDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + tembloruploadinsurancelistDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + tembloruploadinsurancelistDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + tembloruploadinsurancelistDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + tembloruploadinsurancelistDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + tembloruploadinsurancelistDto.getRemark() + "', ");
            debugBuffer.append("Area = " + tembloruploadinsurancelistDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + tembloruploadinsurancelistDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + tembloruploadinsurancelistDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + tembloruploadinsurancelistDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + tembloruploadinsurancelistDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + tembloruploadinsurancelistDto.getPropcertno() + "', ");
            debugBuffer.append("Indexcode = '" + tembloruploadinsurancelistDto.getIndexcode() + "', ");
            debugBuffer.append("Breedingareacode = '" + tembloruploadinsurancelistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Areanumber = " + tembloruploadinsurancelistDto.getAreanumber() + ", ");
            debugBuffer.append("Flag1 = '" + tembloruploadinsurancelistDto.getFlag1() + "', ");
            debugBuffer.append("Operatedate = '" + tembloruploadinsurancelistDto.getOperatedate() + "', ");
            debugBuffer.append("Temp1 = '" + tembloruploadinsurancelistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + tembloruploadinsurancelistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + tembloruploadinsurancelistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + tembloruploadinsurancelistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + tembloruploadinsurancelistDto.getTemp5() + "', ");
            debugBuffer.append("Cardtype = '" + tembloruploadinsurancelistDto.getCardtype() + "', ");
            debugBuffer.append("Name = '" + tembloruploadinsurancelistDto.getName() + "', ");
            debugBuffer.append("Amount = " + tembloruploadinsurancelistDto.getAmount() + ", ");
            debugBuffer.append("Rateadjust1 = " + tembloruploadinsurancelistDto.getRateadjust1() + ", ");
            debugBuffer.append("Rateadjust2 = " + tembloruploadinsurancelistDto.getRateadjust2() + ", ");
            debugBuffer.append("Rate = " + tembloruploadinsurancelistDto.getRate() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(tembloruploadinsurancelistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Address=").append("'").append(tembloruploadinsurancelistDto.getAddress()).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(tembloruploadinsurancelistDto.getIdcard()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,tembloruploadinsurancelistDto.getBusinessno());
        dbManager.setString(2,tembloruploadinsurancelistDto.getCountrycode());
        dbManager.setString(3,tembloruploadinsurancelistDto.getCitycode());
        dbManager.setString(4,tembloruploadinsurancelistDto.getZipcode());
        dbManager.setDouble(5,tembloruploadinsurancelistDto.getLongitude());
        dbManager.setDouble(6,tembloruploadinsurancelistDto.getLatitude());
        dbManager.setString(7,tembloruploadinsurancelistDto.getItemtype());
        dbManager.setString(8,tembloruploadinsurancelistDto.getBuilding());
        dbManager.setInt(9,tembloruploadinsurancelistDto.getFloor());
        dbManager.setString(10,tembloruploadinsurancelistDto.getArchitecture());
        dbManager.setString(11,tembloruploadinsurancelistDto.getRemark());
        dbManager.setDouble(12,tembloruploadinsurancelistDto.getArea());
        dbManager.setString(13,tembloruploadinsurancelistDto.getBuildtime());
        dbManager.setString(14,tembloruploadinsurancelistDto.getRepair());
        dbManager.setString(15,tembloruploadinsurancelistDto.getRepairtime());
        dbManager.setString(16,tembloruploadinsurancelistDto.getPropcerttype());
        dbManager.setString(17,tembloruploadinsurancelistDto.getPropcertno());
        dbManager.setString(18,tembloruploadinsurancelistDto.getIndexcode());
        dbManager.setString(19,tembloruploadinsurancelistDto.getBreedingareacode());
        dbManager.setDouble(20,tembloruploadinsurancelistDto.getAreanumber());
        dbManager.setString(21,tembloruploadinsurancelistDto.getFlag1());
        dbManager.setDateTime(22,tembloruploadinsurancelistDto.getOperatedate());
        dbManager.setString(23,tembloruploadinsurancelistDto.getTemp1());
        dbManager.setString(24,tembloruploadinsurancelistDto.getTemp2());
        dbManager.setString(25,tembloruploadinsurancelistDto.getTemp3());
        dbManager.setString(26,tembloruploadinsurancelistDto.getTemp4());
        dbManager.setString(27,tembloruploadinsurancelistDto.getTemp5());
        dbManager.setString(28,tembloruploadinsurancelistDto.getCardtype());
        dbManager.setString(29,tembloruploadinsurancelistDto.getName());
        dbManager.setDouble(30,tembloruploadinsurancelistDto.getAmount());
        dbManager.setDouble(31,tembloruploadinsurancelistDto.getRateadjust1());
        dbManager.setDouble(32,tembloruploadinsurancelistDto.getRateadjust2());
        dbManager.setDouble(33,tembloruploadinsurancelistDto.getRate());
        //设置条件字段;
        dbManager.setString(34,tembloruploadinsurancelistDto.getInusrelistcode());
        dbManager.setString(35,tembloruploadinsurancelistDto.getAddress());
        dbManager.setString(36,tembloruploadinsurancelistDto.getIdcard());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return TembloruploadinsurancelistDto
     * @throws Exception
     */
    public TembloruploadinsurancelistDto findByPrimaryKey(String inusrelistcode,String address,String idcard)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
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
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Amount,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2,");
        buffer.append("Rate ");
        buffer.append("FROM Tembloruploadinsurancelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Address=").append("'").append(address).append("' AND ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Address = ? And ");
        buffer.append("Idcard = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,address);
        dbManager.setString(3,idcard);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TembloruploadinsurancelistDto tembloruploadinsurancelistDto = null;
        if(resultSet.next()){
            tembloruploadinsurancelistDto = new TembloruploadinsurancelistDto();
            tembloruploadinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            tembloruploadinsurancelistDto.setBusinessno(dbManager.getString(resultSet,2));
            tembloruploadinsurancelistDto.setCountrycode(dbManager.getString(resultSet,3));
            tembloruploadinsurancelistDto.setCitycode(dbManager.getString(resultSet,4));
            tembloruploadinsurancelistDto.setAddress(dbManager.getString(resultSet,5));
            tembloruploadinsurancelistDto.setZipcode(dbManager.getString(resultSet,6));
            tembloruploadinsurancelistDto.setLongitude(dbManager.getDouble(resultSet,7));
            tembloruploadinsurancelistDto.setLatitude(dbManager.getDouble(resultSet,8));
            tembloruploadinsurancelistDto.setItemtype(dbManager.getString(resultSet,9));
            tembloruploadinsurancelistDto.setBuilding(dbManager.getString(resultSet,10));
            tembloruploadinsurancelistDto.setFloor(dbManager.getInt(resultSet,11));
            tembloruploadinsurancelistDto.setArchitecture(dbManager.getString(resultSet,12));
            tembloruploadinsurancelistDto.setRemark(dbManager.getString(resultSet,13));
            tembloruploadinsurancelistDto.setArea(dbManager.getDouble(resultSet,14));
            tembloruploadinsurancelistDto.setBuildtime(dbManager.getString(resultSet,15));
            tembloruploadinsurancelistDto.setRepair(dbManager.getString(resultSet,16));
            tembloruploadinsurancelistDto.setRepairtime(dbManager.getString(resultSet,17));
            tembloruploadinsurancelistDto.setPropcerttype(dbManager.getString(resultSet,18));
            tembloruploadinsurancelistDto.setPropcertno(dbManager.getString(resultSet,19));
            tembloruploadinsurancelistDto.setIndexcode(dbManager.getString(resultSet,20));
            tembloruploadinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,21));
            tembloruploadinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,22));
            tembloruploadinsurancelistDto.setFlag1(dbManager.getString(resultSet,23));
            tembloruploadinsurancelistDto.setOperatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            tembloruploadinsurancelistDto.setTemp1(dbManager.getString(resultSet,25));
            tembloruploadinsurancelistDto.setTemp2(dbManager.getString(resultSet,26));
            tembloruploadinsurancelistDto.setTemp3(dbManager.getString(resultSet,27));
            tembloruploadinsurancelistDto.setTemp4(dbManager.getString(resultSet,28));
            tembloruploadinsurancelistDto.setTemp5(dbManager.getString(resultSet,29));
            tembloruploadinsurancelistDto.setCardtype(dbManager.getString(resultSet,30));
            tembloruploadinsurancelistDto.setIdcard(dbManager.getString(resultSet,31));
            tembloruploadinsurancelistDto.setName(dbManager.getString(resultSet,32));
            tembloruploadinsurancelistDto.setAmount(dbManager.getDouble(resultSet,33));
            tembloruploadinsurancelistDto.setRateadjust1(dbManager.getDouble(resultSet,34));
            tembloruploadinsurancelistDto.setRateadjust2(dbManager.getDouble(resultSet,35));
            tembloruploadinsurancelistDto.setRate(dbManager.getDouble(resultSet,36));
        }
        resultSet.close();
        return tembloruploadinsurancelistDto;
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
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5,");
        buffer.append("Cardtype,");
        buffer.append("Idcard,");
        buffer.append("Name,");
        buffer.append("Amount,");
        buffer.append("Rateadjust1,");
        buffer.append("Rateadjust2,");
        buffer.append("Rate ");
        buffer.append("FROM Tembloruploadinsurancelist WHERE ");
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
        TembloruploadinsurancelistDto tembloruploadinsurancelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            tembloruploadinsurancelistDto = new TembloruploadinsurancelistDto();
            tembloruploadinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            tembloruploadinsurancelistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            tembloruploadinsurancelistDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            tembloruploadinsurancelistDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            tembloruploadinsurancelistDto.setAddress(dbManager.getString(resultSet,"Address"));
            tembloruploadinsurancelistDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            tembloruploadinsurancelistDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            tembloruploadinsurancelistDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            tembloruploadinsurancelistDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            tembloruploadinsurancelistDto.setBuilding(dbManager.getString(resultSet,"Building"));
            tembloruploadinsurancelistDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            tembloruploadinsurancelistDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            tembloruploadinsurancelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            tembloruploadinsurancelistDto.setArea(dbManager.getDouble(resultSet,"Area"));
            tembloruploadinsurancelistDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            tembloruploadinsurancelistDto.setRepair(dbManager.getString(resultSet,"Repair"));
            tembloruploadinsurancelistDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            tembloruploadinsurancelistDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            tembloruploadinsurancelistDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            tembloruploadinsurancelistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            tembloruploadinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            tembloruploadinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            tembloruploadinsurancelistDto.setFlag1(dbManager.getString(resultSet,"Flag1"));
            tembloruploadinsurancelistDto.setOperatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Operatedate"));
            tembloruploadinsurancelistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            tembloruploadinsurancelistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            tembloruploadinsurancelistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            tembloruploadinsurancelistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            tembloruploadinsurancelistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            tembloruploadinsurancelistDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            tembloruploadinsurancelistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            tembloruploadinsurancelistDto.setName(dbManager.getString(resultSet,"Name"));
            tembloruploadinsurancelistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            tembloruploadinsurancelistDto.setRateadjust1(dbManager.getDouble(resultSet,"Rateadjust1"));
            tembloruploadinsurancelistDto.setRateadjust2(dbManager.getDouble(resultSet,"Rateadjust2"));
            tembloruploadinsurancelistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            collection.add(tembloruploadinsurancelistDto);
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
        buffer.append("DELETE FROM Tembloruploadinsurancelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Tembloruploadinsurancelist WHERE ");
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
