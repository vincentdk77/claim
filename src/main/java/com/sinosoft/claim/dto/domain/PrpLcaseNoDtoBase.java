package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcaseNo-赔案号表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcaseNoDtoBase implements Serializable{
    /** 属性单证号 */
    private String certiNo = "";
    /** 属性单证类型 */
    private String certiType = "";
    /** 属性赔案号 */
    private String caseNo = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性赔案号码 */
    private String claimNo = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcaseNoDtoBase对象
     */
    public PrpLcaseNoDtoBase(){
    }

    /**
     * 设置属性单证号
     * @param certiNo 待设置的属性单证号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号
     * @return 属性单证号的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性赔案号
     * @param caseNo 待设置的属性赔案号的值
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getCaseNo(){
        return caseNo;
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
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }
}
