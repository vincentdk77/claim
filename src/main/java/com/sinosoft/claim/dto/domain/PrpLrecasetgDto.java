package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplrecase�ؿ��ⰸ������ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrecasetgDto extends PrpLrecasetgDtoBase implements Serializable{
   
	//2011
	//�����
	private String compensateNo="";
	 private String reCaseReason = "";
	 private double recaseMoney;
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLrecasetgDto����
     */
    public PrpLrecasetgDto(){
    }
    
    public void setReCaseReason(String reCaseReason){
        this.reCaseReason = StringUtils.rightTrim(reCaseReason);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getReCaseReason(){
        return reCaseReason;
    }

	/**
	 * @return the compensateNo
	 */
	public String getCompensateNo() {
		return compensateNo;
	}

	/**
	 * @param compensateNo the compensateNo to set
	 */
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}

	/**
	 * @return the recaseMoney
	 */
	public double getRecaseMoney() {
		return recaseMoney;
	}

	/**
	 * @param recaseMoney the recaseMoney to set
	 */
	public void setRecaseMoney(double recaseMoney) {
		this.recaseMoney = recaseMoney;
	}
}
