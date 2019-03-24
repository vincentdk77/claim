package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * 这是PRPLPAY的数据传输对象类<br>
 */
public class PrplpaytgDto extends PrplpaytgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private String starttime;
    private String startend;
    /**
     * 赔付信息审核平台状态字段:空为未处理，2为正在审核，3为退回，4为通过
     */
    private String vFlag;
    /**被保险人**/
    private String insuredName = "";
    /**车牌号码**/
    private String licenseNo = "";
    /** 一页数据*/
    private TurnPageDto turnPageDto = null ;
  //商业险平台标志字段
    private String uploadserialno="";
    private String comCode;
    private String operatorComCode = "";
    public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getUploadserialno() {
		return uploadserialno;
	}
	public void setUploadserialno(String uploadserialno) {
		this.uploadserialno = uploadserialno;
	}
    /**
     *  默认构造方法,构造一个默认的PrplpaytgDto对象
     */
    public PrplpaytgDto(){
    }
    public String getStarttime() {
        return starttime;
    }
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public String getStartend() {
        return startend;
    }
    public void setStartend(String startend) {
        this.startend = startend;
    }
    public TurnPageDto getTurnPageDto() {
        return turnPageDto;
    }
    public void setTurnPageDto(TurnPageDto turnPageDto) {
        this.turnPageDto = turnPageDto;
    }
	public String getVFlag() {
		return vFlag;
	}
	public void setVFlag(String flag) {
		vFlag = flag;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getOperatorComCode() {
		return operatorComCode;
	}
	public void setOperatorComCode(String operatorComCode) {
		this.operatorComCode = operatorComCode;
	}
	
}
