package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLpersonWound ������Ϣ������ݴ��������<br>
 * ������ 2005-02-18 10:21:16.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonWoundDto extends PrpLpersonWoundDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonWoundDto����
     */
    public PrpLpersonWoundDto() {
    }

    Collection woundList;
    public void setWoundList(Collection woundList) {
      this.woundList = woundList;
    }

    public Collection getWoundList() {
      return woundList;
    }

}
