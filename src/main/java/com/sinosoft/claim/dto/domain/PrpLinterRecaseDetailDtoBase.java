package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ����״̬������ݴ���������<br>
 */
public class PrpLinterRecaseDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** ���Ա������� */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������������ */
    private String claimNo = "";
    /** ���Լ�������� */
    private String compensateNo = "";
    /** �����ؿ����� */
    private int recaseTime = 0;
    /** �����ؿ�����ɹ�(1�ɹ�) */
    private String recaseSuccFlag = "";
    /** �����ؿ������ɹ�(1�ɹ�) */
    private String appovlSuccFlag = "";
    /** �����ؿ�����ɹ�(1�ɹ�) */
    private String comppSuccFlag = "";
    /** �����ؿ�����ɹ�(1�ɹ�) */
    private String vericSuccFlag = "";
    /** �����ؿ��᰸�ɹ�(1�ɹ�) */
    private String endcaSuccFlag = "";
    /** ���Է�����Ϣ(�ɹ�/error) */
    private String remark = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterRecaseDetailDtoBase����
     */
    public PrpLinterRecaseDetailDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
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
     * ����������������
     * @param claimNo �����õ��������������ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Լ��������
     * @param compensateNo �����õ����Լ���������ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ���Լ��������
     * @return ���Լ���������ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ���������ؿ�����
     * @param recaseTime �����õ������ؿ�������ֵ
     */
    public void setRecaseTime(int recaseTime){
        this.recaseTime = recaseTime;
    }

    /**
     * ��ȡ�����ؿ�����
     * @return �����ؿ�������ֵ
     */
    public int getRecaseTime(){
        return recaseTime;
    }

    /**
     * ���������ؿ�����ɹ�(1�ɹ�)
     * @param recaseSuccFlag �����õ������ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public void setRecaseSuccFlag(String recaseSuccFlag){
        this.recaseSuccFlag = StringUtils.rightTrim(recaseSuccFlag);
    }

    /**
     * ��ȡ�����ؿ�����ɹ�(1�ɹ�)
     * @return �����ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public String getRecaseSuccFlag(){
        return recaseSuccFlag;
    }

    /**
     * ���������ؿ������ɹ�(1�ɹ�)
     * @param appovlSuccFlag �����õ������ؿ������ɹ�(1�ɹ�)��ֵ
     */
    public void setAppovlSuccFlag(String appovlSuccFlag){
        this.appovlSuccFlag = StringUtils.rightTrim(appovlSuccFlag);
    }

    /**
     * ��ȡ�����ؿ������ɹ�(1�ɹ�)
     * @return �����ؿ������ɹ�(1�ɹ�)��ֵ
     */
    public String getAppovlSuccFlag(){
        return appovlSuccFlag;
    }

    /**
     * ���������ؿ�����ɹ�(1�ɹ�)
     * @param comppSuccFlag �����õ������ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public void setComppSuccFlag(String comppSuccFlag){
        this.comppSuccFlag = StringUtils.rightTrim(comppSuccFlag);
    }

    /**
     * ��ȡ�����ؿ�����ɹ�(1�ɹ�)
     * @return �����ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public String getComppSuccFlag(){
        return comppSuccFlag;
    }

    /**
     * ���������ؿ�����ɹ�(1�ɹ�)
     * @param vericSuccFlag �����õ������ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * ��ȡ�����ؿ�����ɹ�(1�ɹ�)
     * @return �����ؿ�����ɹ�(1�ɹ�)��ֵ
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * ���������ؿ��᰸�ɹ�(1�ɹ�)
     * @param endcaSuccFlag �����õ������ؿ��᰸�ɹ�(1�ɹ�)��ֵ
     */
    public void setEndcaSuccFlag(String endcaSuccFlag){
        this.endcaSuccFlag = StringUtils.rightTrim(endcaSuccFlag);
    }

    /**
     * ��ȡ�����ؿ��᰸�ɹ�(1�ɹ�)
     * @return �����ؿ��᰸�ɹ�(1�ɹ�)��ֵ
     */
    public String getEndcaSuccFlag(){
        return endcaSuccFlag;
    }

    /**
     * �������Է�����Ϣ(�ɹ�/error)
     * @param remark �����õ����Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Է�����Ϣ(�ɹ�/error)
     * @return ���Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public String getRemark(){
        return remark;
    }
}
