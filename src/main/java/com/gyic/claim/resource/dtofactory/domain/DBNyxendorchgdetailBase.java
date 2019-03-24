package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorchgdetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXENDORCHGDETAIL的数据访问对象基类<br>
 */
public class DBNyxendorchgdetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxendorchgdetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxendorchgdetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void insert(NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Endorseno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Fidcard,");
        buffer.append("Insurenumber,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Settlenumber,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
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
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Chginsurearea,");
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Chgareanumber,");
        buffer.append("Chginsurenumber,");
        buffer.append("Flag,");
        buffer.append("Areanumber,");
        buffer.append("Fieldsource,");
        buffer.append("Litterarea,");
        buffer.append("Atarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Warrant,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getEndorseno()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBankcard()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFidcard()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBreedingkind()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getSettlenumber()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFareacode()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getTaxarea()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getAmount()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getRate()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getShortrate()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getSumamount()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getStartdate()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getEnddate()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getStarttime()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getEndtime()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getRemark()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getFpremium()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTeamname()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getCitypremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getTownpremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getChginsurearea()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getChgsumamount()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getChgsumpremium()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getChgareanumber()).append(",");
            debugBuffer.append("").append(nyxendorchgdetailDto.getChginsurenumber()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFlag()).append("',");
            debugBuffer.append("").append(nyxendorchgdetailDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxendorchgdetailDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxendorchgdetailDto.getInusrelistcode());
        dbManager.setString(2,nyxendorchgdetailDto.getBusinessno());
        dbManager.setString(3,nyxendorchgdetailDto.getEndorseno());
        dbManager.setString(4,nyxendorchgdetailDto.getKindcode());
        dbManager.setString(5,nyxendorchgdetailDto.getItemcode());
        dbManager.setString(6,nyxendorchgdetailDto.getIndexcode());
        dbManager.setString(7,nyxendorchgdetailDto.getFcode());
        dbManager.setString(8,nyxendorchgdetailDto.getFname());
        dbManager.setString(9,nyxendorchgdetailDto.getZhibuka());
        dbManager.setString(10,nyxendorchgdetailDto.getPhone());
        dbManager.setString(11,nyxendorchgdetailDto.getBank());
        dbManager.setString(12,nyxendorchgdetailDto.getBankcard());
        dbManager.setString(13,nyxendorchgdetailDto.getFidcard());
        dbManager.setLong(14,nyxendorchgdetailDto.getInsurenumber());
        dbManager.setString(15,nyxendorchgdetailDto.getBreedingareacode());
        dbManager.setString(16,nyxendorchgdetailDto.getSpecies());
        dbManager.setString(17,nyxendorchgdetailDto.getBreedingkind());
        dbManager.setLong(18,nyxendorchgdetailDto.getBreedingnumber());
        dbManager.setString(19,nyxendorchgdetailDto.getBreedingareaname());
        dbManager.setLong(20,nyxendorchgdetailDto.getSettlenumber());
        dbManager.setString(21,nyxendorchgdetailDto.getClasscode());
        dbManager.setString(22,nyxendorchgdetailDto.getRiskcode());
        dbManager.setString(23,nyxendorchgdetailDto.getFareacode());
        dbManager.setDouble(24,nyxendorchgdetailDto.getTaxarea());
        dbManager.setDouble(25,nyxendorchgdetailDto.getInsurearea());
        dbManager.setDouble(26,nyxendorchgdetailDto.getAmount());
        dbManager.setDouble(27,nyxendorchgdetailDto.getRate());
        dbManager.setString(28,nyxendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(29,nyxendorchgdetailDto.getShortrate());
        dbManager.setDouble(30,nyxendorchgdetailDto.getSumamount());
        dbManager.setDouble(31,nyxendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(32,nyxendorchgdetailDto.getStartdate());
        dbManager.setDateTime(33,nyxendorchgdetailDto.getEnddate());
        dbManager.setString(34,nyxendorchgdetailDto.getStarttime());
        dbManager.setString(35,nyxendorchgdetailDto.getEndtime());
        dbManager.setString(36,nyxendorchgdetailDto.getCalculateflag());
        dbManager.setString(37,nyxendorchgdetailDto.getOpcode());
        dbManager.setDateTime(38,nyxendorchgdetailDto.getOptime());
        dbManager.setString(39,nyxendorchgdetailDto.getValidity());
        dbManager.setString(40,nyxendorchgdetailDto.getRemark());
        dbManager.setDouble(41,nyxendorchgdetailDto.getFpremium());
        dbManager.setString(42,nyxendorchgdetailDto.getTeamname());
        dbManager.setDouble(43,nyxendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(44,nyxendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(45,nyxendorchgdetailDto.getCitypremium());
        dbManager.setDouble(46,nyxendorchgdetailDto.getTownpremium());
        dbManager.setDouble(47,nyxendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(48,nyxendorchgdetailDto.getChginsurearea());
        dbManager.setDouble(49,nyxendorchgdetailDto.getChgsumamount());
        dbManager.setDouble(50,nyxendorchgdetailDto.getChgsumpremium());
        dbManager.setDouble(51,nyxendorchgdetailDto.getChgareanumber());
        dbManager.setLong(52,nyxendorchgdetailDto.getChginsurenumber());
        dbManager.setString(53,nyxendorchgdetailDto.getFlag());
        dbManager.setDouble(54,nyxendorchgdetailDto.getAreanumber());
        dbManager.setString(55,nyxendorchgdetailDto.getFieldsource());
        dbManager.setString(56,nyxendorchgdetailDto.getLitterarea());
        dbManager.setString(57,nyxendorchgdetailDto.getAtarea());
        dbManager.setString(58,nyxendorchgdetailDto.getMulchdate());
        dbManager.setString(59,nyxendorchgdetailDto.getMulchtype());
        dbManager.setString(60,nyxendorchgdetailDto.getWarrant());
        dbManager.setString(61,nyxendorchgdetailDto.getTemp1());
        dbManager.setString(62,nyxendorchgdetailDto.getTemp2());
        dbManager.setString(63,nyxendorchgdetailDto.getTemp3());
        dbManager.setString(64,nyxendorchgdetailDto.getTemp4());
        dbManager.setString(65,nyxendorchgdetailDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Endorseno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Fidcard,");
        buffer.append("Insurenumber,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Settlenumber,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
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
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Chginsurearea,");
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Chgareanumber,");
        buffer.append("Chginsurenumber,");
        buffer.append("Flag,");
        buffer.append("Areanumber,");
        buffer.append("Fieldsource,");
        buffer.append("Litterarea,");
        buffer.append("Atarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Warrant,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            NyxendorchgdetailDto nyxendorchgdetailDto = (NyxendorchgdetailDto)i.next();
            dbManager.setString(1,nyxendorchgdetailDto.getInusrelistcode());
            dbManager.setString(2,nyxendorchgdetailDto.getBusinessno());
            dbManager.setString(3,nyxendorchgdetailDto.getEndorseno());
            dbManager.setString(4,nyxendorchgdetailDto.getKindcode());
            dbManager.setString(5,nyxendorchgdetailDto.getItemcode());
            dbManager.setString(6,nyxendorchgdetailDto.getIndexcode());
            dbManager.setString(7,nyxendorchgdetailDto.getFcode());
            dbManager.setString(8,nyxendorchgdetailDto.getFname());
            dbManager.setString(9,nyxendorchgdetailDto.getZhibuka());
            dbManager.setString(10,nyxendorchgdetailDto.getPhone());
            dbManager.setString(11,nyxendorchgdetailDto.getBank());
            dbManager.setString(12,nyxendorchgdetailDto.getBankcard());
            dbManager.setString(13,nyxendorchgdetailDto.getFidcard());
            dbManager.setLong(14,nyxendorchgdetailDto.getInsurenumber());
            dbManager.setString(15,nyxendorchgdetailDto.getBreedingareacode());
            dbManager.setString(16,nyxendorchgdetailDto.getSpecies());
            dbManager.setString(17,nyxendorchgdetailDto.getBreedingkind());
            dbManager.setLong(18,nyxendorchgdetailDto.getBreedingnumber());
            dbManager.setString(19,nyxendorchgdetailDto.getBreedingareaname());
            dbManager.setLong(20,nyxendorchgdetailDto.getSettlenumber());
            dbManager.setString(21,nyxendorchgdetailDto.getClasscode());
            dbManager.setString(22,nyxendorchgdetailDto.getRiskcode());
            dbManager.setString(23,nyxendorchgdetailDto.getFareacode());
            dbManager.setDouble(24,nyxendorchgdetailDto.getTaxarea());
            dbManager.setDouble(25,nyxendorchgdetailDto.getInsurearea());
            dbManager.setDouble(26,nyxendorchgdetailDto.getAmount());
            dbManager.setDouble(27,nyxendorchgdetailDto.getRate());
            dbManager.setString(28,nyxendorchgdetailDto.getShortrateflag());
            dbManager.setDouble(29,nyxendorchgdetailDto.getShortrate());
            dbManager.setDouble(30,nyxendorchgdetailDto.getSumamount());
            dbManager.setDouble(31,nyxendorchgdetailDto.getSumpremium());
            dbManager.setDateTime(32,nyxendorchgdetailDto.getStartdate());
            dbManager.setDateTime(33,nyxendorchgdetailDto.getEnddate());
            dbManager.setString(34,nyxendorchgdetailDto.getStarttime());
            dbManager.setString(35,nyxendorchgdetailDto.getEndtime());
            dbManager.setString(36,nyxendorchgdetailDto.getCalculateflag());
            dbManager.setString(37,nyxendorchgdetailDto.getOpcode());
            dbManager.setDateTime(38,nyxendorchgdetailDto.getOptime());
            dbManager.setString(39,nyxendorchgdetailDto.getValidity());
            dbManager.setString(40,nyxendorchgdetailDto.getRemark());
            dbManager.setDouble(41,nyxendorchgdetailDto.getFpremium());
            dbManager.setString(42,nyxendorchgdetailDto.getTeamname());
            dbManager.setDouble(43,nyxendorchgdetailDto.getCentralpremium());
            dbManager.setDouble(44,nyxendorchgdetailDto.getProvincepremium());
            dbManager.setDouble(45,nyxendorchgdetailDto.getCitypremium());
            dbManager.setDouble(46,nyxendorchgdetailDto.getTownpremium());
            dbManager.setDouble(47,nyxendorchgdetailDto.getOtherpremium());
            dbManager.setDouble(48,nyxendorchgdetailDto.getChginsurearea());
            dbManager.setDouble(49,nyxendorchgdetailDto.getChgsumamount());
            dbManager.setDouble(50,nyxendorchgdetailDto.getChgsumpremium());
            dbManager.setDouble(51,nyxendorchgdetailDto.getChgareanumber());
            dbManager.setLong(52,nyxendorchgdetailDto.getChginsurenumber());
            dbManager.setString(53,nyxendorchgdetailDto.getFlag());
            dbManager.setDouble(54,nyxendorchgdetailDto.getAreanumber());
            dbManager.setString(55,nyxendorchgdetailDto.getFieldsource());
            dbManager.setString(56,nyxendorchgdetailDto.getLitterarea());
            dbManager.setString(57,nyxendorchgdetailDto.getAtarea());
            dbManager.setString(58,nyxendorchgdetailDto.getMulchdate());
            dbManager.setString(59,nyxendorchgdetailDto.getMulchtype());
            dbManager.setString(60,nyxendorchgdetailDto.getWarrant());
            dbManager.setString(61,nyxendorchgdetailDto.getTemp1());
            dbManager.setString(62,nyxendorchgdetailDto.getTemp2());
            dbManager.setString(63,nyxendorchgdetailDto.getTemp3());
            dbManager.setString(64,nyxendorchgdetailDto.getTemp4());
            dbManager.setString(65,nyxendorchgdetailDto.getTemp5());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Nyxendorchgdetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,endorseno);
        dbManager.setString(4,kindcode);
        dbManager.setString(5,itemcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void update(NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxendorchgdetail SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Bankcard = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Insurenumber = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Species = ?, ");
        buffer.append("Breedingkind = ?, ");
        buffer.append("Breedingnumber = ?, ");
        buffer.append("Breedingareaname = ?, ");
        buffer.append("Settlenumber = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Insurearea = ?, ");
        buffer.append("Amount = ?, ");
        buffer.append("Rate = ?, ");
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
        buffer.append("Remark = ?, ");
        buffer.append("Fpremium = ?, ");
        buffer.append("Teamname = ?, ");
        buffer.append("Centralpremium = ?, ");
        buffer.append("Provincepremium = ?, ");
        buffer.append("Citypremium = ?, ");
        buffer.append("Townpremium = ?, ");
        buffer.append("Otherpremium = ?, ");
        buffer.append("Chginsurearea = ?, ");
        buffer.append("Chgsumamount = ?, ");
        buffer.append("Chgsumpremium = ?, ");
        buffer.append("Chgareanumber = ?, ");
        buffer.append("Chginsurenumber = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Areanumber = ?, ");
        buffer.append("Fieldsource = ?, ");
        buffer.append("Litterarea = ?, ");
        buffer.append("Atarea = ?, ");
        buffer.append("Mulchdate = ?, ");
        buffer.append("Mulchtype = ?, ");
        buffer.append("Warrant = ?, ");
        buffer.append("Temp1 = ?, ");
        buffer.append("Temp2 = ?, ");
        buffer.append("Temp3 = ?, ");
        buffer.append("Temp4 = ?, ");
        buffer.append("Temp5 = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Nyxendorchgdetail SET ");
            debugBuffer.append("Indexcode = '" + nyxendorchgdetailDto.getIndexcode() + "', ");
            debugBuffer.append("Fcode = '" + nyxendorchgdetailDto.getFcode() + "', ");
            debugBuffer.append("Fname = '" + nyxendorchgdetailDto.getFname() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxendorchgdetailDto.getZhibuka() + "', ");
            debugBuffer.append("Phone = '" + nyxendorchgdetailDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxendorchgdetailDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + nyxendorchgdetailDto.getBankcard() + "', ");
            debugBuffer.append("Fidcard = '" + nyxendorchgdetailDto.getFidcard() + "', ");
            debugBuffer.append("Insurenumber = " + nyxendorchgdetailDto.getInsurenumber() + ", ");
            debugBuffer.append("Breedingareacode = '" + nyxendorchgdetailDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + nyxendorchgdetailDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxendorchgdetailDto.getBreedingkind() + "', ");
            debugBuffer.append("Breedingnumber = " + nyxendorchgdetailDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + nyxendorchgdetailDto.getBreedingareaname() + "', ");
            debugBuffer.append("Settlenumber = " + nyxendorchgdetailDto.getSettlenumber() + ", ");
            debugBuffer.append("Classcode = '" + nyxendorchgdetailDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxendorchgdetailDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + nyxendorchgdetailDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + nyxendorchgdetailDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + nyxendorchgdetailDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + nyxendorchgdetailDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + nyxendorchgdetailDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + nyxendorchgdetailDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + nyxendorchgdetailDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + nyxendorchgdetailDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + nyxendorchgdetailDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + nyxendorchgdetailDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + nyxendorchgdetailDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + nyxendorchgdetailDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + nyxendorchgdetailDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + nyxendorchgdetailDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + nyxendorchgdetailDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxendorchgdetailDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + nyxendorchgdetailDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + nyxendorchgdetailDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + nyxendorchgdetailDto.getFpremium() + ", ");
            debugBuffer.append("Teamname = '" + nyxendorchgdetailDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + nyxendorchgdetailDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + nyxendorchgdetailDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + nyxendorchgdetailDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + nyxendorchgdetailDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + nyxendorchgdetailDto.getOtherpremium() + ", ");
            debugBuffer.append("Chginsurearea = " + nyxendorchgdetailDto.getChginsurearea() + ", ");
            debugBuffer.append("Chgsumamount = " + nyxendorchgdetailDto.getChgsumamount() + ", ");
            debugBuffer.append("Chgsumpremium = " + nyxendorchgdetailDto.getChgsumpremium() + ", ");
            debugBuffer.append("Chgareanumber = " + nyxendorchgdetailDto.getChgareanumber() + ", ");
            debugBuffer.append("Chginsurenumber = " + nyxendorchgdetailDto.getChginsurenumber() + ", ");
            debugBuffer.append("Flag = '" + nyxendorchgdetailDto.getFlag() + "', ");
            debugBuffer.append("Areanumber = " + nyxendorchgdetailDto.getAreanumber() + ", ");
            debugBuffer.append("Fieldsource = '" + nyxendorchgdetailDto.getFieldsource() + "', ");
            debugBuffer.append("Litterarea = '" + nyxendorchgdetailDto.getLitterarea() + "', ");
            debugBuffer.append("Atarea = '" + nyxendorchgdetailDto.getAtarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxendorchgdetailDto.getMulchdate() + "', ");
            debugBuffer.append("Mulchtype = '" + nyxendorchgdetailDto.getMulchtype() + "', ");
            debugBuffer.append("Warrant = '" + nyxendorchgdetailDto.getWarrant() + "', ");
            debugBuffer.append("Temp1 = '" + nyxendorchgdetailDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxendorchgdetailDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxendorchgdetailDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxendorchgdetailDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxendorchgdetailDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxendorchgdetailDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxendorchgdetailDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(nyxendorchgdetailDto.getEndorseno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxendorchgdetailDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxendorchgdetailDto.getItemcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxendorchgdetailDto.getIndexcode());
        dbManager.setString(2,nyxendorchgdetailDto.getFcode());
        dbManager.setString(3,nyxendorchgdetailDto.getFname());
        dbManager.setString(4,nyxendorchgdetailDto.getZhibuka());
        dbManager.setString(5,nyxendorchgdetailDto.getPhone());
        dbManager.setString(6,nyxendorchgdetailDto.getBank());
        dbManager.setString(7,nyxendorchgdetailDto.getBankcard());
        dbManager.setString(8,nyxendorchgdetailDto.getFidcard());
        dbManager.setLong(9,nyxendorchgdetailDto.getInsurenumber());
        dbManager.setString(10,nyxendorchgdetailDto.getBreedingareacode());
        dbManager.setString(11,nyxendorchgdetailDto.getSpecies());
        dbManager.setString(12,nyxendorchgdetailDto.getBreedingkind());
        dbManager.setLong(13,nyxendorchgdetailDto.getBreedingnumber());
        dbManager.setString(14,nyxendorchgdetailDto.getBreedingareaname());
        dbManager.setLong(15,nyxendorchgdetailDto.getSettlenumber());
        dbManager.setString(16,nyxendorchgdetailDto.getClasscode());
        dbManager.setString(17,nyxendorchgdetailDto.getRiskcode());
        dbManager.setString(18,nyxendorchgdetailDto.getFareacode());
        dbManager.setDouble(19,nyxendorchgdetailDto.getTaxarea());
        dbManager.setDouble(20,nyxendorchgdetailDto.getInsurearea());
        dbManager.setDouble(21,nyxendorchgdetailDto.getAmount());
        dbManager.setDouble(22,nyxendorchgdetailDto.getRate());
        dbManager.setString(23,nyxendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(24,nyxendorchgdetailDto.getShortrate());
        dbManager.setDouble(25,nyxendorchgdetailDto.getSumamount());
        dbManager.setDouble(26,nyxendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(27,nyxendorchgdetailDto.getStartdate());
        dbManager.setDateTime(28,nyxendorchgdetailDto.getEnddate());
        dbManager.setString(29,nyxendorchgdetailDto.getStarttime());
        dbManager.setString(30,nyxendorchgdetailDto.getEndtime());
        dbManager.setString(31,nyxendorchgdetailDto.getCalculateflag());
        dbManager.setString(32,nyxendorchgdetailDto.getOpcode());
        dbManager.setDateTime(33,nyxendorchgdetailDto.getOptime());
        dbManager.setString(34,nyxendorchgdetailDto.getValidity());
        dbManager.setString(35,nyxendorchgdetailDto.getRemark());
        dbManager.setDouble(36,nyxendorchgdetailDto.getFpremium());
        dbManager.setString(37,nyxendorchgdetailDto.getTeamname());
        dbManager.setDouble(38,nyxendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(39,nyxendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(40,nyxendorchgdetailDto.getCitypremium());
        dbManager.setDouble(41,nyxendorchgdetailDto.getTownpremium());
        dbManager.setDouble(42,nyxendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(43,nyxendorchgdetailDto.getChginsurearea());
        dbManager.setDouble(44,nyxendorchgdetailDto.getChgsumamount());
        dbManager.setDouble(45,nyxendorchgdetailDto.getChgsumpremium());
        dbManager.setDouble(46,nyxendorchgdetailDto.getChgareanumber());
        dbManager.setLong(47,nyxendorchgdetailDto.getChginsurenumber());
        dbManager.setString(48,nyxendorchgdetailDto.getFlag());
        dbManager.setDouble(49,nyxendorchgdetailDto.getAreanumber());
        dbManager.setString(50,nyxendorchgdetailDto.getFieldsource());
        dbManager.setString(51,nyxendorchgdetailDto.getLitterarea());
        dbManager.setString(52,nyxendorchgdetailDto.getAtarea());
        dbManager.setString(53,nyxendorchgdetailDto.getMulchdate());
        dbManager.setString(54,nyxendorchgdetailDto.getMulchtype());
        dbManager.setString(55,nyxendorchgdetailDto.getWarrant());
        dbManager.setString(56,nyxendorchgdetailDto.getTemp1());
        dbManager.setString(57,nyxendorchgdetailDto.getTemp2());
        dbManager.setString(58,nyxendorchgdetailDto.getTemp3());
        dbManager.setString(59,nyxendorchgdetailDto.getTemp4());
        dbManager.setString(60,nyxendorchgdetailDto.getTemp5());
        //设置条件字段;
        dbManager.setString(61,nyxendorchgdetailDto.getInusrelistcode());
        dbManager.setString(62,nyxendorchgdetailDto.getBusinessno());
        dbManager.setString(63,nyxendorchgdetailDto.getEndorseno());
        dbManager.setString(64,nyxendorchgdetailDto.getKindcode());
        dbManager.setString(65,nyxendorchgdetailDto.getItemcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return NyxendorchgdetailDto
     * @throws Exception
     */
    public NyxendorchgdetailDto findByPrimaryKey(String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
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
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Fidcard,");
        buffer.append("Insurenumber,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Settlenumber,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
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
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Chginsurearea,");
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Chgareanumber,");
        buffer.append("Chginsurenumber,");
        buffer.append("Flag,");
        buffer.append("Areanumber,");
        buffer.append("Fieldsource,");
        buffer.append("Litterarea,");
        buffer.append("Atarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Warrant,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append("FROM Nyxendorchgdetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Endorseno=").append("'").append(endorseno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Endorseno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,endorseno);
        dbManager.setString(4,kindcode);
        dbManager.setString(5,itemcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        NyxendorchgdetailDto nyxendorchgdetailDto = null;
        if(resultSet.next()){
            nyxendorchgdetailDto = new NyxendorchgdetailDto();
            nyxendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxendorchgdetailDto.setEndorseno(dbManager.getString(resultSet,3));
            nyxendorchgdetailDto.setKindcode(dbManager.getString(resultSet,4));
            nyxendorchgdetailDto.setItemcode(dbManager.getString(resultSet,5));
            nyxendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,6));
            nyxendorchgdetailDto.setFcode(dbManager.getString(resultSet,7));
            nyxendorchgdetailDto.setFname(dbManager.getString(resultSet,8));
            nyxendorchgdetailDto.setZhibuka(dbManager.getString(resultSet,9));
            nyxendorchgdetailDto.setPhone(dbManager.getString(resultSet,10));
            nyxendorchgdetailDto.setBank(dbManager.getString(resultSet,11));
            nyxendorchgdetailDto.setBankcard(dbManager.getString(resultSet,12));
            nyxendorchgdetailDto.setFidcard(dbManager.getString(resultSet,13));
            nyxendorchgdetailDto.setInsurenumber(dbManager.getLong(resultSet,14));
            nyxendorchgdetailDto.setBreedingareacode(dbManager.getString(resultSet,15));
            nyxendorchgdetailDto.setSpecies(dbManager.getString(resultSet,16));
            nyxendorchgdetailDto.setBreedingkind(dbManager.getString(resultSet,17));
            nyxendorchgdetailDto.setBreedingnumber(dbManager.getLong(resultSet,18));
            nyxendorchgdetailDto.setBreedingareaname(dbManager.getString(resultSet,19));
            nyxendorchgdetailDto.setSettlenumber(dbManager.getLong(resultSet,20));
            nyxendorchgdetailDto.setClasscode(dbManager.getString(resultSet,21));
            nyxendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,22));
            nyxendorchgdetailDto.setFareacode(dbManager.getString(resultSet,23));
            nyxendorchgdetailDto.setTaxarea(dbManager.getDouble(resultSet,24));
            nyxendorchgdetailDto.setInsurearea(dbManager.getDouble(resultSet,25));
            nyxendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,26));
            nyxendorchgdetailDto.setRate(dbManager.getDouble(resultSet,27));
            nyxendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,28));
            nyxendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,29));
            nyxendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,30));
            nyxendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,31));
            nyxendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            nyxendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,33));
            nyxendorchgdetailDto.setStarttime(dbManager.getString(resultSet,34));
            nyxendorchgdetailDto.setEndtime(dbManager.getString(resultSet,35));
            nyxendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,36));
            nyxendorchgdetailDto.setOpcode(dbManager.getString(resultSet,37));
            nyxendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,38));
            nyxendorchgdetailDto.setValidity(dbManager.getString(resultSet,39));
            nyxendorchgdetailDto.setRemark(dbManager.getString(resultSet,40));
            nyxendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,41));
            nyxendorchgdetailDto.setTeamname(dbManager.getString(resultSet,42));
            nyxendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,43));
            nyxendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,44));
            nyxendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,45));
            nyxendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,46));
            nyxendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,47));
            nyxendorchgdetailDto.setChginsurearea(dbManager.getDouble(resultSet,48));
            nyxendorchgdetailDto.setChgsumamount(dbManager.getDouble(resultSet,49));
            nyxendorchgdetailDto.setChgsumpremium(dbManager.getDouble(resultSet,50));
            nyxendorchgdetailDto.setChgareanumber(dbManager.getDouble(resultSet,51));
            nyxendorchgdetailDto.setChginsurenumber(dbManager.getLong(resultSet,52));
            nyxendorchgdetailDto.setFlag(dbManager.getString(resultSet,53));
            nyxendorchgdetailDto.setAreanumber(dbManager.getDouble(resultSet,54));
            nyxendorchgdetailDto.setFieldsource(dbManager.getString(resultSet,55));
            nyxendorchgdetailDto.setLitterarea(dbManager.getString(resultSet,56));
            nyxendorchgdetailDto.setAtarea(dbManager.getString(resultSet,57));
            nyxendorchgdetailDto.setMulchdate(dbManager.getString(resultSet,58));
            nyxendorchgdetailDto.setMulchtype(dbManager.getString(resultSet,59));
            nyxendorchgdetailDto.setWarrant(dbManager.getString(resultSet,60));
            nyxendorchgdetailDto.setTemp1(dbManager.getString(resultSet,61));
            nyxendorchgdetailDto.setTemp2(dbManager.getString(resultSet,62));
            nyxendorchgdetailDto.setTemp3(dbManager.getString(resultSet,63));
            nyxendorchgdetailDto.setTemp4(dbManager.getString(resultSet,64));
            nyxendorchgdetailDto.setTemp5(dbManager.getString(resultSet,65));
        }
        resultSet.close();
        return nyxendorchgdetailDto;
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
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Fidcard,");
        buffer.append("Insurenumber,");
        buffer.append("Breedingareacode,");
        buffer.append("Species,");
        buffer.append("Breedingkind,");
        buffer.append("Breedingnumber,");
        buffer.append("Breedingareaname,");
        buffer.append("Settlenumber,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Fareacode,");
        buffer.append("Taxarea,");
        buffer.append("Insurearea,");
        buffer.append("Amount,");
        buffer.append("Rate,");
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
        buffer.append("Remark,");
        buffer.append("Fpremium,");
        buffer.append("Teamname,");
        buffer.append("Centralpremium,");
        buffer.append("Provincepremium,");
        buffer.append("Citypremium,");
        buffer.append("Townpremium,");
        buffer.append("Otherpremium,");
        buffer.append("Chginsurearea,");
        buffer.append("Chgsumamount,");
        buffer.append("Chgsumpremium,");
        buffer.append("Chgareanumber,");
        buffer.append("Chginsurenumber,");
        buffer.append("Flag,");
        buffer.append("Areanumber,");
        buffer.append("Fieldsource,");
        buffer.append("Litterarea,");
        buffer.append("Atarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Warrant,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append("FROM Nyxendorchgdetail WHERE ");
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
        NyxendorchgdetailDto nyxendorchgdetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxendorchgdetailDto = new NyxendorchgdetailDto();
            nyxendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxendorchgdetailDto.setEndorseno(dbManager.getString(resultSet,"Endorseno"));
            nyxendorchgdetailDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxendorchgdetailDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxendorchgdetailDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxendorchgdetailDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxendorchgdetailDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxendorchgdetailDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxendorchgdetailDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxendorchgdetailDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxendorchgdetailDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxendorchgdetailDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxendorchgdetailDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxendorchgdetailDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxendorchgdetailDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxendorchgdetailDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            nyxendorchgdetailDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxendorchgdetailDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            nyxendorchgdetailDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxendorchgdetailDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxendorchgdetailDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxendorchgdetailDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            nyxendorchgdetailDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            nyxendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            nyxendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            nyxendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            nyxendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            nyxendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            nyxendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            nyxendorchgdetailDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            nyxendorchgdetailDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            nyxendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            nyxendorchgdetailDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxendorchgdetailDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxendorchgdetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            nyxendorchgdetailDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            nyxendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            nyxendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            nyxendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            nyxendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            nyxendorchgdetailDto.setChginsurearea(dbManager.getDouble(resultSet,"Chginsurearea"));
            nyxendorchgdetailDto.setChgsumamount(dbManager.getDouble(resultSet,"Chgsumamount"));
            nyxendorchgdetailDto.setChgsumpremium(dbManager.getDouble(resultSet,"Chgsumpremium"));
            nyxendorchgdetailDto.setChgareanumber(dbManager.getDouble(resultSet,"Chgareanumber"));
            nyxendorchgdetailDto.setChginsurenumber(dbManager.getLong(resultSet,"Chginsurenumber"));
            nyxendorchgdetailDto.setFlag(dbManager.getString(resultSet,"Flag"));
            nyxendorchgdetailDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxendorchgdetailDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxendorchgdetailDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxendorchgdetailDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxendorchgdetailDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxendorchgdetailDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxendorchgdetailDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxendorchgdetailDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxendorchgdetailDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxendorchgdetailDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxendorchgdetailDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxendorchgdetailDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxendorchgdetailDto);
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
        buffer.append("DELETE FROM Nyxendorchgdetail WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxendorchgdetail WHERE ");
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
