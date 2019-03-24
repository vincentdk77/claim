package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * ����prpLscheduleItem���������ı�����ݴ��������<br>
 * ������ 2004-07-15 21:02:17.921<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleItemDto extends PrpLscheduleItemDtoBase implements Serializable{
  /** ������ʾ�б�*/
   private Collection scheduleItemList ;
  /** ���Բ���Ա���� */
  private String operatorName = "";
  
  //add by zhaolu 20060802 start
   TurnPageDto turnPageDto = null;
  //add by zhaolu 20060802 end
 
   
  public TurnPageDto getTurnPageDto() {
	return turnPageDto;
}

public void setTurnPageDto(TurnPageDto turnPageDto) {
	this.turnPageDto = turnPageDto;
}

/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleItemDto����
     */
    public PrpLscheduleItemDto(){
    }

    /**����������ʾ�б�
    * @param prpLctextList ������ʾ�б�
    */
   public void setScheduleItemList(Collection scheduleItemList) {
     this.scheduleItemList = scheduleItemList;
   }

 /**�õ�������ʾ�б�
 * @return ������ʾ�б�
 */
   public Collection getScheduleItemList() {
     return scheduleItemList;
   }
  
      /**
     * �������Բ���Ա����
     * @param operatorName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }
  
}
