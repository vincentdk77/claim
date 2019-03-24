package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLassure-�������������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.656<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLassureDtoBase implements Serializable{
    /** ���Ե����� */
    private String assureNo = "";
    /** ���Թ��������� */
    private String relativeAssureNo = "";
    /** ���Ե��������� */
    private String assureTypeCode = "";
    /** ���Ե������� */
    private String assureNatureCode = "";
    /** ���Ե���ԭ�� */
    private String assureReason = "";
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Դ����գ����� */
    private String shipName = "";
    /** ���Դ����գ�������Ӣ�ģ� */
    private String shipEName = "";
    /** ���Դ��� */
    private String shipOwner = "";
    /** ���Ժ��� */
    private String voyage = "";
    /** ������ʼ�� */
    private String startSiteName = "";
    /** ������ת�� */
    private String viaSiteName = "";
    /** ����Ŀ�ĵ� */
    private String endSiteName = "";
    /** ���Կ�Ѻ����Ժ */
    private String countName = "";
    /** ���Է��˴��� */
    private String artificialPerson = "";
    /** ���Ա�Э���� */
    private String piservice = "";
    /** ���Ա���Ȩ�� */
    private String bytortiousUnit = "";
    /** ���Ա���Ȩ��� */
    private String bytortiousObject = "";
    /** ���Ե������� */
    private String currency = "";
    /** ���Ե������/��������� */
    private double reverseAmount = 0d;
    /** ���������ѽ�� */
    private double commissionCharge = 0d;
    /** ������ʧ��� */
    private double sumLoss = 0d;
    /** �������Ϸ��� */
    private double legalCost = 0d;
    /** ������Ϣ */
    private double accrual = 0d;
    /** ������������ */
    private double otherFee = 0d;
    /** �����Ƿ񲻿ɳ������� */
    private String quashAssure = "";
    /** ���Ե����� */
    private String assurer = "";
    /** �����յ����� */
    private DateTime receiveDate = new DateTime();
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���԰����Ҫ���� */
    private String claimDescribe = "";
    /** �����˻����� */
    private DateTime returnDate = new DateTime();
    /** �����˻������˴��� */
    private String returnHandlerCode = "";
    /** ���Է������� */
    private String reverseCautioner = "";
    /** ���Գа��� */
    private String purveyor = "";
    /** ���Դ����ƣ������ */
    private String chiefText = "";
    /** �������뵣������� */
    private String applicationText = "";
    /** �����ϼ���� */
    private String superText = "";
    /** ���Ե������� */
    private DateTime assureDate = new DateTime();
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLassureDtoBase����
     */
    public PrpLassureDtoBase(){
    }

    /**
     * �������Ե�����
     * @param assureNo �����õ����Ե����ŵ�ֵ
     */
    public void setAssureNo(String assureNo){
        this.assureNo = StringUtils.rightTrim(assureNo);
    }

    /**
     * ��ȡ���Ե�����
     * @return ���Ե����ŵ�ֵ
     */
    public String getAssureNo(){
        return assureNo;
    }

    /**
     * �������Թ���������
     * @param relativeAssureNo �����õ����Թ��������ŵ�ֵ
     */
    public void setRelativeAssureNo(String relativeAssureNo){
        this.relativeAssureNo = StringUtils.rightTrim(relativeAssureNo);
    }

    /**
     * ��ȡ���Թ���������
     * @return ���Թ��������ŵ�ֵ
     */
    public String getRelativeAssureNo(){
        return relativeAssureNo;
    }

    /**
     * �������Ե���������
     * @param assureTypeCode �����õ����Ե��������͵�ֵ
     */
    public void setAssureTypeCode(String assureTypeCode){
        this.assureTypeCode = StringUtils.rightTrim(assureTypeCode);
    }

    /**
     * ��ȡ���Ե���������
     * @return ���Ե��������͵�ֵ
     */
    public String getAssureTypeCode(){
        return assureTypeCode;
    }

    /**
     * �������Ե�������
     * @param assureNatureCode �����õ����Ե������ʵ�ֵ
     */
    public void setAssureNatureCode(String assureNatureCode){
        this.assureNatureCode = StringUtils.rightTrim(assureNatureCode);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������ʵ�ֵ
     */
    public String getAssureNatureCode(){
        return assureNatureCode;
    }

    /**
     * �������Ե���ԭ��
     * @param assureReason �����õ����Ե���ԭ���ֵ
     */
    public void setAssureReason(String assureReason){
        this.assureReason = StringUtils.rightTrim(assureReason);
    }

    /**
     * ��ȡ���Ե���ԭ��
     * @return ���Ե���ԭ���ֵ
     */
    public String getAssureReason(){
        return assureReason;
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
     * �������Դ����գ�����
     * @param shipName �����õ����Դ����գ�������ֵ
     */
    public void setShipName(String shipName){
        this.shipName = StringUtils.rightTrim(shipName);
    }

    /**
     * ��ȡ���Դ����գ�����
     * @return ���Դ����գ�������ֵ
     */
    public String getShipName(){
        return shipName;
    }

    /**
     * �������Դ����գ�������Ӣ�ģ�
     * @param shipEName �����õ����Դ����գ�������Ӣ�ģ���ֵ
     */
    public void setShipEName(String shipEName){
        this.shipEName = StringUtils.rightTrim(shipEName);
    }

    /**
     * ��ȡ���Դ����գ�������Ӣ�ģ�
     * @return ���Դ����գ�������Ӣ�ģ���ֵ
     */
    public String getShipEName(){
        return shipEName;
    }

    /**
     * �������Դ���
     * @param shipOwner �����õ����Դ�����ֵ
     */
    public void setShipOwner(String shipOwner){
        this.shipOwner = StringUtils.rightTrim(shipOwner);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public String getShipOwner(){
        return shipOwner;
    }

    /**
     * �������Ժ���
     * @param voyage �����õ����Ժ��ε�ֵ
     */
    public void setVoyage(String voyage){
        this.voyage = StringUtils.rightTrim(voyage);
    }

    /**
     * ��ȡ���Ժ���
     * @return ���Ժ��ε�ֵ
     */
    public String getVoyage(){
        return voyage;
    }

    /**
     * ����������ʼ��
     * @param startSiteName �����õ�������ʼ�ص�ֵ
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * ��ȡ������ʼ��
     * @return ������ʼ�ص�ֵ
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * ����������ת��
     * @param viaSiteName �����õ�������ת�ص�ֵ
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * ��ȡ������ת��
     * @return ������ת�ص�ֵ
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * ��������Ŀ�ĵ�
     * @param endSiteName �����õ�����Ŀ�ĵص�ֵ
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * ��ȡ����Ŀ�ĵ�
     * @return ����Ŀ�ĵص�ֵ
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * �������Կ�Ѻ����Ժ
     * @param countName �����õ����Կ�Ѻ����Ժ��ֵ
     */
    public void setCountName(String countName){
        this.countName = StringUtils.rightTrim(countName);
    }

    /**
     * ��ȡ���Կ�Ѻ����Ժ
     * @return ���Կ�Ѻ����Ժ��ֵ
     */
    public String getCountName(){
        return countName;
    }

    /**
     * �������Է��˴���
     * @param artificialPerson �����õ����Է��˴����ֵ
     */
    public void setArtificialPerson(String artificialPerson){
        this.artificialPerson = StringUtils.rightTrim(artificialPerson);
    }

    /**
     * ��ȡ���Է��˴���
     * @return ���Է��˴����ֵ
     */
    public String getArtificialPerson(){
        return artificialPerson;
    }

    /**
     * �������Ա�Э����
     * @param piservice �����õ����Ա�Э���Ƶ�ֵ
     */
    public void setPiservice(String piservice){
        this.piservice = StringUtils.rightTrim(piservice);
    }

    /**
     * ��ȡ���Ա�Э����
     * @return ���Ա�Э���Ƶ�ֵ
     */
    public String getPiservice(){
        return piservice;
    }

    /**
     * �������Ա���Ȩ��
     * @param bytortiousUnit �����õ����Ա���Ȩ�˵�ֵ
     */
    public void setBytortiousUnit(String bytortiousUnit){
        this.bytortiousUnit = StringUtils.rightTrim(bytortiousUnit);
    }

    /**
     * ��ȡ���Ա���Ȩ��
     * @return ���Ա���Ȩ�˵�ֵ
     */
    public String getBytortiousUnit(){
        return bytortiousUnit;
    }

    /**
     * �������Ա���Ȩ���
     * @param bytortiousObject �����õ����Ա���Ȩ��ĵ�ֵ
     */
    public void setBytortiousObject(String bytortiousObject){
        this.bytortiousObject = StringUtils.rightTrim(bytortiousObject);
    }

    /**
     * ��ȡ���Ա���Ȩ���
     * @return ���Ա���Ȩ��ĵ�ֵ
     */
    public String getBytortiousObject(){
        return bytortiousObject;
    }

    /**
     * �������Ե�������
     * @param currency �����õ����Ե������ֵ�ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������ֵ�ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ե������/���������
     * @param reverseAmount �����õ����Ե������/����������ֵ
     */
    public void setReverseAmount(double reverseAmount){
        this.reverseAmount = reverseAmount;
    }

    /**
     * ��ȡ���Ե������/���������
     * @return ���Ե������/����������ֵ
     */
    public double getReverseAmount(){
        return reverseAmount;
    }

    /**
     * �������������ѽ��
     * @param commissionCharge �����õ����������ѽ���ֵ
     */
    public void setCommissionCharge(double commissionCharge){
        this.commissionCharge = commissionCharge;
    }

    /**
     * ��ȡ���������ѽ��
     * @return ���������ѽ���ֵ
     */
    public double getCommissionCharge(){
        return commissionCharge;
    }

    /**
     * ����������ʧ���
     * @param sumLoss �����õ�������ʧ����ֵ
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * ��ȡ������ʧ���
     * @return ������ʧ����ֵ
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * �����������Ϸ���
     * @param legalCost �����õ��������Ϸ��õ�ֵ
     */
    public void setLegalCost(double legalCost){
        this.legalCost = legalCost;
    }

    /**
     * ��ȡ�������Ϸ���
     * @return �������Ϸ��õ�ֵ
     */
    public double getLegalCost(){
        return legalCost;
    }

    /**
     * ����������Ϣ
     * @param accrual �����õ�������Ϣ��ֵ
     */
    public void setAccrual(double accrual){
        this.accrual = accrual;
    }

    /**
     * ��ȡ������Ϣ
     * @return ������Ϣ��ֵ
     */
    public double getAccrual(){
        return accrual;
    }

    /**
     * ����������������
     * @param otherFee �����õ������������õ�ֵ
     */
    public void setOtherFee(double otherFee){
        this.otherFee = otherFee;
    }

    /**
     * ��ȡ������������
     * @return �����������õ�ֵ
     */
    public double getOtherFee(){
        return otherFee;
    }

    /**
     * ���������Ƿ񲻿ɳ�������
     * @param quashAssure �����õ������Ƿ񲻿ɳ���������ֵ
     */
    public void setQuashAssure(String quashAssure){
        this.quashAssure = StringUtils.rightTrim(quashAssure);
    }

    /**
     * ��ȡ�����Ƿ񲻿ɳ�������
     * @return �����Ƿ񲻿ɳ���������ֵ
     */
    public String getQuashAssure(){
        return quashAssure;
    }

    /**
     * �������Ե�����
     * @param assurer �����õ����Ե����˵�ֵ
     */
    public void setAssurer(String assurer){
        this.assurer = StringUtils.rightTrim(assurer);
    }

    /**
     * ��ȡ���Ե�����
     * @return ���Ե����˵�ֵ
     */
    public String getAssurer(){
        return assurer;
    }

    /**
     * ���������յ�����
     * @param receiveDate �����õ������յ����ڵ�ֵ
     */
    public void setReceiveDate(DateTime receiveDate){
        this.receiveDate = receiveDate;
    }

    /**
     * ��ȡ�����յ�����
     * @return �����յ����ڵ�ֵ
     */
    public DateTime getReceiveDate(){
        return receiveDate;
    }

    /**
     * �������Ը����˴���
     * @param approverCode �����õ����Ը����˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ���Ը����˴���
     * @return ���Ը����˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
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
     * �������԰����Ҫ����
     * @param claimDescribe �����õ����԰����Ҫ������ֵ
     */
    public void setClaimDescribe(String claimDescribe){
        this.claimDescribe = StringUtils.rightTrim(claimDescribe);
    }

    /**
     * ��ȡ���԰����Ҫ����
     * @return ���԰����Ҫ������ֵ
     */
    public String getClaimDescribe(){
        return claimDescribe;
    }

    /**
     * ���������˻�����
     * @param returnDate �����õ������˻����ڵ�ֵ
     */
    public void setReturnDate(DateTime returnDate){
        this.returnDate = returnDate;
    }

    /**
     * ��ȡ�����˻�����
     * @return �����˻����ڵ�ֵ
     */
    public DateTime getReturnDate(){
        return returnDate;
    }

    /**
     * ���������˻������˴���
     * @param returnHandlerCode �����õ������˻������˴����ֵ
     */
    public void setReturnHandlerCode(String returnHandlerCode){
        this.returnHandlerCode = StringUtils.rightTrim(returnHandlerCode);
    }

    /**
     * ��ȡ�����˻������˴���
     * @return �����˻������˴����ֵ
     */
    public String getReturnHandlerCode(){
        return returnHandlerCode;
    }

    /**
     * �������Է�������
     * @param reverseCautioner �����õ����Է������˵�ֵ
     */
    public void setReverseCautioner(String reverseCautioner){
        this.reverseCautioner = StringUtils.rightTrim(reverseCautioner);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������˵�ֵ
     */
    public String getReverseCautioner(){
        return reverseCautioner;
    }

    /**
     * �������Գа���
     * @param purveyor �����õ����Գа��˵�ֵ
     */
    public void setPurveyor(String purveyor){
        this.purveyor = StringUtils.rightTrim(purveyor);
    }

    /**
     * ��ȡ���Գа���
     * @return ���Գа��˵�ֵ
     */
    public String getPurveyor(){
        return purveyor;
    }

    /**
     * �������Դ����ƣ������
     * @param chiefText �����õ����Դ����ƣ��������ֵ
     */
    public void setChiefText(String chiefText){
        this.chiefText = StringUtils.rightTrim(chiefText);
    }

    /**
     * ��ȡ���Դ����ƣ������
     * @return ���Դ����ƣ��������ֵ
     */
    public String getChiefText(){
        return chiefText;
    }

    /**
     * �����������뵣�������
     * @param applicationText �����õ��������뵣���������ֵ
     */
    public void setApplicationText(String applicationText){
        this.applicationText = StringUtils.rightTrim(applicationText);
    }

    /**
     * ��ȡ�������뵣�������
     * @return �������뵣���������ֵ
     */
    public String getApplicationText(){
        return applicationText;
    }

    /**
     * ���������ϼ����
     * @param superText �����õ������ϼ������ֵ
     */
    public void setSuperText(String superText){
        this.superText = StringUtils.rightTrim(superText);
    }

    /**
     * ��ȡ�����ϼ����
     * @return �����ϼ������ֵ
     */
    public String getSuperText(){
        return superText;
    }

    /**
     * �������Ե�������
     * @param assureDate �����õ����Ե������ڵ�ֵ
     */
    public void setAssureDate(DateTime assureDate){
        this.assureDate = assureDate;
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������ڵ�ֵ
     */
    public DateTime getAssureDate(){
        return assureDate;
    }

    /**
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
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
