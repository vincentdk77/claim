package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class ClaimAppDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性姓名 */
    private String acciName = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性与事故者关系 */
    private String relationCode = "";
    /** 属性联系电话 */
    private String phone = "";
    /** 属性通讯地址 */
    private String proposerAddress = "";

    /**
     *  默认构造方法,构造一个默认的ClaimAppDto对象
     */
    public ClaimAppDto(){
    }

    /**
     * 设置属性序号 PK
     * @param serialNo 待设置的属性序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 PK
     * @return 属性序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性姓名
     * @param acciName 待设置的属性姓名的值
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * 获取属性姓名
     * @return 属性姓名的值
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * 设置属性身份证号码
     * @param identifyNumber 待设置的属性身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性与事故者关系
     * @param relationCode 待设置的属性与事故者关系的值
     */
    public void setRelationCode(String relationCode){
        this.relationCode = StringUtils.rightTrim(relationCode);
    }

    /**
     * 获取属性与事故者关系
     * @return 属性与事故者关系的值
     */
    public String getRelationCode(){
        return relationCode;
    }

    /**
     * 设置属性联系电话
     * @param phone 待设置的属性联系电话的值
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * 获取属性联系电话
     * @return 属性联系电话的值
     */
    public String getPhone(){
        return phone;
    }

    /**
     * 设置属性通讯地址
     * @param proposerAddress 待设置的属性通讯地址的值
     */
    public void setProposerAddress(String proposerAddress){
        this.proposerAddress = StringUtils.rightTrim(proposerAddress);
    }

    /**
     * 获取属性通讯地址
     * @return 属性通讯地址的值
     */
    public String getProposerAddress(){
        return proposerAddress;
    }
}
