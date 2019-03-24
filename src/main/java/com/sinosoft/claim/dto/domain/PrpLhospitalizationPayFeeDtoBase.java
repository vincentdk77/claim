package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLhospitalizationPayFee�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLhospitalizationPayFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����unitType */
    private String unitType = "";
    /** ����serialNo */
    private long serialNo = 0L;
    /** ����feeType */
    private String feeType = "";
    /** ����feeRate */
    private double feeRate = 0D;
    /** ����fee */
    private double fee = 0D;
    /** ����inputDate */
    private DateTime inputDate = new DateTime();
    /** ����remark */
    private String remark = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLhospitalizationPayFeeDtoBase����
     */
    public PrpLhospitalizationPayFeeDtoBase(){
    }

    /**
     * ��������compensateNo
     * @param compensateNo �����õ�����compensateNo��ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ����compensateNo
     * @return ����compensateNo��ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������unitType
     * @param unitType �����õ�����unitType��ֵ
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * ��ȡ����unitType
     * @return ����unitType��ֵ
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * ��������feeType
     * @param feeType �����õ�����feeType��ֵ
     */
    public void setFeeType(String feeType){
        this.feeType = StringUtils.rightTrim(feeType);
    }

    /**
     * ��ȡ����feeType
     * @return ����feeType��ֵ
     */
    public String getFeeType(){
        return feeType;
    }

    /**
     * ��������feeRate
     * @param feeRate �����õ�����feeRate��ֵ
     */
    public void setFeeRate(double feeRate){
        this.feeRate = feeRate;
    }

    /**
     * ��ȡ����feeRate
     * @return ����feeRate��ֵ
     */
    public double getFeeRate(){
        return feeRate;
    }

    /**
     * ��������fee
     * @param fee �����õ�����fee��ֵ
     */
    public void setFee(double fee){
        this.fee = fee;
    }

    /**
     * ��ȡ����fee
     * @return ����fee��ֵ
     */
    public double getFee(){
        return fee;
    }

    /**
     * ��������inputDate
     * @param inputDate �����õ�����inputDate��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����inputDate
     * @return ����inputDate��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������remark
     * @param remark �����õ�����remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����remark
     * @return ����remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
