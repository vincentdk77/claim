package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����prpdcurrency�ұ���������ݴ��������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDto extends PrpDcurrencyDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcurrencyDto����
     */
    public PrpDcurrencyDto(){
    }
 public PrpDcurrencyDto(String currencyCode,String currencyCName){
    	super(currencyCode,currencyCName);
	  
    }
}
