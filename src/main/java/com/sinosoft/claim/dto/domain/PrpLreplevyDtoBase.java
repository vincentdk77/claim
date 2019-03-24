package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLreplevy-Ȩ��ת�ü�׷����Ϣ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.578<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLreplevyDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Դ��� */
    private int times = 0;
    /** ���Ա����� */
    private String policyNo = "";
    /** ����׷�����ʹ��� */
    private String replevyTypeCode = "";
    /** ����Ȩ��ת������ */
    private DateTime rightTransferDate = new DateTime();
    /** ���Ա�׷�������� */
    private String repleviedName = "";
    /** ����׷��ԭ�� */
    private String replevyReason = "";
    /** ����׷��;�������ݣ� */
    private String replevyWay = "";
    /** ����׷������ */
    private DateTime reclaimDate = new DateTime();
    /** ����׷������ */
    private DateTime validDate = new DateTime();
    /** ���Աұ� */
    private String currency = "";
    /** ������׷����� */
    private double sumReplevyFee = 0d;
    /** ������׷�ؽ�� */
    private double sumValidFee = 0d;
    /** ����̯����ʽ
--** 1��׷���� 
--** 2�������
--** 9������ */
    private String amortizeWay = "";
    /** ��������Ǽǻ������� */
    private String makeCom = "";
    /** ����ҵ��������� */
    private String comCode = "";
    /** ���Ը����˴��� */
    private String approverCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ����ͳ������ */
    private DateTime statisticsYM = new DateTime();
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Խ᰸���� */
    private DateTime endCaseDate = new DateTime();
    /** ���Խ᰸Ա���� */
    private String endCaseCode = "";
    /** ����ע������ */
    private DateTime cancelDate = new DateTime();
    /** ����ע��ԭ�� */
    private String cancelReason = "";
    /** ����ע���˴��� */
    private String dealerCode = "";
    /** ���Ա�ע */
    private String note = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLreplevyDtoBase����
     */
    public PrpLreplevyDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Դ���
     * @param times �����õ����Դ�����ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ�����ֵ
     */
    public int getTimes(){
        return times;
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
     * ��������׷�����ʹ���
     * @param replevyTypeCode �����õ�����׷�����ʹ����ֵ
     */
    public void setReplevyTypeCode(String replevyTypeCode){
        this.replevyTypeCode = StringUtils.rightTrim(replevyTypeCode);
    }

    /**
     * ��ȡ����׷�����ʹ���
     * @return ����׷�����ʹ����ֵ
     */
    public String getReplevyTypeCode(){
        return replevyTypeCode;
    }

    /**
     * ��������Ȩ��ת������
     * @param rightTransferDate �����õ�����Ȩ��ת�����ڵ�ֵ
     */
    public void setRightTransferDate(DateTime rightTransferDate){
        this.rightTransferDate = rightTransferDate;
    }

    /**
     * ��ȡ����Ȩ��ת������
     * @return ����Ȩ��ת�����ڵ�ֵ
     */
    public DateTime getRightTransferDate(){
        return rightTransferDate;
    }

    /**
     * �������Ա�׷��������
     * @param repleviedName �����õ����Ա�׷�������Ƶ�ֵ
     */
    public void setRepleviedName(String repleviedName){
        this.repleviedName = StringUtils.rightTrim(repleviedName);
    }

    /**
     * ��ȡ���Ա�׷��������
     * @return ���Ա�׷�������Ƶ�ֵ
     */
    public String getRepleviedName(){
        return repleviedName;
    }

    /**
     * ��������׷��ԭ��
     * @param replevyReason �����õ�����׷��ԭ���ֵ
     */
    public void setReplevyReason(String replevyReason){
        this.replevyReason = StringUtils.rightTrim(replevyReason);
    }

    /**
     * ��ȡ����׷��ԭ��
     * @return ����׷��ԭ���ֵ
     */
    public String getReplevyReason(){
        return replevyReason;
    }

    /**
     * ��������׷��;�������ݣ�
     * @param replevyWay �����õ�����׷��;�������ݣ���ֵ
     */
    public void setReplevyWay(String replevyWay){
        this.replevyWay = StringUtils.rightTrim(replevyWay);
    }

    /**
     * ��ȡ����׷��;�������ݣ�
     * @return ����׷��;�������ݣ���ֵ
     */
    public String getReplevyWay(){
        return replevyWay;
    }

    /**
     * ��������׷������
     * @param reclaimDate �����õ�����׷�����ڵ�ֵ
     */
    public void setReclaimDate(DateTime reclaimDate){
        this.reclaimDate = reclaimDate;
    }

    /**
     * ��ȡ����׷������
     * @return ����׷�����ڵ�ֵ
     */
    public DateTime getReclaimDate(){
        return reclaimDate;
    }

    /**
     * ��������׷������
     * @param validDate �����õ�����׷�����ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ����׷������
     * @return ����׷�����ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
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
     * ����������׷�����
     * @param sumReplevyFee �����õ�������׷������ֵ
     */
    public void setSumReplevyFee(double sumReplevyFee){
        this.sumReplevyFee = sumReplevyFee;
    }

    /**
     * ��ȡ������׷�����
     * @return ������׷������ֵ
     */
    public double getSumReplevyFee(){
        return sumReplevyFee;
    }

    /**
     * ����������׷�ؽ��
     * @param sumValidFee �����õ�������׷�ؽ���ֵ
     */
    public void setSumValidFee(double sumValidFee){
        this.sumValidFee = sumValidFee;
    }

    /**
     * ��ȡ������׷�ؽ��
     * @return ������׷�ؽ���ֵ
     */
    public double getSumValidFee(){
        return sumValidFee;
    }

    /**
     * ��������̯����ʽ
--** 1��׷���� 
--** 2�������
--** 9������
     * @param amortizeWay �����õ�����̯����ʽ
--** 1��׷���� 
--** 2�������
--** 9��������ֵ
     */
    public void setAmortizeWay(String amortizeWay){
        this.amortizeWay = StringUtils.rightTrim(amortizeWay);
    }

    /**
     * ��ȡ����̯����ʽ
--** 1��׷���� 
--** 2�������
--** 9������
     * @return ����̯����ʽ
--** 1��׷���� 
--** 2�������
--** 9��������ֵ
     */
    public String getAmortizeWay(){
        return amortizeWay;
    }

    /**
     * ������������Ǽǻ�������
     * @param makeCom �����õ���������Ǽǻ��������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ��������Ǽǻ�������
     * @return ��������Ǽǻ��������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * ��������ҵ���������
     * @param comCode �����õ�����ҵ�����������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ���������
     * @return ����ҵ�����������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Ը����˴���
     * @param approverCode �����õ����Ը����˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ���Ը����˴���
     * @return ���Ը����˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * �������Ծ����˴���
     * @param handlerCode �����õ����Ծ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Ծ����˴���
     * @return ���Ծ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Թ���ҵ��Ա����
     * @param handler1Code �����õ����Թ���ҵ��Ա�����ֵ
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * ��ȡ���Թ���ҵ��Ա����
     * @return ���Թ���ҵ��Ա�����ֵ
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * ��������ͳ������
     * @param statisticsYM �����õ�����ͳ�����µ�ֵ
     */
    public void setStatisticsYM(DateTime statisticsYM){
        this.statisticsYM = statisticsYM;
    }

    /**
     * ��ȡ����ͳ������
     * @return ����ͳ�����µ�ֵ
     */
    public DateTime getStatisticsYM(){
        return statisticsYM;
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
     * ����������������
     * @param inputDate �����õ������������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Խ᰸����
     * @param endCaseDate �����õ����Խ᰸���ڵ�ֵ
     */
    public void setEndCaseDate(DateTime endCaseDate){
        this.endCaseDate = endCaseDate;
    }

    /**
     * ��ȡ���Խ᰸����
     * @return ���Խ᰸���ڵ�ֵ
     */
    public DateTime getEndCaseDate(){
        return endCaseDate;
    }

    /**
     * �������Խ᰸Ա����
     * @param endCaseCode �����õ����Խ᰸Ա�����ֵ
     */
    public void setEndCaseCode(String endCaseCode){
        this.endCaseCode = StringUtils.rightTrim(endCaseCode);
    }

    /**
     * ��ȡ���Խ᰸Ա����
     * @return ���Խ᰸Ա�����ֵ
     */
    public String getEndCaseCode(){
        return endCaseCode;
    }

    /**
     * ��������ע������
     * @param cancelDate �����õ�����ע�����ڵ�ֵ
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * ��ȡ����ע������
     * @return ����ע�����ڵ�ֵ
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * ��������ע��ԭ��
     * @param cancelReason �����õ�����ע��ԭ���ֵ
     */
    public void setCancelReason(String cancelReason){
        this.cancelReason = StringUtils.rightTrim(cancelReason);
    }

    /**
     * ��ȡ����ע��ԭ��
     * @return ����ע��ԭ���ֵ
     */
    public String getCancelReason(){
        return cancelReason;
    }

    /**
     * ��������ע���˴���
     * @param dealerCode �����õ�����ע���˴����ֵ
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * ��ȡ����ע���˴���
     * @return ����ע���˴����ֵ
     */
    public String getDealerCode(){
        return dealerCode;
    }

    /**
     * �������Ա�ע
     * @param note �����õ����Ա�ע��ֵ
     */
    public void setNote(String note){
        this.note = StringUtils.rightTrim(note);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getNote(){
        return note;
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
