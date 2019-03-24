package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ӧ��Ӧ������Ϣ������ݴ���������<br>
 */
public class PrpJplanFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ҵ������ */
    private String certiType = "";
    /** ���Ա�������/�������� */
    private String certiNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Խ��Ѽƻ���� */
    private int serialNo = 0;
    /** �����ո�ԭ�� */
    private String payRefReason = "";
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String classCode = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ժ�ͬ�� */
    private String contractNo = "";
    /** ����Ͷ���� */
    private String appliCode = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ���Ա������� */
    private String insuredCode = "";
    /** ���Ա��������� */
    private String insuredName = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** ����������Ч���� */
    private DateTime validDate = new DateTime();
    /** ���Խɷ����� */
    private int payNo = 0;
    /** ����Ӧ�ձ��� */
    private String currency1 = "";
    /** ����Ӧ��Ӧ����� */
    private double planFee = 0D;
    /** ���Է��ڽɷ����� */
    private DateTime planDate = new DateTime();
    /** ���Թ������� */
    private String comCode = "";
    /** ���Գ������� */
    private String makeCom = "";
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ����ҵ�������Ա */
    private String handler1Code = "";
    /** ���Ծ����� */
    private String handlerCode = "";
    /** ���Ժ˱�/������ */
    private DateTime underWriteDate = new DateTime();
    /** ������������־ */
    private String coinsFlag = "";
    /** �����������˴��� */
    private String coinsCode = "";
    /** ���������������� */
    private String coinsName = "";
    /** �������������� */
    private String coinsType = "";
    /** ���Ժ��㵥λ */
    private String centerCode = "";
    /** ���Ի��㵥λ */
    private String branchCode = "";
    /** ������������ */
    private String accBookType = "";
    /** �������״��� */
    private String accBookCode = "";
    /** ���Ի���ڼ� */
    private String yearMonth = "";
    /** ����ƾ֤�� */
    private String voucherNo = "";
    /** ����Ӧ��/Ӧ������ */
    private double exchangeRate = 0D;
    /** ����Ӧ��/Ӧ�����ʽ�� */
    private double planFeeCNY = 0D;
    /** ��������/Ӧ����� */
    private double payRefFee = 0D;
    /** ��������/Ӧ��ȷ�Ͻ�� */
    private double realPayRefFee = 0D;
    /** ����Ԥ����־ */
    private String flag = "";
    /** ����ҵ������ */
    private String businessNature = "";
    /** ����ҵ���־ */
    private String othFlag = "";
    /** ���Խ�ǿ�ճ����Ŵ����� */
    private String carNatureCode = "";
    /** ���Խ�ǿ�վŴ���ʹ������ */
    private String useNatureCode = "";
    /** ���Խ�ǿ�վŴ��೵������ */
    private double carProperty = 0D;
    private String payComCode = "";
    private String businessType = "";
    private String businessType1 = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJplanFeeDtoBase����
     */
    public PrpJplanFeeDtoBase(){
    }

    /**
     * ��������ҵ������
     * @param certiType �����õ�����ҵ�����͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Ա�������/��������
     * @param certiNo �����õ����Ա�������/���������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ա�������/��������
     * @return ���Ա�������/���������ֵ
     */
    public String getCertiNo(){
        return certiNo;
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
     * �������Խ��Ѽƻ����
     * @param serialNo �����õ����Խ��Ѽƻ���ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Խ��Ѽƻ����
     * @return ���Խ��Ѽƻ���ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������ո�ԭ��
     * @param payRefReason �����õ������ո�ԭ���ֵ
     */
    public void setPayRefReason(String payRefReason){
        this.payRefReason = StringUtils.rightTrim(payRefReason);
    }

    /**
     * ��ȡ�����ո�ԭ��
     * @return �����ո�ԭ���ֵ
     */
    public String getPayRefReason(){
        return payRefReason;
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
     * @param classCode �����õ����������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getClassCode(){
        return classCode;
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
     * �������Ժ�ͬ��
     * @param contractNo �����õ����Ժ�ͬ�ŵ�ֵ
     */
    public void setContractNo(String contractNo){
        this.contractNo = StringUtils.rightTrim(contractNo);
    }

    /**
     * ��ȡ���Ժ�ͬ��
     * @return ���Ժ�ͬ�ŵ�ֵ
     */
    public String getContractNo(){
        return contractNo;
    }

    /**
     * ��������Ͷ����
     * @param appliCode �����õ�����Ͷ���˵�ֵ
     */
    public void setAppliCode(String appliCode){
        this.appliCode = StringUtils.rightTrim(appliCode);
    }

    /**
     * ��ȡ����Ͷ����
     * @return ����Ͷ���˵�ֵ
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
     * �������Ա�������
     * @param insuredCode �����õ����Ա������˵�ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������˵�ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա���������
     * @param insuredName �����õ����Ա��������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա��������Ƶ�ֵ
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
     * ��������������Ч����
     * @param validDate �����õ�����������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ����������Ч����
     * @return ����������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * �������Խɷ�����
     * @param payNo �����õ����Խɷ�������ֵ
     */
    public void setPayNo(int payNo){
        this.payNo = payNo;
    }

    /**
     * ��ȡ���Խɷ�����
     * @return ���Խɷ�������ֵ
     */
    public int getPayNo(){
        return payNo;
    }

    /**
     * ��������Ӧ�ձ���
     * @param currency1 �����õ�����Ӧ�ձ��ֵ�ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ����Ӧ�ձ���
     * @return ����Ӧ�ձ��ֵ�ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ��������Ӧ��Ӧ�����
     * @param planFee �����õ�����Ӧ��Ӧ������ֵ
     */
    public void setPlanFee(double planFee){
        this.planFee = planFee;
    }

    /**
     * ��ȡ����Ӧ��Ӧ�����
     * @return ����Ӧ��Ӧ������ֵ
     */
    public double getPlanFee(){
        return planFee;
    }

    /**
     * �������Է��ڽɷ�����
     * @param planDate �����õ����Է��ڽɷ����ڵ�ֵ
     */
    public void setPlanDate(DateTime planDate){
        this.planDate = planDate;
    }

    /**
     * ��ȡ���Է��ڽɷ�����
     * @return ���Է��ڽɷ����ڵ�ֵ
     */
    public DateTime getPlanDate(){
        return planDate;
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
     * ��������ҵ�������Ա
     * @param handler1Code �����õ�����ҵ�������Ա��ֵ
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * ��ȡ����ҵ�������Ա
     * @return ����ҵ�������Ա��ֵ
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * �������Ծ�����
     * @param handlerCode �����õ����Ծ����˵�ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ�����
     * @return ���Ծ����˵�ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Ժ˱�/������
     * @param underWriteDate �����õ����Ժ˱�/�����ڵ�ֵ
     */
    public void setUnderWriteDate(DateTime underWriteDate){
        this.underWriteDate = underWriteDate;
    }

    /**
     * ��ȡ���Ժ˱�/������
     * @return ���Ժ˱�/�����ڵ�ֵ
     */
    public DateTime getUnderWriteDate(){
        return underWriteDate;
    }

    /**
     * ����������������־
     * @param coinsFlag �����õ�������������־��ֵ
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = StringUtils.rightTrim(coinsFlag);
    }

    /**
     * ��ȡ������������־
     * @return ������������־��ֵ
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }

    /**
     * ���������������˴���
     * @param coinsCode �����õ������������˴����ֵ
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * ��ȡ�����������˴���
     * @return �����������˴����ֵ
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * ��������������������
     * @param coinsName �����õ����������������Ƶ�ֵ
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * ������������������
     * @param coinsType �����õ��������������͵�ֵ
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * ��ȡ��������������
     * @return �������������͵�ֵ
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * �������Ժ��㵥λ
     * @param centerCode �����õ����Ժ��㵥λ��ֵ
     */
    public void setCenterCode(String centerCode){
        this.centerCode = StringUtils.rightTrim(centerCode);
    }

    /**
     * ��ȡ���Ժ��㵥λ
     * @return ���Ժ��㵥λ��ֵ
     */
    public String getCenterCode(){
        return centerCode;
    }

    /**
     * �������Ի��㵥λ
     * @param branchCode �����õ����Ի��㵥λ��ֵ
     */
    public void setBranchCode(String branchCode){
        this.branchCode = StringUtils.rightTrim(branchCode);
    }

    /**
     * ��ȡ���Ի��㵥λ
     * @return ���Ի��㵥λ��ֵ
     */
    public String getBranchCode(){
        return branchCode;
    }

    /**
     * ����������������
     * @param accBookType �����õ������������͵�ֵ
     */
    public void setAccBookType(String accBookType){
        this.accBookType = StringUtils.rightTrim(accBookType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getAccBookType(){
        return accBookType;
    }

    /**
     * �����������״���
     * @param accBookCode �����õ��������״����ֵ
     */
    public void setAccBookCode(String accBookCode){
        this.accBookCode = StringUtils.rightTrim(accBookCode);
    }

    /**
     * ��ȡ�������״���
     * @return �������״����ֵ
     */
    public String getAccBookCode(){
        return accBookCode;
    }

    /**
     * �������Ի���ڼ�
     * @param yearMonth �����õ����Ի���ڼ��ֵ
     */
    public void setYearMonth(String yearMonth){
        this.yearMonth = StringUtils.rightTrim(yearMonth);
    }

    /**
     * ��ȡ���Ի���ڼ�
     * @return ���Ի���ڼ��ֵ
     */
    public String getYearMonth(){
        return yearMonth;
    }

    /**
     * ��������ƾ֤��
     * @param voucherNo �����õ�����ƾ֤�ŵ�ֵ
     */
    public void setVoucherNo(String voucherNo){
        this.voucherNo = StringUtils.rightTrim(voucherNo);
    }

    /**
     * ��ȡ����ƾ֤��
     * @return ����ƾ֤�ŵ�ֵ
     */
    public String getVoucherNo(){
        return voucherNo;
    }

    /**
     * ��������Ӧ��/Ӧ������
     * @param exchangeRate �����õ�����Ӧ��/Ӧ�����ʵ�ֵ
     */
    public void setExchangeRate(double exchangeRate){
        this.exchangeRate = exchangeRate;
    }

    /**
     * ��ȡ����Ӧ��/Ӧ������
     * @return ����Ӧ��/Ӧ�����ʵ�ֵ
     */
    public double getExchangeRate(){
        return exchangeRate;
    }

    /**
     * ��������Ӧ��/Ӧ�����ʽ��
     * @param planFeeCNY �����õ�����Ӧ��/Ӧ�����ʽ���ֵ
     */
    public void setPlanFeeCNY(double planFeeCNY){
        this.planFeeCNY = planFeeCNY;
    }

    /**
     * ��ȡ����Ӧ��/Ӧ�����ʽ��
     * @return ����Ӧ��/Ӧ�����ʽ���ֵ
     */
    public double getPlanFeeCNY(){
        return planFeeCNY;
    }

    /**
     * ������������/Ӧ�����
     * @param payRefFee �����õ���������/Ӧ������ֵ
     */
    public void setPayRefFee(double payRefFee){
        this.payRefFee = payRefFee;
    }

    /**
     * ��ȡ��������/Ӧ�����
     * @return ��������/Ӧ������ֵ
     */
    public double getPayRefFee(){
        return payRefFee;
    }

    /**
     * ������������/Ӧ��ȷ�Ͻ��
     * @param realPayRefFee �����õ���������/Ӧ��ȷ�Ͻ���ֵ
     */
    public void setRealPayRefFee(double realPayRefFee){
        this.realPayRefFee = realPayRefFee;
    }

    /**
     * ��ȡ��������/Ӧ��ȷ�Ͻ��
     * @return ��������/Ӧ��ȷ�Ͻ���ֵ
     */
    public double getRealPayRefFee(){
        return realPayRefFee;
    }

    /**
     * ��������Ԥ����־
     * @param flag �����õ�����Ԥ����־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Ԥ����־
     * @return ����Ԥ����־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������ҵ������
     * @param businessNautre �����õ�����ҵ��������ֵ
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ��������ֵ
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * ��������ҵ���־
     * @param othFlag �����õ�����ҵ���־��ֵ
     */
    public void setOthFlag(String othFlag){
        this.othFlag = StringUtils.rightTrim(othFlag);
    }

    /**
     * ��ȡ����ҵ���־
     * @return ����ҵ���־��ֵ
     */
    public String getOthFlag(){
        return othFlag;
    }

    /**
     * �������Խ�ǿ�ճ����Ŵ�����
     * @param carNatureCode �����õ����Խ�ǿ�ճ����Ŵ������ֵ
     */
    public void setCarNatureCode(String carNatureCode){
        this.carNatureCode = StringUtils.rightTrim(carNatureCode);
    }

    /**
     * ��ȡ���Խ�ǿ�ճ����Ŵ�����
     * @return ���Խ�ǿ�ճ����Ŵ������ֵ
     */
    public String getCarNatureCode(){
        return carNatureCode;
    }

    /**
     * �������Խ�ǿ�վŴ���ʹ������
     * @param useNatureCode �����õ����Խ�ǿ�վŴ���ʹ�����ʵ�ֵ
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * ��ȡ���Խ�ǿ�վŴ���ʹ������
     * @return ���Խ�ǿ�վŴ���ʹ�����ʵ�ֵ
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * �������Խ�ǿ�վŴ��೵������
     * @param carProperty �����õ����Խ�ǿ�վŴ��೵�����Ե�ֵ
     */
    public void setCarProperty(double carProperty){
        this.carProperty = carProperty;
    }

    /**
     * ��ȡ���Խ�ǿ�վŴ��೵������
     * @return ���Խ�ǿ�վŴ��೵�����Ե�ֵ
     */
    public double getCarProperty(){
        return carProperty;
    }

	public String getPayComCode() {
		return payComCode;
	}

	public void setPayComCode(String payComCode) {
		this.payComCode = payComCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	

}
