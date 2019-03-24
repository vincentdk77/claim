package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/** 
 * ����PrpLscheduleMainWF�����ݴ���������<br>
 * ������ 2005-06-30 16:57:38.747<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleMainWFDtoBase implements Serializable{
    /** ���Ե���ID */
    private int scheduleID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** �����Ѳ鿱���� */
    private int surveyNo = 0;
    /** �������⴦����� */
    private String claimComCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ե��Ȳ���Ա���� */
    private String operatorCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ����Сʱ */
    private int inputHour = 0;
    /** ���Ե������� */
    private int scheduleArea = 0;
    /** ��������༶���� */
    private String scheduleMoreFlag = "";
    /** ���Ե��ȴ������ */
    private String scheduleFlag = "";
    /** ���Ե��ȶ������ */
    private String scheduleObjectID = "";
    /** ���Ե��ȶ������� */
    private String scheduleObjectName = "";
    /** ���Ե������� */
    private String scheduleType = "";
    /** ���Դ������� */
    private DateTime checkInputDate = new DateTime();
    /** ���Բ鿱¼�����Ա���� */
    private String checkOperatorCode = "";
    /** ���Բ鿱״̬ */
    private String checkFlag = "";
    /** ���Դ�����Ϣ */
    private String checkInfo = "";
    /** ���Ա���״̬ */
    private String flag = "";
    /** ���Բ鿱��ַ */
    private String checkSite = "";
    /** ������һ���ڵ��˵Ĵ��� */
    private String nextHandlerCode = "";
    /** ������һ���ڵ��˵����� */
    private String nextHandlerName = "";
    /** ������һ���ڵ������ */
    private String nextNodeNo = "";
    /** ���Է��� */
    private int inputMinute = 0;
    /** ���Ե��ȵ�ǰ��״̬ */
    private String scheduleStatus = "";
    /** ����˫�������־ */
    private String commiItemFlag = "";

    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleMainWFDtoBase����
     */
    public PrpLscheduleMainWFDtoBase(){
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
     * ���������Ѳ鿱����
     * @param surveyNo �����õ������Ѳ鿱������ֵ
     */
    public void setSurveyNo(int surveyNo){
        this.surveyNo = surveyNo;
    }

    /**
     * ��ȡ�����Ѳ鿱����
     * @return �����Ѳ鿱������ֵ
     */
    public int getSurveyNo(){
        return surveyNo;
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
     * �������Ե��Ȳ���Ա����
     * @param operatorCode �����õ����Ե��Ȳ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Ե��Ȳ���Ա����
     * @return ���Ե��Ȳ���Ա�����ֵ
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
     * �������Ե�������
     * @param scheduleArea �����õ����Ե��������ֵ
     */
    public void setScheduleArea(int scheduleArea){
        this.scheduleArea = scheduleArea;
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե��������ֵ
     */
    public int getScheduleArea(){
        return scheduleArea;
    }

    /**
     * ������������༶����
     * @param scheduleMoreFlag �����õ���������༶���ȵ�ֵ
     */
    public void setScheduleMoreFlag(String scheduleMoreFlag){
        this.scheduleMoreFlag = StringUtils.rightTrim(scheduleMoreFlag);
    }

    /**
     * ��ȡ��������༶����
     * @return ��������༶���ȵ�ֵ
     */
    public String getScheduleMoreFlag(){
        return scheduleMoreFlag;
    }

    /**
     * �������Ե��ȴ������
     * @param scheduleFlag �����õ����Ե��ȴ��������ֵ
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * ��ȡ���Ե��ȴ������
     * @return ���Ե��ȴ��������ֵ
     */
    public String getScheduleFlag(){
        return scheduleFlag;
    }

    /**
     * �������Ե��ȶ������
     * @param scheduleObjectID �����õ����Ե��ȶ�������ֵ
     */
    public void setScheduleObjectID(String scheduleObjectID){
        this.scheduleObjectID = StringUtils.rightTrim(scheduleObjectID);
    }

    /**
     * ��ȡ���Ե��ȶ������
     * @return ���Ե��ȶ�������ֵ
     */
    public String getScheduleObjectID(){
        return scheduleObjectID;
    }

    /**
     * �������Ե��ȶ�������
     * @param scheduleObjectName �����õ����Ե��ȶ������Ƶ�ֵ
     */
    public void setScheduleObjectName(String scheduleObjectName){
        this.scheduleObjectName = StringUtils.rightTrim(scheduleObjectName);
    }

    /**
     * ��ȡ���Ե��ȶ�������
     * @return ���Ե��ȶ������Ƶ�ֵ
     */
    public String getScheduleObjectName(){
        return scheduleObjectName;
    }

    /**
     * �������Ե�������
     * @param scheduleType �����õ����Ե������͵�ֵ
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getScheduleType(){
        return scheduleType;
    }

    /**
     * �������Դ�������
     * @param checkInputDate �����õ����Դ������ڵ�ֵ
     */
    public void setCheckInputDate(DateTime checkInputDate){
        this.checkInputDate = checkInputDate;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������ڵ�ֵ
     */
    public DateTime getCheckInputDate(){
        return checkInputDate;
    }

    /**
     * �������Բ鿱¼�����Ա����
     * @param checkOperatorCode �����õ����Բ鿱¼�����Ա�����ֵ
     */
    public void setCheckOperatorCode(String checkOperatorCode){
        this.checkOperatorCode = StringUtils.rightTrim(checkOperatorCode);
    }

    /**
     * ��ȡ���Բ鿱¼�����Ա����
     * @return ���Բ鿱¼�����Ա�����ֵ
     */
    public String getCheckOperatorCode(){
        return checkOperatorCode;
    }

    /**
     * �������Բ鿱״̬
     * @param checkFlag �����õ����Բ鿱״̬��ֵ
     */
    public void setCheckFlag(String checkFlag){
        this.checkFlag = StringUtils.rightTrim(checkFlag);
    }

    /**
     * ��ȡ���Բ鿱״̬
     * @return ���Բ鿱״̬��ֵ
     */
    public String getCheckFlag(){
        return checkFlag;
    }

    /**
     * �������Դ�����Ϣ
     * @param checkInfo �����õ����Դ�����Ϣ��ֵ
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * ��ȡ���Դ�����Ϣ
     * @return ���Դ�����Ϣ��ֵ
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * �������Ա���״̬
     * @param flag �����õ����Ա���״̬��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա���״̬
     * @return ���Ա���״̬��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������Բ鿱��ַ
     * @param checkSite �����õ����Բ鿱��ַ��ֵ
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * ��ȡ���Բ鿱��ַ
     * @return ���Բ鿱��ַ��ֵ
     */
    public String getCheckSite(){
        return checkSite;
    }

    /**
     * ����������һ���ڵ��˵Ĵ���
     * @param nextHandlerCode �����õ�������һ���ڵ��˵Ĵ����ֵ
     */
    public void setNextHandlerCode(String nextHandlerCode){
        this.nextHandlerCode = StringUtils.rightTrim(nextHandlerCode);
    }

    /**
     * ��ȡ������һ���ڵ��˵Ĵ���
     * @return ������һ���ڵ��˵Ĵ����ֵ
     */
    public String getNextHandlerCode(){
        return nextHandlerCode;
    }

    /**
     * ����������һ���ڵ��˵�����
     * @param nextHandlerName �����õ�������һ���ڵ��˵����Ƶ�ֵ
     */
    public void setNextHandlerName(String nextHandlerName){
        this.nextHandlerName = StringUtils.rightTrim(nextHandlerName);
    }

    /**
     * ��ȡ������һ���ڵ��˵�����
     * @return ������һ���ڵ��˵����Ƶ�ֵ
     */
    public String getNextHandlerName(){
        return nextHandlerName;
    }

    /**
     * ����������һ���ڵ������
     * @param nextNodeNo �����õ�������һ���ڵ�����͵�ֵ
     */
    public void setNextNodeNo(String nextNodeNo){
        this.nextNodeNo = StringUtils.rightTrim(nextNodeNo);
    }

    /**
     * ��ȡ������һ���ڵ������
     * @return ������һ���ڵ�����͵�ֵ
     */
    public String getNextNodeNo(){
        return nextNodeNo;
    }

    /**
     * �������Է���
     * @param inputMinute �����õ����Է��ӵ�ֵ
     */
    public void setInputMinute(int inputMinute){
        this.inputMinute = inputMinute;
    }

    /**
     * ��ȡ���Է���
     * @return ���Է��ӵ�ֵ
     */
    public int getInputMinute(){
        return inputMinute;
    }

    /**
     * �������Ե��ȵ�ǰ��״̬
     * @param scheduleStatus �����õ����Ե��ȵ�ǰ��״̬��ֵ
     */
    public void setScheduleStatus(String scheduleStatus){
        this.scheduleStatus = StringUtils.rightTrim(scheduleStatus);
    }

    /**
     * ��ȡ���Ե��ȵ�ǰ��״̬
     * @return ���Ե��ȵ�ǰ��״̬��ֵ
     */
    public String getScheduleStatus(){
        return scheduleStatus;
    }
    
    /**
     * ��������˫�������־
     * @param commiItemFlag �����õ�����˫�������־��ֵ
     */
    public void setCommiItemFlag(String commiItemFlag){
        this.commiItemFlag = StringUtils.rightTrim(commiItemFlag);
    }

    /**
     * ��ȡ����˫�������־
     * @return ����˫�������־��ֵ
     */
    public String getCommiItemFlag(){
        return commiItemFlag;
    }
    
}
