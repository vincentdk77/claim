package com.gyic.claim.dto.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * 
 * @author GYIC
 * ���ڲ��������� ����������dto��PrplcombineDto
 *             ��֮������swflog��dto�б� swfLogDtoList
 */
//��DTO�����swfLogDto����Ҫ���ڲ�ѯҳ�����ʾ���⡣

public class ClaimCombineDto {
	PrplcombineDto prplcombineDto = new PrplcombineDto();
	Collection swfLogDtoList = new ArrayList();
	SwfLogDto swfLogDto = new SwfLogDto();
	Collection claimCombineDtoList = new ArrayList();
	String nodeType = "";//�ڵ�״̬
	/** һҳ����*/
	private TurnPageDto turnPageDto = null ;  
	/**��Ҫ������Ϣ������*/
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
     * ��ȡһҳ����
     * @return ����һҳ����
     */
    public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
    }
    /**
     * ��ȡһҳ����
     * @return ����һҳ����
     */
    public TurnPageDto getTurnPageDto() {
      return turnPageDto;
    }
    /**�õ�alertMessage��Ϣ
     * @return alertMessage��Ϣ
     */
     public String getAlertMessage() {
       return  alertMessage;
     }
     /**����alertMessage��Ϣ
      * @param alertMessage��Ϣ
      */
     public void setAlertMessage(String alertMessage) {
       this.alertMessage = alertMessage;
     }
}
