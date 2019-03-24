package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: PrepayViewHelper</p>
 * <p>Description:预赔ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0 
 * <br>
 */
 public abstract class PrepayViewHelper
 {
    private int RULE_LENGTH = 70; //rule字段的长度  
   /**
    * 默认构造方法
    */
    public PrepayViewHelper()
    {
    }

   /**
    * 保存预赔时报案页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return prepayDto 报案数据传输数据结构
    * @throws Exception
    */
    public PrepayDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      PrepayDto prepayDto = new PrepayDto();
      /*---------------------预赔主表prpLprepay------------------------------------*/
      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
      prpLprepayDto.setPreCompensateNo((String)httpServletRequest.getAttribute("prpLprepayPreCompensateNo"));
      prpLprepayDto.setClaimNo(httpServletRequest.getParameter("prpLprepayClaimNo"));
      prpLprepayDto.setRiskCode(httpServletRequest.getParameter("prpLprepayRiskCode"));
      prpLprepayDto.setPolicyNo(httpServletRequest.getParameter("prpLprepayPolicyNo"));
      prpLprepayDto.setCurrency(httpServletRequest.getParameter("prpLprepayCurrency"));
      prpLprepayDto.setArrearageTimes(Integer.parseInt(httpServletRequest.getParameter("prpLprepayArrearageTimes")));
      prpLprepayDto.setSumArrearage(Double.parseDouble(httpServletRequest.getParameter("prpLprepaySumArrearage")));
      prpLprepayDto.setSumBeforePrePaid(Double.parseDouble(httpServletRequest.getParameter("prpLprepaySumBeforePrePaid")));
      //prpLprepayDto.setSumBeforePrePaid(Integer.parseInt(httpServletRequest.getParameter("prpLprepaySumBeforePrePaid")));
      prpLprepayDto.setBlockUpTimes(Integer.parseInt(httpServletRequest.getParameter("prpLprepayBlockUpTimes")));
      prpLprepayDto.setSumPrePaid(Double.parseDouble(httpServletRequest.getParameter("prpLprepaySumPrePaid")));
      prpLprepayDto.setSumTotalPrepaid(Double.parseDouble(httpServletRequest.getParameter("prpLprepaySumTotalPrepaid")));
      prpLprepayDto.setComCode(httpServletRequest.getParameter("prpLprepayComCode"));
      prpLprepayDto.setMakeCom(httpServletRequest.getParameter("prpLprepayMakeCom"));
      prpLprepayDto.setHandlerCode(httpServletRequest.getParameter("prpLprepayHandlerCode"));
      prpLprepayDto.setHandler1Code(httpServletRequest.getParameter("prpLprepayHandler1Code"));
      prpLprepayDto.setApproverCode(httpServletRequest.getParameter("prpLprepayApproverCode"));
      prpLprepayDto.setUnderWriteCode(httpServletRequest.getParameter("prpLprepayUnderWriteCode"));
      prpLprepayDto.setUnderWriteName(httpServletRequest.getParameter("prpLprepayUnderWriteName"));
      prpLprepayDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLprepayStatisticsYM")));
      prpLprepayDto.setOperatorCode(httpServletRequest.getParameter("prpLprepayOperatorCode"));
      prpLprepayDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLprepayDto.setUnderWriteFlag(httpServletRequest.getParameter("prpLprepayUnderWriteFlag"));
      prpLprepayDto.setFlag(httpServletRequest.getParameter("prpLprepayFlag"));
      prpLprepayDto.setCaseType(httpServletRequest.getParameter("prpLprepayCaseType") );
      
      //加入险类
       prpLprepayDto.setClassCode(httpServletRequest.getParameter("prpLprepayClassCode"));      
 
      //加到ArrayList中
      
      /*---------------------预赔费用PrpLpreChargeDto--------------------------*/
      ArrayList prpLpreChargeDtoList = new ArrayList();
      double sumPrePaid = 0.0;
      String[] prpLpreChargeSerialNo = httpServletRequest.getParameterValues("prpLpreChargeSerialNo");
      String[] prpLprechargeKindCode = httpServletRequest.getParameterValues("prpLprechargeKindCode");
      String[] prpLprechargeKindName = httpServletRequest.getParameterValues("prpLprechargeKindName");
      String[] prpLprechargeChargeCode = httpServletRequest.getParameterValues("prpLprechargeChargeCode");
      String[] prpLprechargeChargeName = httpServletRequest.getParameterValues("prpLprechargeChargeName");
      String[] prpLprechargeCurrency = httpServletRequest.getParameterValues("prpLprechargeCurrency");
      String[] prpLprechargeChargeReport = httpServletRequest.getParameterValues("prpLprechargeChargeReport");
      for(int i = 1;i < prpLprechargeChargeCode.length;i++){
    	  PrpLpreChargeDto prpLpreChargeDto = new PrpLpreChargeDto();
    	  prpLpreChargeDto.setPreCompensateNo((String)httpServletRequest.getAttribute("prpLprepayPreCompensateNo"));
    	  prpLpreChargeDto.setSerialNo(Integer.parseInt(prpLpreChargeSerialNo[i]));
    	  prpLpreChargeDto.setClaimNo(httpServletRequest.getParameter("prpLprepayClaimNo"));
    	  prpLpreChargeDto.setRiskCode(httpServletRequest.getParameter("prpLprepayRiskCode"));
    	  prpLpreChargeDto.setPolicyNo(httpServletRequest.getParameter("prpLprepayPolicyNo"));
    	  prpLpreChargeDto.setKindCode(prpLprechargeKindCode[i]);
    	  prpLpreChargeDto.setChargeCode(prpLprechargeChargeCode[i]);
    	  prpLpreChargeDto.setChargeEName(prpLprechargeChargeName[i]);
    	  prpLpreChargeDto.setCurrenCY(prpLprechargeCurrency[i]);
    	  prpLpreChargeDto.setSumPrepaid(Double.parseDouble(prpLprechargeChargeReport[i]));
    	  sumPrePaid += Double.parseDouble(prpLprechargeChargeReport[i]);
    	  prpLpreChargeDtoList.add(prpLpreChargeDto);
      }
      prpLprepayDto.setSumPreChargePaid(sumPrePaid);
      prepayDto.setPrpLprepayDto(prpLprepayDto);
      prepayDto.setPrpLpreChargeDtoList(prpLpreChargeDtoList);
      /*---------------------预赔文本表PrpLptextDto------------------------------------*/
      ArrayList prpLptextDtoList = new ArrayList();
      String TextTemp = httpServletRequest.getParameter("prpLptextContextInnerHTML");
      String[] rules = StringUtils.split(TextTemp,RULE_LENGTH);
      //得到连接串,下面将其切分到数组
      for(int k=0;k<rules.length;k++){
        PrpLptextDto prpLptextDto = new PrpLptextDto();
        prpLptextDto.setPreCompensateNo((String) httpServletRequest.getAttribute("prpLprepayPreCompensateNo"));
        prpLptextDto.setContext(rules[k]);
        prpLptextDto.setLineNo(k+1);
        prpLptextDtoList.add(prpLptextDto);
      }
        
      //prepayDto
      prepayDto.setPrpLptextDtoList(prpLptextDtoList);

      /*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(prpLprepayDto.getPreCompensateNo() );
      prpLclaimStatusDto.setPolicyNo(prpLprepayDto.getPolicyNo());

      prpLclaimStatusDto.setTypeFlag("5");
      prpLclaimStatusDto.setNodeType("speci");
      prpLclaimStatusDto.setSerialNo(5);

      prpLclaimStatusDto.setRiskCode(httpServletRequest.getParameter("prpLprepayRiskCode"));
      //prpLclaimStatusDto.setSerialNo(0);
      //取得当前用户信息，写操作员信息到实赔中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      //prpLclaimStatusDto.setHandlerCode(prpLprepayDto.getOperatorCode() );
      prpLclaimStatusDto.setInputDate(prpLprepayDto.getInputDate() );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prepayDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

      PrpLclaimDto prpLclaimDto = null;
      Object buttonStatus = httpServletRequest.getParameter("buttonSaveType");
      if(buttonStatus!=null&&buttonStatus.toString().trim().equals("4")){
        prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimNo(httpServletRequest.getParameter("prpLprepayClaimNo"));
        prpLclaimDto.setSumPaid(Double.parseDouble(httpServletRequest.getParameter("prpLprepaySumPrePaid")));
      }
      prepayDto.setPrpLclaimDto(prpLclaimDto);
      return prepayDto;
    }

   /**
    * 取初始化信息需要的数据的整理.
    * 填写报案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */
   public abstract PrepayDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * 填写报案页面及查询报案request的生成.
    * 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param prepayDto 取出的初始化信息Dto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, PrepayDto prepayDto) throws Exception;

 }
