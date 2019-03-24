package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcaseNo-�ⰸ�ű�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.500<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcaseNoDtoBase implements Serializable{
    /** ���Ե�֤�� */
    private String certiNo = "";
    /** ���Ե�֤���� */
    private String certiType = "";
    /** �����ⰸ�� */
    private String caseNo = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";
    /** �����ⰸ���� */
    private String claimNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcaseNoDtoBase����
     */
    public PrpLcaseNoDtoBase(){
    }

    /**
     * �������Ե�֤��
     * @param certiNo �����õ����Ե�֤�ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤��
     * @return ���Ե�֤�ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ե�֤����
     * @param certiType �����õ����Ե�֤���͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���͵�ֵ
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * ���������ⰸ��
     * @param caseNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setCaseNo(String caseNo){
        this.caseNo = StringUtils.rightTrim(caseNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getCaseNo(){
        return caseNo;
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
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }
}
