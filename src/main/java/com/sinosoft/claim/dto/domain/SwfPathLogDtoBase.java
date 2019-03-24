package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfPathLog������·����־�������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfPathLogDtoBase implements Serializable{
    /** �������̱�� */
    private String flowID = "";
    /** �������̱ߺ� */
    private int pathNo = 0;
    /** ����ģ��� */
    private int modelNo = 0;
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
    /** ��������ʱ�� */
    private DateTime flowInTime = new DateTime();
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfPathLogDtoBase����
     */
    public SwfPathLogDtoBase(){
    }

    /**
     * �����������̱��
     * @param flowID �����õ��������̱�ŵ�ֵ
     */
    public void setFlowID(String flowID){
        this.flowID = StringUtils.rightTrim(flowID);
    }

    /**
     * ��ȡ�������̱��
     * @return �������̱�ŵ�ֵ
     */
    public String getFlowID(){
        return flowID;
    }

    /**
     * �����������̱ߺ�
     * @param pathNo �����õ��������̱ߺŵ�ֵ
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * ��ȡ�������̱ߺ�
     * @return �������̱ߺŵ�ֵ
     */
    public int getPathNo(){
        return pathNo;
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
     * ������������ʱ��
     * @param flowInTime �����õ���������ʱ���ֵ
     */
    public void setFlowInTime(DateTime flowInTime){
        this.flowInTime = flowInTime;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getFlowInTime(){
        return flowInTime;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
