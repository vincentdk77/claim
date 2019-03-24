package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleNew-�°���������ʾ��(����)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleNewDtoBase implements Serializable{
    /** ���Ա�������� */
    private String registNo = "";
    /** ������ϯԱID */
    private String operatorCode = "";
    /** ���Գ��ճ��ƺ��� */
    private String lostLicenseNo = "";
    /** ���Բ鿱���ƺ���(����ԤԼ) */
    private String surveyLicenseNo = "";
    /** �����Ѳ鿱���� */
    private int surveyNo = 0;
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Գ������� */
    private String contactName = "";
    /** ������ϵ�绰 */
    private String phoneNumber = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /** �����¹����ʹ���(����) */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���Գ����������� */
    private String damageAreaName = "";
    /** ���Գ��յص���� */
    private String damageAddressType = "";
    /** ���Ե�ַ���� */
    private String addressCode = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���Գ��յص��������� */
    private String damageAreaPostCode = "";
    /** ���Գ������ */
    private String accidentDetail = "";
    /** ���Բ鿱�ص����� */
    private String surveyType = "";
    /** ���Խ����ƿͻ���־ */
    private String signcustType = "";
    /** ���Ա�������(��λ)���� */
    private String customerName = "";
    /** ���Բ鿱��ַ */
    private String surveyAddress = "";
    /** ���Ա���;�� */
    private String reportWay = "";
    /** ���Գб����� (DAA) */
    private String riskCode = "";
    /** ���Գб�֧��˾ */
    private String insureComCode = "";
    /** ���Ե���ʱ�� */
    private DateTime surveyDate = new DateTime();
    /** ���Ե�����Ϣ */
    private String scheduleInfo = "";
    /** ����ԤԼ�鿱(����)״̬ */
    private String bookFlag = "";
    /** �����Ƿ񱻵���ʹ�� */
    private String scheduleFlag = "";
    /** �������ִ��루Ͷ������ */
    private String allKindCode = "";
    /** ����Flag */
    private String flag = "";
    /** ���Բ���ʱ�� */
    private String operateDate = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleNewDtoBase����
     */
    public PrpLscheduleNewDtoBase(){
    }

    /**
     * �������Ա��������
     * @param registNo �����õ����Ա�������ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա��������
     * @return ���Ա�������ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ����������ϯԱID
     * @param operatorCode �����õ�������ϯԱID��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ������ϯԱID
     * @return ������ϯԱID��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Գ��ճ��ƺ���
     * @param lostLicenseNo �����õ����Գ��ճ��ƺ����ֵ
     */
    public void setLostLicenseNo(String lostLicenseNo){
        this.lostLicenseNo = StringUtils.rightTrim(lostLicenseNo);
    }

    /**
     * ��ȡ���Գ��ճ��ƺ���
     * @return ���Գ��ճ��ƺ����ֵ
     */
    public String getLostLicenseNo(){
        return lostLicenseNo;
    }

    /**
     * �������Բ鿱���ƺ���(����ԤԼ)
     * @param surveyLicenseNo �����õ����Բ鿱���ƺ���(����ԤԼ)��ֵ
     */
    public void setSurveyLicenseNo(String surveyLicenseNo){
        this.surveyLicenseNo = StringUtils.rightTrim(surveyLicenseNo);
    }

    /**
     * ��ȡ���Բ鿱���ƺ���(����ԤԼ)
     * @return ���Բ鿱���ƺ���(����ԤԼ)��ֵ
     */
    public String getSurveyLicenseNo(){
        return surveyLicenseNo;
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
     * �������Գ�������
     * @param contactName �����õ����Գ���������ֵ
     */
    public void setContactName(String contactName){
        this.contactName = StringUtils.rightTrim(contactName);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ���������ֵ
     */
    public String getContactName(){
        return contactName;
    }

    /**
     * ����������ϵ�绰
     * @param phoneNumber �����õ�������ϵ�绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ������ϵ�绰
     * @return ������ϵ�绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * �������Գ���ԭ�����
     * @param damageCode �����õ����Գ���ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ���Գ���ԭ�����
     * @return ���Գ���ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * �������Գ���ԭ��˵��
     * @param damageName �����õ����Գ���ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ���Գ���ԭ��˵��
     * @return ���Գ���ԭ��˵����ֵ
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * ���������¹����ʹ���(����)
     * @param damageTypeCode �����õ������¹����ʹ���(����)��ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹����ʹ���(����)
     * @return �����¹����ʹ���(����)��ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * ���������¹�����˵��
     * @param damageTypeName �����õ������¹�����˵����ֵ
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * ��ȡ�����¹�����˵��
     * @return �����¹�����˵����ֵ
     */
    public String getDamageTypeName(){
        return damageTypeName;
    }

    /**
     * �������Գ����������
     * @param damageAreaCode �����õ����Գ�����������ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * �������Գ�����������
     * @param damageAreaName �����õ����Գ����������Ƶ�ֵ
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ����������Ƶ�ֵ
     */
    public String getDamageAreaName(){
        return damageAreaName;
    }

    /**
     * �������Գ��յص����
     * @param damageAddressType �����õ����Գ��յص�����ֵ
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * ��ȡ���Գ��յص����
     * @return ���Գ��յص�����ֵ
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * �������Ե�ַ����
     * @param addressCode �����õ����Ե�ַ�����ֵ
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * ��ȡ���Ե�ַ����
     * @return ���Ե�ַ�����ֵ
     */
    public String getAddressCode(){
        return addressCode;
    }

    /**
     * �������Գ��յص�
     * @param damageAddress �����õ����Գ��յص��ֵ
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * ��ȡ���Գ��յص�
     * @return ���Գ��յص��ֵ
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * �������Գ��յص���������
     * @param damageAreaPostCode �����õ����Գ��յص����������ֵ
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * ��ȡ���Գ��յص���������
     * @return ���Գ��յص����������ֵ
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
    }

    /**
     * �������Գ������
     * @param accidentDetail �����õ����Գ��������ֵ
     */
    public void setAccidentDetail(String accidentDetail){
        this.accidentDetail = StringUtils.rightTrim(accidentDetail);
    }

    /**
     * ��ȡ���Գ������
     * @return ���Գ��������ֵ
     */
    public String getAccidentDetail(){
        return accidentDetail;
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
     * �������Խ����ƿͻ���־
     * @param signcustType �����õ����Խ����ƿͻ���־��ֵ
     */
    public void setSigncustType(String signcustType){
        this.signcustType = StringUtils.rightTrim(signcustType);
    }

    /**
     * ��ȡ���Խ����ƿͻ���־
     * @return ���Խ����ƿͻ���־��ֵ
     */
    public String getSigncustType(){
        return signcustType;
    }

    /**
     * �������Ա�������(��λ)����
     * @param customerName �����õ����Ա�������(��λ)���Ƶ�ֵ
     */
    public void setCustomerName(String customerName){
        this.customerName = StringUtils.rightTrim(customerName);
    }

    /**
     * ��ȡ���Ա�������(��λ)����
     * @return ���Ա�������(��λ)���Ƶ�ֵ
     */
    public String getCustomerName(){
        return customerName;
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
     * �������Ա���;��
     * @param reportWay �����õ����Ա���;����ֵ
     */
    public void setReportWay(String reportWay){
        this.reportWay = StringUtils.rightTrim(reportWay);
    }

    /**
     * ��ȡ���Ա���;��
     * @return ���Ա���;����ֵ
     */
    public String getReportWay(){
        return reportWay;
    }

    /**
     * �������Գб����� (DAA)
     * @param riskCode �����õ����Գб����� (DAA)��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ���Գб����� (DAA)
     * @return ���Գб����� (DAA)��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Գб�֧��˾
     * @param insureComCode �����õ����Գб�֧��˾��ֵ
     */
    public void setInsureComCode(String insureComCode){
        this.insureComCode = StringUtils.rightTrim(insureComCode);
    }

    /**
     * ��ȡ���Գб�֧��˾
     * @return ���Գб�֧��˾��ֵ
     */
    public String getInsureComCode(){
        return insureComCode;
    }

    /**
     * �������Ե���ʱ��
     * @param surveyDate �����õ����Ե���ʱ���ֵ
     */
    public void setSurveyDate(DateTime surveyDate){
        this.surveyDate = surveyDate;
    }

    /**
     * ��ȡ���Ե���ʱ��
     * @return ���Ե���ʱ���ֵ
     */
    public DateTime getSurveyDate(){
        return surveyDate;
    }

    /**
     * �������Ե�����Ϣ
     * @param scheduleInfo �����õ����Ե�����Ϣ��ֵ
     */
    public void setScheduleInfo(String scheduleInfo){
        this.scheduleInfo = StringUtils.rightTrim(scheduleInfo);
    }

    /**
     * ��ȡ���Ե�����Ϣ
     * @return ���Ե�����Ϣ��ֵ
     */
    public String getScheduleInfo(){
        return scheduleInfo;
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
     * ���������Ƿ񱻵���ʹ��
     * @param scheduleFlag �����õ������Ƿ񱻵���ʹ�õ�ֵ
     */
    public void setScheduleFlag(String scheduleFlag){
        this.scheduleFlag = StringUtils.rightTrim(scheduleFlag);
    }

    /**
     * ��ȡ�����Ƿ񱻵���ʹ��
     * @return �����Ƿ񱻵���ʹ�õ�ֵ
     */
    public String getScheduleFlag(){
        return scheduleFlag;
    }

    /**
     * �����������ִ��루Ͷ������
     * @param allKindCode �����õ��������ִ��루Ͷ��������ֵ
     */
    public void setAllKindCode(String allKindCode){
        this.allKindCode = StringUtils.rightTrim(allKindCode);
    }

    /**
     * ��ȡ�������ִ��루Ͷ������
     * @return �������ִ��루Ͷ��������ֵ
     */
    public String getAllKindCode(){
        return allKindCode;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������Բ���ʱ��
     * @param operateDate �����õ����Բ���ʱ���ֵ
     */
    public void setOperateDate(String operateDate){
        this.operateDate = StringUtils.rightTrim(operateDate);
    }

    /**
     * ��ȡ���Բ���ʱ��
     * @return ���Բ���ʱ���ֵ
     */
    public String getOperateDate(){
        return operateDate;
    }
}
