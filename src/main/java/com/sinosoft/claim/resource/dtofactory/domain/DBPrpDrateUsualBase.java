package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateUsualDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrateusual费率代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateUsualBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDrateUsualBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrateUsualBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void insert(PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        String statement = " Insert Into PrpDrateUsual(" + 
                           " RiskCode," + 
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrateUsualDto.getRiskCode());
        dbManager.setInt(2,prpDrateUsualDto.getRatePeriod());
        dbManager.setDateTime(3,prpDrateUsualDto.getValidDate());
        dbManager.setString(4,prpDrateUsualDto.getRateCode());
        dbManager.setDouble(5,prpDrateUsualDto.getBasePremium());
        dbManager.setDouble(6,prpDrateUsualDto.getRate());
        dbManager.setString(7,prpDrateUsualDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateUsualBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateUsualDto prpDrateUsualDto = (PrpDrateUsualDto)i.next();
            insert(prpDrateUsualDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param rateCode 费率代码
     * @throws Exception
     */
    public void delete(String riskCode,int ratePeriod,String rateCode) throws Exception{
        String statement = " Delete From PrpDrateUsual Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,rateCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateUsualBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void update(PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        String statement = " Update PrpDrateUsual Set ValidDate = ?," + 
                           " BasePremium = ?," + 
                           " Rate = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDateTime(1,prpDrateUsualDto.getValidDate());
        dbManager.setDouble(2,prpDrateUsualDto.getBasePremium());
        dbManager.setDouble(3,prpDrateUsualDto.getRate());
        dbManager.setString(4,prpDrateUsualDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpDrateUsualDto.getRiskCode());
        dbManager.setInt(6,prpDrateUsualDto.getRatePeriod());
        dbManager.setString(7,prpDrateUsualDto.getRateCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateUsualBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param rateCode 费率代码
     * @return PrpDrateUsualDto
     * @throws Exception
     */
    public PrpDrateUsualDto findByPrimaryKey(String riskCode,int ratePeriod,String rateCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag From PrpDrateUsual Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        PrpDrateUsualDto prpDrateUsualDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,rateCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateUsualDto = new PrpDrateUsualDto();
            prpDrateUsualDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateUsualDto.setRatePeriod(dbManager.getInt(resultSet,2));
            prpDrateUsualDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpDrateUsualDto.setRateCode(dbManager.getString(resultSet,4));
            prpDrateUsualDto.setBasePremium(dbManager.getDouble(resultSet,5));
            prpDrateUsualDto.setRate(dbManager.getDouble(resultSet,6));
            prpDrateUsualDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDrateUsualBase.findByPrimaryKey() success!");
        return prpDrateUsualDto;
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
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag From PrpDrateUsual Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateUsualDto prpDrateUsualDto = null;
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

            prpDrateUsualDto = new PrpDrateUsualDto();
            prpDrateUsualDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateUsualDto.setRatePeriod(dbManager.getInt(resultSet,2));
            prpDrateUsualDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpDrateUsualDto.setRateCode(dbManager.getString(resultSet,4));
            prpDrateUsualDto.setBasePremium(dbManager.getDouble(resultSet,5));
            prpDrateUsualDto.setRate(dbManager.getDouble(resultSet,6));
            prpDrateUsualDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDrateUsualDto);
        }
        resultSet.close();
        log.info("DBPrpDrateUsualBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrateUsual Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateUsualBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrateUsual Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateUsualBase.getCount() success!");
        return count;
    }
}
