package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ�֧���˻����̹켣������ݴ���������<br>
 */
public class PrplinterPayBackDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** ����֧������ӿڹ���id */
    private String relationId = "";
    /** ���Կͻ��˹������� */
    private String outId = "";
    /** ����֧����� */
    private String paymentNo = "";
    /** �����˻���Ա���� */
    private String operatorCode = "";
    /** �����˻ػ������� */
    private String backComCode = "";
    /** �����˻�ԭ�� */
    private String backReason = "";
    /** �����м����ɹ�(1�ɹ�) */
    private String saveSuccFlag = "";
    /** �������ݽ����ɹ�(1�ɹ�) */
    private String mutualSuccFlag = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ���Է�����Ϣ(�ɹ�/error) */
    private String remark = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplinterPayBackDetailDtoBase����
     */
    public PrplinterPayBackDetailDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ��������֧������ӿڹ���id
     * @param relationId �����õ�����֧������ӿڹ���id��ֵ
     */
    public void setRelationId(String relationId){
        this.relationId = StringUtils.rightTrim(relationId);
    }

    /**
     * ��ȡ����֧������ӿڹ���id
     * @return ����֧������ӿڹ���id��ֵ
     */
    public String getRelationId(){
        return relationId;
    }

    /**
     * �������Կͻ��˹�������
     * @param outId �����õ����Կͻ��˹���������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ��˹�������
     * @return ���Կͻ��˹���������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * ��������֧�����
     * @param paymentNo �����õ�����֧����ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ����֧�����
     * @return ����֧����ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ���������˻���Ա����
     * @param operatorCode �����õ������˻���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ�����˻���Ա����
     * @return �����˻���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ���������˻ػ�������
     * @param backComCode �����õ������˻ػ��������ֵ
     */
    public void setBackComCode(String backComCode){
        this.backComCode = StringUtils.rightTrim(backComCode);
    }

    /**
     * ��ȡ�����˻ػ�������
     * @return �����˻ػ��������ֵ
     */
    public String getBackComCode(){
        return backComCode;
    }

    /**
     * ���������˻�ԭ��
     * @param backReason �����õ������˻�ԭ���ֵ
     */
    public void setBackReason(String backReason){
        this.backReason = StringUtils.rightTrim(backReason);
    }

    /**
     * ��ȡ�����˻�ԭ��
     * @return �����˻�ԭ���ֵ
     */
    public String getBackReason(){
        return backReason;
    }

    /**
     * ���������м����ɹ�(1�ɹ�)
     * @param saveSuccFlag �����õ������м����ɹ�(1�ɹ�)��ֵ
     */
    public void setSaveSuccFlag(String saveSuccFlag){
        this.saveSuccFlag = StringUtils.rightTrim(saveSuccFlag);
    }

    /**
     * ��ȡ�����м����ɹ�(1�ɹ�)
     * @return �����м����ɹ�(1�ɹ�)��ֵ
     */
    public String getSaveSuccFlag(){
        return saveSuccFlag;
    }

    /**
     * �����������ݽ����ɹ�(1�ɹ�)
     * @param mutualSuccFlag �����õ��������ݽ����ɹ�(1�ɹ�)��ֵ
     */
    public void setMutualSuccFlag(String mutualSuccFlag){
        this.mutualSuccFlag = StringUtils.rightTrim(mutualSuccFlag);
    }

    /**
     * ��ȡ�������ݽ����ɹ�(1�ɹ�)
     * @return �������ݽ����ɹ�(1�ɹ�)��ֵ
     */
    public String getMutualSuccFlag(){
        return mutualSuccFlag;
    }

    /**
     * ������������ʱ��
     * @param inputDate �����õ���������ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Է�����Ϣ(�ɹ�/error)
     * @param remark �����õ����Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Է�����Ϣ(�ɹ�/error)
     * @return ���Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public String getRemark(){
        return remark;
    }
}
