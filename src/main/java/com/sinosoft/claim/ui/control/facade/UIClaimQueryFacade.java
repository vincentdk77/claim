package com.sinosoft.claim.ui.control.facade;

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
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ������ѯ
 * <p>Title: ��������������ѯ��Ϣ</p>
 * <p>Description: ������������������ѯ��Ϣϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIClaimQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ

    String editType   = httpServletRequest.getParameter("editType");
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //������
    String claimNo   = httpServletRequest.getParameter("ClaimNo") ; //�ⰸ��
    //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//���ƺ�
    String status     = httpServletRequest.getParameter("caseFlag");//����״̬
    String operateDate  = httpServletRequest.getParameter("OperateDate");//����ʱ��
    String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//����ʱ���ֹ

    //ȥ��status�����һ������
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    
    //add by miaowenjun 20060412
    String insuredName = httpServletRequest.getParameter("InsuredName");
    String registNo = httpServletRequest.getParameter("RegistNo");
    String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setOperateDateEnd(operateDateEnd);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setOperateDateSignEnd(operateDateSignEnd);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
	//add by lixiang start at 20060830
	//reason:������ѯ����ʧ�����������Ҫ�����ݵĲ�ѯ
    //add by lixiang end at 20060830
	workFlowQueryDto.setClaimNo( httpServletRequest.getParameter("ClaimNo"));
	workFlowQueryDto.setClaimNoSign(httpServletRequest.getParameter("ClaimNoSign"));
	
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
    //add by miaowenjun 20060412
    
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����
 
    String forward  = "";                                          //��ǰ
    try
    {
		String isFirst		= httpServletRequest.getParameter("isFirst"); //�Ƿ��һ�ν�������һ�ν�������ѯ���
		
		//��һ�ν�������־Ϊ�յģ����Զ�����г�ʼ�����ڶ��ν�����ȡ����ҳ���ֵ�����Բ�Ϊ�գ����ô���
		if(isFirst == null || "".equals(isFirst)){
			isFirst = "Y";
		}
		httpServletRequest.setAttribute("isFirst", isFirst);
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW"))
      {
        //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
        //add by zhaolu 20060802 start
    	//reason:��ҳ����
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
          if(pageNo==null||pageNo.trim().equals(""))
        	  pageNo = "1"; 
    	//add by zhaolu 20060802 end
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.setPrpLclaimDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //dAAClaimViewHelper.setPrpLclaimDtoToView(httpServletRequest,workFlowQueryDto);
		//add by zhouliu start at 2006-6-9
        if (editType.equals("SHOW"))
        {
        	httpServletRequest.setAttribute("type","SHOW");
        }
        forward = "success";
		//add by zhouliu end at 2006-6-9
      }
      //�ѳ�ʱ�ı���
      if (editType.equals("TimeOut"))
      {
        //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.registTimeOut(httpServletRequest);
        forward = "timeOut";
      }      
      if (editType.equals("claimTimeOut"))
      {
        //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.claimTimeOut(httpServletRequest);
        forward = "claimTimeOut";
      }            
      //�����ⰸ
      if (editType.equals("SpecialCase"))
      {
        //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper(); 
        dAAClaimViewHelper.getSpecialList(httpServletRequest,claimNo,policyNo);
        forward = "SpecialCase"; 
 
      } 
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
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
