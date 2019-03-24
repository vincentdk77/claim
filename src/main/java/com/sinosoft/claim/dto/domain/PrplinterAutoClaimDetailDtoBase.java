package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���������Զ�����״̬��ѯ������ݴ���������<br>
 */
public class PrplinterAutoClaimDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** ���Ա������� PK */
    private String registNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա������̳ɹ�(1�ɹ�) */
    private String registSuccFlag = "";
    /** ���Ե������̳ɹ�(1�ɹ�) */
    private String schedSuccFlag = "";
    /** ���Բ鿱���̳ɹ�(1�ɹ�)(1�ɹ�) */
    private String checkSuccFlag = "";
    /** �����������̳ɹ�(1�ɹ�) */
    private String claimSuccFlag = "";
    /** ���Ե�֤���̳ɹ�(1�ɹ�) */
    private String certiSuccFlag = "";
    /** �����������̳ɹ�(1�ɹ�) */
    private String comppSuccFlag = "";
    /** ���Ժ������̳ɹ�(1�ɹ�) */
    private String vericSuccFlag = "";
    /** ���Խ᰸���̳ɹ�(1�ɹ�) */
    private String endcaSuccFlag = "";
    /** ���Է�����Ϣ(�ɹ�/error) */
    private String remark = "";
    /** ����Ԥ���������̳ɹ�(1�ɹ�) */
    private String prepaySuccFlag = "";
    /** ����Ԥ���������̳ɹ�(1�ɹ�) */
    private String prepayVericSuccFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplinterAutoClaimDetailDtoBase����
     */
    public PrplinterAutoClaimDetailDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * �������Ա������� PK
     * @param registNo �����õ����Ա������� PK��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա������� PK
     * @return ���Ա������� PK��ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * �������Ա������̳ɹ�(1�ɹ�)
     * @param registSuccFlag �����õ����Ա������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setRegistSuccFlag(String registSuccFlag){
        this.registSuccFlag = StringUtils.rightTrim(registSuccFlag);
    }

    /**
     * ��ȡ���Ա������̳ɹ�(1�ɹ�)
     * @return ���Ա������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getRegistSuccFlag(){
        return registSuccFlag;
    }

    /**
     * �������Ե������̳ɹ�(1�ɹ�)
     * @param schedSuccFlag �����õ����Ե������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setSchedSuccFlag(String schedSuccFlag){
        this.schedSuccFlag = StringUtils.rightTrim(schedSuccFlag);
    }

    /**
     * ��ȡ���Ե������̳ɹ�(1�ɹ�)
     * @return ���Ե������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getSchedSuccFlag(){
        return schedSuccFlag;
    }

    /**
     * �������Բ鿱���̳ɹ�(1�ɹ�)(1�ɹ�)
     * @param checkSuccFlag �����õ����Բ鿱���̳ɹ�(1�ɹ�)(1�ɹ�)��ֵ
     */
    public void setCheckSuccFlag(String checkSuccFlag){
        this.checkSuccFlag = StringUtils.rightTrim(checkSuccFlag);
    }

    /**
     * ��ȡ���Բ鿱���̳ɹ�(1�ɹ�)(1�ɹ�)
     * @return ���Բ鿱���̳ɹ�(1�ɹ�)(1�ɹ�)��ֵ
     */
    public String getCheckSuccFlag(){
        return checkSuccFlag;
    }

    /**
     * ���������������̳ɹ�(1�ɹ�)
     * @param claimSuccFlag �����õ������������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setClaimSuccFlag(String claimSuccFlag){
        this.claimSuccFlag = StringUtils.rightTrim(claimSuccFlag);
    }

    /**
     * ��ȡ�����������̳ɹ�(1�ɹ�)
     * @return �����������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getClaimSuccFlag(){
        return claimSuccFlag;
    }

    /**
     * �������Ե�֤���̳ɹ�(1�ɹ�)
     * @param certiSuccFlag �����õ����Ե�֤���̳ɹ�(1�ɹ�)��ֵ
     */
    public void setCertiSuccFlag(String certiSuccFlag){
        this.certiSuccFlag = StringUtils.rightTrim(certiSuccFlag);
    }

    /**
     * ��ȡ���Ե�֤���̳ɹ�(1�ɹ�)
     * @return ���Ե�֤���̳ɹ�(1�ɹ�)��ֵ
     */
    public String getCertiSuccFlag(){
        return certiSuccFlag;
    }

    /**
     * ���������������̳ɹ�(1�ɹ�)
     * @param comppSuccFlag �����õ������������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setComppSuccFlag(String comppSuccFlag){
        this.comppSuccFlag = StringUtils.rightTrim(comppSuccFlag);
    }

    /**
     * ��ȡ�����������̳ɹ�(1�ɹ�)
     * @return �����������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getComppSuccFlag(){
        return comppSuccFlag;
    }

    /**
     * �������Ժ������̳ɹ�(1�ɹ�)
     * @param vericSuccFlag �����õ����Ժ������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * ��ȡ���Ժ������̳ɹ�(1�ɹ�)
     * @return ���Ժ������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * �������Խ᰸���̳ɹ�(1�ɹ�)
     * @param endcaSuccFlag �����õ����Խ᰸���̳ɹ�(1�ɹ�)��ֵ
     */
    public void setEndcaSuccFlag(String endcaSuccFlag){
        this.endcaSuccFlag = StringUtils.rightTrim(endcaSuccFlag);
    }

    /**
     * ��ȡ���Խ᰸���̳ɹ�(1�ɹ�)
     * @return ���Խ᰸���̳ɹ�(1�ɹ�)��ֵ
     */
    public String getEndcaSuccFlag(){
        return endcaSuccFlag;
    }

    /**
     * �������Է�����Ϣ(�ɹ�/error)
     * @param remark �����õ����Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Է�����Ϣ(�ɹ�/error)
     * @return ���Է�����Ϣ(�ɹ�/error)��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������Ԥ���������̳ɹ�(1�ɹ�)
     * @param prepaySuccFlag �����õ�����Ԥ���������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setPrepaySuccFlag(String prepaySuccFlag){
        this.prepaySuccFlag = StringUtils.rightTrim(prepaySuccFlag);
    }

    /**
     * ��ȡ����Ԥ���������̳ɹ�(1�ɹ�)
     * @return ����Ԥ���������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getPrepaySuccFlag(){
        return prepaySuccFlag;
    }

    /**
     * ��������Ԥ���������̳ɹ�(1�ɹ�)
     * @param prepayVericSuccFlag �����õ�����Ԥ���������̳ɹ�(1�ɹ�)��ֵ
     */
    public void setPrepayVericSuccFlag(String prepayVericSuccFlag){
        this.prepayVericSuccFlag = StringUtils.rightTrim(prepayVericSuccFlag);
    }

    /**
     * ��ȡ����Ԥ���������̳ɹ�(1�ɹ�)
     * @return ����Ԥ���������̳ɹ�(1�ɹ�)��ֵ
     */
    public String getPrepayVericSuccFlag(){
        return prepayVericSuccFlag;
    }
}
