package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.TurnPageDto;

/**
 * ����PRPLPAY�����ݴ��������<br>
 */
public class PrplpaytgDto extends PrplpaytgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    private String starttime;
    private String startend;
    /**
     * �⸶��Ϣ���ƽ̨״̬�ֶ�:��Ϊδ����2Ϊ������ˣ�3Ϊ�˻أ�4Ϊͨ��
     */
    private String vFlag;
    /**��������**/
    private String insuredName = "";
    /**���ƺ���**/
    private String licenseNo = "";
    /** һҳ����*/
    private TurnPageDto turnPageDto = null ;
  //��ҵ��ƽ̨��־�ֶ�
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpaytgDto����
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
