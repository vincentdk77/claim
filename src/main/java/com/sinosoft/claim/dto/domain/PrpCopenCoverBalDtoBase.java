package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcopencoverbalЭ������¼������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCopenCoverBalDtoBase implements Serializable{
    /** ���������� */
    private String endorseNo = "";
    /** ����Э��� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ����˳��� */
    private int serialNo = 0;
    /** ���Ա��ν��㷢���ǼǱ��� */
    private double sendPremium = 0d;
    /** ���Ա��ν��㷢���ǼǱ��� */
    private double sendAmount = 0d;
    /** ���Ա��ν�����¼�뱣�� */
    private double oneByOnePremium = 0d;
    /** ���Ա��ν�����¼�뱣��1 */
    private double oneByOneAmount = 0d;
    /** ���Ա��ν����ѽ����� */
    private double paidPremium = 0d;
    /** ���Ա��ν����ѽ�����1 */
    private double paidAmount = 0d;
    /** ���Ա��ν������ո���ϵͳ���� */
    private double sffPremium = 0d;
    /** ���Ա��ν���δ���ո���ϵͳ���� */
    private double unSffPremium = 0d;
    /** ���Դ߽ɽ�� */
    private double duePremium = 0d;
    /** ���Խ������� */
    private DateTime balanceDate = new DateTime();
    /** ���Աұ� */
    private String currency = "";
    /** ���Խ��㱣�� */
    private double balancePremium = 0d;
    /** ���Խ��㱣�� */
    private double balanceAmount = 0d;
    /** ���Թ��ڽ������ */
    private double domesticRate = 0d;
    /** ���Թ��ڽ����� */
    private double domesticPremium = 0d;
    /** ���Խ��ڽ������ */
    private double importRate = 0d;
    /** ���Խ��ڽ����� */
    private double importPremium = 0d;
    /** ���Գ��ڸ۰Ľ������ */
    private double hkRate = 0d;
    /** ���Գ��ڸ۰Ľ����� */
    private double hkPremium = 0d;
    /** ���Գ���Զ�������� */
    private double oceanRate = 0d;
    /** ���Գ���Զ������� */
    private double oceanPremium = 0d;
    /** ���Բ���Ա */
    private String operatorCode = "";
    /** ���Ի������� */
    private String comCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCopenCoverBalDtoBase����
     */
    public PrpCopenCoverBalDtoBase(){
    }

    /**
     * ��������������
     * @param endorseNo �����õ����������ŵ�ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * ��������Э���
     * @param policyNo �����õ�����Э��ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����Э���
     * @return ����Э��ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * ��������˳���
     * @param serialNo �����õ�����˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����˳���
     * @return ����˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա��ν��㷢���ǼǱ���
     * @param sendPremium �����õ����Ա��ν��㷢���ǼǱ��ѵ�ֵ
     */
    public void setSendPremium(double sendPremium){
        this.sendPremium = sendPremium;
    }

    /**
     * ��ȡ���Ա��ν��㷢���ǼǱ���
     * @return ���Ա��ν��㷢���ǼǱ��ѵ�ֵ
     */
    public double getSendPremium(){
        return sendPremium;
    }

    /**
     * �������Ա��ν��㷢���ǼǱ���
     * @param sendAmount �����õ����Ա��ν��㷢���ǼǱ����ֵ
     */
    public void setSendAmount(double sendAmount){
        this.sendAmount = sendAmount;
    }

    /**
     * ��ȡ���Ա��ν��㷢���ǼǱ���
     * @return ���Ա��ν��㷢���ǼǱ����ֵ
     */
    public double getSendAmount(){
        return sendAmount;
    }

    /**
     * �������Ա��ν�����¼�뱣��
     * @param oneByOnePremium �����õ����Ա��ν�����¼�뱣�ѵ�ֵ
     */
    public void setOneByOnePremium(double oneByOnePremium){
        this.oneByOnePremium = oneByOnePremium;
    }

    /**
     * ��ȡ���Ա��ν�����¼�뱣��
     * @return ���Ա��ν�����¼�뱣�ѵ�ֵ
     */
    public double getOneByOnePremium(){
        return oneByOnePremium;
    }

    /**
     * �������Ա��ν�����¼�뱣��1
     * @param oneByOneAmount �����õ����Ա��ν�����¼�뱣��1��ֵ
     */
    public void setOneByOneAmount(double oneByOneAmount){
        this.oneByOneAmount = oneByOneAmount;
    }

    /**
     * ��ȡ���Ա��ν�����¼�뱣��1
     * @return ���Ա��ν�����¼�뱣��1��ֵ
     */
    public double getOneByOneAmount(){
        return oneByOneAmount;
    }

    /**
     * �������Ա��ν����ѽ�����
     * @param paidPremium �����õ����Ա��ν����ѽ����ѵ�ֵ
     */
    public void setPaidPremium(double paidPremium){
        this.paidPremium = paidPremium;
    }

    /**
     * ��ȡ���Ա��ν����ѽ�����
     * @return ���Ա��ν����ѽ����ѵ�ֵ
     */
    public double getPaidPremium(){
        return paidPremium;
    }

    /**
     * �������Ա��ν����ѽ�����1
     * @param paidAmount �����õ����Ա��ν����ѽ�����1��ֵ
     */
    public void setPaidAmount(double paidAmount){
        this.paidAmount = paidAmount;
    }

    /**
     * ��ȡ���Ա��ν����ѽ�����1
     * @return ���Ա��ν����ѽ�����1��ֵ
     */
    public double getPaidAmount(){
        return paidAmount;
    }

    /**
     * �������Ա��ν������ո���ϵͳ����
     * @param sffPremium �����õ����Ա��ν������ո���ϵͳ���ѵ�ֵ
     */
    public void setSffPremium(double sffPremium){
        this.sffPremium = sffPremium;
    }

    /**
     * ��ȡ���Ա��ν������ո���ϵͳ����
     * @return ���Ա��ν������ո���ϵͳ���ѵ�ֵ
     */
    public double getSffPremium(){
        return sffPremium;
    }

    /**
     * �������Ա��ν���δ���ո���ϵͳ����
     * @param unSffPremium �����õ����Ա��ν���δ���ո���ϵͳ���ѵ�ֵ
     */
    public void setUnSffPremium(double unSffPremium){
        this.unSffPremium = unSffPremium;
    }

    /**
     * ��ȡ���Ա��ν���δ���ո���ϵͳ����
     * @return ���Ա��ν���δ���ո���ϵͳ���ѵ�ֵ
     */
    public double getUnSffPremium(){
        return unSffPremium;
    }

    /**
     * �������Դ߽ɽ��
     * @param duePremium �����õ����Դ߽ɽ���ֵ
     */
    public void setDuePremium(double duePremium){
        this.duePremium = duePremium;
    }

    /**
     * ��ȡ���Դ߽ɽ��
     * @return ���Դ߽ɽ���ֵ
     */
    public double getDuePremium(){
        return duePremium;
    }

    /**
     * �������Խ�������
     * @param balanceDate �����õ����Խ������ڵ�ֵ
     */
    public void setBalanceDate(DateTime balanceDate){
        this.balanceDate = balanceDate;
    }

    /**
     * ��ȡ���Խ�������
     * @return ���Խ������ڵ�ֵ
     */
    public DateTime getBalanceDate(){
        return balanceDate;
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
     * �������Խ��㱣��
     * @param balancePremium �����õ����Խ��㱣�ѵ�ֵ
     */
    public void setBalancePremium(double balancePremium){
        this.balancePremium = balancePremium;
    }

    /**
     * ��ȡ���Խ��㱣��
     * @return ���Խ��㱣�ѵ�ֵ
     */
    public double getBalancePremium(){
        return balancePremium;
    }

    /**
     * �������Խ��㱣��
     * @param balanceAmount �����õ����Խ��㱣���ֵ
     */
    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }

    /**
     * ��ȡ���Խ��㱣��
     * @return ���Խ��㱣���ֵ
     */
    public double getBalanceAmount(){
        return balanceAmount;
    }

    /**
     * �������Թ��ڽ������
     * @param domesticRate �����õ����Թ��ڽ��������ֵ
     */
    public void setDomesticRate(double domesticRate){
        this.domesticRate = domesticRate;
    }

    /**
     * ��ȡ���Թ��ڽ������
     * @return ���Թ��ڽ��������ֵ
     */
    public double getDomesticRate(){
        return domesticRate;
    }

    /**
     * �������Թ��ڽ�����
     * @param domesticPremium �����õ����Թ��ڽ������ֵ
     */
    public void setDomesticPremium(double domesticPremium){
        this.domesticPremium = domesticPremium;
    }

    /**
     * ��ȡ���Թ��ڽ�����
     * @return ���Թ��ڽ������ֵ
     */
    public double getDomesticPremium(){
        return domesticPremium;
    }

    /**
     * �������Խ��ڽ������
     * @param importRate �����õ����Խ��ڽ��������ֵ
     */
    public void setImportRate(double importRate){
        this.importRate = importRate;
    }

    /**
     * ��ȡ���Խ��ڽ������
     * @return ���Խ��ڽ��������ֵ
     */
    public double getImportRate(){
        return importRate;
    }

    /**
     * �������Խ��ڽ�����
     * @param importPremium �����õ����Խ��ڽ������ֵ
     */
    public void setImportPremium(double importPremium){
        this.importPremium = importPremium;
    }

    /**
     * ��ȡ���Խ��ڽ�����
     * @return ���Խ��ڽ������ֵ
     */
    public double getImportPremium(){
        return importPremium;
    }

    /**
     * �������Գ��ڸ۰Ľ������
     * @param hkRate �����õ����Գ��ڸ۰Ľ��������ֵ
     */
    public void setHkRate(double hkRate){
        this.hkRate = hkRate;
    }

    /**
     * ��ȡ���Գ��ڸ۰Ľ������
     * @return ���Գ��ڸ۰Ľ��������ֵ
     */
    public double getHkRate(){
        return hkRate;
    }

    /**
     * �������Գ��ڸ۰Ľ�����
     * @param hkPremium �����õ����Գ��ڸ۰Ľ������ֵ
     */
    public void setHkPremium(double hkPremium){
        this.hkPremium = hkPremium;
    }

    /**
     * ��ȡ���Գ��ڸ۰Ľ�����
     * @return ���Գ��ڸ۰Ľ������ֵ
     */
    public double getHkPremium(){
        return hkPremium;
    }

    /**
     * �������Գ���Զ��������
     * @param oceanRate �����õ����Գ���Զ����������ֵ
     */
    public void setOceanRate(double oceanRate){
        this.oceanRate = oceanRate;
    }

    /**
     * ��ȡ���Գ���Զ��������
     * @return ���Գ���Զ����������ֵ
     */
    public double getOceanRate(){
        return oceanRate;
    }

    /**
     * �������Գ���Զ�������
     * @param oceanPremium �����õ����Գ���Զ��������ֵ
     */
    public void setOceanPremium(double oceanPremium){
        this.oceanPremium = oceanPremium;
    }

    /**
     * ��ȡ���Գ���Զ�������
     * @return ���Գ���Զ��������ֵ
     */
    public double getOceanPremium(){
        return oceanPremium;
    }

    /**
     * �������Բ���Ա
     * @param operatorCode �����õ����Բ���Ա��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա
     * @return ���Բ���Ա��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
