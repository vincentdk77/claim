package com.gyic.claim.utils;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLPrplcombineFacadeBase;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.bl.facade.BLSwfLogFacade;

import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.thirdparty.claim.util.DateTime;
import com.sinosoft.utility.database.DbPool;
import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;

public class Utils {
	/**
	 * 根据保单号和耳标号获取相应的投保单信息，保单号和耳标号不可为空
	 * 1.根据保单号查找投保清单头表的list放入结果集
	 * 2.根据投保清单号和耳标号查找保单清单最新数据表的list放入结果集
	 * @author 张菊卿
	 * @version 1.0HerdpolicylistDto
	 */
	/*public static ArrayList findHerdpolicylist(String policyno,String Earlabel,String kindCode) throws Exception
	{
		ArrayList herdPolicyListResult = new ArrayList();
		ArrayList insureMainListDtoList = new ArrayList();
		ArrayList herdPolicyListDtoList = new ArrayList();
		
		if(policyno==null || Earlabel==null)
		{
			return herdPolicyListResult;
		}

		try
		{
		InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
		
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + policyno + "' and VALIDITY ='2' "; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
		if(insureMainListDtoList != null && insureMainListDtoList.size() >1)
			 throw new UserException(1,3,"保单号:" + policyno + "对应的清单主表记录数不唯一");
		
		BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
		InsuremainlistDto insureMainListDto = (InsuremainlistDto)insureMainListDtoList.get(0);
		String herdpolicylistDtoConditions  = "Earlabel = '" + Earlabel + 
		"' and kindcode = '" + kindCode +
		"' and INUSRELISTCODE = '" + insureMainListDto.getInusrelistcode();
		herdPolicyListDtoList = (ArrayList)bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions); 
		if(herdPolicyListDtoList != null && herdPolicyListDtoList.size() >1)
			 throw new UserException(1,3,"保单号:" + policyno + "对应的清单子表记录数不唯一");
        }

        catch(Exception e){
            throw e;
        }
        finally{
        	herdPolicyListResult.add(insureMainListDtoList);
        	herdPolicyListResult.add(herdPolicyListDtoList);
        	
        }
        return herdPolicyListResult;
    }*/
	/**
	 * 根据保单号和耳标号获取最新清单保额大于0的耳标出险时的清单信息
	 * 1.根据保单号查找投保清单头表的list放入结果集
	 * 2.根据投保清单号和耳标号查找保单清单最新数据表的list放入结果集
	 * @author 张菊卿
	 * @version 1.0HerdpolicylistDto
	 */
	public static ArrayList findEndorseHerdpolicylist(String policyno,String Earlabel,String kindCode,String strDamageDate,String strDamageHour) throws Exception
	{
		ArrayList herdPolicyListResult = new ArrayList();
		ArrayList insureMainListDtoList = new ArrayList();
		ArrayList herdPolicyListDtoList = new ArrayList();
		ArrayList herdEndorsePolicyListDtoList = new ArrayList();
		if(policyno == null || Earlabel == null || kindCode == null || strDamageDate == null || strDamageHour == null)
		{
			throw new UserException(1,3,"参数错误");
		}
		
		InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + policyno + "' and VALIDITY in ('2','3') " +
				"and (STARTTIME <= to_date('"+strDamageDate+"','yyyy-mm-dd') " +
				"and ENDTIME >= to_date('"+strDamageDate+"','yyyy-mm-dd'))"; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
		if(insureMainListDtoList != null && insureMainListDtoList.size() >1)
			 throw new UserException(1,3,"保单号:" + policyno + "对应的清单主表记录数不唯一");
		if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
			BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
			insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
			String herdpolicylistDtoConditions = "Earlabel = '" + Earlabel + 
			"' and kindcode = '" + kindCode +
			"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
			"' and VALIDITY = '1" +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))" +
			"  and not exists (select registno,earno,max(nodeno) from prplcompensateear@sinodb A where  policyno='"+ policyno +
			"' and earno='" + Earlabel + "'" +
			" and exists (select 1 from swflog@sinodb where registno=a.registno and flowstatus!='0' )" +
			" group by registno,earno)";
			herdPolicyListDtoList = (ArrayList)bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions); 
			if(herdPolicyListDtoList != null && herdPolicyListDtoList.size() >1)
				 throw new UserException(1,3,"保单号:" + policyno + "对应的清单子表记录数不唯一");
			if(herdPolicyListDtoList != null && herdPolicyListDtoList.size() == 1)
			{
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				herdpolicylistDto = endorseViewHelper.findForEndorHerdpolicylistBefore(
						(HerdpolicylistDto)herdPolicyListDtoList.get(0),
						kindCode,policyno,strDamageDate,strDamageHour);
				herdEndorsePolicyListDtoList.add(herdpolicylistDto);
			}
		}
    	herdPolicyListResult.add(insureMainListDtoList);
    	herdPolicyListResult.add(herdPolicyListDtoList);
    	herdPolicyListResult.add(herdEndorsePolicyListDtoList);
        return herdPolicyListResult;
    }
	//根据节点类型和报案号从核心系统耳标号清单中找到耳标号列表 20110810 By GYIC 李杨 start！
	public static Collection getPrpLCompensateEarDtoList(String nodeType, String registNo,String businessno){
//		String policyNo, String riskCode 这两个变量在加入对险种的区分的时候使用，现在农业险只有一个险种。
		Collection prpLCompensateEarList = new ArrayList();
		String condition = " RegistNo = '"+registNo+"' and NodeType = '" +nodeType+"'" +" and Businessno = '" +businessno+"'" ;
		BLPrplcompensateearFacade prplcompensateearFacade = new BLPrplcompensateearFacade();
		try {
			prpLCompensateEarList = prplcompensateearFacade.findByConditions(condition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prpLCompensateEarList;
	}
	//根据节点类型和报案号从核心系统耳标号清单中找到耳标号列表 20110810 By GYIC 李杨 End！
	
	
	//检查保单是否在养殖险改造上线之前。 20110810 By GYIC 李杨 start！
	public static boolean checkPolicyBeforeOnlineDate(String policyNo){
		boolean result = false;
		
		
		return result;
	}
	//检查保单是否在养殖险改造上线之前。 20110810 By GYIC 李杨 End！
	
	// 把保单的耳标号列表信息放入核心系统的耳标号列表中。
	/**
	 * @param herdPolicyListDto
	 * @param policyNo
	 * @param nodeType
	 * @param registNo
	 * @param map : 所有表中可以为空的信息都放到map中，再取出放到 dto中。
	 * 				claimNo：         立案号
	 * 				compensateNo：    理算书号
	 * 				combineNo：       事故号（并案号）
	 * 				caseNo：          案件归档号
	 * 				damageStartDate： 出险日期起
	 * 				damageStartHour： 出险开始小时
	 * 				damageEndDate：   出险日期止
	 * 				damageCode：      出险原因代码
	 * 				damageName：      出险原因说明
	 * 				unitAmount：      单位保险金额
	 * 				restFee：         残值
	 * 				claimRate：       赔付比例
	 * 				deductibleRate：  免赔率
	 * 				deductible：      免陪额
	 * 				sumRealpay：      赔偿金额
	 * 				
	 * @return 核心系统耳标号清单Dto： PrplcompensateearDto
	 */
	public static PrplcompensateearDto setHerdPolicyListToPrpLCompensateEar(HerdpolicylistDto herdPolicyListDto, String policyNo, String nodeType, String registNo, Map map){// String combineNo ,String claimNo,String compensateNo, String caseNo){
		PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
		
		prplcompensateearDto.setNodetype(nodeType);
		prplcompensateearDto.setEarno(herdPolicyListDto.getEarlabel());
		prplcompensateearDto.setPolicyno(policyNo);
		prplcompensateearDto.setRegistno(registNo);
		prplcompensateearDto.setClaimno((String)map.get("claimNo"));
		prplcompensateearDto.setCompensateno((String)map.get("compensateNo"));
		prplcompensateearDto.setCombineno((String)map.get("combineNo"));
		prplcompensateearDto.setCaseno((String)map.get("caseNo"));
//		prplcompensateearDto.setDamagestartdate((DateTime)map.get("damageStartDate"));
		prplcompensateearDto.setDamagestarthour((String)map.get("damageStartHour"));
//		prplcompensateearDto.setDamageenddate((DateTime)map.get("damageEndDate"));
		prplcompensateearDto.setDamagecode((String)map.get("damageCode"));
		prplcompensateearDto.setDamagename((String)map.get("damageName"));
		prplcompensateearDto.setName(herdPolicyListDto.getFname());
		prplcompensateearDto.setId_card(herdPolicyListDto.getFidcard());
		prplcompensateearDto.setBank(herdPolicyListDto.getBank());
		prplcompensateearDto.setAccount(herdPolicyListDto.getBankcard());
		if(null!=map.get("unitAmount"))
			prplcompensateearDto.setUnitamount(Double.valueOf((String)map.get("unitAmount")));
		if(null!=map.get("estimateLoss"))
			prplcompensateearDto.setEstimateloss(Double.valueOf((String)map.get("estimateLoss")));
		if(null!=map.get("restFee"))
			prplcompensateearDto.setRestfee(Double.valueOf((String)map.get("restFee")));
		if(null!=map.get("claimRate"))
			prplcompensateearDto.setClaimrate(Double.valueOf((String)map.get("claimRate")));
		if(null!=map.get("deductibleRate"))
			prplcompensateearDto.setDeductiblerate(Double.valueOf((String)map.get("deductibleRate")));
		if(null!=map.get("deductible"))
			prplcompensateearDto.setDeductible(Double.valueOf((String)map.get("deductible")));
		if(null!=map.get("sumRealpay"))
			prplcompensateearDto.setSumrealpay(Double.valueOf((String)map.get("sumRealpay")));

		
		return prplcompensateearDto;
	}
	//校验节点名称和节点状态是否一致
	public static boolean checkNodeStatus(String registNo) throws Exception{
		String nodeStatus="";
		String nodeName="";
		boolean isSameStatus=false;
		BLPrplcombineFacade blcombineFacade=new BLPrplcombineFacade();
		PrplcombineDto combineDto=new PrplcombineDto();
		combineDto=blcombineFacade.findByPrimaryKey(registNo);
		String combineNo=combineDto.getCombineno();
		SwfLogDto swfLogDto=new SwfLogDto();
		BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		ArrayList arrayList=new ArrayList();
		ArrayList arrayList1=new ArrayList();
		ArrayList arrayList2=new ArrayList();
		arrayList=blcombineFacade.findByConbineNo(combineNo);
		for(int i=0;i<arrayList.size();i++){
			swfLogDto=blSwfLogFacade.findByRegistNo(arrayList.get(i).toString());
			nodeStatus=swfLogDto.getNodeStatus();
			arrayList1.add(nodeStatus);
		}
		for(int i=0;i<arrayList.size();i++){
			swfLogDto=blSwfLogFacade.findByRegistNo(arrayList.get(i).toString());
			nodeName=swfLogDto.getNodeName();
			arrayList2.add(nodeName);
		}
		for(int i=0;i<arrayList.size();i++){
			   if((arrayList1.get(1).equals(arrayList1.get(i))!=true)||(arrayList2.get(1).equals(arrayList2.get(i))!=true)){
				    throw new Exception("节点状态不一致，不能合并案件！报案号及各节点状态如下:报案号："+arrayList.get(i)+"节点名称："+arrayList2.get(i)+"节点状态："+arrayList1.get(i)+"");	
			   }else{
				    isSameStatus=true;
				    }
	    }
		
		
		
		return isSameStatus;
	}
	public static PrplcompensateearDto getPrplcompensateearDtobyEarNo(String policyNo, String nodeType, String earNo,String businessno){
		PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
		try {
			String conditions = " policyNo = '"+policyNo +"' and nodeType = '"+nodeType+"' and earNo = '"+earNo+"'"+" and Businessno = '"+businessno+"'";
			System.out.println("conditions is "+conditions);
			BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
			Collection collection = blPrplcompensateearFacade.findByConditions(conditions);
			if(null != collection && collection.toArray().length>0)
				prplcompensateearDto = (PrplcompensateearDto)collection.toArray()[0];
			else return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prplcompensateearDto;
	}
	/**
	 * 根据request和所给的属性名称，返回该属性的字符串值。
	 * 
	 * @param request
	 * @param attributeName
	 * @return
	 */
	public static String getStringValueFromRequest(HttpServletRequest request, String attributeName){
		String result = (String)request.getAttribute(attributeName);
		return result;
	}
	/**
	 * 根据传入的事故号combineNo，找到该事故号下所有的报案号。
	 * 
	 * @param combineNo
	 * @return
	 */
	public static List getRegistNoListByCombineNo(String combineNo){
		List registNoList = new ArrayList();
		BLPrplcombineFacade blCombineFacade=new BLPrplcombineFacade();
		try {
			Collection registNoCollection = blCombineFacade.findByConbineNo(combineNo);
			if(null!=registNoCollection && !registNoCollection.isEmpty()){
				Iterator iterator = registNoCollection.iterator();
				while(iterator.hasNext()){
					registNoList.add(iterator.next());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return registNoList;
	}
	/**
	 * 根据录入的节点名称nodeType,业务号businessNo, 把swflog中的信息放到request中。
	 * 
	 * @param request
	 * @param nodeType
	 * @param businessNo
	 */
	public static void setSwflogInfoToRequestAccordingRegistNo(HttpServletRequest request, String nodeType, String registNo, int index, String editType) throws Exception {
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		SwfLogDto swfLogDto = new SwfLogDto();
		String conditions = " registNo = '"+registNo+"' and nodeType = '"+nodeType+"' and nodestatus !='4'";
		Collection swfLogCollection = null;
		try {
			swfLogCollection = uiWorkFlowAction.findNodesByConditions(conditions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!= swfLogCollection && swfLogCollection.size()==1)
			swfLogDto = (SwfLogDto)swfLogCollection.toArray()[0];
		else
			throw new Exception ("节点异常,报案号："+registNo);
		String swfLogFlowID = swfLogDto.getFlowID();
		request.setAttribute("swfLogFlowID_"+index, swfLogFlowID);
		int swfLogLogNo = swfLogDto.getLogNo();
		request.setAttribute("swfLogLogNo_"+index, swfLogLogNo);
		String status = swfLogDto.getNodeStatus();
		request.setAttribute("status_"+index, status);
		String riskCode = swfLogDto.getRiskCode();
		request.setAttribute("riskCode_"+index, riskCode);
		request.setAttribute("nodeType_"+index, nodeType);
		String businessNo = swfLogDto.getBusinessNo();
		request.setAttribute("businessNo_"+index, businessNo);
		String keyIn = swfLogDto.getKeyIn();
		request.setAttribute("keyIn_"+index, keyIn);
		String policyNo = swfLogDto.getPolicyNo();
		request.setAttribute("policyNo_"+index, policyNo);
		int modelNo = swfLogDto.getModelNo();
		request.setAttribute("modelNo_"+index, modelNo);
		int nodeNo = swfLogDto.getNodeNo();
		request.setAttribute("nodeNo_"+index, nodeNo);
		String dfFlag = swfLogDto.getDfFlag();
		request.setAttribute("dfFlag_"+index, dfFlag);
		request.setAttribute("RegistNo_"+index, registNo);
		String nowEditType = "SHOW";
		if("ADD".equalsIgnoreCase(editType) || "EDIT".equalsIgnoreCase(editType)){
			if("0".equals(status))
				nowEditType = "ADD";
			else if("2".equals(status))
				nowEditType = "EDIT";
		}else {
			if("0".equals(status))
				nowEditType = "ADD";
			else if("4".equals(status))
				nowEditType = "SHOW";
		}
		request.setAttribute("editType_"+index, nowEditType);
		String prpCmainPolicyNo = swfLogDto.getBusinessNo();
		
		if("regis".equals(nodeType)){
			if(("0").equals(status)){
				request.setAttribute("prpCmainPolicyNo_"+index, prpCmainPolicyNo);
			}else {
				String prpLregistRegistNo = swfLogDto.getBusinessNo();
				request.setAttribute("prpLregistRegistNo_"+index, prpLregistRegistNo);
				request.setAttribute("updateExt_"+index, "true");
			}
		}else if("compe".equals(nodeType)){
			String claimNo = swfLogDto.getKeyIn();
			request.setAttribute("ClaimNo_"+index, claimNo);
			String caseType = swfLogDto.getTypeFlag();
			request.setAttribute("caseType_"+index, caseType);
			int compeCount = swfLogDto.getCompeCount();
			request.setAttribute("compeCount_"+index, compeCount);
		}else if("claim".equals(nodeType)){
			if("0".equals(status)){
				String claimNo = swfLogDto.getKeyIn();
				request.setAttribute("ClaimNo_"+index, claimNo);
			}else{
				
			}
		}else if("check".equals(nodeType)){
//			RegistNo="+swfLogDto.getKeyIn()
//                +"&lossItemName="+swfLogDto.getLossItemName()
//                +"&lossItemCode="+swfLogDto.getLossItemCode()
//                +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
			if("0".equals(status)){
				String lossItemName = swfLogDto.getLossItemName();
				request.setAttribute("lossItemName_"+index, lossItemName);
				String lossItemCode = swfLogDto.getLossItemCode();
				request.setAttribute("lossItemCode_"+index, lossItemCode);
				String insureCarFlag = swfLogDto.getInsureCarFlag();
				request.setAttribute("insureCarFlag_"+index, insureCarFlag);
			}else{
				String lossItemName = swfLogDto.getLossItemName();
				request.setAttribute("lossItemName_"+index, lossItemName);
				String lossItemCode = swfLogDto.getLossItemCode();
				request.setAttribute("lossItemCode_"+index, lossItemCode);
				String insureCarFlag = swfLogDto.getInsureCarFlag();
				request.setAttribute("insureCarFlag_"+index, insureCarFlag);
				String type= (String)request.getAttribute("com.sinosoft.type");
				request.setAttribute("type_"+index, type);
				String prpLcheckCheckNo = swfLogDto.getKeyIn();
				request.setAttribute("prpLcheckCheckNo_"+index, prpLcheckCheckNo);
			}
		}else if("certi".equals(nodeType)){
			
		}else if("certa".equals(nodeType)){
			if("0".equals(status)){
				String lossItemName = swfLogDto.getLossItemName();
				request.setAttribute("lossItemName_"+index, lossItemName);
				String lossItemCode = swfLogDto.getLossItemCode();
				request.setAttribute("lossItemCode_"+index, lossItemCode);
				String insureCarFlag = swfLogDto.getInsureCarFlag();
				request.setAttribute("insureCarFlag_"+index, insureCarFlag);
				String lossTypeFlag = swfLogDto.getTypeFlag();
				request.setAttribute("lossTypeFlag_"+index, lossTypeFlag);
			}else {
				String lossItemName = swfLogDto.getLossItemName();
				request.setAttribute("lossItemName_"+index, lossItemName);
				String lossItemCode = swfLogDto.getLossItemCode();
				request.setAttribute("lossItemCode_"+index, lossItemCode);
				String insureCarFlag = swfLogDto.getInsureCarFlag();
				request.setAttribute("insureCarFlag_"+index, insureCarFlag);
				String lossTypeFlag = swfLogDto.getTypeFlag();
				request.setAttribute("lossTypeFlag_"+index, lossTypeFlag);
				request.setAttribute("prpLverifyLossRegistNo_"+index, registNo);
			}
		}
		
	}
	
	public static Collection setSwflogInfoToRequestAccordingCombineNo(HttpServletRequest request, String nodeType, String combineNo, String editType) throws Exception{
		BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
		String conditions = "combineNo = '" + combineNo + "'";
		Collection combineDtos = bLPrplcombineFacade.findByConditions(conditions);
		Iterator iterator = combineDtos.iterator();
		int index=0;
		while(iterator.hasNext()){
			PrplcombineDto prplcombineDto = (PrplcombineDto)iterator.next();
			setSwflogInfoToRequestAccordingRegistNo(request, nodeType, prplcombineDto.getRegistno(), index, editType);
			index++;
		}
		return combineDtos;
	}
	
	public static PrpCvirturlItemSchema findPrpCvirturlItemSchema(String strPolicyNo,String strRiskCode)
	throws Exception {
		Collection collection = new ArrayList();
		 //add by   国元项目组 韦吉亮  2008-05-26   start
        //国元的分户信息保存在prpcvirtutlitem里，所以要从这里面去取值 
          UIPolicyAction uiPolicyAction = new UIPolicyAction();
          //GroupProposalService groupProposalService = new GroupProposalService();
          //是否是团单的标志
          boolean isVirturlItemRisk = GroupProposalService.isGroupProposal(strRiskCode);
         String conditions = " policyno='"+strPolicyNo+"'";
         
          PrpCvirturlItemSchema prpCvirturlItemSchema = new PrpCvirturlItemSchema();
         if(isVirturlItemRisk){       	  
	           collection = uiPolicyAction.findPrpCinsuredViturlItemDtoByConditions(conditions);
			   
	           int recordSize=collection.size();
	           for(Iterator iterator = collection.iterator();iterator.hasNext();)
	           {
	        	   prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
	               break;
             }
	          
         }
         return prpCvirturlItemSchema;
	}
	public static PrpCvirturlItemSchema findPrpCvirturlItemSchema (String strPolicyNo,String strRiskCode,String strFamilyNo,String damageStartDate)
	throws Exception {
		Collection collection = new ArrayList();
		PrpCvirturlItemSchema prpCvirturlItemSchema = new PrpCvirturlItemSchema();
		 String conditions = "";
         //String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = strPolicyNo;
         String thisValue =  "";
         String strBenAcciPerson = strFamilyNo;
         
         //是否是团单的标志
         boolean isVirturlItemRisk = GroupProposalService.isGroupProposal(strRiskCode);
         conditions = " KindName like '%" + thisValue + "%'";
         
	     if("9999".equals(strRiskCode)){
	         if(strBenAcciPerson!=null&&!strBenAcciPerson.equals("")){
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and model like '"+strBenAcciPerson+"' order by Kindcode";
             }else{
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" order by Kindcode";
             }
         }else{
             conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and familyno = '"+strBenAcciPerson+"'  order by Kindcode"; 
         }
         conditions = SqlUtils.getWherePartForGetCount(conditions);
         BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
	     BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new  BLPrpCitemKindAgriFacade();    
	      if(isVirturlItemRisk){
	           collection = (ArrayList)blPrpCitemKindFacade.findVirturlItemByConditions(conditions);
	           int recordSize=collection.size();
	           int itemKindNo=0;
		         for(Iterator iterator = collection.iterator();iterator.hasNext();)
		         {    
		           prpCvirturlItemSchema = (PrpCvirturlItemSchema)iterator.next();
		           String ciSQL = " PolicyNo ='"+ strPolicyNo +"' and KindCode = '"+prpCvirturlItemSchema.getKindCode()+"' ";
		           if(prpCvirturlItemSchema.getRationType()!=null && !"".equals(prpCvirturlItemSchema.getRationType()))
	        	   {
		        	   ciSQL +=" and RationType ='"+prpCvirturlItemSchema.getRationType()+"' ";
	        	   }
		           double sumAmount = blPrpCitemKindFacade.getSumAmount(ciSQL);

		           itemKindNo=  blPrpCitemKindFacade.getItemKindNo(" PolicyNo ='"+ strPolicyNo +"' and KindCode = '"+prpCvirturlItemSchema.getKindCode()+"' ");

		           DecimalFormat idecimalFormat = new DecimalFormat("0.00");
		          
		             if("1".equals(prpCvirturlItemSchema.getVirturlFlag()))
		             {
		            	 //buffer.append(idecimalFormat.format(sumAmount));
		             }else
		             {
		            	// buffer.append(prpCvirturlItemSchema.getAmount());
		             }

	            	 prpCvirturlItemSchema.setItemKindNo(String.valueOf(itemKindNo));
	            	 break;
	           }
         }
       return prpCvirturlItemSchema;
	}
	/**
	 * 打印虚拟机内存使用情况
	 * 
	 * @author qian
	 * @return
	 */
	public void getPhisicaMemory(String buzinessNo)throws Exception{
		  // a)物理内存信息
		  Runtime runtime=Runtime.getRuntime();
		  Date date=new Date(); 
		  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Long Total=0L;
		  Long Used=0L;
		  Long Free=0L;
		  try {
		   Total=(runtime.maxMemory()/ 1024L)/1024L;
		   Used=(runtime.totalMemory() / 1024L)/1024L;
		   Free=(runtime.freeMemory()/ 1024L)/1024L;
		   // 内存总量
		   System.out.println("Total = " + Total + "M av");
		   // 当前内存使用量
		   System.out.println("Used = " + Used + "M used");
		   // 当前内存剩余量
		   System.out.println("Free = " + Free + "M free");
		   // 当前时间
		   System.out.println("currentTime = " + format.format(date));
		   // 当前单号
		   System.out.println("备注：" + buzinessNo);
           if(Free<10){
    	   System.err.println("警告：当前可用内存小于10M");
           }
		   } catch (Exception e) {
		   e.printStackTrace();
		   }
	}
}
