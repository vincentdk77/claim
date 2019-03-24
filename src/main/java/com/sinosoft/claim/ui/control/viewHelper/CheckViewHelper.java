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
 * <p>Description:查勘ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */
 public abstract class CheckViewHelper
 {
    private int RULE_LENGTH = 70; //rule字段的长度  
    /**
    * 默认构造方法
    */
    public CheckViewHelper()
    {
    }

   /**
    * 保存查勘时查勘页面数据整理.
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
    * @param httpServletRequest
    * @return checkDto 查勘数据传输数据结构
    * @throws Exception
    */
    public CheckDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
    {
      CheckDto checkDto = new CheckDto();
      /*---------------------查勘主表prpLcheck------------------------------------*/

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
        //原因：从页面中或的预估金额和预估费用
        prpLcheckDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateLoss"))));
        prpLcheckDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateFee"))));
        //modify by wangwei add end 20050603
 
        //加入 系统表示 和 查勘处理单位代码字段
        prpLcheckDto.setUnitType((String)httpServletRequest.getParameter("unitType"));
        prpLcheckDto.setHandleUnitCode((String)httpServletRequest.getParameter("prpLcheckHandleUnitCode"));
        
        //加到ArrayList中
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

	    //modified by xiatian 意健险走查勘 不需要调查了。
        //modify by wangwei add start 2005-06-18
        //原因：添加意健险的调查信息
//        if ("E".equals(strRiskType)) {
//        	PrpLacciCheckDto  prpLacciCheckDto = new PrpLacciCheckDto();
//        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter("checkType")); //暂时用来显示是什么节点提交过来的调查,需调整
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
//            //得到连接串,下面将其切分到数组
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
        
        /*---------------------文本表PrpLregistTextDto--------------------*/
      	ArrayList prpLregistTextDtoList = new ArrayList();
        //得到连接串,下面将其切分到数组
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

        //装入checkDto
        checkDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
        
        /*------------------出险原因详细信息----------------------*/
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
        
        
        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//从界面得到输入数组
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

		//end养殖险耳标清单列表字段定义
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
		    	 //System.err.println("长度:" + prplCompensateHouseDtoList.size());
		    	 checkDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
		}
		
        
        /*---------------------状态内容prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("check");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
        System.out.println("prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode()):==" + prpLcheckDto.getRiskCode());
        //取得当前用户信息，写操作员信息到查勘中
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
    * 取初始化信息需要的数据的整理.
    * 填写查勘单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
    * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
    * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
    * @param httpServletRequest
    * @return RequestDto 取初始化信息需要的数据
    * @throws Exception
    */
   public abstract CheckDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

   /**
    * 填写查勘页面及查询查勘request的生成.
    * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
    * @param httpServletRequest 返回给页面的request
    * @param checkDto 取出的初始化信息Dto
    * @throws Exception
    */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, CheckDto checkDto) throws Exception;

 }

 
 