package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保确认主表-CIInsureValid的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIInsureValidDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性确认码 */
    private String validNo = "";
    /** 属性查询码 */
    private String demandNo = "";
    /** 属性投保单号码 */
    private String proposalNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性保险标志号码 */
    private String insureMarkNo = "";
    /** 属性销售渠道 */
    private String bussinessNature = "";
    /** 属性签单日期 */
    private DateTime operateDate = new DateTime();
    /** 属性特别约定 */
    private String clauses = "";
    /** 属性经办人 */
    private String handlerName = "";
    /** 属性操作员 */
    private String operatorName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性实收保费 */
    private double premium = 0D;
    /** 属性实收保费变化原因 */
    private String changeReason = "";
    /** 属性实收保费变化原因描述 */
    private String changeDetail = "";
    /** 属性归属部门 */
    private String comCode = "";
    /** 属性确认时间 */
    private DateTime validTime = new DateTime();
    /** 属性备注 */
    private String remark = "";
    /** 属性状态字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的CIInsureValidDtoBase对象
     */
    public CIInsureValidDtoBase(){
    }

    /**
     * 设置属性确认码
     * @param validNo 待设置的属性确认码的值
     */
    public void setValidNo(String validNo){
        this.validNo = StringUtils.rightTrim(validNo);
    }

    /**
     * 获取属性确认码
     * @return 属性确认码的值
     */
    public String getValidNo(){
        return validNo;
    }

    /**
     * 设置属性查询码
     * @param demandNo 待设置的属性查询码的值
     */
    public void setDemandNo(String demandNo){
        this.demandNo = StringUtils.rightTrim(demandNo);
    }

    /**
     * 获取属性查询码
     * @return 属性查询码的值
     */
    public String getDemandNo(){
        return demandNo;
    }

    /**
     * 设置属性投保单号码
     * @param proposalNo 待设置的属性投保单号码的值
     */
    public void setProposalNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * 获取属性投保单号码
     * @return 属性投保单号码的值
     */
    public String getProposalNo(){
        return proposalNo;
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
     * 设置属性保险标志号码
     * @param insureMarkNo 待设置的属性保险标志号码的值
     */
    public void setInsureMarkNo(String insureMarkNo){
        this.insureMarkNo = StringUtils.rightTrim(insureMarkNo);
    }

    /**
     * 获取属性保险标志号码
     * @return 属性保险标志号码的值
     */
    public String getInsureMarkNo(){
        return insureMarkNo;
    }

    /**
     * 设置属性销售渠道
     * @param bussinessNature 待设置的属性销售渠道的值
     */
    public void setBussinessNature(String bussinessNature){
        this.bussinessNature = StringUtils.rightTrim(bussinessNature);
    }

    /**
     * 获取属性销售渠道
     * @return 属性销售渠道的值
     */
    public String getBussinessNature(){
        return bussinessNature;
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
     * 设置属性特别约定
     * @param clauses 待设置的属性特别约定的值
     */
    public void setClauses(String clauses){
        this.clauses = StringUtils.rightTrim(clauses);
    }

    /**
     * 获取属性特别约定
     * @return 属性特别约定的值
     */
    public String getClauses(){
        return clauses;
    }

    /**
     * 设置属性经办人
     * @param handlerName 待设置的属性经办人的值
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性经办人
     * @return 属性经办人的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性操作员
     * @param operatorName 待设置的属性操作员的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作员
     * @return 属性操作员的值
     */
    public String getOperatorName(){
        return operatorName;
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
     * 设置属性实收保费
     * @param premium 待设置的属性实收保费的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性实收保费
     * @return 属性实收保费的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性实收保费变化原因
     * @param changeReason 待设置的属性实收保费变化原因的值
     */
    public void setChangeReason(String changeReason){
        this.changeReason = StringUtils.rightTrim(changeReason);
    }

    /**
     * 获取属性实收保费变化原因
     * @return 属性实收保费变化原因的值
     */
    public String getChangeReason(){
        return changeReason;
    }

    /**
     * 设置属性实收保费变化原因描述
     * @param changeDetail 待设置的属性实收保费变化原因描述的值
     */
    public void setChangeDetail(String changeDetail){
        this.changeDetail = StringUtils.rightTrim(changeDetail);
    }

    /**
     * 获取属性实收保费变化原因描述
     * @return 属性实收保费变化原因描述的值
     */
    public String getChangeDetail(){
        return changeDetail;
    }

    /**
     * 设置属性归属部门
     * @param comCode 待设置的属性归属部门的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性归属部门
     * @return 属性归属部门的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性确认时间
     * @param validTime 待设置的属性确认时间的值
     */
    public void setValidTime(DateTime validTime){
        this.validTime = validTime;
    }

    /**
     * 获取属性确认时间
     * @return 属性确认时间的值
     */
    public DateTime getValidTime(){
        return validTime;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
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
