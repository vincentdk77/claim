package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;

/**
 * �Զ�������ڵ�״̬���ݴ������
 * <p>Title: ������������ڵ�״̬DTO</p>
 * <p>Description: ������������ڵ�״̬��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class ClaimStatusDto implements Serializable
{
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  public ClaimStatusDto()
  {
  }

  /**���ò���״̬��Ϣ
   * @param prpLclaimStatusDto ����״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
  {
     this.prpLclaimStatusDto = prpLclaimStatusDto;
  }
  /**�õ�����״̬��Ϣ
   * @return  ����״̬��Ϣ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

}
