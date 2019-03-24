package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpCreditInvest���ŵ��������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCreditInvestDtoBase implements Serializable{
    /** ���Է���Ԥ���� */
    private String investigateNo = "";
    /** ����ȷ�Ϻ��� */
    private String confirmNo = "";
    /** ���Գ��ձ����� */
    private String carPolicyNo = "";
    /** ���Ա�֤���ձ����� */
    private String carLoanPolicyNo = "";
    /** ����Ͷ���˴��� */
    private String appliCode = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ����Ͷ�������ʣ���Ȼ��/���ˣ� */
    private String appliNature = "";
    /** ����Ͷ�������֤�ţ���֯�������룩 */
    private String appliID = "";
    /** ����Ͷ������ż���� */
    private String appliSpouse = "";
    /** ����Ͷ������ż���֤�� */
    private String appliSpouseID = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Ա���������֯�������� */
    private String insuredID = "";
    /** ���Ե�����1���� */
    private String warrantorCode1 = "";
    /** ���Ե�����1���� */
    private String warrantorName1 = "";
    /** ���Ե�����1���֤�� */
    private String warrantorID1 = "";
    /** ���Ե�����1��ż���� */
    private String warrantorSpouse1 = "";
    /** ���Ե�����1��ż���֤�� */
    private String warrantorSpouseID1 = "";
    /** ���Ե�����2���� */
    private String warrantorCode2 = "";
    /** ���Ե�����2���� */
    private String warrantorName2 = "";
    /** ���Ե�����2���֤�� */
    private String warrantorID2 = "";
    /** ���Ե�����2��ż���� */
    private String warrantorSpouse2 = "";
    /** ���Ե�����2��ż���֤�� */
    private String warrantorSpouseID2 = "";
    /** �������������̴��� */
    private String carDealerCode = "";
    /** ������������������ */
    private String carDealerName = "";
    /** ���Դ����� */
    private double loanAmount = 0d;
    /** ���Դ������� */
    private double loanRate = 0d;
    /** ���Դ��ʼ���� */
    private DateTime loanStartDate = new DateTime();
    /** ���Դ�����ֹ���� */
    private DateTime loanEndDate = new DateTime();
    /** ���Դ������� */
    private double loanYear = 0d;
    /** �����׸����� */
    private double firstPaid = 0d;
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Գ��Ƶ�ɫ���� */
    private String licenseColorCode = "";
    /** ���Գ������� */
    private String carKindCode = "";
    /** ���Է������� */
    private String engineNo = "";
    /** ����VIN�� */
    private String vINNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Գ���ʹ�����ʴ��� */
    private String useNatureCode = "";
    /** �����³����ü� */
    private double purchasePrice = 0d;
    /** �������ŵ�����Ա������������ */
    private String creditManCode = "";
    /** �������ŵ�����Ա������������ */
    private String creditManName = "";
    /** ���Գ������� */
    private String makeCom = "";
    /** ���Թ������� */
    private String comCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ��������˴��� */
    private String approverCode = "";
    /** ����������� */
    private DateTime approveDate = new DateTime();
    /** ���������� */
    private String approveNotion = "";
    /** ���Է��ձ�־ */
    private String ventureFlag = "";
    /** ���Է���ԭ�� */
    private String ventureReason = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCreditInvestDtoBase����
     */
    public PrpCreditInvestDtoBase(){
    }

    /**
     * �������Է���Ԥ����
     * @param investigateNo �����õ����Է���Ԥ���ŵ�ֵ
     */
    public void setInvestigateNo(String investigateNo){
        this.investigateNo = StringUtils.rightTrim(investigateNo);
    }

    /**
     * ��ȡ���Է���Ԥ����
     * @return ���Է���Ԥ���ŵ�ֵ
     */
    public String getInvestigateNo(){
        return investigateNo;
    }

    /**
     * ��������ȷ�Ϻ���
     * @param confirmNo �����õ�����ȷ�Ϻ��ŵ�ֵ
     */
    public void setConfirmNo(String confirmNo){
        this.confirmNo = StringUtils.rightTrim(confirmNo);
    }

    /**
     * ��ȡ����ȷ�Ϻ���
     * @return ����ȷ�Ϻ��ŵ�ֵ
     */
    public String getConfirmNo(){
        return confirmNo;
    }

    /**
     * �������Գ��ձ�����
     * @param carPolicyNo �����õ����Գ��ձ����ŵ�ֵ
     */
    public void setCarPolicyNo(String carPolicyNo){
        this.carPolicyNo = StringUtils.rightTrim(carPolicyNo);
    }

    /**
     * ��ȡ���Գ��ձ�����
     * @return ���Գ��ձ����ŵ�ֵ
     */
    public String getCarPolicyNo(){
        return carPolicyNo;
    }

    /**
     * �������Ա�֤���ձ�����
     * @param carLoanPolicyNo �����õ����Ա�֤���ձ����ŵ�ֵ
     */
    public void setCarLoanPolicyNo(String carLoanPolicyNo){
        this.carLoanPolicyNo = StringUtils.rightTrim(carLoanPolicyNo);
    }

    /**
     * ��ȡ���Ա�֤���ձ�����
     * @return ���Ա�֤���ձ����ŵ�ֵ
     */
    public String getCarLoanPolicyNo(){
        return carLoanPolicyNo;
    }

    /**
     * ��������Ͷ���˴���
     * @param appliCode �����õ�����Ͷ���˴����ֵ
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * ��ȡ����Ͷ���˴���
     * @return ����Ͷ���˴����ֵ
     */
    public String getAppliCode(){
        return appliCode;
    }

    /**
     * ��������Ͷ��������
     * @param appliName �����õ�����Ͷ�������Ƶ�ֵ
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ�������Ƶ�ֵ
     */
    public String getAppliName(){
        return appliName;
    }

    /**
     * ��������Ͷ�������ʣ���Ȼ��/���ˣ�
     * @param appliNature �����õ�����Ͷ�������ʣ���Ȼ��/���ˣ���ֵ
     */
    public void setAppliNature(String appliNature){
        this.appliNature = StringUtils.rightTrim(appliNature);
    }

    /**
     * ��ȡ����Ͷ�������ʣ���Ȼ��/���ˣ�
     * @return ����Ͷ�������ʣ���Ȼ��/���ˣ���ֵ
     */
    public String getAppliNature(){
        return appliNature;
    }

    /**
     * ��������Ͷ�������֤�ţ���֯�������룩
     * @param appliID �����õ�����Ͷ�������֤�ţ���֯�������룩��ֵ
     */
    public void setAppliID(String appliID){
        this.appliID = StringUtils.rightTrim(appliID);
    }

    /**
     * ��ȡ����Ͷ�������֤�ţ���֯�������룩
     * @return ����Ͷ�������֤�ţ���֯�������룩��ֵ
     */
    public String getAppliID(){
        return appliID;
    }

    /**
     * ��������Ͷ������ż����
     * @param appliSpouse �����õ�����Ͷ������ż������ֵ
     */
    public void setAppliSpouse(String appliSpouse){
        this.appliSpouse = StringUtils.rightTrim(appliSpouse);
    }

    /**
     * ��ȡ����Ͷ������ż����
     * @return ����Ͷ������ż������ֵ
     */
    public String getAppliSpouse(){
        return appliSpouse;
    }

    /**
     * ��������Ͷ������ż���֤��
     * @param appliSpouseID �����õ�����Ͷ������ż���֤�ŵ�ֵ
     */
    public void setAppliSpouseID(String appliSpouseID){
        this.appliSpouseID = StringUtils.rightTrim(appliSpouseID);
    }

    /**
     * ��ȡ����Ͷ������ż���֤��
     * @return ����Ͷ������ż���֤�ŵ�ֵ
     */
    public String getAppliSpouseID(){
        return appliSpouseID;
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
     * �������Ա���������֯��������
     * @param insuredID �����õ����Ա���������֯���������ֵ
     */
    public void setInsuredID(String insuredID){
        this.insuredID = StringUtils.rightTrim(insuredID);
    }

    /**
     * ��ȡ���Ա���������֯��������
     * @return ���Ա���������֯���������ֵ
     */
    public String getInsuredID(){
        return insuredID;
    }

    /**
     * �������Ե�����1����
     * @param warrantorCode1 �����õ����Ե�����1�����ֵ
     */
    public void setWarrantorCode1(String warrantorCode1){
        this.warrantorCode1 = StringUtils.rightTrim(warrantorCode1);
    }

    /**
     * ��ȡ���Ե�����1����
     * @return ���Ե�����1�����ֵ
     */
    public String getWarrantorCode1(){
        return warrantorCode1;
    }

    /**
     * �������Ե�����1����
     * @param warrantorName1 �����õ����Ե�����1���Ƶ�ֵ
     */
    public void setWarrantorName1(String warrantorName1){
        this.warrantorName1 = StringUtils.rightTrim(warrantorName1);
    }

    /**
     * ��ȡ���Ե�����1����
     * @return ���Ե�����1���Ƶ�ֵ
     */
    public String getWarrantorName1(){
        return warrantorName1;
    }

    /**
     * �������Ե�����1���֤��
     * @param warrantorID1 �����õ����Ե�����1���֤�ŵ�ֵ
     */
    public void setWarrantorID1(String warrantorID1){
        this.warrantorID1 = StringUtils.rightTrim(warrantorID1);
    }

    /**
     * ��ȡ���Ե�����1���֤��
     * @return ���Ե�����1���֤�ŵ�ֵ
     */
    public String getWarrantorID1(){
        return warrantorID1;
    }

    /**
     * �������Ե�����1��ż����
     * @param warrantorSpouse1 �����õ����Ե�����1��ż������ֵ
     */
    public void setWarrantorSpouse1(String warrantorSpouse1){
        this.warrantorSpouse1 = StringUtils.rightTrim(warrantorSpouse1);
    }

    /**
     * ��ȡ���Ե�����1��ż����
     * @return ���Ե�����1��ż������ֵ
     */
    public String getWarrantorSpouse1(){
        return warrantorSpouse1;
    }

    /**
     * �������Ե�����1��ż���֤��
     * @param warrantorSpouseID1 �����õ����Ե�����1��ż���֤�ŵ�ֵ
     */
    public void setWarrantorSpouseID1(String warrantorSpouseID1){
        this.warrantorSpouseID1 = StringUtils.rightTrim(warrantorSpouseID1);
    }

    /**
     * ��ȡ���Ե�����1��ż���֤��
     * @return ���Ե�����1��ż���֤�ŵ�ֵ
     */
    public String getWarrantorSpouseID1(){
        return warrantorSpouseID1;
    }

    /**
     * �������Ե�����2����
     * @param warrantorCode2 �����õ����Ե�����2�����ֵ
     */
    public void setWarrantorCode2(String warrantorCode2){
        this.warrantorCode2 = StringUtils.rightTrim(warrantorCode2);
    }

    /**
     * ��ȡ���Ե�����2����
     * @return ���Ե�����2�����ֵ
     */
    public String getWarrantorCode2(){
        return warrantorCode2;
    }

    /**
     * �������Ե�����2����
     * @param warrantorName2 �����õ����Ե�����2���Ƶ�ֵ
     */
    public void setWarrantorName2(String warrantorName2){
        this.warrantorName2 = StringUtils.rightTrim(warrantorName2);
    }

    /**
     * ��ȡ���Ե�����2����
     * @return ���Ե�����2���Ƶ�ֵ
     */
    public String getWarrantorName2(){
        return warrantorName2;
    }

    /**
     * �������Ե�����2���֤��
     * @param warrantorID2 �����õ����Ե�����2���֤�ŵ�ֵ
     */
    public void setWarrantorID2(String warrantorID2){
        this.warrantorID2 = StringUtils.rightTrim(warrantorID2);
    }

    /**
     * ��ȡ���Ե�����2���֤��
     * @return ���Ե�����2���֤�ŵ�ֵ
     */
    public String getWarrantorID2(){
        return warrantorID2;
    }

    /**
     * �������Ե�����2��ż����
     * @param warrantorSpouse2 �����õ����Ե�����2��ż������ֵ
     */
    public void setWarrantorSpouse2(String warrantorSpouse2){
        this.warrantorSpouse2 = StringUtils.rightTrim(warrantorSpouse2);
    }

    /**
     * ��ȡ���Ե�����2��ż����
     * @return ���Ե�����2��ż������ֵ
     */
    public String getWarrantorSpouse2(){
        return warrantorSpouse2;
    }

    /**
     * �������Ե�����2��ż���֤��
     * @param warrantorSpouseID2 �����õ����Ե�����2��ż���֤�ŵ�ֵ
     */
    public void setWarrantorSpouseID2(String warrantorSpouseID2){
        this.warrantorSpouseID2 = StringUtils.rightTrim(warrantorSpouseID2);
    }

    /**
     * ��ȡ���Ե�����2��ż���֤��
     * @return ���Ե�����2��ż���֤�ŵ�ֵ
     */
    public String getWarrantorSpouseID2(){
        return warrantorSpouseID2;
    }

    /**
     * �����������������̴���
     * @param carDealerCode �����õ��������������̴����ֵ
     */
    public void setCarDealerCode(String carDealerCode){
        this.carDealerCode = StringUtils.rightTrim(carDealerCode);
    }

    /**
     * ��ȡ�������������̴���
     * @return �������������̴����ֵ
     */
    public String getCarDealerCode(){
        return carDealerCode;
    }

    /**
     * ����������������������
     * @param carDealerName �����õ������������������Ƶ�ֵ
     */
    public void setCarDealerName(String carDealerName){
        this.carDealerName = StringUtils.rightTrim(carDealerName);
    }

    /**
     * ��ȡ������������������
     * @return �����������������Ƶ�ֵ
     */
    public String getCarDealerName(){
        return carDealerName;
    }

    /**
     * �������Դ�����
     * @param loanAmount �����õ����Դ������ֵ
     */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ������ֵ
     */
    public double getLoanAmount(){
        return loanAmount;
    }

    /**
     * �������Դ�������
     * @param loanRate �����õ����Դ������ʵ�ֵ
     */
    public void setLoanRate(double loanRate){
        this.loanRate = loanRate;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������ʵ�ֵ
     */
    public double getLoanRate(){
        return loanRate;
    }

    /**
     * �������Դ��ʼ����
     * @param loanStartDate �����õ����Դ��ʼ���ڵ�ֵ
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * ��ȡ���Դ��ʼ����
     * @return ���Դ��ʼ���ڵ�ֵ
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * �������Դ�����ֹ����
     * @param loanEndDate �����õ����Դ�����ֹ���ڵ�ֵ
     */
    public void setLoanEndDate(DateTime loanEndDate){
        this.loanEndDate = loanEndDate;
    }

    /**
     * ��ȡ���Դ�����ֹ����
     * @return ���Դ�����ֹ���ڵ�ֵ
     */
    public DateTime getLoanEndDate(){
        return loanEndDate;
    }

    /**
     * �������Դ�������
     * @param loanYear �����õ����Դ������޵�ֵ
     */
    public void setLoanYear(double loanYear){
        this.loanYear = loanYear;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������޵�ֵ
     */
    public double getLoanYear(){
        return loanYear;
    }

    /**
     * ���������׸�����
     * @param firstPaid �����õ������׸������ֵ
     */
    public void setFirstPaid(double firstPaid){
        this.firstPaid = firstPaid;
    }

    /**
     * ��ȡ�����׸�����
     * @return �����׸������ֵ
     */
    public double getFirstPaid(){
        return firstPaid;
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
     * �������Գ�������
     * @param carKindCode �����õ����Գ��������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ��������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
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
     * ��������VIN��
     * @param vINNo �����õ�����VIN�ŵ�ֵ
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * ��ȡ����VIN��
     * @return ����VIN�ŵ�ֵ
     */
    public String getVINNo(){
        return vINNo;
    }

    /**
     * �������Գ��ܺ�
     * @param frameNo �����õ����Գ��ܺŵ�ֵ
     */
    public void setFrameNo(String frameNo){
        this.frameNo = StringUtils.rightTrim(frameNo);
    }

    /**
     * ��ȡ���Գ��ܺ�
     * @return ���Գ��ܺŵ�ֵ
     */
    public String getFrameNo(){
        return frameNo;
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
     * �������Գ���ʹ�����ʴ���
     * @param useNatureCode �����õ����Գ���ʹ�����ʴ����ֵ
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * ��ȡ���Գ���ʹ�����ʴ���
     * @return ���Գ���ʹ�����ʴ����ֵ
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * ���������³����ü�
     * @param purchasePrice �����õ������³����ü۵�ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ�����³����ü�
     * @return �����³����ü۵�ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * �����������ŵ�����Ա������������
     * @param creditManCode �����õ��������ŵ�����Ա�������������ֵ
     */
    public void setCreditManCode(String creditManCode){
        this.creditManCode = StringUtils.rightTrim(creditManCode);
    }

    /**
     * ��ȡ�������ŵ�����Ա������������
     * @return �������ŵ�����Ա�������������ֵ
     */
    public String getCreditManCode(){
        return creditManCode;
    }

    /**
     * �����������ŵ�����Ա������������
     * @param creditManName �����õ��������ŵ�����Ա�����������Ƶ�ֵ
     */
    public void setCreditManName(String creditManName){
        this.creditManName = StringUtils.rightTrim(creditManName);
    }

    /**
     * ��ȡ�������ŵ�����Ա������������
     * @return �������ŵ�����Ա�����������Ƶ�ֵ
     */
    public String getCreditManName(){
        return creditManName;
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
     * �������Թ�������
     * @param comCode �����õ����Թ���������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ���������ֵ
     */
    public String getComCode(){
        return comCode;
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
     * ������������˴���
     * @param approverCode �����õ���������˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ��������˴���
     * @return ��������˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * ���������������
     * @param approveDate �����õ�����������ڵ�ֵ
     */
    public void setApproveDate(DateTime approveDate){
        this.approveDate = approveDate;
    }

    /**
     * ��ȡ�����������
     * @return ����������ڵ�ֵ
     */
    public DateTime getApproveDate(){
        return approveDate;
    }

    /**
     * ��������������
     * @param approveNotion �����õ�������������ֵ
     */
    public void setApproveNotion(String approveNotion){
        this.approveNotion = StringUtils.rightTrim(approveNotion);
    }

    /**
     * ��ȡ����������
     * @return ������������ֵ
     */
    public String getApproveNotion(){
        return approveNotion;
    }

    /**
     * �������Է��ձ�־
     * @param ventureFlag �����õ����Է��ձ�־��ֵ
     */
    public void setVentureFlag(String ventureFlag){
        this.ventureFlag = StringUtils.rightTrim(ventureFlag);
    }

    /**
     * ��ȡ���Է��ձ�־
     * @return ���Է��ձ�־��ֵ
     */
    public String getVentureFlag(){
        return ventureFlag;
    }

    /**
     * �������Է���ԭ��
     * @param ventureReason �����õ����Է���ԭ���ֵ
     */
    public void setVentureReason(String ventureReason){
        this.ventureReason = StringUtils.rightTrim(ventureReason);
    }

    /**
     * ��ȡ���Է���ԭ��
     * @return ���Է���ԭ���ֵ
     */
    public String getVentureReason(){
        return ventureReason;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
