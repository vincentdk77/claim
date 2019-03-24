package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciCheck--�⽡�յ�����������ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckDtoBase.class.getName().hashCode();
    /** ���Ա������� */
    private String registNo = "";
    /** ���Ե������ */
    private int times = 0;
    /** ���Ե���� */
    private String checkNo = "";
    /** ���Է���ڵ� */
    private String certiType = "";
    /** ���Է���ڵ��ҵ����� */
    private String certiNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ե������� */
    private String checkType = "";
    /** ���Ե������ݼ�Ҫ���� */
    private String checkContext = "";
    /** ���Ե������ */
    private String checkObject = "";
    /** ���Ե���������� */
    private String checkObjectDesc = "";
    /** ���Ե��鷽ʽ */
    private String checkNature = "";
    /** ���Ե�����ʼ���� */
    private DateTime checkDate = new DateTime();
    /** ���Ե�����ʼʱ�� */
    private String checkHour = "";
    /** ���Ե���������� */
    private DateTime checkEndDate = new DateTime();
    /** ���Ե������ʱ�� */
    private String checkEndHour = "";
    /** ���Ե���ص� */
    private String checkSite = "";
    /** �����¹�ԭ����� */
    private String damageCode = "";
    /** �����¹�ԭ��˵�� */
    private String damageName = "";
    /** �����¹����ʹ��� */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** ���Ե����˴��� */
    private String checkerCode = "";
    /** ��������˴��� */
    private String approverCode = "";
    /** ����������� */
    private DateTime approverDate = new DateTime();
    /** �������״̬ */
    private String approverStatus = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciCheckDtoBase����
     */
    public PrpLacciCheckDtoBase(){
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Ե������
     * @param times �����õ����Ե��������ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ���Ե������
     * @return ���Ե��������ֵ
     */
    public int getTimes(){
        return times;
    }

    /**
     * �������Ե����
     * @param checkNo �����õ����Ե���ŵ�ֵ
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * ��ȡ���Ե����
     * @return ���Ե���ŵ�ֵ
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * �������Է���ڵ�
     * @param certiType �����õ����Է���ڵ��ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Է���ڵ�
     * @return ���Է���ڵ��ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Է���ڵ��ҵ�����
     * @param certiNo �����õ����Է���ڵ��ҵ������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Է���ڵ��ҵ�����
     * @return ���Է���ڵ��ҵ������ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Ե�������
     * @param checkType �����õ����Ե������͵�ֵ
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * �������Ե������ݼ�Ҫ����
     * @param checkContext �����õ����Ե������ݼ�Ҫ������ֵ
     */
    public void setCheckContext(String checkContext){
        this.checkContext = StringUtils.rightTrim(checkContext);
    }

    /**
     * ��ȡ���Ե������ݼ�Ҫ����
     * @return ���Ե������ݼ�Ҫ������ֵ
     */
    public String getCheckContext(){
        return checkContext;
    }

    /**
     * �������Ե������
     * @param checkObject �����õ����Ե�������ֵ
     */
    public void setCheckObject(String checkObject){
        this.checkObject = StringUtils.rightTrim(checkObject);
    }

    /**
     * ��ȡ���Ե������
     * @return ���Ե�������ֵ
     */
    public String getCheckObject(){
        return checkObject;
    }

    /**
     * �������Ե����������
     * @param checkObjectDesc �����õ����Ե������������ֵ
     */
    public void setCheckObjectDesc(String checkObjectDesc){
        this.checkObjectDesc = StringUtils.rightTrim(checkObjectDesc);
    }

    /**
     * ��ȡ���Ե����������
     * @return ���Ե������������ֵ
     */
    public String getCheckObjectDesc(){
        return checkObjectDesc;
    }

    /**
     * �������Ե��鷽ʽ
     * @param checkNature �����õ����Ե��鷽ʽ��ֵ
     */
    public void setCheckNature(String checkNature){
        this.checkNature = StringUtils.rightTrim(checkNature);
    }

    /**
     * ��ȡ���Ե��鷽ʽ
     * @return ���Ե��鷽ʽ��ֵ
     */
    public String getCheckNature(){
        return checkNature;
    }

    /**
     * �������Ե�����ʼ����
     * @param checkDate �����õ����Ե�����ʼ���ڵ�ֵ
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * ��ȡ���Ե�����ʼ����
     * @return ���Ե�����ʼ���ڵ�ֵ
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * �������Ե�����ʼʱ��
     * @param checkHour �����õ����Ե�����ʼʱ���ֵ
     */
    public void setCheckHour(String checkHour){
        this.checkHour = StringUtils.rightTrim(checkHour);
    }

    /**
     * ��ȡ���Ե�����ʼʱ��
     * @return ���Ե�����ʼʱ���ֵ
     */
    public String getCheckHour(){
        return checkHour;
    }

    /**
     * �������Ե����������
     * @param checkEndDate �����õ����Ե���������ڵ�ֵ
     */
    public void setCheckEndDate(DateTime checkEndDate){
        this.checkEndDate = checkEndDate;
    }

    /**
     * ��ȡ���Ե����������
     * @return ���Ե���������ڵ�ֵ
     */
    public DateTime getCheckEndDate(){
        return checkEndDate;
    }

    /**
     * �������Ե������ʱ��
     * @param checkEndHour �����õ����Ե������ʱ���ֵ
     */
    public void setCheckEndHour(String checkEndHour){
        this.checkEndHour = StringUtils.rightTrim(checkEndHour);
    }

    /**
     * ��ȡ���Ե������ʱ��
     * @return ���Ե������ʱ���ֵ
     */
    public String getCheckEndHour(){
        return checkEndHour;
    }

    /**
     * �������Ե���ص�
     * @param checkSite �����õ����Ե���ص��ֵ
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * ��ȡ���Ե���ص�
     * @return ���Ե���ص��ֵ
     */
    public String getCheckSite(){
        return checkSite;
    }

    /**
     * ���������¹�ԭ�����
     * @param damageCode �����õ������¹�ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ�����¹�ԭ�����
     * @return �����¹�ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * ���������¹�ԭ��˵��
     * @param damageName �����õ������¹�ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ�����¹�ԭ��˵��
     * @return �����¹�ԭ��˵����ֵ
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * ���������¹����ʹ���
     * @param damageTypeCode �����õ������¹����ʹ����ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹����ʹ���
     * @return �����¹����ʹ����ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * ���������¹�����˵��
     * @param damageTypeName �����õ������¹�����˵����ֵ
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * ��ȡ�����¹�����˵��
     * @return �����¹�����˵����ֵ
     */
    public String getDamageTypeName(){
        return damageTypeName;
    }

    /**
     * �������Ե����˴���
     * @param checkerCode �����õ����Ե����˴����ֵ
     */
    public void setCheckerCode(String checkerCode){
        this.checkerCode = StringUtils.rightTrim(checkerCode);
    }

    /**
     * ��ȡ���Ե����˴���
     * @return ���Ե����˴����ֵ
     */
    public String getCheckerCode(){
        return checkerCode;
    }

    /**
     * ������������˴���
     * @param approverCode �����õ���������˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ��������˴���
     * @return ��������˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * ���������������
     * @param approverDate �����õ�����������ڵ�ֵ
     */
    public void setApproverDate(DateTime approverDate){
        this.approverDate = approverDate;
    }

    /**
     * ��ȡ�����������
     * @return ����������ڵ�ֵ
     */
    public DateTime getApproverDate(){
        return approverDate;
    }

    /**
     * �����������״̬
     * @param approverStatus �����õ��������״̬��ֵ
     */
    public void setApproverStatus(String approverStatus){
        this.approverStatus = StringUtils.rightTrim(approverStatus);
    }

    /**
     * ��ȡ�������״̬
     * @return �������״̬��ֵ
     */
    public String getApproverStatus(){
        return approverStatus;
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
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
