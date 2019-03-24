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
    String editType     = httpServletRequest.getParameter("editType");
    String editForward  = editType;                 //最后做跳转的标志
    String claimNo      = "" ;
    String registNo     = "" ;
    String checkNo      = "" ;
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");
    String riskCode = httpServletRequest.getParameter("riskCode");                 //险种
    String forward  = "";   //向前
    String tempStatus = "";
    
    try
    {
      UICodeAction uiCodeAction = new UICodeAction();
      //add by miaowenjun 20060922 start 获取险类代码
      String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
      //add by miaowenjun 20060922 end 获取险类代码
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD")) {
        //查询立案信息,整理输入，用于初始界面显示
        registNo = httpServletRequest.getParameter("RegistNo"); //报案号
        if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
      {
        riskCode=BusinessRuleUtil.getRiskCode(registNo,"RegistNo"); 
      }

    //==================================================
        //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
        //如果没有flowID和logno则不进行判断。
        String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        if (flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
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
        //add by xiatian 修改意健流程
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
        //查询查勘信息,整理输入，用于初始界面显示
        checkNo = httpServletRequest.getParameter("prpLcheckCheckNo"); //查勘号
        
        if (checkNo.length() > 21) {
			registNo = checkNo.substring(0, 21);
		}else{
			registNo = checkNo;
		}
        //modify by miaowenjun 20060922 农险走自己的viewhelper
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
      /**大户地图信息显示控制*/
      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
      			/*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
				|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
				|| "3139,3141".indexOf(riskCode)>-1*/){
    	  /**获得大户信息*/
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
    	  /**大户*/
    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
    	  /**报案号*/
    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
    	  /**是否显示地图信息按钮*/
    	  if(!"".equals(strRichFlyCode))
    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "1");
      }
       
//    未处理查勘任务的放弃处理
      if (editType.equals("GIVUP")) {
          //add by huangyunzhong 20051226 放弃未暂存和提交的查勘任务，删去结点操作人，使其他人可见可处理
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
      
//   已暂存查勘任务的放弃处理
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
      
      //reason：增加与赔付数量对应的单位信息
      String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
      Collection collection = uiCodeAction.findByConditions(conditions);
      httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
      //取得forward
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"check",editType,1);
      //add by xiatian 修改意健险查勘显示页面路径
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
