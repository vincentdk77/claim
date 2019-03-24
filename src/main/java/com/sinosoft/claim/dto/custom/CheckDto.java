package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �Զ���鿱���ݴ������
 * <p>Title: ��������鿱DTO</p>
 * <p>Description: ��������鿱��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
public class CheckDto implements Serializable
{
  /** �鿱����Ϣ*/
  private PrpLcheckDto prpLcheckDto;
  /** �鿱��չ��Ϣ */
  private ArrayList prpLcheckExtDtoList;
  /** �¹ʹ����� */
  private ArrayList prpLcheckLossDtoList;
  /** �������Ϣ */
  private ArrayList prpLcompensateeartDtoList;
  /** ����prpLcheckDto��Ϣ */
  private ArrayList prpLcheckDtoList;
  /** ����״̬��Ϣ(����)*/
  private ArrayList prpLclaimStatusDtoList;
  private ArrayList prplCompensateHouseDtoList;

  /**�������˶���ı��*/
  private boolean newScheduleItem=false;
  
     /** ���ȱ�ĵ���ϸ����*/
     private String scheduleItemNote="";
     
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
  /** ���߳�����Ϣ*/
  private ArrayList  prpLthirdPartyDtoList;
  /** ��Ա����������Ϣ*/
  private ArrayList prpLpersonTraceDtoList;
  /** ��ʻԱ��Ϣ*/
  private ArrayList prpLdriverDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList;
  /** �鿱����*/
  private ArrayList prpLregistTextDtoList;
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
   /** ���ȱ����Ϣ*/
  private ArrayList  prpLscheduleItemDtoList;

  //modify by wangli add start 20050406
  /** �ر�Լ����Ϣ*/
  private ArrayList  prpCengageDtoList;

  /** ��ʧ��λ��Ϣ*/
  private ArrayList prpLthirdCarLossDtoList;

  /** ��ʧ��λ��Ϣ*/
  private ArrayList prpLthirdPropDtoList;
  
  /**������Ϣ*/
  private AcciCheckDto acciChcekDto;
  
  /** ��������չ��Ϣ add by qinyongli 2005-8-30*/
  private PrpLextDto prpLextDto; 
  /**��ϸ����ԭ����Ϣ*/
  private ArrayList prpLregistTextDtoList3;
  
  public ArrayList getPrpLcompensateeartDtoList() {
	return prpLcompensateeartDtoList;
  }
  public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
	this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
  }
  
  public ArrayList getPrpLregistTextDtoList3() {
	return prpLregistTextDtoList3;
  }
  public void setPrpLregistTextDtoList3(ArrayList prpLregistTextDtoList3) {
	this.prpLregistTextDtoList3 = prpLregistTextDtoList3;
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
 * 
   * ���û�������չ��Ϣ
   * @param PrpLextDto ��������չ��Ϣ
   * */
  public void setPrpLextDto(PrpLextDto prpLextDto) {
  	  this.prpLextDto = prpLextDto;
  }
  /**
   * ��û�������չ��Ϣ
   * @return ��������չ��Ϣ*/
  public PrpLextDto getPrpLextDto() {
  	  return this.prpLextDto;
  }
  
  /**
   * ���õ�����Ϣ
   * @param acciChcekDto ������Ϣ
   * */
  public void setAcciCheckDto(AcciCheckDto acciCheckDto) {
  	  this.acciChcekDto = acciCheckDto;
  }
  
  /**
   * ��õ�����Ϣ
   * @return ������Ϣ*/
  public AcciCheckDto getAcciCheckDto() {
  	  return this.acciChcekDto;
  }

  /**
   * @return Returns the prpCengageDtoList.
   */
  public ArrayList getPrpCengageDtoList() {
  	return prpCengageDtoList;
  }
  /**
   * @param prpCengageDtoList The prpCengageDtoList to set.
   */
  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
  	this.prpCengageDtoList = prpCengageDtoList;
  }
  //modify by wangli add start 20050406


  /**�õ��鿱����Ϣ
   * @return �鿱����Ϣ
   */
  public PrpLcheckDto getPrpLcheckDto() {
    return prpLcheckDto;
  }

  /**�õ�����״̬��Ϣ
   * @return ����״̬��Ϣ
   */
  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  /**���ò鿱����
   * @param prpLregistTextDtoList �鿱����
   */
  public void setPrpLregistTextDtoList(ArrayList prpLregistTextDtoList) {
    this.prpLregistTextDtoList = prpLregistTextDtoList;
  }

  /**���ò鿱����Ϣ
   * @param prpLcheckDto �鿱����Ϣ
   */
  public void setPrpLcheckDto(PrpLcheckDto prpLcheckDto) {
    this.prpLcheckDto = prpLcheckDto;
  }

  /**���ò鿱����
   * @param prpLregistTextDtoList �鿱����
   */
  public ArrayList getPrpLregistTextDtoList() {
    return prpLregistTextDtoList;
  }

  /**�õ����߳�����Ϣ
   * @return  ���߳�����Ϣ
   */
  public ArrayList getPrpLthirdPartyDtoList()
  {
    return prpLthirdPartyDtoList;
  }

  /**�������߳�����Ϣ
   * @param PrpLthirdPartyDtoList ���߳�������Ϣ
   */
  public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList)
  {
    this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
  }

  /**�õ���ԦԱ��Ϣ
   * @return  ��ԦԱ ��Ϣ
   */
  public ArrayList getPrpLdriverDtoList()
  {
    return prpLdriverDtoList;
  }

  /**���ü�ԦԱ��Ϣ
   * @param PrpLdriverDtoList ��ԦԱ����Ϣ
   */
  public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList)
  {
    this.prpLdriverDtoList = prpLdriverDtoList;
  }

  /**�õ��鿱��չ��Ϣ
   * @return  �鿱��չ��Ϣ
   */
  public ArrayList getPrpLcheckExtDtoList()
  {
    return prpLcheckExtDtoList;
  }

  /**���ò鿱��չ��Ϣ
   * @param PrpLcheckExtDtoList �鿱��չ��Ϣ
   */
  public void setPrpLcheckExtDtoList(ArrayList prpLcheckExtDtoList)
  {
    this.prpLcheckExtDtoList = prpLcheckExtDtoList;
  }

  /**�õ��¹ʹ�������Ϣ
   * @return  �¹ʹ�������Ϣ
   */
  public ArrayList getPrpLcheckLossDtoList()
  {
    return prpLcheckLossDtoList;
  }

  /**�����¹ʹ�������Ϣ
   * @param prpLcheckLossDtoList �¹ʹ�������Ϣ
   */
  public void setPrpLcheckLossDtoList(ArrayList prpLcheckLossDtoList)
  {
    this.prpLcheckLossDtoList = prpLcheckLossDtoList;
  }

  /**���ò���״̬��Ϣ
   * @param prpLclaimStatusDto ����״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

      /**�õ����˸�����Ϣ
   * @return  ���˸��� ��Ϣ
   */
  public ArrayList getPrpLpersonTraceDtoList()
  {
    return prpLpersonTraceDtoList;
  }
  /**�������˸�����Ϣ
   * @param PrpLpersonTraceDtoList ���˸��ٱ���Ϣ
   */
  public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList)
  {
    this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
  }

   /**�õ����ȱ����Ϣ
   * @return  ���ȱ����Ϣ
   */
  public ArrayList getPrpLscheduleItemDtoList()
  {
    return prpLscheduleItemDtoList;
  }
  /**���õ��ȱ����Ϣ
   * @param PrpLscheduleItemDto���ȱ����Ϣ
   */
  public void setPrpLscheduleItemDtoList(ArrayList prpLscheduleItemDtoList)
  {
    this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
  }

  /**�õ���ʧ��λ��Ϣ
   * @return  ��ʧ��λ��Ϣ
   */
   public ArrayList getPrpLthirdCarLossDtoList() {
     return prpLthirdCarLossDtoList;
  }

  /**���õ��ȱ����Ϣ
    * @param prpLthirdCarLossDtoList���ȱ����Ϣ
    */
   public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
     this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
   }

   /**����������ʧ��Ϣ
    * @param prpLthirdPropDtoList ������ʧ��Ϣ
    */

    public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
     this.prpLthirdPropDtoList = prpLthirdPropDtoList;
    }

    /**�õ�������ʧ��Ϣ
     * @return  ������ʧ��Ϣ
     */

     public ArrayList getPrpLthirdPropDtoList() {
       return prpLthirdPropDtoList;
     }

     /**�õ�����������
      * @return ����������
      */
     public boolean getNewScheduleItem()
     {
       return newScheduleItem;
     }

     /**��������������
      * @param boolean ����������
      */
     public void setNewScheduleItem(boolean newScheduleItem)
     {
        this.newScheduleItem = newScheduleItem;
     }
     
       /**
        * �������Ե��ȱ�ĵ���ϸ����
        * @param scheduleItemNote �����õ����Ե��ȱ�ĵ���ϸ���ݵ�ֵ
        */
       public void setScheduleItemNote(String scheduleItemNote){
           this.scheduleItemNote = StringUtils.rightTrim(scheduleItemNote);
       }

       /**
        * ��ȡ���Ե��ȱ�ĵ���ϸ����
        * @return ���Ե��ȱ�ĵ���ϸ����
        */
       public String getScheduleItemNote(){
           return scheduleItemNote;
       }

       public ArrayList getPrpLcheckDtoList() {
    		return prpLcheckDtoList;
    	}
    	public void setPrpLcheckDtoList(ArrayList prpLcheckDtoList) {
    		this.prpLcheckDtoList = prpLcheckDtoList;
    	}
    	
    	public ArrayList getPrpLclaimStatusDtoList() {
    		return prpLclaimStatusDtoList;
    	}
    	public void setPrpLclaimStatusDtoList(ArrayList prpLclaimStatusDtoList) {
    		this.prpLclaimStatusDtoList = prpLclaimStatusDtoList;
    	}

  public CheckDto()
  {
  }



}
