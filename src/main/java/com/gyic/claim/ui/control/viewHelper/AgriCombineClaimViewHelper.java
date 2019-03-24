package com.gyic.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.util.LabelValueBean;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrpDangerShareDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIExchAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIRiskUnitAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.action.UserToPrpDuser;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.reins.out.bl.facade.BLFcoRepolicyFacade;
import com.sinosoft.reins.out.dto.domain.PrpCdangerUnitDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.string.Str;
import com.sinosoft.claim.ui.control.viewHelper.*;

/**
 * <p>
 * Title: ClaimViewHelper
 * </p>
 * <p>
 * Description:立案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 lijiyuan
 * @version 1.0 <br>
 */

public class AgriCombineClaimViewHelper extends ClaimViewHelper {
	private int RULE_LENGTH = 70; //rule字段的长度
    /**
     * 默认构造方法
     */
    public AgriCombineClaimViewHelper() {
    }

    /**
     * 保存立案时立案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return claimDto 立案数据传输数据结构
     * @throws Exception
     */
    public ClaimDto viewToDto(HttpServletRequest httpServletRequest,int indexOfClaim) throws Exception {
        //继承对claim,claimsText表的赋值
        ClaimDto claimDto = viewToDtoSuper(httpServletRequest, indexOfClaim);
        //add by zhaolu 20060816 start
        //reason权限判断
        UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
        UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_CLAIM_INSERT);
        //add by zhaolu 20060816 end
        /*add by lym 20060609  for 强三-start--------回写关联表-------------------------*/
        String   policyNo = httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim);
        String   registNo = httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfClaim);
        String   prpLRegistRPolicyClaimNo = (String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim);
    	String   flowID = httpServletRequest.getParameter("swfLogFlowID_"+indexOfClaim); 
        // String   riskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        
        UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
        PrpLRegistRPolicyDto  prpLRegistRPolicyDto = uiPrpLregistRPolicyAction.findByPrimaryKey(registNo, policyNo);
        if ( prpLRegistRPolicyDto!=null ){
        	prpLRegistRPolicyDto.setRegistNo(prpLRegistRPolicyDto.getRegistNo());
        	prpLRegistRPolicyDto.setPolicyNo(prpLRegistRPolicyDto.getPolicyNo());
        	prpLRegistRPolicyDto.setClaimNo(prpLRegistRPolicyClaimNo);
        	prpLRegistRPolicyDto.setFlowId(flowID);
        	prpLRegistRPolicyDto.setPolicyType(prpLRegistRPolicyDto.getPolicyType());
        	prpLRegistRPolicyDto.setRegistFlag(prpLRegistRPolicyDto.getRegistFlag());
        	prpLRegistRPolicyDto.setValidStatus(prpLRegistRPolicyDto.getValidStatus());
        	prpLRegistRPolicyDto.setFlag(prpLRegistRPolicyDto.getFlag());
        	prpLRegistRPolicyDto.setRemark(prpLRegistRPolicyDto.getRemark());
        }
        claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        
        /*add by lym 20060609  for 强三--end-------回写关联表-------------------------*/
       ///*---------------------险别估损金额PrpLclaimloss------------------------------------*/

        //*---------------------险别估损金额PrpLclaimloss------------------------------------*/
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = null;
        //从界面得到输入数组
        String prpLclaimLossClaimNo = (String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim);
        String prpLclaimLossRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfClaim);
        String[] prpLclaimLossSerialNo = httpServletRequest.getParameterValues("prpLclaimLossSerialNo_"+indexOfClaim);
        String[] prpLclaimLossItemKindNo = httpServletRequest.getParameterValues("prpLclaimLossItemKindNo_"+indexOfClaim);
        String[] prpLclaimLossFeeCategory = httpServletRequest.getParameterValues("prpLclaimLossFeeCategory_"+indexOfClaim);
        String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode_"+indexOfClaim);
        String[] prpLclaimLossItemCode = httpServletRequest.getParameterValues("prpLclaimLossItemCode_"+indexOfClaim);
        String[] prpLclaimLossItemDetailName = httpServletRequest.getParameterValues("prpLclaimLossItemDetailName_"+indexOfClaim);
        String[] prpLclaimLossCurrency = httpServletRequest.getParameterValues("prpLclaimLossCurrency_"+indexOfClaim);
        String[] prpLclaimLossSumClaim = httpServletRequest.getParameterValues("prpLclaimLossSumClaim_"+indexOfClaim);
        String[] prpLclaimLossInputDate = httpServletRequest.getParameterValues("prpLclaimLossInputDate_"+indexOfClaim);
        String[] prpLclaimLossRemarkFlag = httpServletRequest.getParameterValues("prpLclaimLossRemarkFlag_"+indexOfClaim);
        //意键险事故者名称暂存RemarkFlag字段，安信这块业务上没有调整估损金额的说法，以后再增加字段
        String[] prpLclaimLossAcciName = httpServletRequest.getParameterValues("prpLclaimLossAcciName_"+indexOfClaim);
        String[] prpLclaimAcciPersonFamilyNo = httpServletRequest.getParameterValues("prpLclaimAcciPersonFamilyNo_"+indexOfClaim);
        String[] prpLclaimLossFlag = httpServletRequest.getParameterValues("prpLclaimLossFlag_"+indexOfClaim);
        String[] prpLclaimLossKindLoss = httpServletRequest.getParameterValues("prpLclaimLossKindLoss_"+indexOfClaim);
        //add by zhaolu 20060914 start
        //加入残值
        String[] prpLclaimLossKindRest = httpServletRequest.getParameterValues("prpLclaimLossKindRest_"+indexOfClaim);
        //add by zhaolu 20060914 end
        //原因：添加标志字段，用于区别赔款和费用。
        String[] prpLregsitLossFeeType = httpServletRequest.getParameterValues("prpLclaimLossLossFeeType_"+indexOfClaim);
        //modify by wangwei add end 2005-06-07

        //对象赋值
        //-估损金额部分开始
        if (prpLclaimLossCurrency == null) {
        } else {
            for (int index = 1; index < prpLclaimLossCurrency.length; index++) {
                prpLclaimLossDto = new PrpLclaimLossDto();
                prpLclaimLossDto.setClaimNo(prpLclaimLossClaimNo);
                prpLclaimLossDto.setRiskCode(prpLclaimLossRiskCode);
                prpLclaimLossDto.setSerialNo(index);
                prpLclaimLossDto.setItemKindNo(Integer.parseInt(prpLclaimLossItemKindNo[index]));
                prpLclaimLossDto.setKindCode(prpLclaimLossKindCode[index]);
                prpLclaimLossDto.setFeeCategory( prpLclaimLossFeeCategory[index] );
                prpLclaimLossDto.setKindRest(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossKindRest[index])));
                if(prpLclaimLossItemCode!=null&&prpLclaimLossItemCode.length>index){
                	prpLclaimLossDto.setItemCode(prpLclaimLossItemCode[index]);
                }
                if(prpLclaimLossItemDetailName!=null&&prpLclaimLossItemDetailName.length>index){
                	prpLclaimLossDto.setItemDetailName(prpLclaimLossItemDetailName[index]);
                }
                prpLclaimLossDto.setCurrency(prpLclaimLossCurrency[index]);
                prpLclaimLossDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[index])));
                ////非车没有上报估损这一项------------------------------------------------
                if(prpLclaimLossKindLoss !=null && prpLclaimLossKindLoss.length >0 ){ //非车没有上报估损这一项
                   prpLclaimLossDto.setKindLoss(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossKindLoss[index])));
                 }
                else {
                   prpLclaimLossDto.setKindLoss(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[index])));
                }
                //暂存的立案再次提交时，原估损时间不变
                prpLclaimLossDto.setInputDate(new DateTime(prpLclaimLossInputDate[index]));
              	prpLclaimLossDto.setFamilyName(prpLclaimLossAcciName[index]);
              	prpLclaimLossDto.setFamilyNo(Integer.parseInt(prpLclaimAcciPersonFamilyNo[index]));
                //modify by luqin update 2005-06-23 start
                if(prpLclaimLossFlag != null){
                	prpLclaimLossDto.setFlag(prpLclaimLossFlag[index]);
                }
                //modify by luqin update 2005-06-23 end
                
                if (prpLregsitLossFeeType != null) {
                    prpLclaimLossDto.setLossFeeType(prpLregsitLossFeeType[index]);
                }
                claimLossList.add(prpLclaimLossDto);
            }
            claimDto.setPrpLclaimLossDtoList(claimLossList);
        }
        
        
        /*---------------------增加理赔联系记录 PrpLregistExt  2005-07-18------------------------------------*/
        ArrayList prpLregistExtDtoList = new ArrayList();
        PrpLregistExtDto prpLregistExtDto = null ;
        //从界面得到输入数组
        String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo_"+indexOfClaim); 
        String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode_"+indexOfClaim);
        String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo_"+indexOfClaim);
        String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate_"+indexOfClaim);
        String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour_"+indexOfClaim);
        String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode_"+indexOfClaim);
        String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext_"+indexOfClaim);

        //理赔联系记录
        if (prpLregistExtSerialNo==null)
        {}
        else
        {
          for(int index=1;index<prpLregistExtSerialNo.length;index++)
          {
            prpLregistExtDto = new PrpLregistExtDto();
            prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
            prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
            prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
            prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
            prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
            prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
            prpLregistExtDto.setContext(prpLregistExtContext[index]);
            //加入集合
            prpLregistExtDtoList.add(prpLregistExtDto);
          }
          //立案集合中加入理赔联系记录
          claimDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
        }      
        
      
        /*-------------------索赔申请人信息-------start------------------------------------*/
        ArrayList prpLacciPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciPersonProposerDto = null;
        //从界面得到输入数组
        
        String   proposerClaimNo = (String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim);
        String   proposerPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim);
        String[] proposerName = httpServletRequest.getParameterValues("proposerName_"+indexOfClaim);
        String[] proposerSerialNo = httpServletRequest.getParameterValues("prpLacciPersonSerialNo_"+indexOfClaim);
        String[] proposerIdentifyNumber = httpServletRequest.getParameterValues("proposerIdentifyNumber_"+indexOfClaim);
        String[] proposerRelation = httpServletRequest.getParameterValues("relationCode_"+indexOfClaim);
        String[] proposerPhone = httpServletRequest.getParameterValues("proposerPhone_"+indexOfClaim);
        String[] proposerAddress = httpServletRequest.getParameterValues("proposerAddress_"+indexOfClaim);
        String   proposerFamilyNo= httpServletRequest.getParameter("personFamilyNo_"+indexOfClaim);
        //-----------------------------------
       
        //对象赋值
        if (proposerSerialNo ==null) {
        } else { 
        	 
            for (int index = 1; index < proposerSerialNo.length; index++) {
            	prpLacciPersonProposerDto =new  PrpLacciPersonDto();
                prpLacciPersonProposerDto.setAcciName(proposerName[index]);
                prpLacciPersonProposerDto.setCertiNo(proposerClaimNo);
                prpLacciPersonProposerDto.setCertiType("03");
                prpLacciPersonProposerDto.setPolicyNo(proposerPolicyNo);
                prpLacciPersonProposerDto.setFlag("1");   //标志是索赔人
                prpLacciPersonProposerDto.setIdentifyNumber(proposerIdentifyNumber[index]);
                prpLacciPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(proposerSerialNo[index])));
                prpLacciPersonProposerDto.setAddress(proposerAddress[index]);
                prpLacciPersonProposerDto.setFamilyNo(0);  //家庭序号
                prpLacciPersonProposerDto.setPhone(proposerPhone[index]);
                prpLacciPersonProposerDto.setRelationCode(proposerRelation[index]);
                String relationName="";
                
                if(proposerRelation[index].equals("1")){
                	relationName ="被保险人本人";	
                }
                else if(proposerRelation[index].equals("2")){
                	relationName ="指定受益人";	
                }
                else if(proposerRelation[index].equals("3")){
                	relationName ="被保险人之继承人";	
                }
                else if(proposerRelation[index].equals("4")){
                	relationName ="被保险人之监护人";	
                }
                prpLacciPersonProposerDto.setRelationName(relationName);
                prpLacciPersonProposerDto.setFamilyNo(1);
                
                //加入集合
                prpLacciPersonList.add(prpLacciPersonProposerDto);
            }
            //意健险立案集合中加入索赔申请人
           claimDto.setPrpLacciPersonDtoList(prpLacciPersonList);
        }
        /*-------------------索赔申请人信息-------end------------------------------------*/

        
        String   DangerUnitCheckSaveFlag = httpServletRequest.getParameter("DangerUnitCheckSaveFlag_"+indexOfClaim);
        //用旧的危险单位方法保存
        if(DangerUnitCheckSaveFlag.equals("1")){
            //******---------------------危险单位信息 add by qinyongli 2005-8-16 start------------------------------------*/
		        //add by kangzhen 061130 start reason 给再保送数据
		        UIPolicyAction uiPolicyAction =new UIPolicyAction();
		        PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(policyNo);
		        String strCoinsFlag = prpCmainDto.getCoinsFlag();
		        //add by kangzhen 061130 end
		        
		        ArrayList dangerUnitList = new ArrayList();
		        PrpLdangerUnitDto prpLdangerUnitDto = null;
		        //从界面得到输入数组
		        String prpLdangerClaimNo =  (String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim);
		        String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo_"+indexOfClaim);
		        String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLclaimRiskCode_"+indexOfClaim);
		        String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDesc_"+indexOfClaim);
		        String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerAddressName_"+indexOfClaim);
		        String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency_"+indexOfClaim);
		        String[] prpLdangerRiskSumClaim = httpServletRequest.getParameterValues("prpLdangerRiskSumClaim_"+indexOfClaim);
		        String[] prpLdangerProportion = httpServletRequest.getParameterValues("prpLdangerProportion_"+indexOfClaim);
		        
		        String  prpLclaimDamageStartDate = httpServletRequest.getParameter("prpLclaimDamageStartDate_"+indexOfClaim);
		        
		        int ednorserTimes = prpCmainDto.getEndorseTimes();//批改次数
		        String policyno = prpCmainDto.getPolicyNo();
		        
		        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		        List prpDangerShareList = new ArrayList();
		        // 取出险时最新保单的危险单位分摊比例
		        prpDangerShareList = blPrpLclaimFacade.getDangerShareList(policyno, ednorserTimes, prpLclaimDamageStartDate);
		        
		        //对象赋值
		        double temSumLoss = 0;
		        double sumLost = 0;//非最后一个危险单位累加值
		        double temSumNoPaid = 0;
		        double sumNoPaid = 0;//非最后一个危险单位累加值
		        if (prpLdangerCurrency == null) {
		        } else {
		            for (int index = 0; index < prpLdangerCurrency.length; index++) {
		         	
		         	sumLost = 0;
		         	sumNoPaid = 0;
		         	PrpDangerShareDto prpdangerShareDto = new PrpDangerShareDto();
		         	
		            	if(prpDangerShareList!=null&&prpDangerShareList.size()>0)
		            	{
		            		for(int i=0;i<prpDangerShareList.size();i++)
		            		{
		                    	 prpLdangerUnitDto = new PrpLdangerUnitDto();
		                    	 prpdangerShareDto = (PrpDangerShareDto)prpDangerShareList.get(i);
		                     	 prpLdangerUnitDto.setCertiNo(prpLdangerClaimNo);
		                    	 prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo);
		                    	 prpLdangerUnitDto.setCertiType("1");
		                    	 prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
		                    	 prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
		                    	 prpLdangerUnitDto.setDangerNo(prpdangerShareDto.getDangerNo());
		                    	 prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
		                    	 prpLdangerUnitDto.setAddressName(prpLdangerAddressName[index]);
		                    	 prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
		                    	 if(i==prpDangerShareList.size()-1)//最后一个危险单位用减法算
		                    	 {
		                    		temSumLoss = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumLost;
		                    	    temSumNoPaid = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumNoPaid;
		                    	 }
		                    	 else
		                      //非最后一个危险单位用乘法算
		                    	 {
		                    		temSumLoss = Double.parseDouble(prpLdangerRiskSumClaim[index])*prpdangerShareDto.getDangerShare()/100;
		                    		temSumNoPaid = Double.parseDouble(prpLdangerRiskSumClaim[index])*prpdangerShareDto.getDangerShare()/100;
		                    		sumLost +=  temSumLoss;
		                    		sumNoPaid +=temSumNoPaid;
		                    	 }
		                    	 prpLdangerUnitDto.setSumLoss(temSumLoss);
		                    	 prpLdangerUnitDto.setSumNoPaid(temSumNoPaid);
		                    	 prpLdangerUnitDto.setDangerShare(prpdangerShareDto.getDangerShare());
		                  	 prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);
		                  	 prpLdangerUnitDto.setDamageDate(claimDto.getPrpLclaimDto().getDamageStartDate());
		                  	 prpLdangerUnitDto.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
		                  	 
		                  	 
		                      //加入集合
		                    	 if(prpLdangerClaimNo!=null&&!(prpLdangerClaimNo.equals(""))){
		                    	      dangerUnitList.add(prpLdangerUnitDto);
		                    	 } 	
		            		}
		            	}
		            }
		            if(dangerUnitList.size()>0){
		              	claimDto.setPrplRiskUnitDtoList(dangerUnitList);
		            }
		      }
		       //******---------------------危险单位信息 add by qinyongli 2005-8-16  end------------------------------------*/
        }else if(DangerUnitCheckSaveFlag.equals("2")){
     	   //用新的危险单位方法保存
        	 //******---------------------危险单位信息 国元项目组 start------------------------------------*/
            String   prpLclaimLossPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim);
            UIPolicyAction uiPolicyAction =new UIPolicyAction();
            PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimLossPolicyNo);
            PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
            String strCoinsFlag = prpCmainDto.getCoinsFlag();
            ArrayList  dangerUnitList = new ArrayList();
            ArrayList  dangerItemList = new ArrayList();
            ArrayList  dangerTotList = new ArrayList();
        
            double temp=0;
            double sumDangerUnit=0d;
            boolean flag=true; 
            //从界面得到输入数组
            String prpLdangerClaimNo =  (String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim);//立案号
            String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo_"+indexOfClaim);//保单号
            String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLdangerRiskCode_"+indexOfClaim);//险种号
            String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDangerDesc_"+indexOfClaim);//危险单位描述
            String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerUnitAddressName_"+indexOfClaim);//危险单位地址
            String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency_"+indexOfClaim);//币别
            String[] prpLdangerUnitSumLoss = httpServletRequest.getParameterValues("prpLdangerUnitSumLoss_"+indexOfClaim);//估损金额
            String[] prpLdangerDangerNo = httpServletRequest.getParameterValues("prpLdangerDangerNo_"+indexOfClaim);//危险单位号
            String[] prpLdangerShare = httpServletRequest.getParameterValues("prpLdangerShare_"+indexOfClaim);//占比
            String[] prpLdangerKindcode = httpServletRequest.getParameterValues("prpLdangerKindcode_"+indexOfClaim);//险别代码
            String[] prpLdangerKindname = httpServletRequest.getParameterValues("prpLdangerKindname_"+indexOfClaim);//险别名称
            String[] prpLdangerItemCode = httpServletRequest.getParameterValues("prpLdangerItemCode_"+indexOfClaim);//标的代码
            String[] prpLdangerItemName = httpServletRequest.getParameterValues("prpLdangerItemName_"+indexOfClaim);//标的名称
            String[] prpLdangerUnitItemKindNo = httpServletRequest.getParameterValues("prpLdangerUnitItemKindNo_"+indexOfClaim);//标的序号
            
            //1、生成此赔款危险单位标的prpLdangerItem
            if (prpLdangerCurrency == null) {
     			
     		} else {
     			PrpLdangerItemDto prpLdangerItemDto=null;
     		    for (int index = 1; index < prpLdangerCurrency.length; index++) {
     		      if(Double.parseDouble(prpLdangerUnitSumLoss[index])!=0&&Double.parseDouble(prpLdangerShare[index])!=0){
     		    	prpLdangerItemDto= new PrpLdangerItemDto();       
     				prpLdangerItemDto.setCertiNo(prpLdangerClaimNo); // 立案号
     				prpLdangerItemDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); //危险单位
     				prpLdangerItemDto.setCurrency(prpLdangerCurrency[index]); // 损失币别
     				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
     				prpLdangerItemDto.setKindCode(prpLdangerKindcode[index]);    
                    prpLdangerItemDto.setKindName(prpLdangerKindname[index]);  
     				prpLdangerItemDto.setRiskCode(prpLdangerRiskCode[index]); 
     				prpLdangerItemDto.setAddressName(prpLdangerAddressName[index]);
     				prpLdangerItemDto.setPolicyno(prpLdangerPolicyNo[index]);
     				prpLdangerItemDto.setDangerdesc(prpLdangerUnitDesc[index]);
     				prpLdangerItemDto.setItemcode(prpLdangerItemCode[index]);
     				prpLdangerItemDto.setItemname(prpLdangerItemName[index]);
     				//占比最后一个减法原则
     				flag=true;
     	                for(int i=index+1;i<prpLdangerCurrency.length;i++){
	                		 if(prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])){
	     	              		 flag=false;
	     	              	 }
     	                }
     	                   if(flag){
     	                	  temp=0;
     	               		for(int k=1;k<index;k++){
	     	               		 if(prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])){
	    	                    	  temp+=Str.round(Double.parseDouble(prpLdangerShare[k]),2);
	    	               		 }
     	               		}
     	               		prpLdangerItemDto.setDangerKindShare(Str.round(100-temp,2));
     	                   }else{
     	                	 	prpLdangerItemDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
     	                   }
     	               
     	           	
     				prpLdangerItemDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
     				prpLdangerItemDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
     				
     				sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
     				 //加入集合
                   	 if(prpLdangerItemDto!=null){
                   		 dangerItemList.add(prpLdangerItemDto);
                   	 }
     			}
     		}  
     		    if(dangerItemList.size()>0){
                  	claimDto.setPrpLdangerItemDtoList(dangerItemList);
                }
     		}
            
            //2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）
            
            Iterator     iterator   = null;
            PrpLdangerTotDto prpLdangerTotDto   = null; 
            Iterator      itTot  = null;
    		PrpLdangerItemDto prpLdangerItemDto = null;       //标的DTO
            boolean find = true;
            if (dangerItemList  != null){
            	iterator = dangerItemList.iterator();
            	while(iterator.hasNext()){
            		prpLdangerItemDto = (PrpLdangerItemDto)iterator.next();
            		find = false;
            		itTot = dangerTotList.iterator();
            		while(itTot.hasNext())
            		{
            			prpLdangerTotDto = (PrpLdangerTotDto)itTot.next();
            			if (prpLdangerTotDto.getDangerNo() == prpLdangerItemDto.getDangerNo())
            			{
            				find = true;
            				prpLdangerTotDto.setSumPaid(Str.round(prpLdangerTotDto.getSumPaid()+prpLdangerItemDto.getSumPaid(),2));
            				prpLdangerTotDto.setSumPaidEx(Str.round(prpLdangerTotDto.getSumPaidEx()+prpLdangerItemDto.getSumPaid(),2));
            				break;
            			}
            		}
            		//每个危险单位标的的第一次数据的生成
            		if (find == false)
            		{
            			prpLdangerTotDto = new PrpLdangerTotDto();
                        
                         prpLdangerTotDto.setCertiNo(prpLdangerClaimNo);
        		  		 prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());                        
        		  		 prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency());   //标的原币别
        		  		 prpLdangerTotDto.setSumFee(0);
        		  		 prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
        		  		 prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
        		  		 prpLdangerTotDto.setExchRate(1);
        		  		 prpLdangerTotDto.setSumFeeEx(0);
        		  		 prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
        		  	 	 //加入集合
                    	 if(prpLdangerTotDto!=null){
                    		dangerTotList.add(prpLdangerTotDto);
                    	 }
                		
            		}
              
            	}

            	  if(dangerTotList.size()>0){
                    	claimDto.setPrpLdangerTotDtoList(dangerTotList);
                  }
            }
            
            //3、生成危险单位prpLdangerUnit
           
            Iterator      itUnit  = null;
            PrpLdangerUnitDto prpLdangerUnitDto=null;
            if (dangerItemList != null){
            	iterator = dangerItemList.iterator();
            	while(iterator.hasNext()){
            		prpLdangerItemDto = (PrpLdangerItemDto)iterator.next();
            		find = false;
            		itUnit = dangerUnitList.iterator();
            		while(itUnit.hasNext())
            		{
            			prpLdangerUnitDto = (PrpLdangerUnitDto)itUnit.next();
            			if (prpLdangerUnitDto.getDangerNo() == prpLdangerItemDto.getDangerNo())
            			{
            				find = true;
            				prpLdangerUnitDto.setSumLoss(Str.round(prpLdangerUnitDto.getSumLoss()+prpLdangerItemDto.getSumPaid(),2));
            				prpLdangerUnitDto.setSumNoPaid(Str.round(prpLdangerUnitDto.getSumLoss()+prpLdangerItemDto.getSumPaid(),2));
            				break;
            			}
            		}
            		//每个危险单位标的的第一次数据的生成
            		if (find == false)
            		{
            			 prpLdangerUnitDto = new PrpLdangerUnitDto();
                   	     prpLdangerUnitDto.setCertiNo(prpLdangerClaimNo);
                    	 prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo);
                    	 prpLdangerUnitDto.setCertiType("1");
                    	 prpLdangerUnitDto.setRiskCode(prpLdangerItemDto.getRiskCode());
                    	 prpLdangerUnitDto.setPolicyNo(prpLdangerItemDto.getPolicyno());
                    	 prpLdangerUnitDto.setDangerNo(prpLdangerItemDto.getDangerNo());
                    	 prpLdangerUnitDto.setDangerDesc(prpLdangerItemDto.getDangerdesc());
                    	 prpLdangerUnitDto.setAddressName(prpLdangerItemDto.getAddressName());
                    	 prpLdangerUnitDto.setCurrency(prpLdangerItemDto.getCurrency());
            		     prpLdangerUnitDto.setSumLoss(prpLdangerItemDto.getSumPaid());
            		     prpLdangerUnitDto.setSumPaid(0);
                         prpLdangerUnitDto.setSumNoPaid(prpLdangerItemDto.getSumPaid());
                         prpLdangerUnitDto.setSumFee(0);
                  	     prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);
                  	     prpLdangerUnitDto.setDamageDate(claimDto.getPrpLclaimDto().getDamageStartDate());
                  	     prpLdangerUnitDto.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
                  	   //  prpLdangerUnitDto.setAgricultureflag(prpCmainDto.getBusinessType1());
                  	    //加入集合
                    	 if(prpLdangerUnitDto!=null){
                    		dangerUnitList.add(prpLdangerUnitDto);
                    	 }
            		}
            	}
            	//最后一个占比减法原则
            	double dangerShare = 0;
            	double tempSumDangerShare = 0;
            	PrpLdangerUnitDto prpLdangerUnitDtotemp =null;
            	for (int i=0;i<dangerUnitList.size();i++){
            		prpLdangerUnitDtotemp=(PrpLdangerUnitDto)dangerUnitList.get(i);
            		if(i==(dangerUnitList.size()-1))
            		{
            			dangerShare = Str.round(100-tempSumDangerShare,2);
            		}else
            		{
            			dangerShare = Str.round(prpLdangerUnitDtotemp.getSumLoss()/sumDangerUnit*100,2);
            			tempSumDangerShare = Str.round(tempSumDangerShare+dangerShare, 2);
            		}
            		prpLdangerUnitDtotemp.setDangerShare(dangerShare);
    	       	 }
    	        	
    	        	 if(dangerUnitList.size()>0){
    	             	claimDto.setPrplRiskUnitDtoList(dangerUnitList);
    	           }
    	        }
            
           //******---------------------危险单位信息 国元项目组   end------------------------------------*/
        }
        return claimDto;
    }

    /**
     * 取初始化信息需要的数据的整理. 填写立案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参， 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
     * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
     * 
     * @param httpServletRequest
     * @return RequestDto 取初始化信息需要的数据
     * @throws Exception
     */
    public ClaimDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception {
        ClaimDto claimDto = new ClaimDto();
        return claimDto;
    }

    /**
     * 填写立案页面及查询立案request的生成. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */
    public void dtoToView(HttpServletRequest httpServletRequest, ClaimDto claimDto) throws Exception {
        //得到request的PrpLregistForm用于显示
        PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
        httpServletRequest.setAttribute("prpLcalimForm", prpLclaimDto);

        //得到request的prpLthirdPartyForm用于显示
        Collection prpLthirdPartyList = claimDto.getPrpLthirdPartyDtoList();
        httpServletRequest.setAttribute("prpLthirdPartyForm", prpLthirdPartyList);

        //得到request的prpLdriverForm用于显示
        Collection prpLdriverList = claimDto.getPrpLdriverDtoList();
        httpServletRequest.setAttribute("prpLdriverForm", prpLdriverList);

        //得到request的prpLltextForm用于显示
        Collection prpLltextDtoList = claimDto.getPrpLltextDtoList();
        httpServletRequest.setAttribute("prpLltextForm", prpLltextDtoList);

        //得到request的prpLclaimFee用于显示
        Collection prpLclaimFeeDtoList = claimDto.getPrpLclaimFeeDtoList();
        httpServletRequest.setAttribute("prpLclaimFeeForm", prpLclaimFeeDtoList);

        //得到request的prpLdoc用于显示
        Collection prpLdocDtoList = claimDto.getPrpLdocDtoList();
        httpServletRequest.setAttribute("prpLdocForm", prpLdocDtoList);

    }

    /**
     * 填写立案页面及查询立案request的生成. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */
    public PrpLclaimDto registDtoToView(HttpServletRequest httpServletRequest, String registNo) throws Exception {
        //取得当前用户信息，写操作员信息到立案中
    	HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        UIRegistAction uiRegistAction = new UIRegistAction();
        String policyNo = httpServletRequest.getParameter("policyNo");  //add by lym 20060605 for 强三
        String riskCode = httpServletRequest.getParameter("riskCode");  //add by lym 20060605 for 强三
        ClaimDto claimDto = new ClaimDto();
        //将查勘信息带入到立案中
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);  
        ArrayList list = new ArrayList();
        if(checkDto.getPrpLextDto()==null){
        	
            httpServletRequest.setAttribute("prpLextDto", new PrpLextDto());
        }else{
        	
            httpServletRequest.setAttribute("prpLextDto", checkDto.getPrpLextDto());
        }
        //根据查询出来的数据内容，给PrpLclaimDto赋值
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        prpLcheckDto =  checkDto.getPrpLcheckDto();
        if (prpLcheckDto == null) //要提示，立案之前必须做查看的！！！
        {
            //没有做查勘，但是可以立案
            //String msg = "立案之前，请先做查勘！";
            //throw new UserException(1,3,"立案",msg);
        	//modify by wangwei add start 2005-06-21
        	//原因：在立案时从报案信息中带出出险摘要
        	/* if (checkDto.getPrpLregistTextDtoList() != null) {
                Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
                while (iterator.hasNext()) {
                    PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
                    PrpLltextDto prpLltextDto = new PrpLltextDto();
                    prpLltextDto.setContext(prpLregistTextDto.getContext());
                    list.add(prpLltextDto);
                }
        	 }*/
        	//modify by wangwei add end 2005-06-21
        } else {

            if (checkDto.getPrpLregistTextDtoList() != null) {
                Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
                while (iterator.hasNext()) {
                    PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
                    PrpLltextDto prpLltextDto = new PrpLltextDto();
                    prpLltextDto.setContext(prpLregistTextDto.getContext());
                    prpLltextDto.setTextType(prpLregistTextDto.getTextType());
                    list.add(prpLltextDto);
                }
            }
           
            prpLclaimDto.setIndemnityDuty(prpLcheckDto.getIndemnityDuty());
            //modify by liubvo add 20050310 start
            //reason: 立案需要从查勘带出责任比例
            String indemnityDuty = prpLcheckDto.getIndemnityDuty();
            double indemnityDutyRate = 100;
            
            //转换赔偿责任
            if (indemnityDuty.trim().equals("0")) {
                indemnityDutyRate = 100;
            } else if (indemnityDuty.trim().equals("1")) {
                indemnityDutyRate = 70;
            } else if (indemnityDuty.trim().equals("2")) {
                indemnityDutyRate = 50;
            } else if (indemnityDuty.trim().equals("3")) {
                indemnityDutyRate = 30;
            } else if (indemnityDuty.trim().equals("4")) {
                indemnityDutyRate = 0.0;
            } else if (indemnityDuty.trim().equals("9")) {
                indemnityDutyRate = 0.0;
            }

            prpLclaimDto.setIndemnityDutyRate(indemnityDutyRate);
            //modify by liubvo add 20050310 end
            //prpLclaimDto.setEscapeFlag(prpLcheckDto.getClaimType());
            

        }
        //查询报案信息，并取适当的信息到新登记的立案中
        RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
        
        //add by zhaolu start at 2006-06-09
    	//reason 强制保单关联信息写到立案中
        System.out.println(registDto.getPrpLRegistRPolicyList().size());
	    System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
	    httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
	    //add by zhaolu end at 2006-06-09
        //modify by wangwei add start 2005-06-10
        //原因：要在界面上显示一些立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();
        
//modify by lym 20060605 for 强三 --------- start
        // Collection registClaimDtoList = (Collection) uiClaimAction.findByPolicyNo(registDto.getPrpLregistDto()
         //       .getPolicyNo());
        
     Collection registClaimDtoList = (Collection) uiClaimAction.findByPolicyNo(policyNo);  
// modify by lym 20060605 for 强三 --------end
     
     httpServletRequest.setAttribute("registClaimDtoList", registClaimDtoList);
        //modify by wangwei add end 2005-06-10
        //add by qinyongli start 2005-8-27 
        //如果未查勘就立案，此时，从报案带入出险摘要默认作为出险摘要
        //在这里进行转化将得到的prpLregistTextDto数据传递给prpLltextDto
        if(list.size()<1){
        	list = registDto.getPrpLregistTextDtoList();
        	
        	Collection listTemp = new ArrayList();
            Iterator iteratorList = list.iterator();
            PrpLregistTextDto prpLregistTextDto = null;
            while(iteratorList.hasNext()){
            	PrpLltextDto prpLltextDto = new PrpLltextDto();
            	prpLregistTextDto =(PrpLregistTextDto)iteratorList.next();
            	prpLltextDto.setContext(prpLregistTextDto.getContext());
            	prpLltextDto.setTextType(prpLregistTextDto.getTextType());
            	listTemp.add(prpLltextDto);
            }    	
            list =(ArrayList)listTemp;
        }     
        //add by qinyongli end
        prpLclaimDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
        prpLclaimDto.setPolicyNo(policyNo); //modify by lym 20060605 for   强三
        prpLclaimDto.setDamageCode(registDto.getPrpLregistDto().getDamageCode());
        prpLclaimDto.setDamageName(registDto.getPrpLregistDto().getDamageName());
        prpLclaimDto.setDamageTypeCode(registDto.getPrpLregistDto().getDamageTypeCode());
        prpLclaimDto.setDamageTypeName(registDto.getPrpLregistDto().getDamageTypeName());
        prpLclaimDto.setDamageAreaCode(registDto.getPrpLregistDto().getDamageAreaCode());
        prpLclaimDto.setDamageAreaName(registDto.getPrpLregistDto().getDamageAreaName()); 
        
        //立案时出险地点取查勘的，如果没有就取报案的出险地点----------------------------------
         if ( prpLcheckDto==null || prpLcheckDto.getDamageAddress()==null || prpLcheckDto.getDamageAddress().equals("")){
         	 prpLclaimDto.setDamageAddress(registDto.getPrpLregistDto().getDamageAddress());
         	 prpLclaimDto.setDamageAddressType(registDto.getPrpLregistDto().getDamageAddressType());
         }
         else {
         	 prpLclaimDto.setDamageAddress(prpLcheckDto.getDamageAddress());
         	 prpLclaimDto.setDamageAddressType(prpLcheckDto.getDamageAddressType());
         }
       
       
        prpLclaimDto.setRiskCode(riskCode);  //modify by lym 20060605 for   强三 
        String timeTemp = "";
        timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageStartHour());
        prpLclaimDto.setDamageStartDate(registDto.getPrpLregistDto().getDamageStartDate());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageEndHour());
        prpLclaimDto.setDamageEndDate(registDto.getPrpLregistDto().getDamageEndDate());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        prpLclaimDto.setClaimDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        //modify by xiatian ,添加精确时间
        prpLclaimDto.setClaimTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setInsuredCode(registDto.getPrpLregistDto().getInsuredCode());
        prpLclaimDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
        if(!registDto.getPrpLregistDto().getInsuredCode().equals(""))
        {
        	UICodeAction uiCodeAction = new UICodeAction();
        	prpLclaimDto.setCustomerType(uiCodeAction.getCustomerType(registDto.getPrpLregistDto().getInsuredCode()));
        }
        prpLclaimDto.setClassCode(registDto.getPrpLregistDto().getClassCode());
        prpLclaimDto.setComCode(registDto.getPrpLregistDto().getComCode());
        prpLclaimDto.setAddressCode(registDto.getPrpLregistDto().getAddressCode());
        prpLclaimDto.setEscapeFlag(registDto.getPrpLregistDto().getClaimType());
        
        //缺省带出报案的币别 2005-09-05
         //modify by qinyngli 20051021  货运险如果进行过查勘则取查勘币别
        UICodeAction uiCodeAction = new UICodeAction();
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(registDto.getPrpLregistDto().getRiskCode());
		
		if ("Y".equals(strRiskType)) {
        	 if(uiCheckAction.isExist(registNo)) {
                 PrpLextDto prpLextDto = checkDto.getPrpLextDto();
                 //Modify by zhaolu 20060908 start
                 if(prpLextDto != null)
                 prpLclaimDto.setEstiCurrency(prpLextDto.getCurrency());
                 //Modify by zhaolu 20060908 end
             }else{
             	prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
             }
        }else{
        	prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
        }
        //modify by qinyongli end
        //添加案件性质 2005-08-01
        prpLclaimDto.setClaimType("1");
        prpLclaimDto.setClaimTypeName("速决赔案");
        //进行币别转化，得到中文名称
        String strCurrencyName = uiCodeAction.translateCurrencyCode(prpLclaimDto.getEstiCurrency(), true);
        httpServletRequest.setAttribute("strCurrencyName", strCurrencyName);
        //原因：添加出险人员信息
        if (registDto.getPrpLacciPersonDto() != null) {
            prpLclaimDto.setAcciCode(registDto.getPrpLacciPersonDto().getAcciCode());
            prpLclaimDto.setAcciName(registDto.getPrpLacciPersonDto().getAcciName());
            prpLclaimDto.setSex(registDto.getPrpLacciPersonDto().getSex());
            prpLclaimDto.setAge(registDto.getPrpLacciPersonDto().getAge());
            prpLclaimDto.setIdentifyNumber(registDto.getPrpLacciPersonDto().getIdentifyNumber());
            prpLclaimDto.setFamilyNo(registDto.getPrpLacciPersonDto().getFamilyNo());
          
        }
       
        
        //modify by wangwei add end 2005-06-16

        //lixiang 对照数据结构后增加
        prpLclaimDto.setLanguage(registDto.getPrpLregistDto().getLanguage());
        prpLclaimDto.setLossName(registDto.getPrpLregistDto().getLossName());
        prpLclaimDto.setMakeCom(registDto.getPrpLregistDto().getMakeCom());
        prpLclaimDto.setHandler1Code(registDto.getPrpLregistDto().getHandler1Code());
        prpLclaimDto.setOperatorCode(user.getUserCode());
        //估损金额的获取，如果是查勘，定损，核损都可以立案，
        prpLclaimDto.setSumClaim(registDto.getPrpLregistDto().getEstimateLoss());
        //设置默认的经办人
        prpLclaimDto.setHandlerCode(user.getUserCode());

        //对车型,条款等信息的支持
        prpLclaimDto.setClauseType(registDto.getPrpLregistDto().getClauseType());
        prpLclaimDto.setClauseName(registDto.getPrpLregistDto().getClauseName());
        prpLclaimDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
        prpLclaimDto.setLicenseColorCode(registDto.getPrpLregistDto().getLicenseColorCode());
        prpLclaimDto.setLicenseColor(prpLclaimDto.getLicenseColorCode());
        prpLclaimDto.setBrandName(registDto.getPrpLregistDto().getBrandName());
        prpLclaimDto.setCarKindCode(registDto.getPrpLregistDto().getCarKindCode());
        prpLclaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        //设置立案操作的状态为 新案件登记 (未处理任务)
        prpLclaimDto.setStatus("1");

        //从保单中获得信息
        if (!policyNo.equals("")) { //modify by lym 20060605 for  强三
            //查询保单信息
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
        	//根据出险日期获得出险时的保单信息  
      		//PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo()); 
    		     PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo   //modify by lym 20060605 for  强三
    		     		,registDto.getPrpLregistDto().getDamageStartDate().toString()
						,registDto.getPrpLregistDto().getDamageStartHour()); 
    		     //将险别信息压到页面上
    		    ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
    		    httpServletRequest.setAttribute("damageKindList", damageKindList); 
    		     
                  //add by qinyongli begin  2005-7-19
    		      //得到共保和股东业务信息临分信息
    		      if(policyDto!=null){
    		       	httpServletRequest.setAttribute("coinsFlag", policyDto.getPrpCmainDto().getCoinsFlag());
    		        httpServletRequest.setAttribute("shareHolderFlag", policyDto.getPrpCmainDto().getShareHolderFlag());
    		       
    		        String conditions = "reinsType in ('1','2')  and policyno = '" + registDto.getPrpLregistDto().getPolicyNo()+"'";
    		        BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
    		        ArrayList reins =(ArrayList) blFcoRepolicyFacade.findByConditions(conditions);
    		        if(reins!=null&&reins.size()>0){
    		        	httpServletRequest.setAttribute("tempReinsFlag", "1");
    		        }else{
    		        	httpServletRequest.setAttribute("tempReinsFlag", "0");
    		        }
                    
                    //添加保单信息 2005-9-26
                    //由于业务对运输方式及工具的存储字段不唯一，所以在此处要做一个处理
                    PrpCmainCargoDto prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
                    uiCodeAction = new UICodeAction();
                    if (prpCmainCargoDto != null) {
                        if (prpCmainCargoDto.getBLNo() == null
                            || prpCmainCargoDto.getBLNo() == "") {
                            prpCmainCargoDto.setBLNo(uiCodeAction.translateCodeCode("ConveyanceType",
                                                      prpCmainCargoDto.getConveyance(), true));
                        }
                   }
                    httpServletRequest.setAttribute("prpCmainCargoDto", prpCmainCargoDto);
                    /**
                     * 获取默认的险别设置到Request中
                     */
                    String defaultKindCode = getDefaultKindCodeByPolicyDto(policyDto);
                    httpServletRequest.setAttribute("defaultKindCode",defaultKindCode);
    		    }
    		     //add by qinyongli  end  2005-7-19 
            prpLclaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
            prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
            //prpLclaimDto.setStartDate(new DateTime(policyDto.getPrpCmainDto().getStartDate().toString(),
            //        DateTime.YEAR_TO_DAY));
            //prpLclaimDto.setEndDate(new DateTime(policyDto.getPrpCmainDto().getEndDate().toString(),
             //       DateTime.YEAR_TO_DAY));
            prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
            prpLclaimDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
            prpLclaimDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());

            prpLclaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
            prpLclaimDto.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
            prpLclaimDto.setBusinessNature(policyDto.getPrpCmainDto().getBusinessNature());
            prpLclaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
            prpLclaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
            prpLclaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
            //prpLclaimDto.setStartHour(policyDto.getPrpCmainDto().getStartHour()); //add by liuyanmei 20051114
                 prpLclaimDto.setStartDate(policyDto.getPrpCmainDto().getStartDate());
                 prpLclaimDto.setEndDate(policyDto.getPrpCmainDto().getEndDate());
                 prpLclaimDto.setStartHour (policyDto.getPrpCmainDto().getStartHour ());
                 prpLclaimDto.setEndHour (policyDto.getPrpCmainDto().getEndHour ());
            prpLclaimDto.setAgentCode(policyDto.getPrpCmainDto().getAgentCode());
            claimDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
            //add start by qingyongli 2005-7-28
            prpLclaimDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
            prpLclaimDto.setUnderWriteEndDate(policyDto.getPrpCmainDto().getUnderWriteEndDate());
            httpServletRequest.setAttribute("liabStartDate", policyDto.getLiabStartDate());
            //add end by qingyongli 2005-7-28
        }
        //modify by qinyongli add 20050720 start
        UIConfigAction uiConfigAction = new UIConfigAction();
        //获取系统设置信息：立案天数
        String standardDays = "" ; //获取立案天数
        standardDays = uiConfigAction.getConfigValue("CLAIM_DAYS",prpLclaimDto.getRiskCode());
        if(standardDays==null||standardDays.equals("")){
        	throw new UserException(1,3,"platform","请联系系统管理员，在平台配置系统中进行险种"+prpLclaimDto.getRiskCode()+"'立案天数'的初始化！");
        }
        //当前时间减去报案时间
        DateTime currentDate = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY);
        DateTime registDate = registDto.getPrpLregistDto().getReportDate();
        httpServletRequest.setAttribute("registDate", registDate);
        httpServletRequest.setAttribute("standardDays", standardDays);
        long current_regist = (currentDate.getTime()-registDate.getTime())/(1000*60*60*24);
        
        if(current_regist>=Integer.parseInt(standardDays)){
        	httpServletRequest.setAttribute("claim_days", "0");//0表示立案天数大于系统规定时间，进行提示
        }else{
        	httpServletRequest.setAttribute("claim_days", "1");//0表示立案天数小于系统规定时间，不进行提示
        }
        //modify by qinyongli add 20050720 end
        //设置相关代码的中文转换
        changeCodeToName(prpLclaimDto);
        //设置窗体表单中各个多选框中的内容
        setSelectionList(httpServletRequest, prpLclaimDto);
        //查询相同保单号的出险次数
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLclaimDto.getPolicyNo(),prpLclaimDto.getRegistNo());

        //设置巨灾代码信息
        prpLclaimDto.setCatastropheCode1(registDto.getPrpLregistDto().getCatastropheCode1());
        prpLclaimDto.setCatastropheName1(registDto.getPrpLregistDto().getCatastropheName1());
        prpLclaimDto.setCatastropheCode2(registDto.getPrpLregistDto().getCatastropheCode2());
        prpLclaimDto.setCatastropheName2(registDto.getPrpLregistDto().getCatastropheName2());
        
        //设置主立案信息内容到窗体表单
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        
        //在界面上显示险种名称 2005-09-09
        uiCodeAction = new UICodeAction();
        httpServletRequest.setAttribute("riskCName", uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(), true));
        
        //Modify by chenrenda add end 20050408
        //Reason:损失部位显示改为列表框方式
        httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
        //Modify by chenrenda add end 20050408

        //Modify by chenrenda add begin 20050418
        //Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
        String strPrpLnodeType = "claim";
        httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
        //Modify by chenrenda add end 20050418
      
        //add by qinyongli start 2005-8-16
        //reason:获取危险单位信息
        UIRiskUnitAction blPrpCdangerUnitFacade = new UIRiskUnitAction();
        PrpCdangerUnitDto prpCdangerUnitDto = blPrpCdangerUnitFacade.findByPrimaryKeyFromPrpCdangerUnit(policyNo,1
        		,httpServletRequest,riskCode);  //modify by lym 20060605 for  强三
        PrpLdangerUnitDto prpLdangerUnitDto = new PrpLdangerUnitDto();
        if(prpCdangerUnitDto!=null){
            prpLdangerUnitDto.setAddressName(prpCdangerUnitDto.getAddressName());
            prpLdangerUnitDto.setDangerDesc(prpCdangerUnitDto.getDangerDesc()); 
            prpLdangerUnitDto.setPolicyNo(prpCdangerUnitDto.getPolicyNo());
            prpLdangerUnitDto.setRiskCode(prpCdangerUnitDto.getRiskCode());
            prpLdangerUnitDto.setCurrency(registDto.getPrpLregistDto().getEstiCurrency());
            uiCodeAction = new UICodeAction();
            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(registDto.getPrpLregistDto().getEstiCurrency(), true)); //用此字段表示币别中文信息
        }
        httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
        //add by qinyongli end 2005-8-16
         
        //设置各个子表信息项到窗体表单

        //给报案文件多行列表准备数据
        claimDto.setPrpLdriverDtoList(registDto.getPrpLdriverDtoList());
        claimDto.setPrpLthirdCarLossDtoList(registDto.getPrpLthirdCarLossDtoList());
        claimDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
        claimDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
        
        //添加人伤跟踪信息 2005-07-26
        claimDto.setPrpLpersonTraceDtoList(registDto.getPrpLpersonTraceDtoList());
        
        //因为是新录入，所以都是空的。
        ArrayList arrayList = new ArrayList();
        claimDto.setPrpLclaimFeeDtoList(arrayList);
        claimDto.setPrpLdocDtoList(arrayList);
        claimDto.setPrpLltextDtoList(arrayList);
        claimDto.setPrpLltextDtoList(list);
        
        //给立案信息理赔联系记录多行列表准备数据
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
        prpLregistExtDto.setRiskCode(riskCode);  //modify by lym 20060605 for  强三
        arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
        prpLregistExtDto.setRegistExtList(arrayListRegistExt);
        httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
        
        //准备自表信息
        claimDto.setPrpLclaimDto(prpLclaimDto);
        setSubInfo(httpServletRequest, claimDto);

        //设置默认的估损金额的子表金额信息
       
        setFirstClaimFeeLoss(httpServletRequest, prpLclaimDto,strRiskType);
        httpServletRequest.setAttribute("prpLacciPersonDto", claimDto.getPrpLacciPersonDto() == null
                ? new PrpLacciPersonDto()
                : claimDto.getPrpLacciPersonDto());
        //索赔申请人
         // httpServletRequest.setAttribute("prpLacciPersonDtoList", claimDto.getPrpLacciPersonDtoList() == null
           //     ? new ArrayList()
            //   : claimDto.getPrpLacciPersonDtoList());
        if(claimDto.getPrpLclaimLossDtoList()==null){
            claimDto.setPrpLclaimLossDtoList(new ArrayList());
         }
        
        //意健险在提交前，所有的申请调查应该已经提交。  2005-08-04
         	//strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLclaimDto.getRiskCode());
			
			if ("E".equals(strRiskType)) {  
        //modify by   项目组  孙兆云  险类27修改为07
       // if (prpLclaimDto.getRiskCode().substring(0, 2).equals("07")) {     
        	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	int intCount = 0;     //没有提交的申请调查数目
        	String strFlowID = httpServletRequest.getParameter("swfLogFlowID");
        	String strSql = " FLOWID='" + strFlowID + "' and NODETYPE='check' and NODESTATUS<>'4'";
        	intCount = uiWorkFlowAction.findNodesByConditions(strSql).size();
        	httpServletRequest.setAttribute("com.sinosoft.acciFlag", intCount>0?"N":"Y");   //设置一个标志位：N表示不能提交，Y表示可以提交。
        }
        
        //获取兑换率信息 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction();       
        prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime().current().toString().substring(0,10));
        httpServletRequest.setAttribute("prpdexchDtoList",prpdexchDtoList); 
        httpServletRequest.setAttribute("claimDto", claimDto);
        return prpLclaimDto;
    }

    /**
     * 填写立案页面及查询立案request的生成. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */

    public void claimDtoToView(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
        //查询立案信息
    	UIClaimAction uiClaimAction = new UIClaimAction();
        
        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
       
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        //给prpLclaimDto赋值
        if (claimDto.getPrpLclaimDto() == null) {
            String msg = "案件'" + claimNo + "'无法查询到！";
            throw new UserException(1, 3, "查询", msg);
        }
        prpLclaimDto = claimDto.getPrpLclaimDto();
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
        String timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageStartHour());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageEndHour());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        
        //区分逃逸和全损
        String strTemp = prpLclaimDto.getEscapeFlag();
        if ((strTemp.length() > 0) && (strTemp.substring(0, 1) != null)) {
            prpLclaimDto.setEscapeFlag(strTemp.substring(0, 1));
        }
        if ((strTemp.length() > 1) && (strTemp.substring(1, 2) != null)) {
            prpLclaimDto.setEscapeFlag2(strTemp.substring(1, 2));
        }

        //设置立案操作的状态为 案件修改 (正处理任务)
        if (claimDto.getPrpLclaimStatusDto() != null) {
            if (claimDto.getPrpLclaimStatusDto().getStatus().equals("7"))
                claimDto.getPrpLclaimStatusDto().setStatus("3");
            prpLclaimDto.setStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        } else {
            //已提交，已经处理完毕的状态
            prpLclaimDto.setStatus("4");
        }

        /*
         * 从保单中获得信息 原因：因为这些保单信息都已经保存到立案表信息中了，故注掉，但是因为需要转换界面上的 车辆信息，所以仍需要去取保单和下面的车辆信息这一个过程。
         */
         
        if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
            //查询保单信息
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    		//根据出险时间还原保单信息
        	//PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()); 
        	  PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
        	  		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour());
        	//将险别信息压到页面上
  		    ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
  		    httpServletRequest.setAttribute("damageKindList", damageKindList);   
        	  
            PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
            /**
             * 获取默认的险别设置到Request中
             */
            String defaultKindCode = getDefaultKindCodeByPolicyDto(policyDto);
            httpServletRequest.setAttribute("defaultKindCode",defaultKindCode);
            
            if (policyDto.getPrpCitemCarDtoList().size() > 0) {
                //对车型等信息的支持
                PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
                prpLclaimDto.setClauseType(PrpCitemCarDto.getClauseType());
                prpLclaimDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
                prpLclaimDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
                prpLclaimDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
                prpLclaimDto.setBrandName(PrpCitemCarDto.getBrandName());
                prpLclaimDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
                httpServletRequest.setAttribute("liabStartDate", policyDto.getLiabStartDate());
            }
            
            //添加保单信息 2005-9-26
            //由于业务对运输方式及工具的存储字段不唯一，所以在此处要做一个处理
            PrpCmainCargoDto prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
            UICodeAction uiCodeAction = new UICodeAction();
            if (prpCmainCargoDto != null) {
                if (prpCmainCargoDto.getBLNo() == null
                    || prpCmainCargoDto.getBLNo() == "") {
                    prpCmainCargoDto.setBLNo(uiCodeAction.translateCodeCode("ConveyanceType",
                                              prpCmainCargoDto.getConveyance(), true));
                }
           }
            httpServletRequest.setAttribute("prpCmainCargoDto", prpCmainCargoDto);
        }
        //设置相关代码的中文转换
        changeCodeToName(prpLclaimDto);
        //设置窗体表单中各个多选框中列表信息的内容
        setSelectionList(httpServletRequest, prpLclaimDto);
        //查询相同保单号的出险次数
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLclaimDto.getPolicyNo(),prpLclaimDto.getRegistNo());
       
        //add by qinyongli start 2005-8-16
	    //reason:获取危险单位信息
		UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
	    PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo(),1,httpServletRequest,claimDto.getPrpLclaimDto().getRiskCode(),0);
	    UICodeAction uiCodeAction = new UICodeAction();
	    if(prpLdangerUnitDto!=null&&prpLdangerUnitDto.getCurrency()!=null&&!prpLdangerUnitDto.getCurrency().equals("")){
            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); //用此字段表示币别中文信息
	    }
        if(prpLdangerUnitDto==null){
        	prpLdangerUnitDto = new PrpLdangerUnitDto();
        }
	    
	    httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
	    //add by qinyongli end 2005-8-16
        
	    //Modify by chenrenda add begin 20050418
        //Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
        String strPrpLnodeType = "claim";
        httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
        //Modify by chenrenda add end 20050418

        //设置各个子表信息项到窗体表单
        claimDto.setPrpLpersonTraceDtoList(claimDto.getPrpLpersonTraceDtoList());
        setSubInfo(httpServletRequest, claimDto);
        httpServletRequest.setAttribute("prpLacciPersonDto", claimDto.getPrpLacciPersonDto() == null
                ? new PrpLacciPersonDto()
                : claimDto.getPrpLacciPersonDto());
        //显示立案日期和现在日期之间的工作日天数
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
        DateTime registDate = registDto.getPrpLregistDto().getReportDate();
        
        //add by zhaolu start at 2006-06-09
        //reason 强制保单关联信息写到立案中
         System.out.println("强制保单关联信息写到立案中----------1327");
	     System.out.println(registDto.getPrpLRegistRPolicyList().size());
		 System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
		  httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		  //add by zhaolu end at 2006-06-09
        httpServletRequest.setAttribute("registDate", registDate);
        //立案环节增加理赔联系记录
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
        prpLregistExtDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        arrayListRegistExt = claimDto.getPrpLregistExtDtoList();       
        prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
        httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
        
        //原因：添加出险人员信息
        if (registDto.getPrpLacciPersonDto() != null) {
            prpLclaimDto.setAcciCode(registDto.getPrpLacciPersonDto().getAcciCode());
            prpLclaimDto.setAcciName(registDto.getPrpLacciPersonDto().getAcciName());
            prpLclaimDto.setSex(registDto.getPrpLacciPersonDto().getSex());
            prpLclaimDto.setAge(registDto.getPrpLacciPersonDto().getAge());
            prpLclaimDto.setIdentifyNumber(registDto.getPrpLacciPersonDto().getIdentifyNumber());
            prpLclaimDto.setFamilyNo(registDto.getPrpLacciPersonDto().getFamilyNo());
        }
        
        //意健险在提交前，所有的申请调查应该已经提交。   2005-08-04
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLclaimDto.getRiskCode());
		if ("E".equals(strRiskType)) {
        	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	int intCount = 0;     //没有提交的申请调查数目
        	String strFlowID = httpServletRequest.getParameter("swfLogFlowID");
        	String strSql = " FLOWID='" + strFlowID + "' and NODETYPE='check' and NODESTATUS<>'4'";
        	intCount = uiWorkFlowAction.findNodesByConditions(strSql).size();
        	httpServletRequest.setAttribute("com.sinosoft.acciFlag", intCount>0?"N":"Y");   //设置一个标志位：N表示不能提交，Y表示可以提交。
        }
        
        httpServletRequest.setAttribute("claimDto", claimDto);
        
        //缺省带出报案的币别 2005-09-05
        prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
        
        //获取兑换率信息 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction(); 
        //进行币别转化，得到中文名称
        uiCodeAction = new UICodeAction();
        String strCurrencyName = uiCodeAction.translateCurrencyCode(prpLclaimDto.getEstiCurrency(), true);
        httpServletRequest.setAttribute("strCurrencyName", strCurrencyName);
        prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime().current().toString().substring(0,10));
        httpServletRequest.setAttribute("prpdexchDtoList",prpdexchDtoList); 
        
        //设置主立案信息内容到窗体表单
        if(claimDto.getPrpLextDto()==null){
             httpServletRequest.setAttribute("prpLextDto", new PrpLextDto());
        }else{
             httpServletRequest.setAttribute("prpLextDto", claimDto.getPrpLextDto());   
        }
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
        
        //在界面上显示险种名称 2005-09-09
        httpServletRequest.setAttribute("riskCName", uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(), true));
      
        //索赔申请人start------------------------
        
        ArrayList prpLacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
        PrpLacciPersonDto  prpLacciPersonDto = new PrpLacciPersonDto();
       	prpLacciPersonDto.setPrpLacciPersonList(prpLacciPersonDtoList);
        httpServletRequest.setAttribute("prpLacciPersonDto",prpLacciPersonDto); 
        httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto()); 
       
        //索赔申请人end-------------------------------------
    }

    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo)
            throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "'";
        //查询立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();

        //得到多行报案主表信息
        Collection claimList = new ArrayList();      

        claimList = (Collection) uiClaimAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);

        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }
    
    //add by zhaolu 20060802 start
    //立案查询分页 
    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto, String pageNo,
			String recordPerPage) throws Exception {
		// 根据输入的保单号，赔案号生成SQL where 子句
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		int intPageNo = Integer.parseInt(pageNo);
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		// Modify by chenrenda update begin 20050316
		// Reason:在查询立案任务中增加"报案号"查询条件
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("prplclaim.claimNo", claimNo,
						workFlowQueryDto.getClaimNoSign());
		conditions = conditions
				+ StringConvert.convertString("prplclaim.policyNo", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		conditions = conditions
				+ StringConvert.convertString("prplclaim.registNo", registNo,
						workFlowQueryDto.getRegistNoSign());
		conditions = conditions
				+ StringConvert.convertString("prplregist.licenseNo",
						licenseNo, workFlowQueryDto.getLicenseNoSign());
		// 添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("prplregist.InsuredName",
						insuredName, workFlowQueryDto.getInsuredNameSign());

		// add by lixiang start at 2006-02-14
		// reason:当查询注销，拒赔数据的时候，没有查询到结果
		// 想法是从status中查询6和7的状态 6-注销， 7-拒赔

		String strTempStatus = "";
		String caseType = "";
		String statusTemp = status;

		if (statusTemp.indexOf("2") >= 0) {
			strTempStatus = strTempStatus + "2,";
		}
		if (statusTemp.indexOf("4") >= 0) {
			strTempStatus = strTempStatus + "4,";
		}
		if (statusTemp.indexOf("6") >= 0) {
			caseType = caseType + "0,";
		}

		if (statusTemp.indexOf("7") >= 0) {
			caseType = caseType + "1,";
		}
		if (statusTemp.indexOf("8") >= 0) {
			caseType = caseType + "2,";
		}

		// 去掉最后的一个","
		if (!caseType.equals("")) {
			caseType = caseType.substring(0, caseType.length() - 1);
			conditions = conditions + " AND (prplclaim.caseType in ("
					+ caseType + ")) ";

		}

		if (!strTempStatus.equals("")) {
			strTempStatus = strTempStatus.substring(0,
					strTempStatus.length() - 1);
			conditions = conditions + " AND (b.status in (" + strTempStatus
					+ ")) ";

		}
		// if (status.trim().length() > 0) {
		// conditions = conditions + " AND (b.status in ('" + status + "')) ";
		// }

		// add by lixiang end at 2006-02-14

		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		// 拼权限
		
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
	
		/*
		 * conditions = conditions +
		 * uiPowerInterface.addPower(userDto.getUserCode(),
		 * com.sinosoft.claim.util.BusinessRuleUtil
		 * .transTaskCode(httpServletRequest.getParameter("nodeType")), "a",
		 * BusinessRuleUtil .getOuterCode(httpServletRequest, "RISKCODE_DAA"));
		 */
		//modify by zhaolu 20060816 start
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
        //modify by zhaolu 20060816 end
		String condition = httpServletRequest.getParameter("condition");
		if (condition != null && condition.trim().length() > 0) {
			conditions = condition;
		}
		// 根据sql字句形成记录
		setPrpLclaimDtoToView(httpServletRequest, conditions, intPageNo,
				intRecordPerPage);
	}
    
    
    
    public PrpLclaimDto setPrpLclaimDtoToView(
			HttpServletRequest httpServletRequest, String conditions,
			int pageNo, int recordPerPage) throws Exception {
		// 查询立案信息
      
		UIClaimAction uiClaimAction = new UIClaimAction();
		// 得到多行报案主表信息
		ArrayList claimList = new ArrayList();
		PageRecord pageRecord = (PageRecord) uiClaimAction
				.findByQueryConditions(conditions, pageNo, recordPerPage);
		claimList = (ArrayList) pageRecord.getResult();
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(claimList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);

		// Collection claimList = new ArrayList();
		// claimList = (Collection)
		// uiClaimAction.findByQueryConditions(conditions);
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto.setTurnPageDto(turnPageDto);
		prpLclaimDto.setClaimList(claimList);
		prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
		prpLclaimDto.setWhereString(conditions);
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
		return prpLclaimDto;
		// httpServletRequest.setAttribute("")
	}
    //add by zhaolu 20060802 end
    
    
    
    
    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */


    public void registTimeOut(HttpServletRequest httpServletRequest) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
         String conditions = "";
        DateTime dateTime = new DateTime(new Date(), DateTime.YEAR_TO_DAY);
        DateTime.setDateDelimiter("-");
      //conditions = " registno not in (select registno from prplclaim) and ReportDate < '" + dateTime + "'";
        //已超时的报案：报案时间-出险时间>＝48小时
        conditions = " ((ReportDate-DamageStartDate)*24+(substr(ReportHour,1,2 )-substr(DamageStartHour,1,2 )))>48";
            //add by qinyongli 2005-10-24增加查询条件
        String registNo = httpServletRequest.getParameter("RegistNo");
        String registNoSign = httpServletRequest.getParameter("RegistNoSign");
        String policyNo = httpServletRequest.getParameter("PolicyNo");
        String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
        String insuredName = httpServletRequest.getParameter("InsuredName");
        String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
        String riskCode = httpServletRequest.getParameter("RiskCode");
        String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");

        //整理查询条件
        if(registNo!=null&&!registNo.equals("")||policyNo!=null&&!policyNo.equals("")
        		||insuredName!=null&&!insuredName.equals("")||riskCode!=null&&!riskCode.equals("")){
        	conditions = conditions + " and ( 1=1 ";
            conditions = conditions + StringConvert.convertString("prplclaim.registNo", registNo, registNoSign);
            conditions = conditions + StringConvert.convertString("prplclaim.policyNo", policyNo, policyNoSign);
            conditions = conditions + StringConvert.convertString("prplclaim.insuredName", insuredName, insuredNameSign);
            conditions = conditions + StringConvert.convertString("prplclaim.riskCode", riskCode, riskCodeSign);
            conditions = conditions + ")";
        }
        //add end
        
       
        //       拼权限

        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
        
        //conditions = conditions
        //         + uiPowerInterface.addPower(userDto.getUserCode(), "lpba", "prplregist", BusinessRuleUtil.getOuterCode(
        //                httpServletRequest, "RISKCODE_DAA"));
//      从翻页取数据
	       String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	       }
        //查询立案信息
        UIRegistAction uiRegistAction = new UIRegistAction();

        //得到多行报案主表信息
//      得到多行报案主表信息
		ArrayList registList = new ArrayList();
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        if(pageNo==null||pageNo.trim().equals("")) 
        	pageNo = "1";
        int intRecordPerPage=Integer.parseInt(recordPerPage) ;
        int intPageNo=Integer.parseInt(pageNo) ;
        
		PageRecord pageRecord = (PageRecord) uiRegistAction
				.findByQueryConditions(conditions, pageNo, recordPerPage);
		registList = (ArrayList) pageRecord.getResult();
		prpLregistDto.setRegistList(registList);

		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(registList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		
		prpLregistDto.setTurnPageDto(turnPageDto);
		// //System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
    }
    //modify by liuyanmei add 20051108 start
    public void claimTimeOut(HttpServletRequest httpServletRequest) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        
    	//add by zhaolu 20060803 start
    	String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        if(pageNo==null) pageNo = "1";
        int intRecordPerPage=Integer.parseInt(recordPerPage) ;
        int intPageNo=Integer.parseInt(pageNo) ;
        //add by zhaolu 20060803 end
    	
    	
    	
        String conditions = "";
        DateTime dateTime = new DateTime(new Date(), DateTime.YEAR_TO_DAY);
        DateTime.setDateDelimiter("-");

        //conditions = " registno not in (select registno from prplclaim) and ReportDate < '" + dateTime + "'";
        
        //已超时的报案：立案时间-报案时间>＝48小时
        conditions = " ((prplclaim.inputDate-prplregist.reportDate)*24+(substr(prplclaim.inputDate,1,2 )-substr(prplregist.ReportHour,1,2 )))>168";
            //add by qinyongli 2005-10-24增加查询条件
        String claimNo = httpServletRequest.getParameter("ClaimNo");
        String claimNoSign = httpServletRequest.getParameter("ClaimNoSign");
        String policyNo = httpServletRequest.getParameter("PolicyNo");
        String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
        String insuredName = httpServletRequest.getParameter("InsuredName");
        String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
        String riskCode = httpServletRequest.getParameter("RiskCode");
        String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");
        //整理查询条件
        if(claimNo!=null&&!claimNo.equals("")||policyNo!=null&&!policyNo.equals("")
        		||insuredName!=null&&!insuredName.equals("")||riskCode!=null&&!riskCode.equals("")){
        	conditions = conditions + " and ( 1=1 ";
            conditions = conditions + StringConvert.convertString("prplclaim.claimNo", claimNo, claimNoSign);
            conditions = conditions + StringConvert.convertString("prplclaim.policyNo", policyNo, policyNoSign);
            conditions = conditions + StringConvert.convertString("prplclaim.insuredName", insuredName, insuredNameSign);
            conditions = conditions + StringConvert.convertString("prplclaim.riskCode", riskCode, riskCodeSign);
            conditions = conditions + ")";
        }
        //add end
       
        //       拼权限
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
		
        //modify by zhaolu 20060816 start
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
	 if (userDto==null){

	 	}
	    
        conditions = conditions + uiPowerInterface.addPower(userDto,"prplregist","","ComCode");
	
        conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
	   
        //	modify by zhaolu 20060816 end
        //add by zhaolu 20060803 start
        //从翻页取数据
        String condition = httpServletRequest.getParameter("condition");
        if(condition!=null && condition.trim().length()>0){ 
           conditions = condition;
         }
        //add by zhaolu 20060803 end
        //查询立案信息
        //UIRegistAction uiRegistAction = new UIRegistAction();
        UIClaimAction uiClaimAction = new UIClaimAction();
      System.out.println("--------conditions------"+conditions);
        //得到多行报案主表信息
        //modify  by zhaolu 20060803 start
        //Collection claimList = new ArrayList();
         ArrayList claimList = new ArrayList();
         PageRecord pageRecord = uiClaimAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
         claimList = (ArrayList)pageRecord.getResult();
        //claimList = (Collection) uiClaimAction.findByQueryConditions(conditions);
         TurnPageDto turnPageDto = new TurnPageDto();
         //查询出来的一页的结构集 
         turnPageDto.setResultList(claimList);
         //当前页号
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //一页的条数
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //查询出来的结果的总数
         turnPageDto.setTotalCount(pageRecord.getCount());
         //返回总的页数
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //搜索条件
         turnPageDto.setCondition(conditions); 
         //modify by zhaolu 20060803 end
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);
        //add by zhaolu 20060803 start
        prpLclaimDto.setTurnPageDto(turnPageDto);
        //add by zhaolu 20060803 end
        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }
    //modify by liuyanmei add 20051108 end 
    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @param status 状态
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo,
            String status) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);
        status = StringUtils.rightTrim(status);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "' AND flag ='"
                + status + "'";
        //查询立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();

        //得到多行报案主表信息
        Collection claimList = new ArrayList();

        claimList = (Collection) uiClaimAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);

        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }
    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @param status 状态
     * @param usercode 用户编码
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo,
            String status, String userCode) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);
        status = StringUtils.rightTrim(status);
        userCode = StringUtils.rightTrim(userCode);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "' AND flag ='"
                + status + "' AND handlerCode ='" + userCode + "'";
        //查询立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();

        //得到多行报案主表信息
        Collection claimList = new ArrayList();
        claimList = (Collection) uiClaimAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);
        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * 根据PrpClaimDto中的各子表内的信息填充界面lixiang
     * 
     * @param httpServletRequest 返回给页面的request
     * @param prpClaimDto 立案的数据类
     * @throws Exception
     */

    private void setSubInfo(HttpServletRequest httpServletRequest, ClaimDto claimDto) throws Exception {
        String strCurrency = "";
        String strCurrencyName = "";
        UICodeAction uiCodeAction = new UICodeAction();

        //(1).[涉案车辆]给三者车辆多行列表准备数据
        Collection arrayList = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
        arrayList = claimDto.getPrpLthirdPartyDtoList();
        prpLthirdPartyDto.setThirdPartyList(arrayList);

        httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

        //(2).[驾驶员]给驾驶员多行多行列表准备数据
        Collection arrayListDriver = new ArrayList();
        PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
        arrayListDriver = claimDto.getPrpLdriverDtoList();
        prpLdriverDto.setDriverList(arrayListDriver);
        httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
        //(3).[查勘信息]给报案文件多行列表准备数据
        PrpLltextDto prpLltextDto = new PrpLltextDto();
        String tempContext = "";
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(claimDto.getPrpLclaimDto().getRiskCode());
		
		
        if (claimDto.getPrpLltextDtoList() != null) {
            Iterator iterator = claimDto.getPrpLltextDtoList().iterator();
            while (iterator.hasNext()) {
                PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
                //add by qinyongli start 2005-9-6
                //对意键险的出险摘要进行单独处理
                //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("07")){
                if ("E".equals(strRiskType)) {
                	//}//目前先注释掉，解决出现摘要丢失的问题 huangyunzhong 20051026
                	tempContext = tempContext + prpLltextDtoTemp.getContext();
                //add end by qinyongli
                }else{
                    tempContext = tempContext + prpLltextDtoTemp.getContext();
                }
                
            }
        }
        prpLltextDto.setContext(tempContext);
        prpLltextDto.setTextType("09");
        httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
        //(4).[估损金额]给估损金额文件多行列表准备数据
        Collection claimFeeList = new ArrayList();
        Collection claimFeeList1 = new ArrayList();

        PrpLclaimFeeDto prpLclaimFeeDto = new PrpLclaimFeeDto();

        claimFeeList = claimDto.getPrpLclaimFeeDtoList();

        Iterator it = claimFeeList.iterator();

        while (it.hasNext()) {
            prpLclaimFeeDto = (PrpLclaimFeeDto) it.next();
            strCurrency = prpLclaimFeeDto.getCurrency();
            strCurrencyName = uiCodeAction.translateCurrencyCode(strCurrency, true);
            prpLclaimFeeDto.setCurrencyName(strCurrencyName);
            claimFeeList1.add(prpLclaimFeeDto);
        }
        prpLclaimFeeDto.setClaimFeeList(claimFeeList1);

        httpServletRequest.setAttribute("prpLclaimFeeDto", prpLclaimFeeDto);

        //(5).给险别估损金额文件多行列表准备数据
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
        String conditions = "";
        Collection collection = null;
        
        claimLossList = claimDto.getPrpLclaimLossDtoList();
        
        if (claimLossList != null) {
        	
        	System.out.println("============  [ 非空 ]  ================");
            for (int i = 0; i < claimLossList.size(); i++) {
                PrpLclaimLossDto prpLclaimLossDto1 = (PrpLclaimLossDto) claimLossList.get(i);
                if (prpLclaimLossDto1.getInputDate().equals("")) {
                	prpLclaimLossDto1.setInputDate( new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                }
                
                //险别信息应该从prpcitemkind表中带出 2005-09-05
               //conditions = " PolicyNo ='"+ claimDto.getPrpLclaimDto().getPolicyNo()
				//            +"' and ItemKindNo=" + prpLclaimLossDto1.getItemKindNo(); 
              // collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);
//               if (collection != null && collection.size() > 0) {
//                   for (Iterator iter = collection.iterator(); iter.hasNext();) {
//                       PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
//                       prpLclaimLossDto1.setKindName(prpCitemKindDto.getKindName());
//                       System.out.println("测试数据==========" + prpLclaimLossDto1.getKindName() );
//                       break;
//                   }
//               } else {
//                   prpLclaimLossDto1.setKindName(uiCodeAction.translateKindCode(prpLclaimLossDto1.getRiskCode(),
//                		   prpLclaimLossDto1.getKindCode(), true));
//               }    
               prpLclaimLossDto1.setKindName(uiCodeAction.translateKindCode(prpLclaimLossDto1.getRiskCode(),
            		   prpLclaimLossDto1.getKindCode(), true));
                
                //add by qinyongli 加入明细名称查询 ,对于意键险
                //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("27")){
                  
                //modify by   项目组  孙兆云  险类27修改为07
               //modify by 孟冬冬  不管哪个险类都要获得险类名称
               //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("07")){
            	   conditions = " PolicyNo ='"+ claimDto.getPrpLclaimDto().getPolicyNo() + "' AND KindCode ='"+ 
            	   prpLclaimLossDto1.getKindCode() +"' and  ItemCode='"+prpLclaimLossDto1.getItemCode()+"' ";
            	   collection = uiCodeAction.findByConditions(UICodeAction.POLICYITEMCODE,conditions,0,0);
            	   if(collection!=null&&collection.size()>0){
            		   Iterator coll = collection.iterator();
            		   while(coll.hasNext()){
            			   PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto)coll.next();
            			   prpLclaimLossDto1.setItemKindName(prpCitemKindDto.getItemDetailName());
            		   }
            	   } 
               //}
            	prpLclaimLossDto.setLossFeeType(prpLclaimLossDto1.getLossFeeType());
                prpLclaimLossDto1.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimLossDto1.getCurrency(),
                        true));
                //prpLclaimLossDto.setKindRest(prpLclaimLossDto1.getKindRest());
                //System.out.println("=============================是不是");System.out.println(prpLclaimLossDto1.getKindRest());System.out.println("==============================");
            }
        }
        prpLclaimLossDto.setClaimLossList(claimLossList);
        httpServletRequest.setAttribute("prpLclaimLossDto", prpLclaimLossDto);

        //(5).[单证信息]给索赔单证文件多行列表准备数据
        Collection docList = new ArrayList();
        PrpLdocDto prpLdocDto = new PrpLdocDto();
        docList = claimDto.getPrpLdocDtoList();
        prpLdocDto.setDocList(docList);
        httpServletRequest.setAttribute("prpLdocDto", prpLdocDto);

        //特别约定信息多行列表准备数据
        Collection arrayListCengageTemp = new ArrayList();
        PrpCengageDto prpCengageDto = new PrpCengageDto();
        arrayListCengageTemp = claimDto.getPrpCengageDtoList();
        ArrayList cengageListTemp = new ArrayList();
        if (arrayListCengageTemp != null) {
            Iterator iteratorCengage = arrayListCengageTemp.iterator();
            while (iteratorCengage.hasNext()) {
                PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage.next();
                if (prpCengageDtoTemp.getClauseCode() != null && prpCengageDtoTemp.getClauseCode().length() > 0
                        && prpCengageDtoTemp.getClauseCode().charAt(0) == 'T') {
                    cengageListTemp.add(prpCengageDtoTemp);
                }
            }
            boolean cFlag = false;
            arrayListCengageTemp = new ArrayList();
            arrayListCengageTemp.addAll(cengageListTemp);
            cengageListTemp = new ArrayList();
            iteratorCengage = arrayListCengageTemp.iterator();
            PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
            while (iteratorCengage.hasNext()) {
                PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage.next();
                if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
                    cFlag = true;
                    cengageListTemp.add(prpCengageDtoTemp1);
                    prpCengageDtoTemp1 = new PrpCengageDto();
                    PropertyUtils.copyProperties(prpCengageDtoTemp1, prpCengageDtoTemp);
                } else {
                    prpCengageDtoTemp1.setContext(prpCengageDtoTemp1.getContext() + prpCengageDtoTemp.getClauses()
                            + "<br>");
                }
            }
            cengageListTemp.add(prpCengageDtoTemp1);
            if (cengageListTemp.size() > 0) {
                cengageListTemp.remove(0);
            }
        }
        prpCengageDto.setPrpCengageList(cengageListTemp);
        httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);

        //Modify by chenrenda add begin 20050408
        //Reason:损失部位模块加进涉案车辆信息中后，相应模块做调整
        Collection arrayListThirdCarLoss = new ArrayList();
        PrpLthirdCarLossDto prpLthirdCarLossDto = new PrpLthirdCarLossDto();
        arrayListThirdCarLoss = claimDto.getPrpLthirdCarLossDtoList();
        prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss);
        httpServletRequest.setAttribute("prpLthirdCarLossDto", prpLthirdCarLossDto);

        //Modify by chenrenda add end 20050408

        //Modify by chenrenda add begin 20050412
        //Reason:在报案页面中加上其它损失模块
        Collection arrayListThirdProp = new ArrayList();
        PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
        arrayListThirdProp = claimDto.getPrpLthirdPropDtoList();
        prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
        httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
        //Modify by chenrenda add end 20050412
        
        //查询保单信息 显示特别约定列表
        String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
        ArrayList itemKindList = new ArrayList();
        Collection itemKindListNew = new ArrayList();
        //根据保单号查询特别约定信息
        if(!policyNo.equals("")&&policyNo!=null)
        {
 			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
 			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
 					,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour()); 

 	        itemKindList = policyDto.getPrpCitemKindDtoList();
        }
        
        // Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
      /* -------------------------------------------------
       *  for(int i=0;i<itemKindList.size();i++)
        {
          PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)itemKindList.get(i);
          prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-" + prpCitemKindDto.getKindName()) ;
          if(prpCitemKindDto.getKindCode().equalsIgnoreCase("B")
          		||prpCitemKindDto.getKindCode().equalsIgnoreCase("D3")
 				||prpCitemKindDto.getKindCode().equalsIgnoreCase("D4")
||prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")
 				||prpCitemKindDto.getKindCode().equalsIgnoreCase("A"))
          {
            //System.out.println("itemKindListoookkk::"+prpCitemKindDto.getKindCode());
            
            itemKindListNew.add(prpCitemKindDto) ;
          }
          
          //System.out.println("itemKindList::"+prpCitemKindDto.getKindCode());
        }
        -------------------------------------------------------*/
        
        ArrayList registRPolicyList = (ArrayList) new  BLPrpLRegistRPolicyFacade().findByRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
        String mainPolicyNo="";
        Collection itemKindListNew1 = new ArrayList();
        Collection itemKindListNew2 = new ArrayList();
        for (Iterator iter = registRPolicyList.iterator(); iter.hasNext();) {
        	PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
        	if ("3".equals(prpLRegistRPolicyDto.getPolicyType())){
        		mainPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
        		break;
        	}
        }
        ArrayList itemKindList1 = new ArrayList(); 	
        if(!mainPolicyNo.equals("")&&mainPolicyNo!=null)
        {
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
        	PolicyDto policyDto1 = endorseViewHelper.findForEndorBefore(mainPolicyNo);
        	itemKindList1 = policyDto1.getPrpCitemKindDtoList();
        }
           
        itemKindListNew1 = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList1);
        itemKindListNew2 = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
        itemKindListNew.addAll(itemKindListNew1 );
        itemKindListNew.addAll(itemKindListNew2 );
        

        
        
        httpServletRequest.setAttribute("referKindList",itemKindListNew);
        
        //给人员伤亡跟踪多行多行列表准备数据
        Collection arrayListPersonTrace = new ArrayList();
        PrpLpersonTraceDto prpLpersonTraceDto  = new PrpLpersonTraceDto();
        arrayListPersonTrace = claimDto.getPrpLpersonTraceDtoList();
        prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace) ;
        prpLpersonTraceDto.setNodeType("check");
        
        if(claimDto.getPrpLpersonTraceDtoList() != null){
         Iterator personTraceDtoList = arrayListPersonTrace.iterator();
         while(personTraceDtoList.hasNext()){
           PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto)personTraceDtoList.next();
           String strReferKind = prplpersonTraceDto.getReferKind();
           prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
         }
       }
        httpServletRequest.setAttribute("prpLpersonTraceDto", prpLpersonTraceDto);

    }

    /**
     * 根据PrpClaimDto中的已经设置的代码内容，对代码进行名称转换
     * 
     * @param httpServletRequest 返回给页面的request
     * @param prpClaimDto 立案的数据类
     * @param ClaimDto 查询出的数据类
     * @throws Exception
     */
    private void changeCodeToName(PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();
        //(1)条款名称的转换
        String clauseType = prpLclaimDto.getClauseType();
        String clauseName = uiCodeAction.translateCodeCode("ClauseType", clauseType, true);
        prpLclaimDto.setClauseName(clauseName);
        //(2)号牌颜色转换
        String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
        String licenseColor = uiCodeAction.translateCodeCode("LicenseColor", licenseColorCodeCode, true);
        prpLclaimDto.setLicenseColor(licenseColor);
        //(3)车辆类型转换
        String carKindCode = prpLclaimDto.getCarKindCode();
        String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode, true);
        prpLclaimDto.setCarKind(carKind);
        
        //(4)对业务归属结构进行转换
        String comCode = prpLclaimDto.getComCode();
        String comName = uiCodeAction.translateComCode(comCode, true);
        prpLclaimDto.setComName(comName);
        //(5)对归属业务员进行转换
        String handler1Code = prpLclaimDto.getHandler1Code();
        String handler1Name = uiCodeAction.translateUserCode(handler1Code, true);
        prpLclaimDto.setHandler1Name(handler1Name);
        //(6)对代理人进行转换
        String agentCode = prpLclaimDto.getAgentCode();
        String agentName = uiCodeAction.translateUserCode(agentCode, true);
        prpLclaimDto.setAgentName(agentName);
        //(7)对经办人进行转换
        String handlerCode = prpLclaimDto.getHandlerCode();
        String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
        prpLclaimDto.setHandlerName(handlerName);
        
        //(8)对案件性质进行转换 2005-08-01
        String strClaimType = prpLclaimDto.getClaimType();
        String strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strClaimType, true);
        prpLclaimDto.setClaimTypeName(strClaimTypeName);
        
        //(9)对业务类型进行转换
        String strBusinessNature = prpLclaimDto.getBusinessNature();
        String strBusinessNatureName = uiCodeAction.translateCodeCode("BusinessNature",strBusinessNature, true);
        prpLclaimDto.setBusinessNatureName(strBusinessNatureName);
        //10)对语种转换
 System.out.println("aaaaaaaaaaaa"+prpLclaimDto.getLanguage());       
        if(prpLclaimDto.getLanguage().equals("C"))
        {
            prpLclaimDto.setLanguageName("中文");
        }
        if(prpLclaimDto.getLanguage().equals("E"))
        {
            prpLclaimDto.setLanguageName("英文");
        }
        //(11)对makeCom进行转换 add by liuyanmei 20051115 
        //reason :itest bug 647 立案任务查询，理赔登记部门显示的只有代码，没有名称。
        String makeCom = prpLclaimDto.getMakeCom();
        String makeComName = uiCodeAction.translateComCode(makeCom, true);
        prpLclaimDto.setMakeComName(makeComName);
        
    }

    /**
     * 获取选择框和列表框中的所有内容
     * 
     * @param httpServletRequest 返回给页面的request
     * @param prpClaimDto 立案的数据类
     * @throws Exception
     */
    private void setSelectionList(HttpServletRequest httpServletRequest, PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();

        //(1)得到立案类型列表
        Collection reportTypes = uiCodeAction.getCodeType("ReportType", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("reportTypes", reportTypes);
        //(2)得到案件种类列表列表
        Collection claimTypes = uiCodeAction.getCodeType("CaseCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("claimTypes", claimTypes);
        //(3)得到出险地址类型列表
        Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
        //(4)得到车辆种类列表
        Collection carKindCodes = uiCodeAction.getCodeType("CarKind", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("carKindCodes", carKindCodes);
        //(5)得到车牌底色列表
        Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
        //(6)得到赔偿责任列表
        Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
        //(7)得到赔案类别列表
        Collection escapeFlags = uiCodeAction.getCodeType("CaseCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("escapeFlags", escapeFlags);
        //(8)得到得到性别
        Collection driverSex = uiCodeAction.getCodeType("SexCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("driverSexs", driverSex);
        //(9)得到职业分类
        Collection driverOccupation = uiCodeAction.getCodeType("Occupation", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("driverOccupations", driverOccupation);
        //(10)得到文化程度
        Collection education = uiCodeAction.getCodeType("Education", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("educations", education);
        //(11)得到理赔类型的列表 --- 目前无法得到
        Collection claimFlagList = new ArrayList();
        claimFlagList.add(new LabelValueBean("理赔", "L"));
        claimFlagList.add(new LabelValueBean("代理赔", "D"));
        httpServletRequest.setAttribute("claimFlagList", claimFlagList);
    }

    /**
     * 查询立案表信息内容的过程，并进行是否可以注销的判断
     * 
     * @param httpServletRequest 返回给页面的request
     * @param Claimno 赔案号码
     * @throws Exception
     */
    public void getClaimCancelInfo(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
        //查询立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();

        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);

        //给prpLclaimDto赋值
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto = claimDto.getPrpLclaimDto();
        //将主表内容的信息放入request中
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * 保存立案注销时立案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return claimDto 立案数据传输数据结构
     * @throws Exception
     */
    public ClaimDto cancelViewToDto(HttpServletRequest httpServletRequest) throws Exception {
    	  //继承对claim,claimsText表的赋值
        ClaimDto claimDto = new ClaimDto();
        HttpSession session = httpServletRequest.getSession();
        UserDto   user     = (UserDto)session.getAttribute("user");
        String claimNo="";
        String caseType="";

        claimNo = (String)httpServletRequest.getParameter("prpLclaimClaimNo");
        String registNo= httpServletRequest.getParameter("prpLclaimRegistNo");
        caseType=((String)httpServletRequest.getParameter("caseType"));
        String cancelReaseon =httpServletRequest.getParameter("prpLclaimContext");
        /*---------------------立案主表prpLclaim------------------------------------*/
        PrpLclaimDto prpLclaimDto =null;
        if ((claimNo==null)||claimNo.equals(""))
        {
         String msg = " 此案件没有立案，可以通知报案人员进行报案注销操作！";
         if ("1".equals(caseType)){
         	 msg = " 此案件没有立案，需要通知立案人员先进行立案后，再申请！";
            
         }
         throw new UserException(1,3,"注销/拒赔",msg);
        
        //产生新立案
        /*	
          prpLclaimDto = registDtoToClaimDto(registNo,user);
          String riskCode = prpLclaimDto.getRiskCode() ;
          String comCode = prpLclaimDto.getComCode() ;
          int year =DateTime.current() .getYear() ;
       //  msg = "没有接收到合法的立案号码！";
       // throw new UserException(1,3,"拒赔",msg);
       //取号过程还需要进一步完善
       UIBillAction uiBillAction = new UIBillAction();
       String tableName = "prplclaim";
       claimNo = uiBillAction.getNo(tableName,riskCode,comCode,year) ;
       prpLclaimDto.setClaimNo(claimNo);
       
      prpLclaimDto.setFlag("1"); //需要插入新的立案数据。
      */
      //需要很多基础数据的。。。。
      
      
        }
        
        claimDtoToView(httpServletRequest, claimNo);
        prpLclaimDto = (PrpLclaimDto)httpServletRequest.getAttribute("prpLclaimDto");
       

        if (prpLclaimDto==null)
        {
          String msg = "没有查询到相关立案！";
          throw new UserException(1,3,"拒赔",msg);
        }
        prpLclaimDto.setFlag("0"); //只update就可以了。。
        
        //设置第一次进入时的默认信息
        //prpLclaimDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDealerCode(user.getUserCode() );
        prpLclaimDto.setDealerName(user.getUserName() );
        prpLclaimDto.setCancelReason("");
        //prpLclaimDto.setCaseType(caseType);
        //用工作流的
        claimDto.setPrpLclaimDto(prpLclaimDto);

       /*---------------------立案注销文本表prpLltext------------------------------------*/
       ArrayList prpLltextDtoList = new ArrayList();
       PrpLltextDto prpLltextDto = null;
       String TextTemp = httpServletRequest.getParameter("prpLclaimContext");
       String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
       
       //得到连接串,下面将其切分到数组
       for (int k = 0; k < rules.length; k++) {
           prpLltextDto = new PrpLltextDto();
           prpLltextDto.setClaimNo(claimNo);
           prpLltextDto.setContext(rules[k]);
           prpLltextDto.setLineNo(k + 1);
           prpLltextDto.setTextType("10");
           prpLltextDtoList.add(prpLltextDto); 
       }

        //装入ClaimDto
       claimDto.setPrpLltextDtoList(prpLltextDtoList);

       /*---------------------立案操作状态内容prpLclaimStatus默认为完成------------------------------------*/
       PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
       prpLclaimStatusDto.setStatus("4");
       prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo() );
       prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
       prpLclaimStatusDto.setNodeType("claim");

       //取得当前用户信息，写操作员信息到实际claimstatus中

      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate() );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode() );
      claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return claimDto;
    }
    /**
     * 展现拒赔申请的页面信息.就是查询
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */

    public void cancelDtoToCancelView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
        String claimNo = httpServletRequest.getParameter("ClaimNo"); //赔案号
        String registNo = httpServletRequest.getParameter("RegistNo"); //赔案号
        UICodeAction uiCodeAction = new UICodeAction();
        String strSql = ""; //查询条件
        String msg = ""; //抛出错误使用的消息传递信息

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //立案Dto对象

        PrpLclaimDto prpLclaimDto = null; //立案Dto对象
        UIClaimAction uiClaimAction = new UIClaimAction();
        UIRegistAction uiRegistAction = new UIRegistAction();
        ClaimDto claimDto = null;

        if ((claimNo == null || claimNo.equals(""))) {
            //产生新的立案数据
            prpLclaimDto = registDtoToClaimDto(registNo, user);

        } else {

            //将立案信息取出
            strSql = " claimno='" + claimNo + "'";
            claimList = uiClaimAction.findByConditions(strSql);
            claimDto = uiClaimAction.findByPrimaryKey(claimNo);
            Iterator it = claimList.iterator();
            if (it.hasNext())
                prpLclaimDto = (PrpLclaimDto) it.next();
        }

        if (prpLclaimDto == null) {
            msg = "没有查询到相关立案！";
            throw new UserException(1, 3, "拒赔", msg);
        }
        
     UICompensateAction	uiCompensateAction = new UICompensateAction();
	ArrayList collection=(ArrayList)uiCompensateAction.findByConditions(" claimno='"+claimNo+"'");
System.out.println(collection.size());	
       for (int i = 0; i < collection.size(); i++) {
	 PrpLcompensateDto prpLcompensateDto  = (PrpLcompensateDto)collection.get(i);
	 if (prpLcompensateDto.getUnderWriteFlag().equals("1")){
           msg = "此赔案已有核赔通过的赔款计算书,不允许注销拒赔！";
       	    throw new UserException(1,3,"注销/拒赔",msg);
		}
     	}

        strSql = "registNo='" + prpLclaimDto.getRegistNo() + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it = registList.iterator();
        if (it.hasNext()) {
            prpLregistDto = (PrpLregistDto) it.next();
        }
        
        //注销/拒赔/不予立案文件多行列表准备数据  2005-08-09
        String tempContext = "";
        PrpLltextDto prpLltextDtoTemp = null;
        if (claimDto.getPrpLltextDtoList() != null) {
            Iterator iterator = claimDto.getPrpLltextDtoList().iterator();
            while (iterator.hasNext()) {
                prpLltextDtoTemp = (PrpLltextDto) iterator.next();
                if (prpLltextDtoTemp.getTextType().equals("10")) {
                    tempContext = tempContext + prpLltextDtoTemp.getContext();
                }
            }
        }
        prpLclaimDto.setCancelReason(tempContext);

        //放信息到request里面。。。
        //转换申请人的姓名
        prpLclaimDto.setDealerCode(user.getUserCode());
        String dealerCode = prpLclaimDto.getDealerCode();
        String dealerName = uiCodeAction.translateUserCode(dealerCode, true);
        prpLclaimDto.setDealerName(dealerName);
        //设置操作状态为ADD,申请登记，很重要的
        String typeFlag=httpServletRequest.getParameter("typeFlag"); //typeFlag
        String flowInTime=httpServletRequest.getParameter("flowInTime"); //申请日期
        
        if (typeFlag!=null){
        	prpLclaimDto.setCaseType(typeFlag );
        }
        if (flowInTime!=null){
        	prpLclaimDto.setCancelDate(new DateTime(flowInTime,DateTime.YEAR_TO_DAY) );
        }
  
        //如果typeflag,flowinTime有数据，则设置 caseType和canceldate
        prpLclaimDto.setEditType("EDIT");
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

    }

    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */

    public void waitToDo(HttpServletRequest httpServletRequest) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句

        String conditions = "";
        //conditions = " nodetype='check' and status='4'";
        conditions = " nodetype='check' and status='4' and businessno not in (select registno from prplcheck)";
        //查询立案信息
        UIClaimStatusAction uiClaimStautsAction = new UIClaimStatusAction();

        //得到多行报案主表信息
        Collection claimStatusList = new ArrayList();
        //    prpLclaimDto.setClaimList(claimList);
        claimStatusList = (Collection) uiClaimStautsAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimStatusList);

        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * 根据报案号,保单号,案件状态，车牌号码，操作时间查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, WorkFlowQueryDto workFlowQueryDto) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
        String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
        String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
        String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
        String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
        String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
        //Modify by chenrenda update begin 20050316
        //Reason:在查询立案任务中增加"报案号"查询条件
        String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());

        String conditions = " 1=1 ";
        conditions = conditions
                + StringConvert.convertString("prplclaim.claimNo", claimNo, workFlowQueryDto.getClaimNoSign());
        conditions = conditions
                + StringConvert.convertString("prplclaim.policyNo", policyNo, workFlowQueryDto.getPolicyNoSign());
        conditions = conditions
                + StringConvert.convertString("prplclaim.registNo", registNo, workFlowQueryDto.getRegistNoSign());
        conditions = conditions
                + StringConvert.convertString("prplregist.licenseNo", licenseNo, workFlowQueryDto.getLicenseNoSign());
        //添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("prplregist.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
        
        //add by lixiang start at 2006-02-14
        //reason:当查询注销，拒赔数据的时候，没有查询到结果
        //想法是从status中查询6和7的状态 6-注销， 7-拒赔
 

            String strTempStatus="";
            String caseType="";
            String statusTemp=status;
            
           	if (statusTemp.indexOf( "2")>=0){
            		strTempStatus=strTempStatus+"2,";
            	}
           	if (statusTemp.indexOf( "4")>=0){
        		  strTempStatus=strTempStatus+"4,";
             }
            	if (statusTemp.indexOf( "6")>=0){
            		caseType=caseType+"0,";
            	}
            		
            	if (statusTemp.indexOf("7")>=0){
            		caseType=caseType+"1,";
            	}
            	if (statusTemp.indexOf("8")>=0){
            		caseType=caseType+"2,";
            	}
          
            
            //去掉最后的一个","
            if (!caseType.equals( "")){
            	caseType = caseType.substring(0,caseType.length()-1) ;
         	   conditions = conditions + " AND (prplclaim.caseType in (" +caseType+ ")) ";
               
            }
            
            if (!strTempStatus.equals("")){
            	strTempStatus = strTempStatus.substring(0,strTempStatus.length()-1) ;
            	   conditions = conditions + " AND (b.status in ('" +strTempStatus+ "')) ";
                   
            }
       //if (status.trim().length() > 0) {
       //     conditions = conditions + " AND (b.status in ('" + status + "')) ";
       // }
            
        //	add by lixiang end at 2006-02-14    
        
        if (operateDate != null && !operateDate.trim().equals("")) {
            conditions = conditions + StringConvert.convertDate("b.operateDate", operateDate, workFlowQueryDto.getOperateDateSign());
        }
        //       拼权限
        //modify by zhaolu 20060816 start
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto,"a","","ComCode");  
         conditions = conditions
               + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
     
       //modify by zhaolu 20060816 end
        //根据sql字句形成记录
        setPrpLclaimDtoToView(httpServletRequest, conditions);
    }

    /**
     * 根据条件查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param 条件内容
     * @throws Exception Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
     */
    public PrpLclaimDto setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String conditions)
            throws Exception {
        //查询立案信息
        UIClaimAction uiClaimAction = new UIClaimAction();
        //得到多行报案主表信息
        Collection claimList = new ArrayList();
        claimList = (Collection) uiClaimAction.findByQueryConditions(conditions);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);
        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        prpLclaimDto.setWhereString(conditions);
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        return prpLclaimDto;
        // httpServletRequest.setAttribute("")
    }
    /**
     * 设置在第一次报案录入立案的时候，将设置默认的估损金额，由于DAA与其它险种的保存内容表不同，所以值也不同
     * 
     * @param httpServletRequest HttpServletRequest
     * @param claimDto ClaimDto
     * @throws Exception
     */

    private void setFirstClaimFeeLoss(HttpServletRequest httpServletRequest, PrpLclaimDto prpLclaimDto,String riskType)
    throws Exception {
UICodeAction uiCodeAction = new UICodeAction();
String strCurrencyName = "";
String strCurrency = "";
String registNo = prpLclaimDto.getRegistNo();

//车险，应该是险类的判断，不应该是按照具体险种进行判断，所以需要要修改。
//modify by lixiang start at 2006-09-13
if ("D".equals(riskType)&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAA"))
		&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAX"))
		&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAT"))) {  
//if (prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAA")) ||
//prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAB")) ||
//	prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAE"))) {
//	modify by lixiang end at 2006-09-13
	
	//估损金额列表
    ArrayList claimLossList = new ArrayList();
    //从报案带过来
    PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
    prpLclaimLossDto.setRiskCode(prpLclaimDto.getRiskCode());
    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
    strCurrency = prpLclaimLossDto.getCurrency();
    strCurrencyName = uiCodeAction.translateCurrencyCode(strCurrency, true);
    prpLclaimLossDto.setCurrencyName(strCurrencyName);
    prpLclaimLossDto.setKindLoss(prpLclaimDto.getSumClaim());
    prpLclaimLossDto.setSumClaim(prpLclaimDto.getSumClaim());
    prpLclaimLossDto.setInputDate(new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY));
     claimLossList.add(prpLclaimLossDto);
    HashMap hashMapTemp = new HashMap();  
   
    //如果已经查勘了，从查勘带估损金额
    UICheckAction uiCheckAction = new UICheckAction();
    CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
    if (checkDto.getPrpLcheckDto() != null) {
        if (checkDto.getPrpLcheckLossDtoList() != null && checkDto.getPrpLcheckLossDtoList().size() > 0) {
            claimLossList = new ArrayList();
            hashMapTemp = new HashMap();
            PrpLcheckLossDto prpLcheckLossDto = null;
            for (int i = 0; i < checkDto.getPrpLcheckLossDtoList().size(); i++) {
                prpLcheckLossDto = (PrpLcheckLossDto) checkDto.getPrpLcheckLossDtoList().get(i);
                //BZ不带入到估损里面
                if ("BZ".equals(prpLcheckLossDto.getKindCode())) continue;
                
                if (hashMapTemp.containsKey(prpLcheckLossDto.getKindCode())) {
                    prpLclaimLossDto = (PrpLclaimLossDto) hashMapTemp.get(prpLcheckLossDto.getKindCode());
                    prpLclaimLossDto.setKindLoss(prpLclaimLossDto.getSumClaim() + prpLcheckLossDto.getLossFee());
                    prpLclaimLossDto
                            .setSumClaim(prpLclaimLossDto.getSumClaim() + prpLcheckLossDto.getLossFee());
                } else {
                    prpLclaimLossDto = new PrpLclaimLossDto();
                    prpLclaimLossDto.setKindCode(prpLcheckLossDto.getKindCode());
                    prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLcheckLossDto.getRiskCode(),
                            prpLcheckLossDto.getKindCode(), true));
                    prpLclaimLossDto.setKindLoss(prpLcheckLossDto.getLossFee());
                    prpLclaimLossDto.setSumClaim(prpLcheckLossDto.getLossFee());
                    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
                    prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimDto
                            .getCurrency(), true));
                   
                }
                hashMapTemp.put(prpLcheckLossDto.getKindCode(), prpLclaimLossDto);
            }
        }
    }

    //立案条件为报案后48小时可立案。立案的估损金额取值方法：当报案后未查勘的案件，估损金额需要立案人员根据报案情况输入；已查勘未定损案件取查勘估损金额；已定损案件取定损金额；已核损通过取核损金额；立案后，查勘/定损/核损/金额/
    UICertainLossAction uiCertainLossAction = new UICertainLossAction();
    CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo);

    //如果已经定损了，从定损带估损金额
    if (certainLossDto.getPrpLverifyLossDtoList() != null
            && certainLossDto.getPrpLverifyLossDtoList().size() > 0) {
        hashMapTemp = new HashMap();
        //修理
        if (certainLossDto.getPrpLrepairFeeDtoList() != null
                && certainLossDto.getPrpLrepairFeeDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLrepairFeeDtoList().size(); i++) {
                PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto) certainLossDto.getPrpLrepairFeeDtoList()
                        .get(i);
                //BZ不带入到估损里面
                if ("BZ".equals(prpLrepairFeeDto.getKindCode())) continue;
                if (hashMapTemp.containsKey(prpLrepairFeeDto.getKindCode())) {
                    prpLclaimLossDto = (PrpLclaimLossDto) hashMapTemp.get(prpLrepairFeeDto.getKindCode());
                    prpLclaimLossDto.setKindLoss(prpLclaimLossDto.getSumClaim()
                            + prpLrepairFeeDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLclaimLossDto.getSumClaim()
                            + prpLrepairFeeDto.getSumDefLoss());
                } else {
                    prpLclaimLossDto = new PrpLclaimLossDto();
                    prpLclaimLossDto.setKindCode(prpLrepairFeeDto.getKindCode());
                    prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLrepairFeeDto.getRiskCode(),
                            prpLrepairFeeDto.getKindCode(), true));
                    prpLclaimLossDto.setKindLoss(prpLrepairFeeDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLrepairFeeDto.getSumDefLoss());
                    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
                    prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimDto
                            .getCurrency(), true));
                }
                hashMapTemp.put(prpLrepairFeeDto.getKindCode(), prpLclaimLossDto);
            }
        }
        //换件
        if (certainLossDto.getPrpLcomponentDtoList() != null
                && certainLossDto.getPrpLcomponentDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLcomponentDtoList().size(); i++) {
                PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto) certainLossDto.getPrpLcomponentDtoList()
                        .get(i);
                //BZ不带入到估损里面
                if ("BZ".equals(prpLcomponentDto.getKindCode())) continue;
                if (hashMapTemp.containsKey(prpLcomponentDto.getKindCode())) {
                    prpLclaimLossDto = (PrpLclaimLossDto) hashMapTemp.get(prpLcomponentDto.getKindCode());
                    prpLclaimLossDto.setKindLoss(prpLclaimLossDto.getSumClaim()
                            + prpLcomponentDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLclaimLossDto.getSumClaim()
                            + prpLcomponentDto.getSumDefLoss());
                } else {
                    prpLclaimLossDto = new PrpLclaimLossDto();
                    prpLclaimLossDto.setKindCode(prpLcomponentDto.getKindCode());
                    prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLcomponentDto.getRiskCode(),
                            prpLcomponentDto.getKindCode(), true));
                    prpLclaimLossDto.setKindLoss(prpLcomponentDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLcomponentDto.getSumDefLoss());
                    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
                    prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimDto
                            .getCurrency(), true));
                }
                hashMapTemp.put(prpLcomponentDto.getKindCode(), prpLclaimLossDto);
            }
        }
        //人员
        if (certainLossDto.getPrpLpersonDtoList() != null && certainLossDto.getPrpLpersonDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLpersonDtoList().size(); i++) {
                PrpLpersonDto prpLpersonDto = (PrpLpersonDto) certainLossDto.getPrpLpersonDtoList().get(i);
//              BZ不带入到估损里面
                if ("BZ".equals(prpLpersonDto.getKindCode())) continue;
                if (hashMapTemp.containsKey(prpLpersonDto.getKindCode())) {
                    prpLclaimLossDto = (PrpLclaimLossDto) hashMapTemp.get(prpLpersonDto.getKindCode());
                    prpLclaimLossDto.setKindLoss(prpLclaimLossDto.getSumClaim() + prpLpersonDto.getSumDefLoss());
       
                    prpLclaimLossDto
                            .setSumClaim(prpLclaimLossDto.getSumClaim() + prpLpersonDto.getSumDefLoss());
                } else {
                    prpLclaimLossDto = new PrpLclaimLossDto();
                    prpLclaimLossDto.setKindCode(prpLpersonDto.getKindCode());
                    prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLpersonDto.getRiskCode(),
                            prpLpersonDto.getKindCode(), true));
                    prpLclaimLossDto.setKindLoss(prpLpersonDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLpersonDto.getSumDefLoss());
                    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
                    prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimDto
                            .getCurrency(), true));
                }
                hashMapTemp.put(prpLpersonDto.getKindCode(), prpLclaimLossDto);
            }
        }
        //财产
        if (certainLossDto.getPrpLpropDtoList() != null && certainLossDto.getPrpLpropDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
                PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
//              BZ不带入到估损里面
                if ("BZ".equals(prpLpropDto.getKindCode())) continue;
                if (hashMapTemp.containsKey(prpLpropDto.getKindCode())) {
                    prpLclaimLossDto = (PrpLclaimLossDto) hashMapTemp.get(prpLpropDto.getKindCode());
                    prpLclaimLossDto.setKindLoss(prpLclaimLossDto.getSumClaim() + prpLpropDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLclaimLossDto.getSumClaim() + prpLpropDto.getSumDefLoss());
                } else {
                    prpLclaimLossDto = new PrpLclaimLossDto();
                    prpLclaimLossDto.setKindCode(prpLpropDto.getKindCode());
                    prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLpropDto.getRiskCode(),
                            prpLpropDto.getKindCode(), true));
                    prpLclaimLossDto.setKindLoss(prpLpropDto.getSumDefLoss());
                    prpLclaimLossDto.setSumClaim(prpLpropDto.getSumDefLoss());
                    prpLclaimLossDto.setCurrency(prpLclaimDto.getCurrency());
                    prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimDto
                            .getCurrency(), true));
                }
                hashMapTemp.put(prpLpropDto.getKindCode(), prpLclaimLossDto);
            }
        }
    }

    //把hashmap里面的值取出来
    Collection collection = hashMapTemp.values();
    if (collection.size() > 0) {
        claimLossList = new ArrayList();
    }
    Iterator iterator = collection.iterator();
    while (iterator.hasNext()) {
        PrpLclaimLossDto prpLclaimLossDtoTemp = (PrpLclaimLossDto) iterator.next();
        claimLossList.add(prpLclaimLossDtoTemp);
        //prpLclaimLossDto.setSumClaim(prpLclaimLossDto.getSumClaim()+prpLclaimLossDtoTemp.getSumClaim());
    }
    /*
     * CertainLossDto certainLossDto = new CertainLossDto(); UICertainLossAction uiCertainLossAction = new
     * UICertainLossAction(); HashMap hashMap = new HashMap(); hashMap.put(122,"sdfsdf");
     */

    prpLclaimLossDto.setClaimLossList(claimLossList);
    httpServletRequest.setAttribute("prpLclaimLossDto", prpLclaimLossDto);
} else {
    Collection claimFeeList = new ArrayList();
    PrpLclaimFeeDto prpLclaimFeeDto = new PrpLclaimFeeDto();
    prpLclaimFeeDto.setRiskCode(prpLclaimDto.getRiskCode());
    prpLclaimFeeDto.setSumClaim(prpLclaimDto.getSumClaim());
    prpLclaimFeeDto.setCurrency(prpLclaimDto.getCurrency());
    strCurrency = prpLclaimFeeDto.getCurrency();
    strCurrencyName = uiCodeAction.translateCurrencyCode(strCurrency, true);
    prpLclaimFeeDto.setCurrencyName(strCurrencyName);
    claimFeeList.add(prpLclaimFeeDto);
    prpLclaimFeeDto.setClaimFeeList(claimFeeList);
    httpServletRequest.setAttribute("prpLclaimFeeDto", prpLclaimFeeDto);

}
}
    
    /**
     * 填写拒赔页面及查询立案request的生成.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */

    public void cancelDtoToView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
    	//add by zhaolu 20060816 start
        //reason权限判断
    	UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_CLAIM_QUERY);
       //add by zhaolu 20060816 end
        String claimNo = httpServletRequest.getParameter("prpLclaimCancelClaimNo"); //赔案号
        String registNo = httpServletRequest.getParameter("businessNo"); //报案号
        String strSql = ""; //查询条件
        String msg = ""; //抛出错误使用的消息传递信息

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //立案Dto对象

        PrpLclaimDto prpLclaimDto = null; //立案Dto对象

        ClaimDto claimDto = null;
        UIClaimAction uiClaimAction = new UIClaimAction();
        UIRegistAction uiRegistAction = new UIRegistAction();
        
        //由于强三的原因，只要立案超过1个的情况的，注销掉部分，则不进行整个流程的关闭，需要选择是申请哪个注销的，我想，一次只能申请一个吧。
        //所以只能依靠registNo来进行判断了。。。
        if (registNo == null ||registNo.equals("")) {
        	msg = "不合法的报案号码！";
            throw new UserException(1, 3, "拒赔", msg);
        }
        //1.首先检查registNo是不是合法。如果不合法那么退出
        if (!uiRegistAction.isExist(registNo)) {
              msg = "不合法的报案号码！";
              throw new UserException(1, 3, "拒赔", msg);
         }
         
        //2.将立案信息取出
            strSql = "registNo='" + registNo + "' and endcasedate is null  ";
            claimList = uiClaimAction.findByConditions(strSql);
            
            if (claimList==null||claimList.size() <1){
                //如果没有立案，先提示，立案后在做拒赔以后要自动写信息到立案表里去'
                //整理立案数据
                msg = "案件目前还没有立案，请先立案后再做注销和拒赔！";
                throw new UserException(1,3,"拒赔",msg);
            }
           
            Iterator it = claimList.iterator();
            if (it.hasNext()){
            	   prpLclaimDto = (PrpLclaimDto) it.next();
                   prpLclaimDto.setClaimList(claimList);
            }
       
        if (prpLclaimDto == null) {
            msg = "没有查询到相关立案！";
            throw new UserException(1, 3, "拒赔", msg);
        }
        /*
        if (!prpLclaimDto.getEndCaseDate().isEmpty()) {
            msg = "立案已经结案";
            throw new UserException(1, 3, "拒赔", msg);
        }

        //已注销
        if (prpLclaimDto.getCaseType().equals("0")) {
            msg = "立案已经注销";
            throw new UserException(1, 3, "拒赔", msg);
        }

        //已拒赔
        if (prpLclaimDto.getCaseType().equals("1")) {
            msg = "立案已经拒赔";
            throw new UserException(1, 3, "拒赔", msg);
        }
      */
            
        strSql = "registNo='" + registNo + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it1 = registList.iterator();
        if (it1.hasNext()) prpLregistDto = (PrpLregistDto) it1.next();

        //放信息到request里面。。。
        //设置申请时间
        prpLclaimDto.setCancelDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
        //设置申请人
        prpLclaimDto.setDealerCode(user.getUserCode());
        prpLclaimDto.setDealerName(user.getUserName());
        //设置操作状态为ADD,申请登记，很重要的
        prpLclaimDto.setEditType("ADD");
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

    }

    /**
     * 根据报案号和保单号查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception
     */

    public void getSpecialList(HttpServletRequest httpServletRequest, String claimNo, String policyNo) throws Exception {
        //根据输入的保单号，赔案号生成SQL where 子句
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);
        String strSign = httpServletRequest.getParameter("OperateDateSign");

        String conditions = " 1=1 ";
        conditions = conditions
                + StringConvert.convertString("BusinessNo", claimNo, httpServletRequest.getParameter("ClaimNoSign"));
        conditions = conditions
                + StringConvert.convertString("PolicyNo", policyNo, httpServletRequest.getParameter("PolicyNoSign"));
        //conditions = conditions+ " and NOT EXISTS (SELECT claimno FROM prplcompensate WHERE prplcompensate.claimno =
        // SwfLog.businessNo) " +
        //                         " and SwfLog.nodeType='claim' and SwfLog.NodeStatus='4' and (SwfLog.FlowStatus='1' or
        // SwfLog.FlowStatus='2')";
        conditions = conditions
                + "  and SwfLog.nodeType='claim' and SwfLog.NodeStatus='4' and (SwfLog.FlowStatus='1' or SwfLog.FlowStatus='2')";

        //       拼权限
        //modify by zhaolu 20060816 start
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
      
        //modify by zhaolu 20060816 end
        //查询立案信息
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        //得到多行报案主表信息
        Collection swfList = new ArrayList();
        swfList = (Collection) uiWorkFlowAction.findNodesByConditions(conditions);
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto.setSwfLogList(swfList);
        //swfLogDto.setEditType(httpServletRequest.getParameter("editType")) ;
        httpServletRequest.setAttribute("swfLogDto", swfLogDto);

    }

    /**
     * 输入报案号码，默认出立案的必要信息
     * 
     * @param registNo 报案号码
     * @throws Exception
     */
    public PrpLclaimDto registDtoToClaimDto(String registNo, UserDto user) throws Exception {
        //取得当前用户信息，写操作员信息到立案中
        UIRegistAction uiRegistAction = new UIRegistAction();
        //将查勘信息带入到立案中
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
        prpLcheckDto = checkDto.getPrpLcheckDto();
        ArrayList list = new ArrayList();
        //根据查询出来的数据内容，给PrpLclaimDto赋值
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        if (prpLcheckDto == null) //要提示，立案之前必须做查看的！！！
        {
            //没有做查勘，但是可以立案
        } else {
            if (checkDto.getPrpLregistTextDtoList() != null) {
                Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
                while (iterator.hasNext()) {
                    PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
                    PrpLltextDto prpLltextDto = new PrpLltextDto();
                    prpLltextDto.setContext(prpLregistTextDto.getContext());
                    list.add(prpLltextDto);
                }
            }

            prpLclaimDto.setIndemnityDuty(prpLcheckDto.getIndemnityDuty());
            prpLclaimDto.setEscapeFlag(prpLcheckDto.getClaimType());

        }
        //查询报案信息，并取适当的信息到新登记的立案中
        RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
        prpLclaimDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
        prpLclaimDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
        prpLclaimDto.setDamageCode(registDto.getPrpLregistDto().getDamageCode());
        prpLclaimDto.setDamageName(registDto.getPrpLregistDto().getDamageName());
        prpLclaimDto.setDamageTypeCode(registDto.getPrpLregistDto().getDamageTypeCode());
        prpLclaimDto.setDamageTypeName(registDto.getPrpLregistDto().getDamageTypeName());
        prpLclaimDto.setDamageAreaCode(registDto.getPrpLregistDto().getDamageAreaCode());
        prpLclaimDto.setDamageAreaName(registDto.getPrpLregistDto().getDamageAreaName());
        prpLclaimDto.setDamageAddressType(registDto.getPrpLregistDto().getDamageAddressType());
        prpLclaimDto.setDamageAddress(registDto.getPrpLregistDto().getDamageAddress());
        prpLclaimDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
        String timeTemp = "";
        timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageStartHour());
        prpLclaimDto.setDamageStartDate(registDto.getPrpLregistDto().getDamageStartDate());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageEndHour());
        prpLclaimDto.setDamageEndDate(registDto.getPrpLregistDto().getDamageEndDate());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        prpLclaimDto.setClaimDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setClaimTime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setInsuredCode(registDto.getPrpLregistDto().getInsuredCode());
        prpLclaimDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
        prpLclaimDto.setClassCode(registDto.getPrpLregistDto().getClassCode());
        prpLclaimDto.setComCode(registDto.getPrpLregistDto().getComCode());
        prpLclaimDto.setAddressCode(registDto.getPrpLregistDto().getAddressCode());

        //lixiang 对照数据结构后增加
        prpLclaimDto.setLanguage(registDto.getPrpLregistDto().getLanguage());
        prpLclaimDto.setLossName(registDto.getPrpLregistDto().getLossName());
        prpLclaimDto.setMakeCom(registDto.getPrpLregistDto().getMakeCom());
        prpLclaimDto.setHandler1Code(registDto.getPrpLregistDto().getHandler1Code());
        prpLclaimDto.setOperatorCode(user.getUserCode());
        //估损金额的获取，如果是查勘，定损，核损都可以立案，
        prpLclaimDto.setSumClaim(registDto.getPrpLregistDto().getEstimateLoss());
        //设置默认的经办人
        prpLclaimDto.setHandlerCode(user.getUserCode());
        //对车型,条款等信息的支持
        prpLclaimDto.setClauseType(registDto.getPrpLregistDto().getClauseType());
        prpLclaimDto.setClauseName(registDto.getPrpLregistDto().getClauseName());
        prpLclaimDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
        prpLclaimDto.setLicenseColorCode(registDto.getPrpLregistDto().getLicenseColorCode());
        prpLclaimDto.setLicenseColor(prpLclaimDto.getLicenseColorCode());
        prpLclaimDto.setBrandName(registDto.getPrpLregistDto().getBrandName());
        prpLclaimDto.setCarKindCode(registDto.getPrpLregistDto().getCarKindCode());
        prpLclaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

        //设置立案操作的状态为 新案件登记 (未处理任务)
        prpLclaimDto.setStatus("1");

        //从保单中获得信息
        if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
            //查询保单信息
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo()
    				,registDto.getPrpLregistDto().getDamageStartDate().toString()
					,registDto.getPrpLregistDto().getDamageStartHour()); 
            
            prpLclaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
            prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
            prpLclaimDto.setStartDate(new DateTime(policyDto.getPrpCmainDto().getStartDate().toString(),
                    DateTime.YEAR_TO_DAY));
            prpLclaimDto.setEndDate(new DateTime(policyDto.getPrpCmainDto().getEndDate().toString(),
                    DateTime.YEAR_TO_DAY));
            prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
            prpLclaimDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
            prpLclaimDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());

            prpLclaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
            prpLclaimDto.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
            prpLclaimDto.setBusinessNature(policyDto.getPrpCmainDto().getBusinessNature());
            prpLclaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
            prpLclaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
            prpLclaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
            prpLclaimDto.setAgentCode(policyDto.getPrpCmainDto().getAgentCode());
        }

        //增加的其他信息
        prpLclaimDto.setLFlag("L");
        return prpLclaimDto;
    }
    public String getLossClaimNo(String registNo) throws Exception {
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        String claimNo = "";
        UICodeAction uiCodeAction = new UICodeAction();
        claimNo = uiCodeAction.translateBusinessCode(registNo, true);
        if (claimNo == null)
            claimNo = "";
        return claimNo;
    }

    public ClaimDto viewToLossDto(HttpServletRequest httpServletRequest) throws Exception {
        ClaimDto claimDto = super.viewToDto(httpServletRequest);
        ///*---------------------险别估损金额PrpLclaimloss------------------------------------*/
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = null;
        //从界面得到输入数组
        String prpLclaimLossClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLclaimLossRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode");
        String[] prpLclaimLossItemCode = httpServletRequest.getParameterValues("prpLclaimLossItemCode");
        String[] prpLclaimLossCurrency = httpServletRequest.getParameterValues("prpLclaimLossCurrency");
        String[] prpLclaimLossSumClaim = httpServletRequest.getParameterValues("prpLclaimLossSumClaim");
        String[] prpLclaimLossInputDate = httpServletRequest.getParameterValues("prpLclaimLossInputDate");
        String[] prpLclaimLossRemarkFlag = httpServletRequest.getParameterValues("prpLclaimLossRemarkFlag");
        String[] prpLclaimLossFlag = httpServletRequest.getParameterValues("prpLclaimLossFlag");
        
        
        //add 20060314 立案估损金额表中存入的itemkindNo 应为prpcitemKind的险别序号------[2]------------
        int[] prpLclaimLossItemKindNo ;
        prpLclaimLossItemKindNo =new int[prpLclaimLossKindCode.length];
        String   prpLclaimLossPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
        UIPolicyAction uiPolicyAction =new UIPolicyAction();
        PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimLossPolicyNo);
        Collection prpCitemKindDtoList = policyDto.getPrpCitemKindDtoList();
         
        Iterator it = prpCitemKindDtoList.iterator();
        PrpCitemKindDto prpCitemKindDto = null;
        while(it.hasNext()){
         	prpCitemKindDto =(PrpCitemKindDto)it.next();
            
         	for (int m=0; m<prpLclaimLossKindCode.length;m++ ){
         	     if(prpLclaimLossKindCode[m].equals(prpCitemKindDto.getKindCode())){
         	     	prpLclaimLossItemKindNo[m] = prpCitemKindDto.getItemKindNo();
         	     	
         	     }
         	}
        	
        }    	
        //---------------------------------------------------------------------------------------
        
        //对象赋值
        //-估损金额部分开始
        String lClaimKindeNo = "";
        if (prpLclaimLossCurrency == null) {
        } else {

            for (int i = 1; i < prpLclaimLossCurrency.length; i++) {
                lClaimKindeNo = prpLclaimLossKindCode[i];
                for (int j = (i + 1); j < prpLclaimLossCurrency.length; j++) {
                    if (lClaimKindeNo.equals(prpLclaimLossKindCode[j]) && !prpLclaimLossKindCode[j].equals("repeat")) {
                        prpLclaimLossKindCode[j] = "repeat";
                        prpLclaimLossSumClaim[i] = String.valueOf((Double.parseDouble(DataUtils
                                .nullToZero(prpLclaimLossSumClaim[j])))
                                + (Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[i]))));

                    }
                }
            }
            int tindex = 1;
            for (int index = 1; index < prpLclaimLossCurrency.length; index++) {
                if (prpLclaimLossKindCode[index].equals("repeat"))
                    continue;
                prpLclaimLossDto = new PrpLclaimLossDto();
                prpLclaimLossDto.setClaimNo(prpLclaimLossClaimNo);
                prpLclaimLossDto.setRiskCode(prpLclaimLossRiskCode);
                prpLclaimLossDto.setSerialNo(index);
                //prpLclaimLossDto.setSerialNo (Integer.parseInt(DataUtils.nullToZero(prpLclaimLossSerialNo[index])));
                //prpLclaimLossDto.setItemKindNo(tindex);
                prpLclaimLossDto.setItemKindNo(prpLclaimLossItemKindNo[index]);
                prpLclaimLossDto.setKindCode(prpLclaimLossKindCode[index]);
                prpLclaimLossDto.setItemCode(prpLclaimLossItemCode[index]);
                prpLclaimLossDto.setCurrency(prpLclaimLossCurrency[index]);
                prpLclaimLossDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[index])));

                //modify by lixiang add 20050316 start
                //reason:修改估损金额的调整
                //modify by lixiang add 20050316 end

                prpLclaimLossDto.setInputDate(new DateTime(new Date()));
                //prpLclaimLossDto.setInputDate (new DateTime(prpLclaimLossInputDate[index]));
                prpLclaimLossDto.setRemarkFlag(prpLclaimLossRemarkFlag[index]);
                prpLclaimLossDto.setFlag(prpLclaimLossFlag[index]);

                //加入集合
                claimLossList.add(prpLclaimLossDto);
                tindex++;
            }
            claimDto.setPrpLclaimLossDtoList(claimLossList);
        }
        return claimDto;
    }
    
    /**
     * 填写不予立案页面及查询报案request的生成.
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */

    public void notGrandClaimDtoToView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
        String registNo = httpServletRequest.getParameter("RegistNo"); //报案号
        String strSql = ""; //查询条件

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //报案Dto对象
        
        UIRegistAction uiRegistAction = new UIRegistAction();

        strSql = "registNo='" + registNo + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it = registList.iterator();
        if (it.hasNext()) {
            prpLregistDto = (PrpLregistDto) it.next();
        }

        prpLregistDto.setDealerCode(user.getUserCode());
        prpLregistDto.setComName(user.getUserName());  //用部门属性存放操作员名字 
        prpLregistDto.setCancelDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
        
        //设置操作状态为ADD,申请登记，很重要的
        prpLregistDto.setEditType("ADD");

        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
    }
    /**
     * 根据PolicyDto获得该保单投保的主要险别
     * @param policyDto
     * @return
     */
    public String getDefaultKindCodeByPolicyDto(PolicyDto policyDto){
    	String kindCode="";
    	for (Iterator iter = policyDto.getPrpCitemKindDtoList().iterator(); iter.hasNext();) {
			PrpCitemKindDto itemKind = (PrpCitemKindDto) iter.next();
			//ItemKindNo为1的为主要险别
			if(itemKind.getItemKindNo()==1){
				return itemKind.getKindCode();
			}
		}
    	return kindCode;
    }
    
    /**
     * 保存立案时立案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return claimDto 立案数据传输数据结构
     * @throws Exception
     */
    public ClaimDto viewToDtoSuper(HttpServletRequest httpServletRequest,int indexOfClaim) throws Exception {
        ClaimDto claimDto = new ClaimDto();
        /*---------------------立案主表prpLclaim------------------------------------*/
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        //加到ArrayList中
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim)
				,httpServletRequest.getParameter("prpLclaimDamageStartDate_"+indexOfClaim)
				,httpServletRequest.getParameter("prpLclaimDamageStartHour_"+indexOfClaim)); 
        prpLclaimDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim));
        //prpLclaimDto.setLFlag (httpServletRequest.getParameter("prpLclaimLFlag_"+indexOfClaim));
        String[] arrayLFlag = httpServletRequest.getParameterValues("LFlag");
        if(null!=arrayLFlag && arrayLFlag.length>indexOfClaim)
        	prpLclaimDto.setLFlag(arrayLFlag[indexOfClaim]);
        prpLclaimDto.setCaseNo(httpServletRequest.getParameter("prpLclaimCaseNo_"+indexOfClaim));
        prpLclaimDto.setClassCode(httpServletRequest.getParameter("prpLclaimClassCode_"+indexOfClaim));
        prpLclaimDto.setRiskCode(httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfClaim));

        prpLclaimDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfClaim));
        prpLclaimDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim));
        prpLclaimDto.setBusinessNature(httpServletRequest.getParameter("prpLclaimBusinessNature_"+indexOfClaim));
        prpLclaimDto.setLanguage(httpServletRequest.getParameter("prpLclaimLanguage_"+indexOfClaim));
        prpLclaimDto.setPolicyType(httpServletRequest.getParameter("prpLclaimPolicyType_"+indexOfClaim));
//        prpLclaimDto.setInsuredCode(httpServletRequest.getParameter("prpLclaimInsuredCode_"+indexOfClaim));
        prpLclaimDto.setInsuredCode(httpServletRequest.getParameter("prpLregistInsuredCode_"+indexOfClaim));
        prpLclaimDto.setInsuredName(httpServletRequest.getParameter("prpLclaimInsuredName_"+indexOfClaim));
        prpLclaimDto.setStartDate(new DateTime(httpServletRequest.getParameter("prpLclaimStartDate_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
       if(policyDto!= null){
        	if(policyDto.getPrpCmainDto()!=null){
              prpLclaimDto.setStartHour(policyDto.getPrpCmainDto().getStartHour());
              prpLclaimDto.setEndHour(policyDto.getPrpCmainDto().getEndHour());
            }
        }else{
        	prpLclaimDto.setStartHour(0);
            prpLclaimDto.setEndHour(24);
        }
        prpLclaimDto
                .setEndDate(new DateTime(httpServletRequest.getParameter("prpLclaimEndDate_"+indexOfClaim), DateTime.YEAR_TO_DAY));
        
        prpLclaimDto.setCurrency(httpServletRequest.getParameter("prpLclaimCurrency_"+indexOfClaim));
        
        prpLclaimDto.setSumAmount(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumAmount_"+indexOfClaim))));
        prpLclaimDto.setSumPremium(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumPremium_"+indexOfClaim))));
        prpLclaimDto.setSumQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumQuantity_"+indexOfClaim))));
        //兼容大地的小时，所以先注释掉
        prpLclaimDto.setDamageStartHour(StringConvert.newString(httpServletRequest
                .getParameter("prpLclaimDamageStartHour_"+indexOfClaim))
                + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLclaimDamageStartMinute_"+indexOfClaim)) + ":00");
        //prpLclaimDto.setDamageStartHour (httpServletRequest.getParameter("prpLclaimDamageStartHour_"+indexOfClaim));
        //兼容大地的小时，所以先注释掉
        prpLclaimDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("prpLclaimDamageStartDate_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDamageEndDate(new DateTime(httpServletRequest.getParameter("prpLclaimDamageEndDate_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
        //兼容大地的小时，所以先注释掉
        //prpLclaimDto.setDamageEndHour (httpServletRequest.getParameter("prpLclaimDamageEndHour_"+indexOfClaim));
        prpLclaimDto.setDamageEndHour(StringConvert
                .newString(httpServletRequest.getParameter("prpLclaimDamageEndHour_"+indexOfClaim))
                + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLclaimDamageEndMinute_"+indexOfClaim)) + ":00");
        prpLclaimDto.setDamageCode(httpServletRequest.getParameter("prpLclaimDamageCode_"+indexOfClaim));
        prpLclaimDto.setDamageName(httpServletRequest.getParameter("prpLclaimDamageName_"+indexOfClaim));
        prpLclaimDto.setDamageTypeCode(httpServletRequest.getParameter("prpLclaimDamageTypeCode_"+indexOfClaim));
        prpLclaimDto.setDamageTypeName(httpServletRequest.getParameter("prpLclaimDamageTypeName_"+indexOfClaim));
        prpLclaimDto.setDamageAreaCode(httpServletRequest.getParameter("prpLclaimDamageAreaCode_"+indexOfClaim));
        prpLclaimDto.setDamageAreaName(httpServletRequest.getParameter("prpLclaimDamageAreaName_"+indexOfClaim));
        prpLclaimDto.setDamageAddressType(httpServletRequest.getParameter("prpLclaimDamageAddressType_"+indexOfClaim));
        prpLclaimDto.setDamageAddress(httpServletRequest.getParameter("prpLclaimDamageAddress_"+indexOfClaim));
        prpLclaimDto.setLossName(httpServletRequest.getParameter("prpLclaimLossName_"+indexOfClaim));
        prpLclaimDto.setLossQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimLossQuantity_"+indexOfClaim))));
        prpLclaimDto.setDamageKind(httpServletRequest.getParameter("prpLclaimDamageKind_"+indexOfClaim));
        if("05".equals(prpLclaimDto.getClassCode())){
        	prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate_"+indexOfClaim),
                    DateTime.YEAR_TO_SECOND));
        }else{
        	prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate_"+indexOfClaim),
                    DateTime.YEAR_TO_DAY));
        	prpLclaimDto.setClaimTime(new DateTime(httpServletRequest.getParameter("prpLclaimClaimTime_"+indexOfClaim),
                    DateTime.YEAR_TO_SECOND));
        }
        //prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate"),
        //        DateTime.YEAR_TO_DAY));
        prpLclaimDto.setIndemnityDuty(httpServletRequest.getParameter("indemnityDuty_"+indexOfClaim));
        prpLclaimDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimIndemnityDutyRate_"+indexOfClaim))));
        prpLclaimDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimDeductibleRate_"+indexOfClaim))));
        prpLclaimDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumClaim_"+indexOfClaim))));
        prpLclaimDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumDefLoss_"+indexOfClaim))));
        prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumPaid_"+indexOfClaim))));
        prpLclaimDto.setSumReplevy(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumReplevy_"+indexOfClaim))));
        prpLclaimDto.setRemark(httpServletRequest.getParameter("prpLclaimRemark_"+indexOfClaim));
        prpLclaimDto.setCaseType(httpServletRequest.getParameter("prpLclaimCaseType_"+indexOfClaim));
        prpLclaimDto.setMakeCom(httpServletRequest.getParameter("prpLclaimMakeCom_"+indexOfClaim));
        prpLclaimDto.setComCode(httpServletRequest.getParameter("prpLclaimComCode_"+indexOfClaim));
        prpLclaimDto.setAgentCode(httpServletRequest.getParameter("prpLclaimAgentCode_"+indexOfClaim));
        prpLclaimDto.setHandlerCode(httpServletRequest.getParameter("prpLclaimHandlerCode_"+indexOfClaim));
        prpLclaimDto.setHandler1Code(httpServletRequest.getParameter("prpLclaimHandler1Code_"+indexOfClaim));
        prpLclaimDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLclaimStatisticsYM_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setOperatorCode(httpServletRequest.getParameter("prpLclaimOperatorCode_"+indexOfClaim));
        prpLclaimDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLclaimInputDate_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setEndCaseDate(new DateTime(httpServletRequest.getParameter("prpLclaimEndCaseDate_"+indexOfClaim),
                DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setEndCaserCode(httpServletRequest.getParameter("prpLclaimEndCaserCode_"+indexOfClaim));
        prpLclaimDto.setCancelDate(new DateTime(httpServletRequest.getParameter("prpLclaimCancelDate_"+indexOfClaim),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setCancelReason(httpServletRequest.getParameter("prpLclaimCancelReason_"+indexOfClaim));
        prpLclaimDto.setDealerCode(httpServletRequest.getParameter("prpLclaimDealerCode_"+indexOfClaim));

        //modify by wangwei add start 2005-06-07
        //原因：添加巨灾代码和出险地邮编
        prpLclaimDto.setDamageAreaPostCode(httpServletRequest.getParameter("prpDamageAreaPostCode_"+indexOfClaim));
        prpLclaimDto.setCatastropheCode1(httpServletRequest.getParameter("prpCatastropheCode1_"+indexOfClaim));
        prpLclaimDto.setCatastropheName1(httpServletRequest.getParameter("prpCatastropheName1_"+indexOfClaim));
        prpLclaimDto.setCatastropheCode2(httpServletRequest.getParameter("prpCatastropheCode2_"+indexOfClaim));
        prpLclaimDto.setCatastropheName2(httpServletRequest.getParameter("prpCatastropheName2_"+indexOfClaim));
        //modify by wangwei add end 205-06-07
        //add by wunier 20071228
        //reason:添加赔付数量以及相应单位
        String prpLclaimLossesNumber = httpServletRequest.getParameter("prpLclaimLossesNumber_"+indexOfClaim);
        if(prpLclaimLossesNumber!=null){
        prpLclaimDto.setLossesNumber(Double.parseDouble(prpLclaimLossesNumber));
        }
        String[] arrayLossesUnitCode = httpServletRequest.getParameterValues("lossesUnitCode");
        if(null!=arrayLossesUnitCode && arrayLossesUnitCode.length > indexOfClaim)
        	prpLclaimDto.setLossesUnitCode(arrayLossesUnitCode[indexOfClaim]);
        //end by wunier 20071228
        //add by wunier 20071229
        //reason:增加出险户次、受灾面积
        String prpLclaimDamageInsured = httpServletRequest.getParameter("prpLclaimDamageInsured_"+indexOfClaim);
        if(prpLclaimDamageInsured!=null&&!"".equals(prpLclaimDamageInsured)){
        prpLclaimDto.setDamageInsured(Double.parseDouble(prpLclaimDamageInsured));
        }
        String prpLclaimDisasterArea = httpServletRequest.getParameter("prpLclaimDisasterArea_"+indexOfClaim);
        if(prpLclaimDisasterArea!=null&&!"".equals(prpLclaimDisasterArea)){
        prpLclaimDto.setDisasterArea(Double.parseDouble(prpLclaimDisasterArea));
        }
        prpLclaimDto.setDisasterUnit(httpServletRequest.getParameter("disasterUnit_"+indexOfClaim));
        String prpLclaimAffectedArea = httpServletRequest.getParameter("prpLclaimAffectedArea_"+indexOfClaim);
        if(prpLclaimAffectedArea!=null&&!"".equals(prpLclaimAffectedArea)){
        prpLclaimDto.setAffectedArea(Double.parseDouble(prpLclaimAffectedArea));
        }
        prpLclaimDto.setAffectedUnit(httpServletRequest.getParameter("affectedUnit_"+indexOfClaim));
        String prpLclaimNoProductionArea = httpServletRequest.getParameter("prpLclaimNoProductionArea_"+indexOfClaim);
        if(prpLclaimNoProductionArea!=null&&!"".equals(prpLclaimNoProductionArea)){
        prpLclaimDto.setNoProductionArea(Double.parseDouble(prpLclaimNoProductionArea));
        }
        prpLclaimDto.setNoProductionUnit(httpServletRequest.getParameter("noProductionUnit_"+indexOfClaim));
        String prpLclaimDeathQuantity = httpServletRequest.getParameter("prpLclaimDeathQuantity_"+indexOfClaim);
        if(prpLclaimDeathQuantity!=null&&!"".equals(prpLclaimDeathQuantity)){
        prpLclaimDto.setDeathQuantity(Double.parseDouble(prpLclaimDeathQuantity));
        String[] arrayDeathUnit = httpServletRequest.getParameterValues("deathUnit");
        if(null!=arrayDeathUnit && arrayDeathUnit.length>indexOfClaim)
        	prpLclaimDto.setDeathUnit(arrayDeathUnit[indexOfClaim]);
        }
        String prpLclaimKillQuantity = httpServletRequest.getParameter("prpLclaimKillQuantity_"+indexOfClaim);
        if(prpLclaimKillQuantity!=null&&!"".equals(prpLclaimKillQuantity)){
        prpLclaimDto.setKillQuantity(Double.parseDouble(prpLclaimKillQuantity));
        }
        String[] arrayKillUnit = httpServletRequest.getParameterValues("killUnit");
        if(null!=arrayKillUnit && arrayKillUnit.length>indexOfClaim)
        	prpLclaimDto.setKillUnit(arrayKillUnit[indexOfClaim]);

        //end by wunier 20071229


        
        /*添加案件类型 2005-08-03
        prpLclaimDto.setClaimType(httpServletRequest.getParameter("prpLclaimClaimType"));
        
        //modify by luqin add 2005-03-24 begin
        //reason:插入字段（escapeFlag）超长
        
        /*
        String escapeFlag = httpServletRequest.getParameter("escapeFlag");
        if (escapeFlag == null) {
            escapeFlag = "";
        }
        String escapeFlag2 = "";
        escapeFlag2 = httpServletRequest.getParameter("escapeFlag2");
        if (escapeFlag2 == null) {
            escapeFlag2 = "";
        }
        prpLclaimDto.setEscapeFlag2(escapeFlag2);
        prpLclaimDto.setEscapeFlag(escapeFlag + escapeFlag2);
        */
        // modify by wangli add start 20050421
        
        //=================================== modify by YANGBO 2009-01-15 START
        prpLclaimDto.setClaimType(httpServletRequest.getParameter("claimType_"+indexOfClaim));
        prpLclaimDto.setEscapeFlag(httpServletRequest.getParameter("escapeFlag_"+indexOfClaim));
        prpLclaimDto.setClaimTypeName(httpServletRequest.getParameter("claimTypeName_"+indexOfClaim));
        //=================================== modify by YANGBO 2009-01-15 END

        prpLclaimDto.setFlag(httpServletRequest.getParameter("prpLclaimFlag_"+indexOfClaim));

        String[] arrayReplevyFlag = httpServletRequest.getParameterValues("replevyFlag");
        if(null!=arrayReplevyFlag && arrayReplevyFlag.length>indexOfClaim)
        	prpLclaimDto.setReplevyFlag(arrayReplevyFlag[indexOfClaim]);
        String[] arrayThirdComFlag = httpServletRequest.getParameterValues("thirdComFlag");
        if(null!=arrayThirdComFlag && arrayThirdComFlag.length>indexOfClaim)
        	prpLclaimDto.setThirdComFlag(arrayThirdComFlag[indexOfClaim]);
        //需要保存的状态,所以每个操作界面必须有一个"buttonSaveType"的操作域来保存要操作的状态！！
        prpLclaimDto.setAddressCode(httpServletRequest.getParameter("prpLclaimAddressCode_"+indexOfClaim));
       
        //if ((prpLclaimDto.getEscapeFlag().length() > 0) && (prpLclaimDto.getEscapeFlag2().length() > 0)) {
        //    String strTemp = prpLclaimDto.getEscapeFlag().substring(0, 1)
        //            + prpLclaimDto.getEscapeFlag2().substring(0, 1);
        //    prpLclaimDto.setEscapeFlag(strTemp);
        //}
        //prpLclaimDto.setStatus (httpServletRequest.getParameter("buttonSaveType") ) ;
        prpLclaimDto.setComName(prpLclaimDto.getComCode());
        prpLclaimDto.setMedicalType(httpServletRequest.getParameter("medicalType_"+indexOfClaim));

        //加到ArrayList中

        claimDto.setPrpLclaimDto(prpLclaimDto);
        
        //事故者信息模块 begin
        ArrayList prpLacciBenPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciBenPersonProposerDto = null;
        String[] prpLacciPersonAcciCode = httpServletRequest.getParameterValues("prpLacciPersonAcciCode_"+indexOfClaim);
        String[] prpLacciBenPersonSerialNo = httpServletRequest.getParameterValues("prpLacciBenPersonSerialNo_"+indexOfClaim);
        String[] prpLacciPersonAcciName = httpServletRequest.getParameterValues("prpLacciPersonAcciName_"+indexOfClaim);
        String[] prpLacciPersonFamilyNo = httpServletRequest.getParameterValues("prpLacciPersonFamilyNo_"+indexOfClaim);
        String[] prpLacciPersonAge = httpServletRequest.getParameterValues("prpLacciPersonAge_"+indexOfClaim);
        String[] prpLacciPersonSex = httpServletRequest.getParameterValues("prpLacciPersonSex_"+indexOfClaim);
        String[] prpLacciPersonIdentifyNumber = httpServletRequest.getParameterValues("prpLacciPersonIdentifyNumber_"+indexOfClaim);
        String[] prpLacciPersonAddress = httpServletRequest.getParameterValues("prpLacciPersonAddress_"+indexOfClaim);
        
        //对象赋值
        if (prpLacciPersonFamilyNo ==null) {
        } else { 
        	
            for (int index = 1; index < prpLacciPersonFamilyNo.length; index++) {
            	prpLacciBenPersonProposerDto = new PrpLacciPersonDto();
            	prpLacciBenPersonProposerDto.setCertiNo(httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfClaim));
            	prpLacciBenPersonProposerDto.setCertiType("01"); //事故者信息
            	prpLacciBenPersonProposerDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim));
            	//prpLacciBenPersonProposerDto.setSerialNo(uiPolicyAction.findBySeriaNo("1=1") + 1);不明白?
                  //分户序号从界面上取
            	prpLacciBenPersonProposerDto.setSerialNo(Integer.parseInt(prpLacciBenPersonSerialNo[index]));
            	prpLacciBenPersonProposerDto.setFamilyNo(Integer.parseInt(prpLacciPersonFamilyNo[index]));
            	prpLacciBenPersonProposerDto.setAcciCode(prpLacciPersonAcciCode[index]);
            	prpLacciBenPersonProposerDto.setAcciName(prpLacciPersonAcciName[index]);
            	prpLacciBenPersonProposerDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonAge[index])));
            	prpLacciBenPersonProposerDto.setSex(prpLacciPersonSex[index]);
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLacciPersonIdentifyNumber[index]);
            	prpLacciBenPersonProposerDto.setAddress(prpLacciPersonAddress[index]);//暂存牛号信息
                //加入集合
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
            }
        }
        claimDto.setPrplacciBenPersonDtoList(prpLacciBenPersonList);
        //事故者信息模块 end
        /*---------------------立案文本表prpLltext------------------------------------*/
        ArrayList prpLltextDtoList = new ArrayList();
        String TextTemp = httpServletRequest.getParameter("prpLltextContextInnerHTML_"+indexOfClaim);
        String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
        //得到连接串,下面将其切分到数组
        for (int k = 0; k < rules.length; k++) {
            PrpLltextDto prpLltextDto = new PrpLltextDto();
            prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim));
            prpLltextDto.setContext(rules[k]);
            prpLltextDto.setLineNo(k + 1);
            prpLltextDto.setTextType("09");
            prpLltextDtoList.add(prpLltextDto);
        }
        //详细出险原因信息
        String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag_"+indexOfClaim);
        if(strDamageMessage!=null && !strDamageMessage.equals("")){
     	   ArrayList prpLltextDtoList3 = new ArrayList();
     	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage_"+indexOfClaim);
     	   if(damageMessage != null){
 	    	   for(int index = 0;index<damageMessage.length;index++){
 	    		  PrpLltextDto prpLltextDto = new PrpLltextDto();
 	    		  prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim));
 	    		  prpLltextDto.setLineNo(index+1);
 	    		  prpLltextDto.setContext(damageMessage[index]);
 	    		  prpLltextDto.setTextType(strDamageMessage);
 	    		 prpLltextDtoList3.add(prpLltextDto);
 	    	   }
     	   }
     	   claimDto.setPrpLltextDtoList3(prpLltextDtoList3);
        }
        //claimDto
        claimDto.setPrpLltextDtoList(prpLltextDtoList);
        
        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
  
		//从界面得到输入数组
		String   prpLclaimClaimNo  = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfClaim);
		String   prpLclaimPolicyNo  = httpServletRequest.getParameter("prpLclaimPolicyNo_"+indexOfClaim);
		String   prpLclaimRegistNo  = httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfClaim);
		String   prpLclaimDamageStartDate  = httpServletRequest.getParameter("prpLclaimDamageStartDate_"+indexOfClaim);
		String   prpLclaimDamageCode  = httpServletRequest.getParameter("prpLclaimDamageCode_"+indexOfClaim);
		String   prpLclaimDamageName  = httpServletRequest.getParameter("prpLclaimDamageName_"+indexOfClaim);
		String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode_"+indexOfClaim);
		
		
		String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount_"+indexOfClaim);
		String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank_"+indexOfClaim);
		String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode_"+indexOfClaim);
		String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName_"+indexOfClaim);
		String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo_"+indexOfClaim);
		String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo_"+indexOfClaim);
		String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate_"+indexOfClaim);
		String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo_"+indexOfClaim);
		String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo_"+indexOfClaim);
		String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber_"+indexOfClaim);
		String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode_"+indexOfClaim);
		String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate_"+indexOfClaim);
		String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName_"+indexOfClaim);
		String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate_"+indexOfClaim);
		String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour_"+indexOfClaim);
		String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber_"+indexOfClaim);
		String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason_"+indexOfClaim);
		String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible_"+indexOfClaim);
		String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate_"+indexOfClaim);
		String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo_"+indexOfClaim);
		String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss_"+indexOfClaim);
		String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode_"+indexOfClaim);
		String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card_"+indexOfClaim);
		String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode_"+indexOfClaim);
		String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode_"+indexOfClaim);
		String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName_"+indexOfClaim);
		String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo_"+indexOfClaim);
		String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType_"+indexOfClaim);
		String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo_"+indexOfClaim);
		String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo_"+indexOfClaim);
		String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime_"+indexOfClaim);
		String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee_"+indexOfClaim);
		String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay_"+indexOfClaim);
		String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount_"+indexOfClaim);


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
				prplCompensateEarDto.setClaimno((String) httpServletRequest.getAttribute("claimNo_"+indexOfClaim));
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("CombineNo_"+indexOfClaim));
				prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(prpLclaimDamageCode);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(prpLclaimDamageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLclaimDamageStartDate,DateTime.YEAR_TO_DAY));
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
				prplCompensateEarDto.setKindcode(prpLclaimLossKindCode[1]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(4);
				prplCompensateEarDto.setNodetype("claim");
				prplCompensateEarDto.setPolicyno(prpLclaimPolicyNo);
				prplCompensateEarDto.setRegistno(prpLclaimRegistNo);
				prplCompensateEarDto.setBusinessno(prpLclaimRegistNo);
				prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		claimDto.setPrpLcompensateeartDtoList(prplCompensateEarDtoList);
        
        /*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo());
        prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("claim");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode());
        //取得当前用户信息，写操作员信息到实赔中
        HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
        //prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
        prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate());
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        return claimDto;
    }
}
