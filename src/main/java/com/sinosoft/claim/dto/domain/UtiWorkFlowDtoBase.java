package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiworkflow������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiWorkFlowDtoBase implements Serializable{
    /** ���Թ��������� */
    private String workflowName = "";
    /** ���Թ��� */
    private String orderNo = "";
    /** ������Ϣ */
    private String message = "";
    /** ������ʾ */
    private String note = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiWorkFlowDtoBase����
     */
    public UtiWorkFlowDtoBase(){
    }

    /**
     * �������Թ���������
     * @param workflowName �����õ����Թ��������Ƶ�ֵ
     */
    public void setWorkflowName(String workflowName){
        this.workflowName = StringUtils.rightTrim(workflowName);
    }

    /**
     * ��ȡ���Թ���������
     * @return ���Թ��������Ƶ�ֵ
     */
    public String getWorkflowName(){
        return workflowName;
    }

    /**
     * �������Թ���
     * @param orderNo �����õ����Թ����ֵ
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * ��ȡ���Թ���
     * @return ���Թ����ֵ
     */
    public String getOrderNo(){
        return orderNo;
    }

    /**
     * ����������Ϣ
     * @param message �����õ�������Ϣ��ֵ
     */
    public void setMessage(String message){
        this.message = StringUtils.rightTrim(message);
    }

    /**
     * ��ȡ������Ϣ
     * @return ������Ϣ��ֵ
     */
    public String getMessage(){
        return message;
    }

    /**
     * ����������ʾ
     * @param note �����õ�������ʾ��ֵ
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * ��ȡ������ʾ
     * @return ������ʾ��ֵ
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
