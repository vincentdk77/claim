package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.SpecialCaseViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ��������᰸ǰ��ѯ��������
 * <p>
 * Title: ��������᰸ǰ��ѯ������Ϣ
 * </p>
 * <p>
 * Description: ��������᰸ǰ��ѯ������Ϣϵͳ��������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILSpeicalCaseApplyBeforeEditGetFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        //ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
        String editType = httpServletRequest.getParameter("editType");
        String claimNo = httpServletRequest.getParameter("ClaimNo"); //������
        String riskCode = httpServletRequest.getParameter("riskCode"); //����
        String registNo = httpServletRequest.getParameter("keyIn");
        String forward = ""; //��ǰ
        try {
            //��δ����type�쳣����{}��������������쳣����{}
            //1.��������,�������룬���ڳ�ʼ������ʾ
            if (editType.equals("CANCEL")) { //����cancel��������
            	 //modify by lixiang start at 2006-09-14
				 //����������������ƣ�����һ����ҵ�յ�Ԥ��Ҳ��Ҫ���ģ����Խ��������ȥ���ˡ� 
			  
            	/*UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
				if(registDto.getPrpLRegistRPolicyDtoOfCompel() == null)
				{   String configCode = new UICodeAction().translateRiskCodetoConfigCode(riskCode);
				    if( "RISKCODE_DAZ".equals(configCode) == false )
				    {
				   	 throw new UserException(1,3,"0000","��ҵ���ղ��ɽ�������"); 
				    }
				   
				}*/
            	 //modify by lixiang end at 2006-09-14
                SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
                specialCaseViewHelper.buessinessNoDtoToView(httpServletRequest);
            }
            //��ѯ�᰸��Ϣ,�������룬���ڳ�ʼ������ʾ
            if (editType.equals("EDIT") || editType.equals("SHOW")) {
            }
           

            //ȡ��forward
            forward = "success";
            //modify by liuyanmei 20051209 start
            /* if (editType.equals("ApplySchedule")) { 
                SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
                specialCaseViewHelper.buessinessNoDtoToView(httpServletRequest);
                forward="ApplySchedule";
            }
            */
            if (editType.equals("ApplySchedule")) { 
                SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
                specialCaseViewHelper.ApplyScheduleDtoToViewDtoToView(httpServletRequest);
                forward="ApplySchedule";
            }
            //modify by liuyanmei 20051209  end 
            
            saveToken(httpServletRequest);
        } catch (UserException usee) {
            usee.printStackTrace();
            //������Ϣ����
            //������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError(
                    "title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            //������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError(
                    "title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";

        } finally {

        }

        return actionMapping.findForward(forward);
    }
}
