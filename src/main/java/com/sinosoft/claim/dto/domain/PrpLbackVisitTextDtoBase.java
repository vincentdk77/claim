package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLbackVisitText--�طñ�ע������ݴ���������<br>
 * ������ 2005-03-23 09:00:34.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitTextDtoBase implements Serializable{
    /** ���Կͻ��طü�¼ID */
    private int backVisitID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ����ҵ������ */
    private String backVisitType = "";
    /** ��������� */
    private int lineNo = 0;
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Է���/�ط����� */
    private String content = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLbackVisitTextDtoBase����
     */
    public PrpLbackVisitTextDtoBase(){
    }

    /**
     * �������Կͻ��طü�¼ID
     * @param backVisitID �����õ����Կͻ��طü�¼ID��ֵ
     */
    public void setBackVisitID(int backVisitID){
        this.backVisitID = backVisitID;
    }

    /**
     * ��ȡ���Կͻ��طü�¼ID
     * @return ���Կͻ��طü�¼ID��ֵ
     */
    public int getBackVisitID(){
        return backVisitID;
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
     * ��������ҵ������
     * @param backVisitType �����õ�����ҵ�����͵�ֵ
     */
    public void setBackVisitType(String backVisitType){
        this.backVisitType = StringUtils.rightTrim(backVisitType);
    }

    /**
     * ��ȡ����ҵ������
     * @return ����ҵ�����͵�ֵ
     */
    public String getBackVisitType(){
        return backVisitType;
    }

    /**
     * �������������
     * @param lineNo �����õ���������ŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ���������
     * @return ��������ŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Է���/�ط�����
     * @param content �����õ����Է���/�ط����ݵ�ֵ
     */
    public void setContent(String content){
        this.content = StringUtils.rightTrim(content);
    }

    /**
     * ��ȡ���Է���/�ط�����
     * @return ���Է���/�ط����ݵ�ֵ
     */
    public String getContent(){
        return content;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
