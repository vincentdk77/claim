package com.sinosoft.claimciplatform.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔平台查询表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIClaimDemandDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性理赔编码 */
    private String claimCode = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性报案信息是否上传 */
    private String registUploadFlag = "";
    /** 属性立案信息是否上传 */
    private String claimUploadFlag = "";
    /** 属性结案信息是否上传 */
    private String endCaseUploadFlag = "";
    /** 属性注销信息是否上传 */
    private String cancelUploadFlag = "";
    /** 属性结案追加信息是否上传 */
    private String endCaseAppendUploadFlag = "";
    /** 属性赔案结案校验码 */
    private String caseCheckNo = "";
    /** 险种 */
    private String riskCode="";
    /**
     *  默认构造方法,构造一个默认的CIClaimDemandDtoBase对象
     */
    public CIClaimDemandDtoBase(){
    }

    /**
     * 设置属性理赔编码
     * @param claimCode 待设置的属性理赔编码的值
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * 获取属性理赔编码
     * @return 属性理赔编码的值
     */
    public String getClaimCode(){
        return claimCode;
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
     * 设置属性报案信息是否上传
     * @param registUploadFlag 待设置的属性报案信息是否上传的值
     */
    public void setRegistUploadFlag(String registUploadFlag){
        this.registUploadFlag = StringUtils.rightTrim(registUploadFlag);
    }

    /**
     * 获取属性报案信息是否上传
     * @return 属性报案信息是否上传的值
     */
    public String getRegistUploadFlag(){
        return registUploadFlag;
    }

    /**
     * 设置属性立案信息是否上传
     * @param claimUploadFlag 待设置的属性立案信息是否上传的值
     */
    public void setClaimUploadFlag(String claimUploadFlag){
        this.claimUploadFlag = StringUtils.rightTrim(claimUploadFlag);
    }

    /**
     * 获取属性立案信息是否上传
     * @return 属性立案信息是否上传的值
     */
    public String getClaimUploadFlag(){
        return claimUploadFlag;
    }

    /**
     * 设置属性结案信息是否上传
     * @param endCaseUploadFlag 待设置的属性结案信息是否上传的值
     */
    public void setEndCaseUploadFlag(String endCaseUploadFlag){
        this.endCaseUploadFlag = StringUtils.rightTrim(endCaseUploadFlag);
    }

    /**
     * 获取属性结案信息是否上传
     * @return 属性结案信息是否上传的值
     */
    public String getEndCaseUploadFlag(){
        return endCaseUploadFlag;
    }

    /**
     * 设置属性注销信息是否上传
     * @param cancelUploadFlag 待设置的属性注销信息是否上传的值
     */
    public void setCancelUploadFlag(String cancelUploadFlag){
        this.cancelUploadFlag = StringUtils.rightTrim(cancelUploadFlag);
    }

    /**
     * 获取属性注销信息是否上传
     * @return 属性注销信息是否上传的值
     */
    public String getCancelUploadFlag(){
        return cancelUploadFlag;
    }

    /**
     * 设置属性赔案结案校验码
     * @param caseCheckNo 待设置的属性赔案结案校验码的值
     */
    public void setCaseCheckNo(String caseCheckNo){
        this.caseCheckNo = StringUtils.rightTrim(caseCheckNo);
    }

    /**
     * 获取属性赔案结案校验码
     * @return 属性赔案结案校验码的值
     */
    public String getCaseCheckNo(){
        return caseCheckNo;
    }

	/**
	 * 获取属性 endCaseAppendUploadFlag
	 * @return the endCaseAppendUploadFlag
	 */
	public String getEndCaseAppendUploadFlag() {
		return endCaseAppendUploadFlag;
	}

	/**
	 * 设置属性 endCaseAppendUploadFlag
	 * @param endCaseAppendUploadFlag the endCaseAppendUploadFlag to set
	 */
	public void setEndCaseAppendUploadFlag(String endCaseAppendUploadFlag) {
		this.endCaseAppendUploadFlag = endCaseAppendUploadFlag;
	}

	/**
	 * @return the riskCode
	 */
	public String getRiskCode() {
		return riskCode;
	}

	/**
	 * @param riskCode the riskCode to set
	 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
    
    
}
