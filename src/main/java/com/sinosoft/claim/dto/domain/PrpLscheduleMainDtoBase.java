package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleMain-����������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainDtoBase implements Serializable{
    /** ���Ե���ID */
    private int scheduleID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �����Ƿ�Ϊ����������(1.��2.��) */
    private String insureCarFlag = "";
    /** �������⴦����� */
    private String claimComCode = "";
    /** �����Ƿ�ѡ���� */
    private String selectTSend = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա����ȵ�λ����,����Ϊ����,����� */
    private String scheduleDeptCode = "";
    /** ���Ա����ȵ�λ���� (����) */
    private String scheduleDeptName = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Ե���Ա���� */
    private String operatorName = "";
    /** ���Բ鿱���� */
    private int surveyTimes = 0;
    /** ���Բ鿱�ص�����(��һ�ֳ�) */
    private String surveyType = "";
    /** ���Բ鿱��ַ */
    private String surveyAddress = "";
    /** ���Գ��ճ��ƺ��� */
    private String licenseNo = "";
    /** ���Լ�����䵥����(��������) */
    private DateTime inputDate = new DateTime();
    /** ����Сʱ */
    private int inputHour = 0;
    /** ���Ե�����Ϣ */
    private String resultInfo = "";
    /** ���Դ�������־ */
    private String transFlag = "";
    /** ����ԤԼ�鿱(����)״̬ */
    private String bookFlag = "";
    /** ���Ե��ȴ����־ */
    private String scheduleFlag = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleMainDtoBase����
     */
    public PrpLscheduleMainDtoBase(){
    }

    /**
     * �������Ե���ID
     * @param scheduleID �����õ����Ե���ID��ֵ
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * ��ȡ���Ե���ID
     * @return ���Ե���ID��ֵ
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * ���������Ƿ�Ϊ����������(1.��2.��)
     * @param insureCarFlag �����õ������Ƿ�Ϊ����������(1.��2.��)��ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������(1.��2.��)
     * @return �����Ƿ�Ϊ����������(1.��2.��)��ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * �����������⴦�����
     * @param claimComCode �����õ��������⴦�������ֵ
     */
    public void setClaimComCode(String claimComCode){
        this.claimComCode = StringUtils.rightTrim(claimComCode);
    }

    /**
     * ��ȡ�������⴦�����
     * @return �������⴦�������ֵ
     */
    public String getClaimComCode(){
        return claimComCode;
    }

    /**
     * ���������Ƿ�ѡ����
     * @param selectTSend �����õ������Ƿ�ѡ���͵�ֵ
     */
    public void setSelectTSend(String selectTSend){
        this.selectTSend = StringUtils.rightTrim(selectTSend);
    }

    /**
     * ��ȡ�����Ƿ�ѡ����
     * @return �����Ƿ�ѡ���͵�ֵ
     */
    public String getSelectTSend(){
        return selectTSend;
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
     * �������Ա����ȵ�λ����,����Ϊ����,�����
     * @param scheduleDeptCode �����õ����Ա����ȵ�λ����,����Ϊ����,������ֵ
     */
    public void setScheduleDeptCode(String scheduleDeptCode){
        this.scheduleDeptCode = StringUtils.rightTrim(scheduleDeptCode);
    }

    /**
     * ��ȡ���Ա����ȵ�λ����,����Ϊ����,�����
     * @return ���Ա����ȵ�λ����,����Ϊ����,������ֵ
     */
    public String getScheduleDeptCode(){
        return scheduleDeptCode;
    }

    /**
     * �������Ա����ȵ�λ���� (����)
     * @param scheduleDeptName �����õ����Ա����ȵ�λ���� (����)��ֵ
     */
    public void setScheduleDeptName(String scheduleDeptName){
        this.scheduleDeptName = StringUtils.rightTrim(scheduleDeptName);
    }

    /**
     * ��ȡ���Ա����ȵ�λ���� (����)
     * @return ���Ա����ȵ�λ���� (����)��ֵ
     */
    public String getScheduleDeptName(){
        return scheduleDeptName;
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
     * �������Ե���Ա����
     * @param operatorName �����õ����Ե���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Ե���Ա����
     * @return ���Ե���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �������Բ鿱����
     * @param surveyTimes �����õ����Բ鿱������ֵ
     */
    public void setSurveyTimes(int surveyTimes){
        this.surveyTimes = surveyTimes;
    }

    /**
     * ��ȡ���Բ鿱����
     * @return ���Բ鿱������ֵ
     */
    public int getSurveyTimes(){
        return surveyTimes;
    }

    /**
     * �������Բ鿱�ص�����(��һ�ֳ�)
     * @param surveyType �����õ����Բ鿱�ص�����(��һ�ֳ�)��ֵ
     */
    public void setSurveyType(String surveyType){
        this.surveyType = StringUtils.rightTrim(surveyType);
    }

    /**
     * ��ȡ���Բ鿱�ص�����(��һ�ֳ�)
     * @return ���Բ鿱�ص�����(��һ�ֳ�)��ֵ
     */
    public String getSurveyType(){
        return surveyType;
    }

    /**
     * �������Բ鿱��ַ
     * @param surveyAddress �����õ����Բ鿱��ַ��ֵ
     */
    public void setSurveyAddress(String surveyAddress){
        this.surveyAddress = StringUtils.rightTrim(surveyAddress);
    }

    /**
     * ��ȡ���Բ鿱��ַ
     * @return ���Բ鿱��ַ��ֵ
     */
    public String getSurveyAddress(){
        return surveyAddress;
    }

    /**
     * �������Գ��ճ��ƺ���
     * @param licenseNo �����õ����Գ��ճ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ճ��ƺ���
     * @return ���Գ��ճ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Լ�����䵥����(��������)
     * @param inputDate �����õ����Լ�����䵥����(��������)��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����(��������)
     * @return ���Լ�����䵥����(��������)��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������Сʱ
     * @param inputHour �����õ�����Сʱ��ֵ
     */
    public void setInputHour(int inputHour){
        this.inputHour = inputHour;
    }

    /**
     * ��ȡ����Сʱ
     * @return ����Сʱ��ֵ
     */
    public int getInputHour(){
        return inputHour;
    }

    /**
     * �������Ե�����Ϣ
     * @param resultInfo �����õ����Ե�����Ϣ��ֵ
     */
    public void setResultInfo(String resultInfo){
        this.resultInfo = StringUtils.rightTrim(resultInfo);
    }

    /**
     * ��ȡ���Ե�����Ϣ
     * @return ���Ե�����Ϣ��ֵ
     */
    public String getResultInfo(){
        return resultInfo;
    }

    /**
     * �������Դ�������־
     * @param transFlag �����õ����Դ�������־��ֵ
     */
    public void setTransFlag(String transFlag){
        this.transFlag = StringUtils.rightTrim(transFlag);
    }

    /**
     * ��ȡ���Դ�������־
     * @return ���Դ�������־��ֵ
     */
    public String getTransFlag(){
        return transFlag;
    }

    /**
     * ��������ԤԼ�鿱(����)״̬
     * @param bookFlag �����õ�����ԤԼ�鿱(����)״̬��ֵ
     */
    public void setBookFlag(String bookFlag){
        this.bookFlag = StringUtils.rightTrim(bookFlag);
    }

    /**
     * ��ȡ����ԤԼ�鿱(����)״̬
     * @return ����ԤԼ�鿱(����)״̬��ֵ
     */
    public String getBookFlag(){
        return bookFlag;
    }

    /**
     * �������Ե��ȴ����־
     * @param scheduleFlag �����õ����Ե��ȴ����־��ֵ
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * ��ȡ���Ե��ȴ����־
     * @return ���Ե��ȴ����־��ֵ
     */
    public String getScheduleFlag(){
        return scheduleFlag;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
