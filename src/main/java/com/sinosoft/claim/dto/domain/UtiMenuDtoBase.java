package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utimenu�˵����Ʊ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiMenuDtoBase implements Serializable{
    /** ���Բ˵��� */
    private String menuName = "";
    /** �����ȼ� */
    private String hotKey = "";
    /** �������� */
    private String riskCode = "";
    /** ���Բ˵��� */
    private String menuItem = "";
    /** ������Ϣ */
    private String message = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiMenuDtoBase����
     */
    public UtiMenuDtoBase(){
    }

    /**
     * �������Բ˵���
     * @param menuName �����õ����Բ˵�����ֵ
     */
    public void setMenuName(String menuName){
        this.menuName = StringUtils.rightTrim(menuName);
    }

    /**
     * ��ȡ���Բ˵���
     * @return ���Բ˵�����ֵ
     */
    public String getMenuName(){
        return menuName;
    }

    /**
     * ���������ȼ�
     * @param hotKey �����õ������ȼ���ֵ
     */
    public void setHotKey(String hotKey){
        this.hotKey = StringUtils.rightTrim(hotKey);
    }

    /**
     * ��ȡ�����ȼ�
     * @return �����ȼ���ֵ
     */
    public String getHotKey(){
        return hotKey;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Բ˵���
     * @param menuItem �����õ����Բ˵�����ֵ
     */
    public void setMenuItem(String menuItem){
        this.menuItem = StringUtils.rightTrim(menuItem);
    }

    /**
     * ��ȡ���Բ˵���
     * @return ���Բ˵�����ֵ
     */
    public String getMenuItem(){
        return menuItem;
    }

    /**
     * ����������Ϣ
     * @param message �����õ�������Ϣ��ֵ
     */
    public void setMessage(String message){
        this.message = StringUtils.rightTrim(message);
    }

    /**
     * ��ȡ������Ϣ
     * @return ������Ϣ��ֵ
     */
    public String getMessage(){
        return message;
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
