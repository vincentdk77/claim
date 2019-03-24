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
 * 分发HTTP GET 车险理赔结案前查询保单请求
 * <p>
 * Title: 车险理赔结案前查询保单信息
 * </p>
 * <p>
 * Description: 车险理赔结案前查询保单信息系统样本程序
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

        //业务类型：ADD-新增 EDIT-修改 SHOW-显示
        String editType = httpServletRequest.getParameter("editType");
        String claimNo = httpServletRequest.getParameter("ClaimNo"); //立案号
        String riskCode = httpServletRequest.getParameter("riskCode"); //险种
        String registNo = httpServletRequest.getParameter("keyIn");
        String forward = ""; //向前
        try {
            //尚未加入type异常处理{}、其它必须参数异常处理{}
            //1.特殊申请,整理输入，用于初始界面显示
            if (editType.equals("CANCEL")) { //借用cancel的申请了
            	 //modify by lixiang start at 2006-09-14
				 //由于增加了这个控制，所以一般商业险的预赔也是要做的，所以将这个控制去掉了。 
			  
            	/*UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
				if(registDto.getPrpLRegistRPolicyDtoOfCompel() == null)
				{   String configCode = new UICodeAction().translateRiskCodetoConfigCode(riskCode);
				    if( "RISKCODE_DAZ".equals(configCode) == false )
				    {
				   	 throw new UserException(1,3,"0000","商业保险不可进行申请"); 
				    }
				   
				}*/
            	 //modify by lixiang end at 2006-09-14
                SpecialCaseViewHelper specialCaseViewHelper = new SpecialCaseViewHelper();
                specialCaseViewHelper.buessinessNoDtoToView(httpServletRequest);
            }
            //查询结案信息,整理输入，用于初始界面显示
            if (editType.equals("EDIT") || editType.equals("SHOW")) {
            }
           

            //取得forward
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
            //错误信息处理
            //错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError(
                    "title.endcaseBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            //错误信息处理
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
