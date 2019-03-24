package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)�����ݴ���������<br>
 * ������ 2005-04-19 09:24:18.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimGradetgDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ����Ա������ */
    private String userName = "";
    /** ����������� */
    private String taskCode = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** ����Ȩ�޼��� */
    private String claimLevel = "";
    /** ���Խ������ */
    private double valueLower = 0d;
    /** ���Խ������ */
    private double valueUpper = 0d;
    /** ���Ա��� */
    private double rate = 0d;
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /** ����CONFIGPARA */
    private String configPara = "";
    /** ����CONFIGDESC */
    private String configDesc = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimGradetgDtoBase����
     */
    public PrpLclaimGradetgDtoBase(){
    }

    /**
     * ��������Ա������
     * @param userCode �����õ�����Ա�������ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�������ֵ
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * ��������Ա������
     * @param userName �����õ�����Ա�����Ƶ�ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ����Ա������
     * @return ����Ա�����Ƶ�ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ���������������
     * @param taskCode �����õ�������������ֵ
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getTaskCode(){
        return taskCode;
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
     * ��������Ȩ�޼���
     * @param claimLevel �����õ�����Ȩ�޼����ֵ
     */
    public void setClaimLevel(String claimLevel){
        this.claimLevel = StringUtils.rightTrim(claimLevel);
    }

    /**
     * ��ȡ����Ȩ�޼���
     * @return ����Ȩ�޼����ֵ
     */
    public String getClaimLevel(){
        return claimLevel;
    }

    /**
     * �������Խ������
     * @param valueLower �����õ����Խ�����޵�ֵ
     */
    public void setValueLower(double valueLower){
        this.valueLower = valueLower;
    }

    /**
     * ��ȡ���Խ������
     * @return ���Խ�����޵�ֵ
     */
    public double getValueLower(){
        return valueLower;
    }

    /**
     * �������Խ������
     * @param valueUpper �����õ����Խ�����޵�ֵ
     */
    public void setValueUpper(double valueUpper){
        this.valueUpper = valueUpper;
    }

    /**
     * ��ȡ���Խ������
     * @return ���Խ�����޵�ֵ
     */
    public double getValueUpper(){
        return valueUpper;
    }

    /**
     * �������Ա���
     * @param rate �����õ����Ա�����ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
     * ��������CONFIGPARA
     * @param configPara �����õ�����CONFIGPARA��ֵ
     */
    public void setConfigPara(String configPara){
        this.configPara = StringUtils.rightTrim(configPara);
    }

    /**
     * ��ȡ����CONFIGPARA
     * @return ����CONFIGPARA��ֵ
     */
    public String getConfigPara(){
        return configPara;
    }

    /**
     * ��������CONFIGDESC
     * @param configDesc �����õ�����CONFIGDESC��ֵ
     */
    public void setConfigDesc(String configDesc){
        this.configDesc = StringUtils.rightTrim(configDesc);
    }

    /**
     * ��ȡ����CONFIGDESC
     * @return ����CONFIGDESC��ֵ
     */
    public String getConfigDesc(){
        return configDesc;
    }

}
