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

import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.utils.PlantingSettleExport;
import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.dbsvr.*;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainAgri;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainProp;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.prpall.schema.PrpCmainAgriSchema;
import com.sinosoft.prpall.schema.PrpCmainPropSchema;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;

/**
 * �ַ�HTTP GET
 * <p>Title: ��ֲ�������嵥�ϴ�����</p>
 * <p>Description: ��ֲ�������嵥�ϴ�����</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: GYIC</p>
 * @author 
 * @version 1.0
 */

public class UIClaimGetSettleListFacade0311 extends Action{
	public final static String[] nodeList = {"check","claim","compe"};
	public final static String[] nodeNameList = {"����","����","����"};//1:��������   2��������ת 3�����ѻĵػ�̲Ϳ��
//	public final static Map fieldSourceMap = new HashMap(){{
//	    put("1", "��������");
//	    put("2", "������ת");
//	    put("3", "���ѻĵػ�̲Ϳ��");
//	}};
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)throws Exception{
		  
		  
		  String forward= "success";
		  System.err.println("33333");
		  String isFirst = trimString(httpServletRequest.getParameter("isFirst"));
		  //��һ�ν���ʱ��ɾ����session�е�planting31SettleList����Щ�������������ݡ�
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
					  * ���ݱ�����ȡ�����嵥ͷ������������ֶβ�����ֵ�������������ֻ��һ�������һ�����մ���Ľڵ������жϡ�
					  * ���û���ҵ���Ӧ�������嵥ͷ�����ȡ���±����嵥��
					  */
					 BLSettlemainlistFacade blSettleMainListFacade = new BLSettlemainlistFacade();
					 String sqlCondition = " policyNo like '"+policyNo+"' and validity like '2' ";
					 //���������ŵ��жϣ���ȷ�������ؿ�ʱ����ȡ���Ѿ�����ĵ������嵥��
					 if("compe".equals(nodeType)){
						 if(null!=compensateNo && !"".equals(compensateNo))//�����������ţ�������������ж�
							 sqlCondition += " and compensateNo like '"+compensateNo+"'";
						 else 
							 sqlCondition += " and (compensateNo is null or compensateNo like '') ";
					 }
					 if(null!=registNo && !"".equals(registNo))//����б����ţ����뱨�����ж�
						 sqlCondition += " and REPORTCODE like '"+registNo+"'";
//					 if(null!=claimNo && !"".equals(claimNo))//����������ţ������������ж�
//						 sqlCondition += " and REGISTERCODE like '"+claimNo+"'";
					 sqlCondition += " order by UpdateDate ";
					 System.err.println(sqlCondition);
					 int countOfSettleMainList = blSettleMainListFacade.getCount(sqlCondition);
					 if(0==countOfSettleMainList){//û���ҵ�������Ӧ�������嵥����ѽڵ������-1���ں�߸������ȥȡ�����嵥��
						 httpServletRequest.setAttribute("viewErrorMessage", "��ǰ����"+policyNo+"û�ж�Ӧ�������嵥��");
						 return actionMapping.findForward("message");
					 }else{
						 Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
						 //�����ж��������嵥�İ������ҵ�һ������Ϊ��һ���������Ӧ���嵥��
						 SettlemainlistDto settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
						 	/**
							 * �����жϽڵ�,�������ڵ��������������ж�Ӧ����ӵ�ǰ�ڵ�ȡ���ݣ���ڵ�����Ϊclaim,���claim�е�����������ʾ��
							 * ���claim��û�����ݣ���ȡcheck�е�����������ʾ
							 */
						 String settleListCode = settleMainListDto.getSettlelistcode();
						 claimNo = settleMainListDto.getRegistercode();
						 if(null!=claimNo && !"".equals(claimNo))
							 httpServletRequest.setAttribute("claimNo", claimNo);
						 
						 
						 
						 BLTemblorsettlelistFacade  blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
			
						 //BLTemblor31SettleListFacade blTemblor31SettleListFacade = new BLTemblor31SettleListFacade();
						 String sqlTemblorSettleList = " settleListCode like '"+settleListCode+"' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlTemblorSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlTemblorSettleList += " and "+strSearchCondition;
							 sqlTemblorSettleList = sqlTemblorSettleList + " and nodeType like '"+nodeType+"' and validity like '1' ";
							 PageRecord pageRecordTemblorSettleList = blTemblorsettlelistFacade.findByConditions(sqlTemblorSettleList, currentPageNum, rowsPerPage);
							 if(null!=pageRecordTemblorSettleList && pageRecordTemblorSettleList.getCount()>0){
								int count = blTemblorsettlelistFacade.getCount(sqlTemblorSettleList);
								 settleListMap.put("countRecord", count);
								/// double sumInsuredArea = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "INSUREAREA");
								// settleListMap.put("sumInsuredArea", sumInsuredArea);
								// double sumSettleArea = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "SETTLEAREA");
								// settleListMap.put("sumSettleArea", sumSettleArea);
								 double settleSum = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "SETTLESUM");
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
								 settleListMap.put("listTable", pageRecordTemblorSettleList.getResult());
								 settleListMap.put("mainTable", settleMainListDto);
							 }else{
								 httpServletRequest.setAttribute("viewErrorMessage", "��ǰ�ڵ�û�ж�Ӧ�������嵥��ϸ��");
								 return actionMapping.findForward("message");
							 }
						}
			  	}
		  }
		  else if("edit".equals(editType) && !"loadXLS".equals(loadXLS)){
			  if(null!=policyNo && !"".equals(policyNo) && null!=registNo && !"".equals(registNo) && null!=nodeType && !"".equals(nodeType)){
				 /**
				  * ���ݱ�����ȡ�����嵥ͷ������������ֶβ�����ֵ�������������ֻ��һ�������һ�����մ���Ľڵ������жϡ�
				  * ���û���ҵ���Ӧ�������嵥ͷ�����ȡ���±����嵥��
				  */
				  System.err.println("policyNo:"+policyNo);
				  
				 BLSettlemainlistFacade blSettleMainListFacade = new BLSettlemainlistFacade();
				 String sqlCondition = " policyNo like '"+policyNo+"' and validity like '2' ";
				 int length = nodeList.length;
				 if(null!=compensateNo && !"".equals(compensateNo))//�����������ţ�������������ж�
					 sqlCondition += " and compensateNo like '"+compensateNo+"'";
				 else sqlCondition += " and (compensateNo is null or compensateNo like '') ";//���������ŵ��жϣ���ȷ�������ؿ�ʱ����ȡ���Ѿ�����ĵ������嵥��
				 if(null!=registNo && !"".equals(registNo))//����б����ţ����뱨�����ж�
					 sqlCondition += " and REPORTCODE like '"+registNo+"'";
//				 if(null!=claimNo && !"".equals(claimNo))//����������ţ������������ж�
//					 sqlCondition += " and REGISTERCODE like '"+claimNo+"'";
				 System.err.println("sqlCondition:"+sqlCondition);
				 int countOfSettleMainList = blSettleMainListFacade.getCount(sqlCondition);
				 System.err.println("countOfSettleMainList:"+countOfSettleMainList);
				 if(0==countOfSettleMainList)//û���ҵ�������Ӧ�������嵥����ѽڵ������-1���ں�߸������ȥȡ�����嵥��
					 indexOfNodeType =-1;
				 else if(1!=countOfSettleMainList){
					 httpServletRequest.setAttribute("editErrorMessage", "��ǰ����"+policyNo+"��Ӧ�������嵥��Ψһ��");
					 return actionMapping.findForward("message");
				 }else{
					 Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
					 SettlemainlistDto settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
					 	/**
						 * �����жϽڵ�,�������ڵ��������������ж�Ӧ����ӵ�ǰ�ڵ�ȡ���ݣ���ڵ�����Ϊclaim,���claim�е�����������ʾ��
						 * ���claim��û�����ݣ���ȡcheck�е�����������ʾ
						 */
					 String settleListCode = settleMainListDto.getSettlelistcode();
					 claimNo = settleMainListDto.getRegistercode();
					 if(null!=claimNo && !"".equals(claimNo))
						 httpServletRequest.setAttribute("claimNo", claimNo);
					 
					 BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
					 System.err.println("1:"+indexOfNodeType);
					 //BLTemblor31SettleListFacade blTemblor31SettleListFacade = new BLTemblor31SettleListFacade();
					 while(indexOfNodeType>=0){
						 System.err.println("2:"+indexOfNodeType);
						 String sqlTemblorSettleList = " settleListCode like '"+settleListCode+"' and validity like '1' ";
						 if(null!=kindCode && !"".equals(kindCode))
							 sqlTemblorSettleList += " and kindCode like '"+kindCode+"'";
						  if(!"".equals(strSearchCondition))
							  sqlTemblorSettleList += " and "+strSearchCondition;
						 sqlTemblorSettleList = sqlTemblorSettleList + " and nodeType like '"+nodeList[indexOfNodeType]+"'";
						 System.err.println("3:"+sqlTemblorSettleList);
						 
						 PageRecord pageRecordTemblor31SettleList = blTemblorsettlelistFacade.findByConditions(sqlTemblorSettleList, currentPageNum, rowsPerPage);
						 System.err.println("4:"+pageRecordTemblor31SettleList.getCount());
						 if(null!=pageRecordTemblor31SettleList && pageRecordTemblor31SettleList.getCount()>0){
							 int count = blTemblorsettlelistFacade.getCount(sqlTemblorSettleList);
							 settleListMap.put("countRecord", count);
							 //double sumInsuredArea = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "INSUREAREA");
							 //settleListMap.put("sumInsuredArea", sumInsuredArea);
							 //double sumSettleArea = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "SETTLEAREA");
							 //settleListMap.put("sumSettleArea", sumSettleArea);
							 double settleSum = blTemblorsettlelistFacade.getSum(sqlTemblorSettleList, "SETTLESUM");
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
							 settleListMap.put("listTable", pageRecordTemblor31SettleList.getResult());
							 settleListMap.put("mainTable", settleMainListDto);
							 break;
						 }
						 else indexOfNodeType --;
					 }
				 }
				  if(-1==indexOfNodeType){//-1����û�������嵥����Ҫ��ʾ���������嵥��
					  System.err.println("indexOfNodeType:"+indexOfNodeType);
					  BLPrpCmainProp blPrpCmainProp = new BLPrpCmainProp();
					  blPrpCmainProp.getData(policyNo);
					  
					  Collection collectionCmainProp = blPrpCmainProp.getSchemas();
					  System.err.println("size:"+collectionCmainProp.size());
					  if(null!=collectionCmainProp && collectionCmainProp.size()==1){
						  PrpCmainPropSchema prpCmainPropSchema = (PrpCmainPropSchema)collectionCmainProp.toArray()[0];
						  String insureListCode = prpCmainPropSchema.getHouseCertificate();
						  System.err.println("insureListCode:"+insureListCode);
						  if(null==insureListCode || "".equals(insureListCode)){
							 httpServletRequest.setAttribute("editErrorMessage", "��ǰ����"+policyNo+"û�й��������嵥��");
							 return actionMapping.findForward("message");
						 }
						  BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
						  String sqlInsureMainList = " inusreListCode like '"+insureListCode+"' and validity like '2' ";
						  Collection collectionInsureMainList = blInsureMainListFacade.findByConditions(sqlInsureMainList);
						  if(null!=collectionInsureMainList && collectionInsureMainList.size()==1){
							  InsuremainlistDto insuremainlistDto = (InsuremainlistDto)collectionInsureMainList.toArray()[0];
							  BLTemblorpolicylistFacade blTemblorpolicylistFacade = new BLTemblorpolicylistFacade();
							  
							  //BLTemblor31PolicyListFacade blTemblor31PolicyListFacade = new BLTemblor31PolicyListFacade();
							  sqlInsureMainList = " inusreListCode like '"+insureListCode+"' ";
							  if(!"".equals(strSearchCondition))
								  sqlInsureMainList += " and "+strSearchCondition;
							  //���뱣���嵥��Ч��У�飡
							  sqlInsureMainList += " and validity like '1' ";
							  System.err.println("sqlInsureMainList:"+sqlInsureMainList);
							  System.err.println("currentPageNum:"+currentPageNum);
							  System.err.println("rowsPerPage:"+rowsPerPage);
							  PageRecord pageRecordTemblorPolicyList = blTemblorpolicylistFacade.findByConditions(sqlInsureMainList, currentPageNum, rowsPerPage);
							  if(null!=pageRecordTemblorPolicyList && pageRecordTemblorPolicyList.getCount()>0){
								  int count = blTemblorpolicylistFacade.getCount(sqlInsureMainList);
								  settleListMap.put("countRecord", count);
								  //double sumInsuredArea = blTemblorpolicylistFacade.getSum(sqlInsureMainList,"AREANUMBER");
								  settleListMap.put("sumInsuredArea", 0);
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
								  settleListMap.put("listTable", pageRecordTemblorPolicyList.getResult());
								  settleListMap.put("mainTable", insuremainlistDto);
							  }else {
									 httpServletRequest.setAttribute("editErrorMessage", "��ǰ����"+policyNo+"û�й��������嵥��");
									 return actionMapping.findForward("message");
								 }
						  }else {
							  httpServletRequest.setAttribute("editErrorMessage", "��ǰ����"+policyNo+"��Ӧ�ı����嵥Ϊ�ջ�Ψһ��");
								 return actionMapping.findForward("message");
							 }
					  }else {
						  	 httpServletRequest.setAttribute("editErrorMessage", "��ǰ����"+policyNo+"��Ӧ�ı����嵥Ϊ�ջ�Ψһ��");
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
			  if("loadXLS".equals(loadXLS)){//�����嵥ʱ������ʱ�����������ʾ��
				  SettlemainlistDto settleMainListDto = generateSettleMainList(httpServletRequest);
				  settleListMap.put("mainTable", settleMainListDto);
				  BLTemblorsettlelisttempFacade blTemblorsettlelisttempFacade = new BLTemblorsettlelisttempFacade();
				  //BLTemblor31SettleListTempFacade blTemblor31SettleListTempFacade = new BLTemblor31SettleListTempFacade();
				  String sqlCondition = "registCode = '"+registNo+"' and stringTimeStamp = '"+strTimeStamp+"'";
				  PageRecord pageRecordTemblorSettleList = blTemblorsettlelisttempFacade.findByConditions(sqlCondition, currentPageNum, rowsPerPage);
				  if(null!=pageRecordTemblorSettleList && pageRecordTemblorSettleList.getCount()>0){
					  Collection collectionListTable = pageRecordTemblorSettleList.getResult();
					  int count = blTemblorsettlelisttempFacade.getCount(sqlCondition);
					  if(count>0){
						 totalPageNum = (count-1)/rowsPerPage+1;
					  }else{
						 totalPageNum = 0;
						 currentPageNum = 0;
					  }
					  //double sunInsuredArea = blTemblorsettlelisttempFacade.getSum(sqlCondition, "INSUREAREA");
					  settleListMap.put("sumInsuredArea", 0);
					  //double sumSettleArea = blTemblorsettlelisttempFacade.getSum(sqlCondition, "SETTLEAREA");
					  settleListMap.put("sumSettleArea", 0);
					  double settleSum = blTemblorsettlelisttempFacade.getSum(sqlCondition, "SETTLESUM");
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
			httpServletRequest.setAttribute("editErrorMessage", "��ǰ������Ӧ�������嵥��Ͷ���嵥Ϊ�գ�");
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
