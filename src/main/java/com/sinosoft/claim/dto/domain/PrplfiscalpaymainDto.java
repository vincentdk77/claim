package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����PRPLFISCALPAYMAIN�����ݴ��������<br>
 */
public class PrplfiscalpaymainDto extends PrplfiscalpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**����ʱ��**/
    private String totalInputDate = "";
    /**�б���������**/
    private String comName = "";
    /**�������**/
    private String compensateNo = "";
    /**ũ������**/
    private String receiverfullName = "";
    /**֤����**/
    private String identifyNumber = "";
    /**ũ������**/
    private String insuredCode = "";
    /**�˺�**/
    private String bankAccount = "";
    
    /** ����� */
    private ArrayList resultList;
    /** һҳ����*/
    private TurnPageDto turnPageDto = null ;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplfiscalpaymainDto����
     */
    public PrplfiscalpaymainDto(){
    }
	public String getTotalInputDate() {
		return totalInputDate;
	}
	public void setTotalInputDate(String totalInputDate) {
		this.totalInputDate = totalInputDate;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public ArrayList getResultList() {
		return resultList;
	}
	public void setResultList(ArrayList resultList) {
		this.resultList = resultList;
	}
	public TurnPageDto getTurnPageDto() {
		return turnPageDto;
	}
	public void setTurnPageDto(TurnPageDto turnPageDto) {
		this.turnPageDto = turnPageDto;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getReceiverfullName() {
		return receiverfullName;
	}
	public void setReceiverfullName(String receiverfullName) {
		this.receiverfullName = receiverfullName;
	}
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
    
}
