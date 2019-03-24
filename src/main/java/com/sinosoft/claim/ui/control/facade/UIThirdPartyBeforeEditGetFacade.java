
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
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.ThirdPartyViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET �������������������ǰ��ѯ��������
 * <p>Title: �������������������ǰ��ѯ������Ϣ</p>
 * <p>Description: �������������������ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli  
 * @version 1.0 
 */

public class UIThirdPartyBeforeEditGetFacade extends Action
	{
	  public ActionForward execute(ActionMapping actionMapping,
	                               ActionForm actionForm,
	                               HttpServletRequest httpServletRequest,
	                               HttpServletResponse httpServletResponse)
	    throws Exception
	  {
	     
	    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ

	    String editType     = httpServletRequest.getParameter("editType");
	    String editForward  = editType;                 //�������ת�ı�־
	 //   String claimNo     = "" ;
	    String businessNo     = "" ;
	 //   String checkNo     = "" ;
	    HttpSession session = httpServletRequest.getSession();
	    UserDto   user     = (UserDto)session.getAttribute("user");
	   // String riskCode = httpServletRequest.getParameter("riskCode");                 //����
	    String forward  = "";                                          //��ǰ
	    try
	    {

          //modify by wangli add start 20050412
	      if(editType.equals("ADDSHOW"))
	      {
          businessNo = httpServletRequest.getParameter("businessNo");
          ThirdPartyViewHelper thirdPartyViewHelper = new ThirdPartyViewHelper();
          UICodeAction uiCodeAction = new UICodeAction();
          String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");	 
          //����ǲ��ǿ��Խ������Ӷ�����ȵģ����� Ŀǰֻ������״̬Ϊ4�ģ��ǲ��ǵ���Ҳ�����ˣ���
           String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
           String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
           String nodeStatus=httpServletRequest.getParameter("nodeStatus"); //������״̬
           
           if (nodeStatus.equals("4")){ //��Ҫ��鵥compe??�Ƿ���ڣ�
           	   String condition ="flowid='"+swfLogFlowID +"' AND nodeType='compe' and nodeStatus<'4'";
           	   UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
               int retCount= uiWorkFlowAction.findFlowNodeCountByConditon( condition);
               if (retCount>0){
                String msg="����'"+businessNo+"'�Ѿ��������㻷�ڣ����ܽ��ж�����ȱ�ĵ�����,��ѡ�������������д���!";
                throw new UserException(1,3,"������",msg);
      
               }
          }      
          
          //add by liyanjie 2005-12-17 start ����˫������,ֻ�г��յص��Ȳ�����������
          /*
           PrpLregistDto prpLregistDto = (new BLPrpLregistFacade()).findByPrimaryKey(businessNo); 
          if((prpLregistDto.getCommiFlag()!=null) && "1".equals(prpLregistDto.getCommiFlag())){
          	//System.out.println("===== ��˫��");
          	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            Collection curNodes = uiWorkFlowAction.findCurrentNode(swfLogFlowID,Integer.parseInt(swfLogLogNo));
            SwfLogDto swfLogDto = null; 
  		    if (curNodes.iterator().hasNext()) {
              //��õ�ǰ��������ڵ���Ϣ
              swfLogDto = (SwfLogDto) curNodes.iterator().next();
              if(  (swfLogDto.getCommiFlag()==null || swfLogDto.getCommiFlag().equals("")) && "4".equals(swfLogDto.getNodeStatus())  ||
  			     (swfLogDto.getCommiFlag()!=null) &&  "2".equals(swfLogDto.getCommiFlag()) ){
              	  String msg="����'"+businessNo+"'��˫������,ֻ���ɳ��յع�˾������Ա����������ȣ��б��ع�˾���Ȳ��ܽ�����������,��ѡ�������������д���!";
                  throw new UserException(1,3,"˫������",msg);
              }else{
              	httpServletRequest.setAttribute("commiFlag",swfLogDto.getCommiFlag());   //��������,��߱���ʱ���ж�,˫��������������ָ����յع�˾
              }
  		    }          
          }
          */
          //add by liyanjie 2005-12-17 end
          
          thirdPartyViewHelper.registDtoToView(httpServletRequest,businessNo,strRiskCode);
       
	        forward = "ADDSHOW";
	       }
	      //modify by wangli add end 20050412 
	      if(!editType.equals("ADDSHOW")){
	        saveToken(httpServletRequest);
	      }  
	    }
	    catch(UserException usee)
	     {
	       usee.printStackTrace() ;
	       //������Ϣ����
	       ActionErrors errors = new ActionErrors();
	       ActionError error = new ActionError("title.registBeforeEdit.editRegist");
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
	      ActionError error = new ActionError("title.registBeforeEdit.titleName");
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

