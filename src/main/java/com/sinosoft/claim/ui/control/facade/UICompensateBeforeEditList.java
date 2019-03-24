
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
 * 分发HTTP 实赔前得到立案对应列表及显示
 * <p>Title: 实赔前得到立案对应列表及显示</p>
 * <p>Description: 车险理赔实赔前得到立案对应列表及显示信息系统样本程序</p>
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
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String nodeType     = httpServletRequest.getParameter("nodeType");
   // String caseFlag     = httpServletRequest.getParameter("caseFlag");
    String status      = httpServletRequest.getParameter("status");    //赔案号
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
    String  caseType = httpServletRequest.getParameter("caseType");//案件类型标志
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();
    //String deductCond ="";  //免赔条件串 add 20060511
    //免赔率选择-20060418--start-------------------
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
    //免赔率选择-20060418--end------------------------

    String forward  = "";                                          //向前
    try
    {
        //判断预，支付的案件如果没有核赔通过，不可以出计算书  add by miaowenjun 20060825
        Collection prepayList = new ArrayList();
        prepayList = new UIPrepayAction().findByConditions(" claimno='"+claimNo+"' and casetype='7'");
        if(prepayList != null && prepayList.size() > 0){
        	for (Iterator iter = prepayList.iterator(); iter.hasNext();) {
    			PrpLprepayDto prpLprepayDto = (PrpLprepayDto) iter.next();
    			if(!"1".equals(prpLprepayDto.getUnderWriteFlag())){
    				String msg = "此赔案预赔未通过，不能出计算书！";
    		        throw new UserException(1,3,"预赔案",msg);
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
        //特殊赔案的占号
     //==================================================
      //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
      //如果没有flowID和logno则不进行判断。
      
       String flowID =swfLogFlowID ;
        String logNo=swfLogLogNo;
        
   
    if ((caseType.equals("3")||caseType.equals("4"))&&flowID!=null && logNo!=null)
        {  UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	 SwfLogDto swfLogDto = new SwfLogDto();
        	 swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
        	 if (swfLogDto.getHoldNode()==false)
                   {
                     String msg="案件'"+businessNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件进行处理!";
                     throw new UserException(1,3,"工作流",msg);
                  }
      }
        
        }
        
        
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        dAACompensateViewHelper.setPrpLcompensateByClaimNoDtoToView(httpServletRequest,claimNo);
        
        //获取免赔条件    add by miaowenjun 20060529
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
      //错误信息处理
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
