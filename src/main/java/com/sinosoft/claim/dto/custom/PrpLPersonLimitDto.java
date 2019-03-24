package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpLPersonLimit��Ա���ֶ��ձ�����ݴ���������<br>
 * ������ 2005-11-15 <br>
 * @author qinyongli
 */
public class PrpLPersonLimitDto implements Serializable{
    /** ������Ա����*/
    private String userCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLPersonLimitDto����
     */
    public PrpLPersonLimitDto(){
    }

    /**
     * ����������Ա����
     * @param userCode �����õ�������Ա����
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա����
     */
    public String getUserCode(){
        return userCode;
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
