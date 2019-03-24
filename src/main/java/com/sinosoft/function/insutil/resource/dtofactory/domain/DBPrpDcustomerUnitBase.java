package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomerunit的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerUnitBase{
    protected DBManager dbManager = null; //资源管理类
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
     * @param prpDcustomerUnitDto prpDcustomerUnitDto
     * @throws Exception
     */
    public void insert(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception{
        String statement = " Insert Into PrpDcustomerUnit(" + 
                           " CustomerCode," + 
                           " Password," + 
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
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcustomerUnitDto.getCustomerCode());
        dbManager.setString(2,prpDcustomerUnitDto.getPassword());
        dbManager.setString(3,prpDcustomerUnitDto.getShortHandCode());
        dbManager.setString(4,prpDcustomerUnitDto.getCustomerCName());
        dbManager.setString(5,prpDcustomerUnitDto.getCustomerEName());
        dbManager.setString(6,prpDcustomerUnitDto.getAddressCName());
        dbManager.setString(7,prpDcustomerUnitDto.getAddressEName());
        dbManager.setString(8,prpDcustomerUnitDto.getPossessNature());
        dbManager.setString(9,prpDcustomerUnitDto.getBusinessSource());
        dbManager.setString(10,prpDcustomerUnitDto.getBusinessSort());
        dbManager.setString(11,prpDcustomerUnitDto.getCustomerKind());
        dbManager.setString(12,prpDcustomerUnitDto.getCustomerFlag());
        dbManager.setString(13,prpDcustomerUnitDto.getOrganizeCode());
        dbManager.setString(14,prpDcustomerUnitDto.getCreditLevel());
        dbManager.setString(15,prpDcustomerUnitDto.getLeaderName());
        dbManager.setString(16,prpDcustomerUnitDto.getPhoneNumber());
        dbManager.setString(17,prpDcustomerUnitDto.getFaxNumber());
        dbManager.setString(18,prpDcustomerUnitDto.getMobile());
        dbManager.setString(19,prpDcustomerUnitDto.getNetAddress());
        dbManager.setString(20,prpDcustomerUnitDto.getEmailAddress());
        dbManager.setString(21,prpDcustomerUnitDto.getPostAddress());
        dbManager.setString(22,prpDcustomerUnitDto.getPostCode());
        dbManager.setString(23,prpDcustomerUnitDto.getLinkerName());
        dbManager.setString(24,prpDcustomerUnitDto.getBank());
        dbManager.setString(25,prpDcustomerUnitDto.getAccount());
        dbManager.setString(26,prpDcustomerUnitDto.getIndustryCode());
        dbManager.setString(27,prpDcustomerUnitDto.getEconomyCode());
        dbManager.setString(28,prpDcustomerUnitDto.getMeasureCode());
        dbManager.setString(29,prpDcustomerUnitDto.getFatherCode());
        dbManager.setString(30,prpDcustomerUnitDto.getSponsorName());
        dbManager.setString(31,prpDcustomerUnitDto.getBusinessRange());
        dbManager.setDouble(32,prpDcustomerUnitDto.getRegistFund());
        dbManager.setString(33,prpDcustomerUnitDto.getRegionCode());
        dbManager.setString(34,prpDcustomerUnitDto.getBlackState());
        dbManager.setString(35,prpDcustomerUnitDto.getNewCustomerCode());
        dbManager.setString(36,prpDcustomerUnitDto.getValidStatus());
        dbManager.setString(37,prpDcustomerUnitDto.getArticleCode());
        dbManager.setString(38,prpDcustomerUnitDto.getFlag());
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
            PrpDcustomerUnitDto prpDcustomerUnitDto = (PrpDcustomerUnitDto)i.next();
            insert(prpDcustomerUnitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param customerCode customercode
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
     * @param prpDcustomerUnitDto prpDcustomerUnitDto
     * @throws Exception
     */
    public void update(PrpDcustomerUnitDto prpDcustomerUnitDto) throws Exception{
        String statement = " Update PrpDcustomerUnit Set Password = ?," + 
                           " ShortHandCode = ?," + 
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
        dbManager.setString(1,prpDcustomerUnitDto.getPassword());
        dbManager.setString(2,prpDcustomerUnitDto.getShortHandCode());
        dbManager.setString(3,prpDcustomerUnitDto.getCustomerCName());
        dbManager.setString(4,prpDcustomerUnitDto.getCustomerEName());
        dbManager.setString(5,prpDcustomerUnitDto.getAddressCName());
        dbManager.setString(6,prpDcustomerUnitDto.getAddressEName());
        dbManager.setString(7,prpDcustomerUnitDto.getPossessNature());
        dbManager.setString(8,prpDcustomerUnitDto.getBusinessSource());
        dbManager.setString(9,prpDcustomerUnitDto.getBusinessSort());
        dbManager.setString(10,prpDcustomerUnitDto.getCustomerKind());
        dbManager.setString(11,prpDcustomerUnitDto.getCustomerFlag());
        dbManager.setString(12,prpDcustomerUnitDto.getOrganizeCode());
        dbManager.setString(13,prpDcustomerUnitDto.getCreditLevel());
        dbManager.setString(14,prpDcustomerUnitDto.getLeaderName());
        dbManager.setString(15,prpDcustomerUnitDto.getPhoneNumber());
        dbManager.setString(16,prpDcustomerUnitDto.getFaxNumber());
        dbManager.setString(17,prpDcustomerUnitDto.getMobile());
        dbManager.setString(18,prpDcustomerUnitDto.getNetAddress());
        dbManager.setString(19,prpDcustomerUnitDto.getEmailAddress());
        dbManager.setString(20,prpDcustomerUnitDto.getPostAddress());
        dbManager.setString(21,prpDcustomerUnitDto.getPostCode());
        dbManager.setString(22,prpDcustomerUnitDto.getLinkerName());
        dbManager.setString(23,prpDcustomerUnitDto.getBank());
        dbManager.setString(24,prpDcustomerUnitDto.getAccount());
        dbManager.setString(25,prpDcustomerUnitDto.getIndustryCode());
        dbManager.setString(26,prpDcustomerUnitDto.getEconomyCode());
        dbManager.setString(27,prpDcustomerUnitDto.getMeasureCode());
        dbManager.setString(28,prpDcustomerUnitDto.getFatherCode());
        dbManager.setString(29,prpDcustomerUnitDto.getSponsorName());
        dbManager.setString(30,prpDcustomerUnitDto.getBusinessRange());
        dbManager.setDouble(31,prpDcustomerUnitDto.getRegistFund());
        dbManager.setString(32,prpDcustomerUnitDto.getRegionCode());
        dbManager.setString(33,prpDcustomerUnitDto.getBlackState());
        dbManager.setString(34,prpDcustomerUnitDto.getNewCustomerCode());
        dbManager.setString(35,prpDcustomerUnitDto.getValidStatus());
        dbManager.setString(36,prpDcustomerUnitDto.getArticleCode());
        dbManager.setString(37,prpDcustomerUnitDto.getFlag());
        //设置条件字段;
        dbManager.setString(38,prpDcustomerUnitDto.getCustomerCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerUnitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param customerCode customercode
     * @return PrpDcustomerUnitDto
     * @throws Exception
     */
    public PrpDcustomerUnitDto findByPrimaryKey(String customerCode) throws Exception{
        String statement = " Select CustomerCode," + 
                           " Password," + 
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
        PrpDcustomerUnitDto prpDcustomerUnitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcustomerUnitDto = new PrpDcustomerUnitDto();
            prpDcustomerUnitDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomerUnitDto.setPassword(dbManager.getString(resultSet,2));
            prpDcustomerUnitDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerUnitDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerUnitDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerUnitDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerUnitDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerUnitDto.setPossessNature(dbManager.getString(resultSet,8));
            prpDcustomerUnitDto.setBusinessSource(dbManager.getString(resultSet,9));
            prpDcustomerUnitDto.setBusinessSort(dbManager.getString(resultSet,10));
            prpDcustomerUnitDto.setCustomerKind(dbManager.getString(resultSet,11));
            prpDcustomerUnitDto.setCustomerFlag(dbManager.getString(resultSet,12));
            prpDcustomerUnitDto.setOrganizeCode(dbManager.getString(resultSet,13));
            prpDcustomerUnitDto.setCreditLevel(dbManager.getString(resultSet,14));
            prpDcustomerUnitDto.setLeaderName(dbManager.getString(resultSet,15));
            prpDcustomerUnitDto.setPhoneNumber(dbManager.getString(resultSet,16));
            prpDcustomerUnitDto.setFaxNumber(dbManager.getString(resultSet,17));
            prpDcustomerUnitDto.setMobile(dbManager.getString(resultSet,18));
            prpDcustomerUnitDto.setNetAddress(dbManager.getString(resultSet,19));
            prpDcustomerUnitDto.setEmailAddress(dbManager.getString(resultSet,20));
            prpDcustomerUnitDto.setPostAddress(dbManager.getString(resultSet,21));
            prpDcustomerUnitDto.setPostCode(dbManager.getString(resultSet,22));
            prpDcustomerUnitDto.setLinkerName(dbManager.getString(resultSet,23));
            prpDcustomerUnitDto.setBank(dbManager.getString(resultSet,24));
            prpDcustomerUnitDto.setAccount(dbManager.getString(resultSet,25));
            prpDcustomerUnitDto.setIndustryCode(dbManager.getString(resultSet,26));
            prpDcustomerUnitDto.setEconomyCode(dbManager.getString(resultSet,27));
            prpDcustomerUnitDto.setMeasureCode(dbManager.getString(resultSet,28));
            prpDcustomerUnitDto.setFatherCode(dbManager.getString(resultSet,29));
            prpDcustomerUnitDto.setSponsorName(dbManager.getString(resultSet,30));
            prpDcustomerUnitDto.setBusinessRange(dbManager.getString(resultSet,31));
            prpDcustomerUnitDto.setRegistFund(dbManager.getDouble(resultSet,32));
            prpDcustomerUnitDto.setRegionCode(dbManager.getString(resultSet,33));
            prpDcustomerUnitDto.setBlackState(dbManager.getString(resultSet,34));
            prpDcustomerUnitDto.setNewCustomerCode(dbManager.getString(resultSet,35));
            prpDcustomerUnitDto.setValidStatus(dbManager.getString(resultSet,36));
            prpDcustomerUnitDto.setArticleCode(dbManager.getString(resultSet,37));
            prpDcustomerUnitDto.setFlag(dbManager.getString(resultSet,38));
        }
        resultSet.close();
        log.info("DBPrpDcustomerUnitBase.findByPrimaryKey() success!");
        return prpDcustomerUnitDto;
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
                           " Password," + 
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
        PrpDcustomerUnitDto prpDcustomerUnitDto = null;
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

            prpDcustomerUnitDto = new PrpDcustomerUnitDto();
            prpDcustomerUnitDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomerUnitDto.setPassword(dbManager.getString(resultSet,2));
            prpDcustomerUnitDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerUnitDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerUnitDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerUnitDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerUnitDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerUnitDto.setPossessNature(dbManager.getString(resultSet,8));
            prpDcustomerUnitDto.setBusinessSource(dbManager.getString(resultSet,9));
            prpDcustomerUnitDto.setBusinessSort(dbManager.getString(resultSet,10));
            prpDcustomerUnitDto.setCustomerKind(dbManager.getString(resultSet,11));
            prpDcustomerUnitDto.setCustomerFlag(dbManager.getString(resultSet,12));
            prpDcustomerUnitDto.setOrganizeCode(dbManager.getString(resultSet,13));
            prpDcustomerUnitDto.setCreditLevel(dbManager.getString(resultSet,14));
            prpDcustomerUnitDto.setLeaderName(dbManager.getString(resultSet,15));
            prpDcustomerUnitDto.setPhoneNumber(dbManager.getString(resultSet,16));
            prpDcustomerUnitDto.setFaxNumber(dbManager.getString(resultSet,17));
            prpDcustomerUnitDto.setMobile(dbManager.getString(resultSet,18));
            prpDcustomerUnitDto.setNetAddress(dbManager.getString(resultSet,19));
            prpDcustomerUnitDto.setEmailAddress(dbManager.getString(resultSet,20));
            prpDcustomerUnitDto.setPostAddress(dbManager.getString(resultSet,21));
            prpDcustomerUnitDto.setPostCode(dbManager.getString(resultSet,22));
            prpDcustomerUnitDto.setLinkerName(dbManager.getString(resultSet,23));
            prpDcustomerUnitDto.setBank(dbManager.getString(resultSet,24));
            prpDcustomerUnitDto.setAccount(dbManager.getString(resultSet,25));
            prpDcustomerUnitDto.setIndustryCode(dbManager.getString(resultSet,26));
            prpDcustomerUnitDto.setEconomyCode(dbManager.getString(resultSet,27));
            prpDcustomerUnitDto.setMeasureCode(dbManager.getString(resultSet,28));
            prpDcustomerUnitDto.setFatherCode(dbManager.getString(resultSet,29));
            prpDcustomerUnitDto.setSponsorName(dbManager.getString(resultSet,30));
            prpDcustomerUnitDto.setBusinessRange(dbManager.getString(resultSet,31));
            prpDcustomerUnitDto.setRegistFund(dbManager.getDouble(resultSet,32));
            prpDcustomerUnitDto.setRegionCode(dbManager.getString(resultSet,33));
            prpDcustomerUnitDto.setBlackState(dbManager.getString(resultSet,34));
            prpDcustomerUnitDto.setNewCustomerCode(dbManager.getString(resultSet,35));
            prpDcustomerUnitDto.setValidStatus(dbManager.getString(resultSet,36));
            prpDcustomerUnitDto.setArticleCode(dbManager.getString(resultSet,37));
            prpDcustomerUnitDto.setFlag(dbManager.getString(resultSet,38));
            collection.add(prpDcustomerUnitDto);
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
        String statement = "Select count(*) from PrpDcustomerUnit Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcustomerUnitBase.getCount() success!");
        return count;
    }
}
