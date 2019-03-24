package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPTMAINLIAB-�����ձ�����Ϣ�����ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpCmainLiabDtoBase implements Serializable{

    private static final long serialVersionUID = PrpCmainLiabDtoBase.class.getName().hashCode();
    /** ����Ͷ�������� */
    private String proposalNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է������ */
    private String riskKind = "";
    /** ����֤��
--** ְҵ�����գ����֤��
--** �����������գ��������֤��
--** ���幤�̻����գ�Ӫҵִ��
--**ZBB������ʤ�������գ�ҵ��--**                Ӫ���֤���� */
    private String certificateNo = "";
    /** ���Է�֤���� */
    private DateTime certificateDate = new DateTime();
    /** ���Է�֤���� */
    private String certificateDepart = "";
    /** ����BUSINESSCODE */
    private String businessCode = "";
    /** ���Կ�ҵ���� */
    private DateTime practiceDate = new DateTime();
    /** ����Ӫҵ����/��Ҫҵ��Χ */
    private String businessDetail = "";
    /** ����Ӫҵ����
--**ZBB������ʤ�������գ��羰��--**                    ʤ����ַ */
    private String businessSite = "";
    /** ���Գб�����Χ
--**ZBB������ʤ�������գ��羰��--**                    ʤ����� */
    private String insureArea = "";
    /** ������������Χ */
    private String saleArea = "";
    /** ������ʦְҵ�����գ����������� 
--** ҽ�ƻ�������/����������/ */
    private String officeType = "";
    /** ����OFFICEGRADE */
    private String officeGrade = "";
    /** ����׷����ʼ���� */
    private DateTime bkWardStartDate = new DateTime();
    /** ����׷����ֹ���� */
    private DateTime bkWardEndDate = new DateTime();
    /** ����Ա������ */
    private long staffCount = 0L;
    /** ���������Ӫҵ�� */
    private double preTurnOver = 0D;
    /** ���Ա����Ӫҵ��/���۶�
--**ZBB������ʤ�������գ��羰��--**              ʤ���������˴� */
    private double nowTurnOver = 0D;
    /** ���Թ����� */
    private double electricPower = 0D;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpTmainLiabDtoBase����
     */
    public PrpCmainLiabDtoBase(){
    }

    /**
     * ��������Ͷ��������
     * @param proposalNo �����õ�����Ͷ���������ֵ
     */
    public void setPolicyNo(String proposalNo){
        this.proposalNo = StringUtils.rightTrim(proposalNo);
    }

    /**
     * ��ȡ����Ͷ��������
     * @return ����Ͷ���������ֵ
     */
    public String getPolicyNo(){
        return proposalNo;
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
     * �������Է������
     * @param riskKind �����õ����Է�������ֵ
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * ��ȡ���Է������
     * @return ���Է�������ֵ
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * ��������֤��
--** ְҵ�����գ����֤��
--** �����������գ��������֤��
--** ���幤�̻����գ�Ӫҵִ��
--**ZBB������ʤ�������գ�ҵ��--**                Ӫ���֤����
     * @param certificateNo �����õ�����֤��
--** ְҵ�����գ����֤��
--** �����������գ��������֤��
--** ���幤�̻����գ�Ӫҵִ��
--**ZBB������ʤ�������գ�ҵ��--**                Ӫ���֤�����ֵ
     */
    public void setCertificateNo(String certificateNo){
        this.certificateNo = StringUtils.rightTrim(certificateNo);
    }

    /**
     * ��ȡ����֤��
--** ְҵ�����գ����֤��
--** �����������գ��������֤��
--** ���幤�̻����գ�Ӫҵִ��
--**ZBB������ʤ�������գ�ҵ��--**                Ӫ���֤����
     * @return ����֤��
--** ְҵ�����գ����֤��
--** �����������գ��������֤��
--** ���幤�̻����գ�Ӫҵִ��
--**ZBB������ʤ�������գ�ҵ��--**                Ӫ���֤�����ֵ
     */
    public String getCertificateNo(){
        return certificateNo;
    }

    /**
     * �������Է�֤����
     * @param certificateDate �����õ����Է�֤���ڵ�ֵ
     */
    public void setCertificateDate(DateTime certificateDate){
        this.certificateDate = certificateDate;
    }

    /**
     * ��ȡ���Է�֤����
     * @return ���Է�֤���ڵ�ֵ
     */
    public DateTime getCertificateDate(){
        return certificateDate;
    }

    /**
     * �������Է�֤����
     * @param certificateDepart �����õ����Է�֤������ֵ
     */
    public void setCertificateDepart(String certificateDepart){
        this.certificateDepart = StringUtils.rightTrim(certificateDepart);
    }

    /**
     * ��ȡ���Է�֤����
     * @return ���Է�֤������ֵ
     */
    public String getCertificateDepart(){
        return certificateDepart;
    }

    /**
     * ��������BUSINESSCODE
     * @param businessCode �����õ�����BUSINESSCODE��ֵ
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * ��ȡ����BUSINESSCODE
     * @return ����BUSINESSCODE��ֵ
     */
    public String getBusinessCode(){
        return businessCode;
    }

    /**
     * �������Կ�ҵ����
     * @param practiceDate �����õ����Կ�ҵ���ڵ�ֵ
     */
    public void setPracticeDate(DateTime practiceDate){
        this.practiceDate = practiceDate;
    }

    /**
     * ��ȡ���Կ�ҵ����
     * @return ���Կ�ҵ���ڵ�ֵ
     */
    public DateTime getPracticeDate(){
        return practiceDate;
    }

    /**
     * ��������Ӫҵ����/��Ҫҵ��Χ
     * @param businessDetail �����õ�����Ӫҵ����/��Ҫҵ��Χ��ֵ
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * ��ȡ����Ӫҵ����/��Ҫҵ��Χ
     * @return ����Ӫҵ����/��Ҫҵ��Χ��ֵ
     */
    public String getBusinessDetail(){
        return businessDetail;
    }

    /**
     * ��������Ӫҵ����
--**ZBB������ʤ�������գ��羰��--**                    ʤ����ַ
     * @param businessSite �����õ�����Ӫҵ����
--**ZBB������ʤ�������գ��羰��--**                    ʤ����ַ��ֵ
     */
    public void setBusinessSite(String businessSite){
        this.businessSite = StringUtils.rightTrim(businessSite);
    }

    /**
     * ��ȡ����Ӫҵ����
--**ZBB������ʤ�������գ��羰��--**                    ʤ����ַ
     * @return ����Ӫҵ����
--**ZBB������ʤ�������գ��羰��--**                    ʤ����ַ��ֵ
     */
    public String getBusinessSite(){
        return businessSite;
    }

    /**
     * �������Գб�����Χ
--**ZBB������ʤ�������գ��羰��--**                    ʤ�����
     * @param insureArea �����õ����Գб�����Χ
--**ZBB������ʤ�������գ��羰��--**                    ʤ�������ֵ
     */
    public void setInsureArea(String insureArea){
        this.insureArea = StringUtils.rightTrim(insureArea);
    }

    /**
     * ��ȡ���Գб�����Χ
--**ZBB������ʤ�������գ��羰��--**                    ʤ�����
     * @return ���Գб�����Χ
--**ZBB������ʤ�������գ��羰��--**                    ʤ�������ֵ
     */
    public String getInsureArea(){
        return insureArea;
    }

    /**
     * ����������������Χ
     * @param saleArea �����õ�������������Χ��ֵ
     */
    public void setSaleArea(String saleArea){
        this.saleArea = StringUtils.rightTrim(saleArea);
    }

    /**
     * ��ȡ������������Χ
     * @return ������������Χ��ֵ
     */
    public String getSaleArea(){
        return saleArea;
    }

    /**
     * ����������ʦְҵ�����գ����������� 
--** ҽ�ƻ�������/����������/
     * @param officeType �����õ�������ʦְҵ�����գ����������� 
--** ҽ�ƻ�������/����������/��ֵ
     */
    public void setOfficeType(String officeType){
        this.officeType = StringUtils.rightTrim(officeType);
    }

    /**
     * ��ȡ������ʦְҵ�����գ����������� 
--** ҽ�ƻ�������/����������/
     * @return ������ʦְҵ�����գ����������� 
--** ҽ�ƻ�������/����������/��ֵ
     */
    public String getOfficeType(){
        return officeType;
    }

    /**
     * ��������OFFICEGRADE
     * @param officeGrade �����õ�����OFFICEGRADE��ֵ
     */
    public void setOfficeGrade(String officeGrade){
        this.officeGrade = StringUtils.rightTrim(officeGrade);
    }

    /**
     * ��ȡ����OFFICEGRADE
     * @return ����OFFICEGRADE��ֵ
     */
    public String getOfficeGrade(){
        return officeGrade;
    }

    /**
     * ��������׷����ʼ����
     * @param bkWardStartDate �����õ�����׷����ʼ���ڵ�ֵ
     */
    public void setBkWardStartDate(DateTime bkWardStartDate){
        this.bkWardStartDate = bkWardStartDate;
    }

    /**
     * ��ȡ����׷����ʼ����
     * @return ����׷����ʼ���ڵ�ֵ
     */
    public DateTime getBkWardStartDate(){
        return bkWardStartDate;
    }

    /**
     * ��������׷����ֹ����
     * @param bkWardEndDate �����õ�����׷����ֹ���ڵ�ֵ
     */
    public void setBkWardEndDate(DateTime bkWardEndDate){
        this.bkWardEndDate = bkWardEndDate;
    }

    /**
     * ��ȡ����׷����ֹ����
     * @return ����׷����ֹ���ڵ�ֵ
     */
    public DateTime getBkWardEndDate(){
        return bkWardEndDate;
    }

    /**
     * ��������Ա������
     * @param staffCount �����õ�����Ա��������ֵ
     */
    public void setStaffCount(long staffCount){
        this.staffCount = staffCount;
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա��������ֵ
     */
    public long getStaffCount(){
        return staffCount;
    }

    /**
     * �������������Ӫҵ��
     * @param preTurnOver �����õ����������Ӫҵ���ֵ
     */
    public void setPreTurnOver(double preTurnOver){
        this.preTurnOver = preTurnOver;
    }

    /**
     * ��ȡ���������Ӫҵ��
     * @return ���������Ӫҵ���ֵ
     */
    public double getPreTurnOver(){
        return preTurnOver;
    }

    /**
     * �������Ա����Ӫҵ��/���۶�
--**ZBB������ʤ�������գ��羰��--**              ʤ���������˴�
     * @param nowTurnOver �����õ����Ա����Ӫҵ��/���۶�
--**ZBB������ʤ�������գ��羰��--**              ʤ���������˴ε�ֵ
     */
    public void setNowTurnOver(double nowTurnOver){
        this.nowTurnOver = nowTurnOver;
    }

    /**
     * ��ȡ���Ա����Ӫҵ��/���۶�
--**ZBB������ʤ�������գ��羰��--**              ʤ���������˴�
     * @return ���Ա����Ӫҵ��/���۶�
--**ZBB������ʤ�������գ��羰��--**              ʤ���������˴ε�ֵ
     */
    public double getNowTurnOver(){
        return nowTurnOver;
    }

    /**
     * �������Թ�����
     * @param electricPower �����õ����Թ�������ֵ
     */
    public void setElectricPower(double electricPower){
        this.electricPower = electricPower;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ�������ֵ
     */
    public double getElectricPower(){
        return electricPower;
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
}
