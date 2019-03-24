package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����UtiRoute·�����ñ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:40<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiRouteDtoBase implements Serializable{
    /** ���Ի������� */
    private String comCode = "";
    /** ���Ի������� */
    private String comName = "";
    /** ������������ */
    private String hostName = "";
    /** ����IP��ַ */
    private String iPaddress = "";
    /** ���Է��������� */
    private String serverName = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiRouteDtoBase����
     */
    public UtiRouteDtoBase(){
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
     * ��������IP��ַ
     * @param iPaddress �����õ�����IP��ַ��ֵ
     */
    public void setIPaddress(String iPaddress){
        this.iPaddress = StringUtils.rightTrim(iPaddress);
    }

    /**
     * ��ȡ����IP��ַ
     * @return ����IP��ַ��ֵ
     */
    public String getIPaddress(){
        return iPaddress;
    }

    /**
     * �������Է���������
     * @param serverName �����õ����Է��������Ƶ�ֵ
     */
    public void setServerName(String serverName){
        this.serverName = StringUtils.rightTrim(serverName);
    }

    /**
     * ��ȡ���Է���������
     * @return ���Է��������Ƶ�ֵ
     */
    public String getServerName(){
        return serverName;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
