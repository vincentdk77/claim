package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 新案件提示数据传输对象
 * <p>Title: 新案件提示DTO</p>
 * <p>Description: 车险理赔理赔节点</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleDto implements Serializable
{
   /** 调度主表信息*/
  private PrpLscheduleMainWFDto prpLscheduleMainWFDto;
  
   /** 改派的定损调度*/
  private PrpLscheduleItemDto prpLscheduleItemDto;
  
  
   /** 三者车辆信息*/
  private ArrayList  prpLthirdPartyDtoList ;
  /** 调度表的信息*/
  private ArrayList  prpLscheduleItemDtoList ;
  /** 查勘表标的信息*/
  private ArrayList  prpLcheckItemDtoList ;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList;
  
 
  private ArrayList  smcComCodeInfoDtoList ;
  private ArrayList  smSendSMListDtoList;
  /** 回访信息 */
  private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
  
  public ArrayList getSmcComCodeInfoDtoList()
  {
    return smcComCodeInfoDtoList;
  }
 
  public void setSmcComCodeInfoDtoList(ArrayList smcComCodeInfoDtoList)
  {
    this.smcComCodeInfoDtoList = smcComCodeInfoDtoList;
  }
  
  public ArrayList getSmSendSMListDtoList()
  {
    return smSendSMListDtoList;
  }
 
  public void setSmSendSMListDtoList(ArrayList smSendSMListDtoList)
  {
    this.smSendSMListDtoList = smSendSMListDtoList;
  }
  
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
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  
   /** 属性调度处理标志 */
    private String scheduleType = "";
  
   public ScheduleDto()
  {
  }

  /**得到调度主表信息
   * @return 调度主表信息
   */
  public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto()
  {
    return prpLscheduleMainWFDto;
  }

  /**设置调度主表信息
   * @param prpLscheduleMainWFDto 调度主表信息
   */
  public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto)
  {
     this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
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

   /**得到调度操作状态信息
    * @return 调度操作状态信息
    */
   public PrpLclaimStatusDto getPrpLclaimStatusDto()
   {
     return prpLclaimStatusDto;
   }

   /**设置调度操作状态信息
    * @param prpLclaimStuatsDto 调度操作状态信息
    */
   public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
   {
      this.prpLclaimStatusDto = prpLclaimStatusDto;
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


/**得到查勘标的信息
   * @return  查勘标的信息
   */
  public ArrayList getPrpLcheckItemDtoList()
  {
    return prpLcheckItemDtoList;
  }
  /**设置查勘标的信息
   * @param PrpLcheckItemDto查勘标的信息
   */
  public void setPrpLcheckItemDtoList(ArrayList prpLcheckItemDtoList)
  {
    this.prpLcheckItemDtoList = prpLcheckItemDtoList;
  }
  
      /**
     * 设置属性调度处理标志
     * @param scheduleType 待设置的属性调度处理标志的值
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * 获取属性调度处理标志
     * @return 属性调度处理标志的值
     */
    public String getScheduleType(){
        return scheduleType;
    }
    
     /**得到调度改派状态信息
    * @return 调度改派状态信息
    */
   public PrpLscheduleItemDto getPrpLscheduleItemDto()
   {
     return prpLscheduleItemDto;
   }

   /**设置调度改派状态信息
    * @param prpLclaimStuatsDto 调度改派状态信息
    */
   public void setPrpLscheduleItemDto(PrpLscheduleItemDto prpLscheduleItemDto)
   {
      this.prpLscheduleItemDto = prpLscheduleItemDto;
   }

   public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
   }

   public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
   }
   
}
