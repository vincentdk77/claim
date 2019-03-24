package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdareagroup����������������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDareaGroupDtoBase implements Serializable{
    /** �������ڴ�����Ļ��� */
    private String comCode = "";
    /** ���Է���������� */
    private String areaGroup = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDareaGroupDtoBase����
     */
    public PrpDareaGroupDtoBase(){
    }

    /**
     * �����������ڴ�����Ļ���
     * @param comCode �����õ��������ڴ�����Ļ�����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ�������ڴ�����Ļ���
     * @return �������ڴ�����Ļ�����ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Է����������
     * @param areaGroup �����õ����Է���������ŵ�ֵ
     */
    public void setAreaGroup(String areaGroup){
        this.areaGroup = StringUtils.rightTrim(areaGroup);
    }

    /**
     * ��ȡ���Է����������
     * @return ���Է���������ŵ�ֵ
     */
    public String getAreaGroup(){
        return areaGroup;
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
}
