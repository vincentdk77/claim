package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;

/**
 * 自定义实赔数据传输对象
 * <p>
 * Title: 车险理赔实赔DTO
 * </p>
 * <p>
 * Description: 车险理赔实赔样本程序
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class CompensateDto implements Serializable {
    /** 赔款计算书主信息 */
    private PrpLcompensateDto prpLcompensateDto;
    /** 特别约定信息 */
    private ArrayList prpCengageDtoList;
    
    private ArrayList prpLacciPersonDtoList;
    /** 事故者信息 */
    private ArrayList prpLacciBenPersonList;
    
    //存农险团单时被保险人信息
    private ArrayList prpLagriPersonDtoList;
    
    /** 赔付标的信息 */
    private ArrayList prpLlossDtoList;
    /** 赔付人员信息 */
    private ArrayList prpLpersonLossDtoList;
    /** 赔款费用信息 */
    private ArrayList prpLchargeDtoList;
    /** 理算报告 */
    private ArrayList prpLctextDtoDtoList;
    /** 立案信息 */
    private PrpLclaimDto prpLclaimDto;
    /** 限额免赔代码表 */
    private ArrayList prpDlimitDtoList;
    /** 赔款计算金额表 */
    private ArrayList prpLcfeeDtoList;
    /** 限额免赔代码表 */
    private ArrayList prpClimitDtoList;
    /** 质量评审内容 */
    private ArrayList prpLqualityCheckList;
    /** 报案信息补充说明 */
    private ArrayList prpLregistExtDtoList;
    /** 结案报告 */
    /**理算免赔信息 add by qinyongli 2006-01-10*/
    private ArrayList prpLdeductibleList;
    /**理算免赔信息 add by qinyongli 2006-01-10*/
    private ArrayList prpLltextDtoList;
    /**危险单位add by qinyongli 2005-8-19 */
    private ArrayList prplRiskUnitDtoList;
    /**理赔危险单位金额合计信息 add by qinyongli 2005-09-10*/
    private ArrayList prpLprpLdangerTotList;
    /**理赔的危险单位信息表 add by qinyongli 2005-09-10*/
    private ArrayList prpLprpLdangerItemList;
    
    private ArrayList prpLcfeecoinsList;
    
    private ArrayList prpLhospitalizationPayFeeDtoList;
    /**车险维修发票信息 */
    private ArrayList prpLcomRepairBillDtoList;
    /**耳标信息 */
    private ArrayList prpLcompensateeartDtoList;
    
    private ArrayList prplCompensateHouseDtoList;
    /**
     * 无责代赔
     */
    private ArrayList prpLnodutyLossDtoList;
    
    private ArrayList prpLthirdPartyDtoList;
    /**出险人详细情况信息*/
    private ArrayList prpLinjuryPersonList;
    
    public ArrayList getPrpLthirdPartyDtoList() {
		return prpLthirdPartyDtoList;
	}

	public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
		this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
	}

	public ArrayList getPrpLhospitalizationPayFeeDtoList(){
    	return prpLhospitalizationPayFeeDtoList;
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
    
    public void setPrpLhospitalizationPayFeeDtoList(ArrayList prpLhospitalizationPayFeeDtoList){
    	this.prpLhospitalizationPayFeeDtoList = prpLhospitalizationPayFeeDtoList;
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
    
    public ArrayList getPrpLacciPersonDtoList() {
        return prpLacciPersonDtoList;
    }
    /**
     * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
     */
    public void setPrpLacciPersonDtoList(ArrayList prpLacciPersonDtoList) {
        this.prpLacciPersonDtoList = prpLacciPersonDtoList;
    }
    
    public ArrayList getPrpLagriPersonDtoList() {
        return prpLagriPersonDtoList;
    }
 
    public void setPrpLagriPersonDtoList(ArrayList prpLagriPersonDtoList) {
        this.prpLagriPersonDtoList = prpLagriPersonDtoList;
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
    /** 操作状态信息 */
    private PrpLclaimStatusDto prpLclaimStatusDto;

    /**
     * 得到赔款费用信息
     * 
     * @return 赔款费用信息
     */
    public ArrayList getPrpLchargeDtoList() {
        return prpLchargeDtoList;
    }

    /**
     * 得到赔款计算书主信息
     * 
     * @return 赔款计算书主信息
     */
    public PrpLcompensateDto getPrpLcompensateDto() {
        return prpLcompensateDto;
    }

    /**
     * 得到特别约定信息
     * 
     * @return 特别约定信息
     */
    public ArrayList getPrpCengageDtoList() {
        return prpCengageDtoList;
    }

    /**
     * 得到赔付人员信息
     * 
     * @return 赔付人员信息
     */
    public ArrayList getPrpLpersonLossDtoList() {
        return prpLpersonLossDtoList;
    }

    /**
     * 得到操作状态信息
     * 
     * @return 操作状态信息
     */
    public PrpLclaimStatusDto getPrpLclaimStatusDto() {
        return prpLclaimStatusDto;
    }

    /**
     * 得到赔付标的信息
     * 
     * @return 赔付标的信息
     */
    public ArrayList getPrpLlossDtoList() {
        return prpLlossDtoList;
    }

    /**
     * 设置理算报告
     * 
     * @param prpLctextDtoDtoList 理算报告
     */
    public void setPrpLctextDtoDtoList(ArrayList prpLctextDtoDtoList) {
        this.prpLctextDtoDtoList = prpLctextDtoDtoList;
    }

    /**
     * 设置赔款费用信息
     * 
     * @param prpLchargeDtoList 赔款费用信息
     */
    public void setPrpLchargeDtoList(ArrayList prpLchargeDtoList) {
        this.prpLchargeDtoList = prpLchargeDtoList;
    }

    /**
     * 设置赔款计算书主信息
     * 
     * @param prpLcompensateDto 赔款计算书主信息
     */
    public void setPrpLcompensateDto(PrpLcompensateDto prpLcompensateDto) {
        this.prpLcompensateDto = prpLcompensateDto;
    }

    /**
     * 设置特别约定信息
     * 
     * @param prpCengageDtoList 特别约定信息
     */
    public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
        this.prpCengageDtoList = prpCengageDtoList;
    }

    /**
     * 设置三者车辆信息
     * 
     * @param PrpLthirdPartyDtoList 三者车辆表信息
     */
    public void setPrpLpersonLossDtoList(ArrayList prpLpersonLossDtoList) {
        this.prpLpersonLossDtoList = prpLpersonLossDtoList;
    }

    /**
     * 设置赔付人员信息
     * 
     * @param prpLpersonLossDtoList 赔付人员信息
     */
    public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
        this.prpLclaimStatusDto = prpLclaimStatusDto;
    }

    /**
     * 设置赔付标的信息
     * 
     * @param prpLlossDtoList 赔付标的信息
     */
    public void setPrpLlossDtoList(ArrayList prpLlossDtoList) {
        this.prpLlossDtoList = prpLlossDtoList;
    }

    /**
     * 设置立案信息
     * 
     * @param prpLclaimDto 立案信息
     */
    public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
        this.prpLclaimDto = prpLclaimDto;
    }

    public void setPrpDlimitDtoList(ArrayList prpDlimitDtoList) {
        this.prpDlimitDtoList = prpDlimitDtoList;
    }

    public void setPrpClimitDtoList(ArrayList prpClimitDtoList) {
        this.prpClimitDtoList = prpClimitDtoList;
    }

    public void setPrpLcfeeDtoList(ArrayList prpLcfeeDtoList) {
        this.prpLcfeeDtoList = prpLcfeeDtoList;
    }

    /**
     * 设置理算报告
     * 
     * @param prpLctextDtoDtoList 理算报告
     */
    public ArrayList getPrpLctextDtoDtoList() {
        return prpLctextDtoDtoList;
    }

    /**
     * 得到立案信息
     * 
     * @return 立案信息
     */
    public PrpLclaimDto getPrpLclaimDto() {
        return prpLclaimDto;
    }

    public ArrayList getPrpDlimitDtoList() {
        return prpDlimitDtoList;
    }

    public ArrayList getPrpClimitDtoList() {
        return prpClimitDtoList;
    }

    public ArrayList getPrpLcfeeDtoList() {
        return prpLcfeeDtoList;
    }

    public CompensateDto() {
    }

    public ArrayList getPrpLltextDtoList() {
        return prpLltextDtoList;
    }
    public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
        this.prpLltextDtoList = prpLltextDtoList;
    }
    /**
     * 返回危险单位 add by qinyongli 2005-8-19
     * @return
     */
    public ArrayList getPrplRiskUnitDtoList() {
        return prplRiskUnitDtoList;
    }
    /**
     * 设置危险单位 add by qinyongli 2005-8-19
     * @param prplRiskUnitDtoList
     */
    public void setPrplRiskUnitDtoList(ArrayList prplRiskUnitDtoList) {
        this.prplRiskUnitDtoList = prplRiskUnitDtoList;
    }
    /**
     * 返回理赔危险单位金额合计信息 add by qinyongli 2005-9-10
     * @return
     */
    public ArrayList getPrpLprpLdangerTotList() {
        return prpLprpLdangerTotList;
    }
    /**
     * 设置理赔危险单位金额合计信息 add by qinyongli 2005-9-10
     * @param prpLprpLdangerTotList
     */
    public void setPrpLprpLdangerTotList(ArrayList prpLprpLdangerTotList) {
        this.prpLprpLdangerTotList = prpLprpLdangerTotList;
    }
    /**
     * 返回理赔的危险单位信息 add by qinyongli 2005-8-19
     * @return
     */
    public ArrayList getPrpLprpLdangerItemList() {
        return prpLprpLdangerItemList;
    }
    /**
     * 设置理赔的危险单位信息 add by qinyongli 2005-8-19
     * @param prpLprpLdangerItemList
     */
    public void setPrpLprpLdangerItemList(ArrayList prpLprpLdangerItemList) {
        this.prpLprpLdangerItemList = prpLprpLdangerItemList;
    }

    /**
     * 返回理赔的理算免赔 add by qinyongli 2006-01-11
     * @return
     */
    public ArrayList getPrpLdeductibleList() {
        return prpLdeductibleList;
    }
    /**
     * 设置理赔的理算免赔 add by qinyongli 2006-01-11
     * @param prpLdeductibleList
     */
    public void setPrpLdeductibleList(ArrayList prpLdeductibleList) {
        this.prpLdeductibleList = prpLdeductibleList;
    }
    
    public ArrayList getPrpLcfeecoinsList()
    {
        return prpLcfeecoinsList;
    }

    public void setPrpLcfeecoinsList(ArrayList prpLcfeecoinsList)
    {
        this.prpLcfeecoinsList = prpLcfeecoinsList;
    }

	public ArrayList getPrpLnodutyLossDtoList() {
		return prpLnodutyLossDtoList;
	}

	public void setPrpLnodutyLossDtoList(ArrayList prpLnodutyLossDtoList) {
		this.prpLnodutyLossDtoList = prpLnodutyLossDtoList;
	}

	public ArrayList getPrpLacciBenPersonList() {
		return prpLacciBenPersonList;
	}

	public void setPrpLacciBenPersonList(ArrayList prpLacciBenPersonList) {
		this.prpLacciBenPersonList = prpLacciBenPersonList;
	}

	public ArrayList getPrpLcomRepairBillDtoList() {
		return prpLcomRepairBillDtoList;
	}

	public void setPrpLcomRepairBillDtoList(ArrayList prpLcomRepairBillDtoList) {
		this.prpLcomRepairBillDtoList = prpLcomRepairBillDtoList;
	}

	/**
	 * @return the prpLcompensateeartDtoList
	 */
	public ArrayList getPrpLcompensateeartDtoList() {
		return prpLcompensateeartDtoList;
	}

	/**
	 * @param prpLcompensateeartDtoList the prpLcompensateeartDtoList to set
	 */
	public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
		this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
	}

	public ArrayList getPrpLinjuryPersonList() {
		return prpLinjuryPersonList;
	}

	public void setPrpLinjuryPersonList(ArrayList prpLinjuryPersonList) {
		this.prpLinjuryPersonList = prpLinjuryPersonList;
	}
   
}
