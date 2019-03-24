package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;

public class PrplCommunicationDto extends PrplCommunicationDtoBase implements
		Serializable {
	 private static final long serialVersionUID = 1L;

	 /** 列表*/ 
	 private Collection resultList ;
	 /** 一页数据*/
	 private TurnPageDto turnPageDto = null ;
	 
	 /** 补充字段 显示本沟通的颜色 */
	 private String color;
	 /** 流入时长 */
	 private String aboveTime;
	 /** 被保险人 */
	 private String insuredName;
	 /**号牌号码 显示用*/
	 private String licenseNo;
	 /** 历史数据兼容的 序号 */
	 private String serialNo;
	 /** 历史数据兼容的 行号 */
	 private String lineno;
    /**
     *  默认构造方法,构造一个默认的PrplCommunicationDto对象
     */
	 public PrplCommunicationDto(){}
	 /** 列表*/
	public Collection getResultList() {
		return resultList;
	}
	/** 列表*/
	public void setResultList(Collection resultList) {
		this.resultList = resultList;
	}
	 /** 一页数据*/
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	 /** 一页数据*/
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	/** 补充字段 显示本沟通的颜色 */
	public String getColor() {
		return color;
	}
	/** 补充字段 显示本沟通的颜色 */
	public void setColor(String color) {
		this.color = color;
	}
	/** 流入时长 */
	public String getAboveTime() {
		return aboveTime;
	}
	/** 流入时长 */
	public void setAboveTime(String aboveTime) {
		this.aboveTime = aboveTime;
	}
	/** 被保险人 */
	public String getInsuredName() {
		return insuredName;
	}
	/** 被保险人 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**号牌号码 显示用*/
	public String getLicenseNo() {
		return licenseNo;
	}
	/**号牌号码 显示用*/
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/** 历史数据兼容的 序号 */
	public String getSerialNo() {
		return serialNo;
	}
	/** 历史数据兼容的 序号 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/** 历史数据兼容的 行号 */
	public String getLineno() {
		return lineno;
	}
	/** 历史数据兼容的 行号 */
	public void setLineno(String lineno) {
		this.lineno = lineno;
	}
	
	 
}
