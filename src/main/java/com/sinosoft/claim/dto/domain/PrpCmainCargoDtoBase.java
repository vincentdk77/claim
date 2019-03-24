package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PRPCMAINCARGO-�����ձ�����Ϣ�����ݴ���������<br>
 * ������ 2005-06-02 10:27:43.000<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCmainCargoDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է������ */
    private String riskKind = "";
    /** ����CONVEYDATEDESC */
    private String conveyDateDesc = "";
    /** ���Լ۸����� */
    private String priceCondition = "";
    /** �����ᵥ�� */
    private String ladingNo = "";
    /** ���Է�Ʊ�� */
    private String invoiceNo = "";
    /** ���Է�Ʊ���ұ� */
    private String invoiceCurrency = "";
    /** ���Է�Ʊ��� */
    private double invoiceAmount = 0d;
    /** ���Լӳɱ��� */
    private double plusRate = 0d;
    /** ��������֤�� */
    private String creditNo = "";
    /** ��������֪ͨ���� */
    private String shipNoteNo = "";
    /** ���Ժ�ͬ�� */
    private String bargainNo = "";
    /** ����װ�����乤�� */
    private String conveyance = "";
    /** �����˾����� */
    private String bLName = "";
    /** ���Ի�Ʊ�˵��� */
    private String carryBillNo = "";
    /** ����ת�˹��� */
    private String transferConveyance = "";
    /** �����˾��ƺ� */
    private String bLNo = "";
    /** ���Ժ��� */
    private String voyageNo = "";
    /** ����Ԥ����Ϣ */
    private String preserveInfo = "";
    /** ���Զ�λ�� */
    private double tonCount = 0d;
    /** ������ʼ�ر��� */
    private String startSiteCode = "";
    /** ������ʼ������ */
    private String startSiteName = "";
    /** ������ת�ر��� */
    private String viaSiteCode = "";
    /** ������ת������ */
    private String viaSiteName = "";
    /** ����ת�ص����� */
    private String reshipSiteName = "";
    /** ������ֹ�ر��� */
    private String endSiteCode = "";
    /** ������ֹ������ */
    private String endSiteName = "";
    /** ���Ծ�����ֹ������ */
    private String endDetailName = "";
    /** ���Թ����������˴��� */
    private String checkAgentCode = "";
    /** ���������ص� */
    private String claimSite = "";
    /** ���Թ������� */
    private String transferBank = "";
    /** ���Ա����������� */
    private double originalCount = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCmainCargoDtoBase����
     */
    public PrpCmainCargoDtoBase(){
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
     * �������Է������
     * @param riskKind �����õ����Է�������ֵ
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * ��ȡ���Է������
     * @return ���Է�������ֵ
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * ��������CONVEYDATEDESC
     * @param conveyDateDesc �����õ�����CONVEYDATEDESC��ֵ
     */
    public void setConveyDateDesc(String conveyDateDesc){
        this.conveyDateDesc = StringUtils.rightTrim(conveyDateDesc);
    }

    /**
     * ��ȡ����CONVEYDATEDESC
     * @return ����CONVEYDATEDESC��ֵ
     */
    public String getConveyDateDesc(){
        return conveyDateDesc;
    }

    /**
     * �������Լ۸�����
     * @param priceCondition �����õ����Լ۸�������ֵ
     */
    public void setPriceCondition(String priceCondition){
        this.priceCondition = StringUtils.rightTrim(priceCondition);
    }

    /**
     * ��ȡ���Լ۸�����
     * @return ���Լ۸�������ֵ
     */
    public String getPriceCondition(){
        return priceCondition;
    }

    /**
     * ���������ᵥ��
     * @param ladingNo �����õ������ᵥ�ŵ�ֵ
     */
    public void setLadingNo(String ladingNo){
        this.ladingNo = StringUtils.rightTrim(ladingNo);
    }

    /**
     * ��ȡ�����ᵥ��
     * @return �����ᵥ�ŵ�ֵ
     */
    public String getLadingNo(){
        return ladingNo;
    }

    /**
     * �������Է�Ʊ��
     * @param invoiceNo �����õ����Է�Ʊ�ŵ�ֵ
     */
    public void setInvoiceNo(String invoiceNo){
        this.invoiceNo = StringUtils.rightTrim(invoiceNo);
    }

    /**
     * ��ȡ���Է�Ʊ��
     * @return ���Է�Ʊ�ŵ�ֵ
     */
    public String getInvoiceNo(){
        return invoiceNo;
    }

    /**
     * �������Է�Ʊ���ұ�
     * @param invoiceCurrency �����õ����Է�Ʊ���ұ��ֵ
     */
    public void setInvoiceCurrency(String invoiceCurrency){
        this.invoiceCurrency = StringUtils.rightTrim(invoiceCurrency);
    }

    /**
     * ��ȡ���Է�Ʊ���ұ�
     * @return ���Է�Ʊ���ұ��ֵ
     */
    public String getInvoiceCurrency(){
        return invoiceCurrency;
    }

    /**
     * �������Է�Ʊ���
     * @param invoiceAmount �����õ����Է�Ʊ����ֵ
     */
    public void setInvoiceAmount(double invoiceAmount){
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * ��ȡ���Է�Ʊ���
     * @return ���Է�Ʊ����ֵ
     */
    public double getInvoiceAmount(){
        return invoiceAmount;
    }

    /**
     * �������Լӳɱ���
     * @param plusRate �����õ����Լӳɱ�����ֵ
     */
    public void setPlusRate(double plusRate){
        this.plusRate = plusRate;
    }

    /**
     * ��ȡ���Լӳɱ���
     * @return ���Լӳɱ�����ֵ
     */
    public double getPlusRate(){
        return plusRate;
    }

    /**
     * ������������֤��
     * @param creditNo �����õ���������֤�ŵ�ֵ
     */
    public void setCreditNo(String creditNo){
        this.creditNo = StringUtils.rightTrim(creditNo);
    }

    /**
     * ��ȡ��������֤��
     * @return ��������֤�ŵ�ֵ
     */
    public String getCreditNo(){
        return creditNo;
    }

    /**
     * ������������֪ͨ����
     * @param shipNoteNo �����õ���������֪ͨ���ŵ�ֵ
     */
    public void setShipNoteNo(String shipNoteNo){
        this.shipNoteNo = StringUtils.rightTrim(shipNoteNo);
    }

    /**
     * ��ȡ��������֪ͨ����
     * @return ��������֪ͨ���ŵ�ֵ
     */
    public String getShipNoteNo(){
        return shipNoteNo;
    }

    /**
     * �������Ժ�ͬ��
     * @param bargainNo �����õ����Ժ�ͬ�ŵ�ֵ
     */
    public void setBargainNo(String bargainNo){
        this.bargainNo = StringUtils.rightTrim(bargainNo);
    }

    /**
     * ��ȡ���Ժ�ͬ��
     * @return ���Ժ�ͬ�ŵ�ֵ
     */
    public String getBargainNo(){
        return bargainNo;
    }

    /**
     * ��������װ�����乤��
     * @param conveyance �����õ�����װ�����乤�ߵ�ֵ
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * ��ȡ����װ�����乤��
     * @return ����װ�����乤�ߵ�ֵ
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * ���������˾�����
     * @param bLName �����õ������˾����Ƶ�ֵ
     */
    public void setBLName(String bLName){
        this.bLName = StringUtils.rightTrim(bLName);
    }

    /**
     * ��ȡ�����˾�����
     * @return �����˾����Ƶ�ֵ
     */
    public String getBLName(){
        return bLName;
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
     * ��������ת�˹���
     * @param transferConveyance �����õ�����ת�˹��ߵ�ֵ
     */
    public void setTransferConveyance(String transferConveyance){
        this.transferConveyance = StringUtils.rightTrim(transferConveyance);
    }

    /**
     * ��ȡ����ת�˹���
     * @return ����ת�˹��ߵ�ֵ
     */
    public String getTransferConveyance(){
        return transferConveyance;
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
     * ��������Ԥ����Ϣ
     * @param preserveInfo �����õ�����Ԥ����Ϣ��ֵ
     */
    public void setPreserveInfo(String preserveInfo){
        this.preserveInfo = StringUtils.rightTrim(preserveInfo);
    }

    /**
     * ��ȡ����Ԥ����Ϣ
     * @return ����Ԥ����Ϣ��ֵ
     */
    public String getPreserveInfo(){
        return preserveInfo;
    }

    /**
     * �������Զ�λ��
     * @param tonCount �����õ����Զ�λ����ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ���Զ�λ��
     * @return ���Զ�λ����ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * ����������ʼ�ر���
     * @param startSiteCode �����õ�������ʼ�ر����ֵ
     */
    public void setStartSiteCode(String startSiteCode){
        this.startSiteCode = StringUtils.rightTrim(startSiteCode);
    }

    /**
     * ��ȡ������ʼ�ر���
     * @return ������ʼ�ر����ֵ
     */
    public String getStartSiteCode(){
        return startSiteCode;
    }

    /**
     * ����������ʼ������
     * @param startSiteName �����õ�������ʼ�����Ƶ�ֵ
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * ��ȡ������ʼ������
     * @return ������ʼ�����Ƶ�ֵ
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * ����������ת�ر���
     * @param viaSiteCode �����õ�������ת�ر����ֵ
     */
    public void setViaSiteCode(String viaSiteCode){
        this.viaSiteCode = StringUtils.rightTrim(viaSiteCode);
    }

    /**
     * ��ȡ������ת�ر���
     * @return ������ת�ر����ֵ
     */
    public String getViaSiteCode(){
        return viaSiteCode;
    }

    /**
     * ����������ת������
     * @param viaSiteName �����õ�������ת�����Ƶ�ֵ
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * ��ȡ������ת������
     * @return ������ת�����Ƶ�ֵ
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * ��������ת�ص�����
     * @param reshipSiteName �����õ�����ת�ص����Ƶ�ֵ
     */
    public void setReshipSiteName(String reshipSiteName){
        this.reshipSiteName = StringUtils.rightTrim(reshipSiteName);
    }

    /**
     * ��ȡ����ת�ص�����
     * @return ����ת�ص����Ƶ�ֵ
     */
    public String getReshipSiteName(){
        return reshipSiteName;
    }

    /**
     * ����������ֹ�ر���
     * @param endSiteCode �����õ�������ֹ�ر����ֵ
     */
    public void setEndSiteCode(String endSiteCode){
        this.endSiteCode = StringUtils.rightTrim(endSiteCode);
    }

    /**
     * ��ȡ������ֹ�ر���
     * @return ������ֹ�ر����ֵ
     */
    public String getEndSiteCode(){
        return endSiteCode;
    }

    /**
     * ����������ֹ������
     * @param endSiteName �����õ�������ֹ�����Ƶ�ֵ
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * ��ȡ������ֹ������
     * @return ������ֹ�����Ƶ�ֵ
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * �������Ծ�����ֹ������
     * @param endDetailName �����õ����Ծ�����ֹ�����Ƶ�ֵ
     */
    public void setEndDetailName(String endDetailName){
        this.endDetailName = StringUtils.rightTrim(endDetailName);
    }

    /**
     * ��ȡ���Ծ�����ֹ������
     * @return ���Ծ�����ֹ�����Ƶ�ֵ
     */
    public String getEndDetailName(){
        return endDetailName;
    }

    /**
     * �������Թ����������˴���
     * @param checkAgentCode �����õ����Թ����������˴����ֵ
     */
    public void setCheckAgentCode(String checkAgentCode){
        this.checkAgentCode = StringUtils.rightTrim(checkAgentCode);
    }

    /**
     * ��ȡ���Թ����������˴���
     * @return ���Թ����������˴����ֵ
     */
    public String getCheckAgentCode(){
        return checkAgentCode;
    }

    /**
     * �������������ص�
     * @param claimSite �����õ����������ص��ֵ
     */
    public void setClaimSite(String claimSite){
        this.claimSite = StringUtils.rightTrim(claimSite);
    }

    /**
     * ��ȡ���������ص�
     * @return ���������ص��ֵ
     */
    public String getClaimSite(){
        return claimSite;
    }

    /**
     * �������Թ�������
     * @param transferBank �����õ����Թ������е�ֵ
     */
    public void setTransferBank(String transferBank){
        this.transferBank = StringUtils.rightTrim(transferBank);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������е�ֵ
     */
    public String getTransferBank(){
        return transferBank;
    }

    /**
     * �������Ա�����������
     * @param originalCount �����õ����Ա�������������ֵ
     */
    public void setOriginalCount(double originalCount){
        this.originalCount = originalCount;
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա�������������ֵ
     */
    public double getOriginalCount(){
        return originalCount;
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
