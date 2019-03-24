package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpdBankBranch的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpdBankBranchDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性bank_number */
    private String bank_number = "";
    /** 属性bank_name */
    private String bank_name = "";
    /** 属性bank_type_code */
    private String bank_type_code = "";
    /** 属性bank_type_name */
    private String bank_type_name = "";
    /** 属性bank_clear_code */
    private String bank_clear_code = "";
    /** 属性cpcc */
    private String cpcc = "";
    /** 属性prov_code */
    private String prov_code = "";
    /** 属性bank_clear_name */
    private String bank_clear_name = "";
    /** 属性prov_name */
    private String prov_name = "";
    /** 属性created_by */
    private String created_by = "";
    /** 属性creation_date */
    private String creation_date = "";
    /** 属性last_update_by */
    private String last_update_by = "";
    /** 属性last_update_date */
    private String last_update_date = "";
    /** 属性belong_bank_value */
    private String belong_bank_value = "";
    /** 属性belong_bank_name */
    private String belong_bank_name = "";
    /** 属性id */
    private String id = "";
    /** 属性city_code */
    private String city_code = "";
    /** 属性city_name */
    private String city_name = "";
    /** 属性head_bank_flag */
    private String head_bank_flag = "";
    /** 属性detail_bank_code */
    private String detail_bank_code = "";
    /** 属性detal_bank_code */
    private String detal_bank_code = "";
    /** 属性detal_bank_name */
    private String detal_bank_name = "";
    /** 属性routing_number */
    private String routing_number = "";
    /** 属性country */
    private String country = "";

    /**
     *  默认构造方法,构造一个默认的PrpdBankBranchDtoBase对象
     */
    public PrpdBankBranchDtoBase(){
    }

    /**
     * 设置属性bank_number
     * @param bank_number 待设置的属性bank_number的值
     */
    public void setBank_number(String bank_number){
        this.bank_number = StringUtils.rightTrim(bank_number);
    }

    /**
     * 获取属性bank_number
     * @return 属性bank_number的值
     */
    public String getBank_number(){
        return bank_number;
    }

    /**
     * 设置属性bank_name
     * @param bank_name 待设置的属性bank_name的值
     */
    public void setBank_name(String bank_name){
        this.bank_name = StringUtils.rightTrim(bank_name);
    }

    /**
     * 获取属性bank_name
     * @return 属性bank_name的值
     */
    public String getBank_name(){
        return bank_name;
    }

    /**
     * 设置属性bank_type_code
     * @param bank_type_code 待设置的属性bank_type_code的值
     */
    public void setBank_type_code(String bank_type_code){
        this.bank_type_code = StringUtils.rightTrim(bank_type_code);
    }

    /**
     * 获取属性bank_type_code
     * @return 属性bank_type_code的值
     */
    public String getBank_type_code(){
        return bank_type_code;
    }

    /**
     * 设置属性bank_type_name
     * @param bank_type_name 待设置的属性bank_type_name的值
     */
    public void setBank_type_name(String bank_type_name){
        this.bank_type_name = StringUtils.rightTrim(bank_type_name);
    }

    /**
     * 获取属性bank_type_name
     * @return 属性bank_type_name的值
     */
    public String getBank_type_name(){
        return bank_type_name;
    }

    /**
     * 设置属性bank_clear_code
     * @param bank_clear_code 待设置的属性bank_clear_code的值
     */
    public void setBank_clear_code(String bank_clear_code){
        this.bank_clear_code = StringUtils.rightTrim(bank_clear_code);
    }

    /**
     * 获取属性bank_clear_code
     * @return 属性bank_clear_code的值
     */
    public String getBank_clear_code(){
        return bank_clear_code;
    }

    /**
     * 设置属性cpcc
     * @param cpcc 待设置的属性cpcc的值
     */
    public void setCpcc(String cpcc){
        this.cpcc = StringUtils.rightTrim(cpcc);
    }

    /**
     * 获取属性cpcc
     * @return 属性cpcc的值
     */
    public String getCpcc(){
        return cpcc;
    }

    /**
     * 设置属性prov_code
     * @param prov_code 待设置的属性prov_code的值
     */
    public void setProv_code(String prov_code){
        this.prov_code = StringUtils.rightTrim(prov_code);
    }

    /**
     * 获取属性prov_code
     * @return 属性prov_code的值
     */
    public String getProv_code(){
        return prov_code;
    }

    /**
     * 设置属性bank_clear_name
     * @param bank_clear_name 待设置的属性bank_clear_name的值
     */
    public void setBank_clear_name(String bank_clear_name){
        this.bank_clear_name = StringUtils.rightTrim(bank_clear_name);
    }

    /**
     * 获取属性bank_clear_name
     * @return 属性bank_clear_name的值
     */
    public String getBank_clear_name(){
        return bank_clear_name;
    }

    /**
     * 设置属性prov_name
     * @param prov_name 待设置的属性prov_name的值
     */
    public void setProv_name(String prov_name){
        this.prov_name = StringUtils.rightTrim(prov_name);
    }

    /**
     * 获取属性prov_name
     * @return 属性prov_name的值
     */
    public String getProv_name(){
        return prov_name;
    }

    /**
     * 设置属性created_by
     * @param created_by 待设置的属性created_by的值
     */
    public void setCreated_by(String created_by){
        this.created_by = StringUtils.rightTrim(created_by);
    }

    /**
     * 获取属性created_by
     * @return 属性created_by的值
     */
    public String getCreated_by(){
        return created_by;
    }

    /**
     * 设置属性creation_date
     * @param creation_date 待设置的属性creation_date的值
     */
    public void setCreation_date(String creation_date){
        this.creation_date = StringUtils.rightTrim(creation_date);
    }

    /**
     * 获取属性creation_date
     * @return 属性creation_date的值
     */
    public String getCreation_date(){
        return creation_date;
    }

    /**
     * 设置属性last_update_by
     * @param last_update_by 待设置的属性last_update_by的值
     */
    public void setLast_update_by(String last_update_by){
        this.last_update_by = StringUtils.rightTrim(last_update_by);
    }

    /**
     * 获取属性last_update_by
     * @return 属性last_update_by的值
     */
    public String getLast_update_by(){
        return last_update_by;
    }

    /**
     * 设置属性last_update_date
     * @param last_update_date 待设置的属性last_update_date的值
     */
    public void setLast_update_date(String last_update_date){
        this.last_update_date = StringUtils.rightTrim(last_update_date);
    }

    /**
     * 获取属性last_update_date
     * @return 属性last_update_date的值
     */
    public String getLast_update_date(){
        return last_update_date;
    }

    /**
     * 设置属性belong_bank_value
     * @param belong_bank_value 待设置的属性belong_bank_value的值
     */
    public void setBelong_bank_value(String belong_bank_value){
        this.belong_bank_value = StringUtils.rightTrim(belong_bank_value);
    }

    /**
     * 获取属性belong_bank_value
     * @return 属性belong_bank_value的值
     */
    public String getBelong_bank_value(){
        return belong_bank_value;
    }

    /**
     * 设置属性belong_bank_name
     * @param belong_bank_name 待设置的属性belong_bank_name的值
     */
    public void setBelong_bank_name(String belong_bank_name){
        this.belong_bank_name = StringUtils.rightTrim(belong_bank_name);
    }

    /**
     * 获取属性belong_bank_name
     * @return 属性belong_bank_name的值
     */
    public String getBelong_bank_name(){
        return belong_bank_name;
    }

    /**
     * 设置属性id
     * @param id 待设置的属性id的值
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * 获取属性id
     * @return 属性id的值
     */
    public String getId(){
        return id;
    }

    /**
     * 设置属性city_code
     * @param city_code 待设置的属性city_code的值
     */
    public void setCity_code(String city_code){
        this.city_code = StringUtils.rightTrim(city_code);
    }

    /**
     * 获取属性city_code
     * @return 属性city_code的值
     */
    public String getCity_code(){
        return city_code;
    }

    /**
     * 设置属性city_name
     * @param city_name 待设置的属性city_name的值
     */
    public void setCity_name(String city_name){
        this.city_name = StringUtils.rightTrim(city_name);
    }

    /**
     * 获取属性city_name
     * @return 属性city_name的值
     */
    public String getCity_name(){
        return city_name;
    }

    /**
     * 设置属性head_bank_flag
     * @param head_bank_flag 待设置的属性head_bank_flag的值
     */
    public void setHead_bank_flag(String head_bank_flag){
        this.head_bank_flag = StringUtils.rightTrim(head_bank_flag);
    }

    /**
     * 获取属性head_bank_flag
     * @return 属性head_bank_flag的值
     */
    public String getHead_bank_flag(){
        return head_bank_flag;
    }

    /**
     * 设置属性detail_bank_code
     * @param detail_bank_code 待设置的属性detail_bank_code的值
     */
    public void setDetail_bank_code(String detail_bank_code){
        this.detail_bank_code = StringUtils.rightTrim(detail_bank_code);
    }

    /**
     * 获取属性detail_bank_code
     * @return 属性detail_bank_code的值
     */
    public String getDetail_bank_code(){
        return detail_bank_code;
    }

    /**
     * 设置属性detal_bank_code
     * @param detal_bank_code 待设置的属性detal_bank_code的值
     */
    public void setDetal_bank_code(String detal_bank_code){
        this.detal_bank_code = StringUtils.rightTrim(detal_bank_code);
    }

    /**
     * 获取属性detal_bank_code
     * @return 属性detal_bank_code的值
     */
    public String getDetal_bank_code(){
        return detal_bank_code;
    }

    /**
     * 设置属性detal_bank_name
     * @param detal_bank_name 待设置的属性detal_bank_name的值
     */
    public void setDetal_bank_name(String detal_bank_name){
        this.detal_bank_name = StringUtils.rightTrim(detal_bank_name);
    }

    /**
     * 获取属性detal_bank_name
     * @return 属性detal_bank_name的值
     */
    public String getDetal_bank_name(){
        return detal_bank_name;
    }

    /**
     * 设置属性routing_number
     * @param routing_number 待设置的属性routing_number的值
     */
    public void setRouting_number(String routing_number){
        this.routing_number = StringUtils.rightTrim(routing_number);
    }

    /**
     * 获取属性routing_number
     * @return 属性routing_number的值
     */
    public String getRouting_number(){
        return routing_number;
    }

    /**
     * 设置属性country
     * @param country 待设置的属性country的值
     */
    public void setCountry(String country){
        this.country = StringUtils.rightTrim(country);
    }

    /**
     * 获取属性country
     * @return 属性country的值
     */
    public String getCountry(){
        return country;
    }
}
