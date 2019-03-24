package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.dto.domain.Planting31SettleListDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELIST�����ݷ��ʶ������<br>
 */
public class DBNyxsettlelistBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBNyxsettlelistBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBNyxsettlelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void insert(NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxsettlelist (");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Fcodemodify,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(nyxsettlelistDto.getSettlelistcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getKindcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getItemcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getClasscode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getRiskcode()).append("',");
            debugBuffer.append("").append(nyxsettlelistDto.getInsurearea()).append(",");
            debugBuffer.append("").append(nyxsettlelistDto.getSuminsured()).append(",");
            debugBuffer.append("'").append(nyxsettlelistDto.getZhibuka()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFname()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFareacode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getInusrelistcode()).append("',");
            debugBuffer.append("").append(nyxsettlelistDto.getGrowingseason()).append(",");
            debugBuffer.append("").append(nyxsettlelistDto.getLossrate()).append(",");
            debugBuffer.append("").append(nyxsettlelistDto.getSettlearea()).append(",");
            debugBuffer.append("").append(nyxsettlelistDto.getSettlesum()).append(",");
            debugBuffer.append("'").append(nyxsettlelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getRemark()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getSettledate()).append("',");
            debugBuffer.append("").append(nyxsettlelistDto.getClaimrate()).append(",");
            debugBuffer.append("'").append(nyxsettlelistDto.getNodetype()).append("',");
            debugBuffer.append("").append(nyxsettlelistDto.getIndexofsettle()).append(",");
            debugBuffer.append("'").append(nyxsettlelistDto.getPhone()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getBank()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFieldsource()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getFcodemodify()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getWarrant()).append("',");
            debugBuffer.append("").append(nyxsettlelistDto.getTaxarea()).append(",");
            debugBuffer.append("'").append(nyxsettlelistDto.getAtarea()).append("',");
            debugBuffer.append("'").append(nyxsettlelistDto.getLittleareaname()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,nyxsettlelistDto.getSettlelistcode());
        dbManager.setString(2,nyxsettlelistDto.getFcode());
        dbManager.setString(3,nyxsettlelistDto.getKindcode());
        dbManager.setString(4,nyxsettlelistDto.getItemcode());
        dbManager.setString(5,nyxsettlelistDto.getClasscode());
        dbManager.setString(6,nyxsettlelistDto.getRiskcode());
        dbManager.setDouble(7,nyxsettlelistDto.getInsurearea());
        dbManager.setDouble(8,nyxsettlelistDto.getSuminsured());
        dbManager.setString(9,nyxsettlelistDto.getZhibuka());
        dbManager.setString(10,nyxsettlelistDto.getFname());
        dbManager.setString(11,nyxsettlelistDto.getFidcard());
        dbManager.setString(12,nyxsettlelistDto.getFareacode());
        dbManager.setString(13,nyxsettlelistDto.getInusrelistcode());
        dbManager.setDouble(14,nyxsettlelistDto.getGrowingseason());
        dbManager.setDouble(15,nyxsettlelistDto.getLossrate());
        dbManager.setDouble(16,nyxsettlelistDto.getSettlearea());
        dbManager.setDouble(17,nyxsettlelistDto.getSettlesum());
        dbManager.setString(18,nyxsettlelistDto.getOpcode());
        dbManager.setDateTime(19,nyxsettlelistDto.getOptime());
        dbManager.setString(20,nyxsettlelistDto.getRemark());
        dbManager.setString(21,nyxsettlelistDto.getValidity());
        dbManager.setDateTime(22,nyxsettlelistDto.getSettledate());
        dbManager.setDouble(23,nyxsettlelistDto.getClaimrate());
        dbManager.setString(24,nyxsettlelistDto.getNodetype());
        dbManager.setInt(25,nyxsettlelistDto.getIndexofsettle());
        dbManager.setString(26,nyxsettlelistDto.getPhone());
        dbManager.setString(27,nyxsettlelistDto.getBank());
        dbManager.setString(28,nyxsettlelistDto.getFieldsource());
        dbManager.setString(29,nyxsettlelistDto.getFcodemodify());
        dbManager.setString(30,nyxsettlelistDto.getWarrant());
        dbManager.setDouble(31,nyxsettlelistDto.getTaxarea());
        dbManager.setString(32,nyxsettlelistDto.getAtarea());
        dbManager.setString(33,nyxsettlelistDto.getLittleareaname());
        dbManager.executePreparedUpdate();

    }
    
    public double getDamageInsured(String conditions) 
    throws Exception{
    double count = 0.00;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT count(distinct(FIDCARD)) FROM nyxSETTLELIST WHERE ");
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
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Nyxsettlelist (");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Fcodemodify,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            NyxsettlelistDto nyxsettlelistDto = (NyxsettlelistDto)i.next();
            dbManager.setString(1,nyxsettlelistDto.getSettlelistcode());
            dbManager.setString(2,nyxsettlelistDto.getFcode());
            dbManager.setString(3,nyxsettlelistDto.getKindcode());
            dbManager.setString(4,nyxsettlelistDto.getItemcode());
            dbManager.setString(5,nyxsettlelistDto.getClasscode());
            dbManager.setString(6,nyxsettlelistDto.getRiskcode());
            dbManager.setDouble(7,nyxsettlelistDto.getInsurearea());
            dbManager.setDouble(8,nyxsettlelistDto.getSuminsured());
            dbManager.setString(9,nyxsettlelistDto.getZhibuka());
            dbManager.setString(10,nyxsettlelistDto.getFname());
            dbManager.setString(11,nyxsettlelistDto.getFidcard());
            dbManager.setString(12,nyxsettlelistDto.getFareacode());
            dbManager.setString(13,nyxsettlelistDto.getInusrelistcode());
            dbManager.setDouble(14,nyxsettlelistDto.getGrowingseason());
            dbManager.setDouble(15,nyxsettlelistDto.getLossrate());
            dbManager.setDouble(16,nyxsettlelistDto.getSettlearea());
            dbManager.setDouble(17,nyxsettlelistDto.getSettlesum());
            dbManager.setString(18,nyxsettlelistDto.getOpcode());
            dbManager.setDateTime(19,nyxsettlelistDto.getOptime());
            dbManager.setString(20,nyxsettlelistDto.getRemark());
            dbManager.setString(21,nyxsettlelistDto.getValidity());
            dbManager.setDateTime(22,nyxsettlelistDto.getSettledate());
            dbManager.setDouble(23,nyxsettlelistDto.getClaimrate());
            dbManager.setString(24,nyxsettlelistDto.getNodetype());
            dbManager.setInt(25,nyxsettlelistDto.getIndexofsettle());
            dbManager.setString(26,nyxsettlelistDto.getPhone());
            dbManager.setString(27,nyxsettlelistDto.getBank());
            dbManager.setString(28,nyxsettlelistDto.getFieldsource());
            dbManager.setString(29,nyxsettlelistDto.getFcodemodify());
            dbManager.setString(30,nyxsettlelistDto.getWarrant());
            dbManager.setDouble(31,nyxsettlelistDto.getTaxarea());
            dbManager.setString(32,nyxsettlelistDto.getAtarea());
            dbManager.setString(33,nyxsettlelistDto.getLittleareaname());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Nyxsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,nodetype);
        dbManager.setInt(6,indexofsettle);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void update(NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Nyxsettlelist SET ");
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
        buffer.append("Phone = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Fieldsource = ?, ");
        buffer.append("Fcodemodify = ?, ");
        buffer.append("Warrant = ?, ");
        buffer.append("Taxarea = ?, ");
        buffer.append("Atarea = ?, ");
        buffer.append("Littleareaname = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Nyxsettlelist SET ");
            debugBuffer.append("Classcode = '" + nyxsettlelistDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + nyxsettlelistDto.getRiskcode() + "', ");
            debugBuffer.append("Insurearea = " + nyxsettlelistDto.getInsurearea() + ", ");
            debugBuffer.append("Suminsured = " + nyxsettlelistDto.getSuminsured() + ", ");
            debugBuffer.append("Zhibuka = '" + nyxsettlelistDto.getZhibuka() + "', ");
            debugBuffer.append("Fname = '" + nyxsettlelistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + nyxsettlelistDto.getFidcard() + "', ");
            debugBuffer.append("Fareacode = '" + nyxsettlelistDto.getFareacode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + nyxsettlelistDto.getInusrelistcode() + "', ");
            debugBuffer.append("Growingseason = " + nyxsettlelistDto.getGrowingseason() + ", ");
            debugBuffer.append("Lossrate = " + nyxsettlelistDto.getLossrate() + ", ");
            debugBuffer.append("Settlearea = " + nyxsettlelistDto.getSettlearea() + ", ");
            debugBuffer.append("Settlesum = " + nyxsettlelistDto.getSettlesum() + ", ");
            debugBuffer.append("Opcode = '" + nyxsettlelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + nyxsettlelistDto.getOptime() + "', ");
            debugBuffer.append("Remark = '" + nyxsettlelistDto.getRemark() + "', ");
            debugBuffer.append("Validity = '" + nyxsettlelistDto.getValidity() + "', ");
            debugBuffer.append("Settledate = '" + nyxsettlelistDto.getSettledate() + "', ");
            debugBuffer.append("Claimrate = " + nyxsettlelistDto.getClaimrate() + ", ");
            debugBuffer.append("Phone = '" + nyxsettlelistDto.getPhone() + "', ");
            debugBuffer.append("Bank = '" + nyxsettlelistDto.getBank() + "', ");
            debugBuffer.append("Fieldsource = '" + nyxsettlelistDto.getFieldsource() + "', ");
            debugBuffer.append("Fcodemodify = '" + nyxsettlelistDto.getFcodemodify() + "', ");
            debugBuffer.append("Warrant = '" + nyxsettlelistDto.getWarrant() + "', ");
            debugBuffer.append("Taxarea = " + nyxsettlelistDto.getTaxarea() + ", ");
            debugBuffer.append("Atarea = '" + nyxsettlelistDto.getAtarea() + "', ");
            debugBuffer.append("Littleareaname = '" + nyxsettlelistDto.getLittleareaname() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(nyxsettlelistDto.getSettlelistcode()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(nyxsettlelistDto.getFcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(nyxsettlelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(nyxsettlelistDto.getItemcode()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nyxsettlelistDto.getNodetype()).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(nyxsettlelistDto.getIndexofsettle()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,nyxsettlelistDto.getClasscode());
        dbManager.setString(2,nyxsettlelistDto.getRiskcode());
        dbManager.setDouble(3,nyxsettlelistDto.getInsurearea());
        dbManager.setDouble(4,nyxsettlelistDto.getSuminsured());
        dbManager.setString(5,nyxsettlelistDto.getZhibuka());
        dbManager.setString(6,nyxsettlelistDto.getFname());
        dbManager.setString(7,nyxsettlelistDto.getFidcard());
        dbManager.setString(8,nyxsettlelistDto.getFareacode());
        dbManager.setString(9,nyxsettlelistDto.getInusrelistcode());
        dbManager.setDouble(10,nyxsettlelistDto.getGrowingseason());
        dbManager.setDouble(11,nyxsettlelistDto.getLossrate());
        dbManager.setDouble(12,nyxsettlelistDto.getSettlearea());
        dbManager.setDouble(13,nyxsettlelistDto.getSettlesum());
        dbManager.setString(14,nyxsettlelistDto.getOpcode());
        dbManager.setDateTime(15,nyxsettlelistDto.getOptime());
        dbManager.setString(16,nyxsettlelistDto.getRemark());
        dbManager.setString(17,nyxsettlelistDto.getValidity());
        dbManager.setDateTime(18,nyxsettlelistDto.getSettledate());
        dbManager.setDouble(19,nyxsettlelistDto.getClaimrate());
        dbManager.setString(20,nyxsettlelistDto.getPhone());
        dbManager.setString(21,nyxsettlelistDto.getBank());
        dbManager.setString(22,nyxsettlelistDto.getFieldsource());
        dbManager.setString(23,nyxsettlelistDto.getFcodemodify());
        dbManager.setString(24,nyxsettlelistDto.getWarrant());
        dbManager.setDouble(25,nyxsettlelistDto.getTaxarea());
        dbManager.setString(26,nyxsettlelistDto.getAtarea());
        dbManager.setString(27,nyxsettlelistDto.getLittleareaname());
        //���������ֶ�;
        dbManager.setString(28,nyxsettlelistDto.getSettlelistcode());
        dbManager.setString(29,nyxsettlelistDto.getFcode());
        dbManager.setString(30,nyxsettlelistDto.getKindcode());
        dbManager.setString(31,nyxsettlelistDto.getItemcode());
        dbManager.setString(32,nyxsettlelistDto.getNodetype());
        dbManager.setInt(33,nyxsettlelistDto.getIndexofsettle());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return NyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Fcodemodify,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname ");
        buffer.append("FROM Nyxsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Itemcode=").append("'").append(itemcode).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Indexofsettle=").append("").append(indexofsettle).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Itemcode = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Indexofsettle = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,fcode);
        dbManager.setString(3,kindcode);
        dbManager.setString(4,itemcode);
        dbManager.setString(5,nodetype);
        dbManager.setInt(6,indexofsettle);
        ResultSet resultSet = dbManager.executePreparedQuery();
        NyxsettlelistDto nyxsettlelistDto = null;
        if(resultSet.next()){
            nyxsettlelistDto = new NyxsettlelistDto();
            nyxsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,1));
            nyxsettlelistDto.setFcode(dbManager.getString(resultSet,2));
            nyxsettlelistDto.setKindcode(dbManager.getString(resultSet,3));
            nyxsettlelistDto.setItemcode(dbManager.getString(resultSet,4));
            nyxsettlelistDto.setClasscode(dbManager.getString(resultSet,5));
            nyxsettlelistDto.setRiskcode(dbManager.getString(resultSet,6));
            nyxsettlelistDto.setInsurearea(dbManager.getDouble(resultSet,7));
            nyxsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,8));
            nyxsettlelistDto.setZhibuka(dbManager.getString(resultSet,9));
            nyxsettlelistDto.setFname(dbManager.getString(resultSet,10));
            nyxsettlelistDto.setFidcard(dbManager.getString(resultSet,11));
            nyxsettlelistDto.setFareacode(dbManager.getString(resultSet,12));
            nyxsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,13));
            nyxsettlelistDto.setGrowingseason(dbManager.getDouble(resultSet,14));
            nyxsettlelistDto.setLossrate(dbManager.getDouble(resultSet,15));
            nyxsettlelistDto.setSettlearea(dbManager.getDouble(resultSet,16));
            nyxsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,17));
            nyxsettlelistDto.setOpcode(dbManager.getString(resultSet,18));
            nyxsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,19));
            nyxsettlelistDto.setRemark(dbManager.getString(resultSet,20));
            nyxsettlelistDto.setValidity(dbManager.getString(resultSet,21));
            nyxsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,22));
            nyxsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,23));
            nyxsettlelistDto.setNodetype(dbManager.getString(resultSet,24));
            nyxsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,25));
            nyxsettlelistDto.setPhone(dbManager.getString(resultSet,26));
            nyxsettlelistDto.setBank(dbManager.getString(resultSet,27));
            nyxsettlelistDto.setFieldsource(dbManager.getString(resultSet,28));
            nyxsettlelistDto.setFcodemodify(dbManager.getString(resultSet,29));
            nyxsettlelistDto.setWarrant(dbManager.getString(resultSet,30));
            nyxsettlelistDto.setTaxarea(dbManager.getDouble(resultSet,31));
            nyxsettlelistDto.setAtarea(dbManager.getString(resultSet,32));
            nyxsettlelistDto.setLittleareaname(dbManager.getString(resultSet,33));
        }
        resultSet.close();
        return nyxsettlelistDto;
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
        buffer.append("Indexofsettle,");
        buffer.append("Phone,");
        buffer.append("Bank,");
        buffer.append("Fieldsource,");
        buffer.append("Fcodemodify,");
        buffer.append("Warrant,");
        buffer.append("Taxarea,");
        buffer.append("Atarea,");
        buffer.append("Littleareaname ");
        buffer.append("FROM Nyxsettlelist WHERE ");
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
        NyxsettlelistDto nyxsettlelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            nyxsettlelistDto = new NyxsettlelistDto();
            nyxsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            nyxsettlelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            nyxsettlelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            nyxsettlelistDto.setItemcode(dbManager.getString(resultSet,"Itemcode"));
            nyxsettlelistDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            nyxsettlelistDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            nyxsettlelistDto.setInsurearea(dbManager.getDouble(resultSet,"Insurearea"));
            nyxsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,"Suminsured"));
            nyxsettlelistDto.setZhibuka(dbManager.getString(resultSet,"Zhibuka"));
            nyxsettlelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            nyxsettlelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            nyxsettlelistDto.setFareacode(dbManager.getString(resultSet,"Fareacode"));
            nyxsettlelistDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            nyxsettlelistDto.setGrowingseason(dbManager.getDouble(resultSet,"Growingseason"));
            nyxsettlelistDto.setLossrate(dbManager.getDouble(resultSet,"Lossrate"));
            nyxsettlelistDto.setSettlearea(dbManager.getDouble(resultSet,"Settlearea"));
            nyxsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,"Settlesum"));
            nyxsettlelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            nyxsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Optime"));
            nyxsettlelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            nyxsettlelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            nyxsettlelistDto.setSettledate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Settledate"));
            nyxsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            nyxsettlelistDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            nyxsettlelistDto.setIndexofsettle(dbManager.getInt(resultSet,"Indexofsettle"));
            nyxsettlelistDto.setPhone(dbManager.getString(resultSet,"Phone"));
            nyxsettlelistDto.setBank(dbManager.getString(resultSet,"Bank"));
            nyxsettlelistDto.setFieldsource(dbManager.getString(resultSet,"Fieldsource"));
            nyxsettlelistDto.setFcodemodify(dbManager.getString(resultSet,"Fcodemodify"));
            nyxsettlelistDto.setWarrant(dbManager.getString(resultSet,"Warrant"));
            nyxsettlelistDto.setTaxarea(dbManager.getDouble(resultSet,"Taxarea"));
            nyxsettlelistDto.setAtarea(dbManager.getString(resultSet,"Atarea"));
            nyxsettlelistDto.setLittleareaname(dbManager.getString(resultSet,"Littleareaname"));
            collection.add(nyxsettlelistDto);
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
        buffer.append("DELETE FROM Nyxsettlelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Nyxsettlelist WHERE ");
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
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)throws Exception{
    	try {
			//ɾ����ǰ�������е������嵥
			String deleteSql = " SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeTo+"'";
			deleteByConditions(deleteSql);
			//ת�������嵥
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("insert into nyxSETTLELIST "+
					"(SETTLELISTCODE, INDEXOFSETTLE, FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
					"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+ 
					"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
					"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE,WARRANT,TAXAREA,ATAREA,LITTLEAREANAME)");
			stringBuffer.append("select SETTLELISTCODE, INDEXOFSETTLE,FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
			  		"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+
			  		"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
			  		"CLAIMRATE, '"+nodeTypeTo+"', PHONE, BANK, FIELDSOURCE,WARRANT,TAXAREA,ATAREA,LITTLEAREANAME  "+ 
			  		"from nyxSETTLELIST where ");
			stringBuffer.append(" SETTLELISTCODE ='"+settleListCode+"' and NODETYPE = '"+nodeTypeFrom+"'");
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
	        buffer.append("SELECT sum("+fieldName+") FROM NYXSettleList WHERE ");
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
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("sum(SETTLESUM) ");
        buffer.append("FROM nyxSETTLELIST WHERE ");
        buffer.append("SettleListCode = '"+settleListCode+"' And fIdCard = '"+fIdCard+"' And nodeType = '"+nodeType+"'");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //���巵�ؽ������
        double result = 0.0;
        NyxsettlelistDto planting31SettleListDto = null;
        while(resultSet.next()){
            result = dbManager.getDouble(resultSet,"sum(SETTLESUM)");
        }
        resultSet.close();
        return result;
    }
    
    /**
     * �����ݴ���ʱ�� PLANTING31SETTLELISTTEMP ������ʽ�� PLANTING31SETTLELIST
     * @param settleListCode ��ʽ���е������嵥��
     * @param indexOfSettle ��ʽ���е����
     * @param whereCondition ��ʱ���ѯ��������������Щ���ݲ�����ʽ��
     * @throws Exception
     */
    public void evaluate(String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("insert into nyxSETTLELIST "+
    					"(SETTLELISTCODE, INDEXOFSETTLE, FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
    					"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+ 
    					"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    					"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE,WARRANT,TAXAREA,ATAREA,LITTLEAREANAME)");
    	stringBuffer.append("select '"+ settleListCode +"', '"+indexOfSettle+"',FCODE, KINDCODE, CLASSCODE, RISKCODE, ITEMCODE, INSUREAREA, "+ 
    			  		"SUMINSURED, ZHIBUKA, FNAME, FIDCARD, FAREACODE, INUSRELISTCODE, GROWINGSEASON, "+
    			  		"LOSSRATE, SETTLEAREA, SETTLESUM, OPCODE, OPTIME, REMARK, VALIDITY, SETTLEDATE, "+ 
    			  		"CLAIMRATE, NODETYPE, PHONE, BANK, FIELDSOURCE,WARRANT,TAXAREA,ATAREA,LITTLEAREANAME "+ 
    			  		"from nyxSETTLELISTTEMP where ");
    	stringBuffer.append(whereCondition);
    	if(logger.isDebugEnabled()){
            logger.debug(stringBuffer.toString());
        }
    	dbManager.prepareStatement(stringBuffer.toString());
    	dbManager.executePreparedUpdate();
    }
    
    public int getMaxIndex(String conditions)
    throws Exception{
	int max = 0;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT max(INDEXOFSETTLE) FROM nyxSettleList WHERE ");
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
    
    public Collection getGroupedSumData( String sqlCondition, boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        if(groupByKindCode || groupByItemCode || groupByLossRate){
        	boolean moreThanOneGroup = false;
	        buffer.append("SELECT ");
	        if(groupByKindCode)
	        	buffer.append("KINDCODE, ");
	        if(groupByItemCode)
	        	buffer.append("ITEMCODE, ");
	        if(groupByLossRate)
	        	buffer.append("LOSSRATE, ");
	        if(groupByClaimRate)
	        	buffer.append("CLAIMRATE, ");
	        buffer.append("sum(SETTLESUM), ");
	        buffer.append("sum(SETTLEAREA), ");
	        buffer.append("sum(INSUREAREA), ");
	        buffer.append("sum(SUMINSURED) ");
	        buffer.append("FROM nyxSETTLELIST WHERE ");
	        buffer.append(sqlCondition);
	        buffer.append(" group by ");
	        
        	if(groupByKindCode){
        		buffer.append(" KINDCODE");
        		moreThanOneGroup = true;
        	}
        	if(groupByItemCode){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" ITEMCODE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByLossRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" LOSSRATE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByClaimRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" CLAIMRATE ");
        		moreThanOneGroup = true;
        	}
	        buffer.append(" order by ");
	        
        	if(groupByKindCode){
        		buffer.append(" KINDCODE");
        		moreThanOneGroup = true;
        	}
        	if(groupByItemCode){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" ITEMCODE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByLossRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" LOSSRATE ");
        		moreThanOneGroup = true;
        	}
        	if(groupByClaimRate){
        		if(moreThanOneGroup)
        			buffer.append(", ");
        		buffer.append(" CLAIMRATE ");
        		moreThanOneGroup = true;
        	}
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //���巵�ؽ������
        Collection collection = new ArrayList();
        NyxsettlelistDto nyxsettlelistDto = null;
        //Planting31SettleListDto planting31SettleListDto = null;
        while(resultSet.next()){

        	nyxsettlelistDto = new NyxsettlelistDto();
	        if(groupByKindCode)
	        	nyxsettlelistDto.setKindcode(dbManager.getString(resultSet,"KindCode"));
	        if(groupByItemCode)
	        	nyxsettlelistDto.setItemcode(dbManager.getString(resultSet,"ItemCode"));
	        if(groupByLossRate)
	        	nyxsettlelistDto.setLossrate(dbManager.getDouble(resultSet,"LossRate"));
	        if(groupByClaimRate)
	        	nyxsettlelistDto.setClaimrate(dbManager.getDouble(resultSet,"ClaimRate"));
	        nyxsettlelistDto.setSettlesum(dbManager.getDouble(resultSet,"sum(SETTLESUM)"));//����������ʱ���������
	        nyxsettlelistDto.setSettlearea(dbManager.getDouble(resultSet,"sum(SETTLEAREA)"));//��������������ʱ������������
	        nyxsettlelistDto.setInsurearea(dbManager.getDouble(resultSet,"sum(INSUREAREA)"));//���������������ʱ���ڱ��������
	        nyxsettlelistDto.setSuminsured(dbManager.getDouble(resultSet,"sum(SUMINSURED)"));//�����������ʱ���ڱ�����
            collection.add(nyxsettlelistDto);
        }
        resultSet.close();
        return collection;
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
        buffer.append("sum(SETTLEAREA), ");
        buffer.append("sum(INSUREAREA), ");
        buffer.append("sum(SUMINSURED) ");
        buffer.append("FROM nyxSETTLELIST WHERE ");
        buffer.append(sqlCondition);
        buffer.append(" group by KINDCODE, ITEMCODE, LOSSRATE, fidcard");
        buffer.append(" order by KINDCODE, ITEMCODE, LOSSRATE, fidcard");
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());

        //���巵�ؽ������
        Collection collection = new ArrayList();
        NyxsettlelistDto planting31SettleListDto = null;
        while(resultSet.next()){

            planting31SettleListDto = new NyxsettlelistDto();
            planting31SettleListDto.setFcode(dbManager.getString(resultSet,"fidcard"));
            planting31SettleListDto.setFidcard(dbManager.getString(resultSet,"fidcard"));
            planting31SettleListDto.setKindcode(dbManager.getString(resultSet,"KindCode"));
            planting31SettleListDto.setItemcode(dbManager.getString(resultSet,"ItemCode"));
            planting31SettleListDto.setLossrate(dbManager.getDouble(resultSet,"LossRate"));
            planting31SettleListDto.setSettlesum(dbManager.getDouble(resultSet,"sum(SETTLESUM)"));//����������ʱ���������
            planting31SettleListDto.setSettlearea(dbManager.getDouble(resultSet,"sum(SETTLEAREA)"));//��������������ʱ������������
            planting31SettleListDto.setInsurearea(dbManager.getDouble(resultSet,"sum(INSUREAREA)"));//���������������ʱ���ڱ��������
            planting31SettleListDto.setSuminsured(dbManager.getDouble(resultSet,"sum(SUMINSURED)"));//�����������ʱ���ڱ�����
            collection.add(planting31SettleListDto);
        }
        resultSet.close();
        return collection;
    }
    
}
