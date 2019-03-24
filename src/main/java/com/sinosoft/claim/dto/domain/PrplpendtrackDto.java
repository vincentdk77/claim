package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLPENDTRACK�����ݴ��������<br>
 */
public class PrplpendtrackDto extends PrplpendtrackDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������ */
    private String policyNo = "";
    /** �������� */
    private String insuredname = "";
    /** ���ƺ� */
    private String licenseno = "";
    /** �б��������� */
    private String comcodeName = "";
    
    private TurnPageDto turnPageDto = null;
    
    private ArrayList<PrplpendtrackrsDto> prplpendtrackrsDtoList;
    
    public String getComcodeName() {
		return comcodeName;
	}

	public void setComcodeName(String comcodeName) {
		this.comcodeName = comcodeName;
	}

	public ArrayList<PrplpendtrackrsDto> getPrplpendtrackrsDtoList() {
		return prplpendtrackrsDtoList;
	}

	public void setPrplpendtrackrsDtoList(
			ArrayList<PrplpendtrackrsDto> prplpendtrackrsDtoList) {
		this.prplpendtrackrsDtoList = prplpendtrackrsDtoList;
	}

	public String getInsuredname() {
		return insuredname;
	}

	public String getLicenseno() {
		return licenseno;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}

	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}

	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpendtrackDto����
     */
    public PrplpendtrackDto(){
    }
}
