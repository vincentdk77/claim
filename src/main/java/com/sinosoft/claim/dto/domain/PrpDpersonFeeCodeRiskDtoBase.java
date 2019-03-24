package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDpersonFeeCodeRisk-���˷������ֶ��ձ�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDpersonFeeCodeRiskDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է��ô��� */
    private String feeCode = "";
    /** ����������� */
    private String feeCategory = "";
    /** ����ǿ�Ʊ������ȼ� */
    private int priority = 0;
    /** ������Ч״̬λ */
    private int validStatus = 0;
    /** ������Ч���� */
    private DateTime validDate = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDpersonFeeCodeRiskDtoBase����
     */
    public PrpDpersonFeeCodeRiskDtoBase(){
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
     * �������Է��ô���
     * @param feeCode �����õ����Է��ô����ֵ
     */
    public void setFeeCode(String feeCode){
        this.feeCode = StringUtils.rightTrim(feeCode);
    }

    /**
     * ��ȡ���Է��ô���
     * @return ���Է��ô����ֵ
     */
    public String getFeeCode(){
        return feeCode;
    }

    /**
     * ���������������
     * @param feeCategory �����õ�������������ֵ
     */
    public void setFeeCategory(String feeCategory){
        this.feeCategory = StringUtils.rightTrim(feeCategory);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getFeeCategory(){
        return feeCategory;
    }

    /**
     * ��������ǿ�Ʊ������ȼ�
     * @param priority �����õ�����ǿ�Ʊ������ȼ���ֵ
     */
    public void setPriority(int priority){
        this.priority = priority;
    }

    /**
     * ��ȡ����ǿ�Ʊ������ȼ�
     * @return ����ǿ�Ʊ������ȼ���ֵ
     */
    public int getPriority(){
        return priority;
    }

    /**
     * ����������Ч״̬λ
     * @param validStatus �����õ�������Ч״̬λ��ֵ
     */
    public void setValidStatus(int validStatus){
        this.validStatus = validStatus;
    }

    /**
     * ��ȡ������Ч״̬λ
     * @return ������Ч״̬λ��ֵ
     */
    public int getValidStatus(){
        return validStatus;
    }

    /**
     * ����������Ч����
     * @param validDate �����õ�������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������Ч����
     * @return ������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }
}
