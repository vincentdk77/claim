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
 * Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п����Ƽ��ɷ����޹�˾(c) 2006
 * </p>
 * 
 * @author ����������Ŀ�� miaowenjun
 * @version 1.0 <br>
 *          policyListToView���������ӳ���ʱ��
 */
public class AgriRegistViewHelper extends RegistViewHelper {
//	private static Log log = LogFactory.getLog(DAARegistViewHelper.class);

	private int RULE_LENGTH = 70; // rule�ֶεĳ���
	

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public AgriRegistViewHelper() {
	}

	/**
	 * ���汨��ʱ����ҳ����������. �������ü̳еķ�ʽ�ֲ㴦�������������������ݷ�����������������������
	 * 
	 * @param httpServletRequest
	 * @return registDto �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public RegistDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// �̳ж�regist,registText���ĸ�ֵ
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
		/*----------�����鿱���ȣ�������� PrpLscheduleMainWF ,PrpLscheduleItem --------------*/
		 
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
		// ͨ��������ձ�ת��riskcode
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//modify by miaowenjun 20060922 ũ��(��ֳ)�ߵ���
		//modified by xiatian �����⽡�պ���ֲ�գ������������
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
		        prpLscheduleMainWFDto.setScheduleFlag("0");  //�鿱����û�б��ɳ�ȥ��
		        prpLscheduleMainWFDto.setFlag                ("");
		        prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		}
		      //�����������
		registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//modify by kangzhen 20061010
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = null; 
		prpLscheduleItemDto = new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleID(1);
		prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
				.getRegistNo());
		prpLscheduleItemDto.setItemNo(-2);
		// ��ʾ�Ƿ�ѡ��
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// ��ʾû�е��ȳɶ����
		prpLscheduleItemDto.setSurveyTimes(0);
		prpLscheduleItemDto.setSurveyType("1");
		prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		prpLscheduleItemDto.setScheduleType("sched");
		prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
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
		// ԭ��������ϵ����Ϣ
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

				// ���뼯����
				relatePersonList.add(prpLrelatePersonDto);
			}

			// ������������ϵ����Ϣ
			registDto.setPrpLrelatePersonDtoList(relatePersonList);
		}

		// modify by wangwei add end 20050601
		
		// ���������õı����Ϣ,ȥ������һ��"/"
		if (registDto.getPrpLregistDto().getScheduleItemNote().length() > 1) {
			String strTemp = registDto.getPrpLregistDto().getScheduleItemNote();
			strTemp = strTemp.substring(0, strTemp.length() - 1);
			registDto.getPrpLregistDto().setScheduleItemNote(strTemp);
		}
		
		return registDto;
	}
	/**
	 * ���汨��ʱ����ҳ����������. �������ü̳еķ�ʽ�ֲ㴦�������������������ݷ�����������������������
	 * 
	 * @param httpServletRequest
	 * @return registDto �������ݴ������ݽṹ
	 * @throws Exception
	 */
	public RegistDto viewToDtoNew(RegistEditPostInfo registEditPostInfo,UserDto user)
			throws Exception {
		// �̳ж�regist,registText���ĸ�ֵ
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
		/*----------�����鿱���ȣ�������� PrpLscheduleMainWF ,PrpLscheduleItem --------------*/
		 
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
		// ͨ��������ձ�ת��riskcode
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//modify by miaowenjun 20060922 ũ��(��ֳ)�ߵ���
		//modified by xiatian �����⽡�պ���ֲ�գ������������
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
		        prpLscheduleMainWFDto.setScheduleFlag("0");  //�鿱����û�б��ɳ�ȥ��
		        prpLscheduleMainWFDto.setFlag                ("");
		        prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		}
		      //�����������
		registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//modify by kangzhen 20061010
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = null; 
		prpLscheduleItemDto = new PrpLscheduleItemDto();
		prpLscheduleItemDto.setScheduleID(1);
		prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
				.getRegistNo());
		prpLscheduleItemDto.setItemNo(-2);
		// ��ʾ�Ƿ�ѡ��
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// ��ʾû�е��ȳɶ����
		prpLscheduleItemDto.setSurveyTimes(0);
		prpLscheduleItemDto.setSurveyType("1");
		prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY));
		prpLscheduleItemDto.setScheduleType("sched");
		prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
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
		// ԭ��������ϵ����Ϣ
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

				// ���뼯����
				relatePersonList.add(prpLrelatePersonDto);
			}

			// ������������ϵ����Ϣ
			registDto.setPrpLrelatePersonDtoList(relatePersonList);
		}

		// modify by wangwei add end 20050601
		
		// ���������õı����Ϣ,ȥ������һ��"/"
		if (registDto.getPrpLregistDto().getScheduleItemNote().length() > 1) {
			String strTemp = registDto.getPrpLregistDto().getScheduleItemNote();
			strTemp = strTemp.substring(0, strTemp.length() - 1);
			registDto.getPrpLregistDto().setScheduleItemNote(strTemp);
		}
		
		return registDto;
	}
	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��д������ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� �������ü̳еķ�ʽ�ֲ㴦����������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public RegistDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		RegistDto registDto = new RegistDto();
		return registDto;
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * �������ü̳еķ�ʽ�ֲ㴦�������������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			RegistDto registDto) throws Exception {
		// �õ�request��PrpLregistForm������ʾ
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();

		// ���ÿͻ�����
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		// �õ�request��prpLregistTextForm������ʾ
		Collection prpLregistTextList = registDto.getPrpLregistTextDtoList();
	    httpServletRequest.setAttribute("prpLregistTextList",
				prpLregistTextList);
	}

	/**
	 * ��д����ҳ�漰��ѯ����request������.
	 * ��д����ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * �������ü̳еķ�ʽ�ֲ㴦�������������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
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
	
		// ��ѯ������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		// PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		// ���ݳ���ʱ���ҵ�����
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				damageDate, damageHour);
     	insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
	    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
			|| insureQuantity <= 1 ) {
	    	
		       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
		       
		}
		else {
			   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";	
		}
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
		
        /**
         * modify by mengdongdong start
         * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
         * 2006-1-19
         */
		//Ƿ�����
		String delinquentfeeCase = "";
		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
		if(intPayFee == -2 && policyDto.getPrpCmainDto().getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(policyDto.getPrpCmainDto());
		}
		
		//���÷��ڸ���δ������
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
        /**
         * modify by mengdongdong end
         * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
         * 2006-1-19
         */
		
		// ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		Collection prpPheadDtoList = uiEndorseAction
				.findByPrpPheadConditions(" policyNo='" + policyNo + "'");
		httpServletRequest.setAttribute("prpPheadDtoList", prpPheadDtoList);

		// ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		PrpCmainDto prpCmainDto = (PrpCmainDto) policyDto.getPrpCmainDto();
		// ���湲�����Ƿ�ɶ���Ϣ ���ٷ���Ϣ
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
		// ����ǩ������
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setUnderWriteEndDate(policyDto.getPrpCmainDto()
				.getUnderWriteEndDate());

		// ����Ĭ���ֳ�Ϊ�ǵ�һ�ֳ�
		prpLregistDto.setFirstSiteFlag("0");
		// �õ�����ҵ��Ա
		String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
		prpLregistDto.setHandler1Code(handler1Code);
		// ���ñ���������״̬Ϊ �°����Ǽ� (δ��������)
		prpLregistDto.setStatus("1");
		// ���ù���ҵ�����
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
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//���ö�����嵥�б�
			BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " ; 
			ArrayList insureMainListDtoList = new ArrayList();
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				httpServletRequest.setAttribute("ListFlag", "true" );//���øñ����Ƿ����嵥��־
			}
			else if(insureMainListDtoList != null && insureMainListDtoList.size() > 1){
				httpServletRequest.setAttribute("ListFlag", "error" );//���øñ����Ƿ����嵥��־
			}
			else{
				httpServletRequest.setAttribute("ListFlag", "false" );//���øñ����Ƿ����嵥��־
			}
		}

		// modify by qinyongli add 2005��07��20 start
		// reason:��ȡ����������������
		UIConfigAction uiConfigAction = new UIConfigAction();
		String configValue = ""; // ��ȡ����������������
		configValue = uiConfigAction.getConfigValue("REPORT_DEFER_DAYS",
				prpLregistDto.getRiskCode());
		if (configValue == null || configValue.equals("")) {
			throw new UserException(1, 3, "platform", "����ϵϵͳ����Ա����ƽ̨����ϵͳ�н�������"
					+ prpLregistDto.getRiskCode() + "'����������������'�ĳ�ʼ����");
		}
		httpServletRequest.setAttribute("configValue", configValue);
		// modify by qinyongli add 2005��07��20 end
		// ȡ������Ǽǻ�����Ϣ
		prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
				.getInsuredCode());
		// modify by liuyanmei
		prpLregistDto.setInsuredName(strInsuredName);
		prpLregistDto.setInsuredNameShow(strInsuredName);
		prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
				.getInsuredAddress());
		prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY));
		// ��ʼ���������ڣ���������
		prpLregistDto.setReportDate(new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY));
		prpLregistDto.setReportHour(String
				.valueOf(DateTime.current().getHour()));
		prpLregistDto.setReportMinute(String.valueOf(DateTime.current()
				.getMinute()));

		// �����ճ���ʱ��ȱʡΪ������ 2005-09-05
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

		// (1)����ҵ��Ա���Ƶ�ת��
		String handler1Code2 = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction.translateUserCode(handler1Code2,
				true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)����ҵ�������ת��
		String comCode2 = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode2, true);
		prpLregistDto.setComName(comName);
		String agentCode = "";
		if (policyDto.getPrpCmainDto() != null) {
			agentCode = policyDto.getPrpCmainDto().getAgentCode(); // �����˴���
		}
		prpLregistDto.setAgentCode(agentCode);
		prpLregistDto.setAgentName(uiCodeAction.translateAgentName(agentCode));// �õ�����������
		// Ĭ�ϵ��Ƿ�������Y,Ͷ������˾����N
		prpLregistDto.setAcceptFlag("Y");
		prpLregistDto.setRepeatInsureFlag("N");
		// ��������������״̬Ϊ �����޸� (����������)
		if (policyDto.getPrpLclaimStatusDto() == null) {
			prpLregistDto.setStatus("1");
		} else {
			prpLregistDto.setStatus(policyDto.getPrpLclaimStatusDto()
					.getStatus());
		}
	
		// ������մ���
		getSamePolicyRegistInfo(httpServletRequest, policyNo, prpLregistDto
				.getRegistNo());


		// ���ø����б����������ѡ����Ϣ��
		setSelectionList(httpServletRequest, prpLregistDto);
		// ���ø����ӱ��е���Ϣ
		RegistDto registDto = new RegistDto();
		registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		registDto.setPrpLregistDto(prpLregistDto);
		registDto.setPrpLscheduleMainWFDto(new PrpLscheduleMainWFDto());
		setSubInfo(httpServletRequest, registDto);
		// ���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());
		// ���ÿͻ�����
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		// add by qinyongli 2005-11-5 ���޸ĳ���ʱ��ʱ��ˢ��ҳ�汣��ԭ����ֵ
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
		//��������ű�Ϊ prplcompensateear By ���� 20110811 Start!
//		httpServletRequest.setAttribute("prpLearDtoList", registDto.getPrpLearDtoList());
		httpServletRequest.setAttribute("prpLearDtoList", registDto.getPrpLcompensateEarDtoList());
		//��������ű�Ϊ prplcompensateear By ���� 20110811 End!
		//������ֳ�ճб�����
		httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());

		
	}
	
	public void setRegistDtoView(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {
		HttpSession session = httpServletRequest.getSession();
		String policyNo = "";
		String riskCode = "";  
		//ȡ��ǿ�Ʊ��յ����ִ���
        //String compelRiskCode=BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAZ");
        	//System.out.println("RISKCODE_DAZ:"+compelRiskCode);	
        riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
        //ת�ɶ�Ӧ�Ľ�ǿ�����ֺ�
        TransCodeCI transCodeCI = new TransCodeCI();
        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode);
        
        String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		// ��ѯ������Ϣ
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// ��registForm��ֵ
		DateTime.setDateDelimiter("-");
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		policyNo = prpLregistDto.getPolicyNo();
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
		
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (riskCode != null && taskCode.indexOf(riskCode) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//�����嵥�б�
			if (registNo != null)
			{
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "regis",registNo);
			}
			httpServletRequest.setAttribute("prplCompensateEarDtoList", prplCompensateEarDtoList);//���ö�����嵥�б�
			httpServletRequest.setAttribute("familySplittingFlag", "true" );//���ö�����嵥�б�
			BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
			String insuremainlistConditions = "policyno = '" + policyNo + "' and VALIDITY in ('2','3') " ; 
			ArrayList insureMainListDtoList = new ArrayList();
			insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
			if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
				httpServletRequest.setAttribute("ListFlag", "true" );//���øñ����Ƿ����嵥��־
			}
			else if(insureMainListDtoList != null && insureMainListDtoList.size() > 1){
				httpServletRequest.setAttribute("ListFlag", "error" );//���øñ����Ƿ����嵥��־
			}
			else{
				httpServletRequest.setAttribute("ListFlag", "false" );//���øñ����Ƿ����嵥��־
			}
		}
		
        /**
         * modify by mengdongdong start
         * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
         * 2006-1-19
         */
		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(policyNo);
		//Ƿ�����
		String delinquentfeeCase = "";
		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
		if(intPayFee == -2 && cmainDto.getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(cmainDto);
		}
		
		//���÷��ڸ���δ������
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
		//modify kangzhen  �������ӵ���ϵ����Ϣ
		httpServletRequest.setAttribute("prpLrelatePersonDtoList", registDto
				.getPrpLrelatePersonDtoList());
		// �ɷѱ�־
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
		// ���ݱ����Ų�ѯ������Ϣ
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
			// add qinyongli 2005-7-18 ���ӹ����ֶ�
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
					   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"��"+insureQuantity+"��";	
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
				agentCode = policyDto.getPrpCmainDto().getAgentCode(); // �����˴���
			}
			prpLregistDto.setAgentCode(agentCode);
			prpLregistDto.setAgentName(uiCodeAction
					.translateAgentName(agentCode));// �õ�����������
         	// ���ñ���������״̬Ϊ �������ύ
			if (registDto.getPrpLclaimStatusDto() != null) {
				if (registDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					registDto.getPrpLclaimStatusDto().setStatus("3");
				prpLregistDto.setStatus(registDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				// ���ύ���Ѿ�������ϵ�״̬
				prpLregistDto.setStatus("4");
			}
			/**�����ֲ�����޸ı����Ļ�,��ô�����潫Status���¸�ֵ,�����ж�������Ӧ������һ����־λ
			*�����Status���¸�ֵ��������,����ֲ�ձ������ύ�Ժ��޸�ʱ,ҳ���Ͽ�����ʾ�ݴ��ύ��ť
			*/
			if("H".equals(riskType)){
				prpLregistDto.setStatus("2");
			}
			//����prpLclaimStatus����Status��ֵ,�ж��޸ı���ʱҳ�水ť����ʾ
			if(!prpLregistDto.getRegistNo().equals("")){
				UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
	            ClaimStatusDto claimStatusDto = (ClaimStatusDto) uiClaimStatusAction.findByPrimaryKey(registNo,
	                    "regis", 0);
	            httpServletRequest.setAttribute("prpLclaimStatusDto",claimStatusDto.getPrpLclaimStatusDto());
			}
			httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());
		}

		// ��ѯ������Ϣ
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

		// ���ÿͻ�����
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}
		
       httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
        
		// �ڽ�������ʾ�������� 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLregistDto.getRiskCode(), true));

		// ������մ���
		getSamePolicyRegistInfo(httpServletRequest, policyNo, registNo);

		// ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		// ת�����ƴ���
		changeCodeToName(httpServletRequest, prpLregistDto);
		// ���ø����б����������ѡ����Ϣ��
		setSelectionList(httpServletRequest, prpLregistDto);
		// ���ø����ӱ�����Ϣ
		setSubInfo(httpServletRequest, registDto);
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		// ���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());
		
		//����Ÿ�ֵ
		//�Ѷ���ű���Ϊ�� prplcompensateear
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
	 
	 
	 if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {  //������>��������
 	 	valid =false;  
 	}else if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //������<��������
 		
         if (endDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {//�ձ�����>��������
         	valid =true;
 		}
         else  if (endDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //�ձ�����<��������
        	 valid =false;
 		}
         else {  ////�ձ�����  = ��������
         	if ( endHour > damageHour){
         		valid =true; 
	    		}
         	else {
         		valid =false;
         	}
         }
   	}else {  //������ = ��������
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
	 * ��ѯ�Ѿ����������ݣ�������ִ�����������ʾ
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
		int intRecentCount = 0; // �������ĳ��մ���
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		// ת��������Ա�����ƣ��Լ��������,ȥ�����ڳ��ղ�λ���������
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null)
			rowCount = registList.size(); // �������ݵ���Ŀ

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
			 
			// ���Ϊ��һ�У������м��У����ұ����Ų�������һ�еģ�����С�����һ�еģ�
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
				// ���ž�continue�ˣ�������Ҫ����intPerilCount����
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 ���ž�continue�ˣ�������Ҫ����intPerilCount����
				continue;
			}
			// �������м�¼

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// modify by wangli update start 20050420
			// reason:����ǵ�һ�γ��� intPerilCount�Ͳ�Ӧ��������
			// ���γ��ղ���������
			
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
		// ����ѯ������ͬ�����������ݷ���PrpLregistDto��list
		prpLregistDto.setRegistList(registLastList);
		// ������յĴ���
		prpLregistDto.setPerilCount(intPerilCount);
		prpLregistDto.setRecentCount(intRecentCount);

		httpServletRequest.setAttribute("policyNo", policyNo);
		httpServletRequest.setAttribute("curRegistNo", curRegistNo);

		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ wl ����" + priorDate
				+ "���ڳ��յĴ���:= " + prpLregistDto.getRecentCount());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$ wl ������յĴ���:= "
				+ prpLregistDto.getPerilCount());
		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
	}

	/**
	 * ���ɷѱ�־ ����ֵ int -1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param policyNo
	 *            ������
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// ȡ������������Ϣ
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
		//Ƿ�����
		String delinquentfeeCase = "";
		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
		if(prpcmain.getPayTimes()<2){
			delinquentfeeCase = "�ɷѼƻ�Ϊ "+prpcmain.getPayTimes()+" ��";
		}else{
			int[] delinquentfeeTime = getDelinquentfeeTime(prpcmain.getPolicyNo());
			for (int i = 0; i < delinquentfeeTime.length; i++) {
				if(i==0){
					delinquentfeeCase = "�ɷѼƻ�Ϊ "+prpcmain.getPayTimes()+" ��";
				}
				delinquentfeeCase += "\n";
				delinquentfeeCase += "�� "+delinquentfeeTime[i]+" ��δ�ɷ�";
			}
		}
		return delinquentfeeCase;
	}
	/**
	 * ���ݱ����źͱ�����,���ƺţ�����ʱ�䣬����״̬��ѯ������Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param registNo
	 *            ������
	 * @param policyNo
	 *            ������
	 * @param licenseNo
	 *            ���ƺ���
	 * @param riskCode
	 *            �ձ�
	 * @param insuredName
	 *            ������������
	 * @throws Exception
	 */
	/**
	 * delete by miaowenjun 20060928û�з�����������ˣ���û����ɾ������������������
	 
	public void getWorkFlowList(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo,
			String riskCode, String insuredName) throws Exception {
		// ��������ı����ţ�����������SQL where �Ӿ�
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
		// ƴȨ��
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(),
						httpServletRequest.getParameter("taskCodeC"), "a",
						BusinessRuleUtil.getOuterCode(httpServletRequest,
								"RISKCODE_DAA"));

		// ��ѯ������Ϣ
		UIRegistAction uiRegistAction = new UIRegistAction();

		// System.out.println("DAARegistViewHelper condition
		// ######="+conditions);
		// �õ����б���������Ϣ
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction.getWorkFlowList(conditions);

		prpLregistDto.setRegistList(registList);
		// System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}
*/
	/**
	 * ����PrpCheckDto�еĸ��ӱ��ڵ���Ϣ������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param checkDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			RegistDto registDto) throws Exception {
		
		// Modify by chenrenda add begin 20050412
		// Reason:�ڱ���ҳ���м���������ʧģ��
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = registDto.getPrpLthirdPropDtoList();

		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
		// Modify by chenrenda add end 20050412

		// ��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto
				.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		prpLregistExtDto
				.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		arrayListRegistExt = registDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		// ���¹ʾ��������¹�����״׼������
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
		// ���ʱ���Ϣ׼������
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
		// reason:���뱣�ձ����Ϣ�����ݣ������Ͽ���ֱ����ʾ�б��ձ�
		// ������Ͷ�����׼������
		Collection arrayPrpCitemKind = new ArrayList();
		PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
		arrayPrpCitemKind = registDto.getPrpCitemKindDtoList();
		prpCitemKindDto.setPrpCitemKindDtoList(arrayPrpCitemKind);
		httpServletRequest.setAttribute("prpCitemKindDto", prpCitemKindDto);

		// modify by lixiang add 20050315 end

		// �ر�Լ����Ϣ�����б�׼������
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
	 * ����PrpRegistDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLcheckDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)����ҵ��Ա���Ƶ�ת��
		String handler1Code = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)����ҵ�������ת��
		String comCode = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLregistDto.setComName(comName);

		// (3)�ұ����Ƶ�ת��
		String estiCurrency = prpLregistDto.getEstiCurrency();
		String estiCurrencyName = uiCodeAction.translateCurrencyCode(
				estiCurrency, true);
		prpLregistDto.setEstiCurrencyName(estiCurrencyName);

		// (4)����Ǽǻ�����ת��
		String makeComCode = prpLregistDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeComCode, true);
		prpLregistDto.setMakeComName(makeComName);

		// (5)�������Ƶ�ת��
		String clauseType = prpLregistDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLregistDto.setClauseName(clauseName);

		// (6)�����û���ת��
		String operatorCode = prpLregistDto.getOperatorCode();
		String operatorName = uiCodeAction
				.translateUserCode(operatorCode, true);
		prpLregistDto.setOperatorName(operatorName);

		// (7)�������ŵ�ת��

		String handleUnit = prpLregistDto.getHandleUnit();
		String handleUnitName = "";
		if (handleUnit.length() > 0) {
			handleUnitName = uiCodeAction.translateCodeCode("HandleUnit",
					handleUnit, true);
			prpLregistDto.setHandleUnitName(handleUnitName);
		}
	}

	/**
	 * ��ȡѡ�����б����е���������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLregistDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = prpLregistDto.getRiskCode();
		// �õ����������б�
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				riskCode);
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		// �õ����������б��б�
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode", riskCode);
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		// �õ����յ�ַ�����б�
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", riskCode);
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		// �õ��õ��Ա�
		Collection driverSex = uiCodeAction.getCodeType("SexCode", riskCode);
		httpServletRequest.setAttribute("driverSexs", driverSex);
		// �õ�ְҵ����
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				riskCode);
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		// �õ��Ļ��̶�
		Collection education = uiCodeAction.getCodeType("Education", riskCode);
		httpServletRequest.setAttribute("educations", education);
	}

	/**
	 * ��ѯ��������������ѡ��Ľڵ�����,�������е㲻ͬ����Ϊ�����ѯ�����Ļ���������һ���еģ�
	 * ���Ǳ�������Ķ���Ͳ鿱���ȣ����������selection,һ���ǰ���ȫ���Ľڵ㣬��һ��ֻ�пɹ�ѡ��Ľڵ�list
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,
			String riskCode, String comCode) throws Exception {
		// �����ڵ����⣬�޷���ǰ��õ���ǰ��modelNo���룬��������ݿ��л��
		int modelNo = 0; // ģ���,��Ҫ�������֣�����Ա����ѡ��
		String nodeNo = "1"; // �ڵ��
		int nextNodeNo = 0;

		Collection pathList = new ArrayList(); // ����ѡ������е���һ���ڵ�
		Collection userSelectList = new ArrayList(); // ��Ҫ�û���ָ������һ���ڵ�
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
					// �ж��ǿɹ�ѡ��Ľڵ�
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
	 * ���ݱ����ŵõ��ôα����� �Ѿ� �� δ�����
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

		// ��������
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);

		if (claimNo != null && claimNo.length() > 0) {
			PrpLclaimDto prpLclaimDto = new PrpLclaimDto();

			prpLclaimDto = uiClaimAction.findByPrimaryKey(claimNo)
					.getPrpLclaimDto();
			if (prpLclaimDto != null) {
				// ������ʧ���
				sumClaim = prpLclaimDto.getSumClaim();
			}
			compensateFeeDto = uiCompensateAction
					.findCompensateFeeByClaimNo(claimNo);
			// �Ѿ����
			sumPaid = compensateFeeDto.getSumPaid();
			// δ����� �� ������ʧ��� �� �Ѿ����
			sumNoPaid = sumClaim - sumPaid;
		}

		compensateFeeDto.setSumPaid(sumPaid);
		compensateFeeDto.setSumNoPaid(sumNoPaid);
		compensateFeeDto.setSumClaim(sumClaim);
		compensateFeeDto.setRegistNo(registNo);

		return compensateFeeDto;
	}

	/**
	 * ����������������
	 * 
	 * @param httpServletRequest
	 *            �������
	 * @throws Exception
	 * @return RegistDto
	 */
	public RegistDto getNotGrandClaim(HttpServletRequest httpServletRequest)
			throws Exception {
		PrpLregistTextDto prpLregistTextDto = null;
		String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

		// ��дCancelDate�����������ں�DealerCode�������������Ĳ���Ա����
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		prpLregistDto.setCancelDate(new DateTime(httpServletRequest
				.getParameter("prpLclaimCancelDate")));
		prpLregistDto.setDealerCode(httpServletRequest
				.getParameter("prpLclaimDealerCode"));
		registDto.setPrpLregistDto(prpLregistDto);

		/*---------------------�򱨰��ı���prpLregistText���벻�������ı���Ϣ------------------------------------*/
		ArrayList prpLregistTextDtoList = registDto.getPrpLregistTextDtoList();
		if (prpLregistTextDtoList == null || prpLregistTextDtoList.size() < 1) {
			prpLregistTextDtoList = new ArrayList();
		}

		String TextTemp = httpServletRequest.getParameter("prpLclaimContext");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);

		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto.setRegistNo((String) httpServletRequest
					.getParameter("prpLclaimRegistNo"));
			prpLregistTextDto.setContext(rules[k]);
			prpLregistTextDto.setLineNo(k + 1);
			prpLregistTextDto.setTextType("2"); // ����2Ϊ�����������ͱ�����prplregistText����
			prpLregistTextDtoList.add(prpLregistTextDto);
		}
		// װ��RegistDto
		registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

		return registDto;
	}
    
    
    
    /**
     * ���ݱ����źͱ����Ų�ѯ������Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo       ������
     * @param policyNo       ������
     * @throws Exception
     */

    public void registCancelDtoToView(HttpServletRequest httpServletRequest,String registNo) throws Exception
    {
    	
    	//��ʼ������
    	String conditions = "";//��ѯ�������
        String msg = ""; //������Ϣ 
    	boolean  isCancel = false;
    	String  strCancel = "";
    	String strConditions = "";
    	//�жϱ������Ƿ�Ϸ�
        if (registNo==null||registNo.equals(""))
        {
            msg = "û�н��յ��Ϸ��ı������룡";
           throw new UserException(1,3,"����ע��",msg);
        }
        
        //����ע�����ṩģ����ѯ
        registNo = StringUtils.rightTrim(registNo) ; 
        conditions = " RegistNo='" + registNo + "' ";
        strConditions  = conditions;
        //conditions = conditions +"  And registno in (select BusinessNo from prpLclaimStatus where nodeType='regis') ";

        //ƴȨ��     
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
        conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpba","prplregist",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
       // System.out.println("condition1111s:"+conditions);
         
        //��ѯ������Ϣ
        UIRegistAction uiRegistAction = new UIRegistAction();
        
        //  �жϱ��������Ƿ����
        if (!uiRegistAction.isExist(registNo) )
        {
        	 msg = "û�н��յ��Ϸ��ı����ţ�";
             throw new UserException(1,3,"����ע��",msg);
         }
     
        //�ж��Ƿ��Ѿ�����
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        int intClaimSize = blPrpLclaimFacade.getCount(strConditions);
        
        UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
        String strSql="registNo='"+registNo+"'";
        
        List registPolicyList =(List)uiPrpLregistRPolicyAction.findByConditions(strSql);
       
        if(intClaimSize>0)
        {
       	  //��Ҫ�ж��Ƿ����еĶ��Ѿ����������û��ȫ�������Ļ������ǿ��Խ��б���ע���ġ�
         if (registPolicyList.size() ==intClaimSize){	
        	
          msg = "�ñ����Ѿ����������������о��ⰸ����";
          throw new UserException(1,3,"����ע��",msg);
         }
        
         }
         
         //�õ����б���������Ϣ
         Collection registList = new ArrayList();
         registList   = (Collection)uiRegistAction.findByConditions(conditions) ;
         
        
         PrpLregistDto prpLregistDto = new PrpLregistDto();
         PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
         
         Iterator it = registList.iterator() ;
        
         if (it.hasNext() ) {
        	 prpLregistDto = (PrpLregistDto)it.next() ;
         }else{
        	 msg = "����Ȩ��ȡ������Ϣ��";
             throw new UserException(1,3,"����ע��",msg);
         }
         
         //����ǿ���ౣ���ȵ��ж�
         RegistDto registDto =new RegistDto();
         registDto.setPrpLregistDto(prpLregistDto );
         httpServletRequest.setAttribute("registDto",registDto);
		 
         //�ñ����Ƿ��Ѿ���
         if(!(prpLregistDto.getCancelDate()==null || prpLregistDto.getCancelDate().isEmpty()||prpLregistDto.getDealerCode()==null || prpLregistDto.getDealerCode().trim().equals("")))
         {
         	isCancel = true;
         	strCancel = "1";
         }
         //���Ѿ�ע������ȡ��ע��ԭ��
         //if(isCancel)
         //{
         	conditions = " RegistNo='" + registNo + "'  and texttype = '2'";
         	
         	BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
         	
         	//�õ�����ע��ԭ��
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
     * ����ע��ʱ��������
     * @param httpServletRequest
     * @return RegistDto �������ݴ������ݽṹ
     * @throws Exception
     */
     public RegistDto cancelViewToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       
       //��ʼ������
       int RULE_LENGTH = 70; //rule�ֶεĳ���  
       RegistDto registDto = new RegistDto ();
       String msg = "";
       UIRegistAction uiRegistAction = new UIRegistAction();
       
       //ȡ�õ�ǰ�û�����
       HttpSession session = httpServletRequest.getSession();
       UserDto   user     = (UserDto)session.getAttribute("user");
       
       //�õ�������
       String strRegistNo =   StringUtils.rightTrim(httpServletRequest.getParameter("prpLclaimRegistNo"));
      
       //  �жϱ��������Ƿ����
       if (!uiRegistAction.isExist(strRegistNo) )
       {
       	   msg = "û�н��յ��Ϸ��ı����ţ�";
           throw new UserException(1,3,"����ע��",msg);
       }
       
       //�õ���������
       registDto = uiRegistAction.findByPrimaryKey(strRegistNo);
       
       //�ռ�����ע��ԭ��
      
       ArrayList prpLregistTextDtoList = new ArrayList();
       //prpLregistTextDtoList =  registDto.getPrpLregistTextDtoList();
       int intSize = prpLregistTextDtoList.size();
       //String cancelReaseon = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       
       String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       String LINECR = "\r\n";       
       String[] rules = StringUtils.split(TextTemp, LINECR);
       
   	   //String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
	    //String[] rules = StringUtils.split(cancelReaseon,RULE_LENGTH);
       //prpLregistTextDtoList ���Ѿ�������������������
       //�õ����Ӵ�,���潫���зֵ����� 
       for(int k=0;k<rules.length;k++){
         //����У��
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
       
       //װ��RegistDto
       registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
       
       
       //���ñ�����Ϣ
       PrpLregistDto prpLregistDto = registDto.getPrpLregistDto() ;

       prpLregistDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
       prpLregistDto.setDealerCode(user.getUserCode());
       
       registDto.setPrpLregistDto(prpLregistDto);
       return registDto;
   }
	
     /**
 	 * ���������ڳ����б��е�������ʾ
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