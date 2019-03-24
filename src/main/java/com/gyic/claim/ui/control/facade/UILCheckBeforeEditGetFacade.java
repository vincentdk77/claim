package com.gyic.claim.ui.control.facade;

import java.util.ArrayList;
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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.gyic.claim.ui.control.viewHelper.AgriCombineCheckViewHelper;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;
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
    

    String claimNo      = "" ;
    String registNo     = "" ;
    String checkNo      = "" ;
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");
    String riskCode = httpServletRequest.getParameter("riskCode");                 //����
    String forward  = "";   //��ǰ
    String tempStatus = "";
    ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
    try
    {
      UICodeAction uiCodeAction = new UICodeAction();
      //add by miaowenjun 20060922 start ��ȡ�������
      String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
      //add by miaowenjun 20060922 end ��ȡ�������
      //��δ����type�쳣����{}��������������쳣����{}
      BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
		String strConditions = "combineNo = '" + httpServletRequest.getParameter("combineNo") + "'";
		Collection combineDtos = bLPrplcombineFacade.findByConditions(strConditions);
		
      if(!"giveupTemporarySave".equals(httpServletRequest.getParameter("editType"))){
    	  Iterator iterator = combineDtos.iterator();
	  		int index=0;
	  		while(iterator.hasNext()){
	  			PrplcombineDto prplcombineDto = (PrplcombineDto)iterator.next();
	  			Utils.setSwflogInfoToRequestAccordingRegistNo(httpServletRequest, httpServletRequest.getParameter("nodeType"), 
	  					prplcombineDto.getRegistno(), index, httpServletRequest.getParameter("editType"));
	  			index++;
  		}
  		httpServletRequest.setAttribute("combineDtos", combineDtos );
      }	
		Iterator iterator = combineDtos.iterator();
		
		int index=0;
		while(iterator.hasNext())
			{	
				String editType     = String.valueOf(httpServletRequest.getAttribute("editType_"+index));
			      if (editType.equals("ADD")) {
			        //��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
			        registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); //������
			        if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
			      {
			        riskCode=BusinessRuleUtil.getRiskCode(registNo,"RegistNo"); 
			      }
		
		    //==================================================
		        //����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
		        //���û��flowID��logno�򲻽����жϡ�
			        String flowID = String.valueOf(httpServletRequest.getAttribute("swfLogFlowID_"+index)) ;
			        String logNo= String.valueOf(httpServletRequest.getAttribute("swfLogLogNo_"+index)) ;
			        if (flowID!=null && logNo!=null)
			        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			        	 SwfLogDto swfLogDto = new SwfLogDto();
			        	 swfLogDto = uiWorkFlowAction.holdNodeCombine(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
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
					if("I".equals(riskType)||"Q".equals(riskType)||"H".equals(riskType)){
						AgriCombineCheckViewHelper agriCombineCheckViewHelper = new AgriCombineCheckViewHelper();
						agriCombineCheckViewHelper.registDtoToView(httpServletRequest,registNo,editType,index);
						agriCombineCheckViewHelper.addVerifyLossDtoToView(httpServletRequest,registNo,index);
					}else{
						//������ʱ����DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
					//������ʱ����dAACheckViewHelper.registDtoToView(httpServletRequest,registNo,editType);
					}
				      //reason���������⸶������Ӧ�ĵ�λ��Ϣ
				      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
				      Collection collection = uiCodeAction.findByConditions(conditions);
				      httpServletRequest.setAttribute("lossesUnitCodeCollection_"+index,collection);
		       }
		
		      if(editType.equals("EDIT")||editType.equals("SHOW")||editType.equals("DELETE"))
		      {
		        //��ѯ�鿱��Ϣ,�������룬���ڳ�ʼ������ʾ
		        checkNo = String.valueOf(httpServletRequest.getAttribute("prpLcheckCheckNo_"+index)); //�鿱��
		        if (checkNo.length() > 21) {
					registNo = checkNo.substring(0, 21);
				}else{
					registNo = checkNo;
				}
		        //modify by miaowenjun 20060922 ũ�����Լ���viewhelper
		        if("I".equals(riskType)||"H".equals(riskType)){
		        	AgriCombineCheckViewHelper agriCombineCheckViewHelper = new AgriCombineCheckViewHelper();
		        	agriCombineCheckViewHelper.checkDtoView(httpServletRequest,checkNo,index);
		        	agriCombineCheckViewHelper.PrpLverifyLossDtoToView(httpServletRequest,checkNo,index);
		        	agriCombineCheckViewHelper.verifyLossDtoToView(httpServletRequest,checkNo,index);
		        }
		        else{
		        	//������ʱ����DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
		        	//������ʱ����dAACheckViewHelper.checkDtoView(httpServletRequest,checkNo);
		        }
			      //reason���������⸶������Ӧ�ĵ�λ��Ϣ
			      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
			      Collection collection = uiCodeAction.findByConditions(conditions);
			      httpServletRequest.setAttribute("lossesUnitCodeCollection_"+index,collection);
		      }
		     
/*	//    δ����鿱����ķ�������
		      if (editType.equals("GIVUP")) {
		          //add by huangyunzhong 20051226 ����δ�ݴ���ύ�Ĳ鿱����ɾȥ�������ˣ�ʹ�����˿ɼ��ɴ���
		          String FlowID = String.valueOf(httpServletRequest.getAttribute("swfLogFlowID_"+index));
		          int  LogNo=Integer.parseInt(String.valueOf(httpServletRequest.getAttribute("swfLogLogNo_"+index)));
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
*/		      
		//   ���ݴ�鿱����ķ�������
		      if ("giveupTemporarySave".equals(httpServletRequest.getParameter("editType"))) {
		          String FlowID = String.valueOf(httpServletRequest.getParameter("swfLogFlowID_"+index));
		          int  LogNo=Integer.parseInt(String.valueOf(httpServletRequest.getParameter("swfLogLogNo_"+index)));
		          UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
		          SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
		          if(swfLogDto.getNodeStatus().equals("2")){
		          swfLogDto.setHandlerCode("");
		          swfLogDto.setHandlerName("");
		          swfLogDto.setNodeStatus("0");
		          swfLogDto.setFlowStatus("1");
		             }
		          else if(swfLogDto.getNodeStatus().equals("0")){
		        	  swfLogDto.setHandlerCode("");
			          swfLogDto.setHandlerName("");
			          swfLogDto.setFlowStatus("1");
		          }
		          else
		        	  throw new UserException(1,3,"������","");
		          swfLogDtoList.add(swfLogDto);
		         
		      }
		      //ȡ��forward
		      if(!editType.equals("SHOW")){
		    	  saveToken(httpServletRequest);
		      }  
		      iterator.next();
		      index++;
		}
		forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"check","ADD",1);
		if(swfLogDtoList != null && swfLogDtoList.size()>0){
			UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
			uiworkflowaction.updateFlow(swfLogDtoList);
	        ActionMessages messages = new ActionMessages();
	        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
	        "prompt.compensate.giveup"));
	        saveMessages(httpServletRequest, messages);
	        forward = "success";
	        return actionMapping.findForward(forward);
		}
		saveToken(httpServletRequest);
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
