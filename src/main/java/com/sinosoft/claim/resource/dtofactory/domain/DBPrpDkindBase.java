package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDkindDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdkind险别代码表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDkindBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDkindBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDkindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDkindDto prpDkindDto
     * @throws Exception
     */
    public void insert(PrpDkindDto prpDkindDto) throws Exception{
        String statement = " Insert Into PrpDkind(" +
                           " RiskCode," +
                           " KindCode," +
                           " KindCName," +
                           " KindEName," +
                           " RateTypeFlag," +
                           " CalculateFlag," +
                           " MaxFloatRate," +
                           " MaxDiscountRate," +
                           " NewKindCode," +
                           " ValidStatus," +
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDkindDto.getRiskCode());
        dbManager.setString(2,prpDkindDto.getKindCode());
        dbManager.setString(3,prpDkindDto.getKindCName());
        dbManager.setString(4,prpDkindDto.getKindEName());
        dbManager.setString(5,prpDkindDto.getRateTypeFlag());
        dbManager.setString(6,prpDkindDto.getCalculateFlag());
        dbManager.setDouble(7,prpDkindDto.getMaxFloatRate());
        dbManager.setDouble(8,prpDkindDto.getMaxDiscountRate());
        dbManager.setString(9,prpDkindDto.getNewKindCode());
        dbManager.setString(10,prpDkindDto.getValidStatus());
        dbManager.setString(11,prpDkindDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDkindBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDkindDto prpDkindDto = (PrpDkindDto)i.next();
            insert(prpDkindDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode) throws Exception{
        String statement = " Delete From PrpDkind Where " +
                           " RiskCode = ? And " +
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDkindBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDkindDto prpDkindDto
     * @throws Exception
     */
    public void update(PrpDkindDto prpDkindDto) throws Exception{
        String statement = " Update PrpDkind Set KindCName = ?," +
                           " KindEName = ?," +
                           " RateTypeFlag = ?," +
                           " CalculateFlag = ?," +
                           " MaxFloatRate = ?," +
                           " MaxDiscountRate = ?," +
                           " NewKindCode = ?," +
                           " ValidStatus = ?," +
                           " Flag = ? Where " +
                           " RiskCode = ? And " +
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDkindDto.getKindCName());
        dbManager.setString(2,prpDkindDto.getKindEName());
        dbManager.setString(3,prpDkindDto.getRateTypeFlag());
        dbManager.setString(4,prpDkindDto.getCalculateFlag());
        dbManager.setDouble(5,prpDkindDto.getMaxFloatRate());
        dbManager.setDouble(6,prpDkindDto.getMaxDiscountRate());
        dbManager.setString(7,prpDkindDto.getNewKindCode());
        dbManager.setString(8,prpDkindDto.getValidStatus());
        dbManager.setString(9,prpDkindDto.getFlag());
        //设置条件字段;
        dbManager.setString(10,prpDkindDto.getRiskCode());
        dbManager.setString(11,prpDkindDto.getKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDkindBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @return PrpDkindDto
     * @throws Exception
     */
    public PrpDkindDto findByPrimaryKey(String riskCode,String kindCode) throws Exception{
        String statement = " Select RiskCode," +
                           " KindCode," +
                           " KindCName," +
                           " KindEName," +
                           " RateTypeFlag," +
                           " CalculateFlag," +
                           " MaxFloatRate," +
                           " MaxDiscountRate," +
                           " NewKindCode," +
                           " ValidStatus," +
                           " Flag From PrpDkind Where " +
                           " RiskCode = ? And " +
                           " KindCode = ?";
        PrpDkindDto prpDkindDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDkindDto = new PrpDkindDto();
            prpDkindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDkindDto.setKindCode(dbManager.getString(resultSet,2));
            prpDkindDto.setKindCName(dbManager.getString(resultSet,3));
            prpDkindDto.setKindEName(dbManager.getString(resultSet,4));
            prpDkindDto.setRateTypeFlag(dbManager.getString(resultSet,5));
            prpDkindDto.setCalculateFlag(dbManager.getString(resultSet,6));
            prpDkindDto.setMaxFloatRate(dbManager.getDouble(resultSet,7));
            prpDkindDto.setMaxDiscountRate(dbManager.getDouble(resultSet,8));
            prpDkindDto.setNewKindCode(dbManager.getString(resultSet,9));
            prpDkindDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDkindDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpDkindBase.findByPrimaryKey() success!");
        return prpDkindDto;
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
                           " KindCode," +
                           " KindCName," +
                           " KindEName," +
                          // " RateTypeFlag," +
                           " CalculateFlag," +
                         //  " MaxFloatRate," +
                         //  " MaxDiscountRate," +
                           " NewKindCode," +
                           " ValidStatus," +
                           " Flag From PrpDkind Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDkindDto prpDkindDto = null;
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

            prpDkindDto = new PrpDkindDto();
            prpDkindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDkindDto.setKindCode(dbManager.getString(resultSet,2));
            prpDkindDto.setKindCName(dbManager.getString(resultSet,3));
            prpDkindDto.setKindEName(dbManager.getString(resultSet,4));
            //prpDkindDto.setRateTypeFlag(dbManager.getString(resultSet,5));
            prpDkindDto.setCalculateFlag(dbManager.getString(resultSet,5));
            //prpDkindDto.setMaxFloatRate(dbManager.getDouble(resultSet,7));
            //prpDkindDto.setMaxDiscountRate(dbManager.getDouble(resultSet,8));
            prpDkindDto.setNewKindCode(dbManager.getString(resultSet,6));
            prpDkindDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDkindDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpDkindDto);
        }
        resultSet.close();
        log.info("DBPrpDkindBase.findByConditions() success!");
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
        String statement = "Delete From PrpDkind Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDkindBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDkind Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDkindBase.getCount() success!");
        return count;
    }
}
