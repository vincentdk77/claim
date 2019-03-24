package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 自定义查勘数据传输对象
 * <p>Title: 车险理赔查勘DTO</p>
 * <p>Description: 车险理赔查勘样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
public class CheckDto implements Serializable
{
  /** 查勘主信息*/
  private PrpLcheckDto prpLcheckDto;
  /** 查勘扩展信息 */
  private ArrayList prpLcheckExtDtoList;
  /** 事故估损金额 */
  private ArrayList prpLcheckLossDtoList;
  /** 耳标号信息 */
  private ArrayList prpLcompensateeartDtoList;
  /** 并案prpLcheckDto信息 */
  private ArrayList prpLcheckDtoList;
  /** 操作状态信息(并案)*/
  private ArrayList prpLclaimStatusDtoList;
  private ArrayList prplCompensateHouseDtoList;

  /**新增加了定损的标的*/
  private boolean newScheduleItem=false;
  
     /** 调度标的的详细内容*/
     private String scheduleItemNote="";
     
/**
 * @return Returns the prpLregistExtDtoList.
 */
public ArrayList getPrpLregistExtDtoList() {
	return prpLregistExtDtoList;
}
/**
 * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
 */
public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
	this.prpLregistExtDtoList = prpLregistExtDtoList;
}
  /** 三者车辆信息*/
  private ArrayList  prpLthirdPartyDtoList;
  /** 人员伤亡跟踪信息*/
  private ArrayList prpLpersonTraceDtoList;
  /** 驾驶员信息*/
  private ArrayList prpLdriverDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList;
  /** 查勘报告*/
  private ArrayList prpLregistTextDtoList;
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
   /** 调度表的信息*/
  private ArrayList  prpLscheduleItemDtoList;

  //modify by wangli add start 20050406
  /** 特别约定信息*/
  private ArrayList  prpCengageDtoList;

  /** 损失部位信息*/
  private ArrayList prpLthirdCarLossDtoList;

  /** 损失部位信息*/
  private ArrayList prpLthirdPropDtoList;
  
  /**调查信息*/
  private AcciCheckDto acciChcekDto;
  
  /** 货运险扩展信息 add by qinyongli 2005-8-30*/
  private PrpLextDto prpLextDto; 
  /**详细出险原因信息*/
  private ArrayList prpLregistTextDtoList3;
  
  public ArrayList getPrpLcompensateeartDtoList() {
	return prpLcompensateeartDtoList;
  }
  public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
	this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
  }
  
  public ArrayList getPrpLregistTextDtoList3() {
	return prpLregistTextDtoList3;
  }
  public void setPrpLregistTextDtoList3(ArrayList prpLregistTextDtoList3) {
	this.prpLregistTextDtoList3 = prpLregistTextDtoList3;
  }
  
  public ArrayList getPrplCompensateHouseDtoList() {
	  	return prplCompensateHouseDtoList;
	  }
	  /**设置耳标号损失清单
	   * @param prplCompensateEarDtoList 耳标号损失清单
	   */
	  public void setPrplCompensateHouseDtoList(ArrayList prplCompensateHouseDtoList) {
	    this.prplCompensateHouseDtoList = prplCompensateHouseDtoList;
	  }
/**
 * 
   * 设置货运险扩展信息
   * @param PrpLextDto 货运险扩展信息
   * */
  public void setPrpLextDto(PrpLextDto prpLextDto) {
  	  this.prpLextDto = prpLextDto;
  }
  /**
   * 获得货运险扩展信息
   * @return 货运险扩展信息*/
  public PrpLextDto getPrpLextDto() {
  	  return this.prpLextDto;
  }
  
  /**
   * 设置调查信息
   * @param acciChcekDto 调查信息
   * */
  public void setAcciCheckDto(AcciCheckDto acciCheckDto) {
  	  this.acciChcekDto = acciCheckDto;
  }
  
  /**
   * 获得调查信息
   * @return 调查信息*/
  public AcciCheckDto getAcciCheckDto() {
  	  return this.acciChcekDto;
  }

  /**
   * @return Returns the prpCengageDtoList.
   */
  public ArrayList getPrpCengageDtoList() {
  	return prpCengageDtoList;
  }
  /**
   * @param prpCengageDtoList The prpCengageDtoList to set.
   */
  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
  	this.prpCengageDtoList = prpCengageDtoList;
  }
  //modify by wangli add start 20050406


  /**得到查勘主信息
   * @return 查勘主信息
   */
  public PrpLcheckDto getPrpLcheckDto() {
    return prpLcheckDto;
  }

  /**得到操作状态信息
   * @return 操作状态信息
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**设置查勘报告
   * @param prpLregistTextDtoList 查勘报告
   */
  public void setPrpLregistTextDtoList(ArrayList prpLregistTextDtoList) {
    this.prpLregistTextDtoList = prpLregistTextDtoList;
  }

  /**设置查勘主信息
   * @param prpLcheckDto 查勘主信息
   */
  public void setPrpLcheckDto(PrpLcheckDto prpLcheckDto) {
    this.prpLcheckDto = prpLcheckDto;
  }

  /**设置查勘报告
   * @param prpLregistTextDtoList 查勘报告
   */
  public ArrayList getPrpLregistTextDtoList() {
    return prpLregistTextDtoList;
  }

  /**得到三者车辆信息
   * @return  三者车辆信息
   */
  public ArrayList getPrpLthirdPartyDtoList()
  {
    return prpLthirdPartyDtoList;
  }

  /**设置三者车辆信息
   * @param PrpLthirdPartyDtoList 三者车辆表信息
   */
  public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList)
  {
    this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
  }

  /**得到驾驭员信息
   * @return  驾驭员 信息
   */
  public ArrayList getPrpLdriverDtoList()
  {
    return prpLdriverDtoList;
  }

  /**设置驾驭员信息
   * @param PrpLdriverDtoList 驾驭员表信息
   */
  public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList)
  {
    this.prpLdriverDtoList = prpLdriverDtoList;
  }

  /**得到查勘扩展信息
   * @return  查勘扩展信息
   */
  public ArrayList getPrpLcheckExtDtoList()
  {
    return prpLcheckExtDtoList;
  }

  /**设置查勘扩展信息
   * @param PrpLcheckExtDtoList 查勘扩展信息
   */
  public void setPrpLcheckExtDtoList(ArrayList prpLcheckExtDtoList)
  {
    this.prpLcheckExtDtoList = prpLcheckExtDtoList;
  }

  /**得到事故估损金额信息
   * @return  事故估损金额信息
   */
  public ArrayList getPrpLcheckLossDtoList()
  {
    return prpLcheckLossDtoList;
  }

  /**设置事故估损金额信息
   * @param prpLcheckLossDtoList 事故估损金额信息
   */
  public void setPrpLcheckLossDtoList(ArrayList prpLcheckLossDtoList)
  {
    this.prpLcheckLossDtoList = prpLcheckLossDtoList;
  }

  /**设置操作状态信息
   * @param prpLclaimStatusDto 操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

      /**得到人伤跟踪信息
   * @return  人伤跟踪 信息
   */
  public ArrayList getPrpLpersonTraceDtoList()
  {
    return prpLpersonTraceDtoList;
  }
  /**设置人伤跟踪信息
   * @param PrpLpersonTraceDtoList 人伤跟踪表信息
   */
  public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList)
  {
    this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
  }

   /**得到调度标的信息
   * @return  调度标的信息
   */
  public ArrayList getPrpLscheduleItemDtoList()
  {
    return prpLscheduleItemDtoList;
  }
  /**设置调度标的信息
   * @param PrpLscheduleItemDto调度标的信息
   */
  public void setPrpLscheduleItemDtoList(ArrayList prpLscheduleItemDtoList)
  {
    this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
  }

  /**得到损失部位信息
   * @return  损失部位信息
   */
   public ArrayList getPrpLthirdCarLossDtoList() {
     return prpLthirdCarLossDtoList;
  }

  /**设置调度标的信息
    * @param prpLthirdCarLossDtoList调度标的信息
    */
   public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
     this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
   }

   /**设置其它损失信息
    * @param prpLthirdPropDtoList 其它损失信息
    */

    public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
     this.prpLthirdPropDtoList = prpLthirdPropDtoList;
    }

    /**得到其它损失信息
     * @return  其它损失信息
     */

     public ArrayList getPrpLthirdPropDtoList() {
       return prpLthirdPropDtoList;
     }

     /**得到新增定损标的
      * @return 新增定损标的
      */
     public boolean getNewScheduleItem()
     {
       return newScheduleItem;
     }

     /**设置新增定损标的
      * @param boolean 新增定损标的
      */
     public void setNewScheduleItem(boolean newScheduleItem)
     {
        this.newScheduleItem = newScheduleItem;
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

       public ArrayList getPrpLcheckDtoList() {
    		return prpLcheckDtoList;
    	}
    	public void setPrpLcheckDtoList(ArrayList prpLcheckDtoList) {
    		this.prpLcheckDtoList = prpLcheckDtoList;
    	}
    	
    	public ArrayList getPrpLclaimStatusDtoList() {
    		return prpLclaimStatusDtoList;
    	}
    	public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
    		this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
    	}

  public CheckDto()
  {
  }



}
