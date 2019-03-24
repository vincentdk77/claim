package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLPrpLcaseNoFacade;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>Title: EndcaseViewHelper</p>
 * <p>Description:结案ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */
public abstract class EndcaseViewHelper {
	private int RULE_LENGTH = 70; //rule字段的长度  

	/**
	 * 默认构造方法
	 */
	public EndcaseViewHelper() {
	}

	/**
	 * 保存结案时整理结案页面数据.
	 * 整理采用继承的方式分层处理。
	 * @param httpServletRequest
	 * @return stepFlag 标志
	 * @throws Exception
	 */
	public EndcaseDto viewToDto(HttpServletRequest httpServletRequest,
			boolean stepFlag) throws Exception {
		EndcaseDto endcaseDto = new EndcaseDto();

		
		
		
		/*---------------------赔案号表prpLcaseno------------------------------------*/
		String policyNo = (String) httpServletRequest.getParameter("prpLclaimPolicyNo");
		String claimNo = (String) httpServletRequest.getAttribute("claimNo");
		String caseNo = (String) httpServletRequest.getAttribute("caseNo");
		if (caseNo != null) {
			UICompensateAction uICompensateAction = new UICompensateAction();
			String conditions = "claimNo ='" + claimNo.trim() + "'";
			ArrayList prpLperpayDtoList = new ArrayList();
			ArrayList arraylist = (ArrayList) uICompensateAction.findByConditions(conditions);
			if (arraylist != null) {
				for (int i = 0; i < arraylist.size(); i++) {
					PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
					PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
					prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
					prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
					prpLcaseNoDto.setCertiType("C");
					prpLcaseNoDto.setCaseNo(caseNo.trim());
					prpLcaseNoDto.setFlag("");
					prpLcaseNoDto.setClaimNo(claimNo.trim());
					prpLperpayDtoList.add(prpLcaseNoDto);
					//policyNo = prpLcompensateDto.getPolicyNo();
				}
			}
			endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
		}

		
		if ( this.isRecase(claimNo.trim())==false){ //非重开赔案回写PrpLltextDto
		/*---------------------文本表PrpLltextDto--------------------*/

		/**
		 * 获取结案报告
		 */
		ArrayList prpLltextDtoList = new ArrayList();
		String textTemp = httpServletRequest.getParameter("prpLltextContextInnerHTML");
	    if (textTemp != null) {
			String[] rules = StringUtils.split(textTemp, RULE_LENGTH);
			//得到连接串,下面将其切分到数组
			for (int k = 0; k < rules.length; k++) {
				PrpLltextDto prpLltextDto = new PrpLltextDto();
				prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
				prpLltextDto.setContext(rules[k]);
				prpLltextDto.setLineNo(k + 1);
				//Modify by zhaolu 20060909 start
				//reason对非车险结案报告覆盖理 算报告的问题修改
				//prpLltextDto.setTextType("05");
				//fenglei
				prpLltextDto.setTextType("08");
				//Modify by zhaolu 20060909 end
				prpLltextDtoList.add(prpLltextDto);
			}
			//prepayDto
			endcaseDto.setPrpLltextDtoList(prpLltextDtoList);

		} else {
			if (stepFlag == true) {
				UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
				EndcaseDto endcaseDto1 = uiEndcaseAction.findByPrimaryKey("",claimNo, "", "");
				endcaseDto.setPrpLltextDtoList(endcaseDto1.getPrpLltextDtoList());
			}
		}
	    /**---------------详细出险原因信息-------------------*/
	    String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag");
	       if(strDamageMessage!=null && !strDamageMessage.equals("")){
	    	   ArrayList prpLendcaseTextDtoList3 = new ArrayList();
	    	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage");
	    	   if(damageMessage != null){
		    	   for(int index = 0;index<damageMessage.length;index++){
		    		   PrpLltextDto prpLlTextDto = new PrpLltextDto();
		    		   prpLlTextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
		    		   prpLlTextDto.setLineNo(index+1);
		    		   prpLlTextDto.setContext(damageMessage[index]);
		    		   prpLlTextDto.setTextType(strDamageMessage);
		    		   prpLendcaseTextDtoList3.add(prpLlTextDto);
		    	   }
	    	   }
	    	   endcaseDto.setPrpLltextDtoList3(prpLendcaseTextDtoList3);
	       }

	}//end非重开赔案
		if (caseNo != null) {
			/*---------------------状态内容prpLclaimStatus------------------------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(policyNo);
			prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo"));
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//取得当前用户信息，写操作员信息到结案中
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			prpLclaimStatusDto.setHandlerCode(user.getUserCode());
			prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
			endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		 }
		
		return endcaseDto;
	}

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
	}
	
	//判断结案是否是特俗赔案生成的结案节点
	public boolean isPrepay(String claimNo) throws Exception{
		boolean blnReturn = true;
		String conditions = " claimNo ='"+claimNo+"'";
		BLPrpLcaseNoFacade blPrpLcaseNoFacade = new BLPrpLcaseNoFacade();
		ArrayList prpLcaseNoDtoList = (ArrayList)blPrpLcaseNoFacade.findByConditions(conditions);
		if(prpLcaseNoDtoList.size() > 0){
			blnReturn = false;
		}
		return blnReturn;
	}
	
	/**
	 * 取初始化信息需要的数据的整理.
	 * 填写结案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * @param httpServletRequest
	 * @return RequestDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public abstract EndcaseDto iniViewToDto(
			HttpServletRequest httpServletRequest) throws Exception;

	/**
	 * 填写结案页面及查询结案request的生成.
	 * 填写结案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * @param httpServletRequest 返回给页面的request
	 * @param endcaseDto 取出的初始化信息Dto
	 * @throws Exception
	 */
	public abstract void dtoToView(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception;

}
