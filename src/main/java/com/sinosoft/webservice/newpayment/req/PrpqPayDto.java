package com.sinosoft.webservice.newpayment.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DetailInfo")
public class PrpqPayDto  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@XStreamAlias("PayBillNo")
	private String payBillNo;
	/** 属性certitype/业务类型：c，z，k */
	@XStreamAlias("Certitype")
	private String certitype ;
	/** 属性certino/业务号 */
	@XStreamAlias("CertiNo")
	private String certino ;
	/** 属性policyno */
	@XStreamAlias("PolicyNo")
	private String policyno ;		
	/** 属性amount/支付金额 */
	@XStreamAlias("Amount")
	private String amount ;
	/** 属性payreason/收付原因 */
	@XStreamAlias("PayReason")
	private String payreason ;
	/** 属性payno/缴费期数：赔款默认为1 */
	@XStreamAlias("PayNo")
	private String payno ;
	@XStreamAlias("ComeCode")
	private String Comcode;
	
	
	/** 属性flag1/扩展字段1 */
	@XStreamAlias("Flag1")
	private String flag1 ;
	/** 属性flag2/扩展字段2 */
	@XStreamAlias("Flag2")
	private String flag2 ;
	/** 属性flag3/扩展字段3 */
	@XStreamAlias("Flag3")
	private String flag3 ;
	/** 属性flag4/扩展字段4 */
	@XStreamAlias("Flag4")
	private String flag4 ;
	/** 属性flag5/扩展字段5 */
	@XStreamAlias("Flag5")
	private String flag5 ;

	
	@XStreamAlias("ArticleCode01")
	private String articleCode01 ;
	
	/** 属性ArticleCode02 */
	@XStreamAlias("ArticleCode02")
	private String articleCode02 ;
	
	/** 属性ArticleCode03 */
	@XStreamAlias("ArticleCode03")
	private String articleCode03 ;
	
	/** 属性ArticleCode04 */
	@XStreamAlias("ArticleCode04")
	private String articleCode04 ;
	
	/** 属性ArticleCode05 */
	@XStreamAlias("ArticleCode05")
	private String articleCode05 ;
	
	/** 属性ArticleCode06 */
	@XStreamAlias("ArticleCode06")
	private String articleCode06 ;
	
	/** 属性ArticleCode07 */
	@XStreamAlias("ArticleCode07")
	private String articleCode07 ;
	
	/** 属性ArticleCode08 */
	@XStreamAlias("ArticleCode08")
	private String articleCode08 ;
	
	/** 属性ArticleCode09 */
	@XStreamAlias("ArticleCode09")
	private String articleCode09 ;
	
	/** 属性ArticleCode10 */
	@XStreamAlias("ArticleCode10")
	private String articleCode10 ;
	
	/** 属性ArticleCode11 */
	@XStreamAlias("ArticleCode11")
	private String articleCode11 ;
	
	/** 属性ArticleCode12 */
	@XStreamAlias("ArticleCode12")
	private String articleCode12 ;
	
	/** 属性ArticleCode13 */
	@XStreamAlias("ArticleCode13")
	private String articleCode13 ;
	
	/** 属性ArticleCode14 */
	@XStreamAlias("ArticleCode14")
	private String articleCode14 ;
	
	/** 属性ArticleCode15 */
	@XStreamAlias("ArticleCode15")
	private String articleCode15 ;
	
	/** 属性ArticleCode16 */
	@XStreamAlias("ArticleCode16")
	private String articleCode16 ;
	
	/** 属性ArticleCode17 */
	@XStreamAlias("ArticleCode17")
	private String articleCode17 ;
	
	/** 属性ArticleCode18 */
	@XStreamAlias("ArticleCode18")
	private String articleCode18 ;
	
	/** 属性ArticleCode19 */
	@XStreamAlias("ArticleCode19")
	private String articleCode19 ;
	
	/** 属性ArticleCode20 */
	@XStreamAlias("ArticleCode20")
	private String articleCode20 ;
	
	/** 属性ArticleCode21 */
	@XStreamAlias("ArticleCode21")
	private String articleCode21 ;
	
	/** 属性ArticleCode22 */
	@XStreamAlias("ArticleCode22")
	private String articleCode22 ;
	
	/** 属性ArticleCode23 */
	@XStreamAlias("ArticleCode23")
	private String articleCode23 ;
	
	/** 属性ArticleCode24 */
	@XStreamAlias("ArticleCode24")
	private String articleCode24 ;
	
	/** 属性ArticleCode25 */
	@XStreamAlias("ArticleCode25")
	private String articleCode25 ;
	
	/** 属性ArticleCode26 */
	@XStreamAlias("ArticleCode26")
	private String articleCode26 ;
	
	/** 属性ArticleCode27 */
	@XStreamAlias("ArticleCode27")
	private String articleCode27 ;
	
	/** 属性ArticleCode28 */
	@XStreamAlias("ArticleCode28")
	private String articleCode28 ;
	
	/** 属性ArticleCode29 */
	@XStreamAlias("ArticleCode29")
	private String articleCode29 ;
	
	/** 属性ArticleCode30 */
	@XStreamAlias("ArticleCode30")
	private String articleCode30 ;
	
	
	public String getPayBillNo() {
		return payBillNo;
	}
	public void setPayBillNo(String payBillNo) {
		this.payBillNo = payBillNo;
	}
	public String getArticleCode01() {
		return articleCode01;
	}
	public void setArticleCode01(String articleCode01) {
		this.articleCode01 = articleCode01;
	}
	public String getArticleCode02() {
		return articleCode02;
	}
	public void setArticleCode02(String articleCode02) {
		this.articleCode02 = articleCode02;
	}
	public String getArticleCode03() {
		return articleCode03;
	}
	public void setArticleCode03(String articleCode03) {
		this.articleCode03 = articleCode03;
	}
	public String getArticleCode04() {
		return articleCode04;
	}
	public void setArticleCode04(String articleCode04) {
		this.articleCode04 = articleCode04;
	}
	public String getArticleCode05() {
		return articleCode05;
	}
	public void setArticleCode05(String articleCode05) {
		this.articleCode05 = articleCode05;
	}
	public String getArticleCode06() {
		return articleCode06;
	}
	public void setArticleCode06(String articleCode06) {
		this.articleCode06 = articleCode06;
	}
	public String getArticleCode07() {
		return articleCode07;
	}
	public void setArticleCode07(String articleCode07) {
		this.articleCode07 = articleCode07;
	}
	public String getArticleCode08() {
		return articleCode08;
	}
	public void setArticleCode08(String articleCode08) {
		this.articleCode08 = articleCode08;
	}
	public String getArticleCode09() {
		return articleCode09;
	}
	public void setArticleCode09(String articleCode09) {
		this.articleCode09 = articleCode09;
	}
	public String getArticleCode10() {
		return articleCode10;
	}
	public void setArticleCode10(String articleCode10) {
		this.articleCode10 = articleCode10;
	}
	public String getArticleCode11() {
		return articleCode11;
	}
	public void setArticleCode11(String articleCode11) {
		this.articleCode11 = articleCode11;
	}
	public String getArticleCode12() {
		return articleCode12;
	}
	public void setArticleCode12(String articleCode12) {
		this.articleCode12 = articleCode12;
	}
	public String getArticleCode13() {
		return articleCode13;
	}
	public void setArticleCode13(String articleCode13) {
		this.articleCode13 = articleCode13;
	}
	public String getArticleCode14() {
		return articleCode14;
	}
	public void setArticleCode14(String articleCode14) {
		this.articleCode14 = articleCode14;
	}
	public String getArticleCode15() {
		return articleCode15;
	}
	public void setArticleCode15(String articleCode15) {
		this.articleCode15 = articleCode15;
	}
	public String getArticleCode16() {
		return articleCode16;
	}
	public void setArticleCode16(String articleCode16) {
		this.articleCode16 = articleCode16;
	}
	public String getArticleCode17() {
		return articleCode17;
	}
	public void setArticleCode17(String articleCode17) {
		this.articleCode17 = articleCode17;
	}
	public String getArticleCode18() {
		return articleCode18;
	}
	public void setArticleCode18(String articleCode18) {
		this.articleCode18 = articleCode18;
	}
	public String getArticleCode19() {
		return articleCode19;
	}
	public void setArticleCode19(String articleCode19) {
		this.articleCode19 = articleCode19;
	}
	public String getArticleCode20() {
		return articleCode20;
	}
	public void setArticleCode20(String articleCode20) {
		this.articleCode20 = articleCode20;
	}
	public String getArticleCode21() {
		return articleCode21;
	}
	public void setArticleCode21(String articleCode21) {
		this.articleCode21 = articleCode21;
	}
	public String getArticleCode22() {
		return articleCode22;
	}
	public void setArticleCode22(String articleCode22) {
		this.articleCode22 = articleCode22;
	}
	public String getArticleCode23() {
		return articleCode23;
	}
	public void setArticleCode23(String articleCode23) {
		this.articleCode23 = articleCode23;
	}
	public String getArticleCode24() {
		return articleCode24;
	}
	public void setArticleCode24(String articleCode24) {
		this.articleCode24 = articleCode24;
	}
	public String getArticleCode25() {
		return articleCode25;
	}
	public void setArticleCode25(String articleCode25) {
		this.articleCode25 = articleCode25;
	}
	public String getArticleCode26() {
		return articleCode26;
	}
	public void setArticleCode26(String articleCode26) {
		this.articleCode26 = articleCode26;
	}
	public String getArticleCode27() {
		return articleCode27;
	}
	public void setArticleCode27(String articleCode27) {
		this.articleCode27 = articleCode27;
	}
	public String getArticleCode28() {
		return articleCode28;
	}
	public void setArticleCode28(String articleCode28) {
		this.articleCode28 = articleCode28;
	}
	public String getArticleCode29() {
		return articleCode29;
	}
	public void setArticleCode29(String articleCode29) {
		this.articleCode29 = articleCode29;
	}
	public String getArticleCode30() {
		return articleCode30;
	}
	public void setArticleCode30(String articleCode30) {
		this.articleCode30 = articleCode30;
	}
	public String getComcode() {
		return Comcode;
	}
	public void setComcode(String comcode) {
		Comcode = comcode;
	}
	public String getCertino() {
		return certino;
	}
	public void setCertino(String certino) {
		this.certino = certino;
	}
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getPayreason() {
		return payreason;
	}
	public void setPayreason(String payreason) {
		this.payreason = payreason;
	}
	public String getFlag1() {
		return flag1;
	}
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}
	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	public String getFlag3() {
		return flag3;
	}
	public void setFlag3(String flag3) {
		this.flag3 = flag3;
	}
	public String getFlag4() {
		return flag4;
	}
	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}
	public String getFlag5() {
		return flag5;
	}
	public void setFlag5(String flag5) {
		this.flag5 = flag5;
	}
	public String getCertitype() {
		return certitype;
	}
	public void setCertitype(String certitype) {
		this.certitype = certitype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPayno() {
		return payno;
	}
	public void setPayno(String payno) {
		this.payno = payno;
	}
}
