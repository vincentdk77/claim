package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDcompany的数据访问对象基类<br>
 * 创建于 2006-03-07 16:50:46.234<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDcompanyBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpDcompanyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcompanyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void insert(PrpDcompanyDto prpDcompanyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDcompany (");
        buffer.append("ComCode,");
        buffer.append("ComCName,");
        buffer.append("ComEName,");
        buffer.append("AddressCName,");
        buffer.append("AddressEName,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("TaxNumber,");
        buffer.append("FaxNumber,");
        buffer.append("UpperComCode,");
        buffer.append("InsurerName,");
        buffer.append("ComAttribute,");
        buffer.append("ComType,");
        buffer.append("ComLevel,");
        buffer.append("Manager,");
        buffer.append("AccountLeader,");
        buffer.append("Cashier,");
        buffer.append("Accountant,");
        buffer.append("Remark,");
        buffer.append("NewComCode,");
        buffer.append("ValidStatus,");
        buffer.append("AcntUnit,");
        buffer.append("ArticleCode,");
        buffer.append("Acccode,");
        buffer.append("CenterFlag,");
        buffer.append("OuterPayCode,");
        buffer.append("InnerPayCode,");
        buffer.append("Flag,");
        buffer.append("WebAddress,");
        buffer.append("ServicePhone,");
        buffer.append("ReportPhone,");
        buffer.append("SysAreaCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpDcompanyDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getComCName()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getComEName()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAddressCName()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAddressEName()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getPostCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getPhoneNumber()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getTaxNumber()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getFaxNumber()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getUpperComCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getInsurerName()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getComAttribute()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getComType()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getComLevel()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getManager()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAccountLeader()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getCashier()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAccountant()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getNewComCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAcntUnit()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getArticleCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getAcccode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getCenterFlag()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getOuterPayCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getInnerPayCode()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getWebAddress()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getServicePhone()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getReportPhone()).append("',");
            debugBuffer.append("'").append(prpDcompanyDto.getSysAreaCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpDcompanyDto.getComCode());
        dbManager.setString(2,prpDcompanyDto.getComCName());
        dbManager.setString(3,prpDcompanyDto.getComEName());
        dbManager.setString(4,prpDcompanyDto.getAddressCName());
        dbManager.setString(5,prpDcompanyDto.getAddressEName());
        dbManager.setString(6,prpDcompanyDto.getPostCode());
        dbManager.setString(7,prpDcompanyDto.getPhoneNumber());
        dbManager.setString(8,prpDcompanyDto.getTaxNumber());
        dbManager.setString(9,prpDcompanyDto.getFaxNumber());
        dbManager.setString(10,prpDcompanyDto.getUpperComCode());
        dbManager.setString(11,prpDcompanyDto.getInsurerName());
        dbManager.setString(12,prpDcompanyDto.getComAttribute());
        dbManager.setString(13,prpDcompanyDto.getComType());
        dbManager.setString(14,prpDcompanyDto.getComLevel());
        dbManager.setString(15,prpDcompanyDto.getManager());
        dbManager.setString(16,prpDcompanyDto.getAccountLeader());
        dbManager.setString(17,prpDcompanyDto.getCashier());
        dbManager.setString(18,prpDcompanyDto.getAccountant());
        dbManager.setString(19,prpDcompanyDto.getRemark());
        dbManager.setString(20,prpDcompanyDto.getNewComCode());
        dbManager.setString(21,prpDcompanyDto.getValidStatus());
        dbManager.setString(22,prpDcompanyDto.getAcntUnit());
        dbManager.setString(23,prpDcompanyDto.getArticleCode());
        dbManager.setString(24,prpDcompanyDto.getAcccode());
        dbManager.setString(25,prpDcompanyDto.getCenterFlag());
        dbManager.setString(26,prpDcompanyDto.getOuterPayCode());
        dbManager.setString(27,prpDcompanyDto.getInnerPayCode());
        dbManager.setString(28,prpDcompanyDto.getFlag());
        dbManager.setString(29,prpDcompanyDto.getWebAddress());
        dbManager.setString(30,prpDcompanyDto.getServicePhone());
        dbManager.setString(31,prpDcompanyDto.getReportPhone());
        dbManager.setString(32,prpDcompanyDto.getSysAreaCode());
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
        buffer.append("INSERT INTO PrpDcompany (");
        buffer.append("ComCode,");
        buffer.append("ComCName,");
        buffer.append("ComEName,");
        buffer.append("AddressCName,");
        buffer.append("AddressEName,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("TaxNumber,");
        buffer.append("FaxNumber,");
        buffer.append("UpperComCode,");
        buffer.append("InsurerName,");
        buffer.append("ComAttribute,");
        buffer.append("ComType,");
        buffer.append("ComLevel,");
        buffer.append("Manager,");
        buffer.append("AccountLeader,");
        buffer.append("Cashier,");
        buffer.append("Accountant,");
        buffer.append("Remark,");
        buffer.append("NewComCode,");
        buffer.append("ValidStatus,");
        buffer.append("AcntUnit,");
        buffer.append("ArticleCode,");
        buffer.append("Acccode,");
        buffer.append("CenterFlag,");
        buffer.append("OuterPayCode,");
        buffer.append("InnerPayCode,");
        buffer.append("Flag,");
        buffer.append("WebAddress,");
        buffer.append("ServicePhone,");
        buffer.append("ReportPhone,");
        buffer.append("SysAreaCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)i.next();
            dbManager.setString(1,prpDcompanyDto.getComCode());
            dbManager.setString(2,prpDcompanyDto.getComCName());
            dbManager.setString(3,prpDcompanyDto.getComEName());
            dbManager.setString(4,prpDcompanyDto.getAddressCName());
            dbManager.setString(5,prpDcompanyDto.getAddressEName());
            dbManager.setString(6,prpDcompanyDto.getPostCode());
            dbManager.setString(7,prpDcompanyDto.getPhoneNumber());
            dbManager.setString(8,prpDcompanyDto.getTaxNumber());
            dbManager.setString(9,prpDcompanyDto.getFaxNumber());
            dbManager.setString(10,prpDcompanyDto.getUpperComCode());
            dbManager.setString(11,prpDcompanyDto.getInsurerName());
            dbManager.setString(12,prpDcompanyDto.getComAttribute());
            dbManager.setString(13,prpDcompanyDto.getComType());
            dbManager.setString(14,prpDcompanyDto.getComLevel());
            dbManager.setString(15,prpDcompanyDto.getManager());
            dbManager.setString(16,prpDcompanyDto.getAccountLeader());
            dbManager.setString(17,prpDcompanyDto.getCashier());
            dbManager.setString(18,prpDcompanyDto.getAccountant());
            dbManager.setString(19,prpDcompanyDto.getRemark());
            dbManager.setString(20,prpDcompanyDto.getNewComCode());
            dbManager.setString(21,prpDcompanyDto.getValidStatus());
            dbManager.setString(22,prpDcompanyDto.getAcntUnit());
            dbManager.setString(23,prpDcompanyDto.getArticleCode());
            dbManager.setString(24,prpDcompanyDto.getAcccode());
            dbManager.setString(25,prpDcompanyDto.getCenterFlag());
            dbManager.setString(26,prpDcompanyDto.getOuterPayCode());
            dbManager.setString(27,prpDcompanyDto.getInnerPayCode());
            dbManager.setString(28,prpDcompanyDto.getFlag());
            dbManager.setString(29,prpDcompanyDto.getWebAddress());
            dbManager.setString(30,prpDcompanyDto.getServicePhone());
            dbManager.setString(31,prpDcompanyDto.getReportPhone());
            dbManager.setString(32,prpDcompanyDto.getSysAreaCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param comCode COMCODE
     * @throws Exception
     */
    public void delete(String comCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDcompany ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ComCode=").append("'").append(comCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ComCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void update(PrpDcompanyDto prpDcompanyDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpDcompany SET ");
        buffer.append("ComCName = ?, ");
        buffer.append("ComEName = ?, ");
        buffer.append("AddressCName = ?, ");
        buffer.append("AddressEName = ?, ");
        buffer.append("PostCode = ?, ");
        buffer.append("PhoneNumber = ?, ");
        buffer.append("TaxNumber = ?, ");
        buffer.append("FaxNumber = ?, ");
        buffer.append("UpperComCode = ?, ");
        buffer.append("InsurerName = ?, ");
        buffer.append("ComAttribute = ?, ");
        buffer.append("ComType = ?, ");
        buffer.append("ComLevel = ?, ");
        buffer.append("Manager = ?, ");
        buffer.append("AccountLeader = ?, ");
        buffer.append("Cashier = ?, ");
        buffer.append("Accountant = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("NewComCode = ?, ");
        buffer.append("ValidStatus = ?, ");
        buffer.append("AcntUnit = ?, ");
        buffer.append("ArticleCode = ?, ");
        buffer.append("Acccode = ?, ");
        buffer.append("CenterFlag = ?, ");
        buffer.append("OuterPayCode = ?, ");
        buffer.append("InnerPayCode = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("WebAddress = ?, ");
        buffer.append("ServicePhone = ?, ");
        buffer.append("ReportPhone = ?, ");
        buffer.append("SysAreaCode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpDcompany SET ");
            debugBuffer.append("ComCName = '" + prpDcompanyDto.getComCName() + "', ");
            debugBuffer.append("ComEName = '" + prpDcompanyDto.getComEName() + "', ");
            debugBuffer.append("AddressCName = '" + prpDcompanyDto.getAddressCName() + "', ");
            debugBuffer.append("AddressEName = '" + prpDcompanyDto.getAddressEName() + "', ");
            debugBuffer.append("PostCode = '" + prpDcompanyDto.getPostCode() + "', ");
            debugBuffer.append("PhoneNumber = '" + prpDcompanyDto.getPhoneNumber() + "', ");
            debugBuffer.append("TaxNumber = '" + prpDcompanyDto.getTaxNumber() + "', ");
            debugBuffer.append("FaxNumber = '" + prpDcompanyDto.getFaxNumber() + "', ");
            debugBuffer.append("UpperComCode = '" + prpDcompanyDto.getUpperComCode() + "', ");
            debugBuffer.append("InsurerName = '" + prpDcompanyDto.getInsurerName() + "', ");
            debugBuffer.append("ComAttribute = '" + prpDcompanyDto.getComAttribute() + "', ");
            debugBuffer.append("ComType = '" + prpDcompanyDto.getComType() + "', ");
            debugBuffer.append("ComLevel = '" + prpDcompanyDto.getComLevel() + "', ");
            debugBuffer.append("Manager = '" + prpDcompanyDto.getManager() + "', ");
            debugBuffer.append("AccountLeader = '" + prpDcompanyDto.getAccountLeader() + "', ");
            debugBuffer.append("Cashier = '" + prpDcompanyDto.getCashier() + "', ");
            debugBuffer.append("Accountant = '" + prpDcompanyDto.getAccountant() + "', ");
            debugBuffer.append("Remark = '" + prpDcompanyDto.getRemark() + "', ");
            debugBuffer.append("NewComCode = '" + prpDcompanyDto.getNewComCode() + "', ");
            debugBuffer.append("ValidStatus = '" + prpDcompanyDto.getValidStatus() + "', ");
            debugBuffer.append("AcntUnit = '" + prpDcompanyDto.getAcntUnit() + "', ");
            debugBuffer.append("ArticleCode = '" + prpDcompanyDto.getArticleCode() + "', ");
            debugBuffer.append("Acccode = '" + prpDcompanyDto.getAcccode() + "', ");
            debugBuffer.append("CenterFlag = '" + prpDcompanyDto.getCenterFlag() + "', ");
            debugBuffer.append("OuterPayCode = '" + prpDcompanyDto.getOuterPayCode() + "', ");
            debugBuffer.append("InnerPayCode = '" + prpDcompanyDto.getInnerPayCode() + "', ");
            debugBuffer.append("Flag = '" + prpDcompanyDto.getFlag() + "', ");
            debugBuffer.append("WebAddress = '" + prpDcompanyDto.getWebAddress() + "', ");
            debugBuffer.append("ServicePhone = '" + prpDcompanyDto.getServicePhone() + "', ");
            debugBuffer.append("ReportPhone = '" + prpDcompanyDto.getReportPhone() + "', ");
            debugBuffer.append("SysAreaCode = '" + prpDcompanyDto.getSysAreaCode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ComCode=").append("'").append(prpDcompanyDto.getComCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ComCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpDcompanyDto.getComCName());
        dbManager.setString(2,prpDcompanyDto.getComEName());
        dbManager.setString(3,prpDcompanyDto.getAddressCName());
        dbManager.setString(4,prpDcompanyDto.getAddressEName());
        dbManager.setString(5,prpDcompanyDto.getPostCode());
        dbManager.setString(6,prpDcompanyDto.getPhoneNumber());
        dbManager.setString(7,prpDcompanyDto.getTaxNumber());
        dbManager.setString(8,prpDcompanyDto.getFaxNumber());
        dbManager.setString(9,prpDcompanyDto.getUpperComCode());
        dbManager.setString(10,prpDcompanyDto.getInsurerName());
        dbManager.setString(11,prpDcompanyDto.getComAttribute());
        dbManager.setString(12,prpDcompanyDto.getComType());
        dbManager.setString(13,prpDcompanyDto.getComLevel());
        dbManager.setString(14,prpDcompanyDto.getManager());
        dbManager.setString(15,prpDcompanyDto.getAccountLeader());
        dbManager.setString(16,prpDcompanyDto.getCashier());
        dbManager.setString(17,prpDcompanyDto.getAccountant());
        dbManager.setString(18,prpDcompanyDto.getRemark());
        dbManager.setString(19,prpDcompanyDto.getNewComCode());
        dbManager.setString(20,prpDcompanyDto.getValidStatus());
        dbManager.setString(21,prpDcompanyDto.getAcntUnit());
        dbManager.setString(22,prpDcompanyDto.getArticleCode());
        dbManager.setString(23,prpDcompanyDto.getAcccode());
        dbManager.setString(24,prpDcompanyDto.getCenterFlag());
        dbManager.setString(25,prpDcompanyDto.getOuterPayCode());
        dbManager.setString(26,prpDcompanyDto.getInnerPayCode());
        dbManager.setString(27,prpDcompanyDto.getFlag());
        dbManager.setString(28,prpDcompanyDto.getWebAddress());
        dbManager.setString(29,prpDcompanyDto.getServicePhone());
        dbManager.setString(30,prpDcompanyDto.getReportPhone());
        dbManager.setString(31,prpDcompanyDto.getSysAreaCode());
        //设置条件字段;
        dbManager.setString(32,prpDcompanyDto.getComCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param comCode COMCODE
     * @return PrpDcompanyDto
     * @throws Exception
     */
    public PrpDcompanyDto findByPrimaryKey(String comCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ComCode,");
        buffer.append("ComCName,");
        buffer.append("ComEName,");
        buffer.append("AddressCName,");
        buffer.append("AddressEName,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("TaxNumber,");
        buffer.append("FaxNumber,");
        buffer.append("UpperComCode,");
        buffer.append("InsurerName,");
        buffer.append("ComAttribute,");
        buffer.append("ComType,");
        buffer.append("ComLevel,");
        buffer.append("Manager,");
        buffer.append("AccountLeader,");
        buffer.append("Cashier,");
        buffer.append("Accountant,");
        buffer.append("Remark,");
        buffer.append("NewComCode,");
        buffer.append("ValidStatus,");
        buffer.append("AcntUnit,");
        buffer.append("ArticleCode,");
        buffer.append("Acccode,");
        buffer.append("CenterFlag,");
        buffer.append("OuterPayCode,");
        buffer.append("InnerPayCode,");
        buffer.append("Flag,");
        buffer.append("WebAddress,");
        buffer.append("ServicePhone,");
        buffer.append("ReportPhone,");
        buffer.append("SysAreaCode,");
        buffer.append("CityCode ");
        buffer.append("FROM PrpDcompany ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ComCode=").append("'").append(comCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ComCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpDcompanyDto prpDcompanyDto = null;
        if(resultSet.next()){
            prpDcompanyDto = new PrpDcompanyDto();
            prpDcompanyDto.setComCode(dbManager.getString(resultSet,1));
            prpDcompanyDto.setComCName(dbManager.getString(resultSet,2));
            prpDcompanyDto.setComEName(dbManager.getString(resultSet,3));
            prpDcompanyDto.setAddressCName(dbManager.getString(resultSet,4));
            prpDcompanyDto.setAddressEName(dbManager.getString(resultSet,5));
            prpDcompanyDto.setPostCode(dbManager.getString(resultSet,6));
            prpDcompanyDto.setPhoneNumber(dbManager.getString(resultSet,7));
            prpDcompanyDto.setTaxNumber(dbManager.getString(resultSet,8));
            prpDcompanyDto.setFaxNumber(dbManager.getString(resultSet,9));
            prpDcompanyDto.setUpperComCode(dbManager.getString(resultSet,10));
            prpDcompanyDto.setInsurerName(dbManager.getString(resultSet,11));
            prpDcompanyDto.setComAttribute(dbManager.getString(resultSet,12));
            prpDcompanyDto.setComType(dbManager.getString(resultSet,13));
            prpDcompanyDto.setComLevel(dbManager.getString(resultSet,14));
            prpDcompanyDto.setManager(dbManager.getString(resultSet,15));
            prpDcompanyDto.setAccountLeader(dbManager.getString(resultSet,16));
            prpDcompanyDto.setCashier(dbManager.getString(resultSet,17));
            prpDcompanyDto.setAccountant(dbManager.getString(resultSet,18));
            prpDcompanyDto.setRemark(dbManager.getString(resultSet,19));
            prpDcompanyDto.setNewComCode(dbManager.getString(resultSet,20));
            prpDcompanyDto.setValidStatus(dbManager.getString(resultSet,21));
            prpDcompanyDto.setAcntUnit(dbManager.getString(resultSet,22));
            prpDcompanyDto.setArticleCode(dbManager.getString(resultSet,23));
            prpDcompanyDto.setAcccode(dbManager.getString(resultSet,24));
            prpDcompanyDto.setCenterFlag(dbManager.getString(resultSet,25));
            prpDcompanyDto.setOuterPayCode(dbManager.getString(resultSet,26));
            prpDcompanyDto.setInnerPayCode(dbManager.getString(resultSet,27));
            prpDcompanyDto.setFlag(dbManager.getString(resultSet,28));
            prpDcompanyDto.setWebAddress(dbManager.getString(resultSet,29));
            prpDcompanyDto.setServicePhone(dbManager.getString(resultSet,30));
            prpDcompanyDto.setReportPhone(dbManager.getString(resultSet,31));
            prpDcompanyDto.setSysAreaCode(dbManager.getString(resultSet,32));
            prpDcompanyDto.setCityCode(dbManager.getString(resultSet,33));
        }
        resultSet.close();
        return prpDcompanyDto;
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
        buffer.append("ComCode,");
        buffer.append("ComCName,");
        buffer.append("ComEName,");
        buffer.append("AddressCName,");
        buffer.append("AddressEName,");
        buffer.append("PostCode,");
        buffer.append("PhoneNumber,");
        buffer.append("TaxNumber,");
        buffer.append("FaxNumber,");
        buffer.append("UpperComCode,");
        buffer.append("InsurerName,");
        buffer.append("ComAttribute,");
        buffer.append("ComType,");
        buffer.append("ComLevel,");
        buffer.append("Manager,");
        buffer.append("AccountLeader,");
        buffer.append("Cashier,");
        buffer.append("Accountant,");
        buffer.append("Remark,");
        buffer.append("NewComCode,");
        buffer.append("ValidStatus,");
        buffer.append("AcntUnit,");
        buffer.append("ArticleCode,");
        buffer.append("Acccode,");
        buffer.append("CenterFlag,");
        buffer.append("OuterPayCode,");
        buffer.append("InnerPayCode,");
        buffer.append("Flag,");
        buffer.append("WebAddress,");
        buffer.append("ServicePhone,");
        buffer.append("ReportPhone,");
        buffer.append("SysAreaCode,");
        buffer.append("CityCode ");
        buffer.append("FROM PrpDcompany WHERE ");
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
        PrpDcompanyDto prpDcompanyDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpDcompanyDto = new PrpDcompanyDto();
            prpDcompanyDto.setComCode(dbManager.getString(resultSet,1));
            prpDcompanyDto.setComCName(dbManager.getString(resultSet,2));
            prpDcompanyDto.setComEName(dbManager.getString(resultSet,3));
            prpDcompanyDto.setAddressCName(dbManager.getString(resultSet,4));
            prpDcompanyDto.setAddressEName(dbManager.getString(resultSet,5));
            prpDcompanyDto.setPostCode(dbManager.getString(resultSet,6));
            prpDcompanyDto.setPhoneNumber(dbManager.getString(resultSet,7));
            prpDcompanyDto.setTaxNumber(dbManager.getString(resultSet,8));
            prpDcompanyDto.setFaxNumber(dbManager.getString(resultSet,9));
            prpDcompanyDto.setUpperComCode(dbManager.getString(resultSet,10));
            prpDcompanyDto.setInsurerName(dbManager.getString(resultSet,11));
            prpDcompanyDto.setComAttribute(dbManager.getString(resultSet,12));
            prpDcompanyDto.setComType(dbManager.getString(resultSet,13));
            prpDcompanyDto.setComLevel(dbManager.getString(resultSet,14));
            prpDcompanyDto.setManager(dbManager.getString(resultSet,15));
            prpDcompanyDto.setAccountLeader(dbManager.getString(resultSet,16));
            prpDcompanyDto.setCashier(dbManager.getString(resultSet,17));
            prpDcompanyDto.setAccountant(dbManager.getString(resultSet,18));
            prpDcompanyDto.setRemark(dbManager.getString(resultSet,19));
            prpDcompanyDto.setNewComCode(dbManager.getString(resultSet,20));
            prpDcompanyDto.setValidStatus(dbManager.getString(resultSet,21));
            prpDcompanyDto.setAcntUnit(dbManager.getString(resultSet,22));
            prpDcompanyDto.setArticleCode(dbManager.getString(resultSet,23));
            prpDcompanyDto.setAcccode(dbManager.getString(resultSet,24));
            prpDcompanyDto.setCenterFlag(dbManager.getString(resultSet,25));
            prpDcompanyDto.setOuterPayCode(dbManager.getString(resultSet,26));
            prpDcompanyDto.setInnerPayCode(dbManager.getString(resultSet,27));
            prpDcompanyDto.setFlag(dbManager.getString(resultSet,28));
            prpDcompanyDto.setWebAddress(dbManager.getString(resultSet,29));
            prpDcompanyDto.setServicePhone(dbManager.getString(resultSet,30));
            prpDcompanyDto.setReportPhone(dbManager.getString(resultSet,31));
            prpDcompanyDto.setSysAreaCode(dbManager.getString(resultSet,32));
            prpDcompanyDto.setCityCode(dbManager.getString(resultSet,33));
            collection.add(prpDcompanyDto);
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
        buffer.append("DELETE FROM PrpDcompany WHERE ");
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
        String  statement;
            statement = "SELECT count(1) FROM PrpDcompany WHERE ";
              statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
