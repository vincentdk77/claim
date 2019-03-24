package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CompeInvMainInfo implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������� PK */
    private int serialNo = 0;
    /** �����⸶�嵥���� */
    private String settleListCode = "";
    /** ���Ա������� */
    private String registNo = "";
    /** ������������ */
    private String claimNo = "";
    /** ���Լ�������� */
    private String compensateNo = "";
    /** ����������Դ */
    private String dateSourceName = "";
    /** ���Լ����������嵥��Ϣ */
	private CompeInvDetailInfo[] compeInvDetailInfo;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCompeInvMainDtoBase����
     */
    public CompeInvMainInfo(){
    }

    /**
     * ����������� PK
     * @param serialNo �����õ�������� PK��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ������� PK
     * @return ������� PK��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������⸶�嵥����
     * @param settleListCode �����õ������⸶�嵥�����ֵ
     */
    public void setSettleListCode(String settleListCode){
        this.settleListCode = StringUtils.rightTrim(settleListCode);
    }

    /**
     * ��ȡ�����⸶�嵥����
     * @return �����⸶�嵥�����ֵ
     */
    public String getSettleListCode(){
        return settleListCode;
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ����������������
     * @param claimNo �����õ��������������ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Լ��������
     * @param compensateNo �����õ����Լ���������ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ���Լ��������
     * @return ���Լ���������ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������������Դ
     * @param dateSourceName �����õ�����������Դ��ֵ
     */
    public void setDateSourceName(String dateSourceName){
        this.dateSourceName = StringUtils.rightTrim(dateSourceName);
    }

    /**
     * ��ȡ����������Դ
     * @return ����������Դ��ֵ
     */
    public String getDateSourceName(){
        return dateSourceName;
    }

	/**
	 * �������Լ�������������Ϣ
	 * 
	 * @param compePayFeeInfoDto
	 *            �����õ����Լ�������������Ϣ��ֵ
	 */
	public void setCompeInvDetailInfo(CompeInvDetailInfo[] compeInvDetailInfo) {
		this.compeInvDetailInfo = compeInvDetailInfo;
	}

	/**
	 * ��ȡ���Լ�������������Ϣ
	 * 
	 * @return ���Լ�������������Ϣ��ֵ
	 */
	public CompeInvDetailInfo[] getCompeInvDetailInfo() {
		return compeInvDetailInfo;
	}
}
