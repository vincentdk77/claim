package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpdlimit�޶�������������ݴ��������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDto extends PrpDlimitDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDlimitDto����
     */
    public PrpDlimitDto(){
    }
    /** �б� */
    Collection prpDlimitList = null;

    public void setPrpDlimitList(Collection prpDlimitList) {
      this.prpDlimitList = prpDlimitList;
    }

    public Collection getPrpDlimitList() {
      return prpDlimitList;
    }

}
