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
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 理赔节点状态查询
 * <p>Title: 车险理赔节点状态询信息</p>
 * <p>Description: 车险理赔节点状态信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowNodeTimeOutGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String startDate =httpServletRequest.getParameter("statStartDate") ;
    String endDate=httpServletRequest.getParameter("statEndDate") ;
    String editType   = "EDIT";
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        String condition =" (nodeStatus in ('0','1','2','3','7')) ";

        //接收用户录入的条件
         String strRiskCodeSign          = httpServletRequest.getParameter("RiskCodeSign");
         String strRiskCode              = httpServletRequest.getParameter("RiskCode");
         String strOperatorCodeSign      = httpServletRequest.getParameter("OperatorCodeSign");
         String strOperatorCode          = httpServletRequest.getParameter("OperatorCode");
         String strStartDate             = httpServletRequest.getParameter("statStartDate");
         String strEndDate               = httpServletRequest.getParameter("statEndDate");
         String checkFlag0               = httpServletRequest.getParameter("checkFlag0");
         String checkFlag1               = httpServletRequest.getParameter("checkFlag1");
         String checkFlag2               = httpServletRequest.getParameter("checkFlag2");
         String checkFlag3               = httpServletRequest.getParameter("checkFlag3");
         String checkFlag7               = httpServletRequest.getParameter("checkFlag7");
         String strTemp                  ="";
         String nodeType = httpServletRequest.getParameter("nodeType");
         String checkFlagPrepay= httpServletRequest.getParameter("checkFlagPrepay");
         String  checkFlagCompany= httpServletRequest.getParameter("checkFlagCompany");
         //拼状态
         if (checkFlag0!=null||checkFlag1!=null||checkFlag2!=null||checkFlag3!=null||checkFlag7!=null) {
            if (checkFlag0!=null) strTemp=strTemp+"'0',";
            if (checkFlag1!=null) strTemp=strTemp+"'1',";
            if (checkFlag2!=null) strTemp=strTemp+"'2',";
            if (checkFlag3!=null) strTemp=strTemp+"'3',";
            if (checkFlag7!=null) strTemp=strTemp+"'7',"; 
            //去掉最后的一个","
            strTemp = strTemp.substring(0,strTemp.length()-1) ;
            condition = " (nodeStatus in("+strTemp+")) ";
          }


         //默认条件下，查询条件为节点状态为0，1，2，3，7 这几个状态，如果全选，或者一个不选，结果是一样的
         //拼成where条件字句
         //计算日期间隔
        if ((strEndDate!=null)&&(strStartDate!=null)) {
          //String endDateLast = new DateTime(strEndDate).addDay(1).toString() ;
          condition= condition + " and handleTime>='"+strStartDate+"' and handleTime<'"+strEndDate+"' ";
        }
         String strCondition = condition;
         strCondition += StringConvert.convertString("RiskCode"    , strRiskCode      ,  strRiskCodeSign      );
         strCondition += StringConvert.convertString("handlerCode", strOperatorCode  ,  strOperatorCodeSign  );

        if (nodeType.equals("allty")) {
          if (checkFlagPrepay!=null)  strCondition = strCondition+ " and nodeType!='prepa' ";
          if (checkFlagCompany!=null)  strCondition = strCondition+ " and nodeType!='compe' ";
        } else {
            strCondition += StringConvert.convertString("NodeType", nodeType  ,  "="  );
        } 

        strCondition = strCondition+ " order by handleTime" ;
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        workFlowViewHelper.getNodeTimeOutInfo(httpServletRequest,strCondition);
        forward = "success";

    }
    catch(UserException usee) {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    } catch(Exception e) {
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
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
