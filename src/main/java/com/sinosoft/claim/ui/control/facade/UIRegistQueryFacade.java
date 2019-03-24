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
 * �ַ�HTTP GET ������ѯ
 * <p>Title: �������ⱨ����ѯ��Ϣ</p>
 * <p>Description: �������ⱨ��������ѯ��Ϣϵͳ��������</p>
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

		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String editType = httpServletRequest.getParameter("editType");
		String pageFlag = httpServletRequest.getParameter("pageFlag");
		String policyNo = httpServletRequest.getParameter("PolicyNo"); //������
		String registNo = httpServletRequest.getParameter("RegistNo"); //������
		//Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
		String licenseNo = httpServletRequest.getParameter("LicenseNo"); //���ƺ�
		String status = httpServletRequest.getParameter("caseFlag"); //����״̬
		String operateDate = httpServletRequest.getParameter("OperateDate");//����ʱ��
		String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//����ʱ���ֹ
		//	Modify By dongchengliang 2005-05-28 Reason:�������ֲ�ѯ����
		String riskCode = httpServletRequest.getParameter("RiskCode");//����
		String insuredName = httpServletRequest.getParameter("InsuredName");  //��������
		String cancelFlag = httpServletRequest.getParameter("cancelFlag");    //�Ƿ�ע��
		//modify by wangwei delete start 2005-06-04
		//ԭ�򣺶������ڱ���ʱ�������֤�Ų�ѯ����
		//String IDCard = httpServletRequest.getParameter("IdentifyNumber");
		//modify by wangwei add end 2005-06-04
		
		//ȥ��status�����һ������
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

		String forward = ""; //��ǰ

		try {
			//�����ѯ�����е�״̬ȥ��status�����һ������
			if (status != null && status.trim().length() > 0) {
				//status = status.substring(0, status.length() - 1);
			}
			HttpSession session = httpServletRequest.getSession();
			//��δ����type�쳣����{}��������������쳣����{}
			//1������һ��Ĳ�ѯ����ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
			if (editType.equals("ADD") || editType.equals("EDIT")) {
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,
						workFlowQueryDto);
				forward = "success";
			}
			
			//add by zhaolu 20060801 start 
			//������ѯ��ҳ
			if(editType.equals("SHOW"))
			{
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		        String pageNo     = httpServletRequest.getParameter("pageNo");
		        if(pageNo==null||pageNo.trim().equals("")) 
		        	pageNo = "1";
                int intRecordPerPage=Integer.parseInt(recordPerPage) ;
		        int intPageNo=Integer.parseInt(pageNo) ;
		        //System.out.println("������ѯ��״̬λ:::"+status);
		        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,
						registNo,policyNo,licenseNo,status,operateDate,riskCode,insuredName,pageNo,recordPerPage);
				forward = "success";
			}
			//add by zhaolu 20060801 end
			
			//2�����������Ĳ�ѯ
			if (editType.equals("DELETE")) {
			         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
			         //dAARegistViewHelper.registDtoListToView(httpServletRequest,registNo,policyNo);
			         dAARegistViewHelper.registCancelDtoToView(httpServletRequest,registNo);
			         //forward = "deleteSuccess";
			         forward = "registCancel";
			} //3��¼�뱨��ǰ��ѯ����
			
				
			if (editType.equals("RegistBeforeQuery")) {
				//��Ҫ���з�ҳ����
				//ÿҳ��ʾ������
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
			//������Ϣ����
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
