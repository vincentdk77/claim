package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLverifyLossItem���������ı�����ݴ���������<br>
 * ������ 2004-11-11 14:31:00.749<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossItemDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Զ������� */
    private String lossType = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա������� */
    private String insuredName = "";
    /** ���Ժ��ƺ��� */
    private String licenseNo = "";
    /** ���Ժ��Ƶ�ɫ���� */
    private String licenseColorcode = "";
    /** ���Ժ���������� */
    private String carKindCode = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���Զ����ܽ�� */
    private double sumPreDefLoss = 0d;
    /** ���Ժ����ܽ�� */
    private double sumDefLoss = 0d;
    /** ���Գ������� */
    private String makeCom = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Զ����˴��� */
    private String handlerCode = "";
    /** ���Զ����� */
    private String handlerName = "";
    /** ���Զ���������� */
    private DateTime defLossDate = new DateTime();
    /** ���Ժ����˴��� */
    private String underWriteCode = "";
    /** ���Ժ��������� */
    private String underWriteName = "";
    /** �������պ���������� */
    private DateTime underWriteEndDate = new DateTime();
    /** ���Ժ����־ */
    private String underWriteFlag = "";
    /** ���Խڵ����� */
    private String nodeType = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�ע(����) */
    private String verifyRemark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLverifyLossItemDtoBase����
     */
    public PrpLverifyLossItemDtoBase(){
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
     * �������Զ�������
     * @param lossType �����õ����Զ������͵�ֵ
     */
    public void setLossType(String lossType){
        this.lossType = StringUtils.rightTrim(lossType);
    }

    /**
     * ��ȡ���Զ�������
     * @return ���Զ������͵�ֵ
     */
    public String getLossType(){
        return lossType;
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
     * �������Ա�������
     * @param insuredName �����õ����Ա������˵�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������˵�ֵ
     */
    public String getInsuredName(){
        return insuredName;
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
     * �������Ժ��Ƶ�ɫ����
     * @param licenseColorcode �����õ����Ժ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorcode(String licenseColorcode){
        this.licenseColorcode = StringUtils.rightTrim(licenseColorcode);
    }

    /**
     * ��ȡ���Ժ��Ƶ�ɫ����
     * @return ���Ժ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorcode(){
        return licenseColorcode;
    }

    /**
     * �������Ժ����������
     * @param carKindCode �����õ����Ժ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Ժ����������
     * @return ���Ժ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
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
     * �������Զ����ܽ��
     * @param sumPreDefLoss �����õ����Զ����ܽ���ֵ
     */
    public void setSumPreDefLoss(double sumPreDefLoss){
        this.sumPreDefLoss = sumPreDefLoss;
    }

    /**
     * ��ȡ���Զ����ܽ��
     * @return ���Զ����ܽ���ֵ
     */
    public double getSumPreDefLoss(){
        return sumPreDefLoss;
    }

    /**
     * �������Ժ����ܽ��
     * @param sumDefLoss �����õ����Ժ����ܽ���ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ����ܽ��
     * @return ���Ժ����ܽ���ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
    }

    /**
     * �������Գ�������
     * @param makeCom �����õ����Գ���������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ���������ֵ
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
     * �������Զ����˴���
     * @param handlerCode �����õ����Զ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Զ����˴���
     * @return ���Զ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Զ�����
     * @param handlerName �����õ����Զ����˵�ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Զ�����
     * @return ���Զ����˵�ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Զ����������
     * @param defLossDate �����õ����Զ���������ڵ�ֵ
     */
    public void setDefLossDate(DateTime defLossDate){
        this.defLossDate = defLossDate;
    }

    /**
     * ��ȡ���Զ����������
     * @return ���Զ���������ڵ�ֵ
     */
    public DateTime getDefLossDate(){
        return defLossDate;
    }

    /**
     * �������Ժ����˴���
     * @param underWriteCode �����õ����Ժ����˴����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ���Ժ����˴���
     * @return ���Ժ����˴����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �������Ժ���������
     * @param underWriteName �����õ����Ժ��������Ƶ�ֵ
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * ��ȡ���Ժ���������
     * @return ���Ժ��������Ƶ�ֵ
     */
    public String getUnderWriteName(){
        return underWriteName;
    }

    /**
     * �����������պ����������
     * @param underWriteEndDate �����õ��������պ���������ڵ�ֵ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * ��ȡ�������պ����������
     * @return �������պ���������ڵ�ֵ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * �������Ժ����־
     * @param underWriteFlag �����õ����Ժ����־��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ���Ժ����־
     * @return ���Ժ����־��ֵ
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ����͵�ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����͵�ֵ
     */
    public String getNodeType(){
        return nodeType;
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
     * �������Ա�ע(����)
     * @param verifyRemark �����õ����Ա�ע(����)��ֵ
     */
    public void setVerifyRemark(String verifyRemark){
        this.verifyRemark = StringUtils.rightTrim(verifyRemark);
    }

    /**
     * ��ȡ���Ա�ע(����)
     * @return ���Ա�ע(����)��ֵ
     */
    public String getVerifyRemark(){
        return verifyRemark;
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
