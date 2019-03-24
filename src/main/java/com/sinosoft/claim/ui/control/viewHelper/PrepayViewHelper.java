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
 * <p>Description:Ԥ��ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0 
 * <br>
 */
 public abstract class PrepayViewHelper
 {
    private int RULE_LENGTH = 70; //rule�ֶεĳ���  
   /**
    * Ĭ�Ϲ��췽��
    */
    public PrepayViewHelper()
    {
    }

   /**
    * ����Ԥ��ʱ����ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return prepayDto �������ݴ������ݽṹ
    * @throws Exception
    */
    public PrepayDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      PrepayDto prepayDto = new PrepayDto();
      /*---------------------Ԥ������prpLprepay------------------------------------*/
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
      
      //��������
       prpLprepayDto.setClassCode(httpServletRequest.getParameter("prpLprepayClassCode"));      
 
      //�ӵ�ArrayList��
      
      /*---------------------Ԥ�����PrpLpreChargeDto--------------------------*/
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
      /*---------------------Ԥ���ı���PrpLptextDto------------------------------------*/
      ArrayList prpLptextDtoList = new ArrayList();
      String TextTemp = httpServletRequest.getParameter("prpLptextContextInnerHTML");
      String[] rules = StringUtils.split(TextTemp,RULE_LENGTH);
      //�õ����Ӵ�,���潫���зֵ�����
      for(int k=0;k<rules.length;k++){
        PrpLptextDto prpLptextDto = new PrpLptextDto();
        prpLptextDto.setPreCompensateNo((String) httpServletRequest.getAttribute("prpLprepayPreCompensateNo"));
        prpLptextDto.setContext(rules[k]);
        prpLptextDto.setLineNo(k+1);
        prpLptextDtoList.add(prpLptextDto);
      }
        
      //prepayDto
      prepayDto.setPrpLptextDtoList(prpLptextDtoList);

      /*---------------------��������״̬����prpLclaimStatus------------------------------------*/
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      prpLclaimStatusDto.setBusinessNo(prpLprepayDto.getPreCompensateNo() );
      prpLclaimStatusDto.setPolicyNo(prpLprepayDto.getPolicyNo());

      prpLclaimStatusDto.setTypeFlag("5");
      prpLclaimStatusDto.setNodeType("speci");
      prpLclaimStatusDto.setSerialNo(5);

      prpLclaimStatusDto.setRiskCode(httpServletRequest.getParameter("prpLprepayRiskCode"));
      //prpLclaimStatusDto.setSerialNo(0);
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ����
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
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д������ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */
   public abstract PrepayDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * ��д����ҳ�漰��ѯ����request������.
    * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param prepayDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, PrepayDto prepayDto) throws Exception;

 }
