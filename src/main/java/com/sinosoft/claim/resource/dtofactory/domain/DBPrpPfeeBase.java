package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPfeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppfee批改保额保费变化表的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:17.656<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPfeeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPfeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPfeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPfeeDto prpPfeeDto
     * @throws Exception
     */
    public void insert(PrpPfeeDto prpPfeeDto) throws Exception{
        String mainStatement = " Insert Into PrpPfee (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " Currency," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPfeeDto.getEndorseNo() + "'," +
                           "'" + prpPfeeDto.getPolicyNo() + "'," +
                           "'" + prpPfeeDto.getRiskCode() + "'," +
                           "'" + prpPfeeDto.getCurrency() + "'," +
                           "'" + prpPfeeDto.getChgAmount() + "'," +
                           "'" + prpPfeeDto.getChgPremium() + "'," +
                           "'" + prpPfeeDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPfeeDto.getEndorseNo());
        dbManager.setString(2,prpPfeeDto.getPolicyNo());
        dbManager.setString(3,prpPfeeDto.getRiskCode());
        dbManager.setString(4,prpPfeeDto.getCurrency());
        dbManager.setDouble(5,prpPfeeDto.getChgAmount());
        dbManager.setDouble(6,prpPfeeDto.getChgPremium());
        dbManager.setString(7,prpPfeeDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPfeeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPfeeDto prpPfeeDto = (PrpPfeeDto)i.next();
            insert(prpPfeeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @param currency 币别
     * @throws Exception
     */
    public void delete(String endorseNo,String currency) throws Exception{
        String statement = " Delete From PrpPfee" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPfee Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,currency);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPfeeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPfeeDto prpPfeeDto
     * @throws Exception
     */
    public void update(PrpPfeeDto prpPfeeDto) throws Exception{
        String statement = " Update PrpPfee Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " ChgAmount = ?," +
                           " ChgPremium = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPfee Set " +
                           " EndorseNo = '" + prpPfeeDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPfeeDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPfeeDto.getRiskCode() + "'," +
                           " Currency = '" + prpPfeeDto.getCurrency() + "'," +
                           " ChgAmount = '" + prpPfeeDto.getChgAmount() + "'," +
                           " ChgPremium = '" + prpPfeeDto.getChgPremium() + "'," +
                           " Flag = '" + prpPfeeDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPfeeDto.getEndorseNo() + "' And " +
                           " Currency = '" + prpPfeeDto.getCurrency() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPfeeDto.getPolicyNo());
        dbManager.setString(2,prpPfeeDto.getRiskCode());
        dbManager.setDouble(3,prpPfeeDto.getChgAmount());
        dbManager.setDouble(4,prpPfeeDto.getChgPremium());
        dbManager.setString(5,prpPfeeDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpPfeeDto.getEndorseNo());
        dbManager.setString(7,prpPfeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPfeeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @param currency 币别
     * @return PrpPfeeDto
     * @throws Exception
     */
    public PrpPfeeDto findByPrimaryKey(String endorseNo,String currency) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " Currency," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Flag From PrpPfee";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " Currency = ?";
        PrpPfeeDto prpPfeeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPfeeDto = new PrpPfeeDto();
            prpPfeeDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPfeeDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPfeeDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPfeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpPfeeDto.setChgAmount(dbManager.getDouble(resultSet,5));
            prpPfeeDto.setChgPremium(dbManager.getDouble(resultSet,6));
            prpPfeeDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        logger.info("DBPrpPfeeBase.findByPrimaryKey() success!");
        return prpPfeeDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " Currency," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Flag From PrpPfee Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPfeeDto prpPfeeDto = null;
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

            prpPfeeDto = new PrpPfeeDto();
            prpPfeeDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPfeeDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPfeeDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPfeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpPfeeDto.setChgAmount(dbManager.getDouble(resultSet,5));
            prpPfeeDto.setChgPremium(dbManager.getDouble(resultSet,6));
            prpPfeeDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpPfeeDto);
        }
        resultSet.close();
        logger.info("DBPrpPfeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpPfee Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPfeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPfee Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPfeeBase.getCount() success!");
        return count;
    }
}
