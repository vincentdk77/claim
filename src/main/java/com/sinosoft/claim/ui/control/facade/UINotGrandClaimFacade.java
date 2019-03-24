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
 * 分发HTTP Post 意健险不予立案处理文件
 * <p>Title: 意健险不予立案处理界面信息</p>
 * <p>Description: 意健险不予立案处理界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author 阳光项目组 
 * @version 1.0
 */
public class UINotGrandClaimFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //向前流转
     /*
     * 程序思路：
     *========================================================
     *[1]根据报案号registno取得报案信息
     *[2]回写报案信息
     *[3]保存报案表信息
     *[4]如是提交，执行Complate操作,并且关闭工作流endflag=1。
     *========================================================
    */
    try {
      UICodeAction uiCodeAction = new UICodeAction();
      String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
      //取报案号
      String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
      String riskCode = httpServletRequest.getParameter("riskCode");
      String policyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
      String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID");
      String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo");
      
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String comCode   = user.getComCode() ;
      
         //用viewHelper整理界面输入
         DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
         RegistDto registDto = dAARegistViewHelper.getNotGrandClaim(httpServletRequest);
         
         //工作流的viewHelper整理界面输入
         WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
         SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        
         //设置报案传入工作流的各个状态
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
         swfLogDtoDealNode.setEndFlag("1");  //关闭工作流
         
         // modify by wangli add start 200504017
         //swfLogDtoDealNode.setFlowInTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_MINUTE));
         // modify by wangli add end 200504017
        
         //整理工作流的创建/修改/提交的数据
         WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        
         UIRegistAction uiRegistAction = new UIRegistAction();
        
         if (workFlowViewHelper.checkDealDto(workFlowDto)){
             uiRegistAction.save(registDto,workFlowDto);
             user.setUserMessage(registNo);
           }else{
             if (workFlowDto.getOperateResult()<0){
                 user.setUserMessage("注意:创建工作流流程时，未找到相关工作流模板的设置，请联系系统管理员进行相应配置！！");
             } 
             else
             {
                 uiRegistAction.save(registDto);
                 user.setUserMessage(registNo+";注意:没有发现与工作流流程相关任何数据！！");
             }
         }
      /**add by qinyongli 2005-09-09 start 
      [reason:目前不予立案的案件在已处理立案任务中可以找到,按照和刘总沟通的结果，将报案以后各个环节，没有处理完毕的工作流节点全部删除]
      [********************************************************************************************************]
      [********************************对工作流节点进行删除操作,请慎重修改*******************************************]
      [********************************************************************************************************]
      [*执行删除操作的条件，工作流号长度判断,必须进行慎重处理，节点状态严格限制;*/
         //对工作流号进行限制
         String conditions = "";
         if(swfLogFlowID.length()==21){
        	  conditions = conditions +" nodestatus <> '4' and flowid ='"+swfLogFlowID+"'  ";
        	  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	  uiWorkFlowAction.deletWorkFlowForNotGrand(conditions);
         }                
      //************************对工作流节点进行删除操作,请慎重修改！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
      //add by qinyongli 2005-09-09 end 
      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.regist.notGrandClaim"));
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
      saveMessages( httpServletRequest, messages );

      //默认不需要自动跳转
      forward = "success";
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

    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //错误信息处理
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
      //错误信息处理
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
