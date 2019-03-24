package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpersonWound-伤情信息表(新增)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonWoundDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性人员序号 */
    private int personNo = 0;
    /** 属性人员姓名 */
    private String personName = "";
    /** 属性伤情代码 */
    private String woundCode = "";
    /** 属性伤情描述 */
    private String woundDesc = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpersonWoundDtoBase对象
     */
    public PrpLpersonWoundDtoBase(){
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
     * 设置属性人员序号
     * @param personNo 待设置的属性人员序号的值
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * 获取属性人员序号
     * @return 属性人员序号的值
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * 设置属性人员姓名
     * @param personName 待设置的属性人员姓名的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员姓名
     * @return 属性人员姓名的值
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * 设置属性伤情代码
     * @param woundCode 待设置的属性伤情代码的值
     */
    public void setWoundCode(String woundCode){
        this.woundCode = StringUtils.rightTrim(woundCode);
    }

    /**
     * 获取属性伤情代码
     * @return 属性伤情代码的值
     */
    public String getWoundCode(){
        return woundCode;
    }

    /**
     * 设置属性伤情描述
     * @param woundDesc 待设置的属性伤情描述的值
     */
    public void setWoundDesc(String woundDesc){
        this.woundDesc = StringUtils.rightTrim(woundDesc);
    }

    /**
     * 获取属性伤情描述
     * @return 属性伤情描述的值
     */
    public String getWoundDesc(){
        return woundDesc;
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
