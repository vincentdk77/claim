package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLbackVisitQue--�ط���ѯ������ݴ���������<br>
 * ������ 2005-03-23 09:00:19.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitQueDtoBase implements Serializable{
    /** ���Կͻ��طü�¼ID */
    private int backVisitID = 0;
    /** ���Ա������� */
    private String registNo = "";
    /** ����ҵ������ */
    private String backVisitType = "";
    /** ���Իط���Ŀ���� */
    private String questionCode = "";
    /** ���Իط���Ŀ���� */
    private String questionName = "";
    /** ���Իطý�� */
    private String questionResult = "";
    /** �������ⱸע */
    private String questionRemark = "";
    /** ������������ */
    private String questionType = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLbackVisitQueDtoBase����
     */
    public PrpLbackVisitQueDtoBase(){
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
     * �������Իط���Ŀ����
     * @param questionCode �����õ����Իط���Ŀ�����ֵ
     */
    public void setQuestionCode(String questionCode){
        this.questionCode = StringUtils.rightTrim(questionCode);
    }

    /**
     * ��ȡ���Իط���Ŀ����
     * @return ���Իط���Ŀ�����ֵ
     */
    public String getQuestionCode(){
        return questionCode;
    }

    /**
     * �������Իط���Ŀ����
     * @param questionName �����õ����Իط���Ŀ���Ƶ�ֵ
     */
    public void setQuestionName(String questionName){
        this.questionName = StringUtils.rightTrim(questionName);
    }

    /**
     * ��ȡ���Իط���Ŀ����
     * @return ���Իط���Ŀ���Ƶ�ֵ
     */
    public String getQuestionName(){
        return questionName;
    }

    /**
     * �������Իطý��
     * @param questionResult �����õ����Իطý����ֵ
     */
    public void setQuestionResult(String questionResult){
        this.questionResult = StringUtils.rightTrim(questionResult);
    }

    /**
     * ��ȡ���Իطý��
     * @return ���Իطý����ֵ
     */
    public String getQuestionResult(){
        return questionResult;
    }

    /**
     * �����������ⱸע
     * @param questionRemark �����õ��������ⱸע��ֵ
     */
    public void setQuestionRemark(String questionRemark){
        this.questionRemark = StringUtils.rightTrim(questionRemark);
    }

    /**
     * ��ȡ�������ⱸע
     * @return �������ⱸע��ֵ
     */
    public String getQuestionRemark(){
        return questionRemark;
    }

    /**
     * ����������������
     * @param questionType �����õ������������͵�ֵ
     */
    public void setQuestionType(String questionType){
        this.questionType = StringUtils.rightTrim(questionType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getQuestionType(){
        return questionType;
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
