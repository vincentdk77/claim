package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付信息主表的数据访问对象基类<br>
 * 创建于 2013-07-03 09:05:28.663<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpaymainBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpaymainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpaymainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void insert(PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpaymain (");
        buffer.append("PaymentNo,");
        buffer.append("PayType,");
        buffer.append("PayAmount,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankSite,");
        buffer.append("AccountType,");
        buffer.append("ReceiverFullName,");
        buffer.append("ReceiverFullCode,");
        buffer.append("CertifType,");
        buffer.append("Address,");
        buffer.append("CertifNo,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("MobilePhone,");
        buffer.append("PayRemark,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("PayDate,");
        buffer.append("PayCode,");
        buffer.append("PayFlag,");
        buffer.append("PaymentType,");
        buffer.append("BankAccount,");
        buffer.append("Node,");
        buffer.append("UpLoadSerialNo,");
        buffer.append("Vflag,");
        buffer.append("ComCode,");
        buffer.append("MergerFlag,");
        buffer.append("PayTotalAmount,");
        buffer.append("UrgentType,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("VerifyFlag,");
        buffer.append("NoticeNo, ");
        buffer.append("provinceCode, ");
        buffer.append("cityCode, ");
        buffer.append("backDate, ");
        buffer.append("backOperatorCode, ");
        buffer.append("backComCode, ");
        buffer.append("thirdPayFlag, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("billFlag, ");
        buffer.append("nobillFlag, ");
        buffer.append("realPayWay, ");
        buffer.append("thirdPayType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpaymainDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayType()).append("',");
            debugBuffer.append("").append(prpLpaymainDto.getPayAmount()).append(",");
            debugBuffer.append("'").append(prpLpaymainDto.getBankType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBankSite()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getReceiverFullName()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getReceiverFullCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getCertifType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getCertifNo()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getFamilyPhone()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getOfficePhone()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayRemark()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayDate()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayFlag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPaymentType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBankAccount()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getNode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getUpLoadSerialNo()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getVflag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getMergerFlag()).append("',");
            debugBuffer.append("").append(prpLpaymainDto.getPayTotalAmount()).append(",");
            debugBuffer.append("'").append(prpLpaymainDto.getUrgentType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getReceiverTypeOther()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getReceiverTypeOtherName()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getQqNumber()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getEmail()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getUnitLink()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPostCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getVerifyFlag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getNoticeNo()).append("')");
            debugBuffer.append("'").append(prpLpaymainDto.getProvinceCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getCityCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBackDate()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBackOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBackComCode()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getThirdPayFlag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayWay()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayReason()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getPayPurpose()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getInterType()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getRouteNum()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getBillFlag()).append("',");
            debugBuffer.append("'").append(prpLpaymainDto.getThirdPayType()).append("')");
            

            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpaymainDto.getPaymentNo());
        dbManager.setString(2,prpLpaymainDto.getPayType());
        dbManager.setDouble(3,prpLpaymainDto.getPayAmount());
        dbManager.setString(4,prpLpaymainDto.getBankType());
        dbManager.setString(5,prpLpaymainDto.getBank());
        dbManager.setString(6,prpLpaymainDto.getBankSite());
        dbManager.setString(7,prpLpaymainDto.getAccountType());
        dbManager.setString(8,prpLpaymainDto.getReceiverFullName());
        dbManager.setString(9,prpLpaymainDto.getReceiverFullCode());
        dbManager.setString(10,prpLpaymainDto.getCertifType());
        dbManager.setString(11,prpLpaymainDto.getAddress());
        dbManager.setString(12,prpLpaymainDto.getCertifNo());
        dbManager.setString(13,prpLpaymainDto.getFamilyPhone());
        dbManager.setString(14,prpLpaymainDto.getOfficePhone());
        dbManager.setString(15,prpLpaymainDto.getMobilePhone());
        dbManager.setString(16,prpLpaymainDto.getPayRemark());
        dbManager.setString(17,prpLpaymainDto.getOperatorCode());
        dbManager.setDateTime(18,prpLpaymainDto.getInputDate());
        dbManager.setDateTime(19,prpLpaymainDto.getPayDate());
        dbManager.setString(20,prpLpaymainDto.getPayCode());
        dbManager.setString(21,prpLpaymainDto.getPayFlag());
        dbManager.setString(22,prpLpaymainDto.getPaymentType());
        dbManager.setString(23,prpLpaymainDto.getBankAccount());
        dbManager.setString(24,prpLpaymainDto.getNode());
        dbManager.setString(25,prpLpaymainDto.getUpLoadSerialNo());
        dbManager.setString(26,prpLpaymainDto.getVflag());
        dbManager.setString(27,prpLpaymainDto.getComCode());
        dbManager.setString(28,prpLpaymainDto.getMergerFlag());
        dbManager.setDouble(29,prpLpaymainDto.getPayTotalAmount());
        dbManager.setString(30,prpLpaymainDto.getUrgentType());
        dbManager.setString(31,prpLpaymainDto.getReceiverTypeOther());
        dbManager.setString(32,prpLpaymainDto.getReceiverTypeOtherName());
        dbManager.setString(33,prpLpaymainDto.getQqNumber());
        dbManager.setString(34,prpLpaymainDto.getEmail());
        dbManager.setString(35,prpLpaymainDto.getUnitLink());
        dbManager.setString(36,prpLpaymainDto.getPostCode());
        dbManager.setString(37,prpLpaymainDto.getVerifyFlag());
        dbManager.setString(38,prpLpaymainDto.getNoticeNo());
        dbManager.setString(39,prpLpaymainDto.getProvinceCode());
        dbManager.setString(40,prpLpaymainDto.getCityCode());
        dbManager.setDateTime(41,prpLpaymainDto.getBackDate());
        dbManager.setString(42,prpLpaymainDto.getBackOperatorCode());
        dbManager.setString(43,prpLpaymainDto.getBackComCode());
        dbManager.setString(44,prpLpaymainDto.getThirdPayFlag());
        dbManager.setString(45,prpLpaymainDto.getPayWay());
        dbManager.setString(46,prpLpaymainDto.getPayReason());
        dbManager.setString(47,prpLpaymainDto.getPayPurpose());
        dbManager.setString(48,prpLpaymainDto.getAccountFlag());
        dbManager.setString(49,prpLpaymainDto.getInterType());
        dbManager.setString(50,prpLpaymainDto.getRouteNum());
        dbManager.setString(51, prpLpaymainDto.getBillFlag());
        dbManager.setString(52, prpLpaymainDto.getNoBillFlag());
        dbManager.setString(53, prpLpaymainDto.getRealPayWay());
        dbManager.setString(54, prpLpaymainDto.getThirdPayType());
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
        buffer.append("INSERT INTO PrpLpaymain (");
        buffer.append("PaymentNo,");
        buffer.append("PayType,");
        buffer.append("PayAmount,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankSite,");
        buffer.append("AccountType,");
        buffer.append("ReceiverFullName,");
        buffer.append("ReceiverFullCode,");
        buffer.append("CertifType,");
        buffer.append("Address,");
        buffer.append("CertifNo,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("MobilePhone,");
        buffer.append("PayRemark,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("PayDate,");
        buffer.append("PayCode,");
        buffer.append("PayFlag,");
        buffer.append("PaymentType,");
        buffer.append("BankAccount,");
        buffer.append("Node,");
        buffer.append("UpLoadSerialNo,");
        buffer.append("Vflag,");
        buffer.append("ComCode,");
        buffer.append("MergerFlag,");
        buffer.append("PayTotalAmount,");
        buffer.append("UrgentType,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("VerifyFlag,");
        buffer.append("NoticeNo, ");
        buffer.append("provinceCode, ");
        buffer.append("cityCode, ");
        buffer.append("backDate, ");
        buffer.append("backOperatorCode, ");
        buffer.append("backComCode, ");
        buffer.append("thirdPayFlag, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("billFlag, ");
        buffer.append("nobillFlag, ");
        buffer.append("realPayWay, ");
        buffer.append("thirdPayType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpaymainDto prpLpaymainDto = (PrpLpaymainDto)i.next();
            dbManager.setString(1,prpLpaymainDto.getPaymentNo());
            dbManager.setString(2,prpLpaymainDto.getPayType());
            dbManager.setDouble(3,prpLpaymainDto.getPayAmount());
            dbManager.setString(4,prpLpaymainDto.getBankType());
            dbManager.setString(5,prpLpaymainDto.getBank());
            dbManager.setString(6,prpLpaymainDto.getBankSite());
            dbManager.setString(7,prpLpaymainDto.getAccountType());
            dbManager.setString(8,prpLpaymainDto.getReceiverFullName());
            dbManager.setString(9,prpLpaymainDto.getReceiverFullCode());
            dbManager.setString(10,prpLpaymainDto.getCertifType());
            dbManager.setString(11,prpLpaymainDto.getAddress());
            dbManager.setString(12,prpLpaymainDto.getCertifNo());
            dbManager.setString(13,prpLpaymainDto.getFamilyPhone());
            dbManager.setString(14,prpLpaymainDto.getOfficePhone());
            dbManager.setString(15,prpLpaymainDto.getMobilePhone());
            dbManager.setString(16,prpLpaymainDto.getPayRemark());
            dbManager.setString(17,prpLpaymainDto.getOperatorCode());
            dbManager.setDateTime(18,prpLpaymainDto.getInputDate());
            dbManager.setDateTime(19,prpLpaymainDto.getPayDate());
            dbManager.setString(20,prpLpaymainDto.getPayCode());
            dbManager.setString(21,prpLpaymainDto.getPayFlag());
            dbManager.setString(22,prpLpaymainDto.getPaymentType());
            dbManager.setString(23,prpLpaymainDto.getBankAccount());
            dbManager.setString(24,prpLpaymainDto.getNode());
            dbManager.setString(25,prpLpaymainDto.getUpLoadSerialNo());
            dbManager.setString(26,prpLpaymainDto.getVflag());
            dbManager.setString(27,prpLpaymainDto.getComCode());
            dbManager.setString(28,prpLpaymainDto.getMergerFlag());
            dbManager.setDouble(29,prpLpaymainDto.getPayTotalAmount());
            dbManager.setString(30,prpLpaymainDto.getUrgentType());
            dbManager.setString(31,prpLpaymainDto.getReceiverTypeOther());
            dbManager.setString(32,prpLpaymainDto.getReceiverTypeOtherName());
            dbManager.setString(33,prpLpaymainDto.getQqNumber());
            dbManager.setString(34,prpLpaymainDto.getEmail());
            dbManager.setString(35,prpLpaymainDto.getUnitLink());
            dbManager.setString(36,prpLpaymainDto.getPostCode());
            dbManager.setString(37,prpLpaymainDto.getVerifyFlag());
            dbManager.setString(38,prpLpaymainDto.getNoticeNo());
            dbManager.setString(39,prpLpaymainDto.getProvinceCode());
            dbManager.setString(40,prpLpaymainDto.getCityCode());
            dbManager.setDateTime(41,prpLpaymainDto.getBackDate());
            dbManager.setString(42,prpLpaymainDto.getBackOperatorCode());
            dbManager.setString(43,prpLpaymainDto.getBackComCode());
            dbManager.setString(44,prpLpaymainDto.getThirdPayFlag());
            dbManager.setString(45, prpLpaymainDto.getPayWay());
            dbManager.setString(46, prpLpaymainDto.getPayReason());
            dbManager.setString(47, prpLpaymainDto.getPayPurpose());
            dbManager.setString(48, prpLpaymainDto.getAccountFlag());
            dbManager.setString(49, prpLpaymainDto.getInterType());
            dbManager.setString(50, prpLpaymainDto.getRouteNum());
            dbManager.setString(51, prpLpaymainDto.getBillFlag());
            dbManager.setString(52, prpLpaymainDto.getNoBillFlag());
            dbManager.setString(53, prpLpaymainDto.getRealPayWay());
            dbManager.setString(54, prpLpaymainDto.getThirdPayType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param paymentNo 支付编号
     * @throws Exception
     */
    public void delete(String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpaymain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,paymentNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void update(PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpaymain SET ");
        buffer.append("PayType = ?, ");
        buffer.append("PayAmount = ?, ");
        buffer.append("BankType = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("BankSite = ?, ");
        buffer.append("AccountType = ?, ");
        buffer.append("ReceiverFullName = ?, ");
        buffer.append("ReceiverFullCode = ?, ");
        buffer.append("CertifType = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("CertifNo = ?, ");
        buffer.append("FamilyPhone = ?, ");
        buffer.append("OfficePhone = ?, ");
        buffer.append("MobilePhone = ?, ");
        buffer.append("PayRemark = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("PayDate = ?, ");
        buffer.append("PayCode = ?, ");
        buffer.append("PayFlag = ?, ");
        buffer.append("PaymentType = ?, ");
        buffer.append("BankAccount = ?, ");
        buffer.append("Node = ?, ");
        buffer.append("UpLoadSerialNo = ?, ");
        buffer.append("Vflag = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("MergerFlag = ?, ");
        buffer.append("PayTotalAmount = ?, ");
        buffer.append("UrgentType = ?, ");
        buffer.append("ReceiverTypeOther = ?, ");
        buffer.append("ReceiverTypeOtherName = ?, ");
        buffer.append("QqNumber = ?, ");
        buffer.append("Email = ?, ");
        buffer.append("UnitLink = ?, ");
        buffer.append("PostCode = ?, ");
        buffer.append("VerifyFlag = ?, ");
        buffer.append("NoticeNo = ?, ");
        buffer.append("provinceCode =  ?, ");
        buffer.append("cityCode = ?, ");
        buffer.append("backDate = ?,");
        buffer.append("backOperatorCode = ?, ");
        buffer.append("backComCode = ?, ");
        buffer.append("thirdPayFlag = ?, ");
        buffer.append("payWay = ?, ");
        buffer.append("payReason = ?,");
        buffer.append("payPurpose = ?, ");
        buffer.append("accountFlag = ?, ");
        buffer.append("interType = ?, ");
        buffer.append("routeNum = ?, ");
        buffer.append("billFlag = ?, ");
        buffer.append("nobillFlag = ?, ");
        buffer.append("realPayWay = ?, ");
        buffer.append("thirdPayType = ? ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpaymain SET ");
            debugBuffer.append("PayType = '" + prpLpaymainDto.getPayType() + "', ");
            debugBuffer.append("PayAmount = " + prpLpaymainDto.getPayAmount() + ", ");
            debugBuffer.append("BankType = '" + prpLpaymainDto.getBankType() + "', ");
            debugBuffer.append("Bank = '" + prpLpaymainDto.getBank() + "', ");
            debugBuffer.append("BankSite = '" + prpLpaymainDto.getBankSite() + "', ");
            debugBuffer.append("AccountType = '" + prpLpaymainDto.getAccountType() + "', ");
            debugBuffer.append("ReceiverFullName = '" + prpLpaymainDto.getReceiverFullName() + "', ");
            debugBuffer.append("ReceiverFullCode = '" + prpLpaymainDto.getReceiverFullCode() + "', ");
            debugBuffer.append("CertifType = '" + prpLpaymainDto.getCertifType() + "', ");
            debugBuffer.append("Address = '" + prpLpaymainDto.getAddress() + "', ");
            debugBuffer.append("CertifNo = '" + prpLpaymainDto.getCertifNo() + "', ");
            debugBuffer.append("FamilyPhone = '" + prpLpaymainDto.getFamilyPhone() + "', ");
            debugBuffer.append("OfficePhone = '" + prpLpaymainDto.getOfficePhone() + "', ");
            debugBuffer.append("MobilePhone = '" + prpLpaymainDto.getMobilePhone() + "', ");
            debugBuffer.append("PayRemark = '" + prpLpaymainDto.getPayRemark() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLpaymainDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpLpaymainDto.getInputDate() + "', ");
            debugBuffer.append("PayDate = '" + prpLpaymainDto.getPayDate() + "', ");
            debugBuffer.append("PayCode = '" + prpLpaymainDto.getPayCode() + "', ");
            debugBuffer.append("PayFlag = '" + prpLpaymainDto.getPayFlag() + "', ");
            debugBuffer.append("PaymentType = '" + prpLpaymainDto.getPaymentType() + "', ");
            debugBuffer.append("BankAccount = '" + prpLpaymainDto.getBankAccount() + "', ");
            debugBuffer.append("Node = '" + prpLpaymainDto.getNode() + "', ");
            debugBuffer.append("UpLoadSerialNo = '" + prpLpaymainDto.getUpLoadSerialNo() + "', ");
            debugBuffer.append("Vflag = '" + prpLpaymainDto.getVflag() + "', ");
            debugBuffer.append("ComCode = '" + prpLpaymainDto.getComCode() + "', ");
            debugBuffer.append("MergerFlag = '" + prpLpaymainDto.getMergerFlag() + "', ");
            debugBuffer.append("PayTotalAmount = " + prpLpaymainDto.getPayTotalAmount() + ", ");
            debugBuffer.append("UrgentType = '" + prpLpaymainDto.getUrgentType() + "', ");
            debugBuffer.append("ReceiverTypeOther = '" + prpLpaymainDto.getReceiverTypeOther() + "', ");
            debugBuffer.append("ReceiverTypeOtherName = '" + prpLpaymainDto.getReceiverTypeOtherName() + "', ");
            debugBuffer.append("QqNumber = '" + prpLpaymainDto.getQqNumber() + "', ");
            debugBuffer.append("Email = '" + prpLpaymainDto.getEmail() + "', ");
            debugBuffer.append("UnitLink = '" + prpLpaymainDto.getUnitLink() + "', ");
            debugBuffer.append("PostCode = '" + prpLpaymainDto.getPostCode() + "', ");
            debugBuffer.append("VerifyFlag = '" + prpLpaymainDto.getVerifyFlag() + "', ");
            debugBuffer.append("NoticeNo = '" + prpLpaymainDto.getNoticeNo() + "', ");
            debugBuffer.append("provinceCode = '" + prpLpaymainDto.getProvinceCode() + "', ");
            debugBuffer.append("cityCode = '" + prpLpaymainDto.getCityCode() + "', ");
            debugBuffer.append("backDate = '" + prpLpaymainDto.getBackDate() + "', ");
            debugBuffer.append("backOperatorCode = '" + prpLpaymainDto.getBackOperatorCode() + "', ");
            debugBuffer.append("backComCode = '" + prpLpaymainDto.getBackComCode() + "', ");
            debugBuffer.append("thirdPayFlag = '" + prpLpaymainDto.getThirdPayFlag() + "', ");
            debugBuffer.append("payWay = '"+prpLpaymainDto.getPayWay()+"', ");
            debugBuffer.append("payReason = '"+prpLpaymainDto.getPayReason()+"', ");
            debugBuffer.append("payPurpose = '"+prpLpaymainDto.getPayPurpose()+"', ");
            debugBuffer.append("accountFlag = '"+prpLpaymainDto.getAccountFlag()+"', ");
            debugBuffer.append("interType = '"+prpLpaymainDto.getInterType()+"', ");
            debugBuffer.append("routeNum = '"+prpLpaymainDto.getRouteNum()+"', ");
            debugBuffer.append("billFlag = '"+prpLpaymainDto.getBillFlag()+"', ");
            debugBuffer.append("thirdPayType = '"+prpLpaymainDto.getThirdPayType()+"' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(prpLpaymainDto.getPaymentNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLpaymainDto.getPayType());
        dbManager.setDouble(2,prpLpaymainDto.getPayAmount());
        dbManager.setString(3,prpLpaymainDto.getBankType());
        dbManager.setString(4,prpLpaymainDto.getBank());
        dbManager.setString(5,prpLpaymainDto.getBankSite());
        dbManager.setString(6,prpLpaymainDto.getAccountType());
        dbManager.setString(7,prpLpaymainDto.getReceiverFullName());
        dbManager.setString(8,prpLpaymainDto.getReceiverFullCode());
        dbManager.setString(9,prpLpaymainDto.getCertifType());
        dbManager.setString(10,prpLpaymainDto.getAddress());
        dbManager.setString(11,prpLpaymainDto.getCertifNo());
        dbManager.setString(12,prpLpaymainDto.getFamilyPhone());
        dbManager.setString(13,prpLpaymainDto.getOfficePhone());
        dbManager.setString(14,prpLpaymainDto.getMobilePhone());
        dbManager.setString(15,prpLpaymainDto.getPayRemark());
        dbManager.setString(16,prpLpaymainDto.getOperatorCode());
        dbManager.setDateTime(17,prpLpaymainDto.getInputDate());
        dbManager.setDateTime(18,prpLpaymainDto.getPayDate());
        dbManager.setString(19,prpLpaymainDto.getPayCode());
        dbManager.setString(20,prpLpaymainDto.getPayFlag());
        dbManager.setString(21,prpLpaymainDto.getPaymentType());
        dbManager.setString(22,prpLpaymainDto.getBankAccount());
        dbManager.setString(23,prpLpaymainDto.getNode());
        dbManager.setString(24,prpLpaymainDto.getUpLoadSerialNo());
        dbManager.setString(25,prpLpaymainDto.getVflag());
        dbManager.setString(26,prpLpaymainDto.getComCode());
        dbManager.setString(27,prpLpaymainDto.getMergerFlag());
        dbManager.setDouble(28,prpLpaymainDto.getPayTotalAmount());
        dbManager.setString(29,prpLpaymainDto.getUrgentType());
        dbManager.setString(30,prpLpaymainDto.getReceiverTypeOther());
        dbManager.setString(31,prpLpaymainDto.getReceiverTypeOtherName());
        dbManager.setString(32,prpLpaymainDto.getQqNumber());
        dbManager.setString(33,prpLpaymainDto.getEmail());
        dbManager.setString(34,prpLpaymainDto.getUnitLink());
        dbManager.setString(35,prpLpaymainDto.getPostCode());
        dbManager.setString(36,prpLpaymainDto.getVerifyFlag());
        dbManager.setString(37,prpLpaymainDto.getNoticeNo());
        dbManager.setString(38,prpLpaymainDto.getProvinceCode());
        dbManager.setString(39,prpLpaymainDto.getCityCode());
        dbManager.setDateTime(40,prpLpaymainDto.getBackDate());
        dbManager.setString(41,prpLpaymainDto.getBackOperatorCode());
        dbManager.setString(42,prpLpaymainDto.getBackComCode());
        dbManager.setString(43,prpLpaymainDto.getThirdPayFlag());
        dbManager.setString(44,prpLpaymainDto.getPayWay());
        dbManager.setString(45,prpLpaymainDto.getPayReason());
        dbManager.setString(46,prpLpaymainDto.getPayPurpose());
        dbManager.setString(47,prpLpaymainDto.getAccountFlag());
        dbManager.setString(48,prpLpaymainDto.getInterType());
        dbManager.setString(49,prpLpaymainDto.getRouteNum());
        dbManager.setString(50, prpLpaymainDto.getBillFlag());
        dbManager.setString(51, prpLpaymainDto.getNoBillFlag());
        dbManager.setString(52, prpLpaymainDto.getRealPayWay());
        dbManager.setString(53,prpLpaymainDto.getThirdPayType());
        //设置条件字段;
        dbManager.setString(54,prpLpaymainDto.getPaymentNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param paymentNo 支付编号
     * @return PrpLpaymainDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PaymentNo,");
        buffer.append("PayType,");
        buffer.append("PayAmount,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankSite,");
        buffer.append("AccountType,");
        buffer.append("ReceiverFullName,");
        buffer.append("ReceiverFullCode,");
        buffer.append("CertifType,");
        buffer.append("Address,");
        buffer.append("CertifNo,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("MobilePhone,");
        buffer.append("PayRemark,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("PayDate,");
        buffer.append("PayCode,");
        buffer.append("PayFlag,");
        buffer.append("PaymentType,");
        buffer.append("BankAccount,");
        buffer.append("Node,");
        buffer.append("UpLoadSerialNo,");
        buffer.append("Vflag,");
        buffer.append("ComCode,");
        buffer.append("MergerFlag,");
        buffer.append("PayTotalAmount,");
        buffer.append("UrgentType,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("VerifyFlag,");
        buffer.append("NoticeNo, ");
        buffer.append("provinceCode, ");
        buffer.append("cityCode, ");
        buffer.append("backDate,");
        buffer.append("backOperatorCode, ");
        buffer.append("backComCode, ");
        buffer.append("thirdPayFlag, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("billFlag, ");
        buffer.append("nobillFlag, ");
        buffer.append("realPayWay, ");
        buffer.append("thirdPayType ");
        buffer.append("FROM PrpLpaymain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,paymentNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpaymainDto prpLpaymainDto = null;
        if(resultSet.next()){
            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setProvinceCode(dbManager.getString(resultSet,39));
            prpLpaymainDto.setCityCode(dbManager.getString(resultSet,40));
            prpLpaymainDto.setBackDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,41));
            prpLpaymainDto.setBackOperatorCode(dbManager.getString(resultSet, 42));
            prpLpaymainDto.setBackComCode(dbManager.getString(resultSet, 43));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet, 44));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet, 45));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet, 46));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet, 47));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet, 48));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet, 49));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 51));
            prpLpaymainDto.setNoBillFlag(dbManager.getString(resultSet, 52));
            prpLpaymainDto.setRealPayWay(dbManager.getString(resultSet, 53));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 54));
        }
        resultSet.close();
        return prpLpaymainDto;
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
        buffer.append("PaymentNo,");
        buffer.append("PayType,");
        buffer.append("PayAmount,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankSite,");
        buffer.append("AccountType,");
        buffer.append("ReceiverFullName,");
        buffer.append("ReceiverFullCode,");
        buffer.append("CertifType,");
        buffer.append("Address,");
        buffer.append("CertifNo,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("MobilePhone,");
        buffer.append("PayRemark,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("PayDate,");
        buffer.append("PayCode,");
        buffer.append("PayFlag,");
        buffer.append("PaymentType,");
        buffer.append("BankAccount,");
        buffer.append("Node,");
        buffer.append("UpLoadSerialNo,");
        buffer.append("Vflag,");
        buffer.append("ComCode,");
        buffer.append("MergerFlag,");
        buffer.append("PayTotalAmount,");
        buffer.append("UrgentType,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("VerifyFlag,");
        buffer.append("NoticeNo, ");
        buffer.append("provinceCode, ");
        buffer.append("cityCode, ");
        buffer.append("backDate,");
        buffer.append("backOperatorCode, ");
        buffer.append("backComCode, ");
        buffer.append("thirdPayFlag, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("billFlag, ");
        buffer.append("nobillFlag, ");
        buffer.append("realPayWay, ");
        buffer.append("thirdPayType ");
        buffer.append("FROM PrpLpaymain WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //目前只对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
        PrpLpaymainDto prpLpaymainDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpaymainDto = new PrpLpaymainDto();
            prpLpaymainDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpaymainDto.setPayType(dbManager.getString(resultSet,2));
            prpLpaymainDto.setPayAmount(dbManager.getDouble(resultSet,3));
            prpLpaymainDto.setBankType(dbManager.getString(resultSet,4));
            prpLpaymainDto.setBank(dbManager.getString(resultSet,5));
            prpLpaymainDto.setBankSite(dbManager.getString(resultSet,6));
            prpLpaymainDto.setAccountType(dbManager.getString(resultSet,7));
            prpLpaymainDto.setReceiverFullName(dbManager.getString(resultSet,8));
            prpLpaymainDto.setReceiverFullCode(dbManager.getString(resultSet,9));
            prpLpaymainDto.setCertifType(dbManager.getString(resultSet,10));
            prpLpaymainDto.setAddress(dbManager.getString(resultSet,11));
            prpLpaymainDto.setCertifNo(dbManager.getString(resultSet,12));
            prpLpaymainDto.setFamilyPhone(dbManager.getString(resultSet,13));
            prpLpaymainDto.setOfficePhone(dbManager.getString(resultSet,14));
            prpLpaymainDto.setMobilePhone(dbManager.getString(resultSet,15));
            prpLpaymainDto.setPayRemark(dbManager.getString(resultSet,16));
            prpLpaymainDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpLpaymainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,18));
            prpLpaymainDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,19));
            prpLpaymainDto.setPayCode(dbManager.getString(resultSet,20));
            prpLpaymainDto.setPayFlag(dbManager.getString(resultSet,21));
            prpLpaymainDto.setPaymentType(dbManager.getString(resultSet,22));
            prpLpaymainDto.setBankAccount(dbManager.getString(resultSet,23));
            prpLpaymainDto.setNode(dbManager.getString(resultSet,24));
            prpLpaymainDto.setUpLoadSerialNo(dbManager.getString(resultSet,25));
            prpLpaymainDto.setVflag(dbManager.getString(resultSet,26));
            prpLpaymainDto.setComCode(dbManager.getString(resultSet,27));
            prpLpaymainDto.setMergerFlag(dbManager.getString(resultSet,28));
            prpLpaymainDto.setPayTotalAmount(dbManager.getDouble(resultSet,29));
            prpLpaymainDto.setUrgentType(dbManager.getString(resultSet,30));
            prpLpaymainDto.setReceiverTypeOther(dbManager.getString(resultSet,31));
            prpLpaymainDto.setReceiverTypeOtherName(dbManager.getString(resultSet,32));
            prpLpaymainDto.setQqNumber(dbManager.getString(resultSet,33));
            prpLpaymainDto.setEmail(dbManager.getString(resultSet,34));
            prpLpaymainDto.setUnitLink(dbManager.getString(resultSet,35));
            prpLpaymainDto.setPostCode(dbManager.getString(resultSet,36));
            prpLpaymainDto.setVerifyFlag(dbManager.getString(resultSet,37));
            prpLpaymainDto.setNoticeNo(dbManager.getString(resultSet,38));
            prpLpaymainDto.setProvinceCode(dbManager.getString(resultSet,39));
            prpLpaymainDto.setCityCode(dbManager.getString(resultSet,40));
            prpLpaymainDto.setBackDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_MINUTE,41));
            prpLpaymainDto.setBackOperatorCode(dbManager.getString(resultSet, 42));
            prpLpaymainDto.setBackComCode(dbManager.getString(resultSet, 43));
            prpLpaymainDto.setThirdPayFlag(dbManager.getString(resultSet, 44));
            prpLpaymainDto.setPayWay(dbManager.getString(resultSet, 45));
            prpLpaymainDto.setPayReason(dbManager.getString(resultSet, 46));
            prpLpaymainDto.setPayPurpose(dbManager.getString(resultSet, 47));
            prpLpaymainDto.setAccountFlag(dbManager.getString(resultSet, 48));
            prpLpaymainDto.setInterType(dbManager.getString(resultSet, 49));
            prpLpaymainDto.setRouteNum(dbManager.getString(resultSet, 50));
            prpLpaymainDto.setBillFlag(dbManager.getString(resultSet, 51));
            prpLpaymainDto.setNoBillFlag(dbManager.getString(resultSet, 52));
            prpLpaymainDto.setRealPayWay(dbManager.getString(resultSet, 53));
            prpLpaymainDto.setThirdPayType(dbManager.getString(resultSet, 54));
            collection.add(prpLpaymainDto);
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
        buffer.append("DELETE FROM PrpLpaymain WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLpaymain WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
