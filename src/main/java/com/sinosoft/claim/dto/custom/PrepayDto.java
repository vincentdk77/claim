package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;

/**
 * 自定义预赔数据传输对象
 * <p>Title: 车险理赔预赔DTO</p>
 * <p>Description: 车险理赔预赔样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class PrepayDto implements Serializable
{
  /** 预赔主信息*/
  private PrpLprepayDto prpLprepayDto;
  /** 预赔报告*/
  private ArrayList prpLptextDtoList;
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /** 立案信息*/
  private PrpLclaimDto prpLclaimDto;
  /** 预付费用信息 */
  private ArrayList prpLpreChargeDtoList;

  public PrepayDto()
  {
  }

  /**得到预赔主表信息
   * @return 预赔主表信息
   */
  public PrpLprepayDto getPrpLprepayDto()
  {
    return prpLprepayDto;
  }

  /**设置预赔主表信息
   * @param prpLperpayDto 预赔主表信息
   */
  public void setPrpLprepayDto(PrpLprepayDto prpLprepayDto)
  {
     this.prpLprepayDto = prpLprepayDto;
  }

  /**得到预赔文本信息
   * @return  预赔文本信息
   */
  public ArrayList getPrpLptextDtoList()
  {
    return prpLptextDtoList;
  }

  /**得到操作状态信息
   * @return  操作状态信息
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**得到立案信息
   * @return  立案信息
   */
  public PrpLclaimDto getPrpLclaimDto() {
    return prpLclaimDto;
  }

  /**设置预赔文本信息
   * @param prpLperpayTextDtoList 预赔文本信息
   */
  public void setPrpLptextDtoList(ArrayList prpLptextDtoList)
  {
    this.prpLptextDtoList = prpLptextDtoList;
  }

  /**设置操作状态信息
   * @param prpLclaimStatusDto 操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**设置立案信息
   * @param prpLclaimDto 立案信息
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
    this.prpLclaimDto = prpLclaimDto;
  }

	public ArrayList getPrpLpreChargeDtoList() {
		return prpLpreChargeDtoList;
	}
	
	public void setPrpLpreChargeDtoList(ArrayList prpLpreChargeDtoList) {
		this.prpLpreChargeDtoList = prpLpreChargeDtoList;
	}

}
