package com.sinosoft.claim.query.ui.control.facade;

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
import com.sinosoft.claim.query.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 工作流报案查询
 * <p>Title: 车险理赔报案查询信息</p>
 * <p>Description: 车险理赔报案报案查询信息用于工作流流程显示</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 

public class UIWorkFlowFlowQueryFacadeRead  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType   = httpServletRequest.getParameter("editType");
    String caseType   = httpServletRequest.getParameter("caseType");
    String pageFlag   = httpServletRequest.getParameter("pageFlag");
    String policyNo   = httpServletRequest.getParameter("prpLregistPolicyNo");    //保单号
    String registNo   = httpServletRequest.getParameter("prpLregistRegistNo") ; //报案号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
    String licenseNo  = httpServletRequest.getParameter("prpLregistLicenseNo");//车牌号
    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("operateDate");//操作时间
    String riskCode     = httpServletRequest.getParameter("prpLregistRiskCode") ;  //险种代码
    String insuredName  = httpServletRequest.getParameter("prpLregistInsuredName");//被保险人姓名
    String riskCodeName = httpServletRequest.getParameter("prpLregistRiskCodeName");
    String riskCodeNameSign = httpServletRequest.getParameter("RiskCodeNameSign");
    String registFlowinTime = httpServletRequest.getParameter("prpLregistFlowinTime");
    String riskCategory = httpServletRequest.getParameter("riskCategory");
    WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
    workFlowQueryDto.setCaseType(caseType);
    workFlowQueryDto.setInsuredName(insuredName);
   	workFlowQueryDto.setLicenseNo(licenseNo);
   	workFlowQueryDto.setPolicyNo(policyNo);
   	workFlowQueryDto.setRegistNo(registNo);
   	workFlowQueryDto.setRiskCode(riskCode);
   	workFlowQueryDto.setRiskCodeName(riskCodeName );
   	workFlowQueryDto.setRiskCodeNameSign(riskCodeNameSign );
   	workFlowQueryDto.setRegistFlowinTime(registFlowinTime);
   	workFlowQueryDto.setRiskCategory(riskCategory);
    //add end by miaowenjun 20060411  
    
    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    
    //added by zhangli 20070424    
    session.setAttribute("compensatePolicyNo", policyNo);
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
    	 if (editType.equals("ADD") || editType.equals("SHOW")) {
            //查询理赔节点状态信息,整理输入，用于初始界面显示

            //每页显示的行数
            String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
            String pageNo     = httpServletRequest.getParameter("pageNo");    
            if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
            DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
            dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,registNo,policyNo,licenseNo,status,operateDate,riskCode,insuredName,pageNo,recordPerPage);
            forward = "success";

         }
    	 
    	 if (editType.equals("RegistBeforeQuery")) {
    	 	editType = "WorkFlow";
    	 }
    	 
          if (editType.equals("WorkFlow")||editType.equals("EDIT")) { 
            //每页显示的行数
            String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
            String pageNo     = httpServletRequest.getParameter("pageNo");
            //
            int intPageNo=0;
            int intrecord =Integer.parseInt(recordPerPage);
            if(pageNo==null||pageNo.trim().equals("")) {
            	intPageNo = 1;
            }else{
            	intPageNo=Integer.parseInt(pageNo);
            }
            //查询理赔节点状态信息,整理输入，用于初始界面显示 
            WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();            
            workFlowViewHelper.getWorkFlowList(httpServletRequest,registNo,policyNo,licenseNo,riskCode,insuredName,intPageNo,intrecord);
            httpServletRequest.setAttribute("workFlowQueryDto",workFlowQueryDto);
            forward = "success"; 
          }    
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
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
