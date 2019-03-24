package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfFlowMain-�������������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.796<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfFlowMainDtoBase implements Serializable{
    /** �������̱�� */
    private String flowID = "";
    /** ������������ */
    private String flowName = "";
    /** ���Ը����̵�״̬ */
    private String flowStatus = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Դ��������̵�ʱ�� */
    private DateTime creatDate = new DateTime();
    /** ���Թرչ������̵�ʱ�� */
    private DateTime closeDate = new DateTime();
    /** ����ģ��� */
    private int modelNo = 0;
    /** ���Ա�־λ */
    private String flag = "";
    /** �����Ƴ���־ 0δ�Ƴ� 1��Ҫ�Ƴ� 2���Ƴ� */
    private String storeFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfFlowMainDtoBase����
     */
    public SwfFlowMainDtoBase(){
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
     * ����������������
     * @param flowName �����õ������������Ƶ�ֵ
     */
    public void setFlowName(String flowName){
        this.flowName = StringUtils.rightTrim(flowName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getFlowName(){
        return flowName;
    }

    /**
     * �������Ը����̵�״̬
     * @param flowStatus �����õ����Ը����̵�״̬��ֵ
     */
    public void setFlowStatus(String flowStatus){
        this.flowStatus = StringUtils.rightTrim(flowStatus);
    }

    /**
     * ��ȡ���Ը����̵�״̬
     * @return ���Ը����̵�״̬��ֵ
     */
    public String getFlowStatus(){
        return flowStatus;
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
     * �������Դ��������̵�ʱ��
     * @param creatDate �����õ����Դ��������̵�ʱ���ֵ
     */
    public void setCreatDate(DateTime creatDate){
        this.creatDate = creatDate;
    }

    /**
     * ��ȡ���Դ��������̵�ʱ��
     * @return ���Դ��������̵�ʱ���ֵ
     */
    public DateTime getCreatDate(){
        return creatDate;
    }

    /**
     * �������Թرչ������̵�ʱ��
     * @param closeDate �����õ����Թرչ������̵�ʱ���ֵ
     */
    public void setCloseDate(DateTime closeDate){
        this.closeDate = closeDate;
    }

    /**
     * ��ȡ���Թرչ������̵�ʱ��
     * @return ���Թرչ������̵�ʱ���ֵ
     */
    public DateTime getCloseDate(){
        return closeDate;
    }

    /**
     * ��������ģ���
     * @param modelNo �����õ�����ģ��ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ���
     * @return ����ģ��ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
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
    
    /**
     * ���������Ƴ���־
     * @param storeFlag �����õ�����storeFlag��ֵ
     */
    public void setStoreFlag(String storeFlag){
        this.storeFlag = StringUtils.rightTrim(storeFlag);
    }

    /**
     * ��ȡ�����Ƴ���־
     * @return ����storeFlag��ֵ
     */
    public String getStoreFlag(){
        return storeFlag;
    }
}
