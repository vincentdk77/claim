package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcustomerDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcustomerBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcustomerBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void insert(PrpDcustomerDto prpDcustomerDto) throws Exception{
        String statement = " Insert Into PrpDcustomer(" + 
                           " CustomerType," + 
                           " CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " OrganizeCode," + 
                           " FatherCode," + 
                           " BlackState," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " ArticleCode," + 
                           " ValidStatus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcustomerDto.getCustomerType());
        dbManager.setString(2,prpDcustomerDto.getCustomerCode());
        dbManager.setString(3,prpDcustomerDto.getShortHandCode());
        dbManager.setString(4,prpDcustomerDto.getCustomerCName());
        dbManager.setString(5,prpDcustomerDto.getCustomerEName());
        dbManager.setString(6,prpDcustomerDto.getAddressCName());
        dbManager.setString(7,prpDcustomerDto.getAddressEName());
        dbManager.setString(8,prpDcustomerDto.getOrganizeCode());
        dbManager.setString(9,prpDcustomerDto.getFatherCode());
        dbManager.setString(10,prpDcustomerDto.getBlackState());
        dbManager.setString(11,prpDcustomerDto.getCustomerKind());
        dbManager.setString(12,prpDcustomerDto.getCustomerFlag());
        dbManager.setString(13,prpDcustomerDto.getArticleCode());
        dbManager.setString(14,prpDcustomerDto.getValidStatus());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcustomerDto prpDcustomerDto = (PrpDcustomerDto)i.next();
            insert(prpDcustomerDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param customerCode customercode
     * @throws Exception
     */
    public void delete(String customerCode) throws Exception{
        String statement = " Delete From PrpDcustomer Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcustomerBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void update(PrpDcustomerDto prpDcustomerDto) throws Exception{
        String statement = " Update PrpDcustomer Set CustomerType = ?," + 
                           " ShortHandCode = ?," + 
                           " CustomerCName = ?," + 
                           " CustomerEName = ?," + 
                           " AddressCName = ?," + 
                           " AddressEName = ?," + 
                           " OrganizeCode = ?," + 
                           " FatherCode = ?," + 
                           " BlackState = ?," + 
                           " CustomerKind = ?," + 
                           " CustomerFlag = ?," + 
                           " ArticleCode = ?," + 
                           " ValidStatus = ? Where " +
                           " CustomerCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDcustomerDto.getCustomerType());
        dbManager.setString(2,prpDcustomerDto.getShortHandCode());
        dbManager.setString(3,prpDcustomerDto.getCustomerCName());
        dbManager.setString(4,prpDcustomerDto.getCustomerEName());
        dbManager.setString(5,prpDcustomerDto.getAddressCName());
        dbManager.setString(6,prpDcustomerDto.getAddressEName());
        dbManager.setString(7,prpDcustomerDto.getOrganizeCode());
        dbManager.setString(8,prpDcustomerDto.getFatherCode());
        dbManager.setString(9,prpDcustomerDto.getBlackState());
        dbManager.setString(10,prpDcustomerDto.getCustomerKind());
        dbManager.setString(11,prpDcustomerDto.getCustomerFlag());
        dbManager.setString(12,prpDcustomerDto.getArticleCode());
        dbManager.setString(13,prpDcustomerDto.getValidStatus());
        //设置条件字段;
        dbManager.setString(14,prpDcustomerDto.getCustomerCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcustomerBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param customerCode customercode
     * @return PrpDcustomerDto
     * @throws Exception
     */
    public PrpDcustomerDto findByPrimaryKey(String customerCode) throws Exception{
        String statement = " Select CustomerType," + 
                           " CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " OrganizeCode," + 
                           " FatherCode," + 
                           " BlackState," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " ArticleCode," + 
                           " ValidStatus From PrpDcustomer Where " +
                           " CustomerCode = ?";
        PrpDcustomerDto prpDcustomerDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,customerCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcustomerDto = new PrpDcustomerDto();
            prpDcustomerDto.setCustomerType(dbManager.getString(resultSet,1));
            prpDcustomerDto.setCustomerCode(dbManager.getString(resultSet,2));
            prpDcustomerDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerDto.setOrganizeCode(dbManager.getString(resultSet,8));
            prpDcustomerDto.setFatherCode(dbManager.getString(resultSet,9));
            prpDcustomerDto.setBlackState(dbManager.getString(resultSet,10));
            prpDcustomerDto.setCustomerKind(dbManager.getString(resultSet,11));
            prpDcustomerDto.setCustomerFlag(dbManager.getString(resultSet,12));
            prpDcustomerDto.setArticleCode(dbManager.getString(resultSet,13));
            prpDcustomerDto.setValidStatus(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        log.info("DBPrpDcustomerBase.findByPrimaryKey() success!");
        return prpDcustomerDto;
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
        String statement = "Select CustomerType," + 
                           " CustomerCode," + 
                           " ShortHandCode," + 
                           " CustomerCName," + 
                           " CustomerEName," + 
                           " AddressCName," + 
                           " AddressEName," + 
                           " OrganizeCode," + 
                           " FatherCode," + 
                           " BlackState," + 
                           " CustomerKind," + 
                           " CustomerFlag," + 
                           " ArticleCode," + 
                           " ValidStatus From PrpDcustomer Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcustomerDto prpDcustomerDto = null;
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

            prpDcustomerDto = new PrpDcustomerDto();
            prpDcustomerDto.setCustomerType(dbManager.getString(resultSet,1));
            prpDcustomerDto.setCustomerCode(dbManager.getString(resultSet,2));
            prpDcustomerDto.setShortHandCode(dbManager.getString(resultSet,3));
            prpDcustomerDto.setCustomerCName(dbManager.getString(resultSet,4));
            prpDcustomerDto.setCustomerEName(dbManager.getString(resultSet,5));
            prpDcustomerDto.setAddressCName(dbManager.getString(resultSet,6));
            prpDcustomerDto.setAddressEName(dbManager.getString(resultSet,7));
            prpDcustomerDto.setOrganizeCode(dbManager.getString(resultSet,8));
            prpDcustomerDto.setFatherCode(dbManager.getString(resultSet,9));
            prpDcustomerDto.setBlackState(dbManager.getString(resultSet,10));
            prpDcustomerDto.setCustomerKind(dbManager.getString(resultSet,11));
            prpDcustomerDto.setCustomerFlag(dbManager.getString(resultSet,12));
            prpDcustomerDto.setArticleCode(dbManager.getString(resultSet,13));
            prpDcustomerDto.setValidStatus(dbManager.getString(resultSet,14));
            collection.add(prpDcustomerDto);
        }
        resultSet.close();
        log.info("DBPrpDcustomerBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcustomer Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcustomerBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDcustomer Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcustomerBase.getCount() success!");
        return count;
    }
}
