package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class AccidentPersonInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ������� PK */
    private int serialNo = 0;
    /** �����¹��ߴ��� */
    private String acciCode = "";
    /** �����¹������� */
    private String acciName = "";
    /** �����Ա�(9δ֪1��2Ů) */
    private String sex = "";
    /** �������� */
    private int age = 0;
    /** �������֤���� */
    private String identifyNumber = "";
    /** ������������Ϣ */
    private String perilContext = "";
    /** ���Ա�����Ϣ */
    private String beneRiskContext = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�AccidentPersonInfoDto����
     */
    public AccidentPersonInfoDto(){
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
     * ���������¹��ߴ���
     * @param acciCode �����õ������¹��ߴ����ֵ
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * ��ȡ�����¹��ߴ���
     * @return �����¹��ߴ����ֵ
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * ���������¹�������
     * @param acciName �����õ������¹������Ƶ�ֵ
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * ��ȡ�����¹�������
     * @return �����¹������Ƶ�ֵ
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * ���������Ա�(9δ֪1��2Ů)
     * @param sex �����õ������Ա�(9δ֪1��2Ů)��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ�����Ա�(9δ֪1��2Ů)
     * @return �����Ա�(9δ֪1��2Ů)��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ������������
     * @param age �����õ����������ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * �����������֤����
     * @param identifyNumber �����õ��������֤�����ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * ����������������Ϣ
     * @param perilContext �����õ�������������Ϣ��ֵ
     */
    public void setPerilContext(String perilContext){
        this.perilContext = StringUtils.rightTrim(perilContext);
    }

    /**
     * ��ȡ������������Ϣ
     * @return ������������Ϣ��ֵ
     */
    public String getPerilContext(){
        return perilContext;
    }

    /**
     * �������Ա�����Ϣ
     * @param beneRiskContext �����õ����Ա�����Ϣ��ֵ
     */
    public void setBeneRiskContext(String beneRiskContext){
        this.beneRiskContext = StringUtils.rightTrim(beneRiskContext);
    }

    /**
     * ��ȡ���Ա�����Ϣ
     * @return ���Ա�����Ϣ��ֵ
     */
    public String getBeneRiskContext(){
        return beneRiskContext;
    }

}
