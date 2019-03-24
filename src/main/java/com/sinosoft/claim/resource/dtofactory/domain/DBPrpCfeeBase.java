package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcfee保单保额保费表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCfeeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCfeeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCfeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void insert(PrpCfeeDto prpCfeeDto) throws Exception{
        String statement = " Insert Into PrpCfee(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCfeeDto.getPolicyNo());
        dbManager.setString(2,prpCfeeDto.getRiskCode());
        dbManager.setString(3,prpCfeeDto.getCurrency());
        dbManager.setDouble(4,prpCfeeDto.getAmount());
        dbManager.setDouble(5,prpCfeeDto.getPremium());
        dbManager.setString(6,prpCfeeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCfeeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCfeeDto prpCfeeDto = (PrpCfeeDto)i.next();
            insert(prpCfeeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(String policyNo,String currency) throws Exception{
        String statement = " Delete From PrpCfee Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,currency);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCfeeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void update(PrpCfeeDto prpCfeeDto) throws Exception{
        String statement = " Update PrpCfee Set RiskCode = ?," + 
                           " Amount = ?," + 
                           " Premium = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCfeeDto.getRiskCode());
        dbManager.setDouble(2,prpCfeeDto.getAmount());
        dbManager.setDouble(3,prpCfeeDto.getPremium());
        dbManager.setString(4,prpCfeeDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpCfeeDto.getPolicyNo());
        dbManager.setString(6,prpCfeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCfeeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param currency 币别代码
     * @return PrpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto findByPrimaryKey(String policyNo,String currency) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpCfee Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        PrpCfeeDto prpCfeeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCfeeDto = new PrpCfeeDto();
            prpCfeeDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCfeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpCfeeDto.setAmount(dbManager.getDouble(resultSet,4));
            prpCfeeDto.setPremium(dbManager.getDouble(resultSet,5));
            prpCfeeDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCfeeBase.findByPrimaryKey() success!");
        return prpCfeeDto;
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
        String statement = "Select PolicyNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpCfee Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCfeeDto prpCfeeDto = null;
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

            prpCfeeDto = new PrpCfeeDto();
            prpCfeeDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCfeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpCfeeDto.setAmount(dbManager.getDouble(resultSet,4));
            prpCfeeDto.setPremium(dbManager.getDouble(resultSet,5));
            prpCfeeDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCfeeDto);
        }
        resultSet.close();
        log.info("DBPrpCfeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpCfee Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCfeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCfee Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCfeeBase.getCount() success!");
        return count;
    }
}
