package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimStatus-����ڵ�״̬��(����)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimStatustgDtoBase implements Serializable{
    /** ����ҵ��� */
    private String businessNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Խڵ����� */
    private String nodeType = "";
    /** �������к��� */
    private int serialNo = 0;
    /** �������� */
    private String riskCode = "";
    /** ���Բ���״̬λ */
    private String status = "";
    /** �������̱�� */
    private String flowID = "";
    /** ���԰�����Ա���� */
    private String handlerCode = "";
    /** ���Լ�����䵥���� */
    private DateTime inputDate = new DateTime();
    /** ���Բ������� */
    private DateTime operateDate = new DateTime();
    /** �������ͱ�־ */
    private String typeFlag = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimStatustgDtoBase����
     */
    public PrpLclaimStatustgDtoBase(){
    }

    /**
     * ��������ҵ���
     * @param businessNo �����õ�����ҵ��ŵ�ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ���
     * @return ����ҵ��ŵ�ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ������ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ������ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * �����������к���
     * @param serialNo �����õ��������к����ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������к���
     * @return �������к����ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Բ���״̬λ
     * @param status �����õ����Բ���״̬λ��ֵ
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ���Բ���״̬λ
     * @return ���Բ���״̬λ��ֵ
     */
    public String getStatus(){
        return status;
    }

    /**
     * �����������̱��
     * @param flowID �����õ��������̱�ŵ�ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ�������̱��
     * @return �������̱�ŵ�ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * �������԰�����Ա����
     * @param handlerCode �����õ����԰�����Ա�����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���԰�����Ա����
     * @return ���԰�����Ա�����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Լ�����䵥����
     * @param inputDate �����õ����Լ�����䵥���ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ�����䵥����
     * @return ���Լ�����䵥���ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Բ�������
     * @param operateDate �����õ����Բ������ڵ�ֵ
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������ڵ�ֵ
     */
    public DateTime getOperateDate(){
        return operateDate;
    }

    /**
     * �����������ͱ�־
     * @param typeFlag �����õ��������ͱ�־��ֵ
     */
    public void setTypeFlag(String typeFlag){
        this.typeFlag = StringUtils.rightTrim(typeFlag);
    }

    /**
     * ��ȡ�������ͱ�־
     * @return �������ͱ�־��ֵ
     */
    public String getTypeFlag(){
        return typeFlag;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
