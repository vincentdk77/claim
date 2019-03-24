package com.gyic.claim.ui.control.facade;


import java.util.ArrayList;

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
import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
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

public class UIClaimComBineFacade extends Action
{
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)
	  throws Exception
	  {
		    String   forward= ""; 
		    String   CombineNo="";
		    String   policyNo=httpServletRequest.getParameter("policyNo");
		    String riskCode = httpServletRequest.getParameter("riskCode");
		    String ComCode ="";
		    String nodeStatus="";
		    String policyno="";
		    BLPrpLregistFacade prpLregistFacade=new BLPrpLregistFacade();
		    UIClaimComBineAction  uIClaimComBineAction = new UIClaimComBineAction();
		    PrplcombineDto prpcombineDto=new PrplcombineDto();
		    BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		    UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		    try{
		    String[] registNos= httpServletRequest.getParameter("checkBox").split("&");
		    PrpLregistDto prplRegistDto=(PrpLregistDto)prpLregistFacade.findByPrimaryKey(registNos[1]);
		    SwfLogDto swfLogDto=new SwfLogDto();
		    ArrayList arrayList=new ArrayList();
		    ArrayList arrayList1=new ArrayList();
		    ArrayList arrayList2=new ArrayList();
		    ArrayList arrayList3=new ArrayList();
		    ArrayList arrayList4=new ArrayList();
		    for(int i=1;i<registNos.length;i++){
				   swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
				   policyno=swfLogDto.getPolicyNo();
				   arrayList1.add(policyno);
			}
		    for(int i=0;i<arrayList1.size();i++){
			   if(arrayList1.get(0).equals(arrayList1.get(i))!=true){
				    throw new Exception("不在同一保单下，不能合并案件！");	
			   }
		    }
		    for(int i=1;i<registNos.length;i++){		    	
				   swfLogDto=blSwfLogFacade.findByRegistNo(registNos[i]);
				   nodeStatus=swfLogDto.getNodeStatus();
				   arrayList3.add(swfLogDto.getNodeType());
				   swfLogDto=blSwfLogFacade.findByPrimaryKey(swfLogDto.getFlowID(), 4);
				   arrayList2.add(swfLogDto.getHandlerCode());
				   arrayList4.add(swfLogDto.getHandleDept());
				   arrayList.add(nodeStatus);
			}
		    for(int i=0;i<arrayList3.size();i++){
				   if(arrayList3.get(0).equals(arrayList3.get(i))!=true){
					    throw new Exception("所处节点不一致，不能合并案件！");	
				   }
			    }
		    for(int i=0;i<arrayList.size();i++){
			   if(arrayList.get(0).equals(arrayList.get(i))!=true){
				    throw new Exception("节点状态不一致，不能合并案件！");	
			   }
		    }
		    if("check".equals(String.valueOf(arrayList3.get(0))))
		    {
			    String temp="";
			    for(int i=0;i<arrayList4.size();i++){
					   if(!String.valueOf(arrayList4.get(0)).equals(String.valueOf(arrayList4.get(i))) ){
						   throw new Exception("定损节点指定案件处理单位须一致 ！");	
					   }
				    }
			    for(int i=0;i<arrayList2.size();i++){
				   if(arrayList2.get(i) != null && !"".equals(String.valueOf(arrayList2.get(i)).trim())){
					   temp = String.valueOf(arrayList2.get(i)).trim();
					   break;
				   }
			    }
			    for(int i=0;i<arrayList2.size();i++){
			    	if(arrayList2.get(i) != null && !"".equals(String.valueOf(arrayList2.get(i)).trim()) 
			    			&& !String.valueOf(arrayList2.get(i)).trim().equals(temp)){
					    throw new Exception("定损节点指定案件处理人须一致 ！");	
			    	}
				}
		    }
		    forward= "success";
		    if(prplRegistDto!=null){
		    ComCode=prplRegistDto.getComCode();
		    riskCode=prplRegistDto.getRiskCode();
		    }
		    int year = DateTime.current().getYear();
		    if("".equals(CombineNo)||CombineNo==null){
		       UIBillAction uiBillAction = new UIBillAction();
		       String tableName = "prplcombine";
		       CombineNo=uiBillAction.getNo(tableName, riskCode, ComCode, year);
		    }		   
		    for(int i=1;i<registNos.length;i++){		    	
		    	   prpcombineDto.setCombineno(CombineNo);
		    	   prpcombineDto.setPolicyno(policyno);
		    	   prpcombineDto.setRegistno(registNos[i]);
		    	   uIClaimComBineAction.claimComBine(prpcombineDto);
		    }
		    user.setUserMessage(CombineNo);
		    ActionMessages messages = new ActionMessages();
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"prompt.combine.submit"));
		    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"db.prplcombine.comboneNo"));
		    saveMessages(httpServletRequest, messages);
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
