package com.gyic.claim.dto.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * 
 * @author GYIC
 * 用于并案处理中 并案关联表dto：PrplcombineDto
 *             与之关联的swflog表dto列表： swfLogDtoList
 */
//此DTO与仿照swfLogDto，主要用于查询页面的显示问题。

public class ClaimCombineDto {
	PrplcombineDto prplcombineDto = new PrplcombineDto();
	Collection swfLogDtoList = new ArrayList();
	SwfLogDto swfLogDto = new SwfLogDto();
	Collection claimCombineDtoList = new ArrayList();
	String nodeType = "";//节点状态
	/** 一页数据*/
	private TurnPageDto turnPageDto = null ;  
	/**需要弹出消息的内容*/
	  String alertMessage="";
	
	public void setPrplcombineDto(PrplcombineDto prplcombineDto){
		this.prplcombineDto = prplcombineDto;
	}
	
	public PrplcombineDto getPrplcombineDto(){
		return this.prplcombineDto;
	}
	
	public void setSwfLogDtoList(Collection swfLogDtoList){
		this.swfLogDtoList = swfLogDtoList;
	}
	
	public Collection getSwfLogDtoList(){
		return this.swfLogDtoList;
	}
	public void setSwfLogDto(SwfLogDto swfLogDto){
		this.swfLogDto = swfLogDto;
	}
	
	public SwfLogDto getSwfLogDto(){
		return this.swfLogDto;
	}
	public void setClaimCombineDtoList(Collection claimCombineDtoList){
		this.claimCombineDtoList = claimCombineDtoList;
	}
	
	public Collection getClaimCombineDtoList(){
		return this.claimCombineDtoList;
	}
	public void setNodeType(String nodeType){
		this.nodeType = nodeType;
	}
	
	public String getNodeType(){
		return this.nodeType;
	}
	   /**
     * 获取一页数据
     * @return 属性一页数据
     */
    public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
    }
    /**
     * 获取一页数据
     * @return 属性一页数据
     */
    public TurnPageDto getTurnPageDto() {
      return turnPageDto;
    }
    /**得到alertMessage信息
     * @return alertMessage信息
     */
     public String getAlertMessage() {
       return  alertMessage;
     }
     /**设置alertMessage信息
      * @param alertMessage信息
      */
     public void setAlertMessage(String alertMessage) {
       this.alertMessage = alertMessage;
     }
}
