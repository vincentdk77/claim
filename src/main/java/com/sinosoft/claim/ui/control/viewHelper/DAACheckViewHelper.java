package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistClaimInfoDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>
 * Title: CheckViewHelper
 * </p>
 * <p>
 * Description:�鿱ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public class DAACheckViewHelper extends CheckViewHelper {
	
	private static Log logger = LogFactory.getLog(DAACheckViewHelper.class);
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public DAACheckViewHelper() {
	}
	
	/**
	 * ����鿱ʱ�鿱ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * 
	 * @param httpServletRequest
	 * @return checkDto �鿱���ݴ������ݽṹ
	 * @throws Exception
	 */
	public CheckDto viewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//�̳ж�check,checkText��ĸ�ֵ
		CheckDto checkDto = super.viewToDto(httpServletRequest);
		//Modify by chenrenda add begin 20050418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		ArrayList prpLcheckLossDtoList = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = null;
		int intCheckLossIndex = 1;//���
		String prpLcheckLossRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLcheckLossPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String prpLcheckLossClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLcheckLossRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		//Modify by chenrenda add end 20050418
		
		//add by lixiang start at 2005-12-28
		//reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
		//��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
		String claimNo=prpLcheckLossClaimNo;
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(prpLcheckLossRegistNo ,true);
		}
		
		//add by lixiang end at 2005-12-28
		
		/*---------------------���߳���prpLthirdParty------------------------------------*/
		ArrayList thirdPartyDtoList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = null;
		//�ӽ���õ���������
		String prpLthirdPartyClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLthirdPartyRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLthirdPartyRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdPartyClauseType = httpServletRequest
		.getParameter("prpLcheckClauseType");
		String[] prpLthirdPartySerialNo = httpServletRequest
		.getParameterValues("prpLthirdPartySerialNo");
		String[] prpLthirdPartyLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdPartyLicenseNo");
		String[] prpLthirdPartyLicenseColorCode = httpServletRequest
		.getParameterValues("licenseColorCode");
		String[] prpLthirdPartyCarKindCode = httpServletRequest
		.getParameterValues("carKindCode");
		String[] prpLthirdPartyInsureCarFlag = httpServletRequest
		.getParameterValues("insureCarFlag");
		String[] prpLthirdPartyCarOwner = httpServletRequest
		.getParameterValues("prpLthirdPartyCarOwner");
		String[] prpLthirdPartyEngineNo = httpServletRequest
		.getParameterValues("prpLthirdPartyEngineNo");
		String[] prpLthirdPartyFrameNo = httpServletRequest
		.getParameterValues("prpLthirdPartyFrameNo");
		String[] prpLthirdPartyModelCode = httpServletRequest
		.getParameterValues("prpLthirdPartyModelCode");
		String[] prpLthirdPartyBrandName = httpServletRequest
		.getParameterValues("prpLthirdPartyBrandName");
		String[] prpLthirdPartyRunDistance = httpServletRequest
		.getParameterValues("prpLthirdPartyRunDistance");
		String[] prpLthirdPartyUseYears = httpServletRequest
		.getParameterValues("prpLthirdPartyUseYears");
		String[] prpLthirdPartyDutyPercent = httpServletRequest
		.getParameterValues("prpLthirdPartyDutyPercent");
		String[] prpLthirdPartyInsuredFlag = httpServletRequest
		.getParameterValues("insuredFlag");
		String[] prpLthirdPartyInsureComCode = httpServletRequest
		.getParameterValues("prpLthirdPartyInsureComCode");
		String[] prpLthirdPartyInsureComName = httpServletRequest
		.getParameterValues("prpLthirdPartyInsureComName");
		String[] prpLthirdPartyFlag = httpServletRequest
		.getParameterValues("prpLthirdPartyFlag");
		String[] prpLthirdPartyVINNo = httpServletRequest
		.getParameterValues("prpLthirdPartyVINNo");
		String[] prpLthirdPartyLossFlag = httpServletRequest
		.getParameterValues("prpLthirdPartyLossFlag");
		String[] prpLthirdPartyDriveName = httpServletRequest
		.getParameterValues("prpLthirdPartyDriveName");
		String[] prpLthirdPartyDriveLicensNo = httpServletRequest
		.getParameterValues("prpLthirdPartyDriveLicensNo");
		String[] prpLthirdPartyCarPolicyNo = httpServletRequest
		.getParameterValues("prpLthirdPartyCarPolicyNo");
		
		//Modify by chenrenda add begin 20050418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		String[] prpLthirdPartyKindCode = httpServletRequest
		.getParameterValues("prpLthirdPartyKindCode");
		String[] prpLthirdPartyLossFee = httpServletRequest
		.getParameterValues("prpLthirdPartyLossFee");
		
		//Modify by chenrenda add end 20050418
		   //add by liyanjie 2005-12-18 start �����ϳ�����Ӧ���Ƿ�Ϊ���������ı�־
		  String[] prpLthirdPartyNewAddFlag       = httpServletRequest.getParameterValues("prpLthirdPartyNewAddFlag");
		  //add by liyanjie 2005-12-18 end  �����ϳ�����Ӧ���Ƿ�Ϊ���������ı�־
		
		//���ȱ���õ�
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		//����ֵ
		if (prpLthirdPartySerialNo == null
				|| prpLthirdPartyLicenseColorCode == null) {
		} else {
			//���߳������ֿ�ʼ
			for (int index = 1; index < prpLthirdPartySerialNo.length; index++) {
				prpLthirdPartyDto = new PrpLthirdPartyDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:Ԥ����ʧģ��ϵ��永������Ϣ��
				prpLcheckLossDto = new PrpLcheckLossDto();
				prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				prpLcheckLossDto.setClaimNo(claimNo);
				prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setReferSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartySerialNo[index])));
				//modify by wuxiaodong 050906 begain reasion
				// ���ղ鿰ʱҪ���ṩ���ձ�����룬Ϊ�˽��ձ���뵽carloss�������checkloss��kindcode�ֶβ�����Ϊ�գ����Դ�����һ��ʦֱΪĬ��ֵ
				//prpLcheckLossDto.setKindCode(prpLthirdPartyKindCode[index]);
				prpLcheckLossDto.setKindCode("A");
				//modify by wuxiaodong 050906 end
				prpLcheckLossDto.setLossFeeType("1");
				prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyLossFee[index])));
				prpLcheckLossDto.setFlag("");
				intCheckLossIndex++;
				prpLcheckLossDtoList.add(prpLcheckLossDto);
				//Modify by chenrenda update end 20050418
				
				prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
				prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
				prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartySerialNo[index])));
				prpLthirdPartyDto.setClaimNo(claimNo);
				prpLthirdPartyDto.setClauseType(prpLthirdPartyClauseType);
				prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo[index]);
				prpLthirdPartyDto
				.setLicenseColorCode(prpLthirdPartyLicenseColorCode[index]);
				prpLthirdPartyDto
				.setCarKindCode(prpLthirdPartyCarKindCode[index]);
				prpLthirdPartyDto
				.setInsureCarFlag(prpLthirdPartyInsureCarFlag[index]);
				prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo[index]);
				prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo[index]);
				prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName[index]);
				prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode[index]);
				
				
				prpLthirdPartyDto.setRunDistance(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyRunDistance[index])));
				prpLthirdPartyDto.setUseYears(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartyUseYears[index])));
				prpLthirdPartyDto.setDutyPercent(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyDutyPercent[index])));
				prpLthirdPartyDto
				.setInsuredFlag(prpLthirdPartyInsuredFlag[index]);
				prpLthirdPartyDto
				.setInsureComCode(prpLthirdPartyInsureComCode[index]);
				prpLthirdPartyDto
				.setInsureComName(prpLthirdPartyInsureComName[index]);
				prpLthirdPartyDto.setVINNo(prpLthirdPartyVINNo[index]);
				prpLthirdPartyDto.setLossFlag(prpLthirdPartyLossFlag[index]);
				//���߳���ʻԱ���ƣ����֤����
				prpLthirdPartyDto.setPrpLthirdPartyDriveName(prpLthirdPartyDriveName[index-1]);
				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(prpLthirdPartyDriveLicensNo[index-1]);
				//���߳�����������
				prpLthirdPartyDto.setCarPolicyNo(prpLthirdPartyCarPolicyNo[index]);
				//���뼯��
				thirdPartyDtoList.add(prpLthirdPartyDto);
				 //����������
		        
		        prpLscheduleItemDto = new PrpLscheduleItemDto();
		        prpLscheduleItemDto.setScheduleID         (1);
		        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyRegistNo);
		        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
		        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
		        
		        //modify by liyanjie 2005-12-18 start �����˫������,�鿱�������߳�,�����Ķ�����������յ�(claimcomcode=�鿱���ȵ�claimcomcode);
		        //System.out.println("------ ���Ӷ��� ---commiFlag:"+commiFlag);
		        //BLPrpLscheduleMainWFFacade blPrpLscheduleMainWF = new BLPrpLscheduleMainWFFacade();
		    	//PrpLscheduleMainWFDto prpLscheduleMainWFDto = blPrpLscheduleMainWF.findByPrimaryKey(1,prpLthirdPartyRegistNo);
		        //if( (!(commiFlag == null )) && "1".equals(commiFlag)){
		        //	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
		        //}
		        //if(!(prpLscheduleMainWFDto==null)){
		        //prpLscheduleItemDto.setClaimComCode(prpLscheduleMainWFDto.getClaimComCode()); //�����ĳ���������������յص�������,����鿱������ͬһ����������
		     		//}else{ 
		     		//prpLscheduleItemDto.setClaimComCode("");  //��һȡ����ʧ��,���������������,����һ���ǲ����ܵ�
		     		//}
		        System.out.println("------ ���Ӷ��� ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
		        //modify by liyanjie 2005-12-17 end
		        
		        //��ʾ�Ƿ�ѡ��
		        prpLscheduleItemDto.setSelectSend         ("1");
		        //��ʾû�е��ȳɶ����
		        prpLscheduleItemDto.setSurveyTimes        (0);
		        prpLscheduleItemDto.setSurveyType         ("1");
		        prpLscheduleItemDto.setCheckSite          (checkDto.getPrpLcheckDto().getCheckSite());
		        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
		        prpLscheduleItemDto.setScheduleObjectID   ("_");
		        prpLscheduleItemDto.setScheduleObjectName (" ");
		        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString() ,DateTime.YEAR_TO_DAY ));
		        prpLscheduleItemDto.setScheduleType       ("schel");
		        prpLscheduleItemDto.setNextNodeNo("certa");
		        
		        //if(prpLthirdPartyNewAddFlag[index].equals("new")){			//����������Ķ���,����  add if����  by liyanjie
			        //������ȱ�ļ���
			        scheduleItemDtoList.add(prpLscheduleItemDto);
		       // }
				
			}
			
			//�鿱�����м������߳���
			checkDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
		}
		/*---------------------��ʻԱprpLdriver------------------------------------*/
		ArrayList driverList = new ArrayList();
		PrpLdriverDto prpLdriverDto = null;
		
		//�ӽ���õ���������
		String prpLdriverRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLdriverClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLdriverRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLdriverPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String[] prpLdriverSerialNo = httpServletRequest
		.getParameterValues("prpLdriverSerialNo");
		/* modify by liuyanmei delete 20051116 
		 * reason : ��ʻԱ��Ϣֻ��Ҫ�����绰 
		 *  
		
		 String[] prpLdriverLicenseColorCode = httpServletRequest
		 .getParameterValues("prpLdriverLicenseColorCode");
		 String[] prpLdriverDrivingLicenseNo = httpServletRequest
		 .getParameterValues("prpLdriverDrivingLicenseNo");
		 */
		String[] prpLdriverDriverName = httpServletRequest
		.getParameterValues("prpLdriverDriverName");
		String[] prpLdriverDriverPhone = httpServletRequest
		.getParameterValues("prpLdriverDriverPhone");
		//add by zhaolu 20060817 start
		//reason��Ӽ�ʻԱ֤���� 
		 String[] prpLdriverLicenseNo = httpServletRequest
		 .getParameterValues("prpLdriverDrivingLicenseNo");
		 String[] prpLdriverIdentifyType = httpServletRequest
		 .getParameterValues("identifyType");
		 String[] prpLdriverIdentifyNumber = httpServletRequest
		 .getParameterValues("prpLdriverIdentifyNumber");
		//add by zhaolu 20060817 end
		/* modify by liuyanmei delete 20051116 
		 * reason : ��ʻԱ��Ϣֻ��Ҫ�����绰 
		 String[] prpLdriverDriverSex = httpServletRequest
		 .getParameterValues("driverSex");
		 String[] prpLdriverDriverAge = httpServletRequest
		 .getParameterValues("prpLdriverDriverAge");
		 String[] prpLdriverDriverOccupation = httpServletRequest
		 .getParameterValues("prpLdriverDriverOccupation");
		 String[] prpLdriverEducation = httpServletRequest
		 .getParameterValues("education");
		 String[] prpLdriverUnitAddress = httpServletRequest
		 .getParameterValues("prpLdriverUnitAddress");
		 String[] prpLdriverIdentifyNumber = httpServletRequest
		 .getParameterValues("prpLdriverIdentifyNumber");
		 String[] prpLdriverDriverGrade = httpServletRequest
		 .getParameterValues("prpLdriverDriverGrade");
		 String[] prpLdriverDriverSeaRoute = httpServletRequest
		 .getParameterValues("prpLdriverDriverSeaRoute");
		 String[] prpLdriverReceiveLicenseDate = httpServletRequest
		 .getParameterValues("prpLdriverReceiveLicenseDate");
		 String[] prpLdriverDrivingCarType = httpServletRequest
		 .getParameterValues("drivingCarType");
		 String[] prpLdriverDrivingYear = httpServletRequest
		 .getParameterValues("prpLdriverDrivingYear");
		 String[] prpLdriverAwardLicenseOrgan = httpServletRequest
		 .getParameterValues("prpLdriverAwardLicenseOrgan");
		 String[] prpLdriverSpecialCertificate = httpServletRequest
		 .getParameterValues("prpLdriverSpecialCertificate");
		 String[] prpLdriverFlag = httpServletRequest
		 .getParameterValues("prpLdriverFlag");
		 // modify by liuyanmei delete 20051116  */ 
		
		//����ֵ
		//if (prpLdriverSerialNo == null || prpLdriverDriverSex == null)
		if (prpLdriverSerialNo == null ) {
		} else {
			//��ʻԱ���ֿ�ʼ
			for (int index = 1; index < prpLdriverSerialNo.length; index++) {
				prpLdriverDto = new PrpLdriverDto();
				prpLdriverDto.setRegistNo(prpLdriverRegistNo);
				prpLdriverDto.setClaimNo(claimNo);
				prpLdriverDto.setRiskCode(prpLdriverRiskCode);
				prpLdriverDto.setPolicyNo(prpLdriverPolicyNo);
				prpLdriverDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLdriverSerialNo[index])));
				prpLdriverDto.setDriverName(prpLdriverDriverName[index]);
				prpLdriverDto.setDriverSeaRoute(prpLdriverDriverPhone[index]);
				//add by zhaolu 20060817 start
				//reason��Ӽ�ʻԱ֤����
				prpLdriverDto.setDrivingLicenseNo(prpLdriverLicenseNo[index]);
				prpLdriverDto.setIdentifyType(prpLdriverIdentifyType[index]);
				prpLdriverDto.setIdentifyNumber(prpLdriverIdentifyNumber[index]);
				//add by zhaolu 20060817 end
				/* modify by liuyanmei delete 20051116 
				 * reason : ��ʻԱ��Ϣֻ��Ҫ�����绰 
				 prpLdriverDto.setLicenseNo(prpLdriverLicenseNo[index]);
				 prpLdriverDto.setLicenseColorCode(prpLdriverLicenseColorCode[index]);
				 prpLdriverDto.setDrivingLicenseNo(prpLdriverDrivingLicenseNo[index]);
				 prpLdriverDto.setDriverName(prpLdriverDriverName[index]);
				 prpLdriverDto.setDriverSex(prpLdriverDriverSex[index]);
				 prpLdriverDto.setDriverAge(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDriverAge[index])));
				 prpLdriverDto
				 .setDriverOccupation(prpLdriverDriverOccupation[index]);
				 prpLdriverDto.setEducation(prpLdriverEducation[index]);
				 prpLdriverDto.setUnitAddress(prpLdriverUnitAddress[index]);
				 prpLdriverDto
				 .setIdentifyNumber(prpLdriverIdentifyNumber[index]);
				 prpLdriverDto.setDriverGrade(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDriverGrade[index])));
				 prpLdriverDto
				 .setDriverSeaRoute(prpLdriverDriverSeaRoute[index]);
				 prpLdriverDto.setReceiveLicenseDate(new DateTime(
				 prpLdriverReceiveLicenseDate[index],
				 DateTime.YEAR_TO_DAY));
				 prpLdriverDto
				 .setDrivingCarType(prpLdriverDrivingCarType[index]);
				 prpLdriverDto.setDrivingYear(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDrivingYear[index])));
				 prpLdriverDto
				 .setAwardLicenseOrgan(prpLdriverAwardLicenseOrgan[index]);
				 prpLdriverDto
				 .setSpecialCertificate(prpLdriverSpecialCertificate[index]);
				 prpLdriverDto.setFlag(prpLdriverFlag[index]);
				 //end    */
				//���뼯��
				driverList.add(prpLdriverDto);
			}
			
			//�鿱�����м����ԦԱ
			checkDto.setPrpLdriverDtoList(driverList);
		}
		/*---------------------�鿱��չ��ϢPrpLcheckExtDto------------------------------------*/
		ArrayList prpLcheckExtDtoList = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = null;
		
		//�ӽ���õ���������
		String prpLcheckExtRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLcheckExtPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String prpLcheckExtClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLcheckExtRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLcheckExtColumnValue01 = httpServletRequest
		.getParameter("CheckExt01");
		String prpLcheckExtColumnValue02 = httpServletRequest
		.getParameter("CheckExt02");
		String prpLcheckExtColumnValue03 = httpServletRequest
		.getParameter("CheckExt03");
		String prpLcheckExtColumnValue04 = httpServletRequest
		.getParameter("CheckExt04");
		String prpLcheckExtColumnValue05 = httpServletRequest
		.getParameter("CheckExt05");
		String prpLcheckExtColumnValue06 = httpServletRequest
		.getParameter("CheckExt06");
		String prpLcheckExtColumnValue07 = httpServletRequest
		.getParameter("CheckExt07");
		String prpLcheckExtColumnValue08 = httpServletRequest
		.getParameter("CheckExt08");
		String prpLcheckExtColumnValue09 = httpServletRequest
		.getParameter("CheckExt09");
		String prpLcheckExtColumnValue10 = httpServletRequest
		.getParameter("CheckExt10");
		String prpLcheckExtColumnValue11 = httpServletRequest
		.getParameter("CheckExt11");
		String prpLcheckExtColumnValue12 = httpServletRequest
		.getParameter("CheckExt12");
		String prpLcheckExtColumnValue13 = httpServletRequest
		.getParameter("CheckExt13");
		String prpLcheckExtColumnValue14 = httpServletRequest
		.getParameter("CheckExt14");
		String prpLcheckExtColumnValue15 = httpServletRequest
		.getParameter("CheckExt15");
		String prpLcheckExtColumnValue16 = httpServletRequest
		.getParameter("CheckExt16");
		String prpLcheckExtColumnValue17 = httpServletRequest
		.getParameter("CheckExt17");
		String prpLcheckExtColumnValue18 = httpServletRequest
		.getParameter("CheckExt18");
		String prpLcheckExtColumnValue19 = httpServletRequest
		.getParameter("CheckExt19");
		
		//��һ����¼
		boolean hasExtColumn = false; //��ʾ�м�¼��
		
		if (prpLcheckExtColumnValue01 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt01Serial")));
			prpLcheckExtDto.setColumnName("CheckExt01");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt01Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue01);
			prpLcheckExtDto.setFlag("0");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//�ڶ�����¼
		if (prpLcheckExtColumnValue02 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt02Serial")));
			prpLcheckExtDto.setColumnName("CheckExt02");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt02Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue02);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��������¼
		if (prpLcheckExtColumnValue03 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt03Serial")));
			prpLcheckExtDto.setColumnName("CheckExt03");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt03Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue03);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��������¼
		if (prpLcheckExtColumnValue04 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt04Serial")));
			prpLcheckExtDto.setColumnName("CheckExt04");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt04Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue04);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��������¼
		if (prpLcheckExtColumnValue05 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt05Serial")));
			prpLcheckExtDto.setColumnName("CheckExt05");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt05Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue05);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��������¼
		if (prpLcheckExtColumnValue06 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt06Serial")));
			prpLcheckExtDto.setColumnName("CheckExt06");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt06Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue06);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��������¼
		if (prpLcheckExtColumnValue07 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt07Serial")));
			prpLcheckExtDto.setColumnName("CheckExt07");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt07Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue07);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//�ڰ�����¼
		if (prpLcheckExtColumnValue08 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt08Serial")));
			prpLcheckExtDto.setColumnName("CheckExt08");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt08Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue08);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//�ھ�����¼
		if (prpLcheckExtColumnValue09 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt09Serial")));
			prpLcheckExtDto.setColumnName("CheckExt09");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt09Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue09);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ����¼
		if (prpLcheckExtColumnValue10 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt10Serial")));
			prpLcheckExtDto.setColumnName("CheckExt10");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt10Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue10);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮһ����¼
		if (prpLcheckExtColumnValue11 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt11Serial")));
			prpLcheckExtDto.setColumnName("CheckExt11");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt11Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue11);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue12 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt12Serial")));
			prpLcheckExtDto.setColumnName("CheckExt12");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt12Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue12);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue13 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt13Serial")));
			prpLcheckExtDto.setColumnName("CheckExt13");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt13Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue13);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue14 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt14Serial")));
			prpLcheckExtDto.setColumnName("CheckExt14");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt14Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue14);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue15 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt15Serial")));
			prpLcheckExtDto.setColumnName("CheckExt15");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt15Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue15);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue16 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt16Serial")));
			prpLcheckExtDto.setColumnName("CheckExt16");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt16Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue16);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//��ʮ������¼
		if (prpLcheckExtColumnValue17 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt17Serial")));
			prpLcheckExtDto.setColumnName("CheckExt17");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt17Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue17);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//  ��ʮ������¼
		if (prpLcheckExtColumnValue18 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt18Serial")));
			prpLcheckExtDto.setColumnName("CheckExt18");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt18Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue18);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//  ��ʮ������¼
		if (prpLcheckExtColumnValue19 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt19Serial")));
			prpLcheckExtDto.setColumnName("CheckExt19");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt19Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue19);
			prpLcheckExtDto.setFlag("");
			//���뼯��
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//�鿱��չ��Ϣ
		if (hasExtColumn) {
			checkDto.setPrpLcheckExtDtoList(prpLcheckExtDtoList);
		}
		
		/*---------------------�¹ʹ�����PrpLcheckLossDto------------------------------------*/
		//Modify by chenrenda remark begin 20050418
		//Reason:�ڲ鿱ҳ���й�����ģ��ϵ��永�������Ʋ���ʧ��������Ϣ��
		//ArrayList prpLcheckLossDtoList = new ArrayList();
		//PrpLcheckLossDto prpLcheckLossDto = null;
		//String prpLcheckLossRegistNo =
		// (String)httpServletRequest.getAttribute("registNo");
		//String prpLcheckLossPolicyNo =
		// httpServletRequest.getParameter("prpLcheckPolicyNo");
		//String prpLcheckLossClaimNo =
		// httpServletRequest.getParameter("prpLcheckClaimNo");
		//String prpLcheckLossRiskCode =
		// httpServletRequest.getParameter("prpLcheckRiskCode");
		//String[] prpLcheckLossSerialNo =
		// httpServletRequest.getParameterValues("prpLcheckLossSerialNo");
		//String[] prpLcheckLossReferSerialNo =
		// httpServletRequest.getParameterValues("prpLcheckLossReferSerialNo");
		//String[] prpLcheckLossKindCode =
		// httpServletRequest.getParameterValues("prpLcheckLossKindCode");
		//String[] prpLcheckLossLossFeeType =
		// httpServletRequest.getParameterValues("lossFeeType");
		//String[] prpLcheckLossLossFee =
		// httpServletRequest.getParameterValues("prpLcheckLossLossFee");
		//String[] prpLcheckLossFlag =
		// httpServletRequest.getParameterValues("prpLcheckLossFlag");
		//����ֵ
		//�¹ʹ�����
		/*
		 * if (prpLcheckLossSerialNo ==null) {} else { for(int index = 1;index <
		 * prpLcheckLossSerialNo.length; index++) { prpLcheckLossDto = new
		 * PrpLcheckLossDto();
		 * prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
		 * prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
		 * prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
		 * prpLcheckLossDto.setClaimNo(claimNo);
		 * 
		 * prpLcheckLossDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLcheckLossSerialNo[index])));
		 * prpLcheckLossDto.setReferSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLcheckLossReferSerialNo[index])));
		 * prpLcheckLossDto.setKindCode(prpLcheckLossKindCode[index]);
		 * prpLcheckLossDto.setLossFeeType(prpLcheckLossLossFeeType[index]);
		 * prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLcheckLossLossFee[index])));
		 * prpLcheckLossDto.setFlag(prpLcheckLossFlag[index]);
		 * 
		 * prpLcheckLossDtoList.add(prpLcheckLossDto); }
		 * checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList); }
		 */
		//Modify by chenrenda remark end 20050418
		//Modify by chenrenda add begin 20050407
		//Reason:ҳ��������������ʧģ��
		/*---------------------������ʧ��λ PrpLthirdProp begin------------------------------------*/
		ArrayList thirdPropDtoList = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = null;
		
		//�ӽ���õ���������
		String prpLthirdPropRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdPropRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String[] prpLthirdPropItemNo = httpServletRequest
		.getParameterValues("prpLthirdPropItemNo");
		String[] prpLthirdPropLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdPropLicenseNo");
		String[] lossItemCode = httpServletRequest
		.getParameterValues("prpLthirdLossItemCode");
		String[] LossItemName = httpServletRequest
		.getParameterValues("prpLthirdLossItemName");
		String[] prpLthirdPropLossDesc = httpServletRequest
		.getParameterValues("prpLthirdPropLossDesc");
		String[] prpLthirdPropFlag = httpServletRequest
		.getParameterValues("prpLthirdPropFlag");
		
		//Modify by chenrenda add begin 20050418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		String[] prpLthirdPropKindCode = httpServletRequest
		.getParameterValues("prpLthirdPropKindCode");
		String[] prpLthirdPropLossFee = httpServletRequest
		.getParameterValues("prpLthirdPropLossFee");
		//Modify by chenrenda add end 20050418
		   String[] prpLthirdPropNewAddFlag      =httpServletRequest.getParameterValues("prpLthirdPropNewAddFlag" );//�Ƿ�������Ŀ�ı�־
		   
		//����ֵ
		//��ʧ��λ���ֿ�ʼ
		if (prpLthirdPropItemNo == null) {
		} else {
			for (int index = 1; index < prpLthirdPropItemNo.length; index++) {
				
				prpLthirdPropDto = new PrpLthirdPropDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:Ԥ����ʧģ��ϵ��永������Ϣ��
				prpLcheckLossDto = new PrpLcheckLossDto();
				prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				prpLcheckLossDto.setClaimNo(claimNo);
				prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				System.out.println("**********prpLthirdProp****:"
						+ intCheckLossIndex);
				prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setKindCode(prpLthirdPropKindCode[index]);
				prpLcheckLossDto.setLossFeeType("3");
				prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPropLossFee[index])));
				prpLcheckLossDto.setFlag("");
				intCheckLossIndex++;
				prpLcheckLossDtoList.add(prpLcheckLossDto);
				//Modify by chenrenda update end 20050418
				
				prpLthirdPropDto.setRegistNo(prpLthirdPropRegistNo);
				prpLthirdPropDto.setRiskCode(prpLthirdPropRiskCode);
				prpLthirdPropDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPropItemNo[index])));
				prpLthirdPropDto.setLicenseNo(prpLthirdPropLicenseNo[index]);
				prpLthirdPropDto.setLossItemCode(lossItemCode[index]);
				prpLthirdPropDto.setLossItemName(LossItemName[index]);
				prpLthirdPropDto.setLossItemDesc(prpLthirdPropLossDesc[index]);
				prpLthirdPropDto.setFlag(prpLthirdPropFlag[index]);
				
				//���뼯��
				thirdPropDtoList.add(prpLthirdPropDto);
				
			}
//			���ӲƲ���ʧ���������Ϣ��������ˣ��ͽ��е���
			System.out.println(" �Ʋ���ʧ�жϿ�ʼ����������������");
			if (thirdPropDtoList != null && thirdPropDtoList.size() > 0) {
				System.out.println(" �Ʋ���ʧ�����ݡ���������������");	
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //��ʾ�Ƿ�ѡ��
		         prpLscheduleItemDto.setSelectSend("1");
		         //��ʾû�е��ȳɶ����
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         prpLscheduleItemDto.setNextNodeNo("propc");
		        	scheduleItemDtoList.add(prpLscheduleItemDto);

			}

			//���������м�����ʧ��λ
			checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
			}
		/*---------------------������ʧ��λ PrpLthirdProp end------------------------------------*/
		//Modify by chenrenda add end 20050407
		/*---------------------��Ա�������� PrpLpersonTrace ------------------------------------*/
		ArrayList personTraceDtoList = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = null;
		//�ӽ���õ���������
		String prpLpersonTraceRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLpersonTraceClaimNo = httpServletRequest
		.getParameter("prpLregistRiskCode");
		String prpLpersonTracePolicyNo = httpServletRequest
		.getParameter("prpLregistPolicyNo");
		String[] prpLpersonTracePersonNo = httpServletRequest
		.getParameterValues("prpLpersonTracePersonNo");
		String[] prpLpersonTracePersonName = httpServletRequest
		.getParameterValues("prpLpersonTracePersonName");
		String[] prpLpersonTracePersonSex = httpServletRequest
		.getParameterValues("personSex");
		String[] prpLpersonTracePersonAge = httpServletRequest
		.getParameterValues("prpLpersonTracePersonAge");
		String[] prpLpersonTraceIdentifyNumber = httpServletRequest
		.getParameterValues("prpLpersonTraceIdentifyNumber");
		String[] prpLpersonTraceRelatePersonNo = httpServletRequest
		.getParameterValues("prpLpersonTraceRelatePersonNo");
		String[] prpLpersonTraceJobCode = httpServletRequest
		.getParameterValues("prpLpersonTraceJobCode");
		String[] prpLpersonTraceJobName = httpServletRequest
		.getParameterValues("prpLpersonTraceJobName");
		String[] prpLpersonTraceReferKind = httpServletRequest
		.getParameterValues("prpLpersonTraceReferKind");
		String[] prpLpersonTracePartDesc = httpServletRequest
		.getParameterValues("prpLpersonTracePartDesc");
		String[] prpLpersonTraceHospital = httpServletRequest
		.getParameterValues("prpLpersonTraceHospital");
		String[] prpLpersonTraceMotionFlag = httpServletRequest
		.getParameterValues("motionFlag");
		String[] prpLpersonTraceWoundRemark = httpServletRequest
		.getParameterValues("prpLpersonTraceWoundRemark");
		String[] prpLpersonTraceRemark = httpServletRequest
		.getParameterValues("prpLpersonTraceRemark");
		String[] prpLpersonTraceFlag = httpServletRequest
		.getParameterValues("prpLpersonTraceFlag");

	     String[] prpLpersonTraceNewAddFlag      =httpServletRequest.getParameterValues("prpLpersonTraceNewAddFlag" );//�Ƿ�������Ŀ�ı�־
	   
		//Modify by chenrenda add begin 20050418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		//String[] prpLpersonTraceLossFee =
		// httpServletRequest.getParameterValues("prpLpersonTraceLossFee" );
		//Modify by chenrenda add end 20050418
		
		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLpersonTracePersonNo == null) {
		} else {
			System.out.println("��Ա�������ٲ��ֿ�ʼ ");
			for (int index = 1; index < prpLpersonTracePersonNo.length; index++) {
				prpLpersonTraceDto = new PrpLpersonTraceDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:Ԥ����ʧģ��ϵ�������Ϣ��
				//���˸�����Ϣ��ȥ����ʧ��� 2005-07-26
				/*
				 * prpLcheckLossDto = new PrpLcheckLossDto();
				 * prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				 * prpLcheckLossDto.setClaimNo(claimNo);
				 * prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				 * prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				 * prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				 * prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
				 * prpLcheckLossDto.setKindCode(prpLpersonTraceReferKind[index]); //
				 * prpLcheckLossDto.setKindCode("B");
				 * prpLcheckLossDto.setLossFeeType("2");
				 * prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLpersonTraceLossFee[index])));
				 * prpLcheckLossDto.setFlag(""); intCheckLossIndex++;
				 * prpLcheckLossDtoList.add(prpLcheckLossDto);
				 */
				//Modify by chenrenda update end 20050418
				prpLpersonTraceDto.setRegistNo(prpLpersonTraceRegistNo);
				prpLpersonTraceDto.setClaimNo(claimNo);
				prpLpersonTraceDto.setPolicyNo(prpLpersonTracePolicyNo);
				prpLpersonTraceDto.setPersonNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTracePersonNo[index])));
				prpLpersonTraceDto
				.setPersonName(prpLpersonTracePersonName[index]);
				prpLpersonTraceDto
				.setPersonSex(prpLpersonTracePersonSex[index]);
				prpLpersonTraceDto.setPersonAge(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTracePersonAge[index])));
				prpLpersonTraceDto
				.setIdentifyNumber(prpLpersonTraceIdentifyNumber[index]);
				prpLpersonTraceDto.setRelatePersonNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTraceRelatePersonNo[index])));
				prpLpersonTraceDto.setJobCode(prpLpersonTraceJobCode[index]);
				prpLpersonTraceDto.setJobName(prpLpersonTraceJobName[index]);
				if(prpLpersonTraceReferKind!=null){
				prpLpersonTraceDto
				.setReferKind(prpLpersonTraceReferKind[index]);
				}
				// prpLpersonTraceDto.setReferKind ("B");
				prpLpersonTraceDto.setPartDesc(prpLpersonTracePartDesc[index]);
				prpLpersonTraceDto.setHospital(prpLpersonTraceHospital[index]);
				prpLpersonTraceDto
				.setMotionFlag(prpLpersonTraceMotionFlag[index]);
				prpLpersonTraceDto
				.setWoundRemark(prpLpersonTraceWoundRemark[index]);
				prpLpersonTraceDto.setRemark(prpLpersonTraceRemark[index]);
				prpLpersonTraceDto.setFlag(prpLpersonTraceFlag[index]);
				//���뼯��
				personTraceDtoList.add(prpLpersonTraceDto);
			}
			//���������м�����ʧ��λ
			checkDto.setPrpLpersonTraceDtoList(personTraceDtoList);
		}
        if (personTraceDtoList!=null&&personTraceDtoList.size() >0){
            prpLscheduleItemDto = new PrpLscheduleItemDto();
            prpLscheduleItemDto.setScheduleID(1);
            prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
            prpLscheduleItemDto.setItemNo(0);
            //��ʾ�Ƿ�ѡ��
            prpLscheduleItemDto.setSelectSend("1");
            //��ʾû�е��ȳɶ����
            prpLscheduleItemDto.setSurveyTimes(0);
            prpLscheduleItemDto.setSurveyType("1");
            prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
            prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
                DateTime.YEAR_TO_DAY));
            prpLscheduleItemDto.setScheduleType("schel");
            prpLscheduleItemDto.setLicenseNo("����");
            prpLscheduleItemDto.setScheduleObjectID("_");
            prpLscheduleItemDto.setScheduleObjectName(" ");
            prpLscheduleItemDto.setNextNodeNo("wound");
           // if(prpLpersonTraceNewAddFlag[prpLpersonTraceDto.getPersonNo()].equals("new")){		
            	scheduleItemDtoList.add(prpLscheduleItemDto);
           // }
        }
        //�������ݣ���������ȵ����ݣ�������ύ��ʱ�򡣡����µ����ݷ���prplscheduleItem�У��������Ѿ����ȹ�������
        if (checkDto.getPrpLclaimStatusDto() .getStatus().equals("4")
           &&scheduleItemDtoList.size() >0 ){ //���β鿱���ҵ����µĵ�������
           //��鶨����ȵ������������ڶ�����ȣ�����Ƿ��Ѿ����ȹ������û�е��ȹ�������û�е��ȹ�����
           Collection prpLscheduleItemList = new ArrayList();
           //��ѯ���ȹ���
           String strSql =" registno ='"+checkDto.getPrpLcheckDto() .getRegistNo()
                         +"' and surveyTimes=1";
           //��ѯ����
           UIScheduleAction uiScheduleAction=new UIScheduleAction();
           prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
           PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
           ArrayList scheduleItemLastList = new ArrayList();
           if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
              //���ü��scheduleITem�ġ���
              checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
           }else
           { //�������õ������У��Ƿ��Ѿ����Ѿ����ȹ�������

               ////System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
             //scheduleItemDtoList ��ָԭ���ӵ����Ѿ����ȹ������ݣ�������ô�������ǲ��ܱ�ɾ���ġ�
             //ֻҪ��� scheduleItemDtoList�д��� prpLscheduleItemList��û�еģ�������prpLscheduleItemList���ˡ�
             
            boolean blnotFind=true; 
            //scheduleItemDtoList���鿱�����ռ��ĵ�������
             for (int i =0;i<scheduleItemDtoList.size() ;i++)
             {
               prpLscheduleItemDto = new PrpLscheduleItemDto();
               prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
               //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
               blnotFind=true;
               for (int j =0;j<prpLscheduleItemList.size() ;j++)
               {
                 prpLscheduleItemoldDto= new PrpLscheduleItemDto();
                 prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
                 if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
                 { //������ھɵ����ݣ���Ҫ�þɵ����ݣ���Ҫ���µ�����
                   blnotFind=false;
                   break;
                 }
                 //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
               }
               
               if (blnotFind)  scheduleItemLastList.add(prpLscheduleItemDto) ;
             }
             
             //����ԭ���Ѿ����ȹ������������ӻ�ȥ
            scheduleItemLastList.addAll(prpLscheduleItemList);
            checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
           }
         }

		//Modify by chenrenda add begin 20050408
		//Reason:��ʧ��λģ����Ϣ�������永������Ϣ�У���Ӧģ��������
		/*---------------------��ʧ��λ PrpLthirdCarLoss begin------------------------------------*/
		ArrayList thirdCarLossDtoList = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = null;
		//�ӽ���õ���������
		String prpLthirdCarLossRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdCarLossRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String[] prpLthirdCarLossSerialNo = httpServletRequest
		.getParameterValues("RelateSerialNo");
		String[] prpLthirdCarLossItemNo = httpServletRequest
		.getParameterValues("prpLthirdCarLossItemNo");
		String[] prpLthirdCarLossLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdCarLossLicenseNo");
		//Modify by chenrenda update begin 20050407
		String[] prpLthirdCarLossPartCode = httpServletRequest
		.getParameterValues("partCode"); //��������
		String[] prpLthirdCarLossPartName = httpServletRequest
		.getParameterValues("partName"); //��������
		String[] prpLthirdCarLossCompCode = httpServletRequest
		.getParameterValues("compCode");//�������
		String[] prpLthirdCarLossCompName = httpServletRequest
		.getParameterValues("compName");//�������
		String[] prpLthirdCarLossLossGrade = httpServletRequest
		.getParameterValues("prpLthirdCarLossLossGrade");
		String[] prpLthirdCarLossLossDesc = httpServletRequest
		.getParameterValues("prpLthirdCarLossLossDesc");
		String[] prpLthirdCarLossFlag = httpServletRequest
		.getParameterValues("prpLthirdCarLossFlag");
		String[] prpLthirdCarLossKindCode = httpServletRequest
		.getParameterValues("kindCode"); //�ձ���� add by wuxiaodong
		// ���ղ鿰Ҫ����Զ���ͬʱ��
		
		//����ֵ
		//��ʧ��λ���ֿ�ʼ
		if (prpLthirdCarLossSerialNo == null) {
		} else {
			for (int index = 1; index < prpLthirdCarLossSerialNo.length; index++) {
				
				prpLthirdCarLossDto = new PrpLthirdCarLossDto();
				prpLthirdCarLossDto.setRegistNo(prpLthirdCarLossRegistNo);
				prpLthirdCarLossDto.setRiskCode(prpLthirdCarLossRiskCode);
				prpLthirdCarLossDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdCarLossSerialNo[index])));
				prpLthirdCarLossDto.setItemNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdCarLossItemNo[index])));
				prpLthirdCarLossDto
				.setLicenseNo(prpLthirdCarLossLicenseNo[index]);
				prpLthirdCarLossDto
				.setCompCode(prpLthirdCarLossCompCode[index]);
				prpLthirdCarLossDto
				.setCompName(prpLthirdCarLossCompName[index]);
				prpLthirdCarLossDto
				.setLossGrade(prpLthirdCarLossLossGrade[index]);
				prpLthirdCarLossDto
				.setLossDesc(prpLthirdCarLossLossDesc[index]);
				prpLthirdCarLossDto.setFlag(prpLthirdCarLossFlag[index]);
				prpLthirdCarLossDto
				.setPartCode(prpLthirdCarLossPartCode[index]);
				prpLthirdCarLossDto
				.setPartName(prpLthirdCarLossPartName[index]);
				if(prpLthirdCarLossKindCode!=null){
				prpLthirdCarLossDto
				.setKindCode(prpLthirdCarLossKindCode[index]);
				}
				//���뼯��
				thirdCarLossDtoList.add(prpLthirdCarLossDto);
			}
			//�鿱�����м�����ʧ��λ
			checkDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
		}
		/*---------------------��ʧ��λ PrpLthirdCarLoss end------------------------------------*/
		//Modify by chenrenda add end 20050408
		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//�ӽ���õ���������
		String prpLregistExtRegistNo = (String) httpServletRequest
		.getParameter("prpLregistExtRegistNo");
		String prpLregistExtRiskCode = httpServletRequest
		.getParameter("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest
		.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest
		.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest
		.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest
		.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest
		.getParameterValues("prpLregistExtContext");
		
		//����ֵ
		//��Ա�������� ���ֿ�ʼ
		if (prpLregistExtSerialNo == null) {
		} else {
			//System.out.println("��Ա�������ٲ��ֿ�ʼ ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
				.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//���������м�����ʧ��λ
			checkDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}
		//Modify by chenrenda add begin 20051418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��;�����ʧ��Ϣ����checkDto������
		checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		//Modify by chenrenda add end 20051418
		//add by qinyongli start 2005-8-30 ��������ղ鿱��Ϣ
		//modify by liuyanmei add ���������ְ���02%�� ��if�����м���02��
		UICodeAction uiCodeAction = new UICodeAction();
		if(prpLcheckLossRiskCode!=null&&prpLcheckLossRiskCode.length()>0){
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckLossRiskCode);
			
			if ("Y".equals(strRiskType)) {
				PrpLextDto prpLextDto = new PrpLextDto();
				
				String prpLextRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
				String prpLextAppliCheckDate = httpServletRequest
				.getParameter("prpLextAppliCheckDate");
				String prpLextAppliPhone = httpServletRequest
				.getParameter("prpLextAppliPhone");
				String prpLextInsuredPhone = httpServletRequest
				.getParameter("prpLextInsuredPhone");
				String prplextSailStartDate = httpServletRequest
				.getParameter("prplextSailStartDate");
				String prpLextSumValue = httpServletRequest
				.getParameter("prpLextSumValue");
				String prpLextLoadCheckCompany = httpServletRequest
				.getParameter("prpLextLoadCheckCompany");
				String prpLextUnloadDate = httpServletRequest
				.getParameter("prpLextUnloadDate");
				String prpLextCurrency = httpServletRequest
				.getParameter("prpLextCurrency");
				String prpLextValue2 = httpServletRequest
				.getParameter("prpLextValue2");
				String prpLextValue1 = httpServletRequest
				.getParameter("prpLextValue1");
				String prpLextRestQuantity = httpServletRequest
				.getParameter("prpLextRestQuantity");
				String prpLextLoadingNo = httpServletRequest
				.getParameter("prpLextLoadingNo");
				String prpLextInvoiceNo = httpServletRequest
				.getParameter("prpLextInvoiceNo");
				String prpLextSalvor = httpServletRequest
				.getParameter("prpLextSalvor");
				
				//��DTO��ֵ��������õ�����ֵ������DTO������
				prpLextDto.setCertiNo(prpLextRegistNo);
				prpLextDto.setCertiType("02");
				prpLextDto.setAppliCheckDate(new DateTime(prpLextAppliCheckDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setAppliPhone(prpLextAppliPhone);
				prpLextDto.setInsuredPhone(prpLextInsuredPhone);
				prpLextDto.setSailStartDate(new DateTime(prplextSailStartDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setCargoValue(Double.parseDouble(prpLextSumValue));
				prpLextDto.setCargoLossCheckCom(prpLextLoadCheckCompany);
				prpLextDto.setUnloadDate(new DateTime(prpLextUnloadDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setCurrency(prpLextCurrency);
				prpLextDto.setSalvor(prpLextSalvor);
				prpLextDto.setValue2(prpLextValue2);
				prpLextDto.setValue1(prpLextValue1);
				prpLextDto.setRestQuantity(Integer.parseInt(prpLextRestQuantity));
				prpLextDto.setRemark(prpLextLoadingNo);//�ñ�ע�洢���ᵥ�˵�����
				prpLextDto.setValue3(prpLextInvoiceNo);//value3�洢��Ʊ����
				checkDto.setPrpLextDto(prpLextDto);
				System.out.println("=====@@@@@@@@@@@@@@@@@#######$$$$$$%%%%%&&&&&&***currency=="+prpLextCurrency);
			}
			System.out.println("=====@@@@@@@@@@@@@@@@@####");
			//�����⽡����Ҫ������Ӧ�ĵ��������Ϣ
			strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckLossRiskCode);
			
			if ("E".equals(strRiskType)) {
				//�����Ӧ�ĵ����
				String prpLacciCheckCheckNo = httpServletRequest.getParameter("prpLacciCheckCheckNo");
				//��÷���������
				String[] prpLAcciCheckChargeCode = httpServletRequest.getParameterValues("prpLAcciCheckChargeCode");
				//��÷����������
				String[] prpLAcciCheckChargeName = httpServletRequest.getParameterValues("prpLAcciCheckChargeName");
				//��ñұ����
				String[] prpLAcciCheckChargeCurrency = httpServletRequest.getParameterValues("prpLAcciCheckChargeCurrency");
//				//��ñұ�����
//				String[] prpLAcciCheckChargeCurrencyName = httpServletRequest.getParameterValues("prpLAcciCheckChargeCurrencyName");
				//��÷��ý��
				String[] prpLAcciCheckChargeAmount = httpServletRequest.getParameterValues("prpLAcciCheckChargeAmount");
				//����������List
				List PrpLAcciCheckChargeList = new ArrayList();
				double chargeAmount = 0;
				for (int i = 1; i < prpLAcciCheckChargeCode.length; i++) {
					PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
					prpLAcciCheckChargeDto.setCheckNo(prpLacciCheckCheckNo);
					prpLAcciCheckChargeDto.setSerialNo(i);
					prpLAcciCheckChargeDto.setChargeCode(prpLAcciCheckChargeCode[i]);
					prpLAcciCheckChargeDto.setChargeName(prpLAcciCheckChargeName[i]);
					prpLAcciCheckChargeDto.setCurrency(prpLAcciCheckChargeCurrency[i]);
					chargeAmount = Double.valueOf(prpLAcciCheckChargeAmount[i]).doubleValue();
					prpLAcciCheckChargeDto.setChargeAmount(chargeAmount);
					PrpLAcciCheckChargeList.add(prpLAcciCheckChargeDto);
				}
				checkDto.getAcciCheckDto().setPrpLAcciCheckChargeDtoList(PrpLAcciCheckChargeList);
			}
		}
		return checkDto;
	}
	
	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��д�鿱��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public CheckDto iniViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		CheckDto checkDto = new CheckDto();
		return checkDto;
	}
	
	/**
	 * ��д�鿱ҳ�漰��ѯ�鿱request������.
	 * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CheckDto checkDto) throws Exception {
		//�õ�request��PrpLcheckForm������ʾ
		PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	public void checkDtoView(HttpServletRequest httpServletRequest,
			String checkNo) throws Exception {
		
		String riskCode = httpServletRequest.getParameter("riskCode");  
		//System.err.println("riskCode3:"+ riskCode);
		
	    String strRiskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
	    String editType     = httpServletRequest.getParameter("editType");
	    //System.err.println("editType:"+ editType);

		//�⽡����������ڵ�checktNoΪ�����,���ȴ���21λ,��Ҫ��ȡΪ21��.
//		if (checkNo.length() > 21) {
//			checkNo = checkNo.substring(0, 21);
//		}
//		
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	    //String lossItemName = "";
		// httpServletRequest.getParameter("lossItemName");
		//String insureCarFlag
		// =httpServletRequest.getParameter("insureCarFlag");
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(checkNo);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto = checkDto.getPrpLcheckDto();
		UICodeAction uiCodeAction =new UICodeAction();
		//ԭ�������⽡�ͷ������
		
		RegistDto registDto = new UIRegistAction().findByPrimaryKey(checkNo);
		
		if ("0310".equals(riskCode)||"0312".equals(riskCode))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//�嵥�б�
			if (checkNo != null)
			{
			
			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();

			if (editType.equals("EDIT") || editType.equals("SHOW"))
			{
				//String nodetype = httpServletRequest.getParameter("nodeType");
				//System.err.println("nodeType:"+ nodetype);
				String condition = " registno='" + checkNo + "' and nodetype='check' ";
				prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition);
			}
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
					
		    }
		}
		
		//�����Ϊ25λ�����ֲ鿱�š�Ϊ������鿴��ǰ�ĵ�����Ϣ add by xiatian 
		if ("E".equals(strRiskType) && checkNo.length()==25) {
			UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
			
			//������Ž��в�ѯ 2005-08-16
			AcciCheckDto acciCheckDto = uiAcciCheckAction
			.findByPrimaryKey(checkNo);
			PrpLacciCheckDto prpLacciCheckDto = acciCheckDto
			.getPrpLacciCheckDto();
			httpServletRequest.setAttribute("acciCheckDto",acciCheckDto);
			if (prpLacciCheckDto != null) {
				//�õ�����ʱ��
				prpLacciCheckDto.setDamageStartDate(acciCheckDto
						.getPrpLregistDto().getDamageStartDate());
				String timeTemp = StringConvert.toStandardTime(acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				prpLacciCheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
				prpLacciCheckDto.setDamageStartHour(timeTemp.substring(0, 2));
				prpLacciCheckDto.setDamageAddress(acciCheckDto
						.getPrpLregistDto().getDamageAddress());
				prpLacciCheckDto.setPolicyNo(acciCheckDto.getPrpLregistDto()
						.getPolicyNo());
				
				//�õ���ǰ��ʱ��
				prpLacciCheckDto.setCheckDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckHour(String.valueOf(DateTime.current()
						.getHour()));
				prpLacciCheckDto.setDamageStartMinute2(String.valueOf(DateTime
						.current().getMinute()));
				
				prpLacciCheckDto.setCheckEndDate(new DateTime(DateTime
						.current().toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckEndHour(String.valueOf(DateTime
						.current().getHour()));
				prpLacciCheckDto.setDamageStartMinute3(String.valueOf(DateTime
						.current().getMinute()));
				
				//���ӵ�����ñұ�start
			
				String currencyName = uiCodeAction.translateCurrencyCode(
						prpLacciCheckDto.getCurrency(), true);
				prpLacciCheckDto.setCurrencyName(currencyName);
				//���ӵ�����ñұ�end
				
				//��ӱ�ע��Ϣ
				//prpLacciCheckDto.setRemark(acciCheckDto.getPrpLregistDto().getRemark());
				httpServletRequest.setAttribute("prpLacciCheckDto",
						prpLacciCheckDto);
				
				//[��������]���������������б�׼������
				PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
				String tempContext = "";
				if (checkDto.getAcciCheckDto().getPrpLacciCheckTextDtoList() != null) {
					Iterator iterator = checkDto.getAcciCheckDto()
					.getPrpLacciCheckTextDtoList().iterator();
					while (iterator.hasNext()) {
						PrpLacciCheckTextDto prpLacciCheckTextDtoTemp2 = (PrpLacciCheckTextDto) iterator
						.next();
						tempContext = tempContext
						+ prpLacciCheckTextDtoTemp2.getContext();
					}
				}
				prpLacciCheckTextDto.setContext(tempContext);
				prpLacciCheckTextDto.setTextType("3");
				httpServletRequest.setAttribute("prpLacciCheckTextDto",
						prpLacciCheckTextDto);
				
				if (prpLcheckDto == null) {
					prpLcheckDto = new PrpLcheckDto();
				}
				
				if (checkDto.getPrpLclaimStatusDto() != null) {
					if (checkDto.getPrpLclaimStatusDto().getStatus()
							.equals("7"))
						checkDto.getPrpLclaimStatusDto().setStatus("3");
					prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
							.getStatus());
				} else {
					//���ύ���Ѿ�������ϵ�״̬
					prpLcheckDto.setStatus("4");
				}
				String nodeStatus = httpServletRequest.getParameter("status");
				if (nodeStatus != null) {
					prpLcheckDto.setStatus(nodeStatus);
				}
				
				prpLcheckDto.setRiskCode(acciCheckDto.getPrpLacciCheckDto()
						.getRiskCode());
				
				changeCodeToName(httpServletRequest, prpLcheckDto);
				
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				//��ѯ��ͬ�����ŵĳ��մ���
				//modify by zhulei 20050902 �⽡����Ҫ��ͬ�Ĵ�������PolicyNo��RegistNoȡ����ֵ
				//modify by   ��Ŀ��  ������ ����27�޸�Ϊ07
			    
				
					dAARegistViewHelper.getSamePolicyRegistInfo(
							httpServletRequest, acciCheckDto
							.getPrpLacciCheckDto().getPolicyNo(),
							acciCheckDto.getPrpLacciCheckDto().getRegistNo());
				
				//Modify by chenrenda add begin 20050418
				//Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
				String strPrpLnodeType = "check";
				httpServletRequest
				.setAttribute("prpLnodeType", strPrpLnodeType);
				//Modify by chenrenda add end 20050418
				
				//���ø����ӱ���Ϣ������
				//setSubInfo(httpServletRequest,checkDto);
				//���ù�������һ���ڵ��ύ��������Ϣ
				getSubmitNodes(httpServletRequest);
				//�������鿱��Ϣ���ݵ������
				httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
			} else {
				throw new Exception("���ݿ���û���������ݣ�");
			}
		} else {
			//modify by wangwei add end 2005-06-18
			
			//���ݲ�ѯ�������������ݣ���PrpLcheckDto��ֵ
			
			//Ϊ��ͬ��������
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&����������       "+prpLcheckDto);
			//     prpLcheckDto.setLossItemName(lossItemName);
			if(prpLcheckDto == null){
				httpServletRequest.setAttribute("errorMessage", "�ð��鿱��Ϣ�����ڣ����ܻ�δ���в鿱");
			}
			prpLcheckDto.setLossItemCode(prpLcheckDto.getReferSerialNo() + "");
			//     prpLcheckDto.setInsureCarFlag(insureCarFlag);
			//    System.out.println("------liujianbo-----"+prpLcheckDto.getLossItemCode()+"|"+prpLcheckDto.getLossItemName()+"|"+prpLcheckDto.getInsureCarFlag());
			//���ò鿱������״̬Ϊ �����޸� (����������)
			if (checkDto.getPrpLclaimStatusDto() != null) {
				if (checkDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					checkDto.getPrpLclaimStatusDto().setStatus("3");
				prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				//���ύ���Ѿ�������ϵ�״̬
				prpLcheckDto.setStatus("4");
			}
			String nodeStatus = httpServletRequest.getParameter("status");
			if (nodeStatus != null) {
				prpLcheckDto.setStatus(nodeStatus);
			}
			
			//UIRegistAction uiRegistAction = new UIRegistAction();
			//RegistDto registDto = uiRegistAction.findByPrimaryKey(checkNo);
		  //[û�г�����ʱ��ҳ���ϲ���ʾѡ���ĳ��Ƿ�����ı�־]-20060426-start--------------------------
		   String damageDate = String.valueOf(registDto.getPrpLregistDto()
					.getDamageStartDate());
			String damageHour = registDto.getPrpLregistDto()
					.getDamageStartHour();

			String kindCode = "";
			String kindAFlag = "0"; //����ʱ���ޱ������յı�־ 1���� 0����
			String kindBFlag = "0"; //����ʱ���ޱ������յı�־ 1���� 0����
			EndorseViewHelper endorViewHelper = new EndorseViewHelper();
			// ���ݳ���ʱ���ҵ�����
			PolicyDto damagePolicyDto = endorViewHelper.findForEndorBefore(
					registDto.getPrpLregistDto().getPolicyNo(), damageDate,
					damageHour);
			ArrayList prpCitemKindDtoList = new ArrayList();
			prpCitemKindDtoList = damagePolicyDto.getPrpCitemKindDtoList();
			if (prpCitemKindDtoList != null && prpCitemKindDtoList.size() > 0) {
				for (int k = 0; k < prpCitemKindDtoList.size(); k++) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpCitemKindDtoList
							.get(k);
					kindCode = prpCitemKindDto.getKindCode();
					if (kindCode.equals("A")) {
						kindAFlag = "1";
					}

				}
			}
			httpServletRequest.setAttribute("kindAFlag", kindAFlag);

           //[û�г�����ʱ��ҳ���ϲ���ʾѡ���ĳ��Ƿ�����ı�־]-20060426-end------------------------
			
			prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
					.getDamageStartDate());
			prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
					.getDamageEndDate());
			prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
					.getEstimateFee());
			prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
					.getEstimateLoss());
			//registDto.getPrpLregistDto().setDamageStartHour(StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageStartHour()));
			String timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageStartHour());
			prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
			timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageEndHour());
			prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
			//prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
			//		.getDamageAddress());
			//modify by lixiang add 20050308 start
			//reason:Ϊ�˱�֤���������߳���˳������
			//�������ȡ���ⰸ�ţ�������������
			//UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(checkNo, true);
			prpLcheckDto.setClaimNo(claimNo);
			//modify by lixiang add 20050308 end
			//modify by caopeng add 20051219 start
			if(registDto!=null && registDto.getPrpLregistDto()!=null){
				prpLcheckDto.setLossItemName(registDto.getPrpLregistDto().getLicenseNo());
				prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
			}
			//modify by caopeng add 20051219 end
			//������ش��������ת��
			changeCodeToName(httpServletRequest, prpLcheckDto);
			
			//���ô�����и�����ѡ�����б���Ϣ������
			setSelectionList(httpServletRequest, prpLcheckDto);
			DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
			//��ѯ��ͬ�����ŵĳ��մ���
			dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
					prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo());
			
			//Modify by chenrenda add begin 20050418
			//Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
			String strPrpLnodeType = "check";
			httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
			//Modify by chenrenda add end 20050418
			
			//���ø����ӱ���Ϣ������
			setSubInfo(httpServletRequest, checkDto);
			
			//���ù�������һ���ڵ��ύ��������Ϣ
			getSubmitNodes(httpServletRequest);
			//�������鿱��Ϣ���ݵ������
			httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
			
			//�ڽ�������ʾ�������� 2005-09-09
			httpServletRequest.setAttribute("riskCName", uiCodeAction
					.translateRiskCode(prpLcheckDto.getRiskCode(), true));
			
			httpServletRequest.setAttribute("prpLregistDto", registDto
					.getPrpLregistDto());
			//modify by wangwei add start 2005-06-15
			// ԭ��ת��������
			httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
					.getIdentifierName());
			//modify by wangwei add end 2005-06-15
			String policyNo = prpLcheckDto.getPolicyNo();
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			//add by qinyongli 2005-8-30 start
			//reason:���ӻ�������չ��Ϣ   
			//modify by liuyanmei add ���������ְ���02%��  ��if�����м���02��
		    strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
			if ("Y".equals(strRiskType)) {
				PrpLextDto prpLextDto = (PrpLextDto) checkDto.getPrpLextDto();
				
				String currency = prpLextDto.getCurrency();
				String currencyName = uiCodeAction.translateCurrencyCode(
						currency, true);
				prpLextDto.setCurrencyCname(currencyName);
				
				if (policyDto != null && prpLextDto != null) {
					prpLextDto.setSumAmount(String.valueOf(policyDto
							.getPrpCmainDto().getSumAmount())); //����ӱ�������
					prpLextDto.setLimitAmount("0"); //����� ��ʱδ��ֵ
					String rootComName = AppConfig.get("sysconst.ROOTCOMCNAME");
					prpLextDto.setPrpCompanyName(rootComName);
					ArrayList itemKind = policyDto.getPrpCitemKindDtoList();
					String itemAll = "";
					if (itemKind != null && itemKind.size() > 0) {
						Iterator item = itemKind.iterator();
						while (item.hasNext()) {
							PrpCitemKindDto itemKindDto = (PrpCitemKindDto) item
							.next();
							itemAll = itemAll + itemKindDto.getItemDetailName();
							double account = itemKindDto.getQuantity();
							String model = itemKindDto.getModel();
							if (account > 0) {
								itemAll = itemAll + "; ��" + account + model;
							}
							prpLextDto.setLimitAmount(String
									.valueOf(itemKindDto.getDeductible())); //�����
							break;
						}
					}
				}
				if (policyDto != null) {
					PrpCmainCargoDto prpCmainCargoDto = policyDto
					.getPrpCmainCargoDto();
					if("Y".equals(strRiskType)&&prpCmainCargoDto==null){
						prpCmainCargoDto = new PrpCmainCargoDto();
						prpCmainCargoDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
						prpCmainCargoDto.setEndSiteName("_____");
						prpCmainCargoDto.setEndSiteCode("");
						prpCmainCargoDto.setStartSiteCode("");
						prpCmainCargoDto.setStartSiteName("_____");
					}
					httpServletRequest.setAttribute("prpLcarGoDto", prpCmainCargoDto);
				}
				if (prpLextDto == null) {
					prpLextDto = new PrpLextDto();
				}
				httpServletRequest.setAttribute("prpLextDto", prpLextDto);
			}
			//add end by qinyongli
			
			//��ȡ������Ϣ
			//DAACertainLossViewHelper daaCertainLossViewHelper = new
			// DAACertainLossViewHelper();
			//daaCertainLossViewHelper.registDtoToView(httpServletRequest,checkNo,BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		}
	}
	
	/**
	 * ��д�鿱ҳ�漰��ѯ�鿱request������.
	 * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType) throws Exception {
		// �⽡����������ڵ�registNoΪ�����,���ȴ���21λ,��Ҫ��ȡΪ21��.
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}	
		
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	    if (user==null){
			user = new UserDto();
		}
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		registDto.getPrpLdriverDtoList();
	    UICheckAction uiCheckAction = new UICheckAction();
		UICodeAction uiCodeAction = new UICodeAction();
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		
		
        //[û�г�����ʱ��ҳ���ϲ���ʾѡ���ĳ��Ƿ�����ı�־]-20060426-start--------------------------
			
		String  damageDate = String.valueOf(registDto.getPrpLregistDto().getDamageStartDate());
		String  damageHour = registDto.getPrpLregistDto().getDamageStartHour();
		//String  policyNo   = registDto.getPrpLregistDto().getPolicyNo();
		String kindCode ="";
		String kindAFlag ="0";  //����ʱ���ޱ������յı�־ 1���� 0����
		String kindBFlag ="0";  //����ʱ���ޱ������յı�־ 1���� 0����
		EndorseViewHelper  endorViewHelper = new EndorseViewHelper();
		// ���ݳ���ʱ���ҵ�����
		PolicyDto damagePolicyDto = endorViewHelper.findForEndorBefore(registDto
				.getPrpLregistDto().getPolicyNo(), damageDate, damageHour);
        ArrayList  prpCitemKindDtoList =new ArrayList();
        prpCitemKindDtoList =  damagePolicyDto.getPrpCitemKindDtoList(); 
        if ( prpCitemKindDtoList!=null && prpCitemKindDtoList.size()>0){
		   for ( int k =0; k<prpCitemKindDtoList.size();k++){
			  PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) prpCitemKindDtoList.get(k);
			  kindCode = prpCitemKindDto.getKindCode();
			  if (kindCode.equals("A")) {
			  	  kindAFlag ="1";
			  }
			
		   }
        }
		httpServletRequest.setAttribute("kindAFlag",kindAFlag);
		
		
		//[û�г�����ʱ��ҳ���ϲ���ʾѡ���ĳ��Ƿ�����ı�־]-20060426-end--------------------------
		
			
		//ԭ�������⽡�ͷ������
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if ( "E".equals(strRiskType) ) {
			UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
			
			//������Ž��в�ѯ 2005-08-16
			AcciCheckDto acciCheckDto = uiAcciCheckAction
			.findByPrimaryKey(httpServletRequest.getParameter("keyIn"));
			PrpLacciCheckDto prpLacciCheckDto = acciCheckDto
			.getPrpLacciCheckDto();
			httpServletRequest.setAttribute("acciCheckDto",acciCheckDto);
			
			if (prpLacciCheckDto != null) {
				//�õ�����ʱ��
				prpLacciCheckDto.setDamageStartDate(acciCheckDto
						.getPrpLregistDto().getDamageStartDate());
				String timeTemp = StringConvert.toStandardTime(acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				prpLacciCheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
				prpLacciCheckDto.setDamageStartHour(timeTemp.substring(0, 2));
				prpLacciCheckDto.setDamageAddress(acciCheckDto
						.getPrpLregistDto().getDamageAddress());
				prpLacciCheckDto.setPolicyNo(acciCheckDto.getPrpLregistDto()
						.getPolicyNo());
				
				//�ӱ������еõ����մ���ͳ���ԭ�� 2005-09-02
				prpLacciCheckDto.setDamageCode(registDto.getPrpLregistDto()
						.getDamageCode());
				prpLacciCheckDto.setDamageName(registDto.getPrpLregistDto()
						.getDamageName());
				
				//�ӱ������еõ��¹����� 205-09-06
				prpLacciCheckDto.setDamageTypeCode(registDto.getPrpLregistDto()
						.getDamageTypeCode());
				prpLacciCheckDto.setDamageTypeName(registDto.getPrpLregistDto()
						.getDamageTypeName());
				
				//�õ���ǰ��ʱ��
				prpLacciCheckDto.setCheckDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckHour(String.valueOf(DateTime.current()
						.getHour()));
				prpLacciCheckDto.setDamageStartMinute2(String.valueOf(DateTime
						.current().getMinute()));
				
				prpLacciCheckDto.setCheckEndDate(new DateTime(DateTime
						.current().toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckEndHour(String.valueOf(DateTime
						.current().getHour()));
				prpLacciCheckDto.setDamageStartMinute3(String.valueOf(DateTime
						.current().getMinute()));
				
				//��ӱ�ע��Ϣ
				prpLacciCheckDto.setRemark(acciCheckDto.getPrpLregistDto()
						.getRemark());
				//����Ĭ�ϱұ�Ϊ"�����"
				prpLacciCheckDto.setCurrency("CNY");
				String currencyName = uiCodeAction.translateCurrencyCode(
						prpLacciCheckDto.getCurrency(), true);
				prpLacciCheckDto.setCurrencyName(currencyName);
				httpServletRequest.setAttribute("prpLacciCheckDto",
						prpLacciCheckDto);
				//����������-----------------------------------------------------
				//���Ҵ�����б�
				/* Collection collection = uiCodeAction.getCurrencyList();
				 Iterator iterator1 = collection.iterator();
				 HashMap currencyTemp = new HashMap();
				 while (iterator1.hasNext()) {
				 PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto) iterator1.next();
				 currencyTemp.put(prpDcurrencyDto.getCurrencyCode(), prpDcurrencyDto.getCurrencyCName());
				 }
				 
				 Collection arrayList3 = new ArrayList();
				 PrpLchargeDto prpLchargeDto = new PrpLchargeDto();
				 arrayList3 = acciCheckDto.getPrpLchargeDtoList();
				 if (arrayList3 != null) {
				 Iterator iteraotrChargeDto = arrayList3.iterator();
				 PrpLchargeDto prpLchargeDtoTemp = null;
				 while (iteraotrChargeDto.hasNext()) {
				 prpLchargeDtoTemp = (PrpLchargeDto) iteraotrChargeDto.next();
				 prpLchargeDtoTemp.setKindName(uiCodeAction.translateKindCode(prpLchargeDtoTemp.getRiskCode(),
				 prpLchargeDtoTemp.getKindCode(), true));
				 
				 
				 if (currencyTemp.containsKey(prpLchargeDtoTemp.getCurrency())) {
				 prpLchargeDtoTemp.setCurrencyName(currencyTemp.get(prpLchargeDtoTemp.getCurrency()).toString());
				 }
				 }
				 }
				 prpLchargeDto.setPrpLchargeList(arrayList3);
				 httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);
				 
				 */
				
				
				//------------------------------------------------------------------
				//[��������]���������������б�׼������
				PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
				String tempContext = "";
				if (registDto.getAcciCheckDto().getPrpLacciCheckTextDtoList() != null) {
					Iterator iterator = registDto.getAcciCheckDto()
					.getPrpLacciCheckTextDtoList().iterator();
					while (iterator.hasNext()) {
						PrpLacciCheckTextDto prpLacciCheckTextDtoTemp2 = (PrpLacciCheckTextDto) iterator
						.next();
						tempContext = tempContext
						+ prpLacciCheckTextDtoTemp2.getContext();
					}
				}
				prpLacciCheckTextDto.setContext(tempContext);
				prpLacciCheckTextDto.setTextType("3");
				httpServletRequest.setAttribute("prpLacciCheckTextDto",
						prpLacciCheckTextDto);
				//add by qinyongli begin 2005-7-19
				//�õ�������Ϣ
				String policyNo = prpLacciCheckDto.getPolicyNo();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
						policyNo, acciCheckDto.getPrpLregistDto()
						.getDamageStartDate().toString(), acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				if (policyDto != null) {
					httpServletRequest.setAttribute("coinsFlag", policyDto
							.getPrpCmainDto().getCoinsFlag());
					httpServletRequest.setAttribute("shareHolderFlag",
							policyDto.getPrpCmainDto().getShareHolderFlag());
				}
				//add by qinyongli end 2005-7-19
			} else {
				throw new Exception("���ݿ���û���������ݣ�");
			}
		}
		
		//ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		com.sinosoft.claim.ui.control.action.UIClaimAction uiClaimAction = new com.sinosoft.claim.ui.control.action.UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
		.findByPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);
		
		//ԭ����Ҫ�ڻ����յĲ鿱ҳ���б����д���鿱����λ
		/*
		 * UIPolicyAction uiPolicyAction = new UIPolicyAction(); PolicyDto
		 * policyDto =
		 * uiPolicyAction.findByPrimaryKey(registDto.getPrpLregistDto().getPolicyNo());
		 * if (policyDto.getPrpCmainCargoDto() != null) { if
		 * (policyDto.getPrpCmainCargoDto().getRiskCode().startsWith("10")) {
		 * httpServletRequest.setAttribute("com.sinosoft.agentCode",
		 * uiCodeAction.translateAgentName(policyDto.getPrpCmainCargoDto().getCheckAgentCode())); }
		 * else { httpServletRequest.setAttribute("com.sinosoft.agentCode", ""); } }
		 * else { httpServletRequest.setAttribute("com.sinosoft.agentCode", ""); }
		 */
		httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
				.getIdentifierName());
		//modify by wangwei add end 2005-06-07
		
		//��ѯ�Ƿ��Ѿ�¼����鿱��Ϣ��
		
		if (uiCheckAction.isExist(registNo)) {
			//System.out.println("�Ѿ��в鿱��Ϣ��");
			checkDtoView(httpServletRequest, registNo);
			return;
		}
		String insureCarFlag = httpServletRequest.getParameter("insureCarFlag"); //�Ƿ�Ϊ����������
		String lossItemCode = httpServletRequest.getParameter("lossItemCode"); //��ʧ���
		String lossItemName = httpServletRequest.getParameter("lossItemName"); //��������
		
		//�������ֵ�Ļ������¸����渴��
		
		//���ݲ�ѯ�������������ݣ���PrpLcheckDto��ֵ
		//������ֵ
		//prpLcheckDto.setInsureCarFlag(insureCarFlag);
		prpLcheckDto.setReferSerialNo(1);
		//prpLcheckDto.setLossItemCode(lossItemCode);
		//prpLcheckDto.setLossItemName(lossItemName);
		
		prpLcheckDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		//����ڲ鿱ǰ�Ѿ������ˣ���ô��������ⰸ�ŷ���Ļ��������
		
		prpLcheckDto.setClaimNo(claimNo);
		prpLcheckDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		prpLcheckDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		//prpLcheckDto.setCheckType("L");
		
		////�鿱����Ĳ鿱�����ɵ��ȱ���� 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckType(registDto.getPrpLscheduleMainWFDto()
					.getFlag());
		}
		
		//modify by wangwei add start 20050602
		//ԭ�����ӱ�����ͱ������
		prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
				.getEstimateLoss());
		prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
				.getEstimateFee());
		//modity by wangwei add end 20050602
		
		//prpLcheckDto.setCheckNature(registDto.getPrpLregistDto().getCheckNature());
		//prpLcheckDto.setCheckDate(registDto.getPrpLregistDto().getCheckDate());
		prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//modify by lixiang remark 20050309 start
		// prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//reason:�鿱������յص��ɱ����������鿱��ַĬ��Ϊ���յص�
		//modify by lixiang remark 20050309 end
		
		//�鿱����Ĳ鿱��ַ�ɵ��ȱ���� 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckSite(registDto.getPrpLscheduleMainWFDto()
					.getCheckSite());
		}
		
		prpLcheckDto.setFirstSiteFlag(registDto.getPrpLregistDto()
				.getFirstSiteFlag());
		prpLcheckDto.setClaimType(registDto.getPrpLregistDto().getClaimType());
		
		//================�������ⰸ��ʱ�õ����鿰 �ⰸ����ȴ�����ȡ������û�дӱ���ȡ===============================
		if ("D".equals(strRiskType) && registClaimDtoList != null && registClaimDtoList.size() > 0) {
			Iterator it = registClaimDtoList.iterator();
			while(it.hasNext()){
                RegistClaimInfoDto registClaimDto = (RegistClaimInfoDto) it.next();
                if(registClaimDto.getRegistNo().equals(registNo)){
                	if(registClaimDto.getClaimType() != null && !registClaimDto.getClaimType().equals("")){
                		prpLcheckDto.setClaimType(registClaimDto.getClaimType());
                	}
                	break;
                }
		
            }
		}   
		
		//================================================================================================
		
		
		prpLcheckDto
		.setDamageCode(registDto.getPrpLregistDto().getDamageCode());
		prpLcheckDto
		.setDamageName(registDto.getPrpLregistDto().getDamageName());
		prpLcheckDto.setDamageTypeCode(registDto.getPrpLregistDto()
				.getDamageTypeCode());
		prpLcheckDto.setDamageTypeName(registDto.getPrpLregistDto()
				.getDamageTypeName());
		//prpLcheckDto.setReferKind(registDto.getPrpLregistDto().getReferKind());
		/////////////////////////bobobo//////////////////
		prpLcheckDto.setReferKind("A,M,L");
		prpLcheckDto.setDamageAreaCode(registDto.getPrpLregistDto()
				.getDamageAreaCode());
		prpLcheckDto.setDamageAddressType(registDto.getPrpLregistDto()
				.getDamageAddressType());
		//prpLcheckDto.setIndemnityDuty(registDto.getPrpLregistDto().getIndemnityDuty());
		//prpLcheckDto.setClaimFlag(registDto.getPrpLregistDto().getClaimFlag());
		
		//modify by lixiang add 20050304 start
		//reason:�鿱��1Ĭ��Ϊ������Զ������
		
		prpLcheckDto.setChecker1(user.getUserName());
		//System.out.println("prpLcheckDto.setChecker1"+prpLcheckDto.getChecker1());
		//modify by lixiang add 20050304 end
		
		//prpLcheckDto.setChecker2(registDto.getPrpLregistDto().getChecker2());
		//prpLcheckDto.setCheckUnitName(registDto.getPrpLregistDto().getCheckUnitName());
		prpLcheckDto
		.setHandleUnit(registDto.getPrpLregistDto().getHandleUnit());
		prpLcheckDto.setRemark(registDto.getPrpLregistDto().getRemark());
		prpLcheckDto.setFlag(registDto.getPrpLregistDto().getFlag());
		
		//add by wuxiaodong 050905 beegain reasion �û���ʾ����ʱ�ıұ�
		prpLcheckDto
		.setCurrency(registDto.getPrpLregistDto().getEstiCurrency());
		//add by wuxiaodong 050905 end
		
		prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
				.getDamageAddress());
		prpLcheckDto.setStatus(registDto.getPrpLregistDto().getStatus());
		prpLcheckDto.setEditType(registDto.getPrpLregistDto().getEditType());
		prpLcheckDto
		.setClauseType(registDto.getPrpLregistDto().getClauseType());
		prpLcheckDto
		.setClauseName(registDto.getPrpLregistDto().getClauseName());//code
		prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
				.getDamageStartDate());
		//prpLcheckDto.setDamageStartHour(registDto.getPrpLregistDto().getDamageStartHour());
		
		prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
				.getDamageEndDate());
		
		//��鿱ҳ����ӱ���������Ϣ  2005-09-26
		prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
		
		//prpLcheckDto.setDamageEndHour(registDto.getPrpLregistDto().getDamageEndHour());
		String timeTemp = StringConvert.toStandardTime(registDto
				.getPrpLregistDto().getDamageStartHour());
		prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
		timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto()
				.getDamageEndHour());
		prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
		
		prpLcheckDto.setDamageAreaName(registDto.getPrpLregistDto()
				.getDamageAreaName());
		//prpLcheckDto.setHandleUnitName(registDto.getPrpLregistDto().getHandleUnitName());//δ֪
		
		//Ĭ�ϲ鿱����
		prpLcheckDto.setCheckDate(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_DAY));
		//���ò鿱������״̬Ϊ �°����Ǽ� (δ��������)
		prpLcheckDto.setStatus("1");
		
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLcheckDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		//System.out.println("prpLcheckDto.getHandleUnitName()="+prpLcheckDto.getHandleUnitName()
		// );
		setSelectionList(httpServletRequest, prpLcheckDto);
		//��ѯ��ͬ�����ŵĳ��մ���
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo());
		
		//�������鿱��Ϣ���ݵ������
		//��������߳�������ô��Ϊ�����棬��Ҫͨ��У�飬���Ա������ض����з����ʼ������ֵ
		/*
		 * if
		 * ((prpLcheckDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA")))&&!insureCarFlag.equals("1")) {
		 * prpLcheckDto.setCheckSite("0 "); prpLcheckDto.setChecker1("0");
		 * prpLcheckDto.setChecker2("0 ");
		 * 
		 * }else {//Ĭ��ֵ prpLcheckDto.setInsureCarFlag("1");
		 * prpLcheckDto.setReferSerialNo(1); }
		 */
		//���ø����ӱ���Ϣ������
		CheckDto checkDto = new CheckDto();
		/*
		 * ArrayList arraylist1= new ArrayList();
		 * if(registDto.getPrpLthirdPartyDtoList() != null) {
		 * arraylist1.add(registDto.getPrpLthirdPartyDtoList().get(0)); }
		 */
		checkDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
		checkDto.setPrpLdriverDtoList(registDto.getPrpLdriverDtoList());
		checkDto.setPrpLpersonTraceDtoList(registDto
				.getPrpLpersonTraceDtoList());
		checkDto.setPrpLthirdCarLossDtoList(registDto
				.getPrpLthirdCarLossDtoList());
		checkDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
		checkDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
		//modify by luqin add 2005-06-21 start
		checkDto.setPrpLregistTextDtoList(registDto.getPrpLregistTextDtoList());
		//modify by luqin add 2005-06-21 end
		
		//modify by wangli add start 20050408
		//�����ر�Լ����Ϣ
		checkDto.setPrpLcheckDto(prpLcheckDto);
		//modify by wangli add end 20050408
		
		//Modify by chenrenda add begin 20050418
		//Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
		String strPrpLnodeType = "check";
		httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
		//Modify by chenrenda add end 20050418
		
		 CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
		 checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList());

		//���ø����ӱ��е���Ϣ����ʾ
		setSubInfo(httpServletRequest, checkDto);
		
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
		
		//��ȡ������Ϣ
		DAACertainLossViewHelper daaCertainLossViewHelper = new DAACertainLossViewHelper();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
		daaCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		
		
		//�ڽ�������ʾ�������� 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcheckDto.getRiskCode(), true));
		
		String policyNo = prpLcheckDto.getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				registDto.getPrpLregistDto().getDamageStartDate().toString(),
				registDto.getPrpLregistDto().getDamageStartHour());
		if (policyDto != null) {
			httpServletRequest.setAttribute("coinsFlag", policyDto
					.getPrpCmainDto().getCoinsFlag());
			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());
		}
		//add by qinyongli 2005-8-30 start
		//reason:���ӻ�������չ��Ϣ
		 strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
		if ("Y".equals(strRiskType)) {
    		PrpLextDto prpLextDto = new PrpLextDto();
			String itemAll = "";
			//��ѯ��ϵ��ʽ 1.��������2.Ͷ����
			if (policyDto != null) {
				ArrayList insuredList = policyDto.getPrpCinsuredDtoList();
				if (insuredList != null && insuredList.size() > 0) {
					Iterator insured = insuredList.iterator();
					while (insured.hasNext()) {
						PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) insured
						.next();
						if (prpCinsuredDto.getInsuredFlag().equals("1")
								&& !prpCinsuredDto.getPhoneNumber().equals("")) {//��������
							prpLextDto.setInsuredPhone(prpCinsuredDto
									.getPhoneNumber());
						} else if (prpCinsuredDto.getInsuredFlag().equals("2")
								&& !prpCinsuredDto.getPhoneNumber().equals("")) {//Ͷ����
							prpLextDto.setAppliPhone(prpCinsuredDto
									.getPhoneNumber());
						}
					}
					
				}
				prpLextDto.setSailStartDate(policyDto.getPrpCmainDto()
						.getStartDate());//�������ڣ�ȡ������
				prpLextDto.setSumAmount(String.valueOf(policyDto
						.getPrpCmainDto().getSumAmount())); //����ӱ�������
				
				prpLextDto.setCargoValue(policyDto.getPrpCmainDto()
						.getSumValue()); //����
				String rootComName = AppConfig.get("sysconst.ROOTCOMCNAME");
				prpLextDto.setPrpCompanyName(rootComName);
				ArrayList itemKind = policyDto.getPrpCitemKindDtoList();
				if (itemKind != null && itemKind.size() > 0) {
					Iterator item = itemKind.iterator();
					
					while (item.hasNext()) {
						PrpCitemKindDto itemKindDto = (PrpCitemKindDto) item
						.next();
						itemAll = itemAll + itemKindDto.getItemDetailName();
						double account = itemKindDto.getQuantity();
						String model = itemKindDto.getModel();
						if (account > 0) {
							itemAll = itemAll + "; ��" + account + model;
						}
						prpLextDto.setLimitAmount(String.valueOf(itemKindDto
								.getDeductible())); //�����
						break;
					}
					if (itemAll.length() > 29) {
						itemAll = itemAll.substring(0, 28);
					}
				}
				prpLextDto.setValue1(itemAll); //���ձ��
				//modify by wuxiaodong 050905 begai reasion
				// ����ҵ������䷽ʽ�����ߵĴ洢�ֶβ�Ψһ�������ڴ˴�Ҫ��һ������
				PrpCmainCargoDto prpCmainCargoDto = policyDto
				.getPrpCmainCargoDto();
				if("Y".equals(strRiskType)&&prpCmainCargoDto==null){
					prpCmainCargoDto = new PrpCmainCargoDto();
					prpCmainCargoDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
					prpCmainCargoDto.setEndSiteName("_____");
					prpCmainCargoDto.setEndSiteCode("");
					prpCmainCargoDto.setStartSiteCode("");
					prpCmainCargoDto.setStartSiteName("_____");
				}
				prpLextDto.setValue3(prpCmainCargoDto.getInvoiceNo()); //��Ʊ����
				prpLextDto.setRemark(prpCmainCargoDto.getLadingNo() 
						+ prpCmainCargoDto.getCarryBillNo());
				if (prpCmainCargoDto != null) {
					if (prpCmainCargoDto.getBLNo() == null
							|| prpCmainCargoDto.getBLNo() == "") {
						prpCmainCargoDto
						.setBLNo(uiCodeAction.translateCodeCode(
								"ConveyanceType", prpCmainCargoDto
								.getConveyance(), true));
					}
				}
				prpLextDto.setValue2(String.valueOf(registDto
						.getPrpLregistDto().getEstimateLoss())); //������
				prpLextDto.setCurrency("CNY");
				prpLextDto.setCurrencyCname("�����");
				httpServletRequest.setAttribute("prpLcarGoDto",
						prpCmainCargoDto);
				//modify by wuxiaodong 050905 end
			}
			httpServletRequest.setAttribute("prpLextDto", prpLextDto);
		}
		
		//add end by qinyongli
		//////////
	}
	
	/**
	 * �����ⰸ�źͱ����Ų�ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param registNo
	 *            �ⰸ��
	 * @param claimNo
	 *            ������
	 * @throws Exception
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo) throws Exception {
		logger.info("�����ⰸ�źͱ����Ų�ѯ�鿱��Ϣ == DAACheckViewHelper -- setPrpLcheckDtoToView");
		//checkNo,policyNo,claimNo
		//��������ı����ţ��鿱������SQL where �Ӿ�
		policyNo = StringUtils.rightTrim(policyNo);
		registNo = StringUtils.rightTrim(registNo);
		String conditions = "";
		conditions = " registNo = '" + registNo + "' and policyNo = '" + policyNo + "'";
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		Collection checkList = new ArrayList();
		checkList = (Collection) uiCheckAction.findByConditions(conditions);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest);
	}
	
	//add by zhaolu 20060802 start
	//reason:���ӷ�ҳ��ѯ
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,String pageNo,String recordPerPage) throws Exception {
		//��������ı����ţ��鿱������SQL where �Ӿ�
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		int intPageNo = Integer.parseInt(pageNo);
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		String conditions = " 1=1 ";
		//���������ũ�ձ�ʶ
		conditions = conditions +" and a.registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='check') "; 
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
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
		//add by zhouliu start at 2006-6-9
		//reason:ǿ����ѯ
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
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
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		
		
	    // ƴȨ��
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by zhaolu 20060816 end
		//modify by wangwei add start 2005-06-13
		//ԭ����Ҫ���ݲ�ͬ��������ѯ����պͷ��⽡��
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by  ������Ŀ��  ������  27�����޸�Ϊ07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		
		//modify by wangwei add end 2005-06-13    
		
		//     ��Ϊprplcheck������comcode�ֶΣ�������ʹ��addPower������������ʹ�ñ�����prpLregist��������
		//modify by zhaolu 20060816 start
		
		conditions = conditions
	   	+ " and ( 1=1 " +uiPowerInterface.addPower(userDto,"gg","","handledept");
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"gg","","comcode").replaceFirst("AND", "or") + ")";
		//modify by zhaolu 20060816 end

		String condition = httpServletRequest.getParameter("condition");
		if(condition != null)
		{
			conditions = condition;
		}
		
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		ArrayList checkList = new ArrayList();
		//Collection checkList = new ArrayList();
		
		PageRecord pageRecord = null;
		
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//ԭ���⽡�պͷ��⽡�ղ�ѯ��ͬ�ı�
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditionsAcci(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditionsAcci(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
			
		} else {
			
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditions(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
		}
		//modify by wangwei add end 2005-06-18
		TurnPageDto turnPageDto = new TurnPageDto();
		turnPageDto.setResultList(checkList);
		turnPageDto.setPageNo(pageRecord.getPageNo());
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		turnPageDto.setTotalCount(pageRecord.getCount());
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		turnPageDto.setCondition(conditions);
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		prpLcheckDto.setTurnPageDto(turnPageDto);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	//add by zhaolu 20060802 end
	
	
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
			CheckDto checkDto) throws Exception {
		
		//��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(checkDto.getPrpLcheckDto().getRegistNo());
		prpLregistExtDto.setRiskCode(checkDto.getPrpLcheckDto().getRiskCode());
		arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
		
		//[�鿱����]�������ļ������б�׼������
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (checkDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
				.next();
				tempContext = tempContext + prpLregistTextDtoTemp.getContext();
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("3");
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
		
		//[�永����]�����߳��������б�׼������
		Collection arrayList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
		arrayList = checkDto.getPrpLthirdPartyDtoList();
		prpLthirdPartyDto.setThirdPartyList(arrayList);
		prpLthirdPartyDto.setNodeType("check");
		httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);
		
		//[��ʻԱ]����ʻԱ���ж����б�׼������
		Collection arrayListDriver = new ArrayList();
		PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
		arrayListDriver = checkDto.getPrpLdriverDtoList();
		prpLdriverDto.setDriverList(arrayListDriver);
		httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
		
		//[�鿱��Ϣ]�鿱��������б�׼������
		/*
		 * Collection arrayLTextList = new ArrayList(); PrpLregistTextDto
		 * prpLregistTextDto = new PrpLregistTextDto();
		 * prpLregistTextDto.setTextType("3") ; arrayLTextList =
		 * checkDto.getPrpLregistTextDtoList() ;
		 * prpLregistTextDto.setRegistTextList(arrayLTextList) ;
		 * httpServletRequest.setAttribute("prpLregistTextDto",
		 * prpLregistTextDto);
		 */
		//�鿱��չ��Ϣ�����б�׼������
		Collection arrayList1 = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = new PrpLcheckExtDto();
		arrayList1 = checkDto.getPrpLcheckExtDtoList();
		prpLcheckExtDto.setPrpLcheckExtList(arrayList1);
		httpServletRequest.setAttribute("prpLcheckExtDto", prpLcheckExtDto);
		
		//�¹ʹ���������б�׼������
		ArrayList arrayList2 = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
		arrayList2 = checkDto.getPrpLcheckLossDtoList();
		if (arrayList2 != null) {
			for (int indexCheck = 0; indexCheck < arrayList2.size(); indexCheck++) {
				PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
				prpLcheckLossDto1 = (PrpLcheckLossDto) arrayList2
				.get(indexCheck);
				
				UICodeAction uiCodeAction = new UICodeAction();
				//���ձ����ת��
				String kindCode = prpLcheckLossDto1.getKindCode();
				String riskcode = checkDto.getPrpLcheckDto().getRiskCode();
		        //ת�ɶ�Ӧ����ҵ�������ֺ�
		        TransCodeCI transCodeCI = new TransCodeCI();
		        String busiRiskCode = transCodeCI.convertToRiskCodeBusi(riskcode);
				String kindName = uiCodeAction.translateKindCode(
						busiRiskCode, kindCode, true);
				prpLcheckLossDto1.setKindName(kindName);
			}
		}
		prpLcheckLossDto.setPrpLcheckLossList(arrayList2);
		httpServletRequest.setAttribute("prpLcheckLossDto", prpLcheckLossDto);
		
		//����Ա�������ٶ��ж����б�׼������
		Collection arrayListPersonTrace = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
		arrayListPersonTrace = checkDto.getPrpLpersonTraceDtoList();
		prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace);
		prpLpersonTraceDto.setNodeType("check");
		//Modify by chenrenda 20050409 begin
		
		if (checkDto.getPrpLpersonTraceDtoList() != null) {
			Iterator personTraceDtoList = arrayListPersonTrace.iterator();
			while (personTraceDtoList.hasNext()) {
				PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto) personTraceDtoList
				.next();
				String strReferKind = prplpersonTraceDto.getReferKind();
				prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
			}
		}
		//Modify by chenrenda 20050409 end
		
		httpServletRequest.setAttribute("prpLpersonTraceDto",
				prpLpersonTraceDto);
		
		//modify by wangli add start 20050407
		//��ѯ������Ϣ ��ʾ�ر�Լ���б�
		String policyNo = checkDto.getPrpLcheckDto().getPolicyNo();
		ArrayList itemKindList = new ArrayList();
		Collection itemKindListNew = new ArrayList();
		//���ݱ����Ų�ѯ�ر�Լ����Ϣ
		String registNo = checkDto.getPrpLcheckDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		
		//�ж��Ƿ����
		BLPrpLRegistRPolicyFacade blRegistRPolicy = new BLPrpLRegistRPolicyFacade();
		boolean compelFlag = blRegistRPolicy.getCompelFlag(registNo);
		if (compelFlag){
           httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		}

		if (!policyNo.equals("") && policyNo != null) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			
			itemKindList = policyDto.getPrpCitemKindDtoList();
			checkDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		}
		//�ر�Լ����Ϣ�����б�׼������
		Collection cengageList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		cengageList = checkDto.getPrpCengageDtoList();
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
		//modify by wangli add end 20050407
		
		//Modify by chenrenda add 20050409 begin
		//Reason:���˸�����Ϣģ�����漰�������б���ѡ��ʽ��ʾ
		//���ձ����Ƹĳ�D1-������Ա�����յķ�ʽ,ֻ�����������복����Ա������
		
		Collection prpLcheckInsuredItemKindNew = new ArrayList();
		Collection prpLcheckThirdItemKindNew = new ArrayList();
		/*------------------------------------------
		for (int i = 0; i < itemKindList.size(); i++) {
			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemKindList
			.get(i);
			prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-"
					+ prpCitemKindDto.getKindName());
			if (prpCitemKindDto.getKindCode().equalsIgnoreCase("B")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D3")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D4")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("A")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")) {
				itemKindListNew.add(prpCitemKindDto);
			}
			prpLcheckItemKindNew.add(prpCitemKindDto);
		}------------------------------------------------*/
	
		if (compelFlag){//�������
			String mainPolicyNo ="";	
			PrpLRegistRPolicyDto prpLregistRPolicyDto=(PrpLRegistRPolicyDto) httpServletRequest.getAttribute("prpLregistRPolicyNo");
			if ( prpLregistRPolicyDto !=null){
				mainPolicyNo =prpLregistRPolicyDto.getPolicyNo();
			}
			EndorseViewHelper  endorseViewHelper =new EndorseViewHelper();
			if ( mainPolicyNo !=null && !mainPolicyNo.equals("")  && !policyNo.equals(mainPolicyNo)){	//��ʱ������ 
				PolicyDto mainPolicyDto = endorseViewHelper.findForEndorBefore(mainPolicyNo);
				ArrayList itemKindList_qs = mainPolicyDto.getPrpCitemKindDtoList();
				for(int index = 0;index < itemKindList_qs.size();index++){
					PrpCitemKindDto  prpCitemKindDto_qs = (PrpCitemKindDto)itemKindList_qs.get(index);
					itemKindList.add(prpCitemKindDto_qs);
				}
			}
		}
		itemKindListNew = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
		Collection prpLcheckItemKindNew = new ArrayList();
		Collection prpLcheckPropItemKindNew = new ArrayList();
		prpLcheckPropItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdPropLoss",itemKindList);
		prpLcheckItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("MainCarLoss",itemKindList);
		prpLcheckThirdItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdCarLoss",itemKindList);
		prpLcheckItemKindNew.addAll(prpLcheckThirdItemKindNew);
		httpServletRequest.setAttribute("referKindList", itemKindListNew);
		httpServletRequest.setAttribute("prpLcheckPropItemKindList", prpLcheckPropItemKindNew);
		httpServletRequest.setAttribute("prpLcheckItemKindList",
				prpLcheckItemKindNew); 
		
		
				
		//Modify by chenrenda add 20050409 end
		
		//Modify by chenrenda add begin 20050408
		//Reason:��ʧ��λģ��ϵ��浽������Ϣ�к�������Ӧģ��������
		//����ʧ��λ���ж����б�׼������
		Collection arrayListThirdCarLoss = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = new PrpLthirdCarLossDto();
		arrayListThirdCarLoss = checkDto.getPrpLthirdCarLossDtoList();
		prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss);
		httpServletRequest.setAttribute("prpLthirdCarLossDto",
				prpLthirdCarLossDto);
		
		//Reason:��ʧ��λ��ʾ��Ϊ�б��ʽ
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());
		//Modify by chenrenda add end 20050408
		
		//Modify by chenrenda add begin 20050412
		//Reason:�ڲ鿱ҳ���м���������ʧģ��
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		//prpLthirdPropDto.setPrpLthirdPropKindCode("B");
		httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
		
		//Modify by chenrenda add end 20050412
		
	}
	
	/**
	 * ��ȡѡ�����б���е���������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLcheckDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		
		//�鿱�����б�
		Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("checkNatures", checkNatures);
		//�ⰸ���
		Collection caseCodes = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("caseCodes", caseCodes);
		//���յص����
		Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("damageAddresss", damageAddresss);
		//�¹��⳥����
		Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);
		
		//�õ�ʵ�������б�
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		//�õ����������б��б�
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		//�õ����յ�ַ�����б�
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", BusinessRuleUtil.getOuterCode(
						httpServletRequest, "RISKCODE_DAA"));
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		//�õ����������б�
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//�õ����Ƶ�ɫ�б�
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		//�õ��⳥�����б�
		Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
		//�õ��ⰸ����б�
		Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("escapeFlags", escapeFlags);
		//�õ��õ��Ա�
		Collection driverSex = uiCodeAction.getCodeType("SexCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("driverSexs", driverSex);
		//�õ�ְҵ����
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		//�õ��Ļ��̶�
		Collection education = uiCodeAction.getCodeType("Education",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("educations", education);
		//�õ�֤������
		Collection identifyTypes = uiCodeAction.getCodeType("IdentifyType",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("identifyTypes", identifyTypes);
	}
	
	/**
	 * ����PrpCheckDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLcheckDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(1)�������Ƶ�ת��
		String clauseType = prpLcheckDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLcheckDto.setClauseName(clauseName);
		prpLcheckDto.setDamageAreaName(uiCodeAction.translateCodeCode(
				"DamageAreaCode", prpLcheckDto.getDamageAreaCode(), true));
		
		//(2)�����ŵ�����ת��
		String strHandleUnit = prpLcheckDto.getHandleUnit();
		String strHandleUnitName = uiCodeAction.translateComCode(strHandleUnit,
				true);
		
		//System.out.println("strHandleUnitName
		// =================================="+strHandleUnitName );;
		prpLcheckDto.setHandleUnitName(strHandleUnitName);
	}
	
	public void getCheckScheduleDtoToView(HttpServletRequest httpServletRequest)
	throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// Ŀ����ȡ��û�б�������ϵĵ�������Ȼ��list������
		Collection scheduleDtoList = new ArrayList();
		UICheckAction uiCheckAction = new UICheckAction();
		//���ҷ��������ĵ�������
		String conditions = "";
		//conditions = " CheckFlag='0' order by registNo,scheduleid " ;
		conditions = " selectSend='1' and insurecarflag='1' order by registNo,scheduleid";
		
		System.out.println("����ǰ.");
		scheduleDtoList = (Collection) uiCheckAction
		.findNewScheduleTaskList(conditions);
		System.out.println("������." + scheduleDtoList.toString());
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		
		scheduleDtoList = changeOperatorCodeToName(scheduleDtoList);
		prpLcheckItemDto.setCheckItemList(scheduleDtoList);
		// prpLcheckItemDto.setCheckOperatorCode(user.getUserCode() );
		//����ѯ������ �����б�ŵ���������ʾ
		// httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto)
		// ;
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
		
	}
	
	private Collection changeOperatorCodeToName(Collection scheduleList)
	throws Exception {
		Collection scheduleListChange = new ArrayList();
		Iterator it = scheduleList.iterator();
		UICodeAction uiCodeAction = new UICodeAction();
		
		String operatorCode = "";
		String operatorName = "";
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			operatorCode = prpLcheckItemDto.getOperatorCode();
			operatorName = uiCodeAction.translateUserCode(operatorCode, true);
			prpLcheckItemDto.setOperatorName(operatorName);
			scheduleListChange.add(prpLcheckItemDto);
		}
		return scheduleListChange;
	}
	
	public void getCheckScheduleDealDtoToView(
			HttpServletRequest httpServletRequest, String registNo,
			String scheduleID) throws Exception {
		
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		int intscheduleID = Integer.parseInt(scheduleID);
		
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		//������չ����
		prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto()
				.getLinkerName());
		prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto()
				.getPhoneNumber());
		//prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
		if (registDto.getPrpLregistTextDtoList() != null) {
			PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto = (PrpLregistTextDto) registDto
			.getPrpLregistTextDtoList().iterator().next();
			prpLscheduleMainWFDto.setRegistText(prpLregistTextDto.getContext());
		}
		
		//���ò鿱������״̬Ϊ �����޸� (����������)
		if (scheduleDto.getPrpLclaimStatusDto() != null) {
			prpLscheduleMainWFDto.setStatus(scheduleDto
					.getPrpLscheduleMainWFDto().getStatus());
		} else {
			//���ύ���Ѿ�������ϵ�״̬
			prpLscheduleMainWFDto.setStatus("4");
		}
		
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//������ش��������ת��
		//changeCodeToName(httpServletRequest,scheduleDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		// setSelectionList(httpServletRequest,scheduleDto);
		//�������鿱��Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLscheduleMainWFDto",
				prpLscheduleMainWFDto);
		//���ø����ӱ���Ϣ������
		setCheckItemInfo(httpServletRequest, scheduleDto);
	}
	
	/**
	 * ����Dto�еĸ��ӱ��ڵ���Ϣ������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param scheduleDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void setCheckItemInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception {
		ArrayList checkItemList = new ArrayList();
		checkItemList = scheduleDto.getPrpLcheckItemDtoList();
		/*
		 * Iterator it = scheduleItemList.iterator() ; int i =1;
		 * 
		 * while (it.hasNext() ) { PrpLscheduleItemDto prpLscheduleItemDto =new
		 * PrpLscheduleItemDto(); prpLthirdPartyTempDto
		 * =(PrpLthirdPartyDto)it.next() ; prpLscheduleItemDto.setScheduleID
		 * (scheduleDto.getPrpLscheduleMainWFDto().getScheduleID() );
		 * prpLscheduleItemDto.setRegistNo
		 * (scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
		 * prpLscheduleItemDto.setItemNo (i);
		 * prpLscheduleItemDto.setInsureCarFlag
		 * (prpLthirdPartyTempDto.getInsureCarFlag ());
		 * prpLscheduleItemDto.setClaimComCode
		 * (scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode ());
		 * //prpLscheduleItemDto.setSelectSend ("0");
		 * //prpLscheduleItemDto.setSurveyTimes ();
		 * //prpLscheduleItemDto.setSurveyType
		 * (prpLthirdPartyTempDto.getSurveyType ());
		 * //prpLscheduleItemDto.setCheckSite
		 * (prpLthirdPartyTempDto.getCheckSite ());
		 * prpLscheduleItemDto.setLicenseNo (prpLthirdPartyTempDto.getLicenseNo
		 * ()); //prpLscheduleItemDto.setScheduleObjectID
		 * (prpLthirdPartyTempDto.getScheduleObjectID ());
		 * //prpLscheduleItemDto.setScheduleObjectName
		 * (prpLthirdPartyTempDto.getScheduleObjectName());
		 * prpLscheduleItemDto.setInputDate (new
		 * DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY)); //
		 * prpLscheduleItemDto.setResultInfo
		 * (prpLthirdPartyTempDto.getResultInfo ()); //
		 * prpLscheduleItemDto.setBookFlag (prpLthirdPartyTempDto.getBookFlag
		 * ()); // prpLscheduleItemDto.setScheduleType
		 * (prpLthirdPartyTempDto.getScheduleType ()); //���뼯��
		 * scheduleItemList.add(prpLscheduleItemDto); i++; }
		 */
		scheduleDto.setPrpLscheduleItemDtoList(checkItemList);
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		prpLcheckItemDto.setCheckItemList(checkItemList);
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
	}
	
	/**
	 * ����鿱ʱ�鿱ҳ����������.
	 * 
	 * @param httpServletRequest
	 * @return scheduleDto �鿱���ݴ������ݽṹ
	 * @throws Exception
	 */
	public ScheduleDto checkViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String registNo = httpServletRequest
		.getParameter("prpLscheduleMainWFRegistNo"); //������
		String scheduleID = httpServletRequest
		.getParameter("prpLscheduleMainWFScheduleID"); //���Ⱥ�
		String prpLscheduleMainWFCheckFlag = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckFlag"); //�鿱״̬
		String prpLscheduleMainWFCheckInfo = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckInfo"); //�鿱�������
		//String prpLscheduleMainWFCheckInputDate=
		String prpLscheduleMainWFCheckOperatorCode = user.getUserCode();
		int intscheduleID = Integer.parseInt(scheduleID);
		
		//���ȴ����ݿ���ȡ�õ��ȵ�������Ϣ
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		prpLscheduleMainWFDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
		prpLscheduleMainWFDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
		prpLscheduleMainWFDto.setCheckInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLscheduleMainWFDto
		.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//-------------����������-------------------------------
		ArrayList checkItemList = new ArrayList();
		ArrayList checkItemListTemp = new ArrayList();
		checkItemListTemp = scheduleDto.getPrpLcheckItemDtoList();
		Iterator it = checkItemListTemp.iterator();
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			prpLcheckItemDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
			prpLcheckItemDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
			//prpLcheckItemDto.setInputDate(new
			// DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLcheckItemDto
			.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
			//����鿱��ļ���
			checkItemList.add(prpLcheckItemDto);
		}
		// ���ȼ������޸Ĳ鿱���
		scheduleDto.setPrpLcheckItemDtoList(checkItemList);
		return scheduleDto;
	}
	
	/**
	 * �����ⰸ��,������,����״̬�����ƺ��룬����ʱ���ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param claimNo
	 *            �ⰸ��
	 * @param registNo
	 *            ������
	 * @param licenseNo
	 *            ���ƺ�
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//��������ı����ţ��鿱������SQL where �Ӿ�
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		String conditions = " 1=1 ";
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:ǿ����ѯ
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		//     ƴȨ��
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by wangwei add start 2005-06-13
		//ԭ����Ҫ���ݲ�ͬ��������ѯ����պͷ��⽡��
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by   ��Ŀ��  ������  27�����޸�Ϊ07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		//modify by wangwei add end 2005-06-13    
		
		//     ��Ϊprplcheck������comcode�ֶΣ�������ʹ��addPower������������ʹ�ñ�����prpLregist��������
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"c","","ComCode");
		
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//ԭ���⽡�պͷ��⽡�ղ�ѯ��ͬ�ı�
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			checkList = (Collection) uiCheckAction
			.findByQueryConditionsAcci(conditions);
		} else {
			checkList = (Collection) uiCheckAction
			.findByQueryConditions(conditions);
		}
		//modify by wangwei add end 2005-06-18
		
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	/**
	 * ��ѯ��������������ѡ��Ľڵ�����
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest)
	throws Exception {
		String modelNo = httpServletRequest.getParameter("modelNo"); //ģ���
		String nodeNo = httpServletRequest.getParameter("nodeNo"); //�ڵ��
		int nextNodeNo = 0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		System.out.println("$$$$$$$$$$$$$$$$44" + modelNo + "++" + nodeNo);
		if (modelNo != null && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo, nodeNo);
			if (pathList.iterator().hasNext()) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}
	
}