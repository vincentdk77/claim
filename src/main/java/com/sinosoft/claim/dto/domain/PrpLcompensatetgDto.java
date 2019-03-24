package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.utility.string.Str;

/**
 * 这是prplcompensate赔款计算书表的数据传输对象类
 * <br> 创建于 2004-4-5 15:31:56
 * <br> JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcompensatetgDto extends PrpLcompensatetgDtoBase implements Serializable{

	/** 属性付款人 */
	private String payrefName="";
	/** 属性付款日期*/
	private DateTime payrefDate=new DateTime();
	/** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性起保小时 */
    private int startHour = 0;
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性终保小时 */
    private int endHour = 0;
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /** 属性车牌号 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车牌底色 */
    private String licenseColor = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性车辆种类 */
    private String carKind = "";
    
    /** 属性核定座位数量 */
    private String seatCount = "";
        
    /** 属性部门名称 */
    private String comName = "";
    /** 属性归属业务员名称 */
    private String handler1Name = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    /** 属性出险地点分类代码 */
    private String damageAddressType = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性总保险金额 */
    private double sumAmount = 0d;
    /** 属性总保费 */
    private double sumPremium = 0d;
    /** 属性保险损失金额 */
    private double sumClaim = 0d;
    /** 属性赔款合计 */
    private double sumDutyPaid1 = 0d;
    /** 属性经办人名称 */
    private String handlerName = "";
    /** 属性查勘/代查勘人1 */
    private String checker1 = "";
    /** 属性货币名称代码 */
    private String currency = "";
    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";
    /** 集合 **/
    Collection compensateList;
    /** 编辑类型 */
    private String editType = "";
    /**属性此案件的操作时间*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24

    /** 报案列表*/
    private Collection registList ;
     /** 属性出险次数 */
    private int perilCount = 0;
    /** 属性赔案类型名称 */
    private String caseTypeName = "";

    /** clauseTypeCode */
    private String clauseTypeCode = "";
    /** DeductibleTerm */
    private String deductibleTerm = "";
    /** EscapeFlag */
    private String escapeFlag = "";
    /** PurchasePrice */
    private String purchasePrice = "";
    private double sumCheckFee = 0d;
    
    //add by wunier 20080102
    private double lossesNumber;
    private String lossesUnitCode;
    private double damageInsured;
    private double disasterArea;
    private String disasterUnit;
    private double affectedArea;
    private String affectedUnit;
    private double noProductionArea;
    private String noProductionUnit;
    private double deathQuantity;
    private String deathUnit;
    private double killQuantity;
    private String killUnit;
    //end by wunier 20080102
    
    private String businessType;
    private String businessType1;
    //分入标志：0－直接业务，1－分入业务
    private String businessFlag = "";
    //其他标志（对应prpcmain中的otherFlag）
    private String otherFlag = ""; 
    /**伤势程度*/
    private String woundGrade = "";
    //modify by luqin 2005-04-08 start
    /** 属性已付保费 */
    private int payFee = 0;
    //modify by luqin 2005-04-08 end
    /** 属性赔偿责任代码 */
    private String indemnityDutyName = "";
    private TurnPageDto turnPageDto;
    //add by qinyongli 2005-7-19
      //增加共保信息
    /** 共保信息 */
    private String coinsFlag = "";
    //增加业务来源信息
    /**业务来源*/
    private String businessNature = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /**属性历次赔付金额汇总信息*/
    double sumPaidAll = 0 ;
    /**属性币别中文名称*/
    String currencyName = "";
    //add by qinyongli end 2005-7-19
    
     /** 属性是否可能有追偿 */
    private String replevyFlag = "";
    
    /**属性案件类型 2005-08-03*/
    private String claimType = "";
    
    /**属性案件类型名 2005-08-03*/
    private String claimTypeName = "";
    
    /**属性报案号 2005-08-07*/
    private String registNo = "";
    /**属性交费标志 2005-12-22  -1为未缴费，0为未缴全，1为缴全*/
    private int palyFlag = 1;
    
    /** 属性投保人名称 */
    private String appliName = "";
    
    /** 属性被保人显示名称 */
    private String insuredNameShow = "";
    /**
     * 财产损失(在prplLoss表中的赔付标的损失SumRealPay之和)
     */
    private double lossSumRealPay = 0;
    
    /**
     * 人伤损失(在PrplPersonLoss表中的赔付损失SumRealPay之和)
     */
    private double personLossSumRealPay = 0;
    
    /** 属性医疗类型 健康险专用 */
    private String medicalType = "";
    
    /**
     * 免赔条件信息
     */
    private ArrayList prpLdeductCondtgDtoList;

    /**
     * 三者车车牌号
     */
    private String thridLicenseNos;
    
    /**
     * 三者车承包公司
     */
    private String  thridCompanys;
    
    //支付对象
    private String  ojectName;
    //支付对象证件类型
    private String  ojectType;
    //支付对象证件号码
    private String  ojectCode;
    
    /**承保户次*/
    private int sumInsured;
    
    /**理赔清单关联号*/
    private String claimRelationNo;
    
    /**预付费用*/
    private double sumPreChargeAmount = 0.0;
    /**零赔付原因*/
    private String zeroLossType;
    /**零赔付-注销拒赔类型*/
    private String zeroLossCaseType;
    /**零赔付-注销拒赔原因*/
    private String zeroLossDetailReason;
    private double coinsOtherPaid = 0.0 ;
    
    /**是否涉诉*/
    private String lawsuitFlag;
    
    /**案件恢复、重开类型*/
    private String reopenedType;
    
    
    
	public String getReopenedType() {
		return reopenedType;
	}

	public void setReopenedType(String reopenedType) {
		this.reopenedType = reopenedType;
	}

	public String getLawsuitFlag() {
		return lawsuitFlag;
	}

	public void setLawsuitFlag(String lawsuitFlag) {
		this.lawsuitFlag = lawsuitFlag;
	}

	public String getClaimRelationNo() {
		return Str.rightTrim(claimRelationNo);
	}

	public void setClaimRelationNo(String claimRelationNo) {
		this.claimRelationNo = Str.rightTrim(claimRelationNo);
	}

	public ArrayList getPrpLdeductCondtgDtoList() {
		return prpLdeductCondtgDtoList;
	}

	public void setPrpLdeductCondtgDtoList(ArrayList prpLdeductCondtgDtoList) {
		this.prpLdeductCondtgDtoList = prpLdeductCondtgDtoList;
	}

	/**
     *  默认构造方法,构造一个默认的PrpLcompensatetgDto对象
     */
    public PrpLcompensatetgDto(){
    }

    /**得到座位数
     * @return 座位数
     */
    public String getSeatCount() {
      return seatCount;
    }

    /**设置座位数
     * @param seatCount 座位数
     */
    public void setSeatCount(String seatCount) {
      this.seatCount = seatCount;
    }
 
    /**得到出险地点分类代码
     * @return 出险地点分类代码
     */
    public String getDamageAddressType() {
      return damageAddressType;
    }

    /**得到出险地点
     * @return 出险地点
     */
    public String getDamageAddress() {
      return damageAddress;
    }

    /**得到终保日期
     * @return 终保日期
     */
    public DateTime getEndDate() {
      return endDate;
    }
    /**得到车架号
     * @return 车架号
     */
    public String getFrameNo() {
      return frameNo;
    }
    /**得到经办人名称
     * @return 经办人名称
     */
    public String getHandlerName() {
      return handlerName;
    }
    /**得到总保费
     * @return 总保费
     */
    public double getSumPremium() {
      return sumPremium;
    }
    /**得到总保费
     * @return 总保费
     */
    public double getSumAmount() {
      return sumAmount;
    }

    /**得到条款名称
     * @return 条款名称
     */
    public String getClauseName() {
      return clauseName;
    }
    /**得到终保小时
     * @return 终保小时
     */
    public int getEndHour() {
      return endHour;
    }
    /**得到出险日期起
     * @return 出险日期起
     */
    public DateTime getDamageStartDate() {
      return damageStartDate;
    }
    /**得到条款类别
     * @return 条款类别
     */
    public String getClauseType() {
      return clauseType;
    }
    /**得到车辆种类代码
     * @return 车辆种类代码
     */
    public String getCarKindCode() {
      return carKindCode;
    }
    /**得到赔款合计
     * @return 赔款合计
     */
    public double getSumDutyPaid1() {
      return sumDutyPaid1;
    }

    /**得到车牌底色代码
     * @return 车牌底色代码
     */
    public String getLicenseColorCode() {
      return licenseColorCode;
    }

    /**得到出险开始小时
     * @return 出险开始小时
     */
    public String getDamageStartHour() {
      return damageStartHour;
    }

    /**得到被保险人名称
     * @return 被保险人名称
     */
    public String getInsuredName() {
      return insuredName;
    }

    /**得到厂牌型号
     * @return 厂牌型号
     */
    public String getBrandName() {
      return brandName;
    }

    /**得到被保险人代码
     * @return 被保险人代码
     */
    public String getInsuredCode() {
      return insuredCode;
    }

    /**得到查勘/代查勘人1
     * @return 查勘/代查勘人1
     */
    public String getChecker1() {
      return checker1;
    }

    /**得到保险损失金额
     * @return 保险损失金额
     */
    public double getSumClaim() {
      return sumClaim;
    }

    /**得到货币名称代码
     * @return 货币名称代码
     */
    public String getCurrency() {
      return currency;
    }
    /**得到起保小时
     * @return 起保小时
     */
    public int getStartHour() {
      return startHour;
    }
     /**得到车牌号
     * @return 车牌号
     */
    public String getLicenseNo() {
      return licenseNo;
    }
    /**得到发动机号
     * @return 发动机号
     */
    public String getEngineNo() {
      return engineNo;
    }
    /**得到起保日期
     * @return 起保日期
     */
    public void setStartDate(DateTime startDate) {
      this.startDate = startDate;
    }

    /**设置出险地点分类代码
     * @param damageAddressType 出险地点分类代码
     */
    public void setDamageAddressType(String damageAddressType) {
      this.damageAddressType = damageAddressType;
    }

    /**设置出险地点
     * @param damageAddress 出险地点
     */
    public void setDamageAddress(String damageAddress) {
      this.damageAddress = damageAddress;
    }

    /**设置终保日期
     * @param endDate 终保日期
     */
    public void setEndDate(DateTime endDate) {
      this.endDate = endDate;
    }

    /**设置车架号
     * @param frameNo 车架号
     */
    public void setFrameNo(String frameNo) {
      this.frameNo = frameNo;
    }

    /**设置经办人名称
     * @param handlerName 经办人名称
     */
    public void setHandlerName(String handlerName) {
      this.handlerName = handlerName;
    }

    /**设置总保费
     * @param sumPremium 总保费
     */
    public void setSumPremium(double sumPremium) {
      this.sumPremium = sumPremium;
    }

    /**设置总保费
     * @param sumAmount 总保费
     */
    public void setSumAmount(double sumAmount) {
      this.sumAmount = sumAmount;
    }

    /**设置条款名称
     * @param clauseName 条款名称
     */
    public void setClauseName(String clauseName) {
      this.clauseName = clauseName;
    }

    /**设置终保小时
     * @param endHour 终保小时
     */
    public void setEndHour(int endHour) {
      this.endHour = endHour;
    }

    /**设置出险日期起
     * @param damageStartDate 出险日期起
     */
    public void setDamageStartDate(DateTime damageStartDate) {
      this.damageStartDate = damageStartDate;
    }

    /**设置条款类别
     * @param clauseType 条款类别
     */
    public void setClauseType(String clauseType) {
      this.clauseType = clauseType;
    }

    /**设置车辆种类代码
     * @param carKindCode 车辆种类代码
     */
    public void setCarKindCode(String carKindCode) {
      this.carKindCode = carKindCode;
    }

    /**设置赔款合计
     * @param sumDutyPaid1 赔款合计
     */
    public void setSumDutyPaid1(double sumDutyPaid1) {
      this.sumDutyPaid1 = sumDutyPaid1;
    }

    /**设置车牌底色代码
     * @param licenseColorCode 车牌底色代码
     */
    public void setLicenseColorCode(String licenseColorCode) {
      this.licenseColorCode = licenseColorCode;
    }

    /**设置出险开始小时
     * @param damageStartHour 出险开始小时
     */
    public void setDamageStartHour(String damageStartHour) {
      this.damageStartHour = damageStartHour;
    }

    /**设置被保险人名称
     * @param insuredName 被保险人名称
     */
    public void setInsuredName(String insuredName) {
      this.insuredName = insuredName;
    }

    /**设置厂牌型号
     * @param brandName 厂牌型号
     */
    public void setBrandName(String brandName) {
      this.brandName = brandName;
    }

    /**设置被保险人代码
     * @param insuredCode 被保险人代码
     */
    public void setInsuredCode(String insuredCode) {
      this.insuredCode = insuredCode;
    }

    /**设置查勘/代查勘人1
     * @param checker1 查勘/代查勘人1
     */
    public void setChecker1(String checker1) {
      this.checker1 = checker1;
    }

    /**设置保险损失金额
     * @param sumClaim 保险损失金额
     */
    public void setSumClaim(double sumClaim) {
      this.sumClaim = sumClaim;
    }

    /**设置货币名称代码
     * @param currency 货币名称代码
     */
    public void setCurrency(String currency) {
      this.currency = currency;
    }

    /**设置起保小时
     * @param startHour 起保小时
     */
    public void setStartHour(int startHour) {
      this.startHour = startHour;
    }

    /**设置发动机号
     * @param engineNo 发动机号
     */
    public void setEngineNo(String engineNo) {
      this.engineNo = engineNo;
    }

    /**设置车牌号
     * @param licenseNo 车牌号
     */
    public void setLicenseNo(String licenseNo) {
      this.licenseNo = licenseNo;
    }

    /**设置此立案的操作状态
     * @param prpLclaimtgDto 此立案的操作状态
     */
    public void setStatus(String status) {
      this.status = status;
    }
    /**设置车辆种类
     * @param carKind 车辆种类
     */

    public void setCarKind(String carKind) {
      this.carKind = carKind;
    }

    /**设置车牌底色
     * @param licenseColor 车牌底色
     */
    public void setLicenseColor(String licenseColor) {
      this.licenseColor = licenseColor;
    }

    /**设置归属业务员名称
     * @param handler1Name 归属业务员名称
     */
    public void setHandler1Name(String handler1Name) {
      this.handler1Name = handler1Name;
    }

    /**设置部门名称
     * @param prpLclaimtgDto 部门名称
     */
    public void setComName(String comName) {
      this.comName = comName;
    }

    /**集合
     * @param compensateList 集合
     */
    public void setCompensateList(Collection compensateList) {
      this.compensateList = compensateList;
    }

    /**设置编辑类型
     * @param editType 编辑类型
     */
    public void setEditType(String editType) {
      this.editType = editType;
    }

    /**设置起保日期
     * @param startDate 起保日期
     */
    public DateTime getStartDate() {
      return startDate;
    }

    /**设置此立案的操作状态
     * @param status 此立案的操作状态
     */
    public String getStatus() {
      return status;
    }

    /**设置车辆种类
     * @param prpLclaimtgDto 车辆种类
     */
    public String getCarKind() {
      return carKind;
    }

    /**设置车牌底色
     * @param prpLclaimtgDto 车牌底色
     */
    public String getLicenseColor() {
      return licenseColor;
    }

    /**设置归属业务员名称
     * @param handler1Name 归属业务员名称
     */
    public String getHandler1Name() {
      return handler1Name;
    }

    /**设置部门名称
     * @param comName 部门名称
     */
    public String getComName() {
      return comName;
    }

    /**设置集合
     * @param compensateList 集合
     */
    public Collection getCompensateList() {
      return compensateList;
    }

    /**设置编辑类型
     * @param editType 编辑类型
     */
    public String getEditType() {
      return editType;
    }

   /**
    * 设置属性操作时间
    * @param operateDate 待设置的属性操作时间
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

  public void setDamageStartMinute(String damageStartMinute) {
    this.damageStartMinute = damageStartMinute;
  }

  /**
     * 获取属性操作时间名称
     * @param status 待设置的属性操作时间
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

  public String getDamageStartMinute() {
    return damageStartMinute;
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
     * 设置属性赔案类型名称
     * @param caseTypeName 待设置的属性赔案类型名称的值
     */
    public void setCaseTypeName(String caseTypeName){
        this.caseTypeName = StringUtils.rightTrim(caseTypeName);
    }

  public void setEscapeFlag(String escapeFlag) {
    this.escapeFlag = escapeFlag;
  }

  public void setDeductibleTerm(String deductibleTerm) {
    this.deductibleTerm = deductibleTerm;
  }

 

  public void setClauseTypeCode(String clauseTypeCode) {
    this.clauseTypeCode = clauseTypeCode;
  }

  public void setPurchasePrice(String purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  /**
     * 获取属性赔案类型名称
     * @return 属性赔案类型名称的值
     */
    public String getCaseTypeName(){
        return caseTypeName;
    }

  public String getEscapeFlag() {
    return escapeFlag;
  }

  public String getDeductibleTerm() {
    return deductibleTerm;
  }


  public String getClauseTypeCode() {
    return clauseTypeCode;
  }

  public String getPurchasePrice() {
    return purchasePrice;
  }
  
  //modify by luqin 2005-04-08 start
  /**得到已交保费信息
   * @return 已交保费
   */
  public int getPayFee(){
    return payFee;
  }
  /**设置已交保费信息
  * @param payFee 已交保费
  */
  public void setPayFee(int payFee){
    this.payFee = payFee;
  }
  //modify by luqin 2005-04-08 end

	/**
	 * @return Returns the indemnityDutyName.
	 */
	public String getIndemnityDutyName() {
		return indemnityDutyName;
	}
	/**
	 * @param indemnityDutyName The indemnityDutyName to set.
	 */
	public void setIndemnityDutyName(String indemnityDutyName) {
		this.indemnityDutyName = indemnityDutyName;
	}
	/**
	 * @return Returns the turnPagetgDto.
	 */
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	/**
	 * @param turnPagetgDto The turnPagetgDto to set.
	 */
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
    /**
     * 设置属性是否可能有追偿
     * @param replevyFlag 待设置的属性是否可能有追偿的值
     */
    public void setReplevyFlag(String replevyFlag){
        this.replevyFlag = StringUtils.rightTrim(replevyFlag);
    }

    /**
     * 获取属性是否可能有追偿
     * @return 属性是否可能有追偿的值
     */
    public String getReplevyFlag(){
        return replevyFlag;
    }
    /**
     * 设置属性共保信息
     * @param coinsFlag 共保信息
     */
    public void setCoinsFlag(String coinsFlag){
        this.coinsFlag = coinsFlag;
    }

    /**
     * 获取属性共保信息
     * @return 属性共保信息
     */
    public String getCoinsFlag(){
        return coinsFlag;
    }
    /**
     * 设置属性业务来源
     * @param businessNature 业务来源
     */
    public void setBusinessNature(String businessNature){
        this.businessNature = businessNature;
    }
    /**
     * 获取属性业务来源
     * @return 属性业务来源
     */
    public String getBusinessNature(){
        return businessNature;
    }
    /**
     * 设置属性出险原因代码
     * @param damageCode 待设置的属性出险原因代码的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性出险原因代码
     * @return 属性出险原因代码的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * 设置属性出险原因说明
     * @param damageName 待设置的属性出险原因说明的值
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * 获取属性出险原因说明
     * @return 属性出险原因说明的值
     */
    public String getDamageName(){
        return damageName;
    }
 
    /**
     * 设置属性案件类型
     * @param claimType 待设置的属性案件类型的值
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * 获取属性案件类型
     * @return 属性案件类型的值
     */
    public String getClaimType(){
        return claimType;
    }
    
    /**
     * 设置属性赔案类别名称
     * @param claimTypeName 待设置的属性赔案类别名称的值
     */
    public void setClaimTypeName(String claimTypeName){
        this.claimTypeName = StringUtils.rightTrim(claimTypeName);
    }

    /**
     * 获取属性赔案类别名称
     * @return 属性赔案类别名称的值
     */
    public String getClaimTypeName(){
        return claimTypeName;
    }
    
    /**
     * 设置属性报案号
     * @return 属性报案号
     * */
    public void setRegistNo(String registNo) {
    	this.registNo = registNo;
    }
    
    /**
     * 获取属性报案号
     * @return 属性报案号
     * */
    public String getRegistNo() {
    	return this.registNo;
    }
    /**
     * 属性历次赔付金额汇总信息
     * @return 属性历次赔付金额汇总信息
     * */
    public void setSumPaidAll(double sumPaidAll) {
    	this.sumPaidAll = sumPaidAll;
    }
    
    /**
     * 属性历次赔付金额汇总信息
     * @return 属性历次赔付金额汇总信息
     * */
    public double getSumPaidAll() {
    	return this.sumPaidAll;
    }
    /**
     * 属性币别中文名称
     * @return 属性币别中文名称
     * */
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    
    /**
     * 属性币别中文名称
     * @return 属性币别中文名称
     * */
    public String getCurrencyName() {
        return this.currencyName;
    }

	/** 
	 * @param intReturn
	 */
	public void setPalyFlag(int palyFlag) {
		// TODO 自动生成方法存根
	   	this.palyFlag = palyFlag;
	    		
	}
	   public int getPalyFlag() {
        return this.palyFlag;
    }
   public double getSumCheckFee() {
	     return sumCheckFee;
    }
   public void setSumCheckFee(double sumCheckFee) {
	this.sumCheckFee = sumCheckFee;
   }
	   
	  /**
     * 设置属性投保人名称
     * @param appliName 待设置的属性投保人名称的值
     */
    public void setAppliName(String appliName){
        this.appliName = StringUtils.rightTrim(appliName);
    }

    /**
     * 获取属性投保人名称
     * @return 属性投保人名称的值
     */
    public String getAppliName(){
        return appliName;
    }
   
    /**
     * 设置属性 被保险人显示名称
     * @param appliName 待设置的属性被保险人显示名称的值
     */
    public void setInsuredNameShow(String insuredNameShow){
        this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
    }

    /**
     * 获取属性被保险人显示名称
     * @return 属性被保险人显示名称的值
     */
    public String getInsuredNameShow(){
        return insuredNameShow;
    }
    
    
    public String getDefaultCompensateResult(){
    	//默认为给付(代码为"1")
    	return "1";
    }

	public double getPersonLossSumRealPay() {
		return personLossSumRealPay;
	}

	public void setPersonLossSumRealPay(double sumPersonLoss) {
		this.personLossSumRealPay = sumPersonLoss;
	}

	public double getLossSumRealPay() {
		return lossSumRealPay;
	}

	public void setLossSumRealPay(double sumPropLoss) {
		this.lossSumRealPay = sumPropLoss;
	}
	
	//新增付款人和付款日期
    public void setPayrefName(String currencyName) {
        this.payrefName = payrefName;
    }
    
    public String getPayrefName() {
        return this.payrefName;
    }
    
    public void setPayrefDate(DateTime payrefDate) {
        this.payrefDate = payrefDate;
    }
    
    public DateTime getPayrefDate() {
        return this.payrefDate;
    }

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getDamageInsured() {
		return damageInsured;
	}

	public void setDamageInsured(double damageInsured) {
		this.damageInsured = damageInsured;
	}

	public double getDisasterArea() {
		return disasterArea;
	}

	public void setDisasterArea(double disasterArea) {
		this.disasterArea = disasterArea;
	}

	public String getDisasterUnit() {
		return disasterUnit;
	}

	public void setDisasterUnit(String disasterUnit) {
		this.disasterUnit = disasterUnit;
	}

	public double getAffectedArea() {
		return affectedArea;
	}

	public void setAffectedArea(double affectedArea) {
		this.affectedArea = affectedArea;
	}

	public String getAffectedUnit() {
		return affectedUnit;
	}

	public void setAffectedUnit(String affectedUnit) {
		this.affectedUnit = affectedUnit;
	}

	public double getNoProductionArea() {
		return noProductionArea;
	}

	public void setNoProductionArea(double noProductionArea) {
		this.noProductionArea = noProductionArea;
	}

	public String getNoProductionUnit() {
		return noProductionUnit;
	}

	public void setNoProductionUnit(String noProductionUnit) {
		this.noProductionUnit = noProductionUnit;
	}

	public double getDeathQuantity() {
		return deathQuantity;
	}

	public void setDeathQuantity(double deathQuantity) {
		this.deathQuantity = deathQuantity;
	}

	public String getDeathUnit() {
		return deathUnit;
	}

	public void setDeathUnit(String deathUnit) {
		this.deathUnit = deathUnit;
	}

	public double getKillQuantity() {
		return killQuantity;
	}

	public void setKillQuantity(double killQuantity) {
		this.killQuantity = killQuantity;
	}

	public String getKillUnit() {
		return killUnit;
	}

	public void setKillUnit(String killUnit) {
		this.killUnit = killUnit;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}
	
	/**
	 * 获取属性医疗类型
	 * @return
	 */
	public String getMedicalType() {
		return medicalType;
	}

	/**
	 * 设置属性医疗类型
	 * @param medicalType
	 */
	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getWoundGrade() {
		return woundGrade;
	}

	public void setWoundGrade(String woundGrade) {
		this.woundGrade = woundGrade;
	}

	public String getThridLicenseNos() {
		return thridLicenseNos;
	}

	public void setThridLicenseNos(String thridLicenseNos) {
		this.thridLicenseNos = thridLicenseNos;
	}

	public String getThridCompanys() {
		return thridCompanys;
	}

	public void setThridCompanys(String thridCompanys) {
		this.thridCompanys = thridCompanys;
	}

	public String getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(String businessFlag) {
		this.businessFlag = businessFlag;
	}

	public String getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	public String getOjectName() {
		return ojectName;
	}

	public void setOjectName(String ojectName) {
		this.ojectName = ojectName;
	}

	public String getOjectType() {
		return ojectType;
	}

	public void setOjectType(String ojectType) {
		this.ojectType = ojectType;
	}

	public String getOjectCode() {
		return ojectCode;
	}

	public void setOjectCode(String ojectCode) {
		this.ojectCode = ojectCode;
	}

	public int getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getSumPreChargeAmount() {
		return sumPreChargeAmount;
	}

	public void setSumPreChargeAmount(double sumPreChargeAmount) {
		this.sumPreChargeAmount = sumPreChargeAmount;
	}

	public String getZeroLossType() {
		return zeroLossType;
	}

	public void setZeroLossType(String zeroLossType) {
		this.zeroLossType = zeroLossType;
	}

	public String getZeroLossCaseType() {
		return zeroLossCaseType;
	}

	public void setZeroLossCaseType(String zeroLossCaseType) {
		this.zeroLossCaseType = zeroLossCaseType;
	}

	public String getZeroLossDetailReason() {
		return zeroLossDetailReason;
	}

	public void setZeroLossDetailReason(String zeroLossDetailReason) {
		this.zeroLossDetailReason = zeroLossDetailReason;
	}
	
	public double getCoinsOtherPaid() {
		return coinsOtherPaid;
	}

	public void setCoinsOtherPaid(double coinsOtherPaid) {
		this.coinsOtherPaid = coinsOtherPaid;
	}


}
