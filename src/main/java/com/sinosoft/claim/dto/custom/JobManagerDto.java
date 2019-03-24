package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;

public class JobManagerDto implements Serializable{
	/** 班表主表信息*/
	private ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList;
	/** 班表时间表信息*/
	private ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList;
	/** 判断按机构修改或个人修改 */
	String updateType = "";
	/**联系人列表*/
	private List<PrpLJobLinkerDto> prpLJobLinkerDtoList;
	
	private PrpljobmanagerDto prpljobmanagerDto;
	
	public PrpljobmanagerDto getPrpljobmanagerDto() {
		return prpljobmanagerDto;
	}
	public void setPrpljobmanagerDto(PrpljobmanagerDto prpljobmanagerDto) {
		this.prpljobmanagerDto = prpljobmanagerDto;
	}
	public String getUpdateType() {
		return updateType;
	}
	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
	public ArrayList<PrpljobmanagerDto> getPrpljobmanagerDtoList() {
		return prpljobmanagerDtoList;
	}
	public ArrayList<PrpljobmanagertimeDto> getPrpljobmanagertimeDtoList() {
		return prpljobmanagertimeDtoList;
	}
	public void setPrpljobmanagerDtoList(
			ArrayList<PrpljobmanagerDto> prpljobmanagerDtoList) {
		this.prpljobmanagerDtoList = prpljobmanagerDtoList;
	}
	public void setPrpljobmanagertimeDtoList(
			ArrayList<PrpljobmanagertimeDto> prpljobmanagertimeDtoList) {
		this.prpljobmanagertimeDtoList = prpljobmanagertimeDtoList;
	}
	public List<PrpLJobLinkerDto> getPrpLJobLinkerDtoList() {
		return prpLJobLinkerDtoList;
	}
	public void setPrpLJobLinkerDtoList(List<PrpLJobLinkerDto> prpLJobLinkerDtoList) {
		this.prpLJobLinkerDtoList = prpLJobLinkerDtoList;
	}
	

}
