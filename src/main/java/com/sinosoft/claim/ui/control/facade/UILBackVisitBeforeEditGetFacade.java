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
import com.sinosoft.claim.ui.control.viewHelper.DAABackVisitViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 查勘回访请求
 * <p>Title: 查勘回访</p>
 * <p>Description: 查勘回访</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 车险理赔项目组
 * @version 1.0
 */

public class UILBackVisitBeforeEditGetFacade extends Action{
  public ActionForward execute(ActionMapping actionMapping,
                             ActionForm actionForm,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse)
  throws Exception
  {
    //编辑类型：ADD-新增  EDIT-修改  SHOW-显示 CANCEL-注销
    String editType     = httpServletRequest.getParameter("editType"); //编辑类型
    String riskCode = httpServletRequest.getParameter("riskCode");     //险种
    String editForward  = editType;  //操作跳转
    String registNo= "";             //报案号
    String forward  = "";            //向前
    String strSql ="";               //查询条件
    String msg="";                   //抛出错误的信息的具体内容

    try
    {
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      if (editType.equals("ADD"))
      {
        //查询报案信息,整理输入，用于初始界面显示
        registNo= httpServletRequest.getParameter("RegistNo").trim();//报案号
        if(riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
        {
          riskCode= BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        }
/*      如果是主动产生任务的话，则不需要判断占号了
        //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
        //如果没有flowID和logno则不进行判断。
        String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        if (flowID!=null && logNo!=null)
        {
          UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
          SwfLogDto swfLogDto = new SwfLogDto();
          swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
          if (swfLogDto.getHoldNode()==false)
          {
            msg="案件'"+registNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件进行处理!";
            throw new UserException(1,3,"工作流",msg);
          }
         }
      }*/
      //收集页面所需数据
         DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
         dAABackVisitViewHelper.registDtoToView(httpServletRequest,registNo,editType);
       }
       //编辑类型为EDIT、SHOW时需要待开发
       if (editType.equals("EDIT") ||editType.equals("SHOW"))
       {
         registNo= httpServletRequest.getParameter("RegistNo").trim();//报案号
         riskCode= BusinessRuleUtil.getRiskCode(registNo.trim(),"RegistNo");
         String lossTypeFlag= httpServletRequest.getParameter("lossTypeFlag");//报案号
         String backVisitType = "";
         if(lossTypeFlag.equals("1")){
          backVisitType="1";
         }else{
          backVisitType="2";
         }
         //收集页面所需数据
         DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
         dAABackVisitViewHelper.backVisitDtoToView(httpServletRequest,registNo,backVisitType,editType);

      }
      //取得forward
      if (!editType.equals("BEFOREQERY")) forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"backv",editType,1);

       if (editType.equals("BEFOREQERY")){
      	  String nodeType =httpServletRequest.getParameter("nodeType");
          registNo =httpServletRequest.getParameter("registNo");
          String policyNo =httpServletRequest.getParameter("PolicyNo");
          String lossItemName=httpServletRequest.getParameter("lossItemName");
          String  startDate = httpServletRequest.getParameter("startDate");
          String  endDate   = httpServletRequest.getParameter("endDate");
        	String conditions=" ";


          if ( startDate!=null&&startDate.trim().length()>0 )
           {
             conditions =conditions+ " (flowIntime>='"+startDate+"') AND ";
           }
           if (endDate!=null&& endDate.trim().length()>0 )
           {
            conditions =conditions+ " (flowIntime<='"+new DateTime(endDate,DateTime.YEAR_TO_DAY ).addDay(1).toString()+"') AND ";
           }

           if ( policyNo!=null&& policyNo.trim().length()>0 )
           {
             conditions =conditions+ " ( policyNo like '"+policyNo+"%') AND ";
           }

           if ( registNo!=null&& registNo.trim().length()>0 )
           {
             conditions =conditions+ " ( keyIn like '"+registNo+"%') AND ";
           }

           if ( lossItemName!=null&& lossItemName.trim().length()>0 )
            {
                conditions =conditions+ " ( lossItemName like '%"+lossItemName+"%') AND ";
             }

//忘记关闭的工作流是不能被查询出来的。现在已经修改正确了 lixiang
              conditions=conditions+" nodeType='"+nodeType+"' and nodestatus='4' and (flowStatus='1' or flowStatus='2') order by flowintime desc";

      	DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
        dAABackVisitViewHelper.getBeforeTaskList(httpServletRequest,conditions,nodeType);
      	forward = "beforesuccess";
      }
System.out.println("----------riskcode-----------"+riskCode+"|"+registNo);


       saveToken(httpServletRequest);
    }
    catch(UserException usee)
    {
       usee.printStackTrace() ;
       //错误信息处理
       ActionErrors errors = new ActionErrors();
       ActionError error = new ActionError("录入回访信息");
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
      ActionError error = new ActionError("录入回访信息");
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



