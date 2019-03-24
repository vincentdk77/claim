package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplprepay预赔登记表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLprepaytgDto extends PrpLprepaytgDtoBase implements Serializable{


    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    /** 属性地址代码 */
    private String addressCode = "";
    /** 属性经办人名称 */
    private String handlerName = "";
    /** 属性代理人名称 */
    private String agentName = "";
    /** 属性归属业务员名称 */
    private String handler1Name = "";
    /** 属性部门名称 */
    private String comName = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /**号牌号码  */
    private String licenseNo = "";
    /**号牌底色代码  */
    private String licenseColorCode = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性保险损失金额 */
    private double sumClaim = 0d;
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性总保额 */
    private double sumAmount = 0d;
    /** 属性总保费 */
    private double sumPremium = 0d;
    /** 属性出险地点分类代码 */
    private String damageAddressType = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /**号牌底色名称  */
    private String licenseColor ="";
    /**发动机号  */
    private String engineNo = "";
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /**车架号  */
    private String frameNo = "";
    /**厂牌型号  */
    private String brandName = "";
    /**车辆种类  */
    private String carKindCode = "";
    /**车辆种类  */
    private String carKind="";
    /** tgDto传递时的编辑状态，如Eidt,Add等等 */
    private String editType ="";
    /**币别名称  */
    private String currencyName = "";
      /** 属性险类代码 */
    private String classCode = "";
  
    
    /** 属性出险次数 */
    private int perilCount = 0;

    /** 列表*/
    Collection claimList ;
    /** 属性此查勘案件的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";             //Modify By Sunhao,2004-08-24
    /**属性此查勘案件的操作时间*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24
    
    private String registNo;
    
     /** 报案列表*/
   Collection registList ;

     /**
     *  默认构造方法,构造一个默认的PrpLctexttgDto对象
     */
    public PrpLprepaytgDto(){

    }

    /**
     * 获取属性操作状态
     * @return 属性操作状态
     * Modify By Sunhao,2004-08-24
     */
    public String getStatus(){
        return status;
    }

    /**
     * 设置属性操作状态
     * @param status 待设置的属性操作状态
     * Modify By Sunhao,2004-08-24
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }
    /**
     * 设置属性经办人代码
     * @param handlerName 属性经办人代码
     */
    public void setHandlerName(String handlerName){
      this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandler1Name(){
        return handler1Name;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandler1Name(String handler1Name){
        this.handler1Name = StringUtils.rightTrim(handler1Name);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * 设置属性部门
     * @param comName 待设置的属性部门的值
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * 获取属性部门
     * @return 属性部门的值
     */
    public String getComName(){
        return comName;
    }

    /**
     * 设置属性出险开始分钟
     * @param damageStartMinute 待设置的属性出险开始分钟的值
     */
    public void setDamageStartMinute(String damageStartMinute){
        this.damageStartMinute= StringUtils.rightTrim(damageStartMinute);
    }

    /**
     * 获取属性出险开始分钟
     * @return 属性出险开始分钟的值
     */
    public String getDamageStartMinute(){
        return damageStartMinute;
    }

    /**
     * 设置属性地址代码
     * @param addressCode 待设置的属性地址代码的值
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * 获取属性地址代码
     * @return 属性地址代码
     */
    public String getAddressCode(){
        return addressCode;
    }

    /**
      * 设置编辑类型
      * @param editType 待设置的编辑类型的值
      */
     public void setEditType(String editType){
         this.editType = StringUtils.rightTrim(editType);
     }

     /**
      * 获取编辑类型
      * @return 属性编辑类型
      */
     public String getEditType(){
         return editType;
     }
    /**
      * 获取列表
      * @return 属性列表
      */
     public Collection getClaimList(){
       return claimList;
     }

     /**
      * 设置列表
      * @param registList 待设置的列表
      */
     public void setClaimList(Collection claimList) {
       this.claimList = claimList;
     }

    /**
     * 设置属性条款类别
     * @param clauseType 待设置的属性条款类别的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别
     * @return 属性条款类别的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

     /**
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColor(String licenseColor){
        this.licenseColor = StringUtils.rightTrim(licenseColor);
    }

    /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColor(){
        return licenseColor;
    }


    /**
     * 设置属性车辆种类代码
     * @param carKindCode 待设置的属性车辆种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码
     * @return 属性车辆种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

     /**
     * 设置属性车辆种类
     * @param carKind待设置的属性车辆种类的值
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
    }

    /**
     * 获取属性车辆种类
     * @return 属性车辆种类值
     */
    public String getCarKind(){
        return carKind;
    }

    /**
     * 设置属性条款名称
     * @param clauseName 待设置的属性条款名称的值
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * 获取属性条款名称
     * @return 属性条款名称的值
     */
    public String getClauseName(){
        return clauseName;
    }

      /**
     * 设置属性厂牌型号
     * @param brandName 待设置的属性厂牌型号的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * 获取属性厂牌型号
     * @return 属性厂牌型号的值
     */
    public String getBrandName(){
        return brandName;
    }


   /**
     * 获取属性代理人名称
     * @return 属性代理人名称的值
     */
    public String getAgentName(){
        return agentName;
    }
   /**
     * 获取代理人代码
     * @return agentCode 代理人代码
     */
    public String getAgentCode() {
      return agentCode;
    }
   /**
     * 获取终保日期
     * @return 终保日期
     */
    public DateTime getEndDate() {
      return endDate;
    }
    /**
     * 获取起保日期
     * @return 起保日期
     */
    public DateTime getStartDate() {
      return startDate;
    }
    /**
     * 获取车架号
     * @return 车架号
     */
    public String getFrameNo() {
      return frameNo;
    }
    /**
     * 获取发动机号
     * @return 发动机号
     */
    public String getEngineNo() {
      return engineNo;
    }
    /**
     * 获取出险开始小时
     * @return 出险开始小时
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }
    /**
     * 获取出险日期起
     * @return 出险日期起
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    /**
     * 获取出险地点分类代码
     * @return 出险地点分类代码
     */
    public String getDamageAddressType() {
      return damageAddressType;
    }
    /**
     * 获取出险地点
     * @return 出险地点
     */
    public String getDamageAddress() {
      return damageAddress;
    }
    /**
     * 获取总保费
     * @return 总保费
     */
    public double getSumPremium() {
      return sumPremium;
    }
    /**
     * 获取总保额
     * @return 总保额
     */
    public double getSumAmount() {
      return sumAmount;
    }
    /**
     * 获取保险损失金额
     * @return 保险损失金额
     */
    public double getSumClaim() {
      return sumClaim;
    }
    /**
     * 获取业务归属机构代码
     * @return 业务归属机构代码
     */
    public String getComCode() {
      return comCode;
    }

    /**
     * 设置属性代理人名称
     * @param AgentName 待设置的属性代理人名称
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }
    /**
     * 获取业务归属机构代码
     * @return 业务归属机构代码
     */
    public void setAgentCode(String agentCode) {
      this.agentCode = agentCode;
    }
    /**
     * 获取终保日期
     * @return endDate 终保日期
     */
    public void setEndDate(DateTime endDate) {
      this.endDate = endDate;
    }
    /**
     * 获取起保日期
     * @return endDate 起保日期
     */
    public void setStartDate(DateTime startDate) {
      this.startDate = startDate;
    }
    /**
     * 获取车架号
     * @return frameNo 车架号
     */
    public void setFrameNo(String frameNo) {
      this.frameNo = frameNo;
    }
    /**
     * 获取发动机号
     * @return engineNo 发动机号
     */
    public void setEngineNo(String engineNo) {
      this.engineNo = engineNo;
    }
    /**
     * 获取出险开始小时
     * @return damageStartHour 出险开始小时
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }
    /**
     * 获取出险日期起
     * @return damageStartDate 出险日期起
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }
    /**
     * 获取出险地点分类代码
     * @return damageAddressType 出险地点分类代码
     */
    public void setDamageAddressType(String damageAddressType) {
      this.damageAddressType = damageAddressType;
    }
    /**
     * 获取出险地点分类代码
     * @return damageAddress 出险地点分类代码
     */
    public void setDamageAddress(String damageAddress) {
      this.damageAddress = damageAddress;
    }
    /**
     * 获取总保费
     * @return sumPremium 总保费
     */
    public void setSumPremium(double sumPremium) {
      this.sumPremium = sumPremium;
    }
    /**
     * 获取总保额
     * @return sumAmount 总保额
     */
    public void setSumAmount(double sumAmount) {
      this.sumAmount = sumAmount;
    }
    /**
     * 获取保险损失金额
     * @return sumClaim 保险损失金额
     */
    public void setSumClaim(double sumClaim) {
      this.sumClaim = sumClaim;
    }
    /**
     * 获取业务归属机构代码
     * @return comCode 业务归属机构代码
     */
    public void setComCode(String comCode) {
      this.comCode = comCode;
    }

   /**
    * 设置属性操作时间
    * @param operateDate 待设置的属性操作时间
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  /**
     * 获取属性操作时间名称
     * @param status 待设置的属性操作时间
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

  public String getCurrencyName() {
    return currencyName;
  }
  
   /**
     * 设置属性出险次数
     * @param perilCount 待设置的属性出险次数的值
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * 获取属性出险次数
     * @return 属性出险次数的值
     */
    public int getPerilCount(){
        return perilCount;
    }
    
    /**
     * 获取列表
     * @return 属性列表
     */
    public Collection getRegistList(){
      return registList;
    }

    /**
     * 设置列表
     * @param registList 待设置的列表
     */
    public void setRegistList(Collection registList) {
      this.registList = registList;
    }

 /**
     * 设置属性险类代码
     * @param classCode 待设置的属性险类代码的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类代码
     * @return 属性险类代码的值
     */
    public String getClassCode(){
        return classCode;
    }

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

}

