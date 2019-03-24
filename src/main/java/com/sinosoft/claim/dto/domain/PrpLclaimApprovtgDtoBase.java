package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimApprov-��������ת��ȷ�ϱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.625<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimApprovtgDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** ����ȷ���˴��� */
    private String approverCode = "";
    /** ����ȷ������ */
    private DateTime approvDate = new DateTime();
    /** �����Ƿ�ת����־
--** 0����ʼֵ 1����ת�� */
    private String transferStatus = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimApprovtgDtoBase����
     */
    public PrpLclaimApprovtgDtoBase(){
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
     * ��������ȷ���˴���
     * @param approverCode �����õ�����ȷ���˴����ֵ
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * ��ȡ����ȷ���˴���
     * @return ����ȷ���˴����ֵ
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * ��������ȷ������
     * @param approvDate �����õ�����ȷ�����ڵ�ֵ
     */
    public void setApprovDate(DateTime approvDate){
        this.approvDate = approvDate;
    }

    /**
     * ��ȡ����ȷ������
     * @return ����ȷ�����ڵ�ֵ
     */
    public DateTime getApprovDate(){
        return approvDate;
    }

    /**
     * ���������Ƿ�ת����־
--** 0����ʼֵ 1����ת��
     * @param transferStatus �����õ������Ƿ�ת����־
--** 0����ʼֵ 1����ת����ֵ
     */
    public void setTransferStatus(String transferStatus){
        this.transferStatus = StringUtils.rightTrim(transferStatus);
    }

    /**
     * ��ȡ�����Ƿ�ת����־
--** 0����ʼֵ 1����ת��
     * @return �����Ƿ�ת����־
--** 0����ʼֵ 1����ת����ֵ
     */
    public String getTransferStatus(){
        return transferStatus;
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
