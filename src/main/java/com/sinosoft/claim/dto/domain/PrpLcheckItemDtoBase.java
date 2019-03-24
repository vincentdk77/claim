package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcheckItem-�鿱�����ı������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckItemDtoBase implements Serializable{
    /** ���Ե���ID */
    private int scheduleID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    /** �������⴦����� */
    private String claimComCode = "";
    /** �����Ƿ�ѡ���� */
    private String selectSend = "";
    /** ���Բ鿱���� */
    private int surveyTimes = 0;
    /** ���Բ鿱�ص����� */
    private String surveyType = "";
    /** ���Բ鿱��ַ */
    private String checkSite = "";
    /** ���Գ��ճ��ƺ��� */
    private String licenseNo = "";
    /** ���Ե��ȶ������ */
    private String scheduleObjectID = "";
    /** ���Ե��ȶ������� */
    private String scheduleObjectName = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Բ鿱¼�����Ա���� */
    private String checkOperatorCode = "";
    /** ���Ե�����Ϣ */
    private String resultInfo = "";
    /** ����ԤԼ�鿱 */
    private String bookFlag = "";
    /** ���Ե������� */
    private String scheduleType = "";
    /** ���Բ鿱״̬ */
    private String checkFlag = "";
    /** ���Բ鿱��������Ϣ */
    private String checkInfo = "";
    /** ����״̬��־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckItemDtoBase����
     */
    public PrpLcheckItemDtoBase(){
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
     * �������Ա�����
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ������������ֵ
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
     * @param selectSend �����õ������Ƿ�ѡ���͵�ֵ
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * ��ȡ�����Ƿ�ѡ����
     * @return �����Ƿ�ѡ���͵�ֵ
     */
    public String getSelectSend(){
        return selectSend;
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
     * �������Բ鿱�ص�����
     * @param surveyType �����õ����Բ鿱�ص����͵�ֵ
     */
    public void setSurveyType(String surveyType){
        this.surveyType = StringUtils.rightTrim(surveyType);
    }

    /**
     * ��ȡ���Բ鿱�ص�����
     * @return ���Բ鿱�ص����͵�ֵ
     */
    public String getSurveyType(){
        return surveyType;
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
     * ��������ԤԼ�鿱
     * @param bookFlag �����õ�����ԤԼ�鿱��ֵ
     */
    public void setBookFlag(String bookFlag){
        this.bookFlag = StringUtils.rightTrim(bookFlag);
    }

    /**
     * ��ȡ����ԤԼ�鿱
     * @return ����ԤԼ�鿱��ֵ
     */
    public String getBookFlag(){
        return bookFlag;
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
     * �������Բ鿱��������Ϣ
     * @param checkInfo �����õ����Բ鿱��������Ϣ��ֵ
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * ��ȡ���Բ鿱��������Ϣ
     * @return ���Բ鿱��������Ϣ��ֵ
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * ��������״̬��־
     * @param flag �����õ�����״̬��־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬��־
     * @return ����״̬��־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
