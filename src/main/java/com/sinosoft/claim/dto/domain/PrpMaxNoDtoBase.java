package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpmaxno��֤�ű�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpMaxNoDtoBase implements Serializable{
    /** ���Ա��� */
    private String groupNo = "";
    /** ���Ա�� */
    private String maxNo = "";
    /** ���Ա��� */
    private String tableName = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpMaxNoDtoBase����
     */
    public PrpMaxNoDtoBase(){
    }

    /**
     * �������Ա���
     * @param groupNo �����õ����Ա����ֵ
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա����ֵ
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * �������Ա��
     * @param maxNo �����õ����Ա�ŵ�ֵ
     */
    public void setMaxNo(String maxNo){
        this.maxNo = StringUtils.rightTrim(maxNo);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ŵ�ֵ
     */
    public String getMaxNo(){
        return maxNo;
    }

    /**
     * �������Ա���
     * @param tableName �����õ����Ա�����ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public String getTableName(){
        return tableName;
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
