package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����PrpLregistExt-������Ϣ����˵�������ݴ��������<br>
 * ������ 2005-03-11 11:11:41.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistExtDto extends PrpLregistExtDtoBase implements Serializable{
	
	/** ����ڵ�Name */
	private String nodetypeName;
	/** ���Բ���ԱName */
	private String operatorCodeName;
	/** ��֯����Name */
	private String comCName;
	/** �鿴״̬ */
	private String checkStatus;
	/** �鿱��� */
	private String conTextCheck="";
	/** �˼���� */
    private String conTextVerip="";
    private String conTextVerpo="";
    /** ������� */
    private String conTextVerif="";
    /** �ڵ����� */
    private String nodeName="";
    /** �����ʶ(N/�ݴ�;Y/���) */
    private String nextHandlerCode;
    /** ռ��ʱ�� */
    private String costTime = "" ;
    /** ����ڵ� */
    private String nodetype = "";


	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

public String getNodetypeName() {
		return nodetypeName;
	}

	public String getOperatorCodeName() {
		return operatorCodeName;
	}

	public void setNodetypeName(String nodetypeName) {
		this.nodetypeName = nodetypeName;
	}

	public void setOperatorCodeName(String operatorCodeName) {
		this.operatorCodeName = operatorCodeName;
	}

public void setRegistExtList(Collection registExtList) {
    this.registExtList = registExtList;
  }

  public Collection getRegistExtList() {
    return registExtList;
  }

  /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistExtDto����
     */
    public PrpLregistExtDto(){
  }
    /** ���� **/
    Collection registExtList;

	public String getConTextCheck() {
		return conTextCheck;
	}

	public String getConTextVerip() {
		return conTextVerip;
	}

	public String getConTextVerpo() {
		return conTextVerpo;
	}

	public String getConTextVerif() {
		return conTextVerif;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setConTextCheck(String conTextCheck) {
		this.conTextCheck = conTextCheck;
	}

	public void setConTextVerip(String conTextVerip) {
		this.conTextVerip = conTextVerip;
	}

	public void setConTextVerpo(String conTextVerpo) {
		this.conTextVerpo = conTextVerpo;
	}

	public void setConTextVerif(String conTextVerif) {
		this.conTextVerif = conTextVerif;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	/**
	 * @return the nextHandlerCode
	 */
	public String getNextHandlerCode() {
		return nextHandlerCode;
	}

	/**
	 * @param nextHandlerCode the nextHandlerCode to set
	 */
	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = nextHandlerCode;
	}

	public String getCostTime() {
		return costTime;
	}

	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	
}
