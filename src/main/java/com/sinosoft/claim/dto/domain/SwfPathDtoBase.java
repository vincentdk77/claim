package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfPath������·������������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPathDtoBase implements Serializable{
    /** ����ģ���� */
    private int modelNo = 0;
    /** ����ģ������ */
    private String modelName = "";
    /** ���Գ̱ߺ� */
    private int pathNo = 0;
    /** ����·������ */
    private String pathName = "";
    /** ������ʼ�ڵ� */
    private int startNodeNo = 0;
    /** ������ʼ�ڵ����� */
    private String startNodeName = "";
    /** ������ֹ�ڵ� */
    private int endNodeNo = 0;
    /** ������ֹ�ڵ����� */
    private String endNodeName = "";
    /** �������ȼ��� */
    private int priority = 0;
    /** �����Ƿ�ȱʡֵ */
    private String defaultFlag = "";
    /** ���Ա��ñ�־ */
    private String flag = "";
    /** �����Ƿ������ת���� */
    private String conditionStatus = "";
    /** ����������ת�����÷����� */
    private String forwardServices = "";
    /** ����������ת�����÷����� */
    private String backwardServices = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfPathDtoBase����
     */
    public SwfPathDtoBase(){
    }

    /**
     * ��������ģ����
     * @param modelNo �����õ�����ģ���ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ����
     * @return ����ģ���ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * ��������ģ������
     * @param modelName �����õ�����ģ�����Ƶ�ֵ
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * ��ȡ����ģ������
     * @return ����ģ�����Ƶ�ֵ
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * �������Գ̱ߺ�
     * @param pathNo �����õ����Գ̱ߺŵ�ֵ
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * ��ȡ���Գ̱ߺ�
     * @return ���Գ̱ߺŵ�ֵ
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * ��������·������
     * @param pathName �����õ�����·�����Ƶ�ֵ
     */
    public void setPathName(String pathName){
        this.pathName = StringUtils.rightTrim(pathName);
    }

    /**
     * ��ȡ����·������
     * @return ����·�����Ƶ�ֵ
     */
    public String getPathName(){
        return pathName;
    }

    /**
     * ����������ʼ�ڵ�
     * @param startNodeNo �����õ�������ʼ�ڵ��ֵ
     */
    public void setStartNodeNo(int startNodeNo){
        this.startNodeNo = startNodeNo;
    }

    /**
     * ��ȡ������ʼ�ڵ�
     * @return ������ʼ�ڵ��ֵ
     */
    public int getStartNodeNo(){
        return startNodeNo;
    }

    /**
     * ����������ʼ�ڵ�����
     * @param startNodeName �����õ�������ʼ�ڵ����Ƶ�ֵ
     */
    public void setStartNodeName(String startNodeName){
        this.startNodeName = StringUtils.rightTrim(startNodeName);
    }

    /**
     * ��ȡ������ʼ�ڵ�����
     * @return ������ʼ�ڵ����Ƶ�ֵ
     */
    public String getStartNodeName(){
        return startNodeName;
    }

    /**
     * ����������ֹ�ڵ�
     * @param endNodeNo �����õ�������ֹ�ڵ��ֵ
     */
    public void setEndNodeNo(int endNodeNo){
        this.endNodeNo = endNodeNo;
    }

    /**
     * ��ȡ������ֹ�ڵ�
     * @return ������ֹ�ڵ��ֵ
     */
    public int getEndNodeNo(){
        return endNodeNo;
    }

    /**
     * ����������ֹ�ڵ�����
     * @param endNodeName �����õ�������ֹ�ڵ����Ƶ�ֵ
     */
    public void setEndNodeName(String endNodeName){
        this.endNodeName = StringUtils.rightTrim(endNodeName);
    }

    /**
     * ��ȡ������ֹ�ڵ�����
     * @return ������ֹ�ڵ����Ƶ�ֵ
     */
    public String getEndNodeName(){
        return endNodeName;
    }

    /**
     * �����������ȼ���
     * @param priority �����õ��������ȼ����ֵ
     */
    public void setPriority(int priority){
        this.priority = priority;
    }

    /**
     * ��ȡ�������ȼ���
     * @return �������ȼ����ֵ
     */
    public int getPriority(){
        return priority;
    }

    /**
     * ���������Ƿ�ȱʡֵ
     * @param defaultFlag �����õ������Ƿ�ȱʡֵ��ֵ
     */
    public void setDefaultFlag(String defaultFlag){
        this.defaultFlag = StringUtils.rightTrim(defaultFlag);
    }

    /**
     * ��ȡ�����Ƿ�ȱʡֵ
     * @return �����Ƿ�ȱʡֵ��ֵ
     */
    public String getDefaultFlag(){
        return defaultFlag;
    }

    /**
     * �������Ա��ñ�־
     * @param flag �����õ����Ա��ñ�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա��ñ�־
     * @return ���Ա��ñ�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ���������Ƿ������ת����
     * @param conditionStatus �����õ������Ƿ������ת������ֵ
     */
    public void setConditionStatus(String conditionStatus){
        this.conditionStatus = StringUtils.rightTrim(conditionStatus);
    }

    /**
     * ��ȡ�����Ƿ������ת����
     * @return �����Ƿ������ת������ֵ
     */
    public String getConditionStatus(){
        return conditionStatus;
    }

    /**
     * ��������������ת�����÷�����
     * @param forwardServices �����õ�����������ת�����÷�������ֵ
     */
    public void setForwardServices(String forwardServices){
        this.forwardServices = StringUtils.rightTrim(forwardServices);
    }

    /**
     * ��ȡ����������ת�����÷�����
     * @return ����������ת�����÷�������ֵ
     */
    public String getForwardServices(){
        return forwardServices;
    }

    /**
     * ��������������ת�����÷�����
     * @param backwardServices �����õ�����������ת�����÷�������ֵ
     */
    public void setBackwardServices(String backwardServices){
        this.backwardServices = StringUtils.rightTrim(backwardServices);
    }

    /**
     * ��ȡ����������ת�����÷�����
     * @return ����������ת�����÷�������ֵ
     */
    public String getBackwardServices(){
        return backwardServices;
    }
}
