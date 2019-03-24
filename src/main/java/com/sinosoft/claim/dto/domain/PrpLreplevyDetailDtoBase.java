package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLreplevyDetail-Ȩ��ת�ü�׷����Ϣ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreplevyDetailDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Դ��� */
    private int times = 0;
    /** ������� */
    private int serialNo = 0;
    /** ����׷�����ʹ��� */
    private String replevyTypeCode = "";
    /** ����Ȩ��ת������ */
    private DateTime rightTransferDate = new DateTime();
    /** ���Ա�׷�������� */
    private String repleviedName = "";
    /** ����׷��ԭ�� */
    private String replevyReason = "";
    /** ����׷����Ŀ��� */
    private String itemCode = "";
    /** ����׷����Ŀ���� */
    private String itemName = "";
    /** ���Աұ� */
    private String currency = "";
    /** ����׷����� */
    private double replevyFee = 0d;
    /** ������׷�ؽ�� */
    private double validFee = 0d;
    /** ����ReplevyCharge */
    private double replevyCharge = 0d;
    /** ����׷������ */
    private DateTime reclaimDate = new DateTime();
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Ա�ע */
    private String note = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLreplevyDetailDtoBase����
     */
    public PrpLreplevyDetailDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
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
     * �������Դ���
     * @param times �����õ����Դ�����ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public int getTimes(){
        return times;
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
     * ��������׷�����ʹ���
     * @param replevyTypeCode �����õ�����׷�����ʹ����ֵ
     */
    public void setReplevyTypeCode(String replevyTypeCode){
        this.replevyTypeCode = StringUtils.rightTrim(replevyTypeCode);
    }

    /**
     * ��ȡ����׷�����ʹ���
     * @return ����׷�����ʹ����ֵ
     */
    public String getReplevyTypeCode(){
        return replevyTypeCode;
    }

    /**
     * ��������Ȩ��ת������
     * @param rightTransferDate �����õ�����Ȩ��ת�����ڵ�ֵ
     */
    public void setRightTransferDate(DateTime rightTransferDate){
        this.rightTransferDate = rightTransferDate;
    }

    /**
     * ��ȡ����Ȩ��ת������
     * @return ����Ȩ��ת�����ڵ�ֵ
     */
    public DateTime getRightTransferDate(){
        return rightTransferDate;
    }

    /**
     * �������Ա�׷��������
     * @param repleviedName �����õ����Ա�׷�������Ƶ�ֵ
     */
    public void setRepleviedName(String repleviedName){
        this.repleviedName = StringUtils.rightTrim(repleviedName);
    }

    /**
     * ��ȡ���Ա�׷��������
     * @return ���Ա�׷�������Ƶ�ֵ
     */
    public String getRepleviedName(){
        return repleviedName;
    }

    /**
     * ��������׷��ԭ��
     * @param replevyReason �����õ�����׷��ԭ���ֵ
     */
    public void setReplevyReason(String replevyReason){
        this.replevyReason = StringUtils.rightTrim(replevyReason);
    }

    /**
     * ��ȡ����׷��ԭ��
     * @return ����׷��ԭ���ֵ
     */
    public String getReplevyReason(){
        return replevyReason;
    }

    /**
     * ��������׷����Ŀ���
     * @param itemCode �����õ�����׷����Ŀ����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����׷����Ŀ���
     * @return ����׷����Ŀ����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������׷����Ŀ����
     * @param itemName �����õ�����׷����Ŀ���Ƶ�ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ����׷����Ŀ����
     * @return ����׷����Ŀ���Ƶ�ֵ
     */
    public String getItemName(){
        return itemName;
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
     * ��������׷�����
     * @param replevyFee �����õ�����׷������ֵ
     */
    public void setReplevyFee(double replevyFee){
        this.replevyFee = replevyFee;
    }

    /**
     * ��ȡ����׷�����
     * @return ����׷������ֵ
     */
    public double getReplevyFee(){
        return replevyFee;
    }

    /**
     * ����������׷�ؽ��
     * @param validFee �����õ�������׷�ؽ���ֵ
     */
    public void setValidFee(double validFee){
        this.validFee = validFee;
    }

    /**
     * ��ȡ������׷�ؽ��
     * @return ������׷�ؽ���ֵ
     */
    public double getValidFee(){
        return validFee;
    }

    /**
     * ��������ReplevyCharge
     * @param replevyCharge �����õ�����ReplevyCharge��ֵ
     */
    public void setReplevyCharge(double replevyCharge){
        this.replevyCharge = replevyCharge;
    }

    /**
     * ��ȡ����ReplevyCharge
     * @return ����ReplevyCharge��ֵ
     */
    public double getReplevyCharge(){
        return replevyCharge;
    }

    /**
     * ��������׷������
     * @param reclaimDate �����õ�����׷�����ڵ�ֵ
     */
    public void setReclaimDate(DateTime reclaimDate){
        this.reclaimDate = reclaimDate;
    }

    /**
     * ��ȡ����׷������
     * @return ����׷�����ڵ�ֵ
     */
    public DateTime getReclaimDate(){
        return reclaimDate;
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
     * �������Ա�ע
     * @param note �����õ����Ա�ע��ֵ
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getNote(){
        return note;
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
