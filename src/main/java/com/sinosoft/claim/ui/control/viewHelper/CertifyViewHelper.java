package com.sinosoft.claim.ui.control.viewHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
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
 public abstract class CertifyViewHelper
 {
   /**
    * 默认构造方法
    */
    public CertifyViewHelper()
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
System.out.println("-------viewToDto----1------CertifyDto----"+httpServletRequest.getParameter("prpLcertifyCollectBusinessNo"));
      CertifyDto certifyDto = new CertifyDto();
      PrpLcertifyCollectDto prpLcertifyCollectDto = new PrpLcertifyCollectDto();
      prpLcertifyCollectDto.setBusinessNo(httpServletRequest.getParameter("prpLcertifyCollectBusinessNo"));
      prpLcertifyCollectDto.setLossItemCode(httpServletRequest.getParameter("prpLcertifyCollectLossItemCode"));
      prpLcertifyCollectDto.setLossItemName(httpServletRequest.getParameter("prpLcertifyCollectLossItemName"));
      //?
      prpLcertifyCollectDto.setPicCount(0);
      prpLcertifyCollectDto.setStartDate(new DateTime(httpServletRequest.getParameter("prpLcertifyCollectStartDate"),DateTime.YEAR_TO_DAY));
      prpLcertifyCollectDto.setStartHour(httpServletRequest.getParameter("prpLcertifyCollectStartHour"));
      prpLcertifyCollectDto.setEndDate(new DateTime(httpServletRequest.getParameter("prpLcertifyCollectEndDate"),DateTime.YEAR_TO_DAY) );
      prpLcertifyCollectDto.setEndHour(httpServletRequest.getParameter("prpLcertifyCollectEndHour"));
      prpLcertifyCollectDto.setOperatorCode(httpServletRequest.getParameter("prpLcertifyCollectOperatorCode"));
      prpLcertifyCollectDto.setCaseFlag(httpServletRequest.getParameter("prpLcertifyCollectCaseFlag"));
      prpLcertifyCollectDto.setFlag(httpServletRequest.getParameter("prpLcertifyCollectFlag"));
      prpLcertifyCollectDto.setUploadYear(httpServletRequest.getParameter("prpLcertifyCollectUploadYear"));
      prpLcertifyCollectDto.setRiskCode(httpServletRequest.getParameter("prpLcertifyCollectRiskCode")); 


      int cltThirdCarCount = Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("cltThirdCarCount")));
      String cltThirdCarFlag = "";
      String cltThirdCarFlagTemp = "";
      for (int i2 = 1; i2 < cltThirdCarCount; i2++) {
          cltThirdCarFlag = cltThirdCarFlag+httpServletRequest.getParameter("cltThirdCarFlag"+i2);
      }
      prpLcertifyCollectDto.setCltThirdCarFlag(cltThirdCarFlag.trim());
System.out.println("----------三者车的收集标志--------"+cltThirdCarFlag+"==-----cltThirdCarCount--------"+cltThirdCarCount+"-----2--"+httpServletRequest.getParameter("cltThirdCarFlag1"));

      prpLcertifyCollectDto.setCltInsureCarFlag   (httpServletRequest.getParameter("cltInsureCarFlag"));
      prpLcertifyCollectDto.setCltPersonFlag   (httpServletRequest.getParameter("cltPersonFlag"));
      prpLcertifyCollectDto.setCltPropFlag   (httpServletRequest.getParameter("cltPropFlag"));
      prpLcertifyCollectDto.setCltCarLossFlag   (httpServletRequest.getParameter("cltCarLossFlag"));
      prpLcertifyCollectDto.setCltAllLossFlag   (httpServletRequest.getParameter("cltAllLossFlag"));
      prpLcertifyCollectDto.setPolicyNo   (httpServletRequest.getParameter("prpLcertifyCollectPolicyNo"));
      prpLcertifyCollectDto.setCollectFlag(httpServletRequest.getParameter("collectFlag"));
      prpLcertifyCollectDto.setContent(httpServletRequest.getParameter("prpLcertifyCollectContent"));

      certifyDto.setPrpLcertifyCollectDto(prpLcertifyCollectDto);
System.out.println("-----businessNo---"+certifyDto.getPrpLcertifyCollectDto().getBusinessNo());
      /*---------------------状态内容prpLclaimStatus------------------------------------*/
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(prpLcertifyCollectDto.getBusinessNo());
      prpLclaimStatusDto.setPolicyNo(prpLcertifyCollectDto.getPolicyNo());
      prpLclaimStatusDto.setNodeType("certi");
      prpLclaimStatusDto.setSerialNo(0);
      prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(prpLcertifyCollectDto.getBusinessNo(),"RegistNo") );
      //取得当前用户信息，写操作员信息到实赔中
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      //prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
      prpLclaimStatusDto.setInputDate(prpLcertifyCollectDto.getStartDate());
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      certifyDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      certifyDto.setNodeType(httpServletRequest.getParameter("nodeType"));
      return certifyDto;
    }

    public abstract void dtoToView(HttpServletRequest httpServletRequest, CertifyDto certifyDto) throws Exception;

 }
