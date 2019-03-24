package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;

/**
 * �Զ��嶨�����ݴ������
 * <p>Title: �������ⶨ��DTO</p>
 * <p>Description: �������ⶨ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class CertainLossDto implements Serializable
{
  
  /** ���߳�����Ϣ*/
  private PrpLthirdPartyDto  prpLthirdPartyDto ;	//add by liuyanmei 20051215 
  /** ���߳�����Ϣ*/
  private ArrayList  prpLthirdPartyDtoList ;	//add by liuyanmei 20051215 
  /** ��������*/
  private PrpLverifyLossDto prpLverifyLossDto;
  /** ��������*/
  private ArrayList prpLverifyLossDtoList;
  /** ��������*/
  private ArrayList prpLcarLossDtoList;
  /** ��������嵥 */
  private ArrayList prpLrepairFeeDtoList;
  /** ������Ŀ�嵥 */
  private ArrayList prpLcomponentDtoList;
  /** ��Ա������ϸ��Ϣ�� */
  private ArrayList prpLpersonDtoList;
  /** �Ʋ��˶�����ϸ�嵥�� */
  private ArrayList prpLpropDtoList;
  /** ���������ı� */
  private ArrayList prpLverifyLossItemDtoList;
  /** ������Ϣ�� */
  private ArrayList prpLpersonWoundDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList; 
  /** ��������Ϣ����˵��*/
  private ArrayList prpLverifyLossExtDtoList; 
  /** ���������*/
  private ArrayList swfNotionList; 
  /** ����״̬��Ϣ����*/
  private ArrayList prpLclaimStatusDtoList;
  /** �������ʧ�嵥*/
  private ArrayList prplCompensateEarDtoList;

  private ArrayList prplCompensateHouseDtoList;
  
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**
   * @return Returns the prplCompensateEarDtoList.
   */
  public ArrayList getPrplCompensateEarDtoList() {
  	return prplCompensateEarDtoList;
  }
  /**���ö������ʧ�嵥
   * @param prplCompensateEarDtoList �������ʧ�嵥
   */
  public void setPrplCompensateEarDtoList(ArrayList prplCompensateEarDtoList) {
    this.prplCompensateEarDtoList = prplCompensateEarDtoList;
  }
  
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
  
  /**�õ���Ա������ϸ��Ϣ
   * @return ��Ա������ϸ��Ϣ
   */
 
  
  public ArrayList getPrpLpersonDtoList() {
    return prpLpersonDtoList;
  }

  /**�õ���������嵥��Ϣ
   * @return ��������嵥��Ϣ
   */
  public ArrayList getPrpLrepairFeeDtoList() {
    return prpLrepairFeeDtoList;
  }

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLverifyLossDto getPrpLverifyLossDto() {
    return prpLverifyLossDto;
  }

  /**�õ�������Ŀ�嵥
   * @return ������Ŀ�嵥
   */
  public ArrayList getPrpLcomponentDtoList() {
    return prpLcomponentDtoList;
  }

  /**�õ��Ʋ��˶�����ϸ�嵥��
   * @return �Ʋ��˶�����ϸ�嵥��
   */
  public ArrayList getPrpLpropDtoList() {
    return prpLpropDtoList;
  }

  /**�õ���������
   * @return ��������
   */
  public ArrayList getPrpLcarLossDtoList() {
    return prpLcarLossDtoList;
  }

  /**���ò���״̬��Ϣ
   * @param prpLclaimStatusDto ����״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  /**������Ա������ϸ��Ϣ
   * @param prpLpersonDtoList ��Ա������ϸ��Ϣ
   */
  public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList) {
    this.prpLpersonDtoList = prpLpersonDtoList;
  }

  /**������������嵥��Ϣ
   * @param prpLrepairFeeDtoList ��������嵥��Ϣ
   */
  public void setPrpLrepairFeeDtoList(ArrayList prpLrepairFeeDtoList) {
    this.prpLrepairFeeDtoList = prpLrepairFeeDtoList;
  }

  /**���ö���������Ϣ
   * @param prpLverifyLossDto ����������Ϣ
   */
  public void setPrpLverifyLossDto(PrpLverifyLossDto prpLverifyLossDto) {
    this.prpLverifyLossDto = prpLverifyLossDto;
  }

  /**���û�����Ŀ�嵥
   * @param prpLcomponentDtoList ������Ŀ�嵥
   */
  public void setPrpLcomponentDtoList(ArrayList prpLcomponentDtoList) {
    this.prpLcomponentDtoList = prpLcomponentDtoList;
  }

  /**���òƲ��˶�����ϸ�嵥��
   * @param prpLpropDtoList �Ʋ��˶�����ϸ�嵥��
   */
  public void setPrpLpropDtoList(ArrayList prpLpropDtoList) {
    this.prpLpropDtoList = prpLpropDtoList;
  }

  /**���ö�������
   * @param prpLcarLossDtoList ��������
   */
  public void setPrpLcarLossDtoList(ArrayList prpLcarLossDtoList) {
    this.prpLcarLossDtoList = prpLcarLossDtoList;
  }

  public void setPrpLverifyLossItemDtoList(ArrayList prpLverifyLossItemDtoList) {
    this.prpLverifyLossItemDtoList = prpLverifyLossItemDtoList;
  }

  public void setPrpLverifyLossDtoList(ArrayList prpLverifyLossDtoList) {
    this.prpLverifyLossDtoList = prpLverifyLossDtoList;
  }

  public void setPrpLpersonWoundDtoList(ArrayList prpLpersonWoundDtoList) {
    this.prpLpersonWoundDtoList = prpLpersonWoundDtoList;
  }

  /**�õ�����״̬��Ϣ
   * @return ����״̬��Ϣ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpLverifyLossItemDtoList() {
    return prpLverifyLossItemDtoList;
  }

  public ArrayList getPrpLverifyLossDtoList() {
    return prpLverifyLossDtoList;
  }

  public ArrayList getPrpLpersonWoundDtoList() {
    return prpLpersonWoundDtoList;
  }

  /**
   *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CertainLossDto����
   */
  public CertainLossDto(){
  }

/**
 * @return Returns the swfNotionList.
 */
public ArrayList getSwfNotionList() {
	return swfNotionList;
} 


/**
 * @param swfNotionList The swfNotionList to set.
 */
public void setSwfNotionList(ArrayList swfNotionList) {
	this.swfNotionList = swfNotionList;
}
//add by liuyanmei 20051215 start
/**�õ����߳�����Ϣ
 * @return  ���߳�����Ϣ
 */
public PrpLthirdPartyDto getPrpLthirdPartyDto()
{
  return prpLthirdPartyDto;
}
/**�������߳�����Ϣ
 * @param PrpLthirdPartyDtoList ���߳�������Ϣ
 */
public void setPrpLthirdPartyDto(PrpLthirdPartyDto prpLthirdPartyDto)
{
  this.prpLthirdPartyDto = prpLthirdPartyDto;
}
public ArrayList getPrpLthirdPartyDtoList() {
    return prpLthirdPartyDtoList;
}
public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
	this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
}
public ArrayList getPrpLclaimStatusDtoList() {
	return prpLclaimStatusDtoList;
}
public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
	this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
}



//add by liuyanmei end 
}
