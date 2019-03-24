package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLclaim-����������Ϣ������ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLclaimtgDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLclaimtgDtoBase.class.getName().hashCode();
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ������������
--** L������
--** D1: ����
--** D2: ���鿱
--** D3: ������
--** B1��������
--** B2�������鿱
--** B3���������� */
    private String lFlag = "";
    /** �����ⰸ�� */
    private String caseNo = "";
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ����ҵ������ */
    private String businessNature = "";
    /** �������� */
    private String language = "";
    /** ���Ա������� */
    private String policyType = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** ������Сʱ */
    private int startHour = 0;
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** �����ձ�Сʱ */
    private int endHour = 0;
    /** ���Աұ���� */
    private String currency = "";
    /** �����ܱ���
--** �軹ԭ����������ʱ�Ľ�� */
    private double sumAmount = 0D;
    /** �����ܱ��� */
    private double sumPremium = 0D;
    /** ���������� */
    private int sumQuantity = 0;
    /** ���Գ��������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ��տ�ʼСʱ */
    private String damageStartHour = "";
    /** ���Գ�������ֹ */
    private DateTime damageEndDate = new DateTime();
    /** ���Գ�����ֹСʱ */
    private String damageEndHour = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /** �����¹����ʹ��� */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���Գ����������� */
    private String damageAreaName = "";
    /** ���Գ��յص������� */
    private String damageAddressType = "";
    /** ���Ե�ַ���� */
    private String addressCode = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���������� */
    private String lossName = "";
    /** ��������������/���շֻ��� */
    private int lossQuantity = 0;
    /** ���Գ����ձ� */
    private String damageKind = "";
    /** ������������ */
    private DateTime claimDate = new DateTime();
    /** �����⳥���δ���--** ȫ��/��Ҫ/�Ե�/��Ҫ/������ */
    private String indemnityDuty = "";
    /** �������α��� */
    private double indemnityDutyRate = 0D;
    /** ���������� */
    private double deductibleRate = 0D;
    /** ���Ա�����ʧ���(ͬ�����ұ�) */
    private double sumClaim = 0D;
    /** �����ܺ˶�����(ͬ�����ұ�) */
    private double sumDefLoss = 0D;
    /** �������⸶���(ͬ�����ұ�)--** (ʵ��+Ԥ��) */
    private double sumPaid = 0D;
    /** ������׷�����(ͬ�����ұ�) */
    private double sumReplevy = 0D;
    /** ���Ա�ע */
    private String remark = "";
    /** ���԰�������--** �⸶/ע��/���� */
    private String caseType = "";
    /** ��������Ǽǻ������� */
    private String makeCom = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ����ͳ������ */
    private DateTime statisticsYM = new DateTime();
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Խ᰸���� */
    private DateTime endCaseDate = new DateTime();
    /** ���Խ᰸Ա���� */
    private String endCaserCode = "";
    /** ����ע��/�������� */
    private DateTime cancelDate = new DateTime();
    /** ����ע��/����ԭ�� */
    private String cancelReason = "";
    /** ����ע��/�����˴��� */
    private String dealerCode = "";
    /** �����Ƿ�Ϊ���ݰ� */
    private String escapeFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** �����Ƿ������׷�� */
    private String replevyFlag = "";
    /** �����Ƿ������������н���� */
    private String thirdComFlag = "";
    /** �����Ƿ��Զ��᰸ */
    private String endCaseFlag = "";
    /** ���Լ��������α��� */
    private double cIndemnityDutyRate = 0D;
    /** ���Գ��յص��������� */
    private String damageAreaPostCode = "";
    /** ���Ծ���һ������ */
    private String catastropheCode1 = "";
    /** ���Ծ���һ������ */
    private String catastropheName1 = "";
    /** ���Ծ��ֶ������� */
    private String catastropheCode2 = "";
    /** ���԰������� */
    private String claimType = "";
    /** ���Ծ��ֶ������� */
    private String catastropheName2 = "";
    
    private DateTime claimTime = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimtgDtoBase����
     */
    public PrpLclaimtgDtoBase(){
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ����������������
--** L������
--** D1: ����
--** D2: ���鿱
--** D3: ������
--** B1��������
--** B2�������鿱
--** B3����������
     * @param lFlag �����õ�������������
--** L������
--** D1: ����
--** D2: ���鿱
--** D3: ������
--** B1��������
--** B2�������鿱
--** B3�����������ֵ
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * ��ȡ������������
--** L������
--** D1: ����
--** D2: ���鿱
--** D3: ������
--** B1��������
--** B2�������鿱
--** B3����������
     * @return ������������
--** L������
--** D1: ����
--** D2: ���鿱
--** D3: ������
--** B1��������
--** B2�������鿱
--** B3�����������ֵ
     */
    public String getLFlag(){
        return lFlag;
    }

    /**
     * ���������ⰸ��
     * @param caseNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getCaseNo(){
        return caseNo;
    }

    /**
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
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
     * ��������ҵ������
     * @param businessNature �����õ�����ҵ�����ʵ�ֵ
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����ʵ�ֵ
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * ������������
     * @param language �����õ��������ֵ�ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * �������Ա�������
     * @param policyType �����õ����Ա������͵�ֵ
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������͵�ֵ
     */
    public String getPolicyType(){
        return policyType;
    }

    /**
     * �������Ա������˴���
     * @param insuredCode �����õ����Ա������˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա������˴���
     * @return ���Ա������˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա�����������
     * @param insuredName �����õ����Ա����������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ��������������
     * @param startDate �����õ����������ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����������
     * @return ���������ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * ���������ձ�Сʱ
     * @param endHour �����õ������ձ�Сʱ��ֵ
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * ��ȡ�����ձ�Сʱ
     * @return �����ձ�Сʱ��ֵ
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������ܱ���
--** �軹ԭ����������ʱ�Ľ��
     * @param sumAmount �����õ������ܱ���
--** �軹ԭ����������ʱ�Ľ���ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ�����ܱ���
--** �軹ԭ����������ʱ�Ľ��
     * @return �����ܱ���
--** �軹ԭ����������ʱ�Ľ���ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * ���������ܱ���
     * @param sumPremium �����õ������ܱ��ѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ��ѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ��������������
     * @param sumQuantity �����õ�������������ֵ
     */
    public void setSumQuantity(int sumQuantity){
        this.sumQuantity = sumQuantity;
    }

    /**
     * ��ȡ����������
     * @return ������������ֵ
     */
    public int getSumQuantity(){
        return sumQuantity;
    }

    /**
     * �������Գ���������
     * @param damageStartDate �����õ����Գ����������ֵ
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * ��ȡ���Գ���������
     * @return ���Գ����������ֵ
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * �������Գ��տ�ʼСʱ
     * @param damageStartHour �����õ����Գ��տ�ʼСʱ��ֵ
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * ��ȡ���Գ��տ�ʼСʱ
     * @return ���Գ��տ�ʼСʱ��ֵ
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * �������Գ�������ֹ
     * @param damageEndDate �����õ����Գ�������ֹ��ֵ
     */
    public void setDamageEndDate(DateTime damageEndDate){
        this.damageEndDate = damageEndDate;
    }

    /**
     * ��ȡ���Գ�������ֹ
     * @return ���Գ�������ֹ��ֵ
     */
    public DateTime getDamageEndDate(){
        return damageEndDate;
    }

    /**
     * �������Գ�����ֹСʱ
     * @param damageEndHour �����õ����Գ�����ֹСʱ��ֵ
     */
    public void setDamageEndHour(String damageEndHour){
        this.damageEndHour = StringUtils.rightTrim(damageEndHour);
    }

    /**
     * ��ȡ���Գ�����ֹСʱ
     * @return ���Գ�����ֹСʱ��ֵ
     */
    public String getDamageEndHour(){
        return damageEndHour;
    }

    /**
     * �������Գ���ԭ�����
     * @param damageCode �����õ����Գ���ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ���Գ���ԭ�����
     * @return ���Գ���ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * �������Գ���ԭ��˵��
     * @param damageName �����õ����Գ���ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ���Գ���ԭ��˵��
     * @return ���Գ���ԭ��˵����ֵ
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
     * �������Գ����������
     * @param damageAreaCode �����õ����Գ�����������ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * �������Գ�����������
     * @param damageAreaName �����õ����Գ����������Ƶ�ֵ
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ����������Ƶ�ֵ
     */
    public String getDamageAreaName(){
        return damageAreaName;
    }

    /**
     * �������Գ��յص�������
     * @param damageAddressType �����õ����Գ��յص��������ֵ
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * ��ȡ���Գ��յص�������
     * @return ���Գ��յص��������ֵ
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * �������Ե�ַ����
     * @param addressCode �����õ����Ե�ַ�����ֵ
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * ��ȡ���Ե�ַ����
     * @return ���Ե�ַ�����ֵ
     */
    public String getAddressCode(){
        return addressCode;
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
     * ��������������
     * @param lossName �����õ����������ĵ�ֵ
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * ��ȡ����������
     * @return ���������ĵ�ֵ
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * ������������������/���շֻ���
     * @param lossQuantity �����õ���������������/���շֻ�����ֵ
     */
    public void setLossQuantity(int lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * ��ȡ��������������/���շֻ���
     * @return ��������������/���շֻ�����ֵ
     */
    public int getLossQuantity(){
        return lossQuantity;
    }

    /**
     * �������Գ����ձ�
     * @param damageKind �����õ����Գ����ձ��ֵ
     */
    public void setDamageKind(String damageKind){
        this.damageKind = StringUtils.rightTrim(damageKind);
    }

    /**
     * ��ȡ���Գ����ձ�
     * @return ���Գ����ձ��ֵ
     */
    public String getDamageKind(){
        return damageKind;
    }

    /**
     * ����������������
     * @param claimDate �����õ������������ڵ�ֵ
     */
    public void setClaimDate(DateTime claimDate){
        this.claimDate = claimDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getClaimDate(){
        return claimDate;
    }

    /**
     * ���������⳥���δ���--** ȫ��/��Ҫ/�Ե�/��Ҫ/������
     * @param indemnityDuty �����õ������⳥���δ���--** ȫ��/��Ҫ/�Ե�/��Ҫ/�����ε�ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ���--** ȫ��/��Ҫ/�Ե�/��Ҫ/������
     * @return �����⳥���δ���--** ȫ��/��Ҫ/�Ե�/��Ҫ/�����ε�ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * �����������α���
     * @param indemnityDutyRate �����õ��������α�����ֵ
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * ��ȡ�������α���
     * @return �������α�����ֵ
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * ��������������
     * @param deductibleRate �����õ����������ʵ�ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * �������Ա�����ʧ���(ͬ�����ұ�)
     * @param sumClaim �����õ����Ա�����ʧ���(ͬ�����ұ�)��ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ���Ա�����ʧ���(ͬ�����ұ�)
     * @return ���Ա�����ʧ���(ͬ�����ұ�)��ֵ
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * ���������ܺ˶�����(ͬ�����ұ�)
     * @param sumDefLoss �����õ������ܺ˶�����(ͬ�����ұ�)��ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ�����ܺ˶�����(ͬ�����ұ�)
     * @return �����ܺ˶�����(ͬ�����ұ�)��ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
    }

    /**
     * �����������⸶���(ͬ�����ұ�)--** (ʵ��+Ԥ��)
     * @param sumPaid �����õ��������⸶���(ͬ�����ұ�)--** (ʵ��+Ԥ��)��ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ�������⸶���(ͬ�����ұ�)--** (ʵ��+Ԥ��)
     * @return �������⸶���(ͬ�����ұ�)--** (ʵ��+Ԥ��)��ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * ����������׷�����(ͬ�����ұ�)
     * @param sumReplevy �����õ�������׷�����(ͬ�����ұ�)��ֵ
     */
    public void setSumReplevy(double sumReplevy){
        this.sumReplevy = sumReplevy;
    }

    /**
     * ��ȡ������׷�����(ͬ�����ұ�)
     * @return ������׷�����(ͬ�����ұ�)��ֵ
     */
    public double getSumReplevy(){
        return sumReplevy;
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
     * �������԰�������--** �⸶/ע��/����
     * @param caseType �����õ����԰�������--** �⸶/ע��/�����ֵ
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * ��ȡ���԰�������--** �⸶/ע��/����
     * @return ���԰�������--** �⸶/ע��/�����ֵ
     */
    public String getCaseType(){
        return caseType;
    }

    /**
     * ������������Ǽǻ�������
     * @param makeCom �����õ���������Ǽǻ��������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ��������Ǽǻ�������
     * @return ��������Ǽǻ��������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * ��������ҵ�������������
     * @param comCode �����õ�����ҵ��������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ�������������
     * @return ����ҵ��������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Դ����˴���
     * @param agentCode �����õ����Դ����˴����ֵ
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * ��ȡ���Դ����˴���
     * @return ���Դ����˴����ֵ
     */
    public String getAgentCode(){
        return agentCode;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Թ���ҵ��Ա����
     * @param handler1Code �����õ����Թ���ҵ��Ա�����ֵ
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * ��ȡ���Թ���ҵ��Ա����
     * @return ���Թ���ҵ��Ա�����ֵ
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * ��������ͳ������
     * @param statisticsYM �����õ�����ͳ�����µ�ֵ
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * ��ȡ����ͳ������
     * @return ����ͳ�����µ�ֵ
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
    }

    /**
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Լ�����䵥����
     * @param inputDate �����õ����Լ�����䵥���ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����
     * @return ���Լ�����䵥���ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Խ᰸����
     * @param endCaseDate �����õ����Խ᰸���ڵ�ֵ
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * ��ȡ���Խ᰸����
     * @return ���Խ᰸���ڵ�ֵ
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * �������Խ᰸Ա����
     * @param endCaserCode �����õ����Խ᰸Ա�����ֵ
     */
    public void setEndCaserCode(String endCaserCode){
        this.endCaserCode = StringUtils.rightTrim(endCaserCode);
    }

    /**
     * ��ȡ���Խ᰸Ա����
     * @return ���Խ᰸Ա�����ֵ
     */
    public String getEndCaserCode(){
        return endCaserCode;
    }

    /**
     * ��������ע��/��������
     * @param cancelDate �����õ�����ע��/�������ڵ�ֵ
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * ��ȡ����ע��/��������
     * @return ����ע��/�������ڵ�ֵ
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * ��������ע��/����ԭ��
     * @param cancelReason �����õ�����ע��/����ԭ���ֵ
     */
    public void setCancelReason(String cancelReason){
        this.cancelReason = StringUtils.rightTrim(cancelReason);
    }

    /**
     * ��ȡ����ע��/����ԭ��
     * @return ����ע��/����ԭ���ֵ
     */
    public String getCancelReason(){
        return cancelReason;
    }

    /**
     * ��������ע��/�����˴���
     * @param dealerCode �����õ�����ע��/�����˴����ֵ
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * ��ȡ����ע��/�����˴���
     * @return ����ע��/�����˴����ֵ
     */
    public String getDealerCode(){
        return dealerCode;
    }

    /**
     * ���������Ƿ�Ϊ���ݰ�
     * @param escapeFlag �����õ������Ƿ�Ϊ���ݰ���ֵ
     */
    public void setEscapeFlag(String escapeFlag){
        this.escapeFlag = StringUtils.rightTrim(escapeFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ���ݰ�
     * @return �����Ƿ�Ϊ���ݰ���ֵ
     */
    public String getEscapeFlag(){
        return escapeFlag;
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
     * ���������Ƿ������׷��
     * @param replevyFlag �����õ������Ƿ������׷����ֵ
     */
    public void setReplevyFlag(String replevyFlag){
        this.replevyFlag = StringUtils.rightTrim(replevyFlag);
    }

    /**
     * ��ȡ�����Ƿ������׷��
     * @return �����Ƿ������׷����ֵ
     */
    public String getReplevyFlag(){
        return replevyFlag;
    }

    /**
     * ���������Ƿ������������н����
     * @param thirdComFlag �����õ������Ƿ������������н������ֵ
     */
    public void setThirdComFlag(String thirdComFlag){
        this.thirdComFlag = StringUtils.rightTrim(thirdComFlag);
    }

    /**
     * ��ȡ�����Ƿ������������н����
     * @return �����Ƿ������������н������ֵ
     */
    public String getThirdComFlag(){
        return thirdComFlag;
    }

    /**
     * ���������Ƿ��Զ��᰸
     * @param endCaseFlag �����õ������Ƿ��Զ��᰸��ֵ
     */
    public void setEndCaseFlag(String endCaseFlag){
        this.endCaseFlag = StringUtils.rightTrim(endCaseFlag);
    }

    /**
     * ��ȡ�����Ƿ��Զ��᰸
     * @return �����Ƿ��Զ��᰸��ֵ
     */
    public String getEndCaseFlag(){
        return endCaseFlag;
    }

    /**
     * �������Լ��������α���
     * @param cIndemnityDutyRate �����õ����Լ��������α�����ֵ
     */
    public void setCIndemnityDutyRate(double cIndemnityDutyRate){
        this.cIndemnityDutyRate = cIndemnityDutyRate;
    }

    /**
     * ��ȡ���Լ��������α���
     * @return ���Լ��������α�����ֵ
     */
    public double getCIndemnityDutyRate(){
        return cIndemnityDutyRate;
    }

    /**
     * �������Գ��յص���������
     * @param damageAreaPostCode �����õ����Գ��յص����������ֵ
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * ��ȡ���Գ��յص���������
     * @return ���Գ��յص����������ֵ
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
    }

    /**
     * �������Ծ���һ������
     * @param catastropheCode1 �����õ����Ծ���һ�������ֵ
     */
    public void setCatastropheCode1(String catastropheCode1){
        this.catastropheCode1 = StringUtils.rightTrim(catastropheCode1);
    }

    /**
     * ��ȡ���Ծ���һ������
     * @return ���Ծ���һ�������ֵ
     */
    public String getCatastropheCode1(){
        return catastropheCode1;
    }

    /**
     * �������Ծ���һ������
     * @param catastropheName1 �����õ����Ծ���һ�����Ƶ�ֵ
     */
    public void setCatastropheName1(String catastropheName1){
        this.catastropheName1 = StringUtils.rightTrim(catastropheName1);
    }

    /**
     * ��ȡ���Ծ���һ������
     * @return ���Ծ���һ�����Ƶ�ֵ
     */
    public String getCatastropheName1(){
        return catastropheName1;
    }

    /**
     * �������Ծ��ֶ�������
     * @param catastropheCode2 �����õ����Ծ��ֶ��������ֵ
     */
    public void setCatastropheCode2(String catastropheCode2){
        this.catastropheCode2 = StringUtils.rightTrim(catastropheCode2);
    }

    /**
     * ��ȡ���Ծ��ֶ�������
     * @return ���Ծ��ֶ��������ֵ
     */
    public String getCatastropheCode2(){
        return catastropheCode2;
    }

    /**
     * �������԰�������
     * @param claimType �����õ����԰������͵�ֵ
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * ��ȡ���԰�������
     * @return ���԰������͵�ֵ
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * �������Ծ��ֶ�������
     * @param catastropheName2 �����õ����Ծ��ֶ������Ƶ�ֵ
     */
    public void setCatastropheName2(String catastropheName2){
        this.catastropheName2 = StringUtils.rightTrim(catastropheName2);
    }

    /**
     * ��ȡ���Ծ��ֶ�������
     * @return ���Ծ��ֶ������Ƶ�ֵ
     */
    public String getCatastropheName2(){
        return catastropheName2;
    }
    
    /**
     * ����������������
     * @param claimDate �����õ������������ڵ�ֵ
     */
    public void setClaimTime(DateTime claimTime){
        this.claimTime = claimTime;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getClaimTime(){
        return claimTime;
    }
}
