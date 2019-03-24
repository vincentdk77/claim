package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLprepay-预赔登记表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLprepaytgDtoBase implements Serializable{
    /** 属性预赔登记号 */
    private String preCompensateNo = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性逾期欠款期数  DAD */
    private int arrearageTimes = 0;
    /** 属性逾期欠款金额  DAD */
    private double sumArrearage = 0d;
    /** 属性已预（垫）付金额 */
    private double sumBeforePrePaid = 0d;
    /** 属性本次垫付逾期欠款期数 DAD */
    private int blockUpTimes = 0;
    /** 属性预赔金额 */
    private double sumPrePaid = 0d;
    /** 属性总预（垫）付金额 = SumBeforePrePaid+SumPrepaid */
    private double sumTotalPrepaid = 0d;
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
    /** 属性核赔标志
--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔) */
    private String underWriteFlag = "";
    /** 属性标志字段
--** [1]：是否转入收付费系统 */
    private String flag = "";
    /** 属性特殊赔案类型 */
    private String caseType = "";
    /** 车险平台上传序号**/
    private String uploadSerialNo = "";
    /** 实付时间**/
    private DateTime payRefDate = new DateTime();
    /** 预付费用**/
    private double sumPreChargePaid = 0d;
    /**
     *  默认构造方法,构造一个默认的PrpLprepaytgDtoBase对象
     */
    public PrpLprepaytgDtoBase(){
    }

    /**
     * 设置属性预赔登记号
     * @param preCompensateNo 待设置的属性预赔登记号的值
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * 获取属性预赔登记号
     * @return 属性预赔登记号的值
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
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
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性逾期欠款期数  DAD
     * @param arrearageTimes 待设置的属性逾期欠款期数  DAD的值
     */
    public void setArrearageTimes(int arrearageTimes){
        this.arrearageTimes = arrearageTimes;
    }

    /**
     * 获取属性逾期欠款期数  DAD
     * @return 属性逾期欠款期数  DAD的值
     */
    public int getArrearageTimes(){
        return arrearageTimes;
    }

    /**
     * 设置属性逾期欠款金额  DAD
     * @param sumArrearage 待设置的属性逾期欠款金额  DAD的值
     */
    public void setSumArrearage(double sumArrearage){
        this.sumArrearage = sumArrearage;
    }

    /**
     * 获取属性逾期欠款金额  DAD
     * @return 属性逾期欠款金额  DAD的值
     */
    public double getSumArrearage(){
        return sumArrearage;
    }

    /**
     * 设置属性已预（垫）付金额
     * @param sumBeforePrePaid 待设置的属性已预（垫）付金额的值
     */
    public void setSumBeforePrePaid(double sumBeforePrePaid){
        this.sumBeforePrePaid = sumBeforePrePaid;
    }

    /**
     * 获取属性已预（垫）付金额
     * @return 属性已预（垫）付金额的值
     */
    public double getSumBeforePrePaid(){
        return sumBeforePrePaid;
    }

    /**
     * 设置属性本次垫付逾期欠款期数 DAD
     * @param blockUpTimes 待设置的属性本次垫付逾期欠款期数 DAD的值
     */
    public void setBlockUpTimes(int blockUpTimes){
        this.blockUpTimes = blockUpTimes;
    }

    /**
     * 获取属性本次垫付逾期欠款期数 DAD
     * @return 属性本次垫付逾期欠款期数 DAD的值
     */
    public int getBlockUpTimes(){
        return blockUpTimes;
    }

    /**
     * 设置属性预赔金额
     * @param sumPrePaid 待设置的属性预赔金额的值
     */
    public void setSumPrePaid(double sumPrePaid){
        this.sumPrePaid = sumPrePaid;
    }

    /**
     * 获取属性预赔金额
     * @return 属性预赔金额的值
     */
    public double getSumPrePaid(){
        return sumPrePaid;
    }

    /**
     * 设置属性总预（垫）付金额 = SumBeforePrePaid+SumPrepaid
     * @param sumTotalPrepaid 待设置的属性总预（垫）付金额 = SumBeforePrePaid+SumPrepaid的值
     */
    public void setSumTotalPrepaid(double sumTotalPrepaid){
        this.sumTotalPrepaid = sumTotalPrepaid;
    }

    /**
     * 获取属性总预（垫）付金额 = SumBeforePrePaid+SumPrepaid
     * @return 属性总预（垫）付金额 = SumBeforePrePaid+SumPrepaid的值
     */
    public double getSumTotalPrepaid(){
        return sumTotalPrepaid;
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
     * 设置属性核赔标志
--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)
     * @param underWriteFlag 待设置的属性核赔标志
--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性核赔标志
--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)
     * @return 属性核赔标志
--** (0初始值/1通过/2不通过/3 无需核赔 9待核赔)的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * 设置属性标志字段
--** [1]：是否转入收付费系统
     * @param flag 待设置的属性标志字段
--** [1]：是否转入收付费系统的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
--** [1]：是否转入收付费系统
     * @return 属性标志字段
--** [1]：是否转入收付费系统的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性特殊赔案类型
     * @param caseType 待设置的属性特殊赔案类型的值
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * 获取属性特殊赔案类型
     * @return 属性特殊赔案类型的值
     */
    public String getCaseType(){
        return caseType;
    }

	public String getUploadSerialNo() {
		return uploadSerialNo;
	}

	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}

	public DateTime getPayRefDate() {
		return payRefDate;
	}

	public void setPayRefDate(DateTime payRefDate) {
		this.payRefDate = payRefDate;
	}

	public double getSumPreChargePaid() {
		return sumPreChargePaid;
	}

	public void setSumPreChargePaid(double sumPreChargePaid) {
		this.sumPreChargePaid = sumPreChargePaid;
	}
    
    
}
