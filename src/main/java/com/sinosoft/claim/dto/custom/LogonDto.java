package com.sinosoft.claim.dto.custom;

import com.sinosoft.claim.dto.domain.PrpDuserDto;

/**
 * �Զ����¼���ݴ������
 * <p>Title: claim</p>
 * <p>Description: ����ϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author �����Ʒ
 * @version 1.0
 */

public class LogonDto
{
  /** �û���Ϣ*/
  private PrpDuserDto prpDuserDto;

  public void setPrpDuserDto(PrpDuserDto prpDuserDto)
  {
    this.prpDuserDto = prpDuserDto;
  }

  public PrpDuserDto getPrpDuserDto()
  {
    return prpDuserDto;
  }
  public LogonDto(){}
}
