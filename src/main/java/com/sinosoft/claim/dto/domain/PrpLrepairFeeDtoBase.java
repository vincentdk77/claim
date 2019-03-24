package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLrepairFee����������嵥��������嵥�����ݴ���������<br>
 * ������ 2006-04-24 10:56:38.753<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrepairFeeDtoBase implements Serializable{
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ���������� */
    private String carKindCode = "";
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
    /** ���Թ�ʱ */
    private double manHour = 0d;
    /** ���Թ�ʱ���� */
    private double manHourUnitPrice = 0d;
    /** ���Թ�ʱ�� */
    private double manHourFee = 0d;
    /** ���Բ��Ϸ� */
    private double materialFee = 0d;
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Աұ� */
    private String currency = "";
    /** ���Ժ˶����� */
    private double sumDefLoss = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Թ�ʱ(����) */
    private double veriManHour = 0d;
    /** ���Թ�ʱ����(����) */
    private double veriManUnitPrice = 0d;
    /** ���Թ�ʱ��(����) */
    private double veriManHourFee = 0d;
    /** ���Բ�������(����) */
    private double veriMaterQuantity = 0d;
    /** ���Բ��ϵ��۷�(����) */
    private double veriMaterUnitPrice = 0d;
    /** ���Բ��Ϸ�(����) */
    private double veriMaterialFee = 0d;
    /** �����⳥���� (����) */
    private double veriLossRate = 0d;
    /** ���Ժ˶�����(����) */
    private double veriSumLoss = 0d;
    /** ���Ա�ע(�������) */
    private String veriRemark = "";
    /** ���Բ������� */
    private double materialQuantity = 0d;
    /** ���Բ��ϵ��� */
    private double materialUnitPrice = 0d;
    /** ����SUMCHECKLOSS */
    private double sumCheckLoss = 0d;
    /** ���Իؿ�����Ŀ��� */
    private String backCheckRemark = "";
    /** ���Ա�Ĵ��� */
    private String lossItemCode = "";
    /** ������ʧ�������� */
    private String partCode = "";
    /** ������ʧ�������� */
    private String partName = "";
    /** ��������ʽ */
    private String repairType = "";
    /** ���Գ��ζ����� */
    private double firstSumDefLoss = 0d;
    /** ����ԭ�л������ */
    private String compensateBackFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLrepairFeeDtoBase����
     */
    public PrpLrepairFeeDtoBase(){
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
     * �������Բ��Ϸ�
     * @param materialFee �����õ����Բ��Ϸѵ�ֵ
     */
    public void setMaterialFee(double materialFee){
        this.materialFee = materialFee;
    }

    /**
     * ��ȡ���Բ��Ϸ�
     * @return ���Բ��Ϸѵ�ֵ
     */
    public double getMaterialFee(){
        return materialFee;
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
     * �������Ժ˶�����
     * @param sumDefLoss �����õ����Ժ˶������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����
     * @return ���Ժ˶������ֵ
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
     * �������Թ�ʱ(����)
     * @param veriManHour �����õ����Թ�ʱ(����)��ֵ
     */
    public void setVeriManHour(double veriManHour){
        this.veriManHour = veriManHour;
    }

    /**
     * ��ȡ���Թ�ʱ(����)
     * @return ���Թ�ʱ(����)��ֵ
     */
    public double getVeriManHour(){
        return veriManHour;
    }

    /**
     * �������Թ�ʱ����(����)
     * @param veriManUnitPrice �����õ����Թ�ʱ����(����)��ֵ
     */
    public void setVeriManUnitPrice(double veriManUnitPrice){
        this.veriManUnitPrice = veriManUnitPrice;
    }

    /**
     * ��ȡ���Թ�ʱ����(����)
     * @return ���Թ�ʱ����(����)��ֵ
     */
    public double getVeriManUnitPrice(){
        return veriManUnitPrice;
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
     * �������Բ�������(����)
     * @param veriMaterQuantity �����õ����Բ�������(����)��ֵ
     */
    public void setVeriMaterQuantity(double veriMaterQuantity){
        this.veriMaterQuantity = veriMaterQuantity;
    }

    /**
     * ��ȡ���Բ�������(����)
     * @return ���Բ�������(����)��ֵ
     */
    public double getVeriMaterQuantity(){
        return veriMaterQuantity;
    }

    /**
     * �������Բ��ϵ��۷�(����)
     * @param veriMaterUnitPrice �����õ����Բ��ϵ��۷�(����)��ֵ
     */
    public void setVeriMaterUnitPrice(double veriMaterUnitPrice){
        this.veriMaterUnitPrice = veriMaterUnitPrice;
    }

    /**
     * ��ȡ���Բ��ϵ��۷�(����)
     * @return ���Բ��ϵ��۷�(����)��ֵ
     */
    public double getVeriMaterUnitPrice(){
        return veriMaterUnitPrice;
    }

    /**
     * �������Բ��Ϸ�(����)
     * @param veriMaterialFee �����õ����Բ��Ϸ�(����)��ֵ
     */
    public void setVeriMaterialFee(double veriMaterialFee){
        this.veriMaterialFee = veriMaterialFee;
    }

    /**
     * ��ȡ���Բ��Ϸ�(����)
     * @return ���Բ��Ϸ�(����)��ֵ
     */
    public double getVeriMaterialFee(){
        return veriMaterialFee;
    }

    /**
     * ���������⳥���� (����)
     * @param veriLossRate �����õ������⳥���� (����)��ֵ
     */
    public void setVeriLossRate(double veriLossRate){
        this.veriLossRate = veriLossRate;
    }

    /**
     * ��ȡ�����⳥���� (����)
     * @return �����⳥���� (����)��ֵ
     */
    public double getVeriLossRate(){
        return veriLossRate;
    }

    /**
     * �������Ժ˶�����(����)
     * @param veriSumLoss �����õ����Ժ˶�����(����)��ֵ
     */
    public void setVeriSumLoss(double veriSumLoss){
        this.veriSumLoss = veriSumLoss;
    }

    /**
     * ��ȡ���Ժ˶�����(����)
     * @return ���Ժ˶�����(����)��ֵ
     */
    public double getVeriSumLoss(){
        return veriSumLoss;
    }

    /**
     * �������Ա�ע(�������)
     * @param veriRemark �����õ����Ա�ע(�������)��ֵ
     */
    public void setVeriRemark(String veriRemark){
        this.veriRemark = StringUtils.rightTrim(veriRemark);
    }

    /**
     * ��ȡ���Ա�ע(�������)
     * @return ���Ա�ע(�������)��ֵ
     */
    public String getVeriRemark(){
        return veriRemark;
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
     * �������Բ��ϵ���
     * @param materialUnitPrice �����õ����Բ��ϵ��۵�ֵ
     */
    public void setMaterialUnitPrice(double materialUnitPrice){
        this.materialUnitPrice = materialUnitPrice;
    }

    /**
     * ��ȡ���Բ��ϵ���
     * @return ���Բ��ϵ��۵�ֵ
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
     * ������������ʽ
     * @param repairType �����õ���������ʽ��ֵ
     */
    public void setRepairType(String repairType){
        this.repairType = StringUtils.rightTrim(repairType);
    }

    /**
     * ��ȡ��������ʽ
     * @return ��������ʽ��ֵ
     */
    public String getRepairType(){
        return repairType;
    }

    /**
     * �������Գ��ζ�����
     * @param firstSumDefLoss �����õ����Գ��ζ������ֵ
     */
    public void setFirstSumDefLoss(double firstSumDefLoss){
        this.firstSumDefLoss = firstSumDefLoss;
    }

    /**
     * ��ȡ���Գ��ζ�����
     * @return ���Գ��ζ������ֵ
     */
    public double getFirstSumDefLoss(){
        return firstSumDefLoss;
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
