package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLverifyLoss����������������ݴ���������<br>
 * ������ 2006-04-17 15:58:39.519<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLverifyLossDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** ������������ */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա����� */
    private String lossItemCode = "";
    /** ���Գ��ƺ��� */
    private String lossItemName = "";
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    /** ���Ա������� */
    private String insuredName = "";
    /** ���Ժ��ƺ��� */
    private String licenseNo = "";
    /** ���Ժ��Ƶ�ɫ���� */
    private String licenseColorcode = "";
    /** ���Ժ���������� */
    private String carKindCode = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���Զ����ܽ�� */
    private double sumPreDefLoss = 0d;
    /** ���Ժ����ܽ�� */
    private double sumDefLoss = 0d;
    /** ���Գ������� */
    private String makeCom = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ���Զ����˴��� */
    private String handlerCode = "";
    /** ���Զ����ˣ����ƣ� */
    private String handlerName = "";
    /** ���Զ���������� */
    private DateTime defLossDate = new DateTime();
    /** ���Ժ����˴��� */
    private String underWriteCode = "";
    /** ���Ժ��������� */
    private String underWriteName = "";
    /** �������պ���������� */
    private DateTime underWriteEndDate = new DateTime();
    /** �����Ƿ񾭹������־ */
    private String underWriteFlag = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�ע(����) */
    private String verifyRemark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Իؿ���� */
    private String backCheckRemark = "";
    /** �������˺�����˵�ԭ�� */
    private String veriwReturnReason = "";
    /** ���Ժ������ */
    private String verifyOpinion = "";
    /** ���Գ��ζ����� */
    private double firstDefLoss = 0d;
    /** ����ƫ����� */
    private double warpDefLoss = 0d;
    /** ���Ժ˼��˴��� */
    private String verpApproverCode = "";
    /** ���Ժ˼�ʱ�� */
    private DateTime verpDate = new DateTime();
    /** ���Ժ˼���� */
    private String verpOpinion = "";
    /** ���Ա�ע(�˼�) */
    private String verpRemark = "";
    /** ���������˻ر�� */
    private String compensateFlag = "";
    /** ���������˻�ԭ�� */
    private String compensateOpinion = "";
    /** ���������˻�ʱ�� */
    private DateTime compensateBackDate = new DateTime();
    /** ���������˻صĲ����� */
    private String compensateApproverCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLverifyLossDtoBase����
     */
    public PrpLverifyLossDtoBase(){
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ����������������
     * @param claimNo �����õ��������������ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Ա�����
     * @param lossItemCode �����õ����Ա����ŵ�ֵ
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * �������Գ��ƺ���
     * @param lossItemName �����õ����Գ��ƺ����ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ���Գ��ƺ���
     * @return ���Գ��ƺ����ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * ���������Ƿ�Ϊ����������
     * @param insureCarFlag �����õ������Ƿ�Ϊ������������ֵ
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * ��ȡ�����Ƿ�Ϊ����������
     * @return �����Ƿ�Ϊ������������ֵ
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
    }

    /**
     * �������Ա�������
     * @param insuredName �����õ����Ա������˵�ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������˵�ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * �������Ժ��ƺ���
     * @param licenseNo �����õ����Ժ��ƺ����ֵ
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * ��ȡ���Ժ��ƺ���
     * @return ���Ժ��ƺ����ֵ
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * �������Ժ��Ƶ�ɫ����
     * @param licenseColorcode �����õ����Ժ��Ƶ�ɫ�����ֵ
     */
    public void setLicenseColorcode(String licenseColorcode){
        this.licenseColorcode = StringUtils.rightTrim(licenseColorcode);
    }

    /**
     * ��ȡ���Ժ��Ƶ�ɫ����
     * @return ���Ժ��Ƶ�ɫ�����ֵ
     */
    public String getLicenseColorcode(){
        return licenseColorcode;
    }

    /**
     * �������Ժ����������
     * @param carKindCode �����õ����Ժ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Ժ����������
     * @return ���Ժ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
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
     * �������Զ����ܽ��
     * @param sumPreDefLoss �����õ����Զ����ܽ���ֵ
     */
    public void setSumPreDefLoss(double sumPreDefLoss){
        this.sumPreDefLoss = sumPreDefLoss;
    }

    /**
     * ��ȡ���Զ����ܽ��
     * @return ���Զ����ܽ���ֵ
     */
    public double getSumPreDefLoss(){
        return sumPreDefLoss;
    }

    /**
     * �������Ժ����ܽ��
     * @param sumDefLoss �����õ����Ժ����ܽ���ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ����ܽ��
     * @return ���Ժ����ܽ���ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
     * �������Զ����˴���
     * @param handlerCode �����õ����Զ����˴����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���Զ����˴���
     * @return ���Զ����˴����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������Զ����ˣ����ƣ�
     * @param handlerName �����õ����Զ����ˣ����ƣ���ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���Զ����ˣ����ƣ�
     * @return ���Զ����ˣ����ƣ���ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Զ����������
     * @param defLossDate �����õ����Զ���������ڵ�ֵ
     */
    public void setDefLossDate(DateTime defLossDate){
        this.defLossDate = defLossDate;
    }

    /**
     * ��ȡ���Զ����������
     * @return ���Զ���������ڵ�ֵ
     */
    public DateTime getDefLossDate(){
        return defLossDate;
    }

    /**
     * �������Ժ����˴���
     * @param underWriteCode �����õ����Ժ����˴����ֵ
     */
    public void setUnderWriteCode(String underWriteCode){
        this.underWriteCode = StringUtils.rightTrim(underWriteCode);
    }

    /**
     * ��ȡ���Ժ����˴���
     * @return ���Ժ����˴����ֵ
     */
    public String getUnderWriteCode(){
        return underWriteCode;
    }

    /**
     * �������Ժ���������
     * @param underWriteName �����õ����Ժ��������Ƶ�ֵ
     */
    public void setUnderWriteName(String underWriteName){
        this.underWriteName = StringUtils.rightTrim(underWriteName);
    }

    /**
     * ��ȡ���Ժ���������
     * @return ���Ժ��������Ƶ�ֵ
     */
    public String getUnderWriteName(){
        return underWriteName;
    }

    /**
     * �����������պ����������
     * @param underWriteEndDate �����õ��������պ���������ڵ�ֵ
     */
    public void setUnderWriteEndDate(DateTime underWriteEndDate){
        this.underWriteEndDate = underWriteEndDate;
    }

    /**
     * ��ȡ�������պ����������
     * @return �������պ���������ڵ�ֵ
     */
    public DateTime getUnderWriteEndDate(){
        return underWriteEndDate;
    }

    /**
     * ���������Ƿ񾭹������־
     * @param underWriteFlag �����õ������Ƿ񾭹������־��ֵ
     */
    public void setUnderWriteFlag(String underWriteFlag){
        this.underWriteFlag = StringUtils.rightTrim(underWriteFlag);
    }

    /**
     * ��ȡ�����Ƿ񾭹������־
     * @return �����Ƿ񾭹������־��ֵ
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
     * �������Ա�ע(����)
     * @param verifyRemark �����õ����Ա�ע(����)��ֵ
     */
    public void setVerifyRemark(String verifyRemark){
        this.verifyRemark = StringUtils.rightTrim(verifyRemark);
    }

    /**
     * ��ȡ���Ա�ע(����)
     * @return ���Ա�ע(����)��ֵ
     */
    public String getVerifyRemark(){
        return verifyRemark;
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
     * �������Իؿ����
     * @param backCheckRemark �����õ����Իؿ������ֵ
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * ��ȡ���Իؿ����
     * @return ���Իؿ������ֵ
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * �����������˺�����˵�ԭ��
     * @param veriwReturnReason �����õ��������˺�����˵�ԭ���ֵ
     */
    public void setVeriwReturnReason(String veriwReturnReason){
        this.veriwReturnReason = StringUtils.rightTrim(veriwReturnReason);
    }

    /**
     * ��ȡ�������˺�����˵�ԭ��
     * @return �������˺�����˵�ԭ���ֵ
     */
    public String getVeriwReturnReason(){
        return veriwReturnReason;
    }

    /**
     * �������Ժ������
     * @param verifyOpinion �����õ����Ժ��������ֵ
     */
    public void setVerifyOpinion(String verifyOpinion){
        this.verifyOpinion = StringUtils.rightTrim(verifyOpinion);
    }

    /**
     * ��ȡ���Ժ������
     * @return ���Ժ��������ֵ
     */
    public String getVerifyOpinion(){
        return verifyOpinion;
    }

    /**
     * �������Գ��ζ�����
     * @param firstDefLoss �����õ����Գ��ζ������ֵ
     */
    public void setFirstDefLoss(double firstDefLoss){
        this.firstDefLoss = firstDefLoss;
    }

    /**
     * ��ȡ���Գ��ζ�����
     * @return ���Գ��ζ������ֵ
     */
    public double getFirstDefLoss(){
        return firstDefLoss;
    }

    /**
     * ��������ƫ�����
     * @param warpDefLoss �����õ�����ƫ������ֵ
     */
    public void setWarpDefLoss(double warpDefLoss){
        this.warpDefLoss = warpDefLoss;
    }

    /**
     * ��ȡ����ƫ�����
     * @return ����ƫ������ֵ
     */
    public double getWarpDefLoss(){
        return warpDefLoss;
    }

    /**
     * �������Ժ˼��˴���
     * @param verpApproverCode �����õ����Ժ˼��˴����ֵ
     */
    public void setVerpApproverCode(String verpApproverCode){
        this.verpApproverCode = StringUtils.rightTrim(verpApproverCode);
    }

    /**
     * ��ȡ���Ժ˼��˴���
     * @return ���Ժ˼��˴����ֵ
     */
    public String getVerpApproverCode(){
        return verpApproverCode;
    }

    /**
     * �������Ժ˼�ʱ��
     * @param verpDate �����õ����Ժ˼�ʱ���ֵ
     */
    public void setVerpDate(DateTime verpDate){
        this.verpDate = verpDate;
    }

    /**
     * ��ȡ���Ժ˼�ʱ��
     * @return ���Ժ˼�ʱ���ֵ
     */
    public DateTime getVerpDate(){
        return verpDate;
    }

    /**
     * �������Ժ˼����
     * @param verpOpinion �����õ����Ժ˼������ֵ
     */
    public void setVerpOpinion(String verpOpinion){
        this.verpOpinion = StringUtils.rightTrim(verpOpinion);
    }

    /**
     * ��ȡ���Ժ˼����
     * @return ���Ժ˼������ֵ
     */
    public String getVerpOpinion(){
        return verpOpinion;
    }

    /**
     * �������Ա�ע(�˼�)
     * @param verpRemark �����õ����Ա�ע(�˼�)��ֵ
     */
    public void setVerpRemark(String verpRemark){
        this.verpRemark = StringUtils.rightTrim(verpRemark);
    }

    /**
     * ��ȡ���Ա�ע(�˼�)
     * @return ���Ա�ע(�˼�)��ֵ
     */
    public String getVerpRemark(){
        return verpRemark;
    }

    /**
     * �������������˻ر��
     * @param compensateFlag �����õ����������˻ر�ǵ�ֵ
     */
    public void setCompensateFlag(String compensateFlag){
        this.compensateFlag = StringUtils.rightTrim(compensateFlag);
    }

    /**
     * ��ȡ���������˻ر��
     * @return ���������˻ر�ǵ�ֵ
     */
    public String getCompensateFlag(){
        return compensateFlag;
    }

    /**
     * �������������˻�ԭ��
     * @param compensateOpinion �����õ����������˻�ԭ���ֵ
     */
    public void setCompensateOpinion(String compensateOpinion){
        this.compensateOpinion = StringUtils.rightTrim(compensateOpinion);
    }

    /**
     * ��ȡ���������˻�ԭ��
     * @return ���������˻�ԭ���ֵ
     */
    public String getCompensateOpinion(){
        return compensateOpinion;
    }

    /**
     * �������������˻�ʱ��
     * @param compensateBackDate �����õ����������˻�ʱ���ֵ
     */
    public void setCompensateBackDate(DateTime compensateBackDate){
        this.compensateBackDate = compensateBackDate;
    }

    /**
     * ��ȡ���������˻�ʱ��
     * @return ���������˻�ʱ���ֵ
     */
    public DateTime getCompensateBackDate(){
        return compensateBackDate;
    }

    /**
     * �������������˻صĲ�����
     * @param compensateApproverCode �����õ����������˻صĲ����˵�ֵ
     */
    public void setCompensateApproverCode(String compensateApproverCode){
        this.compensateApproverCode = StringUtils.rightTrim(compensateApproverCode);
    }

    /**
     * ��ȡ���������˻صĲ�����
     * @return ���������˻صĲ����˵�ֵ
     */
    public String getCompensateApproverCode(){
        return compensateApproverCode;
    }
}
