package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLinvestigate-���������Ϣ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLinvestigateDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ե����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.������� */
    private String objectType = "";
    /** ���Ա����������� */
    private String informantName = "";
    /** ���Ա���������� */
    private String informantStatus = "";
    /** ���Ե���������� */
    private String objectName = "";
    /** ���Ե������λ */
    private String objectUnit = "";
    /** ���Ե�������ַ */
    private String objectAddress = "";
    /** ���Ե������绰 */
    private String objectPhone = "";
    /** ���Ե������������ */
    private double yearIncome = 0d;
    /** ���Ե���������֤���� */
    private String identifyNumber = "";
    /** ���Ե������Ӫҵִ�պ��� */
    private String businessCode = "";
    /** ���Դ����� */
    private double loanAmount = 0d;
    /** ���Ի����� */
    private double sumRePaid = 0d;
    /** ������Ƿ��� */
    private double arrearageCorpus = 0d;
    /** ������󻹿����� */
    private DateTime lastRepaidDate = new DateTime();
    /** ����Ƿ��ʱ�� */
    private DateTime arrearageDate = new DateTime();
    /** �������պ��� */
    private String licenseNo = "";
    /** ���Գ����ͺ� */
    private String brandName = "";
    /** ���Գ����۸� */
    private double purchasePrice = 0d;
    /** ���Է������� */
    private String engineNo = "";
    /** ���Գ��ܺ� */
    private String frameNo = "";
    /** ���Գ�����; */
    private String useNature = "";
    /** ���Թ������� */
    private DateTime purchaseDate = new DateTime();
    /** ���Գ��εǼ����� */
    private DateTime enrollDate = new DateTime();
    /** ���Ե�Ѻ�Ǽǵ�λ */
    private String inpawnEnrollDept = "";
    /** ���Ե�Ѻ�Ǽ����� */
    private DateTime inpawnEnrollDate = new DateTime();
    /** ���Ե�Ѻ������ */
    private String guarantyName = "";
    /** ���Ե�Ѻ���Ƿ��ջ�(Y/N) */
    private String guarantyRetractFlg = "";
    /** ���Ե�Ѻ����� */
    private double guarantyAssessment = 0d;
    /** �����۳�����ȡ��ʽ--** 1.һ������ȡ
--** 2.���д��� */
    private String gatheringWay = "";
    /** ����Ƿ��ԭ����� */
    private String arrearReasonCode = "";
    /** ����Ƿ��ԭ�� */
    private String arrearReasonName = "";
    /** ���Ե������ */
    private String remark = "";
    /** ���Ե������ */
    private String conclution = "";
    /** ���Ե����� */
    private String investigator = "";
    /** ���Ե���ʱ�� */
    private DateTime investigateDate = new DateTime();
    /** ���Ա�� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinvestigateDtoBase����
     */
    public PrpLinvestigateDtoBase(){
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
     * �������Ե����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @param objectType �����õ����Ե����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.������۵�ֵ
     */
    public void setObjectType(String objectType){
        this.objectType = StringUtils.rightTrim(objectType);
    }

    /**
     * ��ȡ���Ե����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.�������
     * @return ���Ե����������
--** 1.������
--** 2.������
--** 3.�����
--** 4.������
--** 5.�۳���
--** 6.������
--** 7.������۵�ֵ
     */
    public String getObjectType(){
        return objectType;
    }

    /**
     * �������Ա�����������
     * @param informantName �����õ����Ա�������������ֵ
     */
    public void setInformantName(String informantName){
        this.informantName = StringUtils.rightTrim(informantName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա�������������ֵ
     */
    public String getInformantName(){
        return informantName;
    }

    /**
     * �������Ա����������
     * @param informantStatus �����õ����Ա���������ݵ�ֵ
     */
    public void setInformantStatus(String informantStatus){
        this.informantStatus = StringUtils.rightTrim(informantStatus);
    }

    /**
     * ��ȡ���Ա����������
     * @return ���Ա���������ݵ�ֵ
     */
    public String getInformantStatus(){
        return informantStatus;
    }

    /**
     * �������Ե����������
     * @param objectName �����õ����Ե���������Ƶ�ֵ
     */
    public void setObjectName(String objectName){
        this.objectName = StringUtils.rightTrim(objectName);
    }

    /**
     * ��ȡ���Ե����������
     * @return ���Ե���������Ƶ�ֵ
     */
    public String getObjectName(){
        return objectName;
    }

    /**
     * �������Ե������λ
     * @param objectUnit �����õ����Ե������λ��ֵ
     */
    public void setObjectUnit(String objectUnit){
        this.objectUnit = StringUtils.rightTrim(objectUnit);
    }

    /**
     * ��ȡ���Ե������λ
     * @return ���Ե������λ��ֵ
     */
    public String getObjectUnit(){
        return objectUnit;
    }

    /**
     * �������Ե�������ַ
     * @param objectAddress �����õ����Ե�������ַ��ֵ
     */
    public void setObjectAddress(String objectAddress){
        this.objectAddress = StringUtils.rightTrim(objectAddress);
    }

    /**
     * ��ȡ���Ե�������ַ
     * @return ���Ե�������ַ��ֵ
     */
    public String getObjectAddress(){
        return objectAddress;
    }

    /**
     * �������Ե������绰
     * @param objectPhone �����õ����Ե������绰��ֵ
     */
    public void setObjectPhone(String objectPhone){
        this.objectPhone = StringUtils.rightTrim(objectPhone);
    }

    /**
     * ��ȡ���Ե������绰
     * @return ���Ե������绰��ֵ
     */
    public String getObjectPhone(){
        return objectPhone;
    }

    /**
     * �������Ե������������
     * @param yearIncome �����õ����Ե�������������ֵ
     */
    public void setYearIncome(double yearIncome){
        this.yearIncome = yearIncome;
    }

    /**
     * ��ȡ���Ե������������
     * @return ���Ե�������������ֵ
     */
    public double getYearIncome(){
        return yearIncome;
    }

    /**
     * �������Ե���������֤����
     * @param identifyNumber �����õ����Ե���������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ���Ե���������֤����
     * @return ���Ե���������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * �������Ե������Ӫҵִ�պ���
     * @param businessCode �����õ����Ե������Ӫҵִ�պ����ֵ
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * ��ȡ���Ե������Ӫҵִ�պ���
     * @return ���Ե������Ӫҵִ�պ����ֵ
     */
    public String getBusinessCode(){
        return businessCode;
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
     * �������Ի�����
     * @param sumRePaid �����õ����Ի������ֵ
     */
    public void setSumRePaid(double sumRePaid){
        this.sumRePaid = sumRePaid;
    }

    /**
     * ��ȡ���Ի�����
     * @return ���Ի������ֵ
     */
    public double getSumRePaid(){
        return sumRePaid;
    }

    /**
     * ����������Ƿ���
     * @param arrearageCorpus �����õ�������Ƿ����ֵ
     */
    public void setArrearageCorpus(double arrearageCorpus){
        this.arrearageCorpus = arrearageCorpus;
    }

    /**
     * ��ȡ������Ƿ���
     * @return ������Ƿ����ֵ
     */
    public double getArrearageCorpus(){
        return arrearageCorpus;
    }

    /**
     * ����������󻹿�����
     * @param lastRepaidDate �����õ�������󻹿����ڵ�ֵ
     */
    public void setLastRepaidDate(DateTime lastRepaidDate){
        this.lastRepaidDate = lastRepaidDate;
    }

    /**
     * ��ȡ������󻹿�����
     * @return ������󻹿����ڵ�ֵ
     */
    public DateTime getLastRepaidDate(){
        return lastRepaidDate;
    }

    /**
     * ��������Ƿ��ʱ��
     * @param arrearageDate �����õ�����Ƿ��ʱ���ֵ
     */
    public void setArrearageDate(DateTime arrearageDate){
        this.arrearageDate = arrearageDate;
    }

    /**
     * ��ȡ����Ƿ��ʱ��
     * @return ����Ƿ��ʱ���ֵ
     */
    public DateTime getArrearageDate(){
        return arrearageDate;
    }

    /**
     * �����������պ���
     * @param licenseNo �����õ��������պ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ�������պ���
     * @return �������պ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
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
     * �������Գ����۸�
     * @param purchasePrice �����õ����Գ����۸��ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ���Գ����۸�
     * @return ���Գ����۸��ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
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
     * �������Գ�����;
     * @param useNature �����õ����Գ�����;��ֵ
     */
    public void setUseNature(String useNature){
        this.useNature = StringUtils.rightTrim(useNature);
    }

    /**
     * ��ȡ���Գ�����;
     * @return ���Գ�����;��ֵ
     */
    public String getUseNature(){
        return useNature;
    }

    /**
     * �������Թ�������
     * @param purchaseDate �����õ����Թ������ڵ�ֵ
     */
    public void setPurchaseDate(DateTime purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������ڵ�ֵ
     */
    public DateTime getPurchaseDate(){
        return purchaseDate;
    }

    /**
     * �������Գ��εǼ�����
     * @param enrollDate �����õ����Գ��εǼ����ڵ�ֵ
     */
    public void setEnrollDate(DateTime enrollDate){
        this.enrollDate = enrollDate;
    }

    /**
     * ��ȡ���Գ��εǼ�����
     * @return ���Գ��εǼ����ڵ�ֵ
     */
    public DateTime getEnrollDate(){
        return enrollDate;
    }

    /**
     * �������Ե�Ѻ�Ǽǵ�λ
     * @param inpawnEnrollDept �����õ����Ե�Ѻ�Ǽǵ�λ��ֵ
     */
    public void setInpawnEnrollDept(String inpawnEnrollDept){
        this.inpawnEnrollDept = StringUtils.rightTrim(inpawnEnrollDept);
    }

    /**
     * ��ȡ���Ե�Ѻ�Ǽǵ�λ
     * @return ���Ե�Ѻ�Ǽǵ�λ��ֵ
     */
    public String getInpawnEnrollDept(){
        return inpawnEnrollDept;
    }

    /**
     * �������Ե�Ѻ�Ǽ�����
     * @param inpawnEnrollDate �����õ����Ե�Ѻ�Ǽ����ڵ�ֵ
     */
    public void setInpawnEnrollDate(DateTime inpawnEnrollDate){
        this.inpawnEnrollDate = inpawnEnrollDate;
    }

    /**
     * ��ȡ���Ե�Ѻ�Ǽ�����
     * @return ���Ե�Ѻ�Ǽ����ڵ�ֵ
     */
    public DateTime getInpawnEnrollDate(){
        return inpawnEnrollDate;
    }

    /**
     * �������Ե�Ѻ������
     * @param guarantyName �����õ����Ե�Ѻ�����Ƶ�ֵ
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * ��ȡ���Ե�Ѻ������
     * @return ���Ե�Ѻ�����Ƶ�ֵ
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * �������Ե�Ѻ���Ƿ��ջ�(Y/N)
     * @param guarantyRetractFlg �����õ����Ե�Ѻ���Ƿ��ջ�(Y/N)��ֵ
     */
    public void setGuarantyRetractFlg(String guarantyRetractFlg){
        this.guarantyRetractFlg = StringUtils.rightTrim(guarantyRetractFlg);
    }

    /**
     * ��ȡ���Ե�Ѻ���Ƿ��ջ�(Y/N)
     * @return ���Ե�Ѻ���Ƿ��ջ�(Y/N)��ֵ
     */
    public String getGuarantyRetractFlg(){
        return guarantyRetractFlg;
    }

    /**
     * �������Ե�Ѻ�����
     * @param guarantyAssessment �����õ����Ե�Ѻ����۵�ֵ
     */
    public void setGuarantyAssessment(double guarantyAssessment){
        this.guarantyAssessment = guarantyAssessment;
    }

    /**
     * ��ȡ���Ե�Ѻ�����
     * @return ���Ե�Ѻ����۵�ֵ
     */
    public double getGuarantyAssessment(){
        return guarantyAssessment;
    }

    /**
     * ���������۳�����ȡ��ʽ--** 1.һ������ȡ
--** 2.���д���
     * @param gatheringWay �����õ������۳�����ȡ��ʽ--** 1.һ������ȡ
--** 2.���д��յ�ֵ
     */
    public void setGatheringWay(String gatheringWay){
        this.gatheringWay = StringUtils.rightTrim(gatheringWay);
    }

    /**
     * ��ȡ�����۳�����ȡ��ʽ--** 1.һ������ȡ
--** 2.���д���
     * @return �����۳�����ȡ��ʽ--** 1.һ������ȡ
--** 2.���д��յ�ֵ
     */
    public String getGatheringWay(){
        return gatheringWay;
    }

    /**
     * ��������Ƿ��ԭ�����
     * @param arrearReasonCode �����õ�����Ƿ��ԭ������ֵ
     */
    public void setArrearReasonCode(String arrearReasonCode){
        this.arrearReasonCode = StringUtils.rightTrim(arrearReasonCode);
    }

    /**
     * ��ȡ����Ƿ��ԭ�����
     * @return ����Ƿ��ԭ������ֵ
     */
    public String getArrearReasonCode(){
        return arrearReasonCode;
    }

    /**
     * ��������Ƿ��ԭ��
     * @param arrearReasonName �����õ�����Ƿ��ԭ���ֵ
     */
    public void setArrearReasonName(String arrearReasonName){
        this.arrearReasonName = StringUtils.rightTrim(arrearReasonName);
    }

    /**
     * ��ȡ����Ƿ��ԭ��
     * @return ����Ƿ��ԭ���ֵ
     */
    public String getArrearReasonName(){
        return arrearReasonName;
    }

    /**
     * �������Ե������
     * @param remark �����õ����Ե��������ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ե������
     * @return ���Ե��������ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * �������Ե������
     * @param conclution �����õ����Ե�����۵�ֵ
     */
    public void setConclution(String conclution){
        this.conclution = StringUtils.rightTrim(conclution);
    }

    /**
     * ��ȡ���Ե������
     * @return ���Ե�����۵�ֵ
     */
    public String getConclution(){
        return conclution;
    }

    /**
     * �������Ե�����
     * @param investigator �����õ����Ե����ߵ�ֵ
     */
    public void setInvestigator(String investigator){
        this.investigator = StringUtils.rightTrim(investigator);
    }

    /**
     * ��ȡ���Ե�����
     * @return ���Ե����ߵ�ֵ
     */
    public String getInvestigator(){
        return investigator;
    }

    /**
     * �������Ե���ʱ��
     * @param investigateDate �����õ����Ե���ʱ���ֵ
     */
    public void setInvestigateDate(DateTime investigateDate){
        this.investigateDate = investigateDate;
    }

    /**
     * ��ȡ���Ե���ʱ��
     * @return ���Ե���ʱ���ֵ
     */
    public DateTime getInvestigateDate(){
        return investigateDate;
    }

    /**
     * �������Ա��
     * @param flag �����õ����Ա�ǵ�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ǵ�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
