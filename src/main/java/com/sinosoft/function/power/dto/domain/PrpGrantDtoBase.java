package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpGrant ��Ȩ��¼������ݴ���������<br>
 * ������ 2004-11-09 10:40:47.668<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ����Ȩ����� */
    private String groupCode = "";
    /** ������Ȩ���� */
    private String taskCode = "";
    /** ������Ȩ���� */
    private String checkCode = "";
    /** ��������ֵ */
    private String value = "";
    /** ������Ȩ��ʼʱ�� */
    private DateTime grantStartDate = new DateTime();
    /** ������Ȩ��ֹʱ�� */
    private DateTime grantEndDate = new DateTime();
    /** ������Ȩ���� */
    private String condition = "";
    /** ������Ȩ�������� */
    private String remark = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGrantDtoBase����
     */
    public PrpGrantDtoBase(){
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
     * ��������Ȩ�����
     * @param groupCode �����õ�����Ȩ����ŵ�ֵ
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * ��ȡ����Ȩ�����
     * @return ����Ȩ����ŵ�ֵ
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * ����������Ȩ����
     * @param taskCode �����õ�������Ȩ�����ֵ
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * ��ȡ������Ȩ����
     * @return ������Ȩ�����ֵ
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * ����������Ȩ����
     * @param checkCode �����õ�������Ȩ���͵�ֵ
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * ��ȡ������Ȩ����
     * @return ������Ȩ���͵�ֵ
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * ������������ֵ
     * @param value �����õ���������ֵ��ֵ
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * ��ȡ��������ֵ
     * @return ��������ֵ��ֵ
     */
    public String getValue(){
        return value;
    }

    /**
     * ����������Ȩ��ʼʱ��
     * @param grantStartDate �����õ�������Ȩ��ʼʱ�޵�ֵ
     */
    public void setGrantStartDate(DateTime grantStartDate){
        this.grantStartDate = grantStartDate;
    }

    /**
     * ��ȡ������Ȩ��ʼʱ��
     * @return ������Ȩ��ʼʱ�޵�ֵ
     */
    public DateTime getGrantStartDate(){
        return grantStartDate;
    }

    /**
     * ����������Ȩ��ֹʱ��
     * @param grantEndDate �����õ�������Ȩ��ֹʱ�޵�ֵ
     */
    public void setGrantEndDate(DateTime grantEndDate){
        this.grantEndDate = grantEndDate;
    }

    /**
     * ��ȡ������Ȩ��ֹʱ��
     * @return ������Ȩ��ֹʱ�޵�ֵ
     */
    public DateTime getGrantEndDate(){
        return grantEndDate;
    }

    /**
     * ����������Ȩ����
     * @param condition �����õ�������Ȩ������ֵ
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * ��ȡ������Ȩ����
     * @return ������Ȩ������ֵ
     */
    public String getCondition(){
        return condition;
    }

    /**
     * ����������Ȩ��������
     * @param remark �����õ�������Ȩ����������ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ������Ȩ��������
     * @return ������Ȩ����������ֵ
     */
    public String getRemark(){
        return remark;
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
