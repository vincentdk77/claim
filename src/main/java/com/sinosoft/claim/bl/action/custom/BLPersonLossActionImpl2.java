/*
 * Created on 2006-6-26
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonFeeCodeRiskAction;
import com.sinosoft.claim.dto.custom.PersonLossDto;
import com.sinosoft.claim.dto.domain.PrpDpersonFeeCodeRiskDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * @author liuyanmei
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BLPersonLossActionImpl2 implements BLPersonLossAction {
	private BLPersonLossActionImpl2(){
		//禁止构造，使用getInstance()获处对象即可
	}
	private static BLPersonLossAction blPersonLossAction = new BLPersonLossActionImpl2();
	public static BLPersonLossAction getInstance(){
		return blPersonLossAction;
	}
	
	public void initPersonLoss(DBManager dbManager,String configCode,String riskCode,List prpLpersonLossList,double medicalLimit,double deathLimit)throws SQLException,Exception{
			
		//首先得到按优先级排列好的医疗费用类型代码和死亡伤残费用类型代码
		List compleMedicalCodeList = getCompelMedicalCodeList(dbManager);
		List compleDeathCodeList = getCompelDeathCodeList(dbManager);
		double realPay =0;
		if( "RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
				||"RISKCODE_DAU".equals(configCode)){ //强制得核定赔偿 按费用优先级别赋值
			//1.首先对所有费用明细的强制保险各医疗费用赋值
		
			for (Iterator iter = compleMedicalCodeList.iterator(); iter.hasNext();) {
				String medicalCode = (String) iter.next();
				for (Iterator iterator = prpLpersonLossList.iterator(); iterator.hasNext();) {
					PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iterator.next();
					if ("BZ".equals(prpLpersonLossDto.getKindCode())){
						if(medicalCode.equals(prpLpersonLossDto.getLiabDetailCode())){
							prpLpersonLossDto.setFeeCategory("M");
							if(medicalLimit>=(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest())){
								//设置强制赔付金额
								prpLpersonLossDto.setSumDefPay(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
								//去除限额
								medicalLimit -= (prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
							}else if(medicalLimit>0){
								//设置强制赔付金额
								prpLpersonLossDto.setSumDefPay(medicalLimit);
								//去除限额
								medicalLimit = 0;						
							} else{
								prpLpersonLossDto.setSumDefPay(0);
							}
							
							prpLpersonLossDto.setSumRealPay(prpLpersonLossDto.getSumDefPay()); //add
						}
					}
					
				}
			}
			//2.其次对所有明细的强制保险死亡伤残费用赋值
			for (Iterator iter = compleDeathCodeList.iterator(); iter.hasNext();) {
				String deathCode = (String) iter.next();
				for (Iterator iterator = prpLpersonLossList.iterator(); iterator.hasNext();) {
					PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iterator.next();
					if ("BZ".equals(prpLpersonLossDto.getKindCode())) {
						if(deathCode.equals(prpLpersonLossDto.getLiabDetailCode())){
							prpLpersonLossDto.setFeeCategory("D");
							if(deathLimit>=(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest())){
								//设置强制赔付金额
								prpLpersonLossDto.setSumDefPay(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
								//去除限额
								deathLimit -= (prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
							}else if(deathLimit>0){
								//设置强制赔付金额
								prpLpersonLossDto.setSumDefPay(deathLimit);
								//去除限额
								deathLimit = 0;							
							} else{
								prpLpersonLossDto.setSumDefPay(0);
							}
							prpLpersonLossDto.setSumRealPay(  prpLpersonLossDto.getSumDefPay());
						}
					}
				}
			}
		}else if( "RISKCODE_DAY".equals(configCode)){  //0505核定赔偿设为零
			for (Iterator iterator = prpLpersonLossList.iterator(); iterator.hasNext();) {
				PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iterator.next();
				if ("B".equals(prpLpersonLossDto.getKindCode())) {
					prpLpersonLossDto.setSumDefPay(0);
				}else{
					prpLpersonLossDto.setSumDefPay(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
				}
				prpLpersonLossDto.setFeeCategory(getBusinessFeeCategory(dbManager,riskCode,prpLpersonLossDto.getLiabDetailCode()));
				realPay = (prpLpersonLossDto.getSumDefPay())
				* (prpLpersonLossDto.getClaimRate() * 0.01) * (prpLpersonLossDto.getIndemnityDutyRate() * 0.01)
				* (1 - (prpLpersonLossDto.getDutyDeductibleRate() * 0.01))
				* (1 - (prpLpersonLossDto.getDeductibleRate() * 0.01));
				prpLpersonLossDto.setSumRealPay(realPay);
				
			}
		}else { //其他的车险 核定赔偿设为 核定损失-残值
			for (Iterator iterator = prpLpersonLossList.iterator(); iterator.hasNext();) {
				PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto) iterator.next();
				prpLpersonLossDto.setSumDefPay(prpLpersonLossDto.getSumLoss()-prpLpersonLossDto.getSumRest());
				prpLpersonLossDto.setFeeCategory(getBusinessFeeCategory(dbManager,riskCode,prpLpersonLossDto.getLiabDetailCode()));
				realPay = (prpLpersonLossDto.getSumDefPay())
				* (prpLpersonLossDto.getClaimRate() * 0.01) * (prpLpersonLossDto.getIndemnityDutyRate() * 0.01)
				* (1 - (prpLpersonLossDto.getDutyDeductibleRate() * 0.01))
				* (1 - (prpLpersonLossDto.getDeductibleRate() * 0.01));
				prpLpersonLossDto.setSumRealPay(realPay);
			}
		}
	}


	private String getBusinessFeeCategory(DBManager dbManager,String riskCode,String feeCode) throws Exception{
		String[] businessMedicalCodeArray = getBusinessMedicalCodeArray(dbManager,riskCode);
		String[] businessDeathCodeArray = getBusinessDeathCodeArray(dbManager,riskCode);
		if(ArrayUtils.contains(businessMedicalCodeArray, feeCode)){
			return PersonLossDto.FeeCategory.MEDICAL;
		}else if(ArrayUtils.contains(businessDeathCodeArray, feeCode)){
			return PersonLossDto.FeeCategory.DEATH;
		}else{
			return null;
		}
	}
	
	/**
	 * @param dbManager
	 * @return
	 * @throws Exception 
	 */
	private List getCompelMedicalCodeList(DBManager dbManager) throws Exception{
		List personFeeCodeList = BLPrpDpersonFeeCodeRiskAction.getInstance().findCompelMedicalCodeList(dbManager);
		List compelMedicalCodeList = new ArrayList();
		for (Iterator iter = personFeeCodeList.iterator(); iter.hasNext();) {
			PrpDpersonFeeCodeRiskDto personFeeCode = (PrpDpersonFeeCodeRiskDto) iter.next();
			compelMedicalCodeList.add(personFeeCode.getFeeCode());
		}
		return compelMedicalCodeList;
	}
	private List getCompelDeathCodeList(DBManager dbManager) throws Exception{
		List personFeeCodeList = BLPrpDpersonFeeCodeRiskAction.getInstance().findCompelDeathCodeList(dbManager);
		List compelDeathCodeList = new ArrayList();
		for (Iterator iter = personFeeCodeList.iterator(); iter.hasNext();) {
			PrpDpersonFeeCodeRiskDto personFeeCode = (PrpDpersonFeeCodeRiskDto) iter.next();
			compelDeathCodeList.add(personFeeCode.getFeeCode());
		}
		return compelDeathCodeList;
	}
	
	private String[] getBusinessMedicalCodeArray(DBManager dbManager,String riskCode) throws Exception{
		List personFeeCodeList = BLPrpDpersonFeeCodeRiskAction.getInstance().findMedicalCodeList(dbManager, riskCode);
		String[] businessMedicalCodeArray = new String[personFeeCodeList.size()];
		int i=0;
		for (Iterator iter = personFeeCodeList.iterator(); iter.hasNext();) {
			PrpDpersonFeeCodeRiskDto personFeeCode = (PrpDpersonFeeCodeRiskDto) iter.next();
			businessMedicalCodeArray[i++] = personFeeCode.getFeeCode();
		}
		return businessMedicalCodeArray;
	}
	private String[] getBusinessDeathCodeArray(DBManager dbManager,String riskCode) throws Exception{
		List personFeeCodeList = BLPrpDpersonFeeCodeRiskAction.getInstance().findDeathCodeList(dbManager, riskCode);
		String[] businessDeathCodeArray = new String[personFeeCodeList.size()];
		int i=0;
		for (Iterator iter = personFeeCodeList.iterator(); iter.hasNext();) {
			
			PrpDpersonFeeCodeRiskDto personFeeCode = (PrpDpersonFeeCodeRiskDto) iter.next();
			businessDeathCodeArray[i++] = personFeeCode.getFeeCode();
		}
		return businessDeathCodeArray;
	}

}
