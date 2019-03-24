package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPCMAIN-保单基本信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpCmainDtoBase implements Serializable{

    private static final int serialVersionUID = PrpCmainDtoBase.class.getName().hashCode();
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性投保单号 */
    private String proposalNo = "";
    /** 属性合同号 */
    private String contractNo = "";
    /** 属性保单种类 */
    private String policySort = "";
    /** 属性保单印刷号 */
    private String printNo = "";
    /** 属性业务来源 */
    private String businessNature = "";
    /** 属性语种标志 */
    private String language = "";
    /** 属性保单类型 */
    private String policyType = "";
  
    //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
    /** 属性保单业务类型 （01：政策性农业险、02：商业性农业险、03：涉农险、04：非农险）*/
    private String policyBizType = "";
    //modified by zengzhu 2007-11-15 end
    
    /** 属性投保人代码 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性投保人地址 */
    private String appliAddress = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性被保险人地址 */
    private String insuredAddress = "";
    /** 属性签单日期/投保日期 */
    private DateTime operateDate = new DateTime();
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性净费率 */
    private double pureRate = 0D;
    /** 属性手续费比例 */
    private double disRate = 0D;
    /** 属性总折扣率 */
    private double discount = 0D;
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保险价值 */
    private double sumValue = 0D;
    /** 属性总保险金额 */
    private double sumAmount = 0D;
    /** 属性总折扣金额 */
    private double sumDiscount = 0D;
    /** 属性总保险费 */
    private double sumPremium = 0D;
    /** 属性总附加险保费 */
    private double sumSubPrem = 0D;
    /** 属性被保险总数量 */
    private int sumQuantity = 0;
    /** 属性司法管辖代码 */
    private String judicalCode = "";
    /** 属性司法管辖 */
    private String judicalScope = "";
    /** 属性交费方式 */
    private String autoTransRenewFlag = "";
    /** 属性争议解决方式 */
    private String argueSolution = "";
    /** 属性仲裁委员会名称 */
    private String arbitBoardName = "";
    /** 属性约定分期交费次数 */
    private int payTimes = 0;
    /** 属性批改次数 */
    private int endorseTimes = 0;
    /** 属性理赔次数 */
    private int claimTimes = 0;
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性签单地点 */
    private String operateSite = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性最终核保人代码 */
    private String underWriteCode = "";
    /** 属性最终核保人名称 */
    private String underWriteName = "";
    /** 属性操作员代码/第一次录入人员代码 */
    private String operatorCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性计算机输单小时 */
    private int inputHour = 0;
    /** 属性核保完成日期 */
    private DateTime underWriteEndDate = new DateTime();
    /** 属性保单统计年月 */
    private DateTime statisticsYM = new DateTime();
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性共保标志 */
    private String coinsFlag = "";
    /** 属性商业分保标志 */
    private String reinsFlag = "";
    /** 属性统保标志 */
    private String allinsFlag = "";
    /** 属性核保标志 */
    private String underWriteFlag = "";
    /** 属性其它标志字段 */
    private String othFlag = "";
    /** 属性状态字段 */
    private String flag = "";
    /** 属性超出部分手续费比例 */
    private double disRate1 = 0D;
    /** 属性业务类型 */
    private String businessFlag = "";
    /** 属性缴费方式 */
    private String payMode = "";
    /** 属性最后一次修改人员代码 */
    private String updaterCode = "";
    /** 属性最后一次修改日期 */
    private DateTime updateDate = new DateTime();
    /** 属性最后一次修改时间 */
    private String updateHour = "";
    /** 属性签单日期 */
    private DateTime signDate = new DateTime();
    /** 属性是否股东业务标识 */
    private String shareHolderFlag = "";
    /** 属性协议号 */
    private String agreementNo = "";
    /** 属性询价单号 */
    private String inquiryNo = "";
    /**大户归属区域*/
    private String RichFlyAreasCode = "";
    /**大户归属区域名称*/
    private String RichFlyAreasCName = "";
    /**大户编码*/
    private String RichFlyCode = "";
    /**大户名称*/
    private String RichFlyCName = "";
    /** 大病医疗专项业务类型*/
    private String bigMedicalType = "";

    
	
	/**
     *  默认构造方法,构造一个默认的PrpCmainDtoBase对象
     */
    public PrpCmainDtoBase(){
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
     * 设置属性投保单号
     * @param proposalNo 待设置的属性投保单号的值
     */
    public void setProposalNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * 获取属性投保单号
     * @return 属性投保单号的值
     */
    public String getProposalNo(){
        return proposalNo;
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
     * 设置属性保单种类
     * @param policySort 待设置的属性保单种类的值
     */
    public void setPolicySort(String policySort){
        this.policySort = StringUtils.rightTrim(policySort);
    }

    /**
     * 获取属性保单种类
     * @return 属性保单种类的值
     */
    public String getPolicySort(){
        return policySort;
    }

    /**
     * 设置属性保单印刷号
     * @param printNo 待设置的属性保单印刷号的值
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * 获取属性保单印刷号
     * @return 属性保单印刷号的值
     */
    public String getPrintNo(){
        return printNo;
    }

    /**
     * 设置属性业务来源
     * @param businessNature 待设置的属性业务来源的值
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * 获取属性业务来源
     * @return 属性业务来源的值
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * 设置属性语种标志
     * @param language 待设置的属性语种标志的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性语种标志
     * @return 属性语种标志的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性保单类型
     * @param policyType 待设置的属性保单类型的值
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * 获取属性保单类型
     * @return 属性保单类型的值
     */
    public String getPolicyType(){
        return policyType;
    }
    
    //modified by zengzhu 2007-11-15 begin reason：统计用的保单农险标志需求，为保单添加一个保单业务类型字段 PolicyBizType
    
    public String getPolicyBizType() {
		return policyBizType;
	}

	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}
	//modified by zengzhu 2007-11-15 end
	

    /**
     * 设置属性投保人代码
     * @param appliCode 待设置的属性投保人代码的值
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * 获取属性投保人代码
     * @return 属性投保人代码的值
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
     * 设置属性投保人地址
     * @param appliAddress 待设置的属性投保人地址的值
     */
    public void setAppliAddress(String appliAddress){
        this.appliAddress = StringUtils.rightTrim(appliAddress);
    }

    /**
     * 获取属性投保人地址
     * @return 属性投保人地址的值
     */
    public String getAppliAddress(){
        return appliAddress;
    }

    /**
     * 设置属性被保险人代码
     * @param insuredCode 待设置的属性被保险人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人代码
     * @return 属性被保险人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保险人名称
     * @param insuredName 待设置的属性被保险人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性被保险人地址
     * @param insuredAddress 待设置的属性被保险人地址的值
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * 获取属性被保险人地址
     * @return 属性被保险人地址的值
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * 设置属性签单日期/投保日期
     * @param operateDate 待设置的属性签单日期/投保日期的值
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性签单日期/投保日期
     * @return 属性签单日期/投保日期的值
     */
    public DateTime getOperateDate(){
        return operateDate;
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
     * 设置属性起保小时
     * @param startHour 待设置的属性起保小时的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性起保小时
     * @return 属性起保小时的值
     */
    public int getStartHour(){
        return startHour;
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
     * 设置属性终保小时
     * @param endHour 待设置的属性终保小时的值
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * 获取属性终保小时
     * @return 属性终保小时的值
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * 设置属性净费率
     * @param pureRate 待设置的属性净费率的值
     */
    public void setPureRate(double pureRate){
        this.pureRate = pureRate;
    }

    /**
     * 获取属性净费率
     * @return 属性净费率的值
     */
    public double getPureRate(){
        return pureRate;
    }

    /**
     * 设置属性手续费比例
     * @param disRate 待设置的属性手续费比例的值
     */
    public void setDisRate(double disRate){
        this.disRate = disRate;
    }

    /**
     * 获取属性手续费比例
     * @return 属性手续费比例的值
     */
    public double getDisRate(){
        return disRate;
    }

    /**
     * 设置属性总折扣率
     * @param discount 待设置的属性总折扣率的值
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * 获取属性总折扣率
     * @return 属性总折扣率的值
     */
    public double getDiscount(){
        return discount;
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
     * 设置属性总保险价值
     * @param sumValue 待设置的属性总保险价值的值
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * 获取属性总保险价值
     * @return 属性总保险价值的值
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * 设置属性总保险金额
     * @param sumAmount 待设置的属性总保险金额的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性总保险金额
     * @return 属性总保险金额的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性总折扣金额
     * @param sumDiscount 待设置的属性总折扣金额的值
     */
    public void setSumDiscount(double sumDiscount){
        this.sumDiscount = sumDiscount;
    }

    /**
     * 获取属性总折扣金额
     * @return 属性总折扣金额的值
     */
    public double getSumDiscount(){
        return sumDiscount;
    }

    /**
     * 设置属性总保险费
     * @param sumPremium 待设置的属性总保险费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性总保险费
     * @return 属性总保险费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性总附加险保费
     * @param sumSubPrem 待设置的属性总附加险保费的值
     */
    public void setSumSubPrem(double sumSubPrem){
        this.sumSubPrem = sumSubPrem;
    }

    /**
     * 获取属性总附加险保费
     * @return 属性总附加险保费的值
     */
    public double getSumSubPrem(){
        return sumSubPrem;
    }

    /**
     * 设置属性被保险总数量
     * @param sumQuantity 待设置的属性被保险总数量的值
     */
    public void setSumQuantity(int sumQuantity){
        this.sumQuantity = sumQuantity;
    }

    /**
     * 获取属性被保险总数量
     * @return 属性被保险总数量的值
     */
    public int getSumQuantity(){
        return sumQuantity;
    }

    /**
     * 设置属性司法管辖代码
     * @param judicalCode 待设置的属性司法管辖代码的值
     */
    public void setJudicalCode(String judicalCode){
        this.judicalCode = StringUtils.rightTrim(judicalCode);
    }

    /**
     * 获取属性司法管辖代码
     * @return 属性司法管辖代码的值
     */
    public String getJudicalCode(){
        return judicalCode;
    }

    /**
     * 设置属性司法管辖
     * @param judicalScope 待设置的属性司法管辖的值
     */
    public void setJudicalScope(String judicalScope){
        this.judicalScope = StringUtils.rightTrim(judicalScope);
    }

    /**
     * 获取属性司法管辖
     * @return 属性司法管辖的值
     */
    public String getJudicalScope(){
        return judicalScope;
    }

    /**
     * 设置属性交费方式
     * @param autoTransRenewFlag 待设置的属性交费方式的值
     */
    public void setAutoTransRenewFlag(String autoTransRenewFlag){
        this.autoTransRenewFlag = StringUtils.rightTrim(autoTransRenewFlag);
    }

    /**
     * 获取属性交费方式
     * @return 属性交费方式的值
     */
    public String getAutoTransRenewFlag(){
        return autoTransRenewFlag;
    }

    /**
     * 设置属性争议解决方式
     * @param argueSolution 待设置的属性争议解决方式的值
     */
    public void setArgueSolution(String argueSolution){
        this.argueSolution = StringUtils.rightTrim(argueSolution);
    }

    /**
     * 获取属性争议解决方式
     * @return 属性争议解决方式的值
     */
    public String getArgueSolution(){
        return argueSolution;
    }

    /**
     * 设置属性仲裁委员会名称
     * @param arbitBoardName 待设置的属性仲裁委员会名称的值
     */
    public void setArbitBoardName(String arbitBoardName){
        this.arbitBoardName = StringUtils.rightTrim(arbitBoardName);
    }

    /**
     * 获取属性仲裁委员会名称
     * @return 属性仲裁委员会名称的值
     */
    public String getArbitBoardName(){
        return arbitBoardName;
    }

    /**
     * 设置属性约定分期交费次数
     * @param payTimes 待设置的属性约定分期交费次数的值
     */
    public void setPayTimes(int payTimes){
        this.payTimes = payTimes;
    }

    /**
     * 获取属性约定分期交费次数
     * @return 属性约定分期交费次数的值
     */
    public int getPayTimes(){
        return payTimes;
    }

    /**
     * 设置属性批改次数
     * @param endorseTimes 待设置的属性批改次数的值
     */
    public void setEndorseTimes(int endorseTimes){
        this.endorseTimes = endorseTimes;
    }

    /**
     * 获取属性批改次数
     * @return 属性批改次数的值
     */
    public int getEndorseTimes(){
        return endorseTimes;
    }

    /**
     * 设置属性理赔次数
     * @param claimTimes 待设置的属性理赔次数的值
     */
    public void setClaimTimes(int claimTimes){
        this.claimTimes = claimTimes;
    }

    /**
     * 获取属性理赔次数
     * @return 属性理赔次数的值
     */
    public int getClaimTimes(){
        return claimTimes;
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
     * 设置属性签单地点
     * @param operateSite 待设置的属性签单地点的值
     */
    public void setOperateSite(String operateSite){
        this.operateSite = StringUtils.rightTrim(operateSite);
    }

    /**
     * 获取属性签单地点
     * @return 属性签单地点的值
     */
    public String getOperateSite(){
        return operateSite;
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
     * 设置属性复核人代码
     * @param approverCode 待设置的属性复核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核人代码
     * @return 属性复核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性最终核保人代码
     * @param underWriteCode 待设置的属性最终核保人代码的值
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * 获取属性最终核保人代码
     * @return 属性最终核保人代码的值
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * 设置属性最终核保人名称
     * @param underWriteName 待设置的属性最终核保人名称的值
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * 获取属性最终核保人名称
     * @return 属性最终核保人名称的值
     */
    public String getUnderWriteName(){
        return underWriteName;
    }

    /**
     * 设置属性操作员代码/第一次录入人员代码
     * @param operatorCode 待设置的属性操作员代码/第一次录入人员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码/第一次录入人员代码
     * @return 属性操作员代码/第一次录入人员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性计算机输单小时
     * @param inputHour 待设置的属性计算机输单小时的值
     */
    public void setInputHour(int inputHour){
        this.inputHour = inputHour;
    }

    /**
     * 获取属性计算机输单小时
     * @return 属性计算机输单小时的值
     */
    public int getInputHour(){
        return inputHour;
    }

    /**
     * 设置属性核保完成日期
     * @param underWriteEndDate 待设置的属性核保完成日期的值
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * 获取属性核保完成日期
     * @return 属性核保完成日期的值
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * 设置属性保单统计年月
     * @param statisticsYM 待设置的属性保单统计年月的值
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * 获取属性保单统计年月
     * @return 属性保单统计年月的值
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
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
     * 设置属性共保标志
     * @param coinsFlag 待设置的属性共保标志的值
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = StringUtils.rightTrim(coinsFlag);
    }

    /**
     * 获取属性共保标志
     * @return 属性共保标志的值
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }

    /**
     * 设置属性商业分保标志
     * @param reinsFlag 待设置的属性商业分保标志的值
     */
    public void setReinsFlag(String reinsFlag){
        this.reinsFlag = StringUtils.rightTrim(reinsFlag);
    }

    /**
     * 获取属性商业分保标志
     * @return 属性商业分保标志的值
     */
    public String getReinsFlag(){
        return reinsFlag;
    }

    /**
     * 设置属性统保标志
     * @param allinsFlag 待设置的属性统保标志的值
     */
    public void setAllinsFlag(String allinsFlag){
        this.allinsFlag = StringUtils.rightTrim(allinsFlag);
    }

    /**
     * 获取属性统保标志
     * @return 属性统保标志的值
     */
    public String getAllinsFlag(){
        return allinsFlag;
    }

    /**
     * 设置属性核保标志
     * @param underWriteFlag 待设置的属性核保标志的值
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * 获取属性核保标志
     * @return 属性核保标志的值
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * 设置属性其它标志字段
     * @param othFlag 待设置的属性其它标志字段的值
     */
    public void setOthFlag(String othFlag){
        this.othFlag = StringUtils.rightTrim(othFlag);
    }

    /**
     * 获取属性其它标志字段
     * @return 属性其它标志字段的值
     */
    public String getOthFlag(){
        return othFlag;
    }

    /**
     * 设置属性状态字段
     * @param flag 待设置的属性状态字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性状态字段
     * @return 属性状态字段的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性超出部分手续费比例
     * @param disRate1 待设置的属性超出部分手续费比例的值
     */
    public void setDisRate1(double disRate1){
        this.disRate1 = disRate1;
    }

    /**
     * 获取属性超出部分手续费比例
     * @return 属性超出部分手续费比例的值
     */
    public double getDisRate1(){
        return disRate1;
    }

    /**
     * 设置属性业务类型
     * @param businessFlag 待设置的属性业务类型的值
     */
    public void setBusinessFlag(String businessFlag){
        this.businessFlag = StringUtils.rightTrim(businessFlag);
    }

    /**
     * 获取属性业务类型
     * @return 属性业务类型的值
     */
    public String getBusinessFlag(){
        return businessFlag;
    }

    /**
     * 设置属性缴费方式
     * @param payMode 待设置的属性缴费方式的值
     */
    public void setPayMode(String payMode){
        this.payMode = StringUtils.rightTrim(payMode);
    }

    /**
     * 获取属性缴费方式
     * @return 属性缴费方式的值
     */
    public String getPayMode(){
        return payMode;
    }

    /**
     * 设置属性最后一次修改人员代码
     * @param updaterCode 待设置的属性最后一次修改人员代码的值
     */
    public void setUpdaterCode(String updaterCode){
        this.updaterCode = StringUtils.rightTrim(updaterCode);
    }

    /**
     * 获取属性最后一次修改人员代码
     * @return 属性最后一次修改人员代码的值
     */
    public String getUpdaterCode(){
        return updaterCode;
    }

    /**
     * 设置属性最后一次修改日期
     * @param updateDate 待设置的属性最后一次修改日期的值
     */
    public void setUpdateDate(DateTime updateDate){
        this.updateDate = updateDate;
    }

    /**
     * 获取属性最后一次修改日期
     * @return 属性最后一次修改日期的值
     */
    public DateTime getUpdateDate(){
        return updateDate;
    }

    /**
     * 设置属性最后一次修改时间
     * @param updateHour 待设置的属性最后一次修改时间的值
     */
    public void setUpdateHour(String updateHour){
        this.updateHour = StringUtils.rightTrim(updateHour);
    }

    /**
     * 获取属性最后一次修改时间
     * @return 属性最后一次修改时间的值
     */
    public String getUpdateHour(){
        return updateHour;
    }

    /**
     * 设置属性签单日期
     * @param signDate 待设置的属性签单日期的值
     */
    public void setSignDate(DateTime signDate){
        this.signDate = signDate;
    }

    /**
     * 获取属性签单日期
     * @return 属性签单日期的值
     */
    public DateTime getSignDate(){
        return signDate;
    }

    /**
     * 设置属性是否股东业务标识
     * @param shareHolderFlag 待设置的属性是否股东业务标识的值
     */
    public void setShareHolderFlag(String shareHolderFlag){
        this.shareHolderFlag = StringUtils.rightTrim(shareHolderFlag);
    }

    /**
     * 获取属性是否股东业务标识
     * @return 属性是否股东业务标识的值
     */
    public String getShareHolderFlag(){
        return shareHolderFlag;
    }

    /**
     * 设置属性协议号
     * @param agreementNo 待设置的属性协议号的值
     */
    public void setAgreementNo(String agreementNo){
        this.agreementNo = StringUtils.rightTrim(agreementNo);
    }

    /**
     * 获取属性协议号
     * @return 属性协议号的值
     */
    public String getAgreementNo(){
        return agreementNo;
    }

    /**
     * 设置属性询价单号
     * @param inquiryNo 待设置的属性询价单号的值
     */
    public void setInquiryNo(String inquiryNo){
        this.inquiryNo = StringUtils.rightTrim(inquiryNo);
    }

    /**
     * 获取属性询价单号
     * @return 属性询价单号的值
     */
    public String getInquiryNo(){
        return inquiryNo;
    }

	public String getRichFlyAreasCode() {
		return RichFlyAreasCode;
	}

	public void setRichFlyAreasCode(String richFlyAreasCode) {
		RichFlyAreasCode = richFlyAreasCode;
	}

	public String getRichFlyAreasCName() {
		return RichFlyAreasCName;
	}

	public void setRichFlyAreasCName(String richFlyAreasCName) {
		RichFlyAreasCName = richFlyAreasCName;
	}

	public String getRichFlyCode() {
		return RichFlyCode;
	}

	public void setRichFlyCode(String richFlyCode) {
		RichFlyCode = richFlyCode;
	}

	public String getRichFlyCName() {
		return RichFlyCName;
	}

	public void setRichFlyCName(String richFlyCName) {
		RichFlyCName = richFlyCName;
	}

	public String getBigMedicalType() {
		return bigMedicalType;
	}

	public void setBigMedicalType(String bigMedicalType) {
		this.bigMedicalType = bigMedicalType;
	}

}
