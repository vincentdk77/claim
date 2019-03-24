package com.sinosoft.claim.dto.custom;

import com.sinosoft.claim.dto.domain.PrpDuserDto;

/**
 * 自定义登录数据传输对象
 * <p>Title: claim</p>
 * <p>Description: 理赔系统样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔产品
 * @version 1.0
 */

public class LogonDto
{
  /** 用户信息*/
  private PrpDuserDto prpDuserDto;

  public void setPrpDuserDto(PrpDuserDto prpDuserDto)
  {
    this.prpDuserDto = prpDuserDto;
  }

  public PrpDuserDto getPrpDuserDto()
  {
    return prpDuserDto;
  }
  public LogonDto(){}
}
