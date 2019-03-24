package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjrefpatchrec�������ѵǼǱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefPatchRecDtoBase implements Serializable{
    /** �����������ѵǼǺ� */
    private String refundGroupNo = "";
    /** ���Ա�������/��������/����������� */
    private String certiNo = "";
    /** ���Ա��θ������ */
    private int serialNo = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJrefPatchRecDtoBase����
     */
    public PrpJrefPatchRecDtoBase(){
    }

    /**
     * ���������������ѵǼǺ�
     * @param refundGroupNo �����õ������������ѵǼǺŵ�ֵ
     */
    public void setRefundGroupNo(String refundGroupNo){
        this.refundGroupNo = StringUtils.rightTrim(refundGroupNo);
    }

    /**
     * ��ȡ�����������ѵǼǺ�
     * @return �����������ѵǼǺŵ�ֵ
     */
    public String getRefundGroupNo(){
        return refundGroupNo;
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
     * �������Ա��θ������
     * @param serialNo �����õ����Ա��θ�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Ա��θ������
     * @return ���Ա��θ�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }
}
