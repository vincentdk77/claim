package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * �������������ݴ������
 * <p>Title: ����������DTO</p>
 * <p>Description: ������������ڵ� ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowDto implements Serializable
{
  /** ���������̽ڵ���Ϣ*/
  private ArrayList  swfLogDtoList ;
  /** ���������̱���Ϣ*/
  private ArrayList  swfPathLogDtoList ;
  /** ��������־ҵ����Ϣ*/
  private ArrayList  swfPackageDtoList ;

  /** ����������������Ϣ*/
  private SwfFlowMainDto swfFlowMainDto;

  /*-----------���϶������ں�������������������ʹ��-----------*/


  /** ��������ǰ����ڵ��ҵ�������Ϣ*/
  private String bessinessNo="";
  /** ��������ǰ״̬ 0 ������ 9�쳣 ֻ������ʱ���õġ�*/
  private String status="0";
  /** ��������������*/

  private boolean create =false;
  /**����ʱ�������ڵ�Ĺ��������̽ڵ���Ϣ*/
  private SwfLogDto createSwfLogDto;
  /** ����ʱ������������������Ϣ*/
  private SwfFlowMainDto createSwfFlowMainDto;

  /** ���������²���*/
  private boolean update =false;
  /**����ʱ�����½ڵ�Ĺ��������̽ڵ���Ϣ*/
  private SwfLogDto updateSwfLogDto;
  /**����ʱ���������½ڵ����Ϣ*/
  private ArrayList updateSwfLogDtoList;

  /** �������ύ����*/
  private boolean submit=false;
  /**�ύʱ�������ӽڵ�Ĺ��������̽ڵ���Ϣ*/
  private ArrayList  submitSwfLogDtoList;
  /**�ύʱ�������ӽڵ�·���Ĺ��������̽ڵ�·����Ϣ*/
  private ArrayList  submitSwfPathLogDtoList;
  
   /**�ڵ�İ�����Ϣ*/
  private ArrayList swfNotionDtoList;


  /** �������رղ���*/
  private boolean close=false;
 /** �ر�ʱ������������������Ϣ*/
  private SwfFlowMainDto closeSwfFlowMainDto;
  
  
 /** ��������Ľ��*/
  private int operateResult=0;
  
  /** �������ؿ�����*/
  private boolean reOpen=false;
  /**�ؿ�ʱ������������������Ϣ*/
  private SwfFlowMainDto reOpenSwfFlowMainDto;
  


  /** ��������־�洢��Ϣ*/
  /** ��������־����Ϣ�洢��Ϣ*/

  /** �������Ƿ��Ѿ����رղ���*/
  private boolean checkClose=false;
  
  
  /** �Ƿ�����Ҫ����ռ�ýڵ����*/
  boolean freeHoldNode = false;
  /** ���������ղ��� */
  boolean recycle = false;
  /**����ʱ�����Ը��½ڵ������һ�������Ǹ��µ�ʱ�򣬿��Ը��������ڵ㡣���������̽ڵ���Ϣ*/
  private SwfLogDto updateSwfLog2Dto;
  
  /** �������������� */
  private ArrayList  workFlowDtoList;


   public WorkFlowDto()
  {
  }
  
  
   /**��������Ľ��
   * @return ����������������Ϣ
   */
  public int getOperateResult()
  {
    return operateResult;
  }

  /**���ù���������������Ϣ
   * @param prpLscheduleMainWFDto ����������������Ϣ
   */
  public void setOperateResult(int operateResult)
  {
     this.operateResult = operateResult;
  }

  /**�õ�����������������Ϣ
   * @return ����������������Ϣ
   */
  public SwfFlowMainDto getSwfFlowMainDto()
  {
    return swfFlowMainDto;
  }

  /**���ù���������������Ϣ
   * @param prpLscheduleMainWFDto ����������������Ϣ
   */
  public void setSwfFlowMainDto(SwfFlowMainDto swfFlowMainDto)
  {
     this.swfFlowMainDto = swfFlowMainDto;
  }

 /**�õ����������̽ڵ���Ϣ
   * @return  ���������̽ڵ���Ϣ
   */
  public ArrayList getSwfLogDtoList()
  {
    return swfLogDtoList;
  }
  /**���ù��������̽ڵ���Ϣ
   * @param PrpLscheduleItemDto���������̽ڵ���Ϣ
   */
  public void setSwfLogDtoList(ArrayList swfLogDtoList)
  {
    this.swfLogDtoList = swfLogDtoList;
  }

   /**�õ����������̱���Ϣ
    * @return ���������̱���Ϣ
    */
   public ArrayList getSwfPathLogDtoList()
  {
    return swfPathLogDtoList;
  }

   /**���ù��������̱���Ϣ
    * @param prpLclaimStuatsDto ���������̱���Ϣ
    */
   public void setSwfPathLogDtoList(ArrayList swfPathLogDtoList)
  {
    this.swfPathLogDtoList= swfPathLogDtoList;
  }

/**�õ���������־ҵ����Ϣ
   * @return  ��������־ҵ����Ϣ
   */
  public ArrayList getSwfPackageDtoList ()
  {
    return swfPackageDtoList ;
  }
  /**���ù�������־ҵ����Ϣ
   * @param PrpLthirdPartyDtoList ��������־ҵ�����Ϣ
   */
  public void setSwfPackageDtoList (ArrayList swfPackageDtoList )
  {
    this.swfPackageDtoList  =swfPackageDtoList ;
  }



  /**�õ���������ǰ����ڵ��ҵ�������Ϣ
     * @return ��������ǰ����ڵ��ҵ�������Ϣ
     */
    public String getBessinessNo()
    {
      return bessinessNo;
    }

    /**���ù�������ǰ����ڵ��ҵ�������Ϣ
     * @param prpLscheduleMainWFDto ��������ǰ����ڵ��ҵ�������Ϣ
     */
    public void setBessinessNo(String bessinessNo)
    {
       this.bessinessNo = bessinessNo;
    }


    /**�õ���������ǰ״̬
     * @return ��������ǰ״̬
     */
    public String getStatus()
    {
      return status;
    }

    /**���ù�������ǰ״̬
     * @param status ��������ǰ״̬
     */
    public void setStatus(String status)
    {
       this.status = status;
    }


  /**�õ���������������
   * @return ��������������
   */
  public boolean getCreate()
  {
    return create;
  }

  /**���ù�������������
   * @param boolean ��������������
   */
  public void setCreate(boolean create)
  {
     this.create= create;
  }


   /**�õ����������²���
   * @return ���������²���
   */
  public boolean getUpdate()
  {
    return update;
  }

  /**���ù��������²���
   * @param boolean ���������²���
   */
  public void setUpdate(boolean update)
  {
     this.update = update;
  }

  /**�õ��������ύ����
   * @return �������ύ����
   */
  public boolean getSubmit()
  {
    return submit;
  }

  /**���ù������ύ����
   * @param boolean �������ύ����
   */
  public void setSubmit(boolean submit)
  {
     this.submit = submit;
  }
  /**�õ��������رղ���
   * @return �������رղ���
   */
  public boolean getClose()
  {
    return close;
  }

  /**���ù������رղ���
   * @param boolean �������رղ���
   */
  public void setClose(boolean close)
  {
     this.close = close;
  }


  /**�õ��ύʱ�������ӽڵ�Ĺ��������̽ڵ���Ϣ
   * @return  ���������̽ڵ���Ϣ
   */
  public ArrayList getSubmitSwfLogDtoList()
  {
    return submitSwfLogDtoList;
  }
  /**�����ύʱ�������ӽڵ�Ĺ��������̽ڵ���Ϣ
   * @param PrpLscheduleItemDto���������̽ڵ���Ϣ
   */
  public void setSubmitSwfLogDtoList(ArrayList submitSwfLogDtoList)
  {
    this.submitSwfLogDtoList = submitSwfLogDtoList;
  }

 /**�õ�����ʱ�����½ڵ�Ĺ��������̽ڵ���Ϣ
   * @return  ���������̽ڵ���Ϣ
   */
  public SwfLogDto getUpdateSwfLogDto()
  {
    return updateSwfLogDto;
  }


  /**���ø���ʱ�����½ڵ�Ĺ��������̽ڵ���Ϣ
   * @param Dto���������̽ڵ���Ϣ
   */
  public void setUpdateSwfLogDto(SwfLogDto updateSwfLogDto)
  {
    this.updateSwfLogDto = updateSwfLogDto;
  }
/**�õ�����ʱ�������ڵ�Ĺ��������̽ڵ���Ϣ
   * @return  ���������̽ڵ���Ϣ
   */
  public SwfLogDto getCreateSwfLogDto()
  {
    return createSwfLogDto;
  }


  /**���ô���ʱ�������ڵ�Ĺ��������̽ڵ���Ϣ
   * @param Dto���������̽ڵ���Ϣ
   */
  public void setCreateSwfLogDto(SwfLogDto createSwfLogDto)
  {
    this.createSwfLogDto = createSwfLogDto;
  }
  /**�õ��ύʱ�������ӽڵ�·���Ĺ��������̽ڵ�·����Ϣ
    * @return  ���������̽ڵ�·����Ϣ
    */
   public ArrayList getSubmitSwfPathLogDtoList()
   {
     return submitSwfPathLogDtoList;
   }
   /**�����ύʱ�������ӽڵ�·���Ĺ��������̽ڵ�·����Ϣ
    * @param PrpLscheduleItemDto���������̽ڵ�·����Ϣ
    */
   public void setSubmitSwfPathLogDtoList(ArrayList submitSwfPathLogDtoList)
   {
     this.submitSwfPathLogDtoList = submitSwfPathLogDtoList;
   }

   /**�õ�����ʱ���������µĹ��������̽ڵ���Ϣ
     * @return  ���������̽ڵ���Ϣ
     */
    public ArrayList getUpdateSwfLogDtoList()
    {
      return updateSwfLogDtoList;
    }
    /**���ø���ʱ���������µĹ��������̽ڵ���Ϣ
     * @param PrpLscheduleItemDto���������̽ڵ���Ϣ
     */
    public void setUpdateSwfLogDtoList(ArrayList updateSwfLogDtoList)
    {
      this.updateSwfLogDtoList = updateSwfLogDtoList;
    }
    
    
     /**�õ��ڵ�������Ϣ�ڵ���Ϣ
     * @return  ���������̽ڵ���Ϣ
     */
    public ArrayList getSwfNotionDtoList()
    {
      return swfNotionDtoList;
    }
    /**���ýڵ�������Ϣ�ڵ���Ϣ
     * @param PrpLscheduleItemDto���������̽ڵ���Ϣ
     */
    public void setSwfNotionDtoList(ArrayList swfNotionDtoList)
    {
      this.swfNotionDtoList = swfNotionDtoList;
    }


/**�õ���������������������Ϣ
   * @return ��������������������Ϣ
   */
  public SwfFlowMainDto getCreateSwfFlowMainDto()
  {
    return createSwfFlowMainDto;
  }

  /**���ô�������������������Ϣ
   * @param prpLscheduleMainWFDto ��������������������Ϣ
   */
  public void setCreateSwfFlowMainDto(SwfFlowMainDto createSwfFlowMainDto)
  {
     this.createSwfFlowMainDto = createSwfFlowMainDto;
  }

  /**�õ��رչ���������������Ϣ
   * @return �رչ���������������Ϣ
   */
  public SwfFlowMainDto getCloseSwfFlowMainDto()
  {
    return closeSwfFlowMainDto;
  }

  /**���ùرչ���������������Ϣ
   * @param prpLscheduleMainWFDto �رչ���������������Ϣ
   */
  public void setCloseSwfFlowMainDto(SwfFlowMainDto closeSwfFlowMainDto)
  {
     this.closeSwfFlowMainDto = closeSwfFlowMainDto;
  }

  /**�õ��������Ƿ��Ѿ����رղ���
     * @return �������Ƿ��Ѿ����رղ���
     */
    public boolean getCheckClose()
    {
      return checkClose;
    }

    /**���ù������Ƿ��Ѿ����رղ���
     * @param boolean �������Ƿ��Ѿ����رղ���
     */
    public void setCheckClose(boolean checkClose)
    {
       this.checkClose = checkClose;
    }

        /**�Ƿ������ڶ���ռ�øýڵ�
       * @return ���ڶ���ռ�øýڵ�
       */
       public boolean getFreeHoldNode() {
         return  this.freeHoldNode ;
       }
      /**�������ڶ���ռ�øýڵ�
       * @param ���ڶ���ռ�øýڵ�
       */
       public void setFreeHoldNode(boolean freeHoldNode) {
         this.freeHoldNode = freeHoldNode;
       }


    public boolean getRecycle() {
        return recycle;
    }
    public void setRecycle(boolean recycle) {
        this.recycle = recycle;
    }
//add by lixiang start 2006-6-7
    //reasion:�ؿ�
    public void setReOpen(boolean reOpen) {
        this.reOpen = reOpen;
    }
 public boolean getReOpen() {
        return reOpen;
    }
 /**�õ����´򿪹���������������Ϣ
  * @return ���´򿪹���������������Ϣ
  */
 public SwfFlowMainDto getReOpenSwfFlowMainDto()
 {
   return reOpenSwfFlowMainDto;
 }

 /**�������´򿪹���������������Ϣ
  * @param prpLscheduleMainWFDto ���´򿪹���������������Ϣ
  */
 public void setReOpenSwfFlowMainDto(SwfFlowMainDto reOpenSwfFlowMainDto)
 {
    this.reOpenSwfFlowMainDto = reOpenSwfFlowMainDto;
 }
 
 /**�õ�����ʱ��2���½ڵ�Ĺ��������̽ڵ���Ϣ
  * @return  ���������̽ڵ���Ϣ
  */
 public SwfLogDto getUpdateSwfLog2Dto()
 {
   return updateSwfLog2Dto;
 }


 /**���ø���ʱ��2���½ڵ�Ĺ��������̽ڵ���Ϣ
  * @param Dto���������̽ڵ���Ϣ
  */
 public void setUpdateSwfLog2Dto(SwfLogDto updateSwfLog2Dto)
 {
   this.updateSwfLog2Dto = updateSwfLog2Dto;
 }
//add by lixiang end 2006-6-7


public ArrayList getWorkFlowDtoList() {
	return workFlowDtoList;
}


public void setWorkFlowDtoList(ArrayList workFlowDtoList) {
	this.workFlowDtoList = workFlowDtoList;
}
   
}
