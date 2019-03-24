package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;

/**
 * 自定义报案数据传输对象
 * <p>Title: 车险理赔报案DTO</p>
 * <p>Description: 车险理赔报案样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class RegistDto implements Serializable
{
  /** 报案主信息*/
  private PrpLregistDto prpLregistDto;
  private PrplregisthisDto prplregisthisDto;
  /** 三者车辆信息*/
  private ArrayList  prpLthirdPartyDtoList ;
  /** 驾驶员信息*/
  private ArrayList prpLdriverDtoList;
  /** 损失部位信息*/
  private ArrayList prpLthirdCarLossDtoList;
  /** 人员伤亡跟踪信息*/
  private ArrayList prpLpersonTraceDtoList;
  /** 报案信息补充说明*/
  private ArrayList prpLregistExtDtoList;
  /** 文本信息*/
  private ArrayList prpLregistTextDtoList;
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**新报案提示表的数据增加*/
  private PrpLscheduleNewDto prpLscheduleNewDto;
  /** 特别约定信息*/
  private ArrayList  prpCengageDtoList ;
  /** 调度主表信息*/
  private PrpLscheduleMainWFDto prpLscheduleMainWFDto;
  /** 调度表的信息*/
  private ArrayList  prpLscheduleItemDtoList ;

  /** 保险标的信息*/
  private ArrayList prpCitemKindDtoList;

  /** 损失部位信息*/
  private ArrayList prpLthirdPropDtoList;
  
  /****/
  //更改耳标号清单列表 为 prpLcompensateEarDtoList  20110810 by GYIC 李杨 End!
  private ArrayList prpLcompensateEarDtoList;
  
  private ArrayList prpLearDtoList;
  //更改耳标号清单列表 为 prpLcompensateEarDtoList  20110810 by GYIC 李杨 End!
  //modify by wangwei add strat 2005-06-18
  //原因：添加调查信息
  private AcciCheckDto acciCheckDto;
  
  //modify by wangwei add start 20050601
  //原因：增加联系人信息
  private ArrayList prpLrelatePersonDtoList;
  //modify by wangwei add end 20050601
  
  //modify by wangwei add start 2005-06-14
  //原因：增加出口货运人的检验人名称
  private String identifierName = "";
  
  //modify by wangwei add start 2005-06-16
  //原因：添加呈报信息
  /** 文本信息*/
  private ArrayList prpLregistTextDtoList2;
  
  /**出险人员信息表*/
  private PrpLacciPersonDto prpLacciPersonDto;
  
  /** 理赔扩展信息表 */
  private PrpLextDto prpLextDto;
  /** 关联表 2006-06-09 by lym for 强三  */
  private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
  /** 事故者信息模块 */
  private ArrayList prplacciBenPersonDtoList;
  /**出险原因详细信息*/
  private ArrayList prpLregistTextDtoList3;
  
  private ArrayList prplCompensateHouseDtoList;
  

	/**
	 * 得到事故者信息
	 * 
	 * @return 事故者 信息
	 */
	public ArrayList getPrplacciBenPersonDtoList() {
		return prplacciBenPersonDtoList;
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
	 * 设置事故者信息
	 * 
	 * @param prplacciBenPersonDtoList
	 *            事故者信息
	 */
	public void setPrplacciBenPersonDtoList(ArrayList prplacciBenPersonDtoList) {
		this.prplacciBenPersonDtoList = prplacciBenPersonDtoList;
	}
	
 //add by lym 20060605  for 强三 ---start ----
  
  /** 强三关联信息*/
  private List prpLRegistRPolicyList = new ArrayList();
 
  public void setPrpLRegistRPolicyList(List prpLRegistRPolicyList) {
  	  this.prpLRegistRPolicyList = prpLRegistRPolicyList;
  }
  
  public List getPrpLRegistRPolicyList() {
  	  return this.prpLRegistRPolicyList;
  }
  
  
  
  /** 
   * 获得关联的强制保单关联信息
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyDtoOfCompel() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if ("0".equals(prpLRegistRPolicyDto.getRegistFlag())) {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }  
  /** 
   * 获得关联的强制保单关联信息
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyBZ() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if(("0507".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0577".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0587".equals(prpLRegistRPolicyDto.getRiskCode()))&&"1".equals(prpLRegistRPolicyDto.getValidStatus()))
		  {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }
  /** 
   * 获得关联的商业险保单关联信息
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyBusiness() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if(("0506".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0576".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0586".equals(prpLRegistRPolicyDto.getRiskCode()))&&"1".equals(prpLRegistRPolicyDto.getValidStatus()))
		  {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }
  
  /**
   * 获得报案的关联保单类型
   * @return
   * RegistDto.BUSINESS_COMPEL_POLICY:商业保单强制保单关联报案
   * RegistDto.SING_BUSINESS_POLICY  :仅商业保单报案
   * RegistDto.SING_COMPEL_POLICY    :仅强制保单报案
   * RegistDto.NONE_RELATION_DATA    :关联表中无关联保单数据
   */
  public String getRegistType(){
	  boolean isHaveCompelPolicy = false;
	  boolean isHaveBusinessPolicy = false;
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if (PrpLRegistRPolicyDto.COMPEL_POLICY.equals(prpLRegistRPolicyDto.getPolicyType())) {
			  isHaveCompelPolicy = true;
		  }
		  if (PrpLRegistRPolicyDto.BUSINESS_POLICY.equals(prpLRegistRPolicyDto.getPolicyType())) {
			  isHaveBusinessPolicy = true;
		  }
	  }
	  if(isHaveBusinessPolicy&&isHaveCompelPolicy){
		  return BUSINESS_COMPEL_POLICY;
	  }
	  if(isHaveBusinessPolicy&&!isHaveCompelPolicy){
		  return SING_BUSINESS_POLICY;
	  }
	  if(!isHaveBusinessPolicy&&isHaveCompelPolicy){
		  return SING_COMPEL_POLICY;
	  }
	  if(!isHaveBusinessPolicy&&!isHaveCompelPolicy){
		  return NONE_RELATION_DATA;
	  }
	  return null;
  }
  
  
  //add by lym 20060605  for 强三 ---end ----
 
  /**设置出险人员信息表
   * @param prpLacciPersonDto 出险人员信息表
   */
  public void setPrpLacciPersonDto(PrpLacciPersonDto prpLacciPersonDto) {
  	  this.prpLacciPersonDto = prpLacciPersonDto;
  }
  
  /**得到出险人员信息表
   * @return  出险人员信息表
   */
  public PrpLacciPersonDto getPrpLacciPersonDto() {
  	  return this.prpLacciPersonDto;
  }
  /**得到呈报文本信息
   * @return  报案文本信息
   */
  public ArrayList getPrpLregistTextDtoList2()
  {
    return prpLregistTextDtoList2;
  }
  /**设置呈报文本信息
   * @param prpLregistTextDtoList 报案文本信息
   */
  public void setPrpLregistTextDtoList2(ArrayList prpLregistTextDtoList2)
  {
    this.prpLregistTextDtoList2 = prpLregistTextDtoList2;
  }
  //modify by wangwei add end 2005-06-16
  
  /**
   * 获得货运信息
   * @return 获得货信息*/
  public String getIdentifierName() {
  	  return this.identifierName;
  }
  
  /**
   * 设置货运信息
   * @param 货运信息*/
  public void setIdentifierName(String identifierName) {
  	  this.identifierName = identifierName;
  }
  //modify by wangwei add end 2005-06-14

  public RegistDto()
  {
  }

  /**得到报案主表信息
   * @return 报案主表信息
   */
  public PrpLregistDto getPrpLregistDto()
  {
    return prpLregistDto;
  }

  /**设置报案主表信息
   * @param prpLregistDto 报案主表信息
   */
  public void setPrpLregistDto(PrpLregistDto prpLregistDto)
  {
     this.prpLregistDto = prpLregistDto;
  }

  /**得到报案文本信息
   * @return  报案文本信息
   */
  public ArrayList getPrpLregistTextDtoList()
  {
    return prpLregistTextDtoList;
  }
  /**设置报案文本信息
   * @param prpLregistTextDtoList 报案文本信息
   */
  public void setPrpLregistTextDtoList(ArrayList prpLregistTextDtoList)
  {
    this.prpLregistTextDtoList = prpLregistTextDtoList;
  }

  /**得到三者车辆信息
   * @return  三者车辆信息
   */
  public ArrayList getPrpLthirdPartyDtoList()
  {
    return prpLthirdPartyDtoList;
  }
  /**设置三者车辆信息
   * @param PrpLthirdPartyDtoList 三者车辆表信息
   */
  public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList)
  {
    this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
  }

  /**得到驾驭员信息
   * @return  驾驭员 信息
   */
  public ArrayList getPrpLdriverDtoList()
  {
    return prpLdriverDtoList;
  }
  /**设置驾驭员信息
   * @param PrpLdriverDtoList 驾驭员表信息
   */
  public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList)
  {
    this.prpLdriverDtoList = prpLdriverDtoList;
  }
  /**得到立案操作状态信息
    * @return 立案操作状态信息
    */
   public PrpLclaimStatusDto getPrpLclaimStatusDto()
   {
     return prpLclaimStatusDto;
   }

   /**设置立案操作状态信息
    * @param prpLclaimStuatsDto 立案操作状态信息
    */
   public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
   {
      this.prpLclaimStatusDto = prpLclaimStatusDto;
   }

    /**得到新报案提示表信息
    * @return 新报案提示表信息
    */
   public PrpLscheduleNewDto getPrpLscheduleNewDto()
   {
     return prpLscheduleNewDto;
   }

  public ArrayList getPrpLthirdCarLossDtoList() {
    return prpLthirdCarLossDtoList;
  }

  /**设置新报案提示表信息
    * @param prpLscheduleNewDto 新报案提示表信息
    */
   public void setPrpLscheduleNewDto(PrpLscheduleNewDto prpLscheduleNewDto)
   {
      this.prpLscheduleNewDto = prpLscheduleNewDto;
   }

  public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
    this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
  }

    /**得到人伤跟踪信息
   * @return  人伤跟踪 信息
   */
  public ArrayList getPrpLpersonTraceDtoList()
  {
    return prpLpersonTraceDtoList;
  }

  public ArrayList getPrpLregistExtDtoList() {
    return prpLregistExtDtoList;
  }

  /**设置人伤跟踪信息
   * @param PrpLpersonTraceDtoList 人伤跟踪表信息
   */
  public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList)
  {
    this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
  }

  public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
    this.prpLregistExtDtoList = prpLregistExtDtoList;
  }

 //modify by lixiang add 20050315 start
//reason:加入保险标的信息的内容，界面上可以直接显示承保险别

   /**得到itemkind信息
   * @return  itemkind信息
   */
  public ArrayList getPrpCitemKindDtoList()
  {
    return prpCitemKindDtoList;
  }

  public ArrayList getPrpCengageDtoList() {
    return prpCengageDtoList;
  }

  /**设置itemkind信息
   * @param prpCitemKindDtoList itemkind表信息
   */
  public void setPrpCitemKindDtoList(ArrayList prpCitemKindDtoList)
  {
    this.prpCitemKindDtoList = prpCitemKindDtoList;
  }

  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
    this.prpCengageDtoList = prpCengageDtoList;
  }

 /**得到调度主表信息
   * @return 调度主表信息
   */
  public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto()
  {
    return prpLscheduleMainWFDto;
  }

  /**设置调度主表信息
   * @param prpLscheduleMainWFDto 调度主表信息
   */
  public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto)
  {
     this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
  }

 /**得到调度标的信息
   * @return  调度标的信息
   */
  public ArrayList getPrpLscheduleItemDtoList()
  {
    return prpLscheduleItemDtoList;
  }
  /**设置调度标的信息
   * @param PrpLscheduleItemDto调度标的信息
   */
  public void setPrpLscheduleItemDtoList(ArrayList prpLscheduleItemDtoList)
  {
    this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
  }

  /**设置其它损失信息
   * @param prpLthirdPropDtoList 其它损失信息
   */

  public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
    this.prpLthirdPropDtoList = prpLthirdPropDtoList;
  }

  /**得到其它损失信息
   * @return  其它损失信息
   */

   public ArrayList getPrpLthirdPropDtoList() {
     return prpLthirdPropDtoList;
   }
   
   /**设置联系人信息
    * @param prpLrelatePersonDtoList 联系人信息
    * */
   public void setPrpLrelatePersonDtoList(ArrayList prpLrelatePersonDtoList) {
   	   this.prpLrelatePersonDtoList = prpLrelatePersonDtoList;
   }
   
   /**得到联系人信息
    * @return 得到联系人信息
    * */
   public ArrayList getPrpLrelatePersonDtoList() {
   	   return this.prpLrelatePersonDtoList;
   }
   
   /**
    * 设置调查信息
    * @param acciCheckDto 调查信息
    * */
   public void setAcciCheckDto(AcciCheckDto acciCheckDto) {
   	  this.acciCheckDto = acciCheckDto;
   }
   
   /**
    * 获得调查信息
    *@return 调查信息
    **/
   public AcciCheckDto getAcciCheckDto( ) {
   	  return this.acciCheckDto;
   }
   
   /**
    * 设置理赔扩展信息
    * @param acciCheckDto 理赔扩展信息
    * */
   public void setPrpLextDto(PrpLextDto prpLextDto){
   	  this.prpLextDto = prpLextDto;
   }
   /**
    * 得到理赔扩展信息
    * @return 得到理赔扩展信息
    * */
   public PrpLextDto getPrpLextDto(){
   	  return prpLextDto;
   }
   
	//add by lym 20060609 for 强三  ---start 
	/**
	 * 得到强三关联表信息
	 * @return 
	 */
	public PrpLRegistRPolicyDto getPrpLRegistRPolicyDto() {
		return prpLRegistRPolicyDto;
	}

	/**
	 * 设置强三关联表信息
	 * @param prpLclaimDto
	 */
	public void setPrpLRegistRPolicyDto(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
		this.prpLRegistRPolicyDto = prpLRegistRPolicyDto;
	}
//	add by lym 20060609 for 强三  ---end
   
   /**
    * 仅商业保单报案
    */
   public static final String SING_BUSINESS_POLICY = "10";
   /**
    * 仅强制保单报案
    */
   public static final String SING_COMPEL_POLICY = "01";
   /**
    * 商业保单强制保单关联报案 
    */
   public static final String BUSINESS_COMPEL_POLICY = "11";
   /**
    * 关联表中无关联保单数据
    */
   public static final String NONE_RELATION_DATA = "00";


   public ArrayList getPrpLearDtoList() {
	   return prpLearDtoList;
   }

   public void setPrpLearDtoList(ArrayList prpLearDtoList) {
	   this.prpLearDtoList = prpLearDtoList;
   }
   
   public ArrayList getPrpLcompensateEarDtoList() {
	   return prpLcompensateEarDtoList;
   }

   public void setPrpLcompensateEarDtoList(ArrayList prpLcompensateEarDtoList) {
	   this.prpLcompensateEarDtoList = prpLcompensateEarDtoList;
   }
   
   public ArrayList getPrpLregistTextDtoList3() {
	   return prpLregistTextDtoList3;
   }

   public void setPrpLregistTextDtoList3(ArrayList prpLregistTextDtoList3) {
	   this.prpLregistTextDtoList3 = prpLregistTextDtoList3;
   }

/**
 * @return the prplregisthisDto
 */
public PrplregisthisDto getPrplregisthisDto() {
	return prplregisthisDto;
}

/**
 * @param prplregisthisDto the prplregisthisDto to set
 */
public void setPrplregisthisDto(PrplregisthisDto prplregisthisDto) {
	this.prplregisthisDto = prplregisthisDto;
}

}
