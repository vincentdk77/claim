package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.dbsvr.jf.DBPrpJplanFee;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: EndcaseViewHelper</p>
 * <p>Description:结案ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

public class DAAEndcaseViewHelper extends EndcaseViewHelper {
	/**
	 * 默认构造方法
	 */
	public DAAEndcaseViewHelper() {
	}

	//2011商业险平台交互
	public ArrayList getRecaseList(String claimNo) throws Exception {
		
		boolean blnReturn = false;   //为false为无重开 或 重开已结案
		String conditions=" claimNo = '"+claimNo+"'";
		int maxSerialNo = 0;
		
		UIRecaseAction   uiRecaseAction = new UIRecaseAction();
		Collection   list = uiRecaseAction.findByConditions(conditions);
		ArrayList prpLrecaseDtoList = null;
		if (list != null && list.size()>0) {
			maxSerialNo = uiRecaseAction.getMaxSerialNo(claimNo);
			String conditions1=" claimno='"+claimNo+"' and serialNo='"+maxSerialNo+"'";
			prpLrecaseDtoList=(ArrayList)uiRecaseAction.findByConditions(conditions1);			
		}
	return prpLrecaseDtoList;
	}
	
	
	/**
	 * 保存结案时结案页面数据整理.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return endcaseDto 结案数据传输数据结构
	 * @throws Exception
	 */
	public EndcaseDto viewToDto(HttpServletRequest httpServletRequest,boolean stepFlag) throws Exception {
		//继承对endcase,endcaseText表的赋值
		EndcaseDto endcaseDto = super.viewToDto(httpServletRequest, stepFlag);
		String claimNo1 = (String) httpServletRequest.getParameter("prpLclaimClaimNo"); //赔案号
		//String claimNo1 = (String) httpServletRequest.getAttribute("claimNo"); //赔案号
		String caseNo1 = (String) httpServletRequest.getAttribute("caseNo"); //陪案号
		String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");//报案号码
		//取得立案信息
		UIClaimAction uIClaimAction = new UIClaimAction();
		ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo1.trim());
		//根据查询出来的数据内容，给PrpLcaseNoDto赋值
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = claimDto.getPrpLclaimDto();
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
//		取得当前用户信息，写操作员信息到结案中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	
		if ( this.isRecase(claimNo1)==false){  //如果是重开赔案的结案，不回写立案表，这里照原样赋值，相当于没有重写
		
		if (stepFlag == true) {
			
			if (caseNo1 != null && caseNo1.length() > 1) {
				prpLclaimDto.setCaseNo(caseNo1.trim());
			} else {
				prpLclaimDto.setCaseNo(null);
			}
			//modify by lixiang start 2006-02-14
			//reason:因为结案时间是不能被改变的。。所以只在保存的时候生成一次时间，如是赔案号生成，就不需要修改
			prpLclaimDto.setCaseType("2"); //设置案件类型 2为正常结案
			//modify by lixiang end 2006-02-14        
			//下面这行代码是干吗的???    2005-09-07
			//prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumPaid"))));
           
			
				prpLclaimDto.setEndCaserCode(user.getUserCode());
				prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
				endcaseDto.setPrpLclaimDto(prpLclaimDto);
			
		}

		if (stepFlag == true && caseNo1 != null) {
			//取得赔款计算书信息
			UICompensateAction uICompensateAction = new UICompensateAction();
			String conditions = "claimNo ='" + claimNo1.trim() + "'";
			ArrayList arrayCompensate = (ArrayList) uICompensateAction.findByConditions(conditions);
			
			for (int j = 0; j < arrayCompensate.size(); j++) {
				PrpLcompensateDto prpLcompensateDto = null;
				prpLcompensateDto = (PrpLcompensateDto) arrayCompensate.get(j);
				prpLcompensateDto.setCaseNo(caseNo1);
			}
			
			/*
			 UIEndcaseAction uiEndcaseAction = new UIEndcaseAction(); ;
			 ArrayList arrayCaseNo = (ArrayList)uiEndcaseAction.findByConditions(conditions);
			 if(arrayCaseNo != null){
			 for(int i = 0;i<arrayCaseNo.size();i++){
			 PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
			 prpLcaseNoDto = (PrpLcaseNoDto)arrayCaseNo.get(i);
			 for(int j = 0;j<arrayCompensate.size();j++){
			 PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
			 prpLcompensateDto = (PrpLcompensateDto)arrayCompensate.get(j);
			 if(prpLcompensateDto.getCompensateNo().equals(prpLcaseNoDto.getCertiNo()))
			 prpLcompensateDto.setCaseNo(prpLcaseNoDto.getCaseNo());
			 }
			 }
			 }
			 */
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			
			prplreturnvisitswflogDto = daaReturnVisitViewHelper.setReturnVisitSwflogDto(httpServletRequest, registNo, "endca", "0");

			endcaseDto.setPrpLcompensateDtoList(arrayCompensate);
		 }
		
		
	 }//非重开赔案
	  //重开赔案的需回写 prplrecase表
	else{
			int maxSerialNo =0;
		    ReCaseDto reCaseDto = new ReCaseDto();
		    UIRecaseAction uiRecaseAction =new UIRecaseAction();
		    
		    maxSerialNo = uiRecaseAction.getMaxSerialNo(claimNo1);
		    reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo1,maxSerialNo);
		    		  
		    PrpLrecaseDto prpLrecaseDto =  reCaseDto.getPrpLrecaseDto();	
		    prpLrecaseDto.setCloseCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
		    prpLrecaseDto.setCloseCaseUserCode(user.getUserCode());
			
		    endcaseDto.setPrpLrecaseDto(prpLrecaseDto);
		    endcaseDto.setPrpLclaimDto(prpLclaimDto);
			
		}
		//自动生成结案回访数据
		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
		PrplreturnvisitswflogDto prplreturnvisitswflog = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, "endca");
		if(prplreturnvisitswflog == null){
			endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
		}
		return endcaseDto;
	}

	/**
	 * 生成陪案信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param caseNo     陪案号
	 * @param editType   编辑类型
	 * @param claimNo    赔案号
	 * @param certiNo    单证名称
	 * @param certiType  单证类型
	 * @throws Exception
	 */
	public void endcaseDtoView(HttpServletRequest httpServletRequest,
			String caseNo, String editType, String claimNo, String certiNo,
			String certiType) throws Exception {
		//取得当前用户信息，写操作员信息到结案中
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(caseNo,
				claimNo, certiNo, certiType);

		//System.out.println(":::::::prplclaimdto:::::::caseno::=" + caseNo+":::::claimNo::="+claimNo+":::::::certiNo::="+certiNo+ "-------certiType--"+certiType);
		//根据查询出来的数据内容，给PrpLcaseNoDto赋值
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = endcaseDto.getPrpLclaimDto();
		//设置结案操作的状态为 案件修改 (正处理任务)
		if (endcaseDto.getPrpLclaimStatusDto() != null) {
			if (endcaseDto.getPrpLclaimStatusDto().getStatus().equals("7"))
				endcaseDto.getPrpLclaimStatusDto().setStatus("3");
			prpLcaseNoDto.setStatus(endcaseDto.getPrpLclaimStatusDto()
					.getStatus());
		} else {
			//已提交，已经处理完毕的状态
			prpLcaseNoDto.setStatus("4");
		}

		//给陪案文件多行列表准备数据
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		if (endcaseDto.getPrpLltextDtoList() != null
				&& endcaseDto.getPrpLltextDtoList().size() > 0) {
			prpLltextDto = (PrpLltextDto) endcaseDto.getPrpLltextDtoList().get(
					0);
		}
		prpLltextDto.setTextType("08");
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);

		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLclaimDto);

		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest, prpLcaseNoDto);

		//设置主结案信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);

		//在界面上显示险种名称 2005-09-09
		UICodeAction uiCodeAction = new UICodeAction();
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest, endcaseDto);
		
		
		   //add by zhaolu start at 2006-06-10
		  //reason 强制保单关联信息写到结案中
			System.out.println("强制保单关联信息写到结案中------------------224");
			RegistDto registDto = new RegistDto();
			System.out.println(registDto.getPrpLRegistRPolicyList().size());
			System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
	}

	/**
	 * 生成陪案信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo    赔案号
	 * @throws Exception
	 */
	public void endcaseDtoView(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		
		//取得报案的信息
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(claimNo);

		//根据查询出来的数据内容，给PrpLcaseNoDto赋值
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = endcaseDto.getPrpLclaimDto();
		//查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto
				.getRegistNo());
		
		   //add by zhaolu start at 2006-06-10
		   //reason 强制保单关联信息写到结案中
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
		
		
		prpLclaimDto.setClaimType(registDto.getPrpLregistDto().getClaimType());
		
		//查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLclaimDto
				.getPolicyNo(), prpLclaimDto.getDamageStartDate().toString(),
				prpLclaimDto.getDamageStartHour());

		prpLclaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
		prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto()
				.getHandler1Code());
		prpLclaimDto.setStartDate(new DateTime(policyDto.getPrpCmainDto()
				.getStartDate().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimDto.setEndDate(new DateTime(policyDto.getPrpCmainDto()
				.getEndDate().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
		prpLclaimDto
				.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
		prpLclaimDto
				.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
		prpLclaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
		prpLclaimDto.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
		prpLclaimDto.setBusinessNature(policyDto.getPrpCmainDto()
				.getBusinessNature());
		prpLclaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
		prpLclaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
		prpLclaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
		if(!"05".equals(policyDto.getPrpCmainDto().getClassCode())){
			prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate(),DateTime.YEAR_TO_DAY));
			prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(),DateTime.YEAR_TO_SECOND));
		}
		UICodeAction uiCodeAction = new UICodeAction();
		prpLclaimDto.setRiskCodeName(uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(),true));
		PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
		if (policyDto.getPrpCitemCarDtoList().size() > 0) {
			//对车型等信息的支持
			PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList()
					.get(0);
			prpLclaimDto.setClauseType(PrpCitemCarDto.getClauseType());
			prpLclaimDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
			prpLclaimDto.setLicenseColorCode(PrpCitemCarDto
					.getLicenseColorCode());
			prpLclaimDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
			prpLclaimDto.setBrandName(PrpCitemCarDto.getBrandName());
			prpLclaimDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
		}

		//设置结案操作的状态为 新案件登记 (未处理任务)
		prpLcaseNoDto.setStatus("1");

		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLclaimDto);
		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest, prpLcaseNoDto);
		//设置主结案信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//设置立案信息内容到窗体表单
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);

		//在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//设置各个子表信息项到窗体表单
		//setSubInfo(httpServletRequest, endcaseDto);
		//modify by zhaozhuo add 20050331 start
		//reason: 查询出预赔登记号
		UIPrepayAction uiPrepayAction = new UIPrepayAction();
		PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
		String strpreCompensateNo = "";
		String strSql = " claimNo='" + prpLclaimDto.getClaimNo() + "'";
		Collection PreCompensateNoList = new ArrayList();
		PreCompensateNoList = uiPrepayAction.findByConditions(strSql);

		Iterator prepay = PreCompensateNoList.iterator();
		if (prepay.hasNext()) {
			prpLprepayDto = (PrpLprepayDto) prepay.next();
		}
		strpreCompensateNo = prpLprepayDto.getPreCompensateNo();
		prpLcaseNoDto.setPreCompensateNo(strpreCompensateNo);
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//modify by zhaozhuo add 20050331 end
		//modify by zhaozhuo add 20050404 start
		//reason:查出赔款计算书号码
		UICompensateAction uiCompensateAction = new UICompensateAction();
		String strcompensateNo = "";
		Collection CompensateNoList = new ArrayList();
		CompensateNoList = uiCompensateAction.findByConditions(strSql);
		for (int i = 0; i < CompensateNoList.size(); i++) {
			strcompensateNo = strcompensateNo
					+ ((PrpLcompensateDto) ((ArrayList) CompensateNoList)
							.get(i)).getCompensateNo();
		}
		prpLcaseNoDto.setCompensateNo(strcompensateNo);
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//modify by zhaozhuo add 20050404 end
		// 打印结案报告中多行文字准备
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (endcaseDto.getPrpLcompensateDtoList() != null) {
				Iterator iterator = endcaseDto.getPrpLltextDtoList().iterator();
				while (iterator.hasNext()) {
					PrpLltextDto prpLltextDto = (PrpLltextDto) iterator.next();
					if (prpLltextDto.getTextType().equals("08")) {
						tempContext = tempContext + prpLltextDto.getContext();
					}
				}
		}
		if(endcaseDto.getPrpLltextDtoList3() != null){
			httpServletRequest.setAttribute("prpLltextDtoList3", endcaseDto.getPrpLltextDtoList3());
		}
	int intCtextCountTmp = 0; // textarea行数
	int index = 0;
	int x = 0;
	int y = 0;
		for (index = 0; index < tempContext.length(); index++) {
			if (tempContext.substring(index, index + 1).equals("\\")) {
				if (!(tempContext.substring(index).length() < 4)) {
					if (tempContext.substring(index, index + 4)
							.equals("\\r\\n")) {
						intCtextCountTmp += 1; // 只要有回车换行，intCtextCountTmp+1
					}
				}
			}
		}
		if (!(tempContext.length() < 4)) // 如果strContext.length()>=4，判断strContext结尾是文字，还是回车换行
		{
			x = tempContext.length() - 4;
			y = tempContext.length();
			if (!tempContext.substring(x, y).equals("\\r\\n")) {
				intCtextCountTmp += 1;
			}
		} else{
			intCtextCountTmp = 1;
		}
		// 设值文本的内容
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		prpLltextDto.setContext(tempContext);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		tempContext = StringUtils.replace(tempContext, "\r\n", "<br>&nbsp;");
		httpServletRequest.setAttribute("tempContext", tempContext);
	}

	/**
	 * 填写结案页面及查询结案request的生成.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @param editType
	 *            编辑类型
	 * @throws Exception
	 */
	public void claimDtoToView(HttpServletRequest httpServletRequest,
			String claimNo, String editType) throws Exception {
		//取得当前用户信息，写操作员信息到结案中
		DateTime.setDateDelimiter("-");
		UIClaimAction uIClaimAction = new UIClaimAction();
		ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo);

		//根据查询出来的数据内容，给PrpLcaseNoDto赋值
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = claimDto.getPrpLclaimDto();

		//查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto
				.getRegistNo());
		   //add by zhaolu start at 2006-06-10
		  //reason 强制保单关联信息写到结案中
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
			
		prpLclaimDto.setClaimType(registDto.getPrpLregistDto().getClaimType());

		//查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLclaimDto
				.getPolicyNo(), prpLclaimDto.getDamageStartDate().toString(),
				prpLclaimDto.getDamageStartHour());

		prpLclaimDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
		prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto()
				.getHandler1Code());
		prpLclaimDto.setStartDate(new DateTime(policyDto.getPrpCmainDto()
				.getStartDate().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimDto.setEndDate(new DateTime(policyDto.getPrpCmainDto()
				.getEndDate().toString(), DateTime.YEAR_TO_DAY));
		prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
		prpLclaimDto
				.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
		prpLclaimDto
				.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
		prpLclaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
		prpLclaimDto.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
		prpLclaimDto.setBusinessNature(policyDto.getPrpCmainDto()
				.getBusinessNature());
		prpLclaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
		prpLclaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
		prpLclaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
		if(!"05".equals(policyDto.getPrpCmainDto().getClassCode())){
			prpLclaimDto.setClaimDate(new DateTime(prpLclaimDto.getClaimDate().toString(),DateTime.YEAR_TO_DAY));
			prpLclaimDto.setClaimTime(new DateTime(prpLclaimDto.getClaimTime(),DateTime.YEAR_TO_SECOND));
			prpLclaimDto.setEndCaseDate(new DateTime(prpLclaimDto.getEndCaseDate().toString(),DateTime.YEAR_TO_SECOND));
		}
		PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
		if (policyDto.getPrpCitemCarDtoList().size() > 0) {
			//对车型等信息的支持
			PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList()
					.get(0);
			prpLclaimDto.setClauseType(PrpCitemCarDto.getClauseType());
			prpLclaimDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
			prpLclaimDto.setLicenseColorCode(PrpCitemCarDto
					.getLicenseColorCode());
			prpLclaimDto.setLicenseColor(PrpCitemCarDto.getLicenseColorCode());
			prpLclaimDto.setBrandName(PrpCitemCarDto.getBrandName());
			prpLclaimDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
		}

		//设置结案操作的状态为 新案件登记 (未处理任务)
		prpLcaseNoDto.setStatus("1");

		//结案报告初始带出理算报告------------------------------------
		
		String tempContext = "";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		EndcaseDto endcaseDto = new EndcaseDto();
		UIEndcaseAction uiEndCaseAction = new UIEndcaseAction();
		endcaseDto = uiEndCaseAction.findByPrimaryKey(claimNo);
		if (endcaseDto.getPrpLcompensateDtoList() != null) {
			Iterator iterator = endcaseDto.getPrpLltextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLltextDto prpLltextDto = (PrpLltextDto) iterator.next();
				if (prpLltextDto.getTextType().equals("08")) {
					tempContext = tempContext + prpLltextDto.getContext();
				}
			}
		}
		// 设值文本的内容
		Collection arraylTextList = new ArrayList();
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		prpLltextDto.setTextType("08");
		prpLltextDto.setContext(tempContext);
		prpLltextDto.setLtextList(arraylTextList);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		
		//详细出险原因信息
		if(endcaseDto.getPrpLltextDtoList3().size() > 1){
			httpServletRequest.setAttribute("prpLltextDtoList3", endcaseDto.getPrpLltextDtoList3());
		}
		
		//结案时，回写立案表的总赔付金额
		double sumPaid = 0; //总赔付金额
	//	UICompensateAction uiCompensateAction = new UICompensateAction();
		String strCondition = "";
		strCondition = " ClaimNo ='" + claimNo + "'";
		//核赔通过的赔款计算书才计算在内
		strCondition += " AND  UnderWriteFlag = '1'";
		Collection compensateListTemp = uiCompensateAction
				.findByConditions(strCondition);
		Iterator iTemp = compensateListTemp.iterator();
		while (iTemp.hasNext()) {
			PrpLcompensateDto prpLcompensateDtoTemp = (PrpLcompensateDto) iTemp
					.next();
			sumPaid = sumPaid + prpLcompensateDtoTemp.getSumThisPaid() + prpLcompensateDtoTemp.getSumPrePaid();
		}
		prpLclaimDto.setSumPaid(sumPaid);

		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLclaimDto);
		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest, prpLcaseNoDto);
		//设置主结案信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//设置立案信息内容到窗体表单
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);

		//在界面上显示险种名称 2005-09-09
		UICodeAction uiCodeAction = new UICodeAction();
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//设置各个子表信息项到窗体表单
		
		//endcaseDto.setPrpLltextDtoList(claimDto.getPrpLltextDtoList());
		//setSubInfo(httpServletRequest, endcaseDto);
	}

	/**
	 * 根据赔案号和报案号查询结案信息
	 * @param httpServletRequest 返回给页面的request
	 * @param registNo      赔案号
	 * @param claimNo       报案号
	 * @throws Exception
	 */
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//caseNO,policyNo,claimNo
		//根据输入的保单号，结案号生成SQL where 子句
		String caseNo = StringUtils.rightTrim(workFlowQueryDto.getCaseNo());
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String comCode = StringUtils.rightTrim(workFlowQueryDto.getComCode());
		String claimDate = StringUtils.rightTrim(workFlowQueryDto.getClaimDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName()); 
		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("claimNo", claimNo,
						workFlowQueryDto.getClaimNoSign());
		conditions = conditions
				+ StringConvert.convertString("caseNo", caseNo,
						workFlowQueryDto.getCaseNoSign());
		conditions = conditions
				+ StringConvert.convertString("policyno", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		conditions = conditions
				+ StringConvert.convertString("licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("comCode", comCode,
						workFlowQueryDto.getComCodeSign());
		conditions = conditions
				+ StringConvert.convertString("insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (claimDate != null && !claimDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("claimDate", claimDate,
							workFlowQueryDto.getClaimDateSign());
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("endcaseDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		conditions = conditions + "and endCaserCode is not null and endCaseDate is not null";

		//查询立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();

		//得到多行结案主表信息
		Collection endcaseList = new ArrayList();
		endcaseList = (Collection) uiClaimAction.findByConditions(conditions);

		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);

		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}
     
	//add by zhaolu 20060803 start
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,int pageNo,int recordPerPage) throws Exception {
		//caseNO,policyNo,claimNo
		//根据输入的保单号，结案号生成SQL where 子句
		String nodeTypeTemp     = httpServletRequest.getParameter("nodeType");
		String caseNo = StringUtils.rightTrim(workFlowQueryDto.getCaseNo());
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String operateDateEnd = StringUtils.rightTrim(workFlowQueryDto.getOperateDateEnd());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String comCode = StringUtils.rightTrim(workFlowQueryDto.getComCode());
		String claimDate = StringUtils.rightTrim(workFlowQueryDto.getClaimDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName()); 
		String queryRiskCode = httpServletRequest.getParameter("queryRiskCode");
		String conditions = " 1=1 ";
		//添加区分新农险标识
		conditions = conditions + " and (registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeTypeTemp+"') ";
		conditions = conditions + " or registno in (select registno from swflogstore where (systemflag is null or systemflag <> 'agri') and nodetype='"+nodeTypeTemp+"')) ";
		conditions = conditions
				+ StringConvert.convertString("claimNo", claimNo,
						workFlowQueryDto.getClaimNoSign());
		conditions = conditions
				+ StringConvert.convertString("caseNo", caseNo,
						workFlowQueryDto.getCaseNoSign());
		conditions = conditions
				+ StringConvert.convertString("policyno", policyNo,
						workFlowQueryDto.getPolicyNoSign());
		conditions = conditions
				+ StringConvert.convertString("licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());
		conditions = conditions
				+ StringConvert.convertString("comCode", comCode,
						workFlowQueryDto.getComCodeSign());
		conditions = conditions
				+ StringConvert.convertString("insuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		conditions = conditions
    	        + StringConvert.convertString("riskcode",
		                 queryRiskCode, "=");

		if (claimDate != null && !claimDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("claimDate", claimDate,
							workFlowQueryDto.getClaimDateSign());
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("endcaseDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		if (operateDateEnd != null && !operateDateEnd.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("endcaseDate", operateDateEnd,
							workFlowQueryDto.getOperateDateSignEnd());
		}
		//从session里取扶贫/大户标志
        String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
        if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
      	  if(strHPflag.equals("Large")) {
      		  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2')) ";
      	  }
            if(strHPflag.equals("Retaol")) {
          	  conditions = conditions +  " and policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1')) ";
      	  }
        }
        
		conditions = conditions + "and endCaserCode is not null and endCaseDate is not null";

		//查询立案信息
		 String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	        }
		
		UIClaimAction uiClaimAction = new UIClaimAction();

		//得到多行结案主表信息
		//Collection endcaseList = new ArrayList();
		ArrayList endcaseList = new ArrayList();
		 PageRecord pageRecord = (PageRecord)uiClaimAction.findByConditions(conditions,pageNo,recordPerPage);
		 endcaseList = (ArrayList)pageRecord.getResult();
		//endcaseList = (Collection) uiClaimAction.findByConditions(conditions);
		TurnPageDto turnPageDto = new TurnPageDto();
	       //查询出来的一页的结构集 
	       turnPageDto.setResultList(endcaseList);
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
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);
		prpLcaseNoDto.setTurnPageDto(turnPageDto);
		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}
	//add by zhaolu 20060803 end
	
	
	
	
	/**
	 * 根据endcaseDto中的各子表内的信息填充界面
	 * @param httpServletRequest 返回给页面的request
	 * @param endcaseDto    结案的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception {
		//[结案信息]结案报告多行列表准备数据
		/*
		 Collection arrayLTextList = new ArrayList();
		 PrpLltextDto prpLltextDto  = new PrpLltextDto();
		 prpLltextDto.setTextType("08") ;
		 arrayLTextList  = endcaseDto.getPrpLltextDtoList() ;
		 prpLltextDto.setLtextList(arrayLTextList) ;
		 httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		 */
		//给报案文件多行列表准备数据
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		String tempContext = "";
		if (endcaseDto.getPrpLltextDtoList() != null) {
			Iterator iterator = endcaseDto.getPrpLltextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
				tempContext = tempContext + prpLltextDtoTemp.getContext();
			}
			
		}
		
		
		
		//prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(0);
		prpLltextDto.setContext(tempContext);
		prpLltextDto.setTextType("08");
		//prpLregistTextDto.setRegistTextList(registDto.getPrpLregistTextDtoList());
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		//add by liubvo

	}

	/**
	 * 获取选择框和列表框中的所有内容
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    结案的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLcaseNoDto prpLcaseNoDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//结案性质列表
		Collection endcaseNatures = uiCodeAction.getCodeType("EndcaseNature",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("endcaseNatures", endcaseNatures);
		//赔案类别
		Collection caseCodes = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("caseCodes", caseCodes);
		//出险地点分类
		Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("damageAddresss", damageAddresss);
		//事故赔偿责任
		Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);

		//得到实赔类型列表
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		//得到案件种类列表列表
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		//得到出险地址类型列表
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		//得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//得到车牌底色列表
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		//得到赔偿责任列表
		Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
		//得到赔案类别列表
		Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("escapeFlags", escapeFlags);
		//得到得到性别
		Collection driverSex = uiCodeAction.getCodeType("SexCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("driverSexs", driverSex);
		//得到职业分类
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		//得到文化程度
		Collection education = uiCodeAction.getCodeType("Education",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("educations", education);
	}

	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    结案的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLclaimDto prpLclaimDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//业务性质
		String businessNature = prpLclaimDto.getBusinessNature();
		String businessNatureName = uiCodeAction.translateCodeCode(
				"BusinessNature", businessNature, true);
		prpLclaimDto.setBusinessNature(businessNatureName);
		//业务性质
		String language = prpLclaimDto.getLanguage();
		String languageName = uiCodeAction.translateCodeCode("Language",
				language, true);
		prpLclaimDto.setLanguage(languageName);

		//(1)条款名称的转换
		String clauseType = prpLclaimDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLclaimDto.setClauseName(clauseName);
		//(2)号牌颜色转换
		String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor",
				licenseColorCodeCode, true);
		prpLclaimDto.setLicenseColor(licenseColor);
		//(3)车辆类型转换
		String carKindCode = prpLclaimDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode,
				true);
		prpLclaimDto.setCarKind(carKind);
		//(4)赔偿责任类型转换
		String indemnityDuty = prpLclaimDto.getIndemnityDuty();
		String indemnityDutyName = uiCodeAction.translateCodeCode(
				"IndemnityDuty", indemnityDuty, true);
		prpLclaimDto.setIndemnityDutyName(indemnityDutyName);
		//(5)赔案类别转换
		String claimType = prpLclaimDto.getEscapeFlag();
		if (claimType != null && claimType.trim().length() > 0) {
			claimType = new Character(claimType.charAt(0)).toString();
			String claimTypeName = uiCodeAction.translateCodeCode("CaseCode",
					claimType, true);
			prpLclaimDto.setClaimTypeName(claimTypeName);
		}
		//(6)对业务归属结构进行转换
		String comCode = prpLclaimDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLclaimDto.setComName(comName);
		//(7)理赔登记机构名称进行转换
		String makeCom = prpLclaimDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeCom, true);
		prpLclaimDto.setMakeComName(makeComName);
		//(8)对归属业务员进行转换
		String handler1Code = prpLclaimDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLclaimDto.setHandler1Name(handler1Name);
		//(9)对代理人进行转换
		String agentCode = prpLclaimDto.getAgentCode();
		String agentName = uiCodeAction.translateUserCode(agentCode, true);
		prpLclaimDto.setAgentName(agentName);
		//(10)对经办人进行转换
		String handlerCode = prpLclaimDto.getHandlerCode();
		String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
		prpLclaimDto.setHandlerName(handlerName);
		//(11)对操作员名称进行转换
		String operatorCode = prpLclaimDto.getOperatorCode();
		String userName = uiCodeAction.translateUserCode(operatorCode, true);
		prpLclaimDto.setOperatorName(userName);
	}

	/**
	 * 取初始化信息需要的数据的整理.
	 * 填写结案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public EndcaseDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		EndcaseDto endcaseDto = new EndcaseDto();
		return endcaseDto;
	}

	/**
	 * 填写结案页面及查询结案request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param endcaseDto 取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception {
	}

	/**
	 * 检查是否还有未通过的赔款计算书
	 * 返回值   0：没有赔款计算书  -1:还有未通过的赔款计算书  1：所有的赔款计算书都已经通过 2:垫付结案
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public int checkCompensate(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		//取得赔款计算书信息
		int compensateFlag= 1 ;
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			//return 0;
			//如果是垫付情况下，应该允许结案的。所以还需要判断是否有垫付的情况。
//			UIPrepayAction uiPrepayAction = new UIPrepayAction ();	
//			conditions = conditions + " and caseType='8'";
//			ArrayList prepayList = (ArrayList)uiPrepayAction.findByConditions(conditions);
			compensateFlag =0;
//			if (prepayList!=null&&prepayList.size()>0){
//				compensateFlag =2; //如果有垫付的情况，可以进行结案操作。
//			}
			
		}
		if (arraylist != null) {
			for (int i = 0; i < arraylist.size(); i++) {
				PrpLcompensateDto prpLcompensateDto = null;
				prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
				if (!(prpLcompensateDto.getUnderWriteFlag().equals("1") || prpLcompensateDto.getUnderWriteFlag().equals("3") )) {
					
					//return -1;
					compensateFlag =-1;
				}
			}
		}
		return compensateFlag ;
	}

	//modify by liuyanmei add 20051110 start ---------------------------
	//reason:交验是否已经录入支付信息，没有的话不能结案（由于特殊情况没有遵循层次调用之间的约定。）    
	public int checkPlanFeeFlag(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {

		int intReturn = 1;
		String conpensateNo = "";
		DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee();
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			return 0;
		}
		if (arraylist != null) {
			for (int i = 0; i < arraylist.size(); i++) {

				PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) arraylist
						.get(i);
				conpensateNo = prpLcompensateDto.getCompensateNo();
				String conditions2 = "select *  from PrpJplanFee where  certiNo='"
						+ conpensateNo + "'";
				Vector planFee = (Vector) dbPrpJplanFee
						.findByConditions(conditions2);
				if (planFee == null) {
					intReturn = 0;
					break;
				} else {
					intReturn = 1;

				}
			}
		}
		return intReturn;
	}

	//modify by liuyanmei add 20051110 end --------------------------- 

	/**
	 * 生成陪案号的功能
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public PrpLcaseNoDto compensateDtoToView(HttpServletRequest httpServletRequest, String claimNo)	throws Exception {
		String caseNo = ""; //赔案号
		String policyNo = ""; //保单号
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");

		//生成赔案号
//		UIBillAction uiBillAction = new UIBillAction();
//		String tableName = "prplcaseno";
//		String comCode = user.getComCode();
//		String riskCode = BusinessRuleUtil.getRiskCode(claimNo);
//		int year = DateTime.current().getYear();
//		caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
		
		//生成赔案号
		caseNo = getCaseNo(claimNo,user.getComCode());

		PrpLcaseNoDto prpLcaseNoDtoList = new PrpLcaseNoDto();
		ArrayList arrayCaseNo = new ArrayList();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) new UICompensateAction().findByConditions(conditions);
		if (arraylist != null) {
			for (int i = 0; i < arraylist.size(); i++) {
				PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
				prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
				PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
				prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
				prpLcaseNoDto.setSumPaid(prpLcompensateDto.getSumPaid());

				prpLcaseNoDto.setCaseNo(caseNo);
				prpLcaseNoDto.setCertiType("C");
				prpLcaseNoDto.setFlag("");
				prpLcaseNoDto.setClaimNo(claimNo.trim());
				policyNo = prpLcompensateDto.getPolicyNo();
				arrayCaseNo.add(prpLcaseNoDto);
			}
		}
		prpLcaseNoDtoList.setCaseList(arrayCaseNo);
		prpLcaseNoDtoList.setPolicyNo(policyNo);
		prpLcaseNoDtoList.setClaimNo(claimNo);
		//使用最后一个陪案号码
		prpLcaseNoDtoList.setCaseNo(caseNo);
		//httpServletRequest.setAttribute("prpLcaseNoDto",prpLcaseNoDtoList);
		httpServletRequest.getSession().setAttribute("prpLcaseNoDto",prpLcaseNoDtoList);
		return prpLcaseNoDtoList;
	}

	public String getCaseNo(String claimNo,String comCode) throws Exception{
		String tableName = "prplcaseno";
		String riskCode = BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
		int year = DateTime.current().getYear();
		UIBillAction uiBillAction = new UIBillAction();
		String caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
		return caseNo;
	}
	
	/**
	 * 根据赔案号,报案号,案件状态，车牌号码，操作时间查询结案信息
	 * @param httpServletRequest 返回给页面的request
	 * @param registNo      赔案号
	 * @param claimNo       报案号
	 * @throws Exception
	 * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			String caseNo, String claimNo, String policyNo, String licenseNo,
			String status, String operateDate) throws Exception {
		//caseNO,policyNo,claimNo
		//根据输入的保单号，结案号生成SQL where 子句
		caseNo = StringUtils.rightTrim(caseNo);
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		status = StringUtils.rightTrim(status);
		operateDate = StringUtils.rightTrim(operateDate);
		String strSign = httpServletRequest.getParameter("OperateDateSign");

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.claimNo", claimNo,
						httpServletRequest.getParameter("ClaimNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.caseNo", caseNo,
						httpServletRequest.getParameter("CaseNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.policyNo", policyNo,
						httpServletRequest.getParameter("PolicyNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLRegist.licenseNo",
						licenseNo, httpServletRequest
								.getParameter("LicenseNoSign"));
		conditions = conditions
				+ StringConvert.convertDate("PrpLclaim.EndCaseDate",
						operateDate, strSign);
		conditions = conditions
				+ " and PrpLclaim.endCaserCode is not null and PrpLclaim.endCaseDate is not null";
		//     拼权限
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");

		//查询立案信息
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

		//得到多行结案主表信息
		Collection endcaseList = new ArrayList();
		endcaseList = (Collection) uiEndcaseAction
				.findByQueryConditions(conditions);
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);
		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}

	//modify by liuyanmei add 20051107 start 
	//reason:结案查询增加承保机构、立案时间；和上面那个函数一样，参数不一样，由于担心别的地方引用上面那个函数，所以增加重载函数。
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			String caseNo, String claimNo, String policyNo, String licenseNo,
			String status, String operateDate, String comCode, String claimDate)
			throws Exception {
		//caseNO,policyNo,claimNo
		//根据输入的保单号，结案号生成SQL where 子句
		caseNo = StringUtils.rightTrim(caseNo);
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		status = StringUtils.rightTrim(status);
		operateDate = StringUtils.rightTrim(operateDate);
		String strSign = httpServletRequest.getParameter("OperateDateSign");
		comCode = StringUtils.rightTrim(comCode);
		claimDate = StringUtils.rightTrim(claimDate);
		String claimDateSign = httpServletRequest.getParameter("claimDateSign");

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.claimNo", claimNo,
						httpServletRequest.getParameter("ClaimNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.caseNo", caseNo,
						httpServletRequest.getParameter("CaseNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.policyNo", policyNo,
						httpServletRequest.getParameter("PolicyNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLRegist.licenseNo",
						licenseNo, httpServletRequest
								.getParameter("LicenseNoSign"));
		conditions = conditions
				+ StringConvert.convertString("PrpLclaim.comCode", comCode,
						httpServletRequest.getParameter("comCodeSign"));
		conditions = conditions
				+ StringConvert.convertDate("PrpLclaim.EndCaseDate",
						operateDate, strSign);
		conditions = conditions
				+ StringConvert.convertDate("PrpLclaim.inputDate", claimDate,
						claimDateSign);
		conditions = conditions
				+ " and PrpLclaim.endCaserCode is not null and PrpLclaim.endCaseDate is not null";
		//     拼权限
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
		
		
       //mpdify by zhaolu 20060816 end
		//查询立案信息
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

		//得到多行结案主表信息
		Collection endcaseList = new ArrayList();
		endcaseList = (Collection) uiEndcaseAction
				.findByQueryConditions(conditions);
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);
		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}

	//modify by liuyanmei add 20051107 end

	/**
	 * 立案已经结案的不许再进行结案登记
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */ 
	public boolean checkEndcase(String claimNo) throws Exception {
		boolean blnReturn = false;
		//查询立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
		if (prpLclaimDto != null && prpLclaimDto.getClaimNo() != null) {
			if (prpLclaimDto.getEndCaserCode() != null && prpLclaimDto.getEndCaserCode().trim().length() > 0) {
				
				blnReturn = true;
			}
		}
		return blnReturn;
	}
	
	
//add by lym 200603015---------------------------------------------------[START]-	
	public boolean checkRecase(String claimNo) throws Exception {
		
		boolean blnReturn = false; 
		String conditions=" claimNo = '"+claimNo+"'";
		int maxSerialNo = 0;
		
		UIRecaseAction   uiRecaseAction = new UIRecaseAction();
		Collection   list = uiRecaseAction.findByConditions(conditions);
		
		if (list != null && list.size()>0) {
			maxSerialNo = uiRecaseAction.getMaxSerialNo(claimNo);
			ReCaseDto reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo) ;
			PrpLrecaseDto   prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
			if(prpLrecaseDto.getCloseCaseUserCode() !=null &&  prpLrecaseDto.getCloseCaseUserCode().length()>0){
				   blnReturn = true;   //重开已结为true,其他都为false
			}
		
		}
	return blnReturn;
	}
	
	
	
/*	
	public boolean isRecase(String claimNo) throws Exception {
		
		boolean blnReturn = false;   //为false为无重开 或 重开已结案
		String conditions=" claimNo = '"+claimNo+"'";
		int maxSerialNo = 0;
		
		UIRecaseAction   uiRecaseAction = new UIRecaseAction();
		Collection   list = uiRecaseAction.findByConditions(conditions);
		
		if (list != null && list.size()>0) {
			maxSerialNo = uiRecaseAction.getMaxSerialNo(claimNo);
			ReCaseDto reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo) ;
			PrpLrecaseDto   prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
			if(  (prpLrecaseDto.getCloseCaseUserCode()==null ||  prpLrecaseDto.getCloseCaseUserCode().trim().equals("")) 
				&& (prpLrecaseDto.getCloseCaseDate()==null ||  prpLrecaseDto.getCloseCaseDate().isEmpty()) ){
				blnReturn = true;   //有重开，且未结案
				   
			}
		
		}
	return blnReturn;
	} */
//add by lym 200603015----------------------------------------------------[END]
	
	
	/**
	 * 立案已经结案的不许再进行结案登记
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception 
	 */
	public boolean isGenrateCaseNo(String claimNo) throws Exception {
		boolean blnReturn = false;
		//查询立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
	if(claimDto !=null ){
		PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
		if (prpLclaimDto != null && prpLclaimDto.getClaimNo() != null) {
			if (prpLclaimDto.getCaseNo() != null
					&& prpLclaimDto.getCaseNo().trim().length() > 0) {
				blnReturn = true;
			}
		}
	}
	else {
		throw new Exception("赔案号不正确，请输入正确的赔案号");
		
	}
		return blnReturn;
	
	}
}
