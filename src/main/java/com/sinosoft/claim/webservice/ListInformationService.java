package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.gyic.claim.bl.facade.BLHousepolicylistFacade;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLZh03PolicyListFacade;
import com.gyic.claim.dto.domain.HousepolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.account.blsvr.BLPrpLcompensatefyFacade;
import com.sinosoft.claim.bl.action.custom.BLClaimAction;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLlossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistBase;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.dto.CaseClaimListMainInfo;
import com.sinosoft.claim.webservice.dto.HouseCaseListInfo;
import com.sinosoft.claim.webservice.dto.HouseCaseListMainInfo;
import com.sinosoft.claim.webservice.dto.LinkmanListMainInfo;
import com.sinosoft.claim.webservice.dto.PaymentListMainInfo;
import com.sinosoft.claim.webservice.dto.PlantingCaseListMainInfo;
import com.sinosoft.claim.webservice.dto.ReturnListDtoMainInfo;
import com.sinosoft.claim.webservice.dto.ReturnListDtoQuery;
import com.sinosoft.claim.webservice.dto.ReturnVisitInfo;
import com.sinosoft.claim.webservice.dto.ZH03CaseListMainInfo;
import com.sinosoft.nyx.blsvr.BLHousePolicyList;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.blsvr.BLZH03PolicyList;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsured;
import com.sinosoft.prpall.blsvr.lp.BLPrpLcompensate;
import com.sinosoft.prpall.schema.PrpCinsuredSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 待回访清单接口和案件回访清单信息接口
 * @author Administrator
 *
 */
public class ListInformationService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 待回访清单接口
	 * @param returnListDtoQuery
	 * @return
	 */
	public ReturnListDtoMainInfo getReturnList (ReturnListDtoQuery returnListDtoQuery){
		long serial = System.currentTimeMillis();
		logger.log("待回访清单接口", 1,serial, returnListDtoQuery);
		ReturnListDtoMainInfo returnListDtoMainInfo= null;
		try {
			//校验数据
			if(isEmpty(returnListDtoQuery.getEndCaseEndDate())){throw new Exception("结案时间截止日期为必传参数，请检查");}
			if(returnListDtoQuery.getPageNo()<0){throw new Exception("当前页码传入有误，请检查");}
			if(returnListDtoQuery.getRecordPerPage()<0){throw new Exception("每页条数传入有误，请检查");}
			if(returnListDtoQuery.getPageNo()==0){returnListDtoQuery.setPageNo(1);}
			if(returnListDtoQuery.getRecordPerPage()==0){returnListDtoQuery.setRecordPerPage(20);}
			
			ListInformationServiceHelper listInformationServiceHelper = new ListInformationServiceHelper();
			returnListDtoMainInfo = listInformationServiceHelper.getReturnList(returnListDtoQuery);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("待回访清单接口",serial, e);
		}
		logger.log("待回访清单接口", 0,serial, returnListDtoMainInfo);
		return returnListDtoMainInfo;
		
	}
	/**
	 * 农村住房回访清单
	 * @param policyNo
	 * @param registNo
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 */
	public HouseCaseListMainInfo getHousePolicyList (String policyNo,String registNo,int pageNo ,int recordPerPage){
		long serial = System.currentTimeMillis();
		logger.log("农村住房回访清单", 1,serial, "[policyNo:"+policyNo+"][registNo:"+registNo+"][pageNo:"+pageNo+"][recordPerPage:"+recordPerPage+"]");
		HouseCaseListMainInfo houseCaseListMainInfo  = null;
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			if(pageNo<0){throw new Exception("当前页码有误，请检查！");}
			if(recordPerPage<0){throw new Exception("每页条数有误，请检查！");}
			if(pageNo == 0){pageNo = 1;}
			if(recordPerPage == 0){recordPerPage = 20;}
			ListInformationServiceHelper listInformationServiceHelper = new ListInformationServiceHelper();
			String conditions = "registno = '"+registNo+"' and nodetype = 'compe'";
			conditions += StringConvert.convertString(" policyNo", policyNo,"=");
			BLPrplcompensatehouseFacade blPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
			ArrayList<PrplcompensatehouseDto> prplcompensatehouseList =  (ArrayList<PrplcompensatehouseDto>) blPrplcompensatehouseFacade.findByConditions(conditions);
			BLInsuremainlistFacade blInsuremainlistFacade = new BLInsuremainlistFacade();
			BLHousepolicylistFacade blHousepolicylistFacade = new BLHousepolicylistFacade();
			String conditions2 = "";
			String conditions3 = "";
			ArrayList<String> sqlList = new  ArrayList<String>();
			BLPrpLcompensateFacade  blPrpLcompensateFacade = new BLPrpLcompensateFacade();
			for(PrplcompensatehouseDto prplcompensatehouseDto:prplcompensatehouseList){
				if(prplcompensatehouseDto.getCompensateno()==null||"".equals(prplcompensatehouseDto.getCompensateno())){
					continue;
				}
				PrpLcompensateDto prpLcompensateDto = blPrpLcompensateFacade.findByPrimaryKey(prplcompensatehouseDto.getCompensateno());
				if(prpLcompensateDto == null||prpLcompensateDto.getUnderWriteFlag()==null||(!"1".equals(prpLcompensateDto.getUnderWriteFlag())&&!"3".equals(prpLcompensateDto.getUnderWriteFlag()))){
					continue;
				}
				conditions2 = "policyno = '"+prplcompensatehouseDto.getPolicyno()+"' and validity = '2'";
				ArrayList<InsuremainlistDto>  insuremainlistDtoList = (ArrayList<InsuremainlistDto>) blInsuremainlistFacade.findByConditions(conditions2);
				if(insuremainlistDtoList!=null&&insuremainlistDtoList.size()>0){
					InsuremainlistDto insuremainlistDto = insuremainlistDtoList.get(0);
					String inusreListCode = insuremainlistDto.getInusrelistcode();
					String idCard = prplcompensatehouseDto.getIdcard();
					String sql = "(inusrelistcode = '"+inusreListCode+"' and idcard = '"+idCard+"')";
					if(!sqlList.contains(sql)){
						sqlList.add(sql);
					}
				}
			}
			if(sqlList.size()>0){
				conditions3 += " 1 = 1 and validity = '1' and (";
				for(int i = 0;i<sqlList.size();i++){
					if(i == sqlList.size()-1){
						conditions3 += sqlList.get(i);
					}else{
						conditions3 += sqlList.get(i)+" or ";
					}
				}
				conditions3 += " )";
			}else{
				conditions3 = " 1=2 ";
			}
			
			
			BLHousePolicyList blHousePolicyList = new BLHousePolicyList();
			ArrayList arrayList  = (ArrayList) blHousePolicyList.query(conditions3, pageNo, recordPerPage);
			
			int intCount = blHousePolicyList.getCount(conditions3);
			int intPageCount = 0;
			if(intCount>0)
			{
			  intPageCount = (intCount-1)/recordPerPage+1;
			}
			else
			{
			  intCount= 0;
			  intPageCount = 0;
			  pageNo = 0;
			}
			HouseCaseListInfo[] houseCaseListInfos = new HouseCaseListInfo[arrayList.size()];
			for(int i = 0;i<arrayList.size();i++){
				HouseCaseListInfo houseCaseListInfo = new HouseCaseListInfo();
				ArrayList list =  (ArrayList) arrayList.get(i);
				int index = 0;
				houseCaseListInfo.setName(String.valueOf(list.get(index++)));
				houseCaseListInfo.setIdCard(String.valueOf(list.get(index++)));
				houseCaseListInfo.setKindCode(String.valueOf(list.get(index++)));
				houseCaseListInfo.setAddress(String.valueOf(list.get(index++)));
				houseCaseListInfo.setFloor(String.valueOf(list.get(index++)));
				houseCaseListInfo.setBuildIngNumber(String.valueOf(list.get(index++)));
				houseCaseListInfo.setZhuanNumber(String.valueOf(list.get(index++)));
				houseCaseListInfo.setWaNumber(String.valueOf(list.get(index++)));
				houseCaseListInfo.setKitchenNumber(String.valueOf(list.get(index++)));
				houseCaseListInfo.setSumAmount(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setSumpremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setRate(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setFpremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setProvincepremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setCitypremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setTownpremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				houseCaseListInfo.setOtherpremium(""+Double.parseDouble(String.valueOf(list.get(index++))));
				Date startDate = (Date)list.get(index++);
				Date endDate = (Date)list.get(index++);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				houseCaseListInfo.setStartDate(sdf.format(startDate));
				houseCaseListInfo.setEndDate(sdf.format(endDate));
				houseCaseListInfo.setPhone(String.valueOf(list.get(index++)));
				houseCaseListInfo.setRemark(String.valueOf(list.get(index++)));
				houseCaseListInfos[i] = houseCaseListInfo;
			}
			
			houseCaseListMainInfo = new HouseCaseListMainInfo();
			houseCaseListMainInfo.setHouseCaseListInfoList(houseCaseListInfos);
			houseCaseListMainInfo.setPageNo(pageNo);
			houseCaseListMainInfo.setRecordPerPage(recordPerPage);
			houseCaseListMainInfo.setTotalCount(intCount);
			houseCaseListMainInfo.setTotalPage(intPageCount);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("农村住房回访清单",serial,e);
		}
		logger.log("农村住房回访清单", 0,serial, houseCaseListMainInfo);
		return houseCaseListMainInfo;
		
	}
	/**
	 * 农家福回访清单
	 */
	public ZH03CaseListMainInfo getZH03CaseList (String policyNo,String registNo,int pageNo ,int recordPerPage){
		long serial = System.currentTimeMillis();
		logger.log("农家福回访清单", 1,serial, "[policyNo:"+policyNo+"][registNo:"+registNo+"][pageNo:"+pageNo+"][recordPerPage:"+recordPerPage+"]");
		ZH03CaseListMainInfo zh03CaseListMainInfo = null;
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			if(pageNo<0){throw new Exception("当前页码有误，请检查！");}
			if(recordPerPage<0){throw new Exception("每页条数有误，请检查！");}
			if(pageNo == 0){pageNo = 1;}
			if(recordPerPage == 0){recordPerPage = 20;}
			String conditions = "registno = '"+registNo+"'";
			conditions += StringConvert.convertString("policyNo", policyNo,"=");
			
			
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			ArrayList<PrpLclaimDto> prplclaimdDtoArrayList = (ArrayList<PrpLclaimDto>) blPrpLclaimFacade.findByConditions(conditions);
			BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
			BLInsuremainlistFacade blInsuremainlistFacade = new BLInsuremainlistFacade();
			BLPrpLlossFacade blPrpLlossFacade = new BLPrpLlossFacade();
			ArrayList<PrpLcompensateDto> prpLcompensateDtoArrayList = null;
			ArrayList<String> conditionsArrayList = new ArrayList<String>();
			for(PrpLclaimDto prpLclaimDto:prplclaimdDtoArrayList){
				conditions = "claimno = '"+prpLclaimDto.getClaimNo()+"' and (underwriteflag ='1' or underwriteflag ='3')";
				prpLcompensateDtoArrayList = (ArrayList<PrpLcompensateDto>) blPrpLcompensateFacade.findByConditions(conditions);
				for(PrpLcompensateDto prpLcompensateDto:prpLcompensateDtoArrayList){
					conditions = "compensateno = '"+prpLcompensateDto.getCompensateNo()+"'";
					ArrayList<PrpLlossDto> prpllossDtolist = (ArrayList<PrpLlossDto>) blPrpLlossFacade.findByConditions(conditions);
					for(PrpLlossDto prpLlossDto:prpllossDtolist){
						conditions = "policyno = '"+prpLlossDto.getPolicyNo()+"' and validity = '2'";
						ArrayList<InsuremainlistDto> insuremainlistDtoArrayList =  (ArrayList<InsuremainlistDto>) blInsuremainlistFacade.findByConditions(conditions);
						if(insuremainlistDtoArrayList!=null&&insuremainlistDtoArrayList.size()>0){
							String sql = "( t1.inusrelistcode = '"+insuremainlistDtoArrayList.get(0).getInusrelistcode()+"' "
								+"and t1.familyno = '"+prpLlossDto.getFamilyNoZH()+"' and t1.kindcode='2742001' and t1.personno='1' )";
							if(!conditionsArrayList.contains(sql)){
								conditionsArrayList.add(sql);
							}
						}
					}
				}
			}
			String strWhere = "";
			if(conditionsArrayList!=null&&conditionsArrayList.size()>0){
				strWhere += " 1=1  and ( ";
				for(int i = 0;i<conditionsArrayList.size();i++){
					if(i == conditionsArrayList.size()-1){
						strWhere += conditionsArrayList.get(i);
					}else{
						strWhere += conditionsArrayList.get(i)+" or " ;
					}
				}
				strWhere += " ) ";
			}else{
				strWhere += " 1=2 ";
			}
			BLZH03PolicyList blZH03PolicyList = new BLZH03PolicyList();
			Collection arrayListForRelateList = blZH03PolicyList.query(strWhere,pageNo,recordPerPage);
			int intCount = blZH03PolicyList.getCount(strWhere);
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			zh03CaseListMainInfo = helper.transZH03CaseList(arrayListForRelateList, intCount, pageNo, recordPerPage);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("农家福回访清单",serial, e);
		}
		logger.log("农家福回访清单", 0,serial, zh03CaseListMainInfo);
		return zh03CaseListMainInfo;
	}
	/**
	 * 种植业回访清单
	 * @param policyNo
	 * @param registNo
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 */
	public PlantingCaseListMainInfo getPlantingCaseList(String policyNo,String registNo,int pageNo ,int recordPerPage){
		long serial = System.currentTimeMillis();
		logger.log("种植业回访清单", 1,serial, "[policyNo:"+policyNo+"][registNo:"+registNo+"][pageNo:"+pageNo+"][recordPerPage:"+recordPerPage+"]");
		PlantingCaseListMainInfo plantingCaseListMainInfo = null;
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			if(pageNo<0){throw new Exception("当前页码有误，请检查！");}
			if(recordPerPage<0){throw new Exception("每页条数有误，请检查！");}
			if(pageNo == 0){pageNo = 1;}
			if(recordPerPage == 0){recordPerPage = 20;}
			
			String conditions = "registno = '"+registNo+"'";
			conditions += StringConvert.convertString("policyNo", policyNo,"=");
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			ArrayList<PrpLclaimDto> prplclaimdDtoArrayList = (ArrayList<PrpLclaimDto>) blPrpLclaimFacade.findByConditions(conditions);
			BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
			BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
			BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
			BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
			ArrayList<PrpLcompensateDto> prpLcompensateDtoArrayList = null;
			ArrayList<String> conditionsArrayList = new ArrayList<String>();
			for(PrpLclaimDto prpLclaimDto:prplclaimdDtoArrayList){
				conditions = "claimno = '"+prpLclaimDto.getClaimNo()+"'  and (underwriteflag ='1' or underwriteflag ='3')";
				prpLcompensateDtoArrayList = (ArrayList<PrpLcompensateDto>) blPrpLcompensateFacade.findByConditions(conditions);
				for(PrpLcompensateDto prpLcompensateDto:prpLcompensateDtoArrayList){
					conditions = "compensateno = '"+prpLcompensateDto.getCompensateNo()+"'";
					ArrayList<SettlemainlistDto> settlemainlistDtoArrayList = (ArrayList<SettlemainlistDto>) blSettlemainlistFacade.findByConditions(conditions);
					for(SettlemainlistDto settlemainlistDto :settlemainlistDtoArrayList){
						conditions ="settlelistcode = '"+settlemainlistDto.getSettlelistcode()+"'"	;
						String zcFlag = prpLcompensateDto.getBusinessType1();
						if("01".equals(zcFlag)){//中央政策性的
							ArrayList<PlantingsettlelistDto>  plantingsettlelistDtoArrayList=(ArrayList<PlantingsettlelistDto>) blPlantingsettlelistFacade.findByConditions(conditions);
							for(PlantingsettlelistDto plantingsettlelistDto:plantingsettlelistDtoArrayList){
								String sql = "(inusrelistcode = '"+settlemainlistDto.getInusrelistcode()+"' and fcode = '"+plantingsettlelistDto.getFcode()+"' and kindcode = '"+plantingsettlelistDto.getKindcode()+"')";
								if(!conditionsArrayList.contains(sql)){
									conditionsArrayList.add(sql);
								}
							}
						}else{
							ArrayList<Planting31SettleListDto>  planting31SettleListDtoArrayList=(ArrayList<Planting31SettleListDto>) blPlanting31SettleListFacade.findByConditions(conditions);
							for(Planting31SettleListDto planting31SettleListDto:planting31SettleListDtoArrayList){
								String sql = "(inusrelistcode = '"+settlemainlistDto.getInusrelistcode()+"' and fcode = '"+planting31SettleListDto.getFcode()+"' and kindcode = '"+planting31SettleListDto.getKindCode()+"')";
								if(!conditionsArrayList.contains(sql)){
									conditionsArrayList.add(sql);
								}
							}
						}
					}
				}
			}
			String strWhere = "";
			if(conditionsArrayList!=null&&conditionsArrayList.size()>0){
				strWhere += " 1=1 and validity = '1' and ( ";
				for(int i = 0;i<conditionsArrayList.size();i++){
					if(i == conditionsArrayList.size()-1){
						strWhere += conditionsArrayList.get(i);
					}else{
						strWhere += conditionsArrayList.get(i)+" or " ;
					}
				}
				strWhere += " ) ";
			}else{
				strWhere += " 1=2 ";
			}
			BLPlantingPolicyList blPlantingPolicyList = new BLPlantingPolicyList();
			Collection arrayListForRelateList = blPlantingPolicyList.query1(strWhere,pageNo,recordPerPage);
			int intCount = blPlantingPolicyList.getCount(strWhere);
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			plantingCaseListMainInfo = helper.transPlantingCaseList(arrayListForRelateList,intCount,pageNo,recordPerPage);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("种植业回访清单",serial, e);
		}
		logger.log("种植业回访清单", 0,serial, plantingCaseListMainInfo);
		return plantingCaseListMainInfo;
	}
	/**
	 * 理赔信息回访清单
	 * @param registNo
	 * @return
	 */
	public CaseClaimListMainInfo getCaseClaimList (String registNo){
		long serial = System.currentTimeMillis();
		logger.log("理赔信息回访清单", 1,serial, "[registNo:"+registNo+"]");
		CaseClaimListMainInfo caseClaimListMainInfo = null;
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			String endCaseTime = "";
			String houseIdCard = "";
			String zh03FamilyNo = "";
			String context = "";
			
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo.trim());
			String conditions = " registno = '"+registNo.trim()+"'order by endcasedate desc";
			ArrayList<PrpLclaimDto> prpLclaimDtoList = (ArrayList<PrpLclaimDto>) blPrpLclaimFacade.findByConditions(conditions);
			PrpLclaimDto prpLclaimDto = null;
			//获取结案时间
			if(prpLclaimDtoList!=null&&prpLclaimDtoList.size()>0){
				endCaseTime = prpLclaimDtoList.get(0).getEndCaseDate().toString(DateTime.YEAR_TO_SECOND);
			}
			//获取农家福或农房的验证信息
			if("ZH03".equals(prpLregistDto.getRiskCode())){
				zh03FamilyNo = prpLregistDto.getRemark();
			}else if("0310".equals(prpLregistDto.getRiskCode())||"0312".equals(prpLregistDto.getRiskCode())){
				BLPrplcompensatehouseFacade blPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
				String conditions2 = "registno = '"+prpLregistDto.getRegistNo()+"' order by compensateno";
				ArrayList<PrplcompensatehouseDto> prplcompensatehouseDtoList = (ArrayList<PrplcompensatehouseDto>) blPrplcompensatehouseFacade.findByConditions(conditions2);
				if(prplcompensatehouseDtoList!=null&&prplcompensatehouseDtoList.size()>0){
					houseIdCard = prplcompensatehouseDtoList.get(0).getIdcard();
				}
			}
			//获取出险摘要
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			String conditions3 = "registno = '"+prpLregistDto.getRegistNo()+"' and texttype = '1' order by lineno";
			ArrayList prpLregistTextList = (ArrayList) blPrpLregistTextFacade.findByConditions(conditions3);
			if(prpLregistTextList!=null&&prpLregistTextList.size()>0){
				for(int m = 0;m<prpLregistTextList.size();m++){
					PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) prpLregistTextList.get(m);
					context += prpLregistTextDto.getContext();
				}
			}
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			caseClaimListMainInfo = helper.transCaseClaimList(prpLregistDto,endCaseTime,houseIdCard,zh03FamilyNo,context);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("理赔信息回访清单",serial, e);
		}
		logger.log("理赔信息回访清单", 0,serial, caseClaimListMainInfo);
		return  caseClaimListMainInfo;
	}
	/**
	 * 支付信息回访清单
	 * @param registNo
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 */
	public PaymentListMainInfo getPaymentList (String registNo,int pageNo ,int recordPerPage){
		long serial = System.currentTimeMillis();
		logger.log("支付信息回访清单", 1,serial, "[registNo:"+registNo+"][pageNo:"+pageNo+"][recordPerPage:"+recordPerPage+"]");
		PaymentListMainInfo paymentListMainInfo = null;
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			if(pageNo<0){throw new Exception("当前页码有误，请检查！");}
			if(recordPerPage<0){throw new Exception("每页条数有误，请检查！");}
			if(pageNo == 0){pageNo = 1;}
			if(recordPerPage == 0){recordPerPage = 20;}
			
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			int intPerilCount = 0;
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo.trim());
			intPerilCount = helper.getDamageTime(prpLregistDto.getPolicyNo());
			
			paymentListMainInfo = helper.getPaymentList(registNo.trim(),pageNo,recordPerPage,intPerilCount,prpLregistDto.getRiskCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("支付信息回访清单",serial, e);
		}
		logger.log("支付信息回访清单", 0,serial, paymentListMainInfo);
		return paymentListMainInfo;
	}

	/**
	 * 联系人信息回访清单
	 * @param registNo 案件号
	 * @return
	 */
	public LinkmanListMainInfo getLinkmanList (String registNo){
		long serial = System.currentTimeMillis();
		logger.log("联系人信息回访清单", 1,serial, "[registNo:"+registNo+"]");
		LinkmanListMainInfo linkmanListMainInfo = null;
		try {
			linkmanListMainInfo = getLinkmanInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("联系人信息回访清单",serial, e);
		}
		logger.log("联系人信息回访清单", 0,serial, linkmanListMainInfo);
		return linkmanListMainInfo;
	}
	/**
	 * 已回访状态返回接口
	 * @param registNo
	 * @param returnVisitFlag
	 * @return
	 */
	public String saveReturnVisitFlag (String registNo,String returnVisitFlag){
		long serial = System.currentTimeMillis();
		logger.log("已回访状态返回接口", 1,serial, "[registNo:"+registNo+"][returnVisitFlag:"+returnVisitFlag+"]");
		String flag = "0";
		try {
			if(isEmpty(registNo)){throw new Exception("案件号是必传参数，请检查！");}
			if(isEmpty(returnVisitFlag)){throw new Exception("案件回访状态是必传参数，请检查！");}
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			flag = helper.saveReturnVisitFlag(registNo.trim(),returnVisitFlag);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("已回访状态返回接口",serial, e);
		}
		logger.log("已回访状态返回接口", 0,serial, "[flag:"+flag+"]");
		return flag;
	}
	
	/**
	 * 回访信息保存接口
	 * @param returnVisitInfo
	 * @return 成功1，失败0
	 */
	public String saveReturnVisit (ReturnVisitInfo returnVisitInfo){
		long serial = System.currentTimeMillis();
		logger.log("回访信息保存接口", 1,serial, returnVisitInfo);
		String flag = "0";
		try {
			ListInformationServiceHelper helper = new ListInformationServiceHelper();
			helper.checkSaveReturnVisitInfo(returnVisitInfo);
			flag = helper.saveReturnVisit(returnVisitInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("回访信息保存接口",serial, e);
		}
		logger.log("回访信息保存接口", 0,serial, "[flag:"+flag+"]");
		return flag;
		
	}
	
	private LinkmanListMainInfo getLinkmanInfo(String registNo) throws Exception{
		DBManager dbManager = new DBManager();
		ResultSet rs = null;
		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
		try
		{
			LinkmanListMainInfo linkmanListMainInfo = new LinkmanListMainInfo();
			DBPrpLregistBase dbPrpLregistBase = new DBPrpLregistBase(dbManager);
			PrpLregistDto prpLregistDto = dbPrpLregistBase.findByPrimaryKeyToLinkManInfo(registNo);
			//获取被保险人信息
			BLPrpCinsured blPrpCinsured = new BLPrpCinsured();
			String isWhere = " policyNo = '" + prpLregistDto.getPolicyNo() + "' and insuredflag ='1' ";
			blPrpCinsured.query(isWhere);
			PrpCinsuredSchema prpCinsuredSchema = new PrpCinsuredSchema();
			if(blPrpCinsured.getSize() > 0){
				prpCinsuredSchema = blPrpCinsured.getArr(0);
			}
			//===========================================================================================
			String insuredName = "";
			String insuredMobile = "";
			String insuredMobilePhone = "";
			String familyphone = "";
			String receiverfullname = "";
		
		
			//联系电话
			 BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade();
			 String strPrpCinsuredCon = "policyno = '"+prpLregistDto.getPolicyNo()+"' and insuredflag = '1'";
			 Collection<PrpCinsuredDto> prpcinsuredDtoList = blPrpCinsuredFacade.findByConditions(strPrpCinsuredCon);
			 if(null != prpcinsuredDtoList && prpcinsuredDtoList.size() > 0){
				 Iterator<PrpCinsuredDto> it = prpcinsuredDtoList.iterator();
				 PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
				 while(it.hasNext()){
					 prpCinsuredDto = it.next();
				 }
				 if(!"".equals(prpCinsuredDto.getInsuredName()) && null != prpCinsuredDto.getInsuredName()){
					 insuredName = prpCinsuredDto.getInsuredName();
				 }
				 if(!"".equals(prpCinsuredDto.getMobile()) && null != prpCinsuredDto.getMobile()){
					 insuredMobile = prpCinsuredDto.getMobile();
				 }
				 if(!"".equals(prpCinsuredDto.getPhoneNumber()) && null != prpCinsuredDto.getPhoneNumber()){
					 insuredMobilePhone = prpCinsuredDto.getPhoneNumber();
				 }
			 }
			 String strPrplPayCon = "";
			strPrplPayCon = " p.REGISTNO = '" + prpLregistDto.getRegistNo() + "' AND p.RECEIVERFULLNAME = '" ;
			strPrplPayCon = strPrplPayCon + prpLregistDto.getInsuredName() + "' ORDER BY INPUTDATE DESC";
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			ArrayList<PrplpayDto> prplpayDtoList = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(strPrplPayCon);
			if(prplpayDtoList.size() > 0){
				familyphone = prplpayDtoList.get(0).getFamilyphone();
				receiverfullname = prplpayDtoList.get(0).getReceiverfullname();
			}
		    	String sql = "SELECT decode(pc.customertype, '1', pc.insuredname, pc.linkername),pc.mobilePhone1 FROM PrplCustomerInfo pc "+
		    	             "WHERE pc.registno = '"+prpLregistDto.getRegistNo()+"'";
		    	rs = dbManager.executeQuery(sql);
		    	if(rs.next()){
		    		String  strreceiverfullname = dbManager.getString(rs,1);
					String  strfamilyphone = dbManager.getString(rs,2);
					if(strfamilyphone!=null&&strfamilyphone.trim().length()!=0){
						familyphone =strfamilyphone;
					}
					if(strreceiverfullname!=null&&strreceiverfullname.trim().length()!=0){
						receiverfullname =strreceiverfullname;
					}
		    	}
		   
		//===========================================================================================
		    
		//数据转换
		    linkmanListMainInfo.setPolicyInsuredName(prpCinsuredSchema.getInsuredName());        
		    linkmanListMainInfo.setPolicyInsuredMobilePhone(prpCinsuredSchema.getPhoneNumber());
		    linkmanListMainInfo.setPolicyInsuredMobile(prpCinsuredSchema.getMobile());      
		    linkmanListMainInfo.setRegistReportorName(prpLregistDto.getReportorName());       
		    linkmanListMainInfo.setRegistReportorPhone(prpLregistDto.getReportorPhoneNumber());      
		    linkmanListMainInfo.setRegistInsuredName(prpLregistDto.getInsuredName());        
		    linkmanListMainInfo.setRegistInsuredPhone(prpLregistDto.getInsuredPhone());       
		    linkmanListMainInfo.setRegistInsuredMobilePhone(prpLregistDto.getInsuredMobilePhone()); 
		    linkmanListMainInfo.setRegistDriverName(prpLregistDto.getDriverName());         
		    linkmanListMainInfo.setRegistDriverPhone(prpLregistDto.getDriverPhone());        
		    linkmanListMainInfo.setCompeReceiverfullname(receiverfullname);    
		    linkmanListMainInfo.setCompeFamilyPhone(familyphone); 
		    if(!"05".equals(prpLregistDto.getClassCode())){
		    	linkmanListMainInfo.setRegistLinkerName(prpLregistDto.getLinkerName());
		    	linkmanListMainInfo.setRegistPhoneNumber(prpLregistDto.getPhoneNumber());
		    }
		    return linkmanListMainInfo;
		 }
	    catch(Exception ex)
	    {
	      dbManager.rollbackTransaction();
	      throw ex;
	    }
	    finally
	    {
	      if(rs!=null){
		      rs.close();//结果集关闭
		    }
	      dbManager.close();
	    }
	}
	
	private boolean isEmpty(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
}
