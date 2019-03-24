package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddbs���ݿ�ά��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdbsDtoBase implements Serializable{
    /** ���Ի������� */
    private String comCode = "";
    /** ���Ի������� */
    private String comName = "";
    /** �������� */
    private String riskCode = "";
    /** ������������ */
    private String hostName = "";
    /** ���Է��������� */
    private String svrName = "";
    /** �������ݿ��� */
    private String dbsName = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdbsDtoBase����
     */
    public PrpDdbsDtoBase(){
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

    /**
     * �������Ի�������
     * @param comName �����õ����Ի������Ƶ�ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������Ƶ�ֵ
     */
    public String getComName(){
        return comName;
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
     * ����������������
     * @param hostName �����õ������������Ƶ�ֵ
     */
    public void setHostName(String hostName){
        this.hostName = StringUtils.rightTrim(hostName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getHostName(){
        return hostName;
    }

    /**
     * �������Է���������
     * @param svrName �����õ����Է��������Ƶ�ֵ
     */
    public void setSvrName(String svrName){
        this.svrName = StringUtils.rightTrim(svrName);
    }

    /**
     * ��ȡ���Է���������
     * @return ���Է��������Ƶ�ֵ
     */
    public String getSvrName(){
        return svrName;
    }

    /**
     * �����������ݿ���
     * @param dbsName �����õ��������ݿ�����ֵ
     */
    public void setDbsName(String dbsName){
        this.dbsName = StringUtils.rightTrim(dbsName);
    }

    /**
     * ��ȡ�������ݿ���
     * @return �������ݿ�����ֵ
     */
    public String getDbsName(){
        return dbsName;
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
