package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prplrecase重开赔案表的数据传输对象类<br>
 * 创建于 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLrecasetgDto extends PrpLrecasetgDtoBase implements Serializable{
   
	//2011
	//理算号
	private String compensateNo="";
	 private String reCaseReason = "";
	 private double recaseMoney;
	/**
     *  默认构造方法,构造一个默认的PrpLrecasetgDto对象
     */
    public PrpLrecasetgDto(){
    }
    
    public void setReCaseReason(String reCaseReason){
        this.reCaseReason = StringUtils.rightTrim(reCaseReason);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
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
