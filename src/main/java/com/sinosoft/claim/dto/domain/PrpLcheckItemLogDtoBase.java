package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.875<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckItemLogDtoBase implements Serializable{
    /** ���Ե���ID */
    private int scheduleID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ���Ա����� */
    private double itemNo = 0d;
    /** ���Դ������ */
    private int serialNo = 0;
    /** ���Դ���ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Բ鿱״̬ */
    private String checkFlag = "";
    /** ���Դ�����Ϣ(�ɴ���Ƭ��������������ֱ��д) */
    private String checkInfo = "";
    /** ���Դ���״�� */
    private String dealFlag = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Բ���Ա���� */
    private String operatorName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckItemLogDtoBase����
     */
    public PrpLcheckItemLogDtoBase(){
    }

    /**
     * �������Ե���ID
     * @param scheduleID �����õ����Ե���ID��ֵ
     */
    public void setScheduleID(int scheduleID){
        this.scheduleID = scheduleID;
    }

    /**
     * ��ȡ���Ե���ID
     * @return ���Ե���ID��ֵ
     */
    public int getScheduleID(){
        return scheduleID;
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Ա�����
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(double itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public double getItemNo(){
        return itemNo;
    }

    /**
     * �������Դ������
     * @param serialNo �����õ����Դ�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Դ������
     * @return ���Դ�����ŵ�ֵ
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
     * �������Բ鿱״̬
     * @param checkFlag �����õ����Բ鿱״̬��ֵ
     */
    public void setCheckFlag(String checkFlag){
        this.checkFlag = StringUtils.rightTrim(checkFlag);
    }

    /**
     * ��ȡ���Բ鿱״̬
     * @return ���Բ鿱״̬��ֵ
     */
    public String getCheckFlag(){
        return checkFlag;
    }

    /**
     * �������Դ�����Ϣ(�ɴ���Ƭ��������������ֱ��д)
     * @param checkInfo �����õ����Դ�����Ϣ(�ɴ���Ƭ��������������ֱ��д)��ֵ
     */
    public void setCheckInfo(String checkInfo){
        this.checkInfo = StringUtils.rightTrim(checkInfo);
    }

    /**
     * ��ȡ���Դ�����Ϣ(�ɴ���Ƭ��������������ֱ��д)
     * @return ���Դ�����Ϣ(�ɴ���Ƭ��������������ֱ��д)��ֵ
     */
    public String getCheckInfo(){
        return checkInfo;
    }

    /**
     * �������Դ���״��
     * @param dealFlag �����õ����Դ���״����ֵ
     */
    public void setDealFlag(String dealFlag){
        this.dealFlag = StringUtils.rightTrim(dealFlag);
    }

    /**
     * ��ȡ���Դ���״��
     * @return ���Դ���״����ֵ
     */
    public String getDealFlag(){
        return dealFlag;
    }

    /**
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Բ���Ա����
     * @param operatorName �����õ����Բ���Ա���Ƶ�ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա���Ƶ�ֵ
     */
    public String getOperatorName(){
        return operatorName;
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
