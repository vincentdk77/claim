package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpusergradeԱ��Ȩ�ޱ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** ����Ա������ */
    private String userCode = "";
    /** ��������Ȩ�� */
    private String power = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpUserGradeDtoBase����
     */
    public PrpUserGradeDtoBase(){
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
     * ������������Ȩ��
     * @param power �����õ���������Ȩ�޵�ֵ
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * ��ȡ��������Ȩ��
     * @return ��������Ȩ�޵�ֵ
     */
    public String getPower(){
        return power;
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
