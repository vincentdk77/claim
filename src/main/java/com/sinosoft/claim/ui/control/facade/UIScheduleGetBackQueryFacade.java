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
 * �ַ�HTTP GET ������Ƚڵ���µ���Ҫ���ȵ�����
 * <p>Title: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
 * <p>Description: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
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

    /**  �������¹���
     * 4����ѯ����ȡ������
    **/

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

    String forward  = "";                         //��ǰ
    String editType     = httpServletRequest.getParameter("editType");
    try
    {
       //��δ����type�쳣����{}��������������쳣����{}
       //��ѯ�µ�����ʾ����Ϣ,�������룬���ڳ�ʼ������ʾ
       String          registNo  = httpServletRequest.getParameter("registNo");    //������
       String          startDate = httpServletRequest.getParameter("startDate");   //��ʼ����
       String          endDate   = httpServletRequest.getParameter("endDate");     //��������
       String          operatorCode    = httpServletRequest.getParameter("operatorCode");//����Ա
      // String          scheduleObjectID= httpServletRequest.getParameter("scheduleObjectID");//���ȶ���
       String          licenseNo= httpServletRequest.getParameter("licenseNo");//���ƺ���
      //String          strRegistNoSign= httpServletRequest.getParameter("registNoSign");//**
       String          nodeType= httpServletRequest.getParameter("nodeType");//��������
       String          NhandlerCode= httpServletRequest.getParameter("NhandlerCode");//������
       String          handlerCode = httpServletRequest.getParameter("handlerCode");//����Ա
       String conditions ="";

       //4����ѯ����ȡ������
       //����λ��:��������->�Ѳ鿱�����ѯ ->�����ѯ�������°�ť->��ʾ��ѯ���
        if(editType.equals("GETBACKQUERY"))
        {
          //˵��:�ܹ�ȡ�ص���������ǻ�û�б��鿱������ĵ�������
          //��ʱ����Ҫ��ѯ���������Ժ��ڼ��뻻�˵Ĳ��������Ǵӹ�������ȡ�ð�
        	   //�����ǳ��ղ��е��ȣ����Ա����ж��ǳ��յ����֡�
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
          conditions = conditions +  " and registno not in (select registno from prplcombine)" ;//���еİ������ܸĵ���
          
          //��session��ȡ��ƶ/�󻧱�־
          String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
          if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
        	  if(strHPflag.equals("Large")) {
        		  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
        	  }
              if(strHPflag.equals("Retaol")) {
            	  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
        	  }
          }
          //���������ũ�ձ�ʶ
          conditions=conditions+  " and (systemflag is null or systemflag<>'agri') ";
          conditions=conditions+  " order by flowintime desc";
          //modify by zhaolu 20060816 end
          //�ӷ�ҳȡ����
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
          //˵��:�ܹ�ȡ�ص���������ǻ�û�б��鿱������ĵ�������
          //��ʱ����Ҫ��ѯ���������Ժ��ڼ��뻻�˵Ĳ��������Ǵӹ�������ȡ�ð�
          
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
          //�ӷ�ҳȡ����
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
