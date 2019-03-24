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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrpDangerShareDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
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
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
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
import com.sinosoft.prpall.blsvr.cb.BLPrpCvirturlItem;
import com.sinosoft.prpall.blsvr.lp.BLPrpLthirdParty;
import com.sinosoft.prpall.pubfun.GroupProposalService;
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
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.Str;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;


/**
 * Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * @author ����������Ŀ�� lijiyuan
 * @version 1.0 <br>
 */

public class DAACombineClaimViewHelper extends com.sinosoft.claim.ui.control.viewHelper.ClaimViewHelper {
	private int RULE_LENGTH = 70; //rule�ֶεĳ���
	
	private static Log logger = LogFactory.getLog(DAACombineClaimViewHelper.class);
    /**
     * Ĭ�Ϲ��췽��
     */
    public DAACombineClaimViewHelper() {
    }

    /**
     * ��������ʱ����ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
     * 
     * @param httpServletRequest
     * @return claimDto �������ݴ������ݽṹ
     * @throws Exception
     */
    public ClaimDto viewToDto(HttpServletRequest httpServletRequest) throws Exception {
        //�̳ж�claim,claimsText��ĸ�ֵ
        ClaimDto claimDto = super.viewToDto(httpServletRequest);
        UICodeAction uiCodeAction  = new UICodeAction();
        String strRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
        
        //add by zhaolu 20060816 start
        //reasonȨ���ж�
        UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
        UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_CLAIM_INSERT);
        //add by zhaolu 20060816 end
        /*add by lym 20060609  for ǿ��-start--------��д������-------------------------*/
        String   policyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
        String   registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
        String   prpLRegistRPolicyClaimNo = (String) httpServletRequest.getAttribute("claimNo");
    	String   flowID = httpServletRequest.getParameter("swfLogFlowID"); 
     
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
        
        /*add by lym 20060609  for ǿ��--end-------��д������-------------------------*/
        
        /*---------------------���߳���prpLthirdParty------------------------------------*/
        ArrayList thirdPartyDtoList = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto = null;
        //�ӽ���õ���������
        String prpLthirdPartyClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLthirdPartyRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String prpLthirdPartyRegistNo = httpServletRequest.getParameter("prpLclaimRegistNo");
        String prpLthirdPartyClauseType = httpServletRequest.getParameter("prpLclaimClauseType");
        String[] prpLthirdPartySerialNo = httpServletRequest.getParameterValues("prpLthirdPartySerialNo");
        String[] prpLthirdPartyLicenseNo = httpServletRequest.getParameterValues("prpLthirdPartyLicenseNo");
        String[] prpLthirdPartyLicenseColorCode = httpServletRequest.getParameterValues("licenseColorCode");
        String[] prpLthirdPartyCarKindCode = httpServletRequest.getParameterValues("carKindCode");
        String[] prpLthirdPartyInsureCarFlag = httpServletRequest.getParameterValues("insureCarFlag");
        String[] prpLthirdPartyCarOwner = httpServletRequest.getParameterValues("prpLthirdPartyCarOwner");
        String[] prpLthirdPartyEngineNo = httpServletRequest.getParameterValues("prpLthirdPartyEngineNo");
        String[] prpLthirdPartyFrameNo = httpServletRequest.getParameterValues("prpLthirdPartyFrameNo");
        String[] prpLthirdPartyModelCode = httpServletRequest.getParameterValues("prpLthirdPartyModelCode");
        String[] prpLthirdPartyBrandName = httpServletRequest.getParameterValues("prpLthirdPartyBrandName");
        String[] prpLthirdPartyRunDistance = httpServletRequest.getParameterValues("prpLthirdPartyRunDistance");
        String[] prpLthirdPartyUseYears = httpServletRequest.getParameterValues("prpLthirdPartyUseYears");
        String[] prpLthirdPartyDutyPercent = httpServletRequest.getParameterValues("prpLthirdPartyDutyPercent");
        String[] prpLthirdPartyInsuredFlag = httpServletRequest.getParameterValues("insuredFlag");
        String[] prpLthirdPartyInsureComCode = httpServletRequest.getParameterValues("prpLthirdPartyInsureComCode");
        String[] prpLthirdPartyInsureComName = httpServletRequest.getParameterValues("prpLthirdPartyInsureComName");
        String[] prpLthirdPartyFlag = httpServletRequest.getParameterValues("prpLthirdPartyFlag");
        String[] prpLthirdPartyCarPolicyNo = httpServletRequest.getParameterValues("prpLthirdPartyCarPolicyNo");
        
        //����ֵ
        //���߳������ֿ�ʼ
        if (prpLthirdPartySerialNo == null) {
        } else {
            for (int index = 1; index < prpLthirdPartySerialNo.length; index++) {
                prpLthirdPartyDto = new PrpLthirdPartyDto();
                prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
                prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
                prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLthirdPartySerialNo[index])));
                prpLthirdPartyDto.setClaimNo(prpLthirdPartyClaimNo);
                prpLthirdPartyDto.setClauseType(prpLthirdPartyClauseType);
                prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo[index]);
                prpLthirdPartyDto.setLicenseColorCode(prpLthirdPartyLicenseColorCode[index]);
                prpLthirdPartyDto.setCarKindCode(prpLthirdPartyCarKindCode[index]);
                prpLthirdPartyDto.setInsureCarFlag(prpLthirdPartyInsureCarFlag[index]);
                prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo[index]);
                prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo[index]);
                prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName[index]);
                prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode[index]);  //add              
                prpLthirdPartyDto.setRunDistance(Double.parseDouble(DataUtils
                        .nullToZero(prpLthirdPartyRunDistance[index])));
                prpLthirdPartyDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(prpLthirdPartyUseYears[index])));
                prpLthirdPartyDto.setDutyPercent(Double.parseDouble(DataUtils
                        .nullToZero(prpLthirdPartyDutyPercent[index])));
                prpLthirdPartyDto.setInsuredFlag(prpLthirdPartyInsuredFlag[index]);
                prpLthirdPartyDto.setInsureComCode(prpLthirdPartyInsureComCode[index]);
                prpLthirdPartyDto.setInsureComName(prpLthirdPartyInsureComName[index]);
    			prpLthirdPartyDto.setCarPolicyNo(prpLthirdPartyCarPolicyNo[index]);
    			BLPrpLthirdPartyFacade blPrpLthirdParty = new BLPrpLthirdPartyFacade();
    			Collection collectiion = blPrpLthirdParty.findByConditions(" registno= '"+prpLthirdPartyRegistNo+"' and serialno = '"+prpLthirdPartySerialNo[index]+"'");
    			if(collectiion.size() > 0){
    				prpLthirdPartyDto.setPrpLthirdPartyDriveName(((PrpLthirdPartyDto)collectiion.iterator().next()).getPrpLthirdPartyDriveName());
    				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(((PrpLthirdPartyDto)collectiion.iterator().next()).getPrpLthirdPartyDriveLicensNo());
    			}
                //���뼯��
                thirdPartyDtoList.add(prpLthirdPartyDto);
            }

            //���������м������߳���
            claimDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
        }
        /*-------------------������������Ϣ-------start------------------------------------*/
        ArrayList prpLacciPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciPersonProposerDto = null;
        //�ӽ���õ���������
        
        String   proposerClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String   proposerPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
        String[] proposerName = httpServletRequest.getParameterValues("proposerName");
        String[] proposerSerialNo = httpServletRequest.getParameterValues("prpLacciPersonSerialNo");
        String[] proposerIdentifyNumber = httpServletRequest.getParameterValues("proposerIdentifyNumber");
        String[] proposerRelation = httpServletRequest.getParameterValues("relationCode");
        String[] proposerPhone = httpServletRequest.getParameterValues("proposerPhone");
        String[] proposerAddress = httpServletRequest.getParameterValues("proposerAddress");
        String   proposerFamilyNo= httpServletRequest.getParameter("personFamilyNo");
        //-----------------------------------
       
        //����ֵ
        if (proposerSerialNo ==null) {
        } else { 
        	 
            for (int index = 1; index < proposerSerialNo.length; index++) {
            	prpLacciPersonProposerDto =new  PrpLacciPersonDto();
                prpLacciPersonProposerDto.setAcciName(proposerName[index]);
                prpLacciPersonProposerDto.setCertiNo(proposerClaimNo);
                prpLacciPersonProposerDto.setCertiType("03");
                prpLacciPersonProposerDto.setPolicyNo(proposerPolicyNo);
                prpLacciPersonProposerDto.setFlag("1");   //��־��������
                prpLacciPersonProposerDto.setIdentifyNumber(proposerIdentifyNumber[index]);
                prpLacciPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(proposerSerialNo[index])));
                prpLacciPersonProposerDto.setAddress(proposerAddress[index]);
                prpLacciPersonProposerDto.setFamilyNo(0);  //��ͥ���
                prpLacciPersonProposerDto.setPhone(proposerPhone[index]);
                prpLacciPersonProposerDto.setRelationCode(proposerRelation[index]);
                String relationName="";
                
                if(proposerRelation[index].equals("1")){
                	relationName ="�������˱���";	
                }
                else if(proposerRelation[index].equals("2")){
                	relationName ="ָ��������";	
                }
                else if(proposerRelation[index].equals("3")){
                	relationName ="��������֮�̳���";	
                }
                else if(proposerRelation[index].equals("4")){
                	relationName ="��������֮�໤��";	
                }
                prpLacciPersonProposerDto.setRelationName(relationName);
                prpLacciPersonProposerDto.setFamilyNo(1);
                
                //���뼯��
                prpLacciPersonList.add(prpLacciPersonProposerDto);
            }
            //�⽡�����������м�������������
           claimDto.setPrpLacciPersonDtoList(prpLacciPersonList);
        }
        /*-------------------������������Ϣ-------end------------------------------------*/
        
        /*---------------------��ʻԱprpLdriver------------------------------------*/
        ArrayList driverList = new ArrayList();
        PrpLdriverDto prpLdriverDto = null;
        //�ӽ���õ���������
        String prpLdriverRegistNo = httpServletRequest.getParameter("prpLclaimRegistNo");
        String prpLdriverClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLdriverRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String prpLdriverPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
        String[] prpLdriverSerialNo = httpServletRequest.getParameterValues("prpLdriverSerialNo");
        String[] prpLdriverDriverName = httpServletRequest.getParameterValues("prpLdriverDriverName");
        String[] prpLdriverDriverPhone = httpServletRequest.getParameterValues("prpLdriverDriverPhone");
        String[] prpLdriverDrivingLicenseNo = httpServletRequest.getParameterValues("prpLdriverDrivingLicenseNo");
        String[] prpLdriverIdentifyType = httpServletRequest.getParameterValues("identifyType");
        String[] prpLdriverIdentifyNumber = httpServletRequest.getParameterValues("prpLdriverIdentifyNumber");
        //����ֵ
        if (prpLdriverSerialNo == null) {
        } else {
            //���߳������ֿ�ʼ
            for (int index = 1; index < prpLdriverSerialNo.length; index++) {
                prpLdriverDto = new PrpLdriverDto();

                prpLdriverDto.setRegistNo(prpLdriverRegistNo);
                prpLdriverDto.setClaimNo(prpLdriverClaimNo);
                prpLdriverDto.setRiskCode(prpLdriverRiskCode);
                prpLdriverDto.setPolicyNo(prpLdriverPolicyNo);
                prpLdriverDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLdriverSerialNo[index])));
                prpLdriverDto.setDriverName(prpLdriverDriverName[index]);
                prpLdriverDto.setDriverSeaRoute(prpLdriverDriverPhone[index]);          
                prpLdriverDto.setDrivingLicenseNo(prpLdriverDrivingLicenseNo[index]);
                prpLdriverDto.setIdentifyType(prpLdriverIdentifyType[index]);
                prpLdriverDto.setIdentifyNumber(prpLdriverIdentifyNumber[index]);
                //���뼯��
                driverList.add(prpLdriverDto);
            }
            //���������м����ԦԱ
            claimDto.setPrpLdriverDtoList(driverList);
        }

        ///*---------------------������PrpLclaimfee------------------------------------*/

        ArrayList claimFeeList = new ArrayList();
        PrpLclaimFeeDto prpLclaimFeeDto = null;
        //�ӽ���õ���������
        String prpLclaimFeeClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLclaimFeeRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLclaimFeeCurrency = httpServletRequest.getParameterValues("prpLclaimFeeCurrency");
        String[] prpLclaimFeeCurrencyName = httpServletRequest.getParameterValues("prpLclaimFeeCurrencyName");

        String[] prpLclaimFeeSumClaim = httpServletRequest.getParameterValues("prpLclaimFeeSumClaim");
        String[] prpLclaimFeeFlag = httpServletRequest.getParameterValues("prpLclaimFeeFlag");
        //����ֵ
        //-������ֿ�ʼ
        if (prpLclaimFeeCurrency == null) {
        } else {
            for (int index = 1; index < prpLclaimFeeCurrency.length; index++) {
                prpLclaimFeeDto = new PrpLclaimFeeDto();

                prpLclaimFeeDto.setClaimNo(prpLclaimFeeClaimNo);
                prpLclaimFeeDto.setRiskCode(prpLclaimFeeRiskCode);
                prpLclaimFeeDto.setCurrency(prpLclaimFeeCurrency[index]);
                prpLclaimFeeDto.setCurrencyName(prpLclaimFeeCurrencyName[index]);
                prpLclaimFeeDto.setSumClaim(Double.parseDouble(prpLclaimFeeSumClaim[index]));
                prpLclaimFeeDto.setFlag(prpLclaimFeeFlag[index]);

                //���뼯��
                claimFeeList.add(prpLclaimFeeDto);
            }
            claimDto.setPrpLclaimFeeDtoList(claimFeeList);
        }
        
        //*---------------------�ձ������PrpLclaimloss------------------------------------*/
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = null;
        //�ӽ���õ���������
        String prpLclaimLossClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLclaimLossRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLclaimLossSerialNo = httpServletRequest.getParameterValues("prpLclaimLossSerialNo");
        String[] prpLclaimLossItemKindNo = httpServletRequest.getParameterValues("prpLclaimLossItemKindNo");
        String[] prpLclaimLossFeeCategory = httpServletRequest.getParameterValues("prpLclaimLossFeeCategory");
        String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode");
        String[] prpLclaimLossItemCode = httpServletRequest.getParameterValues("prpLclaimLossItemCode");
        String[] prpLclaimLossItemDetailName = httpServletRequest.getParameterValues("prpLclaimLossItemDetailName");
        String[] prpLclaimLossCurrency = httpServletRequest.getParameterValues("prpLclaimLossCurrency");
        String[] prpLclaimLossSumClaim = httpServletRequest.getParameterValues("prpLclaimLossSumClaim");
        String[] prpLclaimLossInputDate = httpServletRequest.getParameterValues("prpLclaimLossInputDate");
        String[] prpLclaimLossRemarkFlag = httpServletRequest.getParameterValues("prpLclaimLossRemarkFlag");
        //������¹��������ݴ�RemarkFlag�ֶΣ��������ҵ����û�е����������˵�����Ժ��������ֶ�
        String[] prpLclaimLossAcciName = httpServletRequest.getParameterValues("prpLclaimLossAcciName");
        String[] prpLclaimLossFlag = httpServletRequest.getParameterValues("prpLclaimLossFlag");
        String[] prpLclaimLossKindLoss = httpServletRequest.getParameterValues("prpLclaimLossKindLoss");
        //add by zhaolu 20060914 start
        //�����ֵ
        String[] prpLclaimLossKindRest = httpServletRequest.getParameterValues("prpLclaimLossKindRest");
        //add by zhaolu 20060914 end
        //ԭ����ӱ�־�ֶΣ������������ͷ��á�
        String[] prpLregsitLossFeeType = httpServletRequest.getParameterValues("prpLclaimLossLossFeeType");
        //modify by wangwei add end 2005-06-07
        
        //����ֵ
        //-������ֿ�ʼ
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
               ////�ǳ�û���ϱ�������һ��------------------------------------------------
                if(prpLclaimLossKindLoss !=null && prpLclaimLossKindLoss.length >0 ){ //�ǳ�û���ϱ�������һ��
                   prpLclaimLossDto.setKindLoss(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossKindLoss[index])));
                 }
                else {
                   prpLclaimLossDto.setKindLoss(Double.parseDouble(DataUtils.nullToZero(prpLclaimLossSumClaim[index])));
                }
                if(!"".equals(prpLclaimLossInputDate[index])){
                	prpLclaimLossDto.setInputDate(new DateTime(prpLclaimLossInputDate[index]));
                }else{
                	prpLclaimLossDto.setInputDate(new DateTime(new Date()));
                }
                if("E".equals(strRiskType)||"J".equals(strRiskType)){
                	prpLclaimLossDto.setRemarkFlag(prpLclaimLossAcciName[index]);
                	
                }else{
                	prpLclaimLossDto.setRemarkFlag(prpLclaimLossRemarkFlag[index]);	
                }
                
                
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
        ///*---------------------���ⵥ֤PrpLclaimDoc------------------------------------*/
        ArrayList docList = new ArrayList();
        PrpLdocDto prpLdocDto = null;
        //�ӽ���õ���������
        String prpLdocClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String[] prpLdocDocCode = httpServletRequest.getParameterValues("prpLdocDocCode");
        String[] prpLdocDocName = httpServletRequest.getParameterValues("prpLdocDocName");
        String[] prpLdocDocCount = httpServletRequest.getParameterValues("prpLdocDocCount");
        String[] prpLdocSignInDate = httpServletRequest.getParameterValues("prpLdocSignInDate");
        String[] prpLdocFlag = httpServletRequest.getParameterValues("prpLdocFlag");

        //����ֵ
        //-���ⵥ֤���ֿ�ʼ
        if (prpLdocDocCode == null) {
        } else {
            for (int index = 1; index < prpLdocDocCode.length; index++) {
                prpLdocDto = new PrpLdocDto();
                prpLdocDto.setClaimNo(prpLdocClaimNo);
                prpLdocDto.setDocCode(prpLdocDocCode[index]);
                prpLdocDto.setDocName(prpLdocDocName[index]);
                prpLdocDto.setDocCount(Integer.parseInt(prpLdocDocCount[index]));
                prpLdocDto.setSignInDate(new DateTime(prpLdocSignInDate[index]));
                prpLdocDto.setFlag(prpLdocFlag[index]);
                //���뼯��
                docList.add(prpLdocDto);
            }
            //���������м������ⵥ֤
            claimDto.setPrpLdocDtoList(docList);
        }
        //Modify by chenrenda add begin 20050408
        //Reason:��ʧ��λģ����뵽�永������Ϣ�к���Ӧģ��������
        /*---------------------��ʧ��λ PrpLthirdCarLoss ��ʼ------------------------------------*/
        ArrayList thirdCarLossDtoList = new ArrayList();
        PrpLthirdCarLossDto prpLthirdCarLossDto = null;
        //�ӽ���õ���������
        String prpLthirdCarLossRegistNo = httpServletRequest.getParameter("prpLclaimRegistNo");
        String prpLthirdCarLossRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLthirdCarLossSerialNo = httpServletRequest.getParameterValues("RelateSerialNo");
        String[] prpLthirdCarLossItemNo = httpServletRequest.getParameterValues("prpLthirdCarLossItemNo");
        String[] prpLthirdCarLossLicenseNo = httpServletRequest.getParameterValues("prpLthirdCarLossLicenseNo");
        String[] prpLthirdCarLossPartCode = httpServletRequest.getParameterValues("partCode"); //��������
        String[] prpLthirdCarLossPartName = httpServletRequest.getParameterValues("partName"); //��������
        String[] prpLthirdCarLossCompCode = httpServletRequest.getParameterValues("compCode");//�������
        String[] prpLthirdCarLossCompName = httpServletRequest.getParameterValues("compName");//�������
        String[] prpLthirdCarLossLossGrade = httpServletRequest.getParameterValues("prpLthirdCarLossLossGrade");
        String[] prpLthirdCarLossLossDesc = httpServletRequest.getParameterValues("prpLthirdCarLossLossDesc");
        String[] prpLthirdCarLossFlag = httpServletRequest.getParameterValues("prpLthirdCarLossFlag");

        //����ֵ
        //��ʧ��λ���ֿ�ʼ
        if (prpLthirdCarLossSerialNo == null) {
        } else {
            for (int index = 1; index < prpLthirdCarLossSerialNo.length; index++) {
                prpLthirdCarLossDto = new PrpLthirdCarLossDto();
                prpLthirdCarLossDto.setRegistNo(prpLthirdCarLossRegistNo);
                prpLthirdCarLossDto.setRiskCode(prpLthirdCarLossRiskCode);
                prpLthirdCarLossDto
                        .setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossSerialNo[index])));
                prpLthirdCarLossDto.setItemNo(Integer.parseInt(DataUtils.nullToZero(prpLthirdCarLossItemNo[index])));
                prpLthirdCarLossDto.setLicenseNo(prpLthirdCarLossLicenseNo[index]);
                prpLthirdCarLossDto.setCompCode(prpLthirdCarLossCompCode[index]);
                prpLthirdCarLossDto.setCompName(prpLthirdCarLossCompName[index]);
                prpLthirdCarLossDto.setLossGrade(prpLthirdCarLossLossGrade[index]);
                prpLthirdCarLossDto.setLossDesc(prpLthirdCarLossLossDesc[index]);
                prpLthirdCarLossDto.setFlag(prpLthirdCarLossFlag[index]);
                prpLthirdCarLossDto.setPartCode(prpLthirdCarLossPartCode[index]);
                prpLthirdCarLossDto.setPartName(prpLthirdCarLossPartName[index]);

                //���뼯��
                thirdCarLossDtoList.add(prpLthirdCarLossDto);
            }
            //���������м�����ʧ��λ
            claimDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
        }
        /*---------------------��ʧ��λ PrpLthirdCarLoss ����------------------------------------*/
        //Modify by chenrenda add end 20050408
        //Modify by chenrenda add begin 20050407
        //Reason:ҳ��������������ʧģ��
        /*---------------------������ʧ��λ PrpLthirdProp begin------------------------------------*/
        ArrayList thirdPropDtoList = new ArrayList();
        PrpLthirdPropDto prpLthirdPropDto = null;

        //�ӽ���õ���������

        String prpLthirdPropRegistNo = httpServletRequest.getParameter("prpLclaimRegistNo");
        String prpLthirdPropRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLthirdPropItemNo = httpServletRequest.getParameterValues("prpLthirdPropItemNo");
        String[] prpLthirdPropLicenseNo = httpServletRequest.getParameterValues("prpLthirdPropLicenseNo");
        String[] lossItemCode = httpServletRequest.getParameterValues("prpLthirdLossItemCode");
        String[] LossItemName = httpServletRequest.getParameterValues("prpLthirdLossItemName");
        String[] prpLthirdPropLossDesc = httpServletRequest.getParameterValues("prpLthirdPropLossDesc");
        String[] prpLthirdPropFlag = httpServletRequest.getParameterValues("prpLthirdPropFlag");

        //����ֵ
        //��ʧ��λ���ֿ�ʼ
        if (prpLthirdPropItemNo == null) {
        } else {
            for (int index = 1; index < prpLthirdPropItemNo.length; index++) {

                prpLthirdPropDto = new PrpLthirdPropDto();
                prpLthirdPropDto.setRegistNo(prpLthirdPropRegistNo);
                prpLthirdPropDto.setRiskCode(prpLthirdPropRiskCode);
                prpLthirdPropDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLthirdPropItemNo[index])));
                prpLthirdPropDto.setLicenseNo(prpLthirdPropLicenseNo[index]);
                prpLthirdPropDto.setLossItemCode(lossItemCode[index]);
                prpLthirdPropDto.setLossItemName(LossItemName[index]);
                prpLthirdPropDto.setLossItemDesc(prpLthirdPropLossDesc[index]);
                prpLthirdPropDto.setFlag(prpLthirdPropFlag[index]);

                //���뼯��
                thirdPropDtoList.add(prpLthirdPropDto);
            }

            //���������м�����ʧ��λ
            claimDto.setPrpLthirdPropDtoList(thirdPropDtoList);
        }
        /*---------------------������ʧ��λ PrpLthirdProp end------------------------------------*/
        //Modify by chenrenda add end 20050407

        /*---------------------����������ϵ��¼ PrpLregistExt  2005-07-18------------------------------------*/
        ArrayList prpLregistExtDtoList = new ArrayList();
        PrpLregistExtDto prpLregistExtDto = null ;
        //�ӽ���õ���������
        String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo"); 
        String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
        String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
        String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
        String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
        String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
        String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

        //������ϵ��¼
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
            //���뼯��
            prpLregistExtDtoList.add(prpLregistExtDto);
          }
          //���������м���������ϵ��¼
          claimDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
        }      
        
        /*---------------------�����Ա�������� PrpLpersonTrace 2005-07-26------------------------------------*/
        ArrayList personTraceDtoList = new ArrayList();
        PrpLpersonTraceDto prpLpersonTraceDto = null ;
        //�ӽ���õ���������
       String   prpLpersonTraceRegistNo         =(String)httpServletRequest.getParameter("prpLclaimRegistNo"                   );
       String   prpLpersonTraceClaimNo          = (String) httpServletRequest.getAttribute("claimNo"            );
       String   prpLpersonTracePolicyNo         =httpServletRequest.getParameter      ("prpLclaimPolicyNo"            );
       String[] prpLpersonTracePersonNo         =httpServletRequest.getParameterValues("prpLpersonTracePersonNo"       );
       String[] prpLpersonTracePersonName       =httpServletRequest.getParameterValues("prpLpersonTracePersonName"     );
       String[] prpLpersonTracePersonSex        =httpServletRequest.getParameterValues("personSex"      );
       String[] prpLpersonTracePersonAge        =httpServletRequest.getParameterValues("prpLpersonTracePersonAge"      );
       String[] prpLpersonTraceIdentifyNumber   =httpServletRequest.getParameterValues("prpLpersonTraceIdentifyNumber" );
       String[] prpLpersonTraceRelatePersonNo   =httpServletRequest.getParameterValues("prpLpersonTraceRelatePersonNo" );
       String[] prpLpersonTraceJobCode          =httpServletRequest.getParameterValues("prpLpersonTraceJobCode"        );
       String[] prpLpersonTraceJobName          =httpServletRequest.getParameterValues("prpLpersonTraceJobName"        );
       String[] prpLpersonTraceReferKind        =httpServletRequest.getParameterValues("prpLpersonTraceReferKind"      );
       String[] prpLpersonTracePartDesc         =httpServletRequest.getParameterValues("prpLpersonTracePartDesc"       );
       String[] prpLpersonTraceHospital         =httpServletRequest.getParameterValues("prpLpersonTraceHospital"       );
       String[] prpLpersonTraceMotionFlag       =httpServletRequest.getParameterValues("motionFlag"     );
       String[] prpLpersonTraceWoundRemark      =httpServletRequest.getParameterValues("prpLpersonTraceWoundRemark"    );
       String[] prpLpersonTraceRemark           =httpServletRequest.getParameterValues("prpLpersonTraceRemark"         );
       String[] prpLpersonTraceFlag             =httpServletRequest.getParameterValues("prpLpersonTraceFlag"           );
       
       //����ֵ
       //��Ա�������� ���ֿ�ʼ
       if (prpLpersonTracePersonNo==null)
       {}
       else
       {
         for(int index=1;index<prpLpersonTracePersonNo.length;index++)
         {
           prpLpersonTraceDto = new PrpLpersonTraceDto();
                      
           prpLpersonTraceDto.setRegistNo       (prpLpersonTraceRegistNo         );
           prpLpersonTraceDto.setClaimNo        (prpLpersonTraceClaimNo          );
           prpLpersonTraceDto.setPolicyNo       (prpLpersonTracePolicyNo         );
           prpLpersonTraceDto.setPersonNo       (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonNo       [index] )) );
           prpLpersonTraceDto.setPersonName     (prpLpersonTracePersonName     [index]  );
           prpLpersonTraceDto.setPersonSex      (prpLpersonTracePersonSex      [index]  );
           prpLpersonTraceDto.setPersonAge      (Integer.parseInt(DataUtils.nullToZero(prpLpersonTracePersonAge      [index]))  );
           prpLpersonTraceDto.setIdentifyNumber (prpLpersonTraceIdentifyNumber [index]  );
           prpLpersonTraceDto.setRelatePersonNo (Integer.parseInt(DataUtils.nullToZero(prpLpersonTraceRelatePersonNo [index]) ) );
           prpLpersonTraceDto.setJobCode        (prpLpersonTraceJobCode        [index]  );
           prpLpersonTraceDto.setJobName        (prpLpersonTraceJobName        [index]  );
           if(prpLpersonTraceReferKind!=null){
             prpLpersonTraceDto.setReferKind      (prpLpersonTraceReferKind      [index]  );          
           }
           // prpLpersonTraceDto.setReferKind      ("B");
           prpLpersonTraceDto.setPartDesc       (prpLpersonTracePartDesc       [index]  );
           prpLpersonTraceDto.setHospital       (prpLpersonTraceHospital       [index]  );
           prpLpersonTraceDto.setMotionFlag     (prpLpersonTraceMotionFlag     [index]  );
           prpLpersonTraceDto.setWoundRemark    (prpLpersonTraceWoundRemark    [index]  );
           prpLpersonTraceDto.setRemark         (prpLpersonTraceRemark         [index]  );
           prpLpersonTraceDto.setFlag           (prpLpersonTraceFlag           [index]  );
           //���뼯��
           personTraceDtoList.add(prpLpersonTraceDto);
         }
         //���������м�����ʧ��λ
         claimDto.setPrpLpersonTraceDtoList(personTraceDtoList);
       }
       
       String   DangerUnitCheckSaveFlag = httpServletRequest.getParameter("DangerUnitCheckSaveFlag");
       //�þɵ�Σ�յ�λ��������
       if(DangerUnitCheckSaveFlag.equals("1")){
    	   //******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-16 start------------------------------------*/
           String   prpLclaimLossPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
           UIPolicyAction uiPolicyAction =new UIPolicyAction();
           PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(prpLclaimLossPolicyNo);
           PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
           String strCoinsFlag = prpCmainDto.getCoinsFlag();
           ArrayList dangerUnitList = new ArrayList();
           PrpLdangerUnitDto prpLdangerUnitDto = null;
           //�ӽ���õ���������
           String prpLdangerClaimNo =  (String) httpServletRequest.getAttribute("claimNo");
           String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo");
           String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLclaimRiskCode");
           String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDesc");
           String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerAddressName");
           String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency");
           String[] prpLdangerRiskSumClaim = httpServletRequest.getParameterValues("prpLdangerRiskSumClaim");
           String[] prpLdangerProportion = httpServletRequest.getParameterValues("prpLdangerProportion");
           //��������
           String  prpLclaimDamageStartDate = httpServletRequest.getParameter("prpLclaimDamageStartDate");
           
           //���Ĵ���
           int ednorserTimes = policyDto.getPrpCmainDto().getEndorseTimes();
           //������
           String policyno = policyDto.getPrpCmainDto().getPolicyNo();
           BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
           List prpDangerShareList = new ArrayList();
           //ȡ�˱�����������������Σ�յ�λ�ı���
           prpDangerShareList = blPrpLclaimFacade.getDangerShareList(policyno, ednorserTimes, prpLclaimDamageStartDate);
           

           //����ֵ
           double temSumLoss = 0;
           double sumLost = 0;//�����һ��Σ�յ�λ�ۼ�ֵ
           double temSumNoPaid = 0;
           double sumNoPaid = 0;//�����һ��Σ�յ�λ�ۼ�ֵ
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
                       	 if(i==prpDangerShareList.size()-1)//���һ��Σ�յ�λ�ü�����
                       	 {
                       		temSumLoss = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumLost;
                       	    temSumNoPaid = Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumNoPaid;
                       	 }
                       	 else
                         //�����һ��Σ�յ�λ�ó˷���
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
                     	 
                     	 
                         //���뼯��
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
          //******---------------------Σ�յ�λ��Ϣ add by qinyongli 2005-8-16  end------------------------------------*/
       }else if(DangerUnitCheckSaveFlag.equals("2")){
    	   //���µ�Σ�յ�λ��������
    	   //******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ�� start------------------------------------*/
    	      
           
           String   prpLclaimLossPolicyNo = httpServletRequest.getParameter("prpLclaimPolicyNo");
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
           //�ӽ���õ���������
           String prpLdangerClaimNo =  (String) httpServletRequest.getAttribute("claimNo");//������
           String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo");//������
           String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLdangerRiskCode");//���ֺ�
           String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDangerDesc");//Σ�յ�λ��
           String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerUnitAddressName");//Σ�յ�λ��ַ
           String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency");//�ұ�
           String[] prpLdangerUnitSumLoss = httpServletRequest.getParameterValues("prpLdangerUnitSumLoss");//������
           String[] prpLdangerDangerNo = httpServletRequest.getParameterValues("prpLdangerDangerNo");//Σ�յ�λ��
           String[] prpLdangerShare = httpServletRequest.getParameterValues("prpLdangerShare");//ռ��
           String[] prpLdangerKindcode = httpServletRequest.getParameterValues("prpLdangerKindcode");//�ձ����
           String[] prpLdangerKindname = httpServletRequest.getParameterValues("prpLdangerKindname");//�ձ�����
           String[] prpLdangerItemCode = httpServletRequest.getParameterValues("prpLdangerItemCode");//��Ĵ���
           String[] prpLdangerItemName = httpServletRequest.getParameterValues("prpLdangerItemName");//�������
           String[] prpLdangerUnitItemKindNo = httpServletRequest.getParameterValues("prpLdangerUnitItemKindNo");//������
           
           //1�����ɴ����Σ�յ�λ���prpLdangerItem
           if (prpLdangerCurrency == null) {
    			
    		} else {
    		
    			PrpLdangerItemDto prpLdangerItemDto=null;
    		   for (int index = 1; index < prpLdangerCurrency.length; index++) {
    		      if(Double.parseDouble(prpLdangerUnitSumLoss[index])!=0&&Double.parseDouble(prpLdangerShare[index])!=0){
    		    	prpLdangerItemDto= new PrpLdangerItemDto();       
    				prpLdangerItemDto.setCertiNo(prpLdangerClaimNo); // ������
    				prpLdangerItemDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); 
    				prpLdangerItemDto.setCurrency(prpLdangerCurrency[index]); // ��ʧ�ұ�
    				prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
    				prpLdangerItemDto.setKindCode(prpLdangerKindcode[index]);    
                    prpLdangerItemDto.setKindName(prpLdangerKindname[index]);  
    				prpLdangerItemDto.setRiskCode(prpLdangerRiskCode[index]); 
    				prpLdangerItemDto.setAddressName(prpLdangerAddressName[index]);
    				prpLdangerItemDto.setPolicyno(prpLdangerPolicyNo[index]);
    				prpLdangerItemDto.setDangerdesc(prpLdangerUnitDesc[index]);
    				prpLdangerItemDto.setItemcode(prpLdangerItemCode[index]);
     				prpLdangerItemDto.setItemname(prpLdangerItemName[index]);
    				//ռ�����һ������ԭ��
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
    				prpLdangerItemDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // ������
    				
    				sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
    				 //���뼯��
                  	 if(prpLdangerItemDto!=null){
                  		 dangerItemList.add(prpLdangerItemDto);
                  	 }
    			  }
    		    
    		    if(dangerItemList.size()>0){
                 	claimDto.setPrpLdangerItemDtoList(dangerItemList);
               }
    		 }
    		}
           
           //2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��
           
           Iterator     iterator   = null;
           PrpLdangerTotDto prpLdangerTotDto   = null; 
           Iterator      itTot  = null;
    		PrpLdangerItemDto prpLdangerItemDto = null;       //���DTO
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
           		//ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
           		if (find == false)
           		{
           			prpLdangerTotDto = new PrpLdangerTotDto();
                       
                     prpLdangerTotDto.setCertiNo(prpLdangerClaimNo);
       		  		 prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());                        
       		  		 prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency());   //���ԭ�ұ�
       		  		 prpLdangerTotDto.setSumFee(0);
       		  		 prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
       		  		 prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
       		  		 prpLdangerTotDto.setExchRate(1);
       		  		 prpLdangerTotDto.setSumFeeEx(0);
       		  		 prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
       		  	 	 //���뼯��
                   	 if(prpLdangerTotDto!=null){
                   		dangerTotList.add(prpLdangerTotDto);
                   	 }
               		
           		}
             
           	}

           	  if(dangerTotList.size()>0){
                   	claimDto.setPrpLdangerTotDtoList(dangerTotList);
                 }
           }
          
           
           
           //3������Σ�յ�λprpLdangerUnit
          
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
           		//ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
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
                 	 //prpLdangerUnitDto.setAgricultureflag(prpCmainDto.getBusinessType1());
                 	    //���뼯��
                   	 if(prpLdangerUnitDto!=null){
                   		dangerUnitList.add(prpLdangerUnitDto);
                   	 }
           		}
           	}
           	//���һ��ռ�ȼ���ԭ��
           	double dangerShare = 0;
           	double tempSumDangerShare = 0;
           	PrpLdangerUnitDto prpLdangerUnitDtotemp=null;
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
          //******---------------------Σ�յ�λ��Ϣ ��Ԫ��Ŀ��   end------------------------------------*/
       }
      
   

       
       //���ڻ�����������Ϣ����
       String claimNo = (String) httpServletRequest.getAttribute("claimNo");
       String prpLextSalvor = (String) httpServletRequest.getParameter("prpLextSalvor");
       DateTime uploadDate = new DateTime( httpServletRequest.getParameter("prpLextUnloadDate"),DateTime.YEAR_TO_DAY);
       
       //if(prpLclaimLossRiskCode.substring(0,2).equals("09")||prpLclaimLossRiskCode.substring(0,2).equals("10")){
               //modify by   ��Ŀ��   ������  ����10�޸�Ϊ02
      
		if ("Y".equals(strRiskType)) {
       	PrpLextDto  prplextDto = new PrpLextDto();
               prplextDto.setCertiNo(claimNo);
               prplextDto.setCertiType("03");
               prplextDto.setUnloadDate(uploadDate);
               prplextDto.setSalvor(prpLextSalvor);
               claimDto.setPrpLextDto(prplextDto);
       }
        return claimDto;
    }

    /**
     * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��д������ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ� ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
     * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
     * 
     * @param httpServletRequest
     * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
     * @throws Exception
     */
    public ClaimDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception {
        ClaimDto claimDto = new ClaimDto();
        return claimDto;
    }

    /**
     * ��д����ҳ�漰��ѯ����request������. ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request�� ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
    public void dtoToView(HttpServletRequest httpServletRequest, ClaimDto claimDto) throws Exception {
        //�õ�request��PrpLregistForm������ʾ
        PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
        httpServletRequest.setAttribute("prpLcalimForm", prpLclaimDto);

        //�õ�request��prpLthirdPartyForm������ʾ
        Collection prpLthirdPartyList = claimDto.getPrpLthirdPartyDtoList();
        httpServletRequest.setAttribute("prpLthirdPartyForm", prpLthirdPartyList);

        //�õ�request��prpLdriverForm������ʾ
        Collection prpLdriverList = claimDto.getPrpLdriverDtoList();
        httpServletRequest.setAttribute("prpLdriverForm", prpLdriverList);

        //�õ�request��prpLltextForm������ʾ
        Collection prpLltextDtoList = claimDto.getPrpLltextDtoList();
        httpServletRequest.setAttribute("prpLltextForm", prpLltextDtoList);

        //�õ�request��prpLclaimFee������ʾ
        Collection prpLclaimFeeDtoList = claimDto.getPrpLclaimFeeDtoList();
        httpServletRequest.setAttribute("prpLclaimFeeForm", prpLclaimFeeDtoList);

        //�õ�request��prpLdoc������ʾ
        Collection prpLdocDtoList = claimDto.getPrpLdocDtoList();
        httpServletRequest.setAttribute("prpLdocForm", prpLdocDtoList);

    }

    /**
     * ��д����ҳ�漰��ѯ����request������. ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request�� ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */
    public PrpLclaimDto registDtoToView(HttpServletRequest httpServletRequest, String registNo, int index) throws Exception {
        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��������
    	HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        UIRegistAction uiRegistAction = new UIRegistAction();
        String policyNo = (String)httpServletRequest.getAttribute("policyNo_"+index);  //add by lym 20060605 for ǿ��
        String riskCode = (String)httpServletRequest.getAttribute("riskCode_"+index);  //add by lym 20060605 for ǿ��
        ClaimDto claimDto = new ClaimDto();
        
        String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			if (registNo != null)
			{		
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "certa",registNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList_"+index, prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag_"+index, "true");//���ö�����嵥�б�
		}
        
        //���鿱��Ϣ���뵽������
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);  
        ArrayList list = new ArrayList();
        ArrayList prpLregistTextDtoList3 = new ArrayList();
        if(checkDto.getPrpLextDto()==null){
        	
            httpServletRequest.setAttribute("prpLextDto_"+index, new PrpLextDto());
        }else{
        	
            httpServletRequest.setAttribute("prpLextDto_"+index, checkDto.getPrpLextDto());
        }
                
        //���ݲ�ѯ�������������ݣ���PrpLclaimDto��ֵ
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        prpLcheckDto =  checkDto.getPrpLcheckDto();
        if (prpLcheckDto == null) //Ҫ��ʾ������֮ǰ�������鿴�ģ�����
        {
           
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
            if (checkDto.getPrpLregistTextDtoList3() != null) {
                Iterator iterator = checkDto.getPrpLregistTextDtoList3().iterator();
                while (iterator.hasNext()) {
                    PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
                    PrpLltextDto prpLltextDto = new PrpLltextDto();
                    prpLltextDto.setContext(prpLregistTextDto.getContext());
                    prpLltextDto.setTextType(prpLregistTextDto.getTextType());
                    prpLregistTextDtoList3.add(prpLltextDto);
                }
            }
            prpLclaimDto.setIndemnityDuty(prpLcheckDto.getIndemnityDuty());
            String indemnityDuty = prpLcheckDto.getIndemnityDuty();
            double indemnityDutyRate = 100;
            
            //ת���⳥����
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
        //��ѯ������Ϣ����ȡ�ʵ�����Ϣ���µǼǵ�������
        RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto  = registDto.getPrpLregistDto();
        
        //add by zhaolu start at 2006-06-09
    	//reason ǿ�Ʊ���������Ϣд��������
        httpServletRequest.setAttribute("prpLregistRPolicyNo_"+index,registDto.getPrpLRegistRPolicyDtoOfCompel());
	    //add by zhaolu end at 2006-06-09
        //modify by wangwei add start 2005-06-10
        //ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();
        Collection registClaimDtoList = (Collection) uiClaimAction.findByPolicyNo(policyNo);  
        httpServletRequest.setAttribute("registClaimDtoList_"+index, registClaimDtoList);
        //modify by wangwei add end 2005-06-10
        //add by qinyongli start 2005-8-27 
        //���δ�鿱����������ʱ���ӱ����������ժҪĬ����Ϊ����ժҪ
        //���������ת�����õ���prpLregistTextDto���ݴ��ݸ�prpLltextDto
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
        if(prpLregistTextDtoList3.size()<1){
        	prpLregistTextDtoList3 = registDto.getPrpLregistTextDtoList3();
        	Collection listTemp = new ArrayList();
            Iterator iteratorList = prpLregistTextDtoList3.iterator();
            PrpLregistTextDto prpLregistTextDto = null;
            while(iteratorList.hasNext()){
            	PrpLltextDto prpLltextDto = new PrpLltextDto();
            	prpLregistTextDto =(PrpLregistTextDto)iteratorList.next();
            	prpLltextDto.setContext(prpLregistTextDto.getContext());
            	prpLltextDto.setTextType(prpLregistTextDto.getTextType());
            	listTemp.add(prpLltextDto);
            }    	
            prpLregistTextDtoList3 =(ArrayList)listTemp;
        }
        //add by qinyongli end
        prpLclaimDto.setRegistNo(prpLregistDto.getRegistNo());
        prpLclaimDto.setPolicyNo(policyNo); //modify by lym 20060605 for   ǿ��
        prpLclaimDto.setDamageCode(prpLregistDto.getDamageCode());
        prpLclaimDto.setDamageName(prpLregistDto.getDamageName());
        prpLclaimDto.setDamageTypeCode(prpLregistDto.getDamageTypeCode());
        prpLclaimDto.setDamageTypeName(prpLregistDto.getDamageTypeName());
        prpLclaimDto.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
        prpLclaimDto.setDamageAreaName(prpLregistDto.getDamageAreaName()); 
        if ( prpLcheckDto==null){
        	 prpLclaimDto.setIndemnityDuty("0"); 
        	 prpLclaimDto.setIndemnityDutyRate(100);
        }
         //����ʱ���յص�ȡ�鿱�ģ����û�о�ȡ�����ĳ��յص�----------------------------------
         if ( prpLcheckDto==null || prpLcheckDto.getDamageAddress()==null || prpLcheckDto.getDamageAddress().equals("")){
         	 prpLclaimDto.setDamageAddress(prpLregistDto.getDamageAddress());
         	 prpLclaimDto.setDamageAddressType(prpLregistDto.getDamageAddressType());
         	
         }
         else {
         	 prpLclaimDto.setDamageAddress(prpLcheckDto.getDamageAddress());
         	 prpLclaimDto.setDamageAddressType(prpLcheckDto.getDamageAddressType());
         }
         //�ⰸ�������鿱û�У��ʹӱ���ȡ  modify by YANGABO 2008-01-16
         if ( prpLcheckDto==null || prpLcheckDto.getClaimType().equals("")){
        	 prpLclaimDto.setClaimType(prpLregistDto.getClaimType());
         }
         else{
        	 prpLclaimDto.setClaimType(prpLcheckDto.getClaimType());
         }
        prpLclaimDto.setRiskCode(riskCode);  //modify by lym 20060605 for   ǿ�� 
        String timeTemp = "";
        timeTemp = StringConvert.toStandardTime(prpLregistDto.getDamageStartHour());
        prpLclaimDto.setDamageStartDate(prpLregistDto.getDamageStartDate());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(prpLregistDto.getDamageEndHour());
        prpLclaimDto.setDamageEndDate(prpLregistDto.getDamageEndDate());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        prpLclaimDto.setClassCode(prpLregistDto.getClassCode());
        if("05".equals(prpLclaimDto.getClassCode())){
        	prpLclaimDto.setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
        }else{
        	prpLclaimDto.setClaimDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
        	prpLclaimDto.setClaimTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND));
        }
        //prpLclaimDto.setClaimDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setInsuredCode(prpLregistDto.getInsuredCode());
        prpLclaimDto.setInsuredName(prpLregistDto.getInsuredName());
        
        if(!prpLregistDto.getInsuredCode().equals(""))
        {
        	UICodeAction uiCodeAction = new UICodeAction();
        	prpLclaimDto.setCustomerType(uiCodeAction.getCustomerType(prpLregistDto.getInsuredCode()));
        }
        prpLclaimDto.setComCode(prpLregistDto.getComCode());
        prpLclaimDto.setAddressCode(prpLregistDto.getAddressCode());
        
        //ȱʡ���������ıұ� 2005-09-05
         //modify by qinyngli 20051021  ������������й��鿱��ȡ�鿱�ұ�
        UICodeAction uiCodeAction = new UICodeAction();
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLregistDto.getRiskCode());
		
		if ("Y".equals(strRiskType)) {
        	 if(uiCheckAction.isExist(registNo)) {
                 PrpLextDto prpLextDto = checkDto.getPrpLextDto();
                 //Modify by zhaolu 20060908 start
                 if(prpLextDto != null)
                 prpLclaimDto.setEstiCurrency(prpLextDto.getCurrency());
                 //Modify by zhaolu 20060908 end
             }else{
             	prpLclaimDto.setEstiCurrency(prpLregistDto.getEstiCurrency());
             }
        }else{
        	prpLclaimDto.setEstiCurrency(prpLregistDto.getEstiCurrency());
        }
        //modify by qinyongli end
        //��Ӱ������� 2005-08-01               
        //prpLclaimDto.setClaimType("1");             
        //prpLclaimDto.setClaimTypeName("�پ��ⰸ");
        //���бұ�ת�����õ���������
        String strCurrencyName = uiCodeAction.translateCurrencyCode(prpLclaimDto.getEstiCurrency(), true);
        httpServletRequest.setAttribute("strCurrencyName_"+index, strCurrencyName);
        
        //�¹�����Ϣģ���ʼ��
        ArrayList prplacciBenPersonDtoList = registDto.getPrplacciBenPersonDtoList();
        PrpLacciPersonDto prpLacciBenPersonDto = new PrpLacciPersonDto();
        prpLacciBenPersonDto.setPrpLacciBenPersonList(prplacciBenPersonDtoList);
        prpLacciBenPersonDto.setPrpLacciPersonList(prplacciBenPersonDtoList); //����������ģ��
        httpServletRequest.setAttribute("prpLacciPersonDto_"+index,prpLacciBenPersonDto); 
       
        //lixiang �������ݽṹ������
        prpLclaimDto.setLanguage(prpLregistDto.getLanguage());
        prpLclaimDto.setLossName(prpLregistDto.getLossName());
        prpLclaimDto.setMakeCom(prpLregistDto.getMakeCom());
        prpLclaimDto.setHandler1Code(prpLregistDto.getHandler1Code());
        prpLclaimDto.setOperatorCode(user.getUserCode());
        //������Ļ�ȡ������ǲ鿱�����𣬺��𶼿���������
        prpLclaimDto.setSumClaim(prpLregistDto.getEstimateLoss());
        //����Ĭ�ϵľ�����
        prpLclaimDto.setHandlerCode(user.getUserCode());
        
        //�����⸶�������⸶������λ����
        //ֱ���ð��ŵİ汾�����޸�,����Ŀǰ������lossItemCode �Ĵ洢���淶,���Ժ��Ѹ�������ȥ��ѯ�����¼.
        UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction
				.findByPrimaryKey(registNo);
		ArrayList verifyLossList = certainLossDto.getPrpLverifyLossDtoList();
		if (verifyLossList.size() > 0) {
			PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) verifyLossList
					.get(0);
			if (prpLverifyLossDto != null) {
					// ����⸶������Ϊ0˵�����ں��𻷽ڲ����ں��𻷽�¼��������
					prpLclaimDto.setLossesNumber(prpLverifyLossDto
							.getLossesNumber());
					prpLclaimDto.setLossesUnitCode(prpLverifyLossDto
							.getLossesUnitCode());
					prpLclaimDto.setDamageInsured(prpLverifyLossDto
							.getDamageInsured());
					prpLclaimDto.setDisasterArea(prpLverifyLossDto
							.getDisasterArea());
					prpLclaimDto.setDisasterUnit(prpLverifyLossDto
							.getDisasterUnit());
					prpLclaimDto.setAffectedArea(prpLverifyLossDto
							.getAffectedArea());
					prpLclaimDto.setAffectedUnit(prpLverifyLossDto
							.getAffectedUnit());
					prpLclaimDto.setNoProductionArea(prpLverifyLossDto
							.getNoProductionArea());
					prpLclaimDto.setNoProductionUnit(prpLverifyLossDto
							.getNoProductionUnit());
					prpLclaimDto.setDeathQuantity(prpLverifyLossDto
							.getDeathQuantity());
					prpLclaimDto.setDeathUnit(prpLverifyLossDto.getDeathUnit());
					prpLclaimDto.setKillQuantity(prpLverifyLossDto
							.getKillQuantity());
					prpLclaimDto.setKillUnit(prpLverifyLossDto.getKillUnit());
			}
		}
        
       
        
        
//        prpLclaimDto.setLossesNumber(prpLregistDto.getLossesNumber());
//        prpLclaimDto.setLossesUnitCode(prpLregistDto.getLossesUnitCode());
        //���ӳ��ջ���


        //�Գ���,�������Ϣ��֧��
        prpLclaimDto.setClauseType(prpLregistDto.getClauseType());
        prpLclaimDto.setClauseName(prpLregistDto.getClauseName());
        prpLclaimDto.setLicenseNo(prpLregistDto.getLicenseNo());
        prpLclaimDto.setLicenseColorCode(prpLregistDto.getLicenseColorCode());
        prpLclaimDto.setLicenseColor(prpLclaimDto.getLicenseColorCode());
        prpLclaimDto.setBrandName(prpLregistDto.getBrandName());
        prpLclaimDto.setCarKindCode(prpLregistDto.getCarKindCode());
        prpLclaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        //��������������״̬Ϊ �°����Ǽ� (δ��������)
        prpLclaimDto.setStatus("1");

        //�ӱ����л����Ϣ
        if (!policyNo.equals("")) { //modify by lym 20060605 for  ǿ��
                 //��ѯ������Ϣ
        	     EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
        	     //���ݳ������ڻ�ó���ʱ�ı�����Ϣ  
    		     PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo   //modify by lym 20060605 for  ǿ��
    		     		,prpLregistDto.getDamageStartDate().toString()
						,prpLregistDto.getDamageStartHour()); 
    		     //���ձ���Ϣѹ��ҳ����
    		     if("D".equals(strRiskType)||"Q".equals(strRiskType)||"C".equals(strRiskType)||"Y".equals(strRiskType)){
    		    	    ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
    	    		    httpServletRequest.setAttribute("damageKindList_"+index, damageKindList); 
    	    		    String defaultKindCode = getDefaultKindCodeByPolicyDto(policyDto);
    	    		    httpServletRequest.setAttribute("defaultKindCode_"+index,defaultKindCode);
    		     }
    		      //add by qinyongli begin  2005-7-19
    		      //�õ������͹ɶ�ҵ����Ϣ�ٷ���Ϣ
    		      if(policyDto!=null){
    		       	httpServletRequest.setAttribute("coinsFlag_"+index, policyDto.getPrpCmainDto().getCoinsFlag());
    		        httpServletRequest.setAttribute("shareHolderFlag_"+index, policyDto.getPrpCmainDto().getShareHolderFlag());
    		       
    		        String conditions = "reinsType in ('1','2')  and policyno = '" + prpLregistDto.getPolicyNo()+"'";
    		        BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
    		        ArrayList reins =(ArrayList) blFcoRepolicyFacade.findByConditions(conditions);
    		        if(reins!=null&&reins.size()>0){
    		        	httpServletRequest.setAttribute("tempReinsFlag_"+index, "1");
    		        }else{
    		        	httpServletRequest.setAttribute("tempReinsFlag_"+index, "0");
    		        }
                    
                    //��ӱ�����Ϣ 2005-9-26
                    //����ҵ������䷽ʽ�����ߵĴ洢�ֶβ�Ψһ�������ڴ˴�Ҫ��һ������
                    PrpCmainCargoDto prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
                    uiCodeAction = new UICodeAction();
                    if (prpCmainCargoDto != null) {
                        if (prpCmainCargoDto.getBLNo() == null
                            || prpCmainCargoDto.getBLNo() == "") {
                            prpCmainCargoDto.setBLNo(uiCodeAction.translateCodeCode("ConveyanceType",
                                                      prpCmainCargoDto.getConveyance(), true));
                        }
                   }
                    httpServletRequest.setAttribute("prpCmainCargoDto_"+index, prpCmainCargoDto);
                }
    		     //add by qinyongli  end  2005-7-19 
            prpLclaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
            prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
            prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
            prpLclaimDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
            //ȡ�����������ƣ������ŵ���Ҫ��ʾ����
            String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
			    	strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();
			    	
			}
			else {
					strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";
					
			}
			
			prpLclaimDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
			prpLclaimDto.setInsuredNameShow(strInsuredNameShow);
			prpLclaimDto.setAppliNameShow(policyDto.getPrpCmainDto().getAppliName());
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
            prpLclaimDto.setSumInsured(policyDto.getPrpCmainDto().getSumInsured());
            claimDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
            //add start by qingyongli 2005-7-28
            prpLclaimDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
            prpLclaimDto.setUnderWriteEndDate(policyDto.getPrpCmainDto().getUnderWriteEndDate());
            httpServletRequest.setAttribute("liabStartDate_"+index, policyDto.getLiabStartDate());
            //add end by qingyongli 2005-7-28
        }
        //modify by qinyongli add 20050720 start
        UIConfigAction uiConfigAction = new UIConfigAction();
        //��ȡϵͳ������Ϣ����������
        String standardDays = "" ; //��ȡ��������
        standardDays = uiConfigAction.getConfigValue("CLAIM_DAYS",prpLclaimDto.getRiskCode());
        if(standardDays==null||standardDays.equals("")){
        	throw new UserException(1,3,"platform","����ϵϵͳ����Ա����ƽ̨����ϵͳ�н�������"+prpLclaimDto.getRiskCode()+"'��������'�ĳ�ʼ����");
        }
        //��ǰʱ���ȥ����ʱ��
        DateTime currentDate = new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY);
        DateTime registDate = prpLregistDto.getReportDate();
        httpServletRequest.setAttribute("registDate_"+index, registDate);
        httpServletRequest.setAttribute("standardDays_"+index, standardDays);
        long current_regist = (currentDate.getTime()-registDate.getTime())/(1000*60*60*24);
        
        if(current_regist>=Integer.parseInt(standardDays)){
        	httpServletRequest.setAttribute("claim_days_"+index, "0");//0��ʾ������������ϵͳ�涨ʱ�䣬������ʾ
        }else{
        	httpServletRequest.setAttribute("claim_days_"+index, "1");//0��ʾ��������С��ϵͳ�涨ʱ�䣬��������ʾ
        }
        //modify by qinyongli add 20050720 end
        //������ش��������ת��
        changeCodeToName(prpLclaimDto);
        //���ô�����и�����ѡ���е�����
        setSelectionList(httpServletRequest, prpLclaimDto);
        //��ѯ��ͬ�����ŵĳ��մ���
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLclaimDto.getPolicyNo(),prpLclaimDto.getRegistNo());

        //���þ��ִ�����Ϣ
        prpLclaimDto.setCatastropheCode1(prpLregistDto.getCatastropheCode1());
        prpLclaimDto.setCatastropheName1(prpLregistDto.getCatastropheName1());
        prpLclaimDto.setCatastropheCode2(prpLregistDto.getCatastropheCode2());
        prpLclaimDto.setCatastropheName2(prpLregistDto.getCatastropheName2());
        
        //������������Ϣ���ݵ������
        httpServletRequest.setAttribute("prpLclaimDto_"+index, prpLclaimDto);
        
        //�ڽ�������ʾ�������� 2005-09-09
        uiCodeAction = new UICodeAction();
        httpServletRequest.setAttribute("riskCName_"+index, uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(), true));
        
        //Reason:��ʧ��λ��ʾ��Ϊ�б��ʽ
        httpServletRequest.setAttribute("partCodeList_"+index, ICollections.getPartCodeList());

        //Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
        String strPrpLnodeType = "claim";
        httpServletRequest.setAttribute("prpLnodeType_"+index, strPrpLnodeType);
        httpServletRequest.setAttribute("riskType_"+index, strRiskType);
        
        //add by qinyongli start 2005-8-16
        //reason:��ȡΣ�յ�λ��Ϣ
        UIRiskUnitAction blPrpCdangerUnitFacade = new UIRiskUnitAction();
        PrpCdangerUnitDto prpCdangerUnitDto = blPrpCdangerUnitFacade.findByPrimaryKeyFromPrpCdangerUnit(policyNo,1
        		,httpServletRequest,riskCode);  //modify by lym 20060605 for  ǿ��
        PrpLdangerUnitDto prpLdangerUnitDto = new PrpLdangerUnitDto();
        if(prpCdangerUnitDto!=null){
            prpLdangerUnitDto.setAddressName(prpCdangerUnitDto.getAddressName());
            prpLdangerUnitDto.setDangerDesc(prpCdangerUnitDto.getDangerDesc()); 
            prpLdangerUnitDto.setPolicyNo(prpCdangerUnitDto.getPolicyNo());
            prpLdangerUnitDto.setRiskCode(prpCdangerUnitDto.getRiskCode());
            prpLdangerUnitDto.setCurrency(prpLregistDto.getEstiCurrency());
            uiCodeAction = new UICodeAction();
            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLregistDto.getEstiCurrency(), true)); //�ô��ֶα�ʾ�ұ�������Ϣ
        }
        httpServletRequest.setAttribute("prpLdangerUnitDto_"+index, prpLdangerUnitDto);
        //add by qinyongli end 2005-8-16
         
        //���ø����ӱ���Ϣ������
        
        //�������ļ������б�׼������
        claimDto.setPrpLdriverDtoList(registDto.getPrpLdriverDtoList());
        claimDto.setPrpLthirdCarLossDtoList(registDto.getPrpLthirdCarLossDtoList());
        claimDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
        claimDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
        
        //������˸�����Ϣ 2005-07-26
        claimDto.setPrpLpersonTraceDtoList(registDto.getPrpLpersonTraceDtoList());
        
        //��Ϊ����¼�룬���Զ��ǿյġ�
        ArrayList arrayList = new ArrayList();
        claimDto.setPrpLclaimFeeDtoList(arrayList);
        claimDto.setPrpLdocDtoList(arrayList);
        claimDto.setPrpLltextDtoList(arrayList);
        claimDto.setPrpLltextDtoList(list);
        claimDto.setPrpLltextDtoList3(prpLregistTextDtoList3);
        
        //��������Ϣ������ϵ��¼�����б�׼������
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(prpLregistDto.getRegistNo());
        prpLregistExtDto.setRiskCode(riskCode);  //modify by lym 20060605 for  ǿ��
        arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
        prpLregistExtDto.setRegistExtList(arrayListRegistExt);
        httpServletRequest.setAttribute("prpLregistExtDto_"+index, prpLregistExtDto);
        
        //׼���Ա���Ϣ
        claimDto.setPrpLclaimDto(prpLclaimDto);
        setSubInfo(httpServletRequest, claimDto);

        //����Ĭ�ϵĹ�������ӱ�����Ϣ
        ArrayList prpLclaimLossDtoList = new ArrayList();
        // ����������Ϣ�Ӷ��𻷽��Զ����� ��Ԫ����Ŀǰ��Ԫ���������ȶ���������
        // TODO:�������������ڴ�����ʱ��Ŀǰֻ�����˲Ʋ���ʧ���֣����˲���û�д��룬Ŀǰ�����ն���ʱֻ�вƲ�����û�����˶������̲�����
        // �����̸�����ɺ������˲��ֵĴ����������ɾ���˲���ע��  leave by yehuiquan ��Ԫ 2008-08-15
        if ("H".equals(strRiskType) || "Q".equals(strRiskType) || "I".equals(strRiskType)
				|| "Z".equals(strRiskType) || "Y".equals(strRiskType)) {
			if (registNo.length() > 21) {
				registNo = registNo.substring(0, 21);
			}
			VerifyLossDto verifyLossDto = new VerifyLossDto();
			BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
			verifyLossDto = bLVerifyLossFacade.findByPrimaryKey(registNo, null,
					null);
			ArrayList prpLpropDtoList = verifyLossDto.getPrpLpropDtoList();
			Iterator it = prpLpropDtoList.iterator();
			while (it.hasNext()) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) it.next();
				PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
				prpLclaimLossDto.setFamilyNo(prpLpropDto.getFamilyNo());
				prpLclaimLossDto.setFamilyName(prpLpropDto.getFamilyName());
				prpLclaimLossDto.setRiskCode(prpLpropDto.getRiskCode());
				prpLclaimLossDto.setSerialNo(prpLpropDto.getSerialNo());
				prpLclaimLossDto.setItemKindNo(prpLpropDto.getItemKindNo());
				prpLclaimLossDto.setKindCode(prpLpropDto.getKindCode());
				// �����ձ����
				prpLclaimLossDto.setKindName(uiCodeAction.translateKindCode(prpLpropDto
						.getRiskCode(), prpLpropDto.getKindCode(), true));
				prpLclaimLossDto.setItemCode(prpLpropDto.getItemCode());
				// �����Ĵ���
				prpLclaimLossDto.setItemDetailName(prpLpropDto.getLossItemName());
				// �ձ𱣶�
				double itemKindAmount = 0.0;
				// ȡ������ֻ����ձ𱣶���Ϣ
				if(GroupProposalService.isGroupProposal(prpLpropDto.getRiskCode())) {
					BLPrpCvirturlItem blPrpCvirturlItem = new BLPrpCvirturlItem();
					blPrpCvirturlItem.query("policyNo = '" + prpLpropDto.getPolicyNo()
							+ "' and itemKindNo = '" + prpLpropDto.getItemKindNo() + "'");
					if(blPrpCvirturlItem.getSize() > 0) {
						itemKindAmount = Double.parseDouble(blPrpCvirturlItem.getArr(0).getAmount());	
					}
				}
				// ������ֻ���Ϣ
				else {
					BLPrpCitemKindFacade itemKindFacade = new BLPrpCitemKindFacade();
					List itemKindDtoList = (List)itemKindFacade.findByConditions("policyNo = '" + prpLpropDto.getPolicyNo()
							+ "' and itemKindNo = '" + prpLpropDto.getItemKindNo() + "'");
					if(itemKindDtoList != null && itemKindDtoList.size() > 0) {
						itemKindAmount = ((PrpCitemKindDto)itemKindDtoList.get(0)).getAmount();	
					}
				}
				prpLclaimLossDto.setItemAmount(itemKindAmount); 
				prpLclaimLossDto.setCurrency(prpLpropDto.getCurrency());
				prpLclaimLossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
				prpLclaimLossDto.setSumClaim(prpLpropDto.getSumLoss()); // ������
				prpLclaimLossDto.setInputDate(new DateTime(new Date()));
				prpLclaimLossDtoList.add(prpLclaimLossDto);
			}
		}
        // ����ֲ�����ݴӱ������߲鿱���ڴ���(��Ҫ�ǳ���)
        else {
			setFirstClaimFeeLoss(httpServletRequest, prpLclaimDto,strRiskType);	
		}
        claimDto.setPrpLclaimLossDtoList(prpLclaimLossDtoList);
        
        
        if ("E".equals(strRiskType)) {  
        	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	int intCount = 0;     //û���ύ�����������Ŀ
        	String strFlowID = httpServletRequest.getParameter("swfLogFlowID");
        	String strSql = " FLOWID='" + strFlowID + "' and NODETYPE='check' and NODESTATUS<>'4'";
        	intCount = uiWorkFlowAction.findNodesByConditions(strSql).size();
        	httpServletRequest.setAttribute("com.sinosoft.acciFlag_"+index, intCount>0?"N":"Y");   //����һ����־λ��N��ʾ�����ύ��Y��ʾ�����ύ��
        }
        
        //��ȡ�һ�����Ϣ 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction();       
        
        
        prpdexchDtoList = uiExchAction.getExchOfMaxDate("2007-01-03");
       // prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime().current().toString().substring(0,10));
        httpServletRequest.setAttribute("prpdexchDtoList_"+index,prpdexchDtoList); 
        httpServletRequest.setAttribute("claimDto_"+index, claimDto);
        return prpLclaimDto;
    }

    /**
     * ��д����ҳ�漰��ѯ����request������. ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request�� ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */

    public void claimDtoToView(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
        //��ѯ������Ϣ
    	UIClaimAction uiClaimAction = new UIClaimAction();
    	UICodeAction uiCodeAction = new UICodeAction();
        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto(); 
        //��prpLclaimDto��ֵ
        if (claimDto.getPrpLclaimDto() == null) {
            String msg = "����'" + claimNo + "'�޷���ѯ����";
            throw new UserException(1, 3, "��ѯ", msg);
        }
        prpLclaimDto = claimDto.getPrpLclaimDto();
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLclaimDto.getRiskCode());
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
        String timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageStartHour());
        prpLclaimDto.setDamageStartHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageStartMinute(timeTemp.substring(3, 5));
        timeTemp = StringConvert.toStandardTime(prpLclaimDto.getDamageEndHour());
        prpLclaimDto.setDamageEndHour(timeTemp.substring(0, 2));
        prpLclaimDto.setDamageEndMinute(timeTemp.substring(3, 5));
        
        String riskCode = prpLclaimDto.getRiskCode();
        String registNo = prpLclaimDto.getRegistNo();
        String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			if (registNo != null)
			{		
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "claim",registNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true");//���ö�����嵥�б�
		}
        
        //�������ݺ�ȫ��
        /*=======================Modify YANGBO 2008-01-15
        String strTemp = prpLclaimDto.getEscapeFlag();
        if ((strTemp.length() > 0) && (strTemp.substring(0, 1) != null)) {
            prpLclaimDto.setEscapeFlag(strTemp.substring(0, 1));
        }
        if ((strTemp.length() > 1) && (strTemp.substring(1, 2) != null)) {
            prpLclaimDto.setEscapeFlag2(strTemp.substring(1, 2));
        }
        */
        

        //��������������״̬Ϊ �����޸� (����������)
        if (claimDto.getPrpLclaimStatusDto() != null) {
            if (claimDto.getPrpLclaimStatusDto().getStatus().equals("7"))
                claimDto.getPrpLclaimStatusDto().setStatus("3");
            prpLclaimDto.setStatus(claimDto.getPrpLclaimStatusDto().getStatus());
        } else {
            //���ύ���Ѿ�������ϵ�״̬
            prpLclaimDto.setStatus("4");
        }

        /*
         * �ӱ����л����Ϣ ԭ����Ϊ��Щ������Ϣ���Ѿ����浽��������Ϣ���ˣ���ע����������Ϊ��Ҫת�������ϵ� ������Ϣ����������Ҫȥȡ����������ĳ�����Ϣ��һ�����̡�
         */
        PolicyDto policyDto=null;
        if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
            //��ѯ������Ϣ
        	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
    		//���ݳ���ʱ�仹ԭ������Ϣ
        	policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo()
        	  		,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour());
            if("D".equals(strRiskType)||"Q".equals(strRiskType)||"C".equals(strRiskType)||"Y".equals(strRiskType)){
               //���ձ���Ϣѹ��ҳ����
       		    ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
       		    httpServletRequest.setAttribute("damageKindList", damageKindList);
         		String defaultKindCode = getDefaultKindCodeByPolicyDto(policyDto);
                httpServletRequest.setAttribute("defaultKindCode",defaultKindCode);
         	}
        	if("D".equals(strRiskType)){
                PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
                if (policyDto.getPrpCitemCarDtoList().size() > 0) {
                    //�Գ��͵���Ϣ��֧��
                    PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
                    prpLclaimDto.setClauseType(PrpCitemCarDto.getClauseType());
                    prpLclaimDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
                    prpLclaimDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
                    prpLclaimDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
                    prpLclaimDto.setBrandName(PrpCitemCarDto.getBrandName());
                    prpLclaimDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
                    httpServletRequest.setAttribute("liabStartDate", policyDto.getLiabStartDate());
                }
        	}else{
        		prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(),DateTime.YEAR_TO_DAY));
        		prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(),DateTime.YEAR_TO_DAY));
        	}
        	 
            //��ӱ�����Ϣ 2005-9-26
            //����ҵ������䷽ʽ�����ߵĴ洢�ֶβ�Ψһ�������ڴ˴�Ҫ��һ������
            PrpCmainCargoDto prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
            
            if (prpCmainCargoDto != null) {
                if (prpCmainCargoDto.getBLNo() == null
                    || prpCmainCargoDto.getBLNo() == "") {
                    prpCmainCargoDto.setBLNo(uiCodeAction.translateCodeCode("ConveyanceType",
                                              prpCmainCargoDto.getConveyance(), true));
                }
           }
            httpServletRequest.setAttribute("prpCmainCargoDto", prpCmainCargoDto);
        	httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());
            //ȡ�����������ƣ������ŵ���Ҫ��ʾ����
            String strInsuredNameShow = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
			    	strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName();
			}
			else {
					strInsuredNameShow = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";
			}
			prpLclaimDto.setInsuredNameShow(strInsuredNameShow);
			prpLclaimDto.setSumInsured(policyDto.getPrpCmainDto().getSumInsured());
			
        }
        //������ش��������ת��
        changeCodeToName(prpLclaimDto);
        //���ô�����и�����ѡ�����б���Ϣ������
        
        setSelectionList(httpServletRequest, prpLclaimDto);
        //��ѯ��ͬ�����ŵĳ��մ���
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLclaimDto.getPolicyNo(),prpLclaimDto.getRegistNo());
       
        
        
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
	    //�þɵĻ�ȡΣ�յ�λ��Ϣ����
	    if(time<0){
	    	//add by qinyongli start 2005-8-16
		    //reason:��ȡΣ�յ�λ��Ϣ
			UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
		    PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo(),1,httpServletRequest,claimDto.getPrpLclaimDto().getRiskCode(),0);
		    
		    if(prpLdangerUnitDto!=null&&prpLdangerUnitDto.getCurrency()!=null&&!prpLdangerUnitDto.getCurrency().equals("")){
	            prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); //�ô��ֶα�ʾ�ұ�������Ϣ
		    }
	        if(prpLdangerUnitDto==null){
	        	prpLdangerUnitDto = new PrpLdangerUnitDto();
	        }
		    
		    httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
		    //add by qinyongli end 2005-8-16
	    }else{
	    	//���µĻ�ȡΣ�յ�λ��Ϣ����
	    	//******---------------------��ȡΣ�յ�λ��Ϣ ��Ԫ��Ŀ��  start---------------------------------*/
	        BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
	        List prpLdangerUnitList = new ArrayList();
	        prpLdangerUnitList=blDangerFacade.getPrpLdangerUnit(claimDto.getPrpLclaimDto().getClaimNo());
	        httpServletRequest.setAttribute("prpLdangerUnitList", prpLdangerUnitList);
	        //******---------------------��ȡΣ�յ�λ��Ϣ ��Ԫ��Ŀ��  end-----------------------------------*/
	    	
	    }
        
        
      
        
	    //Modify by chenrenda add begin 20050418
        //Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
        String strPrpLnodeType = "claim";
        httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
        //Modify by chenrenda add end 20050418

        //���ø����ӱ���Ϣ������
        claimDto.setPrpLpersonTraceDtoList(claimDto.getPrpLpersonTraceDtoList());
        setSubInfo(httpServletRequest, claimDto);
        //��ʾ�������ں���������֮��Ĺ���������
        UIRegistAction uiRegistAction = new UIRegistAction();
        RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
        DateTime registDate = registDto.getPrpLregistDto().getReportDate();
        
        //add by zhaolu start at 2006-06-09
        //reason ǿ�Ʊ���������Ϣд��������
        // System.out.println("ǿ�Ʊ���������Ϣд��������----------1327");
	      httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		  //add by zhaolu end at 2006-06-09
        httpServletRequest.setAttribute("registDate", registDate);
        //������������������ϵ��¼
        Collection arrayListRegistExt = new ArrayList();
        PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
        prpLregistExtDto.setRegistNo(claimDto.getPrpLclaimDto().getRegistNo());
        prpLregistExtDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        arrayListRegistExt = claimDto.getPrpLregistExtDtoList();       
        prpLregistExtDto.setRegistExtList(arrayListRegistExt) ;
        httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
        
        //�¹���ģ��   
        ArrayList prpLacciBenPersonDtoList = claimDto.getPrplacciBenPersonDtoList();
        PrpLacciPersonDto  prpLacciPersonDto = new PrpLacciPersonDto();
        prpLacciPersonDto.setPrpLacciBenPersonList(prpLacciBenPersonDtoList);
        
       	//����������
        ArrayList prpLacciPersonDtoList = claimDto.getPrpLacciPersonDtoList();
        prpLacciPersonDto.setPrpLacciPersonList(prpLacciPersonDtoList);
        httpServletRequest.setAttribute("prpLacciPersonDto",prpLacciPersonDto); 
        //����������end-------------------------------------
        
        //�⽡�����ύǰ�����е��������Ӧ���Ѿ��ύ��   2005-08-04
        if ("E".equals(strRiskType)) {
        	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	int intCount = 0;     //û���ύ�����������Ŀ
        	String strFlowID = httpServletRequest.getParameter("swfLogFlowID");
        	String strSql = " FLOWID='" + strFlowID + "' and NODETYPE='check' and NODESTATUS<>'4'";
        	intCount = uiWorkFlowAction.findNodesByConditions(strSql).size();
        	httpServletRequest.setAttribute("com.sinosoft.acciFlag", intCount>0?"N":"Y");   //����һ����־λ��N��ʾ�����ύ��Y��ʾ�����ύ��
        }
        
        httpServletRequest.setAttribute("claimDto", claimDto);
        httpServletRequest.setAttribute("riskType", strRiskType);
        
        //ȱʡ���������ıұ� 2005-09-05
        prpLclaimDto.setEstiCurrency(registDto.getPrpLregistDto().getEstiCurrency());
        
        //��ȡ�һ�����Ϣ 2005-09-05
        Collection prpdexchDtoList = new ArrayList();
        UIExchAction uiExchAction = new UIExchAction(); 
        //���бұ�ת�����õ���������
        uiCodeAction = new UICodeAction();
        String strCurrencyName = uiCodeAction.translateCurrencyCode(prpLclaimDto.getEstiCurrency(), true);
        httpServletRequest.setAttribute("strCurrencyName", strCurrencyName);
        prpdexchDtoList = uiExchAction.getExchOfMaxDate(new DateTime().current().toString().substring(0,10));
        httpServletRequest.setAttribute("prpdexchDtoList",prpdexchDtoList); 
        
        //������������Ϣ���ݵ������
        if(claimDto.getPrpLextDto()==null){
             httpServletRequest.setAttribute("prpLextDto", new PrpLextDto());
        }else{
             httpServletRequest.setAttribute("prpLextDto", claimDto.getPrpLextDto());   
        }
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
        
        //�ڽ�������ʾ�������� 2005-09-09
        httpServletRequest.setAttribute("riskCName", uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(), true));
        
    }

    /**
     * ���ݱ����źͱ����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo)
            throws Exception {
    	logger.info("���ݱ����źͱ����Ų�ѯ������Ϣ����LIKE �������Ż���");
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "'";
        //��ѯ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();

        //�õ����б���������Ϣ
        Collection claimList = new ArrayList();      

        claimList = (Collection) uiClaimAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);

        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }
    
    //add by zhaolu 20060802 start
    //������ѯ��ҳ 
    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto, String pageNo,
			String recordPerPage) throws Exception {
		// ��������ı����ţ��ⰸ������SQL where �Ӿ�
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
		// Reason:�ڲ�ѯ��������������"������"��ѯ����
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
		// Modify by chenrenda update end 20050316
		// ��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("prplregist.InsuredName",
						insuredName, workFlowQueryDto.getInsuredNameSign());

		// add by lixiang start at 2006-02-14
		// reason:����ѯע�����������ݵ�ʱ��û�в�ѯ�����
		// �뷨�Ǵ�status�в�ѯ6��7��״̬ 6-ע���� 7-����

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

		// ȥ������һ��","
		//����״̬�Ͱ������͵Ĳ�ѯ��������Ϊ��ʱ������״̬�밸������֮���á��򡱣������������ġ������������������С��롱
		if(!caseType.equals("") && !strTempStatus.equals("")){
				//ƴ������������
				caseType = caseType.substring(0, caseType.length() - 1);
				conditions = conditions + " AND ((prplclaim.caseType in (" + caseType + ")) ";		
			
				strTempStatus = strTempStatus.substring(0,strTempStatus.length() - 1);
				//ƴ����״̬(�������Ѵ���)����
				int newIndex = 0;
				String statusTemp1 = "";
				while(true){
					if((newIndex = strTempStatus.trim().indexOf(",")) != -1){
						statusTemp1 += strTempStatus.trim().substring(0,newIndex) + "','";
						strTempStatus =strTempStatus.trim().substring(newIndex + 1,strTempStatus.trim().length());					
					}else{
						break;
					}
				}
				strTempStatus = statusTemp1 + strTempStatus;	
				conditions = conditions + " OR (b.status in ('" + strTempStatus + "')) )";
		
			
		}else{
			if (!caseType.equals("")) {
				caseType = caseType.substring(0, caseType.length() - 1);
				conditions = conditions + " AND (prplclaim.caseType in ("
						+ caseType + ")) ";

			}

			if (!strTempStatus.equals("")) {
				strTempStatus = strTempStatus.substring(0,
						strTempStatus.length() - 1);
				//ƴ����״̬(�������Ѵ���)����
				int oldIndex = -2;
				int newIndex = 0;
				while(true){
					if((newIndex = strTempStatus.trim().indexOf(",")) != -1 && newIndex > oldIndex + 2){
						strTempStatus = strTempStatus.trim().substring(0,newIndex) + "','" + strTempStatus.trim().substring(newIndex + 1,strTempStatus.trim().length());
						oldIndex = newIndex;
					}else{
						break;
					}
				}
				conditions = conditions + " AND (b.status in ('" + strTempStatus
						+ "')) ";

			}
			
		}
		// if (status.trim().length() > 0) {
		// conditions = conditions + " AND (b.status in (" + status + ")) ";
		// }

		// add by lixiang end at 2006-02-14

		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		// ƴȨ��
		
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
		// ����sql�־��γɼ�¼
		setPrpLclaimDtoToView(httpServletRequest, conditions, intPageNo,
				intRecordPerPage);
	}
    
    
    
    public PrpLclaimDto setPrpLclaimDtoToView(
			HttpServletRequest httpServletRequest, String conditions,
			int pageNo, int recordPerPage) throws Exception {
		// ��ѯ������Ϣ
      
		UIClaimAction uiClaimAction = new UIClaimAction();
		// �õ����б���������Ϣ
		ArrayList claimList = new ArrayList();
		PageRecord pageRecord = (PageRecord) uiClaimAction
				.findByQueryConditions(conditions, pageNo, recordPerPage);
		claimList = (ArrayList) pageRecord.getResult();
		TurnPageDto turnPageDto = new TurnPageDto();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(claimList);
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
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
     * ���ݱ����źͱ����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */


    public void registTimeOut(HttpServletRequest httpServletRequest) throws Exception {
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
         String conditions = "";
        DateTime dateTime = new DateTime(new Date(), DateTime.YEAR_TO_DAY);
        DateTime.setDateDelimiter("-");
        //conditions = " registno not in (select registno from prplclaim) and ReportDate < '" + dateTime + "'";
        //�ѳ�ʱ�ı���������ʱ��-����ʱ��>��48Сʱ
        //conditions = " ((ReportDate-DamageStartDate)*24+(substr(ReportHour,1,2 )-substr(DamageStartHour,1,2 )))>48";
        conditions = " ((ReportDate-DamageStartDate)*24+(cast(substr(ReportHour,1,2 )as integer)-cast(substr(DamageStartHour,1,2 )as integer)))>48";
            //add by qinyongli 2005-10-24���Ӳ�ѯ����
        String registNo = httpServletRequest.getParameter("RegistNo");
        String registNoSign = httpServletRequest.getParameter("RegistNoSign");
        String policyNo = httpServletRequest.getParameter("PolicyNo");
        String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
        String insuredName = httpServletRequest.getParameter("InsuredName");
        String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
        String riskCode = httpServletRequest.getParameter("RiskCode");
        String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");

        //�����ѯ����
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
        
       
        //       ƴȨ��

        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
        
        //conditions = conditions
        //         + uiPowerInterface.addPower(userDto.getUserCode(), "lpba", "prplregist", BusinessRuleUtil.getOuterCode(
        //                httpServletRequest, "RISKCODE_DAA"));
//      �ӷ�ҳȡ����
	       String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	       }
        //��ѯ������Ϣ
        UIRegistAction uiRegistAction = new UIRegistAction();

        //�õ����б���������Ϣ
//      �õ����б���������Ϣ
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
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(registList);
		// ��ǰҳ��
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// һҳ������
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// ��ѯ�����Ľ��������
		turnPageDto.setTotalCount(pageRecord.getCount());
		// �����ܵ�ҳ��
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// ��������
		turnPageDto.setCondition(conditions);
		
		prpLregistDto.setTurnPageDto(turnPageDto);
		// //System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
    }
    //modify by liuyanmei add 20051108 start
    public void claimTimeOut(HttpServletRequest httpServletRequest) throws Exception {
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
        
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
        
        //�ѳ�ʱ�ı���������ʱ��-����ʱ��>��48Сʱ
       // conditions = " ((prplclaim.inputDate-prplregist.reportDate)*24+(substr(prplclaim.inputDate,1,2 )-substr(prplregist.ReportHour,1,2 )))>168";
        String dbType=SysConfig.getProperty("DBTYPE");  
        if(dbType.equals("DB2")){
        conditions = " ((prplclaim.inputDate-prplregist.reportDate)*24+(cast(substr(char(year(prplclaim.inputDate)),1,2 )as integer)-cast(substr(prplregist.ReportHour,1,2 )as integer)))>168";
        }
        else{
        	 conditions = " ((prplclaim.inputDate-prplregist.reportDate)*24+(substr(prplclaim.inputDate,1,2 )-substr(prplregist.ReportHour,1,2 )))>168";
        }
            //add by qinyongli 2005-10-24���Ӳ�ѯ����
        String claimNo = httpServletRequest.getParameter("ClaimNo");
        String claimNoSign = httpServletRequest.getParameter("ClaimNoSign");
        String policyNo = httpServletRequest.getParameter("PolicyNo");
        String policyNoSign = httpServletRequest.getParameter("PolicyNoSign");
        String insuredName = httpServletRequest.getParameter("InsuredName");
        String insuredNameSign = httpServletRequest.getParameter("InsuredNameSign");
        String riskCode = httpServletRequest.getParameter("RiskCode");
        String riskCodeSign = httpServletRequest.getParameter("RiskCodeSign");
        //�����ѯ����
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
       
        //       ƴȨ��
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
		
        //modify by zhaolu 20060816 start
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
	 if (userDto==null){

	 	}
	    
        conditions = conditions + uiPowerInterface.addPower(userDto,"prplregist","","ComCode");
	
        conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
	   
        //	modify by zhaolu 20060816 end
        //add by zhaolu 20060803 start
        //�ӷ�ҳȡ����
//        String condition = httpServletRequest.getParameter("condition");
//        if(condition!=null && condition.trim().length()>0){ 
//           conditions = condition;
//         }
        //add by zhaolu 20060803 end
        //��ѯ������Ϣ
        //UIRegistAction uiRegistAction = new UIRegistAction();
        UIClaimAction uiClaimAction = new UIClaimAction();
     // System.out.println("--------conditions------"+conditions);
        //�õ����б���������Ϣ
        //modify  by zhaolu 20060803 start
        //Collection claimList = new ArrayList();
         ArrayList claimList = new ArrayList();
         PageRecord pageRecord = uiClaimAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
         claimList = (ArrayList)pageRecord.getResult();
        //claimList = (Collection) uiClaimAction.findByQueryConditions(conditions);
         TurnPageDto turnPageDto = new TurnPageDto();
         //��ѯ������һҳ�Ľṹ�� 
         turnPageDto.setResultList(claimList);
         //��ǰҳ��
         turnPageDto.setPageNo(pageRecord.getPageNo());
         //һҳ������
         turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
         //��ѯ�����Ľ��������
         turnPageDto.setTotalCount(pageRecord.getCount());
         //�����ܵ�ҳ��
         turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
         //��������
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
     * ���������ű����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @param status ״̬
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo,
            String status) throws Exception {
    	logger.info("���������ű����Ų�ѯ������Ϣ ��LIKE �������Ż�");
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);
        status = StringUtils.rightTrim(status);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "' AND flag ='"
				+ status + "'";
        // ��ѯ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();
        Collection claimList = new ArrayList();
        claimList = (Collection) uiClaimAction.findByConditions(conditions);
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);
        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }
    /**
     * ���������ű����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @param status ״̬
     * @param usercode �û�����
     * @throws Exception
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String policyNo,
            String status, String userCode) throws Exception {
    	logger.info("���ݱ����źͱ����Ų�ѯ������Ϣ����LIKE �������Ż���");
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
        claimNo = StringUtils.rightTrim(claimNo);
        policyNo = StringUtils.rightTrim(policyNo);
        status = StringUtils.rightTrim(status);
        userCode = StringUtils.rightTrim(userCode);

        String conditions = "";
        conditions = " claimNo = '" + claimNo + "' AND policyNo = '" + policyNo + "'"
				+ "' AND flag ='" + status + "' AND handlerCode ='" + userCode + "'";
        // ��ѯ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();

        //�õ����б���������Ϣ
        Collection claimList = new ArrayList();
        claimList = (Collection) uiClaimAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimList);
        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * ����PrpClaimDto�еĸ��ӱ��ڵ���Ϣ������lixiang
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpClaimDto ������������
     * @throws Exception
     */

    private void setSubInfo(HttpServletRequest httpServletRequest, ClaimDto claimDto) throws Exception {
        String strCurrency = "";
        String strCurrencyName = "";
        UICodeAction uiCodeAction = new UICodeAction();

        //(1).[�永����]�����߳��������б�׼������
        Collection arrayList = new ArrayList();
        PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
        arrayList = claimDto.getPrpLthirdPartyDtoList();
        prpLthirdPartyDto.setThirdPartyList(arrayList);

        httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

        //(2).[��ʻԱ]����ʻԱ���ж����б�׼������
        Collection arrayListDriver = new ArrayList();
        PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
        arrayListDriver = claimDto.getPrpLdriverDtoList();
        prpLdriverDto.setDriverList(arrayListDriver);
        httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
        //(3).[�鿱��Ϣ]�������ļ������б�׼������
        PrpLltextDto prpLltextDto = new PrpLltextDto();
        String tempContext = "";
        String strRiskType = uiCodeAction.translateRiskCodetoRiskType(claimDto.getPrpLclaimDto().getRiskCode());
		
		
        if (claimDto.getPrpLltextDtoList() != null) {
            Iterator iterator = claimDto.getPrpLltextDtoList().iterator();
            while (iterator.hasNext()) {
                PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
                //add by qinyongli start 2005-9-6
                //������յĳ���ժҪ���е�������
                //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("07")){
                if ("E".equals(strRiskType)) {
                	//}//Ŀǰ��ע�͵����������ժҪ��ʧ������ huangyunzhong 20051026
                	if(prpLltextDtoTemp.getTextType().equals("1") ||prpLltextDtoTemp.getTextType().equals("3")|| prpLltextDtoTemp.getTextType().equals("09")){
                		tempContext = tempContext + prpLltextDtoTemp.getContext();
                	}
                //add end by qinyongli
                }else{
                	if(prpLltextDtoTemp.getTextType().equals("1") ||prpLltextDtoTemp.getTextType().equals("3") || prpLltextDtoTemp.getTextType().equals("09")){
                		tempContext = tempContext + prpLltextDtoTemp.getContext();
                	}
                }
                
            }
        }
        prpLltextDto.setContext(tempContext);
        prpLltextDto.setTextType("09");
        httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
        //����ԭ����ϸ��Ϣ
        if(claimDto.getPrpLltextDtoList3() != null){
        	httpServletRequest.setAttribute("prpLltextDto3", claimDto.getPrpLltextDtoList3());
        }
        //(4).[������]���������ļ������б�׼������
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

        //(5).���ձ�������ļ������б�׼������
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
        String conditions = "";
        Collection collection = null;
        
        claimLossList = claimDto.getPrpLclaimLossDtoList();
        
        if (claimLossList != null) {
        	
        	//System.out.println("============  [ �ǿ� ]  ================");
            for (int i = 0; i < claimLossList.size(); i++) {
                PrpLclaimLossDto prpLclaimLossDto1 = (PrpLclaimLossDto) claimLossList.get(i);
                if (prpLclaimLossDto1.getInputDate().equals("")) {
                	prpLclaimLossDto1.setInputDate( new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                }
                
                //�ձ���ϢӦ�ô�prpcitemkind���д��� 2005-09-05
               //conditions = " PolicyNo ='"+ claimDto.getPrpLclaimDto().getPolicyNo()
				//            +"' and ItemKindNo=" + prpLclaimLossDto1.getItemKindNo(); 
              // collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);
//               if (collection != null && collection.size() > 0) {
//                   for (Iterator iter = collection.iterator(); iter.hasNext();) {
//                       PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
//                       prpLclaimLossDto1.setKindName(prpCitemKindDto.getKindName());
//                       System.out.println("��������==========" + prpLclaimLossDto1.getKindName() );
//                       break;
//                   }
//               } else {
//                   prpLclaimLossDto1.setKindName(uiCodeAction.translateKindCode(prpLclaimLossDto1.getRiskCode(),
//                		   prpLclaimLossDto1.getKindCode(), true));
//               }    
               prpLclaimLossDto1.setKindName(uiCodeAction.translateKindCode(prpLclaimLossDto1.getRiskCode(),
            		   prpLclaimLossDto1.getKindCode(), true));
                
                //add by qinyongli ������ϸ���Ʋ�ѯ ,���������
                //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("27")){
                  
                //modify by   ��Ŀ��  ������  ����27�޸�Ϊ07
               //modify by �϶���  �����ĸ����඼Ҫ�����������
               //if(claimDto.getPrpLclaimDto().getRiskCode().substring(0,2).equals("07")){
            	   conditions = " PolicyNo ='"+ claimDto.getPrpLclaimDto().getPolicyNo() + "' AND KindCode ='"+ 
            	   prpLclaimLossDto1.getKindCode()+"' ";
            	   if(prpLclaimLossDto1.getItemCode()!=null&&!prpLclaimLossDto1.getItemCode().equals("")){
            		   conditions += " and  ItemCode='"+prpLclaimLossDto1.getItemCode()+"' ";
            	   }
            	   collection = uiCodeAction.findByConditions(UICodeAction.POLICYITEMCODE,conditions,0,0);
            	   if(collection!=null&&collection.size()>0){
            		   Iterator coll = collection.iterator();
            		   while(coll.hasNext()){
            			   PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto)coll.next();
            			   prpLclaimLossDto1.setItemKindName(prpCitemKindDto.getItemDetailName());
            			   prpLclaimLossDto1.setItemAmount(prpCitemKindDto.getAmount());
            		   }
            	   } 
               //}
            	prpLclaimLossDto.setLossFeeType(prpLclaimLossDto1.getLossFeeType());
                prpLclaimLossDto1.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLclaimLossDto1.getCurrency(), true));
            }
        }
        prpLclaimLossDto.setClaimLossList(claimLossList);
        httpServletRequest.setAttribute("prpLclaimLossDto", prpLclaimLossDto);

        //(5).[��֤��Ϣ]�����ⵥ֤�ļ������б�׼������
        Collection docList = new ArrayList();
        PrpLdocDto prpLdocDto = new PrpLdocDto();
        docList = claimDto.getPrpLdocDtoList();
        prpLdocDto.setDocList(docList);
        httpServletRequest.setAttribute("prpLdocDto", prpLdocDto);

        //�ر�Լ����Ϣ�����б�׼������
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
        //Reason:��ʧ��λģ��ӽ��永������Ϣ�к���Ӧģ��������
        Collection arrayListThirdCarLoss = new ArrayList();
        PrpLthirdCarLossDto prpLthirdCarLossDto = new PrpLthirdCarLossDto();
        arrayListThirdCarLoss = claimDto.getPrpLthirdCarLossDtoList();
        prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss);
        httpServletRequest.setAttribute("prpLthirdCarLossDto", prpLthirdCarLossDto);

        //Modify by chenrenda add end 20050408

        //Modify by chenrenda add begin 20050412
        //Reason:�ڱ���ҳ���м���������ʧģ��
        Collection arrayListThirdProp = new ArrayList();
        PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
        arrayListThirdProp = claimDto.getPrpLthirdPropDtoList();
        prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
        httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
        //Modify by chenrenda add end 20050412
        
        //��ѯ������Ϣ ��ʾ�ر�Լ���б�
        String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
        ArrayList itemKindList = new ArrayList();
        Collection itemKindListNew = new ArrayList();
        //���ݱ����Ų�ѯ�ر�Լ����Ϣ
        if(!policyNo.equals("")&&policyNo!=null)
        {
 			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
 			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo
 					,claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					,claimDto.getPrpLclaimDto().getDamageStartHour()); 

 	        itemKindList = policyDto.getPrpCitemKindDtoList();
        }
        
        // Reason:���˸�����Ϣģ�����漰�������б���ѡ��ʽ��ʾ
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
        
        itemKindListNew.addAll(itemKindListNew2 );
        //ȥ���ظ��������ձ���ӽ�itemKindListNew
        if(!"0506".equals(claimDto.getPrpLclaimDto().getRiskCode())
        		&&!"0576".equals(claimDto.getPrpLclaimDto().getRiskCode())
        		&&!"0586".equals(claimDto.getPrpLclaimDto().getRiskCode())){
            for(Iterator iterator = itemKindListNew1.iterator();iterator.hasNext();){
         	   PrpCitemKindDto p1 = (PrpCitemKindDto)iterator.next(); 
         	   boolean isExist = false;
         	   for(Iterator iterator1 = itemKindListNew2.iterator();iterator1.hasNext();){
         		   PrpCitemKindDto p2 = (PrpCitemKindDto)iterator1.next();  
         		   if(p2.getKindCode().equals(p1.getKindCode())){
         			   isExist = true;
         		   }
         	   }
         	   if(!isExist){
         		   itemKindListNew.add(p1);
         	   }
            }
        	
        }
       
        httpServletRequest.setAttribute("referKindList",itemKindListNew);
        
        //����Ա�������ٶ��ж����б�׼������
        Collection arrayListPersonTrace = new ArrayList();
        PrpLpersonTraceDto prpLpersonTraceDto  = new PrpLpersonTraceDto();
        arrayListPersonTrace = claimDto.getPrpLpersonTraceDtoList();
        prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace) ;
        prpLpersonTraceDto.setNodeType("check");
        ArrayList presonTraceDeleteList = new ArrayList();
        if(claimDto.getPrpLpersonTraceDtoList() != null){
         Iterator personTraceDtoList = arrayListPersonTrace.iterator();
         while(personTraceDtoList.hasNext()){
           PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto)personTraceDtoList.next();
           String strReferKind = prplpersonTraceDto.getReferKind();
           //0506��0507��������ʱ�����ڹ���prplpersonTrace�е����ݣ�0507ֻ�ܴ����ձ�Ϊ��B����BZ����������Ϣ,����ķ���presonTraceDeleteList�У�����������ɾ����
           if((claimDto.getPrpLclaimDto().getRiskCode().equals("0507")||claimDto.getPrpLclaimDto().getRiskCode().equals("0577")
        		   ||claimDto.getPrpLclaimDto().getRiskCode().equals("0587")) && !"B".equals(strReferKind) && !"BZ".equals(strReferKind)){
        	   presonTraceDeleteList.add(prplpersonTraceDto);
           }else{
               prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);        	   
           }
         }
       }
        if(presonTraceDeleteList.size() > 0 && (claimDto.getPrpLclaimDto().getRiskCode().equals("0507")
        		||claimDto.getPrpLclaimDto().getRiskCode().equals("0577")
        		||claimDto.getPrpLclaimDto().getRiskCode().equals("0587"))){
        	arrayListPersonTrace.removeAll(presonTraceDeleteList);
        }
        httpServletRequest.setAttribute("prpLpersonTraceDto", prpLpersonTraceDto);

    }

    /**
     * ����PrpClaimDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpClaimDto ������������
     * @param ClaimDto ��ѯ����������
     * @throws Exception
     */
    private void changeCodeToName(PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();
        //(1)�������Ƶ�ת��
        String clauseType = prpLclaimDto.getClauseType();
        String clauseName = uiCodeAction.translateCodeCode("ClauseType", clauseType, true);
        prpLclaimDto.setClauseName(clauseName);
        //(2)������ɫת��
        String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
        String licenseColor = uiCodeAction.translateCodeCode("LicenseColor", licenseColorCodeCode, true);
        prpLclaimDto.setLicenseColor(licenseColor);
        //(3)��������ת��
        String carKindCode = prpLclaimDto.getCarKindCode();
        String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode, true);
        prpLclaimDto.setCarKind(carKind);
        
        //(4)��ҵ������ṹ����ת��
        String comCode = prpLclaimDto.getComCode();
        String comName = uiCodeAction.translateComCode(comCode, true);
        prpLclaimDto.setComName(comName);
        //(5)�Թ���ҵ��Ա����ת��
        String handler1Code = prpLclaimDto.getHandler1Code();
        String handler1Name = uiCodeAction.translateUserCode(handler1Code, true);
        prpLclaimDto.setHandler1Name(handler1Name);
        //(6)�Դ����˽���ת��
        String agentCode = prpLclaimDto.getAgentCode();
        String agentName = uiCodeAction.translateUserCode(agentCode, true);
        prpLclaimDto.setAgentName(agentName);
        //(7)�Ծ����˽���ת��
        String handlerCode = prpLclaimDto.getHandlerCode();
        String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
        prpLclaimDto.setHandlerName(handlerName);
        
        //(8)�԰������ʽ���ת�� 2005-08-01
        String strClaimType = prpLclaimDto.getClaimType();
        String strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strClaimType, true);
        prpLclaimDto.setClaimTypeName(strClaimTypeName);
        
        //(9)��ҵ�����ͽ���ת��
        String strBusinessNature = prpLclaimDto.getBusinessNature();
        String strBusinessNatureName = uiCodeAction.translateCodeCode("BusinessNature",strBusinessNature, true);
        prpLclaimDto.setBusinessNatureName(strBusinessNatureName);
        //10)������ת��
 //System.out.println("aaaaaaaaaaaa"+prpLclaimDto.getLanguage());       
        if(prpLclaimDto.getLanguage().equals("C"))
        {
            prpLclaimDto.setLanguageName("����");
        }
        if(prpLclaimDto.getLanguage().equals("E"))
        {
            prpLclaimDto.setLanguageName("Ӣ��");
        }
        //(11)��makeCom����ת�� add by liuyanmei 20051115 
        //reason :itest bug 647 ���������ѯ������Ǽǲ�����ʾ��ֻ�д��룬û�����ơ�
        String makeCom = prpLclaimDto.getMakeCom();
        String makeComName = uiCodeAction.translateComCode(makeCom, true);
        prpLclaimDto.setMakeComName(makeComName);
        
    }

    /**
     * ��ȡѡ�����б���е���������
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param prpClaimDto ������������
     * @throws Exception
     */
    private void setSelectionList(HttpServletRequest httpServletRequest, PrpLclaimDto prpLclaimDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();

        //(1)�õ����������б�
        Collection reportTypes = uiCodeAction.getCodeType("ReportType", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("reportTypes", reportTypes);
        //(2)�õ����������б��б�
        Collection claimTypes = uiCodeAction.getCodeType("CaseCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("claimTypes", claimTypes);
        //(3)�õ����յ�ַ�����б�
        Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
        //(4)�õ����������б�
        Collection carKindCodes = uiCodeAction.getCodeType("CarKind", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("carKindCodes", carKindCodes);
        //(5)�õ����Ƶ�ɫ�б�
        Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
        //(6)�õ��⳥�����б�
        Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
        //(7)�õ��ⰸ����б�
        Collection escapeFlags = uiCodeAction.getCodeType("CaseCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("escapeFlags", escapeFlags);
        //(8)�õ��õ��Ա�
        Collection driverSex = uiCodeAction.getCodeType("SexCode", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("driverSexs", driverSex);
        //(9)�õ�ְҵ����
        Collection driverOccupation = uiCodeAction.getCodeType("Occupation", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("driverOccupations", driverOccupation);
        //(10)�õ��Ļ��̶�
        Collection education = uiCodeAction.getCodeType("Education", BusinessRuleUtil.getOuterCode(httpServletRequest,
                "RISKCODE_DAA"));
        httpServletRequest.setAttribute("educations", education);
        //(11)�õ��������͵��б� --- Ŀǰ�޷��õ�
        //(12)�õ�֤������
        Collection IdentifyTYpeOccupation = uiCodeAction.getCodeType("IdentifyType", BusinessRuleUtil.getOuterCode(
                httpServletRequest, "RISKCODE_DAA"));
        httpServletRequest.setAttribute("identifyTypes", IdentifyTYpeOccupation);
        Collection claimFlagList = new ArrayList();
        claimFlagList.add(new LabelValueBean("����", "L"));
        claimFlagList.add(new LabelValueBean("������", "D"));
        httpServletRequest.setAttribute("claimFlagList", claimFlagList);
    }

    /**
     * ��ѯ��������Ϣ���ݵĹ��̣��������Ƿ����ע�����ж�
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param Claimno �ⰸ����
     * @throws Exception
     */
    public void getClaimCancelInfo(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
        //��ѯ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();

        ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);

        //��prpLclaimDto��ֵ
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto = claimDto.getPrpLclaimDto();
        //���������ݵ���Ϣ����request��
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * ��������ע��ʱ����ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
     * 
     * @param httpServletRequest
     * @return claimDto �������ݴ������ݽṹ
     * @throws Exception
     */
    public ClaimDto cancelViewToDto(HttpServletRequest httpServletRequest) throws Exception {
    	  //�̳ж�claim,claimsText��ĸ�ֵ
        ClaimDto claimDto = new ClaimDto();
        HttpSession session = httpServletRequest.getSession();
        UserDto   user     = (UserDto)session.getAttribute("user");
        String claimNo="";
        String caseType="";

        claimNo = (String)httpServletRequest.getParameter("prpLclaimClaimNo");
        String registNo= httpServletRequest.getParameter("prpLclaimRegistNo");
        caseType=((String)httpServletRequest.getParameter("caseType"));
        String cancelReaseon =httpServletRequest.getParameter("prpLclaimContext");
        /*---------------------��������prpLclaim------------------------------------*/
        PrpLclaimDto prpLclaimDto =null;
        if ((claimNo==null)||claimNo.equals(""))
        {
         String msg = " �˰���û������������֪ͨ������Ա���б���ע��������";
         if ("1".equals(caseType)){
         	 msg = " �˰���û����������Ҫ֪ͨ������Ա�Ƚ��������������룡";
            
         }
         throw new UserException(1,3,"ע��/����",msg);
        
        //����������
        /*	
          prpLclaimDto = registDtoToClaimDto(registNo,user);
          String riskCode = prpLclaimDto.getRiskCode() ;
          String comCode = prpLclaimDto.getComCode() ;
          int year =DateTime.current() .getYear() ;
       //  msg = "û�н��յ��Ϸ����������룡";
       // throw new UserException(1,3,"����",msg);
       //ȡ�Ź��̻���Ҫ��һ������
       UIBillAction uiBillAction = new UIBillAction();
       String tableName = "prplclaim";
       claimNo = uiBillAction.getNo(tableName,riskCode,comCode,year) ;
       prpLclaimDto.setClaimNo(claimNo);
       
      prpLclaimDto.setFlag("1"); //��Ҫ�����µ��������ݡ�
      */
      //��Ҫ�ܶ�������ݵġ�������
      
      
        }
        
        claimDtoToView(httpServletRequest, claimNo);
        prpLclaimDto = (PrpLclaimDto)httpServletRequest.getAttribute("prpLclaimDto");
       

        if (prpLclaimDto==null)
        {
          String msg = "û�в�ѯ�����������";
          throw new UserException(1,3,"����",msg);
        }
        prpLclaimDto.setFlag("0"); //ֻupdate�Ϳ����ˡ���
        
        //���õ�һ�ν���ʱ��Ĭ����Ϣ
        //prpLclaimDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDealerCode(user.getUserCode() );
        prpLclaimDto.setDealerName(user.getUserName() );
        prpLclaimDto.setCancelReason("");
        //prpLclaimDto.setCaseType(caseType);
        //�ù�������
        claimDto.setPrpLclaimDto(prpLclaimDto);

       /*---------------------����ע���ı���prpLltext------------------------------------*/
       ArrayList prpLltextDtoList = new ArrayList();
       PrpLltextDto prpLltextDto = null;
       String TextTemp = httpServletRequest.getParameter("prpLclaimContext");
       String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
       
       //�õ����Ӵ�,���潫���зֵ�����
       for (int k = 0; k < rules.length; k++) {
           prpLltextDto = new PrpLltextDto();
           prpLltextDto.setClaimNo(claimNo);
           prpLltextDto.setContext(rules[k]);
           prpLltextDto.setLineNo(k + 1);
           prpLltextDto.setTextType("10");
           prpLltextDtoList.add(prpLltextDto); 
       }

        //װ��ClaimDto
       claimDto.setPrpLltextDtoList(prpLltextDtoList);

       /*---------------------��������״̬����prpLclaimStatusĬ��Ϊ���------------------------------------*/
       PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
       prpLclaimStatusDto.setStatus("4");
       prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo() );
       prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
       prpLclaimStatusDto.setNodeType("claim");

       //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ��claimstatus��

      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
      prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate() );
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode() );
      claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return claimDto;
    }
    /**
     * չ�־��������ҳ����Ϣ.���ǲ�ѯ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */

    public void cancelDtoToCancelView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
        String claimNo = httpServletRequest.getParameter("ClaimNo"); //�ⰸ��
        String registNo = httpServletRequest.getParameter("RegistNo"); //�ⰸ��
        UICodeAction uiCodeAction = new UICodeAction();
        String strSql = ""; //��ѯ����
        String msg = ""; //�׳�����ʹ�õ���Ϣ������Ϣ

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //����Dto����

        PrpLclaimDto prpLclaimDto = null; //����Dto����
        UIClaimAction uiClaimAction = new UIClaimAction();
        UIRegistAction uiRegistAction = new UIRegistAction();
        ClaimDto claimDto = null;

        if ((claimNo == null || claimNo.equals(""))) {
            //�����µ���������
            prpLclaimDto = registDtoToClaimDto(registNo, user);

        } else {

            //��������Ϣȡ��
            strSql = " claimno='" + claimNo + "'";
            claimList = uiClaimAction.findByConditions(strSql);
            claimDto = uiClaimAction.findByPrimaryKey(claimNo);
            Iterator it = claimList.iterator();
            if (it.hasNext())
                prpLclaimDto = (PrpLclaimDto) it.next();
        }

        if (prpLclaimDto == null) {
            msg = "û�в�ѯ�����������";
            throw new UserException(1, 3, "����", msg);
        }
        
     UICompensateAction	uiCompensateAction = new UICompensateAction();
	ArrayList collection=(ArrayList)uiCompensateAction.findByConditions(" claimno='"+claimNo+"'");
//System.out.println(collection.size());	
       for (int i = 0; i < collection.size(); i++) {
	 PrpLcompensateDto prpLcompensateDto  = (PrpLcompensateDto)collection.get(i);
	 if (prpLcompensateDto.getUnderWriteFlag().equals("1")){
           msg = "���ⰸ���к���ͨ������������,������ע�����⣡";
       	    throw new UserException(1,3,"ע��/����",msg);
		}
     	}

        strSql = "registNo='" + prpLclaimDto.getRegistNo() + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it = registList.iterator();
        if (it.hasNext()) {
            prpLregistDto = (PrpLregistDto) it.next();
        }
        
        //ע��/����/���������ļ������б�׼������  2005-08-09
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

        //����Ϣ��request���档����
        //ת�������˵�����
        prpLclaimDto.setDealerCode(user.getUserCode());
        String dealerCode = prpLclaimDto.getDealerCode();
        String dealerName = uiCodeAction.translateUserCode(dealerCode, true);
        prpLclaimDto.setDealerName(dealerName);
        //���ò���״̬ΪADD,����Ǽǣ�����Ҫ��
        String typeFlag=httpServletRequest.getParameter("typeFlag"); //typeFlag
        String flowInTime=httpServletRequest.getParameter("flowInTime"); //��������
        
        if (typeFlag!=null){
        	prpLclaimDto.setCaseType(typeFlag );
        }
        if (flowInTime!=null){
        	prpLclaimDto.setCancelDate(new DateTime(flowInTime,DateTime.YEAR_TO_DAY) );
        }
  
        //���typeflag,flowinTime�����ݣ������� caseType��canceldate
        prpLclaimDto.setEditType("EDIT");
        PrpLRegistRPolicyDto  prpLregistRPolicyDto = new BLPrpLRegistRPolicyFacade().findByPrimaryKey(prpLclaimDto.getRegistNo(), prpLclaimDto.getPolicyNo());
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
        httpServletRequest.setAttribute("prpLregistRPolicyDto", prpLregistRPolicyDto);
    }

    /**
     * ���ݱ����źͱ����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */

    public void waitToDo(HttpServletRequest httpServletRequest) throws Exception {
        //��������ı����ţ��ⰸ������SQL where �Ӿ�

        String conditions = "";
        //conditions = " nodetype='check' and status='4'";
        conditions = " nodetype='check' and status='4' and businessno not in (select registno from prplcheck)";
        //��ѯ������Ϣ
        UIClaimStatusAction uiClaimStautsAction = new UIClaimStatusAction();

        //�õ����б���������Ϣ
        Collection claimStatusList = new ArrayList();
        //    prpLclaimDto.setClaimList(claimList);
        claimStatusList = (Collection) uiClaimStautsAction.findByConditions(conditions);

        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        prpLclaimDto.setClaimList(claimStatusList);

        prpLclaimDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
    }

    /**
     * ���ݱ�����,������,����״̬�����ƺ��룬����ʱ���ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
     */

    public void setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, WorkFlowQueryDto workFlowQueryDto) throws Exception {
        //��������ı����ţ��ⰸ������SQL where �Ӿ�
        String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
        String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
        String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
        String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
        String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
        String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
        //Modify by chenrenda update begin 20050316
        //Reason:�ڲ�ѯ��������������"������"��ѯ����
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
        //Modify by chenrenda update end 20050316
        //��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("prplregist.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
        
        //add by lixiang start at 2006-02-14
        //reason:����ѯע�����������ݵ�ʱ��û�в�ѯ�����
        //�뷨�Ǵ�status�в�ѯ6��7��״̬ 6-ע���� 7-����
 

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
          
            
            //ȥ������һ��","
            if (!caseType.equals( "")){
            	caseType = caseType.substring(0,caseType.length()-1) ;
         	   conditions = conditions + " AND (prplclaim.caseType in (" +caseType+ ")) ";
               
            }
            
            if (!strTempStatus.equals("")){
            	strTempStatus = strTempStatus.substring(0,strTempStatus.length()-1) ;
            	   conditions = conditions + " AND (b.status in ('" +strTempStatus+ "')) ";
                   
            }
       //if (status.trim().length() > 0) {
       //     conditions = conditions + " AND (b.status in (" + status + ")) ";
       // }
            
        //	add by lixiang end at 2006-02-14    
        
        if (operateDate != null && !operateDate.trim().equals("")) {
            conditions = conditions + StringConvert.convertDate("b.operateDate", operateDate, workFlowQueryDto.getOperateDateSign());
        }
        //       ƴȨ��
        //modify by zhaolu 20060816 start
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto,"a","","ComCode");  
         conditions = conditions
               + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
     
       //modify by zhaolu 20060816 end
        //����sql�־��γɼ�¼
        setPrpLclaimDtoToView(httpServletRequest, conditions);
    }

    /**
     * ����������ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param ��������
     * @throws Exception Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
     */
    public PrpLclaimDto setPrpLclaimDtoToView(HttpServletRequest httpServletRequest, String conditions)
            throws Exception {
        //��ѯ������Ϣ
        UIClaimAction uiClaimAction = new UIClaimAction();
        //�õ����б���������Ϣ
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
     * �����ڵ�һ�α���¼��������ʱ�򣬽�����Ĭ�ϵĹ��������DAA���������ֵı������ݱ�ͬ������ֵҲ��ͬ
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

//���գ�Ӧ����������жϣ���Ӧ���ǰ��վ������ֽ����жϣ�������ҪҪ�޸ġ�
//modify by lixiang start at 2006-09-13
if ("D".equals(riskType)&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAZ"))
		&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAY"))
		&&!prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAU"))) {  //modify by kangzhen
//if (prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAA")) ||
//prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAB")) ||
//	prpLclaimDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest, "RISKCODE_DAE"))) {
//	modify by lixiang end at 2006-09-13
	
	//�������б�
    ArrayList claimLossList = new ArrayList();
    //�ӱ���������
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
   
    //����Ѿ��鿱�ˣ��Ӳ鿱��������
    UICheckAction uiCheckAction = new UICheckAction();
    CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
    if (checkDto.getPrpLcheckDto() != null) {
        if (checkDto.getPrpLcheckLossDtoList() != null && checkDto.getPrpLcheckLossDtoList().size() > 0) {
            claimLossList = new ArrayList();
            hashMapTemp = new HashMap();
            PrpLcheckLossDto prpLcheckLossDto = null;
            for (int i = 0; i < checkDto.getPrpLcheckLossDtoList().size(); i++) {
                 prpLcheckLossDto = (PrpLcheckLossDto) checkDto.getPrpLcheckLossDtoList().get(i);
                //BZ�����뵽��������
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

    //��������Ϊ������48Сʱ�������������Ĺ�����ȡֵ��������������δ�鿱�İ�������������Ҫ������Ա���ݱ���������룻�Ѳ鿱δ���𰸼�ȡ�鿱������Ѷ��𰸼�ȡ������Ѻ���ͨ��ȡ����������󣬲鿱/����/����/���/
    UICertainLossAction uiCertainLossAction = new UICertainLossAction();
    CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo);

    //����Ѿ������ˣ��Ӷ����������
    if (certainLossDto.getPrpLverifyLossDtoList() != null
            && certainLossDto.getPrpLverifyLossDtoList().size() > 0) {
        hashMapTemp = new HashMap();
        //����
        if (certainLossDto.getPrpLrepairFeeDtoList() != null
                && certainLossDto.getPrpLrepairFeeDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLrepairFeeDtoList().size(); i++) {
                PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto) certainLossDto.getPrpLrepairFeeDtoList()
                        .get(i);
                //BZ�����뵽��������
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
        //����
        if (certainLossDto.getPrpLcomponentDtoList() != null
                && certainLossDto.getPrpLcomponentDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLcomponentDtoList().size(); i++) {
                PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto) certainLossDto.getPrpLcomponentDtoList()
                        .get(i);
                //BZ�����뵽��������
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
        //��Ա
        if (certainLossDto.getPrpLpersonDtoList() != null && certainLossDto.getPrpLpersonDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLpersonDtoList().size(); i++) {
                PrpLpersonDto prpLpersonDto = (PrpLpersonDto) certainLossDto.getPrpLpersonDtoList().get(i);
//              BZ�����뵽��������
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
        //�Ʋ�
        if (certainLossDto.getPrpLpropDtoList() != null && certainLossDto.getPrpLpropDtoList().size() > 0) {
            for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
                PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
//              BZ�����뵽��������
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

    //��hashmap�����ֵȡ����
    Collection collection = hashMapTemp.values();
    if (collection.size() > 0) {
        claimLossList = new ArrayList();
    }
    Iterator iterator = collection.iterator();
    
    EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
    PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLclaimDto.getPolicyNo(),prpLclaimDto.getDamageStartDate().toString());
    PrpCitemKindDto prpCitemKindDto=null;
    
    while (iterator.hasNext()) {
        PrpLclaimLossDto prpLclaimLossDtoTemp = (PrpLclaimLossDto) iterator.next();
        
        //���������ŴӺ��ı���ȡ
        for(int j=0;j<policyDto.getPrpCitemKindDtoList().size();j++){
      	  prpCitemKindDto = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(j);
      	  if(prpCitemKindDto.getKindCode().equals(prpLclaimLossDtoTemp.getKindCode())){
      		  prpLclaimLossDtoTemp.setItemKindNo(prpCitemKindDto.getItemKindNo());
      		  break;
           }
         }
        //���������ŴӺ��ı���ȡ
        
        claimLossList.add(prpLclaimLossDtoTemp);
        //prpLclaimLossDto.setSumClaim(prpLclaimLossDto.getSumClaim()+prpLclaimLossDtoTemp.getSumClaim());
    }
    /*
     * CertainLossDto certainLossDto = new CertainLossDto(); UICertainLossAction uiCertainLossAction = new
     * UICertainLossAction(); HashMap hashMap = new HashMap(); hashMap.put(122,"sdfsdf");
     */

    
    

    
    prpLclaimLossDto.setClaimLossList(claimLossList);
   // System.out.println("^^^^^^^^^^^^^^^^^KindCode^^^^^^^^^^^^^^^^^^^"+prpLclaimLossDto.getKindCode());
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
     * ��д����ҳ�漰��ѯ����request������.
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */

    public void cancelDtoToView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
    	//add by zhaolu 20060816 start
        //reasonȨ���ж�
    	UIPowerAction.checkPower(UserToPrpDuser.convert(user),Constants.TASK_CLAIM_CLAIM_QUERY);
       //add by zhaolu 20060816 end
        String claimNo = httpServletRequest.getParameter("prpLclaimCancelClaimNo"); //�ⰸ��
        String registNo = httpServletRequest.getParameter("RegistNo"); //������
        String nodeType       = httpServletRequest.getParameter("nodeType");
        String strSql = ""; //��ѯ����
        String msg = ""; //�׳�����ʹ�õ���Ϣ������Ϣ

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //����Dto����

        PrpLclaimDto prpLclaimDto = null; //����Dto����

        ClaimDto claimDto = null;
        UIClaimAction uiClaimAction = new UIClaimAction();
        UIRegistAction uiRegistAction = new UIRegistAction();
        
        //����ǿ����ԭ��ֻҪ��������1��������ģ�ע�������֣��򲻽����������̵Ĺرգ���Ҫѡ���������ĸ�ע���ģ����룬һ��ֻ������һ���ɡ�
        //����ֻ������registNo�������ж��ˡ�����
        if(!"compe".equals(nodeType)){
        if (registNo == null ||registNo.equals("")) {
        	msg = "���Ϸ��ı������룡";
            throw new UserException(1, 3, "����", msg);
        }
        //1.���ȼ��registNo�ǲ��ǺϷ���������Ϸ���ô�˳�
        if (!uiRegistAction.isExist(registNo)) {
              msg = "���Ϸ��ı������룡";
              throw new UserException(1, 3, "����", msg);
         }
        }
         
        //2.��������Ϣȡ��
            if("compe".equals(nodeType)){
                strSql = "claimNo='" + claimNo + "' and endcasedate is null  ";
            }else{
                strSql = "registNo='" + registNo + "' and endcasedate is null  ";
            }
            claimList = uiClaimAction.findByConditions(strSql);
            
            if (claimList==null||claimList.size() <1){
                //���û������������ʾ�����������������Ժ�Ҫ�Զ�д��Ϣ����������ȥ'
                //������������
                msg = "����Ŀǰ��û����������������������ע���;��⣡";
                throw new UserException(1,3,"����",msg);
            }
           
            Iterator it = claimList.iterator();
            if (it.hasNext()){
            	   prpLclaimDto = (PrpLclaimDto) it.next();
                   prpLclaimDto.setClaimList(claimList);
                   if("compe".equals(nodeType)){
                	   registNo = prpLclaimDto.getRegistNo();
                   }
            }
       
        if (prpLclaimDto == null) {
            msg = "û�в�ѯ�����������";
            throw new UserException(1, 3, "����", msg);
        }
        /*
        if (!prpLclaimDto.getEndCaseDate().isEmpty()) {
            msg = "�����Ѿ��᰸";
            throw new UserException(1, 3, "����", msg);
        }

        //��ע��
        if (prpLclaimDto.getCaseType().equals("0")) {
            msg = "�����Ѿ�ע��";
            throw new UserException(1, 3, "����", msg);
        }

        //�Ѿ���
        if (prpLclaimDto.getCaseType().equals("1")) {
            msg = "�����Ѿ�����";
            throw new UserException(1, 3, "����", msg);
        }
      */
	      //����ע��/����ڵ��Ƿ��Ѿ����ɹ�
        String BZFlag = "N";//��ҵ���������Ƿ��Ѿ�ע��/�����־
        String DAAFlag = "N";//����ҵ�����������������Ƿ��Ѿ�ע�������־
        Iterator iterator = claimList.iterator();
        while(iterator.hasNext()){
        	PrpLclaimDto prpLclaimDto1 = new PrpLclaimDto();
        	prpLclaimDto1 = (PrpLclaimDto) iterator.next();
        	String condition = "businessNo = '"+prpLclaimDto1.getClaimNo()+"' and nodetype = 'cance'";
        	UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        	ArrayList SwfLogDtoList = new ArrayList();
        	SwfLogDtoList = (ArrayList)uiWorkFlowAction.findNodesByConditions(condition);
        	//��ҵ���Ƿ��Ѿ�ע��/�����־
        	if(prpLclaimDto1.getRiskCode().equals("0506")|| 
        			prpLclaimDto1.getRiskCode().equals("0586")||
        			prpLclaimDto1.getRiskCode().equals("0576")){
	  		   	if(SwfLogDtoList.size() > 0){
	  			   DAAFlag = "Y";
	  		   	}
	  		 //��ǿ���Ƿ��Ѿ�ע��/�����־
        	}else if(prpLclaimDto1.getRiskCode().equals("0507")||
        			prpLclaimDto1.getRiskCode().equals("05077")||
        			prpLclaimDto1.getRiskCode().equals("0587")){
	  		   	if(SwfLogDtoList.size() > 0){
	  			   BZFlag = "Y";
	  		   	}
        	//�ǳ����Ƿ��Ѿ�ע��/�����־
        	}else{
	  		   if(SwfLogDtoList.size() > 0){
	  			   BZFlag = "Y";
	  		   }
        	}
        }
        httpServletRequest.setAttribute("BZFlag",BZFlag);
        httpServletRequest.setAttribute("DAAFlag",DAAFlag);     
        strSql = "registNo='" + registNo + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it1 = registList.iterator();
        if (it1.hasNext()) prpLregistDto = (PrpLregistDto) it1.next();

        //����Ϣ��request���档����
        //��������ʱ��
        prpLclaimDto.setCancelDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
        //����������
        prpLclaimDto.setDealerCode(user.getUserCode());
        prpLclaimDto.setDealerName(user.getUserName());
        //���ò���״̬ΪADD,����Ǽǣ�����Ҫ��
        prpLclaimDto.setEditType("ADD");
        httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);
        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
        PrpLRegistRPolicyDto  prpLregistRPolicyDto = new BLPrpLRegistRPolicyFacade().findByPrimaryKey(prpLclaimDto.getRegistNo(), prpLclaimDto.getPolicyNo());
        httpServletRequest.setAttribute("prpLregistRPolicyDto", prpLregistRPolicyDto);

    }

    /**
     * ���ݱ����źͱ����Ų�ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception
     */

    public void getSpecialList(HttpServletRequest httpServletRequest, String claimNo, String policyNo) throws Exception {
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

        //       ƴȨ��
        //modify by zhaolu 20060816 start
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
      
        //modify by zhaolu 20060816 end
        //��ѯ������Ϣ
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
        //�õ����б���������Ϣ
        Collection swfList = new ArrayList();
        swfList = (Collection) uiWorkFlowAction.findNodesByConditions(conditions);
        SwfLogDto swfLogDto = new SwfLogDto();
        swfLogDto.setSwfLogList(swfList);
        //swfLogDto.setEditType(httpServletRequest.getParameter("editType")) ;
        httpServletRequest.setAttribute("swfLogDto", swfLogDto);

    }

    /**
     * ���뱨�����룬Ĭ�ϳ������ı�Ҫ��Ϣ
     * 
     * @param registNo ��������
     * @throws Exception
     */
    public PrpLclaimDto registDtoToClaimDto(String registNo, UserDto user) throws Exception {
        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��������
        UIRegistAction uiRegistAction = new UIRegistAction();
        //���鿱��Ϣ���뵽������
        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
        UICheckAction uiCheckAction = new UICheckAction();
        CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo);
        prpLcheckDto = checkDto.getPrpLcheckDto();
        ArrayList list = new ArrayList();
        //���ݲ�ѯ�������������ݣ���PrpLclaimDto��ֵ
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        if (prpLcheckDto == null) //Ҫ��ʾ������֮ǰ�������鿴�ģ�����
        {
            //û�����鿱�����ǿ�������
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
        //��ѯ������Ϣ����ȡ�ʵ�����Ϣ���µǼǵ�������
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

        //lixiang �������ݽṹ������
        prpLclaimDto.setLanguage(registDto.getPrpLregistDto().getLanguage());
        prpLclaimDto.setLossName(registDto.getPrpLregistDto().getLossName());
        prpLclaimDto.setMakeCom(registDto.getPrpLregistDto().getMakeCom());
        prpLclaimDto.setHandler1Code(registDto.getPrpLregistDto().getHandler1Code());
        prpLclaimDto.setOperatorCode(user.getUserCode());
        //������Ļ�ȡ������ǲ鿱�����𣬺��𶼿���������
        prpLclaimDto.setSumClaim(registDto.getPrpLregistDto().getEstimateLoss());
        //����Ĭ�ϵľ�����
        prpLclaimDto.setHandlerCode(user.getUserCode());
        //�Գ���,�������Ϣ��֧��
        prpLclaimDto.setClauseType(registDto.getPrpLregistDto().getClauseType());
        prpLclaimDto.setClauseName(registDto.getPrpLregistDto().getClauseName());
        prpLclaimDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
        prpLclaimDto.setLicenseColorCode(registDto.getPrpLregistDto().getLicenseColorCode());
        prpLclaimDto.setLicenseColor(prpLclaimDto.getLicenseColorCode());
        prpLclaimDto.setBrandName(registDto.getPrpLregistDto().getBrandName());
        prpLclaimDto.setCarKindCode(registDto.getPrpLregistDto().getCarKindCode());
        prpLclaimDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

        //��������������״̬Ϊ �°����Ǽ� (δ��������)
        prpLclaimDto.setStatus("1");

        //�ӱ����л����Ϣ
        if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
            //��ѯ������Ϣ
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

        //���ӵ�������Ϣ
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
        ///*---------------------�ձ������PrpLclaimloss------------------------------------*/
        ArrayList claimLossList = new ArrayList();
        PrpLclaimLossDto prpLclaimLossDto = null;
        //�ӽ���õ���������
        String prpLclaimLossClaimNo = (String) httpServletRequest.getAttribute("claimNo");
        String prpLclaimLossRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
        String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode");
        String[] prpLclaimLossItemCode = httpServletRequest.getParameterValues("prpLclaimLossItemCode");
        String[] prpLclaimLossCurrency = httpServletRequest.getParameterValues("prpLclaimLossCurrency");
        String[] prpLclaimLossSumClaim = httpServletRequest.getParameterValues("prpLclaimLossSumClaim");
        String[] prpLclaimLossInputDate = httpServletRequest.getParameterValues("prpLclaimLossInputDate");
        String[] prpLclaimLossRemarkFlag = httpServletRequest.getParameterValues("prpLclaimLossRemarkFlag");
        String[] prpLclaimLossFlag = httpServletRequest.getParameterValues("prpLclaimLossFlag");
        
        
        //add 20060314 ������������д����itemkindNo ӦΪprpcitemKind���ձ����------[2]------------
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
        
        //����ֵ
        //-������ֿ�ʼ
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
                //reason:�޸Ĺ�����ĵ���
                //modify by lixiang add 20050316 end

                prpLclaimLossDto.setInputDate(new DateTime(new Date()));
                //prpLclaimLossDto.setInputDate (new DateTime(prpLclaimLossInputDate[index]));
                prpLclaimLossDto.setRemarkFlag(prpLclaimLossRemarkFlag[index]);
                prpLclaimLossDto.setFlag(prpLclaimLossFlag[index]);

                //���뼯��
                claimLossList.add(prpLclaimLossDto);
                tindex++;
            }
            claimDto.setPrpLclaimLossDtoList(claimLossList);
        }
        return claimDto;
    }
    
    /**
     * ��д��������ҳ�漰��ѯ����request������.
     * @param httpServletRequest ���ظ�ҳ���request
     * @param proposalIniDto ȡ���ĳ�ʼ����ϢDto
     * @throws Exception
     */

    public void notGrandClaimDtoToView(HttpServletRequest httpServletRequest, UserDto user) throws Exception {
        String registNo = httpServletRequest.getParameter("RegistNo"); //������
        String strSql = ""; //��ѯ����

        Collection claimList = new ArrayList();
        Collection registList = new ArrayList();
        PrpLregistDto prpLregistDto = null; //����Dto����
        
        UIRegistAction uiRegistAction = new UIRegistAction();

        strSql = "registNo='" + registNo + "'";
        registList = uiRegistAction.findByConditions(strSql);
        Iterator it = registList.iterator();
        if (it.hasNext()) {
            prpLregistDto = (PrpLregistDto) it.next();
        }

        prpLregistDto.setDealerCode(user.getUserCode());
        prpLregistDto.setComName(user.getUserName());  //�ò������Դ�Ų���Ա���� 
        prpLregistDto.setCancelDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
        
        //���ò���״̬ΪADD,����Ǽǣ�����Ҫ��
        prpLregistDto.setEditType("ADD");

        httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
    }
    /**
     * ����PolicyDto��øñ���Ͷ������Ҫ�ձ�
     * @param policyDto
     * @return
     */
    public String getDefaultKindCodeByPolicyDto(PolicyDto policyDto){
    	String kindCode="";
    	for (Iterator iter = policyDto.getPrpCitemKindDtoList().iterator(); iter.hasNext();) {
			PrpCitemKindDto itemKind = (PrpCitemKindDto) iter.next();
			//ItemKindNoΪ1��Ϊ��Ҫ�ձ�
			if(itemKind.getItemKindNo()==1||itemKind.getItemNo()==1||itemKind.getItemNo()==0){//����ҵ�����ݵ��������⣬��ʱ�����޸İ�kangzhen  20061218
				return itemKind.getKindCode();
			}
		}
    	return kindCode;
    }
   
}
