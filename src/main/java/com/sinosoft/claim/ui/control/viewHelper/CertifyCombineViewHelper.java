package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLPrpLclaimStatusFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
/**
 * <p>Title: CertifyViewHelper</p>
 * <p>Description:单证ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */
 public abstract class CertifyCombineViewHelper
 {
   /**
    * 默认构造方法
    */
    public CertifyCombineViewHelper()
    {
    }

   /**
    * 保存单证时单证页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return stepFlag 标志
    * @throws Exception
    */
    public CertifyDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      String[]  prplcombineRegistNo = httpServletRequest.getParameterValues("prplcombineRegistNo");
      String[]  CombinenodeStatus   = httpServletRequest.getParameterValues("CombinenodeStatus");

      CertifyDto certifyDto = new CertifyDto();
      UIRegistAction uiRegistAction = new UIRegistAction();
      PrpLcertifyCollectDto prpLcertifyCollectDto = null;
      PrpLclaimStatusDto prpLclaimStatusDto = null;
      ArrayList prpLcertifyCollectDtoList = new ArrayList();
      ArrayList prpLclaimStatusDtoList = new ArrayList();
      ArrayList prpLclaimStatusDtoupdateList = new ArrayList();
      BLPrpLclaimStatusFacade bLPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
      //取得当前用户信息，写操作员信息到实赔中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      if(prplcombineRegistNo==null){
      }else{
    	  
    	  for (int index = 0; index < prplcombineRegistNo.length; index++) {
    		  //未处理单证
    		  if(CombinenodeStatus[index]!=null&&"0".equals(CombinenodeStatus[index])){
    		  prpLcertifyCollectDto = new PrpLcertifyCollectDto();
    		  RegistDto registDto = uiRegistAction.findByPrimaryKey(prplcombineRegistNo[index]);
    		  prpLcertifyCollectDto.setBusinessNo(prplcombineRegistNo[index]);
    		  prpLcertifyCollectDto.setLossItemCode("1");
  			  prpLcertifyCollectDto.setLossItemName("标的名称");
  			  prpLcertifyCollectDto.setPicCount(0);
  			  prpLcertifyCollectDto.setUploadYear(String.valueOf(new DateTime(DateTime.current().toString()).getYear()));
  			  prpLcertifyCollectDto.setStartDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			  prpLcertifyCollectDto.setStartHour(String.valueOf(DateTime.current().getHour()));
			  prpLcertifyCollectDto.setEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			  prpLcertifyCollectDto.setEndHour(String.valueOf(DateTime.current().getHour()));
			  if (httpServletRequest.getSession().getAttribute("user") == null) {
					prpLcertifyCollectDto.setOperatorCode(registDto.getPrpLregistDto().getHandlerCode());
			  } else {
					prpLcertifyCollectDto.setOperatorCode(user.getUserCode());
			  }
			  prpLcertifyCollectDto.setCaseFlag("0000");
			  prpLcertifyCollectDto.setFlag("");
			  prpLcertifyCollectDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
			  prpLcertifyCollectDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
			  prpLcertifyCollectDto.setContent(httpServletRequest.getParameter("prpLcertifyCollectContent"));
			  prpLcertifyCollectDtoList.add(prpLcertifyCollectDto);
			  /*---------------------状态内容prpLclaimStatus------------------------------------*/
			  prpLclaimStatusDto = new PrpLclaimStatusDto();
			  prpLclaimStatusDto.setStatus("4");
		      prpLclaimStatusDto.setBusinessNo(prpLcertifyCollectDto.getBusinessNo());
		      prpLclaimStatusDto.setPolicyNo(prpLcertifyCollectDto.getPolicyNo());
		      prpLclaimStatusDto.setNodeType("certi");
		      prpLclaimStatusDto.setSerialNo(0);
		      prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(prpLcertifyCollectDto.getBusinessNo(),"RegistNo") );
		      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
		      prpLclaimStatusDto.setInputDate(prpLcertifyCollectDto.getStartDate());
		      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
		      prpLclaimStatusDtoList.add(prpLclaimStatusDto);
    		  }else{
    		  //正在处理单证 
    		   prpLclaimStatusDto = new PrpLclaimStatusDto();	
    		   prpLclaimStatusDto = bLPrpLclaimStatusFacade.findByPrimaryKey(prplcombineRegistNo[index], "certi", 0);  
    		   prpLclaimStatusDto.setStatus("4");
    		   prpLclaimStatusDtoList.add(prpLclaimStatusDto);
    		  }
    	  }
      }
      certifyDto.setPrpLcertifyCollectDtoList(prpLcertifyCollectDtoList);
      certifyDto.setPrpLclaimStatusDtoList(prpLclaimStatusDtoList);
      certifyDto.setNodeType(httpServletRequest.getParameter("nodeType"));
      return certifyDto;
    }

    public abstract void dtoToView(HttpServletRequest httpServletRequest, CertifyDto certifyDto) throws Exception;

 }
