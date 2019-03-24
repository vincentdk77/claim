package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfCondition-���������������������������ݴ���������<br>
 * ������ 2005-04-26 15:20:39.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfConditionDtoBase implements Serializable{
    /** ����ģ����� */
    private int modelNo = 0;
    /** �������̱߱��� */
    private int pathNo = 0;
    /** ������������ */
    private int conditionNo = 0;
    /** ������� */
    private int serialNo = 0;
    /** ���Բ��Ŵ��� */
    private String comCode = "";
    /** �����Ƿ���Ч�� */
    private String validStatus = "";
    /** �����������ͱ�־ */
    private String configType = "";
    /** ������������ */
    private String configText = "";
    /** ����ҵ���ֵ */
    private String businessKey = "";
    /** �������ݿ����� */
    private String dBName = "";
    /** ���Ա��� */
    private String tableName = "";
    /** �����ֶ��������� */
    private String dataType = "";
    /** �����ֶ��� */
    private String columnName = "";
    /** �����ֶ����� */
    private String columnDesc = "";
    /** ��������� */
    private String operator = "";
    /** ���ԱȽ�ֵ */
    private String value = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfConditionDtoBase����
     */
    public SwfConditionDtoBase(){
    }

    /**
     * ��������ģ�����
     * @param modelNo �����õ�����ģ������ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ�����
     * @return ����ģ������ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * �����������̱߱���
     * @param pathNo �����õ��������̱߱����ֵ
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * ��ȡ�������̱߱���
     * @return �������̱߱����ֵ
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * ����������������
     * @param conditionNo �����õ��������������ֵ
     */
    public void setConditionNo(int conditionNo){
        this.conditionNo = conditionNo;
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public int getConditionNo(){
        return conditionNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Բ��Ŵ���
     * @param comCode �����õ����Բ��Ŵ����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Բ��Ŵ���
     * @return ���Բ��Ŵ����ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ���������Ƿ���Ч��
     * @param validStatus �����õ������Ƿ���Ч���ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ�����Ƿ���Ч��
     * @return �����Ƿ���Ч���ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ���������������ͱ�־
     * @param configType �����õ������������ͱ�־��ֵ
     */
    public void setConfigType(String configType){
        this.configType = StringUtils.rightTrim(configType);
    }

    /**
     * ��ȡ�����������ͱ�־
     * @return �����������ͱ�־��ֵ
     */
    public String getConfigType(){
        return configType;
    }

    /**
     * ����������������
     * @param configText �����õ���������������ֵ
     */
    public void setConfigText(String configText){
        this.configText = StringUtils.rightTrim(configText);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getConfigText(){
        return configText;
    }

    /**
     * ��������ҵ���ֵ
     * @param businessKey �����õ�����ҵ���ֵ��ֵ
     */
    public void setBusinessKey(String businessKey){
        this.businessKey = StringUtils.rightTrim(businessKey);
    }

    /**
     * ��ȡ����ҵ���ֵ
     * @return ����ҵ���ֵ��ֵ
     */
    public String getBusinessKey(){
        return businessKey;
    }

    /**
     * �����������ݿ�����
     * @param dBName �����õ��������ݿ����Ƶ�ֵ
     */
    public void setDBName(String dBName){
        this.dBName = StringUtils.rightTrim(dBName);
    }

    /**
     * ��ȡ�������ݿ�����
     * @return �������ݿ����Ƶ�ֵ
     */
    public String getDBName(){
        return dBName;
    }

    /**
     * �������Ա���
     * @param tableName �����õ����Ա�����ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * ���������ֶ���������
     * @param dataType �����õ������ֶ��������͵�ֵ
     */
    public void setDataType(String dataType){
        this.dataType = StringUtils.rightTrim(dataType);
    }

    /**
     * ��ȡ�����ֶ���������
     * @return �����ֶ��������͵�ֵ
     */
    public String getDataType(){
        return dataType;
    }

    /**
     * ���������ֶ���
     * @param columnName �����õ������ֶ�����ֵ
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * ��ȡ�����ֶ���
     * @return �����ֶ�����ֵ
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * ���������ֶ�����
     * @param columnDesc �����õ������ֶ�������ֵ
     */
    public void setColumnDesc(String columnDesc){
        this.columnDesc = StringUtils.rightTrim(columnDesc);
    }

    /**
     * ��ȡ�����ֶ�����
     * @return �����ֶ�������ֵ
     */
    public String getColumnDesc(){
        return columnDesc;
    }

    /**
     * �������������
     * @param operator �����õ������������ֵ
     */
    public void setOperator(String operator){
        this.operator = StringUtils.rightTrim(operator);
    }

    /**
     * ��ȡ���������
     * @return �����������ֵ
     */
    public String getOperator(){
        return operator;
    }

    /**
     * �������ԱȽ�ֵ
     * @param value �����õ����ԱȽ�ֵ��ֵ
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * ��ȡ���ԱȽ�ֵ
     * @return ���ԱȽ�ֵ��ֵ
     */
    public String getValue(){
        return value;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
