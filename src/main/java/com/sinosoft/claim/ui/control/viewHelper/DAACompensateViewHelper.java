package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Title: CompensateViewHelper
 * </p>
 * <p>
 * Description:ʵ��ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public class DAACompensateViewHelper extends CompensateViewHelper {
	private static Log logger = LogFactory.getLog(DAACompensateViewHelper.class);

	private UICodeAction uiCodeAction = new UICodeAction();

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��дʵ�ⵥʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return compensateDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public CompensateDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		return compensateDto;
	}

	/**
	 * ��дʵ��ҳ�漰��ѯʵ��request������.
	 * ��дʵ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		// �õ�request��PrpLcompensateForm������ʾ
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}


	/**
	 * ������������źͱ�����,�ⰸ��,����״̬�����ƺ��룬����ʱ���ѯʵ����Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateNo
	 *            ���������
	 * @param policyNo
	 *            ������
	 * @param claimNo
	 *            �ⰸ��
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
	 */

	public void setPrpLcompensateDtoToView(
			HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		// compensateNo,policyNo,claimNo
		// ��������ı����ţ�ʵ�������SQL where �Ӿ�
		String riskType = "";
		riskType = httpServletRequest.getParameter("riskType"); // modify by
		// liuyanmei add
		// 20051110
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String compensateNo = StringUtils.rightTrim(workFlowQueryDto
				.getCompensateNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String underWriteFlag = StringUtils.rightTrim(workFlowQueryDto
				.getUnderWriteFlag());

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("a.compensateNo", compensateNo,
						workFlowQueryDto.getCompensateNoSign());
		conditions = conditions
				+ StringConvert.convertString("a.claimNo", claimNo,
						workFlowQueryDto.getClaimNoSign());
		conditions = conditions
				+ StringConvert.convertString("a.policyNo", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status != null && status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (underWriteFlag != null && underWriteFlag.trim().length() > 0) {
			conditions = conditions + " AND a.underWriteFlag in ("
					+ underWriteFlag + ") ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}

		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		if (!(riskType == null)) {
			if (riskType.equals("acci")) {
				conditions = conditions
						+ " and (a.riskCode like '07%' or a.riskCode like '06%') ";
			}
		} else {
			conditions = conditions
					+ " and (a.riskCode not like '07%' or a.riskCode like '06%' ) ";
		}

		// ��ѯԤ����Ϣ
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// �õ�����ʵ��������Ϣ
		Collection compensateList = new ArrayList();
		compensateList = (Collection) uiCompensateAction
				.findByQueryConditions(conditions);
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);
		prpLcompensateDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

	}
	
	
	
	//add by zhaolu 20060803 start
	public void setPrpLcompensateDtoToView(
			HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,String pageNo,String recordPerPage) throws Exception {
		// compensateNo,policyNo,claimNo
		// ��������ı����ţ�ʵ�������SQL where �Ӿ�
		String riskType = "";
		riskType = httpServletRequest.getParameter("riskType"); // modify by
		// liuyanmei add
		// 20051110
		
		int intPageNo = Integer.parseInt(pageNo);
		
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		String nodeTypeTemp     = httpServletRequest.getParameter("nodeType");
		String insuredName = StringUtils.rightTrim(workFlowQueryDto
				.getInsuredName());
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String compensateNo = StringUtils.rightTrim(workFlowQueryDto
				.getCompensateNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto
				.getLicenseNo());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDate());
		String operateDateEnd = StringUtils.rightTrim(workFlowQueryDto
				.getOperateDateEnd());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String underWriteFlag = StringUtils.rightTrim(workFlowQueryDto
				.getUnderWriteFlag());
		String queryRiskCode = httpServletRequest.getParameter("queryRiskCode");
		String conditions = " 1=1 ";
		//���������ũ�ձ�ʶ
		conditions = conditions + " and (c.registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeTypeTemp+"') ";
		conditions = conditions + " or c.registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeTypeTemp+"')) ";
		conditions = conditions
				+ StringConvert.convertString("a.compensateNo", compensateNo,
						workFlowQueryDto.getCompensateNoSign());
		conditions = conditions
				+ StringConvert.convertString("a.claimNo", claimNo,
						workFlowQueryDto.getClaimNoSign());
		conditions = conditions
				+ StringConvert.convertString("a.policyNo", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("c.insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		conditions = conditions
	        	+ StringConvert.convertString("a.riskcode",
				        queryRiskCode, "=");

		if (status != null && status.trim().length() > 0) {
			//ƴ����״̬			
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
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (underWriteFlag != null && underWriteFlag.trim().length() > 0) {
			conditions = conditions + " AND a.underWriteFlag in ("
					+ underWriteFlag + ") ";
		}
		
		//��session��ȡ��ƶ/�󻧱�־
        String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
        if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
      	  if(strHPflag.equals("Large")) {
      		  conditions = conditions +  " and a.policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
      	  }
            if(strHPflag.equals("Retaol")) {
          	  conditions = conditions +  " and a.policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
      	  }
        }
        
		System.err.println("************conditions = " + conditions);
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		if (operateDateEnd != null && !operateDateEnd.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDateEnd,
							workFlowQueryDto.getOperateDateSignEnd());
		}
        
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060816 end
		/**if (!(riskType == null)) {
			if (riskType.equals("acci")) {
				conditions = conditions
						+ " and (a.riskCode like '07%' or a.riskCode like '06%') ";
			}
		} else {
			conditions = conditions
					+ " and (a.riskCode not like '07%' or a.riskCode like '06%' ) ";
		}*/
		
		
		
		 String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	        }

		// ��ѯԤ����Ϣ
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// �õ�����ʵ��������Ϣ
		//Collection compensateList = new ArrayList();
		ArrayList compensateList = new ArrayList();
		logger.debug("start to �⽡��--conditions--..||" + conditions);
		System.out.println("##########conditions:" +conditions );
		PageRecord pageRecord = (PageRecord)uiCompensateAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
		compensateList = (ArrayList)pageRecord.getResult();
		///compensateList = (Collection) uiCompensateAction
				//.findByQueryConditions(conditions);
		 logger.debug("end search,please waiting for result...");
		
		   TurnPageDto turnPageDto = new TurnPageDto();
	       //��ѯ������һҳ�Ľṹ�� 
	       turnPageDto.setResultList(compensateList);
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
	       
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);
		prpLcompensateDto.setTurnPageDto(turnPageDto);
		logger.debug("finish add list");
		logger.debug("editType=" + httpServletRequest.getParameter("editType"));
		prpLcompensateDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

	}
	//add by zhaolu 20060803 end

	/**
	 * ������������źͱ����ź��ⰸ�Ų�ѯ�����˵�ʵ����Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateNo
	 *            ���������
	 * @param policyNo
	 *            ������
	 * @param claimNo
	 *            �ⰸ��
	 * @throws Exception
	 */

	public void getApproveCompensateList(HttpServletRequest httpServletRequest,
			String compensateNo, String policyNo, String claimNo)
			throws Exception {
		// compensateNo,policyNo,claimNo
		// ��������ı����ţ�ʵ�������SQL where �Ӿ�
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		compensateNo = StringUtils.rightTrim(compensateNo);

		String conditions = "1=1  ";
		conditions = conditions
				+ StringConvert.convertString("prplcompensate.compensateNo",
						compensateNo, httpServletRequest
								.getParameter("CompensateNoSign"));
		conditions = conditions
				+ StringConvert.convertString("prplcompensate.policyNo",
						policyNo, httpServletRequest
								.getParameter("PolicyNoSign"));
		conditions = conditions
				+ StringConvert
						.convertString("prplcompensate.claimNo", claimNo,
								httpServletRequest.getParameter("ClaimNoSign"));
		// conditions = conditions +" AND ( prplcompensate.ApproverCode IS NULL
		// OR prplcompensate.ApproverCode='' OR
		// prplcompensate.UnderWriteFlag='2') and prplclaimstatus.status='3'" ;
		conditions = conditions
				+ " AND ( prplcompensate.ApproverCode IS NULL OR  prplcompensate.ApproverCode='' OR prplcompensate.UnderWriteFlag='2')";
		// ��ѯԤ����Ϣ
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// �õ�����ʵ��������Ϣ
		Collection compensateList = new ArrayList();
		logger.debug("start to��ô����...");

		compensateList = (Collection) uiCompensateAction
				.findByApproveConditions(conditions);

		logger.debug("end search,please waiting for result...");

		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);

		logger.debug("finish add list");

		logger.debug("editType=" + httpServletRequest.getParameter("editType"));
		prpLcompensateDto.setEditType(httpServletRequest
				.getParameter("editType"));
		logger.debug("finish add list::::::::::::::::::edittype::::"
				+ httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}

	// modify by luqin 2005-04-08 start
	/**
	 * ���ɷѱ�־ ����ֵ int -1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param policyNo
	 *            �ⰸ��
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// ȡ������������Ϣ
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo
				+ "' AND substr(Flag,1,1)!='1' ";
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions);
		return intReturn;
	}

	// modify by luqin 2005-04-08 end
    
	// modfiy by wangli add start 20050420

	/**
	 * ��ѯ�ⰸ�Ŷ�Ӧ��ʵ����Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param claimNo
	 *            �ⰸ��
	 * @throws Exception
	 *             Modify By wangli 2005-04-20 Reason:��ѯ�ⰸ�Ŷ�Ӧ��ʵ����Ϣ
	 */

	public void setPrpLcompensateByClaimNoDtoToView(
			HttpServletRequest httpServletRequest, String claimNo)
			throws Exception {

		claimNo = StringUtils.rightTrim(claimNo);
		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("claimNo", claimNo, "=");

		// ��ѯԤ����Ϣ
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// �õ�����ʵ��������Ϣ
		Collection compensateList = new ArrayList();
		logger.debug("start to search,please waiting ...");
		compensateList = (Collection) uiCompensateAction
				.findByClaimNo(conditions);

		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);

		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// �жϳ��ռ�ʻԱ�Ƿ��Լ����ʻԱ
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto
				.getPrpLclaimDto().getPolicyNo(), claimDto.getPrpLclaimDto()
				.getDamageStartDate().toString(), claimDto.getPrpLclaimDto()
				.getDamageStartHour());
		ArrayList prpLdriverDtoList = claimDto.getPrpLdriverDtoList();
		String driverName = "";
		String driverFlag = "";
		// ȡ�����ռ�ʻԱ������
		int driverCount = prpLdriverDtoList.size();
		if (driverCount > 0)
			driverName = ((PrpLdriverDto) prpLdriverDtoList.get(0))
					.getDriverName();
		ArrayList prpCcarDriverDtoList = new ArrayList();
		prpCcarDriverDtoList = policyDto.getPrpCcarDriverDtoList();
		driverFlag = "false";
		for (int m = 0; m < prpCcarDriverDtoList.size(); m++) {
			PrpCcarDriverDto prpCcarDriverDto = (PrpCcarDriverDto) prpCcarDriverDtoList
					.get(m);
			if (prpCcarDriverDto.getDriverName().equals(driverName)) {
				driverFlag = "true";// Լ���˼�ʻԱ
				break;
			}
		}

		// �������û��Լ��������ʱ¼��,��Լ�� 2005-9-19
		if (prpCcarDriverDtoList.size() < 1) {
			driverFlag = "true";
		}
		logger.debug("#######driverFlag####" + driverFlag);
		httpServletRequest.setAttribute("driverFlag", driverFlag);
	}

	public void setPrpLcompensateDtoToPrint(
			HttpServletRequest httpServletRequest, String claimNo,
			String printType) throws Exception {
		UICompensateAction uiCompensateAction = new UICompensateAction();
		String condition = "claimNo =  '" + claimNo + "'";

		Collection prpLcompensateList = new ArrayList();
		prpLcompensateList = uiCompensateAction.findByClaimNo(condition);

		httpServletRequest.setAttribute("prpLcompensateList",
				prpLcompensateList);
		httpServletRequest.setAttribute("printType", printType);
	}
	
	/**
	 * ������������źͱ����ź��ⰸ�Ų�ѯʵ����Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateNo
	 *            ���������
	 * @param policyNo
	 *            ������
	 * @param claimNo
	 *            �ⰸ��
	 * @throws Exception
	 */

	public void searchPassCompensate(HttpServletRequest httpServletRequest, String compensateNo, String policyNo,
			String claimNo, String operateDate, String underWriteFlag, String pageNo, String recordPerPage)
			throws Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		// compensateNo,policyNo,claimNo
		// ��������ı����ţ�ʵ�������SQL where �Ӿ�
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		compensateNo = StringUtils.rightTrim(compensateNo);
		operateDate = StringUtils.rightTrim(operateDate);
		String strSign = httpServletRequest.getParameter("OperateDateSign");

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("compensateNo", compensateNo, httpServletRequest
						.getParameter("CompensateNoSign"));
		conditions = conditions
				+ StringConvert.convertString("claimNo", claimNo, httpServletRequest.getParameter("ClaimNoSign"));
		conditions = conditions
				+ StringConvert.convertString("policyNo", policyNo, httpServletRequest.getParameter("PolicyNoSign"));

		if (underWriteFlag != null && underWriteFlag.trim().length() > 0) {
			conditions = conditions + " AND underWriteFlag in (" + underWriteFlag + ") ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions + StringConvert.convertDate("InputDate", operateDate, strSign);
		}
		// ƴȨ��
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		conditions = conditions	+ uiPowerInterface.addPower(userDto,"prplcompensate","","ComCode");
		//modify by zhaolu 20060816 end
		String condition = httpServletRequest.getParameter("condition");
		String searchFlag = httpServletRequest.getParameter("searchFlag");
		if (searchFlag == null || searchFlag.trim().equals("true")) {

		} else {
			if (condition != null && condition.trim().length() > 0) {
				conditions = condition;
			}
		}
		// ��ѯʵ����Ϣ
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// �õ�����ʵ��������Ϣ
		ArrayList compensateList = new ArrayList();

		PageRecord pageRecord = (PageRecord) uiCompensateAction.findByConditions(conditions, pageNo, recordPerPage);

		compensateList = (ArrayList) pageRecord.getResult();

		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);
		TurnPageDto turnPageDto = new TurnPageDto();
		// ��ѯ������һҳ�Ľṹ��
		turnPageDto.setResultList(compensateList);
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
		prpLcompensateDto.setTurnPageDto(turnPageDto);

		// prpLcompensateDto.setCompensateList(compensateList);

		prpLcompensateDto.setEditType(httpServletRequest.getParameter("editType"));
		// httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

	}
}