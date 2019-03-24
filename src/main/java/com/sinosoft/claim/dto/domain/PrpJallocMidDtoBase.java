package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjallocmid������ҵ�񱣷ѷ�̯�м������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJallocMidDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Է�̯�� */
    private String allocNo = "";
    /** ���Ե�֤�� */
    private String certiNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Է�̯������ */
    private int allocSerialNo = 0;
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Ա����˴��� */
    private String insuredCode = "";
    /** ���Ա��������� */
    private String insuredName = "";
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ���Ծ����˴��� */
    private String handlerCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Ա��� */
    private String currency = "";
    /** ���Է�̯���� */
    private String allocType = "";
    /** ������������ */
    private String endorType = "";
    /** ���Գб����� */
    private int limityear = 0;
    /** ���Է�̯��Ч���� */
    private int passYear = 0;
    /** �����ѷ�̯���� */
    private int allocYear = 0;
    /** �����ܱ��� */
    private double sumFee = 0d;
    /** ����ʣ��δ̯���� */
    private double prefee = 0d;
    /** ���Ա��η�̯��� */
    private double allocFee = 0d;
    /** �����ۼƷ�̯���ѣ��������ѱ仯����� */
    private double valueFee = 0d;
    /** ���Է�̯���� */
    private DateTime allocDate = new DateTime();
    /** ���ԵǼ����� */
    private DateTime inputDate = new DateTime();
    /** �����ϴ�ˢ�±仯�Ǽ����� */
    private DateTime olddate = new DateTime();
    /** ����*��־λ */
    private String dealFlag = "";
    /** ����Ԥ��1 */
    private String tcol1 = "";
    /** ����Ԥ��2 */
    private int tcol2 = 0;
    /** ����Ԥ��3 */
    private int tcol3 = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJallocMidDtoBase����
     */
    public PrpJallocMidDtoBase(){
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
     * �������Է�̯��
     * @param allocNo �����õ����Է�̯�ŵ�ֵ
     */
    public void setAllocNo(String allocNo){
        this.allocNo = StringUtils.rightTrim(allocNo);
    }

    /**
     * ��ȡ���Է�̯��
     * @return ���Է�̯�ŵ�ֵ
     */
    public String getAllocNo(){
        return allocNo;
    }

    /**
     * �������Ե�֤��
     * @param certiNo �����õ����Ե�֤�ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤��
     * @return ���Ե�֤�ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
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
     * �������Է�̯������
     * @param allocSerialNo �����õ����Է�̯�����ŵ�ֵ
     */
    public void setAllocSerialNo(int allocSerialNo){
        this.allocSerialNo = allocSerialNo;
    }

    /**
     * ��ȡ���Է�̯������
     * @return ���Է�̯�����ŵ�ֵ
     */
    public int getAllocSerialNo(){
        return allocSerialNo;
    }

    /**
     * ��������������
     * @param startDate �����õ����������ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ����������
     * @return ���������ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * ���������ձ�����
     * @param endDate �����õ������ձ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Ա����˴���
     * @param insuredCode �����õ����Ա����˴����ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ���Ա����˴���
     * @return ���Ա����˴����ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * �������Ա���������
     * @param insuredName �����õ����Ա��������Ƶ�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա���������
     * @return ���Ա��������Ƶ�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Դ����˴���
     * @param agentCode �����õ����Դ����˴����ֵ
     */
    public void setAgentCode(String agentCode){
        this.agentCode = StringUtils.rightTrim(agentCode);
    }

    /**
     * ��ȡ���Դ����˴���
     * @return ���Դ����˴����ֵ
     */
    public String getAgentCode(){
        return agentCode;
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
     * �������Ա���
     * @param currency �����õ����Ա��ֵ�ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��ֵ�ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Է�̯����
     * @param allocType �����õ����Է�̯���͵�ֵ
     */
    public void setAllocType(String allocType){
        this.allocType = StringUtils.rightTrim(allocType);
    }

    /**
     * ��ȡ���Է�̯����
     * @return ���Է�̯���͵�ֵ
     */
    public String getAllocType(){
        return allocType;
    }

    /**
     * ����������������
     * @param endorType �����õ������������͵�ֵ
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * �������Գб�����
     * @param limityear �����õ����Գб����޵�ֵ
     */
    public void setLimityear(int limityear){
        this.limityear = limityear;
    }

    /**
     * ��ȡ���Գб�����
     * @return ���Գб����޵�ֵ
     */
    public int getLimityear(){
        return limityear;
    }

    /**
     * �������Է�̯��Ч����
     * @param passYear �����õ����Է�̯��Ч���޵�ֵ
     */
    public void setPassYear(int passYear){
        this.passYear = passYear;
    }

    /**
     * ��ȡ���Է�̯��Ч����
     * @return ���Է�̯��Ч���޵�ֵ
     */
    public int getPassYear(){
        return passYear;
    }

    /**
     * ���������ѷ�̯����
     * @param allocYear �����õ������ѷ�̯���޵�ֵ
     */
    public void setAllocYear(int allocYear){
        this.allocYear = allocYear;
    }

    /**
     * ��ȡ�����ѷ�̯����
     * @return �����ѷ�̯���޵�ֵ
     */
    public int getAllocYear(){
        return allocYear;
    }

    /**
     * ���������ܱ���
     * @param sumFee �����õ������ܱ��ѵ�ֵ
     */
    public void setSumFee(double sumFee){
        this.sumFee = sumFee;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ��ѵ�ֵ
     */
    public double getSumFee(){
        return sumFee;
    }

    /**
     * ��������ʣ��δ̯����
     * @param prefee �����õ�����ʣ��δ̯���ѵ�ֵ
     */
    public void setPrefee(double prefee){
        this.prefee = prefee;
    }

    /**
     * ��ȡ����ʣ��δ̯����
     * @return ����ʣ��δ̯���ѵ�ֵ
     */
    public double getPrefee(){
        return prefee;
    }

    /**
     * �������Ա��η�̯���
     * @param allocFee �����õ����Ա��η�̯����ֵ
     */
    public void setAllocFee(double allocFee){
        this.allocFee = allocFee;
    }

    /**
     * ��ȡ���Ա��η�̯���
     * @return ���Ա��η�̯����ֵ
     */
    public double getAllocFee(){
        return allocFee;
    }

    /**
     * ���������ۼƷ�̯���ѣ��������ѱ仯�����
     * @param valueFee �����õ������ۼƷ�̯���ѣ��������ѱ仯������ֵ
     */
    public void setValueFee(double valueFee){
        this.valueFee = valueFee;
    }

    /**
     * ��ȡ�����ۼƷ�̯���ѣ��������ѱ仯�����
     * @return �����ۼƷ�̯���ѣ��������ѱ仯������ֵ
     */
    public double getValueFee(){
        return valueFee;
    }

    /**
     * �������Է�̯����
     * @param allocDate �����õ����Է�̯���ڵ�ֵ
     */
    public void setAllocDate(DateTime allocDate){
        this.allocDate = allocDate;
    }

    /**
     * ��ȡ���Է�̯����
     * @return ���Է�̯���ڵ�ֵ
     */
    public DateTime getAllocDate(){
        return allocDate;
    }

    /**
     * �������ԵǼ�����
     * @param inputDate �����õ����ԵǼ����ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ���ԵǼ�����
     * @return ���ԵǼ����ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ���������ϴ�ˢ�±仯�Ǽ�����
     * @param olddate �����õ������ϴ�ˢ�±仯�Ǽ����ڵ�ֵ
     */
    public void setOlddate(DateTime olddate){
        this.olddate = olddate;
    }

    /**
     * ��ȡ�����ϴ�ˢ�±仯�Ǽ�����
     * @return �����ϴ�ˢ�±仯�Ǽ����ڵ�ֵ
     */
    public DateTime getOlddate(){
        return olddate;
    }

    /**
     * ��������*��־λ
     * @param dealFlag �����õ�����*��־λ��ֵ
     */
    public void setDealFlag(String dealFlag){
        this.dealFlag = StringUtils.rightTrim(dealFlag);
    }

    /**
     * ��ȡ����*��־λ
     * @return ����*��־λ��ֵ
     */
    public String getDealFlag(){
        return dealFlag;
    }

    /**
     * ��������Ԥ��1
     * @param tcol1 �����õ�����Ԥ��1��ֵ
     */
    public void setTcol1(String tcol1){
        this.tcol1 = StringUtils.rightTrim(tcol1);
    }

    /**
     * ��ȡ����Ԥ��1
     * @return ����Ԥ��1��ֵ
     */
    public String getTcol1(){
        return tcol1;
    }

    /**
     * ��������Ԥ��2
     * @param tcol2 �����õ�����Ԥ��2��ֵ
     */
    public void setTcol2(int tcol2){
        this.tcol2 = tcol2;
    }

    /**
     * ��ȡ����Ԥ��2
     * @return ����Ԥ��2��ֵ
     */
    public int getTcol2(){
        return tcol2;
    }

    /**
     * ��������Ԥ��3
     * @param tcol3 �����õ�����Ԥ��3��ֵ
     */
    public void setTcol3(int tcol3){
        this.tcol3 = tcol3;
    }

    /**
     * ��ȡ����Ԥ��3
     * @return ����Ԥ��3��ֵ
     */
    public int getTcol3(){
        return tcol3;
    }
}
