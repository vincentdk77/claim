package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimLoss－立案险别估损金额表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性保单标的项目代码 */
    private String itemCode = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性估损金额 */
    private double sumClaim = 0D;
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性备注 */
    private String remarkFlag = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性要能分别出赔款还是直接理赔费用 */
    private String lossFeeType = "";
    /** 属性标的项目明细名称 */
    private String itemDetailName = "";
    /** 属性费用范围 */
    private String feeCategory = "";
    /** 属性险别损失 */
    private double kindLoss = 0D;
    /** 属性险别残值 */
    private double kindRest = 0D;
    /** 属性绝对免赔率 */
    private double deductibleRate = 0D;
    /** 属性绝对免赔额 */
    private double deductible = 0D;
    /** 属性事故责任免赔率 */
    private double acciDeductibleRate = 0D;
    /** 属性分户号 */
    private int familyNo = 0;
    /** 属性组合保险分户号 */
    private String familyNoZH = "";
    /** 属性分户名称 */
    private String familyName = "";
    /** 属性车辆编号 自行车第三者责任使用 */
    private String licenseNo = "";
    /** 属性赔付数量 */
    private String claimNumber = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimLossDtoBase对象
     */
    public PrpLclaimLossDtoBase(){
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
     * 设置属性标的子险序号
     * @param itemKindNo 待设置的属性标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的子险序号
     * @return 属性标的子险序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性保单标的项目代码
     * @param itemCode 待设置的属性保单标的项目代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性保单标的项目代码
     * @return 属性保单标的项目代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性估损金额
     * @param sumClaim 待设置的属性估损金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性估损金额
     * @return 属性估损金额的值
     */
    public double getSumClaim(){
        return sumClaim;
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
     * 设置属性备注
     * @param remarkFlag 待设置的属性备注的值
     */
    public void setRemarkFlag(String remarkFlag){
        this.remarkFlag = StringUtils.rightTrim(remarkFlag);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemarkFlag(){
        return remarkFlag;
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
     * 设置属性要能分别出赔款还是直接理赔费用
     * @param lossFeeType 待设置的属性要能分别出赔款还是直接理赔费用的值
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * 获取属性要能分别出赔款还是直接理赔费用
     * @return 属性要能分别出赔款还是直接理赔费用的值
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * 设置属性标的项目明细名称
     * @param itemDetailName 待设置的属性标的项目明细名称的值
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * 获取属性标的项目明细名称
     * @return 属性标的项目明细名称的值
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * 设置属性费用范围
     * @param feeCategory 待设置的属性费用范围的值
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * 获取属性费用范围
     * @return 属性费用范围的值
     */
    public String getFeeCategory(){
        return feeCategory;
    }

    /**
     * 设置属性险别损失
     * @param kindLoss 待设置的属性险别损失的值
     */
    public void setKindLoss(double kindLoss){
        this.kindLoss = kindLoss;
    }

    /**
     * 获取属性险别损失
     * @return 属性险别损失的值
     */
    public double getKindLoss(){
        return kindLoss;
    }

    /**
     * 设置属性险别残值
     * @param kindRest 待设置的属性险别残值的值
     */
    public void setKindRest(double kindRest){
        this.kindRest = kindRest;
    }

    /**
     * 获取属性险别残值
     * @return 属性险别残值的值
     */
    public double getKindRest(){
        return kindRest;
    }

    /**
     * 设置属性绝对免赔率
     * @param deductibleRate 待设置的属性绝对免赔率的值
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * 获取属性绝对免赔率
     * @return 属性绝对免赔率的值
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * 设置属性绝对免赔额
     * @param deductible 待设置的属性绝对免赔额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性绝对免赔额
     * @return 属性绝对免赔额的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性事故责任免赔率
     * @param acciDeductibleRate 待设置的属性事故责任免赔率的值
     */
    public void setAcciDeductibleRate(double acciDeductibleRate){
        this.acciDeductibleRate = acciDeductibleRate;
    }

    /**
     * 获取属性事故责任免赔率
     * @return 属性事故责任免赔率的值
     */
    public double getAcciDeductibleRate(){
        return acciDeductibleRate;
    }
    
    
    /**
     * 设置属性分户号
     * @param familyNO 待设置的属性分户号的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }
    /**
     * 获取属性分户号
     * @return 属性分户号的值
     */
    public int getFamilyNo(){
        return familyNo;
    }
    
    /**
     * 设置属性分户号
     * @param familyNO 待设置的属性分户号的值
     */
    public void setFamilyNoZH(String familyNoZH){
        this.familyNoZH = familyNoZH;
    }
    /**
     * 获取属性分户号
     * @return 属性分户号的值
     */
    public String getFamilyNoZH(){
        return familyNoZH;
    }
    
    /**
     * 设置属性分户名称
     * @param familyName 待设置的属性分户名称的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性分户名称
     * @return 属性分户名称的值
     */
    public String getFamilyName(){
        return familyName;
    }

	public String getLicenseNo() {
		return StringUtils.rightTrim(licenseNo);
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = StringUtils.rightTrim(licenseNo);
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
    
    
}
