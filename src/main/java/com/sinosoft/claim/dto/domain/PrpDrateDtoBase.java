package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrate��׼���ʱ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateDtoBase implements Serializable{
    /** ������� */
    private int serialNo = 0;
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Ի������� */
    private String comCode = "";
    /** ����ռ������ */
    private String possessNature = "";
    /** ������ҵ���� */
    private String businessSource = "";
    /** ����Ӫҵ���ʴ��� */
    private String businessDetail = "";
    /** ���Ա����Ŀ���� */
    private String itemCode = "";
    /** ���Ա����Ŀ���� */
    private String itemName = "";
    /** ���Գб����� */
    private int years = 0;
    /** ���������Ӫҵ�� */
    private double preturnOver = 0d;
    /** �����޶����� */
    private String limitType = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����⳥�޶����� */
    private double limitFeeLower = 0d;
    /** �����⳥�޶����� */
    private double limitFeeUpper = 0d;
    /** ���Ի����������� */
    private double baseRateLower = 0d;
    /** ���Ի����������� */
    private double baseRateUpper = 0d;
    /** ���Է��ʱ��� */
    private double rateRatio = 0d;
    /** ���Ա��� */
    private double premium = 0d;
    /** ���Է��ʴ��� */
    private String rateCode = "";
    /** ������������ */
    private DateTime validDate = new DateTime();
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ����״̬λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateDtoBase����
     */
    public PrpDrateDtoBase(){
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
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������ռ������
     * @param possessNature �����õ�����ռ�����ʵ�ֵ
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * ��ȡ����ռ������
     * @return ����ռ�����ʵ�ֵ
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * ����������ҵ����
     * @param businessSource �����õ�������ҵ�����ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ������ҵ����
     * @return ������ҵ�����ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * ��������Ӫҵ���ʴ���
     * @param businessDetail �����õ�����Ӫҵ���ʴ����ֵ
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * ��ȡ����Ӫҵ���ʴ���
     * @return ����Ӫҵ���ʴ����ֵ
     */
    public String getBusinessDetail(){
        return businessDetail;
    }

    /**
     * �������Ա����Ŀ����
     * @param itemCode �����õ����Ա����Ŀ�����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա����Ŀ����
     * @return ���Ա����Ŀ�����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Ա����Ŀ����
     * @param itemName �����õ����Ա����Ŀ���Ƶ�ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ���Ա����Ŀ����
     * @return ���Ա����Ŀ���Ƶ�ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * �������Գб�����
     * @param years �����õ����Գб����޵�ֵ
     */
    public void setYears(int years){
        this.years = years;
    }

    /**
     * ��ȡ���Գб�����
     * @return ���Գб����޵�ֵ
     */
    public int getYears(){
        return years;
    }

    /**
     * �������������Ӫҵ��
     * @param preturnOver �����õ����������Ӫҵ���ֵ
     */
    public void setPreturnOver(double preturnOver){
        this.preturnOver = preturnOver;
    }

    /**
     * ��ȡ���������Ӫҵ��
     * @return ���������Ӫҵ���ֵ
     */
    public double getPreturnOver(){
        return preturnOver;
    }

    /**
     * ���������޶�����
     * @param limitType �����õ������޶����͵�ֵ
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * ��ȡ�����޶�����
     * @return �����޶����͵�ֵ
     */
    public String getLimitType(){
        return limitType;
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
     * ���������⳥�޶�����
     * @param limitFeeLower �����õ������⳥�޶����޵�ֵ
     */
    public void setLimitFeeLower(double limitFeeLower){
        this.limitFeeLower = limitFeeLower;
    }

    /**
     * ��ȡ�����⳥�޶�����
     * @return �����⳥�޶����޵�ֵ
     */
    public double getLimitFeeLower(){
        return limitFeeLower;
    }

    /**
     * ���������⳥�޶�����
     * @param limitFeeUpper �����õ������⳥�޶����޵�ֵ
     */
    public void setLimitFeeUpper(double limitFeeUpper){
        this.limitFeeUpper = limitFeeUpper;
    }

    /**
     * ��ȡ�����⳥�޶�����
     * @return �����⳥�޶����޵�ֵ
     */
    public double getLimitFeeUpper(){
        return limitFeeUpper;
    }

    /**
     * �������Ի�����������
     * @param baseRateLower �����õ����Ի����������޵�ֵ
     */
    public void setBaseRateLower(double baseRateLower){
        this.baseRateLower = baseRateLower;
    }

    /**
     * ��ȡ���Ի�����������
     * @return ���Ի����������޵�ֵ
     */
    public double getBaseRateLower(){
        return baseRateLower;
    }

    /**
     * �������Ի�����������
     * @param baseRateUpper �����õ����Ի����������޵�ֵ
     */
    public void setBaseRateUpper(double baseRateUpper){
        this.baseRateUpper = baseRateUpper;
    }

    /**
     * ��ȡ���Ի�����������
     * @return ���Ի����������޵�ֵ
     */
    public double getBaseRateUpper(){
        return baseRateUpper;
    }

    /**
     * �������Է��ʱ���
     * @param rateRatio �����õ����Է��ʱ��ʵ�ֵ
     */
    public void setRateRatio(double rateRatio){
        this.rateRatio = rateRatio;
    }

    /**
     * ��ȡ���Է��ʱ���
     * @return ���Է��ʱ��ʵ�ֵ
     */
    public double getRateRatio(){
        return rateRatio;
    }

    /**
     * �������Ա���
     * @param premium �����õ����Ա��ѵ�ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��ѵ�ֵ
     */
    public double getPremium(){
        return premium;
    }

    /**
     * �������Է��ʴ���
     * @param rateCode �����õ����Է��ʴ����ֵ
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * ��ȡ���Է��ʴ���
     * @return ���Է��ʴ����ֵ
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * ����������������
     * @param validDate �����õ������������ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������״̬λ
     * @param flag �����õ�����״̬λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬λ
     * @return ����״̬λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
