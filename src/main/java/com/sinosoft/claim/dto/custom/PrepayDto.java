package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;

/**
 * �Զ���Ԥ�����ݴ������
 * <p>Title: ��������Ԥ��DTO</p>
 * <p>Description: ��������Ԥ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class PrepayDto implements Serializable
{
  /** Ԥ������Ϣ*/
  private PrpLprepayDto prpLprepayDto;
  /** Ԥ�ⱨ��*/
  private ArrayList prpLptextDtoList;
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /** ������Ϣ*/
  private PrpLclaimDto prpLclaimDto;
  /** Ԥ��������Ϣ */
  private ArrayList prpLpreChargeDtoList;

  public PrepayDto()
  {
  }

  /**�õ�Ԥ��������Ϣ
   * @return Ԥ��������Ϣ
   */
  public PrpLprepayDto getPrpLprepayDto()
  {
    return prpLprepayDto;
  }

  /**����Ԥ��������Ϣ
   * @param prpLperpayDto Ԥ��������Ϣ
   */
  public void setPrpLprepayDto(PrpLprepayDto prpLprepayDto)
  {
     this.prpLprepayDto = prpLprepayDto;
  }

  /**�õ�Ԥ���ı���Ϣ
   * @return  Ԥ���ı���Ϣ
   */
  public ArrayList getPrpLptextDtoList()
  {
    return prpLptextDtoList;
  }

  /**�õ�����״̬��Ϣ
   * @return  ����״̬��Ϣ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**�õ�������Ϣ
   * @return  ������Ϣ
   */
  public PrpLclaimDto getPrpLclaimDto() {
    return prpLclaimDto;
  }

  /**����Ԥ���ı���Ϣ
   * @param prpLperpayTextDtoList Ԥ���ı���Ϣ
   */
  public void setPrpLptextDtoList(ArrayList prpLptextDtoList)
  {
    this.prpLptextDtoList = prpLptextDtoList;
  }

  /**���ò���״̬��Ϣ
   * @param prpLclaimStatusDto ����״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**����������Ϣ
   * @param prpLclaimDto ������Ϣ
   */
  public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
    this.prpLclaimDto = prpLclaimDto;
  }

	public ArrayList getPrpLpreChargeDtoList() {
		return prpLpreChargeDtoList;
	}
	
	public void setPrpLpreChargeDtoList(ArrayList prpLpreChargeDtoList) {
		this.prpLpreChargeDtoList = prpLpreChargeDtoList;
	}

}
