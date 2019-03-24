package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpdBankBranch�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpdBankBranchDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����bank_number */
    private String bank_number = "";
    /** ����bank_name */
    private String bank_name = "";
    /** ����bank_type_code */
    private String bank_type_code = "";
    /** ����bank_type_name */
    private String bank_type_name = "";
    /** ����bank_clear_code */
    private String bank_clear_code = "";
    /** ����cpcc */
    private String cpcc = "";
    /** ����prov_code */
    private String prov_code = "";
    /** ����bank_clear_name */
    private String bank_clear_name = "";
    /** ����prov_name */
    private String prov_name = "";
    /** ����created_by */
    private String created_by = "";
    /** ����creation_date */
    private String creation_date = "";
    /** ����last_update_by */
    private String last_update_by = "";
    /** ����last_update_date */
    private String last_update_date = "";
    /** ����belong_bank_value */
    private String belong_bank_value = "";
    /** ����belong_bank_name */
    private String belong_bank_name = "";
    /** ����id */
    private String id = "";
    /** ����city_code */
    private String city_code = "";
    /** ����city_name */
    private String city_name = "";
    /** ����head_bank_flag */
    private String head_bank_flag = "";
    /** ����detail_bank_code */
    private String detail_bank_code = "";
    /** ����detal_bank_code */
    private String detal_bank_code = "";
    /** ����detal_bank_name */
    private String detal_bank_name = "";
    /** ����routing_number */
    private String routing_number = "";
    /** ����country */
    private String country = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpdBankBranchDtoBase����
     */
    public PrpdBankBranchDtoBase(){
    }

    /**
     * ��������bank_number
     * @param bank_number �����õ�����bank_number��ֵ
     */
    public void setBank_number(String bank_number){
        this.bank_number = StringUtils.rightTrim(bank_number);
    }

    /**
     * ��ȡ����bank_number
     * @return ����bank_number��ֵ
     */
    public String getBank_number(){
        return bank_number;
    }

    /**
     * ��������bank_name
     * @param bank_name �����õ�����bank_name��ֵ
     */
    public void setBank_name(String bank_name){
        this.bank_name = StringUtils.rightTrim(bank_name);
    }

    /**
     * ��ȡ����bank_name
     * @return ����bank_name��ֵ
     */
    public String getBank_name(){
        return bank_name;
    }

    /**
     * ��������bank_type_code
     * @param bank_type_code �����õ�����bank_type_code��ֵ
     */
    public void setBank_type_code(String bank_type_code){
        this.bank_type_code = StringUtils.rightTrim(bank_type_code);
    }

    /**
     * ��ȡ����bank_type_code
     * @return ����bank_type_code��ֵ
     */
    public String getBank_type_code(){
        return bank_type_code;
    }

    /**
     * ��������bank_type_name
     * @param bank_type_name �����õ�����bank_type_name��ֵ
     */
    public void setBank_type_name(String bank_type_name){
        this.bank_type_name = StringUtils.rightTrim(bank_type_name);
    }

    /**
     * ��ȡ����bank_type_name
     * @return ����bank_type_name��ֵ
     */
    public String getBank_type_name(){
        return bank_type_name;
    }

    /**
     * ��������bank_clear_code
     * @param bank_clear_code �����õ�����bank_clear_code��ֵ
     */
    public void setBank_clear_code(String bank_clear_code){
        this.bank_clear_code = StringUtils.rightTrim(bank_clear_code);
    }

    /**
     * ��ȡ����bank_clear_code
     * @return ����bank_clear_code��ֵ
     */
    public String getBank_clear_code(){
        return bank_clear_code;
    }

    /**
     * ��������cpcc
     * @param cpcc �����õ�����cpcc��ֵ
     */
    public void setCpcc(String cpcc){
        this.cpcc = StringUtils.rightTrim(cpcc);
    }

    /**
     * ��ȡ����cpcc
     * @return ����cpcc��ֵ
     */
    public String getCpcc(){
        return cpcc;
    }

    /**
     * ��������prov_code
     * @param prov_code �����õ�����prov_code��ֵ
     */
    public void setProv_code(String prov_code){
        this.prov_code = StringUtils.rightTrim(prov_code);
    }

    /**
     * ��ȡ����prov_code
     * @return ����prov_code��ֵ
     */
    public String getProv_code(){
        return prov_code;
    }

    /**
     * ��������bank_clear_name
     * @param bank_clear_name �����õ�����bank_clear_name��ֵ
     */
    public void setBank_clear_name(String bank_clear_name){
        this.bank_clear_name = StringUtils.rightTrim(bank_clear_name);
    }

    /**
     * ��ȡ����bank_clear_name
     * @return ����bank_clear_name��ֵ
     */
    public String getBank_clear_name(){
        return bank_clear_name;
    }

    /**
     * ��������prov_name
     * @param prov_name �����õ�����prov_name��ֵ
     */
    public void setProv_name(String prov_name){
        this.prov_name = StringUtils.rightTrim(prov_name);
    }

    /**
     * ��ȡ����prov_name
     * @return ����prov_name��ֵ
     */
    public String getProv_name(){
        return prov_name;
    }

    /**
     * ��������created_by
     * @param created_by �����õ�����created_by��ֵ
     */
    public void setCreated_by(String created_by){
        this.created_by = StringUtils.rightTrim(created_by);
    }

    /**
     * ��ȡ����created_by
     * @return ����created_by��ֵ
     */
    public String getCreated_by(){
        return created_by;
    }

    /**
     * ��������creation_date
     * @param creation_date �����õ�����creation_date��ֵ
     */
    public void setCreation_date(String creation_date){
        this.creation_date = StringUtils.rightTrim(creation_date);
    }

    /**
     * ��ȡ����creation_date
     * @return ����creation_date��ֵ
     */
    public String getCreation_date(){
        return creation_date;
    }

    /**
     * ��������last_update_by
     * @param last_update_by �����õ�����last_update_by��ֵ
     */
    public void setLast_update_by(String last_update_by){
        this.last_update_by = StringUtils.rightTrim(last_update_by);
    }

    /**
     * ��ȡ����last_update_by
     * @return ����last_update_by��ֵ
     */
    public String getLast_update_by(){
        return last_update_by;
    }

    /**
     * ��������last_update_date
     * @param last_update_date �����õ�����last_update_date��ֵ
     */
    public void setLast_update_date(String last_update_date){
        this.last_update_date = StringUtils.rightTrim(last_update_date);
    }

    /**
     * ��ȡ����last_update_date
     * @return ����last_update_date��ֵ
     */
    public String getLast_update_date(){
        return last_update_date;
    }

    /**
     * ��������belong_bank_value
     * @param belong_bank_value �����õ�����belong_bank_value��ֵ
     */
    public void setBelong_bank_value(String belong_bank_value){
        this.belong_bank_value = StringUtils.rightTrim(belong_bank_value);
    }

    /**
     * ��ȡ����belong_bank_value
     * @return ����belong_bank_value��ֵ
     */
    public String getBelong_bank_value(){
        return belong_bank_value;
    }

    /**
     * ��������belong_bank_name
     * @param belong_bank_name �����õ�����belong_bank_name��ֵ
     */
    public void setBelong_bank_name(String belong_bank_name){
        this.belong_bank_name = StringUtils.rightTrim(belong_bank_name);
    }

    /**
     * ��ȡ����belong_bank_name
     * @return ����belong_bank_name��ֵ
     */
    public String getBelong_bank_name(){
        return belong_bank_name;
    }

    /**
     * ��������id
     * @param id �����õ�����id��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ����id
     * @return ����id��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ��������city_code
     * @param city_code �����õ�����city_code��ֵ
     */
    public void setCity_code(String city_code){
        this.city_code = StringUtils.rightTrim(city_code);
    }

    /**
     * ��ȡ����city_code
     * @return ����city_code��ֵ
     */
    public String getCity_code(){
        return city_code;
    }

    /**
     * ��������city_name
     * @param city_name �����õ�����city_name��ֵ
     */
    public void setCity_name(String city_name){
        this.city_name = StringUtils.rightTrim(city_name);
    }

    /**
     * ��ȡ����city_name
     * @return ����city_name��ֵ
     */
    public String getCity_name(){
        return city_name;
    }

    /**
     * ��������head_bank_flag
     * @param head_bank_flag �����õ�����head_bank_flag��ֵ
     */
    public void setHead_bank_flag(String head_bank_flag){
        this.head_bank_flag = StringUtils.rightTrim(head_bank_flag);
    }

    /**
     * ��ȡ����head_bank_flag
     * @return ����head_bank_flag��ֵ
     */
    public String getHead_bank_flag(){
        return head_bank_flag;
    }

    /**
     * ��������detail_bank_code
     * @param detail_bank_code �����õ�����detail_bank_code��ֵ
     */
    public void setDetail_bank_code(String detail_bank_code){
        this.detail_bank_code = StringUtils.rightTrim(detail_bank_code);
    }

    /**
     * ��ȡ����detail_bank_code
     * @return ����detail_bank_code��ֵ
     */
    public String getDetail_bank_code(){
        return detail_bank_code;
    }

    /**
     * ��������detal_bank_code
     * @param detal_bank_code �����õ�����detal_bank_code��ֵ
     */
    public void setDetal_bank_code(String detal_bank_code){
        this.detal_bank_code = StringUtils.rightTrim(detal_bank_code);
    }

    /**
     * ��ȡ����detal_bank_code
     * @return ����detal_bank_code��ֵ
     */
    public String getDetal_bank_code(){
        return detal_bank_code;
    }

    /**
     * ��������detal_bank_name
     * @param detal_bank_name �����õ�����detal_bank_name��ֵ
     */
    public void setDetal_bank_name(String detal_bank_name){
        this.detal_bank_name = StringUtils.rightTrim(detal_bank_name);
    }

    /**
     * ��ȡ����detal_bank_name
     * @return ����detal_bank_name��ֵ
     */
    public String getDetal_bank_name(){
        return detal_bank_name;
    }

    /**
     * ��������routing_number
     * @param routing_number �����õ�����routing_number��ֵ
     */
    public void setRouting_number(String routing_number){
        this.routing_number = StringUtils.rightTrim(routing_number);
    }

    /**
     * ��ȡ����routing_number
     * @return ����routing_number��ֵ
     */
    public String getRouting_number(){
        return routing_number;
    }

    /**
     * ��������country
     * @param country �����õ�����country��ֵ
     */
    public void setCountry(String country){
        this.country = StringUtils.rightTrim(country);
    }

    /**
     * ��ȡ����country
     * @return ����country��ֵ
     */
    public String getCountry(){
        return country;
    }
}
