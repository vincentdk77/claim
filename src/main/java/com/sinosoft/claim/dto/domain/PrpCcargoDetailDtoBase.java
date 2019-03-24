package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpccargodetail�����ջ�����ϸ��Ϣ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcargoDetailDtoBase implements Serializable{
    /** ���Ա�����/Э��� */
    private String policyNo = "";
    /** �������� */
    private String riskCode = "";
    /** �������� */
    private int batchNo = 0;
    /** ����˳��� */
    private int serialNo = 0;
    /** ���Ա������ */
    private String policyType = "";
    /** �������乤�� */
    private String conveyance = "";
    /** �����˾��ƺ� */
    private String bLNo = "";
    /** ���Ժ��� */
    private String voyageNo = "";
    /** ���Ի�Ʊ�˵��� */
    private String carryBillNo = "";
    /** ���Ի������� */
    private String detailName = "";
    /** ������������ */
    private DateTime startDate = new DateTime();
    /** �������˵� */
    private String startSiteName = "";
    /** ������ת�� */
    private String viaSiteName = "";
    /** ����Ŀ�ĵ� */
    private String endSiteName = "";
    /** ���԰�װ������ */
    private String quantity = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ի����ֵ */
    private double sumValue = 0d;
    /** ���Ա��� */
    private double sumAmount = 0d;
    /** ���Է��� */
    private double rate = 0d;
    /** ���Ա��� */
    private double sumPremium = 0d;
    /** ���Խ����־ */
    private String settleFlag = "";
    /** ���Ա�ע�ֶ� */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcargoDetailDtoBase����
     */
    public PrpCcargoDetailDtoBase(){
    }

    /**
     * �������Ա�����/Э���
     * @param policyNo �����õ����Ա�����/Э��ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����/Э���
     * @return ���Ա�����/Э��ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ������������
     * @param batchNo �����õ��������ε�ֵ
     */
    public void setBatchNo(int batchNo){
        this.batchNo = batchNo;
    }

    /**
     * ��ȡ��������
     * @return �������ε�ֵ
     */
    public int getBatchNo(){
        return batchNo;
    }

    /**
     * ��������˳���
     * @param serialNo �����õ�����˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����˳���
     * @return ����˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա������
     * @param policyType �����õ����Ա�������ֵ
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * ��ȡ���Ա������
     * @return ���Ա�������ֵ
     */
    public String getPolicyType(){
        return policyType;
    }

    /**
     * �����������乤��
     * @param conveyance �����õ��������乤�ߵ�ֵ
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * ��ȡ�������乤��
     * @return �������乤�ߵ�ֵ
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * ���������˾��ƺ�
     * @param bLNo �����õ������˾��ƺŵ�ֵ
     */
    public void setBLNo(String bLNo){
        this.bLNo = StringUtils.rightTrim(bLNo);
    }

    /**
     * ��ȡ�����˾��ƺ�
     * @return �����˾��ƺŵ�ֵ
     */
    public String getBLNo(){
        return bLNo;
    }

    /**
     * �������Ժ���
     * @param voyageNo �����õ����Ժ��ε�ֵ
     */
    public void setVoyageNo(String voyageNo){
        this.voyageNo = StringUtils.rightTrim(voyageNo);
    }

    /**
     * ��ȡ���Ժ���
     * @return ���Ժ��ε�ֵ
     */
    public String getVoyageNo(){
        return voyageNo;
    }

    /**
     * �������Ի�Ʊ�˵���
     * @param carryBillNo �����õ����Ի�Ʊ�˵��ŵ�ֵ
     */
    public void setCarryBillNo(String carryBillNo){
        this.carryBillNo = StringUtils.rightTrim(carryBillNo);
    }

    /**
     * ��ȡ���Ի�Ʊ�˵���
     * @return ���Ի�Ʊ�˵��ŵ�ֵ
     */
    public String getCarryBillNo(){
        return carryBillNo;
    }

    /**
     * �������Ի�������
     * @param detailName �����õ����Ի������Ƶ�ֵ
     */
    public void setDetailName(String detailName){
        this.detailName = StringUtils.rightTrim(detailName);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
    public String getDetailName(){
        return detailName;
    }

    /**
     * ����������������
     * @param startDate �����õ������������ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * �����������˵�
     * @param startSiteName �����õ��������˵ص�ֵ
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * ��ȡ�������˵�
     * @return �������˵ص�ֵ
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
     * �������԰�װ������
     * @param quantity �����õ����԰�װ��������ֵ
     */
    public void setQuantity(String quantity){
        this.quantity = StringUtils.rightTrim(quantity);
    }

    /**
     * ��ȡ���԰�װ������
     * @return ���԰�װ��������ֵ
     */
    public String getQuantity(){
        return quantity;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ի����ֵ
     * @param sumValue �����õ����Ի����ֵ��ֵ
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * ��ȡ���Ի����ֵ
     * @return ���Ի����ֵ��ֵ
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * �������Ա���
     * @param sumAmount �����õ����Ա����ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա����ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * �������Է���
     * @param rate �����õ����Է��ʵ�ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ���Է���
     * @return ���Է��ʵ�ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * �������Ա���
     * @param sumPremium �����õ����Ա��ѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��ѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * �������Խ����־
     * @param settleFlag �����õ����Խ����־��ֵ
     */
    public void setSettleFlag(String settleFlag){
        this.settleFlag = StringUtils.rightTrim(settleFlag);
    }

    /**
     * ��ȡ���Խ����־
     * @return ���Խ����־��ֵ
     */
    public String getSettleFlag(){
        return settleFlag;
    }

    /**
     * �������Ա�ע�ֶ�
     * @param remark �����õ����Ա�ע�ֶε�ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע�ֶ�
     * @return ���Ա�ע�ֶε�ֵ
     */
    public String getRemark(){
        return remark;
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
