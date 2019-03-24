package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * 分发HTTP Post 大病住院理赔报案编辑界面
 * <p>Title: 大病住院理赔报案编辑界面信息</p>
 * <p>Description: 大病住院理赔报案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author 
 * @version 1.0
 */
public class UIL0807RegistEditPostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
    Exception {

    String forward = ""; //向前流转
    String  registNo ="";

    try {
      UICodeAction uiCodeAction = new UICodeAction();
      registNo = httpServletRequest.getParameter("prpLregistRegistNo");
      
      String createWorkFlowFlag="0";  //是否需要创建工作流，如果第一次保存，需要创建工作流 0 表示不需要， 1表示需要
      
      String registReportorName = httpServletRequest.getParameter("prpLregistReportorName");
      String registLicenseNo = httpServletRequest.getParameter("prpLregistLicenseNo");
      String registReportDate = httpServletRequest.getParameter("prpLregistReportDate");
      String registReportHour = httpServletRequest.getParameter("prpLregistReportHour");
      String registPolicyNo = httpServletRequest.getParameter("prpLregistPolicyNo");
      String riskCode =httpServletRequest.getParameter("prpLregistRiskCode");
      String mainPolicyNo = httpServletRequest.getParameter("mainPolicyNo");
      
      int year = DateTime.current().getYear()  ;
      int nextNodeNo=0;
      UserDto user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String comCode   = user.getComCode() ;
      String policyComCode = httpServletRequest.getParameter("prpLregistComCode");
      String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime()/1000;
        
        if (registNo.length()<1 || registNo== null){ //取报案号码	
           UIBillAction uiBillAction = new UIBillAction();
           String tableName = "prplregist";
           registNo = uiBillAction.getNo(tableName, riskCode, policyComCode, year);
           httpServletRequest.setAttribute("com.sinosoft.registno", registNo);
           httpServletRequest.setAttribute("riskCode",riskCode);
           createWorkFlowFlag="1";
         }
         httpServletRequest.setAttribute("registNo", registNo);
         httpServletRequest.setAttribute("newWorkFlow", createWorkFlowFlag);
        
         RegistDto registDto = new RegistDto();
         PrpLregistDto prpLregistDto = new PrpLregistDto();
	     
         //报案主表
         prpLregistDto.setRegistNo(registNo);
         prpLregistDto.setLFlag("L");
         prpLregistDto.setClassCode(httpServletRequest.getParameter("prpLregistClassCode"));
         prpLregistDto.setRiskCode(httpServletRequest.getParameter("prpLregistRiskCode"));
         prpLregistDto.setPolicyNo(httpServletRequest.getParameter("prpLregistPolicyNo"));
         prpLregistDto.setLanguage("C");
         prpLregistDto.setInsuredCode(httpServletRequest.getParameter("prpLregistInsuredCode"));
         prpLregistDto.setInsuredName(httpServletRequest.getParameter("insuredName"));
         prpLregistDto.setInsuredAddress(httpServletRequest.getParameter("insuredAddress"));
         prpLregistDto.setLicenseNo(httpServletRequest.getParameter("townName"));
         //prpLregistDto.setLicenseColorCode(httpServletRequest.getParameter("prpLregistLicenseColorCode"));
         //prpLregistDto.setCarKindCode(httpServletRequest.getParameter("prpLregistCarKindCode"));
         prpLregistDto.setModelCode(httpServletRequest.getParameter("hospitalName"));
         prpLregistDto.setBrandName(httpServletRequest.getParameter("content"));
         prpLregistDto.setEngineNo(httpServletRequest.getParameter("hospitalItem"));
         prpLregistDto.setFrameNo(httpServletRequest.getParameter("hospitalCode"));
         //prpLregistDto.setRunDistance(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLregistRunDistance"))));
         prpLregistDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("damageDays"))));
         prpLregistDto.setReportDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
         //prpLregistDto.setReportorPhoneNumber(httpServletRequest.getParameter("phoneNumber"));
         //prpLregistDto.setLinkerPostCode(httpServletRequest.getParameter("prpLregistLinkerPostCode"));
         //prpLregistDto.setLinkerAddress(httpServletRequest.getParameter("prpLregistLinkerAddress"));
         prpLregistDto.setReportHour(String.valueOf(DateTime.current().getHour()));
         //prpLregistDto.setReportAddress(httpServletRequest.getParameter("prpLregistReportAddress"));
         //prpLregistDto.setReportorName(httpServletRequest.getParameter("prpLregistReportorName"));
         //prpLregistDto.setReportType(httpServletRequest.getParameter("reportType"));
         prpLregistDto.setPhoneNumber(httpServletRequest.getParameter("phoneNumber"));
         //prpLregistDto.setLinkerName(httpServletRequest.getParameter("prpLregistLinkerName"));
         prpLregistDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("damageStartDate"),DateTime.YEAR_TO_DAY));
         prpLregistDto.setDamageStartHour("0");
         prpLregistDto.setDamageEndDate(new DateTime(httpServletRequest.getParameter("damageEndDate"),DateTime.YEAR_TO_DAY));
         prpLregistDto.setDamageEndHour("24");
         //prpLregistDto.setDamageCode(httpServletRequest.getParameter("prpLregistDamageCode"));
         prpLregistDto.setDamageName(httpServletRequest.getParameter("identifyNumber"));
         //prpLregistDto.setDamageTypeCode(httpServletRequest.getParameter("prpLregistDamageTypeCode"));
         prpLregistDto.setDamageTypeName(httpServletRequest.getParameter("hospitalNumber"));
         prpLregistDto.setFirstSiteFlag("0");
         //prpLregistDto.setAddressCode(httpServletRequest.getParameter("prpLregistAddressCode"));
         //prpLregistDto.setDamageAreaCode(httpServletRequest.getParameter("prpLregistDamageAreaCode"));
         //prpLregistDto.setDamageAreaName(httpServletRequest.getParameter("prpLregistDamageAreaName"));
         //prpLregistDto.setDamageAddressType(httpServletRequest.getParameter("damageAddressType"));
         //prpLregistDto.setDamageAddress(httpServletRequest.getParameter("prpLregistDamageAddress"));
         //prpLregistDto.setDamageAreaPostCode(httpServletRequest.getParameter("prpLregistDamageAreaPostCode"));
         //prpLregistDto.setHandleUnit(httpServletRequest.getParameter("prpLregistHandleUnit"));
         //prpLregistDto.setLossName(httpServletRequest.getParameter("prpLregistLossName"));
         //prpLregistDto.setLossQuantity(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLregistLossQuantity"))));
         //prpLregistDto.setUnit(httpServletRequest.getParameter("prpLregistUnit"));
         prpLregistDto.setEstiCurrency("CNY");
         //prpLregistDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLregistEstimateLoss"))));
         //prpLregistDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLregistEstimateFee"))));
         prpLregistDto.setReceiverName(user.getUserCode());
         prpLregistDto.setHandlerCode(user.getUserCode());
         //prpLregistDto.setHandler1Code(httpServletRequest.getParameter("prpLregistHandler1Code"));
         prpLregistDto.setComCode(httpServletRequest.getParameter("prpLregistComCode"));
         prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
         prpLregistDto.setAcceptFlag("Y");
         prpLregistDto.setRepeatInsureFlag("N");
         //prpLregistDto.setClaimType(httpServletRequest.getParameter("claimType"));
         //prpLregistDto.setCancelDate(new DateTime(httpServletRequest.getParameter("prpLregistCancelDate"),DateTime.YEAR_TO_DAY));
         prpLregistDto.setDealerCode(user.getUserCode());
         prpLregistDto.setRemark(httpServletRequest.getParameter("prpLregistRemark"));
         prpLregistDto.setOperatorCode(user.getUserCode());
         prpLregistDto.setMakeCom("31000000");
         //prpLregistDto.setFlag(httpServletRequest.getParameter("prpLregistFlag"));
         prpLregistDto.setReportFlag("0");
         registDto.setPrpLregistDto(prpLregistDto);
         //住院人员信息表
         PrpLacciPersonDto prpLacciPerson = new PrpLacciPersonDto();
         UIPolicyAction uiPolicyAction = new UIPolicyAction();
         prpLacciPerson.setCertiNo(registNo);
         prpLacciPerson.setCertiType("01");
         prpLacciPerson.setPolicyNo(httpServletRequest.getParameter("prpLregistPolicyNo"));
         prpLacciPerson.setSerialNo(1);
         prpLacciPerson.setFamilyNo(Integer.parseInt("2"));
         prpLacciPerson.setAcciCode("9999999999999999");
         prpLacciPerson.setAcciName(httpServletRequest.getParameter("insuredName"));
         prpLacciPerson.setAge(Integer.parseInt(httpServletRequest.getParameter("age")));
         prpLacciPerson.setSex(httpServletRequest.getParameter("sexCode"));
         prpLacciPerson.setIdentifyNumber(httpServletRequest.getParameter("prpLacciPersonIdentifyNumber"));
         registDto.setPrpLacciPersonDto(prpLacciPerson);
         
         //立案操作状态内容prpLclaimStatus
         PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
         prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
         prpLclaimStatusDto.setBusinessNo(prpLregistDto.getRegistNo());
         prpLclaimStatusDto.setPolicyNo(prpLregistDto.getPolicyNo());
         prpLclaimStatusDto.setNodeType("regis");
         prpLclaimStatusDto.setSerialNo(0);
         prpLclaimStatusDto.setHandlerCode(user.getUserCode());
         prpLclaimStatusDto.setInputDate(prpLregistDto.getInputDate());
         prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
         prpLclaimStatusDto.setRiskCode(prpLregistDto.getRiskCode());
         registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
  
         //工作流的viewHelper整理界面输入
         WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
         SwfLogDto swfLogDtoDealNode = new SwfLogDto();
         if (createWorkFlowFlag.equals("1") )  swfLogDtoDealNode.setCreateFlow(true);
        
         //判断是否受理的状态,如果不受理，设置工作流的参数为工作流程结束状态。
         if (registDto.getPrpLregistDto().getAcceptFlag().equals("N"))  swfLogDtoDealNode.setEndFlag("1");
        
         //设置报案传入工作流的各个状态
         swfLogDtoDealNode.setNodeType("regis");
         swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
         swfLogDtoDealNode.setBusinessNo(registNo);
         swfLogDtoDealNode.setNextBusinessNo(registNo);
         swfLogDtoDealNode.setKeyIn(registNo);
         swfLogDtoDealNode.setKeyOut(registNo);
         swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode() );
         swfLogDtoDealNode.setComCode(policyComCode);
         swfLogDtoDealNode.setPolicyNo(registPolicyNo);
         swfLogDtoDealNode.setRegistNo(registNo);
         swfLogDtoDealNode.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
         swfLogDtoDealNode.setLossItemName(registDto.getPrpLregistDto().getLicenseNo());
         swfLogDtoDealNode.setFlowInTime( registDto.getPrpLregistDto().getFlowInTime().toString());

         //整理工作流的创建/修改/提交的数据
         WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
         UIRegistAction uiRegistAction = new UIRegistAction();
        
         if (workFlowViewHelper.checkDealDto(workFlowDto)){
             uiRegistAction.save(registDto,workFlowDto);
             user.setUserMessage(registNo);
           }else{
             if (workFlowDto.getOperateResult()<0){
               user.setUserMessage("注意:创建工作流流程时，未找到相关工作流模板的设置，请联系系统管理员进行相应配置！！");
             }
             else
             {
             uiRegistAction.save(registDto);
             user.setUserMessage(registNo+";注意:没有发现与工作流流程相关任何数据！！");
             }
           }
         httpServletRequest.getSession().putValue("oldRegistLastAccessedTime",strLastAccessedTime);
         
         String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
         String comCodeTemp = user.getComCode().substring(0,4);

         httpServletRequest.setAttribute("prpLregistDto",registDto.getPrpLregistDto() ) ;
       


      String registSaveMessage = "q"+registNo;
      System.out.println(registSaveMessage);
      ActionMessages messages = new ActionMessages();
      Object obj_msg = registSaveMessage;
      if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.regist.submit"));
      }else
      {
        messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.regist.save"));
      }
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
      saveMessages( httpServletRequest, messages );

      httpServletRequest.setAttribute("registDto",registDto);
      httpServletRequest.setAttribute("policyNo",registPolicyNo);
      httpServletRequest.setAttribute("handleDept",policyComCode);
      String swfLogFlowID = workFlowDto.getUpdateSwfLogDto().getFlowID();
      httpServletRequest.setAttribute("swfLogFlowID",swfLogFlowID);

      forward = "ADD";
     
 
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
       this.putNoback(registNo);
   }

    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
       this.putNoback(registNo);
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
      this.putNoback(registNo);

    }
    finally {

    }

    return actionMapping.findForward(forward);
  }
  
   //add by huangyunzhong 增加出错后放号回归函数 20051208
  public boolean putNoback(String registNo) throws SQLException,Exception{
  	
  	UIBillAction uiBillAction = new UIBillAction();
    String tableName = "prplregist";
    if(uiBillAction.putNo(tableName,registNo)){
    	System.out.println("单号放回成功"+registNo);
      }else{
      	System.out.println("单号放回失败"+registNo);
      }
  	return true;
    }
  //add end by huangyunzhong 20051208
}
