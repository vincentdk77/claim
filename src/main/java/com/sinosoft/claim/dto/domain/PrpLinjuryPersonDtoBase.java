package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciPerson�����ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLinjuryPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLinjuryPersonDtoBase.class.getName().hashCode();
    /** ����AcciName */
    private String acciName = "";
    /** ����Sex */
    private String sex = "";
    /** ����IdentifyNumber */
    private String identifyNumber = "";
    private String CompensateNo= "";

    public String getCompensateNo() {
		return CompensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		CompensateNo = compensateNo;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciPersonDtoBase����
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
