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
 * <p>Description:�᰸ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

public class DAAEndcaseViewHelper extends EndcaseViewHelper {
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public DAAEndcaseViewHelper() {
	}

	//2011��ҵ��ƽ̨����
	public ArrayList getRecaseList(String claimNo) throws Exception {
		
		boolean blnReturn = false;   //ΪfalseΪ���ؿ� �� �ؿ��ѽ᰸
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
	 * ����᰸ʱ�᰸ҳ����������.
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * @param httpServletRequest
	 * @return endcaseDto �᰸���ݴ������ݽṹ
	 * @throws Exception
	 */
	public EndcaseDto viewToDto(HttpServletRequest httpServletRequest,boolean stepFlag) throws Exception {
		//�̳ж�endcase,endcaseText��ĸ�ֵ
		EndcaseDto endcaseDto = super.viewToDto(httpServletRequest, stepFlag);
		String claimNo1 = (String) httpServletRequest.getParameter("prpLclaimClaimNo"); //�ⰸ��
		//String claimNo1 = (String) httpServletRequest.getAttribute("claimNo"); //�ⰸ��
		String caseNo1 = (String) httpServletRequest.getAttribute("caseNo"); //�㰸��
		String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");//��������
		//ȡ��������Ϣ
		UIClaimAction uIClaimAction = new UIClaimAction();
		ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo1.trim());
		//���ݲ�ѯ�������������ݣ���PrpLcaseNoDto��ֵ
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = claimDto.getPrpLclaimDto();
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
//		ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	
		if ( this.isRecase(claimNo1)==false){  //������ؿ��ⰸ�Ľ᰸������д������������ԭ����ֵ���൱��û����д
		
		if (stepFlag == true) {
			
			if (caseNo1 != null && caseNo1.length() > 1) {
				prpLclaimDto.setCaseNo(caseNo1.trim());
			} else {
				prpLclaimDto.setCaseNo(null);
			}
			//modify by lixiang start 2006-02-14
			//reason:��Ϊ�᰸ʱ���ǲ��ܱ��ı�ġ�������ֻ�ڱ����ʱ������һ��ʱ�䣬�����ⰸ�����ɣ��Ͳ���Ҫ�޸�
			prpLclaimDto.setCaseType("2"); //���ð������� 2Ϊ�����᰸
			//modify by lixiang end 2006-02-14        
			//�������д����Ǹ����???    2005-09-07
			//prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLclaimSumPaid"))));
           
			
				prpLclaimDto.setEndCaserCode(user.getUserCode());
				prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
				endcaseDto.setPrpLclaimDto(prpLclaimDto);
			
		}

		if (stepFlag == true && caseNo1 != null) {
			//ȡ������������Ϣ
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
		
		
	 }//���ؿ��ⰸ
	  //�ؿ��ⰸ�����д prplrecase��
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
		//�Զ����ɽ᰸�ط�����
		BLPrplreturnvisitswflogFacade blPrplreturnvisitswflogFacade = new BLPrplreturnvisitswflogFacade();
		PrplreturnvisitswflogDto prplreturnvisitswflog = blPrplreturnvisitswflogFacade.findByPrimaryKey(registNo, "endca");
		if(prplreturnvisitswflog == null){
			endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
		}
		return endcaseDto;
	}

	/**
	 * �����㰸��Ϣ��ϸ����
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param caseNo     �㰸��
	 * @param editType   �༭����
	 * @param claimNo    �ⰸ��
	 * @param certiNo    ��֤����
	 * @param certiType  ��֤����
	 * @throws Exception
	 */
	public void endcaseDtoView(HttpServletRequest httpServletRequest,
			String caseNo, String editType, String claimNo, String certiNo,
			String certiType) throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(caseNo,
				claimNo, certiNo, certiType);

		//System.out.println(":::::::prplclaimdto:::::::caseno::=" + caseNo+":::::claimNo::="+claimNo+":::::::certiNo::="+certiNo+ "-------certiType--"+certiType);
		//���ݲ�ѯ�������������ݣ���PrpLcaseNoDto��ֵ
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = endcaseDto.getPrpLclaimDto();
		//���ý᰸������״̬Ϊ �����޸� (����������)
		if (endcaseDto.getPrpLclaimStatusDto() != null) {
			if (endcaseDto.getPrpLclaimStatusDto().getStatus().equals("7"))
				endcaseDto.getPrpLclaimStatusDto().setStatus("3");
			prpLcaseNoDto.setStatus(endcaseDto.getPrpLclaimStatusDto()
					.getStatus());
		} else {
			//���ύ���Ѿ�������ϵ�״̬
			prpLcaseNoDto.setStatus("4");
		}

		//���㰸�ļ������б�׼������
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		if (endcaseDto.getPrpLltextDtoList() != null
				&& endcaseDto.getPrpLltextDtoList().size() > 0) {
			prpLltextDto = (PrpLltextDto) endcaseDto.getPrpLltextDtoList().get(
					0);
		}
		prpLltextDto.setTextType("08");
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);

		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLclaimDto);

		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest, prpLcaseNoDto);

		//�������᰸��Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);

		//�ڽ�������ʾ�������� 2005-09-09
		UICodeAction uiCodeAction = new UICodeAction();
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//���ø����ӱ���Ϣ������
		setSubInfo(httpServletRequest, endcaseDto);
		
		
		   //add by zhaolu start at 2006-06-10
		  //reason ǿ�Ʊ���������Ϣд���᰸��
			System.out.println("ǿ�Ʊ���������Ϣд���᰸��------------------224");
			RegistDto registDto = new RegistDto();
			System.out.println(registDto.getPrpLRegistRPolicyList().size());
			System.out.println(registDto.getPrpLRegistRPolicyDtoOfCompel());
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
	}

	/**
	 * �����㰸��Ϣ��ϸ����
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo    �ⰸ��
	 * @throws Exception
	 */
	public void endcaseDtoView(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		
		//ȡ�ñ�������Ϣ
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
		EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(claimNo);

		//���ݲ�ѯ�������������ݣ���PrpLcaseNoDto��ֵ
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = endcaseDto.getPrpLclaimDto();
		//��ѯ������Ϣ
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto
				.getRegistNo());
		
		   //add by zhaolu start at 2006-06-10
		   //reason ǿ�Ʊ���������Ϣд���᰸��
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
		
		
		prpLclaimDto.setClaimType(registDto.getPrpLregistDto().getClaimType());
		
		//��ѯ������Ϣ
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
			//�Գ��͵���Ϣ��֧��
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

		//���ý᰸������״̬Ϊ �°����Ǽ� (δ��������)
		prpLcaseNoDto.setStatus("1");

		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLclaimDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest, prpLcaseNoDto);
		//�������᰸��Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//����������Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);

		//�ڽ�������ʾ�������� 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//���ø����ӱ���Ϣ������
		//setSubInfo(httpServletRequest, endcaseDto);
		//modify by zhaozhuo add 20050331 start
		//reason: ��ѯ��Ԥ��ǼǺ�
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
		//reason:��������������
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
		// ��ӡ�᰸�����ж�������׼��
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
	int intCtextCountTmp = 0; // textarea����
	int index = 0;
	int x = 0;
	int y = 0;
		for (index = 0; index < tempContext.length(); index++) {
			if (tempContext.substring(index, index + 1).equals("\\")) {
				if (!(tempContext.substring(index).length() < 4)) {
					if (tempContext.substring(index, index + 4)
							.equals("\\r\\n")) {
						intCtextCountTmp += 1; // ֻҪ�лس����У�intCtextCountTmp+1
					}
				}
			}
		}
		if (!(tempContext.length() < 4)) // ���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
		{
			x = tempContext.length() - 4;
			y = tempContext.length();
			if (!tempContext.substring(x, y).equals("\\r\\n")) {
				intCtextCountTmp += 1;
			}
		} else{
			intCtextCountTmp = 1;
		}
		// ��ֵ�ı�������
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		prpLltextDto.setContext(tempContext);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		tempContext = StringUtils.replace(tempContext, "\r\n", "<br>&nbsp;");
		httpServletRequest.setAttribute("tempContext", tempContext);
	}

	/**
	 * ��д�᰸ҳ�漰��ѯ�᰸request������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param claimNo
	 *            �ⰸ��
	 * @param editType
	 *            �༭����
	 * @throws Exception
	 */
	public void claimDtoToView(HttpServletRequest httpServletRequest,
			String claimNo, String editType) throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
		DateTime.setDateDelimiter("-");
		UIClaimAction uIClaimAction = new UIClaimAction();
		ClaimDto claimDto = uIClaimAction.findByPrimaryKey(claimNo);

		//���ݲ�ѯ�������������ݣ���PrpLcaseNoDto��ֵ
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto = claimDto.getPrpLclaimDto();

		//��ѯ������Ϣ
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto
				.getRegistNo());
		   //add by zhaolu start at 2006-06-10
		  //reason ǿ�Ʊ���������Ϣд���᰸��
			httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
			//add by zhaolu end at 2006-06-10
			
		prpLclaimDto.setClaimType(registDto.getPrpLregistDto().getClaimType());

		//��ѯ������Ϣ
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
			//�Գ��͵���Ϣ��֧��
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

		//���ý᰸������״̬Ϊ �°����Ǽ� (δ��������)
		prpLcaseNoDto.setStatus("1");

		//�᰸�����ʼ�������㱨��------------------------------------
		
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
		// ��ֵ�ı�������
		Collection arraylTextList = new ArrayList();
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		prpLltextDto.setTextType("08");
		prpLltextDto.setContext(tempContext);
		prpLltextDto.setLtextList(arraylTextList);
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		
		//��ϸ����ԭ����Ϣ
		if(endcaseDto.getPrpLltextDtoList3().size() > 1){
			httpServletRequest.setAttribute("prpLltextDtoList3", endcaseDto.getPrpLltextDtoList3());
		}
		
		//�᰸ʱ����д����������⸶���
		double sumPaid = 0; //���⸶���
	//	UICompensateAction uiCompensateAction = new UICompensateAction();
		String strCondition = "";
		strCondition = " ClaimNo ='" + claimNo + "'";
		//����ͨ������������ż�������
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

		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLclaimDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		setSelectionList(httpServletRequest, prpLcaseNoDto);
		//�������᰸��Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
		//����������Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLclaimDto", prpLclaimDto);

		//�ڽ�������ʾ�������� 2005-09-09
		UICodeAction uiCodeAction = new UICodeAction();
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLclaimDto.getRiskCode(), true));

		//���ø����ӱ���Ϣ������
		
		//endcaseDto.setPrpLltextDtoList(claimDto.getPrpLltextDtoList());
		//setSubInfo(httpServletRequest, endcaseDto);
	}

	/**
	 * �����ⰸ�źͱ����Ų�ѯ�᰸��Ϣ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param registNo      �ⰸ��
	 * @param claimNo       ������
	 * @throws Exception
	 */
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//caseNO,policyNo,claimNo
		//��������ı����ţ��᰸������SQL where �Ӿ�
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

		//��ѯ������Ϣ
		UIClaimAction uiClaimAction = new UIClaimAction();

		//�õ����н᰸������Ϣ
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
		//��������ı����ţ��᰸������SQL where �Ӿ�
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
		//���������ũ�ձ�ʶ
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
		//��session��ȡ��ƶ/�󻧱�־
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

		//��ѯ������Ϣ
		 String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	        }
		
		UIClaimAction uiClaimAction = new UIClaimAction();

		//�õ����н᰸������Ϣ
		//Collection endcaseList = new ArrayList();
		ArrayList endcaseList = new ArrayList();
		 PageRecord pageRecord = (PageRecord)uiClaimAction.findByConditions(conditions,pageNo,recordPerPage);
		 endcaseList = (ArrayList)pageRecord.getResult();
		//endcaseList = (Collection) uiClaimAction.findByConditions(conditions);
		TurnPageDto turnPageDto = new TurnPageDto();
	       //��ѯ������һҳ�Ľṹ�� 
	       turnPageDto.setResultList(endcaseList);
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
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);
		prpLcaseNoDto.setTurnPageDto(turnPageDto);
		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}
	//add by zhaolu 20060803 end
	
	
	
	
	/**
	 * ����endcaseDto�еĸ��ӱ��ڵ���Ϣ������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param endcaseDto    �᰸��������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception {
		//[�᰸��Ϣ]�᰸��������б�׼������
		/*
		 Collection arrayLTextList = new ArrayList();
		 PrpLltextDto prpLltextDto  = new PrpLltextDto();
		 prpLltextDto.setTextType("08") ;
		 arrayLTextList  = endcaseDto.getPrpLltextDtoList() ;
		 prpLltextDto.setLtextList(arrayLTextList) ;
		 httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		 */
		//�������ļ������б�׼������
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
	 * ��ȡѡ�����б���е���������
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �᰸��������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLcaseNoDto prpLcaseNoDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//�᰸�����б�
		Collection endcaseNatures = uiCodeAction.getCodeType("EndcaseNature",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("endcaseNatures", endcaseNatures);
		//�ⰸ���
		Collection caseCodes = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("caseCodes", caseCodes);
		//���յص����
		Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("damageAddresss", damageAddresss);
		//�¹��⳥����
		Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);

		//�õ�ʵ�������б�
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		//�õ����������б��б�
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		//�õ����յ�ַ�����б�
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		//�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//�õ����Ƶ�ɫ�б�
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		//�õ��⳥�����б�
		Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
		//�õ��ⰸ����б�
		Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("escapeFlags", escapeFlags);
		//�õ��õ��Ա�
		Collection driverSex = uiCodeAction.getCodeType("SexCode",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("driverSexs", driverSex);
		//�õ�ְҵ����
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		//�õ��Ļ��̶�
		Collection education = uiCodeAction.getCodeType("Education",
				prpLcaseNoDto.getRiskCode());
		httpServletRequest.setAttribute("educations", education);
	}

	/**
	 * ����PrpPrepayDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param prpLcaseNoDto    �᰸��������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLclaimDto prpLclaimDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//ҵ������
		String businessNature = prpLclaimDto.getBusinessNature();
		String businessNatureName = uiCodeAction.translateCodeCode(
				"BusinessNature", businessNature, true);
		prpLclaimDto.setBusinessNature(businessNatureName);
		//ҵ������
		String language = prpLclaimDto.getLanguage();
		String languageName = uiCodeAction.translateCodeCode("Language",
				language, true);
		prpLclaimDto.setLanguage(languageName);

		//(1)�������Ƶ�ת��
		String clauseType = prpLclaimDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLclaimDto.setClauseName(clauseName);
		//(2)������ɫת��
		String licenseColorCodeCode = prpLclaimDto.getLicenseColorCode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor",
				licenseColorCodeCode, true);
		prpLclaimDto.setLicenseColor(licenseColor);
		//(3)��������ת��
		String carKindCode = prpLclaimDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode,
				true);
		prpLclaimDto.setCarKind(carKind);
		//(4)�⳥��������ת��
		String indemnityDuty = prpLclaimDto.getIndemnityDuty();
		String indemnityDutyName = uiCodeAction.translateCodeCode(
				"IndemnityDuty", indemnityDuty, true);
		prpLclaimDto.setIndemnityDutyName(indemnityDutyName);
		//(5)�ⰸ���ת��
		String claimType = prpLclaimDto.getEscapeFlag();
		if (claimType != null && claimType.trim().length() > 0) {
			claimType = new Character(claimType.charAt(0)).toString();
			String claimTypeName = uiCodeAction.translateCodeCode("CaseCode",
					claimType, true);
			prpLclaimDto.setClaimTypeName(claimTypeName);
		}
		//(6)��ҵ������ṹ����ת��
		String comCode = prpLclaimDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLclaimDto.setComName(comName);
		//(7)����Ǽǻ������ƽ���ת��
		String makeCom = prpLclaimDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeCom, true);
		prpLclaimDto.setMakeComName(makeComName);
		//(8)�Թ���ҵ��Ա����ת��
		String handler1Code = prpLclaimDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLclaimDto.setHandler1Name(handler1Name);
		//(9)�Դ����˽���ת��
		String agentCode = prpLclaimDto.getAgentCode();
		String agentName = uiCodeAction.translateUserCode(agentCode, true);
		prpLclaimDto.setAgentName(agentName);
		//(10)�Ծ����˽���ת��
		String handlerCode = prpLclaimDto.getHandlerCode();
		String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
		prpLclaimDto.setHandlerName(handlerName);
		//(11)�Բ���Ա���ƽ���ת��
		String operatorCode = prpLclaimDto.getOperatorCode();
		String userName = uiCodeAction.translateUserCode(operatorCode, true);
		prpLclaimDto.setOperatorName(userName);
	}

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����.
	 * ��д�᰸��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ��
	 * ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public EndcaseDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		EndcaseDto endcaseDto = new EndcaseDto();
		return endcaseDto;
	}

	/**
	 * ��д�᰸ҳ�漰��ѯ�᰸request������.
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param endcaseDto ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			EndcaseDto endcaseDto) throws Exception {
	}

	/**
	 * ����Ƿ���δͨ������������
	 * ����ֵ   0��û����������  -1:����δͨ������������  1�����е��������鶼�Ѿ�ͨ�� 2:�渶�᰸
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public int checkCompensate(HttpServletRequest httpServletRequest,
			String claimNo) throws Exception {
		//ȡ������������Ϣ
		int compensateFlag= 1 ;
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			//return 0;
			//����ǵ渶����£�Ӧ������᰸�ġ����Ի���Ҫ�ж��Ƿ��е渶�������
//			UIPrepayAction uiPrepayAction = new UIPrepayAction ();	
//			conditions = conditions + " and caseType='8'";
//			ArrayList prepayList = (ArrayList)uiPrepayAction.findByConditions(conditions);
			compensateFlag =0;
//			if (prepayList!=null&&prepayList.size()>0){
//				compensateFlag =2; //����е渶����������Խ��н᰸������
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
	//reason:�����Ƿ��Ѿ�¼��֧����Ϣ��û�еĻ����ܽ᰸�������������û����ѭ��ε���֮���Լ������    
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
	 * �����㰸�ŵĹ���
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public PrpLcaseNoDto compensateDtoToView(HttpServletRequest httpServletRequest, String claimNo)	throws Exception {
		String caseNo = ""; //�ⰸ��
		String policyNo = ""; //������
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");

		//�����ⰸ��
//		UIBillAction uiBillAction = new UIBillAction();
//		String tableName = "prplcaseno";
//		String comCode = user.getComCode();
//		String riskCode = BusinessRuleUtil.getRiskCode(claimNo);
//		int year = DateTime.current().getYear();
//		caseNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
		
		//�����ⰸ��
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
		//ʹ�����һ���㰸����
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
	 * �����ⰸ��,������,����״̬�����ƺ��룬����ʱ���ѯ�᰸��Ϣ
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param registNo      �ⰸ��
	 * @param claimNo       ������
	 * @throws Exception
	 * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
	 */
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			String caseNo, String claimNo, String policyNo, String licenseNo,
			String status, String operateDate) throws Exception {
		//caseNO,policyNo,claimNo
		//��������ı����ţ��᰸������SQL where �Ӿ�
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
		//     ƴȨ��
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");

		//��ѯ������Ϣ
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

		//�õ����н᰸������Ϣ
		Collection endcaseList = new ArrayList();
		endcaseList = (Collection) uiEndcaseAction
				.findByQueryConditions(conditions);
		PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
		prpLcaseNoDto.setCaseList(endcaseList);
		prpLcaseNoDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcaseNoDto", prpLcaseNoDto);
	}

	//modify by liuyanmei add 20051107 start 
	//reason:�᰸��ѯ���ӳб�����������ʱ�䣻�������Ǹ�����һ����������һ�������ڵ��ı�ĵط����������Ǹ������������������غ�����
	public void setPrpLendcaseDtoToView(HttpServletRequest httpServletRequest,
			String caseNo, String claimNo, String policyNo, String licenseNo,
			String status, String operateDate, String comCode, String claimDate)
			throws Exception {
		//caseNO,policyNo,claimNo
		//��������ı����ţ��᰸������SQL where �Ӿ�
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
		//     ƴȨ��
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplclaim","","ComCode");
		
		
       //mpdify by zhaolu 20060816 end
		//��ѯ������Ϣ
		UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

		//�õ����н᰸������Ϣ
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
	 * �����Ѿ��᰸�Ĳ����ٽ��н᰸�Ǽ�
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */ 
	public boolean checkEndcase(String claimNo) throws Exception {
		boolean blnReturn = false;
		//��ѯ������Ϣ
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
				   blnReturn = true;   //�ؿ��ѽ�Ϊtrue,������Ϊfalse
			}
		
		}
	return blnReturn;
	}
	
	
	
/*	
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
	} */
//add by lym 200603015----------------------------------------------------[END]
	
	
	/**
	 * �����Ѿ��᰸�Ĳ����ٽ��н᰸�Ǽ�
	 * @param httpServletRequest ���ظ�ҳ���request
	 * @param claimNo �ⰸ��
	 * @throws Exception 
	 */
	public boolean isGenrateCaseNo(String claimNo) throws Exception {
		boolean blnReturn = false;
		//��ѯ������Ϣ
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
		throw new Exception("�ⰸ�Ų���ȷ����������ȷ���ⰸ��");
		
	}
		return blnReturn;
	
	}
}
