package com.sinosoft.webservice.newpayment.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqPayMainDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@XStreamAlias("PayPurPose")
    private String payPurpose;
	/** 属性visaserialno/结算单号 */
	@XStreamAlias("VisaSerialNo")
	private String visaserialno ;
	/** 属性channelcode/渠道代码：医保通默认为：neusoftyb 中科软为sinosoft */
	@XStreamAlias("ChannelCode")
	private String channelcode ;
	/** 属性receiverfullname/收款人 */
	@XStreamAlias("ReceiverFullName")
	private String receiverfullname ;
	/** 属性bankaccount/卡号或账号 */
	@XStreamAlias("BankAccount")
	private String bankaccount ;
	/** 属性banktype/银行类型 */
	@XStreamAlias("BankType")
	private String banktype ;
	/** 属性bank/开户银行 */
	@XStreamAlias("Bank")
	private String bank ;
	/** 属性bankprov/开户行所在省份 */
	@XStreamAlias("BankProv")
	private String bankprov ;
	/** 属性bankcity/开户行所在城市 */
	@XStreamAlias("BankCity")
	private String bankcity ;
	/** 属性accounttype/账户属性 1个人 2单位 */
	@XStreamAlias("AccountType")
	private String accounttype ;
	/** 属性operatorcode/操作员代码 */
	@XStreamAlias("OperateCode")
	private String operatorcode ;
	/** 属性operatename/ */
	@XStreamAlias("OperateName")
	private String operatename ;
	/** 属性operatedate/ */
	@XStreamAlias("OperateDate")
	private String operatedate ;
	/** 属性comcode/操作部门机构代码 */
	@XStreamAlias("ComCode")
	private String comcode ;
	/** 属性uppercomcode/支付申请上级机构 */
	@XStreamAlias("UpperComCode")
	private String uppercomcode ;
	/** 属性accountflag/账号类型 00银行卡 01存折 02信用卡 03对公账户 */
	@XStreamAlias("AccountFlag")
	private String accountflag ;
	/** 属性routenum/支付行号 */
	@XStreamAlias("RouteNum")
	private String routenum ;
	/** 属性certifytype/证件类型：01： 居民身份证 02：居民户口薄 03：驾驶证 04：军官证 05：士兵证 07：中国护照 08：异常身份证 41：港澳通行证 42：台湾通行证 43：回乡证 51：外国护照 52：旅行证 53：居留证件 71：组织机构代码证 72：税务登记证 73：营业执照 99：其他证件 */
	@XStreamAlias("CertifType")
	private String certifytype ;
	/** 属性certifyno/证件号码 */
	@XStreamAlias("CertifNo")
	private String certifyno ;
	/** 属性receivertype/领款人类型：t01：被保险人 t02：查勘直赔中心 t03：玻璃更换单位 t04：查勘人员 t05：人民法院 t06：公估机构 t07：配件维修单位 t08：调查机构 t09：救援机构 t10：鉴定机构 t11：律师部门 t12：其他个人 t13：其他单位 t14：受害人员 t15：救治医院 t16：民政部门 t17：交警部门 t18：仲裁机构 */
	@XStreamAlias("ReceiverTypeOther")
	private String receivertype ;
	/** 属性mobilephone/手机号码 */
	@XStreamAlias("MobilePhone")
	private String mobilephone ;
	/** 属性familyphone/家庭号码 */
	@XStreamAlias("FamilyPhone")
	private String familyphone ;
	/** 属性officephone/办公电话 */
	@XStreamAlias("OfficePhone")
	private String officephone ;
	/** 属性address/详细地址 */
	@XStreamAlias("Address")
	private String address ;
	/** 属性qqnumber/qq号码 */
	@XStreamAlias("QQNumber")
	private String qqnumber ;
	/** 属性email/电子邮件 */
	@XStreamAlias("EMail")
	private String email ;
	/** 属性unitlink/单位联系人 */
	@XStreamAlias("UnitLink")
	private String unitlink ;
	/** 属性postcode/邮政编码 */
	@XStreamAlias("PostCode")
	private String postcode ;
	/** 属性urgenttype/紧急程度：30m;1h;2h;3h;4h;8h;24h;48h */
	@XStreamAlias("UrgentType")
	private String urgenttype ;
	/** 属性payamount/支付金额 */
	@XStreamAlias("PayAmount")
	private String payamount ;
	/** 属性thridpayflag/第三方支付标识:1 是0 否 */
	@XStreamAlias("ThridPayFlag")
	private String thridpayflag ;
	/** 属性businessno1/扩展字段1 */
	@XStreamAlias("Flag1")
	private String businessno1 ;
	@XStreamAlias("Flag2")
	/** 属性businessno2/扩展字段2 */
	private String businessno2 ;
	/** 属性businessno3/扩展字段3 */
	@XStreamAlias("Flag3")
	private String businessno3 ;
	/** 属性businessno4/扩展字段4 */
	@XStreamAlias("Flag4")
	private String businessno4 ;
	/** 属性businessno5/扩展字段5 */
	@XStreamAlias("Flag5")
	private String businessno5 ;
	
	
	/** 属性flag/支付状态：0待提交 1待审核 2审核不通过 3 支付中心待处理 4 支付中心退回 5 已打包待审核
	6打包审核通过待发送 7已发往银行 在途 8银行打回 9支付成功 m默认成功 n银行退回支付中心 */
	@XStreamAlias("Flag")
	private String flag ;
	
	/** 属性结算类型 P-保费 C-赔款 S-手续费 */
	@XStreamAlias("SettleType")
	private String settleType ;
	

	/**
	 * 属性receiverfullname/收款人的getter方法
	 */
	public String getReceiverfullname() {
		return receiverfullname;
	}
	/**
	 * 属性receiverfullname/收款人的setter方法
	 */
	public void setReceiverfullname(String receiverfullname) {
		this.receiverfullname = receiverfullname;
	} 
	/**
	 * 属性bankaccount/卡号或账号的getter方法
	 */
	public String getBankaccount() {
		return bankaccount;
	}
	/**
	 * 属性bankaccount/卡号或账号的setter方法
	 */
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	} 
	/**
	 * 属性banktype/银行类型的getter方法
	 */
	public String getBanktype() {
		return banktype;
	}
	/**
	 * 属性banktype/银行类型的setter方法
	 */
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	} 
	/**
	 * 属性bank/开户银行的getter方法
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 属性bank/开户银行的setter方法
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 
	/**
	 * 属性bankprov/开户行所在省份的getter方法
	 */
	public String getBankprov() {
		return bankprov;
	}
	/**
	 * 属性bankprov/开户行所在省份的setter方法
	 */
	public void setBankprov(String bankprov) {
		this.bankprov = bankprov;
	} 
	/**
	 * 属性bankcity/开户行所在城市的getter方法
	 */
	public String getBankcity() {
		return bankcity;
	}
	/**
	 * 属性bankcity/开户行所在城市的setter方法
	 */
	public void setBankcity(String bankcity) {
		this.bankcity = bankcity;
	} 
	/**
	 * 属性accounttype/账户属性 1个人 2单位的getter方法
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * 属性accounttype/账户属性 1个人 2单位的setter方法
	 */
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	} 
	/**
	 * 属性operatorcode/操作员代码的getter方法
	 */
	public String getOperatorcode() {
		return operatorcode;
	}
	/**
	 * 属性operatorcode/操作员代码的setter方法
	 */
	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	} 
	/**
	 * 属性operatename/的getter方法
	 */
	public String getOperatename() {
		return operatename;
	}
	/**
	 * 属性operatename/的setter方法
	 */
	public void setOperatename(String operatename) {
		this.operatename = operatename;
	} 
	public String getOperatedate() {
		return operatedate;
	}
	public void setOperatedate(String operatedate) {
		this.operatedate = operatedate;
	}
	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}
	/**
	 * 属性comcode/操作部门机构代码的getter方法
	 */
	public String getComcode() {
		return comcode;
	}
	/**
	 * 属性comcode/操作部门机构代码的setter方法
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	} 
	/**
	 * 属性uppercomcode/支付申请上级机构的getter方法
	 */
	public String getUppercomcode() {
		return uppercomcode;
	}
	/**
	 * 属性uppercomcode/支付申请上级机构的setter方法
	 */
	public void setUppercomcode(String uppercomcode) {
		this.uppercomcode = uppercomcode;
	} 
	/**
	 * 属性accountflag/账号类型 00银行卡 01存折 02信用卡 03对公账户的getter方法
	 */
	public String getAccountflag() {
		return accountflag;
	}
	/**
	 * 属性accountflag/账号类型 00银行卡 01存折 02信用卡 03对公账户的setter方法
	 */
	public void setAccountflag(String accountflag) {
		this.accountflag = accountflag;
	} 
	/**
	 * 属性routenum/支付行号的getter方法
	 */
	public String getRoutenum() {
		return routenum;
	}
	/**
	 * 属性routenum/支付行号的setter方法
	 */
	public void setRoutenum(String routenum) {
		this.routenum = routenum;
	} 
	/**
	 * 属性certifytype/证件类型：01： 居民身份证 02：居民户口薄 03：驾驶证 04：军官证 05：士兵证 07：中国护照 08：异常身份证 41：港澳通行证 42：台湾通行证 43：回乡证 51：外国护照 52：旅行证 53：居留证件 71：组织机构代码证 72：税务登记证 73：营业执照 99：其他证件的getter方法
	 */
	public String getCertifytype() {
		return certifytype;
	}
	/**
	 * 属性certifytype/证件类型：01： 居民身份证 02：居民户口薄 03：驾驶证 04：军官证 05：士兵证 07：中国护照 08：异常身份证 41：港澳通行证 42：台湾通行证 43：回乡证 51：外国护照 52：旅行证 53：居留证件 71：组织机构代码证 72：税务登记证 73：营业执照 99：其他证件的setter方法
	 */
	public void setCertifytype(String certifytype) {
		this.certifytype = certifytype;
	} 
	/**
	 * 属性certifyno/证件号码的getter方法
	 */
	public String getCertifyno() {
		return certifyno;
	}
	/**
	 * 属性certifyno/证件号码的setter方法
	 */
	public void setCertifyno(String certifyno) {
		this.certifyno = certifyno;
	} 
	/**
	 * 属性receivertype/领款人类型：t01：被保险人 t02：查勘直赔中心 t03：玻璃更换单位 t04：查勘人员 t05：人民法院 t06：公估机构 t07：配件维修单位 t08：调查机构 t09：救援机构 t10：鉴定机构 t11：律师部门 t12：其他个人 t13：其他单位 t14：受害人员 t15：救治医院 t16：民政部门 t17：交警部门 t18：仲裁机构的getter方法
	 */
	public String getReceivertype() {
		return receivertype;
	}
	/**
	 * 属性receivertype/领款人类型：t01：被保险人 t02：查勘直赔中心 t03：玻璃更换单位 t04：查勘人员 t05：人民法院 t06：公估机构 t07：配件维修单位 t08：调查机构 t09：救援机构 t10：鉴定机构 t11：律师部门 t12：其他个人 t13：其他单位 t14：受害人员 t15：救治医院 t16：民政部门 t17：交警部门 t18：仲裁机构的setter方法
	 */
	public void setReceivertype(String receivertype) {
		this.receivertype = receivertype;
	} 
	/**
	 * 属性mobilephone/手机号码的getter方法
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * 属性mobilephone/手机号码的setter方法
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	} 
	/**
	 * 属性familyphone/家庭号码的getter方法
	 */
	public String getFamilyphone() {
		return familyphone;
	}
	/**
	 * 属性familyphone/家庭号码的setter方法
	 */
	public void setFamilyphone(String familyphone) {
		this.familyphone = familyphone;
	} 
	/**
	 * 属性officephone/办公电话的getter方法
	 */
	public String getOfficephone() {
		return officephone;
	}
	/**
	 * 属性officephone/办公电话的setter方法
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	} 
	/**
	 * 属性address/详细地址的getter方法
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 属性address/详细地址的setter方法
	 */
	public void setAddress(String address) {
		this.address = address;
	} 
	/**
	 * 属性qqnumber/qq号码的getter方法
	 */
	public String getQqnumber() {
		return qqnumber;
	}
	/**
	 * 属性qqnumber/qq号码的setter方法
	 */
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	} 
	/**
	 * 属性email/电子邮件的getter方法
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 属性email/电子邮件的setter方法
	 */
	public void setEmail(String email) {
		this.email = email;
	} 
	/**
	 * 属性unitlink/单位联系人的getter方法
	 */
	public String getUnitlink() {
		return unitlink;
	}
	/**
	 * 属性unitlink/单位联系人的setter方法
	 */
	public void setUnitlink(String unitlink) {
		this.unitlink = unitlink;
	} 
	/**
	 * 属性postcode/邮政编码的getter方法
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * 属性postcode/邮政编码的setter方法
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	} 
	/**
	 * 属性urgenttype/紧急程度：30m;1h;2h;3h;4h;8h;24h;48h的getter方法
	 */
	public String getUrgenttype() {
		return urgenttype;
	}
	/**
	 * 属性urgenttype/紧急程度：30m;1h;2h;3h;4h;8h;24h;48h的setter方法
	 */
	public void setUrgenttype(String urgenttype) {
		this.urgenttype = urgenttype;
	} 
	
	public String getPayamount() {
		return payamount;
	}

	/**
	 * 属性thridpayflag/第三方支付标识:1 是0 否的getter方法
	 */
	public String getThridpayflag() {
		return thridpayflag;
	}
	/**
	 * 属性thridpayflag/第三方支付标识:1 是0 否的setter方法
	 */
	public void setThridpayflag(String thridpayflag) {
		this.thridpayflag = thridpayflag;
	} 
	/**
	 * 属性businessno1/扩展字段1的getter方法
	 */
	public String getBusinessno1() {
		return businessno1;
	}
	/**
	 * 属性businessno1/扩展字段1的setter方法
	 */
	public void setBusinessno1(String businessno1) {
		this.businessno1 = businessno1;
	} 
	/**
	 * 属性businessno2/扩展字段2的getter方法
	 */
	public String getBusinessno2() {
		return businessno2;
	}
	/**
	 * 属性businessno2/扩展字段2的setter方法
	 */
	public void setBusinessno2(String businessno2) {
		this.businessno2 = businessno2;
	} 
	/**
	 * 属性businessno3/扩展字段3的getter方法
	 */
	public String getBusinessno3() {
		return businessno3;
	}
	/**
	 * 属性businessno3/扩展字段3的setter方法
	 */
	public void setBusinessno3(String businessno3) {
		this.businessno3 = businessno3;
	} 
	/**
	 * 属性businessno4/扩展字段4的getter方法
	 */
	public String getBusinessno4() {
		return businessno4;
	}
	/**
	 * 属性businessno4/扩展字段4的setter方法
	 */
	public void setBusinessno4(String businessno4) {
		this.businessno4 = businessno4;
	} 
	/**
	 * 属性businessno5/扩展字段5的getter方法
	 */
	public String getBusinessno5() {
		return businessno5;
	}
	/**
	 * 属性businessno5/扩展字段5的setter方法
	 */
	public void setBusinessno5(String businessno5) {
		this.businessno5 = businessno5;
	}

	public String getVisaserialno() {
		return visaserialno;
	}

	public void setVisaserialno(String visaserialno) {
		this.visaserialno = visaserialno;
	}

	public String getChannelcode() {
		return channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSettleType() {
		return settleType;
	}
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	public String getPayPurpose() {
		return payPurpose;
	}
	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	} 
	
	
}
