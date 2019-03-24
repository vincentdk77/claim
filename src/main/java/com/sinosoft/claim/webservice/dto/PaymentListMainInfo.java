package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 支付信息回访清单
 * 主信息（PaymentListMainInfo）
 * @author Administrator
 *
 */
public class PaymentListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private PaymentListInfo[] paymentListInfoList;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	public PaymentListMainInfo() {
		super();
	}
	public PaymentListInfo[] getPaymentListInfoList() {
		return paymentListInfoList;
	}
	public void setPaymentListInfoList(PaymentListInfo[] paymentListInfoList) {
		this.paymentListInfoList = paymentListInfoList;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
