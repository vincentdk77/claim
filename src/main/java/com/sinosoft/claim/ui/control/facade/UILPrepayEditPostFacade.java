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

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAPrepayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP Post 车险理赔预赔编辑界面
 * <p>Title: 车险理赔预赔编辑界面信息</p>
 * <p>Description: 车险理赔预赔编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILPrepayEditPostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //向前流转
    try {
      UserDto   user     = (UserDto )httpServletRequest.getSession().getAttribute("user");
      String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
      String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
      String riskCodeTemp = httpServletRequest.getParameter("prpLprepayRiskCode");
      String taskType=""; //表示是特殊赔案中的预赔的新增，还是修改，如果是新增，则会增加新的工作流信息，
                          //只要设置taskType="T"类型的就可以了。

    	if(riskCodeTemp !=null&&riskCodeTemp.trim().length()>0){
        user.setRiskCode(riskCodeTemp);
      }
      String riskCode = user.getRiskCode();
      String comCode = user.getComCode();
      int year = DateTime.current().getYear() ;
      //险种
      if(isTokenValid(httpServletRequest,true)){
      //如果是新登记，则从取号表中取预赔号码，如果是修改，则保持原来的preCompensateNo不变
      //取预赔号
      String preCompensateNo = ""; //预赔号
      preCompensateNo = httpServletRequest.getParameter("prpLprepayPreCompensateNo");
      if (preCompensateNo== null||preCompensateNo.length()<1|| preCompensateNo.trim().equals(""))
      {
        UIBillAction uiBillAction = new UIBillAction();
        String tableName = "prplprepay";
        preCompensateNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
        taskType="T"  ;
      }
      httpServletRequest.setAttribute("preCompensateNo", preCompensateNo);
      httpServletRequest.setAttribute("prpLprepayPreCompensateNo", preCompensateNo);
      //用viewHelper整理界面输入
      PrepayDto prepayDto = null;
      DAAPrepayViewHelper daaPrepayViewHelper = new DAAPrepayViewHelper();
      prepayDto = daaPrepayViewHelper.viewToDto(httpServletRequest);
      
      //如果提交核赔则状态为9
      if (httpServletRequest.getParameter("buttonSaveType").equals("4")) {
          prepayDto.getPrpLprepayDto().setUnderWriteFlag("9");
      }

      //异常测试

      if(preCompensateNo.equals("") || preCompensateNo.length()!=22)
      {
        //throw new UserException(-98,-200,"","错误测试");
      }

        //工作流处理过程(属于特殊)
        //-----------------------------------------------------
        // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();

        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
        //swfLogDtoDealNode.setTaskType(taskType);
   
          swfLogDtoDealNode.setFlowID(swfLogFlowID);
          swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
       
        //如果下一个节点是结案的话，那么直接是赔案号就可以了
        //swfLogDtoDealNode.setNextBusinessNo(prepayDto.getPrpLprepayDto().getClaimNo());
        swfLogDtoDealNode.setNextBusinessNo(preCompensateNo);
        swfLogDtoDealNode.setKeyIn(prepayDto.getPrpLprepayDto().getClaimNo());
        swfLogDtoDealNode.setKeyOut(preCompensateNo);
        swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
        System.out.println();System.out.println(httpServletRequest.getParameter("buttonSaveType")+"============");System.out.println();
        
        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
        //------------------------------------------------------------
        //保存预赔信息
        UIPrepayAction uiPrepayAction = new UIPrepayAction();

        if (workFlowDto.getCheckClose() )
         { String msg ="该工作流程已经关闭，"
                      +"\n\r如果需要操作，请联系管理员重新开启工作流!";
           throw new UserException(1,2,"工作流",msg);
         }

         if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
        {

        	     //增加对核保核赔系统的接口调用。
        int vericLogNo=0;
         if (swfLogDtoDealNode.getNodeStatus().equals("4")){
               if (taskType.equals("T" ))
                  { //业务数据库中还没有数据
                   uiPrepayAction.save(prepayDto);}
                    if (workFlowDto.getSubmitSwfLogDtoList()!=null &&workFlowDto.getSubmitSwfLogDtoList().size()!=0){
                      vericLogNo=((SwfLogDto)workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo() ;
                    }

                    UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade=new UIWorkFlowUWInterFaceFacade();
                    String UWflowID= uiWorkFlowUWInterFaceFacade.submitVericTask(workFlowDto.getUpdateSwfLogDto().getFlowID() ,
                           vericLogNo+"",
                           "22",
                           "Y",
                           preCompensateNo,
                           prepayDto.getPrpLprepayDto().getRiskCode() ,
                           prepayDto.getPrpLprepayDto().getClassCode() ,
                           prepayDto.getPrpLprepayDto().getComCode(),
                           prepayDto.getPrpLprepayDto().getHandlerCode() ,
                           prepayDto.getPrpLprepayDto().getMakeCom() ,
                           user.getUserCode(),
                           prepayDto.getPrpLprepayDto().getHandler1Code() ,
                           "");
 
             if (UWflowID.length()!= 27){
                //如果提交核赔失败则状态为0 2005-9-29
//             	计算书提交失败时，把计算书置为暂存，可以再次提交。
				swfLogDtoDealNode.setNodeStatus("2");
                prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
				workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
				uiPrepayAction.save(prepayDto, workFlowDto);
                String msg="案件'"+preCompensateNo+"'提交双核系统失败，请重新提交或者与管理员联系!";
                throw new UserException(1,3,"工作流",msg);
             }

         }
        	 uiPrepayAction.save(prepayDto,workFlowDto);
             user.setUserMessage(preCompensateNo);
        } else {
             //如果提交核赔失败则状态为0
             prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
        	 uiPrepayAction.save(prepayDto);
             user.setUserMessage(preCompensateNo+";注意:没有发现与工作流流程相关任何数据！！");
        }

      //httpServletRequest.setAttribute("messagepagevalue",preCompensateNo) ;
      httpServletRequest.setAttribute("prpLregistDto",prepayDto.getPrpLprepayDto()) ;
    }

      ActionMessages messages = new ActionMessages();
      if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.prepay.submit"));
      }else {
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.prepay.save"));
      }
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLprepay.preCompensateNo"));
      saveMessages( httpServletRequest, messages );

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
