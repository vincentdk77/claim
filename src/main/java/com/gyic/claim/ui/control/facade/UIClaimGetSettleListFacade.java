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

import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPlantingpolicylistFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelisttempFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.utils.PlantingSettleExport;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.dbsvr.DBPlantingPolicyList;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainAgri;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainAgriSchema;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import java.text.DecimalFormat;
/**
 * 分发HTTP GET
 * <p>Title: 种植险理赔清单上传更新</p>
 * <p>Description: 种植险理赔清单上传更新</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: GYIC</p>
 * @author 
 * @version 1.0
 */

public class UIClaimGetSettleListFacade extends Action{
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
		  //第一次进来时候删除掉session中的plantingSettleList，这些数据是垃圾数据。
		  if("isFirst".equals(isFirst))
			  httpServletRequest.getSession().removeAttribute("plantingSettleList");
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
						 BLPlantingsettlelistFacade blPlantingSettleListFacade = new BLPlantingsettlelistFacade();
						 String sqlPlantingSettleList = " settleListCode like '"+settleListCode+"' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlPlantingSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlPlantingSettleList += " and "+strSearchCondition;
							 sqlPlantingSettleList = sqlPlantingSettleList + " and nodeType like '"+nodeType+"' and validity like '1' ";
							 PageRecord pageRecordPlantingSettleList = blPlantingSettleListFacade.findByConditions(sqlPlantingSettleList, currentPageNum, rowsPerPage);
							 if(null!=pageRecordPlantingSettleList && pageRecordPlantingSettleList.getCount()>0){
								 int count = blPlantingSettleListFacade.getCount(sqlPlantingSettleList);
								 settleListMap.put("countRecord", count);
								 double sumInsuredArea = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "INSUREAREA");
								 settleListMap.put("sumInsuredArea", sumInsuredArea);
								 double sumSettleArea = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "SETTLEAREA");
								 settleListMap.put("sumSettleArea", sumSettleArea);
								 double settleSum = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "SETTLESUM");
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
					 BLPlantingsettlelistFacade blPlantingSettleListFacade = new BLPlantingsettlelistFacade();
					 while(indexOfNodeType>=0){
						 String sqlPlantingSettleList = " settleListCode like '"+settleListCode+"' and validity like '1' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlPlantingSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlPlantingSettleList += " and "+strSearchCondition;
						 sqlPlantingSettleList = sqlPlantingSettleList + " and nodeType like '"+nodeList[indexOfNodeType]+"'";
						 PageRecord pageRecordPlantingSettleList = blPlantingSettleListFacade.findByConditions(sqlPlantingSettleList, currentPageNum, rowsPerPage);
						 if(null!=pageRecordPlantingSettleList && pageRecordPlantingSettleList.getCount()>0){
							 int count = blPlantingSettleListFacade.getCount(sqlPlantingSettleList);
							 settleListMap.put("countRecord", count);
							 double sumInsuredArea = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "INSUREAREA");
							 settleListMap.put("sumInsuredArea", sumInsuredArea);
							 double sumSettleArea = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "SETTLEAREA");
							 settleListMap.put("sumSettleArea", sumSettleArea);
							 double settleSum = blPlantingSettleListFacade.getSum(sqlPlantingSettleList, "SETTLESUM");
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
							  //if(insuremainlistDto.getRiskcode().equals("3228")||insuremainlistDto.getRiskcode().equals("3224"))
							  if(insuremainlistDto.getRiskcode().equals("3224"))
							  {
								  BLHerdpolicylistFacade blHerdpolicylistFacade = new BLHerdpolicylistFacade();
								  sqlInsureMainList = " inusreListCode like '"+insureListCode+"' ";
								  if(!"".equals(strSearchCondition))
									  sqlInsureMainList += " and "+strSearchCondition;
								  //加入保单清单有效性校验！
								  sqlInsureMainList += " and validity like '1' ";
								  PageRecord pageRecordPlantingPolicyList = blHerdpolicylistFacade.findByConditions(sqlInsureMainList, currentPageNum, rowsPerPage);
								  if(null!=pageRecordPlantingPolicyList && pageRecordPlantingPolicyList.getCount()>0){
									  int count = blHerdpolicylistFacade.getCount(sqlInsureMainList);
									  settleListMap.put("countRecord", count);
									  double sumInsuredArea = blHerdpolicylistFacade.getSum(sqlInsureMainList,"AREANUMBER");
									  settleListMap.put("sumInsuredArea", sumInsuredArea);
									  settleListMap.put("sumSettleArea", 0);
									  settleListMap.put("settleSum", 0);
									  Collection pageRecordHerdPolicyList = new ArrayList();
									  if(count>0){
										 totalPageNum = (count-1)/rowsPerPage+1;
									  }else{
										 totalPageNum = 0;
										 currentPageNum = 0;
									  }
									  settleListMap.put("currentPageNum", currentPageNum);
									  settleListMap.put("totalPageNum", totalPageNum);
									  settleListMap.put("listType", "PolicyList");

							     		Iterator it = pageRecordPlantingPolicyList.getResult().iterator();
							     		while(it.hasNext()){
							     			HerdpolicylistDto herdpolicylistDto = (HerdpolicylistDto)it.next();
							     			PlantingpolicylistDto herdtoplantingpolicylistDto = new PlantingpolicylistDto();
							     			//if(insuremainlistDto.getRiskcode().equals("3228"))
							     			//	herdtoplantingpolicylistDto = blHerdpolicylistFacade.evaluateHerdToplanting(herdpolicylistDto, "3228");
							     			//else 
							     			if(insuremainlistDto.getRiskcode().equals("3224"))
							     				herdtoplantingpolicylistDto = blHerdpolicylistFacade.evaluateHerdToplanting(herdpolicylistDto, "3224");
							     			pageRecordHerdPolicyList.add(herdtoplantingpolicylistDto);
							     		}
									  settleListMap.put("listTable", pageRecordHerdPolicyList);
									  settleListMap.put("mainTable", insuremainlistDto);
								  
								  }else {
										 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"没有关联保单清单！");
										 return actionMapping.findForward("message");
									 }
							  }
							  else
							  {
								  System.err.print("清单测1试3!");
								  BLPlantingpolicylistFacade blPlantingPolicyListFacade = new BLPlantingpolicylistFacade();
								  sqlInsureMainList = " inusreListCode like '"+insureListCode+"' ";
								  if(!"".equals(strSearchCondition))
									  sqlInsureMainList += " and "+strSearchCondition;
								  //加入保单清单有效性校验！
								  sqlInsureMainList += " and validity like '1' ";
								  PageRecord pageRecordPlantingPolicyList = blPlantingPolicyListFacade.findByConditions(sqlInsureMainList, currentPageNum, rowsPerPage);
								  if(null!=pageRecordPlantingPolicyList && pageRecordPlantingPolicyList.getCount()>0){
									  int count = blPlantingPolicyListFacade.getCount(sqlInsureMainList);
									  settleListMap.put("countRecord", count);
									  double sumInsuredArea = blPlantingPolicyListFacade.getSum(sqlInsureMainList,"INSUREAREA");
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
			  if("loadXLS".equals(loadXLS)){
				  SettlemainlistDto settleMainListDto = generateSettleMainList(httpServletRequest);
				  settleListMap.put("mainTable", settleMainListDto);
				  BLPlantingsettlelisttempFacade blPlantingSettleListTempFacade = new BLPlantingsettlelisttempFacade();
				  String sqlCondition = "registCode = '"+registNo+"' and stringTimeStamp = '"+strTimeStamp+"'";
				  PageRecord pageRecordPlantingSettleList = blPlantingSettleListTempFacade.findByConditions(sqlCondition, currentPageNum, rowsPerPage);
				  if(null!=pageRecordPlantingSettleList && pageRecordPlantingSettleList.getCount()>0){
					  Collection collectionListTable = pageRecordPlantingSettleList.getResult();
					  int count = blPlantingSettleListTempFacade.getCount(sqlCondition);
					  if(count>0){
						 totalPageNum = (count-1)/rowsPerPage+1;
					  }else{
						 totalPageNum = 0;
						 currentPageNum = 0;
					  }
					  double sunInsuredArea = blPlantingSettleListTempFacade.getSum(sqlCondition, "INSUREAREA");
					  settleListMap.put("sumInsuredArea", sunInsuredArea);
					  double sumSettleArea = blPlantingSettleListTempFacade.getSum(sqlCondition, "SETTLEAREA");
					  settleListMap.put("sumSettleArea", sumSettleArea);
					  double settleSum = blPlantingSettleListTempFacade.getSum(sqlCondition, "SETTLESUM");
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
	public List getSettleInfoList(HttpServletRequest httpServletRequest,String loadXLS, String editType,List<String> strTitleFieldName){
		List settleInfoTableList = new ArrayList();
		Map settleListMap = (Map)httpServletRequest.getAttribute("settleListMap");
		String listType = (String)settleListMap.get("listType");
		if("SettleList".equals(listType) && !"loadXLS".equals(loadXLS)){//listTable
	     	Collection collectionPlantingSettleList = (Collection)settleListMap.get("listTable");
	     	if(null!=collectionPlantingSettleList && collectionPlantingSettleList.size()>0){
	     		Iterator it = collectionPlantingSettleList.iterator();
	     		int i=1;
	     		while(it.hasNext()){
				    PlantingsettlelistDto plantingsettlelistDto = (PlantingsettlelistDto)it.next();
				    List settleRowInfoList = getSettleRowInfoListFromPlantingSettleList(plantingsettlelistDto,strTitleFieldName);
				    settleInfoTableList.add(settleRowInfoList);
				}
	     	}
		}else if("PolicyList".equals(listType)){
			Collection collectionPlantingPolicyList = (Collection)settleListMap.get("listTable");
			if(null != collectionPlantingPolicyList && collectionPlantingPolicyList.size()>0){
				String policyNo = (String)httpServletRequest.getAttribute("policyNo");
				//if(policyNo.substring(1,5).equals("3228")||policyNo.substring(1,5).equals("3224"))
				if(policyNo.substring(1,5).equals("3224"))
				{
					Iterator it = collectionPlantingPolicyList.iterator();
					int i = 1;
					BLHerdpolicylistFacade blHerdpolicylistFacade = new BLHerdpolicylistFacade();
					while(it.hasNext()){
//						HerdpolicylistDto herdpolicylistDto = (HerdpolicylistDto)it.next();						
//						PlantingpolicylistDto evPlantingpolicylistDto= blHerdpolicylistFacade.evaluateHerdToplanting(herdpolicylistDto,"3228");
//						List settleRowInfoList = getSettleRowInfoListFromPlantingPolicyList(evPlantingpolicylistDto,strTitleFieldName);
//					    settleInfoTableList.add(settleRowInfoList);
						PlantingpolicylistDto plantingPolicyListDto = (PlantingpolicylistDto)it.next();
						List settleRowInfoList = getSettleRowInfoListFromPlantingPolicyList(plantingPolicyListDto,strTitleFieldName);
					    settleInfoTableList.add(settleRowInfoList);
					}
				}
				else
				{
					Iterator it = collectionPlantingPolicyList.iterator();
					int i = 1;
					while(it.hasNext()){
						PlantingpolicylistDto plantingPolicyListDto = (PlantingpolicylistDto)it.next();
						List settleRowInfoList = getSettleRowInfoListFromPlantingPolicyList(plantingPolicyListDto,strTitleFieldName);
					    settleInfoTableList.add(settleRowInfoList);
					}
				}
			}
		}else if("loadXLS".equals(loadXLS)){
			//listTable
	     	Collection collectionPlantingSettleListTemp = (Collection)settleListMap.get("listTable");
	     	if(null!=collectionPlantingSettleListTemp && collectionPlantingSettleListTemp.size()>0){
	     		Iterator it = collectionPlantingSettleListTemp.iterator();
	     		int i=1;
	     		while(it.hasNext()){
	     			PlantingsettlelisttempDto plantingsettlelistTempDto = (PlantingsettlelisttempDto)it.next();
	     			List settleRowInfoList = getSettleRowInfoListFromPlantingSettleTempList(plantingsettlelistTempDto,strTitleFieldName);
				    settleInfoTableList.add(settleRowInfoList);
	     		}
	     	}
		}
		return settleInfoTableList;
	}
	public List<String> getSettleRowInfoListFromPlantingSettleList (PlantingsettlelistDto plantingsettlelistDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getSettlelistcode()==null?"":plantingsettlelistDto.getSettlelistcode());
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getFcode()==null?"":plantingsettlelistDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getKindcode()==null?"":plantingsettlelistDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getRiskcode()==null?"":plantingsettlelistDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getInsurearea()==0?"0":String.valueOf(plantingsettlelistDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getSuminsured()==null?"0":String.valueOf(plantingsettlelistDto.getSuminsured()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getZhibuka()==null?"":plantingsettlelistDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getFname()==null?"":plantingsettlelistDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getFidcard()==null?"":plantingsettlelistDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getFareacode()==null?"":plantingsettlelistDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getInusrelistcode()==null?"":plantingsettlelistDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getLossrate()==0?"0":String.valueOf(plantingsettlelistDto.getLossrate()));
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getSettlearea()==0?"0":String.valueOf(plantingsettlelistDto.getSettlearea()));
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getSettlesum()==null?"0":plantingsettlelistDto.getSettlesum());
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getRemark()==null?"":plantingsettlelistDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getClaimrate()==0?"0":String.valueOf(plantingsettlelistDto.getClaimrate()));
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getIndexofsettle()==0?"0":String.valueOf(plantingsettlelistDto.getIndexofsettle()));
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getPhone()==null?"":plantingsettlelistDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getBank()==null?"":plantingsettlelistDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getTaxarea()==0?"0":String.valueOf(plantingsettlelistDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = plantingsettlelistDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(i,fieldSourceName);
				}else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(plantingsettlelistDto.getWarrant()==null?"0":plantingsettlelistDto.getWarrant());
				else if("ATAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistDto.getAtarea()==null?"":plantingsettlelistDto.getAtarea());
				else if("LITTERAREA".equals(fieldName))
				    settleRowInfoList.add(plantingsettlelistDto.getLitterArea()==null?"":plantingsettlelistDto.getLitterArea());
				else if("WOODLANDAREA".equals(fieldName))
				    settleRowInfoList.add(plantingsettlelistDto.getWoodlandArea()==0?"":String.valueOf(plantingsettlelistDto.getWoodlandArea()));
			}
		}
		
		return settleRowInfoList;
	}
	public List<String> getSettleRowInfoListFromPlantingPolicyList (PlantingpolicylistDto plantingPolicyListDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				DecimalFormat df = new DecimalFormat("##0.00");
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add("");
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getFcode()==null?"":plantingPolicyListDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getKindcode()==null?"":plantingPolicyListDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getRiskcode()==null?"":plantingPolicyListDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getInsurearea()==0?"0":String.valueOf(plantingPolicyListDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					//settleRowInfoList.add(plantingPolicyListDto.getSumamount()==0?"0":String.valueOf(plantingPolicyListDto.getSumamount()));
					settleRowInfoList.add(plantingPolicyListDto.getSumamount()==0?"0":df.format(plantingPolicyListDto.getSumamount()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getZhibuka()==null?"":plantingPolicyListDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getFname()==null?"":plantingPolicyListDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getFidcard()==null?"":plantingPolicyListDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getFareacode()==null?"":plantingPolicyListDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getInusrelistcode()==null?"":plantingPolicyListDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add("");
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add("");
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add("");
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getRemark()==null?"":plantingPolicyListDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add("");
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getIndexcode()==null?"0":plantingPolicyListDto.getIndexcode());
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getPhone()==null?"":plantingPolicyListDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getBank()==null?"":plantingPolicyListDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getTaxarea()==0?"0":String.valueOf(plantingPolicyListDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = plantingPolicyListDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(fieldSourceName);
				}
				else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(plantingPolicyListDto.getWarrant()==null?"0":plantingPolicyListDto.getWarrant());
				else if("ATAREA".equals(fieldName))
					settleRowInfoList.add(plantingPolicyListDto.getAtarea()==null?"":plantingPolicyListDto.getAtarea());
				else if("LITTERAREA".equals(fieldName))
				    settleRowInfoList.add(plantingPolicyListDto.getLitterArea()==null?"":plantingPolicyListDto.getLitterArea());
				else if("WOODLANDAREA".equals(fieldName))
				    settleRowInfoList.add(plantingPolicyListDto.getWoodlandArea()==0?"":String.valueOf(plantingPolicyListDto.getWoodlandArea()));
			}
		}
		
		return settleRowInfoList;
	}
	public List<String> getSettleRowInfoListFromPlantingSettleTempList (PlantingsettlelisttempDto plantingsettlelistTempDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add("");
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getFcode()==null?"":plantingsettlelistTempDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getKindcode()==null?"":plantingsettlelistTempDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getRiskcode()==null?"":plantingsettlelistTempDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getInsurearea()==0?"0":String.valueOf(plantingsettlelistTempDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getSuminsured()==null?"0":String.valueOf(plantingsettlelistTempDto.getSuminsured()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getZhibuka()==null?"":plantingsettlelistTempDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getFname()==null?"":plantingsettlelistTempDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getFidcard()==null?"":plantingsettlelistTempDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getFareacode()==null?"":plantingsettlelistTempDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getInusrelistcode()==null?"":plantingsettlelistTempDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getLossrate()==0?"0":String.valueOf(plantingsettlelistTempDto.getLossrate()));
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getSettlearea()==0?"0":String.valueOf(plantingsettlelistTempDto.getSettlearea()));
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getSettlesum()==null?"0":plantingsettlelistTempDto.getSettlesum());
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getRemark()==null?"":plantingsettlelistTempDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getClaimrate()==0?"0":String.valueOf(plantingsettlelistTempDto.getClaimrate()));
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getIndexofsettle()==0?"0":String.valueOf(plantingsettlelistTempDto.getIndexofsettle()));
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getPhone()==null?"":plantingsettlelistTempDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getBank()==null?"":plantingsettlelistTempDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getTaxarea()==0?"0":String.valueOf(plantingsettlelistTempDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = plantingsettlelistTempDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(fieldSourceName);
				}
				else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(plantingsettlelistTempDto.getWarrant()==null?"0":plantingsettlelistTempDto.getWarrant());
				else if("ATAREA".equals(fieldName))
					settleRowInfoList.add(plantingsettlelistTempDto.getAtarea()==null?"":plantingsettlelistTempDto.getAtarea());
				else if("LITTERAREA".equals(fieldName))
				    settleRowInfoList.add(plantingsettlelistTempDto.getLitterArea()==null?"":plantingsettlelistTempDto.getLitterArea());
				else if("WOODLANDAREA".equals(fieldName))
				    settleRowInfoList.add(plantingsettlelistTempDto.getWoodlandArea()==0?"":String.valueOf(plantingsettlelistTempDto.getWoodlandArea()));
			}
		}
		
		return settleRowInfoList;
	}
	//定义清单缮制页面的表头标签信息
	public static List<String> getTitleListByRisk(String riskCode){
		List<String> strTitleList = new ArrayList<String>();
		if("3149".equals(riskCode)){
			String[] tempTitle = {"全选","序号","农户代码","姓名","身份证","银行账号","联系电话","林权证号/林补面积","剩余面积","剩余保额","受损面积","损失率%","赔偿金额","备注"};
			for(int i=0;i<tempTitle.length;i++){
				strTitleList.add(tempTitle[i]);
			}
		}
		if("3177".equals(riskCode)){
			String[] tempTitle = {"全选","序号","农户代码","姓名","身份证","银行账号","联系电话","林权证号/林补面积","剩余面积","剩余保额","受损面积","损失率%","赔偿金额","备注","实有林地面积"};
			for(int i=0;i<tempTitle.length;i++){
				strTitleList.add(tempTitle[i]);
			}
		}
		//if("3228".equals(riskCode)||"3224".equals(riskCode)){
		if("3224".equals(riskCode)){
			String[] tempTitle = {"序号","姓名","身份证","直补卡号","联系电话","投保数量","损失数量","损失程度","赔付比例","坐落地点","小地名","赔偿金额","备注"};
			for(int i=0;i<tempTitle.length;i++){
				strTitleList.add(tempTitle[i]);
			}
		}
		return strTitleList;
	}
	//定义清单缮制导入导出excel的清单表单数据信息，与表头标签信息一一对应。
	public static List<String> getTitleFieldNameListByRiskPolicyNo(String riskCode,String policyNo){
		List<String> strTitleFieldNameList = new ArrayList<String>();
		if("3149".equals(riskCode)){
			try {
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				Collection colItemKind = blPrpCitemKindFacade.findByConditions("PolicyNo = '"+policyNo+"'");
				if(null != colItemKind && colItemKind.size() > 0){
					String itemCode = ((PrpCitemKindDto)colItemKind.toArray()[0]).getItemCode();
					if("001".equals(itemCode)){
						String[] tempTitleFieldName = {"ALLSELECT","INDEXOFSETTLE","FCODE","FNAME","FIDCARD","ZHIBUKA","PHONE","TAXAREA","INSUREAREA","SUMINSURED","SETTLEAREA","LOSSRATE","SETTLESUM","REMARK","STRING"};
						for(int i=0;i<tempTitleFieldName.length;i++){
							strTitleFieldNameList.add(tempTitleFieldName[i]);
						}
					}else if("002".equals(itemCode)){
						String[] tempTitleFieldName = {"ALLSELECT","INDEXOFSETTLE","FCODE","FNAME","FIDCARD","ZHIBUKA","PHONE","WARRANT","INSUREAREA","SUMINSURED","SETTLEAREA","LOSSRATE","SETTLESUM","REMARK","STRING"};
						for(int i=0;i<tempTitleFieldName.length;i++){
							strTitleFieldNameList.add(tempTitleFieldName[i]);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if("3177".equals(riskCode)){
			try {
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				Collection colItemKind = blPrpCitemKindFacade.findByConditions("PolicyNo = '"+policyNo+"'");
				if(null != colItemKind && colItemKind.size() > 0){
					String itemCode = ((PrpCitemKindDto)colItemKind.toArray()[0]).getItemCode();
					if("001".equals(itemCode)){
						String[] tempTitleFieldName = {"ALLSELECT","INDEXOFSETTLE","FCODE","FNAME","FIDCARD","ZHIBUKA","PHONE","TAXAREA","INSUREAREA","SUMINSURED","SETTLEAREA","LOSSRATE","SETTLESUM","REMARK","WOODLANDAREA"};
						for(int i=0;i<tempTitleFieldName.length;i++){
							strTitleFieldNameList.add(tempTitleFieldName[i]);
						}
					}else if("002".equals(itemCode)){
						String[] tempTitleFieldName = {"ALLSELECT","INDEXOFSETTLE","FCODE","FNAME","FIDCARD","ZHIBUKA","PHONE","WARRANT","INSUREAREA","SUMINSURED","SETTLEAREA","LOSSRATE","SETTLESUM","REMARK","WOODLANDAREA"};
						for(int i=0;i<tempTitleFieldName.length;i++){
							strTitleFieldNameList.add(tempTitleFieldName[i]);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
			//if("3228".equals(riskCode)||"3224".equals(riskCode)){
			if("3224".equals(riskCode)){
					try {

					String[] tempTitleFieldName = {"INDEXOFSETTLE","FNAME","FIDCARD","ZHIBUKA","PHONE","INSUREAREA","SETTLEAREA","LOSSRATE","CLAIMRATE","ATAREA","LITTERAREA","SETTLESUM","REMARK","STRING"};
					for(int i=0;i<tempTitleFieldName.length;i++){
						strTitleFieldNameList.add(tempTitleFieldName[i]);
					}					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
		return strTitleFieldNameList;
	}

}
