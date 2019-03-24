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
 * <p>Description:�᰸ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */
public abstract class EndcaseViewHelper {
	private int RULE_LENGTH = 70; //rule�ֶεĳ���  

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public EndcaseViewHelper() {
	}

	/**
	 * ����᰸ʱ����᰸ҳ������.
	 * ������ü̳еķ�ʽ�ֲ㴦��
	 * @param httpServletRequest
	 * @return stepFlag ��־
	 * @throws Exception
	 */
	public EndcaseDto viewToDto(HttpServletRequest httpServletRequest,
			boolean stepFlag) throws Exception {
		EndcaseDto endcaseDto = new EndcaseDto();

		
		
		
		/*---------------------�ⰸ�ű�prpLcaseno------------------------------------*/
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

		
		if ( this.isRecase(claimNo.trim())==false){ //���ؿ��ⰸ��дPrpLltextDto
		/*---------------------�ı���PrpLltextDto--------------------*/

		/**
		 * ��ȡ�᰸����
		 */
		ArrayList prpLltextDtoList = new ArrayList();
		String textTemp = httpServletRequest.getParameter("prpLltextContextInnerHTML");
	    if (textTemp != null) {
			String[] rules = StringUtils.split(textTemp, RULE_LENGTH);
			//�õ����Ӵ�,���潫���зֵ�����
			for (int k = 0; k < rules.length; k++) {
				PrpLltextDto prpLltextDto = new PrpLltextDto();
				prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
				prpLltextDto.setContext(rules[k]);
				prpLltextDto.setLineNo(k + 1);
				//Modify by zhaolu 20060909 start
				//reason�Էǳ��ս᰸���渲���� �㱨��������޸�
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
	    /**---------------��ϸ����ԭ����Ϣ-------------------*/
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

	}//end���ؿ��ⰸ
		if (caseNo != null) {
			/*---------------------״̬����prpLclaimStatus------------------------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(policyNo);
			prpLclaimStatusDto.setRiskCode(BusinessRuleUtil.getRiskCode(policyNo,"PolicyNo"));
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
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
		
		boolean blnReturn = false;   //ΪfalseΪ���ؿ� �� �ؿ��ѽ᰸
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
				blnReturn = true;   //���ؿ�����δ�᰸
				   
			}
		
		}
	return blnReturn;
	}
	
	//�жϽ᰸�Ƿ��������ⰸ���ɵĽ᰸�ڵ�
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
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
	 * ��д�᰸��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
	 * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * @param httpServletRequest
	 * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public abstract EndcaseDto iniViewToDto(
			HttpServletRequest httpServletRequest) throws Exception;

	/**
	 * ��д�᰸ҳ�漰��ѯ�᰸request������.
	 * ��д�᰸ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param endcaseDto ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public abstract void dtoToView(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception;

}
