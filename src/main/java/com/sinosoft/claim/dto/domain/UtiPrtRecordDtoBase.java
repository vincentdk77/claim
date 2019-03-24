package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtrecord打印记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtRecordDtoBase implements Serializable{
    /** 属性单据号 */
    private String certiNo = "";
    /** 属性单据类型 */
    private String certiType = "";
    /** 属性打印人 */
    private String userName = "";
    /** 属性打印时间 */
    private String prtDate = "";
    /** 属性打印份数 */
    private int prtCount = 0;
    /** 属性备注 */
    private String note = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtRecordDtoBase对象
     */
    public UtiPrtRecordDtoBase(){
    }

    /**
     * 设置属性单据号
     * @param certiNo 待设置的属性单据号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单据号
     * @return 属性单据号的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性单据类型
     * @param certiType 待设置的属性单据类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性单据类型
     * @return 属性单据类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性打印人
     * @param userName 待设置的属性打印人的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性打印人
     * @return 属性打印人的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性打印时间
     * @param prtDate 待设置的属性打印时间的值
     */
    public void setPrtDate(String prtDate){
        this.prtDate = StringUtils.rightTrim(prtDate);
    }

    /**
     * 获取属性打印时间
     * @return 属性打印时间的值
     */
    public String getPrtDate(){
        return prtDate;
    }

    /**
     * 设置属性打印份数
     * @param prtCount 待设置的属性打印份数的值
     */
    public void setPrtCount(int prtCount){
        this.prtCount = prtCount;
    }

    /**
     * 获取属性打印份数
     * @return 属性打印份数的值
     */
    public int getPrtCount(){
        return prtCount;
    }

    /**
     * 设置属性备注
     * @param note 待设置的属性备注的值
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getNote(){
        return note;
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
}
