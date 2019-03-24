package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLCMainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCMain-代赔保单主表的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:37.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLCMainBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLCMainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLCMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void insert(PrpLCMainDto prpLCMainDto) throws Exception{
        String mainStatement = " Insert Into PrpLCMain (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " BusinessNature," + 
                           " AppliName," + 
                           " AppliAddress," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " OperateDate," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " ArgueSolution," + 
                           " ArbitBoardName," + 
                           " PayTimes," + 
                           " EndorseTimes," + 
                           " RegistTimes," + 
                           " ClaimTimes," + 
                           " SumClaim," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " InputDate," + 
                           " InputHour," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLCMainDto.getClaimNo() + "'," + 
                           "'" + prpLCMainDto.getRegistNo() + "'," + 
                           "'" + prpLCMainDto.getPolicyNo() + "'," + 
                           "'" + prpLCMainDto.getClassCode() + "'," + 
                           "'" + prpLCMainDto.getRiskCode() + "'," + 
                           "'" + prpLCMainDto.getBusinessNature() + "'," + 
                           "'" + prpLCMainDto.getAppliName() + "'," + 
                           "'" + prpLCMainDto.getAppliAddress() + "'," + 
                           "'" + prpLCMainDto.getInsuredName() + "'," + 
                           "'" + prpLCMainDto.getInsuredAddress() + "'," + 
                           "'" + prpLCMainDto.getOperateDate() + "'," + 
                           "'" + prpLCMainDto.getStartDate() + "'," + 
                           "" + prpLCMainDto.getStartHour() + "," + 
                           "'" + prpLCMainDto.getEndDate() + "'," + 
                           "" + prpLCMainDto.getEndHour() + "," + 
                           "'" + prpLCMainDto.getCurrency() + "'," + 
                           "'" + prpLCMainDto.getSumAmount() + "'," + 
                           "'" + prpLCMainDto.getSumPremium() + "'," + 
                           "'" + prpLCMainDto.getArgueSolution() + "'," + 
                           "'" + prpLCMainDto.getArbitBoardName() + "'," + 
                           "" + prpLCMainDto.getPayTimes() + "," + 
                           "" + prpLCMainDto.getEndorseTimes() + "," + 
                           "" + prpLCMainDto.getRegistTimes() + "," + 
                           "" + prpLCMainDto.getClaimTimes() + "," + 
                           "'" + prpLCMainDto.getSumClaim() + "'," + 
                           "'" + prpLCMainDto.getMakeCom() + "'," + 
                           "'" + prpLCMainDto.getComCode() + "'," + 
                           "'" + prpLCMainDto.getHandlerCode() + "'," + 
                           "'" + prpLCMainDto.getHandler1Code() + "'," + 
                           "'" + prpLCMainDto.getInputDate() + "'," + 
                           "" + prpLCMainDto.getInputHour() + "," + 
                           "'" + prpLCMainDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLCMainDto.getClaimNo());
        dbManager.setString(2,prpLCMainDto.getRegistNo());
        dbManager.setString(3,prpLCMainDto.getPolicyNo());
        dbManager.setString(4,prpLCMainDto.getClassCode());
        dbManager.setString(5,prpLCMainDto.getRiskCode());
        dbManager.setString(6,prpLCMainDto.getBusinessNature());
        dbManager.setString(7,prpLCMainDto.getAppliName());
        dbManager.setString(8,prpLCMainDto.getAppliAddress());
        dbManager.setString(9,prpLCMainDto.getInsuredName());
        dbManager.setString(10,prpLCMainDto.getInsuredAddress());
        dbManager.setDateTime(11,prpLCMainDto.getOperateDate());
        dbManager.setDateTime(12,prpLCMainDto.getStartDate());
        dbManager.setInt(13,prpLCMainDto.getStartHour());
        dbManager.setDateTime(14,prpLCMainDto.getEndDate());
        dbManager.setInt(15,prpLCMainDto.getEndHour());
        dbManager.setString(16,prpLCMainDto.getCurrency());
        dbManager.setDouble(17,prpLCMainDto.getSumAmount());
        dbManager.setDouble(18,prpLCMainDto.getSumPremium());
        dbManager.setString(19,prpLCMainDto.getArgueSolution());
        dbManager.setString(20,prpLCMainDto.getArbitBoardName());
        dbManager.setInt(21,prpLCMainDto.getPayTimes());
        dbManager.setInt(22,prpLCMainDto.getEndorseTimes());
        dbManager.setInt(23,prpLCMainDto.getRegistTimes());
        dbManager.setInt(24,prpLCMainDto.getClaimTimes());
        dbManager.setDouble(25,prpLCMainDto.getSumClaim());
        dbManager.setString(26,prpLCMainDto.getMakeCom());
        dbManager.setString(27,prpLCMainDto.getComCode());
        dbManager.setString(28,prpLCMainDto.getHandlerCode());
        dbManager.setString(29,prpLCMainDto.getHandler1Code());
        dbManager.setDateTime(30,prpLCMainDto.getInputDate());
        dbManager.setInt(31,prpLCMainDto.getInputHour());
        dbManager.setString(32,prpLCMainDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCMainBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLCMain (" + 
                           " ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " BusinessNature," + 
                           " AppliName," + 
                           " AppliAddress," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " OperateDate," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " ArgueSolution," + 
                           " ArbitBoardName," + 
                           " PayTimes," + 
                           " EndorseTimes," + 
                           " RegistTimes," + 
                           " ClaimTimes," + 
                           " SumClaim," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " InputDate," + 
                           " InputHour," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLCMainDto prpLCMainDto = (PrpLCMainDto)i.next();
            dbManager.setString(1,prpLCMainDto.getClaimNo());
            dbManager.setString(2,prpLCMainDto.getRegistNo());
            dbManager.setString(3,prpLCMainDto.getPolicyNo());
            dbManager.setString(4,prpLCMainDto.getClassCode());
            dbManager.setString(5,prpLCMainDto.getRiskCode());
            dbManager.setString(6,prpLCMainDto.getBusinessNature());
            dbManager.setString(7,prpLCMainDto.getAppliName());
            dbManager.setString(8,prpLCMainDto.getAppliAddress());
            dbManager.setString(9,prpLCMainDto.getInsuredName());
            dbManager.setString(10,prpLCMainDto.getInsuredAddress());
            dbManager.setDateTime(11,prpLCMainDto.getOperateDate());
            dbManager.setDateTime(12,prpLCMainDto.getStartDate());
            dbManager.setInt(13,prpLCMainDto.getStartHour());
            dbManager.setDateTime(14,prpLCMainDto.getEndDate());
            dbManager.setInt(15,prpLCMainDto.getEndHour());
            dbManager.setString(16,prpLCMainDto.getCurrency());
            dbManager.setDouble(17,prpLCMainDto.getSumAmount());
            dbManager.setDouble(18,prpLCMainDto.getSumPremium());
            dbManager.setString(19,prpLCMainDto.getArgueSolution());
            dbManager.setString(20,prpLCMainDto.getArbitBoardName());
            dbManager.setInt(21,prpLCMainDto.getPayTimes());
            dbManager.setInt(22,prpLCMainDto.getEndorseTimes());
            dbManager.setInt(23,prpLCMainDto.getRegistTimes());
            dbManager.setInt(24,prpLCMainDto.getClaimTimes());
            dbManager.setDouble(25,prpLCMainDto.getSumClaim());
            dbManager.setString(26,prpLCMainDto.getMakeCom());
            dbManager.setString(27,prpLCMainDto.getComCode());
            dbManager.setString(28,prpLCMainDto.getHandlerCode());
            dbManager.setString(29,prpLCMainDto.getHandler1Code());
            dbManager.setDateTime(30,prpLCMainDto.getInputDate());
            dbManager.setInt(31,prpLCMainDto.getInputHour());
            dbManager.setString(32,prpLCMainDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLCMainBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(String registNo,String policyNo) throws Exception{
        String statement = " Delete From PrpLCMain" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLCMain Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLCMainBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLCMainDto prpLCMainDto
     * @throws Exception
     */
    public void update(PrpLCMainDto prpLCMainDto) throws Exception{
        String statement = " Update PrpLCMain Set ClaimNo = ?," + 
                           " ClassCode = ?," + 
                           " RiskCode = ?," + 
                           " BusinessNature = ?," + 
                           " AppliName = ?," + 
                           " AppliAddress = ?," + 
                           " InsuredName = ?," + 
                           " InsuredAddress = ?," + 
                           " OperateDate = ?," + 
                           " StartDate = ?," + 
                           " StartHour = ?," + 
                           " EndDate = ?," + 
                           " EndHour = ?," + 
                           " Currency = ?," + 
                           " SumAmount = ?," + 
                           " SumPremium = ?," + 
                           " ArgueSolution = ?," + 
                           " ArbitBoardName = ?," + 
                           " PayTimes = ?," + 
                           " EndorseTimes = ?," + 
                           " RegistTimes = ?," + 
                           " ClaimTimes = ?," + 
                           " SumClaim = ?," + 
                           " MakeCom = ?," + 
                           " ComCode = ?," + 
                           " HandlerCode = ?," + 
                           " Handler1Code = ?," + 
                           " InputDate = ?," + 
                           " InputHour = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLCMain Set " + 
                           " ClaimNo = '" + prpLCMainDto.getClaimNo() + "'," + 
                           " RegistNo = '" + prpLCMainDto.getRegistNo() + "'," + 
                           " PolicyNo = '" + prpLCMainDto.getPolicyNo() + "'," + 
                           " ClassCode = '" + prpLCMainDto.getClassCode() + "'," + 
                           " RiskCode = '" + prpLCMainDto.getRiskCode() + "'," + 
                           " BusinessNature = '" + prpLCMainDto.getBusinessNature() + "'," + 
                           " AppliName = '" + prpLCMainDto.getAppliName() + "'," + 
                           " AppliAddress = '" + prpLCMainDto.getAppliAddress() + "'," + 
                           " InsuredName = '" + prpLCMainDto.getInsuredName() + "'," + 
                           " InsuredAddress = '" + prpLCMainDto.getInsuredAddress() + "'," + 
                           " OperateDate = '" + prpLCMainDto.getOperateDate() + "'," + 
                           " StartDate = '" + prpLCMainDto.getStartDate() + "'," + 
                           " StartHour = " + prpLCMainDto.getStartHour() + "," + 
                           " EndDate = '" + prpLCMainDto.getEndDate() + "'," + 
                           " EndHour = " + prpLCMainDto.getEndHour() + "," + 
                           " Currency = '" + prpLCMainDto.getCurrency() + "'," + 
                           " SumAmount = '" + prpLCMainDto.getSumAmount() + "'," + 
                           " SumPremium = '" + prpLCMainDto.getSumPremium() + "'," + 
                           " ArgueSolution = '" + prpLCMainDto.getArgueSolution() + "'," + 
                           " ArbitBoardName = '" + prpLCMainDto.getArbitBoardName() + "'," + 
                           " PayTimes = " + prpLCMainDto.getPayTimes() + "," + 
                           " EndorseTimes = " + prpLCMainDto.getEndorseTimes() + "," + 
                           " RegistTimes = " + prpLCMainDto.getRegistTimes() + "," + 
                           " ClaimTimes = " + prpLCMainDto.getClaimTimes() + "," + 
                           " SumClaim = '" + prpLCMainDto.getSumClaim() + "'," + 
                           " MakeCom = '" + prpLCMainDto.getMakeCom() + "'," + 
                           " ComCode = '" + prpLCMainDto.getComCode() + "'," + 
                           " HandlerCode = '" + prpLCMainDto.getHandlerCode() + "'," + 
                           " Handler1Code = '" + prpLCMainDto.getHandler1Code() + "'," + 
                           " InputDate = '" + prpLCMainDto.getInputDate() + "'," + 
                           " InputHour = " + prpLCMainDto.getInputHour() + "," + 
                           " Flag = '" + prpLCMainDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLCMainDto.getRegistNo() + "' And " + 
                           " PolicyNo = '" + prpLCMainDto.getPolicyNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLCMainDto.getClaimNo());
        dbManager.setString(2,prpLCMainDto.getClassCode());
        dbManager.setString(3,prpLCMainDto.getRiskCode());
        dbManager.setString(4,prpLCMainDto.getBusinessNature());
        dbManager.setString(5,prpLCMainDto.getAppliName());
        dbManager.setString(6,prpLCMainDto.getAppliAddress());
        dbManager.setString(7,prpLCMainDto.getInsuredName());
        dbManager.setString(8,prpLCMainDto.getInsuredAddress());
        dbManager.setDateTime(9,prpLCMainDto.getOperateDate());
        dbManager.setDateTime(10,prpLCMainDto.getStartDate());
        dbManager.setInt(11,prpLCMainDto.getStartHour());
        dbManager.setDateTime(12,prpLCMainDto.getEndDate());
        dbManager.setInt(13,prpLCMainDto.getEndHour());
        dbManager.setString(14,prpLCMainDto.getCurrency());
        dbManager.setDouble(15,prpLCMainDto.getSumAmount());
        dbManager.setDouble(16,prpLCMainDto.getSumPremium());
        dbManager.setString(17,prpLCMainDto.getArgueSolution());
        dbManager.setString(18,prpLCMainDto.getArbitBoardName());
        dbManager.setInt(19,prpLCMainDto.getPayTimes());
        dbManager.setInt(20,prpLCMainDto.getEndorseTimes());
        dbManager.setInt(21,prpLCMainDto.getRegistTimes());
        dbManager.setInt(22,prpLCMainDto.getClaimTimes());
        dbManager.setDouble(23,prpLCMainDto.getSumClaim());
        dbManager.setString(24,prpLCMainDto.getMakeCom());
        dbManager.setString(25,prpLCMainDto.getComCode());
        dbManager.setString(26,prpLCMainDto.getHandlerCode());
        dbManager.setString(27,prpLCMainDto.getHandler1Code());
        dbManager.setDateTime(28,prpLCMainDto.getInputDate());
        dbManager.setInt(29,prpLCMainDto.getInputHour());
        dbManager.setString(30,prpLCMainDto.getFlag());
        //设置条件字段;
        dbManager.setString(31,prpLCMainDto.getRegistNo());
        dbManager.setString(32,prpLCMainDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLCMainBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号
     * @param policyNo 保单号码
     * @return PrpLCMainDto
     * @throws Exception
     */
    public PrpLCMainDto findByPrimaryKey(String registNo,String policyNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RegistNo," + 
                           " PolicyNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " BusinessNature," + 
                           " AppliName," + 
                           " AppliAddress," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " OperateDate," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " ArgueSolution," + 
                           " ArbitBoardName," + 
                           " PayTimes," + 
                           " EndorseTimes," + 
                           " RegistTimes," + 
                           " ClaimTimes," + 
                           " SumClaim," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " InputDate," + 
                           " InputHour," + 
                           " Flag From PrpLCMain";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " PolicyNo = ?";
        PrpLCMainDto prpLCMainDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " PolicyNo = '" + policyNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLCMainDto = new PrpLCMainDto();
            prpLCMainDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCMainDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCMainDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCMainDto.setClassCode(dbManager.getString(resultSet,4));
            prpLCMainDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLCMainDto.setBusinessNature(dbManager.getString(resultSet,6));
            prpLCMainDto.setAppliName(dbManager.getString(resultSet,7));
            prpLCMainDto.setAppliAddress(dbManager.getString(resultSet,8));
            prpLCMainDto.setInsuredName(dbManager.getString(resultSet,9));
            prpLCMainDto.setInsuredAddress(dbManager.getString(resultSet,10));
            prpLCMainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLCMainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpLCMainDto.setStartHour(dbManager.getInt(resultSet,13));
            prpLCMainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLCMainDto.setEndHour(dbManager.getInt(resultSet,15));
            prpLCMainDto.setCurrency(dbManager.getString(resultSet,16));
            prpLCMainDto.setSumAmount(dbManager.getDouble(resultSet,17));
            prpLCMainDto.setSumPremium(dbManager.getDouble(resultSet,18));
            prpLCMainDto.setArgueSolution(dbManager.getString(resultSet,19));
            prpLCMainDto.setArbitBoardName(dbManager.getString(resultSet,20));
            prpLCMainDto.setPayTimes(dbManager.getInt(resultSet,21));
            prpLCMainDto.setEndorseTimes(dbManager.getInt(resultSet,22));
            prpLCMainDto.setRegistTimes(dbManager.getInt(resultSet,23));
            prpLCMainDto.setClaimTimes(dbManager.getInt(resultSet,24));
            prpLCMainDto.setSumClaim(dbManager.getDouble(resultSet,25));
            prpLCMainDto.setMakeCom(dbManager.getString(resultSet,26));
            prpLCMainDto.setComCode(dbManager.getString(resultSet,27));
            prpLCMainDto.setHandlerCode(dbManager.getString(resultSet,28));
            prpLCMainDto.setHandler1Code(dbManager.getString(resultSet,29));
            prpLCMainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            prpLCMainDto.setInputHour(dbManager.getInt(resultSet,31));
            prpLCMainDto.setFlag(dbManager.getString(resultSet,32));
            logger.info("DBPrpLCMainBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLCMainBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLCMainDto;
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
                           " RegistNo," + 
                           " PolicyNo," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " BusinessNature," + 
                           " AppliName," + 
                           " AppliAddress," + 
                           " InsuredName," + 
                           " InsuredAddress," + 
                           " OperateDate," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " ArgueSolution," + 
                           " ArbitBoardName," + 
                           " PayTimes," + 
                           " EndorseTimes," + 
                           " RegistTimes," + 
                           " ClaimTimes," + 
                           " SumClaim," + 
                           " MakeCom," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " Handler1Code," + 
                           " InputDate," + 
                           " InputHour," + 
                           " Flag From PrpLCMain Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLCMainDto prpLCMainDto = null;
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

            prpLCMainDto = new PrpLCMainDto();
            prpLCMainDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLCMainDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLCMainDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLCMainDto.setClassCode(dbManager.getString(resultSet,4));
            prpLCMainDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLCMainDto.setBusinessNature(dbManager.getString(resultSet,6));
            prpLCMainDto.setAppliName(dbManager.getString(resultSet,7));
            prpLCMainDto.setAppliAddress(dbManager.getString(resultSet,8));
            prpLCMainDto.setInsuredName(dbManager.getString(resultSet,9));
            prpLCMainDto.setInsuredAddress(dbManager.getString(resultSet,10));
            prpLCMainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLCMainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpLCMainDto.setStartHour(dbManager.getInt(resultSet,13));
            prpLCMainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpLCMainDto.setEndHour(dbManager.getInt(resultSet,15));
            prpLCMainDto.setCurrency(dbManager.getString(resultSet,16));
            prpLCMainDto.setSumAmount(dbManager.getDouble(resultSet,17));
            prpLCMainDto.setSumPremium(dbManager.getDouble(resultSet,18));
            prpLCMainDto.setArgueSolution(dbManager.getString(resultSet,19));
            prpLCMainDto.setArbitBoardName(dbManager.getString(resultSet,20));
            prpLCMainDto.setPayTimes(dbManager.getInt(resultSet,21));
            prpLCMainDto.setEndorseTimes(dbManager.getInt(resultSet,22));
            prpLCMainDto.setRegistTimes(dbManager.getInt(resultSet,23));
            prpLCMainDto.setClaimTimes(dbManager.getInt(resultSet,24));
            prpLCMainDto.setSumClaim(dbManager.getDouble(resultSet,25));
            prpLCMainDto.setMakeCom(dbManager.getString(resultSet,26));
            prpLCMainDto.setComCode(dbManager.getString(resultSet,27));
            prpLCMainDto.setHandlerCode(dbManager.getString(resultSet,28));
            prpLCMainDto.setHandler1Code(dbManager.getString(resultSet,29));
            prpLCMainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,30));
            prpLCMainDto.setInputHour(dbManager.getInt(resultSet,31));
            prpLCMainDto.setFlag(dbManager.getString(resultSet,32));
            collection.add(prpLCMainDto);
        }
        resultSet.close();
        logger.info("DBPrpLCMainBase.findByConditions() success!");
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
        String statement = "Delete From PrpLCMain Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLCMainBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLCMain Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLCMainBase.getCount() success!");
        return count;
    }
}
