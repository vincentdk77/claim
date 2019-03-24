package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * �°�����ʾ���ݴ������
 * <p>Title: �°�����ʾDTO</p>
 * <p>Description: ������������ڵ�</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class ScheduleDto implements Serializable
{
   /** ����������Ϣ*/
  private PrpLscheduleMainWFDto prpLscheduleMainWFDto;
  
   /** ���ɵĶ������*/
  private PrpLscheduleItemDto prpLscheduleItemDto;
  
  
   /** ���߳�����Ϣ*/
  private ArrayList  prpLthirdPartyDtoList ;
  /** ���ȱ����Ϣ*/
  private ArrayList  prpLscheduleItemDtoList ;
  /** �鿱������Ϣ*/
  private ArrayList  prpLcheckItemDtoList ;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList;
  
 
  private ArrayList  smcComCodeInfoDtoList ;
  private ArrayList  smSendSMListDtoList;
  /** �ط���Ϣ */
  private PrplreturnvisitswflogDto prplreturnvisitswflogDto;
  
  public ArrayList getSmcComCodeInfoDtoList()
  {
    return smcComCodeInfoDtoList;
  }
 
  public void setSmcComCodeInfoDtoList(ArrayList smcComCodeInfoDtoList)
  {
    this.smcComCodeInfoDtoList = smcComCodeInfoDtoList;
  }
  
  public ArrayList getSmSendSMListDtoList()
  {
    return smSendSMListDtoList;
  }
 
  public void setSmSendSMListDtoList(ArrayList smSendSMListDtoList)
  {
    this.smSendSMListDtoList = smSendSMListDtoList;
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
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  
   /** ���Ե��ȴ����־ */
    private String scheduleType = "";
  
   public ScheduleDto()
  {
  }

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto()
  {
    return prpLscheduleMainWFDto;
  }

  /**���õ���������Ϣ
   * @param prpLscheduleMainWFDto ����������Ϣ
   */
  public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto)
  {
     this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
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

   /**�õ����Ȳ���״̬��Ϣ
    * @return ���Ȳ���״̬��Ϣ
    */
   public PrpLclaimStatusDto getPrpLclaimStatusDto()
   {
     return prpLclaimStatusDto;
   }

   /**���õ��Ȳ���״̬��Ϣ
    * @param prpLclaimStuatsDto ���Ȳ���״̬��Ϣ
    */
   public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
   {
      this.prpLclaimStatusDto = prpLclaimStatusDto;
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


/**�õ��鿱�����Ϣ
   * @return  �鿱�����Ϣ
   */
  public ArrayList getPrpLcheckItemDtoList()
  {
    return prpLcheckItemDtoList;
  }
  /**���ò鿱�����Ϣ
   * @param PrpLcheckItemDto�鿱�����Ϣ
   */
  public void setPrpLcheckItemDtoList(ArrayList prpLcheckItemDtoList)
  {
    this.prpLcheckItemDtoList = prpLcheckItemDtoList;
  }
  
      /**
     * �������Ե��ȴ����־
     * @param scheduleType �����õ����Ե��ȴ����־��ֵ
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * ��ȡ���Ե��ȴ����־
     * @return ���Ե��ȴ����־��ֵ
     */
    public String getScheduleType(){
        return scheduleType;
    }
    
     /**�õ����ȸ���״̬��Ϣ
    * @return ���ȸ���״̬��Ϣ
    */
   public PrpLscheduleItemDto getPrpLscheduleItemDto()
   {
     return prpLscheduleItemDto;
   }

   /**���õ��ȸ���״̬��Ϣ
    * @param prpLclaimStuatsDto ���ȸ���״̬��Ϣ
    */
   public void setPrpLscheduleItemDto(PrpLscheduleItemDto prpLscheduleItemDto)
   {
      this.prpLscheduleItemDto = prpLscheduleItemDto;
   }

   public PrplreturnvisitswflogDto getPrplreturnvisitswflogDto() {
	return prplreturnvisitswflogDto;
   }

   public void setPrplreturnvisitswflogDto(
		PrplreturnvisitswflogDto prplreturnvisitswflogDto) {
	this.prplreturnvisitswflogDto = prplreturnvisitswflogDto;
   }
   
}
