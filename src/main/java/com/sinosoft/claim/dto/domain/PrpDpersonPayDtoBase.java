package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdpersonpay��ͨ�¹����⳥�����׼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDpersonPayDtoBase implements Serializable{
    /** ������� */
    private int serialNo = 0;
    /** �����⳥��Ŀ���� */
    private String payItemCode = "";
    /** ���Գ��յ������� */
    private String damageAreaCode = "";
    /** ������ҵ���� */
    private String businessSource = "";
    /** ���Ա�׼��� */
    private double standardFee = 0d;
    /** ���Է������� */
    private DateTime issueDate = new DateTime();
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDpersonPayDtoBase����
     */
    public PrpDpersonPayDtoBase(){
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
     * ���������⳥��Ŀ����
     * @param payItemCode �����õ������⳥��Ŀ�����ֵ
     */
    public void setPayItemCode(String payItemCode){
        this.payItemCode = StringUtils.rightTrim(payItemCode);
    }

    /**
     * ��ȡ�����⳥��Ŀ����
     * @return �����⳥��Ŀ�����ֵ
     */
    public String getPayItemCode(){
        return payItemCode;
    }

    /**
     * �������Գ��յ�������
     * @param damageAreaCode �����õ����Գ��յ��������ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ���Գ��յ�������
     * @return ���Գ��յ��������ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
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
     * �������Ա�׼���
     * @param standardFee �����õ����Ա�׼����ֵ
     */
    public void setStandardFee(double standardFee){
        this.standardFee = standardFee;
    }

    /**
     * ��ȡ���Ա�׼���
     * @return ���Ա�׼����ֵ
     */
    public double getStandardFee(){
        return standardFee;
    }

    /**
     * �������Է�������
     * @param issueDate �����õ����Է������ڵ�ֵ
     */
    public void setIssueDate(DateTime issueDate){
        this.issueDate = issueDate;
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������ڵ�ֵ
     */
    public DateTime getIssueDate(){
        return issueDate;
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
