package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdagentcom�б�����,�б���˾������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentComDtoBase implements Serializable{
    /** ���Գб��������� */
    private String centreCode = "";
    /** ���Գб��������� */
    private String centreName = "";
    /** ���Գб���˾���� */
    private String unitCode = "";
    /** ���Գб���˾���� */
    private String unitName = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDagentComDtoBase����
     */
    public PrpDagentComDtoBase(){
    }

    /**
     * �������Գб���������
     * @param centreCode �����õ����Գб����������ֵ
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * ��ȡ���Գб���������
     * @return ���Գб����������ֵ
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * �������Գб���������
     * @param centreName �����õ����Գб��������Ƶ�ֵ
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * ��ȡ���Գб���������
     * @return ���Գб��������Ƶ�ֵ
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * �������Գб���˾����
     * @param unitCode �����õ����Գб���˾�����ֵ
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾�����ֵ
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * �������Գб���˾����
     * @param unitName �����õ����Գб���˾���Ƶ�ֵ
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * ��ȡ���Գб���˾����
     * @return ���Գб���˾���Ƶ�ֵ
     */
    public String getUnitName(){
        return unitName;
    }
}
