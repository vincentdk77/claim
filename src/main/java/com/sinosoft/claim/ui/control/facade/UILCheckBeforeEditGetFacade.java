package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.sinosoft.claim.bl.action.domain.BLPrpCmainAction;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriCheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;
/**
 * �ַ�HTTP GET ��������鿱ǰ��ѯ��������
 * <p>Title: ��������鿱ǰ��ѯ������Ϣ</p>
 * <p>Description: ��������鿱ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCheckBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  { 
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    String editForward  = editType;                 //�������ת�ı�־
    String claimNo      = "" ;
    String registNo     = "" ;
    String checkNo      = "" ;
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");
    String riskCode = httpServletRequest.getParameter("riskCode");                 //����
    String forward  = "";   //��ǰ
    String tempStatus = "";
    
    try
    {
      UICodeAction uiCodeAction = new UICodeAction();
      //add by miaowenjun 20060922 start ��ȡ�������
      String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
      //add by miaowenjun 20060922 end ��ȡ�������
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD")) {
        //��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
        registNo = httpServletRequest.getParameter("RegistNo"); //������
        if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
      {
        riskCode=BusinessRuleUtil.getRiskCode(registNo,"RegistNo"); 
      }

    //==================================================
        //����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
        //���û��flowID��logno�򲻽����жϡ�
        String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        if (flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
        	 if (swfLogDto.getHoldNode()==false)
                   {
                     String msg="����'"+registNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,��ѡ�������������д���!";
                     throw new UserException(1,3,"������",msg);
                   }
       }
    //================================================== 
       // DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
       // dAACertainLossViewHelper.registDtoToView(httpServletRequest,registNo,editType);
          
       //modify by miaowenjun 20060922 ũ�����Լ���viewhelper
        //add by xiatian �޸��⽡����
        if("I".equals(riskType)||"Q".equals(riskType)||"H".equals(riskType)||"E".equals(riskType)){
        	AgriCheckViewHelper agriCheckViewHelper = new AgriCheckViewHelper();
        	agriCheckViewHelper.registDtoToView(httpServletRequest,registNo,editType);
        }else{
        	DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
            dAACheckViewHelper.registDtoToView(httpServletRequest,registNo,editType);
        }
       }

      if(editType.equals("EDIT")||editType.equals("SHOW")||editType.equals("DELETE"))
      {
        //��ѯ�鿱��Ϣ,�������룬���ڳ�ʼ������ʾ
        checkNo = httpServletRequest.getParameter("prpLcheckCheckNo"); //�鿱��
        
        if (checkNo.length() > 21) {
			registNo = checkNo.substring(0, 21);
		}else{
			registNo = checkNo;
		}
        //modify by miaowenjun 20060922 ũ�����Լ���viewhelper
        if("I".equals(riskType)||"H".equals(riskType)){
        	AgriCheckViewHelper agriCheckViewHelper = new AgriCheckViewHelper();
        	agriCheckViewHelper.checkDtoView(httpServletRequest,checkNo);
        	agriCheckViewHelper.PrpLverifyLossDtoToView(httpServletRequest,checkNo);
        	agriCheckViewHelper.verifyLossDtoToView(httpServletRequest,checkNo);
        }
        else{
	        DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
	        dAACheckViewHelper.checkDtoView(httpServletRequest,checkNo);
        }
      }
      /**�󻧵�ͼ��Ϣ��ʾ����*/
      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
      			/*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
				|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
				|| "3139,3141".indexOf(riskCode)>-1*/){
    	  /**��ô���Ϣ*/
    	  PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
    	  prpLcheckDto = (PrpLcheckDto)httpServletRequest.getAttribute("prpLcheckDto");
    	  String gisPolicyNo = prpLcheckDto.getPolicyNo();
    	  UIRegistAction uiRegistAction = new UIRegistAction();
          RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
    	  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		  PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					gisPolicyNo, registDto.getPrpLregistDto()
							.getDamageStartDate().toString(), registDto
							.getPrpLregistDto().getDamageStartHour());
    	  String strRichFlyCode = policyDto.getPrpCmainDto().getRichFlyCode();
    	  /**��*/
    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
    	  /**������*/
    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
    	  /**�Ƿ���ʾ��ͼ��Ϣ��ť*/
    	  if(!"".equals(strRichFlyCode))
    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "1");
      }
       
//    δ����鿱����ķ�������
      if (editType.equals("GIVUP")) {
          //add by huangyunzhong 20051226 ����δ�ݴ���ύ�Ĳ鿱����ɾȥ�������ˣ�ʹ�����˿ɼ��ɴ���
          String FlowID = httpServletRequest.getParameter("swfLogFlowID");
          int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
          UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
          SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
          if(swfLogDto.getNodeType().equals("check")){
          swfLogDto.setHandlerCode("");
          swfLogDto.setHandlerName("");
          swfLogDto.setFlowStatus("1");
             }
          uiworkflowaction.updateFlow(swfLogDto);
          ActionMessages messages = new ActionMessages();
          messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
          "prompt.compensate.giveup"));
          saveMessages(httpServletRequest, messages);
          forward = "success";
          return actionMapping.findForward(forward);
      }
      
//   ���ݴ�鿱����ķ�������
      if (editType.equals("giveupTemporarySave")) {
          String FlowID = httpServletRequest.getParameter("swfLogFlowID");
          int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
          UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
          SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
          if(swfLogDto.getNodeType().equals("check")){
          swfLogDto.setHandlerCode("");
          swfLogDto.setHandlerName("");
          swfLogDto.setNodeStatus("0");
          swfLogDto.setFlowStatus("1");
             }
          uiworkflowaction.updateFlow(swfLogDto);
          ActionMessages messages = new ActionMessages();
          messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
          "prompt.compensate.giveup"));
          saveMessages(httpServletRequest, messages);
          forward = "success";
          return actionMapping.findForward(forward);
      }
      
      //reason���������⸶������Ӧ�ĵ�λ��Ϣ
      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
      Collection collection = uiCodeAction.findByConditions(conditions);
      httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
      //ȡ��forward
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"check",editType,1);
      //add by xiatian �޸��⽡�ղ鿱��ʾҳ��·��
      if("E".equals(riskType) && checkNo.length()==25 && editType.equals("SHOW"))
      {
    	  forward= "SHOWEAA";
      }
      if(!editType.equals("SHOW")){
        saveToken(httpServletRequest);
      }  
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
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      
      String errorMessage = (String)httpServletRequest.getAttribute("errorMessage");
      if(errorMessage != null && errorMessage.equals("�ð��鿱��Ϣ�����ڣ����ܻ�δ���в鿱")){
    	  error = new ActionError("  ");
      }else{
          httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;   	  
      }
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      //httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
     
    return actionMapping.findForward(forward);
  }
}
