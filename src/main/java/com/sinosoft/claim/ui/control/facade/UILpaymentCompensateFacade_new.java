package com.sinosoft.claim.ui.control.facade;

import java.sql.ResultSet;
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
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class UILpaymentCompensateFacade_new extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forword = "true";
		String conditions = "";
		String editType = request.getParameter("editType");
		String[] compensate = request.getParameterValues("compensateNo");
		String[] registNo = request.getParameterValues("registNoPay");
		String[] isCheckeds = request.getParameterValues("isChecked");
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
		DBManager dbManager = new DBManager();
		ResultSet rs = null;
		try {
			String compensateList = "";
			String registList = "";
			if("ADD".equals(editType)){
				if(compensate!=null && compensate.length>0){
					for(int i=0;i<isCheckeds.length;i++){
						if("1".equals(isCheckeds[i])){
							if(!"".equals(compensateList)){
								compensateList += ",'"+compensate[i]+"'";
							}else{
								compensateList += "'"+compensate[i]+"'";
							}
							
							if(!"".equals(registList)){
								registList += ",'"+registNo[i]+"'";
							}else{
								registList += "'"+registNo[i]+"'";
							}
						}
						
					}
						
					
				}
				
				String queryCon = " select mm.registno,mm.claimno,mm.policyno, " +
				" (select am.identifynumber from prpcinsured am where am.policyno = mm.policyno and am.insuredflag='1') as identifynumber, " +
				"  mm.insuredname, " +
				" te.compensateno, " +
				" te.sumthispaid, " +
				" te.sumthispaid - Decode((Select Sum(Payamount) " +
				"        From Prplpay Ay " +
				"       Where Ay.Compensateno = Te.Compensateno " +
				"         And Ay.Registno = Mm.Registno " +
				"         And Ay.Paymenttype = 'P60'), Null, 0, '', 0, (Select Sum(Payamount) " +
				"        From Prplpay Ay " +
				"       Where Ay.Compensateno = Te.Compensateno " +
				"         And Ay.Registno = Mm.Registno " +
				"         And Ay.Paymenttype = 'P60')) as havpad,te.underwriteenddate " +
				" from prplclaim mm, prplcompensate te " +
				" where mm.claimno = te.claimno and te.sumthispaid>0" +
				" and mm.registno in ("+registList+") " +
				" and te.compensateno in ("+compensateList+")";
				
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				rs = dbManager.executeQuery(queryCon);
				PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
				String reQRegistNo = "";
				String reQClaimNo = "";
				String reQPolicyNo = "";
				while(rs.next()){
					prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
					//prpLclaimBillManagerDto.setSerialNo(Integer.parseInt(dbManager.getString(rs,1)));
					prpLclaimBillManagerDto.setRegistNo(dbManager.getString(rs,1));
					prpLclaimBillManagerDto.setClaimNo(dbManager.getString(rs,2));
					prpLclaimBillManagerDto.setPolicyNo(dbManager.getString(rs,3));
					prpLclaimBillManagerDto.setIdentifyNumber(dbManager.getString(rs,4));
					prpLclaimBillManagerDto.setPayName(dbManager.getString(rs,5));
					prpLclaimBillManagerDto.setCompensateNo(dbManager.getString(rs,6));
					prpLclaimBillManagerDto.setSumPaid(dbManager.getDouble(rs,7));
					prpLclaimBillManagerDto.setHavPaid(dbManager.getDouble(rs,8));
					prpLclaimBillManagerDto.setUnderWriteEndDate(dbManager.getString(rs,9));
					
					prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
				}
				if(null!=prpLclaimBillManagerList && prpLclaimBillManagerList.size()>0){
					PrpLclaimBillManagerDto iPrpLclaimBillManagerDto = (PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(0);
					reQRegistNo = iPrpLclaimBillManagerDto.getRegistNo();
					reQClaimNo = iPrpLclaimBillManagerDto.getClaimNo();
					reQPolicyNo = iPrpLclaimBillManagerDto.getPolicyNo();
				}
				request.setAttribute("reQRegistNo", reQRegistNo);
				request.setAttribute("reQClaimNo", reQClaimNo);
				request.setAttribute("reQPolicyNo", reQPolicyNo);
				/*request.setAttribute("pageConditions", conditions);
				pr = blPrpLclaimBillManagerFacade.findByConditonSum(conditions,editType,back,rowsPerPage,pageNo);
				prpLclaimBillManagerList = (ArrayList)pr.getResult();*/
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
			}else if("EDIT".equals(editType)){}else{}
			
			// 搜索条件
			request.setAttribute("type", type);
			request.setAttribute("editType", editType);
			request.setAttribute("nodeType", nodeType);
			request.setAttribute("back", back);
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
		}finally{
		    if(rs!=null){
		      rs.close();//结果集关闭
		    }
			dbManager.close();//增加数据库连接关闭按钮
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
