package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLQs_Dslist����ͨ�������ϸ�嵥������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLQsDslistDtoBase implements Serializable{
    /** ���Խ��㵥���κ� */
    private String procNo = "";
    /** ���Ա��ν���˳��� */
    private int serialNo = 0;
    /** ���Գ������� */
    private DateTime damageDate = new DateTime();
    /** ���Գб��ع�˾���� */
    private String cbComCode = "";
    /** ���Գб��ع�˾���� */
    private String cbComCName = "";
    /** ���Գ��յع�˾���� */
    private String lpComCode = "";
    /** ���Գ��յع�˾���� */
    private String lpComCName = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Գ��ƺ��� */
    private String licenseNo = "";
    /** ���Ա����������� */
    private String insuredName = "";
    /** ���Դ���/�������ⰸ�� */
    private String claimAgntNo = "";
    /** �����¼����ʴ��� */
    private String agntTypeCode = "";
    /** ��������վ�Ǧӡ�� */
    private String reciptNo = "";
    /** ��������� */
    private double claimAgntFee = 0d;
    /** ����ʵ����� */
    private double realPayFee = 0d;
    /** ���������� */
    private String handlerCode = "";
    /** ���Ա��ؽ������� */
    private DateTime procDate = new DateTime();
    /** ���Ա��ؽ������Ա */
    private String operatorCode = "";
    /** ���Ա��ؽ��㵥λ���� */
    private String comCode = "";
    /** ���Բ����־ */
    private String differFlag = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLQs_DslistDtoBase����
     */
    public PrpLQsDslistDtoBase(){
    }

    /**
     * �������Խ��㵥���κ�
     * @param procNo �����õ����Խ��㵥���κŵ�ֵ
     */
    public void setProcNo(String procNo){
        this.procNo = StringUtils.rightTrim(procNo);
    }

    /**
     * ��ȡ���Խ��㵥���κ�
     * @return ���Խ��㵥���κŵ�ֵ
     */
    public String getProcNo(){
        return procNo;
    }

    /**
     * �������Ա��ν���˳���
     * @param serialNo �����õ����Ա��ν���˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Ա��ν���˳���
     * @return ���Ա��ν���˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Գ�������
     * @param damageDate �����õ����Գ������ڵ�ֵ
     */
    public void setDamageDate(DateTime damageDate){
        this.damageDate = damageDate;
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������ڵ�ֵ
     */
    public DateTime getDamageDate(){
        return damageDate;
    }

    /**
     * �������Գб��ع�˾����
     * @param cbComCode �����õ����Գб��ع�˾�����ֵ
     */
    public void setCbComCode(String cbComCode){
        this.cbComCode = StringUtils.rightTrim(cbComCode);
    }

    /**
     * ��ȡ���Գб��ع�˾����
     * @return ���Գб��ع�˾�����ֵ
     */
    public String getCbComCode(){
        return cbComCode;
    }

    /**
     * �������Գб��ع�˾����
     * @param cbComCName �����õ����Գб��ع�˾���Ƶ�ֵ
     */
    public void setCbComCName(String cbComCName){
        this.cbComCName = StringUtils.rightTrim(cbComCName);
    }

    /**
     * ��ȡ���Գб��ع�˾����
     * @return ���Գб��ع�˾���Ƶ�ֵ
     */
    public String getCbComCName(){
        return cbComCName;
    }

    /**
     * �������Գ��յع�˾����
     * @param lpComCode �����õ����Գ��յع�˾�����ֵ
     */
    public void setLpComCode(String lpComCode){
        this.lpComCode = StringUtils.rightTrim(lpComCode);
    }

    /**
     * ��ȡ���Գ��յع�˾����
     * @return ���Գ��յع�˾�����ֵ
     */
    public String getLpComCode(){
        return lpComCode;
    }

    /**
     * �������Գ��յع�˾����
     * @param lpComCName �����õ����Գ��յع�˾���Ƶ�ֵ
     */
    public void setLpComCName(String lpComCName){
        this.lpComCName = StringUtils.rightTrim(lpComCName);
    }

    /**
     * ��ȡ���Գ��յع�˾����
     * @return ���Գ��յع�˾���Ƶ�ֵ
     */
    public String getLpComCName(){
        return lpComCName;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Գ��ƺ���
     * @param licenseNo �����õ����Գ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Ա�����������
     * @param insuredName �����õ����Ա����������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Դ���/�������ⰸ��
     * @param claimAgntNo �����õ����Դ���/�������ⰸ�ŵ�ֵ
     */
    public void setClaimAgntNo(String claimAgntNo){
        this.claimAgntNo = StringUtils.rightTrim(claimAgntNo);
    }

    /**
     * ��ȡ���Դ���/�������ⰸ��
     * @return ���Դ���/�������ⰸ�ŵ�ֵ
     */
    public String getClaimAgntNo(){
        return claimAgntNo;
    }

    /**
     * ���������¼����ʴ���
     * @param agntTypeCode �����õ������¼����ʴ����ֵ
     */
    public void setAgntTypeCode(String agntTypeCode){
        this.agntTypeCode = StringUtils.rightTrim(agntTypeCode);
    }

    /**
     * ��ȡ�����¼����ʴ���
     * @return �����¼����ʴ����ֵ
     */
    public String getAgntTypeCode(){
        return agntTypeCode;
    }

    /**
     * ������������վ�Ǧӡ��
     * @param reciptNo �����õ���������վ�Ǧӡ�ŵ�ֵ
     */
    public void setReciptNo(String reciptNo){
        this.reciptNo = StringUtils.rightTrim(reciptNo);
    }

    /**
     * ��ȡ��������վ�Ǧӡ��
     * @return ��������վ�Ǧӡ�ŵ�ֵ
     */
    public String getReciptNo(){
        return reciptNo;
    }

    /**
     * �������������
     * @param claimAgntFee �����õ�����������ֵ
     */
    public void setClaimAgntFee(double claimAgntFee){
        this.claimAgntFee = claimAgntFee;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getClaimAgntFee(){
        return claimAgntFee;
    }

    /**
     * ��������ʵ�����
     * @param realPayFee �����õ�����ʵ������ֵ
     */
    public void setRealPayFee(double realPayFee){
        this.realPayFee = realPayFee;
    }

    /**
     * ��ȡ����ʵ�����
     * @return ����ʵ������ֵ
     */
    public double getRealPayFee(){
        return realPayFee;
    }

    /**
     * ��������������
     * @param handlerCode �����õ����������˵�ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ����������
     * @return ���������˵�ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Ա��ؽ�������
     * @param procDate �����õ����Ա��ؽ������ڵ�ֵ
     */
    public void setProcDate(DateTime procDate){
        this.procDate = procDate;
    }

    /**
     * ��ȡ���Ա��ؽ�������
     * @return ���Ա��ؽ������ڵ�ֵ
     */
    public DateTime getProcDate(){
        return procDate;
    }

    /**
     * �������Ա��ؽ������Ա
     * @param operatorCode �����õ����Ա��ؽ������Ա��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Ա��ؽ������Ա
     * @return ���Ա��ؽ������Ա��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Ա��ؽ��㵥λ����
     * @param comCode �����õ����Ա��ؽ��㵥λ�����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ա��ؽ��㵥λ����
     * @return ���Ա��ؽ��㵥λ�����ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Բ����־
     * @param differFlag �����õ����Բ����־��ֵ
     */
    public void setDifferFlag(String differFlag){
        this.differFlag = StringUtils.rightTrim(differFlag);
    }

    /**
     * ��ȡ���Բ����־
     * @return ���Բ����־��ֵ
     */
    public String getDifferFlag(){
        return differFlag;
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
