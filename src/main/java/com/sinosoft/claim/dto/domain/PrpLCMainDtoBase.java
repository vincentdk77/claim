package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLCMain-代赔保单主表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCMainDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码2 */
    private String riskCode = "";
    /** 属性业务来源 */
    private String businessNature = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性投保人地址 */
    private String appliAddress = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性被保险人地址 */
    private String insuredAddress = "";
    /** 属性签单日期 */
    private DateTime operateDate = new DateTime();
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保险金额(折算为人民币) */
    private double sumAmount = 0d;
    /** 属性总保险费(折算为人民币) */
    private double sumPremium = 0d;
    /** 属性争议解决方式--** 1 诉讼；2 仲裁 */
    private String argueSolution = "";
    /** 属性仲裁委员会名称 */
    private String arbitBoardName = "";
    /** 属性约定分期交费次数 */
    private int payTimes = 0;
    /** 属性批改次数 */
    private int endorseTimes = 0;
    /** 属性出险次数 */
    private int registTimes = 0;
    /** 属性赔付次数 */
    private int claimTimes = 0;
    /** 属性赔付金额 */
    private double sumClaim = 0d;
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性计算机输单小时 */
    private int inputHour = 0;
    /** 属性状态字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLCMainDtoBase对象
     */
    public PrpLCMainDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性险种代码2
     * @param riskCode 待设置的属性险种代码2的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码2
     * @return 属性险种代码2的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性签单日期
     * @param operateDate 待设置的属性签单日期的值
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性签单日期
     * @return 属性签单日期的值
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
     * 设置属性总保险金额(折算为人民币)
     * @param sumAmount 待设置的属性总保险金额(折算为人民币)的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性总保险金额(折算为人民币)
     * @return 属性总保险金额(折算为人民币)的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性总保险费(折算为人民币)
     * @param sumPremium 待设置的属性总保险费(折算为人民币)的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性总保险费(折算为人民币)
     * @return 属性总保险费(折算为人民币)的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性争议解决方式--** 1 诉讼；2 仲裁
     * @param argueSolution 待设置的属性争议解决方式--** 1 诉讼；2 仲裁的值
     */
    public void setArgueSolution(String argueSolution){
        this.argueSolution = StringUtils.rightTrim(argueSolution);
    }

    /**
     * 获取属性争议解决方式--** 1 诉讼；2 仲裁
     * @return 属性争议解决方式--** 1 诉讼；2 仲裁的值
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
     * 设置属性出险次数
     * @param registTimes 待设置的属性出险次数的值
     */
    public void setRegistTimes(int registTimes){
        this.registTimes = registTimes;
    }

    /**
     * 获取属性出险次数
     * @return 属性出险次数的值
     */
    public int getRegistTimes(){
        return registTimes;
    }

    /**
     * 设置属性赔付次数
     * @param claimTimes 待设置的属性赔付次数的值
     */
    public void setClaimTimes(int claimTimes){
        this.claimTimes = claimTimes;
    }

    /**
     * 获取属性赔付次数
     * @return 属性赔付次数的值
     */
    public int getClaimTimes(){
        return claimTimes;
    }

    /**
     * 设置属性赔付金额
     * @param sumClaim 待设置的属性赔付金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性赔付金额
     * @return 属性赔付金额的值
     */
    public double getSumClaim(){
        return sumClaim;
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
}
