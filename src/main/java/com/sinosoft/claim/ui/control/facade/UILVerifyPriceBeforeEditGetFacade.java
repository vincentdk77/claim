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
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIPrpLclaimGradeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP GET ��������˼�ǰ��ѯ��������
 * <p>Title: ��������˼�ǰ��ѯ������Ϣ</p>
 * <p>Description: ��������˼�ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyPriceBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {


    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    String claimNo      = "" ;             //�ⰸ��
    String registNo     = "" ;             //������
    HttpSession session = httpServletRequest.getSession();
    UserDto   user      = (UserDto)session.getAttribute("user");    //�û���Ϣ
    String lossType = httpServletRequest.getParameter("lossTypeFlag"); //��������
    String riskCode = httpServletRequest.getParameter("riskCode");                           //����
    String insureCarFlag = httpServletRequest.getParameter("insureCarFlag");      //������־
    String lossItemCode = httpServletRequest.getParameter("lossItemCode");        //����
    String lossItemName = httpServletRequest.getParameter("lossItemName");        //���ƺ���
    String nodeType     = httpServletRequest.getParameter("nodeType");

    String tempStatus = httpServletRequest.getParameter("status"); 
    String swfLogFlowID =(String)httpServletRequest.getParameter("swfLogFlowID");
    String swfLogLogNo =(String)httpServletRequest.getParameter("swfLogLogNo");

    String forward  = "";                                                             //��ǰ
    int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));        //����
    String editForward  = editType;                 //�������ת�ı�־
    try
    {
        System.out.println("=========[ UILVerifyPriceBeforeEditGetFacade ]  [  ��ѯ�˼۽��Ȩ��  ] ====================");
       
	    
        double valueUpper = 0.00;
        if( nodeType.equals("verip")) {   //������ܹ�˾��ֻ�����ί�еĺ˼ۣ�����˼ۣ�����ѯ���ί�еĵ���
         	String comLevel = user.getComLevel();
         }
        
        String  userCode="";
   	    String  configPara ="SINGLE_CUSTOM_COMP_PRICE" ;
   	    String  taskCode="lphj";
        
   	    if ( nodeType.equals("verip") ){
        	userCode=user.getUserCode();  //�˼�ʱ����鱾��Ȩ��
        }
        if(nodeType.equals("verpo")) {   //����ѯ�۽ڵ�ʱ������ύѯ�۵ĺ˼���Ȩ��
        	  SwfLogDto swflogDto  =new SwfLogDto (); 
        	  UIWorkFlowAction  uiWorkFlowAction  =new UIWorkFlowAction();  
        	  swflogDto = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,Integer.parseInt(swfLogLogNo));
        	  userCode = swflogDto.getBeforeHandlerCode();
        }
        	
         	 
         	  UIPrpLclaimGradeAction  uiPrpLclaimGradeAction =new UIPrpLclaimGradeAction();
         	  PrpLclaimGradeDto  prpLclaimGradeDto =  uiPrpLclaimGradeAction.findByPrimaryKey(userCode,taskCode,configPara) ;
             if (prpLclaimGradeDto != null ){
             	valueUpper = prpLclaimGradeDto.getValueUpper();
             }else {
         	    valueUpper =0.00;
             }
        // }
        
         httpServletRequest.setAttribute("valueUpper", String.valueOf(valueUpper) );
         System.out.println("===============  [  ��ѯ�˼۽��Ȩ�� ����   ] ==[ valueUpper ]=====" +valueUpper);  
     	
    	
    	//��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD")) {

        //��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
        registNo = httpServletRequest.getParameter("RegistNo"); //������
        DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
     
        //==================================================
        //����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
        //���û��flowID��logno�򲻽����жϡ�
     String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
        String logNo=httpServletRequest.getParameter("swfLogLogNo");
        String msg="";
        if (flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
        	 if (swfLogDto.getHoldNode()==false)
                   {
                     msg="����'"+registNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,��ѡ�������������д���!";
                     throw new UserException(1,3,"������",msg);
                  }
      }
    //==================================================

        dAAVerifyLossViewHelper.certainLossDtoToView(httpServletRequest,registNo,editType);
        forward = editType+riskCode;
      }
      if(editType.equals("EDIT")||editType.equals("SHOW"))
      {
        //��ѯ�˼���Ϣ,�������룬���ڳ�ʼ������ʾ
        registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //������
        
        DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
        dAAVerifyLossViewHelper.verifyLossDtoView(httpServletRequest,registNo,editType,tempStatus);
        forward = editType+riskCode;
      }
    
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"verip",editType,intLossItemCode);
    
      saveToken(httpServletRequest);
    }
    catch(SecurityException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyPriceBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyPriceBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }

   System.out.println("-----------forward---------"+forward);
    return actionMapping.findForward(forward);
  }
}
