package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjpaypatchrec�����շѵǼǱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJpayPatchRecDtoBase implements Serializable{
    /** ���������շѵǼǺ� */
    private String payGroupNo = "";
    /** ���Ա�������/��������/����������� */
    private String certiNo = "";
    /** ���Ա����շ���� */
    private int serialNo = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJpayPatchRecDtoBase����
     */
    public PrpJpayPatchRecDtoBase(){
    }

    /**
     * �������������շѵǼǺ�
     * @param payGroupNo �����õ����������շѵǼǺŵ�ֵ
     */
    public void setPayGroupNo(String payGroupNo){
        this.payGroupNo = StringUtils.rightTrim(payGroupNo);
    }

    /**
     * ��ȡ���������շѵǼǺ�
     * @return ���������շѵǼǺŵ�ֵ
     */
    public String getPayGroupNo(){
        return payGroupNo;
    }

    /**
     * �������Ա�������/��������/�����������
     * @param certiNo �����õ����Ա�������/��������/������������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ա�������/��������/�����������
     * @return ���Ա�������/��������/������������ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ա����շ����
     * @param serialNo �����õ����Ա����շ���ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Ա����շ����
     * @return ���Ա����շ���ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }
}
