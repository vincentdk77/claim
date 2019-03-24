package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prppmain���ı�����Ϣ������ݴ���������<br>
 * ������ 2004-11-22 15:24:12.703<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPmainDtoBase implements Serializable{
    /** ������������ */
    private String endorseNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ����Ͷ������ */
    private String proposalNo = "";
    /** ���Ժ�ͬ�� */
    private String contractNo = "";
    /** ���Ա������� */
    private String policySort = "";
    /** ���Ա���ӡˢ�� */
    private String printNo = "";
    /** ����ҵ����Դ */
    private String businessNature = "";
    /** �������ֱ�־ */
    private String language = "";
    /** ���Ա������� */
    private String policyType = "";
    
    
    //modified by zengzhu 2007-11-15 begin reason��ͳ���õı���ũ�ձ�־����Ϊ�������һ������ҵ�������ֶ� PolicyBizType
    //��01��������ũҵ�ա�02����ҵ��ũҵ�ա�03����ũ�ա�04����ũ�գ�
    private String policyBizType = "";
    //modified by zengzhu 2007-11-15 end
    
    /** ����Ͷ���˴��� */
    private String appliCode = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ����Ͷ���˵�ַ */
    private String appliAddress = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Ա������˵�ַ */
    private String insuredAddress = "";
    /** ����ǩ������ */
    private DateTime operateDate = new DateTime();
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** ������Сʱ */
    private int startHour = 0;
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** �����ձ�Сʱ */
    private int endHour = 0;
    /** ���Ծ����� */
    private double pureRate = 0d;
    /** ������������/�������� */
    private double disRate = 0d;
    /** �������ۿ��� */
    private double discount = 0d;
    /** ���Աұ���� */
    private String currency = "";
    /** �����ܱ��ռ�ֵ */
    private double sumValue = 0d;
    /** �����ܱ��� */
    private double sumAmount = 0d;
    /** �������ۿ۽�� */
    private double sumDiscount = 0d;
    /** �����ܱ��շ� */
    private double sumPremium = 0d;
    /** �����ܸ����ձ��� */
    private double sumSubPrem = 0d;
    /** ����ѹ���������� */
    private int sumQuantity = 0;
    /** ����˾����Ͻ */
    private String judicalScope = "";
    /** �����Ƿ��Զ�ת��������־ */
    private String autoTransRenewFlag = "";
    /** ������������ʽ */
    private String argueSolution = "";
    /** �����ٲ�ίԱ������ */
    private String arbitBoardName = "";
    /** ����Լ�����ڽ��Ѵ��� */
    private int payTimes = 0;
    /** �������Ĵ��� */
    private int endorseTimes = 0;
    /** ����������� */
    private int claimTimes = 0;
    /** ���Գ������� */
    private String makeCom = "";
    /** ����ǩ���ص� */
    private String operateSite = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** �������պ˱��˴��� */
    private String underWriteCode = "";
    /** �������պ˱������� */
    private String underWriteName = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Լ�����䵥Сʱ */
    private int inputHour = 0;
    /** ���Ժ˱�������� */
    private DateTime underWriteEndDate = new DateTime();
    /** ���Ա���ͳ������ */
    private DateTime statisticsYM = new DateTime();
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ���Թ�����־ */
    private String coinsFlag = "";
    /** ������ҵ�ֱ���־ */
    private String reinsFlag = "";
    /** ����ͳ����־ */
    private String allinsFlag = "";
    /** ���Ժ˱���־ */
    private String underWriteFlag = "";
    /** ����������־�ֶ� */
    private String othFlag = "";
    /** ����״̬�ֶ� */
    private String flag = "";
    /** ���Ա仯���ս��(����Ϊ����ұ���) */
    private double chgAmount = 0d;
    /** ����chgpremium */
    private double chgPremium = 0d;
    /** ����chgsubprem */
    private double chgSubPrem = 0d;
    /** ����chgquantity */
    private int chgQuantity = 0;
    /** ����statquantity */
    private double statQuantity=0;
    /** ����chgstatquantity */
    private double chgStatquantity=0;
    
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPmainDtoBase����
     */
    public PrpPmainDtoBase(){
    }

    /**
     * ����������������
     * @param endorseNo �����õ��������������ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
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
     * ��������Ͷ������
     * @param proposalNo �����õ�����Ͷ�����ŵ�ֵ
     */
    public void setProposalNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * ��ȡ����Ͷ������
     * @return ����Ͷ�����ŵ�ֵ
     */
    public String getProposalNo(){
        return proposalNo;
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
     * �������Ա�������
     * @param policySort �����õ����Ա��������ֵ
     */
    public void setPolicySort(String policySort){
        this.policySort = StringUtils.rightTrim(policySort);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicySort(){
        return policySort;
    }

    /**
     * �������Ա���ӡˢ��
     * @param printNo �����õ����Ա���ӡˢ�ŵ�ֵ
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * ��ȡ���Ա���ӡˢ��
     * @return ���Ա���ӡˢ�ŵ�ֵ
     */
    public String getPrintNo(){
        return printNo;
    }

    /**
     * ��������ҵ����Դ
     * @param businessNature �����õ�����ҵ����Դ��ֵ
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = StringUtils.rightTrim(businessNature);
    }

    /**
     * ��ȡ����ҵ����Դ
     * @return ����ҵ����Դ��ֵ
     */
    public String getBusinessNature(){
        return businessNature;
    }

    /**
     * �����������ֱ�־
     * @param language �����õ��������ֱ�־��ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ�������ֱ�־
     * @return �������ֱ�־��ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * �������Ա�������
     * @param policyType �����õ����Ա������͵�ֵ
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������͵�ֵ
     */
    public String getPolicyType(){
        return policyType;
    }
    
    //modified by zengzhu 2007-11-15 begin reason��ͳ���õı���ũ�ձ�־����Ϊ�������һ������ҵ�������ֶ� PolicyBizType
    public String getPolicyBizType() {
		return policyBizType;
	}

	public void setPolicyBizType(String policyBizType) {
		this.policyBizType = policyBizType;
	}
	//modified by zengzhu 2007-11-15 end


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
     * ��������Ͷ���˵�ַ
     * @param appliAddress �����õ�����Ͷ���˵�ַ��ֵ
     */
    public void setAppliAddress(String appliAddress){
        this.appliAddress = StringUtils.rightTrim(appliAddress);
    }

    /**
     * ��ȡ����Ͷ���˵�ַ
     * @return ����Ͷ���˵�ַ��ֵ
     */
    public String getAppliAddress(){
        return appliAddress;
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
     * �������Ա������˵�ַ
     * @param insuredAddress �����õ����Ա������˵�ַ��ֵ
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * ��ȡ���Ա������˵�ַ
     * @return ���Ա������˵�ַ��ֵ
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * ��������ǩ������
     * @param operateDate �����õ�����ǩ�����ڵ�ֵ
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ����ǩ������
     * @return ����ǩ�����ڵ�ֵ
     */
    public DateTime getOperateDate(){
        return operateDate;
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
     * ����������Сʱ
     * @param startHour �����õ�������Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ������Сʱ
     * @return ������Сʱ��ֵ
     */
    public int getStartHour(){
        return startHour;
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
     * ���������ձ�Сʱ
     * @param endHour �����õ������ձ�Сʱ��ֵ
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * ��ȡ�����ձ�Сʱ
     * @return �����ձ�Сʱ��ֵ
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * �������Ծ�����
     * @param pureRate �����õ����Ծ����ʵ�ֵ
     */
    public void setPureRate(double pureRate){
        this.pureRate = pureRate;
    }

    /**
     * ��ȡ���Ծ�����
     * @return ���Ծ����ʵ�ֵ
     */
    public double getPureRate(){
        return pureRate;
    }

    /**
     * ����������������/��������
     * @param disRate �����õ�������������/�������ʵ�ֵ
     */
    public void setDisRate(double disRate){
        this.disRate = disRate;
    }

    /**
     * ��ȡ������������/��������
     * @return ������������/�������ʵ�ֵ
     */
    public double getDisRate(){
        return disRate;
    }

    /**
     * �����������ۿ���
     * @param discount �����õ��������ۿ��ʵ�ֵ
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * ��ȡ�������ۿ���
     * @return �������ۿ��ʵ�ֵ
     */
    public double getDiscount(){
        return discount;
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
     * ���������ܱ��ռ�ֵ
     * @param sumValue �����õ������ܱ��ռ�ֵ��ֵ
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * ��ȡ�����ܱ��ռ�ֵ
     * @return �����ܱ��ռ�ֵ��ֵ
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * ���������ܱ���
     * @param sumAmount �����õ������ܱ����ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ����ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * �����������ۿ۽��
     * @param sumDiscount �����õ��������ۿ۽���ֵ
     */
    public void setSumDiscount(double sumDiscount){
        this.sumDiscount = sumDiscount;
    }

    /**
     * ��ȡ�������ۿ۽��
     * @return �������ۿ۽���ֵ
     */
    public double getSumDiscount(){
        return sumDiscount;
    }

    /**
     * ���������ܱ��շ�
     * @param sumPremium �����õ������ܱ��շѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ�����ܱ��շ�
     * @return �����ܱ��շѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ���������ܸ����ձ���
     * @param sumSubPrem �����õ������ܸ����ձ��ѵ�ֵ
     */
    public void setSumSubPrem(double sumSubPrem){
        this.sumSubPrem = sumSubPrem;
    }

    /**
     * ��ȡ�����ܸ����ձ���
     * @return �����ܸ����ձ��ѵ�ֵ
     */
    public double getSumSubPrem(){
        return sumSubPrem;
    }

    /**
     * ��������ѹ����������
     * @param sumQuantity �����õ�����ѹ������������ֵ
     */
    public void setSumQuantity(int sumQuantity){
        this.sumQuantity = sumQuantity;
    }

    /**
     * ��ȡ����ѹ����������
     * @return ����ѹ������������ֵ
     */
    public int getSumQuantity(){
        return sumQuantity;
    }

    /**
     * ��������˾����Ͻ
     * @param judicalScope �����õ�����˾����Ͻ��ֵ
     */
    public void setJudicalScope(String judicalScope){
        this.judicalScope = StringUtils.rightTrim(judicalScope);
    }

    /**
     * ��ȡ����˾����Ͻ
     * @return ����˾����Ͻ��ֵ
     */
    public String getJudicalScope(){
        return judicalScope;
    }

    /**
     * ���������Ƿ��Զ�ת��������־
     * @param autoTransRenewFlag �����õ������Ƿ��Զ�ת��������־��ֵ
     */
    public void setAutoTransRenewFlag(String autoTransRenewFlag){
        this.autoTransRenewFlag = StringUtils.rightTrim(autoTransRenewFlag);
    }

    /**
     * ��ȡ�����Ƿ��Զ�ת��������־
     * @return �����Ƿ��Զ�ת��������־��ֵ
     */
    public String getAutoTransRenewFlag(){
        return autoTransRenewFlag;
    }

    /**
     * ����������������ʽ
     * @param argueSolution �����õ�������������ʽ��ֵ
     */
    public void setArgueSolution(String argueSolution){
        this.argueSolution = StringUtils.rightTrim(argueSolution);
    }

    /**
     * ��ȡ������������ʽ
     * @return ������������ʽ��ֵ
     */
    public String getArgueSolution(){
        return argueSolution;
    }

    /**
     * ���������ٲ�ίԱ������
     * @param arbitBoardName �����õ������ٲ�ίԱ�����Ƶ�ֵ
     */
    public void setArbitBoardName(String arbitBoardName){
        this.arbitBoardName = StringUtils.rightTrim(arbitBoardName);
    }

    /**
     * ��ȡ�����ٲ�ίԱ������
     * @return �����ٲ�ίԱ�����Ƶ�ֵ
     */
    public String getArbitBoardName(){
        return arbitBoardName;
    }

    /**
     * ��������Լ�����ڽ��Ѵ���
     * @param payTimes �����õ�����Լ�����ڽ��Ѵ�����ֵ
     */
    public void setPayTimes(int payTimes){
        this.payTimes = payTimes;
    }

    /**
     * ��ȡ����Լ�����ڽ��Ѵ���
     * @return ����Լ�����ڽ��Ѵ�����ֵ
     */
    public int getPayTimes(){
        return payTimes;
    }

    /**
     * �����������Ĵ���
     * @param endorseTimes �����õ��������Ĵ�����ֵ
     */
    public void setEndorseTimes(int endorseTimes){
        this.endorseTimes = endorseTimes;
    }

    /**
     * ��ȡ�������Ĵ���
     * @return �������Ĵ�����ֵ
     */
    public int getEndorseTimes(){
        return endorseTimes;
    }

    /**
     * ���������������
     * @param claimTimes �����õ��������������ֵ
     */
    public void setClaimTimes(int claimTimes){
        this.claimTimes = claimTimes;
    }

    /**
     * ��ȡ�����������
     * @return �������������ֵ
     */
    public int getClaimTimes(){
        return claimTimes;
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
     * ��������ǩ���ص�
     * @param operateSite �����õ�����ǩ���ص��ֵ
     */
    public void setOperateSite(String operateSite){
        this.operateSite = StringUtils.rightTrim(operateSite);
    }

    /**
     * ��ȡ����ǩ���ص�
     * @return ����ǩ���ص��ֵ
     */
    public String getOperateSite(){
        return operateSite;
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
     * �������Թ���ҵ��Ա����
     * @param handler1Code �����õ����Թ���ҵ��Ա�����ֵ
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * ��ȡ���Թ���ҵ��Ա����
     * @return ���Թ���ҵ��Ա�����ֵ
     */
    public String getHandler1Code(){
        return handler1Code;
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
     * �����������պ˱��˴���
     * @param underWriteCode �����õ��������պ˱��˴����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ�������պ˱��˴���
     * @return �������պ˱��˴����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �����������պ˱�������
     * @param underWriteName �����õ��������պ˱������Ƶ�ֵ
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * ��ȡ�������պ˱�������
     * @return �������պ˱������Ƶ�ֵ
     */
    public String getUnderWriteName(){
        return underWriteName;
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
     * �������Լ�����䵥����
     * @param inputDate �����õ����Լ�����䵥���ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����
     * @return ���Լ�����䵥���ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Լ�����䵥Сʱ
     * @param inputHour �����õ����Լ�����䵥Сʱ��ֵ
     */
    public void setInputHour(int inputHour){
        this.inputHour = inputHour;
    }

    /**
     * ��ȡ���Լ�����䵥Сʱ
     * @return ���Լ�����䵥Сʱ��ֵ
     */
    public int getInputHour(){
        return inputHour;
    }

    /**
     * �������Ժ˱��������
     * @param underWriteEndDate �����õ����Ժ˱�������ڵ�ֵ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * ��ȡ���Ժ˱��������
     * @return ���Ժ˱�������ڵ�ֵ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * �������Ա���ͳ������
     * @param statisticsYM �����õ����Ա���ͳ�����µ�ֵ
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * ��ȡ���Ա���ͳ������
     * @return ���Ա���ͳ�����µ�ֵ
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
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
     * �������Թ�����־
     * @param coinsFlag �����õ����Թ�����־��ֵ
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = StringUtils.rightTrim(coinsFlag);
    }

    /**
     * ��ȡ���Թ�����־
     * @return ���Թ�����־��ֵ
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }

    /**
     * ����������ҵ�ֱ���־
     * @param reinsFlag �����õ�������ҵ�ֱ���־��ֵ
     */
    public void setReinsFlag(String reinsFlag){
        this.reinsFlag = StringUtils.rightTrim(reinsFlag);
    }

    /**
     * ��ȡ������ҵ�ֱ���־
     * @return ������ҵ�ֱ���־��ֵ
     */
    public String getReinsFlag(){
        return reinsFlag;
    }

    /**
     * ��������ͳ����־
     * @param allinsFlag �����õ�����ͳ����־��ֵ
     */
    public void setAllinsFlag(String allinsFlag){
        this.allinsFlag = StringUtils.rightTrim(allinsFlag);
    }

    /**
     * ��ȡ����ͳ����־
     * @return ����ͳ����־��ֵ
     */
    public String getAllinsFlag(){
        return allinsFlag;
    }

    /**
     * �������Ժ˱���־
     * @param underWriteFlag �����õ����Ժ˱���־��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ���Ժ˱���־
     * @return ���Ժ˱���־��ֵ
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * ��������������־�ֶ�
     * @param othFlag �����õ�����������־�ֶε�ֵ
     */
    public void setOthFlag(String othFlag){
        this.othFlag = StringUtils.rightTrim(othFlag);
    }

    /**
     * ��ȡ����������־�ֶ�
     * @return ����������־�ֶε�ֵ
     */
    public String getOthFlag(){
        return othFlag;
    }

    /**
     * ��������״̬�ֶ�
     * @param flag �����õ�����״̬�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬�ֶ�
     * @return ����״̬�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������Ա仯���ս��(����Ϊ����ұ���)
     * @param chgAmount �����õ����Ա仯���ս��(����Ϊ����ұ���)��ֵ
     */
    public void setChgAmount(double chgAmount){
        this.chgAmount = chgAmount;
    }

    /**
     * ��ȡ���Ա仯���ս��(����Ϊ����ұ���)
     * @return ���Ա仯���ս��(����Ϊ����ұ���)��ֵ
     */
    public double getChgAmount(){
        return chgAmount;
    }

    /**
     * ��������chgpremium
     * @param chgPremium �����õ�����chgpremium��ֵ
     */
    public void setChgPremium(double chgPremium){
        this.chgPremium = chgPremium;
    }

    /**
     * ��ȡ����chgpremium
     * @return ����chgpremium��ֵ
     */
    public double getChgPremium(){
        return chgPremium;
    }

    /**
     * ��������chgsubprem
     * @param chgSubPrem �����õ�����chgsubprem��ֵ
     */
    public void setChgSubPrem(double chgSubPrem){
        this.chgSubPrem = chgSubPrem;
    }

    /**
     * ��ȡ����chgsubprem
     * @return ����chgsubprem��ֵ
     */
    public double getChgSubPrem(){
        return chgSubPrem;
    }

    /**
     * ��������chgquantity
     * @param chgQuantity �����õ�����chgquantity��ֵ
     */
    public void setChgQuantity(int chgQuantity){
        this.chgQuantity = chgQuantity;
    }

    /**
     * ��ȡ����chgquantity
     * @return ����chgquantity��ֵ
     */
    public int getChgQuantity(){
        return chgQuantity;
    }


	public double getStatQuantity() {
		return statQuantity;
	}

	public void setStatQuantity(double statQuantity) {
		this.statQuantity = statQuantity;
	}

	public double getChgStatquantity() {
		return chgStatquantity;
	}

	public void setChgStatquantity(double chgStatquantity) {
		this.chgStatquantity = chgStatquantity;
	}
    
}
