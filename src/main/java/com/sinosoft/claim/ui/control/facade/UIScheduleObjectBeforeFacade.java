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

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
import com.sinosoft.claim.ui.control.action.UICompanyAction;
import com.sinosoft.claim.ui.control.action.UIScheduleObjectAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 理赔调度节点的改派任务
 * <p>Title: 理赔调度节点的新的改派任务</p>
 * <p>Description: 理赔调度节点的改派任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIScheduleObjectBeforeFacade  extends Action
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
         	 msg="该用户没有可以设置的所属调度中心机构！";
             throw new UserException(1,3,"调度中心设置",msg);
 
         }
        
         //如果是总公司人员，可以随便增加的
         String strSelectNewCode=httpServletRequest.getParameter("comCode");
         
                   
       if(editType.equals("ADD"))
        {
        UICompanyAction uiCompanyAction = new UICompanyAction();
        PrpDcompanyDto prpdcompanyDto = new PrpDcompanyDto ();
        PrpDcompanyDto prpdcompanyCenterDto = new PrpDcompanyDto ();
        prpdcompanyCenterDto = uiCompanyAction.findByPrimaryKey(strScheduleComCode );
        
        if (prpdcompanyCenterDto==null){
        	 msg="该用户没有可以设置的所属调度中心机构！";
             throw new UserException(1,3,"调度中心设置",msg);
       }
              
           String comName = prpdcompanyCenterDto.getComCName() ;
           prpdcompanyDto.setUpperComCode( strScheduleComCode);
           
           
           
           prpdcompanyDto.setOuterPayCode( strScheduleComCode );
           prpdcompanyDto.setInnerPayCode(  strScheduleComCode );
           prpdcompanyDto.setInsurerName( comName);
           prpdcompanyDto.setComCode( strScheduleComCode.substring(0,4 )+"9");
           prpdcompanyDto.setValidStatus( "1");
           //计算level
          String newLevel=(Integer.parseInt(DataUtils.nullToZero(prpdcompanyCenterDto.getComLevel()))+1)+"";
          prpdcompanyDto.setComLevel("7"); //先暂时写都是7的
          prpdcompanyDto.setComType( "1000001");
           
           ScheduleObjectDto scheduleObjectDto =new ScheduleObjectDto();
           scheduleObjectDto.setEditType( "ADD");
           httpServletRequest.setAttribute ("prpDcompanyDto", prpdcompanyDto);
           httpServletRequest.setAttribute ("scheduleObjectDto", scheduleObjectDto);
           
           //将所有为调度中心的数据查询出来。。。
           //将所有为调度中心的数据查询出来。。。
           String sqstr=" substr(comType,6,1)='1' order by comcode ";
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
       if(editType.equals("EDIT")||editType.equals("SHOW"))
        {
       	
       	   String comCode=httpServletRequest.getParameter("comCode");;
           PrpLscheduleObjectDto prpLscheduleObjectDto = null;
           UIScheduleObjectAction uiScheduleObjectAction = new UIScheduleObjectAction();
           ScheduleObjectDto scheduleObjectDto = uiScheduleObjectAction.findByPrimaryKey(comCode);
           
           scheduleObjectDto.setEditType( editType);
           if (scheduleObjectDto.getPrpdcompanyDto()!=null){
            httpServletRequest.setAttribute ("prpDcompanyDto", scheduleObjectDto.getPrpdcompanyDto());
            httpServletRequest.setAttribute ("scheduleObjectDto", scheduleObjectDto);
            //将所有为调度中心的数据查询出来。。。
            UICompanyAction uiCompanyAction = new UICompanyAction();
            
            //将所有为调度中心的数据查询出来。。。
            String sqstr=" substr(comType,6,1)='1' order by comcode ";
           Collection scheduleCenterList=uiCompanyAction.findByConditions (sqstr );
           if (scheduleCenterList!=null&&scheduleCenterList.size()>0){
           	
           	  for (int i=0;i<scheduleCenterList.size();i++){
           	      String sCode=((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).getComCode();
           	      
           	      String sName=((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).getComCName();
           	   ((PrpDcompanyDto)((ArrayList)scheduleCenterList).get(i)).setComCName(sCode+"-"+sName);   
           	  }
           }
           
           httpServletRequest.setAttribute ("scheduleCenterList", scheduleCenterList);
         
             }else{
              	  msg="没有查询到该机构的信息";
                 throw new UserException(1,3,"调度中心设置",msg);
         
             }
           
           //转换名称
         
          forward = "success";
        }
       
       if(editType.equals("QUERY"))
       {
       	UICompanyAction uiCompanyAction = new UICompanyAction();
        PrpDcompanyDto prpdcompanyDto = new PrpDcompanyDto ();
        Collection companyList = new ArrayList();
        //拼查询字符串
        String conditions ="";
        if (user.getComCode().equals("31000000")){
            conditions ="(comType in ('1000001','1000002')) ";
             	
        }else{
//        	20060807   conditions =" upperComCode='"+user.getScheduleComCode()+"' and (comType in ('1000001','1000002'))";
        }
        String comCode=httpServletRequest.getParameter("ComCode"  );
        String comCName=httpServletRequest.getParameter("ComCName"  );
        String validStatus1=httpServletRequest.getParameter("validStatus1"  );
        String validStatus2=httpServletRequest.getParameter("validStatus2"  );
        String comType1=httpServletRequest.getParameter("comType1"  );
        String comType2=httpServletRequest.getParameter("comType2"  );
        String strTemp="";
        
        conditions = conditions + StringConvert.convertString("ComCode",comCode,httpServletRequest.getParameter("ComCodeSign"));
        conditions = conditions + StringConvert.convertString("ComCName",comCName,"ComCNameSign");
       
        
        if (validStatus1!=null||validStatus2!=null)
        {
          if (validStatus1!=null) {
          	strTemp=strTemp+"'1',";
          }
          
         
           if (validStatus2!=null) {
          	strTemp=strTemp+"'0',";
         	
          }
          //去掉最后的一个","
          strTemp = strTemp.substring(0,strTemp.length()-1) ;
          conditions =conditions+ " AND (validStatus in("+strTemp+"))";
          
        }   
        strTemp ="";
        if (comType1!=null||comType2!=null)
        {
          if (comType1!=null) {
          	strTemp=strTemp+"'1000001',";
          }
          
         
           if (comType2!=null) {
          	strTemp=strTemp+"'1000002',";
         	
          }
          //去掉最后的一个","
          strTemp = strTemp.substring(0,strTemp.length()-1) ;
          conditions =conditions+ " AND (comType in("+strTemp+"))";
          
        }   
        //add by lixiang start at 2005-09-29
        //按照机构代码排序 
          conditions =conditions+ " order by comcode";
        //add by lixiang end at 2005-09-29
        System.out.println(conditions);
        companyList=uiCompanyAction.findByConditions( conditions );
//      20060807prpdcompanyDto.setCompanyList( companyList);
        //转换名称
        httpServletRequest.setAttribute ("prpDcompanyDto", prpdcompanyDto);
        
         forward = "querysuccess";
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
