package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagerAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayBillAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeListAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpJpaymentpackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBillFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayHisFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayNoticeListFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayShowFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLbillPayDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.log.PayQueryConditionLogger;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.TurnPageUtil;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;
//import com.sinosoft.payment.bl.action.domain.BLPrpLClaimPaymentAction;
//import com.sinosoft.payment.dto.domain.PrpLClaimPaymentDto;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.platform.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utiall.schema.PrpDriskSchema;
import com.sinosoft.utiall.schema.PrpDriskSchema;
import com.sinosoft.utility.PrpallUtility;
import com.sinosoft.utility.string.Str;
/**
 * 支付信息帮助类
 * @author Administrator
 *
 */
public class PaymentViewHelperNew {
	/**
	 * 赔款类型的对应类
	 * @return
	 * @throws Exception
	 */
	public HashMap getPaymentTypeMap() throws Exception {
		HashMap<String,String> paymentTypeMap = new HashMap<String,String>();
		String payCondition = " codetype='PayRefReason'  and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		for(int i=0;i<paymentTypes.size();i++){
			PrpDcodeDto codeDto = (PrpDcodeDto) paymentTypes.get(i);
			String key = codeDto.getCodeCode();
			String value= codeDto.getCodeCName();
			paymentTypeMap.put(key, value);
		}
		paymentTypeMap.put("P6", "赔款");
		return paymentTypeMap;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public HashMap getRiskCodeMap() throws Exception {
		HashMap<String,String> riskCodeMap = new HashMap<String,String>();
		String condition = " validstatus='1' ";
		BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
		blPrpDrisk.query(condition);
		for(int i=0;i<blPrpDrisk.getSize();i++){
			PrpDriskSchema prpDriskSchema = (PrpDriskSchema) blPrpDrisk.getArr(i);
			String key = prpDriskSchema.getRiskCode();
			String value= prpDriskSchema.getRiskCName();
			riskCodeMap.put(key, value);
		}
		return riskCodeMap;
	}
	/**
	 * 支付状态的Map帮助方法
	 * @return
	 * @throws Exception
	 */
	public Map getVFlagMap() throws Exception {
		Map<String, String> vFlagMap = new HashMap<String,String>();
		vFlagMap.put("0", "");
		vFlagMap.put("1", "支付暂存");
		vFlagMap.put("2", "审批占用");
		vFlagMap.put("3", "审批退回");
		vFlagMap.put("4", "待下发");
		vFlagMap.put("6", "待审批");
		vFlagMap.put("7", "主动撤回");
		vFlagMap.put("8", "待支付");
		vFlagMap.put("9", "财务退回");
		return vFlagMap;
	}
	/**
	 * 验证合并录入的业务号和赔款类型在prplpay表中是否有数据（除去自身）
	 * @param paymentNo 支付编号
	 * @param paymentType 赔偿类型
	 * @param certiNo 业务单号
	 * @return
	 * @throws Exception
	 */
	public int payMerge(String paymentNo,String paymentType,String certiNo)throws Exception{
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		String conditions="  p.compensateno='"+certiNo+"' and p.paymenttype='"+paymentType+"' ";
		if(paymentNo!=null&&!"".equals(paymentNo.trim())){
			conditions += " and serialno<> '"+paymentNo+"' " ;
		}
		Collection collection  =blPrplpayFacade.findByConditions(conditions);
		return collection.size();
	}
	/**
	 * 验证合并录入的业务号和赔款类型在prplpay表中是否有数据（除去自身）
	 * @param paymentNo 支付编号
	 * @param certiNo 业务单号
	 * @return
	 * @throws Exception
	 */
	public int payMerge(String paymentNo,String certiNo)throws Exception{
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		String conditions="  p.compensateno='"+certiNo+"'  ";
		if(paymentNo!=null&&!"".equals(paymentNo.trim())){
			conditions += " and serialno<> '"+paymentNo+"' " ;
		}
		Collection collection  =blPrplpayFacade.findByConditions(conditions);
		return collection.size();
	}
	/**
	 * 预赔、理算环节点击支付信息处理逻辑处理方法
	 * @param request
	 * @throws Exception
	 */
	public void paymainBeforeEdit(HttpServletRequest request) throws Exception{
		String registNo= request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String editType = request.getParameter("editType");
		//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
		String isBtn = request.getParameter("isBtn");
		String [] compensateNos = request.getParameterValues("compensateNo");
		ArrayList<String> certiNos = new ArrayList<String>();
		if(compensateNos!=null&&compensateNos.length>0){
			for(int i=0;i<compensateNos.length;i++){
				certiNos.add(compensateNos[i]);
			}
		}
		BLPrpLpaymainFacade blPrpLpaymainFacade= new BLPrpLpaymainFacade ();
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList<PrpLpaymainDto> resultList = null;
		//String conditions =" paymentno in (select serialno from prplpay  where registno='405063418002012000015')";
		String conditions =" paymentno in (select serialno from prplpay  where registno='"+registNo+"')";
		resultList =(ArrayList<PrpLpaymainDto>)blPrpLpaymainFacade.findByConditions(conditions);
		if(resultList!=null){
			for(int i=0;i<resultList.size();i++){
				PrpLpaymainDto prpLpaymainDto = resultList.get(i);
				String operatorName = uiCodeAction.translateUserCode(prpLpaymainDto.getOperatorCode(), true);
				prpLpaymainDto.setOperatorName(operatorName);
			}
		}
		PrpLpaymainDto prpLpaymainDtoList = new PrpLpaymainDto();
		prpLpaymainDtoList.setResultList(resultList);
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		request.setAttribute("vFlagMap",paymentViewHelper.getVFlagMap());
		request.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap());
		request.setAttribute("prpLpaymainDtoList", prpLpaymainDtoList);
		request.setAttribute("isBtn", isBtn);
		request.setAttribute("editType", editType);
		request.setAttribute("nodeType", nodeType);
		request.setAttribute("registNo", registNo);
		request.setAttribute("compensateNos", certiNos);
		request.setAttribute("thirdPayFlagMap", paymentViewHelper.getThirdPayFlagMap());
	}
	/**
	 * 预赔、理算环节支付信息进入详细页面编辑facade类
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void paymainEditPost(HttpServletRequest httpServletRequest) throws Exception{
		PrpLpaymainDto prpLpaymainDto = new PrpLpaymainDto();
		UICodeAction uiCodeAction = new UICodeAction();
		//String registNo= httpServletRequest.getParameter("registNo");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String editType = httpServletRequest.getParameter("editType");
		
		//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过
		String isBtn = httpServletRequest.getParameter("isBtn");
		boolean judgeFlag = true;
		if(isBtn!=null&&"true".equals(isBtn)) judgeFlag=false;
		String [] registNoReqs = httpServletRequest.getParameterValues("registNo");
		String [] compensateNos = httpServletRequest.getParameterValues("compensateNo");
		UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
		ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
		BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
		ArrayList<String> certiNos = new ArrayList<String>();
		ArrayList<String> registNos = new ArrayList<String>();
		if(compensateNos!=null&&compensateNos.length>0){
			for(int i=0;i<compensateNos.length;i++){
				certiNos.add(compensateNos[i]);
			}
		}
		if(registNoReqs!=null&&registNoReqs.length>0){
			for(int i=0;i<registNoReqs.length;i++){
				registNos.add(registNoReqs[i]);
			}
		}
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		
		String Datatype="linkOne";
		Datatype = httpServletRequest.getParameter("Datatype");
		BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
		String vflag="";
		PrpLpayExtDto prpLpayExtDtoNew = null;
		if("ADD".equals(editType)){
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			prpLpaymainDto.setPayType(payType);
			prpLpaymainDto.setPaymentType(paymentType);
			prpLpaymainDto.setPayType("".equals(prpLpaymainDto.getPayType())?"P5":prpLpaymainDto.getPayType());
			prpLpaymainDto.setPaymentType("".equals(prpLpaymainDto.getPaymentType())?"P6":prpLpaymainDto.getPaymentType());
			//forward = "ADD";
			//System.out.println("@@@@@@@@@@@@@@@@@@======  ADD  =======@@@@@@@@@@@@@@@@@@@");
			BLPrepayFacade blPrepayFacade = new BLPrepayFacade();
			//blPrepayFacade.findByPrimaryKey(compensateNo);
			if(null!=registNos && !"".equals(registNos) && registNos.size()>0){
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(payType, paymentType,user.getComCode(),"",judgeFlag, registNos, certiNos,"0");
			}else{
				System.out.println("操作人："+user.getUserCode()+"--"+user.getUserName());
				PayQueryConditionLogger.payQueryConditionData("paymentViewHeler方法：<br>操作人："+user.getUserCode()+"--"+user.getUserName()+"--支付类型："+payType);
				throw new Exception ("报案号不能为空！");
			}
			
			Datatype = httpServletRequest.getParameter("Datatype");
			if(Datatype!=null&&!"".equals(Datatype)){
				//合并支付时，根据计算书号+赔案类型在prplpay表中查询是否存在对应记录。如果存在支付项目，
				//校验不通过,在赔付信息列表中remove
				if("mergeMany".equals(Datatype)){
					PrpLpayShowDto prpLpayShowDto = null;
					for(int i=prpLpayShowDtoList.size()-1;i>=0;i--){
						prpLpayShowDto = prpLpayShowDtoList.get(i);
						int count  = payMerge("",paymentType, prpLpayShowDto.getCertiNo());
						if(count>0){
							prpLpayShowDtoList.remove(prpLpayShowDto);
						}
					}
					
				}
			}
			//最后一条处理意见
			prpLpayExtDtoNew = new PrpLpayExtDto();
			prpLpayExtDtoNew.setComCode(user.getComCode());
			prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDtoNew.setNodeType(nodeType);
			//String nodeTypeName = "epay".equals(nodeType)?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			String nodeName="";
			if("apay".equals(nodeType)){
				nodeName = "支付录入";
			}else if("vpay".equals(nodeType)){
				nodeName = "支付审批";
			}else{
				nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			}
			prpLpayExtDtoNew.setNodeName(nodeName);
			prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
			//String inputHour = DateTime.current().HOUR_TO_HOUR+":"+DateTime.current().MINUTE_TO_MINUTE+":"+DateTime.current().SECOND_TO_SECOND;
//			StringBuffer bf = new StringBuffer(200);
//			if(registNos!=null&&registNos.size()>0){
//				bf.append(" and registNo in ( ");
//	    		for(int i=0;i<registNos.size();i++){
//	    			if(i!=0)bf.append(" , ");
//	    			bf.append(" '"+registNos.get(i).trim()+"' ");
//	    		}
//	    		bf.append(" ) ");
//	    	}
			String costTime ="";
			String starDate = "";
			//取核赔通过时间，若多个案件，则取最大值
			if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
				if(prpLpayShowDtoList.size()==1){
					starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
				}else{
					for(int i=1;i<prpLpayShowDtoList.size();i++){
						String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
						String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
						int temp =DateCompute.compareDate(bDate,eDate);
						if(temp>=0){
							starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
						}else{
							starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
						}
					}
				}
			}
			
			//endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
			DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
			costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			prpLpayExtDtoNew.setCostTime(costTime);
			prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
			prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
			if("".equals(vflag)){
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("未处理");
			}
		}else if("EDIT".equals(editType)){
			String paymentNo =  httpServletRequest.getParameter("paymentNo");
			prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			String backReason = prpLpaymainDto.getPayRemark();
			if("".equals(prpLpaymainDto.getPayType())&&prpLpaymainDto.getPaymentType().indexOf("P6")>-1){
				prpLpaymainDto.setPayType("P3");
			}else if("".equals(prpLpaymainDto.getPayType())&&"P50".equals(prpLpaymainDto.getPaymentType())){
				prpLpaymainDto.setPayType("P1");
			}
			prpLpaymainDto.setProvinceName(new UICodeAction().getInstance().translateCodeCode("BusinessZone",prpLpaymainDto.getProvinceCode(),true)) ;
			prpLpaymainDto.setCityName(new UICodeAction().getInstance().translateCodeCode("BusinessZone",prpLpaymainDto.getCityCode(),true));
			ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
			ArrayList<String> registNoEdit = new ArrayList<String>();
			ArrayList<String> certiNosEdit = new ArrayList<String>();
			for(int i=0;i<collection.size();i++){
				certiNosEdit.add(collection.get(i).getCompensateno());
				registNoEdit.add(collection.get(i).getRegistno());
			}
			prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(prpLpaymainDto.getPayType(), prpLpaymainDto.getPaymentType(),prpLpaymainDto.getComCode(),paymentNo, judgeFlag,registNoEdit, certiNosEdit,prpLpaymainDto.getVflag());
			if(prpLpaymainDto!=null){
				String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
				prpLpaymainDto.setBankTypeName(bankTypeName);
				
				for(int i=0;i<collection.size();i++){
					certiNos.add(collection.get(i).getCompensateno());
					registNos.add(collection.get(i).getRegistno());
				}
				
				//String registExtSql = "registNo = '"+registNoReqs[0]+"' and taskId = '"+paymentNo+"' and flag<> 'N' "	;
				//prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(registExtSql);
				String payExtSql = " paymentNo = '"+paymentNo+"' and  flag='Y' order by inputdate "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					//String nodeTypeName = "epay".equals(prpLpayExtDtoList.get(i).getNodetype())?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodetype(), true);
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付录入";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else if("back".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "财务退回";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				this.getCostTime(prpLpayExtDtoList, starDate);
				
				
			}
			//最后一条处理意见
			String payExtSql = " paymentNo = '"+paymentNo+"' and flag= 'N' "	;
			Collection payExtList =blPrpLpayExtFacade.findByConditions(payExtSql);
			
			prpLpayExtDtoNew=payExtList.iterator().hasNext()?(PrpLpayExtDto) payExtList.iterator().next():new PrpLpayExtDto();
			//prpLpayExtDtoNew = new PrpLpayExtDto();
			prpLpayExtDtoNew.setComCode(user.getComCode());
			prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDtoNew.setNodeType(nodeType);
			//String nodeTypeName = "epay".equals(nodeType)?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			String nodeName="";
			if("apay".equals(nodeType)){
				nodeName = "支付录入";
			}else if("vpay".equals(nodeType)){
				nodeName = "支付审批";
			}else{
				nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			}
			prpLpayExtDtoNew.setNodeName(nodeName);
			prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
//			
//			StringBuffer bf = new StringBuffer(200);
//			if(registNos!=null&&registNos.size()>0){
//				bf.append(" and registNo in ( ");
//	    		for(int i=0;i<registNos.size();i++){
//	    			if(i!=0)bf.append(" , ");
//	    			bf.append(" '"+registNos.get(i).trim()+"' ");
//	    		}
//	    		bf.append(" ) ");
//	    	}
			//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
			//DateTime endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
			String costTime ="";
			if(prpLpayExtDtoList!=null&&prpLpayExtDtoList.size()>0){
				PrpLpayExtDto prpLpayExtDtolast = prpLpayExtDtoList.get(prpLpayExtDtoList.size()-1);
				String starDate = prpLpayExtDtolast.getInputDate().toString(DateTime.YEAR_TO_SECOND);
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}else{
				//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}
			prpLpayExtDtoNew.setCostTime(costTime);
			prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
			prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
			if("".equals(vflag)){
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("未处理");
			}
			if("".equals(backReason)){
				BLPrpJpaymentpackDetailFacade blPrpJpaymentpackDetailFacade = new BLPrpJpaymentpackDetailFacade();
				String iWherePart = " VISASERIALNO = '"+paymentNo+"' and approveflag <> '3'";
				blPrpJpaymentpackDetailFacade.query(iWherePart);
				if(blPrpJpaymentpackDetailFacade.getSize()>0){
					backReason =  blPrpJpaymentpackDetailFacade.getArr(0).getBackReason();
				}
			}
			PrpLpayExtDto prpLpayExtDtoNew1 = new PrpLpayExtDto();
			if(!"".equals(prpLpaymainDto.getBackDate())&&!"".equals(backReason)){
				prpLpayExtDtoNew1.setComCode(prpLpaymainDto.getBackComCode());
				prpLpayExtDtoNew1.setComCName(new UICodeAction().translateComCode(prpLpaymainDto.getBackComCode(), true));
				prpLpayExtDtoNew1.setInputDate(prpLpaymainDto.getBackDate());
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(prpLpaymainDto.getBackDate().toString(), now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew1.setCostTime(costTime);
				prpLpayExtDtoNew1.setNotionCode("9");
				prpLpayExtDtoNew1.setNotionName("下发修改");
				prpLpayExtDtoNew1.setNodeType("back");
				prpLpayExtDtoNew1.setNodeName("财务退回");
				prpLpayExtDtoNew1.setContext(backReason);
				prpLpayExtDtoNew1.setSerialNo(prpLpayExtDtoList.size()+1);
				prpLpayExtDtoNew1.setOperatorCode(prpLpaymainDto.getBackOperatorCode());
				prpLpayExtDtoNew1.setFlag("Y");
				prpLpayExtDtoNew1.setOperatorCodeName(new UICodeAction().translateUserCode(prpLpaymainDto.getBackOperatorCode(), true));
				prpLpayExtDtoList.add(prpLpayExtDtoNew1);
			}
			
			
		}else if("SHOW".equals(editType)){
			String paymentNo =  httpServletRequest.getParameter("paymentNo");
			prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			String claimNoHis = "";
			String compensateNoHis = "";
			String payTypeHis = "";
			String backReason = prpLpaymainDto.getPayRemark();
			if(prpLpaymainDto!=null){
				String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
				prpLpaymainDto.setBankTypeName(bankTypeName);
				String payFlag  = "";
				ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
				for(int i=0;i<collection.size();i++){
					certiNos.add(collection.get(i).getCompensateno());
					registNos.add(collection.get(i).getRegistno());
					payFlag = collection.get(i).getPayflag();
					claimNoHis = collection.get(i).getClaimno();
					compensateNoHis = collection.get(i).getCompensateno();
					payTypeHis = collection.get(i).getPaytype();
				}
				BLPrpLpayHisFacade blPrpLpayHisFacade = new BLPrpLpayHisFacade();
				String conditions = " claimNo = '"+claimNoHis+"' and compensateNo = '"+compensateNoHis+"' and payType ='"+payTypeHis+"' and serialno<>'"+paymentNo+"' order by serialNo2 desc ";
				ArrayList<PrpLpayHisDto>  prpLpayHisDtoList = (ArrayList)blPrpLpayHisFacade.findByConditions(conditions);
				PrpLpayHisDto prpLpayHisDto = new PrpLpayHisDto() ;
				if(prpLpayHisDtoList.size()>0){
					prpLpayHisDto = prpLpayHisDtoList.get(0);
				}
				httpServletRequest.setAttribute("prpLpayHisDto", prpLpayHisDto);
				prpLpaymainDto.setPayFlag(payFlag);//此数据从prplpay表中获取，因为收付系统只会对应prplpay表内容
				String payExtSql = " paymentNo = '"+paymentNo+"'  "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "新增支付";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(prpLpaymainDto.getPayType(), prpLpaymainDto.getPaymentType(),prpLpaymainDto.getComCode(),paymentNo, judgeFlag,registNos, certiNos,"4");
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				this.getCostTime(prpLpayExtDtoList, starDate);
			}
			if("".equals(backReason)){
				BLPrpJpaymentpackDetailFacade blpaymentpackDetailFacade = new BLPrpJpaymentpackDetailFacade();
				String iWherePart = " VISASERIALNO = '"+paymentNo+"'";
				blpaymentpackDetailFacade.query(iWherePart);
				if(blpaymentpackDetailFacade.getSize()>0){
					backReason =  blpaymentpackDetailFacade.getArr(0).getBackReason();
				}
			}
			httpServletRequest.setAttribute("backReason", backReason);
		}
		//合并支付时，领款人类型选项中无被保险人选项。
		if(!"mergeMany".equals(Datatype)&&!"SHOW".equals(editType)){
			if("ADD".equals(editType)){
				PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNoReqs[0]);
				String  bbxrInsuredType = "";
				ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNoReqs[0]+"') and insuredflag = '1' ");
				if(insuredList!=null && !insuredList.isEmpty()){
					bbxrInsuredType=insuredList.get(0).getInsuredType();
				}
				httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);
				httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
				httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
				httpServletRequest.setAttribute("registNo", registNoReqs[0]);
			}else{
				String paymentNo =  httpServletRequest.getParameter("paymentNo");
				ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
				if(collection!=null&&!collection.isEmpty()){
					String registNo = collection.get(0).getRegistno();
					PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
					String  bbxrInsuredType = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo+"') and insuredflag = '1' ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//被保险人类型
					httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
					httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
					httpServletRequest.setAttribute("registNo", registNo);
				}
				
			}
		}else{
			if(prpLpayShowDtoList!=null&&!prpLpayShowDtoList.isEmpty()){
				String insuredName = "";
				String registNo = "";
				boolean hasbbxrSelect = false;
				insuredName = prpLpayShowDtoList.get(0).getInsuredName();
				registNo = prpLpayShowDtoList.get(0).getRegistNo();
				for(int i=0;i<prpLpayShowDtoList.size();i++){
					if(!insuredName.equals(prpLpayShowDtoList.get(i).getInsuredName())){
						hasbbxrSelect = false;
					}else{
						hasbbxrSelect = true;
						continue;
					}
				}
				if(hasbbxrSelect){
					String  bbxrInsuredType = "";
					String insuredCode = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo+"') and insuredflag = '1' ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
						insuredCode =insuredList.get(0).getInsuredCode(); 
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//被保险人类型
					httpServletRequest.setAttribute("insuredCode", insuredCode);
					httpServletRequest.setAttribute("insuredName", insuredName);
					httpServletRequest.setAttribute("hasbbxrSelect", hasbbxrSelect);
				}
			}
		}
		//此处参见ClaimProcessDto.java getPayInfo()方法   第696行
		String payCondition = "codetype='NewPayRefReason' and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		httpServletRequest.setAttribute("paymentTypes",paymentTypes);
		httpServletRequest.setAttribute("prpLpaymainDto", prpLpaymainDto);
		httpServletRequest.setAttribute("prpLpayShowDtoList", prpLpayShowDtoList);
		httpServletRequest.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
		httpServletRequest.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
		httpServletRequest.setAttribute("isBtn", isBtn);
		httpServletRequest.setAttribute("editType", editType);
		httpServletRequest.setAttribute("nodeType", nodeType);
		httpServletRequest.setAttribute("Datatype", Datatype);//是否为合并支付
		httpServletRequest.setAttribute("paymentTypeMap",getPaymentTypeMap());//增加支付原因映射
		httpServletRequest.setAttribute("compensateNos", certiNos);
		
		
	}
	
	public void paymainBillEditPost(HttpServletRequest httpServletRequest)throws Exception{
		String editType = httpServletRequest.getParameter("editType");
		String nodeType= httpServletRequest.getParameter("nodeType");
		String back = httpServletRequest.getParameter("back");
		String Datatype = "";
		String vflag="";
		String registNo="";
		String policyNo="";
		String compensateNo="";
		String payName="";
		String identifyNumber="";
		double sumPaid=0.00;
		double payAmount=0.00;
		PrpLpayExtDto prpLpayExtDtoNew = null;
		PrpLpaymainDto prpLpaymainDto = new PrpLpaymainDto();
		UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
		ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
		BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
		BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
		UICodeAction uiCodeAction = new UICodeAction();
		if("ADD".equals(editType)){
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			int index = Integer.parseInt(httpServletRequest.getParameter("CheckTask"));
			String[] registNoes = httpServletRequest.getParameterValues("registNo");
			String[] policyNoes = httpServletRequest.getParameterValues("policyNo");
			String[] compensateNoes = httpServletRequest.getParameterValues("compensateNo");
			String[] payNamees = httpServletRequest.getParameterValues("payName");
			String[] identifyNumberes = httpServletRequest.getParameterValues("identifyNumber");
			String[] sumPaides = httpServletRequest.getParameterValues("sumPaid");
			String[] payAmountes = httpServletRequest.getParameterValues("payAmount");
			registNo = registNoes[index];
			policyNo = policyNoes[index];
			compensateNo = compensateNoes[index];
			payName = payNamees[index];
			identifyNumber = identifyNumberes[index];
			sumPaid = Double.parseDouble(sumPaides[index]);
			payAmount = Double.parseDouble(payAmountes[index]);
			try {
				String[] compensateNos = compensateNo.split(",");
				String strCompensateNo = "";
				if(compensateNos!=null){
					for(int i=0;i<compensateNos.length;i++){
						if(i!=0){
							strCompensateNo += " , ";
						}
						strCompensateNo += "'"+compensateNos[i]+"'";
					}
				}
				String conditions = " 1=1 and registNo ='"+registNo+"' and compensateNo in ("+strCompensateNo+") and payName='"+payName+"' and identifyNumber ='"+identifyNumber+"'";
				ArrayList prpLclaimBillManagerList = (ArrayList)blPrpLclaimBillManagerFacade.findByConditions(conditions);
				PrpLclaimBillManagerDto prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
				if(prpLclaimBillManagerList.size()>0){
					prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0);
				}
				prpLpaymainDto.setPayType(payType);
				prpLpaymainDto.setPaymentType(paymentType);
				prpLpaymainDto.setPayType("".equals(prpLpaymainDto.getPayType())?"P3":prpLpaymainDto.getPayType());
				prpLpaymainDto.setPaymentType("".equals(prpLpaymainDto.getPaymentType())?"P60":prpLpaymainDto.getPaymentType());
				prpLpaymainDto.setReceiverTypeOther("t01");
				prpLpaymainDto.setReceiverFullName("被保险人");
				prpLpaymainDto.setReceiverFullName(payName);
				prpLpaymainDto.setPayAmount(payAmount);
				prpLpaymainDto.setBankType(prpLclaimBillManagerDto.getBankName());
				prpLpaymainDto.setBank(prpLclaimBillManagerDto.getOpenBank());
				prpLpaymainDto.setAccountType(prpLclaimBillManagerDto.getAccountType());
				prpLpaymainDto.setCertifType("01");
				prpLpaymainDto.setCertifNo(prpLclaimBillManagerDto.getIdentifyNumber());
				prpLpaymainDto.setBankAccount(prpLclaimBillManagerDto.getBankAccount());
				prpLpaymainDto.setProvinceCode(prpLclaimBillManagerDto.getProvinceName());
				prpLpaymainDto.setCityCode(prpLclaimBillManagerDto.getCityName());
				//forward = "ADD";
				//System.out.println("@@@@@@@@@@@@@@@@@@======  ADD  =======@@@@@@@@@@@@@@@@@@@");
				BLPrepayFacade blPrepayFacade = new BLPrepayFacade();
				//blPrepayFacade.findByPrimaryKey(compensateNo);
				boolean flag = true;
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowBillList(payType, paymentType,user.getComCode(),"",payName,identifyNumber,flag, registNo, strCompensateNo,"0",back);
				Datatype = httpServletRequest.getParameter("Datatype");
				if(Datatype!=null&&!"".equals(Datatype)){
					//合并支付时，根据计算书号+赔案类型在prplpay表中查询是否存在对应记录。如果存在支付项目，
					//校验不通过,在赔付信息列表中remove
					if("mergeMany".equals(Datatype)){
						PrpLpayShowDto prpLpayShowDto = null;
						for(int i=prpLpayShowDtoList.size()-1;i>=0;i--){
							prpLpayShowDto = prpLpayShowDtoList.get(i);
							int count  = payMerge("",paymentType, prpLpayShowDto.getCertiNo());
							if(count>0){
								prpLpayShowDtoList.remove(prpLpayShowDto);
							}
						}
						
					}
				}
				//最后一条处理意见
				prpLpayExtDtoNew = new PrpLpayExtDto();
				prpLpayExtDtoNew.setComCode(user.getComCode());
				prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
				prpLpayExtDtoNew.setNodeType(nodeType);
				//String nodeTypeName = "epay".equals(nodeType)?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
				String nodeName="";
				if("apay".equals(nodeType)){
					nodeName = "支付录入";
				}else if("vpay".equals(nodeType)){
					nodeName = "支付审批";
				}else{
					nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
				}
				prpLpayExtDtoNew.setNodeName(nodeName);
				prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
				String costTime ="";
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew.setCostTime(costTime);
				prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
				prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
				if("".equals(vflag)){
					prpLpayExtDtoNew.setNotionCode("0");
					prpLpayExtDtoNew.setNotionName("未处理");
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}else if("EDIT".equals(editType)){
			String paymentNo =  httpServletRequest.getParameter("paymentNo");
			prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			String backReason = prpLpaymainDto.getPayRemark();
			if("".equals(prpLpaymainDto.getPayType())&&prpLpaymainDto.getPaymentType().indexOf("P6")>-1){
				prpLpaymainDto.setPayType("P3");
			}else if("".equals(prpLpaymainDto.getPayType())&&"P50".equals(prpLpaymainDto.getPaymentType())){
				prpLpaymainDto.setPayType("P1");
			}
			prpLpaymainDto.setProvinceName(new UICodeAction().getInstance().translateCodeCode("BusinessZone",prpLpaymainDto.getProvinceCode(),true)) ;
			prpLpaymainDto.setCityName(new UICodeAction().getInstance().translateCodeCode("BusinessZone",prpLpaymainDto.getCityCode(),true));
			ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
			ArrayList<String> registNoEdit = new ArrayList<String>();
			ArrayList<String> certiNosEdit = new ArrayList<String>();
			String strCompensateNo = "";
			for(int i=0;i<collection.size();i++){
				if(i!=0){
					strCompensateNo += " , ";
				}
				strCompensateNo += "'"+collection.get(i).getCompensateno()+"'";
				registNo = collection.get(i).getRegistno();
				payName = collection.get(i).getReceiverfullname();
				identifyNumber = collection.get(i).getCertifno();
			}
			boolean flag = true;
			prpLpayShowDtoList = blPrpLpayShowFacade.getShowBillList(prpLpaymainDto.getPayType(), prpLpaymainDto.getPaymentType(),user.getComCode(),paymentNo,payName,identifyNumber,flag, registNo, strCompensateNo,prpLpaymainDto.getVflag(),back);
			if(prpLpaymainDto!=null){
				String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
				prpLpaymainDto.setBankTypeName(bankTypeName);
				String payExtSql = " paymentNo = '"+paymentNo+"' and  flag='Y' order by inputdate "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付录入";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else if("back".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "财务退回";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				this.getCostTime(prpLpayExtDtoList, starDate);
				
				
			}
			//最后一条处理意见
			String payExtSql = " paymentNo = '"+paymentNo+"' and flag= 'N' "	;
			Collection payExtList =blPrpLpayExtFacade.findByConditions(payExtSql);
			
			prpLpayExtDtoNew=payExtList.iterator().hasNext()?(PrpLpayExtDto) payExtList.iterator().next():new PrpLpayExtDto();
			//prpLpayExtDtoNew = new PrpLpayExtDto();
			prpLpayExtDtoNew.setComCode(user.getComCode());
			prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
			prpLpayExtDtoNew.setNodeType(nodeType);
			//String nodeTypeName = "epay".equals(nodeType)?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			String nodeName="";
			if("apay".equals(nodeType)){
				nodeName = "支付录入";
			}else if("vpay".equals(nodeType)){
				nodeName = "支付审批";
			}else{
				nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
			}
			prpLpayExtDtoNew.setNodeName(nodeName);
			prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
//			
//			StringBuffer bf = new StringBuffer(200);
//			if(registNos!=null&&registNos.size()>0){
//				bf.append(" and registNo in ( ");
//	    		for(int i=0;i<registNos.size();i++){
//	    			if(i!=0)bf.append(" , ");
//	    			bf.append(" '"+registNos.get(i).trim()+"' ");
//	    		}
//	    		bf.append(" ) ");
//	    	}
			//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
			//DateTime endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
			String costTime ="";
			if(prpLpayExtDtoList!=null&&prpLpayExtDtoList.size()>0){
				PrpLpayExtDto prpLpayExtDtolast = prpLpayExtDtoList.get(prpLpayExtDtoList.size()-1);
				String starDate = prpLpayExtDtolast.getInputDate().toString(DateTime.YEAR_TO_SECOND);
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}else{
				//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}else{
								starDate=prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							}
						}
					}
				}
				
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
			}
			prpLpayExtDtoNew.setCostTime(costTime);
			prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
			prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
			if("".equals(vflag)){
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("未处理");
			}
			if("".equals(backReason)){
				BLPrpJpaymentpackDetailFacade blPrpJpaymentpackDetailFacade = new BLPrpJpaymentpackDetailFacade();
				String iWherePart = " VISASERIALNO = '"+paymentNo+"'";
				blPrpJpaymentpackDetailFacade.query(iWherePart);
				if(blPrpJpaymentpackDetailFacade.getSize()>0){
					backReason =  blPrpJpaymentpackDetailFacade.getArr(0).getBackReason();
				}
			}
			PrpLpayExtDto prpLpayExtDtoNew1 = new PrpLpayExtDto();
			if(!"".equals(prpLpaymainDto.getBackDate())&&!"".equals(backReason)){
				prpLpayExtDtoNew1.setComCode(prpLpaymainDto.getBackComCode());
				prpLpayExtDtoNew1.setComCName(new UICodeAction().translateComCode(prpLpaymainDto.getBackComCode(), true));
				prpLpayExtDtoNew1.setInputDate(prpLpaymainDto.getBackDate());
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(prpLpaymainDto.getBackDate().toString(), now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew1.setCostTime(costTime);
				prpLpayExtDtoNew1.setNotionCode("9");
				prpLpayExtDtoNew1.setNotionName("下发修改");
				prpLpayExtDtoNew1.setNodeType("back");
				prpLpayExtDtoNew1.setNodeName("财务退回");
				prpLpayExtDtoNew1.setContext(backReason);
				prpLpayExtDtoNew1.setSerialNo(prpLpayExtDtoList.size()+1);
				prpLpayExtDtoNew1.setOperatorCode(prpLpaymainDto.getBackOperatorCode());
				prpLpayExtDtoNew1.setFlag("Y");
				prpLpayExtDtoNew1.setOperatorCodeName(new UICodeAction().translateUserCode(prpLpaymainDto.getBackOperatorCode(), true));
				prpLpayExtDtoList.add(prpLpayExtDtoNew1);
			}
			
			
		}else if("SHOW".equals(editType)){
			String paymentNo =  httpServletRequest.getParameter("paymentNo");
			prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
			String claimNoHis = "";
			String compensateNoHis = "";
			String payTypeHis = "";
			String backReason = prpLpaymainDto.getPayRemark();
			if(prpLpaymainDto!=null){
				String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
				prpLpaymainDto.setBankTypeName(bankTypeName);
				String payFlag  = "";
				ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
				String strCompensateNo = "";
				for(int i=0;i<collection.size();i++){
					if(i!=0){
						strCompensateNo += " , ";
					}
					strCompensateNo += "'"+collection.get(i).getCompensateno()+"'";
					registNo = collection.get(i).getRegistno();
					payName = collection.get(i).getReceiverfullname();
					identifyNumber = collection.get(i).getCertifno();
					payFlag = collection.get(i).getPayflag();
					claimNoHis = collection.get(i).getClaimno();
					compensateNoHis = collection.get(i).getCompensateno();
					payTypeHis = collection.get(i).getPaytype();
				}
				BLPrpLpayHisFacade blPrpLpayHisFacade = new BLPrpLpayHisFacade();
				String conditions = " claimNo = '"+claimNoHis+"' and compensateNo = '"+compensateNoHis+"' and payType ='"+payTypeHis+"' and serialno<>'"+paymentNo+"' order by serialNo2 desc ";
				ArrayList<PrpLpayHisDto>  prpLpayHisDtoList = (ArrayList)blPrpLpayHisFacade.findByConditions(conditions);
				PrpLpayHisDto prpLpayHisDto = new PrpLpayHisDto() ;
				if(prpLpayHisDtoList.size()>0){
					prpLpayHisDto = prpLpayHisDtoList.get(0);
				}
				httpServletRequest.setAttribute("prpLpayHisDto", prpLpayHisDto);
				prpLpaymainDto.setPayFlag(payFlag);//此数据从prplpay表中获取，因为收付系统只会对应prplpay表内容
				String payExtSql = " paymentNo = '"+paymentNo+"'  "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "新增支付";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				boolean flag = true;
				prpLpayShowDtoList = blPrpLpayShowFacade.getShowBillList(prpLpaymainDto.getPayType(), prpLpaymainDto.getPaymentType(),user.getComCode(),paymentNo,payName,identifyNumber,flag, registNo, strCompensateNo,"4","0");
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayShowDtoList.get(i).getUnderWriteEndDate(),prpLpayShowDtoList.get(i-1).getUnderWriteEndDate());
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				this.getCostTime(prpLpayExtDtoList, starDate);
			}
			if("".equals(backReason)){
				BLPrpJpaymentpackDetailFacade blpaymentpackDetailFacade = new BLPrpJpaymentpackDetailFacade();
				String iWherePart = " VISASERIALNO = '"+paymentNo+"'";
				blpaymentpackDetailFacade.query(iWherePart);
				if(blpaymentpackDetailFacade.getSize()>0){
					backReason =  blpaymentpackDetailFacade.getArr(0).getBackReason();
				}
			}
			httpServletRequest.setAttribute("backReason", backReason);
		}
		if(!"mergeMany".equals(Datatype)&&!"SHOW".equals(editType)){
			if("ADD".equals(editType)){
				PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
				String  bbxrInsuredType = "";
				ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo+"') ");
				if(insuredList!=null && !insuredList.isEmpty()){
					bbxrInsuredType=insuredList.get(0).getInsuredType();
				}
				httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);
				httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
				httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
				httpServletRequest.setAttribute("registNo", registNo);
			}else{
				String paymentNo =  httpServletRequest.getParameter("paymentNo");
				ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
				if(collection!=null&&!collection.isEmpty()){
					String registNo1 = collection.get(0).getRegistno();
					PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
					String  bbxrInsuredType = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo1+"') ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//被保险人类型
					httpServletRequest.setAttribute("insuredCode", prpLregistDto.getInsuredCode());
					httpServletRequest.setAttribute("insuredName", prpLregistDto.getInsuredName());
					httpServletRequest.setAttribute("registNo", registNo);
				}
				
			}
		}else{
			if(prpLpayShowDtoList!=null&&!prpLpayShowDtoList.isEmpty()){
				String insuredName = "";
				String registNo1 = "";
				boolean hasbbxrSelect = false;
				insuredName = prpLpayShowDtoList.get(0).getInsuredName();
				registNo = prpLpayShowDtoList.get(0).getRegistNo();
				for(int i=0;i<prpLpayShowDtoList.size();i++){
					if(!insuredName.equals(prpLpayShowDtoList.get(i).getInsuredName())){
						hasbbxrSelect = false;
					}else{
						hasbbxrSelect = true;
						continue;
					}
				}
				if(hasbbxrSelect){
					String  bbxrInsuredType = "";
					String insuredCode = "";
					ArrayList<PrpCinsuredDto> insuredList  = (ArrayList<PrpCinsuredDto>) new BLPrpCinsuredFacade().findByConditions(" policyNo in (select policyno from prplregistrpolicy where registno='"+registNo1+"') ");
					if(insuredList!=null && !insuredList.isEmpty()){
						bbxrInsuredType=insuredList.get(0).getInsuredType();
						insuredCode =insuredList.get(0).getInsuredCode(); 
					}
					httpServletRequest.setAttribute("bbxrInsuredType", bbxrInsuredType);//被保险人类型
					httpServletRequest.setAttribute("insuredCode", insuredCode);
					httpServletRequest.setAttribute("insuredName", insuredName);
					httpServletRequest.setAttribute("hasbbxrSelect", hasbbxrSelect);
				}
			}
		}
		String payCondition = "codetype='NewPayRefReason' and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		httpServletRequest.setAttribute("paymentTypes",paymentTypes);
		httpServletRequest.setAttribute("prpLpaymainDto", prpLpaymainDto);
		httpServletRequest.setAttribute("prpLpayShowDtoList", prpLpayShowDtoList);
		httpServletRequest.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
		httpServletRequest.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
		httpServletRequest.setAttribute("editType", editType);
		httpServletRequest.setAttribute("nodeType", nodeType);
		httpServletRequest.setAttribute("Datatype", Datatype);//是否为合并支付
		httpServletRequest.setAttribute("paymentTypeMap",getPaymentTypeMap());//增加支付原因映射
		httpServletRequest.setAttribute("compensateNos", compensateNo);
		httpServletRequest.setAttribute("back", back);
	
	}
	/**
	 * 两核系统支付信息进入详细页面编辑facade类
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void paymainPostEditFromUndwrt(HttpServletRequest request) throws Exception{
		//记录从哪个页面转发过来  from 为undwrt  是双核发的请求
        String from =request.getParameter("from");
        String paymentNo =  request.getParameter("paymentNo");
        String nodeType =  request.getParameter("nodeType");
        String editType =  request.getParameter("editType");
        String undwrtEditType =  request.getParameter("undwrtEditType");
        UICodeAction uiCodeAction = new UICodeAction();
        BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
        PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(paymentNo);
        ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
		BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
        ArrayList<String> certiNos = new ArrayList<String>();
		ArrayList<String> registNos = new ArrayList<String>();
		PrpLpayExtDto prpLpayExtDtoNew = null;
		if(prpLpaymainDto!=null){
			String claimNoHis = "";
			String compensateNoHis = "";
			String payTypeHis = "";
			String bankTypeName = uiCodeAction.translateCodeCode("BankCode", prpLpaymainDto.getBankType(), true);
			prpLpaymainDto.setBankTypeName(bankTypeName);
			ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayFacade.findByConditions(" serialno='"+paymentNo+"'");
			for(int i=0;i<collection.size();i++){
				certiNos.add(collection.get(i).getCompensateno());
				registNos.add(collection.get(i).getRegistno());
				claimNoHis = collection.get(i).getClaimno();
				compensateNoHis = collection.get(i).getCompensateno();
				payTypeHis = collection.get(i).getPaytype();
			}
			prpLpayShowDtoList = blPrpLpayShowFacade.getShowList(prpLpaymainDto.getPayType(), prpLpaymainDto.getPaymentType(),prpLpaymainDto.getComCode(),paymentNo, true,registNos, certiNos,"4");
			BLPrpLpayHisFacade blPrpLpayHisFacade = new BLPrpLpayHisFacade();
			String conditions = " claimNo = '"+claimNoHis+"' and compensateNo = '"+compensateNoHis+"' and payType ='"+payTypeHis+"' order by serialNo2 desc ";
			ArrayList<PrpLpayHisDto>  prpLpayHisDtoList = (ArrayList)blPrpLpayHisFacade.findByConditions(conditions);
			PrpLpayHisDto prpLpayHisDto = new PrpLpayHisDto() ;
			if(prpLpayHisDtoList.size()>0){
				prpLpayHisDto = prpLpayHisDtoList.get(0);
			}
			request.setAttribute("prpLpayHisDto", prpLpayHisDto);
			String inputHour = "";
			//如果在两核系统中的editType是支付审批，则此处支付状态为支付占用
			if("deal".equals(undwrtEditType)){
				UserDto user  = (UserDto) request.getSession().getAttribute("user");
				if("6".equals(prpLpaymainDto.getVflag())){
					//如果在两核系统中的editType是支付审批，则此处支付状态为支付占用
					new BLPrplpayFacade().updateVFlag("2", paymentNo);//更新为正在审核状态
					new BLPrpLpaymainFacade().updateByKey(paymentNo, "2");
					//插入支付占用处理意见的操作
//					PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();
//					prpLpayExtDto.setPaymentNo(paymentNo);
//					int count = new BLPrpLpayExtFacade().getCount(" paymentNo='"+paymentNo+"' ")+1;
//					prpLpayExtDto.setSerialNo(count);
//					prpLpayExtDto.setComCode(user.getComCode());
//					prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
//					prpLpayExtDto.setNodeType("vpay");
//					prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
//					prpLpayExtDto.setOperatorCode(user.getUserCode());
//					prpLpayExtDto.setOperatorCodeName(user.getUserName());
//					prpLpayExtDto.setFlag("Y");
//					prpLpayExtDto.setNotionCode("2");
//					prpLpayExtDto.setNotionName("支付占用");
//					prpLpayExtDto.setContext("支付占用");
//					new BLPrpLpayExtFacade().insert(prpLpayExtDto);
				} 	
				String paytExtSql = " paymentNo = '"+paymentNo+"' order by inputdate "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(paytExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					//String nodeTypeName = "epay".equals(prpLpayExtDtoList.get(i).getNodetype())?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodetype(), true);
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "新增支付";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				//Collection col  = new BLPrpLclaimFacade().findByConditions(" 1=1 "+bf.toString()+" order by endcasedate desc ");
				//DateTime endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
				
				this.getCostTime(prpLpayExtDtoList, starDate);
				
				//最后一条处理意见
				/**
				prpLpayExtDtoNew = new PrpLpayExtDto();
				prpLpayExtDtoNew.setComCode(user.getComCode());
				prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
				prpLpayExtDtoNew.setNodeType(nodeType);
				String nodeName="";
				if("apay".equals(nodeType)){
					nodeName = "新增支付";
				}else if("vpay".equals(nodeType)){
					nodeName = "支付审批";
				}else{
					nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", nodeType, true);
				}
				prpLpayExtDtoNew.setNodeName(nodeName);
				prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
				String costTime ="";
				starDate = "";
				if(prpLpayExtDtoList!=null&&prpLpayExtDtoList.size()>0){
					if(prpLpayExtDtoList.size()==1){
						starDate=prpLpayExtDtoList.get(0).getInputDate().toString(DateTime.YEAR_TO_SECOND);
					}else{
						for(int i=1;i<prpLpayExtDtoList.size();i++){
							
							int temp =DateCompute.compareDate(prpLpayExtDtoList.get(i).getInputDate().toString(DateTime.YEAR_TO_SECOND),
									prpLpayExtDtoList.get(i-1).getInputDate().toString(DateTime.YEAR_TO_SECOND));
							if(temp>=0){
								starDate=prpLpayExtDtoList.get(i).getInputDate().toString(DateTime.YEAR_TO_SECOND);
							}else{
								starDate=prpLpayExtDtoList.get(i-1).getInputDate().toString(DateTime.YEAR_TO_SECOND);
							}
						}
					}
				}
				
				//endCaseDate = ((PrpLclaimDto)col.iterator().next()).getEndCaseDate();
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew.setCostTime(costTime);
				prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
				prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("未处理");
				*/
			}else{
				String payExtSql = " paymentNo= '"+paymentNo+"'  "	;
				prpLpayExtDtoList=(ArrayList<PrpLpayExtDto>) blPrpLpayExtFacade.findByConditions(payExtSql);
				for(int i=0;i<prpLpayExtDtoList.size();i++){
					//String nodeTypeName = "epay".equals(prpLpayExtDtoList.get(i).getNodetype())?"支付":uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodetype(), true);
					String nodeName="";
					if("apay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "新增支付";
					}else if("vpay".equals(prpLpayExtDtoList.get(i).getNodeType())){
						nodeName = "支付审批";
					}else{
						nodeName = uiCodeAction.translateCodeCode("ClaimNodeType", prpLpayExtDtoList.get(i).getNodeType(), true);
					}
					String comCName = new UICodeAction().translateComCode(prpLpayExtDtoList.get(i).getComCode(), true);
					String userName = new UICodeAction().translateUserCode(prpLpayExtDtoList.get(i).getOperatorCode(), true);
					prpLpayExtDtoList.get(i).setNodeName(nodeName);
					prpLpayExtDtoList.get(i).setComCName(comCName);
					prpLpayExtDtoList.get(i).setOperatorCodeName(userName);
				}
				
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLpayShowDtoList!=null&&prpLpayShowDtoList.size()>0){
					if(prpLpayShowDtoList.size()==1){
						starDate=prpLpayShowDtoList.get(0).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLpayShowDtoList.size();i++){
							String bDate = prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							String eDate = prpLpayShowDtoList.get(i-1).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=prpLpayShowDtoList.get(i).getUnderWriteEndDate();
							}
						}
					}
				}
				this.getCostTime(prpLpayExtDtoList, starDate);
				
			}
			
		}
		//此处参见ClaimProcessDto.java getPayInfo()方法   第696行
		String payCondition = "codetype='NewPayRefReason' and validstatus='1' ";
		List paymentTypes=(List) new BLPrpDcodeFacade().findByConditions(payCondition);
		request.setAttribute("paymentTypes",paymentTypes);
		request.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
		request.setAttribute("paymentTypes", paymentTypes);
		request.setAttribute("prpLpaymainDto", prpLpaymainDto);
		request.setAttribute("prpLpayShowDtoList", prpLpayShowDtoList);
		request.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
		request.setAttribute("from", from);
		request.setAttribute("nodeType", nodeType);
		request.setAttribute("editType", editType);
		request.setAttribute("undwrtEditType", undwrtEditType);
		request.setAttribute("paymentTypeMap", getPaymentTypeMap());
		
	}
	/**
	 * 数据保存提交
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public String saveOrupdate(HttpServletRequest request) throws Exception{
		String submitType = request.getParameter("submitType");
		String registNo = request.getParameter("registNo");
		String vflag  = request.getParameter("vflag");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String Datatype = request.getParameter("Datatype");//合并支付标志
        if (user==null) {
			throw new Exception("session失效");
		}
		String businessNo = null;
		if(submitType!=null){
			//预赔、理算环节数据收集
			if("0".equals(submitType)){
				return savePayMain(request,"");
			}
			//数据暂存
			else if("2".equals(submitType)){
				return savePayMain(request,"1");
			}
			//数据提交
			else if("4".equals(submitType)){
				businessNo = savePayMain(request,vflag);
				//判断案件是否冻结begin
				//DAAReviewViewHelper daaReviewViewHelper = new DAAReviewViewHelper();
				boolean status = false;//daaReviewViewHelper.CaseStatus(null, registNo);
				if(status){
					String msg = "案件已冻结，不能提交支付！";
					throw new UserException(1, 3, "", msg);
				}
				//判断案件是否冻结end
				
				//1.自动审核通过
				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
				PrpLpaymainDto prplpaymainDto =blPrpLpaymainFacade.findByPrimaryKey(businessNo);
				BLPrpLpayExtFacade blPrpLpayExtFacade =new BLPrpLpayExtFacade();
				//若收款人为被保险人，则自动审核通过
				/*if("t01".equals(prplpaymainDto.getReceiverTypeOther().trim())){
					//blPrpLpaymainFacade.updateByKey(businessNo, "4");
					//更新为待下发状态
					prplpaymainDto.setVerifyFlag("0");//自动审核
					prplpaymainDto.setVflag("4");
					prplpaymainDto.setThirdPayFlag("1");//赔款新增第三方支付标识
					blPrpLpaymainFacade.update(prplpaymainDto);
					new BLPrplpayFacade().updateVFlag("4", businessNo);//更新为待下发状态
					//插入支付占用处理意见的操作
					PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();
					int count = blPrpLpayExtFacade.getCount(" paymentNo = '"+businessNo+"'")+1;
					prpLpayExtDto.setPaymentNo(businessNo);
					prpLpayExtDto.setSerialNo(count);
					prpLpayExtDto.setComCode(user.getComCode());
					prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
					prpLpayExtDto.setNodeType("vpay");
					prpLpayExtDto.setNodeName("支付审批");
					prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
					prpLpayExtDto.setOperatorCode(user.getUserCode());
					prpLpayExtDto.setOperatorCodeName(user.getUserName());
					prpLpayExtDto.setFlag("Y");
					prpLpayExtDto.setNotionCode("4");
					prpLpayExtDto.setNotionName("审核通过");
					prpLpayExtDto.setContext("自动审核通过");
					blPrpLpayExtFacade.insert(prpLpayExtDto);
					//若未勾选合并下发则直接生成通知单
					if(!"1".equals(prplpaymainDto.getMergerFlag().trim())){
						String noticeNo = mergerIssued(businessNo, user.getUserCode(), prplpaymainDto.getComCode(), 
								prplpaymainDto.getReceiverFullName());
						prplpaymainDto.setNoticeNo(noticeNo);
						prplpaymainDto.setVflag("8");//下发完成待支付
						if(prplpaymainDto.getPayAmount()<0){
							prplpaymainDto.setThirdPayFlag("a");//赔款新增第三方支付标识
						}else{
							prplpaymainDto.setThirdPayFlag("3");//赔款新增第三方支付标识
						}
						new BLPrpLpaymainFacade().update(prplpaymainDto);
						new BLPrplpayFacade().updateVFlag("8", businessNo);//更新为正在审核状态
						// 处理意见记录
						//插入支付占用处理意见的操作
						*//**
						PrpLpayExtDto prpLpayExtDtoNew = new PrpLpayExtDto();
						prpLpayExtDtoNew.setPaymentNo(businessNo);
						int count2 = blPrpLpayExtFacade.getCount(" paymentNo = '"+businessNo+"'")+1;
						prpLpayExtDtoNew.setSerialNo(count2);
						prpLpayExtDtoNew.setComCode(user.getComCode());
						prpLpayExtDtoNew.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
						prpLpayExtDtoNew.setNodeType("vpay");
						prpLpayExtDtoNew.setNodeName("支付审批");
						prpLpayExtDtoNew.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
						prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
						prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
						prpLpayExtDtoNew.setFlag("Y");
						prpLpayExtDtoNew.setNotionCode("8");
						prpLpayExtDtoNew.setNotionName("合并下发");
						prpLpayExtDtoNew.setContext("自动合并下发");
						blPrpLpayExtFacade.insert(prpLpayExtDtoNew);
						*//*
					}
					
				}else{*/
					PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNo);
					if(prpLregistDto==null){
						registNo = request.getParameterValues("registNoPay")[0];
						prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNo);
					}
					UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
					String UWflowID = uiWorkFlowApprovalInterFaceFacade
							.submitApprovalPlatform("VeriPay",
									"00", "00", businessNo,
											prpLregistDto.getRiskCode(),
											prpLregistDto.getClassCode(),
											prpLregistDto.getComCode(),
											user.getUserCode(), prpLregistDto.getMakeCom(),
											user.getUserCode(), user.getUserCode(),
											businessNo);
					if (UWflowID.length() < 15) {
						String msg = "案件'"
								+ businessNo
								+ "'提交双核系统失败，请重新提交或者与管理员联系!";
						throw new UserException(1, 3, "工作流", msg);
					}
					/*** 报案注销送审核平台 end****/
					new BLPrplpayFacade().updateVFlag("6", businessNo);//更新为正在审核状态
					new BLPrpLpaymainFacade().updateByKey(businessNo, "6");
					new BLPrpLpaymainFacade().updateThirdPayFlag(businessNo, "1");//更新第三方支付标识
					
				/*}*/
				//更新日志完成状态 begin
				new BLPrpLpayExtFacade().updateFlagByPaymentNo(businessNo);//更新日志完成状态
				return businessNo;
				
			}
			
		}
		
		return null;
	}
	
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库prplpaymain
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public String savePayMain(HttpServletRequest request,String vflag) throws Exception{
		String editType = request.getParameter("editType");
		String payType = request.getParameter("payType");//支付类型
		String Datatype = request.getParameter("Datatype");//合并支付标志
		String urgentType = request.getParameter("urgentType");//紧急程度
		String receiverTypeOther = StringUtils.trimToEmpty(request.getParameter("receiverTypeOther"));//领款人类型代码
		String receiverTypeOtherName = StringUtils.trimToEmpty(request.getParameter("receiverTypeOtherName"));//领款人类型名称
		String receiverFullName = StringUtils.trimToEmpty(request.getParameter("receiverFullName"));//领款人名称
		String receiverFullCode = StringUtils.trimToEmpty(request.getParameter("receiverFullCode"));//领款人代码
		String certifType = StringUtils.trimToEmpty(request.getParameter("certifType"));//领款人证件类型
		String certifNo = StringUtils.trimToEmpty(request.getParameter("certifNo"));//证件号码
		String provinceCode = StringUtils.trimToEmpty(request.getParameter("provinceCode"));//省份
		String cityCode = StringUtils.trimToEmpty(request.getParameter("cityCode"));//城市
		String accountType = StringUtils.trimToEmpty(request.getParameter("accountType"));
		String bankType = StringUtils.trimToEmpty(request.getParameter("bankType"));//银行大类
		String bank = StringUtils.trimToEmpty(request.getParameter("bank"));//开户银行
		String bankAccount = StringUtils.trimToEmpty(request.getParameter("bankAccount"));//银行账号
		String familyPhone = StringUtils.trimToEmpty(request.getParameter("familyPhone"));//家庭电话
		String officePhone = StringUtils.trimToEmpty(request.getParameter("officePhone"));//办公电话
		String mobilePhone = StringUtils.trimToEmpty(request.getParameter("mobilePhone"));//手机号码
		String address = StringUtils.trimToEmpty(request.getParameter("address"));//详细地址
		String qqNumber = StringUtils.trimToEmpty(request.getParameter("qqNumber"));//qq号码
		String email = StringUtils.trimToEmpty(request.getParameter("email"));//电子邮件
		String unitLink = StringUtils.trimToEmpty(request.getParameter("unitLink"));//单位联系人员
		String postCode = StringUtils.trimToEmpty(request.getParameter("postCode"));//邮政编码
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String registNo = request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String paymentType = request.getParameter("paymentType");//赔款类型
		String mergerFlag  = request.getParameter("mergerFlag");//合并下发标志
		String payAmount = request.getParameter("payAmount");
		String vflagHis  = request.getParameter("vflag");
		/**赔款支付信息新增支付方式 add by zhong begin**/
		String payWay = request.getParameter("payWay");//支付方式
		String payReason = request.getParameter("payReason");//支付原因
		String payPurpose = request.getParameter("payPurpose");//用途说明
		String accountFlag = request.getParameter("accountFlag");//账号类型
		String routeNum = request.getParameter("routeNum");//支付行号
		String billFlag = request.getParameter("billFlag");
		if(null==payPurpose||"".equals(payPurpose)){
			payPurpose = "国元理赔";
		}
		/**赔款支付信息新增支付方式 add by zhong end**/
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDto==null){
			registNo = request.getParameterValues("registNoPay")[0];
			prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		}
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		PrpLpaymainDto prpLpaymainDto = null;
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		DBManager dbManager = new DBManager();
		String paymentNo = "";
		String paymentNoHis = "";
		if("9".equals(vflagHis)){
			editType = "ADD";
		}
		vflag = "".equals(vflag)?"1":vflag;
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
			if("ADD".equals(editType)){
				prpLpaymainDto = new PrpLpaymainDto();
				String tableName = "prplpaymain";
				String riskCode = this.getRiskCodeByRegistNo(registNo, dbManager);
				String comCode = user.getComCode();
				int year = new DateTime(DateTime.current().toString()).getYear();
				
				paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
				//prplpay 和 prpLpayExt表数据采用先删后插方式
				blPrpLpaymainAction.delete(dbManager, paymentNo);
				prpLpaymainDto.setPaymentNo(paymentNo);
				prpLpaymainDto.setPayType(payType);
				prpLpaymainDto.setPaymentType(paymentType);
				prpLpaymainDto.setUrgentType(urgentType);
				prpLpaymainDto.setReceiverTypeOther(receiverTypeOther);
				prpLpaymainDto.setReceiverTypeOtherName(receiverTypeOtherName);
				prpLpaymainDto.setReceiverFullName(receiverFullName);
				prpLpaymainDto.setReceiverFullCode(receiverFullCode);
				prpLpaymainDto.setCertifNo(certifNo);
				prpLpaymainDto.setCertifType(certifType);
				prpLpaymainDto.setProvinceCode(provinceCode);
				prpLpaymainDto.setCityCode(cityCode);
				prpLpaymainDto.setAccountType(accountType);
				prpLpaymainDto.setBankType(bankType);
				prpLpaymainDto.setBank(bank);
				prpLpaymainDto.setBankAccount(bankAccount);
				prpLpaymainDto.setFamilyPhone(familyPhone);
				prpLpaymainDto.setOfficePhone(officePhone);
				prpLpaymainDto.setMobilePhone(mobilePhone);
				prpLpaymainDto.setAddress(address);
				prpLpaymainDto.setQqNumber(qqNumber);
				prpLpaymainDto.setEmail(email);
				prpLpaymainDto.setUnitLink(unitLink);
				prpLpaymainDto.setPostCode(postCode);
				prpLpaymainDto.setPayAmount(Double.parseDouble(payAmount));
				prpLpaymainDto.setNode(nodeType);
				prpLpaymainDto.setVflag("".equals(vflag)?"1":vflag);//保存任务状态
				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
				prpLpaymainDto.setOperatorCode(user.getUserCode());
				prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				//赔款增加新增第三方支付标识
				if("1".equals(vflag)){
					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
				}else if("6".equals(vflag)){
					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
				}
				prpLpaymainDto.setPayWay(payWay);//支付方式
				prpLpaymainDto.setPayReason(payReason);//支付原因
				prpLpaymainDto.setPayPurpose(payPurpose);//用途说明
				prpLpaymainDto.setAccountFlag(accountFlag);//账户类型
				prpLpaymainDto.setRouteNum(routeNum);//支付行号
				prpLpaymainDto.setBillFlag(billFlag);
				blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
				
				blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
			}else if("EDIT".equals(editType)){
				paymentNo = request.getParameter("paymentNo");
				paymentNoHis = request.getParameter("paymentNo");
				if(paymentNoHis.indexOf("Z")==-1){
					prpLpaymainDto = new PrpLpaymainDto();
					String tableName = "prplpaymain";
					String riskCode = this.getRiskCodeByRegistNo(registNo, dbManager);
					String comCode = user.getComCode();
					int year = new DateTime(DateTime.current().toString()).getYear();
					
					paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
				}else{
					prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNo);
				}
				prpLpaymainDto.setPaymentNo(paymentNo);
				prpLpaymainDto.setPayType(payType);
				prpLpaymainDto.setPaymentType(paymentType);
				prpLpaymainDto.setUrgentType(urgentType);
				prpLpaymainDto.setReceiverTypeOther(receiverTypeOther);
				prpLpaymainDto.setReceiverTypeOtherName(receiverTypeOtherName);
				prpLpaymainDto.setReceiverFullName(receiverFullName);
				prpLpaymainDto.setReceiverFullCode(receiverFullCode);
				prpLpaymainDto.setCertifNo(certifNo);
				prpLpaymainDto.setCertifType(certifType);
				prpLpaymainDto.setProvinceCode(provinceCode);
				prpLpaymainDto.setCityCode(cityCode);
				prpLpaymainDto.setAccountType(accountType);
				prpLpaymainDto.setBankType(bankType);
				prpLpaymainDto.setBank(bank);
				prpLpaymainDto.setBankAccount(bankAccount);
				prpLpaymainDto.setFamilyPhone(familyPhone);
				prpLpaymainDto.setOfficePhone(officePhone);
				prpLpaymainDto.setMobilePhone(mobilePhone);
				prpLpaymainDto.setAddress(address);
				prpLpaymainDto.setQqNumber(qqNumber);
				prpLpaymainDto.setEmail(email);
				prpLpaymainDto.setUnitLink(unitLink);
				prpLpaymainDto.setPostCode(postCode);
				prpLpaymainDto.setPayAmount(Double.parseDouble(payAmount));
				prpLpaymainDto.setNode(nodeType);
				prpLpaymainDto.setVflag(vflag);//保存任务状态
				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
				prpLpaymainDto.setOperatorCode(user.getUserCode());
				prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				//赔款增加新增第三方支付标识
				if("1".equals(vflag)){
					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
				}else if("6".equals(vflag)){
					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
				}
				prpLpaymainDto.setPayWay(payWay);//支付方式
				prpLpaymainDto.setPayReason(payReason);//支付原因
				prpLpaymainDto.setPayPurpose(payPurpose);//用途说明
				prpLpaymainDto.setAccountFlag(accountFlag);//账户类型
				prpLpaymainDto.setRouteNum(routeNum);//支付行号
				prpLpaymainDto.setBillFlag(billFlag);
				if(paymentNoHis.indexOf("Z")==-1){
					blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
				}else{
					blPrpLpaymainAction.update(dbManager, prpLpaymainDto);
				}
				
				//prplpay 和 prpLpayExt表数据采用先删后插方式
				blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
			}
			if(billFlag!=null&&"1".equals(billFlag)){
				savePayBill(dbManager,request,paymentNo,"",user.getUserCode());
			}else if(billFlag!=null&&"0".equals(billFlag)){
				savePayNoBill(dbManager,request,paymentNo,"",user.getUserCode());
			}
			savePays(dbManager,request, paymentNo, vflag);
			String submitType = request.getParameter("submitType");
			savePrplpayExt(dbManager,request,paymentNo,vflag);
			dbManager.commitTransaction();
		}catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpaymainDto.getPaymentNo();
	}
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库表prplpay
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void savePays(DBManager dbManager,HttpServletRequest request,String paymentNo,String vflag) throws Exception{
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String editType = request.getParameter("editType");
		String payType = StringUtils.trimToEmpty(request.getParameter("payType"));//支付类型
		String Datatype = request.getParameter("Datatype");//合并支付标志
		String paymentType = request.getParameter("paymentType");//赔款类型
		String urgentType = StringUtils.trimToEmpty(request.getParameter("urgentType"));//紧急程度
		String receiverTypeOther = StringUtils.trimToEmpty(request.getParameter("receiverTypeOther"));//领款人类型代码
		String receiverTypeOtherName = StringUtils.trimToEmpty(request.getParameter("receiverTypeOtherName"));//领款人类型名称
		String receiverFullName = StringUtils.trimToEmpty(request.getParameter("receiverFullName"));//领款人名称
		String receiverFullCode = StringUtils.trimToEmpty(request.getParameter("receiverFullCode"));//领款人代码
		String certifType = StringUtils.trimToEmpty(request.getParameter("certifType"));//领款人证件类型
		String certifNo = StringUtils.trimToEmpty(request.getParameter("certifNo"));//证件号码
		String provinceCode = StringUtils.trimToEmpty(request.getParameter("provinceCode"));//省份
		String cityCode = StringUtils.trimToEmpty(request.getParameter("cityCode"));//城市
		String accountType = StringUtils.trimToEmpty(request.getParameter("accountType"));
		String bankType = StringUtils.trimToEmpty(request.getParameter("bankType"));//银行大类
		String bank = StringUtils.trimToEmpty(request.getParameter("bank"));//开户银行
		String bankAccount = StringUtils.trimToEmpty(request.getParameter("bankAccount"));//银行账号
		String familyPhone = StringUtils.trimToEmpty(request.getParameter("familyPhone"));//家庭电话
		String officePhone = StringUtils.trimToEmpty(request.getParameter("officePhone"));//办公电话
		String mobilePhone = StringUtils.trimToEmpty(request.getParameter("mobilePhone"));//手机号码
		String address = StringUtils.trimToEmpty(request.getParameter("address"));//详细地址
		String qqNumber = StringUtils.trimToEmpty(request.getParameter("qqNumber"));//qq号码
		String email = StringUtils.trimToEmpty(request.getParameter("email"));//电子邮件
		String unitLink = StringUtils.trimToEmpty(request.getParameter("unitLink"));//单位联系人员
		String postCode = StringUtils.trimToEmpty(request.getParameter("postCode"));//邮政编码
		//String registNo = request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String compensateNo = request.getParameter("compensateNo");//业务单号
		String vflagHis  = request.getParameter("vflag");
		String paymentNoHis = "";
		
		String [] certiNos = request.getParameterValues("certiNoPay");//业务单号
		String [] policyNos = request.getParameterValues("policyNoPay");
		String [] registNos = request.getParameterValues("registNoPay");
		String [] paids = request.getParameterValues("paidPay");//支付金额
		String [] paidPayHis = request.getParameterValues("paidPayHis");
		String [] claimNos = request.getParameterValues("claimNoPay");
		String [] comCodes= request.getParameterValues("comCodePay");
		String [] serilNos= request.getParameterValues("serilNoPay");
		String [] payrefreasons = request.getParameterValues("payrefreason");
		
		
		//String [] compensateNo = request.getParameterValues("compensateNo");
		String registNo = request.getParameter("registNo");
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo);
		ArrayList<PrplpayDto> list =new ArrayList<PrplpayDto>();
		ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
		PrplpayDto prplpayDto=null;
		PrpLpayHisDto prpLpayHisDto= null;
		ArrayList<PrplpayDto> prplpayDtoList=null;
		PrpLpaymainDto prpLpaymainDto = null;
		String flagStr = "";
		String [] flags = request.getParameterValues("flag");//合并勾选框
		for(int k =0;k<flags.length;k++){
			flagStr += "["+flags[k]+"]";
		}
		
		for(int i=0;i<registNos.length;i++){
			if((flagStr).indexOf("["+String.valueOf(i)+"]")<0) continue;
			prplpayDto = new PrplpayDto();
			prplpayDto.setClaimno(claimNos[i]);
			prplpayDto.setSerialno(paymentNo);
			prplpayDto.setSerialNo2(serilNos[i]);
			prplpayDto.setCompensateno(certiNos[i]);
			prplpayDto.setClasscode(policyNos[i].substring(1, 3));
			prplpayDto.setRiskcode(policyNos[i].substring(1,5));
			prplpayDto.setRegistno(registNos[i]);
			prplpayDto.setPolicyno(policyNos[i]);
			prplpayDto.setPaytype(payType);
			
			prplpayDto.setReceivertype(receiverTypeOther);
			double payAmount = Double.parseDouble(paids[i]);
			prplpayDto.setPayamount(payAmount);
			prplpayDto.setBanktype(bankType);
			prplpayDto.setBank(bank);
			prplpayDto.setAccounttype(accountType);
			prplpayDto.setReceiverfullname(receiverFullName);
			prplpayDto.setCertiftype(certifType);
			prplpayDto.setAddress(address);
			prplpayDto.setCertifno(certifNo);
			prplpayDto.setFamilyphone(familyPhone);
			prplpayDto.setOfficephone(officePhone);
			prplpayDto.setMobilephone(mobilePhone);
			//prplpayDto.setPayremark(payRemark);
			prplpayDto.setOperatorcode(user.getUserCode());
			prplpayDto.setOperatorComCode(user.getComCode());
			prplpayDto.setInputdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
			prplpayDto.setPaymenttype(payrefreasons[i]);
			prplpayDto.setBankaccount(bankAccount);
			prplpayDto.setNode(nodeType);
			prplpayDto.setVFlag(vflag);
			prplpayDto.setComCode(comCodes[i]);
			
			if("9".equals(vflagHis)){
				paymentNoHis = request.getParameter("paymentNo");
				prpLpayHisDto = new PrpLpayHisDto();
				prplpayDtoList = new ArrayList();
				prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
				String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+certiNos[i]+"' and Payamount = "+paidPayHis[i];
				prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
				PrplpayDto prplpayDto1 = new PrplpayDto();
				if(prplpayDtoList.size()>0){
					prplpayDto1 = prplpayDtoList.get(0);
				}
				setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,receiverTypeOtherName);
				prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
				prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
				prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
				prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
				prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
				prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
				prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
				prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				String conditions1 = " claimNo ='"+claimNos[i]+"' and Compensateno = '"+certiNos[i]+"' and payType = '"+payType+"'";
				int count = blPrpLpayHisAction.getCount(dbManager, conditions1);
				prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
				prplpayDto1.setVFlag("8");
				//支付信息历史轨迹表保存接口类型等
				prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
				prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
				prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
				prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
				prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
				prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
				blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
			}
			list.add(prplpayDto);
			if(prpLpayHisDto != null){
				list2.add(prpLpayHisDto);
			}
		}
		blPrpLpaymainAction.delete(dbManager, paymentNoHis);
		blPrplpayAction.insertAll(dbManager, list);
		blPrpLpayHisAction.insertAll(dbManager, list2);
		
	}
	
	public void setPrpLpayTransPrpLpayHis(PrplpayDto prplpayDto,PrpLpayHisDto prpLpayHisDto,String receiverTypeOtherName){
		prpLpayHisDto.setAccountType(prplpayDto.getAccounttype());
		prpLpayHisDto.setAddress(prplpayDto.getAddress());
		prpLpayHisDto.setBank(prplpayDto.getBank());
		prpLpayHisDto.setBankAccount(prplpayDto.getBankaccount());
		prpLpayHisDto.setBankType(prplpayDto.getBanktype());
		prpLpayHisDto.setBankSite(prplpayDto.getBanksite());
		prpLpayHisDto.setCertifNo(prplpayDto.getCertifno());
		prpLpayHisDto.setCertifType(prplpayDto.getCertiftype());
		prpLpayHisDto.setClaimNo(prplpayDto.getClaimno());
		prpLpayHisDto.setClassCode(prplpayDto.getClasscode());
		prpLpayHisDto.setComCode(prplpayDto.getComCode());
		prpLpayHisDto.setCompensateNo(prplpayDto.getCompensateno());
		prpLpayHisDto.setFamilyPhone(prplpayDto.getFamilyphone());
		prpLpayHisDto.setInputDate(prplpayDto.getInputdate());
		prpLpayHisDto.setMobilePhone(prplpayDto.getMobilephone());
		prpLpayHisDto.setNode(prplpayDto.getNode());
		prpLpayHisDto.setOfficePhone(prplpayDto.getOfficephone());
		prpLpayHisDto.setOperatorCode(prplpayDto.getOperatorcode());
		prpLpayHisDto.setPayAmount(prplpayDto.getPayamount());
		prpLpayHisDto.setPayCode(prplpayDto.getPaycode());
		prpLpayHisDto.setPayDate(prplpayDto.getPaydate());
		prpLpayHisDto.setPayFlag(prplpayDto.getPayflag());
		prpLpayHisDto.setPaymentType(prplpayDto.getPaymenttype());
		prpLpayHisDto.setPayreMark(prplpayDto.getPayremark());
		prpLpayHisDto.setPayType(prplpayDto.getPaytype());
		prpLpayHisDto.setPolicyNo(prplpayDto.getPolicyno());
		prpLpayHisDto.setReceiverFullName(prplpayDto.getReceiverfullname());
		prpLpayHisDto.setReceiverType(prplpayDto.getReceivertype());
		prpLpayHisDto.setRegistNo(prplpayDto.getRegistno());
		prpLpayHisDto.setRiskCode(prplpayDto.getRiskcode());
		prpLpayHisDto.setSerialNo(prplpayDto.getSerialno());
		prpLpayHisDto.setSerialNo2(prplpayDto.getSerialNo2());
		prpLpayHisDto.setUploadSerialno(prplpayDto.getUploadserialno());
		prpLpayHisDto.setVflag(prplpayDto.getVFlag());
		prpLpayHisDto.setOperatorComCode(prplpayDto.getOperatorComCode());
		prpLpayHisDto.setReceivertypeothername(receiverTypeOtherName);
	}
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库表pprpLpayExt
	 * @param request
	 * @param paymentNo 支付编号
	 * @param registNo 报案号码
	 * @param vflag 支付状态
	 * @throws Exception
	 */
	public void savePrplpayExt(DBManager dbManager,HttpServletRequest request,String paymentNo,String vflag) throws Exception{
		String[] rowNum = request.getParameterValues("prpLpayExtRowNum");
		String[] serialNo = request.getParameterValues("prpLpayExtSerialNo");
		String[] InputDate= request.getParameterValues("prpLpayExtInputDate");
		String[] OperatorCode = request.getParameterValues("prpLpayExtOperatorCode");
		String[] ComCode = request.getParameterValues("prpLpayExtComCode");
		String[] Context = request.getParameterValues("prpLpayExtContext");
		String[] NodeType = request.getParameterValues("prpLpayExtNodeType");
		String[] NodeName = request.getParameterValues("prpLpayExtNodeName");
		String[] notionCode = request.getParameterValues("prpLpayExtNotionCode");
		String[] notionName = request.getParameterValues("prpLpayExtNotionName");
		String[] flag = request.getParameterValues("prpLpayExtFlag");
		//String[] linkphone = request.getParameterValues("prpLpayExtNodeType");
		String newContext = request.getParameter("prpLpayExtNewContext");
		//String registNo = request.getParameter("registNo");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dt = new Date();
		String time = sdf.format(dt);
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		if (rowNum !=null) {
			for (int i = 0; i < rowNum.length; i++) {
				PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();	
				prpLpayExtDto.setPaymentNo(paymentNo);
				prpLpayExtDto.setOperatorCode(OperatorCode[i]);
//				int count = blPrpLpayExtAction.getMaxSerialNo(dbManager, registNo);
//				if(serialNo==null||serialNo[i]==null||"".equals(serialNo[i].trim())||"0".equals(serialNo[i].trim())){
//					prpLpayExtDto.setSerialNo(count);
//				}else{
//					prpLpayExtDto.setSerialNo(Integer.parseInt(serialNo[i]));
//				}
				
				if (i==rowNum.length-1) {
					prpLpayExtDto.setContext(newContext);
					prpLpayExtDto.setInputDate(new DateTime(time,DateTime.YEAR_TO_SECOND));
					if("".equals(vflag)||"1".equals(vflag)){
						prpLpayExtDto.setFlag("N");
					}else{
						prpLpayExtDto.setFlag("Y");
					}
					int count = blPrpLpayExtAction.getCount(dbManager, " paymentNo='"+paymentNo+"' ")+1;
					
					prpLpayExtDto.setSerialNo(count);
				}else{
					prpLpayExtDto.setContext(Context[i]);
					prpLpayExtDto.setInputDate(new DateTime(InputDate[i],DateTime.YEAR_TO_SECOND));
					prpLpayExtDto.setFlag(flag[i]);
					prpLpayExtDto.setSerialNo(Integer.parseInt(serialNo[i]));
				}
				prpLpayExtDto.setComCode(ComCode[i]);
				prpLpayExtDto.setNodeType(NodeType[i]);
				prpLpayExtDto.setNodeName(NodeName[i]);
				prpLpayExtDto.setNotionCode(notionCode[i]);
				prpLpayExtDto.setNotionName(notionName[i]);
				//prpLpayExtDto.setLinkphone(linkphone[i]);
				blPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
			}
		}
		
		
	}
	
	
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库表pprpLpayExt
	 * @param request
	 * @param paymentNo 支付编号
	 * @param registNo 报案号码
	 * @param vflag 支付状态
	 * @throws Exception
	 */
	public void savePrplpayExtBill(DBManager dbManager,ParamUtils paramUtils,String paymentNo,String vflag) throws Exception{
		String[] rowNum = paramUtils.getParameterValues("prpLpayExtRowNum2");
		String[] serialNo = paramUtils.getParameterValues("prpLpayExtSerialNo2");
		String[] InputDate= paramUtils.getParameterValues("prpLpayExtInputDate2");
		String[] OperatorCode = paramUtils.getParameterValues("prpLpayExtOperatorCode2");
		String[] ComCode = paramUtils.getParameterValues("prpLpayExtComCode2");
		String[] Context = paramUtils.getParameterValues("prpLpayExtContext2");
		String[] NodeType = paramUtils.getParameterValues("prpLpayExtNodeType2");
		String[] NodeName = paramUtils.getParameterValues("prpLpayExtNodeName2");
		String[] notionCode = paramUtils.getParameterValues("prpLpayExtNotionCode2");
		String[] notionName = paramUtils.getParameterValues("prpLpayExtNotionName2");
		String[] flag = paramUtils.getParameterValues("prpLpayExtFlag2");
		//String[] linkphone = request.getParameterValues("prpLpayExtNodeType");
		String newContext = paramUtils.getParameter("prpLpayExtNewContext2");
		//String registNo = request.getParameter("registNo");
		String submitType = paramUtils.getParameter("submitType");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dt = new Date();
		String time = sdf.format(dt);
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		if (rowNum !=null) {
			for (int i = 0; i < rowNum.length; i++) {
				PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();	
				prpLpayExtDto.setPaymentNo(paymentNo);
				prpLpayExtDto.setOperatorCode(OperatorCode[i]);
//				int count = blPrpLpayExtAction.getMaxSerialNo(dbManager, registNo);
//				if(serialNo==null||serialNo[i]==null||"".equals(serialNo[i].trim())||"0".equals(serialNo[i].trim())){
//					prpLpayExtDto.setSerialNo(count);
//				}else{
//					prpLpayExtDto.setSerialNo(Integer.parseInt(serialNo[i]));
//				}
				
				if (i==rowNum.length-1) {
					prpLpayExtDto.setContext(Context[i]);
					prpLpayExtDto.setInputDate(new DateTime(time,DateTime.YEAR_TO_SECOND));
					if("".equals(submitType)||!"4".equals(submitType)){
						prpLpayExtDto.setFlag("N");
					}else{
						prpLpayExtDto.setFlag("Y");
					}
					int count = blPrpLpayExtAction.getCount(dbManager, " paymentNo='"+paymentNo+"' ")+1;
					
					prpLpayExtDto.setSerialNo(count);
				}else{
					prpLpayExtDto.setContext(Context[i]);
					prpLpayExtDto.setInputDate(new DateTime(InputDate[i],DateTime.YEAR_TO_SECOND));
					prpLpayExtDto.setFlag(flag[i]);
					prpLpayExtDto.setSerialNo(Integer.parseInt(serialNo[i]));
				}
				prpLpayExtDto.setComCode(ComCode[i]);
				prpLpayExtDto.setNodeType(NodeType[i]);
				prpLpayExtDto.setNodeName(NodeName[i]);
				prpLpayExtDto.setNotionCode(notionCode[i]);
				prpLpayExtDto.setNotionName(notionName[i]);
				//prpLpayExtDto.setLinkphone(linkphone[i]);
				blPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
			}
		}
		
		
	}
	
	public void paymainNewBefore(HttpServletRequest request)throws Exception{
		String payType = request.getParameter("payType");
		String paymentType = request.getParameter("paymentType");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = "";
		}
		//每页显示多少条
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=this.getPayNewConditions(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoT");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//向下兼容
				//conditions +=sqlStr3 + ")";
			}
		}
        //判断案件类型
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNo");
        
        if(registNo!=null&&!"".equals(registNo.trim())){
        	paymentType="";
        	conditions = conditions + " and  r.registno = '"+registNo+"' " ;
        }
        PageRecord pr=new BLPrpLpayShowFacade().getNewQueryShowList(payType, paymentType, conditions, pageNo, rowsPerPage,casesType,userComCode);
        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
        // 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList)pr.getResult());
		// 当前页号
		turnPageDto.setPageNo(pr.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pr.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pr.getCount());
		// 返回总的页数
		int a=(pr.getCount())%pr.getRowsPerPage();
		if(a>0){
			turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
		}else{
			turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
		}
		
		// 搜索条件
		turnPageDto.setCondition(conditions);
		request.setAttribute("turnPageDto", turnPageDto);
	}
	
	public void paymainNewRegistBefore(HttpServletRequest request)throws Exception{
		String payType = request.getParameter("payType");
		String paymentType = request.getParameter("paymentType");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = "";
		}
		//每页显示多少条
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=this.getPayNewConditions(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoT");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//向下兼容
				//conditions +=sqlStr3 + ")";
			}
		}
        //判断案件类型
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNo");
        
        if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
        
        String type = request.getParameter("type");
        PageRecord pr=new BLPrpLpayShowFacade().getNewQueryShowRegistList(payType, paymentType, conditions, pageNo, rowsPerPage,casesType,userComCode,type);
        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
        // 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList)pr.getResult());
		// 当前页号
		turnPageDto.setPageNo(pr.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pr.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pr.getCount());
		// 返回总的页数
		int a=(pr.getCount())%pr.getRowsPerPage();
		if(a>0){
			turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
		}else{
			turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
		}
		
		// 搜索条件
		turnPageDto.setCondition(conditions);
		request.setAttribute("turnPageDto", turnPageDto);
	}
	/**
	 * 获取查询条件，拼接条件
	 * @param request
	 * @return
	 */
	public String getPayNewConditions(HttpServletRequest request){
		String conditions = "";
		String strWherePart =request.getParameter("condition"); //页面隐藏的查询条件
		if(strWherePart==null||strWherePart.equals("")){ 
			String registNoFlag = request.getParameter("registNos");
			String registNo = request.getParameter("registNoT");
			if ("=".equals(registNoFlag) && !"".equals(registNo)) {
				if (!"".equals(registNo.trim())) {
					conditions += " and r.registNo='" + registNo.trim() + "' ";
				}
			} else if ("*".equals(registNoFlag) && !"".equals(registNo)) {
				if (!"".equals(registNo.trim())) {
					conditions += " and r.registNo like '%" + registNo.trim() + "%'  ";
				}
			}
			String policyNoFlag = request.getParameter("policyNos");
			String policyNo = request.getParameter("policyNo");
			if ("=".equals(policyNoFlag) && !"".equals(policyNo)) {
				if (!"".equals(policyNo.trim())) {
					//conditions += " and r.policyNo='" + policyNo.trim() + "'  ";
					conditions += " and r.registno in (select registno from prplregistrpolicy where policyNo='" + policyNo.trim() + "' ) ";
				}
			} else if ("*".equals(policyNoFlag) && !"".equals(policyNo)) {
				if (!"".equals(policyNo.trim())) {
					//conditions += " and r.policyNo like '%" + policyNo.trim() + "%'  ";
					conditions += " and r.registno in (select registno from prplregistrpolicy where policyNo like '%" + policyNo.trim() + "%' ) ";
				}
			}
			
			String insuredNameFlag = request.getParameter("insuredNames");
			String insuredName = request.getParameter("insuredName");
			if ("=".equals(insuredNameFlag) && !"".equals(insuredNameFlag)) {
				if (!"".equals(insuredName.trim())) {
					conditions += " and r.insuredName='" + insuredName.trim() + "'   ";
				}
			} else if ("*".equals(insuredNameFlag) && !"".equals(insuredNameFlag)) {
				if (!"".equals(insuredName.trim())) {
					conditions += " and r.insuredName like '%" + insuredName.trim() + "%'  ";
				}
			}
			String LicenseNo = request.getParameter("LicenseNo");
			String LicenseNoFlag = request.getParameter("LicenseNos");
			if ("=".equals(LicenseNoFlag) && !"".equals(LicenseNo)) {
				if (!"".equals(LicenseNo.trim())) {
					conditions += " and r.LicenseNo='" + LicenseNo.trim() + "' ";
				}
			} else if ("*".equals(LicenseNoFlag) && !"".equals(LicenseNo)) {
				if (!"".equals(LicenseNo.trim())) {
					conditions += " and r.LicenseNo like '%" + LicenseNo.trim()
							+ "%'  ";
				}
			}
			
			// 时间处理
			String inputDateStrat = request.getParameter("inputDateStrat");
			String inputDateEnd = request.getParameter("inputDateEnd");
			if (!"".equals(inputDateStrat) ) {
				conditions += " and underwriteenddate >= " +"to_date('"+inputDateStrat+ " 00:00:00', 'YYYY-MM-DD hh24:mi:ss ')";
			}
			if(!"".equals(inputDateEnd) ){
				conditions += " and underwriteenddate <= " +"to_date('"+inputDateEnd+" 23:59:59', 'YYYY-MM-DD hh24:mi:ss')";
			}
			/*if (!"".equals(inputDateStrat) ) {
				conditions += " and underwriteenddate >= '" +inputDateStrat+"'" ;
			}
			if(!"".equals(inputDateEnd) ){
				conditions += " and underwriteenddate <= '" +inputDateEnd+"'"  ;
			}*/
		}else{
			conditions=strWherePart;
		}
		return conditions;
	}
	/**
	 * 支付类型的Map帮助方法 add by zhongfen
	 * @return
	 * @throws Exception
	 */
	public Map getPayTypeMap() throws Exception {
		Map<String, String> payTypeMap = new HashMap<String,String>();
		payTypeMap.put("P1", "预付");
		payTypeMap.put("P2", "支付");
		payTypeMap.put("P3", "赔付");
		payTypeMap.put("P4", "垫付");
		return payTypeMap;
	}
	/**
	 * 重写DAARegistViewHelper中的获取占用时间
	 * @param prpLpayExtDtoList
	 * @param originTime
	 * @throws Exception
	 */
	public void getCostTime(List<PrpLpayExtDto> prpLpayExtDtoList,
			String originTime) throws Exception {
		for(int i=0; i<prpLpayExtDtoList.size(); i++){
			PrpLpayExtDto dto = prpLpayExtDtoList.get(i);
			String costTime = "";
			String curDtoInputTime = "";
			if(!"".equals(dto.getInputDate())){
				curDtoInputTime = dto.getInputDate().toString(DateTime.YEAR_TO_SECOND);
			} else {
				curDtoInputTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString(DateTime.YEAR_TO_SECOND);
			}
			if(i==0){
				if(!"".equals(originTime)){
					costTime = DateCompute.betweenDate(originTime, curDtoInputTime);	
				    int index = costTime.indexOf("钟");
					if (index != -1){
						costTime = costTime.substring(0, index);
					}
					dto.setCostTime(costTime);
				}
			} else {
				PrpLpayExtDto priorDto = prpLpayExtDtoList.get(i-1);
				String priorFlowOutTime =  priorDto.getInputDate().toString(DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.betweenDate(priorFlowOutTime, curDtoInputTime);	
			    int index = costTime.indexOf("钟");
				if (index != -1){
					costTime = costTime.substring(0, index);
				}
				dto.setCostTime(costTime);
			}
		}
	}
	/**
	 * * 单个支付单号合并下发
	 * @param paymentNo 支付编号
	 * @param userCode	操作人员代码
	 * @param comCode	承保机构代码
	 * @param receiverFullName 领款人名称
	 * @return	通知单号
	 * @throws Exception
	 */
	public String mergerIssued(String paymentNo,String userCode,String comCode,String receiverFullName) throws Exception{
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpayNoticeAction  blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
		BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
		DBManager dbManager = new DBManager();
		String noticeNo = "";
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            int year = DateTime.current().getYear();
            String tableName = "prplpaynotice";
            String riskCode = "0500";
            noticeNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");//生成主键
            //通知单表数据插入
            PrpLpayNoticeListDto prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            PrpLpayNoticeDto prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(noticeNo);
            prpLpayNoticeDto.setNoticeType("0");
            prpLpayNoticeDto.setOpreateCode(userCode);
            prpLpayNoticeDto.setOpreateDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
            prpLpayNoticeDto.setReceiverFullName(receiverFullName);
            blPrpLpayNoticeAction.insert(dbManager, prpLpayNoticeDto);
            //通知单关联表数据插入
            prpLpayNoticeListDto.setNoticeNo(noticeNo);
            prpLpayNoticeListDto.setPaymentNo(paymentNo);
            blPrpLpayNoticeListAction.insert(dbManager, prpLpayNoticeListDto);
            dbManager.commitTransaction();
		}catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
		return noticeNo;
	}
	/**
	 * 合并下发提交 add by zhongfen
	 * @param request
	 * @throws Exception
	 */
	public void mergerIssuedPost(HttpServletRequest request,ParamUtils paramUtils)throws Exception{
		int year = DateTime.current().getYear();
		String tableName = "prplpaynotice";
		String riskCode = "0500";
		String comCode  = "";
		String receiverName = "";
		String[] isCheckTemp = paramUtils.getParameterValues("isCheckTemp");
		String[] paymentNo = paramUtils.getParameterValues("paymentNo");
		String[] stcomCodre= paramUtils.getParameterValues("comCode");
		String[] receiverFullName = paramUtils.getParameterValues("receiverFullName");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		BLPrpLpayNoticeFacade  blPrpLpayNoticeFacade = new BLPrpLpayNoticeFacade();
		BLPrpLpayNoticeListFacade blPrpLpayNoticeListFacade = new BLPrpLpayNoticeListFacade();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
		
		comCode = stcomCodre[0];
		
		String noticeNo = new UIBillAction().getNo(tableName, riskCode, comCode, year);
		
		PrpLpayNoticeDto prpLpayNoticeDto = new PrpLpayNoticeDto();
		
		Collection prplpaynoticelistList = new ArrayList<PrpLpayNoticeListDto>();
		DBManager dbManager = new DBManager();
		try{//增加try、catch、finally代码段，保证数据库连接正常关闭
			if(null!=isCheckTemp&&isCheckTemp.length>0){
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				for(int i=0;i<isCheckTemp.length;i++){
					PrpLpayNoticeListDto prpLpayNoticeListDto = new PrpLpayNoticeListDto();
					if("1".equals(isCheckTemp[i])){
						receiverName = receiverFullName[i];
						prpLpayNoticeListDto.setPaymentNo(paymentNo[i]);
						prpLpayNoticeListDto.setNoticeNo(noticeNo);
						prplpaynoticelistList.add(prpLpayNoticeListDto);
						//更新支付信息状态
						blPrpLpaymainAction.updateByKey(dbManager, paymentNo[i], "8");
						blPrplpayAction.updateVflagByPaymentNo(dbManager, paymentNo[i], "8");
					}
				}
				dbManager.commitTransaction();
			}
		}catch(Exception e){
		    dbManager.rollbackTransaction();
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		prpLpayNoticeDto.setNoticeNo(noticeNo);
		prpLpayNoticeDto.setNoticeType("1");
		prpLpayNoticeDto.setOpreateCode(user.getUserCode());
		prpLpayNoticeDto.setOpreateDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLpayNoticeDto.setReceiverFullName(receiverName);
		
		if(!prplpaynoticelistList.isEmpty()){
			blPrpLpayNoticeFacade.insert(prpLpayNoticeDto);
			blPrpLpayNoticeListFacade.insertAll(prplpaynoticelistList);
		}
		request.setAttribute("noticeNo", noticeNo);
	}
	
	/**
	 * 合并下发查询逻辑处理 add by zhongfen
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String getMergerIssuedList(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String receiverFullNameSign = request.getParameter("receiverFullNameSign");
        String receiverFullName = request.getParameter("receiverFullName");
        String payType = request.getParameter("payType");
        String licenseNoSign = request.getParameter("licenseNoSign");
        String licenseNo = request.getParameter("licenseNo");
        String inputDate1 = request.getParameter("inputDate1");
        String inputDate2 = request.getParameter("inputDate2");
        String conditions = "";
        String forward = "";
        UserDto  user=(UserDto) request.getSession().getAttribute("user");
        if(null!=receiverFullNameSign&&!"".equals(receiverFullNameSign)){
        	if (user==null) {
    			throw new Exception("session失效");
    		}else{
    			conditions += " comcode like '" + user.getComCode().substring(0, 6) + "%'";
    		}
        	conditions += " and mergerflag='1' and vflag='4'";
        	//领款人名称
    		if(null!=receiverFullName&&!"".equals(receiverFullName)){
    			if("*".equals(receiverFullNameSign)){
    				conditions += " and receiverFullName like '%"+receiverFullName+"%'";
    			}else if("=".equals(receiverFullNameSign)){
    				conditions += " and receiverFullName = '"+receiverFullName+"'";
            	}
    			
    		}
        	//支付类型
        	if(null!=payType&&!"".equals(payType)){
        		conditions += "and payType = '"+payType+"'";
        	}
        	//流入时间
        	if(null!=inputDate1&&!"".equals(inputDate1)){
        		conditions += "and inputDate >=  to_date('"+inputDate1+"','yyyy-mm-dd hh24:mi:ss')";
        	}
        	if(null!=inputDate2&&!"".equals(inputDate2)){
        		conditions += "and inputDate <=  to_date('"+inputDate2+"','yyyy-mm-dd hh24:mi:ss')";
        	}
        	//号牌号码	
        	if(null!=licenseNo&&!"".equals(licenseNo)){
        		if("*".equals(licenseNoSign)){
        			conditions += " and paymentno in (select serialno from prplpay where registno in(select registno from prplregist where licenseNo like '%"+licenseNo+"%'))";
            	}else if("=".equals(licenseNoSign)){
            		conditions += " and paymentno in (select serialno from prplpay where registno in(select registno from prplregist where licenseNo = '"+licenseNo+"'))";
            	}
        	}
        	BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
        	Collection prplpaymainList = blPrpLpaymainFacade.findByConditions(conditions);
        	String limit = AppConfig.get("sysconst.PAYMERGEMAXLIMIT");
        	int maxLimit = Integer.parseInt(limit);
        	String nowTime = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND)+"";
        	if(null!=prplpaymainList&&!prplpaymainList.isEmpty()){
        		if(prplpaymainList.size()<maxLimit){
        			for(Iterator<PrpLpaymainDto> itr=prplpaymainList.iterator();itr.hasNext();){
            			PrpLpaymainDto prpLpaymaiDto = itr.next();
            			//流入时长取数
            			String totalInputDate = DateCompute.betweenDate(prpLpaymaiDto.getInputDate()+"", nowTime);
            			totalInputDate = totalInputDate.split("分钟")[0];
            			prpLpaymaiDto.setTotalInputDate(totalInputDate);
            			//承保机构名称取数
            			BLPrpDcompanyFacade  blPrpDcompanyFacade = new BLPrpDcompanyFacade();
            			PrpDcompanyDto prpDcompanyDto = blPrpDcompanyFacade.findByPrimaryKey(prpLpaymaiDto.getComCode());
            			if(null!=prpDcompanyDto&&!"".equals(prpDcompanyDto)){
            				prpLpaymaiDto.setComName(prpDcompanyDto.getComCName());
            			}
                	}
        			request.setAttribute("payTypeMap",this.getPayTypeMap());
        			request.setAttribute("prplpaymainList", prplpaymainList);
        		}else{
        			response.setCharacterEncoding("utf-8");
        			response.getWriter().write("查询结果超出一千条！！！");
        			forward = null;
        		}
        		
        	}
        	forward = "success";
        }
        return forward;
	}
	
	/**
	 * 第三方支付状态的Map帮助方法
	 * @return
	 * @throws Exception
	 */
	public Map getThirdPayFlagMap() throws Exception {
		Map<String, String> thirdPayFlagMap = new HashMap<String,String>();
		thirdPayFlagMap.put("0", "待提交");            
		thirdPayFlagMap.put("1", "待审核");            
		thirdPayFlagMap.put("2", "审核不通过");        
		thirdPayFlagMap.put("3", "支付中心待处理");    
		thirdPayFlagMap.put("4", "支付中心退回");      
		thirdPayFlagMap.put("5", "已打包待审核");      
		thirdPayFlagMap.put("6", "打包审核通过待发送");
		thirdPayFlagMap.put("7", "已提交银行");   
		thirdPayFlagMap.put("8", "银行打回");          
		thirdPayFlagMap.put("9", "支付成功");
		thirdPayFlagMap.put("a", "机构收付待处理");
		thirdPayFlagMap.put("b", "机构收付待提交");
		thirdPayFlagMap.put("c", "机构收付退回");
		thirdPayFlagMap.put("m", "默认支付成功");
		thirdPayFlagMap.put("n", "银行退回支付中心");
		return thirdPayFlagMap;
	}
	
	public String getRiskCodeByRegistNo(String registNo,DBManager dbManager) throws Exception {
		String riskCode = "";
		try{
			String condi = "select classCode from prplclaim where registNo = '"+registNo+"'";
			ResultSet rs = dbManager.executeQuery(condi);
			String classCode = "";
			while(rs.next()){
				classCode = rs.getString("classCode");
			}
			rs.close();
			riskCode = classCode + "00";
		}catch(Exception e){
			e.printStackTrace();
		}
		return riskCode;
	}
	
	public void savePayBill(DBManager dbManager,HttpServletRequest request,String paymentNo,String billNo,String userCode) throws Exception{
		String editType = request.getParameter("editType");
		String [] certiNos = request.getParameterValues("certiNoPay");//业务单号
		String [] registNos = request.getParameterValues("registNoPay");
		String [] paids = request.getParameterValues("paidPay");//支付金额
		String [] fkSerialNo = request.getParameterValues("fkSerialNo");
		String vflagHis  = request.getParameter("vflag");
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		ArrayList prpLpayBillList = new ArrayList();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
		ArrayList prpLpayBillHisList = new ArrayList();
		PrpLpayBillDto prpLpayBillDto;
		PrpLpayBillDto prpLpayBillHisDto;
		try {
			for(int i=0;i<certiNos.length;i++){
				String[] serialNo = fkSerialNo[i].split(",");
				for(int j=0;j<serialNo.length;j++){
					prpLpayBillDto = new PrpLpayBillDto();
					prpLpayBillDto.setBillNo(billNo);
					prpLpayBillDto.setPaymentNo(paymentNo);
					prpLpayBillDto.setRegistNo(registNos[i]);
					prpLpayBillDto.setCompensateNo(certiNos[i]);
					prpLpayBillDto.setSerialNo(Integer.parseInt(serialNo[j]));
					prpLpayBillDto.setPayAmount(Double.parseDouble(paids[i]));
					prpLpayBillDto.setBusinessNo(paymentNo);
					prpLpayBillList.add(prpLpayBillDto);
//					prpLpayBillHisDto = blPrpLpayBillAction.findByPrimaryKey(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
					prpLpayBillHisDto = blPrpLpayBillAction.findByBillFlag(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
					prpLpayBillHisList.add(prpLpayBillHisDto);
				}
			}
			if(!"9".equals(vflagHis)&&prpLpayBillHisList.size()>0){
				PrplpayDto prplpayDto=null;
				PrpLpayHisDto prpLpayHisDto= null;
				PrpLpaymainDto prpLpaymainDto = null;
				BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
				ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
				ArrayList  prplpayDtoList = new ArrayList();
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null){
						String paymentNoHis = prpLpayBillHisDto.getPaymentNo();
						PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)blPrpLclaimBillManagerAction.findByPrimaryKey(dbManager, prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
						if("2".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							if(prpLclaimBillManagerDto!=null){
								prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
								String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+prpLpayBillHisDto.getCompensateNo()+"' and Payamount = "+prpLpayBillHisDto.getPayAmount();
								prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
								PrplpayDto prplpayDto1 = new PrplpayDto();
								if(prplpayDtoList.size()>0){
									prplpayDto1 = (PrplpayDto) prplpayDtoList.get(0);
								}
								prpLpayHisDto = new PrpLpayHisDto();
								setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLclaimBillManagerDto.getPayName());
								prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
								prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
								prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
								prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
								prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
								prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
								prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
								prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
								int count = blPrpLpayHisAction.getCount(dbManager, conditions);
								System.err.println(list2.size());
								prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
								prplpayDto1.setVFlag("8");
								//支付信息历史轨迹表保存接口类型等
								prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
								prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
								prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
								prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
								prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
								prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
								blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
								if(prpLpayHisDto != null){
									list2.add(prpLpayHisDto);
								}
							}
						}else if("5".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
							blPrpLpaymainAction.deleteByConditions(dbManager, " paymentNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
						}
						blPrpLpayBillAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo(), prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
					}
				}
				if(list2.size()>0){
					blPrpLpayHisAction.insertAll(dbManager, list2);
				}
			}
			if(!"9".equals(vflagHis)&&prpLpayBillHisList.size()>0){
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
						blPrpLpaymainAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo());
					}
				}
			}
			for(int i=0;i<prpLpayBillList.size();i++){
				prpLpayBillDto = (PrpLpayBillDto)prpLpayBillList.get(i);
				blPrpLclaimBillManagerAction.update(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, userCode,"0");
			}
			blPrpLpayBillAction.insertAll(dbManager, prpLpayBillList);
			String paymentNoHis = "";
			if("9".equals(vflagHis)){
				paymentNoHis = paymentNoHis = request.getParameter("paymentNo");
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNoHis+"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void savePayNoBill(DBManager dbManager,HttpServletRequest request,String paymentNo,String billNo,String userCode) throws Exception{
		String editType = request.getParameter("editType");
		String [] certiNos = request.getParameterValues("certiNoPay");//业务单号
		String [] policyNos = request.getParameterValues("policyNoPay");
		String [] registNos = request.getParameterValues("registNoPay");
		String [] paids = request.getParameterValues("paidPay");//支付金额
		String [] serilNos= request.getParameterValues("serilNoPay");
		String vflagHis  = request.getParameter("vflag");
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		ArrayList prpLpayBillList = new ArrayList();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
		ArrayList prpLpayBillHisList = new ArrayList();
		PrpLpayBillDto prpLpayBillDto;
		PrpLpayBillDto prpLpayBillHisDto;
		try {
			for(int i=0;i<certiNos.length;i++){
				prpLpayBillDto = new PrpLpayBillDto();
				prpLpayBillDto.setBillNo(billNo);
				prpLpayBillDto.setPaymentNo(paymentNo);
				prpLpayBillDto.setRegistNo(registNos[i]);
				prpLpayBillDto.setCompensateNo(certiNos[i]);
				prpLpayBillDto.setSerialNo(Integer.parseInt(serilNos[i]));
				prpLpayBillDto.setPayAmount(Double.parseDouble(paids[i]));
				prpLpayBillDto.setBusinessNo(paymentNo);
				prpLpayBillList.add(prpLpayBillDto);
			}
			blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNo+"'");
			blPrpLpayBillAction.insertAll(dbManager, prpLpayBillList);
			String paymentNoHis = "";
			if("9".equals(vflagHis)){
			    paymentNoHis = request.getParameter("paymentNo");
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNoHis+"'");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String saveBillOrupdate(UserDto user,ParamUtils paramUtils,ArrayList prpLbillPayDtoList) throws Exception {
		String submitType = paramUtils.getParameter("submitType");
		String registNoL = "";
        if(prpLbillPayDtoList.size()>0){
      	  PrpLbillPayDto ooPrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(0);
      	  registNoL = ooPrpLbillPayDto.getRegistNo();
        }
		String vflag  = paramUtils.getParameter("vflag");
		
        if (user==null) {
			throw new Exception("session失效");
		}
		String billNo = null;
		if(submitType!=null){
			//预赔、理算环节数据收集
			if("0".equals(submitType)){
				//return savePayMainBill(paramUtils,"");
			}
			//数据暂存
			else if("2".equals(submitType)){
				//return savePayMainBill(paramUtils,"1");
			}
			//数据提交
			else if("4".equals(submitType)){
				//优化修改
				//billNo = savePayMainBill(request,vflag);
				billNo = savePayMainBillByPrepered(user,prpLbillPayDtoList, paramUtils, vflag);
				//判断案件是否冻结begin
				//DAAReviewViewHelper daaReviewViewHelper = new DAAReviewViewHelper();
				boolean status = false;//daaReviewViewHelper.CaseStatus(null, registNo);
				if(status){
					String msg = "案件已冻结，不能提交支付！";
					throw new UserException(1, 3, "", msg);
				}
				//判断案件是否冻结end
				
				//1.自动审核通过
				PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registNoL);
				UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
				String UWflowID = uiWorkFlowApprovalInterFaceFacade
						.submitApprovalPlatform("VeriPay",
								"00", "00", billNo,
										prpLregistDto.getRiskCode(),
										prpLregistDto.getClassCode(),
										prpLregistDto.getComCode(),
										user.getUserCode(), prpLregistDto.getMakeCom(),
										user.getUserCode(), user.getUserCode(),
										billNo);
				if (UWflowID.length() < 15) {
					String msg = "案件'"
							+ billNo
							+ "'提交双核系统失败，请重新提交或者与管理员联系!";
					throw new UserException(1, 3, "工作流", msg);
				}
				BLPrpLpayBillFacade blPrpLpayBillFacade = new BLPrpLpayBillFacade();
				ArrayList list = (ArrayList)blPrpLpayBillFacade.findByPaymentNo(" and billNo ='"+billNo+"' ");
				for(int i=0;i<list.size();i++){
					String businessNo = ((PrpLpayBillDto)list.get(i)).getPaymentNo();
					BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
					PrpLpaymainDto prplpaymainDto =blPrpLpaymainFacade.findByPrimaryKey(businessNo);
					BLPrpLpayExtFacade blPrpLpayExtFacade =new BLPrpLpayExtFacade();
						/*** 报案注销送审核平台 end****/
						new BLPrplpayFacade().updateVFlag("6", businessNo);//更新为正在审核状态
						new BLPrpLpaymainFacade().updateByKey(businessNo, "6");
						new BLPrpLpaymainFacade().updateThirdPayFlag(businessNo, "1");//更新第三方支付标识
						
					/*}*/
					//更新日志完成状态 begin
					new BLPrpLpayExtFacade().updateFlagByPaymentNo(businessNo);//更新日志完成状态
					
				}
				return billNo;
			}
			
		}
		
		return null;
	}
	
	public void savePayBillLink(DBManager dbManager,HttpServletRequest request,String paymentNo,String billNo,int index,String userCode) throws Exception{
		String submitType = request.getParameter("submitType");
		String certiNos = request.getParameterValues("compensateNo")[index];
		String registNos = request.getParameterValues("registNo")[index];
		String paids = request.getParameterValues("payAmount")[index];
		String fkSerialNo = request.getParameterValues("fkSerialNo")[index];
		String payAmounts = request.getParameterValues("payAmounts")[index];
		String vflagHis  = request.getParameterValues("vflag")[index];
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		ArrayList prpLpayBillList = new ArrayList();
		ArrayList prpLpayBillHisList = new ArrayList();
		PrpLpayBillDto prpLpayBillDto;
		PrpLpayBillDto prpLpayBillHisDto;
		
		try {
			String[] serialNo = fkSerialNo.split(",");
			String[] certiNo = certiNos.split(",");
			String[] payAmount = payAmounts.split(",");
			for(int i=0;i<serialNo.length;i++){
				prpLpayBillDto = new PrpLpayBillDto();
				prpLpayBillDto.setBillNo(billNo);
				prpLpayBillDto.setPaymentNo(paymentNo);
				prpLpayBillDto.setRegistNo(registNos);
				prpLpayBillDto.setCompensateNo(certiNo[i]);
				prpLpayBillDto.setSerialNo(Integer.parseInt(serialNo[i]));
				prpLpayBillDto.setPayAmount(Double.parseDouble(payAmount[i]));
				prpLpayBillDto.setBusinessNo(billNo);
				prpLpayBillList.add(prpLpayBillDto);
//				prpLpayBillHisDto = blPrpLpayBillAction.findByPrimaryKey(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
				prpLpayBillHisDto = blPrpLpayBillAction.findByBillFlag(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
				prpLpayBillHisList.add(prpLpayBillHisDto);
			}
			if(!"9".equals(vflagHis)&&prpLpayBillHisList.size()>0){
				PrplpayDto prplpayDto=null;
				PrpLpayHisDto prpLpayHisDto= null;
				PrpLpaymainDto prpLpaymainDto = null;
				BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
				ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
				ArrayList  prplpayDtoList = new ArrayList();
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null){
						String paymentNoHis = prpLpayBillHisDto.getPaymentNo();
						PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)blPrpLclaimBillManagerAction.findByPrimaryKey(dbManager, prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
						if("2".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							if(prpLclaimBillManagerDto!=null){
								prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
								String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+prpLpayBillHisDto.getCompensateNo()+"' and Payamount = "+prpLpayBillHisDto.getPayAmount();
								prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
								PrplpayDto prplpayDto1 = new PrplpayDto();
								if(prplpayDtoList.size()>0){
									prplpayDto1 = (PrplpayDto) prplpayDtoList.get(0);
								}
								prpLpayHisDto = new PrpLpayHisDto();
								setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLclaimBillManagerDto.getPayName());
								prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
								prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
								prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
								prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
								prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
								prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
								prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
								prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
								int count = blPrpLpayHisAction.getCount(dbManager, conditions);
								System.err.println(list2.size());
								prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
								prplpayDto1.setVFlag("8");
								//支付信息历史轨迹表保存接口类型等
								prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
								prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
								prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
								prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
								prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
								prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
								blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
								if(prpLpayHisDto != null){
									list2.add(prpLpayHisDto);
								}
							}
						}else if("5".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
							blPrpLpaymainAction.deleteByConditions(dbManager, " paymentNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
						}
						blPrpLpayBillAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo(), prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
					}
				}
				if(list2.size()>0){
					blPrpLpayHisAction.insertAll(dbManager, list2);
				}
			}
			if(!"9".equals(vflagHis)&&prpLpayBillHisList.size()>0){
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
						blPrpLpaymainAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo());
					}
				}
			}
			for(int i=0;i<prpLpayBillList.size();i++){
				prpLpayBillDto = (PrpLpayBillDto)prpLpayBillList.get(i);
				blPrpLclaimBillManagerAction.update(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, userCode,"0");
			}
			blPrpLpayBillAction.insertAll(dbManager, prpLpayBillList);
			String paymentNoHis = "";
			if("9".equals(vflagHis)){
				paymentNoHis = request.getParameterValues("paymentNo")[index];
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNoHis+"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void savePayBillDelete(DBManager dbManager,HttpServletRequest request,int index,String userCode) throws Exception{
		String editType = request.getParameter("editType");
		String submitType = request.getParameter("submitType");
		String certiNos = request.getParameterValues("compensateNo")[index];
		String registNos = request.getParameterValues("registNo")[index];
		String paids = request.getParameterValues("payAmount")[index];
		String fkSerialNo = request.getParameterValues("fkSerialNo")[index];
		String payAmounts = request.getParameterValues("payAmounts")[index];
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		ArrayList prpLpayBillList = new ArrayList();
		PrpLpayBillDto PrpLpayBillDto;
		try {
			String[] serialNo = fkSerialNo.split(",");
			String[] certiNo = certiNos.split(",");
			String[] payAmount = payAmounts.split(",");
			for(int i=0;i<serialNo.length;i++){
				PrpLpayBillDto = new PrpLpayBillDto();
				PrpLpayBillDto.setRegistNo(registNos);
				PrpLpayBillDto.setCompensateNo(certiNo[i]);
				PrpLpayBillDto.setSerialNo(Integer.parseInt(serialNo[i]));
				prpLpayBillList.add(PrpLpayBillDto);
			}
			for(int i=0;i<prpLpayBillList.size();i++){
				PrpLpayBillDto PrpLpayBillDto1 = (PrpLpayBillDto)prpLpayBillList.get(i);
				blPrpLclaimBillManagerAction.update(dbManager, PrpLpayBillDto1.getRegistNo(), 
						PrpLpayBillDto1.getCompensateNo(), PrpLpayBillDto1.getSerialNo(), 0,userCode, "3");
			}
			String vflagHis  = request.getParameterValues("vflag")[index];
			String paymentNoHis = "";
			String paymentNo = "";
			if("9".equals(vflagHis)){
				paymentNoHis = request.getParameterValues("paymentNo")[index];
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNoHis+"'");
			}else{
				paymentNo = request.getParameterValues("paymentNo")[index];
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNo+"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库prplpaymain
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public String savePayMainBill(HttpServletRequest request,String vflag) throws Exception{
		String editType = request.getParameter("editType");
		String payType = request.getParameter("payType");//支付类型
		String Datatype = request.getParameter("Datatype");//合并支付标志
		String[] receiverTypeOther = request.getParameterValues("receiverTypeOther");//领款人类型代码
		String[] receiverTypeOtherName = request.getParameterValues("receiverTypeOtherName");//领款人类型名称
		String[] receiverFullName = request.getParameterValues("payName");//领款人名称
		String[] receiverFullCode = request.getParameterValues("receiverFullCode");//领款人代码
		String[] certifType = request.getParameterValues("certifType");//领款人证件类型
		String[] certifNo = request.getParameterValues("identifyNumber");//证件号码
		String[] provinceCode = request.getParameterValues("provinceName");//省份
		String[] cityCode = request.getParameterValues("cityName");//城市
		String[] accountType = request.getParameterValues("accountType");
		String[] bankType = request.getParameterValues("bankName");//银行大类
		String[] bank = request.getParameterValues("openBank");//开户银行
		String[] bankAccount = request.getParameterValues("bankAccount");//银行账号
		String[] mobilePhone = request.getParameterValues("mobilePhone");//手机号码
		String[] address = request.getParameterValues("address");//详细地址
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String[] registNo = request.getParameterValues("registNo");
		String nodeType = request.getParameter("nodeType");
		String paymentType = request.getParameter("paymentType");//赔款类型
		String mergerFlag  = request.getParameter("mergerFlag");//合并下发标志
		String[] payAmount = request.getParameterValues("payAmount");
		String[] vflagHis  = request.getParameterValues("vflag");
		/**赔款支付信息新增支付方式 add by zhong begin**/
		String[] payWay = request.getParameterValues("payWay");//支付方式
		String[] payReason = request.getParameterValues("payReason");//支付原因
		String[] payPurpose = request.getParameterValues("payPurpose");//用途说明
		String[] accountFlag = request.getParameterValues("accountFlag");//账号类型
		String[] routeNum = request.getParameterValues("routeNum");//支付行号
		String billFlag = request.getParameter("billFlag");
		String noBillFlag = request.getParameter("noBillFlag");
		String submitType = request.getParameter("submitType");
		String[] deleteFlag = request.getParameterValues("deleteFlag");
		/**赔款支付信息新增支付方式 add by zhong end**/
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo[0]);
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		PrpLpaymainDto prpLpaymainDto = null;
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		DBManager dbManager = new DBManager();
		ArrayList prpLbillPayDtoList = new ArrayList();
		String paymentNo = "";
		String paymentNoHis = "";
		String billNo = "";
		String tableName = "";
		String riskCode = "";
		String comCode = "";
		int year = 0;
		
		vflag = "".equals(vflag)?"1":vflag;
		String strPayPurpose = "";
		boolean isSave = false;
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            
            //无清单按照清单支付时，先更新表prplclaimbillmanager，根据页面导入的清单进行先删后插
    		if(noBillFlag != null && "1".equals(noBillFlag)){
    			saveBillManagerNoBill(dbManager , null, prpLbillPayDtoList);
    		}
            
            if("ADD".equals(editType)&&billFlag!=null&&"1".equals(billFlag)){
	            prpLpaymainDto = new PrpLpaymainDto();
				tableName = "PRPLPAYBILL";
				riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
				comCode = user.getComCode();
				year = new DateTime(DateTime.current().toString()).getYear();
				billNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
            }
          DateTime nowTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
            for(int i=0;i<registNo.length;i++){
            	if("0".equals(deleteFlag[i])){
            		if(null==payPurpose[i]||"".equals(payPurpose[i])){
                		strPayPurpose = "国元理赔";
            		}
                	if("9".equals(vflagHis[i])){
             			editType = "ADD";
             			if("".equals(billNo)&&billFlag!=null&&"1".equals(billFlag)){
             				prpLpaymainDto = new PrpLpaymainDto();
            				tableName = "PRPLPAYBILL";
            				riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
            				comCode = user.getComCode();
            				year = new DateTime(DateTime.current().toString()).getYear();
            				billNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
             			}
             		}
                	
                	if("ADD".equals(editType)){
        				prpLpaymainDto = new PrpLpaymainDto();
        				tableName = "prplpaymain";
        				comCode = user.getComCode();
        				riskCode = this.getRiskCodeByRegistNo(registNo[i], dbManager);
        				year = new DateTime(DateTime.current().toString()).getYear();
        				paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
        				//prplpay 和 prpLpayExt表数据采用先删后插方式
        				blPrpLpaymainAction.delete(dbManager, paymentNo);
        				prpLpaymainDto.setPaymentNo(paymentNo);
        				prpLpaymainDto.setPayType(payType);
        				prpLpaymainDto.setPaymentType(paymentType);
        				prpLpaymainDto.setReceiverTypeOther(receiverTypeOther[i]);
        				prpLpaymainDto.setReceiverTypeOtherName(receiverTypeOtherName[i]);
        				prpLpaymainDto.setReceiverFullName(receiverFullName[i]);
        				prpLpaymainDto.setReceiverFullCode(receiverFullCode[i]);
        				prpLpaymainDto.setCertifNo(certifNo[i]);
        				prpLpaymainDto.setCertifType(certifType[i]);
        				prpLpaymainDto.setProvinceCode(provinceCode[i]);
        				prpLpaymainDto.setCityCode(cityCode[i]);
        				prpLpaymainDto.setAccountType(accountType[i]);
        				prpLpaymainDto.setBankType(bankType[i]);
        				prpLpaymainDto.setBank(bank[i]);
        				prpLpaymainDto.setBankAccount(bankAccount[i]);
        				prpLpaymainDto.setMobilePhone(mobilePhone[i]);
        				prpLpaymainDto.setAddress(address[i]);
        				prpLpaymainDto.setPayAmount(Double.parseDouble(payAmount[i]));
        				prpLpaymainDto.setNode(nodeType);
        				prpLpaymainDto.setVflag("".equals(vflag)?"1":vflag);//保存任务状态
        				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
        				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
        				prpLpaymainDto.setOperatorCode(user.getUserCode());
        				prpLpaymainDto.setInputDate(nowTime);
        				//赔款增加新增第三方支付标识
        				if("1".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
        				}else if("6".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
        				}
        				prpLpaymainDto.setPayWay(payWay[i]);//支付方式
        				prpLpaymainDto.setPayReason(payReason[i]);//支付原因
        				prpLpaymainDto.setPayPurpose(payPurpose[i]);//用途说明
        				prpLpaymainDto.setAccountFlag(accountFlag[i]);//账户类型
        				prpLpaymainDto.setRouteNum(routeNum[i]);//支付行号
        				prpLpaymainDto.setBillFlag(billFlag);
        				if(noBillFlag != null && !"null".equals(noBillFlag)){
        					prpLpaymainDto.setNoBillFlag(noBillFlag);
        				}
        				blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
        				
        				blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
        				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
        			}else if("EDIT".equals(editType)){
        				billNo = request.getParameter("billNo");
        				paymentNo = request.getParameterValues("paymentNo")[i];
        				paymentNoHis = request.getParameterValues("paymentNo")[i];
        				if(paymentNoHis.indexOf("Z")==-1){
        					prpLpaymainDto = new PrpLpaymainDto();
        					tableName = "prplpaymain";
        					riskCode = this.getRiskCodeByRegistNo(registNo[i], dbManager);
        					year = new DateTime(DateTime.current().toString()).getYear();
        					comCode = user.getComCode();
        					paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
        				}else{
        					prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNo);
        				}
        				prpLpaymainDto.setPaymentNo(paymentNo);
        				prpLpaymainDto.setPayType(payType);
        				prpLpaymainDto.setPaymentType(paymentType);
        				prpLpaymainDto.setReceiverTypeOther(receiverTypeOther[i]);
        				prpLpaymainDto.setReceiverTypeOtherName(receiverTypeOtherName[i]);
        				prpLpaymainDto.setReceiverFullName(receiverFullName[i]);
        				prpLpaymainDto.setReceiverFullCode(receiverFullCode[i]);
        				prpLpaymainDto.setCertifNo(certifNo[i]);
        				prpLpaymainDto.setCertifType(certifType[i]);
        				prpLpaymainDto.setProvinceCode(provinceCode[i]);
        				prpLpaymainDto.setCityCode(cityCode[i]);
        				prpLpaymainDto.setAccountType(accountType[i]);
        				prpLpaymainDto.setBankType(bankType[i]);
        				prpLpaymainDto.setBank(bank[i]);
        				prpLpaymainDto.setBankAccount(bankAccount[i]);
        				prpLpaymainDto.setMobilePhone(mobilePhone[i]);
        				prpLpaymainDto.setAddress(address[i]);
        				prpLpaymainDto.setPayAmount(Double.parseDouble(payAmount[i]));
        				prpLpaymainDto.setNode(nodeType);
        				prpLpaymainDto.setVflag(vflag);//保存任务状态
        				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
        				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
        				prpLpaymainDto.setOperatorCode(user.getUserCode());
        				prpLpaymainDto.setInputDate(nowTime);
        				//赔款增加新增第三方支付标识
        				if("1".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
        				}else if("6".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
        				}
        				prpLpaymainDto.setPayWay(payWay[i]);//支付方式
        				prpLpaymainDto.setPayReason(payReason[i]);//支付原因
        				prpLpaymainDto.setPayPurpose(payPurpose[i]);//用途说明
        				prpLpaymainDto.setAccountFlag(accountFlag[i]);//账户类型
        				prpLpaymainDto.setRouteNum(routeNum[i]);//支付行号
        				prpLpaymainDto.setBillFlag(billFlag);
        				prpLpaymainDto.setNoBillFlag(noBillFlag);
        				if(paymentNoHis.indexOf("Z")==-1){
        					blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
        				}else{
        					blPrpLpaymainAction.update(dbManager, prpLpaymainDto);
        				}
        				
        				//prplpay 和 prpLpayExt表数据采用先删后插方式
        				blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
        				blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
        			}
                	if(billFlag!=null&&"1".equals(billFlag)){
        				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
        				savePayBillLink(dbManager,request,paymentNo,billNo,i,user.getUserCode());
        			}
        			savePaysBill(dbManager,nowTime ,user,new ParamUtils(request),null, paymentNo, vflag,i,prpLregistDto.getComCode());
        			isSave = true;
            	}else if("1".equals(deleteFlag[i])){
            		savePayBillHis(dbManager,request,i);
            		savePayBillDelete(dbManager,request,i,user.getUserCode());
            	}
    		}
            if(isSave){
            	blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+billNo+"' ");
            	savePrplpayExtBill(dbManager,new ParamUtils(request),billNo,vflag);
            }
			dbManager.commitTransaction();
		}catch(Exception exception){
			exception.printStackTrace();
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
        return billNo;
	}
	
	/**
	 * 无理赔清单业务，清单支付时更新清单数据，将每次支付的清单数据更新到表中
	 * @param dbManager
	 * @param request
	 * @throws Exception
	 */
	private void saveBillManagerNoBill(DBManager dbManager,ParamUtils paramUtils, ArrayList prpLbillPayDtoList) throws Exception {

		/*String[] compensateNos = request.getParameterValues("compensateNo");//业务单号
		String[] receiverTypeOther = request.getParameterValues("receiverTypeOther");//领款人类型代码
		String[] receiverTypeOtherName = request.getParameterValues("receiverTypeOtherName");//领款人类型名称
		String[] receiverFullName = request.getParameterValues("payName");//领款人名称
		String[] receiverFullCode = request.getParameterValues("receiverFullCode");//领款人代码
		String[] certifType = request.getParameterValues("certifType");//领款人证件类型
		String[] certifNo = request.getParameterValues("identifyNumber");//证件号码
		String[]  policyNo = request.getParameterValues("policyNo");
		String[]  registNo = request.getParameterValues("registNo");
		String[]  claimNo = request.getParameterValues("claimNo");
		String[]  paids = request.getParameterValues("payAmount");//支付金额
		String[] vflagHis  = request.getParameterValues("vflag");
		String[] fkSerialNo = request.getParameterValues("fkSerialNo") ;*/ 
		
		String editType = paramUtils.getParameter("editType");
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		PrpLclaimBillManagerDto prpLclaimBillManagerDto = null ; 
		ArrayList prpLclaimBillManagerList = new ArrayList() ; 
		String conditions = "" ; 
		//conditions = " registno = '"+registNo[0]+"' and policyno = '"+policyNo[0]+"' and compensateno = '"+compensateNos[0]+"' " ; //  and substr(flag , 1, 1) = '1'
		//int serialNo = blPrpLclaimBillManagerAction.getMaxSerialNo(dbManager, conditions)+1;
		for(int i=0;i<prpLbillPayDtoList.size();i++){
			PrpLbillPayDto PrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(i);
			if("9".equals(PrpLbillPayDto.getVflag())){
     			editType = "ADD";
			}
			prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
			prpLclaimBillManagerDto.setRegistNo(PrpLbillPayDto.getRegistNo());
			prpLclaimBillManagerDto.setPolicyNo(PrpLbillPayDto.getPolicyNo());
			prpLclaimBillManagerDto.setCompensateNo(PrpLbillPayDto.getCompensateNo());
			prpLclaimBillManagerDto.setSerialNo(Integer.parseInt(PrpLbillPayDto.getFkSerialNo()));
			prpLclaimBillManagerDto.setPayName(PrpLbillPayDto.getReceiverfullName());
			prpLclaimBillManagerDto.setIdentifyNumber(PrpLbillPayDto.getCertifNo());
			prpLclaimBillManagerDto.setInsuredCode(PrpLbillPayDto.getReceiverfullName());
			prpLclaimBillManagerDto.setOpenBank("");
			prpLclaimBillManagerDto.setBankAccount("");
			prpLclaimBillManagerDto.setSumPaid(PrpLbillPayDto.getPayAmount());
			prpLclaimBillManagerDto.setPayAmount(PrpLbillPayDto.getPayAmount());
			if(PrpLbillPayDto.getPayAmount()==0){
				prpLclaimBillManagerDto.setPayFlag("1");
			}else{
				prpLclaimBillManagerDto.setPayFlag("0");
			}
			prpLclaimBillManagerDto.setFlag("1000000000") ; 
			if("EDIT".equals(editType)){
				conditions = " registno = '"+PrpLbillPayDto.getRegistNo()+"' and policyno = '"+PrpLbillPayDto.getPolicyNo()+"' and compensateno = '"+PrpLbillPayDto.getCompensateNo()+"' and serialno = "+PrpLbillPayDto.getFkSerialNo()+"" ; 
				blPrpLclaimBillManagerAction.deleteByConditions(dbManager,  conditions);
			}
			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
		}
		blPrpLclaimBillManagerAction.insertAll(dbManager, prpLclaimBillManagerList);
	
	}

	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库表prplpay
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void savePaysBill(DBManager dbManager,DateTime nowTime,UserDto user,ParamUtils paramUtils,PrpLbillPayDto iPrpLbillPayDto,String paymentNo,String vflag,int index,String comCode) throws Exception{
		//UserDto user = (UserDto)request.getSession().getAttribute("user");
		String editType = paramUtils.getParameter("editType");
		String payType = paramUtils.getParameter("payType");//支付类型
		String Datatype = paramUtils.getParameter("Datatype");//合并支付标志
		String paymentType = paramUtils.getParameter("paymentType");//赔款类型
		/*String receiverTypeOther = paramUtils.getParameterValues("receiverTypeOther")[index];//领款人类型代码
		String receiverTypeOtherName = paramUtils.getParameterValues("receiverTypeOtherName")[index];//领款人类型名称
		String receiverFullName = paramUtils.getParameterValues("payName")[index];//领款人名称
		String receiverFullCode = request.getParameterValues("receiverFullCode")[index];//领款人代码
		String certifType = request.getParameterValues("certifType")[index];//领款人证件类型
		String certifNo = request.getParameterValues("identifyNumber")[index];//证件号码
		String provinceCode = request.getParameterValues("provinceName")[index];//省份
		String cityCode = request.getParameterValues("cityName")[index];//城市
		String accountType = request.getParameterValues("accountType")[index];
		String bankType = request.getParameterValues("bankName")[index];//银行大类
		String bank = request.getParameterValues("openBank")[index];//开户银行
		String bankAccount = request.getParameterValues("bankAccount")[index];//银行账号
		String mobilePhone = request.getParameterValues("mobilePhone")[index];//手机号码
		String address = request.getParameterValues("address")[index];//详细地址
*/		String nodeType = paramUtils.getParameter("nodeType");
		//String compensateNos = request.getParameterValues("compensateNo")[index];//业务单号
		//String vflagHis  = request.getParameterValues("vflag")[index];
		String paymentNoHis = "";
		
		/*String  policyNo = request.getParameterValues("policyNo")[index];
		String  registNo = request.getParameterValues("registNo")[index];
		String  paids = request.getParameterValues("payAmounts")[index];//支付金额
		String  claimNo = request.getParameterValues("claimNo")[index];
		String  serialNos= request.getParameterValues("fkSerialNo")[index];*/
		String  payrefreasons = paramUtils.getParameter("paymentType");
		
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(iPrpLbillPayDto.getRegistNo());
		ArrayList<PrplpayDto> list =new ArrayList<PrplpayDto>();
		ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
		PrplpayDto prplpayDto=null;
		PrpLpayHisDto prpLpayHisDto= null;
		ArrayList<PrplpayDto> prplpayDtoList=null;
		PrpLpaymainDto prpLpaymainDto = null;
		/*String[] compensateNo = compensateNos.split(",");
		String[] serialNo = serialNos.split(",");
		String[] payAmount = paids.split(",");*/
		//for(int i=0;i<compensateNo.length;i++){
			prplpayDto = new PrplpayDto();
			prplpayDto.setClaimno(iPrpLbillPayDto.getClaimNo());
			prplpayDto.setSerialno(paymentNo);
			prplpayDto.setSerialNo2(1+"");
			prplpayDto.setCompensateno(iPrpLbillPayDto.getCompensateNo());
			prplpayDto.setClasscode(iPrpLbillPayDto.getPolicyNo().substring(1, 3));
			prplpayDto.setRiskcode(iPrpLbillPayDto.getPolicyNo().substring(1,5));
			prplpayDto.setRegistno(iPrpLbillPayDto.getRegistNo());
			prplpayDto.setPolicyno(iPrpLbillPayDto.getPolicyNo());
			prplpayDto.setPaytype(payType);
			
			prplpayDto.setReceivertype("t01");
			double payAmount1 = iPrpLbillPayDto.getPayAmount();
			prplpayDto.setPayamount(payAmount1);
			prplpayDto.setBanktype(iPrpLbillPayDto.getBankType());
			prplpayDto.setBank(iPrpLbillPayDto.getBank());
			prplpayDto.setAccounttype(iPrpLbillPayDto.getAccountType());
			prplpayDto.setReceiverfullname(iPrpLbillPayDto.getReceiverfullName());
			prplpayDto.setCertiftype("01");//被保险人
			prplpayDto.setAddress(iPrpLbillPayDto.getAddress());
			prplpayDto.setCertifno(iPrpLbillPayDto.getCertifNo());
			prplpayDto.setMobilephone(iPrpLbillPayDto.getMobilePhone());
			//prplpayDto.setPayremark(payRemark);
			prplpayDto.setOperatorcode(user.getUserCode());
			prplpayDto.setOperatorComCode(user.getComCode());
			prplpayDto.setInputdate(nowTime);
			prplpayDto.setPaymenttype(payrefreasons);
			prplpayDto.setBankaccount(iPrpLbillPayDto.getBankAccount());
			prplpayDto.setNode(nodeType);
			prplpayDto.setVFlag(vflag);
			prplpayDto.setComCode(comCode);
			
			if("9".equals(iPrpLbillPayDto.getVflag())){
				paymentNoHis = iPrpLbillPayDto.getPaymentNo();
				prpLpayHisDto = new PrpLpayHisDto();
				prplpayDtoList = new ArrayList();
				prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
				String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+iPrpLbillPayDto.getCompensateNo()+"' and Payamount = "+iPrpLbillPayDto.getPayAmount();
				prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
				PrplpayDto prplpayDto1 = new PrplpayDto();
				if(prplpayDtoList.size()>0){
					prplpayDto1 = prplpayDtoList.get(0);
				}
				setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,"被保险人");
				prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
				prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
				prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
				prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
				prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
				prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
				prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
				prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				String conditions1 = " claimNo ='"+iPrpLbillPayDto.getClaimNo()+"' and Compensateno = '"+iPrpLbillPayDto.getCompensateNo()+"' and payType = '"+payType+"'";
				int count = blPrpLpayHisAction.getCount(dbManager, conditions1);
				prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
				prplpayDto1.setVFlag("8");
				//支付信息历史轨迹表保存接口类型等
				prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
				prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
				prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
				prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
				prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
				prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
				blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
			}
			list.add(prplpayDto);
			if(prpLpayHisDto != null){
				list2.add(prpLpayHisDto);
			}
		//}
		blPrpLpaymainAction.delete(dbManager, paymentNoHis);
		blPrplpayAction.insertAll(dbManager, list);
		blPrpLpayHisAction.insertAll(dbManager, list2);
		
	}
	
	private void savePayBillHis(DBManager dbManager,
			HttpServletRequest request, int index) throws Exception {
		String payType = request.getParameter("payType");//支付类型
		String vflagHis  = request.getParameterValues("vflag")[index];
		String compensateNos = request.getParameterValues("compensateNo")[index];//业务单号
		String  paids = request.getParameterValues("payAmounts")[index];//支付金额
		String  claimNo = request.getParameterValues("claimNo")[index];
		String  serialNos= request.getParameterValues("fkSerialNo")[index];
		String receiverTypeOtherName = request.getParameterValues("receiverTypeOtherName")[index];//领款人类型名称
		String paymentNo = "";
		String paymentNoHis = "";
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
		PrplpayDto prplpayDto=null;
		PrpLpayHisDto prpLpayHisDto= null;
		ArrayList<PrplpayDto> prplpayDtoList=null;
		PrpLpaymainDto prpLpaymainDto = null;
		String[] compensateNo = compensateNos.split(",");
		String[] serialNo = serialNos.split(",");
		String[] payAmount = paids.split(",");
		for(int i=0;i<compensateNo.length;i++){
			if("9".equals(vflagHis)){
				paymentNoHis = request.getParameterValues("paymentNo")[index];
				prpLpayHisDto = new PrpLpayHisDto();
				prplpayDtoList = new ArrayList();
				prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
				String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+compensateNo[i]+"' and Payamount = "+payAmount[i];
				prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
				PrplpayDto prplpayDto1 = new PrplpayDto();
				if(prplpayDtoList.size()>0){
					prplpayDto1 = prplpayDtoList.get(0);
				}
				setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,receiverTypeOtherName);
				prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
				prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
				prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
				prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
				prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
				prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
				prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
				prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				String conditions1 = " claimNo ='"+claimNo+"' and Compensateno = '"+compensateNo[i]+"' and payType = '"+payType+"'";
				int count = blPrpLpayHisAction.getCount(dbManager, conditions1);
				prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
				prplpayDto1.setVFlag("8");
				//支付信息历史轨迹表保存接口类型等
				prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
				prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
				prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
				prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
				prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
				prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
				blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
			}else{
				paymentNo =  request.getParameterValues("paymentNo")[index];
				blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+paymentNo+"' ");
				blPrpLpaymainAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNo+"'");
			}
			if(prpLpayHisDto != null){
				list2.add(prpLpayHisDto);
			}
		}
		blPrpLpaymainAction.delete(dbManager, paymentNoHis);
		blPrpLpayHisAction.insertAll(dbManager, list2);
	}
	
	public void paymainNewAddBefore(HttpServletRequest request)throws Exception{
		String[] payType = request.getParameterValues("payType");
		String paymentType = request.getParameter("paymentType");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = null;
		}
		String newPayType = request.getParameter("newPayType");
		  if((null==newPayType || "undefined".equals(newPayType) || "".equals(newPayType))&&(null!=payType&&payType.length>0)){
			  for(int i=0;i<payType.length;i++){
				  if(null!=newPayType&&!"".equals(newPayType)){
					  newPayType += ","+payType[i];
				  }else{
					  newPayType = payType[i];
				  }
			  }
		  }else{
			  if(null!=newPayType && !"undefined".equals(newPayType) && !"".equals(newPayType)){
				  payType = newPayType.split(",");
			  }
		  }
		  
		  request.setAttribute("newPayType", newPayType);
		//每页显示多少条
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = 100;//TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=this.getPayNewADDConditions(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoTNew");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//向下兼容
				//conditions +=sqlStr3 + ")";
			}
		}
        //判断案件类型
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNoTNew");
        request.setAttribute("registNoTNew", registNo);
        if(registNo!=null&&!"".equals(registNo.trim())){
        	paymentType="";
        	conditions = conditions + " and  r.registno = '"+registNo+"' " ;
        }
        PageRecord pr=new BLPrpLpayShowFacade().getNewAddQueryShowList(payType, paymentType, conditions, pageNo, rowsPerPage,casesType,userComCode);
        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
        // 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList)pr.getResult());
		// 当前页号
		turnPageDto.setPageNo(pr.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pr.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pr.getCount());
		// 返回总的页数
		int a=(pr.getCount())%pr.getRowsPerPage();
		if(a>0){
			turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
		}else{
			turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
		}
		
		// 搜索条件
		turnPageDto.setCondition(conditions);
		request.setAttribute("turnPageDto", turnPageDto);
	}
	
	public String getPayNewADDConditions(HttpServletRequest request){
		String conditions = "";
		String strWherePart =request.getParameter("condition"); //页面隐藏的查询条件
		if(strWherePart==null||strWherePart.equals("")){ 
			String registNoFlag = request.getParameter("registNos");
			String registNo = request.getParameter("registNoTNew");
			if ("=".equals(registNoFlag) && !"".equals(registNo)) {
				if (!"".equals(registNo.trim())) {
					conditions += " and r.registNo='" + registNo.trim() + "' ";
				}
			} else if ("*".equals(registNoFlag) && !"".equals(registNo)) {
				if (!"".equals(registNo.trim())) {
					conditions += " and r.registNo like '%" + registNo.trim() + "%'  ";
				}
			}
			String policyNoFlag = request.getParameter("policyNos");
			String policyNo = request.getParameter("policyNo");
			if ("=".equals(policyNoFlag) && !"".equals(policyNo)) {
				if (!"".equals(policyNo.trim())) {
					//conditions += " and r.policyNo='" + policyNo.trim() + "'  ";
					conditions += " and r.registno in (select registno from prplregistrpolicy where policyNo='" + policyNo.trim() + "' ) ";
				}
			} else if ("*".equals(policyNoFlag) && !"".equals(policyNo)) {
				if (!"".equals(policyNo.trim())) {
					//conditions += " and r.policyNo like '%" + policyNo.trim() + "%'  ";
					conditions += " and r.registno in (select registno from prplregistrpolicy where policyNo like '%" + policyNo.trim() + "%' ) ";
				}
			}
			
			String insuredNameFlag = request.getParameter("insuredNames");
			String insuredName = request.getParameter("insuredName");
			if ("=".equals(insuredNameFlag) && !"".equals(insuredNameFlag)) {
				if (!"".equals(insuredName.trim())) {
					conditions += " and r.insuredName='" + insuredName.trim() + "'   ";
				}
			} else if ("*".equals(insuredNameFlag) && !"".equals(insuredNameFlag)) {
				if (!"".equals(insuredName.trim())) {
					conditions += " and r.insuredName like '%" + insuredName.trim() + "%'  ";
				}
			}
			String LicenseNo = request.getParameter("LicenseNo");
			String LicenseNoFlag = request.getParameter("LicenseNos");
			if ("=".equals(LicenseNoFlag) && !"".equals(LicenseNo)) {
				if (!"".equals(LicenseNo.trim())) {
					conditions += " and r.LicenseNo='" + LicenseNo.trim() + "' ";
				}
			} else if ("*".equals(LicenseNoFlag) && !"".equals(LicenseNo)) {
				if (!"".equals(LicenseNo.trim())) {
					conditions += " and r.LicenseNo like '%" + LicenseNo.trim()
							+ "%'  ";
				}
			}
			
			String riskCode = request.getParameter("riskCode");
			if(null!=riskCode && !"".equals(riskCode)){
				conditions += " and r.riskCode in ("+riskCode+")";
			}
			
			// 时间处理
			String inputDateStrat = request.getParameter("inputDateStrat");
			String inputDateEnd = request.getParameter("inputDateEnd");
			if (!"".equals(inputDateStrat) ) {
				conditions += " and underwriteenddate >= " +"to_date('"+inputDateStrat+ " 00:00:00', 'YYYY-MM-DD hh24:mi:ss')";
			}
			if(!"".equals(inputDateEnd) ){
				conditions += " and underwriteenddate <= " +"to_date('"+inputDateEnd+" 23:59:59', 'YYYY-MM-DD hh24:mi:ss')";
			}
			/*if (!"".equals(inputDateStrat) ) {
				conditions += " and underwriteenddate >= '" +inputDateStrat+"'" ;
			}
			if(!"".equals(inputDateEnd) ){
				conditions += " and underwriteenddate <= '" +inputDateEnd+"'"  ;
			}*/
		}else{
			conditions=strWherePart;
		}
		return conditions;
	}
	
	/**
	 * 清单退回删除
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String billDelete(HttpServletRequest request) throws Exception {
		String submitType = request.getParameter("submitType");
		String[] registNos = request.getParameterValues("registNo");
		String registNo = registNos[0];
		String vflag  = request.getParameter("vflag");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
        if (user==null) {
			throw new Exception("session失效");
		}
		String billNo = null;
		if(submitType!=null){
			if("9".equals(submitType)){
				billNo = deletePayMainBill(request,vflag);
				return billNo;
			}
		}
		return null;
	}
	
	public String deletePayMainBill(HttpServletRequest request,String vflag) throws Exception{
		String editType = request.getParameter("editType");
		String payType = request.getParameter("payType");//支付类型
		String Datatype = request.getParameter("Datatype");//合并支付标志
		String[] receiverTypeOther = request.getParameterValues("receiverTypeOther");//领款人类型代码
		String[] receiverTypeOtherName = request.getParameterValues("receiverTypeOtherName");//领款人类型名称
		String[] receiverFullName = request.getParameterValues("payName");//领款人名称
		String[] receiverFullCode = request.getParameterValues("receiverFullCode");//领款人代码
		String[] certifType = request.getParameterValues("certifType");//领款人证件类型
		String[] certifNo = request.getParameterValues("identifyNumber");//证件号码
		String[] provinceCode = request.getParameterValues("provinceName");//省份
		String[] cityCode = request.getParameterValues("cityName");//城市
		String[] accountType = request.getParameterValues("accountType");
		String[] bankType = request.getParameterValues("bankName");//银行大类
		String[] bank = request.getParameterValues("openBank");//开户银行
		String[] bankAccount = request.getParameterValues("bankAccount");//银行账号
		String[] mobilePhone = request.getParameterValues("mobilePhone");//手机号码
		String[] address = request.getParameterValues("address");//详细地址
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String[] registNo = request.getParameterValues("registNo");
		String nodeType = request.getParameter("nodeType");
		String paymentType = request.getParameter("paymentType");//赔款类型
		String mergerFlag  = request.getParameter("mergerFlag");//合并下发标志
		String[] payAmount = request.getParameterValues("payAmount");
		String[] vflagHis  = request.getParameterValues("vflag");
		/**赔款支付信息新增支付方式 add by zhong begin**/
		String[] payWay = request.getParameterValues("payWay");//支付方式
		String[] payReason = request.getParameterValues("payReason");//支付原因
		String[] payPurpose = request.getParameterValues("payPurpose");//用途说明
		String[] accountFlag = request.getParameterValues("accountFlag");//账号类型
		String[] routeNum = request.getParameterValues("routeNum");//支付行号
		String billFlag = request.getParameter("billFlag");
		String noBillFlag = request.getParameter("noBillFlag");
		String submitType = request.getParameter("submitType");
		String[] deleteFlag = request.getParameterValues("deleteFlag");
		/**赔款支付信息新增支付方式 add by zhong end**/
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNo[0]);
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		PrpLpaymainDto prpLpaymainDto = null;
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		DBManager dbManager = new DBManager();
		String paymentNo = "";
		String paymentNoHis = "";
		String billNo = "";
		String tableName = "";
		String riskCode = "";
		String comCode = "";
		int year = 0;
		
		vflag = "".equals(vflag)?"1":vflag;
		String strPayPurpose = "";
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            
          DateTime nowTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
            for(int i=0;i<registNo.length;i++){
            		savePayBillHis(dbManager,request,i);
            		savePayBillDelete(dbManager,request,i,user.getUserCode());
    		}
			dbManager.commitTransaction();
		}catch(Exception exception){
			exception.printStackTrace();
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
        return billNo;
	}
	/**********************************优化修改：start***********************************/
	/*
	 * 此方法针对-- 理赔管理 >> 支付录入 >> 支付清单管理
	 * 防止影响其他功能
	 * */
	public void paymainNewRegistBeforeNew(HttpServletRequest request)throws Exception{
		String payType = request.getParameter("payType");
		String paymentType = request.getParameter("paymentType");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = "";
		}
		//每页显示多少条
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=this.getPayNewConditions(request);
        //优化时额外拼接的方法
        String conditionsAdd=this.getPayNewConditionsAdd(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoT");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//向下兼容
				//conditions +=sqlStr3 + ")";
			}
		}
        //判断案件类型
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNo");
        
        if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
        
        String type = request.getParameter("type");
        //将额外的条件conditionsAdd拼接到conditions开头，用  ABCD 隔开,没有空格
        if(!"".equals(conditionsAdd)&&conditionsAdd!=null&&!"null".equals(conditionsAdd)){
        	conditionsAdd +="ABCD";
        	conditions = conditionsAdd+conditions;
        }
        PageRecord pr=new BLPrpLpayShowFacade().getNewQueryShowRegistListNew(payType, paymentType, conditions, pageNo, rowsPerPage,casesType,userComCode,type);
        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
        // 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList)pr.getResult());
		// 当前页号
		turnPageDto.setPageNo(pr.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pr.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pr.getCount());
		// 返回总的页数
		int a=(pr.getCount())%pr.getRowsPerPage();
		if(a>0){
			turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
		}else{
			turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
		}
		
		// 搜索条件
		turnPageDto.setCondition(conditions);
		request.setAttribute("turnPageDto", turnPageDto);
	}
	/**
	 * 获取额外的查询条件，拼接条件
	 * @param request
	 * @return
	 */
	public String getPayNewConditionsAdd(HttpServletRequest request){
		String conditionsAdd = "";
		String strWherePart =request.getParameter("condition"); //页面隐藏的查询条件
		if(strWherePart==null||strWherePart.equals("")){ 
			
			// 时间处理
			String inputDateStrat = request.getParameter("inputDateStrat");
			String inputDateEnd = request.getParameter("inputDateEnd");
			if (!"".equals(inputDateStrat) ) {
				conditionsAdd += " and underwriteenddate >= " +"to_date('"+inputDateStrat+ " 00:00:00', 'YYYY-MM-DD hh24:mi:ss ')";
			}
			if(!"".equals(inputDateEnd) ){
				conditionsAdd += " and underwriteenddate <= " +"to_date('"+inputDateEnd+" 23:59:59', 'YYYY-MM-DD hh24:mi:ss')";
			}
		}else{
			//额外的条件会添加到原来的conditions保存到页面，所以此处不再取值
			conditionsAdd="";
		}
		return conditionsAdd;
	}
	public void paymainNewBeforeNew(HttpServletRequest request)throws Exception{
		String payType = request.getParameter("payType");
		String paymentType = request.getParameter("paymentType");
		if("undefined".equals(paymentType)){
			paymentType = "";
		}
		if("undefined".equals(payType)){
			payType = "";
		}
		//每页显示多少条
        //int rowsPerPage =Integer.parseInt(AppConfig.get("sysconst.ROWS_PERPAGE"));
        int rowsPerPage = TurnPageUtil.PERPAGE;
        //int rowsPerPage =5;
        //页数
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
        UserDto user = (UserDto)request.getSession().getAttribute("user");
        String userComCode = user.getComCode();
        String conditions=this.getPayNewConditions(request);
      //优化时额外拼接的方法
        String conditionsAdd=this.getPayNewConditionsAdd(request);
        if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
        	conditions=request.getParameter("condition");
		}else{
			 String registNo = request.getParameter("registNoT");
		     if(registNo!=null&&!"".equals(registNo.trim())) paymentType="";
		}
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        String sqlStr = uiPowerInterface.addPower(user, "r", "", "ComCode");
        String sqlStr2 = uiPowerInterface.addPower(user, "ent", "", "resavecom");
        
        
        if (user==null) {
			throw new Exception("session失效");
		}else {
			if (request.getParameter("condition")!=null&&!"".equals(request.getParameter("condition"))&&!"null".equals(request.getParameter("condition"))) {
				if(conditions.indexOf("r.registNo")>-1)  paymentType="";
			}else{
				//conditions+=" and r.comcode like '" + user.getComCode().substring(0, 6) + "%'" ;
				/*String sqlStr3=" or exists (select 1 "+
		        " from prplentrust ent, prplpaytrace paytrace "+
		        " where ent.registno = r.registno "+
		        "  and ent.flag = '1' "+
		        "  and ent.entrustid = paytrace.entrustid "+
		        "  and ent.entrustway in ('1', '2') "+sqlStr2+" ) ";*/
				conditions += " AND ( (1=1 " + sqlStr + "))";//向下兼容
				//conditions +=sqlStr3 + ")";
			}
		}
        //判断案件类型
        String casesType = "";
        String mechanism = request.getParameter("mechanism");
        String agnet = request.getParameter("agnet");
        
        if((mechanism!=null&&!mechanism.trim().equals(""))&&(agnet!=null&&!agnet.trim().equals(""))){
        	casesType = "no";
        }else if(mechanism!=null&&!mechanism.trim().equals("")){
        	casesType = "mechanism";
        }else if(agnet!=null&&!agnet.trim().equals("")){
        	casesType = "agnet";
        }
        String registNo = request.getParameter("registNo");
        
        if(registNo!=null&&!"".equals(registNo.trim())){
        	paymentType="";
        	conditions = conditions + " and  r.registno = '"+registNo+"' " ;
        }
      //将额外的条件conditionsAdd拼接到conditions末尾，用  ABCD 隔开,没有空格
        if(!"".equals(conditionsAdd)&&conditionsAdd!=null&&!"null".equals(conditionsAdd)){
        	conditionsAdd +="ABCD";
        	conditions = conditionsAdd+conditions;
        }
        PageRecord pr=new BLPrpLpayShowFacade().getNewQueryShowListNew(payType, paymentType, conditions, pageNo, rowsPerPage,casesType,userComCode);
        TurnPageDto turnPageDto = new TurnPageDto();// 翻页内容
        // 查询出来的一页的结构集
		turnPageDto.setResultList((ArrayList)pr.getResult());
		// 当前页号
		turnPageDto.setPageNo(pr.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pr.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pr.getCount());
		// 返回总的页数
		int a=(pr.getCount())%pr.getRowsPerPage();
		if(a>0){
			turnPageDto.setTotalPage(((pr.getCount())/pr.getRowsPerPage())+1);
		}else{
			turnPageDto.setTotalPage((pr.getCount())/pr.getRowsPerPage());
		}
		
		// 搜索条件
		turnPageDto.setCondition(conditions);
		request.setAttribute("turnPageDto", turnPageDto);
	}
	
	/**
	 * 此方法用于预赔、理算、支付环节提交保存时收集前端传入的参数并保存到数据库prplpaymain
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public String savePayMainBillByPrepered(UserDto user,ArrayList prpLbillPayDtoList,ParamUtils paramUtils,String vflag) throws Exception{
		
		String editType = paramUtils.getParameter("editType");
		String payType = paramUtils.getParameter("payType");//支付类型----
		String Datatype = paramUtils.getParameter("Datatype");//合并支付标志
		/*String[] receiverTypeOther = request.getParameterValues("receiverTypeOther");//领款人类型代码
		String[] receiverTypeOtherName = request.getParameterValues("receiverTypeOtherName");//领款人类型名称
		String[] receiverFullName = request.getParameterValues("payName");//领款人名称
		String[] receiverFullCode = request.getParameterValues("receiverFullCode");//领款人代码
		String[] certifType = request.getParameterValues("certifType");//领款人证件类型
		String[] certifNo = request.getParameterValues("identifyNumber");//证件号码
		String[] provinceCode = request.getParameterValues("provinceName");//省份
		String[] cityCode = request.getParameterValues("cityName");//城市
		String[] accountType = request.getParameterValues("accountType");
		String[] bankType = request.getParameterValues("bankName");//银行大类
		String[] bank = request.getParameterValues("openBank");//开户银行
		String[] bankAccount = request.getParameterValues("bankAccount");//银行账号
		String[] mobilePhone = request.getParameterValues("mobilePhone");//手机号码
		String[] address = request.getParameterValues("address");//详细地址
*/		
		//String[] registNo = request.getParameterValues("registNo");
		String nodeType = paramUtils.getParameter("nodeType");
		String paymentType = paramUtils.getParameter("paymentType");//赔款类型----
		String mergerFlag  = paramUtils.getParameter("mergerFlag");//合并下发标志
		/*String[] payAmount = request.getParameterValues("payAmount");
		String[] vflagHis  = request.getParameterValues("vflag");
		*//**赔款支付信息新增支付方式 add by zhong begin**//*
		String[] payWay = request.getParameterValues("payWay");//支付方式
		String[] payReason = request.getParameterValues("payReason");//支付原因
		String[] payPurpose = request.getParameterValues("payPurpose");//用途说明
		String[] accountFlag = request.getParameterValues("accountFlag");//账号类型
		String[] routeNum = request.getParameterValues("routeNum");//支付行号
*/		String billFlag = paramUtils.getParameter("billFlag");
		String noBillFlag = paramUtils.getParameter("noBillFlag");
		String submitType = paramUtils.getParameter("submitType");
		//String[] deleteFlag = request.getParameterValues("deleteFlag");
		/**赔款支付信息新增支付方式 add by zhong end**/
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrpLpayExtAction blPrpLpayExtAction = new BLPrpLpayExtAction();
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		PrpLpaymainDto prpLpaymainDto = null;
		BLPrplpayAction  blPrplpayAction = new BLPrplpayAction ();
		DBManager dbManager = new DBManager();
		String paymentNo = "";
		String paymentNoHis = "";
		String billNo = "";
		String tableName = "";
		String riskCode = "";
		String comCode = "";
		int year = 0;
		//新增清单支付导清单是vflag为空
		if(vflag==null)
			vflag="";
		vflag = "".equals(vflag)?"1":vflag;
		String strPayPurpose = "";
		boolean isSave = false;
		PrpLbillPayDto PrpLbillPayDto = null;
//		BLPrpLClaimPaymentAction blPrpLClaimPaymentAction = new BLPrpLClaimPaymentAction();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            
            //无清单按照清单支付时，先更新表prplclaimbillmanager，根据页面导入的清单进行先删后插
    		if(noBillFlag != null && "1".equals(noBillFlag)){
    			saveBillManagerNoBill(dbManager , paramUtils, prpLbillPayDtoList);
    		}
    		String registNoL = "";
    		String compensatenoL = "";
            if(prpLbillPayDtoList.size()>0){
          	  PrpLbillPayDto ooPrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(0);
          	  registNoL = ooPrpLbillPayDto.getRegistNo();
          	  compensatenoL = ooPrpLbillPayDto.getCompensateNo();
          	  
            }
            if("ADD".equals(editType)&&billFlag!=null&&"1".equals(billFlag)){
	            prpLpaymainDto = new PrpLpaymainDto();
				tableName = "PRPLPAYBILL";
				//优化修改
				//riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
				riskCode = this.getRiskCodeByRegistNoByPrepered(registNoL, dbManager);
				comCode = user.getComCode();
				year = new DateTime(DateTime.current().toString()).getYear();
				//优化修改
				//billNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
				billNo = uiBillAction.getNoByPrepered(dbManager,tableName, riskCode,comCode, year,"");
            }
          DateTime nowTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
          
          PrpLregistDto prpLregistDto= blPrpLregistFacade.findByPrimaryKey(registNoL);
          double sumPayamount = 0;
            for(int i=0;i<prpLbillPayDtoList.size();i++){
            	PrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(i);
            	
            	if("0".equals("0")){
            		//if(null==payPurpose[i]||"".equals(payPurpose[i])){
                		strPayPurpose = "国元理赔";
            		//}
                	if("9".equals(PrpLbillPayDto.getVflag())){
             			editType = "ADD";
             			if("".equals(billNo)&&billFlag!=null&&"1".equals(billFlag)){
             				prpLpaymainDto = new PrpLpaymainDto();
            				tableName = "PRPLPAYBILL";
            				//优化修改
            				//riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
            				riskCode = this.getRiskCodeByRegistNoByPrepered(PrpLbillPayDto.getRegistNo(),dbManager);
            				comCode = user.getComCode();
            				year = new DateTime(DateTime.current().toString()).getYear();
            				//优化修改
            				//billNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
            				billNo = uiBillAction.getNoByPrepered(dbManager,tableName, riskCode,comCode, year,"");
             			}
             		}
                	
                	if("ADD".equals(editType)){
        				prpLpaymainDto = new PrpLpaymainDto();
        				tableName = "prplpaymain";
        				comCode = user.getComCode();
        				//优化修改
        				//riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
        				riskCode = this.getRiskCodeByRegistNoByPrepered(PrpLbillPayDto.getRegistNo(), dbManager);
        				year = new DateTime(DateTime.current().toString()).getYear();
        				//优化修改
        				//paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
        				paymentNo = uiBillAction.getNoByPrepered(dbManager,tableName, riskCode,comCode, year,"");

        				//prplpay 和 prpLpayExt表数据采用先删后插方式

        				blPrpLpaymainAction.delete(dbManager, paymentNo);//

        				prpLpaymainDto.setPaymentNo(paymentNo);
        				prpLpaymainDto.setPayType(payType);
        				prpLpaymainDto.setPaymentType(paymentType);
        				prpLpaymainDto.setReceiverTypeOther("t01");
        				prpLpaymainDto.setReceiverTypeOtherName("被保险人");
        				prpLpaymainDto.setReceiverFullName(PrpLbillPayDto.getReceiverfullName());
        				prpLpaymainDto.setReceiverFullCode("");
        				prpLpaymainDto.setCertifNo(PrpLbillPayDto.getCertifNo());
        				prpLpaymainDto.setCertifType("01");
        				prpLpaymainDto.setProvinceCode(PrpLbillPayDto.getProvinceName());
        				prpLpaymainDto.setCityCode(PrpLbillPayDto.getCityName());
        				prpLpaymainDto.setAccountType(PrpLbillPayDto.getAccountType());
        				prpLpaymainDto.setBankType(PrpLbillPayDto.getBankType());
        				prpLpaymainDto.setBank(PrpLbillPayDto.getBank());
        				prpLpaymainDto.setBankAccount(PrpLbillPayDto.getBankAccount());
        				prpLpaymainDto.setMobilePhone(PrpLbillPayDto.getMobilePhone());
        				prpLpaymainDto.setAddress(PrpLbillPayDto.getAddress());
        				prpLpaymainDto.setPayAmount(PrpLbillPayDto.getPayAmount());
        				sumPayamount += PrpLbillPayDto.getPayAmount();
        				prpLpaymainDto.setNode(nodeType);
        				prpLpaymainDto.setVflag("".equals(vflag)?"1":vflag);//保存任务状态
        				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
        				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
        				prpLpaymainDto.setOperatorCode(user.getUserCode());
        				prpLpaymainDto.setInputDate(nowTime);
        				//赔款增加新增第三方支付标识
        				if("1".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
        				}else if("6".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
        				}
        				prpLpaymainDto.setPayWay(PrpLbillPayDto.getPayWay());//支付方式
        				prpLpaymainDto.setPayReason(PrpLbillPayDto.getPayReason());//支付原因
        				prpLpaymainDto.setPayPurpose(PrpLbillPayDto.getPayPurpose());//用途说明
        				prpLpaymainDto.setAccountFlag(PrpLbillPayDto.getAccountFlag());//账户类型
        				prpLpaymainDto.setRouteNum(PrpLbillPayDto.getRouteNum());//支付行号
        				prpLpaymainDto.setBillFlag(billFlag);
        				if(noBillFlag != null && !"null".equals(noBillFlag)){
        					prpLpaymainDto.setNoBillFlag(noBillFlag);
        				}

        				blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);

        				//优化修改
        				//blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");

        				blPrplpayAction.deleteByConditionsByPrepered(dbManager, paymentNo);
 
        				//优化修改
        				//blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");

        				blPrpLpayExtAction.deleteByConditionsByPrepered(dbManager, paymentNo);

        			}else if("EDIT".equals(editType)){/*
        				billNo = request.getParameter("billNo");
        				paymentNo = request.getParameterValues("paymentNo")[i];
        				paymentNoHis = request.getParameterValues("paymentNo")[i];
        				if(paymentNoHis.indexOf("Z")==-1){
        					prpLpaymainDto = new PrpLpaymainDto();
        					tableName = "prplpaymain";
        					//优化修改
        					//riskCode = this.getRiskCodeByRegistNo(registNo[0], dbManager);
        					riskCode = this.getRiskCodeByRegistNoByPrepered(registNo[i], dbManager);
        					year = new DateTime(DateTime.current().toString()).getYear();
        					comCode = user.getComCode();
        					//优化修改
        					//paymentNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");
        					paymentNo = uiBillAction.getNoByPrepered(dbManager,tableName, riskCode,comCode, year,"");
        				}else{
        					prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNo);
        				}
        				prpLpaymainDto.setPaymentNo(paymentNo);
        				prpLpaymainDto.setPayType(payType);
        				prpLpaymainDto.setPaymentType(paymentType);
        				prpLpaymainDto.setReceiverTypeOther(receiverTypeOther[i]);
        				prpLpaymainDto.setReceiverTypeOtherName(receiverTypeOtherName[i]);
        				prpLpaymainDto.setReceiverFullName(receiverFullName[i]);
        				prpLpaymainDto.setReceiverFullCode(receiverFullCode[i]);
        				prpLpaymainDto.setCertifNo(certifNo[i]);
        				prpLpaymainDto.setCertifType(certifType[i]);
        				prpLpaymainDto.setProvinceCode(provinceCode[i]);
        				prpLpaymainDto.setCityCode(cityCode[i]);
        				prpLpaymainDto.setAccountType(accountType[i]);
        				prpLpaymainDto.setBankType(bankType[i]);
        				prpLpaymainDto.setBank(bank[i]);
        				prpLpaymainDto.setBankAccount(bankAccount[i]);
        				prpLpaymainDto.setMobilePhone(mobilePhone[i]);
        				prpLpaymainDto.setAddress(address[i]);
        				prpLpaymainDto.setPayAmount(Double.parseDouble(payAmount[i]));
        				prpLpaymainDto.setNode(nodeType);
        				prpLpaymainDto.setVflag(vflag);//保存任务状态
        				prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
        				prpLpaymainDto.setComCode(prpLregistDto.getComCode());//一般是承保机构
        				prpLpaymainDto.setOperatorCode(user.getUserCode());
        				prpLpaymainDto.setInputDate(nowTime);
        				//赔款增加新增第三方支付标识
        				if("1".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("0");//暂存 待提交
        				}else if("6".equals(vflag)){
        					prpLpaymainDto.setThirdPayFlag("1");//提交 待审核
        				}
        				prpLpaymainDto.setPayWay(payWay[i]);//支付方式
        				prpLpaymainDto.setPayReason(payReason[i]);//支付原因
        				prpLpaymainDto.setPayPurpose(payPurpose[i]);//用途说明
        				prpLpaymainDto.setAccountFlag(accountFlag[i]);//账户类型
        				prpLpaymainDto.setRouteNum(routeNum[i]);//支付行号
        				prpLpaymainDto.setBillFlag(billFlag);
        				prpLpaymainDto.setNoBillFlag(noBillFlag);
        				if(paymentNoHis.indexOf("Z")==-1){
        					blPrpLpaymainAction.insert(dbManager, prpLpaymainDto);
        				}else{
        					blPrpLpaymainAction.update(dbManager, prpLpaymainDto);
        				}
        				
        				//prplpay 和 prpLpayExt表数据采用先删后插方式
        				//优化修改
        				//blPrplpayAction.deleteByConditions(dbManager, " serialno='"+paymentNo+"' ");
        				blPrplpayAction.deleteByConditionsByPrepered(dbManager, paymentNo);
        				//优化修改
        				//blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");
        				blPrpLpayExtAction.deleteByConditionsByPrepered(dbManager, paymentNo);
        			*/}
                	if(billFlag!=null&&"1".equals(billFlag)){
                		//优化修改
        				//blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo='"+paymentNo+"' ");

        				blPrpLpayBillAction.deleteByConditionsByPrepered(dbManager, paymentNo);


        				//优化修改
        				//savePayBillLink(dbManager,request,paymentNo,billNo,i,user.getUserCode());//??????????????????
        				savePayBillLinkByprepered(dbManager,paramUtils, PrpLbillPayDto,paymentNo,billNo,i,user.getUserCode());

        			}

        			savePaysBill(dbManager,nowTime,user,paramUtils, PrpLbillPayDto, paymentNo, vflag,i,prpLregistDto.getComCode());//??????????????????????
  
        			isSave = true;
            	} /*else if("1".equals(deleteFlag[i])){
            		savePayBillHis(dbManager,request,i);
            		savePayBillDelete(dbManager,request,i,user.getUserCode());
            	}*/
    		}
            if("ADD".equals(editType)){
    			if(compensatenoL!=null && !"".equals(compensatenoL)){
					String certiNo = compensatenoL;
//					PrpLClaimPaymentDto prpLClaimPaymentDto = blPrpLClaimPaymentAction.findByPrimaryKey(dbManager, certiNo, "P60");
//					double inputedFee = prpLClaimPaymentDto.getInputedFee();
//					double paidPay = Str.round(sumPayamount,2);
//					prpLClaimPaymentDto.setInputedFee(inputedFee+paidPay);
//					blPrpLClaimPaymentAction.update(dbManager, prpLClaimPaymentDto);
    			}
    		}
            
            if(isSave){
            	//优化修改
            	//blPrpLpayExtAction.deleteByConditions(dbManager, " paymentNo='"+billNo+"' ");
            	blPrpLpayExtAction.deleteByConditionsByPrepered(dbManager, billNo);
            	savePrplpayExtBill(dbManager,paramUtils,billNo,vflag);
            }
			dbManager.commitTransaction();
		}catch(Exception exception){
			exception.printStackTrace();
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
        return billNo;
	}
	public String getRiskCodeByRegistNoByPrepered(String registNo,DBManager dbManager) throws Exception {
		String riskCode = "";
		try{
			String condi = "select classCode from prplclaim where registNo = ? ";
			dbManager.prepareStatement(condi);
			dbManager.setString(1, registNo);
			ResultSet rs = dbManager.executePreparedQuery();
			String classCode = "";
			while(rs.next()){
				classCode = rs.getString("classCode");
			}
			rs.close();
			riskCode = classCode + "00";
		}catch(Exception e){
			e.printStackTrace();
		}
		return riskCode;
	}
	public void savePayBillLinkByprepered(DBManager dbManager,ParamUtils paramUtils,PrpLbillPayDto iPrpLbillPayDto,String paymentNo,String billNo,int index,String userCode) throws Exception{
		String submitType = paramUtils.getParameter("submitType");
		/*String certiNos = paramUtils.getParameterValues("compensateNo")[index];
		String registNos = paramUtils.getParameterValues("registNo")[index];
		String paids = request.getParameterValues("payAmount")[index];
		String fkSerialNo = request.getParameterValues("fkSerialNo")[index];
		String payAmounts = request.getParameterValues("payAmounts")[index];
		String vflagHis  = request.getParameterValues("vflag")[index];*/
		BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
		BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
		BLPrplpayAction blPrplpayAction = new BLPrplpayAction();
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		ArrayList prpLpayBillList = new ArrayList();
		ArrayList prpLpayBillHisList = new ArrayList();
		PrpLpayBillDto prpLpayBillDto;
		PrpLpayBillDto prpLpayBillHisDto;
		
		try {
			/*String[] serialNo = fkSerialNo.split(",");
			String[] certiNo = certiNos.split(",");
			String[] payAmount = payAmounts.split(",");*/
			//for(int i=0;i<serialNo.length;i++){
				prpLpayBillDto = new PrpLpayBillDto();
				prpLpayBillDto.setBillNo(billNo);
				prpLpayBillDto.setPaymentNo(paymentNo);
				prpLpayBillDto.setRegistNo(iPrpLbillPayDto.getRegistNo());
				prpLpayBillDto.setCompensateNo(iPrpLbillPayDto.getCompensateNo());
				prpLpayBillDto.setSerialNo(Integer.parseInt(iPrpLbillPayDto.getFkSerialNo()));
				prpLpayBillDto.setPayAmount(iPrpLbillPayDto.getPayAmount());
				prpLpayBillDto.setBusinessNo(billNo);
				prpLpayBillList.add(prpLpayBillDto);
				/************************************/
//				prpLpayBillHisDto = blPrpLpayBillAction.findByPrimaryKey(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
				prpLpayBillHisDto = blPrpLpayBillAction.findByBillFlag(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo());
				/************************************/
				prpLpayBillHisList.add(prpLpayBillHisDto);
			//}
			if(!"9".equals(iPrpLbillPayDto.getVflag())&&prpLpayBillHisList.size()>0){
				PrplpayDto prplpayDto=null;
				PrpLpayHisDto prpLpayHisDto= null;
				PrpLpaymainDto prpLpaymainDto = null;
				BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
				ArrayList<PrpLpayHisDto> list2 = new ArrayList<PrpLpayHisDto>();
				ArrayList  prplpayDtoList = new ArrayList();
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null){
						String paymentNoHis = prpLpayBillHisDto.getPaymentNo();
						PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)blPrpLclaimBillManagerAction.findByPrimaryKey(dbManager, prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
						if("2".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							if(prpLclaimBillManagerDto!=null){
								prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
								//优化修改
								/*
								String conditions = " Serialno = '"+paymentNoHis+"' and Compensateno = '"+prpLpayBillHisDto.getCompensateNo()+"' and Payamount = "+prpLpayBillHisDto.getPayAmount();
								prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSql(dbManager, conditions);
								*/
								String conditions = " Serialno = ? and Compensateno = ? and Payamount = ? ";
								prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSqlByPrepered(dbManager, conditions,paymentNoHis,prpLpayBillHisDto.getCompensateNo(),prpLpayBillHisDto.getPayAmount());
								
								PrplpayDto prplpayDto1 = new PrplpayDto();
								if(prplpayDtoList.size()>0){
									prplpayDto1 = (PrplpayDto) prplpayDtoList.get(0);
								}
								prpLpayHisDto = new PrpLpayHisDto();
								setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLclaimBillManagerDto.getPayName());
								prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
								prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
								prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
								prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
								prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
								prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
								prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
								prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
								//优化修改
								//int count = blPrpLpayHisAction.getCount(dbManager, conditions);
								int count = blPrpLpayHisAction.getCountByPrepered(dbManager, conditions,paymentNoHis,prpLpayBillHisDto.getCompensateNo(),prpLpayBillHisDto.getPayAmount());
								
								System.err.println(list2.size());
								prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
								prplpayDto1.setVFlag("8");
								//支付信息历史轨迹表保存接口类型等
								prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
								prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
								prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
								prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
								prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
								prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
								//此处需要判断支付信息是否为退回状态
								if(!checkPayVflag(prplpayDto1.getSerialno())) 
		        					throw new Exception("支付编号"+prplpayDto1.getSerialno()+"为非退回状态不允许操作");
								blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
								if(prpLpayHisDto != null){
									list2.add(prpLpayHisDto);
								}
							}
						}else if("5".equals(prpLclaimBillManagerDto.getPayFlag())&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
							//此处需要判断支付信息是否为退回状态
							if(!checkPayVflag(prpLpayBillHisDto.getPaymentNo())) 
	        					throw new Exception("支付编号"+prpLpayBillHisDto.getPaymentNo()+"为非退回状态不允许操作");
							blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
							blPrpLpaymainAction.deleteByConditions(dbManager, " paymentNo = '"+prpLpayBillHisDto.getPaymentNo()+"'");
//						}else{
//							//转储多窗口导致的重复
//							prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager, paymentNoHis);
//							if(prpLpaymainDto==null){
//								prpLpaymainDto=new PrpLpaymainDto();
//							}
//							String conditions = " Serialno = ? and Compensateno = ? and Payamount = ? ";
//							prplpayDtoList = (ArrayList)blPrplpayAction.findByConditionsSqlByPrepered(dbManager, conditions,paymentNoHis,prpLpayBillHisDto.getCompensateNo(),prpLpayBillHisDto.getPayAmount());
//							
//							PrplpayDto prplpayDto1 = new PrplpayDto();
//							if(prplpayDtoList.size()>0){
//								prplpayDto1 = (PrplpayDto) prplpayDtoList.get(0);
//								prpLpayHisDto = new PrpLpayHisDto();
//								setPrpLpayTransPrpLpayHis(prplpayDto1,prpLpayHisDto,prpLclaimBillManagerDto.getPayName());
//								prpLpayHisDto.setProvinceCode(prpLpaymainDto.getProvinceCode());
//								prpLpayHisDto.setCityCode(prpLpaymainDto.getCityCode());
//								prpLpayHisDto.setUrgentType(prpLpaymainDto.getUrgentType());
//								prpLpayHisDto.setQqNumber(prpLpaymainDto.getQqNumber());
//								prpLpayHisDto.setEmail(prpLpaymainDto.getEmail());
//								prpLpayHisDto.setUnitLink(prpLpaymainDto.getUnitLink());
//								prpLpayHisDto.setPostCode(prpLpaymainDto.getPostCode());
//								prpLpayHisDto.setEditDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
//								//优化修改
//								//int count = blPrpLpayHisAction.getCount(dbManager, conditions);
//								int count = blPrpLpayHisAction.getCountByPrepered(dbManager, conditions,paymentNoHis,prpLpayBillHisDto.getCompensateNo(),prpLpayBillHisDto.getPayAmount());
//								
//								System.err.println(list2.size());
//								prpLpayHisDto.setSerialNo2(String.valueOf(list2.size()+(++count)));
////								prplpayDto1.setVFlag("8");
//								//支付信息历史轨迹表保存接口类型等
//								prpLpayHisDto.setPayWay(prpLpaymainDto.getPayWay());
//								prpLpayHisDto.setPayReason(prpLpaymainDto.getPayReason());
//								prpLpayHisDto.setPayPurpose(prpLpaymainDto.getPayPurpose());
//								prpLpayHisDto.setAccountFlag(prpLpaymainDto.getAccountFlag());
//								prpLpayHisDto.setInterType(prpLpaymainDto.getInterType());
//								prpLpayHisDto.setRouteNum(prpLpaymainDto.getRouteNum());
////								blPrplpayAction.delete(dbManager, prplpayDto1.getSerialno(), prplpayDto1.getCompensateno(), prplpayDto1.getSerialNo2());
//								if(prpLpayHisDto != null){
//									list2.add(prpLpayHisDto);
//								}
//							}
							
						}
						//
						blPrpLpayBillAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo(), prpLpayBillHisDto.getRegistNo(), prpLpayBillHisDto.getCompensateNo(), prpLpayBillHisDto.getSerialNo());
					
					}
				}
				if(list2.size()>0){
					blPrpLpayHisAction.insertAll(dbManager, list2);
				}
			}
			if(!"9".equals(iPrpLbillPayDto.getVflag())&&prpLpayBillHisList.size()>0){
				for(int i=0;i<prpLpayBillHisList.size();i++){
					prpLpayBillHisDto = (PrpLpayBillDto)prpLpayBillHisList.get(i);
					if(prpLpayBillHisDto!=null&&!paymentNo.equals(prpLpayBillHisDto.getPaymentNo())){
						//此处需要判断支付信息是否为退回状态
						if(!checkPayVflag(prpLpayBillHisDto.getPaymentNo())) 
        					throw new Exception("支付编号"+prpLpayBillHisDto.getPaymentNo()+"为非退回状态不允许操作");
						//多窗口重复录入在这里删除prplpay 数据,2017-08-01是为了防止删除了历史数据
//						blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+prpLpayBillHisDto.getPaymentNo()+"' and inputdate>=date'2017-08-01' ");
						blPrplpayAction.deleteByConditions(dbManager, " serialNo = '"+prpLpayBillHisDto.getPaymentNo()+"'  ");
						blPrpLpaymainAction.delete(dbManager, prpLpayBillHisDto.getPaymentNo());
					}
				}
			}
			for(int i=0;i<prpLpayBillList.size();i++){
				prpLpayBillDto = (PrpLpayBillDto)prpLpayBillList.get(i);
				//
				blPrpLclaimBillManagerAction.update(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, userCode,"0");
			}
			blPrpLpayBillAction.insertAll(dbManager, prpLpayBillList);
			String paymentNoHis = "";
			if("9".equals(iPrpLbillPayDto.getVflag())){
				paymentNoHis = iPrpLbillPayDto.getPaymentNo();
				blPrpLpayBillAction.deleteByConditions(dbManager, " paymentNo = '"+paymentNoHis+"'");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*********************************优化修改：end************************************/
	/**
	 * 支付信息删除前需要判断是否退回状态，否则不允许删除
	 */
	public boolean checkPayVflag(String paymentNo) throws Exception {
		boolean ifThirdPay = true;
		DBManager dbManager = new DBManager();
		try{
			//第一步判断是否退回
			String checkLpay = "select count(1) from prplpaymain where " +
			" paymentno = '"+paymentNo+"' and vflag not in ('9','3','7')  ";
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            ResultSet rs = dbManager.executeQuery(checkLpay);
			if(rs.next()){
            	if(dbManager.getInt(rs,1)!=0){
            		ifThirdPay =false;
            	}else{
                	ifThirdPay = true;
                }
            }
			rs.close();
			if(!ifThirdPay){
				return ifThirdPay;
			}
			//第二步判断第三方是否为退回状态
			String checkQuery = "select count(1) from thirdpay_platform.prpqpaymain where " +
								" visaserialno = '"+paymentNo+"' and flag not in ('4','14','15')";
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            ResultSet rss = dbManager.executeQuery(checkQuery);
            if(rss.next()){
            	if(dbManager.getInt(rss,1)!=0){
            		ifThirdPay =false;
            	}else{
                	ifThirdPay = true;
                }
            }
            rss.close();
            if(!ifThirdPay){
				return ifThirdPay;
			}
          //第三步判断第三方his是否为退回状态
            String checkQueryhis = "select count(1) from thirdpay_platform.prpqpaymainhis where " +
			" visaserialno = '"+paymentNo+"' and flag not in ('4','14','15')";
		    ResultSet rsss = dbManager.executeQuery(checkQueryhis);
		    if(rsss.next()){
		    	if(dbManager.getInt(rsss,1)!=0){
		    		ifThirdPay = false;
		    	}else{
		        	ifThirdPay =true;
		        }
		    }
		    rsss.close();
		    
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			dbManager.close();
		}
		return ifThirdPay;
	}
}
