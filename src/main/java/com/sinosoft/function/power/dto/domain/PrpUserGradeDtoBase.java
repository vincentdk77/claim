package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpUserGrade Ա��Ȩ�ޱ�����ݴ���������<br>
 * ������ 2004-11-09 10:40:47.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ����Ȩ����Ŵ��� */
    private String groupCode = "";
    /** ����������� */
    private String taskCode = "";
    /** ����Ȩ�޼������ */
    private String checkCode = "";
    /** ���Ծ���ȡֵ */
    private String value = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpUserGradeDtoBase����
     */
    public PrpUserGradeDtoBase(){
    }

    /**
     * ��������Ա������
     * @param userCode �����õ�����Ա�������ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�������ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������Ȩ����Ŵ���
     * @param groupCode �����õ�����Ȩ����Ŵ����ֵ
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * ��ȡ����Ȩ����Ŵ���
     * @return ����Ȩ����Ŵ����ֵ
     */
    public String getGroupCode(){
        return groupCode;
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
     * �������Ծ���ȡֵ
     * @param value �����õ����Ծ���ȡֵ��ֵ
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * ��ȡ���Ծ���ȡֵ
     * @return ���Ծ���ȡֵ��ֵ
     */
    public String getValue(){
        return value;
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
