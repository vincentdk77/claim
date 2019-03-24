package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class SchedExtInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������� pk */
    private int serialNo = 0;
    /** ���Բ����˴��� */
    private String operatorCode = "";
    /** �������� */
    private String context = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SchedExtInfoDto����
     */
    public SchedExtInfoDto(){
    }

    /**
     * ����������� pk
     * @param serialNo �����õ�������� pk��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ������� pk
     * @return ������� pk��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Բ����˴���
     * @param operatorCode �����õ����Բ����˴����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ����˴���
     * @return ���Բ����˴����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ������������
     * @param context �����õ��������ݵ�ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ��������
     * @return �������ݵ�ֵ
     */
    public String getContext(){
        return context;
    }

}
