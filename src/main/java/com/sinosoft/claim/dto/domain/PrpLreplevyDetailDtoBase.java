package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLreplevyDetail-权益转让及追偿信息的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreplevyDetailDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性次数 */
    private int times = 0;
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性追偿类型代码 */
    private String replevyTypeCode = "";
    /** 属性权益转让日期 */
    private DateTime rightTransferDate = new DateTime();
    /** 属性被追偿人名称 */
    private String repleviedName = "";
    /** 属性追偿原因 */
    private String replevyReason = "";
    /** 属性追偿项目类别 */
    private String itemCode = "";
    /** 属性追偿项目名称 */
    private String itemName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性追偿金额 */
    private double replevyFee = 0d;
    /** 属性已追回金额 */
    private double validFee = 0d;
    /** 属性ReplevyCharge */
    private double replevyCharge = 0d;
    /** 属性追偿日期 */
    private DateTime reclaimDate = new DateTime();
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性备注 */
    private String note = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLreplevyDetailDtoBase对象
     */
    public PrpLreplevyDetailDtoBase(){
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
     * 设置属性追偿类型代码
     * @param replevyTypeCode 待设置的属性追偿类型代码的值
     */
    public void setReplevyTypeCode(String replevyTypeCode){
        this.replevyTypeCode = StringUtils.rightTrim(replevyTypeCode);
    }

    /**
     * 获取属性追偿类型代码
     * @return 属性追偿类型代码的值
     */
    public String getReplevyTypeCode(){
        return replevyTypeCode;
    }

    /**
     * 设置属性权益转让日期
     * @param rightTransferDate 待设置的属性权益转让日期的值
     */
    public void setRightTransferDate(DateTime rightTransferDate){
        this.rightTransferDate = rightTransferDate;
    }

    /**
     * 获取属性权益转让日期
     * @return 属性权益转让日期的值
     */
    public DateTime getRightTransferDate(){
        return rightTransferDate;
    }

    /**
     * 设置属性被追偿人名称
     * @param repleviedName 待设置的属性被追偿人名称的值
     */
    public void setRepleviedName(String repleviedName){
        this.repleviedName = StringUtils.rightTrim(repleviedName);
    }

    /**
     * 获取属性被追偿人名称
     * @return 属性被追偿人名称的值
     */
    public String getRepleviedName(){
        return repleviedName;
    }

    /**
     * 设置属性追偿原因
     * @param replevyReason 待设置的属性追偿原因的值
     */
    public void setReplevyReason(String replevyReason){
        this.replevyReason = StringUtils.rightTrim(replevyReason);
    }

    /**
     * 获取属性追偿原因
     * @return 属性追偿原因的值
     */
    public String getReplevyReason(){
        return replevyReason;
    }

    /**
     * 设置属性追偿项目类别
     * @param itemCode 待设置的属性追偿项目类别的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性追偿项目类别
     * @return 属性追偿项目类别的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性追偿项目名称
     * @param itemName 待设置的属性追偿项目名称的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性追偿项目名称
     * @return 属性追偿项目名称的值
     */
    public String getItemName(){
        return itemName;
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
     * 设置属性追偿金额
     * @param replevyFee 待设置的属性追偿金额的值
     */
    public void setReplevyFee(double replevyFee){
        this.replevyFee = replevyFee;
    }

    /**
     * 获取属性追偿金额
     * @return 属性追偿金额的值
     */
    public double getReplevyFee(){
        return replevyFee;
    }

    /**
     * 设置属性已追回金额
     * @param validFee 待设置的属性已追回金额的值
     */
    public void setValidFee(double validFee){
        this.validFee = validFee;
    }

    /**
     * 获取属性已追回金额
     * @return 属性已追回金额的值
     */
    public double getValidFee(){
        return validFee;
    }

    /**
     * 设置属性ReplevyCharge
     * @param replevyCharge 待设置的属性ReplevyCharge的值
     */
    public void setReplevyCharge(double replevyCharge){
        this.replevyCharge = replevyCharge;
    }

    /**
     * 获取属性ReplevyCharge
     * @return 属性ReplevyCharge的值
     */
    public double getReplevyCharge(){
        return replevyCharge;
    }

    /**
     * 设置属性追偿日期
     * @param reclaimDate 待设置的属性追偿日期的值
     */
    public void setReclaimDate(DateTime reclaimDate){
        this.reclaimDate = reclaimDate;
    }

    /**
     * 获取属性追偿日期
     * @return 属性追偿日期的值
     */
    public DateTime getReclaimDate(){
        return reclaimDate;
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
     * 设置属性备注
     * @param note 待设置的属性备注的值
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getNote(){
        return note;
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
}
