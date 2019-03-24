package com.sinosoft.claimprop.common.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CiClaimPropDemand的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimPropDemandDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性claimCode */
    private String claimCode = "";
    /** 属性cancellationNo */
    private String cancellationNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性registNo */
    private String registNo = "";
    /** 属性claimNo */
    private String claimNo = "";
    /** 属性registUploadFlag */
    private String registUploadFlag = "";
    /** 属性claimUploadFlag */
    private String claimUploadFlag = "";
    /** 属性endCaseUploadFlag */
    private String endCaseUploadFlag = "";
    /** 属性cancelUploadFlag */
    private String cancelUploadFlag = "";
    /** 属性endAddcode */
    private String endAddcode = "";

    /**
     *  默认构造方法,构造一个默认的CiClaimPropDemandDtoBase对象
     */
    public CiClaimPropDemandDtoBase(){
    }

    /**
     * 设置属性claimCode
     * @param claimCode 待设置的属性claimCode的值
     */
    public void setClaimCode(String claimCode){
        this.claimCode = StringUtils.rightTrim(claimCode);
    }

    /**
     * 获取属性claimCode
     * @return 属性claimCode的值
     */
    public String getClaimCode(){
        return claimCode;
    }

    /**
     * 设置属性cancellationNo
     * @param cancellationNo 待设置的属性cancellationNo的值
     */
    public void setCancellationNo(String cancellationNo){
        this.cancellationNo = StringUtils.rightTrim(cancellationNo);
    }

    /**
     * 获取属性cancellationNo
     * @return 属性cancellationNo的值
     */
    public String getCancellationNo(){
        return cancellationNo;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性claimNo
     * @param claimNo 待设置的属性claimNo的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性claimNo
     * @return 属性claimNo的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性registUploadFlag
     * @param registUploadFlag 待设置的属性registUploadFlag的值
     */
    public void setRegistUploadFlag(String registUploadFlag){
        this.registUploadFlag = StringUtils.rightTrim(registUploadFlag);
    }

    /**
     * 获取属性registUploadFlag
     * @return 属性registUploadFlag的值
     */
    public String getRegistUploadFlag(){
        return registUploadFlag;
    }

    /**
     * 设置属性claimUploadFlag
     * @param claimUploadFlag 待设置的属性claimUploadFlag的值
     */
    public void setClaimUploadFlag(String claimUploadFlag){
        this.claimUploadFlag = StringUtils.rightTrim(claimUploadFlag);
    }

    /**
     * 获取属性claimUploadFlag
     * @return 属性claimUploadFlag的值
     */
    public String getClaimUploadFlag(){
        return claimUploadFlag;
    }

    /**
     * 设置属性endCaseUploadFlag
     * @param endCaseUploadFlag 待设置的属性endCaseUploadFlag的值
     */
    public void setEndCaseUploadFlag(String endCaseUploadFlag){
        this.endCaseUploadFlag = StringUtils.rightTrim(endCaseUploadFlag);
    }

    /**
     * 获取属性endCaseUploadFlag
     * @return 属性endCaseUploadFlag的值
     */
    public String getEndCaseUploadFlag(){
        return endCaseUploadFlag;
    }

    /**
     * 设置属性cancelUploadFlag
     * @param cancelUploadFlag 待设置的属性cancelUploadFlag的值
     */
    public void setCancelUploadFlag(String cancelUploadFlag){
        this.cancelUploadFlag = StringUtils.rightTrim(cancelUploadFlag);
    }

    /**
     * 获取属性cancelUploadFlag
     * @return 属性cancelUploadFlag的值
     */
    public String getCancelUploadFlag(){
        return cancelUploadFlag;
    }

    /**
     * 设置属性endAddcode
     * @param endAddcode 待设置的属性endAddcode的值
     */
    public void setEndAddcode(String endAddcode){
        this.endAddcode = StringUtils.rightTrim(endAddcode);
    }

    /**
     * 获取属性endAddcode
     * @return 属性endAddcode的值
     */
    public String getEndAddcode(){
        return endAddcode;
    }
}
