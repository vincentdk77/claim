package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP Post �⽡�ղ������������ļ�
 * <p>Title: �⽡�ղ����������������Ϣ</p>
 * <p>Description: �⽡�ղ����������������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author ������Ŀ�� 
 * @version 1.0
 */
public class UINotGrandClaimFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //��ǰ��ת
     /*
     * ����˼·��
     *========================================================
     *[1]���ݱ�����registnoȡ�ñ�����Ϣ
     *[2]��д������Ϣ
     *[3]���汨������Ϣ
     *[4]�����ύ��ִ��Complate����,���ҹرչ�����endflag=1��
     *========================================================
    */
    try {
      UICodeAction uiCodeAction = new UICodeAction();
      String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
      //ȡ������
      String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
      String riskCode = httpServletRequest.getParameter("riskCode");
      String policyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
      String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID");
      String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo");
      
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String comCode   = user.getComCode() ;
      
         //��viewHelper�����������
         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
         RegistDto registDto = dAARegistViewHelper.getNotGrandClaim(httpServletRequest);
         
         //��������viewHelper�����������
         WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
         SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        
         //���ñ������빤�����ĸ���״̬
         swfLogDtoDealNode.setFlowID(swfLogFlowID);
         swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
         swfLogDtoDealNode.setNodeType("regis");
         swfLogDtoDealNode.setNodeStatus("1");
         swfLogDtoDealNode.setBusinessNo(registNo);
         swfLogDtoDealNode.setNextBusinessNo(registNo);
         swfLogDtoDealNode.setKeyIn(registNo);
         swfLogDtoDealNode.setKeyOut(registNo);
         swfLogDtoDealNode.setRiskCode(riskCode);
         swfLogDtoDealNode.setComCode(comCode);
         swfLogDtoDealNode.setPolicyNo(policyNo);
         swfLogDtoDealNode.setEndFlag("1");  //�رչ�����
         
         // modify by wangli add start 200504017
         //swfLogDtoDealNode.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_MINUTE));
         // modify by wangli add end 200504017
        
         //���������Ĵ���/�޸�/�ύ������
         WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        
         UIRegistAction uiRegistAction = new UIRegistAction();
        
         if (workFlowViewHelper.checkDealDto(workFlowDto)){
             uiRegistAction.save(registDto,workFlowDto);
             user.setUserMessage(registNo);
           }else{
             if (workFlowDto.getOperateResult()<0){
                 user.setUserMessage("ע��:��������������ʱ��δ�ҵ���ع�����ģ������ã�����ϵϵͳ����Ա������Ӧ���ã���");
             } 
             else
             {
                 uiRegistAction.save(registDto);
                 user.setUserMessage(registNo+";ע��:û�з����빤������������κ����ݣ���");
             }
         }
      /**add by qinyongli 2005-09-09 start 
      [reason:Ŀǰ���������İ������Ѵ������������п����ҵ�,���պ����ܹ�ͨ�Ľ�����������Ժ�������ڣ�û�д�����ϵĹ������ڵ�ȫ��ɾ��]
      [********************************************************************************************************]
      [********************************�Թ������ڵ����ɾ������,�������޸�*******************************************]
      [********************************************************************************************************]
      [*ִ��ɾ���������������������ų����ж�,����������ش����ڵ�״̬�ϸ�����;*/
         //�Թ������Ž�������
         String conditions = "";
         if(swfLogFlowID.length()==21){
        	  conditions = conditions +" nodestatus <> '4' and flowid ='"+swfLogFlowID+"'  ";
        	  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	  uiWorkFlowAction.deletWorkFlowForNotGrand(conditions);
         }                
      //************************�Թ������ڵ����ɾ������,�������޸ģ���������������������������������������������������������������
      //add by qinyongli 2005-09-09 end 
      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.regist.notGrandClaim"));
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
      saveMessages( httpServletRequest, messages );

      //Ĭ�ϲ���Ҫ�Զ���ת
      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
   }

    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally {
    }
    return actionMapping.findForward(forward);
  }
}
