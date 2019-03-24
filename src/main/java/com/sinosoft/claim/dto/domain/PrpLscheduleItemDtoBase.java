package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
 
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleItem-���������ı�(�����������ݴ���������<br>
 * ������ 2005-06-30 16:57:37.736<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleItemDtoBase implements Serializable{
    /** ���Ե���ID */
    private int scheduleID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ����ITEMNO */
    private int itemNo = 0;
    /** �����Ƿ�Ϊ����������(1.��2.��) */
    private String insureCarFlag = "";
    /** �������⴦����� */
    private String claimComCode = "";
    /** �����Ƿ�ѡ���� */
    private String selectSend = "";
    /** ���Բ鿱���� */
    private int surveyTimes = 0;
    /** ���Բ鿱�ص�����(��һ�ֳ�) */
    private String surveyType = "";
    /** ���Բ鿱��ַ */
    private String checkSite = "";
    /** ���Գ��ճ��ƺ��� */
    private String licenseNo = "";
    /** ���Ե��ȶ������ */
    private String scheduleObjectID = "";
    /** ���Ե��ȶ������� */
    private String scheduleObjectName = "";
    /** ���Լ�����䵥����(��������) */
    private DateTime inputDate = new DateTime();
    /** ���Ե�����Ϣ */
    private String resultInfo = "";
    /** ����ԤԼ�鿱(����)״̬ */
    private String bookFlag = "";
    /** ���Ե��ȴ����־ */
    private String scheduleType = "";
    /** ���Ա�־ */
    private String flag = "";
    /** ������һ���ڵ��˵Ĵ��� */
    private String nextHandlerCode = "";
    /** ������һ���ڵ��˵����� */
    private String nextHandlerName = "";
    /** ������һ���ڵ������ */
    private String nextNodeNo = "";
    /** ���Ե��Ȳ���Ա���� */
    private String operatorCode = "";
    /** ����������ϵ�绰 */
    private String factoryPhone = "";
    /** �������������ܽ�� */
    private double factoryEstimateLoss = 0d;
    /** �����Ƽ��������� */
    private String commendRepairFactoryCode = "";
    /** �����Ƽ��������� */
    private String commendRepairFactoryName = "";
    /** ���Խ����̶� */
    private String exigenceGree = "";
    /** ���Ե��ȵ�ǰ��״̬ */
    private String scheduleStatus = "";
    /** ����˫�������־ add by liyanjie 2005-12-10*/
    private String commiItemFlag = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleItemDtoBase����
     */
    public PrpLscheduleItemDtoBase(){
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
     * ��������ITEMNO
     * @param itemNo �����õ�����ITEMNO��ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ����ITEMNO
     * @return ����ITEMNO��ֵ
     */
    public int getItemNo(){
        return itemNo;
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
     * @param scheduleType �����õ����Ե��ȴ����־��ֵ
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * ��ȡ���Ե��ȴ����־
     * @return ���Ե��ȴ����־��ֵ
     */
    public String getScheduleType(){
        return scheduleType;
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
     * ��������������ϵ�绰
     * @param factoryPhone �����õ�����������ϵ�绰��ֵ
     */
    public void setFactoryPhone(String factoryPhone){
        this.factoryPhone = StringUtils.rightTrim(factoryPhone);
    }

    /**
     * ��ȡ����������ϵ�绰
     * @return ����������ϵ�绰��ֵ
     */
    public String getFactoryPhone(){
        return factoryPhone;
    }

    /**
     * �����������������ܽ��
     * @param factoryEstimateLoss �����õ��������������ܽ���ֵ
     */
    public void setFactoryEstimateLoss(double factoryEstimateLoss){
        this.factoryEstimateLoss = factoryEstimateLoss;
    }

    /**
     * ��ȡ�������������ܽ��
     * @return �������������ܽ���ֵ
     */
    public double getFactoryEstimateLoss(){
        return factoryEstimateLoss;
    }

    /**
     * ���������Ƽ���������
     * @param commendRepairFactoryCode �����õ������Ƽ����������ֵ
     */
    public void setCommendRepairFactoryCode(String commendRepairFactoryCode){
        this.commendRepairFactoryCode = StringUtils.rightTrim(commendRepairFactoryCode);
    }

    /**
     * ��ȡ�����Ƽ���������
     * @return �����Ƽ����������ֵ
     */
    public String getCommendRepairFactoryCode(){
        return commendRepairFactoryCode;
    }

    /**
     * ���������Ƽ���������
     * @param commendRepairFactoryName �����õ������Ƽ��������Ƶ�ֵ
     */
    public void setCommendRepairFactoryName(String commendRepairFactoryName){
        this.commendRepairFactoryName = StringUtils.rightTrim(commendRepairFactoryName);
    }

    /**
     * ��ȡ�����Ƽ���������
     * @return �����Ƽ��������Ƶ�ֵ
     */
    public String getCommendRepairFactoryName(){
        return commendRepairFactoryName;
    }

    /**
     * �������Խ����̶�
     * @param exigenceGree �����õ����Խ����̶ȵ�ֵ
     */
    public void setExigenceGree(String exigenceGree){
        this.exigenceGree = StringUtils.rightTrim(exigenceGree);
    }

    /**
     * ��ȡ���Խ����̶�
     * @return ���Խ����̶ȵ�ֵ
     */
    public String getExigenceGree(){
        return exigenceGree;
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
