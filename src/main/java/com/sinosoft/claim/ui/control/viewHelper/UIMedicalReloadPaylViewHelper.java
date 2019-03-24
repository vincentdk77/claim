package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;

/***
 * �ӿڲ���������,��������֧���ӿ�
 */
public class UIMedicalReloadPaylViewHelper {
	
	private PrpLinterPayRequestDto prpLinterPayRequestDto;
	
	private PrpLinterPayDetailDto prpLinterPayDetailDto ;
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalReloadPaylViewHelper(){
	}
	
	/**
	 * �ж��м�������Ƿ���ڣ�������ڽ��м�����ݸ�ֵprpLinterPayRequestDto
	 * @param registNo
	 * @param interId
	 * @param outId
	 * @return
	 * @throws Exception
	 */
	public boolean checkExists(String registNo, String interId, String outId) throws Exception{
		
		boolean existsFlag = false;
		
		BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
		
		String conditions = " 1=1 ";
		
		if(null != interId && !"".equals(interId)){
			conditions += " AND ID = '" + interId + "' " +
					"and not exists (select 1 from prplinterpaydetail t where t.id = prplinterpayrequest.id and t.vericsuccflag = '1') " +
					"and not exists (select 1 from prplinterpaydetailhis h where h.id = prplinterpayrequest.id and h.vericsuccflag = '1') ";
		}
		
		if(null != outId && !"".equals(outId)){
			conditions += " AND outId = '" + outId + "' " +
				"and not exists (select 1 from prplinterpaydetail d where d.id = prplinterpayrequest.id and d.vericsuccflag = '1') "+
				"and not exists (select 1 from prplinterpaydetailhis ho where ho.id = prplinterpayrequest.id and ho.vericsuccflag = '1') ";
		}
		
		try {
			Collection<PrpLinterPayRequestDto> prpLinterPayRequestList = blPrpLinterPayRequestFacade.findByConditionsWithChild(conditions);
			if(prpLinterPayRequestList.size() >0){
				for (Iterator iter = prpLinterPayRequestList.iterator(); iter.hasNext();) {
					this.setPrpLinterPayRequestDto((PrpLinterPayRequestDto) iter.next());
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
		
		PrpLinterPayDetailDto prpLinterPayDetail = this.getPrpLinterPayRequestDto().getPrpLinterPayDetailDto();
		if(null != prpLinterPayDetail){
			this.setPrpLinterPayDetailDto(prpLinterPayDetail);
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
		//���켣���д��ڸ����ݣ��жϵ�ǰ�ڵ��ڹ켣�����Ƿ��Ѿ���ת�ɹ������ɹ�����Ҫ����
		String returnMessage = "";
		if(this.getPrpLinterPayDetailDto() != null && null != reuploadNode){
			/*<option value ='payApply'>����֧������</option>
        	<option value ='payAudit'>����֧������</option>*/
			if("payApply".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterPayDetailDto().getPaySuccFlag())){
					returnMessage = "�ð�������֧�����뻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					//��������֧������ӿ�
					try {
						new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
						returnMessage = "����֧������ӿڲ����ɹ�";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "����֧������ӿڲ���ʧ�ܣ�" + e.toString();
					}
				}
			}else if("payAudit".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterPayDetailDto().getVericSuccFlag())){
					returnMessage = "�ð�������֧�����������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterPayDetailDto().getPaySuccFlag())){
						returnMessage = "�ð�������֧�����뻷��δ�����ת�����Ȳ�������֧������ӿ�";
					}else{ 
						//��������֧�������ӿ�
						try {
							new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
							returnMessage = "����֧�������ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "����֧�������ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}
		}
		return returnMessage;
	}

	public PrpLinterPayRequestDto getPrpLinterPayRequestDto() {
		return prpLinterPayRequestDto;
	}

	public void setPrpLinterPayRequestDto(
			PrpLinterPayRequestDto prpLinterPayRequestDto) {
		this.prpLinterPayRequestDto = prpLinterPayRequestDto;
	}

	public PrpLinterPayDetailDto getPrpLinterPayDetailDto() {
		return prpLinterPayDetailDto;
	}

	public void setPrpLinterPayDetailDto(PrpLinterPayDetailDto prpLinterPayDetailDto) {
		this.prpLinterPayDetailDto = prpLinterPayDetailDto;
	}

}
