package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是应收应付费信息表的数据传输对象基类<br>
 */
public class PrpJplanFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性业务类型 */
    private String certiType = "";
    /** 属性保单号码/批单号码 */
    private String certiNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性交费计划序号 */
    private int serialNo = 0;
    /** 属性收付原因 */
    private String payRefReason = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性险类 */
    private String classCode = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性合同号 */
    private String contractNo = "";
    /** 属性投保人 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性被保险人 */
    private String insuredCode = "";
    /** 属性被保人名称 */
    private String insuredName = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性批单生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性缴费期数 */
    private int payNo = 0;
    /** 属性应收币种 */
    private String currency1 = "";
    /** 属性应收应付金额 */
    private double planFee = 0D;
    /** 属性分期缴费日期 */
    private DateTime planDate = new DateTime();
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性业务归属人员 */
    private String handler1Code = "";
    /** 属性经办人 */
    private String handlerCode = "";
    /** 属性核保/赔日期 */
    private DateTime underWriteDate = new DateTime();
    /** 属性联共保标志 */
    private String coinsFlag = "";
    /** 属性联共保人代码 */
    private String coinsCode = "";
    /** 属性联共保人名称 */
    private String coinsName = "";
    /** 属性联共保类型 */
    private String coinsType = "";
    /** 属性核算单位 */
    private String centerCode = "";
    /** 属性基层单位 */
    private String branchCode = "";
    /** 属性帐套类型 */
    private String accBookType = "";
    /** 属性帐套代码 */
    private String accBookCode = "";
    /** 属性会计期间 */
    private String yearMonth = "";
    /** 属性凭证号 */
    private String voucherNo = "";
    /** 属性应收/应付汇率 */
    private double exchangeRate = 0D;
    /** 属性应收/应付进帐金额 */
    private double planFeeCNY = 0D;
    /** 属性收收/应付金额 */
    private double payRefFee = 0D;
    /** 属性收收/应付确认金额 */
    private double realPayRefFee = 0D;
    /** 属性预留标志 */
    private String flag = "";
    /** 属性业务渠道 */
    private String businessNature = "";
    /** 属性业务标志 */
    private String othFlag = "";
    /** 属性交强险车辆九大类类 */
    private String carNatureCode = "";
    /** 属性交强险九大类使用性质 */
    private String useNatureCode = "";
    /** 属性交强险九大类车的属性 */
    private double carProperty = 0D;
    private String payComCode = "";
    private String businessType = "";
    private String businessType1 = "";

    /**
     *  默认构造方法,构造一个默认的PrpJplanFeeDtoBase对象
     */
    public PrpJplanFeeDtoBase(){
    }

    /**
     * 设置属性业务类型
     * @param certiType 待设置的属性业务类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性保单号码/批单号码
     * @param certiNo 待设置的属性保单号码/批单号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性保单号码/批单号码
     * @return 属性保单号码/批单号码的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性交费计划序号
     * @param serialNo 待设置的属性交费计划序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性交费计划序号
     * @return 属性交费计划序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性收付原因
     * @param payRefReason 待设置的属性收付原因的值
     */
    public void setPayRefReason(String payRefReason){
        this.payRefReason = StringUtils.rightTrim(payRefReason);
    }

    /**
     * 获取属性收付原因
     * @return 属性收付原因的值
     */
    public String getPayRefReason(){
        return payRefReason;
    }

    /**
     * 设置属性立案号
     * @param claimNo 待设置的属性立案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性立案号
     * @return 属性立案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性险类
     * @param classCode 待设置的属性险类的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类
     * @return 属性险类的值
     */
    public String getClassCode(){
        return classCode;
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
     * 设置属性合同号
     * @param contractNo 待设置的属性合同号的值
     */
    public void setContractNo(String contractNo){
        this.contractNo = StringUtils.rightTrim(contractNo);
    }

    /**
     * 获取属性合同号
     * @return 属性合同号的值
     */
    public String getContractNo(){
        return contractNo;
    }

    /**
     * 设置属性投保人
     * @param appliCode 待设置的属性投保人的值
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * 获取属性投保人
     * @return 属性投保人的值
     */
    public String getAppliCode(){
        return appliCode;
    }

    /**
     * 设置属性投保人名称
     * @param appliName 待设置的属性投保人名称的值
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * 获取属性投保人名称
     * @return 属性投保人名称的值
     */
    public String getAppliName(){
        return appliName;
    }

    /**
     * 设置属性被保险人
     * @param insuredCode 待设置的属性被保险人的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人
     * @return 属性被保险人的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保人名称
     * @param insuredName 待设置的属性被保人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保人名称
     * @return 属性被保人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性起保日期
     * @param startDate 待设置的属性起保日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性起保日期
     * @return 属性起保日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * 设置属性批单生效日期
     * @param validDate 待设置的属性批单生效日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性批单生效日期
     * @return 属性批单生效日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性缴费期数
     * @param payNo 待设置的属性缴费期数的值
     */
    public void setPayNo(int payNo){
        this.payNo = payNo;
    }

    /**
     * 获取属性缴费期数
     * @return 属性缴费期数的值
     */
    public int getPayNo(){
        return payNo;
    }

    /**
     * 设置属性应收币种
     * @param currency1 待设置的属性应收币种的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性应收币种
     * @return 属性应收币种的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性应收应付金额
     * @param planFee 待设置的属性应收应付金额的值
     */
    public void setPlanFee(double planFee){
        this.planFee = planFee;
    }

    /**
     * 获取属性应收应付金额
     * @return 属性应收应付金额的值
     */
    public double getPlanFee(){
        return planFee;
    }

    /**
     * 设置属性分期缴费日期
     * @param planDate 待设置的属性分期缴费日期的值
     */
    public void setPlanDate(DateTime planDate){
        this.planDate = planDate;
    }

    /**
     * 获取属性分期缴费日期
     * @return 属性分期缴费日期的值
     */
    public DateTime getPlanDate(){
        return planDate;
    }

    /**
     * 设置属性归属机构
     * @param comCode 待设置的属性归属机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属机构
     * @return 属性归属机构的值
     */
    public String getComCode(){
        return comCode;
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
     * 设置属性代理人代码
     * @param agentCode 待设置的属性代理人代码的值
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * 获取属性代理人代码
     * @return 属性代理人代码的值
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * 设置属性业务归属人员
     * @param handler1Code 待设置的属性业务归属人员的值
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * 获取属性业务归属人员
     * @return 属性业务归属人员的值
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * 设置属性经办人
     * @param handlerCode 待设置的属性经办人的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人
     * @return 属性经办人的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性核保/赔日期
     * @param underWriteDate 待设置的属性核保/赔日期的值
     */
    public void setUnderWriteDate(DateTime underWriteDate){
        this.underWriteDate = underWriteDate;
    }

    /**
     * 获取属性核保/赔日期
     * @return 属性核保/赔日期的值
     */
    public DateTime getUnderWriteDate(){
        return underWriteDate;
    }

    /**
     * 设置属性联共保标志
     * @param coinsFlag 待设置的属性联共保标志的值
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = StringUtils.rightTrim(coinsFlag);
    }

    /**
     * 获取属性联共保标志
     * @return 属性联共保标志的值
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }

    /**
     * 设置属性联共保人代码
     * @param coinsCode 待设置的属性联共保人代码的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性联共保人代码
     * @return 属性联共保人代码的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性联共保人名称
     * @param coinsName 待设置的属性联共保人名称的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性联共保人名称
     * @return 属性联共保人名称的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性联共保类型
     * @param coinsType 待设置的属性联共保类型的值
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * 获取属性联共保类型
     * @return 属性联共保类型的值
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * 设置属性核算单位
     * @param centerCode 待设置的属性核算单位的值
     */
    public void setCenterCode(String centerCode){
        this.centerCode = StringUtils.rightTrim(centerCode);
    }

    /**
     * 获取属性核算单位
     * @return 属性核算单位的值
     */
    public String getCenterCode(){
        return centerCode;
    }

    /**
     * 设置属性基层单位
     * @param branchCode 待设置的属性基层单位的值
     */
    public void setBranchCode(String branchCode){
        this.branchCode = StringUtils.rightTrim(branchCode);
    }

    /**
     * 获取属性基层单位
     * @return 属性基层单位的值
     */
    public String getBranchCode(){
        return branchCode;
    }

    /**
     * 设置属性帐套类型
     * @param accBookType 待设置的属性帐套类型的值
     */
    public void setAccBookType(String accBookType){
        this.accBookType = StringUtils.rightTrim(accBookType);
    }

    /**
     * 获取属性帐套类型
     * @return 属性帐套类型的值
     */
    public String getAccBookType(){
        return accBookType;
    }

    /**
     * 设置属性帐套代码
     * @param accBookCode 待设置的属性帐套代码的值
     */
    public void setAccBookCode(String accBookCode){
        this.accBookCode = StringUtils.rightTrim(accBookCode);
    }

    /**
     * 获取属性帐套代码
     * @return 属性帐套代码的值
     */
    public String getAccBookCode(){
        return accBookCode;
    }

    /**
     * 设置属性会计期间
     * @param yearMonth 待设置的属性会计期间的值
     */
    public void setYearMonth(String yearMonth){
        this.yearMonth = StringUtils.rightTrim(yearMonth);
    }

    /**
     * 获取属性会计期间
     * @return 属性会计期间的值
     */
    public String getYearMonth(){
        return yearMonth;
    }

    /**
     * 设置属性凭证号
     * @param voucherNo 待设置的属性凭证号的值
     */
    public void setVoucherNo(String voucherNo){
        this.voucherNo = StringUtils.rightTrim(voucherNo);
    }

    /**
     * 获取属性凭证号
     * @return 属性凭证号的值
     */
    public String getVoucherNo(){
        return voucherNo;
    }

    /**
     * 设置属性应收/应付汇率
     * @param exchangeRate 待设置的属性应收/应付汇率的值
     */
    public void setExchangeRate(double exchangeRate){
        this.exchangeRate = exchangeRate;
    }

    /**
     * 获取属性应收/应付汇率
     * @return 属性应收/应付汇率的值
     */
    public double getExchangeRate(){
        return exchangeRate;
    }

    /**
     * 设置属性应收/应付进帐金额
     * @param planFeeCNY 待设置的属性应收/应付进帐金额的值
     */
    public void setPlanFeeCNY(double planFeeCNY){
        this.planFeeCNY = planFeeCNY;
    }

    /**
     * 获取属性应收/应付进帐金额
     * @return 属性应收/应付进帐金额的值
     */
    public double getPlanFeeCNY(){
        return planFeeCNY;
    }

    /**
     * 设置属性收收/应付金额
     * @param payRefFee 待设置的属性收收/应付金额的值
     */
    public void setPayRefFee(double payRefFee){
        this.payRefFee = payRefFee;
    }

    /**
     * 获取属性收收/应付金额
     * @return 属性收收/应付金额的值
     */
    public double getPayRefFee(){
        return payRefFee;
    }

    /**
     * 设置属性收收/应付确认金额
     * @param realPayRefFee 待设置的属性收收/应付确认金额的值
     */
    public void setRealPayRefFee(double realPayRefFee){
        this.realPayRefFee = realPayRefFee;
    }

    /**
     * 获取属性收收/应付确认金额
     * @return 属性收收/应付确认金额的值
     */
    public double getRealPayRefFee(){
        return realPayRefFee;
    }

    /**
     * 设置属性预留标志
     * @param flag 待设置的属性预留标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性预留标志
     * @return 属性预留标志的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性业务渠道
     * @param businessNautre 待设置的属性业务渠道的值
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * 获取属性业务渠道
     * @return 属性业务渠道的值
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * 设置属性业务标志
     * @param othFlag 待设置的属性业务标志的值
     */
    public void setOthFlag(String othFlag){
        this.othFlag = StringUtils.rightTrim(othFlag);
    }

    /**
     * 获取属性业务标志
     * @return 属性业务标志的值
     */
    public String getOthFlag(){
        return othFlag;
    }

    /**
     * 设置属性交强险车辆九大类类
     * @param carNatureCode 待设置的属性交强险车辆九大类类的值
     */
    public void setCarNatureCode(String carNatureCode){
        this.carNatureCode = StringUtils.rightTrim(carNatureCode);
    }

    /**
     * 获取属性交强险车辆九大类类
     * @return 属性交强险车辆九大类类的值
     */
    public String getCarNatureCode(){
        return carNatureCode;
    }

    /**
     * 设置属性交强险九大类使用性质
     * @param useNatureCode 待设置的属性交强险九大类使用性质的值
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * 获取属性交强险九大类使用性质
     * @return 属性交强险九大类使用性质的值
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * 设置属性交强险九大类车的属性
     * @param carProperty 待设置的属性交强险九大类车的属性的值
     */
    public void setCarProperty(double carProperty){
        this.carProperty = carProperty;
    }

    /**
     * 获取属性交强险九大类车的属性
     * @return 属性交强险九大类车的属性的值
     */
    public double getCarProperty(){
        return carProperty;
    }

	public String getPayComCode() {
		return payComCode;
	}

	public void setPayComCode(String payComCode) {
		this.payComCode = payComCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	

}
