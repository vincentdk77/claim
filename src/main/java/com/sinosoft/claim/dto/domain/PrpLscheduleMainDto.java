package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * ����PrpLscheduleMain-����������������ݴ��������<br>
 * ������ 2005-03-18 16:42:18.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLscheduleMainDto extends PrpLscheduleMainDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleMainDto����
     */
    public PrpLscheduleMainDto(){
    }
    
      /** һҳ����*/
   TurnPageDto turnPageDto = null ;


  public void setTurnPageDto(TurnPageDto turnPageDto) {
    this.turnPageDto = turnPageDto;
  }
 public TurnPageDto getTurnPageDto() {
    return turnPageDto;
  }
}
