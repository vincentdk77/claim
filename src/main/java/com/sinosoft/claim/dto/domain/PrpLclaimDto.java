package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 这是prplclaim立案基本信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLclaimDto extends PrpLclaimDtoBase implements Serializable{

    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    
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
    /** 属性理赔登记机构名称 */
    private String makeComName = "";
    /**号牌号码  */
    private String licenseNo = "";
    /** 属性赔案类别 */
    //private String claimType = "";
    /** 属性赔案类别名称 */
    private String claimTypeName = "";
    /**号牌底色代码  */
    private String licenseColorCode = "";
    /**号牌底色名称  */
    private String licenseColor ="";
    /** 属性赔偿责任名称 */
    private String indemnityDutyName = "";
    /** 属性操作员名称 */
    private String operatorName = "";
    /**厂牌型号  */
    private String brandName = "";
    /**车辆种类  */
    private String carKindCode = "";
    private String carKind="";
    /** Dto传递时的编辑状态，如Eidt,Add等等 */
    private String editType ="";
      /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性出险次数 */
    private int perilCount = 0;
    /** 此报案时间 */
    private String reportDate ="";       // Modify By liuyanmei,2005-11-08

    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";       // Modify By Sunhao,2004-08-24
    /**属性此查勘案件的操作时间*/
    private DateTime operateDate = new DateTime(); //Modify By Sunhao,2004-08-24

    /**用来做提示的用的  */
    private String alertMessage="";
    /**保存上一个查询所用的查询语句*/
    private String whereString="";
    /** 属性出险终止分钟 */
    private String damageEndMinute = "";
    /** 属性笔数 */
    private int count =0;
    /** 属性险种名称 */
    private String riskCodeName="";
    /**属性逃逸标志的第二位*/
    private String escapeFlag2="";
    /**属性拒赔操作人名称*/
    private String dealerName="";
    /** 报案列表*/
    Collection registList ;

    /** 列表*/
    Collection claimList ;
    // modify by qinyongli add start 2005-07-19
    /**共保信息*/
    private String coinsFlag = "";
    /**核保日期*/
    private DateTime underWriteEndDate = null;
    /**标志位信息*/
    private String othFlag  = "";
    /**被保险人序号 */
    private int familyNo = 0;
    /**被保险人类别*/
    private String customerType = "";
    // modify by qinyongli add end  2005-07-19   
    //modify by wangwei add start 2005-06-16
    //原因：添加出险人员信息
    /** 属性AcciCode */
    private String acciCode = "";
    /** 属性AcciName */
    private String acciName = "";
    /** 属性Sex */
    private String sex = "";
    /** 属性Age */
    private int age = 0;
    /** 属性IdentifyNumber */
    private String identifyNumber = "";
    
    private String caseTypeName = ""; //属性案件性质
    
    private String businessNatureName = ""; //属性案件性质
    private String languageName = ""; //语种名称
    /**属性币别estiCurrency*/
    private String estiCurrency = "";               
    /**属性卸货日期,用于货运险*/
    private Date prpLextUnloadDate = null;
    
    private String insuredNameShow  = ""; 
    private String appliNameShow = "";
    //add by zhaolu 20060802 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060802 end
    
   
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

    
    private String businessType;
    private String businessType1;
    //分入标志：0－直接业务，1－分入业务
    private String businessFlag = "";
    //其他标志（对应prpcmain中的otherFlag）
    private String otherFlag = ""; 
    /** 属性医疗类型 健康险统计专用 */
    private String medicalType;
    
    /**属性承保户次*/
    private int sumInsured;
    /**立案注销原因说明*/
    private String cancelReasonExplan;

    
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

	public double getDamageInsured() {
		return damageInsured;
	}

	public void setDamageInsured(double damageInsured) {
		this.damageInsured = damageInsured;
	}

	public void setAppliNameShow(String appliNameShow){
    	
    	this.appliNameShow = StringUtils.rightTrim(appliNameShow);
    }
    
    public String getAppliNameShow(){
    	
    	return appliNameShow;
    }
    
    public void setInsuredNameShow(String insuredNameShow){
    	
    	this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
    }
    
    public String getInsuredNameShow(){
    	
    	return insuredNameShow;
    }
    /**
     * 设置属性businessNatureName
     * @param businessNatureName 待设置的属性businessNatureName的值
     */
    public void setBusinessNatureName(String businessNatureName){
        this.businessNatureName = StringUtils.rightTrim(businessNatureName);
    }

    /**
     * 获取属性businessNatureName
     * @return 属性businessNatureName的值
     */
    public String getBusinessNatureName(){
        return businessNatureName;
    }
    
     /**
     * 设置属性businessNatureName
     * @param businessNatureName 待设置的属性businessNatureName的值
     */
    public void setLanguageName(String languageName){
        this.languageName = StringUtils.rightTrim(languageName);
    }

    /**
     * 获取属性businessNatureName
     * @return 属性businessNatureName的值
     */
    public String getLanguageName(){
        return languageName;
    }
   
    /**
     * 设置属性AcciCode
     * @param acciCode 待设置的属性AcciCode的值
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * 获取属性AcciCode
     * @return 属性AcciCode的值
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * 设置属性AcciName
     * @param acciName 待设置的属性AcciName的值
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * 获取属性AcciName
     * @return 属性AcciName的值
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * 设置属性Sex
     * @param sex 待设置的属性Sex的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性Sex
     * @return 属性Sex的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性Age
     * @param age 待设置的属性Age的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性Age
     * @return 属性Age的值
     */
    public int getAge(){
        return age;
    }
    
    /**
     * 设置属性IdentifyNumber
     * @param identifyNumber 待设置的属性IdentifyNumber的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性IdentifyNumber
     * @return 属性IdentifyNumber的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    //modify by wangwei add end  2005-06-16
    
    /**
     *  默认构造方法,构造一个默认的PrpLclaimDto对象
     */
     public PrpLclaimDto(){
     	
     	escapeFlag2="N";
    }

    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * 获取属性赔偿责任名称
     * @return 属性赔偿责任名称的值
     */
    public String getIndemnityDutyName(){
        return indemnityDutyName;
    }

    /**
     * 设置属性赔偿责任名称
     * @param indemnityDutyName 待设置的属性赔偿责任名称的值
     */
    public void setIndemnityDutyName(String indemnityDutyName){
        this.indemnityDutyName = StringUtils.rightTrim(indemnityDutyName);
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
     * 设置属性赔案类别
     * @param claimType 待设置的属性赔案类别的值
     */
   /* public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }*/

    /**
     * 获取属性赔案类别
     * @return 属性赔案类别的值
     */
    /*public String getClaimType(){
        return claimType;
    }
   */
    
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
     * 设置属性理赔登记机构名称
     * @param makeComName 待设置的属性理赔登记机构名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性理赔登记机构名称
     * @return 属性理赔登记机构名称的值
     */
    public String getMakeComName(){
        return makeComName;
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
     * 设置属性代理人名称
     * @param AgentName 待设置的属性代理人名称
     */
    public void setAgentName(String agentName){
        this.agentName = StringUtils.rightTrim(agentName);
    }

    /**
     * 设置属性操作员名称
     * @param operatorName 待设置的属性操作员名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作员名称
     * @return 属性操作员名称的值
     */
    public String getOperatorName(){
        return operatorName;
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
     * 获取属性操作状态
     * @return 属性操作状态
     * Modify By Sunhao,2004-08-24
     */
    public String getStatus(){
        return status;
    }

   /**
    * 设置属性操作时间
    * @param operateDate 待设置的属性操作时间
    * Modify By Sunhao,2004-08-24
    */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性操作时间名称
     * @param status 待设置的属性操作时间
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }


     /**
     * 设置属性用来做提示的用的信息
     * @param alertMessage 待设置的属性用来做提示的用的信息的值
     */
    public void setAlertMessage(String alertMessage){
        this.alertMessage = StringUtils.rightTrim(alertMessage);
    }

    /**
     * 获取用来做提示的用的信息
     * @return 属性用来做提示的用的信息
     */
    public String getAlertMessage(){
        return alertMessage;
    }


 /**
     * 设置属性保存上一个查询所用的查询语句
     * @param whereString 待设置的属性保存上一个查询所用的查询语句的值
     */
    public void setWhereString(String whereString){
        this.whereString = StringUtils.rightTrim(whereString);
    }

  public void setDamageEndMinute(String damageEndMinute) {
    this.damageEndMinute = damageEndMinute;
  }

  /**
     * 获取保存上一个查询所用的查询语句
     * @return 属性保存上一个查询所用的查询语句
     */
    public String getWhereString(){
        return whereString;
    }

  public String getDamageEndMinute() {
    return damageEndMinute;
  }


  /**
     * 设置属性笔数
     * @param count 待设置的属性笔数的值
     */
    public void setCount(int count){
        this.count = count;
    }

    /**
     * 获取属性笔数
     * @return 属性笔数的值
     */
    public int getCount(){
        return count;
    }
    /**
         * 设置属性险种名称
         * @param riskCodeName 待设置的属性险种名称的值
         */
        public void setRiskCodeName(String riskCodeName){
            this.riskCodeName = StringUtils.rightTrim(riskCodeName);
        }

        /**
         * 获取属性险种名称
         * @return 属性险种名称的值
         */
        public String getRiskCodeName(){
            return riskCodeName;
        }

 /**
     * 设置属性赔款计算书号
     * @param compensateNo 待设置的属性赔款计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号
     * @return 属性赔款计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * 设置属性是否为全损
     * @param escapeFlag 待设置的属性是否为全损的值
     */
    public void setEscapeFlag2(String escapeFlag2){
        this.escapeFlag2 = StringUtils.rightTrim(escapeFlag2);
    }

    /**
     * 获取属性是否为全损
     * @return 属性是否为全损的值
     */
    public String getEscapeFlag2(){
        return escapeFlag2;
    }
    
     /**
     * 设置属性拒赔操作人名称
     * @param dealerName 待设置的属性拒赔操作人名称的值
     */
    public void setDealerName (String dealerName ){
        this.dealerName  = StringUtils.rightTrim(dealerName );
    }

    /**
     * 获取属性拒赔操作人名称
     * @return 属性拒赔操作人名称的值
     */
    public String getDealerName (){
        return dealerName ;
    }
    /**
     * 设置属性共保信息
     * @param coinsFlag 共保信息
     */
    public void setCoinsFlag(String coinsFlag ){
        this.coinsFlag  = coinsFlag ;
    }

    /**
     * 获取属性共保信息
     * @return 共保信息
     */
    public String getCoinsFlag(){
        return coinsFlag ;
    }
    /**
     * 设置属性核保信息
     * @param coinsFlag 核保信息
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate ){
        this.underWriteEndDate  = underWriteEndDate ;
    }

    /**
     * 获取属性核保信息
     * @return 核保信息
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate ;
    }
    /**
     * 设置属性核保信息
     * @param coinsFlag 核保信息
     */
    public void setOthFlag(String othFlag ){
        this.othFlag  = othFlag ;
    }

    /**
     * 获取属性核保信息othFlag
     * @return 核保信息
     */
    public String getOthFlag(){
        return othFlag ;
    }
    
    /**
     * 设置属性案件性质
     * @param 案件性质
     * */
    public void setCaseTypeName(String caseTypeName) {
    	 this.caseTypeName = caseTypeName;
    }
    
    /**
     * 获得属性案件性质
     * @return caseTypeName 案件性质
     * */
    public String getCaseTypeName() {
    	return this.caseTypeName;
    }
    /**
     * 设置序号
     * @param 序号
     * */
    public void setFamilyNo(int familyNo) {
    	 this.familyNo = familyNo;
    }
    
    /**
     * 获得属性序号
     * @return caseTypeName 序号
     * */
    public int getFamilyNo() {
    	return this.familyNo;
    }
    /**
     * 被保险人类别
     * @param 被保险人类别
     * */
    public void setCustomerType(String customerType) {
    	 this.customerType = customerType;
    }
    
    /**
     * 被保险人类别
     * @return  被保险人类别
     * */
    public String getCustomerType() {
    	return this.customerType;
    }
    
    /**
     * 设置币别信息
     * @param EstiCurrency 币别
     * */
    public void setEstiCurrency(String estiCurrency) {
    	this.estiCurrency = estiCurrency;
    }
    /**
     * 获得币别信息
     * @return EstiCurrency 币别信息
     * */   
    public String getEstiCurrency() {
    	return this.estiCurrency;
    }
    /**
     * 属性卸货日期
     * @param 属性卸货日期
     * */
    public void setprpLextUnloadDate(Date prpLextUnloadDate) {
    	this.prpLextUnloadDate = prpLextUnloadDate;
    }
    /**
     * 属性卸货日期
     * @return 属性卸货日期
     * */   
    public Date getprpLextUnloadDate() {
    	return this.prpLextUnloadDate;
    }
//modify by liuyanmei add 
    public void setReportDate(String reportDate){
        this.reportDate = StringUtils.rightTrim(reportDate);
    }

    /**
     * 获取属性AcciName
     * @return 属性AcciName的值
     */
    public String getReportDate(){
        return reportDate;
    }

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}


	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public double getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
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

	/**
	 * 设置属性承保户次
	 * @return
	 */
	public int getSumInsured() {
		return sumInsured;
	}
	
	/**
	 * 设置属性承保户次
	 * @return sumInsured
	 */
	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getCancelReasonExplan() {
		return cancelReasonExplan;
	}

	public void setCancelReasonExplan(String cancelReasonExplan) {
		this.cancelReasonExplan = cancelReasonExplan;
	}

	
	
	
}
