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
 * �ַ�HTTP GET �鿱�ط�����
 * <p>Title: �鿱�ط�</p>
 * <p>Description: �鿱�ط�</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ����������Ŀ��
 * @version 1.0
 */

public class UILBackVisitBeforeEditGetFacade extends Action{
  public ActionForward execute(ActionMapping actionMapping,
                             ActionForm actionForm,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse)
  throws Exception
  {
    //�༭���ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ CANCEL-ע��
    String editType     = httpServletRequest.getParameter("editType"); //�༭����
    String riskCode = httpServletRequest.getParameter("riskCode");     //����
    String editForward  = editType;  //������ת
    String registNo= "";             //������
    String forward  = "";            //��ǰ
    String strSql ="";               //��ѯ����
    String msg="";                   //�׳��������Ϣ�ľ�������

    try
    {
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");

      if (editType.equals("ADD"))
      {
        //��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
        registNo= httpServletRequest.getParameter("RegistNo").trim();//������
        if(riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
        {
          riskCode= BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        }
/*      �����������������Ļ�������Ҫ�ж�ռ����
        //����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
        //���û��flowID��logno�򲻽����жϡ�
        String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        if (flowID!=null && logNo!=null)
        {
          UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
          SwfLogDto swfLogDto = new SwfLogDto();
          swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
          if (swfLogDto.getHoldNode()==false)
          {
            msg="����'"+registNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,��ѡ�������������д���!";
            throw new UserException(1,3,"������",msg);
          }
         }
      }*/
      //�ռ�ҳ����������
         DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
         dAABackVisitViewHelper.registDtoToView(httpServletRequest,registNo,editType);
       }
       //�༭����ΪEDIT��SHOWʱ��Ҫ������
       if (editType.equals("EDIT") ||editType.equals("SHOW"))
       {
         registNo= httpServletRequest.getParameter("RegistNo").trim();//������
         riskCode= BusinessRuleUtil.getRiskCode(registNo.trim(),"RegistNo");
         String lossTypeFlag= httpServletRequest.getParameter("lossTypeFlag");//������
         String backVisitType = "";
         if(lossTypeFlag.equals("1")){
          backVisitType="1";
         }else{
          backVisitType="2";
         }
         //�ռ�ҳ����������
         DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
         dAABackVisitViewHelper.backVisitDtoToView(httpServletRequest,registNo,backVisitType,editType);

      }
      //ȡ��forward
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

//���ǹرյĹ������ǲ��ܱ���ѯ�����ġ������Ѿ��޸���ȷ�� lixiang
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
       //������Ϣ����
       ActionErrors errors = new ActionErrors();
       ActionError error = new ActionError("¼��ط���Ϣ");
       errors.add(ActionErrors.GLOBAL_ERROR, error);
       httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
       saveErrors(httpServletRequest, errors);
       forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("¼��ط���Ϣ");
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



