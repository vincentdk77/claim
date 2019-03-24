package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayHis的数据访问对象基类<br>
 * 创建于 2013-10-25 11:22:16.531<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayHistgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayHistgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayHistgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insert(PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayHistg (");
        buffer.append("claimNo,");
        buffer.append("serialNo,");
        buffer.append("compensateNo,");
        buffer.append("classCode,");
        buffer.append("riskCode,");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("payType,");
        buffer.append("receiverType,");
        buffer.append("payAmount,");
        buffer.append("bankType,");
        buffer.append("bank,");
        buffer.append("bankSite,");
        buffer.append("accountType,");
        buffer.append("receiverFullName,");
        buffer.append("certifType,");
        buffer.append("address,");
        buffer.append("certifNo,");
        buffer.append("familyPhone,");
        buffer.append("officePhone,");
        buffer.append("mobilePhone,");
        buffer.append("payreMark,");
        buffer.append("operatorCode,");
        buffer.append("inputDate,");
        buffer.append("payDate,");
        buffer.append("payCode,");
        buffer.append("payFlag,");
        buffer.append("paymentType,");
        buffer.append("bankAccount,");
        buffer.append("node,");
        buffer.append("uploadSerialno,");
        buffer.append("vflag,");
        buffer.append("comCode,");
        buffer.append("serialNo2,");
        buffer.append("provinceCode,");
        buffer.append("cityCode,");
        buffer.append("urgentType,");
        buffer.append("qqNumber,");
        buffer.append("email,");
        buffer.append("unitLink,");
        buffer.append("postCode, ");
        buffer.append("operatorComCode, ");
        buffer.append("editDate, ");
        buffer.append("receivertypeothername, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("thirdPayType, ");
        buffer.append("coinsCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayHisDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getSerialNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getReceiverType()).append("',");
            debugBuffer.append("").append(prpLpayHisDto.getPayAmount()).append(",");
            debugBuffer.append("'").append(prpLpayHisDto.getBankType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getBankSite()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getReceiverFullName()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getCertifType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getCertifNo()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getFamilyPhone()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getOfficePhone()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayreMark()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayDate()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayFlag()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPaymentType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getBankAccount()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getNode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getUploadSerialno()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getVflag()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getSerialNo2()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getProvinceCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getCityCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getUrgentType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getQqNumber()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getEmail()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getUnitLink()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPostCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getOperatorComCode()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getEditDate()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayWay()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayReason()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getPayPurpose()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getInterType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getRouteNum()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getThirdPayType()).append("',");
            debugBuffer.append("'").append(prpLpayHisDto.getCoinsCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayHisDto.getClaimNo());
        dbManager.setString(2,prpLpayHisDto.getSerialNo());
        dbManager.setString(3,prpLpayHisDto.getCompensateNo());
        dbManager.setString(4,prpLpayHisDto.getClassCode());
        dbManager.setString(5,prpLpayHisDto.getRiskCode());
        dbManager.setString(6,prpLpayHisDto.getRegistNo());
        dbManager.setString(7,prpLpayHisDto.getPolicyNo());
        dbManager.setString(8,prpLpayHisDto.getPayType());
        dbManager.setString(9,prpLpayHisDto.getReceiverType());
        dbManager.setDouble(10,prpLpayHisDto.getPayAmount());
        dbManager.setString(11,prpLpayHisDto.getBankType());
        dbManager.setString(12,prpLpayHisDto.getBank());
        dbManager.setString(13,prpLpayHisDto.getBankSite());
        dbManager.setString(14,prpLpayHisDto.getAccountType());
        dbManager.setString(15,prpLpayHisDto.getReceiverFullName());
        dbManager.setString(16,prpLpayHisDto.getCertifType());
        dbManager.setString(17,prpLpayHisDto.getAddress());
        dbManager.setString(18,prpLpayHisDto.getCertifNo());
        dbManager.setString(19,prpLpayHisDto.getFamilyPhone());
        dbManager.setString(20,prpLpayHisDto.getOfficePhone());
        dbManager.setString(21,prpLpayHisDto.getMobilePhone());
        dbManager.setString(22,prpLpayHisDto.getPayreMark());
        dbManager.setString(23,prpLpayHisDto.getOperatorCode());
        dbManager.setDateTime(24,prpLpayHisDto.getInputDate());
        dbManager.setDateTime(25,prpLpayHisDto.getPayDate());
        dbManager.setString(26,prpLpayHisDto.getPayCode());
        dbManager.setString(27,prpLpayHisDto.getPayFlag());
        dbManager.setString(28,prpLpayHisDto.getPaymentType());
        dbManager.setString(29,prpLpayHisDto.getBankAccount());
        dbManager.setString(30,prpLpayHisDto.getNode());
        dbManager.setString(31,prpLpayHisDto.getUploadSerialno());
        dbManager.setString(32,prpLpayHisDto.getVflag());
        dbManager.setString(33,prpLpayHisDto.getComCode());
        dbManager.setString(34,prpLpayHisDto.getSerialNo2());
        dbManager.setString(35,prpLpayHisDto.getProvinceCode());
        dbManager.setString(36,prpLpayHisDto.getCityCode());
        dbManager.setString(37,prpLpayHisDto.getUrgentType());
        dbManager.setString(38,prpLpayHisDto.getQqNumber());
        dbManager.setString(39,prpLpayHisDto.getEmail());
        dbManager.setString(40,prpLpayHisDto.getUnitLink());
        dbManager.setString(41,prpLpayHisDto.getPostCode());
        dbManager.setString(42,prpLpayHisDto.getOperatorComCode());
        dbManager.setDateTime(43,prpLpayHisDto.getEditDate());
        dbManager.setString(44,prpLpayHisDto.getReceivertypeothername());
        dbManager.setString(45,prpLpayHisDto.getPayWay());
        dbManager.setString(46,prpLpayHisDto.getPayReason());
        dbManager.setString(47,prpLpayHisDto.getPayPurpose());
        dbManager.setString(48,prpLpayHisDto.getAccountFlag());
        dbManager.setString(49,prpLpayHisDto.getInterType());
        dbManager.setString(50,prpLpayHisDto.getRouteNum());
        dbManager.setString(51,prpLpayHisDto.getThirdPayType());
        dbManager.setString(52,prpLpayHisDto.getCoinsCode());
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
        buffer.append("INSERT INTO PrpLpayHistg (");
        buffer.append("claimNo,");
        buffer.append("serialNo,");
        buffer.append("compensateNo,");
        buffer.append("classCode,");
        buffer.append("riskCode,");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("payType,");
        buffer.append("receiverType,");
        buffer.append("payAmount,");
        buffer.append("bankType,");
        buffer.append("bank,");
        buffer.append("bankSite,");
        buffer.append("accountType,");
        buffer.append("receiverFullName,");
        buffer.append("certifType,");
        buffer.append("address,");
        buffer.append("certifNo,");
        buffer.append("familyPhone,");
        buffer.append("officePhone,");
        buffer.append("mobilePhone,");
        buffer.append("payreMark,");
        buffer.append("operatorCode,");
        buffer.append("inputDate,");
        buffer.append("payDate,");
        buffer.append("payCode,");
        buffer.append("payFlag,");
        buffer.append("paymentType,");
        buffer.append("bankAccount,");
        buffer.append("node,");
        buffer.append("uploadSerialno,");
        buffer.append("vflag,");
        buffer.append("comCode,");
        buffer.append("serialNo2,");
        buffer.append("provinceCode,");
        buffer.append("cityCode,");
        buffer.append("urgentType,");
        buffer.append("qqNumber,");
        buffer.append("email,");
        buffer.append("unitLink,");
        buffer.append("postCode, ");
        buffer.append("operatorComCode, ");
        buffer.append("editDate, ");
        buffer.append("receivertypeothername, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("thirdPayType, ");
        buffer.append("coinsCode ");
        buffer.append(") ");
        
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayHisDto prpLpayHisDto = (PrpLpayHisDto)i.next();
            dbManager.setString(1,prpLpayHisDto.getClaimNo());
            dbManager.setString(2,prpLpayHisDto.getSerialNo());
            dbManager.setString(3,prpLpayHisDto.getCompensateNo());
            dbManager.setString(4,prpLpayHisDto.getClassCode());
            dbManager.setString(5,prpLpayHisDto.getRiskCode());
            dbManager.setString(6,prpLpayHisDto.getRegistNo());
            dbManager.setString(7,prpLpayHisDto.getPolicyNo());
            dbManager.setString(8,prpLpayHisDto.getPayType());
            dbManager.setString(9,prpLpayHisDto.getReceiverType());
            dbManager.setDouble(10,prpLpayHisDto.getPayAmount());
            dbManager.setString(11,prpLpayHisDto.getBankType());
            dbManager.setString(12,prpLpayHisDto.getBank());
            dbManager.setString(13,prpLpayHisDto.getBankSite());
            dbManager.setString(14,prpLpayHisDto.getAccountType());
            dbManager.setString(15,prpLpayHisDto.getReceiverFullName());
            dbManager.setString(16,prpLpayHisDto.getCertifType());
            dbManager.setString(17,prpLpayHisDto.getAddress());
            dbManager.setString(18,prpLpayHisDto.getCertifNo());
            dbManager.setString(19,prpLpayHisDto.getFamilyPhone());
            dbManager.setString(20,prpLpayHisDto.getOfficePhone());
            dbManager.setString(21,prpLpayHisDto.getMobilePhone());
            dbManager.setString(22,prpLpayHisDto.getPayreMark());
            dbManager.setString(23,prpLpayHisDto.getOperatorCode());
            dbManager.setDateTime(24,prpLpayHisDto.getInputDate());
            dbManager.setDateTime(25,prpLpayHisDto.getPayDate());
            dbManager.setString(26,prpLpayHisDto.getPayCode());
            dbManager.setString(27,prpLpayHisDto.getPayFlag());
            dbManager.setString(28,prpLpayHisDto.getPaymentType());
            dbManager.setString(29,prpLpayHisDto.getBankAccount());
            dbManager.setString(30,prpLpayHisDto.getNode());
            dbManager.setString(31,prpLpayHisDto.getUploadSerialno());
            dbManager.setString(32,prpLpayHisDto.getVflag());
            dbManager.setString(33,prpLpayHisDto.getComCode());
            dbManager.setString(34,prpLpayHisDto.getSerialNo2());
            dbManager.setString(35,prpLpayHisDto.getProvinceCode());
            dbManager.setString(36,prpLpayHisDto.getCityCode());
            dbManager.setString(37,prpLpayHisDto.getUrgentType());
            dbManager.setString(38,prpLpayHisDto.getQqNumber());
            dbManager.setString(39,prpLpayHisDto.getEmail());
            dbManager.setString(40,prpLpayHisDto.getUnitLink());
            dbManager.setString(41,prpLpayHisDto.getPostCode());
            dbManager.setString(42,prpLpayHisDto.getOperatorComCode());
            dbManager.setDateTime(43,prpLpayHisDto.getEditDate());
            dbManager.setString(44,prpLpayHisDto.getReceivertypeothername());
            dbManager.setString(45,prpLpayHisDto.getPayWay());
            dbManager.setString(46,prpLpayHisDto.getPayReason());
            dbManager.setString(47,prpLpayHisDto.getPayPurpose());
            dbManager.setString(48,prpLpayHisDto.getAccountFlag());
            dbManager.setString(49,prpLpayHisDto.getInterType());
            dbManager.setString(50,prpLpayHisDto.getRouteNum());
            dbManager.setString(51,prpLpayHisDto.getThirdPayType());
            dbManager.setString(52,prpLpayHisDto.getCoinsCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @throws Exception
     */
    public void delete(String serialNo,String serialNo2)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayHistg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("serialNo=").append("'").append(serialNo).append("' AND ");
            debugBuffer.append("serialNo2=").append("'").append(serialNo2).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serialNo = ? And ");
        buffer.append("serialNo2 = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,serialNo);
        dbManager.setString(2,serialNo2);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void update(PrpLpayHisDto prpLpayHisDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayHistg SET ");
        buffer.append("claimNo = ?, ");
        buffer.append("compensateNo = ?, ");
        buffer.append("classCode = ?, ");
        buffer.append("riskCode = ?, ");
        buffer.append("registNo = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("payType = ?, ");
        buffer.append("receiverType = ?, ");
        buffer.append("payAmount = ?, ");
        buffer.append("bankType = ?, ");
        buffer.append("bank = ?, ");
        buffer.append("bankSite = ?, ");
        buffer.append("accountType = ?, ");
        buffer.append("receiverFullName = ?, ");
        buffer.append("certifType = ?, ");
        buffer.append("address = ?, ");
        buffer.append("certifNo = ?, ");
        buffer.append("familyPhone = ?, ");
        buffer.append("officePhone = ?, ");
        buffer.append("mobilePhone = ?, ");
        buffer.append("payreMark = ?, ");
        buffer.append("operatorCode = ?, ");
        buffer.append("inputDate = ?, ");
        buffer.append("payDate = ?, ");
        buffer.append("payCode = ?, ");
        buffer.append("payFlag = ?, ");
        buffer.append("paymentType = ?, ");
        buffer.append("bankAccount = ?, ");
        buffer.append("node = ?, ");
        buffer.append("uploadSerialno = ?, ");
        buffer.append("vflag = ?, ");
        buffer.append("comCode = ?, ");
        buffer.append("provinceCode = ?, ");
        buffer.append("cityCode = ?, ");
        buffer.append("urgentType = ?, ");
        buffer.append("qqNumber = ?, ");
        buffer.append("email = ?, ");
        buffer.append("unitLink = ?, ");
        buffer.append("postCode = ?, ");
        buffer.append("operatorComCode = ?, ");
        buffer.append("editDate = ?, ");
        buffer.append("receivertypeothername = ?, ");
        buffer.append("payWay = ?, ");
        buffer.append("payReason = ?, ");
        buffer.append("payPurpose = ?, ");
        buffer.append("accountFlag = ?, ");
        buffer.append("interType = ?, ");
        buffer.append("routeNum = ?, ");
        buffer.append("thirdPayType = ?, ");
        buffer.append("coinsCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayHistg SET ");
            debugBuffer.append("claimNo = '" + prpLpayHisDto.getClaimNo() + "', ");
            debugBuffer.append("compensateNo = '" + prpLpayHisDto.getCompensateNo() + "', ");
            debugBuffer.append("classCode = '" + prpLpayHisDto.getClassCode() + "', ");
            debugBuffer.append("riskCode = '" + prpLpayHisDto.getRiskCode() + "', ");
            debugBuffer.append("registNo = '" + prpLpayHisDto.getRegistNo() + "', ");
            debugBuffer.append("policyNo = '" + prpLpayHisDto.getPolicyNo() + "', ");
            debugBuffer.append("payType = '" + prpLpayHisDto.getPayType() + "', ");
            debugBuffer.append("receiverType = '" + prpLpayHisDto.getReceiverType() + "', ");
            debugBuffer.append("payAmount = " + prpLpayHisDto.getPayAmount() + ", ");
            debugBuffer.append("bankType = '" + prpLpayHisDto.getBankType() + "', ");
            debugBuffer.append("bank = '" + prpLpayHisDto.getBank() + "', ");
            debugBuffer.append("bankSite = '" + prpLpayHisDto.getBankSite() + "', ");
            debugBuffer.append("accountType = '" + prpLpayHisDto.getAccountType() + "', ");
            debugBuffer.append("receiverFullName = '" + prpLpayHisDto.getReceiverFullName() + "', ");
            debugBuffer.append("certifType = '" + prpLpayHisDto.getCertifType() + "', ");
            debugBuffer.append("address = '" + prpLpayHisDto.getAddress() + "', ");
            debugBuffer.append("certifNo = '" + prpLpayHisDto.getCertifNo() + "', ");
            debugBuffer.append("familyPhone = '" + prpLpayHisDto.getFamilyPhone() + "', ");
            debugBuffer.append("officePhone = '" + prpLpayHisDto.getOfficePhone() + "', ");
            debugBuffer.append("mobilePhone = '" + prpLpayHisDto.getMobilePhone() + "', ");
            debugBuffer.append("payreMark = '" + prpLpayHisDto.getPayreMark() + "', ");
            debugBuffer.append("operatorCode = '" + prpLpayHisDto.getOperatorCode() + "', ");
            debugBuffer.append("inputDate = '" + prpLpayHisDto.getInputDate() + "', ");
            debugBuffer.append("payDate = '" + prpLpayHisDto.getPayDate() + "', ");
            debugBuffer.append("payCode = '" + prpLpayHisDto.getPayCode() + "', ");
            debugBuffer.append("payFlag = '" + prpLpayHisDto.getPayFlag() + "', ");
            debugBuffer.append("paymentTye = '" + prpLpayHisDto.getPaymentType() + "', ");
            debugBuffer.append("bankAccount = '" + prpLpayHisDto.getBankAccount() + "', ");
            debugBuffer.append("node = '" + prpLpayHisDto.getNode() + "', ");
            debugBuffer.append("uploadSerialno = '" + prpLpayHisDto.getUploadSerialno() + "', ");
            debugBuffer.append("vflag = '" + prpLpayHisDto.getVflag() + "', ");
            debugBuffer.append("comCode = '" + prpLpayHisDto.getComCode() + "', ");
            debugBuffer.append("provinceCode = '" + prpLpayHisDto.getProvinceCode() + "', ");
            debugBuffer.append("cityCode = '" + prpLpayHisDto.getCityCode() + "', ");
            debugBuffer.append("urgentType = '" + prpLpayHisDto.getUrgentType() + "', ");
            debugBuffer.append("qqNumber = '" + prpLpayHisDto.getQqNumber() + "', ");
            debugBuffer.append("email = '" + prpLpayHisDto.getEmail() + "', ");
            debugBuffer.append("unitLink = '" + prpLpayHisDto.getUnitLink() + "', ");
            debugBuffer.append("postCode = '" + prpLpayHisDto.getPostCode() + "', ");
            debugBuffer.append("operatorComCode = '" + prpLpayHisDto.getEditDate() + "', ");
            debugBuffer.append("editDate = '" + prpLpayHisDto.getOperatorComCode() + "', ");
            debugBuffer.append("payWay = '" + prpLpayHisDto.getPayWay() + "', ");
            debugBuffer.append("payReason = '" + prpLpayHisDto.getPayReason() + "', ");
            debugBuffer.append("payPurpose = '" + prpLpayHisDto.getPayPurpose() + "', ");
            debugBuffer.append("accountFlag = '" + prpLpayHisDto.getAccountFlag() + "', ");
            debugBuffer.append("interType = '" + prpLpayHisDto.getInterType() + "', ");
            debugBuffer.append("routeNum = '" + prpLpayHisDto.getRouteNum() + "', ");
            debugBuffer.append("thirdPayType = '" + prpLpayHisDto.getThirdPayType() + "', ");
            debugBuffer.append("coinsCode = '" + prpLpayHisDto.getCoinsCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("serialNo=").append("'").append(prpLpayHisDto.getSerialNo()).append("' AND ");
            debugBuffer.append("serialNo2=").append("'").append(prpLpayHisDto.getSerialNo2()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serialNo = ? And ");
        buffer.append("serialNo2 = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLpayHisDto.getClaimNo());
        dbManager.setString(2,prpLpayHisDto.getCompensateNo());
        dbManager.setString(3,prpLpayHisDto.getClassCode());
        dbManager.setString(4,prpLpayHisDto.getRiskCode());
        dbManager.setString(5,prpLpayHisDto.getRegistNo());
        dbManager.setString(6,prpLpayHisDto.getPolicyNo());
        dbManager.setString(7,prpLpayHisDto.getPayType());
        dbManager.setString(8,prpLpayHisDto.getReceiverType());
        dbManager.setDouble(9,prpLpayHisDto.getPayAmount());
        dbManager.setString(10,prpLpayHisDto.getBankType());
        dbManager.setString(11,prpLpayHisDto.getBank());
        dbManager.setString(12,prpLpayHisDto.getBankSite());
        dbManager.setString(13,prpLpayHisDto.getAccountType());
        dbManager.setString(14,prpLpayHisDto.getReceiverFullName());
        dbManager.setString(15,prpLpayHisDto.getCertifType());
        dbManager.setString(16,prpLpayHisDto.getAddress());
        dbManager.setString(17,prpLpayHisDto.getCertifNo());
        dbManager.setString(18,prpLpayHisDto.getFamilyPhone());
        dbManager.setString(19,prpLpayHisDto.getOfficePhone());
        dbManager.setString(20,prpLpayHisDto.getMobilePhone());
        dbManager.setString(21,prpLpayHisDto.getPayreMark());
        dbManager.setString(22,prpLpayHisDto.getOperatorCode());
        dbManager.setDateTime(23,prpLpayHisDto.getInputDate());
        dbManager.setDateTime(24,prpLpayHisDto.getPayDate());
        dbManager.setString(25,prpLpayHisDto.getPayCode());
        dbManager.setString(26,prpLpayHisDto.getPayFlag());
        dbManager.setString(27,prpLpayHisDto.getPaymentType());
        dbManager.setString(28,prpLpayHisDto.getBankAccount());
        dbManager.setString(29,prpLpayHisDto.getNode());
        dbManager.setString(30,prpLpayHisDto.getUploadSerialno());
        dbManager.setString(31,prpLpayHisDto.getVflag());
        dbManager.setString(32,prpLpayHisDto.getComCode());
        dbManager.setString(33,prpLpayHisDto.getProvinceCode());
        dbManager.setString(34,prpLpayHisDto.getCityCode());
        dbManager.setString(35,prpLpayHisDto.getUrgentType());
        dbManager.setString(36,prpLpayHisDto.getQqNumber());
        dbManager.setString(37,prpLpayHisDto.getEmail());
        dbManager.setString(38,prpLpayHisDto.getUnitLink());
        dbManager.setString(39,prpLpayHisDto.getPostCode());
        dbManager.setString(40,prpLpayHisDto.getOperatorComCode());
        dbManager.setDateTime(41,prpLpayHisDto.getEditDate());
        dbManager.setString(42,prpLpayHisDto.getReceivertypeothername());
        dbManager.setString(43,prpLpayHisDto.getPayWay());
        dbManager.setString(44,prpLpayHisDto.getPayReason());
        dbManager.setString(45,prpLpayHisDto.getPayPurpose());
        dbManager.setString(46,prpLpayHisDto.getAccountFlag());
        dbManager.setString(47,prpLpayHisDto.getInterType());
        dbManager.setString(48,prpLpayHisDto.getRouteNum());
        dbManager.setString(49,prpLpayHisDto.getThirdPayType());
        dbManager.setString(50,prpLpayHisDto.getCoinsCode());
        //设置条件字段;
        dbManager.setString(51,prpLpayHisDto.getSerialNo());
        dbManager.setString(52,prpLpayHisDto.getSerialNo2());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return PrpLpayHisDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(String serialNo,String serialNo2)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("claimNo,");
        buffer.append("serialNo,");
        buffer.append("compensateNo,");
        buffer.append("classCode,");
        buffer.append("riskCode,");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("payType,");
        buffer.append("receiverType,");
        buffer.append("payAmount,");
        buffer.append("bankType,");
        buffer.append("bank,");
        buffer.append("bankSite,");
        buffer.append("accountType,");
        buffer.append("receiverFullName,");
        buffer.append("certifType,");
        buffer.append("address,");
        buffer.append("certifNo,");
        buffer.append("familyPhone,");
        buffer.append("officePhone,");
        buffer.append("mobilePhone,");
        buffer.append("payreMark,");
        buffer.append("operatorCode,");
        buffer.append("inputDate,");
        buffer.append("payDate,");
        buffer.append("payCode,");
        buffer.append("payFlag,");
        buffer.append("paymentType,");
        buffer.append("bankAccount,");
        buffer.append("node,");
        buffer.append("uploadSerialno,");
        buffer.append("vflag,");
        buffer.append("comCode,");
        buffer.append("serialNo2,");
        buffer.append("provinceCode,");
        buffer.append("cityCode,");
        buffer.append("urgentType,");
        buffer.append("qqNumber,");
        buffer.append("email,");
        buffer.append("unitLink,");
        buffer.append("postCode, ");
        buffer.append("operatorComCode, ");
        buffer.append("editDate, ");
        buffer.append("receivertypeothername, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("thirdPayType, ");
        buffer.append("coinsCode ");
        buffer.append("FROM PrpLpayHistg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("serialNo=").append("'").append(serialNo).append("' AND ");
            debugBuffer.append("serialNo2=").append("'").append(serialNo2).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("serialNo = ? And ");
        buffer.append("serialNo2 = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,serialNo);
        dbManager.setString(2,serialNo2);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayHisDto prpLpayHisDto = null;
        if(resultSet.next()){
            prpLpayHisDto = new PrpLpayHisDto();
            prpLpayHisDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpayHisDto.setSerialNo(dbManager.getString(resultSet,2));
            prpLpayHisDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLpayHisDto.setClassCode(dbManager.getString(resultSet,4));
            prpLpayHisDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLpayHisDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLpayHisDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLpayHisDto.setPayType(dbManager.getString(resultSet,8));
            prpLpayHisDto.setReceiverType(dbManager.getString(resultSet,9));
            prpLpayHisDto.setPayAmount(dbManager.getDouble(resultSet,10));
            prpLpayHisDto.setBankType(dbManager.getString(resultSet,11));
            prpLpayHisDto.setBank(dbManager.getString(resultSet,12));
            prpLpayHisDto.setBankSite(dbManager.getString(resultSet,13));
            prpLpayHisDto.setAccountType(dbManager.getString(resultSet,14));
            prpLpayHisDto.setReceiverFullName(dbManager.getString(resultSet,15));
            prpLpayHisDto.setCertifType(dbManager.getString(resultSet,16));
            prpLpayHisDto.setAddress(dbManager.getString(resultSet,17));
            prpLpayHisDto.setCertifNo(dbManager.getString(resultSet,18));
            prpLpayHisDto.setFamilyPhone(dbManager.getString(resultSet,19));
            prpLpayHisDto.setOfficePhone(dbManager.getString(resultSet,20));
            prpLpayHisDto.setMobilePhone(dbManager.getString(resultSet,21));
            prpLpayHisDto.setPayreMark(dbManager.getString(resultSet,22));
            prpLpayHisDto.setOperatorCode(dbManager.getString(resultSet,23));
            prpLpayHisDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prpLpayHisDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,25));
            prpLpayHisDto.setPayCode(dbManager.getString(resultSet,26));
            prpLpayHisDto.setPayFlag(dbManager.getString(resultSet,27));
            prpLpayHisDto.setPaymentType(dbManager.getString(resultSet,28));
            prpLpayHisDto.setBankAccount(dbManager.getString(resultSet,29));
            prpLpayHisDto.setNode(dbManager.getString(resultSet,30));
            prpLpayHisDto.setUploadSerialno(dbManager.getString(resultSet,31));
            prpLpayHisDto.setVflag(dbManager.getString(resultSet,32));
            prpLpayHisDto.setComCode(dbManager.getString(resultSet,33));
            prpLpayHisDto.setSerialNo2(dbManager.getString(resultSet,34));
            prpLpayHisDto.setProvinceCode(dbManager.getString(resultSet,35));
            prpLpayHisDto.setCityCode(dbManager.getString(resultSet,36));
            prpLpayHisDto.setUrgentType(dbManager.getString(resultSet,37));
            prpLpayHisDto.setQqNumber(dbManager.getString(resultSet,38));
            prpLpayHisDto.setEmail(dbManager.getString(resultSet,39));
            prpLpayHisDto.setUnitLink(dbManager.getString(resultSet,40));
            prpLpayHisDto.setPostCode(dbManager.getString(resultSet,41));
            prpLpayHisDto.setOperatorComCode(dbManager.getString(resultSet,42));
            prpLpayHisDto.setEditDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,43));
            prpLpayHisDto.setReceivertypeothername(dbManager.getString(resultSet,44));
            prpLpayHisDto.setPayWay(dbManager.getString(resultSet, 45));
            prpLpayHisDto.setPayReason(dbManager.getString(resultSet, 46));
            prpLpayHisDto.setPayPurpose(dbManager.getString(resultSet, 47));
            prpLpayHisDto.setAccountFlag(dbManager.getString(resultSet, 48));
            prpLpayHisDto.setInterType(dbManager.getString(resultSet, 49));
            prpLpayHisDto.setRouteNum(dbManager.getString(resultSet, 50));
            prpLpayHisDto.setThirdPayType(dbManager.getString(resultSet, 51));
            prpLpayHisDto.setCoinsCode(dbManager.getString(resultSet, 52));
        }
        resultSet.close();
        return prpLpayHisDto;
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
        buffer.append("claimNo,");
        buffer.append("serialNo,");
        buffer.append("compensateNo,");
        buffer.append("classCode,");
        buffer.append("riskCode,");
        buffer.append("registNo,");
        buffer.append("policyNo,");
        buffer.append("payType,");
        buffer.append("receiverType,");
        buffer.append("payAmount,");
        buffer.append("bankType,");
        buffer.append("bank,");
        buffer.append("bankSite,");
        buffer.append("accountType,");
        buffer.append("receiverFullName,");
        buffer.append("certifType,");
        buffer.append("address,");
        buffer.append("certifNo,");
        buffer.append("familyPhone,");
        buffer.append("officePhone,");
        buffer.append("mobilePhone,");
        buffer.append("payreMark,");
        buffer.append("operatorCode,");
        buffer.append("inputDate,");
        buffer.append("payDate,");
        buffer.append("payCode,");
        buffer.append("payFlag,");
        buffer.append("paymentType,");
        buffer.append("bankAccount,");
        buffer.append("node,");
        buffer.append("uploadSerialno,");
        buffer.append("vflag,");
        buffer.append("comCode,");
        buffer.append("serialNo2,");
        buffer.append("provinceCode,");
        buffer.append("cityCode,");
        buffer.append("urgentType,");
        buffer.append("qqNumber,");
        buffer.append("email,");
        buffer.append("unitLink,");
        buffer.append("postCode, ");
        buffer.append("operatorComCode, ");
        buffer.append("editDate, ");
        buffer.append("receivertypeothername, ");
        buffer.append("payWay, ");
        buffer.append("payReason, ");
        buffer.append("payPurpose, ");
        buffer.append("accountFlag, ");
        buffer.append("interType, ");
        buffer.append("routeNum, ");
        buffer.append("thirdPayType, ");
        buffer.append("coinsCode ");
        buffer.append("FROM PrpLpayHistg WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLpayHisDto prpLpayHisDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayHisDto = new PrpLpayHisDto();
            prpLpayHisDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpayHisDto.setSerialNo(dbManager.getString(resultSet,2));
            prpLpayHisDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLpayHisDto.setClassCode(dbManager.getString(resultSet,4));
            prpLpayHisDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLpayHisDto.setRegistNo(dbManager.getString(resultSet,6));
            prpLpayHisDto.setPolicyNo(dbManager.getString(resultSet,7));
            prpLpayHisDto.setPayType(dbManager.getString(resultSet,8));
            prpLpayHisDto.setReceiverType(dbManager.getString(resultSet,9));
            prpLpayHisDto.setPayAmount(dbManager.getDouble(resultSet,10));
            prpLpayHisDto.setBankType(dbManager.getString(resultSet,11));
            prpLpayHisDto.setBank(dbManager.getString(resultSet,12));
            prpLpayHisDto.setBankSite(dbManager.getString(resultSet,13));
            prpLpayHisDto.setAccountType(dbManager.getString(resultSet,14));
            prpLpayHisDto.setReceiverFullName(dbManager.getString(resultSet,15));
            prpLpayHisDto.setCertifType(dbManager.getString(resultSet,16));
            prpLpayHisDto.setAddress(dbManager.getString(resultSet,17));
            prpLpayHisDto.setCertifNo(dbManager.getString(resultSet,18));
            prpLpayHisDto.setFamilyPhone(dbManager.getString(resultSet,19));
            prpLpayHisDto.setOfficePhone(dbManager.getString(resultSet,20));
            prpLpayHisDto.setMobilePhone(dbManager.getString(resultSet,21));
            prpLpayHisDto.setPayreMark(dbManager.getString(resultSet,22));
            prpLpayHisDto.setOperatorCode(dbManager.getString(resultSet,23));
            prpLpayHisDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,24));
            prpLpayHisDto.setPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,25));
            prpLpayHisDto.setPayCode(dbManager.getString(resultSet,26));
            prpLpayHisDto.setPayFlag(dbManager.getString(resultSet,27));
            prpLpayHisDto.setPaymentType(dbManager.getString(resultSet,28));
            prpLpayHisDto.setBankAccount(dbManager.getString(resultSet,29));
            prpLpayHisDto.setNode(dbManager.getString(resultSet,30));
            prpLpayHisDto.setUploadSerialno(dbManager.getString(resultSet,31));
            prpLpayHisDto.setVflag(dbManager.getString(resultSet,32));
            prpLpayHisDto.setComCode(dbManager.getString(resultSet,33));
            prpLpayHisDto.setSerialNo2(dbManager.getString(resultSet,34));
            prpLpayHisDto.setProvinceCode(dbManager.getString(resultSet,35));
            prpLpayHisDto.setCityCode(dbManager.getString(resultSet,36));
            prpLpayHisDto.setUrgentType(dbManager.getString(resultSet,37));
            prpLpayHisDto.setQqNumber(dbManager.getString(resultSet,38));
            prpLpayHisDto.setEmail(dbManager.getString(resultSet,39));
            prpLpayHisDto.setUnitLink(dbManager.getString(resultSet,40));
            prpLpayHisDto.setPostCode(dbManager.getString(resultSet,41));
            prpLpayHisDto.setOperatorComCode(dbManager.getString(resultSet,42));
            prpLpayHisDto.setEditDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,43));
            prpLpayHisDto.setReceivertypeothername(dbManager.getString(resultSet,44));
            prpLpayHisDto.setPayWay(dbManager.getString(resultSet, 45));
            prpLpayHisDto.setPayReason(dbManager.getString(resultSet, 46));
            prpLpayHisDto.setPayPurpose(dbManager.getString(resultSet, 47));
            prpLpayHisDto.setAccountFlag(dbManager.getString(resultSet, 48));
            prpLpayHisDto.setInterType(dbManager.getString(resultSet, 49));
            prpLpayHisDto.setRouteNum(dbManager.getString(resultSet, 50));
            prpLpayHisDto.setThirdPayType(dbManager.getString(resultSet, 51));
            prpLpayHisDto.setCoinsCode(dbManager.getString(resultSet, 52));
            collection.add(prpLpayHisDto);
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
        buffer.append("DELETE FROM PrpLpayHistg WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLpayHistg WHERE ");
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
    /***********************优化修改：start******************************/
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountByPrepered(String conditions,String Serialno,String Compensateno,double Payamount) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM PrpLpayHistg WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, Serialno);
        dbManager.setString(2, Compensateno);
        dbManager.setDouble(3, Payamount);
        ResultSet resultSet = dbManager.executePreparedQuery();
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    /***********************优化修改：end********************************/
}
