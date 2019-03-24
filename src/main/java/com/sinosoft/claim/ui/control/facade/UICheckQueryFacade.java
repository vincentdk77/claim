package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
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

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 查勘查询
 * <p>Title: 车险理赔查勘查询信息</p>
 * <p>Description: 车险理赔查勘查勘查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICheckQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
	String policyNo = httpServletRequest.getParameter("PolicyNo"); //保单号
    String editType   = httpServletRequest.getParameter("editType");//类型
    String claimNo   = httpServletRequest.getParameter("ClaimNo");    //赔案号
    String registNo   = httpServletRequest.getParameter("RegistNo");//报案号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
    String insuredName = httpServletRequest.getParameter("InsuredName");  //被保险人
    String strDeleteFlag = httpServletRequest.getParameter("deleteFlag");//删除理算书标志
    String arrCheckFlag[]  = httpServletRequest.getParameterValues("CheckFlag");//选中的要删除的理算书的序列号
    String arrCompensateNo[] = httpServletRequest.getParameterValues("RegistNo");//需要删除的理算书号
    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种
    
    //add by miaowenjun 20060412
    String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String claimNoSign = httpServletRequest.getParameter("ClaimNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setClaimNo(claimNo);
	workFlowQueryDto.setPolicyNo(policyNo);
	workFlowQueryDto.setRegistNo(registNo);
	workFlowQueryDto.setLicenseNo(licenseNo);
	workFlowQueryDto.setStatus(status);
	workFlowQueryDto.setOperateDate(operateDate);
	workFlowQueryDto.setInsuredName(insuredName);
	workFlowQueryDto.setRegistNoSign(registNoSign);
	workFlowQueryDto.setPolicyNoSign(policyNoSign);
	workFlowQueryDto.setClaimNoSign(claimNoSign);
	workFlowQueryDto.setLicenseNoSign(licenseNoSign);
	workFlowQueryDto.setOperateDateSign(operateDateSign);
	workFlowQueryDto.setInsuredNameSign(insuredNameSign);
    //add end by miaowenjun 20060412

    String forward  = "";                                          //向前
    try 
    {
    	DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
      
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //查询查勘信息,整理输入，用于初始界面显示
        //add by zhaolu 20060802 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo = httpServletRequest.getParameter("pageNo");
          if(pageNo == null || pageNo.trim().equals(""))
       	   pageNo = "1";
       //add by zhaolu 20060802 end
        //modify by zhaolu 20060802 start
          dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //modify by zhaolu 20060802 end
       //dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);
       forward = "success";

    }
    
    
     if (editType.equals("DELETE"))
     {
     	
      dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);
      forward = "deleteSuccess";
  	
    }
      if (editType.equals("Certify")) {
        //查询查勘信息,整理输入，用于初始界面显示

        dAACheckViewHelper.setPrpLcheckDtoToView(httpServletRequest,workFlowQueryDto);

        forward = "certifyUpload"; 

      }    
      
      //打印调查报告前,先查出所有的调查号,显示成调查列表. 2005-08-16
      if (editType.equals("PRINT")) {
      	  String comditions = " registNo='" + registNo + "'"; 
      	  UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
      	  Collection prpLacciCheckDtoList = uiAcciCheckAction.findByConditionsAcciCheck(comditions);
      	  httpServletRequest.setAttribute("prpLacciCheckDtoList", prpLacciCheckDtoList); 
      	  forward = "acciCheckList";
      }
      
      //查勘退回
      if ("1".equals(strDeleteFlag)) {
				int size = arrCheckFlag.length;
				BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
				for (int i = 0; i < size; i++) {
					// 判断checkbox选中的报案号
					if ("Y".equals(arrCheckFlag[i])) {
						String conditions = "BusinessNo = '"+arrCompensateNo[i]+"' and NodeNo= 3";
						SwfLogDto swfLogDto = new SwfLogDto();
						Collection tion = facadeSwf.findByConditions(conditions);
					    for (Iterator ite = tion.iterator(); ite.hasNext();){
					    	swfLogDto = (SwfLogDto)ite.next();
					      }
					    facadeSwf.checkFlowID(swfLogDto.getFlowID());
						swfLogDto=facadeSwf.findByPrimaryKey(swfLogDto.getFlowID(), swfLogDto.getLogNo());
						swfLogDto.setNodeStatus("2");
						swfLogDto.setFlowStatus("2");
						swfLogDto.setSubmitTime("");
						facadeSwf.updateStatusReurun(swfLogDto);
					}
				}
				httpServletRequest.setAttribute("content", "查勘退回成功");
				forward = "delete";
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
    return actionMapping.findForward(forward);
  }

}
