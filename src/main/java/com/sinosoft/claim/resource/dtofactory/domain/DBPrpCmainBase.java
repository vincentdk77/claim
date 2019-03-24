package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.ChgData;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPCMAIN-保单基本信息表的数据访问对象基类<br>
 * 创建于 2005-07-07 18:42:57.062<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCmainBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpCmainBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void insert(PrpCmainDto prpCmainDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCmain (");
        buffer.append("PolicyNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ProposalNo,");
        buffer.append("ContractNo,");
        buffer.append("PolicySort,");
        buffer.append("PrintNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        buffer.append("PolicyBizType,");
        //modified by zengzhu 2007-11-15 end
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("AppliAddress,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("OperateDate,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("PureRate,");
        buffer.append("DisRate,");
        buffer.append("Discount,");
        buffer.append("Currency,");
        buffer.append("SumValue,");
        buffer.append("SumAmount,");
        buffer.append("SumDiscount,");
        buffer.append("SumPremium,");
        buffer.append("SumSubPrem,");
        buffer.append("SumQuantity,");
        buffer.append("JudicalCode,");
        buffer.append("JudicalScope,");
        buffer.append("AutoTransRenewFlag,");
        buffer.append("ArgueSolution,");
        buffer.append("ArbitBoardName,");
        buffer.append("PayTimes,");
        buffer.append("EndorseTimes,");
        buffer.append("ClaimTimes,");
        buffer.append("MakeCom,");
        buffer.append("OperateSite,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("StatisticsYM,");
        buffer.append("AgentCode,");
        buffer.append("CoinsFlag,");
        buffer.append("ReinsFlag,");
        buffer.append("AllinsFlag,");
        buffer.append("UnderWriteFlag,");
        buffer.append("OthFlag,");
        buffer.append("Flag,");
        buffer.append("DisRate1,");
        buffer.append("BusinessFlag,");
        buffer.append("PayMode,");
        buffer.append("UpdaterCode,");
        buffer.append("UpdateDate,");
        buffer.append("UpdateHour,");
        buffer.append("SignDate,");
        buffer.append("ShareHolderFlag,");
        buffer.append("AgreementNo,");
        buffer.append("businesstype,");
        buffer.append("businesstype1,");
        buffer.append("InquiryNo,");
        buffer.append("ArticleType, ");
        buffer.append("BigMedicalType, ");
        buffer.append("RichFlyAreasCode, ");
        buffer.append("RichFlyAreasCName, ");
        buffer.append("RichFlyCode, ");
        buffer.append("RichFlyCName ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCmainDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getClassCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getProposalNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getContractNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getPolicySort()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getPrintNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getBusinessNature()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getLanguage()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getPolicyType()).append("',");
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            debugBuffer.append("'").append(prpCmainDto.getPolicyBizType()).append("',");
            //modified by zengzhu 2007-11-15 end
            debugBuffer.append("'").append(prpCmainDto.getAppliCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAppliName()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAppliAddress()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getInsuredCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getInsuredName()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getInsuredAddress()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getOperateDate()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getStartDate()).append("',");
            debugBuffer.append("").append(prpCmainDto.getStartHour()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getEndDate()).append("',");
            debugBuffer.append("").append(prpCmainDto.getEndHour()).append(",");
            debugBuffer.append("").append(prpCmainDto.getPureRate()).append(",");
            debugBuffer.append("").append(prpCmainDto.getDisRate()).append(",");
            debugBuffer.append("").append(prpCmainDto.getDiscount()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpCmainDto.getSumValue()).append(",");
            debugBuffer.append("").append(prpCmainDto.getSumAmount()).append(",");
            debugBuffer.append("").append(prpCmainDto.getSumDiscount()).append(",");
            debugBuffer.append("").append(prpCmainDto.getSumPremium()).append(",");
            debugBuffer.append("").append(prpCmainDto.getSumSubPrem()).append(",");
            debugBuffer.append("").append(prpCmainDto.getSumQuantity()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getJudicalCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getJudicalScope()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAutoTransRenewFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getArgueSolution()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getArbitBoardName()).append("',");
            debugBuffer.append("").append(prpCmainDto.getPayTimes()).append(",");
            debugBuffer.append("").append(prpCmainDto.getEndorseTimes()).append(",");
            debugBuffer.append("").append(prpCmainDto.getClaimTimes()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getMakeCom()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getOperateSite()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getHandlerCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getHandler1Code()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getApproverCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUnderWriteCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUnderWriteName()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getInputDate()).append("',");
            debugBuffer.append("").append(prpCmainDto.getInputHour()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getUnderWriteEndDate()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getStatisticsYM()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAgentCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getCoinsFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getReinsFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAllinsFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUnderWriteFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getOthFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getFlag()).append("',");
            debugBuffer.append("").append(prpCmainDto.getDisRate1()).append(",");
            debugBuffer.append("'").append(prpCmainDto.getBusinessFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getPayMode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUpdaterCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUpdateDate()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getUpdateHour()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getSignDate()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getShareHolderFlag()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getAgreementNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getBusinessType()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getBusinessType1()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getInquiryNo()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getArticleType()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getBigMedicalType()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getRichFlyAreasCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getRichFlyAreasCName()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getRichFlyCode()).append("',");
            debugBuffer.append("'").append(prpCmainDto.getRichFlyCName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        int index = 1;
        dbManager.setString(index++,prpCmainDto.getPolicyNo());
        dbManager.setString(index++,prpCmainDto.getClassCode());
        dbManager.setString(index++,prpCmainDto.getRiskCode());
        dbManager.setString(index++,prpCmainDto.getProposalNo());
        dbManager.setString(index++,prpCmainDto.getContractNo());
        dbManager.setString(index++,prpCmainDto.getPolicySort());
        dbManager.setString(index++,prpCmainDto.getPrintNo());
        dbManager.setString(index++,prpCmainDto.getBusinessNature());
        dbManager.setString(index++,prpCmainDto.getLanguage());
        dbManager.setString(index++,prpCmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        dbManager.setString(index++,prpCmainDto.getPolicyBizType());
        //modified by zengzhu 2007-11-15 end
        dbManager.setString(index++,prpCmainDto.getAppliCode());
        dbManager.setString(index++,prpCmainDto.getAppliName());
        dbManager.setString(index++,prpCmainDto.getAppliAddress());
        dbManager.setString(index++,prpCmainDto.getInsuredCode());
        dbManager.setString(index++,prpCmainDto.getInsuredName());
        dbManager.setString(index++,prpCmainDto.getInsuredAddress());
        dbManager.setDateTime(index++,prpCmainDto.getOperateDate());
        dbManager.setDateTime(index++,prpCmainDto.getStartDate());
        dbManager.setInt(index++,prpCmainDto.getStartHour());
        dbManager.setDateTime(index++,prpCmainDto.getEndDate());
        dbManager.setInt(index++,prpCmainDto.getEndHour());
        dbManager.setDouble(index++,prpCmainDto.getPureRate());
        dbManager.setDouble(index++,prpCmainDto.getDisRate());
        dbManager.setDouble(index++,prpCmainDto.getDiscount());
        dbManager.setString(index++,prpCmainDto.getCurrency());
        dbManager.setDouble(index++,prpCmainDto.getSumValue());
        dbManager.setDouble(index++,prpCmainDto.getSumAmount());
        dbManager.setDouble(index++,prpCmainDto.getSumDiscount());
        dbManager.setDouble(index++,prpCmainDto.getSumPremium());
        dbManager.setDouble(index++,prpCmainDto.getSumSubPrem());
        dbManager.setInt(index++,prpCmainDto.getSumQuantity());
        dbManager.setString(index++,prpCmainDto.getJudicalCode());
        dbManager.setString(index++,prpCmainDto.getJudicalScope());
        dbManager.setString(index++,prpCmainDto.getAutoTransRenewFlag());
        dbManager.setString(index++,prpCmainDto.getArgueSolution());
        dbManager.setString(index++,prpCmainDto.getArbitBoardName());
        dbManager.setInt(index++,prpCmainDto.getPayTimes());
        dbManager.setInt(index++,prpCmainDto.getEndorseTimes());
        dbManager.setInt(index++,prpCmainDto.getClaimTimes());
        dbManager.setString(index++,prpCmainDto.getMakeCom());
        dbManager.setString(index++,prpCmainDto.getOperateSite());
        dbManager.setString(index++,prpCmainDto.getComCode());
        dbManager.setString(index++,prpCmainDto.getHandlerCode());
        dbManager.setString(index++,prpCmainDto.getHandler1Code());
        dbManager.setString(index++,prpCmainDto.getApproverCode());
        dbManager.setString(index++,prpCmainDto.getUnderWriteCode());
        dbManager.setString(index++,prpCmainDto.getUnderWriteName());
        dbManager.setString(index++,prpCmainDto.getOperatorCode());
        dbManager.setDateTime(index++,prpCmainDto.getInputDate());
        dbManager.setInt(index++,prpCmainDto.getInputHour());
        dbManager.setDateTime(index++,prpCmainDto.getUnderWriteEndDate());
        dbManager.setDateTime(index++,prpCmainDto.getStatisticsYM());
        dbManager.setString(index++,prpCmainDto.getAgentCode());
        dbManager.setString(index++,prpCmainDto.getCoinsFlag());
        dbManager.setString(index++,prpCmainDto.getReinsFlag());
        dbManager.setString(index++,prpCmainDto.getAllinsFlag());
        dbManager.setString(index++,prpCmainDto.getUnderWriteFlag());
        dbManager.setString(index++,prpCmainDto.getOthFlag());
        dbManager.setString(index++,prpCmainDto.getFlag());
        dbManager.setDouble(index++,prpCmainDto.getDisRate1());
        dbManager.setString(index++,prpCmainDto.getBusinessFlag());
        dbManager.setString(index++,prpCmainDto.getPayMode());
        dbManager.setString(index++,prpCmainDto.getUpdaterCode());
        dbManager.setDateTime(index++,prpCmainDto.getUpdateDate());
        dbManager.setString(index++,prpCmainDto.getUpdateHour());
        dbManager.setDateTime(index++,prpCmainDto.getSignDate());
        dbManager.setString(index++,prpCmainDto.getShareHolderFlag());
        dbManager.setString(index++,prpCmainDto.getAgreementNo());
        dbManager.setString(index++,prpCmainDto.getBusinessType());
        dbManager.setString(index++,prpCmainDto.getBusinessType1());
        dbManager.setString(index++,prpCmainDto.getInquiryNo());
        dbManager.setString(index++,prpCmainDto.getArticleType());
        dbManager.setString(index++,prpCmainDto.getBigMedicalType());
        dbManager.setString(index++,prpCmainDto.getRichFlyAreasCode());
        dbManager.setString(index++,prpCmainDto.getRichFlyAreasCName());
        dbManager.setString(index++,prpCmainDto.getRichFlyCode());
        dbManager.setString(index++,prpCmainDto.getRichFlyCName());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCmain (");
        buffer.append("PolicyNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ProposalNo,");
        buffer.append("ContractNo,");
        buffer.append("PolicySort,");
        buffer.append("PrintNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        buffer.append("PolicyBizType,");
        //modified by zengzhu 2007-11-15 end
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("AppliAddress,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("OperateDate,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("PureRate,");
        buffer.append("DisRate,");
        buffer.append("Discount,");
        buffer.append("Currency,");
        buffer.append("SumValue,");
        buffer.append("SumAmount,");
        buffer.append("SumDiscount,");
        buffer.append("SumPremium,");
        buffer.append("SumSubPrem,");
        buffer.append("SumQuantity,");
        buffer.append("JudicalCode,");
        buffer.append("JudicalScope,");
        buffer.append("AutoTransRenewFlag,");
        buffer.append("ArgueSolution,");
        buffer.append("ArbitBoardName,");
        buffer.append("PayTimes,");
        buffer.append("EndorseTimes,");
        buffer.append("ClaimTimes,");
        buffer.append("MakeCom,");
        buffer.append("OperateSite,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("StatisticsYM,");
        buffer.append("AgentCode,");
        buffer.append("CoinsFlag,");
        buffer.append("ReinsFlag,");
        buffer.append("AllinsFlag,");
        buffer.append("UnderWriteFlag,");
        buffer.append("OthFlag,");
        buffer.append("Flag,");
        buffer.append("DisRate1,");
        buffer.append("BusinessFlag,");
        buffer.append("PayMode,");
        buffer.append("UpdaterCode,");
        buffer.append("UpdateDate,");
        buffer.append("UpdateHour,");
        buffer.append("SignDate,");
        buffer.append("ShareHolderFlag,");
        buffer.append("AgreementNo,");
        buffer.append("businesstype,");
        buffer.append("businesstype1,");
        buffer.append("InquiryNo,");
        buffer.append("ArticleType,");
        buffer.append("BigMedicalType,");
        buffer.append("RichFlyAreasCode, ");
        buffer.append("RichFlyAreasCName, ");
        buffer.append("RichFlyCode, ");
        buffer.append("RichFlyCName ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCmainDto prpCmainDto = (PrpCmainDto)i.next();
            int index=1;
            dbManager.setString(index++,prpCmainDto.getPolicyNo());
            dbManager.setString(index++,prpCmainDto.getClassCode());
            dbManager.setString(index++,prpCmainDto.getRiskCode());
            dbManager.setString(index++,prpCmainDto.getProposalNo());
            dbManager.setString(index++,prpCmainDto.getContractNo());
            dbManager.setString(index++,prpCmainDto.getPolicySort());
            dbManager.setString(index++,prpCmainDto.getPrintNo());
            dbManager.setString(index++,prpCmainDto.getBusinessNature());
            dbManager.setString(index++,prpCmainDto.getLanguage());
            dbManager.setString(index++,prpCmainDto.getPolicyType());
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            dbManager.setString(index++,prpCmainDto.getPolicyBizType());
            //modified by zengzhu 2007-11-15 end
            dbManager.setString(index++,prpCmainDto.getAppliCode());
            dbManager.setString(index++,prpCmainDto.getAppliName());
            dbManager.setString(index++,prpCmainDto.getAppliAddress());
            dbManager.setString(index++,prpCmainDto.getInsuredCode());
            dbManager.setString(index++,prpCmainDto.getInsuredName());
            dbManager.setString(index++,prpCmainDto.getInsuredAddress());
            dbManager.setDateTime(index++,prpCmainDto.getOperateDate());
            dbManager.setDateTime(index++,prpCmainDto.getStartDate());
            dbManager.setInt(index++,prpCmainDto.getStartHour());
            dbManager.setDateTime(index++,prpCmainDto.getEndDate());
            dbManager.setInt(index++,prpCmainDto.getEndHour());
            dbManager.setDouble(index++,prpCmainDto.getPureRate());
            dbManager.setDouble(index++,prpCmainDto.getDisRate());
            dbManager.setDouble(index++,prpCmainDto.getDiscount());
            dbManager.setString(index++,prpCmainDto.getCurrency());
            dbManager.setDouble(index++,prpCmainDto.getSumValue());
            dbManager.setDouble(index++,prpCmainDto.getSumAmount());
            dbManager.setDouble(index++,prpCmainDto.getSumDiscount());
            dbManager.setDouble(index++,prpCmainDto.getSumPremium());
            dbManager.setDouble(index++,prpCmainDto.getSumSubPrem());
            dbManager.setInt(index++,prpCmainDto.getSumQuantity());
            dbManager.setString(index++,prpCmainDto.getJudicalCode());
            dbManager.setString(index++,prpCmainDto.getJudicalScope());
            dbManager.setString(index++,prpCmainDto.getAutoTransRenewFlag());
            dbManager.setString(index++,prpCmainDto.getArgueSolution());
            dbManager.setString(index++,prpCmainDto.getArbitBoardName());
            dbManager.setInt(index++,prpCmainDto.getPayTimes());
            dbManager.setInt(index++,prpCmainDto.getEndorseTimes());
            dbManager.setInt(index++,prpCmainDto.getClaimTimes());
            dbManager.setString(index++,prpCmainDto.getMakeCom());
            dbManager.setString(index++,prpCmainDto.getOperateSite());
            dbManager.setString(index++,prpCmainDto.getComCode());
            dbManager.setString(index++,prpCmainDto.getHandlerCode());
            dbManager.setString(index++,prpCmainDto.getHandler1Code());
            dbManager.setString(index++,prpCmainDto.getApproverCode());
            dbManager.setString(index++,prpCmainDto.getUnderWriteCode());
            dbManager.setString(index++,prpCmainDto.getUnderWriteName());
            dbManager.setString(index++,prpCmainDto.getOperatorCode());
            dbManager.setDateTime(index++,prpCmainDto.getInputDate());
            dbManager.setInt(index++,prpCmainDto.getInputHour());
            dbManager.setDateTime(index++,prpCmainDto.getUnderWriteEndDate());
            dbManager.setDateTime(index++,prpCmainDto.getStatisticsYM());
            dbManager.setString(index++,prpCmainDto.getAgentCode());
            dbManager.setString(index++,prpCmainDto.getCoinsFlag());
            dbManager.setString(index++,prpCmainDto.getReinsFlag());
            dbManager.setString(index++,prpCmainDto.getAllinsFlag());
            dbManager.setString(index++,prpCmainDto.getUnderWriteFlag());
            dbManager.setString(index++,prpCmainDto.getOthFlag());
            dbManager.setString(index++,prpCmainDto.getFlag());
            dbManager.setDouble(index++,prpCmainDto.getDisRate1());
            dbManager.setString(index++,prpCmainDto.getBusinessFlag());
            dbManager.setString(index++,prpCmainDto.getPayMode());
            dbManager.setString(index++,prpCmainDto.getUpdaterCode());
            dbManager.setDateTime(index++,prpCmainDto.getUpdateDate());
            dbManager.setString(index++,prpCmainDto.getUpdateHour());
            dbManager.setDateTime(index++,prpCmainDto.getSignDate());
            dbManager.setString(index++,prpCmainDto.getShareHolderFlag());
            dbManager.setString(index++,prpCmainDto.getAgreementNo());
            dbManager.setString(index++,prpCmainDto.getBusinessType());
            dbManager.setString(index++,prpCmainDto.getBusinessType1());
            dbManager.setString(index++,prpCmainDto.getInquiryNo());
            dbManager.setString(index++,prpCmainDto.getArticleType());
            dbManager.setString(index++,prpCmainDto.getBigMedicalType());
            dbManager.setString(index++,prpCmainDto.getRichFlyAreasCode());
            dbManager.setString(index++,prpCmainDto.getRichFlyAreasCName());
            dbManager.setString(index++,prpCmainDto.getRichFlyCode());
            dbManager.setString(index++,prpCmainDto.getRichFlyCName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(String policyNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCmain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void update(PrpCmainDto prpCmainDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCmain SET ");
        buffer.append("ClassCode = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("ProposalNo = ?, ");
        buffer.append("ContractNo = ?, ");
        buffer.append("PolicySort = ?, ");
        buffer.append("PrintNo = ?, ");
        buffer.append("BusinessNature = ?, ");
        buffer.append("Language = ?, ");
        buffer.append("PolicyType = ?, ");
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        buffer.append("PolicyBizType = ?, ");
         //modified by zengzhu 2007-11-15 end        
        buffer.append("AppliCode = ?, ");
        buffer.append("AppliName = ?, ");
        buffer.append("AppliAddress = ?, ");
        buffer.append("InsuredCode = ?, ");
        buffer.append("InsuredName = ?, ");
        buffer.append("InsuredAddress = ?, ");
        buffer.append("OperateDate = ?, ");
        buffer.append("StartDate = ?, ");
        buffer.append("StartHour = ?, ");
        buffer.append("EndDate = ?, ");
        buffer.append("EndHour = ?, ");
        buffer.append("PureRate = ?, ");
        buffer.append("DisRate = ?, ");
        buffer.append("Discount = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumValue = ?, ");
        buffer.append("SumAmount = ?, ");
        buffer.append("SumDiscount = ?, ");
        buffer.append("SumPremium = ?, ");
        buffer.append("SumSubPrem = ?, ");
        buffer.append("SumQuantity = ?, ");
        buffer.append("JudicalCode = ?, ");
        buffer.append("JudicalScope = ?, ");
        buffer.append("AutoTransRenewFlag = ?, ");
        buffer.append("ArgueSolution = ?, ");
        buffer.append("ArbitBoardName = ?, ");
        buffer.append("PayTimes = ?, ");
        buffer.append("EndorseTimes = ?, ");
        buffer.append("ClaimTimes = ?, ");
        buffer.append("MakeCom = ?, ");
        buffer.append("OperateSite = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("HandlerCode = ?, ");
        buffer.append("Handler1Code = ?, ");
        buffer.append("ApproverCode = ?, ");
        buffer.append("UnderWriteCode = ?, ");
        buffer.append("UnderWriteName = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("InputHour = ?, ");
        buffer.append("UnderWriteEndDate = ?, ");
        buffer.append("StatisticsYM = ?, ");
        buffer.append("AgentCode = ?, ");
        buffer.append("CoinsFlag = ?, ");
        buffer.append("ReinsFlag = ?, ");
        buffer.append("AllinsFlag = ?, ");
        buffer.append("UnderWriteFlag = ?, ");
        buffer.append("OthFlag = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("DisRate1 = ?, ");
        buffer.append("BusinessFlag = ?, ");
        buffer.append("PayMode = ?, ");
        buffer.append("UpdaterCode = ?, ");
        buffer.append("UpdateDate = ?, ");
        buffer.append("UpdateHour = ?, ");
        buffer.append("SignDate = ?, ");
        buffer.append("ShareHolderFlag = ?, ");
        buffer.append("AgreementNo = ?, ");
        buffer.append("BusinessType = ?, ");
        buffer.append("BusinessType1 = ?, ");
        buffer.append("InquiryNo = ?, ");
        buffer.append("ArticleType = ?, ");
        buffer.append("BigMedicalType = ?, ");
        buffer.append("RichFlyAreasCode = ?, ");
        buffer.append("RichFlyAreasCName = ?, ");
        buffer.append("RichFlyCode = ?, ");
        buffer.append("RichFlyCName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCmain SET ");
            debugBuffer.append("ClassCode = '" + prpCmainDto.getClassCode() + "', ");
            debugBuffer.append("RiskCode = '" + prpCmainDto.getRiskCode() + "', ");
            debugBuffer.append("ProposalNo = '" + prpCmainDto.getProposalNo() + "', ");
            debugBuffer.append("ContractNo = '" + prpCmainDto.getContractNo() + "', ");
            debugBuffer.append("PolicySort = '" + prpCmainDto.getPolicySort() + "', ");
            debugBuffer.append("PrintNo = '" + prpCmainDto.getPrintNo() + "', ");
            debugBuffer.append("BusinessNature = '" + prpCmainDto.getBusinessNature() + "', ");
            debugBuffer.append("Language = '" + prpCmainDto.getLanguage() + "', ");
            debugBuffer.append("PolicyType = '" + prpCmainDto.getPolicyType() + "', ");
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            debugBuffer.append("PolicyBizType = '" + prpCmainDto.getPolicyBizType() + "', ");
             //modified by zengzhu 2007-11-15 end
            debugBuffer.append("AppliCode = '" + prpCmainDto.getAppliCode() + "', ");
            debugBuffer.append("AppliName = '" + prpCmainDto.getAppliName() + "', ");
            debugBuffer.append("AppliAddress = '" + prpCmainDto.getAppliAddress() + "', ");
            debugBuffer.append("InsuredCode = '" + prpCmainDto.getInsuredCode() + "', ");
            debugBuffer.append("InsuredName = '" + prpCmainDto.getInsuredName() + "', ");
            debugBuffer.append("InsuredAddress = '" + prpCmainDto.getInsuredAddress() + "', ");
            debugBuffer.append("OperateDate = '" + prpCmainDto.getOperateDate() + "', ");
            debugBuffer.append("StartDate = '" + prpCmainDto.getStartDate() + "', ");
            debugBuffer.append("StartHour = " + prpCmainDto.getStartHour() + ", ");
            debugBuffer.append("EndDate = '" + prpCmainDto.getEndDate() + "', ");
            debugBuffer.append("EndHour = " + prpCmainDto.getEndHour() + ", ");
            debugBuffer.append("PureRate = " + prpCmainDto.getPureRate() + ", ");
            debugBuffer.append("DisRate = " + prpCmainDto.getDisRate() + ", ");
            debugBuffer.append("Discount = " + prpCmainDto.getDiscount() + ", ");
            debugBuffer.append("Currency = '" + prpCmainDto.getCurrency() + "', ");
            debugBuffer.append("SumValue = " + prpCmainDto.getSumValue() + ", ");
            debugBuffer.append("SumAmount = " + prpCmainDto.getSumAmount() + ", ");
            debugBuffer.append("SumDiscount = " + prpCmainDto.getSumDiscount() + ", ");
            debugBuffer.append("SumPremium = " + prpCmainDto.getSumPremium() + ", ");
            debugBuffer.append("SumSubPrem = " + prpCmainDto.getSumSubPrem() + ", ");
            debugBuffer.append("SumQuantity = " + prpCmainDto.getSumQuantity() + ", ");
            debugBuffer.append("JudicalCode = '" + prpCmainDto.getJudicalCode() + "', ");
            debugBuffer.append("JudicalScope = '" + prpCmainDto.getJudicalScope() + "', ");
            debugBuffer.append("AutoTransRenewFlag = '" + prpCmainDto.getAutoTransRenewFlag() + "', ");
            debugBuffer.append("ArgueSolution = '" + prpCmainDto.getArgueSolution() + "', ");
            debugBuffer.append("ArbitBoardName = '" + prpCmainDto.getArbitBoardName() + "', ");
            debugBuffer.append("PayTimes = " + prpCmainDto.getPayTimes() + ", ");
            debugBuffer.append("EndorseTimes = " + prpCmainDto.getEndorseTimes() + ", ");
            debugBuffer.append("ClaimTimes = " + prpCmainDto.getClaimTimes() + ", ");
            debugBuffer.append("MakeCom = '" + prpCmainDto.getMakeCom() + "', ");
            debugBuffer.append("OperateSite = '" + prpCmainDto.getOperateSite() + "', ");
            debugBuffer.append("ComCode = '" + prpCmainDto.getComCode() + "', ");
            debugBuffer.append("HandlerCode = '" + prpCmainDto.getHandlerCode() + "', ");
            debugBuffer.append("Handler1Code = '" + prpCmainDto.getHandler1Code() + "', ");
            debugBuffer.append("ApproverCode = '" + prpCmainDto.getApproverCode() + "', ");
            debugBuffer.append("UnderWriteCode = '" + prpCmainDto.getUnderWriteCode() + "', ");
            debugBuffer.append("UnderWriteName = '" + prpCmainDto.getUnderWriteName() + "', ");
            debugBuffer.append("OperatorCode = '" + prpCmainDto.getOperatorCode() + "', ");
            debugBuffer.append("InputDate = '" + prpCmainDto.getInputDate() + "', ");
            debugBuffer.append("InputHour = " + prpCmainDto.getInputHour() + ", ");
            debugBuffer.append("UnderWriteEndDate = '" + prpCmainDto.getUnderWriteEndDate() + "', ");
            debugBuffer.append("StatisticsYM = '" + prpCmainDto.getStatisticsYM() + "', ");
            debugBuffer.append("AgentCode = '" + prpCmainDto.getAgentCode() + "', ");
            debugBuffer.append("CoinsFlag = '" + prpCmainDto.getCoinsFlag() + "', ");
            debugBuffer.append("ReinsFlag = '" + prpCmainDto.getReinsFlag() + "', ");
            debugBuffer.append("AllinsFlag = '" + prpCmainDto.getAllinsFlag() + "', ");
            debugBuffer.append("UnderWriteFlag = '" + prpCmainDto.getUnderWriteFlag() + "', ");
            debugBuffer.append("OthFlag = '" + prpCmainDto.getOthFlag() + "', ");
            debugBuffer.append("Flag = '" + prpCmainDto.getFlag() + "', ");
            debugBuffer.append("DisRate1 = " + prpCmainDto.getDisRate1() + ", ");
            debugBuffer.append("BusinessFlag = '" + prpCmainDto.getBusinessFlag() + "', ");
            debugBuffer.append("PayMode = '" + prpCmainDto.getPayMode() + "', ");
            debugBuffer.append("UpdaterCode = '" + prpCmainDto.getUpdaterCode() + "', ");
            debugBuffer.append("UpdateDate = '" + prpCmainDto.getUpdateDate() + "', ");
            debugBuffer.append("UpdateHour = '" + prpCmainDto.getUpdateHour() + "', ");
            debugBuffer.append("SignDate = '" + prpCmainDto.getSignDate() + "', ");
            debugBuffer.append("ShareHolderFlag = '" + prpCmainDto.getShareHolderFlag() + "', ");
            debugBuffer.append("AgreementNo = '" + prpCmainDto.getAgreementNo() + "', ");            
            debugBuffer.append("BusinessType = '" + prpCmainDto.getBusinessType() + "', ");
            debugBuffer.append("BusinessType1 = '" + prpCmainDto.getBusinessType1() + "', ");
            debugBuffer.append("InquiryNo = '" + prpCmainDto.getInquiryNo() + "', ");
            debugBuffer.append("ArticleType = '" + prpCmainDto.getArticleType() + "', ");
            debugBuffer.append("BigMedicalType = '" + prpCmainDto.getBigMedicalType() + "', ");	
            debugBuffer.append("RichFlyAreasCode = '" + prpCmainDto.getArticleType() + "', ");
            debugBuffer.append("RichFlyAreasCName = '" + prpCmainDto.getArticleType() + "', ");
            debugBuffer.append("RichFlyCode = '" + prpCmainDto.getArticleType() + "', ");
            debugBuffer.append("RichFlyCName = '" + prpCmainDto.getArticleType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCmainDto.getPolicyNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        int index = 1;
        dbManager.setString(index++,prpCmainDto.getClassCode());
        dbManager.setString(index++,prpCmainDto.getRiskCode());
        dbManager.setString(index++,prpCmainDto.getProposalNo());
        dbManager.setString(index++,prpCmainDto.getContractNo());
        dbManager.setString(index++,prpCmainDto.getPolicySort());
        dbManager.setString(index++,prpCmainDto.getPrintNo());
        dbManager.setString(index++,prpCmainDto.getBusinessNature());
        dbManager.setString(index++,prpCmainDto.getLanguage());
        dbManager.setString(index++,prpCmainDto.getPolicyType());
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        dbManager.setString(index++,prpCmainDto.getPolicyBizType());
         //modified by zengzhu 2007-11-15 end
       
        dbManager.setString(index++,prpCmainDto.getAppliCode());
        dbManager.setString(index++,prpCmainDto.getAppliName());
        dbManager.setString(index++,prpCmainDto.getAppliAddress());
        dbManager.setString(index++,prpCmainDto.getInsuredCode());
        dbManager.setString(index++,prpCmainDto.getInsuredName());
        dbManager.setString(index++,prpCmainDto.getInsuredAddress());
        dbManager.setDateTime(index++,prpCmainDto.getOperateDate());
        dbManager.setDateTime(index++,prpCmainDto.getStartDate());
        dbManager.setInt(index++,prpCmainDto.getStartHour());
        dbManager.setDateTime(index++,prpCmainDto.getEndDate());
        dbManager.setInt(index++,prpCmainDto.getEndHour());
        dbManager.setDouble(index++,prpCmainDto.getPureRate());
        dbManager.setDouble(index++,prpCmainDto.getDisRate());
        dbManager.setDouble(index++,prpCmainDto.getDiscount());
        dbManager.setString(index++,prpCmainDto.getCurrency());
        dbManager.setDouble(index++,prpCmainDto.getSumValue());
        dbManager.setDouble(index++,prpCmainDto.getSumAmount());
        dbManager.setDouble(index++,prpCmainDto.getSumDiscount());
        dbManager.setDouble(index++,prpCmainDto.getSumPremium());
        dbManager.setDouble(index++,prpCmainDto.getSumSubPrem());
        dbManager.setInt(index++,prpCmainDto.getSumQuantity());
        dbManager.setString(index++,prpCmainDto.getJudicalCode());
        dbManager.setString(index++,prpCmainDto.getJudicalScope());
        dbManager.setString(index++,prpCmainDto.getAutoTransRenewFlag());
        dbManager.setString(index++,prpCmainDto.getArgueSolution());
        dbManager.setString(index++,prpCmainDto.getArbitBoardName());
        dbManager.setInt(index++,prpCmainDto.getPayTimes());
        dbManager.setInt(index++,prpCmainDto.getEndorseTimes());
        dbManager.setInt(index++,prpCmainDto.getClaimTimes());
        dbManager.setString(index++,prpCmainDto.getMakeCom());
        dbManager.setString(index++,prpCmainDto.getOperateSite());
        dbManager.setString(index++,prpCmainDto.getComCode());
        dbManager.setString(index++,prpCmainDto.getHandlerCode());
        dbManager.setString(index++,prpCmainDto.getHandler1Code());
        dbManager.setString(index++,prpCmainDto.getApproverCode());
        dbManager.setString(index++,prpCmainDto.getUnderWriteCode());
        dbManager.setString(index++,prpCmainDto.getUnderWriteName());
        dbManager.setString(index++,prpCmainDto.getOperatorCode());
        dbManager.setDateTime(index++,prpCmainDto.getInputDate());
        dbManager.setInt(index++,prpCmainDto.getInputHour());
        dbManager.setDateTime(index++,prpCmainDto.getUnderWriteEndDate());
        dbManager.setDateTime(index++,prpCmainDto.getStatisticsYM());
        dbManager.setString(index++,prpCmainDto.getAgentCode());
        dbManager.setString(index++,prpCmainDto.getCoinsFlag());
        dbManager.setString(index++,prpCmainDto.getReinsFlag());
        dbManager.setString(index++,prpCmainDto.getAllinsFlag());
        dbManager.setString(index++,prpCmainDto.getUnderWriteFlag());
        dbManager.setString(index++,prpCmainDto.getOthFlag());
        dbManager.setString(index++,prpCmainDto.getFlag());
        dbManager.setDouble(index++,prpCmainDto.getDisRate1());
        dbManager.setString(index++,prpCmainDto.getBusinessFlag());
        dbManager.setString(index++,prpCmainDto.getPayMode());
        dbManager.setString(index++,prpCmainDto.getUpdaterCode());
        dbManager.setDateTime(index++,prpCmainDto.getUpdateDate());
        dbManager.setString(index++,prpCmainDto.getUpdateHour());
        dbManager.setDateTime(index++,prpCmainDto.getSignDate());
        dbManager.setString(index++,prpCmainDto.getShareHolderFlag());
        dbManager.setString(index++,prpCmainDto.getAgreementNo());
        dbManager.setString(index++,prpCmainDto.getBusinessType());
        dbManager.setString(index++,prpCmainDto.getBusinessType1());
        dbManager.setString(index++,prpCmainDto.getInquiryNo());
        dbManager.setString(index++,prpCmainDto.getArticleType());
        dbManager.setString(index++,prpCmainDto.getBigMedicalType());
        dbManager.setString(index++,prpCmainDto.getRichFlyAreasCode());
        dbManager.setString(index++,prpCmainDto.getRichFlyAreasCName());
        dbManager.setString(index++,prpCmainDto.getRichFlyCode());
        dbManager.setString(index++,prpCmainDto.getRichFlyCName());
        //设置条件字段;
        dbManager.setString(index++,prpCmainDto.getPolicyNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @return PrpCmainDto
     * @throws Exception
     */
    public PrpCmainDto findByPrimaryKey(String policyNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ProposalNo,");
        buffer.append("ContractNo,");
        buffer.append("PolicySort,");
        buffer.append("PrintNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        buffer.append("PolicyBizType,");
        //modified by zengzhu 2007-11-15 end
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("AppliAddress,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("OperateDate,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("PureRate,");
        buffer.append("DisRate,");
        buffer.append("Discount,");
        buffer.append("Currency,");
        buffer.append("SumValue,");
        buffer.append("SumAmount,");
        buffer.append("SumDiscount,");
        buffer.append("SumPremium,");
        buffer.append("SumSubPrem,");
        buffer.append("SumQuantity,");
        buffer.append("JudicalCode,");
        buffer.append("JudicalScope,");
        buffer.append("AutoTransRenewFlag,");
        buffer.append("ArgueSolution,");
        buffer.append("ArbitBoardName,");
        buffer.append("PayTimes,");
        buffer.append("EndorseTimes,");
        buffer.append("ClaimTimes,");
        buffer.append("MakeCom,");
        buffer.append("OperateSite,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("StatisticsYM,");
        buffer.append("AgentCode,");
        buffer.append("CoinsFlag,");
        buffer.append("ReinsFlag,");
        buffer.append("AllinsFlag,");
        buffer.append("UnderWriteFlag,");
        buffer.append("OthFlag,");
        buffer.append("Flag,");
        buffer.append("DisRate1,");
        buffer.append("BusinessFlag,");
        buffer.append("PayMode,");
        buffer.append("UpdaterCode,");
        buffer.append("UpdateDate,");
        buffer.append("UpdateHour,");
        buffer.append("SignDate,");
        buffer.append("ShareHolderFlag,");
        buffer.append("AgreementNo,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("InquiryNo,");
        buffer.append("ArticleType, ");
        buffer.append("BigMedicalType, ");
        buffer.append("sumInsured,");
        buffer.append("StatQuantity, ");
        buffer.append("RichFlyAreasCode, ");
        buffer.append("RichFlyAreasCName, ");
        buffer.append("RichFlyCode, ");
        buffer.append("BusinessProvince, ");
        buffer.append("BusinessTown, ");
        buffer.append("BusinessCounty, ");
        buffer.append("BusinessAreaName, ");
        buffer.append("RichFlyCName, ");
        //add by dongkun 呼叫中心对接 报案接口添加判断系统字段
        buffer.append("SystemFlag ");
        buffer.append("FROM PrpCmain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCmainDto prpCmainDto = null;
        if(resultSet.next()){
        	int index=1;
            prpCmainDto = new PrpCmainDto();
            prpCmainDto.setPolicyNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setClassCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setRiskCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setProposalNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setContractNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setPolicySort(dbManager.getString(resultSet,index++));
            prpCmainDto.setPrintNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessNature(dbManager.getString(resultSet,index++));
            prpCmainDto.setLanguage(dbManager.getString(resultSet,index++));
            prpCmainDto.setPolicyType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            prpCmainDto.setPolicyBizType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 end
            
            prpCmainDto.setAppliCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setAppliName(dbManager.getString(resultSet,index++));
            prpCmainDto.setAppliAddress(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredName(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredAddress(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStartHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setEndHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setPureRate(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setDisRate(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setDiscount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setCurrency(dbManager.getString(resultSet,index++));
            prpCmainDto.setSumValue(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumAmount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumDiscount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumPremium(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumSubPrem(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumQuantity(dbManager.getInt(resultSet,index++));
            prpCmainDto.setJudicalCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setJudicalScope(dbManager.getString(resultSet,index++));
            prpCmainDto.setAutoTransRenewFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setArgueSolution(dbManager.getString(resultSet,index++));
            prpCmainDto.setArbitBoardName(dbManager.getString(resultSet,index++));
            prpCmainDto.setPayTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setEndorseTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setClaimTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setMakeCom(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperateSite(dbManager.getString(resultSet,index++));
            prpCmainDto.setComCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setHandler1Code(dbManager.getString(resultSet,index++));
            prpCmainDto.setApproverCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteName(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperatorCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setInputHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setAgentCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setCoinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setReinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setAllinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setOthFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setDisRate1(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setBusinessFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setPayMode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUpdaterCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setUpdateHour(dbManager.getString(resultSet,index++));
            prpCmainDto.setSignDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setShareHolderFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setAgreementNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessType(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessType1(dbManager.getString(resultSet,index++));
            prpCmainDto.setInquiryNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setArticleType(dbManager.getString(resultSet,index++));
            prpCmainDto.setBigMedicalType(dbManager.getString(resultSet,index++));
            prpCmainDto.setSumInsured(dbManager.getInt(resultSet,index++));
            prpCmainDto.setStatQuantity(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setRichFlyAreasCode(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyAreasCName(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyCode(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setBusinessProvince(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setBusinessTown(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setBusinessCounty(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setBusinessAreaName(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyCName(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            //add by dongkun 呼叫中心对接 报案接口添加判断系统字段
            prpCmainDto.setSystemFlag(dbManager.getString(resultSet,index++));
        }else{
            logger.info("DBPrpCmainBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpCmainDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ProposalNo,");
        buffer.append("ContractNo,");
        buffer.append("PolicySort,");
        buffer.append("PrintNo,");
        buffer.append("BusinessNature,");
        buffer.append("Language,");
        buffer.append("PolicyType,");
        //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
        buffer.append("PolicyBizType,");
        //modified by zengzhu 2007-11-15 end
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("AppliAddress,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("InsuredAddress,");
        buffer.append("OperateDate,");
        buffer.append("StartDate,");
        buffer.append("StartHour,");
        buffer.append("EndDate,");
        buffer.append("EndHour,");
        buffer.append("PureRate,");
        buffer.append("DisRate,");
        buffer.append("Discount,");
        buffer.append("Currency,");
        buffer.append("SumValue,");
        buffer.append("SumAmount,");
        buffer.append("SumDiscount,");
        buffer.append("SumPremium,");
        buffer.append("SumSubPrem,");
        buffer.append("SumQuantity,");
        buffer.append("JudicalCode,");
        buffer.append("JudicalScope,");
        buffer.append("AutoTransRenewFlag,");
        buffer.append("ArgueSolution,");
        buffer.append("ArbitBoardName,");
        buffer.append("PayTimes,");
        buffer.append("EndorseTimes,");
        buffer.append("ClaimTimes,");
        buffer.append("MakeCom,");
        buffer.append("OperateSite,");
        buffer.append("ComCode,");
        buffer.append("HandlerCode,");
        buffer.append("Handler1Code,");
        buffer.append("ApproverCode,");
        buffer.append("UnderWriteCode,");
        buffer.append("UnderWriteName,");
        buffer.append("OperatorCode,");
        buffer.append("InputDate,");
        buffer.append("InputHour,");
        buffer.append("UnderWriteEndDate,");
        buffer.append("StatisticsYM,");
        buffer.append("AgentCode,");
        buffer.append("CoinsFlag,");
        buffer.append("ReinsFlag,");
        buffer.append("AllinsFlag,");
        buffer.append("UnderWriteFlag,");
        buffer.append("OthFlag,");
        buffer.append("Flag,");
        buffer.append("DisRate1,");
        buffer.append("BusinessFlag,");
        buffer.append("PayMode,");
        buffer.append("UpdaterCode,");
        buffer.append("UpdateDate,");
        buffer.append("UpdateHour,");
        buffer.append("SignDate,");
        buffer.append("ShareHolderFlag,");
        buffer.append("AgreementNo,");
        buffer.append("BusinessType,");
        buffer.append("BusinessType1,");
        buffer.append("InquiryNo,");
        buffer.append("ArticleType,");
        buffer.append("BigMedicalType,");
        buffer.append("RichFlyAreasCode, ");
        buffer.append("RichFlyAreasCName, ");
        buffer.append("RichFlyCode, ");
        buffer.append("RichFlyCName ");
        buffer.append("FROM PrpCmain WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpCmainDto prpCmainDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCmainDto = new PrpCmainDto();
            int index=1;
            prpCmainDto.setPolicyNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setClassCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setRiskCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setProposalNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setContractNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setPolicySort(dbManager.getString(resultSet,index++));
            prpCmainDto.setPrintNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessNature(dbManager.getString(resultSet,index++));
            prpCmainDto.setLanguage(dbManager.getString(resultSet,index++));
            prpCmainDto.setPolicyType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
            prpCmainDto.setPolicyBizType(dbManager.getString(resultSet,index++));
            //modified by zengzhu 2007-11-15 end
            prpCmainDto.setAppliCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setAppliName(dbManager.getString(resultSet,index++));
            prpCmainDto.setAppliAddress(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredName(dbManager.getString(resultSet,index++));
            prpCmainDto.setInsuredAddress(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStartHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setEndHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setPureRate(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setDisRate(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setDiscount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setCurrency(dbManager.getString(resultSet,index++));
            prpCmainDto.setSumValue(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumAmount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumDiscount(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumPremium(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumSubPrem(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setSumQuantity(dbManager.getInt(resultSet,index++));
            prpCmainDto.setJudicalCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setJudicalScope(dbManager.getString(resultSet,index++));
            prpCmainDto.setAutoTransRenewFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setArgueSolution(dbManager.getString(resultSet,index++));
            prpCmainDto.setArbitBoardName(dbManager.getString(resultSet,index++));
            prpCmainDto.setPayTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setEndorseTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setClaimTimes(dbManager.getInt(resultSet,index++));
            prpCmainDto.setMakeCom(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperateSite(dbManager.getString(resultSet,index++));
            prpCmainDto.setComCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setHandlerCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setHandler1Code(dbManager.getString(resultSet,index++));
            prpCmainDto.setApproverCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteName(dbManager.getString(resultSet,index++));
            prpCmainDto.setOperatorCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setInputHour(dbManager.getInt(resultSet,index++));
            prpCmainDto.setUnderWriteEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setStatisticsYM(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setAgentCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setCoinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setReinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setAllinsFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setUnderWriteFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setOthFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setDisRate1(dbManager.getDouble(resultSet,index++));
            prpCmainDto.setBusinessFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setPayMode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUpdaterCode(dbManager.getString(resultSet,index++));
            prpCmainDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setUpdateHour(dbManager.getString(resultSet,index++));
            prpCmainDto.setSignDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,index++));
            prpCmainDto.setShareHolderFlag(dbManager.getString(resultSet,index++));
            prpCmainDto.setAgreementNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessType(dbManager.getString(resultSet,index++));
            prpCmainDto.setBusinessType1(dbManager.getString(resultSet,index++));
            prpCmainDto.setInquiryNo(dbManager.getString(resultSet,index++));
            prpCmainDto.setArticleType(dbManager.getString(resultSet,index++));
            prpCmainDto.setBigMedicalType(dbManager.getString(resultSet,index++));
            prpCmainDto.setRichFlyAreasCode(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyAreasCName(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyCode(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            prpCmainDto.setRichFlyCName(ChgData.nullToString(dbManager.getString(resultSet,index++)));
            collection.add(prpCmainDto);
        }
        resultSet.close();
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCmain WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        String statement;
        statement="SELECT count(1) FROM PrpCmain WHERE ";
         statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
