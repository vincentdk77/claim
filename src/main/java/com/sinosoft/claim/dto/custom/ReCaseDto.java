package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
/**
 * �Զ��屣�����ݴ������
 * <p>Title: �������Ᵽ��DTO</p>
 * <p>Description: �������Ᵽ����������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class ReCaseDto implements Serializable
{
  /** ��������Ϣ*/
  private PrpCmainDto prpCmainDto;
  /** ������Ϣ*/
  private PrpLclaimDto  prpLclaimDto ;
  private PrpLrecaseDto  prpLrecaseDto ;
  /** ������Ϣ*/
  private ArrayList  prpLrecaseDtoList ;
  
  public ReCaseDto()
  {
  }

  public ArrayList getPrpLrecaseDtoList()
  {
    return prpLrecaseDtoList;
  }
  /**����itemkind��Ϣ
   * @param prpCitemKindDtoList itemkind����Ϣ
   */
  public void setPrpLrecaseDtoList(ArrayList prpLrecaseDtoList)
  {
    this.prpLrecaseDtoList = prpLrecaseDtoList;
  }

  
  
  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpCmainDto getPrpCmainDto()
  {
    return prpCmainDto;
  }

  /**���ñ���������Ϣ
   * @param prpCmainDto ����������Ϣ
   */
  public void setPrpCmainDto(PrpCmainDto prpCmainDto)
  {
     this.prpCmainDto = prpCmainDto;
  }

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLclaimDto getPrpLclaimDto()
  {
    return prpLclaimDto;
  }

  /**���ñ���������Ϣ
   * @param prpCmainDto ����������Ϣ
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto)
  {
     this.prpLclaimDto = prpLclaimDto;
  }
  /**�õ�������Ϣ
   * @return  ������Ϣ
   */
  public PrpLrecaseDto getPrpLrecaseDto()
  {
    return prpLrecaseDto;
  }
  /**���÷ѱ���Ϣ
   * @param PrpCfeeDto ���ѱ���Ϣ
   */
  public void setPrpLrecaseDto(PrpLrecaseDto prpLrecaseDto)
  {
    this.prpLrecaseDto = prpLrecaseDto;
  }
}
  

