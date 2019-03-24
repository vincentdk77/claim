package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数子表-----赔付信息的数据传输对象基类<br>
 */
public class PrpLinterPaymentInfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键id PK */
    private String id = "";
    /** 属性主键序号 PK */
    private int serialNo = 0;
    /** 属性报案号码 */
    private String registNoPay = "";
    /** 属性被保险人 */
    private String insuredNamePay = "";
    /** 属性理算书号 */
    private String certiNoPay = "";
    /** 属性赔款类型 */
    private String paymentType = "";
    /** 属性赔款类型代码 */
    private String paymentTypeCode = "";
    /** 属性结案金额 */
    private double sumPaidPay = 0D;
    /** 属性已支付金额 */
    private double havPaidPay = 0D;
    /** 属性本次支付金额 */
    private double paidPay = 0D;
    /** 属性关联案件外键 */
    private String relationOutId = "";
    /** 属性关联案件类型(N正常案件R重开案件) */
    private String relationOutIdType = "";

    /**
     *  默认构造方法,构造一个默认的PrpLinterPaymentInfoDtoBase对象
     */
    public PrpLinterPaymentInfoDtoBase(){
    }

    /**
     * 设置属性主键id PK
     * @param id 待设置的属性主键id PK的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键id PK
     * @return 属性主键id PK的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性主键序号 PK
     * @param serialNo 待设置的属性主键序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性主键序号 PK
     * @return 属性主键序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性报案号码
     * @param registNoPay 待设置的属性报案号码的值
     */
    public void setRegistNoPay(String registNoPay){
        this.registNoPay = StringUtils.rightTrim(registNoPay);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNoPay(){
        return registNoPay;
    }

    /**
     * 设置属性被保险人
     * @param insuredNamePay 待设置的属性被保险人的值
     */
    public void setInsuredNamePay(String insuredNamePay){
        this.insuredNamePay = StringUtils.rightTrim(insuredNamePay);
    }

    /**
     * 获取属性被保险人
     * @return 属性被保险人的值
     */
    public String getInsuredNamePay(){
        return insuredNamePay;
    }

    /**
     * 设置属性理算书号
     * @param certiNoPay 待设置的属性理算书号的值
     */
    public void setCertiNoPay(String certiNoPay){
        this.certiNoPay = StringUtils.rightTrim(certiNoPay);
    }

    /**
     * 获取属性理算书号
     * @return 属性理算书号的值
     */
    public String getCertiNoPay(){
        return certiNoPay;
    }

    /**
     * 设置属性赔款类型
     * @param paymentType 待设置的属性赔款类型的值
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * 获取属性赔款类型
     * @return 属性赔款类型的值
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * 设置属性赔款类型代码
     * @param paymentTypeCode 待设置的属性赔款类型代码的值
     */
    public void setPaymentTypeCode(String paymentTypeCode){
        this.paymentTypeCode = StringUtils.rightTrim(paymentTypeCode);
    }

    /**
     * 获取属性赔款类型代码
     * @return 属性赔款类型代码的值
     */
    public String getPaymentTypeCode(){
        return paymentTypeCode;
    }

    /**
     * 设置属性结案金额
     * @param sumPaidPay 待设置的属性结案金额的值
     */
    public void setSumPaidPay(double sumPaidPay){
        this.sumPaidPay = sumPaidPay;
    }

    /**
     * 获取属性结案金额
     * @return 属性结案金额的值
     */
    public double getSumPaidPay(){
        return sumPaidPay;
    }

    /**
     * 设置属性已支付金额
     * @param havPaidPay 待设置的属性已支付金额的值
     */
    public void setHavPaidPay(double havPaidPay){
        this.havPaidPay = havPaidPay;
    }

    /**
     * 获取属性已支付金额
     * @return 属性已支付金额的值
     */
    public double getHavPaidPay(){
        return havPaidPay;
    }

    /**
     * 设置属性本次支付金额
     * @param paidPay 待设置的属性本次支付金额的值
     */
    public void setPaidPay(double paidPay){
        this.paidPay = paidPay;
    }

    /**
     * 获取属性本次支付金额
     * @return 属性本次支付金额的值
     */
    public double getPaidPay(){
        return paidPay;
    }

    /**
     * 设置属性关联案件外键
     * @param relationOutId 待设置的属性关联案件外键的值
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * 获取属性关联案件外键
     * @return 属性关联案件外键的值
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * 设置属性关联案件类型(N正常案件R重开案件)
     * @param relationOutIdType 待设置的属性关联案件类型(N正常案件R重开案件)的值
     */
    public void setRelationOutIdType(String relationOutIdType){
        this.relationOutIdType = StringUtils.rightTrim(relationOutIdType);
    }

    /**
     * 获取属性关联案件类型(N正常案件R重开案件)
     * @return 属性关联案件类型(N正常案件R重开案件)的值
     */
    public String getRelationOutIdType(){
        return relationOutIdType;
    }
}
