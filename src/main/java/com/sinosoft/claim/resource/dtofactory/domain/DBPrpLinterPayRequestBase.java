package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数主表的数据访问对象基类<br>
 */
public class DBPrpLinterPayRequestBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPayRequestBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinterPayRequestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterPayRequestDto prpLinterPayRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPayRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("OperateType,");
        buffer.append("PaymentNo,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("ReceiverFullName,");
        buffer.append("CertifType,");
        buffer.append("CertifTypeName,");
        buffer.append("CertifNo,");
        buffer.append("UrgentType,");
        buffer.append("UrgentTypeName,");
        buffer.append("ProvinceCode,");
        buffer.append("CityCode,");
        buffer.append("AccountType,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankAccount,");
        buffer.append("BankAccount2,");
        buffer.append("MobilePhone,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("Address,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("PayWay,");
        buffer.append("PayReason,");
        buffer.append("PayPurpose,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("OperatorDate,");
        buffer.append("HandleText,");
        buffer.append("InputDate,");
        buffer.append("AccountFlag, ");
        buffer.append("AutoFlag, ");
        buffer.append("HandleDate, ");
        buffer.append("HandleCode, ");
        buffer.append("SeriousInterType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOperateType()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getReceiverTypeOther()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getReceiverTypeOtherName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getReceiverFullName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getCertifType()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getCertifTypeName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getCertifNo()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getUrgentType()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getUrgentTypeName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getProvinceCode()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getCityCode()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getBankType()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getBankAccount()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getBankAccount2()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getFamilyPhone()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOfficePhone()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getAddress()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getQqNumber()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getEmail()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getUnitLink()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getPostCode()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getPayWay()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getPayReason()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getPayPurpose()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOperatorName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getMakeComName()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getOperatorDate()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getHandleText()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getAutoFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getHandleDate()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getHandleCode()).append("',");
            debugBuffer.append("'").append(prpLinterPayRequestDto.getSeriousInterType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPayRequestDto.getId());
        dbManager.setString(2,prpLinterPayRequestDto.getOutId());
        dbManager.setString(3,prpLinterPayRequestDto.getOperateType());
        dbManager.setString(4,prpLinterPayRequestDto.getPaymentNo());
        dbManager.setString(5,prpLinterPayRequestDto.getReceiverTypeOther());
        dbManager.setString(6,prpLinterPayRequestDto.getReceiverTypeOtherName());
        dbManager.setString(7,prpLinterPayRequestDto.getReceiverFullName());
        dbManager.setString(8,prpLinterPayRequestDto.getCertifType());
        dbManager.setString(9,prpLinterPayRequestDto.getCertifTypeName());
        dbManager.setString(10,prpLinterPayRequestDto.getCertifNo());
        dbManager.setString(11,prpLinterPayRequestDto.getUrgentType());
        dbManager.setString(12,prpLinterPayRequestDto.getUrgentTypeName());
        dbManager.setString(13,prpLinterPayRequestDto.getProvinceCode());
        dbManager.setString(14,prpLinterPayRequestDto.getCityCode());
        dbManager.setString(15,prpLinterPayRequestDto.getAccountType());
        dbManager.setString(16,prpLinterPayRequestDto.getBankType());
        dbManager.setString(17,prpLinterPayRequestDto.getBank());
        dbManager.setString(18,prpLinterPayRequestDto.getBankAccount());
        dbManager.setString(19,prpLinterPayRequestDto.getBankAccount2());
        dbManager.setString(20,prpLinterPayRequestDto.getMobilePhone());
        dbManager.setString(21,prpLinterPayRequestDto.getFamilyPhone());
        dbManager.setString(22,prpLinterPayRequestDto.getOfficePhone());
        dbManager.setString(23,prpLinterPayRequestDto.getAddress());
        dbManager.setString(24,prpLinterPayRequestDto.getQqNumber());
        dbManager.setString(25,prpLinterPayRequestDto.getEmail());
        dbManager.setString(26,prpLinterPayRequestDto.getUnitLink());
        dbManager.setString(27,prpLinterPayRequestDto.getPostCode());
        dbManager.setString(28,prpLinterPayRequestDto.getPayWay());
        dbManager.setString(29,prpLinterPayRequestDto.getPayReason());
        dbManager.setString(30,prpLinterPayRequestDto.getPayPurpose());
        dbManager.setString(31,prpLinterPayRequestDto.getOperatorCode());
        dbManager.setString(32,prpLinterPayRequestDto.getOperatorName());
        dbManager.setString(33,prpLinterPayRequestDto.getMakeCom());
        dbManager.setString(34,prpLinterPayRequestDto.getMakeComName());
        dbManager.setDateTime(35,prpLinterPayRequestDto.getOperatorDate());
        dbManager.setString(36,prpLinterPayRequestDto.getHandleText());
        dbManager.setDateTime(37,prpLinterPayRequestDto.getInputDate());
        dbManager.setString(38,prpLinterPayRequestDto.getAccountFlag());
        dbManager.setString(39,prpLinterPayRequestDto.getAutoFlag());
        dbManager.setDateTime(40,prpLinterPayRequestDto.getHandleDate());
        dbManager.setString(41,prpLinterPayRequestDto.getHandleCode());
        dbManager.setString(42,prpLinterPayRequestDto.getSeriousInterType());
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
        buffer.append("INSERT INTO PrpLinterPayRequest (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("OperateType,");
        buffer.append("PaymentNo,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("ReceiverFullName,");
        buffer.append("CertifType,");
        buffer.append("CertifTypeName,");
        buffer.append("CertifNo,");
        buffer.append("UrgentType,");
        buffer.append("UrgentTypeName,");
        buffer.append("ProvinceCode,");
        buffer.append("CityCode,");
        buffer.append("AccountType,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankAccount,");
        buffer.append("BankAccount2,");
        buffer.append("MobilePhone,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("Address,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("PayWay,");
        buffer.append("PayReason,");
        buffer.append("PayPurpose,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("OperatorDate,");
        buffer.append("HandleText,");
        buffer.append("InputDate,");
        buffer.append("AccountFlag, ");
        buffer.append("AutoFlag, ");
        buffer.append("HandleDate, ");
        buffer.append("HandleCode, ");
        buffer.append("SeriousInterType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPayRequestDto prpLinterPayRequestDto = (PrpLinterPayRequestDto)i.next();
            dbManager.setString(1,prpLinterPayRequestDto.getId());
            dbManager.setString(2,prpLinterPayRequestDto.getOutId());
            dbManager.setString(3,prpLinterPayRequestDto.getOperateType());
            dbManager.setString(4,prpLinterPayRequestDto.getPaymentNo());
            dbManager.setString(5,prpLinterPayRequestDto.getReceiverTypeOther());
            dbManager.setString(6,prpLinterPayRequestDto.getReceiverTypeOtherName());
            dbManager.setString(7,prpLinterPayRequestDto.getReceiverFullName());
            dbManager.setString(8,prpLinterPayRequestDto.getCertifType());
            dbManager.setString(9,prpLinterPayRequestDto.getCertifTypeName());
            dbManager.setString(10,prpLinterPayRequestDto.getCertifNo());
            dbManager.setString(11,prpLinterPayRequestDto.getUrgentType());
            dbManager.setString(12,prpLinterPayRequestDto.getUrgentTypeName());
            dbManager.setString(13,prpLinterPayRequestDto.getProvinceCode());
            dbManager.setString(14,prpLinterPayRequestDto.getCityCode());
            dbManager.setString(15,prpLinterPayRequestDto.getAccountType());
            dbManager.setString(16,prpLinterPayRequestDto.getBankType());
            dbManager.setString(17,prpLinterPayRequestDto.getBank());
            dbManager.setString(18,prpLinterPayRequestDto.getBankAccount());
            dbManager.setString(19,prpLinterPayRequestDto.getBankAccount2());
            dbManager.setString(20,prpLinterPayRequestDto.getMobilePhone());
            dbManager.setString(21,prpLinterPayRequestDto.getFamilyPhone());
            dbManager.setString(22,prpLinterPayRequestDto.getOfficePhone());
            dbManager.setString(23,prpLinterPayRequestDto.getAddress());
            dbManager.setString(24,prpLinterPayRequestDto.getQqNumber());
            dbManager.setString(25,prpLinterPayRequestDto.getEmail());
            dbManager.setString(26,prpLinterPayRequestDto.getUnitLink());
            dbManager.setString(27,prpLinterPayRequestDto.getPostCode());
            dbManager.setString(28,prpLinterPayRequestDto.getPayWay());
            dbManager.setString(29,prpLinterPayRequestDto.getPayReason());
            dbManager.setString(30,prpLinterPayRequestDto.getPayPurpose());
            dbManager.setString(31,prpLinterPayRequestDto.getOperatorCode());
            dbManager.setString(32,prpLinterPayRequestDto.getOperatorName());
            dbManager.setString(33,prpLinterPayRequestDto.getMakeCom());
            dbManager.setString(34,prpLinterPayRequestDto.getMakeComName());
            dbManager.setDateTime(35,prpLinterPayRequestDto.getOperatorDate());
            dbManager.setString(36,prpLinterPayRequestDto.getHandleText());
            dbManager.setDateTime(37,prpLinterPayRequestDto.getInputDate());
            dbManager.setString(38,prpLinterPayRequestDto.getAccountFlag());
            dbManager.setString(39,prpLinterPayRequestDto.getAutoFlag());
            dbManager.setDateTime(40,prpLinterPayRequestDto.getHandleDate());
            dbManager.setString(41,prpLinterPayRequestDto.getHandleCode());
            dbManager.setString(42,prpLinterPayRequestDto.getSeriousInterType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPayRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLinterPayRequestDto prpLinterPayRequestDto
     * @throws Exception
     */
    public void update(PrpLinterPayRequestDto prpLinterPayRequestDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPayRequest SET ");
        buffer.append("OutId = ?, ");
        buffer.append("OperateType = ?, ");
        buffer.append("PaymentNo = ?, ");
        buffer.append("ReceiverTypeOther = ?, ");
        buffer.append("ReceiverTypeOtherName = ?, ");
        buffer.append("ReceiverFullName = ?, ");
        buffer.append("CertifType = ?, ");
        buffer.append("CertifTypeName = ?, ");
        buffer.append("CertifNo = ?, ");
        buffer.append("UrgentType = ?, ");
        buffer.append("UrgentTypeName = ?, ");
        buffer.append("ProvinceCode = ?, ");
        buffer.append("CityCode = ?, ");
        buffer.append("AccountType = ?, ");
        buffer.append("BankType = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("BankAccount = ?, ");
        buffer.append("BankAccount2 = ?, ");
        buffer.append("MobilePhone = ?, ");
        buffer.append("FamilyPhone = ?, ");
        buffer.append("OfficePhone = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("QqNumber = ?, ");
        buffer.append("Email = ?, ");
        buffer.append("UnitLink = ?, ");
        buffer.append("PostCode = ?, ");
        buffer.append("PayWay = ?, ");
        buffer.append("PayReason = ?, ");
        buffer.append("PayPurpose = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("OperatorName = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("MakeComName = ?, ");
        buffer.append("OperatorDate = ?, ");
        buffer.append("HandleText = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("AccountFlag = ?, ");
        buffer.append("AutoFlag = ?, ");
        buffer.append("HandleDate = ?, ");
        buffer.append("HandleCode = ?, ");
        buffer.append("SeriousInterType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPayRequest SET ");
            debugBuffer.append("OutId = '" + prpLinterPayRequestDto.getOutId() + "', ");
            debugBuffer.append("OperateType = '" + prpLinterPayRequestDto.getOperateType() + "', ");
            debugBuffer.append("PaymentNo = '" + prpLinterPayRequestDto.getPaymentNo() + "', ");
            debugBuffer.append("ReceiverTypeOther = '" + prpLinterPayRequestDto.getReceiverTypeOther() + "', ");
            debugBuffer.append("ReceiverTypeOtherName = '" + prpLinterPayRequestDto.getReceiverTypeOtherName() + "', ");
            debugBuffer.append("ReceiverFullName = '" + prpLinterPayRequestDto.getReceiverFullName() + "', ");
            debugBuffer.append("CertifType = '" + prpLinterPayRequestDto.getCertifType() + "', ");
            debugBuffer.append("CertifTypeName = '" + prpLinterPayRequestDto.getCertifTypeName() + "', ");
            debugBuffer.append("CertifNo = '" + prpLinterPayRequestDto.getCertifNo() + "', ");
            debugBuffer.append("UrgentType = '" + prpLinterPayRequestDto.getUrgentType() + "', ");
            debugBuffer.append("UrgentTypeName = '" + prpLinterPayRequestDto.getUrgentTypeName() + "', ");
            debugBuffer.append("ProvinceCode = '" + prpLinterPayRequestDto.getProvinceCode() + "', ");
            debugBuffer.append("CityCode = '" + prpLinterPayRequestDto.getCityCode() + "', ");
            debugBuffer.append("AccountType = '" + prpLinterPayRequestDto.getAccountType() + "', ");
            debugBuffer.append("BankType = '" + prpLinterPayRequestDto.getBankType() + "', ");
            debugBuffer.append("Bank = '" + prpLinterPayRequestDto.getBank() + "', ");
            debugBuffer.append("BankAccount = '" + prpLinterPayRequestDto.getBankAccount() + "', ");
            debugBuffer.append("BankAccount2 = '" + prpLinterPayRequestDto.getBankAccount2() + "', ");
            debugBuffer.append("MobilePhone = '" + prpLinterPayRequestDto.getMobilePhone() + "', ");
            debugBuffer.append("FamilyPhone = '" + prpLinterPayRequestDto.getFamilyPhone() + "', ");
            debugBuffer.append("OfficePhone = '" + prpLinterPayRequestDto.getOfficePhone() + "', ");
            debugBuffer.append("Address = '" + prpLinterPayRequestDto.getAddress() + "', ");
            debugBuffer.append("QqNumber = '" + prpLinterPayRequestDto.getQqNumber() + "', ");
            debugBuffer.append("Email = '" + prpLinterPayRequestDto.getEmail() + "', ");
            debugBuffer.append("UnitLink = '" + prpLinterPayRequestDto.getUnitLink() + "', ");
            debugBuffer.append("PostCode = '" + prpLinterPayRequestDto.getPostCode() + "', ");
            debugBuffer.append("PayWay = '" + prpLinterPayRequestDto.getPayWay() + "', ");
            debugBuffer.append("PayReason = '" + prpLinterPayRequestDto.getPayReason() + "', ");
            debugBuffer.append("PayPurpose = '" + prpLinterPayRequestDto.getPayPurpose() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLinterPayRequestDto.getOperatorCode() + "', ");
            debugBuffer.append("OperatorName = '" + prpLinterPayRequestDto.getOperatorName() + "', ");
            debugBuffer.append("MakeCom = '" + prpLinterPayRequestDto.getMakeCom() + "', ");
            debugBuffer.append("MakeComName = '" + prpLinterPayRequestDto.getMakeComName() + "', ");
            debugBuffer.append("OperatorDate = '" + prpLinterPayRequestDto.getOperatorDate() + "', ");
            debugBuffer.append("HandleText = '" + prpLinterPayRequestDto.getHandleText() + "', ");
            debugBuffer.append("InputDate = '" + prpLinterPayRequestDto.getInputDate() + "', ");
            debugBuffer.append("AccountFlag = '" + prpLinterPayRequestDto.getAccountFlag() + "', ");
            debugBuffer.append("AutoFlag = '" + prpLinterPayRequestDto.getAutoFlag() + "', ");
            debugBuffer.append("HandleDate= '" + prpLinterPayRequestDto.getHandleDate() + "', ");
            debugBuffer.append("HandleCode= '" + prpLinterPayRequestDto.getHandleCode() + "', ");
            debugBuffer.append("SeriousInterType = '" + prpLinterPayRequestDto.getSeriousInterType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPayRequestDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinterPayRequestDto.getOutId());
        dbManager.setString(2,prpLinterPayRequestDto.getOperateType());
        dbManager.setString(3,prpLinterPayRequestDto.getPaymentNo());
        dbManager.setString(4,prpLinterPayRequestDto.getReceiverTypeOther());
        dbManager.setString(5,prpLinterPayRequestDto.getReceiverTypeOtherName());
        dbManager.setString(6,prpLinterPayRequestDto.getReceiverFullName());
        dbManager.setString(7,prpLinterPayRequestDto.getCertifType());
        dbManager.setString(8,prpLinterPayRequestDto.getCertifTypeName());
        dbManager.setString(9,prpLinterPayRequestDto.getCertifNo());
        dbManager.setString(10,prpLinterPayRequestDto.getUrgentType());
        dbManager.setString(11,prpLinterPayRequestDto.getUrgentTypeName());
        dbManager.setString(12,prpLinterPayRequestDto.getProvinceCode());
        dbManager.setString(13,prpLinterPayRequestDto.getCityCode());
        dbManager.setString(14,prpLinterPayRequestDto.getAccountType());
        dbManager.setString(15,prpLinterPayRequestDto.getBankType());
        dbManager.setString(16,prpLinterPayRequestDto.getBank());
        dbManager.setString(17,prpLinterPayRequestDto.getBankAccount());
        dbManager.setString(18,prpLinterPayRequestDto.getBankAccount2());
        dbManager.setString(19,prpLinterPayRequestDto.getMobilePhone());
        dbManager.setString(20,prpLinterPayRequestDto.getFamilyPhone());
        dbManager.setString(21,prpLinterPayRequestDto.getOfficePhone());
        dbManager.setString(22,prpLinterPayRequestDto.getAddress());
        dbManager.setString(23,prpLinterPayRequestDto.getQqNumber());
        dbManager.setString(24,prpLinterPayRequestDto.getEmail());
        dbManager.setString(25,prpLinterPayRequestDto.getUnitLink());
        dbManager.setString(26,prpLinterPayRequestDto.getPostCode());
        dbManager.setString(27,prpLinterPayRequestDto.getPayWay());
        dbManager.setString(28,prpLinterPayRequestDto.getPayReason());
        dbManager.setString(29,prpLinterPayRequestDto.getPayPurpose());
        dbManager.setString(30,prpLinterPayRequestDto.getOperatorCode());
        dbManager.setString(31,prpLinterPayRequestDto.getOperatorName());
        dbManager.setString(32,prpLinterPayRequestDto.getMakeCom());
        dbManager.setString(33,prpLinterPayRequestDto.getMakeComName());
        dbManager.setDateTime(34,prpLinterPayRequestDto.getOperatorDate());
        dbManager.setString(35,prpLinterPayRequestDto.getHandleText());
        dbManager.setDateTime(36,prpLinterPayRequestDto.getInputDate());
        dbManager.setString(37,prpLinterPayRequestDto.getAccountFlag());
        dbManager.setString(38,prpLinterPayRequestDto.getAutoFlag());
        dbManager.setDateTime(39,prpLinterPayRequestDto.getHandleDate());
        dbManager.setString(40,prpLinterPayRequestDto.getHandleCode());
        dbManager.setString(41,prpLinterPayRequestDto.getSeriousInterType());
        
        //设置条件字段;
        dbManager.setString(42,prpLinterPayRequestDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param id 主键id PK
     * @return PrpLinterPayRequestDto
     * @throws Exception
     */
    public PrpLinterPayRequestDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("OperateType,");
        buffer.append("PaymentNo,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("ReceiverFullName,");
        buffer.append("CertifType,");
        buffer.append("CertifTypeName,");
        buffer.append("CertifNo,");
        buffer.append("UrgentType,");
        buffer.append("UrgentTypeName,");
        buffer.append("ProvinceCode,");
        buffer.append("CityCode,");
        buffer.append("AccountType,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankAccount,");
        buffer.append("BankAccount2,");
        buffer.append("MobilePhone,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("Address,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("PayWay,");
        buffer.append("PayReason,");
        buffer.append("PayPurpose,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("OperatorDate,");
        buffer.append("HandleText,");
        buffer.append("InputDate,");
        buffer.append("AccountFlag, ");
        buffer.append("AutoFlag, ");
        buffer.append("HandleDate, ");
        buffer.append("HandleCode, ");
        buffer.append("SeriousInterType ");
        buffer.append("FROM PrpLinterPayRequest ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPayRequestDto prpLinterPayRequestDto = null;
        if(resultSet.next()){
            prpLinterPayRequestDto = new PrpLinterPayRequestDto();
            prpLinterPayRequestDto.setId(dbManager.getString(resultSet,1));
            prpLinterPayRequestDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterPayRequestDto.setOperateType(dbManager.getString(resultSet,3));
            prpLinterPayRequestDto.setPaymentNo(dbManager.getString(resultSet,4));
            prpLinterPayRequestDto.setReceiverTypeOther(dbManager.getString(resultSet,5));
            prpLinterPayRequestDto.setReceiverTypeOtherName(dbManager.getString(resultSet,6));
            prpLinterPayRequestDto.setReceiverFullName(dbManager.getString(resultSet,7));
            prpLinterPayRequestDto.setCertifType(dbManager.getString(resultSet,8));
            prpLinterPayRequestDto.setCertifTypeName(dbManager.getString(resultSet,9));
            prpLinterPayRequestDto.setCertifNo(dbManager.getString(resultSet,10));
            prpLinterPayRequestDto.setUrgentType(dbManager.getString(resultSet,11));
            prpLinterPayRequestDto.setUrgentTypeName(dbManager.getString(resultSet,12));
            prpLinterPayRequestDto.setProvinceCode(dbManager.getString(resultSet,13));
            prpLinterPayRequestDto.setCityCode(dbManager.getString(resultSet,14));
            prpLinterPayRequestDto.setAccountType(dbManager.getString(resultSet,15));
            prpLinterPayRequestDto.setBankType(dbManager.getString(resultSet,16));
            prpLinterPayRequestDto.setBank(dbManager.getString(resultSet,17));
            prpLinterPayRequestDto.setBankAccount(dbManager.getString(resultSet,18));
            prpLinterPayRequestDto.setBankAccount2(dbManager.getString(resultSet,19));
            prpLinterPayRequestDto.setMobilePhone(dbManager.getString(resultSet,20));
            prpLinterPayRequestDto.setFamilyPhone(dbManager.getString(resultSet,21));
            prpLinterPayRequestDto.setOfficePhone(dbManager.getString(resultSet,22));
            prpLinterPayRequestDto.setAddress(dbManager.getString(resultSet,23));
            prpLinterPayRequestDto.setQqNumber(dbManager.getString(resultSet,24));
            prpLinterPayRequestDto.setEmail(dbManager.getString(resultSet,25));
            prpLinterPayRequestDto.setUnitLink(dbManager.getString(resultSet,26));
            prpLinterPayRequestDto.setPostCode(dbManager.getString(resultSet,27));
            prpLinterPayRequestDto.setPayWay(dbManager.getString(resultSet,28));
            prpLinterPayRequestDto.setPayReason(dbManager.getString(resultSet,29));
            prpLinterPayRequestDto.setPayPurpose(dbManager.getString(resultSet,30));
            prpLinterPayRequestDto.setOperatorCode(dbManager.getString(resultSet,31));
            prpLinterPayRequestDto.setOperatorName(dbManager.getString(resultSet,32));
            prpLinterPayRequestDto.setMakeCom(dbManager.getString(resultSet,33));
            prpLinterPayRequestDto.setMakeComName(dbManager.getString(resultSet,34));
            prpLinterPayRequestDto.setOperatorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,35));
            prpLinterPayRequestDto.setHandleText(dbManager.getString(resultSet,36));
            prpLinterPayRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,37));
            prpLinterPayRequestDto.setAccountFlag(dbManager.getString(resultSet,38));
            prpLinterPayRequestDto.setAutoFlag(dbManager.getString(resultSet,39));
            prpLinterPayRequestDto.setHandleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,40));
            prpLinterPayRequestDto.setHandleCode(dbManager.getString(resultSet,41));
            prpLinterPayRequestDto.setSeriousInterType(dbManager.getString(resultSet, 42));
        }
        resultSet.close();
        return prpLinterPayRequestDto;
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
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("OperateType,");
        buffer.append("PaymentNo,");
        buffer.append("ReceiverTypeOther,");
        buffer.append("ReceiverTypeOtherName,");
        buffer.append("ReceiverFullName,");
        buffer.append("CertifType,");
        buffer.append("CertifTypeName,");
        buffer.append("CertifNo,");
        buffer.append("UrgentType,");
        buffer.append("UrgentTypeName,");
        buffer.append("ProvinceCode,");
        buffer.append("CityCode,");
        buffer.append("AccountType,");
        buffer.append("BankType,");
        buffer.append("Bank,");
        buffer.append("BankAccount,");
        buffer.append("BankAccount2,");
        buffer.append("MobilePhone,");
        buffer.append("FamilyPhone,");
        buffer.append("OfficePhone,");
        buffer.append("Address,");
        buffer.append("QqNumber,");
        buffer.append("Email,");
        buffer.append("UnitLink,");
        buffer.append("PostCode,");
        buffer.append("PayWay,");
        buffer.append("PayReason,");
        buffer.append("PayPurpose,");
        buffer.append("OperatorCode,");
        buffer.append("OperatorName,");
        buffer.append("MakeCom,");
        buffer.append("MakeComName,");
        buffer.append("OperatorDate,");
        buffer.append("HandleText,");
        buffer.append("InputDate,");
        buffer.append("AccountFlag, ");
        buffer.append("AutoFlag, ");
        buffer.append("HandleDate, ");
        buffer.append("HandleCode, ");
        buffer.append("SeriousInterType ");
        buffer.append("FROM PrpLinterPayRequest WHERE ");
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
        PrpLinterPayRequestDto prpLinterPayRequestDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPayRequestDto = new PrpLinterPayRequestDto();
            prpLinterPayRequestDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPayRequestDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterPayRequestDto.setOperateType(dbManager.getString(resultSet,"OperateType"));
            prpLinterPayRequestDto.setPaymentNo(dbManager.getString(resultSet,"PaymentNo"));
            prpLinterPayRequestDto.setReceiverTypeOther(dbManager.getString(resultSet,"ReceiverTypeOther"));
            prpLinterPayRequestDto.setReceiverTypeOtherName(dbManager.getString(resultSet,"ReceiverTypeOtherName"));
            prpLinterPayRequestDto.setReceiverFullName(dbManager.getString(resultSet,"ReceiverFullName"));
            prpLinterPayRequestDto.setCertifType(dbManager.getString(resultSet,"CertifType"));
            prpLinterPayRequestDto.setCertifTypeName(dbManager.getString(resultSet,"CertifTypeName"));
            prpLinterPayRequestDto.setCertifNo(dbManager.getString(resultSet,"CertifNo"));
            prpLinterPayRequestDto.setUrgentType(dbManager.getString(resultSet,"UrgentType"));
            prpLinterPayRequestDto.setUrgentTypeName(dbManager.getString(resultSet,"UrgentTypeName"));
            prpLinterPayRequestDto.setProvinceCode(dbManager.getString(resultSet,"ProvinceCode"));
            prpLinterPayRequestDto.setCityCode(dbManager.getString(resultSet,"CityCode"));
            prpLinterPayRequestDto.setAccountType(dbManager.getString(resultSet,"AccountType"));
            prpLinterPayRequestDto.setBankType(dbManager.getString(resultSet,"BankType"));
            prpLinterPayRequestDto.setBank(dbManager.getString(resultSet,"Bank"));
            prpLinterPayRequestDto.setBankAccount(dbManager.getString(resultSet,"BankAccount"));
            prpLinterPayRequestDto.setBankAccount2(dbManager.getString(resultSet,"BankAccount2"));
            prpLinterPayRequestDto.setMobilePhone(dbManager.getString(resultSet,"MobilePhone"));
            prpLinterPayRequestDto.setFamilyPhone(dbManager.getString(resultSet,"FamilyPhone"));
            prpLinterPayRequestDto.setOfficePhone(dbManager.getString(resultSet,"OfficePhone"));
            prpLinterPayRequestDto.setAddress(dbManager.getString(resultSet,"Address"));
            prpLinterPayRequestDto.setQqNumber(dbManager.getString(resultSet,"QqNumber"));
            prpLinterPayRequestDto.setEmail(dbManager.getString(resultSet,"Email"));
            prpLinterPayRequestDto.setUnitLink(dbManager.getString(resultSet,"UnitLink"));
            prpLinterPayRequestDto.setPostCode(dbManager.getString(resultSet,"PostCode"));
            prpLinterPayRequestDto.setPayWay(dbManager.getString(resultSet,"PayWay"));
            prpLinterPayRequestDto.setPayReason(dbManager.getString(resultSet,"PayReason"));
            prpLinterPayRequestDto.setPayPurpose(dbManager.getString(resultSet,"PayPurpose"));
            prpLinterPayRequestDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLinterPayRequestDto.setOperatorName(dbManager.getString(resultSet,"OperatorName"));
            prpLinterPayRequestDto.setMakeCom(dbManager.getString(resultSet,"MakeCom"));
            prpLinterPayRequestDto.setMakeComName(dbManager.getString(resultSet,"MakeComName"));
            prpLinterPayRequestDto.setOperatorDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"OperatorDate"));
            prpLinterPayRequestDto.setHandleText(dbManager.getString(resultSet,"HandleText"));
            prpLinterPayRequestDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prpLinterPayRequestDto.setAccountFlag(dbManager.getString(resultSet,"AccountFlag"));
            prpLinterPayRequestDto.setAutoFlag(dbManager.getString(resultSet,"AutoFlag"));
            prpLinterPayRequestDto.setHandleDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"HandleDate"));
            prpLinterPayRequestDto.setHandleCode(dbManager.getString(resultSet,"HandleCode"));
            prpLinterPayRequestDto.setSeriousInterType(dbManager.getString(resultSet, "SeriousInterType"));
            collection.add(prpLinterPayRequestDto);
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
        buffer.append("DELETE FROM PrpLinterPayRequest WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPayRequest WHERE ");
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
