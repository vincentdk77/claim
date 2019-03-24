package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgnode�������ڵ�ģ�������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGnodeDtoBase implements Serializable{
    /** ����ģ��� */
    private int modelNo = 0;
    /** ���Խڵ�� */
    private int nodeNo = 0;
    /** ���Խڵ����� */
    private String nodeName = "";
    /** �����ӽڵ�� */
    private int sonNodeNo = 0;
    /** �����ӽڵ����� */
    private String sonNodeName = "";
    /** ����Ԥ��ʱ�� */
    private int limitDay = 0;
    /** ���Ը�λ���� */
    private String gradeCode = "";
    /** ���Թ����������� */
    private String comCode = "";
    /** ���Գ����������� */
    private String makeCom = "";
    /** ���Խڵ�״̬ */
    private String nodeFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGnodeDtoBase����
     */
    public PrpGnodeDtoBase(){
    }

    /**
     * ��������ģ���
     * @param modelNo �����õ�����ģ��ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ���
     * @return ����ģ��ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * �������Խڵ��
     * @param nodeNo �����õ����Խڵ�ŵ�ֵ
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * ��ȡ���Խڵ��
     * @return ���Խڵ�ŵ�ֵ
     */
    public int getNodeNo(){
        return nodeNo;
    }

    /**
     * �������Խڵ�����
     * @param nodeName �����õ����Խڵ����Ƶ�ֵ
     */
    public void setNodeName(String nodeName){
        this.nodeName = StringUtils.rightTrim(nodeName);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����Ƶ�ֵ
     */
    public String getNodeName(){
        return nodeName;
    }

    /**
     * ���������ӽڵ��
     * @param sonNodeNo �����õ������ӽڵ�ŵ�ֵ
     */
    public void setSonNodeNo(int sonNodeNo){
        this.sonNodeNo = sonNodeNo;
    }

    /**
     * ��ȡ�����ӽڵ��
     * @return �����ӽڵ�ŵ�ֵ
     */
    public int getSonNodeNo(){
        return sonNodeNo;
    }

    /**
     * ���������ӽڵ�����
     * @param sonNodeName �����õ������ӽڵ����Ƶ�ֵ
     */
    public void setSonNodeName(String sonNodeName){
        this.sonNodeName = StringUtils.rightTrim(sonNodeName);
    }

    /**
     * ��ȡ�����ӽڵ�����
     * @return �����ӽڵ����Ƶ�ֵ
     */
    public String getSonNodeName(){
        return sonNodeName;
    }

    /**
     * ��������Ԥ��ʱ��
     * @param limitDay �����õ�����Ԥ��ʱ�޵�ֵ
     */
    public void setLimitDay(int limitDay){
        this.limitDay = limitDay;
    }

    /**
     * ��ȡ����Ԥ��ʱ��
     * @return ����Ԥ��ʱ�޵�ֵ
     */
    public int getLimitDay(){
        return limitDay;
    }

    /**
     * �������Ը�λ����
     * @param gradeCode �����õ����Ը�λ�����ֵ
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * ��ȡ���Ը�λ����
     * @return ���Ը�λ�����ֵ
     */
    public String getGradeCode(){
        return gradeCode;
    }

    /**
     * �������Թ�����������
     * @param comCode �����õ����Թ������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Գ�����������
     * @param makeCom �����õ����Գ������������ֵ
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ������������ֵ
     */
    public String getMakeCom(){
        return makeCom;
    }

    /**
     * �������Խڵ�״̬
     * @param nodeFlag �����õ����Խڵ�״̬��ֵ
     */
    public void setNodeFlag(String nodeFlag){
        this.nodeFlag = StringUtils.rightTrim(nodeFlag);
    }

    /**
     * ��ȡ���Խڵ�״̬
     * @return ���Խڵ�״̬��ֵ
     */
    public String getNodeFlag(){
        return nodeFlag;
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
