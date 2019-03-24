package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLendor�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLendorDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����claimNo */
    private String claimNo = "";
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����itemKindNo */
    private int itemKindNo = 0;
    /** ����itemCode */
    private String itemCode = "";
    /** ����itemName */
    private String itemName = "";
    /** ����kindCode */
    private String kindCode = "";
    /** ����kindName */
    private String kindName = "";
    /** ����currency */
    private String currency = "";
    /** ����endorAmount */
    private double endorAmount = 0D;
    /** ����inputDate */
    private DateTime inputDate = new DateTime();
    /** ����flag */
    private String flag = "";
    /** ����endorseNo */
    private String endorseNo = "";
    /** ����endorType */
    private String endorType = "";
    /** ����endorGrossQuantity */
    private double endorGrossQuantity = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLendorDtoBase����
     */
    public PrpLendorDtoBase(){
    }

    /**
     * ��������claimNo
     * @param claimNo �����õ�����claimNo��ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����claimNo
     * @return ����claimNo��ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������itemKindNo
     * @param itemKindNo �����õ�����itemKindNo��ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ����itemKindNo
     * @return ����itemKindNo��ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * ��������itemCode
     * @param itemCode �����õ�����itemCode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����itemCode
     * @return ����itemCode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������itemName
     * @param itemName �����õ�����itemName��ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ����itemName
     * @return ����itemName��ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * ��������kindCode
     * @param kindCode �����õ�����kindCode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindCode
     * @return ����kindCode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������kindName
     * @param kindName �����õ�����kindName��ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ����kindName
     * @return ����kindName��ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������endorAmount
     * @param endorAmount �����õ�����endorAmount��ֵ
     */
    public void setEndorAmount(double endorAmount){
        this.endorAmount = endorAmount;
    }

    /**
     * ��ȡ����endorAmount
     * @return ����endorAmount��ֵ
     */
    public double getEndorAmount(){
        return endorAmount;
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

    /**
     * ��������endorseNo
     * @param endorseNo �����õ�����endorseNo��ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����endorseNo
     * @return ����endorseNo��ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * ��������endorType
     * @param endorType �����õ�����endorType��ֵ
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * ��ȡ����endorType
     * @return ����endorType��ֵ
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * ��������endorGrossQuantity
     * @param endorGrossQuantity �����õ�����endorGrossQuantity��ֵ
     */
    public void setEndorGrossQuantity(double endorGrossQuantity){
        this.endorGrossQuantity = endorGrossQuantity;
    }

    /**
     * ��ȡ����endorGrossQuantity
     * @return ����endorGrossQuantity��ֵ
     */
    public double getEndorGrossQuantity(){
        return endorGrossQuantity;
    }
}
