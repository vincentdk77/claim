package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcarmodel���ʹ�������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcarModelDtoBase implements Serializable{
    /** ���Գ��ʹ��� */
    private String modelCode = "";
    /** �����ٲ������� */
    private String shortHandCode = "";
    /** ���Գ������� */
    private String modelName = "";
    /** ���Գ�ϵ���� */
    private String carSeriesName = "";
    /** ������λ�� */
    private int seatCount = 0;
    /** ���Զ�λ�� */
    private double tonCount = 0d;
    /** ������������ */
    private String factory = "";
    /** �����������Ҵ��� */
    private String countryCode = "";
    /** �����³����ü۸� */
    private double purchasePrice = 0d;
    /** ����ʹ�����ַ�Χ */
    private String riskScope = "";
    /** ������������ */
    private DateTime validDate = new DateTime();
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ����״̬λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcarModelDtoBase����
     */
    public PrpDcarModelDtoBase(){
    }

    /**
     * �������Գ��ʹ���
     * @param modelCode �����õ����Գ��ʹ����ֵ
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * ��ȡ���Գ��ʹ���
     * @return ���Գ��ʹ����ֵ
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * ���������ٲ�������
     * @param shortHandCode �����õ������ٲ��������ֵ
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * ��ȡ�����ٲ�������
     * @return �����ٲ��������ֵ
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * �������Գ�������
     * @param modelName �����õ����Գ������Ƶ�ֵ
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������Ƶ�ֵ
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * �������Գ�ϵ����
     * @param carSeriesName �����õ����Գ�ϵ���Ƶ�ֵ
     */
    public void setCarSeriesName(String carSeriesName){
        this.carSeriesName = StringUtils.rightTrim(carSeriesName);
    }

    /**
     * ��ȡ���Գ�ϵ����
     * @return ���Գ�ϵ���Ƶ�ֵ
     */
    public String getCarSeriesName(){
        return carSeriesName;
    }

    /**
     * ����������λ��
     * @param seatCount �����õ�������λ����ֵ
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * ��ȡ������λ��
     * @return ������λ����ֵ
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * �������Զ�λ��
     * @param tonCount �����õ����Զ�λ����ֵ
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * ��ȡ���Զ�λ��
     * @return ���Զ�λ����ֵ
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * ����������������
     * @param factory �����õ������������ҵ�ֵ
     */
    public void setFactory(String factory){
        this.factory = StringUtils.rightTrim(factory);
    }

    /**
     * ��ȡ������������
     * @return �����������ҵ�ֵ
     */
    public String getFactory(){
        return factory;
    }

    /**
     * ���������������Ҵ���
     * @param countryCode �����õ������������Ҵ����ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ�����������Ҵ���
     * @return �����������Ҵ����ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * ���������³����ü۸�
     * @param purchasePrice �����õ������³����ü۸��ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ�����³����ü۸�
     * @return �����³����ü۸��ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * ��������ʹ�����ַ�Χ
     * @param riskScope �����õ�����ʹ�����ַ�Χ��ֵ
     */
    public void setRiskScope(String riskScope){
        this.riskScope = StringUtils.rightTrim(riskScope);
    }

    /**
     * ��ȡ����ʹ�����ַ�Χ
     * @return ����ʹ�����ַ�Χ��ֵ
     */
    public String getRiskScope(){
        return riskScope;
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
