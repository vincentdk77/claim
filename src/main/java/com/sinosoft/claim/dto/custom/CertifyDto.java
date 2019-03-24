package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;

/**
 * 自定义单证数据传输对象
 * <p>Title: 车险理赔单证DTO</p>
 * <p>Description: 车险理赔单证样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
public class CertifyDto implements Serializable
{
  /** 单证收集主信息*/
  private ArrayList prpLcertifyCollectDtoList;
  /** 单证收集主信息*/
  private PrpLcertifyCollectDto prpLcertifyCollectDto;
  /** 单证及影像信息 */
  private ArrayList prpLcertifyImgDtoList;
  /** 索赔指引信息 */
  private ArrayList prpLcertifyDirectDtoList;
  /** 质量评审内容*/
  private ArrayList prpLqualityCheckList; 
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /** 操作状态信息(并案)*/
  private ArrayList prpLclaimStatusDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList;
  /** 节点名称*/
  private String nodeType;
  /**回访主表**/
  private PrplreturnvisitswflogDto prplreturnvisitswflogDto;

  /**
   *  默认构造方法,构造一个默认的CertifyDto对象
   */
  public CertifyDto(){
  }

  /**
   * 设置属性单证收集主信息
   * @param prpLcertifyCollectDtoList 待设置的属性单证收集主信息
   */
  public void setPrpLcertifyCollectDtoList(ArrayList prpLcertifyCollectDtoList){
      this.prpLcertifyCollectDtoList = prpLcertifyCollectDtoList;
  }

  /**
   * 获取属性单证收集主信息
   * @return 属性单证收集主信息的值
   */
  public ArrayList getPrpLcertifyCollectDtoList(){
      return prpLcertifyCollectDtoList;
  }

  /**
   * 设置属性单证及影像信息
   * @param prpLcertifyImgDtoList 待设置的属性单证及影像信息的值
   */
  public void setPrpLcertifyImgDtoList(ArrayList prpLcertifyImgDtoList){
      this.prpLcertifyImgDtoList = prpLcertifyImgDtoList;
  }

  /**
   * 获取属性单证及影像信息
   * @return 属性单证及影像信息的值
   */
  public ArrayList getPrpLcertifyImgDtoList(){
      return prpLcertifyImgDtoList;
  }

  /**
   * 设置属性操作状态信息
   * @param 操作状态信息 待设置的属性操作状态信息的值
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto){
      this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  public void setPrpLcertifyCollectDto(PrpLcertifyCollectDto
                                       prpLcertifyCollectDto) {
    this.prpLcertifyCollectDto = prpLcertifyCollectDto;
  }

  public void setNodeType(String nodeType) {
    this.nodeType = nodeType;
  }

  public void setPrpLcertifyDirectDtoList(ArrayList prpLcertifyDirectDtoList) {
    this.prpLcertifyDirectDtoList = prpLcertifyDirectDtoList;
  }

  /**
   * 获取属性操作状态信息
   * @return 属性操作状态信息的值
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto(){
      return prpLclaimStatusDto;
  }

  public PrpLcertifyCollectDto getPrpLcertifyCollectDto() {
    return prpLcertifyCollectDto;
  }

  public String getNodeType() {
    return nodeType;
  }

  public ArrayList getPrpLcertifyDirectDtoList() {
    return prpLcertifyDirectDtoList;
  }
/**
 * @return Returns the prpLqualityCheckList.
 */
public ArrayList getPrpLqualityCheckList() {
	return prpLqualityCheckList;
}
/**
 * @param prpLqualityCheckList The prpLqualityCheckList to set.
 */
public void setPrpLqualityCheckList(ArrayList prpLqualityCheckList) {
	this.prpLqualityCheckList = prpLqualityCheckList;
}
/**
 * @return Returns the prpLregistExtDtoList.
 */
public ArrayList getPrpLregistExtDtoList() {
	return prpLregistExtDtoList;
}
/**
 * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
 */
public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
	this.prpLregistExtDtoList = prpLregistExtDtoList;
}

public ArrayList getPrpLclaimStatusDtoList() {
	return prpLclaimStatusDtoList;
}

public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
	this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
}

public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
}

public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
}

}
