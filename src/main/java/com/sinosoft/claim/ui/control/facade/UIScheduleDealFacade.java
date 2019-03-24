package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ������Ƚڵ���µ���Ҫ���ȵ�����
 * <p>Title: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
 * <p>Description: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0u
 */

public class UIScheduleDealFacade extends Action {

	public static String SCHEDULEADD = "ADD"; //
	public static String SCHEDULEEDIT = "EDIT"; //
	public static String SCHEDULEQUERYCHECK = "QUERYCHECK"; //

	public static String FORWARDSUCCESS = "success"; //��ת�����ɹ�
	public static String FORWARDERROR = "error"; //��ת����ʧ��
	public static String FORWARDLISTDAA = "LISTDAA"; //��ת�����ɹ���LISTDAA
	public static String FORWARDEDITDAA = "EDITDAA"; //��ת�����ɹ���EDITDAA

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		/**  �������¹���
		 * 1������¼��Ľ���չ��
		 * 2�����ύ���������б��еĵ�����Ϣ��ϸ�鿴
		 * 3���Ѳ鿱�����ѯ
		 * 4����ѯ����ȡ������
		 * 5����ѯ���ȳ�������
		 * 6����ѯ���ȵ�������Ϣ
		 **/

		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		String forward = "";

		//��ǰ
		String editType = httpServletRequest.getParameter("editType");
		try {
			//��δ����type�쳣����{}��������������쳣����{}
			//��ѯ�µ�����ʾ����Ϣ,�������룬���ڳ�ʼ������ʾ
			String registNo = "";
			String scheduleID = "";
			String surveyNo = "";
			String checkFlag0 = "";
			String checkFlag1 = "";
			String checkFlag2 = "";
			String checkFlag3 = "";
			String checkFlag4 = "";
			String checkFlag5 = "";
			String checkFlag6 = "";

			String operatorCode = "";
			String scheduleObjectID = "";
			String startDate = "";
			String endDate = "";
			String conditions = "";
			String strTemp = "";
			String licenseNo = "";
			String scheduleType = "schedule"; //���ȴ������

			String beforeHandlerCode = "";
			String handlerCode = "";
			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskCode = uiCodeAction
					.translateProductCode("RISKCODE_DAA");
			String flowID = httpServletRequest.getParameter("swfLogFlowID");
			String logNo = httpServletRequest.getParameter("swfLogLogNo");
			//add by miaowenjun 20060922 start
			String riskCode = httpServletRequest.getParameter("riskCode");
			String riskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			//add by miaowenjun 20060922 end

			//1������¼��Ľ���չ��
			//����λ��:��������Ǽ� ->�°�����ʾ�����б���ѡ��һ������->��ʾ����������Ϣ			
			if (editType.equals("ADD")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //������
				surveyNo = httpServletRequest
						.getParameter("prpLscheduleMainWFSurveyNo"); //��������

				//  ռ����ô������
				//	������ռ�ţ���Ҷ��ܿ��õ������������Ҳ����˾Ϳ���������ˡ�����
				//  ������������
				//==================================================
				//����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
				//���û��flowID��logno�򲻽����жϡ�

				String msg = "";

				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer
							.parseInt(logNo), user.getUserCode(), user
							.getUserName());

					if (swfLogDto.getHoldNode() == false) {
						msg = "����'" + registNo + "'�Ѿ�������:'"
								+ swfLogDto.getHandlerCode() + "',����:'"
								+ swfLogDto.getHandlerName()
								+ "'���û���ռ��,��ѡ�������������д���!";
						throw new UserException(1, 3, "������", msg);
					}
				}
				//modify by miaowenjun 20060922 ũ���߲�ͬ��viewhelper,���ز�ͬ��forward
				if ("D".equals(riskType) ) {
					DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
					dAAScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "success";
				} else if ("I".equals(riskType) || "H".equals(riskType)) {
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "AgriSuccess";
				} else if ("Q".equals(riskType) || "Z".equals(riskType)
						|| "Y".equals(riskType) ) {
					//�Ʋ��յ�JAVA�����ũ�յ���ʵ��
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "PropSuccess";
					//�⽡�����Լ��ĵ���ҳ�棬add by xiatian
				} else if ("E".equals(riskType) ) {
					//�Ʋ��յ�JAVA�����ũ�յ���ʵ��
					AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
					agriScheduleViewHelper.registDtoToView(httpServletRequest,
							registNo, editType);
					forward = "AcciSuccess";
				}
				//��Ӳ鿱�����Ͷ��������Ĭ��ֵ
				BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
				PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)httpServletRequest.getAttribute("prpLscheduleMainWFDto");
				if(null != prpLscheduleMainWFDto){
					String centerComCode = blPrpDcompanyFacade.getCenterCode(prpLscheduleMainWFDto.getClaimComCode());
					String centerComName = blPrpDcompanyFacade.translateCode(centerComCode, true);
					
					prpLscheduleMainWFDto.setScheduleObjectID(centerComCode);
					prpLscheduleMainWFDto.setScheduleObjectName(centerComName);
					
					PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto)httpServletRequest.getAttribute("prpLscheduleItemDto");
					Collection scheduleItemList = prpLscheduleItemDto.getScheduleItemList();
					for(Iterator scheduleItemItr = scheduleItemList.iterator();scheduleItemItr.hasNext();){
						PrpLscheduleItemDto prpLscheduleItem = (PrpLscheduleItemDto)scheduleItemItr.next();
						prpLscheduleItem.setScheduleObjectID(centerComCode);
						prpLscheduleItem.setScheduleObjectName(centerComName);
					}
				} 
			}
			//2�����ύ���������б��еĵ�����Ϣ��ϸ�鿴
			//����λ��:���ύ�������� ->�����б���ѡ��һ������->��ʾ������ĵ���������Ϣ
			if (editType.equals("EDIT")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //������
				scheduleID = httpServletRequest
						.getParameter("prpLscheduleMainWFScheduleID"); //���Ⱥ�
				//modify by miaowenjun 20060928 ũ�����Լ���viewhelper
				AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				if ("I".equals(riskType) || "H".equals(riskType)) {
					agriScheduleViewHelper.scheduleDtoToView(
							httpServletRequest, registNo, editType, scheduleID);
					forward = "EDITAgri";
				} else if ("Q".equals(riskType)|| "Y".equals(riskType)||"Z".equals(riskType)|| "E".equals(riskType)) {
					agriScheduleViewHelper.scheduleDtoToView(
							httpServletRequest, registNo, editType, scheduleID);
					forward = "EDITProp";
					//add by xiatian ����⽡�յ���
				}else if ("E".equals(riskType)) {
						agriScheduleViewHelper.scheduleDtoToView(
								httpServletRequest, registNo, editType, scheduleID);
						forward = "EDITAcci";
				} else {
					dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
							registNo, editType, scheduleID);
					forward = "EDITDAA";
				}
			}

			//3���Ѳ鿱�����ѯ
			//����λ��:��������->�鿱���������ѯ  ->�����ѯ�������°�ť->��ʾ��ѯ���
			if (editType.equals("QUERYCHECK")
					|| editType.equals("QUERYCERTAINLOSS")) {
				registNo = httpServletRequest.getParameter("registNo");
				beforeHandlerCode = httpServletRequest
						.getParameter("handlerCode");
				handlerCode = httpServletRequest.getParameter("NhandlerCode");
				checkFlag0 = httpServletRequest.getParameter("checkFlag0");
				checkFlag2 = httpServletRequest.getParameter("checkFlag2");
				checkFlag4 = httpServletRequest.getParameter("checkFlag4");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				licenseNo = httpServletRequest.getParameter("licenseNo");

				conditions = "";

				if (registNo != null && registNo.trim().length() > 0) {
					conditions = conditions + " (keyin like '" + registNo
							+ "%') AND ";

				}
				if (beforeHandlerCode != null
						&& beforeHandlerCode.trim().length() > 0) {
					conditions = conditions + " (beforeHandlerCode="
							+ beforeHandlerCode + ") AND ";
				}

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " (flowIntime>='" + startDate
							+ "') AND ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " (flowIntime<='"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1).toString() + "') AND ";
				}
				if (checkFlag0 != null || checkFlag2 != null
						|| checkFlag4 != null) {
					if (checkFlag0 != null)
						strTemp = strTemp + "'0',";
					if (checkFlag2 != null)
						strTemp = strTemp + "'2',";
					if (checkFlag4 != null)
						strTemp = strTemp + "'4',";
					//ȥ������һ��","
					strTemp = strTemp.substring(0, strTemp.length() - 1);
					conditions = conditions + " (nodeStatus in(" + strTemp
							+ ")) AND ";
				}
				if (licenseNo != null && licenseNo.trim().length() > 0) {
					conditions = conditions + " (lossItemCode like '%"
							+ licenseNo + "%') AND ";
				}

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				String nodeType = "";
				if (editType.equals("QUERYCHECK")) {
					nodeType = "check";
					conditions = conditions + " nodeType='check'";
				} else {
					conditions = conditions + " nodeType='certa'";
					nodeType = "certa";
				}

				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),com.sinosoft.claim.util.BusinessRuleUtil.transTaskCode(httpServletRequest.getParameter("nodeType")),"swflog",strRiskCode);
				conditions = conditions
						+ uiPowerInterface.addPower(userDto, "swflog", "",
								"ComCode");
				conditions = conditions + " order by flowintime";

				//�ӷ�ҳȡ����
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}
				System.out.println();
				System.out.println("conditions=" + conditions);
				System.out.println();
				dAAScheduleViewHelper.getNextTaskList(httpServletRequest,
						conditions, nodeType);

				forward = "LISTDAA";
			}

			//5����ѯ���ȳ�������
			//����λ��:��������->�Ѳ鿱�����ѯ ->�����ѯ�������°�ť->��ʾ��ѯ���
			if (editType.equals("CANCELQUERY")) {
				conditions = "1=1";
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.getScheuleCheckList(httpServletRequest,
						conditions, scheduleType);
				forward = "CANCELLISTDAA";

			}

			//6����ѯ���ȵ�������Ϣ
			//����λ��:��������->�Ѳ鿱�����ѯ ->�����ѯ�������°�ť->��ʾ��ѯ���

			if (editType.equals("QUERY")) {
				registNo = httpServletRequest.getParameter("registNo");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				checkFlag0 = httpServletRequest.getParameter("checkFlag0");
				checkFlag4 = httpServletRequest.getParameter("checkFlag4");
				checkFlag2 = httpServletRequest.getParameter("checkFlag2");
				operatorCode = httpServletRequest.getParameter("handlerCode");
				licenseNo = httpServletRequest.getParameter("licenseNo");
				scheduleObjectID = httpServletRequest
						.getParameter("scheduleObjectID");
				scheduleType = httpServletRequest.getParameter("scheduleType");
				conditions = " 1=1 ";
				//���������ũ�ձ�ʶ
				conditions = conditions + " and (registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='sched') ";
				conditions = conditions + " or registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='sched')) ";
				conditions = conditions
						+ StringConvert
								.convertString("registNo", registNo,
										httpServletRequest
												.getParameter("registNoSign"));
				conditions = conditions
						+ StringConvert.convertString("operatorCode",
								operatorCode, "=");
				conditions = conditions
						+ StringConvert.convertString("scheduleObjectID",
								scheduleObjectID, "=");
				String strTemp1 = "";
				String tableName = "";
				if (scheduleType.equals("schel")) {
					conditions = conditions
							+ StringConvert
									.convertString(
											"licenseNo",
											httpServletRequest
													.getParameter("prpLscheduleItemLicenseNo"),
											httpServletRequest
													.getParameter("prpLscheduleItemLicenseNoSign"));
				}
				if (checkFlag0 != null || checkFlag4 != null) {
					if (checkFlag0 != null) {
						strTemp = strTemp + "'0',";
						strTemp1 = strTemp1 + "'0',";
					}

					if (checkFlag4 != null) {
						strTemp = strTemp + "'4',";
						strTemp1 = strTemp1 + "'1',";

					}
					//ȥ������һ��","
					strTemp = strTemp.substring(0, strTemp.length() - 1);
					strTemp1 = strTemp1.substring(0, strTemp1.length() - 1);

					if (scheduleType.equals("schel")) {

						conditions = conditions + " AND (surveyTimes in("
								+ strTemp1 + "))";
					} else {
						conditions = conditions + " AND (checkFlag in("
								+ strTemp + "))";
					}
				}

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " AND (inputdate>=to_date('"
							+ startDate + "','YYYY-MM-DD')) ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " AND (inputdate<=to_date('"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1).toString() + "','YYYY-MM-DD')) ";
				}

				if (scheduleType.equals("schel")) {

					//tableName="prplscheduleitem";
					tableName = "swflog";
				} else {
					// 	tableName="prplschedulemainwf";
					tableName = "swflog"; //modify by kangzhen
				}
				//           20060807  conditions =conditions+ " and claimComCode='"+user.getScheduleComCode() +"'";

				//��session��ȡ��ƶ/�󻧱�־
		          String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
		          if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
		        	  if(strHPflag.equals("Large")) {
		        		  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
		        	  }
		              if(strHPflag.equals("Retaol")) {
		            	  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
		        	  }
		          }
		          
				//conditions += " AND exists(select 0 from prplregist a,swflog where DealerCode is null and a.registNo="+tableName+".registno)";
				conditions += " AND exists(select 0 from prplregist a,swflog where (DealerCode is null or DealerCode='') and a.registNo="
						+ tableName + ".registno";//modify by kangzhen
				conditions = conditions
						+ StringConvert.convertString("InsuredName",
								httpServletRequest.getParameter("InsuredName"),
								httpServletRequest
										.getParameter("InsuredNameSign"));

				UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions =conditions+ uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","prplregist",strRiskCode)+") " ;
				conditions = conditions
						+ uiPowerInterface.addPower(userDto, tableName, "",
								"ComCode");

				//conditions =conditions +" order by inputdate desc";
				conditions = conditions + ") order by inputdate desc";//modify by kangzhen
				//System.out.println(conditions);
				//�ӷ�ҳȡ����
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.getScheuleCheckList(httpServletRequest,
						conditions, scheduleType);
				forward = "COMMONLISTDAA" + scheduleType;

			}

			//7����ʾ������Ϣ��ϸ�鿴 ֻ����

			if (editType.equals("SHOW")) {
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //������
				scheduleID = httpServletRequest
						.getParameter("prpLscheduleMainWFScheduleID"); //���Ⱥ�

				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
						registNo, editType, scheduleID);
				forward = "SHOWDAA";
				if ("I".equals(riskType) || "H".equals(riskType)) {
					forward = "SHOWAgri";
				}else if("Q".equals(riskType)|| "Y".equals(riskType)||"Z".equals(riskType)){
					forward = "SHOWProp";
					//add by xiatian �޸��⽡����ʾ·��
				}else if("E".equals(riskType))
					forward = "SHOWAcci";
			}

			//8��������Ϣȡ����ϸ��ʾ
			//����λ��:����ȡ������ ->�����б���ѡ��һ������->��ʾ������ĵ���������Ϣ
			if (editType.equals("GETBACKEDIT")) {
				scheduleType = httpServletRequest.getParameter("scheduleType");
				registNo = httpServletRequest
						.getParameter("prpLscheduleMainWFRegistNo"); //������
				scheduleID = "1"; //���Ⱥ�
				DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
				dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,
						registNo, editType, scheduleID);
				forward = "EDITDAA" + scheduleType;
			}

			//modify by wangli add start 20050412

			//9. ����������ȵ�������Ϣ
			//����λ��:��������->����������� ->�����ѯ�������°�ť->��ʾ��ѯ���

			if (editType.equals("ADDQUERY")) {
				//˵��:�ܹ�ȡ�ص���������ǻ�û�б��鿱������ĵ�������
				registNo = httpServletRequest.getParameter("registNo");
				startDate = httpServletRequest.getParameter("startDate");
				endDate = httpServletRequest.getParameter("endDate");
				conditions = " NodeType = 'sched' ";
				conditions = conditions
						+ StringConvert
								.convertString("keyin", registNo,
										httpServletRequest
												.getParameter("registNoSign"));
				conditions = conditions
						+ StringConvert
								.convertString(
										"LossItemName",
										httpServletRequest
												.getParameter("prpLscheduleItemLicenseNo"),
										httpServletRequest
												.getParameter("prpLscheduleItemLicenseNoSign"));
				conditions = conditions
						+ StringConvert.convertString("InsuredName",
								httpServletRequest.getParameter("InsuredName"),
								httpServletRequest
										.getParameter("InsuredNameSign"));

				if (startDate != null && startDate.trim().length() > 0) {
					conditions = conditions + " AND (FlowInTime>='" + startDate
							+ "') ";
				}
				if (endDate != null && endDate.trim().length() > 0) {
					conditions = conditions
							+ " AND (FlowInTime<='"
							+ new DateTime(endDate, DateTime.YEAR_TO_DAY)
									.addDay(1) + "') ";
				}
				System.out.println();

				//��ѯ�����е�
				//UIPowerInterface uiPowerInterface = new UIPowerInterface();
				UserDto userDto = (UserDto) httpServletRequest.getSession()
						.getAttribute("user");
				//conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpdd","swflog",strRiskCode);
				//          20060807     conditions =conditions+ " and handledept='"+user.getScheduleComCode() +"'";           

				//�ӷ�ҳȡ����
				String condition = httpServletRequest.getParameter("condition");
				if (condition != null && condition.trim().length() > 0) {
					conditions = condition;
				}

				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				workFlowViewHelper.getScheduleAddCertainLossSwfLogList(
						httpServletRequest, conditions);
				forward = "ADDLISTDAA";

			}
			//modify by wangli add start 20050412

			saveToken(httpServletRequest);
		}

		catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.scheduleBeforeEdit.querySchedule");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = FORWARDERROR;

		}

		catch (Exception e) {
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.scheduleBeforeEdit.querySchedule");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = FORWARDERROR;

		} finally {

		}
		return actionMapping.findForward(forward);

	}

}
