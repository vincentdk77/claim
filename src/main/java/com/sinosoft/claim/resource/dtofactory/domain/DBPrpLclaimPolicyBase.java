package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimPolicyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimPolicy-立案保单清单表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimPolicyBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLclaimPolicyBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimPolicyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void insert(PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimPolicy (" + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimPolicyDto.getClaimNo() + "'," + 
                           "'" + prpLclaimPolicyDto.getPolicyNo() + "'," + 
                           "'" + prpLclaimPolicyDto.getCurrency() + "'," + 
                           "'" + prpLclaimPolicyDto.getSumAmount() + "'," + 
                           "'" + prpLclaimPolicyDto.getSumPremium() + "'," + 
                           "'" + prpLclaimPolicyDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimPolicyDto.getClaimNo());
        dbManager.setString(2,prpLclaimPolicyDto.getPolicyNo());
        dbManager.setString(3,prpLclaimPolicyDto.getCurrency());
        dbManager.setDouble(4,prpLclaimPolicyDto.getSumAmount());
        dbManager.setDouble(5,prpLclaimPolicyDto.getSumPremium());
        dbManager.setString(6,prpLclaimPolicyDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimPolicyBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimPolicy (" + 
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
            PrpLclaimPolicyDto prpLclaimPolicyDto = (PrpLclaimPolicyDto)i.next();
            dbManager.setString(1,prpLclaimPolicyDto.getClaimNo());
            dbManager.setString(2,prpLclaimPolicyDto.getPolicyNo());
            dbManager.setString(3,prpLclaimPolicyDto.getCurrency());
            dbManager.setDouble(4,prpLclaimPolicyDto.getSumAmount());
            dbManager.setDouble(5,prpLclaimPolicyDto.getSumPremium());
            dbManager.setString(6,prpLclaimPolicyDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimPolicyBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String claimNo,String policyNo) throws Exception{
        String statement = " Delete From PrpLclaimPolicy" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimPolicy Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimPolicyBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimPolicyDto prpLclaimPolicyDto
     * @throws Exception
     */
    public void update(PrpLclaimPolicyDto prpLclaimPolicyDto) throws Exception{
        String statement = " Update PrpLclaimPolicy Set Currency = ?," + 
                           " SumAmount = ?," + 
                           " SumPremium = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimPolicy Set " + 
                           " ClaimNo = '" + prpLclaimPolicyDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLclaimPolicyDto.getPolicyNo() + "'," + 
                           " Currency = '" + prpLclaimPolicyDto.getCurrency() + "'," + 
                           " SumAmount = '" + prpLclaimPolicyDto.getSumAmount() + "'," + 
                           " SumPremium = '" + prpLclaimPolicyDto.getSumPremium() + "'," + 
                           " Flag = '" + prpLclaimPolicyDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLclaimPolicyDto.getClaimNo() + "' And " + 
                           " PolicyNo = '" + prpLclaimPolicyDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLclaimPolicyDto.getCurrency());
        dbManager.setDouble(2,prpLclaimPolicyDto.getSumAmount());
        dbManager.setDouble(3,prpLclaimPolicyDto.getSumPremium());
        dbManager.setString(4,prpLclaimPolicyDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpLclaimPolicyDto.getClaimNo());
        dbManager.setString(6,prpLclaimPolicyDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimPolicyBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param policyNo 保单号
     * @return PrpLclaimPolicyDto
     * @throws Exception
     */
    public PrpLclaimPolicyDto findByPrimaryKey(String claimNo,String policyNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag From PrpLclaimPolicy";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " PolicyNo = ?";
        PrpLclaimPolicyDto prpLclaimPolicyDto = null;
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
            prpLclaimPolicyDto = new PrpLclaimPolicyDto();
            prpLclaimPolicyDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimPolicyDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimPolicyDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimPolicyDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpLclaimPolicyDto.setSumPremium(dbManager.getDouble(resultSet,5));
            prpLclaimPolicyDto.setFlag(dbManager.getString(resultSet,6));
            logger.info("DBPrpLclaimPolicyBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimPolicyBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimPolicyDto;
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
                           " Flag From PrpLclaimPolicy Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimPolicyDto prpLclaimPolicyDto = null;
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

            prpLclaimPolicyDto = new PrpLclaimPolicyDto();
            prpLclaimPolicyDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimPolicyDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLclaimPolicyDto.setCurrency(dbManager.getString(resultSet,3));
            prpLclaimPolicyDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpLclaimPolicyDto.setSumPremium(dbManager.getDouble(resultSet,5));
            prpLclaimPolicyDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpLclaimPolicyDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimPolicyBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimPolicy Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimPolicyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimPolicy Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimPolicyBase.getCount() success!");
        return count;
    }
}
