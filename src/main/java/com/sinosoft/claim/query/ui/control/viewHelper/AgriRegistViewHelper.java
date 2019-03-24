package com.sinosoft.claim.query.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLearDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLrelatePersonDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.RegistEditPostInfo;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.reins.out.bl.facade.BLFcoRepolicyFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.ChgDate;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.utils.Utils;
import com.sinosoft.prpall.bl.facade.BLPrpCaddressFacade;



/**
 * <p>
 * Title: RegistViewHelper
 * </p>
 * <p>
 * Description:报案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2006
 * </p>
 * 
 * @author 车险理赔项目组 miaowenjun
 * @version 1.0 <br>
 *          policyListToView方法中增加出险时间
 */
public class AgriRegistViewHelper extends RegistViewHelper {
//	private static Log log = LogFactory.getLog(DAARegistViewHelper.class);

	private int RULE_LENGTH = 70; // rule字段的长度
	

	/**
	 * 默认构造方法
	 */
	public AgriRegistViewHelper() {
	}

	/**
	 * 保存报案时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return registDto 报案数据传输数据结构
	 * @throws Exception
	 */
	public RegistDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// 继承对regist,registText表的赋值
		RegistDto registDto = super.viewToDto(httpServletRequest);
		PrpLRegistRPolicyDto  prpLRegistRPolicyDto =new PrpLRegistRPolicyDto();
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		String registNo     = (String) httpServletRequest.getAttribute("registNo");
		String policyNo     = (String) httpServletRequest.getParameter("prpLregistPolicyNo");
		String prpLregistRPPolicyRiskCode     = (String) httpServletRequest.getParameter("prpLregistRiskCode");
        String scheduleType = httpServletRequest.getParameter("scheduleType");
		
		ArrayList   prpLRegistRPolicyDtoList = new  ArrayList();
		if (policyNo !=null && !policyNo.equals("")){
			prpLRegistRPolicyDto.setRegistFlag("1");
			prpLRegistRPolicyDto.setRiskCode(prpLregistRPPolicyRiskCode);
			prpLRegistRPolicyDto.setRegistNo(registNo);	
			prpLRegistRPolicyDto.setPolicyNo(policyNo);
			prpLRegistRPolicyDto.setPolicyType("1");
			prpLRegistRPolicyDto.setValidStatus("1");
			prpLRegistRPolicyDto.setOperatorCode(user.getUserCode());
			prpLRegistRPolicyDto.setRegistComCode(user.getComCode());
			if(!"".equals(httpServletRequest.getParameter("prpLregistInputDate")))
			{
				ChgDate idate = new ChgDate();
				String	currentTime = idate.getCurrentTime(" HH:mm:ss");

	            if(httpServletRequest.getParameter("prpLregistInputDate").length()<12)
	            {
	            	prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate")+currentTime,
		                DateTime.YEAR_TO_SECOND));
	            }
	            else
	            {
	            	prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
			                DateTime.YEAR_TO_SECOND));
	            }
			}
			else
			{
				prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
	                    DateTime.YEAR_TO_DAY));
			}
//			prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
//	                DateTime.YEAR_TO_DAY));
			prpLRegistRPolicyDto.setRegistValidStatus("1");
			prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto);
		}
		registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyDtoList);
		/*----------包括查勘调度，定损调度 PrpLscheduleMainWF ,PrpLscheduleItem --------------*/
		 
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
		// 通过代码对照表转换riskcode
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//modify by miaowenjun 20060922 农险(养殖)走调度
		//modified by xiatian 添加意健险和种植险，加入调度主表
		if ("H".equals(strRiskType)|| "I".equals(strRiskType)|| "Q".equals(strRiskType)|| "Z".equals(strRiskType)|| "Y".equals(strRiskType)
				|| "E".equals(strRiskType)) {
				PrpLregistDto prpLregistDto =  registDto.getPrpLregistDto();
		        prpLscheduleMainWFDto = new  PrpLscheduleMainWFDto();
		        prpLscheduleMainWFDto.setScheduleID          (1);
		        prpLscheduleMainWFDto.setRegistNo            (prpLregistDto.getRegistNo() );
		        prpLscheduleMainWFDto.setSurveyNo  (0);
		        prpLscheduleMainWFDto.setClaimComCode        (prpLregistDto.getComCode()  );
		        prpLscheduleMainWFDto.setRiskCode            (prpLregistDto.getRiskCode() );
		        prpLscheduleMainWFDto.setPolicyNo            (prpLregistDto.getPolicyNo());
		        prpLscheduleMainWFDto.setOperatorCode        ("");
		        prpLscheduleMainWFDto.setInputDate           (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
		        prpLscheduleMainWFDto.setInputHour           (DateTime.current().getHour() );
		        prpLscheduleMainWFDto.setScheduleObjectID  ("_" );
		        prpLscheduleMainWFDto.setScheduleObjectName(" ");
		        prpLscheduleMainWFDto.setScheduleType      (scheduleType);
		        prpLscheduleMainWFDto.setCheckFlag         ("0");
		        prpLscheduleMainWFDto.setScheduleFlag("0");  //查勘调度没有被派出去的
		        prpLscheduleMainWFDto.setFlag                ("");
		        prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		}
		      //加入调度主表
		registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//modify by kangzhen 20061010
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = null; 
		prpLscheduleItemDto = new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleID(1);
		prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
				.getRegistNo());
		prpLscheduleItemDto.setItemNo(-2);
		// 表示是否选中
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// 表示没有调度成定损过
		prpLscheduleItemDto.setSurveyTimes(0);
		prpLscheduleItemDto.setSurveyType("1");
		prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		prpLscheduleItemDto.setScheduleType("sched");
		prpLscheduleItemDto.setLicenseNo("财产损失");
		prpLscheduleItemDto.setScheduleObjectID("_");
		prpLscheduleItemDto.setScheduleObjectName(" ");
		prpLscheduleItemDto.setNextNodeNo("certa");

		scheduleItemDtoList.add(prpLscheduleItemDto);
		registDto.getPrpLregistDto().setScheduleItemNote(
				registDto.getPrpLregistDto().getScheduleItemNote()
						//+ prpLscheduleItemDto.getLicenseNo() + "/"
						);
		
		
		registDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
		
		// modify by wangwei add start 20050601
		// 原因：增加联系人信息
		ArrayList relatePersonList = new ArrayList();
		String[] prpSeriaNo = httpServletRequest
				.getParameterValues("prpLrelatePersonSeriaNo");
		String strPolicyNo = httpServletRequest
				.getParameter("prpLregistPolicyNo");
		String[] prpPersonName = httpServletRequest
				.getParameterValues("prpLrelatePersonPersonName");
		String[] prpPhoneNumber = httpServletRequest
				.getParameterValues("prpLrelatePersonPhoneNumber");
		String[] prpMobile = httpServletRequest
				.getParameterValues("prpLrelatePersonMobile");
		String[] prpRemark = httpServletRequest
				.getParameterValues("prpLrelatePersonRemark");

		if (prpSeriaNo != null) {
			for (int i = 1; i < prpSeriaNo.length; i++) {
				PrpLrelatePersonDto prpLrelatePersonDto = new PrpLrelatePersonDto();
				prpLrelatePersonDto.setRegistNo((String) httpServletRequest
						.getAttribute("registNo"));
				prpLrelatePersonDto
						.setSerialNo(Integer.parseInt(prpSeriaNo[i]));
				prpLrelatePersonDto.setPersonName(prpPersonName[i]);
				prpLrelatePersonDto.setPhoneNumber(prpPhoneNumber[i]);
				prpLrelatePersonDto.setMobile(prpMobile[i]);
				prpLrelatePersonDto.setRemark(prpRemark[i]);
				prpLrelatePersonDto.setPolicyNo(strPolicyNo);
				prpLrelatePersonDto.setPersonType("Link");
				prpLrelatePersonDto.setPersonCode("");
				prpLrelatePersonDto.setFlag("");

				// 加入集合中
				relatePersonList.add(prpLrelatePersonDto);
			}

			// 报案集合中联系人信息
			registDto.setPrpLrelatePersonDtoList(relatePersonList);
		}

		// modify by wangwei add end 20050601
		
		// 整理调度用的标的信息,去掉最后的一个"/"
		if (registDto.getPrpLregistDto().getScheduleItemNote().length() > 1) {
			String strTemp = registDto.getPrpLregistDto().getScheduleItemNote();
			strTemp = strTemp.substring(0, strTemp.length() - 1);
			registDto.getPrpLregistDto().setScheduleItemNote(strTemp);
		}
		
		return registDto;
	}
	/**
	 * 保存报案时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return registDto 报案数据传输数据结构
	 * @throws Exception
	 */
	public RegistDto viewToDtoNew(RegistEditPostInfo registEditPostInfo,UserDto user)
			throws Exception {
		// 继承对regist,registText表的赋值
		RegistDto registDto = super.viewToDtoNew(registEditPostInfo);
		PrpLRegistRPolicyDto  prpLRegistRPolicyDto =new PrpLRegistRPolicyDto();

		String policyNo     = registEditPostInfo.getPrpLregistPolicyNo();
		String prpLregistRPPolicyRiskCode     = registEditPostInfo.getPrpLregistRiskCode();
        String scheduleType = registEditPostInfo.getScheduleType();
		
		ArrayList   prpLRegistRPolicyDtoList = new  ArrayList();
		if (policyNo !=null && !policyNo.equals("")){
			prpLRegistRPolicyDto.setRegistFlag("1");
			prpLRegistRPolicyDto.setRiskCode(prpLregistRPPolicyRiskCode);
			prpLRegistRPolicyDto.setRegistNo(registEditPostInfo.getRegistNo());	
			prpLRegistRPolicyDto.setPolicyNo(policyNo);
			prpLRegistRPolicyDto.setPolicyType("1");
			prpLRegistRPolicyDto.setValidStatus("1");
			prpLRegistRPolicyDto.setOperatorCode(user.getUserCode());
			prpLRegistRPolicyDto.setRegistComCode(user.getComCode());
			prpLRegistRPolicyDto.setInputDate(new DateTime(registEditPostInfo.getPrpLregistInputDate(),
	                DateTime.YEAR_TO_DAY));
			prpLRegistRPolicyDto.setRegistValidStatus("1");
			prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto);
		}
		registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyDtoList);
		/*----------包括查勘调度，定损调度 PrpLscheduleMainWF ,PrpLscheduleItem --------------*/
		 
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
		// 通过代码对照表转换riskcode
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//modify by miaowenjun 20060922 农险(养殖)走调度
		//modified by xiatian 添加意健险和种植险，加入调度主表
		if ("H".equals(strRiskType)|| "I".equals(strRiskType)|| "Q".equals(strRiskType)|| "Z".equals(strRiskType)|| "Y".equals(strRiskType)
				|| "E".equals(strRiskType)) {
				PrpLregistDto prpLregistDto =  registDto.getPrpLregistDto();
		        prpLscheduleMainWFDto = new  PrpLscheduleMainWFDto();
		        prpLscheduleMainWFDto.setScheduleID          (1);
		        prpLscheduleMainWFDto.setRegistNo            (prpLregistDto.getRegistNo() );
		        prpLscheduleMainWFDto.setSurveyNo  (0);
		        prpLscheduleMainWFDto.setClaimComCode        (prpLregistDto.getComCode()  );
		        prpLscheduleMainWFDto.setRiskCode            (prpLregistDto.getRiskCode() );
		        prpLscheduleMainWFDto.setPolicyNo            (prpLregistDto.getPolicyNo());
		        prpLscheduleMainWFDto.setOperatorCode        ("");
		        prpLscheduleMainWFDto.setInputDate           (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
		        prpLscheduleMainWFDto.setInputHour           (DateTime.current().getHour() );
		        prpLscheduleMainWFDto.setScheduleObjectID  ("_" );
		        prpLscheduleMainWFDto.setScheduleObjectName(" ");
		        prpLscheduleMainWFDto.setScheduleType      (scheduleType);
		        prpLscheduleMainWFDto.setCheckFlag         ("0");
		        prpLscheduleMainWFDto.setScheduleFlag("0");  //查勘调度没有被派出去的
		        prpLscheduleMainWFDto.setFlag                ("");
		        prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		}
		      //加入调度主表
		registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//modify by kangzhen 20061010
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = null; 
		prpLscheduleItemDto = new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleID(1);
		prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
				.getRegistNo());
		prpLscheduleItemDto.setItemNo(-2);
		// 表示是否选中
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// 表示没有调度成定损过
		prpLscheduleItemDto.setSurveyTimes(0);
		prpLscheduleItemDto.setSurveyType("1");
		prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		prpLscheduleItemDto.setScheduleType("sched");
		prpLscheduleItemDto.setLicenseNo("财产损失");
		prpLscheduleItemDto.setScheduleObjectID("_");
		prpLscheduleItemDto.setScheduleObjectName(" ");
		prpLscheduleItemDto.setNextNodeNo("certa");

		scheduleItemDtoList.add(prpLscheduleItemDto);
		registDto.getPrpLregistDto().setScheduleItemNote(
				registDto.getPrpLregistDto().getScheduleItemNote()
						//+ prpLscheduleItemDto.getLicenseNo() + "/"
						);
		
		
		registDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
		
		// modify by wangwei add start 20050601
		// 原因：增加联系人信息
		ArrayList relatePersonList = new ArrayList();
		String[] prpSeriaNo = registEditPostInfo.getPrpLrelatePersonSeriaNo();
		String strPolicyNo =registEditPostInfo.getPrpLregistPolicyNo();
		String[] prpPersonName = registEditPostInfo.getPrpLrelatePersonPersonName();
		String[] prpPhoneNumber = registEditPostInfo.getPrpLrelatePersonPhoneNumber();
		String[] prpMobile = registEditPostInfo.getPrpLrelatePersonMobile();
		String[] prpRemark = registEditPostInfo.getPrpLrelatePersonRemark();
		String[] prpLrelatePersonSeriaNo = registEditPostInfo.getPrpLrelatePersonSeriaNo();
		if (prpSeriaNo != null) {
			for (int i = 0; i < prpSeriaNo.length; i++) {
				PrpLrelatePersonDto prpLrelatePersonDto = new PrpLrelatePersonDto();
				prpLrelatePersonDto.setRegistNo(registEditPostInfo.getRegistNo());
				prpLrelatePersonDto
						.setSerialNo(Integer.parseInt(prpSeriaNo[i]));
				prpLrelatePersonDto.setPersonName(prpPersonName[i]);
				prpLrelatePersonDto.setPhoneNumber(prpPhoneNumber[i]);
				prpLrelatePersonDto.setMobile(prpMobile[i]);
				prpLrelatePersonDto.setRemark(prpRemark[i]);
				prpLrelatePersonDto.setPolicyNo(strPolicyNo);
				prpLrelatePersonDto.setPersonType("Link");
				prpLrelatePersonDto.setPersonCode("");
				prpLrelatePersonDto.setFlag("");

				// 加入集合中
				relatePersonList.add(prpLrelatePersonDto);
			}

			// 报案集合中联系人信息
			registDto.setPrpLrelatePersonDtoList(relatePersonList);
		}

		// modify by wangwei add end 20050601
		
		// 整理调度用的标的信息,去掉最后的一个"/"
		if (registDto.getPrpLregistDto().getScheduleItemNote().length() > 1) {
			String strTemp = registDto.getPrpLregistDto().getScheduleItemNote();
			strTemp = strTemp.substring(0, strTemp.length() - 1);
			registDto.getPrpLregistDto().setScheduleItemNote(strTemp);
		}
		
		return registDto;
	}
	/**
	 * 取初始化信息需要的数据的整理. 填写报案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public RegistDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		RegistDto registDto = new RegistDto();
		return registDto;
	}

	/**
	 * 填写报案页面及查询报案request的生成.
	 * 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			RegistDto registDto) throws Exception {
		// 得到request的PrpLregistForm用于显示
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		// 得到request的prpLregistTextForm用于显示
		Collection prpLregistTextList = registDto.getPrpLregistTextDtoList();
	    httpServletRequest.setAttribute("prpLregistTextList",
				prpLregistTextList);
	}

	/**
	 * 填写报案页面及查询报案request的生成.
	 * 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void policyDtoToView(HttpServletRequest httpServletRequest,
			String policyNo, String damageDate, String damageHour)
			throws Exception {
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String strInsuredName = ""; // add by liuyanmei
		int insureQuantity = 0; // add by liuyanmei
		int j = 0;
	
		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		// PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		// 根据出险时间找到保单
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				damageDate, damageHour);
     	insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
	    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
			|| insureQuantity <= 1 ) {
	    	
		       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
		       
		}
		else {
			   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
		}
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
		
        /**
         * modify by mengdongdong start
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(intPayFee == -2 && policyDto.getPrpCmainDto().getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(policyDto.getPrpCmainDto());
		}
		
		//设置分期付款未缴期数
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
        /**
         * modify by mengdongdong end
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		
		// 原因：要在界面上显示一些立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		Collection prpPheadDtoList = uiEndorseAction
				.findByPrpPheadConditions(" policyNo='" + policyNo + "'");
		httpServletRequest.setAttribute("prpPheadDtoList", prpPheadDtoList);

		// 原因：要在界面上显示一些保单信息
		PrpCmainDto prpCmainDto = (PrpCmainDto) policyDto.getPrpCmainDto();
		// 保存共保、是否股东信息 、临分信息
		// add start by qingyongli 2005-7-22
		httpServletRequest
				.setAttribute("coinsFlag", prpCmainDto.getCoinsFlag());
		httpServletRequest.setAttribute("shareHolderFlag", prpCmainDto
				.getShareHolderFlag());
		String conditions = "reinsType in ('1','2')  and policyno = '"
				+ prpCmainDto.getPolicyNo() + "'";
		BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
		ArrayList reins = (ArrayList) blFcoRepolicyFacade
				.findByConditions(conditions);
		if (reins != null && reins.size() > 0) {
			httpServletRequest.setAttribute("tempReinsFlag", "1");
		} else {
			httpServletRequest.setAttribute("tempReinsFlag", "0");
		}
		DateTime.setDateDelimiter("-");
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		prpLregistDto.setPayFlag(String.valueOf(intPayFee));
		prpLregistDto.setPolicyNo(policyNo);
		prpLregistDto.setClassCode(policyDto.getPrpCmainDto().getClassCode());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		prpLregistDto.setRiskCode(riskCode);
		prpLregistDto.setReceiverCode(user.getUserCode());
		prpLregistDto.setReceiverName(user.getUserName());
		prpLregistDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
		// 设置签单日期
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setUnderWriteEndDate(policyDto.getPrpCmainDto()
				.getUnderWriteEndDate());

		// 设置默认现场为非第一现场
		prpLregistDto.setFirstSiteFlag("0");
		// 得到归属业务员
		String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
		prpLregistDto.setHandler1Code(handler1Code);
		// 设置报案操作的状态为 新案件登记 (未处理任务)
		prpLregistDto.setStatus("1");
		// 设置归属业务机构
		String comCode = policyDto.getPrpCmainDto().getComCode();
		prpLregistDto.setComCode(comCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		prpLregistDto.setStartDate(policyDto.getPrpCmainDto().getStartDate()
				.toString());
		prpLregistDto.setStartHour(policyDto.getPrpCmainDto().getStartHour());
		prpLregistDto.setEndDate(policyDto.getPrpCmainDto().getEndDate()
				.toString());
		prpLregistDto.setEndHour(policyDto.getPrpCmainDto().getEndHour()); 
		String estiCurrency = policyDto.getPrpCmainDto().getCurrency();
		prpLregistDto.setEstiCurrency(estiCurrency);
		prpLregistDto.setEstiCurrencyName(uiCodeAction.translateCurrencyCode(
				prpLregistDto.getEstiCurrency(), true));
	
		prpLregistDto.setLanguage(policyDto.getPrpCmainDto().getLanguage());
		prpLregistDto.setMakeCom(user.getComCode());
		prpLregistDto.setHandlerCode(policyDto.getPrpCmainDto()
				.getHandlerCode());
		prpLregistDto.setOperatorCode(user.getUserCode());
		prpLregistDto.setMakeComName(user.getComName());
		prpLregistDto.setOperatorName(user.getUserName());
		// modify by wangli add start 200504017
		DateTime systemFlowInTime = new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND);
		prpLregistDto.setFlowInTime(systemFlowInTime);
		// modify by wangli add start 200504017
		
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (riskCode != null && taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//设置耳标号清单列表
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//设置耳标号清单列表
			BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " ; 
			ArrayList insureMainListDtoList = new ArrayList();
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				httpServletRequest.setAttribute("ListFlag", "true" );//设置该保单是否含有清单标志
			}
			else if(insureMainListDtoList != null && insureMainListDtoList.size() > 1){
				httpServletRequest.setAttribute("ListFlag", "error" );//设置该保单是否含有清单标志
			}
			else{
				httpServletRequest.setAttribute("ListFlag", "false" );//设置该保单是否含有清单标志
			}
		}

		// modify by qinyongli add 2005－07－20 start
		// reason:获取报案出险延期天数
		UIConfigAction uiConfigAction = new UIConfigAction();
		String configValue = ""; // 获取报案出险延期天数
		configValue = uiConfigAction.getConfigValue("REPORT_DEFER_DAYS",
				prpLregistDto.getRiskCode());
		if (configValue == null || configValue.equals("")) {
			throw new UserException(1, 3, "platform", "请联系系统管理员，在平台配置系统中进行险种"
					+ prpLregistDto.getRiskCode() + "'报案出险延期天数'的初始化！");
		}
		httpServletRequest.setAttribute("configValue", configValue);
		// modify by qinyongli add 2005－07－20 end
		// 取得理赔登记机构信息
		prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
				.getInsuredCode());
		// modify by liuyanmei
		prpLregistDto.setInsuredName(strInsuredName);
		prpLregistDto.setInsuredNameShow(strInsuredName);
		prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
				.getInsuredAddress());
		prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY));
		// 初始化报案日期，出险日期
		prpLregistDto.setReportDate(new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY));
		prpLregistDto.setReportHour(String
				.valueOf(DateTime.current().getHour()));
		prpLregistDto.setReportMinute(String.valueOf(DateTime.current()
				.getMinute()));

		// 货运险出险时间缺省为启运日 2005-09-05
		prpLregistDto.setDamageStartDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
		
		prpLregistDto.setDamageStartHour(String.valueOf(DateTime.current()
				.getHour()));
		prpLregistDto.setDamageStartMinute(String.valueOf(DateTime.current()
				.getMinute()));
		prpLregistDto.setDamageEndDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLregistDto.setDamageEndHour(String.valueOf(DateTime.current()
				.getHour()));
		prpLregistDto.setLFlag("L");

		// (1)归属业务员名称的转换
		String handler1Code2 = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction.translateUserCode(handler1Code2,
				true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)归属业务机构的转换
		String comCode2 = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode2, true);
		prpLregistDto.setComName(comName);
		String agentCode = "";
		if (policyDto.getPrpCmainDto() != null) {
			agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
		}
		prpLregistDto.setAgentCode(agentCode);
		prpLregistDto.setAgentName(uiCodeAction.translateAgentName(agentCode));// 得到代理人名称
		// 默认的是否受理是Y,投其他公司的是N
		prpLregistDto.setAcceptFlag("Y");
		prpLregistDto.setRepeatInsureFlag("N");
		// 设置立案操作的状态为 案件修改 (正处理任务)
		if (policyDto.getPrpLclaimStatusDto() == null) {
			prpLregistDto.setStatus("1");
		} else {
			prpLregistDto.setStatus(policyDto.getPrpLclaimStatusDto()
					.getStatus());
		}
	
		// 计算出险次数
		getSamePolicyRegistInfo(httpServletRequest, policyNo, prpLregistDto
				.getRegistNo());


		// 设置各个列表和下拉框的选择信息的
		setSelectionList(httpServletRequest, prpLregistDto);
		// 设置各个子表中的信息
		RegistDto registDto = new RegistDto();
		registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		registDto.setPrpLregistDto(prpLregistDto);
		registDto.setPrpLscheduleMainWFDto(new PrpLscheduleMainWFDto());
		setSubInfo(httpServletRequest, registDto);
		// 设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());
		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		// add by qinyongli 2005-11-5 当修改出险时间时，刷新页面保存原来的值
		if (httpServletRequest.getParameter("modifyDamageDate") != null) {
			String reportName = httpServletRequest
					.getParameter("prpLregistReportorName");
			DateTime reportDate = new DateTime(httpServletRequest
					.getParameter("prpLregistReportDate"), DateTime.YEAR_TO_DAY);
			String reportHour = httpServletRequest
					.getParameter("prpLregistReportHour");
			String reportMinute = httpServletRequest
					.getParameter("prpLregistReportMinute");
			String reportType = httpServletRequest.getParameter("reportType");
			String registLink = httpServletRequest
					.getParameter("prpLregistLinkerName");
			String registLinkPhone = httpServletRequest
					.getParameter("prpLregistPhoneNumber");
			DateTime DamageDate = new DateTime(httpServletRequest
					.getParameter("prpLregistDamageStartDate"),
					DateTime.YEAR_TO_DAY);
			String theDamageHour = httpServletRequest
					.getParameter("prpLregistDamageStartHour");
			String theDamageMinute = httpServletRequest
					.getParameter("prpLregistDamageStartMinute");
			String prpLregistDamageAddress = httpServletRequest
					.getParameter("prpLregistDamageAddress");
			String prpLregistDamageCode = httpServletRequest
					.getParameter("prpLregistDamageCode");
			String prpLregistDamageName = httpServletRequest
					.getParameter("prpLregistDamageName");
			String prpLregistRegistNo = httpServletRequest
					.getParameter("prpLregistRegistNo");
			String prpLregistHandleUnit=httpServletRequest
			.getParameter("prpLregistHandleUnit");
			String prpLregistHandleUnitName=httpServletRequest
			.getParameter("prpLregistHandleUnitName");
			String prpLregistPersonDeathB=httpServletRequest
			.getParameter("prpLregistPersonDeathB");
			
			String prpLregistPersonInjureB=httpServletRequest
			.getParameter("prpLregistPersonInjureB");
			
			String prpLregistPersonDeathD1=httpServletRequest
			.getParameter("prpLregistPersonDeathD1");
			
			String prpLregistPersonInjureD1=httpServletRequest
			.getParameter("prpLregistPersonInjureD1");
			String prpLregistLossName=httpServletRequest
			.getParameter("prpLregistLossName");
			
			RegistDto registDtoTemp = viewToDto(httpServletRequest);
			if (registDtoTemp.getPrpLregistDto() !=null) {
				prpLregistDto.setReportorName(reportName);
				prpLregistDto.setReportorPhoneNumber(registDtoTemp.getPrpLregistDto().getReportorPhoneNumber());
				prpLregistDto.setLinkerName(registLink);
				
				prpLregistDto.setPhoneNumber (registDtoTemp.getPrpLregistDto().getPhoneNumber ());
				prpLregistDto.setLinkerPostCode( registDtoTemp.getPrpLregistDto().getLinkerPostCode());
				prpLregistDto.setLinkerAddress( registDtoTemp.getPrpLregistDto().getLinkerAddress());
			
				prpLregistDto.setDamageStartDate(DamageDate);
				prpLregistDto.setDamageStartHour(theDamageHour);
				prpLregistDto.setDamageStartMinute(theDamageMinute);
				prpLregistDto.setDamageCode(prpLregistDamageCode);
				prpLregistDto.setDamageName(prpLregistDamageName);
				prpLregistDto.setDamageAreaCode( registDtoTemp.getPrpLregistDto().getDamageAreaCode());
				prpLregistDto.setDamageAreaName( registDtoTemp.getPrpLregistDto().getDamageAreaName());
				prpLregistDto.setDamageAddress(prpLregistDamageAddress);
				prpLregistDto.setDamageAddressType( registDtoTemp.getPrpLregistDto().getDamageAddressType());
				
				prpLregistDto.setReportDate(reportDate);
				prpLregistDto.setReportHour(reportHour);
				prpLregistDto.setReportMinute(reportMinute);
				prpLregistDto.setReportType(reportType);
				prpLregistDto.setPersonDeathB( Long.parseLong( DataUtils.nullToZero(prpLregistPersonDeathB)));
				prpLregistDto.setPersonInjureB( Long.parseLong( DataUtils.nullToZero(prpLregistPersonInjureB)));
				
				prpLregistDto.setPersonDeathD1( Long.parseLong( DataUtils.nullToZero(prpLregistPersonDeathD1)));
				prpLregistDto.setPersonInjureD1( Long.parseLong( DataUtils.nullToZero(prpLregistPersonInjureD1)));
				
				
				prpLregistDto.setRegistNo(prpLregistRegistNo);
				prpLregistDto.setReportType(registDtoTemp.getPrpLregistDto().getReportType());
				prpLregistDto.setClaimType(registDtoTemp.getPrpLregistDto().getClaimType());
				prpLregistDto.setHandleUnit(prpLregistHandleUnit);
				prpLregistDto.setHandleUnitName( prpLregistHandleUnitName);
				prpLregistDto.setLossName(prpLregistLossName);
			}
			
			if (registDtoTemp.getPrpLthirdPropDtoList() !=null){
				PrpLthirdPropDto prpLthirdPropDto =new PrpLthirdPropDto();
				prpLthirdPropDto.setThirdPropList(registDtoTemp.getPrpLthirdPropDtoList() );
				httpServletRequest.setAttribute("prpLthirdPropDto",
						prpLthirdPropDto);
			}
			
			if (registDtoTemp.getPrpLregistExtDtoList()   !=null){
				PrpLregistExtDto prpLregistExtDto=new PrpLregistExtDto();
				prpLregistExtDto.setRegistExtList(registDtoTemp.getPrpLregistExtDtoList() );
				httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
			}
			
			if (registDtoTemp.getPrpLregistTextDtoList()   !=null){
				String tempContext="";
				PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
				Iterator iterator = registDtoTemp.getPrpLregistTextDtoList().iterator();
				while (iterator.hasNext()) {
					PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
							.next();
					if (prpLregistTextDtoTemp.getTextType().equals("1")) {
						tempContext = tempContext
								+ prpLregistTextDtoTemp.getContext();
					}
				}
				prpLregistTextDto.setContext(tempContext);
				prpLregistTextDto.setTextType( "1");
				
				httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
				
			}
				
		}else{
			prpLregistDto.setDamageStartDate(new DateTime());
			prpLregistDto.setDamageStartHour("00");
			prpLregistDto.setDamageStartMinute("00");
			if (SysConfig.getProperty("FamilySplittingFlag","claim") != null && SysConfig.getProperty("FamilySplittingFlag","claim").indexOf(riskCode) > -1) {
				BLPrpCitemKindFacade bLPrpCitemKindFacade = new BLPrpCitemKindFacade();
				BLPrpCaddressFacade blPrpCaddressFacade = new BLPrpCaddressFacade();
				prpLregistDto.setLossName(bLPrpCitemKindFacade.getItemDetailName("policyno='"+policyNo+"'"));
				prpLregistDto.setDamageAddress(blPrpCaddressFacade.findByPrimaryKey(policyNo, 1).getAddressName());
			}
			

		}
		// modify by qinyongli end
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLregistDto.getRiskCode(), true));
		httpServletRequest.setAttribute("prpLacciPersonDto", registDto
				.getPrpLacciPersonDto() == null ? new PrpLacciPersonDto()
				: registDto.getPrpLacciPersonDto());
		//更换耳标号表为 prplcompensateear By 李杨 20110811 Start!
//		httpServletRequest.setAttribute("prpLearDtoList", registDto.getPrpLearDtoList());
		httpServletRequest.setAttribute("prpLearDtoList", registDto.getPrpLcompensateEarDtoList());
		//更换耳标号表为 prplcompensateear By 李杨 20110811 End!
		//增加养殖险承保数量
		httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());

		
	}
	
	public void setRegistDtoView(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {
		HttpSession session = httpServletRequest.getSession();
		String policyNo = "";
		String riskCode = "";  
		//取得强制保险的险种代码
        //String compelRiskCode=BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAZ");
        	//System.out.println("RISKCODE_DAZ:"+compelRiskCode);	
        riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        //转成对应的交强险险种号
        TransCodeCI transCodeCI = new TransCodeCI();
        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode);
        
        String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		// 查询保单信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// 给registForm赋值
		DateTime.setDateDelimiter("-");
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		policyNo = prpLregistDto.getPolicyNo();
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
		
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (riskCode != null && taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
			if (registNo != null)
			{
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "regis",registNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//设置耳标号清单列表
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//设置耳标号清单列表
			BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " ; 
			ArrayList insureMainListDtoList = new ArrayList();
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				httpServletRequest.setAttribute("ListFlag", "true" );//设置该保单是否含有清单标志
			}
			else if(insureMainListDtoList != null && insureMainListDtoList.size() > 1){
				httpServletRequest.setAttribute("ListFlag", "error" );//设置该保单是否含有清单标志
			}
			else{
				httpServletRequest.setAttribute("ListFlag", "false" );//设置该保单是否含有清单标志
			}
		}
		
        /**
         * modify by mengdongdong start
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(policyNo);
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(intPayFee == -2 && cmainDto.getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(cmainDto);
		}
		
		//设置分期付款未缴期数
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
		//modify kangzhen  设置增加的联系人信息
		httpServletRequest.setAttribute("prpLrelatePersonDtoList", registDto
				.getPrpLrelatePersonDtoList());
		// 缴费标志
		prpLregistDto.setPayFlag(String.valueOf(intPayFee));
		prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto
				.getReportHour()));
		prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(
				3, 5));
		prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,
				2));
		prpLregistDto.setDamageStartHour(StringConvert
				.toStandardTime(prpLregistDto.getDamageStartHour()));
		prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour()
				.substring(3, 5));
		prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour()
				.substring(0, 2));
		if(!"05".equals(prpLregistDto.getClassCode())){
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_DAY));
		}else{
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_SECOND));
		}
		// 根据保单号查询保单信息
		if (!prpLregistDto.getPolicyNo().equals("")) {
			policyNo = prpLregistDto.getPolicyNo();
			// System.out.println("prpLregistPolicyNo="+policyNo);
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String damageDate = sf.format(prpLregistDto.getDamageStartDate());
			String damageHour = String.valueOf(prpLregistDto.getDamageStartHour());
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHour );
			registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
			prpLregistDto.setPolicyNo(policyNo);
			prpLregistDto.setHandler1Code(policyDto.getPrpCmainDto()
					.getHandler1Code());
			prpLregistDto.setStartDate(policyDto.getPrpCmainDto()
					.getStartDate().toString());
			prpLregistDto.setEndDate(policyDto.getPrpCmainDto().getEndDate()
					.toString());
			// add qinyongli 2005-7-18 增加共保字段
			httpServletRequest.setAttribute("coinsFlag", policyDto
					.getPrpCmainDto().getCoinsFlag());
			// add end
			prpLregistDto.setComCode(policyDto.getPrpCmainDto().getComCode());

			prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
					.getInsuredCode());

			String strInsuredName = "";
			
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			
			    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
				       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
				}
				else {
					   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
				}
			
			prpLregistDto.setInsuredName(strInsuredName);
			prpLregistDto.setInsuredNameShow(strInsuredName);
			prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
					.getInsuredAddress());
			prpLregistDto.setSumAmount(policyDto.getPrpCmainDto()
					.getSumAmount());
			// modify by dongcl add start 20050622
			prpLregistDto.setEstiCurrencyName(uiCodeAction
					.translateCurrencyCode(prpLregistDto.getEstiCurrency(),
							true));
			// modify by dongcl add start 20050622
         	String agentCode = "";
			if (policyDto.getPrpCmainDto() != null) {
				agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
			}
			prpLregistDto.setAgentCode(agentCode);
			prpLregistDto.setAgentName(uiCodeAction
					.translateAgentName(agentCode));// 得到代理人名称
         	// 设置报案操作的状态为 案件已提交
			if (registDto.getPrpLclaimStatusDto() != null) {
				if (registDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					registDto.getPrpLclaimStatusDto().setStatus("3");
				prpLregistDto.setStatus(registDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				// 已提交，已经处理完毕的状态
				prpLregistDto.setStatus("4");
			}
			/**如果种植险是修改报案的话,那么在下面将Status重新赋值,另外判断条件还应该增加一个标志位
			*下面对Status重新赋值的意义是,让种植险报案在提交以后修改时,页面上可以显示暂存提交按钮
			*/
			if("H".equals(riskType)){
				prpLregistDto.setStatus("2");
			}
			//根据prpLclaimStatus表中Status的值,判断修改报案时页面按钮的显示
			if(!prpLregistDto.getRegistNo().equals("")){
				UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
	            ClaimStatusDto claimStatusDto = (ClaimStatusDto) uiClaimStatusAction.findByPrimaryKey(registNo,
	                    "regis", 0);
	            httpServletRequest.setAttribute("prpLclaimStatusDto",claimStatusDto.getPrpLclaimStatusDto());
			}
			httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());
		}

		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		
		
		httpServletRequest.setAttribute("prpCmainDto", policyDto
				.getPrpCmainDto());
		PrpLextDto prpLextDto = registDto.getPrpLextDto();
		if (prpLextDto != null) {
			prpLregistDto.setCertiNo(prpLextDto.getCertiNo());
			prpLregistDto.setCertiType(prpLextDto.getCertiType());
			prpLregistDto.setPersonDeathB(prpLextDto.getPersonDeathB());
			prpLregistDto.setPersonInjureB(prpLextDto.getPersonInjureB());
			prpLregistDto.setPersonDeathD1(prpLextDto.getPersonDeathD1());
			prpLregistDto.setPersonInjureD1(prpLextDto.getPersonInjureD1());
		}

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}
		
       httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
        
		// 在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLregistDto.getRiskCode(), true));

		// 计算出险次数
		getSamePolicyRegistInfo(httpServletRequest, policyNo, registNo);

		// 原因：要在界面上显示一些立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		// 转换名称代码
		changeCodeToName(httpServletRequest, prpLregistDto);
		// 设置各个列表和下拉框的选择信息的
		setSelectionList(httpServletRequest, prpLregistDto);
		// 设置各个子表的信息
		setSubInfo(httpServletRequest, registDto);
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		// 设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());
		
		//耳标号赋值
		//把耳标号表改为表 prplcompensateear
//		ArrayList prpLearDtoList = registDto.getPrpLearDtoList();
//		httpServletRequest.setAttribute("prpLearDtoList",prpLearDtoList);
		ArrayList prpLcompensateearDtoList = registDto.getPrpLcompensateEarDtoList();
		httpServletRequest.setAttribute("prpLearDtoList",prpLcompensateearDtoList);
		
		ArrayList prplacciBenPersonDtoList = registDto.getPrplacciBenPersonDtoList();
	    PrpLacciPersonDto prpLacciBenPersonDto = new PrpLacciPersonDto();
	    prpLacciBenPersonDto.setPrpLacciBenPersonList(prplacciBenPersonDtoList);
	    httpServletRequest.setAttribute("prpLacciPersonDto",prpLacciBenPersonDto); 
	       
	    Collection prpLregistTextList = registDto.getPrpLregistTextDtoList();
		StringBuffer context = new StringBuffer();
		if( prpLregistTextList != null )
		{
			Iterator iterator = prpLregistTextList.iterator();
			while(iterator.hasNext()){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)iterator.next();
				if( "2".equals(prpLregistTextDto.getTextType()) ){
					context.append("  ");
					context.append(prpLregistTextDto.getContext());
					context.append("\t");
					
				}
			}
		}
		httpServletRequest.setAttribute("context",context.toString());
	    //add by zhaolu 20060911 end
		
		Collection prpLregistTextList3 = registDto.getPrpLregistTextDtoList3();
		httpServletRequest.setAttribute("prpLregistTextList3",prpLregistTextList3);
	}
	
	
	public boolean  checkDate(HttpServletRequest httpServletRequest,String policyNo,
			                String damageDate,int damageHour)
	throws Exception {
	 boolean  valid = false ;
	   UIPolicyAction  uiPolicyAction  = new UIPolicyAction(); 
	   PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
	   
	   PrpCmainDto  prpCmainDto =  policyDto.getPrpCmainDto();
	   
	   if (prpCmainDto==null) return false;	
	   DateTime startDate = prpCmainDto.getStartDate() ;
	   int startHour= prpCmainDto.getStartHour();
	   DateTime endDate =prpCmainDto.getEndDate();
	   int endHour=prpCmainDto.getEndHour();
	 
	 
	 if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {  //起保日期>出险日期
 	 	valid =false;  
 	}else if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //起保日期<出险日期
 		
         if (endDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {//终保日期>出险日期
         	valid =true;
 		}
         else  if (endDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //终保日期<出险日期
        	 valid =false;
 		}
         else {  ////终保日期  = 出险日期
         	if ( endHour > damageHour){
         		valid =true; 
	    		}
         	else {
         		valid =false;
         	}
         }
   	}else {  //起保日期 = 出险日期
 		if ( startHour > damageHour){
 			valid =false; 
 		}else {
 			 if (endDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {
 				 valid =true;
 		     }
	             else  if (endDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) {
	            		valid =false; 
 		     }
	             else {
	            	if ( endHour > damageHour){
	            		valid =true; 
	    			}
	               	else {
	               		valid =false;
	               	}
	             } 	
 		}
 		
 	}
		
	  return valid;	
	}
	
	/**
	 * 查询已经报案的数据，计算出现次数来进行显示
	 * 
	 * @param registDto
	 *            RegistDto
	 * @throws Exception
	 */
	public void getSamePolicyRegistInfo(HttpServletRequest httpServletRequest,
			String policyNo, String curRegistNo) throws Exception {
		UIRegistAction uiRegistAction = new UIRegistAction();
		ArrayList registList = new ArrayList();
		ArrayList registLastList = new ArrayList();
		PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
		PrpLregistDto prpLregistDtoPre = new PrpLregistDto();
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		UICodeAction uiCodeAction = new UICodeAction();
		String strOperatorCode = "";
		String strOperatorName = "";
		registList = (ArrayList) uiRegistAction.findSamePolicyRegist(policyNo);
		int intPerilCount = 0;
		int intRecentCount = 0; // 最近几天的出险次数
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null)
			rowCount = registList.size(); // 计算数据的数目

		if (curRegistNo == null)
			curRegistNo = "";
		for (rowNo = 0; rowNo < rowCount; rowNo++) {
			oldRegistNo = nowRegistNo;
			prpLregistDtoPre = prpLregistDtoTemp;
			prpLregistDtoTemp = (PrpLregistDto) registList.get(rowNo);
			nowRegistNo = prpLregistDtoTemp.getRegistNo();
			intervalDay = DateTime.intervalDay(prpLregistDtoTemp
					.getDamageStartDate(), 0, dateTime, 0);
            
			 if (intervalDay <= Integer.parseInt(priorDate)) {
				intRecentCount++;
			 }
			 
			// 如果为第一行，或者中间行，并且报案号不等于上一行的，或者小于最后一行的，
			if (rowNo == 0
					&& rowCount != 1
					|| ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo
							.equals(nowRegistNo)))) {
				if (oldRegistNo.equals(nowRegistNo)) {
					prpLregistDtoTemp.setBrandName(prpLregistDtoPre
							.getBrandName()
							+ " " + prpLregistDtoTemp.getBrandName());
				}
				// add by zhulei begin 20050901
				// 接着就continue了，这里需要补个intPerilCount记数
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 接着就continue了，这里需要补个intPerilCount记数
				continue;
			}
			// 添加上行记录

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// modify by wangli update start 20050420
			// reason:如果是第一次出险 intPerilCount就不应该再增加
			// 本次出险不计算在内
			
			if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo)
					&& (!oldRegistNo.equals(nowRegistNo))) {
				
				intPerilCount++;
				strOperatorCode = prpLregistDtoTemp.getOperatorCode();
				strOperatorName = uiCodeAction.translateUserCode(
						strOperatorCode, true);
				prpLregistDtoTemp.setOperatorName(strOperatorName);
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setSerialNo(intPerilCount);
				registLastList.add(prpLregistDtoTemp);
			} else {
				if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
					intPerilCount++;
					strOperatorCode = prpLregistDtoPre.getOperatorCode();
					strOperatorName = uiCodeAction.translateUserCode(
							strOperatorCode, true);
					prpLregistDtoPre.setOperatorName(strOperatorName);
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setSerialNo(intPerilCount);
					registLastList.add(prpLregistDtoPre);
				}
				// modify by wangli update end 20050420
			}
		}
		// 将查询出来的同个保单的数据放入PrpLregistDto的list
		prpLregistDto.setRegistList(registLastList);
		// 计算出险的次数
		prpLregistDto.setPerilCount(intPerilCount);
		prpLregistDto.setRecentCount(intRecentCount);

		httpServletRequest.setAttribute("policyNo", policyNo);
		httpServletRequest.setAttribute("curRegistNo", curRegistNo);

		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ wl 计算" + priorDate
				+ "天内出险的次数:= " + prpLregistDto.getRecentCount());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ wl 计算出险的次数:= "
				+ prpLregistDto.getPerilCount());
		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
	}

	/**
	 * 检查缴费标志 返回值 int -1为未缴费，0为未缴全，1为缴全
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param policyNo
	 *            立案号
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// 取得赔款计算书信息
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo + "'";
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions);
		return intReturn;
	}
	
	public int[] getDelinquentfeeTime(String policyNo) throws Exception{
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo + "'";
		return uiPolicyAction.getDelinquentfeeTime(conditions);
	}

	
	public String getDelinquentfeeCase(PrpCmainDto prpcmain) throws Exception{
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(prpcmain.getPayTimes()<2){
			delinquentfeeCase = "缴费计划为 "+prpcmain.getPayTimes()+" 期";
		}else{
			int[] delinquentfeeTime = getDelinquentfeeTime(prpcmain.getPolicyNo());
			for (int i = 0; i < delinquentfeeTime.length; i++) {
				if(i==0){
					delinquentfeeCase = "缴费计划为 "+prpcmain.getPayTimes()+" 期";
				}
				delinquentfeeCase += "\n";
				delinquentfeeCase += "第 "+delinquentfeeTime[i]+" 期未缴费";
			}
		}
		return delinquentfeeCase;
	}
	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @param licenseNo
	 *            车牌号码
	 * @param riskCode
	 *            险别
	 * @param insuredName
	 *            被保险人名称
	 * @throws Exception
	 */
	/**
	 * delete by miaowenjun 20060928没有发现哪里调用了，但没把握删除掉，所以先屏蔽了
	 
	public void getWorkFlowList(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo,
			String riskCode, String insuredName) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		insuredName = StringUtils.rightTrim(insuredName);
		riskCode = StringUtils.rightTrim(riskCode);
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		// prpLregistDto.setStatusName(statusName);
		// prpLregistDto.setLicenseNo(licenseNo);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);

		String conditions = " 1=1 ";
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.registNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));
		}
		if (policyNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"));
		}
		if (riskCode.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.riskCode", riskCode,
							httpServletRequest.getParameter("RiskCodeSign"));
		}
		if (insuredName.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.insuredName",
							insuredName, httpServletRequest
									.getParameter("InsuredNameSign"));
		}
		if (licenseNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.licenseNo", licenseNo,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		// 拼权限
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(),
						httpServletRequest.getParameter("taskCodeC"), "a",
						BusinessRuleUtil.getOuterCode(httpServletRequest,
								"RISKCODE_DAA"));

		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// System.out.println("DAARegistViewHelper condition
		// ######="+conditions);
		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction.getWorkFlowList(conditions);

		prpLregistDto.setRegistList(registList);
		// System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}
*/
	/**
	 * 根据PrpCheckDto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param checkDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			RegistDto registDto) throws Exception {
		
		// Modify by chenrenda add begin 20050412
		// Reason:在报案页面中加上其它损失模块
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = registDto.getPrpLthirdPropDtoList();

		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
		// Modify by chenrenda add end 20050412

		// 给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto
				.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		prpLregistExtDto
				.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		arrayListRegistExt = registDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		// 给事故经过及其事故者现状准备数据
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (registDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
						.next();
				if (prpLregistTextDtoTemp.getTextType().equals("1")) {
					tempContext = tempContext
							+ prpLregistTextDtoTemp.getContext();
				}
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("1");
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
		// 给呈报信息准备数据
		PrpLregistTextDto prpLregistText4Dto = new PrpLregistTextDto();
		tempContext = "";
		if (registDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
						.next();
				if (prpLregistTextDtoTemp.getTextType().equals("4")) {
					tempContext = tempContext
							+ prpLregistTextDtoTemp.getContext();
				}
			}
		}
		prpLregistText4Dto.setContext(tempContext);
		prpLregistText4Dto.setTextType("4");
		httpServletRequest.setAttribute("prpLregistText4Dto",
				prpLregistText4Dto);

		// modify by lixiang add 20050315 start
		// reason:加入保险标的信息的内容，界面上可以直接显示承保险别
		// 给保单投保标的准备数据
		Collection arrayPrpCitemKind = new ArrayList();
		PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
		arrayPrpCitemKind = registDto.getPrpCitemKindDtoList();
		prpCitemKindDto.setPrpCitemKindDtoList(arrayPrpCitemKind);
		httpServletRequest.setAttribute("prpCitemKindDto", prpCitemKindDto);

		// modify by lixiang add 20050315 end

		// 特别约定信息多行列表准备数据
		Collection cengageList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		cengageList = registDto.getPrpCengageDtoList();
		ArrayList cengageListTemp = new ArrayList();
		if (cengageList != null) {
			Iterator iteratorCengage = cengageList.iterator();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
						.next();
				if (prpCengageDtoTemp.getClauseCode() != null
						&& prpCengageDtoTemp.getClauseCode().length() > 0
						&& prpCengageDtoTemp.getClauseCode().charAt(0) == 'T') {
					cengageListTemp.add(prpCengageDtoTemp);
				}
			}
			boolean cFlag = false;
			cengageList = new ArrayList();
			cengageList.addAll(cengageListTemp);
			cengageListTemp = new ArrayList();
			iteratorCengage = cengageList.iterator();
			PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
						.next();
				if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
					cFlag = true;
					cengageListTemp.add(prpCengageDtoTemp1);
					prpCengageDtoTemp1 = new PrpCengageDto();
					PropertyUtils.copyProperties(prpCengageDtoTemp1,
							prpCengageDtoTemp);
				} else {
					prpCengageDtoTemp1.setContext(prpCengageDtoTemp1
							.getContext()
							+ prpCengageDtoTemp.getClauses() + "<br>");
				}
			}
			cengageListTemp.add(prpCengageDtoTemp1);
			if (cengageListTemp.size() > 0) {
				cengageListTemp.remove(0);
			}
		}
		prpCengageDto.setPrpCengageList(cengageListTemp);
		httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);
		httpServletRequest.setAttribute("prpLscheduleMainWFDto", registDto.getPrpLscheduleMainWFDto());
	}

	/**
	 * 根据PrpRegistDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)归属业务员名称的转换
		String handler1Code = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)归属业务机构的转换
		String comCode = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLregistDto.setComName(comName);

		// (3)币别名称的转换
		String estiCurrency = prpLregistDto.getEstiCurrency();
		String estiCurrencyName = uiCodeAction.translateCurrencyCode(
				estiCurrency, true);
		prpLregistDto.setEstiCurrencyName(estiCurrencyName);

		// (4)理赔登记机构的转换
		String makeComCode = prpLregistDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeComCode, true);
		prpLregistDto.setMakeComName(makeComName);

		// (5)条款名称的转换
		String clauseType = prpLregistDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLregistDto.setClauseName(clauseName);

		// (6)操作用户的转换
		String operatorCode = prpLregistDto.getOperatorCode();
		String operatorName = uiCodeAction
				.translateUserCode(operatorCode, true);
		prpLregistDto.setOperatorName(operatorName);

		// (7)处理部门的转换

		String handleUnit = prpLregistDto.getHandleUnit();
		String handleUnitName = "";
		if (handleUnit.length() > 0) {
			handleUnitName = uiCodeAction.translateCodeCode("HandleUnit",
					handleUnit, true);
			prpLregistDto.setHandleUnitName(handleUnitName);
		}
	}

	/**
	 * 获取选择框和列表框中的所有内容
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLregistDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = prpLregistDto.getRiskCode();
		// 得到报案类型列表
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				riskCode);
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		// 得到案件种类列表列表
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode", riskCode);
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		// 得到出险地址类型列表
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", riskCode);
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		// 得到得到性别
		Collection driverSex = uiCodeAction.getCodeType("SexCode", riskCode);
		httpServletRequest.setAttribute("driverSexs", driverSex);
		// 得到职业分类
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				riskCode);
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		// 得到文化程度
		Collection education = uiCodeAction.getCodeType("Education", riskCode);
		httpServletRequest.setAttribute("educations", education);
	}

	/**
	 * 查询工作流可以用来选择的节点内容,在这里有点不同，因为如果查询出来的话，立案是一定有的，
	 * 但是报案下面的定损和查勘调度，结果有两个selection,一个是包括全部的节点，另一个只有可供选择的节点list
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,
			String riskCode, String comCode) throws Exception {
		// 报案节点特殊，无法从前面得到当前的modelNo号码，必须从数据库中获得
		int modelNo = 0; // 模板号,需要根据险种，操作员部门选择
		String nodeNo = "1"; // 节点号
		int nextNodeNo = 0;

		Collection pathList = new ArrayList(); // 可以选择的所有的下一个节点
		Collection userSelectList = new ArrayList(); // 需要用户来指定的下一个节点
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		
		modelNo = workFlowViewHelper.getModelNoByRiskComCode(riskCode, comCode);
	
		if (modelNo > 0 && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo + "",
					nodeNo);
			String[] selectNodeList = new String[pathList.size()];
			for (int i = 0; i < pathList.size(); i++) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) ((ArrayList) pathList).get(i);
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
				if (!swfPathDtoTemp.getDefaultFlag().equals("3")) {
					// 判断是可供选择的节点
					userSelectList.add(swfPathDtoTemp);
				}
				selectNodeList[i] = nextNodeNo + "";
			}
			swfPathDto.setNextNodeNoList(selectNodeList);
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("userSelectList", userSelectList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}

	/**
	 * 根据报案号得到该次报案的 已决 和 未决金额
	 * 
	 * @param registNo
	 * @author wangli 20050531
	 * @return
	 */
	public CompensateFeeDto getCompensateFeeByRegistNo(String registNo)
			throws Exception {

		double sumClaim = 0d;
		double sumPaid = 0d;
		double sumNoPaid = 0d;
		CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
		UICodeAction uiCodeAction = new UICodeAction();
		UIClaimAction uiClaimAction = new UIClaimAction();
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得立案号
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);

		if (claimNo != null && claimNo.length() > 0) {
			PrpLclaimDto prpLclaimDto = new PrpLclaimDto();

			prpLclaimDto = uiClaimAction.findByPrimaryKey(claimNo)
					.getPrpLclaimDto();
			if (prpLclaimDto != null) {
				// 保险损失金额
				sumClaim = prpLclaimDto.getSumClaim();
			}
			compensateFeeDto = uiCompensateAction
					.findCompensateFeeByClaimNo(claimNo);
			// 已决金额
			sumPaid = compensateFeeDto.getSumPaid();
			// 未决金额 ＝ 保险损失金额 － 已决金额
			sumNoPaid = sumClaim - sumPaid;
		}

		compensateFeeDto.setSumPaid(sumPaid);
		compensateFeeDto.setSumNoPaid(sumNoPaid);
		compensateFeeDto.setSumClaim(sumClaim);
		compensateFeeDto.setRegistNo(registNo);

		return compensateFeeDto;
	}

	/**
	 * 不予立案处理方法
	 * 
	 * @param httpServletRequest
	 *            请求对象
	 * @throws Exception
	 * @return RegistDto
	 */
	public RegistDto getNotGrandClaim(HttpServletRequest httpServletRequest)
			throws Exception {
		PrpLregistTextDto prpLregistTextDto = null;
		String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

		// 回写CancelDate不予立案日期和DealerCode处理不予立案的操作员代码
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		prpLregistDto.setCancelDate(new DateTime(httpServletRequest
				.getParameter("prpLclaimCancelDate")));
		prpLregistDto.setDealerCode(httpServletRequest
				.getParameter("prpLclaimDealerCode"));
		registDto.setPrpLregistDto(prpLregistDto);

		/*---------------------向报案文本表prpLregistText加入不予立案文本信息------------------------------------*/
		ArrayList prpLregistTextDtoList = registDto.getPrpLregistTextDtoList();
		if (prpLregistTextDtoList == null || prpLregistTextDtoList.size() < 1) {
			prpLregistTextDtoList = new ArrayList();
		}

		String TextTemp = httpServletRequest.getParameter("prpLclaimContext");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);

		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < rules.length; k++) {
			prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto.setRegistNo((String) httpServletRequest
					.getParameter("prpLclaimRegistNo"));
			prpLregistTextDto.setContext(rules[k]);
			prpLregistTextDto.setLineNo(k + 1);
			prpLregistTextDto.setTextType("2"); // 类型2为不予立案类型保存在prplregistText表中
			prpLregistTextDtoList.add(prpLregistTextDto);
		}
		// 装入RegistDto
		registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

		return registDto;
	}
    
    
    
    /**
     * 根据报案号和保单号查询报案信息
     * @param httpServletRequest 返回给页面的request
     * @param registNo       报案号
     * @param policyNo       保单号
     * @throws Exception
     */

    public void registCancelDtoToView(HttpServletRequest httpServletRequest,String registNo) throws Exception
    {
    	
    	//初始化变量
    	String conditions = "";//查询条件语句
        String msg = ""; //错误信息 
    	boolean  isCancel = false;
    	String  strCancel = "";
    	String strConditions = "";
    	//判断报案号是否合法
        if (registNo==null||registNo.equals(""))
        {
            msg = "没有接收到合法的报案号码！";
           throw new UserException(1,3,"报案注销",msg);
        }
        
        //报案注销不提供模糊查询
        registNo = StringUtils.rightTrim(registNo) ; 
        conditions = " RegistNo='" + registNo + "' ";
        strConditions  = conditions;
        //conditions = conditions +"  And registno in (select BusinessNo from prpLclaimStatus where nodeType='regis') ";

        //拼权限     
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
        conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpba","prplregist",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
       // System.out.println("condition1111s:"+conditions);
         
        //查询报案信息
        UIRegistAction uiRegistAction = new UIRegistAction();
        
        //  判断报案号码是否存在
        if (!uiRegistAction.isExist(registNo) )
        {
        	 msg = "没有接收到合法的报案号！";
             throw new UserException(1,3,"报案注销",msg);
         }
     
        //判断是否已经立案
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        int intClaimSize = blPrpLclaimFacade.getCount(strConditions);
        
        UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
        String strSql="registNo='"+registNo+"'";
        
        List registPolicyList =(List)uiPrpLregistRPolicyAction.findByConditions(strSql);
       
        if(intClaimSize>0)
        {
       	  //需要判断是否所有的都已经立案，如果没有全部立案的话，还是可以进行报案注销的。
         if (registPolicyList.size() ==intClaimSize){	
        	
          msg = "该报案已经立案，请在立案中拒赔案件！";
          throw new UserException(1,3,"报案注销",msg);
         }
        
         }
         
         //得到多行报案主表信息
         Collection registList = new ArrayList();
         registList   = (Collection)uiRegistAction.findByConditions(conditions) ;
         
        
         PrpLregistDto prpLregistDto = new PrpLregistDto();
         PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
         
         Iterator it = registList.iterator() ;
        
         if (it.hasNext() ) {
        	 prpLregistDto = (PrpLregistDto)it.next() ;
         }else{
        	 msg = "您无权读取报案信息！";
             throw new UserException(1,3,"报案注销",msg);
         }
         
         //增加强三多保单等的判断
         RegistDto registDto =new RegistDto();
         registDto.setPrpLregistDto(prpLregistDto );
         httpServletRequest.setAttribute("registDto",registDto);
		 
         //该报案是否已拒赔
         if(!(prpLregistDto.getCancelDate()==null || prpLregistDto.getCancelDate().isEmpty()||prpLregistDto.getDealerCode()==null || prpLregistDto.getDealerCode().trim().equals("")))
         {
         	isCancel = true;
         	strCancel = "1";
         }
         //如已经注销，则取得注销原因
         //if(isCancel)
         //{
         	conditions = " RegistNo='" + registNo + "'  and texttype = '2'";
         	
         	BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
         	
         	//得到报案注销原因
            Collection registTextList = new ArrayList();
            registTextList= blPrpLregistTextFacade.findByConditions(conditions);
            String tempContext = "";
            if(registTextList != null){
              Iterator iterator = registTextList.iterator();
              while(iterator.hasNext()){
                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
                //tempContext = tempContext + StringUtils.replace(prpLregistTextDtoTemp.getContext(),"\r\n","\\r\\n")+"\\r\\n";
                String tmp = StringConvert.encode(prpLregistTextDtoTemp.getContext());
                tempContext = tempContext + StringUtils.replace(tmp,"\r\n","\\r\\n")+"\\r\\n";
              }  
            }
            prpLregistTextDto.setContext(tempContext);
            prpLregistTextDto.setTextType("2");
          
            
        //}
         httpServletRequest.setAttribute("prpLregistDto",prpLregistDto) ;
         httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
         httpServletRequest.setAttribute("strCancel", strCancel);
    }
    
    /**
     * 报案注销时数据整理
     * @param httpServletRequest
     * @return RegistDto 报案数据传输数据结构
     * @throws Exception
     */
     public RegistDto cancelViewToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       
       //初始化变量
       int RULE_LENGTH = 70; //rule字段的长度  
       RegistDto registDto = new RegistDto ();
       String msg = "";
       UIRegistAction uiRegistAction = new UIRegistAction();
       
       //取得当前用户对象
       HttpSession session = httpServletRequest.getSession();
       UserDto   user     = (UserDto)session.getAttribute("user");
       
       //得到报案号
       String strRegistNo =   StringUtils.rightTrim(httpServletRequest.getParameter("prpLclaimRegistNo"));
      
       //  判断报案号码是否存在
       if (!uiRegistAction.isExist(strRegistNo) )
       {
       	   msg = "没有接收到合法的报案号！";
           throw new UserException(1,3,"报案注销",msg);
       }
       
       //得到报案对象
       registDto = uiRegistAction.findByPrimaryKey(strRegistNo);
       
       //收集报案注销原因
      
       ArrayList prpLregistTextDtoList = new ArrayList();
       //prpLregistTextDtoList =  registDto.getPrpLregistTextDtoList();
       int intSize = prpLregistTextDtoList.size();
       //String cancelReaseon = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       
       String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       String LINECR = "\r\n";       
       String[] rules = StringUtils.split(TextTemp, LINECR);
       
   	   //String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
	    //String[] rules = StringUtils.split(cancelReaseon,RULE_LENGTH);
       //prpLregistTextDtoList 中已经包含所有其它的数据
       //得到连接串,下面将其切分到数组 
       for(int k=0;k<rules.length;k++){
         //长度校验
         if(rules[k].getBytes().length > RULE_LENGTH)
         { 
           //System.err.println("length>FIELDLENGHT: "+rules[k]);
         }
         
         PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
         prpLregistTextDto.setRegistNo(strRegistNo);
         prpLregistTextDto.setContext(rules[k]);
         prpLregistTextDto.setLineNo(k+1);
         prpLregistTextDto.setTextType("2");
         prpLregistTextDtoList.add(prpLregistTextDto);
       }       
       
       //装入RegistDto
       registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
       
       
       //设置报案信息
       PrpLregistDto prpLregistDto = registDto.getPrpLregistDto() ;

       prpLregistDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
       prpLregistDto.setDealerCode(user.getUserCode());
       
       registDto.setPrpLregistDto(prpLregistDto);
       return registDto;
   }
	
     /**
 	 * 整理调度在车辆列表中的数据显示
 	 * 
 	 * @param itemType
 	 *            String
 	 * @param itemList
 	 *            Collection
 	 * @param scheduleItemList
 	 *            Collection
 	 * @throws exception
 	 * @return Collection
 	 */
 	private Collection ScheduleItemDtoToView(Collection itemList,
 			Collection scheduleItemList) throws Exception {
 		if (scheduleItemList == null)
 			return itemList;
 		Collection itemToViewList = new ArrayList();
 		PrpLthirdPartyDto prpLthirdpartyDto = null;
 		if (itemList != null) {
 			for (int j = 0; j < itemList.size(); j++) {
 				prpLthirdpartyDto = (PrpLthirdPartyDto) ((ArrayList) itemList)
 						.get(j);
 				for (int i = 0; i < scheduleItemList.size(); i++) {
 					PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList) scheduleItemList)
 							.get(i);
 					if (prpLthirdpartyDto.getSerialNo() == prpLscheduleItemDto
 							.getItemNo()) {
 						prpLthirdpartyDto.setSelectSend(prpLscheduleItemDto
 								.getSelectSend());
 						prpLthirdpartyDto.setScheduleType(prpLscheduleItemDto
 								.getScheduleType());
 						break;
 					}
 				}
 				itemToViewList.add(prpLthirdpartyDto);
 			}
 		}
 		return itemToViewList;
 	}  
     
}
