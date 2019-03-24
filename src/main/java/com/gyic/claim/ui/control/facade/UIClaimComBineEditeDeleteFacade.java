package com.gyic.claim.ui.control.facade;
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
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLSwfLogFacade;

/**
 * 分发HTTP GET
 * <p>Title: 养殖险合并案件</p>
 * <p>Description: 养殖险合并案件</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Sinosoft</p>
 * @author qianxiantao
 * @version 1.0
 */

public class UIClaimComBineEditeDeleteFacade extends Action
{
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)
	  throws Exception
	  {
		    String   forward=""; 
		    BLPrplcombineFacade bLPrplcombineFacade=new BLPrplcombineFacade();
		    UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		    String[] registNos= httpServletRequest.getParameter("checkBox").split("&");
		    try{
		    BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		    SwfLogDto swfLogDto=new SwfLogDto();
		    for(int i=1;i<registNos.length;i++){
		    swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
			if(!"".equals(swfLogDto.getHandlerName())||!"".equals(swfLogDto.getHandlerCode())){
					throw new Exception("该并案正在处理中，不能删除合并案件！");
			}else{
				 forward= "success";
				}
		    }
		    for(int i=1;i<registNos.length;i++){		    	
		    	bLPrplcombineFacade.delete(registNos[i]);
		    }
		    ActionMessages messages = new ActionMessages();
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"prompt.combine.delete"));
		    saveMessages(httpServletRequest, messages);
		    forward= "success";
		    }catch(UserException usee)
		    {
		        usee.printStackTrace() ;
		        //错误信息处理
		        ActionErrors errors = new ActionErrors();
		        ActionError error = new ActionError("prompt.system.title");
		        errors.add(ActionErrors.GLOBAL_ERROR, error);
		        httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
		        saveErrors(httpServletRequest, errors);
		        forward = "error";
		      }
		    catch(Exception e){
		        e.printStackTrace();
		        ActionErrors errors = new ActionErrors();
		        ActionError error = new ActionError("prompt.system.title");
		        errors.add(ActionErrors.GLOBAL_ERROR, error);
		        httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
		        saveErrors(httpServletRequest, errors);
		        forward = "error";
		      }finally{

		      }
             return actionMapping.findForward(forward);
		    }
	}
