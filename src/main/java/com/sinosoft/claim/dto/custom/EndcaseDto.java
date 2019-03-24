package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * 自定义结案数据传输对象
 * <p>Title: 车险理赔结案DTO</p>
 * <p>Description: 车险理赔结案样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class EndcaseDto implements Serializable
{
  /** 赔案号表主信息*/
  private ArrayList prpLcaseNoDtoList;
  /** 立案信息*/
  private PrpLclaimDto prpLclaimDto;
  
  
  private PrpLrecaseDto prpLrecaseDto;
  /** 赔款计算书信息*/
  private ArrayList prpLcompensateDtoList;
  /** 结案报告*/
  private ArrayList prpLltextDtoList;
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**出险原因详细信息*/
  private ArrayList prpLltextDtoList3;
  
  /** 回访主表 */
	private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
	
  public ArrayList getPrpLltextDtoList3() {
	return prpLltextDtoList3;
  }

  public void setPrpLltextDtoList3(ArrayList prpLltextDtoList3) {
	this.prpLltextDtoList3 = prpLltextDtoList3;
  }

/**得到赔款计算书主信息
   * @return 赔款计算书主信息
   */
  public ArrayList getPrpLcompensateDtoList() {
    return prpLcompensateDtoList;
  }

  /**得到结案文本信息
   * @return  结案文本信息
   */
  public ArrayList getPrpLltextDtoList() {
    return prpLltextDtoList;
  }

  /**得到立案主表信息
   * @return 立案主表信息
   */
  public PrpLclaimDto getPrpLclaimDto() {
    return prpLclaimDto;
  }
  
  public PrpLrecaseDto getPrpLrecaseDto() {
    return prpLrecaseDto;
  }
  /**得到结案主表信息
   * @return 结案主表信息
   */
  public ArrayList getPrpLcaseNoDtoList() {
    return prpLcaseNoDtoList;
  }
  
  /**设置操作状态信息
   * @param prpLclaimStatusDto 操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }
    
  /**设置赔款计算书主信息
   * @param setPrpLcompensateDtoList 赔款计算书主信息
   */
  public void setPrpLcompensateDtoList(ArrayList prpLcompensateDtoList) {
    this.prpLcompensateDtoList = prpLcompensateDtoList;
  }

  /**设置结案文本信息
   * @param prpLltextDtoList 结案文本信息
   */
  public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
    this.prpLltextDtoList = prpLltextDtoList;
  }
  
  /**设置立案主表信息
   * @param prpLclaimDto 立案主表信息
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
    this.prpLclaimDto = prpLclaimDto;
  }
  
  public void setPrpLrecaseDto(PrpLrecaseDto prpLrecaseDto) {
    this.prpLrecaseDto = prpLrecaseDto;
  }

  /**设置结案主表信息
   * @param prpLperpayDto 结案主表信息
   */
  public void setPrpLcaseNoDtoList(ArrayList prpLcaseNoDtoList) {
    this.prpLcaseNoDtoList = prpLcaseNoDtoList;
  }
  
  /**得到操作状态信息
   * @return  操作状态信息
   */   
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
  }

  public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
  }

  public EndcaseDto()
  {
  }


}
