package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLverifyLossExt�����ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLverifyLossExtDto extends PrpLverifyLossExtDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;

    /** ���� **/
    Collection verifyLossExtList;
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLverifyLossExtDto����
     */
    public PrpLverifyLossExtDto(){
    }
    
    public void setVerifyLossExtList(Collection verifyLossExtList) {
        this.verifyLossExtList = verifyLossExtList;
      }

      public Collection getVerifyLossExtList() {
        return verifyLossExtList;
      }
}
