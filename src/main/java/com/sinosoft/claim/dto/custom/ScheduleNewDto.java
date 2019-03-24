package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;

/**
 * 新案件提示数据传输对象
 * <p>Title: 新案件提示DTO</p>
 * <p>Description: 车险理赔理赔节点</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleNewDto implements Serializable
{
  /** 操作状态信息*/
  private PrpLscheduleNewDto prpLscheduleNewDto;

  public ScheduleNewDto()
  {
  }

  /**设置操作状态信息
   * @param prpLscheduleNewDto 操作状态信息
   */
  public void setPrpLscheduleNewDto(PrpLscheduleNewDto prpLscheduleNewDto)
  {
     this.prpLscheduleNewDto = prpLscheduleNewDto;
  }
  /**得到操作状态信息
   * @return  操作状态信息
   */
  public PrpLscheduleNewDto getPrpLscheduleNewDto() {
    return prpLscheduleNewDto;
  }

}
