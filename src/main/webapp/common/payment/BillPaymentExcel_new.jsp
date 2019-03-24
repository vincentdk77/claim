<%@page import="java.util.ArrayList" %>
<%@page import="java.util.HashMap" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLbillPayDtoBase" %>
<%@page import="com.sinosoft.sysframework.common.util.ParamUtils" %>
<%@page import="com.sinosoft.claim.util.ExportExcel" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@page import="com.sinosoft.claim.ui.control.facade.BillPaymentExcel_new"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto"%>
<%
	String strUserCode = request.getParameter("userCode");
	String[] compensate = request.getParameterValues("compensateNo");
	String[] isChecked = request.getParameterValues("isChecked");
	BillPaymentExcel_new  iiBillPaymentExcel_new = new BillPaymentExcel_new();
	ArrayList prpLclaimBillManagerList = iiBillPaymentExcel_new.selectAll(compensate,isChecked);
	
	String[] registNo = request.getParameterValues("registNo");
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
	if(prpLclaimBillManagerList!=null&&prpLclaimBillManagerList.size()>0){
	PrpLclaimBillManagerDto prpLclaimBillManagerDto =  null;
		for(int i=0;i<prpLclaimBillManagerList.size();i++){
			prpLclaimBillManagerDto = (PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(i);
			prpLbillPayDtoBase = new PrpLbillPayDtoBase();
			prpLbillPayDtoBase.setStrSerialNo(String.valueOf(prpLclaimBillManagerDto.getSerialNo()+i+1));
			prpLbillPayDtoBase.setReceiverfullName(prpLclaimBillManagerDto.getPayName());
			prpLbillPayDtoBase.setCertifNo(prpLclaimBillManagerDto.getIdentifyNumber());
			prpLbillPayDtoBase.setMobilePhone(prpLclaimBillManagerDto.getMobilePhone());
			prpLbillPayDtoBase.setProvinceName(prpLclaimBillManagerDto.getProvinceName());
			prpLbillPayDtoBase.setCityName(prpLclaimBillManagerDto.getCityName());
			prpLbillPayDtoBase.setAccountType(prpLclaimBillManagerDto.getAccountType());
			prpLbillPayDtoBase.setBankType(prpLclaimBillManagerDto.getBankName());
			prpLbillPayDtoBase.setBankAccount(prpLclaimBillManagerDto.getBankAccount());
			prpLbillPayDtoBase.setAccountFlag(prpLclaimBillManagerDto.getAccountFlag());
			prpLbillPayDtoBase.setBank(prpLclaimBillManagerDto.getOpenBank());
			prpLbillPayDtoBase.setAddress(prpLclaimBillManagerDto.getAddress());
			prpLbillPayDtoBase.setStrPayAmount(prpLclaimBillManagerDto.getPayAmount()+"");
			prpLbillPayDtoBase.setPayWay(prpLclaimBillManagerDto.getPayWay());
			prpLbillPayDtoBase.setPayReason(prpLclaimBillManagerDto.getPayReason());
			prpLbillPayDtoBase.setPayPurpose(prpLclaimBillManagerDto.getPayPurpose());
			prpLbillPayDtoBase.setRouteNum(prpLclaimBillManagerDto.getRouteNum());
			
			
			//prpLbillPayDtoBase.setCertifType("t01");
			prplbillpayList.add(prpLbillPayDtoBase);
		}
	}
	HashMap titleHash = new HashMap();
	HashMap fieldHash = new HashMap();
	String dateTime = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).toString();
	System.err.println(dateTime);
	String expDate = dateTime.substring(0,4)+"年"+dateTime.substring(5,7)+"月"+dateTime.substring(8,10)+"日"+dateTime.substring(11,13)+"时"+dateTime.substring(14,16)+"分"+dateTime.substring(17,19)+"秒";
	String excelFileName = "";
	excelFileName = "工号"+strUserCode+"_"+expDate+"_账户信息清单.xls";
	System.err.println(excelFileName);
	titleHash.put("0", "序号(不可修改)");
	titleHash.put("1", "姓名(不可修改)");
	titleHash.put("2", "身份证号(不可修改)");
	titleHash.put("3", "手机号码");
	titleHash.put("4", "省份名称(例:安徽省)*");
	titleHash.put("5", "城市名称(例:合肥市)*");
	titleHash.put("6", "账号属性（1：个人、2：单位）*");
	titleHash.put("7", "银行大类*");
	titleHash.put("8", "银行账号*");
	titleHash.put("9", "账号类型（00:银行卡、01：存折、02：信用卡、03：对公账户）*");
	titleHash.put("10", "开户银行*");
	titleHash.put("11", "联系地址");
	titleHash.put("12", "金额(不可修改)");
	titleHash.put("13", "支付方式（1：第三方支付）*");
	titleHash.put("14", "支付原因");
	titleHash.put("15", "用途说明");
	titleHash.put("16", "联行号 *");

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
			prplbillpayList, excelFileName,registNo[0].substring(1,5),registNo[0],compensate[0],strUserCode);
%>