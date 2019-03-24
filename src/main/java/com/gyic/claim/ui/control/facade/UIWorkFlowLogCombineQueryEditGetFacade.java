package com.gyic.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLPrplcombineSwfLogFacade;
import com.gyic.claim.dto.custom.ClaimCombineDto;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.DateCompute;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET ������״̬��ѯ
 * <p>Title: �������⹤������ѯ��Ϣ</p>
 * <p>Description: �������⹤������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowLogCombineQueryEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
	//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String nodeType     = httpServletRequest.getParameter("nodeType");
    String caseFlag     = httpServletRequest.getParameter("caseFlag");
    String status      = httpServletRequest.getParameter("status");     //������
    HttpSession session = httpServletRequest.getSession();
    String editType= httpServletRequest.getParameter("editType");
    String funcName=httpServletRequest.getParameter("FuncName"); //ֻ����ע��/���������ʱ��������õ�
    String isFirst		= httpServletRequest.getParameter("isFirst"); //�Ƿ��һ�ν�������һ�ν�������ѯ���
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();
    String forward  = "";  
    String comLevel ="" ; 
    try
    { 
    	//��һ�ν�������־Ϊ�յģ����Զ�����г�ʼ�����ڶ��ν�����ȡ����ҳ���ֵ�����Բ�Ϊ�գ����ô���
    	if(isFirst == null || "".equals(isFirst)){
    		isFirst = "Y";
    	}
    	httpServletRequest.setAttribute("isFirst", isFirst);
    	//�����Ƿ����ܹ�˾-----------------------------
    	if (nodeType.equals("verip")){
    		comLevel = user.getComLevel();
        	httpServletRequest.setAttribute("comLevel",comLevel);
    	}
    	//----------------------------
    	//��ѯ������״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
		//��Ҫ���з�ҳ����
		//ÿҳ��ʾ������
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
        if(editType!=null&&editType.trim().equals("specialQuery")){
        	//�����ⰸ��ѯ
          getSwfLogList(httpServletRequest,caseFlag,userCode,nodeType);
          return actionMapping.findForward("specialQuery");
        } else if(editType!=null&&editType.trim().equals("welcome")){//��ҳ���б�����ʱ��
          getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,"10000");
          return actionMapping.findForward("success");
        }  else {
          getWorkFlowLogList(httpServletRequest,nodeType,status,"",pageNo,recordPerPage);
        }
        forward = "success";

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
    //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage","usee.getErrorMessage()") ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
    return actionMapping.findForward(forward);
  }
	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ(��ҳ)
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
	public void getWorkFlowLogList(HttpServletRequest httpServletRequest,
			String nodeType, String status, String alertMessage, String pageNo,
			String recordPerPage) throws Exception {
		// ��ѯ����ڵ�״̬��Ϣ
		BLPrplcombineSwfLogFacade blPrplcombineSwfLogFacade = new BLPrplcombineSwfLogFacade();
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// �õ����б���������Ϣ
		Collection claimCombineDtoList = new ArrayList();
		Collection claimCombineDtoListTemp = new ArrayList();
		//
		if (pageNo == null || pageNo.trim().equals(""))
			pageNo = "1";
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		int intPageNo = Integer.parseInt(pageNo);
		TurnPageDto turnPageDto = new TurnPageDto();// ��ҳ����
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		String conditions = null;
		if (nodeType == null || nodeType.trim().length() < 1) {
			conditions = getNodeTaskListConditions(httpServletRequest, status,
					user.getUserCode());
		} else {
			conditions = getNodeTaskListConditionsByNodeType(
					httpServletRequest, nodeType, status, user.getUserCode());
		}
		String condition = httpServletRequest.getParameter("condition");
		String searchFlag = httpServletRequest.getParameter("searchFlag");

		if (searchFlag == null || searchFlag.trim().equals("true")) {

		} else {
			if (condition != null && condition.trim().length() > 0) {
				conditions = condition;
			}
		}
		PageRecord pageRecord = (PageRecord) blPrplcombineSwfLogFacade.findByConditions(conditions, intPageNo, intRecordPerPage);
		Collection claimCombineDtoListtemp1 = null;
		claimCombineDtoListtemp1 = (ArrayList) pageRecord.getResult();

		String dfFlag = "N";

		for (Iterator it = claimCombineDtoListtemp1.iterator(); it.hasNext();) {
			ClaimCombineDto ClaimCombineDtotemp = (ClaimCombineDto)it.next();
			
//			�����ⲿ�ֲ��������ã���ע�͵�   GYIC ���� start 20110803
//			
//			PageRecord pageRecord2 = (PageRecord) blPrplcombineSwfLogFacade
//					.findByConditions("  flowid='"
//							+ swflogtemp.getFlowID() + "'", intPageNo,
//							intRecordPerPage);
//			swfLogDtolist = (ArrayList) pageRecord2.getResult();
//			�����ⲿ�ֲ��������ã���ע�͵�   GYIC ���� end 20110803
			/*
			 * ��Ԫ��Ŀ�� �������ѭ����鿱�б��е����Ҵ�����İ����Ƿ������˵渶.���������Ӱ������
			 * ��Ϊ��Ԫ�ĲƲ���Ҳ���߶����.�����������ε� for (Iterator iter =
			 * swfLogDtolist.iterator(); iter.hasNext();) { SwfLogDto element =
			 * (SwfLogDto) iter.next(); if ("8".equals(element.getTypeFlag())){
			 * //��ʾ�ð��������˵渶 dfFlag="Y"; swflogtemp.setDfFlag(dfFlag); break; }
			 *  }
			 */
			claimCombineDtoList.add(ClaimCombineDtotemp);
		}

		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList((ArrayList) pageRecord.getResult());
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

		UICodeAction uiCodeAction = new UICodeAction();
		// ���nodeType=����/����Ļ�������Ҫת������/�������������
		if (nodeType != null) {
			if (nodeType.equals("certa") || nodeType.equals("verif")
					|| nodeType.equals("sched")) {
				if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
					for (int i = 0; i < claimCombineDtoList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						ClaimCombineDto claimCombineTemp = (ClaimCombineDto) (((ArrayList) claimCombineDtoList)
								.get(i));
						swfLogTemp = claimCombineTemp.getSwfLogDto();
						if (nodeType.equals("sched")) {
							// ����Ⱥ�ʱ��
							if (swfLogTemp.getNodeStatus().equals("0"))
								swfLogTemp
										.setStopTimeDesc(DateCompute
												.betweenDate(
														swfLogTemp
																.getFlowInTime(),
														new DateTime(
																DateTime
																		.current(),
																DateTime.YEAR_TO_SECOND)
																.toString()));
							if (swfLogTemp.getNodeStatus().equals("2"))
								swfLogTemp
										.setStopTimeDesc(DateCompute
												.betweenDate(
														swfLogTemp
																.getHandleTime(),
														new DateTime(
																DateTime
																		.current(),
																DateTime.YEAR_TO_SECOND)
																.toString()));
							int index = swfLogTemp.getStopTimeDesc().indexOf(
									"��");
							if (index != -1)
								swfLogTemp.setStopTimeDesc(swfLogTemp
										.getStopTimeDesc().substring(0, index));
						} else {
							if (swfLogTemp.getTypeFlag().equals("1")) {
								swfLogTemp.setTypeFlagName("1-������");
							} else if (swfLogTemp.getTypeFlag().equals("2")) {
								swfLogTemp.setTypeFlagName("2-��Ա����");
							} else if (swfLogTemp.getTypeFlag().equals("3")) {
								swfLogTemp.setTypeFlagName("3-�Ʋ�����");
							} else if (swfLogTemp.getTypeFlag().equals("4")) {
								swfLogTemp.setTypeFlagName("4-ȫ��/�ƶ�ȫ��");
							} else {
								swfLogTemp.setTypeFlagName("");
							}
						}
						claimCombineTemp.setSwfLogDto(swfLogTemp);
						claimCombineDtoListTemp.add(claimCombineTemp);
					}
					claimCombineDtoList = claimCombineDtoListTemp;
				}
			} else if (nodeType.equals("compe") && status.equals("0")) { // ���ڴ��������:�������δ���ͨ���ļ����飬�Ͳ��������ɼ����顣
				if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
					for (int i = 0; i < claimCombineDtoList.size(); i++) {
						SwfLogDto swfLogTemp = new SwfLogDto();
						ClaimCombineDto claimCombineDto = (ClaimCombineDto) (((ArrayList) claimCombineDtoList).get(i));
						swfLogTemp = claimCombineDto.getSwfLogDto();
						UICompensateAction uiCompensateAciton = new UICompensateAction();
						String statement = "claimno='"
								+ swfLogTemp.getKeyIn()
								+ "' and (UnderWriteFlag <> '1' and UnderWriteFlag <>'3')";
						Collection uiCompenList = uiCompensateAciton
								.findByConditions(statement);
						swfLogTemp.setCompCount(uiCompenList.size());
						claimCombineDto.setSwfLogDto(swfLogTemp);
						claimCombineDtoListTemp.add(claimCombineDto);
					}
					claimCombineDtoList = claimCombineDtoListTemp;
				}
			} else if (nodeType.equals("claim") && status.equals("0")) { // ���ڴ���ע��������ע���ı�����������
				/*
				 * if(swfLogList!=null&&swfLogList.size()>0){ for (int i = 0; i <
				 * swfLogList.size(); i++) { SwfLogDto swfLogTemp = new
				 * SwfLogDto(); swfLogTemp = (SwfLogDto) ( ( (ArrayList)
				 * swfLogList).get(i)); EndorseViewHelper endorseViewHelper =
				 * new EndorseViewHelper(); PolicyDto policyDto =
				 * endorseViewHelper.findForEndorBefore(swfLogTemp.getPolicyNo());
				 * swfLogTemp.setOtherFlag(policyDto.getPrpCmainDto().getOthFlag());
				 * swfLogListTemp.add(swfLogTemp); } swfLogList =
				 * swfLogListTemp; }
				 */
			}
		} else {
			if (claimCombineDtoList != null && claimCombineDtoList.size() > 0) {
				for (int i = 0; i < claimCombineDtoList.size(); i++) {
					SwfLogDto swfLogTemp = new SwfLogDto();
					ClaimCombineDto claimCombineDto = new ClaimCombineDto();
					claimCombineDto = (ClaimCombineDto) (((ArrayList) claimCombineDtoList).get(i));
					swfLogTemp = claimCombineDto.getSwfLogDto();
					swfLogTemp.setNodeTypeName(uiCodeAction.translateCodeCode(
							"ClaimNodeType", swfLogTemp.getNodeType(), true));
					claimCombineDto.setSwfLogDto(swfLogTemp);
					claimCombineDtoListTemp.add(claimCombineDto);
				}
				claimCombineDtoList = claimCombineDtoListTemp;
			}
		}
		SwfLogDto swfLogDto = new SwfLogDto();
		ClaimCombineDto claimCombineDto = new ClaimCombineDto();
		// add by lixiang start at 2006-6-5
		// reason:ת�����������õ�
		claimCombineDtoList = translateRelatePolicyOnTaskQuery(claimCombineDtoList, nodeType);
		// add by lixiang end at 2006-6-5
		getNodeTimeOutInfo(claimCombineDtoList);
		claimCombineDto.setClaimCombineDtoList(claimCombineDtoList);
		claimCombineDto.setAlertMessage(alertMessage);
		if (nodeType == null || nodeType.trim().length() < 1) {
			claimCombineDto.setNodeType("commo");
		} else {
			claimCombineDto.setNodeType(nodeType);
		}
		claimCombineDto.setTurnPageDto(turnPageDto);

		httpServletRequest.setAttribute("claimCombineDto", claimCombineDto);
		// ��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
		httpServletRequest.setAttribute("status", status);
		httpServletRequest.setAttribute("nodeType", nodeType);

		// modify by wangwei add start 2005-06-12
		// ԭ�򣺰�����������Ϣ����Request�У����������⽡�պ��������֡�
		httpServletRequest.setAttribute("com.sinosoft.type", httpServletRequest
				.getParameter("type"));
		// modify by wangwei add end 2005-06-12
	}
	/**
	 * ���������ʾ�б�������������ֽڵ�����д��������
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 */
	private String getNodeTaskListConditions(
			HttpServletRequest httpServletRequest, String status,
			String handlerCode) throws Exception {
		String condition = " ";
		// ���ȼ������������� GYIC ���� 20110803 start
		String combineCondition = " SWFLOG.RegistNo = PRPLCOMBINE.RegistNo ";
		// ���ȼ������������� GYIC ���� 20110803 end
		String orderString = "  order by nodeType,handleTime desc";
		// ע������
		if (status.equals("-1")) {
			condition = condition +combineCondition + " and Nodestatus < '4' and handlerCode='"
					+ handlerCode + "'";
			// ����������
		} else if (status.equals("0")) {
			// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
			condition = combineCondition + " and ((NodeStatus='"
					+ status
					+ "' and (handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='' ))  or ( NodeStatus='3' and handlerCode='"
					+ handlerCode + "')) ";
		} else {
			condition = condition + combineCondition + " and NodeStatus='" + status
					+ "' and handlerCode='" + handlerCode + "'";
		}
		// ������������ڴ��������м��벻��ʾ�Ѿ��ر����̵Ľڵ���Ϣ
		condition = condition + " and (flowStatus='1' or flowStatus='2')";

		// condition = condition +"' and NodeStatus='"+status+"'";
		/*
		 * if (handlerCode!=null&&handlerCode.trim().length()>0 ) { condition =
		 * condition + " and (handlerCode='"+handlerCode+"'"; }
		 */
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		// modify by zhaolu 20060816 start
		// condition =
		// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		condition = condition
				+ uiPowerInterface.addPower(userDto, "swflog", "", "ComCode");
		// modify by zhaolu 20060816 end
		// ������ԱȨ�޴��� add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end
		condition = condition + orderString;

		return condition;
	}
	/**
	 * ���������ʾ�б������,һ�����(�������������ڴ����������ύ����)
	 * 
	 * @param nodeType
	 *            String
	 * @param status
	 *            String
	 * @param handlerCode
	 *            String
	 * @throws Exception
	 * @return String
	 */
	private String getNodeTaskListConditionsByNodeType(
			HttpServletRequest httpServletRequest, String nodeType,
			String status, String handlerCode) throws Exception {
 		String condition = "";
		String orderString = " order by handleTime desc";
		String riskType = httpServletRequest.getParameter("type");
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String conSignType = httpServletRequest.getParameter("conSignType");
		if (nodeType.equals("verip")) {
			String comLevel = user.getComLevel();
			if (comLevel.equals("1")) {
				nodeType = "verpo";
			}
		}
		// �����ѯ����˼��������޸Ľڵ�����
		if (conSignType != null && conSignType.equals("verpo")) {
			nodeType = conSignType;
			condition = "  handleDept = '" + user.getComCode() + "' ";
		}

		// ��ʼƴ������������
		condition = "";
		// ���ȼ������������� GYIC ���� 20110803 start
		String combineCondition = " SWFLOG.RegistNo = PRPLCOMBINE.RegistNo ";
		// ���ȼ������������� GYIC ���� 20110803 end
		if (handlerCode.equals("")) {
			condition = combineCondition + "  and nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "'";
		} else {
			condition = combineCondition +  "  and (nodeType='" + nodeType + "' and NodeStatus='"
					+ status + "' and handlerCode='" + handlerCode + "')";
		}
		// ע������
		// if (status.equals("-1")&&!nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus <'4' ";
		// if (status.equals("-1")&& nodeType.equals("claim")) condition = "
		// nodeType='"+ nodeType+ "' and ( handlerCode='"+handlerCode+"' or
		// handlerCode is null or handlerCode='') and Nodestatus ='4' ";//modify
		// by kangzhen 070417
		if (status.equals("-1")){
			if(!"compe".equals(nodeType)){
			condition = combineCondition +  "  and nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus <'4' ";// ���������Ժ�
			
			}
			//����ע���������룬ҵ�񱳾���ע������ֻ������δ�������������������ע�����ⲻ��
			else{
				condition = combineCondition +  "  and nodeType='"
					+ nodeType
					+ "' and ( handlerCode='"
					+ handlerCode
					+ "' or handlerCode is null or handlerCode='') and Nodestatus ='0' ";// ���������Ժ�
			    }
			}																				// ����������ֻ���ύ֮ǰ����������ע��,����ύ,���뵽��֤����ע������

		// ����������
		if (status.equals("0")) {

			// �����˻ص����񵥶��ֳ����������ڴ�������
			if (nodeType.equals("certa") || nodeType.equals("wound")
					|| nodeType.equals("propc")) { //
				condition = combineCondition +  "  and nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			} else {
				// ״̬����0�������Ϊָ�����˺͹������ֵģ�û�б�ָ���û�������
				condition = combineCondition +  "  and nodeType='" + nodeType + "' and (NodeStatus='"
						+ status + "' or NodeStatus='3' ) and flowStatus!='0' and (handlerCode='"
						+ handlerCode
						+ "' or handlerCode is null or handlerCode='')";
			}

			if (nodeType.equals("sched")) { // �������̫������

				condition = combineCondition +  "  and (nodeType='" + nodeType + "' ) and (NodeStatus='"
						+ status + "') and flowStatus!='0' and (handlerCode='" + handlerCode
						+ "' or handlerCode is null or handlerCode='')";
				//��ũ�����ܹ�˾���б���������֧��˾ֻ������ũ�ձ���
				if(user.getComCode().indexOf("000") != 0){
					condition = condition +  " and  (riskcode like '31%' or riskcode like '32%') ";
				}

			}
		}
		if(status.equals("2")){
			condition = condition +  "  and flowStatus!='0'";//���ѹر��ⰸ��,�����ڴ�������˵�ʱ������ʾ����
		}
		//������������ڴ��������м��벻��ʾ�Ѿ��ر����̵Ľڵ���Ϣ
		condition = condition + " and (flowStatus='1' or flowStatus='2')";

		if (nodeType.equals("verpo")) {
			condition = condition + " and   handleDept like  '"
					+ user.getComCode().substring(0, 3) + "%' ";
		}

		if (nodeType.equals("claim") && status.equals("0")) {
			// modify by lixiang add 20050310 start
			// reason:����������ʾ
			orderString = " order by flowintime";
			// modify by lixiang add 20050310 end
		}

		if (nodeType.equals("sched") && status.equals("2")) {
			// condition = " (nodeType='"+ nodeType+ "' ) and
			// (NodeStatus='"+status+"') ";

		}

		if (nodeType.equals("sched") && status.equals("0")) {
			orderString = " order by flowintime";
		}
		// ����������
		if (status.equals("99")) // 9�ǲ�ѯ����״̬�ġ���
		{
			condition = combineCondition +   " nodeType='" + nodeType + "'";
		}
		if (nodeType.equals("veric") && status.equals("0")) {
			condition = combineCondition +  " nodeType='" + nodeType + "' and nodestatus <'4'";
		}
		// -------------------------------------------------------------
		if ("check".equals(nodeType)) {
			if(status.equals("-1")){
				condition = condition
				+ " and nodeType='"
				+ nodeType
				+ "' and NodeStatus < '4'"
				+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			}
			else{
				condition = condition
				+ " and nodeType='"
				+ nodeType
				+ "' and NodeStatus='"
				+ status
				+ "'"
				+ " and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			}
		}

		// /////////////////////
		// �Ӵ���������ȡ��������˵��������ӽ����ϵ�ҵ������keyIn,keyOut����businessNO�Ͻ��в�ѯ
		if (status.equals("-1") && "claim".equals(nodeType)) {
		    String strBusinessNo = (String)httpServletRequest.getParameter("BusinessNo");
			if (strBusinessNo!= null && !"".equals(strBusinessNo)) {
				PrpLclaimDto prpLclaimDto = (new BLPrpLclaimFacade()).findByPrimaryKey(httpServletRequest.getParameter("BusinessNo"));
				String registNo = "null";
				if(prpLclaimDto != null){
					registNo = prpLclaimDto.getRegistNo();
				}
				
				condition = condition
						+ StringConvert.convertString(httpServletRequest.getParameter("searchField"), registNo,
								httpServletRequest.getParameter("BusinessNoSign"));
			}

		} else {
			condition = condition
					+ StringConvert.convertString(httpServletRequest
							.getParameter("searchField"), httpServletRequest
							.getParameter("BusinessNo"), httpServletRequest
							.getParameter("BusinessNoSign"));
		}

		// modify by lixiang start at 2006-6-5
		// reason:֧�ֶౣ���Ĳ�ѯ
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// ����һ�£�������������߽᰸�������Ǽ����鴦������δ�����أ�Ӧ���ǲ�������������ת���İɣ�
			if (!checkNeedFindRelatePolicy(nodeType)) {
				condition = condition
						+ StringConvert
								.convertString("SWFLOG.policyNo", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));
			} else {
				condition = condition
						+ " and SWFLOG.registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert
								.convertString(" policyNo", policyNo,
										httpServletRequest
												.getParameter("PolicyNoSign"))
						+ ") ";
			}
		}
		//
		// modify by lixiang end at 2006-6-5
		String strRiskClaimType = httpServletRequest.getParameter("RiskClaimType");
		if(strRiskClaimType != null &&!"".equals(strRiskClaimType)){
			condition = condition + " and riskcode in (select distinct outercode from uticodetransfer where risktype='"+strRiskClaimType+"' and validstatus='1') ";

		}else{
			condition = condition
			+ StringConvert.convertString("RiskCode",
					httpServletRequest.getParameter("RiskCode"),
					httpServletRequest.getParameter("RiskCodeNoSign"));
		}
        
		condition = condition
		+ StringConvert.convertString("insuredName",
				httpServletRequest.getParameter("insuredName"),
				httpServletRequest.getParameter("insuredNameSign"));

		// add by liuyanmei 20051123 start
		// reason : ���ڴ����������� ��ѯ�����豨����
		if (nodeType.equals("claim") && !status.equals("0")) {
			condition = condition
					+ " And exists (select * from prplclaim a where swflog.keyout=a.claimno "
					+ StringConvert.convertString("a.registno",
							httpServletRequest.getParameter("ClaimRegistNo"),
							httpServletRequest
									.getParameter("ClaimRegistNoSign"));
			condition = condition + ")";
		}

		if (nodeType.equals("compp") && !status.equals("1")) {
			condition = condition
					+ StringConvert.convertString("SWFLOG.registno",
							httpServletRequest.getParameter("ComppRegistNo"),
							httpServletRequest
									.getParameter("ComppRegistNoSign"));
		}

		// add by liuyanmei 20051123 end
		// ���Ŵ���
		String deptname = httpServletRequest.getParameter("DeptName");
		if (deptname != null && (deptname.trim().length()) > 0) {
			condition = condition
					+ StringConvert.convertString("DeptName", deptname,
							httpServletRequest.getParameter("DeptNameSign"));
		}
		String operateDate = httpServletRequest.getParameter("OperateDate");
		if (operateDate != null && !operateDate.trim().equals("")) {
			condition = condition
					+ StringConvert.convertDate("FlowInTime", operateDate,
							httpServletRequest.getParameter("OperateDateSign"));
		}
		String statEndDate = httpServletRequest.getParameter("statEndDate");
		String statStartDate = httpServletRequest.getParameter("statStartDate");
		if (statEndDate != null && statEndDate.trim().length() > 0) {
			condition = condition + " AND HandleTime <='" + statEndDate + "'";
		}
		if (statStartDate != null && statStartDate.trim().length() > 0) {
			condition = condition + " AND HandleTime >='" + statStartDate + "'";
		}
		// ////////////////////

		// ������
		String registNo = httpServletRequest.getParameter("RegistNo");
		if (registNo != null && registNo.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("SWFLOG.RegistNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));

		}

		// ��ʧ���/����
		String lossitemName = httpServletRequest.getParameter("LicenseNo");
		if (lossitemName != null && lossitemName.trim().length() > 0) {
			condition = condition
					+ StringConvert.convertString("LossItemName", lossitemName,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		String InsuredName = httpServletRequest.getParameter("InsuredName");
		if (InsuredName != null && InsuredName.trim().length() > 0) {

			// ����������
			condition = condition
					+ StringConvert.convertString("InsuredName", InsuredName,
							httpServletRequest.getParameter("InsuredNameSign"));
		}

		String conditionscompe = "";

		String endcaRegistNo = httpServletRequest.getParameter("EndcaRegistNo");
		String compeRegistNo = httpServletRequest.getParameter("CompeRegistNo");
		String comppRegistNo = httpServletRequest.getParameter("ComppRegistNo");
		// ��֣�ΪʲôҪ��ô���ء��������������б�������ѽ����������
		if (endcaRegistNo != null && endcaRegistNo.trim().length() > 0) {
			conditionscompe = endcaRegistNo;
		}
		if (compeRegistNo != null && compeRegistNo.trim().length() > 0) {
			conditionscompe = compeRegistNo;
		}
		if (comppRegistNo != null && comppRegistNo.trim().length() > 0) {
			conditionscompe = comppRegistNo;
		}

		if (conditionscompe != "") {
			condition = condition
					+ StringConvert.convertString("SWFLOG.RegistNo", conditionscompe,
							"=");
		}

		String typeFlag = httpServletRequest.getParameter("typeFlag");
		if (("1").equals(typeFlag)) {
			condition = condition + " AND typeFlag='1' ";
		}
		
		/*
		 * added by ���� from ��Ԫ���� start
		 * ���ӶԲ��������в�ѯ��֧�֡�
		 * ���� �¹ʺţ������ţ��Ĳ�ѯ��
		 * 
		 */
		String combineNo = httpServletRequest.getParameter("CombineNo");
		if(null != combineNo && combineNo.trim().length() > 0){
			condition = condition
			+ StringConvert.convertString("PRPLCOMBINE.CombineNo", combineNo, httpServletRequest.getParameter("CombineNoSign"));
//			String sqlGetRegistNoUnderCombined = "select registno from PRPLCOMBINE where "+ StringConvert.convertString("CombineNo", combineNo,
//					httpServletRequest.getParameter("combineNoSign"));
//			condition = condition + " AND RegistNo in (" + sqlGetRegistNoUnderCombined + ") ";
		}
//		 added by ���� from ��Ԫ���� end

		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		if (riskType != null
				&& (nodeType.equals("compe") || nodeType.equals("compp"))
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyh","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// modify by zhaolu 20060816 end
		} else if (riskType != null && nodeType.equals("check")
				&& riskType.equals("acci")) {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),"lpyd","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 start
		} else if (nodeType.equals("verpo")) {
			// ����˼۲���Ҫ
		}else if(nodeType.equals("check")){
			condition = condition + " and ((modelno=7  "+uiPowerInterface.addPower(userDto, "vv","", "ComCode").replace("vv", "Swflog")+") or (modelno<>7 "+uiPowerInterface.addPower(userDto, "kk", "","handledept").replace("kk", "Swflog")+") )";
		}else if(nodeType.equals("certa") ||
				nodeType.equals("wound") || nodeType.equals("propc") ||
				nodeType.equals("verif") || nodeType.equals("veriw") ||
				nodeType.equals("propv")){
			condition = condition
			+ uiPowerInterface.addPower(userDto, "swflog", "",
					"handledept");
		}

		else {
			// modify by zhaolu 20060816 start
			condition = condition
					+ uiPowerInterface.addPower(userDto, "swflog", "",
							"ComCode");
			// condition =
			// condition+uiPowerInterface.addPower(userDto.getUserCode(),BusinessRuleUtil.transTaskCode(nodeType),"swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
			// modify by zhaolu 20060816 end
		}

		// ������ԱȨ�޴��� add by qinyongli 2005-11-15 begin
		// UIPrpPersonLimitAction uiPrpPersonLimitAction = new
		// UIPrpPersonLimitAction();
		// String conditionRisk =
		// uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
		// condition = condition + conditionRisk;
		// add by qinyongli end

		condition = condition + orderString;
        
		return condition;
	}
	/**
	 * �����Ҫ���й������������
	 * 
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @return boolean
	 */
	private boolean checkNeedFindRelatePolicy(String nodeType) throws Exception {
		boolean blresut = true;
		// �����������飬�᰸�ǲ���Ҫ���й������������
		if ("claim".equals(nodeType) || "compp".equals(nodeType)
				|| "endca".equals(nodeType)) {
			blresut = false;

		}
		return blresut;
	}
	
	/**
	 * �����Ҫ���й������������
	 * 
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 * @return boolean
	 */
	private Collection translateRelatePolicyOnTaskQuery(Collection claimCombineDtoList,
			String nodeType) throws Exception {
		Collection claimCombineDtoListTemp = new ArrayList();
		UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		Iterator it = claimCombineDtoList.iterator();
		String strSql = "";
		while (it.hasNext()) {
			SwfLogDto swfLogTemp = new SwfLogDto();
			ClaimCombineDto claimCombineDto = new ClaimCombineDto();
			claimCombineDto = (ClaimCombineDto)it.next();
			swfLogTemp = claimCombineDto.getSwfLogDto();
			Collection relatePolicyList = new ArrayList();
			if (checkNeedFindRelatePolicy(swfLogTemp.getNodeType())) {
				// ȡ�ö�������ı�����Ϣ
				strSql = " registno='" + swfLogTemp.getRegistNo() + "'";
				relatePolicyList = uiPrpLregistRPolicyAction
						.findByConditions(strSql);

			} else {
				// �������Ҫ�Ļ���ֱ�ӽ������еı�������ŵ���ʾ�õ�relatePolicyList������
				PrpLRegistRPolicyDto prpLregistRPolicyDto = new PrpLRegistRPolicyDto();
				prpLregistRPolicyDto.setPolicyNo(swfLogTemp.getPolicyNo());
				prpLregistRPolicyDto.setRegistNo(swfLogTemp.getRegistNo());
				relatePolicyList.add(prpLregistRPolicyDto);
			}

			swfLogTemp.setRelatePolicyList(relatePolicyList);

			claimCombineDto.setSwfLogDto(swfLogTemp);
			claimCombineDtoListTemp.add(claimCombineDto);

		}
		return claimCombineDtoListTemp;
	}

	/**
	 * ���ݽڵ�����Ͳ���״̬��������Ϣ(Ŀǰֻ���������ⰸ�Ĳ�ѯ)
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param status
	 *            ����״̬
	 * @param nodeType
	 *            �ڵ�����
	 * @throws Exception
	 */
	public void getSwfLogList(HttpServletRequest httpServletRequest,
			String caseFlag, String userCode, String nodeType) throws Exception {
		if (caseFlag != null && caseFlag.trim().length() > 0) {
			caseFlag = caseFlag.substring(0, caseFlag.length() - 1);
		}
		// ��ѯ����ڵ�״̬��Ϣ
		// �õ�����������Ϣ
		Collection claimCombineDtoList = new ArrayList();
		Collection claimCombineDtoListTemp = new ArrayList();
		String conditions = " handlerCode = '" + userCode
				+ "' AND NodeType = '" + nodeType + "'";
		conditions = conditions
				+ StringConvert.convertString("businessno", httpServletRequest
						.getParameter("RegistNo"), httpServletRequest
						.getParameter("RegistNoSign"));

		// modify by lixiang start at 2006-6-5
		// reason:֧�ֶౣ���Ĳ�ѯ
		String policyNo = httpServletRequest.getParameter("PolicyNo");
		if (policyNo != null && policyNo.length() > 1) {
			// ����һ�£�������������߽᰸�������Ǽ����鴦������δ�����أ�Ӧ���ǲ�������������ת���İɣ�
			if (!checkNeedFindRelatePolicy(nodeType)) {
				conditions = conditions
						+ StringConvert
								.convertString("SWFLOG.policyno", httpServletRequest
										.getParameter("PolicyNo"),
										httpServletRequest
												.getParameter("PolicyNoSign"));

			} else {
				conditions = conditions
						+ " and SWFLOG.registno in (select registno from "
						+ "prplregistrpolicy where 1=1 "
						+ StringConvert
								.convertString(" policyNo", policyNo,
										httpServletRequest
												.getParameter("PolicyNoSign"))
						+ ") ";
			}
		}
		// modify by lixiang end at 2006-6-5

		if (caseFlag.trim().length() > 0) {
			//ƴ����״̬����			
			int newIndex = 0;
			String caseFlagTemp = "";
			while(true){
				if((newIndex = caseFlag.trim().indexOf(",")) != -1){
					caseFlagTemp += caseFlag.trim().substring(0,newIndex) + "','";
					caseFlag =caseFlag.trim().substring(newIndex + 1,caseFlag.trim().length());					
				}else{
					break;
				}
			}
			caseFlag = caseFlagTemp + caseFlag;
			conditions = conditions + "  AND NodeStatus in ('" + caseFlag
					+ "')";
		}		
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		// modify by zhaolu 20060816 start
		conditions = conditions
				+ uiPowerInterface.addPower(userDto, "swflog", "", "ComCode");
		// conditions =
		// conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		// modify by zhaolu 20060816 end
		// �жϽڵ㣬�е���Ҫ�����û����ƽ��в�ѯ���еĲ���Ҫ�û����ֽ��в�ѯ
		// Ŀǰֻ��Ϊ4��״̬�����ύ��Ҫ���з�ҳ
		BLPrplcombineSwfLogFacade blPrplcombineSwfLogFacade = new BLPrplcombineSwfLogFacade();
		claimCombineDtoList = (Collection) blPrplcombineSwfLogFacade.findByConditions(conditions);

		// ���nodeType=����/����Ļ�������Ҫת������/�������������
		if (nodeType.equals("speci")) {
			Iterator it = claimCombineDtoList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogTemp = new SwfLogDto();
				ClaimCombineDto claimCombineDto = new ClaimCombineDto();
				claimCombineDto = (ClaimCombineDto) it.next();
				swfLogTemp = claimCombineDto.getSwfLogDto();
				if (swfLogTemp.getTypeFlag().equals("3")) {
					swfLogTemp.setTypeFlagName("ͨ��");
				} else if (swfLogTemp.getTypeFlag().equals("4")) {
					swfLogTemp.setTypeFlagName("Ԥ��");
				} else if (swfLogTemp.getTypeFlag().equals("5")) {
					swfLogTemp.setTypeFlagName("Ԥ��");
				} else {
					swfLogTemp.setTypeFlagName("");
				}
				claimCombineDto.setSwfLogDto(swfLogTemp);
				claimCombineDtoListTemp.add(claimCombineDto);
			}

			claimCombineDtoList = claimCombineDtoListTemp;
		}
		ClaimCombineDto claimCombineDto = new ClaimCombineDto();
		// add by lixiang start at 2006-6-5
		// reason:ת�����������õ�
		claimCombineDtoList = translateRelatePolicyOnTaskQuery(claimCombineDtoList, nodeType);
		getNodeTimeOutInfo(claimCombineDtoList);
		// add by lixiang end at 2006-6-5
		claimCombineDto.setClaimCombineDtoList(claimCombineDtoList);
		claimCombineDto.setNodeType(nodeType);
		httpServletRequest.setAttribute("claimCombineDto", claimCombineDto);
		// ��ֹ�ٴ�ˢ�µ�ʱ���ʧȥֵ
		httpServletRequest.setAttribute("nodeType", nodeType);

	}
	
	
	public Collection getNodeTimeOutInfo(Collection claimCombineDtoList)
	throws Exception
	{
		Collection claimCombineDtoListTemp = new ArrayList();
		if(null!=claimCombineDtoList && claimCombineDtoList.size()>0){
	      Collection swfLogDtoList = new ArrayList();
	      Collection swfLogDtoLastList = new ArrayList();
	      UICodeAction  uiCodeAction = new UICodeAction();

	      SwfLogDto swfLogDto = new SwfLogDto();
	      Iterator it = claimCombineDtoList.iterator() ;
	      String riskCodeName ="";
	      String nodeStatusName ="";
	      String nodeTypeName ="";
	      int count=0;

	      while (it.hasNext() )
	      {
	        //ת������
	          SwfLogDto swfLogDtoTemp = new SwfLogDto();
	          ClaimCombineDto claimCombineDto = new ClaimCombineDto();
	          claimCombineDto = (ClaimCombineDto)it.next();
	          swfLogDtoTemp = claimCombineDto.getSwfLogDto();
	        //���㳬ʱ��ʱ�䳤��
	        //public static int intervalDay(DateTime startDate, int startHour, DateTime endDate, int endHour) { return 0;}
	        count =DateTime.intervalDay(new DateTime(swfLogDtoTemp.getHandleTime(),DateTime.YEAR_TO_DAY ),0,new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ) ,0) -1;
	        //-1��Ϊ�˳������ͳ�Ƶĵ���
	        swfLogDtoTemp.setTimeLimit(count);
	         //ת������
	         riskCodeName =  uiCodeAction.translateRiskCode(swfLogDtoTemp.getRiskCode(),true);
	         swfLogDtoTemp.setRiskCodeName(riskCodeName);
	         nodeStatusName =uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp.getNodeStatus() ,true);
	         swfLogDtoTemp.setNodeStatusName(nodeStatusName);
	         nodeTypeName=uiCodeAction.translateCodeCode("ClaimNodeType",swfLogDtoTemp.getNodeType() ,true);
	         swfLogDtoTemp.setNodeTypeName(nodeTypeName) ;
	         claimCombineDto.setSwfLogDto(swfLogDtoTemp);
	         claimCombineDtoListTemp.add(claimCombineDto);
	      }
		}

	      return claimCombineDtoListTemp;
	}

}

