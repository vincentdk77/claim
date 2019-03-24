package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLsalvation-��Լ����������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLsalvationDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ������Լ������ */
    private String salvationNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ժ��ƺ��� */
    private String licenseNo = "";
    /** �������յ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ�����ɫ���� */
    private String colorCode = "";
    /** ���Գ��ʹ��� */
    private String modelCode = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Լ�ʻԱ���� */
    private String driverName = "";
    /** ���Ե绰 */
    private String phone = "";
    /** ���Ծ�������
--** 0:����������� 1���������� */
    private String salvaType = "";
    /** ���Է����¹�ʱ�� */
    private DateTime damageTime = new DateTime();
    /** ���Ը��ѷ�ʽ  0����Ѿ��� 
--** 1���ֳ��շѾ��� */
    private String moneyFlag = "";
    /** ���Ծ�����Ŀ�����
--** 0: �ϳ� 1: ���׹���2: �͵�
--** 3: ���� 4:������̥
--** 5: ���� 6: ���� */
    private String salvaItemCode = "";
    /** ���Ծ�����Ŀ���� */
    private String salvaItemName = "";
    /** ���Ծ����ص� */
    private String salvaSite = "";
    /** ���Գ��������ص� */
    private String sendSite = "";
    /** ���Ծ���Э����λ���� */
    private String salvaAssistUnit = "";
    /** ���Ծ���Э����λ���������� */
    private String salvaUnitHandler = "";
    /** ��������·�� */
    private String salvaRoute = "";
    /** ���Ծ������� */
    private double salvaMile = 0d;
    /** ���Գб���˾���� */
    private String insureUnitCode = "";
    /** ���Գб���˾���� */
    private String insureUnitName = "";
    /** �����շѱ�׼ */
    private String feeStandard = "";
    /** ���Ծ������� */
    private double salvaFee = 0d;
    /** ���Ծ���������ʱ�� */
    private DateTime arriveDate = new DateTime();
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ����ȷ������ */
    private DateTime verifyDate = new DateTime();
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLsalvationDtoBase����
     */
    public PrpLsalvationDtoBase(){
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
     * ����������Լ������
     * @param salvationNo �����õ�������Լ�����ŵ�ֵ
     */
    public void setSalvationNo(String salvationNo){
        this.salvationNo = StringUtils.rightTrim(salvationNo);
    }

    /**
     * ��ȡ������Լ������
     * @return ������Լ�����ŵ�ֵ
     */
    public String getSalvationNo(){
        return salvationNo;
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
     * �������Ժ��ƺ���
     * @param licenseNo �����õ����Ժ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Ժ��ƺ���
     * @return ���Ժ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �����������յ�ɫ����
     * @param licenseColorCode �����õ��������յ�ɫ�����ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * ��ȡ�������յ�ɫ����
     * @return �������յ�ɫ�����ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * �������Է�������
     * @param engineNo �����õ����Է������ŵ�ֵ
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������ŵ�ֵ
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * �������Գ�����ɫ����
     * @param colorCode �����õ����Գ�����ɫ�����ֵ
     */
    public void setColorCode(String colorCode){
        this.colorCode = StringUtils.rightTrim(colorCode);
    }

    /**
     * ��ȡ���Գ�����ɫ����
     * @return ���Գ�����ɫ�����ֵ
     */
    public String getColorCode(){
        return colorCode;
    }

    /**
     * �������Գ��ʹ���
     * @param modelCode �����õ����Գ��ʹ����ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ���Գ��ʹ���
     * @return ���Գ��ʹ����ֵ
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * �������Գ����ͺ�
     * @param brandName �����õ����Գ����ͺŵ�ֵ
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * ��ȡ���Գ����ͺ�
     * @return ���Գ����ͺŵ�ֵ
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * �������Լ�ʻԱ����
     * @param driverName �����õ����Լ�ʻԱ������ֵ
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * ��ȡ���Լ�ʻԱ����
     * @return ���Լ�ʻԱ������ֵ
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * �������Ե绰
     * @param phone �����õ����Ե绰��ֵ
     */
    public void setPhone(String phone){
        this.phone = StringUtils.rightTrim(phone);
    }

    /**
     * ��ȡ���Ե绰
     * @return ���Ե绰��ֵ
     */
    public String getPhone(){
        return phone;
    }

    /**
     * �������Ծ�������
--** 0:����������� 1����������
     * @param salvaType �����õ����Ծ�������
--** 0:����������� 1������������ֵ
     */
    public void setSalvaType(String salvaType){
        this.salvaType = StringUtils.rightTrim(salvaType);
    }

    /**
     * ��ȡ���Ծ�������
--** 0:����������� 1����������
     * @return ���Ծ�������
--** 0:����������� 1������������ֵ
     */
    public String getSalvaType(){
        return salvaType;
    }

    /**
     * �������Է����¹�ʱ��
     * @param damageTime �����õ����Է����¹�ʱ���ֵ
     */
    public void setDamageTime(DateTime damageTime){
        this.damageTime = damageTime;
    }

    /**
     * ��ȡ���Է����¹�ʱ��
     * @return ���Է����¹�ʱ���ֵ
     */
    public DateTime getDamageTime(){
        return damageTime;
    }

    /**
     * �������Ը��ѷ�ʽ  0����Ѿ��� 
--** 1���ֳ��շѾ���
     * @param moneyFlag �����õ����Ը��ѷ�ʽ  0����Ѿ��� 
--** 1���ֳ��շѾ�����ֵ
     */
    public void setMoneyFlag(String moneyFlag){
        this.moneyFlag = StringUtils.rightTrim(moneyFlag);
    }

    /**
     * ��ȡ���Ը��ѷ�ʽ  0����Ѿ��� 
--** 1���ֳ��շѾ���
     * @return ���Ը��ѷ�ʽ  0����Ѿ��� 
--** 1���ֳ��շѾ�����ֵ
     */
    public String getMoneyFlag(){
        return moneyFlag;
    }

    /**
     * �������Ծ�����Ŀ�����
--** 0: �ϳ� 1: ���׹���2: �͵�
--** 3: ���� 4:������̥
--** 5: ���� 6: ����
     * @param salvaItemCode �����õ����Ծ�����Ŀ�����
--** 0: �ϳ� 1: ���׹���2: �͵�
--** 3: ���� 4:������̥
--** 5: ���� 6: ������ֵ
     */
    public void setSalvaItemCode(String salvaItemCode){
        this.salvaItemCode = StringUtils.rightTrim(salvaItemCode);
    }

    /**
     * ��ȡ���Ծ�����Ŀ�����
--** 0: �ϳ� 1: ���׹���2: �͵�
--** 3: ���� 4:������̥
--** 5: ���� 6: ����
     * @return ���Ծ�����Ŀ�����
--** 0: �ϳ� 1: ���׹���2: �͵�
--** 3: ���� 4:������̥
--** 5: ���� 6: ������ֵ
     */
    public String getSalvaItemCode(){
        return salvaItemCode;
    }

    /**
     * �������Ծ�����Ŀ����
     * @param salvaItemName �����õ����Ծ�����Ŀ���Ƶ�ֵ
     */
    public void setSalvaItemName(String salvaItemName){
        this.salvaItemName = StringUtils.rightTrim(salvaItemName);
    }

    /**
     * ��ȡ���Ծ�����Ŀ����
     * @return ���Ծ�����Ŀ���Ƶ�ֵ
     */
    public String getSalvaItemName(){
        return salvaItemName;
    }

    /**
     * �������Ծ����ص�
     * @param salvaSite �����õ����Ծ����ص��ֵ
     */
    public void setSalvaSite(String salvaSite){
        this.salvaSite = StringUtils.rightTrim(salvaSite);
    }

    /**
     * ��ȡ���Ծ����ص�
     * @return ���Ծ����ص��ֵ
     */
    public String getSalvaSite(){
        return salvaSite;
    }

    /**
     * �������Գ��������ص�
     * @param sendSite �����õ����Գ��������ص��ֵ
     */
    public void setSendSite(String sendSite){
        this.sendSite = StringUtils.rightTrim(sendSite);
    }

    /**
     * ��ȡ���Գ��������ص�
     * @return ���Գ��������ص��ֵ
     */
    public String getSendSite(){
        return sendSite;
    }

    /**
     * �������Ծ���Э����λ����
     * @param salvaAssistUnit �����õ����Ծ���Э����λ���Ƶ�ֵ
     */
    public void setSalvaAssistUnit(String salvaAssistUnit){
        this.salvaAssistUnit = StringUtils.rightTrim(salvaAssistUnit);
    }

    /**
     * ��ȡ���Ծ���Э����λ����
     * @return ���Ծ���Э����λ���Ƶ�ֵ
     */
    public String getSalvaAssistUnit(){
        return salvaAssistUnit;
    }

    /**
     * �������Ծ���Э����λ����������
     * @param salvaUnitHandler �����õ����Ծ���Э����λ���������Ƶ�ֵ
     */
    public void setSalvaUnitHandler(String salvaUnitHandler){
        this.salvaUnitHandler = StringUtils.rightTrim(salvaUnitHandler);
    }

    /**
     * ��ȡ���Ծ���Э����λ����������
     * @return ���Ծ���Э����λ���������Ƶ�ֵ
     */
    public String getSalvaUnitHandler(){
        return salvaUnitHandler;
    }

    /**
     * ������������·��
     * @param salvaRoute �����õ���������·�ߵ�ֵ
     */
    public void setSalvaRoute(String salvaRoute){
        this.salvaRoute = StringUtils.rightTrim(salvaRoute);
    }

    /**
     * ��ȡ��������·��
     * @return ��������·�ߵ�ֵ
     */
    public String getSalvaRoute(){
        return salvaRoute;
    }

    /**
     * �������Ծ�������
     * @param salvaMile �����õ����Ծ��������ֵ
     */
    public void setSalvaMile(double salvaMile){
        this.salvaMile = salvaMile;
    }

    /**
     * ��ȡ���Ծ�������
     * @return ���Ծ��������ֵ
     */
    public double getSalvaMile(){
        return salvaMile;
    }

    /**
     * �������Գб���˾����
     * @param insureUnitCode �����õ����Գб���˾�����ֵ
     */
    public void setInsureUnitCode(String insureUnitCode){
        this.insureUnitCode = StringUtils.rightTrim(insureUnitCode);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾�����ֵ
     */
    public String getInsureUnitCode(){
        return insureUnitCode;
    }

    /**
     * �������Գб���˾����
     * @param insureUnitName �����õ����Գб���˾���Ƶ�ֵ
     */
    public void setInsureUnitName(String insureUnitName){
        this.insureUnitName = StringUtils.rightTrim(insureUnitName);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾���Ƶ�ֵ
     */
    public String getInsureUnitName(){
        return insureUnitName;
    }

    /**
     * ���������շѱ�׼
     * @param feeStandard �����õ������շѱ�׼��ֵ
     */
    public void setFeeStandard(String feeStandard){
        this.feeStandard = StringUtils.rightTrim(feeStandard);
    }

    /**
     * ��ȡ�����շѱ�׼
     * @return �����շѱ�׼��ֵ
     */
    public String getFeeStandard(){
        return feeStandard;
    }

    /**
     * �������Ծ�������
     * @param salvaFee �����õ����Ծ������õ�ֵ
     */
    public void setSalvaFee(double salvaFee){
        this.salvaFee = salvaFee;
    }

    /**
     * ��ȡ���Ծ�������
     * @return ���Ծ������õ�ֵ
     */
    public double getSalvaFee(){
        return salvaFee;
    }

    /**
     * �������Ծ���������ʱ��
     * @param arriveDate �����õ����Ծ���������ʱ���ֵ
     */
    public void setArriveDate(DateTime arriveDate){
        this.arriveDate = arriveDate;
    }

    /**
     * ��ȡ���Ծ���������ʱ��
     * @return ���Ծ���������ʱ���ֵ
     */
    public DateTime getArriveDate(){
        return arriveDate;
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
     * ��������ȷ������
     * @param verifyDate �����õ�����ȷ�����ڵ�ֵ
     */
    public void setVerifyDate(DateTime verifyDate){
        this.verifyDate = verifyDate;
    }

    /**
     * ��ȡ����ȷ������
     * @return ����ȷ�����ڵ�ֵ
     */
    public DateTime getVerifyDate(){
        return verifyDate;
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
