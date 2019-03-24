package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtrecord�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtRecordDtoBase implements Serializable{
    /** ����certino */
    private String certiNo = "";
    /** ����certitype */
    private String certiType = "";
    /** ����username */
    private String userName = "";
    /** ����prtdate */
    private String prtDate = "";
    /** ����prtcount */
    private int prtCount = 0;
    /** ����note */
    private String note = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtRecordDtoBase����
     */
    public UtiPrtRecordDtoBase(){
    }

    /**
     * ��������certino
     * @param certiNo �����õ�����certino��ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ����certino
     * @return ����certino��ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * ��������certitype
     * @param certiType �����õ�����certitype��ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ����certitype
     * @return ����certitype��ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * ��������username
     * @param userName �����õ�����username��ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����username
     * @return ����username��ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ��������prtdate
     * @param prtDate �����õ�����prtdate��ֵ
     */
    public void setPrtDate(String prtDate){
        this.prtDate = StringUtils.rightTrim(prtDate);
    }

    /**
     * ��ȡ����prtdate
     * @return ����prtdate��ֵ
     */
    public String getPrtDate(){
        return prtDate;
    }

    /**
     * ��������prtcount
     * @param prtCount �����õ�����prtcount��ֵ
     */
    public void setPrtCount(int prtCount){
        this.prtCount = prtCount;
    }

    /**
     * ��ȡ����prtcount
     * @return ����prtcount��ֵ
     */
    public int getPrtCount(){
        return prtCount;
    }

    /**
     * ��������note
     * @param note �����õ�����note��ֵ
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * ��ȡ����note
     * @return ����note��ֵ
     */
    public String getNote(){
        return note;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
