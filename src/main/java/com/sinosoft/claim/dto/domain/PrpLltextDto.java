package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prplltext�������ֱ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLltextDto extends PrpLltextDtoBase implements Serializable{
    private Collection ltextList ;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLltextDto����
     */
    public PrpLltextDto(){
    }

    public Collection getLtextList(){
      return ltextList;
    }
    /**
     * �����б�
     * @param driverList �����õ��б�
     */
    public void setLtextList(Collection ltextList) {
      this.ltextList = ltextList;
    	}
	
}
