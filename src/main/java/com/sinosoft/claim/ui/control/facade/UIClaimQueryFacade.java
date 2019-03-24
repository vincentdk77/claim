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

import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 立案查询
 * <p>Title: 车险理赔立案查询信息</p>
 * <p>Description: 车险理赔立案立案查询信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIClaimQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示

    String editType   = httpServletRequest.getParameter("editType");
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
    String claimNo   = httpServletRequest.getParameter("ClaimNo") ; //赔案号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
    String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//操作时间截止

    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    
    //add by miaowenjun 20060412
    String insuredName = httpServletRequest.getParameter("InsuredName");
    String registNo = httpServletRequest.getParameter("RegistNo");
    String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setOperateDateEnd(operateDateEnd);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setOperateDateSignEnd(operateDateSignEnd);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
	//add by lixiang start at 20060830
	//reason:立案查询，丢失立案号这个重要的内容的查询
    //add by lixiang end at 20060830
	workFlowQueryDto.setClaimNo( httpServletRequest.getParameter("ClaimNo"));
	workFlowQueryDto.setClaimNoSign(httpServletRequest.getParameter("ClaimNoSign"));
	
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
    //add by miaowenjun 20060412
    
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种
 
    String forward  = "";                                          //向前
    try
    {
		String isFirst		= httpServletRequest.getParameter("isFirst"); //是否第一次进来，第一次进来不查询结果
		
		//第一次进来，标志为空的，所以对其进行初始化；第二次进来，取的是页面的值，所以不为空，不用处理
		if(isFirst == null || "".equals(isFirst)){
			isFirst = "Y";
		}
		httpServletRequest.setAttribute("isFirst", isFirst);
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW"))
      {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        //add by zhaolu 20060802 start
    	//reason:翻页处理
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
          if(pageNo==null||pageNo.trim().equals(""))
        	  pageNo = "1"; 
    	//add by zhaolu 20060802 end
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.setPrpLclaimDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //dAAClaimViewHelper.setPrpLclaimDtoToView(httpServletRequest,workFlowQueryDto);
		//add by zhouliu start at 2006-6-9
        if (editType.equals("SHOW"))
        {
        	httpServletRequest.setAttribute("type","SHOW");
        }
        forward = "success";
		//add by zhouliu end at 2006-6-9
      }
      //已超时的报案
      if (editType.equals("TimeOut"))
      {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.registTimeOut(httpServletRequest);
        forward = "timeOut";
      }      
      if (editType.equals("claimTimeOut"))
      {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
        dAAClaimViewHelper.claimTimeOut(httpServletRequest);
        forward = "claimTimeOut";
      }            
      //特殊赔案
      if (editType.equals("SpecialCase"))
      {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper(); 
        dAAClaimViewHelper.getSpecialList(httpServletRequest,claimNo,policyNo);
        forward = "SpecialCase"; 
 
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
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
