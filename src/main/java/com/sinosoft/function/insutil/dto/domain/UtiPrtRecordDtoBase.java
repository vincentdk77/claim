package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtrecord的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtRecordDtoBase implements Serializable{
    /** 属性certino */
    private String certiNo = "";
    /** 属性certitype */
    private String certiType = "";
    /** 属性username */
    private String userName = "";
    /** 属性prtdate */
    private String prtDate = "";
    /** 属性prtcount */
    private int prtCount = 0;
    /** 属性note */
    private String note = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtRecordDtoBase对象
     */
    public UtiPrtRecordDtoBase(){
    }

    /**
     * 设置属性certino
     * @param certiNo 待设置的属性certino的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性certino
     * @return 属性certino的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性certitype
     * @param certiType 待设置的属性certitype的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性certitype
     * @return 属性certitype的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性username
     * @param userName 待设置的属性username的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性username
     * @return 属性username的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性prtdate
     * @param prtDate 待设置的属性prtdate的值
     */
    public void setPrtDate(String prtDate){
        this.prtDate = StringUtils.rightTrim(prtDate);
    }

    /**
     * 获取属性prtdate
     * @return 属性prtdate的值
     */
    public String getPrtDate(){
        return prtDate;
    }

    /**
     * 设置属性prtcount
     * @param prtCount 待设置的属性prtcount的值
     */
    public void setPrtCount(int prtCount){
        this.prtCount = prtCount;
    }

    /**
     * 获取属性prtcount
     * @return 属性prtcount的值
     */
    public int getPrtCount(){
        return prtCount;
    }

    /**
     * 设置属性note
     * @param note 待设置的属性note的值
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * 获取属性note
     * @return 属性note的值
     */
    public String getNote(){
        return note;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
