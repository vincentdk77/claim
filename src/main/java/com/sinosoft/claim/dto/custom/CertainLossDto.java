package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;

/**
 * 自定义定损数据传输对象
 * <p>Title: 车险理赔定损DTO</p>
 * <p>Description: 车险理赔定损样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class CertainLossDto implements Serializable
{
  
  /** 三者车辆信息*/
  private PrpLthirdPartyDto  prpLthirdPartyDto ;	//add by liuyanmei 20051215 
  /** 三者车辆信息*/
  private ArrayList  prpLthirdPartyDtoList ;	//add by liuyanmei 20051215 
  /** 定损主表*/
  private PrpLverifyLossDto prpLverifyLossDto;
  /** 定损主表*/
  private ArrayList prpLverifyLossDtoList;
  /** 定损车辆表*/
  private ArrayList prpLcarLossDtoList;
  /** 修理费用清单 */
  private ArrayList prpLrepairFeeDtoList;
  /** 换件项目清单 */
  private ArrayList prpLcomponentDtoList;
  /** 人员伤亡明细信息表 */
  private ArrayList prpLpersonDtoList;
  /** 财产核定损明细清单表 */
  private ArrayList prpLpropDtoList;
  /** 定核损处理标的表 */
  private ArrayList prpLverifyLossItemDtoList;
  /** 伤情信息表 */
  private ArrayList prpLpersonWoundDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList; 
  /** 定核损信息补充说明*/
  private ArrayList prpLverifyLossExtDtoList; 
  /** 处理意见表*/
  private ArrayList swfNotionList; 
  /** 并案状态信息处理*/
  private ArrayList prpLclaimStatusDtoList;
  /** 耳标号损失清单*/
  private ArrayList prplCompensateEarDtoList;

  private ArrayList prplCompensateHouseDtoList;
  
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**
   * @return Returns the prplCompensateEarDtoList.
   */
  public ArrayList getPrplCompensateEarDtoList() {
  	return prplCompensateEarDtoList;
  }
  /**设置耳标号损失清单
   * @param prplCompensateEarDtoList 耳标号损失清单
   */
  public void setPrplCompensateEarDtoList(ArrayList prplCompensateEarDtoList) {
    this.prplCompensateEarDtoList = prplCompensateEarDtoList;
  }
  
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
  
  /**得到人员伤亡明细信息
   * @return 人员伤亡明细信息
   */
 
  
  public ArrayList getPrpLpersonDtoList() {
    return prpLpersonDtoList;
  }

  /**得到修理费用清单信息
   * @return 修理费用清单信息
   */
  public ArrayList getPrpLrepairFeeDtoList() {
    return prpLrepairFeeDtoList;
  }

  /**得到定损主表信息
   * @return 定损主表信息
   */
  public PrpLverifyLossDto getPrpLverifyLossDto() {
    return prpLverifyLossDto;
  }

  /**得到换件项目清单
   * @return 换件项目清单
   */
  public ArrayList getPrpLcomponentDtoList() {
    return prpLcomponentDtoList;
  }

  /**得到财产核定损明细清单表
   * @return 财产核定损明细清单表
   */
  public ArrayList getPrpLpropDtoList() {
    return prpLpropDtoList;
  }

  /**得到定损车辆表
   * @return 定损车辆表
   */
  public ArrayList getPrpLcarLossDtoList() {
    return prpLcarLossDtoList;
  }

  /**设置操作状态信息
   * @param prpLclaimStatusDto 操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**设置人员伤亡明细信息
   * @param prpLpersonDtoList 人员伤亡明细信息
   */
  public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList) {
    this.prpLpersonDtoList = prpLpersonDtoList;
  }

  /**设置修理费用清单信息
   * @param prpLrepairFeeDtoList 修理费用清单信息
   */
  public void setPrpLrepairFeeDtoList(ArrayList prpLrepairFeeDtoList) {
    this.prpLrepairFeeDtoList = prpLrepairFeeDtoList;
  }

  /**设置定损主表信息
   * @param prpLverifyLossDto 定损主表信息
   */
  public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
    this.prpLverifyLossDto = prpLverifyLossDto;
  }

  /**设置换件项目清单
   * @param prpLcomponentDtoList 换件项目清单
   */
  public void setPrpLcomponentDtoList(ArrayList prpLcomponentDtoList) {
    this.prpLcomponentDtoList = prpLcomponentDtoList;
  }

  /**设置财产核定损明细清单表
   * @param prpLpropDtoList 财产核定损明细清单表
   */
  public void setPrpLpropDtoList(ArrayList prpLpropDtoList) {
    this.prpLpropDtoList = prpLpropDtoList;
  }

  /**设置定损车辆表
   * @param prpLcarLossDtoList 定损车辆表
   */
  public void setPrpLcarLossDtoList(ArrayList prpLcarLossDtoList) {
    this.prpLcarLossDtoList = prpLcarLossDtoList;
  }

  public void setPrpLverifyLossItemDtoList(ArrayList prpLverifyLossItemDtoList) {
    this.prpLverifyLossItemDtoList = prpLverifyLossItemDtoList;
  }

  public void setPrpLverifyLossDtoList(ArrayList prpLverifyLossDtoList) {
    this.prpLverifyLossDtoList = prpLverifyLossDtoList;
  }

  public void setPrpLpersonWoundDtoList(ArrayList prpLpersonWoundDtoList) {
    this.prpLpersonWoundDtoList = prpLpersonWoundDtoList;
  }

  /**得到操作状态信息
   * @return 操作状态信息
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpLverifyLossItemDtoList() {
    return prpLverifyLossItemDtoList;
  }

  public ArrayList getPrpLverifyLossDtoList() {
    return prpLverifyLossDtoList;
  }

  public ArrayList getPrpLpersonWoundDtoList() {
    return prpLpersonWoundDtoList;
  }

  /**
   *  默认构造方法,构造一个默认的CertainLossDto对象
   */
  public CertainLossDto(){
  }

/**
 * @return Returns the swfNotionList.
 */
public ArrayList getSwfNotionList() {
	return swfNotionList;
} 


/**
 * @param swfNotionList The swfNotionList to set.
 */
public void setSwfNotionList(ArrayList swfNotionList) {
	this.swfNotionList = swfNotionList;
}
//add by liuyanmei 20051215 start
/**得到三者车辆信息
 * @return  三者车辆信息
 */
public PrpLthirdPartyDto getPrpLthirdPartyDto()
{
  return prpLthirdPartyDto;
}
/**设置三者车辆信息
 * @param PrpLthirdPartyDtoList 三者车辆表信息
 */
public void setPrpLthirdPartyDto(PrpLthirdPartyDto prpLthirdPartyDto)
{
  this.prpLthirdPartyDto = prpLthirdPartyDto;
}
public ArrayList getPrpLthirdPartyDtoList() {
    return prpLthirdPartyDtoList;
}
public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
	this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
}
public ArrayList getPrpLclaimStatusDtoList() {
	return prpLclaimStatusDtoList;
}
public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
	this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
}



//add by liuyanmei end 
}
