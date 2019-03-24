package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是prpdcurrency币别代码表的数据传输对象类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDto extends PrpDcurrencyDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpDcurrencyDto对象
     */
    public PrpDcurrencyDto(){
    }
 public PrpDcurrencyDto(String currencyCode,String currencyCName){
    	super(currencyCode,currencyCName);
	  
    }
}
