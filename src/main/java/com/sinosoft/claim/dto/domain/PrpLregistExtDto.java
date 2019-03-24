package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是PrpLregistExt-报案信息补充说明的数据传输对象类<br>
 * 创建于 2005-03-11 11:11:41.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistExtDto extends PrpLregistExtDtoBase implements Serializable{
	
	/** 处理节点Name */
	private String nodetypeName;
	/** 属性操作员Name */
	private String operatorCodeName;
	/** 组织机构Name */
	private String comCName;
	/** 查看状态 */
	private String checkStatus;
	/** 查勘意见 */
	private String conTextCheck="";
	/** 核价意见 */
    private String conTextVerip="";
    private String conTextVerpo="";
    /** 核损意见 */
    private String conTextVerif="";
    /** 节点名称 */
    private String nodeName="";
    /** 保存标识(N/暂存;Y/完成) */
    private String nextHandlerCode;
    /** 占用时间 */
    private String costTime = "" ;
    /** 处理节点 */
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
     *  默认构造方法,构造一个默认的PrpLregistExtDto对象
     */
    public PrpLregistExtDto(){
  }
    /** 集合 **/
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
