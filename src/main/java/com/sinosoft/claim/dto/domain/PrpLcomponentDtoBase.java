package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcomponent��������Ŀ�嵥�����ݴ���������<br>
 * ������ 2006-04-24 19:02:04.443<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcomponentDtoBase implements Serializable{
    /** �������� */
    private String riskCode = "";
    /** ���������� */
    private String claimNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա�Ĵ��� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** ����������� */
    private String makeYear = "";
    /** ���Ա�������ʽ */
    private String gearboxType = "";
    /** ���Ա��۹�˾�ȼ� */
    private String quoteCompanyGrade = "";
    /** ���Թ���ѱ��� */
    private double manageFeeRate = 0d;
    /** ������������ */
    private String repairFactoryCode = "";
    /** ������������ */
    private String repairFactoryName = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ������������ */
    private DateTime repairStartDate = new DateTime();
    /** �����޻����� */
    private DateTime repairEndDate = new DateTime();
    /** ���Բ�λ���� */
    private String partDesc = "";
    /** ���Ժ�׼�� */
    private String sanctioner = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ����������Ŀ���� */
    private String compCode = "";
    /** ����������Ŀ���� */
    private String compName = "";
    /** �������� */
    private int quantity = 0;
    /** ���Թ�ʱ�� */
    private double manHourFee = 0d;
    /** ���Բ��Ϸѣ��ϱ��۸� */
    private double materialFee = 0d;
    /** ����ѯ�ۼ۸� */
    private double queryPrice = 0d;
    /** ���Ա��ۼ۸� */
    private double quotedPrice = 0d;
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Աұ� */
    private String currency = "";
    /** ���Ժ˶�����м������������� */
    private double sumDefLoss = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Թ�ʱ */
    private double manHour = 0d;
    /** ���Թ�ʱ���� */
    private double manHourUnitPrice = 0d;
    /** ���Բ������� */
    private double materialQuantity = 0d;
    /** ���Բ��ϵ��۷� */
    private double materialUnitPrice = 0d;
    /** ����SUMCHECKLOSS */
    private double sumCheckLoss = 0d;
    /** ��������(����) */
    private int veriQuantity = 0;
    /** ���Թ�ʱ��(����) */
    private double veriManHourFee = 0d;
    /** ���Բ��Ϸ�(����) */
    private double veriMaterFee = 0d;
    /** �����⳥����(����) */
    private double veriLossRate = 0d;
    /** ���Ժ˶�����(����) */
    private double sumVeriLoss = 0d;
    /** ���Ա�ע����������� */
    private String veriRemark = "";
    /** ���Բ�ֵ(����) */
    private double veriRestFee = 0d;
    /** ���Բ�ֵ */
    private double sumReject = 0d;
    /** �����޳�ԭ�� */
    private String rejectReason = "";
    /** ���Բ�ֵ1 */
    private double restFee = 0d;
    /** ���Իؿ�����Ŀ��� */
    private String backCheckRemark = "";
    /** ������ʧ�������� */
    private String partCode = "";
    /** ������ʧ�������� */
    private String partName = "";
    /** ���������ԭ������ */
    private String originalId = "";
    /** ����ϵͳר�޼۸� */
    private double sys4SPrice = 0d;
    /** ����ϵͳ�г��۸� */
    private double sysMarketPrice = 0d;
    /** ����ϵͳ���׼۸� */
    private double sysMatchPrice = 0d;
    /** ���Ա���ר�޼۸� */
    private double native4SPrice = 0d;
    /** ���Ա����г��۸� */
    private double nativeMarketPrice = 0d;
    /** ���Ա������׼۸� */
    private double nativeMatchPrice = 0d;
    /** ����������۸񣨺˼ۣ� */
    private double verpCompPrice = 0d;
    /** ���������� */
    private int indId = 0;
    /** ����FirstMaterialFee */
    private double firstMaterialFee = 0d;
    /** ����VerpoFlag */
    private String verpoFlag = "";
    /** ����ԭ�л������ */
    private String compensateBackFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcomponentDtoBase����
     */
    public PrpLcomponentDtoBase(){
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
     * ��������������
     * @param claimNo �����õ����������ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Ա�������������
     * @param itemKindNo �����õ����Ա������������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�������������
     * @return ���Ա������������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Ա�Ĵ���
     * @param lossItemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Գ��Ƶ�ɫ����
     * @param licenseColorCode �����õ����Գ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * ��ȡ���Գ��Ƶ�ɫ����
     * @return ���Գ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * �������Գ����������
     * @param carKindCode �����õ����Գ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * ���������������
     * @param makeYear �����õ�����������ݵ�ֵ
     */
    public void setMakeYear(String makeYear){
        this.makeYear = StringUtils.rightTrim(makeYear);
    }

    /**
     * ��ȡ�����������
     * @return ����������ݵ�ֵ
     */
    public String getMakeYear(){
        return makeYear;
    }

    /**
     * �������Ա�������ʽ
     * @param gearboxType �����õ����Ա�������ʽ��ֵ
     */
    public void setGearboxType(String gearboxType){
        this.gearboxType = StringUtils.rightTrim(gearboxType);
    }

    /**
     * ��ȡ���Ա�������ʽ
     * @return ���Ա�������ʽ��ֵ
     */
    public String getGearboxType(){
        return gearboxType;
    }

    /**
     * �������Ա��۹�˾�ȼ�
     * @param quoteCompanyGrade �����õ����Ա��۹�˾�ȼ���ֵ
     */
    public void setQuoteCompanyGrade(String quoteCompanyGrade){
        this.quoteCompanyGrade = StringUtils.rightTrim(quoteCompanyGrade);
    }

    /**
     * ��ȡ���Ա��۹�˾�ȼ�
     * @return ���Ա��۹�˾�ȼ���ֵ
     */
    public String getQuoteCompanyGrade(){
        return quoteCompanyGrade;
    }

    /**
     * �������Թ���ѱ���
     * @param manageFeeRate �����õ����Թ���ѱ�����ֵ
     */
    public void setManageFeeRate(double manageFeeRate){
        this.manageFeeRate = manageFeeRate;
    }

    /**
     * ��ȡ���Թ���ѱ���
     * @return ���Թ���ѱ�����ֵ
     */
    public double getManageFeeRate(){
        return manageFeeRate;
    }

    /**
     * ����������������
     * @param repairFactoryCode �����õ��������������ֵ
     */
    public void setRepairFactoryCode(String repairFactoryCode){
        this.repairFactoryCode = StringUtils.rightTrim(repairFactoryCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getRepairFactoryCode(){
        return repairFactoryCode;
    }

    /**
     * ����������������
     * @param repairFactoryName �����õ������������Ƶ�ֵ
     */
    public void setRepairFactoryName(String repairFactoryName){
        this.repairFactoryName = StringUtils.rightTrim(repairFactoryName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getRepairFactoryName(){
        return repairFactoryName;
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
     * ����������������
     * @param repairStartDate �����õ������������ڵ�ֵ
     */
    public void setRepairStartDate(DateTime repairStartDate){
        this.repairStartDate = repairStartDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getRepairStartDate(){
        return repairStartDate;
    }

    /**
     * ���������޻�����
     * @param repairEndDate �����õ������޻����ڵ�ֵ
     */
    public void setRepairEndDate(DateTime repairEndDate){
        this.repairEndDate = repairEndDate;
    }

    /**
     * ��ȡ�����޻�����
     * @return �����޻����ڵ�ֵ
     */
    public DateTime getRepairEndDate(){
        return repairEndDate;
    }

    /**
     * �������Բ�λ����
     * @param partDesc �����õ����Բ�λ���Ƶ�ֵ
     */
    public void setPartDesc(String partDesc){
        this.partDesc = StringUtils.rightTrim(partDesc);
    }

    /**
     * ��ȡ���Բ�λ����
     * @return ���Բ�λ���Ƶ�ֵ
     */
    public String getPartDesc(){
        return partDesc;
    }

    /**
     * �������Ժ�׼��
     * @param sanctioner �����õ����Ժ�׼�˵�ֵ
     */
    public void setSanctioner(String sanctioner){
        this.sanctioner = StringUtils.rightTrim(sanctioner);
    }

    /**
     * ��ȡ���Ժ�׼��
     * @return ���Ժ�׼�˵�ֵ
     */
    public String getSanctioner(){
        return sanctioner;
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
     * ��������������Ŀ����
     * @param compCode �����õ�����������Ŀ�����ֵ
     */
    public void setCompCode(String compCode){
        this.compCode = StringUtils.rightTrim(compCode);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ�����ֵ
     */
    public String getCompCode(){
        return compCode;
    }

    /**
     * ��������������Ŀ����
     * @param compName �����õ�����������Ŀ���Ƶ�ֵ
     */
    public void setCompName(String compName){
        this.compName = StringUtils.rightTrim(compName);
    }

    /**
     * ��ȡ����������Ŀ����
     * @return ����������Ŀ���Ƶ�ֵ
     */
    public String getCompName(){
        return compName;
    }

    /**
     * ������������
     * @param quantity �����õ�����������ֵ
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * �������Թ�ʱ��
     * @param manHourFee �����õ����Թ�ʱ�ѵ�ֵ
     */
    public void setManHourFee(double manHourFee){
        this.manHourFee = manHourFee;
    }

    /**
     * ��ȡ���Թ�ʱ��
     * @return ���Թ�ʱ�ѵ�ֵ
     */
    public double getManHourFee(){
        return manHourFee;
    }

    /**
     * �������Բ��Ϸѣ��ϱ��۸�
     * @param materialFee �����õ����Բ��Ϸѣ��ϱ��۸񣩵�ֵ
     */
    public void setMaterialFee(double materialFee){
        this.materialFee = materialFee;
    }

    /**
     * ��ȡ���Բ��Ϸѣ��ϱ��۸�
     * @return ���Բ��Ϸѣ��ϱ��۸񣩵�ֵ
     */
    public double getMaterialFee(){
        return materialFee;
    }

    /**
     * ��������ѯ�ۼ۸�
     * @param queryPrice �����õ�����ѯ�ۼ۸��ֵ
     */
    public void setQueryPrice(double queryPrice){
        this.queryPrice = queryPrice;
    }

    /**
     * ��ȡ����ѯ�ۼ۸�
     * @return ����ѯ�ۼ۸��ֵ
     */
    public double getQueryPrice(){
        return queryPrice;
    }

    /**
     * �������Ա��ۼ۸�
     * @param quotedPrice �����õ����Ա��ۼ۸��ֵ
     */
    public void setQuotedPrice(double quotedPrice){
        this.quotedPrice = quotedPrice;
    }

    /**
     * ��ȡ���Ա��ۼ۸�
     * @return ���Ա��ۼ۸��ֵ
     */
    public double getQuotedPrice(){
        return quotedPrice;
    }

    /**
     * ���������⳥����
     * @param lossRate �����õ������⳥������ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ�����⳥����
     * @return �����⳥������ֵ
     */
    public double getLossRate(){
        return lossRate;
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
     * �������Ժ˶�����м�������������
     * @param sumDefLoss �����õ����Ժ˶�����м���������������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����м�������������
     * @return ���Ժ˶�����м���������������ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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

    /**
     * �������Թ�ʱ
     * @param manHour �����õ����Թ�ʱ��ֵ
     */
    public void setManHour(double manHour){
        this.manHour = manHour;
    }

    /**
     * ��ȡ���Թ�ʱ
     * @return ���Թ�ʱ��ֵ
     */
    public double getManHour(){
        return manHour;
    }

    /**
     * �������Թ�ʱ����
     * @param manHourUnitPrice �����õ����Թ�ʱ���۵�ֵ
     */
    public void setManHourUnitPrice(double manHourUnitPrice){
        this.manHourUnitPrice = manHourUnitPrice;
    }

    /**
     * ��ȡ���Թ�ʱ����
     * @return ���Թ�ʱ���۵�ֵ
     */
    public double getManHourUnitPrice(){
        return manHourUnitPrice;
    }

    /**
     * �������Բ�������
     * @param materialQuantity �����õ����Բ���������ֵ
     */
    public void setMaterialQuantity(double materialQuantity){
        this.materialQuantity = materialQuantity;
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ���������ֵ
     */
    public double getMaterialQuantity(){
        return materialQuantity;
    }

    /**
     * �������Բ��ϵ��۷�
     * @param materialUnitPrice �����õ����Բ��ϵ��۷ѵ�ֵ
     */
    public void setMaterialUnitPrice(double materialUnitPrice){
        this.materialUnitPrice = materialUnitPrice;
    }

    /**
     * ��ȡ���Բ��ϵ��۷�
     * @return ���Բ��ϵ��۷ѵ�ֵ
     */
    public double getMaterialUnitPrice(){
        return materialUnitPrice;
    }

    /**
     * ��������SUMCHECKLOSS
     * @param sumCheckLoss �����õ�����SUMCHECKLOSS��ֵ
     */
    public void setSumCheckLoss(double sumCheckLoss){
        this.sumCheckLoss = sumCheckLoss;
    }

    /**
     * ��ȡ����SUMCHECKLOSS
     * @return ����SUMCHECKLOSS��ֵ
     */
    public double getSumCheckLoss(){
        return sumCheckLoss;
    }

    /**
     * ������������(����)
     * @param veriQuantity �����õ���������(����)��ֵ
     */
    public void setVeriQuantity(int veriQuantity){
        this.veriQuantity = veriQuantity;
    }

    /**
     * ��ȡ��������(����)
     * @return ��������(����)��ֵ
     */
    public int getVeriQuantity(){
        return veriQuantity;
    }

    /**
     * �������Թ�ʱ��(����)
     * @param veriManHourFee �����õ����Թ�ʱ��(����)��ֵ
     */
    public void setVeriManHourFee(double veriManHourFee){
        this.veriManHourFee = veriManHourFee;
    }

    /**
     * ��ȡ���Թ�ʱ��(����)
     * @return ���Թ�ʱ��(����)��ֵ
     */
    public double getVeriManHourFee(){
        return veriManHourFee;
    }

    /**
     * �������Բ��Ϸ�(����)
     * @param veriMaterFee �����õ����Բ��Ϸ�(����)��ֵ
     */
    public void setVeriMaterFee(double veriMaterFee){
        this.veriMaterFee = veriMaterFee;
    }

    /**
     * ��ȡ���Բ��Ϸ�(����)
     * @return ���Բ��Ϸ�(����)��ֵ
     */
    public double getVeriMaterFee(){
        return veriMaterFee;
    }

    /**
     * ���������⳥����(����)
     * @param veriLossRate �����õ������⳥����(����)��ֵ
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * ��ȡ�����⳥����(����)
     * @return �����⳥����(����)��ֵ
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * �������Ժ˶�����(����)
     * @param sumVeriLoss �����õ����Ժ˶�����(����)��ֵ
     */
    public void setSumVeriLoss(double sumVeriLoss){
        this.sumVeriLoss = sumVeriLoss;
    }

    /**
     * ��ȡ���Ժ˶�����(����)
     * @return ���Ժ˶�����(����)��ֵ
     */
    public double getSumVeriLoss(){
        return sumVeriLoss;
    }

    /**
     * �������Ա�ע�����������
     * @param veriRemark �����õ����Ա�ע�������������ֵ
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * ��ȡ���Ա�ע�����������
     * @return ���Ա�ע�������������ֵ
     */
    public String getVeriRemark(){
        return veriRemark;
    }

    /**
     * �������Բ�ֵ(����)
     * @param veriRestFee �����õ����Բ�ֵ(����)��ֵ
     */
    public void setVeriRestFee(double veriRestFee){
        this.veriRestFee = veriRestFee;
    }

    /**
     * ��ȡ���Բ�ֵ(����)
     * @return ���Բ�ֵ(����)��ֵ
     */
    public double getVeriRestFee(){
        return veriRestFee;
    }

    /**
     * �������Բ�ֵ
     * @param sumReject �����õ����Բ�ֵ��ֵ
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * ��ȡ���Բ�ֵ
     * @return ���Բ�ֵ��ֵ
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * ���������޳�ԭ��
     * @param rejectReason �����õ������޳�ԭ���ֵ
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * ��ȡ�����޳�ԭ��
     * @return �����޳�ԭ���ֵ
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * �������Բ�ֵ1
     * @param restFee �����õ����Բ�ֵ1��ֵ
     */
    public void setRestFee(double restFee){
        this.restFee = restFee;
    }

    /**
     * ��ȡ���Բ�ֵ1
     * @return ���Բ�ֵ1��ֵ
     */
    public double getRestFee(){
        return restFee;
    }

    /**
     * �������Իؿ�����Ŀ���
     * @param backCheckRemark �����õ����Իؿ�����Ŀ�����ֵ
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * ��ȡ���Իؿ�����Ŀ���
     * @return ���Իؿ�����Ŀ�����ֵ
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * ����������ʧ��������
     * @param partCode �����õ�������ʧ���������ֵ
     */
    public void setPartCode(String partCode){
        this.partCode = StringUtils.rightTrim(partCode);
    }

    /**
     * ��ȡ������ʧ��������
     * @return ������ʧ���������ֵ
     */
    public String getPartCode(){
        return partCode;
    }

    /**
     * ����������ʧ��������
     * @param partName �����õ�������ʧ�������Ƶ�ֵ
     */
    public void setPartName(String partName){
        this.partName = StringUtils.rightTrim(partName);
    }

    /**
     * ��ȡ������ʧ��������
     * @return ������ʧ�������Ƶ�ֵ
     */
    public String getPartName(){
        return partName;
    }

    /**
     * �������������ԭ������
     * @param originalId �����õ����������ԭ�������ֵ
     */
    public void setOriginalId(String originalId){
        this.originalId = StringUtils.rightTrim(originalId);
    }

    /**
     * ��ȡ���������ԭ������
     * @return ���������ԭ�������ֵ
     */
    public String getOriginalId(){
        return originalId;
    }

    /**
     * ��������ϵͳר�޼۸�
     * @param sys4SPrice �����õ�����ϵͳר�޼۸��ֵ
     */
    public void setSys4SPrice(double sys4SPrice){
        this.sys4SPrice = sys4SPrice;
    }

    /**
     * ��ȡ����ϵͳר�޼۸�
     * @return ����ϵͳר�޼۸��ֵ
     */
    public double getSys4SPrice(){
        return sys4SPrice;
    }

    /**
     * ��������ϵͳ�г��۸�
     * @param sysMarketPrice �����õ�����ϵͳ�г��۸��ֵ
     */
    public void setSysMarketPrice(double sysMarketPrice){
        this.sysMarketPrice = sysMarketPrice;
    }

    /**
     * ��ȡ����ϵͳ�г��۸�
     * @return ����ϵͳ�г��۸��ֵ
     */
    public double getSysMarketPrice(){
        return sysMarketPrice;
    }

    /**
     * ��������ϵͳ���׼۸�
     * @param sysMatchPrice �����õ�����ϵͳ���׼۸��ֵ
     */
    public void setSysMatchPrice(double sysMatchPrice){
        this.sysMatchPrice = sysMatchPrice;
    }

    /**
     * ��ȡ����ϵͳ���׼۸�
     * @return ����ϵͳ���׼۸��ֵ
     */
    public double getSysMatchPrice(){
        return sysMatchPrice;
    }

    /**
     * �������Ա���ר�޼۸�
     * @param native4SPrice �����õ����Ա���ר�޼۸��ֵ
     */
    public void setNative4SPrice(double native4SPrice){
        this.native4SPrice = native4SPrice;
    }

    /**
     * ��ȡ���Ա���ר�޼۸�
     * @return ���Ա���ר�޼۸��ֵ
     */
    public double getNative4SPrice(){
        return native4SPrice;
    }

    /**
     * �������Ա����г��۸�
     * @param nativeMarketPrice �����õ����Ա����г��۸��ֵ
     */
    public void setNativeMarketPrice(double nativeMarketPrice){
        this.nativeMarketPrice = nativeMarketPrice;
    }

    /**
     * ��ȡ���Ա����г��۸�
     * @return ���Ա����г��۸��ֵ
     */
    public double getNativeMarketPrice(){
        return nativeMarketPrice;
    }

    /**
     * �������Ա������׼۸�
     * @param nativeMatchPrice �����õ����Ա������׼۸��ֵ
     */
    public void setNativeMatchPrice(double nativeMatchPrice){
        this.nativeMatchPrice = nativeMatchPrice;
    }

    /**
     * ��ȡ���Ա������׼۸�
     * @return ���Ա������׼۸��ֵ
     */
    public double getNativeMatchPrice(){
        return nativeMatchPrice;
    }

    /**
     * ��������������۸񣨺˼ۣ�
     * @param verpCompPrice �����õ�����������۸񣨺˼ۣ���ֵ
     */
    public void setVerpCompPrice(double verpCompPrice){
        this.verpCompPrice = verpCompPrice;
    }

    /**
     * ��ȡ����������۸񣨺˼ۣ�
     * @return ����������۸񣨺˼ۣ���ֵ
     */
    public double getVerpCompPrice(){
        return verpCompPrice;
    }

    /**
     * ��������������
     * @param indId �����õ����������ŵ�ֵ
     */
    public void setIndId(int indId){
        this.indId = indId;
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public int getIndId(){
        return indId;
    }

    /**
     * ��������FirstMaterialFee
     * @param firstMaterialFee �����õ�����FirstMaterialFee��ֵ
     */
    public void setFirstMaterialFee(double firstMaterialFee){
        this.firstMaterialFee = firstMaterialFee;
    }

    /**
     * ��ȡ����FirstMaterialFee
     * @return ����FirstMaterialFee��ֵ
     */
    public double getFirstMaterialFee(){
        return firstMaterialFee;
    }

    /**
     * ��������VerpoFlag
     * @param verpoFlag �����õ�����VerpoFlag��ֵ
     */
    public void setVerpoFlag(String verpoFlag){
        this.verpoFlag = StringUtils.rightTrim(verpoFlag);
    }

    /**
     * ��ȡ����VerpoFlag
     * @return ����VerpoFlag��ֵ
     */
    public String getVerpoFlag(){
        return verpoFlag;
    }

    /**
     * ��������ԭ�л������
     * @param compensateBackFlag �����õ�����ԭ�л�����ǵ�ֵ
     */
    public void setCompensateBackFlag(String compensateBackFlag){
        this.compensateBackFlag = StringUtils.rightTrim(compensateBackFlag);
    }

    /**
     * ��ȡ����ԭ�л������
     * @return ����ԭ�л�����ǵ�ֵ
     */
    public String getCompensateBackFlag(){
        return compensateBackFlag;
    }
}
