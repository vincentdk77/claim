package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PrpCcoinsDetail�����ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCcoinsDetailDto extends PrpCcoinsDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcoinsDetailDto����
     */
    public PrpCcoinsDetailDto(){
    }
    /** ���Թ����ݶ� */
    private double coinsRate = 0d;
	public double getCoinsRate() {
		return coinsRate;
	}
	public void setCoinsRate(double coinsRate) {
		this.coinsRate = coinsRate;
	}
    
}
