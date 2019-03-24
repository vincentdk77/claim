package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcrenewal������Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCrenewalDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ����ԭ�������� */
    private String oldPolicyNo = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCrenewalDtoBase����
     */
    public PrpCrenewalDtoBase(){
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
     * ��������ԭ��������
     * @param oldPolicyNo �����õ�����ԭ���������ֵ
     */
    public void setOldPolicyNo(String oldPolicyNo){
        this.oldPolicyNo = StringUtils.rightTrim(oldPolicyNo);
    }

    /**
     * ��ȡ����ԭ��������
     * @return ����ԭ���������ֵ
     */
    public String getOldPolicyNo(){
        return oldPolicyNo;
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
