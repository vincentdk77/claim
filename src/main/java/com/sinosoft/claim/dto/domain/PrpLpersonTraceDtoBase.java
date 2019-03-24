package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpersonTrace-���˸��ٱ�(����)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.750<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonTraceDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������Ա��� */
    private int personNo = 0;
    /** ������Ա���� */
    private String personName = "";
    /** �����Ա� */
    private String personSex = "";
    /** �������� */
    private int personAge = 0;
    /** �������֤���� */
    private String identifyNumber = "";
    /** ���Թ�����Ա��� */
    private int relatePersonNo = 0;
    /** ������ҵ���� */
    private String jobCode = "";
    /** ������ҵ���� */
    private String jobName = "";
    /** �����¹����漰���� */
    private String referKind = "";
    /** �������˲�λ���� */
    private String partDesc = "";
    /** ���Ծ���ҽԺ */
    private String hospital = "";
    /** �����Ƿ����о�ҽ */
    private String motionFlag = "";
    /** ������������ */
    private String woundRemark = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonTraceDtoBase����
     */
    public PrpLpersonTraceDtoBase(){
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ����������Ա���
     * @param personNo �����õ�������Ա��ŵ�ֵ
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * ��ȡ������Ա���
     * @return ������Ա��ŵ�ֵ
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * ����������Ա����
     * @param personName �����õ�������Ա������ֵ
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա������ֵ
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * ���������Ա�
     * @param personSex �����õ������Ա��ֵ
     */
    public void setPersonSex(String personSex){
        this.personSex = StringUtils.rightTrim(personSex);
    }

    /**
     * ��ȡ�����Ա�
     * @return �����Ա��ֵ
     */
    public String getPersonSex(){
        return personSex;
    }

    /**
     * ������������
     * @param personAge �����õ����������ֵ
     */
    public void setPersonAge(int personAge){
        this.personAge = personAge;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getPersonAge(){
        return personAge;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �������Թ�����Ա���
     * @param relatePersonNo �����õ����Թ�����Ա��ŵ�ֵ
     */
    public void setRelatePersonNo(int relatePersonNo){
        this.relatePersonNo = relatePersonNo;
    }

    /**
     * ��ȡ���Թ�����Ա���
     * @return ���Թ�����Ա��ŵ�ֵ
     */
    public int getRelatePersonNo(){
        return relatePersonNo;
    }

    /**
     * ����������ҵ����
     * @param jobCode �����õ�������ҵ�����ֵ
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ�����ֵ
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * ����������ҵ����
     * @param jobName �����õ�������ҵ���Ƶ�ֵ
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ���Ƶ�ֵ
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * ���������¹����漰����
     * @param referKind �����õ������¹����漰���ֵ�ֵ
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * ��ȡ�����¹����漰����
     * @return �����¹����漰���ֵ�ֵ
     */
    public String getReferKind(){
        return referKind;
    }

    /**
     * �����������˲�λ����
     * @param partDesc �����õ��������˲�λ������ֵ
     */
    public void setPartDesc(String partDesc){
        this.partDesc = StringUtils.rightTrim(partDesc);
    }

    /**
     * ��ȡ�������˲�λ����
     * @return �������˲�λ������ֵ
     */
    public String getPartDesc(){
        return partDesc;
    }

    /**
     * �������Ծ���ҽԺ
     * @param hospital �����õ����Ծ���ҽԺ��ֵ
     */
    public void setHospital(String hospital){
        this.hospital = StringUtils.rightTrim(hospital);
    }

    /**
     * ��ȡ���Ծ���ҽԺ
     * @return ���Ծ���ҽԺ��ֵ
     */
    public String getHospital(){
        return hospital;
    }

    /**
     * ���������Ƿ����о�ҽ
     * @param motionFlag �����õ������Ƿ����о�ҽ��ֵ
     */
    public void setMotionFlag(String motionFlag){
        this.motionFlag = StringUtils.rightTrim(motionFlag);
    }

    /**
     * ��ȡ�����Ƿ����о�ҽ
     * @return �����Ƿ����о�ҽ��ֵ
     */
    public String getMotionFlag(){
        return motionFlag;
    }

    /**
     * ����������������
     * @param woundRemark �����õ���������������ֵ
     */
    public void setWoundRemark(String woundRemark){
        this.woundRemark = StringUtils.rightTrim(woundRemark);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getWoundRemark(){
        return woundRemark;
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
