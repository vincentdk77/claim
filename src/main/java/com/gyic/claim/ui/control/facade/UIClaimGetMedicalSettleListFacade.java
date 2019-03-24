package com.gyic.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.utils.PlantingSettleExport;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.dbsvr.DBPlantingPolicyList;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainAgri;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty;
import com.sinosoft.prpall.schema.PrpCmainCasualtySchema;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainAgriSchema;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class UIClaimGetMedicalSettleListFacade extends Action{
	public final static String[] nodeList = {"claim","compe"};
	public final static String[] nodeNameList = {"立案","理算"};//1:代耕代种   2：土地流转 3：开垦荒地或滩涂地
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)throws Exception{
		  
		  
		  String forward= "success";
		  String isFirst = trimString(httpServletRequest.getParameter("isFirst"));
		  //第一次进来时候删除掉session中的plantingSettleList，这些数据是垃圾数据。
		  if("isFirst".equals(isFirst))
			  httpServletRequest.getSession().removeAttribute("medicalSettleList");
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
		  String riskCode1 = trimString(httpServletRequest.getParameter("riskCode"));
          //System.err.println(riskCode1);
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
		  if(null==riskCode1 || "".equals(riskCode1))
			  riskCode1 = trimString((String)httpServletRequest.getAttribute("riskCode"));
		  //System.err.println(riskCode1);
		  httpServletRequest.setAttribute("policyNo", policyNo);
		  httpServletRequest.setAttribute("registNo", registNo);
		  httpServletRequest.setAttribute("claimNo", claimNo);
		  httpServletRequest.setAttribute("editType", editType);
		  httpServletRequest.setAttribute("nodeType", nodeType);
		  httpServletRequest.setAttribute("kindCode", kindCode);
		  httpServletRequest.setAttribute("loadXLS", loadXLS);
		  httpServletRequest.setAttribute("compensateNo", compensateNo);
		  httpServletRequest.setAttribute("timeStamp", strTimeStamp);
		  
		  httpServletRequest.setAttribute("riskCode1", riskCode1);
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
				     BLSettlemainlistFacadeForMedical blSettleMainListFacade = new BLSettlemainlistFacadeForMedical();
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
						 BLMedicalsettlelistFacade blMedicalSettleListFacade = new BLMedicalsettlelistFacade();
						 String sqlMedicalSettleList = " settleListCode like '"+settleListCode+"' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlMedicalSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlMedicalSettleList += " and "+strSearchCondition;
							 sqlMedicalSettleList = sqlMedicalSettleList + " and nodeType like '"+nodeType+"' and validity like '1' ";
							 PageRecord pageRecordMedicalSettleList = blMedicalSettleListFacade.findByConditions(sqlMedicalSettleList, currentPageNum, rowsPerPage);
							 if(null!=pageRecordMedicalSettleList && pageRecordMedicalSettleList.getCount()>0){
								 int count = blMedicalSettleListFacade.getCount(sqlMedicalSettleList);
								 settleListMap.put("countRecord", count);
								 //double sumInsuredArea = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "INSUREAREA");
								 //settleListMap.put("sumInsuredArea", sumInsuredArea);
								 //double sumSettleArea = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "SETTLEAREA");
								 //settleListMap.put("sumSettleArea", sumSettleArea);
								 BigDecimal settleSum = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "SETTLESUM");
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
								 settleListMap.put("listTable", pageRecordMedicalSettleList.getResult());
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
				  //System.err.println(policyNo);
				 BLSettlemainlistFacadeForMedical blSettleMainListFacade = new BLSettlemainlistFacadeForMedical();
				 String sqlCondition = " policyNo like '"+policyNo+"' and validity like '2' ";
				 int length = nodeList.length;
				 if(null!=compensateNo && !"".equals(compensateNo))//如果有理算书号，加入理算书号判断
					 sqlCondition += " and compensateNo like '"+compensateNo+"'";
				 else sqlCondition += " and (compensateNo is null or compensateNo like '') ";//加入对理算号的判断，以确保案后重开时不会取到已经理算的的理赔清单。
				 if(null!=registNo && !"".equals(registNo))//如果有报案号，加入报案号判断
					 sqlCondition += " and REPORTCODE like '"+registNo+"'";
//				 if(null!=claimNo && !"".equals(claimNo))//如果有立案号，加入立案号判断
//					 sqlCondition += " and REGISTERCODE like '"+claimNo+"'";
				 //System.err.println(sqlCondition);
				 int countOfSettleMainList = blSettleMainListFacade.getCount(sqlCondition);
				 //System.err.println(countOfSettleMainList);
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
					 BLMedicalsettlelistFacade blMedicalSettleListFacade = new BLMedicalsettlelistFacade();
					 while(indexOfNodeType>=0){
						 String sqlMedicalSettleList = " settleListCode like '"+settleListCode+"' and validity like '1' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlMedicalSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlMedicalSettleList += " and "+strSearchCondition;
						 sqlMedicalSettleList = sqlMedicalSettleList + " and nodeType like '"+nodeList[indexOfNodeType]+"'";
						 PageRecord pageRecordMedicalSettleList = blMedicalSettleListFacade.findByConditions(sqlMedicalSettleList, currentPageNum, rowsPerPage);
						 if(null!=pageRecordMedicalSettleList && pageRecordMedicalSettleList.getCount()>0){
							 int count = blMedicalSettleListFacade.getCount(sqlMedicalSettleList);
							 settleListMap.put("countRecord", count);
							 //double sumInsuredArea = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "INSUREAREA");
							 //settleListMap.put("sumInsuredArea", sumInsuredArea);
							 //double sumSettleArea = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "SETTLEAREA");
							 //settleListMap.put("sumSettleArea", sumSettleArea);
							 BigDecimal settleSum = blMedicalSettleListFacade.getSum(sqlMedicalSettleList, "SETTLESUM");
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
							 settleListMap.put("listTable", pageRecordMedicalSettleList.getResult());
							 settleListMap.put("mainTable", settleMainListDto);
							 break;
						 }
						 else indexOfNodeType --;
					 }
				 }
				  if(-1==indexOfNodeType){//-1代表没有理赔清单，需要显示保单最新清单。
					  if("2801".equals(riskCode1) || "2605".equals(riskCode1) || "2606".equals(riskCode1))
					  {
						  settleListMap.put("listType", "NoList");
					  }
					  else
					  {
						  BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
						  blPrpCmainCasualty.getData(policyNo);
						  if(null!=blPrpCmainCasualty && blPrpCmainCasualty.getSize() ==1)
						  {
							  PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
							  String insureListCode = prpCmainCasualtySchema.getTravelGroupNo();
							  //System.err.println("清单号：" + insureListCode);
							  if(null==insureListCode || "".equals(insureListCode)){
									 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"没有关联保单清单！");
									 return actionMapping.findForward("message");
							  }
							  BLMedicalInsuremainlistFacade blInsureMainListFacade = new BLMedicalInsuremainlistFacade();
							  String sqlInsureMainList = " inusreListCode like '"+insureListCode+"' and validity like '2' ";
							  Collection collectionInsureMainList = blInsureMainListFacade.findByConditions(sqlInsureMainList);
							  //System.err.println("查询条件：" + sqlInsureMainList);
							  //System.err.println("保单清单主表记录数目：" + collectionInsureMainList.size());
							  if(null!=collectionInsureMainList && collectionInsureMainList.size()==1)
							  {
								  MedicalInsuremainlistDto insuremainlistDto = (MedicalInsuremainlistDto)collectionInsureMainList.toArray()[0];
								  BLMedicalPolicyListFacade blMedicalPolicyListFacade = new BLMedicalPolicyListFacade();
								  sqlInsureMainList = " inusreListCode like '"+insureListCode+"' ";
								  //System.err.println("搜索条件：" + strSearchCondition);
								  if(!"".equals(strSearchCondition))
									  sqlInsureMainList += " and "+strSearchCondition;
								  
								  
								  //加入保单清单有效性校验！
								  sqlInsureMainList += " and validity like '1' ";
								  //System.err.println("清单表查询条件：" + sqlInsureMainList);
								  PageRecord pageRecordMedicalPolicyList = blMedicalPolicyListFacade.findByConditions(sqlInsureMainList, currentPageNum, rowsPerPage);
								  //System.err.println("保单清单表数目：" + pageRecordMedicalPolicyList.getCount());
								  if(null!=pageRecordMedicalPolicyList && pageRecordMedicalPolicyList.getCount()>0){
									  int count = blMedicalPolicyListFacade.getCount(sqlInsureMainList);
									  settleListMap.put("countRecord", count);
									  //double sumInsuredArea = blMedicalPolicyListFacade.getSum(sqlInsureMainList,"INSUREAREA");
									  //settleListMap.put("sumInsuredArea", sumInsuredArea);
									  //settleListMap.put("sumSettleArea", 0);
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
									  settleListMap.put("listTable", pageRecordMedicalPolicyList.getResult());
									  settleListMap.put("mainTable", insuremainlistDto);
								  }else {
										 httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"没有关联保单清单！");
										 return actionMapping.findForward("message");
									 }
							  }
							  else {
								  httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"对应的保单清单为空或不唯一！");
									 return actionMapping.findForward("message");
								 }
							  
						  }
						  else {
							  httpServletRequest.setAttribute("editErrorMessage", "当前保单"+policyNo+"对应的保单清单为空或不唯一！");
								 return actionMapping.findForward("message");
							 }
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
				  SettlemainlistDto settleMainListDto = generateSettleMainList(httpServletRequest,riskCode1);
				  settleListMap.put("mainTable", settleMainListDto);
				  BLMedicalsettlelisttempFacade blMedicalSettleListTempFacade = new BLMedicalsettlelisttempFacade();
				  String sqlCondition = "registCode = '"+registNo+"' and stringTimeStamp = '"+strTimeStamp+"'";
				  PageRecord pageRecordMedicalSettleList = blMedicalSettleListTempFacade.findByConditions(sqlCondition, currentPageNum, rowsPerPage);
				  if(null!=pageRecordMedicalSettleList && pageRecordMedicalSettleList.getCount()>0){
					  Collection collectionListTable = pageRecordMedicalSettleList.getResult();
					  int count = blMedicalSettleListTempFacade.getCount(sqlCondition);
					  if(count>0){
						 totalPageNum = (count-1)/rowsPerPage+1;
					  }else{
						 totalPageNum = 0;
						 currentPageNum = 0;
					  }
					  //double sunInsuredArea = blMedicalSettleListTempFacade.getSum(sqlCondition, "INSUREAREA");
					  //settleListMap.put("sumInsuredArea", sunInsuredArea);
					  //double sumSettleArea = blMedicalSettleListTempFacade.getSum(sqlCondition, "SETTLEAREA");
					  //settleListMap.put("sumSettleArea", sumSettleArea);
					  double settleSum = blMedicalSettleListTempFacade.getSum(sqlCondition, "SETTLESUM");
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
			if("medicalcard".equals(strSearchType))
				searchCondition = " medicalcard like '%"+strSearchInfo.trim()+"%'";
			if("creditcard".equals(strSearchType))
				searchCondition = " creditcard like '%"+strSearchInfo.trim()+"%'";
			if("Name".equals(strSearchType))
				searchCondition = " Name like '%"+strSearchInfo.trim()+"%'";
			if("idcard".equals(strSearchType))
				searchCondition = " idcard like '%"+strSearchInfo.trim()+"%'";
		  }
		  return searchCondition;
	  }
	  private SettlemainlistDto generateSettleMainList(HttpServletRequest httpServletRequest,String riskcode){
		  SettlemainlistDto settleMainListDto = null;
		  String settleListCode = httpServletRequest.getParameter("settleListCode");
		  if(null==settleListCode || "".equals(settleListCode))
			  settleListCode = trimString((String)httpServletRequest.getAttribute("settleListCode"));
		  try {
			if(null!=settleListCode && !"".equals(settleListCode)){
				BLSettlemainlistFacadeForMedical blSettleMainListFacade = new BLSettlemainlistFacadeForMedical();
				  Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(" settleListCode like '"+settleListCode+"' and validity like '2' ");
				  if(null!=collectionSettleMainList && collectionSettleMainList.size()==1){
					  settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
				  }
			  }
			else
			{
				  String insureListCode = httpServletRequest.getParameter("insureListCode");
				  if(null==insureListCode || "".equals(insureListCode))
					  insureListCode = trimString((String)httpServletRequest.getAttribute("insureListCode"));
				  
				  if(null!=insureListCode && !"".equals(insureListCode)){
					  BLMedicalInsuremainlistFacade insureMainListFacade = new BLMedicalInsuremainlistFacade();
					  Collection collectionInsureMainList = insureMainListFacade.findByConditions(" inusreListCode like '"+insureListCode+"' and validity like '2' ");
					  if(null!=collectionInsureMainList && collectionInsureMainList.size()==1){
						  MedicalInsuremainlistDto insureMainListDto = (MedicalInsuremainlistDto)collectionInsureMainList.toArray()[0];
						  settleMainListDto = getDataFromInsureMainList(insureMainListDto);
					  }
				  }
				  else
				  {
					  settleMainListDto = new SettlemainlistDto();
					  //String riskcodetemp = trimString(httpServletRequest.getParameter("riskCode"));
					  settleMainListDto.setRiskcode(riskcode);
					  settleMainListDto.setClasscode(riskcode.substring(0, 2));
				  }
				  //settleMainListDto.setInusrelistcode(insureMainListDto.getInusrelistcode());
				  //settleMainListDto.setFareacode(insureMainListDto.getFareacode());
				  
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null==settleMainListDto)
			httpServletRequest.setAttribute("editErrorMessage", "当前保单对应的理赔清单为空！");
		  return settleMainListDto;
	  }
	  /**
	  private SettlemainlistDto getDataFromInsureMainList(InsuremainlistDto insureMainListDto){
		  SettlemainlistDto settleMainListDto = new SettlemainlistDto();
		  settleMainListDto.setInusrelistcode(insureMainListDto.getInusrelistcode());
		  settleMainListDto.setFareacode(insureMainListDto.getFareacode());
		  settleMainListDto.setRiskcode(insureMainListDto.getRiskcode());
		  settleMainListDto.setClasscode(insureMainListDto.getClasscode());
		  return settleMainListDto;
	  }
	  **/
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
	
	  private SettlemainlistDto getDataFromInsureMainList(MedicalInsuremainlistDto insureMainListDto){
		  SettlemainlistDto settleMainListDto = new SettlemainlistDto();
		  settleMainListDto.setInusrelistcode(insureMainListDto.getInusreListCode());
		  //settleMainListDto.setFareacode(insureMainListDto.getFareacode());
		  settleMainListDto.setRiskcode(insureMainListDto.getRiskCode());
		  settleMainListDto.setClasscode(insureMainListDto.getClassCode());
		  return settleMainListDto;
	  }
	/**
	public List getSettleInfoList(HttpServletRequest httpServletRequest,String loadXLS, String editType,List<String> strTitleFieldName){
		List settleInfoTableList = new ArrayList();
		Map settleListMap = (Map)httpServletRequest.getAttribute("settleListMap");
		String listType = (String)settleListMap.get("listType");
		if("SettleList".equals(listType) && !"loadXLS".equals(loadXLS)){//listTable
	     	Collection collectionMedicalSettleList = (Collection)settleListMap.get("listTable");
	     	if(null!=collectionMedicalSettleList && collectionMedicalSettleList.size()>0){
	     		Iterator it = collectionMedicalSettleList.iterator();
	     		int i=1;
	     		while(it.hasNext()){
				    MedicalsettlelistDto medicalsettlelistDto = (MedicalsettlelistDto)it.next();
				    List settleRowInfoList = getSettleRowInfoListFromMedicalSettleList(medicalsettlelistDto,strTitleFieldName);
				    settleInfoTableList.add(settleRowInfoList);
				}
	     	}
		}else if("loadXLS".equals(loadXLS)){
			//listTable
	     	Collection collectionMedicalSettleListTemp = (Collection)settleListMap.get("listTable");
	     	if(null!=collectionMedicalSettleListTemp && collectionMedicalSettleListTemp.size()>0){
	     		Iterator it = collectionMedicalSettleListTemp.iterator();
	     		int i=1;
	     		while(it.hasNext()){
	     			MedicalsettlelisttempDto medicalsettlelistTempDto = (MedicalsettlelisttempDto)it.next();
	     			List settleRowInfoList = getSettleRowInfoListFromMedicalSettleTempList(medicalsettlelistTempDto,strTitleFieldName);
				    settleInfoTableList.add(settleRowInfoList);
	     		}
	     	}
		}
		return settleInfoTableList;
	}

	public List<String> getSettleRowInfoListFromMedicalSettleList (MedicalsettlelistDto medicalsettlelistDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getSettlelistcode()==null?"":medicalsettlelistDto.getSettlelistcode());
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getFcode()==null?"":medicalsettlelistDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getKindcode()==null?"":medicalsettlelistDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getRiskcode()==null?"":medicalsettlelistDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getInsurearea()==0?"0":String.valueOf(medicalsettlelistDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getSuminsured()==0?"0":String.valueOf(medicalsettlelistDto.getSuminsured()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getZhibuka()==null?"":medicalsettlelistDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getFname()==null?"":medicalsettlelistDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getFidcard()==null?"":medicalsettlelistDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getFareacode()==null?"":medicalsettlelistDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getInusrelistcode()==null?"":medicalsettlelistDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getLossrate()==0?"0":String.valueOf(medicalsettlelistDto.getLossrate()));
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getSettlearea()==0?"0":String.valueOf(medicalsettlelistDto.getSettlearea()));
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getSettlesum()==0?"0":String.valueOf(medicalsettlelistDto.getSettlesum()));
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getRemark()==null?"":medicalsettlelistDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getClaimrate()==0?"0":String.valueOf(medicalsettlelistDto.getClaimrate()));
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getIndexofsettle()==0?"0":String.valueOf(medicalsettlelistDto.getIndexofsettle()));
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getPhone()==null?"":medicalsettlelistDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getBank()==null?"":medicalsettlelistDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistDto.getTaxarea()==0?"0":String.valueOf(medicalsettlelistDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = medicalsettlelistDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(i,fieldSourceName);
				}else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(medicalsettlelistDto.getWarrant()==null?"0":medicalsettlelistDto.getWarrant());
			}
		}
		
		return settleRowInfoList;
	}
	**/
	
	/**
	public List<String> getSettleRowInfoListFromMedicalPolicyList (MedicalpolicylistDto medicalPolicyListDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add("");
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getFcode()==null?"":medicalPolicyListDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getKindcode()==null?"":medicalPolicyListDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getRiskcode()==null?"":medicalPolicyListDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getInsurearea()==0?"0":String.valueOf(medicalPolicyListDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getSumamount()==0?"0":String.valueOf(medicalPolicyListDto.getSumamount()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getZhibuka()==null?"":medicalPolicyListDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getFname()==null?"":medicalPolicyListDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getFidcard()==null?"":medicalPolicyListDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getFareacode()==null?"":medicalPolicyListDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getInusrelistcode()==null?"":medicalPolicyListDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add("");
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add("");
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add("");
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getRemark()==null?"":medicalPolicyListDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add("");
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getIndexcode()==null?"0":medicalPolicyListDto.getIndexcode());
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getPhone()==null?"":medicalPolicyListDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getBank()==null?"":medicalPolicyListDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(medicalPolicyListDto.getTaxarea()==0?"0":String.valueOf(medicalPolicyListDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = medicalPolicyListDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(fieldSourceName);
				}
				else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(medicalPolicyListDto.getWarrant()==null?"0":medicalPolicyListDto.getWarrant());
			}
		}
		
		return settleRowInfoList;
	}	  **/
	/**
	public List<String> getSettleRowInfoListFromMedicalSettleTempList (MedicalsettlelisttempDto medicalsettlelistTempDto,List<String> strTitleFieldName){
		List<String> settleRowInfoList = new ArrayList<String>();
		if(null != strTitleFieldName){
			for(int i=0; i < strTitleFieldName.size();i++){
				String fieldName = strTitleFieldName.get(i);
				if("SETTLELISTCODE".equals(fieldName))
					settleRowInfoList.add("");
				else if("FCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getFcode()==null?"":medicalsettlelistTempDto.getFcode());
				else if("KINDCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getKindcode()==null?"":medicalsettlelistTempDto.getKindcode());
				else if("RISKCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getRiskcode()==null?"":medicalsettlelistTempDto.getRiskcode());
				else if("INSUREAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getInsurearea()==0?"0":String.valueOf(medicalsettlelistTempDto.getInsurearea()));
				else if("SUMINSURED".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getSuminsured()==0?"0":String.valueOf(medicalsettlelistTempDto.getSuminsured()));
				else if("ZHIBUKA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getZhibuka()==null?"":medicalsettlelistTempDto.getZhibuka());
				else if("FNAME".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getFname()==null?"":medicalsettlelistTempDto.getFname());
				else if("FIDCARD".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getFidcard()==null?"":medicalsettlelistTempDto.getFidcard());
				else if("FAREACODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getFareacode()==null?"":medicalsettlelistTempDto.getFareacode());
				else if("INUSRELISTCODE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getInusrelistcode()==null?"":medicalsettlelistTempDto.getInusrelistcode());
				else if("LOSSRATE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getLossrate()==0?"0":String.valueOf(medicalsettlelistTempDto.getLossrate()));
				else if("SETTLEAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getSettlearea()==0?"0":String.valueOf(medicalsettlelistTempDto.getSettlearea()));
				else if("SETTLESUM".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getSettlesum()==0?"0":String.valueOf(medicalsettlelistTempDto.getSettlesum()));
				else if("REMARK".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getRemark()==null?"":medicalsettlelistTempDto.getRemark());
				else if("CLAIMRATE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getClaimrate()==0?"0":String.valueOf(medicalsettlelistTempDto.getClaimrate()));
				else if("INDEXOFSETTLE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getIndexofsettle()==0?"0":String.valueOf(medicalsettlelistTempDto.getIndexofsettle()));
				else if("PHONE".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getPhone()==null?"":medicalsettlelistTempDto.getPhone());
				else if("BANK".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getBank()==null?"":medicalsettlelistTempDto.getBank());
				else if("TAXAREA".equals(fieldName))
					settleRowInfoList.add(medicalsettlelistTempDto.getTaxarea()==0?"0":String.valueOf(medicalsettlelistTempDto.getTaxarea()));
				else if("FIELDSOURCE".equals(fieldName)){
					String fieldSource = medicalsettlelistTempDto.getFieldsource();
					String fieldSourceName = "";
					if(null!=fieldSource)
						fieldSourceName = fieldSourceMap.get(fieldSource)==null?"":(String)fieldSourceMap.get(fieldSource);
					settleRowInfoList.add(fieldSourceName);
				}
				else if("WARRANT".equals(fieldName))
				settleRowInfoList.add(medicalsettlelistTempDto.getWarrant()==null?"0":medicalsettlelistTempDto.getWarrant());
			}
		}
		
		return settleRowInfoList;
	}
	**/

}
