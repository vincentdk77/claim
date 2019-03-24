package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔调度节点的新的需要调度的任务
 * <p>Title: 理赔调度节点的新的需要调度的任务</p>
 * <p>Description: 理赔调度节点的新的需要调度的任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIScheduleGetBackQueryFacade  extends Action
{
   public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {

    /**  包含如下功能
     * 4。查询调度取回任务
    **/

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

    String forward  = "";                         //向前
    String editType     = httpServletRequest.getParameter("editType");
    try
    {
       //尚未加入type异常处理{}、其它必须参数异常处理{}
       //查询新调度提示表信息,整理输入，用于初始界面显示
       String          registNo  = httpServletRequest.getParameter("registNo");    //报案号
       String          startDate = httpServletRequest.getParameter("startDate");   //开始日期
       String          endDate   = httpServletRequest.getParameter("endDate");     //结束日期
       String          operatorCode    = httpServletRequest.getParameter("operatorCode");//调度员
      // String          scheduleObjectID= httpServletRequest.getParameter("scheduleObjectID");//调度对象
       String          licenseNo= httpServletRequest.getParameter("licenseNo");//车牌号码
      //String          strRegistNoSign= httpServletRequest.getParameter("registNoSign");//**
       String          nodeType= httpServletRequest.getParameter("nodeType");//调度类型
       String          NhandlerCode= httpServletRequest.getParameter("NhandlerCode");//定损人
       String          handlerCode = httpServletRequest.getParameter("handlerCode");//调度员
       String conditions ="";

       //4。查询调度取回任务
       //调用位置:调度任务->已查勘情况查询 ->输入查询条件后按下按钮->显示查询结果
        if(editType.equals("GETBACKQUERY"))
        {
          //说明:能够取回的任务必须是还没有被查勘处理过的调度任务
          //暂时不需要查询工作流，以后在加入换人的操作。还是从工作流中取得吧
        	   //由于是车险才有调度，所以必须判断是车险的险种。
           conditions=" (nodeType='"+nodeType+"' and nodestatus<'4') ";

          conditions= conditions + StringConvert.convertString("registNo",registNo,httpServletRequest.getParameter("registNoSign"));
           conditions= conditions + StringConvert.convertString("BeforeHandlerCode",handlerCode ,"=");
           conditions= conditions + StringConvert.convertString("handlerCode",NhandlerCode,"=");
           conditions= conditions + StringConvert.convertString("lossItemCode",licenseNo,httpServletRequest.getParameter("licenseNoSign"));
             
           if (startDate!=null &&startDate.trim().length()>0 )
           {
             conditions =conditions+ " and (flowintime>='"+startDate+"') ";
            }
            if ( endDate!=null&&endDate.trim().length()>0 )
            {
             conditions =conditions+ "  and (flowintime<='"+new DateTime(endDate,DateTime.YEAR_TO_DAY ).addDay(1).toString()  +"') ";
            }
           //modify by zhaolu 20060816 start
          UIPowerInterface uiPowerInterface = new UIPowerInterface();
          UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user"); 
          UICodeAction uiCodeAction = new UICodeAction();
          String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");          
          //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","swflog",strRiskCode);
          conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
          conditions = conditions +  " and registno not in (select registno from prplcombine)" ;//绑定中的案件不能改调度
          
          //从session里取扶贫/大户标志
          String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
          if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
        	  if(strHPflag.equals("Large")) {
        		  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
        	  }
              if(strHPflag.equals("Retaol")) {
            	  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
        	  }
          }
          //添加区分新农险标识
          conditions=conditions+  " and (systemflag is null or systemflag<>'agri') ";
          conditions=conditions+  " order by flowintime desc";
          //modify by zhaolu 20060816 end
          //从翻页取数据
          String condition = httpServletRequest.getParameter("condition");
          if(condition!=null && condition.trim().length()>0){ 
           conditions = condition;
          }
          
          System.out.println(conditions);
          DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
          dAAScheduleViewHelper.getNextTaskList(httpServletRequest,conditions,nodeType);
          forward ="GETBACKLISTDAA" ;

        }

       if(editType.equals("CANCELBEFOREQUERY"))
        {
          //说明:能够取回的任务必须是还没有被查勘处理过的调度任务
          //暂时不需要查询工作流，以后在加入换人的操作。还是从工作流中取得吧
          
       	registNo =httpServletRequest.getParameter("prpLcertainLossRegistNo");
       	 if ("all".equals( nodeType)){
          	conditions="nodestatus='0' and nodeType in ('certa','wound','propc')";
          }else{
       	  conditions=" (nodeType='"+nodeType+"' and nodestatus='0')";
          }
          conditions= conditions + StringConvert.convertString("registNo",registNo,"=");
          
          //modify by zhaolu 20060816 start
          UIPowerInterface uiPowerInterface = new UIPowerInterface();
          UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user"); 
          UICodeAction uiCodeAction = new UICodeAction();
          String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");          
          //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","swflog",strRiskCode);
          conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
          conditions=conditions+  " order by flowintime desc";
          //modify by zhaolu 20062816 end
          //从翻页取数据
          String condition = httpServletRequest.getParameter("condition");
          if(condition!=null && condition.trim().length()>0){ 
           conditions = condition;
          }
          
          System.out.println(conditions);
          DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
          dAAScheduleViewHelper.getNextTaskList(httpServletRequest,conditions,nodeType);
          forward ="CANCELLISTDAA" ;

        }

        saveToken(httpServletRequest);
    }

    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }

    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
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
