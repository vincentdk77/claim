package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PrpLcfeecoins�����ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcfeecoinsDto extends PrpLcfeecoinsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcfeecoinsDto����
     */
    public PrpLcfeecoinsDto(){
    }
    private String mainPolicyNo = "" ;
	public String getMainPolicyNo() {
		return mainPolicyNo;
	}
	public void setMainPolicyNo(String mainPolicyNo) {
		this.mainPolicyNo = mainPolicyNo;
	}
    
}
