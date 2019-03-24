package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLnodutyLoss�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLnodutyLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����riskCode */
    private String riskCode = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����kindCode */
    private String kindCode = "";
    /** ����licenseNo */
    private String licenseNo = "";
    /** ����insuredName */
    private String insuredName = "";
    /** ����driverLicenseNo */
    private String driverLicenseNo = "";
    /** ����insuredCompanyCode */
    private String insuredCompanyCode = "";
    /** ����insuredCompanyName */
    private String insuredCompanyName = "";
    /** ����dutyPercent */
    private double dutyPercent = 0D;
    /** ����paidType */
    private String paidType = "";
    /** ����paidName */
    private String paidName = "";
    /** ����currency */
    private String currency = "";
    /** ����verifyPaid */
    private double verifyPaid = 0D;
    /** ����limitPaid */
    private double limitPaid = 0D;
    /** ����realPaid */
    private double realPaid = 0D;
    /** ����dutyType */
    private String dutyType = "";
    /** ����replaceFlag */
    private String replaceFlag = "";
    /** ����remark */
    private String remark = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLnodutyLossDtoBase����
     */
    public PrpLnodutyLossDtoBase(){
    }

    /**
     * ��������compensateNo
     * @param compensateNo �����õ�����compensateNo��ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ����compensateNo
     * @return ����compensateNo��ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������riskCode
     * @param riskCode �����õ�����riskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskCode
     * @return ����riskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * ��������kindCode
     * @param kindCode �����õ�����kindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindCode
     * @return ����kindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������licenseNo
     * @param licenseNo �����õ�����licenseNo��ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ����licenseNo
     * @return ����licenseNo��ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * ��������insuredName
     * @param insuredName �����õ�����insuredName��ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ����insuredName
     * @return ����insuredName��ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ��������driverLicenseNo
     * @param driverLicenseNo �����õ�����driverLicenseNo��ֵ
     */
    public void setDriverLicenseNo(String driverLicenseNo){
        this.driverLicenseNo = StringUtils.rightTrim(driverLicenseNo);
    }

    /**
     * ��ȡ����driverLicenseNo
     * @return ����driverLicenseNo��ֵ
     */
    public String getDriverLicenseNo(){
        return driverLicenseNo;
    }

    /**
     * ��������insuredCompanyCode
     * @param insuredCompanyCode �����õ�����insuredCompanyCode��ֵ
     */
    public void setInsuredCompanyCode(String insuredCompanyCode){
        this.insuredCompanyCode = StringUtils.rightTrim(insuredCompanyCode);
    }

    /**
     * ��ȡ����insuredCompanyCode
     * @return ����insuredCompanyCode��ֵ
     */
    public String getInsuredCompanyCode(){
        return insuredCompanyCode;
    }

    /**
     * ��������insuredCompanyName
     * @param insuredCompanyName �����õ�����insuredCompanyName��ֵ
     */
    public void setInsuredCompanyName(String insuredCompanyName){
        this.insuredCompanyName = StringUtils.rightTrim(insuredCompanyName);
    }

    /**
     * ��ȡ����insuredCompanyName
     * @return ����insuredCompanyName��ֵ
     */
    public String getInsuredCompanyName(){
        return insuredCompanyName;
    }

    /**
     * ��������dutyPercent
     * @param dutyPercent �����õ�����dutyPercent��ֵ
     */
    public void setDutyPercent(double dutyPercent){
        this.dutyPercent = dutyPercent;
    }

    /**
     * ��ȡ����dutyPercent
     * @return ����dutyPercent��ֵ
     */
    public double getDutyPercent(){
        return dutyPercent;
    }

    /**
     * ��������paidType
     * @param paidType �����õ�����paidType��ֵ
     */
    public void setPaidType(String paidType){
        this.paidType = StringUtils.rightTrim(paidType);
    }

    /**
     * ��ȡ����paidType
     * @return ����paidType��ֵ
     */
    public String getPaidType(){
        return paidType;
    }

    /**
     * ��������paidName
     * @param paidName �����õ�����paidName��ֵ
     */
    public void setPaidName(String paidName){
        this.paidName = StringUtils.rightTrim(paidName);
    }

    /**
     * ��ȡ����paidName
     * @return ����paidName��ֵ
     */
    public String getPaidName(){
        return paidName;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������verifyPaid
     * @param verifyPaid �����õ�����verifyPaid��ֵ
     */
    public void setVerifyPaid(double verifyPaid){
        this.verifyPaid = verifyPaid;
    }

    /**
     * ��ȡ����verifyPaid
     * @return ����verifyPaid��ֵ
     */
    public double getVerifyPaid(){
        return verifyPaid;
    }

    /**
     * ��������limitPaid
     * @param limitPaid �����õ�����limitPaid��ֵ
     */
    public void setLimitPaid(double limitPaid){
        this.limitPaid = limitPaid;
    }

    /**
     * ��ȡ����limitPaid
     * @return ����limitPaid��ֵ
     */
    public double getLimitPaid(){
        return limitPaid;
    }

    /**
     * ��������realPaid
     * @param realPaid �����õ�����realPaid��ֵ
     */
    public void setRealPaid(double realPaid){
        this.realPaid = realPaid;
    }

    /**
     * ��ȡ����realPaid
     * @return ����realPaid��ֵ
     */
    public double getRealPaid(){
        return realPaid;
    }

    /**
     * ��������dutyType
     * @param dutyType �����õ�����dutyType��ֵ
     */
    public void setDutyType(String dutyType){
        this.dutyType = StringUtils.rightTrim(dutyType);
    }

    /**
     * ��ȡ����dutyType
     * @return ����dutyType��ֵ
     */
    public String getDutyType(){
        return dutyType;
    }

    /**
     * ��������replaceFlag
     * @param replaceFlag �����õ�����replaceFlag��ֵ
     */
    public void setReplaceFlag(String replaceFlag){
        this.replaceFlag = StringUtils.rightTrim(replaceFlag);
    }

    /**
     * ��ȡ����replaceFlag
     * @return ����replaceFlag��ֵ
     */
    public String getReplaceFlag(){
        return replaceFlag;
    }

    /**
     * ��������remark
     * @param remark �����õ�����remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����remark
     * @return ����remark��ֵ
     */
    public String getRemark(){
        return remark;
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
}
