package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;

/***
 * 接口补传辅助类,补传立案注销接口
 */
public class UIMedicalReloadCancelViewHelper {
	
	private PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto;
	
	private PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto ;
	
	/**
	* 默认构造方法
	*/
	public UIMedicalReloadCancelViewHelper(){
	}
	
	/**
	 * 判断中间表数据是否存在，如果存在将中间表数据赋值prpLinterCancelClaimRequestDto
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
	 * 判断是否存在轨迹表
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
	 * 判断节点是否已经流转成功
	 * @param reuploadNode
	 * @return
	 */
	public String checkExcuteNode(String reuploadNode) {
		String returnMessage = "";
		//更新报案注销标识
		prpLinterCancelClaimRequestDto.setCancelFlag(true);
		//若轨迹表中存在该数据，判断当前节点在轨迹表中是否已经流转成功，若成功不需要补传
		if(this.getPrpLinterCancelClaimDetailDto() != null && null != reuploadNode){
			/*<option value ='cancelApply'>报案</option>
        	<option value ='cancelAudit'>报案注销</option>*/
			if("registCancel".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getCancelSuccFlag())){
					returnMessage = "该案件报案注销环节已经流转成功，不需要补传";
				}else{
					//补传报案接口
					try {
						new UIMedicalAutoRegistCancleSubViewHelpe().autoRegistCancel(prpLinterCancelClaimRequestDto);
						returnMessage = "报案注销接口补传成功";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "报案注销补传失败：" + e.toString();
					}
				}
			}else if("claimCancel".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getClaimCancelFlag())){
					returnMessage = "该案件立案注销申请环节已经流转成功，不需要补传";
				}else{
					//补传立案注销接口
					try {
						new UIMedicalAutoRegistCancleSubViewHelpe().autoClaimCancel(prpLinterCancelClaimRequestDto);
						returnMessage = "注销接口补传成功";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "注销接口补传失败：" + e.toString();
					}
				}
			}else if("claimApprov".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterCancelClaimDetailDto().getCancelApprovFlag())){
					returnMessage = "该案件注销审批环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterCancelClaimDetailDto().getClaimCancelFlag())){
						returnMessage = "该案件立案注销申请环节未完成流转，请先补传立案注销申请接口";
					}else{ 
						//补传立案注销接口
						try {
							new UIMedicalAutoRegistCancleSubViewHelpe().autoCancelApprov(prpLinterCancelClaimRequestDto);
							returnMessage = "注销接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "注销接口补传失败：" + e.toString();
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
