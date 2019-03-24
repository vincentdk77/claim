package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpldealinfo�����ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLdealinfoDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա����� */
    private String reportName = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Գ��ձ����ϸ���� */
    private String itemName = "";
    /** ���Թ������� */
    private String comCode = "";
    /** ���Դ������� */
    private DateTime dealDate = new DateTime();
    /** ���Դ���ʱ�� */
    private int dealHour = 0;
    /** ���Ա������� */
    private DateTime reportDate = new DateTime();
    /** ���Գб���˾�绰 */
    private String insurePhoneNumber = "";
    /** ����������Ա */
    private String acceptName = "";
    /** ������ϯ */
    private String seatNo = "";
    /** ���Զ�����Ա */
    private String defLossName = "";
    /** ���Զ�����Ա�绰 */
    private String checkPhoneNumber = "";
    /** ���Զ���������� */
    private DateTime checkStartDate = new DateTime();
    /** ���Զ������ʱ�� */
    private int checkStartHour = 0;
    /** ���Դ������ */
    private String dealStatus = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdealinfoDtoBase����
     */
    public PrpLdealinfoDtoBase(){
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Ա�����
     * @param reportName �����õ����Ա����˵�ֵ
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����˵�ֵ
     */
    public String getReportName(){
        return reportName;
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
     * �������Գ��ձ����ϸ����
     * @param itemName �����õ����Գ��ձ����ϸ���Ƶ�ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ���Գ��ձ����ϸ����
     * @return ���Գ��ձ����ϸ���Ƶ�ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * �������Թ�������
     * @param comCode �����õ����Թ������ŵ�ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������ŵ�ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Դ�������
     * @param dealDate �����õ����Դ������ڵ�ֵ
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������ڵ�ֵ
     */
    public DateTime getDealDate(){
        return dealDate;
    }

    /**
     * �������Դ���ʱ��
     * @param dealHour �����õ����Դ���ʱ���ֵ
     */
    public void setDealHour(int dealHour){
        this.dealHour = dealHour;
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ���ֵ
     */
    public int getDealHour(){
        return dealHour;
    }

    /**
     * �������Ա�������
     * @param reportDate �����õ����Ա������ڵ�ֵ
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������ڵ�ֵ
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * �������Գб���˾�绰
     * @param insurePhoneNumber �����õ����Գб���˾�绰��ֵ
     */
    public void setInsurePhoneNumber(String insurePhoneNumber){
        this.insurePhoneNumber = StringUtils.rightTrim(insurePhoneNumber);
    }

    /**
     * ��ȡ���Գб���˾�绰
     * @return ���Գб���˾�绰��ֵ
     */
    public String getInsurePhoneNumber(){
        return insurePhoneNumber;
    }

    /**
     * ��������������Ա
     * @param acceptName �����õ�����������Ա��ֵ
     */
    public void setAcceptName(String acceptName){
        this.acceptName = StringUtils.rightTrim(acceptName);
    }

    /**
     * ��ȡ����������Ա
     * @return ����������Ա��ֵ
     */
    public String getAcceptName(){
        return acceptName;
    }

    /**
     * ����������ϯ
     * @param seatNo �����õ�������ϯ��ֵ
     */
    public void setSeatNo(String seatNo){
        this.seatNo = StringUtils.rightTrim(seatNo);
    }

    /**
     * ��ȡ������ϯ
     * @return ������ϯ��ֵ
     */
    public String getSeatNo(){
        return seatNo;
    }

    /**
     * �������Զ�����Ա
     * @param defLossName �����õ����Զ�����Ա��ֵ
     */
    public void setDefLossName(String defLossName){
        this.defLossName = StringUtils.rightTrim(defLossName);
    }

    /**
     * ��ȡ���Զ�����Ա
     * @return ���Զ�����Ա��ֵ
     */
    public String getDefLossName(){
        return defLossName;
    }

    /**
     * �������Զ�����Ա�绰
     * @param checkPhoneNumber �����õ����Զ�����Ա�绰��ֵ
     */
    public void setCheckPhoneNumber(String checkPhoneNumber){
        this.checkPhoneNumber = StringUtils.rightTrim(checkPhoneNumber);
    }

    /**
     * ��ȡ���Զ�����Ա�绰
     * @return ���Զ�����Ա�绰��ֵ
     */
    public String getCheckPhoneNumber(){
        return checkPhoneNumber;
    }

    /**
     * �������Զ����������
     * @param checkStartDate �����õ����Զ���������ڵ�ֵ
     */
    public void setCheckStartDate(DateTime checkStartDate){
        this.checkStartDate = checkStartDate;
    }

    /**
     * ��ȡ���Զ����������
     * @return ���Զ���������ڵ�ֵ
     */
    public DateTime getCheckStartDate(){
        return checkStartDate;
    }

    /**
     * �������Զ������ʱ��
     * @param checkStartHour �����õ����Զ������ʱ���ֵ
     */
    public void setCheckStartHour(int checkStartHour){
        this.checkStartHour = checkStartHour;
    }

    /**
     * ��ȡ���Զ������ʱ��
     * @return ���Զ������ʱ���ֵ
     */
    public int getCheckStartHour(){
        return checkStartHour;
    }

    /**
     * �������Դ������
     * @param dealStatus �����õ����Դ��������ֵ
     */
    public void setDealStatus(String dealStatus){
        this.dealStatus = StringUtils.rightTrim(dealStatus);
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ��������ֵ
     */
    public String getDealStatus(){
        return dealStatus;
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
