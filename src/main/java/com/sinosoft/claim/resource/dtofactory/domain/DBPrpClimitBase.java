package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpClimit的数据访问对象基类<br>
 * 创建于 2006-06-09 15:31:29.968<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpClimitBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpClimitBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpClimitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void insert(PrpClimitDto prpClimitDto) throws Exception{
        String mainStatement = " Insert Into PrpClimit (" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " LimitGrade," + 
                           " LimitNo," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFee," + 
                           " CalculateFlag," + 
                           " LimitFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpClimitDto.getPolicyNo() + "'," + 
                           "'" + prpClimitDto.getRiskCode() + "'," + 
                           "'" + prpClimitDto.getLimitGrade() + "'," + 
                           "'" + prpClimitDto.getLimitNo() + "'," + 
                           "'" + prpClimitDto.getLimitType() + "'," + 
                           "'" + prpClimitDto.getCurrency() + "'," + 
                           "'" + prpClimitDto.getLimitFee() + "'," + 
                           "'" + prpClimitDto.getCalculateFlag() + "'," + 
                           "'" + prpClimitDto.getLimitFlag() + "'," + 
                           "'" + prpClimitDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpClimitDto.getPolicyNo());
        dbManager.setString(2,prpClimitDto.getRiskCode());
        dbManager.setString(3,prpClimitDto.getLimitGrade());
        dbManager.setDouble(4,prpClimitDto.getLimitNo());
        dbManager.setString(5,prpClimitDto.getLimitType());
        dbManager.setString(6,prpClimitDto.getCurrency());
        dbManager.setDouble(7,prpClimitDto.getLimitFee());
        dbManager.setString(8,prpClimitDto.getCalculateFlag());
        dbManager.setString(9,prpClimitDto.getLimitFlag());
        dbManager.setString(10,prpClimitDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpClimitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpClimitDto prpClimitDto = (PrpClimitDto)i.next();
            insert(prpClimitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @throws Exception
     */
    public void delete(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        String statement = " Delete From PrpClimit" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " LimitGrade = ? And " + 
                           " LimitNo = ? And " + 
                           " LimitType = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpClimit Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " LimitGrade = '" + limitGrade + "' And " + 
                           " LimitNo = '" + limitNo + "' And " + 
                           " LimitType = '" + limitType + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,limitGrade);
        dbManager.setDouble(3,limitNo);
        dbManager.setString(4,limitType);
        dbManager.setString(5,currency);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpClimitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void update(PrpClimitDto prpClimitDto) throws Exception{
        String statement = " Update PrpClimit Set RiskCode = ?," + 
                           " LimitFee = ?," + 
                           " CalculateFlag = ?," + 
                           " LimitFlag = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " LimitGrade = ? And " + 
                           " LimitNo = ? And " + 
                           " LimitType = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpClimit Set " + 
                           " PolicyNo = '" + prpClimitDto.getPolicyNo() + "'," + 
                           " RiskCode = '" + prpClimitDto.getRiskCode() + "'," + 
                           " LimitGrade = '" + prpClimitDto.getLimitGrade() + "'," + 
                           " LimitNo = '" + prpClimitDto.getLimitNo() + "'," + 
                           " LimitType = '" + prpClimitDto.getLimitType() + "'," + 
                           " Currency = '" + prpClimitDto.getCurrency() + "'," + 
                           " LimitFee = '" + prpClimitDto.getLimitFee() + "'," + 
                           " CalculateFlag = '" + prpClimitDto.getCalculateFlag() + "'," + 
                           " LimitFlag = '" + prpClimitDto.getLimitFlag() + "'," + 
                           " Flag = '" + prpClimitDto.getFlag() + "'" + 
			               " Where " +
                           " PolicyNo = '" + prpClimitDto.getPolicyNo() + "' And " + 
                           " LimitGrade = '" + prpClimitDto.getLimitGrade() + "' And " + 
                           " LimitNo = '" + prpClimitDto.getLimitNo() + "' And " + 
                           " LimitType = '" + prpClimitDto.getLimitType() + "' And " + 
                           " Currency = '" + prpClimitDto.getCurrency() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpClimitDto.getRiskCode());
        dbManager.setDouble(2,prpClimitDto.getLimitFee());
        dbManager.setString(3,prpClimitDto.getCalculateFlag());
        dbManager.setString(4,prpClimitDto.getLimitFlag());
        dbManager.setString(5,prpClimitDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpClimitDto.getPolicyNo());
        dbManager.setString(7,prpClimitDto.getLimitGrade());
        dbManager.setDouble(8,prpClimitDto.getLimitNo());
        dbManager.setString(9,prpClimitDto.getLimitType());
        dbManager.setString(10,prpClimitDto.getCurrency());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpClimitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @return PrpClimitDto
     * @throws Exception
     */
    public PrpClimitDto findByPrimaryKey(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        String mainStatement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " LimitGrade," + 
                           " LimitNo," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFee," + 
                           " CalculateFlag," + 
                           " LimitFlag," + 
                           " Flag From PrpClimit";
        String statement = mainStatement + " Where " +
                           " PolicyNo = ? And " + 
                           " LimitGrade = ? And " + 
                           " LimitNo = ? And " + 
                           " LimitType = ? And " + 
                           " Currency = ?";
        PrpClimitDto prpClimitDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " LimitGrade = '" + limitGrade + "' And " + 
                           " LimitNo = '" + limitNo + "' And " + 
                           " LimitType = '" + limitType + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,limitGrade);
        dbManager.setDouble(3,limitNo);
        dbManager.setString(4,limitType);
        dbManager.setString(5,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpClimitDto = new PrpClimitDto();
            prpClimitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpClimitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpClimitDto.setLimitGrade(dbManager.getString(resultSet,3));
            prpClimitDto.setLimitNo(dbManager.getDouble(resultSet,4));
            prpClimitDto.setLimitType(dbManager.getString(resultSet,5));
            prpClimitDto.setCurrency(dbManager.getString(resultSet,6));
            prpClimitDto.setLimitFee(dbManager.getDouble(resultSet,7));
            prpClimitDto.setCalculateFlag(dbManager.getString(resultSet,8));
            prpClimitDto.setLimitFlag(dbManager.getString(resultSet,9));
            prpClimitDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        logger.info("DBPrpClimitBase.findByPrimaryKey() success!");
        return prpClimitDto;
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
        String statement = "Select PolicyNo," + 
                           " RiskCode," + 
                           " LimitGrade," + 
                           " LimitNo," + 
                           " LimitType," + 
                           " Currency," + 
                           " LimitFee," + 
                           " CalculateFlag," + 
                           " LimitFlag," + 
                           " Flag From PrpClimit Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpClimitDto prpClimitDto = null;
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

            prpClimitDto = new PrpClimitDto();
            prpClimitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpClimitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpClimitDto.setLimitGrade(dbManager.getString(resultSet,3));
            prpClimitDto.setLimitNo(dbManager.getDouble(resultSet,4));
            prpClimitDto.setLimitType(dbManager.getString(resultSet,5));
            prpClimitDto.setCurrency(dbManager.getString(resultSet,6));
            prpClimitDto.setLimitFee(dbManager.getDouble(resultSet,7));
            prpClimitDto.setCalculateFlag(dbManager.getString(resultSet,8));
            prpClimitDto.setLimitFlag(dbManager.getString(resultSet,9));
            prpClimitDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpClimitDto);
        }
        resultSet.close();
        logger.info("DBPrpClimitBase.findByConditions() success!");
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
        String statement = "Delete From PrpClimit Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpClimitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpClimit Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpClimitBase.getCount() success!");
        return count;
    }
}
