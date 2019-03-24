package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiprtrecord��ӡ��¼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtRecordDtoBase implements Serializable{
    /** ���Ե��ݺ� */
    private String certiNo = "";
    /** ���Ե������� */
    private String certiType = "";
    /** ���Դ�ӡ�� */
    private String userName = "";
    /** ���Դ�ӡʱ�� */
    private String prtDate = "";
    /** ���Դ�ӡ���� */
    private int prtCount = 0;
    /** ���Ա�ע */
    private String note = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPrtRecordDtoBase����
     */
    public UtiPrtRecordDtoBase(){
    }

    /**
     * �������Ե��ݺ�
     * @param certiNo �����õ����Ե��ݺŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե��ݺ�
     * @return ���Ե��ݺŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ե�������
     * @param certiType �����õ����Ե������͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Դ�ӡ��
     * @param userName �����õ����Դ�ӡ�˵�ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ���Դ�ӡ��
     * @return ���Դ�ӡ�˵�ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * �������Դ�ӡʱ��
     * @param prtDate �����õ����Դ�ӡʱ���ֵ
     */
    public void setPrtDate(String prtDate){
        this.prtDate = StringUtils.rightTrim(prtDate);
    }

    /**
     * ��ȡ���Դ�ӡʱ��
     * @return ���Դ�ӡʱ���ֵ
     */
    public String getPrtDate(){
        return prtDate;
    }

    /**
     * �������Դ�ӡ����
     * @param prtCount �����õ����Դ�ӡ������ֵ
     */
    public void setPrtCount(int prtCount){
        this.prtCount = prtCount;
    }

    /**
     * ��ȡ���Դ�ӡ����
     * @return ���Դ�ӡ������ֵ
     */
    public int getPrtCount(){
        return prtCount;
    }

    /**
     * �������Ա�ע
     * @param note �����õ����Ա�ע��ֵ
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getNote(){
        return note;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
