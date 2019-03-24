package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLPENDTRACK的数据传输对象类<br>
 */
public class PrplpendtrackDto extends PrplpendtrackDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 保单号 */
    private String policyNo = "";
    /** 被保险人 */
    private String insuredname = "";
    /** 车牌号 */
    private String licenseno = "";
    /** 承保机构名称 */
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
     *  默认构造方法,构造一个默认的PrplpendtrackDto对象
     */
    public PrplpendtrackDto(){
    }
}
