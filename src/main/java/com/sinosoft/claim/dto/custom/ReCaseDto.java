package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
/**
 * 自定义保单数据传输对象
 * <p>Title: 车险理赔保单DTO</p>
 * <p>Description: 车险理赔保单样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class ReCaseDto implements Serializable
{
  /** 保单主信息*/
  private PrpCmainDto prpCmainDto;
  /** 保费信息*/
  private PrpLclaimDto  prpLclaimDto ;
  private PrpLrecaseDto  prpLrecaseDto ;
  /** 保费信息*/
  private ArrayList  prpLrecaseDtoList ;
  
  public ReCaseDto()
  {
  }

  public ArrayList getPrpLrecaseDtoList()
  {
    return prpLrecaseDtoList;
  }
  /**设置itemkind信息
   * @param prpCitemKindDtoList itemkind表信息
   */
  public void setPrpLrecaseDtoList(ArrayList prpLrecaseDtoList)
  {
    this.prpLrecaseDtoList = prpLrecaseDtoList;
  }

  
  
  /**得到保单主表信息
   * @return 保单主表信息
   */
  public PrpCmainDto getPrpCmainDto()
  {
    return prpCmainDto;
  }

  /**设置保单主表信息
   * @param prpCmainDto 保单主表信息
   */
  public void setPrpCmainDto(PrpCmainDto prpCmainDto)
  {
     this.prpCmainDto = prpCmainDto;
  }

  /**得到保单主表信息
   * @return 保单主表信息
   */
  public PrpLclaimDto getPrpLclaimDto()
  {
    return prpLclaimDto;
  }

  /**设置保单主表信息
   * @param prpCmainDto 保单主表信息
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto)
  {
     this.prpLclaimDto = prpLclaimDto;
  }
  /**得到保费信息
   * @return  保费信息
   */
  public PrpLrecaseDto getPrpLrecaseDto()
  {
    return prpLrecaseDto;
  }
  /**设置费表信息
   * @param PrpCfeeDto 保费表信息
   */
  public void setPrpLrecaseDto(PrpLrecaseDto prpLrecaseDto)
  {
    this.prpLrecaseDto = prpLrecaseDto;
  }
}
  

