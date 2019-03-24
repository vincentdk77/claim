package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpccoins������Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcoinsDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �������������� */
    private String mainPolicyNo = "";
    /** ���Թ����˻������� */
    private String coinsCode = "";
    /** ���Թ��������� */
    private String coinsName = "";
    /** ���Թ������� */
    private String coinsType = "";
    /** ���Թ����ݶ� */
    private double coinsRate = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ����ChiefFlag */
    private String chiefFlag = "";
    /** ����ProportionFlag */
    private String proportionFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcoinsDtoBase����
     */
    public PrpCcoinsDtoBase(){
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
     * ������������������
     * @param mainPolicyNo �����õ����������������ֵ
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * ��ȡ��������������
     * @return ���������������ֵ
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * �������Թ����˻�������
     * @param coinsCode �����õ����Թ����˻��������ֵ
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * ��ȡ���Թ����˻�������
     * @return ���Թ����˻��������ֵ
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * �������Թ���������
     * @param coinsName �����õ����Թ��������Ƶ�ֵ
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * ��ȡ���Թ���������
     * @return ���Թ��������Ƶ�ֵ
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * �������Թ�������
     * @param coinsType �����õ����Թ������͵�ֵ
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������͵�ֵ
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * �������Թ����ݶ�
     * @param coinsRate �����õ����Թ����ݶ��ֵ
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * ��ȡ���Թ����ݶ�
     * @return ���Թ����ݶ��ֵ
     */
    public double getCoinsRate(){
        return coinsRate;
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

    /**
     * ��������ChiefFlag
     * @param chiefFlag �����õ�����ChiefFlag��ֵ
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * ��ȡ����ChiefFlag
     * @return ����ChiefFlag��ֵ
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * ��������ProportionFlag
     * @param proportionFlag �����õ�����ProportionFlag��ֵ
     */
    public void setProportionFlag(String proportionFlag){
        this.proportionFlag = StringUtils.rightTrim(proportionFlag);
    }

    /**
     * ��ȡ����ProportionFlag
     * @return ����ProportionFlag��ֵ
     */
    public String getProportionFlag(){
        return proportionFlag;
    }
}
