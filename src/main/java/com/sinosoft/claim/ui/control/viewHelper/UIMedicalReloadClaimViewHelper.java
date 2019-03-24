package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;

/***
 * 接口补传辅助类
 */
public class UIMedicalReloadClaimViewHelper {
	
	private PrpLinterRequestDto prpLinterRequestDto;
	
	private PrplinterAutoClaimDetailDto prplinterautoclaimdetail ;
	
	/**
	* 默认构造方法
	*/
	public UIMedicalReloadClaimViewHelper(){
	}
	
	/**
	 * 判断中间表数据是否存在，如果存在将中间表数据赋值prpLinterRequestDto
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
	 * 判断是否存在轨迹表
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
	 * 判断节点是否已经流转成功
	 * @param reuploadNode
	 * @return
	 */
	public String checkExcuteNode(String reuploadNode) {
		//若轨迹表中存在该数据，判断当前节点在轨迹表中是否已经流转成功，若成功不需要补传
		String returnMessage = "";
		if(this.getPrplinterautoclaimdetail() != null && null != reuploadNode){
			/*<option value ='regis'>报案</option>
        	<option value ='sched'>调度</option>
        	<option value ='check'>查勘</option>
        	<option value ='claim'>立案</option>
        	<option value ='certi'>单证</option>
        	<option value ='compp'>理算</option>
        	<option value ='veric'>核赔</option>
        	<option value ='endca'>结案</option>*/
			if("regis".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getRegistSuccFlag())){
					returnMessage = "该案件报案环节已经流转成功，不需要补传";
				}else{
					//补传报案接口
					try {
						new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
						returnMessage = "报案接口补传成功";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "报案接口补传失败：" + e.toString();
					}
				}
			}else if("sched".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getSchedSuccFlag())){
					returnMessage = "该案件调度环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getRegistSuccFlag())){
						returnMessage = "该案件报案环节未完成流转，请先补传报案接口";
					}else{ 
						//补传调度接口
						try {
							new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
							returnMessage = "调度接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "调度接口补传失败：" + e.toString();
						}
					}
				}
			}else if("check".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getCheckSuccFlag())){
					returnMessage = "该案件查勘环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getSchedSuccFlag())){
						returnMessage = "该案件调度环节未完成流转，请先补传调度接口";
					}else{
						//补传查勘接口
						try {
							new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
							returnMessage = "查勘接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "查勘接口补传失败：" + e.toString();
						}
					}
				}
			}else if("claim".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getClaimSuccFlag())){
					returnMessage = "该案件立案环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getCheckSuccFlag())){
						returnMessage = "该案件查勘环节未完成流转，请先补传查勘接口";
					}else{
						//补传立案接口
						try {
							new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
							returnMessage = "立案接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "立案接口补传失败：" + e.toString();
						}
					}
				}
			}else if("certi".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getCertiSuccFlag())){
					returnMessage = "该案件单证环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getClaimSuccFlag())){
						returnMessage = "该案件立案环节未完成流转，请先补传立案接口";
					}else{
						returnMessage = "单证补传开发中......";
						//补传立案接口
						try {
							new UIMedicalAutoCertiSubViewHelper().autoCerti(prpLinterRequestDto);
							returnMessage = "单证接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "单证接口补传失败：" + e.toString();
						}
					}
				}
			}else if("compp".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
					returnMessage = "该案件理算环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getCertiSuccFlag())){
						returnMessage = "该案件单证环节未完成流转，请先补传单证接口";
					}else{
						//补传理算接口
						try {
							new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRequestDto);
							returnMessage = "理算接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "理算接口补传失败：" + e.toString();
						}
					}
				}
			}else if("veric".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getVericSuccFlag())){
					returnMessage = "该案件核赔环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
						returnMessage = "该案件理算环节未完成流转，请先补传理算接口";
					}else{
						//补传核赔接口
						try {
							new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRequestDto);
							returnMessage = "核赔接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "核赔接口补传失败：" + e.toString();
						}
					}
				}
			}else if("endca".equals(reuploadNode)){
				if("1".equals(this.getPrplinterautoclaimdetail().getEndcaSuccFlag())){
					returnMessage = "该案件结案环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrplinterautoclaimdetail().getComppSuccFlag())){
						returnMessage = "该案件核赔环节未完成流转，请先补传核赔接口";
					}else{
						//补传结案接口
						try {
							new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRequestDto);
							//需要把交互成功的标志值为1：prplinterrelation.SYNCHRONFLAG
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
							returnMessage = "结案接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "结案接口补传失败：" + e.toString();
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
