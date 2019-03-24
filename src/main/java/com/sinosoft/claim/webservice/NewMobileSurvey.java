package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrplareasettingFacade;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;
import com.sinosoft.utiall.blsvr.BLPrpDuser;
import com.sinosoft.utiall.schema.PrpDuserSchema;
import com.sinosoft.utility.error.UserException;

/***
 * 移动查勘WebService类
 * 
 * @author fengye
 * 
 */
public class NewMobileSurvey {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 获取查勘定损人员查询信息
	 */
	public CheckCertaPersonInfo[] getCheckCertaPersonInfo(String comCode){
		long serial = System.currentTimeMillis();
		logger.log("获取查勘定损人员查询信息",1,serial,"[comCode:"+comCode+"]");
		String strContidions = "";
		Collection collection = new ArrayList();
		CheckCertaPersonInfo[] checklist = null;
		try {
			strContidions = "  ValidStatus='1' "
	                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + comCode
	                       + "' Connect By Prior comCode =  uppercomCode"
	                       + " and prior comcode != comcode and validstatus='1')";
			UICodeAction uicodeAction = new UICodeAction();
			ArrayList<PrpDuserDto>  checkCertaPersonList = (ArrayList<PrpDuserDto>)uicodeAction.findByConditions(UICodeAction.HANDERCODE,strContidions,0,0);
		    boolean checkPower = false ; //是否通过校验
		    int recordSize = -1; 
		    recordSize=collection.size();
		    
		    if(!isEmpty(checkCertaPersonList)) {
		    	ArrayList<CheckCertaPersonInfo> checkCertaPersonInfoList = new ArrayList<CheckCertaPersonInfo>();
				int i = 0;
				CheckCertaPersonInfo checkCertaPersonInfo = null;
				for(PrpDuserDto element:checkCertaPersonList) {
				   //对查询出的人员进行权限校验
			       com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
			       BLPrpDcompany prpDcompany = new BLPrpDcompany();   
		           String upperComCode = prpDcompany.getCenterCode(element.getComCode());
			       //此处赋值有问题，不应使用人员机构代码的上级机构作为登录机构，应使用传入的机构代码作为后续权限检验的依据
			       //platformPrpDuserDto.setLoginComCode(upperComCode);
			       platformPrpDuserDto.setLoginComCode(comCode);
			       platformPrpDuserDto.setUserCode(element.getUserCode());
			       checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
			       if (checkPower) {
			    	  checkCertaPersonInfo = new CheckCertaPersonInfo();
			    	  checkCertaPersonInfo.setUserCode(element.getUserCode());
			    	  checkCertaPersonInfo.setUserName(element.getUserName());
			    	  String phoneNumber  = getPhoneNumber(checkCertaPersonInfo.getUserCode(),comCode);
			    	  checkCertaPersonInfo.setPhoneNumber(phoneNumber);
			    	  checkCertaPersonInfoList.add(checkCertaPersonInfo);
			       }
			       if(null != checkCertaPersonInfoList && checkCertaPersonInfoList.size()>0){
			    	   checklist = new CheckCertaPersonInfo[checkCertaPersonInfoList.size()];
			    	   for(int j=0;j<checkCertaPersonInfoList.size();j++){
			    		   checklist[j] = checkCertaPersonInfoList.get(j);
			    	   }
			       }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询错误");
			logger.log("获取查勘定损人员查询信息",serial,e);
		}
		logger.log("获取查勘定损人员查询信息", 0,serial, checklist);
		return checklist;
	}
	
	
	private String getPhoneNumber(String userCode,String comCode) throws UserException, Exception {
		String phoneNumber = "";
		String isWhere = "";
		boolean isFalse = false;
		BLPrplareasettingFacade blPrplareasettingFacade = new BLPrplareasettingFacade();
		PrplareasettingDto prplareasettingDto = new PrplareasettingDto();
		isWhere = " handlercode = '" + userCode.trim() + "'  and classcode = '99'";
		ArrayList PrplareasettingDtoList = (ArrayList)blPrplareasettingFacade.findByConditions(isWhere);
		if(PrplareasettingDtoList.size() > 0){
			prplareasettingDto = (PrplareasettingDto)PrplareasettingDtoList.get(0);
			//如果一个人查到多个号码，需要取出一个。
			if(PrplareasettingDtoList.size() > 1){
				for(int m = 0;m<PrplareasettingDtoList.size();m++){
					PrplareasettingDto prplareasettingDtoTemp = (PrplareasettingDto)PrplareasettingDtoList.get(m);
					if(comCode!=null&&comCode.trim().length()!=0&&comCode.equals(prplareasettingDtoTemp.getHandledept())){
						prplareasettingDto = prplareasettingDtoTemp;
					}
				}
			}
			if(!"".equals(prplareasettingDto.getTel())){
				phoneNumber = prplareasettingDto.getTel().trim();
			}else{
				isFalse = true;
			}
		}
		if(isFalse){
			BLPrpDuser blPrpDuser = new BLPrpDuser();
			isWhere = " userCode ='" + userCode.trim() + "'";
			blPrpDuser.query(isWhere);
			PrpDuserSchema prpDuserSchema = new PrpDuserSchema();
			if(blPrpDuser.getSize() > 0){
				prpDuserSchema = blPrpDuser.getArr(0);
				phoneNumber = prpDuserSchema.getMobile().trim();
			}
		}
		return phoneNumber;
	}


	/**
	 * 获取查勘定损处理单位查询信息
	 */
	public CheckCertaCompanyInfo[] getCheckCertaCompanyInfo(){
		long serial = System.currentTimeMillis();
		CheckCertaCompanyInfo[] checkCertaCompanyInfoList = null;
		try {
			String strCondition = " comCode not like '0000%' or comCode like '00000013%' order by comlevel,comcode";
			BLPrpDcompanyFacade blPrpDcompayFacade = new BLPrpDcompanyFacade();
			ArrayList<PrpDcompanyDto>  checkCertaCompanyList =  (ArrayList<PrpDcompanyDto>)blPrpDcompayFacade.findByConditions(strCondition);
		    
		    if(!isEmpty(checkCertaCompanyList)) {
		    	checkCertaCompanyInfoList = new CheckCertaCompanyInfo[checkCertaCompanyList.size()];
				int i = 0;
				for(PrpDcompanyDto element:checkCertaCompanyList) {
					checkCertaCompanyInfoList[i++] = new CheckCertaCompanyInfo(element.getComCode(), element.getComCName(),element.getUpperComCode(),element.getComLevel());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询错误");
			logger.log("获取查勘定损处理单位查询信息",serial,e);
		}
		logger.log("获取查勘定损处理单位查询信息", 0,serial, checkCertaCompanyInfoList);
		return checkCertaCompanyInfoList;
	}
	
	
	/**
	 * 获取意键险事故类型查询信息
	 */
	@SuppressWarnings("unchecked")
	public EDamageTypeCodeInfo[] getEDamageTypeCodeInfo(String strRiskCode){
		long serial = System.currentTimeMillis();
		logger.log("获取意键险事故类型查询信息", 1,serial, "[strRiskCode:"+strRiskCode+"]");
		String strContidions = "";
		UICodeAction uicodeAction = new UICodeAction();
		EDamageTypeCodeInfo[] eDamageTypeCodeInfoList = null;
		try {
            if (isEmpty(strRiskCode)) {// 有效性校验
				
				throw new Exception("险种信息不能为空，请检查。");
			}
			strContidions = " codeType ='DamageTypeCode' and codecode in (select codecode from PrpDcodeRisk where (riskcode='"+strRiskCode+"'  OR riskcode='0000') and codetype='DamageTypeCode')  order by codecode";
			ArrayList<PrpDcodeDto> eDamageTypeCodeList = (ArrayList<PrpDcodeDto>)uicodeAction.findByConditions(UICodeAction.DAMAGETYPECODE,strContidions,0,0);
		    if(!isEmpty(eDamageTypeCodeList)) {
		    	eDamageTypeCodeInfoList = new EDamageTypeCodeInfo[eDamageTypeCodeList.size()];
				int i = 0;
				for(PrpDcodeDto element:eDamageTypeCodeList) {
					eDamageTypeCodeInfoList[i++] = new EDamageTypeCodeInfo(element.getCodeCode(), element.getCodeCName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询错误");
			logger.log("获取意键险事故类型查询信息",serial,e);
		}
		logger.log("获取意键险事故类型查询信息", 0,serial, eDamageTypeCodeInfoList);
		return eDamageTypeCodeInfoList;
	}
	
	
	/**
	 * 获取巨灾等级查询信息
	 */
	@SuppressWarnings("unchecked")
	public CatastropheCodeInfo[] getCatastropheCodeInfo(){
		long serial = System.currentTimeMillis();
		String strContidions = "";
		UICodeAction uicodeAction = new UICodeAction();
		CatastropheCodeInfo[] catastropheCodeInfoList = null;
		try {
			strContidions = " codeType ='CatastropheCode' and codecode in (select codecode from PrpDcodeRisk where riskcode='0000' and codetype='CatastropheCode') order by codecode";
			ArrayList<PrpDcodeDto>  catastropheCodeList = (ArrayList<PrpDcodeDto> )uicodeAction.findByConditions(UICodeAction.CATASTROPHECODE, strContidions, 0, 0);
		    if(!isEmpty(catastropheCodeList)) {
		    	catastropheCodeInfoList = new CatastropheCodeInfo[catastropheCodeList.size()];
				int i = 0;
				for(PrpDcodeDto element:catastropheCodeList) {
					catastropheCodeInfoList[i++] = new CatastropheCodeInfo(element.getCodeCode(), element.getCodeCName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询错误");
			logger.log("获取巨灾等级查询信息",serial,e);
		}
		logger.log("获取巨灾等级查询信息", 0,serial, catastropheCodeInfoList);
		return catastropheCodeInfoList;
	}
	
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	private boolean isEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return false;
		}
		return true;
	}
}

