package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLscheduleMainWF的数据传输对象类<br>
 * 创建于 2005-03-18 16:42:18.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainWFDto extends PrpLscheduleMainWFDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleMainWFDto对象
     */
    public PrpLscheduleMainWFDto(){
    }
   /** 属性部门名称 */
    private String claimComName = "";
    /** 属性操作员名称 */
    private String operatorName = "";
    /** 属性联系电话 */
   private String phoneNumber = "";
   /** 属性联系人 */
   private String linkerName = "";
   /**出险详细情况，出险摘要*/
   private String registText = "";
   /**节点状态信息*/
   private String status="";
   /**查勘操作员姓名*/
   private String checkOperatorName = "";//Modify By sunhao 2004-08-24
   /**车牌号码*/
   private String licenseNo = "";//Modify By sunhao 2004-08-24

   /** 属性出险次数 */
    private int perilCount = 0;
    /** 新节点人的代码 */
    private String newHandlerCode = "";
  
   /**保存的类别 cancel 表示是撤消的保存 getback 表示是取回的保存 其他的为正常保存*/
   private String saveType="";

   /** 属性显示列表*/
   private Collection scheduleList ;

   /** 属性案件双代标志 add by liyanjie 2005-12-06*/
   private String commiFlag ;
   
// mdoify by wangli  add start 20050416  
   /** 属性代理人代码*/
   private String agentCode = "";
   
   /** 属性代理人名称*/
   private String agentName = "";

    /** 属性估损金额 */
    private double estimateLoss = 0d;
    
      //modify by wangwei add start 205-6-13
    /** 属性估损费用 */
    private double estimateFee = 0d;
    
    //add by zhaolu 20060801 start
    TurnPageDto turnPageDto = null;
    //add by zhaolu 20060801 end
    
    
    /**
     * 设置属性估损费用
     * @param estimateFee 待设置的属性估损费用
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * 获取属性估损费用
     * @return 属性属性估损费用
     */
    public double getEstimateFee(){
        return estimateFee;
    }
    //modify by wangwei add end 2005-6-13
   
   
   /**
    * @return Returns the agentCode.
    */
   public String getAgentCode() {
   	return agentCode;
   }
   /**
    * @param agentCode The agentCode to set.
    */
   public void setAgentCode(String agentCode) {
   	this.agentCode = agentCode;
   }
   /**
    * @return Returns the agentName.
    */
   public String getAgentName() {
   	return agentName;
   }
   /**
    * @param agentName The agentName to set.
    */
   public void setAgentName(String agentName) {
   	this.agentName = agentName;
   }
   
  //mdoify by wangli  add end 20050416  
   
    /**
     * 设置属性部门
     * @param comName 待设置的属性部门的值
     */
    public void setClaimComName(String claimComName){
        this.claimComName = StringUtils.rightTrim(claimComName);
    }

    /**
     * 获取属性部门
     * @return 属性部门的值
     */
    public String getClaimComName(){
        return claimComName;
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
    * 设置属性联系电话
    * @param phoneNumber 待设置的属性联系电话的值
    */
   public void setPhoneNumber(String phoneNumber){
       this.phoneNumber = StringUtils.rightTrim(phoneNumber);
   }

   /**
    * 获取属性联系电话
    * @return 属性联系电话的值
    */
   public String getPhoneNumber(){
       return phoneNumber;
   }

   /**
    * 设置属性联系人
    * @param linkerName 待设置的属性联系人的值
    */
   public void setLinkerName(String linkerName){
       this.linkerName = StringUtils.rightTrim(linkerName);
   }

   /**
    * 获取属性联系人
    * @return 属性联系人的值
    */
   public String getLinkerName(){
       return linkerName;
   }

   /**
   * 设置属性出险详细情况，出险摘要
   * @param registText 待设置的属性出险详细情况，出险摘要的值
   */
  public void setRegistText(String registText){
      this.registText = StringUtils.rightTrim(registText);
  }

  /**
   * 获取属性出险详细情况，出险摘要
   * @return 属性出险详细情况，出险摘要的值
   */
  public String getRegistText(){
      return registText;
  }
 /**
     * 获取属性操作状态
     * @return 属性操作状态
     */
    public String getStatus(){
        return status;
    }

    /**
     * 设置属性操作状态
     * @param status 待设置的属性操作状态
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
    public void setScheduleList(Collection scheduleList) {
      this.scheduleList = scheduleList;
    }

  /**得到属性显示列表
  * @return 属性显示列表
  */
    public Collection getScheduleList() {
      return scheduleList;
    }
    /**
     * 获取保存类别操作状态
     * @return 保存类别操作状态
     */
    public String getSaveType(){
        return saveType;
    }

    /**
     * 设置保存类别操作状态
     * @param saveType 待设置的保存类别操作状态
     */
    public void setSaveType(String saveType){
        this.saveType = StringUtils.rightTrim(saveType);
    }

    /**
     * 获取查勘操作员姓名
     * @return 查勘操作员姓名
     * Modify By sunhao 2004-08-24
     */
    public String getCheckOperatorName(){
        return checkOperatorName;
    }

    /**
     * 设置查勘操作员姓名
     * @param saveType 待设置的查勘操作员姓名
     * Modify By sunhao 2004-08-24
     */
    public void setCheckOperatorName(String checkOperatorName){
        this.checkOperatorName = StringUtils.rightTrim(checkOperatorName);
    }

    /**
     * 获取车牌号码
     * @return 车牌号码
     * Modify By sunhao 2004-08-24
     */
        public String getLicenseNo(){
            return licenseNo;
        }

    /**
     * 设置车牌号码
     * @param saveType 待设置的车牌号码
     * Modify By sunhao 2004-08-24
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
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
     * 设置属性新节点人的代码
     * @param nextHandlerCode 待设置的属性新节点人的代码的值
     */
    public void setNewHandlerCode(String newHandlerCode){
        this.newHandlerCode = StringUtils.rightTrim(newHandlerCode);
    }

    /**
     * 获取属性新节点人的代码
     * @return 属性新节点人的代码的值
     */
    public String getNewHandlerCode(){
        return newHandlerCode;
    }

    /**
     * 设置属性估损金额
     * @param estimateLoss 待设置的属性估损金额的值
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * 获取属性估损金额
     * @return 属性估损金额的值
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }
    


  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }
 public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }

 /**
  * 设置属性案件双代标识
  * @param commiFlag 待设置的属性案件双代标识的值
  */
 public void setCommiFlag(String commiFlag){
     this.commiFlag = commiFlag;
 }

 /**
  * 获取属性案件双代标识
  * @return 属性案件双代标识的值
  */
 public String getCommiFlag(){
     return commiFlag;
 }


}
