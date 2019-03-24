package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcinsuredartif法人信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredArtifDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性关系人标识 */
    private String insuredFlag = "";
    /** 属性法人代表 */
    private String leaderName = "";
    /** 属性法人代表身份证号 */
    private String leaderID = "";
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性邮编 */
    private String postCode = "";
    /** 属性营业执照 */
    private String businessCode = "";
    /** 属性税务登记号码 */
    private String revenueRegistNo = "";
    /** 属性经销车型 */
    private String carType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCinsuredArtifDtoBase对象
     */
    public PrpCinsuredArtifDtoBase(){
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
     * 设置属性关系人标识
     * @param insuredFlag 待设置的属性关系人标识的值
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * 获取属性关系人标识
     * @return 属性关系人标识的值
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * 设置属性法人代表
     * @param leaderName 待设置的属性法人代表的值
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * 获取属性法人代表
     * @return 属性法人代表的值
     */
    public String getLeaderName(){
        return leaderName;
    }

    /**
     * 设置属性法人代表身份证号
     * @param leaderID 待设置的属性法人代表身份证号的值
     */
    public void setLeaderID(String leaderID){
        this.leaderID = StringUtils.rightTrim(leaderID);
    }

    /**
     * 获取属性法人代表身份证号
     * @return 属性法人代表身份证号的值
     */
    public String getLeaderID(){
        return leaderID;
    }

    /**
     * 设置属性电话
     * @param phoneNumber 待设置的属性电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性邮编
     * @param postCode 待设置的属性邮编的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮编
     * @return 属性邮编的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性营业执照
     * @param businessCode 待设置的属性营业执照的值
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * 获取属性营业执照
     * @return 属性营业执照的值
     */
    public String getBusinessCode(){
        return businessCode;
    }

    /**
     * 设置属性税务登记号码
     * @param revenueRegistNo 待设置的属性税务登记号码的值
     */
    public void setRevenueRegistNo(String revenueRegistNo){
        this.revenueRegistNo = StringUtils.rightTrim(revenueRegistNo);
    }

    /**
     * 获取属性税务登记号码
     * @return 属性税务登记号码的值
     */
    public String getRevenueRegistNo(){
        return revenueRegistNo;
    }

    /**
     * 设置属性经销车型
     * @param carType 待设置的属性经销车型的值
     */
    public void setCarType(String carType){
        this.carType = StringUtils.rightTrim(carType);
    }

    /**
     * 获取属性经销车型
     * @return 属性经销车型的值
     */
    public String getCarType(){
        return carType;
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
