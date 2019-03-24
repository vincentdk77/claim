package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDinvestDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdinvest投资型险种投资信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDinvestBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDinvestBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDinvestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void insert(PrpDinvestDto prpDinvestDto) throws Exception{
        String statement = " Insert Into PrpDinvest(" + 
                           " RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDinvestDto.getRiskCode());
        dbManager.setString(2,prpDinvestDto.getInvestType());
        dbManager.setString(3,prpDinvestDto.getInvestName());
        dbManager.setDouble(4,prpDinvestDto.getUnitAmount());
        dbManager.setDouble(5,prpDinvestDto.getUnitPremium());
        dbManager.setDouble(6,prpDinvestDto.getUnitInvestment());
        dbManager.setDouble(7,prpDinvestDto.getInterestRate());
        dbManager.setInt(8,prpDinvestDto.getInvestYear());
        dbManager.setString(9,prpDinvestDto.getValidStatus());
        dbManager.setString(10,prpDinvestDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDinvestBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDinvestDto prpDinvestDto = (PrpDinvestDto)i.next();
            insert(prpDinvestDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param investType 投资类型代码
     * @throws Exception
     */
    public void delete(String riskCode,String investType) throws Exception{
        String statement = " Delete From PrpDinvest Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,investType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDinvestBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void update(PrpDinvestDto prpDinvestDto) throws Exception{
        String statement = " Update PrpDinvest Set InvestName = ?," + 
                           " UnitAmount = ?," + 
                           " UnitPremium = ?," + 
                           " UnitInvestment = ?," + 
                           " InterestRate = ?," + 
                           " InvestYear = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDinvestDto.getInvestName());
        dbManager.setDouble(2,prpDinvestDto.getUnitAmount());
        dbManager.setDouble(3,prpDinvestDto.getUnitPremium());
        dbManager.setDouble(4,prpDinvestDto.getUnitInvestment());
        dbManager.setDouble(5,prpDinvestDto.getInterestRate());
        dbManager.setInt(6,prpDinvestDto.getInvestYear());
        dbManager.setString(7,prpDinvestDto.getValidStatus());
        dbManager.setString(8,prpDinvestDto.getFlag());
        //设置条件字段;
        dbManager.setString(9,prpDinvestDto.getRiskCode());
        dbManager.setString(10,prpDinvestDto.getInvestType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDinvestBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param investType 投资类型代码
     * @return PrpDinvestDto
     * @throws Exception
     */
    public PrpDinvestDto findByPrimaryKey(String riskCode,String investType) throws Exception{
        String statement = " Select RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag From PrpDinvest Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        PrpDinvestDto prpDinvestDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,investType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDinvestDto = new PrpDinvestDto();
            prpDinvestDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDinvestDto.setInvestType(dbManager.getString(resultSet,2));
            prpDinvestDto.setInvestName(dbManager.getString(resultSet,3));
            prpDinvestDto.setUnitAmount(dbManager.getDouble(resultSet,4));
            prpDinvestDto.setUnitPremium(dbManager.getDouble(resultSet,5));
            prpDinvestDto.setUnitInvestment(dbManager.getDouble(resultSet,6));
            prpDinvestDto.setInterestRate(dbManager.getDouble(resultSet,7));
            prpDinvestDto.setInvestYear(dbManager.getInt(resultSet,8));
            prpDinvestDto.setValidStatus(dbManager.getString(resultSet,9));
            prpDinvestDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDinvestBase.findByPrimaryKey() success!");
        return prpDinvestDto;
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
        String statement = "Select RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag From PrpDinvest Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDinvestDto prpDinvestDto = null;
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

            prpDinvestDto = new PrpDinvestDto();
            prpDinvestDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDinvestDto.setInvestType(dbManager.getString(resultSet,2));
            prpDinvestDto.setInvestName(dbManager.getString(resultSet,3));
            prpDinvestDto.setUnitAmount(dbManager.getDouble(resultSet,4));
            prpDinvestDto.setUnitPremium(dbManager.getDouble(resultSet,5));
            prpDinvestDto.setUnitInvestment(dbManager.getDouble(resultSet,6));
            prpDinvestDto.setInterestRate(dbManager.getDouble(resultSet,7));
            prpDinvestDto.setInvestYear(dbManager.getInt(resultSet,8));
            prpDinvestDto.setValidStatus(dbManager.getString(resultSet,9));
            prpDinvestDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDinvestDto);
        }
        resultSet.close();
        log.info("DBPrpDinvestBase.findByConditions() success!");
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
        String statement = "Delete From PrpDinvest Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDinvestBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDinvest Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDinvestBase.getCount() success!");
        return count;
    }
}
