package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimCompelcrash ���⳵���������ݱ�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CiClaimCompelcrashDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա��չ�˾���� */
    private String comCode = "";
    /** ���Գ������� */
    private String driverName = "";
    /** �������֤���� */
    private String idNo = "";
    /** ���Ե绰���� */
    private String telNo = "";
    /** ���Գ��ƺ� */
    private String carNo = "";
    /** ���Գ��� */
    private String carKind = "";
    /** ������ײ�𻵲�λ */
    private String damagePart = "";
    /** ���Թ��� */
    private String faultParty = "";
    /** ����һ�������˹�����Ϊ */
    private String faultBehavior = "";
    /** ���Գ���ʱ�� */
    private DateTime damageDate = new DateTime();
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���Ա���ʱ�� */
    private DateTime reportDate = new DateTime();
    /** �������붨��ʱ�� */
    private DateTime applyCertainTime = new DateTime();
    /** ���Զ�����ʼʱ�� */
    private DateTime certainStartTime =new DateTime();
    /** ���Լ���˫����ʾ */
    private String actorFlag = "";
    /** �����¹ʺ� */
    private String accidentNo = "";
    /** �����ϴ�ID�� */
    private String upLoadNo = "";
    /** ���Թ��������� */
    private String relatedRegistNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CiClaimCompelcrashDtoBase����
     */
    public CiClaimCompelcrashDtoBase(){
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
     * �������Ա��չ�˾����
     * @param comCode �����õ����Ա��չ�˾�����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ա��չ�˾����
     * @return ���Ա��չ�˾�����ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�������
     * @param driverName �����õ����Գ���������ֵ
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ���������ֵ
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * �����������֤����
     * @param idNo �����õ��������֤�����ֵ
     */
    public void setIdNo(String idNo){
        this.idNo = StringUtils.rightTrim(idNo);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdNo(){
        return idNo;
    }

    /**
     * �������Ե绰����
     * @param telNo �����õ����Ե绰�����ֵ
     */
    public void setTelNo(String telNo){
        this.telNo = StringUtils.rightTrim(telNo);
    }

    /**
     * ��ȡ���Ե绰����
     * @return ���Ե绰�����ֵ
     */
    public String getTelNo(){
        return telNo;
    }

    /**
     * �������Գ��ƺ�
     * @param carNo �����õ����Գ��ƺŵ�ֵ
     */
    public void setCarNo(String carNo){
        this.carNo = StringUtils.rightTrim(carNo);
    }

    /**
     * ��ȡ���Գ��ƺ�
     * @return ���Գ��ƺŵ�ֵ
     */
    public String getCarNo(){
        return carNo;
    }

    /**
     * �������Գ���
     * @param carKind �����õ����Գ��͵�ֵ
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
    }

    /**
     * ��ȡ���Գ���
     * @return ���Գ��͵�ֵ
     */
    public String getCarKind(){
        return carKind;
    }

    /**
     * ����������ײ�𻵲�λ
     * @param damagePart �����õ�������ײ�𻵲�λ��ֵ
     */
    public void setDamagePart(String damagePart){
        this.damagePart = StringUtils.rightTrim(damagePart);
    }

    /**
     * ��ȡ������ײ�𻵲�λ
     * @return ������ײ�𻵲�λ��ֵ
     */
    public String getDamagePart(){
        return damagePart;
    }

    /**
     * �������Թ���
     * @param faultParty �����õ����Թ�����ֵ
     */
    public void setFaultParty(String faultParty){
        this.faultParty = StringUtils.rightTrim(faultParty);
    }

    /**
     * ��ȡ���Թ���
     * @return ���Թ�����ֵ
     */
    public String getFaultParty(){
        return faultParty;
    }

    /**
     * ��������һ�������˹�����Ϊ
     * @param faultBehavior �����õ�����һ�������˹�����Ϊ��ֵ
     */
    public void setFaultBehavior(String faultBehavior){
        this.faultBehavior = StringUtils.rightTrim(faultBehavior);
    }

    /**
     * ��ȡ����һ�������˹�����Ϊ
     * @return ����һ�������˹�����Ϊ��ֵ
     */
    public String getFaultBehavior(){
        return faultBehavior;
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
     * �������Գ��յص�
     * @param damageAddress �����õ����Գ��յص��ֵ
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * ��ȡ���Գ��յص�
     * @return ���Գ��յص��ֵ
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * �������Ա���ʱ��
     * @param reportDate �����õ����Ա���ʱ���ֵ
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate =  reportDate;
    }

    /**
     * ��ȡ���Ա���ʱ��
     * @return ���Ա���ʱ���ֵ
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * �����������붨��ʱ��
     * @param applyCertainTime �����õ��������붨��ʱ���ֵ
     */
    public void setApplyCertainTime(DateTime applyCertainTime){
        this.applyCertainTime =  applyCertainTime;
    }

    /**
     * ��ȡ�������붨��ʱ��
     * @return �������붨��ʱ���ֵ
     */
    public DateTime getApplyCertainTime(){
        return applyCertainTime;
    }

    /**
     * �������Զ�����ʼʱ��
     * @param certainStartTime �����õ����Զ�����ʼʱ���ֵ
     */
    public void setCertainStartTime(DateTime certainStartTime){
        this.certainStartTime =  certainStartTime;
    }

    /**
     * ��ȡ���Զ�����ʼʱ��
     * @return ���Զ�����ʼʱ���ֵ
     */
    public DateTime getCertainStartTime(){
        return certainStartTime;
    }

    /**
     * �������Լ���˫����ʾ
     * @param actorFlag �����õ����Լ���˫����ʾ��ֵ
     */
    public void setActorFlag(String actorFlag){
        this.actorFlag = StringUtils.rightTrim(actorFlag);
    }

    /**
     * ��ȡ���Լ���˫����ʾ
     * @return ���Լ���˫����ʾ��ֵ
     */
    public String getActorFlag(){
        return actorFlag;
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
     * ���������ϴ�ID��
     * @param upLoadNo �����õ������ϴ�ID�ŵ�ֵ
     */
    public void setUpLoadNo(String upLoadNo){
        this.upLoadNo = StringUtils.rightTrim(upLoadNo);
    }

    /**
     * ��ȡ�����ϴ�ID��
     * @return �����ϴ�ID�ŵ�ֵ
     */
    public String getUpLoadNo(){
        return upLoadNo;
    }

    /**
     * �������Թ���������
     * @param relatedRegistNo �����õ����Թ��������ŵ�ֵ
     */
    public void setRelatedRegistNo(String relatedRegistNo){
        this.relatedRegistNo = StringUtils.rightTrim(relatedRegistNo);
    }

    /**
     * ��ȡ���Թ���������
     * @return ���Թ��������ŵ�ֵ
     */
    public String getRelatedRegistNo(){
        return relatedRegistNo;
    }
}
