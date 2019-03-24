package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleCompany--����������ʾ��Ϣ���ñ�����ݴ���������<br>
 * ������ 2005-11-07 11:11:19.031<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyDtoBase implements Serializable{
    /** ���Ե������Ļ������� */
    private String comCode = "";
    /** �����ϰ�ʱ�� */
    private String onDutyTime = "";
    /** �����°�ʱ�� */
    private String offDutyTime = "";
    /** ������ʾ��Ϣ */
    private String promptContent = "";
    /** ���Թ̶��绰 */
    private String phoneNo = "";
    /** ���Ը����� */
    private String linkerName = "";
    /** �����ֻ����� */
    private String mobileNo = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־ */
    private String flag = "";
    /** ����am�ʺ� */
    private String amNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleCompanyDtoBase����
     */
    public PrpLscheduleCompanyDtoBase(){
    }

    /**
     * �������Ե������Ļ�������
     * @param comCode �����õ����Ե������Ļ��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ե������Ļ�������
     * @return ���Ե������Ļ��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ���������ϰ�ʱ��
     * @param onDutyTime �����õ������ϰ�ʱ���ֵ
     */
    public void setOnDutyTime(String onDutyTime){
        this.onDutyTime = StringUtils.rightTrim(onDutyTime);
    }

    /**
     * ��ȡ�����ϰ�ʱ��
     * @return �����ϰ�ʱ���ֵ
     */
    public String getOnDutyTime(){
        return onDutyTime;
    }

    /**
     * ���������°�ʱ��
     * @param offDutyTime �����õ������°�ʱ���ֵ
     */
    public void setOffDutyTime(String offDutyTime){
        this.offDutyTime = StringUtils.rightTrim(offDutyTime);
    }

    /**
     * ��ȡ�����°�ʱ��
     * @return �����°�ʱ���ֵ
     */
    public String getOffDutyTime(){
        return offDutyTime;
    }

    /**
     * ����������ʾ��Ϣ
     * @param promptContent �����õ�������ʾ��Ϣ��ֵ
     */
    public void setPromptContent(String promptContent){
        this.promptContent = StringUtils.rightTrim(promptContent);
    }

    /**
     * ��ȡ������ʾ��Ϣ
     * @return ������ʾ��Ϣ��ֵ
     */
    public String getPromptContent(){
        return promptContent;
    }

    /**
     * �������Թ̶��绰
     * @param phoneNo �����õ����Թ̶��绰��ֵ
     */
    public void setPhoneNo(String phoneNo){
        this.phoneNo = StringUtils.rightTrim(phoneNo);
    }

    /**
     * ��ȡ���Թ̶��绰
     * @return ���Թ̶��绰��ֵ
     */
    public String getPhoneNo(){
        return phoneNo;
    }

    /**
     * �������Ը�����
     * @param linkerName �����õ����Ը����˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ���Ը�����
     * @return ���Ը����˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ���������ֻ�����
     * @param mobileNo �����õ������ֻ������ֵ
     */
    public void setMobileNo(String mobileNo){
        this.mobileNo = StringUtils.rightTrim(mobileNo);
    }

    /**
     * ��ȡ�����ֻ�����
     * @return �����ֻ������ֵ
     */
    public String getMobileNo(){
        return mobileNo;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
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

    /**
     * ��������am�ʺ�
     * @param amNo �����õ�����am�ʺŵ�ֵ
     */
    public void setAmNo(String amNo){
        this.amNo = StringUtils.rightTrim(amNo);
    }

    /**
     * ��ȡ����am�ʺ�
     * @return ����am�ʺŵ�ֵ
     */
    public String getAmNo(){
        return amNo;
    }
}
