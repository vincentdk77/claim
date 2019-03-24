package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * 这是prppitemkind标的子险信息的数据传输对象类<br>
 * 创建于 2004-11-22 15:24:13.078<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPitemKindDto extends PrpPitemKindDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpPitemKindDto对象
     */
    public PrpPitemKindDto(){
    }
    
    /** 移动设备IMEI码 add by wangxinyang 20180614 */
    private String remark = "";

   	//移动设备IMEI码 add by wangxinyang 20180614
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
