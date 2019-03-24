package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcaseNo-赔案号表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcaseNoBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcaseNoBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcaseNoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void insert(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        String mainStatement = " Insert Into PrpLcaseNo (" + 
                           " CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcaseNoDto.getCertiNo() + "'," + 
                           "'" + prpLcaseNoDto.getCertiType() + "'," + 
                           "'" + prpLcaseNoDto.getCaseNo() + "'," + 
                           "'" + prpLcaseNoDto.getFlag() + "'," + 
                           "'" + prpLcaseNoDto.getClaimNo() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcaseNoDto.getCertiNo());
        dbManager.setString(2,prpLcaseNoDto.getCertiType());
        dbManager.setString(3,prpLcaseNoDto.getCaseNo());
        dbManager.setString(4,prpLcaseNoDto.getFlag());
        dbManager.setString(5,prpLcaseNoDto.getClaimNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcaseNoBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcaseNo (" + 
                           " CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcaseNoDto prpLcaseNoDto = (PrpLcaseNoDto)i.next();
            dbManager.setString(1,prpLcaseNoDto.getCertiNo());
            dbManager.setString(2,prpLcaseNoDto.getCertiType());
            dbManager.setString(3,prpLcaseNoDto.getCaseNo());
            dbManager.setString(4,prpLcaseNoDto.getFlag());
            dbManager.setString(5,prpLcaseNoDto.getClaimNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcaseNoBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 单证号
     * @param certiType 单证类型
     * @param caseNo 赔案号
     * @throws Exception
     */
    public void delete(String certiNo,String certiType,String caseNo) throws Exception{
        String statement = " Delete From PrpLcaseNo" + 
	            		   " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcaseNo Where " +
                           " CertiNo = '" + certiNo + "' And " + 
                           " CertiType = '" + certiType + "' And " + 
                           " CaseNo = '" + caseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setString(3,caseNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcaseNoBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void update(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        String statement = " Update PrpLcaseNo Set Flag = ?," + 
                           " ClaimNo = ?" + 
	            		   " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcaseNo Set " + 
                           " CertiNo = '" + prpLcaseNoDto.getCertiNo() + "'," + 
                           " CertiType = '" + prpLcaseNoDto.getCertiType() + "'," + 
                           " CaseNo = '" + prpLcaseNoDto.getCaseNo() + "'," + 
                           " Flag = '" + prpLcaseNoDto.getFlag() + "'," + 
                           " ClaimNo = '" + prpLcaseNoDto.getClaimNo() + "'" + 
			               " Where " +
                           " CertiNo = '" + prpLcaseNoDto.getCertiNo() + "' And " + 
                           " CertiType = '" + prpLcaseNoDto.getCertiType() + "' And " + 
                           " CaseNo = '" + prpLcaseNoDto.getCaseNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcaseNoDto.getFlag());
        dbManager.setString(2,prpLcaseNoDto.getClaimNo());
        //设置条件字段;
        dbManager.setString(3,prpLcaseNoDto.getCertiNo());
        dbManager.setString(4,prpLcaseNoDto.getCertiType());
        dbManager.setString(5,prpLcaseNoDto.getCaseNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcaseNoBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param certiNo 单证号
     * @param certiType 单证类型
     * @param caseNo 赔案号
     * @return PrpLcaseNoDto
     * @throws Exception
     */
    public PrpLcaseNoDto findByPrimaryKey(String certiNo,String certiType,String caseNo) throws Exception{
        String mainStatement = " Select CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo From PrpLcaseNo";
        String statement = mainStatement + " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        PrpLcaseNoDto prpLcaseNoDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CertiNo = '" + certiNo + "' And " + 
                           " CertiType = '" + certiType + "' And " + 
                           " CaseNo = '" + caseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setString(3,caseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcaseNoDto = new PrpLcaseNoDto();
            prpLcaseNoDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLcaseNoDto.setCertiType(dbManager.getString(resultSet,2));
            prpLcaseNoDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcaseNoDto.setFlag(dbManager.getString(resultSet,4));
            prpLcaseNoDto.setClaimNo(dbManager.getString(resultSet,5));
            logger.info("DBPrpLcaseNoBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcaseNoBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcaseNoDto;
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
        String statement = "Select CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo From PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcaseNoDto prpLcaseNoDto = null;
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

            prpLcaseNoDto = new PrpLcaseNoDto();
            prpLcaseNoDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLcaseNoDto.setCertiType(dbManager.getString(resultSet,2));
            prpLcaseNoDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcaseNoDto.setFlag(dbManager.getString(resultSet,4));
            prpLcaseNoDto.setClaimNo(dbManager.getString(resultSet,5));
            collection.add(prpLcaseNoDto);
        }
        resultSet.close();
        logger.info("DBPrpLcaseNoBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcaseNoBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcaseNoBase.getCount() success!");
        return count;
    }
}
