package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdagentcom�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentComDtoBase implements Serializable{
    /** ����centrecode */
    private String centreCode = "";
    /** ����centrename */
    private String centreName = "";
    /** ����unitcode */
    private String unitCode = "";
    /** ����unitname */
    private String unitName = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDagentComDtoBase����
     */
    public PrpDagentComDtoBase(){
    }

    /**
     * ��������centrecode
     * @param centreCode �����õ�����centrecode��ֵ
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * ��ȡ����centrecode
     * @return ����centrecode��ֵ
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * ��������centrename
     * @param centreName �����õ�����centrename��ֵ
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * ��ȡ����centrename
     * @return ����centrename��ֵ
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * ��������unitcode
     * @param unitCode �����õ�����unitcode��ֵ
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * ��ȡ����unitcode
     * @return ����unitcode��ֵ
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * ��������unitname
     * @param unitName �����õ�����unitname��ֵ
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * ��ȡ����unitname
     * @return ����unitname��ֵ
     */
    public String getUnitName(){
        return unitName;
    }
}
