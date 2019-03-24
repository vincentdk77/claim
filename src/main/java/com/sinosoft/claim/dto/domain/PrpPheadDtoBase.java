package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpphead������Ϣ������ݴ���������<br>
 * ������ 2004-11-22 15:24:12.687<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPheadDtoBase implements Serializable{
    /** ������������ */
    private String endorseNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ��������ӡˢ�� */
    private String printNo = "";
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������Ĵ��� */
    private int endorseTimes = 0;
    /** ���Գ����������� */
    private String makeCom = "";
    /** ������������� */
    private String compensateNo = "";
    /** ���Ա������˴��� */
    private String insuredCode = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ������/Ӣ�� */
    private String language = "";
    /** ���Ա������� */
    private String policyType = "";
    /** ������������ */
    private String endorType = "";
    /** ������������ */
    private DateTime endorDate = new DateTime();
    /** ������Ч���� */
    private DateTime validDate = new DateTime();
    /** ������ЧСʱ */
    private int validHour = 0;
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** �������պ����˴��� */
    private String underWriteCode = "";
    /** �������պ��������� */
    private String underWriteName = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Լ�����䵥Сʱ */
    private int inputHour = 0;
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ��������ͳ������ */
    private DateTime statisticsYM = new DateTime();
    /** ���Ժ���������� */
    private DateTime underWriteEndDate = new DateTime();
    /** ���Ժ�����־ */
    private String underWriteFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPheadDtoBase����
     */
    public PrpPheadDtoBase(){
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
     * ������������ӡˢ��
     * @param printNo �����õ���������ӡˢ�ŵ�ֵ
     */
    public void setPrintNo(String printNo){
        this.printNo = StringUtils.rightTrim(printNo);
    }

    /**
     * ��ȡ��������ӡˢ��
     * @return ��������ӡˢ�ŵ�ֵ
     */
    public String getPrintNo(){
        return printNo;
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
     * �������Ա������Ĵ���
     * @param endorseTimes �����õ����Ա������Ĵ�����ֵ
     */
    public void setEndorseTimes(int endorseTimes){
        this.endorseTimes = endorseTimes;
    }

    /**
     * ��ȡ���Ա������Ĵ���
     * @return ���Ա������Ĵ�����ֵ
     */
    public int getEndorseTimes(){
        return endorseTimes;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * @param insuredName �����õ����Ա�������������ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա�������������ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ����������/Ӣ��
     * @param language �����õ�������/Ӣ�ĵ�ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ������/Ӣ��
     * @return ������/Ӣ�ĵ�ֵ
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

    /**
     * ����������������
     * @param endorType �����õ������������͵�ֵ
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * ����������������
     * @param endorDate �����õ������������ڵ�ֵ
     */
    public void setEndorDate(DateTime endorDate){
        this.endorDate = endorDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getEndorDate(){
        return endorDate;
    }

    /**
     * ����������Ч����
     * @param validDate �����õ�������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������Ч����
     * @return ������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ����������ЧСʱ
     * @param validHour �����õ�������ЧСʱ��ֵ
     */
    public void setValidHour(int validHour){
        this.validHour = validHour;
    }

    /**
     * ��ȡ������ЧСʱ
     * @return ������ЧСʱ��ֵ
     */
    public int getValidHour(){
        return validHour;
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
     * �����������պ����˴���
     * @param underWriteCode �����õ��������պ����˴����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ�������պ����˴���
     * @return �������պ����˴����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �����������պ���������
     * @param underWriteName �����õ��������պ��������Ƶ�ֵ
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * ��ȡ�������պ���������
     * @return �������պ��������Ƶ�ֵ
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
     * ������������ͳ������
     * @param statisticsYM �����õ���������ͳ�����µ�ֵ
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * ��ȡ��������ͳ������
     * @return ��������ͳ�����µ�ֵ
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
    }

    /**
     * �������Ժ����������
     * @param underWriteEndDate �����õ����Ժ���������ڵ�ֵ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * ��ȡ���Ժ����������
     * @return ���Ժ���������ڵ�ֵ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * �������Ժ�����־
     * @param underWriteFlag �����õ����Ժ�����־��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ���Ժ�����־
     * @return ���Ժ�����־��ֵ
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
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
