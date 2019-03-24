package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是PrpLext的数据传输对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLextDto extends PrpLextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLextDto.class.getName().hashCode();
    /**
     *  默认构造方法,构造一个默认的PrpLextDto对象
     */
    public PrpLextDto(){
    }
    
    //add by qinyongli begin 2005-8-30 
    //在货运险中： 
    //预留字段一 表示：货物名称和数量  private String value1 = "";
    //预留字段二 表示：估损金额       private String value2 = "";
    /** 属性保额 */
    private String sumAmount="";
    /** 属性免赔 */
    private String limitAmount ="";
    /** 属性承保公司 */
    private String prpCompanyName = "";
    /**币别中文名称*/
    private String currencyCname = "";
    
    /**
     * 获取属性保额
     * @return 属性保额
     */
    public String getSumAmount(){
        return sumAmount;
    }
    /**
     * 设置属性保额
     * @param sumAmount 待设置的属性保额
     */
    public void setSumAmount(String sumAmount){
        this.sumAmount = sumAmount;
    }
    /**
     * 获取属性免赔
     * @return 属性免赔
     */
    public String getLimitAmount(){
        return limitAmount;
    }
    /**
     * 设置属性免赔
     * @param sumAmount 待设置的属性免赔
     */
    public void setLimitAmount(String limitAmount){
        this.limitAmount = limitAmount;
    }
    /**
     * 获取属性承保公司
     * @return 属性承保公司
     */
    public String getPrpCompanyName(){
        return prpCompanyName;
    }
    /**
     * 设置属性承保公司
     * @param sumAmount 待设置的属性承保公司
     */
    public void setPrpCompanyName(String prpCompanyName){
        this.prpCompanyName = prpCompanyName;
    } 
    /**
     * 获取属性币别中文名称
     * @return 属性币别中文名称
     */
    public String getCurrencyCname(){
        return currencyCname;
    }
    /**
     * 设置属性币别中文名称
     * @param  待设置的币别中文名称
     */
    public void setCurrencyCname(String currencyCname){
        this.currencyCname = currencyCname;
    } 
    //add by qinyongli end 
}
