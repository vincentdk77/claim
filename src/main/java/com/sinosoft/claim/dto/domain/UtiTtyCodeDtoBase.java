package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utittycode�ն����Լ�¼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyCodeDtoBase implements Serializable{
    /** �����ն���� */
    private String ttyCode = "";
    /** ����ϵͳ������ն˺� */
    private String sysTty = "";
    /** �����ն����� */
    private String ttyType = "";
    /** �����ն����� */
    private String ttyName = "";
    /** ���Դ�ӡ������ */
    private String prtType = "";
    /** ���Դ�ӡ������ */
    private String prtName = "";
    /** ���Դ�ӡģʽ��A/T/L�� */
    private String prtMode = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiTtyCodeDtoBase����
     */
    public UtiTtyCodeDtoBase(){
    }

    /**
     * ���������ն����
     * @param ttyCode �����õ������ն���ŵ�ֵ
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * ��ȡ�����ն����
     * @return �����ն���ŵ�ֵ
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * ��������ϵͳ������ն˺�
     * @param sysTty �����õ�����ϵͳ������ն˺ŵ�ֵ
     */
    public void setSysTty(String sysTty){
        this.sysTty = StringUtils.rightTrim(sysTty);
    }

    /**
     * ��ȡ����ϵͳ������ն˺�
     * @return ����ϵͳ������ն˺ŵ�ֵ
     */
    public String getSysTty(){
        return sysTty;
    }

    /**
     * ���������ն�����
     * @param ttyType �����õ������ն����͵�ֵ
     */
    public void setTtyType(String ttyType){
        this.ttyType = StringUtils.rightTrim(ttyType);
    }

    /**
     * ��ȡ�����ն�����
     * @return �����ն����͵�ֵ
     */
    public String getTtyType(){
        return ttyType;
    }

    /**
     * ���������ն�����
     * @param ttyName �����õ������ն����Ƶ�ֵ
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * ��ȡ�����ն�����
     * @return �����ն����Ƶ�ֵ
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * �������Դ�ӡ������
     * @param prtType �����õ����Դ�ӡ�����͵�ֵ
     */
    public void setPrtType(String prtType){
        this.prtType = StringUtils.rightTrim(prtType);
    }

    /**
     * ��ȡ���Դ�ӡ������
     * @return ���Դ�ӡ�����͵�ֵ
     */
    public String getPrtType(){
        return prtType;
    }

    /**
     * �������Դ�ӡ������
     * @param prtName �����õ����Դ�ӡ�����Ƶ�ֵ
     */
    public void setPrtName(String prtName){
        this.prtName = StringUtils.rightTrim(prtName);
    }

    /**
     * ��ȡ���Դ�ӡ������
     * @return ���Դ�ӡ�����Ƶ�ֵ
     */
    public String getPrtName(){
        return prtName;
    }

    /**
     * �������Դ�ӡģʽ��A/T/L��
     * @param prtMode �����õ����Դ�ӡģʽ��A/T/L����ֵ
     */
    public void setPrtMode(String prtMode){
        this.prtMode = StringUtils.rightTrim(prtMode);
    }

    /**
     * ��ȡ���Դ�ӡģʽ��A/T/L��
     * @return ���Դ�ӡģʽ��A/T/L����ֵ
     */
    public String getPrtMode(){
        return prtMode;
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
