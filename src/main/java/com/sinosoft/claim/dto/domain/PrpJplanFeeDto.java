package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ����Ӧ��Ӧ������Ϣ������ݴ��������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpJplanFeeDto extends PrpJplanFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����ո�����*/
    private DateTime payRefDate = new DateTime();
    /** �����ո���� */
    private double payRefFee = 0D;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJplanFeeDto����
     */
    public PrpJplanFeeDto(){
    }
	public DateTime getPayRefDate() {
		return payRefDate;
	}
	public void setPayRefDate(DateTime payRefDate) {
		this.payRefDate = payRefDate;
	}
	public double getPayRefFee() {
		return payRefFee;
	}
	public void setPayRefFee(double payRefFee) {
		this.payRefFee = payRefFee;
	}
    
}
