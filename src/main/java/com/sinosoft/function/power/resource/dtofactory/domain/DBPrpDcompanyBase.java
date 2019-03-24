package com.sinosoft.function.power.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcompany机构代码表的数据访问对象基类<br>
 * 创建于 2004-11-09 18:30:40.428<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcompanyBase{
    protected DBManager dbManager = null; //资源管理类
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
    public void insert(PrpDcompanyDto prpDcompanyDto) throws Exception{
        String mainStatement = " Insert Into PrpDcompany (" + 
                           " ComCode," + 
                           " ComCName," + 
                           " ComEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " TaxNumber," + 
                           " UpperComCode," + 
                           " InsurerName," + 
                           " ComAttribute," + 
                           " Manager," + 
                           " AccountLeader," + 
                           " Cashier," + 
                           " ComType," + 
                           " ComLevel," + 
                           " Accountant," + 
                           " Remark," + 
                           " NewComCode," + 
                           " ValidStatus," + 
                           " AcntUnit," + 
                           " ArticleCode," + 
                           " AccCode," + 
                           " CenterFlag," + 
                           " OuterPayCode," + 
                           " InnerPayCode," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpDcompanyDto.getComCode() + "'," + 
                           "'" + prpDcompanyDto.getComCName() + "'," + 
                           "'" + prpDcompanyDto.getComEName() + "'," + 
                           "'" + prpDcompanyDto.getAddressCName() + "'," + 
                           "'" + prpDcompanyDto.getAddressEName() + "'," + 
                           "'" + prpDcompanyDto.getPostCode() + "'," + 
                           "'" + prpDcompanyDto.getPhoneNumber() + "'," + 
                           "'" + prpDcompanyDto.getFaxNumber() + "'," + 
                           "'" + prpDcompanyDto.getTaxNumber() + "'," + 
                           "'" + prpDcompanyDto.getUpperComCode() + "'," + 
                           "'" + prpDcompanyDto.getInsurerName() + "'," + 
                           "'" + prpDcompanyDto.getComAttribute() + "'," + 
                           "'" + prpDcompanyDto.getManager() + "'," + 
                           "'" + prpDcompanyDto.getAccountLeader() + "'," + 
                           "'" + prpDcompanyDto.getCashier() + "'," + 
                           "'" + prpDcompanyDto.getComType() + "'," + 
                           "'" + prpDcompanyDto.getComLevel() + "'," + 
                           "'" + prpDcompanyDto.getAccountant() + "'," + 
                           "'" + prpDcompanyDto.getRemark() + "'," + 
                           "'" + prpDcompanyDto.getNewComCode() + "'," + 
                           "'" + prpDcompanyDto.getValidStatus() + "'," + 
                           "'" + prpDcompanyDto.getAcntUnit() + "'," + 
                           "'" + prpDcompanyDto.getArticleCode() + "'," + 
                           "'" + prpDcompanyDto.getAccCode() + "'," + 
                           "'" + prpDcompanyDto.getCenterFlag() + "'," + 
                           "'" + prpDcompanyDto.getOuterPayCode() + "'," + 
                           "'" + prpDcompanyDto.getInnerPayCode() + "'," + 
                           "'" + prpDcompanyDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcompanyDto.getComCode());
        dbManager.setString(2,prpDcompanyDto.getComCName());
        dbManager.setString(3,prpDcompanyDto.getComEName());
        dbManager.setString(4,prpDcompanyDto.getAddressCName());
        dbManager.setString(5,prpDcompanyDto.getAddressEName());
        dbManager.setString(6,prpDcompanyDto.getPostCode());
        dbManager.setString(7,prpDcompanyDto.getPhoneNumber());
        dbManager.setString(8,prpDcompanyDto.getFaxNumber());
        dbManager.setString(9,prpDcompanyDto.getTaxNumber());
        dbManager.setString(10,prpDcompanyDto.getUpperComCode());
        dbManager.setString(11,prpDcompanyDto.getInsurerName());
        dbManager.setString(12,prpDcompanyDto.getComAttribute());
        dbManager.setString(13,prpDcompanyDto.getManager());
        dbManager.setString(14,prpDcompanyDto.getAccountLeader());
        dbManager.setString(15,prpDcompanyDto.getCashier());
        dbManager.setString(16,prpDcompanyDto.getComType());
        dbManager.setString(17,prpDcompanyDto.getComLevel());
        dbManager.setString(18,prpDcompanyDto.getAccountant());
        dbManager.setString(19,prpDcompanyDto.getRemark());
        dbManager.setString(20,prpDcompanyDto.getNewComCode());
        dbManager.setString(21,prpDcompanyDto.getValidStatus());
        dbManager.setString(22,prpDcompanyDto.getAcntUnit());
        dbManager.setString(23,prpDcompanyDto.getArticleCode());
        dbManager.setString(24,prpDcompanyDto.getAccCode());
        dbManager.setString(25,prpDcompanyDto.getCenterFlag());
        dbManager.setString(26,prpDcompanyDto.getOuterPayCode());
        dbManager.setString(27,prpDcompanyDto.getInnerPayCode());
        dbManager.setString(28,prpDcompanyDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDcompanyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)i.next();
            insert(prpDcompanyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param comCode ComCode
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        String statement = " Delete From PrpDcompany" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpDcompany Where " +
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpDcompanyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void update(PrpDcompanyDto prpDcompanyDto) throws Exception{
        String statement = " Update PrpDcompany Set ComCName = ?," + 
                           " ComEName = ?," + 
                           " AddressCName = ?," + 
                           " AddressEName = ?," + 
                           " PostCode = ?," + 
                           " PhoneNumber = ?," + 
                           " FaxNumber = ?," + 
                           " TaxNumber = ?," + 
                           " UpperComCode = ?," + 
                           " InsurerName = ?," + 
                           " ComAttribute = ?," + 
                           " Manager = ?," + 
                           " AccountLeader = ?," + 
                           " Cashier = ?," + 
                           " ComType = ?," + 
                           " ComLevel = ?," + 
                           " Accountant = ?," + 
                           " Remark = ?," + 
                           " NewComCode = ?," + 
                           " ValidStatus = ?," + 
                           " AcntUnit = ?," + 
                           " ArticleCode = ?," + 
                           " AccCode = ?," + 
                           " CenterFlag = ?," + 
                           " OuterPayCode = ?," + 
                           " InnerPayCode = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpDcompany Set " + 
                           " ComCode = '" + prpDcompanyDto.getComCode() + "'," + 
                           " ComCName = '" + prpDcompanyDto.getComCName() + "'," + 
                           " ComEName = '" + prpDcompanyDto.getComEName() + "'," + 
                           " AddressCName = '" + prpDcompanyDto.getAddressCName() + "'," + 
                           " AddressEName = '" + prpDcompanyDto.getAddressEName() + "'," + 
                           " PostCode = '" + prpDcompanyDto.getPostCode() + "'," + 
                           " PhoneNumber = '" + prpDcompanyDto.getPhoneNumber() + "'," + 
                           " FaxNumber = '" + prpDcompanyDto.getFaxNumber() + "'," + 
                           " TaxNumber = '" + prpDcompanyDto.getTaxNumber() + "'," + 
                           " UpperComCode = '" + prpDcompanyDto.getUpperComCode() + "'," + 
                           " InsurerName = '" + prpDcompanyDto.getInsurerName() + "'," + 
                           " ComAttribute = '" + prpDcompanyDto.getComAttribute() + "'," + 
                           " Manager = '" + prpDcompanyDto.getManager() + "'," + 
                           " AccountLeader = '" + prpDcompanyDto.getAccountLeader() + "'," + 
                           " Cashier = '" + prpDcompanyDto.getCashier() + "'," + 
                           " ComType = '" + prpDcompanyDto.getComType() + "'," + 
                           " ComLevel = '" + prpDcompanyDto.getComLevel() + "'," + 
                           " Accountant = '" + prpDcompanyDto.getAccountant() + "'," + 
                           " Remark = '" + prpDcompanyDto.getRemark() + "'," + 
                           " NewComCode = '" + prpDcompanyDto.getNewComCode() + "'," + 
                           " ValidStatus = '" + prpDcompanyDto.getValidStatus() + "'," + 
                           " AcntUnit = '" + prpDcompanyDto.getAcntUnit() + "'," + 
                           " ArticleCode = '" + prpDcompanyDto.getArticleCode() + "'," + 
                           " AccCode = '" + prpDcompanyDto.getAccCode() + "'," + 
                           " CenterFlag = '" + prpDcompanyDto.getCenterFlag() + "'," + 
                           " OuterPayCode = '" + prpDcompanyDto.getOuterPayCode() + "'," + 
                           " InnerPayCode = '" + prpDcompanyDto.getInnerPayCode() + "'," + 
                           " Flag = '" + prpDcompanyDto.getFlag() + "'" + 
			               " Where " +
                           " ComCode = '" + prpDcompanyDto.getComCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDcompanyDto.getComCName());
        dbManager.setString(2,prpDcompanyDto.getComEName());
        dbManager.setString(3,prpDcompanyDto.getAddressCName());
        dbManager.setString(4,prpDcompanyDto.getAddressEName());
        dbManager.setString(5,prpDcompanyDto.getPostCode());
        dbManager.setString(6,prpDcompanyDto.getPhoneNumber());
        dbManager.setString(7,prpDcompanyDto.getFaxNumber());
        dbManager.setString(8,prpDcompanyDto.getTaxNumber());
        dbManager.setString(9,prpDcompanyDto.getUpperComCode());
        dbManager.setString(10,prpDcompanyDto.getInsurerName());
        dbManager.setString(11,prpDcompanyDto.getComAttribute());
        dbManager.setString(12,prpDcompanyDto.getManager());
        dbManager.setString(13,prpDcompanyDto.getAccountLeader());
        dbManager.setString(14,prpDcompanyDto.getCashier());
        dbManager.setString(15,prpDcompanyDto.getComType());
        dbManager.setString(16,prpDcompanyDto.getComLevel());
        dbManager.setString(17,prpDcompanyDto.getAccountant());
        dbManager.setString(18,prpDcompanyDto.getRemark());
        dbManager.setString(19,prpDcompanyDto.getNewComCode());
        dbManager.setString(20,prpDcompanyDto.getValidStatus());
        dbManager.setString(21,prpDcompanyDto.getAcntUnit());
        dbManager.setString(22,prpDcompanyDto.getArticleCode());
        dbManager.setString(23,prpDcompanyDto.getAccCode());
        dbManager.setString(24,prpDcompanyDto.getCenterFlag());
        dbManager.setString(25,prpDcompanyDto.getOuterPayCode());
        dbManager.setString(26,prpDcompanyDto.getInnerPayCode());
        dbManager.setString(27,prpDcompanyDto.getFlag());
        //设置条件字段;
        dbManager.setString(28,prpDcompanyDto.getComCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDcompanyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param comCode ComCode
     * @return PrpDcompanyDto
     * @throws Exception
     */
    public PrpDcompanyDto findByPrimaryKey(String comCode) throws Exception{
        String mainStatement = " Select ComCode," + 
                           " ComCName," + 
                           " ComEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " TaxNumber," + 
                           " UpperComCode," + 
                           " InsurerName," + 
                           " ComAttribute," + 
                           " Manager," + 
                           " AccountLeader," + 
                           " Cashier," + 
                           " ComType," + 
                           " ComLevel," + 
                           " Accountant," + 
                           " Remark," + 
                           " NewComCode," + 
                           " ValidStatus," + 
                           " AcntUnit," + 
                           " ArticleCode," + 
                           " AccCode," + 
                           " CenterFlag," + 
                           " OuterPayCode," + 
                           " InnerPayCode," + 
                           " Flag From PrpDcompany";
        String statement = mainStatement + " Where " +
                           " ComCode = ?";
        PrpDcompanyDto prpDcompanyDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcompanyDto = new PrpDcompanyDto();
            prpDcompanyDto.setComCode(dbManager.getString(resultSet,1));
            prpDcompanyDto.setComCName(dbManager.getString(resultSet,2));
            prpDcompanyDto.setComEName(dbManager.getString(resultSet,3));
            prpDcompanyDto.setAddressCName(dbManager.getString(resultSet,4));
            prpDcompanyDto.setAddressEName(dbManager.getString(resultSet,5));
            prpDcompanyDto.setPostCode(dbManager.getString(resultSet,6));
            prpDcompanyDto.setPhoneNumber(dbManager.getString(resultSet,7));
            prpDcompanyDto.setFaxNumber(dbManager.getString(resultSet,8));
            prpDcompanyDto.setTaxNumber(dbManager.getString(resultSet,9));
            prpDcompanyDto.setUpperComCode(dbManager.getString(resultSet,10));
            prpDcompanyDto.setInsurerName(dbManager.getString(resultSet,11));
            prpDcompanyDto.setComAttribute(dbManager.getString(resultSet,12));
            prpDcompanyDto.setManager(dbManager.getString(resultSet,13));
            prpDcompanyDto.setAccountLeader(dbManager.getString(resultSet,14));
            prpDcompanyDto.setCashier(dbManager.getString(resultSet,15));
            prpDcompanyDto.setComType(dbManager.getString(resultSet,16));
            prpDcompanyDto.setComLevel(dbManager.getString(resultSet,17));
            prpDcompanyDto.setAccountant(dbManager.getString(resultSet,18));
            prpDcompanyDto.setRemark(dbManager.getString(resultSet,19));
            prpDcompanyDto.setNewComCode(dbManager.getString(resultSet,20));
            prpDcompanyDto.setValidStatus(dbManager.getString(resultSet,21));
            prpDcompanyDto.setAcntUnit(dbManager.getString(resultSet,22));
            prpDcompanyDto.setArticleCode(dbManager.getString(resultSet,23));
            prpDcompanyDto.setAccCode(dbManager.getString(resultSet,24));
            prpDcompanyDto.setCenterFlag(dbManager.getString(resultSet,25));
            prpDcompanyDto.setOuterPayCode(dbManager.getString(resultSet,26));
            prpDcompanyDto.setInnerPayCode(dbManager.getString(resultSet,27));
            prpDcompanyDto.setFlag(dbManager.getString(resultSet,28));
        }
        resultSet.close();
        logger.info("DBPrpDcompanyBase.findByPrimaryKey() success!");
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
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ComCode," + 
                           " ComCName," + 
                           " ComEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " PostCode," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " TaxNumber," + 
                           " UpperComCode," + 
                           " InsurerName," + 
                           " ComAttribute," + 
                           " Manager," + 
                           " AccountLeader," + 
                           " Cashier," + 
                           " ComType," + 
                           " ComLevel," + 
                           " Accountant," + 
                           " Remark," + 
                           " NewComCode," + 
                           " ValidStatus," + 
                           " AcntUnit," + 
                           " ArticleCode," + 
                           " AccCode," + 
                           " CenterFlag," + 
                           " OuterPayCode," + 
                           " InnerPayCode," + 
                           " Flag From PrpDcompany Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpDcompanyDto prpDcompanyDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

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
            prpDcompanyDto.setFaxNumber(dbManager.getString(resultSet,8));
            prpDcompanyDto.setTaxNumber(dbManager.getString(resultSet,9));
            prpDcompanyDto.setUpperComCode(dbManager.getString(resultSet,10));
            prpDcompanyDto.setInsurerName(dbManager.getString(resultSet,11));
            prpDcompanyDto.setComAttribute(dbManager.getString(resultSet,12));
            prpDcompanyDto.setManager(dbManager.getString(resultSet,13));
            prpDcompanyDto.setAccountLeader(dbManager.getString(resultSet,14));
            prpDcompanyDto.setCashier(dbManager.getString(resultSet,15));
            prpDcompanyDto.setComType(dbManager.getString(resultSet,16));
            prpDcompanyDto.setComLevel(dbManager.getString(resultSet,17));
            prpDcompanyDto.setAccountant(dbManager.getString(resultSet,18));
            prpDcompanyDto.setRemark(dbManager.getString(resultSet,19));
            prpDcompanyDto.setNewComCode(dbManager.getString(resultSet,20));
            prpDcompanyDto.setValidStatus(dbManager.getString(resultSet,21));
            prpDcompanyDto.setAcntUnit(dbManager.getString(resultSet,22));
            prpDcompanyDto.setArticleCode(dbManager.getString(resultSet,23));
            prpDcompanyDto.setAccCode(dbManager.getString(resultSet,24));
            prpDcompanyDto.setCenterFlag(dbManager.getString(resultSet,25));
            prpDcompanyDto.setOuterPayCode(dbManager.getString(resultSet,26));
            prpDcompanyDto.setInnerPayCode(dbManager.getString(resultSet,27));
            prpDcompanyDto.setFlag(dbManager.getString(resultSet,28));
            collection.add(prpDcompanyDto);
        }
        resultSet.close();
        logger.info("DBPrpDcompanyBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpDcompany Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpDcompanyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcompany Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpDcompanyBase.getCount() success!");
        return count;
    }
}
