package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����UtiGroup  Ȩ����ű�����ݴ���������<br>
 * ������ 2004-11-09 10:40:47.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupDtoBase implements Serializable{
    /** ����Ȩ����Ŵ��� */
    private String groupCode = "";
    /** ����Ȩ��������� */
    private String groupName = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiGroupDtoBase����
     */
    public UtiGroupDtoBase(){
    }

    /**
     * ��������Ȩ����Ŵ���
     * @param groupCode �����õ�����Ȩ����Ŵ����ֵ
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * ��ȡ����Ȩ����Ŵ���
     * @return ����Ȩ����Ŵ����ֵ
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * ��������Ȩ���������
     * @param groupName �����õ�����Ȩ��������Ƶ�ֵ
     */
    public void setGroupName(String groupName){
        this.groupName = StringUtils.rightTrim(groupName);
    }

    /**
     * ��ȡ����Ȩ���������
     * @return ����Ȩ��������Ƶ�ֵ
     */
    public String getGroupName(){
        return groupName;
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
