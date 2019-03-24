package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;

/***
 * �ӿڲ���������,�����ؿ��ⰸ�ӿ�
 */
public class UIMedicalReloadRecaseViewHelper {
	
	private PrpLinterRecaseRequestDto prpLinterRecaseRequestDto;
	
	private PrpLinterRecaseDetailDto prpLinterRecaseDetailDto ;
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalReloadRecaseViewHelper(){
	}
	
	/**
	 * �ж��м�������Ƿ���ڣ�������ڽ��м�����ݸ�ֵprpLinterRecaseRequestDto
	 * @param registNo
	 * @param interId
	 * @param outId
	 * @return
	 * @throws Exception
	 */
	public boolean checkExists(String registNo, String interId, String outId) throws Exception{
		
		boolean existsFlag = false;
		
		BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
		
		String conditions = " 1=1 ";
		
		if(null != registNo && !"".equals(registNo)){
			conditions += " AND relationoutid = (SELECT outId FROM prplinterrelation WHERE relationregistno ='" + registNo + "')";
		}
		
		if(null != interId && !"".equals(interId)){
			conditions += " AND ID = '" + interId + "' " ;
		}
		
		if(null != outId && !"".equals(outId)){
			conditions += " AND outId = '" + outId + "' " ;
		}
		
		try {
			Collection<PrpLinterRecaseRequestDto> prpLinterrecaseRequestList = blPrpLinterRecaseRequestFacade.findByConditionsWithChild(conditions);
			if(prpLinterrecaseRequestList.size() >0){
				for (Iterator iter = prpLinterrecaseRequestList.iterator(); iter.hasNext();) {
					this.setPrpLinterRecaseRequestDto((PrpLinterRecaseRequestDto) iter.next());
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
		
		PrpLinterRecaseDetailDto prpLinterRecaseDetail = this.getPrpLinterRecaseRequestDto().getPrpLinterRecaseDetailDto();
		if(null != prpLinterRecaseDetail){
			this.setPrpLinterRecaseDetailDto(prpLinterRecaseDetail);
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
		//����ת������ȡǰ�ڵĹ�������
		try {
			prpLinterRecaseRequestDto = new UIMedicalClaimRecaseViewHelper().getRecaseDtoMain(prpLinterRecaseRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage = "����ת������" + e.toString();
		}
		//���켣���д��ڸ����ݣ��жϵ�ǰ�ڵ��ڹ켣�����Ƿ��Ѿ���ת�ɹ������ɹ�����Ҫ����
		if(this.getPrpLinterRecaseDetailDto() != null && null != reuploadNode){
			/*<option value ='regis'>�ؿ��ⰸ����</option>
        	<option value ='sched'>�ؿ��ⰸ����</option>
        	<option value ='compp'>�ؿ��ⰸ����</option>
        	<option value ='veric'>�ؿ��ⰸ����</option>
        	<option value ='endca'>�ؿ��ⰸ�᰸</option>*/
			if("recaseApply".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getRecaseSuccFlag())){
					returnMessage = "�ð����ؿ��ⰸ���뻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					//�����ؿ��ⰸ����ӿ�
					try {
						new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
						returnMessage = "�ؿ��ⰸ����ӿڲ����ɹ�";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "�ؿ��ⰸ����ӿڲ���ʧ�ܣ�" + e.toString();
					}
				}
			}else if("recaseAudit".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getAppovlSuccFlag())){
					returnMessage = "�ð����ؿ��ⰸ���������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getRecaseSuccFlag())){
						returnMessage = "�ð����ؿ��ⰸ���뻷��δ�����ת�����Ȳ����ؿ��ⰸ����ӿ�";
					}else{ 
						//�����ؿ��ⰸ�����ӿ�
						try {
							new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
							returnMessage = "�ؿ��ⰸ�����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�ؿ��ⰸ�����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("recaseCompp".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
					returnMessage = "�ð����ؿ��ⰸ���㻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getAppovlSuccFlag())){
						returnMessage = "�ð����ؿ��ⰸ��������δ�����ת�����Ȳ����ؿ��ⰸ�����ӿ�";
					}else{
						//�����ؿ��ⰸ����ӿ�
						try {
							new UIMedicalAutoCompeSubViewHelper().autoCompeRecase(prpLinterRecaseRequestDto);
							returnMessage = "�ؿ��ⰸ����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�ؿ��ⰸ����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("recaseVeric".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getVericSuccFlag())){
					returnMessage = "�ð����ؿ��ⰸ���⻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
						returnMessage = "�ð����ؿ��ⰸ���㻷��δ�����ת�����Ȳ����ؿ��ⰸ����ӿ�";
					}else{
						//�����ؿ��ⰸ����ӿ�
						try {
							new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
							returnMessage = "�ؿ��ⰸ����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�ؿ��ⰸ����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("recaseEndca".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getEndcaSuccFlag())){
					returnMessage = "�ð����ؿ��ⰸ�᰸�����Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
						returnMessage = "�ð����ؿ��ⰸ���⻷��δ�����ת�����Ȳ����ؿ��ⰸ����ӿ�";
					}else{
						//�����ؿ��ⰸ�᰸�ӿ�
						try {
							new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
							returnMessage = "�ؿ��ⰸ�᰸�ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�ؿ��ⰸ�᰸�ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}
		}
		return returnMessage;
	}

	public PrpLinterRecaseRequestDto getPrpLinterRecaseRequestDto() {
		return prpLinterRecaseRequestDto;
	}

	public void setPrpLinterRecaseRequestDto(
			PrpLinterRecaseRequestDto prpLinterRecaseRequestDto) {
		this.prpLinterRecaseRequestDto = prpLinterRecaseRequestDto;
	}

	public PrpLinterRecaseDetailDto getPrpLinterRecaseDetailDto() {
		return prpLinterRecaseDetailDto;
	}

	public void setPrpLinterRecaseDetailDto(
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto) {
		this.prpLinterRecaseDetailDto = prpLinterRecaseDetailDto;
	}
	
	
}
