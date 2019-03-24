package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
/**
 * 新案件提示数据传输对象
 * <p>Title: 新案件提示DTO</p>
 * <p>Description: 车险理赔理赔节点</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleObjectDto implements Serializable
{
   /** 调度机构设置信息*/
  private PrpLscheduleObjectDto prpLscheduleObjectDto;
  
   /** 公司机构信息*/
  private PrpDcompanyDto prpdcompanyDto;
  
  /** 编辑类型 */
    private String editType = "" ;
    
     /**需要弹出消息的内容*/
  String alertMessage="";
  
  
  
 /**得到调度主表信息
   * @return 调度主表信息
   */
  public PrpLscheduleObjectDto getPrpLscheduleObjectDto()
  {
    return prpLscheduleObjectDto;
  }

  /**设置调度主表信息
   * @param prpLscheduleObjectDto 调度主表信息
   */
  public void setPrpLscheduleObjectDto(PrpLscheduleObjectDto prpLscheduleObjectDto)
  {
     this.prpLscheduleObjectDto = prpLscheduleObjectDto;
  }
   /**得到调度主表信息
   * @return 调度主表信息
   */
  public PrpDcompanyDto getPrpdcompanyDto()
  {
    return prpdcompanyDto;
  }

  /**设置调度主表信息
   * @param prpdcompanyDto 调度主表信息
   */
  public void setPrpdcompanyDto(PrpDcompanyDto prpdcompanyDto)
  {
     this.prpdcompanyDto = prpdcompanyDto;
  }


  public String getEditType() {
    return editType;
  }
  
   public void setEditType(String editType) {
    this.editType = editType;
  }
  
     /**得到alertMessage信息
   * @return alertMessage信息
   */
   public String getAlertMessage() {
     return  alertMessage;
   }
   /**设置alertMessage信息
   * @param alertMessage信息
   */
   public void setAlertMessage(String alertMessage) {
     this.alertMessage = alertMessage;
   }

}
