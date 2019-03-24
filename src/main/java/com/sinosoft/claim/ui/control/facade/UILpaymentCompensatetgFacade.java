package com.sinosoft.claim.ui.control.facade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpJpaymentpackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBillFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBilltgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.newClaim.bl.facade.BLSwfLogFacade;
import com.sinosoft.newClaim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.newClaim.dto.domain.SwfLogDto;
import com.sinosoft.newClaim.dto.domain.SwfLogStoreDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;

public class UILpaymentCompensatetgFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forword = "success";
		String conditions = "";
		String editType = request.getParameter("editType");
		String[] compensate = request.getParameterValues("compensateNo");
		String[] isChecked = request.getParameterValues("isChecked");
		String registNo = request.getParameter("registNoPay");
		String back = request.getParameter("back");
		String type = request.getParameter("type");
		String[] payKey = request.getParameterValues("payKey");
		String pageConditions = request.getParameter("pageConditions");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String selectBillFlag = request.getParameter("selectBillFlag");
		String noBillFlag = request.getParameter("noBillFlag");
		String nodeType= request.getParameter("nodeType");
		int rowsPerPage = 999;
        int pageNo = Integer.parseInt(request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")+"");
		BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
		PageRecord pr = null;
		PrpLpayExtDto prpLpayExtDtoNew = null;
		ArrayList<PrpLpayExtDto> prpLpayExtDtoList = new ArrayList<PrpLpayExtDto>();
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList billManagerList = new ArrayList();
		BLPrpLpayExtFacade blPrpLpayExtFacade = new BLPrpLpayExtFacade();
		ArrayList prpLclaimBillManagerList = new ArrayList();
		boolean isAccBack = false;
		try {
			if("ADD".equals(editType)){
				if(compensate!=null && compensate.length>0){
					for(int i=0;i<compensate.length;i++){
						if(isChecked!=null&&"1".equals(isChecked[i])){
							if("".equals(conditions)){
								conditions += " and te.compensateNo in ('"+compensate[i]+"'";
							}else{
								conditions += ",'"+compensate[i]+"'";
							}
						}
						
					}
					if(!"".equals(conditions)){
						conditions += ")";
					}else{
						
					}
					
				}
				if("6".equals(type)){
					editType = "SHOW";
					String registnoSign = request.getParameter("registnoSign");
			        String policynoSign = request.getParameter("policynoSign");
			        String insuredNameSign = request.getParameter("insuredNameSign");
			        String registno = request.getParameter("registno");
			        String policyno = request.getParameter("policyno");
			        String insuredName = request.getParameter("insuredName");
			        if (!registno.equals("")) {
		        		if("*".equals(registnoSign)){
		        			conditions += " and rr.registno like '%"+registno+"%'";
		        		}else if("=".equals(registnoSign)){
		        			conditions += " and rr.registno = '"+registno+"'";
		        		}
		        	}
		        	//保单号码
		        	if (!policyno.equals("")) {
		        		if("*".equals(policynoSign)){
		        			conditions += " and rr.policyno like '%"+policyno+"%'";
		        		}else if("=".equals(policynoSign)){
		        			conditions += " and rr.policyno = '"+policyno+"'";
		        		}
		        	}
		        	//被保险人
		        	if (!insuredName.equals("")) {
		        		if("*".equals(insuredNameSign)){
		        			conditions += " and exists (select 1 from prplregist where  rr.registno = prplregist.registno and prplregist.insuredname like '%"+insuredName+"%' )";
		        			//conditions += " and rr.insuredname like '%"+insuredName+"%'";
		        		}else if("=".equals(insuredNameSign)){
		        			//conditions += "and rr.insuredname = '"+insuredName+"'";
		        			conditions += " and exists (select 1 from prplregist where  rr.registno = prplregist.registno and prplregist.insuredname = '"+insuredName+"' )";
		        		}
		        	}
					UIPowerInterface uiPowerInterface = new UIPowerInterface();
					String sqlStr = uiPowerInterface.addPower(user, "te", "", "ComCode");
					conditions += sqlStr;;
					conditions += " and payflag = '3' ";
					conditions += " and substr(rr.flag , 1 ,1 ) = '0' " ; 
				}else{
					if(back!=null&&"1".equals(back)&&!"".equals(conditions)){
						conditions += " and (payflag in ('0','3') or (payflag in ('2','5') and rr.operatorcode='"+user.getUserCode()+"') )";
					}else if(!"".equals(conditions)){
						conditions += " and payflag in ('0','3') ";
					}
				}
				if(conditions==null||"".equals(conditions)){
					conditions = pageConditions;
				}
				request.setAttribute("pageConditions", conditions);
				if(selectBillFlag!=null&&"1".equals(selectBillFlag)){
					if(payKey!=null&&payKey.length>0){
						for(int i=0;i<payKey.length;i++){
							if(i==0){
								conditions += " and (rr.payname||'_'||rr.identifynumber) in ('"+payKey[i]+"'";
							}else{
								conditions += ",'"+payKey[i]+"'";
							}
						}
						conditions += ")";
					}
					pageNo = 1;
				}
				if(noBillFlag != null && "1".equals(noBillFlag)){
					conditions += " and substr(rr.flag , 1 ,1 ) = '0' " ; 
				}
				pr = blPrpLclaimBillManagerFacade.findByConditonSum(conditions,editType,back,rowsPerPage,pageNo);
				prpLclaimBillManagerList = (ArrayList)pr.getResult();
				request.setAttribute("prpLclaimBillManagerList", prpLclaimBillManagerList);
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
				if(prpLclaimBillManagerList!=null&&prpLclaimBillManagerList.size()>0){
					if(prpLclaimBillManagerList.size()==1){
						starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0)).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLclaimBillManagerList.size();i++){
							String bDate = ((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate();
							String eDate = ((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate();
							int temp =DateCompute.compareDate(bDate,eDate);
							if(temp>=0){
								starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate();
							}else{
								starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate();
							}
						}
					}
				}
				
				DateTime now = new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND);
				costTime = DateCompute.intervalDateTime(starDate, now.toString(), DateCompute.DAY_TO_MINUTE);
				prpLpayExtDtoNew.setCostTime(costTime);
				prpLpayExtDtoNew.setOperatorCode(user.getUserCode());
				prpLpayExtDtoNew.setOperatorCodeName(user.getUserName());
				prpLpayExtDtoNew.setNotionCode("0");
				prpLpayExtDtoNew.setNotionName("未处理");
			}else if("EDIT".equals(editType)){
				String billNo = request.getParameter("billNo");
				if(billNo!=null&&!"".equals(billNo)){
					conditions += " 1=1 and billNo='"+billNo+"'";
				}else{
					conditions += "1=1";
				}
				if("3".equals(type)){
					conditions += "and nn.thirdpayflag in ('2','4','8')";
				}else{
					conditions += "and nn.thirdpayflag ='0' ";
				}
				
				pr = blPrpLclaimBillManagerFacade.findByConditonBillSum(conditions,editType,rowsPerPage,pageNo);
				prpLclaimBillManagerList = (ArrayList)pr.getResult();
				request.setAttribute("prpLclaimBillManagerList", prpLclaimBillManagerList);
				request.setAttribute("billNo", billNo);
				
				if(billNo!=null&&!"".equals(billNo)){
					String payExtSql = " paymentNo = '"+billNo+"' and  flag='Y' order by inputdate "	;
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
					if(prpLclaimBillManagerList!=null&&prpLclaimBillManagerList.size()>0){
						if(prpLclaimBillManagerList.size()==1){
							starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0)).getUnderWriteEndDate();
						}else{
							for(int i=1;i<prpLclaimBillManagerList.size();i++){
								
								int temp =DateCompute.compareDate(((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate(),((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate());
								if(temp>=0){
									starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate();
								}else{
									starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate();
								}
							}
						}
					}
					
					this.getCostTime(prpLpayExtDtoList, starDate);
					
					
				}
				//最后一条处理意见
				String payExtSql = " paymentNo = '"+billNo+"' and flag= 'N' "	;
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
//				StringBuffer bf = new StringBuffer(200);
//				if(registNos!=null&&registNos.size()>0){
//					bf.append(" and registNo in ( ");
//		    		for(int i=0;i<registNos.size();i++){
//		    			if(i!=0)bf.append(" , ");
//		    			bf.append(" '"+registNos.get(i).trim()+"' ");
//		    		}
//		    		bf.append(" ) ");
//		    	}
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
					if(prpLclaimBillManagerList!=null&&prpLclaimBillManagerList.size()>0){
						if(prpLclaimBillManagerList.size()==1){
							starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0)).getUnderWriteEndDate();
						}else{
							for(int i=1;i<prpLclaimBillManagerList.size();i++){
								
								int temp =DateCompute.compareDate(((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate(),((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate());
								if(temp>=0){
									starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate();
								}else{
									starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate();
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
				//prpLpayExtDtoNew.setNotionCode("0");
				//prpLpayExtDtoNew.setNotionName("未处理");
				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
				PrpLpaymainDto prpLpaymainDto = null;
				String backReason = "";
				boolean isUnBack = false;
				for(int i=0;i<prpLclaimBillManagerList.size();i++){
					PrpLclaimBillManagerDto  prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i);
					prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(prpLclaimBillManagerDto.getPaymentNo());
					backReason = prpLpaymainDto.getPayRemark();
					if("".equals(backReason)){
						BLPrpJpaymentpackDetailFacade blPrpJpaymentpackDetailFacade = new BLPrpJpaymentpackDetailFacade();
						String iWherePart = " VISASERIALNO = '"+prpLpaymainDto.getPaymentNo()+"'";
						blPrpJpaymentpackDetailFacade.query(iWherePart);
						if(blPrpJpaymentpackDetailFacade.getSize()>0){
							backReason =  blPrpJpaymentpackDetailFacade.getArr(0).getBackReason();
							prpLclaimBillManagerDto.setPayReMark(backReason);
						}
						isUnBack = true;
					}
				}
				
				PrpLpayExtDto prpLpayExtDtoNew1 = new PrpLpayExtDto();
				if(!"".equals(prpLpaymainDto.getBackDate())&&!"".equals(backReason)){
					if(isUnBack){
						isAccBack = true;
					}
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
				
			}else{
				String billNo = request.getParameter("billNo");
				//add by wxy 2018-8-17 17:34:10 添加新农险区分判断和委托险种判断
				boolean agriFlag = false;
				boolean wtFlag = false;
				List<PrpLpayBillDto> prpLpayBillDtoList = new ArrayList<PrpLpayBillDto>();
				BLPrpLpayBillFacade blPrpLpayBillFacade = new BLPrpLpayBillFacade();
				prpLpayBillDtoList = (List<PrpLpayBillDto>)blPrpLpayBillFacade.findByConditions(" billno='"+billNo+"'");
				if(prpLpayBillDtoList==null || prpLpayBillDtoList.size()<=0){
					BLPrpLpayBilltgFacade blPrpLpayBilltgFacade = new BLPrpLpayBilltgFacade();
					prpLpayBillDtoList = (List<PrpLpayBillDto>)blPrpLpayBilltgFacade.findByConditions(" billno='"+billNo+"'");
					wtFlag = true;
				}
				if(prpLpayBillDtoList!=null && prpLpayBillDtoList.size()>0){
					List<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
					List<SwfLogStoreDto> swfLogStoreDtoList = new ArrayList<SwfLogStoreDto>();
					BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
					BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
					swfLogDtoList = (List<SwfLogDto>)blSwfLogFacade.findByConditions("registno='"+prpLpayBillDtoList.get(0).getRegistNo()+"' and systemflag='agri'");
					swfLogStoreDtoList = (List<SwfLogStoreDto>)blSwfLogStoreFacade.findByConditions("registno='"+prpLpayBillDtoList.get(0).getRegistNo()+"' and systemflag='agri'");
					if(swfLogDtoList!=null && swfLogDtoList.size()>0 || swfLogStoreDtoList!=null && swfLogStoreDtoList.size()>0){
						agriFlag = true;
					}
				}
				if(billNo!=null&&!"".equals(billNo)){
					conditions += " 1=1 and billNo='"+billNo+"'";
				}else{
					conditions += "1=1";
				}
				conditions += " and (nn.vflag not in ('0', '1', '3', '7', '9') or nn.vflag is null) ";
				//新农险及委托险种走另一套逻辑 add by wxy 2018-8-17 17:57:22
				if(agriFlag){
					pr = blPrpLclaimBillManagerFacade.findByConditonBillSumNew(conditions,editType,rowsPerPage,pageNo,wtFlag);
				}else{
					pr = blPrpLclaimBillManagerFacade.findByConditonBillSum(conditions,editType,rowsPerPage,pageNo);
				}
				prpLclaimBillManagerList = (ArrayList)pr.getResult();
				request.setAttribute("prpLclaimBillManagerList", prpLclaimBillManagerList);
				request.setAttribute("billNo", billNo);
				
				String payExtSql = " paymentNo = '"+billNo+"'  "	;
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
				String starDate = "";
				//取核赔通过时间，若多个案件，则取最大值
				if(prpLclaimBillManagerList!=null&&prpLclaimBillManagerList.size()>0){
					if(prpLclaimBillManagerList.size()==1){
						starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0)).getUnderWriteEndDate();
					}else{
						for(int i=1;i<prpLclaimBillManagerList.size();i++){
							
							int temp =DateCompute.compareDate(((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate(),((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i-1)).getUnderWriteEndDate());
							if(temp>=0){
								starDate=((PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i)).getUnderWriteEndDate();
							}
						}
					}
				}
				this.getCostTime(prpLpayExtDtoList, starDate);
			}
			ArrayList list = (ArrayList)pr.getResult();
			double sumTotalPaid = 0.00;
			DecimalFormat decimalFormat = new DecimalFormat("#0.00");
			String reQRegistNo = "";
			String reQClaimNo = "";
			String reQPolicyNo = "";
			String reQVflag = "";
			for(int i=0;i<list.size();i++){
				PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)list.get(i);
				sumTotalPaid += prpLclaimBillManagerDto.getPayAmount();
				reQRegistNo = prpLclaimBillManagerDto.getRegistNo();
				reQClaimNo = prpLclaimBillManagerDto.getClaimNo();
				reQPolicyNo = prpLclaimBillManagerDto.getPolicyNo();
				reQVflag = prpLclaimBillManagerDto.getVflag();
			}
			ArrayList selectList = new ArrayList();
			if(selectBillFlag==null||!"1".equals(selectBillFlag)){
				if(payKey!=null&&payKey.length>0){
					for(int j=0;j<payKey.length;j++){
						boolean isExists = false;
						for(int i=0;i<list.size();i++){
							PrpLclaimBillManagerDto prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)list.get(i);
							if(payKey[j].trim().equals(prpLclaimBillManagerDto.getPayName().trim()+"_"+prpLclaimBillManagerDto.getIdentifyNumber().trim())){
								prpLclaimBillManagerDto.setSelectFlag("1");
								isExists = true;
							}
						}
						if(!isExists){
							selectList.add(payKey[j]);
						}
					}
				}
			}
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
			request.setAttribute("type", type);
			request.setAttribute("editType", editType);
			request.setAttribute("nodeType", nodeType);
			request.setAttribute("back", back);
			request.setAttribute("sumTotalPaid", decimalFormat.format(sumTotalPaid));
			request.setAttribute("userCode", user.getUserCode());
			request.setAttribute("reQRegistNo", reQRegistNo);
			request.setAttribute("reQClaimNo", reQClaimNo);
			request.setAttribute("reQPolicyNo", reQPolicyNo);
			request.setAttribute("reQVflag", reQVflag);
			request.setAttribute("selectList", selectList);
			request.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
			request.setAttribute("prpLpayExtDtoList", prpLpayExtDtoList);
			request.setAttribute("isAccBack", isAccBack);
			request.setAttribute("noBillFlag", noBillFlag);
			if(!"1".equals(type)&&!"5".equals(type)){
				forword = "true";
			}
			if(selectBillFlag!=null&&"1".equals(selectBillFlag)){
				forword = "true";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forword = "error";
		}
		return mapping.findForward(forword);
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
}
