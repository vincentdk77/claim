
package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcompensate-�������������ݴ���������<br>
 * ������ 2005-05-26 09:04:12.562<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcompensatetgDtoBase implements Serializable{
    /** ��������������� */
    private String compensateNo = "";
    /** ������������(L-���� D-������) */
    private String lFlag = "";
    /** �����ⰸ�� */
    private String caseNo = "";
    /** ���Դ��� */
    private int times = 0;
    /** ����������� */
    private String classCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������������ֶ� */
    private String deductCond = "";
    /** �����յ����� */
    private DateTime preserveDate = new DateTime();
    /** ������������˴��� */
    private String checkAgentCode = "";
    /** ����������������� */
    private String checkAgentName = "";
    /** ���Լ��������� */
    private String surveyorName = "";
    /** �������������� */
    private String counterClaimerName = "";
    /** ���Ժ������� */
    private String dutyDescription = "";
    /** ���Աұ����(�ִ�:CNY) */
    private String currency = "";
    /** ���Ա����ʧ���(ͬ�����ұ�) */
    private double sumLoss = 0d;
    /** ����������(ͬ�����ұ�) */
    private double sumRest = 0d;
    /** �����������ϼ�(ͬ�����ұ�)
--** = PrpLloss�������ϼ�
--** + PrpLcharge�������ķ��úϼ� */
    private double sumDutyPaid = 0d;
    /** ���Բ��������ķ��ý��(ͬ�����ұ�) */
    private double sumNoDutyFee = 0d;
    /** �������⸶���(ͬ�����ұ�) */
    private double sumPaid = 0d;
    /** ������Ԥ�����(ͬ�����ұ�)--** ��һ�ż�����
--** =SUM(PrpLprepay.SumPrePaid)
--** �ڶ��ź���=0 */
    private double sumPrePaid = 0d;
    /** ���Ա����⸶��ͬ�����ұ�
--** = SumPaid-SumPrePaid */
    private double sumThisPaid = 0d;
    /** ��������λ/������/������ */
    private String receiverName = "";
    /** ���Կ������� */
    private String bank = "";
    /** ���������ʺ� */
    private String account = "";
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
    /** ���Ժ����־--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������) */
    private String underWriteFlag = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���԰������� */
    private String caseType = "";
    /** �������α��� */
    private double indemnityDutyRate = 0d;
    /** �����⳥���δ��� */
    private String indemnityDuty = "";
    /** �������ռ������־ */
    private String finallyFlag = "";
    /** ������� */
    private String result = "";
    /** ����ƽ̨�ϴ���� **/
    private String uploadSerialNo = "";
    /** ����ҵ���⸶���� **/
    private String coinsPaidLossType = "";
    /** ����ҵ���⸶�ܽ�� **/
    private double coinsSumPaid = 0d;
    
    //�Ƿ����⹫ʾ
    private String claimNotification = "";
    //�Ƿ��޹���������
    private String InncentTreatment = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcompensatetgDtoBase����
     */
    public PrpLcompensatetgDtoBase(){
    }

    /**
     * �������������������
     * @param compensateNo �����õ�����������������ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ���������������
     * @return ����������������ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ����������������(L-���� D-������)
     * @param lFlag �����õ�������������(L-���� D-������)��ֵ
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * ��ȡ������������(L-���� D-������)
     * @return ������������(L-���� D-������)��ֵ
     */
    public String getLFlag(){
        return lFlag;
    }

    /**
     * ���������ⰸ��
     * @param caseNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getCaseNo(){
        return caseNo;
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
     * ���������������
     * @param classCode �����õ�������������ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * �����������������ֶ�
     * @param deductCond �����õ��������������ֶε�ֵ
     */
    public void setDeductCond(String deductCond){
        this.deductCond = StringUtils.rightTrim(deductCond);
    }

    /**
     * ��ȡ�������������ֶ�
     * @return �������������ֶε�ֵ
     */
    public String getDeductCond(){
        return deductCond;
    }

    /**
     * ���������յ�����
     * @param preserveDate �����õ������յ����ڵ�ֵ
     */
    public void setPreserveDate(DateTime preserveDate){
        this.preserveDate = preserveDate;
    }

    /**
     * ��ȡ�����յ�����
     * @return �����յ����ڵ�ֵ
     */
    public DateTime getPreserveDate(){
        return preserveDate;
    }

    /**
     * ����������������˴���
     * @param checkAgentCode �����õ�������������˴����ֵ
     */
    public void setCheckAgentCode(String checkAgentCode){
        this.checkAgentCode = StringUtils.rightTrim(checkAgentCode);
    }

    /**
     * ��ȡ������������˴���
     * @return ������������˴����ֵ
     */
    public String getCheckAgentCode(){
        return checkAgentCode;
    }

    /**
     * ���������������������
     * @param checkAgentName �����õ�����������������Ƶ�ֵ
     */
    public void setCheckAgentName(String checkAgentName){
        this.checkAgentName = StringUtils.rightTrim(checkAgentName);
    }

    /**
     * ��ȡ�����������������
     * @return ����������������Ƶ�ֵ
     */
    public String getCheckAgentName(){
        return checkAgentName;
    }

    /**
     * �������Լ���������
     * @param surveyorName �����õ����Լ��������Ƶ�ֵ
     */
    public void setSurveyorName(String surveyorName){
        this.surveyorName = StringUtils.rightTrim(surveyorName);
    }

    /**
     * ��ȡ���Լ���������
     * @return ���Լ��������Ƶ�ֵ
     */
    public String getSurveyorName(){
        return surveyorName;
    }

    /**
     * ������������������
     * @param counterClaimerName �����õ��������������Ƶ�ֵ
     */
    public void setCounterClaimerName(String counterClaimerName){
        this.counterClaimerName = StringUtils.rightTrim(counterClaimerName);
    }

    /**
     * ��ȡ��������������
     * @return �������������Ƶ�ֵ
     */
    public String getCounterClaimerName(){
        return counterClaimerName;
    }

    /**
     * �������Ժ�������
     * @param dutyDescription �����õ����Ժ������ε�ֵ
     */
    public void setDutyDescription(String dutyDescription){
        this.dutyDescription = StringUtils.rightTrim(dutyDescription);
    }

    /**
     * ��ȡ���Ժ�������
     * @return ���Ժ������ε�ֵ
     */
    public String getDutyDescription(){
        return dutyDescription;
    }

    /**
     * �������Աұ����(�ִ�:CNY)
     * @param currency �����õ����Աұ����(�ִ�:CNY)��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����(�ִ�:CNY)
     * @return ���Աұ����(�ִ�:CNY)��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ա����ʧ���(ͬ�����ұ�)
     * @param sumLoss �����õ����Ա����ʧ���(ͬ�����ұ�)��ֵ
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * ��ȡ���Ա����ʧ���(ͬ�����ұ�)
     * @return ���Ա����ʧ���(ͬ�����ұ�)��ֵ
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * ��������������(ͬ�����ұ�)
     * @param sumRest �����õ�����������(ͬ�����ұ�)��ֵ
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * ��ȡ����������(ͬ�����ұ�)
     * @return ����������(ͬ�����ұ�)��ֵ
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * ���������������ϼ�(ͬ�����ұ�)
--** = PrpLloss�������ϼ�
--** + PrpLcharge�������ķ��úϼ�
     * @param sumDutyPaid �����õ������������ϼ�(ͬ�����ұ�)
--** = PrpLloss�������ϼ�
--** + PrpLcharge�������ķ��úϼƵ�ֵ
     */
    public void setSumDutyPaid(double sumDutyPaid){
        this.sumDutyPaid = sumDutyPaid;
    }

    /**
     * ��ȡ�����������ϼ�(ͬ�����ұ�)
--** = PrpLloss�������ϼ�
--** + PrpLcharge�������ķ��úϼ�
     * @return �����������ϼ�(ͬ�����ұ�)
--** = PrpLloss�������ϼ�
--** + PrpLcharge�������ķ��úϼƵ�ֵ
     */
    public double getSumDutyPaid(){
        return sumDutyPaid;
    }

    /**
     * �������Բ��������ķ��ý��(ͬ�����ұ�)
     * @param sumNoDutyFee �����õ����Բ��������ķ��ý��(ͬ�����ұ�)��ֵ
     */
    public void setSumNoDutyFee(double sumNoDutyFee){
        this.sumNoDutyFee = sumNoDutyFee;
    }

    /**
     * ��ȡ���Բ��������ķ��ý��(ͬ�����ұ�)
     * @return ���Բ��������ķ��ý��(ͬ�����ұ�)��ֵ
     */
    public double getSumNoDutyFee(){
        return sumNoDutyFee;
    }

    /**
     * �����������⸶���(ͬ�����ұ�)
     * @param sumPaid �����õ��������⸶���(ͬ�����ұ�)��ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ�������⸶���(ͬ�����ұ�)
     * @return �������⸶���(ͬ�����ұ�)��ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }

    /**
     * ����������Ԥ�����(ͬ�����ұ�)--** ��һ�ż�����
--** =SUM(PrpLprepay.SumPrePaid)
--** �ڶ��ź���=0
     * @param sumPrePaid �����õ�������Ԥ�����(ͬ�����ұ�)--** ��һ�ż�����
--** =SUM(PrpLprepay.SumPrePaid)
--** �ڶ��ź���=0��ֵ
     */
    public void setSumPrePaid(double sumPrePaid){
        this.sumPrePaid = sumPrePaid;
    }

    /**
     * ��ȡ������Ԥ�����(ͬ�����ұ�)--** ��һ�ż�����
--** =SUM(PrpLprepay.SumPrePaid)
--** �ڶ��ź���=0
     * @return ������Ԥ�����(ͬ�����ұ�)--** ��һ�ż�����
--** =SUM(PrpLprepay.SumPrePaid)
--** �ڶ��ź���=0��ֵ
     */
    public double getSumPrePaid(){
        return sumPrePaid;
    }

    /**
     * �������Ա����⸶��ͬ�����ұ�
--** = SumPaid-SumPrePaid
     * @param sumThisPaid �����õ����Ա����⸶��ͬ�����ұ�
--** = SumPaid-SumPrePaid��ֵ
     */
    public void setSumThisPaid(double sumThisPaid){
        this.sumThisPaid = sumThisPaid;
    }

    /**
     * ��ȡ���Ա����⸶��ͬ�����ұ�
--** = SumPaid-SumPrePaid
     * @return ���Ա����⸶��ͬ�����ұ�
--** = SumPaid-SumPrePaid��ֵ
     */
    public double getSumThisPaid(){
        return sumThisPaid;
    }

    /**
     * ������������λ/������/������
     * @param receiverName �����õ���������λ/������/�����˵�ֵ
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * ��ȡ��������λ/������/������
     * @return ��������λ/������/�����˵�ֵ
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * �������Կ�������
     * @param bank �����õ����Կ������е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Կ�������
     * @return ���Կ������е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * �������������ʺ�
     * @param account �����õ����������ʺŵ�ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ���������ʺ�
     * @return ���������ʺŵ�ֵ
     */
    public String getAccount(){
        return account;
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
     * �������Ժ����־--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)
     * @param underWriteFlag �����õ����Ժ����־--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ���Ժ����־--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)
     * @return ���Ժ����־--** (0��ʼֵ/1ͨ��/2��ͨ��/3 ������� 9������)��ֵ
     */
    public String getUnderWriteFlag(){
        return underWriteFlag;
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

    /**
     * �������԰�������
     * @param caseType �����õ����԰������ʵ�ֵ
     */
    public void setCaseType(String caseType){
        this.caseType = StringUtils.rightTrim(caseType);
    }

    /**
     * ��ȡ���԰�������
     * @return ���԰������ʵ�ֵ
     */
    public String getCaseType(){
        return caseType;
    }

    /**
     * �����������α���
     * @param indemnityDutyRate �����õ��������α�����ֵ
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * ��ȡ�������α���
     * @return �������α�����ֵ
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * ���������⳥���δ���
     * @param indemnityDuty �����õ������⳥���δ����ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ���
     * @return �����⳥���δ����ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * �����������ռ������־
     * @param finallyFlag �����õ��������ռ������־��ֵ
     */
    public void setFinallyFlag(String finallyFlag){
        this.finallyFlag = StringUtils.rightTrim(finallyFlag);
    }

    /**
     * ��ȡ�������ռ������־
     * @return �������ռ������־��ֵ
     */
    public String getFinallyFlag(){
        return finallyFlag;
    }
    /**
     * �����������
     * @param result �������
     */
    
    public void setResult(String result){
        this.result = result;
    }

    /**
     * ��ȡ�������
     * @return �������
     */
    public String getResult(){
        return this.result;
    }

	public String getUploadSerialNo() {
		return uploadSerialNo;
	}

	public void setUploadSerialNo(String uploadSerialNo) {
		this.uploadSerialNo = uploadSerialNo;
	}
    /**
     * ��ȡ���Թ���ҵ���⸶����
     * @return ���Թ���ҵ���⸶����
     */
	public String getCoinsPaidLossType() {
		return coinsPaidLossType;
	}
    /**
     * �������Թ���ҵ���⸶����
     * @param finallyFlag �����õ����Թ���ҵ���⸶����
     */
	public void setCoinsPaidLossType(String coinsPaidLossType) {
		this.coinsPaidLossType = StringUtils.rightTrim(coinsPaidLossType);
	}
    /**
     * ��ȡ���Թ���ҵ���⸶���
     * @return ���Թ���ҵ���⸶���
     */
	public double getCoinsSumPaid() {
		return coinsSumPaid;
	}
    /**
     * �������Թ���ҵ���⸶���
     * @param finallyFlag �����õ����Թ���ҵ���⸶���
     */
	public void setCoinsSumPaid(double coinsSumPaid) {
		this.coinsSumPaid = coinsSumPaid;
	}

	/**
	 * @return the claimNotification
	 */
	public String getClaimNotification() {
		return claimNotification;
	}

	/**
	 * @param claimNotification the claimNotification to set
	 */
	public void setClaimNotification(String claimNotification) {
		this.claimNotification = claimNotification;
	}

	/**
	 * @return the inncentTreatment
	 */
	public String getInncentTreatment() {
		return InncentTreatment;
	}

	/**
	 * @param inncentTreatment the inncentTreatment to set
	 */
	public void setInncentTreatment(String inncentTreatment) {
		InncentTreatment = inncentTreatment;
	}
    
}
