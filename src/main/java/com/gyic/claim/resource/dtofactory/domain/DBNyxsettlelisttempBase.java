package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.dto.domain.Planting31SettleListDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXSETTLELISTTEMP的数据访问对象基类<br>
 */
public class DBNyxsettlelisttempBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxsettlelisttempBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBNyxsettlelisttempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void insert(NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Fieldsource ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getRegistcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getStringtimestamp()).append("',");
            debugBuffer.append("").append(nyxsettlelisttempDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getRiskcode()).append("',");
            debugBuffer.append("").append(nyxsettlelisttempDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxsettlelisttempDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getFareacode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(nyxsettlelisttempDto.getGrowingseason()).append(",");
            debugBuffer.append("").append(nyxsettlelisttempDto.getLossrate()).append(",");
            debugBuffer.append("").append(nyxsettlelisttempDto.getSettlearea()).append(",");
            debugBuffer.append("").append(nyxsettlelisttempDto.getSettlesum()).append(",");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getRemark()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getSettledate()).append("',");
            debugBuffer.append("").append(nyxsettlelisttempDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getNodetype()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getWarrant()).append("',");
            debugBuffer.append("").append(nyxsettlelisttempDto.getTaxarea()).append(",");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getLittleareaname()).append("',");
            debugBuffer.append("'").append(nyxsettlelisttempDto.getFieldsource()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxsettlelisttempDto.getRegistcode());
        dbManager.setString(2,nyxsettlelisttempDto.getStringtimestamp());
        dbManager.setInt(3,nyxsettlelisttempDto.getIndexofsettle());
        dbManager.setString(4,nyxsettlelisttempDto.getFcode());
        dbManager.setString(5,nyxsettlelisttempDto.getKindcode());
        dbManager.setString(6,nyxsettlelisttempDto.getItemcode());
        dbManager.setString(7,nyxsettlelisttempDto.getClasscode());
        dbManager.setString(8,nyxsettlelisttempDto.getRiskcode());
        dbManager.setDouble(9,nyxsettlelisttempDto.getInsurearea());
        dbManager.setDouble(10,nyxsettlelisttempDto.getSuminsured());
        dbManager.setString(11,nyxsettlelisttempDto.getZhibuka());
        dbManager.setString(12,nyxsettlelisttempDto.getFname());
        dbManager.setString(13,nyxsettlelisttempDto.getFidcard());
        dbManager.setString(14,nyxsettlelisttempDto.getFareacode());
        dbManager.setString(15,nyxsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(16,nyxsettlelisttempDto.getGrowingseason());
        dbManager.setDouble(17,nyxsettlelisttempDto.getLossrate());
        dbManager.setDouble(18,nyxsettlelisttempDto.getSettlearea());
        dbManager.setDouble(19,nyxsettlelisttempDto.getSettlesum());
        dbManager.setString(20,nyxsettlelisttempDto.getOpcode());
        dbManager.setDateTime(21,nyxsettlelisttempDto.getOptime());
        dbManager.setString(22,nyxsettlelisttempDto.getRemark());
        dbManager.setString(23,nyxsettlelisttempDto.getValidity());
        dbManager.setDateTime(24,nyxsettlelisttempDto.getSettledate());
        dbManager.setDouble(25,nyxsettlelisttempDto.getClaimrate());
        dbManager.setString(26,nyxsettlelisttempDto.getNodetype());
        dbManager.setString(27,nyxsettlelisttempDto.getPhone());
        dbManager.setString(28,nyxsettlelisttempDto.getBank());
        dbManager.setString(29,nyxsettlelisttempDto.getWarrant());
        dbManager.setDouble(30,nyxsettlelisttempDto.getTaxarea());
        dbManager.setString(31,nyxsettlelisttempDto.getAtarea());
        dbManager.setString(32,nyxsettlelisttempDto.getLittleareaname());
        dbManager.setString(33,nyxsettlelisttempDto.getFieldsource());
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
        buffer.append("INSERT INTO Nyxsettlelisttemp (");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Fieldsource ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            NyxsettlelisttempDto nyxsettlelisttempDto = (NyxsettlelisttempDto)i.next();
            dbManager.setString(1,nyxsettlelisttempDto.getRegistcode());
            dbManager.setString(2,nyxsettlelisttempDto.getStringtimestamp());
            dbManager.setInt(3,nyxsettlelisttempDto.getIndexofsettle());
            dbManager.setString(4,nyxsettlelisttempDto.getFcode());
            dbManager.setString(5,nyxsettlelisttempDto.getKindcode());
            dbManager.setString(6,nyxsettlelisttempDto.getItemcode());
            dbManager.setString(7,nyxsettlelisttempDto.getClasscode());
            dbManager.setString(8,nyxsettlelisttempDto.getRiskcode());
            dbManager.setDouble(9,nyxsettlelisttempDto.getInsurearea());
            dbManager.setDouble(10,nyxsettlelisttempDto.getSuminsured());
            dbManager.setString(11,nyxsettlelisttempDto.getZhibuka());
            dbManager.setString(12,nyxsettlelisttempDto.getFname());
            dbManager.setString(13,nyxsettlelisttempDto.getFidcard());
            dbManager.setString(14,nyxsettlelisttempDto.getFareacode());
            dbManager.setString(15,nyxsettlelisttempDto.getInusrelistcode());
            dbManager.setDouble(16,nyxsettlelisttempDto.getGrowingseason());
            dbManager.setDouble(17,nyxsettlelisttempDto.getLossrate());
            dbManager.setDouble(18,nyxsettlelisttempDto.getSettlearea());
            dbManager.setDouble(19,nyxsettlelisttempDto.getSettlesum());
            dbManager.setString(20,nyxsettlelisttempDto.getOpcode());
            dbManager.setDateTime(21,nyxsettlelisttempDto.getOptime());
            dbManager.setString(22,nyxsettlelisttempDto.getRemark());
            dbManager.setString(23,nyxsettlelisttempDto.getValidity());
            dbManager.setDateTime(24,nyxsettlelisttempDto.getSettledate());
            dbManager.setDouble(25,nyxsettlelisttempDto.getClaimrate());
            dbManager.setString(26,nyxsettlelisttempDto.getNodetype());
            dbManager.setString(27,nyxsettlelisttempDto.getPhone());
            dbManager.setString(28,nyxsettlelisttempDto.getBank());
            dbManager.setString(29,nyxsettlelisttempDto.getWarrant());
            dbManager.setDouble(30,nyxsettlelisttempDto.getTaxarea());
            dbManager.setString(31,nyxsettlelisttempDto.getAtarea());
            dbManager.setString(32,nyxsettlelisttempDto.getLittleareaname());
            dbManager.setString(33,nyxsettlelisttempDto.getFieldsource());
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
        buffer.append("DELETE FROM Nyxsettlelisttemp ");
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
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void update(NyxsettlelisttempDto nyxsettlelisttempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxsettlelisttemp SET ");
        buffer.append("Fcode = ?, ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Itemcode = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Insurearea = ?, ");
        buffer.append("Suminsured = ?, ");
        buffer.append("Zhibuka = ?, ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Fareacode = ?, ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Growingseason = ?, ");
        buffer.append("Lossrate = ?, ");
        buffer.append("Settlearea = ?, ");
        buffer.append("Settlesum = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Settledate = ?, ");
        buffer.append("Claimrate = ?, ");
        buffer.append("Nodetype = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Warrant = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Atarea = ?, ");
        buffer.append("Littleareaname = ?, ");
        buffer.append("Fieldsource = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Nyxsettlelisttemp SET ");
            debugBuffer.append("Fcode = '" + nyxsettlelisttempDto.getFcode() + "', ");
            debugBuffer.append("Kindcode = '" + nyxsettlelisttempDto.getKindcode() + "', ");
            debugBuffer.append("Itemcode = '" + nyxsettlelisttempDto.getItemcode() + "', ");
            debugBuffer.append("Classcode = '" + nyxsettlelisttempDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxsettlelisttempDto.getRiskcode() + "', ");
            debugBuffer.append("Insurearea = " + nyxsettlelisttempDto.getInsurearea() + ", ");
            debugBuffer.append("Suminsured = " + nyxsettlelisttempDto.getSuminsured() + ", ");
            debugBuffer.append("Zhibuka = '" + nyxsettlelisttempDto.getZhibuka() + "', ");
            debugBuffer.append("Fname = '" + nyxsettlelisttempDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + nyxsettlelisttempDto.getFidcard() + "', ");
            debugBuffer.append("Fareacode = '" + nyxsettlelisttempDto.getFareacode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + nyxsettlelisttempDto.getInusrelistcode() + "', ");
            debugBuffer.append("Growingseason = " + nyxsettlelisttempDto.getGrowingseason() + ", ");
            debugBuffer.append("Lossrate = " + nyxsettlelisttempDto.getLossrate() + ", ");
            debugBuffer.append("Settlearea = " + nyxsettlelisttempDto.getSettlearea() + ", ");
            debugBuffer.append("Settlesum = " + nyxsettlelisttempDto.getSettlesum() + ", ");
            debugBuffer.append("Opcode = '" + nyxsettlelisttempDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxsettlelisttempDto.getOptime() + "', ");
            debugBuffer.append("Remark = '" + nyxsettlelisttempDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + nyxsettlelisttempDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + nyxsettlelisttempDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + nyxsettlelisttempDto.getClaimrate() + ", ");
            debugBuffer.append("Nodetype = '" + nyxsettlelisttempDto.getNodetype() + "', ");
            debugBuffer.append("Phone = '" + nyxsettlelisttempDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxsettlelisttempDto.getBank() + "', ");
            debugBuffer.append("Warrant = '" + nyxsettlelisttempDto.getWarrant() + "', ");
            debugBuffer.append("Taxarea = " + nyxsettlelisttempDto.getTaxarea() + ", ");
            debugBuffer.append("Atarea = '" + nyxsettlelisttempDto.getAtarea() + "', ");
            debugBuffer.append("Littleareaname = '" + nyxsettlelisttempDto.getLittleareaname() + "', ");
            debugBuffer.append("Fieldsource = '" + nyxsettlelisttempDto.getFieldsource() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Registcode=").append("'").append(nyxsettlelisttempDto.getRegistcode()).append("' AND ");
            debugBuffer.append("Stringtimestamp=").append("'").append(nyxsettlelisttempDto.getStringtimestamp()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(nyxsettlelisttempDto.getIndexofsettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Registcode = ? And ");
        buffer.append("Stringtimestamp = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,nyxsettlelisttempDto.getFcode());
        dbManager.setString(2,nyxsettlelisttempDto.getKindcode());
        dbManager.setString(3,nyxsettlelisttempDto.getItemcode());
        dbManager.setString(4,nyxsettlelisttempDto.getClasscode());
        dbManager.setString(5,nyxsettlelisttempDto.getRiskcode());
        dbManager.setDouble(6,nyxsettlelisttempDto.getInsurearea());
        dbManager.setDouble(7,nyxsettlelisttempDto.getSuminsured());
        dbManager.setString(8,nyxsettlelisttempDto.getZhibuka());
        dbManager.setString(9,nyxsettlelisttempDto.getFname());
        dbManager.setString(10,nyxsettlelisttempDto.getFidcard());
        dbManager.setString(11,nyxsettlelisttempDto.getFareacode());
        dbManager.setString(12,nyxsettlelisttempDto.getInusrelistcode());
        dbManager.setDouble(13,nyxsettlelisttempDto.getGrowingseason());
        dbManager.setDouble(14,nyxsettlelisttempDto.getLossrate());
        dbManager.setDouble(15,nyxsettlelisttempDto.getSettlearea());
        dbManager.setDouble(16,nyxsettlelisttempDto.getSettlesum());
        dbManager.setString(17,nyxsettlelisttempDto.getOpcode());
        dbManager.setDateTime(18,nyxsettlelisttempDto.getOptime());
        dbManager.setString(19,nyxsettlelisttempDto.getRemark());
        dbManager.setString(20,nyxsettlelisttempDto.getValidity());
        dbManager.setDateTime(21,nyxsettlelisttempDto.getSettledate());
        dbManager.setDouble(22,nyxsettlelisttempDto.getClaimrate());
        dbManager.setString(23,nyxsettlelisttempDto.getNodetype());
        dbManager.setString(24,nyxsettlelisttempDto.getPhone());
        dbManager.setString(25,nyxsettlelisttempDto.getBank());
        dbManager.setString(26,nyxsettlelisttempDto.getWarrant());
        dbManager.setDouble(27,nyxsettlelisttempDto.getTaxarea());
        dbManager.setString(28,nyxsettlelisttempDto.getAtarea());
        dbManager.setString(29,nyxsettlelisttempDto.getLittleareaname());
        dbManager.setString(30,nyxsettlelisttempDto.getFieldsource());
        //设置条件字段;
        dbManager.setString(31,nyxsettlelisttempDto.getRegistcode());
        dbManager.setString(32,nyxsettlelisttempDto.getStringtimestamp());
        dbManager.setInt(33,nyxsettlelisttempDto.getIndexofsettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return NyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Registcode,");
        buffer.append("Stringtimestamp,");
        buffer.append("Indexofsettle,");
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Fieldsource ");
        buffer.append("FROM Nyxsettlelisttemp ");
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
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        if(resultSet.next()){
            nyxsettlelisttempDto = new NyxsettlelisttempDto();
            nyxsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,1));
            nyxsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,2));
            nyxsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,3));
            nyxsettlelisttempDto.setFcode(dbManager.getString(resultSet,4));
            nyxsettlelisttempDto.setKindcode(dbManager.getString(resultSet,5));
            nyxsettlelisttempDto.setItemcode(dbManager.getString(resultSet,6));
            nyxsettlelisttempDto.setClasscode(dbManager.getString(resultSet,7));
            nyxsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,8));
            nyxsettlelisttempDto.setInsurearea(dbManager.getDouble(resultSet,9));
            nyxsettlelisttempDto.setSuminsured(dbManager.getDouble(resultSet,10));
            nyxsettlelisttempDto.setZhibuka(dbManager.getString(resultSet,11));
            nyxsettlelisttempDto.setFname(dbManager.getString(resultSet,12));
            nyxsettlelisttempDto.setFidcard(dbManager.getString(resultSet,13));
            nyxsettlelisttempDto.setFareacode(dbManager.getString(resultSet,14));
            nyxsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,15));
            nyxsettlelisttempDto.setGrowingseason(dbManager.getDouble(resultSet,16));
            nyxsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,17));
            nyxsettlelisttempDto.setSettlearea(dbManager.getDouble(resultSet,18));
            nyxsettlelisttempDto.setSettlesum(dbManager.getDouble(resultSet,19));
            nyxsettlelisttempDto.setOpcode(dbManager.getString(resultSet,20));
            nyxsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,21));
            nyxsettlelisttempDto.setRemark(dbManager.getString(resultSet,22));
            nyxsettlelisttempDto.setValidity(dbManager.getString(resultSet,23));
            nyxsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
            nyxsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,25));
            nyxsettlelisttempDto.setNodetype(dbManager.getString(resultSet,26));
            nyxsettlelisttempDto.setPhone(dbManager.getString(resultSet,27));
            nyxsettlelisttempDto.setBank(dbManager.getString(resultSet,28));
            nyxsettlelisttempDto.setWarrant(dbManager.getString(resultSet,29));
            nyxsettlelisttempDto.setTaxarea(dbManager.getDouble(resultSet,30));
            nyxsettlelisttempDto.setAtarea(dbManager.getString(resultSet,31));
            nyxsettlelisttempDto.setLittleareaname(dbManager.getString(resultSet,32));
            nyxsettlelisttempDto.setFieldsource(dbManager.getString(resultSet,33));
        }
        resultSet.close();
        return nyxsettlelisttempDto;
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
        buffer.append("Fcode,");
        buffer.append("Kindcode,");
        buffer.append("Itemcode,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Insurearea,");
        buffer.append("Suminsured,");
        buffer.append("Zhibuka,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Fareacode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Growingseason,");
        buffer.append("Lossrate,");
        buffer.append("Settlearea,");
        buffer.append("Settlesum,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Remark,");
        buffer.append("Validity,");
        buffer.append("Settledate,");
        buffer.append("Claimrate,");
        buffer.append("Nodetype,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname,");
        buffer.append("Fieldsource ");
        buffer.append("FROM Nyxsettlelisttemp WHERE ");
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
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxsettlelisttempDto = new NyxsettlelisttempDto();
            nyxsettlelisttempDto.setRegistcode(dbManager.getString(resultSet,"Registcode"));
            nyxsettlelisttempDto.setStringtimestamp(dbManager.getString(resultSet,"Stringtimestamp"));
            nyxsettlelisttempDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            nyxsettlelisttempDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxsettlelisttempDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxsettlelisttempDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxsettlelisttempDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxsettlelisttempDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxsettlelisttempDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxsettlelisttempDto.setSuminsured(dbManager.getDouble(resultSet,"Suminsured"));
            nyxsettlelisttempDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxsettlelisttempDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxsettlelisttempDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxsettlelisttempDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxsettlelisttempDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxsettlelisttempDto.setGrowingseason(dbManager.getDouble(resultSet,"Growingseason"));
            nyxsettlelisttempDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            nyxsettlelisttempDto.setSettlearea(dbManager.getDouble(resultSet,"Settlearea"));
            nyxsettlelisttempDto.setSettlesum(dbManager.getDouble(resultSet,"Settlesum"));
            nyxsettlelisttempDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxsettlelisttempDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxsettlelisttempDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxsettlelisttempDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxsettlelisttempDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            nyxsettlelisttempDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            nyxsettlelisttempDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            nyxsettlelisttempDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxsettlelisttempDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxsettlelisttempDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxsettlelisttempDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxsettlelisttempDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxsettlelisttempDto.setLittleareaname(dbManager.getString(resultSet,"Littleareaname"));
            nyxsettlelisttempDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            collection.add(nyxsettlelisttempDto);
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
        buffer.append("DELETE FROM Nyxsettlelisttemp WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxsettlelisttemp WHERE ");
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
	        buffer.append("SELECT sum("+fieldName+") FROM nyxSettleListTemp WHERE ");
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
