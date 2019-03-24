package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXPOLICYLIST的数据访问对象基类<br>
 */
public class DBNyxpolicylistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxpolicylistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxpolicylistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void insert(NyxpolicylistDto nyxpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxpolicylist (");
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
        buffer.append("Fidcard,");
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
            debugBuffer.append("'").append(nyxpolicylistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getBankcard()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getBreedingkind()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getSettlenumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getFareacode()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getTaxarea()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getAmount()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getRate()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getShortrate()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getSumamount()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getEndtime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getRemark()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getFpremium()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTeamname()).append("',");
            debugBuffer.append("").append(nyxpolicylistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(nyxpolicylistDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxpolicylistDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxpolicylistDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxpolicylistDto.getInusrelistcode());
        dbManager.setString(2,nyxpolicylistDto.getBusinessno());
        dbManager.setString(3,nyxpolicylistDto.getKindcode());
        dbManager.setString(4,nyxpolicylistDto.getItemcode());
        dbManager.setString(5,nyxpolicylistDto.getIndexcode());
        dbManager.setString(6,nyxpolicylistDto.getFcode());
        dbManager.setString(7,nyxpolicylistDto.getFname());
        dbManager.setString(8,nyxpolicylistDto.getZhibuka());
        dbManager.setString(9,nyxpolicylistDto.getPhone());
        dbManager.setString(10,nyxpolicylistDto.getBank());
        dbManager.setString(11,nyxpolicylistDto.getBankcard());
        dbManager.setLong(12,nyxpolicylistDto.getInsurenumber());
        dbManager.setString(13,nyxpolicylistDto.getBreedingareacode());
        dbManager.setString(14,nyxpolicylistDto.getSpecies());
        dbManager.setString(15,nyxpolicylistDto.getBreedingkind());
        dbManager.setLong(16,nyxpolicylistDto.getBreedingnumber());
        dbManager.setString(17,nyxpolicylistDto.getBreedingareaname());
        dbManager.setLong(18,nyxpolicylistDto.getSettlenumber());
        dbManager.setString(19,nyxpolicylistDto.getClasscode());
        dbManager.setString(20,nyxpolicylistDto.getRiskcode());
        dbManager.setString(21,nyxpolicylistDto.getFareacode());
        dbManager.setDouble(22,nyxpolicylistDto.getTaxarea());
        dbManager.setDouble(23,nyxpolicylistDto.getInsurearea());
        dbManager.setDouble(24,nyxpolicylistDto.getAmount());
        dbManager.setDouble(25,nyxpolicylistDto.getRate());
        dbManager.setString(26,nyxpolicylistDto.getShortrateflag());
        dbManager.setDouble(27,nyxpolicylistDto.getShortrate());
        dbManager.setDouble(28,nyxpolicylistDto.getSumamount());
        dbManager.setDouble(29,nyxpolicylistDto.getSumpremium());
        dbManager.setDateTime(30,nyxpolicylistDto.getStartdate());
        dbManager.setDateTime(31,nyxpolicylistDto.getEnddate());
        dbManager.setString(32,nyxpolicylistDto.getStarttime());
        dbManager.setString(33,nyxpolicylistDto.getEndtime());
        dbManager.setString(34,nyxpolicylistDto.getCalculateflag());
        dbManager.setString(35,nyxpolicylistDto.getOpcode());
        dbManager.setDateTime(36,nyxpolicylistDto.getOptime());
        dbManager.setString(37,nyxpolicylistDto.getValidity());
        dbManager.setString(38,nyxpolicylistDto.getRemark());
        dbManager.setDouble(39,nyxpolicylistDto.getFpremium());
        dbManager.setString(40,nyxpolicylistDto.getFidcard());
        dbManager.setString(41,nyxpolicylistDto.getTeamname());
        dbManager.setDouble(42,nyxpolicylistDto.getCentralpremium());
        dbManager.setDouble(43,nyxpolicylistDto.getProvincepremium());
        dbManager.setDouble(44,nyxpolicylistDto.getCitypremium());
        dbManager.setDouble(45,nyxpolicylistDto.getTownpremium());
        dbManager.setDouble(46,nyxpolicylistDto.getOtherpremium());
        dbManager.setDouble(47,nyxpolicylistDto.getAreanumber());
        dbManager.setString(48,nyxpolicylistDto.getFieldsource());
        dbManager.setString(49,nyxpolicylistDto.getLitterarea());
        dbManager.setString(50,nyxpolicylistDto.getAtarea());
        dbManager.setString(51,nyxpolicylistDto.getMulchdate());
        dbManager.setString(52,nyxpolicylistDto.getMulchtype());
        dbManager.setString(53,nyxpolicylistDto.getWarrant());
        dbManager.setString(54,nyxpolicylistDto.getTemp1());
        dbManager.setString(55,nyxpolicylistDto.getTemp2());
        dbManager.setString(56,nyxpolicylistDto.getTemp3());
        dbManager.setString(57,nyxpolicylistDto.getTemp4());
        dbManager.setString(58,nyxpolicylistDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxpolicylist (");
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
        buffer.append("Fidcard,");
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
            NyxpolicylistDto nyxpolicylistDto = (NyxpolicylistDto)i.next();
            dbManager.setString(1,nyxpolicylistDto.getInusrelistcode());
            dbManager.setString(2,nyxpolicylistDto.getBusinessno());
            dbManager.setString(3,nyxpolicylistDto.getKindcode());
            dbManager.setString(4,nyxpolicylistDto.getItemcode());
            dbManager.setString(5,nyxpolicylistDto.getIndexcode());
            dbManager.setString(6,nyxpolicylistDto.getFcode());
            dbManager.setString(7,nyxpolicylistDto.getFname());
            dbManager.setString(8,nyxpolicylistDto.getZhibuka());
            dbManager.setString(9,nyxpolicylistDto.getPhone());
            dbManager.setString(10,nyxpolicylistDto.getBank());
            dbManager.setString(11,nyxpolicylistDto.getBankcard());
            dbManager.setLong(12,nyxpolicylistDto.getInsurenumber());
            dbManager.setString(13,nyxpolicylistDto.getBreedingareacode());
            dbManager.setString(14,nyxpolicylistDto.getSpecies());
            dbManager.setString(15,nyxpolicylistDto.getBreedingkind());
            dbManager.setLong(16,nyxpolicylistDto.getBreedingnumber());
            dbManager.setString(17,nyxpolicylistDto.getBreedingareaname());
            dbManager.setLong(18,nyxpolicylistDto.getSettlenumber());
            dbManager.setString(19,nyxpolicylistDto.getClasscode());
            dbManager.setString(20,nyxpolicylistDto.getRiskcode());
            dbManager.setString(21,nyxpolicylistDto.getFareacode());
            dbManager.setDouble(22,nyxpolicylistDto.getTaxarea());
            dbManager.setDouble(23,nyxpolicylistDto.getInsurearea());
            dbManager.setDouble(24,nyxpolicylistDto.getAmount());
            dbManager.setDouble(25,nyxpolicylistDto.getRate());
            dbManager.setString(26,nyxpolicylistDto.getShortrateflag());
            dbManager.setDouble(27,nyxpolicylistDto.getShortrate());
            dbManager.setDouble(28,nyxpolicylistDto.getSumamount());
            dbManager.setDouble(29,nyxpolicylistDto.getSumpremium());
            dbManager.setDateTime(30,nyxpolicylistDto.getStartdate());
            dbManager.setDateTime(31,nyxpolicylistDto.getEnddate());
            dbManager.setString(32,nyxpolicylistDto.getStarttime());
            dbManager.setString(33,nyxpolicylistDto.getEndtime());
            dbManager.setString(34,nyxpolicylistDto.getCalculateflag());
            dbManager.setString(35,nyxpolicylistDto.getOpcode());
            dbManager.setDateTime(36,nyxpolicylistDto.getOptime());
            dbManager.setString(37,nyxpolicylistDto.getValidity());
            dbManager.setString(38,nyxpolicylistDto.getRemark());
            dbManager.setDouble(39,nyxpolicylistDto.getFpremium());
            dbManager.setString(40,nyxpolicylistDto.getFidcard());
            dbManager.setString(41,nyxpolicylistDto.getTeamname());
            dbManager.setDouble(42,nyxpolicylistDto.getCentralpremium());
            dbManager.setDouble(43,nyxpolicylistDto.getProvincepremium());
            dbManager.setDouble(44,nyxpolicylistDto.getCitypremium());
            dbManager.setDouble(45,nyxpolicylistDto.getTownpremium());
            dbManager.setDouble(46,nyxpolicylistDto.getOtherpremium());
            dbManager.setDouble(47,nyxpolicylistDto.getAreanumber());
            dbManager.setString(48,nyxpolicylistDto.getFieldsource());
            dbManager.setString(49,nyxpolicylistDto.getLitterarea());
            dbManager.setString(50,nyxpolicylistDto.getAtarea());
            dbManager.setString(51,nyxpolicylistDto.getMulchdate());
            dbManager.setString(52,nyxpolicylistDto.getMulchtype());
            dbManager.setString(53,nyxpolicylistDto.getWarrant());
            dbManager.setString(54,nyxpolicylistDto.getTemp1());
            dbManager.setString(55,nyxpolicylistDto.getTemp2());
            dbManager.setString(56,nyxpolicylistDto.getTemp3());
            dbManager.setString(57,nyxpolicylistDto.getTemp4());
            dbManager.setString(58,nyxpolicylistDto.getTemp5());
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
        buffer.append("DELETE FROM Nyxpolicylist ");
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
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void update(NyxpolicylistDto nyxpolicylistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxpolicylist SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
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
        buffer.append("Fidcard = ?, ");
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
            debugBuffer.append("UPDATE Nyxpolicylist SET ");
            debugBuffer.append("Indexcode = '" + nyxpolicylistDto.getIndexcode() + "', ");
            debugBuffer.append("Fcode = '" + nyxpolicylistDto.getFcode() + "', ");
            debugBuffer.append("Fname = '" + nyxpolicylistDto.getFname() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxpolicylistDto.getZhibuka() + "', ");
            debugBuffer.append("Phone = '" + nyxpolicylistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxpolicylistDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + nyxpolicylistDto.getBankcard() + "', ");
            debugBuffer.append("Insurenumber = " + nyxpolicylistDto.getInsurenumber() + ", ");
            debugBuffer.append("Breedingareacode = '" + nyxpolicylistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + nyxpolicylistDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxpolicylistDto.getBreedingkind() + "', ");
            debugBuffer.append("Breedingnumber = " + nyxpolicylistDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + nyxpolicylistDto.getBreedingareaname() + "', ");
            debugBuffer.append("Settlenumber = " + nyxpolicylistDto.getSettlenumber() + ", ");
            debugBuffer.append("Classcode = '" + nyxpolicylistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxpolicylistDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + nyxpolicylistDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + nyxpolicylistDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + nyxpolicylistDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + nyxpolicylistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + nyxpolicylistDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + nyxpolicylistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + nyxpolicylistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + nyxpolicylistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + nyxpolicylistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + nyxpolicylistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + nyxpolicylistDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + nyxpolicylistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + nyxpolicylistDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + nyxpolicylistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + nyxpolicylistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxpolicylistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + nyxpolicylistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + nyxpolicylistDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + nyxpolicylistDto.getFpremium() + ", ");
            debugBuffer.append("Fidcard = '" + nyxpolicylistDto.getFidcard() + "', ");
            debugBuffer.append("Teamname = '" + nyxpolicylistDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + nyxpolicylistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + nyxpolicylistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + nyxpolicylistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + nyxpolicylistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + nyxpolicylistDto.getOtherpremium() + ", ");
            debugBuffer.append("Areanumber = " + nyxpolicylistDto.getAreanumber() + ", ");
            debugBuffer.append("Fieldsource = '" + nyxpolicylistDto.getFieldsource() + "', ");
            debugBuffer.append("Litterarea = '" + nyxpolicylistDto.getLitterarea() + "', ");
            debugBuffer.append("Atarea = '" + nyxpolicylistDto.getAtarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxpolicylistDto.getMulchdate() + "', ");
            debugBuffer.append("Mulchtype = '" + nyxpolicylistDto.getMulchtype() + "', ");
            debugBuffer.append("Warrant = '" + nyxpolicylistDto.getWarrant() + "', ");
            debugBuffer.append("Temp1 = '" + nyxpolicylistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxpolicylistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxpolicylistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxpolicylistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxpolicylistDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxpolicylistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxpolicylistDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxpolicylistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxpolicylistDto.getItemcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxpolicylistDto.getIndexcode());
        dbManager.setString(2,nyxpolicylistDto.getFcode());
        dbManager.setString(3,nyxpolicylistDto.getFname());
        dbManager.setString(4,nyxpolicylistDto.getZhibuka());
        dbManager.setString(5,nyxpolicylistDto.getPhone());
        dbManager.setString(6,nyxpolicylistDto.getBank());
        dbManager.setString(7,nyxpolicylistDto.getBankcard());
        dbManager.setLong(8,nyxpolicylistDto.getInsurenumber());
        dbManager.setString(9,nyxpolicylistDto.getBreedingareacode());
        dbManager.setString(10,nyxpolicylistDto.getSpecies());
        dbManager.setString(11,nyxpolicylistDto.getBreedingkind());
        dbManager.setLong(12,nyxpolicylistDto.getBreedingnumber());
        dbManager.setString(13,nyxpolicylistDto.getBreedingareaname());
        dbManager.setLong(14,nyxpolicylistDto.getSettlenumber());
        dbManager.setString(15,nyxpolicylistDto.getClasscode());
        dbManager.setString(16,nyxpolicylistDto.getRiskcode());
        dbManager.setString(17,nyxpolicylistDto.getFareacode());
        dbManager.setDouble(18,nyxpolicylistDto.getTaxarea());
        dbManager.setDouble(19,nyxpolicylistDto.getInsurearea());
        dbManager.setDouble(20,nyxpolicylistDto.getAmount());
        dbManager.setDouble(21,nyxpolicylistDto.getRate());
        dbManager.setString(22,nyxpolicylistDto.getShortrateflag());
        dbManager.setDouble(23,nyxpolicylistDto.getShortrate());
        dbManager.setDouble(24,nyxpolicylistDto.getSumamount());
        dbManager.setDouble(25,nyxpolicylistDto.getSumpremium());
        dbManager.setDateTime(26,nyxpolicylistDto.getStartdate());
        dbManager.setDateTime(27,nyxpolicylistDto.getEnddate());
        dbManager.setString(28,nyxpolicylistDto.getStarttime());
        dbManager.setString(29,nyxpolicylistDto.getEndtime());
        dbManager.setString(30,nyxpolicylistDto.getCalculateflag());
        dbManager.setString(31,nyxpolicylistDto.getOpcode());
        dbManager.setDateTime(32,nyxpolicylistDto.getOptime());
        dbManager.setString(33,nyxpolicylistDto.getValidity());
        dbManager.setString(34,nyxpolicylistDto.getRemark());
        dbManager.setDouble(35,nyxpolicylistDto.getFpremium());
        dbManager.setString(36,nyxpolicylistDto.getFidcard());
        dbManager.setString(37,nyxpolicylistDto.getTeamname());
        dbManager.setDouble(38,nyxpolicylistDto.getCentralpremium());
        dbManager.setDouble(39,nyxpolicylistDto.getProvincepremium());
        dbManager.setDouble(40,nyxpolicylistDto.getCitypremium());
        dbManager.setDouble(41,nyxpolicylistDto.getTownpremium());
        dbManager.setDouble(42,nyxpolicylistDto.getOtherpremium());
        dbManager.setDouble(43,nyxpolicylistDto.getAreanumber());
        dbManager.setString(44,nyxpolicylistDto.getFieldsource());
        dbManager.setString(45,nyxpolicylistDto.getLitterarea());
        dbManager.setString(46,nyxpolicylistDto.getAtarea());
        dbManager.setString(47,nyxpolicylistDto.getMulchdate());
        dbManager.setString(48,nyxpolicylistDto.getMulchtype());
        dbManager.setString(49,nyxpolicylistDto.getWarrant());
        dbManager.setString(50,nyxpolicylistDto.getTemp1());
        dbManager.setString(51,nyxpolicylistDto.getTemp2());
        dbManager.setString(52,nyxpolicylistDto.getTemp3());
        dbManager.setString(53,nyxpolicylistDto.getTemp4());
        dbManager.setString(54,nyxpolicylistDto.getTemp5());
        //设置条件字段;
        dbManager.setString(55,nyxpolicylistDto.getInusrelistcode());
        dbManager.setString(56,nyxpolicylistDto.getBusinessno());
        dbManager.setString(57,nyxpolicylistDto.getKindcode());
        dbManager.setString(58,nyxpolicylistDto.getItemcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return NyxpolicylistDto
     * @throws Exception
     */
    public NyxpolicylistDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxpolicylist ");
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
        NyxpolicylistDto nyxpolicylistDto = null;
        if(resultSet.next()){
            nyxpolicylistDto = new NyxpolicylistDto();
            nyxpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxpolicylistDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxpolicylistDto.setKindcode(dbManager.getString(resultSet,3));
            nyxpolicylistDto.setItemcode(dbManager.getString(resultSet,4));
            nyxpolicylistDto.setIndexcode(dbManager.getString(resultSet,5));
            nyxpolicylistDto.setFcode(dbManager.getString(resultSet,6));
            nyxpolicylistDto.setFname(dbManager.getString(resultSet,7));
            nyxpolicylistDto.setZhibuka(dbManager.getString(resultSet,8));
            nyxpolicylistDto.setPhone(dbManager.getString(resultSet,9));
            nyxpolicylistDto.setBank(dbManager.getString(resultSet,10));
            nyxpolicylistDto.setBankcard(dbManager.getString(resultSet,11));
            nyxpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,12));
            nyxpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,13));
            nyxpolicylistDto.setSpecies(dbManager.getString(resultSet,14));
            nyxpolicylistDto.setBreedingkind(dbManager.getString(resultSet,15));
            nyxpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,16));
            nyxpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,17));
            nyxpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,18));
            nyxpolicylistDto.setClasscode(dbManager.getString(resultSet,19));
            nyxpolicylistDto.setRiskcode(dbManager.getString(resultSet,20));
            nyxpolicylistDto.setFareacode(dbManager.getString(resultSet,21));
            nyxpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,22));
            nyxpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,23));
            nyxpolicylistDto.setAmount(dbManager.getDouble(resultSet,24));
            nyxpolicylistDto.setRate(dbManager.getDouble(resultSet,25));
            nyxpolicylistDto.setShortrateflag(dbManager.getString(resultSet,26));
            nyxpolicylistDto.setShortrate(dbManager.getDouble(resultSet,27));
            nyxpolicylistDto.setSumamount(dbManager.getDouble(resultSet,28));
            nyxpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,29));
            nyxpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            nyxpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            nyxpolicylistDto.setStarttime(dbManager.getString(resultSet,32));
            nyxpolicylistDto.setEndtime(dbManager.getString(resultSet,33));
            nyxpolicylistDto.setCalculateflag(dbManager.getString(resultSet,34));
            nyxpolicylistDto.setOpcode(dbManager.getString(resultSet,35));
            nyxpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,36));
            nyxpolicylistDto.setValidity(dbManager.getString(resultSet,37));
            nyxpolicylistDto.setRemark(dbManager.getString(resultSet,38));
            nyxpolicylistDto.setFpremium(dbManager.getDouble(resultSet,39));
            nyxpolicylistDto.setFidcard(dbManager.getString(resultSet,40));
            nyxpolicylistDto.setTeamname(dbManager.getString(resultSet,41));
            nyxpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,42));
            nyxpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,43));
            nyxpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,44));
            nyxpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,45));
            nyxpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,46));
            nyxpolicylistDto.setAreanumber(dbManager.getDouble(resultSet,47));
            nyxpolicylistDto.setFieldsource(dbManager.getString(resultSet,48));
            nyxpolicylistDto.setLitterarea(dbManager.getString(resultSet,49));
            nyxpolicylistDto.setAtarea(dbManager.getString(resultSet,50));
            nyxpolicylistDto.setMulchdate(dbManager.getString(resultSet,51));
            nyxpolicylistDto.setMulchtype(dbManager.getString(resultSet,52));
            nyxpolicylistDto.setWarrant(dbManager.getString(resultSet,53));
            nyxpolicylistDto.setTemp1(dbManager.getString(resultSet,54));
            nyxpolicylistDto.setTemp2(dbManager.getString(resultSet,55));
            nyxpolicylistDto.setTemp3(dbManager.getString(resultSet,56));
            nyxpolicylistDto.setTemp4(dbManager.getString(resultSet,57));
            nyxpolicylistDto.setTemp5(dbManager.getString(resultSet,58));
        }
        resultSet.close();
        return nyxpolicylistDto;
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxpolicylist WHERE ");
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
        NyxpolicylistDto nyxpolicylistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxpolicylistDto = new NyxpolicylistDto();
            nyxpolicylistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxpolicylistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxpolicylistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxpolicylistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxpolicylistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxpolicylistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxpolicylistDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxpolicylistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxpolicylistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxpolicylistDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxpolicylistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxpolicylistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxpolicylistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxpolicylistDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxpolicylistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxpolicylistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            nyxpolicylistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxpolicylistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            nyxpolicylistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxpolicylistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxpolicylistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxpolicylistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxpolicylistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxpolicylistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            nyxpolicylistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            nyxpolicylistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            nyxpolicylistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            nyxpolicylistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            nyxpolicylistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            nyxpolicylistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            nyxpolicylistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            nyxpolicylistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            nyxpolicylistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            nyxpolicylistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            nyxpolicylistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxpolicylistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxpolicylistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxpolicylistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxpolicylistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            nyxpolicylistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxpolicylistDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxpolicylistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            nyxpolicylistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            nyxpolicylistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            nyxpolicylistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            nyxpolicylistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            nyxpolicylistDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxpolicylistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxpolicylistDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxpolicylistDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxpolicylistDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxpolicylistDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxpolicylistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxpolicylistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxpolicylistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxpolicylistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxpolicylistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxpolicylistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxpolicylistDto);
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
        buffer.append("DELETE FROM Nyxpolicylist WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxpolicylist WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM NyxPolicyList WHERE ");
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
}
