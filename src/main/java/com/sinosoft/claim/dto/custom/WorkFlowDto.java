package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;

/**
 * 工作流流程数据传输对象
 * <p>Title: 工作流流程DTO</p>
 * <p>Description: 车险理赔理赔节点 工作流部分</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowDto implements Serializable
{
  /** 工作流流程节点信息*/
  private ArrayList  swfLogDtoList ;
  /** 工作流流程边信息*/
  private ArrayList  swfPathLogDtoList ;
  /** 工作流日志业务信息*/
  private ArrayList  swfPackageDtoList ;

  /** 工作流流程主表信息*/
  private SwfFlowMainDto swfFlowMainDto;

  /*-----------以上定义由于后来的事务处理，后来不再使用-----------*/


  /** 工作流当前处理节点的业务编码信息*/
  private String bessinessNo="";
  /** 工作流当前状态 0 正常， 9异常 只做运算时候用的。*/
  private String status="0";
  /** 工作流创建操作*/

  private boolean create =false;
  /**创建时，创建节点的工作流流程节点信息*/
  private SwfLogDto createSwfLogDto;
  /** 创建时，工作流流程主表信息*/
  private SwfFlowMainDto createSwfFlowMainDto;

  /** 工作流更新操作*/
  private boolean update =false;
  /**更新时，更新节点的工作流流程节点信息*/
  private SwfLogDto updateSwfLogDto;
  /**更新时，批量更新节点的信息*/
  private ArrayList updateSwfLogDtoList;

  /** 工作流提交操作*/
  private boolean submit=false;
  /**提交时，新增加节点的工作流流程节点信息*/
  private ArrayList  submitSwfLogDtoList;
  /**提交时，新增加节点路径的工作流流程节点路径信息*/
  private ArrayList  submitSwfPathLogDtoList;
  
   /**节点的办理信息*/
  private ArrayList swfNotionDtoList;


  /** 工作流关闭操作*/
  private boolean close=false;
 /** 关闭时，工作流流程主表信息*/
  private SwfFlowMainDto closeSwfFlowMainDto;
  
  
 /** 数据整理的结果*/
  private int operateResult=0;
  
  /** 工作流重开操作*/
  private boolean reOpen=false;
  /**重开时，工作流流程主表信息*/
  private SwfFlowMainDto reOpenSwfFlowMainDto;
  


  /** 工作流日志存储信息*/
  /** 工作流日志包信息存储信息*/

  /** 工作流是否已经被关闭操作*/
  private boolean checkClose=false;
  
  
  /** 是否是需要进行占用节点操作*/
  boolean freeHoldNode = false;
  /** 工作流回收操作 */
  boolean recycle = false;
  /**更新时，可以更新节点的另外一个，就是更新的时候，可以更新两个节点。工作流流程节点信息*/
  private SwfLogDto updateSwfLog2Dto;
  
  /** 并案工作流操作 */
  private ArrayList  workFlowDtoList;


   public WorkFlowDto()
  {
  }
  
  
   /**数据整理的结果
   * @return 工作流流程主表信息
   */
  public int getOperateResult()
  {
    return operateResult;
  }

  /**设置工作流流程主表信息
   * @param prpLscheduleMainWFDto 工作流流程主表信息
   */
  public void setOperateResult(int operateResult)
  {
     this.operateResult = operateResult;
  }

  /**得到工作流流程主表信息
   * @return 工作流流程主表信息
   */
  public SwfFlowMainDto getSwfFlowMainDto()
  {
    return swfFlowMainDto;
  }

  /**设置工作流流程主表信息
   * @param prpLscheduleMainWFDto 工作流流程主表信息
   */
  public void setSwfFlowMainDto(SwfFlowMainDto swfFlowMainDto)
  {
     this.swfFlowMainDto = swfFlowMainDto;
  }

 /**得到工作流流程节点信息
   * @return  工作流流程节点信息
   */
  public ArrayList getSwfLogDtoList()
  {
    return swfLogDtoList;
  }
  /**设置工作流流程节点信息
   * @param PrpLscheduleItemDto工作流流程节点信息
   */
  public void setSwfLogDtoList(ArrayList swfLogDtoList)
  {
    this.swfLogDtoList = swfLogDtoList;
  }

   /**得到工作流流程边信息
    * @return 工作流流程边信息
    */
   public ArrayList getSwfPathLogDtoList()
  {
    return swfPathLogDtoList;
  }

   /**设置工作流流程边信息
    * @param prpLclaimStuatsDto 工作流流程边信息
    */
   public void setSwfPathLogDtoList(ArrayList swfPathLogDtoList)
  {
    this.swfPathLogDtoList= swfPathLogDtoList;
  }

/**得到工作流日志业务信息
   * @return  工作流日志业务信息
   */
  public ArrayList getSwfPackageDtoList ()
  {
    return swfPackageDtoList ;
  }
  /**设置工作流日志业务信息
   * @param PrpLthirdPartyDtoList 工作流日志业务表信息
   */
  public void setSwfPackageDtoList (ArrayList swfPackageDtoList )
  {
    this.swfPackageDtoList  =swfPackageDtoList ;
  }



  /**得到工作流当前处理节点的业务编码信息
     * @return 工作流当前处理节点的业务编码信息
     */
    public String getBessinessNo()
    {
      return bessinessNo;
    }

    /**设置工作流当前处理节点的业务编码信息
     * @param prpLscheduleMainWFDto 工作流当前处理节点的业务编码信息
     */
    public void setBessinessNo(String bessinessNo)
    {
       this.bessinessNo = bessinessNo;
    }


    /**得到工作流当前状态
     * @return 工作流当前状态
     */
    public String getStatus()
    {
      return status;
    }

    /**设置工作流当前状态
     * @param status 工作流当前状态
     */
    public void setStatus(String status)
    {
       this.status = status;
    }


  /**得到工作流创建操作
   * @return 工作流创建操作
   */
  public boolean getCreate()
  {
    return create;
  }

  /**设置工作流创建操作
   * @param boolean 工作流创建操作
   */
  public void setCreate(boolean create)
  {
     this.create= create;
  }


   /**得到工作流更新操作
   * @return 工作流更新操作
   */
  public boolean getUpdate()
  {
    return update;
  }

  /**设置工作流更新操作
   * @param boolean 工作流更新操作
   */
  public void setUpdate(boolean update)
  {
     this.update = update;
  }

  /**得到工作流提交操作
   * @return 工作流提交操作
   */
  public boolean getSubmit()
  {
    return submit;
  }

  /**设置工作流提交操作
   * @param boolean 工作流提交操作
   */
  public void setSubmit(boolean submit)
  {
     this.submit = submit;
  }
  /**得到工作流关闭操作
   * @return 工作流关闭操作
   */
  public boolean getClose()
  {
    return close;
  }

  /**设置工作流关闭操作
   * @param boolean 工作流关闭操作
   */
  public void setClose(boolean close)
  {
     this.close = close;
  }


  /**得到提交时，新增加节点的工作流流程节点信息
   * @return  工作流流程节点信息
   */
  public ArrayList getSubmitSwfLogDtoList()
  {
    return submitSwfLogDtoList;
  }
  /**设置提交时，新增加节点的工作流流程节点信息
   * @param PrpLscheduleItemDto工作流流程节点信息
   */
  public void setSubmitSwfLogDtoList(ArrayList submitSwfLogDtoList)
  {
    this.submitSwfLogDtoList = submitSwfLogDtoList;
  }

 /**得到更新时，更新节点的工作流流程节点信息
   * @return  工作流流程节点信息
   */
  public SwfLogDto getUpdateSwfLogDto()
  {
    return updateSwfLogDto;
  }


  /**设置更新时，更新节点的工作流流程节点信息
   * @param Dto工作流流程节点信息
   */
  public void setUpdateSwfLogDto(SwfLogDto updateSwfLogDto)
  {
    this.updateSwfLogDto = updateSwfLogDto;
  }
/**得到创建时，创建节点的工作流流程节点信息
   * @return  工作流流程节点信息
   */
  public SwfLogDto getCreateSwfLogDto()
  {
    return createSwfLogDto;
  }


  /**设置创建时，创建节点的工作流流程节点信息
   * @param Dto工作流流程节点信息
   */
  public void setCreateSwfLogDto(SwfLogDto createSwfLogDto)
  {
    this.createSwfLogDto = createSwfLogDto;
  }
  /**得到提交时，新增加节点路径的工作流流程节点路径信息
    * @return  工作流流程节点路径信息
    */
   public ArrayList getSubmitSwfPathLogDtoList()
   {
     return submitSwfPathLogDtoList;
   }
   /**设置提交时，新增加节点路径的工作流流程节点路径信息
    * @param PrpLscheduleItemDto工作流流程节点路径信息
    */
   public void setSubmitSwfPathLogDtoList(ArrayList submitSwfPathLogDtoList)
   {
     this.submitSwfPathLogDtoList = submitSwfPathLogDtoList;
   }

   /**得到更新时，批量更新的工作流流程节点信息
     * @return  工作流流程节点信息
     */
    public ArrayList getUpdateSwfLogDtoList()
    {
      return updateSwfLogDtoList;
    }
    /**设置更新时，批量更新的工作流流程节点信息
     * @param PrpLscheduleItemDto工作流流程节点信息
     */
    public void setUpdateSwfLogDtoList(ArrayList updateSwfLogDtoList)
    {
      this.updateSwfLogDtoList = updateSwfLogDtoList;
    }
    
    
     /**得到节点批办信息节点信息
     * @return  工作流流程节点信息
     */
    public ArrayList getSwfNotionDtoList()
    {
      return swfNotionDtoList;
    }
    /**设置节点批办信息节点信息
     * @param PrpLscheduleItemDto工作流流程节点信息
     */
    public void setSwfNotionDtoList(ArrayList swfNotionDtoList)
    {
      this.swfNotionDtoList = swfNotionDtoList;
    }


/**得到创建工作流流程主表信息
   * @return 创建工作流流程主表信息
   */
  public SwfFlowMainDto getCreateSwfFlowMainDto()
  {
    return createSwfFlowMainDto;
  }

  /**设置创建工作流流程主表信息
   * @param prpLscheduleMainWFDto 创建工作流流程主表信息
   */
  public void setCreateSwfFlowMainDto(SwfFlowMainDto createSwfFlowMainDto)
  {
     this.createSwfFlowMainDto = createSwfFlowMainDto;
  }

  /**得到关闭工作流流程主表信息
   * @return 关闭工作流流程主表信息
   */
  public SwfFlowMainDto getCloseSwfFlowMainDto()
  {
    return closeSwfFlowMainDto;
  }

  /**设置关闭工作流流程主表信息
   * @param prpLscheduleMainWFDto 关闭工作流流程主表信息
   */
  public void setCloseSwfFlowMainDto(SwfFlowMainDto closeSwfFlowMainDto)
  {
     this.closeSwfFlowMainDto = closeSwfFlowMainDto;
  }

  /**得到工作流是否已经被关闭操作
     * @return 工作流是否已经被关闭操作
     */
    public boolean getCheckClose()
    {
      return checkClose;
    }

    /**设置工作流是否已经被关闭操作
     * @param boolean 工作流是否已经被关闭操作
     */
    public void setCheckClose(boolean checkClose)
    {
       this.checkClose = checkClose;
    }

        /**是否是正在独自占用该节点
       * @return 正在独自占用该节点
       */
       public boolean getFreeHoldNode() {
         return  this.freeHoldNode ;
       }
      /**设置正在独自占用该节点
       * @param 正在独自占用该节点
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
    //reasion:重开
    public void setReOpen(boolean reOpen) {
        this.reOpen = reOpen;
    }
 public boolean getReOpen() {
        return reOpen;
    }
 /**得到重新打开工作流流程主表信息
  * @return 重新打开工作流流程主表信息
  */
 public SwfFlowMainDto getReOpenSwfFlowMainDto()
 {
   return reOpenSwfFlowMainDto;
 }

 /**设置重新打开工作流流程主表信息
  * @param prpLscheduleMainWFDto 重新打开工作流流程主表信息
  */
 public void setReOpenSwfFlowMainDto(SwfFlowMainDto reOpenSwfFlowMainDto)
 {
    this.reOpenSwfFlowMainDto = reOpenSwfFlowMainDto;
 }
 
 /**得到更新时，2更新节点的工作流流程节点信息
  * @return  工作流流程节点信息
  */
 public SwfLogDto getUpdateSwfLog2Dto()
 {
   return updateSwfLog2Dto;
 }


 /**设置更新时，2更新节点的工作流流程节点信息
  * @param Dto工作流流程节点信息
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
