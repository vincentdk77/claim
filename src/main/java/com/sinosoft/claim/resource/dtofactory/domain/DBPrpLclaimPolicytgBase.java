package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicytgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimPolicy-立案保单清单表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimPolicytgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLclaimPolicytgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimPolicytgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void insert(PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimPolicytg (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimPolicytgDto.getClaimNo() + "'," + 
                           "'" + prpLclaimPolicytgDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimPolicytgDto.getCurrency() + "'," + 
                           "'" + prpLclaimPolicytgDto.getSumAmount() + "'," + 
                           "'" + prpLclaimPolicytgDto.getSumPremium() + "'," + 
                           "'" + prpLclaimPolicytgDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimPolicytgDto.getClaimNo());
        dbManager.setString(2,prpLclaimPolicytgDto.getPolicyNo());
        dbManager.setString(3,prpLclaimPolicytgDto.getCurrency());
        dbManager.setDouble(4,prpLclaimPolicytgDto.getSumAmount());
        dbManager.setDouble(5,prpLclaimPolicytgDto.getSumPremium());
        dbManager.setString(6,prpLclaimPolicytgDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimPolicytgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimPolicytg (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimPolicytgDto prpLclaimPolicytgDto = (PrpLclaimPolicytgDto)i.next();
            dbManager.setString(1,prpLclaimPolicytgDto.getClaimNo());
            dbManager.setString(2,prpLclaimPolicytgDto.getPolicyNo());
            dbManager.setString(3,prpLclaimPolicytgDto.getCurrency());
            dbManager.setDouble(4,prpLclaimPolicytgDto.getSumAmount());
            dbManager.setDouble(5,prpLclaimPolicytgDto.getSumPremium());
            dbManager.setString(6,prpLclaimPolicytgDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimPolicytgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String claimNo,String policyNo) throws Exception{
        String statement = " Delete From PrpLclaimPolicytg" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimPolicytg Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimPolicytgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimPolicytgDto prpLclaimPolicytgDto
     * @throws Exception
     */
    public void update(PrpLclaimPolicytgDto prpLclaimPolicytgDto) throws Exception{
        String statement = " Update PrpLclaimPolicytg Set Currency = ?," + 
                           " SumAmount = ?," + 
                           " SumPremium = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimPolicytg Set " + 
                           " ClaimNo = '" + prpLclaimPolicytgDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLclaimPolicytgDto.getPolicyNo() + "'," + 
                           " Currency = '" + prpLclaimPolicytgDto.getCurrency() + "'," + 
                           " SumAmount = '" + prpLclaimPolicytgDto.getSumAmount() + "'," + 
                           " SumPremium = '" + prpLclaimPolicytgDto.getSumPremium() + "'," + 
                           " Flag = '" + prpLclaimPolicytgDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLclaimPolicytgDto.getClaimNo() + "' And " + 
                           " PolicyNo = '" + prpLclaimPolicytgDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLclaimPolicytgDto.getCurrency());
        dbManager.setDouble(2,prpLclaimPolicytgDto.getSumAmount());
        dbManager.setDouble(3,prpLclaimPolicytgDto.getSumPremium());
        dbManager.setString(4,prpLclaimPolicytgDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpLclaimPolicytgDto.getClaimNo());
        dbManager.setString(6,prpLclaimPolicytgDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimPolicytgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @return PrpLclaimPolicytgDto
     * @throws Exception
     */
    public PrpLclaimPolicytgDto findByPrimaryKey(String claimNo,String policyNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag From PrpLclaimPolicytg";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        PrpLclaimPolicytgDto prpLclaimPolicytgDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimPolicytgDto = new PrpLclaimPolicytgDto();
            prpLclaimPolicytgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimPolicytgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimPolicytgDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimPolicytgDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpLclaimPolicytgDto.setSumPremium(dbManager.getDouble(resultSet,5));
            prpLclaimPolicytgDto.setFlag(dbManager.getString(resultSet,6));
            logger.info("DBPrpLclaimPolicytgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimPolicytgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimPolicytgDto;
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
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag From PrpLclaimPolicytg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimPolicytgDto prpLclaimPolicytgDto = null;
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

            prpLclaimPolicytgDto = new PrpLclaimPolicytgDto();
            prpLclaimPolicytgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimPolicytgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimPolicytgDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimPolicytgDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpLclaimPolicytgDto.setSumPremium(dbManager.getDouble(resultSet,5));
            prpLclaimPolicytgDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpLclaimPolicytgDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimPolicytgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimPolicytg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimPolicytgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimPolicytg Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimPolicytgBase.getCount() success!");
        return count;
    }
}
