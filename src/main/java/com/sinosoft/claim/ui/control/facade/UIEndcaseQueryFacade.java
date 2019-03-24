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
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET �᰸��ѯ
 * <p>Title: ��������᰸��ѯ��Ϣ</p>
 * <p>Description: ��������᰸�᰸��ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIEndcaseQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    String claimNo      = httpServletRequest.getParameter("ClaimNo");    //�ⰸ��
    String policyNo     = httpServletRequest.getParameter("PolicyNo");   //������
    String caseNo       = httpServletRequest.getParameter("CaseNo");     //�㰸��
    //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
    String licenseNo    = httpServletRequest.getParameter("LicenseNo");//���ƺ�
    String status       = httpServletRequest.getParameter("caseFlag");//����״̬
    String operateDate  = httpServletRequest.getParameter("OperateDate");//����ʱ��
    String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//����ʱ���ֹ
    String comCode       = httpServletRequest.getParameter("comCode");//����״̬
    String claimDate  = httpServletRequest.getParameter("claimDate");//����ʱ��

    //ȥ��status�����һ������
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    
    //add by miaowenjun 20060412
    String insuredName = httpServletRequest.getParameter("InsuredName");
    String claimDateSign = httpServletRequest.getParameter("claimDateSign");
    String comCodeSign = httpServletRequest.getParameter("comCodeSign");
    String caseNoSign = httpServletRequest.getParameter("CaseNoSign");
    String claimNoSign = httpServletRequest.getParameter("ClaimNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setClaimNoSign(claimNoSign);
	workFlowQueryDto.setComCodeSign(comCodeSign);
	workFlowQueryDto.setClaimDateSign(claimDateSign);
	workFlowQueryDto.setClaimDate(claimDate);
	workFlowQueryDto.setComCode(comCode);
	workFlowQueryDto.setClaimNo(claimNo);
	workFlowQueryDto.setCaseNo(caseNo);
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setOperateDateEnd(operateDateEnd);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setOperateDateSignEnd(operateDateSignEnd);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
	//add end by miaowenjun 20060412
    
    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        
        //��ѯ�᰸��Ϣ,�������룬���ڳ�ʼ������ʾ
    	//add by zhaolu 20060803 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
         if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
         int intRecordPerPage=Integer.parseInt(recordPerPage) ;
         int intPageNo=Integer.parseInt(pageNo) ;
    	//add by zhaolu 20060803 end
        DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
        //modify by zhaolu 20060803 start
        //dAAEndcaseViewHelper.setPrpLendcaseDtoToView(httpServletRequest,workFlowQueryDto);
        dAAEndcaseViewHelper.setPrpLendcaseDtoToView(httpServletRequest,workFlowQueryDto,intPageNo,intRecordPerPage);
        //modify by zhaolu 20060803 end
        forward = "success";
      }
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcaseList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.endcaseBeforeEdit.queryEndcaseList");
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
