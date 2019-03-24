package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleObject-���ȶ��������ݴ���������<br>
 * ������ 2005-07-11 16:53:05.889<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleObjectDtoBase implements Serializable{
    /** ���Ե��ȶ������ */
    private String scheduleObjectID = "";
    /** ���Ե��ȶ������� */
    private String scheduleObjectName = "";
    /** ���Ե��ȶ������ */
    private String objectType = "";
    /** ���Ե��ȶ������ڱ����� */
    private String objectKey = "";
    /** ���Ե��ȶ������ڱ� */
    private String objectTable = "";
    /** ���Ե��ȶ����������� */
    private String objectArea = "";
    /** ���Ե��ȶ����������� */
    private int objectGroup = 0;
    /** ���Ա�־ */
    private String flag = "";
    /** ���Ի������� */
    private String comCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleObjectDtoBase����
     */
    public PrpLscheduleObjectDtoBase(){
    }

    /**
     * �������Ե��ȶ������
     * @param scheduleObjectID �����õ����Ե��ȶ�������ֵ
     */
    public void setScheduleObjectID(String scheduleObjectID){
        this.scheduleObjectID = StringUtils.rightTrim(scheduleObjectID);
    }

    /**
     * ��ȡ���Ե��ȶ������
     * @return ���Ե��ȶ�������ֵ
     */
    public String getScheduleObjectID(){
        return scheduleObjectID;
    }

    /**
     * �������Ե��ȶ�������
     * @param scheduleObjectName �����õ����Ե��ȶ������Ƶ�ֵ
     */
    public void setScheduleObjectName(String scheduleObjectName){
        this.scheduleObjectName = StringUtils.rightTrim(scheduleObjectName);
    }

    /**
     * ��ȡ���Ե��ȶ�������
     * @return ���Ե��ȶ������Ƶ�ֵ
     */
    public String getScheduleObjectName(){
        return scheduleObjectName;
    }

    /**
     * �������Ե��ȶ������
     * @param objectType �����õ����Ե��ȶ�������ֵ
     */
    public void setObjectType(String objectType){
        this.objectType = StringUtils.rightTrim(objectType);
    }

    /**
     * ��ȡ���Ե��ȶ������
     * @return ���Ե��ȶ�������ֵ
     */
    public String getObjectType(){
        return objectType;
    }

    /**
     * �������Ե��ȶ������ڱ�����
     * @param objectKey �����õ����Ե��ȶ������ڱ�������ֵ
     */
    public void setObjectKey(String objectKey){
        this.objectKey = StringUtils.rightTrim(objectKey);
    }

    /**
     * ��ȡ���Ե��ȶ������ڱ�����
     * @return ���Ե��ȶ������ڱ�������ֵ
     */
    public String getObjectKey(){
        return objectKey;
    }

    /**
     * �������Ե��ȶ������ڱ�
     * @param objectTable �����õ����Ե��ȶ������ڱ��ֵ
     */
    public void setObjectTable(String objectTable){
        this.objectTable = StringUtils.rightTrim(objectTable);
    }

    /**
     * ��ȡ���Ե��ȶ������ڱ�
     * @return ���Ե��ȶ������ڱ��ֵ
     */
    public String getObjectTable(){
        return objectTable;
    }

    /**
     * �������Ե��ȶ�����������
     * @param objectArea �����õ����Ե��ȶ�������������ֵ
     */
    public void setObjectArea(String objectArea){
        this.objectArea = StringUtils.rightTrim(objectArea);
    }

    /**
     * ��ȡ���Ե��ȶ�����������
     * @return ���Ե��ȶ�������������ֵ
     */
    public String getObjectArea(){
        return objectArea;
    }

    /**
     * �������Ե��ȶ�����������
     * @param objectGroup �����õ����Ե��ȶ������������ֵ
     */
    public void setObjectGroup(int objectGroup){
        this.objectGroup = objectGroup;
    }

    /**
     * ��ȡ���Ե��ȶ�����������
     * @return ���Ե��ȶ������������ֵ
     */
    public int getObjectGroup(){
        return objectGroup;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }
}
