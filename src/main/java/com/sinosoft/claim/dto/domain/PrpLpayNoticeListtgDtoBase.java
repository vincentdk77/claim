package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ������������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayNoticeListtgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����֪ͨ���� */
    private String noticeNo = "";
    /** �����ո���� */
    private String paymentNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayNoticeListtgDtoBase����
     */
    public PrpLpayNoticeListtgDtoBase(){
    }

    /**
     * ��������֪ͨ����
     * @param noticeNo �����õ�����֪ͨ���ŵ�ֵ
     */
    public void setNoticeNo(String noticeNo){
        this.noticeNo = StringUtils.rightTrim(noticeNo);
    }

    /**
     * ��ȡ����֪ͨ����
     * @return ����֪ͨ���ŵ�ֵ
     */
    public String getNoticeNo(){
        return noticeNo;
    }

    /**
     * ���������ո����
     * @param paymentNo �����õ������ո���ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ�����ո����
     * @return �����ո���ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }
}
