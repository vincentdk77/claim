package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpCreditAssure����Ԥ��ȷ�Ϻ��ű�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCreditAssureDtoBase implements Serializable{
    /** ���Է���Ԥ��ȷ�Ϻ��� */
    private String confirmNo = "";
    /** ���Է���Ԥ���� */
    private String investigateNo = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCreditAssureDtoBase����
     */
    public PrpCreditAssureDtoBase(){
    }

    /**
     * �������Է���Ԥ��ȷ�Ϻ���
     * @param confirmNo �����õ����Է���Ԥ��ȷ�Ϻ��ŵ�ֵ
     */
    public void setConfirmNo(String confirmNo){
        this.confirmNo = StringUtils.rightTrim(confirmNo);
    }

    /**
     * ��ȡ���Է���Ԥ��ȷ�Ϻ���
     * @return ���Է���Ԥ��ȷ�Ϻ��ŵ�ֵ
     */
    public String getConfirmNo(){
        return confirmNo;
    }

    /**
     * �������Է���Ԥ����
     * @param investigateNo �����õ����Է���Ԥ���ŵ�ֵ
     */
    public void setInvestigateNo(String investigateNo){
        this.investigateNo = StringUtils.rightTrim(investigateNo);
    }

    /**
     * ��ȡ���Է���Ԥ����
     * @return ���Է���Ԥ���ŵ�ֵ
     */
    public String getInvestigateNo(){
        return investigateNo;
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
