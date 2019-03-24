package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcguaranty������Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCguarantyDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ե�����ʽ */
    private String guaranteeType = "";
    /** ������Ѻ��ʽ */
    private String inpawnType = "";
    /** ���Ե�(��)Ѻ��ͬ�� */
    private String mortgageNo = "";
    /** ����Ȩ����� */
    private String obligeeType = "";
    /** ���Ե�Ѻ�����ʣ������� */
    private String warrantorName = "";
    /** ���Ե�Ѻ���ʣ�Ȩ�� */
    private String guarantyObligee = "";
    /** ���Ե��������� */
    private String guarantyName = "";
    /** ���Ե��������ͺ� */
    private String model = "";
    /** ���Ե����������λ */
    private String unit = "";
    /** ���Ե��������� */
    private int quantity = 0;
    /** ���Ե���������Ȩ�� */
    private String possessor = "";
    /** ���Ե��������ڴ��� */
    private String guarantyAddress = "";
    /** ���Ե����ﱣ���� */
    private String guarantyKeeper = "";
    /** ���Բ�Ȩ֤��� */
    private String propCertifNo = "";
    /** ���Ե�����������ֵ */
    private double guarantyAssessment = 0d;
    /** �����Ѿ�Ϊ����ծȨ�趨��� */
    private double otherRating = 0d;
    /** ������Ѻ������״�� */
    private String inpawnQuality = "";
    /** ������Ѻ������ԭֵ */
    private double originalValue = 0d;
    /** ������Ѻ�ﾻֵ */
    private double netValue = 0d;
    /** ���������� */
    private String valuator = "";
    /** ����Ȩ����Ч�� */
    private DateTime rightValidPeriod = new DateTime();
    /** �������������� */
    private DateTime encashDate = new DateTime();
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCguarantyDtoBase����
     */
    public PrpCguarantyDtoBase(){
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
     * �������Ե�����ʽ
     * @param guaranteeType �����õ����Ե�����ʽ��ֵ
     */
    public void setGuaranteeType(String guaranteeType){
        this.guaranteeType = StringUtils.rightTrim(guaranteeType);
    }

    /**
     * ��ȡ���Ե�����ʽ
     * @return ���Ե�����ʽ��ֵ
     */
    public String getGuaranteeType(){
        return guaranteeType;
    }

    /**
     * ����������Ѻ��ʽ
     * @param inpawnType �����õ�������Ѻ��ʽ��ֵ
     */
    public void setInpawnType(String inpawnType){
        this.inpawnType = StringUtils.rightTrim(inpawnType);
    }

    /**
     * ��ȡ������Ѻ��ʽ
     * @return ������Ѻ��ʽ��ֵ
     */
    public String getInpawnType(){
        return inpawnType;
    }

    /**
     * �������Ե�(��)Ѻ��ͬ��
     * @param mortgageNo �����õ����Ե�(��)Ѻ��ͬ�ŵ�ֵ
     */
    public void setMortgageNo(String mortgageNo){
        this.mortgageNo = StringUtils.rightTrim(mortgageNo);
    }

    /**
     * ��ȡ���Ե�(��)Ѻ��ͬ��
     * @return ���Ե�(��)Ѻ��ͬ�ŵ�ֵ
     */
    public String getMortgageNo(){
        return mortgageNo;
    }

    /**
     * ��������Ȩ�����
     * @param obligeeType �����õ�����Ȩ������ֵ
     */
    public void setObligeeType(String obligeeType){
        this.obligeeType = StringUtils.rightTrim(obligeeType);
    }

    /**
     * ��ȡ����Ȩ�����
     * @return ����Ȩ������ֵ
     */
    public String getObligeeType(){
        return obligeeType;
    }

    /**
     * �������Ե�Ѻ�����ʣ�������
     * @param warrantorName �����õ����Ե�Ѻ�����ʣ������Ƶ�ֵ
     */
    public void setWarrantorName(String warrantorName){
        this.warrantorName = StringUtils.rightTrim(warrantorName);
    }

    /**
     * ��ȡ���Ե�Ѻ�����ʣ�������
     * @return ���Ե�Ѻ�����ʣ������Ƶ�ֵ
     */
    public String getWarrantorName(){
        return warrantorName;
    }

    /**
     * �������Ե�Ѻ���ʣ�Ȩ��
     * @param guarantyObligee �����õ����Ե�Ѻ���ʣ�Ȩ�˵�ֵ
     */
    public void setGuarantyObligee(String guarantyObligee){
        this.guarantyObligee = StringUtils.rightTrim(guarantyObligee);
    }

    /**
     * ��ȡ���Ե�Ѻ���ʣ�Ȩ��
     * @return ���Ե�Ѻ���ʣ�Ȩ�˵�ֵ
     */
    public String getGuarantyObligee(){
        return guarantyObligee;
    }

    /**
     * �������Ե���������
     * @param guarantyName �����õ����Ե��������Ƶ�ֵ
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * ��ȡ���Ե���������
     * @return ���Ե��������Ƶ�ֵ
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * �������Ե��������ͺ�
     * @param model �����õ����Ե��������ͺŵ�ֵ
     */
    public void setModel(String model){
        this.model = StringUtils.rightTrim(model);
    }

    /**
     * ��ȡ���Ե��������ͺ�
     * @return ���Ե��������ͺŵ�ֵ
     */
    public String getModel(){
        return model;
    }

    /**
     * �������Ե����������λ
     * @param unit �����õ����Ե����������λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ���Ե����������λ
     * @return ���Ե����������λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * �������Ե���������
     * @param quantity �����õ����Ե�����������ֵ
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ���Ե���������
     * @return ���Ե�����������ֵ
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * �������Ե���������Ȩ��
     * @param possessor �����õ����Ե���������Ȩ����ֵ
     */
    public void setPossessor(String possessor){
        this.possessor = StringUtils.rightTrim(possessor);
    }

    /**
     * ��ȡ���Ե���������Ȩ��
     * @return ���Ե���������Ȩ����ֵ
     */
    public String getPossessor(){
        return possessor;
    }

    /**
     * �������Ե��������ڴ���
     * @param guarantyAddress �����õ����Ե��������ڴ�����ֵ
     */
    public void setGuarantyAddress(String guarantyAddress){
        this.guarantyAddress = StringUtils.rightTrim(guarantyAddress);
    }

    /**
     * ��ȡ���Ե��������ڴ���
     * @return ���Ե��������ڴ�����ֵ
     */
    public String getGuarantyAddress(){
        return guarantyAddress;
    }

    /**
     * �������Ե����ﱣ����
     * @param guarantyKeeper �����õ����Ե����ﱣ���˵�ֵ
     */
    public void setGuarantyKeeper(String guarantyKeeper){
        this.guarantyKeeper = StringUtils.rightTrim(guarantyKeeper);
    }

    /**
     * ��ȡ���Ե����ﱣ����
     * @return ���Ե����ﱣ���˵�ֵ
     */
    public String getGuarantyKeeper(){
        return guarantyKeeper;
    }

    /**
     * �������Բ�Ȩ֤���
     * @param propCertifNo �����õ����Բ�Ȩ֤��ŵ�ֵ
     */
    public void setPropCertifNo(String propCertifNo){
        this.propCertifNo = StringUtils.rightTrim(propCertifNo);
    }

    /**
     * ��ȡ���Բ�Ȩ֤���
     * @return ���Բ�Ȩ֤��ŵ�ֵ
     */
    public String getPropCertifNo(){
        return propCertifNo;
    }

    /**
     * �������Ե�����������ֵ
     * @param guarantyAssessment �����õ����Ե�����������ֵ��ֵ
     */
    public void setGuarantyAssessment(double guarantyAssessment){
        this.guarantyAssessment = guarantyAssessment;
    }

    /**
     * ��ȡ���Ե�����������ֵ
     * @return ���Ե�����������ֵ��ֵ
     */
    public double getGuarantyAssessment(){
        return guarantyAssessment;
    }

    /**
     * ���������Ѿ�Ϊ����ծȨ�趨���
     * @param otherRating �����õ������Ѿ�Ϊ����ծȨ�趨��ȵ�ֵ
     */
    public void setOtherRating(double otherRating){
        this.otherRating = otherRating;
    }

    /**
     * ��ȡ�����Ѿ�Ϊ����ծȨ�趨���
     * @return �����Ѿ�Ϊ����ծȨ�趨��ȵ�ֵ
     */
    public double getOtherRating(){
        return otherRating;
    }

    /**
     * ����������Ѻ������״��
     * @param inpawnQuality �����õ�������Ѻ������״����ֵ
     */
    public void setInpawnQuality(String inpawnQuality){
        this.inpawnQuality = StringUtils.rightTrim(inpawnQuality);
    }

    /**
     * ��ȡ������Ѻ������״��
     * @return ������Ѻ������״����ֵ
     */
    public String getInpawnQuality(){
        return inpawnQuality;
    }

    /**
     * ����������Ѻ������ԭֵ
     * @param originalValue �����õ�������Ѻ������ԭֵ��ֵ
     */
    public void setOriginalValue(double originalValue){
        this.originalValue = originalValue;
    }

    /**
     * ��ȡ������Ѻ������ԭֵ
     * @return ������Ѻ������ԭֵ��ֵ
     */
    public double getOriginalValue(){
        return originalValue;
    }

    /**
     * ����������Ѻ�ﾻֵ
     * @param netValue �����õ�������Ѻ�ﾻֵ��ֵ
     */
    public void setNetValue(double netValue){
        this.netValue = netValue;
    }

    /**
     * ��ȡ������Ѻ�ﾻֵ
     * @return ������Ѻ�ﾻֵ��ֵ
     */
    public double getNetValue(){
        return netValue;
    }

    /**
     * ��������������
     * @param valuator �����õ����������˵�ֵ
     */
    public void setValuator(String valuator){
        this.valuator = StringUtils.rightTrim(valuator);
    }

    /**
     * ��ȡ����������
     * @return ���������˵�ֵ
     */
    public String getValuator(){
        return valuator;
    }

    /**
     * ��������Ȩ����Ч��
     * @param rightValidPeriod �����õ�����Ȩ����Ч�ڵ�ֵ
     */
    public void setRightValidPeriod(DateTime rightValidPeriod){
        this.rightValidPeriod = rightValidPeriod;
    }

    /**
     * ��ȡ����Ȩ����Ч��
     * @return ����Ȩ����Ч�ڵ�ֵ
     */
    public DateTime getRightValidPeriod(){
        return rightValidPeriod;
    }

    /**
     * ������������������
     * @param encashDate �����õ��������������ڵ�ֵ
     */
    public void setEncashDate(DateTime encashDate){
        this.encashDate = encashDate;
    }

    /**
     * ��ȡ��������������
     * @return �������������ڵ�ֵ
     */
    public DateTime getEncashDate(){
        return encashDate;
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
