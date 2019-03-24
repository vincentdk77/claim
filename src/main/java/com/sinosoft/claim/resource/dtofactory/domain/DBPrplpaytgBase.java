package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplpayDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPAY的数据访问对象基类<br>
 */
public class DBPrplpaytgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplpaytgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplpaytgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void insert(PrplpayDto prplpayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplpaytg (");
        buffer.append("Claimno,");
        //buffer.append("Serialno,");
        buffer.append("Compensateno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Paytype,");
        buffer.append("Receivertype,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Banksite,");
        buffer.append("Accounttype,");
        buffer.append("Receiverfullname,");
        buffer.append("Certiftype,");
        buffer.append("Address,");
        buffer.append("Certifno,");
        buffer.append("Familyphone,");
        buffer.append("Officephone,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Paydate,");
        buffer.append("Paycode,");
        buffer.append("Payflag,");
        buffer.append("paymenttype,");
        buffer.append("bankaccount,");
        buffer.append("node,");
        buffer.append("vflag,");
        buffer.append("comcode,");
        //商业险平台标志字段
        buffer.append("uploadserialno,");
        buffer.append("Serialno,");
        buffer.append("Serialno2,");
        buffer.append("operatorComCode, ");
        buffer.append("coinsCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplpayDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getSerialno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getClasscode()).append("',");
            debugBuffer.append("'").append(prplpayDto.getRiskcode()).append("',");
            debugBuffer.append("'").append(prplpayDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPaytype()).append("',");
            debugBuffer.append("'").append(prplpayDto.getReceivertype()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPayamount()).append(",");
            debugBuffer.append("'").append(prplpayDto.getBanktype()).append("',");
            debugBuffer.append("'").append(prplpayDto.getBank()).append("',");
            debugBuffer.append("'").append(prplpayDto.getBanksite()).append("',");
            debugBuffer.append("'").append(prplpayDto.getAccounttype()).append("',");
            debugBuffer.append("'").append(prplpayDto.getReceiverfullname()).append("',");
            debugBuffer.append("'").append(prplpayDto.getCertiftype()).append("',");
            debugBuffer.append("'").append(prplpayDto.getAddress()).append("',");
            debugBuffer.append("'").append(prplpayDto.getCertifno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getFamilyphone()).append("',");
            debugBuffer.append("'").append(prplpayDto.getOfficephone()).append("',");
            debugBuffer.append("'").append(prplpayDto.getMobilephone()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPayremark()).append("',");
            debugBuffer.append("'").append(prplpayDto.getOperatorcode()).append("',");
            debugBuffer.append("'").append(prplpayDto.getInputdate()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPaydate()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPaycode()).append("',");
            debugBuffer.append("'").append(prplpayDto.getPayflag()).append("',");
          //商业险平台标志字段
            debugBuffer.append("'").append(prplpayDto.getUploadserialno()).append("',");
            debugBuffer.append("'").append(prplpayDto.getSerialNo2()).append("',)");
            debugBuffer.append("'").append(prplpayDto.getOperatorComCode()).append("',");
            debugBuffer.append("'").append(prplpayDto.getCoinsCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        //buffer.append("VALUES(?,PAYMENT.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        System.err.println(buffer.toString());
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplpayDto.getClaimno());
        dbManager.setString(2,prplpayDto.getCompensateno());
        dbManager.setString(3,prplpayDto.getClasscode());
        dbManager.setString(4,prplpayDto.getRiskcode());
        dbManager.setString(5,prplpayDto.getRegistno());
        dbManager.setString(6,prplpayDto.getPolicyno());
        dbManager.setString(7,prplpayDto.getPaytype());
        dbManager.setString(8,prplpayDto.getReceivertype());
        dbManager.setDouble(9,prplpayDto.getPayamount());
        dbManager.setString(10,prplpayDto.getBanktype());
        dbManager.setString(11,prplpayDto.getBank());
        dbManager.setString(12,prplpayDto.getBanksite());
        dbManager.setString(13,prplpayDto.getAccounttype());
        dbManager.setString(14,prplpayDto.getReceiverfullname());
        dbManager.setString(15,prplpayDto.getCertiftype());
        dbManager.setString(16,prplpayDto.getAddress());
        dbManager.setString(17,prplpayDto.getCertifno());
        dbManager.setString(18,prplpayDto.getFamilyphone());
        dbManager.setString(19,prplpayDto.getOfficephone());
        dbManager.setString(20,prplpayDto.getMobilephone());
        dbManager.setString(21,prplpayDto.getPayremark());
        dbManager.setString(22,prplpayDto.getOperatorcode());
        dbManager.setDateTime(23,prplpayDto.getInputdate());
        dbManager.setDateTime(24,prplpayDto.getPaydate());
        dbManager.setString(25,prplpayDto.getPaycode());
        dbManager.setString(26,prplpayDto.getPayflag());
        dbManager.setString(27,prplpayDto.getPaymenttype());
        dbManager.setString(28,prplpayDto.getBankaccount());
        dbManager.setString(29,prplpayDto.getNode());
        dbManager.setString(30,prplpayDto.getVFlag());
        dbManager.setString(31,prplpayDto.getComCode());
      //商业险平台标志字段
        dbManager.setString(32,prplpayDto.getUploadserialno());
        //新增联合主键
        dbManager.setString(33,prplpayDto.getSerialno());
        dbManager.setString(34,prplpayDto.getSerialNo2());
        dbManager.setString(35,prplpayDto.getOperatorComCode());
        dbManager.setString(36,prplpayDto.getCoinsCode());
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
        buffer.append("INSERT INTO Prplpaytg (");
        buffer.append("Claimno,");
        //buffer.append("Serialno,");
        buffer.append("Compensateno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Paytype,");
        buffer.append("Receivertype,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Banksite,");
        buffer.append("Accounttype,");
        buffer.append("Receiverfullname,");
        buffer.append("Certiftype,");
        buffer.append("Address,");
        buffer.append("Certifno,");
        buffer.append("Familyphone,");
        buffer.append("Officephone,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Paydate,");
        buffer.append("Paycode,");
        buffer.append("Payflag ,");
        buffer.append("paymenttype,");
        buffer.append("bankaccount,");
        buffer.append("node,");
        buffer.append("vflag,");
        buffer.append("comcode,");
        //商业险平台标志字段
        buffer.append("uploadserialno,");
        buffer.append("Serialno,");
        buffer.append("Serialno2,");
        buffer.append("operatorComCode, ");
        buffer.append("coinsCode ");
        buffer.append(") ");
        //buffer.append("VALUES(?,PAYMENT.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,?,?,?,?,?,?)");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }System.err.println(buffer.toString());
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplpayDto prplpayDto = (PrplpayDto)i.next();
            dbManager.setString(1,prplpayDto.getClaimno());
            dbManager.setString(2,prplpayDto.getCompensateno());
            dbManager.setString(3,prplpayDto.getClasscode());
            dbManager.setString(4,prplpayDto.getRiskcode());
            dbManager.setString(5,prplpayDto.getRegistno());
            dbManager.setString(6,prplpayDto.getPolicyno());
            dbManager.setString(7,prplpayDto.getPaytype());
            dbManager.setString(8,prplpayDto.getReceivertype());
            dbManager.setDouble(9,prplpayDto.getPayamount());
            dbManager.setString(10,prplpayDto.getBanktype());
            dbManager.setString(11,prplpayDto.getBank());
            dbManager.setString(12,prplpayDto.getBanksite());
            dbManager.setString(13,prplpayDto.getAccounttype());
            dbManager.setString(14,prplpayDto.getReceiverfullname());
            dbManager.setString(15,prplpayDto.getCertiftype());
            dbManager.setString(16,prplpayDto.getAddress());
            dbManager.setString(17,prplpayDto.getCertifno());
            dbManager.setString(18,prplpayDto.getFamilyphone());
            dbManager.setString(19,prplpayDto.getOfficephone());
            dbManager.setString(20,prplpayDto.getMobilephone());
            dbManager.setString(21,prplpayDto.getPayremark());
            dbManager.setString(22,prplpayDto.getOperatorcode());
            dbManager.setDateTime(23,prplpayDto.getInputdate());
            dbManager.setDateTime(24,prplpayDto.getPaydate());
            dbManager.setString(25,prplpayDto.getPaycode());
            dbManager.setString(26,prplpayDto.getPayflag());
            dbManager.setString(27,prplpayDto.getPaymenttype());
            dbManager.setString(28,prplpayDto.getBankaccount());
            dbManager.setString(29,prplpayDto.getNode());
            dbManager.setString(30,prplpayDto.getVFlag());
            dbManager.setString(31,prplpayDto.getComCode());
          //商业险平台标志字段
            dbManager.setString(32,prplpayDto.getUploadserialno());
            //新增联合主键
            dbManager.setString(33,prplpayDto.getSerialno());
            dbManager.setString(34,prplpayDto.getSerialNo2());
            dbManager.setString(35,prplpayDto.getOperatorComCode());
            dbManager.setString(36,prplpayDto.getCoinsCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }
    /**
     * 按主键删除一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(String serialno,String compensateno,String serialno2)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplpaytg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("' AND ");
            debugBuffer.append("Compensateno=").append("'").append(compensateno).append("' AND ");
            debugBuffer.append("Serialno2=").append("'").append(serialno2).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Serialno = ? And ");
        buffer.append("Compensateno = ? And ");
        buffer.append("Serialno2 = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,serialno);
        dbManager.setString(2,compensateno);
        dbManager.setString(3,serialno2);
        dbManager.executePreparedUpdate();
    }
    /**
     * 按主键删除一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(String serialno,String compensateno)
//            throws Exception{
//        StringBuffer buffer = new StringBuffer(100);
//        buffer.append("DELETE FROM Prplpaytg ");
//        if(logger.isDebugEnabled()){
//            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
//            debugBuffer.append(buffer.toString());
//            debugBuffer.append("WHERE ");
//            debugBuffer.append("Serialno=").append("'").append(serialno).append("' AND ");
//            debugBuffer.append("Compensateno=").append("'").append(compensateno).append("'");
//            logger.debug(debugBuffer.toString());
//        }
//
//        buffer.append("WHERE ");
//        buffer.append("Serialno = ? And ");
//        buffer.append("Compensateno = ?");
//
//        dbManager.prepareStatement(buffer.toString());
//        //设置条件字段;
//        dbManager.setString(1,serialno);
//        dbManager.setString(2,compensateno);
//        dbManager.executePreparedUpdate();
//    }
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplpayDto prplpayDto
     * @throws Exception
     */
    public void update(PrplpayDto prplpayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplpaytg SET ");
        buffer.append("Claimno = ?, ");
        buffer.append("Classcode = ?, ");
        buffer.append("Riskcode = ?, ");
        buffer.append("Registno = ?, ");
        buffer.append("Policyno = ?, ");
        buffer.append("Paytype = ?, ");
        buffer.append("Receivertype = ?, ");
        buffer.append("Payamount = ?, ");
        buffer.append("Banktype = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Banksite = ?, ");
        buffer.append("Accounttype = ?, ");
        buffer.append("Receiverfullname = ?, ");
        buffer.append("Certiftype = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("Certifno = ?, ");
        buffer.append("Familyphone = ?, ");
        buffer.append("Officephone = ?, ");
        buffer.append("Mobilephone = ?, ");
        buffer.append("Payremark = ?, ");
        buffer.append("Operatorcode = ?, ");
        buffer.append("Inputdate = ?, ");
        buffer.append("Paydate = ?, ");
        buffer.append("Paycode = ?, ");
        buffer.append("Payflag = ?,");
        buffer.append("paymenttype=?,");
        buffer.append("bankaccount =?,");
        buffer.append("node =?,");
        buffer.append("vflag =?,");
        buffer.append("comcode =?,");
        //商业险平台标志字段
        buffer.append("uploadserialno=?, ");
        buffer.append("operatorComCode=?, ");
        buffer.append("coinsCode=? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplpaytg SET ");
            debugBuffer.append("Claimno = '" + prplpayDto.getClaimno() + "', ");
            debugBuffer.append("Classcode = '" + prplpayDto.getClasscode() + "', ");
            debugBuffer.append("Riskcode = '" + prplpayDto.getRiskcode() + "', ");
            debugBuffer.append("Registno = '" + prplpayDto.getRegistno() + "', ");
            debugBuffer.append("Policyno = '" + prplpayDto.getPolicyno() + "', ");
            debugBuffer.append("Paytype = '" + prplpayDto.getPaytype() + "', ");
            debugBuffer.append("Receivertype = '" + prplpayDto.getReceivertype() + "', ");
            debugBuffer.append("Payamount = " + prplpayDto.getPayamount() + ", ");
            debugBuffer.append("Banktype = '" + prplpayDto.getBanktype() + "', ");
            debugBuffer.append("Bank = '" + prplpayDto.getBank() + "', ");
            debugBuffer.append("Banksite = '" + prplpayDto.getBanksite() + "', ");
            debugBuffer.append("Accounttype = '" + prplpayDto.getAccounttype() + "', ");
            debugBuffer.append("Receiverfullname = '" + prplpayDto.getReceiverfullname() + "', ");
            debugBuffer.append("Certiftype = '" + prplpayDto.getCertiftype() + "', ");
            debugBuffer.append("Address = '" + prplpayDto.getAddress() + "', ");
            debugBuffer.append("Certifno = '" + prplpayDto.getCertifno() + "', ");
            debugBuffer.append("Familyphone = '" + prplpayDto.getFamilyphone() + "', ");
            debugBuffer.append("Officephone = '" + prplpayDto.getOfficephone() + "', ");
            debugBuffer.append("Mobilephone = '" + prplpayDto.getMobilephone() + "', ");
            debugBuffer.append("Payremark = '" + prplpayDto.getPayremark() + "', ");
            debugBuffer.append("Operatorcode = '" + prplpayDto.getOperatorcode() + "', ");
            debugBuffer.append("Inputdate = '" + prplpayDto.getInputdate() + "', ");
            debugBuffer.append("Paydate = '" + prplpayDto.getPaydate() + "', ");
            debugBuffer.append("Paycode = '" + prplpayDto.getPaycode() + "', ");
            debugBuffer.append("Payflag = '" + prplpayDto.getPayflag() + "',");
            debugBuffer.append("paymenttype = '" + prplpayDto.getPaymenttype() + "',");
            debugBuffer.append("bankaccount = '" + prplpayDto.getBankaccount() + "',");
            debugBuffer.append("node = '" + prplpayDto.getNode() + "',");
            debugBuffer.append("uploadserialno = '" + prplpayDto.getUploadserialno() + "', ");
            debugBuffer.append("operatorComCode = '" + prplpayDto.getOperatorComCode() + "', ");
            debugBuffer.append("coinsCode = '" + prplpayDto.getCoinsCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Serialno=").append("'").append(prplpayDto.getSerialno()).append("' AND ");
            debugBuffer.append("Compensateno=").append("'").append(prplpayDto.getCompensateno()).append("'");
            logger.debug(debugBuffer.toString());
        }

//        buffer.append("WHERE ");
//        buffer.append("Serialno = ? And ");
//        buffer.append("Compensateno = ?");
        buffer.append("WHERE ");
        buffer.append("Serialno = ? And ");
        buffer.append("Compensateno = ? And ");
        buffer.append("Serialno2 = ?");
        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplpayDto.getClaimno());
        dbManager.setString(2,prplpayDto.getClasscode());
        dbManager.setString(3,prplpayDto.getRiskcode());
        dbManager.setString(4,prplpayDto.getRegistno());
        dbManager.setString(5,prplpayDto.getPolicyno());
        dbManager.setString(6,prplpayDto.getPaytype());
        dbManager.setString(7,prplpayDto.getReceivertype());
        dbManager.setDouble(8,prplpayDto.getPayamount());
        dbManager.setString(9,prplpayDto.getBanktype());
        dbManager.setString(10,prplpayDto.getBank());
        dbManager.setString(11,prplpayDto.getBanksite());
        dbManager.setString(12,prplpayDto.getAccounttype());
        dbManager.setString(13,prplpayDto.getReceiverfullname());
        dbManager.setString(14,prplpayDto.getCertiftype());
        dbManager.setString(15,prplpayDto.getAddress());
        dbManager.setString(16,prplpayDto.getCertifno());
        dbManager.setString(17,prplpayDto.getFamilyphone());
        dbManager.setString(18,prplpayDto.getOfficephone());
        dbManager.setString(19,prplpayDto.getMobilephone());
        dbManager.setString(20,prplpayDto.getPayremark());
        dbManager.setString(21,prplpayDto.getOperatorcode());
        dbManager.setDateTime(22,prplpayDto.getInputdate());
        dbManager.setDateTime(23,prplpayDto.getPaydate());
        dbManager.setString(24,prplpayDto.getPaycode());
        dbManager.setString(25,prplpayDto.getPayflag());
        dbManager.setString(26,prplpayDto.getPaymenttype());
        dbManager.setString(27,prplpayDto.getBankaccount());
        dbManager.setString(28,prplpayDto.getNode());
        dbManager.setString(29,prplpayDto.getVFlag());
        dbManager.setString(30,prplpayDto.getComCode());
      //商业险平台标志字段
        dbManager.setString(31,prplpayDto.getUploadserialno());
        dbManager.setString(32,prplpayDto.getOperatorComCode());
        dbManager.setString(33,prplpayDto.getCoinsCode());
        //设置条件字段;
//        dbManager.setString(32,prplpayDto.getSerialno());
//        dbManager.setString(33,prplpayDto.getCompensateno());
      //设置条件字段;
        dbManager.setString(34,prplpayDto.getSerialno());
        dbManager.setString(35,prplpayDto.getCompensateno());
        dbManager.setString(36,prplpayDto.getSerialNo2());
        dbManager.executePreparedUpdate();

    }
   

    /**
     * 按主键查找一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return PrplpayDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(String serialno,String compensateno)
//            throws Exception{
//        StringBuffer buffer = new StringBuffer(200);
//        //拼SQL语句
//        buffer.append("SELECT ");
//        buffer.append("Claimno,");
//        buffer.append("Serialno,");
//        buffer.append("Compensateno,");
//        buffer.append("Classcode,");
//        buffer.append("Riskcode,");
//        buffer.append("Registno,");
//        buffer.append("Policyno,");
//        buffer.append("Paytype,");
//        buffer.append("Receivertype,");
//        buffer.append("Payamount,");
//        buffer.append("Banktype,");
//        buffer.append("Bank,");
//        buffer.append("Banksite,");
//        buffer.append("Accounttype,");
//        buffer.append("Receiverfullname,");
//        buffer.append("Certiftype,");
//        buffer.append("Address,");
//        buffer.append("Certifno,");
//        buffer.append("Familyphone,");
//        buffer.append("Officephone,");
//        buffer.append("Mobilephone,");
//        buffer.append("Payremark,");
//        buffer.append("Operatorcode,");
//        buffer.append("Inputdate,");
//        buffer.append("Paydate,");
//        buffer.append("Paycode,");
//        buffer.append("Payflag ,");
//        buffer.append("paymenttype,");
//        buffer.append("bankaccount,");
//        buffer.append("node,");
//        buffer.append("vflag,");
//        buffer.append("comcode,");
//      //商业险平台标志字段
//        buffer.append("uploadserialno ");
//        buffer.append("FROM Prplpaytg ");
//        if(logger.isDebugEnabled()){
//            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
//            debugBuffer.append(buffer.toString());
//            debugBuffer.append("WHERE ");
//            debugBuffer.append("Serialno=").append("'").append(serialno).append("' AND ");
//            debugBuffer.append("Compensateno=").append("'").append(compensateno).append("'");
//            logger.debug(debugBuffer.toString());
//        }
//
//        buffer.append("WHERE ");
//        buffer.append("Serialno = ? And ");
//        buffer.append("Compensateno = ?");
//
//        dbManager.prepareStatement(buffer.toString());
//        //设置条件字段;
//        dbManager.setString(1,serialno);
//        dbManager.setString(2,compensateno);
//        ResultSet resultSet = dbManager.executePreparedQuery();
//        PrplpayDto prplpayDto = null;
//        if(resultSet.next()){
//            prplpayDto = new PrplpayDto();
//            prplpayDto.setClaimno(dbManager.getString(resultSet,1));
//            prplpayDto.setSerialno(dbManager.getString(resultSet,2));
//            prplpayDto.setCompensateno(dbManager.getString(resultSet,3));
//            prplpayDto.setClasscode(dbManager.getString(resultSet,4));
//            prplpayDto.setRiskcode(dbManager.getString(resultSet,5));
//            prplpayDto.setRegistno(dbManager.getString(resultSet,6));
//            prplpayDto.setPolicyno(dbManager.getString(resultSet,7));
//            prplpayDto.setPaytype(dbManager.getString(resultSet,8));
//            prplpayDto.setReceivertype(dbManager.getString(resultSet,9));
//            prplpayDto.setPayamount(dbManager.getDouble(resultSet,10));
//            prplpayDto.setBanktype(dbManager.getString(resultSet,11));
//            prplpayDto.setBank(dbManager.getString(resultSet,12));
//            prplpayDto.setBanksite(dbManager.getString(resultSet,13));
//            prplpayDto.setAccounttype(dbManager.getString(resultSet,14));
//            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,15));
//            prplpayDto.setCertiftype(dbManager.getString(resultSet,16));
//            prplpayDto.setAddress(dbManager.getString(resultSet,17));
//            prplpayDto.setCertifno(dbManager.getString(resultSet,18));
//            prplpayDto.setFamilyphone(dbManager.getString(resultSet,19));
//            prplpayDto.setOfficephone(dbManager.getString(resultSet,20));
//            prplpayDto.setMobilephone(dbManager.getString(resultSet,21));
//            prplpayDto.setPayremark(dbManager.getString(resultSet,22));
//            prplpayDto.setOperatorcode(dbManager.getString(resultSet,23));
//            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,24));
//            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,25));
//            prplpayDto.setPaycode(dbManager.getString(resultSet,26));
//            prplpayDto.setPayflag(dbManager.getString(resultSet,27));
//            prplpayDto.setPaymenttype(dbManager.getString(resultSet,28));
//            prplpayDto.setBankaccount(dbManager.getString(resultSet,29));
//            prplpayDto.setNode(dbManager.getString(resultSet,30));
//            prplpayDto.setVFlag(dbManager.getString(resultSet,31));
//            prplpayDto.setComCode(dbManager.getString(resultSet,32));
//          //商业险平台标志字段
//            prplpayDto.setUploadserialno(dbManager.getString(resultSet,33));
//        }
//        resultSet.close();
//        return prplpayDto;
//    }
    /**
     * 按主键查找一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return PrplpayDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(String serialno,String compensateno,String serialno2)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Claimno,");
        buffer.append("Serialno,");
        buffer.append("Compensateno,");
        buffer.append("Classcode,");
        buffer.append("Riskcode,");
        buffer.append("Registno,");
        buffer.append("Policyno,");
        buffer.append("Paytype,");
        buffer.append("Receivertype,");
        buffer.append("Payamount,");
        buffer.append("Banktype,");
        buffer.append("Bank,");
        buffer.append("Banksite,");
        buffer.append("Accounttype,");
        buffer.append("Receiverfullname,");
        buffer.append("Certiftype,");
        buffer.append("Address,");
        buffer.append("Certifno,");
        buffer.append("Familyphone,");
        buffer.append("Officephone,");
        buffer.append("Mobilephone,");
        buffer.append("Payremark,");
        buffer.append("Operatorcode,");
        buffer.append("Inputdate,");
        buffer.append("Paydate,");
        buffer.append("Paycode,");
        buffer.append("Payflag,");
        buffer.append("Paymenttype,");
        buffer.append("Bankaccount,");
        buffer.append("Node,");
        buffer.append("Uploadserialno,");
        buffer.append("Vflag,");
        buffer.append("Comcode,");
        buffer.append("Serialno2, ");
        buffer.append("operatorComCode, ");
        buffer.append("coinsCode ");
        buffer.append("FROM Prplpaytg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Serialno=").append("'").append(serialno).append("' AND ");
            debugBuffer.append("Compensateno=").append("'").append(compensateno).append("' AND ");
            debugBuffer.append("Serialno2=").append("'").append(serialno2).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Serialno = ? And ");
        buffer.append("Compensateno = ? And ");
        buffer.append("Serialno2 = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,serialno);
        dbManager.setString(2,compensateno);
        dbManager.setString(3,serialno2);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplpayDto prplpayDto = null;
        if(resultSet.next()){
            prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,1));
            prplpayDto.setSerialno(dbManager.getString(resultSet,2));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,3));
            prplpayDto.setClasscode(dbManager.getString(resultSet,4));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,5));
            prplpayDto.setRegistno(dbManager.getString(resultSet,6));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,7));
            prplpayDto.setPaytype(dbManager.getString(resultSet,8));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,9));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,10));
            prplpayDto.setBanktype(dbManager.getString(resultSet,11));
            prplpayDto.setBank(dbManager.getString(resultSet,12));
            prplpayDto.setBanksite(dbManager.getString(resultSet,13));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,14));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,15));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,16));
            prplpayDto.setAddress(dbManager.getString(resultSet,17));
            prplpayDto.setCertifno(dbManager.getString(resultSet,18));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,19));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,20));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,21));
            prplpayDto.setPayremark(dbManager.getString(resultSet,22));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,23));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,25));
            prplpayDto.setPaycode(dbManager.getString(resultSet,26));
            prplpayDto.setPayflag(dbManager.getString(resultSet,27));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,28));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,29));
            prplpayDto.setNode(dbManager.getString(resultSet,30));
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,31));
            prplpayDto.setVFlag(dbManager.getString(resultSet,32));
            prplpayDto.setComCode(dbManager.getString(resultSet,33));
            prplpayDto.setSerialNo2(dbManager.getString(resultSet,34));
            prplpayDto.setOperatorComCode(dbManager.getString(resultSet,35));
            prplpayDto.setCoinsCode(dbManager.getString(resultSet,36));
        }
        resultSet.close();
        return prplpayDto;
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
        buffer.append("p.Claimno Claimno,");
        buffer.append("p.Serialno Serialno,");
        buffer.append("p.Compensateno Compensateno,");
        buffer.append("p.Classcode Classcode,");
        buffer.append("p.Riskcode Riskcode,");
        buffer.append("p.Registno Registno,");
        buffer.append("p.Policyno Policyno,");
        buffer.append("p.Paytype Paytype,");
        buffer.append("p.Receivertype Receivertype,");
        buffer.append("p.Payamount Payamount,");
        buffer.append("p.Banktype Banktype,");
        buffer.append("p.Bank Bank,");
        buffer.append("p.Banksite Banksite,");
        buffer.append("p.Accounttype Accounttype,");
        buffer.append("p.Receiverfullname Receiverfullname,");
        buffer.append("p.Certiftype Certiftype,");
        buffer.append("p.Address Address,");
        buffer.append("p.Certifno Certifno,");
        buffer.append("p.Familyphone Familyphone,");
        buffer.append("p.Officephone Officephone,");
        buffer.append("p.Mobilephone Mobilephone,");
        buffer.append("p.Payremark Payremark,");
        buffer.append("p.Operatorcode Operatorcode,");
        buffer.append("p.Inputdate Inputdate,");
        buffer.append("p.Paydate Paydate,");
        buffer.append("p.Paycode Paycode,");
        buffer.append("p.Payflag Payflag,");
        buffer.append("p.paymenttype paymenttype,");
        buffer.append("p.bankaccount bankaccount,");
        buffer.append("p.node node,");
        buffer.append("p.vflag vflag,");
        buffer.append("p.comcode comcode,");
        //商业险平台标志字段
        buffer.append("p.uploadserialno, ");
        buffer.append("p.operatorComCode, ");
        buffer.append("p.coinsCode ");
        buffer.append("FROM Prplpaytg p left join prplcompensatetg c on p.compensateno=c.compensateno left join prplprepaytg pre on p.compensateno=pre.precompensateno join prplpaymaintg paymain on p.serialno=paymain.paymentNo WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        System.out.println(buffer);
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
        PrplpayDto prplpayDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplpayDto = new PrplpayDto();
            prplpayDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prplpayDto.setSerialno(dbManager.getString(resultSet,"Serialno"));
            prplpayDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplpayDto.setClasscode(dbManager.getString(resultSet,"Classcode"));
            prplpayDto.setRiskcode(dbManager.getString(resultSet,"Riskcode"));
            prplpayDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplpayDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplpayDto.setPaytype(dbManager.getString(resultSet,"Paytype"));
            prplpayDto.setReceivertype(dbManager.getString(resultSet,"Receivertype"));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,"Payamount"));
            prplpayDto.setBanktype(dbManager.getString(resultSet,"Banktype"));
            prplpayDto.setBank(dbManager.getString(resultSet,"Bank"));
            prplpayDto.setBanksite(dbManager.getString(resultSet,"Banksite"));
            prplpayDto.setAccounttype(dbManager.getString(resultSet,"Accounttype"));
            prplpayDto.setReceiverfullname(dbManager.getString(resultSet,"Receiverfullname"));
            prplpayDto.setCertiftype(dbManager.getString(resultSet,"Certiftype"));
            prplpayDto.setAddress(dbManager.getString(resultSet,"Address"));
            prplpayDto.setCertifno(dbManager.getString(resultSet,"Certifno"));
            prplpayDto.setFamilyphone(dbManager.getString(resultSet,"Familyphone"));
            prplpayDto.setOfficephone(dbManager.getString(resultSet,"Officephone"));
            prplpayDto.setMobilephone(dbManager.getString(resultSet,"Mobilephone"));
            prplpayDto.setPayremark(dbManager.getString(resultSet,"Payremark"));
            prplpayDto.setOperatorcode(dbManager.getString(resultSet,"Operatorcode"));
            prplpayDto.setInputdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Inputdate"));
            prplpayDto.setPaydate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"Paydate"));
            prplpayDto.setPaycode(dbManager.getString(resultSet,"Paycode"));
            prplpayDto.setPayflag(dbManager.getString(resultSet,"Payflag"));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,"paymenttype"));
            prplpayDto.setBankaccount(dbManager.getString(resultSet,"bankaccount"));
            prplpayDto.setNode(dbManager.getString(resultSet,"node"));
            prplpayDto.setVFlag(dbManager.getString(resultSet,"vflag"));
            prplpayDto.setComCode(dbManager.getString(resultSet,"comcode"));
            //商业险平台标志字段
            prplpayDto.setUploadserialno(dbManager.getString(resultSet,"uploadserialno"));
            prplpayDto.setOperatorComCode(dbManager.getString(resultSet,"operatorComCode"));
            prplpayDto.setCoinsCode(dbManager.getString(resultSet,"coinsCode"));
            collection.add(prplpayDto);
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
        buffer.append("DELETE FROM Prplpaytg WHERE ");
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
        buffer.append("SELECT count(p.serialno) FROM Prplpaytg p left join prplcompensate c on p.compensateno=c.compensateno left join prplprepay pre on p.compensateno=pre.precompensateno WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        System.out.println(buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /******************************优化修改:start***********************************/
    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditionsByPrepered(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplpaytg WHERE serialno = ? ");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, conditions);
        int count = dbManager.executePreparedUpdate();
        return count;
    }
    /******************************优化修改:end***********************************/
    /**
     * 按条件查询多条数据 相同计算书,收付原因,联共保人金额求和
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection getSumPayamount(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("select p.compensateno,p.paymenttype,p.coinscode,SUM(p.payamount) AS payamount FROM prplpaytg p WHERE ");
        buffer.append(conditions);
        buffer.append(" GROUP BY p.compensateno,p.paymenttype,p.coinscode");
        System.out.println(buffer);
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        //定义返回结果集合
        Collection collection = new ArrayList();
        PrplpayDto prplpayDto = null;
        while(resultSet.next()){
            
            prplpayDto = new PrplpayDto();
            prplpayDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplpayDto.setPayamount(dbManager.getDouble(resultSet,"Payamount"));
            prplpayDto.setPaymenttype(dbManager.getString(resultSet,"paymenttype"));
            prplpayDto.setCoinsCode(dbManager.getString(resultSet,"coinsCode"));
            collection.add(prplpayDto);
        }
        resultSet.close();
        return collection;
    }
}
