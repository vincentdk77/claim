package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLqualityCheck-质量评审内容表的数据访问对象基类<br>
 * 创建于 2005-04-14 15:56:46.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLqualityCheckBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLqualityCheckBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLqualityCheckBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void insert(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        String mainStatement = " Insert Into PrpLqualityCheck (" + 
                           " RegistNo," + 
                           " QualityCheckType," + 
                           " SerialNo," + 
                           " TypeCode," + 
                           " TypeName," + 
                           " CheckResult," + 
                           " CheckRemark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLqualityCheckDto.getRegistNo() + "'," + 
                           "'" + prpLqualityCheckDto.getQualityCheckType() + "'," + 
                           "" + prpLqualityCheckDto.getSerialNo() + "," + 
                           "'" + prpLqualityCheckDto.getTypeCode() + "'," + 
                           "'" + prpLqualityCheckDto.getTypeName() + "'," + 
                           "'" + prpLqualityCheckDto.getCheckResult() + "'," + 
                           "'" + prpLqualityCheckDto.getCheckRemark() + "'," + 
                           "'" + prpLqualityCheckDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLqualityCheckDto.getRegistNo());
        dbManager.setString(2,prpLqualityCheckDto.getQualityCheckType());
        dbManager.setInt(3,prpLqualityCheckDto.getSerialNo());
        dbManager.setString(4,prpLqualityCheckDto.getTypeCode());
        dbManager.setString(5,prpLqualityCheckDto.getTypeName());
        dbManager.setString(6,prpLqualityCheckDto.getCheckResult());
        dbManager.setString(7,prpLqualityCheckDto.getCheckRemark());
        dbManager.setString(8,prpLqualityCheckDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLqualityCheckBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLqualityCheck (" + 
                           " RegistNo," + 
                           " QualityCheckType," + 
                           " SerialNo," + 
                           " TypeCode," + 
                           " TypeName," + 
                           " CheckResult," + 
                           " CheckRemark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLqualityCheckDto prpLqualityCheckDto = (PrpLqualityCheckDto)i.next();
            dbManager.setString(1,prpLqualityCheckDto.getRegistNo());
            dbManager.setString(2,prpLqualityCheckDto.getQualityCheckType());
            dbManager.setInt(3,prpLqualityCheckDto.getSerialNo());
            dbManager.setString(4,prpLqualityCheckDto.getTypeCode());
            dbManager.setString(5,prpLqualityCheckDto.getTypeName());
            dbManager.setString(6,prpLqualityCheckDto.getCheckResult());
            dbManager.setString(7,prpLqualityCheckDto.getCheckRemark());
            dbManager.setString(8,prpLqualityCheckDto.getFlag());        
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLqualityCheckBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,String qualityCheckType,int serialNo) throws Exception{
        String statement = " Delete From PrpLqualityCheck" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " QualityCheckType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLqualityCheck Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " QualityCheckType = '" + qualityCheckType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,qualityCheckType);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLqualityCheckBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void update(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        String statement = " Update PrpLqualityCheck Set TypeCode = ?," + 
                           " TypeName = ?," + 
                           " CheckResult = ?," + 
                           " CheckRemark = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " QualityCheckType = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLqualityCheck Set " + 
                           " RegistNo = '" + prpLqualityCheckDto.getRegistNo() + "'," + 
                           " QualityCheckType = '" + prpLqualityCheckDto.getQualityCheckType() + "'," + 
                           " SerialNo = " + prpLqualityCheckDto.getSerialNo() + "," + 
                           " TypeCode = '" + prpLqualityCheckDto.getTypeCode() + "'," + 
                           " TypeName = '" + prpLqualityCheckDto.getTypeName() + "'," + 
                           " CheckResult = '" + prpLqualityCheckDto.getCheckResult() + "'," + 
                           " CheckRemark = '" + prpLqualityCheckDto.getCheckRemark() + "'," + 
                           " Flag = '" + prpLqualityCheckDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLqualityCheckDto.getRegistNo() + "' And " + 
                           " QualityCheckType = '" + prpLqualityCheckDto.getQualityCheckType() + "' And " + 
                           " SerialNo = " + prpLqualityCheckDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLqualityCheckDto.getTypeCode());
        dbManager.setString(2,prpLqualityCheckDto.getTypeName());
        dbManager.setString(3,prpLqualityCheckDto.getCheckResult());
        dbManager.setString(4,prpLqualityCheckDto.getCheckRemark());
        dbManager.setString(5,prpLqualityCheckDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpLqualityCheckDto.getRegistNo());
        dbManager.setString(7,prpLqualityCheckDto.getQualityCheckType());
        dbManager.setInt(8,prpLqualityCheckDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLqualityCheckBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @return PrpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckDto findByPrimaryKey(String registNo,String qualityCheckType,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " QualityCheckType," + 
                           " SerialNo," + 
                           " TypeCode," + 
                           " TypeName," + 
                           " CheckResult," + 
                           " CheckRemark," + 
                           " Flag From PrpLqualityCheck";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " QualityCheckType = ? And " + 
                           " SerialNo = ?";
        PrpLqualityCheckDto prpLqualityCheckDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " QualityCheckType = '" + qualityCheckType + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,qualityCheckType);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLqualityCheckDto = new PrpLqualityCheckDto();
            prpLqualityCheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLqualityCheckDto.setQualityCheckType(dbManager.getString(resultSet,2));
            prpLqualityCheckDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLqualityCheckDto.setTypeCode(dbManager.getString(resultSet,4));
            prpLqualityCheckDto.setTypeName(dbManager.getString(resultSet,5));
            prpLqualityCheckDto.setCheckResult(dbManager.getString(resultSet,6));
            prpLqualityCheckDto.setCheckRemark(dbManager.getString(resultSet,7));
            prpLqualityCheckDto.setFlag(dbManager.getString(resultSet,8));
            logger.info("DBPrpLqualityCheckBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLqualityCheckBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLqualityCheckDto;
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
        String statement = "Select RegistNo," + 
                           " QualityCheckType," + 
                           " SerialNo," + 
                           " TypeCode," + 
                           " TypeName," + 
                           " CheckResult," + 
                           " CheckRemark," + 
                           " Flag From PrpLqualityCheck Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLqualityCheckDto prpLqualityCheckDto = null;
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

            prpLqualityCheckDto = new PrpLqualityCheckDto();
            prpLqualityCheckDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLqualityCheckDto.setQualityCheckType(dbManager.getString(resultSet,2));
            prpLqualityCheckDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLqualityCheckDto.setTypeCode(dbManager.getString(resultSet,4));
            prpLqualityCheckDto.setTypeName(dbManager.getString(resultSet,5));
            prpLqualityCheckDto.setCheckResult(dbManager.getString(resultSet,6));
            prpLqualityCheckDto.setCheckRemark(dbManager.getString(resultSet,7));
            prpLqualityCheckDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpLqualityCheckDto);
        }
        resultSet.close();
        logger.info("DBPrpLqualityCheckBase.findByConditions() success!");
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
        String statement = "Delete From PrpLqualityCheck Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLqualityCheckBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLqualityCheck Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLqualityCheckBase.getCount() success!");
        return count;
    }
}
