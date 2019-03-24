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
 * 分发HTTP GET 车险理赔查勘前查询保单请求
 * <p>Title: 车险理赔查勘前查询保单信息</p>
 * <p>Description: 车险理赔查勘前查询保单信息系统样本程序</p>
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
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    

    String claimNo      = "" ;
    String registNo     = "" ;
    String checkNo      = "" ;
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");
    String riskCode = httpServletRequest.getParameter("riskCode");                 //险种
    String forward  = "";   //向前
    String tempStatus = "";
    ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
    try
    {
      UICodeAction uiCodeAction = new UICodeAction();
      //add by miaowenjun 20060922 start 获取险类代码
      String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
      //add by miaowenjun 20060922 end 获取险类代码
      //尚未加入type异常处理{}、其它必须参数异常处理{}
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
			        //查询立案信息,整理输入，用于初始界面显示
			        registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); //报案号
			        if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
			      {
			        riskCode=BusinessRuleUtil.getRiskCode(registNo,"RegistNo"); 
			      }
		
		    //==================================================
		        //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
		        //如果没有flowID和logno则不进行判断。
			        String flowID = String.valueOf(httpServletRequest.getAttribute("swfLogFlowID_"+index)) ;
			        String logNo= String.valueOf(httpServletRequest.getAttribute("swfLogLogNo_"+index)) ;
			        if (flowID!=null && logNo!=null)
			        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			        	 SwfLogDto swfLogDto = new SwfLogDto();
			        	 swfLogDto = uiWorkFlowAction.holdNodeCombine(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
			        	 if (swfLogDto.getHoldNode()==false)
			                   {
			                     String msg="案件'"+registNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件进行处理!";
			                     throw new UserException(1,3,"工作流",msg);
			                   }
			       }
		    //================================================== 
		       // DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
		       // dAACertainLossViewHelper.registDtoToView(httpServletRequest,registNo,editType);
		          
		       //modify by miaowenjun 20060922 农险走自己的viewhelper
					if("I".equals(riskType)||"Q".equals(riskType)||"H".equals(riskType)){
						AgriCombineCheckViewHelper agriCombineCheckViewHelper = new AgriCombineCheckViewHelper();
						agriCombineCheckViewHelper.registDtoToView(httpServletRequest,registNo,editType,index);
						agriCombineCheckViewHelper.addVerifyLossDtoToView(httpServletRequest,registNo,index);
					}else{
						//并案暂时屏蔽DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
					//并案暂时屏蔽dAACheckViewHelper.registDtoToView(httpServletRequest,registNo,editType);
					}
				      //reason：增加与赔付数量对应的单位信息
				      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
				      Collection collection = uiCodeAction.findByConditions(conditions);
				      httpServletRequest.setAttribute("lossesUnitCodeCollection_"+index,collection);
		       }
		
		      if(editType.equals("EDIT")||editType.equals("SHOW")||editType.equals("DELETE"))
		      {
		        //查询查勘信息,整理输入，用于初始界面显示
		        checkNo = String.valueOf(httpServletRequest.getAttribute("prpLcheckCheckNo_"+index)); //查勘号
		        if (checkNo.length() > 21) {
					registNo = checkNo.substring(0, 21);
				}else{
					registNo = checkNo;
				}
		        //modify by miaowenjun 20060922 农险走自己的viewhelper
		        if("I".equals(riskType)||"H".equals(riskType)){
		        	AgriCombineCheckViewHelper agriCombineCheckViewHelper = new AgriCombineCheckViewHelper();
		        	agriCombineCheckViewHelper.checkDtoView(httpServletRequest,checkNo,index);
		        	agriCombineCheckViewHelper.PrpLverifyLossDtoToView(httpServletRequest,checkNo,index);
		        	agriCombineCheckViewHelper.verifyLossDtoToView(httpServletRequest,checkNo,index);
		        }
		        else{
		        	//并案暂时屏蔽DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
		        	//并案暂时屏蔽dAACheckViewHelper.checkDtoView(httpServletRequest,checkNo);
		        }
			      //reason：增加与赔付数量对应的单位信息
			      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
			      Collection collection = uiCodeAction.findByConditions(conditions);
			      httpServletRequest.setAttribute("lossesUnitCodeCollection_"+index,collection);
		      }
		     
/*	//    未处理查勘任务的放弃处理
		      if (editType.equals("GIVUP")) {
		          //add by huangyunzhong 20051226 放弃未暂存和提交的查勘任务，删去结点操作人，使其他人可见可处理
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
		//   已暂存查勘任务的放弃处理
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
		        	  throw new UserException(1,3,"工作流","");
		          swfLogDtoList.add(swfLogDto);
		         
		      }
		      //取得forward
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
       //错误信息处理
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
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      
      String errorMessage = (String)httpServletRequest.getAttribute("errorMessage");
      if(errorMessage != null && errorMessage.equals("该案查勘信息不存在，可能还未进行查勘")){
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
