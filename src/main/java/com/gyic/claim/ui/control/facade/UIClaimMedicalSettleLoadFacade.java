package com.gyic.claim.ui.control.facade;

import  jxl.*;

import java.io.*;

import  jxl.read.biff.BiffException;
import org.apache.struts.upload.FormFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.Action;


import com.gyic.claim.bl.action.domain.*;
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.utils.LoadForm;
import com.gyic.claim.utils.PlantingSettleExport;
import com.gyic.claim.utils.MedicalSettleExport;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.blsvr.lp.BLPrpLcompensate;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDkind;
import com.sinosoft.utility.error.UserException;

public class UIClaimMedicalSettleLoadFacade extends Action{
	static double topLimitOfGrownSeason = 1.00;
	static double lowerLimitOfGrownSeason = 0;
	static double lowerLimitOfSettleArea = 0.1;
	static double topLimitOfTotalLoss = 100;
	static double topLimitOfClaimRate = 1.00;
	static double lowerLimitOfClaimRate = 0;
	 Utils utils=new Utils();
	public String medicalLoadAct(HttpServletRequest request,String rootPath,LoadForm loadForm)
		throws Exception {
		try {
			request.setAttribute("loadXLS", "loadXLS");
	    	request.setAttribute("insureListCode", request.getParameter("insureListCode"));
	    	request.setAttribute("settleListCode", request.getParameter("settleListCode"));
	    	request.setAttribute("policyNo", request.getParameter("policyNo"));
	    	request.setAttribute("nodeType", request.getParameter("nodeType"));
	    	request.setAttribute("registNo", request.getParameter("registNo"));
	    	request.setAttribute("claimNo", request.getParameter("claimNo"));
	    	request.setAttribute("riskCode", request.getParameter("riskCode"));
	    	request.setAttribute("classCode", request.getParameter("classCode"));
	    	//request.setAttribute("registNo", request.getParameter("registNo"));
	    	request.setAttribute("editType", request.getParameter("editType"));
	    	request.setAttribute("compensateNo", request.getParameter("compensateNo"));
	    	request.setAttribute("timeStamp", request.getParameter("timeStamp"));
            utils.getPhisicaMemory("校验理赔清单并保存临时表开始-----start");
			Boolean bRes=loadSettleInfo(request,rootPath,loadForm);
			utils.getPhisicaMemory("校验理赔清单并保存临时表结束-----end");
			if (bRes){
				request.setAttribute("opType", "loadXLS");
				return ("success");
			}else{
				return ("message");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	private Boolean loadSettleInfo(HttpServletRequest request,String rootPath, LoadForm loadForm){
		try{
			String riskCode = request.getParameter("riskCode");
			//List<String> strTitleList = MedicalSettleExport.getTitleListByRisk(riskCode);
			Map excelMap;

			excelMap=loadExcelData(request,rootPath,loadForm);
			
			if ((excelMap==null) || (excelMap.size()==0))
				return false;
			
			StringBuffer errorMessage = (StringBuffer)excelMap.get("errorMessage");
			if(null!=errorMessage && !"".equals(errorMessage.toString())){
				request.setAttribute("errorMessage", errorMessage);
				return false;
			}
			else{
				List medicalSettleList = (List)excelMap.get("medicalSettleListDtoList");
				String registNo = request.getParameter("registNo");
				String timeStamp = request.getParameter("timeStamp");
				if(null!=registNo && !"".equals(registNo)){
					deletePrevousTempData(registNo,timeStamp);//在保存之前先清空当前报案的临时表数据。
					boolean saveResult = saveToTempTable(medicalSettleList,registNo,request);//将数据保存到临时表中,并将时间戳放到request中。
					if(!saveResult){
						request.setAttribute("errorMessage1", "暂存理赔清单失败！！");
						return false;
					}
				}
			}			
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}	
		return true;
	}

	private Map loadExcelData(HttpServletRequest request,String rootPath,LoadForm loadForm){
		try{
			String riskCode = request.getParameter("riskCode");
			Map saveMap=null;
				
			InputStream in=null;
			String savePath=rootPath;
			FormFile formFile = loadForm.getFormFile();
			String fileName=savePath+"\\"+formFile.getFileName();
				
			in =formFile.getInputStream();
			//System.err.println(riskCode);
			if("2801".equals(riskCode) || "2605".equals(riskCode) || "2606".equals(riskCode))
			{
				saveMap = checkAndLoadSettleExcel(request,in);
			}
			if("2607".equals(riskCode))
			{
				
				saveMap = checkAndLoadSettleExcelFor2607(request,in);
			}
			
			in.close();
			return saveMap;
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	private Map checkAndLoadSettleExcel(HttpServletRequest request, InputStream in){
		Workbook workbook=null;
		/**
		 * resultMap 包含两个参数： List medicalSettleListDtoList 理赔清单子表信息。
		 * 						 StringBuffer errorMessage 出错信息，用于页面显示。
		 */
		Map resultMap = new HashMap();
		String settleListCode = request.getParameter("settleListCode");
		//String insureListCode = request.getParameter("insureListCode");
		String policyNo = request.getParameter("policyNo");
		String nodeType = request.getParameter("nodeType");
		String registNo = request.getParameter("registNo");
		String riskCode = request.getParameter("riskCode");
		String classCode = request.getParameter("classCode");
		String compensateNo = request.getParameter("compensateNo");

		double lowerLimitOfPartialLoss = 0.0;
		try{
			workbook=Workbook.getWorkbook(in);
			Sheet sheet=workbook.getSheet(0);
			
			//boolean isReopen = isReopenCase(registNo, policyNo,nodeType,compensateNo);
			//List reopenSettleCodeList = new ArrayList();
			//if(isReopen)
				//reopenSettleCodeList = getAllReopenSettleCodeList(registNo, policyNo,compensateNo);
			List medicalSettleListDtoList = new ArrayList();
			List medicalSettleListTotalDtoList = new ArrayList();
			List reopenFcodeList = new ArrayList();
			StringBuffer errorMessage = new StringBuffer();
			
			String sqlCondition = "";
			MedicalsettlelistDto medicalSettleListDto = new MedicalsettlelistDto();
			MedicalsettlelistDto medicalSettleListTotalDto = new MedicalsettlelistDto();
			//BLMedicalpolicylistFacade blMedicalPolicyListFacade = new BLMedicalpolicylistFacade();
			//Collection collectionMedicalPolicyList = new ArrayList();
			//Map kindCodeMap = new HashMap();
			//Map claimRateMap = new HashMap();
			String enterSymbol = "<br/>";
			
			if ( null==riskCode || "".equals(riskCode)){
				errorMessage.append("险种 "+riskCode +"为空！"+enterSymbol);
				resultMap.put("errorMessage", errorMessage);
				return resultMap;
			}
			
			//将第一个农户(第六行)的kindCode作为整张单子的默认kindCode,查询保单中的。
			//String kindCode = sheet.getCell(8, 5).getContents().trim();
			//if(null == kindCode || "".equals(kindCode)){
				//errorMessage.append("第一行农户的险别信息错误！！"+enterSymbol);
				//resultMap.put("errorMessage", errorMessage);
				//return resultMap;
			//}
			
			PrpCitemKindSchema prpCitemKindSchema = getPrpCitemKindSchema(policyNo, riskCode);
			if(null==prpCitemKindSchema){
				errorMessage.append("没有找到保单为"+policyNo+"，险种为"+riskCode+"的标的子险信息。"+enterSymbol);
				resultMap.put("errorMessage", errorMessage);
				return resultMap;
			}
			String strDamageDate = getDamageDateByRegistNo(registNo);
			String strDamageHour = getDamageHourByRegistNo(registNo);
			//lowerLimitOfPartialLoss = 30;
			UserDto user = (UserDto)request.getSession().getAttribute("user");
			String opCode = user.getUserCode();
			DateTime dateTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
			
			if("".equals(errorMessage.toString())){//进行Excel解析。
				for (int i = 5; i < sheet.getRows(); i++){//第6行开始读入
					medicalSettleListDto = new MedicalsettlelistDto();
					
					String name = sheet.getCell(1, i).getContents().trim();

					String idcard = sheet.getCell(2, i).getContents().trim();

					String medicalcard = sheet.getCell(3, i).getContents().trim();
	
					String suminsured = sheet.getCell(4, i).getContents().trim();

					String settlesum = sheet.getCell(5, i).getContents().trim();

					String medicalfamily = sheet.getCell(6, i).getContents().trim();

					String bank = sheet.getCell(7, i).getContents().trim();

					String creditcard = sheet.getCell(8, i).getContents().trim();

					//String fRemark = sheet.getCell(9, i).getContents().trim();
					
					String coln = sheet.getCell(0, i).getContents().trim();
					if (("总计：").equals(coln) || ("总计").equals(coln) || ("合计：").equals(coln) || ("合计").equals(coln))
						break;
					if("".equals(name) || name == null)
					{
						//errorMessage.append("第"+(i+1)+"行，被保险人姓名为空，不允许导入"+enterSymbol);
						break;
					}
					if("".equals(medicalcard) || medicalcard == null)
					{
						//errorMessage.append("第"+(i+1)+"行，医保编号为空，不允许导入"+enterSymbol);
						break;
					}
					if("".equals(idcard) || idcard == null)
					{
						//errorMessage.append("第"+(i+1)+"行，身份证号为空，不允许导入"+enterSymbol);
						break;
					}
					

									
					//if(null == strfGrowingSeason || "".equals(strfGrowingSeason)){
					//errorMessage += "第"+(i+1)+"行，农户"+fCode+"的生长期比例为空！"+enterSymbol;
					//continue;
					//}			
					
		
					//sqlCondition = " fcode like '"+fCode+"' and riskCode like '"+riskCode+"' and kindCode like '"+fKindCode+"' and inusreListCode like '"+insureListCode+"' and validity like '1' ";
					//collectionMedicalPolicyList = blMedicalPolicyListFacade.findByConditions(sqlCondition);

						//MedicalpolicylistDto medicalPolicyListDto = (MedicalpolicylistDto)(collectionMedicalPolicyList.toArray()[0]);
						//从保单清单带入农户基本信息
						//medicalSettleListDto = getBasicInfoFromPolicyList(medicalSettleListDto,medicalPolicyListDto,request);
						
						boolean newTotalDto = false;
						medicalSettleListDto.setName(name);
						medicalSettleListDto.setRiskcode(riskCode);
						String classCode1 = riskCode.substring(0,2);
						medicalSettleListDto.setOpcode(opCode);
						medicalSettleListDto.setOptime(dateTime);
						medicalSettleListDto.setClasscode(classCode1);
						Double dsuminsured = transformStringToDouble(suminsured);
						medicalSettleListDto.setSuminsured(dsuminsured);
						medicalSettleListDto.setBank(bank);
						medicalSettleListDto.setCreditcard(creditcard);
						medicalSettleListDto.setIdcard(idcard);
						medicalSettleListDto.setMedicalfamily(medicalfamily);
						medicalSettleListDto.setNodetype(nodeType);
						medicalSettleListDto.setValidity("1");
						medicalSettleListDto.setMedicalcard(medicalcard);
						//kindCodeMap.put(fKindCode, fKindCode);
						
						medicalSettleListTotalDto = getDtoFromMedicalSettleListTotalDtoList(medicalSettleListTotalDtoList, medicalSettleListDto);
						if(null==medicalSettleListTotalDto.getIdcard()||"".equals(medicalSettleListTotalDto.getIdcard())){
							medicalSettleListTotalDto.setIdcard(idcard);
							medicalSettleListTotalDto.setRiskcode(riskCode);
							//medicalSettleListTotalDto.setKindcode(fKindCode);
							newTotalDto = true;
						}
					
										
						//损失率必须在规定的损失范围内。
						//double lossRate = transformStringToDouble(strfLostRate);
						//lossRate = MedicalSettleExport.round(lossRate, 2);

						//medicalSettleListDto.setLossrate(lossRate);
						
						//生长期比率必须在规定的范围内。
//						double grownSeason = transformStringToDouble(strfGrowingSeason);
//						if(topLimitOfGrownSeason<grownSeason || lowerLimitOfGrownSeason>=grownSeason){
//							errorMessage += "第"+(i+1)+"行，农户"+fCode+"的生长期比率必须在"+lowerLimitOfGrownSeason+"到"+topLimitOfGrownSeason+"之间！"+enterSymbol;
//							continue;
//						}
//						medicalSettleListDto.setGrowingseason(grownSeason);
						
						//赔付比例必须在规定的范围内。
					
						
						//计算赔款金额
						//medicalPolicyListDto 应该替换成为出险时清单数据。
						//double settleSum = calculateSettleSum(prpCitemKindSchema,settleArea,lossRate,claimRate,medicalPolicyListDto);
						//settleSum = MedicalSettleExport.round(settleSum, 2);
						//medicalSettleListDto.setSettlesum(settleSum);
						Double dsettlesum = transformStringToDouble(settlesum);
						medicalSettleListDto.setSettlesum(dsettlesum);
						
						if(medicalSettleListTotalDto.getSettlesum()==0)
							medicalSettleListTotalDto.setSettlesum(dsettlesum);
						else medicalSettleListTotalDto.setSettlesum(medicalSettleListTotalDto.getSettlesum()+dsettlesum);
						
						//存入电话号码和备注。
						//medicalSettleListDto.setPhone(fPhone);
						//medicalSettleListDto.setRemark(fRemark);
						
						medicalSettleListDtoList.add(medicalSettleListDto);
						if(newTotalDto)
							medicalSettleListTotalDtoList.add(medicalSettleListTotalDto);
						

						//与保单最新清单进行总亩数和总金额的校验。
						//checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,medicalPolicyListDto,true,enterSymbol);
						//与出险时清单进行总亩数和总金额的校验。
//						checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,medicalPolicyListDto,false,enterSymbol);
						//MedicalpolicylistDto damageDateMedicalPolicyListDto = getDamageDateMedicalPolicyListDto(medicalPolicyListDto, strDamageDate, strDamageHour, policyNo, kindCode, fCode, riskCode);
						//checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,damageDateMedicalPolicyListDto,false,enterSymbol);
						
						//对于案后重开的案件，如果理赔面积小于0，增加与本案之前的理赔清单的总金额和面积校验。
					}
				}
				//errorMessage = checkKindCodeType(errorMessage,kindCodeMap);
				//errorMessage = checkClaimRate(errorMessage,claimRateMap);
			
			resultMap.put("medicalSettleListDtoList", medicalSettleListDtoList);
			resultMap.put("errorMessage", errorMessage);
			workbook.close();
		}catch (BiffException e){
			e.printStackTrace();
		//	workbook.close();
			return null;
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if (workbook!=null)
				workbook.close();
		}
		return resultMap;
	}

	private Map checkAndLoadSettleExcelFor2607(HttpServletRequest request, InputStream in){
		Workbook workbook=null;
		/**
		 * resultMap 包含两个参数： List medicalSettleListDtoList 理赔清单子表信息。
		 * 						 StringBuffer errorMessage 出错信息，用于页面显示。
		 */
		Map resultMap = new HashMap();
		String settleListCode = request.getParameter("settleListCode");
		String insureListCode = request.getParameter("insureListCode");
		String policyNo = request.getParameter("policyNo");
		String nodeType = request.getParameter("nodeType");
		String registNo = request.getParameter("registNo");
		String riskCode = request.getParameter("riskCode");
		String classCode = request.getParameter("classCode");
		String compensateNo = request.getParameter("compensateNo");

		double lowerLimitOfPartialLoss = 0.0;
		try{
			workbook=Workbook.getWorkbook(in);
			Sheet sheet=workbook.getSheet(0);
			
			//boolean isReopen = isReopenCase(registNo, policyNo,nodeType,compensateNo);
			//List reopenSettleCodeList = new ArrayList();
			//if(isReopen)
				//reopenSettleCodeList = getAllReopenSettleCodeList(registNo, policyNo,compensateNo);
			List medicalSettleListDtoList = new ArrayList();
			List medicalSettleListTotalDtoList = new ArrayList();
			List reopenFcodeList = new ArrayList();
			StringBuffer errorMessage = new StringBuffer();
			
			String sqlCondition = "";
			MedicalsettlelistDto medicalSettleListDto = new MedicalsettlelistDto();
			MedicalsettlelistDto medicalSettleListTotalDto = new MedicalsettlelistDto();
			BLMedicalPolicyListFacade blMedicalPolicyListFacade = new BLMedicalPolicyListFacade();
			Collection collectionMedicalPolicyList = new ArrayList();
			//Map kindCodeMap = new HashMap();
			//Map claimRateMap = new HashMap();
			String enterSymbol = "<br/>";
			
			if ( null==riskCode || "".equals(riskCode)){
				errorMessage.append("险种 "+riskCode +"为空！"+enterSymbol);
				resultMap.put("errorMessage", errorMessage);
				return resultMap;
			}
			
			//将第一个农户(第六行)的kindCode作为整张单子的默认kindCode,查询保单中的。
			//String kindCode = sheet.getCell(8, 5).getContents().trim();
			//if(null == kindCode || "".equals(kindCode)){
				//errorMessage.append("第一行农户的险别信息错误！！"+enterSymbol);
				//resultMap.put("errorMessage", errorMessage);
				//return resultMap;
			//}
			
			PrpCitemKindSchema prpCitemKindSchema = getPrpCitemKindSchema(policyNo, riskCode);
			if(null==prpCitemKindSchema){
				errorMessage.append("没有找到保单为"+policyNo+"，险种为"+riskCode+"的标的子险信息。"+enterSymbol);
				resultMap.put("errorMessage", errorMessage);
				return resultMap;
			}
			String strDamageDate = getDamageDateByRegistNo(registNo);
			String strDamageHour = getDamageHourByRegistNo(registNo);
			//lowerLimitOfPartialLoss = 30;
			UserDto user = (UserDto)request.getSession().getAttribute("user");
			String opCode = user.getUserCode();
			DateTime dateTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
			
			if("".equals(errorMessage.toString())){//进行Excel解析。
				for (int i = 5; i < sheet.getRows(); i++){//第6行开始读入
					medicalSettleListDto = new MedicalsettlelistDto();
					
					String name = sheet.getCell(1, i).getContents().trim();

					String idcard = sheet.getCell(2, i).getContents().trim();

					String medicalcard = sheet.getCell(3, i).getContents().trim();
	
					String suminsured = sheet.getCell(4, i).getContents().trim();

					String settlesum = sheet.getCell(5, i).getContents().trim();

					String medicalfamily = sheet.getCell(6, i).getContents().trim();

					String bank = sheet.getCell(7, i).getContents().trim();

					String creditcard = sheet.getCell(8, i).getContents().trim();

					//String fRemark = sheet.getCell(9, i).getContents().trim();
					
					String coln = sheet.getCell(0, i).getContents().trim();
					if (("总计：").equals(coln) || ("总计").equals(coln) || ("合计：").equals(coln) || ("合计").equals(coln))
						break;
					if("".equals(name) || name == null)
					{
						//errorMessage.append("第"+(i+1)+"行，被保险人姓名为空，不允许导入"+enterSymbol);
						break;
					}

					if("".equals(idcard) || idcard == null)
					{
						//errorMessage.append("第"+(i+1)+"行，身份证号为空，不允许导入"+enterSymbol);
						break;
					}
					if("".equals(settlesum) || settlesum == null)
					{
						//errorMessage.append("第"+(i+1)+"行，赔付金额为空，不允许导入"+enterSymbol);
						break;
					}
					
					sqlCondition = " idcard like '"+idcard+"' and inusreListCode like '"+insureListCode+"' and validity like '1' ";
					
					collectionMedicalPolicyList = blMedicalPolicyListFacade.findByConditions(sqlCondition);
					if(null==collectionMedicalPolicyList || collectionMedicalPolicyList.size()!=1){
						errorMessage.append("第"+(i+1)+"行，身份证号为"+idcard+"的被保险人在保单清单中对应的记录为空或者不唯一！"+enterSymbol);
					}
					else
					{
						MedicalPolicyListDto medicalPolicyListDto = (MedicalPolicyListDto)(collectionMedicalPolicyList.toArray()[0]);
						double  sumAmount = 0;
						if(medicalPolicyListDto != null)
						{
							sumAmount = medicalPolicyListDto.getBscAmount() + medicalPolicyListDto.getOptAmount();
						}
						
						if((transformStringToDouble(settlesum)) > sumAmount)
						{
							errorMessage.append("第"+(i+1)+"行，身份证号为"+idcard+"的被保险人的赔付金额为" + transformStringToDouble(settlesum) + ",大于保额，保额为" + sumAmount+enterSymbol);
							continue;
						}
					}

									
					//if(null == strfGrowingSeason || "".equals(strfGrowingSeason)){
					//errorMessage += "第"+(i+1)+"行，农户"+fCode+"的生长期比例为空！"+enterSymbol;
					//continue;
					//}			
					
		
					//sqlCondition = " fcode like '"+fCode+"' and riskCode like '"+riskCode+"' and kindCode like '"+fKindCode+"' and inusreListCode like '"+insureListCode+"' and validity like '1' ";
					//collectionMedicalPolicyList = blMedicalPolicyListFacade.findByConditions(sqlCondition);

						//MedicalpolicylistDto medicalPolicyListDto = (MedicalpolicylistDto)(collectionMedicalPolicyList.toArray()[0]);
						//从保单清单带入农户基本信息
						//medicalSettleListDto = getBasicInfoFromPolicyList(medicalSettleListDto,medicalPolicyListDto,request);
						
						boolean newTotalDto = false;
						medicalSettleListDto.setName(name);
						medicalSettleListDto.setRiskcode(riskCode);
						String classCode1 = riskCode.substring(0,2);
						medicalSettleListDto.setOpcode(opCode);
						medicalSettleListDto.setOptime(dateTime);
						medicalSettleListDto.setClasscode(classCode1);
						Double dsuminsured = transformStringToDouble(suminsured);
						medicalSettleListDto.setSuminsured(dsuminsured);
						medicalSettleListDto.setBank(bank);
						medicalSettleListDto.setCreditcard(creditcard);
						medicalSettleListDto.setIdcard(idcard);
						medicalSettleListDto.setMedicalfamily(medicalfamily);
						medicalSettleListDto.setNodetype(nodeType);
						medicalSettleListDto.setValidity("1");
						if(medicalcard == null || "".equals(medicalcard))
						{
							//System.err.println("医保编号为空");
							medicalSettleListDto.setMedicalcard("空编号");
						}
						else
						{
							medicalSettleListDto.setMedicalcard(medicalcard);
						}

						//kindCodeMap.put(fKindCode, fKindCode);
						
						medicalSettleListTotalDto = getDtoFromMedicalSettleListTotalDtoList(medicalSettleListTotalDtoList, medicalSettleListDto);
						if(null==medicalSettleListTotalDto.getIdcard()||"".equals(medicalSettleListTotalDto.getIdcard())){
							medicalSettleListTotalDto.setIdcard(idcard);
							medicalSettleListTotalDto.setRiskcode(riskCode);
							//medicalSettleListTotalDto.setKindcode(fKindCode);
							newTotalDto = true;
						}
					
										
						//损失率必须在规定的损失范围内。
						//double lossRate = transformStringToDouble(strfLostRate);
						//lossRate = MedicalSettleExport.round(lossRate, 2);

						//medicalSettleListDto.setLossrate(lossRate);
						
						//生长期比率必须在规定的范围内。
//						double grownSeason = transformStringToDouble(strfGrowingSeason);
//						if(topLimitOfGrownSeason<grownSeason || lowerLimitOfGrownSeason>=grownSeason){
//							errorMessage += "第"+(i+1)+"行，农户"+fCode+"的生长期比率必须在"+lowerLimitOfGrownSeason+"到"+topLimitOfGrownSeason+"之间！"+enterSymbol;
//							continue;
//						}
//						medicalSettleListDto.setGrowingseason(grownSeason);
						
						//赔付比例必须在规定的范围内。
					
						
						//计算赔款金额
						//medicalPolicyListDto 应该替换成为出险时清单数据。
						//double settleSum = calculateSettleSum(prpCitemKindSchema,settleArea,lossRate,claimRate,medicalPolicyListDto);
						//settleSum = MedicalSettleExport.round(settleSum, 2);
						//medicalSettleListDto.setSettlesum(settleSum);
						Double dsettlesum = transformStringToDouble(settlesum);
						medicalSettleListDto.setSettlesum(dsettlesum);
						
						if(medicalSettleListTotalDto.getSettlesum()==0)
							medicalSettleListTotalDto.setSettlesum(dsettlesum);
						else medicalSettleListTotalDto.setSettlesum(medicalSettleListTotalDto.getSettlesum()+dsettlesum);
						
						//存入电话号码和备注。
						//medicalSettleListDto.setPhone(fPhone);
						//medicalSettleListDto.setRemark(fRemark);
						
						medicalSettleListDtoList.add(medicalSettleListDto);
						if(newTotalDto)
							medicalSettleListTotalDtoList.add(medicalSettleListTotalDto);
						

						//与保单最新清单进行总亩数和总金额的校验。
						//checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,medicalPolicyListDto,true,enterSymbol);
						//与出险时清单进行总亩数和总金额的校验。
//						checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,medicalPolicyListDto,false,enterSymbol);
						//MedicalpolicylistDto damageDateMedicalPolicyListDto = getDamageDateMedicalPolicyListDto(medicalPolicyListDto, strDamageDate, strDamageHour, policyNo, kindCode, fCode, riskCode);
						//checkSumAreaAndSumAmount(errorMessage,medicalSettleListTotalDto,damageDateMedicalPolicyListDto,false,enterSymbol);
						
						//对于案后重开的案件，如果理赔面积小于0，增加与本案之前的理赔清单的总金额和面积校验。
					}
				}
				//errorMessage = checkKindCodeType(errorMessage,kindCodeMap);
				//errorMessage = checkClaimRate(errorMessage,claimRateMap);
			
			resultMap.put("medicalSettleListDtoList", medicalSettleListDtoList);
			resultMap.put("errorMessage", errorMessage);
			workbook.close();
		}catch (BiffException e){
			e.printStackTrace();
		//	workbook.close();
			return null;
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if (workbook!=null)
				workbook.close();
		}
		return resultMap;
	}
	
	public static String trimAllSpace(String str) {
		//return str == null ? str : str.replaceAll("^[\\s　]*|[\\s　]*$", "");  
		return str == null ? str : str.replaceAll("^[\\s　]*|，。？：；‘’！“”—……、|[\\s　]*$", "");  
	}
	private String getKindCodeByCName(String cName){
		String kindCode = "";
		String sqlCondition = " kindCName like '"+cName+"' ";
		BLPrpDkind blPrpDkind = new BLPrpDkind();
		try {
			blPrpDkind.query(sqlCondition);
			if(1==blPrpDkind.getSize())
				kindCode = blPrpDkind.getArr(0).getKindCode();
			else throw new Exception("无法找到 "+cName+" 对应的险别代码，请检查！");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kindCode;
	}
	//根据节点类型判断是否是理算环节，非理算环节不涉及到案后重开。如果是理算环节，再根据立案号和保单号查询理算书表，如果已经存在理算书，则表明现在是在做案后重开。
	private boolean isReopenCase(String registNo, String policyNo, String nodeType, String compensateNo){
		boolean isReopen = false;
		if(UIClaimGetSettleListFacade.nodeList[2].equals(nodeType)){
			BLPrpLcompensate blPrpLcompensate = new BLPrpLcompensate();
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			String sqlClaimCondition = " registNo like '"+registNo +"' and policyNo like '"+policyNo+"' ";
			try {
				Collection collectionPrpLclaim = blPrpLclaimFacade.findByConditions(sqlClaimCondition);
				if(null != collectionPrpLclaim && collectionPrpLclaim.size()==1){
					String claimNo = ((PrpLclaimDto)collectionPrpLclaim.toArray()[0]).getClaimNo();
					BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
					String sqlCondition = " claimNo like '"+claimNo +"' and policyNo like '"+policyNo+"' ";
					if(null!=compensateNo && !"".equals(compensateNo))
						sqlCondition += " and compensateNo not like '"+compensateNo+"' ";
					blPrpLcompensate.query(sqlCondition);
					if( blPrpLcompensate.getSize()>0)
						isReopen = true;
				}
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isReopen;
	}
	//将字符串型数据转化证浮点型数据。
	private double transformStringToDouble(String stringValue){
		double doubleValue = 0.0;
		if(null!=stringValue && !"".equals(stringValue)){
			stringValue = trimAllSpace(stringValue);
			doubleValue = Double.parseDouble(stringValue);
		}
		return doubleValue;
	}

	//根据保单号，险种代码，险别代码获取一条标的子险信息。可为主险，也可为附加险。
	private PrpCitemKindSchema getPrpCitemKindSchema(String policyNo, String riskCode){
		PrpCitemKindSchema prpCitemKindSchema = null;
		try {
			if(null!=riskCode && !"".equals(riskCode)){
				BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
				blPrpCitemKind.getData(policyNo);
				Collection prpCitemKindSchemaes = blPrpCitemKind.getSchemas();
				if(null!=prpCitemKindSchemaes && prpCitemKindSchemaes.size()>0){
					Iterator it = prpCitemKindSchemaes.iterator();
					String riskCodeTemp = "";
					//String kindCodeTemp = "";
					while(it.hasNext()){
						PrpCitemKindSchema prpCitemKindSchemaTemp = (PrpCitemKindSchema)it.next();
						riskCodeTemp = prpCitemKindSchemaTemp.getRiskCode();
						//kindCodeTemp = prpCitemKindSchemaTemp.getKindCode();
						if(riskCode.equals(riskCodeTemp)){
							prpCitemKindSchema = prpCitemKindSchemaTemp;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prpCitemKindSchema;
	}
	/**
	//根据规则计算出赔偿金额。
	private double calculateSettleSum(PrpCitemKindSchema prpCitemKindSchema){
		double settleSum = 0.0;
		String riskCode = prpCitemKindSchema.getRiskCode();
		double lowerLimitOfPartialLoss = 0.3;
		if(0!=transformStringToDouble(prpCitemKindSchema.getTriggerPoint()));//起赔点
			lowerLimitOfPartialLoss = transformStringToDouble(prpCitemKindSchema.getTriggerPoint())/100;
		double topLimitOfPartialLoss = 0.8;
		if(0!=transformStringToDouble(prpCitemKindSchema.getTotalLossRatio()))
				topLimitOfPartialLoss = transformStringToDouble(prpCitemKindSchema.getTotalLossRatio())/100;//全损起点
		double deductibleRate = 0.15;			
		//白术保险免赔率默认值为0，按照实际免赔率赔付！
		if("3143".equals(riskCode) || "3139".equals(riskCode) || "3142".equals(riskCode) || "3146".equals(riskCode) || "3186".equals(riskCode) || "3144".equals(riskCode))
			//3143 白术 3142 桔梗，3146 菊花，3186 蓝莓，3139 石榴，3144 樱桃 
			deductibleRate = 0.00;	//免赔率
		if(0!=transformStringToDouble(prpCitemKindSchema.getDeductibleRate()))
			deductibleRate = transformStringToDouble(prpCitemKindSchema.getDeductibleRate())/100;//免赔率
		if("3150".equals(riskCode))
		{
			deductibleRate = 0.00;
			lowerLimitOfPartialLoss = 0.3;
			topLimitOfPartialLoss = 0.8;
		}
		double amount = transformStringToDouble(prpCitemKindSchema.getUnitAmount());//单位保额
		lossRate = lossRate/100;//把百分比的损失率80 换成小数0.8
		//中央政策性险种理赔计算公式与非政策性险种不同，分开计算
		if("3139".equals(riskCode) || "3186".equals(riskCode) || "3144".equals(riskCode)){
			if(lowerLimitOfPartialLoss<=lossRate && lossRate<topLimitOfPartialLoss)
			//对于部分损失的（如30%<=损失率<80%）的按部分损失的公式计算：单位保额*赔付面积*赔付比例*损失率*(1-免赔率）
				settleSum = amount*settleArea*claimRate*lossRate*(1-deductibleRate);
			else if(lossRate>=topLimitOfPartialLoss)
			//对于全损（如损失率>=80%）的按全损公式计算：单位保额*赔付面积*赔付比例
				settleSum = amount*settleArea*claimRate;
		}else if("3149".equals(riskCode)){//森林保险计算公式与其他险种均不同，需要单独计算
			if(lowerLimitOfPartialLoss<=lossRate && lossRate<topLimitOfPartialLoss){
				//保险林木发生保险事故，损失程度在10%（含10%）至90%时，保险人按以下公式计算赔偿金额： 
				if(settleArea*0.1<10)
				//分户损失面积  *  10%  <  10亩: 
			    //赔偿金额  =  每亩保险金额  ×  损失程度  ×  损失面积  ×（1－绝对免赔率） 
					settleSum = amount * lossRate * settleArea * (1-deductibleRate);
				else
				//分户损失面积  *  10%  >=  10亩: 
				//赔偿金额  =  每亩保险金额  ×  损失程度  ×  （损失面积-10）
					settleSum = amount * lossRate * (settleArea-10);
			}else if(lossRate>=topLimitOfPartialLoss)
				//保险林木发生保险事故，损失程度在90%（含90%）以上的，保险人按以下公式计算赔偿金额： 
				//赔偿金额  =  每亩保险金额  ×  损失面积
					settleSum = amount * settleArea;

		}else{
			if(lowerLimitOfPartialLoss<=lossRate && lossRate<topLimitOfPartialLoss)
			//对于部分损失的（如30%<=损失率<80%）的按部分损失的公式计算：单位保额*赔付面积*赔付比例*（损失率-免赔率）
				settleSum = amount*settleArea*claimRate*(lossRate-deductibleRate);
			else if(lossRate>=topLimitOfPartialLoss)
			//对于全损（如损失率>=80%）的按全损公式计算：单位保额*赔付面积*赔付比例
				settleSum = amount*settleArea*claimRate;
		}
		return settleSum;
	}
	**/
	//根据
	private List getAllReopenSettleCodeList(String registNo, String policyNo, String compensateNo){
		List reopenSettleCodeList = new ArrayList();
		try {
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			String sqlClaimCondition = " registNo like '"+registNo +"' and policyNo like '"+policyNo+"' ";
			Collection collectionPrpLclaim = blPrpLclaimFacade.findByConditions(sqlClaimCondition);
			if(null != collectionPrpLclaim && collectionPrpLclaim.size()==1){
				String claimNo = ((PrpLclaimDto)collectionPrpLclaim.toArray()[0]).getClaimNo();
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				String sqlCondition = " claimNo like '"+claimNo +"' and policyNo like '"+policyNo+"' ";
				if(null!=compensateNo && !"".equals(compensateNo))
					sqlCondition += " and compensateNo not like '"+compensateNo+"' ";
				Collection collectionPrpLcompensate = blPrpLcompensateFacade.findByConditions(sqlCondition);
				if(null != collectionPrpLcompensate && collectionPrpLcompensate.size()>0){
					Iterator it = collectionPrpLcompensate.iterator();
					List prpLcompensateNoList = new ArrayList();
					while(it.hasNext()){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)it.next();
						prpLcompensateNoList.add(prpLcompensateDto.getCompensateNo());
					}
					if(null!=prpLcompensateNoList && prpLcompensateNoList.size()>0){
						reopenSettleCodeList = getSettleCodeListByCompensateNo(prpLcompensateNoList);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reopenSettleCodeList;
	}
	//
	private List getSettleCodeListByCompensateNo(List prpLcompensateNoList){
		List reopenSettleCodeList = new ArrayList();
		if(null!=prpLcompensateNoList && prpLcompensateNoList.size()>0){
			try {
				String strAllPrpLcompensateNo = "";
				for(int i = 0;i<prpLcompensateNoList.size();i++){
					if(i==0)
						strAllPrpLcompensateNo = "'"+prpLcompensateNoList.get(i)+"'";
					else strAllPrpLcompensateNo += ",'"+prpLcompensateNoList.get(i)+"'";
				}
				String sqlCondition = " validity like '2' and compensateNo in ("+strAllPrpLcompensateNo+")";
				BLSettlemainlistFacadeForMedical blSettleMainListFacade = new BLSettlemainlistFacadeForMedical();
				Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
				if(null!=collectionSettleMainList && collectionSettleMainList.size()>0){
					Iterator it = collectionSettleMainList.iterator();
					while(it.hasNext()){
						SettlemainlistDto settleMainListDto = (SettlemainlistDto)it.next();
						reopenSettleCodeList.add(settleMainListDto.getSettlelistcode());
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reopenSettleCodeList;
	}
	/**
	private StringBuffer checkReopenCaseSettleList(StringBuffer errorMessage, MedicalsettlelistDto medicalSettleListTotalDto, List settleCodeList, String enterSymbol){
		if(null!=settleCodeList && settleCodeList.size()>0){
			String riskCode = medicalSettleListTotalDto.getRiskcode();
			String kindCode = medicalSettleListTotalDto.getKindcode();
			String fCode = medicalSettleListTotalDto.getFcode();
			String sqlCondition = "";
			String allSettleCode = "";
			for(int i=0;i<settleCodeList.size();i++){
				if(i==0)
					allSettleCode = "'"+settleCodeList.get(i)+"'";
				else allSettleCode += ",'"+settleCodeList.get(i)+"'";
			}
			sqlCondition = " fCode like '"+fCode+"' and riskCode like '"+riskCode+"' and kindCode like '"+kindCode+"' and validity like '1' and nodeType like 'compe' and settleListCode in ("+allSettleCode+")";
			try {
				BLMedicalsettlelistFacade blMedicalSettleListFacade = new BLMedicalsettlelistFacade();
				Collection collectionMedicalSettleList = blMedicalSettleListFacade.findByConditions(sqlCondition);
				double settleArea = medicalSettleListTotalDto.getSettlearea();
				double settleAreaOld = 0.0;
				double settleAmount = medicalSettleListTotalDto.getSettlesum();
				double settleAmountOld = 0.0;
				if(null!= collectionMedicalSettleList && collectionMedicalSettleList.size()>0){
					MedicalsettlelistDto medicalSettleListDto = new MedicalsettlelistDto();
					Iterator it = collectionMedicalSettleList.iterator();
					while(it.hasNext()){
						medicalSettleListDto = (MedicalsettlelistDto)it.next();
						settleAreaOld += medicalSettleListDto.getSettlearea();
						settleAmountOld += medicalSettleListDto.getSettlesum();
					}
				}
				if(Math.abs(settleAreaOld)<Math.abs(settleArea))
					errorMessage.append("农户："+fCode+"的案后重开的理赔面积大于之前所有理算书面积之和。"+enterSymbol);
				if(Math.abs(settleAmountOld)<Math.abs(settleAmount))
					errorMessage.append("农户："+fCode+"的案后重开的理赔金额大于之前所有理算书金额之和。"+enterSymbol);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return errorMessage;
	}
	**/
	private MedicalsettlelistDto getDtoFromMedicalSettleListTotalDtoList(List medicalSettleListTotalDtoList,MedicalsettlelistDto medicalSettleListDto){
		MedicalsettlelistDto medicalSettleListTotalDto = new MedicalsettlelistDto();
		if(null!=medicalSettleListTotalDtoList && medicalSettleListTotalDtoList.size()>0){
			String idcard = medicalSettleListDto.getIdcard();
			MedicalsettlelistDto medicalSettleListTotalDtoTemp = new MedicalsettlelistDto();
			for(int i=0;i<medicalSettleListTotalDtoList.size();i++){
				medicalSettleListTotalDtoTemp = (MedicalsettlelistDto)medicalSettleListTotalDtoList.get(i);
				if(idcard.equals(medicalSettleListTotalDtoTemp.getIdcard())){
					medicalSettleListTotalDto = medicalSettleListTotalDtoTemp;
					break;
				}
			}
		}
		return medicalSettleListTotalDto;
	}
	/**
	private StringBuffer checkKindCodeType(StringBuffer errorMessage, Map kindCodeMap){
		if(null==kindCodeMap)
			errorMessage.append("险别代码录入为空，请检查！");
		else if(kindCodeMap.size()>1)
			errorMessage.append("一张理赔清单只能录入一个险别！请检查险别代码！");
		return errorMessage;
	}
	private StringBuffer checkClaimRate(StringBuffer errorMessage, Map cliamRateMap){
		if(null==cliamRateMap)
			errorMessage.append("赔付比例为空，请检查！");
		else if(cliamRateMap.size()>1)
			errorMessage.append("一张理赔清单只能录入一个赔付比例！请检查赔付比例！");
		return errorMessage;
	}
	**/
	
	/** *//**
	* 提供精确的小数位截断处理。
	* @param v 需要截断的数字
	* @param scale 小数点后保留几位
	* @return 截断后的结果
	*/
	public static double roundDown(double v,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one,scale,BigDecimal.ROUND_DOWN).doubleValue();
	}
	//根据报案号查询出险日期。
	private String getDamageDateByRegistNo(String registNo){
		String strDamageDate = "";
		try {
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(null==prpLregistDto)
				return null;
			else{
				SimpleDateFormat dateToStr = new SimpleDateFormat ("yyyy-MM-dd");
		        // parse date to format String
				strDamageDate = dateToStr.format(prpLregistDto.getDamageStartDate());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDamageDate;
	}
	//根据报案号查询出险小时。
	private String getDamageHourByRegistNo(String registNo){
		String strDamageHour = "";
		try {
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(null==prpLregistDto)
				return null;
			else{
				strDamageHour = prpLregistDto.getDamageStartHour();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDamageHour;
	}
	/**
	private MedicalpolicylistDto getDamageDateMedicalPolicyListDto(MedicalpolicylistDto medicalPolicyListDto, String strDamageDate, String strDamageHour, String policyNo, String kindCode, String fCode, String riskCode){
		MedicalpolicylistDto medicalPolicyListTempDto = medicalPolicyListDto;
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		try {
			medicalPolicyListTempDto = endorseViewHelper.findForEndorPlantinpolicylistBefore(medicalPolicyListTempDto,riskCode,kindCode,policyNo,strDamageDate,strDamageHour);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicalPolicyListTempDto;
	}
	**/
	//保存理赔清单数据到临时表中
	private boolean saveToTempTable(List medicalSettleList, String registNo, HttpServletRequest request)throws Exception{
		boolean saveResult = false;
		if(null!=medicalSettleList && medicalSettleList.size()>0){
			DBManager dbManager = new DBManager();
			String timeStamp = generateTimeStamp();
			try {
				dbManager.open("JKXDataSource");
				dbManager.beginTransaction();
				MedicalsettlelistDto medicalSettleListDto = null;
				BLMedicalsettlelisttempAction blMedicalSettleListTempAction = new BLMedicalsettlelisttempAction();
				for(int index=0;index<medicalSettleList.size();index++){
					medicalSettleListDto = (MedicalsettlelistDto)medicalSettleList.get(index);
					MedicalsettlelisttempDto medicalSettleListTempDto = medicalSettleListDto.evaluate(registNo, index, timeStamp);
					blMedicalSettleListTempAction.insert(dbManager, medicalSettleListTempDto);				
				}
				dbManager.commitTransaction();
				saveResult = true;
				request.setAttribute("timeStamp", timeStamp);
			}catch (Exception e) {
				dbManager.rollbackTransaction();
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dbManager.close();
			}
		}
		return saveResult;
	}
	//根据报案号删除理赔清单临时表中的对应数据。
	private void deletePrevousTempData(String registNo, String timeStamp)throws Exception{
		String sqlCondition = " registCode = '"+registNo+"' and stringTimeStamp = '"+timeStamp+"' ";
		BLMedicalsettlelisttempFacade blMedicalSettleListTempFacade = new BLMedicalsettlelisttempFacade();
		blMedicalSettleListTempFacade.deleteByConditions(sqlCondition);
	}
	private String generateTimeStamp(){
		String timeStamp = "";
		Date currentTime = new Date();
		timeStamp=new SimpleDateFormat("yyMMddHHmmss").format(currentTime);
		return timeStamp;
	}	
//	private String checkNumber(String string){
//		String result = "";
//		^[0-9]*$
//		return result;
//	}

	
	
	//根据保单号获取第一条标的子险信息。可为主险，也可为附加险。
	private PrpCitemKindSchema getFirstPrpCitemKindSchema(String policyNo){
		PrpCitemKindSchema prpCitemKindSchema = null;
		try {
			if(null!=policyNo && !"".equals(policyNo) ){
				BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
				blPrpCitemKind.getData(policyNo);
				if(null != blPrpCitemKind && blPrpCitemKind.getSize()>0){
					prpCitemKindSchema = blPrpCitemKind.getArr(0);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prpCitemKindSchema;
	}

}
