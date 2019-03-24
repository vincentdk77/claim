package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovtgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimApprov-代赔数据转出确认表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimApprovtgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLclaimApprovtgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimApprovtgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void insert(PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimApprovtg (" + 
                           " RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimApprovtgDto.getRegistNo() + "'," + 
                           "'" + prpLclaimApprovtgDto.getApproverCode() + "'," + 
                           "'" + prpLclaimApprovtgDto.getApprovDate() + "'," + 
                           "'" + prpLclaimApprovtgDto.getTransferStatus() + "'," + 
                           "'" + prpLclaimApprovtgDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimApprovtgDto.getRegistNo());
        dbManager.setString(2,prpLclaimApprovtgDto.getApproverCode());
        dbManager.setDateTime(3,prpLclaimApprovtgDto.getApprovDate());
        dbManager.setString(4,prpLclaimApprovtgDto.getTransferStatus());
        dbManager.setString(5,prpLclaimApprovtgDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimApprovtgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimApprovtg (" + 
                           " RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimApprovtgDto prpLclaimApprovtgDto = (PrpLclaimApprovtgDto)i.next();
            dbManager.setString(1,prpLclaimApprovtgDto.getRegistNo());
            dbManager.setString(2,prpLclaimApprovtgDto.getApproverCode());
            dbManager.setDateTime(3,prpLclaimApprovtgDto.getApprovDate());
            dbManager.setString(4,prpLclaimApprovtgDto.getTransferStatus());
            dbManager.setString(5,prpLclaimApprovtgDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimApprovtgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(String registNo) throws Exception{
        String statement = " Delete From PrpLclaimApprovtg" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimApprovtg Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimApprovtgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void update(PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        String statement = " Update PrpLclaimApprovtg Set ApproverCode = ?," + 
                           " ApprovDate = ?," + 
                           " TransferStatus = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimApprovtg Set " + 
                           " RegistNo = '" + prpLclaimApprovtgDto.getRegistNo() + "'," + 
                           " ApproverCode = '" + prpLclaimApprovtgDto.getApproverCode() + "'," + 
                           " ApprovDate = '" + prpLclaimApprovtgDto.getApprovDate() + "'," + 
                           " TransferStatus = '" + prpLclaimApprovtgDto.getTransferStatus() + "'," + 
                           " Flag = '" + prpLclaimApprovtgDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLclaimApprovtgDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLclaimApprovtgDto.getApproverCode());
        dbManager.setDateTime(2,prpLclaimApprovtgDto.getApprovDate());
        dbManager.setString(3,prpLclaimApprovtgDto.getTransferStatus());
        dbManager.setString(4,prpLclaimApprovtgDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpLclaimApprovtgDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimApprovtgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @return PrpLclaimApprovtgDto
     * @throws Exception
     */
    public PrpLclaimApprovtgDto findByPrimaryKey(String registNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag From PrpLclaimApprovtg";
        String statement = mainStatement + " Where " +
                           " RegistNo = ?";
        PrpLclaimApprovtgDto prpLclaimApprovtgDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimApprovtgDto = new PrpLclaimApprovtgDto();
            prpLclaimApprovtgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimApprovtgDto.setApproverCode(dbManager.getString(resultSet,2));
            prpLclaimApprovtgDto.setApprovDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLclaimApprovtgDto.setTransferStatus(dbManager.getString(resultSet,4));
            prpLclaimApprovtgDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLclaimApprovtgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimApprovtgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimApprovtgDto;
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
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag From PrpLclaimApprovtg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimApprovtgDto prpLclaimApprovtgDto = null;
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

            prpLclaimApprovtgDto = new PrpLclaimApprovtgDto();
            prpLclaimApprovtgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimApprovtgDto.setApproverCode(dbManager.getString(resultSet,2));
            prpLclaimApprovtgDto.setApprovDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLclaimApprovtgDto.setTransferStatus(dbManager.getString(resultSet,4));
            prpLclaimApprovtgDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLclaimApprovtgDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimApprovtgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimApprovtg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimApprovtgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimApprovtg Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimApprovtgBase.getCount() success!");
        return count;
    }
}
