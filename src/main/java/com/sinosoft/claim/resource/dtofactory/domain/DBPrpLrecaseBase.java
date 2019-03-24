package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrecase-重开赔案表;的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLrecaseBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLrecaseBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLrecaseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void insert(PrpLrecaseDto prpLrecaseDto) throws Exception{
        String mainStatement = " Insert Into PrpLrecase (" + 
                           " ClaimNo," + 
                           " SerialNo," + 
                           " OpenCaseUserCode," + 
                           " OpenCaseDate," + 
                           " CloseCaseUserCode," + 
                           " CloseCaseDate," + 
                           " Flag," + 
                           " recaseMoney," +
                           " reCaseUploadFlag," +
                           " ReCaseReason)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLrecaseDto.getClaimNo() + "'," + 
                           "" + prpLrecaseDto.getSerialNo() + "," + 
                           "'" + prpLrecaseDto.getOpenCaseUserCode() + "'," + 
                           "'" + prpLrecaseDto.getOpenCaseDate() + "'," + 
                           "'" + prpLrecaseDto.getCloseCaseUserCode() + "'," + 
                           "'" + prpLrecaseDto.getCloseCaseDate() + "'," + 
                           "'" + prpLrecaseDto.getFlag()  + "'," + 
                           "'" + prpLrecaseDto.getRecaseMoney()  + "'," + 
                           "'" + prpLrecaseDto.getReCaseUploadFlag()  + "'," + 
                          
                           "'" + prpLrecaseDto.getReCaseReason() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLrecaseDto.getClaimNo());
        dbManager.setInt(2,prpLrecaseDto.getSerialNo());
        dbManager.setString(3,prpLrecaseDto.getOpenCaseUserCode());
        dbManager.setDateTime(4,prpLrecaseDto.getOpenCaseDate());
        dbManager.setString(5,prpLrecaseDto.getCloseCaseUserCode());
        dbManager.setDateTime(6,prpLrecaseDto.getCloseCaseDate());
        dbManager.setString(7,prpLrecaseDto.getFlag());
        dbManager.setDouble(8,prpLrecaseDto.getRecaseMoney());
        dbManager.setString(9,prpLrecaseDto.getReCaseUploadFlag());
        dbManager.setString(10,prpLrecaseDto.getReCaseReason());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrecaseBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLrecase (" + 
                           " ClaimNo," + 
                           " SerialNo," + 
                           " OpenCaseUserCode," + 
                           " OpenCaseDate," + 
                           " CloseCaseUserCode," + 
                           " CloseCaseDate," + 
                           " Flag," + 
                           " recaseMoney," +
                           " reCaseUploadFlag," +
                           " ReCaseReason)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLrecaseDto prpLrecaseDto = (PrpLrecaseDto)i.next();
            dbManager.setString(1,prpLrecaseDto.getClaimNo());
            dbManager.setInt(2,prpLrecaseDto.getSerialNo());
            dbManager.setString(3,prpLrecaseDto.getOpenCaseUserCode());
            dbManager.setDateTime(4,prpLrecaseDto.getOpenCaseDate());
            dbManager.setString(5,prpLrecaseDto.getCloseCaseUserCode());
            dbManager.setDateTime(6,prpLrecaseDto.getCloseCaseDate());
            dbManager.setString(7,prpLrecaseDto.getFlag());
            dbManager.setDouble(8,prpLrecaseDto.getRecaseMoney());
            dbManager.setString(9,prpLrecaseDto.getReCaseUploadFlag());
            dbManager.setString(10,prpLrecaseDto.getReCaseReason());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLrecaseBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLrecase" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLrecase Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLrecaseBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLrecaseDto prpLrecaseDto
     * @throws Exception
     */
    public void update(PrpLrecaseDto prpLrecaseDto) throws Exception{
        String statement = " Update PrpLrecase Set OpenCaseUserCode = ?," + 
                           " OpenCaseDate = ?," + 
                           " CloseCaseUserCode = ?," + 
                           " CloseCaseDate = ?," + 
                           " Flag = ?," + 
                           " recaseMoney= ?," +
                           " reCaseUploadFlag= ?," +
                           " ReCaseReason = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLrecase Set " + 
                           " ClaimNo = '" + prpLrecaseDto.getClaimNo() + "'," + 
                           " SerialNo = " + prpLrecaseDto.getSerialNo() + "," + 
                           " OpenCaseUserCode = '" + prpLrecaseDto.getOpenCaseUserCode() + "'," + 
                           " OpenCaseDate = '" + prpLrecaseDto.getOpenCaseDate() + "'," + 
                           " CloseCaseUserCode = '" + prpLrecaseDto.getCloseCaseUserCode() + "'," + 
                           " CloseCaseDate = '" + prpLrecaseDto.getCloseCaseDate() + "'," + 
                           " Flag = '" + prpLrecaseDto.getFlag() + "'," + 
                           " RecaseMoney = '" + prpLrecaseDto.getRecaseMoney() + "'," + 
                           " ReCaseUploadFlag = '" + prpLrecaseDto.getReCaseUploadFlag() + "'," + 
                           " ReCaseReason = '" + prpLrecaseDto.getReCaseReason() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLrecaseDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLrecaseDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLrecaseDto.getOpenCaseUserCode());
        dbManager.setDateTime(2,prpLrecaseDto.getOpenCaseDate());
        dbManager.setString(3,prpLrecaseDto.getCloseCaseUserCode());
        dbManager.setDateTime(4,prpLrecaseDto.getCloseCaseDate());
        dbManager.setString(5,prpLrecaseDto.getFlag());
        dbManager.setDouble(6,prpLrecaseDto.getRecaseMoney());
        dbManager.setString(7,prpLrecaseDto.getReCaseUploadFlag());
        dbManager.setString(8,prpLrecaseDto.getReCaseReason());
        //设置条件字段;
        dbManager.setString(9,prpLrecaseDto.getClaimNo());
        dbManager.setInt(10,prpLrecaseDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrecaseBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @return PrpLrecaseDto
     * @throws Exception
     */
    public PrpLrecaseDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " SerialNo," + 
                           " OpenCaseUserCode," + 
                           " OpenCaseDate," + 
                           " CloseCaseUserCode," + 
                           " CloseCaseDate," + 

                           " Flag," + 
                           " recaseMoney," +
                           " reCaseUploadFlag," +
                           " ReCaseReason From PrpLrecase";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLrecaseDto prpLrecaseDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLrecaseDto = new PrpLrecaseDto();
            prpLrecaseDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrecaseDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLrecaseDto.setOpenCaseUserCode(dbManager.getString(resultSet,3));
            prpLrecaseDto.setOpenCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLrecaseDto.setCloseCaseUserCode(dbManager.getString(resultSet,5));
            prpLrecaseDto.setCloseCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            prpLrecaseDto.setFlag(dbManager.getString(resultSet,7));
            prpLrecaseDto.setRecaseMoney(dbManager.getDouble(resultSet,8));
            prpLrecaseDto.setReCaseUploadFlag(dbManager.getString(resultSet,9));
            prpLrecaseDto.setReCaseReason(dbManager.getString(resultSet,10));
            logger.info("DBPrpLrecaseBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLrecaseBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLrecaseDto;
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
                           " SerialNo," + 
                           " OpenCaseUserCode," + 
                           " OpenCaseDate," + 
                           " CloseCaseUserCode," + 
                           " CloseCaseDate," + 

                           " Flag," + 
                           " recaseMoney," +
                           " reCaseUploadFlag," +
                           " ReCaseReason From PrpLrecase Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLrecaseDto prpLrecaseDto = null;
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

            prpLrecaseDto = new PrpLrecaseDto();
            prpLrecaseDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrecaseDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLrecaseDto.setOpenCaseUserCode(dbManager.getString(resultSet,3));
            prpLrecaseDto.setOpenCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLrecaseDto.setCloseCaseUserCode(dbManager.getString(resultSet,5));
            prpLrecaseDto.setCloseCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            prpLrecaseDto.setFlag(dbManager.getString(resultSet,7));
            prpLrecaseDto.setRecaseMoney(dbManager.getDouble(resultSet,8));
            prpLrecaseDto.setReCaseUploadFlag(dbManager.getString(resultSet,9));
            prpLrecaseDto.setReCaseReason(dbManager.getString(resultSet,10));
            collection.add(prpLrecaseDto);
        }
        resultSet.close();
        logger.info("DBPrpLrecaseBase.findByConditions() success!");
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
        String statement = "Delete From PrpLrecase Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLrecaseBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLrecase Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLrecaseBase.getCount() success!");
        return count;
    }
}
