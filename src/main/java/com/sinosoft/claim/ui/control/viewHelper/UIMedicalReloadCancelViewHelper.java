package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;

/***
 * �ӿڲ���������,��������ע���ӿ�
 */
public class UIMedicalReloadCancelViewHelper {
	
	private PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto;
	
	private PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto ;
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalReloadCancelViewHelper(){
	}
	
	/**
	 * �ж��м�������Ƿ���ڣ�������ڽ��м�����ݸ�ֵprpLinterCancelClaimRequestDto
	 * @param registNo
	 * @param interId
	 * @param outId
	 * @return
	 * @throws Exception
	 */
	public boolean checkExists(String registNo, String interId, String outId) throws Exception{
		
		boolean existsFlag = false;
		
		BLPrpLinterCancelClaimRequestFacade blPrpLinterCancelClaimRequestFacade = new BLPrpLinterCancelClaimRequestFacade();
		
		String conditions = " 1=1 ";
		
		if(null != interId && !"".equals(interId)){
			conditions += " AND ID = '" + interId + "' " ;
		}
		
		if(null != outId && !"".equals(outId)){
			conditions += " AND outRegistNo = '" + outId + "' " ;
		}
		
		try {
			Collection<PrpLinterCancelClaimRequestDto> prpLinterCancelClaimRequestList = blPrpLinterCancelClaimRequestFacade.findByConditionsWithChild(conditions);
			if(prpLinterCancelClaimRequestList.size() >0){
				for (Iterator iter = prpLinterCancelClaimRequestList.iterator(); iter.hasNext();) {
					this.setPrpLinterCancelClaimRequestDto((PrpLinterCancelClaimRequestDto) iter.next());
		        }
				existsFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return existsFlag;
		
	}
	
	/**
	 * �ж��Ƿ���ڹ켣��
	 * @param registNo
	 * @param interId
	 * @param outId
	 * @return
	 * @throws Exception
	 */
	public boolean checkExistsDetail() throws Exception{
		
		boolean existsDetailFlag = false;
		
		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetail = this.getPrpLinterCancelClaimRequestDto().getPrpLinterCancelClaimDetailDto();
		if(null != prpLinterCancelClaimDetail){
			this.setPrpLinterCancelClaimDetailDto(prpLinterCancelClaimDetail);
			existsDetailFlag = true;
		}
		
		return existsDetailFlag;
		
	}
	
	/**
	 * �жϽڵ��Ƿ��Ѿ���ת�ɹ�
	 * @param reuploadNode
	 * @return
	 */
	public String checkExcuteNode(String reuploadNode) {
		String returnMessage = "";
		//���±���ע����ʶ
		prpLinterCancelClaimRequestDto.setCancelFlag(true);
		//���켣���д��ڸ����ݣ��жϵ�ǰ�ڵ��ڹ켣�����Ƿ��Ѿ���ת�ɹ������ɹ�����Ҫ����
		if(this.getPrpLinterCancelClaimDetailDto() != null && null != reuploadNode){
			/*<option value ='cancelApply'>����</option>
        	<option value ='cancelAudit'>����ע��</option>*/
			if("registCancel".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getCancelSuccFlag())){
					returnMessage = "�ð�������ע�������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					//���������ӿ�
					try {
						new UIMedicalAutoRegistCancleSubViewHelpe().autoRegistCancel(prpLinterCancelClaimRequestDto);
						returnMessage = "����ע���ӿڲ����ɹ�";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "����ע������ʧ�ܣ�" + e.toString();
					}
				}
			}else if("claimCancel".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getClaimCancelFlag())){
					returnMessage = "�ð�������ע�����뻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					//��������ע���ӿ�
					try {
						new UIMedicalAutoRegistCancleSubViewHelpe().autoClaimCancel(prpLinterCancelClaimRequestDto);
						returnMessage = "ע���ӿڲ����ɹ�";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "ע���ӿڲ���ʧ�ܣ�" + e.toString();
					}
				}
			}else if("claimApprov".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getCancelApprovFlag())){
					returnMessage = "�ð���ע�����������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterCancelClaimDetailDto().getClaimCancelFlag())){
						returnMessage = "�ð�������ע�����뻷��δ�����ת�����Ȳ�������ע������ӿ�";
					}else{ 
						//��������ע���ӿ�
						try {
							new UIMedicalAutoRegistCancleSubViewHelpe().autoCancelApprov(prpLinterCancelClaimRequestDto);
							returnMessage = "ע���ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "ע���ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}
		}
		return returnMessage;
	}

	public PrpLinterCancelClaimRequestDto getPrpLinterCancelClaimRequestDto() {
		return prpLinterCancelClaimRequestDto;
	}

	public void setPrpLinterCancelClaimRequestDto(
			PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) {
		this.prpLinterCancelClaimRequestDto = prpLinterCancelClaimRequestDto;
	}

	public PrpLinterCancelClaimDetailDto getPrpLinterCancelClaimDetailDto() {
		return prpLinterCancelClaimDetailDto;
	}

	public void setPrpLinterCancelClaimDetailDto(
			PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto) {
		this.prpLinterCancelClaimDetailDto = prpLinterCancelClaimDetailDto;
	}
	
	
	

	
}
