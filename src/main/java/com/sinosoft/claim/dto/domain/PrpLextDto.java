package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����PrpLext�����ݴ��������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLextDto extends PrpLextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLextDto.class.getName().hashCode();
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLextDto����
     */
    public PrpLextDto(){
    }
    
    //add by qinyongli begin 2005-8-30 
    //�ڻ������У� 
    //Ԥ���ֶ�һ ��ʾ���������ƺ�����  private String value1 = "";
    //Ԥ���ֶζ� ��ʾ��������       private String value2 = "";
    /** ���Ա��� */
    private String sumAmount="";
    /** �������� */
    private String limitAmount ="";
    /** ���Գб���˾ */
    private String prpCompanyName = "";
    /**�ұ���������*/
    private String currencyCname = "";
    
    /**
     * ��ȡ���Ա���
     * @return ���Ա���
     */
    public String getSumAmount(){
        return sumAmount;
    }
    /**
     * �������Ա���
     * @param sumAmount �����õ����Ա���
     */
    public void setSumAmount(String sumAmount){
        this.sumAmount = sumAmount;
    }
    /**
     * ��ȡ��������
     * @return ��������
     */
    public String getLimitAmount(){
        return limitAmount;
    }
    /**
     * ������������
     * @param sumAmount �����õ���������
     */
    public void setLimitAmount(String limitAmount){
        this.limitAmount = limitAmount;
    }
    /**
     * ��ȡ���Գб���˾
     * @return ���Գб���˾
     */
    public String getPrpCompanyName(){
        return prpCompanyName;
    }
    /**
     * �������Գб���˾
     * @param sumAmount �����õ����Գб���˾
     */
    public void setPrpCompanyName(String prpCompanyName){
        this.prpCompanyName = prpCompanyName;
    } 
    /**
     * ��ȡ���Աұ���������
     * @return ���Աұ���������
     */
    public String getCurrencyCname(){
        return currencyCname;
    }
    /**
     * �������Աұ���������
     * @param  �����õıұ���������
     */
    public void setCurrencyCname(String currencyCname){
        this.currencyCname = currencyCname;
    } 
    //add by qinyongli end 
}
