
package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.ThirdPartyViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 车险理赔新增定损调度前查询保单请求
 * <p>Title: 车险理赔新增定损调度前查询保单信息</p>
 * <p>Description: 车险理赔新增定损调度前查询保单信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli  
 * @version 1.0 
 */

public class UIThirdPartyBeforeEditGetFacade extends Action
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
	 //   String claimNo     = "" ;
	    String businessNo     = "" ;
	 //   String checkNo     = "" ;
	    HttpSession session = httpServletRequest.getSession();
	    UserDto   user     = (UserDto)session.getAttribute("user");
	   // String riskCode = httpServletRequest.getParameter("riskCode");                 //险种
	    String forward  = "";                                          //向前
	    try
	    {

          //modify by wangli add start 20050412
	      if(editType.equals("ADDSHOW"))
	      {
          businessNo = httpServletRequest.getParameter("businessNo");
          ThirdPartyViewHelper thirdPartyViewHelper = new ThirdPartyViewHelper();
          UICodeAction uiCodeAction = new UICodeAction();
          String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");	 
          //检查是不是可以进行增加定损调度的？？？ 目前只检查调度状态为4的，是不是单正也做完了？？
           String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
           String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
           String nodeStatus=httpServletRequest.getParameter("nodeStatus"); //工作流状态
           
           if (nodeStatus.equals("4")){ //需要检查单compe??是否存在？
           	   String condition ="flowid='"+swfLogFlowID +"' AND nodeType='compe' and nodeStatus<'4'";
           	   UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
               int retCount= uiWorkFlowAction.findFlowNodeCountByConditon( condition);
               if (retCount>0){
                String msg="案件'"+businessNo+"'已经处理到理算环节，不能进行定损调度标的的增加,请选择其它案件进行处理!";
                throw new UserException(1,3,"工作流",msg);
      
               }
          }      
          
          //add by liyanjie 2005-12-17 start 对于双代案件,只有出险地调度才能新增定损
          /*
           PrpLregistDto prpLregistDto = (new BLPrpLregistFacade()).findByPrimaryKey(businessNo); 
          if((prpLregistDto.getCommiFlag()!=null) && "1".equals(prpLregistDto.getCommiFlag())){
          	//System.out.println("===== 是双代");
          	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            Collection curNodes = uiWorkFlowAction.findCurrentNode(swfLogFlowID,Integer.parseInt(swfLogLogNo));
            SwfLogDto swfLogDto = null; 
  		    if (curNodes.iterator().hasNext()) {
              //获得当前调度任务节点信息
              swfLogDto = (SwfLogDto) curNodes.iterator().next();
              if(  (swfLogDto.getCommiFlag()==null || swfLogDto.getCommiFlag().equals("")) && "4".equals(swfLogDto.getNodeStatus())  ||
  			     (swfLogDto.getCommiFlag()!=null) &&  "2".equals(swfLogDto.getCommiFlag()) ){
              	  String msg="案件'"+businessNo+"'是双代案件,只能由出险地公司调度人员新增定损调度，承保地公司调度不能进行新增操作,请选择其它案件进行处理!";
                  throw new UserException(1,3,"双代案件",msg);
              }else{
              	httpServletRequest.setAttribute("commiFlag",swfLogDto.getCommiFlag());   //设置属性,后边保存时做判断,双代案件新增任务分给出险地公司
              }
  		    }          
          }
          */
          //add by liyanjie 2005-12-17 end
          
          thirdPartyViewHelper.registDtoToView(httpServletRequest,businessNo,strRiskCode);
       
	        forward = "ADDSHOW";
	       }
	      //modify by wangli add end 20050412 
	      if(!editType.equals("ADDSHOW")){
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
	      errors.add(ActionErrors.GLOBAL_ERROR, error);
	      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
	      saveErrors(httpServletRequest, errors);
	      forward = "error"; 
	    }
	    finally  
	    {

	    }
	     
	    return actionMapping.findForward(forward);
	  }
	}

