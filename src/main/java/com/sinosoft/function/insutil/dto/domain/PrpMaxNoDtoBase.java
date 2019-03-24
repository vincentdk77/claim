package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpmaxno�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpMaxNoDtoBase implements Serializable{
    /** ����groupno */
    private String groupNo = "";
    /** ����tablename */
    private String tableName = "";
    /** ����maxno */
    private String maxNo = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpMaxNoDtoBase����
     */
    public PrpMaxNoDtoBase(){
    }

    /**
     * ��������groupno
     * @param groupNo �����õ�����groupno��ֵ
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * ��ȡ����groupno
     * @return ����groupno��ֵ
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * ��������tablename
     * @param tableName �����õ�����tablename��ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ����tablename
     * @return ����tablename��ֵ
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * ��������maxno
     * @param maxNo �����õ�����maxno��ֵ
     */
    public void setMaxNo(String maxNo){
        this.maxNo = StringUtils.rightTrim(maxNo);
    }

    /**
     * ��ȡ����maxno
     * @return ����maxno��ֵ
     */
    public String getMaxNo(){
        return maxNo;
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