package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCrash ���������¼�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCrashDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ������������˾ */
    private String claimCompany = "";
    /** ���Գ���ʱ�� */
    private DateTime damageDate = new DateTime();
    /** ���Ա���ʱ�� */
    private DateTime reportDate = new DateTime();
    /** ��������ʱ�� */
    private DateTime claimDate = new DateTime();
    /** ���Խ᰸ʱ�� */
    private DateTime endCaseDate = new DateTime();
    /** ���Թ����� */
    private double sumClaim = 0D;
    /** ��������� */
    private double sumPaid = 0D;
    /** ���԰���״̬ */
    private String claimStatus = "";
    /** �����¹ʺ� */
    private String accidentNo = "";
    /** ���Լ��ұ�־ */
    private String actorFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CiClaimCrashDtoBase����
     */
    public CiClaimCrashDtoBase(){
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
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ����������������˾
     * @param claimCompany �����õ�������������˾��ֵ
     */
    public void setClaimCompany(String claimCompany){
        this.claimCompany = StringUtils.rightTrim(claimCompany);
    }

    /**
     * ��ȡ������������˾
     * @return ������������˾��ֵ
     */
    public String getClaimCompany(){
        return claimCompany;
    }

    /**
     * �������Գ���ʱ��
     * @param damageDate �����õ����Գ���ʱ���ֵ
     */
    public void setDamageDate(DateTime damageDate){
        this.damageDate = damageDate;
    }

    /**
     * ��ȡ���Գ���ʱ��
     * @return ���Գ���ʱ���ֵ
     */
    public DateTime getDamageDate(){
        return damageDate;
    }

    /**
     * �������Ա���ʱ��
     * @param reportDate �����õ����Ա���ʱ���ֵ
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * ��ȡ���Ա���ʱ��
     * @return ���Ա���ʱ���ֵ
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * ������������ʱ��
     * @param claimDate �����õ���������ʱ���ֵ
     */
    public void setClaimDate(DateTime claimDate){
        this.claimDate = claimDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getClaimDate(){
        return claimDate;
    }

    /**
     * �������Խ᰸ʱ��
     * @param endCaseDate �����õ����Խ᰸ʱ���ֵ
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * ��ȡ���Խ᰸ʱ��
     * @return ���Խ᰸ʱ���ֵ
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * �������Թ�����
     * @param sumClaim �����õ����Թ������ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ������ֵ
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * �������������
     * @param sumPaid �����õ�����������ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * �������԰���״̬
     * @param claimStatus �����õ����԰���״̬��ֵ
     */
    public void setClaimStatus(String claimStatus){
        this.claimStatus = StringUtils.rightTrim(claimStatus);
    }

    /**
     * ��ȡ���԰���״̬
     * @return ���԰���״̬��ֵ
     */
    public String getClaimStatus(){
        return claimStatus;
    }

    /**
     * ���������¹ʺ�
     * @param accidentNo �����õ������¹ʺŵ�ֵ
     */
    public void setAccidentNo(String accidentNo){
        this.accidentNo = StringUtils.rightTrim(accidentNo);
    }

    /**
     * ��ȡ�����¹ʺ�
     * @return �����¹ʺŵ�ֵ
     */
    public String getAccidentNo(){
        return accidentNo;
    }

    /**
     * �������Լ��ұ�־
     * @param actorFlag �����õ����Լ��ұ�־��ֵ
     */
    public void setActorFlag(String actorFlag){
        this.actorFlag = StringUtils.rightTrim(actorFlag);
    }

    /**
     * ��ȡ���Լ��ұ�־
     * @return ���Լ��ұ�־��ֵ
     */
    public String getActorFlag(){
        return actorFlag;
    }
}
