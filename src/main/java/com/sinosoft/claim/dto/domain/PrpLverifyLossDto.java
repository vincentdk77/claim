package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLverifyLoss定核损主表的数据传输对象类<br>
 * 创建于 2004-07-19 14:23:54.248<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossDto extends PrpLverifyLossDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLverifyLossDto对象
     */
    public PrpLverifyLossDto(){
    }

    /** 集合 **/
    Collection verifyLossList;
    /** 编辑类型 */
    private String editType = "";
    /** 此立案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";// Modify By Sunhao,2004-08-24
    /**属性此案件的操作时间*/
    private DateTime operateDate = new DateTime();// Modify By Sunhao,2004-08-24
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /**号牌底色名称  */
    private String licenseColor ="";
    /**车辆种类  */
    private String carKind="";
    /**币别名称  */
    private String currencyName="";
    /** 属性出险次数 */
    private int perilCount = 0;
    /** 是否更新立案的估损金额 */
    private boolean isUpdateSumClaim = false; 
    /** 向外询价信息 */
    private String verifPriceOuterMsg="";
    /** 属性理算退回的操作人 */
    private String compensateApproverName = "";
    /** 属性流程编号 */
    private String flowID = "";
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

    
    //关联保单号
	//add by zhouliu start at 2006-6-9
	//reason:强三查询
    private Collection relatepolicyNo=null;
    
    //add by zhaolu 20060803 start
    TurnPageDto	turnPageDto = null;
    //add by zhaolu 20060803 end
    
    public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}
	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9
	/**
     * 获取属性车辆种类
     * @return 属性车辆种类值
     */
    public String getCarKind(){
        return carKind;
    }
     /**
     * 设置属性车辆种类
     * @param carKind待设置的属性车辆种类的值
     */
    public void setCarKind(String carKind){
        this.carKind = StringUtils.rightTrim(carKind);
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
    /**得到单证的操作状态
    * @return 单证的操作状态
    * Modify By Sunhao,2004-08-24
    */
     public String getStatus() {
       return status;
     }

    /**设置单证的操作状态
    * @param status 单证的操作状态
    * Modify By Sunhao,2004-08-24
    */
     public void setStatus(String status) {
       this.status = status;
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
     * 设置向外询价信息
     * @param verifPriceOuterMsg 待设置向外询价信息的值
     */
    public void setVerifPriceOuterMsg(String verifPriceOuterMsg){
        this.verifPriceOuterMsg = StringUtils.rightTrim(verifPriceOuterMsg);
    }

    /**
     * 获取向外询价信息
     * @return 属性向外询价信息
     */
    public String getVerifPriceOuterMsg(){
        return verifPriceOuterMsg;
    }

    
	
    /**得到单证集合
    * @return 单证集合信息
    */
    public Collection getVerifyLossList() {
      return  verifyLossList;
    }
    /**设置单证集合
    * @param verifyLossList 单证集合
    */
    public void setVerifyLossList(Collection verifyLossList) {
      this.verifyLossList = verifyLossList;
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

    public void setIsUpdateSumClaim(boolean isUpdateSumClaim) {
      this.isUpdateSumClaim = isUpdateSumClaim;
    }

  /**
     * 获取属性出险次数
     * @return 属性出险次数的值
     */
    public int getPerilCount(){
        return perilCount;
    }

    public boolean isIsUpdateSumClaim() {
      return isUpdateSumClaim;
    }
    
      /**
     * 设置属性理算退回的操作人
     * @param compensateApproverCode 待设置的属性理算退回的操作人的值
     */
    public void setCompensateApproverName(String compensateApproverName){
        this.compensateApproverName = StringUtils.rightTrim(compensateApproverName);
    }

    /**
     * 获取属性理算退回的操作人
     * @return 属性理算退回的操作人的值
     */
    public String getCompensateApproverName(){
        return compensateApproverName;
    }
    /**
     * 设置属性流程编号
     * @param flowID 待设置的属性流程编号的值
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * 获取属性流程编号
     * @return 属性流程编号的值
     */
    public String getFlowID(){
        return flowID;
    }
	public boolean isUpdateSumClaim() {
		return isUpdateSumClaim;
	}
	public void setUpdateSumClaim(boolean isUpdateSumClaim) {
		this.isUpdateSumClaim = isUpdateSumClaim;
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
  }
