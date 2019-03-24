package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prptask�����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpTaskDtoBase implements Serializable{
    /** ����������� */
    private String taskCode = "";
    /** ������������ */
    private String taskName = "";
    /** ����Ȩ�޼������� */
    private String checkType = "";
    /** ����Ȩ�޼����������� */
    private String checkName = "";
    /** ����Ȩ��ָ��λ�� */
    private int gradePoint = 0;
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
     * ��������Ȩ�޼�������
     * @param checkType �����õ�����Ȩ�޼������͵�ֵ
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * ��ȡ����Ȩ�޼�������
     * @return ����Ȩ�޼������͵�ֵ
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * ��������Ȩ�޼�����������
     * @param checkName �����õ�����Ȩ�޼����������Ƶ�ֵ
     */
    public void setCheckName(String checkName){
        this.checkName = StringUtils.rightTrim(checkName);
    }

    /**
     * ��ȡ����Ȩ�޼�����������
     * @return ����Ȩ�޼����������Ƶ�ֵ
     */
    public String getCheckName(){
        return checkName;
    }

    /**
     * ��������Ȩ��ָ��λ��
     * @param gradePoint �����õ�����Ȩ��ָ��λ�õ�ֵ
     */
    public void setGradePoint(int gradePoint){
        this.gradePoint = gradePoint;
    }

    /**
     * ��ȡ����Ȩ��ָ��λ��
     * @return ����Ȩ��ָ��λ�õ�ֵ
     */
    public int getGradePoint(){
        return gradePoint;
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
