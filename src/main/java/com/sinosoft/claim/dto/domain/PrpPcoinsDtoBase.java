package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoins�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpPcoinsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����endorseNo */
    private String endorseNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����mainPolicyNo */
    private String mainPolicyNo = "";
    /** ����coinsCode */
    private String coinsCode = "";
    /** ����coinsName */
    private String coinsName = "";
    /** ����coinsType */
    private String coinsType = "";
    /** ����coinsRate */
    private double coinsRate = 0D;
    /** ����flag */
    private String flag = "";
    /** ����chiefFlag */
    private String chiefFlag = "";
    /** ����proportionFlag */
    private String proportionFlag = "";
    /** ����chgCoinsRate */
    private double chgCoinsRate = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPcoinsDtoBase����
     */
    public PrpPcoinsDtoBase(){
    }

    /**
     * ��������endorseNo
     * @param endorseNo �����õ�����endorseNo��ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����endorseNo
     * @return ����endorseNo��ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������mainPolicyNo
     * @param mainPolicyNo �����õ�����mainPolicyNo��ֵ
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * ��ȡ����mainPolicyNo
     * @return ����mainPolicyNo��ֵ
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * ��������coinsCode
     * @param coinsCode �����õ�����coinsCode��ֵ
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * ��ȡ����coinsCode
     * @return ����coinsCode��ֵ
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * ��������coinsName
     * @param coinsName �����õ�����coinsName��ֵ
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * ��ȡ����coinsName
     * @return ����coinsName��ֵ
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * ��������coinsType
     * @param coinsType �����õ�����coinsType��ֵ
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * ��ȡ����coinsType
     * @return ����coinsType��ֵ
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * ��������coinsRate
     * @param coinsRate �����õ�����coinsRate��ֵ
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * ��ȡ����coinsRate
     * @return ����coinsRate��ֵ
     */
    public double getCoinsRate(){
        return coinsRate;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������chiefFlag
     * @param chiefFlag �����õ�����chiefFlag��ֵ
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * ��ȡ����chiefFlag
     * @return ����chiefFlag��ֵ
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * ��������proportionFlag
     * @param proportionFlag �����õ�����proportionFlag��ֵ
     */
    public void setProportionFlag(String proportionFlag){
        this.proportionFlag = StringUtils.rightTrim(proportionFlag);
    }

    /**
     * ��ȡ����proportionFlag
     * @return ����proportionFlag��ֵ
     */
    public String getProportionFlag(){
        return proportionFlag;
    }

    /**
     * ��������chgCoinsRate
     * @param chgCoinsRate �����õ�����chgCoinsRate��ֵ
     */
    public void setChgCoinsRate(double chgCoinsRate){
        this.chgCoinsRate = chgCoinsRate;
    }

    /**
     * ��ȡ����chgCoinsRate
     * @return ����chgCoinsRate��ֵ
     */
    public double getChgCoinsRate(){
        return chgCoinsRate;
    }
}
