package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyCollect����֤�ռ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcertifyCollectDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ҵ����� */
    private String businessNo = "";
    /** ���Ա�Ĵ��� */
    private String lossItemCode = "";
    /** ���Ա������ */
    private String lossItemName = "";
    /** ���Ե�֤���� */
    private int picCount = 0;
    /** ���Ե�֤��ʼ�ռ����� */
    private DateTime startDate = new DateTime();
    /** ���Ե�֤��ʼ�ռ�Сʱ */
    private String startHour = "";
    /** ���Ե�֤�����ռ����� */
    private DateTime endDate = new DateTime();
    /** ���Ե�֤�����ռ�Сʱ */
    private String endHour = "";
    /** ���Բ���Ա */
    private String operatorCode = "";
    /** �����ռ���־ */
    private String collectFlag = "";
    /** ���������ռ���־ */
    private String cltInsureCarFlag = "";
    /** �������߳��ռ���־ */
    private String cltThirdCarFlag = "";
    /** ���������ռ���־ */
    private String cltPersonFlag = "";
    /** ���������ռ���־ */
    private String cltPropFlag = "";
    /** ���Ե����ռ���־ */
    private String cltCarLossFlag = "";
    /** ����ȫ���ռ���־ */
    private String cltAllLossFlag = "";
    /** ���Դ���¹����� */
    private String caseFlag = "";
    /** ���԰���������� */
    private String content = "";
    /** ���Ա�־λ */
    private String flag = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������ */
    private String uploadYear = "";
    /** ����ǿ�Ʊ����ռ���־ */
    private String compelFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyCollectDtoBase����
     */
    public PrpLcertifyCollectDtoBase(){
    }

    /**
     * ��������ҵ�����
     * @param businessNo �����õ�����ҵ������ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����ҵ�����
     * @return ����ҵ������ֵ
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * �������Ա�Ĵ���
     * @param lossItemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Ա������
     * @param lossItemName �����õ����Ա�����Ƶ�ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Ա������
     * @return ���Ա�����Ƶ�ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * �������Ե�֤����
     * @param picCount �����õ����Ե�֤������ֵ
     */
    public void setPicCount(int picCount){
        this.picCount = picCount;
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤������ֵ
     */
    public int getPicCount(){
        return picCount;
    }

    /**
     * �������Ե�֤��ʼ�ռ�����
     * @param startDate �����õ����Ե�֤��ʼ�ռ����ڵ�ֵ
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * ��ȡ���Ե�֤��ʼ�ռ�����
     * @return ���Ե�֤��ʼ�ռ����ڵ�ֵ
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * �������Ե�֤��ʼ�ռ�Сʱ
     * @param startHour �����õ����Ե�֤��ʼ�ռ�Сʱ��ֵ
     */
    public void setStartHour(String startHour){
        this.startHour = StringUtils.rightTrim(startHour);
    }

    /**
     * ��ȡ���Ե�֤��ʼ�ռ�Сʱ
     * @return ���Ե�֤��ʼ�ռ�Сʱ��ֵ
     */
    public String getStartHour(){
        return startHour;
    }

    /**
     * �������Ե�֤�����ռ�����
     * @param endDate �����õ����Ե�֤�����ռ����ڵ�ֵ
     */
    public void setEndDate(DateTime endDate){
        this.endDate = endDate;
    }

    /**
     * ��ȡ���Ե�֤�����ռ�����
     * @return ���Ե�֤�����ռ����ڵ�ֵ
     */
    public DateTime getEndDate(){
        return endDate;
    }

    /**
     * �������Ե�֤�����ռ�Сʱ
     * @param endHour �����õ����Ե�֤�����ռ�Сʱ��ֵ
     */
    public void setEndHour(String endHour){
        this.endHour = StringUtils.rightTrim(endHour);
    }

    /**
     * ��ȡ���Ե�֤�����ռ�Сʱ
     * @return ���Ե�֤�����ռ�Сʱ��ֵ
     */
    public String getEndHour(){
        return endHour;
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
     * ���������ռ���־
     * @param collectFlag �����õ������ռ���־��ֵ
     */
    public void setCollectFlag(String collectFlag){
        this.collectFlag = StringUtils.rightTrim(collectFlag);
    }

    /**
     * ��ȡ�����ռ���־
     * @return �����ռ���־��ֵ
     */
    public String getCollectFlag(){
        return collectFlag;
    }

    /**
     * �������������ռ���־
     * @param cltInsureCarFlag �����õ����������ռ���־��ֵ
     */
    public void setCltInsureCarFlag(String cltInsureCarFlag){
        this.cltInsureCarFlag = StringUtils.rightTrim(cltInsureCarFlag);
    }

    /**
     * ��ȡ���������ռ���־
     * @return ���������ռ���־��ֵ
     */
    public String getCltInsureCarFlag(){
        return cltInsureCarFlag;
    }

    /**
     * �����������߳��ռ���־
     * @param cltThirdCarFlag �����õ��������߳��ռ���־��ֵ
     */
    public void setCltThirdCarFlag(String cltThirdCarFlag){
        this.cltThirdCarFlag = StringUtils.rightTrim(cltThirdCarFlag);
    }

    /**
     * ��ȡ�������߳��ռ���־
     * @return �������߳��ռ���־��ֵ
     */
    public String getCltThirdCarFlag(){
        return cltThirdCarFlag;
    }

    /**
     * �������������ռ���־
     * @param cltPersonFlag �����õ����������ռ���־��ֵ
     */
    public void setCltPersonFlag(String cltPersonFlag){
        this.cltPersonFlag = StringUtils.rightTrim(cltPersonFlag);
    }

    /**
     * ��ȡ���������ռ���־
     * @return ���������ռ���־��ֵ
     */
    public String getCltPersonFlag(){
        return cltPersonFlag;
    }

    /**
     * �������������ռ���־
     * @param cltPropFlag �����õ����������ռ���־��ֵ
     */
    public void setCltPropFlag(String cltPropFlag){
        this.cltPropFlag = StringUtils.rightTrim(cltPropFlag);
    }

    /**
     * ��ȡ���������ռ���־
     * @return ���������ռ���־��ֵ
     */
    public String getCltPropFlag(){
        return cltPropFlag;
    }

    /**
     * �������Ե����ռ���־
     * @param cltCarLossFlag �����õ����Ե����ռ���־��ֵ
     */
    public void setCltCarLossFlag(String cltCarLossFlag){
        this.cltCarLossFlag = StringUtils.rightTrim(cltCarLossFlag);
    }

    /**
     * ��ȡ���Ե����ռ���־
     * @return ���Ե����ռ���־��ֵ
     */
    public String getCltCarLossFlag(){
        return cltCarLossFlag;
    }

    /**
     * ��������ȫ���ռ���־
     * @param cltAllLossFlag �����õ�����ȫ���ռ���־��ֵ
     */
    public void setCltAllLossFlag(String cltAllLossFlag){
        this.cltAllLossFlag = StringUtils.rightTrim(cltAllLossFlag);
    }

    /**
     * ��ȡ����ȫ���ռ���־
     * @return ����ȫ���ռ���־��ֵ
     */
    public String getCltAllLossFlag(){
        return cltAllLossFlag;
    }

    /**
     * �������Դ���¹�����
     * @param caseFlag �����õ����Դ���¹����͵�ֵ
     */
    public void setCaseFlag(String caseFlag){
        this.caseFlag = StringUtils.rightTrim(caseFlag);
    }

    /**
     * ��ȡ���Դ���¹�����
     * @return ���Դ���¹����͵�ֵ
     */
    public String getCaseFlag(){
        return caseFlag;
    }

    /**
     * �������԰����������
     * @param content �����õ����԰������������ֵ
     */
    public void setContent(String content){
        this.content = StringUtils.rightTrim(content);
    }

    /**
     * ��ȡ���԰����������
     * @return ���԰������������ֵ
     */
    public String getContent(){
        return content;
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
     * ����������
     * @param uploadYear �����õ��������ֵ
     */
    public void setUploadYear(String uploadYear){
        this.uploadYear = StringUtils.rightTrim(uploadYear);
    }

    /**
     * ��ȡ������
     * @return �������ֵ
     */
    public String getUploadYear(){
        return uploadYear;
    }

    /**
     * ��������ǿ�Ʊ����ռ���־
     * @param compelFlag �����õ�����ǿ�Ʊ����ռ���־��ֵ
     */
    public void setCompelFlag(String compelFlag){
        this.compelFlag = StringUtils.rightTrim(compelFlag);
    }

    /**
     * ��ȡ����ǿ�Ʊ����ռ���־
     * @return ����ǿ�Ʊ����ռ���־��ֵ
     */
    public String getCompelFlag(){
        return compelFlag;
    }
}
