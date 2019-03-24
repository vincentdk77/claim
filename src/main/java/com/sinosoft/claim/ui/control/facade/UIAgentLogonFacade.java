package com.sinosoft.claim.ui.control.facade;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLEdaUserFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UILogonAction;
import com.sinosoft.claim.ui.control.action.UIUtiCodeTransferAction;
import com.sinosoft.claim.ui.view.formbean.LogonForm;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/** 
 * ������ϯ�����ҵ��ϵͳ����Facade
 * <p>Title: ��ϯҵ��ϵͳ��¼</p>
 * <p>Description: ��ϯҵ��ϵͳ��¼facade</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author CallCenter
 * @version 1.0
 */
public class UIAgentLogonFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception
  {
    
  	UserDto user = new UserDto();
    String forward = "false";
    HttpSession session = httpServletRequest.getSession();
    
  	try{ 
        //�õ����е����ִ���
  	    UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
      	UICodeAction uiCodeAction = new UICodeAction();
      	ArrayList transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");
      	session.setAttribute("transferList", transferList); 
      	
      	//��ϵͳ�м��ϵ�¼ҳ�棬�Ա��ܲ���ʹ��ʱͬ�����Խ��б���
      	LogonForm logonForm = (LogonForm)actionForm;
        String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA"); 
        
        String agentCode = logonForm.getPrpDuserUserCode();
        String agentPassword = logonForm.getPrpDuserPassword();
        agentCode  = StringUtils.rightTrim(agentCode);
        agentPassword  = StringUtils.rightTrim(agentPassword);
        UILogonAction uILogonAction = new UILogonAction(); 
        boolean blnFlag = false;   
        boolean blnReturn = false; //ͨ����¼ҳ�����빤���������Ƿ���ȷ
        
        /*
        if(!agentCode.equals(""))
        {
            //�жϹ����������Ƿ���ȷ
            blnReturn = uILogonAction.isExist(agentCode,agentPassword);
           
        	if(!blnReturn)
            {
            	forward = "false"; //���������벻��ȷ
            	blnFlag = true;
            }          	
        }
        */
        //�����Ǵ���û��ͨ����ϯ��ܵ�¼�����
        
        DateTime.setDateDelimiter("-") ;
    
        //����Ҫ�õ���ϯ��ܴ������Ĳ���
        
        String strCallID = StringUtils.rightTrim(httpServletRequest.getParameter("COID"));
        String strAgentID=StringUtils.rightTrim(httpServletRequest.getParameter("AgentID"));
        String strANI = StringUtils.rightTrim(httpServletRequest.getParameter("ANI"));
        String strTaskCode = StringUtils.rightTrim(httpServletRequest.getParameter("taskcode"));
        
        //������Ǵ���ϯ��ܵ�¼����ôagentidΪ��ϯ��¼�Ĺ���
        /*
        if(blnReturn)
        {
          strAgentID=agentCode;
          strTaskCode = "regist";
        }
        */
        
        //������ϯ���Ż�ȡԱ������
        BLEdaUserFacade bLEdaUserFacade = new BLEdaUserFacade();
        EdaUserDto edaUserDto = bLEdaUserFacade.findByPrimaryKey(strAgentID);
        String usercode = "";
        if(edaUserDto!=null)
        {
          usercode  = edaUserDto.getUserCode();
        }
        else
        {
          user.setLoginMessage("���Ż����������");
	      session.setAttribute("userDto", user);  
	      forward = "false";    //��¼��ϢУ����Ч	
	    }
       
        if ( strAgentID==null||strAgentID.equals("")||usercode==null || usercode.equals("")||blnFlag)
	    {
        	 
        	forward = "false"; //��ȡ��ϯ��ܲ�������ת����У����Чҳ��
	    }
	    else
	    {
	      //����Ա������õ�Ա������
	      PrpDuserDto prpDuserDto = bLEdaUserFacade.findPrpDUserByPrimaryKey(usercode);
	     
	      if (prpDuserDto!=null)
	      {
	       //���û���Ϣ����ϯ�ӿڲ�������user��session��
	       user.setUserCode(usercode);
	       user.setRiskCode(riskCode);
	       user.setComCode(prpDuserDto.getComCode() );
	       user.setLoginSystem("claim");
	       String userName = uiCodeAction.translateUserCode(usercode,true);
	        
	       user.setUserName(userName);
	       //user.setAreaCode(strAreaCode);
	       String comName = uiCodeAction.translateComCode(user.getComCode(),true )  ;
	       user.setComName(comName);
	       user.setTaskCode(strTaskCode);
	       user.setAgentID(strAgentID);
	       user.setCallID(strCallID);
	       user.setAni(strANI);
	       
	       session.setAttribute("user", user);
       
	       //session.setMaxInactiveInterval(1*60*60); //����Session����ʱ��Ϊ1Сʱ
	       
	       forward = "success";  //��ϢУ����Ч
	      }
	      else
	      {
	      	 user.setLoginMessage("��ȡԱ����Ϣʧ��");
	         session.setAttribute("userDto", user);  
	         forward = "false";    //��¼��ϢУ����Ч
	      }
	     }

    }
    catch(Exception e)
    {  
    	 user.setLoginMessage("��ȡԱ����Ϣʧ��");
         session.setAttribute("userDto", user);      
         forward = "false";    //��ȡ��ϯ��ܲ�������ת����У����Чҳ��
         e.printStackTrace() ;
    }
    finally
    {

    }
    return actionMapping.findForward(forward);
  }
}
