package com.sinosoft.workbench.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplregist报案信息表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLregistDto extends PrpLregistDtoBase implements Serializable{
	
    private int countdate=0;
	 /** 属性报案标志 */  
    private String registFlag = "";
    /** 属性经办人名称 */  
    private String handlerName = "";
    /** 属性经办人名称 */
    private String handler1Name = "";
    /** 属性部门名称 */
    private String comName = "";
    /** 属性启保日期 */
    private String startDate = "";
    /** 属性操作员名称 */
    private String operatorName = "";
    /** 属性理赔登记机构 */
    private String makeComName = "";
    /** 属性终保日期 */
    private String endDate = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /** 属性出险开始分钟 */
    private String damageStartMinute = "";
    /** 属性处理单位名称 */
    private String handleUnitName = "";
    /** 属性接案人代码 */
    private String receiverCode = "";
    /** 属性事故所涉及险种 */
    private String referKind = "";
    /** 编辑类型 */
    private String editType = "";
    /** 属性报案分钟 */
    private String reportMinute = "";
    /** 交费情况 */
    private String payFlag = "";
    /** 单号 */
    private String certiNo = "";
    /** 单号类型 */
    private String certiType = "";
    /** 第三者亡人数 */
    private long personDeathB = 0;
    /** 第三者伤人数 */
    private long personInjureB = 0;
    /** 车上人员亡人数 */
    private long personDeathD1 = 0;
    /** 车上人员伤人数 */
    private long personInjureD1 = 0;

    /**属性此报案的操作状态 1。未处理 2。正在处理 3。已完成 4。已提交 5。 撤消 */
    private String status = "";//Modify By Sunhao,2004-08-24
    /**币别的名称*/
    private String estiCurrencyName="";
    
    /**被保险人类别*/
    private String customerType = "";

    /**属性此报案的操作时间*/
    private DateTime operateDate = new DateTime();//Modify By Sunhao,2004-08-24

    /** 属性出险次数 */
    private int perilCount = 0;
    /** 属性最近N天出险次数 */
    private int recentCount = 0;
    /** 属性流程编号 */
    private String flowID = "";

    /**排列记录的编号*/
    private int serialNo=0;

    /** 调度标的的详细内容*/
    private String scheduleItemNote="";

    /**出险原因代码*/
    private String prpLregistDamageCode = "";

    /**事故原因代码*/
    private String prpLregistDamageTypeCode = "";
    
    /**事故责任预估代码*/
    private String indemnityDuty = "";
      /** 属性标的序号 */
    private String lossItemCode = "";
    /** 列表*/ 
   Collection registList ;
    /** 一页数据*/
   TurnPageDto turnPageDto = null ;
   /**保险金额*/
   private double sumAmount = 0D;
  
   //mdoify by qinyongli  add begin  20050719   
   /**共保信息*/
   private String coinsFlag = "";
   //modify end
   
   //mdoify by wangli  add start 20050416  
   /** 属性代理人代码*/
   private String agentCode = "";
   
   /** 属性代理人名称*/
   private String agentName = "";
   
   /** 流入系统时间 */
   private  DateTime flowInTime = new DateTime();
   
   private  DateTime signDate = new DateTime();
   private  DateTime underWriteEndDate = new DateTime();
   private String othFlag = ""; 
   
   /** 属性被保险人显示名称 */
   private String insuredNameShow = "";
   
   /** 属性投保人单位显示名称 */
   private String appliNameShow = "";
   
   
   //modify by liuyanmei add 20051114 start
   private int startHour = 0;
   private int endHour = 0;
   
   private CompensateFeeDto compensateFeeDto;
   
   //相应的工作流ID
   private String workFlowId;
   
   //增加字段关联保单
   //add by zhouliu start at 2006-6-9
   //reason:强三查询
   private Collection relatepolicyNo=null;
   //add by zhouliu end at 2006-6-9
   
   //add by wunier 20071228
   //reason:增加农险统计中的赔付数量以及对应的数量单位
   private String lossesUnitCode;
   private double lossesNumber;
   //end by wunier 20071228
   private String businessType;
   private String businessType1;
   //分入标志：0－直接业务，1－分入业务
   private String businessFlag = "";
   //其他标志（对应prpcmain中的otherFlag）
   private String otherFlag = ""; 
   //赔案类别名称
   private String claimTypeName = "";
   /**
    * 设置属性被保险人名称
    * @param insuredName 待设置的属性被保险人名称的值
    */
   public void setInsuredNameShow(String insuredNameShow){
       this.insuredNameShow = StringUtils.rightTrim(insuredNameShow);
   }

   /**
    * 获取属性被保险人名称
    * @return 属性被保险人名称的值
    */
   public String getInsuredNameShow(){
       return insuredNameShow;
   }
   
   /**
    * 设置属性投保人单位名称
    * @param insuredName 待设置的属性投保人单位名称的值
    */
   public void setAppliNameShow(String appliNameShow){
       this.appliNameShow = StringUtils.rightTrim(appliNameShow);
   }

   /**
    * 获取属性投保人单位名称
    * @return 属性投保人单位名称的值
    */
   public String getAppliNameShow(){
       return appliNameShow;
   }
   
   //终保时间
   public void setEndHour(int endHour){
    this.endHour = endHour;
    }

   public int getEndHour(){
    return endHour;
   }
   //起保时间
   public void setStartHour(int startHour){
    this.startHour = startHour;
   }

   public int getStartHour(){
    return startHour;
   }
   
   //modify by liuyanmei add 20051114 end 
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
   
   /**
    * @return Returns the flowInTime.
    */
   public DateTime getFlowInTime() {
   	return flowInTime;
   }
   /**
    * @param flowInTime The flowInTime to set.
    */
   public void setFlowInTime(DateTime flowInTime) {
   	this.flowInTime = flowInTime;
   }
   
  //mdoify by wangli  add end 20050416  
 
  
   
   
    /**
     *  默认构造方法,构造一个默认的PrpLregistDto对象
     */


    public PrpLregistDto(){
    }

    /**
     * 设置属性操作员名称
     * @param makeComName 待设置的属性操作员名称的值
     */
    public void setMakeComName(String makeComName){
        this.makeComName = StringUtils.rightTrim(makeComName);
    }

    /**
     * 获取属性理赔登记机构
     * @return 属性理赔登记机构的值
     */
    public String getMakeComName(){
        return makeComName;
    }

    /**
     * 属性理赔登记机构
     * @param operatorName 待设置的属性理赔登记机构名称的值
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
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
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
     * 设置属性启保日期
     * @param startDate 待设置的属性启保日期的值
     */
    public void setStartDate(String startDate){
        this.startDate = StringUtils.rightTrim(startDate);
    }

    /**
     * 获取属性启保日期
     * @return 属性启保日期的值
     */
    public String getStartDate(){
        return startDate;
    }

    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(String endDate){
        this.endDate = StringUtils.rightTrim(endDate);
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public String getEndDate(){
        return endDate;
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
     * 设置属性出险开始分钟
     * @param damageStartMinute 待设置的属性出险开始分钟的值
     */
    public void setDamageStartMinute(String damageStartMinute){
        this.damageStartMinute = StringUtils.rightTrim(damageStartMinute);
    }

    /**
     * 获取属性出险开始分钟
     * @return 属性出险开始分钟的值
     */
    public String getDamageStartMinute(){
        return damageStartMinute;
    }

    /**
     * 设置属性接案人代码
     * @param receiverCode 待设置的属性接案人代码的值
     */
    public void setReceiverCode(String receiverCode){
        this.receiverCode = StringUtils.rightTrim(receiverCode);
    }

    /**
     * 获取属性接案人代码
     * @return 属性接案人代码的值
     */
    public String getReceiverCode(){
        return receiverCode;
    }

    /**
     * 设置属性处理单位名称
     * @param handleUnitName 待设置的属性处理单位名称的值
     */
    public void setHandleUnitName(String handleUnitName){
        this.handleUnitName = StringUtils.rightTrim(handleUnitName);
    }

    /**
     * 获取属性处理单位名称
     * @return 属性处理单位名称
     */
    public String getHandleUnitName(){
        return handleUnitName;
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

    public void setReportMinute(String reportMinute) {
      this.reportMinute = reportMinute;
    }

  /**
     * 获取属性操作时间名称
     * @param status 待设置的属性操作时间
     * Modify By Sunhao,2004-08-24
     */

    public DateTime getOperateDate(){
         return operateDate;
     }

     public String getReportMinute() {
       return reportMinute;
     }


     /**
     * 设置属性币别名称
     * @param estiCurrencyName 待设置的属性币别名称的值
     */
    public void setEstiCurrencyName(String estiCurrencyName){
        this.estiCurrencyName = StringUtils.rightTrim(estiCurrencyName);
    }

    /**
     * 获取属性币别名称
     * @return 属性币别名称
     */
    public String getEstiCurrencyName(){
        return estiCurrencyName;
    }
    
    /**
     * 设置属性被保险人类别
     * @param customerType 待设置的属性被保险人类别的值
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * 获取属性被保险人类别
     * @return 属性被保险人类别
     */
    public String getCustomerType(){
        return customerType;
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
     * 设置属性事故所涉及险种
     * @param referKind 待设置的属性事故所涉及险种的值
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * 获取属性事故所涉及险种
     * @return 属性事故所涉及险种的值
     */
    public String getReferKind(){
        return referKind;
    }

	public void setPayFlag(String payFlag) {
      this.payFlag = payFlag;
    }

  public void setFlowID(String flowID) {
    this.flowID = flowID;
  }

  public String getPayFlag() {
      return payFlag;
    }

  public String getFlowID() {
    return flowID;
  }

     /**
     * 设置属性排列记录的编号
     * @param serialNo 待设置的属性排列记录的编号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }

  /**
     * 获取属性排列记录的编号
     * @return 属性排列记录的编号
     */
    public int getSerialNo(){
        return serialNo;
    }

  public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }

  /**
     * 设置属性调度标的的详细内容
     * @param scheduleItemNote 待设置的属性调度标的的详细内容的值
     */
    public void setScheduleItemNote(String scheduleItemNote){
        this.scheduleItemNote = StringUtils.rightTrim(scheduleItemNote);
    }

    /**
     * 获取属性调度标的的详细内容
     * @return 属性调度标的的详细内容
     */
    public String getScheduleItemNote(){
        return scheduleItemNote;
    }

    /**
    * 设置属性出险原因代码的详细内容
    * @param prpLregistDamageCode 待设置的属性出险原因代码的详细内容的值
    */
   public void setPrpLregistDamageCode(String prpLregistDamageCode){
       this.prpLregistDamageCode = StringUtils.rightTrim(prpLregistDamageCode);
   }

   /**
    * 获取属性出险原因代码的详细内容
    * @return 属性出险原因代码的详细内容
    */
   public String getPrpLregistDamageCode(){
       return prpLregistDamageCode;
   }

   /**
    * 设置属性事故原因代码的详细内容
    * @param prpLregistDamageTypeCode 待设置的属性事故原因代码的详细内容的值
    */
   public void setPrpLregistDamageTypeCode(String prpLregistDamageTypeCode){
     this.prpLregistDamageTypeCode = StringUtils.rightTrim(prpLregistDamageTypeCode);
   }

  /**
   * 获取属性事故原因代码的详细内容
   * @return 属性事故原因代码的详细内容
   */
   public String getPrpLregistDamageTypeCode(){
     return prpLregistDamageTypeCode;
   }
   
     /**
    * 设置事故责任预估代码的详细内容
    * @param prpLregistDamageTypeCode 待设置的事故责任预估代码的详细内容的值
    */
   public void setIndemnityDuty(String indemnityDuty){
     this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
   }

  /**
   * 获取属性事故责任预估代码的详细内容
   * @return 属性事故责任预估代码的详细内容
   */
   public String getIndemnityDuty(){
     return indemnityDuty;
   }
   
   /**
     * 设置属性标的序号
     * @param lossItemCode 待设置的属性标的序号的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }


	/**
	 * @return Returns the recentCount.
	 */
	public int getRecentCount() {
		return recentCount;
	} 
	/**
	 * @param recentCount The recentCount to set.
	 */
	public void setRecentCount(int recentCount) {
		this.recentCount = recentCount;
	}
	
	//modify by wangwei add start 2005-06-08
	//原因：意键险的报案画面需要显示保单中的保险金额
	/**
	 * 设置属性的保险金额
	 * @param sumAmount 待设置属性的保险金额*/
	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}	
	/**
	 * 获得属性的保险金额
	 * @return 属性的保险金额*/
	public double getSumAmount() {
		return this.sumAmount;
	}
	//modify by wangwei add end 2005-06-08
	
	/**
     * 设置单号
     * @param certiNo 单号
     */
	public void setCertiNo(String certiNo){
		this.certiNo = certiNo;
	}
	/**
     * 获取单号
     * @return 单号
     */
	public String getCertiNo(){
		return certiNo;
	}
	/**
     * 设置单号类型
     * @param certiType 单号类型
     */
	public void setCertiType(String certiType){
		this.certiType = certiType;
	}
	/**
     * 获取属性单号类型
     * @return 属性单号类型
     */
	public String getCertiType(){
		return certiType;
	}
	/**
     * 设置属性第三者亡人数
     * @param personDeathB 第三者亡人数
     */
	public void setPersonDeathB(long personDeathB){
		this.personDeathB = personDeathB;
	}
	/**
     * 获取属性第三者亡人数
     * @return 属性第三者亡人数
     */
	public long getPersonDeathB(){
		return personDeathB;
	}
	/**
     * 设置属性第三者伤人数
     * @param personInjureB 第三者伤人数
     */
	public void setPersonInjureB(long personInjureB){
		this.personInjureB = personInjureB;
	}
	/**
     * 获取属性第三者伤人数
     * @return 属性第三者伤人数
     */
	public long getPersonInjureB(){
		return personInjureB;
	}
	/**
     * 设置属性车上人员亡人数
     * @param personDeathD1 车上人员亡人数
     */
	public void setPersonDeathD1(long personDeathD1){
		this.personDeathD1 = personDeathD1;
	}
	/**
     * 获取属性车上人员亡人数
     * @return 属性车上人员亡人数
     */
	public long getPersonDeathD1(){
		return personDeathD1;
	}
	/**
     * 设置属性车上人员伤人数
     * @param personInjureD1 车上人员伤人数
     */
	public void setPersonInjureD1(long personInjureD1){
		this.personInjureD1 = personInjureD1;
	}
	/**
     * 获取属性车上人员伤人数
     * @return 属性车上人员伤人数
     */
	public long getPersonInjureD1(){
		return personInjureD1;
	}
    public DateTime getSignDate() {
        return signDate;
    }
    public void setSignDate(DateTime signDate) {
        this.signDate = signDate;
    }
    
    public DateTime getUnderWriteEndDate() {
        return underWriteEndDate;
    }
    public void setUnderWriteEndDate(DateTime underWriteEndDate) {
        this.underWriteEndDate = underWriteEndDate;
    }
    
    public String getOthFlag() {
        return othFlag;
    }
    public void setOthFlag(String othFlag) {
        this.othFlag = othFlag;
    }
    //共保标志
    public String getCoinsFlag() {
        return coinsFlag;
    }
    public void setCoinsFlag(String coinsFlag) {
        this.coinsFlag = coinsFlag;
    }

	public CompensateFeeDto getCompensateFeeDto() {
		return compensateFeeDto;
	}

	public void setCompensateFeeDto(CompensateFeeDto compensateFeeDto) {
		this.compensateFeeDto = compensateFeeDto;
	}

	public String getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}

	//add by zhouliu start at 2006-6-9
	//reason:强三查询
	public Collection getRelatepolicyNo() {
		return relatepolicyNo;
	}

	public void setRelatepolicyNo(Collection relatepolicyNo) {
		this.relatepolicyNo = relatepolicyNo;
	}
	//add by zhouliu end at 2006-6-9
	

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
	 * @return the claimTypeName
	 */
	public String getClaimTypeName() {
		return claimTypeName;
	}

	/**
	 * @param claimTypeName the claimTypeName to set
	 */
	public void setClaimTypeName(String claimTypeName) {
		this.claimTypeName = claimTypeName;
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

	public String getRegistFlag() {
		return registFlag;
	}

	public void setRegistFlag(String registFlag) {
		this.registFlag = registFlag;
	}

    public int getCountdate() {
        return countdate;
    }

    public void setCountdate(int countdate) {
        this.countdate = countdate;
    }


	
}



