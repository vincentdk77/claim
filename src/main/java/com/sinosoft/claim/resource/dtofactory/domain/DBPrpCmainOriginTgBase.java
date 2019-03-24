package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.prpall.dto.domain.PrpCmainOriginDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBPrpCmainOriginTgBase
{
  protected DBManager dbManager = null;
  private static Log logger = LogFactory.getLog(DBPrpCmainOriginTgBase.class);

  public DBPrpCmainOriginTgBase(DBManager dbManager)
  {
    this.dbManager = dbManager;
  }

  public void insert(PrpCmainOriginDto prpCmainOriginDto)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(200);
    buffer.append("INSERT INTO PrpCmainOriginTg (");
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

    buffer.append("PolicyBizType,");

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
    buffer.append("JUDICALCODE,");
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
    buffer.append("Underwritestartdate,");
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
    buffer.append("InquiryNo,");
    buffer.append("Remark, ");
    buffer.append("LimitAmount, ");
    buffer.append("ThirdKnow, ");
    buffer.append("nCarPerPflag, ");
    buffer.append("businessYear, ");
    buffer.append("makeArea, ");
    buffer.append("topCommisionRate, ");
    buffer.append("intCommisionRate ,");
    buffer.append("sumNoTaxPremium, ");
    buffer.append("sumTaxFee, ");
    buffer.append("notificationFlag, ");
    buffer.append("InceptionFlag ");
    buffer.append(") ");
    if (logger.isDebugEnabled()) {
      StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
      debugBuffer.append(buffer.toString());
      debugBuffer.append("VALUES(");
      debugBuffer.append("'").append(prpCmainOriginDto.getPolicyNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getClassCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getRiskCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getProposalNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getContractNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getPolicySort()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getPrintNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getBusinessNature()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getLanguage()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getPolicyType()).append("',");

      debugBuffer.append("'").append(prpCmainOriginDto.getPolicyBizType()).append("',");

      debugBuffer.append("'").append(prpCmainOriginDto.getAppliCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAppliName()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAppliAddress()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getInsuredCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getInsuredName()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getInsuredAddress()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getOperateDate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getStartDate()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getStartHour()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getEndDate()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getEndHour()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getPureRate()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getDisRate()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getDiscount()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getCurrency()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getSumValue()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getSumAmount()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getSumDiscount()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getSumPremium()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getSumSubPrem()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getSumQuantity()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getJUDICALCODE()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getJudicalScope()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAutoTransRenewFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getArgueSolution()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getArbitBoardName()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getPayTimes()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getEndorseTimes()).append(",");
      debugBuffer.append("").append(prpCmainOriginDto.getClaimTimes()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getMakeCom()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getOperateSite()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getComCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getHandlerCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getHandler1Code()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getApproverCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUnderWriteCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUnderWriteName()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getOperatorCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getInputDate()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getInputHour()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getUnderWriteEndDate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUnderwritestartdate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getStatisticsYM()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAgentCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getCoinsFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getReinsFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAllinsFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUnderWriteFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getOthFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getFlag()).append("',");
      debugBuffer.append("").append(prpCmainOriginDto.getDisRate1()).append(",");
      debugBuffer.append("'").append(prpCmainOriginDto.getBusinessFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getPayMode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUpdaterCode()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUpdateDate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getUpdateHour()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getSignDate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getShareHolderFlag()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getAgreementNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getInquiryNo()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getRemark()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getLimitamount()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getThirdKnow()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getNCarPerPflag()).append("')");

      debugBuffer.append("'").append(prpCmainOriginDto.getBusinessYear()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getMakeArea()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getTopCommissionRate()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getIntCommissionRate()).append("')");
      debugBuffer.append("'").append(prpCmainOriginDto.getSumNoTaxPremium()).append("',");
      debugBuffer.append("'").append(prpCmainOriginDto.getSumTaxFee()).append("')");
      logger.debug(debugBuffer.toString());
    }

    buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    this.dbManager.prepareStatement(buffer.toString());
    int index = 1;
    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getClassCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getRiskCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getProposalNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getContractNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getPolicySort());
    this.dbManager.setString(index++, prpCmainOriginDto.getPrintNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessNature());
    this.dbManager.setString(index++, prpCmainOriginDto.getLanguage());
    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyType());

    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyBizType());

    this.dbManager.setString(index++, prpCmainOriginDto.getAppliCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getAppliName());
    this.dbManager.setString(index++, prpCmainOriginDto.getAppliAddress());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredName());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredAddress());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getOperateDate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getStartDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getStartHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getEndDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getEndHour());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getPureRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDiscount());
    this.dbManager.setString(index++, prpCmainOriginDto.getCurrency());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumValue());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumAmount());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumDiscount());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumPremium());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumSubPrem());
    this.dbManager.setLong(index++, prpCmainOriginDto.getSumQuantity());
    this.dbManager.setString(index++, prpCmainOriginDto.getJUDICALCODE());
    this.dbManager.setString(index++, prpCmainOriginDto.getJudicalScope());
    this.dbManager.setString(index++, prpCmainOriginDto.getAutoTransRenewFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getArgueSolution());
    this.dbManager.setString(index++, prpCmainOriginDto.getArbitBoardName());
    this.dbManager.setLong(index++, prpCmainOriginDto.getPayTimes());
    this.dbManager.setLong(index++, prpCmainOriginDto.getEndorseTimes());
    this.dbManager.setLong(index++, prpCmainOriginDto.getClaimTimes());
    this.dbManager.setString(index++, prpCmainOriginDto.getMakeCom());
    this.dbManager.setString(index++, prpCmainOriginDto.getOperateSite());
    this.dbManager.setString(index++, prpCmainOriginDto.getComCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getHandlerCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getHandler1Code());
    this.dbManager.setString(index++, prpCmainOriginDto.getApproverCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteName());
    this.dbManager.setString(index++, prpCmainOriginDto.getOperatorCode());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getInputDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getInputHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderWriteEndDate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderwritestartdate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getStatisticsYM());
    this.dbManager.setString(index++, prpCmainOriginDto.getAgentCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getCoinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getReinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getAllinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getOthFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getFlag());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate1());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getPayMode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUpdaterCode());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUpdateDate());
    this.dbManager.setString(index++, prpCmainOriginDto.getUpdateHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getSignDate());
    this.dbManager.setString(index++, prpCmainOriginDto.getShareHolderFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getAgreementNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getInquiryNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getRemark());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getLimitamount());
    this.dbManager.setString(index++, prpCmainOriginDto.getThirdKnow());
    this.dbManager.setString(index++, prpCmainOriginDto.getNCarPerPflag());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessYear());
    this.dbManager.setString(index++, prpCmainOriginDto.getMakeArea());
    this.dbManager.setString(index++, prpCmainOriginDto.getTopCommissionRate());
    this.dbManager.setString(index++, prpCmainOriginDto.getIntCommissionRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumNoTaxPremium());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumTaxFee());
    this.dbManager.setString(index++, prpCmainOriginDto.getNotificationFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getInceptionFlag());
    this.dbManager.executePreparedUpdate();
  }

  public void insertAll(Collection collection)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(200);
    buffer.append("INSERT INTO PrpCmainOriginTg (");
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

    buffer.append("PolicyBizType,");

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
    buffer.append("JUDICALCODE,");
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
    buffer.append("Underwritestartdate,");
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
    buffer.append("InquiryNo,");
    buffer.append("Remark, ");
    buffer.append("LimitAmount, ");
    buffer.append("ThirdKnow, ");
    buffer.append("nCarPerPflag, ");
    buffer.append("businessYear, ");
    buffer.append("makeArea, ");
    buffer.append("topCommisionRate, ");
    buffer.append("intCommisionRate ,");
    buffer.append("sumNoTaxPremium, ");
    buffer.append("sumTaxFee ");
    buffer.append(") ");
    buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    if (logger.isDebugEnabled()) {
      logger.debug(buffer.toString());
    }
    this.dbManager.prepareStatement(buffer.toString());
    for (Iterator i = collection.iterator(); i.hasNext(); ) {
      PrpCmainOriginDto prpCmainOriginDto = (PrpCmainOriginDto)i.next();
      int index = 1;
      this.dbManager.setString(index++, prpCmainOriginDto.getPolicyNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getClassCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getRiskCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getProposalNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getContractNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getPolicySort());
      this.dbManager.setString(index++, prpCmainOriginDto.getPrintNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getBusinessNature());
      this.dbManager.setString(index++, prpCmainOriginDto.getLanguage());
      this.dbManager.setString(index++, prpCmainOriginDto.getPolicyType());

      this.dbManager.setString(index++, prpCmainOriginDto.getPolicyBizType());

      this.dbManager.setString(index++, prpCmainOriginDto.getAppliCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getAppliName());
      this.dbManager.setString(index++, prpCmainOriginDto.getAppliAddress());
      this.dbManager.setString(index++, prpCmainOriginDto.getInsuredCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getInsuredName());
      this.dbManager.setString(index++, prpCmainOriginDto.getInsuredAddress());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getOperateDate());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getStartDate());
      this.dbManager.setLong(index++, prpCmainOriginDto.getStartHour());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getEndDate());
      this.dbManager.setLong(index++, prpCmainOriginDto.getEndHour());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getPureRate());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getDiscount());
      this.dbManager.setString(index++, prpCmainOriginDto.getCurrency());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumValue());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumAmount());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumDiscount());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumPremium());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumSubPrem());
      this.dbManager.setLong(index++, prpCmainOriginDto.getSumQuantity());
      this.dbManager.setString(index++, prpCmainOriginDto.getJUDICALCODE());
      this.dbManager.setString(index++, prpCmainOriginDto.getJudicalScope());
      this.dbManager.setString(index++, prpCmainOriginDto.getAutoTransRenewFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getArgueSolution());
      this.dbManager.setString(index++, prpCmainOriginDto.getArbitBoardName());
      this.dbManager.setLong(index++, prpCmainOriginDto.getPayTimes());
      this.dbManager.setLong(index++, prpCmainOriginDto.getEndorseTimes());
      this.dbManager.setLong(index++, prpCmainOriginDto.getClaimTimes());
      this.dbManager.setString(index++, prpCmainOriginDto.getMakeCom());
      this.dbManager.setString(index++, prpCmainOriginDto.getOperateSite());
      this.dbManager.setString(index++, prpCmainOriginDto.getComCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getHandlerCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getHandler1Code());
      this.dbManager.setString(index++, prpCmainOriginDto.getApproverCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteName());
      this.dbManager.setString(index++, prpCmainOriginDto.getOperatorCode());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getInputDate());
      this.dbManager.setLong(index++, prpCmainOriginDto.getInputHour());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderWriteEndDate());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderwritestartdate());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getStatisticsYM());
      this.dbManager.setString(index++, prpCmainOriginDto.getAgentCode());
      this.dbManager.setString(index++, prpCmainOriginDto.getCoinsFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getReinsFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getAllinsFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getOthFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getFlag());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate1());
      this.dbManager.setString(index++, prpCmainOriginDto.getBusinessFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getPayMode());
      this.dbManager.setString(index++, prpCmainOriginDto.getUpdaterCode());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getUpdateDate());
      this.dbManager.setString(index++, prpCmainOriginDto.getUpdateHour());
      this.dbManager.setDateTime(index++, prpCmainOriginDto.getSignDate());
      this.dbManager.setString(index++, prpCmainOriginDto.getShareHolderFlag());
      this.dbManager.setString(index++, prpCmainOriginDto.getAgreementNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getInquiryNo());
      this.dbManager.setString(index++, prpCmainOriginDto.getRemark());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getLimitamount());
      this.dbManager.setString(index++, prpCmainOriginDto.getThirdKnow());
      this.dbManager.setString(index++, prpCmainOriginDto.getNCarPerPflag());
      this.dbManager.setString(index++, prpCmainOriginDto.getBusinessYear());
      this.dbManager.setString(index++, prpCmainOriginDto.getMakeArea());
      this.dbManager.setString(index++, prpCmainOriginDto.getTopCommissionRate());
      this.dbManager.setString(index++, prpCmainOriginDto.getIntCommissionRate());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumNoTaxPremium());
      this.dbManager.setDouble(index++, prpCmainOriginDto.getSumTaxFee());
      this.dbManager.addBatch();
    }
    this.dbManager.executePreparedUpdateBatch();
  }

  public void delete(String policyNo)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("DELETE FROM PrpCmainOriginTg ");
    if (logger.isDebugEnabled()) {
      StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
      debugBuffer.append(buffer.toString());
      debugBuffer.append("WHERE ");
      debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
      logger.debug(debugBuffer.toString());
    }

    buffer.append("WHERE ");
    buffer.append("PolicyNo = ?");

    this.dbManager.prepareStatement(buffer.toString());

    this.dbManager.setString(1, policyNo);
    this.dbManager.executePreparedUpdate();
  }

  public void update(PrpCmainOriginDto prpCmainOriginDto)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(200);
    buffer.append("UPDATE PrpCmainOriginTg SET ");
    buffer.append("ClassCode = ?, ");
    buffer.append("RiskCode = ?, ");
    buffer.append("ProposalNo = ?, ");
    buffer.append("ContractNo = ?, ");
    buffer.append("PolicySort = ?, ");
    buffer.append("PrintNo = ?, ");
    buffer.append("BusinessNature = ?, ");
    buffer.append("Language = ?, ");
    buffer.append("PolicyType = ?, ");

    buffer.append("PolicyBizType = ?, ");

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
    buffer.append("JUDICALCODE = ?, ");
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
    buffer.append("Underwritestartdate = ?, ");
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
    buffer.append("InquiryNo = ?, ");
    buffer.append("Remark = ?, ");
    buffer.append("LimitAmount = ?, ");
    buffer.append("ThirdKnow = ?, ");
    buffer.append("nCarPerPflag = ?, ");
    buffer.append("businessYear = ?, ");
    buffer.append("makeArea = ?, ");
    buffer.append("topCommisionRate = ?, ");
    buffer.append("intCommisionRate = ?, ");
    buffer.append("sumNoTaxPremium=?, ");
    buffer.append("sumTaxFee=?, ");
    buffer.append("notificationFlag=?, ");
    buffer.append("InceptionFlag=? ");
    if (logger.isDebugEnabled()) {
      StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
      debugBuffer.append("UPDATE PrpCmainOriginTg SET ");
      debugBuffer.append("ClassCode = '" + prpCmainOriginDto.getClassCode() + "', ");
      debugBuffer.append("RiskCode = '" + prpCmainOriginDto.getRiskCode() + "', ");
      debugBuffer.append("ProposalNo = '" + prpCmainOriginDto.getProposalNo() + "', ");
      debugBuffer.append("ContractNo = '" + prpCmainOriginDto.getContractNo() + "', ");
      debugBuffer.append("PolicySort = '" + prpCmainOriginDto.getPolicySort() + "', ");
      debugBuffer.append("PrintNo = '" + prpCmainOriginDto.getPrintNo() + "', ");
      debugBuffer.append("BusinessNature = '" + prpCmainOriginDto.getBusinessNature() + "', ");
      debugBuffer.append("Language = '" + prpCmainOriginDto.getLanguage() + "', ");
      debugBuffer.append("PolicyType = '" + prpCmainOriginDto.getPolicyType() + "', ");

      debugBuffer.append("PolicyBizType = '" + prpCmainOriginDto.getPolicyBizType() + "', ");

      debugBuffer.append("AppliCode = '" + prpCmainOriginDto.getAppliCode() + "', ");
      debugBuffer.append("AppliName = '" + prpCmainOriginDto.getAppliName() + "', ");
      debugBuffer.append("AppliAddress = '" + prpCmainOriginDto.getAppliAddress() + "', ");
      debugBuffer.append("InsuredCode = '" + prpCmainOriginDto.getInsuredCode() + "', ");
      debugBuffer.append("InsuredName = '" + prpCmainOriginDto.getInsuredName() + "', ");
      debugBuffer.append("InsuredAddress = '" + prpCmainOriginDto.getInsuredAddress() + "', ");
      debugBuffer.append("OperateDate = '" + prpCmainOriginDto.getOperateDate() + "', ");
      debugBuffer.append("StartDate = '" + prpCmainOriginDto.getStartDate() + "', ");
      debugBuffer.append("StartHour = " + prpCmainOriginDto.getStartHour() + ", ");
      debugBuffer.append("EndDate = '" + prpCmainOriginDto.getEndDate() + "', ");
      debugBuffer.append("EndHour = " + prpCmainOriginDto.getEndHour() + ", ");
      debugBuffer.append("PureRate = " + prpCmainOriginDto.getPureRate() + ", ");
      debugBuffer.append("DisRate = " + prpCmainOriginDto.getDisRate() + ", ");
      debugBuffer.append("Discount = " + prpCmainOriginDto.getDiscount() + ", ");
      debugBuffer.append("Currency = '" + prpCmainOriginDto.getCurrency() + "', ");
      debugBuffer.append("SumValue = " + prpCmainOriginDto.getSumValue() + ", ");
      debugBuffer.append("SumAmount = " + prpCmainOriginDto.getSumAmount() + ", ");
      debugBuffer.append("SumDiscount = " + prpCmainOriginDto.getSumDiscount() + ", ");
      debugBuffer.append("SumPremium = " + prpCmainOriginDto.getSumPremium() + ", ");
      debugBuffer.append("SumSubPrem = " + prpCmainOriginDto.getSumSubPrem() + ", ");
      debugBuffer.append("SumQuantity = " + prpCmainOriginDto.getSumQuantity() + ", ");
      debugBuffer.append("JUDICALCODE = '" + prpCmainOriginDto.getJUDICALCODE() + "', ");
      debugBuffer.append("JudicalScope = '" + prpCmainOriginDto.getJudicalScope() + "', ");
      debugBuffer.append("AutoTransRenewFlag = '" + prpCmainOriginDto.getAutoTransRenewFlag() + "', ");
      debugBuffer.append("ArgueSolution = '" + prpCmainOriginDto.getArgueSolution() + "', ");
      debugBuffer.append("ArbitBoardName = '" + prpCmainOriginDto.getArbitBoardName() + "', ");
      debugBuffer.append("PayTimes = " + prpCmainOriginDto.getPayTimes() + ", ");
      debugBuffer.append("EndorseTimes = " + prpCmainOriginDto.getEndorseTimes() + ", ");
      debugBuffer.append("ClaimTimes = " + prpCmainOriginDto.getClaimTimes() + ", ");
      debugBuffer.append("MakeCom = '" + prpCmainOriginDto.getMakeCom() + "', ");
      debugBuffer.append("OperateSite = '" + prpCmainOriginDto.getOperateSite() + "', ");
      debugBuffer.append("ComCode = '" + prpCmainOriginDto.getComCode() + "', ");
      debugBuffer.append("HandlerCode = '" + prpCmainOriginDto.getHandlerCode() + "', ");
      debugBuffer.append("Handler1Code = '" + prpCmainOriginDto.getHandler1Code() + "', ");
      debugBuffer.append("ApproverCode = '" + prpCmainOriginDto.getApproverCode() + "', ");
      debugBuffer.append("UnderWriteCode = '" + prpCmainOriginDto.getUnderWriteCode() + "', ");
      debugBuffer.append("UnderWriteName = '" + prpCmainOriginDto.getUnderWriteName() + "', ");
      debugBuffer.append("OperatorCode = '" + prpCmainOriginDto.getOperatorCode() + "', ");
      debugBuffer.append("InputDate = '" + prpCmainOriginDto.getInputDate() + "', ");
      debugBuffer.append("InputHour = " + prpCmainOriginDto.getInputHour() + ", ");
      debugBuffer.append("UnderWriteEndDate = '" + prpCmainOriginDto.getUnderWriteEndDate() + "', ");
      debugBuffer.append("Underwritestartdate = '" + prpCmainOriginDto.getUnderwritestartdate() + "', ");
      debugBuffer.append("StatisticsYM = '" + prpCmainOriginDto.getStatisticsYM() + "', ");
      debugBuffer.append("AgentCode = '" + prpCmainOriginDto.getAgentCode() + "', ");
      debugBuffer.append("CoinsFlag = '" + prpCmainOriginDto.getCoinsFlag() + "', ");
      debugBuffer.append("ReinsFlag = '" + prpCmainOriginDto.getReinsFlag() + "', ");
      debugBuffer.append("AllinsFlag = '" + prpCmainOriginDto.getAllinsFlag() + "', ");
      debugBuffer.append("UnderWriteFlag = '" + prpCmainOriginDto.getUnderWriteFlag() + "', ");
      debugBuffer.append("OthFlag = '" + prpCmainOriginDto.getOthFlag() + "', ");
      debugBuffer.append("Flag = '" + prpCmainOriginDto.getFlag() + "', ");
      debugBuffer.append("DisRate1 = " + prpCmainOriginDto.getDisRate1() + ", ");
      debugBuffer.append("BusinessFlag = '" + prpCmainOriginDto.getBusinessFlag() + "', ");
      debugBuffer.append("PayMode = '" + prpCmainOriginDto.getPayMode() + "', ");
      debugBuffer.append("UpdaterCode = '" + prpCmainOriginDto.getUpdaterCode() + "', ");
      debugBuffer.append("UpdateDate = '" + prpCmainOriginDto.getUpdateDate() + "', ");
      debugBuffer.append("UpdateHour = '" + prpCmainOriginDto.getUpdateHour() + "', ");
      debugBuffer.append("SignDate = '" + prpCmainOriginDto.getSignDate() + "', ");
      debugBuffer.append("ShareHolderFlag = '" + prpCmainOriginDto.getShareHolderFlag() + "', ");
      debugBuffer.append("AgreementNo = '" + prpCmainOriginDto.getAgreementNo() + "', ");
      debugBuffer.append("InquiryNo = '" + prpCmainOriginDto.getInquiryNo() + "', ");
      debugBuffer.append("Remark = '" + prpCmainOriginDto.getRemark() + "', ");
      debugBuffer.append("LimitAmount = '" + prpCmainOriginDto.getLimitamount() + "', ");
      debugBuffer.append("ThirdKnow = '" + prpCmainOriginDto.getThirdKnow() + "', ");
      debugBuffer.append("nCarPerPflag = '" + prpCmainOriginDto.getNCarPerPflag() + "', ");
      debugBuffer.append("businessyear = '" + prpCmainOriginDto.getBusinessYear() + "', ");
      debugBuffer.append("makearea = '" + prpCmainOriginDto.getMakeArea() + "', ");
      debugBuffer.append("topCommisionRate = '" + prpCmainOriginDto.getTopCommissionRate() + "', ");
      debugBuffer.append("intCommisionRate = '" + prpCmainOriginDto.getIntCommissionRate() + "' ");
      debugBuffer.append("sumNoTaxPremium = '" + prpCmainOriginDto.getSumNoTaxPremium() + "', ");
      debugBuffer.append("sumTaxFee = '" + prpCmainOriginDto.getSumTaxFee() + "' ");
      debugBuffer.append("WHERE ");
      debugBuffer.append("PolicyNo=").append("'").append(prpCmainOriginDto.getPolicyNo()).append("'");
      logger.debug(debugBuffer.toString());
    }

    buffer.append("WHERE ");
    buffer.append("PolicyNo = ?");

    this.dbManager.prepareStatement(buffer.toString());

    int index = 1;
    this.dbManager.setString(index++, prpCmainOriginDto.getClassCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getRiskCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getProposalNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getContractNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getPolicySort());
    this.dbManager.setString(index++, prpCmainOriginDto.getPrintNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessNature());
    this.dbManager.setString(index++, prpCmainOriginDto.getLanguage());
    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyType());

    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyBizType());

    this.dbManager.setString(index++, prpCmainOriginDto.getAppliCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getAppliName());
    this.dbManager.setString(index++, prpCmainOriginDto.getAppliAddress());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredName());
    this.dbManager.setString(index++, prpCmainOriginDto.getInsuredAddress());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getOperateDate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getStartDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getStartHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getEndDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getEndHour());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getPureRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDiscount());
    this.dbManager.setString(index++, prpCmainOriginDto.getCurrency());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumValue());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumAmount());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumDiscount());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumPremium());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumSubPrem());
    this.dbManager.setLong(index++, prpCmainOriginDto.getSumQuantity());
    this.dbManager.setString(index++, prpCmainOriginDto.getJUDICALCODE());
    this.dbManager.setString(index++, prpCmainOriginDto.getJudicalScope());
    this.dbManager.setString(index++, prpCmainOriginDto.getAutoTransRenewFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getArgueSolution());
    this.dbManager.setString(index++, prpCmainOriginDto.getArbitBoardName());
    this.dbManager.setLong(index++, prpCmainOriginDto.getPayTimes());
    this.dbManager.setLong(index++, prpCmainOriginDto.getEndorseTimes());
    this.dbManager.setLong(index++, prpCmainOriginDto.getClaimTimes());
    this.dbManager.setString(index++, prpCmainOriginDto.getMakeCom());
    this.dbManager.setString(index++, prpCmainOriginDto.getOperateSite());
    this.dbManager.setString(index++, prpCmainOriginDto.getComCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getHandlerCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getHandler1Code());
    this.dbManager.setString(index++, prpCmainOriginDto.getApproverCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteName());
    this.dbManager.setString(index++, prpCmainOriginDto.getOperatorCode());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getInputDate());
    this.dbManager.setLong(index++, prpCmainOriginDto.getInputHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderWriteEndDate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUnderwritestartdate());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getStatisticsYM());
    this.dbManager.setString(index++, prpCmainOriginDto.getAgentCode());
    this.dbManager.setString(index++, prpCmainOriginDto.getCoinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getReinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getAllinsFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getUnderWriteFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getOthFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getFlag());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getDisRate1());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getPayMode());
    this.dbManager.setString(index++, prpCmainOriginDto.getUpdaterCode());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getUpdateDate());
    this.dbManager.setString(index++, prpCmainOriginDto.getUpdateHour());
    this.dbManager.setDateTime(index++, prpCmainOriginDto.getSignDate());
    this.dbManager.setString(index++, prpCmainOriginDto.getShareHolderFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getAgreementNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getInquiryNo());
    this.dbManager.setString(index++, prpCmainOriginDto.getRemark());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getLimitamount());
    this.dbManager.setString(index++, prpCmainOriginDto.getThirdKnow());
    this.dbManager.setString(index++, prpCmainOriginDto.getNCarPerPflag());
    this.dbManager.setString(index++, prpCmainOriginDto.getBusinessYear());
    this.dbManager.setString(index++, prpCmainOriginDto.getMakeArea());
    this.dbManager.setString(index++, prpCmainOriginDto.getTopCommissionRate());
    this.dbManager.setString(index++, prpCmainOriginDto.getIntCommissionRate());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumNoTaxPremium());
    this.dbManager.setDouble(index++, prpCmainOriginDto.getSumTaxFee());
    this.dbManager.setString(index++, prpCmainOriginDto.getNotificationFlag());
    this.dbManager.setString(index++, prpCmainOriginDto.getInceptionFlag());

    this.dbManager.setString(index++, prpCmainOriginDto.getPolicyNo());

    this.dbManager.executePreparedUpdate();
  }

  public PrpCmainOriginDto findByPrimaryKey(String policyNo)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(200);

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

    buffer.append("PolicyBizType,");

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
    buffer.append("JUDICALCODE,");
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
    buffer.append("Underwritestartdate,");
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
    buffer.append("InquiryNo,");
    buffer.append("Remark, ");
    buffer.append("LimitAmount, ");
    buffer.append("ThirdKnow, ");
    buffer.append("nCarPerPflag ,");
    buffer.append("businessYear, ");
    buffer.append("makeArea, ");
    buffer.append("topCommisionRate, ");
    buffer.append("intCommisionRate, ");
    buffer.append("sumNoTaxPremium, ");
    buffer.append("sumTaxFee, ");
    buffer.append("notificationFlag, ");
    buffer.append("InceptionFlag ");
    buffer.append("FROM PrpCmainOriginTg ");
    if (logger.isDebugEnabled()) {
      StringBuffer debugBuffer = new StringBuffer(buffer.length() * 4);
      debugBuffer.append(buffer.toString());
      debugBuffer.append("WHERE ");
      debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("'");
      logger.debug(debugBuffer.toString());
    }

    buffer.append("WHERE ");
    buffer.append("PolicyNo = ?");

    this.dbManager.prepareStatement(buffer.toString());

    this.dbManager.setString(1, policyNo);
    ResultSet resultSet = this.dbManager.executePreparedQuery();
    PrpCmainOriginDto prpCmainOriginDto = null;
    if (resultSet.next()) {
      int index = 1;
      prpCmainOriginDto = new PrpCmainOriginDto();
      prpCmainOriginDto.setPolicyNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setClassCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setRiskCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setProposalNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setContractNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPolicySort(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPrintNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setBusinessNature(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setLanguage(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPolicyType(this.dbManager.getString(resultSet, index++));

      prpCmainOriginDto.setPolicyBizType(this.dbManager.getString(resultSet, index++));

      prpCmainOriginDto.setAppliCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAppliName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAppliAddress(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredAddress(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperateDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStartDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStartHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setEndDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setEndHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setPureRate(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setDisRate(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setDiscount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setCurrency(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSumValue(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumAmount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumDiscount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumPremium(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumSubPrem(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumQuantity(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setJUDICALCODE(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setJudicalScope(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAutoTransRenewFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setArgueSolution(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setArbitBoardName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPayTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setEndorseTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setClaimTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setMakeCom(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperateSite(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setComCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setHandlerCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setHandler1Code(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setApproverCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperatorCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInputDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setInputHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setUnderWriteEndDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setUnderwritestartdate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStatisticsYM(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setAgentCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setCoinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setReinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAllinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOthFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setDisRate1(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setBusinessFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPayMode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUpdaterCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUpdateDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setUpdateHour(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSignDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setShareHolderFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAgreementNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInquiryNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setRemark(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setLimitamount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setThirdKnow(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setNCarPerPflag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setBusinessYear(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setMakeArea(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setTopCommissionRate(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setIntCommissionRate(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSumNoTaxPremium(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumTaxFee(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setNotificationFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInceptionFlag(this.dbManager.getString(resultSet, index++));
    }
    resultSet.close();
    return prpCmainOriginDto;
  }

  public Collection findByConditions(String conditions, int pageNo, int rowsPerPage)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(200);

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

    buffer.append("PolicyBizType,");

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
    buffer.append("JUDICALCODE,");
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
    buffer.append("Underwritestartdate,");
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
    buffer.append("InquiryNo,");
    buffer.append("Remark, ");
    buffer.append("LimitAmount, ");
    buffer.append("ThirdKnow, ");
    buffer.append("nCarPerPflag, ");
    buffer.append("businessYear, ");
    buffer.append("makeArea, ");
    buffer.append("topCommisionRate, ");
    buffer.append("intCommisionRate,");
    buffer.append("sumNoTaxPremium, ");
    buffer.append("sumTaxFee, ");
    buffer.append("notificationFlag, ");
    buffer.append("InceptionFlag ");
    buffer.append("FROM PrpCmainOriginTg WHERE ");
    buffer.append(conditions);
    if (logger.isDebugEnabled()) {
      logger.debug(buffer.toString());
    }
    ResultSet resultSet = this.dbManager.executeQuery(buffer.toString());
    int count = 0;
    if (pageNo > 1) {
      this.dbManager.locate(resultSet, rowsPerPage * (pageNo - 1));
    }

    Collection collection = new ArrayList(rowsPerPage);
    PrpCmainOriginDto prpCmainOriginDto = null;
    while (resultSet.next()) {
      count++;
      if ((pageNo > 0) && 
        (count > rowsPerPage))
      {
        break;
      }

      prpCmainOriginDto = new PrpCmainOriginDto();
      int index = 1;
      prpCmainOriginDto.setPolicyNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setClassCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setRiskCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setProposalNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setContractNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPolicySort(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPrintNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setBusinessNature(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setLanguage(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPolicyType(this.dbManager.getString(resultSet, index++));

      prpCmainOriginDto.setPolicyBizType(this.dbManager.getString(resultSet, index++));

      prpCmainOriginDto.setAppliCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAppliName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAppliAddress(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInsuredAddress(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperateDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStartDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStartHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setEndDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setEndHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setPureRate(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setDisRate(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setDiscount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setCurrency(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSumValue(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumAmount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumDiscount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumPremium(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumSubPrem(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumQuantity(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setJUDICALCODE(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setJudicalScope(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAutoTransRenewFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setArgueSolution(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setArbitBoardName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPayTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setEndorseTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setClaimTimes(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setMakeCom(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperateSite(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setComCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setHandlerCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setHandler1Code(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setApproverCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteName(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOperatorCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInputDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setInputHour(this.dbManager.getLong(resultSet, index++));
      prpCmainOriginDto.setUnderWriteEndDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setUnderwritestartdate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setStatisticsYM(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setAgentCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setCoinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setReinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAllinsFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUnderWriteFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setOthFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setDisRate1(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setBusinessFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setPayMode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUpdaterCode(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setUpdateDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setUpdateHour(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSignDate(this.dbManager.getDateTime(resultSet, 13, index++));
      prpCmainOriginDto.setShareHolderFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setAgreementNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInquiryNo(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setRemark(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setLimitamount(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setThirdKnow(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setNCarPerPflag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setBusinessYear(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setMakeArea(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setTopCommissionRate(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setTopCommissionRate(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setSumNoTaxPremium(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setSumTaxFee(this.dbManager.getDouble(resultSet, index++));
      prpCmainOriginDto.setNotificationFlag(this.dbManager.getString(resultSet, index++));
      prpCmainOriginDto.setInceptionFlag(this.dbManager.getString(resultSet, index++));
      collection.add(prpCmainOriginDto);
    }
    resultSet.close();
    return collection;
  }

  public Collection findByConditions(String conditions)
    throws Exception
  {
    return findByConditions(conditions, 0, 0);
  }

  public int deleteByConditions(String conditions)
    throws Exception
  {
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("DELETE FROM PrpCmainOriginTg WHERE ");
    buffer.append(conditions);
    if (logger.isDebugEnabled()) {
      logger.debug(buffer.toString());
    }
    int count = this.dbManager.executeUpdate(buffer.toString());
    return count;
  }

  public int getCount(String conditions)
    throws Exception
  {
    int count = -1;
    StringBuffer buffer = new StringBuffer(100);
    buffer.append("SELECT count(1) FROM PrpCmainOriginTg WHERE ");
    conditions = SqlUtils.getWherePartForGetCount(conditions);
    buffer.append(conditions);
    if (logger.isDebugEnabled()) {
      logger.debug(buffer.toString());
    }
    ResultSet resultSet = this.dbManager.executeQuery(buffer.toString());
    resultSet.next();
    count = this.dbManager.getInt(resultSet, 1);
    resultSet.close();
    return count;
  }
}