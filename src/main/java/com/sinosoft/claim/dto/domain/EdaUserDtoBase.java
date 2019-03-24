package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����EdaUser-��ϯԱ��Ϣ������ݴ���������<br>
 * ������ 2005-06-22 14:56:36.573<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaUserDtoBase implements Serializable{
    /** ������ϯԱ���� */
    private String edaUserCode = "";
    /** ������ϯԱ���� */
    private String edaUserName = "";
    /** ����ҵ��ϵͳԱ������ */
    private String userCode = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�EdaUserDtoBase����
     */
    public EdaUserDtoBase(){
    }

    /**
     * ����������ϯԱ����
     * @param edaUserCode �����õ�������ϯԱ���ŵ�ֵ
     */
    public void setEdaUserCode(String edaUserCode){
        this.edaUserCode = StringUtils.rightTrim(edaUserCode);
    }

    /**
     * ��ȡ������ϯԱ����
     * @return ������ϯԱ���ŵ�ֵ
     */
    public String getEdaUserCode(){
        return edaUserCode;
    }

    /**
     * ����������ϯԱ����
     * @param edaUserName �����õ�������ϯԱ���Ƶ�ֵ
     */
    public void setEdaUserName(String edaUserName){
        this.edaUserName = StringUtils.rightTrim(edaUserName);
    }

    /**
     * ��ȡ������ϯԱ����
     * @return ������ϯԱ���Ƶ�ֵ
     */
    public String getEdaUserName(){
        return edaUserName;
    }

    /**
     * ��������ҵ��ϵͳԱ������
     * @param userCode �����õ�����ҵ��ϵͳԱ�������ֵ
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * ��ȡ����ҵ��ϵͳԱ������
     * @return ����ҵ��ϵͳԱ�������ֵ
     */
    public String getUserCode(){
        return userCode;
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
