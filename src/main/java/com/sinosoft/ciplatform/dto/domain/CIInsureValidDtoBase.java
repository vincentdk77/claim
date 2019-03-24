package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ��ȷ������-CIInsureValid�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIInsureValidDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ȷ���� */
    private String validNo = "";
    /** ���Բ�ѯ�� */
    private String demandNo = "";
    /** ����Ͷ�������� */
    private String proposalNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա��ձ�־���� */
    private String insureMarkNo = "";
    /** ������������ */
    private String bussinessNature = "";
    /** ����ǩ������ */
    private DateTime operateDate = new DateTime();
    /** �����ر�Լ�� */
    private String clauses = "";
    /** ���Ծ����� */
    private String handlerName = "";
    /** ���Բ���Ա */
    private String operatorName = "";
    /** ���Աұ� */
    private String currency = "";
    /** ����ʵ�ձ��� */
    private double premium = 0D;
    /** ����ʵ�ձ��ѱ仯ԭ�� */
    private String changeReason = "";
    /** ����ʵ�ձ��ѱ仯ԭ������ */
    private String changeDetail = "";
    /** ���Թ������� */
    private String comCode = "";
    /** ����ȷ��ʱ�� */
    private DateTime validTime = new DateTime();
    /** ���Ա�ע */
    private String remark = "";
    /** ����״̬�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIInsureValidDtoBase����
     */
    public CIInsureValidDtoBase(){
    }

    /**
     * ��������ȷ����
     * @param validNo �����õ�����ȷ�����ֵ
     */
    public void setValidNo(String validNo){
        this.validNo = StringUtils.rightTrim(validNo);
    }

    /**
     * ��ȡ����ȷ����
     * @return ����ȷ�����ֵ
     */
    public String getValidNo(){
        return validNo;
    }

    /**
     * �������Բ�ѯ��
     * @param demandNo �����õ����Բ�ѯ���ֵ
     */
    public void setDemandNo(String demandNo){
        this.demandNo = StringUtils.rightTrim(demandNo);
    }

    /**
     * ��ȡ���Բ�ѯ��
     * @return ���Բ�ѯ���ֵ
     */
    public String getDemandNo(){
        return demandNo;
    }

    /**
     * ��������Ͷ��������
     * @param proposalNo �����õ�����Ͷ���������ֵ
     */
    public void setProposalNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ���������ֵ
     */
    public String getProposalNo(){
        return proposalNo;
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
     * �������Ա��ձ�־����
     * @param insureMarkNo �����õ����Ա��ձ�־�����ֵ
     */
    public void setInsureMarkNo(String insureMarkNo){
        this.insureMarkNo = StringUtils.rightTrim(insureMarkNo);
    }

    /**
     * ��ȡ���Ա��ձ�־����
     * @return ���Ա��ձ�־�����ֵ
     */
    public String getInsureMarkNo(){
        return insureMarkNo;
    }

    /**
     * ����������������
     * @param bussinessNature �����õ���������������ֵ
     */
    public void setBussinessNature(String bussinessNature){
        this.bussinessNature = StringUtils.rightTrim(bussinessNature);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getBussinessNature(){
        return bussinessNature;
    }

    /**
     * ��������ǩ������
     * @param operateDate �����õ�����ǩ�����ڵ�ֵ
     */
    public void setOperateDate(DateTime operateDate){
        this.operateDate = operateDate;
    }

    /**
     * ��ȡ����ǩ������
     * @return ����ǩ�����ڵ�ֵ
     */
    public DateTime getOperateDate(){
        return operateDate;
    }

    /**
     * ���������ر�Լ��
     * @param clauses �����õ������ر�Լ����ֵ
     */
    public void setClauses(String clauses){
        this.clauses = StringUtils.rightTrim(clauses);
    }

    /**
     * ��ȡ�����ر�Լ��
     * @return �����ر�Լ����ֵ
     */
    public String getClauses(){
        return clauses;
    }

    /**
     * �������Ծ�����
     * @param handlerName �����õ����Ծ����˵�ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Ծ�����
     * @return ���Ծ����˵�ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Բ���Ա
     * @param operatorName �����õ����Բ���Ա��ֵ
     */
    public void setOperatorName(String operatorName){
        this.operatorName = StringUtils.rightTrim(operatorName);
    }

    /**
     * ��ȡ���Բ���Ա
     * @return ���Բ���Ա��ֵ
     */
    public String getOperatorName(){
        return operatorName;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������ʵ�ձ���
     * @param premium �����õ�����ʵ�ձ��ѵ�ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ����ʵ�ձ���
     * @return ����ʵ�ձ��ѵ�ֵ
     */
    public double getPremium(){
        return premium;
    }

    /**
     * ��������ʵ�ձ��ѱ仯ԭ��
     * @param changeReason �����õ�����ʵ�ձ��ѱ仯ԭ���ֵ
     */
    public void setChangeReason(String changeReason){
        this.changeReason = StringUtils.rightTrim(changeReason);
    }

    /**
     * ��ȡ����ʵ�ձ��ѱ仯ԭ��
     * @return ����ʵ�ձ��ѱ仯ԭ���ֵ
     */
    public String getChangeReason(){
        return changeReason;
    }

    /**
     * ��������ʵ�ձ��ѱ仯ԭ������
     * @param changeDetail �����õ�����ʵ�ձ��ѱ仯ԭ��������ֵ
     */
    public void setChangeDetail(String changeDetail){
        this.changeDetail = StringUtils.rightTrim(changeDetail);
    }

    /**
     * ��ȡ����ʵ�ձ��ѱ仯ԭ������
     * @return ����ʵ�ձ��ѱ仯ԭ��������ֵ
     */
    public String getChangeDetail(){
        return changeDetail;
    }

    /**
     * �������Թ�������
     * @param comCode �����õ����Թ������ŵ�ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������ŵ�ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������ȷ��ʱ��
     * @param validTime �����õ�����ȷ��ʱ���ֵ
     */
    public void setValidTime(DateTime validTime){
        this.validTime = validTime;
    }

    /**
     * ��ȡ����ȷ��ʱ��
     * @return ����ȷ��ʱ���ֵ
     */
    public DateTime getValidTime(){
        return validTime;
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
     * ��������״̬�ֶ�
     * @param flag �����õ�����״̬�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬�ֶ�
     * @return ����״̬�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
