package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLcertifyDirect-����ָ��(����)�����ݴ��������<br>
 * ������ 2005-03-22 17:21:36.031<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcertifyDirectDto extends PrpLcertifyDirectDtoBase implements Serializable{

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyDirectDto����
     */
    public PrpLcertifyDirectDto(){
    }
    /** ���� **/
    Collection certifyDirectList;

    public void setCertifyDirectList(Collection certifyDirectList) {
      this.certifyDirectList = certifyDirectList;
    }

    public Collection getCertifyDirectList() {
      return certifyDirectList;
    }

}
