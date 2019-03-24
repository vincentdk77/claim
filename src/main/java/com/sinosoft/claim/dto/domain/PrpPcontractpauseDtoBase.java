package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpPcontractpause��ֹ���պ�ͬ��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPcontractpauseDtoBase implements Serializable{
    /** ���������� */
    private String endorseNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ����ԭ������ */
    private DateTime startDate = new DateTime();
    /** ����ԭ��Сʱ */
    private int startHour = 0;
    /** ����ԭ�ձ����� */
    private DateTime endDate = new DateTime();
    /** ����ԭ�ձ�Сʱ */
    private int endHour = 0;
    /** ����ʧЧ��ʼ���� */
    private DateTime invalidStartDate = new DateTime();
    /** ����ʧЧ��ʼСʱ */
    private int invalidStartHour = 0;
    /** ����ʧЧ��ֹ���� */
    private DateTime invalidEndDate = new DateTime();
    /** ����ʧЧ��ֹСʱ */
    private int invalidEndHour = 0;
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPcontractpauseDtoBase����
     */
    public PrpPcontractpauseDtoBase(){
    }

    /**
     * ��������������
     * @param endorseNo �����õ����������ŵ�ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * ��������ԭ������
     * @param startDate �����õ�����ԭ�����ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����ԭ������
     * @return ����ԭ�����ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ��������ԭ��Сʱ
     * @param startHour �����õ�����ԭ��Сʱ��ֵ
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * ��ȡ����ԭ��Сʱ
     * @return ����ԭ��Сʱ��ֵ
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * ��������ԭ�ձ�����
     * @param endDate �����õ�����ԭ�ձ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ����ԭ�ձ�����
     * @return ����ԭ�ձ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * ��������ԭ�ձ�Сʱ
     * @param endHour �����õ�����ԭ�ձ�Сʱ��ֵ
     */
    public void setEndHour(int endHour){
        this.endHour = endHour;
    }

    /**
     * ��ȡ����ԭ�ձ�Сʱ
     * @return ����ԭ�ձ�Сʱ��ֵ
     */
    public int getEndHour(){
        return endHour;
    }

    /**
     * ��������ʧЧ��ʼ����
     * @param invalidStartDate �����õ�����ʧЧ��ʼ���ڵ�ֵ
     */
    public void setInvalidStartDate(DateTime invalidStartDate){
        this.invalidStartDate = invalidStartDate;
    }

    /**
     * ��ȡ����ʧЧ��ʼ����
     * @return ����ʧЧ��ʼ���ڵ�ֵ
     */
    public DateTime getInvalidStartDate(){
        return invalidStartDate;
    }

    /**
     * ��������ʧЧ��ʼСʱ
     * @param invalidStartHour �����õ�����ʧЧ��ʼСʱ��ֵ
     */
    public void setInvalidStartHour(int invalidStartHour){
        this.invalidStartHour = invalidStartHour;
    }

    /**
     * ��ȡ����ʧЧ��ʼСʱ
     * @return ����ʧЧ��ʼСʱ��ֵ
     */
    public int getInvalidStartHour(){
        return invalidStartHour;
    }

    /**
     * ��������ʧЧ��ֹ����
     * @param invalidEndDate �����õ�����ʧЧ��ֹ���ڵ�ֵ
     */
    public void setInvalidEndDate(DateTime invalidEndDate){
        this.invalidEndDate = invalidEndDate;
    }

    /**
     * ��ȡ����ʧЧ��ֹ����
     * @return ����ʧЧ��ֹ���ڵ�ֵ
     */
    public DateTime getInvalidEndDate(){
        return invalidEndDate;
    }

    /**
     * ��������ʧЧ��ֹСʱ
     * @param invalidEndHour �����õ�����ʧЧ��ֹСʱ��ֵ
     */
    public void setInvalidEndHour(int invalidEndHour){
        this.invalidEndHour = invalidEndHour;
    }

    /**
     * ��ȡ����ʧЧ��ֹСʱ
     * @return ����ʧЧ��ֹСʱ��ֵ
     */
    public int getInvalidEndHour(){
        return invalidEndHour;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
