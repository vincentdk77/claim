package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;

/**
 * �°�����ʾ���ݴ������
 * <p>Title: �°�����ʾDTO</p>
 * <p>Description: ������������ڵ�</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleNewDto implements Serializable
{
  /** ����״̬��Ϣ*/
  private PrpLscheduleNewDto prpLscheduleNewDto;

  public ScheduleNewDto()
  {
  }

  /**���ò���״̬��Ϣ
   * @param prpLscheduleNewDto ����״̬��Ϣ
   */
  public void setPrpLscheduleNewDto(PrpLscheduleNewDto prpLscheduleNewDto)
  {
     this.prpLscheduleNewDto = prpLscheduleNewDto;
  }
  /**�õ�����״̬��Ϣ
   * @return  ����״̬��Ϣ
   */
  public PrpLscheduleNewDto getPrpLscheduleNewDto() {
    return prpLscheduleNewDto;
  }

}
