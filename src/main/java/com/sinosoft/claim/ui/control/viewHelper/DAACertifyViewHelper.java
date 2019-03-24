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
 * Description:单证ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class DAACertifyViewHelper extends CertifyViewHelper {
	private static final Log logger = LogFactory.getLog(DAACertifyViewHelper.class);

	/**
	 * 保存单证时单证页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return certifyDto 单证数据传输数据结构
	 * @throws Exception
	 *             modify by qinyongli 加入非车险的数据处理
	 */
	public CertifyDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// 继承对certify,certifyText表的赋值
		CertifyDto certifyDto = super.viewToDto(httpServletRequest);
		if (certifyDto.getNodeType().equals("CertifDirect")) {
			/*---------------------索赔指引 PrpLcertifyDirect------------------------------------*/
			ArrayList prpLcertifyDirecDtotList = new ArrayList();
			CertifyAttribute certifyAttribute = new CertifyAttribute();
			// 从界面得到输入数组
			certifyAttribute.setRegistNo((String) httpServletRequest
					.getParameter("prpLcertifyCollectBusinessNo"));
			// 取得报案的其他信息
			RegistDto registDto = new UIRegistAction()
					.findByPrimaryKey(certifyAttribute.getRegistNo());
			certifyAttribute.setPolicyNo(registDto.getPrpLregistDto()
					.getPolicyNo());
			certifyAttribute.setRiskCode(registDto.getPrpLregistDto()
					.getRiskCode());

			// add by miaowenjun 20060620 判断保单是商业，强三还是关联
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
			// 处理车辆
			
			if(checkArray != null){
				for (int i = 0; i < checkArray.length; i++) {
					String cFlag = "0";
					String bFlag = "0";

					// 如果是被选择的
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
			 * 获取自定义类型
			 */
			List customCertifyDirect = getCustomCertifyDirect(
					httpServletRequest, certifyAttribute);
			prpLcertifyDirecDtotList.addAll(customCertifyDirect);

			// 立案集合中加入三者车辆
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
		// 加到ArrayList中
		certifyDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		// 整理回访问询信息结束

		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		// 从界面得到输入数组
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

		// 对象赋值
		// 人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo == null) {
		} else {
			// logger.debug("人员伤亡跟踪部分开始 ");
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
				// 加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			// 报案集合中加入损失部位
			certifyDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		logger
				.debug("------nodeType- 索赔清单的标志------"
						+ certifyDto.getNodeType());
		return certifyDto;
	}

	/**
	 * 填写单证页面及查询单证request的生成.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param certifyDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CertifyDto certifyDto) throws Exception {
	}

	/**
	 * 进入单证收集画面前取得必要的初始信息.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            业务号码
	 * @throws Exception
	 */
	public void certifyDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String uploadNodeFlag) throws Exception {
		UICertifyAction uiCertifyAction = new UICertifyAction();
		UIRegistAction uiRegistAction = new UIRegistAction();
		UICheckAction uiCheckAction = new UICheckAction(); // add by miaowenjun
															// 20060419
		// 工作流的信息
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
		// add by miaowenjun 20060620 判断保单是商业，强三还是关联
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
		// 如果已经存在单证主表(PrpLcertifyCollect)信息
		if (certifyDto != null && certifyDto.getPrpLcertifyCollectDto() != null) {
			logger.debug("----已经存在单证主表信息---------");
			prpLcertifyCollectDto = certifyDto.getPrpLcertifyCollectDto();
			// 设置状态，原来有的取原来的，没有的设置为1
			if (certifyDto.getPrpLclaimStatusDto() != null) {
				prpLcertifyCollectDto.setStatus(certifyDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				prpLcertifyCollectDto.setStatus("1");
			}
		} else {
			logger.debug("----不存在单证主表信息---------"
					+ registDto.getPrpLregistDto().getPolicyNo());
			prpLcertifyCollectDto = new PrpLcertifyCollectDto();
			prpLcertifyCollectDto.setBusinessNo(registNo);
			prpLcertifyCollectDto.setPolicyNo(registDto.getPrpLregistDto()
					.getPolicyNo());
			// 设置三者车收集标志
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < registDto.getPrpLthirdCarLossDtoList().size() + 3; i++) {
				stringBuffer.append("0");
			}
			logger.debug("----不存在单证主表信息--stringBuffer-------"
					+ stringBuffer.toString());
			prpLcertifyCollectDto.setCltThirdCarFlag(stringBuffer.toString());// 十辆车够用
			prpLcertifyCollectDto.setLossItemCode("1");
			prpLcertifyCollectDto.setLossItemName("标的名称");
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
			prpLcertifyCollectDto.setCaseFlag("0000"); // 事故类型
			prpLcertifyCollectDto.setStatus("1");
			

		}
		// 工作流的东西
		String editType = httpServletRequest.getParameter("editType");
		if (!prpLcertifyCollectDto.getStatus().equals("4") || (editType!=null && !editType.equals("SHOW"))) {
			String msg = "";

			// 校验立案是否注销拒赔
			UIClaimAction uiclaimAction = new UIClaimAction();
			Collection claimDtoList = new ArrayList();
			PrpLclaimDto prpLclaimDto = null;
			claimDtoList = uiclaimAction.findByQueryConditions(" prplclaim.registNo='"
					+ registNo + "'");

			Iterator it = claimDtoList.iterator();

			while (it.hasNext()) {
				prpLclaimDto = (PrpLclaimDto) it.next();

				if (prpLclaimDto.getCaseType().trim().equals("0"))
					msg = "该案已经注销";
				else{
					msg = "";
					break;
				}
				if (prpLclaimDto.getCaseType().trim().equals("1"))
					msg = "该案已经拒赔";
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
		String status = httpServletRequest.getParameter("status");// 从工作流上去状态
		if (status != null && !status.equals(""))
			prpLcertifyCollectDto.setStatus(status);
		// 把单证主表设置到 prpLcertifyCollectDto
		httpServletRequest.setAttribute("prpLcertifyCollectDto",
				prpLcertifyCollectDto);

		// 处理单证及影像表(PrpLcertifyImg)
		PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
		prpLcertifyImgDto.setCertifyImgList(certifyDto
				.getPrpLcertifyImgDtoList());
		if (certifyDto.getPrpLcertifyImgDtoList() != null) {
			logger.debug("---处理单证及影像表------"
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
					    		 prpLcertifyDirectDtoForTemp.setTypeName("出险现场照片");
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
		    				prpLcertifyDirectDto.setTypeName("出险现场照片");
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
		// 根据需要标志，都上传了。。就认为是齐全的，如果有需要标志的，但是没上传，就是认为不齐全的。
		// 设置三者车收集标志
		StringBuffer stringBuffer = new StringBuffer();
		String cltInsureCarFlag = "1";
		String cltPersonFlag = "1"; // 人伤收集标志
		String cltPropFlag = "1"; // 物损收集标志
		String cltCarLossFlag = "1"; // 盗抢收集标志
		String cltAllLossFlag = "1"; // 全损收集标志 no support
		String compelFlag = "1"; // 强制保险收集标志
		// long alreadyUploadCount = 0; //upload flag
		// long requireUploadCount = 0; //reqired flag
		Collection requireList = new ArrayList();
		Collection uploadList = new ArrayList();

		// left(codecode,2)='05' 车损资料
		// left(codecode,2)='07' 人伤资料
		// left(codecode,2)='08' 盗抢收集
		// left(codecode,2)='12' 物损资料
		String imageType = "07%";

		// 查询在需要标志不为空的情况 默认都为不齐全。
		// 查询在需要标志中为需要，并且都上传的，则认为是齐全的。
		// 查询在需要标志中为需要，有没上传的，认为不齐全。
		String conditons = "codetype='ImageType' and codecode like '"
				+ imageType + "'"
				+ " and exists (select 0 from prpLcertifyDirect "
				+ " where registno='" + registNo + "'"
				+ " and typecode=codecode)";
		requireList = uiCodeAction.findByConditions(conditons);

		// 人伤资料不齐全
		if (requireList == null || requireList.size() == 0) {
			// cltPersonFlag="1"; //没有设置需要，就是先默认成齐全
		} else {
			conditons = conditons
					+ " and not exists (select 0 from prpLcertifyImg "
					+ " where businessno='" + registNo + "'"
					+ " and typecode=codecode)";
			uploadList = uiCodeAction.findByConditions(conditons);
			if (uploadList != null || uploadList.size() > 0)
				cltPersonFlag = "0";
		}

		// 盗抢不齐全
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
		// 物损资料不齐全
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
		// 主车收集标志
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
		logger.debug("----不存在单证主表信息--stringBuffer-------"
				+ stringBuffer.toString());
		prpLcertifyCollectDto.setCltInsureCarFlag(cltInsureCarFlag); // 主车收集标志
		prpLcertifyCollectDto.setCltThirdCarFlag(stringBuffer.toString());// 十辆车够用
																			// 三者车收集标志
		prpLcertifyCollectDto.setCompelFlag(compelFlag); // 强制保险收集标志
		prpLcertifyCollectDto.setCltPersonFlag(cltPersonFlag); // 人伤收集标志
		prpLcertifyCollectDto.setCltPropFlag(cltPropFlag); // 物损收集标志
		prpLcertifyCollectDto.setCltCarLossFlag(cltCarLossFlag); // 盗抢收集标志
		prpLcertifyCollectDto.setCltAllLossFlag(cltAllLossFlag); // 全损收集标志

		if (cltPersonFlag.equals("1") && cltPropFlag.equals("1")
				&& cltCarLossFlag.equals("1") && cltAllLossFlag.equals("1")
				&& stringBuffer.indexOf("0") < 0) {
			prpLcertifyCollectDto.setCollectFlag("1"); // 全部收集标志
		} else {
			prpLcertifyCollectDto.setCollectFlag("0"); // 全部收集标志
		}
		//
		// modify by lixiang end at 2005-12-17

		// (1)得到实赔类型列表
		logger.debug("---处理单证及影像表---imageTypeList---" + imageTypeList.size());
		// modify by luqin add
		httpServletRequest.setAttribute("registDto", registDto);
		httpServletRequest.setAttribute("certifyDto", certifyDto);
		httpServletRequest.setAttribute("registType",
				RegistDto.BUSINESS_COMPEL_POLICY/* registDto.getRegistType() */);

		// 给报案信息补充说明多行列表准备数据
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
	 * 根据赔案号,报案号,案件状态，车牌号码，操作时间查询单证信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param businessNo
	 *            赔案号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */
	public void setPrpLcertifyDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		// caseNO,policyNo,claimNo
		// 根据输入的保单号，单证号生成SQL where 子句
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
		// 查询立案信息
		UICertifyAction uiCertifyAction = new UICertifyAction();

		// 得到多行单证主表信息
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
	// reason:分页查询
	public void setPrpLcertifyDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto, int pageNo, int recordPerPage)
			throws Exception {
		// caseNO,policyNo,claimNo
		// 根据输入的保单号，单证号生成SQL where 子句
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
		//添加区分新农险标识
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
			//拼案件状态(正处理、已处理)条件
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

		// 查询立案信息
		UICertifyAction uiCertifyAction = new UICertifyAction();

		// 得到多行单证主表信息
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
		// 查询出来的一页的结构集
		turnPageDto.setResultList(certifyList);
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
		// 加入翻页
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
		// 声明长度为1的int型数组,目的是为了将int作为对象传入方法中(该方法可以对此参数进行修改)
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
			// 判断该typeCode在已保存的列表中是否存在
			if (!ArrayUtils.contains(havedTypeCodeArray, typeCode)) {
				startIndex[0] = i + 1;
				return typeCode;
			}
		}
		// 因存储typeCode的字段长度只有4位,自定义前两位必须是"99"开头;后两位用数字保存仅能存储99个自定义单证;所以增加AA-ZZ的存单证类型
		// for(int i=65;i<=90;i++){
		// char firstLetter = (char)i;
		// for (int j = 65; j < 90; j++) {
		// char secondLetter = (char)j;
		// typeCode="99"+firstLetter+secondLetter;
		// //判断该typeCode在已保存的列表中是否存在
		// if(!ArrayUtils.contains(havedTypeCodeArray,typeCode)){
		// return typeCode;
		// }
		// }
		// }
		throw new RuntimeException("自定义的单证类型太多了,超出了系统的范围");
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
