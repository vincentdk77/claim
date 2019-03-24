package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;

/***
 * 接口补传辅助类,补传重开赔案接口
 */
public class UIMedicalReloadRecaseViewHelper {
	
	private PrpLinterRecaseRequestDto prpLinterRecaseRequestDto;
	
	private PrpLinterRecaseDetailDto prpLinterRecaseDetailDto ;
	
	/**
	* 默认构造方法
	*/
	public UIMedicalReloadRecaseViewHelper(){
	}
	
	/**
	 * 判断中间表数据是否存在，如果存在将中间表数据赋值prpLinterRecaseRequestDto
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
	 * 判断是否存在轨迹表
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
	 * 判断节点是否已经流转成功
	 * @param reuploadNode
	 * @return
	 */
	public String checkExcuteNode(String reuploadNode) {
		String returnMessage = "";
		//数据转换，获取前期的关联数据
		try {
			prpLinterRecaseRequestDto = new UIMedicalClaimRecaseViewHelper().getRecaseDtoMain(prpLinterRecaseRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
			returnMessage = "数据转换出错：" + e.toString();
		}
		//若轨迹表中存在该数据，判断当前节点在轨迹表中是否已经流转成功，若成功不需要补传
		if(this.getPrpLinterRecaseDetailDto() != null && null != reuploadNode){
			/*<option value ='regis'>重开赔案申请</option>
        	<option value ='sched'>重开赔案审批</option>
        	<option value ='compp'>重开赔案理算</option>
        	<option value ='veric'>重开赔案核赔</option>
        	<option value ='endca'>重开赔案结案</option>*/
			if("recaseApply".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getRecaseSuccFlag())){
					returnMessage = "该案件重开赔案申请环节已经流转成功，不需要补传";
				}else{
					//补传重开赔案申请接口
					try {
						new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
						returnMessage = "重开赔案申请接口补传成功";
					} catch (Exception e) {
						e.printStackTrace();
						returnMessage = "重开赔案申请接口补传失败：" + e.toString();
					}
				}
			}else if("recaseAudit".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getAppovlSuccFlag())){
					returnMessage = "该案件重开赔案审批环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getRecaseSuccFlag())){
						returnMessage = "该案件重开赔案申请环节未完成流转，请先补传重开赔案申请接口";
					}else{ 
						//补传重开赔案审批接口
						try {
							new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
							returnMessage = "重开赔案审批接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "重开赔案审批接口补传失败：" + e.toString();
						}
					}
				}
			}else if("recaseCompp".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
					returnMessage = "该案件重开赔案理算环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getAppovlSuccFlag())){
						returnMessage = "该案件重开赔案审批环节未完成流转，请先补传重开赔案审批接口";
					}else{
						//补传重开赔案理算接口
						try {
							new UIMedicalAutoCompeSubViewHelper().autoCompeRecase(prpLinterRecaseRequestDto);
							returnMessage = "重开赔案理算接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "重开赔案理算接口补传失败：" + e.toString();
						}
					}
				}
			}else if("recaseVeric".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getVericSuccFlag())){
					returnMessage = "该案件重开赔案核赔环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
						returnMessage = "该案件重开赔案理算环节未完成流转，请先补传重开赔案理算接口";
					}else{
						//补传重开赔案核赔接口
						try {
							new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
							returnMessage = "重开赔案核赔接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "重开赔案核赔接口补传失败：" + e.toString();
						}
					}
				}
			}else if("recaseEndca".equals(reuploadNode)){
				if("1".equals(this.getPrpLinterRecaseDetailDto().getEndcaSuccFlag())){
					returnMessage = "该案件重开赔案结案环节已经流转成功，不需要补传";
				}else{
					if(!"1".equals(this.getPrpLinterRecaseDetailDto().getComppSuccFlag())){
						returnMessage = "该案件重开赔案核赔环节未完成流转，请先补传重开赔案核赔接口";
					}else{
						//补传重开赔案结案接口
						try {
							new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
							returnMessage = "重开赔案结案接口补传成功";
						} catch (Exception e) {
							e.printStackTrace();
							returnMessage = "重开赔案结案接口补传失败：" + e.toString();
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
