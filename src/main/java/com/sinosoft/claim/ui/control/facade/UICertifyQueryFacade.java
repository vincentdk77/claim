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
import com.sinosoft.claim.ui.control.viewHelper.DAACertifyViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 单证查询
 * <p>Title: 车险理赔单证查询信息</p>
 * <p>Description: 车险理赔单证单证查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICertifyQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    String registNo      = httpServletRequest.getParameter("RegistNo");    //赔案号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
    String status   = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间  

    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    
//  add by miaowenjun 20060412
    String insuredName = httpServletRequest.getParameter("InsuredName");
	String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
	//add by miaowenjun 20060412
    
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        
        //查询单证信息,整理输入，用于初始界面显示
    	//add by zhaolu 20060803 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
          if(pageNo==null) pageNo = "1";
          int intRecordPerPage=Integer.parseInt(recordPerPage) ;
          int intPageNo=Integer.parseInt(pageNo) ;
    	//add by zhaolu 20060803 end
        DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
        //modify by zhaolu 20060803 start
        //dAACertifyViewHelper.setPrpLcertifyDtoToView(httpServletRequest,workFlowQueryDto);
        dAACertifyViewHelper.setPrpLcertifyDtoToView(httpServletRequest,workFlowQueryDto,intPageNo,intRecordPerPage);
        //modify by zhaolu 20060803 end
        forward = "success";
      }   
    }
    catch(UserException usee)
    {
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
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
