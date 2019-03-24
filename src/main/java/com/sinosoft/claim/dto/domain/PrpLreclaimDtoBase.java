package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLreclaim-���������Ϣ������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreclaimDtoBase implements Serializable{
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �������������Ŀ��� */
    private String itemCode = "";
    /** �������������Ŀ���� */
    private String itemName = "";
    /** ���Ե�Ѻ������ */
    private String guarantyName = "";
    /** ���Ե�Ѻ�ﴦ��ʽ */
    private String dealWay = "";
    /** ���Աұ� */
    private String currency = "";
    /** �������� */
    private int reclaimCount = 0;
    /** ���������� */
    private double lossFee = 0d;
    /** ���Խ��׷��� */
    private double bargainFee = 0d;
    /** ���Ա�ȫ�Ʋ����� */
    private String propProtectName = "";
    /** ���Ա�ȫ�Ʋ����� */
    private double propProtectFee = 0d;
    /** ���Ի��ս�� */
    private double reclaimFee = 0d;
    /** ���Ի������� */
    private DateTime reclaimDate = new DateTime();
    /** ����̯����ʽ��
--** 1:׷����
--** 2:�����
--** 9:���� */
    private String amortizeWay = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Դ�������
--** [1]0�����ǰ�����Ѻ��
--**  1���������Ѻ�� */
    private String dealType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLreclaimDtoBase����
     */
    public PrpLreclaimDtoBase(){
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �����������������Ŀ���
     * @param itemCode �����õ��������������Ŀ����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ�������������Ŀ���
     * @return �������������Ŀ����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �����������������Ŀ����
     * @param itemName �����õ��������������Ŀ���Ƶ�ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ�������������Ŀ����
     * @return �������������Ŀ���Ƶ�ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * �������Ե�Ѻ������
     * @param guarantyName �����õ����Ե�Ѻ�����Ƶ�ֵ
     */
    public void setGuarantyName(String guarantyName){
        this.guarantyName = StringUtils.rightTrim(guarantyName);
    }

    /**
     * ��ȡ���Ե�Ѻ������
     * @return ���Ե�Ѻ�����Ƶ�ֵ
     */
    public String getGuarantyName(){
        return guarantyName;
    }

    /**
     * �������Ե�Ѻ�ﴦ��ʽ
     * @param dealWay �����õ����Ե�Ѻ�ﴦ��ʽ��ֵ
     */
    public void setDealWay(String dealWay){
        this.dealWay = StringUtils.rightTrim(dealWay);
    }

    /**
     * ��ȡ���Ե�Ѻ�ﴦ��ʽ
     * @return ���Ե�Ѻ�ﴦ��ʽ��ֵ
     */
    public String getDealWay(){
        return dealWay;
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
     * ������������
     * @param reclaimCount �����õ�����������ֵ
     */
    public void setReclaimCount(int reclaimCount){
        this.reclaimCount = reclaimCount;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public int getReclaimCount(){
        return reclaimCount;
    }

    /**
     * ��������������
     * @param lossFee �����õ������������ֵ
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * ��ȡ����������
     * @return �����������ֵ
     */
    public double getLossFee(){
        return lossFee;
    }

    /**
     * �������Խ��׷���
     * @param bargainFee �����õ����Խ��׷��õ�ֵ
     */
    public void setBargainFee(double bargainFee){
        this.bargainFee = bargainFee;
    }

    /**
     * ��ȡ���Խ��׷���
     * @return ���Խ��׷��õ�ֵ
     */
    public double getBargainFee(){
        return bargainFee;
    }

    /**
     * �������Ա�ȫ�Ʋ�����
     * @param propProtectName �����õ����Ա�ȫ�Ʋ����Ƶ�ֵ
     */
    public void setPropProtectName(String propProtectName){
        this.propProtectName = StringUtils.rightTrim(propProtectName);
    }

    /**
     * ��ȡ���Ա�ȫ�Ʋ�����
     * @return ���Ա�ȫ�Ʋ����Ƶ�ֵ
     */
    public String getPropProtectName(){
        return propProtectName;
    }

    /**
     * �������Ա�ȫ�Ʋ�����
     * @param propProtectFee �����õ����Ա�ȫ�Ʋ����õ�ֵ
     */
    public void setPropProtectFee(double propProtectFee){
        this.propProtectFee = propProtectFee;
    }

    /**
     * ��ȡ���Ա�ȫ�Ʋ�����
     * @return ���Ա�ȫ�Ʋ����õ�ֵ
     */
    public double getPropProtectFee(){
        return propProtectFee;
    }

    /**
     * �������Ի��ս��
     * @param reclaimFee �����õ����Ի��ս���ֵ
     */
    public void setReclaimFee(double reclaimFee){
        this.reclaimFee = reclaimFee;
    }

    /**
     * ��ȡ���Ի��ս��
     * @return ���Ի��ս���ֵ
     */
    public double getReclaimFee(){
        return reclaimFee;
    }

    /**
     * �������Ի�������
     * @param reclaimDate �����õ����Ի������ڵ�ֵ
     */
    public void setReclaimDate(DateTime reclaimDate){
        this.reclaimDate = reclaimDate;
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������ڵ�ֵ
     */
    public DateTime getReclaimDate(){
        return reclaimDate;
    }

    /**
     * ��������̯����ʽ��
--** 1:׷����
--** 2:�����
--** 9:����
     * @param amortizeWay �����õ�����̯����ʽ��
--** 1:׷����
--** 2:�����
--** 9:������ֵ
     */
    public void setAmortizeWay(String amortizeWay){
        this.amortizeWay = StringUtils.rightTrim(amortizeWay);
    }

    /**
     * ��ȡ����̯����ʽ��
--** 1:׷����
--** 2:�����
--** 9:����
     * @return ����̯����ʽ��
--** 1:׷����
--** 2:�����
--** 9:������ֵ
     */
    public String getAmortizeWay(){
        return amortizeWay;
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
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Դ�������
--** [1]0�����ǰ�����Ѻ��
--**  1���������Ѻ��
     * @param dealType �����õ����Դ�������
--** [1]0�����ǰ�����Ѻ��
--**  1���������Ѻ���ֵ
     */
    public void setDealType(String dealType){
        this.dealType = StringUtils.rightTrim(dealType);
    }

    /**
     * ��ȡ���Դ�������
--** [1]0�����ǰ�����Ѻ��
--**  1���������Ѻ��
     * @return ���Դ�������
--** [1]0�����ǰ�����Ѻ��
--**  1���������Ѻ���ֵ
     */
    public String getDealType(){
        return dealType;
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
