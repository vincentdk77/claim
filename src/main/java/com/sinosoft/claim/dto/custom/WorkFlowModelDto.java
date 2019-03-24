package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;

/**
 * ģ�����ݴ������
 * <p>Title: ģ��DTO</p>
 * <p>Description: ������������ڵ� ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowModelDto implements Serializable
{
   /** ģ��������Ϣ*/
  private SwfModelMainDto wfModelMainDto;
   /** ģ��ڵ���Ϣ*/
  private ArrayList  wfNodeDtoList ;
  /** ģ�����Ϣ*/
  private ArrayList  wfPathDtoList ;
  /** ģ���������Ϣ*/
  private ArrayList  wfConditionDtoList ;
  /** ģ�����÷�Χ��Ϣ*/

   public WorkFlowModelDto()
  {
  }

  /**�õ�ģ��������Ϣ
   * @return ģ��������Ϣ
   */
  public SwfModelMainDto getSwfModelMainDto()
  {
    return wfModelMainDto;
  }

  /**����ģ��������Ϣ
   * @param prpLscheduleMainWFDto ģ��������Ϣ
   */
  public void setSwfModelMainDto(SwfModelMainDto wfModelMainDto)
  {
     this.wfModelMainDto = wfModelMainDto;
  }

 /**�õ�ģ��ڵ���Ϣ
   * @return  ģ��ڵ���Ϣ
   */
  public ArrayList getSwfNodeDtoList()
  {
    return wfNodeDtoList;
  }
  /**����ģ��ڵ���Ϣ
   * @param PrpLscheduleItemDtoģ��ڵ���Ϣ
   */
  public void setSwfNodeDtoList(ArrayList wfNodeDtoList)
  {
    this.wfNodeDtoList = wfNodeDtoList;
  }

   /**�õ�ģ�����Ϣ
    * @return ģ�����Ϣ
    */
   public ArrayList getSwfPathDtoList()
  {
    return wfPathDtoList;
  }

   /**����ģ�����Ϣ
    * @param prpLclaimStuatsDto ģ�����Ϣ
    */
   public void setSwfPathDtoList(ArrayList wfPathDtoList)
  {
    this.wfPathDtoList= wfPathDtoList;
  }

/**�õ�ģ���������Ϣ
   * @return  ģ���������Ϣ
   */
  public ArrayList getSwfConditionDtoList ()
  {
    return wfConditionDtoList ;
  }
  /**����ģ���������Ϣ
   * @param PrpLthirdPartyDtoList ģ�����������Ϣ
   */
  public void setSwfConditionDtoList (ArrayList wfConditionDtoList )
  {
    this.wfConditionDtoList  =wfConditionDtoList ;
  }

}
