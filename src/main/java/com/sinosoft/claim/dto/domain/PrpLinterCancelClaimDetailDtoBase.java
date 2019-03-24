package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ����������ݴ���������<br>
 */
public class PrpLinterCancelClaimDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ���Կͻ����������� */
    private String outId = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ա�������״̬(1�ɹ�) */
    private String registSuccFlag = "";
    /** ����ע������״̬(1�ɹ�) */
    private String cancelSuccFlag = "";
    /** ���Է�����Ϣ(�ɹ�/error) */
    private String remark = "";
    /** ��������ע�����뽻��״̬(1�ɹ�) */
    private String claimCancelFlag = "";
    /** ��������ע����˽���״̬(1�ɹ�) */
    private String cancelApprovFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCancelClaimDetailDtoBase����
     */
    public PrpLinterCancelClaimDetailDtoBase(){
    }

    /**
     * ������������id PK
     * @param id �����õ���������id PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id PK
     * @return ��������id PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * �������Կͻ�����������
     * @param outId �����õ����Կͻ�������������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�����������
     * @return ���Կͻ�������������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * �������Ա�������״̬(1�ɹ�)
     * @param registSuccFlag �����õ����Ա�������״̬(1�ɹ�)��ֵ
     */
    public void setRegistSuccFlag(String registSuccFlag){
        this.registSuccFlag = StringUtils.rightTrim(registSuccFlag);
    }

    /**
     * ��ȡ���Ա�������״̬(1�ɹ�)
     * @return ���Ա�������״̬(1�ɹ�)��ֵ
     */
    public String getRegistSuccFlag(){
        return registSuccFlag;
    }

    /**
     * ��������ע������״̬(1�ɹ�)
     * @param cancelSuccFlag �����õ�����ע������״̬(1�ɹ�)��ֵ
     */
    public void setCancelSuccFlag(String cancelSuccFlag){
        this.cancelSuccFlag = StringUtils.rightTrim(cancelSuccFlag);
    }

    /**
     * ��ȡ����ע������״̬(1�ɹ�)
     * @return ����ע������״̬(1�ɹ�)��ֵ
     */
    public String getCancelSuccFlag(){
        return cancelSuccFlag;
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

	public String getClaimCancelFlag() {
		return claimCancelFlag;
	}

	public void setClaimCancelFlag(String claimCancelFlag) {
		this.claimCancelFlag = claimCancelFlag;
	}

	public String getCancelApprovFlag() {
		return cancelApprovFlag;
	}

	public void setCancelApprovFlag(String cancelApprovFlag) {
		this.cancelApprovFlag = cancelApprovFlag;
	}
}
