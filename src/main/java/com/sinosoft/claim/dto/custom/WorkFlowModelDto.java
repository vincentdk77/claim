package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;

/**
 * 模板数据传输对象
 * <p>Title: 模板DTO</p>
 * <p>Description: 车险理赔理赔节点 工作流部分</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class WorkFlowModelDto implements Serializable
{
   /** 模板主表信息*/
  private SwfModelMainDto wfModelMainDto;
   /** 模板节点信息*/
  private ArrayList  wfNodeDtoList ;
  /** 模板边信息*/
  private ArrayList  wfPathDtoList ;
  /** 模板边条件信息*/
  private ArrayList  wfConditionDtoList ;
  /** 模板设置范围信息*/

   public WorkFlowModelDto()
  {
  }

  /**得到模板主表信息
   * @return 模板主表信息
   */
  public SwfModelMainDto getSwfModelMainDto()
  {
    return wfModelMainDto;
  }

  /**设置模板主表信息
   * @param prpLscheduleMainWFDto 模板主表信息
   */
  public void setSwfModelMainDto(SwfModelMainDto wfModelMainDto)
  {
     this.wfModelMainDto = wfModelMainDto;
  }

 /**得到模板节点信息
   * @return  模板节点信息
   */
  public ArrayList getSwfNodeDtoList()
  {
    return wfNodeDtoList;
  }
  /**设置模板节点信息
   * @param PrpLscheduleItemDto模板节点信息
   */
  public void setSwfNodeDtoList(ArrayList wfNodeDtoList)
  {
    this.wfNodeDtoList = wfNodeDtoList;
  }

   /**得到模板边信息
    * @return 模板边信息
    */
   public ArrayList getSwfPathDtoList()
  {
    return wfPathDtoList;
  }

   /**设置模板边信息
    * @param prpLclaimStuatsDto 模板边信息
    */
   public void setSwfPathDtoList(ArrayList wfPathDtoList)
  {
    this.wfPathDtoList= wfPathDtoList;
  }

/**得到模板边条件信息
   * @return  模板边条件信息
   */
  public ArrayList getSwfConditionDtoList ()
  {
    return wfConditionDtoList ;
  }
  /**设置模板边条件信息
   * @param PrpLthirdPartyDtoList 模板边条件表信息
   */
  public void setSwfConditionDtoList (ArrayList wfConditionDtoList )
  {
    this.wfConditionDtoList  =wfConditionDtoList ;
  }

}
