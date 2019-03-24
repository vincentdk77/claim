package com.sinosoft.claim.ui.control.facade;

import java.sql.SQLException;
import java.util.ArrayList;
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
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 实赔查询
 * <p>Title: 车险理赔实赔查询信息</p>
 * <p>Description: 车险理赔实赔实赔查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICompensateQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType   = httpServletRequest.getParameter("editType");//类型
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
    String claimNo   = httpServletRequest.getParameter("ClaimNo");//赔案号 
    String registNo   = httpServletRequest.getParameter("RegistNo");//赔案号    
    String compensateNo   = httpServletRequest.getParameter("CompensateNo") ; //赔款计算书号
    //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间,核赔标志查询条件
    String licenseNo  = httpServletRequest.getParameter("LicenseNo");//车牌号
    String status     = httpServletRequest.getParameter("caseFlag");//案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
    String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//操作时间截止
    String underWriteFlag = httpServletRequest.getParameter("compensateFlag");//核赔标志
    String strDeleteFlag = httpServletRequest.getParameter("deleteFlag");//删除理算书标志
    String arrCheckFlag[]  = httpServletRequest.getParameterValues("CheckFlag");//选中的要删除的理算书的序列号
    String arrCompensateNo[] = httpServletRequest.getParameterValues("CompensateNo");//需要删除的理算书号
    

    //去掉status中最后一个逗号
    if(status!=null&&status.trim().length()>0){
      status=status.substring(0,status.length()-1);
    }
    //去掉compensateFlag中最后一个逗号
    if(underWriteFlag!=null&&underWriteFlag.trim().length()>0){
      underWriteFlag = underWriteFlag.substring(0,underWriteFlag.length()-1);	
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种

//  add by miaowenjun 20060412
	String registNoSign = httpServletRequest.getParameter("RegistNoSign");
	String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
	String licenseNoSign = httpServletRequest.getParameter("LicenseNoSign");
	String operateDateSign = httpServletRequest.getParameter("OperateDateSign");
	String operateDateSignEnd = httpServletRequest.getParameter("OperateDateSignEnd");
	String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
	String compensateNoSign = httpServletRequest.getParameter("CompensateNoSign");
	String insuredName = httpServletRequest.getParameter("InsuredName");
	WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
	workFlowQueryDto.setUnderWriteFlag(underWriteFlag);
	workFlowQueryDto.setCompensateNo(compensateNo);
	workFlowQueryDto.setCompensateNoSign(compensateNoSign);
	workFlowQueryDto.setClaimNo(claimNo);
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
	//add by miaowenjun 20060412
    
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //查询实赔r信息,整理输入，用于初始界面显示
        //add by zhaolu 20060803 start
    	  String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
          String pageNo     = httpServletRequest.getParameter("pageNo");
          if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
    	//add by zhaolu 20060803 end
        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        //modify by zhaolu 20060803 start
        //dAACompensateViewHelper.setPrpLcompensateDtoToView(httpServletRequest,workFlowQueryDto);
        dAACompensateViewHelper.setPrpLcompensateDtoToView(httpServletRequest,workFlowQueryDto,pageNo,recordPerPage);
        //modify by zhaolu 20060803 end

        forward = "success";

      }
      
      if (editType.equals("PRINT")) {
    	 Collection compensateList = new ArrayList();
      	if ( (claimNo==null ||claimNo.equals("") ) && (compensateNo==null || compensateNo.equals("")) ){
      	  String conditions="  registNo='"+registNo+"'";
      	  UIClaimAction  uiClaimAction = new UIClaimAction();
    	  Collection  claimDtoList= uiClaimAction.findByConditions(conditions);
    	  if (claimDtoList!=null &&claimDtoList.size()>0 ) {
    	 	Iterator it = claimDtoList.iterator();
    	 	  while(it.hasNext()){
    	           PrpLclaimDto prpLclaimDto = (PrpLclaimDto)it.next();
    	           claimNo = prpLclaimDto.getClaimNo();
    	           Collection compensateListTemp = new UICompensateAction().findByClaimNo("claimNo = '" + claimNo+ "'");
    	           compensateList.add(compensateListTemp);
    	           }
    	 	}
    	    else {
    	 	  throw new Exception("该案件还未立案！");
    	    }
      	}
       else if ( ! (compensateNo==null || compensateNo.equals(""))){
          UICompensateAction  uiCompensateAction = new  UICompensateAction();
          CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo); 
          claimNo =  compensateDto.getPrpLclaimDto().getClaimNo();
          
       }
      	DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
     	String printType   = httpServletRequest.getParameter("PrintType");//赔案号
     	httpServletRequest.setAttribute("printType", printType);
     	if(compensateList.size() == 0)
    	dAACompensateViewHelper.setPrpLcompensateDtoToPrint(httpServletRequest,
    			claimNo,printType);
    	httpServletRequest.setAttribute("compensateLists",compensateList);
   	    forward = "PRINT";
	}
      //理算书删除
      if ("1".equals(strDeleteFlag)) {
				int size = arrCheckFlag.length;
				BLCompensateFacade facade = new BLCompensateFacade();
				for (int i = 0; i < size; i++) {
					// 判断checkbox选中的理算书号
					if ("Y".equals(arrCheckFlag[i])) {
						facade.deleteCompensateRelation(arrCompensateNo[i]);
					}
				}
				httpServletRequest.setAttribute("content", "理算书删除成功");
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
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
