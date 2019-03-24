package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiroute�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiRouteDtoBase implements Serializable{
    /** ����comcode */
    private String comCode = "";
    /** ����comname */
    private String comName = "";
    /** ����hostname */
    private String hostName = "";
    /** ����ipaddress */
    private String iPAddress = "";
    /** ����servername */
    private String serverName = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiRouteDtoBase����
     */
    public UtiRouteDtoBase(){
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������comname
     * @param comName �����õ�����comname��ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ����comname
     * @return ����comname��ֵ
     */
    public String getComName(){
        return comName;
    }

    /**
     * ��������hostname
     * @param hostName �����õ�����hostname��ֵ
     */
    public void setHostName(String hostName){
        this.hostName = StringUtils.rightTrim(hostName);
    }

    /**
     * ��ȡ����hostname
     * @return ����hostname��ֵ
     */
    public String getHostName(){
        return hostName;
    }

    /**
     * ��������ipaddress
     * @param iPAddress �����õ�����ipaddress��ֵ
     */
    public void setIPAddress(String iPAddress){
        this.iPAddress = StringUtils.rightTrim(iPAddress);
    }

    /**
     * ��ȡ����ipaddress
     * @return ����ipaddress��ֵ
     */
    public String getIPAddress(){
        return iPAddress;
    }

    /**
     * ��������servername
     * @param serverName �����õ�����servername��ֵ
     */
    public void setServerName(String serverName){
        this.serverName = StringUtils.rightTrim(serverName);
    }

    /**
     * ��ȡ����servername
     * @return ����servername��ֵ
     */
    public String getServerName(){
        return serverName;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
