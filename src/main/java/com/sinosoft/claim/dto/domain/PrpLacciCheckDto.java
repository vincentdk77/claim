package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 这是PrpLacciCheck的数据传输对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckDto extends PrpLacciCheckDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckDto.class.getName().hashCode();
    
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    /** 属性调查开始分钟 */
    private String damageStartMinute2 = "";
    /** 属性调查结束分钟 */
    private String damageStartMinute3 = "";
    /**事故地点*/
    private String damageAddress = "";
    
    //add by liuyanmei 20051209 start
    private String registNo = "";
    private String claimNo = "";
    private String compensateNo = "";
    private String claimStatus = "";
    private double checkFee = 0;
    private String currency = "";
    private String currencyName = "";
    //add by liuyanmei 20051209 end
    /**备注信息*/
    private String remark;
    
    
//  add by liuyanmei 20051209 start
    public void setCurrency(String currency) {
    	this.currency = currency;
    }
    public String getCurrency() {
    	return this.currency;
    }
    
    public void setCurrencyName(String currencyName) {
    	this.currencyName = currencyName;
    }
    public String getCurrencyName() {
    	return this.currencyName;
    }
    
    public void setCheckFee(double checkFee) {
    	this.checkFee = checkFee;
    }
    public double getCheckFee() {
    	return this.checkFee;
    }
    
    
    public void setRegistNo(String registNo) {
    	this.registNo = registNo;
    }
    
    public String getRegistNo() {
    	return this.registNo;
    }
    
    public void setClaimNo(String claimNo) {
    	this.claimNo = claimNo;
    }
   
    public String getClaimNo() {
    	return this.claimNo;
    }
    public void setCompensateNo(String compensateNo) {
    	this.compensateNo = compensateNo;
    }
    
    public String getCompensateNo() {
    	return this.compensateNo;
    }
    public void setClaimStatus(String claimStatus) {
    	this.claimStatus = claimStatus;
    }
    
    public String getClaimStatus() {
    	return this.claimStatus;
    }
//  add by liuyanmei 20051209 end
    
    /**
     * 设置备注信息
     * @param remark 备注信息
     * */
    public void setRemark(String remark) {
    	this.remark = remark;
    }
    /**
     * 获得备注信息
     * @return 获得备注信息
     * */
    public String getRemark() {
    	return this.remark;
    }
    
    /**
     * 设置事故地点
     * @param damageAddress事故地点
     * */
    public void setDamageAddress(String damageAddress) {
    	this.damageAddress = damageAddress;
    }
    /**
     * 获得事故地点
     * @return 获得事故地点*/
    public String getDamageAddress() {
    	return this.damageAddress;
    }
    
    /**
     * 设置出险日期起
     * @param damageStartDate 出险日期起
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }
    /**
     * 得到出险日期起
     * @return 出险日期起
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    
    
    /**
     * 设置出险开始小时
     * @param damageStartHour 出险开始小时
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }
    /**
     * 得到出险开始小时
     * @return 出险开始小时
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }
    
    public void setDamageStartMinute(String damageStartMinute) {
        this.damageStartMinute = damageStartMinute;
      }
    
    public String getDamageStartMinute() {
        return damageStartMinute;
      }
    
    public void setDamageStartMinute2(String damageStartMinute2) {
        this.damageStartMinute2 = damageStartMinute2;
      }
    
    public String getDamageStartMinute2() {
        return damageStartMinute2;
      }
    
    public void setDamageStartMinute3(String damageStartMinute3) {
        this.damageStartMinute3 = damageStartMinute3;
      }
    
    public String getDamageStartMinute3() {
        return damageStartMinute3;
      }
    /**
     *  默认构造方法,构造一个默认的PrpLacciCheckDto对象
     */
    public PrpLacciCheckDto(){
    }
}
