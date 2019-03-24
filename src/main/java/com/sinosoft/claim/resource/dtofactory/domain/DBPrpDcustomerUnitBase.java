package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcustomerUnit单位客户代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerUnitBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcustomerUnitBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcustomerUnitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void insert(PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        String statement = " Insert Into PrpDcustomerUnit(" + 
                           " CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " OrganizeCode," + 
                           " CreditLevel," + 
                           " LeaderName," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " NetAddress," + 
                           " EmailAddress," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " LinkerName," + 
                           " Bank," + 
                           " Account," + 
                           " IndustryCode," + 
                           " EconomyCode," + 
                           " MeasureCode," + 
                           " FatherCode," + 
                           " SponsorName," + 
                           " BusinessRange," + 
                           " RegistFund," + 
                           " RegionCode," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,PrpDcustomerUnitDto.getCustomerCode());
        dbManager.setString(2,PrpDcustomerUnitDto.getShortHandCode());
        dbManager.setString(3,PrpDcustomerUnitDto.getCustomerCName());
        dbManager.setString(4,PrpDcustomerUnitDto.getCustomerEName());
        dbManager.setString(5,PrpDcustomerUnitDto.getAddressCName());
        dbManager.setString(6,PrpDcustomerUnitDto.getAddressEName());
        dbManager.setString(7,PrpDcustomerUnitDto.getPossessNature());
        dbManager.setString(8,PrpDcustomerUnitDto.getBusinessSource());
        dbManager.setString(9,PrpDcustomerUnitDto.getBusinessSort());
        dbManager.setString(10,PrpDcustomerUnitDto.getCustomerKind());
        dbManager.setString(11,PrpDcustomerUnitDto.getCustomerFlag());
        dbManager.setString(12,PrpDcustomerUnitDto.getOrganizeCode());
        dbManager.setString(13,PrpDcustomerUnitDto.getCreditLevel());
        dbManager.setString(14,PrpDcustomerUnitDto.getLeaderName());
        dbManager.setString(15,PrpDcustomerUnitDto.getPhoneNumber());
        dbManager.setString(16,PrpDcustomerUnitDto.getFaxNumber());
        dbManager.setString(17,PrpDcustomerUnitDto.getMobile());
        dbManager.setString(18,PrpDcustomerUnitDto.getNetAddress());
        dbManager.setString(19,PrpDcustomerUnitDto.getEmailAddress());
        dbManager.setString(20,PrpDcustomerUnitDto.getPostAddress());
        dbManager.setString(21,PrpDcustomerUnitDto.getPostCode());
        dbManager.setString(22,PrpDcustomerUnitDto.getLinkerName());
        dbManager.setString(23,PrpDcustomerUnitDto.getBank());
        dbManager.setString(24,PrpDcustomerUnitDto.getAccount());
        dbManager.setString(25,PrpDcustomerUnitDto.getIndustryCode());
        dbManager.setString(26,PrpDcustomerUnitDto.getEconomyCode());
        dbManager.setString(27,PrpDcustomerUnitDto.getMeasureCode());
        dbManager.setString(28,PrpDcustomerUnitDto.getFatherCode());
        dbManager.setString(29,PrpDcustomerUnitDto.getSponsorName());
        dbManager.setString(30,PrpDcustomerUnitDto.getBusinessRange());
        dbManager.setDouble(31,PrpDcustomerUnitDto.getRegistFund());
        dbManager.setString(32,PrpDcustomerUnitDto.getRegionCode());
        dbManager.setString(33,PrpDcustomerUnitDto.getBlackState());
        dbManager.setString(34,PrpDcustomerUnitDto.getNewCustomerCode());
        dbManager.setString(35,PrpDcustomerUnitDto.getValidStatus());
        dbManager.setString(36,PrpDcustomerUnitDto.getArticleCode());
        dbManager.setString(37,PrpDcustomerUnitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerUnitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcustomerUnitDto PrpDcustomerUnitDto = (PrpDcustomerUnitDto)i.next();
            insert(PrpDcustomerUnitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param customerCode 客户代码
     * @throws Exception
     */
    public void delete(String customerCode) throws Exception{
        String statement = " Delete From PrpDcustomerUnit Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcustomerUnitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void update(PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        String statement = " Update PrpDcustomerUnit Set ShortHandCode = ?," + 
                           " CustomerCName = ?," + 
                           " CustomerEName = ?," + 
                           " AddressCName = ?," + 
                           " AddressEName = ?," + 
                           " PossessNature = ?," + 
                           " BusinessSource = ?," + 
                           " BusinessSort = ?," + 
                           " CustomerKind = ?," + 
                           " CustomerFlag = ?," + 
                           " OrganizeCode = ?," + 
                           " CreditLevel = ?," + 
                           " LeaderName = ?," + 
                           " PhoneNumber = ?," + 
                           " FaxNumber = ?," + 
                           " Mobile = ?," + 
                           " NetAddress = ?," + 
                           " EmailAddress = ?," + 
                           " PostAddress = ?," + 
                           " PostCode = ?," + 
                           " LinkerName = ?," + 
                           " Bank = ?," + 
                           " Account = ?," + 
                           " IndustryCode = ?," + 
                           " EconomyCode = ?," + 
                           " MeasureCode = ?," + 
                           " FatherCode = ?," + 
                           " SponsorName = ?," + 
                           " BusinessRange = ?," + 
                           " RegistFund = ?," + 
                           " RegionCode = ?," + 
                           " BlackState = ?," + 
                           " NewCustomerCode = ?," + 
                           " ValidStatus = ?," + 
                           " ArticleCode = ?," + 
                           " Flag = ? Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,PrpDcustomerUnitDto.getShortHandCode());
        dbManager.setString(2,PrpDcustomerUnitDto.getCustomerCName());
        dbManager.setString(3,PrpDcustomerUnitDto.getCustomerEName());
        dbManager.setString(4,PrpDcustomerUnitDto.getAddressCName());
        dbManager.setString(5,PrpDcustomerUnitDto.getAddressEName());
        dbManager.setString(6,PrpDcustomerUnitDto.getPossessNature());
        dbManager.setString(7,PrpDcustomerUnitDto.getBusinessSource());
        dbManager.setString(8,PrpDcustomerUnitDto.getBusinessSort());
        dbManager.setString(9,PrpDcustomerUnitDto.getCustomerKind());
        dbManager.setString(10,PrpDcustomerUnitDto.getCustomerFlag());
        dbManager.setString(11,PrpDcustomerUnitDto.getOrganizeCode());
        dbManager.setString(12,PrpDcustomerUnitDto.getCreditLevel());
        dbManager.setString(13,PrpDcustomerUnitDto.getLeaderName());
        dbManager.setString(14,PrpDcustomerUnitDto.getPhoneNumber());
        dbManager.setString(15,PrpDcustomerUnitDto.getFaxNumber());
        dbManager.setString(16,PrpDcustomerUnitDto.getMobile());
        dbManager.setString(17,PrpDcustomerUnitDto.getNetAddress());
        dbManager.setString(18,PrpDcustomerUnitDto.getEmailAddress());
        dbManager.setString(19,PrpDcustomerUnitDto.getPostAddress());
        dbManager.setString(20,PrpDcustomerUnitDto.getPostCode());
        dbManager.setString(21,PrpDcustomerUnitDto.getLinkerName());
        dbManager.setString(22,PrpDcustomerUnitDto.getBank());
        dbManager.setString(23,PrpDcustomerUnitDto.getAccount());
        dbManager.setString(24,PrpDcustomerUnitDto.getIndustryCode());
        dbManager.setString(25,PrpDcustomerUnitDto.getEconomyCode());
        dbManager.setString(26,PrpDcustomerUnitDto.getMeasureCode());
        dbManager.setString(27,PrpDcustomerUnitDto.getFatherCode());
        dbManager.setString(28,PrpDcustomerUnitDto.getSponsorName());
        dbManager.setString(29,PrpDcustomerUnitDto.getBusinessRange());
        dbManager.setDouble(30,PrpDcustomerUnitDto.getRegistFund());
        dbManager.setString(31,PrpDcustomerUnitDto.getRegionCode());
        dbManager.setString(32,PrpDcustomerUnitDto.getBlackState());
        dbManager.setString(33,PrpDcustomerUnitDto.getNewCustomerCode());
        dbManager.setString(34,PrpDcustomerUnitDto.getValidStatus());
        dbManager.setString(35,PrpDcustomerUnitDto.getArticleCode());
        dbManager.setString(36,PrpDcustomerUnitDto.getFlag());
        //设置条件字段;
        dbManager.setString(37,PrpDcustomerUnitDto.getCustomerCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerUnitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param customerCode 客户代码
     * @return PrpDcustomerUnitDto
     * @throws Exception
     */
    public PrpDcustomerUnitDto findByPrimaryKey(String customerCode) throws Exception{
        String statement = " Select CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " OrganizeCode," + 
                           " CreditLevel," + 
                           " LeaderName," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " NetAddress," + 
                           " EmailAddress," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " LinkerName," + 
                           " Bank," + 
                           " Account," + 
                           " IndustryCode," + 
                           " EconomyCode," + 
                           " MeasureCode," + 
                           " FatherCode," + 
                           " SponsorName," + 
                           " BusinessRange," + 
                           " RegistFund," + 
                           " RegionCode," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDcustomerUnit Where " +
                           " CustomerCode = ?";
        PrpDcustomerUnitDto PrpDcustomerUnitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            PrpDcustomerUnitDto = new PrpDcustomerUnitDto();
            PrpDcustomerUnitDto.setCustomerCode(dbManager.getString(resultSet,1));
            PrpDcustomerUnitDto.setShortHandCode(dbManager.getString(resultSet,2));
            PrpDcustomerUnitDto.setCustomerCName(dbManager.getString(resultSet,3));
            PrpDcustomerUnitDto.setCustomerEName(dbManager.getString(resultSet,4));
            PrpDcustomerUnitDto.setAddressCName(dbManager.getString(resultSet,5));
            PrpDcustomerUnitDto.setAddressEName(dbManager.getString(resultSet,6));
            PrpDcustomerUnitDto.setPossessNature(dbManager.getString(resultSet,7));
            PrpDcustomerUnitDto.setBusinessSource(dbManager.getString(resultSet,8));
            PrpDcustomerUnitDto.setBusinessSort(dbManager.getString(resultSet,9));
            PrpDcustomerUnitDto.setCustomerKind(dbManager.getString(resultSet,10));
            PrpDcustomerUnitDto.setCustomerFlag(dbManager.getString(resultSet,11));
            PrpDcustomerUnitDto.setOrganizeCode(dbManager.getString(resultSet,12));
            PrpDcustomerUnitDto.setCreditLevel(dbManager.getString(resultSet,13));
            PrpDcustomerUnitDto.setLeaderName(dbManager.getString(resultSet,14));
            PrpDcustomerUnitDto.setPhoneNumber(dbManager.getString(resultSet,15));
            PrpDcustomerUnitDto.setFaxNumber(dbManager.getString(resultSet,16));
            PrpDcustomerUnitDto.setMobile(dbManager.getString(resultSet,17));
            PrpDcustomerUnitDto.setNetAddress(dbManager.getString(resultSet,18));
            PrpDcustomerUnitDto.setEmailAddress(dbManager.getString(resultSet,19));
            PrpDcustomerUnitDto.setPostAddress(dbManager.getString(resultSet,20));
            PrpDcustomerUnitDto.setPostCode(dbManager.getString(resultSet,21));
            PrpDcustomerUnitDto.setLinkerName(dbManager.getString(resultSet,22));
            PrpDcustomerUnitDto.setBank(dbManager.getString(resultSet,23));
            PrpDcustomerUnitDto.setAccount(dbManager.getString(resultSet,24));
            PrpDcustomerUnitDto.setIndustryCode(dbManager.getString(resultSet,25));
            PrpDcustomerUnitDto.setEconomyCode(dbManager.getString(resultSet,26));
            PrpDcustomerUnitDto.setMeasureCode(dbManager.getString(resultSet,27));
            PrpDcustomerUnitDto.setFatherCode(dbManager.getString(resultSet,28));
            PrpDcustomerUnitDto.setSponsorName(dbManager.getString(resultSet,29));
            PrpDcustomerUnitDto.setBusinessRange(dbManager.getString(resultSet,30));
            PrpDcustomerUnitDto.setRegistFund(dbManager.getDouble(resultSet,31));
            PrpDcustomerUnitDto.setRegionCode(dbManager.getString(resultSet,32));
            PrpDcustomerUnitDto.setBlackState(dbManager.getString(resultSet,33));
            PrpDcustomerUnitDto.setNewCustomerCode(dbManager.getString(resultSet,34));
            PrpDcustomerUnitDto.setValidStatus(dbManager.getString(resultSet,35));
            PrpDcustomerUnitDto.setArticleCode(dbManager.getString(resultSet,36));
            PrpDcustomerUnitDto.setFlag(dbManager.getString(resultSet,37));
        }
        resultSet.close();
        log.info("DBPrpDcustomerUnitBase.findByPrimaryKey() success!");
        return PrpDcustomerUnitDto;
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
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessSort," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " OrganizeCode," + 
                           " CreditLevel," + 
                           " LeaderName," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " Mobile," + 
                           " NetAddress," + 
                           " EmailAddress," + 
                           " PostAddress," + 
                           " PostCode," + 
                           " LinkerName," + 
                           " Bank," + 
                           " Account," + 
                           " IndustryCode," + 
                           " EconomyCode," + 
                           " MeasureCode," + 
                           " FatherCode," + 
                           " SponsorName," + 
                           " BusinessRange," + 
                           " RegistFund," + 
                           " RegionCode," + 
                           " BlackState," + 
                           " NewCustomerCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDcustomerUnit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcustomerUnitDto PrpDcustomerUnitDto = null;
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

            PrpDcustomerUnitDto = new PrpDcustomerUnitDto();
            PrpDcustomerUnitDto.setCustomerCode(dbManager.getString(resultSet,1));
            PrpDcustomerUnitDto.setShortHandCode(dbManager.getString(resultSet,2));
            PrpDcustomerUnitDto.setCustomerCName(dbManager.getString(resultSet,3));
            PrpDcustomerUnitDto.setCustomerEName(dbManager.getString(resultSet,4));
            PrpDcustomerUnitDto.setAddressCName(dbManager.getString(resultSet,5));
            PrpDcustomerUnitDto.setAddressEName(dbManager.getString(resultSet,6));
            PrpDcustomerUnitDto.setPossessNature(dbManager.getString(resultSet,7));
            PrpDcustomerUnitDto.setBusinessSource(dbManager.getString(resultSet,8));
            PrpDcustomerUnitDto.setBusinessSort(dbManager.getString(resultSet,9));
            PrpDcustomerUnitDto.setCustomerKind(dbManager.getString(resultSet,10));
            PrpDcustomerUnitDto.setCustomerFlag(dbManager.getString(resultSet,11));
            PrpDcustomerUnitDto.setOrganizeCode(dbManager.getString(resultSet,12));
            PrpDcustomerUnitDto.setCreditLevel(dbManager.getString(resultSet,13));
            PrpDcustomerUnitDto.setLeaderName(dbManager.getString(resultSet,14));
            PrpDcustomerUnitDto.setPhoneNumber(dbManager.getString(resultSet,15));
            PrpDcustomerUnitDto.setFaxNumber(dbManager.getString(resultSet,16));
            PrpDcustomerUnitDto.setMobile(dbManager.getString(resultSet,17));
            PrpDcustomerUnitDto.setNetAddress(dbManager.getString(resultSet,18));
            PrpDcustomerUnitDto.setEmailAddress(dbManager.getString(resultSet,19));
            PrpDcustomerUnitDto.setPostAddress(dbManager.getString(resultSet,20));
            PrpDcustomerUnitDto.setPostCode(dbManager.getString(resultSet,21));
            PrpDcustomerUnitDto.setLinkerName(dbManager.getString(resultSet,22));
            PrpDcustomerUnitDto.setBank(dbManager.getString(resultSet,23));
            PrpDcustomerUnitDto.setAccount(dbManager.getString(resultSet,24));
            PrpDcustomerUnitDto.setIndustryCode(dbManager.getString(resultSet,25));
            PrpDcustomerUnitDto.setEconomyCode(dbManager.getString(resultSet,26));
            PrpDcustomerUnitDto.setMeasureCode(dbManager.getString(resultSet,27));
            PrpDcustomerUnitDto.setFatherCode(dbManager.getString(resultSet,28));
            PrpDcustomerUnitDto.setSponsorName(dbManager.getString(resultSet,29));
            PrpDcustomerUnitDto.setBusinessRange(dbManager.getString(resultSet,30));
            PrpDcustomerUnitDto.setRegistFund(dbManager.getDouble(resultSet,31));
            PrpDcustomerUnitDto.setRegionCode(dbManager.getString(resultSet,32));
            PrpDcustomerUnitDto.setBlackState(dbManager.getString(resultSet,33));
            PrpDcustomerUnitDto.setNewCustomerCode(dbManager.getString(resultSet,34));
            PrpDcustomerUnitDto.setValidStatus(dbManager.getString(resultSet,35));
            PrpDcustomerUnitDto.setArticleCode(dbManager.getString(resultSet,36));
            PrpDcustomerUnitDto.setFlag(dbManager.getString(resultSet,37));
            collection.add(PrpDcustomerUnitDto);
        }
        resultSet.close();
        log.info("DBPrpDcustomerUnitBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcustomerUnit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcustomerUnitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcustomerUnit Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcustomerUnitBase.getCount() success!");
        return count;
    }
}
