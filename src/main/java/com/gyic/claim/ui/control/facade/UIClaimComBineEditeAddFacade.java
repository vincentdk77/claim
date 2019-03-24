package com.gyic.claim.ui.control.facade;


import java.util.ArrayList;
import java.util.List;

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

import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.ui.control.action.UIClaimComBineAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET
 * <p>Title: 养殖险合并案件</p>
 * <p>Description: 养殖险合并案件</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Sinosoft</p>
 * @author qianxiantao
 * @version 1.0
 */

public class UIClaimComBineEditeAddFacade extends Action
{
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)
	  throws Exception
	  {     
		
		    String   forward= ""; 
		    String   CombineNo="";
		    String   policyNo="";
		    String   nodeStatus="";
		    String   policyno="";
		    BLPrplcombineFacade  bLPrplcombineFacade = new BLPrplcombineFacade();
		    PrplcombineDto prpcombineDto=new PrplcombineDto();
		    BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		    UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		    String[] registNos= httpServletRequest.getParameter("checkBox").split("&");
		try{
			SwfLogDto swfLogDto=new SwfLogDto();
		    ArrayList arrayList=new ArrayList();
		    ArrayList arrayList1=new ArrayList();
		    List combineNoList = new ArrayList();
		    for(int i=1;i<registNos.length;i++){
				   swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
				   if(!"".equals(swfLogDto.getHandlerName())||!"".equals(swfLogDto.getHandlerCode())){
					   throw new Exception("该并案正在处理中，不能新增合并案件！");
				   }else{
					    forward= "success";
				    }
			}
		    for(int i=1;i<registNos.length;i++){
				   swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
				   policyno=swfLogDto.getPolicyNo();
				   arrayList1.add(policyno);
			}
		    for(int i=0;i<arrayList1.size();i++){
			   if(arrayList1.get(0).equals(arrayList1.get(i))!=true){
				    throw new Exception("不在同一保单下，不能新增合并案件！");	
			   }else{
				    forward= "success";
				    }
		    }
		    for(int i=1;i<registNos.length;i++){	    	
				   swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
				   nodeStatus=swfLogDto.getNodeStatus();
				   arrayList.add(nodeStatus);
			}
		    for(int i=0;i<arrayList.size();i++){
			   if(arrayList.get(0).equals(arrayList.get(i))!=true){
				    throw new Exception("节点状态不一致，不能新增合并案件！");	
			   }else{
				    forward= "success";
				    }
		    }
		    boolean allEmpty=true;
		    for(int i=1;i<registNos.length;i++){		    	
		    	   prpcombineDto=bLPrplcombineFacade.findByPrimaryKey(registNos[i]);
		    	   if(prpcombineDto!=null){
		    		CombineNo=prpcombineDto.getCombineno();
		    		policyNo=prpcombineDto.getPolicyno();
		    		allEmpty=false;
		    		if(null!=CombineNo && !"".equals(CombineNo))
		    			combineNoList.add(CombineNo);
		    	    }
		    }
		    if(null!=combineNoList && combineNoList.size()>=2){
			    for(int i=0;i<combineNoList.size();i++){
			    	String combineNo_i = (String)combineNoList.get(i);
			    	for(int j=i+1;j<combineNoList.size();j++){
			    		String combineNo_j = (String)combineNoList.get(j);
			    		if(!combineNo_i.equals(combineNo_j))
			    			throw new Exception("所选报案至少属于两个并案中，不能新增合并案件！");
			    	}
			    }
		    }
		    if(allEmpty){
		    	throw new Exception("请选择至少一条已合并案件！");	
		    }
		    for(int i=1;i<registNos.length;i++){	    	
		    	prpcombineDto=bLPrplcombineFacade.findByPrimaryKey(registNos[i]);
		    	if(prpcombineDto!=null){
		    	}else{
		        prpcombineDto = new PrplcombineDto();
		    	prpcombineDto.setCombineno(CombineNo);
		    	prpcombineDto.setPolicyno(policyNo);
		    	prpcombineDto.setRegistno(registNos[i]);
		    	bLPrplcombineFacade.insert(prpcombineDto); 
		    	}
		    }
		    user.setUserMessage(CombineNo);
		    ActionMessages messages = new ActionMessages();
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"prompt.combine.add"));
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"db.prplcombine.comboneNo"));
		    saveMessages(httpServletRequest, messages);
		    forward = "success";
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
