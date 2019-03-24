package com.sinosoft.claim.ui.control.facade;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 报案查询
 * <p>Title: 车险理赔报案查询信息</p>
 * <p>Description: 车险理赔报案报案查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIRegistQueryFacade extends Action {
//	private static Log log = LogFactory.getLog(UIRegistQueryFacade.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		String editType = httpServletRequest.getParameter("editType");
		String pageFlag = httpServletRequest.getParameter("pageFlag");
		String policyNo = httpServletRequest.getParameter("PolicyNo"); //保单号
		String registNo = httpServletRequest.getParameter("RegistNo"); //报案号
		//Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
		String licenseNo = httpServletRequest.getParameter("LicenseNo"); //车牌号
		String status = httpServletRequest.getParameter("caseFlag"); //案件状态
		String operateDate = httpServletRequest.getParameter("OperateDate");//操作时间
		String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//操作时间截止
		//	Modify By dongchengliang 2005-05-28 Reason:增加险种查询条件
		String riskCode = httpServletRequest.getParameter("RiskCode");//险种
		String insuredName = httpServletRequest.getParameter("InsuredName");  //被保险人
		String cancelFlag = httpServletRequest.getParameter("cancelFlag");    //是否注销
		//modify by wangwei delete start 2005-06-04
		//原因：对意险在报案时增加身份证号查询条件
		//String IDCard = httpServletRequest.getParameter("IdentifyNumber");
		//modify by wangwei add end 2005-06-04
		
		//去掉status中最后一个逗号
	    if(status!=null&&status.trim().length()>0){
	      status=status.substring(0,status.length()-1);
	    }
		
	    //add by miaowenjun 20060413
	    String registStartCancelDate = httpServletRequest.getParameter("registStartCancelDate");
	    String registEndCancelDate = httpServletRequest.getParameter("registEndCancelDate");
	    //add end by miaowenjun 20060413
	    
		//add by miaowenjun 20060411
		String registNoSign = httpServletRequest.getParameter("RegistNoSign");
		String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
		String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");
		String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
		String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
		String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
		String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
		WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
		workFlowQueryDto.setRegistStartCancelDate(registStartCancelDate);
		workFlowQueryDto.setRegistEndCancelDate(registEndCancelDate);
		workFlowQueryDto.setPolicyNo(policyNo);
		workFlowQueryDto.setRegistNo(registNo);
		workFlowQueryDto.setLicenseNo(licenseNo);
		workFlowQueryDto.setStatus(status);
		workFlowQueryDto.setOperateDate(operateDate);
		workFlowQueryDto.setOperateDateEnd(operateDateEnd);
		workFlowQueryDto.setRiskCode(riskCode);
		workFlowQueryDto.setInsuredName(insuredName);
		workFlowQueryDto.setCancelFlag(cancelFlag);
		workFlowQueryDto.setRegistNoSign(registNoSign);
		workFlowQueryDto.setPolicyNoSign(policyNoSign);
		workFlowQueryDto.setRiskCodeSign(riskCodeSign);
		workFlowQueryDto.setLicenseNoSign(licenseNoSign);
		workFlowQueryDto.setOperateDateSign(operateDateSign);
		workFlowQueryDto.setOperateDateSignEnd(operateDateSignEnd);
		workFlowQueryDto.setInsuredNameSign(insuredNameSign);
		//add end by miaowenjun 20060411

		String forward = ""; //向前

		try {
			//整理查询条件中的状态去掉status中最后一个逗号
			if (status != null && status.trim().length() > 0) {
				//status = status.substring(0, status.length() - 1);
			}
			HttpSession session = httpServletRequest.getSession();
			//尚未加入type异常处理{}、其它必须参数异常处理{}
			//1。报案一般的查询，查询理赔节点状态信息,整理输入，用于初始界面显示
			if (editType.equals("ADD") || editType.equals("EDIT")) {
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,
						workFlowQueryDto);
				forward = "success";
			}
			
			//add by zhaolu 20060801 start 
			//报案查询分页
			if(editType.equals("SHOW"))
			{
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		        String pageNo     = httpServletRequest.getParameter("pageNo");
		        if(pageNo==null||pageNo.trim().equals("")) 
		        	pageNo = "1";
                int intRecordPerPage=Integer.parseInt(recordPerPage) ;
		        int intPageNo=Integer.parseInt(pageNo) ;
		        //System.out.println("报案查询的状态位:::"+status);
		        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,
						registNo,policyNo,licenseNo,status,operateDate,riskCode,insuredName,pageNo,recordPerPage);
				forward = "success";
			}
			//add by zhaolu 20060801 end
			
			//2。报案撤消的查询
			if (editType.equals("DELETE")) {
			         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
			         //dAARegistViewHelper.registDtoListToView(httpServletRequest,registNo,policyNo);
			         dAARegistViewHelper.registCancelDtoToView(httpServletRequest,registNo);
			         //forward = "deleteSuccess";
			         forward = "registCancel";
			} //3。录入报案前查询保单
			
				
			if (editType.equals("RegistBeforeQuery")) {
				//需要进行翻页处理
				//每页显示的行数
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo = httpServletRequest.getParameter("pageNo");
				
				if (pageNo == null || pageNo.trim().equals(""))
					pageNo = "1";

				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.policyListToView(httpServletRequest,
						pageNo, recordPerPage);
				if("2601".equals(riskCode)){
					forward = "target0807";
				}
				else{
				    forward = "target1";
				}
			}
			
			if (editType.equals("PRINT")) {
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.setPrpLregistDtoToPrint(httpServletRequest,
						registNo, policyNo, insuredName, licenseNo);
				forward = "PRINT";
			}

		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.queryRegistList");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.queryRegistList");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} finally {

		}
		System.out.println("finishQueryEdit forward=" + forward);

		return actionMapping.findForward(forward);
	}

}
