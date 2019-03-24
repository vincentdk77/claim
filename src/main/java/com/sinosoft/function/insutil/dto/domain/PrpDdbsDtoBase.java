package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddbs�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdbsDtoBase implements Serializable{
    /** ����comcode */
    private String comCode = "";
    /** ����comname */
    private String comName = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����hostname */
    private String hostName = "";
    /** ����svrname */
    private String svrName = "";
    /** ����dbsname */
    private String dbsName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdbsDtoBase����
     */
    public PrpDdbsDtoBase(){
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
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
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
     * ��������svrname
     * @param svrName �����õ�����svrname��ֵ
     */
    public void setSvrName(String svrName){
        this.svrName = StringUtils.rightTrim(svrName);
    }

    /**
     * ��ȡ����svrname
     * @return ����svrname��ֵ
     */
    public String getSvrName(){
        return svrName;
    }

    /**
     * ��������dbsname
     * @param dbsName �����õ�����dbsname��ֵ
     */
    public void setDbsName(String dbsName){
        this.dbsName = StringUtils.rightTrim(dbsName);
    }

    /**
     * ��ȡ����dbsname
     * @return ����dbsname��ֵ
     */
    public String getDbsName(){
        return dbsName;
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
