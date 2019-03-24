package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLmessage理赔流转讨论留言表的数据传输对象类<br>
 * 创建于 2004-07-27 16:11:36.736<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLmessageDto extends PrpLmessageDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLmessageDto对象
     */

    public PrpLmessageDto(){

    }

    /*属性节点中文名称*/
    private String nodeTypeName;

    /*属性留言内容列表*/
    private Collection messageList;

    /**设置属性留言内容列表
    * @param contextList 属性留言内容列表
    */
   public void setMessageList(Collection messageList) {
     this.messageList = messageList;
   }

  public void setNodeTypeName(String nodeTypeName) {
    this.nodeTypeName = nodeTypeName;
  }

  /**得到属性留言内容列表
  * @return 属性留言内容列表
  */
   public Collection getMessageList() {
      return messageList;
    }

  public String getNodeTypeName() {
    return nodeTypeName;
  }
}




