package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLQs_coll��������ͨ�������ܱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLQsCollDtoBase implements Serializable{
    /** ���������κ� */
    private String batchNo = "";
    /** ���Թ�˾����  ���ճб� */
    private String procComCode = "";
    /** ���Թ�˾���� */
    private String procComCName = "";
    /** ���Խ��㵥���κ� */
    private String procNo = "";
    /** ���Դ��ⰸ���� */
    private int checkAgntD1 = 0;
    /** ���Դ��鿱��=���ⰸ������500 */
    private double checkAgntFee1 = 0d;
    /** ���Դ��鰸���� */
    private int checkAgntD2 = 0;
    /** ���Դ��鿱��  =���鰸������300 */
    private double checkAgntFee2 = 0d;
    /** ���Դ��������� */
    private int checkAgntD3 = 0;
    /** ���Դ��鿱��  =������������500 */
    private double checkAgntFee3 = 0d;
    /** ���Դ����� */
    private double claimAgntFee = 0d;
    /** �����˰����� */
    private int refundAgntNo = 0;
    /** �����˰���� */
    private double refundAgntFee = 0d;
    /** ����ʵ�������� */
    private int realPayAgntFee = 0;
    /** ����ʵ�����鿱��С�� */
    private double realCheckAgntFee = 0d;
    /** ����ʵ���ܽ�� */
    private double realPaySumFee = 0d;
    /** ���Ի������� */
    private DateTime balDate = new DateTime();
    /** ������������ */
    private DateTime procDate = new DateTime();
    /** �����������Ա */
    private String operatorCode = "";
    /** ���Թ�˾����  ���� */
    private String comCode = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLQs_collDtoBase����
     */
    public PrpLQsCollDtoBase(){
    }

    /**
     * �������������κ�
     * @param batchNo �����õ����������κŵ�ֵ
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * ��ȡ���������κ�
     * @return ���������κŵ�ֵ
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * �������Թ�˾����  ���ճб�
     * @param procComCode �����õ����Թ�˾����  ���ճб���ֵ
     */
    public void setProcComCode(String procComCode){
        this.procComCode = StringUtils.rightTrim(procComCode);
    }

    /**
     * ��ȡ���Թ�˾����  ���ճб�
     * @return ���Թ�˾����  ���ճб���ֵ
     */
    public String getProcComCode(){
        return procComCode;
    }

    /**
     * �������Թ�˾����
     * @param procComCName �����õ����Թ�˾���Ƶ�ֵ
     */
    public void setProcComCName(String procComCName){
        this.procComCName = StringUtils.rightTrim(procComCName);
    }

    /**
     * ��ȡ���Թ�˾����
     * @return ���Թ�˾���Ƶ�ֵ
     */
    public String getProcComCName(){
        return procComCName;
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
     * �������Դ��ⰸ����
     * @param checkAgntD1 �����õ����Դ��ⰸ������ֵ
     */
    public void setCheckAgntD1(int checkAgntD1){
        this.checkAgntD1 = checkAgntD1;
    }

    /**
     * ��ȡ���Դ��ⰸ����
     * @return ���Դ��ⰸ������ֵ
     */
    public int getCheckAgntD1(){
        return checkAgntD1;
    }

    /**
     * �������Դ��鿱��=���ⰸ������500
     * @param checkAgntFee1 �����õ����Դ��鿱��=���ⰸ������500��ֵ
     */
    public void setCheckAgntFee1(double checkAgntFee1){
        this.checkAgntFee1 = checkAgntFee1;
    }

    /**
     * ��ȡ���Դ��鿱��=���ⰸ������500
     * @return ���Դ��鿱��=���ⰸ������500��ֵ
     */
    public double getCheckAgntFee1(){
        return checkAgntFee1;
    }

    /**
     * �������Դ��鰸����
     * @param checkAgntD2 �����õ����Դ��鰸������ֵ
     */
    public void setCheckAgntD2(int checkAgntD2){
        this.checkAgntD2 = checkAgntD2;
    }

    /**
     * ��ȡ���Դ��鰸����
     * @return ���Դ��鰸������ֵ
     */
    public int getCheckAgntD2(){
        return checkAgntD2;
    }

    /**
     * �������Դ��鿱��  =���鰸������300
     * @param checkAgntFee2 �����õ����Դ��鿱��  =���鰸������300��ֵ
     */
    public void setCheckAgntFee2(double checkAgntFee2){
        this.checkAgntFee2 = checkAgntFee2;
    }

    /**
     * ��ȡ���Դ��鿱��  =���鰸������300
     * @return ���Դ��鿱��  =���鰸������300��ֵ
     */
    public double getCheckAgntFee2(){
        return checkAgntFee2;
    }

    /**
     * �������Դ���������
     * @param checkAgntD3 �����õ����Դ�����������ֵ
     */
    public void setCheckAgntD3(int checkAgntD3){
        this.checkAgntD3 = checkAgntD3;
    }

    /**
     * ��ȡ���Դ���������
     * @return ���Դ�����������ֵ
     */
    public int getCheckAgntD3(){
        return checkAgntD3;
    }

    /**
     * �������Դ��鿱��  =������������500
     * @param checkAgntFee3 �����õ����Դ��鿱��  =������������500��ֵ
     */
    public void setCheckAgntFee3(double checkAgntFee3){
        this.checkAgntFee3 = checkAgntFee3;
    }

    /**
     * ��ȡ���Դ��鿱��  =������������500
     * @return ���Դ��鿱��  =������������500��ֵ
     */
    public double getCheckAgntFee3(){
        return checkAgntFee3;
    }

    /**
     * �������Դ�����
     * @param claimAgntFee �����õ����Դ������ֵ
     */
    public void setClaimAgntFee(double claimAgntFee){
        this.claimAgntFee = claimAgntFee;
    }

    /**
     * ��ȡ���Դ�����
     * @return ���Դ������ֵ
     */
    public double getClaimAgntFee(){
        return claimAgntFee;
    }

    /**
     * ���������˰�����
     * @param refundAgntNo �����õ������˰�������ֵ
     */
    public void setRefundAgntNo(int refundAgntNo){
        this.refundAgntNo = refundAgntNo;
    }

    /**
     * ��ȡ�����˰�����
     * @return �����˰�������ֵ
     */
    public int getRefundAgntNo(){
        return refundAgntNo;
    }

    /**
     * ���������˰����
     * @param refundAgntFee �����õ������˰�����ֵ
     */
    public void setRefundAgntFee(double refundAgntFee){
        this.refundAgntFee = refundAgntFee;
    }

    /**
     * ��ȡ�����˰����
     * @return �����˰�����ֵ
     */
    public double getRefundAgntFee(){
        return refundAgntFee;
    }

    /**
     * ��������ʵ��������
     * @param realPayAgntFee �����õ�����ʵ����������ֵ
     */
    public void setRealPayAgntFee(int realPayAgntFee){
        this.realPayAgntFee = realPayAgntFee;
    }

    /**
     * ��ȡ����ʵ��������
     * @return ����ʵ����������ֵ
     */
    public int getRealPayAgntFee(){
        return realPayAgntFee;
    }

    /**
     * ��������ʵ�����鿱��С��
     * @param realCheckAgntFee �����õ�����ʵ�����鿱��С�Ƶ�ֵ
     */
    public void setRealCheckAgntFee(double realCheckAgntFee){
        this.realCheckAgntFee = realCheckAgntFee;
    }

    /**
     * ��ȡ����ʵ�����鿱��С��
     * @return ����ʵ�����鿱��С�Ƶ�ֵ
     */
    public double getRealCheckAgntFee(){
        return realCheckAgntFee;
    }

    /**
     * ��������ʵ���ܽ��
     * @param realPaySumFee �����õ�����ʵ���ܽ���ֵ
     */
    public void setRealPaySumFee(double realPaySumFee){
        this.realPaySumFee = realPaySumFee;
    }

    /**
     * ��ȡ����ʵ���ܽ��
     * @return ����ʵ���ܽ���ֵ
     */
    public double getRealPaySumFee(){
        return realPaySumFee;
    }

    /**
     * �������Ի�������
     * @param balDate �����õ����Ի������ڵ�ֵ
     */
    public void setBalDate(DateTime balDate){
        this.balDate = balDate;
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������ڵ�ֵ
     */
    public DateTime getBalDate(){
        return balDate;
    }

    /**
     * ����������������
     * @param procDate �����õ������������ڵ�ֵ
     */
    public void setProcDate(DateTime procDate){
        this.procDate = procDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getProcDate(){
        return procDate;
    }

    /**
     * ���������������Ա
     * @param operatorCode �����õ������������Ա��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ�����������Ա
     * @return �����������Ա��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Թ�˾����  ����
     * @param comCode �����õ����Թ�˾����  �����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�˾����  ����
     * @return ���Թ�˾����  �����ֵ
     */
    public String getComCode(){
        return comCode;
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
