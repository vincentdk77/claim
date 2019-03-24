package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXUPLOADINSURANCELIST的数据访问对象基类<br>
 */
public class DBNyxuploadinsurancelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxuploadinsurancelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxuploadinsurancelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void insert(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxuploadinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Fcode,");
        buffer.append("Phone,");
        buffer.append("Zhibuka,");
        buffer.append("Breedingareaname,");
        buffer.append("Insurenumber,");
        buffer.append("Species,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Breedingkind,");
        buffer.append("Fname,");
        buffer.append("Flag,");
        buffer.append("Taxarea,");
        buffer.append("Fidcard,");
        buffer.append("Insurearea,");
        buffer.append("Remark,");
        buffer.append("Teamname,");
        buffer.append("Fieldsource,");
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Warrant,");
        buffer.append("Litterarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
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
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBreedingareaname()).append("',");
            debugBuffer.append("").append(nyxuploadinsurancelistDto.getInsurenumber()).append(",");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getSpecies()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBankcard()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBreedingkind()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFlag()).append("',");
            debugBuffer.append("").append(nyxuploadinsurancelistDto.getTaxarea()).append(",");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFidcard()).append("',");
            debugBuffer.append("").append(nyxuploadinsurancelistDto.getInsurearea()).append(",");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getRemark()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTeamname()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getIndexcode()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getBreedingareacode()).append("',");
            debugBuffer.append("").append(nyxuploadinsurancelistDto.getAreanumber()).append(",");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getFlag1()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getOperatedate()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getLittleareaname()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getWarrant()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getLitterarea()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getMulchdate()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getMulchtype()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTemp1()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTemp2()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTemp3()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTemp4()).append("',");
            debugBuffer.append("'").append(nyxuploadinsurancelistDto.getTemp5()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxuploadinsurancelistDto.getInusrelistcode());
        dbManager.setString(2,nyxuploadinsurancelistDto.getBusinessno());
        dbManager.setString(3,nyxuploadinsurancelistDto.getFcode());
        dbManager.setString(4,nyxuploadinsurancelistDto.getPhone());
        dbManager.setString(5,nyxuploadinsurancelistDto.getZhibuka());
        dbManager.setString(6,nyxuploadinsurancelistDto.getBreedingareaname());
        dbManager.setLong(7,nyxuploadinsurancelistDto.getInsurenumber());
        dbManager.setString(8,nyxuploadinsurancelistDto.getSpecies());
        dbManager.setString(9,nyxuploadinsurancelistDto.getBank());
        dbManager.setString(10,nyxuploadinsurancelistDto.getBankcard());
        dbManager.setString(11,nyxuploadinsurancelistDto.getBreedingkind());
        dbManager.setString(12,nyxuploadinsurancelistDto.getFname());
        dbManager.setString(13,nyxuploadinsurancelistDto.getFlag());
        dbManager.setDouble(14,nyxuploadinsurancelistDto.getTaxarea());
        dbManager.setString(15,nyxuploadinsurancelistDto.getFidcard());
        dbManager.setDouble(16,nyxuploadinsurancelistDto.getInsurearea());
        dbManager.setString(17,nyxuploadinsurancelistDto.getRemark());
        dbManager.setString(18,nyxuploadinsurancelistDto.getTeamname());
        dbManager.setString(19,nyxuploadinsurancelistDto.getFieldsource());
        dbManager.setString(20,nyxuploadinsurancelistDto.getIndexcode());
        dbManager.setString(21,nyxuploadinsurancelistDto.getBreedingareacode());
        dbManager.setDouble(22,nyxuploadinsurancelistDto.getAreanumber());
        dbManager.setString(23,nyxuploadinsurancelistDto.getFlag1());
        dbManager.setDateTime(24,nyxuploadinsurancelistDto.getOperatedate());
        dbManager.setString(25,nyxuploadinsurancelistDto.getAtarea());
        dbManager.setString(26,nyxuploadinsurancelistDto.getLittleareaname());
        dbManager.setString(27,nyxuploadinsurancelistDto.getWarrant());
        dbManager.setString(28,nyxuploadinsurancelistDto.getLitterarea());
        dbManager.setString(29,nyxuploadinsurancelistDto.getMulchdate());
        dbManager.setString(30,nyxuploadinsurancelistDto.getMulchtype());
        dbManager.setString(31,nyxuploadinsurancelistDto.getTemp1());
        dbManager.setString(32,nyxuploadinsurancelistDto.getTemp2());
        dbManager.setString(33,nyxuploadinsurancelistDto.getTemp3());
        dbManager.setString(34,nyxuploadinsurancelistDto.getTemp4());
        dbManager.setString(35,nyxuploadinsurancelistDto.getTemp5());
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
        buffer.append("INSERT INTO Nyxuploadinsurancelist (");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Fcode,");
        buffer.append("Phone,");
        buffer.append("Zhibuka,");
        buffer.append("Breedingareaname,");
        buffer.append("Insurenumber,");
        buffer.append("Species,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Breedingkind,");
        buffer.append("Fname,");
        buffer.append("Flag,");
        buffer.append("Taxarea,");
        buffer.append("Fidcard,");
        buffer.append("Insurearea,");
        buffer.append("Remark,");
        buffer.append("Teamname,");
        buffer.append("Fieldsource,");
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Warrant,");
        buffer.append("Litterarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            NyxuploadinsurancelistDto nyxuploadinsurancelistDto = (NyxuploadinsurancelistDto)i.next();
            dbManager.setString(1,nyxuploadinsurancelistDto.getInusrelistcode());
            dbManager.setString(2,nyxuploadinsurancelistDto.getBusinessno());
            dbManager.setString(3,nyxuploadinsurancelistDto.getFcode());
            dbManager.setString(4,nyxuploadinsurancelistDto.getPhone());
            dbManager.setString(5,nyxuploadinsurancelistDto.getZhibuka());
            dbManager.setString(6,nyxuploadinsurancelistDto.getBreedingareaname());
            dbManager.setLong(7,nyxuploadinsurancelistDto.getInsurenumber());
            dbManager.setString(8,nyxuploadinsurancelistDto.getSpecies());
            dbManager.setString(9,nyxuploadinsurancelistDto.getBank());
            dbManager.setString(10,nyxuploadinsurancelistDto.getBankcard());
            dbManager.setString(11,nyxuploadinsurancelistDto.getBreedingkind());
            dbManager.setString(12,nyxuploadinsurancelistDto.getFname());
            dbManager.setString(13,nyxuploadinsurancelistDto.getFlag());
            dbManager.setDouble(14,nyxuploadinsurancelistDto.getTaxarea());
            dbManager.setString(15,nyxuploadinsurancelistDto.getFidcard());
            dbManager.setDouble(16,nyxuploadinsurancelistDto.getInsurearea());
            dbManager.setString(17,nyxuploadinsurancelistDto.getRemark());
            dbManager.setString(18,nyxuploadinsurancelistDto.getTeamname());
            dbManager.setString(19,nyxuploadinsurancelistDto.getFieldsource());
            dbManager.setString(20,nyxuploadinsurancelistDto.getIndexcode());
            dbManager.setString(21,nyxuploadinsurancelistDto.getBreedingareacode());
            dbManager.setDouble(22,nyxuploadinsurancelistDto.getAreanumber());
            dbManager.setString(23,nyxuploadinsurancelistDto.getFlag1());
            dbManager.setDateTime(24,nyxuploadinsurancelistDto.getOperatedate());
            dbManager.setString(25,nyxuploadinsurancelistDto.getAtarea());
            dbManager.setString(26,nyxuploadinsurancelistDto.getLittleareaname());
            dbManager.setString(27,nyxuploadinsurancelistDto.getWarrant());
            dbManager.setString(28,nyxuploadinsurancelistDto.getLitterarea());
            dbManager.setString(29,nyxuploadinsurancelistDto.getMulchdate());
            dbManager.setString(30,nyxuploadinsurancelistDto.getMulchtype());
            dbManager.setString(31,nyxuploadinsurancelistDto.getTemp1());
            dbManager.setString(32,nyxuploadinsurancelistDto.getTemp2());
            dbManager.setString(33,nyxuploadinsurancelistDto.getTemp3());
            dbManager.setString(34,nyxuploadinsurancelistDto.getTemp4());
            dbManager.setString(35,nyxuploadinsurancelistDto.getTemp5());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Nyxuploadinsurancelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Mulchtype=").append("'").append(mulchtype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Mulchtype = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,mulchtype);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void update(NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxuploadinsurancelist SET ");
        buffer.append("Fcode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Breedingareaname = ?, ");
        buffer.append("Insurenumber = ?, ");
        buffer.append("Species = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Bankcard = ?, ");
        buffer.append("Breedingkind = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Insurearea = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Teamname = ?, ");
        buffer.append("Fieldsource = ?, ");
        buffer.append("Indexcode = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Areanumber = ?, ");
        buffer.append("Flag1 = ?, ");
        buffer.append("Operatedate = ?, ");
        buffer.append("Atarea = ?, ");
        buffer.append("Littleareaname = ?, ");
        buffer.append("Warrant = ?, ");
        buffer.append("Litterarea = ?, ");
        buffer.append("Mulchdate = ?, ");
        buffer.append("Temp1 = ?, ");
        buffer.append("Temp2 = ?, ");
        buffer.append("Temp3 = ?, ");
        buffer.append("Temp4 = ?, ");
        buffer.append("Temp5 = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Nyxuploadinsurancelist SET ");
            debugBuffer.append("Fcode = '" + nyxuploadinsurancelistDto.getFcode() + "', ");
            debugBuffer.append("Phone = '" + nyxuploadinsurancelistDto.getPhone() + "', ");
            debugBuffer.append("Zhibuka = '" + nyxuploadinsurancelistDto.getZhibuka() + "', ");
            debugBuffer.append("Breedingareaname = '" + nyxuploadinsurancelistDto.getBreedingareaname() + "', ");
            debugBuffer.append("Insurenumber = " + nyxuploadinsurancelistDto.getInsurenumber() + ", ");
            debugBuffer.append("Species = '" + nyxuploadinsurancelistDto.getSpecies() + "', ");
            debugBuffer.append("Bank = '" + nyxuploadinsurancelistDto.getBank() + "', ");
            debugBuffer.append("Bankcard = '" + nyxuploadinsurancelistDto.getBankcard() + "', ");
            debugBuffer.append("Breedingkind = '" + nyxuploadinsurancelistDto.getBreedingkind() + "', ");
            debugBuffer.append("Fname = '" + nyxuploadinsurancelistDto.getFname() + "', ");
            debugBuffer.append("Flag = '" + nyxuploadinsurancelistDto.getFlag() + "', ");
            debugBuffer.append("Taxarea = " + nyxuploadinsurancelistDto.getTaxarea() + ", ");
            debugBuffer.append("Fidcard = '" + nyxuploadinsurancelistDto.getFidcard() + "', ");
            debugBuffer.append("Insurearea = " + nyxuploadinsurancelistDto.getInsurearea() + ", ");
            debugBuffer.append("Remark = '" + nyxuploadinsurancelistDto.getRemark() + "', ");
            debugBuffer.append("Teamname = '" + nyxuploadinsurancelistDto.getTeamname() + "', ");
            debugBuffer.append("Fieldsource = '" + nyxuploadinsurancelistDto.getFieldsource() + "', ");
            debugBuffer.append("Indexcode = '" + nyxuploadinsurancelistDto.getIndexcode() + "', ");
            debugBuffer.append("Breedingareacode = '" + nyxuploadinsurancelistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Areanumber = " + nyxuploadinsurancelistDto.getAreanumber() + ", ");
            debugBuffer.append("Flag1 = '" + nyxuploadinsurancelistDto.getFlag1() + "', ");
            debugBuffer.append("Operatedate = '" + nyxuploadinsurancelistDto.getOperatedate() + "', ");
            debugBuffer.append("Atarea = '" + nyxuploadinsurancelistDto.getAtarea() + "', ");
            debugBuffer.append("Littleareaname = '" + nyxuploadinsurancelistDto.getLittleareaname() + "', ");
            debugBuffer.append("Warrant = '" + nyxuploadinsurancelistDto.getWarrant() + "', ");
            debugBuffer.append("Litterarea = '" + nyxuploadinsurancelistDto.getLitterarea() + "', ");
            debugBuffer.append("Mulchdate = '" + nyxuploadinsurancelistDto.getMulchdate() + "', ");
            debugBuffer.append("Temp1 = '" + nyxuploadinsurancelistDto.getTemp1() + "', ");
            debugBuffer.append("Temp2 = '" + nyxuploadinsurancelistDto.getTemp2() + "', ");
            debugBuffer.append("Temp3 = '" + nyxuploadinsurancelistDto.getTemp3() + "', ");
            debugBuffer.append("Temp4 = '" + nyxuploadinsurancelistDto.getTemp4() + "', ");
            debugBuffer.append("Temp5 = '" + nyxuploadinsurancelistDto.getTemp5() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(nyxuploadinsurancelistDto.getInusrelistcode()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(nyxuploadinsurancelistDto.getBusinessno()).append("' AND ");
            debugBuffer.append("Mulchtype=").append("'").append(nyxuploadinsurancelistDto.getMulchtype()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Mulchtype = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxuploadinsurancelistDto.getFcode());
        dbManager.setString(2,nyxuploadinsurancelistDto.getPhone());
        dbManager.setString(3,nyxuploadinsurancelistDto.getZhibuka());
        dbManager.setString(4,nyxuploadinsurancelistDto.getBreedingareaname());
        dbManager.setLong(5,nyxuploadinsurancelistDto.getInsurenumber());
        dbManager.setString(6,nyxuploadinsurancelistDto.getSpecies());
        dbManager.setString(7,nyxuploadinsurancelistDto.getBank());
        dbManager.setString(8,nyxuploadinsurancelistDto.getBankcard());
        dbManager.setString(9,nyxuploadinsurancelistDto.getBreedingkind());
        dbManager.setString(10,nyxuploadinsurancelistDto.getFname());
        dbManager.setString(11,nyxuploadinsurancelistDto.getFlag());
        dbManager.setDouble(12,nyxuploadinsurancelistDto.getTaxarea());
        dbManager.setString(13,nyxuploadinsurancelistDto.getFidcard());
        dbManager.setDouble(14,nyxuploadinsurancelistDto.getInsurearea());
        dbManager.setString(15,nyxuploadinsurancelistDto.getRemark());
        dbManager.setString(16,nyxuploadinsurancelistDto.getTeamname());
        dbManager.setString(17,nyxuploadinsurancelistDto.getFieldsource());
        dbManager.setString(18,nyxuploadinsurancelistDto.getIndexcode());
        dbManager.setString(19,nyxuploadinsurancelistDto.getBreedingareacode());
        dbManager.setDouble(20,nyxuploadinsurancelistDto.getAreanumber());
        dbManager.setString(21,nyxuploadinsurancelistDto.getFlag1());
        dbManager.setDateTime(22,nyxuploadinsurancelistDto.getOperatedate());
        dbManager.setString(23,nyxuploadinsurancelistDto.getAtarea());
        dbManager.setString(24,nyxuploadinsurancelistDto.getLittleareaname());
        dbManager.setString(25,nyxuploadinsurancelistDto.getWarrant());
        dbManager.setString(26,nyxuploadinsurancelistDto.getLitterarea());
        dbManager.setString(27,nyxuploadinsurancelistDto.getMulchdate());
        dbManager.setString(28,nyxuploadinsurancelistDto.getTemp1());
        dbManager.setString(29,nyxuploadinsurancelistDto.getTemp2());
        dbManager.setString(30,nyxuploadinsurancelistDto.getTemp3());
        dbManager.setString(31,nyxuploadinsurancelistDto.getTemp4());
        dbManager.setString(32,nyxuploadinsurancelistDto.getTemp5());
        //设置条件字段;
        dbManager.setString(33,nyxuploadinsurancelistDto.getInusrelistcode());
        dbManager.setString(34,nyxuploadinsurancelistDto.getBusinessno());
        dbManager.setString(35,nyxuploadinsurancelistDto.getMulchtype());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @return NyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistDto findByPrimaryKey(String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Fcode,");
        buffer.append("Phone,");
        buffer.append("Zhibuka,");
        buffer.append("Breedingareaname,");
        buffer.append("Insurenumber,");
        buffer.append("Species,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Breedingkind,");
        buffer.append("Fname,");
        buffer.append("Flag,");
        buffer.append("Taxarea,");
        buffer.append("Fidcard,");
        buffer.append("Insurearea,");
        buffer.append("Remark,");
        buffer.append("Teamname,");
        buffer.append("Fieldsource,");
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Warrant,");
        buffer.append("Litterarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append("FROM Nyxuploadinsurancelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Inusrelistcode=").append("'").append(inusrelistcode).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("' AND ");
            debugBuffer.append("Mulchtype=").append("'").append(mulchtype).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Inusrelistcode = ? And ");
        buffer.append("Businessno = ? And ");
        buffer.append("Mulchtype = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,inusrelistcode);
        dbManager.setString(2,businessno);
        dbManager.setString(3,mulchtype);
        ResultSet resultSet = dbManager.executePreparedQuery();
        NyxuploadinsurancelistDto nyxuploadinsurancelistDto = null;
        if(resultSet.next()){
            nyxuploadinsurancelistDto = new NyxuploadinsurancelistDto();
            nyxuploadinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,1));
            nyxuploadinsurancelistDto.setBusinessno(dbManager.getString(resultSet,2));
            nyxuploadinsurancelistDto.setFcode(dbManager.getString(resultSet,3));
            nyxuploadinsurancelistDto.setPhone(dbManager.getString(resultSet,4));
            nyxuploadinsurancelistDto.setZhibuka(dbManager.getString(resultSet,5));
            nyxuploadinsurancelistDto.setBreedingareaname(dbManager.getString(resultSet,6));
            nyxuploadinsurancelistDto.setInsurenumber(dbManager.getLong(resultSet,7));
            nyxuploadinsurancelistDto.setSpecies(dbManager.getString(resultSet,8));
            nyxuploadinsurancelistDto.setBank(dbManager.getString(resultSet,9));
            nyxuploadinsurancelistDto.setBankcard(dbManager.getString(resultSet,10));
            nyxuploadinsurancelistDto.setBreedingkind(dbManager.getString(resultSet,11));
            nyxuploadinsurancelistDto.setFname(dbManager.getString(resultSet,12));
            nyxuploadinsurancelistDto.setFlag(dbManager.getString(resultSet,13));
            nyxuploadinsurancelistDto.setTaxarea(dbManager.getDouble(resultSet,14));
            nyxuploadinsurancelistDto.setFidcard(dbManager.getString(resultSet,15));
            nyxuploadinsurancelistDto.setInsurearea(dbManager.getDouble(resultSet,16));
            nyxuploadinsurancelistDto.setRemark(dbManager.getString(resultSet,17));
            nyxuploadinsurancelistDto.setTeamname(dbManager.getString(resultSet,18));
            nyxuploadinsurancelistDto.setFieldsource(dbManager.getString(resultSet,19));
            nyxuploadinsurancelistDto.setIndexcode(dbManager.getString(resultSet,20));
            nyxuploadinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,21));
            nyxuploadinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,22));
            nyxuploadinsurancelistDto.setFlag1(dbManager.getString(resultSet,23));
            nyxuploadinsurancelistDto.setOperatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            nyxuploadinsurancelistDto.setAtarea(dbManager.getString(resultSet,25));
            nyxuploadinsurancelistDto.setLittleareaname(dbManager.getString(resultSet,26));
            nyxuploadinsurancelistDto.setWarrant(dbManager.getString(resultSet,27));
            nyxuploadinsurancelistDto.setLitterarea(dbManager.getString(resultSet,28));
            nyxuploadinsurancelistDto.setMulchdate(dbManager.getString(resultSet,29));
            nyxuploadinsurancelistDto.setMulchtype(dbManager.getString(resultSet,30));
            nyxuploadinsurancelistDto.setTemp1(dbManager.getString(resultSet,31));
            nyxuploadinsurancelistDto.setTemp2(dbManager.getString(resultSet,32));
            nyxuploadinsurancelistDto.setTemp3(dbManager.getString(resultSet,33));
            nyxuploadinsurancelistDto.setTemp4(dbManager.getString(resultSet,34));
            nyxuploadinsurancelistDto.setTemp5(dbManager.getString(resultSet,35));
        }
        resultSet.close();
        return nyxuploadinsurancelistDto;
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
        buffer.append("Fcode,");
        buffer.append("Phone,");
        buffer.append("Zhibuka,");
        buffer.append("Breedingareaname,");
        buffer.append("Insurenumber,");
        buffer.append("Species,");
        buffer.append("Bank,");
        buffer.append("Bankcard,");
        buffer.append("Breedingkind,");
        buffer.append("Fname,");
        buffer.append("Flag,");
        buffer.append("Taxarea,");
        buffer.append("Fidcard,");
        buffer.append("Insurearea,");
        buffer.append("Remark,");
        buffer.append("Teamname,");
        buffer.append("Fieldsource,");
        buffer.append("Indexcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Areanumber,");
        buffer.append("Flag1,");
        buffer.append("Operatedate,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Warrant,");
        buffer.append("Litterarea,");
        buffer.append("Mulchdate,");
        buffer.append("Mulchtype,");
        buffer.append("Temp1,");
        buffer.append("Temp2,");
        buffer.append("Temp3,");
        buffer.append("Temp4,");
        buffer.append("Temp5 ");
        buffer.append("FROM Nyxuploadinsurancelist WHERE ");
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
        NyxuploadinsurancelistDto nyxuploadinsurancelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxuploadinsurancelistDto = new NyxuploadinsurancelistDto();
            nyxuploadinsurancelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxuploadinsurancelistDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            nyxuploadinsurancelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxuploadinsurancelistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxuploadinsurancelistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxuploadinsurancelistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            nyxuploadinsurancelistDto.setInsurenumber(dbManager.getLong(resultSet,"Insurenumber"));
            nyxuploadinsurancelistDto.setSpecies(dbManager.getString(resultSet,"Species"));
            nyxuploadinsurancelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxuploadinsurancelistDto.setBankcard(dbManager.getString(resultSet,"Bankcard"));
            nyxuploadinsurancelistDto.setBreedingkind(dbManager.getString(resultSet,"Breedingkind"));
            nyxuploadinsurancelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxuploadinsurancelistDto.setFlag(dbManager.getString(resultSet,"Flag"));
            nyxuploadinsurancelistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxuploadinsurancelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxuploadinsurancelistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxuploadinsurancelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxuploadinsurancelistDto.setTeamname(dbManager.getString(resultSet,"Teamname"));
            nyxuploadinsurancelistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxuploadinsurancelistDto.setIndexcode(dbManager.getString(resultSet,"Indexcode"));
            nyxuploadinsurancelistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            nyxuploadinsurancelistDto.setAreanumber(dbManager.getDouble(resultSet,"Areanumber"));
            nyxuploadinsurancelistDto.setFlag1(dbManager.getString(resultSet,"Flag1"));
            nyxuploadinsurancelistDto.setOperatedate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Operatedate"));
            nyxuploadinsurancelistDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxuploadinsurancelistDto.setLittleareaname(dbManager.getString(resultSet,"Littleareaname"));
            nyxuploadinsurancelistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxuploadinsurancelistDto.setLitterarea(dbManager.getString(resultSet,"Litterarea"));
            nyxuploadinsurancelistDto.setMulchdate(dbManager.getString(resultSet,"Mulchdate"));
            nyxuploadinsurancelistDto.setMulchtype(dbManager.getString(resultSet,"Mulchtype"));
            nyxuploadinsurancelistDto.setTemp1(dbManager.getString(resultSet,"Temp1"));
            nyxuploadinsurancelistDto.setTemp2(dbManager.getString(resultSet,"Temp2"));
            nyxuploadinsurancelistDto.setTemp3(dbManager.getString(resultSet,"Temp3"));
            nyxuploadinsurancelistDto.setTemp4(dbManager.getString(resultSet,"Temp4"));
            nyxuploadinsurancelistDto.setTemp5(dbManager.getString(resultSet,"Temp5"));
            collection.add(nyxuploadinsurancelistDto);
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
        buffer.append("DELETE FROM Nyxuploadinsurancelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxuploadinsurancelist WHERE ");
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
