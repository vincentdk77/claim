package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
/**
 * 新案件提示数据传输对象
 * <p>Title: 新案件提示DTO</p>
 * <p>Description: 车险理赔理赔节点</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleCompanyDto implements Serializable
{
   /** 调度中心设置信息*/
  private PrpLscheduleCompanyDto prpLscheduleCompanyDto;
  
   /** 调度中心电话表*/
  private Collection  prpLschecduleCompanyMobileDtoList ;
  
  
public Collection getPrpLschecduleCompanyMobileDtoList() {
	return prpLschecduleCompanyMobileDtoList;
}
/**
 * @param prpLschecduleCompanyMobileDtoList The prpLschecduleCompanyMobileDtoList to set.
 */
public void setPrpLschecduleCompanyMobileDtoList(Collection prpLschecduleCompanyMobileDtoList) {
	this.prpLschecduleCompanyMobileDtoList = prpLschecduleCompanyMobileDtoList;
}

  /**得到调度主表信息
   * @return 调度主表信息
   */
  public PrpLscheduleCompanyDto getPrpLscheduleCompanyDto()
  {
    return prpLscheduleCompanyDto;
  }

  /**设置调度主表信息
   * @param prpLscheduleCompanyDto 调度主表信息
   */
  public void setPrpLscheduleCompanyDto(PrpLscheduleCompanyDto prpLscheduleCompanyDto)
  {
     this.prpLscheduleCompanyDto = prpLscheduleCompanyDto;
  }

}
