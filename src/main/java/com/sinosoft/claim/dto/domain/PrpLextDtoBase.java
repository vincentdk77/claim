package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLext�����ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLextDtoBase.class.getName().hashCode();
    /** ���Ե��� */
    private String certiNo = "";
    /** ���Ե������� */
    private String certiType = "";
    /** ���Ե����������� */
    private long personDeathB = 0L;
    /** ���Գ�����Ա������ */
    private long personDeathD1 = 0L;
    /** ���Ե����������� */
    private long personInjureB = 0L;
    /** ���Գ�����Ա������ */
    private long personInjureD1 = 0L;
    /** ���Գ����� */
    private String carrier = "";
    /** ���Կ������� */
    private DateTime sailStartDate = new DateTime();
    /** ����ж������ */
    private DateTime unloadDate = new DateTime();
    /** ��������鿱���� */
    private DateTime appliCheckDate = new DateTime();
    /** ����Ͷ���˻������ϵ�绰������ */
    private String appliPhone = "";
    /** ���Ա������˻������ϵ�绰������ */
    private String insuredPhone = "";
    /** ���Ի���鿱��˾ */
    private String cargoLossCheckCom = "";
    /** ���Ի�������ʧ���� */
    private String cargoLossType = "";
    /** ���Թ�������ʦ */
    private String shareClaimer = "";
    /** ���Ծ����� */
    private String salvor = "";
    /** �����Ƿ���Ҫ���µ��� */
    private String guaranteeFlag = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ի��� */
    private double cargoValue = 0D;
    /** ���Ծ���������� */
    private double salvaGuarantAmount = 0D;
    /** ���Բ�ֵ���� */
    private int restQuantity = 0;
    /** ���Ե����� */
    private String guarantor = "";
    /** ����Ԥ���ֶ�1 */
    private String value1 = "";
    /** ����Ԥ���ֶ�2 */
    private String value2 = "";
    /** ����Ԥ���ֶ�3 */
    private String value3 = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLextDtoBase����
     */
    public PrpLextDtoBase(){
    }

    /**
     * �������Ե���
     * @param certiNo �����õ����Ե��ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե���
     * @return ���Ե��ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ե�������
     * @param certiType �����õ����Ե������͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * �������Ե�����������
     * @param personDeathB �����õ����Ե�������������ֵ
     */
    public void setPersonDeathB(long personDeathB){
        this.personDeathB = personDeathB;
    }

    /**
     * ��ȡ���Ե�����������
     * @return ���Ե�������������ֵ
     */
    public long getPersonDeathB(){
        return personDeathB;
    }

    /**
     * �������Գ�����Ա������
     * @param personDeathD1 �����õ����Գ�����Ա��������ֵ
     */
    public void setPersonDeathD1(long personDeathD1){
        this.personDeathD1 = personDeathD1;
    }

    /**
     * ��ȡ���Գ�����Ա������
     * @return ���Գ�����Ա��������ֵ
     */
    public long getPersonDeathD1(){
        return personDeathD1;
    }

    /**
     * �������Ե�����������
     * @param personInjureB �����õ����Ե�������������ֵ
     */
    public void setPersonInjureB(long personInjureB){
        this.personInjureB = personInjureB;
    }

    /**
     * ��ȡ���Ե�����������
     * @return ���Ե�������������ֵ
     */
    public long getPersonInjureB(){
        return personInjureB;
    }

    /**
     * �������Գ�����Ա������
     * @param personInjureD1 �����õ����Գ�����Ա��������ֵ
     */
    public void setPersonInjureD1(long personInjureD1){
        this.personInjureD1 = personInjureD1;
    }

    /**
     * ��ȡ���Գ�����Ա������
     * @return ���Գ�����Ա��������ֵ
     */
    public long getPersonInjureD1(){
        return personInjureD1;
    }

    /**
     * �������Գ�����
     * @param carrier �����õ����Գ����˵�ֵ
     */
    public void setCarrier(String carrier){
        this.carrier = StringUtils.rightTrim(carrier);
    }

    /**
     * ��ȡ���Գ�����
     * @return ���Գ����˵�ֵ
     */
    public String getCarrier(){
        return carrier;
    }

    /**
     * �������Կ�������
     * @param sailStartDate �����õ����Կ������ڵ�ֵ
     */
    public void setSailStartDate(DateTime sailStartDate){
        this.sailStartDate = sailStartDate;
    }

    /**
     * ��ȡ���Կ�������
     * @return ���Կ������ڵ�ֵ
     */
    public DateTime getSailStartDate(){
        return sailStartDate;
    }

    /**
     * ��������ж������
     * @param unloadDate �����õ�����ж�����ڵ�ֵ
     */
    public void setUnloadDate(DateTime unloadDate){
        this.unloadDate = unloadDate;
    }

    /**
     * ��ȡ����ж������
     * @return ����ж�����ڵ�ֵ
     */
    public DateTime getUnloadDate(){
        return unloadDate;
    }

    /**
     * ������������鿱����
     * @param appliCheckDate �����õ���������鿱���ڵ�ֵ
     */
    public void setAppliCheckDate(DateTime appliCheckDate){
        this.appliCheckDate = appliCheckDate;
    }

    /**
     * ��ȡ��������鿱����
     * @return ��������鿱���ڵ�ֵ
     */
    public DateTime getAppliCheckDate(){
        return appliCheckDate;
    }

    /**
     * ��������Ͷ���˻������ϵ�绰������
     * @param appliPhone �����õ�����Ͷ���˻������ϵ�绰�������ֵ
     */
    public void setAppliPhone(String appliPhone){
        this.appliPhone = appliPhone;
    }

    /**
     * ��ȡ����Ͷ���˻������ϵ�绰������
     * @return ����Ͷ���˻������ϵ�绰�������ֵ
     */
    public String getAppliPhone(){
        return appliPhone;
    }

    /**
     * �������Ա������˻������ϵ�绰������
     * @param insuredPhone �����õ����Ա������˻������ϵ�绰�������ֵ
     */
    public void setInsuredPhone(String insuredPhone){
        this.insuredPhone = insuredPhone;
    }

    /**
     * ��ȡ���Ա������˻������ϵ�绰������
     * @return ���Ա������˻������ϵ�绰�������ֵ
     */
    public String getInsuredPhone(){
        return insuredPhone;
    }

    /**
     * �������Ի���鿱��˾
     * @param cargoLossCheckCom �����õ����Ի���鿱��˾��ֵ
     */
    public void setCargoLossCheckCom(String cargoLossCheckCom){
        this.cargoLossCheckCom = StringUtils.rightTrim(cargoLossCheckCom);
    }

    /**
     * ��ȡ���Ի���鿱��˾
     * @return ���Ի���鿱��˾��ֵ
     */
    public String getCargoLossCheckCom(){
        return cargoLossCheckCom;
    }

    /**
     * �������Ի�������ʧ����
     * @param cargoLossType �����õ����Ի�������ʧ���͵�ֵ
     */
    public void setCargoLossType(String cargoLossType){
        this.cargoLossType = StringUtils.rightTrim(cargoLossType);
    }

    /**
     * ��ȡ���Ի�������ʧ����
     * @return ���Ի�������ʧ���͵�ֵ
     */
    public String getCargoLossType(){
        return cargoLossType;
    }

    /**
     * �������Թ�������ʦ
     * @param shareClaimer �����õ����Թ�������ʦ��ֵ
     */
    public void setShareClaimer(String shareClaimer){
        this.shareClaimer = StringUtils.rightTrim(shareClaimer);
    }

    /**
     * ��ȡ���Թ�������ʦ
     * @return ���Թ�������ʦ��ֵ
     */
    public String getShareClaimer(){
        return shareClaimer;
    }

    /**
     * �������Ծ�����
     * @param salvor �����õ����Ծ����˵�ֵ
     */
    public void setSalvor(String salvor){
        this.salvor = StringUtils.rightTrim(salvor);
    }

    /**
     * ��ȡ���Ծ�����
     * @return ���Ծ����˵�ֵ
     */
    public String getSalvor(){
        return salvor;
    }

    /**
     * ���������Ƿ���Ҫ���µ���
     * @param guaranteeFlag �����õ������Ƿ���Ҫ���µ�����ֵ
     */
    public void setGuaranteeFlag(String guaranteeFlag){
        this.guaranteeFlag = StringUtils.rightTrim(guaranteeFlag);
    }

    /**
     * ��ȡ�����Ƿ���Ҫ���µ���
     * @return �����Ƿ���Ҫ���µ�����ֵ
     */
    public String getGuaranteeFlag(){
        return guaranteeFlag;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ի���
     * @param cargoValue �����õ����Ի��۵�ֵ
     */
    public void setCargoValue(double cargoValue){
        this.cargoValue = cargoValue;
    }

    /**
     * ��ȡ���Ի���
     * @return ���Ի��۵�ֵ
     */
    public double getCargoValue(){
        return cargoValue;
    }

    /**
     * �������Ծ����������
     * @param salvaGuarantAmount �����õ����Ծ�����������ֵ
     */
    public void setSalvaGuarantAmount(double salvaGuarantAmount){
        this.salvaGuarantAmount = salvaGuarantAmount;
    }

    /**
     * ��ȡ���Ծ����������
     * @return ���Ծ�����������ֵ
     */
    public double getSalvaGuarantAmount(){
        return salvaGuarantAmount;
    }

    /**
     * �������Բ�ֵ����
     * @param restQuantity �����õ����Բ�ֵ������ֵ
     */
    public void setRestQuantity(int restQuantity){
        this.restQuantity = restQuantity;
    }

    /**
     * ��ȡ���Բ�ֵ����
     * @return ���Բ�ֵ������ֵ
     */
    public int getRestQuantity(){
        return restQuantity;
    }

    /**
     * �������Ե�����
     * @param guarantor �����õ����Ե����˵�ֵ
     */
    public void setGuarantor(String guarantor){
        this.guarantor = StringUtils.rightTrim(guarantor);
    }

    /**
     * ��ȡ���Ե�����
     * @return ���Ե����˵�ֵ
     */
    public String getGuarantor(){
        return guarantor;
    }

    /**
     * ��������Ԥ���ֶ�1
     * @param value1 �����õ�����Ԥ���ֶ�1��ֵ
     */
    public void setValue1(String value1){
        this.value1 = StringUtils.rightTrim(value1);
    }

    /**
     * ��ȡ����Ԥ���ֶ�1
     * @return ����Ԥ���ֶ�1��ֵ
     */
    public String getValue1(){
        return value1;
    }

    /**
     * ��������Ԥ���ֶ�2
     * @param value2 �����õ�����Ԥ���ֶ�2��ֵ
     */
    public void setValue2(String value2){
        this.value2 = StringUtils.rightTrim(value2);
    }

    /**
     * ��ȡ����Ԥ���ֶ�2
     * @return ����Ԥ���ֶ�2��ֵ
     */
    public String getValue2(){
        return value2;
    }

    /**
     * ��������Ԥ���ֶ�3
     * @param value3 �����õ�����Ԥ���ֶ�3��ֵ
     */
    public void setValue3(String value3){
        this.value3 = StringUtils.rightTrim(value3);
    }

    /**
     * ��ȡ����Ԥ���ֶ�3
     * @return ����Ԥ���ֶ�3��ֵ
     */
    public String getValue3(){
        return value3;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
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
