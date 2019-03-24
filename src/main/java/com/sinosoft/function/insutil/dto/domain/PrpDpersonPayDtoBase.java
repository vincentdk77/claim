package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdpersonpay�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDpersonPayDtoBase implements Serializable{
    /** ����serialno */
    private int serialNo = 0;
    /** ����payitemcode */
    private String payItemCode = "";
    /** ����damageareacode */
    private String damageAreaCode = "";
    /** ����businesssource */
    private String businessSource = "";
    /** ����standardfee */
    private double standardFee = 0d;
    /** ����issuedate */
    private DateTime issueDate = new DateTime();
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDpersonPayDtoBase����
     */
    public PrpDpersonPayDtoBase(){
    }

    /**
     * ��������serialno
     * @param serialNo �����õ�����serialno��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialno
     * @return ����serialno��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������payitemcode
     * @param payItemCode �����õ�����payitemcode��ֵ
     */
    public void setPayItemCode(String payItemCode){
        this.payItemCode = StringUtils.rightTrim(payItemCode);
    }

    /**
     * ��ȡ����payitemcode
     * @return ����payitemcode��ֵ
     */
    public String getPayItemCode(){
        return payItemCode;
    }

    /**
     * ��������damageareacode
     * @param damageAreaCode �����õ�����damageareacode��ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ����damageareacode
     * @return ����damageareacode��ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * ��������businesssource
     * @param businessSource �����õ�����businesssource��ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ����businesssource
     * @return ����businesssource��ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * ��������standardfee
     * @param standardFee �����õ�����standardfee��ֵ
     */
    public void setStandardFee(double standardFee){
        this.standardFee = standardFee;
    }

    /**
     * ��ȡ����standardfee
     * @return ����standardfee��ֵ
     */
    public double getStandardFee(){
        return standardFee;
    }

    /**
     * ��������issuedate
     * @param issueDate �����õ�����issuedate��ֵ
     */
    public void setIssueDate(DateTime issueDate){
        this.issueDate = issueDate;
    }

    /**
     * ��ȡ����issuedate
     * @return ����issuedate��ֵ
     */
    public DateTime getIssueDate(){
        return issueDate;
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
