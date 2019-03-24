package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateCondDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdratecond费率条件表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateCondBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDrateCondBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrateCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void insert(PrpDrateCondDto prpDrateCondDto) throws Exception{
        String statement = " Insert Into PrpDrateCond(" + 
                           " RiskCode," + 
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrateCondDto.getRiskCode());
        dbManager.setDateTime(2,prpDrateCondDto.getValidDate());
        dbManager.setInt(3,prpDrateCondDto.getRatePeriod());
        dbManager.setString(4,prpDrateCondDto.getCondCode());
        dbManager.setString(5,prpDrateCondDto.getCondName());
        dbManager.setDouble(6,prpDrateCondDto.getLowerValue());
        dbManager.setDouble(7,prpDrateCondDto.getUpperValue());
        dbManager.setString(8,prpDrateCondDto.getValueCode());
        dbManager.setString(9,prpDrateCondDto.getValueName());
        dbManager.setInt(10,prpDrateCondDto.getStartpos());
        dbManager.setInt(11,prpDrateCondDto.getEndpos());
        dbManager.setString(12,prpDrateCondDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateCondBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateCondDto prpDrateCondDto = (PrpDrateCondDto)i.next();
            insert(prpDrateCondDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param condCode 条件代码
     * @param valueCode 取值代码
     * @throws Exception
     */
    public void delete(String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        String statement = " Delete From PrpDrateCond Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,condCode);
        dbManager.setString(4,valueCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateCondBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void update(PrpDrateCondDto prpDrateCondDto) throws Exception{
        String statement = " Update PrpDrateCond Set ValidDate = ?," + 
                           " CondName = ?," + 
                           " LowerValue = ?," + 
                           " UpperValue = ?," + 
                           " ValueName = ?," + 
                           " Startpos = ?," + 
                           " Endpos = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setDateTime(1,prpDrateCondDto.getValidDate());
        dbManager.setString(2,prpDrateCondDto.getCondName());
        dbManager.setDouble(3,prpDrateCondDto.getLowerValue());
        dbManager.setDouble(4,prpDrateCondDto.getUpperValue());
        dbManager.setString(5,prpDrateCondDto.getValueName());
        dbManager.setInt(6,prpDrateCondDto.getStartpos());
        dbManager.setInt(7,prpDrateCondDto.getEndpos());
        dbManager.setString(8,prpDrateCondDto.getFlag());
        //设置条件字段;
        dbManager.setString(9,prpDrateCondDto.getRiskCode());
        dbManager.setInt(10,prpDrateCondDto.getRatePeriod());
        dbManager.setString(11,prpDrateCondDto.getCondCode());
        dbManager.setString(12,prpDrateCondDto.getValueCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateCondBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param condCode 条件代码
     * @param valueCode 取值代码
     * @return PrpDrateCondDto
     * @throws Exception
     */
    public PrpDrateCondDto findByPrimaryKey(String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag From PrpDrateCond Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        PrpDrateCondDto prpDrateCondDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,condCode);
        dbManager.setString(4,valueCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateCondDto = new PrpDrateCondDto();
            prpDrateCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
            prpDrateCondDto.setRatePeriod(dbManager.getInt(resultSet,3));
            prpDrateCondDto.setCondCode(dbManager.getString(resultSet,4));
            prpDrateCondDto.setCondName(dbManager.getString(resultSet,5));
            prpDrateCondDto.setLowerValue(dbManager.getDouble(resultSet,6));
            prpDrateCondDto.setUpperValue(dbManager.getDouble(resultSet,7));
            prpDrateCondDto.setValueCode(dbManager.getString(resultSet,8));
            prpDrateCondDto.setValueName(dbManager.getString(resultSet,9));
            prpDrateCondDto.setStartpos(dbManager.getInt(resultSet,10));
            prpDrateCondDto.setEndpos(dbManager.getInt(resultSet,11));
            prpDrateCondDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        log.info("DBPrpDrateCondBase.findByPrimaryKey() success!");
        return prpDrateCondDto;
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
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag From PrpDrateCond Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateCondDto prpDrateCondDto = null;
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

            prpDrateCondDto = new PrpDrateCondDto();
            prpDrateCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
            prpDrateCondDto.setRatePeriod(dbManager.getInt(resultSet,3));
            prpDrateCondDto.setCondCode(dbManager.getString(resultSet,4));
            prpDrateCondDto.setCondName(dbManager.getString(resultSet,5));
            prpDrateCondDto.setLowerValue(dbManager.getDouble(resultSet,6));
            prpDrateCondDto.setUpperValue(dbManager.getDouble(resultSet,7));
            prpDrateCondDto.setValueCode(dbManager.getString(resultSet,8));
            prpDrateCondDto.setValueName(dbManager.getString(resultSet,9));
            prpDrateCondDto.setStartpos(dbManager.getInt(resultSet,10));
            prpDrateCondDto.setEndpos(dbManager.getInt(resultSet,11));
            prpDrateCondDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpDrateCondDto);
        }
        resultSet.close();
        log.info("DBPrpDrateCondBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrateCond Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateCondBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDrateCond Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateCondBase.getCount() success!");
        return count;
    }
}
