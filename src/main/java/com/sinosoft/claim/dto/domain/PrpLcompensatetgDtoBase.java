
package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcompensate-赔款计算书表的数据传输对象基类<br>
 * 创建于 2005-05-26 09:04:12.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcompensatetgDtoBase implements Serializable{
    /** 属性赔款计算书号码 */
    private String compensateNo = "";
    /** 属性理赔类型(L-理赔 D-代理赔) */
    private String lFlag = "";
    /** 属性赔案号 */
    private String caseNo = "";
    /** 属性次数 */
    private int times = 0;
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性免赔条件字段 */
    private String deductCond = "";
    /** 属性终到日期 */
    private DateTime preserveDate = new DateTime();
    /** 属性理赔代理人代码 */
    private String checkAgentCode = "";
    /** 属性理赔代理人名称 */
    private String checkAgentName = "";
    /** 属性检验人名称 */
    private String surveyorName = "";
    /** 属性索赔人名称 */
    private String counterClaimerName = "";
    /** 属性航方责任 */
    private String dutyDescription = "";
    /** 属性币别代码(现存:CNY) */
    private String currency = "";
    /** 属性标的损失金额(同保单币别) */
    private double sumLoss = 0d;
    /** 属性损余金额(同保单币别) */
    private double sumRest = 0d;
    /** 属性责任赔款合计(同保单币别)
--** = PrpLloss表标的赔款合计
--** + PrpLcharge计入赔款的费用合计 */
    private double sumDutyPaid = 0d;
    /** 属性不计入赔款的费用金额(同保单币别) */
    private double sumNoDutyFee = 0d;
    /** 属性总赔付金额(同保单币别) */
    private double sumPaid = 0d;
    /** 属性已预付赔款(同保单币别)--** 第一张计算书
--** =SUM(PrpLprepay.SumPrePaid)
--** 第二张后金额=0 */
    private double sumPrePaid = 0d;
    /** 属性本次赔付金额（同保单币别）
--** = SumPaid-SumPrePaid */
    private double sumThisPaid = 0d;
    /** 属性领赔款单位/代理人/索赔人 */
    private String receiverName = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性银行帐号 */
    private String account = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性复核员代码 */
    private String approverCode = "";
    /** 属性最终核赔人代码 */
    private String underWriteCode = "";
    /** 属性最终核赔人名称 */
    private String underWriteName = "";
    /** 属性统计年月 */
    private DateTime statisticsYM = new DateTime();
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性计算机输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性核赔完成日期 */
    private DateTime underWriteEndDate = new DateTime();
    /** 属性核赔标志--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔) */
    private String underWriteFlag = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性案件性质 */
    private String caseType = "";
    /** 属性责任比例 */
    private double indemnityDutyRate = 0d;
    /** 属性赔偿责任代码 */
    private String indemnityDuty = "";
    /** 属性最终计算书标志 */
    private String finallyFlag = "";
    /** 理赔结论 */
    private String result = "";
    /** 车险平台上传序号 **/
    private String uploadSerialNo = "";
    /** 共保业务赔付类型 **/
    private String coinsPaidLossType = "";
    /** 共保业务赔付总金额 **/
    private double coinsSumPaid = 0d;
    
    //是否理赔公示
    private String claimNotification = "";
    //是否无公害化处理
    private String InncentTreatment = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpLcompensatetgDtoBase对象
     */
    public PrpLcompensatetgDtoBase(){
    }

    /**
     * 设置属性赔款计算书号码
     * @param compensateNo 待设置的属性赔款计算书号码的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号码
     * @return 属性赔款计算书号码的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性理赔类型(L-理赔 D-代理赔)
     * @param lFlag 待设置的属性理赔类型(L-理赔 D-代理赔)的值
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * 获取属性理赔类型(L-理赔 D-代理赔)
     * @return 属性理赔类型(L-理赔 D-代理赔)的值
     */
    public String getLFlag(){
        return lFlag;
    }

    /**
     * 设置属性赔案号
     * @param caseNo 待设置的属性赔案号的值
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getCaseNo(){
        return caseNo;
    }

    /**
     * 设置属性次数
     * @param times 待设置的属性次数的值
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * 获取属性次数
     * @return 属性次数的值
     */
    public int getTimes(){
        return times;
    }

    /**
     * 设置属性险类代码
     * @param classCode 待设置的属性险类代码的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类代码
     * @return 属性险类代码的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性免赔条件字段
     * @param deductCond 待设置的属性免赔条件字段的值
     */
    public void setDeductCond(String deductCond){
        this.deductCond = StringUtils.rightTrim(deductCond);
    }

    /**
     * 获取属性免赔条件字段
     * @return 属性免赔条件字段的值
     */
    public String getDeductCond(){
        return deductCond;
    }

    /**
     * 设置属性终到日期
     * @param preserveDate 待设置的属性终到日期的值
     */
    public void setPreserveDate(DateTime preserveDate){
        this.preserveDate = preserveDate;
    }

    /**
     * 获取属性终到日期
     * @return 属性终到日期的值
     */
    public DateTime getPreserveDate(){
        return preserveDate;
    }

    /**
     * 设置属性理赔代理人代码
     * @param checkAgentCode 待设置的属性理赔代理人代码的值
     */
    public void setCheckAgentCode(String checkAgentCode){
        this.checkAgentCode = StringUtils.rightTrim(checkAgentCode);
    }

    /**
     * 获取属性理赔代理人代码
     * @return 属性理赔代理人代码的值
     */
    public String getCheckAgentCode(){
        return checkAgentCode;
    }

    /**
     * 设置属性理赔代理人名称
     * @param checkAgentName 待设置的属性理赔代理人名称的值
     */
    public void setCheckAgentName(String checkAgentName){
        this.checkAgentName = StringUtils.rightTrim(checkAgentName);
    }

    /**
     * 获取属性理赔代理人名称
     * @return 属性理赔代理人名称的值
     */
    public String getCheckAgentName(){
        return checkAgentName;
    }

    /**
     * 设置属性检验人名称
     * @param surveyorName 待设置的属性检验人名称的值
     */
    public void setSurveyorName(String surveyorName){
        this.surveyorName = StringUtils.rightTrim(surveyorName);
    }

    /**
     * 获取属性检验人名称
     * @return 属性检验人名称的值
     */
    public String getSurveyorName(){
        return surveyorName;
    }

    /**
     * 设置属性索赔人名称
     * @param counterClaimerName 待设置的属性索赔人名称的值
     */
    public void setCounterClaimerName(String counterClaimerName){
        this.counterClaimerName = StringUtils.rightTrim(counterClaimerName);
    }

    /**
     * 获取属性索赔人名称
     * @return 属性索赔人名称的值
     */
    public String getCounterClaimerName(){
        return counterClaimerName;
    }

    /**
     * 设置属性航方责任
     * @param dutyDescription 待设置的属性航方责任的值
     */
    public void setDutyDescription(String dutyDescription){
        this.dutyDescription = StringUtils.rightTrim(dutyDescription);
    }

    /**
     * 获取属性航方责任
     * @return 属性航方责任的值
     */
    public String getDutyDescription(){
        return dutyDescription;
    }

    /**
     * 设置属性币别代码(现存:CNY)
     * @param currency 待设置的属性币别代码(现存:CNY)的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码(现存:CNY)
     * @return 属性币别代码(现存:CNY)的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性标的损失金额(同保单币别)
     * @param sumLoss 待设置的属性标的损失金额(同保单币别)的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性标的损失金额(同保单币别)
     * @return 属性标的损失金额(同保单币别)的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性损余金额(同保单币别)
     * @param sumRest 待设置的属性损余金额(同保单币别)的值
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * 获取属性损余金额(同保单币别)
     * @return 属性损余金额(同保单币别)的值
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * 设置属性责任赔款合计(同保单币别)
--** = PrpLloss表标的赔款合计
--** + PrpLcharge计入赔款的费用合计
     * @param sumDutyPaid 待设置的属性责任赔款合计(同保单币别)
--** = PrpLloss表标的赔款合计
--** + PrpLcharge计入赔款的费用合计的值
     */
    public void setSumDutyPaid(double sumDutyPaid){
        this.sumDutyPaid = sumDutyPaid;
    }

    /**
     * 获取属性责任赔款合计(同保单币别)
--** = PrpLloss表标的赔款合计
--** + PrpLcharge计入赔款的费用合计
     * @return 属性责任赔款合计(同保单币别)
--** = PrpLloss表标的赔款合计
--** + PrpLcharge计入赔款的费用合计的值
     */
    public double getSumDutyPaid(){
        return sumDutyPaid;
    }

    /**
     * 设置属性不计入赔款的费用金额(同保单币别)
     * @param sumNoDutyFee 待设置的属性不计入赔款的费用金额(同保单币别)的值
     */
    public void setSumNoDutyFee(double sumNoDutyFee){
        this.sumNoDutyFee = sumNoDutyFee;
    }

    /**
     * 获取属性不计入赔款的费用金额(同保单币别)
     * @return 属性不计入赔款的费用金额(同保单币别)的值
     */
    public double getSumNoDutyFee(){
        return sumNoDutyFee;
    }

    /**
     * 设置属性总赔付金额(同保单币别)
     * @param sumPaid 待设置的属性总赔付金额(同保单币别)的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性总赔付金额(同保单币别)
     * @return 属性总赔付金额(同保单币别)的值
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * 设置属性已预付赔款(同保单币别)--** 第一张计算书
--** =SUM(PrpLprepay.SumPrePaid)
--** 第二张后金额=0
     * @param sumPrePaid 待设置的属性已预付赔款(同保单币别)--** 第一张计算书
--** =SUM(PrpLprepay.SumPrePaid)
--** 第二张后金额=0的值
     */
    public void setSumPrePaid(double sumPrePaid){
        this.sumPrePaid = sumPrePaid;
    }

    /**
     * 获取属性已预付赔款(同保单币别)--** 第一张计算书
--** =SUM(PrpLprepay.SumPrePaid)
--** 第二张后金额=0
     * @return 属性已预付赔款(同保单币别)--** 第一张计算书
--** =SUM(PrpLprepay.SumPrePaid)
--** 第二张后金额=0的值
     */
    public double getSumPrePaid(){
        return sumPrePaid;
    }

    /**
     * 设置属性本次赔付金额（同保单币别）
--** = SumPaid-SumPrePaid
     * @param sumThisPaid 待设置的属性本次赔付金额（同保单币别）
--** = SumPaid-SumPrePaid的值
     */
    public void setSumThisPaid(double sumThisPaid){
        this.sumThisPaid = sumThisPaid;
    }

    /**
     * 获取属性本次赔付金额（同保单币别）
--** = SumPaid-SumPrePaid
     * @return 属性本次赔付金额（同保单币别）
--** = SumPaid-SumPrePaid的值
     */
    public double getSumThisPaid(){
        return sumThisPaid;
    }

    /**
     * 设置属性领赔款单位/代理人/索赔人
     * @param receiverName 待设置的属性领赔款单位/代理人/索赔人的值
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * 获取属性领赔款单位/代理人/索赔人
     * @return 属性领赔款单位/代理人/索赔人的值
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * 设置属性开户银行
     * @param bank 待设置的属性开户银行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户银行
     * @return 属性开户银行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性银行帐号
     * @param account 待设置的属性银行帐号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性银行帐号
     * @return 属性银行帐号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性出单机构
     * @param makeCom 待设置的属性出单机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性出单机构
     * @return 属性出单机构的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性归属业务员代码
     * @param handler1Code 待设置的属性归属业务员代码的值
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * 获取属性归属业务员代码
     * @return 属性归属业务员代码的值
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * 设置属性复核员代码
     * @param approverCode 待设置的属性复核员代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核员代码
     * @return 属性复核员代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性最终核赔人代码
     * @param underWriteCode 待设置的属性最终核赔人代码的值
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * 获取属性最终核赔人代码
     * @return 属性最终核赔人代码的值
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * 设置属性最终核赔人名称
     * @param underWriteName 待设置的属性最终核赔人名称的值
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * 获取属性最终核赔人名称
     * @return 属性最终核赔人名称的值
     */
    public String getUnderWriteName(){
        return underWriteName;
    }

    /**
     * 设置属性统计年月
     * @param statisticsYM 待设置的属性统计年月的值
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * 获取属性统计年月
     * @return 属性统计年月的值
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性计算机输入日期
     * @param inputDate 待设置的属性计算机输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输入日期
     * @return 属性计算机输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性核赔完成日期
     * @param underWriteEndDate 待设置的属性核赔完成日期的值
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * 获取属性核赔完成日期
     * @return 属性核赔完成日期的值
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * 设置属性核赔标志--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)
     * @param underWriteFlag 待设置的属性核赔标志--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性核赔标志--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)
     * @return 属性核赔标志--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性案件性质
     * @param caseType 待设置的属性案件性质的值
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * 获取属性案件性质
     * @return 属性案件性质的值
     */
    public String getCaseType(){
        return caseType;
    }

    /**
     * 设置属性责任比例
     * @param indemnityDutyRate 待设置的属性责任比例的值
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * 获取属性责任比例
     * @return 属性责任比例的值
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * 设置属性赔偿责任代码
     * @param indemnityDuty 待设置的属性赔偿责任代码的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性赔偿责任代码
     * @return 属性赔偿责任代码的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * 设置属性最终计算书标志
     * @param finallyFlag 待设置的属性最终计算书标志的值
     */
    public void setFinallyFlag(String finallyFlag){
        this.finallyFlag = StringUtils.rightTrim(finallyFlag);
    }

    /**
     * 获取属性最终计算书标志
     * @return 属性最终计算书标志的值
     */
    public String getFinallyFlag(){
        return finallyFlag;
    }
    /**
     * 设置理赔结论
     * @param result 理赔结论
     */
    
    public void setResult(String result){
        this.result = result;
    }

    /**
     * 获取理赔结论
     * @return 理赔结论
     */
    public String getResult(){
        return this.result;
    }

	public String getUploadSerialNo() {
		return uploadSerialNo;
	}

	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}
    /**
     * 获取属性共保业务赔付类型
     * @return 属性共保业务赔付类型
     */
	public String getCoinsPaidLossType() {
		return coinsPaidLossType;
	}
    /**
     * 设置属性共保业务赔付类型
     * @param finallyFlag 待设置的属性共保业务赔付类型
     */
	public void setCoinsPaidLossType(String coinsPaidLossType) {
		this.coinsPaidLossType = StringUtils.rightTrim(coinsPaidLossType);
	}
    /**
     * 获取属性共保业务赔付金额
     * @return 属性共保业务赔付金额
     */
	public double getCoinsSumPaid() {
		return coinsSumPaid;
	}
    /**
     * 设置属性共保业务赔付金额
     * @param finallyFlag 待设置的属性共保业务赔付金额
     */
	public void setCoinsSumPaid(double coinsSumPaid) {
		this.coinsSumPaid = coinsSumPaid;
	}

	/**
	 * @return the claimNotification
	 */
	public String getClaimNotification() {
		return claimNotification;
	}

	/**
	 * @param claimNotification the claimNotification to set
	 */
	public void setClaimNotification(String claimNotification) {
		this.claimNotification = claimNotification;
	}

	/**
	 * @return the inncentTreatment
	 */
	public String getInncentTreatment() {
		return InncentTreatment;
	}

	/**
	 * @param inncentTreatment the inncentTreatment to set
	 */
	public void setInncentTreatment(String inncentTreatment) {
		InncentTreatment = inncentTreatment;
	}
    
}
