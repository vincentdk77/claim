package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
/**
 * 这是PrpLdeductibleDto的数据传输对象类<br>
 * 创建于 2006-01-06 <br>
 * 手工创建 by 秦永利 用于处理到标的、险别、赔付类型、保单，四个免赔级别的免赔额
 */
public class PrpLdeductibleDto implements Serializable{
    
    /**
     *  默认构造方法,构造一个默认的PrpLdeductibleDto对象
     */
    public PrpLdeductibleDto(){
    }
    /** 属性计算书号码 */
    private String compensateNo    = "";
    /** 属性序号 */
    private String serialNo        = "";
    /** 属性立案号码 */
    private String claimNo         = "";
    /** 属性险别 */
    private String kindCode        = "";
    /** 属性险别赔偿金额 */
    private double sumKindPaid     = 0;
    /** 属性 免赔类型 */
    private String deductibleLevel = "";
    /** 属性免赔币别 */
    private String currency        = "";
    /** 属性免赔额 */
    private String deductible      = "";
    /** 属性免赔率 */
    private String deductibleRate  = "";
    /** 属性标志位 */
    private String flag            = "";
    /**属性险别名称*/
    private String kindName = "";
    /**
     * 获取计算书号码
     * @return 属性计算书号码
     */
    public String getCompensateNo(){
      return compensateNo;
    }
    /**
     * 设置计算书号码
     * @param compensateNo 计算书号码
     */
    public void setCompensateNo(String compensateNo ) {
      this.compensateNo  = compensateNo;
    }
    /**
     * 获取序号
     * @return 属性序号
     */
    public String getSerialNo(){
      return serialNo;
    }
    /**
     * 设置序号
     * @param serialNo 序号
     */
    public void setSerialNo(String serialNo ) {
      this.serialNo  = serialNo;
    }
    /**
     * 获取立案号码
     * @return 属性立案号码
     */
    public String getClaimNo(){
      return claimNo;
    }
    /**
     * 设置立案号码
     * @param claimNo 立案号码
     */
    public void setClaimNo(String claimNo ) {
      this.claimNo  = claimNo;
    }
    /**
     * 获取险别
     * @return 属性险别
     */
    public String getKindCode(){
      return kindCode;
    }
    /**
     * 设置险别
     * @param kindCode 险别
     */
    public void setKindCode(String kindCode ) {
      this.kindCode  = kindCode;
    }
    /**
     * 获取免赔等级
     * @return 属性免赔等级
     */
    public String getDeductibleLevel(){
      return deductibleLevel ;
    }
    /**
     * 设置免赔等级
     * @param deductibleLevel 免赔等级
     */
    public void setDeductibleLevel(String deductibleLevel ) {
      this.deductibleLevel  = deductibleLevel ;
    }
    /**
     * 属性免赔币别
     * @return 属性免赔币别
     */
    public String getCurrency(){
      return currency ;
    }
    /**
     * 属性免赔币别
     * @param currency 属性免赔币别
     */
    public void setCurrency(String currency ) {
      this.currency  = currency ;
    }
    /**
     * 属性免赔额
     * @return 属性免赔额
     */
    public String getDeductible(){
      return deductible ;
    }
    /**
     * 属性免赔额
     * @param deductible 属性免赔额
     */
    public void setDeductible(String deductible ) {
      this.deductible  = deductible ;
    }
    /**
     * 属性免赔率
     * @return 属性免赔率
     */
    public String getDeductibleRate(){
      return deductibleRate ;
    }
    /**
     * 属性免赔率
     * @param deductibleRate 属性免赔率
     */
    public void setDeductibleRate(String deductibleRate ) {
      this.deductibleRate  = deductibleRate ;
    }
    /**
     * 属性标志位
     * @return 属性标志位
     */
    public String getFlag(){
      return flag ;
    }
    /**
     * 属性标志位
     * @param flag 属性标志位
     */
    public void setFlag(String flag ) {
      this.flag  = flag ;
    }
    /**
     * 属性险别名称
     * @return 属性险别名称
     */
    public String getKindName(){
      return kindName ;
    }
    /**
     * 属性标志位
     * @param flag 属性标志位
     */
    public void setKindName(String kindName ) {
      this.kindName  = kindName ;
    }
    /**
     * 属性险别赔偿金额
     * @return 属性险别赔偿金额
     */
    public double getSumKindPaid(){
      return sumKindPaid ;
    }
    /**
     * 属性险别赔偿金额
     * @param flag 属性险别赔偿金额
     */
    public void setSumKindPaid(double sumKindPaid ) {
      this.sumKindPaid  = sumKindPaid ;
    }
}
