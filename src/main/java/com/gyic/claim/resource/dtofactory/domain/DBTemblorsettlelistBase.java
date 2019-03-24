package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELIST�����ݷ��ʶ������<br>
 */
public class DBTemblorsettlelistBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBTemblorsettlelistBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBTemblorsettlelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void insert(TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorsettlelist (");
        buffer.append("Settlelistcode,");
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
            debugBuffer.append("'").append(temblorsettlelistDto.getSettlelistcode()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getCountrycode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getCitycode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getAddress()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getZipcode()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getLongitude()).append(",");
            debugBuffer.append("").append(temblorsettlelistDto.getLatitude()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getItemtype()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getBuilding()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getFloor()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getArchitecture()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getRemark()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getArea()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getBuildtime()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getRepair()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getRepairtime()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getPropcerttype()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getPropcertno()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getLossrate()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getSettledate()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getNodetype()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getDamagelevel()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getLossamount()).append(",");
            debugBuffer.append("").append(temblorsettlelistDto.getSettlesum()).append(",");
            debugBuffer.append("").append(temblorsettlelistDto.getPrepay()).append(",");
            debugBuffer.append("").append(temblorsettlelistDto.getSupplyprepay()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getCardtype()).append("',");
            debugBuffer.append("'").append(temblorsettlelistDto.getIdcard()).append("',");
            debugBuffer.append("").append(temblorsettlelistDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(temblorsettlelistDto.getName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,temblorsettlelistDto.getSettlelistcode());
        dbManager.setInt(2,temblorsettlelistDto.getIndexofsettle());
        dbManager.setString(3,temblorsettlelistDto.getKindcode());
        dbManager.setString(4,temblorsettlelistDto.getItemcode());
        dbManager.setString(5,temblorsettlelistDto.getClasscode());
        dbManager.setString(6,temblorsettlelistDto.getRiskcode());
        dbManager.setString(7,temblorsettlelistDto.getCountrycode());
        dbManager.setString(8,temblorsettlelistDto.getCitycode());
        dbManager.setString(9,temblorsettlelistDto.getAddress());
        dbManager.setString(10,temblorsettlelistDto.getZipcode());
        dbManager.setDouble(11,temblorsettlelistDto.getLongitude());
        dbManager.setDouble(12,temblorsettlelistDto.getLatitude());
        dbManager.setString(13,temblorsettlelistDto.getItemtype());
        dbManager.setString(14,temblorsettlelistDto.getBuilding());
        dbManager.setInt(15,temblorsettlelistDto.getFloor());
        dbManager.setString(16,temblorsettlelistDto.getArchitecture());
        dbManager.setString(17,temblorsettlelistDto.getRemark());
        dbManager.setDouble(18,temblorsettlelistDto.getArea());
        dbManager.setString(19,temblorsettlelistDto.getBuildtime());
        dbManager.setString(20,temblorsettlelistDto.getRepair());
        dbManager.setString(21,temblorsettlelistDto.getRepairtime());
        dbManager.setString(22,temblorsettlelistDto.getPropcerttype());
        dbManager.setString(23,temblorsettlelistDto.getPropcertno());
        dbManager.setString(24,temblorsettlelistDto.getInusrelistcode());
        dbManager.setDouble(25,temblorsettlelistDto.getLossrate());
        dbManager.setString(26,temblorsettlelistDto.getOpcode());
        dbManager.setDateTime(27,temblorsettlelistDto.getOptime());
        dbManager.setString(28,temblorsettlelistDto.getValidity());
        dbManager.setDateTime(29,temblorsettlelistDto.getSettledate());
        dbManager.setDouble(30,temblorsettlelistDto.getClaimrate());
        dbManager.setString(31,temblorsettlelistDto.getNodetype());
        dbManager.setString(32,temblorsettlelistDto.getDamagelevel());
        dbManager.setDouble(33,temblorsettlelistDto.getLossamount());
        dbManager.setDouble(34,temblorsettlelistDto.getSettlesum());
        dbManager.setDouble(35,temblorsettlelistDto.getPrepay());
        dbManager.setDouble(36,temblorsettlelistDto.getSupplyprepay());
        dbManager.setString(37,temblorsettlelistDto.getCardtype());
        dbManager.setString(38,temblorsettlelistDto.getIdcard());
        dbManager.setDouble(39,temblorsettlelistDto.getSuminsured());
        dbManager.setString(40,temblorsettlelistDto.getName());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Temblorsettlelist (");
        buffer.append("Settlelistcode,");
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
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            TemblorsettlelistDto temblorsettlelistDto = (TemblorsettlelistDto)i.next();
            dbManager.setString(1,temblorsettlelistDto.getSettlelistcode());
            dbManager.setInt(2,temblorsettlelistDto.getIndexofsettle());
            dbManager.setString(3,temblorsettlelistDto.getKindcode());
            dbManager.setString(4,temblorsettlelistDto.getItemcode());
            dbManager.setString(5,temblorsettlelistDto.getClasscode());
            dbManager.setString(6,temblorsettlelistDto.getRiskcode());
            dbManager.setString(7,temblorsettlelistDto.getCountrycode());
            dbManager.setString(8,temblorsettlelistDto.getCitycode());
            dbManager.setString(9,temblorsettlelistDto.getAddress());
            dbManager.setString(10,temblorsettlelistDto.getZipcode());
            dbManager.setDouble(11,temblorsettlelistDto.getLongitude());
            dbManager.setDouble(12,temblorsettlelistDto.getLatitude());
            dbManager.setString(13,temblorsettlelistDto.getItemtype());
            dbManager.setString(14,temblorsettlelistDto.getBuilding());
            dbManager.setInt(15,temblorsettlelistDto.getFloor());
            dbManager.setString(16,temblorsettlelistDto.getArchitecture());
            dbManager.setString(17,temblorsettlelistDto.getRemark());
            dbManager.setDouble(18,temblorsettlelistDto.getArea());
            dbManager.setString(19,temblorsettlelistDto.getBuildtime());
            dbManager.setString(20,temblorsettlelistDto.getRepair());
            dbManager.setString(21,temblorsettlelistDto.getRepairtime());
            dbManager.setString(22,temblorsettlelistDto.getPropcerttype());
            dbManager.setString(23,temblorsettlelistDto.getPropcertno());
            dbManager.setString(24,temblorsettlelistDto.getInusrelistcode());
            dbManager.setDouble(25,temblorsettlelistDto.getLossrate());
            dbManager.setString(26,temblorsettlelistDto.getOpcode());
            dbManager.setDateTime(27,temblorsettlelistDto.getOptime());
            dbManager.setString(28,temblorsettlelistDto.getValidity());
            dbManager.setDateTime(29,temblorsettlelistDto.getSettledate());
            dbManager.setDouble(30,temblorsettlelistDto.getClaimrate());
            dbManager.setString(31,temblorsettlelistDto.getNodetype());
            dbManager.setString(32,temblorsettlelistDto.getDamagelevel());
            dbManager.setDouble(33,temblorsettlelistDto.getLossamount());
            dbManager.setDouble(34,temblorsettlelistDto.getSettlesum());
            dbManager.setDouble(35,temblorsettlelistDto.getPrepay());
            dbManager.setDouble(36,temblorsettlelistDto.getSupplyprepay());
            dbManager.setString(37,temblorsettlelistDto.getCardtype());
            dbManager.setString(38,temblorsettlelistDto.getIdcard());
            dbManager.setDouble(39,temblorsettlelistDto.getSuminsured());
            dbManager.setString(40,temblorsettlelistDto.getName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append(" AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,settlelistcode);
        dbManager.setInt(2,indexofsettle);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,nodetype);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void update(TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Temblorsettlelist SET ");
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
            debugBuffer.append("UPDATE Temblorsettlelist SET ");
            debugBuffer.append("Classcode = '" + temblorsettlelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + temblorsettlelistDto.getRiskcode() + "', ");
            debugBuffer.append("Countrycode = '" + temblorsettlelistDto.getCountrycode() + "', ");
            debugBuffer.append("Citycode = '" + temblorsettlelistDto.getCitycode() + "', ");
            debugBuffer.append("Address = '" + temblorsettlelistDto.getAddress() + "', ");
            debugBuffer.append("Zipcode = '" + temblorsettlelistDto.getZipcode() + "', ");
            debugBuffer.append("Longitude = " + temblorsettlelistDto.getLongitude() + ", ");
            debugBuffer.append("Latitude = " + temblorsettlelistDto.getLatitude() + ", ");
            debugBuffer.append("Itemtype = '" + temblorsettlelistDto.getItemtype() + "', ");
            debugBuffer.append("Building = '" + temblorsettlelistDto.getBuilding() + "', ");
            debugBuffer.append("Floor = " + temblorsettlelistDto.getFloor() + ", ");
            debugBuffer.append("Architecture = '" + temblorsettlelistDto.getArchitecture() + "', ");
            debugBuffer.append("Remark = '" + temblorsettlelistDto.getRemark() + "', ");
            debugBuffer.append("Area = " + temblorsettlelistDto.getArea() + ", ");
            debugBuffer.append("Buildtime = '" + temblorsettlelistDto.getBuildtime() + "', ");
            debugBuffer.append("Repair = '" + temblorsettlelistDto.getRepair() + "', ");
            debugBuffer.append("Repairtime = '" + temblorsettlelistDto.getRepairtime() + "', ");
            debugBuffer.append("Propcerttype = '" + temblorsettlelistDto.getPropcerttype() + "', ");
            debugBuffer.append("Propcertno = '" + temblorsettlelistDto.getPropcertno() + "', ");
            debugBuffer.append("Inusrelistcode = '" + temblorsettlelistDto.getInusrelistcode() + "', ");
            debugBuffer.append("Lossrate = " + temblorsettlelistDto.getLossrate() + ", ");
            debugBuffer.append("Opcode = '" + temblorsettlelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + temblorsettlelistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + temblorsettlelistDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + temblorsettlelistDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + temblorsettlelistDto.getClaimrate() + ", ");
            debugBuffer.append("Damagelevel = '" + temblorsettlelistDto.getDamagelevel() + "', ");
            debugBuffer.append("Lossamount = " + temblorsettlelistDto.getLossamount() + ", ");
            debugBuffer.append("Settlesum = " + temblorsettlelistDto.getSettlesum() + ", ");
            debugBuffer.append("Prepay = " + temblorsettlelistDto.getPrepay() + ", ");
            debugBuffer.append("Supplyprepay = " + temblorsettlelistDto.getSupplyprepay() + ", ");
            debugBuffer.append("Cardtype = '" + temblorsettlelistDto.getCardtype() + "', ");
            debugBuffer.append("Idcard = '" + temblorsettlelistDto.getIdcard() + "', ");
            debugBuffer.append("Name = '" + temblorsettlelistDto.getName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(temblorsettlelistDto.getSettlelistcode()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(temblorsettlelistDto.getIndexofsettle()).append(" AND ");
            debugBuffer.append("Kindcode=").append("'").append(temblorsettlelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(temblorsettlelistDto.getItemcode()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(temblorsettlelistDto.getNodetype()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,temblorsettlelistDto.getClasscode());
        dbManager.setString(2,temblorsettlelistDto.getRiskcode());
        dbManager.setString(3,temblorsettlelistDto.getCountrycode());
        dbManager.setString(4,temblorsettlelistDto.getCitycode());
        dbManager.setString(5,temblorsettlelistDto.getAddress());
        dbManager.setString(6,temblorsettlelistDto.getZipcode());
        dbManager.setDouble(7,temblorsettlelistDto.getLongitude());
        dbManager.setDouble(8,temblorsettlelistDto.getLatitude());
        dbManager.setString(9,temblorsettlelistDto.getItemtype());
        dbManager.setString(10,temblorsettlelistDto.getBuilding());
        dbManager.setInt(11,temblorsettlelistDto.getFloor());
        dbManager.setString(12,temblorsettlelistDto.getArchitecture());
        dbManager.setString(13,temblorsettlelistDto.getRemark());
        dbManager.setDouble(14,temblorsettlelistDto.getArea());
        dbManager.setString(15,temblorsettlelistDto.getBuildtime());
        dbManager.setString(16,temblorsettlelistDto.getRepair());
        dbManager.setString(17,temblorsettlelistDto.getRepairtime());
        dbManager.setString(18,temblorsettlelistDto.getPropcerttype());
        dbManager.setString(19,temblorsettlelistDto.getPropcertno());
        dbManager.setString(20,temblorsettlelistDto.getInusrelistcode());
        dbManager.setDouble(21,temblorsettlelistDto.getLossrate());
        dbManager.setString(22,temblorsettlelistDto.getOpcode());
        dbManager.setDateTime(23,temblorsettlelistDto.getOptime());
        dbManager.setString(24,temblorsettlelistDto.getValidity());
        dbManager.setDateTime(25,temblorsettlelistDto.getSettledate());
        dbManager.setDouble(26,temblorsettlelistDto.getClaimrate());
        dbManager.setString(27,temblorsettlelistDto.getDamagelevel());
        dbManager.setDouble(28,temblorsettlelistDto.getLossamount());
        dbManager.setDouble(29,temblorsettlelistDto.getSettlesum());
        dbManager.setDouble(30,temblorsettlelistDto.getPrepay());
        dbManager.setDouble(31,temblorsettlelistDto.getSupplyprepay());
        dbManager.setString(32,temblorsettlelistDto.getCardtype());
        dbManager.setString(33,temblorsettlelistDto.getIdcard());
        dbManager.setDouble(34,temblorsettlelistDto.getSuminsured());
        dbManager.setString(35,temblorsettlelistDto.getName());
        //���������ֶ�;
        dbManager.setString(36,temblorsettlelistDto.getSettlelistcode());
        dbManager.setInt(37,temblorsettlelistDto.getIndexofsettle());
        dbManager.setString(38,temblorsettlelistDto.getKindcode());
        dbManager.setString(39,temblorsettlelistDto.getItemcode());
        dbManager.setString(40,temblorsettlelistDto.getNodetype());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @return TemblorsettlelistDto
     * @throws Exception
     */
    public TemblorsettlelistDto findByPrimaryKey(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
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
        buffer.append("FROM Temblorsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append(" AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Indexofsettle = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,settlelistcode);
        dbManager.setInt(2,indexofsettle);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,nodetype);
        ResultSet resultSet = dbManager.executePreparedQuery();
        TemblorsettlelistDto temblorsettlelistDto = null;
        if(resultSet.next()){
            temblorsettlelistDto = new TemblorsettlelistDto();
            temblorsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,1));
            temblorsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,2));
            temblorsettlelistDto.setKindcode(dbManager.getString(resultSet,3));
            temblorsettlelistDto.setItemcode(dbManager.getString(resultSet,4));
            temblorsettlelistDto.setClasscode(dbManager.getString(resultSet,5));
            temblorsettlelistDto.setRiskcode(dbManager.getString(resultSet,6));
            temblorsettlelistDto.setCountrycode(dbManager.getString(resultSet,7));
            temblorsettlelistDto.setCitycode(dbManager.getString(resultSet,8));
            temblorsettlelistDto.setAddress(dbManager.getString(resultSet,9));
            temblorsettlelistDto.setZipcode(dbManager.getString(resultSet,10));
            temblorsettlelistDto.setLongitude(dbManager.getDouble(resultSet,11));
            temblorsettlelistDto.setLatitude(dbManager.getDouble(resultSet,12));
            temblorsettlelistDto.setItemtype(dbManager.getString(resultSet,13));
            temblorsettlelistDto.setBuilding(dbManager.getString(resultSet,14));
            temblorsettlelistDto.setFloor(dbManager.getInt(resultSet,15));
            temblorsettlelistDto.setArchitecture(dbManager.getString(resultSet,16));
            temblorsettlelistDto.setRemark(dbManager.getString(resultSet,17));
            temblorsettlelistDto.setArea(dbManager.getDouble(resultSet,18));
            temblorsettlelistDto.setBuildtime(dbManager.getString(resultSet,19));
            temblorsettlelistDto.setRepair(dbManager.getString(resultSet,20));
            temblorsettlelistDto.setRepairtime(dbManager.getString(resultSet,21));
            temblorsettlelistDto.setPropcerttype(dbManager.getString(resultSet,22));
            temblorsettlelistDto.setPropcertno(dbManager.getString(resultSet,23));
            temblorsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,24));
            temblorsettlelistDto.setLossrate(dbManager.getDouble(resultSet,25));
            temblorsettlelistDto.setOpcode(dbManager.getString(resultSet,26));
            temblorsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,27));
            temblorsettlelistDto.setValidity(dbManager.getString(resultSet,28));
            temblorsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            temblorsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,30));
            temblorsettlelistDto.setNodetype(dbManager.getString(resultSet,31));
            temblorsettlelistDto.setDamagelevel(dbManager.getString(resultSet,32));
            temblorsettlelistDto.setLossamount(dbManager.getDouble(resultSet,33));
            temblorsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,34));
            temblorsettlelistDto.setPrepay(dbManager.getDouble(resultSet,35));
            temblorsettlelistDto.setSupplyprepay(dbManager.getDouble(resultSet,36));
            temblorsettlelistDto.setCardtype(dbManager.getString(resultSet,37));
            temblorsettlelistDto.setIdcard(dbManager.getString(resultSet,38));
            temblorsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,39));
            temblorsettlelistDto.setName(dbManager.getString(resultSet,40));
        }
        resultSet.close();
        return temblorsettlelistDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
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
        buffer.append("FROM Temblorsettlelist WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
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

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        TemblorsettlelistDto temblorsettlelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            temblorsettlelistDto = new TemblorsettlelistDto();
            temblorsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            temblorsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            temblorsettlelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            temblorsettlelistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            temblorsettlelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            temblorsettlelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            temblorsettlelistDto.setCountrycode(dbManager.getString(resultSet,"Countrycode"));
            temblorsettlelistDto.setCitycode(dbManager.getString(resultSet,"Citycode"));
            temblorsettlelistDto.setAddress(dbManager.getString(resultSet,"Address"));
            temblorsettlelistDto.setZipcode(dbManager.getString(resultSet,"Zipcode"));
            temblorsettlelistDto.setLongitude(dbManager.getDouble(resultSet,"Longitude"));
            temblorsettlelistDto.setLatitude(dbManager.getDouble(resultSet,"Latitude"));
            temblorsettlelistDto.setItemtype(dbManager.getString(resultSet,"Itemtype"));
            temblorsettlelistDto.setBuilding(dbManager.getString(resultSet,"Building"));
            temblorsettlelistDto.setFloor(dbManager.getInt(resultSet,"Floor"));
            temblorsettlelistDto.setArchitecture(dbManager.getString(resultSet,"Architecture"));
            temblorsettlelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            temblorsettlelistDto.setArea(dbManager.getDouble(resultSet,"Area"));
            temblorsettlelistDto.setBuildtime(dbManager.getString(resultSet,"Buildtime"));
            temblorsettlelistDto.setRepair(dbManager.getString(resultSet,"Repair"));
            temblorsettlelistDto.setRepairtime(dbManager.getString(resultSet,"Repairtime"));
            temblorsettlelistDto.setPropcerttype(dbManager.getString(resultSet,"Propcerttype"));
            temblorsettlelistDto.setPropcertno(dbManager.getString(resultSet,"Propcertno"));
            temblorsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            temblorsettlelistDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            temblorsettlelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            temblorsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            temblorsettlelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            temblorsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            temblorsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            temblorsettlelistDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            temblorsettlelistDto.setDamagelevel(dbManager.getString(resultSet,"Damagelevel"));
            temblorsettlelistDto.setLossamount(dbManager.getDouble(resultSet,"Lossamount"));
            temblorsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,"Settlesum"));
            temblorsettlelistDto.setPrepay(dbManager.getDouble(resultSet,"Prepay"));
            temblorsettlelistDto.setSupplyprepay(dbManager.getDouble(resultSet,"Supplyprepay"));
            temblorsettlelistDto.setCardtype(dbManager.getString(resultSet,"Cardtype"));
            temblorsettlelistDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
            temblorsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,"Suminsured"));
            temblorsettlelistDto.setName(dbManager.getString(resultSet,"Name"));
            collection.add(temblorsettlelistDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Temblorsettlelist WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Temblorsettlelist WHERE ");
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
    
    
    
    
    
    //---------
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)throws Exception{
    	try {
			//ɾ����ǰ�������е������嵥
			String deleteSql = " SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeTo+"'";
			deleteByConditions(deleteSql);
			//ת�������嵥
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("insert into  TEMBLORSETTLELIST "+
					"(SETTLELISTCODE,INDEXOFSETTLE,KINDCODE,ITEMCODE,CLASSCODE,RISKCODE,COUNTRYCODE,CITYCODE, "+
					"ADDRESS,ZIPCODE,LONGITUDE,LATITUDE,ITEMTYPE,BUILDING,FLOOR,ARCHITECTURE,REMARK,AREA, "+
					"BUILDTIME,REPAIR,REPAIRTIME,PROPCERTTYPE,PROPCERTNO,INUSRELISTCODE,LOSSRATE,OPCODE, "+
					"OPTIME,VALIDITY,SETTLEDATE,CLAIMRATE,NODETYPE,DAMAGELEVEL,LOSSAMOUNT,SETTLESUM, "+
					"PREPAY,SUPPLYPREPAY,CARDTYPE,IDCARD,Suminsured,NAME)");
			stringBuffer.append("select SETTLELISTCODE,INDEXOFSETTLE,KINDCODE,ITEMCODE,CLASSCODE,RISKCODE,COUNTRYCODE,CITYCODE, "+
					"ADDRESS,ZIPCODE,LONGITUDE,LATITUDE,ITEMTYPE,BUILDING,FLOOR,ARCHITECTURE,REMARK,AREA, "+
					"BUILDTIME,REPAIR,REPAIRTIME,PROPCERTTYPE,PROPCERTNO,INUSRELISTCODE,LOSSRATE,OPCODE, "+
					"OPTIME,VALIDITY,SETTLEDATE,CLAIMRATE, '"+nodeTypeTo+"', NODETYPE,DAMAGELEVEL,LOSSAMOUNT,SETTLESUM, "+
					"PREPAY,SUPPLYPREPAY,CARDTYPE,IDCARD,Suminsured,NAME  "+ 
					"from temblorSETTLELIST where  ");
			stringBuffer.append(" SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeFrom+"'");
			
			System.err.println(stringBuffer.toString());
			dbManager.executeUpdate(stringBuffer.toString());
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
    	double sum = 0;
    	if(null!=fieldName && !"".equals(fieldName)){
	        StringBuffer buffer = new StringBuffer(100);
	        buffer.append("SELECT sum("+fieldName+") FROM TEMBLORSettleList WHERE ");
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
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
//    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String nodeType)
//    throws Exception{
//    	StringBuffer buffer = new StringBuffer(200);
//        //ƴSQL���
//        buffer.append("SELECT ");
//        buffer.append("sum(SETTLESUM) ");
//        buffer.append("FROM nyxSETTLELIST WHERE ");
//        buffer.append("SettleListCode = '"+settleListCode+"' And fIdCard = '"+fIdCard+"' And nodeType = '"+nodeType+"'");
//        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
//
//        //���巵�ؽ������
//        double result = 0.0;
//        NyxsettlelistDto planting31SettleListDto = null;
//        while(resultSet.next()){
//            result = dbManager.getDouble(resultSet,"sum(SETTLESUM)");
//        }
//        resultSet.close();
//        return result;
//    }
    
    /**
     * �����ݴ���ʱ�� PLANTING31SETTLELISTTEMP ������ʽ�� PLANTING31SETTLELIST
     * @param settleListCode ��ʽ���е������嵥��
     * @param indexOfSettle ��ʽ���е����
     * @param whereCondition ��ʱ���ѯ��������������Щ���ݲ�����ʽ��
     * @throws Exception
     */
    public void evaluate(String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("insert into  TEMBLORSETTLELIST "+
		    			"(SETTLELISTCODE,INDEXOFSETTLE,KINDCODE,ITEMCODE,CLASSCODE,RISKCODE,COUNTRYCODE,CITYCODE, "+
		    			"ADDRESS,ZIPCODE,LONGITUDE,LATITUDE,ITEMTYPE,BUILDING,FLOOR,ARCHITECTURE,REMARK,AREA, "+
		    			"BUILDTIME,REPAIR,REPAIRTIME,PROPCERTTYPE,PROPCERTNO,INUSRELISTCODE,LOSSRATE,OPCODE, "+
		    			"OPTIME,VALIDITY,SETTLEDATE,CLAIMRATE,NODETYPE,DAMAGELEVEL,LOSSAMOUNT,SETTLESUM, "+
		    			"PREPAY,SUPPLYPREPAY,CARDTYPE,IDCARD,Suminsured,NAME)");
    	stringBuffer.append("select '"+ settleListCode +"', '"+indexOfSettle+"',KINDCODE,ITEMCODE,CLASSCODE,RISKCODE,COUNTRYCODE,CITYCODE, "+ 
		    			"ADDRESS,ZIPCODE,LONGITUDE,LATITUDE,ITEMTYPE,BUILDING,FLOOR,ARCHITECTURE,REMARK,AREA, "+
		    			"BUILDTIME,REPAIR,REPAIRTIME,PROPCERTTYPE,PROPCERTNO,INUSRELISTCODE,LOSSRATE,OPCODE, "+
		    			"OPTIME,VALIDITY,SETTLEDATE,CLAIMRATE, NODETYPE,DAMAGELEVEL,LOSSAMOUNT,SETTLESUM, "+
		    			"PREPAY,SUPPLYPREPAY,CARDTYPE,IDCARD,Suminsured,NAME  "+ 
		    			"from temblorSETTLELISTTemp where  ");
    	stringBuffer.append(whereCondition);
    	if(logger.isDebugEnabled()){
            logger.debug(stringBuffer.toString());
        }
    	System.err.println(stringBuffer.toString());
    	dbManager.prepareStatement(stringBuffer.toString());
    	dbManager.executePreparedUpdate();
    }
    
    public int getMaxIndex(String conditions)
    throws Exception{
	int max = 0;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT max(INDEXOFSETTLE) FROM TemblorSettleList WHERE ");
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
     * ��ѯ��ͬ��ʧ�ʵļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getDistinctLossRateCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(Lossrate)) FROM temblorsettlelist WHERE ");
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
     * ͳ�ƻ���
     * @param conditions conditions
     * @return  ͳ�ƻ���
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
        double count = 0.00;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(distinct(idcard)) FROM temblorsettlelist WHERE ");
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
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard,String Address, String nodeType)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("sum(SETTLESUM) ");
        buffer.append("FROM temblorSETTLELIST WHERE ");
        buffer.append("SettleListCode = '"+settleListCode+"' And fIdCard = '"+fIdCard+"' And Address = '"+Address+"' And nodeType = '"+nodeType+"'");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //���巵�ؽ������
        double result = 0.0;
        //TemblorsettlelistDto planting31SettleListDto = null;
        while(resultSet.next()){
            result = dbManager.getDouble(resultSet,"sum(SETTLESUM)");
        }
        resultSet.close();
        return result;
    }
    
    public Collection getGroupedSumDataByFcode( String sqlCondition)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        //buffer.append("fcode, ");
        buffer.append("fidcard, ");
        buffer.append("KINDCODE, ");
        buffer.append("ITEMCODE, ");
        buffer.append("LOSSRATE, ");
        buffer.append("sum(SETTLESUM), ");
        buffer.append("sum(SUMINSURED) ");
        buffer.append("FROM temblorSETTLELIST WHERE ");
        buffer.append(sqlCondition);
        buffer.append(" group by KINDCODE, ITEMCODE, LOSSRATE, idcard");
        buffer.append(" order by KINDCODE, ITEMCODE, LOSSRATE, idcard");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //���巵�ؽ������
        Collection collection = new ArrayList();
        TemblorsettlelistDto planting31SettleListDto = null;
        while(resultSet.next()){

            planting31SettleListDto = new TemblorsettlelistDto();
            //planting31SettleListDto.setFcode(dbManager.getString(resultSet,"fidcard"));
            planting31SettleListDto.setIdcard(dbManager.getString(resultSet,"idcard"));
            planting31SettleListDto.setKindcode(dbManager.getString(resultSet,"KindCode"));
            planting31SettleListDto.setItemcode(dbManager.getString(resultSet,"ItemCode"));
            planting31SettleListDto.setLossrate(dbManager.getDouble(resultSet,"LossRate"));
            planting31SettleListDto.setSettlesum(dbManager.getDouble(resultSet,"sum(SETTLESUM)"));//����������ʱ���������
            //planting31SettleListDto.setSettlearea(dbManager.getDouble(resultSet,"sum(SETTLEAREA)"));//��������������ʱ������������
            //planting31SettleListDto.setInsurearea(dbManager.getDouble(resultSet,"sum(INSUREAREA)"));//���������������ʱ���ڱ��������
            planting31SettleListDto.setSuminsured(dbManager.getDouble(resultSet,"sum(SUMINSURED)"));//�����������ʱ���ڱ�����
            collection.add(planting31SettleListDto);
        }
        resultSet.close();
        return collection;
    }

}
