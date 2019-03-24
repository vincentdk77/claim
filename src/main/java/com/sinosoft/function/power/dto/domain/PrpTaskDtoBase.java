package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpTask�������������ݴ���������<br>
 * ������ 2004-11-09 10:40:47.668<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpTaskDtoBase implements Serializable{
    /** ����������� */
    private String taskCode = "";
    /** ������������ */
    private String taskName = "";
    /** ����Ȩ�޼������ */
    private String checkCode = "";
    /** ����Ȩ�޼������� */
    private String checkName = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpTaskDtoBase����
     */
    public PrpTaskDtoBase(){
    }

    /**
     * ���������������
     * @param taskCode �����õ�������������ֵ
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * ����������������
     * @param taskName �����õ������������Ƶ�ֵ
     */
    public void setTaskName(String taskName){
        this.taskName = StringUtils.rightTrim(taskName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getTaskName(){
        return taskName;
    }

    /**
     * ��������Ȩ�޼������
     * @param checkCode �����õ�����Ȩ�޼�������ֵ
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * ��ȡ����Ȩ�޼������
     * @return ����Ȩ�޼�������ֵ
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * ��������Ȩ�޼�������
     * @param checkName �����õ�����Ȩ�޼������Ƶ�ֵ
     */
    public void setCheckName(String checkName){
        this.checkName = StringUtils.rightTrim(checkName);
    }

    /**
     * ��ȡ����Ȩ�޼�������
     * @return ����Ȩ�޼������Ƶ�ֵ
     */
    public String getCheckName(){
        return checkName;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
