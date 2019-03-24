package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.claim.dto.domain.PrpPmainDto;

/**
 * �Զ����������ݴ������
 * <p>Title: ������������DTO</p>
 * <p>Description: ��������������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class EndorseDto implements Serializable
{
  /** ������Ϣ����Ϣ*/
  private PrpPheadDto prpPheadDto;
  /** ���ı�����Ϣ����Ϣ*/
  private PrpPmainDto prpPmainDto;
  /** ���ձ����Ϣ*/
  private ArrayList prpPitemKindDtoList;
  /** ���Ķ���*/
  private ArrayList prpPtextDtoList;
  /** �������ձ����Ϣ*/
  private ArrayList prpPitem_carDtoList;
  /** ���ı���ѱ仯��*/
  private ArrayList prpPfeeDtoList;
  /** �Ż���Ϣ��*/
  private ArrayList prpPprofitDtoList;
  /** �ر�Լ����*/
  private ArrayList prpPengageDtoList;

  /** ������Ϣ����Ϣ �б�*/
  private ArrayList prpPheadDtoList;
  /** ���ı�����Ϣ����Ϣ �б� */
  private ArrayList prpPmainDtoList;
  /** ���Ĺ�����Ϣ����Ϣ �б� */
  private ArrayList prpPCoinsDtoList;
  /** ���Ĺ�����ϸ��Ϣ����Ϣ �б� */
  private ArrayList prpPCoinsDetailDtoList;


  public ArrayList getPrpPitemKindDtoList() {
    return prpPitemKindDtoList;
  }

  public PrpPmainDto getPrpPmainDto() {
    return prpPmainDto;
  }

  public ArrayList getPrpPtextDtoList() {
    return prpPtextDtoList;
  }

  public void setPrpPheadDto(PrpPheadDto prpPheadDto) {
    this.prpPheadDto = prpPheadDto;
  }

  public void setPrpPitemKindDtoList(ArrayList prpPitemKindDtoList) {
    this.prpPitemKindDtoList = prpPitemKindDtoList;
  }

  public void setPrpPmainDto(PrpPmainDto prpPmainDto) {
    this.prpPmainDto = prpPmainDto;
  }

  public void setPrpPtextDtoList(ArrayList prpPtextDtoList) {
    this.prpPtextDtoList = prpPtextDtoList;
  }

  public void setPrpPmainDtoList(ArrayList prpPmainDtoList) {
    this.prpPmainDtoList = prpPmainDtoList;
  }

  public void setPrpPheadDtoList(ArrayList prpPheadDtoList) {
    this.prpPheadDtoList = prpPheadDtoList;
  }

  public void setPrpPprofitDtoList(ArrayList prpPprofitDtoList) {
    this.prpPprofitDtoList = prpPprofitDtoList;
  }

  public void setPrpPitem_carDtoList(ArrayList prpPitem_carDtoList) {
    this.prpPitem_carDtoList = prpPitem_carDtoList;
  }

  public void setPrpPengageDtoList(ArrayList prpPengageDtoList) {
    this.prpPengageDtoList = prpPengageDtoList;
  }

  public void setPrpPfeeDtoList(ArrayList prpPfeeDtoList) {
    this.prpPfeeDtoList = prpPfeeDtoList;
  }

  public PrpPheadDto getPrpPheadDto() {
    return prpPheadDto;
  }

  public ArrayList getPrpPmainDtoList() {
    return prpPmainDtoList;
  }

  public ArrayList getPrpPheadDtoList() {
    return prpPheadDtoList;
  }

  public ArrayList getPrpPprofitDtoList() {
    return prpPprofitDtoList;
  }

  public ArrayList getPrpPitem_carDtoList() {
    return prpPitem_carDtoList;
  }

  public ArrayList getPrpPengageDtoList() {
    return prpPengageDtoList;
  }

  public ArrayList getPrpPfeeDtoList() {
    return prpPfeeDtoList;
  }

  public ArrayList getPrpPCoinsDtoList() {
	return prpPCoinsDtoList;
}

public void setPrpPCoinsDtoList(ArrayList prpPCoinsDtoList) {
	this.prpPCoinsDtoList = prpPCoinsDtoList;
}

public ArrayList getPrpPCoinsDetailDtoList() {
	return prpPCoinsDetailDtoList;
}

public void setPrpPCoinsDetailDtoList(ArrayList prpPCoinsDetailDtoList) {
	this.prpPCoinsDetailDtoList = prpPCoinsDetailDtoList;
}

public EndorseDto()
  {
  }

}
