package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimFeeBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLclaimFeeBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimFeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimFee (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumClaim," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimFeeDto.getClaimNo() + "'," + 
                           "'" + prpLclaimFeeDto.getRiskCode() + "'," + 
                           "'" + prpLclaimFeeDto.getCurrency() + "'," + 
                           "'" + prpLclaimFeeDto.getSumClaim() + "'," + 
                           "'" + prpLclaimFeeDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimFeeDto.getClaimNo());
        dbManager.setString(2,prpLclaimFeeDto.getRiskCode());
        dbManager.setString(3,prpLclaimFeeDto.getCurrency());
        dbManager.setDouble(4,prpLclaimFeeDto.getSumClaim());
        dbManager.setString(5,prpLclaimFeeDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimFeeBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimFee (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumClaim," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimFeeDto prpLclaimFeeDto = (PrpLclaimFeeDto)i.next();
            dbManager.setString(1,prpLclaimFeeDto.getClaimNo());
            dbManager.setString(2,prpLclaimFeeDto.getRiskCode());
            dbManager.setString(3,prpLclaimFeeDto.getCurrency());
            dbManager.setDouble(4,prpLclaimFeeDto.getSumClaim());
            dbManager.setString(5,prpLclaimFeeDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimFeeBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(String claimNo,String currency) throws Exception{
        String statement = " Delete From PrpLclaimFee" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimFee Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,currency);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimFeeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void update(PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        String statement = " Update PrpLclaimFee Set RiskCode = ?," + 
                           " SumClaim = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimFee Set " + 
                           " ClaimNo = '" + prpLclaimFeeDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLclaimFeeDto.getRiskCode() + "'," + 
                           " Currency = '" + prpLclaimFeeDto.getCurrency() + "'," + 
                           " SumClaim = '" + prpLclaimFeeDto.getSumClaim() + "'," + 
                           " Flag = '" + prpLclaimFeeDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLclaimFeeDto.getClaimNo() + "' And " + 
                           " Currency = '" + prpLclaimFeeDto.getCurrency() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLclaimFeeDto.getRiskCode());
        dbManager.setDouble(2,prpLclaimFeeDto.getSumClaim());
        dbManager.setString(3,prpLclaimFeeDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpLclaimFeeDto.getClaimNo());
        dbManager.setString(5,prpLclaimFeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimFeeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @return PrpLclaimFeeDto
     * @throws Exception
     */
    public PrpLclaimFeeDto findByPrimaryKey(String claimNo,String currency) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumClaim," + 
                           " Flag From PrpLclaimFee";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " Currency = ?";
        PrpLclaimFeeDto prpLclaimFeeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimFeeDto = new PrpLclaimFeeDto();
            prpLclaimFeeDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimFeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimFeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimFeeDto.setSumClaim(dbManager.getDouble(resultSet,4));
            prpLclaimFeeDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLclaimFeeBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimFeeBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimFeeDto;
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
        String statement = "Select ClaimNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumClaim," + 
                           " Flag From PrpLclaimFee Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimFeeDto prpLclaimFeeDto = null;
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

            prpLclaimFeeDto = new PrpLclaimFeeDto();
            prpLclaimFeeDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimFeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimFeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimFeeDto.setSumClaim(dbManager.getDouble(resultSet,4));
            prpLclaimFeeDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLclaimFeeDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimFeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimFee Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimFeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimFee Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimFeeBase.getCount() success!");
        return count;
    }
}
