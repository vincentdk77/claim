package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����WFPATHLOG������·����־������ݴ��������<br>
 * ������ 2004-08-09 19:54:50.640<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class SwfPathLogDto extends SwfPathLogDtoBase implements Serializable{
  /**
   * �б�
   */
  private Collection pathLogList;
  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfPathLogDto����
     */
    public SwfPathLogDto(){
    }

    /**
    * ��ȡ�б�
    * @return �����б�
    */
   public Collection getPathLogList(){
     return pathLogList;
   }

   /**
    * �����б�
    * @param registList �����õ��б�
    */
   public void setPathLogList(Collection pathLogList) {
     this.pathLogList = pathLogList;
   }

}
