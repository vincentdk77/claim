package com.sinosoft.claim.resource.dtofactory.domain;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogBase;
import com.gyic.claim.dto.domain.PrplcombineSwfLogDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLog-工作流日志表（新增）的数据访问对象基类<br>
 * 创建于 2005-04-20 11:21:05.078<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfLogBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBSwfLogBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void insert(SwfLogDto swfLogDto) throws Exception{
        String mainStatement = " Insert Into SwfLog (" + 
                           " FlowID," + 
                           " LogNo," + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " BusinessNo," + 
                           " HandleDept," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " FlowInTime," + 
                           " TimeLimit," + 
                           " HandleTime," + 
                           " SubmitTime," + 
                           " NodeStatus," + 
                           " FlowStatus," + 
                           " PackageID," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " TitleStr," + 
                           " BusinessType," + 
                           " RiskCode," + 
                           " KeyIn," + 
                           " KeyOut," + 
                           " DeptName," + 
                           " MainFlowID," + 
                           " SubFlowID," + 
                           " PosX," + 
                           " PosY," + 
                           " EndFlag," + 
                           " BeforeHandlerCode," + 
                           " BeforeHandlerName," + 
                           " PolicyNo," + 
                           " TypeFlag," + 
                           " ComCode," + 
                           " ScheduleID," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " HandlerRange," + 
                           " ExigenceGree," + 
                           " RegistNo," + 
                           " InsuredName," +
                           " dataFlag,"+
                           " medicalTransitFlag,"+
                           " systemFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + swfLogDto.getFlowID() + "'," + 
                           "" + swfLogDto.getLogNo() + "," + 
                           "" + swfLogDto.getModelNo() + "," + 
                           "" + swfLogDto.getNodeNo() + "," + 
                           "'" + swfLogDto.getNodeName() + "'," + 
                           "'" + swfLogDto.getBusinessNo() + "'," + 
                           "'" + swfLogDto.getHandleDept() + "'," + 
                           "'" + swfLogDto.getHandlerCode() + "'," + 
                           "'" + swfLogDto.getHandlerName() + "'," + 
                           "'" + swfLogDto.getFlowInTime() + "'," + 
                           "" + swfLogDto.getTimeLimit() + "," + 
                           "'" + swfLogDto.getHandleTime() + "'," + 
                           "'" + swfLogDto.getSubmitTime() + "'," + 
                           "'" + swfLogDto.getNodeStatus() + "'," + 
                           "'" + swfLogDto.getFlowStatus() + "'," + 
                           "'" + swfLogDto.getPackageID() + "'," + 
                           "'" + swfLogDto.getFlag() + "'," + 
                           "" + swfLogDto.getTaskNo() + "," + 
                           "'" + swfLogDto.getTaskType() + "'," + 
                           "'" + swfLogDto.getNodeType() + "'," + 
                           "'" + swfLogDto.getTitleStr() + "'," + 
                           "'" + swfLogDto.getBusinessType() + "'," + 
                           "'" + swfLogDto.getRiskCode() + "'," + 
                           "'" + swfLogDto.getKeyIn() + "'," + 
                           "'" + swfLogDto.getKeyOut() + "'," + 
                           "'" + swfLogDto.getDeptName() + "'," + 
                           "'" + swfLogDto.getMainFlowID() + "'," + 
                           "'" + swfLogDto.getSubFlowID() + "'," + 
                           "" + swfLogDto.getPosX() + "," + 
                           "" + swfLogDto.getPosY() + "," + 
                           "'" + swfLogDto.getEndFlag() + "'," + 
                           "'" + swfLogDto.getBeforeHandlerCode() + "'," + 
                           "'" + swfLogDto.getBeforeHandlerName() + "'," + 
                           "'" + swfLogDto.getPolicyNo() + "'," + 
                           "'" + swfLogDto.getTypeFlag() + "'," + 
                           "'" + swfLogDto.getComCode() + "'," + 
                           "" + swfLogDto.getScheduleID() + "," + 
                           "'" + swfLogDto.getLossItemCode() + "'," + 
                           "'" + swfLogDto.getLossItemName() + "'," + 
                           "'" + swfLogDto.getInsureCarFlag() + "'," + 
                           "'" + swfLogDto.getHandlerRange() + "'," + 
                           "'" + swfLogDto.getExigenceGree() + "'," + 
                           "'" + swfLogDto.getRegistNo() + "'," + 
                           "'" + swfLogDto.getInsuredName() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,swfLogDto.getFlowID());
        dbManager.setInt(2,swfLogDto.getLogNo());
        dbManager.setInt(3,swfLogDto.getModelNo());
        dbManager.setInt(4,swfLogDto.getNodeNo());
        dbManager.setString(5,swfLogDto.getNodeName());
        dbManager.setString(6,swfLogDto.getBusinessNo());
        dbManager.setString(7,swfLogDto.getHandleDept());
        dbManager.setString(8,swfLogDto.getHandlerCode());
        dbManager.setString(9,swfLogDto.getHandlerName());
        dbManager.setString(10,swfLogDto.getFlowInTime());
        dbManager.setInt(11,swfLogDto.getTimeLimit());
        dbManager.setString(12,swfLogDto.getHandleTime());
        dbManager.setString(13,swfLogDto.getSubmitTime());
        dbManager.setString(14,swfLogDto.getNodeStatus());
        dbManager.setString(15,swfLogDto.getFlowStatus());
        dbManager.setString(16,swfLogDto.getPackageID());
        dbManager.setString(17,swfLogDto.getFlag());
        dbManager.setInt(18,swfLogDto.getTaskNo());
        dbManager.setString(19,swfLogDto.getTaskType());
        dbManager.setString(20,swfLogDto.getNodeType());
        dbManager.setString(21,swfLogDto.getTitleStr());
        dbManager.setString(22,swfLogDto.getBusinessType());
        dbManager.setString(23,swfLogDto.getRiskCode());
        dbManager.setString(24,swfLogDto.getKeyIn());
        dbManager.setString(25,swfLogDto.getKeyOut());
        dbManager.setString(26,swfLogDto.getDeptName());
        dbManager.setString(27,swfLogDto.getMainFlowID());
        dbManager.setString(28,swfLogDto.getSubFlowID());
        dbManager.setInt(29,swfLogDto.getPosX());
        dbManager.setInt(30,swfLogDto.getPosY());
        dbManager.setString(31,swfLogDto.getEndFlag());
        dbManager.setString(32,swfLogDto.getBeforeHandlerCode());
        dbManager.setString(33,swfLogDto.getBeforeHandlerName());
        dbManager.setString(34,swfLogDto.getPolicyNo());
        dbManager.setString(35,swfLogDto.getTypeFlag());
        dbManager.setString(36,swfLogDto.getComCode());
        dbManager.setInt(37,swfLogDto.getScheduleID());
        dbManager.setString(38,swfLogDto.getLossItemCode());
        dbManager.setString(39,swfLogDto.getLossItemName());
        dbManager.setString(40,swfLogDto.getInsureCarFlag());
        dbManager.setString(41,swfLogDto.getHandlerRange());
        dbManager.setString(42,swfLogDto.getExigenceGree());
        dbManager.setString(43,swfLogDto.getRegistNo());
        dbManager.setString(44,swfLogDto.getInsuredName());
        dbManager.setString(45, swfLogDto.getDataFlag());
        dbManager.setString(46, swfLogDto.getMedicalTransitFlag());
        dbManager.setString(47, swfLogDto.getSystemFlag());//新农险呼救中心改派存储SystemFlag='agri'
        dbManager.executePreparedUpdate();

        logger.info("DBSwfLogBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfLog (" + 
                           " FlowID," + 
                           " LogNo," + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " BusinessNo," + 
                           " HandleDept," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " FlowInTime," + 
                           " TimeLimit," + 
                           " HandleTime," + 
                           " SubmitTime," + 
                           " NodeStatus," + 
                           " FlowStatus," + 
                           " PackageID," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " TitleStr," + 
                           " BusinessType," + 
                           " RiskCode," + 
                           " KeyIn," + 
                           " KeyOut," + 
                           " DeptName," + 
                           " MainFlowID," + 
                           " SubFlowID," + 
                           " PosX," + 
                           " PosY," + 
                           " EndFlag," + 
                           " BeforeHandlerCode," + 
                           " BeforeHandlerName," + 
                           " PolicyNo," + 
                           " TypeFlag," + 
                           " ComCode," + 
                           " ScheduleID," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " HandlerRange," + 
                           " ExigenceGree," + 
                           " RegistNo," + 
                           " InsuredName," +
                           " dataFlag,"+
                           " medicalTransitFlag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfLogDto swfLogDto = (SwfLogDto)i.next();
            dbManager.setString(1,swfLogDto.getFlowID());
            dbManager.setInt(2,swfLogDto.getLogNo());
            dbManager.setInt(3,swfLogDto.getModelNo());
            dbManager.setInt(4,swfLogDto.getNodeNo());
            dbManager.setString(5,swfLogDto.getNodeName());
            dbManager.setString(6,swfLogDto.getBusinessNo());
            dbManager.setString(7,swfLogDto.getHandleDept());
            dbManager.setString(8,swfLogDto.getHandlerCode());
            dbManager.setString(9,swfLogDto.getHandlerName());
            dbManager.setString(10,swfLogDto.getFlowInTime());
            dbManager.setInt(11,swfLogDto.getTimeLimit());
            dbManager.setString(12,swfLogDto.getHandleTime());
            dbManager.setString(13,swfLogDto.getSubmitTime());
            dbManager.setString(14,swfLogDto.getNodeStatus());
            dbManager.setString(15,swfLogDto.getFlowStatus());
            dbManager.setString(16,swfLogDto.getPackageID());
            dbManager.setString(17,swfLogDto.getFlag());
            dbManager.setInt(18,swfLogDto.getTaskNo());
            dbManager.setString(19,swfLogDto.getTaskType());
            dbManager.setString(20,swfLogDto.getNodeType());
            dbManager.setString(21,swfLogDto.getTitleStr());
            dbManager.setString(22,swfLogDto.getBusinessType());
            dbManager.setString(23,swfLogDto.getRiskCode());
            dbManager.setString(24,swfLogDto.getKeyIn());
            dbManager.setString(25,swfLogDto.getKeyOut());
            dbManager.setString(26,swfLogDto.getDeptName());
            dbManager.setString(27,swfLogDto.getMainFlowID());
            dbManager.setString(28,swfLogDto.getSubFlowID());
            dbManager.setInt(29,swfLogDto.getPosX());
            dbManager.setInt(30,swfLogDto.getPosY());
            dbManager.setString(31,swfLogDto.getEndFlag());
            dbManager.setString(32,swfLogDto.getBeforeHandlerCode());
            dbManager.setString(33,swfLogDto.getBeforeHandlerName());
            dbManager.setString(34,swfLogDto.getPolicyNo());
            dbManager.setString(35,swfLogDto.getTypeFlag());
            dbManager.setString(36,swfLogDto.getComCode());
            dbManager.setInt(37,swfLogDto.getScheduleID());
            dbManager.setString(38,swfLogDto.getLossItemCode());
            dbManager.setString(39,swfLogDto.getLossItemName());
            dbManager.setString(40,swfLogDto.getInsureCarFlag());
            dbManager.setString(41,swfLogDto.getHandlerRange());
            dbManager.setString(42,swfLogDto.getExigenceGree());
            dbManager.setString(43,swfLogDto.getRegistNo());
            dbManager.setString(44,swfLogDto.getInsuredName());
            dbManager.setString(45, swfLogDto.getDataFlag());
            dbManager.setString(46, swfLogDto.getMedicalTransitFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfLogBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param flowID 流程编号
     * @param logNo 序号
     * @throws Exception
     */
    public void delete(String flowID,int logNo) throws Exception{
        String statement = " Delete From SwfLog" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfLog Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " LogNo = " + logNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,logNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfLogBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void update(SwfLogDto swfLogDto) throws Exception{
        String statement = " Update SwfLog Set ModelNo = ?," + 
                           " NodeNo = ?," + 
                           " NodeName = ?," + 
                           " BusinessNo = ?," + 
                           " HandleDept = ?," + 
                           " HandlerCode = ?," + 
                           " HandlerName = ?," + 
                           " FlowInTime = ?," + 
                           " TimeLimit = ?," + 
                           " HandleTime = ?," + 
                           " SubmitTime = ?," + 
                           " NodeStatus = ?," + 
                           " FlowStatus = ?," + 
                           " PackageID = ?," + 
                           " Flag = ?," + 
                           " TaskNo = ?," + 
                           " TaskType = ?," + 
                           " NodeType = ?," + 
                           " TitleStr = ?," + 
                           " BusinessType = ?," + 
                           " RiskCode = ?," + 
                           " KeyIn = ?," + 
                           " KeyOut = ?," + 
                           " DeptName = ?," + 
                           " MainFlowID = ?," + 
                           " SubFlowID = ?," + 
                           " PosX = ?," + 
                           " PosY = ?," + 
                           " EndFlag = ?," + 
                           " BeforeHandlerCode = ?," + 
                           " BeforeHandlerName = ?," + 
                           " PolicyNo = ?," + 
                           " TypeFlag = ?," + 
                           " ComCode = ?," + 
                           " ScheduleID = ?," + 
                           " LossItemCode = ?," + 
                           " LossItemName = ?," + 
                           " InsureCarFlag = ?," + 
                           " HandlerRange = ?," + 
                           " ExigenceGree = ?," + 
                           " RegistNo = ?," + 
                           " InsuredName = ?," +
                           " dataFlag = ?" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfLog Set " + 
                           " FlowID = '" + swfLogDto.getFlowID() + "'," + 
                           " LogNo = " + swfLogDto.getLogNo() + "," + 
                           " ModelNo = " + swfLogDto.getModelNo() + "," + 
                           " NodeNo = " + swfLogDto.getNodeNo() + "," + 
                           " NodeName = '" + swfLogDto.getNodeName() + "'," + 
                           " BusinessNo = '" + swfLogDto.getBusinessNo() + "'," + 
                           " HandleDept = '" + swfLogDto.getHandleDept() + "'," + 
                           " HandlerCode = '" + swfLogDto.getHandlerCode() + "'," + 
                           " HandlerName = '" + swfLogDto.getHandlerName() + "'," + 
                           " FlowInTime = '" + swfLogDto.getFlowInTime() + "'," + 
                           " TimeLimit = " + swfLogDto.getTimeLimit() + "," + 
                           " HandleTime = '" + swfLogDto.getHandleTime() + "'," + 
                           " SubmitTime = '" + swfLogDto.getSubmitTime() + "'," + 
                           " NodeStatus = '" + swfLogDto.getNodeStatus() + "'," + 
                           " FlowStatus = '" + swfLogDto.getFlowStatus() + "'," + 
                           " PackageID = '" + swfLogDto.getPackageID() + "'," + 
                           " Flag = '" + swfLogDto.getFlag() + "'," + 
                           " TaskNo = " + swfLogDto.getTaskNo() + "," + 
                           " TaskType = '" + swfLogDto.getTaskType() + "'," + 
                           " NodeType = '" + swfLogDto.getNodeType() + "'," + 
                           " TitleStr = '" + swfLogDto.getTitleStr() + "'," + 
                           " BusinessType = '" + swfLogDto.getBusinessType() + "'," + 
                           " RiskCode = '" + swfLogDto.getRiskCode() + "'," + 
                           " KeyIn = '" + swfLogDto.getKeyIn() + "'," + 
                           " KeyOut = '" + swfLogDto.getKeyOut() + "'," + 
                           " DeptName = '" + swfLogDto.getDeptName() + "'," + 
                           " MainFlowID = '" + swfLogDto.getMainFlowID() + "'," + 
                           " SubFlowID = '" + swfLogDto.getSubFlowID() + "'," + 
                           " PosX = " + swfLogDto.getPosX() + "," + 
                           " PosY = " + swfLogDto.getPosY() + "," + 
                           " EndFlag = '" + swfLogDto.getEndFlag() + "'," + 
                           " BeforeHandlerCode = '" + swfLogDto.getBeforeHandlerCode() + "'," + 
                           " BeforeHandlerName = '" + swfLogDto.getBeforeHandlerName() + "'," + 
                           " PolicyNo = '" + swfLogDto.getPolicyNo() + "'," + 
                           " TypeFlag = '" + swfLogDto.getTypeFlag() + "'," + 
                           " ComCode = '" + swfLogDto.getComCode() + "'," + 
                           " ScheduleID = " + swfLogDto.getScheduleID() + "," + 
                           " LossItemCode = '" + swfLogDto.getLossItemCode() + "'," + 
                           " LossItemName = '" + swfLogDto.getLossItemName() + "'," + 
                           " InsureCarFlag = '" + swfLogDto.getInsureCarFlag() + "'," + 
                           " HandlerRange = '" + swfLogDto.getHandlerRange() + "'," + 
                           " ExigenceGree = '" + swfLogDto.getExigenceGree() + "'," + 
                           " RegistNo = '" + swfLogDto.getRegistNo() + "'," + 
                           " InsuredName = '" + swfLogDto.getInsuredName() + "'" + 
			               " Where " +
                           " FlowID = '" + swfLogDto.getFlowID() + "' And " + 
                           " LogNo = " + swfLogDto.getLogNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setInt(1,swfLogDto.getModelNo());
        dbManager.setInt(2,swfLogDto.getNodeNo());
        dbManager.setString(3,swfLogDto.getNodeName());
        dbManager.setString(4,swfLogDto.getBusinessNo());
        dbManager.setString(5,swfLogDto.getHandleDept());
        dbManager.setString(6,swfLogDto.getHandlerCode());
        dbManager.setString(7,swfLogDto.getHandlerName());
        dbManager.setString(8,swfLogDto.getFlowInTime());
        dbManager.setInt(9,swfLogDto.getTimeLimit());
        dbManager.setString(10,swfLogDto.getHandleTime());
        dbManager.setString(11,swfLogDto.getSubmitTime());
        dbManager.setString(12,swfLogDto.getNodeStatus());
        dbManager.setString(13,swfLogDto.getFlowStatus());
        dbManager.setString(14,swfLogDto.getPackageID());
        dbManager.setString(15,swfLogDto.getFlag());
        dbManager.setInt(16,swfLogDto.getTaskNo());
        dbManager.setString(17,swfLogDto.getTaskType());
        dbManager.setString(18,swfLogDto.getNodeType());
        dbManager.setString(19,swfLogDto.getTitleStr());
        dbManager.setString(20,swfLogDto.getBusinessType());
        dbManager.setString(21,swfLogDto.getRiskCode());
        dbManager.setString(22,swfLogDto.getKeyIn());
        dbManager.setString(23,swfLogDto.getKeyOut());
        dbManager.setString(24,swfLogDto.getDeptName());
        dbManager.setString(25,swfLogDto.getMainFlowID());
        dbManager.setString(26,swfLogDto.getSubFlowID());
        dbManager.setInt(27,swfLogDto.getPosX());
        dbManager.setInt(28,swfLogDto.getPosY());
        dbManager.setString(29,swfLogDto.getEndFlag());
        dbManager.setString(30,swfLogDto.getBeforeHandlerCode());
        dbManager.setString(31,swfLogDto.getBeforeHandlerName());
        dbManager.setString(32,swfLogDto.getPolicyNo());
        dbManager.setString(33,swfLogDto.getTypeFlag());
        dbManager.setString(34,swfLogDto.getComCode());
        dbManager.setInt(35,swfLogDto.getScheduleID());
        dbManager.setString(36,swfLogDto.getLossItemCode());
        dbManager.setString(37,swfLogDto.getLossItemName());
        dbManager.setString(38,swfLogDto.getInsureCarFlag());
        dbManager.setString(39,swfLogDto.getHandlerRange());
        dbManager.setString(40,swfLogDto.getExigenceGree());
        dbManager.setString(41,swfLogDto.getRegistNo());
        dbManager.setString(42,swfLogDto.getInsuredName());
        dbManager.setString(43, swfLogDto.getDataFlag());
        //设置条件字段;
        dbManager.setString(44,swfLogDto.getFlowID());
        dbManager.setInt(45,swfLogDto.getLogNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfLogBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param flowID 流程编号
     * @param logNo 序号
     * @return SwfLogDto
     * @throws Exception
     */
    public SwfLogDto findByPrimaryKey(String flowID,int logNo) throws Exception{
        String mainStatement = " Select FlowID," + 
                           " LogNo," + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " BusinessNo," + 
                           " HandleDept," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " FlowInTime," + 
                           " TimeLimit," + 
                           " HandleTime," + 
                           " SubmitTime," + 
                           " NodeStatus," + 
                           " FlowStatus," + 
                           " PackageID," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " TitleStr," + 
                           " BusinessType," + 
                           " RiskCode," + 
                           " KeyIn," + 
                           " KeyOut," + 
                           " DeptName," + 
                           " MainFlowID," + 
                           " SubFlowID," + 
                           " PosX," + 
                           " PosY," + 
                           " EndFlag," + 
                           " BeforeHandlerCode," + 
                           " BeforeHandlerName," + 
                           " PolicyNo," + 
                           " TypeFlag," + 
                           " ComCode," + 
                           " ScheduleID," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " HandlerRange," + 
                           " ExigenceGree," + 
                           " RegistNo," + 
                           " InsuredName," +
                           " dataFlag,medicalTransitFlag,systemFlag From SwfLog";//增加systemFlag查询，用于新农险数据的判断
        String statement = mainStatement + " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ?";
        SwfLogDto swfLogDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " LogNo = " + logNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,logNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfLogDto = new SwfLogDto();
            swfLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogDto.setFlag(dbManager.getString(resultSet,17));
            swfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogDto.setComCode(dbManager.getString(resultSet,36));
            swfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,43));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,44));
            swfLogDto.setDataFlag(dbManager.getString(resultSet, 45));
            swfLogDto.setMedicalTransitFlag(dbManager.getString(resultSet, 46));
            swfLogDto.setSystemFlag(dbManager.getString(resultSet, 47));//增加systemFlag查询，用于新农险数据的判断
            logger.info("DBSwfLogBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfLogBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfLogDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findAllStatusByConditions(String swflogConditions,String swflogStoreConditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select FlowID," + 
                           " LogNo," + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " BusinessNo," + 
                           " HandleDept," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " FlowInTime," + 
                           " TimeLimit," + 
                           " HandleTime," + 
                           " SubmitTime," + 
                           " NodeStatus," + 
                           " FlowStatus," + 
                           " PackageID," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " TitleStr," + 
                           " BusinessType," + 
                           " RiskCode," + 
                           " KeyIn," + 
                           " KeyOut," + 
                           " DeptName," + 
                           " MainFlowID," + 
                           " SubFlowID," + 
                           " PosX," + 
                           " PosY," + 
                           " EndFlag," + 
                           " BeforeHandlerCode," + 
                           " BeforeHandlerName," + 
                           " PolicyNo," + 
                           " TypeFlag," + 
                           " ComCode," + 
                           " ScheduleID," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " HandlerRange," + 
                           " ExigenceGree," + 
                           " RegistNo," + 
                           " InsuredName," +
                           " dataFlag,medicalTransitFlag " +
                           " From (" +
                           " select * From SwfLog Where " + swflogConditions + 
                           " union all " +
                           " select * From SwfLogStore Where " + swflogStoreConditions +
                           ")  order by handleTime desc" ;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfLogDto swfLogDto = null;
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

            swfLogDto = new SwfLogDto();
            swfLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogDto.setFlag(dbManager.getString(resultSet,17));
            swfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogDto.setComCode(dbManager.getString(resultSet,36));
            swfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,43));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,44));
            swfLogDto.setDataFlag(dbManager.getString(resultSet, 45));
            swfLogDto.setMedicalTransitFlag(dbManager.getString(resultSet, 46));
            collection.add(swfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
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
        String statement = "Select /*+first_rows*/FlowID," + 
                           " LogNo," + 
                           " ModelNo," + 
                           " NodeNo," + 
                           " NodeName," + 
                           " BusinessNo," + 
                           " HandleDept," + 
                           " HandlerCode," + 
                           " HandlerName," + 
                           " FlowInTime," + 
                           " TimeLimit," + 
                           " HandleTime," + 
                           " SubmitTime," + 
                           " NodeStatus," + 
                           " FlowStatus," + 
                           " PackageID," + 
                           " Flag," + 
                           " TaskNo," + 
                           " TaskType," + 
                           " NodeType," + 
                           " TitleStr," + 
                           " BusinessType," + 
                           " RiskCode," + 
                           " KeyIn," + 
                           " KeyOut," + 
                           " DeptName," + 
                           " MainFlowID," + 
                           " SubFlowID," + 
                           " PosX," + 
                           " PosY," + 
                           " EndFlag," + 
                           " BeforeHandlerCode," + 
                           " BeforeHandlerName," + 
                           " PolicyNo," + 
                           " TypeFlag," + 
                           " ComCode," + 
                           " ScheduleID," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " InsureCarFlag," + 
                           " HandlerRange," + 
                           " ExigenceGree," + 
                           " RegistNo," + 
                           " dataFlag," +
                           " InsuredName,medicalTransitFlag From SwfLog Where " + conditions;
        logger.debug(statement);
        
        Collection collection = new ArrayList();
        SwfLogDto swfLogDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        logger.debug(statement);
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

            swfLogDto = new SwfLogDto();
            swfLogDto.setFlowID(dbManager.getString(resultSet,1));
            swfLogDto.setLogNo(dbManager.getInt(resultSet,2));
            swfLogDto.setModelNo(dbManager.getInt(resultSet,3));
            swfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
            swfLogDto.setNodeName(dbManager.getString(resultSet,5));
            swfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
            swfLogDto.setHandleDept(dbManager.getString(resultSet,7));
            swfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
            swfLogDto.setHandlerName(dbManager.getString(resultSet,9));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
            swfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
            swfLogDto.setHandleTime(dbManager.getString(resultSet,12));
            swfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
            swfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
            swfLogDto.setPackageID(dbManager.getString(resultSet,16));
            swfLogDto.setFlag(dbManager.getString(resultSet,17));
            swfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
            swfLogDto.setTaskType(dbManager.getString(resultSet,19));
            swfLogDto.setNodeType(dbManager.getString(resultSet,20));
            swfLogDto.setTitleStr(dbManager.getString(resultSet,21));
            swfLogDto.setBusinessType(dbManager.getString(resultSet,22));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,23));
            swfLogDto.setKeyIn(dbManager.getString(resultSet,24));
            swfLogDto.setKeyOut(dbManager.getString(resultSet,25));
            swfLogDto.setDeptName(dbManager.getString(resultSet,26));
            swfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
            swfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
            swfLogDto.setPosX(dbManager.getInt(resultSet,29));
            swfLogDto.setPosY(dbManager.getInt(resultSet,30));
            swfLogDto.setEndFlag(dbManager.getString(resultSet,31));
            swfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            swfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
            swfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
            swfLogDto.setComCode(dbManager.getString(resultSet,36));
            swfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
            swfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
            swfLogDto.setLossItemName(dbManager.getString(resultSet,39));
            swfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            swfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
            swfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,43));
            swfLogDto.setDataFlag(dbManager.getString(resultSet, 44));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,45));
            swfLogDto.setMedicalTransitFlag(dbManager.getString(resultSet,46));
            collection.add(swfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
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
        String statement = "Delete From SwfLog Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfLogBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfLog Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public int getComBineCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) from (select s.registno from swflog s " +
					        " where s.registno in (select distinct (o.registno) from swflog o, prplregist g " +
					        " where "+conditions+") and not exists " +
					        " (select 1 from prplcombine k where k.registno = s.registno) "+
					        "and not exists (select 1 from swflog k where k.registno = s.registno and  nodetype='cance')  "+//屏蔽立案注销拒赔
					        " and nodestatus != 4 "+
					        " and  nodetype in ('check','certa','claim','certi')"+
					        " group by s.registno )";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 按事故号查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public int getComBineCountByComBineNo(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) from (select h.nodestatus," +
                                   "h.registno," +
        		                   "p.combineno," +
        		                   "h.policyno," +
        		                   "h.riskcode," +
        		                   "h.insuredname," +
        		                   "h.FlowInTime," +
        		                   "h.nodename " +
        		           "from (select l.nodestatus,l.registno,l.policyno,l.riskcode,l.insuredname,l.FlowInTime,l.nodename " +
        		           "from swflog l,(select s.registno, min(logno) logno " +
        		           "from swflog s " +
        		           "where s.registno in (select distinct (registno) from swflog) " +
        		           "and nodestatus!='4' " +
        		           "and nodetype in ('check','certa','claim','certi') " +
        		           " group by s.registno) t " +
        		           "where l.registno = t.registno and l.logno = t.logno) h,prplcombine p " +
        		           "where h.registno = p.registno and p."+conditions+")";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 按保单号查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public int getComBineCountByPolicyNo(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) " +
        						   "from (select l.* from swflog l,(select s.registno, min(logno) logno " +
                                   "from swflog s where s.registno in (select o.registno" +
                                   " from swflog o, prplregist g where "+conditions+") " +
		        		           "and nodestatus!='4' " +
		        		           "and nodetype in ('check','certa','claim','certi')  group by s.registno) t,prplcombine u " +
                                   "where l.registno = t.registno and l.logno = t.logno and l.registno = u.registno)";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 按报案号查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public int getComBineCountByRegistNo(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) from (select h.nodestatus," +
                                  "h.registno," +
                                  "(select p.combineno from prplcombine p where p.registno = h.registno) as combineno," +      		           
                                  "h.policyno," +
                                  "h.riskcode," +
                                  "h.insuredname," +
                                  "h.FlowInTime," +
                                  "h.nodename from (select l.nodestatus," +
                                  "l.registno," +
                                  "l.policyno," +
                                  "l.riskcode," +
                                  "l.insuredname," +
                                  "l.FlowInTime," +
                                  "l.nodename from swflog l,(select s.registno, min(logno) logno " +
                                  "from swflog s where s.registno in (select distinct (registno)" +
                                  " from swflog where "+conditions+")" +
		        		           "and nodestatus!='4' " +
		        		           "and nodetype in ('check','certa','claim','certi')  group by s.registno) t " +
                                  "where l.registno = t.registno and l.logno = t.logno) h)";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 查询同一保单下未合并的报案列表
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findByPolicyNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select l.nodestatus,"+
                                  "l.registno,"+
                                  "l.policyno,"+
                                  "l.riskcode,"+
                                  "l.insuredname,"+
                                  "l.FlowInTime,"+
                                  "l.nodename from swflog l," +
                                  "(select s.registno, min(logno) logno from swflog s " +
                                  "where s.registno in (select o.registno from swflog o, prplregist g where " + conditions + ")" +
                                  "and not exists (select 1 from prplcombine k where k.registno = s.registno) "+//屏蔽已经绑定案件
                                  "and not exists (select 1 from swflog k where k.registno = s.registno and  nodetype='cance')  "+//屏蔽立案注销拒赔
                                  " and nodestatus != 4 "+
                                  " and  nodetype in ('check','certa','claim','certi')"+
                                  " group by s.registno order by s.registno) t " +
                                  "where l.registno=t.registno and l.logno=t.logno";
        
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfLogDto swfLogDto = null;
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

            swfLogDto = new SwfLogDto();
            swfLogDto.setNodeName(dbManager.getString(resultSet,7));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,6));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,4));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,3));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,5));
            collection.add(swfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }
    /**
     * 按报案号查找一条数据
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public SwfLogDto findByRegistNo(String registNo) throws Exception{
        String statement = "select l.nodestatus,"+
                                  "l.registno,"+
                                  "l.logno,"+
                                  "l.flowid,"+
                                  "l.policyno,"+
                                  "l.riskcode,"+
                                  "l.insuredname,"+
                                  "l.FlowInTime,"+
                                  "l.nodename,l.nodetype from swflog l," +
                                  "(select s.registno, min(logno) logno from swflog s " +
                                  "where s.registno ='"+registNo+ 
                                  "' and nodetype in ('check','certa','claim','certi') and nodestatus!='4' group by registno ) t " +
                                  "where l.registno=t.registno and l.logno=t.logno";
        
        logger.debug(statement);
        SwfLogDto swfLogDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        while(resultSet.next()){
            swfLogDto = new SwfLogDto();
            swfLogDto.setNodeType(dbManager.getString(resultSet,10));
            swfLogDto.setNodeName(dbManager.getString(resultSet,9));
            swfLogDto.setFlowInTime(dbManager.getString(resultSet,8));
            swfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            swfLogDto.setRiskCode(dbManager.getString(resultSet,6));
            swfLogDto.setPolicyNo(dbManager.getString(resultSet,5));
            swfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            swfLogDto.setInsuredName(dbManager.getString(resultSet,7));  
            swfLogDto.setLogNo(dbManager.getInt(resultSet,3));
            swfLogDto.setFlowID(dbManager.getString(resultSet,4));
            logger.info("DBSwfLogBase.findByConditions() success!");       
        }
            resultSet.close();
            return swfLogDto;
    }
    /**
     * 查询同一事故号下合并的报案列表
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findEditeByComBineNo(String ComBineNo,int pageNo,int rowsPerPage) throws Exception{
        String statement = " select h.nodestatus," +
                                   "h.registno," +
        		                   "p.combineno," +
        		                   "h.policyno," +
        		                   "h.riskcode," +
        		                   "h.insuredname," +
        		                   "h.FlowInTime," +
        		                   "h.nodename " +
        		           "from (select l.nodestatus,l.registno,l.policyno,l.riskcode,l.insuredname,l.FlowInTime,l.nodename " +
        		           "from swflog l,(select s.registno, min(logno) logno " +
        		           "from swflog s " +
        		           "where s.registno in (select distinct (registno) from swflog) " +
		        		           "and nodestatus!='4' " +
	                               " and  nodetype in ('check','certa','claim','certi') "+
		        		           " group by s.registno order by s.registno) t " +
        		           "where l.registno = t.registno and l.logno = t.logno) h,prplcombine p " +
        		           "where h.registno = p.registno and p."+ComBineNo+"";
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrplcombineSwfLogDto combineSwfLogDto = null;
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

            combineSwfLogDto = new PrplcombineSwfLogDto();
            combineSwfLogDto.setNodeName(dbManager.getString(resultSet,8));
            combineSwfLogDto.setFlowInTime(dbManager.getString(resultSet,7));
            combineSwfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            combineSwfLogDto.setRiskCode(dbManager.getString(resultSet,5));
            combineSwfLogDto.setPolicyNo(dbManager.getString(resultSet,4));
            combineSwfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            combineSwfLogDto.setInsuredName(dbManager.getString(resultSet,6));
            combineSwfLogDto.setCombineno(dbManager.getString(resultSet, 3));
            collection.add(combineSwfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }
    /**
     * 查询同一保单号下已合并的报案列表
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findEditeByPolicyNo(String PolicyNo,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select h.nodestatus," +
                           "h.registno," +
        		           "p.combineno," +
        		           "h.policyno," +
        		           "h.riskcode," +
        		           "h.insuredname," +
        		           "h.FlowInTime," +
        		           "h.nodename from (select l.nodestatus," +
        		                                   "l.registno," +
        		                                   "l.policyno," +
        		                                   "l.riskcode," +
        		                                   "l.insuredname," +
        		                                   "l.FlowInTime," +
        		                                   "l.nodename from swflog l,(select s.registno, min(logno) logno " +
        		                                   "from swflog s where s.registno in (select o.registno" +
        		                                   " from swflog o, prplregist g where "+PolicyNo+")" +
						        		           " and nodestatus!='4' " +
					                               " and  nodetype in ('check','certa','claim','certi') "+
						        		           " group by s.registno order by s.registno) t " +
        		                                   "where l.registno = t.registno and l.logno = t.logno) h, prplcombine p where p.registno = h.registno";
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrplcombineSwfLogDto combineSwfLogDto = null;
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

            combineSwfLogDto = new PrplcombineSwfLogDto();
            combineSwfLogDto.setNodeName(dbManager.getString(resultSet,8));
            combineSwfLogDto.setFlowInTime(dbManager.getString(resultSet,7));
            combineSwfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            combineSwfLogDto.setRiskCode(dbManager.getString(resultSet,5));
            combineSwfLogDto.setPolicyNo(dbManager.getString(resultSet,4));
            combineSwfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            combineSwfLogDto.setInsuredName(dbManager.getString(resultSet,6));
            combineSwfLogDto.setCombineno(dbManager.getString(resultSet, 3));
            collection.add(combineSwfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }
    /**
     * 查询报案号对应的合并案件
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findEditeByRegistNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select h.nodestatus," +
                           "h.registno," +
        		           "(select p.combineno from prplcombine p where p.registno = h.registno) as combineno," +      		           
        		           "h.policyno," +
        		           "h.riskcode," +
        		           "h.insuredname," +
        		           "h.FlowInTime," +
        		           "h.nodename from (select l.nodestatus," +
        		                                   "l.registno," +
        		                                   "l.policyno," +
        		                                   "l.riskcode," +
        		                                   "l.insuredname," +
        		                                   "l.FlowInTime," +
        		                                   "l.nodename from swflog l,(select s.registno, min(logno) logno " +
        		                                   "from swflog s where s.registno in (select distinct (registno)" +
        		                                   " from swflog where "+conditions+") " +
						        		           " and nodestatus!='4' " +
					                               " and  nodetype in ('check','certa','claim','certi') "+
						        		           " group by s.registno order by s.registno) t " +
        		                                   "where l.registno = t.registno and l.logno = t.logno) h";
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrplcombineSwfLogDto combineSwfLogDto = null;
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

            combineSwfLogDto = new PrplcombineSwfLogDto();
            combineSwfLogDto.setNodeName(dbManager.getString(resultSet,8));
            combineSwfLogDto.setFlowInTime(dbManager.getString(resultSet,7));
            combineSwfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            combineSwfLogDto.setRiskCode(dbManager.getString(resultSet,5));
            combineSwfLogDto.setPolicyNo(dbManager.getString(resultSet,4));
            combineSwfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            combineSwfLogDto.setInsuredName(dbManager.getString(resultSet,6));
            combineSwfLogDto.setCombineno(dbManager.getString(resultSet, 3));
            collection.add(combineSwfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }
    /**
     * 查询未处理理算信息列表
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findCompensateListByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{    	
        String statement = " select  n.flowid," +
							        "n.LogNo," + 
								    "n.ModelNo," + 
								    "n.NodeNo," + 
								    "n.NodeName," + 
								    "n.BusinessNo," + 
								    "n.HandleDept," + 
								    "n.HandlerCode," + 
								    "n.HandlerName," + 
								    "n.FlowInTime," + 
								    "n.TimeLimit," + 
								    "n.HandleTime," + 
								    "n.SubmitTime," + 
								    "n.NodeStatus," + 
								    "n.FlowStatus," + 
								    "n.PackageID," + 
								    "n.Flag," + 
								    "n.TaskNo," + 
								     "n.TaskType," + 
								     "n.NodeType," + 
								     "n.TitleStr," + 
								     "n.BusinessType," + 
								     "n.RiskCode," + 
								     "n.KeyIn," + 
								     "n.KeyOut," + 
								     "n.DeptName," + 
								     "n.MainFlowID," + 
								     "n.SubFlowID," + 
								     "n.PosX," + 
								     "n.PosY," + 
								     "n.EndFlag," + 
								     "n.BeforeHandlerCode," + 
						              "n.BeforeHandlerName," + 
						              "n.PolicyNo," + 
						              "n.TypeFlag," + 
						              "n.ComCode," + 
						              "n.ScheduleID," + 
						              "n.LossItemCode," + 
						              "n.LossItemName," + 
						              "n.InsureCarFlag," + 
						              "n.HandlerRange," + 
						              "n.ExigenceGree," + 
						              "n.RegistNo," +                    
						              "n.InsuredName," + 
						              "n.combineno," +
						              "m.claimno " +
        		                   "from prplclaim m," +
        		                   "(select p.combineno," +
        		                            "h.flowid," +
        		                            "h.LogNo," + 
                                            "h.ModelNo," + 
                                            "h.NodeNo," + 
                                            "h.NodeName," + 
                                            "h.BusinessNo," + 
                                            "h.HandleDept," + 
                                            "h.HandlerCode," + 
                                            "h.HandlerName," + 
                                            "h.FlowInTime," + 
                                            "h.TimeLimit," + 
                                            "h.HandleTime," + 
                                            "h.SubmitTime," + 
                                            "h.NodeStatus," + 
                                            "h.FlowStatus," + 
                                            "h.PackageID," + 
                                            "h.Flag," + 
                                            "h.TaskNo," + 
                                            "h.TaskType," + 
                                            "h.NodeType," + 
                                            "h.TitleStr," + 
                                            "h.BusinessType," + 
                                            "h.RiskCode," + 
                                            "h.KeyIn," + 
                                            "h.KeyOut," + 
                                            "h.DeptName," + 
                                            "h.MainFlowID," + 
                                            "h.SubFlowID," + 
                                            "h.PosX," + 
                                            "h.PosY," + 
                                            "h.EndFlag," + 
                                            "h.BeforeHandlerCode," + 
					                        "h.BeforeHandlerName," + 
					                        "h.PolicyNo," + 
					                        "h.TypeFlag," + 
					                        "h.ComCode," + 
					                        "h.ScheduleID," + 
					                        "h.LossItemCode," + 
					                        "h.LossItemName," + 
					                        "h.InsureCarFlag," + 
					                        "h.HandlerRange," + 
					                        "h.ExigenceGree," + 
					                        "h.RegistNo," +                    
					                        "h.InsuredName " +    
        		                           "from " +
        		                           "(select l.flowId," +
        		                                   "l.LogNo," + 
        		                                   "l.ModelNo," + 
        		                                   "l.NodeNo," + 
        		                                   "l.NodeName," + 
        		                                   "l.BusinessNo," + 
        		                                   "l.HandleDept," + 
        		                                   "l.HandlerCode," + 
        		                                   "l.HandlerName," + 
        		                                   "l.FlowInTime," + 
        		                                   "l.TimeLimit," + 
        		                                   "l.HandleTime," + 
        		                                   "l.SubmitTime," + 
        		                                   "l.NodeStatus," + 
        		                                   "l.FlowStatus," + 
        		                                   "l.PackageID," + 
        		                                   "l.Flag," + 
        		                                   "l.TaskNo," + 
        		                                   "l.TaskType," + 
        		                                   "l.NodeType," + 
        		                                   "l.TitleStr," + 
        		                                   "l.BusinessType," + 
        		                                   "l.RiskCode," + 
        		                                   "l.KeyIn," + 
        		                                   "l.KeyOut," + 
        		                                   "l.DeptName," + 
        		                                   "l.MainFlowID," + 
        		                                   "l.SubFlowID," + 
        		                                   "l.PosX," + 
        		                                   "l.PosY," + 
        		                                   "l.EndFlag," + 
        		                                   "l.BeforeHandlerCode," + 
        		                                   "l.BeforeHandlerName," + 
        		                                   "l.PolicyNo," + 
        		                                   "l.TypeFlag," + 
        		                                   "l.ComCode," + 
        		                                   "l.ScheduleID," + 
        		                                   "l.LossItemCode," + 
        		                                   "l.LossItemName," + 
        		                                   "l.InsureCarFlag," + 
        		                                   "l.HandlerRange," + 
        		                                   "l.ExigenceGree," + 
        		                                   "l.RegistNo," + 
        		                                   "l.InsuredName " +
        		                                   "from swflog l," +
        		                                   "(select s.registno, max(logno) logno from swflog s " +
        		                                   "where s.registno in (select distinct (registno) from swflog " +
        		                                   "where"+conditions+"";
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrplcombineSwfLogDto combineSwfLogDto = null;
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

            combineSwfLogDto = new PrplcombineSwfLogDto();
            combineSwfLogDto.setFlowID(dbManager.getString(resultSet,1));
            combineSwfLogDto.setLogNo(dbManager.getInt(resultSet,2));
            combineSwfLogDto.setModelNo(dbManager.getInt(resultSet,3));
            combineSwfLogDto.setNodeNo(dbManager.getInt(resultSet,4));
            combineSwfLogDto.setNodeName(dbManager.getString(resultSet,5));
            combineSwfLogDto.setBusinessNo(dbManager.getString(resultSet,6));
            combineSwfLogDto.setHandleDept(dbManager.getString(resultSet,7));
            combineSwfLogDto.setHandlerCode(dbManager.getString(resultSet,8));
            combineSwfLogDto.setHandlerName(dbManager.getString(resultSet,9));
            combineSwfLogDto.setFlowInTime(dbManager.getString(resultSet,10));
            combineSwfLogDto.setTimeLimit(dbManager.getInt(resultSet,11));
            combineSwfLogDto.setHandleTime(dbManager.getString(resultSet,12));
            combineSwfLogDto.setSubmitTime(dbManager.getString(resultSet,13));
            combineSwfLogDto.setNodeStatus(dbManager.getString(resultSet,14));
            combineSwfLogDto.setFlowStatus(dbManager.getString(resultSet,15));
            combineSwfLogDto.setPackageID(dbManager.getString(resultSet,16));
            combineSwfLogDto.setFlag(dbManager.getString(resultSet,17));
            combineSwfLogDto.setTaskNo(dbManager.getInt(resultSet,18));
            combineSwfLogDto.setTaskType(dbManager.getString(resultSet,19));
            combineSwfLogDto.setNodeType(dbManager.getString(resultSet,20));
            combineSwfLogDto.setTitleStr(dbManager.getString(resultSet,21));
            combineSwfLogDto.setBusinessType(dbManager.getString(resultSet,22));
            combineSwfLogDto.setRiskCode(dbManager.getString(resultSet,23));
            combineSwfLogDto.setKeyIn(dbManager.getString(resultSet,24));
            combineSwfLogDto.setKeyOut(dbManager.getString(resultSet,25));
            combineSwfLogDto.setDeptName(dbManager.getString(resultSet,26));
            combineSwfLogDto.setMainFlowID(dbManager.getString(resultSet,27));
            combineSwfLogDto.setSubFlowID(dbManager.getString(resultSet,28));
            combineSwfLogDto.setPosX(dbManager.getInt(resultSet,29));
            combineSwfLogDto.setPosY(dbManager.getInt(resultSet,30));
            combineSwfLogDto.setEndFlag(dbManager.getString(resultSet,31));
            combineSwfLogDto.setBeforeHandlerCode(dbManager.getString(resultSet,32));
            combineSwfLogDto.setBeforeHandlerName(dbManager.getString(resultSet,33));
            combineSwfLogDto.setPolicyNo(dbManager.getString(resultSet,34));
            combineSwfLogDto.setTypeFlag(dbManager.getString(resultSet,35));
            combineSwfLogDto.setComCode(dbManager.getString(resultSet,36));
            combineSwfLogDto.setScheduleID(dbManager.getInt(resultSet,37));
            combineSwfLogDto.setLossItemCode(dbManager.getString(resultSet,38));
            combineSwfLogDto.setLossItemName(dbManager.getString(resultSet,39));
            combineSwfLogDto.setInsureCarFlag(dbManager.getString(resultSet,40));
            combineSwfLogDto.setHandlerRange(dbManager.getString(resultSet,41));
            combineSwfLogDto.setExigenceGree(dbManager.getString(resultSet,42));
            combineSwfLogDto.setRegistNo(dbManager.getString(resultSet,43));
            combineSwfLogDto.setInsuredName(dbManager.getString(resultSet,44));
            combineSwfLogDto.setCombineno(dbManager.getString(resultSet,45));
            combineSwfLogDto.setClaimNo(dbManager.getString(resultSet,46));
            collection.add(combineSwfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getcompensateCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) from (select n.nodestatus," +
        "m.claimno," +
        "n.combineno," +
        "n.policyno," +
        "n.riskcode," +
        "n.insuredname," +
        "n.FlowInTime," +
        "n.nodename from prplclaim m," +
        "(select h.nodestatus," +
                "p.combineno," +
                "h.registno," +
                "h.policyno," +
                "h.riskcode," +
                "h.insuredname," +
                "h.FlowInTime," +
                "h.nodename from " +
                "(select l.nodestatus," +
                        "l.registno," +
                        "l.policyno," +
                        "l.riskcode," +
                        "l.insuredname," +
                        "l.FlowInTime," +
                        "l.nodename from swflog l," +
                        "(select s.registno, max(logno) logno from swflog s " +
                        "where s.registno in (select distinct (registno) from swflog " +
                        "where"+conditions+")";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 按保单号查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public int getComBineCountByConditions(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "select count(*) from (select h.nodestatus," +
                                   "h.registno," +
                                   "(select p.combineno from prplcombine p where p.registno = h.registno) as combineno," +      		           
                                   "h.policyno," +
                                   "h.riskcode," +
                                   "h.insuredname," +
                                   "h.FlowInTime," +
                                   "h.nodename from (select l.nodestatus," +
                                   "l.registno," +
                                   "l.policyno," +
                                   "l.riskcode," +
                                   "l.insuredname," +
                                   "l.FlowInTime," +
                                   "l.nodename from swflog l,(select s.registno, min(logno) logno " +
                                   "from swflog s where s.registno in (select distinct (o.registno)" +
                                   " from swflog o, prplregist g where "+conditions+") " +
		        		           "and nodestatus!='4' " +
		        		           "and nodetype in ('check','certa','claim','certi')  group by s.registno) t " +
                                   "where l.registno = t.registno and l.logno = t.logno) h)";
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        statement = SqlUtils.getWherePartForGetCount(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfLogBase.getCount() success!");
        return count;
    }
    /**
     * 查询同一保单号下已合并的报案列表
     * @param conditions conditions
     * @return 满足条件的记录数
     * @throws Exception
     * @author qianxiantao
     */
    public Collection findEditeByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "select h.nodestatus," +
                           "h.registno," +
        		           "p.combineno," +
        		           "h.policyno," +
        		           "h.riskcode," +
        		           "h.insuredname," +
        		           "h.FlowInTime," +
        		           "h.nodename from (select l.nodestatus," +
        		                                   "l.registno," +
        		                                   "l.policyno," +
        		                                   "l.riskcode," +
        		                                   "l.insuredname," +
        		                                   "l.FlowInTime," +
        		                                   "l.nodename from swflog l,(select s.registno, min(logno) logno " +
        		                                   "from swflog s where s.registno in (select distinct (o.registno)" +
        		                                   " from swflog o, prplregist g where "+conditions+")" +
						        		           " and nodestatus!='4' " +
					                               " and  nodetype in ('check','certa','claim','certi') "+
						        		           " group by s.registno order by s.registno) t " +
        		                                   "where l.registno = t.registno and l.logno = t.logno) h, prplcombine p where p.registno = h.registno";
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrplcombineSwfLogDto combineSwfLogDto = null;
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

            combineSwfLogDto = new PrplcombineSwfLogDto();
            combineSwfLogDto.setNodeName(dbManager.getString(resultSet,8));
            combineSwfLogDto.setFlowInTime(dbManager.getString(resultSet,7));
            combineSwfLogDto.setNodeStatus(dbManager.getString(resultSet,1));
            combineSwfLogDto.setRiskCode(dbManager.getString(resultSet,5));
            combineSwfLogDto.setPolicyNo(dbManager.getString(resultSet,4));
            combineSwfLogDto.setRegistNo(dbManager.getString(resultSet,2));
            combineSwfLogDto.setInsuredName(dbManager.getString(resultSet,6));
            combineSwfLogDto.setCombineno(dbManager.getString(resultSet, 3));
            collection.add(combineSwfLogDto);
        }
        resultSet.close();
        logger.info("DBSwfLogBase.findByConditions() success!");
        return collection;
    }
}
