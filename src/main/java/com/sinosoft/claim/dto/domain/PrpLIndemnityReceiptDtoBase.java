package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是赔款收据的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLIndemnityReceiptDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性业务号 */
    private String businessNo = "";
    /** 属性单证类型 */
    private String certiType = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性收款单位银行 */
    private String unitBank = "";
    /** 属性收款单位帐号 */
    private String unitAccount = "";
    /** 属性收款人银行帐号 */
    private String account = "";
    /** 属性收款人身份证号 */
    private String identifyNumber = "";
    /** 属性打印单证代码 */
    private String visaCode = "";
    /** 属性打印单证名称 */
    private String visaName = "";
    /** 属性打印单证流水号 */
    private String printNo = "";

    /**
     *  默认构造方法,构造一个默认的PrpLIndemnityReceiptDtoBase对象
     */
    public PrpLIndemnityReceiptDtoBase(){
    }

    /**
     * 设置属性业务号
     * @param businessNo 待设置的属性业务号的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性业务号
     * @return 属性业务号的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性单证类型
     * @param certiType 待设置的属性单证类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性单证类型
     * @return 属性单证类型的值
     */
    public String getCertiType(){
        return certiType;
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
     * 设置属性收款单位银行
     * @param unitBank 待设置的属性收款单位银行的值
     */
    public void setUnitBank(String unitBank){
        this.unitBank = StringUtils.rightTrim(unitBank);
    }

    /**
     * 获取属性收款单位银行
     * @return 属性收款单位银行的值
     */
    public String getUnitBank(){
        return unitBank;
    }

    /**
     * 设置属性收款单位帐号
     * @param unitAccount 待设置的属性收款单位帐号的值
     */
    public void setUnitAccount(String unitAccount){
        this.unitAccount = StringUtils.rightTrim(unitAccount);
    }

    /**
     * 获取属性收款单位帐号
     * @return 属性收款单位帐号的值
     */
    public String getUnitAccount(){
        return unitAccount;
    }

    /**
     * 设置属性收款人银行帐号
     * @param account 待设置的属性收款人银行帐号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性收款人银行帐号
     * @return 属性收款人银行帐号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性收款人身份证号
     * @param identifyNumber 待设置的属性收款人身份证号的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性收款人身份证号
     * @return 属性收款人身份证号的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性打印单证代码
     * @param visaCode 待设置的属性打印单证代码的值
     */
    public void setVisaCode(String visaCode){
        this.visaCode = StringUtils.rightTrim(visaCode);
    }

    /**
     * 获取属性打印单证代码
     * @return 属性打印单证代码的值
     */
    public String getVisaCode(){
        return visaCode;
    }

    /**
     * 设置属性打印单证名称
     * @param visaName 待设置的属性打印单证名称的值
     */
    public void setVisaName(String visaName){
        this.visaName = StringUtils.rightTrim(visaName);
    }

    /**
     * 获取属性打印单证名称
     * @return 属性打印单证名称的值
     */
    public String getVisaName(){
        return visaName;
    }

    /**
     * 设置属性打印单证流水号
     * @param printNo 待设置的属性打印单证流水号的值
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * 获取属性打印单证流水号
     * @return 属性打印单证流水号的值
     */
    public String getPrintNo(){
        return printNo;
    }
}
