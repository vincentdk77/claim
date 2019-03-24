package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;

/**
 * �Զ���������ݴ������
 * <p>Title: �����������DTO</p>
 * <p>Description: �������������������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class VerifyLossDto implements Serializable
{
  /** ����������Ϣ*/
  private PrpLverifyLossDto prpLverifyLossDto;
  /** ����������Ϣ*/
  private ArrayList prpLcarLossDtoList;
  /** ��������嵥��Ϣ */
  private ArrayList prpLrepairFeeDtoList;
  /** ������Ŀ�嵥��Ϣ */
  private ArrayList prpLcomponentDtoList;
  /** ��Ա������ϸ��Ϣ����Ϣ */
  private ArrayList prpLpersonDtoList;
  /** �Ʋ��˺�����ϸ�嵥����Ϣ */
  private ArrayList prpLpropDtoList;
  /** ���������ı� */
  private ArrayList prpLverifyLossItemDtoList;
  /** ������Ϣ�� */
  private ArrayList prpLpersonWoundDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLverifyLossExtDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList;
  
  private ArrayList prplCompensateHouseDtoList;
  
  
  public ArrayList getPrplCompensateHouseDtoList() {
	  	return prplCompensateHouseDtoList;
	  }
	  /**���ö������ʧ�嵥
	   * @param prplCompensateEarDtoList �������ʧ�嵥
	   */
	  public void setPrplCompensateHouseDtoList(ArrayList prplCompensateHouseDtoList) {
	    this.prplCompensateHouseDtoList = prplCompensateHouseDtoList;
	  }
  
  /**
   * @return Returns the prpLverifyLossExtDtoList.
   */
  public ArrayList getPrpLverifyLossExtDtoList() {
  	return prpLverifyLossExtDtoList;
  }
  /** 
   * @param prpLverifyLossExtDtoList The prpLverifyLossExtDtoList to set.
   */
  public void setPrpLverifyLossExtDtoList(ArrayList prpLverifyLossExtDtoList) {
  	this.prpLverifyLossExtDtoList = prpLverifyLossExtDtoList;
  }
  
/**
 * @return Returns the prpLregistExtDtoList.
 */
public ArrayList getPrpLregistExtDtoList() {
	return prpLregistExtDtoList;
}
/** 
 * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
 */
public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
	this.prpLregistExtDtoList = prpLregistExtDtoList;
}
  /** ����״̬��Ϣ��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  /**
   * ��ȡ������Ա������ϸ��Ϣ����Ϣ
   * @return ������Ա������ϸ��Ϣ����Ϣ
   */
  public ArrayList getPrpLpersonDtoList() {
    return prpLpersonDtoList;
  }

  /**
   * ��ȡ������������嵥��Ϣ
   * @return ������������嵥��Ϣ
   */
  public ArrayList getPrpLrepairFeeDtoList() {
    return prpLrepairFeeDtoList;
  }

  /**
   * ��ȡ��������
   * @return ��������
   */
  public PrpLverifyLossDto getPrpLverifyLossDto() {
    return prpLverifyLossDto;
  }

  /**
   * ��ȡ���Ի�����Ŀ�嵥��Ϣ
   * @return ���Ի�����Ŀ�嵥��Ϣ
   */
  public ArrayList getPrpLcomponentDtoList() {
    return prpLcomponentDtoList;
  }

  /**
   * ��ȡ���ԲƲ��˺�����ϸ�嵥����Ϣ
   * @return ���ԲƲ��˺�����ϸ�嵥����Ϣ
   */
  public ArrayList getPrpLpropDtoList() {
    return prpLpropDtoList;
  }

  /**
   * ��ȡ����������Ϣ
   * @return ����������Ϣ
   */
  public ArrayList getPrpLcarLossDtoList() {
    return prpLcarLossDtoList;
  }

  /**
   * �������Բ���״̬��Ϣ��Ϣ
   * @param prpLclaimStatusDto �����õ����Բ���״̬��Ϣ��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**
   * ����������Ա������ϸ��Ϣ����Ϣ
   * @param prpLpersonDtoList �����õ�������Ա������ϸ��Ϣ����Ϣ
   */
  public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList) {
    this.prpLpersonDtoList = prpLpersonDtoList;
  }

  /**
   * ����������������嵥��Ϣ
   * @param prpLrepairFeeDtoList �����õ�������������嵥��Ϣ
   */
  public void setPrpLrepairFeeDtoList(ArrayList prpLrepairFeeDtoList) {
    this.prpLrepairFeeDtoList = prpLrepairFeeDtoList;
  }

  /**
   * �������Ժ�������
   * @param prpLverifyLossDto ��������
   */
  public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
    this.prpLverifyLossDto = prpLverifyLossDto;
  }

  /**
   * �������Ի�����Ŀ�嵥��Ϣ
   * @param prpLcertifyImgDtoList �����õ����Ի�����Ŀ�嵥��Ϣ
   */
  public void setPrpLcomponentDtoList(ArrayList prpLcomponentDtoList) {
    this.prpLcomponentDtoList = prpLcomponentDtoList;
  }

  /**
   * �������ԲƲ��˺�����ϸ�嵥����Ϣ
   * @param prpLpropDtoList �����õ����ԲƲ��˺�����ϸ�嵥����Ϣ
   */
  public void setPrpLpropDtoList(ArrayList prpLpropDtoList) {
    this.prpLpropDtoList = prpLpropDtoList;
  }

  /**
   * �������Ժ���������Ϣ
   * @param prpLcarLossDtoList ����������Ϣ
   */
  public void setPrpLcarLossDtoList(ArrayList prpLcarLossDtoList) {
    this.prpLcarLossDtoList = prpLcarLossDtoList;
  }

  public void setPrpLverifyLossItemDtoList(ArrayList prpLverifyLossItemDtoList) {
    this.prpLverifyLossItemDtoList = prpLverifyLossItemDtoList;
  }

  public void setPrpLpersonWoundDtoList(ArrayList prpLpersonWoundDtoList) {
    this.prpLpersonWoundDtoList = prpLpersonWoundDtoList;
  }

  /**
   * ��ȡ���Բ���״̬��Ϣ��Ϣ
   * @return ���Բ���״̬��Ϣ��Ϣ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpLverifyLossItemDtoList() {
    return prpLverifyLossItemDtoList;
  }

  public ArrayList getPrpLpersonWoundDtoList() {
    return prpLpersonWoundDtoList;
  }

  /**
   *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�VerifyLossDto����
   */
  public VerifyLossDto(){
  }

}
