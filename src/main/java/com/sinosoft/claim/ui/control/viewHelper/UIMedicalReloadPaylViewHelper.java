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
 * 接口补传辅助类,补传三方支付接口
 */
public class UIMedicalReloadPaylViewHelper {
	
	private PrpLinterPayRequestDto prpLinterPayRequestDto;
	
	private PrpLinterPayDetailDto prpLinterPayDetailDto ;
	
	/**
	* 默认构造方法
	*/
	public UIMedicalReloadPaylViewHelper(){
	}
	
	/**
	 * 判断中间表数据是否存在，如果存在将中间表数据赋值prpLinterPayRequestDto
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
	 * 判断是否存在轨迹表
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
	 * 判断节点是否已经流转成功
	 * @param reuploadNode
	 * @return
	 */
	public String checkExcuteNode(String reuploadNode) {
		//若轨迹表中存在该数据，判断当前节点在轨迹表中是否已经流转成功，若成功不需要补传
		String returnMessage = "";
		if(this.getPrpLinterPayDetailDto() != null && null != reuploadNode){
			/*<option value ='payApply'>三方支付申请</option>
        	<option value ='payAudit'>三方支付审批</option>*/
			if("payApply".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterPayDetailDto().getPaySuccFlag())){
					returnMessage = "该案件三方支付申请环节已经流转成功，不需要补传";
				}else{
					//补传三方支付申请接口
					try {
						new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
						returnMessage = "三方支付申请接口补传成功";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "三方支付申请接口补传失败：" + e.toString();
					}
				}
			}else if("payAudit".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterPayDetailDto().getVericSuccFlag())){
					returnMessage = "该案件三方支付审批环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterPayDetailDto().getPaySuccFlag())){
						returnMessage = "该案件三方支付申请环节未完成流转，请先补传三方支付申请接口";
					}else{ 
						//补传三方支付审批接口
						try {
							new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
							returnMessage = "三方支付审批接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "三方支付审批接口补传失败：" + e.toString();
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
