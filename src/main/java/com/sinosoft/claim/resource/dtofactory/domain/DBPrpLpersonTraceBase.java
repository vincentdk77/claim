package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonTrace-人伤跟踪表(新增)的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLpersonTraceBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLpersonTraceBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpersonTraceBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void insert(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        String mainStatement = " Insert Into PrpLpersonTrace (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " IdentifyNumber," + 
                           " RelatePersonNo," + 
                           " JobCode," + 
                           " JobName," + 
                           " ReferKind," + 
                           " PartDesc," + 
                           " Hospital," + 
                           " MotionFlag," + 
                           " WoundRemark," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLpersonTraceDto.getRegistNo() + "'," + 
                           "'" + prpLpersonTraceDto.getClaimNo() + "'," + 
                           "'" + prpLpersonTraceDto.getPolicyNo() + "'," + 
                           "" + prpLpersonTraceDto.getPersonNo() + "," + 
                           "'" + prpLpersonTraceDto.getPersonName() + "'," + 
                           "'" + prpLpersonTraceDto.getPersonSex() + "'," + 
                           "" + prpLpersonTraceDto.getPersonAge() + "," + 
                           "'" + prpLpersonTraceDto.getIdentifyNumber() + "'," + 
                           "" + prpLpersonTraceDto.getRelatePersonNo() + "," + 
                           "'" + prpLpersonTraceDto.getJobCode() + "'," + 
                           "'" + prpLpersonTraceDto.getJobName() + "'," + 
                           "'" + prpLpersonTraceDto.getReferKind() + "'," + 
                           "'" + prpLpersonTraceDto.getPartDesc() + "'," + 
                           "'" + prpLpersonTraceDto.getHospital() + "'," + 
                           "'" + prpLpersonTraceDto.getMotionFlag() + "'," + 
                           "'" + prpLpersonTraceDto.getWoundRemark() + "'," + 
                           "'" + prpLpersonTraceDto.getRemark() + "'," + 
                           "'" + prpLpersonTraceDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpersonTraceDto.getRegistNo());
        dbManager.setString(2,prpLpersonTraceDto.getClaimNo());
        dbManager.setString(3,prpLpersonTraceDto.getPolicyNo());
        dbManager.setInt(4,prpLpersonTraceDto.getPersonNo());
        dbManager.setString(5,prpLpersonTraceDto.getPersonName());
        dbManager.setString(6,prpLpersonTraceDto.getPersonSex());
        dbManager.setInt(7,prpLpersonTraceDto.getPersonAge());
        dbManager.setString(8,prpLpersonTraceDto.getIdentifyNumber());
        dbManager.setInt(9,prpLpersonTraceDto.getRelatePersonNo());
        dbManager.setString(10,prpLpersonTraceDto.getJobCode());
        dbManager.setString(11,prpLpersonTraceDto.getJobName());
        dbManager.setString(12,prpLpersonTraceDto.getReferKind());
        dbManager.setString(13,prpLpersonTraceDto.getPartDesc());
        dbManager.setString(14,prpLpersonTraceDto.getHospital());
        dbManager.setString(15,prpLpersonTraceDto.getMotionFlag());
        dbManager.setString(16,prpLpersonTraceDto.getWoundRemark());
        dbManager.setString(17,prpLpersonTraceDto.getRemark());
        dbManager.setString(18,prpLpersonTraceDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonTraceBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLpersonTrace (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " IdentifyNumber," + 
                           " RelatePersonNo," + 
                           " JobCode," + 
                           " JobName," + 
                           " ReferKind," + 
                           " PartDesc," + 
                           " Hospital," + 
                           " MotionFlag," + 
                           " WoundRemark," + 
                           " Remark," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpersonTraceDto prpLpersonTraceDto = (PrpLpersonTraceDto)i.next();
            dbManager.setString(1,prpLpersonTraceDto.getRegistNo());
            dbManager.setString(2,prpLpersonTraceDto.getClaimNo());
            dbManager.setString(3,prpLpersonTraceDto.getPolicyNo());
            dbManager.setInt(4,prpLpersonTraceDto.getPersonNo());
            dbManager.setString(5,prpLpersonTraceDto.getPersonName());
            dbManager.setString(6,prpLpersonTraceDto.getPersonSex());
            dbManager.setInt(7,prpLpersonTraceDto.getPersonAge());
            dbManager.setString(8,prpLpersonTraceDto.getIdentifyNumber());
            dbManager.setInt(9,prpLpersonTraceDto.getRelatePersonNo());
            dbManager.setString(10,prpLpersonTraceDto.getJobCode());
            dbManager.setString(11,prpLpersonTraceDto.getJobName());
            dbManager.setString(12,prpLpersonTraceDto.getReferKind());
            dbManager.setString(13,prpLpersonTraceDto.getPartDesc());
            dbManager.setString(14,prpLpersonTraceDto.getHospital());
            dbManager.setString(15,prpLpersonTraceDto.getMotionFlag());
            dbManager.setString(16,prpLpersonTraceDto.getWoundRemark());
            dbManager.setString(17,prpLpersonTraceDto.getRemark());
            dbManager.setString(18,prpLpersonTraceDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLpersonTraceBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param personNo 人员序号
     * @throws Exception
     */
    public void delete(String registNo,int personNo) throws Exception{
        String statement = " Delete From PrpLpersonTrace" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PersonNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLpersonTrace Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PersonNo = " + personNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,personNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpersonTraceBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void update(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        String statement = " Update PrpLpersonTrace Set ClaimNo = ?," + 
                           " PolicyNo = ?," + 
                           " PersonName = ?," + 
                           " PersonSex = ?," + 
                           " PersonAge = ?," + 
                           " IdentifyNumber = ?," + 
                           " RelatePersonNo = ?," + 
                           " JobCode = ?," + 
                           " JobName = ?," + 
                           " ReferKind = ?," + 
                           " PartDesc = ?," + 
                           " Hospital = ?," + 
                           " MotionFlag = ?," + 
                           " WoundRemark = ?," + 
                           " Remark = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PersonNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLpersonTrace Set " + 
                           " RegistNo = '" + prpLpersonTraceDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLpersonTraceDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLpersonTraceDto.getPolicyNo() + "'," + 
                           " PersonNo = " + prpLpersonTraceDto.getPersonNo() + "," + 
                           " PersonName = '" + prpLpersonTraceDto.getPersonName() + "'," + 
                           " PersonSex = '" + prpLpersonTraceDto.getPersonSex() + "'," + 
                           " PersonAge = " + prpLpersonTraceDto.getPersonAge() + "," + 
                           " IdentifyNumber = '" + prpLpersonTraceDto.getIdentifyNumber() + "'," + 
                           " RelatePersonNo = " + prpLpersonTraceDto.getRelatePersonNo() + "," + 
                           " JobCode = '" + prpLpersonTraceDto.getJobCode() + "'," + 
                           " JobName = '" + prpLpersonTraceDto.getJobName() + "'," + 
                           " ReferKind = '" + prpLpersonTraceDto.getReferKind() + "'," + 
                           " PartDesc = '" + prpLpersonTraceDto.getPartDesc() + "'," + 
                           " Hospital = '" + prpLpersonTraceDto.getHospital() + "'," + 
                           " MotionFlag = '" + prpLpersonTraceDto.getMotionFlag() + "'," + 
                           " WoundRemark = '" + prpLpersonTraceDto.getWoundRemark() + "'," + 
                           " Remark = '" + prpLpersonTraceDto.getRemark() + "'," + 
                           " Flag = '" + prpLpersonTraceDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLpersonTraceDto.getRegistNo() + "' And " + 
                           " PersonNo = " + prpLpersonTraceDto.getPersonNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLpersonTraceDto.getClaimNo());
        dbManager.setString(2,prpLpersonTraceDto.getPolicyNo());
        dbManager.setString(3,prpLpersonTraceDto.getPersonName());
        dbManager.setString(4,prpLpersonTraceDto.getPersonSex());
        dbManager.setInt(5,prpLpersonTraceDto.getPersonAge());
        dbManager.setString(6,prpLpersonTraceDto.getIdentifyNumber());
        dbManager.setInt(7,prpLpersonTraceDto.getRelatePersonNo());
        dbManager.setString(8,prpLpersonTraceDto.getJobCode());
        dbManager.setString(9,prpLpersonTraceDto.getJobName());
        dbManager.setString(10,prpLpersonTraceDto.getReferKind());
        dbManager.setString(11,prpLpersonTraceDto.getPartDesc());
        dbManager.setString(12,prpLpersonTraceDto.getHospital());
        dbManager.setString(13,prpLpersonTraceDto.getMotionFlag());
        dbManager.setString(14,prpLpersonTraceDto.getWoundRemark());
        dbManager.setString(15,prpLpersonTraceDto.getRemark());
        dbManager.setString(16,prpLpersonTraceDto.getFlag());
        //设置条件字段;
        dbManager.setString(17,prpLpersonTraceDto.getRegistNo());
        dbManager.setInt(18,prpLpersonTraceDto.getPersonNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonTraceBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param personNo 人员序号
     * @return PrpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceDto findByPrimaryKey(String registNo,int personNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " IdentifyNumber," + 
                           " RelatePersonNo," + 
                           " JobCode," + 
                           " JobName," + 
                           " ReferKind," + 
                           " PartDesc," + 
                           " Hospital," + 
                           " MotionFlag," + 
                           " WoundRemark," + 
                           " Remark," + 
                           " Flag From PrpLpersonTrace";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " PersonNo = ?";
        PrpLpersonTraceDto prpLpersonTraceDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PersonNo = " + personNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,personNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpersonTraceDto = new PrpLpersonTraceDto();
            prpLpersonTraceDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpersonTraceDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLpersonTraceDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonTraceDto.setPersonNo(dbManager.getInt(resultSet,4));
            prpLpersonTraceDto.setPersonName(dbManager.getString(resultSet,5));
            prpLpersonTraceDto.setPersonSex(dbManager.getString(resultSet,6));
            prpLpersonTraceDto.setPersonAge(dbManager.getInt(resultSet,7));
            prpLpersonTraceDto.setIdentifyNumber(dbManager.getString(resultSet,8));
            prpLpersonTraceDto.setRelatePersonNo(dbManager.getInt(resultSet,9));
            prpLpersonTraceDto.setJobCode(dbManager.getString(resultSet,10));
            prpLpersonTraceDto.setJobName(dbManager.getString(resultSet,11));
            prpLpersonTraceDto.setReferKind(dbManager.getString(resultSet,12));
            prpLpersonTraceDto.setPartDesc(dbManager.getString(resultSet,13));
            prpLpersonTraceDto.setHospital(dbManager.getString(resultSet,14));
            prpLpersonTraceDto.setMotionFlag(dbManager.getString(resultSet,15));
            prpLpersonTraceDto.setWoundRemark(dbManager.getString(resultSet,16));
            prpLpersonTraceDto.setRemark(dbManager.getString(resultSet,17));
            prpLpersonTraceDto.setFlag(dbManager.getString(resultSet,18));
            logger.info("DBPrpLpersonTraceBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLpersonTraceBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLpersonTraceDto;
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
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " PersonSex," + 
                           " PersonAge," + 
                           " IdentifyNumber," + 
                           " RelatePersonNo," + 
                           " JobCode," + 
                           " JobName," + 
                           " ReferKind," + 
                           " PartDesc," + 
                           " Hospital," + 
                           " MotionFlag," + 
                           " WoundRemark," + 
                           " Remark," + 
                           " Flag From PrpLpersonTrace Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpersonTraceDto prpLpersonTraceDto = null;
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

            prpLpersonTraceDto = new PrpLpersonTraceDto();
            prpLpersonTraceDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpersonTraceDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLpersonTraceDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonTraceDto.setPersonNo(dbManager.getInt(resultSet,4));
            prpLpersonTraceDto.setPersonName(dbManager.getString(resultSet,5));
            prpLpersonTraceDto.setPersonSex(dbManager.getString(resultSet,6));
            prpLpersonTraceDto.setPersonAge(dbManager.getInt(resultSet,7));
            prpLpersonTraceDto.setIdentifyNumber(dbManager.getString(resultSet,8));
            prpLpersonTraceDto.setRelatePersonNo(dbManager.getInt(resultSet,9));
            prpLpersonTraceDto.setJobCode(dbManager.getString(resultSet,10));
            prpLpersonTraceDto.setJobName(dbManager.getString(resultSet,11));
            prpLpersonTraceDto.setReferKind(dbManager.getString(resultSet,12));
            prpLpersonTraceDto.setPartDesc(dbManager.getString(resultSet,13));
            prpLpersonTraceDto.setHospital(dbManager.getString(resultSet,14));
            prpLpersonTraceDto.setMotionFlag(dbManager.getString(resultSet,15));
            prpLpersonTraceDto.setWoundRemark(dbManager.getString(resultSet,16));
            prpLpersonTraceDto.setRemark(dbManager.getString(resultSet,17));
            prpLpersonTraceDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(prpLpersonTraceDto);
        }
        resultSet.close();
        logger.info("DBPrpLpersonTraceBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpersonTrace Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpersonTraceBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLpersonTrace Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpersonTraceBase.getCount() success!");
        return count;
    }
}
