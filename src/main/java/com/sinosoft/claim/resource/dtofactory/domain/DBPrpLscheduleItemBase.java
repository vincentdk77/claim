package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleItem-调度任务标的表(新增）的数据访问对象基类<br>
 * 创建于 2005-06-30 16:57:28.543<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLscheduleItemBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLscheduleItemBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLscheduleItemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void insert(PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        String mainStatement = " Insert Into PrpLscheduleItem (" + 
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
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " Flag," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " OperatorCode," + 
                           " FactoryPhone," + 
                           " FactoryEstimateLoss," + 
                           " commendRepairFactoryCode," + 
                           " commendRepairFactoryName," + 
                           " ExigenceGree," + 
                           " ScheduleStatus," + 
                           " CommiItemFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLscheduleItemDto.getScheduleID() + "," + 
                           "'" + prpLscheduleItemDto.getRegistNo() + "'," + 
                           "" + prpLscheduleItemDto.getItemNo() + "," + 
                           "'" + prpLscheduleItemDto.getInsureCarFlag() + "'," + 
                           "'" + prpLscheduleItemDto.getClaimComCode() + "'," + 
                           "'" + prpLscheduleItemDto.getSelectSend() + "'," + 
                           "" + prpLscheduleItemDto.getSurveyTimes() + "," + 
                           "'" + prpLscheduleItemDto.getSurveyType() + "'," + 
                           "'" + prpLscheduleItemDto.getCheckSite() + "'," + 
                           "'" + prpLscheduleItemDto.getLicenseNo() + "'," + 
                           "'" + prpLscheduleItemDto.getScheduleObjectID() + "'," + 
                           "'" + prpLscheduleItemDto.getScheduleObjectName() + "'," + 
                           "'" + prpLscheduleItemDto.getInputDate() + "'," + 
                           "'" + prpLscheduleItemDto.getResultInfo() + "'," + 
                           "'" + prpLscheduleItemDto.getBookFlag() + "'," + 
                           "'" + prpLscheduleItemDto.getScheduleType() + "'," + 
                           "'" + prpLscheduleItemDto.getFlag() + "'," + 
                           "'" + prpLscheduleItemDto.getNextHandlerCode() + "'," + 
                           "'" + prpLscheduleItemDto.getNextHandlerName() + "'," + 
                           "'" + prpLscheduleItemDto.getNextNodeNo() + "'," + 
                           "'" + prpLscheduleItemDto.getOperatorCode() + "'," + 
                           "'" + prpLscheduleItemDto.getFactoryPhone() + "'," + 
                           "'" + prpLscheduleItemDto.getFactoryEstimateLoss() + "'," + 
                           "'" + prpLscheduleItemDto.getCommendRepairFactoryCode() + "'," + 
                           "'" + prpLscheduleItemDto.getCommendRepairFactoryName() + "'," + 
                           "'" + prpLscheduleItemDto.getExigenceGree() + "'," + 
                           "'" + prpLscheduleItemDto.getScheduleStatus() + "'," + 
                           "'" + prpLscheduleItemDto.getCommiItemFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLscheduleItemDto.getScheduleID());
        dbManager.setString(2,prpLscheduleItemDto.getRegistNo());
        dbManager.setInt(3,prpLscheduleItemDto.getItemNo());
        dbManager.setString(4,prpLscheduleItemDto.getInsureCarFlag());
        dbManager.setString(5,prpLscheduleItemDto.getClaimComCode());
        dbManager.setString(6,prpLscheduleItemDto.getSelectSend());
        dbManager.setInt(7,prpLscheduleItemDto.getSurveyTimes());
        dbManager.setString(8,prpLscheduleItemDto.getSurveyType());
        dbManager.setString(9,prpLscheduleItemDto.getCheckSite());
        dbManager.setString(10,prpLscheduleItemDto.getLicenseNo());
        dbManager.setString(11,prpLscheduleItemDto.getScheduleObjectID());
        dbManager.setString(12,prpLscheduleItemDto.getScheduleObjectName());
        dbManager.setDateTime(13,prpLscheduleItemDto.getInputDate());
        dbManager.setString(14,prpLscheduleItemDto.getResultInfo());
        dbManager.setString(15,prpLscheduleItemDto.getBookFlag());
        dbManager.setString(16,prpLscheduleItemDto.getScheduleType());
        dbManager.setString(17,prpLscheduleItemDto.getFlag());
        dbManager.setString(18,prpLscheduleItemDto.getNextHandlerCode());
        dbManager.setString(19,prpLscheduleItemDto.getNextHandlerName());
        dbManager.setString(20,prpLscheduleItemDto.getNextNodeNo());
        dbManager.setString(21,prpLscheduleItemDto.getOperatorCode());
        dbManager.setString(22,prpLscheduleItemDto.getFactoryPhone());
        dbManager.setDouble(23,prpLscheduleItemDto.getFactoryEstimateLoss());
        dbManager.setString(24,prpLscheduleItemDto.getCommendRepairFactoryCode());
        dbManager.setString(25,prpLscheduleItemDto.getCommendRepairFactoryName());
        dbManager.setString(26,prpLscheduleItemDto.getExigenceGree());
        dbManager.setString(27,prpLscheduleItemDto.getScheduleStatus());
        dbManager.setString(28,prpLscheduleItemDto.getCommiItemFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleItemBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto)i.next();
            //add by liyanjie 2005-12-12 start 删除时只删除本条要插的记录
            if(prpLscheduleItemDto.getCommiItemFlag()!=null && "1".equals(prpLscheduleItemDto.getCommiItemFlag())){  //双代,需判断此项目是否已被撤回承保公司
            	PrpLscheduleItemDto prpLscheduleItemDto1 = findByPrimaryKey(prpLscheduleItemDto.getScheduleID(),prpLscheduleItemDto.getRegistNo(),prpLscheduleItemDto.getItemNo());
            	if((prpLscheduleItemDto1 ==null) || prpLscheduleItemDto1 !=null && prpLscheduleItemDto.getClaimComCode().equals(prpLscheduleItemDto1.getClaimComCode() )){ //公司代码一致,说明没被撤消,可以操作
            		delete(prpLscheduleItemDto.getScheduleID(),prpLscheduleItemDto.getRegistNo(),prpLscheduleItemDto.getItemNo());
                    insert(prpLscheduleItemDto);
            	}else{
            		//已被撤消了,提示?
            	}
            }else{      //不是双代,直接操作
	            delete(prpLscheduleItemDto.getScheduleID(),prpLscheduleItemDto.getRegistNo(),prpLscheduleItemDto.getItemNo());
	            //add by liyanjie 2005-12-12 end
	            insert(prpLscheduleItemDto);
            }
        }
    }

    /**
     * 按主键删除一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo ITEMNO
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int itemNo) throws Exception{
        String statement = " Delete From PrpLscheduleItem" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLscheduleItem Where " +
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
        logger.info("DBPrpLscheduleItemBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLscheduleItemDto prpLscheduleItemDto
     * @throws Exception
     */
    public void update(PrpLscheduleItemDto prpLscheduleItemDto) throws Exception{
        String statement = " Update PrpLscheduleItem Set InsureCarFlag = ?," + 
                           " ClaimComCode = ?," + 
                           " SelectSend = ?," + 
                           " SurveyTimes = ?," + 
                           " SurveyType = ?," + 
                           " CheckSite = ?," + 
                           " LicenseNo = ?," + 
                           " ScheduleObjectID = ?," + 
                           " ScheduleObjectName = ?," + 
                           " InputDate = ?," + 
                           " ResultInfo = ?," + 
                           " BookFlag = ?," + 
                           " ScheduleType = ?," + 
                           " Flag = ?," + 
                           " NextHandlerCode = ?," + 
                           " NextHandlerName = ?," + 
                           " NextNodeNo = ?," + 
                           " OperatorCode = ?," + 
                           " FactoryPhone = ?," + 
                           " FactoryEstimateLoss = ?," + 
                           " commendRepairFactoryCode = ?," + 
                           " commendRepairFactoryName = ?," + 
                           " ExigenceGree = ?," + 
                           " ScheduleStatus = ?" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLscheduleItem Set " + 
                           " ScheduleID = " + prpLscheduleItemDto.getScheduleID() + "," + 
                           " RegistNo = '" + prpLscheduleItemDto.getRegistNo() + "'," + 
                           " ItemNo = " + prpLscheduleItemDto.getItemNo() + "," + 
                           " InsureCarFlag = '" + prpLscheduleItemDto.getInsureCarFlag() + "'," + 
                           " ClaimComCode = '" + prpLscheduleItemDto.getClaimComCode() + "'," + 
                           " SelectSend = '" + prpLscheduleItemDto.getSelectSend() + "'," + 
                           " SurveyTimes = " + prpLscheduleItemDto.getSurveyTimes() + "," + 
                           " SurveyType = '" + prpLscheduleItemDto.getSurveyType() + "'," + 
                           " CheckSite = '" + prpLscheduleItemDto.getCheckSite() + "'," + 
                           " LicenseNo = '" + prpLscheduleItemDto.getLicenseNo() + "'," + 
                           " ScheduleObjectID = '" + prpLscheduleItemDto.getScheduleObjectID() + "'," + 
                           " ScheduleObjectName = '" + prpLscheduleItemDto.getScheduleObjectName() + "'," + 
                           " InputDate = '" + prpLscheduleItemDto.getInputDate() + "'," + 
                           " ResultInfo = '" + prpLscheduleItemDto.getResultInfo() + "'," + 
                           " BookFlag = '" + prpLscheduleItemDto.getBookFlag() + "'," + 
                           " ScheduleType = '" + prpLscheduleItemDto.getScheduleType() + "'," + 
                           " Flag = '" + prpLscheduleItemDto.getFlag() + "'," + 
                           " NextHandlerCode = '" + prpLscheduleItemDto.getNextHandlerCode() + "'," + 
                           " NextHandlerName = '" + prpLscheduleItemDto.getNextHandlerName() + "'," + 
                           " NextNodeNo = '" + prpLscheduleItemDto.getNextNodeNo() + "'," + 
                           " OperatorCode = '" + prpLscheduleItemDto.getOperatorCode() + "'," + 
                           " FactoryPhone = '" + prpLscheduleItemDto.getFactoryPhone() + "'," + 
                           " FactoryEstimateLoss = '" + prpLscheduleItemDto.getFactoryEstimateLoss() + "'," + 
                           " commendRepairFactoryCode = '" + prpLscheduleItemDto.getCommendRepairFactoryCode() + "'," + 
                           " commendRepairFactoryName = '" + prpLscheduleItemDto.getCommendRepairFactoryName() + "'," + 
                           " ExigenceGree = '" + prpLscheduleItemDto.getExigenceGree() + "'," + 
                           " ScheduleStatus = '" + prpLscheduleItemDto.getScheduleStatus() + "'" + 
			               " Where " +
                           " ScheduleID = " + prpLscheduleItemDto.getScheduleID() + " And " + 
                           " RegistNo = '" + prpLscheduleItemDto.getRegistNo() + "' And " + 
                           " ItemNo = " + prpLscheduleItemDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLscheduleItemDto.getInsureCarFlag());
        dbManager.setString(2,prpLscheduleItemDto.getClaimComCode());
        dbManager.setString(3,prpLscheduleItemDto.getSelectSend());
        dbManager.setInt(4,prpLscheduleItemDto.getSurveyTimes());
        dbManager.setString(5,prpLscheduleItemDto.getSurveyType());
        dbManager.setString(6,prpLscheduleItemDto.getCheckSite());
        dbManager.setString(7,prpLscheduleItemDto.getLicenseNo());
        dbManager.setString(8,prpLscheduleItemDto.getScheduleObjectID());
        dbManager.setString(9,prpLscheduleItemDto.getScheduleObjectName());
        dbManager.setDateTime(10,prpLscheduleItemDto.getInputDate());
        dbManager.setString(11,prpLscheduleItemDto.getResultInfo());
        dbManager.setString(12,prpLscheduleItemDto.getBookFlag());
        dbManager.setString(13,prpLscheduleItemDto.getScheduleType());
        dbManager.setString(14,prpLscheduleItemDto.getFlag());
        dbManager.setString(15,prpLscheduleItemDto.getNextHandlerCode());
        dbManager.setString(16,prpLscheduleItemDto.getNextHandlerName());
        dbManager.setString(17,prpLscheduleItemDto.getNextNodeNo());
        dbManager.setString(18,prpLscheduleItemDto.getOperatorCode());
        dbManager.setString(19,prpLscheduleItemDto.getFactoryPhone());
        dbManager.setDouble(20,prpLscheduleItemDto.getFactoryEstimateLoss());
        dbManager.setString(21,prpLscheduleItemDto.getCommendRepairFactoryCode());
        dbManager.setString(22,prpLscheduleItemDto.getCommendRepairFactoryName());
        dbManager.setString(23,prpLscheduleItemDto.getExigenceGree());
        dbManager.setString(24,prpLscheduleItemDto.getScheduleStatus());
        //设置条件字段;
        dbManager.setInt(25,prpLscheduleItemDto.getScheduleID());
        dbManager.setString(26,prpLscheduleItemDto.getRegistNo());
        dbManager.setInt(27,prpLscheduleItemDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLscheduleItemBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param itemNo ITEMNO
     * @return PrpLscheduleItemDto
     * @throws Exception
     */
    public PrpLscheduleItemDto findByPrimaryKey(int scheduleID,String registNo,int itemNo) throws Exception{
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
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " Flag," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " OperatorCode," + 
                           " FactoryPhone," + 
                           " FactoryEstimateLoss," + 
                           " commendRepairFactoryCode," + 
                           " commendRepairFactoryName," + 
                           " ExigenceGree," + 
                           " ScheduleStatus," + 
                           " CommiItemFlag From PrpLscheduleItem";
        String statement = mainStatement + " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ?";
        PrpLscheduleItemDto prpLscheduleItemDto = null;
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
            prpLscheduleItemDto = new PrpLscheduleItemDto();
            prpLscheduleItemDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleItemDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleItemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpLscheduleItemDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLscheduleItemDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLscheduleItemDto.setSelectSend(dbManager.getString(resultSet,6));
            prpLscheduleItemDto.setSurveyTimes(dbManager.getInt(resultSet,7));
            prpLscheduleItemDto.setSurveyType(dbManager.getString(resultSet,8));
            prpLscheduleItemDto.setCheckSite(dbManager.getString(resultSet,9));
            prpLscheduleItemDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLscheduleItemDto.setScheduleObjectID(dbManager.getString(resultSet,11));
            prpLscheduleItemDto.setScheduleObjectName(dbManager.getString(resultSet,12));
            prpLscheduleItemDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLscheduleItemDto.setResultInfo(dbManager.getString(resultSet,14));
            prpLscheduleItemDto.setBookFlag(dbManager.getString(resultSet,15));
            prpLscheduleItemDto.setScheduleType(dbManager.getString(resultSet,16));
            prpLscheduleItemDto.setFlag(dbManager.getString(resultSet,17));
            prpLscheduleItemDto.setNextHandlerCode(dbManager.getString(resultSet,18));
            prpLscheduleItemDto.setNextHandlerName(dbManager.getString(resultSet,19));
            prpLscheduleItemDto.setNextNodeNo(dbManager.getString(resultSet,20));
            prpLscheduleItemDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLscheduleItemDto.setFactoryPhone(dbManager.getString(resultSet,22));
            prpLscheduleItemDto.setFactoryEstimateLoss(dbManager.getDouble(resultSet,23));
            prpLscheduleItemDto.setCommendRepairFactoryCode(dbManager.getString(resultSet,24));
            prpLscheduleItemDto.setCommendRepairFactoryName(dbManager.getString(resultSet,25));
            prpLscheduleItemDto.setExigenceGree(dbManager.getString(resultSet,26));
            prpLscheduleItemDto.setScheduleStatus(dbManager.getString(resultSet,27));
            prpLscheduleItemDto.setCommiItemFlag(dbManager.getString(resultSet,28));
        }
        resultSet.close();
        logger.info("DBPrpLscheduleItemBase.findByPrimaryKey() success!");
        return prpLscheduleItemDto;
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
                           " ResultInfo," + 
                           " BookFlag," + 
                           " ScheduleType," + 
                           " Flag," + 
                           " NextHandlerCode," + 
                           " NextHandlerName," + 
                           " NextNodeNo," + 
                           " OperatorCode," + 
                           " FactoryPhone," + 
                           " FactoryEstimateLoss," + 
                           " commendRepairFactoryCode," + 
                           " commendRepairFactoryName," + 
                           " ExigenceGree," + 
                           " ScheduleStatus," + 
                           " CommiItemFlag From PrpLscheduleItem Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLscheduleItemDto prpLscheduleItemDto = null;
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

            prpLscheduleItemDto = new PrpLscheduleItemDto();
            prpLscheduleItemDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLscheduleItemDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLscheduleItemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpLscheduleItemDto.setInsureCarFlag(dbManager.getString(resultSet,4));
            prpLscheduleItemDto.setClaimComCode(dbManager.getString(resultSet,5));
            prpLscheduleItemDto.setSelectSend(dbManager.getString(resultSet,6));
            prpLscheduleItemDto.setSurveyTimes(dbManager.getInt(resultSet,7));
            prpLscheduleItemDto.setSurveyType(dbManager.getString(resultSet,8));
            prpLscheduleItemDto.setCheckSite(dbManager.getString(resultSet,9));
            prpLscheduleItemDto.setLicenseNo(dbManager.getString(resultSet,10));
            prpLscheduleItemDto.setScheduleObjectID(dbManager.getString(resultSet,11));
            prpLscheduleItemDto.setScheduleObjectName(dbManager.getString(resultSet,12));
            prpLscheduleItemDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpLscheduleItemDto.setResultInfo(dbManager.getString(resultSet,14));
            prpLscheduleItemDto.setBookFlag(dbManager.getString(resultSet,15));
            prpLscheduleItemDto.setScheduleType(dbManager.getString(resultSet,16));
            prpLscheduleItemDto.setFlag(dbManager.getString(resultSet,17));
            prpLscheduleItemDto.setNextHandlerCode(dbManager.getString(resultSet,18));
            prpLscheduleItemDto.setNextHandlerName(dbManager.getString(resultSet,19));
            prpLscheduleItemDto.setNextNodeNo(dbManager.getString(resultSet,20));
            prpLscheduleItemDto.setOperatorCode(dbManager.getString(resultSet,21));
            prpLscheduleItemDto.setFactoryPhone(dbManager.getString(resultSet,22));
            prpLscheduleItemDto.setFactoryEstimateLoss(dbManager.getDouble(resultSet,23));
            prpLscheduleItemDto.setCommendRepairFactoryCode(dbManager.getString(resultSet,24));
            prpLscheduleItemDto.setCommendRepairFactoryName(dbManager.getString(resultSet,25));
            prpLscheduleItemDto.setExigenceGree(dbManager.getString(resultSet,26));
            prpLscheduleItemDto.setScheduleStatus(dbManager.getString(resultSet,27));
            prpLscheduleItemDto.setCommiItemFlag(dbManager.getString(resultSet,28));
            collection.add(prpLscheduleItemDto);
        }
        resultSet.close();
        logger.info("DBPrpLscheduleItemBase.findByConditions() success!");
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
        String statement = "Delete From PrpLscheduleItem Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLscheduleItemBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLscheduleItem Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLscheduleItemBase.getCount() success!");
        return count;
    }
}
