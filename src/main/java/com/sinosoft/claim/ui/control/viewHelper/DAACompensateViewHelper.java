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
 * Description:实赔ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class DAACompensateViewHelper extends CompensateViewHelper {
	private static Log logger = LogFactory.getLog(DAACompensateViewHelper.class);

	private UICodeAction uiCodeAction = new UICodeAction();

	/**
	 * 取初始化信息需要的数据的整理. 填写实赔单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public CompensateDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		return compensateDto;
	}

	/**
	 * 填写实赔页面及查询实赔request的生成.
	 * 填写实赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception {
		// 得到request的PrpLcompensateForm用于显示
		PrpLcompensateDto prpLcompensateDto = compensateDto
				.getPrpLcompensateDto();
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}


	/**
	 * 根据赔款计算书号和保单号,赔案号,案件状态，车牌号码，操作时间查询实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @param policyNo
	 *            保单号
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */

	public void setPrpLcompensateDtoToView(
			HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		// compensateNo,policyNo,claimNo
		// 根据输入的保单号，实赔号生成SQL where 子句
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

		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
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
		// 根据输入的保单号，实赔号生成SQL where 子句
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
		//添加区分新农险标识
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
			//拼案件状态			
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
		
		//从session里取扶贫/大户标志
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

		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		//Collection compensateList = new ArrayList();
		ArrayList compensateList = new ArrayList();
		logger.debug("start to 意健险--conditions--..||" + conditions);
		System.out.println("##########conditions:" +conditions );
		PageRecord pageRecord = (PageRecord)uiCompensateAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
		compensateList = (ArrayList)pageRecord.getResult();
		///compensateList = (Collection) uiCompensateAction
				//.findByQueryConditions(conditions);
		 logger.debug("end search,please waiting for result...");
		
		   TurnPageDto turnPageDto = new TurnPageDto();
	       //查询出来的一页的结构集 
	       turnPageDto.setResultList(compensateList);
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
	 * 根据赔款计算书号和保单号和赔案号查询待复核的实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @param policyNo
	 *            保单号
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */

	public void getApproveCompensateList(HttpServletRequest httpServletRequest,
			String compensateNo, String policyNo, String claimNo)
			throws Exception {
		// compensateNo,policyNo,claimNo
		// 根据输入的保单号，实赔号生成SQL where 子句
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
		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		Collection compensateList = new ArrayList();
		logger.debug("start to怎么回事...");

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
	 * 检查缴费标志 返回值 int -1为未缴费，0为未缴全，1为缴全
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param policyNo
	 *            赔案号
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// 取得赔款计算书信息
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
	 * 查询赔案号对应的实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 *             Modify By wangli 2005-04-20 Reason:查询赔案号对应的实赔信息
	 */

	public void setPrpLcompensateByClaimNoDtoToView(
			HttpServletRequest httpServletRequest, String claimNo)
			throws Exception {

		claimNo = StringUtils.rightTrim(claimNo);
		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("claimNo", claimNo, "=");

		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		Collection compensateList = new ArrayList();
		logger.debug("start to search,please waiting ...");
		compensateList = (Collection) uiCompensateAction
				.findByClaimNo(conditions);

		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);

		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

		// 判断出险驾驶员是否非约定驾驶员
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
		// 取出出险驾驶员的姓名
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
				driverFlag = "true";// 约定了驾驶员
				break;
			}
		}

		// 如果保单没有约定，出险时录入,算约定 2005-9-19
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
	 * 根据赔款计算书号和保单号和赔案号查询实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @param policyNo
	 *            保单号
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */

	public void searchPassCompensate(HttpServletRequest httpServletRequest, String compensateNo, String policyNo,
			String claimNo, String operateDate, String underWriteFlag, String pageNo, String recordPerPage)
			throws Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		// compensateNo,policyNo,claimNo
		// 根据输入的保单号，实赔号生成SQL where 子句
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
		// 拼权限
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
		// 查询实赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		ArrayList compensateList = new ArrayList();

		PageRecord pageRecord = (PageRecord) uiCompensateAction.findByConditions(conditions, pageNo, recordPerPage);

		compensateList = (ArrayList) pageRecord.getResult();

		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(compensateList);
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
		prpLcompensateDto.setTurnPageDto(turnPageDto);

		// prpLcompensateDto.setCompensateList(compensateList);

		prpLcompensateDto.setEditType(httpServletRequest.getParameter("editType"));
		// httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

	}
}