package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpltrack�����ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLtrackDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** ���Ե�֤���� */
    private String docCode = "";
    /** ���Ե�֤���� */
    private String docName = "";
    /** ����״̬ */
    private int status = 0;
    /** �����ͼ��� */
    private String sendorName = "";
    /** �����ͼ�ʱ�� */
    private DateTime sendDate = new DateTime();
    /** �����ռ��� */
    private String acceptName = "";
    /** �����ռ�ʱ�� */
    private DateTime acceptDate = new DateTime();
    /** �����ƽ����ⲿ��Ա */
    private String checkName = "";
    /** �����ƽ����ⲿʱ�� */
    private DateTime checkDate = new DateTime();
    /** ���Ժ��ⷵ��ʱ�� */
    private DateTime returnDate = new DateTime();
    /** ���Թ鵵�� */
    private String dossierMark = "";
    /** �����Ƿ�᰸ */
    private String endCase = "";
    /** ���Ա�� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLtrackDtoBase����
     */
    public PrpLtrackDtoBase(){
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
     * �������Ե�֤����
     * @param docCode �����õ����Ե�֤�����ֵ
     */
    public void setDocCode(String docCode){
        this.docCode = StringUtils.rightTrim(docCode);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤�����ֵ
     */
    public String getDocCode(){
        return docCode;
    }

    /**
     * �������Ե�֤����
     * @param docName �����õ����Ե�֤���Ƶ�ֵ
     */
    public void setDocName(String docName){
        this.docName = StringUtils.rightTrim(docName);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤���Ƶ�ֵ
     */
    public String getDocName(){
        return docName;
    }

    /**
     * ��������״̬
     * @param status �����õ�����״̬��ֵ
     */
    public void setStatus(int status){
        this.status = status;
    }

    /**
     * ��ȡ����״̬
     * @return ����״̬��ֵ
     */
    public int getStatus(){
        return status;
    }

    /**
     * ���������ͼ���
     * @param sendorName �����õ������ͼ��˵�ֵ
     */
    public void setSendorName(String sendorName){
        this.sendorName = StringUtils.rightTrim(sendorName);
    }

    /**
     * ��ȡ�����ͼ���
     * @return �����ͼ��˵�ֵ
     */
    public String getSendorName(){
        return sendorName;
    }

    /**
     * ���������ͼ�ʱ��
     * @param sendDate �����õ������ͼ�ʱ���ֵ
     */
    public void setSendDate(DateTime sendDate){
        this.sendDate = sendDate;
    }

    /**
     * ��ȡ�����ͼ�ʱ��
     * @return �����ͼ�ʱ���ֵ
     */
    public DateTime getSendDate(){
        return sendDate;
    }

    /**
     * ���������ռ���
     * @param acceptName �����õ������ռ��˵�ֵ
     */
    public void setAcceptName(String acceptName){
        this.acceptName = StringUtils.rightTrim(acceptName);
    }

    /**
     * ��ȡ�����ռ���
     * @return �����ռ��˵�ֵ
     */
    public String getAcceptName(){
        return acceptName;
    }

    /**
     * ���������ռ�ʱ��
     * @param acceptDate �����õ������ռ�ʱ���ֵ
     */
    public void setAcceptDate(DateTime acceptDate){
        this.acceptDate = acceptDate;
    }

    /**
     * ��ȡ�����ռ�ʱ��
     * @return �����ռ�ʱ���ֵ
     */
    public DateTime getAcceptDate(){
        return acceptDate;
    }

    /**
     * ���������ƽ����ⲿ��Ա
     * @param checkName �����õ������ƽ����ⲿ��Ա��ֵ
     */
    public void setCheckName(String checkName){
        this.checkName = StringUtils.rightTrim(checkName);
    }

    /**
     * ��ȡ�����ƽ����ⲿ��Ա
     * @return �����ƽ����ⲿ��Ա��ֵ
     */
    public String getCheckName(){
        return checkName;
    }

    /**
     * ���������ƽ����ⲿʱ��
     * @param checkDate �����õ������ƽ����ⲿʱ���ֵ
     */
    public void setCheckDate(DateTime checkDate){
        this.checkDate = checkDate;
    }

    /**
     * ��ȡ�����ƽ����ⲿʱ��
     * @return �����ƽ����ⲿʱ���ֵ
     */
    public DateTime getCheckDate(){
        return checkDate;
    }

    /**
     * �������Ժ��ⷵ��ʱ��
     * @param returnDate �����õ����Ժ��ⷵ��ʱ���ֵ
     */
    public void setReturnDate(DateTime returnDate){
        this.returnDate = returnDate;
    }

    /**
     * ��ȡ���Ժ��ⷵ��ʱ��
     * @return ���Ժ��ⷵ��ʱ���ֵ
     */
    public DateTime getReturnDate(){
        return returnDate;
    }

    /**
     * �������Թ鵵��
     * @param dossierMark �����õ����Թ鵵�ŵ�ֵ
     */
    public void setDossierMark(String dossierMark){
        this.dossierMark = StringUtils.rightTrim(dossierMark);
    }

    /**
     * ��ȡ���Թ鵵��
     * @return ���Թ鵵�ŵ�ֵ
     */
    public String getDossierMark(){
        return dossierMark;
    }

    /**
     * ���������Ƿ�᰸
     * @param endCase �����õ������Ƿ�᰸��ֵ
     */
    public void setEndCase(String endCase){
        this.endCase = StringUtils.rightTrim(endCase);
    }

    /**
     * ��ȡ�����Ƿ�᰸
     * @return �����Ƿ�᰸��ֵ
     */
    public String getEndCase(){
        return endCase;
    }

    /**
     * �������Ա��
     * @param flag �����õ����Ա�ǵ�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ǵ�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
