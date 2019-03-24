package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLverifyLossExt�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLverifyLossExtDtoBase implements Serializable{
 
    private static final long serialVersionUID = 1L;
    /** ����RegistNo */
    private String registNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����SerialNo */
    private int serialNo = 0;
    /** ����InputDate */
    private DateTime inputDate = new DateTime();
    /** ����InputHour */
    private String inputHour = "";
    /** ����OperatorCode */
    private String operatorCode = "";
    /** ����ComCode */
    private String comCode = "";
    /** ����title */
    private String title = "";
    /** ����Context */
    private String context = "";
    /** ����LossItemCode */
    private String lossItemCode = "";
    /** ����nodetype */
    private String nodeType = "";
    /** ����status */
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLverifyLossExtDtoBase����
     */
    public PrpLverifyLossExtDtoBase(){
    }

    /**
     * ��������RegistNo
     * @param registNo �����õ�����RegistNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����RegistNo
     * @return ����RegistNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������SerialNo
     * @param serialNo �����õ�����SerialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����SerialNo
     * @return ����SerialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������InputDate
     * @param inputDate �����õ�����InputDate��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����InputDate
     * @return ����InputDate��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������InputHour
     * @param inputHour �����õ�����InputHour��ֵ
     */
    public void setInputHour(String inputHour){
        this.inputHour = StringUtils.rightTrim(inputHour);
    }

    /**
     * ��ȡ����InputHour
     * @return ����InputHour��ֵ
     */
    public String getInputHour(){
        return inputHour;
    }

    /**
     * ��������OperatorCode
     * @param operatorCode �����õ�����OperatorCode��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ����OperatorCode
     * @return ����OperatorCode��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ��������ComCode
     * @param comCode �����õ�����ComCode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ComCode
     * @return ����ComCode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������title
     * @param title �����õ�����title��ֵ
     */
    public void setTitle(String title){
        this.title = StringUtils.rightTrim(title);
    }

    /**
     * ��ȡ����title
     * @return ����title��ֵ
     */
    public String getTitle(){
        return title;
    }

    /**
     * ��������Context
     * @param context �����õ�����Context��ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ����Context
     * @return ����Context��ֵ
     */
    public String getContext(){
        return context;
    }
    
    /**
     * ��������LossItemCode
     * @param lossItemCode �����õ�����LossItemCode��ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ����LossItemCode
     * @return ����LossItemCode��ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }
}
