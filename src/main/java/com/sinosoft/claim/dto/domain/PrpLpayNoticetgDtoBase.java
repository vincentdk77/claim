package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ��������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayNoticetgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����֪ͨ���� */
    private String noticeNo = "";
    /** ����֪ͨ��������(0,��֧����1,�ϲ�֧��) */
    private String noticeType = "";
    /** ���Բ������� */
    private DateTime opreateDate = new DateTime();
    /** ���Բ����˴��� */
    private String opreateCode = "";
    /** ������������� */
    private String receiverFullName = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayNoticetgDtoBase����
     */
    public PrpLpayNoticetgDtoBase(){
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
     * ��������֪ͨ��������(0,��֧����1,�ϲ�֧��)
     * @param noticeType �����õ�����֪ͨ��������(0,��֧����1,�ϲ�֧��)��ֵ
     */
    public void setNoticeType(String noticeType){
        this.noticeType = StringUtils.rightTrim(noticeType);
    }

    /**
     * ��ȡ����֪ͨ��������(0,��֧����1,�ϲ�֧��)
     * @return ����֪ͨ��������(0,��֧����1,�ϲ�֧��)��ֵ
     */
    public String getNoticeType(){
        return noticeType;
    }

    /**
     * �������Բ�������
     * @param opreateDate �����õ����Բ������ڵ�ֵ
     */
    public void setOpreateDate(DateTime opreateDate){
        this.opreateDate = opreateDate;
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������ڵ�ֵ
     */
    public DateTime getOpreateDate(){
        return opreateDate;
    }

    /**
     * �������Բ����˴���
     * @param opreateCode �����õ����Բ����˴����ֵ
     */
    public void setOpreateCode(String opreateCode){
        this.opreateCode = StringUtils.rightTrim(opreateCode);
    }

    /**
     * ��ȡ���Բ����˴���
     * @return ���Բ����˴����ֵ
     */
    public String getOpreateCode(){
        return opreateCode;
    }

    /**
     * �����������������
     * @param receiverFullName �����õ�������������Ƶ�ֵ
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * ��ȡ�������������
     * @return ������������Ƶ�ֵ
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }
}
