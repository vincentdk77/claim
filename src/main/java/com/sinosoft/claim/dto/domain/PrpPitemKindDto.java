package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����prppitemkind���������Ϣ�����ݴ��������<br>
 * ������ 2004-11-22 15:24:13.078<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPitemKindDto extends PrpPitemKindDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPitemKindDto����
     */
    public PrpPitemKindDto(){
    }
    
    /** �ƶ��豸IMEI�� add by wangxinyang 20180614 */
    private String remark = "";

   	//�ƶ��豸IMEI�� add by wangxinyang 20180614
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
