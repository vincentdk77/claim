package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrecasetgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrecase-重开赔案表;的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLrecasetgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLrecasetgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLrecasetgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLrecasetgDto prpLrecasetgDto
     * @throws Exception
     */
    public void insert(PrpLrecasetgDto prpLrecasetgDto) throws Exception{
        String mainStatement = " Insert Into PrpLrecasetg (" + 
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
                           "'" + prpLrecasetgDto.getClaimNo() + "'," + 
                           "" + prpLrecasetgDto.getSerialNo() + "," + 
                           "'" + prpLrecasetgDto.getOpenCaseUserCode() + "'," + 
                           "'" + prpLrecasetgDto.getOpenCaseDate() + "'," + 
                           "'" + prpLrecasetgDto.getCloseCaseUserCode() + "'," + 
                           "'" + prpLrecasetgDto.getCloseCaseDate() + "'," + 
                           "'" + prpLrecasetgDto.getFlag()  + "'," + 
                           "'" + prpLrecasetgDto.getRecaseMoney()  + "'," + 
                           "'" + prpLrecasetgDto.getReCaseUploadFlag()  + "'," + 
                          
                           "'" + prpLrecasetgDto.getReCaseReason() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLrecasetgDto.getClaimNo());
        dbManager.setInt(2,prpLrecasetgDto.getSerialNo());
        dbManager.setString(3,prpLrecasetgDto.getOpenCaseUserCode());
        dbManager.setDateTime(4,prpLrecasetgDto.getOpenCaseDate());
        dbManager.setString(5,prpLrecasetgDto.getCloseCaseUserCode());
        dbManager.setDateTime(6,prpLrecasetgDto.getCloseCaseDate());
        dbManager.setString(7,prpLrecasetgDto.getFlag());
        dbManager.setDouble(8,prpLrecasetgDto.getRecaseMoney());
        dbManager.setString(9,prpLrecasetgDto.getReCaseUploadFlag());
        dbManager.setString(10,prpLrecasetgDto.getReCaseReason());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrecasetgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLrecasetg (" + 
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
            PrpLrecasetgDto prpLrecasetgDto = (PrpLrecasetgDto)i.next();
            dbManager.setString(1,prpLrecasetgDto.getClaimNo());
            dbManager.setInt(2,prpLrecasetgDto.getSerialNo());
            dbManager.setString(3,prpLrecasetgDto.getOpenCaseUserCode());
            dbManager.setDateTime(4,prpLrecasetgDto.getOpenCaseDate());
            dbManager.setString(5,prpLrecasetgDto.getCloseCaseUserCode());
            dbManager.setDateTime(6,prpLrecasetgDto.getCloseCaseDate());
            dbManager.setString(7,prpLrecasetgDto.getFlag());
            dbManager.setDouble(8,prpLrecasetgDto.getRecaseMoney());
            dbManager.setString(9,prpLrecasetgDto.getReCaseUploadFlag());
            dbManager.setString(10,prpLrecasetgDto.getReCaseReason());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLrecasetgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLrecasetg" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLrecasetg Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLrecasetgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLrecasetgDto prpLrecasetgDto
     * @throws Exception
     */
    public void update(PrpLrecasetgDto prpLrecasetgDto) throws Exception{
        String statement = " Update PrpLrecasetg Set OpenCaseUserCode = ?," + 
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
            String debugStatement = "Update PrpLrecasetg Set " + 
                           " ClaimNo = '" + prpLrecasetgDto.getClaimNo() + "'," + 
                           " SerialNo = " + prpLrecasetgDto.getSerialNo() + "," + 
                           " OpenCaseUserCode = '" + prpLrecasetgDto.getOpenCaseUserCode() + "'," + 
                           " OpenCaseDate = '" + prpLrecasetgDto.getOpenCaseDate() + "'," + 
                           " CloseCaseUserCode = '" + prpLrecasetgDto.getCloseCaseUserCode() + "'," + 
                           " CloseCaseDate = '" + prpLrecasetgDto.getCloseCaseDate() + "'," + 
                           " Flag = '" + prpLrecasetgDto.getFlag() + "'," + 
                           " RecaseMoney = '" + prpLrecasetgDto.getRecaseMoney() + "'," + 
                           " ReCaseUploadFlag = '" + prpLrecasetgDto.getReCaseUploadFlag() + "'," + 
                           " ReCaseReason = '" + prpLrecasetgDto.getReCaseReason() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLrecasetgDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLrecasetgDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLrecasetgDto.getOpenCaseUserCode());
        dbManager.setDateTime(2,prpLrecasetgDto.getOpenCaseDate());
        dbManager.setString(3,prpLrecasetgDto.getCloseCaseUserCode());
        dbManager.setDateTime(4,prpLrecasetgDto.getCloseCaseDate());
        dbManager.setString(5,prpLrecasetgDto.getFlag());
        dbManager.setDouble(6,prpLrecasetgDto.getRecaseMoney());
        dbManager.setString(7,prpLrecasetgDto.getReCaseUploadFlag());
        dbManager.setString(8,prpLrecasetgDto.getReCaseReason());
        //设置条件字段;
        dbManager.setString(9,prpLrecasetgDto.getClaimNo());
        dbManager.setInt(10,prpLrecasetgDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLrecasetgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param claimNo 赔案号
     * @param serialNo 重开赔案次数
     * @return PrpLrecasetgDto
     * @throws Exception
     */
    public PrpLrecasetgDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " SerialNo," + 
                           " OpenCaseUserCode," + 
                           " OpenCaseDate," + 
                           " CloseCaseUserCode," + 
                           " CloseCaseDate," + 

                           " Flag," + 
                           " recaseMoney," +
                           " reCaseUploadFlag," +
                           " ReCaseReason From PrpLrecasetg";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLrecasetgDto prpLrecasetgDto = null;
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
            prpLrecasetgDto = new PrpLrecasetgDto();
            prpLrecasetgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrecasetgDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLrecasetgDto.setOpenCaseUserCode(dbManager.getString(resultSet,3));
            prpLrecasetgDto.setOpenCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLrecasetgDto.setCloseCaseUserCode(dbManager.getString(resultSet,5));
            prpLrecasetgDto.setCloseCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            prpLrecasetgDto.setFlag(dbManager.getString(resultSet,7));
            prpLrecasetgDto.setRecaseMoney(dbManager.getDouble(resultSet,8));
            prpLrecasetgDto.setReCaseUploadFlag(dbManager.getString(resultSet,9));
            prpLrecasetgDto.setReCaseReason(dbManager.getString(resultSet,10));
            logger.info("DBPrpLrecasetgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLrecasetgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLrecasetgDto;
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
                           " ReCaseReason From PrpLrecasetg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLrecasetgDto prpLrecasetgDto = null;
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

            prpLrecasetgDto = new PrpLrecasetgDto();
            prpLrecasetgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLrecasetgDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLrecasetgDto.setOpenCaseUserCode(dbManager.getString(resultSet,3));
            prpLrecasetgDto.setOpenCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLrecasetgDto.setCloseCaseUserCode(dbManager.getString(resultSet,5));
            prpLrecasetgDto.setCloseCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
            prpLrecasetgDto.setFlag(dbManager.getString(resultSet,7));
            prpLrecasetgDto.setRecaseMoney(dbManager.getDouble(resultSet,8));
            prpLrecasetgDto.setReCaseUploadFlag(dbManager.getString(resultSet,9));
            prpLrecasetgDto.setReCaseReason(dbManager.getString(resultSet,10));
            collection.add(prpLrecasetgDto);
        }
        resultSet.close();
        logger.info("DBPrpLrecasetgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLrecasetg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLrecasetgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLrecasetg Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLrecasetgBase.getCount() success!");
        return count;
    }
}
