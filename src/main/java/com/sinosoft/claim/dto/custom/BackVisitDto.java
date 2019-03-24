package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;

/**
 * 自定义回访数据传输对象
 * <p>Title: 车险理赔回访DTO</p>
 * <p>Description: 车险理赔回访程序</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */


public class BackVisitDto implements Serializable
{
  /** 回访主信息*/
  private PrpLbackVisitDto prpLbackVisitDto;

  /** 文本信息*/
  private ArrayList prpLbackVisitTextDtoList;

  /** 回访问询信息*/
  private ArrayList  prpLbackVisitQueDtoList;

  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  public BackVisitDto()
  {
  }

  /**得到回访主表信息
   * @return 回访主表信息
   */
  public PrpLbackVisitDto getPrpLbackVisitDto()
  {
    return prpLbackVisitDto;
  }

  /**设置回访主表信息
   * @param prpLclaimDto 回访主表信息
   */
  public void setPrpLbackVisitDto(PrpLbackVisitDto prpLbackVisitDto)
  {
     this.prpLbackVisitDto = prpLbackVisitDto;
  }

  /**得到回访文本信息
   * @return  回访文本信息
   */
  public ArrayList getPrpLbackVisitTextDtoList()
  {
    return prpLbackVisitTextDtoList;
  }
  /**设置回访文本信息
   * @param prpLclaimTextDtoList 回访文本信息
   */
  public void setPrpLbackVisitTextDtoList(ArrayList prpLbackVisitTextDtoList)
  {
    this.prpLbackVisitTextDtoList = prpLbackVisitTextDtoList;
  }

  /**得到回访问询信息
   * @return  回访问询信息
   */
  public ArrayList getPrpLbackVisitQueDtoList()
  {
    return prpLbackVisitQueDtoList;
  }

  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**设置回访问询信息
   * @param PrpLthirdPartyDtoList 回访问询表信息
   */
  public void setPrpLbackVisitQueDtoList(ArrayList prpLbackVisitQueDtoList)
  {
    this.prpLbackVisitQueDtoList = prpLbackVisitQueDtoList;
  }

  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

}
