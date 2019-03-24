package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是WFPATHLOG工作流路径日志表的数据传输对象类<br>
 * 创建于 2004-08-09 19:54:50.640<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogDto extends SwfPathLogDtoBase implements Serializable{
  /**
   * 列表
   */
  private Collection pathLogList;
  /**
     *  默认构造方法,构造一个默认的SwfPathLogDto对象
     */
    public SwfPathLogDto(){
    }

    /**
    * 获取列表
    * @return 属性列表
    */
   public Collection getPathLogList(){
     return pathLogList;
   }

   /**
    * 设置列表
    * @param registList 待设置的列表
    */
   public void setPathLogList(Collection pathLogList) {
     this.pathLogList = pathLogList;
   }

}
