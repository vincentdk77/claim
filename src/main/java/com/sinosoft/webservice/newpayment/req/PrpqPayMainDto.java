package com.sinosoft.webservice.newpayment.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PrpqPayMainDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@XStreamAlias("PayPurPose")
    private String payPurpose;
	/** ����visaserialno/���㵥�� */
	@XStreamAlias("VisaSerialNo")
	private String visaserialno ;
	/** ����channelcode/�������룺ҽ��ͨĬ��Ϊ��neusoftyb �п���Ϊsinosoft */
	@XStreamAlias("ChannelCode")
	private String channelcode ;
	/** ����receiverfullname/�տ��� */
	@XStreamAlias("ReceiverFullName")
	private String receiverfullname ;
	/** ����bankaccount/���Ż��˺� */
	@XStreamAlias("BankAccount")
	private String bankaccount ;
	/** ����banktype/�������� */
	@XStreamAlias("BankType")
	private String banktype ;
	/** ����bank/�������� */
	@XStreamAlias("Bank")
	private String bank ;
	/** ����bankprov/����������ʡ�� */
	@XStreamAlias("BankProv")
	private String bankprov ;
	/** ����bankcity/���������ڳ��� */
	@XStreamAlias("BankCity")
	private String bankcity ;
	/** ����accounttype/�˻����� 1���� 2��λ */
	@XStreamAlias("AccountType")
	private String accounttype ;
	/** ����operatorcode/����Ա���� */
	@XStreamAlias("OperateCode")
	private String operatorcode ;
	/** ����operatename/ */
	@XStreamAlias("OperateName")
	private String operatename ;
	/** ����operatedate/ */
	@XStreamAlias("OperateDate")
	private String operatedate ;
	/** ����comcode/�������Ż������� */
	@XStreamAlias("ComCode")
	private String comcode ;
	/** ����uppercomcode/֧�������ϼ����� */
	@XStreamAlias("UpperComCode")
	private String uppercomcode ;
	/** ����accountflag/�˺����� 00���п� 01���� 02���ÿ� 03�Թ��˻� */
	@XStreamAlias("AccountFlag")
	private String accountflag ;
	/** ����routenum/֧���к� */
	@XStreamAlias("RouteNum")
	private String routenum ;
	/** ����certifytype/֤�����ͣ�01�� �������֤ 02�����񻧿ڱ� 03����ʻ֤ 04������֤ 05��ʿ��֤ 07���й����� 08���쳣���֤ 41���۰�ͨ��֤ 42��̨��ͨ��֤ 43������֤ 51��������� 52������֤ 53������֤�� 71����֯��������֤ 72��˰��Ǽ�֤ 73��Ӫҵִ�� 99������֤�� */
	@XStreamAlias("CertifType")
	private String certifytype ;
	/** ����certifyno/֤������ */
	@XStreamAlias("CertifNo")
	private String certifyno ;
	/** ����receivertype/��������ͣ�t01���������� t02���鿱ֱ������ t03������������λ t04���鿱��Ա t05������Ժ t06���������� t07�����ά�޵�λ t08��������� t09����Ԯ���� t10���������� t11����ʦ���� t12���������� t13��������λ t14���ܺ���Ա t15������ҽԺ t16���������� t17���������� t18���ٲû��� */
	@XStreamAlias("ReceiverTypeOther")
	private String receivertype ;
	/** ����mobilephone/�ֻ����� */
	@XStreamAlias("MobilePhone")
	private String mobilephone ;
	/** ����familyphone/��ͥ���� */
	@XStreamAlias("FamilyPhone")
	private String familyphone ;
	/** ����officephone/�칫�绰 */
	@XStreamAlias("OfficePhone")
	private String officephone ;
	/** ����address/��ϸ��ַ */
	@XStreamAlias("Address")
	private String address ;
	/** ����qqnumber/qq���� */
	@XStreamAlias("QQNumber")
	private String qqnumber ;
	/** ����email/�����ʼ� */
	@XStreamAlias("EMail")
	private String email ;
	/** ����unitlink/��λ��ϵ�� */
	@XStreamAlias("UnitLink")
	private String unitlink ;
	/** ����postcode/�������� */
	@XStreamAlias("PostCode")
	private String postcode ;
	/** ����urgenttype/�����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h */
	@XStreamAlias("UrgentType")
	private String urgenttype ;
	/** ����payamount/֧����� */
	@XStreamAlias("PayAmount")
	private String payamount ;
	/** ����thridpayflag/������֧����ʶ:1 ��0 �� */
	@XStreamAlias("ThridPayFlag")
	private String thridpayflag ;
	/** ����businessno1/��չ�ֶ�1 */
	@XStreamAlias("Flag1")
	private String businessno1 ;
	@XStreamAlias("Flag2")
	/** ����businessno2/��չ�ֶ�2 */
	private String businessno2 ;
	/** ����businessno3/��չ�ֶ�3 */
	@XStreamAlias("Flag3")
	private String businessno3 ;
	/** ����businessno4/��չ�ֶ�4 */
	@XStreamAlias("Flag4")
	private String businessno4 ;
	/** ����businessno5/��չ�ֶ�5 */
	@XStreamAlias("Flag5")
	private String businessno5 ;
	
	
	/** ����flag/֧��״̬��0���ύ 1����� 2��˲�ͨ�� 3 ֧�����Ĵ����� 4 ֧�������˻� 5 �Ѵ�������
	6������ͨ�������� 7�ѷ������� ��; 8���д�� 9֧���ɹ� mĬ�ϳɹ� n�����˻�֧������ */
	@XStreamAlias("Flag")
	private String flag ;
	
	/** ���Խ������� P-���� C-��� S-������ */
	@XStreamAlias("SettleType")
	private String settleType ;
	

	/**
	 * ����receiverfullname/�տ��˵�getter����
	 */
	public String getReceiverfullname() {
		return receiverfullname;
	}
	/**
	 * ����receiverfullname/�տ��˵�setter����
	 */
	public void setReceiverfullname(String receiverfullname) {
		this.receiverfullname = receiverfullname;
	} 
	/**
	 * ����bankaccount/���Ż��˺ŵ�getter����
	 */
	public String getBankaccount() {
		return bankaccount;
	}
	/**
	 * ����bankaccount/���Ż��˺ŵ�setter����
	 */
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	} 
	/**
	 * ����banktype/�������͵�getter����
	 */
	public String getBanktype() {
		return banktype;
	}
	/**
	 * ����banktype/�������͵�setter����
	 */
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	} 
	/**
	 * ����bank/�������е�getter����
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * ����bank/�������е�setter����
	 */
	public void setBank(String bank) {
		this.bank = bank;
	} 
	/**
	 * ����bankprov/����������ʡ�ݵ�getter����
	 */
	public String getBankprov() {
		return bankprov;
	}
	/**
	 * ����bankprov/����������ʡ�ݵ�setter����
	 */
	public void setBankprov(String bankprov) {
		this.bankprov = bankprov;
	} 
	/**
	 * ����bankcity/���������ڳ��е�getter����
	 */
	public String getBankcity() {
		return bankcity;
	}
	/**
	 * ����bankcity/���������ڳ��е�setter����
	 */
	public void setBankcity(String bankcity) {
		this.bankcity = bankcity;
	} 
	/**
	 * ����accounttype/�˻����� 1���� 2��λ��getter����
	 */
	public String getAccounttype() {
		return accounttype;
	}
	/**
	 * ����accounttype/�˻����� 1���� 2��λ��setter����
	 */
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	} 
	/**
	 * ����operatorcode/����Ա�����getter����
	 */
	public String getOperatorcode() {
		return operatorcode;
	}
	/**
	 * ����operatorcode/����Ա�����setter����
	 */
	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	} 
	/**
	 * ����operatename/��getter����
	 */
	public String getOperatename() {
		return operatename;
	}
	/**
	 * ����operatename/��setter����
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
	 * ����comcode/�������Ż��������getter����
	 */
	public String getComcode() {
		return comcode;
	}
	/**
	 * ����comcode/�������Ż��������setter����
	 */
	public void setComcode(String comcode) {
		this.comcode = comcode;
	} 
	/**
	 * ����uppercomcode/֧�������ϼ�������getter����
	 */
	public String getUppercomcode() {
		return uppercomcode;
	}
	/**
	 * ����uppercomcode/֧�������ϼ�������setter����
	 */
	public void setUppercomcode(String uppercomcode) {
		this.uppercomcode = uppercomcode;
	} 
	/**
	 * ����accountflag/�˺����� 00���п� 01���� 02���ÿ� 03�Թ��˻���getter����
	 */
	public String getAccountflag() {
		return accountflag;
	}
	/**
	 * ����accountflag/�˺����� 00���п� 01���� 02���ÿ� 03�Թ��˻���setter����
	 */
	public void setAccountflag(String accountflag) {
		this.accountflag = accountflag;
	} 
	/**
	 * ����routenum/֧���кŵ�getter����
	 */
	public String getRoutenum() {
		return routenum;
	}
	/**
	 * ����routenum/֧���кŵ�setter����
	 */
	public void setRoutenum(String routenum) {
		this.routenum = routenum;
	} 
	/**
	 * ����certifytype/֤�����ͣ�01�� �������֤ 02�����񻧿ڱ� 03����ʻ֤ 04������֤ 05��ʿ��֤ 07���й����� 08���쳣���֤ 41���۰�ͨ��֤ 42��̨��ͨ��֤ 43������֤ 51��������� 52������֤ 53������֤�� 71����֯��������֤ 72��˰��Ǽ�֤ 73��Ӫҵִ�� 99������֤����getter����
	 */
	public String getCertifytype() {
		return certifytype;
	}
	/**
	 * ����certifytype/֤�����ͣ�01�� �������֤ 02�����񻧿ڱ� 03����ʻ֤ 04������֤ 05��ʿ��֤ 07���й����� 08���쳣���֤ 41���۰�ͨ��֤ 42��̨��ͨ��֤ 43������֤ 51��������� 52������֤ 53������֤�� 71����֯��������֤ 72��˰��Ǽ�֤ 73��Ӫҵִ�� 99������֤����setter����
	 */
	public void setCertifytype(String certifytype) {
		this.certifytype = certifytype;
	} 
	/**
	 * ����certifyno/֤�������getter����
	 */
	public String getCertifyno() {
		return certifyno;
	}
	/**
	 * ����certifyno/֤�������setter����
	 */
	public void setCertifyno(String certifyno) {
		this.certifyno = certifyno;
	} 
	/**
	 * ����receivertype/��������ͣ�t01���������� t02���鿱ֱ������ t03������������λ t04���鿱��Ա t05������Ժ t06���������� t07�����ά�޵�λ t08��������� t09����Ԯ���� t10���������� t11����ʦ���� t12���������� t13��������λ t14���ܺ���Ա t15������ҽԺ t16���������� t17���������� t18���ٲû�����getter����
	 */
	public String getReceivertype() {
		return receivertype;
	}
	/**
	 * ����receivertype/��������ͣ�t01���������� t02���鿱ֱ������ t03������������λ t04���鿱��Ա t05������Ժ t06���������� t07�����ά�޵�λ t08��������� t09����Ԯ���� t10���������� t11����ʦ���� t12���������� t13��������λ t14���ܺ���Ա t15������ҽԺ t16���������� t17���������� t18���ٲû�����setter����
	 */
	public void setReceivertype(String receivertype) {
		this.receivertype = receivertype;
	} 
	/**
	 * ����mobilephone/�ֻ������getter����
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * ����mobilephone/�ֻ������setter����
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	} 
	/**
	 * ����familyphone/��ͥ�����getter����
	 */
	public String getFamilyphone() {
		return familyphone;
	}
	/**
	 * ����familyphone/��ͥ�����setter����
	 */
	public void setFamilyphone(String familyphone) {
		this.familyphone = familyphone;
	} 
	/**
	 * ����officephone/�칫�绰��getter����
	 */
	public String getOfficephone() {
		return officephone;
	}
	/**
	 * ����officephone/�칫�绰��setter����
	 */
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	} 
	/**
	 * ����address/��ϸ��ַ��getter����
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * ����address/��ϸ��ַ��setter����
	 */
	public void setAddress(String address) {
		this.address = address;
	} 
	/**
	 * ����qqnumber/qq�����getter����
	 */
	public String getQqnumber() {
		return qqnumber;
	}
	/**
	 * ����qqnumber/qq�����setter����
	 */
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	} 
	/**
	 * ����email/�����ʼ���getter����
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * ����email/�����ʼ���setter����
	 */
	public void setEmail(String email) {
		this.email = email;
	} 
	/**
	 * ����unitlink/��λ��ϵ�˵�getter����
	 */
	public String getUnitlink() {
		return unitlink;
	}
	/**
	 * ����unitlink/��λ��ϵ�˵�setter����
	 */
	public void setUnitlink(String unitlink) {
		this.unitlink = unitlink;
	} 
	/**
	 * ����postcode/���������getter����
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * ����postcode/���������setter����
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	} 
	/**
	 * ����urgenttype/�����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h��getter����
	 */
	public String getUrgenttype() {
		return urgenttype;
	}
	/**
	 * ����urgenttype/�����̶ȣ�30m;1h;2h;3h;4h;8h;24h;48h��setter����
	 */
	public void setUrgenttype(String urgenttype) {
		this.urgenttype = urgenttype;
	} 
	
	public String getPayamount() {
		return payamount;
	}

	/**
	 * ����thridpayflag/������֧����ʶ:1 ��0 ���getter����
	 */
	public String getThridpayflag() {
		return thridpayflag;
	}
	/**
	 * ����thridpayflag/������֧����ʶ:1 ��0 ���setter����
	 */
	public void setThridpayflag(String thridpayflag) {
		this.thridpayflag = thridpayflag;
	} 
	/**
	 * ����businessno1/��չ�ֶ�1��getter����
	 */
	public String getBusinessno1() {
		return businessno1;
	}
	/**
	 * ����businessno1/��չ�ֶ�1��setter����
	 */
	public void setBusinessno1(String businessno1) {
		this.businessno1 = businessno1;
	} 
	/**
	 * ����businessno2/��չ�ֶ�2��getter����
	 */
	public String getBusinessno2() {
		return businessno2;
	}
	/**
	 * ����businessno2/��չ�ֶ�2��setter����
	 */
	public void setBusinessno2(String businessno2) {
		this.businessno2 = businessno2;
	} 
	/**
	 * ����businessno3/��չ�ֶ�3��getter����
	 */
	public String getBusinessno3() {
		return businessno3;
	}
	/**
	 * ����businessno3/��չ�ֶ�3��setter����
	 */
	public void setBusinessno3(String businessno3) {
		this.businessno3 = businessno3;
	} 
	/**
	 * ����businessno4/��չ�ֶ�4��getter����
	 */
	public String getBusinessno4() {
		return businessno4;
	}
	/**
	 * ����businessno4/��չ�ֶ�4��setter����
	 */
	public void setBusinessno4(String businessno4) {
		this.businessno4 = businessno4;
	} 
	/**
	 * ����businessno5/��չ�ֶ�5��getter����
	 */
	public String getBusinessno5() {
		return businessno5;
	}
	/**
	 * ����businessno5/��չ�ֶ�5��setter����
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
