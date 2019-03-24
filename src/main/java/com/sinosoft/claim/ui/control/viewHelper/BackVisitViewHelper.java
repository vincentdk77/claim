package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.ui.control.action.UIBackVisitAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: DAABackVisitViewHelper</p>
 * <p>Description:回访ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2005</p>
 * @author 车险理赔项目组
 * @version 1.0
 * <br>
 */

 public abstract class BackVisitViewHelper
 {
    /**
    * 默认构造方法
    */
    public BackVisitViewHelper()
    {
    }
    
    /**
    * 保存回访页面数据整理
    * @param httpServletRequest
    * @return BackVisitDto
    * @throws Exception
    */
    public BackVisitDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    { 
      //定义BackVisitDto对象
      BackVisitDto backVisitDto = new BackVisitDto();
      
      //从页面获取业务类型
      String strBackVisitType =  StringUtils.rightTrim(httpServletRequest.getParameter("backVisitType"));
      
      //取得回访登记号
      //1为查勘回访，2为定损回访
      String strConditions  = "";
      strConditions = "BackVisitType = '"+strBackVisitType+"'";
      UIBackVisitAction uiBackVisitAction = new UIBackVisitAction();
      
      //int intBackVisitID = uiBackVisitAction.getMaxNo(strConditions);
      int intBackVisitID = 1;//应该是对每个报案号码增加的(暂时的处理方式)
      
      //取用户信息
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String strComCode  = user.getComCode() ;
      String strUserCode = user.getUserCode();
      String strUserName = user.getUserName();
      
      //整理回访主表信息开始
      PrpLbackVisitDto prpLbackVisitDto = new PrpLbackVisitDto();
      prpLbackVisitDto.setBackVisitID(intBackVisitID);
      prpLbackVisitDto.setRegistNo(httpServletRequest.getParameter("prpLbackVisitRegistNo"));
      prpLbackVisitDto.setPolicyNo(httpServletRequest.getParameter("prpLbackVisitPolicyNo"));
      prpLbackVisitDto.setLicenseNo(httpServletRequest.getParameter("prpLbackVisitLicenseNo"));
      prpLbackVisitDto.setInsuredCode(httpServletRequest.getParameter("prpLbackVisitInsuredCode"));
      prpLbackVisitDto.setInsuredName(httpServletRequest.getParameter("prpLbackVisitInsuredName"));
      prpLbackVisitDto.setCustomType("");//暂时不实现
      prpLbackVisitDto.setPhone(httpServletRequest.getParameter("prpLbackVisitPhone"));
      prpLbackVisitDto.setFax(httpServletRequest.getParameter("prpLbackVisitFax"));
      prpLbackVisitDto.setPostCode(httpServletRequest.getParameter("prpLbackVisitPostCode"));
      prpLbackVisitDto.setEmail(httpServletRequest.getParameter("prpLbackVisitEmail"));
      prpLbackVisitDto.setAddress(httpServletRequest.getParameter("prpLbackVisitAddress"));
      prpLbackVisitDto.setBackVisitType(httpServletRequest.getParameter("backVisitType"));
      prpLbackVisitDto.setHandlerCode(httpServletRequest.getParameter("strUserCode"));
      prpLbackVisitDto.setHandlerName(httpServletRequest.getParameter("strUserName"));
      prpLbackVisitDto.setHandleDept(httpServletRequest.getParameter("strComCode"));
      prpLbackVisitDto.setBackVisitTime(httpServletRequest.getParameter("prpLbackVisitBackVisitTime"));
      prpLbackVisitDto.setCustomOpinion(httpServletRequest.getParameter("customOpinion"));
      prpLbackVisitDto.setDeliverDepart("");//暂时不实现
      prpLbackVisitDto.setDeliverTime("");//暂时不实现
      prpLbackVisitDto.setDeliverPerson("");//暂时不实现
      prpLbackVisitDto.setDeliverBackTime("");//暂时不实现
      prpLbackVisitDto.setBackCustomTime("");//暂时不实现
      prpLbackVisitDto.setHurryFlag("");  //暂时不实现
      prpLbackVisitDto.setStatus("1"); //1暂定为新回访，应从页面取值
      prpLbackVisitDto.setFlag("");
      prpLbackVisitDto.setLinkerName(httpServletRequest.getParameter("prpLbackLinkerName"));
      
      //加到ArrayList中
      backVisitDto.setPrpLbackVisitDto(prpLbackVisitDto);
      //整理回访主表信息结束
      
      /*---------------------回访操作状态内容prpLclaimStatus----开始-------*/
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(prpLbackVisitDto.getRegistNo() );
      prpLclaimStatusDto.setPolicyNo(prpLbackVisitDto.getPolicyNo());
      prpLclaimStatusDto.setNodeType("backv");
      prpLclaimStatusDto.setSerialNo(Integer.parseInt(prpLbackVisitDto.getBackVisitType()) );
      prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(prpLbackVisitDto.getRegistNo(),"RegistNo"));
      //取得当前用户信息，写操作员信息到实赔中
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      //prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
      prpLclaimStatusDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      backVisitDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      /*---------------------回访操作状态内容prpLclaimStatus----结束-------*/
      
      return backVisitDto;
    }
 }
