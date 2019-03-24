package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcurrency币别代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcurrencyBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDcurrencyBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDcurrencyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void insert(PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        String statement = " Insert Into PrpDcurrency(" +
                           " CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcurrencyDto.getCurrencyCode());
        dbManager.setString(2,prpDcurrencyDto.getCurrencyCName());
        dbManager.setString(3,prpDcurrencyDto.getCurrencyEName());
        dbManager.setString(4,prpDcurrencyDto.getNewCurrencyCode());
        dbManager.setString(5,prpDcurrencyDto.getValidStatus());
        dbManager.setString(6,prpDcurrencyDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcurrencyBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto)i.next();
            insert(prpDcurrencyDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param currencyCode 币别代码
     * @throws Exception
     */
    public void delete(String currencyCode) throws Exception{
        String statement = " Delete From PrpDcurrency Where " +
                           " CurrencyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,currencyCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcurrencyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void update(PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        String statement = " Update PrpDcurrency Set CurrencyCName = ?," +
                           " CurrencyEName = ?," +
                           " NewCurrencyCode = ?," +
                           " ValidStatus = ?," +
                           " Flag = ? Where " +
                           " CurrencyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDcurrencyDto.getCurrencyCName());
        dbManager.setString(2,prpDcurrencyDto.getCurrencyEName());
        dbManager.setString(3,prpDcurrencyDto.getNewCurrencyCode());
        dbManager.setString(4,prpDcurrencyDto.getValidStatus());
        dbManager.setString(5,prpDcurrencyDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpDcurrencyDto.getCurrencyCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcurrencyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param currencyCode 币别代码
     * @return PrpDcurrencyDto
     * @throws Exception
     */
    public PrpDcurrencyDto findByPrimaryKey(String currencyCode) throws Exception{
        String statement = " Select CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag From PrpDcurrency Where " +
                           " CurrencyCode = ?";
        PrpDcurrencyDto prpDcurrencyDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,currencyCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcurrencyDto = new PrpDcurrencyDto();
            prpDcurrencyDto.setCurrencyCode(dbManager.getString(resultSet,1));
            prpDcurrencyDto.setCurrencyCName(dbManager.getString(resultSet,2));
            prpDcurrencyDto.setCurrencyEName(dbManager.getString(resultSet,3));
            prpDcurrencyDto.setNewCurrencyCode(dbManager.getString(resultSet,4));
            prpDcurrencyDto.setValidStatus(dbManager.getString(resultSet,5));
            prpDcurrencyDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpDcurrencyBase.findByPrimaryKey() success!");
        return prpDcurrencyDto;
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
        String statement = "Select CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag From PrpDcurrency Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcurrencyDto prpDcurrencyDto = null;
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

            prpDcurrencyDto = new PrpDcurrencyDto();
            prpDcurrencyDto.setCurrencyCode(dbManager.getString(resultSet,1));
            prpDcurrencyDto.setCurrencyCName(dbManager.getString(resultSet,2));
            prpDcurrencyDto.setCurrencyEName(dbManager.getString(resultSet,3));
            prpDcurrencyDto.setNewCurrencyCode(dbManager.getString(resultSet,4));
            prpDcurrencyDto.setValidStatus(dbManager.getString(resultSet,5));
            prpDcurrencyDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpDcurrencyDto);
        }
        resultSet.close();
        log.info("DBPrpDcurrencyBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcurrency Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcurrencyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcurrency Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcurrencyBase.getCount() success!");
        return count;
    }
}
