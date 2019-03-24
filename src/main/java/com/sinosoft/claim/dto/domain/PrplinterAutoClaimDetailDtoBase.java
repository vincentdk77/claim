package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔自动流程状态查询表的数据传输对象基类<br>
 */
public class PrplinterAutoClaimDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性主键pk */
    private String id = "";
    /** 属性报案号码 PK */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性报案流程成功(1成功) */
    private String registSuccFlag = "";
    /** 属性调度流程成功(1成功) */
    private String schedSuccFlag = "";
    /** 属性查勘流程成功(1成功)(1成功) */
    private String checkSuccFlag = "";
    /** 属性立案流程成功(1成功) */
    private String claimSuccFlag = "";
    /** 属性单证流程成功(1成功) */
    private String certiSuccFlag = "";
    /** 属性理算流程成功(1成功) */
    private String comppSuccFlag = "";
    /** 属性核赔流程成功(1成功) */
    private String vericSuccFlag = "";
    /** 属性结案流程成功(1成功) */
    private String endcaSuccFlag = "";
    /** 属性返回信息(成功/error) */
    private String remark = "";
    /** 属性预赔申请流程成功(1成功) */
    private String prepaySuccFlag = "";
    /** 属性预赔审批流程成功(1成功) */
    private String prepayVericSuccFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrplinterAutoClaimDetailDtoBase对象
     */
    public PrplinterAutoClaimDetailDtoBase(){
    }

    /**
     * 设置属性主键pk
     * @param id 待设置的属性主键pk的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性主键pk
     * @return 属性主键pk的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性报案号码 PK
     * @param registNo 待设置的属性报案号码 PK的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码 PK
     * @return 属性报案号码 PK的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性报案流程成功(1成功)
     * @param registSuccFlag 待设置的属性报案流程成功(1成功)的值
     */
    public void setRegistSuccFlag(String registSuccFlag){
        this.registSuccFlag = StringUtils.rightTrim(registSuccFlag);
    }

    /**
     * 获取属性报案流程成功(1成功)
     * @return 属性报案流程成功(1成功)的值
     */
    public String getRegistSuccFlag(){
        return registSuccFlag;
    }

    /**
     * 设置属性调度流程成功(1成功)
     * @param schedSuccFlag 待设置的属性调度流程成功(1成功)的值
     */
    public void setSchedSuccFlag(String schedSuccFlag){
        this.schedSuccFlag = StringUtils.rightTrim(schedSuccFlag);
    }

    /**
     * 获取属性调度流程成功(1成功)
     * @return 属性调度流程成功(1成功)的值
     */
    public String getSchedSuccFlag(){
        return schedSuccFlag;
    }

    /**
     * 设置属性查勘流程成功(1成功)(1成功)
     * @param checkSuccFlag 待设置的属性查勘流程成功(1成功)(1成功)的值
     */
    public void setCheckSuccFlag(String checkSuccFlag){
        this.checkSuccFlag = StringUtils.rightTrim(checkSuccFlag);
    }

    /**
     * 获取属性查勘流程成功(1成功)(1成功)
     * @return 属性查勘流程成功(1成功)(1成功)的值
     */
    public String getCheckSuccFlag(){
        return checkSuccFlag;
    }

    /**
     * 设置属性立案流程成功(1成功)
     * @param claimSuccFlag 待设置的属性立案流程成功(1成功)的值
     */
    public void setClaimSuccFlag(String claimSuccFlag){
        this.claimSuccFlag = StringUtils.rightTrim(claimSuccFlag);
    }

    /**
     * 获取属性立案流程成功(1成功)
     * @return 属性立案流程成功(1成功)的值
     */
    public String getClaimSuccFlag(){
        return claimSuccFlag;
    }

    /**
     * 设置属性单证流程成功(1成功)
     * @param certiSuccFlag 待设置的属性单证流程成功(1成功)的值
     */
    public void setCertiSuccFlag(String certiSuccFlag){
        this.certiSuccFlag = StringUtils.rightTrim(certiSuccFlag);
    }

    /**
     * 获取属性单证流程成功(1成功)
     * @return 属性单证流程成功(1成功)的值
     */
    public String getCertiSuccFlag(){
        return certiSuccFlag;
    }

    /**
     * 设置属性理算流程成功(1成功)
     * @param comppSuccFlag 待设置的属性理算流程成功(1成功)的值
     */
    public void setComppSuccFlag(String comppSuccFlag){
        this.comppSuccFlag = StringUtils.rightTrim(comppSuccFlag);
    }

    /**
     * 获取属性理算流程成功(1成功)
     * @return 属性理算流程成功(1成功)的值
     */
    public String getComppSuccFlag(){
        return comppSuccFlag;
    }

    /**
     * 设置属性核赔流程成功(1成功)
     * @param vericSuccFlag 待设置的属性核赔流程成功(1成功)的值
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * 获取属性核赔流程成功(1成功)
     * @return 属性核赔流程成功(1成功)的值
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * 设置属性结案流程成功(1成功)
     * @param endcaSuccFlag 待设置的属性结案流程成功(1成功)的值
     */
    public void setEndcaSuccFlag(String endcaSuccFlag){
        this.endcaSuccFlag = StringUtils.rightTrim(endcaSuccFlag);
    }

    /**
     * 获取属性结案流程成功(1成功)
     * @return 属性结案流程成功(1成功)的值
     */
    public String getEndcaSuccFlag(){
        return endcaSuccFlag;
    }

    /**
     * 设置属性返回信息(成功/error)
     * @param remark 待设置的属性返回信息(成功/error)的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性返回信息(成功/error)
     * @return 属性返回信息(成功/error)的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性预赔申请流程成功(1成功)
     * @param prepaySuccFlag 待设置的属性预赔申请流程成功(1成功)的值
     */
    public void setPrepaySuccFlag(String prepaySuccFlag){
        this.prepaySuccFlag = StringUtils.rightTrim(prepaySuccFlag);
    }

    /**
     * 获取属性预赔申请流程成功(1成功)
     * @return 属性预赔申请流程成功(1成功)的值
     */
    public String getPrepaySuccFlag(){
        return prepaySuccFlag;
    }

    /**
     * 设置属性预赔审批流程成功(1成功)
     * @param prepayVericSuccFlag 待设置的属性预赔审批流程成功(1成功)的值
     */
    public void setPrepayVericSuccFlag(String prepayVericSuccFlag){
        this.prepayVericSuccFlag = StringUtils.rightTrim(prepayVericSuccFlag);
    }

    /**
     * 获取属性预赔审批流程成功(1成功)
     * @return 属性预赔审批流程成功(1成功)的值
     */
    public String getPrepayVericSuccFlag(){
        return prepayVericSuccFlag;
    }
}
