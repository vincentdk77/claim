package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpCreditInvest资信调查表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCreditInvestDtoBase implements Serializable{
    /** 属性风险预警号 */
    private String investigateNo = "";
    /** 属性确认函号 */
    private String confirmNo = "";
    /** 属性车险保单号 */
    private String carPolicyNo = "";
    /** 属性保证保险保单号 */
    private String carLoanPolicyNo = "";
    /** 属性投保人代码 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性投保人性质（自然人/法人） */
    private String appliNature = "";
    /** 属性投保人身份证号（组织机构代码） */
    private String appliID = "";
    /** 属性投保人配偶姓名 */
    private String appliSpouse = "";
    /** 属性投保人配偶身份证号 */
    private String appliSpouseID = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性被保险人组织机构代码 */
    private String insuredID = "";
    /** 属性担保人1代码 */
    private String warrantorCode1 = "";
    /** 属性担保人1名称 */
    private String warrantorName1 = "";
    /** 属性担保人1身份证号 */
    private String warrantorID1 = "";
    /** 属性担保人1配偶姓名 */
    private String warrantorSpouse1 = "";
    /** 属性担保人1配偶身份证号 */
    private String warrantorSpouseID1 = "";
    /** 属性担保人2代码 */
    private String warrantorCode2 = "";
    /** 属性担保人2名称 */
    private String warrantorName2 = "";
    /** 属性担保人2身份证号 */
    private String warrantorID2 = "";
    /** 属性担保人2配偶姓名 */
    private String warrantorSpouse2 = "";
    /** 属性担保人2配偶身份证号 */
    private String warrantorSpouseID2 = "";
    /** 属性汽车经销商代码 */
    private String carDealerCode = "";
    /** 属性汽车经销商名称 */
    private String carDealerName = "";
    /** 属性贷款金额 */
    private double loanAmount = 0d;
    /** 属性贷款利率 */
    private double loanRate = 0d;
    /** 属性贷款开始日期 */
    private DateTime loanStartDate = new DateTime();
    /** 属性贷款终止日期 */
    private DateTime loanEndDate = new DateTime();
    /** 属性贷款期限 */
    private double loanYear = 0d;
    /** 属性首付款金额 */
    private double firstPaid = 0d;
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类 */
    private String carKindCode = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性VIN号 */
    private String vINNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性车辆使用性质代码 */
    private String useNatureCode = "";
    /** 属性新车购置价 */
    private double purchasePrice = 0d;
    /** 属性资信调查人员（机构）代码 */
    private String creditManCode = "";
    /** 属性资信调查人员（机构）名称 */
    private String creditManName = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性审核人代码 */
    private String approverCode = "";
    /** 属性审核日期 */
    private DateTime approveDate = new DateTime();
    /** 属性审核意见 */
    private String approveNotion = "";
    /** 属性风险标志 */
    private String ventureFlag = "";
    /** 属性风险原因 */
    private String ventureReason = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCreditInvestDtoBase对象
     */
    public PrpCreditInvestDtoBase(){
    }

    /**
     * 设置属性风险预警号
     * @param investigateNo 待设置的属性风险预警号的值
     */
    public void setInvestigateNo(String investigateNo){
        this.investigateNo = StringUtils.rightTrim(investigateNo);
    }

    /**
     * 获取属性风险预警号
     * @return 属性风险预警号的值
     */
    public String getInvestigateNo(){
        return investigateNo;
    }

    /**
     * 设置属性确认函号
     * @param confirmNo 待设置的属性确认函号的值
     */
    public void setConfirmNo(String confirmNo){
        this.confirmNo = StringUtils.rightTrim(confirmNo);
    }

    /**
     * 获取属性确认函号
     * @return 属性确认函号的值
     */
    public String getConfirmNo(){
        return confirmNo;
    }

    /**
     * 设置属性车险保单号
     * @param carPolicyNo 待设置的属性车险保单号的值
     */
    public void setCarPolicyNo(String carPolicyNo){
        this.carPolicyNo = StringUtils.rightTrim(carPolicyNo);
    }

    /**
     * 获取属性车险保单号
     * @return 属性车险保单号的值
     */
    public String getCarPolicyNo(){
        return carPolicyNo;
    }

    /**
     * 设置属性保证保险保单号
     * @param carLoanPolicyNo 待设置的属性保证保险保单号的值
     */
    public void setCarLoanPolicyNo(String carLoanPolicyNo){
        this.carLoanPolicyNo = StringUtils.rightTrim(carLoanPolicyNo);
    }

    /**
     * 获取属性保证保险保单号
     * @return 属性保证保险保单号的值
     */
    public String getCarLoanPolicyNo(){
        return carLoanPolicyNo;
    }

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
     * 设置属性投保人性质（自然人/法人）
     * @param appliNature 待设置的属性投保人性质（自然人/法人）的值
     */
    public void setAppliNature(String appliNature){
        this.appliNature = StringUtils.rightTrim(appliNature);
    }

    /**
     * 获取属性投保人性质（自然人/法人）
     * @return 属性投保人性质（自然人/法人）的值
     */
    public String getAppliNature(){
        return appliNature;
    }

    /**
     * 设置属性投保人身份证号（组织机构代码）
     * @param appliID 待设置的属性投保人身份证号（组织机构代码）的值
     */
    public void setAppliID(String appliID){
        this.appliID = StringUtils.rightTrim(appliID);
    }

    /**
     * 获取属性投保人身份证号（组织机构代码）
     * @return 属性投保人身份证号（组织机构代码）的值
     */
    public String getAppliID(){
        return appliID;
    }

    /**
     * 设置属性投保人配偶姓名
     * @param appliSpouse 待设置的属性投保人配偶姓名的值
     */
    public void setAppliSpouse(String appliSpouse){
        this.appliSpouse = StringUtils.rightTrim(appliSpouse);
    }

    /**
     * 获取属性投保人配偶姓名
     * @return 属性投保人配偶姓名的值
     */
    public String getAppliSpouse(){
        return appliSpouse;
    }

    /**
     * 设置属性投保人配偶身份证号
     * @param appliSpouseID 待设置的属性投保人配偶身份证号的值
     */
    public void setAppliSpouseID(String appliSpouseID){
        this.appliSpouseID = StringUtils.rightTrim(appliSpouseID);
    }

    /**
     * 获取属性投保人配偶身份证号
     * @return 属性投保人配偶身份证号的值
     */
    public String getAppliSpouseID(){
        return appliSpouseID;
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
     * 设置属性被保险人组织机构代码
     * @param insuredID 待设置的属性被保险人组织机构代码的值
     */
    public void setInsuredID(String insuredID){
        this.insuredID = StringUtils.rightTrim(insuredID);
    }

    /**
     * 获取属性被保险人组织机构代码
     * @return 属性被保险人组织机构代码的值
     */
    public String getInsuredID(){
        return insuredID;
    }

    /**
     * 设置属性担保人1代码
     * @param warrantorCode1 待设置的属性担保人1代码的值
     */
    public void setWarrantorCode1(String warrantorCode1){
        this.warrantorCode1 = StringUtils.rightTrim(warrantorCode1);
    }

    /**
     * 获取属性担保人1代码
     * @return 属性担保人1代码的值
     */
    public String getWarrantorCode1(){
        return warrantorCode1;
    }

    /**
     * 设置属性担保人1名称
     * @param warrantorName1 待设置的属性担保人1名称的值
     */
    public void setWarrantorName1(String warrantorName1){
        this.warrantorName1 = StringUtils.rightTrim(warrantorName1);
    }

    /**
     * 获取属性担保人1名称
     * @return 属性担保人1名称的值
     */
    public String getWarrantorName1(){
        return warrantorName1;
    }

    /**
     * 设置属性担保人1身份证号
     * @param warrantorID1 待设置的属性担保人1身份证号的值
     */
    public void setWarrantorID1(String warrantorID1){
        this.warrantorID1 = StringUtils.rightTrim(warrantorID1);
    }

    /**
     * 获取属性担保人1身份证号
     * @return 属性担保人1身份证号的值
     */
    public String getWarrantorID1(){
        return warrantorID1;
    }

    /**
     * 设置属性担保人1配偶姓名
     * @param warrantorSpouse1 待设置的属性担保人1配偶姓名的值
     */
    public void setWarrantorSpouse1(String warrantorSpouse1){
        this.warrantorSpouse1 = StringUtils.rightTrim(warrantorSpouse1);
    }

    /**
     * 获取属性担保人1配偶姓名
     * @return 属性担保人1配偶姓名的值
     */
    public String getWarrantorSpouse1(){
        return warrantorSpouse1;
    }

    /**
     * 设置属性担保人1配偶身份证号
     * @param warrantorSpouseID1 待设置的属性担保人1配偶身份证号的值
     */
    public void setWarrantorSpouseID1(String warrantorSpouseID1){
        this.warrantorSpouseID1 = StringUtils.rightTrim(warrantorSpouseID1);
    }

    /**
     * 获取属性担保人1配偶身份证号
     * @return 属性担保人1配偶身份证号的值
     */
    public String getWarrantorSpouseID1(){
        return warrantorSpouseID1;
    }

    /**
     * 设置属性担保人2代码
     * @param warrantorCode2 待设置的属性担保人2代码的值
     */
    public void setWarrantorCode2(String warrantorCode2){
        this.warrantorCode2 = StringUtils.rightTrim(warrantorCode2);
    }

    /**
     * 获取属性担保人2代码
     * @return 属性担保人2代码的值
     */
    public String getWarrantorCode2(){
        return warrantorCode2;
    }

    /**
     * 设置属性担保人2名称
     * @param warrantorName2 待设置的属性担保人2名称的值
     */
    public void setWarrantorName2(String warrantorName2){
        this.warrantorName2 = StringUtils.rightTrim(warrantorName2);
    }

    /**
     * 获取属性担保人2名称
     * @return 属性担保人2名称的值
     */
    public String getWarrantorName2(){
        return warrantorName2;
    }

    /**
     * 设置属性担保人2身份证号
     * @param warrantorID2 待设置的属性担保人2身份证号的值
     */
    public void setWarrantorID2(String warrantorID2){
        this.warrantorID2 = StringUtils.rightTrim(warrantorID2);
    }

    /**
     * 获取属性担保人2身份证号
     * @return 属性担保人2身份证号的值
     */
    public String getWarrantorID2(){
        return warrantorID2;
    }

    /**
     * 设置属性担保人2配偶姓名
     * @param warrantorSpouse2 待设置的属性担保人2配偶姓名的值
     */
    public void setWarrantorSpouse2(String warrantorSpouse2){
        this.warrantorSpouse2 = StringUtils.rightTrim(warrantorSpouse2);
    }

    /**
     * 获取属性担保人2配偶姓名
     * @return 属性担保人2配偶姓名的值
     */
    public String getWarrantorSpouse2(){
        return warrantorSpouse2;
    }

    /**
     * 设置属性担保人2配偶身份证号
     * @param warrantorSpouseID2 待设置的属性担保人2配偶身份证号的值
     */
    public void setWarrantorSpouseID2(String warrantorSpouseID2){
        this.warrantorSpouseID2 = StringUtils.rightTrim(warrantorSpouseID2);
    }

    /**
     * 获取属性担保人2配偶身份证号
     * @return 属性担保人2配偶身份证号的值
     */
    public String getWarrantorSpouseID2(){
        return warrantorSpouseID2;
    }

    /**
     * 设置属性汽车经销商代码
     * @param carDealerCode 待设置的属性汽车经销商代码的值
     */
    public void setCarDealerCode(String carDealerCode){
        this.carDealerCode = StringUtils.rightTrim(carDealerCode);
    }

    /**
     * 获取属性汽车经销商代码
     * @return 属性汽车经销商代码的值
     */
    public String getCarDealerCode(){
        return carDealerCode;
    }

    /**
     * 设置属性汽车经销商名称
     * @param carDealerName 待设置的属性汽车经销商名称的值
     */
    public void setCarDealerName(String carDealerName){
        this.carDealerName = StringUtils.rightTrim(carDealerName);
    }

    /**
     * 获取属性汽车经销商名称
     * @return 属性汽车经销商名称的值
     */
    public String getCarDealerName(){
        return carDealerName;
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
     * 设置属性贷款利率
     * @param loanRate 待设置的属性贷款利率的值
     */
    public void setLoanRate(double loanRate){
        this.loanRate = loanRate;
    }

    /**
     * 获取属性贷款利率
     * @return 属性贷款利率的值
     */
    public double getLoanRate(){
        return loanRate;
    }

    /**
     * 设置属性贷款开始日期
     * @param loanStartDate 待设置的属性贷款开始日期的值
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * 获取属性贷款开始日期
     * @return 属性贷款开始日期的值
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * 设置属性贷款终止日期
     * @param loanEndDate 待设置的属性贷款终止日期的值
     */
    public void setLoanEndDate(DateTime loanEndDate){
        this.loanEndDate = loanEndDate;
    }

    /**
     * 获取属性贷款终止日期
     * @return 属性贷款终止日期的值
     */
    public DateTime getLoanEndDate(){
        return loanEndDate;
    }

    /**
     * 设置属性贷款期限
     * @param loanYear 待设置的属性贷款期限的值
     */
    public void setLoanYear(double loanYear){
        this.loanYear = loanYear;
    }

    /**
     * 获取属性贷款期限
     * @return 属性贷款期限的值
     */
    public double getLoanYear(){
        return loanYear;
    }

    /**
     * 设置属性首付款金额
     * @param firstPaid 待设置的属性首付款金额的值
     */
    public void setFirstPaid(double firstPaid){
        this.firstPaid = firstPaid;
    }

    /**
     * 获取属性首付款金额
     * @return 属性首付款金额的值
     */
    public double getFirstPaid(){
        return firstPaid;
    }

    /**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * 设置属性车辆种类
     * @param carKindCode 待设置的属性车辆种类的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类
     * @return 属性车辆种类的值
     */
    public String getCarKindCode(){
        return carKindCode;
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
     * 设置属性VIN号
     * @param vINNo 待设置的属性VIN号的值
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * 获取属性VIN号
     * @return 属性VIN号的值
     */
    public String getVINNo(){
        return vINNo;
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
     * 设置属性车辆使用性质代码
     * @param useNatureCode 待设置的属性车辆使用性质代码的值
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * 获取属性车辆使用性质代码
     * @return 属性车辆使用性质代码的值
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * 设置属性新车购置价
     * @param purchasePrice 待设置的属性新车购置价的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性新车购置价
     * @return 属性新车购置价的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性资信调查人员（机构）代码
     * @param creditManCode 待设置的属性资信调查人员（机构）代码的值
     */
    public void setCreditManCode(String creditManCode){
        this.creditManCode = StringUtils.rightTrim(creditManCode);
    }

    /**
     * 获取属性资信调查人员（机构）代码
     * @return 属性资信调查人员（机构）代码的值
     */
    public String getCreditManCode(){
        return creditManCode;
    }

    /**
     * 设置属性资信调查人员（机构）名称
     * @param creditManName 待设置的属性资信调查人员（机构）名称的值
     */
    public void setCreditManName(String creditManName){
        this.creditManName = StringUtils.rightTrim(creditManName);
    }

    /**
     * 获取属性资信调查人员（机构）名称
     * @return 属性资信调查人员（机构）名称的值
     */
    public String getCreditManName(){
        return creditManName;
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
     * 设置属性输入日期
     * @param inputDate 待设置的属性输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入日期
     * @return 属性输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
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
     * 设置属性审核人代码
     * @param approverCode 待设置的属性审核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性审核人代码
     * @return 属性审核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性审核日期
     * @param approveDate 待设置的属性审核日期的值
     */
    public void setApproveDate(DateTime approveDate){
        this.approveDate = approveDate;
    }

    /**
     * 获取属性审核日期
     * @return 属性审核日期的值
     */
    public DateTime getApproveDate(){
        return approveDate;
    }

    /**
     * 设置属性审核意见
     * @param approveNotion 待设置的属性审核意见的值
     */
    public void setApproveNotion(String approveNotion){
        this.approveNotion = StringUtils.rightTrim(approveNotion);
    }

    /**
     * 获取属性审核意见
     * @return 属性审核意见的值
     */
    public String getApproveNotion(){
        return approveNotion;
    }

    /**
     * 设置属性风险标志
     * @param ventureFlag 待设置的属性风险标志的值
     */
    public void setVentureFlag(String ventureFlag){
        this.ventureFlag = StringUtils.rightTrim(ventureFlag);
    }

    /**
     * 获取属性风险标志
     * @return 属性风险标志的值
     */
    public String getVentureFlag(){
        return ventureFlag;
    }

    /**
     * 设置属性风险原因
     * @param ventureReason 待设置的属性风险原因的值
     */
    public void setVentureReason(String ventureReason){
        this.ventureReason = StringUtils.rightTrim(ventureReason);
    }

    /**
     * 获取属性风险原因
     * @return 属性风险原因的值
     */
    public String getVentureReason(){
        return ventureReason;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
