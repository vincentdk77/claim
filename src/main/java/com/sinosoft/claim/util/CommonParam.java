package com.sinosoft.claim.util;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class CommonParam {
	//int long double date String byte[]
	//com.sinosoft.sysframework.reference.DBManager暂时只支持以上的参数类型的预编译
	//参数类型
	private String paramType;
	//参数值
	private byte[] byteValue;
	private int intValue;
	private long longValue;
	private double doubleValue;
	private String stringValue; 
	private DateTime DateTimeValue;
	
	public CommonParam() {
		// TODO Auto-generated constructor stub
	}
	
	public CommonParam(String stringValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "String";
		this.stringValue = stringValue;
	}
	
	public CommonParam(int intValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "int";
		this.intValue = intValue;
	}
	
	public CommonParam(long longValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "long";
		this.longValue = longValue;
	}
	
	public CommonParam(double doubleValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "double";
		this.doubleValue = doubleValue;
	}
	
	public CommonParam(DateTime DateTimeValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "DateTime";
		this.DateTimeValue = DateTimeValue;
	}
	
	public CommonParam(byte[] byteValue) {
		// TODO Auto-generated constructor stub
		this.paramType = "byte";
		this.byteValue = byteValue;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public byte[] getByteValue() {
		return byteValue;
	}

	public void setByteValue(byte[] byteValue) {
		setParamType("byte");
		this.byteValue = byteValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		setParamType("int");
		this.intValue = intValue;
	}

	public long getLongValue() {
		return longValue;
	}

	public void setLongValue(long longValue) {
		setParamType("long");
		this.longValue = longValue;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		setParamType("double");
		this.doubleValue = doubleValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		setParamType("String");
		this.stringValue = stringValue;
	}

	public DateTime getDateTimeValue() {
		return DateTimeValue;
	}

	public void setDateTimeValue(DateTime dateTimeValue) {
		setParamType("DateTime");
		DateTimeValue = dateTimeValue;
	}
		
}
