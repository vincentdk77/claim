package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLmessage������ת�������Ա�����ݴ��������<br>
 * ������ 2004-07-27 16:11:36.736<br>
 * JToolpad(1.2.12-RC9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLmessageDto extends PrpLmessageDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLmessageDto����
     */

    public PrpLmessageDto(){

    }

    /*���Խڵ���������*/
    private String nodeTypeName;

    /*�������������б�*/
    private Collection messageList;

    /**�����������������б�
    * @param contextList �������������б�
    */
   public void setMessageList(Collection messageList) {
     this.messageList = messageList;
   }

  public void setNodeTypeName(String nodeTypeName) {
    this.nodeTypeName = nodeTypeName;
  }

  /**�õ��������������б�
  * @return �������������б�
  */
   public Collection getMessageList() {
      return messageList;
    }

  public String getNodeTypeName() {
    return nodeTypeName;
  }
}




