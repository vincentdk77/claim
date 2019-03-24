package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLrecase-�ؿ��ⰸ��;�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrecasetgDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** �����ؿ��ⰸ���� */
    private int serialNo = 0;
    /** �����ؿ��ⰸ�˴��� */
    private String openCaseUserCode = "";
    /** �����ؿ��ⰸ���� */
    private DateTime openCaseDate = new DateTime();
    /** ���Ա��ν᰸�˴��� */
    private String closeCaseUserCode = "";
    /** ���Ա��ν᰸���� */
    private DateTime closeCaseDate = new DateTime();
    /** ���Ա�־ */
    private String flag = "";
    /** �ϴ�ƽ̨�Ƿ�ɹ� */
    private String reCaseUploadFlag = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLrecasetgDtoBase����
     */
    public PrpLrecasetgDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ���������ؿ��ⰸ����
     * @param serialNo �����õ������ؿ��ⰸ������ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����ؿ��ⰸ����
     * @return �����ؿ��ⰸ������ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������ؿ��ⰸ�˴���
     * @param openCaseUserCode �����õ������ؿ��ⰸ�˴����ֵ
     */
    public void setOpenCaseUserCode(String openCaseUserCode){
        this.openCaseUserCode = StringUtils.rightTrim(openCaseUserCode);
    }

    /**
     * ��ȡ�����ؿ��ⰸ�˴���
     * @return �����ؿ��ⰸ�˴����ֵ
     */
    public String getOpenCaseUserCode(){
        return openCaseUserCode;
    }

    /**
     * ���������ؿ��ⰸ����
     * @param openCaseDate �����õ������ؿ��ⰸ���ڵ�ֵ
     */
    public void setOpenCaseDate(DateTime openCaseDate){
        this.openCaseDate = openCaseDate;
    }

    /**
     * ��ȡ�����ؿ��ⰸ����
     * @return �����ؿ��ⰸ���ڵ�ֵ
     */
    public DateTime getOpenCaseDate(){
        return openCaseDate;
    }

    /**
     * �������Ա��ν᰸�˴���
     * @param closeCaseUserCode �����õ����Ա��ν᰸�˴����ֵ
     */
    public void setCloseCaseUserCode(String closeCaseUserCode){
        this.closeCaseUserCode = StringUtils.rightTrim(closeCaseUserCode);
    }

    /**
     * ��ȡ���Ա��ν᰸�˴���
     * @return ���Ա��ν᰸�˴����ֵ
     */
    public String getCloseCaseUserCode(){
        return closeCaseUserCode;
    }

    /**
     * �������Ա��ν᰸����
     * @param closeCaseDate �����õ����Ա��ν᰸���ڵ�ֵ
     */
    public void setCloseCaseDate(DateTime closeCaseDate){
        this.closeCaseDate = closeCaseDate;
    }

    /**
     * ��ȡ���Ա��ν᰸����
     * @return ���Ա��ν᰸���ڵ�ֵ
     */
    public DateTime getCloseCaseDate(){
        return closeCaseDate;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

	/**
	 * @return the reCaseUploadFlag
	 */
	public String getReCaseUploadFlag() {
		return reCaseUploadFlag;
	}

	/**
	 * @param reCaseUploadFlag the reCaseUploadFlag to set
	 */
	public void setReCaseUploadFlag(String reCaseUploadFlag) {
		this.reCaseUploadFlag = reCaseUploadFlag;
	}
}
