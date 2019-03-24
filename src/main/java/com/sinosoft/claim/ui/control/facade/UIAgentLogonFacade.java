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
 * 处理座席框架与业务系统连接Facade
 * <p>Title: 座席业务系统登录</p>
 * <p>Description: 座席业务系统登录facade</p>
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
        //得到所有的险种代码
  	    UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
      	UICodeAction uiCodeAction = new UICodeAction();
      	ArrayList transferList = (ArrayList)uiUtiCodeTransferAction.findByConditions(" 1=1");
      	session.setAttribute("transferList", transferList); 
      	
      	//在系统中加上登录页面，以便框架不能使用时同样可以进行报案
      	LogonForm logonForm = (LogonForm)actionForm;
        String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA"); 
        
        String agentCode = logonForm.getPrpDuserUserCode();
        String agentPassword = logonForm.getPrpDuserPassword();
        agentCode  = StringUtils.rightTrim(agentCode);
        agentPassword  = StringUtils.rightTrim(agentPassword);
        UILogonAction uILogonAction = new UILogonAction(); 
        boolean blnFlag = false;   
        boolean blnReturn = false; //通过登录页面输入工号与密码是否正确
        
        /*
        if(!agentCode.equals(""))
        {
            //判断工号与密码是否正确
            blnReturn = uILogonAction.isExist(agentCode,agentPassword);
           
        	if(!blnReturn)
            {
            	forward = "false"; //工号与密码不正确
            	blnFlag = true;
            }          	
        }
        */
        //以上是处理没有通过座席框架登录的情况
        
        DateTime.setDateDelimiter("-") ;
    
        //这里要得到座席框架传过来的参数
        
        String strCallID = StringUtils.rightTrim(httpServletRequest.getParameter("COID"));
        String strAgentID=StringUtils.rightTrim(httpServletRequest.getParameter("AgentID"));
        String strANI = StringUtils.rightTrim(httpServletRequest.getParameter("ANI"));
        String strTaskCode = StringUtils.rightTrim(httpServletRequest.getParameter("taskcode"));
        
        //如果不是从座席框架登录，那么agentid为座席登录的工号
        /*
        if(blnReturn)
        {
          strAgentID=agentCode;
          strTaskCode = "regist";
        }
        */
        
        //根据座席工号获取员工代码
        BLEdaUserFacade bLEdaUserFacade = new BLEdaUserFacade();
        EdaUserDto edaUserDto = bLEdaUserFacade.findByPrimaryKey(strAgentID);
        String usercode = "";
        if(edaUserDto!=null)
        {
          usercode  = edaUserDto.getUserCode();
        }
        else
        {
          user.setLoginMessage("工号或者密码错误");
	      session.setAttribute("userDto", user);  
	      forward = "false";    //登录信息校验无效	
	    }
       
        if ( strAgentID==null||strAgentID.equals("")||usercode==null || usercode.equals("")||blnFlag)
	    {
        	 
        	forward = "false"; //获取座席框架参数有则转发到校验无效页面
	    }
	    else
	    {
	      //根据员工代码得到员工对象
	      PrpDuserDto prpDuserDto = bLEdaUserFacade.findPrpDUserByPrimaryKey(usercode);
	     
	      if (prpDuserDto!=null)
	      {
	       //将用户信息及座席接口参数加入user到session中
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
       
	       //session.setMaxInactiveInterval(1*60*60); //设置Session持续时间为1小时
	       
	       forward = "success";  //信息校验有效
	      }
	      else
	      {
	      	 user.setLoginMessage("获取员工信息失败");
	         session.setAttribute("userDto", user);  
	         forward = "false";    //登录信息校验无效
	      }
	     }

    }
    catch(Exception e)
    {  
    	 user.setLoginMessage("获取员工信息失败");
         session.setAttribute("userDto", user);      
         forward = "false";    //获取座席框架参数有则转发到校验无效页面
         e.printStackTrace() ;
    }
    finally
    {

    }
    return actionMapping.findForward(forward);
  }
}
