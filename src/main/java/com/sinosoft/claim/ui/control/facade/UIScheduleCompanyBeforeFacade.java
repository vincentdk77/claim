package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompanyAction;
import com.sinosoft.claim.ui.control.action.UIScheduleCompanyAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 理赔调度节点的改派任务
 * <p>Title: 理赔调度节点的新的改派任务</p>
 * <p>Description: 理赔调度节点的改派任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
 
public class UIScheduleCompanyBeforeFacade  extends Action
{

  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {

   /** 调度中心设置详细信息，如果有设置调度中心的权限，则可以进行设置
    * 如果原来没有设置信息，可以重新设置，也可以设置有效和无效。
    **/
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

     String forward  = "";
     String registNo="";
                                        //向前
    String editType     = httpServletRequest.getParameter("editType");
    
    try
    {
     	 String strScheduleComCode="";//20060807user.getScheduleComCode();
         String msg="";
         if (strScheduleComCode ==null ||strScheduleComCode.length() <1){
         	msg="该用户没有可以设置的调度中心信息!";
             throw new UserException(1,3,"调度中心设置",msg);
 
         }
         
         //如果是总公司人员，可以随便增加的
         String strSelectNewCode=httpServletRequest.getParameter("comCode");
         
         if (strSelectNewCode!=null &&strSelectNewCode.length() >1){
         	strScheduleComCode =strSelectNewCode; 
         }
       if(editType.equals("ADD")||editType.equals("SHOW"))
        {

       	System.out.println("------sinosoft--18:00-09--");
           PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
           UIScheduleCompanyAction uiScheduleCompanyAction = new UIScheduleCompanyAction();
           ScheduleCompanyDto scheduleCompanyDto = uiScheduleCompanyAction.findByPrimaryKey(strScheduleComCode);
           
           prpLscheduleCompanyDto= scheduleCompanyDto.getPrpLscheduleCompanyDto ();
        
           if (prpLscheduleCompanyDto==null){
           	prpLscheduleCompanyDto =new PrpLscheduleCompanyDto();
           	prpLscheduleCompanyDto.setComCode( strScheduleComCode);
           	prpLscheduleCompanyDto.setOffDutyTime("18:00:00" );
           	prpLscheduleCompanyDto.setOnDutyTime("09:00:00" );
           	prpLscheduleCompanyDto.setValidStatus("1");
             }
           
           //转换名称
           UICodeAction uiCodeAction = new UICodeAction();
           String comName = uiCodeAction.translateComCode( strScheduleComCode,true);
           prpLscheduleCompanyDto.setComName( comName);
           httpServletRequest.setAttribute ("prpLscheduleCompanyDto", prpLscheduleCompanyDto);
           httpServletRequest.setAttribute ("scheduleCompanyDto", scheduleCompanyDto );
 
//         20060807httpServletRequest.setAttribute("dayList", ICollections.getDayList());
           //将所有为调度中心的数据查询出来。。。
           String sqstr=" substr(comType,6,1)='1' order by comcode ";
           UICompanyAction uiCompanyAction = new UICompanyAction();
           Collection scheduleCenterList=uiCompanyAction.findByConditions (sqstr );
           if (scheduleCenterList!=null&&scheduleCenterList.size()>0){
           	
           	  for (int i=0;i<scheduleCenterList.size();i++){
           	      String sCode=((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).getComCode();
           	      
           	      String sName=((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).getComCName();
           	   ((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).setComCName(sCode+"-"+sName);   
           	  }
           }
           httpServletRequest.setAttribute ("scheduleCenterList", scheduleCenterList);
         
          forward = "success";
        }
       
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
