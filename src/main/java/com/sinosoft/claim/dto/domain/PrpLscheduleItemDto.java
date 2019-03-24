package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 这是prpLscheduleItem调度任务标的表的数据传输对象类<br>
 * 创建于 2004-07-15 21:02:17.921<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleItemDto extends PrpLscheduleItemDtoBase implements Serializable{
  /** 属性显示列表*/
   private Collection scheduleItemList ;
  /** 属性操作员名称 */
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
     *  默认构造方法,构造一个默认的PrpLscheduleItemDto对象
     */
    public PrpLscheduleItemDto(){
    }

    /**设置属性显示列表
    * @param prpLctextList 属性显示列表
    */
   public void setScheduleItemList(Collection scheduleItemList) {
     this.scheduleItemList = scheduleItemList;
   }

 /**得到属性显示列表
 * @return 属性显示列表
 */
   public Collection getScheduleItemList() {
     return scheduleItemList;
   }
  
      /**
     * 设置属性操作员名称
     * @param operatorName 待设置的属性操作员名称的值
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * 获取属性操作员名称
     * @return 属性操作员名称的值
     */
    public String getOperatorName(){
        return operatorName;
    }
  
}
