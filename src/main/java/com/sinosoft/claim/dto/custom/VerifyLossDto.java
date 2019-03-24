package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;

/**
 * 自定义核损数据传输对象
 * <p>Title: 车险理赔核损DTO</p>
 * <p>Description: 车险理赔核损样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class VerifyLossDto implements Serializable
{
  /** 核损主表信息*/
  private PrpLverifyLossDto prpLverifyLossDto;
  /** 核损车辆表信息*/
  private ArrayList prpLcarLossDtoList;
  /** 修理费用清单信息 */
  private ArrayList prpLrepairFeeDtoList;
  /** 换件项目清单信息 */
  private ArrayList prpLcomponentDtoList;
  /** 人员伤亡明细信息表信息 */
  private ArrayList prpLpersonDtoList;
  /** 财产核核损明细清单表信息 */
  private ArrayList prpLpropDtoList;
  /** 定核损处理标的表 */
  private ArrayList prpLverifyLossItemDtoList;
  /** 伤情信息表 */
  private ArrayList prpLpersonWoundDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLverifyLossExtDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList;
  
  private ArrayList prplCompensateHouseDtoList;
  
  
  public ArrayList getPrplCompensateHouseDtoList() {
	  	return prplCompensateHouseDtoList;
	  }
	  /**设置耳标号损失清单
	   * @param prplCompensateEarDtoList 耳标号损失清单
	   */
	  public void setPrplCompensateHouseDtoList(ArrayList prplCompensateHouseDtoList) {
	    this.prplCompensateHouseDtoList = prplCompensateHouseDtoList;
	  }
  
  /**
   * @return Returns the prpLverifyLossExtDtoList.
   */
  public ArrayList getPrpLverifyLossExtDtoList() {
  	return prpLverifyLossExtDtoList;
  }
  /** 
   * @param prpLverifyLossExtDtoList The prpLverifyLossExtDtoList to set.
   */
  public void setPrpLverifyLossExtDtoList(ArrayList prpLverifyLossExtDtoList) {
  	this.prpLverifyLossExtDtoList = prpLverifyLossExtDtoList;
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
  /** 操作状态信息信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  /**
   * 获取属性人员伤亡明细信息表信息
   * @return 属性人员伤亡明细信息表信息
   */
  public ArrayList getPrpLpersonDtoList() {
    return prpLpersonDtoList;
  }

  /**
   * 获取属性修理费用清单信息
   * @return 属性修理费用清单信息
   */
  public ArrayList getPrpLrepairFeeDtoList() {
    return prpLrepairFeeDtoList;
  }

  /**
   * 获取核损主表
   * @return 核损主表
   */
  public PrpLverifyLossDto getPrpLverifyLossDto() {
    return prpLverifyLossDto;
  }

  /**
   * 获取属性换件项目清单信息
   * @return 属性换件项目清单信息
   */
  public ArrayList getPrpLcomponentDtoList() {
    return prpLcomponentDtoList;
  }

  /**
   * 获取属性财产核核损明细清单表信息
   * @return 属性财产核核损明细清单表信息
   */
  public ArrayList getPrpLpropDtoList() {
    return prpLpropDtoList;
  }

  /**
   * 获取核损车辆表信息
   * @return 核损车辆表信息
   */
  public ArrayList getPrpLcarLossDtoList() {
    return prpLcarLossDtoList;
  }

  /**
   * 设置属性操作状态信息信息
   * @param prpLclaimStatusDto 待设置的属性操作状态信息信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**
   * 设置属性人员伤亡明细信息表信息
   * @param prpLpersonDtoList 待设置的属性人员伤亡明细信息表信息
   */
  public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList) {
    this.prpLpersonDtoList = prpLpersonDtoList;
  }

  /**
   * 设置属性修理费用清单信息
   * @param prpLrepairFeeDtoList 待设置的属性修理费用清单信息
   */
  public void setPrpLrepairFeeDtoList(ArrayList prpLrepairFeeDtoList) {
    this.prpLrepairFeeDtoList = prpLrepairFeeDtoList;
  }

  /**
   * 设置属性核损主表
   * @param prpLverifyLossDto 核损主表
   */
  public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
    this.prpLverifyLossDto = prpLverifyLossDto;
  }

  /**
   * 设置属性换件项目清单信息
   * @param prpLcertifyImgDtoList 待设置的属性换件项目清单信息
   */
  public void setPrpLcomponentDtoList(ArrayList prpLcomponentDtoList) {
    this.prpLcomponentDtoList = prpLcomponentDtoList;
  }

  /**
   * 设置属性财产核核损明细清单表信息
   * @param prpLpropDtoList 待设置的属性财产核核损明细清单表信息
   */
  public void setPrpLpropDtoList(ArrayList prpLpropDtoList) {
    this.prpLpropDtoList = prpLpropDtoList;
  }

  /**
   * 设置属性核损车辆表信息
   * @param prpLcarLossDtoList 核损车辆表信息
   */
  public void setPrpLcarLossDtoList(ArrayList prpLcarLossDtoList) {
    this.prpLcarLossDtoList = prpLcarLossDtoList;
  }

  public void setPrpLverifyLossItemDtoList(ArrayList prpLverifyLossItemDtoList) {
    this.prpLverifyLossItemDtoList = prpLverifyLossItemDtoList;
  }

  public void setPrpLpersonWoundDtoList(ArrayList prpLpersonWoundDtoList) {
    this.prpLpersonWoundDtoList = prpLpersonWoundDtoList;
  }

  /**
   * 获取属性操作状态信息信息
   * @return 属性操作状态信息信息
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpLverifyLossItemDtoList() {
    return prpLverifyLossItemDtoList;
  }

  public ArrayList getPrpLpersonWoundDtoList() {
    return prpLpersonWoundDtoList;
  }

  /**
   *  默认构造方法,构造一个默认的VerifyLossDto对象
   */
  public VerifyLossDto(){
  }

}
