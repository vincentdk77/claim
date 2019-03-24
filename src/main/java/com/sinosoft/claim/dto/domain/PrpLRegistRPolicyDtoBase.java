package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的数据传输对象基类<br>
 * 创建于 2006-06-09 11:05:56.144<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLRegistRPolicyDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 属性报案号 */
    private String registNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性保单类型 */
    private String policyType = "";
    /** 属性工作流号码 */
    private String flowId = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性是否有效的标记 */
    private String validStatus = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性报案标记 */
    private String registFlag = "";
    /** 属性注销原因代码 */
    private String cancelReason = "";
    /** 属性注销原因名称 **/
    private String cancelReasonName = "";
    /** 属性注销时间 **/
    private String cancelDate = "";
    /** 属性注销操作员代码 **/
    private String cancelOperaterCode = "";
    /** 属性注销机构 **/
    private String cancelComCode = "";
    /** 属性报案关联保单有效标志 */
    private String registValidStatus = "";
    /** 属性报案关联保单的录入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性录入人代码 */
    private String operatorCode = "";
    /** 属性录入人归属机构 */
    private String registComCode = ""; 
    
    /**
     *  默认构造方法,构造一个默认的PrpLRegistRPolicyDtoBase对象
     */
    public PrpLRegistRPolicyDtoBase(){
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

    /**
     * 设置属性工作流号码
     * @param flowId 待设置的属性工作流号码的值
     */
    public void setFlowId(String flowId){
        this.flowId = StringUtils.rightTrim(flowId);
    }

    /**
     * 获取属性工作流号码
     * @return 属性工作流号码的值
     */
    public String getFlowId(){
        return flowId;
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
     * 设置属性是否有效的标记
     * @param validStatus 待设置的属性是否有效的标记的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性是否有效的标记
     * @return 属性是否有效的标记的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
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
     * 设置属性报案标记
     * @param registFlag 待设置的属性报案标记的值
     */
    public void setRegistFlag(String registFlag){
        this.registFlag = StringUtils.rightTrim(registFlag);
    }

    /**
     * 获取属性报案标记
     * @return 属性报案标记的值
     */
    public String getRegistFlag(){
        return registFlag;
    }

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonName() {
		return cancelReasonName;
	}

	public void setCancelReasonName(String cancelReasonName) {
		this.cancelReasonName = cancelReasonName;
	}

	/**
	 * @return the cancelDate
	 */
	public String getCancelDate() {
		return cancelDate;
	}

	/**
	 * @param cancelDate the cancelDate to set
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * @return the cancelOperaterCode
	 */
	public String getCancelOperaterCode() {
		return cancelOperaterCode;
	}

	/**
	 * @param cancelOperaterCode the cancelOperaterCode to set
	 */
	public void setCancelOperaterCode(String cancelOperaterCode) {
		this.cancelOperaterCode = cancelOperaterCode;
	}

	/**
	 * @return the cancelComCode
	 */
	public String getCancelComCode() {
		return cancelComCode;
	}

	/**
	 * @param cancelComCode the cancelComCode to set
	 */
	public void setCancelComCode(String cancelComCode) {
		this.cancelComCode = cancelComCode;
	}
	/**
     * 设置属性registValidStatus
     * @param registValidStatus 待设置的属性registValidStatus的值
     */
    public void setRegistValidStatus(String registValidStatus){
        this.registValidStatus = StringUtils.rightTrim(registValidStatus);
    }

    /**
     * 获取属性registValidStatus
     * @return 属性registValidStatus的值
     */
    public String getRegistValidStatus(){
        return registValidStatus;
    }

    /**
     * 设置属性inputDate
     * @param inputDate 待设置的属性inputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性inputDate
     * @return 属性inputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性operatorCode
     * @param operatorCode 待设置的属性operatorCode的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性operatorCode
     * @return 属性operatorCode的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性registComCode
     * @param registComCode 待设置的属性registComCode的值
     */
    public void setRegistComCode(String registComCode){
        this.registComCode = StringUtils.rightTrim(registComCode);
    }

    /**
     * 获取属性registComCode
     * @return 属性registComCode的值
     */
    public String getRegistComCode(){
        return registComCode;
    }
}
