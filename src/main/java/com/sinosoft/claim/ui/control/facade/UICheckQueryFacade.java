package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET �鿱��ѯ
 * <p>Title: ��������鿱��ѯ��Ϣ</p>
 * <p>Description: ��������鿱�鿱��ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICheckQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
	String policyNo = httpServletRequest.getParameter("PolicyNo"); //������
    String editType   = httpServletRequest.getParameter("editType");//����
    String claimNo   = httpServletRequest.getParameter("ClaimNo");    //�ⰸ��
    String registNo   = httpServletRequest.getParameter("RegistNo");//������
    //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//���ƺ�
    String status     = httpServletRequest.getParameter("caseFlag");//����״̬
    String operateDate  = httpServletRequest.getParameter("OperateDate");//����ʱ��
    String insuredName = httpServletRequest.getParameter("InsuredName");  //��������
    String strDeleteFlag = httpServletRequest.getParameter("deleteFlag");//ɾ���������־
    String arrCheckFlag[]  = httpServletRequest.getParameterValues("CheckFlag");//ѡ�е�Ҫɾ��������������к�
    String arrCompensateNo[] = httpServletRequest.getParameterValues("RegistNo");//��Ҫɾ�����������
    //ȥ��status�����һ������
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����
    
    //add by miaowenjun 20060412
    String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String claimNoSign = httpServletRequest.getParameter("ClaimNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setClaimNo(claimNo);
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setClaimNoSign(claimNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
    //add end by miaowenjun 20060412

    String forward  = "";                                          //��ǰ
    try 
    {
    	DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
      
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //��ѯ�鿱��Ϣ,�������룬���ڳ�ʼ������ʾ
        //add by zhaolu 20060802 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo = httpServletRequest.getParameter("pageNo");
          if(pageNo == null || pageNo.trim().equals(""))
       	   pageNo = "1";
       //add by zhaolu 20060802 end
        //modify by zhaolu 20060802 start
          dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //modify by zhaolu 20060802 end
       //dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);
       forward = "success";

    }
    
    
     if (editType.equals("DELETE"))
     {
     	
      dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);
      forward = "deleteSuccess";
  	
    }
      if (editType.equals("Certify")) {
        //��ѯ�鿱��Ϣ,�������룬���ڳ�ʼ������ʾ

        dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);

        forward = "certifyUpload"; 

      }    
      
      //��ӡ���鱨��ǰ,�Ȳ�����еĵ����,��ʾ�ɵ����б�. 2005-08-16
      if (editType.equals("PRINT")) {
      	  String comditions = " registNo='" + registNo + "'"; 
      	  UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
      	  Collection prpLacciCheckDtoList = uiAcciCheckAction.findByConditionsAcciCheck(comditions);
      	  httpServletRequest.setAttribute("prpLacciCheckDtoList", prpLacciCheckDtoList); 
      	  forward = "acciCheckList";
      }
      
      //�鿱�˻�
      if ("1".equals(strDeleteFlag)) {
				int size = arrCheckFlag.length;
				BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
				for (int i = 0; i < size; i++) {
					// �ж�checkboxѡ�еı�����
					if ("Y".equals(arrCheckFlag[i])) {
						String conditions = "BusinessNo = '"+arrCompensateNo[i]+"' and NodeNo= 3";
						SwfLogDto swfLogDto = new SwfLogDto();
						Collection tion = facadeSwf.findByConditions(conditions);
					    for (Iterator ite = tion.iterator(); ite.hasNext();){
					    	swfLogDto = (SwfLogDto)ite.next();
					      }
					    facadeSwf.checkFlowID(swfLogDto.getFlowID());
						swfLogDto=facadeSwf.findByPrimaryKey(swfLogDto.getFlowID(), swfLogDto.getLogNo());
						swfLogDto.setNodeStatus("2");
						swfLogDto.setFlowStatus("2");
						swfLogDto.setSubmitTime("");
						facadeSwf.updateStatusReurun(swfLogDto);
					}
				}
				httpServletRequest.setAttribute("content", "�鿱�˻سɹ�");
				forward = "delete";
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
    return actionMapping.findForward(forward);
  }

}
