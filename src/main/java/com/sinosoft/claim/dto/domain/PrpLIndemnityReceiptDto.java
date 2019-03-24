package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是赔款收据的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLIndemnityReceiptDto extends PrpLIndemnityReceiptDtoBase implements Serializable{

	private static final long serialVersionUID = 2322782914375687419L;
	/**
     *  默认构造方法,构造一个默认的PrpLIndemnityReceiptDto对象
     */
    public PrpLIndemnityReceiptDto(){
    }
    public static final String DEFAULT_CERTI_TYPE = "C";
}
