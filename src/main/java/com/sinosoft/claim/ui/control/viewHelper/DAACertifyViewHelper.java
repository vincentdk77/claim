package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>
 * Title: CertifyViewHelper
 * </p>
 * <p>
 * Description:��֤ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public class DAACertifyViewHelper extends CertifyViewHelper {
	private static final Log logger = LogFactory.getLog(DAACertifyViewHelper.class);

	/**
	 * ���浥֤ʱ��֤ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * 
	 * @param httpServletRequest
	 * @return certifyDto ��֤���ݴ������ݽṹ
	 * @throws Exception
	 *             modify by qinyongli ����ǳ��յ����ݴ���
	 */
	public CertifyDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// �̳ж�certify,certifyText��ĸ�ֵ
		CertifyDto certifyDto = super.viewToDto(httpServletRequest);
		if (certifyDto.getNodeType().equals("CertifDirect")) {
			/*---------------------����ָ�� PrpLcertifyDirect------------------------------------*/
			ArrayList prpLcertifyDirecDtotList = new ArrayList();
			CertifyAttribute certifyAttribute = new CertifyAttribute();
			// �ӽ���õ���������
			certifyAttribute.setRegistNo((String) httpServletRequest
					.getParameter("prpLcertifyCollectBusinessNo"));
			// ȡ�ñ�����������Ϣ
			RegistDto registDto = new UIRegistAction()
					.findByPrimaryKey(certifyAttribute.getRegistNo());
			certifyAttribute.setPolicyNo(registDto.getPrpLregistDto()
					.getPolicyNo());
			certifyAttribute.setRiskCode(registDto.getPrpLregistDto()
					.getRiskCode());

			// add by miaowenjun 20060620 �жϱ�������ҵ��ǿ�����ǹ���
			String compelPolicyFlag = "0";
			String relatePolicyFlag = "0";
			if (registDto.getPrpLRegistRPolicyList().size() > 1) {
				relatePolicyFlag = "1";
			} else if ("3".equals(((PrpLRegistRPolicyDto) registDto
					.getPrpLRegistRPolicyList().get(0)).getPolicyType())) {
				compelPolicyFlag = "1";
			}
			httpServletRequest.setAttribute("compelPolicyFlag",
					compelPolicyFlag);
			httpServletRequest.setAttribute("relatePolicyFlag",
					relatePolicyFlag);
			// add end by miaowenjun 20060620
			int serialNo = 0;

			// add by miaowenjun 20060609
			String[] checkArray = httpServletRequest
					.getParameterValues("prpLcertifyDirectCode");
			String[] lossItemCode = httpServletRequest
					.getParameterValues("prpLcertifyDirectLossItemCode");
			String[] compelFlag = httpServletRequest
					.getParameterValues("compleChoiceFlag");
			String[] certifyDirectFlag = httpServletRequest
					.getParameterValues("certifyDirectFlag");
			// add end by miaowenjun

			UICodeAction uiCodeAction = new UICodeAction();
			// ������
			
			if(checkArray != null){
				for (int i = 0; i < checkArray.length; i++) {
					String cFlag = "0";
					String bFlag = "0";

					// ����Ǳ�ѡ���
					if (!checkArray[i].equals("0")) {
						serialNo++;
						PrpLcertifyDirectDto prpLcertifyDirectDto = new PrpLcertifyDirectDto();
						prpLcertifyDirectDto.setRegistNo(certifyAttribute
								.getRegistNo());
						prpLcertifyDirectDto.setSerialNo(serialNo);
						prpLcertifyDirectDto.setRiskCode(certifyAttribute
								.getRiskCode());
						prpLcertifyDirectDto.setPolicyNo(certifyAttribute
								.getPolicyNo());
						prpLcertifyDirectDto.setLossItemCode(lossItemCode[i]);
						prpLcertifyDirectDto.setTypeCode(checkArray[i]);
						prpLcertifyDirectDto
								.setTypeName(uiCodeAction.translateCodeCode(
										"ImageType", checkArray[i], true));
						prpLcertifyDirectDto.setColumnValue("columevaue");
						if ("D".equals(uiCodeAction
								.translateRiskCodetoRiskType(certifyAttribute
										.getRiskCode()))) {
							if ("1".equals(compelFlag[i])) {
								cFlag = "1";
							}
							if ("1".equals(certifyDirectFlag[i])) {
								bFlag = "1";
							}
							prpLcertifyDirectDto.setCompelFlag(cFlag);
							prpLcertifyDirectDto.setBusinessFlag(bFlag);
						}
						prpLcertifyDirecDtotList.add(prpLcertifyDirectDto);
					}
				}
				
			}
			certifyAttribute.setSerialNo(serialNo);
			/**
			 * ��ȡ�Զ�������
			 */
			List customCertifyDirect = getCustomCertifyDirect(
					httpServletRequest, certifyAttribute);
			prpLcertifyDirecDtotList.addAll(customCertifyDirect);

			// ���������м������߳���
			certifyDto.setPrpLcertifyDirectDtoList(prpLcertifyDirecDtotList);
		}

		ArrayList prpLqualityCheckDtoList = new ArrayList();
		PrpLqualityCheckDto prpLqualityCheckDto = null;
		String strCount = httpServletRequest.getParameter("txtRecordNum");
		logger.debug("-----1---" + strCount);
		int intCount = Integer.parseInt(DataUtils.nullToZero(strCount));
		int j = 0;
		String strQuestionCode = "";
		String strQuestionName = "";
		String strQuestionRemark = "";
		String strVisitBackQueRes = "";
		for (int i = 0; i < intCount; i++) {
			j = i + 1;

			strQuestionCode = "txtQuestionCode" + j;
			strQuestionName = "txtQuestionName" + j;
			strQuestionRemark = "txtQuestionRemark" + j;
			strVisitBackQueRes = "VisitBackQue" + j;
			prpLqualityCheckDto = new PrpLqualityCheckDto();
			prpLqualityCheckDto.setRegistNo(certifyDto
					.getPrpLcertifyCollectDto().getBusinessNo());
			prpLqualityCheckDto.setQualityCheckType(httpServletRequest
					.getParameter("qualityCheckType"));
			prpLqualityCheckDto.setSerialNo(i + 1);
			prpLqualityCheckDto.setTypeName(httpServletRequest
					.getParameter(strQuestionName));
			prpLqualityCheckDto.setTypeCode(httpServletRequest
					.getParameter(strQuestionCode));
			prpLqualityCheckDto.setCheckResult(httpServletRequest
					.getParameter(strVisitBackQueRes));
			prpLqualityCheckDto.setCheckRemark(httpServletRequest
					.getParameter(strQuestionRemark));
			prpLqualityCheckDto.setFlag("");
			prpLqualityCheckDtoList.add(prpLqualityCheckDto);
			logger.debug("----j----" + j + "|" + strVisitBackQueRes + "|"
					+ strQuestionRemark);
		}
		// �ӵ�ArrayList��
		certifyDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		// ����ط���ѯ��Ϣ����

		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		// �ӽ���õ���������
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

		// ����ֵ
		// ��Ա�������� ���ֿ�ʼ
		if (prpLregistExtSerialNo == null) {
		} else {
			// logger.debug("��Ա�������ٲ��ֿ�ʼ ");
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
				// ���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			// ���������м�����ʧ��λ
			certifyDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		logger
				.debug("------nodeType- �����嵥�ı�־------"
						+ certifyDto.getNodeType());
		return certifyDto;
	}

	/**
	 * ��д��֤ҳ�漰��ѯ��֤request������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param certifyDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CertifyDto certifyDto) throws Exception {
	}

	/**
	 * ���뵥֤�ռ�����ǰȡ�ñ�Ҫ�ĳ�ʼ��Ϣ.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param registNo
	 *            ҵ�����
	 * @throws Exception
	 */
	public void certifyDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String uploadNodeFlag) throws Exception {
		UICertifyAction uiCertifyAction = new UICertifyAction();
		UIRegistAction uiRegistAction = new UIRegistAction();
		UICheckAction uiCheckAction = new UICheckAction(); // add by miaowenjun
															// 20060419
		// ����������Ϣ
		String swfLogFlowID = (String) httpServletRequest
				.getParameter("swfLogFlowID");
		String swfLogLogNo = (String) httpServletRequest
				.getParameter("swfLogLogNo");

		CertifyDto certifyDto = uiCertifyAction.findByPrimaryKey(registNo);
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(registNo); // add
																		// by
																		// miaowenjun
																		// 20060419
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// add by miaowenjun 20060620 �жϱ�������ҵ��ǿ�����ǹ���
		String compelPolicyFlag = "0";
		String relatePolicyFlag = "0";
		if (registDto.getPrpLRegistRPolicyList().size() > 1) {
			relatePolicyFlag = "1";
		} else if (registDto.getPrpLRegistRPolicyList().size() > 0) {
			if("3".equals(((PrpLRegistRPolicyDto) registDto
						.getPrpLRegistRPolicyList().get(0)).getPolicyType()))
			compelPolicyFlag = "1";
		}
		httpServletRequest.setAttribute("compelPolicyFlag", compelPolicyFlag);
		httpServletRequest.setAttribute("relatePolicyFlag", relatePolicyFlag);
		// add end by miaowenjun 20060620
			if ("1".equals(relatePolicyFlag)) {
			httpServletRequest.setAttribute("prpLregistRPolicyNo", registDto
					.getPrpLRegistRPolicyDtoOfCompel());
		}
		httpServletRequest.setAttribute("prpLregistDto", registDto
				.getPrpLregistDto());// modify by miaowenjun 20060620

		// add by zhaolu end at 2006-06-09
		PrpLcertifyCollectDto prpLcertifyCollectDto = null;
		//PrpLcertifyDirectDto prpLcertifyDirectDtoForTemp = null;
		// ����Ѿ����ڵ�֤����(PrpLcertifyCollect)��Ϣ
		if (certifyDto != null && certifyDto.getPrpLcertifyCollectDto() != null) {
			logger.debug("----�Ѿ����ڵ�֤������Ϣ---------");
			prpLcertifyCollectDto = certifyDto.getPrpLcertifyCollectDto();
			// ����״̬��ԭ���е�ȡԭ���ģ�û�е�����Ϊ1
			if (certifyDto.getPrpLclaimStatusDto() != null) {
				prpLcertifyCollectDto.setStatus(certifyDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				prpLcertifyCollectDto.setStatus("1");
			}
		} else {
			logger.debug("----�����ڵ�֤������Ϣ---------"
					+ registDto.getPrpLregistDto().getPolicyNo());
			prpLcertifyCollectDto = new PrpLcertifyCollectDto();
			prpLcertifyCollectDto.setBusinessNo(registNo);
			prpLcertifyCollectDto.setPolicyNo(registDto.getPrpLregistDto()
					.getPolicyNo());
			// �������߳��ռ���־
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < registDto.getPrpLthirdCarLossDtoList().size() + 3; i++) {
				stringBuffer.append("0");
			}
			logger.debug("----�����ڵ�֤������Ϣ--stringBuffer-------"
					+ stringBuffer.toString());
			prpLcertifyCollectDto.setCltThirdCarFlag(stringBuffer.toString());// ʮ��������
			prpLcertifyCollectDto.setLossItemCode("1");
			prpLcertifyCollectDto.setLossItemName("�������");
			prpLcertifyCollectDto.setPicCount(0);
			prpLcertifyCollectDto.setUploadYear(String.valueOf(new DateTime(
					DateTime.current().toString()).getYear()));
			prpLcertifyCollectDto.setRiskCode(registDto.getPrpLregistDto()
					.getRiskCode());
			prpLcertifyCollectDto.setStartDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
			prpLcertifyCollectDto.setStartHour(String.valueOf(DateTime
					.current().getHour()));
			prpLcertifyCollectDto.setEndDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
			prpLcertifyCollectDto.setEndHour(String.valueOf(DateTime.current()
					.getHour()));
			if (httpServletRequest.getSession().getAttribute("user") == null) {
				prpLcertifyCollectDto.setOperatorCode(registDto
						.getPrpLregistDto().getHandlerCode());
			} else {
				UserDto user = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				prpLcertifyCollectDto.setOperatorCode(user.getUserCode());
			}

			prpLcertifyCollectDto.setContent("");
			prpLcertifyCollectDto.setFlag("");
			prpLcertifyCollectDto.setCaseFlag("0000"); // �¹�����
			prpLcertifyCollectDto.setStatus("1");
			

		}
		// �������Ķ���
		String editType = httpServletRequest.getParameter("editType");
		if (!prpLcertifyCollectDto.getStatus().equals("4") || (editType!=null && !editType.equals("SHOW"))) {
			String msg = "";

			// У�������Ƿ�ע������
			UIClaimAction uiclaimAction = new UIClaimAction();
			Collection claimDtoList = new ArrayList();
			PrpLclaimDto prpLclaimDto = null;
			claimDtoList = uiclaimAction.findByQueryConditions(" prplclaim.registNo='"
					+ registNo + "'");

			Iterator it = claimDtoList.iterator();

			while (it.hasNext()) {
				prpLclaimDto = (PrpLclaimDto) it.next();

				if (prpLclaimDto.getCaseType().trim().equals("0"))
					msg = "�ð��Ѿ�ע��";
				else{
					msg = "";
					break;
				}
				if (prpLclaimDto.getCaseType().trim().equals("1"))
					msg = "�ð��Ѿ�����";
				else{
					msg = "";
					break;
				}
			}

			if (msg.equals("")) {
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				msg = workFlowViewHelper.checkNodeSubmit(swfLogFlowID,
						swfLogLogNo);
			}

			prpLcertifyCollectDto.setNoSubmitMsg(msg);
		}
		String status = httpServletRequest.getParameter("status");// �ӹ�������ȥ״̬
		if (status != null && !status.equals(""))
			prpLcertifyCollectDto.setStatus(status);
		// �ѵ�֤�������õ� prpLcertifyCollectDto
		httpServletRequest.setAttribute("prpLcertifyCollectDto",
				prpLcertifyCollectDto);

		// ����֤��Ӱ���(PrpLcertifyImg)
		PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
		prpLcertifyImgDto.setCertifyImgList(certifyDto
				.getPrpLcertifyImgDtoList());
		if (certifyDto.getPrpLcertifyImgDtoList() != null) {
			logger.debug("---����֤��Ӱ���------"
					+ certifyDto.getPrpLcertifyImgDtoList().size() + "|"
					+ certifyDto.getPrpLcertifyDirectDtoList().size());
		}
		prpLcertifyImgDto.setUploadNodeFlag(uploadNodeFlag);
		prpLcertifyImgDto.setBusinessNo(registNo);
		prpLcertifyImgDto.setPolicyNo(registDto.getPrpLregistDto()
				.getPolicyNo());
		prpLcertifyImgDto.setSignInDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLcertifyImgDto.setThirdPartyCode("9999999999");

		if (httpServletRequest.getSession().getAttribute("user") == null) {
			prpLcertifyImgDto.setCollectorName(registDto.getPrpLregistDto()
					.getHandlerCode());
		} else {
			prpLcertifyImgDto.setCollectorName(((UserDto) httpServletRequest
					.getSession().getAttribute("user")).getUserCode());
		}
		prpLcertifyImgDto.setFlag("1");
		httpServletRequest.setAttribute("prpLcertifyImgDto", prpLcertifyImgDto);
		httpServletRequest.getSession().setAttribute("prpLcertifyImgDto",
				prpLcertifyImgDto);
		httpServletRequest.setAttribute("thirdPartyList", registDto
				.getPrpLthirdPartyDtoList());
		httpServletRequest.setAttribute("prpLqualityCheckList", certifyDto
				.getPrpLqualityCheckList());
		PrpLcertifyDirectDto prpLcertifyDirectDto = new PrpLcertifyDirectDto();
		if(registDto != null){
		     if(registDto.getPrpLregistDto() != null)
		     {
		    	 String riskcode = registDto.getPrpLregistDto().getRiskCode();
		    	 if(riskcode.startsWith("32"))
		    	 {
		    		
		    		 if(certifyDto.getPrpLcertifyDirectDtoList() != null && certifyDto.getPrpLcertifyDirectDtoList().size() > 0)
		    			{
		    			    boolean upload = false;
		    			    int serialno = 0;
		    			    for(int i = 0;i < certifyDto.getPrpLcertifyDirectDtoList().size();i++)
		    			    {
		    			    	serialno ++;
		    			    	PrpLcertifyDirectDto tempDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i);
		    			    	String typecode = tempDto.getTypeCode();
		    			    	if("A008".equals(typecode))
		    			    	{
		    			    		upload = true;
		    			    		break;
		    			    	}
		    			    }
		    			    if(false == upload)
		    			    {

		    			    	 PrpLcertifyDirectDto prpLcertifyDirectDtoForTemp = new PrpLcertifyDirectDto();
					    		 prpLcertifyDirectDtoForTemp.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
					    		 prpLcertifyDirectDtoForTemp.setSerialNo(serialno + 1);
					    		 prpLcertifyDirectDtoForTemp.setRiskCode(riskcode);
					    		 prpLcertifyDirectDtoForTemp.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
					    		 prpLcertifyDirectDtoForTemp.setLossItemCode("5");
					    		 prpLcertifyDirectDtoForTemp.setTypeCode("A008");
					    		 prpLcertifyDirectDtoForTemp.setTypeName("�����ֳ���Ƭ");
					    		 prpLcertifyDirectDtoForTemp.setColumnValue("columevaue");
					    		 BLPrpLcertifyDirectFacade bLPrpLcertifyDirectFacade = new BLPrpLcertifyDirectFacade();
					    		 try
					    		 {
					    			 bLPrpLcertifyDirectFacade.insert(prpLcertifyDirectDtoForTemp);
					    		 }
					    		 catch(Exception ex)
					    		 {
					    			 
					    		 }
					
					    		 certifyDto.getPrpLcertifyDirectDtoList().add(prpLcertifyDirectDtoForTemp);
		    			    }
		    				prpLcertifyDirectDto.setCertifyDirectList(certifyDto
		    						.getPrpLcertifyDirectDtoList());
		    				httpServletRequest.setAttribute("prpLcertifyDirectDto",
									prpLcertifyDirectDto);
		    			}
		    			else
		    			{
		    				prpLcertifyDirectDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		    				prpLcertifyDirectDto.setSerialNo(1);
		    				prpLcertifyDirectDto.setRiskCode(riskcode);
		    				prpLcertifyDirectDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		    				prpLcertifyDirectDto.setLossItemCode("5");
		    				prpLcertifyDirectDto.setTypeCode("A008");
		    				prpLcertifyDirectDto.setTypeName("�����ֳ���Ƭ");
		    				prpLcertifyDirectDto.setColumnValue("columevaue");
				    		BLPrpLcertifyDirectFacade bLPrpLcertifyDirectFacade = new BLPrpLcertifyDirectFacade();
				    		try
				    		{
				    			bLPrpLcertifyDirectFacade.insert(prpLcertifyDirectDto);
				    		}
				    		catch(Exception ex)
				    		{
				    			 
				    		}
				    		ArrayList prpLcertifyDirectDtoList= new ArrayList();
				    		prpLcertifyDirectDtoList.add(prpLcertifyDirectDto);
				    		prpLcertifyDirectDto.setCertifyDirectList(prpLcertifyDirectDtoList);
		    				httpServletRequest.setAttribute("prpLcertifyDirectDto",prpLcertifyDirectDto);
				    		
		    			}
		    	 }
		    	 else
		    	 {
		    		 prpLcertifyDirectDto.setCertifyDirectList(certifyDto
								.getPrpLcertifyDirectDtoList());
						httpServletRequest.setAttribute("prpLcertifyDirectDto",
								prpLcertifyDirectDto);
		    	 }
		     }
		     else
		     {
					prpLcertifyDirectDto.setCertifyDirectList(certifyDto
							.getPrpLcertifyDirectDtoList());
					httpServletRequest.setAttribute("prpLcertifyDirectDto",
							prpLcertifyDirectDto);
		     }
		}
		else
		{
			prpLcertifyDirectDto.setCertifyDirectList(certifyDto
					.getPrpLcertifyDirectDtoList());
			httpServletRequest.setAttribute("prpLcertifyDirectDto",
					prpLcertifyDirectDto);
		}
		
		httpServletRequest.setAttribute("prpLpersonTraceList", checkDto
				.getPrpLpersonTraceDtoList()); // add by miaowenjun 20060419
		UICodeAction uiCodeAction = new UICodeAction();
		Collection imageTypeList = null;

		imageTypeList = uiCodeAction.getCodeType("ImageType", registDto
				.getPrpLregistDto().getRiskCode());

		httpServletRequest.setAttribute("imageTypeList", imageTypeList);
		Collection certiQuality = uiCodeAction.getCodeType("CertiQuality",
				prpLcertifyDirectDto.getRiskCode());
		httpServletRequest.setAttribute("qualityCheckList", certiQuality);

		// modify by lixiang start at 2005-12-17
		// reason: the certify collection flag is not correct, so check it.
		// ������Ҫ��־�����ϴ��ˡ�������Ϊ����ȫ�ģ��������Ҫ��־�ģ�����û�ϴ���������Ϊ����ȫ�ġ�
		// �������߳��ռ���־
		StringBuffer stringBuffer = new StringBuffer();
		String cltInsureCarFlag = "1";
		String cltPersonFlag = "1"; // �����ռ���־
		String cltPropFlag = "1"; // �����ռ���־
		String cltCarLossFlag = "1"; // �����ռ���־
		String cltAllLossFlag = "1"; // ȫ���ռ���־ no support
		String compelFlag = "1"; // ǿ�Ʊ����ռ���־
		// long alreadyUploadCount = 0; //upload flag
		// long requireUploadCount = 0; //reqired flag
		Collection requireList = new ArrayList();
		Collection uploadList = new ArrayList();

		// left(codecode,2)='05' ��������
		// left(codecode,2)='07' ��������
		// left(codecode,2)='08' �����ռ�
		// left(codecode,2)='12' ��������
		String imageType = "07%";

		// ��ѯ����Ҫ��־��Ϊ�յ���� Ĭ�϶�Ϊ����ȫ��
		// ��ѯ����Ҫ��־��Ϊ��Ҫ�����Ҷ��ϴ��ģ�����Ϊ����ȫ�ġ�
		// ��ѯ����Ҫ��־��Ϊ��Ҫ����û�ϴ��ģ���Ϊ����ȫ��
		String conditons = "codetype='ImageType' and codecode like '"
				+ imageType + "'"
				+ " and exists (select 0 from prpLcertifyDirect "
				+ " where registno='" + registNo + "'"
				+ " and typecode=codecode)";
		requireList = uiCodeAction.findByConditions(conditons);

		// �������ϲ���ȫ
		if (requireList == null || requireList.size() == 0) {
			// cltPersonFlag="1"; //û��������Ҫ��������Ĭ�ϳ���ȫ
		} else {
			conditons = conditons
					+ " and not exists (select 0 from prpLcertifyImg "
					+ " where businessno='" + registNo + "'"
					+ " and typecode=codecode)";
			uploadList = uiCodeAction.findByConditions(conditons);
			if (uploadList != null || uploadList.size() > 0)
				cltPersonFlag = "0";
		}

		// ��������ȫ
		imageType = "08%";
		conditons = "codetype='ImageType' and codecode like '" + imageType
				+ "'" + " and exists (select 0 from prpLcertifyDirect "
				+ " where registno='" + registNo + "'"
				+ " and typecode=codecode)";
		requireList = uiCodeAction.findByConditions(conditons);

		if (requireList == null || requireList.size() == 0) {
			// cltCarLossFlag="0";
		} else {
			conditons = conditons
					+ " and not exists (select 0 from prpLcertifyImg "
					+ " where businessno='" + registNo + "'"
					+ " and typecode=codecode)";
			uploadList = uiCodeAction.findByConditions(conditons);
			if (uploadList != null && uploadList.size() > 0)
				cltCarLossFlag = "0";
		}
		// �������ϲ���ȫ
		imageType = "12%";
		conditons = "codetype='ImageType' and codecode like '" + imageType
				+ "'" + " and exists (select 0 from prpLcertifyDirect "
				+ " where registno='" + registNo + "'"
				+ " and typecode=codecode)";
		requireList = uiCodeAction.findByConditions(conditons);

		if (requireList == null || requireList.size() == 0) {
			// cltPropFlag="0";
		} else {
			conditons = conditons
					+ " and not exists (select 0 from prpLcertifyImg "
					+ " where businessno='" + registNo + "'"
					+ " and typecode=codecode)";
			uploadList = uiCodeAction.findByConditions(conditons);
			if (uploadList != null && uploadList.size() > 0)
				cltPropFlag = "0";
		}
		imageType = "05%";
		// �����ռ���־
		String lossItemCode = "";
		String carFlag = "1";
		if (registDto.getPrpLthirdPartyDtoList() != null) {
			for (int i = 0; i < registDto.getPrpLthirdPartyDtoList().size(); i++) {
				lossItemCode = ((PrpLthirdPartyDto) registDto
						.getPrpLthirdPartyDtoList().get(i)).getSerialNo()
						+ "";
				carFlag = "1";
				conditons = "codetype='ImageType' and codecode like '"
						+ imageType + "'"
						+ " and exists (select 0 from prpLcertifyDirect "
						+ " where registno='" + registNo
						+ "' and lossitemcode='" + lossItemCode + "'"
						+ " and typecode=codecode )";
				requireList = uiCodeAction.findByConditions(conditons);

				if (requireList == null || requireList.size() == 0) {
					logger.debug("lossitemcode" + lossItemCode + ":requals 0");
					carFlag = "0";
				} else {
					conditons = conditons
							+ " and not exists (select 0 from prpLcertifyImg "
							+ " where businessno='" + registNo
							+ "' and lossitemcode='" + lossItemCode + "'"
							+ " and typecode=codecode)";
					uploadList = uiCodeAction.findByConditions(conditons);
					if (uploadList != null && uploadList.size() > 0) {
						carFlag = "0";
						logger.debug("lossitemcode" + lossItemCode
								+ ":upload >0" + conditons);

					}
				}
				// flag in car
				if (lossItemCode.equals("1") && carFlag.equals("0"))
					cltInsureCarFlag = "0";
				stringBuffer.append(carFlag);
			}
		}

		// add by miaowenjun 20060630
		List compelNeedList = (List) new BLPrpLcertifyDirectFacade()
				.findByConditions(" registno = '"
						+ registNo
						+ "'and not exists "
						+ "(select * from prplcertifyimg "
						+ "where prplcertifydirect.typecode = prplcertifyimg.typecode and prplcertifydirect.registno = prplcertifyimg.businessno)");
		if (compelNeedList != null && compelNeedList.size() > 0) {
			compelFlag = "0";
		}
		// add end by miaowenjun 20060630
		logger.debug("----�����ڵ�֤������Ϣ--stringBuffer-------"
				+ stringBuffer.toString());
		prpLcertifyCollectDto.setCltInsureCarFlag(cltInsureCarFlag); // �����ռ���־
		prpLcertifyCollectDto.setCltThirdCarFlag(stringBuffer.toString());// ʮ��������
																			// ���߳��ռ���־
		prpLcertifyCollectDto.setCompelFlag(compelFlag); // ǿ�Ʊ����ռ���־
		prpLcertifyCollectDto.setCltPersonFlag(cltPersonFlag); // �����ռ���־
		prpLcertifyCollectDto.setCltPropFlag(cltPropFlag); // �����ռ���־
		prpLcertifyCollectDto.setCltCarLossFlag(cltCarLossFlag); // �����ռ���־
		prpLcertifyCollectDto.setCltAllLossFlag(cltAllLossFlag); // ȫ���ռ���־

		if (cltPersonFlag.equals("1") && cltPropFlag.equals("1")
				&& cltCarLossFlag.equals("1") && cltAllLossFlag.equals("1")
				&& stringBuffer.indexOf("0") < 0) {
			prpLcertifyCollectDto.setCollectFlag("1"); // ȫ���ռ���־
		} else {
			prpLcertifyCollectDto.setCollectFlag("0"); // ȫ���ռ���־
		}
		//
		// modify by lixiang end at 2005-12-17

		// (1)�õ�ʵ�������б�
		logger.debug("---����֤��Ӱ���---imageTypeList---" + imageTypeList.size());
		// modify by luqin add
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("certifyDto", certifyDto);
		httpServletRequest.setAttribute("registType",
				RegistDto.BUSINESS_COMPEL_POLICY/* registDto.getRegistType() */);

		// ��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto
				.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		prpLregistExtDto
				.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		arrayListRegistExt = certifyDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

	}

	/**
	 * �����ⰸ��,������,����״̬�����ƺ��룬����ʱ���ѯ��֤��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param businessNo
	 *            �ⰸ��
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
	 */
	public void setPrpLcertifyDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		// caseNO,policyNo,claimNo
		// ��������ı����ţ���֤������SQL where �Ӿ�
		String businessNo = StringUtils.rightTrim(workFlowQueryDto
				.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		String conditions = " 1=1 ";
		logger.debug(":::1::::::::" + licenseNo);
		logger.debug(":::2:::::::"
				+ httpServletRequest.getParameter("LicenseNoSign"));
		conditions = conditions
				+ StringConvert.convertString("a.businessNo", businessNo,
						workFlowQueryDto.getRegistNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");

		conditions = conditions
				+ uiPowerInterface.addPower(userDto,"c","","ComCode");
	     //modify by zhaolu 20060816 end
		// ��ѯ������Ϣ
		UICertifyAction uiCertifyAction = new UICertifyAction();

		// �õ����е�֤������Ϣ
		Collection certifyList = new ArrayList();
		logger.debug("start to search,please waiting ...");
		certifyList = (Collection) uiCertifyAction
				.findByQueryConditions(conditions);
		logger.debug("end search,please waiting for result...");
		PrpLcertifyCollectDto prpLcertifyCollectDto = new PrpLcertifyCollectDto();
		prpLcertifyCollectDto.setCertifyCollectList(certifyList);
		logger.debug("finish add list");
		logger.debug("editType=" + httpServletRequest.getParameter("editType"));
		prpLcertifyCollectDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcertifyCollectDto",
				prpLcertifyCollectDto);
	}

	// add by zhaolu 20060803 start
	// reason:��ҳ��ѯ
	public void setPrpLcertifyDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto, int pageNo, int recordPerPage)
			throws Exception {
		// caseNO,policyNo,claimNo
		// ��������ı����ţ���֤������SQL where �Ӿ�
		String businessNo = StringUtils.rightTrim(workFlowQueryDto
				.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		String conditions = " 1=1 ";
		//���������ũ�ձ�ʶ
		conditions = conditions +" and (b.BusinessNo in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='certi') ";
		conditions = conditions +"  or b.BusinessNo in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='certi')) ";
		logger.debug(":::1::::::::" + licenseNo);
		logger.debug(":::2:::::::"
				+ httpServletRequest.getParameter("LicenseNoSign"));
		conditions = conditions
				+ StringConvert.convertString("a.businessNo", businessNo,
						workFlowQueryDto.getRegistNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			//ƴ����״̬(�������Ѵ���)����
			int newIndex = 0;
			String statusTemp = "";
			while(true){
				if((newIndex = status.trim().indexOf(",")) != -1){
					statusTemp += status.trim().substring(0,newIndex) + "','";
					status =status.trim().substring(newIndex + 1,status.trim().length());					
				}else{
					break;
				}
			}
			status = statusTemp + status;				
			conditions = conditions + "AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");

		conditions = conditions
				+ uiPowerInterface.addPower(userDto,"c","","ComCode");
	    //add by zhaolu 20060816 end

		String condition = httpServletRequest.getParameter("condition");
		if (condition != null && condition.trim().length() > 0) {
			conditions = condition;
		}

		// ��ѯ������Ϣ
		UICertifyAction uiCertifyAction = new UICertifyAction();

		// �õ����е�֤������Ϣ
		// Collection certifyList = new ArrayList();
		ArrayList certifyList = new ArrayList();
		logger.debug("start to search,please waiting ...");
		// certifyList = (Collection)
		// uiCertifyAction.findByQueryConditions(conditions);
		PageRecord pageRecord = (PageRecord) uiCertifyAction
				.findByQueryConditions(conditions, pageNo, recordPerPage);
		certifyList = (ArrayList) pageRecord.getResult();
		logger.debug("end search,please waiting for result...");
		TurnPageDto turnPageDto = new TurnPageDto();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(certifyList);
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
		// ���뷭ҳ
		PrpLcertifyCollectDto prpLcertifyCollectDto = new PrpLcertifyCollectDto();
		prpLcertifyCollectDto.setCertifyCollectList(certifyList);

		prpLcertifyCollectDto.setTurnPageDto(turnPageDto);
		httpServletRequest.setAttribute("prpLcertifyCollectDto",
				prpLcertifyCollectDto);

		logger.debug("finish add list");
		logger.debug("editType=" + httpServletRequest.getParameter("editType"));
		prpLcertifyCollectDto.setEditType(httpServletRequest
				.getParameter("editType"));

	}

	// add by zhaolu 20060803 end

	private List getCustomCertifyDirect(HttpServletRequest httpServletRequest,
			CertifyAttribute certifyAttribute) throws Exception {
		List customCertifyDirectList = new ArrayList();
		String typeCode;
		String[] prpLcertifyDirectCustomTypeName = httpServletRequest
				.getParameterValues("prpLcertifyDirectCustomTypeName");
		String[] prpLcertifyDirectCustomTypeSerialNo = httpServletRequest
				.getParameterValues("prpLcertifyDirectCustomTypeSerialNo");
		String[] prpLcertifyDirectCustomTypeCode = httpServletRequest
				.getParameterValues("prpLcertifyDirectCustomTypeCode");
		// ��������Ϊ1��int������,Ŀ����Ϊ�˽�int��Ϊ�����뷽����(�÷������ԶԴ˲��������޸�)
		int[] startIndex = new int[] { 1 };
		if (prpLcertifyDirectCustomTypeSerialNo != null) {
			for (int i = 1; i < prpLcertifyDirectCustomTypeSerialNo.length; i++) {
				if (prpLcertifyDirectCustomTypeName[i].trim().length() > 0) {
					certifyAttribute.serialNo++;
					PrpLcertifyDirectDto prpLcertifyDirectDto = new PrpLcertifyDirectDto();
					prpLcertifyDirectDto.setSerialNo(certifyAttribute
							.getSerialNo());
					prpLcertifyDirectDto.setRegistNo(certifyAttribute
							.getRegistNo());
					prpLcertifyDirectDto.setRiskCode(certifyAttribute
							.getRiskCode());
					prpLcertifyDirectDto.setPolicyNo(certifyAttribute
							.getPolicyNo());
					prpLcertifyDirectDto.setLossItemCode("0");
					if (prpLcertifyDirectCustomTypeCode[i].trim().length() == 0) {
						typeCode = getCustomCertifyTypeCode(
								prpLcertifyDirectCustomTypeCode, startIndex);
					} else {
						typeCode = prpLcertifyDirectCustomTypeCode[i];
					}
					prpLcertifyDirectDto.setTypeCode(typeCode);
					prpLcertifyDirectDto
							.setTypeName(prpLcertifyDirectCustomTypeName[i]);
					prpLcertifyDirectDto.setLossItemCode("0");
					prpLcertifyDirectDto.setColumnValue("columevaue");
					prpLcertifyDirectDto.setFlag("");
					customCertifyDirectList.add(prpLcertifyDirectDto);
				}
			}
		}
		return customCertifyDirectList;
	}

	private String getCustomCertifyTypeCode(String[] havedTypeCodeArray,
			int[] startIndex) {
		String typeCode;
		DecimalFormat df = new DecimalFormat("00");
		int index = startIndex == null ? 1 : startIndex[0];
		typeCode = null;
		for (int i = index; i < 100; i++) {
			typeCode = "99" + df.format(i);
			// �жϸ�typeCode���ѱ�����б����Ƿ����
			if (!ArrayUtils.contains(havedTypeCodeArray, typeCode)) {
				startIndex[0] = i + 1;
				return typeCode;
			}
		}
		// ��洢typeCode���ֶγ���ֻ��4λ,�Զ���ǰ��λ������"99"��ͷ;����λ�����ֱ�����ܴ洢99���Զ��嵥֤;��������AA-ZZ�Ĵ浥֤����
		// for(int i=65;i<=90;i++){
		// char firstLetter = (char)i;
		// for (int j = 65; j < 90; j++) {
		// char secondLetter = (char)j;
		// typeCode="99"+firstLetter+secondLetter;
		// //�жϸ�typeCode���ѱ�����б����Ƿ����
		// if(!ArrayUtils.contains(havedTypeCodeArray,typeCode)){
		// return typeCode;
		// }
		// }
		// }
		throw new RuntimeException("�Զ���ĵ�֤����̫����,������ϵͳ�ķ�Χ");
	}

	private static class CertifyAttribute {
		String policyNo;

		String registNo;

		String riskCode;

		int serialNo;

		public String getPolicyNo() {
			return policyNo;
		}

		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}

		public String getRegistNo() {
			return registNo;
		}

		public void setRegistNo(String registNo) {
			this.registNo = registNo;
		}

		public String getRiskCode() {
			return riskCode;
		}

		public void setRiskCode(String riskCode) {
			this.riskCode = riskCode;
		}

		public int getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(int serialNo) {
			this.serialNo = serialNo;
		}
	}
}
