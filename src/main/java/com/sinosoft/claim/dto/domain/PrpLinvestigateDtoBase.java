package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLinvestigate-案情调查信息表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLinvestigateDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论 */
    private String objectType = "";
    /** 属性被调查人姓名 */
    private String informantName = "";
    /** 属性被调查人身份 */
    private String informantStatus = "";
    /** 属性调查对象名称 */
    private String objectName = "";
    /** 属性调查对象单位 */
    private String objectUnit = "";
    /** 属性调查对象地址 */
    private String objectAddress = "";
    /** 属性调查对象电话 */
    private String objectPhone = "";
    /** 属性调查对象年收入 */
    private double yearIncome = 0d;
    /** 属性调查对象身份证号码 */
    private String identifyNumber = "";
    /** 属性调查对象营业执照号码 */
    private String businessCode = "";
    /** 属性贷款金额 */
    private double loanAmount = 0d;
    /** 属性还款金额 */
    private double sumRePaid = 0d;
    /** 属性尚欠金额 */
    private double arrearageCorpus = 0d;
    /** 属性最后还款日期 */
    private DateTime lastRepaidDate = new DateTime();
    /** 属性欠款时间 */
    private DateTime arrearageDate = new DateTime();
    /** 属性牌照号码 */
    private String licenseNo = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性车辆价格 */
    private double purchasePrice = 0d;
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性车辆用途 */
    private String useNature = "";
    /** 属性购车日期 */
    private DateTime purchaseDate = new DateTime();
    /** 属性初次登记日期 */
    private DateTime enrollDate = new DateTime();
    /** 属性抵押登记单位 */
    private String inpawnEnrollDept = "";
    /** 属性抵押登记日期 */
    private DateTime inpawnEnrollDate = new DateTime();
    /** 属性抵押物名称 */
    private String guarantyName = "";
    /** 属性抵押物是否收回(Y/N) */
    private String guarantyRetractFlg = "";
    /** 属性抵押物估价 */
    private double guarantyAssessment = 0d;
    /** 属性售车款收取方式--** 1.一次性收取
--** 2.银行代收 */
    private String gatheringWay = "";
    /** 属性欠款原因代码 */
    private String arrearReasonCode = "";
    /** 属性欠款原因 */
    private String arrearReasonName = "";
    /** 属性调查情况 */
    private String remark = "";
    /** 属性调查结论 */
    private String conclution = "";
    /** 属性调查者 */
    private String investigator = "";
    /** 属性调查时间 */
    private DateTime investigateDate = new DateTime();
    /** 属性标记 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinvestigateDtoBase对象
     */
    public PrpLinvestigateDtoBase(){
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
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @param objectType 待设置的属性调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论的值
     */
    public void setObjectType(String objectType){
        this.objectType = StringUtils.rightTrim(objectType);
    }

    /**
     * 获取属性调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论
     * @return 属性调查对象类型
--** 1.被保人
--** 2.购车人
--** 3.贷款车辆
--** 4.担保人
--** 5.售车商
--** 6.其他方
--** 7.调查结论的值
     */
    public String getObjectType(){
        return objectType;
    }

    /**
     * 设置属性被调查人姓名
     * @param informantName 待设置的属性被调查人姓名的值
     */
    public void setInformantName(String informantName){
        this.informantName = StringUtils.rightTrim(informantName);
    }

    /**
     * 获取属性被调查人姓名
     * @return 属性被调查人姓名的值
     */
    public String getInformantName(){
        return informantName;
    }

    /**
     * 设置属性被调查人身份
     * @param informantStatus 待设置的属性被调查人身份的值
     */
    public void setInformantStatus(String informantStatus){
        this.informantStatus = StringUtils.rightTrim(informantStatus);
    }

    /**
     * 获取属性被调查人身份
     * @return 属性被调查人身份的值
     */
    public String getInformantStatus(){
        return informantStatus;
    }

    /**
     * 设置属性调查对象名称
     * @param objectName 待设置的属性调查对象名称的值
     */
    public void setObjectName(String objectName){
        this.objectName = StringUtils.rightTrim(objectName);
    }

    /**
     * 获取属性调查对象名称
     * @return 属性调查对象名称的值
     */
    public String getObjectName(){
        return objectName;
    }

    /**
     * 设置属性调查对象单位
     * @param objectUnit 待设置的属性调查对象单位的值
     */
    public void setObjectUnit(String objectUnit){
        this.objectUnit = StringUtils.rightTrim(objectUnit);
    }

    /**
     * 获取属性调查对象单位
     * @return 属性调查对象单位的值
     */
    public String getObjectUnit(){
        return objectUnit;
    }

    /**
     * 设置属性调查对象地址
     * @param objectAddress 待设置的属性调查对象地址的值
     */
    public void setObjectAddress(String objectAddress){
        this.objectAddress = StringUtils.rightTrim(objectAddress);
    }

    /**
     * 获取属性调查对象地址
     * @return 属性调查对象地址的值
     */
    public String getObjectAddress(){
        return objectAddress;
    }

    /**
     * 设置属性调查对象电话
     * @param objectPhone 待设置的属性调查对象电话的值
     */
    public void setObjectPhone(String objectPhone){
        this.objectPhone = StringUtils.rightTrim(objectPhone);
    }

    /**
     * 获取属性调查对象电话
     * @return 属性调查对象电话的值
     */
    public String getObjectPhone(){
        return objectPhone;
    }

    /**
     * 设置属性调查对象年收入
     * @param yearIncome 待设置的属性调查对象年收入的值
     */
    public void setYearIncome(double yearIncome){
        this.yearIncome = yearIncome;
    }

    /**
     * 获取属性调查对象年收入
     * @return 属性调查对象年收入的值
     */
    public double getYearIncome(){
        return yearIncome;
    }

    /**
     * 设置属性调查对象身份证号码
     * @param identifyNumber 待设置的属性调查对象身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性调查对象身份证号码
     * @return 属性调查对象身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性调查对象营业执照号码
     * @param businessCode 待设置的属性调查对象营业执照号码的值
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * 获取属性调查对象营业执照号码
     * @return 属性调查对象营业执照号码的值
     */
    public String getBusinessCode(){
        return businessCode;
    }

    /**
     * 设置属性贷款金额
     * @param loanAmount 待设置的属性贷款金额的值
     */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * 获取属性贷款金额
     * @return 属性贷款金额的值
     */
    public double getLoanAmount(){
        return loanAmount;
    }

    /**
     * 设置属性还款金额
     * @param sumRePaid 待设置的属性还款金额的值
     */
    public void setSumRePaid(double sumRePaid){
        this.sumRePaid = sumRePaid;
    }

    /**
     * 获取属性还款金额
     * @return 属性还款金额的值
     */
    public double getSumRePaid(){
        return sumRePaid;
    }

    /**
     * 设置属性尚欠金额
     * @param arrearageCorpus 待设置的属性尚欠金额的值
     */
    public void setArrearageCorpus(double arrearageCorpus){
        this.arrearageCorpus = arrearageCorpus;
    }

    /**
     * 获取属性尚欠金额
     * @return 属性尚欠金额的值
     */
    public double getArrearageCorpus(){
        return arrearageCorpus;
    }

    /**
     * 设置属性最后还款日期
     * @param lastRepaidDate 待设置的属性最后还款日期的值
     */
    public void setLastRepaidDate(DateTime lastRepaidDate){
        this.lastRepaidDate = lastRepaidDate;
    }

    /**
     * 获取属性最后还款日期
     * @return 属性最后还款日期的值
     */
    public DateTime getLastRepaidDate(){
        return lastRepaidDate;
    }

    /**
     * 设置属性欠款时间
     * @param arrearageDate 待设置的属性欠款时间的值
     */
    public void setArrearageDate(DateTime arrearageDate){
        this.arrearageDate = arrearageDate;
    }

    /**
     * 获取属性欠款时间
     * @return 属性欠款时间的值
     */
    public DateTime getArrearageDate(){
        return arrearageDate;
    }

    /**
     * 设置属性牌照号码
     * @param licenseNo 待设置的属性牌照号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性牌照号码
     * @return 属性牌照号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性厂牌型号
     * @param brandName 待设置的属性厂牌型号的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * 获取属性厂牌型号
     * @return 属性厂牌型号的值
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * 设置属性车辆价格
     * @param purchasePrice 待设置的属性车辆价格的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性车辆价格
     * @return 属性车辆价格的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性发动机号
     * @param engineNo 待设置的属性发动机号的值
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * 获取属性发动机号
     * @return 属性发动机号的值
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * 设置属性车架号
     * @param frameNo 待设置的属性车架号的值
     */
    public void setFrameNo(String frameNo){
        this.frameNo = StringUtils.rightTrim(frameNo);
    }

    /**
     * 获取属性车架号
     * @return 属性车架号的值
     */
    public String getFrameNo(){
        return frameNo;
    }

    /**
     * 设置属性车辆用途
     * @param useNature 待设置的属性车辆用途的值
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * 获取属性车辆用途
     * @return 属性车辆用途的值
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * 设置属性购车日期
     * @param purchaseDate 待设置的属性购车日期的值
     */
    public void setPurchaseDate(DateTime purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    /**
     * 获取属性购车日期
     * @return 属性购车日期的值
     */
    public DateTime getPurchaseDate(){
        return purchaseDate;
    }

    /**
     * 设置属性初次登记日期
     * @param enrollDate 待设置的属性初次登记日期的值
     */
    public void setEnrollDate(DateTime enrollDate){
        this.enrollDate = enrollDate;
    }

    /**
     * 获取属性初次登记日期
     * @return 属性初次登记日期的值
     */
    public DateTime getEnrollDate(){
        return enrollDate;
    }

    /**
     * 设置属性抵押登记单位
     * @param inpawnEnrollDept 待设置的属性抵押登记单位的值
     */
    public void setInpawnEnrollDept(String inpawnEnrollDept){
        this.inpawnEnrollDept = StringUtils.rightTrim(inpawnEnrollDept);
    }

    /**
     * 获取属性抵押登记单位
     * @return 属性抵押登记单位的值
     */
    public String getInpawnEnrollDept(){
        return inpawnEnrollDept;
    }

    /**
     * 设置属性抵押登记日期
     * @param inpawnEnrollDate 待设置的属性抵押登记日期的值
     */
    public void setInpawnEnrollDate(DateTime inpawnEnrollDate){
        this.inpawnEnrollDate = inpawnEnrollDate;
    }

    /**
     * 获取属性抵押登记日期
     * @return 属性抵押登记日期的值
     */
    public DateTime getInpawnEnrollDate(){
        return inpawnEnrollDate;
    }

    /**
     * 设置属性抵押物名称
     * @param guarantyName 待设置的属性抵押物名称的值
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * 获取属性抵押物名称
     * @return 属性抵押物名称的值
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * 设置属性抵押物是否收回(Y/N)
     * @param guarantyRetractFlg 待设置的属性抵押物是否收回(Y/N)的值
     */
    public void setGuarantyRetractFlg(String guarantyRetractFlg){
        this.guarantyRetractFlg = StringUtils.rightTrim(guarantyRetractFlg);
    }

    /**
     * 获取属性抵押物是否收回(Y/N)
     * @return 属性抵押物是否收回(Y/N)的值
     */
    public String getGuarantyRetractFlg(){
        return guarantyRetractFlg;
    }

    /**
     * 设置属性抵押物估价
     * @param guarantyAssessment 待设置的属性抵押物估价的值
     */
    public void setGuarantyAssessment(double guarantyAssessment){
        this.guarantyAssessment = guarantyAssessment;
    }

    /**
     * 获取属性抵押物估价
     * @return 属性抵押物估价的值
     */
    public double getGuarantyAssessment(){
        return guarantyAssessment;
    }

    /**
     * 设置属性售车款收取方式--** 1.一次性收取
--** 2.银行代收
     * @param gatheringWay 待设置的属性售车款收取方式--** 1.一次性收取
--** 2.银行代收的值
     */
    public void setGatheringWay(String gatheringWay){
        this.gatheringWay = StringUtils.rightTrim(gatheringWay);
    }

    /**
     * 获取属性售车款收取方式--** 1.一次性收取
--** 2.银行代收
     * @return 属性售车款收取方式--** 1.一次性收取
--** 2.银行代收的值
     */
    public String getGatheringWay(){
        return gatheringWay;
    }

    /**
     * 设置属性欠款原因代码
     * @param arrearReasonCode 待设置的属性欠款原因代码的值
     */
    public void setArrearReasonCode(String arrearReasonCode){
        this.arrearReasonCode = StringUtils.rightTrim(arrearReasonCode);
    }

    /**
     * 获取属性欠款原因代码
     * @return 属性欠款原因代码的值
     */
    public String getArrearReasonCode(){
        return arrearReasonCode;
    }

    /**
     * 设置属性欠款原因
     * @param arrearReasonName 待设置的属性欠款原因的值
     */
    public void setArrearReasonName(String arrearReasonName){
        this.arrearReasonName = StringUtils.rightTrim(arrearReasonName);
    }

    /**
     * 获取属性欠款原因
     * @return 属性欠款原因的值
     */
    public String getArrearReasonName(){
        return arrearReasonName;
    }

    /**
     * 设置属性调查情况
     * @param remark 待设置的属性调查情况的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性调查情况
     * @return 属性调查情况的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性调查结论
     * @param conclution 待设置的属性调查结论的值
     */
    public void setConclution(String conclution){
        this.conclution = StringUtils.rightTrim(conclution);
    }

    /**
     * 获取属性调查结论
     * @return 属性调查结论的值
     */
    public String getConclution(){
        return conclution;
    }

    /**
     * 设置属性调查者
     * @param investigator 待设置的属性调查者的值
     */
    public void setInvestigator(String investigator){
        this.investigator = StringUtils.rightTrim(investigator);
    }

    /**
     * 获取属性调查者
     * @return 属性调查者的值
     */
    public String getInvestigator(){
        return investigator;
    }

    /**
     * 设置属性调查时间
     * @param investigateDate 待设置的属性调查时间的值
     */
    public void setInvestigateDate(DateTime investigateDate){
        this.investigateDate = investigateDate;
    }

    /**
     * 获取属性调查时间
     * @return 属性调查时间的值
     */
    public DateTime getInvestigateDate(){
        return investigateDate;
    }

    /**
     * 设置属性标记
     * @param flag 待设置的属性标记的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标记
     * @return 属性标记的值
     */
    public String getFlag(){
        return flag;
    }
}
