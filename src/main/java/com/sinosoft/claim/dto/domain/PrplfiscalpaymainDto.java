package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * 这是PRPLFISCALPAYMAIN的数据传输对象类<br>
 */
public class PrplfiscalpaymainDto extends PrplfiscalpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**流入时长**/
    private String totalInputDate = "";
    /**承保机构名称**/
    private String comName = "";
    /**计算书号**/
    private String compensateNo = "";
    /**农户名称**/
    private String receiverfullName = "";
    /**证件号**/
    private String identifyNumber = "";
    /**农户代码**/
    private String insuredCode = "";
    /**账号**/
    private String bankAccount = "";
    
    /** 结果集 */
    private ArrayList resultList;
    /** 一页数据*/
    private TurnPageDto turnPageDto = null ;
    /**
     *  默认构造方法,构造一个默认的PrplfiscalpaymainDto对象
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
