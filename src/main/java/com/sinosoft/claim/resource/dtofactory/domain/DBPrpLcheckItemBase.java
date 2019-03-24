package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckItem-查勘任务标的表（新增）的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckItemBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcheckItemBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcheckItemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void insert(PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        String mainStatement = " Insert Into PrpLcheckItem (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectSend," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " CheckSite," + 
                           " LicenseNo," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " CheckOperatorCode," + 
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLcheckItemDto.getScheduleID() + "," + 
                           "'" + prpLcheckItemDto.getRegistNo() + "'," + 
                           "" + prpLcheckItemDto.getItemNo() + "," + 
                           "'" + prpLcheckItemDto.getInsureCarFlag() + "'," + 
                           "'" + prpLcheckItemDto.getClaimComCode() + "'," + 
                           "'" + prpLcheckItemDto.getSelectSend() + "'," + 
                           "" + prpLcheckItemDto.getSurveyTimes() + "," + 
                           "'" + prpLcheckItemDto.getSurveyType() + "'," + 
                           "'" + prpLcheckItemDto.getCheckSite() + "'," + 
                           "'" + prpLcheckItemDto.getLicenseNo() + "'," + 
                           "'" + prpLcheckItemDto.getScheduleObjectID() + "'," + 
                           "'" + prpLcheckItemDto.getScheduleObjectName() + "'," + 
                           "'" + prpLcheckItemDto.getInputDate() + "'," + 
                           "'" + prpLcheckItemDto.getOperatorCode() + "'," + 
                           "'" + prpLcheckItemDto.getCheckOperatorCode() + "'," + 
                           "'" + prpLcheckItemDto.getResultInfo() + "'," + 
                           "'" + prpLcheckItemDto.getBookFlag() + "'," + 
                           "'" + prpLcheckItemDto.getScheduleType() + "'," + 
                           "'" + prpLcheckItemDto.getCheckFlag() + "'," + 
                           "'" + prpLcheckItemDto.getCheckInfo() + "'," + 
                           "'" + prpLcheckItemDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLcheckItemDto.getScheduleID());
        dbManager.setString(2,prpLcheckItemDto.getRegistNo());
        dbManager.setInt(3,prpLcheckItemDto.getItemNo());
        dbManager.setString(4,prpLcheckItemDto.getInsureCarFlag());
        dbManager.setString(5,prpLcheckItemDto.getClaimComCode());
        dbManager.setString(6,prpLcheckItemDto.getSelectSend());
        dbManager.setInt(7,prpLcheckItemDto.getSurveyTimes());
        dbManager.setString(8,prpLcheckItemDto.getSurveyType());
        dbManager.setString(9,prpLcheckItemDto.getCheckSite());
        dbManager.setString(10,prpLcheckItemDto.getLicenseNo());
        dbManager.setString(11,prpLcheckItemDto.getScheduleObjectID());
        dbManager.setString(12,prpLcheckItemDto.getScheduleObjectName());
        dbManager.setDateTime(13,prpLcheckItemDto.getInputDate());
        dbManager.setString(14,prpLcheckItemDto.getOperatorCode());
        dbManager.setString(15,prpLcheckItemDto.getCheckOperatorCode());
        dbManager.setString(16,prpLcheckItemDto.getResultInfo());
        dbManager.setString(17,prpLcheckItemDto.getBookFlag());
        dbManager.setString(18,prpLcheckItemDto.getScheduleType());
        dbManager.setString(19,prpLcheckItemDto.getCheckFlag());
        dbManager.setString(20,prpLcheckItemDto.getCheckInfo());
        dbManager.setString(21,prpLcheckItemDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckItemBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcheckItem (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectSend," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " CheckSite," + 
                           " LicenseNo," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " CheckOperatorCode," + 
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcheckItemDto prpLcheckItemDto = (PrpLcheckItemDto)i.next();
            dbManager.setInt(1,prpLcheckItemDto.getScheduleID());
            dbManager.setString(2,prpLcheckItemDto.getRegistNo());
            dbManager.setInt(3,prpLcheckItemDto.getItemNo());
            dbManager.setString(4,prpLcheckItemDto.getInsureCarFlag());
            dbManager.setString(5,prpLcheckItemDto.getClaimComCode());
            dbManager.setString(6,prpLcheckItemDto.getSelectSend());
            dbManager.setInt(7,prpLcheckItemDto.getSurveyTimes());
            dbManager.setString(8,prpLcheckItemDto.getSurveyType());
            dbManager.setString(9,prpLcheckItemDto.getCheckSite());
            dbManager.setString(10,prpLcheckItemDto.getLicenseNo());
            dbManager.setString(11,prpLcheckItemDto.getScheduleObjectID());
            dbManager.setString(12,prpLcheckItemDto.getScheduleObjectName());
            dbManager.setDateTime(13,prpLcheckItemDto.getInputDate());
            dbManager.setString(14,prpLcheckItemDto.getOperatorCode());
            dbManager.setString(15,prpLcheckItemDto.getCheckOperatorCode());
            dbManager.setString(16,prpLcheckItemDto.getResultInfo());
            dbManager.setString(17,prpLcheckItemDto.getBookFlag());
            dbManager.setString(18,prpLcheckItemDto.getScheduleType());
            dbManager.setString(19,prpLcheckItemDto.getCheckFlag());
            dbManager.setString(20,prpLcheckItemDto.getCheckInfo());
            dbManager.setString(21,prpLcheckItemDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcheckItemBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int itemNo) throws Exception{
        String statement = " Delete From PrpLcheckItem" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcheckItem Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,itemNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcheckItemBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcheckItemDto prpLcheckItemDto
     * @throws Exception
     */
    public void update(PrpLcheckItemDto prpLcheckItemDto) throws Exception{
        String statement = " Update PrpLcheckItem Set InsureCarFlag = ?," + 
                           " ClaimComCode = ?," + 
                           " SelectSend = ?," + 
                           " SurveyTimes = ?," + 
                           " SurveyType = ?," + 
                           " CheckSite = ?," + 
                           " LicenseNo = ?," + 
                           " ScheduleObjectID = ?," + 
                           " ScheduleObjectName = ?," + 
                           " InputDate = ?," + 
                           " OperatorCode = ?," + 
                           " CheckOperatorCode = ?," + 
                           " ResultInfo = ?," + 
                           " BookFlag = ?," + 
                           " ScheduleType = ?," + 
                           " CheckFlag = ?," + 
                           " CheckInfo = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcheckItem Set " + 
                           " ScheduleID = " + prpLcheckItemDto.getScheduleID() + "," + 
                           " RegistNo = '" + prpLcheckItemDto.getRegistNo() + "'," + 
                           " ItemNo = " + prpLcheckItemDto.getItemNo() + "," + 
                           " InsureCarFlag = '" + prpLcheckItemDto.getInsureCarFlag() + "'," + 
                           " ClaimComCode = '" + prpLcheckItemDto.getClaimComCode() + "'," + 
                           " SelectSend = '" + prpLcheckItemDto.getSelectSend() + "'," + 
                           " SurveyTimes = " + prpLcheckItemDto.getSurveyTimes() + "," + 
                           " SurveyType = '" + prpLcheckItemDto.getSurveyType() + "'," + 
                           " CheckSite = '" + prpLcheckItemDto.getCheckSite() + "'," + 
                           " LicenseNo = '" + prpLcheckItemDto.getLicenseNo() + "'," + 
                           " ScheduleObjectID = '" + prpLcheckItemDto.getScheduleObjectID() + "'," + 
                           " ScheduleObjectName = '" + prpLcheckItemDto.getScheduleObjectName() + "'," + 
                           " InputDate = '" + prpLcheckItemDto.getInputDate() + "'," + 
                           " OperatorCode = '" + prpLcheckItemDto.getOperatorCode() + "'," + 
                           " CheckOperatorCode = '" + prpLcheckItemDto.getCheckOperatorCode() + "'," + 
                           " ResultInfo = '" + prpLcheckItemDto.getResultInfo() + "'," + 
                           " BookFlag = '" + prpLcheckItemDto.getBookFlag() + "'," + 
                           " ScheduleType = '" + prpLcheckItemDto.getScheduleType() + "'," + 
                           " CheckFlag = '" + prpLcheckItemDto.getCheckFlag() + "'," + 
                           " CheckInfo = '" + prpLcheckItemDto.getCheckInfo() + "'," + 
                           " Flag = '" + prpLcheckItemDto.getFlag() + "'" + 
			               " Where " +
                           " ScheduleID = " + prpLcheckItemDto.getScheduleID() + " And " + 
                           " RegistNo = '" + prpLcheckItemDto.getRegistNo() + "' And " + 
                           " ItemNo = " + prpLcheckItemDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcheckItemDto.getInsureCarFlag());
        dbManager.setString(2,prpLcheckItemDto.getClaimComCode());
        dbManager.setString(3,prpLcheckItemDto.getSelectSend());
        dbManager.setInt(4,prpLcheckItemDto.getSurveyTimes());
        dbManager.setString(5,prpLcheckItemDto.getSurveyType());
        dbManager.setString(6,prpLcheckItemDto.getCheckSite());
        dbManager.setString(7,prpLcheckItemDto.getLicenseNo());
        dbManager.setString(8,prpLcheckItemDto.getScheduleObjectID());
        dbManager.setString(9,prpLcheckItemDto.getScheduleObjectName());
        dbManager.setDateTime(10,prpLcheckItemDto.getInputDate());
        dbManager.setString(11,prpLcheckItemDto.getOperatorCode());
        dbManager.setString(12,prpLcheckItemDto.getCheckOperatorCode());
        dbManager.setString(13,prpLcheckItemDto.getResultInfo());
        dbManager.setString(14,prpLcheckItemDto.getBookFlag());
        dbManager.setString(15,prpLcheckItemDto.getScheduleType());
        dbManager.setString(16,prpLcheckItemDto.getCheckFlag());
        dbManager.setString(17,prpLcheckItemDto.getCheckInfo());
        dbManager.setString(18,prpLcheckItemDto.getFlag());
        //设置条件字段;
        dbManager.setInt(19,prpLcheckItemDto.getScheduleID());
        dbManager.setString(20,prpLcheckItemDto.getRegistNo());
        dbManager.setInt(21,prpLcheckItemDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckItemBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo 标的序号
     * @return PrpLcheckItemDto
     * @throws Exception
     */
    public PrpLcheckItemDto findByPrimaryKey(int scheduleID,String registNo,int itemNo) throws Exception{
        String mainStatement = " Select ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectSend," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " CheckSite," + 
                           " LicenseNo," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " CheckOperatorCode," + 
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag From PrpLcheckItem";
        String statement = mainStatement + " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        PrpLcheckItemDto prpLcheckItemDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setInt(3,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcheckItemDto = new PrpLcheckItemDto();
            prpLcheckItemDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLcheckItemDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLcheckItemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpLcheckItemDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLcheckItemDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLcheckItemDto.setSelectSend(dbManager.getString(resultSet,6));
            prpLcheckItemDto.setSurveyTimes(dbManager.getInt(resultSet,7));
            prpLcheckItemDto.setSurveyType(dbManager.getString(resultSet,8));
            prpLcheckItemDto.setCheckSite(dbManager.getString(resultSet,9));
            prpLcheckItemDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLcheckItemDto.setScheduleObjectID(dbManager.getString(resultSet,11));
            prpLcheckItemDto.setScheduleObjectName(dbManager.getString(resultSet,12));
            prpLcheckItemDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLcheckItemDto.setOperatorCode(dbManager.getString(resultSet,14));
            prpLcheckItemDto.setCheckOperatorCode(dbManager.getString(resultSet,15));
            prpLcheckItemDto.setResultInfo(dbManager.getString(resultSet,16));
            prpLcheckItemDto.setBookFlag(dbManager.getString(resultSet,17));
            prpLcheckItemDto.setScheduleType(dbManager.getString(resultSet,18));
            prpLcheckItemDto.setCheckFlag(dbManager.getString(resultSet,19));
            prpLcheckItemDto.setCheckInfo(dbManager.getString(resultSet,20));
            prpLcheckItemDto.setFlag(dbManager.getString(resultSet,21));
            logger.info("DBPrpLcheckItemBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcheckItemBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcheckItemDto;
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
        String statement = "Select ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " InsureCarFlag," + 
                           " ClaimComCode," + 
                           " SelectSend," + 
                           " SurveyTimes," + 
                           " SurveyType," + 
                           " CheckSite," + 
                           " LicenseNo," + 
                           " ScheduleObjectID," + 
                           " ScheduleObjectName," + 
                           " InputDate," + 
                           " OperatorCode," + 
                           " CheckOperatorCode," + 
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " Flag From PrpLcheckItem Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcheckItemDto prpLcheckItemDto = null;
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

            prpLcheckItemDto = new PrpLcheckItemDto();
            prpLcheckItemDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLcheckItemDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLcheckItemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpLcheckItemDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLcheckItemDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLcheckItemDto.setSelectSend(dbManager.getString(resultSet,6));
            prpLcheckItemDto.setSurveyTimes(dbManager.getInt(resultSet,7));
            prpLcheckItemDto.setSurveyType(dbManager.getString(resultSet,8));
            prpLcheckItemDto.setCheckSite(dbManager.getString(resultSet,9));
            prpLcheckItemDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLcheckItemDto.setScheduleObjectID(dbManager.getString(resultSet,11));
            prpLcheckItemDto.setScheduleObjectName(dbManager.getString(resultSet,12));
            prpLcheckItemDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLcheckItemDto.setOperatorCode(dbManager.getString(resultSet,14));
            prpLcheckItemDto.setCheckOperatorCode(dbManager.getString(resultSet,15));
            prpLcheckItemDto.setResultInfo(dbManager.getString(resultSet,16));
            prpLcheckItemDto.setBookFlag(dbManager.getString(resultSet,17));
            prpLcheckItemDto.setScheduleType(dbManager.getString(resultSet,18));
            prpLcheckItemDto.setCheckFlag(dbManager.getString(resultSet,19));
            prpLcheckItemDto.setCheckInfo(dbManager.getString(resultSet,20));
            prpLcheckItemDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpLcheckItemDto);
        }
        resultSet.close();
        logger.info("DBPrpLcheckItemBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcheckItem Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcheckItemBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcheckItem Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcheckItemBase.getCount() success!");
        return count;
    }
}
