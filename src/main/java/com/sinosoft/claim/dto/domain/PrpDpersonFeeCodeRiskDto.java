package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的数据传输对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDpersonFeeCodeRiskDto extends PrpDpersonFeeCodeRiskDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    
    /** 属性费用代码 */
    private String feeName = "";
    
    /**
     *  默认构造方法,构造一个默认的PrpDpersonFeeCodeRiskDto对象
     */
    public PrpDpersonFeeCodeRiskDto(){
    }

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
}
