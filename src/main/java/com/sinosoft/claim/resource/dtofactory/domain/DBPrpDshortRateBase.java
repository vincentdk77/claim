package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshortRateDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdshortrate月短期费率表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDshortRateBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDshortRateBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDshortRateBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void insert(PrpDshortRateDto prpDshortRateDto) throws Exception{
        String statement = " Insert Into PrpDshortRate(" + 
                           " RiskCode," + 
                           " Months," + 
                           " ShortRate," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDshortRateDto.getRiskCode());
        dbManager.setInt(2,prpDshortRateDto.getMonths());
        dbManager.setDouble(3,prpDshortRateDto.getShortRate());
        dbManager.setString(4,prpDshortRateDto.getValidStatus());
        dbManager.setString(5,prpDshortRateDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshortRateBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDshortRateDto prpDshortRateDto = (PrpDshortRateDto)i.next();
            insert(prpDshortRateDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param months 月份数
     * @throws Exception
     */
    public void delete(String riskCode,int months) throws Exception{
        String statement = " Delete From PrpDshortRate Where " +
                           " RiskCode = ? And " + 
                           " Months = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,months);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDshortRateBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void update(PrpDshortRateDto prpDshortRateDto) throws Exception{
        String statement = " Update PrpDshortRate Set ShortRate = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " Months = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDouble(1,prpDshortRateDto.getShortRate());
        dbManager.setString(2,prpDshortRateDto.getValidStatus());
        dbManager.setString(3,prpDshortRateDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpDshortRateDto.getRiskCode());
        dbManager.setInt(5,prpDshortRateDto.getMonths());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshortRateBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param months 月份数
     * @return PrpDshortRateDto
     * @throws Exception
     */
    public PrpDshortRateDto findByPrimaryKey(String riskCode,int months) throws Exception{
        String statement = " Select RiskCode," + 
                           " Months," + 
                           " ShortRate," + 
                           " ValidStatus," + 
                           " Flag From PrpDshortRate Where " +
                           " RiskCode = ? And " + 
                           " Months = ?";
        PrpDshortRateDto prpDshortRateDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,months);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDshortRateDto = new PrpDshortRateDto();
            prpDshortRateDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDshortRateDto.setMonths(dbManager.getInt(resultSet,2));
            prpDshortRateDto.setShortRate(dbManager.getDouble(resultSet,3));
            prpDshortRateDto.setValidStatus(dbManager.getString(resultSet,4));
            prpDshortRateDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDshortRateBase.findByPrimaryKey() success!");
        return prpDshortRateDto;
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
                           " Months," + 
                           " ShortRate," + 
                           " ValidStatus," + 
                           " Flag From PrpDshortRate Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDshortRateDto prpDshortRateDto = null;
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

            prpDshortRateDto = new PrpDshortRateDto();
            prpDshortRateDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDshortRateDto.setMonths(dbManager.getInt(resultSet,2));
            prpDshortRateDto.setShortRate(dbManager.getDouble(resultSet,3));
            prpDshortRateDto.setValidStatus(dbManager.getString(resultSet,4));
            prpDshortRateDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDshortRateDto);
        }
        resultSet.close();
        log.info("DBPrpDshortRateBase.findByConditions() success!");
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
        String statement = "Delete From PrpDshortRate Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDshortRateBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDshortRate Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDshortRateBase.getCount() success!");
        return count;
    }
}
