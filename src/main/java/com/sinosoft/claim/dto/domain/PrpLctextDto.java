package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplctext���������ֱ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLctextDto extends PrpLctextDtoBase implements Serializable{


  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLctextDto����
     */
    public PrpLctextDto(){
    }
    /** ������ʾ�б�*/
    private Collection prpLctextList ;

    /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
    public void setPrpLctextList(Collection prpLctextList) {
      this.prpLctextList = prpLctextList;
    }
    
    /**�õ�������ʾ�б�
    * @return ������ʾ�б�
    */
    public Collection getPrpLctextList() {
      return prpLctextList;
    }

}
