package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomeridv的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:45<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerIdvBase{
    protected DBManager dbManager = null; //资源管理类
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
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void insert(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        String statement = " Insert Into PrpDcustomerIdv(" + 
                           " CustomerCode," + 
                           " Password," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " IdentifyType," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerKind," + 
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
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcustomerIdvDto.getCustomerCode());
        dbManager.setString(2,prpDcustomerIdvDto.getPassword());
        dbManager.setString(3,prpDcustomerIdvDto.getShortHandCode());
        dbManager.setString(4,prpDcustomerIdvDto.getCustomerCName());
        dbManager.setString(5,prpDcustomerIdvDto.getCustomerEName());
        dbManager.setString(6,prpDcustomerIdvDto.getAddressCName());
        dbManager.setString(7,prpDcustomerIdvDto.getAddressEName());
        dbManager.setString(8,prpDcustomerIdvDto.getIdentifyType());
        dbManager.setString(9,prpDcustomerIdvDto.getIdentifyNumber());
        dbManager.setString(10,prpDcustomerIdvDto.getCreditLevel());
        dbManager.setString(11,prpDcustomerIdvDto.getSex());
        dbManager.setInt(12,prpDcustomerIdvDto.getAge());
        dbManager.setString(13,prpDcustomerIdvDto.getHealth());
        dbManager.setString(14,prpDcustomerIdvDto.getOccupationCode());
        dbManager.setString(15,prpDcustomerIdvDto.getEducationCode());
        dbManager.setString(16,prpDcustomerIdvDto.getUnit());
        dbManager.setString(17,prpDcustomerIdvDto.getUnitAddress());
        dbManager.setString(18,prpDcustomerIdvDto.getCustomerKind());
        dbManager.setString(19,prpDcustomerIdvDto.getCustomerFlag());
        dbManager.setString(20,prpDcustomerIdvDto.getPhoneNumber());
        dbManager.setString(21,prpDcustomerIdvDto.getFaxNumber());
        dbManager.setString(22,prpDcustomerIdvDto.getMobile());
        dbManager.setString(23,prpDcustomerIdvDto.getLinkAddress());
        dbManager.setString(24,prpDcustomerIdvDto.getPostCode());
        dbManager.setString(25,prpDcustomerIdvDto.getPager());
        dbManager.setString(26,prpDcustomerIdvDto.getEmail());
        dbManager.setString(27,prpDcustomerIdvDto.getBank());
        dbManager.setString(28,prpDcustomerIdvDto.getAccount());
        dbManager.setDateTime(29,prpDcustomerIdvDto.getDeathDate());
        dbManager.setString(30,prpDcustomerIdvDto.getBlackState());
        dbManager.setString(31,prpDcustomerIdvDto.getNewCustomerCode());
        dbManager.setString(32,prpDcustomerIdvDto.getValidStatus());
        dbManager.setString(33,prpDcustomerIdvDto.getArticleCode());
        dbManager.setString(34,prpDcustomerIdvDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerIdvBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcustomerIdvDto prpDcustomerIdvDto = (PrpDcustomerIdvDto)i.next();
            insert(prpDcustomerIdvDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param customerCode customercode
     * @throws Exception
     */
    public void delete(String customerCode) throws Exception{
        String statement = " Delete From PrpDcustomerIdv Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcustomerIdvBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcustomerIdvDto prpDcustomerIdvDto
     * @throws Exception
     */
    public void update(PrpDcustomerIdvDto prpDcustomerIdvDto) throws Exception{
        String statement = " Update PrpDcustomerIdv Set Password = ?," + 
                           " ShortHandCode = ?," + 
                           " CustomerCName = ?," + 
                           " CustomerEName = ?," + 
                           " AddressCName = ?," + 
                           " AddressEName = ?," + 
                           " IdentifyType = ?," + 
                           " IdentifyNumber = ?," + 
                           " CreditLevel = ?," + 
                           " Sex = ?," + 
                           " Age = ?," + 
                           " Health = ?," + 
                           " OccupationCode = ?," + 
                           " EducationCode = ?," + 
                           " Unit = ?," + 
                           " UnitAddress = ?," + 
                           " CustomerKind = ?," + 
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
        dbManager.setString(1,prpDcustomerIdvDto.getPassword());
        dbManager.setString(2,prpDcustomerIdvDto.getShortHandCode());
        dbManager.setString(3,prpDcustomerIdvDto.getCustomerCName());
        dbManager.setString(4,prpDcustomerIdvDto.getCustomerEName());
        dbManager.setString(5,prpDcustomerIdvDto.getAddressCName());
        dbManager.setString(6,prpDcustomerIdvDto.getAddressEName());
        dbManager.setString(7,prpDcustomerIdvDto.getIdentifyType());
        dbManager.setString(8,prpDcustomerIdvDto.getIdentifyNumber());
        dbManager.setString(9,prpDcustomerIdvDto.getCreditLevel());
        dbManager.setString(10,prpDcustomerIdvDto.getSex());
        dbManager.setInt(11,prpDcustomerIdvDto.getAge());
        dbManager.setString(12,prpDcustomerIdvDto.getHealth());
        dbManager.setString(13,prpDcustomerIdvDto.getOccupationCode());
        dbManager.setString(14,prpDcustomerIdvDto.getEducationCode());
        dbManager.setString(15,prpDcustomerIdvDto.getUnit());
        dbManager.setString(16,prpDcustomerIdvDto.getUnitAddress());
        dbManager.setString(17,prpDcustomerIdvDto.getCustomerKind());
        dbManager.setString(18,prpDcustomerIdvDto.getCustomerFlag());
        dbManager.setString(19,prpDcustomerIdvDto.getPhoneNumber());
        dbManager.setString(20,prpDcustomerIdvDto.getFaxNumber());
        dbManager.setString(21,prpDcustomerIdvDto.getMobile());
        dbManager.setString(22,prpDcustomerIdvDto.getLinkAddress());
        dbManager.setString(23,prpDcustomerIdvDto.getPostCode());
        dbManager.setString(24,prpDcustomerIdvDto.getPager());
        dbManager.setString(25,prpDcustomerIdvDto.getEmail());
        dbManager.setString(26,prpDcustomerIdvDto.getBank());
        dbManager.setString(27,prpDcustomerIdvDto.getAccount());
        dbManager.setDateTime(28,prpDcustomerIdvDto.getDeathDate());
        dbManager.setString(29,prpDcustomerIdvDto.getBlackState());
        dbManager.setString(30,prpDcustomerIdvDto.getNewCustomerCode());
        dbManager.setString(31,prpDcustomerIdvDto.getValidStatus());
        dbManager.setString(32,prpDcustomerIdvDto.getArticleCode());
        dbManager.setString(33,prpDcustomerIdvDto.getFlag());
        //设置条件字段;
        dbManager.setString(34,prpDcustomerIdvDto.getCustomerCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerIdvBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param customerCode customercode
     * @return PrpDcustomerIdvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(String customerCode) throws Exception{
        String statement = " Select CustomerCode," + 
                           " Password," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " IdentifyType," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerKind," + 
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
                           " Flag From PrpDcustomerIdv Where " +
                           " CustomerCode = ?";
        PrpDcustomerIdvDto prpDcustomerIdvDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcustomerIdvDto = new PrpDcustomerIdvDto();
            prpDcustomerIdvDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomerIdvDto.setPassword(dbManager.getString(resultSet,2));
            prpDcustomerIdvDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerIdvDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerIdvDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerIdvDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerIdvDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerIdvDto.setIdentifyType(dbManager.getString(resultSet,8));
            prpDcustomerIdvDto.setIdentifyNumber(dbManager.getString(resultSet,9));
            prpDcustomerIdvDto.setCreditLevel(dbManager.getString(resultSet,10));
            prpDcustomerIdvDto.setSex(dbManager.getString(resultSet,11));
            prpDcustomerIdvDto.setAge(dbManager.getInt(resultSet,12));
            prpDcustomerIdvDto.setHealth(dbManager.getString(resultSet,13));
            prpDcustomerIdvDto.setOccupationCode(dbManager.getString(resultSet,14));
            prpDcustomerIdvDto.setEducationCode(dbManager.getString(resultSet,15));
            prpDcustomerIdvDto.setUnit(dbManager.getString(resultSet,16));
            prpDcustomerIdvDto.setUnitAddress(dbManager.getString(resultSet,17));
            prpDcustomerIdvDto.setCustomerKind(dbManager.getString(resultSet,18));
            prpDcustomerIdvDto.setCustomerFlag(dbManager.getString(resultSet,19));
            prpDcustomerIdvDto.setPhoneNumber(dbManager.getString(resultSet,20));
            prpDcustomerIdvDto.setFaxNumber(dbManager.getString(resultSet,21));
            prpDcustomerIdvDto.setMobile(dbManager.getString(resultSet,22));
            prpDcustomerIdvDto.setLinkAddress(dbManager.getString(resultSet,23));
            prpDcustomerIdvDto.setPostCode(dbManager.getString(resultSet,24));
            prpDcustomerIdvDto.setPager(dbManager.getString(resultSet,25));
            prpDcustomerIdvDto.setEmail(dbManager.getString(resultSet,26));
            prpDcustomerIdvDto.setBank(dbManager.getString(resultSet,27));
            prpDcustomerIdvDto.setAccount(dbManager.getString(resultSet,28));
            prpDcustomerIdvDto.setDeathDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpDcustomerIdvDto.setBlackState(dbManager.getString(resultSet,30));
            prpDcustomerIdvDto.setNewCustomerCode(dbManager.getString(resultSet,31));
            prpDcustomerIdvDto.setValidStatus(dbManager.getString(resultSet,32));
            prpDcustomerIdvDto.setArticleCode(dbManager.getString(resultSet,33));
            prpDcustomerIdvDto.setFlag(dbManager.getString(resultSet,34));
        }
        resultSet.close();
        log.info("DBPrpDcustomerIdvBase.findByPrimaryKey() success!");
        return prpDcustomerIdvDto;
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
                           " IdentifyType," + 
                           " IdentifyNumber," + 
                           " CreditLevel," + 
                           " Sex," + 
                           " Age," + 
                           " Health," + 
                           " OccupationCode," + 
                           " EducationCode," + 
                           " Unit," + 
                           " UnitAddress," + 
                           " CustomerKind," + 
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
                           " Flag From PrpDcustomerIdv Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcustomerIdvDto prpDcustomerIdvDto = null;
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

            prpDcustomerIdvDto = new PrpDcustomerIdvDto();
            prpDcustomerIdvDto.setCustomerCode(dbManager.getString(resultSet,1));
            prpDcustomerIdvDto.setPassword(dbManager.getString(resultSet,2));
            prpDcustomerIdvDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerIdvDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerIdvDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerIdvDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerIdvDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerIdvDto.setIdentifyType(dbManager.getString(resultSet,8));
            prpDcustomerIdvDto.setIdentifyNumber(dbManager.getString(resultSet,9));
            prpDcustomerIdvDto.setCreditLevel(dbManager.getString(resultSet,10));
            prpDcustomerIdvDto.setSex(dbManager.getString(resultSet,11));
            prpDcustomerIdvDto.setAge(dbManager.getInt(resultSet,12));
            prpDcustomerIdvDto.setHealth(dbManager.getString(resultSet,13));
            prpDcustomerIdvDto.setOccupationCode(dbManager.getString(resultSet,14));
            prpDcustomerIdvDto.setEducationCode(dbManager.getString(resultSet,15));
            prpDcustomerIdvDto.setUnit(dbManager.getString(resultSet,16));
            prpDcustomerIdvDto.setUnitAddress(dbManager.getString(resultSet,17));
            prpDcustomerIdvDto.setCustomerKind(dbManager.getString(resultSet,18));
            prpDcustomerIdvDto.setCustomerFlag(dbManager.getString(resultSet,19));
            prpDcustomerIdvDto.setPhoneNumber(dbManager.getString(resultSet,20));
            prpDcustomerIdvDto.setFaxNumber(dbManager.getString(resultSet,21));
            prpDcustomerIdvDto.setMobile(dbManager.getString(resultSet,22));
            prpDcustomerIdvDto.setLinkAddress(dbManager.getString(resultSet,23));
            prpDcustomerIdvDto.setPostCode(dbManager.getString(resultSet,24));
            prpDcustomerIdvDto.setPager(dbManager.getString(resultSet,25));
            prpDcustomerIdvDto.setEmail(dbManager.getString(resultSet,26));
            prpDcustomerIdvDto.setBank(dbManager.getString(resultSet,27));
            prpDcustomerIdvDto.setAccount(dbManager.getString(resultSet,28));
            prpDcustomerIdvDto.setDeathDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpDcustomerIdvDto.setBlackState(dbManager.getString(resultSet,30));
            prpDcustomerIdvDto.setNewCustomerCode(dbManager.getString(resultSet,31));
            prpDcustomerIdvDto.setValidStatus(dbManager.getString(resultSet,32));
            prpDcustomerIdvDto.setArticleCode(dbManager.getString(resultSet,33));
            prpDcustomerIdvDto.setFlag(dbManager.getString(resultSet,34));
            collection.add(prpDcustomerIdvDto);
        }
        resultSet.close();
        log.info("DBPrpDcustomerIdvBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcustomerIdv Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcustomerIdvBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDcustomerIdv Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcustomerIdvBase.getCount() success!");
        return count;
    }
}
