package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAPrepayViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 车险理赔预赔前查询保单请求
 * <p>Title: 车险理赔预赔前查询保单信息</p>
 * <p>Description: 车险理赔预赔前查询保单信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILPrepayBeforeEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示

    String editType     = httpServletRequest.getParameter("editType");
    String policyNo     = "" ;
    String registNo     = "" ;
    String claimNo ="";
   // String claimNo = httpServletRequest.getParameter("ClaimNo"); //赔案号
    String editForward  = editType;
    String riskCode = httpServletRequest.getParameter("riskCode");                     //险种
    String forward  = "";                                           //向前
    String  prepayNo ="";
    try
    {
       policyNo = httpServletRequest.getParameter("policyNo"); 
       UIPolicyAction uiPolicyAction = new UIPolicyAction();
       PolicyDto policyDto  =new PolicyDto ();
       policyDto=new  UIPolicyAction().findByPrimaryKey(policyNo);
       ArrayList prpclimitDtoList =policyDto.getPrpClimitDtoList();
       double limitfeeHaveDuty=0.00;
       double limitfeeNoneDuty=0.00;
       
       if(prpclimitDtoList !=null && prpclimitDtoList.size()>0  ){
       	for (Iterator iter = prpclimitDtoList.iterator(); iter.hasNext();) {
       		PrpClimitDto prpclimitDto = (PrpClimitDto) iter.next();
       		if(prpclimitDto.getLimitType().equals("91")){
       		    limitfeeHaveDuty = prpclimitDto.getLimitFee();
       		}
       		if(prpclimitDto.getLimitType().equals("94")){
      		        limitfeeNoneDuty = prpclimitDto.getLimitFee();
      		    }
   		}
       }                                
       httpServletRequest.setAttribute("limitfeeHaveDuty", String.valueOf(limitfeeHaveDuty));
       httpServletRequest.setAttribute("limitfeeNoneDuty",String.valueOf(limitfeeNoneDuty));
       //Reason:增加控制：历次垫付款不能超过无责医疗限额、支付款不能超过有责医疗限额
       UIClaimAction uiClaimAction = new UIClaimAction();
	   String  status = (String)httpServletRequest.getParameter("status");
	   String prpLprepayPrepayNo = (String)httpServletRequest.getParameter("prpLprepayPrepayNo");  
       claimNo = httpServletRequest.getParameter("ClaimNo"); //赔案号
       if(claimNo == null || "".equals(claimNo)){
    	   PrpLprepayDto prpLprepayDto = (new UIPrepayAction().findByPrimaryKey(prpLprepayPrepayNo)).getPrpLprepayDto();
    	   claimNo = prpLprepayDto.getClaimNo();
       }
	   ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
       double sumBeforePrepaidzf = 0.00;
       double sumBeforePrepaiddf = 0.00;
       ArrayList prpLprepayDtoList =claimDto.getPrpLprepayDtoList();
		if ( prpLprepayDtoList !=null && prpLprepayDtoList.size()>0){
			for (Iterator iter = prpLprepayDtoList.iterator(); iter.hasNext();) {
					PrpLprepayDto element = (PrpLprepayDto) iter.next();
					if ("7".equals(element.getCaseType())) {
						if ("2".equals(status)
								&& prpLprepayPrepayNo.equals(element.getPreCompensateNo())) {
						} else {
							sumBeforePrepaidzf += element.getSumPrePaid();
						}
					} else {
						if ("8".equals(element.getCaseType())) {
							if ("2".equals(status)
									&& prpLprepayPrepayNo.equals(element.getPreCompensateNo())) {
							} else {
								sumBeforePrepaiddf += element.getSumPrePaid();
							}
						} else {
						}
					}
				}
		}
		httpServletRequest.setAttribute("sumBeforePrepaidzf", String.valueOf(sumBeforePrepaidzf));
	    httpServletRequest.setAttribute("sumBeforePrepaiddf",String.valueOf(sumBeforePrepaiddf));

    HttpSession session = httpServletRequest.getSession();
    UserDto   user     = (UserDto)session.getAttribute("user");
    //尚未加入type异常处理{}、其它必须参数异常处理{}
    if (editType.equals("ADD")) {
//    	claimNo = httpServletRequest.getParameter("ClaimNo"); //赔案号
    	    registNo = claimDto.getPrpLclaimDto().getRegistNo();
    	    httpServletRequest.setAttribute("registNo", registNo);
          //查询立案信息,整理输入，用于初始界面显示

          //==================================================
          //进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
          //如果没有flowID和logno则不进行判断。
          String flowID =httpServletRequest.getParameter("swfLogFlowID") ;
          String logNo=httpServletRequest.getParameter("swfLogLogNo");
          
          
          //如果configValue =2 intReturn！=1则表示未交费预赔
//          if(configValue.equals("2")&&intReturn!=1){
//        	  ActionMessages messages = new ActionMessages();
//              ActionMessage message = new ActionMessage("prompt.prepay.feeFailure");
//              messages.add(ActionMessages.GLOBAL_MESSAGE, message);
//              saveMessages(httpServletRequest, messages);
//              forward = "success";
//              System.out.println("保费未实收，系统不允许预赔！"+intReturn);
//              return actionMapping.findForward(forward);
//          }
          //*******************************************add end 
         
          if (flowID!=null && logNo!=null)
          {
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
          	SwfLogDto swfLogDto = new SwfLogDto();
          	swfLogDto = uiWorkFlowAction.holdNode(flowID,Integer.parseInt(logNo) ,user.getUserCode() ,user.getUserName() );
          	if (swfLogDto.getHoldNode()==false)
            {
               String msg="案件'"+claimNo+"'已经被代码:'"+swfLogDto.getHandlerCode() +"',名称:'"+swfLogDto.getHandlerName() +"'的用户所占用,请选择其它案件进行处理!";
              throw new UserException(1,3,"工作流",msg);
            }
          }
      //==================================================

          if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
          {
                riskCode=BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
          }
          DAAPrepayViewHelper dAAPrepayViewHelper = new DAAPrepayViewHelper();
          //判断险种
             dAAPrepayViewHelper.claimDtoToView(httpServletRequest,claimNo);
        }

        if (editType.equals("EDIT")||editType.equals("SHOW")) {
          //查询预赔信息,整理输入，用于初始界面显示
          //add by zhaolu 20060902 start
        	registNo = claimDto.getPrpLclaimDto().getRegistNo();
        	httpServletRequest.setAttribute("registNo",registNo);
          //add by zhaoul 20060902 end
        	prepayNo = httpServletRequest.getParameter("prpLprepayPrepayNo"); //赔案号
          DAAPrepayViewHelper dAAPrepayViewHelper = new DAAPrepayViewHelper();
          dAAPrepayViewHelper.prepayDtoToView(httpServletRequest,prepayNo);
           if (riskCode==null||riskCode.length() <1||riskCode.trim().equals(""))
          {
                riskCode=BusinessRuleUtil.getRiskCode(prepayNo,"PrepayNo"); 
          }
        }
        if (editType.equals("Approve")) {
          //查询预赔信息,整理输入，用于初始界面显示
          claimNo = httpServletRequest.getParameter("prpLprepayPrepayNo"); //赔案号
          DAAPrepayViewHelper dAAPrepayViewHelper = new DAAPrepayViewHelper();
          dAAPrepayViewHelper.prepayDtoToView(httpServletRequest,claimNo);
           return actionMapping.findForward(forward );
        }

      //取得forward
      forward=BusinessRuleUtil.getForward(httpServletRequest,riskCode,"prepa",editType,1);
      
      saveToken(httpServletRequest);
    } catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.prepayBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
      } catch(Exception e) {
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.prepayBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    } finally {

    }
     
    System.out.println("##UILPrepayBeforeEditGetFacade  ###forward=" + forward);
    return actionMapping.findForward(forward);
  }
}
