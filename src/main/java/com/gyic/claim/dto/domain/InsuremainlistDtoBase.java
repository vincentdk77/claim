package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ���嵥ͷ������ݴ���������<br>
 */
public class InsuremainlistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����Ͷ���嵥��� */
    private String inusrelistcode = "";
    /** ����������� */
    private String fareacode = "";
    /** �������� */
    private String classcode = "";
    /** �������� */
    private String riskcode = "";
    /** ����Ͷ������ */
    private String proposalno = "";
    /** ���Ա������� */
    private String policyno = "";
    /** �����嵥��־ */
    private String validity = "";
    /** �����ϴα༭���� */
    private String updatecode = "";
    /** �����ϴα༭ʱ�� */
    private DateTime updatedate = new DateTime();
    /** ���Բ���Ա���� */
    private String opcode = "";
    /** ����Ͷ����ע */
    private String remark = "";
    /** ���Ա������� */
    private DateTime starttime = new DateTime();
    /** ���Ա���ֹ�� */
    private DateTime endtime = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�InsuremainlistDtoBase����
     */
    public InsuremainlistDtoBase(){
    }

    /**
     * ��������Ͷ���嵥���
     * @param inusrelistcode �����õ�����Ͷ���嵥��ŵ�ֵ
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * ��ȡ����Ͷ���嵥���
     * @return ����Ͷ���嵥��ŵ�ֵ
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * ���������������
     * @param fareacode �����õ�������������ֵ
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getFareacode(){
        return fareacode;
    }

    /**
     * ������������
     * @param classcode �����õ����������ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ������������
     * @param riskcode �����õ��������ֵ�ֵ
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * ��������Ͷ������
     * @param proposalno �����õ�����Ͷ�����ŵ�ֵ
     */
    public void setProposalno(String proposalno){
        this.proposalno = StringUtils.rightTrim(proposalno);
    }

    /**
     * ��ȡ����Ͷ������
     * @return ����Ͷ�����ŵ�ֵ
     */
    public String getProposalno(){
        return proposalno;
    }

    /**
     * �������Ա�������
     * @param policyno �����õ����Ա��������ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ���������嵥��־
     * @param validity �����õ������嵥��־��ֵ
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * ��ȡ�����嵥��־
     * @return �����嵥��־��ֵ
     */
    public String getValidity(){
        return validity;
    }

    /**
     * ���������ϴα༭����
     * @param updatecode �����õ������ϴα༭�����ֵ
     */
    public void setUpdatecode(String updatecode){
        this.updatecode = StringUtils.rightTrim(updatecode);
    }

    /**
     * ��ȡ�����ϴα༭����
     * @return �����ϴα༭�����ֵ
     */
    public String getUpdatecode(){
        return updatecode;
    }

    /**
     * ���������ϴα༭ʱ��
     * @param updatedate �����õ������ϴα༭ʱ���ֵ
     */
    public void setUpdatedate(DateTime updatedate){
        this.updatedate = updatedate;
    }

    /**
     * ��ȡ�����ϴα༭ʱ��
     * @return �����ϴα༭ʱ���ֵ
     */
    public DateTime getUpdatedate(){
        return updatedate;
    }

    /**
     * �������Բ���Ա����
     * @param opcode �����õ����Բ���Ա�����ֵ
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * ��������Ͷ����ע
     * @param remark �����õ�����Ͷ����ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Ͷ����ע
     * @return ����Ͷ����ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * �������Ա�������
     * @param starttime �����õ����Ա������ڵ�ֵ
     */
    public void setStarttime(DateTime starttime){
        this.starttime = starttime;
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������ڵ�ֵ
     */
    public DateTime getStarttime(){
        return starttime;
    }

    /**
     * �������Ա���ֹ��
     * @param endtime �����õ����Ա���ֹ�ڵ�ֵ
     */
    public void setEndtime(DateTime endtime){
        this.endtime = endtime;
    }

    /**
     * ��ȡ���Ա���ֹ��
     * @return ���Ա���ֹ�ڵ�ֵ
     */
    public DateTime getEndtime(){
        return endtime;
    }
}
