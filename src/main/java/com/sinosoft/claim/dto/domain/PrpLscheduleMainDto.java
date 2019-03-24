package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * 这是PrpLscheduleMain-调度任务主表的数据传输对象类<br>
 * 创建于 2005-03-18 16:42:18.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainDto extends PrpLscheduleMainDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleMainDto对象
     */
    public PrpLscheduleMainDto(){
    }
    
      /** 一页数据*/
   TurnPageDto turnPageDto = null ;


  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }
 public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }
}
