package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.domain.HerdpolicylistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDPOLICYLIST的数据访问对象基类<br>
 */
public class DBHerdpolicylistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    //protected DBManager dbManager1 = null;
    private static Logger logger = Logger.getLogger(DBHerdpolicylistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBHerdpolicylistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void insert(HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Herdpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Insurenumber,");
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
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Phone,");
        buffer.append("Settlenumber,");
        buffer.append("AreaNumber,");
        buffer.append("LitterArea ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(herdpolicylistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getEarlabel()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getFcode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getFname()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getSpecies()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getBreedingkind()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getBank()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getBankcard()).append("',");
            debugBuffer.append("").append(herdpolicylistDto.getInsurenumber()).append(",");
            debugBuffer.append("").append(herdpolicylistDto.getAmount()).append(",");
            debugBuffer.append("").append(herdpolicylistDto.getRate()).append(",");
            debugBuffer.append("'").append(herdpolicylistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(herdpolicylistDto.getShortrate()).append(",");
            debugBuffer.append("").append(herdpolicylistDto.getSumamount()).append(",");
            debugBuffer.append("").append(herdpolicylistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(herdpolicylistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getOptime()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getValidity()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getRemark()).append("',");
            debugBuffer.append("").append(herdpolicylistDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(herdpolicylistDto.getBreedingareaname()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getEndtime()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getPhone()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getAreaNumber()).append("',");
            debugBuffer.append("'").append(herdpolicylistDto.getLitterArea()).append("',");
            debugBuffer.append("").append(herdpolicylistDto.getSettlenumber()).append(")");
            
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,herdpolicylistDto.getInusrelistcode());
        dbManager.setString(2,herdpolicylistDto.getEarlabel());
        dbManager.setString(3,herdpolicylistDto.getKindcode());
        dbManager.setString(4,herdpolicylistDto.getIndexcode());
        dbManager.setString(5,herdpolicylistDto.getFcode());
        dbManager.setString(6,herdpolicylistDto.getFname());
        dbManager.setString(7,herdpolicylistDto.getFidcard());
        dbManager.setString(8,herdpolicylistDto.getBreedingareacode());
        dbManager.setString(9,herdpolicylistDto.getSpecies());
        dbManager.setString(10,herdpolicylistDto.getBreedingkind());
        dbManager.setString(11,herdpolicylistDto.getBank());
        dbManager.setString(12,herdpolicylistDto.getBankcard());
        dbManager.setLong(13,herdpolicylistDto.getInsurenumber());
        dbManager.setDouble(14,herdpolicylistDto.getAmount());
        dbManager.setDouble(15,herdpolicylistDto.getRate());
        dbManager.setString(16,herdpolicylistDto.getShortrateflag());
        dbManager.setDouble(17,herdpolicylistDto.getShortrate());
        dbManager.setDouble(18,herdpolicylistDto.getSumamount());
        dbManager.setDouble(19,herdpolicylistDto.getSumpremium());
        dbManager.setDateTime(20,herdpolicylistDto.getStartdate());
        dbManager.setDateTime(21,herdpolicylistDto.getEnddate());
        dbManager.setString(22,herdpolicylistDto.getCalculateflag());
        dbManager.setString(23,herdpolicylistDto.getOpcode());
        dbManager.setDateTime(24,herdpolicylistDto.getOptime());
        dbManager.setString(25,herdpolicylistDto.getValidity());
        dbManager.setString(26,herdpolicylistDto.getRemark());
        dbManager.setLong(27,herdpolicylistDto.getBreedingnumber());
        dbManager.setString(28,herdpolicylistDto.getBreedingareaname());
        dbManager.setString(29,herdpolicylistDto.getStarttime());
        dbManager.setString(30,herdpolicylistDto.getEndtime());
        dbManager.setString(31,herdpolicylistDto.getPhone());
        dbManager.setLong(32,herdpolicylistDto.getSettlenumber());
        dbManager.setDouble(31,herdpolicylistDto.getAreaNumber());
        dbManager.setString(32,herdpolicylistDto.getLitterArea());
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
        buffer.append("INSERT INTO Herdpolicylist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Insurenumber,");
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
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Phone,");
        buffer.append("Settlenumber,");
        buffer.append("AreaNumber,");
        buffer.append("LitterArea ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            HerdpolicylistDto herdpolicylistDto = (HerdpolicylistDto)i.next();
            dbManager.setString(1,herdpolicylistDto.getInusrelistcode());
            dbManager.setString(2,herdpolicylistDto.getEarlabel());
            dbManager.setString(3,herdpolicylistDto.getKindcode());
            dbManager.setString(4,herdpolicylistDto.getIndexcode());
            dbManager.setString(5,herdpolicylistDto.getFcode());
            dbManager.setString(6,herdpolicylistDto.getFname());
            dbManager.setString(7,herdpolicylistDto.getFidcard());
            dbManager.setString(8,herdpolicylistDto.getBreedingareacode());
            dbManager.setString(9,herdpolicylistDto.getSpecies());
            dbManager.setString(10,herdpolicylistDto.getBreedingkind());
            dbManager.setString(11,herdpolicylistDto.getBank());
            dbManager.setString(12,herdpolicylistDto.getBankcard());
            dbManager.setLong(13,herdpolicylistDto.getInsurenumber());
            dbManager.setDouble(14,herdpolicylistDto.getAmount());
            dbManager.setDouble(15,herdpolicylistDto.getRate());
            dbManager.setString(16,herdpolicylistDto.getShortrateflag());
            dbManager.setDouble(17,herdpolicylistDto.getShortrate());
            dbManager.setDouble(18,herdpolicylistDto.getSumamount());
            dbManager.setDouble(19,herdpolicylistDto.getSumpremium());
            dbManager.setDateTime(20,herdpolicylistDto.getStartdate());
            dbManager.setDateTime(21,herdpolicylistDto.getEnddate());
            dbManager.setString(22,herdpolicylistDto.getCalculateflag());
            dbManager.setString(23,herdpolicylistDto.getOpcode());
            dbManager.setDateTime(24,herdpolicylistDto.getOptime());
            dbManager.setString(25,herdpolicylistDto.getValidity());
            dbManager.setString(26,herdpolicylistDto.getRemark());
            dbManager.setLong(27,herdpolicylistDto.getBreedingnumber());
            dbManager.setString(28,herdpolicylistDto.getBreedingareaname());
            dbManager.setString(29,herdpolicylistDto.getStarttime());
            dbManager.setString(30,herdpolicylistDto.getEndtime());
            dbManager.setString(31,herdpolicylistDto.getPhone());
            dbManager.setLong(32,herdpolicylistDto.getSettlenumber());
            dbManager.setDouble(31,herdpolicylistDto.getAreaNumber());
            dbManager.setString(32,herdpolicylistDto.getLitterArea());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Herdpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(earlabel).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Fcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,earlabel);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,fcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void update(HerdpolicylistDto herdpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Herdpolicylist SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Species = ?, ");
        buffer.append("Breedingkind = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Bankcard = ?, ");
        buffer.append("Insurenumber = ?, ");
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
        buffer.append("Breedingnumber = ?, ");
        buffer.append("Breedingareaname = ?, ");
        buffer.append("Starttime = ?, ");
        buffer.append("Endtime = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Settlenumber = ?,");
        buffer.append("AreaNumber = ?, ");
        buffer.append("LitterArea = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Herdpolicylist SET ");
            debugBuffer.append("Indexcode = '" + herdpolicylistDto.getIndexcode() + "', ");
            debugBuffer.append("Fname = '" + herdpolicylistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + herdpolicylistDto.getFidcard() + "', ");
            debugBuffer.append("Breedingareacode = '" + herdpolicylistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + herdpolicylistDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + herdpolicylistDto.getBreedingkind() + "', ");
            debugBuffer.append("Bank = '" + herdpolicylistDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + herdpolicylistDto.getBankcard() + "', ");
            debugBuffer.append("Insurenumber = " + herdpolicylistDto.getInsurenumber() + ", ");
            debugBuffer.append("Amount = " + herdpolicylistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + herdpolicylistDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + herdpolicylistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + herdpolicylistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + herdpolicylistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + herdpolicylistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + herdpolicylistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + herdpolicylistDto.getEnddate() + "', ");
            debugBuffer.append("Calculateflag = '" + herdpolicylistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + herdpolicylistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + herdpolicylistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + herdpolicylistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + herdpolicylistDto.getRemark() + "', ");
            debugBuffer.append("Breedingnumber = " + herdpolicylistDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + herdpolicylistDto.getBreedingareaname() + "', ");
            debugBuffer.append("Starttime = '" + herdpolicylistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + herdpolicylistDto.getEndtime() + "', ");
            debugBuffer.append("Phone = '" + herdpolicylistDto.getPhone() + "', ");
            debugBuffer.append("Settlenumber = " + herdpolicylistDto.getSettlenumber() + " ");
            debugBuffer.append("AreaNumber = " + herdpolicylistDto.getAreaNumber() + ", ");
            debugBuffer.append("LitterArea = '" + herdpolicylistDto.getLitterArea() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(herdpolicylistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(herdpolicylistDto.getEarlabel()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(herdpolicylistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(herdpolicylistDto.getFcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Fcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,herdpolicylistDto.getIndexcode());
        dbManager.setString(2,herdpolicylistDto.getFname());
        dbManager.setString(3,herdpolicylistDto.getFidcard());
        dbManager.setString(4,herdpolicylistDto.getBreedingareacode());
        dbManager.setString(5,herdpolicylistDto.getSpecies());
        dbManager.setString(6,herdpolicylistDto.getBreedingkind());
        dbManager.setString(7,herdpolicylistDto.getBank());
        dbManager.setString(8,herdpolicylistDto.getBankcard());
        dbManager.setLong(9,herdpolicylistDto.getInsurenumber());
        dbManager.setDouble(10,herdpolicylistDto.getAmount());
        dbManager.setDouble(11,herdpolicylistDto.getRate());
        dbManager.setString(12,herdpolicylistDto.getShortrateflag());
        dbManager.setDouble(13,herdpolicylistDto.getShortrate());
        dbManager.setDouble(14,herdpolicylistDto.getSumamount());
        dbManager.setDouble(15,herdpolicylistDto.getSumpremium());
        dbManager.setDateTime(16,herdpolicylistDto.getStartdate());
        dbManager.setDateTime(17,herdpolicylistDto.getEnddate());
        dbManager.setString(18,herdpolicylistDto.getCalculateflag());
        dbManager.setString(19,herdpolicylistDto.getOpcode());
        dbManager.setDateTime(20,herdpolicylistDto.getOptime());
        dbManager.setString(21,herdpolicylistDto.getValidity());
        dbManager.setString(22,herdpolicylistDto.getRemark());
        dbManager.setLong(23,herdpolicylistDto.getBreedingnumber());
        dbManager.setString(24,herdpolicylistDto.getBreedingareaname());
        dbManager.setString(25,herdpolicylistDto.getStarttime());
        dbManager.setString(26,herdpolicylistDto.getEndtime());
        dbManager.setString(27,herdpolicylistDto.getPhone());
        dbManager.setLong(28,herdpolicylistDto.getSettlenumber());
        dbManager.setDouble(29,herdpolicylistDto.getAreaNumber());
        dbManager.setString(30,herdpolicylistDto.getLitterArea());
        //设置条件字段;
        dbManager.setString(31,herdpolicylistDto.getInusrelistcode());
        dbManager.setString(32,herdpolicylistDto.getEarlabel());
        dbManager.setString(33,herdpolicylistDto.getKindcode());
        dbManager.setString(34,herdpolicylistDto.getFcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @return HerdpolicylistDto
     * @throws Exception
     */
    public HerdpolicylistDto findByPrimaryKey(String inusrelistcode,String earlabel,String kindcode,String fcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Insurenumber,");
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
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Phone,");
        buffer.append("Settlenumber,");
        buffer.append("AreaNumber,");
        buffer.append("LitterArea ");
        buffer.append("FROM Herdpolicylist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(earlabel).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Fcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,earlabel);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,fcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        HerdpolicylistDto herdpolicylistDto = null;
        if(resultSet.next()){
            herdpolicylistDto = new HerdpolicylistDto();
            herdpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            herdpolicylistDto.setEarlabel(dbManager.getString(resultSet,2));
            herdpolicylistDto.setKindcode(dbManager.getString(resultSet,3));
            herdpolicylistDto.setIndexcode(dbManager.getString(resultSet,4));
            herdpolicylistDto.setFcode(dbManager.getString(resultSet,5));
            herdpolicylistDto.setFname(dbManager.getString(resultSet,6));
            herdpolicylistDto.setFidcard(dbManager.getString(resultSet,7));
            herdpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,8));
            herdpolicylistDto.setSpecies(dbManager.getString(resultSet,9));
            herdpolicylistDto.setBreedingkind(dbManager.getString(resultSet,10));
            herdpolicylistDto.setBank(dbManager.getString(resultSet,11));
            herdpolicylistDto.setBankcard(dbManager.getString(resultSet,12));
            herdpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,13));
            herdpolicylistDto.setAmount(dbManager.getDouble(resultSet,14));
            herdpolicylistDto.setRate(dbManager.getDouble(resultSet,15));
            herdpolicylistDto.setShortrateflag(dbManager.getString(resultSet,16));
            herdpolicylistDto.setShortrate(dbManager.getDouble(resultSet,17));
            herdpolicylistDto.setSumamount(dbManager.getDouble(resultSet,18));
            herdpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,19));
            herdpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            herdpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            herdpolicylistDto.setCalculateflag(dbManager.getString(resultSet,22));
            herdpolicylistDto.setOpcode(dbManager.getString(resultSet,23));
            herdpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,24));
            herdpolicylistDto.setValidity(dbManager.getString(resultSet,25));
            herdpolicylistDto.setRemark(dbManager.getString(resultSet,26));
            herdpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,27));
            herdpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,28));
            herdpolicylistDto.setStarttime(dbManager.getString(resultSet,29));
            herdpolicylistDto.setEndtime(dbManager.getString(resultSet,30));
            herdpolicylistDto.setPhone(dbManager.getString(resultSet,31));
            herdpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,32));
            herdpolicylistDto.setAreaNumber(dbManager.getDouble(resultSet,33));
            herdpolicylistDto.setLitterArea(dbManager.getString(resultSet,34));
        }
        resultSet.close();
        return herdpolicylistDto;
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
        buffer.append("Earlabel,");
        buffer.append("Kindcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Insurenumber,");
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
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Starttime,");
        buffer.append("Endtime,");
        buffer.append("Phone,");
        buffer.append("Settlenumber,");
        buffer.append("AreaNumber,");
        buffer.append("LitterArea ");
        buffer.append("FROM Herdpolicylist WHERE ");
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
        HerdpolicylistDto herdpolicylistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            herdpolicylistDto = new HerdpolicylistDto();
            herdpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            herdpolicylistDto.setEarlabel(dbManager.getString(resultSet,"Earlabel"));
            herdpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            herdpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            herdpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            herdpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
            herdpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            herdpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            herdpolicylistDto.setSpecies(dbManager.getString(resultSet,"Species"));
            herdpolicylistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            herdpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
            herdpolicylistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            herdpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            herdpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            herdpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            herdpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            herdpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            herdpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            herdpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            herdpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            herdpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            herdpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            herdpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            herdpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"Optime"));
            herdpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            herdpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            herdpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            herdpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            herdpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            herdpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            herdpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            herdpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            herdpolicylistDto.setAreaNumber(dbManager.getDouble(resultSet,"AreaNumber"));
            herdpolicylistDto.setLitterArea(dbManager.getString(resultSet,"LitterArea"));
            collection.add(herdpolicylistDto);
        }
        resultSet.close();
        return collection;
    }
    
    public Collection findEarByConditions(String conditions,int pageNo,int rowsPerPage)
    throws Exception{
	StringBuffer buffer = new StringBuffer(400);
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
	////////////////////
	buffer.append("d.Inusrelistcode,");
    buffer.append("d.Earlabel,");
    buffer.append("d.Kindcode,");
    buffer.append("d.Indexcode,");
    buffer.append("d.Fcode,");
    buffer.append("d.Fname,");
    buffer.append("d.Fidcard,");
    buffer.append("d.Breedingareacode,");
    buffer.append("d.Species,");
    buffer.append("d.Breedingkind,");
    buffer.append("d.Bank,");
    buffer.append("d.Bankcard,");
    buffer.append("d.Insurenumber,");
    buffer.append("d.Amount,");
    buffer.append("d.Rate,");
    buffer.append("d.Shortrateflag,");
    buffer.append("d.Shortrate,");
    buffer.append("d.Sumamount,");
    buffer.append("d.Sumpremium,");
    //buffer.append("d.Enddate,");
    buffer.append("d.Calculateflag,");
    buffer.append("d.Opcode,");
    buffer.append("d.Optime,");
    buffer.append("d.Validity,");
    buffer.append("d.Remark,");
    buffer.append("d.Breedingnumber,");
    buffer.append("d.Breedingareaname,");
    buffer.append("d.Starttime,");
    buffer.append("d.Endtime,");
    buffer.append("d.Phone,");
    buffer.append("d.Settlenumber ");
    buffer.append("FROM Herdpolicylist d,insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
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
    if(logger.isDebugEnabled()){
        logger.debug(buffer.toString());
    }
    System.err.println("sql:" + buffer.toString());
    ResultSet resultSet = null;
    try {
        resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        HerdpolicylistDto herdpolicylistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            herdpolicylistDto = new HerdpolicylistDto();
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
			///////////////////////////////////////////////////////////////////////////////////////
            herdpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            herdpolicylistDto.setEarlabel(dbManager.getString(resultSet,"Earlabel"));
            herdpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            herdpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            herdpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            herdpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
            herdpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            herdpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            herdpolicylistDto.setSpecies(dbManager.getString(resultSet,"Species"));
            herdpolicylistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            herdpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
            herdpolicylistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            herdpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            herdpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            herdpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            herdpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            herdpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            herdpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            herdpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            herdpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            herdpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            herdpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            herdpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            herdpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"Optime"));
            herdpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            herdpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            herdpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            herdpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            herdpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            herdpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            herdpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            herdpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            EarLabelRegistDto earLabelRegistDto = new EarLabelRegistDto();
            earLabelRegistDto.setHerdpolicylistDto(herdpolicylistDto);
            earLabelRegistDto.setPrpCmainDto(prpCmainDto);
            collection.add(earLabelRegistDto);
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
    public Collection findEarByConditions(String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
	    	StringBuffer buffer = new StringBuffer(400);
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
	    	//buffer.append("a.flag,");
	    	//buffer.append("a.underwriteflag,");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	buffer.append("d.Inusrelistcode,");
	        buffer.append("d.Earlabel,");
	        buffer.append("d.Kindcode,");
	        buffer.append("d.Indexcode,");
	        buffer.append("d.Fcode,");
	        buffer.append("d.Fname,");
	        buffer.append("d.Fidcard,");
	        buffer.append("d.Breedingareacode,");
	        buffer.append("d.Species,");
	        buffer.append("d.Breedingkind,");
	        buffer.append("d.Bank,");
	        buffer.append("d.Bankcard,");
	        buffer.append("d.Insurenumber,");
	        buffer.append("d.Amount,");
	        buffer.append("d.Rate,");
	        buffer.append("d.Shortrateflag,");
	        buffer.append("d.Shortrate,");
	        buffer.append("d.Sumamount,");
	        buffer.append("d.Sumpremium,");
	        //buffer.append("d.Enddate,");
	        buffer.append("d.Calculateflag,");
	        buffer.append("d.Opcode,");
	        buffer.append("d.Optime,");
	        buffer.append("d.Validity,");
	        buffer.append("d.Remark,");
	        buffer.append("d.Breedingnumber,");
	        buffer.append("d.Breedingareaname,");
	        buffer.append("d.Starttime,");
	        buffer.append("d.Endtime,");
	        buffer.append("d.Phone,");
	        buffer.append("d.Settlenumber ");
	        buffer.append("FROM Herdpolicylist d,insuremainlist e " +
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
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = null;
	        //System.err.println("sql1:" + buffer.toString());
	        try {
		        resultSet = dbManager.executeQuery(buffer.toString());
		        System.err.print(buffer.toString());
		        int count=0;
		        if(supportPaging==false && pageNo>1){
		            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		        }
		
		        //定义返回结果集合
		        Collection collection = new ArrayList(rowsPerPage);
		        HerdpolicylistDto herdpolicylistDto = null;
		        while(resultSet.next()){
		            if (supportPaging == false && pageNo>0) {
		                count++;
		                if(count > rowsPerPage){
		                    break;
		                }
		            }
		
		            herdpolicylistDto = new HerdpolicylistDto();
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
					 //add by guolei  20070519 增加团单
		            //if(dbManager.getString(resultSet,11).length()>=2){
		            	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
		            //}
		            //添加见费出单的标志
		            //prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
		            //增加车牌号码
		           // prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
					///////////////////////////////////////////////////////////////////////////////////////
		            herdpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
		            herdpolicylistDto.setEarlabel(dbManager.getString(resultSet,"Earlabel"));
		            herdpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
		            herdpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
		            herdpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
		            herdpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
		            herdpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
		            herdpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
		            herdpolicylistDto.setSpecies(dbManager.getString(resultSet,"Species"));
		            herdpolicylistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
		            herdpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
		            herdpolicylistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
		            herdpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
		            herdpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
		            herdpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
		            herdpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
		            herdpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
		            herdpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
		            herdpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
		            herdpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
		            herdpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
		            herdpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
		            herdpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
		            herdpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"Optime"));
		            herdpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
		            herdpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
		            herdpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
		            herdpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
		            herdpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
		            herdpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
		            herdpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
		            herdpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));            
		            EarLabelRegistDto earLabelRegistDto = new EarLabelRegistDto();
		            earLabelRegistDto.setHerdpolicylistDto(herdpolicylistDto);
		            earLabelRegistDto.setPrpCmainDto(prpCmainDto);
		            collection.add(earLabelRegistDto);
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
        buffer.append("DELETE FROM Herdpolicylist WHERE ");
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
        buffer.append("SELECT count(*) FROM Herdpolicylist WHERE ");
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
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getEarCount(String conditions,String fname,String earno) 
        throws Exception{
    	System.err.println("conditions:" + conditions);
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        //StringBuffer buffer1 = new StringBuffer(100);
        //buffer1.append("SELECT count(*) FROM prpcmain a, uticodetransfer c ");
        
        buffer.append("SELECT COUNT (1) FROM herdpolicylist d,INSUREMAINLIST e where d.inusrelistcode=e.inusrelistcode and  e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
        buffer.append(conditions);
        //System.err.println("sql:" + buffer.toString());
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
	        buffer.append("SELECT sum("+fieldName+") FROM herdpolicylist WHERE ");
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
    
    public int getEarCount(String conditions) 
    throws Exception{
    int count = -1;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT count(*) FROM Herdpolicylist d,insuremainlist e ,PrpCmain@sinodb a LEFT JOIN PrpCitemcar@sinodb b ON a.PolicyNo = b.PolicyNo ,uticodetransfer@sinodb c" +
" WHERE e.policyno = a.policyno and d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
    buffer.append(conditions);
    if(logger.isDebugEnabled()){
        logger.debug(buffer.toString());
    }
    ResultSet resultSet = null;
    try
    {
    	System.err.println("sqlcount:"+ buffer.toString());
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
    public int getNEWEarCount(String conditions,String fname,String earno) 
        throws Exception{
    	System.err.println("conditions:" + conditions);
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        //StringBuffer buffer1 = new StringBuffer(100);
        //buffer1.append("SELECT count(*) FROM prpcmain a, uticodetransfer c ");
        
        buffer.append("SELECT COUNT (1) FROM herdpolicylist@NEWNYXDB.RAC d,INSUREMAINLIST@NEWNYXDB.RAC e where d.inusrelistcode=e.inusrelistcode and  e.VALIDITY in ('2') and d.VALIDITY in ('1') and ");
        buffer.append(conditions);
        //System.err.println("sql:" + buffer.toString());
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
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findNEWEarByConditions(String conditions,int pageNo,int rowsPerPage,String fname,String earno)
            throws Exception{
	    	StringBuffer buffer = new StringBuffer(400);
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
	    	//buffer.append("a.flag,");
	    	//buffer.append("a.underwriteflag,");
	    	//buffer.append("b.licenseno,");
	    	////////////////////
	    	buffer.append("d.Inusrelistcode,");
	        buffer.append("d.Earlabel,");
	        buffer.append("d.Kindcode,");
	        buffer.append("d.Indexcode,");
	        buffer.append("d.Fcode,");
	        buffer.append("d.Fname,");
	        buffer.append("d.Fidcard,");
	        buffer.append("d.Breedingareacode,");
	        buffer.append("d.Species,");
	        buffer.append("d.Breedingkind,");
	        buffer.append("d.Bank,");
	        buffer.append("d.Bankcard,");
	        buffer.append("d.Insurenumber,");
	        buffer.append("d.Amount,");
	        buffer.append("d.Rate,");
	        buffer.append("d.Shortrateflag,");
	        buffer.append("d.Shortrate,");
	        buffer.append("d.Sumamount,");
	        buffer.append("d.Sumpremium,");
	        //buffer.append("d.Enddate,");
	        buffer.append("d.Calculateflag,");
	        buffer.append("d.Opcode,");
	        buffer.append("d.Optime,");
	        buffer.append("d.Validity,");
	        buffer.append("d.Remark,");
	        buffer.append("d.Breedingnumber,");
	        buffer.append("d.Breedingareaname,");
	        buffer.append("d.Starttime,");
	        buffer.append("d.Endtime,");
	        buffer.append("d.Phone,");
	        buffer.append("d.Settlenumber ");
	        buffer.append("FROM Herdpolicylist@NEWNYXDB.RAC d,insuremainlist@NEWNYXDB.RAC e " +
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
	        if(logger.isDebugEnabled()){
	            logger.debug(buffer.toString());
	        }
	        ResultSet resultSet = null;
	        //System.err.println("sql1:" + buffer.toString());
	        try {
		        resultSet = dbManager.executeQuery(buffer.toString());
		        System.err.print(buffer.toString());
		        int count=0;
		        if(supportPaging==false && pageNo>1){
		            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
		        }
		
		        //定义返回结果集合
		        Collection collection = new ArrayList(rowsPerPage);
		        HerdpolicylistDto herdpolicylistDto = null;
		        while(resultSet.next()){
		            if (supportPaging == false && pageNo>0) {
		                count++;
		                if(count > rowsPerPage){
		                    break;
		                }
		            }
		
		            herdpolicylistDto = new HerdpolicylistDto();
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
					 //add by guolei  20070519 增加团单
		            //if(dbManager.getString(resultSet,11).length()>=2){
		            	//prpCmainDto.setInsuredName(dbManager.getString(resultSet,3)+"等"+dbManager.getString(resultSet,10)+"人");	
		            //}
		            //添加见费出单的标志
		            //prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet, 12));
		            //增加车牌号码
		           // prpCmainDto.setLicenseNo(dbManager.getString(resultSet, 2));
					///////////////////////////////////////////////////////////////////////////////////////
		            herdpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
		            herdpolicylistDto.setEarlabel(dbManager.getString(resultSet,"Earlabel"));
		            herdpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
		            herdpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
		            herdpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
		            herdpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
		            herdpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
		            herdpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
		            herdpolicylistDto.setSpecies(dbManager.getString(resultSet,"Species"));
		            herdpolicylistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
		            herdpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
		            herdpolicylistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
		            herdpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
		            herdpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
		            herdpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
		            herdpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
		            herdpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
		            herdpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
		            herdpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
		            herdpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
		            herdpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
		            herdpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
		            herdpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
		            herdpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"Optime"));
		            herdpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
		            herdpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
		            herdpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
		            herdpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
		            herdpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
		            herdpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
		            herdpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
		            herdpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));            
		            EarLabelRegistDto earLabelRegistDto = new EarLabelRegistDto();
		            earLabelRegistDto.setHerdpolicylistDto(herdpolicylistDto);
		            earLabelRegistDto.setPrpCmainDto(prpCmainDto);
		            collection.add(earLabelRegistDto);
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
