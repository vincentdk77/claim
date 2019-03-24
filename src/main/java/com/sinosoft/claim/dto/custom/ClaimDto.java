package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;

/**
 * 自定义立案数据传输对象
 * <p>
 * Title: 车险理赔立案DTO
 * </p>
 * <p>
 * Description: 车险理赔立案样本程序
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author lijiyuan
 * @version 1.0
 */

public class ClaimDto implements Serializable {
	/** 立案主信息 */
	private PrpLclaimDto prpLclaimDto;
	//add by lym 20060809 start for （特殊赔案：垫支付）
	private ArrayList prpLprepayDtoList;
	//add by lym 20060809 end for （特殊赔案：垫支付）
	/** 特别约定信息 */
	private ArrayList prpCengageDtoList;

	/** 三者车辆信息 */
	private ArrayList prpLthirdPartyDtoList;

	/** 驾驶员信息 */
	private ArrayList prpLdriverDtoList;
	
	/** 索赔人信息 */
	private ArrayList prpLacciPersonDtoList;
	
	/** 事故者信息 */
	private ArrayList prplacciBenPersonDtoList;
	
	/** 险别估损金额 */
	private ArrayList prpLclaimLossDtoList;

	/** 估损金额 */
	private ArrayList prpLclaimFeeDtoList;

	/** 单证信息 */
	private ArrayList prpLdocDtoList;

	/** 文本信息 */
	private ArrayList prpLltextDtoList;

	/** 损失部位信息 */
	private ArrayList prpLthirdCarLossDtoList;

	/** 损失部位信息 */
	private ArrayList prpLthirdPropDtoList;

	/** 操作状态信息 */
	private PrpLclaimStatusDto prpLclaimStatusDto;

	//modify by wangwei add start 2005-06-16
	//原因：添加出险人员信息
	/** 出险人员信息表 */
	private PrpLacciPersonDto prpLacciPersonDto;

	/** 报案信息补充说明 */
	private ArrayList prpLregistExtDtoList;

	/** 人员伤亡跟踪信息 2005-07-26 */
	private ArrayList prpLpersonTraceDtoList;

	/** 风险单位信息 2005-08-16 by qinyongli */
	private ArrayList prpLRiskUnitDtoList;
    
    /** 立案信息扩展表 2005-09-23 by qinyongli */
    private PrpLextDto prpLextDto;
    
    
    /** 关联表 2006-06-09 by lym for 强三  */
    private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
    
    //add by kangzhen 20070522 start 存储大病住院医疗补偿保险中的住院费用信息
    private ArrayList prpLpersonDtoList;
    
    /** 立案耳标号信息表 2011-08-15 by Pao*/
    private ArrayList prpLcompensateeartDtoList;
    
    /**详细出险原因信息*/
    private ArrayList prpLltextDtoList3;
    
    /**	理赔的危险单位信息表 2011-01-14  */
	private ArrayList PrpLdangerItemDtoList;
    
    /**	立案环节保存危险单位金额合计信息表 2011-01-14  */
	private ArrayList PrpLdangerTotDtoList;   
    
	/**预赔费用信息*/
	private ArrayList PrpLpreChargeDtoList;
	
	private ArrayList prplCompensateHouseDtoList;
   
    public ArrayList getPrpLltextDtoList3() {
		return prpLltextDtoList3;
	}

	public void setPrpLltextDtoList3(ArrayList prpLltextDtoList3) {
		this.prpLltextDtoList3 = prpLltextDtoList3;
	}

	public ArrayList getPrpLpersonDtoList(){
    	return prpLpersonDtoList;
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
    
    public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList){
    	this.prpLpersonDtoList = prpLpersonDtoList;
    }
    //add by kangzhen 20070522 end

    /** 得到人伤跟踪信息
	 * @return 人伤跟踪 信息
	 */
	public ArrayList getPrpLpersonTraceDtoList() {
		return prpLpersonTraceDtoList;
	}

	/**
	 * 设置人伤跟踪信息
	 * 
	 * @param PrpLpersonTraceDtoList
	 *            人伤跟踪表信息
	 */
	public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList) {
		this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
	}

	/**
	 * @return Returns the prpLregistExtDtoList.
	 */
	public ArrayList getPrpLregistExtDtoList() {
		return prpLregistExtDtoList;
	}

	/**
	 * @param prpLregistExtDtoList
	 *            The prpLregistExtDtoList to set.
	 */
	public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
		this.prpLregistExtDtoList = prpLregistExtDtoList;
	}

	/**
	 * 设置出险人员信息表
	 * 
	 * @param prpLacciPersonDto
	 *            出险人员信息表
	 */
	public void setPrpLacciPersonDto(PrpLacciPersonDto prpLacciPersonDto) {
		this.prpLacciPersonDto = prpLacciPersonDto;
	}

	/**
	 * 得到出险人员信息表
	 * 
	 * @return 出险人员信息表
	 */
	public PrpLacciPersonDto getPrpLacciPersonDto() {
		return this.prpLacciPersonDto;
	}

	//modify by wangwei add end 2005-06-15

	public ClaimDto() {
	}

	/**
	 * 得到立案主表信息
	 * 
	 * @return 立案主表信息
	 */
	public PrpLclaimDto getPrpLclaimDto() {
		return prpLclaimDto;
	}

	/**
	 * 设置立案主表信息
	 * 
	 * @param prpLclaimDto
	 *            立案主表信息
	 */
	public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
		this.prpLclaimDto = prpLclaimDto;
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
	 * 得到立案文本信息
	 * 
	 * @return 立案文本信息
	 */
	public ArrayList getPrpLltextDtoList() {
		return prpLltextDtoList;
	}

	/**
	 * 设置立案文本信息
	 * 
	 * @param prpLclaimTextDtoList
	 *            立案文本信息
	 */
	public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
		this.prpLltextDtoList = prpLltextDtoList;
	}

	/**
	 * 得到三者车辆信息
	 * 
	 * @return 三者车辆信息
	 */
	public ArrayList getPrpLthirdPartyDtoList() {
		return prpLthirdPartyDtoList;
	}

	/**
	 * 设置三者车辆信息
	 * 
	 * @param PrpLthirdPartyDtoList
	 *            三者车辆表信息
	 */
	public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
		this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
	}

	/**
	 * 得到驾驭员信息
	 * 
	 * @return 驾驭员 信息
	 */
	public ArrayList getPrpLdriverDtoList() {
		return prpLdriverDtoList;
	}

	/**
	 * 设置驾驭员信息
	 * 
	 * @param PrpLdriverDtoList
	 *            驾驭员表信息
	 */
	public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList) {
		this.prpLdriverDtoList = prpLdriverDtoList;
	}
	
	/**
	 * 得到索赔申请人信息
	 * 
	 * @return 索赔申请人 信息
	 */
	public ArrayList getPrpLacciPersonDtoList() {
		return prpLacciPersonDtoList;
	}

	/**
	 * 设置索赔申请人信息
	 * 
	 * @param PrpLaccipersonDtoList
	 *            索赔申请人信息
	 */
	public void setPrpLacciPersonDtoList(ArrayList prpLacciPersonDtoList) {
		this.prpLacciPersonDtoList = prpLacciPersonDtoList;
	}
    
	/**
	 * 得到事故者信息
	 * 
	 * @return 事故者 信息
	 */
	public ArrayList getPrplacciBenPersonDtoList() {
		return prplacciBenPersonDtoList;
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
	
	/**
	 * 得到估损金额信息
	 * 
	 * @return 估损金额 信息
	 */
	public ArrayList getPrpLclaimFeeDtoList() {
		return prpLclaimFeeDtoList;
	}

	/**
	 * 设置估损金额信息
	 * 
	 * @param PrpLclaimFeeDtoList
	 *            估损金额表信息
	 */
	public void setPrpLclaimFeeDtoList(ArrayList prpLclaimFeeDtoList) {
		this.prpLclaimFeeDtoList = prpLclaimFeeDtoList;
	}

	/**
	 * 得到单证信息
	 * 
	 * @return 单证信息
	 */
	public ArrayList getPrpLdocDtoList() {
		return prpLdocDtoList;
	}

	/**
	 * 设置单证信息
	 * 
	 * @param PrpLdocDtoList
	 *            单证表信息
	 */
	public void setPrpLdocDtoList(ArrayList prpLdocDtoList) {
		this.prpLdocDtoList = prpLdocDtoList;
	}

	/**
	 * 得到立案操作状态信息
	 * 
	 * @return 立案操作状态信息
	 */
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	/**
	 * 设置立案操作状态信息
	 * 
	 * @param prpLclaimStuatsDto
	 *            立案操作状态信息
	 */
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	/**
	 * 得到险别估损金额信息
	 * 
	 * @return 险别估损金额 信息
	 */
	public ArrayList getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}

	public ArrayList getPrpCengageDtoList() {
		return prpCengageDtoList;
	}

	/**
	 * 设置险别估损金额信息
	 * 
	 * @param PrpLclaimLossDtoList
	 *            险别估损金额表信息
	 */
	public void setPrpLclaimLossDtoList(ArrayList prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}

	public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
		this.prpCengageDtoList = prpCengageDtoList;
	}

	/**
	 * 得到部件损失信息
	 * 
	 * @return 部件损失 信息
	 */

	public ArrayList getPrpLthirdCarLossDtoList() {
		return prpLthirdCarLossDtoList;
	}

	/**
	 * 设置部件损失信息
	 * 
	 * @param prpLthirdCarLossDtoList
	 *            部件损失信息
	 */

	public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
		this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
	}

	/**
	 * 设置其它损失信息
	 * 
	 * @param prpLthirdPropDtoList
	 *            其它损失信息
	 */

	public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
		this.prpLthirdPropDtoList = prpLthirdPropDtoList;
	}

	/**
	 * 得到其它损失信息
	 * 
	 * @return 其它损失信息
	 */

	public ArrayList getPrpLthirdPropDtoList() {
		return prpLthirdPropDtoList;
	}

	/**
	 * @param prpLRiskUnitDtoList
	 */
	public void setPrplRiskUnitDtoList(ArrayList prpLRiskUnitDtoList) {
		this.prpLRiskUnitDtoList = prpLRiskUnitDtoList;
	}

	/**
	 * @return ArrayList
	 */
	public ArrayList getPrpLRiskUnitDtoList() {
		return prpLRiskUnitDtoList;
	}
    /**
     * @param 立案信息扩展
     */
    public void setPrpLextDto(PrpLextDto prpLextDto) {
        this.prpLextDto = prpLextDto;
    }

    /**
     * @return 立案信息扩展
     */
    public PrpLextDto getPrpLextDto() {
        return prpLextDto;
    }
//  add by lym 20060809 start for （特殊赔案：垫支付）	
    /**
	 * @return Returns the prpLprepayDtoList.
	 */
	public ArrayList getPrpLprepayDtoList() {
		return prpLprepayDtoList;
	}
	/**
	 * @param prpLprepayDtoList The prpLprepayDtoList to set.
	 */
	public void setPrpLprepayDtoList(ArrayList prpLprepayDtoList) {
		this.prpLprepayDtoList = prpLprepayDtoList;
	}
//	add by lym 20060809 start for （特殊赔案：垫支付）

	public ArrayList getPrpLdangerItemDtoList() {
		return PrpLdangerItemDtoList;
	}

	public void setPrpLdangerItemDtoList(ArrayList prpLdangerItemDtoList) {
		PrpLdangerItemDtoList = prpLdangerItemDtoList;
	}

	public ArrayList getPrpLdangerTotDtoList() {
		return PrpLdangerTotDtoList;
	}

	public void setPrpLdangerTotDtoList(ArrayList prpLdangerTotDtoList) {
		PrpLdangerTotDtoList = prpLdangerTotDtoList;
	}

	public ArrayList getPrpLcompensateeartDtoList() {
		return prpLcompensateeartDtoList;
	}

	public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
		this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
	}

	public ArrayList getPrpLpreChargeDtoList() {
		return PrpLpreChargeDtoList;
	}

	public void setPrpLpreChargeDtoList(ArrayList prpLpreChargeDtoList) {
		PrpLpreChargeDtoList = prpLpreChargeDtoList;
	}
}
