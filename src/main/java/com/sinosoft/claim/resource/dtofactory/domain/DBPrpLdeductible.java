package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductibleDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;
public class DBPrpLdeductible{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLctextBase.class);
    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLdeductible(DBManager dbManager){
        this.dbManager = dbManager;
    }
    /**
     * 插入一条数据
     * @param prpLctextDto prpLctextDto
     * @throws Exception
     */
    public void insert(PrpLdeductibleDto prpLdeductibleDto) throws Exception{
        String mainStatement = " Insert Into PrpLdeductible (" + 
                           " CompensateNo," + 
                           " SerialNo," + 
                           " kindCode," + 
                           " SumKindPaid," + 
                           " ClaimNo," + 
                           " DeductibleLevel," + 
                           " Currency," + 
                           " Deductible," + 
                           " DeductibleRate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLdeductibleDto.getCompensateNo() + "'," + 
                           "'" + prpLdeductibleDto.getSerialNo() + "'," + 
                           "'" + prpLdeductibleDto.getKindCode() + "'," + 
                           "'" + prpLdeductibleDto.getSumKindPaid() + "'," + 
                           "'" + prpLdeductibleDto.getClaimNo() + "'," + 
                           "'" + prpLdeductibleDto.getDeductibleLevel() + "'," + 
                           "'" + prpLdeductibleDto.getCurrency() + "'," + 
                           "'" + prpLdeductibleDto.getDeductible() + "'," + 
                           "'" + prpLdeductibleDto.getDeductibleRate() + "'," + 
                           "'" + prpLdeductibleDto.getFlag() + "')";
            logger.debug(debugStatement);
        }
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLdeductibleDto.getCompensateNo());
        dbManager.setString(2,prpLdeductibleDto.getSerialNo());
        dbManager.setString(3,prpLdeductibleDto.getKindCode());
        dbManager.setDouble(4,prpLdeductibleDto.getSumKindPaid());
        dbManager.setString(5,prpLdeductibleDto.getClaimNo());
        dbManager.setString(6,prpLdeductibleDto.getDeductibleLevel());
        dbManager.setString(7,prpLdeductibleDto.getCurrency());
        dbManager.setString(8,prpLdeductibleDto.getDeductible());
        dbManager.setString(9,prpLdeductibleDto.getDeductibleRate());
        dbManager.setString(10,prpLdeductibleDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("PrpLdeductible.insert() success!");
    }
    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLdeductible (" + 
                               " CompensateNo," + 
                               " SerialNo," + 
                               " kindCode," + 
                               " SumKindPaid," + 
                               " ClaimNo," + 
                               " DeductibleLevel," + 
                               " Currency," + 
                               " Deductible," + 
                               " DeductibleRate," + 
                               " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLdeductibleDto prpLdeductibleDto = (PrpLdeductibleDto)i.next();
            dbManager.setString(1,prpLdeductibleDto.getCompensateNo());
            dbManager.setString(2,prpLdeductibleDto.getSerialNo());
            dbManager.setString(3,prpLdeductibleDto.getKindCode());
            dbManager.setDouble(4,prpLdeductibleDto.getSumKindPaid());
            dbManager.setString(5,prpLdeductibleDto.getClaimNo());
            dbManager.setString(6,prpLdeductibleDto.getDeductibleLevel());
            dbManager.setString(7,prpLdeductibleDto.getCurrency());
            dbManager.setString(8,prpLdeductibleDto.getDeductible());
            dbManager.setString(9,prpLdeductibleDto.getDeductibleRate());
            dbManager.setString(10,prpLdeductibleDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("PrpLdeductible.insertAll() success!");
    }
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLdeductibleDto prpLdeductibleDto
     * @throws Exception
     */
    public void update(PrpLdeductibleDto prpLdeductibleDto) throws Exception{
        String statement = " Update PrpLdeductible Set CompensateNo = ?," + 
                           " SerialNo = ?" + 
                           " kindCode = ?" + 
                           " SumKindPaid = ?" + 
                           " ClaimNo = ?" + 
                           " DeductibleLevel = ?" +
                           " Currency = ?" +
                           " Deductible = ?" +
                           " DeductibleRate = ?" +
                           " Flag = ?" +
                           " Where " +
                           " CompensateNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLdeductible Set " + 
                           " CompensateNo = '" + prpLdeductibleDto.getCompensateNo() + "'," +
                           " SerialNo = '" + prpLdeductibleDto.getSerialNo() + "'," + 
                           " kindCode = '" + prpLdeductibleDto.getKindCode() + "'," + 
                           " SumKindPaid = '" + prpLdeductibleDto.getSumKindPaid() + "'," + 
                           " ClaimNo = '" + prpLdeductibleDto.getClaimNo() + "'," + 
                           " DeductibleLevel = " + prpLdeductibleDto.getDeductibleLevel() + "," +  
                           " Currency = " + prpLdeductibleDto.getCurrency() + "," + 
                           " Deductible = " + prpLdeductibleDto.getDeductible() + "," + 
                           " DeductibleRate = " + prpLdeductibleDto.getDeductibleRate() + "," + 
                           " Flag = " + prpLdeductibleDto.getFlag() + "," + 
                           " Where " +
                           " CompensateNo = '" + prpLdeductibleDto.getCompensateNo() + "' And " + 
                           " SerialNo = " + prpLdeductibleDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLdeductibleDto.getClaimNo());
        dbManager.setString(2,prpLdeductibleDto.getDeductibleLevel());
        dbManager.setString(3,prpLdeductibleDto.getCurrency());
        dbManager.setString(4,prpLdeductibleDto.getDeductible());
        dbManager.setString(5,prpLdeductibleDto.getDeductibleRate());
        dbManager.setString(6,prpLdeductibleDto.getFlag());
        dbManager.setString(7,prpLdeductibleDto.getKindCode());
        dbManager.setDouble(8,prpLdeductibleDto.getSumKindPaid());
        //设置条件字段;
        dbManager.setString(9,prpLdeductibleDto.getCompensateNo());
        dbManager.setString(10,prpLdeductibleDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("prpLdeductibleDto.update() success!");
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
        String statement = "Select CompensateNo," + 
                           " SerialNo," + 
                           " kindCode," + 
                           " SumKindPaid," + 
                           " ClaimNo," + 
                           " DeductibleLevel," + 
                           " Currency," + 
                           " Deductible," + 
                           " DeductibleRate," + 
                           " Flag From PrpLdeductible Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLdeductibleDto prpLdeductibleDto = null;
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
            prpLdeductibleDto = new PrpLdeductibleDto();
            prpLdeductibleDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLdeductibleDto.setSerialNo(dbManager.getString(resultSet,2));
            prpLdeductibleDto.setKindCode(dbManager.getString(resultSet,3));
            prpLdeductibleDto.setSumKindPaid(dbManager.getDouble(resultSet,4));
            prpLdeductibleDto.setClaimNo(dbManager.getString(resultSet,5));
            prpLdeductibleDto.setDeductibleLevel(dbManager.getString(resultSet,6));
            prpLdeductibleDto.setCurrency(dbManager.getString(resultSet,7));
            prpLdeductibleDto.setDeductible(dbManager.getString(resultSet,8));
            prpLdeductibleDto.setDeductibleRate(dbManager.getString(resultSet,9));
            prpLdeductibleDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpLdeductibleDto);
        }
        resultSet.close();
        logger.info("DBprpLdeductibleBase.findByConditions() success!");
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
        String statement = "Delete From PrpLdeductible Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLdeductible.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLdeductible Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLdeductible.getCount() success!");
        return count;
    }
}
