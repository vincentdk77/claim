package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.claim.dto.domain.PrpPmainDto;

/**
 * 自定义批单数据传输对象
 * <p>Title: 车险理赔批单DTO</p>
 * <p>Description: 车险理赔批单样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class EndorseDto implements Serializable
{
  /** 批改信息表信息*/
  private PrpPheadDto prpPheadDto;
  /** 批改保单信息表信息*/
  private PrpPmainDto prpPmainDto;
  /** 保险标的信息*/
  private ArrayList prpPitemKindDtoList;
  /** 批文对象*/
  private ArrayList prpPtextDtoList;
  /** 机动车险标的信息*/
  private ArrayList prpPitem_carDtoList;
  /** 批改保额保费变化表*/
  private ArrayList prpPfeeDtoList;
  /** 优惠信息表*/
  private ArrayList prpPprofitDtoList;
  /** 特别约定表*/
  private ArrayList prpPengageDtoList;

  /** 批改信息表信息 列表*/
  private ArrayList prpPheadDtoList;
  /** 批改保单信息表信息 列表 */
  private ArrayList prpPmainDtoList;
  /** 批改共保信息表信息 列表 */
  private ArrayList prpPCoinsDtoList;
  /** 批改共保明细信息表信息 列表 */
  private ArrayList prpPCoinsDetailDtoList;


  public ArrayList getPrpPitemKindDtoList() {
    return prpPitemKindDtoList;
  }

  public PrpPmainDto getPrpPmainDto() {
    return prpPmainDto;
  }

  public ArrayList getPrpPtextDtoList() {
    return prpPtextDtoList;
  }

  public void setPrpPheadDto(PrpPheadDto prpPheadDto) {
    this.prpPheadDto = prpPheadDto;
  }

  public void setPrpPitemKindDtoList(ArrayList prpPitemKindDtoList) {
    this.prpPitemKindDtoList = prpPitemKindDtoList;
  }

  public void setPrpPmainDto(PrpPmainDto prpPmainDto) {
    this.prpPmainDto = prpPmainDto;
  }

  public void setPrpPtextDtoList(ArrayList prpPtextDtoList) {
    this.prpPtextDtoList = prpPtextDtoList;
  }

  public void setPrpPmainDtoList(ArrayList prpPmainDtoList) {
    this.prpPmainDtoList = prpPmainDtoList;
  }

  public void setPrpPheadDtoList(ArrayList prpPheadDtoList) {
    this.prpPheadDtoList = prpPheadDtoList;
  }

  public void setPrpPprofitDtoList(ArrayList prpPprofitDtoList) {
    this.prpPprofitDtoList = prpPprofitDtoList;
  }

  public void setPrpPitem_carDtoList(ArrayList prpPitem_carDtoList) {
    this.prpPitem_carDtoList = prpPitem_carDtoList;
  }

  public void setPrpPengageDtoList(ArrayList prpPengageDtoList) {
    this.prpPengageDtoList = prpPengageDtoList;
  }

  public void setPrpPfeeDtoList(ArrayList prpPfeeDtoList) {
    this.prpPfeeDtoList = prpPfeeDtoList;
  }

  public PrpPheadDto getPrpPheadDto() {
    return prpPheadDto;
  }

  public ArrayList getPrpPmainDtoList() {
    return prpPmainDtoList;
  }

  public ArrayList getPrpPheadDtoList() {
    return prpPheadDtoList;
  }

  public ArrayList getPrpPprofitDtoList() {
    return prpPprofitDtoList;
  }

  public ArrayList getPrpPitem_carDtoList() {
    return prpPitem_carDtoList;
  }

  public ArrayList getPrpPengageDtoList() {
    return prpPengageDtoList;
  }

  public ArrayList getPrpPfeeDtoList() {
    return prpPfeeDtoList;
  }

  public ArrayList getPrpPCoinsDtoList() {
	return prpPCoinsDtoList;
}

public void setPrpPCoinsDtoList(ArrayList prpPCoinsDtoList) {
	this.prpPCoinsDtoList = prpPCoinsDtoList;
}

public ArrayList getPrpPCoinsDetailDtoList() {
	return prpPCoinsDetailDtoList;
}

public void setPrpPCoinsDetailDtoList(ArrayList prpPCoinsDetailDtoList) {
	this.prpPCoinsDetailDtoList = prpPCoinsDetailDtoList;
}

public EndorseDto()
  {
  }

}
