package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

/***
 * �ӿڲ���������
 */
public class UIMedicalReloadClaimViewHelper {
	
	private PrpLinterRequestDto prpLinterRequestDto;
	
	private PrplinterAutoClaimDetailDto prplinterautoclaimdetail ;
	
	/**
	* Ĭ�Ϲ��췽��
	*/
	public UIMedicalReloadClaimViewHelper(){
	}
	
	/**
	 * �ж��м�������Ƿ���ڣ�������ڽ��м�����ݸ�ֵprpLinterRequestDto
	 * @param registNo
	 * @param interId
	 * @param outId
	 * @return
	 * @throws Exception
	 */
	public boolean checkExists(String registNo, String interId, String outId) throws Exception{
		
		boolean existsFlag = false;
		
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		
		String conditions = " mutualflag='1' and not exists (select 1 "+
			" from prplinterrelation rel "+
			" where rel.id = prplinterrequest.id "+
			" and rel.outid = prplinterrequest.outid "+
			" and rel.synchronflag = '1') ";
		
		if(null != registNo && !"".equals(registNo)){
			conditions += " AND ID IN (SELECT id FROM prplinterrelation WHERE relationRegistNo = '" + registNo + "') ";
		}
		
		if(null != interId && !"".equals(interId)){
			conditions += " AND ID = '" + interId + "' " ;
		}
		
		if(null != outId && !"".equals(outId)){
			conditions += " AND outId = '" + outId + "' " ;
		}
		
		try {
			Collection<PrpLinterRequestDto> prpLinterRequestList = blPrpLinterRequestFacade.findByConditionsWithChild(conditions);
			if(prpLinterRequestList.size() >0){
				for (Iterator iter = prpLinterRequestList.iterator(); iter.hasNext();) {
					this.setPrpLinterRequestDto((PrpLinterRequestDto) iter.next());
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
		
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetail = this.getPrpLinterRequestDto().getPrplinterAutoClaimDetailDto();
		if(null != prplinterAutoClaimDetail){
			this.setPrplinterautoclaimdetail(prplinterAutoClaimDetail);
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
		if(this.getPrplinterautoclaimdetail() != null && null != reuploadNode){
			/*<option value ='regis'>����</option>
        	<option value ='sched'>����</option>
        	<option value ='check'>�鿱</option>
        	<option value ='claim'>����</option>
        	<option value ='certi'>��֤</option>
        	<option value ='compp'>����</option>
        	<option value ='veric'>����</option>
        	<option value ='endca'>�᰸</option>*/
			if("regis".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getRegistSuccFlag())){
					returnMessage = "�ð������������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					//���������ӿ�
					try {
						new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
						returnMessage = "�����ӿڲ����ɹ�";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "�����ӿڲ���ʧ�ܣ�" + e.toString();
					}
				}
			}else if("sched".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getSchedSuccFlag())){
					returnMessage = "�ð������Ȼ����Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getRegistSuccFlag())){
						returnMessage = "�ð�����������δ�����ת�����Ȳ��������ӿ�";
					}else{ 
						//�������Ƚӿ�
						try {
							new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
							returnMessage = "���Ƚӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "���Ƚӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("check".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getCheckSuccFlag())){
					returnMessage = "�ð����鿱�����Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getSchedSuccFlag())){
						returnMessage = "�ð������Ȼ���δ�����ת�����Ȳ������Ƚӿ�";
					}else{
						//�����鿱�ӿ�
						try {
							new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
							returnMessage = "�鿱�ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�鿱�ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("claim".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getClaimSuccFlag())){
					returnMessage = "�ð������������Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getCheckSuccFlag())){
						returnMessage = "�ð����鿱����δ�����ת�����Ȳ����鿱�ӿ�";
					}else{
						//���������ӿ�
						try {
							new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
							returnMessage = "�����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("certi".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getCertiSuccFlag())){
					returnMessage = "�ð�����֤�����Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getClaimSuccFlag())){
						returnMessage = "�ð�����������δ�����ת�����Ȳ��������ӿ�";
					}else{
						returnMessage = "��֤����������......";
						//���������ӿ�
						try {
							new UIMedicalAutoCertiSubViewHelper().autoCerti(prpLinterRequestDto);
							returnMessage = "��֤�ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "��֤�ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("compp".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
					returnMessage = "�ð������㻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getCertiSuccFlag())){
						returnMessage = "�ð�����֤����δ�����ת�����Ȳ�����֤�ӿ�";
					}else{
						//��������ӿ�
						try {
							new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRequestDto);
							returnMessage = "����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("veric".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getVericSuccFlag())){
					returnMessage = "�ð������⻷���Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
						returnMessage = "�ð������㻷��δ�����ת�����Ȳ�������ӿ�";
					}else{
						//��������ӿ�
						try {
							new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRequestDto);
							returnMessage = "����ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "����ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}else if("endca".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getEndcaSuccFlag())){
					returnMessage = "�ð����᰸�����Ѿ���ת�ɹ�������Ҫ����";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
						returnMessage = "�ð������⻷��δ�����ת�����Ȳ�������ӿ�";
					}else{
						//�����᰸�ӿ�
						try {
							new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRequestDto);
							//��Ҫ�ѽ����ɹ��ı�־ֵΪ1��prplinterrelation.SYNCHRONFLAG
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
							returnMessage = "�᰸�ӿڲ����ɹ�";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "�᰸�ӿڲ���ʧ�ܣ�" + e.toString();
						}
					}
				}
			}
		}
		return returnMessage;
	}
	

	public PrpLinterRequestDto getPrpLinterRequestDto() {
		return prpLinterRequestDto;
	}

	public void setPrpLinterRequestDto(PrpLinterRequestDto prpLinterRequestDto) {
		this.prpLinterRequestDto = prpLinterRequestDto;
	}
	
	public PrplinterAutoClaimDetailDto getPrplinterautoclaimdetail() {
		return prplinterautoclaimdetail;
	}
	
	public void setPrplinterautoclaimdetail(
			PrplinterAutoClaimDetailDto prplinterautoclaimdetail) {
		this.prplinterautoclaimdetail = prplinterautoclaimdetail;
	}


	
}
