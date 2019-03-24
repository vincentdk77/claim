package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLclaimGradeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;

/**
 * <p>Title: VerifyLossViewHelper</p>
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

public class AgriVerifyLossViewHelper extends VerifyLossViewHelper {
	private static Log logger = LogFactory.getLog(AgriVerifyLossViewHelper.class);

	/**
	 * ���涨��ʱ����ҳ����������.
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * @param httpServletRequest
	 * @return verifyLossDto �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public VerifyLossDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		String lossType = httpServletRequest.getParameter("lossTypeFlag");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String nodeStatus = httpServletRequest.getParameter("nodeStatus");
		String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
		String riskcode = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
		String comCode = user.getComCode();
		//System.err.println("riskcode:" + riskcode);
		String registNo2 = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		ArrayList list = new ArrayList();
		String verifyOpinion = "";
		
		//��89��ģ������� start==
		BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        //��89��ģ�������  end===
	    if(riskcode != null){
	    	if("0310".equals(riskcode)||"0312".equals(riskcode) || riskcodeStr.indexOf(riskcode)>0  )
	    	{
	    		verifyOpinion = httpServletRequest.getParameter("verifyOpinion");
	    		System.err.println("verifyOpinion:" + verifyOpinion);
	    		String [] prpLverifyLossExtSerialNo = httpServletRequest.getParameterValues("prpLverifyLossExtSerialNo");
	    		String [] prpLverifyLossExtInputDate = httpServletRequest.getParameterValues("prpLverifyLossExtInputDate");
	    		String [] prpLverifyLossExtInputHour = httpServletRequest.getParameterValues("prpLverifyLossExtInputHour");
	    		String [] prpLverifyLossExtOperatorCode = httpServletRequest.getParameterValues("prpLverifyLossExtOperatorCode");
	    		String [] prpLverifyLossExtTitle = httpServletRequest.getParameterValues("prpLverifyLossExtTitle");
	    		String [] prpLverifyLossExtContext = httpServletRequest.getParameterValues("prpLverifyLossExtContext");
	    		if(prpLverifyLossExtSerialNo != null && prpLverifyLossExtSerialNo.length > 0)
	    		{
	    			DBManager dbManager = new DBManager();
	    			
	    			try{
	    				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	    				DBPrpLverifyLossExt dBPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
	    				ArrayList<PrpLverifyLossExtDto> arrayListVerifyLossExt = (ArrayList)dBPrpLverifyLossExt.findByConditions(" registno='" + registNo2 + "' and LOSSITEMCODE='-1' order by serialno");
	    				if(arrayListVerifyLossExt != null && arrayListVerifyLossExt.size()>0)
	    				{
	    					if ("2".equals(nodeStatus)){//ɾ�����һ��Ԫ�� ���serialno
	    						arrayListVerifyLossExt.remove(arrayListVerifyLossExt.get(arrayListVerifyLossExt.size()-1));
	    					}
	    					list = (ArrayList)arrayListVerifyLossExt;
	    				}
	    				
	    				
	    			}
	    			catch(Exception exception)
	    			{
	    				dbManager.rollbackTransaction();
	    				throw exception;
	    				
	    			}finally{
	    				dbManager.close();
	    			}
	    		}
	    		int maxIndex = prpLverifyLossExtSerialNo.length-1;
	    		PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
	    		prpLverifyLossExtDto.setContext(prpLverifyLossExtContext[maxIndex]);
	    		prpLverifyLossExtDto.setTitle(prpLverifyLossExtTitle[maxIndex]);
	    		DateTime time = new DateTime(prpLverifyLossExtInputDate[maxIndex]);
	    		
	    		prpLverifyLossExtDto.setInputDate(time);
	    		prpLverifyLossExtDto.setInputHour(prpLverifyLossExtInputHour[maxIndex]);
	    		prpLverifyLossExtDto.setLossItemCode("-1");
	    		prpLverifyLossExtDto.setOperatorCode(prpLverifyLossExtOperatorCode[maxIndex]);
	    		prpLverifyLossExtDto.setRegistNo(registNo2);
	    		prpLverifyLossExtDto.setRiskCode(riskcode);
	    		prpLverifyLossExtDto.setComCode(comCode);
	    		prpLverifyLossExtDto.setStatus(buttonSaveType);
	    		prpLverifyLossExtDto.setNodeType(nodeType);
	    		prpLverifyLossExtDto.setSerialNo(Integer.parseInt(prpLverifyLossExtSerialNo[maxIndex]));
	    		list.add(prpLverifyLossExtDto);	
	    	}
	    }
		
		
		

		//�̳ж�verifyLoss,verifyLossText��ĸ�ֵ
		VerifyLossDto verifyLossDto = super.viewToDto(httpServletRequest);
		 if(riskcode != null){
			 if("0310".equals(riskcode)||"0312".equals(riskcode)|| riskcodeStr.indexOf(riskcode)>0)
			 {
				 verifyLossDto.setPrpLverifyLossExtDtoList(list);
			 }
		 }
		/*---------------------�Ʋ��˶�����ϸ�嵥�� prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		//add by lixiang start 20051228
		//reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
		String claimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String registNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");
		//��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
		if (claimNo == null || claimNo.length() < 2) {
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		}
		//add by lixiang end 20051228

		//���������ı�
		PrpLverifyLossItemDto LossItemRepairComponentDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPersonDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemAllLossDto = new PrpLverifyLossItemDto();
		 if(riskcode != null){
			 if("0310".equals(riskcode)||"0312".equals(riskcode)|| riskcodeStr.indexOf(riskcode)>0)
			 {
				 PrpLverifyLossDto prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();
				 prpLverifyLossDto.setVerifyOpinion(verifyOpinion);
				 verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
			 }
		 }
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList lossItemListTemp = new ArrayList();

		//�ӽ���õ���������
		String prpLpropPolicyNo = httpServletRequest
				.getParameter("prpLverifyLossPolicyNo");
		String prpLpropRiskCode = httpServletRequest
				.getParameter("prpLverifyLossRiskCode");
		String prpLpropClaimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo");
		String prpLpropRegistNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo");
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpropRiskCode);

		String[] prpLpropSerialNo = httpServletRequest
				.getParameterValues("prpLpropSerialNo");
		String[] prpLpropItemKindNo = httpServletRequest
				.getParameterValues("prpLpropItemKindNo");
		String[] prpLpropFamilyNo = httpServletRequest
				.getParameterValues("prpLpropFamilyNo");
		String[] prpLpropFamilyName = httpServletRequest
				.getParameterValues("prpLpropFamilyName");
		String[] prpLpropKindCode = httpServletRequest
				.getParameterValues("prpLpropKindCode");
		String[] prpLpropItemCode = httpServletRequest
				.getParameterValues("prpLpropItemCode");
		String[] prpLpropLossItemCode = httpServletRequest
				.getParameterValues("prpLpropLossItemCode");
		String[] prpLpropLossItemName = httpServletRequest
				.getParameterValues("prpLpropLossItemName");
		String[] prpLpropFeeTypeCode = httpServletRequest
				.getParameterValues("prpLpropFeeTypeCode");
		String[] prpLpropCurrency = httpServletRequest
				.getParameterValues("prpLpropCurrency");
		String[] prpLpropUnitPrice = httpServletRequest
				.getParameterValues("prpLpropUnitPrice");
		String[] prpLpropLossQuantity = httpServletRequest
				.getParameterValues("prpLpropLossQuantity");
		String[] prpLpropUnit = httpServletRequest
				.getParameterValues("prpLpropUnit");
		String[] prpLpropBuyDate = httpServletRequest
				.getParameterValues("prpLpropBuyDate");
		String[] prpLpropDepreRate = httpServletRequest
				.getParameterValues("prpLpropDepreRate");
		String[] prpLpropSumLoss = httpServletRequest
				.getParameterValues("prpLpropSumLoss");
		String[] prpLpropSumReject = httpServletRequest
				.getParameterValues("prpLpropSumReject");
		String[] prpLpropRejectReason = httpServletRequest
				.getParameterValues("prpLpropRejectReason");
		String[] prpLpropLossRate = httpServletRequest
				.getParameterValues("prpLpropLossRate");
		String[] prpLpropSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropSumDefLoss");
		String[] prpLpropRemark = httpServletRequest
				.getParameterValues("prpLpropRemark");
		String[] prpLpropVeriUnitPrice = httpServletRequest
				.getParameterValues("prpLpropVeriUnitPrice");
		String[] prpLpropVeriLossQuantity = httpServletRequest
				.getParameterValues("prpLpropVeriLossQuantity");
		String[] prpLpropVeriUnit = httpServletRequest
				.getParameterValues("prpLpropVeriUnit");
		String[] prpLpropVeriDepreRate = httpServletRequest
				.getParameterValues("prpLpropVeriDepreRate");
		String[] prpLpropVeriSumLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumLoss");
		String[] prpLpropVeriSumReject = httpServletRequest
				.getParameterValues("prpLpropVeriSumReject");
		String[] prpLpropVeriRejectReason = httpServletRequest
				.getParameterValues("prpLpropVeriRejectReason");
		String[] prpLpropVeriLossRate = httpServletRequest
				.getParameterValues("prpLpropVeriLossRate");
		String[] prpLpropVeriSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumDefLoss");
		String[] prpLpropVeriRemark = httpServletRequest
				.getParameterValues("prpLpropVeriRemark");
		String[] prpLpropFlag = httpServletRequest
				.getParameterValues("prpLpropFlag");
		//		add by lixiang start at 2006-04-21
		//reason: ���ӱ��������˻صĶ���ı�־�ı���,�������ݲ��ᱻ������
		String[] prpLpropCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLpropCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//����ֵ
		if (prpLpropSerialNo == null) {

		} else {
			for (int index = 1; index < prpLpropSerialNo.length; index++) {
				prpLpropDto = new PrpLpropDto();
				prpLpropDto.setPolicyNo(prpLpropPolicyNo);
				prpLpropDto.setRiskCode(prpLpropRiskCode);
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setRegistNo(prpLpropRegistNo);
				prpLpropDto.setSerialNo(index);
				//prpLpropDto.setSerialNo( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo[index])));
				prpLpropDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropItemKindNo[index])));
				prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropFamilyNo[index])));
				prpLpropDto.setFamilyName(prpLpropFamilyName[index]);
				prpLpropDto.setKindCode(prpLpropKindCode[index]);
				prpLpropDto.setItemCode(prpLpropItemCode[index]);
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
				prpLpropDto.setLossItemCode("-2");
				}else{
				prpLpropDto.setLossItemCode(prpLpropLossItemCode[index]);
				}
				prpLpropDto.setLossItemName(prpLpropLossItemName[index]);
				prpLpropDto.setFeeTypeCode("");
				prpLpropDto.setFeeTypeName("");
				prpLpropDto.setCurrency(prpLpropCurrency[index]);
				prpLpropDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropUnitPrice[index])));
				prpLpropDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossQuantity[index])));
				prpLpropDto.setUnit(prpLpropUnit[index]);
				prpLpropDto.setBuyDate(new DateTime(new Date(),
						DateTime.YEAR_TO_DAY));
				//prpLpropDto.setBuyDate                  ( new DateTime(prpLpropBuyDate      [index]));
				prpLpropDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropDepreRate[index])));
				prpLpropDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumLoss[index])));
				prpLpropDto.setSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumReject[index])));
				prpLpropDto.setRejectReason(prpLpropRejectReason[index]);
				prpLpropDto.setLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossRate[index])));
				prpLpropDto.setSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumDefLoss[index])));
				prpLpropDto.setRemark(prpLpropRemark[index]);
				prpLpropDto.setVeriUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriUnitPrice[index])));
				prpLpropDto.setVeriLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossQuantity[index])));
				prpLpropDto.setVeriUnit(prpLpropVeriUnit[index]);
				prpLpropDto.setVeriDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriDepreRate[index])));
				prpLpropDto.setVeriSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumLoss[index])));
				prpLpropDto.setVeriSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumReject[index])));
				prpLpropDto
						.setVeriRejectReason(prpLpropVeriRejectReason[index]);
				prpLpropDto.setVeriLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossRate[index])));
				prpLpropDto.setVeriSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumDefLoss[index])));
				prpLpropDto.setVeriRemark(prpLpropVeriRemark[index]);
				prpLpropDto.setFlag(prpLpropFlag[index]);
				if(prpLpropCompensateBackFlag != null){
					prpLpropDto
					.setCompensateBackFlag(prpLpropCompensateBackFlag[index]);
				}
				//===========================================================
				UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction
						.findByPrimaryKey(prpLpropRegistNo);

				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
					PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
							registDto.getPrpLregistDto().getPolicyNo(),
							registDto.getPrpLregistDto().getDamageStartDate()
									.toString(), registDto.getPrpLregistDto()
									.getDamageStartHour());
					//�����Ƿ����ŵ����жϣ�������ŵ����ҳ����ȡitemkindno
					String strRiskCode = registDto.getPrpLregistDto().getRiskCode();
					GroupProposalService groupProposalService = new GroupProposalService();
					 //�Ƿ����ŵ��ı�־
			        boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
			        if(!isVirturlItemRisk) {
						for (int k = 0; k < policyDto.getPrpCitemKindDtoList().size(); k++) {
					           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
							          .getPrpCitemKindDtoList().get(k);
					           if (prpCitemKindDto.getKindCode().equals(
							          prpLpropDto.getKindCode())) {
						               prpLpropDto.setItemKindNo(prpCitemKindDto
								              .getItemKindNo());
						                 break;
					           }
						}
			        }
				}
				//===========================================================
				//���뼯��
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto, verifyLossDto
					.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("veri");
			lossItemListTemp.add(LossItemPropDto);
		}
		//�Ʋ��˶�����ϸ�嵥��
		verifyLossDto.setPrpLpropDtoList(prpLpropDtoList);
		/*---------------------��������&��������嵥&������Ŀ�嵥 prpLcarLoss&prpLrepairFee&prpLcomponent ------------------------------------*/
		
		verifyLossDto.setPrpLverifyLossItemDtoList(lossItemListTemp);
		
		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//�ӽ���õ���������
		String prpLregistExtRegistNo = (String) httpServletRequest
				.getParameter("prpLregistExtRegistNo");
		String prpLregistExtRiskCode = httpServletRequest
				.getParameter("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest
				.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest
				.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest
				.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest
				.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest
				.getParameterValues("prpLregistExtContext");

		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLregistExtSerialNo == null) {
		} else {
			//System.out.println("��Ա�������ٲ��ֿ�ʼ ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
						.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//���������м�����ʧ��λ
			verifyLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}
		
		//System.err.println("riskcode11:"+ riskcode);
		 if(riskcode != null){
			 
			 if("0310".equals(riskcode)||"0312".equals(riskcode) || riskcodeStr.indexOf(riskcode)>0)
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
				 
				 //System.err.println("prplCompensateHouseIDcard:" + prplCompensateHouseIDcard.length);
				 
				 
				 if (prplCompensateHouseIDcard == null){
				 }else{
					 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
					 {
						 prplCompensateHouseDto = new PrplcompensatehouseDto();
						 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
						 prplCompensateHouseDto.setBusinessno(registNo2);
						 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
						 prplCompensateHouseDto.setClaimno(prplCompensateHouseClaimNo[index]);
						 prplCompensateHouseDto.setCompensateno(prplCompensateHouseCompensateNo[index]);
						 prplCompensateHouseDto.setDamagecode(prplCompensateHouseDamageCode[index]);
						 prplCompensateHouseDto.setDamagename(prplCompensateHouseDamageName[index]);
						 prplCompensateHouseDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("prpLregistDamageStartDate1"),DateTime.YEAR_TO_DAY));
						 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
						 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
						 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
						 prplCompensateHouseDto.setKindcode("001");
						 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
						 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
						 prplCompensateHouseDto.setRegistno(registNo2);
						 prplCompensateHouseDto.setPolicyno(prpLpropPolicyNo);
						 prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
						 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
						 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
						 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
						 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
						 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
						 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);
						 
						 if("propv".equals(httpServletRequest.getParameter("nodeType")))
						 {
							 prplCompensateHouseDto.setNodeno(17);
							 prplCompensateHouseDto.setNodetype("propv");
						 }
						 prplCompensateHouseDtoList.add(prplCompensateHouseDto);
					 }
					 
					 verifyLossDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
				 }
			 }
		 }

		return verifyLossDto;
	}

	/**
	 * ���ɶ�����Ϣ��ϸ����
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo     ҵ�����
	 * @param editType   �༭����
	 * @throws Exception
	 */
	public void verifyLossDtoView(HttpServletRequest httpServletRequest,
			String registNo, String editType, String tempStatus)
			throws Exception {
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//����������Ϣ
		String swfLogFlowID = (String) httpServletRequest
				.getParameter("swfLogFlowID");
		String swfLogLogNo = (String) httpServletRequest
				.getParameter("swfLogLogNo");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");

		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //�û���Ϣ

		String riskCode = httpServletRequest.getParameter("riskCode");
		//�ǳ��գ�lossItemCodeĬ��Ϊ1,�����Ϳ����������вƲ�����ϸ��ɾ��������
		logger.debug("RiskCode:" + riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		//modify by miaowenjun 20060925 start ũ�յ�lossitemcode�ݶ�Ϊ-2
		if (riskCode != null && !strRiskType.equals(("D")) && !strRiskType.equals(("I"))&& !strRiskType.equals(("H"))) {
			lossItemCode = "1";
		}
		if (strRiskType.equals(("I"))|| strRiskType.equals(("H"))) {
			lossItemCode = "-2";
		}
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode);

		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);

		//���ݲ�ѯ�������������ݣ���PrpLverifyLossDto��ֵ
		PrpLverifyLossDto prpLverifyLossDto = verifyLossDto
				.getPrpLverifyLossDto();

		//���ö��������״̬Ϊ �����޸� (����������)      
		if (verifyLossDto.getPrpLclaimStatusDto() != null) {
			if (tempStatus == null) {
				prpLverifyLossDto.setStatus(verifyLossDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				prpLverifyLossDto.setStatus(tempStatus);
			}
		} else {
			//���ύ���Ѿ�������ϵ�״̬
			prpLverifyLossDto.setStatus("1");
		}

		//У���Ƿ��Ѿ�����ѯ�ۣ�����Ѿ�����ѯ�ۣ�������˼�Ա��Ȩ���ύ
		if (!prpLverifyLossDto.getStatus().equals("4")) {
			String msg = "";
			msg = this.checkVerpo(swfLogFlowID, swfLogLogNo, lossItemCode);
			prpLverifyLossDto.setVerifPriceOuterMsg(msg);
		}

		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
		String relatePolicyFlag = "0";
		if (registDto.getPrpLRegistRPolicyList().size() > 1) {
			relatePolicyFlag = "1";
		}
		if ("1".equals(relatePolicyFlag)) {
			httpServletRequest.setAttribute("prpLregistRPolicyNo", registDto
					.getPrpLRegistRPolicyDtoOfCompel());
		}
		//add by zhaolu end at 2006-06-09
		//�����������
		prpLverifyLossDto.setClauseType(registDto.getPrpLregistDto()
				.getClauseType());

		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo());
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest);

		//��ѯ�˼�Ȩ��       
		String taskCode = AppConfig.get("sysconst.TASKCODE_LPHJ"); //�������Ϊ�˼�
		UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();

		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLE_CUSTOM_COMP_PRICE");
		//�����Զ�������۸�
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_CUSTOM_COMP_PRICE");
		//����ȫ������۸�
		PrpLclaimGradeDto prpLclaimGradeDto3 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_ALL_COMP_PRICE");

		if (prpLclaimGradeDto1 == null)
			prpLclaimGradeDto1 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto2 == null)
			prpLclaimGradeDto2 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto3 == null)
			prpLclaimGradeDto3 = new PrpLclaimGradeDto();

		httpServletRequest.setAttribute("prpLclaimGradeDto1",
				prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2",
				prpLclaimGradeDto2);
		httpServletRequest.setAttribute("prpLclaimGradeDto3",
				prpLclaimGradeDto3);

		//���ö�����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);

		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections
				.getVerifyPriceOpinionList());
		//Reason:���Ӻ������       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());

		//���ø����ӱ���Ϣ������
		setSubInfo(httpServletRequest, verifyLossDto);

		PrpLthirdPartyDto prpLthirdParty1Dto = new PrpLthirdPartyDto();
		prpLthirdParty1Dto = certainLossDto.getPrpLthirdPartyDto();
		httpServletRequest.setAttribute("prpLthirdParty1Dto",
				prpLthirdParty1Dto);

		//ȡ������������Ϣ 
		//UIRegistAction uiRegistAction = new UIRegistAction();
		CaseRelateNodeDto caseRelateNodeDto = uiRegistAction
				.relateNode(registNo);
		PrpLcheckDto prpLcheckDtoTemp1 = caseRelateNodeDto.getPrpLcheckDto();
		if (prpLcheckDtoTemp1 == null)
			prpLcheckDtoTemp1 = new PrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp1);
		PrpLregistDto prpLregistDtoTemp1 = caseRelateNodeDto.getPrpLregistDto();
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp1
				.getDamageStartHour());
		prpLregistDtoTemp1.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp1.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp1);

		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo ҵ�����
	 * @param editType �༭����
	 * @throws Exception
	 */
	public void certainLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType) throws Exception {
		//�����ţ����������Ϊ0������Ϊ1��2��3��4��5�ȳ������
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//����������Ϣ
		String swfLogFlowID = (String) httpServletRequest
				.getParameter("swfLogFlowID");
		String swfLogLogNo = (String) httpServletRequest
				.getParameter("swfLogLogNo");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //�û���Ϣ

		String riskCode = httpServletRequest.getParameter("riskCode");

		//�ǳ��գ�lossItemCodeĬ��Ϊ1,�����Ϳ����������вƲ�����ϸ��ɾ��������
		//System.out.println("riskCode=============="+riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode);

		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//System.out.println("registNo-------"+registNo);
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);
		
		//���ݲ�ѯ�������������ݣ���PrpLverifyLossDto��ֵ
		PrpLverifyLossDto prpLverifyLossDto = null;
		prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();
		
		if (prpLverifyLossDto == null) {
			prpLverifyLossDto = new PrpLverifyLossDto();
		}
		//׼������

		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) verifyLossDto
						.getPrpLpropDtoList().get(i);
				prpLpropDto.setVeriSumLoss(prpLpropDto.getSumLoss());
				prpLpropDto.setVeriSumReject(prpLpropDto.getSumReject());
				prpLpropDto.setVeriSumDefLoss(prpLpropDto.getSumDefLoss());
				prpLpropDto.setVeriRemark(prpLpropDto.getRemark());

			}
		}
		prpLverifyLossDto.setStatus("1");

		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
		//�����������
		prpLverifyLossDto.setClauseType(registDto.getPrpLregistDto()
				.getClauseType());

		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo());
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest);

		//���ö�����Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);
		if (nodeType.equals("verip")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceOpinionList());
		} else if (nodeType.equals("verpo")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceVerpoOpinionList());
		}

		//Modify by chenrenda add begin 20050421
		//Reason:���Ӻ������
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());
		//Modify by chenrenda add  end 20050421

		//���ø����ӱ���Ϣ������
		verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest, verifyLossDto);

		//ȡ������������Ϣ
		//UIRegistAction uiRegistAction = new UIRegistAction();
		CaseRelateNodeDto caseRelateNodeDto = uiRegistAction
				.relateNode(registNo);
		PrpLcheckDto prpLcheckDtoTemp1 = caseRelateNodeDto.getPrpLcheckDto();
		if (prpLcheckDtoTemp1 == null)
			prpLcheckDtoTemp1 = new PrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp1);
		PrpLregistDto prpLregistDtoTemp1 = caseRelateNodeDto.getPrpLregistDto();
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp1
				.getDamageStartHour());
		prpLregistDtoTemp1.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp1.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp1);

		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * ��鱾���˼��Ƿ�������ѯ��
	 * @param swfLogDtoCurrent SwfLogDto ��Ҫ�����Ľڵ����
	 * @throws Exception
	 */
	public String checkVerpo(String swfLogFlowID, String swfLogLogNo,
			String lossItemCode) throws Exception {
		//Ŀǰֻ���ó��˼��Ƿ��Ѿ�ѯ�۹���ֻ��Ե�������

		String nodeType = "";
		String conditions = "";
		String msg = "";

		SwfLogDto swfLogDtoCurrent = null;

		int logNo = Integer.parseInt(DataUtils.nullToZero(swfLogLogNo));

		if (swfLogFlowID == null || logNo < 1)
			return msg;

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogDtoCurrent = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,
				logNo);
		if (swfLogDtoCurrent == null)
			return msg;

		nodeType = swfLogDtoCurrent.getNodeType();

		if (nodeType.equals("verip")) //�˼ۼ���Ƿ��Ѿ�����ѯ��
		{
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and nodeType='verpo'  and  lossItemCode = '"
					+ lossItemCode + "' ";
		}

		if (uiWorkFlowAction.getCount(conditions) > 0) {
			msg = "�����Ѿ�����ѯ��";
		}
		return msg;
	}

	/**
	 * �Ѻ��𰸼���ѯ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param businessNo      �ⰸ��
	 * @throws Exception
	 */
	public void getUnderWriteVerifyLossList(
			HttpServletRequest httpServletRequest) throws Exception {
		logger.info("��ѯ�Ѻ��㰸�� �� like �������Ż�");
		//caseNO,policyNo,claimNo
		//��������ı����ţ����������SQL where �Ӿ�
		String conditions = "";
		conditions = " underWriteFlag = '1' ";
		//��ѯ������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//�õ����ж���������Ϣ
		Collection verifyLossList = new ArrayList();
		verifyLossList = (Collection) uiVerifyLossAction
				.findByConditions(conditions);
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	/**
	 * ��ȡѡ�����б���е���������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest)
			throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(11)�õ��������Ƶ��б� ---
		Collection FeeTypeCodeList = new ArrayList();
		FeeTypeCodeList.add(new LabelValueBean("�����", "01"));
		FeeTypeCodeList.add(new LabelValueBean("���Ϸ�", "02"));
		httpServletRequest.setAttribute("FeeTypeCodeList", FeeTypeCodeList);

		//(2)�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
						"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);

	}

	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLverifyLossDto prpLverifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//������ɫת��
		String licenseColorCodeCode = prpLverifyLossDto.getLicenseColorcode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor",
				licenseColorCodeCode, true);
		prpLverifyLossDto.setLicenseColor(licenseColor);
		//��������ת��
		String carKindCode = prpLverifyLossDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode,
				true);
		prpLverifyLossDto.setCarKind(carKind);
		//�������Ƶ�ת��
		String clauseType = prpLverifyLossDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLverifyLossDto.setClauseName(clauseName);

	}

	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �����������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		String compelRiskCode = "";//��ǿ�����ֺ�
		String businessRiskCode = "";//��ҵ�����ֺ�
		String riskCode = "";
        String riskCodeType = "";//��������
        TransCodeCI transCodeCI = new TransCodeCI();

		PrpLpropDto prpLpropDto = null;
		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				prpLpropDto = (PrpLpropDto) verifyLossDto.getPrpLpropDtoList()
						.get(i);
				if (prpLpropDto.getFeeTypeCode().trim().equals("01")) {
					prpLpropDto.setFeeTypeName("�����");
				} else if (prpLpropDto.getFeeTypeCode().trim().equals("02")) {
					prpLpropDto.setFeeTypeName("���Ϸ�");
				}
		        riskCode  = prpLpropDto.getRiskCode();
				if ("BZ".equals(prpLpropDto.getKindCode())) {

			        riskCodeType = "";
			        //ȡ��ǿ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLpropDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpropDto.getKindCode(),
							true));
				} else {
			        riskCodeType = "";
			        //ȡ��ҵ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLpropDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpropDto.getKindCode(),
							true));
				}
			}
		}

		PrpLcarLossDto prpLcarLossDto = null;
		if (verifyLossDto.getPrpLcarLossDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLcarLossDtoList().size(); i++) {
				prpLcarLossDto = (PrpLcarLossDto) verifyLossDto
						.getPrpLcarLossDtoList().get(i);
				//�Ƿ�Ϊ����������ת��
				if (prpLcarLossDto.getInsureCarFlag().trim().equals("1")) {
					prpLcarLossDto.setInsureCarFlagName("��");
				} else {
					prpLcarLossDto.setInsureCarFlagName("��");
				}
				//��������
				prpLcarLossDto.setCarKindName(uiCodeAction.translateCodeCode(
						"CarKind", prpLcarLossDto.getCarKindCode(), true));
			}
		}

		if (verifyLossDto.getPrpLrepairFeeDtoList() != null) {
			PrpLrepairFeeDto prpLrepairFeeDto = null;
			//�ձ�����ת��
			Iterator iterator = verifyLossDto.getPrpLrepairFeeDtoList()
					.iterator();
			while (iterator.hasNext()) {
				prpLrepairFeeDto = (PrpLrepairFeeDto) iterator.next();
				prpLrepairFeeDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLrepairFeeDto.getHandlerCode(), true));
		        riskCode  = prpLrepairFeeDto.getRiskCode();
				if ("BZ".equals(prpLrepairFeeDto.getKindCode())) {
			        riskCodeType = "";
			        //ȡ��ǿ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLrepairFeeDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLrepairFeeDto.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //ȡ��ҵ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLrepairFeeDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLrepairFeeDto.getKindCode(), true));
				}
				prpLrepairFeeDto.setRepairTypeName(uiCodeAction
						.translateCodeCode("RepairType", prpLrepairFeeDto
								.getRepairType(), true));

			}
		}

		if (verifyLossDto.getPrpLcomponentDtoList() != null) {
			PrpLcomponentDto prpLcomponentDto = null;
			//�ձ�����ת��
			Iterator iterator1 = verifyLossDto.getPrpLcomponentDtoList()
					.iterator();
			while (iterator1.hasNext()) {
				prpLcomponentDto = (PrpLcomponentDto) iterator1.next();
				prpLcomponentDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLcomponentDto.getHandlerCode(), true));
		        riskCode  = prpLcomponentDto.getRiskCode();
				if ("BZ".equals(prpLcomponentDto.getKindCode())) {
			        riskCodeType = "";
			        //ȡ��ǿ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLcomponentDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLcomponentDto.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //ȡ��ҵ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLcomponentDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLcomponentDto.getKindCode(), true));
				}
			}
		}
		if (verifyLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			//�ձ�����ת��
			Iterator iterator2 = verifyLossDto.getPrpLpersonDtoList()
					.iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
		        riskCode  = prpLpersonDto.getRiskCode();
				if ("BZ".equals(prpLpersonDto.getKindCode())) {
			        riskCodeType = "";
			        //ȡ��ǿ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLpersonDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpersonDto
									.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //ȡ��ҵ��uticodetransfer������
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLpersonDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpersonDto
									.getKindCode(), true));
				}
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode(
						"DamageDistrict", prpLpersonDto.getAreaCode(), true));
				if (prpLpersonDto.getFixedIncomeFlagName().trim().equals("1")) {
					prpLpersonDto.setFixedIncomeFlagName("�й̶�����");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("2")) {
					prpLpersonDto.setFixedIncomeFlagName("�޹̶�����");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("3")) {
					prpLpersonDto.setFixedIncomeFlagName("������");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("4")) {
					prpLpersonDto.setFixedIncomeFlagName("���Ͷ�����");
				} else {
					prpLpersonDto.setFixedIncomeFlagName("����");
				}
				if (prpLpersonDto.getPayPersonType().trim().equals("1")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("2")) {
					prpLpersonDto.setPayPersonTypeName("��������");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("3")) {
					prpLpersonDto.setPayPersonTypeName("������");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("4")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("5")) {
					prpLpersonDto.setPayPersonTypeName("��");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("6")) {
					prpLpersonDto.setPayPersonTypeName("�μ��¹ʴ�����Ա");
				} else {
					prpLpersonDto.setPayPersonTypeName("����");
				}
			}
		}
	}

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
	 * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
	 * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public VerifyLossDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		VerifyLossDto verifyLossDto = new VerifyLossDto();
		return verifyLossDto;
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param verifyLossDto ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
	}

	/**
	 * ����verifyLossDto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param verifyLossDto    �����������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		//Reason:�õ����������б�
		String strRiskCode = BusinessRuleUtil.getRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo(), "RegistNo");
		UICodeAction uiCodeAction = new UICodeAction();
		Collection repairTypes = uiCodeAction.getCodeType("RepairType",
				strRiskCode);
		httpServletRequest.setAttribute("repairTypes", repairTypes);
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());

		//����������Ϣ����˵�������б�׼������
		Collection arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd = new PrpLverifyLossExtDto();
		if (nodeType.equals("verip")) {
			prpLverifyLossExtDtoAdd.setTitle("ͬ�ⱨ��");
		}
		if (nodeType.equals("verif")) {
			prpLverifyLossExtDtoAdd.setTitle("ͬ�ⶨ��");
		}

		if (nodeType.equals("backc")) {
			prpLverifyLossExtDtoAdd.setTitle("ͨ������");
		}
		prpLverifyLossExtDtoAdd.setRegistNo(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo());
		prpLverifyLossExtDtoAdd.setRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRiskCode());
		prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_SECOND).getHour()
				+ "ʱ"
				+ new DateTime(DateTime.current().toString(),
						DateTime.YEAR_TO_SECOND).getMinute() + "��");
		prpLverifyLossExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLverifyLossExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListVerifyLossExt = verifyLossDto.getPrpLverifyLossExtDtoList();
		if (arrayListVerifyLossExt == null) {
			arrayListVerifyLossExt = new ArrayList();
		}
		prpLverifyLossExtDtoAdd.setSerialNo(arrayListVerifyLossExt.size() + 1);
		String status = httpServletRequest.getParameter("status");
		if ("0".equals(status)) {
			arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
		}
		prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt);
		httpServletRequest.setAttribute("prpLverifyLossExtDto",
				prpLverifyLossExtDto);

		//��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLregistExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListRegistExt = verifyLossDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		//�Ʋ��˶�����ϸ�嵥�����б�׼������
		ArrayList arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		arrayList4 = verifyLossDto.getPrpLpropDtoList();
		//add by kangzhen
		//modify by miaowenjun 20070202
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		PolicyDto policyDto = new PolicyDto();
		PrpCitemKindDto prpCitemKindDto =new PrpCitemKindDto(); 
		if (arrayList4 != null) {
	        for (int i = 0; i < arrayList4.size(); i++) {
	          PrpLpropDto prpLpropDto1 = (PrpLpropDto) arrayList4.get(i);
	          prpCitemKindDto = uiPolicyAction.findPrpCitemKindDtoByConditions(prpLpropDto1.getPolicyNo(), prpLpropDto1.getKindCode());
	          
	          prpLpropDto1.setKindName(prpCitemKindDto.getKindName());
	        }
	    }
		prpLpropDto.setPropList(arrayList4);
		httpServletRequest.setAttribute("prpLpropDto", prpLpropDto);
		}

	/**
	 * ����Ƿ��ѳ��ⰸ������
	 * ����ֵ   true �ѳ�        false δ��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {
		//���ݱ�������ȡ�ö�Ӧ���ⰸ����
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		//ȡ������������Ϣ
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			return false;
		} else {
			return true;
		}
	}


	/**
	 * ��ѯ��������������ѡ��Ľڵ�����
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest)
			throws Exception {
		String modelNo = httpServletRequest.getParameter("modelNo"); //ģ���
		String nodeNo = httpServletRequest.getParameter("nodeNo"); //�ڵ��
		int nextNodeNo = 0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		if (modelNo != null && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo, nodeNo);
			if (pathList.iterator().hasNext()) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}
}
