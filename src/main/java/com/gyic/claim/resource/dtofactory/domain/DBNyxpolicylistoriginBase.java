package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistoriginDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXPOLICYLISTORIGIN的数据访问对象基类<br>
 */
public class DBNyxpolicylistoriginBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxpolicylistoriginBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxpolicylistoriginBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void insert(NyxpolicylistoriginDto nyxpolicylistoriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxpolicylistorigin (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fidcard,");
        buffer.append("Bankcard,");
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
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBankcard()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBreedingkind()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getSettlenumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getFareacode()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getTaxarea()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getAmount()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getRate()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getShortrate()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getSumamount()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getStartdate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getEnddate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getStarttime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getEndtime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getRemark()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getFpremium()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTeamname()).append("',");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getCitypremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getTownpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistoriginDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxpolicylistoriginDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxpolicylistoriginDto.getInusrelistcode());
        dbManager.setString(2,nyxpolicylistoriginDto.getBusinessno());
        dbManager.setString(3,nyxpolicylistoriginDto.getKindcode());
        dbManager.setString(4,nyxpolicylistoriginDto.getItemcode());
        dbManager.setString(5,nyxpolicylistoriginDto.getIndexcode());
        dbManager.setString(6,nyxpolicylistoriginDto.getFcode());
        dbManager.setString(7,nyxpolicylistoriginDto.getFname());
        dbManager.setString(8,nyxpolicylistoriginDto.getZhibuka());
        dbManager.setString(9,nyxpolicylistoriginDto.getPhone());
        dbManager.setString(10,nyxpolicylistoriginDto.getBank());
        dbManager.setString(11,nyxpolicylistoriginDto.getFidcard());
        dbManager.setString(12,nyxpolicylistoriginDto.getBankcard());
        dbManager.setLong(13,nyxpolicylistoriginDto.getInsurenumber());
        dbManager.setString(14,nyxpolicylistoriginDto.getBreedingareacode());
        dbManager.setString(15,nyxpolicylistoriginDto.getSpecies());
        dbManager.setString(16,nyxpolicylistoriginDto.getBreedingkind());
        dbManager.setLong(17,nyxpolicylistoriginDto.getBreedingnumber());
        dbManager.setString(18,nyxpolicylistoriginDto.getBreedingareaname());
        dbManager.setLong(19,nyxpolicylistoriginDto.getSettlenumber());
        dbManager.setString(20,nyxpolicylistoriginDto.getClasscode());
        dbManager.setString(21,nyxpolicylistoriginDto.getRiskcode());
        dbManager.setString(22,nyxpolicylistoriginDto.getFareacode());
        dbManager.setDouble(23,nyxpolicylistoriginDto.getTaxarea());
        dbManager.setDouble(24,nyxpolicylistoriginDto.getInsurearea());
        dbManager.setDouble(25,nyxpolicylistoriginDto.getAmount());
        dbManager.setDouble(26,nyxpolicylistoriginDto.getRate());
        dbManager.setString(27,nyxpolicylistoriginDto.getShortrateflag());
        dbManager.setDouble(28,nyxpolicylistoriginDto.getShortrate());
        dbManager.setDouble(29,nyxpolicylistoriginDto.getSumamount());
        dbManager.setDouble(30,nyxpolicylistoriginDto.getSumpremium());
        dbManager.setDateTime(31,nyxpolicylistoriginDto.getStartdate());
        dbManager.setDateTime(32,nyxpolicylistoriginDto.getEnddate());
        dbManager.setString(33,nyxpolicylistoriginDto.getStarttime());
        dbManager.setString(34,nyxpolicylistoriginDto.getEndtime());
        dbManager.setString(35,nyxpolicylistoriginDto.getCalculateflag());
        dbManager.setString(36,nyxpolicylistoriginDto.getOpcode());
        dbManager.setDateTime(37,nyxpolicylistoriginDto.getOptime());
        dbManager.setString(38,nyxpolicylistoriginDto.getValidity());
        dbManager.setString(39,nyxpolicylistoriginDto.getRemark());
        dbManager.setDouble(40,nyxpolicylistoriginDto.getFpremium());
        dbManager.setString(41,nyxpolicylistoriginDto.getTeamname());
        dbManager.setDouble(42,nyxpolicylistoriginDto.getCentralpremium());
        dbManager.setDouble(43,nyxpolicylistoriginDto.getProvincepremium());
        dbManager.setDouble(44,nyxpolicylistoriginDto.getCitypremium());
        dbManager.setDouble(45,nyxpolicylistoriginDto.getTownpremium());
        dbManager.setDouble(46,nyxpolicylistoriginDto.getOtherpremium());
        dbManager.setDouble(47,nyxpolicylistoriginDto.getAreanumber());
        dbManager.setString(48,nyxpolicylistoriginDto.getFieldsource());
        dbManager.setString(49,nyxpolicylistoriginDto.getLitterarea());
        dbManager.setString(50,nyxpolicylistoriginDto.getAtarea());
        dbManager.setString(51,nyxpolicylistoriginDto.getMulchdate());
        dbManager.setString(52,nyxpolicylistoriginDto.getMulchtype());
        dbManager.setString(53,nyxpolicylistoriginDto.getWarrant());
        dbManager.setString(54,nyxpolicylistoriginDto.getTemp1());
        dbManager.setString(55,nyxpolicylistoriginDto.getTemp2());
        dbManager.setString(56,nyxpolicylistoriginDto.getTemp3());
        dbManager.setString(57,nyxpolicylistoriginDto.getTemp4());
        dbManager.setString(58,nyxpolicylistoriginDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxpolicylistorigin (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fidcard,");
        buffer.append("Bankcard,");
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
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            NyxpolicylistoriginDto nyxpolicylistoriginDto = (NyxpolicylistoriginDto)i.next();
            dbManager.setString(1,nyxpolicylistoriginDto.getInusrelistcode());
            dbManager.setString(2,nyxpolicylistoriginDto.getBusinessno());
            dbManager.setString(3,nyxpolicylistoriginDto.getKindcode());
            dbManager.setString(4,nyxpolicylistoriginDto.getItemcode());
            dbManager.setString(5,nyxpolicylistoriginDto.getIndexcode());
            dbManager.setString(6,nyxpolicylistoriginDto.getFcode());
            dbManager.setString(7,nyxpolicylistoriginDto.getFname());
            dbManager.setString(8,nyxpolicylistoriginDto.getZhibuka());
            dbManager.setString(9,nyxpolicylistoriginDto.getPhone());
            dbManager.setString(10,nyxpolicylistoriginDto.getBank());
            dbManager.setString(11,nyxpolicylistoriginDto.getFidcard());
            dbManager.setString(12,nyxpolicylistoriginDto.getBankcard());
            dbManager.setLong(13,nyxpolicylistoriginDto.getInsurenumber());
            dbManager.setString(14,nyxpolicylistoriginDto.getBreedingareacode());
            dbManager.setString(15,nyxpolicylistoriginDto.getSpecies());
            dbManager.setString(16,nyxpolicylistoriginDto.getBreedingkind());
            dbManager.setLong(17,nyxpolicylistoriginDto.getBreedingnumber());
            dbManager.setString(18,nyxpolicylistoriginDto.getBreedingareaname());
            dbManager.setLong(19,nyxpolicylistoriginDto.getSettlenumber());
            dbManager.setString(20,nyxpolicylistoriginDto.getClasscode());
            dbManager.setString(21,nyxpolicylistoriginDto.getRiskcode());
            dbManager.setString(22,nyxpolicylistoriginDto.getFareacode());
            dbManager.setDouble(23,nyxpolicylistoriginDto.getTaxarea());
            dbManager.setDouble(24,nyxpolicylistoriginDto.getInsurearea());
            dbManager.setDouble(25,nyxpolicylistoriginDto.getAmount());
            dbManager.setDouble(26,nyxpolicylistoriginDto.getRate());
            dbManager.setString(27,nyxpolicylistoriginDto.getShortrateflag());
            dbManager.setDouble(28,nyxpolicylistoriginDto.getShortrate());
            dbManager.setDouble(29,nyxpolicylistoriginDto.getSumamount());
            dbManager.setDouble(30,nyxpolicylistoriginDto.getSumpremium());
            dbManager.setDateTime(31,nyxpolicylistoriginDto.getStartdate());
            dbManager.setDateTime(32,nyxpolicylistoriginDto.getEnddate());
            dbManager.setString(33,nyxpolicylistoriginDto.getStarttime());
            dbManager.setString(34,nyxpolicylistoriginDto.getEndtime());
            dbManager.setString(35,nyxpolicylistoriginDto.getCalculateflag());
            dbManager.setString(36,nyxpolicylistoriginDto.getOpcode());
            dbManager.setDateTime(37,nyxpolicylistoriginDto.getOptime());
            dbManager.setString(38,nyxpolicylistoriginDto.getValidity());
            dbManager.setString(39,nyxpolicylistoriginDto.getRemark());
            dbManager.setDouble(40,nyxpolicylistoriginDto.getFpremium());
            dbManager.setString(41,nyxpolicylistoriginDto.getTeamname());
            dbManager.setDouble(42,nyxpolicylistoriginDto.getCentralpremium());
            dbManager.setDouble(43,nyxpolicylistoriginDto.getProvincepremium());
            dbManager.setDouble(44,nyxpolicylistoriginDto.getCitypremium());
            dbManager.setDouble(45,nyxpolicylistoriginDto.getTownpremium());
            dbManager.setDouble(46,nyxpolicylistoriginDto.getOtherpremium());
            dbManager.setDouble(47,nyxpolicylistoriginDto.getAreanumber());
            dbManager.setString(48,nyxpolicylistoriginDto.getFieldsource());
            dbManager.setString(49,nyxpolicylistoriginDto.getLitterarea());
            dbManager.setString(50,nyxpolicylistoriginDto.getAtarea());
            dbManager.setString(51,nyxpolicylistoriginDto.getMulchdate());
            dbManager.setString(52,nyxpolicylistoriginDto.getMulchtype());
            dbManager.setString(53,nyxpolicylistoriginDto.getWarrant());
            dbManager.setString(54,nyxpolicylistoriginDto.getTemp1());
            dbManager.setString(55,nyxpolicylistoriginDto.getTemp2());
            dbManager.setString(56,nyxpolicylistoriginDto.getTemp3());
            dbManager.setString(57,nyxpolicylistoriginDto.getTemp4());
            dbManager.setString(58,nyxpolicylistoriginDto.getTemp5());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Nyxpolicylistorigin ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param nyxpolicylistoriginDto nyxpolicylistoriginDto
     * @throws Exception
     */
    public void update(NyxpolicylistoriginDto nyxpolicylistoriginDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxpolicylistorigin SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Bankcard = ?, ");
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
            debugBuffer.append("UPDATE Nyxpolicylistorigin SET ");
            debugBuffer.append("Indexcode = '" + nyxpolicylistoriginDto.getIndexcode() + "', ");
            debugBuffer.append("Fcode = '" + nyxpolicylistoriginDto.getFcode() + "', ");
            debugBuffer.append("Fname = '" + nyxpolicylistoriginDto.getFname() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxpolicylistoriginDto.getZhibuka() + "', ");
            debugBuffer.append("Phone = '" + nyxpolicylistoriginDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxpolicylistoriginDto.getBank() + "', ");
            debugBuffer.append("Fidcard = '" + nyxpolicylistoriginDto.getFidcard() + "', ");
            debugBuffer.append("Bankcard = '" + nyxpolicylistoriginDto.getBankcard() + "', ");
            debugBuffer.append("Insurenumber = " + nyxpolicylistoriginDto.getInsurenumber() + ", ");
            debugBuffer.append("Breedingareacode = '" + nyxpolicylistoriginDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + nyxpolicylistoriginDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxpolicylistoriginDto.getBreedingkind() + "', ");
            debugBuffer.append("Breedingnumber = " + nyxpolicylistoriginDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + nyxpolicylistoriginDto.getBreedingareaname() + "', ");
            debugBuffer.append("Settlenumber = " + nyxpolicylistoriginDto.getSettlenumber() + ", ");
            debugBuffer.append("Classcode = '" + nyxpolicylistoriginDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxpolicylistoriginDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + nyxpolicylistoriginDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + nyxpolicylistoriginDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + nyxpolicylistoriginDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + nyxpolicylistoriginDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + nyxpolicylistoriginDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + nyxpolicylistoriginDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + nyxpolicylistoriginDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + nyxpolicylistoriginDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + nyxpolicylistoriginDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + nyxpolicylistoriginDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + nyxpolicylistoriginDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + nyxpolicylistoriginDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + nyxpolicylistoriginDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + nyxpolicylistoriginDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + nyxpolicylistoriginDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxpolicylistoriginDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + nyxpolicylistoriginDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + nyxpolicylistoriginDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + nyxpolicylistoriginDto.getFpremium() + ", ");
            debugBuffer.append("Teamname = '" + nyxpolicylistoriginDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + nyxpolicylistoriginDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + nyxpolicylistoriginDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + nyxpolicylistoriginDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + nyxpolicylistoriginDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + nyxpolicylistoriginDto.getOtherpremium() + ", ");
            debugBuffer.append("Areanumber = " + nyxpolicylistoriginDto.getAreanumber() + ", ");
            debugBuffer.append("Fieldsource = '" + nyxpolicylistoriginDto.getFieldsource() + "', ");
            debugBuffer.append("Litterarea = '" + nyxpolicylistoriginDto.getLitterarea() + "', ");
            debugBuffer.append("Atarea = '" + nyxpolicylistoriginDto.getAtarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxpolicylistoriginDto.getMulchdate() + "', ");
            debugBuffer.append("Mulchtype = '" + nyxpolicylistoriginDto.getMulchtype() + "', ");
            debugBuffer.append("Warrant = '" + nyxpolicylistoriginDto.getWarrant() + "', ");
            debugBuffer.append("Temp1 = '" + nyxpolicylistoriginDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxpolicylistoriginDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxpolicylistoriginDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxpolicylistoriginDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxpolicylistoriginDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxpolicylistoriginDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxpolicylistoriginDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxpolicylistoriginDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxpolicylistoriginDto.getItemcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxpolicylistoriginDto.getIndexcode());
        dbManager.setString(2,nyxpolicylistoriginDto.getFcode());
        dbManager.setString(3,nyxpolicylistoriginDto.getFname());
        dbManager.setString(4,nyxpolicylistoriginDto.getZhibuka());
        dbManager.setString(5,nyxpolicylistoriginDto.getPhone());
        dbManager.setString(6,nyxpolicylistoriginDto.getBank());
        dbManager.setString(7,nyxpolicylistoriginDto.getFidcard());
        dbManager.setString(8,nyxpolicylistoriginDto.getBankcard());
        dbManager.setLong(9,nyxpolicylistoriginDto.getInsurenumber());
        dbManager.setString(10,nyxpolicylistoriginDto.getBreedingareacode());
        dbManager.setString(11,nyxpolicylistoriginDto.getSpecies());
        dbManager.setString(12,nyxpolicylistoriginDto.getBreedingkind());
        dbManager.setLong(13,nyxpolicylistoriginDto.getBreedingnumber());
        dbManager.setString(14,nyxpolicylistoriginDto.getBreedingareaname());
        dbManager.setLong(15,nyxpolicylistoriginDto.getSettlenumber());
        dbManager.setString(16,nyxpolicylistoriginDto.getClasscode());
        dbManager.setString(17,nyxpolicylistoriginDto.getRiskcode());
        dbManager.setString(18,nyxpolicylistoriginDto.getFareacode());
        dbManager.setDouble(19,nyxpolicylistoriginDto.getTaxarea());
        dbManager.setDouble(20,nyxpolicylistoriginDto.getInsurearea());
        dbManager.setDouble(21,nyxpolicylistoriginDto.getAmount());
        dbManager.setDouble(22,nyxpolicylistoriginDto.getRate());
        dbManager.setString(23,nyxpolicylistoriginDto.getShortrateflag());
        dbManager.setDouble(24,nyxpolicylistoriginDto.getShortrate());
        dbManager.setDouble(25,nyxpolicylistoriginDto.getSumamount());
        dbManager.setDouble(26,nyxpolicylistoriginDto.getSumpremium());
        dbManager.setDateTime(27,nyxpolicylistoriginDto.getStartdate());
        dbManager.setDateTime(28,nyxpolicylistoriginDto.getEnddate());
        dbManager.setString(29,nyxpolicylistoriginDto.getStarttime());
        dbManager.setString(30,nyxpolicylistoriginDto.getEndtime());
        dbManager.setString(31,nyxpolicylistoriginDto.getCalculateflag());
        dbManager.setString(32,nyxpolicylistoriginDto.getOpcode());
        dbManager.setDateTime(33,nyxpolicylistoriginDto.getOptime());
        dbManager.setString(34,nyxpolicylistoriginDto.getValidity());
        dbManager.setString(35,nyxpolicylistoriginDto.getRemark());
        dbManager.setDouble(36,nyxpolicylistoriginDto.getFpremium());
        dbManager.setString(37,nyxpolicylistoriginDto.getTeamname());
        dbManager.setDouble(38,nyxpolicylistoriginDto.getCentralpremium());
        dbManager.setDouble(39,nyxpolicylistoriginDto.getProvincepremium());
        dbManager.setDouble(40,nyxpolicylistoriginDto.getCitypremium());
        dbManager.setDouble(41,nyxpolicylistoriginDto.getTownpremium());
        dbManager.setDouble(42,nyxpolicylistoriginDto.getOtherpremium());
        dbManager.setDouble(43,nyxpolicylistoriginDto.getAreanumber());
        dbManager.setString(44,nyxpolicylistoriginDto.getFieldsource());
        dbManager.setString(45,nyxpolicylistoriginDto.getLitterarea());
        dbManager.setString(46,nyxpolicylistoriginDto.getAtarea());
        dbManager.setString(47,nyxpolicylistoriginDto.getMulchdate());
        dbManager.setString(48,nyxpolicylistoriginDto.getMulchtype());
        dbManager.setString(49,nyxpolicylistoriginDto.getWarrant());
        dbManager.setString(50,nyxpolicylistoriginDto.getTemp1());
        dbManager.setString(51,nyxpolicylistoriginDto.getTemp2());
        dbManager.setString(52,nyxpolicylistoriginDto.getTemp3());
        dbManager.setString(53,nyxpolicylistoriginDto.getTemp4());
        dbManager.setString(54,nyxpolicylistoriginDto.getTemp5());
        //设置条件字段;
        dbManager.setString(55,nyxpolicylistoriginDto.getInusrelistcode());
        dbManager.setString(56,nyxpolicylistoriginDto.getBusinessno());
        dbManager.setString(57,nyxpolicylistoriginDto.getKindcode());
        dbManager.setString(58,nyxpolicylistoriginDto.getItemcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return NyxpolicylistoriginDto
     * @throws Exception
     */
    public NyxpolicylistoriginDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fidcard,");
        buffer.append("Bankcard,");
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
        buffer.append("FROM Nyxpolicylistorigin ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        NyxpolicylistoriginDto nyxpolicylistoriginDto = null;
        if(resultSet.next()){
            nyxpolicylistoriginDto = new NyxpolicylistoriginDto();
            nyxpolicylistoriginDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxpolicylistoriginDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxpolicylistoriginDto.setKindcode(dbManager.getString(resultSet,3));
            nyxpolicylistoriginDto.setItemcode(dbManager.getString(resultSet,4));
            nyxpolicylistoriginDto.setIndexcode(dbManager.getString(resultSet,5));
            nyxpolicylistoriginDto.setFcode(dbManager.getString(resultSet,6));
            nyxpolicylistoriginDto.setFname(dbManager.getString(resultSet,7));
            nyxpolicylistoriginDto.setZhibuka(dbManager.getString(resultSet,8));
            nyxpolicylistoriginDto.setPhone(dbManager.getString(resultSet,9));
            nyxpolicylistoriginDto.setBank(dbManager.getString(resultSet,10));
            nyxpolicylistoriginDto.setFidcard(dbManager.getString(resultSet,11));
            nyxpolicylistoriginDto.setBankcard(dbManager.getString(resultSet,12));
            nyxpolicylistoriginDto.setInsurenumber(dbManager.getLong(resultSet,13));
            nyxpolicylistoriginDto.setBreedingareacode(dbManager.getString(resultSet,14));
            nyxpolicylistoriginDto.setSpecies(dbManager.getString(resultSet,15));
            nyxpolicylistoriginDto.setBreedingkind(dbManager.getString(resultSet,16));
            nyxpolicylistoriginDto.setBreedingnumber(dbManager.getLong(resultSet,17));
            nyxpolicylistoriginDto.setBreedingareaname(dbManager.getString(resultSet,18));
            nyxpolicylistoriginDto.setSettlenumber(dbManager.getLong(resultSet,19));
            nyxpolicylistoriginDto.setClasscode(dbManager.getString(resultSet,20));
            nyxpolicylistoriginDto.setRiskcode(dbManager.getString(resultSet,21));
            nyxpolicylistoriginDto.setFareacode(dbManager.getString(resultSet,22));
            nyxpolicylistoriginDto.setTaxarea(dbManager.getDouble(resultSet,23));
            nyxpolicylistoriginDto.setInsurearea(dbManager.getDouble(resultSet,24));
            nyxpolicylistoriginDto.setAmount(dbManager.getDouble(resultSet,25));
            nyxpolicylistoriginDto.setRate(dbManager.getDouble(resultSet,26));
            nyxpolicylistoriginDto.setShortrateflag(dbManager.getString(resultSet,27));
            nyxpolicylistoriginDto.setShortrate(dbManager.getDouble(resultSet,28));
            nyxpolicylistoriginDto.setSumamount(dbManager.getDouble(resultSet,29));
            nyxpolicylistoriginDto.setSumpremium(dbManager.getDouble(resultSet,30));
            nyxpolicylistoriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            nyxpolicylistoriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            nyxpolicylistoriginDto.setStarttime(dbManager.getString(resultSet,33));
            nyxpolicylistoriginDto.setEndtime(dbManager.getString(resultSet,34));
            nyxpolicylistoriginDto.setCalculateflag(dbManager.getString(resultSet,35));
            nyxpolicylistoriginDto.setOpcode(dbManager.getString(resultSet,36));
            nyxpolicylistoriginDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            nyxpolicylistoriginDto.setValidity(dbManager.getString(resultSet,38));
            nyxpolicylistoriginDto.setRemark(dbManager.getString(resultSet,39));
            nyxpolicylistoriginDto.setFpremium(dbManager.getDouble(resultSet,40));
            nyxpolicylistoriginDto.setTeamname(dbManager.getString(resultSet,41));
            nyxpolicylistoriginDto.setCentralpremium(dbManager.getDouble(resultSet,42));
            nyxpolicylistoriginDto.setProvincepremium(dbManager.getDouble(resultSet,43));
            nyxpolicylistoriginDto.setCitypremium(dbManager.getDouble(resultSet,44));
            nyxpolicylistoriginDto.setTownpremium(dbManager.getDouble(resultSet,45));
            nyxpolicylistoriginDto.setOtherpremium(dbManager.getDouble(resultSet,46));
            nyxpolicylistoriginDto.setAreanumber(dbManager.getDouble(resultSet,47));
            nyxpolicylistoriginDto.setFieldsource(dbManager.getString(resultSet,48));
            nyxpolicylistoriginDto.setLitterarea(dbManager.getString(resultSet,49));
            nyxpolicylistoriginDto.setAtarea(dbManager.getString(resultSet,50));
            nyxpolicylistoriginDto.setMulchdate(dbManager.getString(resultSet,51));
            nyxpolicylistoriginDto.setMulchtype(dbManager.getString(resultSet,52));
            nyxpolicylistoriginDto.setWarrant(dbManager.getString(resultSet,53));
            nyxpolicylistoriginDto.setTemp1(dbManager.getString(resultSet,54));
            nyxpolicylistoriginDto.setTemp2(dbManager.getString(resultSet,55));
            nyxpolicylistoriginDto.setTemp3(dbManager.getString(resultSet,56));
            nyxpolicylistoriginDto.setTemp4(dbManager.getString(resultSet,57));
            nyxpolicylistoriginDto.setTemp5(dbManager.getString(resultSet,58));
        }
        resultSet.close();
        return nyxpolicylistoriginDto;
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
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Zhibuka,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fidcard,");
        buffer.append("Bankcard,");
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
        buffer.append("FROM Nyxpolicylistorigin WHERE ");
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
        NyxpolicylistoriginDto nyxpolicylistoriginDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxpolicylistoriginDto = new NyxpolicylistoriginDto();
            nyxpolicylistoriginDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxpolicylistoriginDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxpolicylistoriginDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxpolicylistoriginDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxpolicylistoriginDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxpolicylistoriginDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxpolicylistoriginDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxpolicylistoriginDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxpolicylistoriginDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxpolicylistoriginDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxpolicylistoriginDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxpolicylistoriginDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxpolicylistoriginDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxpolicylistoriginDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxpolicylistoriginDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxpolicylistoriginDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxpolicylistoriginDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            nyxpolicylistoriginDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxpolicylistoriginDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            nyxpolicylistoriginDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxpolicylistoriginDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxpolicylistoriginDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxpolicylistoriginDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxpolicylistoriginDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxpolicylistoriginDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            nyxpolicylistoriginDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            nyxpolicylistoriginDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            nyxpolicylistoriginDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            nyxpolicylistoriginDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            nyxpolicylistoriginDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            nyxpolicylistoriginDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            nyxpolicylistoriginDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            nyxpolicylistoriginDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            nyxpolicylistoriginDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            nyxpolicylistoriginDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            nyxpolicylistoriginDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxpolicylistoriginDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxpolicylistoriginDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxpolicylistoriginDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxpolicylistoriginDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            nyxpolicylistoriginDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxpolicylistoriginDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            nyxpolicylistoriginDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            nyxpolicylistoriginDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            nyxpolicylistoriginDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            nyxpolicylistoriginDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            nyxpolicylistoriginDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxpolicylistoriginDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxpolicylistoriginDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxpolicylistoriginDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxpolicylistoriginDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxpolicylistoriginDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxpolicylistoriginDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxpolicylistoriginDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxpolicylistoriginDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxpolicylistoriginDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxpolicylistoriginDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxpolicylistoriginDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxpolicylistoriginDto);
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
        buffer.append("DELETE FROM Nyxpolicylistorigin WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxpolicylistorigin WHERE ");
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
