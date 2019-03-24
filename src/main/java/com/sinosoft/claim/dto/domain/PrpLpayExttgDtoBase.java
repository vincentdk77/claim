package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧���������������ݴ���������<br>
 */
public class PrpLpayExttgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����ո���� */
    private String paymentNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Դ���ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Դ����˴��� */
    private String operatorCode = "";
    /** ����������� */
    private String context = "";
    /** ���Դ������ */
    private String comCode = "";
    /** ���Դ���ڵ� */
    private String nodeType = "";
    /** ���Դ���ڵ����� */
    private String nodeName = "";
    /** ���Դ���������� */
    private String notionCode = "";
    /** ���Դ���������� */
    private String notionName = "";
    /** �����ݴ��־(N/�ݴ�;Y/���) */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayExttgDtoBase����
     */
    public PrpLpayExttgDtoBase(){
    }

    /**
     * ���������ո����
     * @param paymentNo �����õ������ո���ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ�����ո����
     * @return �����ո���ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
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
     * �������Դ���ʱ��
     * @param inputDate �����õ����Դ���ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Դ����˴���
     * @param operatorCode �����õ����Դ����˴����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Դ����˴���
     * @return ���Դ����˴����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ���������������
     * @param context �����õ�����������ݵ�ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ�����������
     * @return ����������ݵ�ֵ
     */
    public String getContext(){
        return context;
    }

    /**
     * �������Դ������
     * @param comCode �����õ����Դ��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Դ���ڵ�
     * @param nodeType �����õ����Դ���ڵ��ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Դ���ڵ�
     * @return ���Դ���ڵ��ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * �������Դ���ڵ�����
     * @param nodeName �����õ����Դ���ڵ����Ƶ�ֵ
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * ��ȡ���Դ���ڵ�����
     * @return ���Դ���ڵ����Ƶ�ֵ
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * �������Դ����������
     * @param notionCode �����õ����Դ�����������ֵ
     */
    public void setNotionCode(String notionCode){
        this.notionCode = StringUtils.rightTrim(notionCode);
    }

    /**
     * ��ȡ���Դ����������
     * @return ���Դ�����������ֵ
     */
    public String getNotionCode(){
        return notionCode;
    }

    /**
     * �������Դ����������
     * @param notionName �����õ����Դ���������ֵ�ֵ
     */
    public void setNotionName(String notionName){
        this.notionName = StringUtils.rightTrim(notionName);
    }

    /**
     * ��ȡ���Դ����������
     * @return ���Դ���������ֵ�ֵ
     */
    public String getNotionName(){
        return notionName;
    }

    /**
     * ���������ݴ��־(N/�ݴ�;Y/���)
     * @param flag �����õ������ݴ��־(N/�ݴ�;Y/���)��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ�����ݴ��־(N/�ݴ�;Y/���)
     * @return �����ݴ��־(N/�ݴ�;Y/���)��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
