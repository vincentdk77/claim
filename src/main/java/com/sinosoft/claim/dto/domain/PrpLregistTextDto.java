package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplregisttext�ⰸ���ֱ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLregistTextDto extends PrpLregistTextDtoBase implements Serializable{
    /** ������ʾ�б�*/
    private Collection registTextList ;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistTextDto����
     */
    public PrpLregistTextDto(){
    }

    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getRegistTextList(){
      return registTextList;
    }
    /**
     * �����б�
     * @param registTextList �����õ��б�
     */
    public void setRegistTextList(Collection registTextList) {
      this.registTextList = registTextList;
    }

}
