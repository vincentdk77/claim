package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxcpendorchgdetailDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXCPENDORCHGDETAIL的数据访问对象基类<br>
 */
public class DBNyxcpendorchgdetailBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxcpendorchgdetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxcpendorchgdetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void insert(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxcpendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fidcard,");
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
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBankcard()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBreedingkind()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getBreedingnumber()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getSettlenumber()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getFareacode()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getTaxarea()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getAmount()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getRate()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getShortrateflag()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getShortrate()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getSumamount()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getSumpremium()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getStartdate()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getEnddate()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getStarttime()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getEndtime()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getCalculateflag()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getRemark()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getFpremium()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTeamname()).append("',");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getCentralpremium()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getProvincepremium()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getCitypremium()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getTownpremium()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getOtherpremium()).append(",");
            debugBuffer.append("").append(nyxcpendorchgdetailDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxcpendorchgdetailDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxcpendorchgdetailDto.getInusrelistcode());
        dbManager.setString(2,nyxcpendorchgdetailDto.getBusinessno());
        dbManager.setString(3,nyxcpendorchgdetailDto.getKindcode());
        dbManager.setString(4,nyxcpendorchgdetailDto.getItemcode());
        dbManager.setString(5,nyxcpendorchgdetailDto.getIndexcode());
        dbManager.setString(6,nyxcpendorchgdetailDto.getFcode());
        dbManager.setString(7,nyxcpendorchgdetailDto.getFidcard());
        dbManager.setString(8,nyxcpendorchgdetailDto.getFname());
        dbManager.setString(9,nyxcpendorchgdetailDto.getZhibuka());
        dbManager.setString(10,nyxcpendorchgdetailDto.getPhone());
        dbManager.setString(11,nyxcpendorchgdetailDto.getBank());
        dbManager.setString(12,nyxcpendorchgdetailDto.getBankcard());
        dbManager.setLong(13,nyxcpendorchgdetailDto.getInsurenumber());
        dbManager.setString(14,nyxcpendorchgdetailDto.getBreedingareacode());
        dbManager.setString(15,nyxcpendorchgdetailDto.getSpecies());
        dbManager.setString(16,nyxcpendorchgdetailDto.getBreedingkind());
        dbManager.setLong(17,nyxcpendorchgdetailDto.getBreedingnumber());
        dbManager.setString(18,nyxcpendorchgdetailDto.getBreedingareaname());
        dbManager.setLong(19,nyxcpendorchgdetailDto.getSettlenumber());
        dbManager.setString(20,nyxcpendorchgdetailDto.getClasscode());
        dbManager.setString(21,nyxcpendorchgdetailDto.getRiskcode());
        dbManager.setString(22,nyxcpendorchgdetailDto.getFareacode());
        dbManager.setDouble(23,nyxcpendorchgdetailDto.getTaxarea());
        dbManager.setDouble(24,nyxcpendorchgdetailDto.getInsurearea());
        dbManager.setDouble(25,nyxcpendorchgdetailDto.getAmount());
        dbManager.setDouble(26,nyxcpendorchgdetailDto.getRate());
        dbManager.setString(27,nyxcpendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(28,nyxcpendorchgdetailDto.getShortrate());
        dbManager.setDouble(29,nyxcpendorchgdetailDto.getSumamount());
        dbManager.setDouble(30,nyxcpendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(31,nyxcpendorchgdetailDto.getStartdate());
        dbManager.setDateTime(32,nyxcpendorchgdetailDto.getEnddate());
        dbManager.setString(33,nyxcpendorchgdetailDto.getStarttime());
        dbManager.setString(34,nyxcpendorchgdetailDto.getEndtime());
        dbManager.setString(35,nyxcpendorchgdetailDto.getCalculateflag());
        dbManager.setString(36,nyxcpendorchgdetailDto.getOpcode());
        dbManager.setDateTime(37,nyxcpendorchgdetailDto.getOptime());
        dbManager.setString(38,nyxcpendorchgdetailDto.getValidity());
        dbManager.setString(39,nyxcpendorchgdetailDto.getRemark());
        dbManager.setDouble(40,nyxcpendorchgdetailDto.getFpremium());
        dbManager.setString(41,nyxcpendorchgdetailDto.getTeamname());
        dbManager.setDouble(42,nyxcpendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(43,nyxcpendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(44,nyxcpendorchgdetailDto.getCitypremium());
        dbManager.setDouble(45,nyxcpendorchgdetailDto.getTownpremium());
        dbManager.setDouble(46,nyxcpendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(47,nyxcpendorchgdetailDto.getAreanumber());
        dbManager.setString(48,nyxcpendorchgdetailDto.getFieldsource());
        dbManager.setString(49,nyxcpendorchgdetailDto.getLitterarea());
        dbManager.setString(50,nyxcpendorchgdetailDto.getAtarea());
        dbManager.setString(51,nyxcpendorchgdetailDto.getMulchdate());
        dbManager.setString(52,nyxcpendorchgdetailDto.getMulchtype());
        dbManager.setString(53,nyxcpendorchgdetailDto.getWarrant());
        dbManager.setString(54,nyxcpendorchgdetailDto.getTemp1());
        dbManager.setString(55,nyxcpendorchgdetailDto.getTemp2());
        dbManager.setString(56,nyxcpendorchgdetailDto.getTemp3());
        dbManager.setString(57,nyxcpendorchgdetailDto.getTemp4());
        dbManager.setString(58,nyxcpendorchgdetailDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxcpendorchgdetail (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Indexcode,");
        buffer.append("Fcode,");
        buffer.append("Fidcard,");
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
            NyxcpendorchgdetailDto nyxcpendorchgdetailDto = (NyxcpendorchgdetailDto)i.next();
            dbManager.setString(1,nyxcpendorchgdetailDto.getInusrelistcode());
            dbManager.setString(2,nyxcpendorchgdetailDto.getBusinessno());
            dbManager.setString(3,nyxcpendorchgdetailDto.getKindcode());
            dbManager.setString(4,nyxcpendorchgdetailDto.getItemcode());
            dbManager.setString(5,nyxcpendorchgdetailDto.getIndexcode());
            dbManager.setString(6,nyxcpendorchgdetailDto.getFcode());
            dbManager.setString(7,nyxcpendorchgdetailDto.getFidcard());
            dbManager.setString(8,nyxcpendorchgdetailDto.getFname());
            dbManager.setString(9,nyxcpendorchgdetailDto.getZhibuka());
            dbManager.setString(10,nyxcpendorchgdetailDto.getPhone());
            dbManager.setString(11,nyxcpendorchgdetailDto.getBank());
            dbManager.setString(12,nyxcpendorchgdetailDto.getBankcard());
            dbManager.setLong(13,nyxcpendorchgdetailDto.getInsurenumber());
            dbManager.setString(14,nyxcpendorchgdetailDto.getBreedingareacode());
            dbManager.setString(15,nyxcpendorchgdetailDto.getSpecies());
            dbManager.setString(16,nyxcpendorchgdetailDto.getBreedingkind());
            dbManager.setLong(17,nyxcpendorchgdetailDto.getBreedingnumber());
            dbManager.setString(18,nyxcpendorchgdetailDto.getBreedingareaname());
            dbManager.setLong(19,nyxcpendorchgdetailDto.getSettlenumber());
            dbManager.setString(20,nyxcpendorchgdetailDto.getClasscode());
            dbManager.setString(21,nyxcpendorchgdetailDto.getRiskcode());
            dbManager.setString(22,nyxcpendorchgdetailDto.getFareacode());
            dbManager.setDouble(23,nyxcpendorchgdetailDto.getTaxarea());
            dbManager.setDouble(24,nyxcpendorchgdetailDto.getInsurearea());
            dbManager.setDouble(25,nyxcpendorchgdetailDto.getAmount());
            dbManager.setDouble(26,nyxcpendorchgdetailDto.getRate());
            dbManager.setString(27,nyxcpendorchgdetailDto.getShortrateflag());
            dbManager.setDouble(28,nyxcpendorchgdetailDto.getShortrate());
            dbManager.setDouble(29,nyxcpendorchgdetailDto.getSumamount());
            dbManager.setDouble(30,nyxcpendorchgdetailDto.getSumpremium());
            dbManager.setDateTime(31,nyxcpendorchgdetailDto.getStartdate());
            dbManager.setDateTime(32,nyxcpendorchgdetailDto.getEnddate());
            dbManager.setString(33,nyxcpendorchgdetailDto.getStarttime());
            dbManager.setString(34,nyxcpendorchgdetailDto.getEndtime());
            dbManager.setString(35,nyxcpendorchgdetailDto.getCalculateflag());
            dbManager.setString(36,nyxcpendorchgdetailDto.getOpcode());
            dbManager.setDateTime(37,nyxcpendorchgdetailDto.getOptime());
            dbManager.setString(38,nyxcpendorchgdetailDto.getValidity());
            dbManager.setString(39,nyxcpendorchgdetailDto.getRemark());
            dbManager.setDouble(40,nyxcpendorchgdetailDto.getFpremium());
            dbManager.setString(41,nyxcpendorchgdetailDto.getTeamname());
            dbManager.setDouble(42,nyxcpendorchgdetailDto.getCentralpremium());
            dbManager.setDouble(43,nyxcpendorchgdetailDto.getProvincepremium());
            dbManager.setDouble(44,nyxcpendorchgdetailDto.getCitypremium());
            dbManager.setDouble(45,nyxcpendorchgdetailDto.getTownpremium());
            dbManager.setDouble(46,nyxcpendorchgdetailDto.getOtherpremium());
            dbManager.setDouble(47,nyxcpendorchgdetailDto.getAreanumber());
            dbManager.setString(48,nyxcpendorchgdetailDto.getFieldsource());
            dbManager.setString(49,nyxcpendorchgdetailDto.getLitterarea());
            dbManager.setString(50,nyxcpendorchgdetailDto.getAtarea());
            dbManager.setString(51,nyxcpendorchgdetailDto.getMulchdate());
            dbManager.setString(52,nyxcpendorchgdetailDto.getMulchtype());
            dbManager.setString(53,nyxcpendorchgdetailDto.getWarrant());
            dbManager.setString(54,nyxcpendorchgdetailDto.getTemp1());
            dbManager.setString(55,nyxcpendorchgdetailDto.getTemp2());
            dbManager.setString(56,nyxcpendorchgdetailDto.getTemp3());
            dbManager.setString(57,nyxcpendorchgdetailDto.getTemp4());
            dbManager.setString(58,nyxcpendorchgdetailDto.getTemp5());
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
        buffer.append("DELETE FROM Nyxcpendorchgdetail ");
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
     * @param nyxcpendorchgdetailDto nyxcpendorchgdetailDto
     * @throws Exception
     */
    public void update(NyxcpendorchgdetailDto nyxcpendorchgdetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxcpendorchgdetail SET ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Fidcard = ?, ");
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
            debugBuffer.append("UPDATE Nyxcpendorchgdetail SET ");
            debugBuffer.append("Indexcode = '" + nyxcpendorchgdetailDto.getIndexcode() + "', ");
            debugBuffer.append("Fcode = '" + nyxcpendorchgdetailDto.getFcode() + "', ");
            debugBuffer.append("Fidcard = '" + nyxcpendorchgdetailDto.getFidcard() + "', ");
            debugBuffer.append("Fname = '" + nyxcpendorchgdetailDto.getFname() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxcpendorchgdetailDto.getZhibuka() + "', ");
            debugBuffer.append("Phone = '" + nyxcpendorchgdetailDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxcpendorchgdetailDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + nyxcpendorchgdetailDto.getBankcard() + "', ");
            debugBuffer.append("Insurenumber = " + nyxcpendorchgdetailDto.getInsurenumber() + ", ");
            debugBuffer.append("Breedingareacode = '" + nyxcpendorchgdetailDto.getBreedingareacode() + "', ");
            debugBuffer.append("Species = '" + nyxcpendorchgdetailDto.getSpecies() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxcpendorchgdetailDto.getBreedingkind() + "', ");
            debugBuffer.append("Breedingnumber = " + nyxcpendorchgdetailDto.getBreedingnumber() + ", ");
            debugBuffer.append("Breedingareaname = '" + nyxcpendorchgdetailDto.getBreedingareaname() + "', ");
            debugBuffer.append("Settlenumber = " + nyxcpendorchgdetailDto.getSettlenumber() + ", ");
            debugBuffer.append("Classcode = '" + nyxcpendorchgdetailDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxcpendorchgdetailDto.getRiskcode() + "', ");
            debugBuffer.append("Fareacode = '" + nyxcpendorchgdetailDto.getFareacode() + "', ");
            debugBuffer.append("Taxarea = " + nyxcpendorchgdetailDto.getTaxarea() + ", ");
            debugBuffer.append("Insurearea = " + nyxcpendorchgdetailDto.getInsurearea() + ", ");
            debugBuffer.append("Amount = " + nyxcpendorchgdetailDto.getAmount() + ", ");
            debugBuffer.append("Rate = " + nyxcpendorchgdetailDto.getRate() + ", ");
            debugBuffer.append("Shortrateflag = '" + nyxcpendorchgdetailDto.getShortrateflag() + "', ");
            debugBuffer.append("Shortrate = " + nyxcpendorchgdetailDto.getShortrate() + ", ");
            debugBuffer.append("Sumamount = " + nyxcpendorchgdetailDto.getSumamount() + ", ");
            debugBuffer.append("Sumpremium = " + nyxcpendorchgdetailDto.getSumpremium() + ", ");
            debugBuffer.append("Startdate = '" + nyxcpendorchgdetailDto.getStartdate() + "', ");
            debugBuffer.append("Enddate = '" + nyxcpendorchgdetailDto.getEnddate() + "', ");
            debugBuffer.append("Starttime = '" + nyxcpendorchgdetailDto.getStarttime() + "', ");
            debugBuffer.append("Endtime = '" + nyxcpendorchgdetailDto.getEndtime() + "', ");
            debugBuffer.append("Calculateflag = '" + nyxcpendorchgdetailDto.getCalculateflag() + "', ");
            debugBuffer.append("Opcode = '" + nyxcpendorchgdetailDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxcpendorchgdetailDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + nyxcpendorchgdetailDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + nyxcpendorchgdetailDto.getRemark() + "', ");
            debugBuffer.append("Fpremium = " + nyxcpendorchgdetailDto.getFpremium() + ", ");
            debugBuffer.append("Teamname = '" + nyxcpendorchgdetailDto.getTeamname() + "', ");
            debugBuffer.append("Centralpremium = " + nyxcpendorchgdetailDto.getCentralpremium() + ", ");
            debugBuffer.append("Provincepremium = " + nyxcpendorchgdetailDto.getProvincepremium() + ", ");
            debugBuffer.append("Citypremium = " + nyxcpendorchgdetailDto.getCitypremium() + ", ");
            debugBuffer.append("Townpremium = " + nyxcpendorchgdetailDto.getTownpremium() + ", ");
            debugBuffer.append("Otherpremium = " + nyxcpendorchgdetailDto.getOtherpremium() + ", ");
            debugBuffer.append("Areanumber = " + nyxcpendorchgdetailDto.getAreanumber() + ", ");
            debugBuffer.append("Fieldsource = '" + nyxcpendorchgdetailDto.getFieldsource() + "', ");
            debugBuffer.append("Litterarea = '" + nyxcpendorchgdetailDto.getLitterarea() + "', ");
            debugBuffer.append("Atarea = '" + nyxcpendorchgdetailDto.getAtarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxcpendorchgdetailDto.getMulchdate() + "', ");
            debugBuffer.append("Mulchtype = '" + nyxcpendorchgdetailDto.getMulchtype() + "', ");
            debugBuffer.append("Warrant = '" + nyxcpendorchgdetailDto.getWarrant() + "', ");
            debugBuffer.append("Temp1 = '" + nyxcpendorchgdetailDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxcpendorchgdetailDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxcpendorchgdetailDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxcpendorchgdetailDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxcpendorchgdetailDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxcpendorchgdetailDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxcpendorchgdetailDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxcpendorchgdetailDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxcpendorchgdetailDto.getItemcode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxcpendorchgdetailDto.getIndexcode());
        dbManager.setString(2,nyxcpendorchgdetailDto.getFcode());
        dbManager.setString(3,nyxcpendorchgdetailDto.getFidcard());
        dbManager.setString(4,nyxcpendorchgdetailDto.getFname());
        dbManager.setString(5,nyxcpendorchgdetailDto.getZhibuka());
        dbManager.setString(6,nyxcpendorchgdetailDto.getPhone());
        dbManager.setString(7,nyxcpendorchgdetailDto.getBank());
        dbManager.setString(8,nyxcpendorchgdetailDto.getBankcard());
        dbManager.setLong(9,nyxcpendorchgdetailDto.getInsurenumber());
        dbManager.setString(10,nyxcpendorchgdetailDto.getBreedingareacode());
        dbManager.setString(11,nyxcpendorchgdetailDto.getSpecies());
        dbManager.setString(12,nyxcpendorchgdetailDto.getBreedingkind());
        dbManager.setLong(13,nyxcpendorchgdetailDto.getBreedingnumber());
        dbManager.setString(14,nyxcpendorchgdetailDto.getBreedingareaname());
        dbManager.setLong(15,nyxcpendorchgdetailDto.getSettlenumber());
        dbManager.setString(16,nyxcpendorchgdetailDto.getClasscode());
        dbManager.setString(17,nyxcpendorchgdetailDto.getRiskcode());
        dbManager.setString(18,nyxcpendorchgdetailDto.getFareacode());
        dbManager.setDouble(19,nyxcpendorchgdetailDto.getTaxarea());
        dbManager.setDouble(20,nyxcpendorchgdetailDto.getInsurearea());
        dbManager.setDouble(21,nyxcpendorchgdetailDto.getAmount());
        dbManager.setDouble(22,nyxcpendorchgdetailDto.getRate());
        dbManager.setString(23,nyxcpendorchgdetailDto.getShortrateflag());
        dbManager.setDouble(24,nyxcpendorchgdetailDto.getShortrate());
        dbManager.setDouble(25,nyxcpendorchgdetailDto.getSumamount());
        dbManager.setDouble(26,nyxcpendorchgdetailDto.getSumpremium());
        dbManager.setDateTime(27,nyxcpendorchgdetailDto.getStartdate());
        dbManager.setDateTime(28,nyxcpendorchgdetailDto.getEnddate());
        dbManager.setString(29,nyxcpendorchgdetailDto.getStarttime());
        dbManager.setString(30,nyxcpendorchgdetailDto.getEndtime());
        dbManager.setString(31,nyxcpendorchgdetailDto.getCalculateflag());
        dbManager.setString(32,nyxcpendorchgdetailDto.getOpcode());
        dbManager.setDateTime(33,nyxcpendorchgdetailDto.getOptime());
        dbManager.setString(34,nyxcpendorchgdetailDto.getValidity());
        dbManager.setString(35,nyxcpendorchgdetailDto.getRemark());
        dbManager.setDouble(36,nyxcpendorchgdetailDto.getFpremium());
        dbManager.setString(37,nyxcpendorchgdetailDto.getTeamname());
        dbManager.setDouble(38,nyxcpendorchgdetailDto.getCentralpremium());
        dbManager.setDouble(39,nyxcpendorchgdetailDto.getProvincepremium());
        dbManager.setDouble(40,nyxcpendorchgdetailDto.getCitypremium());
        dbManager.setDouble(41,nyxcpendorchgdetailDto.getTownpremium());
        dbManager.setDouble(42,nyxcpendorchgdetailDto.getOtherpremium());
        dbManager.setDouble(43,nyxcpendorchgdetailDto.getAreanumber());
        dbManager.setString(44,nyxcpendorchgdetailDto.getFieldsource());
        dbManager.setString(45,nyxcpendorchgdetailDto.getLitterarea());
        dbManager.setString(46,nyxcpendorchgdetailDto.getAtarea());
        dbManager.setString(47,nyxcpendorchgdetailDto.getMulchdate());
        dbManager.setString(48,nyxcpendorchgdetailDto.getMulchtype());
        dbManager.setString(49,nyxcpendorchgdetailDto.getWarrant());
        dbManager.setString(50,nyxcpendorchgdetailDto.getTemp1());
        dbManager.setString(51,nyxcpendorchgdetailDto.getTemp2());
        dbManager.setString(52,nyxcpendorchgdetailDto.getTemp3());
        dbManager.setString(53,nyxcpendorchgdetailDto.getTemp4());
        dbManager.setString(54,nyxcpendorchgdetailDto.getTemp5());
        //设置条件字段;
        dbManager.setString(55,nyxcpendorchgdetailDto.getInusrelistcode());
        dbManager.setString(56,nyxcpendorchgdetailDto.getBusinessno());
        dbManager.setString(57,nyxcpendorchgdetailDto.getKindcode());
        dbManager.setString(58,nyxcpendorchgdetailDto.getItemcode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return NyxcpendorchgdetailDto
     * @throws Exception
     */
    public NyxcpendorchgdetailDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxcpendorchgdetail ");
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
        NyxcpendorchgdetailDto nyxcpendorchgdetailDto = null;
        if(resultSet.next()){
            nyxcpendorchgdetailDto = new NyxcpendorchgdetailDto();
            nyxcpendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxcpendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxcpendorchgdetailDto.setKindcode(dbManager.getString(resultSet,3));
            nyxcpendorchgdetailDto.setItemcode(dbManager.getString(resultSet,4));
            nyxcpendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,5));
            nyxcpendorchgdetailDto.setFcode(dbManager.getString(resultSet,6));
            nyxcpendorchgdetailDto.setFidcard(dbManager.getString(resultSet,7));
            nyxcpendorchgdetailDto.setFname(dbManager.getString(resultSet,8));
            nyxcpendorchgdetailDto.setZhibuka(dbManager.getString(resultSet,9));
            nyxcpendorchgdetailDto.setPhone(dbManager.getString(resultSet,10));
            nyxcpendorchgdetailDto.setBank(dbManager.getString(resultSet,11));
            nyxcpendorchgdetailDto.setBankcard(dbManager.getString(resultSet,12));
            nyxcpendorchgdetailDto.setInsurenumber(dbManager.getLong(resultSet,13));
            nyxcpendorchgdetailDto.setBreedingareacode(dbManager.getString(resultSet,14));
            nyxcpendorchgdetailDto.setSpecies(dbManager.getString(resultSet,15));
            nyxcpendorchgdetailDto.setBreedingkind(dbManager.getString(resultSet,16));
            nyxcpendorchgdetailDto.setBreedingnumber(dbManager.getLong(resultSet,17));
            nyxcpendorchgdetailDto.setBreedingareaname(dbManager.getString(resultSet,18));
            nyxcpendorchgdetailDto.setSettlenumber(dbManager.getLong(resultSet,19));
            nyxcpendorchgdetailDto.setClasscode(dbManager.getString(resultSet,20));
            nyxcpendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,21));
            nyxcpendorchgdetailDto.setFareacode(dbManager.getString(resultSet,22));
            nyxcpendorchgdetailDto.setTaxarea(dbManager.getDouble(resultSet,23));
            nyxcpendorchgdetailDto.setInsurearea(dbManager.getDouble(resultSet,24));
            nyxcpendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,25));
            nyxcpendorchgdetailDto.setRate(dbManager.getDouble(resultSet,26));
            nyxcpendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,27));
            nyxcpendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,28));
            nyxcpendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,29));
            nyxcpendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,30));
            nyxcpendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,31));
            nyxcpendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            nyxcpendorchgdetailDto.setStarttime(dbManager.getString(resultSet,33));
            nyxcpendorchgdetailDto.setEndtime(dbManager.getString(resultSet,34));
            nyxcpendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,35));
            nyxcpendorchgdetailDto.setOpcode(dbManager.getString(resultSet,36));
            nyxcpendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,37));
            nyxcpendorchgdetailDto.setValidity(dbManager.getString(resultSet,38));
            nyxcpendorchgdetailDto.setRemark(dbManager.getString(resultSet,39));
            nyxcpendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,40));
            nyxcpendorchgdetailDto.setTeamname(dbManager.getString(resultSet,41));
            nyxcpendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,42));
            nyxcpendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,43));
            nyxcpendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,44));
            nyxcpendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,45));
            nyxcpendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,46));
            nyxcpendorchgdetailDto.setAreanumber(dbManager.getDouble(resultSet,47));
            nyxcpendorchgdetailDto.setFieldsource(dbManager.getString(resultSet,48));
            nyxcpendorchgdetailDto.setLitterarea(dbManager.getString(resultSet,49));
            nyxcpendorchgdetailDto.setAtarea(dbManager.getString(resultSet,50));
            nyxcpendorchgdetailDto.setMulchdate(dbManager.getString(resultSet,51));
            nyxcpendorchgdetailDto.setMulchtype(dbManager.getString(resultSet,52));
            nyxcpendorchgdetailDto.setWarrant(dbManager.getString(resultSet,53));
            nyxcpendorchgdetailDto.setTemp1(dbManager.getString(resultSet,54));
            nyxcpendorchgdetailDto.setTemp2(dbManager.getString(resultSet,55));
            nyxcpendorchgdetailDto.setTemp3(dbManager.getString(resultSet,56));
            nyxcpendorchgdetailDto.setTemp4(dbManager.getString(resultSet,57));
            nyxcpendorchgdetailDto.setTemp5(dbManager.getString(resultSet,58));
        }
        resultSet.close();
        return nyxcpendorchgdetailDto;
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
        buffer.append("Fidcard,");
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
        buffer.append("FROM Nyxcpendorchgdetail WHERE ");
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
        NyxcpendorchgdetailDto nyxcpendorchgdetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxcpendorchgdetailDto = new NyxcpendorchgdetailDto();
            nyxcpendorchgdetailDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxcpendorchgdetailDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxcpendorchgdetailDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxcpendorchgdetailDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxcpendorchgdetailDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxcpendorchgdetailDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxcpendorchgdetailDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxcpendorchgdetailDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxcpendorchgdetailDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxcpendorchgdetailDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxcpendorchgdetailDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxcpendorchgdetailDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxcpendorchgdetailDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxcpendorchgdetailDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxcpendorchgdetailDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxcpendorchgdetailDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxcpendorchgdetailDto.setBreedingnumber(dbManager.getLong(resultSet,"Breedingnumber"));
            nyxcpendorchgdetailDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxcpendorchgdetailDto.setSettlenumber(dbManager.getLong(resultSet,"Settlenumber"));
            nyxcpendorchgdetailDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxcpendorchgdetailDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxcpendorchgdetailDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxcpendorchgdetailDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxcpendorchgdetailDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxcpendorchgdetailDto.setAmount(dbManager.getDouble(resultSet,"Amount"));
            nyxcpendorchgdetailDto.setRate(dbManager.getDouble(resultSet,"Rate"));
            nyxcpendorchgdetailDto.setShortrateflag(dbManager.getString(resultSet,"Shortrateflag"));
            nyxcpendorchgdetailDto.setShortrate(dbManager.getDouble(resultSet,"Shortrate"));
            nyxcpendorchgdetailDto.setSumamount(dbManager.getDouble(resultSet,"Sumamount"));
            nyxcpendorchgdetailDto.setSumpremium(dbManager.getDouble(resultSet,"Sumpremium"));
            nyxcpendorchgdetailDto.setStartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Startdate"));
            nyxcpendorchgdetailDto.setEnddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Enddate"));
            nyxcpendorchgdetailDto.setStarttime(dbManager.getString(resultSet,"Starttime"));
            nyxcpendorchgdetailDto.setEndtime(dbManager.getString(resultSet,"Endtime"));
            nyxcpendorchgdetailDto.setCalculateflag(dbManager.getString(resultSet,"Calculateflag"));
            nyxcpendorchgdetailDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxcpendorchgdetailDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxcpendorchgdetailDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxcpendorchgdetailDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxcpendorchgdetailDto.setFpremium(dbManager.getDouble(resultSet,"Fpremium"));
            nyxcpendorchgdetailDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxcpendorchgdetailDto.setCentralpremium(dbManager.getDouble(resultSet,"Centralpremium"));
            nyxcpendorchgdetailDto.setProvincepremium(dbManager.getDouble(resultSet,"Provincepremium"));
            nyxcpendorchgdetailDto.setCitypremium(dbManager.getDouble(resultSet,"Citypremium"));
            nyxcpendorchgdetailDto.setTownpremium(dbManager.getDouble(resultSet,"Townpremium"));
            nyxcpendorchgdetailDto.setOtherpremium(dbManager.getDouble(resultSet,"Otherpremium"));
            nyxcpendorchgdetailDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxcpendorchgdetailDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxcpendorchgdetailDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxcpendorchgdetailDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxcpendorchgdetailDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxcpendorchgdetailDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxcpendorchgdetailDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxcpendorchgdetailDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxcpendorchgdetailDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxcpendorchgdetailDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxcpendorchgdetailDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxcpendorchgdetailDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxcpendorchgdetailDto);
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
        buffer.append("DELETE FROM Nyxcpendorchgdetail WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxcpendorchgdetail WHERE ");
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
