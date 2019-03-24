package com.gyic.claim.ui.control.facade;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPlanting31PolicyListFacade;
import com.gyic.claim.bl.facade.BLPlanting31SettleListTempFacade;
import com.gyic.claim.bl.facade.BLPlantingpolicylistFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelisttempFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.utils.PlantingSettleExport;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.dbsvr.DBPlantingPolicyList;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainAgri;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainAgriSchema;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;

/**
 * 分发HTTP GET
 * <p>Title: 种植险理赔清单上传更新</p>
 * <p>Description: 种植险理赔清单上传更新</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: GYIC</p>
 * @author 
 * @version 1.0
 */

public class UIClaimGet31SettleListFacade extends Action{
	public final static String[] nodeList = {"check","claim","compe"};
	public final static String[] nodeNameList = {"调查","立案","理算"};//1:代耕代种   2：土地流转 3：开垦荒地或滩涂地
	public final static Map fieldSourceMap = new HashMap(){{
	    put("1", "代耕代种");
	    put("2", "土地流转");
	    put("3", "开垦荒地或滩涂地");
	}};
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)throws Exception{
		  
		  
		  String forward= "success";
		  String isFirst = trimString(httpServletRequest.getParameter("isFirst"));
		  //第一次进来时候删除掉session中的planting31SettleList，这些数据是垃圾数据。
		  if("isFirst".equals(isFirst))
			  httpServletRequest.getSession().removeAttribute("planting31SettleList");
		  String policyNo = trimString(httpServletRequest.getParameter("policyNo"));
		  String registNo = trimString(httpServletRequest.getParameter("registNo"));
		  String nodeType = trimString(httpServletRequest.getParameter("nodeType"));
		  String editType = trimString(httpServletRequest.getParameter("editType"));
		  String compensateNo = trimString(httpServletRequest.getParameter("compensateNo"));
		  String claimNo = trimString(httpServletRequest.getParameter("claimNo"));
		  String kindCode = trimString(httpServletRequest.getParameter("kindCode"));
		  String strPageNum = trimString(httpServletRequest.getParameter("PageNum"));
		  String strRowsPerPage = trimString(httpServletRequest.getParameter("rowsPerPage"));
		  String strSearchType = trimString(httpServletRequest.getParameter("searchType"));
		  String strSearchInfo = trimString(httpServletRequest.getParameter("searchInfo"));
		  String strTimeStamp = trimString(httpServletRequest.getParameter("timeStamp"));
		  String strSearchCondition = getSearchCondition(strSearchType,strSearchInfo);
		  String loadXLS = trimString(httpServletRequest.getParameter("loadXLS"));
		  if(null==loadXLS || "".equals(loadXLS))
			  loadXLS = trimString((String)httpServletRequest.getAttribute("loadXLS"));
		  if(null==policyNo || "".equals(policyNo))
			  policyNo = trimString((String)httpServletRequest.getAttribute("policyNo"));
		  if(null==registNo || "".equals(registNo))
			  registNo = trimString((String)httpServletRequest.getAttribute("registNo"));
		  if(null==nodeType || "".equals(nodeType))
			  nodeType = trimString((String)httpServletRequest.getAttribute("nodeType"));
		  if(null==claimNo || "".equals(claimNo))
			  claimNo = trimString((String)httpServletRequest.getAttribute("claimNo"));
		  if(null==kindCode || "".equals(kindCode))
			  kindCode = trimString((String)httpServletRequest.getAttribute("kindCode"));
		  if(null==editType || "".equals(editType))
			  editType = trimString((String)httpServletRequest.getAttribute("editType"));
		  if(null==compensateNo || "".equals(compensateNo))
			  compensateNo = trimString((String)httpServletRequest.getAttribute("compensateNo"));
		  if(null==strTimeStamp || "".equals(strTimeStamp))
			  strTimeStamp = trimString((String)httpServletRequest.getAttribute("timeStamp"));
		  httpServletRequest.setAttribute("policyNo", policyNo);
		  httpServletRequest.setAttribute("registNo", registNo);
		  httpServletRequest.setAttribute("claimNo", claimNo);
		  httpServletRequest.setAttribute("editType", editType);
		  httpServletRequest.setAttribute("nodeType", nodeType);
		  httpServletRequest.setAttribute("kindCode", kindCode);
		  httpServletRequest.setAttribute("loadXLS", loadXLS);
		  httpServletRequest.setAttribute("compensateNo", compensateNo);
		  httpServletRequest.setAttribute("timeStamp", strTimeStamp);
		  int currentPageNum = 0;
		  int rowsPerPage = 20;
		  int totalPageNum = 0;
		  if(null!=strPageNum && !"".equals(strPageNum))
			  currentPageNum = Integer.parseInt(strPageNum);
		  else currentPageNum =1;
		  if(null!=strRowsPerPage && !"".equals(strRowsPerPage))
			  rowsPerPage = Integer.parseInt(strRowsPerPage);
		  int indexOfNodeType = -1;
		  for(int i=0;i<nodeList.length;i++){
			  if(null!=nodeType && nodeType.equals(nodeList[i])){
				  indexOfNodeType = i;
				  break;
			  }
		  }
		  Map settleListMap = new HashMap();
		  if("view".equals(editType)){
			  if(null!=policyNo && !"".equals(policyNo) && null!=registNo && !"".equals(registNo) && null!=nodeType && !"".equals(nodeType)){
				  /**
					  * 根据保单号取理赔清单头表，且理算书号字段不能有值，如果有数据且只有一条，则进一步依照传入的节点名称判断。
					  * 如果没有找到对应的理赔清单头表，则获取最新保单清单表。
					  */
					 BLSettlemainlistFacade blSettleMainListFacade = new BLSettlemainlistFacade();
					 String sqlCondition = " policyNo like '"+policyNo+"' and validity like '2' ";
					 //加入对理算号的判断，以确保案后重开时不会取到已经理算的的理赔清单。
					 if("compe".equals(nodeType)){
						 if(null!=compensateNo && !"".equals(compensateNo))//如果有理算书号，加入理算书号判断
							 sqlCondition += " and compensateNo like '"+compensateNo+"'";
						 else 
							 sqlCondition += " and (compensateNo is null or compensateNo like '') ";
					 }
					 if(null!=registNo && !"".equals(registNo))//如果有报案号，加入报案号判断
						 sqlCondition += " and REPORTCODE like '"+registNo+"'";
//					 if(null!=claimNo && !"".equals(claimNo))//如果有立案号，加入立案号判断
//						 sqlCondition += " and REGISTERCODE like '"+claimNo+"'";
					 sqlCondition += " order by UpdateDate ";
					 int countOfSettleMainList = blSettleMainListFacade.getCount(sqlCondition);
					 if(0==countOfSettleMainList){//没有找到保单对应的理赔清单，则把节点序号置-1。在后边根据这个去取保单清单。
						 httpServletRequest.setAttribute("viewErrorMessage", "当前保单"+policyNo+"没有对应的理赔清单！");
						 return actionMapping.findForward("message");
					 }else{
						 Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
						 //对于有多条理赔清单的案件，找第一条，即为第一张理算书对应的清单。
						 SettlemainlistDto settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
						 	/**
							 * 首先判断节点,如果传入节点类型在数组中有对应。则从当前节点取数据，如节点类型为claim,则带claim中的数据用于显示。
							 * 如果claim中没有数据，则取check中的数据用于显示
							 */
						 String settleListCode = settleMainListDto.getSettlelistcode();
						 claimNo = settleMainListDto.getRegistercode();
						 if(null!=claimNo && !"".equals(claimNo))
							 httpServletRequest.setAttribute("claimNo", claimNo);
						 BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
						 String sqlPlantingSettleList = " settleListCode like '"+settleListCode+"' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlPlantingSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlPlantingSettleList += " and "+strSearchCondition;
							 sqlPlantingSettleList = sqlPlantingSettleList + " and nodeType like '"+nodeType+"' and validity like '1' ";
							 PageRecord pageRecordPlantingSettleList = blPlanting31SettleListFacade.findByConditions(sqlPlantingSettleList, currentPageNum, rowsPerPage);
							 if(null!=pageRecordPlantingSettleList && pageRecordPlantingSettleList.getCount()>0){
								 int count = blPlanting31SettleListFacade.getCount(sqlPlantingSettleList);
								 settleListMap.put("countRecord", count);
								 double sumInsuredArea = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "INSUREAREA");
								 settleListMap.put("sumInsuredArea", sumInsuredArea);
								 double sumSettleArea = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "SETTLEAREA");
								 settleListMap.put("sumSettleArea", sumSettleArea);
								 double settleSum = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "SETTLESUM");
								 settleListMap.put("settleSum", settleSum);
								 if(count>0){
									 totalPageNum = (count-1)/rowsPerPage+1;
								 }else{
									 totalPageNum = 0;
									 currentPageNum = 0;
								 }
								 settleListMap.put("currentPageNum", currentPageNum);
								 settleListMap.put("totalPageNum", totalPageNum);
								 settleListMap.put("listType", "SettleList");
								 settleListMap.put("listTable", pageRecordPlantingSettleList.getResult());
								 settleListMap.put("mainTable", settleMainListDto);
							 }else{
								 httpServletRequest.setAttribute("viewErrorMessage", "当前节点没有对应的理赔清单明细！");
								 return actionMapping.findForward("message");
							 }
						}
			  	}
		  }
		  else if("edit".equals(editType) && !"loadXLS".equals(loadXLS)){
			  if(null!=policyNo && !"".equals(policyNo) && null!=registNo && !"".equals(registNo) && null!=nodeType && !"".equals(nodeType)){
				 /**
				  * 根据保单号取理赔清单头表，且理算书号字段不能有值，如果有数据且只有一条，则进一步依照传入的节点名称判断。
				  * 如果没有找到对应的理赔清单头表，则获取最新保单清单表。
				  */
				 BLSettlemainlistFacade blSettleMainListFacade = new BLSettlemainlistFacade();
				 String sqlCondition = " policyNo like '"+policyNo+"' and validity like '2' ";
				 int length = nodeList.length;
				 if(null!=compensateNo && !"".equals(compensateNo))//如果有理算书号，加入理算书号判断
					 sqlCondition += " and compensateNo like '"+compensateNo+"'";
				 else sqlCondition += " and (compensateNo is null or compensateNo like '') ";//加入对理算号的判断，以确保案后重开时不会取到已经理算的的理赔清单。
				 if(null!=registNo && !"".equals(registNo))//如果有报案号，加入报案号判断
					 sqlCondition += " and REPORTCODE like '"+registNo+"'";
//				 if(null!=claimNo && !"".equals(claimNo))//如果有立案号，加入立案号判断
//					 sqlCondition += " and REGISTERCODE like '"+claimNo+"'";
				 int countOfSettleMainList = blSettleMainListFacade.getCount(sqlCondition);
				 if(0==countOfSettleMainList)//没有找到保单对应的理赔清单，则把节点序号置-1。在后边根据这个去取保单清单。
					 indexOfNodeType =-1;
				 else if(1!=countOfSettleMainList){
					 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"对应的理赔清单不唯一！");
					 return actionMapping.findForward("message");
				 }else{
					 Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
					 SettlemainlistDto settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
					 	/**
						 * 首先判断节点,如果传入节点类型在数组中有对应。则从当前节点取数据，如节点类型为claim,则带claim中的数据用于显示。
						 * 如果claim中没有数据，则取check中的数据用于显示
						 */
					 String settleListCode = settleMainListDto.getSettlelistcode();
					 claimNo = settleMainListDto.getRegistercode();
					 if(null!=claimNo && !"".equals(claimNo))
						 httpServletRequest.setAttribute("claimNo", claimNo);
					 BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
					 while(indexOfNodeType>=0){
						 String sqlPlantingSettleList = " settleListCode like '"+settleListCode+"' and validity like '1' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlPlantingSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlPlantingSettleList += " and "+strSearchCondition;
						 sqlPlantingSettleList = sqlPlantingSettleList + " and nodeType like '"+nodeList[indexOfNodeType]+"'";
						 PageRecord pageRecordPlanting31SettleList = blPlanting31SettleListFacade.findByConditions(sqlPlantingSettleList, currentPageNum, rowsPerPage);
						 if(null!=pageRecordPlanting31SettleList && pageRecordPlanting31SettleList.getCount()>0){
							 int count = blPlanting31SettleListFacade.getCount(sqlPlantingSettleList);
							 settleListMap.put("countRecord", count);
							 double sumInsuredArea = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "INSUREAREA");
							 settleListMap.put("sumInsuredArea", sumInsuredArea);
							 double sumSettleArea = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "SETTLEAREA");
							 settleListMap.put("sumSettleArea", sumSettleArea);
							 double settleSum = blPlanting31SettleListFacade.getSum(sqlPlantingSettleList, "SETTLESUM");
							 settleListMap.put("settleSum", settleSum);
							 if(count>0){
								 totalPageNum = (count-1)/rowsPerPage+1;
							 }else{
								 totalPageNum = 0;
								 currentPageNum = 0;
							 }
							 settleListMap.put("currentPageNum", currentPageNum);
							 settleListMap.put("totalPageNum", totalPageNum);
							 settleListMap.put("listType", "SettleList");
							 settleListMap.put("listTable", pageRecordPlanting31SettleList.getResult());
							 settleListMap.put("mainTable", settleMainListDto);
							 break;
						 }
						 else indexOfNodeType --;
					 }
				 }
				  if(-1==indexOfNodeType){//-1代表没有理赔清单，需要显示保单最新清单。
					  BLPrpCmainAgri blPrpCmainAgri = new BLPrpCmainAgri();
					  blPrpCmainAgri.getData(policyNo);
					  Collection collectionCmainAgri = blPrpCmainAgri.getSchemas();
					  if(null!=collectionCmainAgri && collectionCmainAgri.size()==1){
						  PrpCmainAgriSchema prpCmainAgriSchema = (PrpCmainAgriSchema)collectionCmainAgri.toArray()[0];
						  String insureListCode = prpCmainAgriSchema.getRelationListNo();
						  if(null==insureListCode || "".equals(insureListCode)){
							 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"没有关联保单清单！");
							 return actionMapping.findForward("message");
						 }
						  BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
						  String sqlInsureMainList = " inusreListCode like '"+insureListCode+"' and validity like '2' ";
						  Collection collectionInsureMainList = blInsureMainListFacade.findByConditions(sqlInsureMainList);
						  if(null!=collectionInsureMainList && collectionInsureMainList.size()==1){
							  InsuremainlistDto insuremainlistDto = (InsuremainlistDto)collectionInsureMainList.toArray()[0];
							  BLPlanting31PolicyListFacade blPlanting31PolicyListFacade = new BLPlanting31PolicyListFacade();
							  sqlInsureMainList = " inusreListCode like '"+insureListCode+"' ";
							  if(!"".equals(strSearchCondition))
								  sqlInsureMainList += " and "+strSearchCondition;
							  //加入保单清单有效性校验！
							  sqlInsureMainList += " and validity like '1' ";
							  PageRecord pageRecordPlantingPolicyList = blPlanting31PolicyListFacade.findByConditions(sqlInsureMainList, currentPageNum, rowsPerPage);
							  if(null!=pageRecordPlantingPolicyList && pageRecordPlantingPolicyList.getCount()>0){
								  int count = blPlanting31PolicyListFacade.getCount(sqlInsureMainList);
								  settleListMap.put("countRecord", count);
								  double sumInsuredArea = blPlanting31PolicyListFacade.getSum(sqlInsureMainList,"INSUREAREA");
								  settleListMap.put("sumInsuredArea", sumInsuredArea);
								  settleListMap.put("sumSettleArea", 0);
								  settleListMap.put("settleSum", 0);
								  if(count>0){
									 totalPageNum = (count-1)/rowsPerPage+1;
								  }else{
									 totalPageNum = 0;
									 currentPageNum = 0;
								  }
								  settleListMap.put("currentPageNum", currentPageNum);
								  settleListMap.put("totalPageNum", totalPageNum);
								  settleListMap.put("listType", "PolicyList");
								  settleListMap.put("listTable", pageRecordPlantingPolicyList.getResult());
								  settleListMap.put("mainTable", insuremainlistDto);
							  }else {
									 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"没有关联保单清单！");
									 return actionMapping.findForward("message");
								 }
						  }else {
							  httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"对应的保单清单为空或不唯一！");
								 return actionMapping.findForward("message");
							 }
					  }else {
						  	 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"对应的保单清单为空或不唯一！");
							 return actionMapping.findForward("message");
						 }
				  }
//				  BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
//				  blPrpCitemKind.findByMess(policyNo);
//				  Collection prpCitemKindSchemaes = blPrpCitemKind.getSchemas();
//				  List kindCodesList = new ArrayList();
//				  if(null!=prpCitemKindSchemaes && prpCitemKindSchemaes.size()>0){
//					  Iterator it = prpCitemKindSchemaes.iterator();
//					  while(it.hasNext()){
//						  PrpCitemKindSchema prpCitemKindSchema = (PrpCitemKindSchema)it.next();
//						  kindCodesList.add(prpCitemKindSchema.getKindCode());
//						  kindCodesList.add(prpCitemKindSchema.getKindName());
//					  }
//				  }
//				  settleListMap.put("kindCodesList", kindCodesList);
				  
			  }
		  }else{
			  if("loadXLS".equals(loadXLS)){//导入清单时，从临时表查找数据显示。
				  SettlemainlistDto settleMainListDto = generateSettleMainList(httpServletRequest);
				  settleListMap.put("mainTable", settleMainListDto);
				  BLPlanting31SettleListTempFacade blPlanting31SettleListTempFacade = new BLPlanting31SettleListTempFacade();
				  String sqlCondition = "registCode = '"+registNo+"' and stringTimeStamp = '"+strTimeStamp+"'";
				  PageRecord pageRecordPlantingSettleList = blPlanting31SettleListTempFacade.findByConditions(sqlCondition, currentPageNum, rowsPerPage);
				  if(null!=pageRecordPlantingSettleList && pageRecordPlantingSettleList.getCount()>0){
					  Collection collectionListTable = pageRecordPlantingSettleList.getResult();
					  int count = blPlanting31SettleListTempFacade.getCount(sqlCondition);
					  if(count>0){
						 totalPageNum = (count-1)/rowsPerPage+1;
					  }else{
						 totalPageNum = 0;
						 currentPageNum = 0;
					  }
					  double sunInsuredArea = blPlanting31SettleListTempFacade.getSum(sqlCondition, "INSUREAREA");
					  settleListMap.put("sumInsuredArea", sunInsuredArea);
					  double sumSettleArea = blPlanting31SettleListTempFacade.getSum(sqlCondition, "SETTLEAREA");
					  settleListMap.put("sumSettleArea", sumSettleArea);
					  double settleSum = blPlanting31SettleListTempFacade.getSum(sqlCondition, "SETTLESUM");
					  settleListMap.put("settleSum", settleSum);
					  settleListMap.put("countRecord", count);
					  settleListMap.put("currentPageNum", currentPageNum);
					  settleListMap.put("totalPageNum", totalPageNum);
					  settleListMap.put("listType", "SettleList");
					  settleListMap.put("listTable", collectionListTable);
				  }
			  }
		  }
		  httpServletRequest.setAttribute("realNodeType", translateNodeType(indexOfNodeType));
		  httpServletRequest.setAttribute("settleListMap", settleListMap);
		  if(null!=httpServletRequest.getAttribute("editErrorMessage"))
			 return actionMapping.findForward("message");
		  return actionMapping.findForward(forward);
	  }
	  
	  private String getSearchCondition(String strSearchType, String strSearchInfo){
		  String searchCondition = "";
		  if(null!=strSearchInfo && !"".equals(strSearchInfo.trim())){
			if("fCode".equals(strSearchType))
				searchCondition = " FCODE like '%"+strSearchInfo.trim()+"%'";
			if("ZhiBuKa".equals(strSearchType))
				searchCondition = " ZHIBUKA like '%"+strSearchInfo.trim()+"%'";
			if("fName".equals(strSearchType))
				searchCondition = " FNAME like '%"+strSearchInfo.trim()+"%'";
		  }
		  return searchCondition;
	  }
	  private SettlemainlistDto generateSettleMainList(HttpServletRequest httpServletRequest){
		  SettlemainlistDto settleMainListDto = null;
		  String settleListCode = httpServletRequest.getParameter("settleListCode");
		  if(null==settleListCode || "".equals(settleListCode))
			  settleListCode = trimString((String)httpServletRequest.getAttribute("settleListCode"));
		  try {
			if(null!=settleListCode && !"".equals(settleListCode)){
				  BLSettlemainlistFacade blSettleMainListFacade = new BLSettlemainlistFacade();
				  Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(" settleListCode like '"+settleListCode+"' and validity like '2' ");
				  if(null!=collectionSettleMainList && collectionSettleMainList.size()==1){
					  settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
				  }
			  }else{
				  String insureListCode = httpServletRequest.getParameter("insureListCode");
				  if(null==insureListCode || "".equals(insureListCode))
					  insureListCode = trimString((String)httpServletRequest.getAttribute("insureListCode"));
				  if(null!=insureListCode && !"".equals(insureListCode)){
					  BLInsuremainlistFacade insureMainListFacade = new BLInsuremainlistFacade();
					  Collection collectionInsureMainList = insureMainListFacade.findByConditions(" inusreListCode like '"+insureListCode+"' and validity like '2' ");
					  if(null!=collectionInsureMainList && collectionInsureMainList.size()==1){
						  InsuremainlistDto insureMainListDto = (InsuremainlistDto)collectionInsureMainList.toArray()[0];
						  settleMainListDto = getDataFromInsureMainList(insureMainListDto);
					  }
				  }
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null==settleMainListDto)
			httpServletRequest.setAttribute("editErrorMessage", "当前保单对应的理赔清单或投保清单为空！");
		  return settleMainListDto;
	  }
	  private SettlemainlistDto getDataFromInsureMainList(InsuremainlistDto insureMainListDto){
		  SettlemainlistDto settleMainListDto = new SettlemainlistDto();
		  settleMainListDto.setInusrelistcode(insureMainListDto.getInusrelistcode());
		  settleMainListDto.setFareacode(insureMainListDto.getFareacode());
		  settleMainListDto.setRiskcode(insureMainListDto.getRiskcode());
		  settleMainListDto.setClasscode(insureMainListDto.getClasscode());
		  return settleMainListDto;
	  }
	private String trimString(String string){
			if(null!=string && !"".equals(string))
				string = string.trim();
			return string;
	}
	private String translateNodeType(int indexOfNodeType){
		String nodeType = "";
		if(-1<indexOfNodeType && indexOfNodeType<nodeList.length)
			nodeType = nodeList[indexOfNodeType];		
		return nodeType;
	}
}
