package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfNode�������ڵ㶨��������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfNodeDtoBase implements Serializable{
    /** ����ģ���� */
    private int modelNo = 0;
    /** ����ģ������ */
    private String modelName = "";
    /** ���Խڵ��� */
    private int nodeNo = 0;
    /** ���Խڵ����� */
    private String nodeName = "";
    /** ���Դ���ʱ�� */
    private int timeLimit = 0;
    /** ���Խ�����־ */
    private String endFlag = "";
    /** ���Դ���Ҫ�� */
    private String criterion = "";
    /** ���Ա��ñ�־ */
    private String flag = "";
    /** ���������� */
    private int taskNo = 0;
    /** ������������ */
    private String taskType = "";
    /** ���Խڵ����� */
    private String nodeType = "";
    /** ���԰����� */
    private String unitCode = "";
    /** ���Բ������� */
    private String unitName = "";
    /** ���԰�����Ա���� */
    private String handlerCode = "";
    /** ���԰�����Ա���� */
    private String handlerName = "";
    /** ���Խڵ�X���� */
    private int posX = 0;
    /** ���Խڵ�Y���� */
    private int posY = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfNodeDtoBase����
     */
    public SwfNodeDtoBase(){
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
     * �������Խڵ���
     * @param nodeNo �����õ����Խڵ��ŵ�ֵ
     */
    public void setNodeNo(int nodeNo){
        this.nodeNo = nodeNo;
    }

    /**
     * ��ȡ���Խڵ���
     * @return ���Խڵ��ŵ�ֵ
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
     * �������Դ���ʱ��
     * @param timeLimit �����õ����Դ���ʱ�޵�ֵ
     */
    public void setTimeLimit(int timeLimit){
        this.timeLimit = timeLimit;
    }

    /**
     * ��ȡ���Դ���ʱ��
     * @return ���Դ���ʱ�޵�ֵ
     */
    public int getTimeLimit(){
        return timeLimit;
    }

    /**
     * �������Խ�����־
     * @param endFlag �����õ����Խ�����־��ֵ
     */
    public void setEndFlag(String endFlag){
        this.endFlag = StringUtils.rightTrim(endFlag);
    }

    /**
     * ��ȡ���Խ�����־
     * @return ���Խ�����־��ֵ
     */
    public String getEndFlag(){
        return endFlag;
    }

    /**
     * �������Դ���Ҫ��
     * @param criterion �����õ����Դ���Ҫ���ֵ
     */
    public void setCriterion(String criterion){
        this.criterion = StringUtils.rightTrim(criterion);
    }

    /**
     * ��ȡ���Դ���Ҫ��
     * @return ���Դ���Ҫ���ֵ
     */
    public String getCriterion(){
        return criterion;
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
     * ��������������
     * @param taskNo �����õ����������ŵ�ֵ
     */
    public void setTaskNo(int taskNo){
        this.taskNo = taskNo;
    }

    /**
     * ��ȡ����������
     * @return ���������ŵ�ֵ
     */
    public int getTaskNo(){
        return taskNo;
    }

    /**
     * ����������������
     * @param taskType �����õ������������͵�ֵ
     */
    public void setTaskType(String taskType){
        this.taskType = StringUtils.rightTrim(taskType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getTaskType(){
        return taskType;
    }

    /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ����͵�ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����͵�ֵ
     */
    public String getNodeType(){
        return nodeType;
    }

    /**
     * �������԰�����
     * @param unitCode �����õ����԰����ŵ�ֵ
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * ��ȡ���԰�����
     * @return ���԰����ŵ�ֵ
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * �������Բ�������
     * @param unitName �����õ����Բ������Ƶ�ֵ
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ������Ƶ�ֵ
     */
    public String getUnitName(){
        return unitName;
    }

    /**
     * �������԰�����Ա����
     * @param handlerCode �����õ����԰�����Ա�����ֵ
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * ��ȡ���԰�����Ա����
     * @return ���԰�����Ա�����ֵ
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * �������԰�����Ա����
     * @param handlerName �����õ����԰�����Ա���Ƶ�ֵ
     */
    public void setHandlerName(String handlerName){
        this.handlerName = StringUtils.rightTrim(handlerName);
    }

    /**
     * ��ȡ���԰�����Ա����
     * @return ���԰�����Ա���Ƶ�ֵ
     */
    public String getHandlerName(){
        return handlerName;
    }

    /**
     * �������Խڵ�X����
     * @param posX �����õ����Խڵ�X�����ֵ
     */
    public void setPosX(int posX){
        this.posX = posX;
    }

    /**
     * ��ȡ���Խڵ�X����
     * @return ���Խڵ�X�����ֵ
     */
    public int getPosX(){
        return posX;
    }

    /**
     * �������Խڵ�Y����
     * @param posY �����õ����Խڵ�Y�����ֵ
     */
    public void setPosY(int posY){
        this.posY = posY;
    }

    /**
     * ��ȡ���Խڵ�Y����
     * @return ���Խڵ�Y�����ֵ
     */
    public int getPosY(){
        return posY;
    }
}
