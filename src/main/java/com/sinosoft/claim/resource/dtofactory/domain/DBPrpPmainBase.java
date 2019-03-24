package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPmainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppmain批改保单信息表的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:17.406<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPmainBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPmainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPmainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void insert(PrpPmainDto prpPmainDto) throws Exception{
        String mainStatement = " Insert Into PrpPmain (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " ProposalNo," +
                           " ContractNo," +
                           " PolicySort," +
                           " PrintNo," +
                           " BusinessNature," +
                           " Language," +
                           " PolicyType," +
                     	  	//modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           " PolicyBizType," +
                           //modified by zengzhu 2007-11-15 end
                           " AppliCode," +
                           " AppliName," +
                           " AppliAddress," +
                           " InsuredCode," +
                           " InsuredName," +
                           " InsuredAddress," +
                           " OperateDate," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " PureRate," +
                           " DisRate," +
                           " Discount," +
                           " Currency," +
                           " SumValue," +
                           " SumAmount," +
                           " SumDiscount," +
                           " SumPremium," +
                           " SumSubPrem," +
                           " SumQuantity," +
                           " JudicalScope," +
                           " AutoTransRenewFlag," +
                           " ArgueSolution," +
                           " ArbitBoardName," +
                           " PayTimes," +
                           " EndorseTimes," +
                           " ClaimTimes," +
                           " MakeCom," +
                           " OperateSite," +
                           " ComCode," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " UnderWriteEndDate," +
                           " StatisticsYM," +
                           " AgentCode," +
                           " CoinsFlag," +
                           " ReinsFlag," +
                           " AllinsFlag," +
                           " UnderWriteFlag," +
                           " OthFlag," +
                           " Flag," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " ChgSubPrem," +
                           " statquantity," +
                           " Chgstatquantity," +
                           " ChgQuantity)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPmainDto.getEndorseNo() + "'," +
                           "'" + prpPmainDto.getPolicyNo() + "'," +
                           "'" + prpPmainDto.getClassCode() + "'," +
                           "'" + prpPmainDto.getRiskCode() + "'," +
                           "'" + prpPmainDto.getProposalNo() + "'," +
                           "'" + prpPmainDto.getContractNo() + "'," +
                           "'" + prpPmainDto.getPolicySort() + "'," +
                           "'" + prpPmainDto.getPrintNo() + "'," +
                           "'" + prpPmainDto.getBusinessNature() + "'," +
                           "'" + prpPmainDto.getLanguage() + "'," +
                           "'" + prpPmainDto.getPolicyType() + "'," +
                           //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           "'" + prpPmainDto.getPolicyBizType() + "'," +
                           //modified by zengzhu 2007-11-15 end
                           "'" + prpPmainDto.getAppliCode() + "'," +
                           "'" + prpPmainDto.getAppliName() + "'," +
                           "'" + prpPmainDto.getAppliAddress() + "'," +
                           "'" + prpPmainDto.getInsuredCode() + "'," +
                           "'" + prpPmainDto.getInsuredName() + "'," +
                           "'" + prpPmainDto.getInsuredAddress() + "'," +
                           "'" + prpPmainDto.getOperateDate() + "'," +
                           "'" + prpPmainDto.getStartDate() + "'," +
                           "" + prpPmainDto.getStartHour() + "," +
                           "'" + prpPmainDto.getEndDate() + "'," +
                           "" + prpPmainDto.getEndHour() + "," +
                           "'" + prpPmainDto.getPureRate() + "'," +
                           "'" + prpPmainDto.getDisRate() + "'," +
                           "'" + prpPmainDto.getDiscount() + "'," +
                           "'" + prpPmainDto.getCurrency() + "'," +
                           "'" + prpPmainDto.getSumValue() + "'," +
                           "'" + prpPmainDto.getSumAmount() + "'," +
                           "'" + prpPmainDto.getSumDiscount() + "'," +
                           "'" + prpPmainDto.getSumPremium() + "'," +
                           "'" + prpPmainDto.getSumSubPrem() + "'," +
                           "" + prpPmainDto.getSumQuantity() + "," +
                           "'" + prpPmainDto.getJudicalScope() + "'," +
                           "'" + prpPmainDto.getAutoTransRenewFlag() + "'," +
                           "'" + prpPmainDto.getArgueSolution() + "'," +
                           "'" + prpPmainDto.getArbitBoardName() + "'," +
                           "" + prpPmainDto.getPayTimes() + "," +
                           "" + prpPmainDto.getEndorseTimes() + "," +
                           "" + prpPmainDto.getClaimTimes() + "," +
                           "'" + prpPmainDto.getMakeCom() + "'," +
                           "'" + prpPmainDto.getOperateSite() + "'," +
                           "'" + prpPmainDto.getComCode() + "'," +
                           "'" + prpPmainDto.getHandlerCode() + "'," +
                           "'" + prpPmainDto.getHandler1Code() + "'," +
                           "'" + prpPmainDto.getApproverCode() + "'," +
                           "'" + prpPmainDto.getUnderWriteCode() + "'," +
                           "'" + prpPmainDto.getUnderWriteName() + "'," +
                           "'" + prpPmainDto.getOperatorCode() + "'," +
                           "'" + prpPmainDto.getInputDate() + "'," +
                           "" + prpPmainDto.getInputHour() + "," +
                           "'" + prpPmainDto.getUnderWriteEndDate() + "'," +
                           "'" + prpPmainDto.getStatisticsYM() + "'," +
                           "'" + prpPmainDto.getAgentCode() + "'," +
                           "'" + prpPmainDto.getCoinsFlag() + "'," +
                           "'" + prpPmainDto.getReinsFlag() + "'," +
                           "'" + prpPmainDto.getAllinsFlag() + "'," +
                           "'" + prpPmainDto.getUnderWriteFlag() + "'," +
                           "'" + prpPmainDto.getOthFlag() + "'," +
                           "'" + prpPmainDto.getFlag() + "'," +
                           "'" + prpPmainDto.getChgAmount() + "'," +
                           "'" + prpPmainDto.getChgPremium() + "'," +
                           "'" + prpPmainDto.getChgSubPrem() + "'," +
                           "" + prpPmainDto.getChgQuantity() + ")";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        int index=1;
        dbManager.setString(index++,prpPmainDto.getEndorseNo());
        dbManager.setString(index++,prpPmainDto.getPolicyNo());
        dbManager.setString(index++,prpPmainDto.getClassCode());
        dbManager.setString(index++,prpPmainDto.getRiskCode());
        dbManager.setString(index++,prpPmainDto.getProposalNo());
        dbManager.setString(index++,prpPmainDto.getContractNo());
        dbManager.setString(index++,prpPmainDto.getPolicySort());
        dbManager.setString(index++,prpPmainDto.getPrintNo());
        dbManager.setString(index++,prpPmainDto.getBusinessNature());
        dbManager.setString(index++,prpPmainDto.getLanguage());
        dbManager.setString(index++,prpPmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        dbManager.setString(index++,prpPmainDto.getPolicyBizType());
  	  	//modified by zengzhu 2007-11-15 end
        dbManager.setString(index++,prpPmainDto.getAppliCode());
        dbManager.setString(index++,prpPmainDto.getAppliName());
        dbManager.setString(index++,prpPmainDto.getAppliAddress());
        dbManager.setString(index++,prpPmainDto.getInsuredCode());
        dbManager.setString(index++,prpPmainDto.getInsuredName());
        dbManager.setString(index++,prpPmainDto.getInsuredAddress());
        dbManager.setDateTime(index++,prpPmainDto.getOperateDate());
        dbManager.setDateTime(index++,prpPmainDto.getStartDate());
        dbManager.setInt(index++,prpPmainDto.getStartHour());
        dbManager.setDateTime(index++,prpPmainDto.getEndDate());
        dbManager.setInt(index++,prpPmainDto.getEndHour());
        dbManager.setDouble(index++,prpPmainDto.getPureRate());
        dbManager.setDouble(index++,prpPmainDto.getDisRate());
        dbManager.setDouble(index++,prpPmainDto.getDiscount());
        dbManager.setString(index++,prpPmainDto.getCurrency());
        dbManager.setDouble(index++,prpPmainDto.getSumValue());
        dbManager.setDouble(index++,prpPmainDto.getSumAmount());
        dbManager.setDouble(index++,prpPmainDto.getSumDiscount());
        dbManager.setDouble(index++,prpPmainDto.getSumPremium());
        dbManager.setDouble(index++,prpPmainDto.getSumSubPrem());
        dbManager.setInt(index++,prpPmainDto.getSumQuantity());
        dbManager.setString(index++,prpPmainDto.getJudicalScope());
        dbManager.setString(index++,prpPmainDto.getAutoTransRenewFlag());
        dbManager.setString(index++,prpPmainDto.getArgueSolution());
        dbManager.setString(index++,prpPmainDto.getArbitBoardName());
        dbManager.setInt(index++,prpPmainDto.getPayTimes());
        dbManager.setInt(index++,prpPmainDto.getEndorseTimes());
        dbManager.setInt(index++,prpPmainDto.getClaimTimes());
        dbManager.setString(index++,prpPmainDto.getMakeCom());
        dbManager.setString(index++,prpPmainDto.getOperateSite());
        dbManager.setString(index++,prpPmainDto.getComCode());
        dbManager.setString(index++,prpPmainDto.getHandlerCode());
        dbManager.setString(index++,prpPmainDto.getHandler1Code());
        dbManager.setString(index++,prpPmainDto.getApproverCode());
        dbManager.setString(index++,prpPmainDto.getUnderWriteCode());
        dbManager.setString(index++,prpPmainDto.getUnderWriteName());
        dbManager.setString(index++,prpPmainDto.getOperatorCode());
        dbManager.setDateTime(index++,prpPmainDto.getInputDate());
        dbManager.setInt(index++,prpPmainDto.getInputHour());
        dbManager.setDateTime(index++,prpPmainDto.getUnderWriteEndDate());
        dbManager.setDateTime(index++,prpPmainDto.getStatisticsYM());
        dbManager.setString(index++,prpPmainDto.getAgentCode());
        dbManager.setString(index++,prpPmainDto.getCoinsFlag());
        dbManager.setString(index++,prpPmainDto.getReinsFlag());
        dbManager.setString(index++,prpPmainDto.getAllinsFlag());
        dbManager.setString(index++,prpPmainDto.getUnderWriteFlag());
        dbManager.setString(index++,prpPmainDto.getOthFlag());
        dbManager.setString(index++,prpPmainDto.getFlag());
        dbManager.setDouble(index++,prpPmainDto.getChgAmount());
        dbManager.setDouble(index++,prpPmainDto.getChgPremium());
        dbManager.setDouble(index++,prpPmainDto.getChgSubPrem());
        dbManager.setDouble(index++,prpPmainDto.getStatQuantity());
        dbManager.setDouble(index++,prpPmainDto.getChgStatquantity());
        dbManager.setInt(index++,prpPmainDto.getChgQuantity());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPmainBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPmainDto prpPmainDto = (PrpPmainDto)i.next();
            insert(prpPmainDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        String statement = " Delete From PrpPmain" +
	            		   " Where " +
                           " EndorseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPmain Where " +
                           " EndorseNo = '" + endorseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPmainBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void update(PrpPmainDto prpPmainDto) throws Exception{
        String statement = " Update PrpPmain Set PolicyNo = ?," +
                           " ClassCode = ?," +
                           " RiskCode = ?," +
                           " ProposalNo = ?," +
                           " ContractNo = ?," +
                           " PolicySort = ?," +
                           " PrintNo = ?," +
                           " BusinessNature = ?," +
                           " Language = ?," +
                           " PolicyType = ?," +
                     	  	//modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           " PolicyBizType = ?," +
                           //modified by zengzhu 2007-11-15 end
                           " AppliCode = ?," +
                           " AppliName = ?," +
                           " AppliAddress = ?," +
                           " InsuredCode = ?," +
                           " InsuredName = ?," +
                           " InsuredAddress = ?," +
                           " OperateDate = ?," +
                           " StartDate = ?," +
                           " StartHour = ?," +
                           " EndDate = ?," +
                           " EndHour = ?," +
                           " PureRate = ?," +
                           " DisRate = ?," +
                           " Discount = ?," +
                           " Currency = ?," +
                           " SumValue = ?," +
                           " SumAmount = ?," +
                           " SumDiscount = ?," +
                           " SumPremium = ?," +
                           " SumSubPrem = ?," +
                           " SumQuantity = ?," +
                           " JudicalScope = ?," +
                           " AutoTransRenewFlag = ?," +
                           " ArgueSolution = ?," +
                           " ArbitBoardName = ?," +
                           " PayTimes = ?," +
                           " EndorseTimes = ?," +
                           " ClaimTimes = ?," +
                           " MakeCom = ?," +
                           " OperateSite = ?," +
                           " ComCode = ?," +
                           " HandlerCode = ?," +
                           " Handler1Code = ?," +
                           " ApproverCode = ?," +
                           " UnderWriteCode = ?," +
                           " UnderWriteName = ?," +
                           " OperatorCode = ?," +
                           " InputDate = ?," +
                           " InputHour = ?," +
                           " UnderWriteEndDate = ?," +
                           " StatisticsYM = ?," +
                           " AgentCode = ?," +
                           " CoinsFlag = ?," +
                           " ReinsFlag = ?," +
                           " AllinsFlag = ?," +
                           " UnderWriteFlag = ?," +
                           " OthFlag = ?," +
                           " Flag = ?," +
                           " ChgAmount = ?," +
                           " ChgPremium = ?," +
                           " ChgSubPrem = ?," +
                           " ChgQuantity = ?" +
	            		   " Where " +
                           " EndorseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPmain Set " +
                           " EndorseNo = '" + prpPmainDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPmainDto.getPolicyNo() + "'," +
                           " ClassCode = '" + prpPmainDto.getClassCode() + "'," +
                           " RiskCode = '" + prpPmainDto.getRiskCode() + "'," +
                           " ProposalNo = '" + prpPmainDto.getProposalNo() + "'," +
                           " ContractNo = '" + prpPmainDto.getContractNo() + "'," +
                           " PolicySort = '" + prpPmainDto.getPolicySort() + "'," +
                           " PrintNo = '" + prpPmainDto.getPrintNo() + "'," +
                           " BusinessNature = '" + prpPmainDto.getBusinessNature() + "'," +
                           " Language = '" + prpPmainDto.getLanguage() + "'," +
                           " PolicyType = '" + prpPmainDto.getPolicyType() + "'," +
                           //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           " PolicyBizType = '" + prpPmainDto.getPolicyBizType() + "'," +
                           //modified by zengzhu 2007-11-15 end
                           " AppliCode = '" + prpPmainDto.getAppliCode() + "'," +
                           " AppliName = '" + prpPmainDto.getAppliName() + "'," +
                           " AppliAddress = '" + prpPmainDto.getAppliAddress() + "'," +
                           " InsuredCode = '" + prpPmainDto.getInsuredCode() + "'," +
                           " InsuredName = '" + prpPmainDto.getInsuredName() + "'," +
                           " InsuredAddress = '" + prpPmainDto.getInsuredAddress() + "'," +
                           " OperateDate = '" + prpPmainDto.getOperateDate() + "'," +
                           " StartDate = '" + prpPmainDto.getStartDate() + "'," +
                           " StartHour = " + prpPmainDto.getStartHour() + "," +
                           " EndDate = '" + prpPmainDto.getEndDate() + "'," +
                           " EndHour = " + prpPmainDto.getEndHour() + "," +
                           " PureRate = '" + prpPmainDto.getPureRate() + "'," +
                           " DisRate = '" + prpPmainDto.getDisRate() + "'," +
                           " Discount = '" + prpPmainDto.getDiscount() + "'," +
                           " Currency = '" + prpPmainDto.getCurrency() + "'," +
                           " SumValue = '" + prpPmainDto.getSumValue() + "'," +
                           " SumAmount = '" + prpPmainDto.getSumAmount() + "'," +
                           " SumDiscount = '" + prpPmainDto.getSumDiscount() + "'," +
                           " SumPremium = '" + prpPmainDto.getSumPremium() + "'," +
                           " SumSubPrem = '" + prpPmainDto.getSumSubPrem() + "'," +
                           " SumQuantity = " + prpPmainDto.getSumQuantity() + "," +
                           " JudicalScope = '" + prpPmainDto.getJudicalScope() + "'," +
                           " AutoTransRenewFlag = '" + prpPmainDto.getAutoTransRenewFlag() + "'," +
                           " ArgueSolution = '" + prpPmainDto.getArgueSolution() + "'," +
                           " ArbitBoardName = '" + prpPmainDto.getArbitBoardName() + "'," +
                           " PayTimes = " + prpPmainDto.getPayTimes() + "," +
                           " EndorseTimes = " + prpPmainDto.getEndorseTimes() + "," +
                           " ClaimTimes = " + prpPmainDto.getClaimTimes() + "," +
                           " MakeCom = '" + prpPmainDto.getMakeCom() + "'," +
                           " OperateSite = '" + prpPmainDto.getOperateSite() + "'," +
                           " ComCode = '" + prpPmainDto.getComCode() + "'," +
                           " HandlerCode = '" + prpPmainDto.getHandlerCode() + "'," +
                           " Handler1Code = '" + prpPmainDto.getHandler1Code() + "'," +
                           " ApproverCode = '" + prpPmainDto.getApproverCode() + "'," +
                           " UnderWriteCode = '" + prpPmainDto.getUnderWriteCode() + "'," +
                           " UnderWriteName = '" + prpPmainDto.getUnderWriteName() + "'," +
                           " OperatorCode = '" + prpPmainDto.getOperatorCode() + "'," +
                           " InputDate = '" + prpPmainDto.getInputDate() + "'," +
                           " InputHour = " + prpPmainDto.getInputHour() + "," +
                           " UnderWriteEndDate = '" + prpPmainDto.getUnderWriteEndDate() + "'," +
                           " StatisticsYM = '" + prpPmainDto.getStatisticsYM() + "'," +
                           " AgentCode = '" + prpPmainDto.getAgentCode() + "'," +
                           " CoinsFlag = '" + prpPmainDto.getCoinsFlag() + "'," +
                           " ReinsFlag = '" + prpPmainDto.getReinsFlag() + "'," +
                           " AllinsFlag = '" + prpPmainDto.getAllinsFlag() + "'," +
                           " UnderWriteFlag = '" + prpPmainDto.getUnderWriteFlag() + "'," +
                           " OthFlag = '" + prpPmainDto.getOthFlag() + "'," +
                           " Flag = '" + prpPmainDto.getFlag() + "'," +
                           " ChgAmount = '" + prpPmainDto.getChgAmount() + "'," +
                           " ChgPremium = '" + prpPmainDto.getChgPremium() + "'," +
                           " ChgSubPrem = '" + prpPmainDto.getChgSubPrem() + "'," +
                           " ChgQuantity = " + prpPmainDto.getChgQuantity() + "" +
			               " Where " +
                           " EndorseNo = '" + prpPmainDto.getEndorseNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        int index=1;
        dbManager.setString(index++,prpPmainDto.getPolicyNo());
        dbManager.setString(index++,prpPmainDto.getClassCode());
        dbManager.setString(index++,prpPmainDto.getRiskCode());
        dbManager.setString(index++,prpPmainDto.getProposalNo());
        dbManager.setString(index++,prpPmainDto.getContractNo());
        dbManager.setString(index++,prpPmainDto.getPolicySort());
        dbManager.setString(index++,prpPmainDto.getPrintNo());
        dbManager.setString(index++,prpPmainDto.getBusinessNature());
        dbManager.setString(index++,prpPmainDto.getLanguage());
        dbManager.setString(index++,prpPmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        dbManager.setString(index++,prpPmainDto.getPolicyBizType());
        //modified by zengzhu 2007-11-15 end
        dbManager.setString(index++,prpPmainDto.getAppliCode());
        dbManager.setString(index++,prpPmainDto.getAppliName());
        dbManager.setString(index++,prpPmainDto.getAppliAddress());
        dbManager.setString(index++,prpPmainDto.getInsuredCode());
        dbManager.setString(index++,prpPmainDto.getInsuredName());
        dbManager.setString(index++,prpPmainDto.getInsuredAddress());
        dbManager.setDateTime(index++,prpPmainDto.getOperateDate());
        dbManager.setDateTime(index++,prpPmainDto.getStartDate());
        dbManager.setInt(index++,prpPmainDto.getStartHour());
        dbManager.setDateTime(index++,prpPmainDto.getEndDate());
        dbManager.setInt(index++,prpPmainDto.getEndHour());
        dbManager.setDouble(index++,prpPmainDto.getPureRate());
        dbManager.setDouble(index++,prpPmainDto.getDisRate());
        dbManager.setDouble(index++,prpPmainDto.getDiscount());
        dbManager.setString(index++,prpPmainDto.getCurrency());
        dbManager.setDouble(index++,prpPmainDto.getSumValue());
        dbManager.setDouble(index++,prpPmainDto.getSumAmount());
        dbManager.setDouble(index++,prpPmainDto.getSumDiscount());
        dbManager.setDouble(index++,prpPmainDto.getSumPremium());
        dbManager.setDouble(index++,prpPmainDto.getSumSubPrem());
        dbManager.setInt(index++,prpPmainDto.getSumQuantity());
        dbManager.setString(index++,prpPmainDto.getJudicalScope());
        dbManager.setString(index++,prpPmainDto.getAutoTransRenewFlag());
        dbManager.setString(index++,prpPmainDto.getArgueSolution());
        dbManager.setString(index++,prpPmainDto.getArbitBoardName());
        dbManager.setInt(index++,prpPmainDto.getPayTimes());
        dbManager.setInt(index++,prpPmainDto.getEndorseTimes());
        dbManager.setInt(index++,prpPmainDto.getClaimTimes());
        dbManager.setString(index++,prpPmainDto.getMakeCom());
        dbManager.setString(index++,prpPmainDto.getOperateSite());
        dbManager.setString(index++,prpPmainDto.getComCode());
        dbManager.setString(index++,prpPmainDto.getHandlerCode());
        dbManager.setString(index++,prpPmainDto.getHandler1Code());
        dbManager.setString(index++,prpPmainDto.getApproverCode());
        dbManager.setString(index++,prpPmainDto.getUnderWriteCode());
        dbManager.setString(index++,prpPmainDto.getUnderWriteName());
        dbManager.setString(index++,prpPmainDto.getOperatorCode());
        dbManager.setDateTime(index++,prpPmainDto.getInputDate());
        dbManager.setInt(index++,prpPmainDto.getInputHour());
        dbManager.setDateTime(index++,prpPmainDto.getUnderWriteEndDate());
        dbManager.setDateTime(index++,prpPmainDto.getStatisticsYM());
        dbManager.setString(index++,prpPmainDto.getAgentCode());
        dbManager.setString(index++,prpPmainDto.getCoinsFlag());
        dbManager.setString(index++,prpPmainDto.getReinsFlag());
        dbManager.setString(index++,prpPmainDto.getAllinsFlag());
        dbManager.setString(index++,prpPmainDto.getUnderWriteFlag());
        dbManager.setString(index++,prpPmainDto.getOthFlag());
        dbManager.setString(index++,prpPmainDto.getFlag());
        dbManager.setDouble(index++,prpPmainDto.getChgAmount());
        dbManager.setDouble(index++,prpPmainDto.getChgPremium());
        dbManager.setDouble(index++,prpPmainDto.getChgSubPrem());
        dbManager.setInt(index++,prpPmainDto.getChgQuantity());
        //设置条件字段;
        dbManager.setString(index++,prpPmainDto.getEndorseNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPmainBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @return PrpPmainDto
     * @throws Exception
     */
    public PrpPmainDto findByPrimaryKey(String endorseNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " ProposalNo," +
                           " ContractNo," +
                           " PolicySort," +
                           " PrintNo," +
                           " BusinessNature," +
                           " Language," +
                           " PolicyType," +
                           //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           " PolicyBizType," +
                      	  	//modified by zengzhu 2007-11-15 end
                           " AppliCode," +
                           " AppliName," +
                           " AppliAddress," +
                           " InsuredCode," +
                           " InsuredName," +
                           " InsuredAddress," +
                           " OperateDate," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " PureRate," +
                           " DisRate," +
                           " Discount," +
                           " Currency," +
                           " SumValue," +
                           " SumAmount," +
                           " SumDiscount," +
                           " SumPremium," +
                           " SumSubPrem," +
                           " SumQuantity," +
                           " JudicalScope," +
                           " AutoTransRenewFlag," +
                           " ArgueSolution," +
                           " ArbitBoardName," +
                           " PayTimes," +
                           " EndorseTimes," +
                           " ClaimTimes," +
                           " MakeCom," +
                           " OperateSite," +
                           " ComCode," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " UnderWriteEndDate," +
                           " StatisticsYM," +
                           " AgentCode," +
                           " CoinsFlag," +
                           " ReinsFlag," +
                           " AllinsFlag," +
                           " UnderWriteFlag," +
                           " OthFlag," +
                           " Flag," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " ChgSubPrem," +
                           " statquantity," +
                           " chgstatquantity," +
                           " ChgQuantity From PrpPmain";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ?";
        PrpPmainDto prpPmainDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPmainDto = new PrpPmainDto();
            int index=1;
            prpPmainDto.setEndorseNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicyNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setClassCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setRiskCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setProposalNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setContractNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicySort(dbManager.getString(resultSet,index++));
            prpPmainDto.setPrintNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setBusinessNature(dbManager.getString(resultSet,index++));
            prpPmainDto.setLanguage(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicyType(dbManager.getString(resultSet,index++));
      	  	//modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            prpPmainDto.setPolicyBizType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 end
            prpPmainDto.setAppliCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setAppliName(dbManager.getString(resultSet,index++));
            prpPmainDto.setAppliAddress(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredName(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredAddress(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStartHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setEndHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setPureRate(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setDisRate(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setDiscount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setCurrency(dbManager.getString(resultSet,index++));
            prpPmainDto.setSumValue(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumAmount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumDiscount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumPremium(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumSubPrem(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumQuantity(dbManager.getInt(resultSet,index++));
            prpPmainDto.setJudicalScope(dbManager.getString(resultSet,index++));
            prpPmainDto.setAutoTransRenewFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setArgueSolution(dbManager.getString(resultSet,index++));
            prpPmainDto.setArbitBoardName(dbManager.getString(resultSet,index++));
            prpPmainDto.setPayTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setEndorseTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setClaimTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setMakeCom(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperateSite(dbManager.getString(resultSet,index++));
            prpPmainDto.setComCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setHandler1Code(dbManager.getString(resultSet,index++));
            prpPmainDto.setApproverCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteName(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperatorCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setInputHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setAgentCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setCoinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setReinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setAllinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setOthFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setChgAmount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgPremium(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgSubPrem(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setStatQuantity(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgStatquantity(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgQuantity(dbManager.getInt(resultSet,index++));
        }
        resultSet.close();
        logger.info("DBPrpPmainBase.findByPrimaryKey() success!");
        return prpPmainDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " ClassCode," +
                           " RiskCode," +
                           " ProposalNo," +
                           " ContractNo," +
                           " PolicySort," +
                           " PrintNo," +
                           " BusinessNature," +
                           " Language," +
                           " PolicyType," +
                           //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
                           " PolicyBizType," +
                           //modified by zengzhu 2007-11-15 end
                           " AppliCode," +
                           " AppliName," +
                           " AppliAddress," +
                           " InsuredCode," +
                           " InsuredName," +
                           " InsuredAddress," +
                           " OperateDate," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " PureRate," +
                           " DisRate," +
                           " Discount," +
                           " Currency," +
                           " SumValue," +
                           " SumAmount," +
                           " SumDiscount," +
                           " SumPremium," +
                           " SumSubPrem," +
                           " SumQuantity," +
                           " JudicalScope," +
                           " AutoTransRenewFlag," +
                           " ArgueSolution," +
                           " ArbitBoardName," +
                           " PayTimes," +
                           " EndorseTimes," +
                           " ClaimTimes," +
                           " MakeCom," +
                           " OperateSite," +
                           " ComCode," +
                           " HandlerCode," +
                           " Handler1Code," +
                           " ApproverCode," +
                           " UnderWriteCode," +
                           " UnderWriteName," +
                           " OperatorCode," +
                           " InputDate," +
                           " InputHour," +
                           " UnderWriteEndDate," +
                           " StatisticsYM," +
                           " AgentCode," +
                           " CoinsFlag," +
                           " ReinsFlag," +
                           " AllinsFlag," +
                           " UnderWriteFlag," +
                           " OthFlag," +
                           " Flag," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " ChgSubPrem," +
                           " ChgQuantity From PrpPmain Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPmainDto prpPmainDto = null;
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

            prpPmainDto = new PrpPmainDto();
            int index=1;
            prpPmainDto.setEndorseNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicyNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setClassCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setRiskCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setProposalNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setContractNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicySort(dbManager.getString(resultSet,index++));
            prpPmainDto.setPrintNo(dbManager.getString(resultSet,index++));
            prpPmainDto.setBusinessNature(dbManager.getString(resultSet,index++));
            prpPmainDto.setLanguage(dbManager.getString(resultSet,index++));
            prpPmainDto.setPolicyType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            prpPmainDto.setPolicyBizType(dbManager.getString(resultSet,index++));
       	  	//modified by zengzhu 2007-11-15 end
            prpPmainDto.setAppliCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setAppliName(dbManager.getString(resultSet,index++));
            prpPmainDto.setAppliAddress(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredName(dbManager.getString(resultSet,index++));
            prpPmainDto.setInsuredAddress(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStartHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setEndHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setPureRate(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setDisRate(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setDiscount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setCurrency(dbManager.getString(resultSet,index++));
            prpPmainDto.setSumValue(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumAmount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumDiscount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumPremium(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumSubPrem(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setSumQuantity(dbManager.getInt(resultSet,index++));
            prpPmainDto.setJudicalScope(dbManager.getString(resultSet,index++));
            prpPmainDto.setAutoTransRenewFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setArgueSolution(dbManager.getString(resultSet,index++));
            prpPmainDto.setArbitBoardName(dbManager.getString(resultSet,index++));
            prpPmainDto.setPayTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setEndorseTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setClaimTimes(dbManager.getInt(resultSet,index++));
            prpPmainDto.setMakeCom(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperateSite(dbManager.getString(resultSet,index++));
            prpPmainDto.setComCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setHandler1Code(dbManager.getString(resultSet,index++));
            prpPmainDto.setApproverCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteName(dbManager.getString(resultSet,index++));
            prpPmainDto.setOperatorCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setInputHour(dbManager.getInt(resultSet,index++));
            prpPmainDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpPmainDto.setAgentCode(dbManager.getString(resultSet,index++));
            prpPmainDto.setCoinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setReinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setAllinsFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setUnderWriteFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setOthFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setFlag(dbManager.getString(resultSet,index++));
            prpPmainDto.setChgAmount(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgPremium(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgSubPrem(dbManager.getDouble(resultSet,index++));
            prpPmainDto.setChgQuantity(dbManager.getInt(resultSet,index++));
            collection.add(prpPmainDto);
        }
        resultSet.close();
        logger.info("DBPrpPmainBase.findByConditions() success!");
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
        String statement = "Delete From PrpPmain Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPmainBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPmain Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPmainBase.getCount() success!");
        return count;
    }
}
