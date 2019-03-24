package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer_idv个人客户代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerIdvBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcustomerIdvBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcustomerIdvBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void insert(PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        String statement = " Insert Into PrpDcustomer_idv(" + 
                           " CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerFlag," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " LinkAddress," + 
                           " PostCode," + 
                           " Pager," + 
                           " Email," + 
                           " Bank," + 
                           " Account," + 
                           " DeathDate," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcustomer_idvDto.getCustomerCode());
        dbManager.setString(2,prpDcustomer_idvDto.getShortHandCode());
        dbManager.setString(3,prpDcustomer_idvDto.getCustomerCName());
        dbManager.setString(4,prpDcustomer_idvDto.getCustomerEName());
        dbManager.setString(5,prpDcustomer_idvDto.getAddressCName());
        dbManager.setString(6,prpDcustomer_idvDto.getAddressEName());
        dbManager.setString(7,prpDcustomer_idvDto.getIdentifyNumber());
        dbManager.setString(8,prpDcustomer_idvDto.getCreditLevel());
        dbManager.setString(9,prpDcustomer_idvDto.getSex());
        dbManager.setInt(10,prpDcustomer_idvDto.getAge());
        dbManager.setString(11,prpDcustomer_idvDto.getHealth());
        dbManager.setString(12,prpDcustomer_idvDto.getOccupationCode());
        dbManager.setString(13,prpDcustomer_idvDto.getEducationCode());
        dbManager.setString(14,prpDcustomer_idvDto.getUnit());
        dbManager.setString(15,prpDcustomer_idvDto.getUnitAddress());
        dbManager.setString(16,prpDcustomer_idvDto.getCustomerFlag());
        dbManager.setString(17,prpDcustomer_idvDto.getPhoneNumber());
        dbManager.setString(18,prpDcustomer_idvDto.getFaxNumber());
        dbManager.setString(19,prpDcustomer_idvDto.getMobile());
        dbManager.setString(20,prpDcustomer_idvDto.getLinkAddress());
        dbManager.setString(21,prpDcustomer_idvDto.getPostCode());
        dbManager.setString(22,prpDcustomer_idvDto.getPager());
        dbManager.setString(23,prpDcustomer_idvDto.getEmail());
        dbManager.setString(24,prpDcustomer_idvDto.getBank());
        dbManager.setString(25,prpDcustomer_idvDto.getAccount());
        dbManager.setDateTime(26,prpDcustomer_idvDto.getDeathDate());
        dbManager.setString(27,prpDcustomer_idvDto.getBlackState());
        dbManager.setString(28,prpDcustomer_idvDto.getNewCustomerCode());
        dbManager.setString(29,prpDcustomer_idvDto.getValidStatus());
        dbManager.setString(30,prpDcustomer_idvDto.getArticleCode());
        dbManager.setString(31,prpDcustomer_idvDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomer_idvBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcustomerIdvDto prpDcustomer_idvDto = (PrpDcustomerIdvDto)i.next();
            insert(prpDcustomer_idvDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param customerCode 客户代码
     * @throws Exception
     */
    public void delete(String customerCode) throws Exception{
        String statement = " Delete From PrpDcustomer_idv Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcustomer_idvBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void update(PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        String statement = " Update PrpDcustomer_idv Set ShortHandCode = ?," + 
                           " CustomerCName = ?," + 
                           " CustomerEName = ?," + 
                           " AddressCName = ?," + 
                           " AddressEName = ?," + 
                           " IdentifyNumber = ?," + 
                           " CreditLevel = ?," + 
                           " Sex = ?," + 
                           " Age = ?," + 
                           " Health = ?," + 
                           " OccupationCode = ?," + 
                           " EducationCode = ?," + 
                           " Unit = ?," + 
                           " UnitAddress = ?," + 
                           " CustomerFlag = ?," + 
                           " PhoneNumber = ?," + 
                           " FaxNumber = ?," + 
                           " Mobile = ?," + 
                           " LinkAddress = ?," + 
                           " PostCode = ?," + 
                           " Pager = ?," + 
                           " Email = ?," + 
                           " Bank = ?," + 
                           " Account = ?," + 
                           " DeathDate = ?," + 
                           " BlackState = ?," + 
                           " NewCustomerCode = ?," + 
                           " ValidStatus = ?," + 
                           " ArticleCode = ?," + 
                           " Flag = ? Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDcustomer_idvDto.getShortHandCode());
        dbManager.setString(2,prpDcustomer_idvDto.getCustomerCName());
        dbManager.setString(3,prpDcustomer_idvDto.getCustomerEName());
        dbManager.setString(4,prpDcustomer_idvDto.getAddressCName());
        dbManager.setString(5,prpDcustomer_idvDto.getAddressEName());
        dbManager.setString(6,prpDcustomer_idvDto.getIdentifyNumber());
        dbManager.setString(7,prpDcustomer_idvDto.getCreditLevel());
        dbManager.setString(8,prpDcustomer_idvDto.getSex());
        dbManager.setInt(9,prpDcustomer_idvDto.getAge());
        dbManager.setString(10,prpDcustomer_idvDto.getHealth());
        dbManager.setString(11,prpDcustomer_idvDto.getOccupationCode());
        dbManager.setString(12,prpDcustomer_idvDto.getEducationCode());
        dbManager.setString(13,prpDcustomer_idvDto.getUnit());
        dbManager.setString(14,prpDcustomer_idvDto.getUnitAddress());
        dbManager.setString(15,prpDcustomer_idvDto.getCustomerFlag());
        dbManager.setString(16,prpDcustomer_idvDto.getPhoneNumber());
        dbManager.setString(17,prpDcustomer_idvDto.getFaxNumber());
        dbManager.setString(18,prpDcustomer_idvDto.getMobile());
        dbManager.setString(19,prpDcustomer_idvDto.getLinkAddress());
        dbManager.setString(20,prpDcustomer_idvDto.getPostCode());
        dbManager.setString(21,prpDcustomer_idvDto.getPager());
        dbManager.setString(22,prpDcustomer_idvDto.getEmail());
        dbManager.setString(23,prpDcustomer_idvDto.getBank());
        dbManager.setString(24,prpDcustomer_idvDto.getAccount());
        dbManager.setDateTime(25,prpDcustomer_idvDto.getDeathDate());
        dbManager.setString(26,prpDcustomer_idvDto.getBlackState());
        dbManager.setString(27,prpDcustomer_idvDto.getNewCustomerCode());
        dbManager.setString(28,prpDcustomer_idvDto.getValidStatus());
        dbManager.setString(29,prpDcustomer_idvDto.getArticleCode());
        dbManager.setString(30,prpDcustomer_idvDto.getFlag());
        //设置条件字段;
        dbManager.setString(31,prpDcustomer_idvDto.getCustomerCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomer_idvBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param customerCode 客户代码
     * @return PrpDcustomerIdvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(String customerCode) throws Exception{
        String statement = " Select CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerFlag," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " LinkAddress," + 
                           " PostCode," + 
                           " Pager," + 
                           " Email," + 
                           " Bank," + 
                           " Account," + 
                           " DeathDate," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDcustomer_idv Where " +
                           " CustomerCode = ?";
        PrpDcustomerIdvDto prpDcustomer_idvDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcustomer_idvDto = new PrpDcustomerIdvDto();
            prpDcustomer_idvDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomer_idvDto.setShortHandCode(dbManager.getString(resultSet,2));
            prpDcustomer_idvDto.setCustomerCName(dbManager.getString(resultSet,3));
            prpDcustomer_idvDto.setCustomerEName(dbManager.getString(resultSet,4));
            prpDcustomer_idvDto.setAddressCName(dbManager.getString(resultSet,5));
            prpDcustomer_idvDto.setAddressEName(dbManager.getString(resultSet,6));
            prpDcustomer_idvDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpDcustomer_idvDto.setCreditLevel(dbManager.getString(resultSet,8));
            prpDcustomer_idvDto.setSex(dbManager.getString(resultSet,9));
            prpDcustomer_idvDto.setAge(dbManager.getInt(resultSet,10));
            prpDcustomer_idvDto.setHealth(dbManager.getString(resultSet,11));
            prpDcustomer_idvDto.setOccupationCode(dbManager.getString(resultSet,12));
            prpDcustomer_idvDto.setEducationCode(dbManager.getString(resultSet,13));
            prpDcustomer_idvDto.setUnit(dbManager.getString(resultSet,14));
            prpDcustomer_idvDto.setUnitAddress(dbManager.getString(resultSet,15));
            prpDcustomer_idvDto.setCustomerFlag(dbManager.getString(resultSet,16));
            prpDcustomer_idvDto.setPhoneNumber(dbManager.getString(resultSet,17));
            prpDcustomer_idvDto.setFaxNumber(dbManager.getString(resultSet,18));
            prpDcustomer_idvDto.setMobile(dbManager.getString(resultSet,19));
            prpDcustomer_idvDto.setLinkAddress(dbManager.getString(resultSet,20));
            prpDcustomer_idvDto.setPostCode(dbManager.getString(resultSet,21));
            prpDcustomer_idvDto.setPager(dbManager.getString(resultSet,22));
            prpDcustomer_idvDto.setEmail(dbManager.getString(resultSet,23));
            prpDcustomer_idvDto.setBank(dbManager.getString(resultSet,24));
            prpDcustomer_idvDto.setAccount(dbManager.getString(resultSet,25));
            prpDcustomer_idvDto.setDeathDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpDcustomer_idvDto.setBlackState(dbManager.getString(resultSet,27));
            prpDcustomer_idvDto.setNewCustomerCode(dbManager.getString(resultSet,28));
            prpDcustomer_idvDto.setValidStatus(dbManager.getString(resultSet,29));
            prpDcustomer_idvDto.setArticleCode(dbManager.getString(resultSet,30));
            prpDcustomer_idvDto.setFlag(dbManager.getString(resultSet,31));
        }
        resultSet.close();
        log.info("DBPrpDcustomer_idvBase.findByPrimaryKey() success!");
        return prpDcustomer_idvDto;
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
        String statement = "Select CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerFlag," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " LinkAddress," + 
                           " PostCode," + 
                           " Pager," + 
                           " Email," + 
                           " Bank," + 
                           " Account," + 
                           " DeathDate," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDcustomer_idv Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcustomerIdvDto prpDcustomer_idvDto = null;
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

            prpDcustomer_idvDto = new PrpDcustomerIdvDto();
            prpDcustomer_idvDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomer_idvDto.setShortHandCode(dbManager.getString(resultSet,2));
            prpDcustomer_idvDto.setCustomerCName(dbManager.getString(resultSet,3));
            prpDcustomer_idvDto.setCustomerEName(dbManager.getString(resultSet,4));
            prpDcustomer_idvDto.setAddressCName(dbManager.getString(resultSet,5));
            prpDcustomer_idvDto.setAddressEName(dbManager.getString(resultSet,6));
            prpDcustomer_idvDto.setIdentifyNumber(dbManager.getString(resultSet,7));
            prpDcustomer_idvDto.setCreditLevel(dbManager.getString(resultSet,8));
            prpDcustomer_idvDto.setSex(dbManager.getString(resultSet,9));
            prpDcustomer_idvDto.setAge(dbManager.getInt(resultSet,10));
            prpDcustomer_idvDto.setHealth(dbManager.getString(resultSet,11));
            prpDcustomer_idvDto.setOccupationCode(dbManager.getString(resultSet,12));
            prpDcustomer_idvDto.setEducationCode(dbManager.getString(resultSet,13));
            prpDcustomer_idvDto.setUnit(dbManager.getString(resultSet,14));
            prpDcustomer_idvDto.setUnitAddress(dbManager.getString(resultSet,15));
            prpDcustomer_idvDto.setCustomerFlag(dbManager.getString(resultSet,16));
            prpDcustomer_idvDto.setPhoneNumber(dbManager.getString(resultSet,17));
            prpDcustomer_idvDto.setFaxNumber(dbManager.getString(resultSet,18));
            prpDcustomer_idvDto.setMobile(dbManager.getString(resultSet,19));
            prpDcustomer_idvDto.setLinkAddress(dbManager.getString(resultSet,20));
            prpDcustomer_idvDto.setPostCode(dbManager.getString(resultSet,21));
            prpDcustomer_idvDto.setPager(dbManager.getString(resultSet,22));
            prpDcustomer_idvDto.setEmail(dbManager.getString(resultSet,23));
            prpDcustomer_idvDto.setBank(dbManager.getString(resultSet,24));
            prpDcustomer_idvDto.setAccount(dbManager.getString(resultSet,25));
            prpDcustomer_idvDto.setDeathDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpDcustomer_idvDto.setBlackState(dbManager.getString(resultSet,27));
            prpDcustomer_idvDto.setNewCustomerCode(dbManager.getString(resultSet,28));
            prpDcustomer_idvDto.setValidStatus(dbManager.getString(resultSet,29));
            prpDcustomer_idvDto.setArticleCode(dbManager.getString(resultSet,30));
            prpDcustomer_idvDto.setFlag(dbManager.getString(resultSet,31));
            collection.add(prpDcustomer_idvDto);
        }
        resultSet.close();
        log.info("DBPrpDcustomer_idvBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcustomer_idv Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcustomer_idvBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcustomer_idv Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcustomer_idvBase.getCount() success!");
        return count;
    }
}
