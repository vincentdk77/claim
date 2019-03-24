package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrate的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDrateBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDrateBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void insert(PrpDrateDto prpDrateDto) throws Exception{
        String statement = " Insert Into PrpDrate(" + 
                           " SerialNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessDetail," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Years," + 
                           " PreturnOver," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFeeLower," + 
                           " LimitFeeUpper," + 
                           " BaseRateLower," + 
                           " BaseRateUpper," + 
                           " RateRatio," + 
                           " Premium," + 
                           " RateCode," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpDrateDto.getSerialNo());
        dbManager.setString(2,prpDrateDto.getClassCode());
        dbManager.setString(3,prpDrateDto.getRiskCode());
        dbManager.setString(4,prpDrateDto.getKindCode());
        dbManager.setString(5,prpDrateDto.getKindName());
        dbManager.setString(6,prpDrateDto.getComCode());
        dbManager.setString(7,prpDrateDto.getPossessNature());
        dbManager.setString(8,prpDrateDto.getBusinessSource());
        dbManager.setString(9,prpDrateDto.getBusinessDetail());
        dbManager.setString(10,prpDrateDto.getItemCode());
        dbManager.setString(11,prpDrateDto.getItemName());
        dbManager.setInt(12,prpDrateDto.getYears());
        dbManager.setDouble(13,prpDrateDto.getPreturnOver());
        dbManager.setString(14,prpDrateDto.getLimitType());
        dbManager.setString(15,prpDrateDto.getCurrency());
        dbManager.setDouble(16,prpDrateDto.getLimitFeeLower());
        dbManager.setDouble(17,prpDrateDto.getLimitFeeUpper());
        dbManager.setDouble(18,prpDrateDto.getBaseRateLower());
        dbManager.setDouble(19,prpDrateDto.getBaseRateUpper());
        dbManager.setDouble(20,prpDrateDto.getRateRatio());
        dbManager.setDouble(21,prpDrateDto.getPremium());
        dbManager.setString(22,prpDrateDto.getRateCode());
        dbManager.setDateTime(23,prpDrateDto.getValidDate());
        dbManager.setString(24,prpDrateDto.getValidStatus());
        dbManager.setString(25,prpDrateDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateDto prpDrateDto = (PrpDrateDto)i.next();
            insert(prpDrateDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialNo serialno
     * @param riskCode riskcode
     * @param rateCode ratecode
     * @throws Exception
     */
    public void delete(int serialNo,String riskCode,String rateCode) throws Exception{
        String statement = " Delete From PrpDrate Where " +
                           " SerialNo = ? And " + 
                           " RiskCode = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,rateCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDrateDto prpDrateDto
     * @throws Exception
     */
    public void update(PrpDrateDto prpDrateDto) throws Exception{
        String statement = " Update PrpDrate Set ClassCode = ?," + 
                           " KindCode = ?," + 
                           " KindName = ?," + 
                           " ComCode = ?," + 
                           " PossessNature = ?," + 
                           " BusinessSource = ?," + 
                           " BusinessDetail = ?," + 
                           " ItemCode = ?," + 
                           " ItemName = ?," + 
                           " Years = ?," + 
                           " PreturnOver = ?," + 
                           " LimitType = ?," + 
                           " Currency = ?," + 
                           " LimitFeeLower = ?," + 
                           " LimitFeeUpper = ?," + 
                           " BaseRateLower = ?," + 
                           " BaseRateUpper = ?," + 
                           " RateRatio = ?," + 
                           " Premium = ?," + 
                           " ValidDate = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " SerialNo = ? And " + 
                           " RiskCode = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDrateDto.getClassCode());
        dbManager.setString(2,prpDrateDto.getKindCode());
        dbManager.setString(3,prpDrateDto.getKindName());
        dbManager.setString(4,prpDrateDto.getComCode());
        dbManager.setString(5,prpDrateDto.getPossessNature());
        dbManager.setString(6,prpDrateDto.getBusinessSource());
        dbManager.setString(7,prpDrateDto.getBusinessDetail());
        dbManager.setString(8,prpDrateDto.getItemCode());
        dbManager.setString(9,prpDrateDto.getItemName());
        dbManager.setInt(10,prpDrateDto.getYears());
        dbManager.setDouble(11,prpDrateDto.getPreturnOver());
        dbManager.setString(12,prpDrateDto.getLimitType());
        dbManager.setString(13,prpDrateDto.getCurrency());
        dbManager.setDouble(14,prpDrateDto.getLimitFeeLower());
        dbManager.setDouble(15,prpDrateDto.getLimitFeeUpper());
        dbManager.setDouble(16,prpDrateDto.getBaseRateLower());
        dbManager.setDouble(17,prpDrateDto.getBaseRateUpper());
        dbManager.setDouble(18,prpDrateDto.getRateRatio());
        dbManager.setDouble(19,prpDrateDto.getPremium());
        dbManager.setDateTime(20,prpDrateDto.getValidDate());
        dbManager.setString(21,prpDrateDto.getValidStatus());
        dbManager.setString(22,prpDrateDto.getFlag());
        //设置条件字段;
        dbManager.setInt(23,prpDrateDto.getSerialNo());
        dbManager.setString(24,prpDrateDto.getRiskCode());
        dbManager.setString(25,prpDrateDto.getRateCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param serialNo serialno
     * @param riskCode riskcode
     * @param rateCode ratecode
     * @return PrpDrateDto
     * @throws Exception
     */
    public PrpDrateDto findByPrimaryKey(int serialNo,String riskCode,String rateCode) throws Exception{
        String statement = " Select SerialNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessDetail," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Years," + 
                           " PreturnOver," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFeeLower," + 
                           " LimitFeeUpper," + 
                           " BaseRateLower," + 
                           " BaseRateUpper," + 
                           " RateRatio," + 
                           " Premium," + 
                           " RateCode," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDrate Where " +
                           " SerialNo = ? And " + 
                           " RiskCode = ? And " + 
                           " RateCode = ?";
        PrpDrateDto prpDrateDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,rateCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateDto = new PrpDrateDto();
            prpDrateDto.setSerialNo(dbManager.getInt(resultSet,1));
            prpDrateDto.setClassCode(dbManager.getString(resultSet,2));
            prpDrateDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDrateDto.setKindCode(dbManager.getString(resultSet,4));
            prpDrateDto.setKindName(dbManager.getString(resultSet,5));
            prpDrateDto.setComCode(dbManager.getString(resultSet,6));
            prpDrateDto.setPossessNature(dbManager.getString(resultSet,7));
            prpDrateDto.setBusinessSource(dbManager.getString(resultSet,8));
            prpDrateDto.setBusinessDetail(dbManager.getString(resultSet,9));
            prpDrateDto.setItemCode(dbManager.getString(resultSet,10));
            prpDrateDto.setItemName(dbManager.getString(resultSet,11));
            prpDrateDto.setYears(dbManager.getInt(resultSet,12));
            prpDrateDto.setPreturnOver(dbManager.getDouble(resultSet,13));
            prpDrateDto.setLimitType(dbManager.getString(resultSet,14));
            prpDrateDto.setCurrency(dbManager.getString(resultSet,15));
            prpDrateDto.setLimitFeeLower(dbManager.getDouble(resultSet,16));
            prpDrateDto.setLimitFeeUpper(dbManager.getDouble(resultSet,17));
            prpDrateDto.setBaseRateLower(dbManager.getDouble(resultSet,18));
            prpDrateDto.setBaseRateUpper(dbManager.getDouble(resultSet,19));
            prpDrateDto.setRateRatio(dbManager.getDouble(resultSet,20));
            prpDrateDto.setPremium(dbManager.getDouble(resultSet,21));
            prpDrateDto.setRateCode(dbManager.getString(resultSet,22));
            prpDrateDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpDrateDto.setValidStatus(dbManager.getString(resultSet,24));
            prpDrateDto.setFlag(dbManager.getString(resultSet,25));
        }
        resultSet.close();
        log.info("DBPrpDrateBase.findByPrimaryKey() success!");
        return prpDrateDto;
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
        String statement = "Select SerialNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " PossessNature," + 
                           " BusinessSource," + 
                           " BusinessDetail," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " Years," + 
                           " PreturnOver," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFeeLower," + 
                           " LimitFeeUpper," + 
                           " BaseRateLower," + 
                           " BaseRateUpper," + 
                           " RateRatio," + 
                           " Premium," + 
                           " RateCode," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDrate Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateDto prpDrateDto = null;
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

            prpDrateDto = new PrpDrateDto();
            prpDrateDto.setSerialNo(dbManager.getInt(resultSet,1));
            prpDrateDto.setClassCode(dbManager.getString(resultSet,2));
            prpDrateDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDrateDto.setKindCode(dbManager.getString(resultSet,4));
            prpDrateDto.setKindName(dbManager.getString(resultSet,5));
            prpDrateDto.setComCode(dbManager.getString(resultSet,6));
            prpDrateDto.setPossessNature(dbManager.getString(resultSet,7));
            prpDrateDto.setBusinessSource(dbManager.getString(resultSet,8));
            prpDrateDto.setBusinessDetail(dbManager.getString(resultSet,9));
            prpDrateDto.setItemCode(dbManager.getString(resultSet,10));
            prpDrateDto.setItemName(dbManager.getString(resultSet,11));
            prpDrateDto.setYears(dbManager.getInt(resultSet,12));
            prpDrateDto.setPreturnOver(dbManager.getDouble(resultSet,13));
            prpDrateDto.setLimitType(dbManager.getString(resultSet,14));
            prpDrateDto.setCurrency(dbManager.getString(resultSet,15));
            prpDrateDto.setLimitFeeLower(dbManager.getDouble(resultSet,16));
            prpDrateDto.setLimitFeeUpper(dbManager.getDouble(resultSet,17));
            prpDrateDto.setBaseRateLower(dbManager.getDouble(resultSet,18));
            prpDrateDto.setBaseRateUpper(dbManager.getDouble(resultSet,19));
            prpDrateDto.setRateRatio(dbManager.getDouble(resultSet,20));
            prpDrateDto.setPremium(dbManager.getDouble(resultSet,21));
            prpDrateDto.setRateCode(dbManager.getString(resultSet,22));
            prpDrateDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,23));
            prpDrateDto.setValidStatus(dbManager.getString(resultSet,24));
            prpDrateDto.setFlag(dbManager.getString(resultSet,25));
            collection.add(prpDrateDto);
        }
        resultSet.close();
        log.info("DBPrpDrateBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrate Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrate Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateBase.getCount() success!");
        return count;
    }
}
