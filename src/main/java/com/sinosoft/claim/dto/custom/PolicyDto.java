package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpCmainLoanDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.prpall.dto.domain.PrpCmainOriginDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 自定义保单数据传输对象
 * <p>Title: 车险理赔保单DTO</p>
 * <p>Description: 车险理赔保单样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class PolicyDto implements Serializable
{
  /** 保单主信息*/
  private PrpCmainDto prpCmainDto;
  /**原始保单信息**/
  private PrpCmainOriginDto prpCmainOriginDto;
  /** 保费信息*/
  private PrpCfeeDto  prpCfeeDto ;
  /** 保费信息*/
  private ArrayList  prpCfeeDtoList ;
  /** 保险标的信息*/
  private ArrayList prpCitemKindDtoList;
  /** 保险地址信息*/
  private ArrayList prpCaddressDtoList;
  /** 保单客户信息*/
  private ArrayList prpCinsuredDtoList;
  /** 车辆信息*/
  private ArrayList prpCitemCarDtoList;
  /** 优惠信息表*/
  private ArrayList prpCprofitDtoList;
  /** 优惠折扣明细表信息*/
  private ArrayList prpCprofitDetailDtoList;
  /** 交费计划信息*/
  private ArrayList prpCplanDtoList;
  /** 特别约定信息*/
  private ArrayList  prpCengageDtoList ;
  /** 驾驶员信息*/
  private ArrayList prpCcarDriverDtoList;
  /** 操作状态信息*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  //modify by wangwei add start 20050601
  /**货运险保单信息*/
  private PrpCmainCargoDto prpCmainCargoDto;
  //modify by wangwei add end 20050601
  //modify by qinyongli add start 20050718
  
//add by liuyanmei 20060224 start
  /**责任险限额信息*/
  private ArrayList prpClimitDtoList;
//add by liuyanmei 20060224 end
  
  /**增加责任险追溯期*/
  private DateTime liabStartDate;
  //modify by wangwei add end 20050718
  
  //add by miaowenjun 20060430
  /**个贷险房屋信息*/
  private ArrayList prpCitemHouseDtoList;
  private PrpCmainLoanDto prpCmainLoanDto;
  //add end by miaowenjun 20060430
  
  //add by lym 20060204  for 强三 ---- start
  /** 保单关联信息*/
  private ArrayList prpCmainSubDtoList;
  /** 保单主信息*/
  private ArrayList prpLRegistRPolicyDtoList;
  
  //add by lym 20060204  for 强三 ---- end

  private ArrayList prpCcoinsDtoList ;
  private ArrayList prpCcoinsDetailDtoList ;
  public PolicyDto()
  {
  }

//add by liuyanmei 20060224 start
  /**责任险限额信息*/
  public ArrayList getPrpClimitDtoList()
  {
    return prpClimitDtoList;
  }

  public void setPrpClimitDtoList(ArrayList prpClimitDtoList)
  {
     this.prpClimitDtoList=prpClimitDtoList;
  }
  //modify by wangwei add end 20050718
  
  
  
  //add by lym 20060204  for 强三 ---- start 
  /**得到保单关联表信息
   * @return 保单关联表信息
   */
  public ArrayList getPrpCmainSubDtoList()
  {
    return prpCmainSubDtoList;
  }

  /**设置保单关联表信息
   * @param prpCmainDto 保单关联表信息
   */
  public void setPrpCmainSubDtoList(ArrayList prpCmainSubDtoList)
  {
     this.prpCmainSubDtoList = prpCmainSubDtoList;
  }
  
  /**得到保单关联表信息
   * @return 保单关联表信息
   */
  public ArrayList getPrpLRegistRPolicyDtoList()
  {
    return prpLRegistRPolicyDtoList;
  }

  /**设置保单关联表信息
   * @param prpCmainDto 保单关联表信息
   */
  public void setPrpLRegistRPolicyDtoList(ArrayList prpLRegistRPolicyDtoList)
  {
     this.prpLRegistRPolicyDtoList= prpLRegistRPolicyDtoList;
  }
  
  //add by lym 20060204  for 强三 ---- end 
  
   
  
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

  /**得到保费信息
   * @return  保费信息
   */
  public PrpCfeeDto getPrpCfeeDto()
  {
    return prpCfeeDto;
  }
  /**设置费表信息
   * @param PrpCfeeDto 保费表信息
   */
  public void setPrpCfeeDto(PrpCfeeDto prpCfeeDto)
  {
    this.prpCfeeDto = prpCfeeDto;
  }

  /**得到itemkind信息
   * @return  itemkind信息
   */
  public ArrayList getPrpCitemKindDtoList()
  {
    return prpCitemKindDtoList;
  }
  /**设置itemkind信息
   * @param prpCitemKindDtoList itemkind表信息
   */
  public void setPrpCitemKindDtoList(ArrayList prpCitemKindDtoList)
  {
    this.prpCitemKindDtoList = prpCitemKindDtoList;
  }

  /**得到address信息
   * @return  address 信息
   */
  public ArrayList getPrpCaddressDtoList()
  {
    return prpCaddressDtoList;
  }
  /**设置address信息
   * @param prpCaddressDtoList address表信息
   */
  public void setPrpCaddressDtoList(ArrayList prpCaddressDtoList)
  {
    this.prpCaddressDtoList = prpCaddressDtoList;
  }

  /**得到insured信息
   * @return  insured 信息
   */
  public ArrayList getPrpCinsuredDtoList()
  {
    return prpCinsuredDtoList;
  }
  /**设置insured信息
   * @param prpCinsuredDtoList insured表信息
   */
  public void setPrpCinsuredDtoList(ArrayList prpCinsuredDtoList)
  {
    this.prpCinsuredDtoList = prpCinsuredDtoList;
  }

  /**得到PrpCitem_car信息
   * @return  itemcar 信息 PrpCitemCarDto
   */
  public ArrayList getPrpCitemCarDtoList()
  {
    return prpCitemCarDtoList;
  }
  /**设置itemcar信息
   * @param PrpCitemCarDtoList itemcar表信息
   */
  public void setPrpCitemCarDtoList(ArrayList prpCitemCarDtoList)
  {
    this.prpCitemCarDtoList = prpCitemCarDtoList;
  }


  /**得到carDriver信息
   * @return  carDriver 信息
   */
  public ArrayList getPrpCcarDriverDtoList()
  {
    return prpCcarDriverDtoList;
  }

  /**得到立案操作状态信息
    * @return 立案操作状态信息
    */

  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpCprofitDetailDtoList() {
    return prpCprofitDetailDtoList;
  }

  public ArrayList getPrpCplanDtoList() {
    return prpCplanDtoList;
  }

  /**设置insured信息
   * @param prpCinsuredDtoList insured表信息
   */
  public void setPrpCcarDriverDtoList(ArrayList prpCcarDriverDtoList)
  {
    this.prpCcarDriverDtoList = prpCcarDriverDtoList;
  }
  /**设置立案操作状态信息
   * @param prpLclaimStuatsDto 立案操作状态信息
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  public void setPrpCprofitDetailDtoList(ArrayList prpCprofitDetailDtoList) {
    this.prpCprofitDetailDtoList = prpCprofitDetailDtoList;
  }

  public void setPrpCplanDtoList(ArrayList prpCplanDtoList) {
    this.prpCplanDtoList = prpCplanDtoList;
  }

  /**得到特别约定信息
   * @return 特别约定信息
   */
  public ArrayList getPrpCengageDtoList() {
    return prpCengageDtoList;
  }

  public ArrayList getPrpCprofitDtoList() {
    return prpCprofitDtoList;
  }

  public ArrayList getPrpCfeeDtoList() {
    return prpCfeeDtoList;
  }

  /**设置特别约定信息
   * @param prpCengageDtoList 特别约定信息
   */
  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
    this.prpCengageDtoList = prpCengageDtoList;
  }

  public void setPrpCprofitDtoList(ArrayList prpCprofitDtoList) {
    this.prpCprofitDtoList = prpCprofitDtoList;
  }

  public void setPrpCfeeDtoList(ArrayList prpCfeeDtoList) {
    this.prpCfeeDtoList = prpCfeeDtoList;
  }
  
  //modify by wangwei add start 20050601
  /**设置货运险保单信息
   * @return 货运险保单信息 
   * */
  public PrpCmainCargoDto getPrpCmainCargoDto() {
      return this.prpCmainCargoDto;
  }
  
  /**得到货运险保单信息
   * @param prpCmain_cargoDto 货运险保单信息
   * */
  public void setPrpCmainCargoDto(PrpCmainCargoDto prpCmainCargoDto) {
  	  this.prpCmainCargoDto = prpCmainCargoDto;
  }
  //modify by wangwei add end 20050601

	//modify by qinyongli add start 20050718
	/**设置责任险追溯期
	 * @return 责任险追溯期 
	 * */
	public DateTime getLiabStartDate() {
	    return this.liabStartDate;
	}
	
	/**得到责任险追溯期
	 * @param  责任险追溯期
	 * */
	public void setLiabStartDate(DateTime liabStartDate) {
		  this.liabStartDate = liabStartDate;
	}
	//modify by wangwei add end 20050718

	public ArrayList getPrpCitemHouseDtoList() {
		return prpCitemHouseDtoList;
	}

	public void setPrpCitemHouseDtoList(ArrayList prpCitemHouseDtoList) {
		this.prpCitemHouseDtoList = prpCitemHouseDtoList;
	}

	public PrpCmainLoanDto getPrpCmainLoanDto() {
		return prpCmainLoanDto;
	}

	public void setPrpCmainLoanDtoList(PrpCmainLoanDto prpCmainLoanDto) {
		this.prpCmainLoanDto = prpCmainLoanDto;
	}

	public PrpCmainOriginDto getPrpCmainOriginDto() {
		return prpCmainOriginDto;
	}

	public void setPrpCmainOriginDto(PrpCmainOriginDto prpCmainOriginDto) {
		this.prpCmainOriginDto = prpCmainOriginDto;
	}

	public ArrayList getPrpCcoinsDtoList() {
		return prpCcoinsDtoList;
	}

	public void setPrpCcoinsDtoList(ArrayList prpCcoinsDtoList) {
		this.prpCcoinsDtoList = prpCcoinsDtoList;
	}

	public ArrayList getPrpCcoinsDetailDtoList() {
		return prpCcoinsDetailDtoList;
	}

	public void setPrpCcoinsDetailDtoList(ArrayList prpCcoinsDetailDtoList) {
		this.prpCcoinsDetailDtoList = prpCcoinsDetailDtoList;
	}
	
	}


