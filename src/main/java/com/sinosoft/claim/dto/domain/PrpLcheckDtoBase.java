package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcheck���鿱/���鿱��Ϣ������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcheckDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Ա������� */
    private String registNo = "";
    /** ������������ */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Բ鿱���� */
    private String checkType = "";
    /** ���Բ鿱/���鿱���� */
    private String checkNature = "";
    /** ���Բ鿱/���鿱���� */
    private DateTime checkDate = new DateTime();
    /** ���Բ鿱/���鿱�ص� */
    private String checkSite = "";
    /** �����Ƿ��һ�ֳ� */
    private String firstSiteFlag = "";
    /** ���԰������� */
    private String claimType = "";
    /** ���Գ���ԭ����� */
    private String damageCode = "";
    /** ���Գ���ԭ��˵�� */
    private String damageName = "";
    /** �����¹����ʹ��� */
    private String damageTypeCode = "";
    /** �����¹�����˵�� */
    private String damageTypeName = "";
    /** �����¹����漰���� */
    private String referKind = "";
    /** ���Գ���������� */
    private String damageAreaCode = "";
    /** ���Գ��յص���� */
    private String damageAddressType = "";
    /** �����⳥���δ��� */
    private String indemnityDuty = "";
    /** �����Ƿ����ڱ������� */
    private String claimFlag = "";
    /** ���Բ鿱/���鿱��1 */
    private String checker1 = "";
    /** ���Բ鿱/���鿱��2 */
    private String checker2 = "";
    /** ���Բ鿱/���鿱��λ���� */
    private String checkUnitName = "";
    /** �����¹ʴ����� */
    private String handleUnit = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** ���Թ������⳵����� */
    private int referSerialNo = 0;
    /** �����Ƿ�Ϊ���������� */
    private String insureCarFlag = "";
    /** �����Ƿ����ı��չ�˾Ͷ��(Y/N) */
    private String repeatInsureFlag = "";
    /** �����¹ʴ����Ŵ��� */
    private String handleUnitCode = "";
    /** ���Ե�λ���� */
    private String unitType = "";
    /** ����δ�����׼���� */
    private double estimateFee = 0D;
    /** ���Թ����� */
    private double estimateLoss = 0D;
    /** ���Գ������� */
    private DateTime damageStartDate = new DateTime();
    /** ���Գ���Сʱ */
    private String damageStartHour = "";
    /** ���Գ��յص� */
    private String damageAddress = "";
    /** ���Բ鿱������ */
    private String checkLinker = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckDtoBase����
     */
    public PrpLcheckDtoBase(){
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
     * �������Բ鿱����
     * @param checkType �����õ����Բ鿱���͵�ֵ
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * ��ȡ���Բ鿱����
     * @return ���Բ鿱���͵�ֵ
     */
    public String getCheckType(){
        return checkType;
    }

    /**
     * �������Բ鿱/���鿱����
     * @param checkNature �����õ����Բ鿱/���鿱���ʵ�ֵ
     */
    public void setCheckNature(String checkNature){
        this.checkNature = StringUtils.rightTrim(checkNature);
    }

    /**
     * ��ȡ���Բ鿱/���鿱����
     * @return ���Բ鿱/���鿱���ʵ�ֵ
     */
    public String getCheckNature(){
        return checkNature;
    }

    /**
     * �������Բ鿱/���鿱����
     * @param checkDate �����õ����Բ鿱/���鿱���ڵ�ֵ
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * ��ȡ���Բ鿱/���鿱����
     * @return ���Բ鿱/���鿱���ڵ�ֵ
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * �������Բ鿱/���鿱�ص�
     * @param checkSite �����õ����Բ鿱/���鿱�ص��ֵ
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * ��ȡ���Բ鿱/���鿱�ص�
     * @return ���Բ鿱/���鿱�ص��ֵ
     */
    public String getCheckSite(){
        return checkSite;
    }

    /**
     * ���������Ƿ��һ�ֳ�
     * @param firstSiteFlag �����õ������Ƿ��һ�ֳ���ֵ
     */
    public void setFirstSiteFlag(String firstSiteFlag){
        this.firstSiteFlag = StringUtils.rightTrim(firstSiteFlag);
    }

    /**
     * ��ȡ�����Ƿ��һ�ֳ�
     * @return �����Ƿ��һ�ֳ���ֵ
     */
    public String getFirstSiteFlag(){
        return firstSiteFlag;
    }

    /**
     * �������԰�������
     * @param claimType �����õ����԰������͵�ֵ
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * ��ȡ���԰�������
     * @return ���԰������͵�ֵ
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * �������Գ���ԭ�����
     * @param damageCode �����õ����Գ���ԭ������ֵ
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * ��ȡ���Գ���ԭ�����
     * @return ���Գ���ԭ������ֵ
     */
    public String getDamageCode(){
        return damageCode;
    }

    /**
     * �������Գ���ԭ��˵��
     * @param damageName �����õ����Գ���ԭ��˵����ֵ
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * ��ȡ���Գ���ԭ��˵��
     * @return ���Գ���ԭ��˵����ֵ
     */
    public String getDamageName(){
        return damageName;
    }

    /**
     * ���������¹����ʹ���
     * @param damageTypeCode �����õ������¹����ʹ����ֵ
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * ��ȡ�����¹����ʹ���
     * @return �����¹����ʹ����ֵ
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * ���������¹�����˵��
     * @param damageTypeName �����õ������¹�����˵����ֵ
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * ��ȡ�����¹�����˵��
     * @return �����¹�����˵����ֵ
     */
    public String getDamageTypeName(){
        return damageTypeName;
    }

    /**
     * ���������¹����漰����
     * @param referKind �����õ������¹����漰���ֵ�ֵ
     */
    public void setReferKind(String referKind){
        this.referKind = StringUtils.rightTrim(referKind);
    }

    /**
     * ��ȡ�����¹����漰����
     * @return �����¹����漰���ֵ�ֵ
     */
    public String getReferKind(){
        return referKind;
    }

    /**
     * �������Գ����������
     * @param damageAreaCode �����õ����Գ�����������ֵ
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
    }

    /**
     * �������Գ��յص����
     * @param damageAddressType �����õ����Գ��յص�����ֵ
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * ��ȡ���Գ��յص����
     * @return ���Գ��յص�����ֵ
     */
    public String getDamageAddressType(){
        return damageAddressType;
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
     * ���������Ƿ����ڱ�������
     * @param claimFlag �����õ������Ƿ����ڱ������ε�ֵ
     */
    public void setClaimFlag(String claimFlag){
        this.claimFlag = StringUtils.rightTrim(claimFlag);
    }

    /**
     * ��ȡ�����Ƿ����ڱ�������
     * @return �����Ƿ����ڱ������ε�ֵ
     */
    public String getClaimFlag(){
        return claimFlag;
    }

    /**
     * �������Բ鿱/���鿱��1
     * @param checker1 �����õ����Բ鿱/���鿱��1��ֵ
     */
    public void setChecker1(String checker1){
        this.checker1 = StringUtils.rightTrim(checker1);
    }

    /**
     * ��ȡ���Բ鿱/���鿱��1
     * @return ���Բ鿱/���鿱��1��ֵ
     */
    public String getChecker1(){
        return checker1;
    }

    /**
     * �������Բ鿱/���鿱��2
     * @param checker2 �����õ����Բ鿱/���鿱��2��ֵ
     */
    public void setChecker2(String checker2){
        this.checker2 = StringUtils.rightTrim(checker2);
    }

    /**
     * ��ȡ���Բ鿱/���鿱��2
     * @return ���Բ鿱/���鿱��2��ֵ
     */
    public String getChecker2(){
        return checker2;
    }

    /**
     * �������Բ鿱/���鿱��λ����
     * @param checkUnitName �����õ����Բ鿱/���鿱��λ���Ƶ�ֵ
     */
    public void setCheckUnitName(String checkUnitName){
        this.checkUnitName = StringUtils.rightTrim(checkUnitName);
    }

    /**
     * ��ȡ���Բ鿱/���鿱��λ����
     * @return ���Բ鿱/���鿱��λ���Ƶ�ֵ
     */
    public String getCheckUnitName(){
        return checkUnitName;
    }

    /**
     * ���������¹ʴ�����
     * @param handleUnit �����õ������¹ʴ����ŵ�ֵ
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * ��ȡ�����¹ʴ�����
     * @return �����¹ʴ����ŵ�ֵ
     */
    public String getHandleUnit(){
        return handleUnit;
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
     * �������Թ������⳵�����
     * @param referSerialNo �����õ����Թ������⳵����ŵ�ֵ
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * ��ȡ���Թ������⳵�����
     * @return ���Թ������⳵����ŵ�ֵ
     */
    public int getReferSerialNo(){
        return referSerialNo;
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
     * ���������Ƿ����ı��չ�˾Ͷ��(Y/N)
     * @param repeatInsureFlag �����õ������Ƿ����ı��չ�˾Ͷ��(Y/N)��ֵ
     */
    public void setRepeatInsureFlag(String repeatInsureFlag){
        this.repeatInsureFlag = StringUtils.rightTrim(repeatInsureFlag);
    }

    /**
     * ��ȡ�����Ƿ����ı��չ�˾Ͷ��(Y/N)
     * @return �����Ƿ����ı��չ�˾Ͷ��(Y/N)��ֵ
     */
    public String getRepeatInsureFlag(){
        return repeatInsureFlag;
    }

    /**
     * ���������¹ʴ����Ŵ���
     * @param handleUnitCode �����õ������¹ʴ����Ŵ����ֵ
     */
    public void setHandleUnitCode(String handleUnitCode){
        this.handleUnitCode = StringUtils.rightTrim(handleUnitCode);
    }

    /**
     * ��ȡ�����¹ʴ����Ŵ���
     * @return �����¹ʴ����Ŵ����ֵ
     */
    public String getHandleUnitCode(){
        return handleUnitCode;
    }

    /**
     * �������Ե�λ����
     * @param unitType �����õ����Ե�λ���͵�ֵ
     */
    public void setUnitType(String unitType){
        this.unitType = StringUtils.rightTrim(unitType);
    }

    /**
     * ��ȡ���Ե�λ����
     * @return ���Ե�λ���͵�ֵ
     */
    public String getUnitType(){
        return unitType;
    }

    /**
     * ��������δ�����׼����
     * @param estimateFee �����õ�����δ�����׼�����ֵ
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * ��ȡ����δ�����׼����
     * @return ����δ�����׼�����ֵ
     */
    public double getEstimateFee(){
        return estimateFee;
    }

    /**
     * �������Թ�����
     * @param estimateLoss �����õ����Թ������ֵ
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * ��ȡ���Թ�����
     * @return ���Թ������ֵ
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }

    /**
     * �������Գ�������
     * @param damageStartDate �����õ����Գ������ڵ�ֵ
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * ��ȡ���Գ�������
     * @return ���Գ������ڵ�ֵ
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * �������Գ���Сʱ
     * @param damageStartHour �����õ����Գ���Сʱ��ֵ
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * ��ȡ���Գ���Сʱ
     * @return ���Գ���Сʱ��ֵ
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * �������Գ��յص�
     * @param damageAddress �����õ����Գ��յص��ֵ
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * ��ȡ���Գ��յص�
     * @return ���Գ��յص��ֵ
     */
    public String getDamageAddress(){
        return damageAddress;
    }

    /**
     * �������Բ鿱������
     * @param checkLinker �����õ����Բ鿱�����˵�ֵ
     */
    public void setCheckLinker(String checkLinker){
        this.checkLinker = StringUtils.rightTrim(checkLinker);
    }

    /**
     * ��ȡ���Բ鿱������
     * @return ���Բ鿱�����˵�ֵ
     */
    public String getCheckLinker(){
        return checkLinker;
    }
}
