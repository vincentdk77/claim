package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLverifyLossExt的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLverifyLossExtDto extends PrpLverifyLossExtDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;

    /** 集合 **/
    Collection verifyLossExtList;
    
    /**
     *  默认构造方法,构造一个默认的PrpLverifyLossExtDto对象
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
