package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * <p>Title: CheckViewHelper</p>
 * <p>Description:�鿱ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */
 public abstract class CheckViewHelper
 {
    private int RULE_LENGTH = 70; //rule�ֶεĳ���  
    /**
    * Ĭ�Ϲ��췽��
    */
    public CheckViewHelper()
    {
    }

   /**
    * ����鿱ʱ�鿱ҳ����������.
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
    * @param httpServletRequest
    * @return checkDto �鿱���ݴ������ݽṹ
    * @throws Exception
    */
    public CheckDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      CheckDto checkDto = new CheckDto();
      /*---------------------�鿱����prpLcheck------------------------------------*/

        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        prpLcheckDto.setRegistNo((String)httpServletRequest.getAttribute("registNo"));
        prpLcheckDto.setClaimNo((String)httpServletRequest.getParameter("prpLcheckClaimNo"));
        prpLcheckDto.setRiskCode((String)httpServletRequest.getParameter("prpLcheckRiskCode"));
        prpLcheckDto.setPolicyNo((String)httpServletRequest.getParameter("prpLcheckPolicyNo"));
        prpLcheckDto.setCheckType((String)httpServletRequest.getParameter("checkType"));
        prpLcheckDto.setCheckNature((String)httpServletRequest.getParameter("checkNature"));
        prpLcheckDto.setCheckDate(new DateTime(httpServletRequest.getParameter("prpLcheckCheckDate")));
        prpLcheckDto.setCheckSite((String)httpServletRequest.getParameter("prpLcheckCheckSite"));
        prpLcheckDto.setFirstSiteFlag((String)httpServletRequest.getParameter("firstSiteFlag"));
        prpLcheckDto.setClaimType((String)httpServletRequest.getParameter("claimType"));
        prpLcheckDto.setDamageCode((String)httpServletRequest.getParameter("prpLcheckDamageCode"));
        prpLcheckDto.setDamageName((String)httpServletRequest.getParameter("prpLcheckDamageName"));
        prpLcheckDto.setDamageTypeCode((String)httpServletRequest.getParameter("prpLcheckDamageTypeCode"));
        prpLcheckDto.setDamageTypeName((String)httpServletRequest.getParameter("prpLcheckDamageTypeName"));
        prpLcheckDto.setReferKind((String)httpServletRequest.getParameter("referKind"));
        //prpLcheckDto.setReferKind((String)httpServletRequest.getParameter("prpLcheckReferKind"));
        prpLcheckDto.setDamageAreaCode((String)httpServletRequest.getParameter("prpLcheckDamageAreaCode"));
        prpLcheckDto.setDamageAddressType((String)httpServletRequest.getParameter("damageAddressType"));
        prpLcheckDto.setIndemnityDuty((String)httpServletRequest.getParameter("indemnityDuty"));
        //prpLcheckDto.setClaimFlag((String)httpServletRequest.getParameter("prpLcheckClaimFlag"));
        prpLcheckDto.setClaimFlag((String)httpServletRequest.getParameter("claimFlag"));
        prpLcheckDto.setChecker1((String)httpServletRequest.getParameter("prpLcheckChecker1"));
        prpLcheckDto.setChecker2((String)httpServletRequest.getParameter("prpLcheckChecker2"));
        prpLcheckDto.setCheckUnitName((String)httpServletRequest.getParameter("prpLcheckCheckUnitName"));
        prpLcheckDto.setHandleUnit((String)httpServletRequest.getParameter("prpLcheckHandleUnitName"));
        prpLcheckDto.setRemark((String)httpServletRequest.getParameter("prpLcheckRemark"));
        prpLcheckDto.setFlag((String)httpServletRequest.getParameter("prpLcheckFlag"));
        prpLcheckDto.setDamageAddress((String)httpServletRequest.getParameter("prpLcheckDamageAddress")   );   //add 20060320 
        //modify by wangwei add start 20060603
        //ԭ�򣺴�ҳ���л��Ԥ������Ԥ������
        prpLcheckDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateLoss"))));
        prpLcheckDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateFee"))));
        //modify by wangwei add end 20050603
 
        //���� ϵͳ��ʾ �� �鿱����λ�����ֶ�
        prpLcheckDto.setUnitType((String)httpServletRequest.getParameter("unitType"));
        prpLcheckDto.setHandleUnitCode((String)httpServletRequest.getParameter("prpLcheckHandleUnitCode"));
        
        //�ӵ�ArrayList��
        //String prpLcheckReferSerialNo=(String)httpServletRequest.getParameter("prpLcheckReferSerialNo");
        prpLcheckDto.setReferSerialNo(1);
        checkDto.setPrpLcheckDto(prpLcheckDto);
        String riskCode = prpLcheckDto.getRiskCode();
        String strRiskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
        if("D".equals(strRiskType)){
            prpLcheckDto.setInsureCarFlag("1");
        }else{
        	prpLcheckDto.setInsureCarFlag("");	
        }
	    if (httpServletRequest.getParameter("repeatInsureFlag")==null)
        	prpLcheckDto.setRepeatInsureFlag("-");		
		else
            prpLcheckDto.setRepeatInsureFlag(httpServletRequest.getParameter("repeatInsur eFlag"));

	    //modified by xiatian �⽡���߲鿱 ����Ҫ�����ˡ�
        //modify by wangwei add start 2005-06-18
        //ԭ������⽡�յĵ�����Ϣ
//        if ("E".equals(strRiskType)) {
//        	PrpLacciCheckDto  prpLacciCheckDto = new PrpLacciCheckDto();
//        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter("checkType")); //��ʱ������ʾ��ʲô�ڵ��ύ�����ĵ���,�����
//        	prpLacciCheckDto.setRegistNo(httpServletRequest.getParameter("prpLacciCheckRegistNo"));
//        	prpLacciCheckDto.setTimes(Integer.parseInt(httpServletRequest.getParameter("prpLacciCheckTimes")));
//        	prpLacciCheckDto.setCheckNo(httpServletRequest.getParameter("prpLacciCheckCheckNo"));
//        	prpLacciCheckDto.setCertiType(httpServletRequest.getParameter("prpLacciCheckCertiType"));
//        	prpLacciCheckDto.setCertiNo(httpServletRequest.getParameter("prpLacciCheckCertiNo"));
//        	prpLacciCheckDto.setRiskCode(httpServletRequest.getParameter("prpLacciCheckRiskCode"));
//        	prpLacciCheckDto.setPolicyNo(httpServletRequest.getParameter("prpLacciCheckPolicyNo"));
//        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter());
//        	prpLacciCheckDto.setCheckContext(httpServletRequest.getParameter("prpLacciCheckCheckContext"));
//        	prpLacciCheckDto.setCheckObjectDesc(httpServletRequest.getParameter("prpLacciCheckCheckObject"));
//        	prpLacciCheckDto.setCheckNature(httpServletRequest.getParameter("checkNature"));
//        	prpLacciCheckDto.setCheckDate(new DateTime(httpServletRequest.getParameter("prpLacciCheckCheckDate")));
//        	prpLacciCheckDto.setCheckHour(httpServletRequest.getParameter("prpLacciCheckCheckHour") + ":" + httpServletRequest.getParameter("prpLaccecheckCheckMinute"));
//        	prpLacciCheckDto.setCheckEndDate(new DateTime(httpServletRequest.getParameter("prpLacciCheckCheckEndDate")));
//        	prpLacciCheckDto.setCheckEndHour(httpServletRequest.getParameter("prpLacciCheckCheckEndHour") + ":" + httpServletRequest.getParameter("prpLacciCheckCheckEndMinute"));
//        	prpLacciCheckDto.setCheckSite(httpServletRequest.getParameter("prpLacciCheckCheckSite"));
//        	prpLacciCheckDto.setDamageCode(httpServletRequest.getParameter("prpLacciCheckDamageCode"));
//        	prpLacciCheckDto.setDamageName(httpServletRequest.getParameter("prpLacciCheckDamageName"));
//        	prpLacciCheckDto.setDamageTypeCode(httpServletRequest.getParameter("prpLacciCheckDamageTypeCode"));
//        	prpLacciCheckDto.setDamageTypeName(httpServletRequest.getParameter("prpLacciCheckDamageTypeName"));
//        	prpLacciCheckDto.setCheckerCode(httpServletRequest.getParameter("prpLacciCheckCode"));
//        	prpLacciCheckDto.setRemark(httpServletRequest.getParameter("prpLacciCheckRemark"));
//        	prpLacciCheckDto.setCheckFee(Float.parseFloat(httpServletRequest.getParameter("prpLacciCheckCheckFee")));
//        	prpLacciCheckDto.setCurrency(httpServletRequest.getParameter("prpLacciCheckCurrencyCode"));
//        	
//			
//        	ArrayList prpLacciCheckTextDtoList = new ArrayList();
//            //�õ����Ӵ�,���潫���зֵ�����
//          String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
//          String[] rulesAcci = StringUtils.split(TextTemp,RULE_LENGTH);
//            for(int k=0;k<rulesAcci.length;k++){
//              PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
//              prpLacciCheckTextDto.setCheckNo( (String) httpServletRequest.getParameter("prpLacciCheckCheckNo"));
//              prpLacciCheckTextDto.setContext(rulesAcci[k]);
//              prpLacciCheckTextDto.setLineNo(k+1);
//              prpLacciCheckTextDto.setTextType("3");
//              prpLacciCheckTextDtoList.add(prpLacciCheckTextDto);
//            }
//            AcciCheckDto acciCheckDto = new AcciCheckDto(); 
//            acciCheckDto.setPrpLacciCheckDto(prpLacciCheckDto);
//            acciCheckDto.setPrpLacciCheckTextDtoList(prpLacciCheckTextDtoList);
//            checkDto.setAcciCheckDto(acciCheckDto);
//          }
        //modify by wangwei add end 2005-06-18
        
        /*---------------------�ı���PrpLregistTextDto--------------------*/
      	ArrayList prpLregistTextDtoList = new ArrayList();
        //�õ����Ӵ�,���潫���зֵ�����
      String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
      String[] rules = StringUtils.split(TextTemp,RULE_LENGTH);
        for(int k=0;k<rules.length;k++){
          PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
          prpLregistTextDto.setRegistNo( (String) httpServletRequest.getAttribute("registNo"));
          prpLregistTextDto.setContext(rules[k]);
          prpLregistTextDto.setLineNo(k+1);
          prpLregistTextDto.setTextType("3");
          prpLregistTextDtoList.add(prpLregistTextDto);
        }        

        //װ��checkDto
        checkDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
        
        /*------------------����ԭ����ϸ��Ϣ----------------------*/
        String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag");
        if(strDamageMessage!=null && !strDamageMessage.equals("")){
     	   ArrayList prpLregistTextDtoList3 = new ArrayList();
     	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage");
     	   if(damageMessage != null){
 	    	   for(int index = 0;index<damageMessage.length;index++){
 	    		   PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
 	    		   prpLregistTextDto.setRegistNo((String) httpServletRequest.getAttribute("registNo"));
 	    		   prpLregistTextDto.setLineNo(index+1);
 	    		   prpLregistTextDto.setContext(damageMessage[index]);
 	    		   prpLregistTextDto.setTextType(strDamageMessage);
 	    		   prpLregistTextDtoList3.add(prpLregistTextDto);
 	    	   }
     	   }
     	   checkDto.setPrpLregistTextDtoList3(prpLregistTextDtoList3);
        }
        
        
        /*---------------------�������Ϣ��prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//�ӽ���õ���������
		String   prpLcheckPolicyNo  = httpServletRequest.getParameter("prpLcheckPolicyNo");
		String   prpLcheckRegistNo  = httpServletRequest.getParameter("prpLcheckRegistNo");
		String   prpLcheckDamageStartDate  = httpServletRequest.getParameter("prpLcheckDamageStartDate");
		String   prpLcheckDamageCode  = httpServletRequest.getParameter("prpLcheckDamageCode");
		String   prpLcheckDamageName  = httpServletRequest.getParameter("prpLcheckDamageName");
		String[]   prpLpropKindCode  = httpServletRequest.getParameterValues("prpLpropKindCode");
		
		
		String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount");
		String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank");
		String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode");
		String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName");
		String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo");
		String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo");
		String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate");
		String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo");
		String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo");
		String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber");
		String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode");
		String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate");
		String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName");
		String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate");
		String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour");
		String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber");
		String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason");
		String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible");
		String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate");
		String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo");
		String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss");
		String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode");
		String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card");
		String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode");
		String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode");
		String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName");
		String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo");
		String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType");
		String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo");
		String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo");
		String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime");
		String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee");
		String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay");
		String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount");

		//end��ֳ�ն����嵥�б��ֶζ���
		if (prplCompensateEarEarNo == null){
		}else{
			for(int index = 1;index < prplCompensateEarEarNo.length;index++)
			{
				prplCompensateEarDto = new PrplcompensateearDto();
						
				prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
				prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
				prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
				prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
				prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
				prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("Combine"));
				prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(prpLcheckDamageCode);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(prpLcheckDamageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLcheckDamageStartDate,DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
				prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
				prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
				prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
				prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
				prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
				prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
				prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
				prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
				prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
				prplCompensateEarDto.setKindcode(prplCompensateEarKindCode[index]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(2);
				prplCompensateEarDto.setNodetype("check");
				prplCompensateEarDto.setPolicyno(prpLcheckPolicyNo);
				prplCompensateEarDto.setRegistno(prpLcheckRegistNo);
				prplCompensateEarDto.setBusinessno(prpLcheckRegistNo);
				prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		checkDto.setPrpLcompensateeartDtoList(prplCompensateEarDtoList);
		String temp2 = httpServletRequest.getParameter("prpLcheckRiskCode");
		
		if("0310".equals(temp2)||"0312".equals(temp2))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			PrplcompensatehouseDto prplCompensateHouseDto = null;
			//String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			//String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");
			String[] prplCompensateHouseCaseNo=httpServletRequest.getParameterValues("prplCompensateHouseCaseNo");
			String[] prplCompensateHouseClaimNo=httpServletRequest.getParameterValues("prplCompensateHouseClaimNo");
			String[] prplCompensateHouseNodeNo=httpServletRequest.getParameterValues("prplCompensateHouseNodeNo");
			String[] prplCompensateHouseNodeType=httpServletRequest.getParameterValues("prplCompensateHouseNodeType");
			String[] prplCompensateHousePolicyNo=httpServletRequest.getParameterValues("prplCompensateHousePolicyNo");
			String[] prplCompensateHouseRegistNo=httpServletRequest.getParameterValues("prplCompensateHouseRegistNo");
			String[] prplCompensateHouseDamageCode=httpServletRequest.getParameterValues("prplCompensateHouseDamageCode");
			String[] prplCompensateHouseDamageStartDate=httpServletRequest.getParameterValues("prplCompensateHouseDamageStartDate");
			String[] prplCompensateHouseCompensateNo=httpServletRequest.getParameterValues("prplCompensateHouseCompensateNo");
			String[] prplCompensateHouseDamageName=httpServletRequest.getParameterValues("prplCompensateHouseDamageName");
			String[] prplCompensateHouseKindCode=httpServletRequest.getParameterValues("prplCompensateHouseKindCode");
			
			
			String[] prplCompensateHouseName=httpServletRequest.getParameterValues("prplCompensateHouseName");
			String[] prplCompensateHouseIDcard=httpServletRequest.getParameterValues("prplCompensateHouseIDcard");
			String[] prplCompensateHousehukoubu=httpServletRequest.getParameterValues("prplCompensateHousehukoubu");
			String[] prplCompensateHouseAddress=httpServletRequest.getParameterValues("prplCompensateHouseAddress");
			String[] prplCompensateHousePhone=httpServletRequest.getParameterValues("prplCompensateHousePhone");
			String[] prplCompensateHouseRemark=httpServletRequest.getParameterValues("prplCompensateHouseRemark");
			
			String[] prplCompensateHouseEstimateLoss=httpServletRequest.getParameterValues("prplCompensateHouseEstimateLoss");
			
  			String prplCompensateHouseBuildingnumber=httpServletRequest.getParameter("prplCompensateHouseBuildingnumber");
			String prplCompensateHouseZhuannumber=httpServletRequest.getParameter("prplCompensateHouseZhuannumber");
			String prplCompensateHouseWanumber=httpServletRequest.getParameter("prplCompensateHouseWanumber");
			String prplCompensateHouseKitchennumber=httpServletRequest.getParameter("prplCompensateHouseKitchennumber");
			String prplCompensateHouseOthernumber=httpServletRequest.getParameter("prplCompensateHouseOthernumber");
			String prplCompensateHouseFloor=httpServletRequest.getParameter("prplCompensateHouseFloor");
			//System.err.println("length1:" + prplCompensateHouseIDcard.length);
			//System.err.println("length2:" + prplCompensateHouseCaseNo.length);
			if (prplCompensateHouseIDcard == null){
		     }else{
		    	 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
		    	 {
		    		 prplCompensateHouseDto = new PrplcompensatehouseDto();
		    		 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
		    		 prplCompensateHouseDto.setBusinessno(prpLcheckRegistNo);
		    		 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
		    		 prplCompensateHouseDto.setClaimno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setCompensateno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setDamagecode(prpLcheckDamageCode);
		    		 prplCompensateHouseDto.setDamagename(prpLcheckDamageName);
		    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(prpLcheckDamageStartDate,DateTime.YEAR_TO_DAY));
		    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
		    		 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
		    		 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
		    		 prplCompensateHouseDto.setKindcode("001");
		    		 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
		    		 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
		    		 prplCompensateHouseDto.setRegistno(prpLcheckRegistNo);
		    		 prplCompensateHouseDto.setPolicyno(prpLcheckPolicyNo);
		    		 prplCompensateHouseDto.setNodeno(2);
		    		 prplCompensateHouseDto.setNodetype("check");
		    		 prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
					 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
		    		 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
		    		 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
		    		 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
		    		 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
		    		 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);
					 prplCompensateHouseDtoList.add(prplCompensateHouseDto);

		    	 }
		    	 //System.err.println("����:" + prplCompensateHouseDtoList.size());
		    	 checkDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
		}
		
        
        /*---------------------״̬����prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("check");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
        System.out.println("prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode()):==" + prpLcheckDto.getRiskCode());
        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
        HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));

        checkDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return checkDto;

    }

   /**
    * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
    * ��д�鿱��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
    * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
    * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
    * @param httpServletRequest
    * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
    * @throws Exception
    */
   public abstract CheckDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * ��д�鿱ҳ�漰��ѯ�鿱request������.
    * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
    * @param httpServletRequest ���ظ�ҳ���request
    * @param checkDto ȡ���ĳ�ʼ����ϢDto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, CheckDto checkDto) throws Exception;

 }

 
 