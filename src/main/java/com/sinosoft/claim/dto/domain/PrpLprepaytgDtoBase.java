package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLprepay-Ԥ��ǼǱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.421<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLprepaytgDtoBase implements Serializable{
    /** ����Ԥ��ǼǺ� */
    private String preCompensateNo = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ��������Ƿ������  DAD */
    private int arrearageTimes = 0;
    /** ��������Ƿ����  DAD */
    private double sumArrearage = 0d;
    /** ������Ԥ���棩����� */
    private double sumBeforePrePaid = 0d;
    /** ���Ա��ε渶����Ƿ������ DAD */
    private int blockUpTimes = 0;
    /** ����Ԥ���� */
    private double sumPrePaid = 0d;
    /** ������Ԥ���棩����� = SumBeforePrePaid+SumPrepaid */
    private double sumTotalPrepaid = 0d;
    /** ���Գ������� */
    private String makeCom = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Թ���ҵ��Ա���� */
    private String handler1Code = "";
    /** ���Ը���Ա���� */
    private String approverCode = "";
    /** �������պ����˴��� */
    private String underWriteCode = "";
    /** �������պ��������� */
    private String underWriteName = "";
    /** ����ͳ������ */
    private DateTime statisticsYM = new DateTime();
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Լ������������ */
    private DateTime inputDate = new DateTime();
    /** ���Ժ���������� */
    private DateTime underWriteEndDate = new DateTime();
    /** ���Ժ����־
--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������) */
    private String underWriteFlag = "";
    /** ���Ա�־�ֶ�
--** [1]���Ƿ�ת���ո���ϵͳ */
    private String flag = "";
    /** ���������ⰸ���� */
    private String caseType = "";
    /** ����ƽ̨�ϴ����**/
    private String uploadSerialNo = "";
    /** ʵ��ʱ��**/
    private DateTime payRefDate = new DateTime();
    /** Ԥ������**/
    private double sumPreChargePaid = 0d;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLprepaytgDtoBase����
     */
    public PrpLprepaytgDtoBase(){
    }

    /**
     * ��������Ԥ��ǼǺ�
     * @param preCompensateNo �����õ�����Ԥ��ǼǺŵ�ֵ
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * ��ȡ����Ԥ��ǼǺ�
     * @return ����Ԥ��ǼǺŵ�ֵ
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ������������Ƿ������  DAD
     * @param arrearageTimes �����õ���������Ƿ������  DAD��ֵ
     */
    public void setArrearageTimes(int arrearageTimes){
        this.arrearageTimes = arrearageTimes;
    }

    /**
     * ��ȡ��������Ƿ������  DAD
     * @return ��������Ƿ������  DAD��ֵ
     */
    public int getArrearageTimes(){
        return arrearageTimes;
    }

    /**
     * ������������Ƿ����  DAD
     * @param sumArrearage �����õ���������Ƿ����  DAD��ֵ
     */
    public void setSumArrearage(double sumArrearage){
        this.sumArrearage = sumArrearage;
    }

    /**
     * ��ȡ��������Ƿ����  DAD
     * @return ��������Ƿ����  DAD��ֵ
     */
    public double getSumArrearage(){
        return sumArrearage;
    }

    /**
     * ����������Ԥ���棩�����
     * @param sumBeforePrePaid �����õ�������Ԥ���棩������ֵ
     */
    public void setSumBeforePrePaid(double sumBeforePrePaid){
        this.sumBeforePrePaid = sumBeforePrePaid;
    }

    /**
     * ��ȡ������Ԥ���棩�����
     * @return ������Ԥ���棩������ֵ
     */
    public double getSumBeforePrePaid(){
        return sumBeforePrePaid;
    }

    /**
     * �������Ա��ε渶����Ƿ������ DAD
     * @param blockUpTimes �����õ����Ա��ε渶����Ƿ������ DAD��ֵ
     */
    public void setBlockUpTimes(int blockUpTimes){
        this.blockUpTimes = blockUpTimes;
    }

    /**
     * ��ȡ���Ա��ε渶����Ƿ������ DAD
     * @return ���Ա��ε渶����Ƿ������ DAD��ֵ
     */
    public int getBlockUpTimes(){
        return blockUpTimes;
    }

    /**
     * ��������Ԥ����
     * @param sumPrePaid �����õ�����Ԥ�����ֵ
     */
    public void setSumPrePaid(double sumPrePaid){
        this.sumPrePaid = sumPrePaid;
    }

    /**
     * ��ȡ����Ԥ����
     * @return ����Ԥ�����ֵ
     */
    public double getSumPrePaid(){
        return sumPrePaid;
    }

    /**
     * ����������Ԥ���棩����� = SumBeforePrePaid+SumPrepaid
     * @param sumTotalPrepaid �����õ�������Ԥ���棩����� = SumBeforePrePaid+SumPrepaid��ֵ
     */
    public void setSumTotalPrepaid(double sumTotalPrepaid){
        this.sumTotalPrepaid = sumTotalPrepaid;
    }

    /**
     * ��ȡ������Ԥ���棩����� = SumBeforePrePaid+SumPrepaid
     * @return ������Ԥ���棩����� = SumBeforePrePaid+SumPrepaid��ֵ
     */
    public double getSumTotalPrepaid(){
        return sumTotalPrepaid;
    }

    /**
     * �������Գ�������
     * @param makeCom �����õ����Գ���������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ���������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * ��������ҵ�������������
     * @param comCode �����õ�����ҵ��������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ�������������
     * @return ����ҵ��������������ֵ
     */
    public String getComCode(){
        return comCode;
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
     * �������Ը���Ա����
     * @param approverCode �����õ����Ը���Ա�����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ���Ը���Ա����
     * @return ���Ը���Ա�����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * �����������պ����˴���
     * @param underWriteCode �����õ��������պ����˴����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ�������պ����˴���
     * @return �������պ����˴����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �����������պ���������
     * @param underWriteName �����õ��������պ��������Ƶ�ֵ
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * ��ȡ�������պ���������
     * @return �������պ��������Ƶ�ֵ
     */
    public String getUnderWriteName(){
        return underWriteName;
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
     * �������Լ������������
     * @param inputDate �����õ����Լ�����������ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���Լ������������
     * @return ���Լ�����������ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * �������Ժ����������
     * @param underWriteEndDate �����õ����Ժ���������ڵ�ֵ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * ��ȡ���Ժ����������
     * @return ���Ժ���������ڵ�ֵ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * �������Ժ����־
--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)
     * @param underWriteFlag �����õ����Ժ����־
--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ���Ժ����־
--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)
     * @return ���Ժ����־
--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)��ֵ
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
    }

    /**
     * �������Ա�־�ֶ�
--** [1]���Ƿ�ת���ո���ϵͳ
     * @param flag �����õ����Ա�־�ֶ�
--** [1]���Ƿ�ת���ո���ϵͳ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
--** [1]���Ƿ�ת���ո���ϵͳ
     * @return ���Ա�־�ֶ�
--** [1]���Ƿ�ת���ո���ϵͳ��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������������ⰸ����
     * @param caseType �����õ����������ⰸ���͵�ֵ
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * ��ȡ���������ⰸ����
     * @return ���������ⰸ���͵�ֵ
     */
    public String getCaseType(){
        return caseType;
    }

	public String getUploadSerialNo() {
		return uploadSerialNo;
	}

	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}

	public DateTime getPayRefDate() {
		return payRefDate;
	}

	public void setPayRefDate(DateTime payRefDate) {
		this.payRefDate = payRefDate;
	}

	public double getSumPreChargePaid() {
		return sumPreChargePaid;
	}

	public void setSumPreChargePaid(double sumPreChargePaid) {
		this.sumPreChargePaid = sumPreChargePaid;
	}
    
    
}
