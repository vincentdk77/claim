package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplcheckext�鿱/���鿱��չ������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcheckExtDto extends PrpLcheckExtDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckExtDto����
     */
    public PrpLcheckExtDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpLcheckExtList ;

   /**����������ʾ�б�
    * @param prpLctextList ������ʾ�б�
    */        
    public void setPrpLcheckExtList(Collection prpLcheckExtList) {
      this.prpLcheckExtList = prpLcheckExtList;
    }
      
   /**�õ�������ʾ�б�
   * @return ������ʾ�б�
   */
    public Collection getPrpLcheckExtList() {
      return prpLcheckExtList;
    }
}
