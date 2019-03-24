package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplcheck查勘/代查勘信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckDto extends PrpLcheckDtoBase implements Serializable{

    /**
     *  默认构造方法,构造一个默认的PrpLcheckDto对象
     */
    public PrpLcheckDto(){
    }

    /** 集合 **/
    Collection checkList;
    /** 编辑类型 */
    private String editType = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    /** 属性出险日期止 */
    private DateTime damageEndDate = new DateTime();
    /** 属性出险终止小时 */
    private String damageEndHour = "";
    /** 属性出险终止分钟 */
    private String damageEndMinute = "";
    /** 属性出险区域 */
    private String damageAreaName = "";
    /** 属性事故处理部门 */
    private String handleUnitName = "";
    /** 属性此查勘案件的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status ="";       // Modify By Sunhao,2004-08-24
    /**属性此查勘案件的操作时间*/
    private DateTime operateDate = new DateTime();  // Modify By Sunhao,2004-08-24
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";

    private String damageAddress = "";

    /** 是否更新立案的估损金额 */
    private boolean isUpdateSumClaim = false;

    /** 报案列表*/
    Collection registList;

    /** 属性出险次数 */
    private int perilCount = 0;

    //modify by wangwei add start 20050602
    //原因：增加报损金额和报损费用
    /**报损金额*/
    private double registEstimateLoss = 0D;
    /**报损费用*/
    private double registEstimateFee = 0D;
    //modify by wangwei add end 20050602
    //modify by qinyongli add start 20050718
    //增加共保标志
    private String coinsFlag = "";
    //modify by qinyongli add end 20050718

    private String currency = "";//add by wuxiaodong 050905 reasin 增加币别代码显示
    /**被保险人信息*/
    private String insuredName;
    //关联保单
	//add by zhouliu start at 2006-6-9
	//reason:强三查询
    private Collection relatepolicyNo=null;
    
    //add by zhaolu 20060802 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060802 end
	
   public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}

	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9

/**得到事故处理部门
   * @return 事故处理部门
   */
  public String getHandleUnitName() {
    return handleUnitName;
  }

   /**得到出险日期止
   * @return 出险日期止
   */
  public DateTime getDamageEndDate() {
    return damageEndDate;
  }

   /**得到条款名称
   * @return 条款名称
   */
  public String getClauseName() {
    return clauseName;
  }

   /**得到查勘集合
   * @return 查勘集合信息
   */
  public Collection getCheckList() {
    return checkList;
  }

   /**得到出险开始小时
   * @return 出险开始小时
   */
  public String getDamageStartHour() {
    return damageStartHour;
  }

   /**得到出险终止小时
   * @return 出险终止小时
   */
  public String getDamageEndHour() {
    return damageEndHour;
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

   /**得到出险区域
   * @return 出险区域
   */
  public String getDamageAreaName() {
    return damageAreaName;
  }

   /**设置编辑类型
   * @param editType 编辑类型
   */
  public void setEditType(String editType) {
    this.editType = editType;
  }

   /**设置事故处理部门
   * @param handleUnitName 事故处理部门
   */
  public void setHandleUnitName(String handleUnitName) {
    this.handleUnitName = handleUnitName;
  }

   /**设置出险日期止
   * @param damageEndDate 出险日期止
   */
  public void setDamageEndDate(DateTime damageEndDate) {
    this.damageEndDate = damageEndDate;
  }

   /**设置条款名称
   * @param clauseName 条款名称
   */
  public void setClauseName(String clauseName) {
    this.clauseName = clauseName;
  }

   /**设置查勘集合
   * @param checkList 查勘集合
   */
  public void setCheckList(Collection checkList) {
    this.checkList = checkList;
  }

   /**设置出险开始小时
   * @param damageStartHour 出险开始小时
   */
  public void setDamageStartHour(String damageStartHour) {
    this.damageStartHour = damageStartHour;
  }

   /**设置出险终止小时
   * @param damageEndHour 出险终止小时
   */
  public void setDamageEndHour(String damageEndHour) {
    this.damageEndHour = damageEndHour;
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

  /**设置查勘报告
   * @param prpLregistTextDtoList 查勘报告
   */
  public void setDamageAreaName(String damageAreaName) {
    this.damageAreaName = damageAreaName;
  }

  /**设置编辑类型
   * @param editType 编辑类型
   */
  public String getEditType() {
    return editType;
  }

  /**
   * 设置属性操作状态
   * @param status 待设置的属性操作状态
   * Modify By Sunhao,2004-08-24
   */
  public void setStatus(String status) {
    this.status = StringUtils.rightTrim(status);
  }

  /**
   * 获取属性操作状态
   * @return 属性操作状态
   * Modify By Sunhao,2004-08-24
   */
  public String getStatus() {
    return status;
  }

  /**
   * 设置属性操作时间
   * @param operateDate 待设置的属性操作时间
   * Modify By Sunhao,2004-08-24
   */
  public void setOperateDate(DateTime operateDate) {
    this.operateDate = operateDate;
  }

  public void setDamageEndMinute(String damageEndMinute) {
    this.damageEndMinute = damageEndMinute;
  }

  public void setDamageStartMinute(String damageStartMinute) {
    this.damageStartMinute = damageStartMinute;
  }

  /**
   * 获取属性操作时间名称
   * @param status 待设置的属性操作时间
   * Modify By Sunhao,2004-08-24
   */

  public DateTime getOperateDate() {
    return operateDate;
  }

  public String getDamageEndMinute() {
    return damageEndMinute;
  }

  public String getDamageStartMinute() {
    return damageStartMinute;
  }

  /**
   * 设置属性出险次数
   * @param perilCount 待设置的属性出险次数的值
   */
  public void setPerilCount(int perilCount) {
    this.perilCount = perilCount;
  }

  /**
   * 获取属性出险次数
   * @return 属性出险次数的值
   */
  public int getPerilCount() {
    return perilCount;
  }

  /**
   * 获取列表
   * @return 属性列表
   */
  public Collection getRegistList() {
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
   * 设置属性标的序号
   * @param lossItemCode 待设置的属性标的序号的值
   */
  public void setLossItemCode(String lossItemCode) {
    this.lossItemCode = StringUtils.rightTrim(lossItemCode);
  }

  /**
   * 获取属性标的序号
   * @return 属性标的序号的值
   */
  public String getLossItemCode() {
    return lossItemCode;
  }

  /**
   * 设置属性车牌号码
   * @param lossItemName 待设置的属性车牌号码的值
   */
  public void setLossItemName(String lossItemName) {
    this.lossItemName = StringUtils.rightTrim(lossItemName);
  }

  /**
   * 获取属性车牌号码
   * @return 属性车牌号码的值
   */
  public String getLossItemName() {
    return lossItemName;
  }

  /**
   * 设置属性是否为本保单车辆
   * @param insureCarFlag 待设置的属性是否为本保单车辆的值
   */
  public void setInsureCarFlag(String insureCarFlag) {
    this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
  }

  /**
   * 获取属性是否为本保单车辆
   * @return 属性是否为本保单车辆的值
   */
  public String getInsureCarFlag() {
    return insureCarFlag;
  }

  /**
   * 设置属性是否为本保单车辆
   * @param insureCarFlag 待设置的属性是否为本保单车辆的值
   */
  public void setDamageAddress(String damageAddress) {
    this.damageAddress = StringUtils.rightTrim(damageAddress);
  }

  public void setIsUpdateSumClaim(boolean isUpdateSumClaim) {
    this.isUpdateSumClaim = isUpdateSumClaim;
  }

  /**
   * 获取属性是否为本保单车辆
   * @return 属性是否为本保单车辆的值
   */
  public String getDamageAddress() {
    return damageAddress;
  }

  public boolean isIsUpdateSumClaim() {
    return isUpdateSumClaim;
  }

  //modify by wangwei add start 20050602
  //原因：增加报损金额和报损费用
  /**
   * 获取属性报损金额
   * @return报损金额
   * */
  public double getRegistEstimateLoss() {
  	  return this.registEstimateLoss;
  }

  /**
   * 设置属性报损金额
   * @param registEstmateLoss 报损金额*/
  public void setRegistEstimateLoss(double registEstmateLoss) {
  	  this.registEstimateLoss = registEstmateLoss;
  }

  /**
   * 获取属性报损费用
   * @return 报损费用
   * */
  public  double getRegistEstimateFee() {
  	  return this.registEstimateFee;
  }

  /**
   * 设置属性报损费用
   * @param registEstmateFee 报损费用*/
  public void setRegistEstimateFee(double registEstimateFee) {
  	  this.registEstimateFee = registEstimateFee;
  }
  //modify by wangwei add end 20050602

  /**
   * 获取属性报损费用
   * @return 报损费用
   * */
  public String getCoinsFlag() {
  	  return this.coinsFlag;
  }

  /**
   * 设置属性报损费用
   * @param registEstmateFee 报损费用*/
  public void setCoinsFlag(String coinsFlag) {
  	  this.coinsFlag = coinsFlag;
  }

  /**add by wuxiaodong 050905 begain
   * 设置属性币别
   * @return String
   */
  public String getCurrency() {
      return this.currency;
  }

  /**
   * 设置属性币别
   * @param currency 属性币别*/
  public void setCurrency(String currency) {
      this.currency = currency;
  }
  //add by wuxiaodong 050905 end


	/**
	 * @return Returns the insuredName.
	 */
	public String getInsuredName() {
		return insuredName;
	}
	/**
	 * @param insuredName The insuredName to set.
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
}
