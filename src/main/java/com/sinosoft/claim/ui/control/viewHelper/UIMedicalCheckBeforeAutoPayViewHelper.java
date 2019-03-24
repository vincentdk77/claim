package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterPayBackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.webservice.PayExtDto;
import com.sinosoft.claim.webservice.PayRequestInfo;
import com.sinosoft.claim.webservice.PaymentInfoDto;
import com.sinosoft.sff.blsvr.BLPrpJpackDetail;

/**
 * �ӿڴ�������ĺϷ���У����
 * 
 * */
public class UIMedicalCheckBeforeAutoPayViewHelper {
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param payRequestInfo
	 * 
	 * */
	public String checkBeforePay(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFields(payRequestInfo);
		if(returnStr.equals("")){
			returnStr = this.checkFlagFieldsRange(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkReceiverAndPaymentType(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkOutId(payRequestInfo);
		}
		if(returnStr.equals("")){
			returnStr = this.checkRelationOutId(payRequestInfo);
		}
		
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkNotNullFields(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		if(null == payRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(payRequestInfo.getOutId()==null || "".equals(payRequestInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getOperateType()==null || "".equals(payRequestInfo.getOperateType())){
			returnStr = "0^�������Ͳ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getReceiverTypeOther()==null || "".equals(payRequestInfo.getReceiverTypeOther())){
			returnStr = "0^��������ʹ��벻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getReceiverTypeOtherName()==null || "".equals(payRequestInfo.getReceiverTypeOtherName())){
			returnStr = "0^������������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getReceiverFullName()==null || "".equals(payRequestInfo.getReceiverFullName())){
			returnStr = "0^��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getCertifType()==null || "".equals(payRequestInfo.getCertifType())){
			returnStr = "0^�����֤�����Ͳ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getCertifNo()==null || "".equals(payRequestInfo.getCertifNo())){
			returnStr = "0^֤�����벻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getProvinceCode()==null || "".equals(payRequestInfo.getProvinceCode())){
			returnStr = "0^ʡ�����Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getCityCode()==null || "".equals(payRequestInfo.getCityCode())){
			returnStr = "0^�������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getAccountType()==null || "".equals(payRequestInfo.getAccountType())){
			returnStr = "0^�˺����Բ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getBankType()==null || "".equals(payRequestInfo.getBankType())){
			returnStr = "0^���д��಻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getBank()==null || "".equals(payRequestInfo.getBank())){
			returnStr = "0^�������в���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getBankAccount()==null || "".equals(payRequestInfo.getBankAccount())){
			returnStr = "0^�����˺Ų���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getBankAccount2()==null || "".equals(payRequestInfo.getBankAccount2())){
			returnStr = "0^�����˺Ų���Ϊ��";
			return returnStr;
		}
		if(!payRequestInfo.getBankAccount2().equals(payRequestInfo.getBankAccount())){
			returnStr = "0^���������˺Ų�һ��";
			return returnStr;
		}
		if(payRequestInfo.getMobilePhone()==null || "".equals(payRequestInfo.getMobilePhone())){
			returnStr = "0^�ֻ����벻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getAddress()==null || "".equals(payRequestInfo.getAddress())){
			returnStr = "0^��ϸ��ַ����Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getPayWay()==null || "".equals(payRequestInfo.getPayWay())){
			returnStr = "0^֧����ʽ����Ϊ��";
			return returnStr;
		}
//		if(payRequestInfo.getPayPurpose()==null || "".equals(payRequestInfo.getPayPurpose())){
//			returnStr = "0^��;˵������Ϊ��";
//			return returnStr;
//		}
		if(payRequestInfo.getOperatorCode() == null || "".equals(payRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getOperatorName() == null || "".equals(payRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getMakeCom() == null || "".equals(payRequestInfo.getMakeCom())){
			returnStr = "0^�����˻�������Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getMakeComName() == null || "".equals(payRequestInfo.getMakeComName())){
			returnStr = "0^�����˻������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getOperatorDate()==null || "".equals(payRequestInfo.getOperatorDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getHandleText()==null || "".equals(payRequestInfo.getHandleText())){
			returnStr = "0^֧�������������Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getAccountFlag()==null || "".equals(payRequestInfo.getAccountFlag())){
			returnStr = "0^�˺������������Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getHandleDate()==null || "".equals(payRequestInfo.getHandleDate())){
			returnStr = "0^֧������ͨ��ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getHandleCode()==null || "".equals(payRequestInfo.getHandleCode())){
			returnStr = "0^֧��������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(payRequestInfo.getPaymentInfoDto()==null || payRequestInfo.getPaymentInfoDto().length==0){
			returnStr = "0^�⸶��Ϣ����Ϊ��";
			return returnStr;
		} else {
			PaymentInfoDto[] paymentInfoDtos = payRequestInfo.getPaymentInfoDto();
			PaymentInfoDto paymentInfoDto = null;
			for(int i=0;i<paymentInfoDtos.length;i++){
				if(paymentInfoDtos[i] != null){
					paymentInfoDto = paymentInfoDtos[i];
					if(paymentInfoDto.getRelationOutId()==null || "".equals(paymentInfoDto.getRelationOutId())){
						returnStr = "0^�⸶��Ϣ�еĹ��������������Ϊ��";
						return returnStr;
					}
					if(paymentInfoDto.getRelationOutIdType()==null || "".equals(paymentInfoDto.getRelationOutIdType())){
						returnStr = "0^�⸶��Ϣ�еĹ����������Ͳ���Ϊ��";
						return returnStr;
					}else{
						String relationOutIdType = "N,R";
						if(!relationOutIdType.contains(paymentInfoDto.getRelationOutIdType())){
							returnStr = "0^�⸶��Ϣ�еĹ����������Ͳ��Ϸ�";
							return returnStr;
						}
					}
					if(paymentInfoDto.getInsuredNamePay()==null || "".equals(paymentInfoDto.getInsuredNamePay())){
						returnStr = "0^�⸶��Ϣ�еı������˲���Ϊ��";
						return returnStr;
					}
					if(paymentInfoDto.getPaymentType()==null || "".equals(paymentInfoDto.getPaymentType())){
						returnStr = "0^�⸶��Ϣ�е�����������Ʋ���Ϊ��";
						return returnStr;
					}else{
						String paymentType = "Ԥ�����,���,�������,���ٲ÷� ,��ִ�з�,�����鿱��,��ʩ�ȷ�,�����Ϸ�,��ϵͳ�ڴ��鿱," +
								"������/����,�ⲿ���鿱��,����ʦ��,������,����������,�������鿱��,���ݰ��⸶,���ⲹ�ձ���,�帶��," +
								"Ԥ�������,Ԥ���ٲ÷�,Ԥ��ִ�з�,Ԥ�������鿱��,Ԥ�����Ϸ�,Ԥ���ڲ����鿱��,Ԥ���ⲿ���鿱��,Ԥ����ʦ��";
						if(!paymentType.contains(paymentInfoDto.getPaymentType())){
							returnStr = "0^�⸶��Ϣ�е�������Ͳ��Ϸ�";
							return returnStr;
						}
					}
					if(paymentInfoDto.getPaymentTypeCode()==null || "".equals(paymentInfoDto.getPaymentTypeCode())){
						returnStr = "0^�⸶��Ϣ�е�������ʹ��벻��Ϊ��";
						return returnStr;
					}else{
						String paymentTypeCode = "P50,P60,P61,P611,P612,P62,P63,P64,P65,P66,P67,P68,P69,P6B,P70,P71,P72," +
								"P97,Y61,Y611,Y612,Y62,Y64,Y65,Y67,Y68";
						if(!paymentTypeCode.contains(paymentInfoDto.getPaymentTypeCode())){
							returnStr = "0^�⸶��Ϣ�е�������ʹ��벻�Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^�⸶��Ϣ����Ϊ��";
					return returnStr;
				}
			}
			
		}
		PayExtDto[] payExtDtos = payRequestInfo.getPayExtDto();
		if(payExtDtos!=null && payExtDtos.length>0){
			PayExtDto payExtDto = null;
			for(int i=0;i<payExtDtos.length;i++){
				if(payExtDtos[i] != null){
					payExtDto = payExtDtos[i];
					if(payExtDto.getOperatorCodeName()==null || "".equals(payExtDto.getOperatorCodeName())){
						returnStr = "0^��������еĲ����˲���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^�����������Ϊ��";
					return returnStr;
				}
			}
		}
		
		return returnStr;
	}
	
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ��Ϸ�
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkFlagFieldsRange(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		
		String operateType = "A,U";
		if(!operateType.contains(payRequestInfo.getOperateType())){
			returnStr = "0^�������Ͳ��Ϸ�";
			return returnStr;
		}
		String receiverTypeOther = "t01,t02,t03,t04,t05,t06,t07,t08,t09,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20";
		if(!receiverTypeOther.contains(payRequestInfo.getReceiverTypeOther())){
			returnStr = "0^��������ʹ��벻�Ϸ�";
			return returnStr;
		}
		String receiverTypeOtherName = "��������,�鿱ֱ������,����������λ,�鿱��Ա,����Ժ,��������,���ά�޵�λ," +
				"�������,��Ԯ����,��������,��ʦ����,��������,������λ,�ܺ���Ա,����ҽԺ,��������,��������,�ٲû���,�໤��,ί�д�����";
		if(!receiverTypeOtherName.contains(payRequestInfo.getReceiverTypeOtherName())){
			returnStr = "0^������������Ʋ��Ϸ�";
			return returnStr;
		}
		String certifType = "01,02,04,05,07,51,71,72,73";
		if(!certifType.contains(payRequestInfo.getCertifType())){
			returnStr = "0^�����֤�����Ͳ��Ϸ�";
			return returnStr;
		}
		String certifTypeName = "�������֤,���񻧿ڱ�,����֤,ʿ��֤,�й�����,�������,��֯��������֤,˰��Ǽ�֤,Ӫҵִ��";
		if(!certifTypeName.contains(payRequestInfo.getCertifTypeName())){
			returnStr = "0^�����֤���������Ʋ��Ϸ�";
			return returnStr;
		}
		if(payRequestInfo.getUrgentType()!=null && !"".equals(payRequestInfo.getUrgentType())){
			String urgentType = "0.5,1,2,3,4,8,24,48";
			if(!urgentType.contains(payRequestInfo.getUrgentType())){
				returnStr = "0^�����̶Ȳ��Ϸ�";
				return returnStr;
			}
		}
		if(payRequestInfo.getUrgentTypeName()!=null && !"".equals(payRequestInfo.getUrgentTypeName())){
			String urgentTypeName = "30����,1Сʱ,2Сʱ,3Сʱ,4Сʱ,8Сʱ,24Сʱ,48Сʱ";
			if(!urgentTypeName.contains(payRequestInfo.getUrgentTypeName())){
				returnStr = "0^�����̶����Ʋ��Ϸ�";
				return returnStr;
			}
		}
		String provinceCode = "����,�Ϻ�,���,����,�ӱ�,ɽ��,���ɹ�,����,����,������,����,�㽭,����,����,����,ɽ��," +
				"����,����,����,�㶫,����,�Ĵ� ,����,����,����,����,����,�ຣ,����,����,�½�,���,����,̨��";
		if(!provinceCode.contains(payRequestInfo.getProvinceCode())){
			returnStr = "0^ʡ�����Ʋ��Ϸ�";
			return returnStr;
		}
		/*String cityCode = "����,�Ϻ�,����,��ݸ,÷��,����,��β,����,ï��,��ɽ,����,�麣,��Զ,�ع�,��ͷ,����,��Դ,տ��,����," +
				"��ɽ,����,���,����,�Ͼ�,��,����,����,����,����,����,��Ǩ,��̨,̩��,��ͨ,����,����,����,����,����,���Ƹ�," +
				"����,�γ�,����,�˻�,����,����,����,����,��ɽ,����,��Ϫ,����,����,����,��ɽ,����,����,��Ҧ,�ٺ�,��,��ˮ," +
				"��ɽ,����,��,̨��,�ɶ�,����,����,�Ű�,����,����,�ϳ�,�ڽ�,�˱�,����,��ɽ,��֦��,����,��Ԫ,����,����,����," +
				"�Թ�,����,����,����,ͨʲ,����,��ƽ,����,ʯʨ,����,����,����,����,Ȫ��,����,����,����,����,�Ͳ�,��Ӫ,���,��̨," +
				"�ൺ,����,����,����,����,����,�ĳ�,����,����,Ϋ��,����,����,̩��,��̩,����,����,��ׯ,�ϲ�,������,ӥ̶,����,����," +
				"����ɽ,�ٴ�,�Ž�,����,����,Ƽ��,����,����,����,��ɫ,����,����,����,�ӳ�,ƾ��,����,����,����,���,����,�Ϸ�,����," +
				"����,����,����,�ߺ�,��ɽ,ͭ��,����,����,����,����,����,����,����,��ɽ,����,ʯ��ׯ,����,��̨,����,��ͷ,��ɽ,������," +
				"����,����,�ȷ�,�Ϲ�,��ˮ,ɳ��,����,����,�ػʵ�,�е�,����,�żҿ�,֣��,����,�ױ�,���,פ���,�ܿ�,����,����,����,����," +
				"����,���,�к�,����,ƽ��ɽ,����Ͽ,����,����,�人,����,Ӧ��,����,ɳ��,����,����,����,����,�Ϻӿ�,ʮ��,֦��,����,���," +
				"Т��,��½,���,ʯ��,��ʯ,��Ѩ,�差,����,������,�˲�,��ʩ,�Ƹ�,��ɳ,����,����,����,����,��ӹ,��Դ,����,����,����,����," +
				"��̶,����,����,����,����,¦��,��ˮ��,�齭,����,����,��ˮ̲,����,μ��,�Ӱ�,����,����,����,����,ͭ��,̫ԭ,����,�ٷ�,�˳�," +
				"����,�ܴ�,��ͬ,����,��Ȫ,����,������,�ض�,����,�׸�,˫Ѽ,ĵ����,����,����,�ں�,����,�绯,��ľ˹,��̨��,ͬ��,��ں�," +
				"�������,����,�������,����,����,��˳,����,����,��Ϫ,����,�˳�,��Ʊ,�̽�,����,����,��ɽ,Ӫ��,�߷���,����,����,����,����," +
				"����,����,�Ӽ�,����,ͨ��,�뽭,��ƽ,��Դ,���,����,���,ͼ��,�ػ�,����,÷�ӿ�,������,�׳�,����,����,��Զ,����,��ɽ,����," +
				"��ͨ,����,����,����,ͭ��,����,����,��ˮ,����ˮ,����,��˳,����,����,����,��Ҵ,������,���,ƽ��,����,����,��Ȫ,����,��ˮ," +
				"����,���ͺ���,��������,�ٺ�,��ʤ,������,���,��������,���ֹ���,����,��ͷ,�ں�,������,����ʯ,���ֺ���,ͨ��,������,����,����," +
				"��ͭϿ,ʯ��ɽ,����,�տ���,��³ľ��,ʯ����,����,����,����̩,����,������,��ͼʲ,����,����,��������,����,��³��,�����,��ʲ,����," +
				"����,���ľ,�����,���,����,̨��";
		if(!cityCode.contains(payRequestInfo.getCityCode())){
			returnStr = "0^�������Ʋ��Ϸ�";
			return returnStr;
		}*/
		String accountType = "1,2";
		if(!accountType.contains(payRequestInfo.getAccountType())){
			returnStr = "0^�˺����Բ��Ϸ�";
			return returnStr;
		}
		/*String bankType = "ũҵ����,��ͨ����,��������,�������,��������,��������,��������,�ַ�����,��������,�㷢����,�й�����,���ҿ�������," +
				"�й�����������,�й�ũҵ��չ����,��������,�㶫��չ����,���ڷ�չ����,��ҵ����,������ҵ����,����ũ����ҵ����,�������,��������," +
				"ũ���������,�������йɷ����޹�˾,�������йɷ����޹�˾,�������������ι�˾,����������,ũ�������纬����ũ����ҵ����,�й�������������," +
				"�������,��������,������ҵ����,���������й����޹�˾,�й�����������޹�˾,�����������޹�˾,�����������޹�˾,��չ�����й����޹�˾," +
				"���������й����޹�˾,��¡����,���������й����޹�˾,�����������޹�˾,Ħ����ͨ�����й����޹�˾,���ⶫ�����������й����޹�˾," +
				"�ձ�����ס�����йɷ����޹�˾,��۵�������,����ʵҵ�����й����޹�˾,�ձ�ɽ�����йɷ����޹�˾,�����⻻���йɷ����޹�˾,���������й����޹�˾," +
				"������ҵ����,�º������й����޹�˾,������С��ҵ�������޹�˾,���������й����޹�˾,���������й����޹�˾,�������й����޹�˾," +
				"��չ�����й����޹�˾,̩���̹����д������޹�˾,�µ�������������йɷ����޹�˾,����ʱ�������йɷ����޹�˾,����ʱ��ͨ�������޹�˾," +
				"��������,�����������йɷ����޹�˾,��������,Ӣ���ո����ʼ����й������޹�˾,������ҵ�����й����޹�˾,���������������йɷ����޹�˾," +
				"������ó���йɷ����޹�˾,�¹�����˹�����йɷݹ�˾,����־�����й����޹�˾,�¹���ҵ���йɷ����޹�˾,�¹��������йɷ����޹�˾," +
				"�¹��ͷ�����������,�¹�������־������,���������ʥ�������йɷ����޹�˾,��ʿ�Ŵ����йɷ����޹�˾,��ʿ����,���ô��ҵ�������޹�˾," +
				"���ô����������������޹�˾,�Ĵ����Ǻ����������м������޹�˾,Ħ��ʿ�������������й����޹�˾,���������й����޹�˾,���������������޹�˾," +
				"���Ź�������,�������������й����޹�˾,��������,��һ����,���ŵ�������,��������,���ҽ��,��������,ũҵ����,";
		if(!bankType.contains(payRequestInfo.getBankType())){
			returnStr = "0^���д��಻�Ϸ�";
			return returnStr;
		}*/
		String payWay = "1,2";
		if(!payWay.contains(payRequestInfo.getPayWay())){
			returnStr = "0^֧����ʽ���Ϸ�";
			return returnStr;
		}
		String accountFlag = "00,01,02,03";
		if(!accountFlag.contains(payRequestInfo.getAccountFlag())){
			returnStr = "0^�˺����Ͳ��Ϸ�";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * У���ڲ�ͬ״̬���ⲿoutId�Ƿ���Ч��������Ӧ������Ϣ
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkOutId(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String outId = payRequestInfo.getOutId();
		String operateType = payRequestInfo.getOperateType();
		BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
		Collection collection = blPrpLinterPayRequestFacade.findByConditions(" outId='"+outId+"' order by inputDate desc ");
		if(operateType.equals("A")){
			if(collection!=null && collection.size()>0){
				returnStr = "2^�������Ѿ�������֧��ϵͳ";
				return returnStr;
			}
		}
		if(operateType.equals("U")){
			if(collection==null || collection.size()<1){
				returnStr = "0^������δ������֧��ϵͳ�����ܽ��и���֧����Ϣ����";
				return returnStr;
			}else{
				PrpLinterPayRequestDto prpLinterPayRequest = (PrpLinterPayRequestDto)collection.iterator().next();
				String id = prpLinterPayRequest.getId();
				//����outid ��prplinterpaydetail�����ҵ� paymentno
				BLPrpLinterPayDetailFacade blPrpLinterPayDetailFacade = new BLPrpLinterPayDetailFacade();
				BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
				Collection payDetailList = blPrpLinterPayDetailFacade.findByConditions(" outid='"+outId+"' and id='"+id+"' ");
				if(payDetailList!=null && payDetailList.size()>0){
					PrpLinterPayDetailDto prpLinterPayDetailDto = (PrpLinterPayDetailDto)payDetailList.iterator().next();
					if(prpLinterPayDetailDto!=null && "1".equals(prpLinterPayDetailDto.getVericSuccFlag())){
						PrpLpaymainDto prpLpaymainDto = blPrpLpaymainFacade.findByPrimaryKey(prpLinterPayDetailDto.getPaymentNo());
						if(prpLpaymainDto!=null){
							if(!"9".equals(prpLpaymainDto.getVflag())){
								returnStr = "0^����δ�����˻�״̬�����ܽ��и���֧����Ϣ����";
								return returnStr;
							}
						}else{
							returnStr = "0^����δ�����˻�״̬�����ܽ��и���֧����Ϣ����";
							return returnStr;
						}
					}else{
						returnStr = "0^��δ��ɵĽ��������������ٴθ���";
						return returnStr;
					}
				}else{
					returnStr = "0^û�鵽���֧����Ϣ�����ܽ��и���֧����Ϣ����";
					return returnStr;
				}
				//����֧���ӿ��ڡ�U����ʱ������:�˻ؽ��׽��ճɹ����жϣ��м���¼���е��˻صĽ���
				BLPrplinterPayBackDetailFacade blPrplinterPayBackDetailFacade = new BLPrplinterPayBackDetailFacade();
				Collection payBackDetailList = blPrplinterPayBackDetailFacade.findByConditions(" relationId='"+id+"' ");
				if(payBackDetailList!=null && payBackDetailList.size()>0){
					PrplinterPayBackDetailDto prplinterPayBackDetailDto = (PrplinterPayBackDetailDto)payBackDetailList.iterator().next();
					String mutualSuccFlag = prplinterPayBackDetailDto.getMutualSuccFlag();
					if(prplinterPayBackDetailDto==null || (!"1".equals(mutualSuccFlag) && !"2".equals(mutualSuccFlag))){
						returnStr = "0^֧���˻����ݽ���ʧ�ܣ����ܽ��и���֧����Ϣ����";
						return returnStr;
					}
				}else{
					returnStr = "0^û�в鵽���֧���˻���Ϣ�����ܽ��и���֧����Ϣ����";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * У���ڲ�ͬ״̬���ⲿrelationOutId�Ƿ���Ч��������Ӧ������Ϣ
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkRelationOutId(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String key = "";
		
		Map<String,PaymentInfoDto> map = new HashMap<String,PaymentInfoDto>();
		PaymentInfoDto[] paymentDtos = payRequestInfo.getPaymentInfoDto();
		for(int i=0;i<paymentDtos.length;i++){
			String relationOutId = paymentDtos[i].getRelationOutId();
			String relationOutIdType = paymentDtos[i].getRelationOutIdType();
			if(relationOutIdType.equals("R")){
				BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
				BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
				Collection recaseList = blPrpLinterRecaseRequestFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(recaseList==null || recaseList.size()<1){
					returnStr = "0^û������ؿ�����";
					return returnStr;
				}
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)recaseList.iterator().next();
				String id = prpLinterRecaseRequestDto.getId();
				Collection recaseDetailList = blPrpLinterRecaseDetailFacade.findByConditions(" id='"+id+"' ");
//				if(recaseDetailList==null || recaseDetailList.size()<1){
//					returnStr = "0^����ؿ�����û�н᰸�����ܽ���֧������";
//					return returnStr;
//				}
//				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)recaseDetailList.iterator().next();
//				if(!prpLinterRecaseDetailDto.getEndcaSuccFlag().equals("1")){
//					returnStr = "0^����ؿ�����û�н᰸�����ܽ���֧������";
//					return returnStr;
//				}
				
				//��Ҫ�жϼ������Ƿ�������֧��prpjpayrefrec��
//				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
//				String compensateNo = prpLinterRecaseDetailDto.getCompensateNo();
//				String payrefreason = paymentDtos[i].getPaymentTypeCode();
//				String conditions = " certino='"+compensateNo+"' and certitype='C' and visaserialno like '9%' " +
//						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
//				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
//				//����ж�Ӧ�ļ�¼�����Խ�������֧��,������ʾ��0^�����ڶ�Ӧ������֧����Ϣ
//				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
//					returnStr = "0^�����ڶ�Ӧ������֧����Ϣ";
//					return returnStr;
//				}
			}
			if(relationOutIdType.equals("N")){
				BLPrplinterrelationFacade blprplinterrelationFacade = new BLPrplinterrelationFacade();
				BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
//				Collection prplinterrelationList = blprplinterrelationFacade.findByConditions(" outid='"+relationOutId+"' ");
//				if(prplinterrelationList==null || prplinterrelationList.size()==0){
//					returnStr = "0^û����ذ���";
//					return returnStr;
//				}
//				PrplinterrelationDto prplinterrelationDto = (PrplinterrelationDto)prplinterrelationList.iterator().next();
//				String id = prplinterrelationDto.getId();
//				String registNo = prplinterrelationDto.getRelationRegistNo();
//				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(id, registNo);
//				if(prplinterAutoClaimDetailDto==null || !"1".equals(prplinterAutoClaimDetailDto.getEndcaSuccFlag())){
//					returnStr = "0^��ذ���û�н᰸�����ܽ���֧������";
//					return returnStr;
//				}
				
				//��Ҫ�жϼ������Ƿ�������֧��prpjpayrefrec��
//				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
//				String payrefreason = paymentDtos[i].getPaymentTypeCode();
//				String conditions = " certino = (select compensateno from prplcompensate where times = '1' " +
//						"and claimno in (select claimno from prplclaim where registno = '"+registNo+"')) " +
//						"and certitype='C' and visaserialno like '9%' " +
//						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
//				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
//				//����ж�Ӧ�ļ�¼�����Խ�������֧��,������ʾ��0^�����ڶ�Ӧ������֧����Ϣ
//				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
//					returnStr = "0^�����ڶ�Ӧ������֧����Ϣ";
//					return returnStr;
//				}
				
			}
			
			key = paymentDtos[i].getRelationOutId()+paymentDtos[i].getPaymentType();
			if(map.containsKey(key)){
				returnStr = "0^ͬһ������������������������ͬ���⸶��Ϣֻ����һ��";
				return returnStr;
			}
			map.put(key, paymentDtos[i]);
		}
		return returnStr;
	}
	
	
	/**
	 * У���ڲ�ͬ״̬���ⲿrelationOutId�Ƿ���Ч��������Ӧ������Ϣ
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkRelationOutIdByAuto(PrpLinterPayRequestDto prpLinterPayRequestDto) throws Exception{
		String returnStr = "";
		String key = "";
		
		Map<String,PrpLinterPaymentInfoDto> map = new HashMap<String,PrpLinterPaymentInfoDto>();
		PrpLinterPaymentInfoDto[] paymentDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
		for(int i=0;i<paymentDtos.length;i++){
			String relationOutId = paymentDtos[i].getRelationOutId();
			String relationOutIdType = paymentDtos[i].getRelationOutIdType();
			if(relationOutIdType.equals("R")){
				BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
				BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
				Collection recaseList = blPrpLinterRecaseRequestFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(recaseList==null || recaseList.size()<1){
					returnStr = "0^û������ؿ�����";
					return returnStr;
				}
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)recaseList.iterator().next();
				String id = prpLinterRecaseRequestDto.getId();
				Collection recaseDetailList = blPrpLinterRecaseDetailFacade.findByConditions(" id='"+id+"' ");
				if(recaseDetailList==null || recaseDetailList.size()<1){
					returnStr = "0^����ؿ�����û�н᰸�����ܽ���֧������";
					return returnStr;
				}
				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = (PrpLinterRecaseDetailDto)recaseDetailList.iterator().next();
				if(!prpLinterRecaseDetailDto.getEndcaSuccFlag().equals("1")){
					returnStr = "0^����ؿ�����û�н᰸�����ܽ���֧������";
					return returnStr;
				}
				
				//��Ҫ�жϼ������Ƿ�������֧��prpjpayrefrec��
				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
				String compensateNo = prpLinterRecaseDetailDto.getCompensateNo();
				String payrefreason = paymentDtos[i].getPaymentTypeCode();
				String conditions = " certino='"+compensateNo+"' and certitype='C' and visaserialno like '9%' " +
						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
				//����ж�Ӧ�ļ�¼�����Խ�������֧��,������ʾ��0^�����ڶ�Ӧ������֧����Ϣ
				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
					returnStr = "0^�����ڶ�Ӧ������֧����Ϣ";
					return returnStr;
				}
			}
			if(relationOutIdType.equals("N")){
				BLPrplinterrelationFacade blprplinterrelationFacade = new BLPrplinterrelationFacade();
				BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
				Collection prplinterrelationList = blprplinterrelationFacade.findByConditions(" outid='"+relationOutId+"' ");
				if(prplinterrelationList==null || prplinterrelationList.size()==0){
					returnStr = "0^û����ذ���";
					return returnStr;
				}
				PrplinterrelationDto prplinterrelationDto = (PrplinterrelationDto)prplinterrelationList.iterator().next();
				String id = prplinterrelationDto.getId();
				String registNo = prplinterrelationDto.getRelationRegistNo();
				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(id, registNo);
				if(prplinterAutoClaimDetailDto==null || !"1".equals(prplinterAutoClaimDetailDto.getEndcaSuccFlag())){
					returnStr = "0^��ذ���û�н᰸�����ܽ���֧������";
					return returnStr;
				}
				
				//��Ҫ�жϼ������Ƿ�������֧��prpjpayrefrec��
				BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
				String payrefreason = paymentDtos[i].getPaymentTypeCode();
				String conditions = " certino = (select compensateno from prplcompensate where times = '1' " +
						"and claimno in (select claimno from prplclaim where registno = '"+registNo+"')) " +
						"and certitype='C' and visaserialno like '9%' " +
						"and payrefreason='"+payrefreason+"' and payrefstate in ('00', '01') and payrefdate is null ";
				Collection prpJpayRefRecList = blPrpJpayRefRecFacade.findByConditions(conditions);
				//����ж�Ӧ�ļ�¼�����Խ�������֧��,������ʾ��0^�����ڶ�Ӧ������֧����Ϣ
				if(prpJpayRefRecList==null || prpJpayRefRecList.size()<1){
					returnStr = "0^�����ڶ�Ӧ������֧����Ϣ";
					return returnStr;
				}
				
			}
			
			key = paymentDtos[i].getRelationOutId()+paymentDtos[i].getPaymentType();
			if(map.containsKey(key)){
				returnStr = "0^ͬһ������������������������ͬ���⸶��Ϣֻ����һ��";
				return returnStr;
			}
			map.put(key, paymentDtos[i]);
		}
		return returnStr;
	}
	
	/**
	 * ����������͡��͡�������͡��Ĺ���У��
	 * @param payRequestInfo
	 * @return String
	 * @throwsException
	 */
	public String checkReceiverAndPaymentType(PayRequestInfo payRequestInfo) throws Exception{
		String returnStr = "";
		String receiverType = payRequestInfo.getReceiverTypeOther();
		String receiverTypeName = payRequestInfo.getReceiverTypeOtherName();
		PaymentInfoDto[] paymentInfoDtos = payRequestInfo.getPaymentInfoDto();
		if(paymentInfoDtos!=null && paymentInfoDtos.length>0){
			PaymentInfoDto paymentInfoDto = null;
			for(int i=0;i<paymentInfoDtos.length;i++){
				if(paymentInfoDtos[i] != null){
					paymentInfoDto = paymentInfoDtos[i];
					String paymentType = paymentInfoDto.getPaymentTypeCode();
					String paymentTypeName = paymentInfoDto.getPaymentType();
					
					if("P60".equals(paymentType)||"P50".equals(paymentType)){//���
						if("t04".equals(receiverType)||"t11".equals(receiverType)||"t06".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)
								||"t09".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P61".equals(paymentType)||"Y61".equals(paymentType)){//�����/Ԥ�������
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t07".equals(receiverType)||"t04".equals(receiverType)||"t18".equals(receiverType)
								||"t11".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t09".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P62".equals(paymentType)||"Y62".equals(paymentType)){//�����鿱��/Ԥ�������鿱��
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t05".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t12".equals(receiverType)||"t13".equals(receiverType)||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)
								||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P611".equals(paymentType)||"Y611".equals(paymentType)){//�ٲ÷�/Ԥ���ٲ÷�
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t05".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P612".equals(paymentType)||"Y612".equals(paymentType)){//ִ�з�/Ԥ��ִ�з�
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P64".equals(paymentType)||"Y64".equals(paymentType)){//���Ϸ�/Ԥ�����Ϸ�
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)||"t07".equals(receiverType)
								||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)||"t15".equals(receiverType)
								||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}
					else if ("P65".equals(paymentType)||"Y65".equals(paymentType)){//�ڲ����鿱��/Ԥ���ڲ����鿱��
						if("t04".equals(receiverType)||"t11".equals(receiverType)||"t06".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)||"t09".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}
					else if ("P67".equals(paymentType)||"Y67".equals(paymentType)){//�ⲿ���鿱��/Ԥ���ⲿ���鿱��
						if("t01".equals(receiverType)||"t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t05".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t10".equals(receiverType)||"t11".equals(receiverType)
								||"t12".equals(receiverType)||"t13".equals(receiverType)||"t14".equals(receiverType)||"t15".equals(receiverType)||"t16".equals(receiverType)
								||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}else if ("P68".equals(paymentType)||"Y68".equals(paymentType)){//��ʦ��/Ԥ����ʦ��
						if("t02".equals(receiverType)||"t03".equals(receiverType)||"t04".equals(receiverType)||"t06".equals(receiverType)
								||"t07".equals(receiverType)||"t08".equals(receiverType)||"t09".equals(receiverType)||"t10".equals(receiverType)
								||"t15".equals(receiverType)||"t16".equals(receiverType)||"t17".equals(receiverType)||"t18".equals(receiverType)){
							returnStr = "0^�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+paymentTypeName+"��";
							return returnStr;
						}
					}
				}
			}
		}
		
		return returnStr;
	}

	public String checkBeforePayDelete(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullPayDelete(payDeleteRequestInfo);
		if(returnStr.equals("")){
			returnStr = this.checkPayDeleteOutId(payDeleteRequestInfo);
		}
		return returnStr;
	}
	
	public String checkNotNullPayDelete(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		if(null == payDeleteRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(payDeleteRequestInfo.getOutId()==null || "".equals(payDeleteRequestInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorCode() == null || "".equals(payDeleteRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorName() == null || "".equals(payDeleteRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getMakeCom() == null || "".equals(payDeleteRequestInfo.getMakeCom())){
			returnStr = "0^�����˻�������Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getMakeComName() == null || "".equals(payDeleteRequestInfo.getMakeComName())){
			returnStr = "0^�����˻������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getOperatorDate()==null || "".equals(payDeleteRequestInfo.getOperatorDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(payDeleteRequestInfo.getHandleText()==null || "".equals(payDeleteRequestInfo.getHandleText())){
			returnStr = "0^֧��ɾ���������Ϊ��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	public String checkPayDeleteOutId(PrpLinterPayDeleteRequestDto payDeleteRequestInfo) throws Exception{
		String returnStr = "";
		String outId = payDeleteRequestInfo.getOutId();
		BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
		ArrayList list = (ArrayList)blPrpLinterPayRequestFacade.findByConditions(" outId='"+outId+"' order by inputDate desc ");
		if(list==null || list.size()==0){
			returnStr = "2^�������Ѿ�֧��ɾ����δͬ��֧��ϵͳ";
			return returnStr;
		}
		String paymentList = "";
		for(int num=0;num<list.size();num++){
			PrpLinterPayRequestDto iPrpLinterPayRequestDto = (PrpLinterPayRequestDto)list.get(num);
    		if(null!=paymentList && !"".equals(paymentList)){
    			paymentList += ",'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
    		}else{
    			paymentList += "'"+iPrpLinterPayRequestDto.getPaymentNo()+"'";
    		}
		}
		if(null!=paymentList && !"".equals(paymentList)){
			String queryCondi = " flag='1' and approveflag<>'3' and visaserialno in (select paymentno from prplpaymain where paymentno in ("+paymentList+"))";
			BLPrpJpackDetail blPrpJpackDetail = new BLPrpJpackDetail();
			blPrpJpackDetail.query(queryCondi);
			if(null!=blPrpJpackDetail&&blPrpJpackDetail.getSize()>0){
				returnStr = "2^�����ݴ��ڴ�֧���ļ�¼������Ҫɾ��";
			}
		}
		
		return returnStr;
	}
}
