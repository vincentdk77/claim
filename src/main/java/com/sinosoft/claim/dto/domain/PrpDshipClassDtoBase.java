package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdshipclass������������յ����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshipClassDtoBase implements Serializable{
    /** ���Դ������� */
    private String shipCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Դ��������� */
    private String classification = "";
    /** ���Է�֤���� */
    private DateTime issuedonDate = new DateTime();
    /** ������ֹ���� */
    private DateTime closingDate = new DateTime();
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDshipClassDtoBase����
     */
    public PrpDshipClassDtoBase(){
    }

    /**
     * �������Դ�������
     * @param shipCode �����õ����Դ��������ֵ
     */
    public void setShipCode(String shipCode){
        this.shipCode = StringUtils.rightTrim(shipCode);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ��������ֵ
     */
    public String getShipCode(){
        return shipCode;
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
     * �������Դ���������
     * @param classification �����õ����Դ��������Ƶ�ֵ
     */
    public void setClassification(String classification){
        this.classification = StringUtils.rightTrim(classification);
    }

    /**
     * ��ȡ���Դ���������
     * @return ���Դ��������Ƶ�ֵ
     */
    public String getClassification(){
        return classification;
    }

    /**
     * �������Է�֤����
     * @param issuedonDate �����õ����Է�֤���ڵ�ֵ
     */
    public void setIssuedonDate(DateTime issuedonDate){
        this.issuedonDate = issuedonDate;
    }

    /**
     * ��ȡ���Է�֤����
     * @return ���Է�֤���ڵ�ֵ
     */
    public DateTime getIssuedonDate(){
        return issuedonDate;
    }

    /**
     * ����������ֹ����
     * @param closingDate �����õ�������ֹ���ڵ�ֵ
     */
    public void setClosingDate(DateTime closingDate){
        this.closingDate = closingDate;
    }

    /**
     * ��ȡ������ֹ����
     * @return ������ֹ���ڵ�ֵ
     */
    public DateTime getClosingDate(){
        return closingDate;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
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
