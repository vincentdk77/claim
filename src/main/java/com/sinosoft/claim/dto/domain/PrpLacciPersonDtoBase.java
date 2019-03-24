package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciPerson�����ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciPersonDtoBase.class.getName().hashCode();
    /** ����CertiNo */
    private String certiNo = "";
    /** ����CertiType */
    private String certiType = "";
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����SerialNo */
    private int serialNo = 0;
    /** ����AcciCode */
    private String acciCode = "";
    /** ����FamilyNo */
    private int familyNo = 0;
    /** ����AcciName */
    private String acciName = "";
    /** ����Sex */
    private String sex = "";
    /** ����Age */
    private int age = 0;
    /** ����IdentifyType */
    private String identifyType = "";
    /** ����IdentifyNumber */
    private String identifyNumber = "";
    /** ����Flag */
    private String flag = "";
    /** ����Remark */
    private String remark = "";
    /** ����Birthday */
    private String birthday = "";//�������������ֶΣ���ɽ�������շ�����Ϣ��ѯ�ӿ�ʹ��

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciPersonDtoBase����
     */
    public PrpLacciPersonDtoBase(){
    }

    /**
     * ��������CertiNo
     * @param certiNo �����õ�����CertiNo��ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ����CertiNo
     * @return ����CertiNo��ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * ��������CertiType
     * @param certiType �����õ�����CertiType��ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ����CertiType
     * @return ����CertiType��ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������SerialNo
     * @param serialNo �����õ�����SerialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����SerialNo
     * @return ����SerialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������AcciCode
     * @param acciCode �����õ�����AcciCode��ֵ
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * ��ȡ����AcciCode
     * @return ����AcciCode��ֵ
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * ��������FamilyNo
     * @param familyNo �����õ�����FamilyNo��ֵ
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * ��ȡ����FamilyNo
     * @return ����FamilyNo��ֵ
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * ��������AcciName
     * @param acciName �����õ�����AcciName��ֵ
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * ��ȡ����AcciName
     * @return ����AcciName��ֵ
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * ��������Sex
     * @param sex �����õ�����Sex��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ����Sex
     * @return ����Sex��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ��������Age
     * @param age �����õ�����Age��ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ����Age
     * @return ����Age��ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * ��������IdentifyType
     * @param identifyType �����õ�����IdentifyType��ֵ
     */
    public void setIdentifyType(String identifyType){
        this.identifyType = StringUtils.rightTrim(identifyType);
    }

    /**
     * ��ȡ����IdentifyType
     * @return ����IdentifyType��ֵ
     */
    public String getIdentifyType(){
        return identifyType;
    }

    /**
     * ��������IdentifyNumber
     * @param identifyNumber �����õ�����IdentifyNumber��ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ����IdentifyNumber
     * @return ����IdentifyNumber��ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
