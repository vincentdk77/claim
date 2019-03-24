package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLreplevy-权益转让及追偿信息的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.578<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreplevyDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性次数 */
    private int times = 0;
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性追偿类型代码 */
    private String replevyTypeCode = "";
    /** 属性权益转让日期 */
    private DateTime rightTransferDate = new DateTime();
    /** 属性被追偿人名称 */
    private String repleviedName = "";
    /** 属性追偿原因 */
    private String replevyReason = "";
    /** 属性追偿途径（依据） */
    private String replevyWay = "";
    /** 属性追偿日期 */
    private DateTime reclaimDate = new DateTime();
    /** 属性追回日期 */
    private DateTime validDate = new DateTime();
    /** 属性币别 */
    private String currency = "";
    /** 属性总追偿金额 */
    private double sumReplevyFee = 0d;
    /** 属性总追回金额 */
    private double sumValidFee = 0d;
    /** 属性摊销方式
--** 1：追偿款 
--** 2：冲赔款
--** 9：其他 */
    private String amortizeWay = "";
    /** 属性理赔登记机构代码 */
    private String makeCom = "";
    /** 属性业务归属机构 */
    private String comCode = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性统计年月 */
    private DateTime statisticsYM = new DateTime();
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性结案日期 */
    private DateTime endCaseDate = new DateTime();
    /** 属性结案员代码 */
    private String endCaseCode = "";
    /** 属性注销日期 */
    private DateTime cancelDate = new DateTime();
    /** 属性注销原因 */
    private String cancelReason = "";
    /** 属性注销人代码 */
    private String dealerCode = "";
    /** 属性备注 */
    private String note = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLreplevyDtoBase对象
     */
    public PrpLreplevyDtoBase(){
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
     * 设置属性追偿途径（依据）
     * @param replevyWay 待设置的属性追偿途径（依据）的值
     */
    public void setReplevyWay(String replevyWay){
        this.replevyWay = StringUtils.rightTrim(replevyWay);
    }

    /**
     * 获取属性追偿途径（依据）
     * @return 属性追偿途径（依据）的值
     */
    public String getReplevyWay(){
        return replevyWay;
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
     * 设置属性追回日期
     * @param validDate 待设置的属性追回日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性追回日期
     * @return 属性追回日期的值
     */
    public DateTime getValidDate(){
        return validDate;
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
     * 设置属性总追偿金额
     * @param sumReplevyFee 待设置的属性总追偿金额的值
     */
    public void setSumReplevyFee(double sumReplevyFee){
        this.sumReplevyFee = sumReplevyFee;
    }

    /**
     * 获取属性总追偿金额
     * @return 属性总追偿金额的值
     */
    public double getSumReplevyFee(){
        return sumReplevyFee;
    }

    /**
     * 设置属性总追回金额
     * @param sumValidFee 待设置的属性总追回金额的值
     */
    public void setSumValidFee(double sumValidFee){
        this.sumValidFee = sumValidFee;
    }

    /**
     * 获取属性总追回金额
     * @return 属性总追回金额的值
     */
    public double getSumValidFee(){
        return sumValidFee;
    }

    /**
     * 设置属性摊销方式
--** 1：追偿款 
--** 2：冲赔款
--** 9：其他
     * @param amortizeWay 待设置的属性摊销方式
--** 1：追偿款 
--** 2：冲赔款
--** 9：其他的值
     */
    public void setAmortizeWay(String amortizeWay){
        this.amortizeWay = StringUtils.rightTrim(amortizeWay);
    }

    /**
     * 获取属性摊销方式
--** 1：追偿款 
--** 2：冲赔款
--** 9：其他
     * @return 属性摊销方式
--** 1：追偿款 
--** 2：冲赔款
--** 9：其他的值
     */
    public String getAmortizeWay(){
        return amortizeWay;
    }

    /**
     * 设置属性理赔登记机构代码
     * @param makeCom 待设置的属性理赔登记机构代码的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性理赔登记机构代码
     * @return 属性理赔登记机构代码的值
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * 设置属性业务归属机构
     * @param comCode 待设置的属性业务归属机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构
     * @return 属性业务归属机构的值
     */
    public String getComCode(){
        return comCode;
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
     * 设置属性结案日期
     * @param endCaseDate 待设置的属性结案日期的值
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * 获取属性结案日期
     * @return 属性结案日期的值
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * 设置属性结案员代码
     * @param endCaseCode 待设置的属性结案员代码的值
     */
    public void setEndCaseCode(String endCaseCode){
        this.endCaseCode = StringUtils.rightTrim(endCaseCode);
    }

    /**
     * 获取属性结案员代码
     * @return 属性结案员代码的值
     */
    public String getEndCaseCode(){
        return endCaseCode;
    }

    /**
     * 设置属性注销日期
     * @param cancelDate 待设置的属性注销日期的值
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性注销日期
     * @return 属性注销日期的值
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * 设置属性注销原因
     * @param cancelReason 待设置的属性注销原因的值
     */
    public void setCancelReason(String cancelReason){
        this.cancelReason = StringUtils.rightTrim(cancelReason);
    }

    /**
     * 获取属性注销原因
     * @return 属性注销原因的值
     */
    public String getCancelReason(){
        return cancelReason;
    }

    /**
     * 设置属性注销人代码
     * @param dealerCode 待设置的属性注销人代码的值
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * 获取属性注销人代码
     * @return 属性注销人代码的值
     */
    public String getDealerCode(){
        return dealerCode;
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
