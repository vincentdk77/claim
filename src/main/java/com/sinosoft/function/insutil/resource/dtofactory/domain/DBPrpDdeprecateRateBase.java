package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdeprecateRateDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpddeprecaterate的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdeprecateRateBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDdeprecateRateBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDdeprecateRateBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @throws Exception
     */
    public void insert(PrpDdeprecateRateDto prpDdeprecateRateDto) throws Exception{
        String statement = " Insert Into PrpDdeprecateRate(" + 
                           " RiskCode," + 
                           " ClauseType," + 
                           " CarKindCode," + 
                           " CarKindName," + 
                           " PerYearRate," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDdeprecateRateDto.getRiskCode());
        dbManager.setString(2,prpDdeprecateRateDto.getClauseType());
        dbManager.setString(3,prpDdeprecateRateDto.getCarKindCode());
        dbManager.setString(4,prpDdeprecateRateDto.getCarKindName());
        dbManager.setDouble(5,prpDdeprecateRateDto.getPerYearRate());
        dbManager.setString(6,prpDdeprecateRateDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdeprecateRateBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDdeprecateRateDto prpDdeprecateRateDto = (PrpDdeprecateRateDto)i.next();
            insert(prpDdeprecateRateDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param carKindCode carkindcode
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String carKindCode) throws Exception{
        String statement = " Delete From PrpDdeprecateRate Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " CarKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,carKindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDdeprecateRateBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDdeprecateRateDto prpDdeprecateRateDto
     * @throws Exception
     */
    public void update(PrpDdeprecateRateDto prpDdeprecateRateDto) throws Exception{
        String statement = " Update PrpDdeprecateRate Set CarKindName = ?," + 
                           " PerYearRate = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " CarKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDdeprecateRateDto.getCarKindName());
        dbManager.setDouble(2,prpDdeprecateRateDto.getPerYearRate());
        dbManager.setString(3,prpDdeprecateRateDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpDdeprecateRateDto.getRiskCode());
        dbManager.setString(5,prpDdeprecateRateDto.getClauseType());
        dbManager.setString(6,prpDdeprecateRateDto.getCarKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdeprecateRateBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param carKindCode carkindcode
     * @return PrpDdeprecateRateDto
     * @throws Exception
     */
    public PrpDdeprecateRateDto findByPrimaryKey(String riskCode,String clauseType,String carKindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ClauseType," + 
                           " CarKindCode," + 
                           " CarKindName," + 
                           " PerYearRate," + 
                           " Flag From PrpDdeprecateRate Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " CarKindCode = ?";
        PrpDdeprecateRateDto prpDdeprecateRateDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,carKindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDdeprecateRateDto = new PrpDdeprecateRateDto();
            prpDdeprecateRateDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeprecateRateDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeprecateRateDto.setCarKindCode(dbManager.getString(resultSet,3));
            prpDdeprecateRateDto.setCarKindName(dbManager.getString(resultSet,4));
            prpDdeprecateRateDto.setPerYearRate(dbManager.getDouble(resultSet,5));
            prpDdeprecateRateDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpDdeprecateRateBase.findByPrimaryKey() success!");
        return prpDdeprecateRateDto;
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
                           " ClauseType," + 
                           " CarKindCode," + 
                           " CarKindName," + 
                           " PerYearRate," + 
                           " Flag From PrpDdeprecateRate Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDdeprecateRateDto prpDdeprecateRateDto = null;
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

            prpDdeprecateRateDto = new PrpDdeprecateRateDto();
            prpDdeprecateRateDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeprecateRateDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeprecateRateDto.setCarKindCode(dbManager.getString(resultSet,3));
            prpDdeprecateRateDto.setCarKindName(dbManager.getString(resultSet,4));
            prpDdeprecateRateDto.setPerYearRate(dbManager.getDouble(resultSet,5));
            prpDdeprecateRateDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpDdeprecateRateDto);
        }
        resultSet.close();
        log.info("DBPrpDdeprecateRateBase.findByConditions() success!");
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
        String statement = "Delete From PrpDdeprecateRate Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDdeprecateRateBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDdeprecateRate Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDdeprecateRateBase.getCount() success!");
        return count;
    }
}
