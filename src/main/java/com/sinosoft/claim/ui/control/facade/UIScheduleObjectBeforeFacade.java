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
 * �ַ�HTTP GET ������Ƚڵ�ĸ�������
 * <p>Title: ������Ƚڵ���µĸ�������</p>
 * <p>Description: ������Ƚڵ�ĸ�������</p>
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
         	 msg="���û�û�п������õ������������Ļ�����";
             throw new UserException(1,3,"������������",msg);
 
         }
        
         //������ܹ�˾��Ա������������ӵ�
         String strSelectNewCode=httpServletRequest.getParameter("comCode");
         
                   
       if(editType.equals("ADD"))
        {
        UICompanyAction uiCompanyAction = new UICompanyAction();
        PrpDcompanyDto prpdcompanyDto = new PrpDcompanyDto ();
        PrpDcompanyDto prpdcompanyCenterDto = new PrpDcompanyDto ();
        prpdcompanyCenterDto = uiCompanyAction.findByPrimaryKey(strScheduleComCode );
        
        if (prpdcompanyCenterDto==null){
        	 msg="���û�û�п������õ������������Ļ�����";
             throw new UserException(1,3,"������������",msg);
       }
              
           String comName = prpdcompanyCenterDto.getComCName() ;
           prpdcompanyDto.setUpperComCode( strScheduleComCode);
           
           
           
           prpdcompanyDto.setOuterPayCode( strScheduleComCode );
           prpdcompanyDto.setInnerPayCode(  strScheduleComCode );
           prpdcompanyDto.setInsurerName( comName);
           prpdcompanyDto.setComCode( strScheduleComCode.substring(0,4 )+"9");
           prpdcompanyDto.setValidStatus( "1");
           //����level
          String newLevel=(Integer.parseInt(DataUtils.nullToZero(prpdcompanyCenterDto.getComLevel()))+1)+"";
          prpdcompanyDto.setComLevel("7"); //����ʱд����7��
          prpdcompanyDto.setComType( "1000001");
           
           ScheduleObjectDto scheduleObjectDto =new ScheduleObjectDto();
           scheduleObjectDto.setEditType( "ADD");
           httpServletRequest.setAttribute ("prpDcompanyDto", prpdcompanyDto);
           httpServletRequest.setAttribute ("scheduleObjectDto", scheduleObjectDto);
           
           //������Ϊ�������ĵ����ݲ�ѯ����������
           //������Ϊ�������ĵ����ݲ�ѯ����������
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
            //������Ϊ�������ĵ����ݲ�ѯ����������
            UICompanyAction uiCompanyAction = new UICompanyAction();
            
            //������Ϊ�������ĵ����ݲ�ѯ����������
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
              	  msg="û�в�ѯ���û�������Ϣ";
                 throw new UserException(1,3,"������������",msg);
         
             }
           
           //ת������
         
          forward = "success";
        }
       
       if(editType.equals("QUERY"))
       {
       	UICompanyAction uiCompanyAction = new UICompanyAction();
        PrpDcompanyDto prpdcompanyDto = new PrpDcompanyDto ();
        Collection companyList = new ArrayList();
        //ƴ��ѯ�ַ���
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
          //ȥ������һ��","
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
          //ȥ������һ��","
          strTemp = strTemp.substring(0,strTemp.length()-1) ;
          conditions =conditions+ " AND (comType in("+strTemp+"))";
          
        }   
        //add by lixiang start at 2005-09-29
        //���ջ����������� 
          conditions =conditions+ " order by comcode";
        //add by lixiang end at 2005-09-29
        System.out.println(conditions);
        companyList=uiCompanyAction.findByConditions( conditions );
//      20060807prpdcompanyDto.setCompanyList( companyList);
        //ת������
        httpServletRequest.setAttribute ("prpDcompanyDto", prpdcompanyDto);
        
         forward = "querysuccess";
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
