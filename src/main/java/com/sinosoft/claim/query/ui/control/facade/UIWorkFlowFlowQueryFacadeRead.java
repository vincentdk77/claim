package com.sinosoft.claim.query.ui.control.facade;

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
import com.sinosoft.claim.query.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ������������ѯ
 * <p>Title: �������ⱨ����ѯ��Ϣ</p>
 * <p>Description: �������ⱨ��������ѯ��Ϣ���ڹ�����������ʾ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 

public class UIWorkFlowFlowQueryFacadeRead  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType   = httpServletRequest.getParameter("editType");
    String caseType   = httpServletRequest.getParameter("caseType");
    String pageFlag   = httpServletRequest.getParameter("pageFlag");
    String policyNo   = httpServletRequest.getParameter("prpLregistPolicyNo");    //������
    String registNo   = httpServletRequest.getParameter("prpLregistRegistNo") ; //������
    //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
    String licenseNo  = httpServletRequest.getParameter("prpLregistLicenseNo");//���ƺ�
    String status     = httpServletRequest.getParameter("caseFlag");//����״̬
    String operateDate  = httpServletRequest.getParameter("operateDate");//����ʱ��
    String riskCode     = httpServletRequest.getParameter("prpLregistRiskCode") ;  //���ִ���
    String insuredName  = httpServletRequest.getParameter("prpLregistInsuredName");//������������
    String riskCodeName = httpServletRequest.getParameter("prpLregistRiskCodeName");
    String riskCodeNameSign = httpServletRequest.getParameter("RiskCodeNameSign");
    String registFlowinTime = httpServletRequest.getParameter("prpLregistFlowinTime");
    String riskCategory = httpServletRequest.getParameter("riskCategory");
    WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
    workFlowQueryDto.setCaseType(caseType);
    workFlowQueryDto.setInsuredName(insuredName);
   	workFlowQueryDto.setLicenseNo(licenseNo);
   	workFlowQueryDto.setPolicyNo(policyNo);
   	workFlowQueryDto.setRegistNo(registNo);
   	workFlowQueryDto.setRiskCode(riskCode);
   	workFlowQueryDto.setRiskCodeName(riskCodeName );
   	workFlowQueryDto.setRiskCodeNameSign(riskCodeNameSign );
   	workFlowQueryDto.setRegistFlowinTime(registFlowinTime);
   	workFlowQueryDto.setRiskCategory(riskCategory);
    //add end by miaowenjun 20060411  
    
    //ȥ��status�����һ������
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    
    //added by zhangli 20070424    
    session.setAttribute("compensatePolicyNo", policyNo);
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����
    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
    	 if (editType.equals("ADD") || editType.equals("SHOW")) {
            //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ

            //ÿҳ��ʾ������
            String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
            String pageNo     = httpServletRequest.getParameter("pageNo");    
            if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
            DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
            dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,registNo,policyNo,licenseNo,status,operateDate,riskCode,insuredName,pageNo,recordPerPage);
            forward = "success";

         }
    	 
    	 if (editType.equals("RegistBeforeQuery")) {
    	 	editType = "WorkFlow";
    	 }
    	 
          if (editType.equals("WorkFlow")||editType.equals("EDIT")) { 
            //ÿҳ��ʾ������
            String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
            String pageNo     = httpServletRequest.getParameter("pageNo");
            //
            int intPageNo=0;
            int intrecord =Integer.parseInt(recordPerPage);
            if(pageNo==null||pageNo.trim().equals("")) {
            	intPageNo = 1;
            }else{
            	intPageNo=Integer.parseInt(pageNo);
            }
            //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ 
            WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();            
            workFlowViewHelper.getWorkFlowList(httpServletRequest,registNo,policyNo,licenseNo,riskCode,insuredName,intPageNo,intrecord);
            httpServletRequest.setAttribute("workFlowQueryDto",workFlowQueryDto);
            forward = "success"; 
          }    
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
