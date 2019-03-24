package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleObjectDto;
/**
 * �°�����ʾ���ݴ������
 * <p>Title: �°�����ʾDTO</p>
 * <p>Description: ������������ڵ�</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleObjectDto implements Serializable
{
   /** ���Ȼ���������Ϣ*/
  private PrpLscheduleObjectDto prpLscheduleObjectDto;
  
   /** ��˾������Ϣ*/
  private PrpDcompanyDto prpdcompanyDto;
  
  /** �༭���� */
    private String editType = "" ;
    
     /**��Ҫ������Ϣ������*/
  String alertMessage="";
  
  
  
 /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLscheduleObjectDto getPrpLscheduleObjectDto()
  {
    return prpLscheduleObjectDto;
  }

  /**���õ���������Ϣ
   * @param prpLscheduleObjectDto ����������Ϣ
   */
  public void setPrpLscheduleObjectDto(PrpLscheduleObjectDto prpLscheduleObjectDto)
  {
     this.prpLscheduleObjectDto = prpLscheduleObjectDto;
  }
   /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpDcompanyDto getPrpdcompanyDto()
  {
    return prpdcompanyDto;
  }

  /**���õ���������Ϣ
   * @param prpdcompanyDto ����������Ϣ
   */
  public void setPrpdcompanyDto(PrpDcompanyDto prpdcompanyDto)
  {
     this.prpdcompanyDto = prpdcompanyDto;
  }


  public String getEditType() {
    return editType;
  }
  
   public void setEditType(String editType) {
    this.editType = editType;
  }
  
     /**�õ�alertMessage��Ϣ
   * @return alertMessage��Ϣ
   */
   public String getAlertMessage() {
     return  alertMessage;
   }
   /**����alertMessage��Ϣ
   * @param alertMessage��Ϣ
   */
   public void setAlertMessage(String alertMessage) {
     this.alertMessage = alertMessage;
   }

}
