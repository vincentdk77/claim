<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLbillPayDtoBase" %>
<%@page import="com.sinosoft.sysframework.common.util.ParamUtils" %>
<%@page import="com.sinosoft.claim.util.ExportExcel" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%
	String strUserCode = request.getParameter("userCode");
	String[] registNo = request.getParameterValues("registNo");
	String[] compensateNo = request.getParameterValues("compensateNo");
	String[] policyNo = request.getParameterValues("policyNo");
	String[] serialNo = request.getParameterValues("serialNo");
	String[] payName = request.getParameterValues("payName");
	String[] identifyNumber = request.getParameterValues("identifyNumber");
	String[] provinceName = request.getParameterValues("provinceName");
	String[] cityName = request.getParameterValues("cityName");
	String[] accountType = request.getParameterValues("accountType");
	String[] accountFlag = request.getParameterValues("accountFlag");
	String[] bankAccount = request.getParameterValues("bankAccount");
	String[] bankName = request.getParameterValues("bankName");
	String[] openBank = request.getParameterValues("openBank");
	String[] routeNum = request.getParameterValues("routeNum");
	String[] payAmount = request.getParameterValues("payAmount");
	String[] mobilePhone = request.getParameterValues("mobilePhone");
	String[] address = request.getParameterValues("address");
	String[] payWay = request.getParameterValues("payWay");
	String[] payReason = request.getParameterValues("payReason");
	String[] payPurpose = request.getParameterValues("payPurpose");
	PrpLbillPayDtoBase prpLbillPayDtoBase = null;
	ArrayList prplbillpayList = new ArrayList();
	/*
	if(registNo!=null&&registNo.length>0){
		for(int i=0;i<registNo.length;i++){
			prpLbillPayDtoBase = new PrpLbillPayDtoBase();
			prpLbillPayDtoBase.setRegistNo(registNo[i]);
			prpLbillPayDtoBase.setStrSerialNo(serialNo[i]);
			prpLbillPayDtoBase.setReceiverfullName(payName[i]);
			prpLbillPayDtoBase.setCertifNo(identifyNumber[i]);
			prpLbillPayDtoBase.setBankType(bankName[i]);
			prpLbillPayDtoBase.setBank(openBank[i]);
			prpLbillPayDtoBase.setAccountType(accountType[i]);
			prpLbillPayDtoBase.setAccountFlag(accountFlag[i]);
			prpLbillPayDtoBase.setCertifType("t01");
			prpLbillPayDtoBase.setBankAccount(bankAccount[i]);
			prpLbillPayDtoBase.setPayAmount(Double.parseDouble(payAmount[i]));
			prpLbillPayDtoBase.setProvinceName(provinceName[i]);
			prpLbillPayDtoBase.setCityName(cityName[i]);
			prpLbillPayDtoBase.setMobilePhone(mobilePhone[i]);
			prpLbillPayDtoBase.setAddress(address[i]);
			prpLbillPayDtoBase.setStrPayAmount(payAmount[i]);
			prpLbillPayDtoBase.setPayWay(payWay[i]);
			prpLbillPayDtoBase.setPayReason(payReason[i]);
			prpLbillPayDtoBase.setPayPurpose(payPurpose[i]);
			prplbillpayList.add(prpLbillPayDtoBase);
		}
	}
	*/
	HashMap titleHash = new HashMap();
	HashMap fieldHash = new HashMap();
	String dateTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).toString();
	System.err.println(dateTime);
	String expDate = dateTime.substring(0,4)+"��"+dateTime.substring(5,7)+"��"+dateTime.substring(8,10)+"��"+dateTime.substring(11,13)+"ʱ"+dateTime.substring(14,16)+"��"+dateTime.substring(17,19)+"��";
	String excelFileName = "";
	excelFileName = "����"+strUserCode+"_"+expDate+"_�˻���Ϣ�嵥.xls";
	System.err.println(excelFileName);
	titleHash.put("0", "���");
	titleHash.put("1", "����");
	titleHash.put("2", "���֤��");
	titleHash.put("3", "�ֻ�����");
	titleHash.put("4", "ʡ������(��:����ʡ)*");
	titleHash.put("5", "��������(��:�Ϸ���)*");
	titleHash.put("6", "�˺����ԣ�1�����ˡ�2����λ��*");
	titleHash.put("7", "���д���*");
	titleHash.put("8", "�����˺�*");
	titleHash.put("9", "�˺����ͣ�00:���п���01�����ۡ�02�����ÿ���03���Թ��˻���*");
	titleHash.put("10", "��������*");
	titleHash.put("11", "��ϵ��ַ");
	titleHash.put("12", "���");
	titleHash.put("13", "֧����ʽ��1��������֧����*");
	titleHash.put("14", "֧��ԭ��");
	titleHash.put("15", "��;˵��");
	titleHash.put("16", "���к� *");

	fieldHash.put("0", "StrSerialNo");
	fieldHash.put("1", "ReceiverfullName");
	fieldHash.put("2", "CertifNo");
	fieldHash.put("3", "MobilePhone");
	fieldHash.put("4", "ProvinceName");
	fieldHash.put("5", "CityName");
	fieldHash.put("6", "AccountType");
	fieldHash.put("7", "BankType");
	fieldHash.put("8", "BankAccount");
	fieldHash.put("9", "AccountFlag");
	fieldHash.put("10", "Bank");
	fieldHash.put("11", "Address");
	fieldHash.put("12", "StrPayAmount");
	fieldHash.put("13", "PayWay");
	fieldHash.put("14", "PayReason");
	fieldHash.put("15", "PayPurpose");
	fieldHash.put("16", "RouteNum");
	
	ExportExcel.ExportByPOI(response, titleHash, fieldHash,
			prplbillpayList, excelFileName,registNo[0].substring(1,5),registNo[0],compensateNo[0],strUserCode);
%>