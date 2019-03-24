package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLCMain-���Ᵽ����������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCMainDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ����������� */
    private String classCode = "";
    /** �������ִ���2 */
    private String riskCode = "";
    /** ����ҵ����Դ */
    private String businessNature = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ����Ͷ���˵�ַ */
    private String appliAddress = "";
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
    /** ���Աұ���� */
    private String currency = "";
    /** �����ܱ��ս��(����Ϊ�����) */
    private double sumAmount = 0d;
    /** �����ܱ��շ�(����Ϊ�����) */
    private double sumPremium = 0d;
    /** ������������ʽ--** 1 ���ϣ�2 �ٲ� */
    private String argueSolution = "";
    /** �����ٲ�ίԱ������ */
    private String arbitBoardName = "";
    /** ����Լ�����ڽ��Ѵ��� */
    private int payTimes = 0;
    /** �������Ĵ��� */
    private int endorseTimes = 0;
    /** ���Գ��մ��� */
    private int registTimes = 0;
    /** �����⸶���� */
    private int claimTimes = 0;
    /** �����⸶��� */
    private double sumClaim = 0d;
    /** ���Գ������� */
    private String makeCom = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Լ�����䵥Сʱ */
    private int inputHour = 0;
    /** ����״̬�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLCMainDtoBase����
     */
    public PrpLCMainDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
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
     * �����������ִ���2
     * @param riskCode �����õ��������ִ���2��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���2
     * @return �������ִ���2��ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * ���������ܱ��ս��(����Ϊ�����)
     * @param sumAmount �����õ������ܱ��ս��(����Ϊ�����)��ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ�����ܱ��ս��(����Ϊ�����)
     * @return �����ܱ��ս��(����Ϊ�����)��ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * ���������ܱ��շ�(����Ϊ�����)
     * @param sumPremium �����õ������ܱ��շ�(����Ϊ�����)��ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ�����ܱ��շ�(����Ϊ�����)
     * @return �����ܱ��շ�(����Ϊ�����)��ֵ
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * ����������������ʽ--** 1 ���ϣ�2 �ٲ�
     * @param argueSolution �����õ�������������ʽ--** 1 ���ϣ�2 �ٲõ�ֵ
     */
    public void setArgueSolution(String argueSolution){
        this.argueSolution = StringUtils.rightTrim(argueSolution);
    }

    /**
     * ��ȡ������������ʽ--** 1 ���ϣ�2 �ٲ�
     * @return ������������ʽ--** 1 ���ϣ�2 �ٲõ�ֵ
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
     * �������Գ��մ���
     * @param registTimes �����õ����Գ��մ�����ֵ
     */
    public void setRegistTimes(int registTimes){
        this.registTimes = registTimes;
    }

    /**
     * ��ȡ���Գ��մ���
     * @return ���Գ��մ�����ֵ
     */
    public int getRegistTimes(){
        return registTimes;
    }

    /**
     * ���������⸶����
     * @param claimTimes �����õ������⸶������ֵ
     */
    public void setClaimTimes(int claimTimes){
        this.claimTimes = claimTimes;
    }

    /**
     * ��ȡ�����⸶����
     * @return �����⸶������ֵ
     */
    public int getClaimTimes(){
        return claimTimes;
    }

    /**
     * ���������⸶���
     * @param sumClaim �����õ������⸶����ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ�����⸶���
     * @return �����⸶����ֵ
     */
    public double getSumClaim(){
        return sumClaim;
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
}
