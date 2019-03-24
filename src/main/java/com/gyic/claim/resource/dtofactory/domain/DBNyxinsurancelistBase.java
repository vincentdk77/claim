package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxinsurancelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXINSURANCELIST的数据访问对象基类<br>
 */
public class DBNyxinsurancelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxinsurancelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxinsurancelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void insert(NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
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
            debugBuffer.append("'").append(nyxinsurancelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBankcard()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBreedingkind()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getSettlenumber()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getFareacode()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getTaxarea()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getAmount()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getRate()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getShortrate()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getSumamount()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getStartdate()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getEnddate()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getStarttime()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getEndtime()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getRemark()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getFpremium()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTeamname()).append("',");
            debugBuffer.append("").append(nyxinsurancelistDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getCitypremium()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getTownpremium()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(nyxinsurancelistDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxinsurancelistDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxinsurancelistDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxinsurancelistDto.getInusrelistcode());
        dbManager.setString(2,nyxinsurancelistDto.getBusinessno());
        dbManager.setString(3,nyxinsurancelistDto.getKindcode());
        dbManager.setString(4,nyxinsurancelistDto.getItemcode());
        dbManager.setString(5,nyxinsurancelistDto.getIndexcode());
        dbManager.setString(6,nyxinsurancelistDto.getFcode());
        dbManager.setString(7,nyxinsurancelistDto.getFname());
        dbManager.setString(8,nyxinsurancelistDto.getFidcard());
        dbManager.setString(9,nyxinsurancelistDto.getZhibuka());
        dbManager.setString(10,nyxinsurancelistDto.getPhone());
        dbManager.setString(11,nyxinsurancelistDto.getBank());
        dbManager.setString(12,nyxinsurancelistDto.getBankcard());
        dbManager.setLong(13,nyxinsurancelistDto.getInsurenumber());
        dbManager.setString(14,nyxinsurancelistDto.getBreedingareacode());
        dbManager.setString(15,nyxinsurancelistDto.getSpecies());
        dbManager.setString(16,nyxinsurancelistDto.getBreedingkind());
        dbManager.setLong(17,nyxinsurancelistDto.getBreedingnumber());
        dbManager.setString(18,nyxinsurancelistDto.getBreedingareaname());
        dbManager.setLong(19,nyxinsurancelistDto.getSettlenumber());
        dbManager.setString(20,nyxinsurancelistDto.getClasscode());
        dbManager.setString(21,nyxinsurancelistDto.getRiskcode());
        dbManager.setString(22,nyxinsurancelistDto.getFareacode());
        dbManager.setDouble(23,nyxinsurancelistDto.getTaxarea());
        dbManager.setDouble(24,nyxinsurancelistDto.getInsurearea());
        dbManager.setDouble(25,nyxinsurancelistDto.getAmount());
        dbManager.setDouble(26,nyxinsurancelistDto.getRate());
        dbManager.setString(27,nyxinsurancelistDto.getShortrateflag());
        dbManager.setDouble(28,nyxinsurancelistDto.getShortrate());
        dbManager.setDouble(29,nyxinsurancelistDto.getSumamount());
        dbManager.setDouble(30,nyxinsurancelistDto.getSumpremium());
        dbManager.setDateTime(31,nyxinsurancelistDto.getStartdate());
        dbManager.setDateTime(32,nyxinsurancelistDto.getEnddate());
        dbManager.setString(33,nyxinsurancelistDto.getStarttime());
        dbManager.setString(34,nyxinsurancelistDto.getEndtime());
        dbManager.setString(35,nyxinsurancelistDto.getCalculateflag());
        dbManager.setString(36,nyxinsurancelistDto.getOpcode());
        dbManager.setDateTime(37,nyxinsurancelistDto.getOptime());
        dbManager.setString(38,nyxinsurancelistDto.getValidity());
        dbManager.setString(39,nyxinsurancelistDto.getRemark());
        dbManager.setDouble(40,nyxinsurancelistDto.getFpremium());
        dbManager.setString(41,nyxinsurancelistDto.getTeamname());
        dbManager.setDouble(42,nyxinsurancelistDto.getCentralpremium());
        dbManager.setDouble(43,nyxinsurancelistDto.getProvincepremium());
        dbManager.setDouble(44,nyxinsurancelistDto.getCitypremium());
        dbManager.setDouble(45,nyxinsurancelistDto.getTownpremium());
        dbManager.setDouble(46,nyxinsurancelistDto.getOtherpremium());
        dbManager.setDouble(47,nyxinsurancelistDto.getAreanumber());
        dbManager.setString(48,nyxinsurancelistDto.getFieldsource());
        dbManager.setString(49,nyxinsurancelistDto.getLitterarea());
        dbManager.setString(50,nyxinsurancelistDto.getAtarea());
        dbManager.setString(51,nyxinsurancelistDto.getMulchdate());
        dbManager.setString(52,nyxinsurancelistDto.getMulchtype());
        dbManager.setString(53,nyxinsurancelistDto.getWarrant());
        dbManager.setString(54,nyxinsurancelistDto.getTemp1());
        dbManager.setString(55,nyxinsurancelistDto.getTemp2());
        dbManager.setString(56,nyxinsurancelistDto.getTemp3());
        dbManager.setString(57,nyxinsurancelistDto.getTemp4());
        dbManager.setString(58,nyxinsurancelistDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
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
            NyxinsurancelistDto nyxinsurancelistDto = (NyxinsurancelistDto)i.next();
            dbManager.setString(1,nyxinsurancelistDto.getInusrelistcode());
            dbManager.setString(2,nyxinsurancelistDto.getBusinessno());
            dbManager.setString(3,nyxinsurancelistDto.getKindcode());
            dbManager.setString(4,nyxinsurancelistDto.getItemcode());
            dbManager.setString(5,nyxinsurancelistDto.getIndexcode());
            dbManager.setString(6,nyxinsurancelistDto.getFcode());
            dbManager.setString(7,nyxinsurancelistDto.getFname());
            dbManager.setString(8,nyxinsurancelistDto.getFidcard());
            dbManager.setString(9,nyxinsurancelistDto.getZhibuka());
            dbManager.setString(10,nyxinsurancelistDto.getPhone());
            dbManager.setString(11,nyxinsurancelistDto.getBank());
            dbManager.setString(12,nyxinsurancelistDto.getBankcard());
            dbManager.setLong(13,nyxinsurancelistDto.getInsurenumber());
            dbManager.setString(14,nyxinsurancelistDto.getBreedingareacode());
            dbManager.setString(15,nyxinsurancelistDto.getSpecies());
            dbManager.setString(16,nyxinsurancelistDto.getBreedingkind());
            dbManager.setLong(17,nyxinsurancelistDto.getBreedingnumber());
            dbManager.setString(18,nyxinsurancelistDto.getBreedingareaname());
            dbManager.setLong(19,nyxinsurancelistDto.getSettlenumber());
            dbManager.setString(20,nyxinsurancelistDto.getClasscode());
            dbManager.setString(21,nyxinsurancelistDto.getRiskcode());
            dbManager.setString(22,nyxinsurancelistDto.getFareacode());
            dbManager.setDouble(23,nyxinsurancelistDto.getTaxarea());
            dbManager.setDouble(24,nyxinsurancelistDto.getInsurearea());
            dbManager.setDouble(25,nyxinsurancelistDto.getAmount());
            dbManager.setDouble(26,nyxinsurancelistDto.getRate());
            dbManager.setString(27,nyxinsurancelistDto.getShortrateflag());
            dbManager.setDouble(28,nyxinsurancelistDto.getShortrate());
            dbManager.setDouble(29,nyxinsurancelistDto.getSumamount());
            dbManager.setDouble(30,nyxinsurancelistDto.getSumpremium());
            dbManager.setDateTime(31,nyxinsurancelistDto.getStartdate());
            dbManager.setDateTime(32,nyxinsurancelistDto.getEnddate());
            dbManager.setString(33,nyxinsurancelistDto.getStarttime());
            dbManager.setString(34,nyxinsurancelistDto.getEndtime());
            dbManager.setString(35,nyxinsurancelistDto.getCalculateflag());
            dbManager.setString(36,nyxinsurancelistDto.getOpcode());
            dbManager.setDateTime(37,nyxinsurancelistDto.getOptime());
            dbManager.setString(38,nyxinsurancelistDto.getValidity());
            dbManager.setString(39,nyxinsurancelistDto.getRemark());
            dbManager.setDouble(40,nyxinsurancelistDto.getFpremium());
            dbManager.setString(41,nyxinsurancelistDto.getTeamname());
            dbManager.setDouble(42,nyxinsurancelistDto.getCentralpremium());
            dbManager.setDouble(43,nyxinsurancelistDto.getProvincepremium());
            dbManager.setDouble(44,nyxinsurancelistDto.getCitypremium());
            dbManager.setDouble(45,nyxinsurancelistDto.getTownpremium());
            dbManager.setDouble(46,nyxinsurancelistDto.getOtherpremium());
            dbManager.setDouble(47,nyxinsurancelistDto.getAreanumber());
            dbManager.setString(48,nyxinsurancelistDto.getFieldsource());
            dbManager.setString(49,nyxinsurancelistDto.getLitterarea());
            dbManager.setString(50,nyxinsurancelistDto.getAtarea());
            dbManager.setString(51,nyxinsurancelistDto.getMulchdate());
            dbManager.setString(52,nyxinsurancelistDto.getMulchtype());
            dbManager.setString(53,nyxinsurancelistDto.getWarrant());
            dbManager.setString(54,nyxinsurancelistDto.getTemp1());
            dbManager.setString(55,nyxinsurancelistDto.getTemp2());
            dbManager.setString(56,nyxinsurancelistDto.getTemp3());
            dbManager.setString(57,nyxinsurancelistDto.getTemp4());
            dbManager.setString(58,nyxinsurancelistDto.getTemp5());
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
        buffer.append("DELETE FROM Nyxinsurancelist ");
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
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void update(NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxinsurancelist SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
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
            debugBuffer.append("UPDATE Nyxinsurancelist SET ");
            debugBuffer.append("Indexcode = '" + nyxinsurancelistDto.getIndexcode() + "', ");
            debugBuffer.append("Fcode = '" + nyxinsurancelistDto.getFcode() + "', ");
            debugBuffer.append("Fname = '" + nyxinsurancelistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + nyxinsurancelistDto.getFidcard() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxinsurancelistDto.getZhibuka() + "', ");
            debugBuffer.append("Phone = '" + nyxinsurancelistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxinsurancelistDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + nyxinsurancelistDto.getBankcard() + "', ");
            debugBuffer.append("Insurenumber = " + nyxinsurancelistDto.getInsurenumber() + ", ");
            debugBuffer.append("Breedingareacode = '" + nyxinsurancelistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + nyxinsurancelistDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxinsurancelistDto.getBreedingkind() + "', ");
            debugBuffer.append("Breedingnumber = " + nyxinsurancelistDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + nyxinsurancelistDto.getBreedingareaname() + "', ");
            debugBuffer.append("Settlenumber = " + nyxinsurancelistDto.getSettlenumber() + ", ");
            debugBuffer.append("Classcode = '" + nyxinsurancelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxinsurancelistDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + nyxinsurancelistDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + nyxinsurancelistDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + nyxinsurancelistDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + nyxinsurancelistDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + nyxinsurancelistDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + nyxinsurancelistDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + nyxinsurancelistDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + nyxinsurancelistDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + nyxinsurancelistDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + nyxinsurancelistDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + nyxinsurancelistDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + nyxinsurancelistDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + nyxinsurancelistDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + nyxinsurancelistDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + nyxinsurancelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxinsurancelistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + nyxinsurancelistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + nyxinsurancelistDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + nyxinsurancelistDto.getFpremium() + ", ");
            debugBuffer.append("Teamname = '" + nyxinsurancelistDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + nyxinsurancelistDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + nyxinsurancelistDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + nyxinsurancelistDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + nyxinsurancelistDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + nyxinsurancelistDto.getOtherpremium() + ", ");
            debugBuffer.append("Areanumber = " + nyxinsurancelistDto.getAreanumber() + ", ");
            debugBuffer.append("Fieldsource = '" + nyxinsurancelistDto.getFieldsource() + "', ");
            debugBuffer.append("Litterarea = '" + nyxinsurancelistDto.getLitterarea() + "', ");
            debugBuffer.append("Atarea = '" + nyxinsurancelistDto.getAtarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxinsurancelistDto.getMulchdate() + "', ");
            debugBuffer.append("Mulchtype = '" + nyxinsurancelistDto.getMulchtype() + "', ");
            debugBuffer.append("Warrant = '" + nyxinsurancelistDto.getWarrant() + "', ");
            debugBuffer.append("Temp1 = '" + nyxinsurancelistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxinsurancelistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxinsurancelistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxinsurancelistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxinsurancelistDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxinsurancelistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxinsurancelistDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxinsurancelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxinsurancelistDto.getItemcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxinsurancelistDto.getIndexcode());
        dbManager.setString(2,nyxinsurancelistDto.getFcode());
        dbManager.setString(3,nyxinsurancelistDto.getFname());
        dbManager.setString(4,nyxinsurancelistDto.getFidcard());
        dbManager.setString(5,nyxinsurancelistDto.getZhibuka());
        dbManager.setString(6,nyxinsurancelistDto.getPhone());
        dbManager.setString(7,nyxinsurancelistDto.getBank());
        dbManager.setString(8,nyxinsurancelistDto.getBankcard());
        dbManager.setLong(9,nyxinsurancelistDto.getInsurenumber());
        dbManager.setString(10,nyxinsurancelistDto.getBreedingareacode());
        dbManager.setString(11,nyxinsurancelistDto.getSpecies());
        dbManager.setString(12,nyxinsurancelistDto.getBreedingkind());
        dbManager.setLong(13,nyxinsurancelistDto.getBreedingnumber());
        dbManager.setString(14,nyxinsurancelistDto.getBreedingareaname());
        dbManager.setLong(15,nyxinsurancelistDto.getSettlenumber());
        dbManager.setString(16,nyxinsurancelistDto.getClasscode());
        dbManager.setString(17,nyxinsurancelistDto.getRiskcode());
        dbManager.setString(18,nyxinsurancelistDto.getFareacode());
        dbManager.setDouble(19,nyxinsurancelistDto.getTaxarea());
        dbManager.setDouble(20,nyxinsurancelistDto.getInsurearea());
        dbManager.setDouble(21,nyxinsurancelistDto.getAmount());
        dbManager.setDouble(22,nyxinsurancelistDto.getRate());
        dbManager.setString(23,nyxinsurancelistDto.getShortrateflag());
        dbManager.setDouble(24,nyxinsurancelistDto.getShortrate());
        dbManager.setDouble(25,nyxinsurancelistDto.getSumamount());
        dbManager.setDouble(26,nyxinsurancelistDto.getSumpremium());
        dbManager.setDateTime(27,nyxinsurancelistDto.getStartdate());
        dbManager.setDateTime(28,nyxinsurancelistDto.getEnddate());
        dbManager.setString(29,nyxinsurancelistDto.getStarttime());
        dbManager.setString(30,nyxinsurancelistDto.getEndtime());
        dbManager.setString(31,nyxinsurancelistDto.getCalculateflag());
        dbManager.setString(32,nyxinsurancelistDto.getOpcode());
        dbManager.setDateTime(33,nyxinsurancelistDto.getOptime());
        dbManager.setString(34,nyxinsurancelistDto.getValidity());
        dbManager.setString(35,nyxinsurancelistDto.getRemark());
        dbManager.setDouble(36,nyxinsurancelistDto.getFpremium());
        dbManager.setString(37,nyxinsurancelistDto.getTeamname());
        dbManager.setDouble(38,nyxinsurancelistDto.getCentralpremium());
        dbManager.setDouble(39,nyxinsurancelistDto.getProvincepremium());
        dbManager.setDouble(40,nyxinsurancelistDto.getCitypremium());
        dbManager.setDouble(41,nyxinsurancelistDto.getTownpremium());
        dbManager.setDouble(42,nyxinsurancelistDto.getOtherpremium());
        dbManager.setDouble(43,nyxinsurancelistDto.getAreanumber());
        dbManager.setString(44,nyxinsurancelistDto.getFieldsource());
        dbManager.setString(45,nyxinsurancelistDto.getLitterarea());
        dbManager.setString(46,nyxinsurancelistDto.getAtarea());
        dbManager.setString(47,nyxinsurancelistDto.getMulchdate());
        dbManager.setString(48,nyxinsurancelistDto.getMulchtype());
        dbManager.setString(49,nyxinsurancelistDto.getWarrant());
        dbManager.setString(50,nyxinsurancelistDto.getTemp1());
        dbManager.setString(51,nyxinsurancelistDto.getTemp2());
        dbManager.setString(52,nyxinsurancelistDto.getTemp3());
        dbManager.setString(53,nyxinsurancelistDto.getTemp4());
        dbManager.setString(54,nyxinsurancelistDto.getTemp5());
        //设置条件字段;
        dbManager.setString(55,nyxinsurancelistDto.getInusrelistcode());
        dbManager.setString(56,nyxinsurancelistDto.getBusinessno());
        dbManager.setString(57,nyxinsurancelistDto.getKindcode());
        dbManager.setString(58,nyxinsurancelistDto.getItemcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return NyxinsurancelistDto
     * @throws Exception
     */
    public NyxinsurancelistDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxinsurancelist ");
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
        NyxinsurancelistDto nyxinsurancelistDto = null;
        if(resultSet.next()){
            nyxinsurancelistDto = new NyxinsurancelistDto();
            nyxinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxinsurancelistDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxinsurancelistDto.setKindcode(dbManager.getString(resultSet,3));
            nyxinsurancelistDto.setItemcode(dbManager.getString(resultSet,4));
            nyxinsurancelistDto.setIndexcode(dbManager.getString(resultSet,5));
            nyxinsurancelistDto.setFcode(dbManager.getString(resultSet,6));
            nyxinsurancelistDto.setFname(dbManager.getString(resultSet,7));
            nyxinsurancelistDto.setFidcard(dbManager.getString(resultSet,8));
            nyxinsurancelistDto.setZhibuka(dbManager.getString(resultSet,9));
            nyxinsurancelistDto.setPhone(dbManager.getString(resultSet,10));
            nyxinsurancelistDto.setBank(dbManager.getString(resultSet,11));
            nyxinsurancelistDto.setBankcard(dbManager.getString(resultSet,12));
            nyxinsurancelistDto.setInsurenumber(dbManager.getLong(resultSet,13));
            nyxinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,14));
            nyxinsurancelistDto.setSpecies(dbManager.getString(resultSet,15));
            nyxinsurancelistDto.setBreedingkind(dbManager.getString(resultSet,16));
            nyxinsurancelistDto.setBreedingnumber(dbManager.getLong(resultSet,17));
            nyxinsurancelistDto.setBreedingareaname(dbManager.getString(resultSet,18));
            nyxinsurancelistDto.setSettlenumber(dbManager.getLong(resultSet,19));
            nyxinsurancelistDto.setClasscode(dbManager.getString(resultSet,20));
            nyxinsurancelistDto.setRiskcode(dbManager.getString(resultSet,21));
            nyxinsurancelistDto.setFareacode(dbManager.getString(resultSet,22));
            nyxinsurancelistDto.setTaxarea(dbManager.getDouble(resultSet,23));
            nyxinsurancelistDto.setInsurearea(dbManager.getDouble(resultSet,24));
            nyxinsurancelistDto.setAmount(dbManager.getDouble(resultSet,25));
            nyxinsurancelistDto.setRate(dbManager.getDouble(resultSet,26));
            nyxinsurancelistDto.setShortrateflag(dbManager.getString(resultSet,27));
            nyxinsurancelistDto.setShortrate(dbManager.getDouble(resultSet,28));
            nyxinsurancelistDto.setSumamount(dbManager.getDouble(resultSet,29));
            nyxinsurancelistDto.setSumpremium(dbManager.getDouble(resultSet,30));
            nyxinsurancelistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            nyxinsurancelistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            nyxinsurancelistDto.setStarttime(dbManager.getString(resultSet,33));
            nyxinsurancelistDto.setEndtime(dbManager.getString(resultSet,34));
            nyxinsurancelistDto.setCalculateflag(dbManager.getString(resultSet,35));
            nyxinsurancelistDto.setOpcode(dbManager.getString(resultSet,36));
            nyxinsurancelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            nyxinsurancelistDto.setValidity(dbManager.getString(resultSet,38));
            nyxinsurancelistDto.setRemark(dbManager.getString(resultSet,39));
            nyxinsurancelistDto.setFpremium(dbManager.getDouble(resultSet,40));
            nyxinsurancelistDto.setTeamname(dbManager.getString(resultSet,41));
            nyxinsurancelistDto.setCentralpremium(dbManager.getDouble(resultSet,42));
            nyxinsurancelistDto.setProvincepremium(dbManager.getDouble(resultSet,43));
            nyxinsurancelistDto.setCitypremium(dbManager.getDouble(resultSet,44));
            nyxinsurancelistDto.setTownpremium(dbManager.getDouble(resultSet,45));
            nyxinsurancelistDto.setOtherpremium(dbManager.getDouble(resultSet,46));
            nyxinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,47));
            nyxinsurancelistDto.setFieldsource(dbManager.getString(resultSet,48));
            nyxinsurancelistDto.setLitterarea(dbManager.getString(resultSet,49));
            nyxinsurancelistDto.setAtarea(dbManager.getString(resultSet,50));
            nyxinsurancelistDto.setMulchdate(dbManager.getString(resultSet,51));
            nyxinsurancelistDto.setMulchtype(dbManager.getString(resultSet,52));
            nyxinsurancelistDto.setWarrant(dbManager.getString(resultSet,53));
            nyxinsurancelistDto.setTemp1(dbManager.getString(resultSet,54));
            nyxinsurancelistDto.setTemp2(dbManager.getString(resultSet,55));
            nyxinsurancelistDto.setTemp3(dbManager.getString(resultSet,56));
            nyxinsurancelistDto.setTemp4(dbManager.getString(resultSet,57));
            nyxinsurancelistDto.setTemp5(dbManager.getString(resultSet,58));
        }
        resultSet.close();
        return nyxinsurancelistDto;
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxinsurancelist WHERE ");
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
        NyxinsurancelistDto nyxinsurancelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxinsurancelistDto = new NyxinsurancelistDto();
            nyxinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxinsurancelistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxinsurancelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxinsurancelistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxinsurancelistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxinsurancelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxinsurancelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxinsurancelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxinsurancelistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxinsurancelistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxinsurancelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxinsurancelistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxinsurancelistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxinsurancelistDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxinsurancelistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxinsurancelistDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            nyxinsurancelistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxinsurancelistDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            nyxinsurancelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxinsurancelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxinsurancelistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxinsurancelistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxinsurancelistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxinsurancelistDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            nyxinsurancelistDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            nyxinsurancelistDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            nyxinsurancelistDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            nyxinsurancelistDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            nyxinsurancelistDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            nyxinsurancelistDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            nyxinsurancelistDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            nyxinsurancelistDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            nyxinsurancelistDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            nyxinsurancelistDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            nyxinsurancelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxinsurancelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxinsurancelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxinsurancelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxinsurancelistDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            nyxinsurancelistDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxinsurancelistDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            nyxinsurancelistDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            nyxinsurancelistDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            nyxinsurancelistDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            nyxinsurancelistDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            nyxinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxinsurancelistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxinsurancelistDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxinsurancelistDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxinsurancelistDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxinsurancelistDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxinsurancelistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxinsurancelistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxinsurancelistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxinsurancelistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxinsurancelistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxinsurancelistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxinsurancelistDto);
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
        buffer.append("DELETE FROM Nyxinsurancelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxinsurancelist WHERE ");
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
