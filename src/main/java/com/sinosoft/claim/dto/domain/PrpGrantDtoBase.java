package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgrant��Ȩ��¼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGrantDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ������Ȩ���� */
    private String riskType = "";
    /** ������Ȩ���� */
    private String taskCode = "";
    /** ������Ȩ���� */
    private String checkType = "";
    /** ��������Ȩ�� */
    private String power = "";
    /** ������Ȩ��ʼʱ�� */
    private DateTime grantStartDate = new DateTime();
    /** ������Ȩ��ֹʱ�� */
    private DateTime grantEndDate = new DateTime();
    /** ������Ȩ���� */
    private String condition = "";
    /** ���������������� */
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
     * ����������Ȩ����
     * @param riskType �����õ�������Ȩ�����ֵ
     */
    public void setRiskType(String riskType){
        this.riskType = StringUtils.rightTrim(riskType);
    }

    /**
     * ��ȡ������Ȩ����
     * @return ������Ȩ�����ֵ
     */
    public String getRiskType(){
        return riskType;
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
     * @param checkType �����õ�������Ȩ���͵�ֵ
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * ��ȡ������Ȩ����
     * @return ������Ȩ���͵�ֵ
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * ������������Ȩ��
     * @param power �����õ���������Ȩ�޵�ֵ
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * ��ȡ��������Ȩ��
     * @return ��������Ȩ�޵�ֵ
     */
    public String getPower(){
        return power;
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
     * ��������������������
     * @param remark �����õ�������������������ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����������������
     * @return ������������������ֵ
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
