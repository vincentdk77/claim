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
 * �ַ�HTTP GET ������Ƚڵ�ĸ�������
 * <p>Title: ������Ƚڵ���µĸ�������</p>
 * <p>Description: ������Ƚڵ�ĸ�������</p>
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

   /** ��������������ϸ��Ϣ����������õ������ĵ�Ȩ�ޣ�����Խ�������
    * ���ԭ��û��������Ϣ�������������ã�Ҳ����������Ч����Ч��
    **/
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

     String forward  = "";
     String registNo="";
                                        //��ǰ
    String editType     = httpServletRequest.getParameter("editType");
    
    try
    {
     	 String strScheduleComCode="";//20060807user.getScheduleComCode();
         String msg="";
         if (strScheduleComCode ==null ||strScheduleComCode.length() <1){
         	msg="���û�û�п������õĵ���������Ϣ!";
             throw new UserException(1,3,"������������",msg);
 
         }
         
         //������ܹ�˾��Ա������������ӵ�
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
           
           //ת������
           UICodeAction uiCodeAction = new UICodeAction();
           String comName = uiCodeAction.translateComCode( strScheduleComCode,true);
           prpLscheduleCompanyDto.setComName( comName);
           httpServletRequest.setAttribute ("prpLscheduleCompanyDto", prpLscheduleCompanyDto);
           httpServletRequest.setAttribute ("scheduleCompanyDto", scheduleCompanyDto );
 
//         20060807httpServletRequest.setAttribute("dayList", ICollections.getDayList());
           //������Ϊ�������ĵ����ݲ�ѯ����������
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
      //������Ϣ����
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
