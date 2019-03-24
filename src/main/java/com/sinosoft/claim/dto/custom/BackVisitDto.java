package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;

/**
 * �Զ���ط����ݴ������
 * <p>Title: ��������ط�DTO</p>
 * <p>Description: ��������طó���</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */


public class BackVisitDto implements Serializable
{
  /** �ط�����Ϣ*/
  private PrpLbackVisitDto prpLbackVisitDto;

  /** �ı���Ϣ*/
  private ArrayList prpLbackVisitTextDtoList;

  /** �ط���ѯ��Ϣ*/
  private ArrayList  prpLbackVisitQueDtoList;

  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  public BackVisitDto()
  {
  }

  /**�õ��ط�������Ϣ
   * @return �ط�������Ϣ
   */
  public PrpLbackVisitDto getPrpLbackVisitDto()
  {
    return prpLbackVisitDto;
  }

  /**���ûط�������Ϣ
   * @param prpLclaimDto �ط�������Ϣ
   */
  public void setPrpLbackVisitDto(PrpLbackVisitDto prpLbackVisitDto)
  {
     this.prpLbackVisitDto = prpLbackVisitDto;
  }

  /**�õ��ط��ı���Ϣ
   * @return  �ط��ı���Ϣ
   */
  public ArrayList getPrpLbackVisitTextDtoList()
  {
    return prpLbackVisitTextDtoList;
  }
  /**���ûط��ı���Ϣ
   * @param prpLclaimTextDtoList �ط��ı���Ϣ
   */
  public void setPrpLbackVisitTextDtoList(ArrayList prpLbackVisitTextDtoList)
  {
    this.prpLbackVisitTextDtoList = prpLbackVisitTextDtoList;
  }

  /**�õ��ط���ѯ��Ϣ
   * @return  �ط���ѯ��Ϣ
   */
  public ArrayList getPrpLbackVisitQueDtoList()
  {
    return prpLbackVisitQueDtoList;
  }

  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**���ûط���ѯ��Ϣ
   * @param PrpLthirdPartyDtoList �ط���ѯ����Ϣ
   */
  public void setPrpLbackVisitQueDtoList(ArrayList prpLbackVisitQueDtoList)
  {
    this.prpLbackVisitQueDtoList = prpLbackVisitQueDtoList;
  }

  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

}
