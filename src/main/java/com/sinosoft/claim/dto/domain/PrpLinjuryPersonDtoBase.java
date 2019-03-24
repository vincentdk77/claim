package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciPerson的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLinjuryPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLinjuryPersonDtoBase.class.getName().hashCode();
    /** 属性AcciName */
    private String acciName = "";
    /** 属性Sex */
    private String sex = "";
    /** 属性IdentifyNumber */
    private String identifyNumber = "";
    private String CompensateNo= "";

    public String getCompensateNo() {
		return CompensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		CompensateNo = compensateNo;
	}

	/**
     *  默认构造方法,构造一个默认的PrpLacciPersonDtoBase对象
     */
    public PrpLinjuryPersonDtoBase(){
    }

	public String getAcciName() {
		return acciName;
	}

	public void setAcciName(String acciName) {
		this.acciName = acciName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

   
}
