
package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UILdeductCondAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP ʵ��ǰ�õ�������Ӧ�б���ʾ
 * <p>Title: ʵ��ǰ�õ�������Ӧ�б���ʾ</p>
 * <p>Description: ��������ʵ��ǰ�õ�������Ӧ�б���ʾ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author wangli
 * @version 1.0
 */

public class UICompensateBeforeEditList extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String nodeType     = httpServletRequest.getParameter("nodeType");
   // String caseFlag     = httpServletRequest.getParameter("caseFlag");
    String status      = httpServletRequest.getParameter("status");    //�ⰸ��
    HttpSession session = httpServletRequest.getSession();
    String editType= httpServletRequest.getParameter("editType");
    //String editType = "SHOW";
    String claimNo = httpServletRequest.getParameter("ClaimNo");
    String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID");
    String swfLogLogNo  = httpServletRequest.getParameter("swfLogLogNo");
	String riskCode  = httpServletRequest.getParameter("riskCode");
	String businessNo  = httpServletRequest.getParameter("businessNo");
    String policyNo = httpServletRequest.getParameter("policyNo");
    String  modelNo = httpServletRequest.getParameter("modelNo");
    String  caseType = httpServletRequest.getParameter("caseType");//�������ͱ�־
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();
    //String deductCond ="";  //���������� add 20060511
    //������ѡ��-20060418--start-------------------
    String  compensateNo = httpServletRequest.getParameter("CompensateNo");
    String  rechoseFlag = httpServletRequest.getParameter("rechoseFlag"); 
    if ( compensateNo !=null && !compensateNo.equals("")){
    	UICompensateAction  uiCompensateAction = new UICompensateAction();
    	CompensateDto compensateDto =uiCompensateAction.findByPrimaryKey(compensateNo); 
    	PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
    	
    }
     
    if( rechoseFlag!=null && !rechoseFlag.equals("") ){
    	httpServletRequest.setAttribute("rechoseFlag",rechoseFlag);
    	httpServletRequest.setAttribute("compensateNo",compensateNo);
    }
    //������ѡ��-20060418--end------------------------

    String forward  = "";                                          //��ǰ
    try
    {
        //�ж�Ԥ��֧���İ������û�к���ͨ���������Գ�������  add by miaowenjun 20060825
        Collection prepayList = new ArrayList();
        prepayList = new UIPrepayAction().findByConditions(" claimno='"+claimNo+"' and casetype='7'");
        if(prepayList != null && prepayList.size() > 0){
        	for (Iterator iter = prepayList.iterator(); iter.hasNext();) {
    			PrpLprepayDto prpLprepayDto = (PrpLprepayDto) iter.next();
    			if(!"1".equals(prpLprepayDto.getUnderWriteFlag())){
    				String msg = "���ⰸԤ��δͨ�������ܳ������飡";
    		        throw new UserException(1,3,"Ԥ�ⰸ",msg);
    			}
    		}
        }
        //add end by miaowenjun 20060825
        
        httpServletRequest.setAttribute("ClaimNo",claimNo);
        httpServletRequest.setAttribute("swfLogFlowID",swfLogFlowID);
        httpServletRequest.setAttribute("swfLogLogNo",swfLogLogNo);
        httpServletRequest.setAttribute("status",status);
        httpServletRequest.setAttribute("riskCode",riskCode);
        httpServletRequest.setAttribute("editType",editType);
        httpServletRequest.setAttribute("nodeType",nodeType);
        httpServletRequest.setAttribute("businessNo",businessNo);
        
        if(caseType!=null){
        	
        httpServletRequest.setAttribute("caseType",caseType);
        //�����ⰸ��ռ��
     //==================================================
      //����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
      //���û��flowID��logno�򲻽����жϡ�
      
       String flowID =swfLogFlowID ;
        String logNo=swfLogLogNo;
        
   
    if ((caseType.equals("3")||caseType.equals("4"))&&flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
        	 if (swfLogDto.getHoldNode()==false)
                   {
                     String msg="����'"+businessNo+"'�Ѿ�������:'"+swfLogDto.getHandlerCode() +"',����:'"+swfLogDto.getHandlerName() +"'���û���ռ��,��ѡ�������������д���!";
                     throw new UserException(1,3,"������",msg);
                  }
      }
        
        }
        
        
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        dAACompensateViewHelper.setPrpLcompensateByClaimNoDtoToView(httpServletRequest,claimNo);
        
        //��ȡ��������    add by miaowenjun 20060529
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList prpLdeductCondDtoList = new ArrayList(); 
		
		 if ( compensateNo !=null && !compensateNo.equals("")){
		prpLdeductCondDtoList = (ArrayList)UILdeductCondAction.getInstance().findByConditions(compensateNo);
		httpServletRequest.setAttribute("prpLdeductCondDtolist",prpLdeductCondDtoList);
		 }
		List prpDCodeList = (ArrayList)uiCodeAction.getDeductCondition(riskCode);
		httpServletRequest.setAttribute("prpDCodeList",prpDCodeList);
		//add end by miaowenjun 20060529
            

        forward = "success";
    }
    catch(UserException usee)
    {
    	System.out.println();System.out.println("-----------1-----------");System.out.println();
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
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
