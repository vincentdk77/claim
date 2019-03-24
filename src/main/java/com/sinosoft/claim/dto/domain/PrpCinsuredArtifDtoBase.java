package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcinsuredartif������Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredArtifDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Թ�ϵ�˱�ʶ */
    private String insuredFlag = "";
    /** ���Է��˴��� */
    private String leaderName = "";
    /** ���Է��˴������֤�� */
    private String leaderID = "";
    /** ���Ե绰 */
    private String phoneNumber = "";
    /** �����ʱ� */
    private String postCode = "";
    /** ����Ӫҵִ�� */
    private String businessCode = "";
    /** ����˰��ǼǺ��� */
    private String revenueRegistNo = "";
    /** ���Ծ������� */
    private String carType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCinsuredArtifDtoBase����
     */
    public PrpCinsuredArtifDtoBase(){
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
     * �������Թ�ϵ�˱�ʶ
     * @param insuredFlag �����õ����Թ�ϵ�˱�ʶ��ֵ
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * ��ȡ���Թ�ϵ�˱�ʶ
     * @return ���Թ�ϵ�˱�ʶ��ֵ
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * �������Է��˴���
     * @param leaderName �����õ����Է��˴����ֵ
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * ��ȡ���Է��˴���
     * @return ���Է��˴����ֵ
     */
    public String getLeaderName(){
        return leaderName;
    }

    /**
     * �������Է��˴������֤��
     * @param leaderID �����õ����Է��˴������֤�ŵ�ֵ
     */
    public void setLeaderID(String leaderID){
        this.leaderID = StringUtils.rightTrim(leaderID);
    }

    /**
     * ��ȡ���Է��˴������֤��
     * @return ���Է��˴������֤�ŵ�ֵ
     */
    public String getLeaderID(){
        return leaderID;
    }

    /**
     * �������Ե绰
     * @param phoneNumber �����õ����Ե绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ���Ե绰
     * @return ���Ե绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ���������ʱ�
     * @param postCode �����õ������ʱ��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ�����ʱ�
     * @return �����ʱ��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������Ӫҵִ��
     * @param businessCode �����õ�����Ӫҵִ�յ�ֵ
     */
    public void setBusinessCode(String businessCode){
        this.businessCode = StringUtils.rightTrim(businessCode);
    }

    /**
     * ��ȡ����Ӫҵִ��
     * @return ����Ӫҵִ�յ�ֵ
     */
    public String getBusinessCode(){
        return businessCode;
    }

    /**
     * ��������˰��ǼǺ���
     * @param revenueRegistNo �����õ�����˰��ǼǺ����ֵ
     */
    public void setRevenueRegistNo(String revenueRegistNo){
        this.revenueRegistNo = StringUtils.rightTrim(revenueRegistNo);
    }

    /**
     * ��ȡ����˰��ǼǺ���
     * @return ����˰��ǼǺ����ֵ
     */
    public String getRevenueRegistNo(){
        return revenueRegistNo;
    }

    /**
     * �������Ծ�������
     * @param carType �����õ����Ծ������͵�ֵ
     */
    public void setCarType(String carType){
        this.carType = StringUtils.rightTrim(carType);
    }

    /**
     * ��ȡ���Ծ�������
     * @return ���Ծ������͵�ֵ
     */
    public String getCarType(){
        return carType;
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
