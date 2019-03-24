package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLverifyLossExt的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLverifyLossExtDtoBase implements Serializable{
 
    private static final long serialVersionUID = 1L;
    /** 属性RegistNo */
    private String registNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性SerialNo */
    private int serialNo = 0;
    /** 属性InputDate */
    private DateTime inputDate = new DateTime();
    /** 属性InputHour */
    private String inputHour = "";
    /** 属性OperatorCode */
    private String operatorCode = "";
    /** 属性ComCode */
    private String comCode = "";
    /** 属性title */
    private String title = "";
    /** 属性Context */
    private String context = "";
    /** 属性LossItemCode */
    private String lossItemCode = "";
    /** 属性nodetype */
    private String nodeType = "";
    /** 属性status */
    private String status = "";
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	/**
     *  默认构造方法,构造一个默认的PrpLverifyLossExtDtoBase对象
     */
    public PrpLverifyLossExtDtoBase(){
    }

    /**
     * 设置属性RegistNo
     * @param registNo 待设置的属性RegistNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性RegistNo
     * @return 属性RegistNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性SerialNo
     * @param serialNo 待设置的属性SerialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性SerialNo
     * @return 属性SerialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性InputDate
     * @param inputDate 待设置的属性InputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性InputDate
     * @return 属性InputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性InputHour
     * @param inputHour 待设置的属性InputHour的值
     */
    public void setInputHour(String inputHour){
        this.inputHour = StringUtils.rightTrim(inputHour);
    }

    /**
     * 获取属性InputHour
     * @return 属性InputHour的值
     */
    public String getInputHour(){
        return inputHour;
    }

    /**
     * 设置属性OperatorCode
     * @param operatorCode 待设置的属性OperatorCode的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性OperatorCode
     * @return 属性OperatorCode的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性ComCode
     * @param comCode 待设置的属性ComCode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性ComCode
     * @return 属性ComCode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性title
     * @param title 待设置的属性title的值
     */
    public void setTitle(String title){
        this.title = StringUtils.rightTrim(title);
    }

    /**
     * 获取属性title
     * @return 属性title的值
     */
    public String getTitle(){
        return title;
    }

    /**
     * 设置属性Context
     * @param context 待设置的属性Context的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性Context
     * @return 属性Context的值
     */
    public String getContext(){
        return context;
    }
    
    /**
     * 设置属性LossItemCode
     * @param lossItemCode 待设置的属性LossItemCode的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性LossItemCode
     * @return 属性LossItemCode的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }
}
