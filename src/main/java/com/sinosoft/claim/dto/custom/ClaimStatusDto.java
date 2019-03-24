package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;

/**
 * 自定义理赔节点状态数据传输对象
 * <p>Title: 车险理赔理赔节点状态DTO</p>
 * <p>Description: 车险理赔理赔节点状态样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class ClaimStatusDto implements Serializable
{
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  public ClaimStatusDto()
  {
  }

  /**设置操作状态信息
   * @param prpLclaimStatusDto 操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
  {
     this.prpLclaimStatusDto = prpLclaimStatusDto;
  }
  /**得到操作状态信息
   * @return  操作状态信息
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

}
