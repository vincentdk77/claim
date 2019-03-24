package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpCitemHouse�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemHouseDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����ItemNo */
    private long itemNo = 0L;
    /** ����Structure */
    private String structure = "";
    /** ����BuildArea */
    private double buildArea = 0D;
    /** ����Remark */
    private String remark = "";
    /** ����flag */
    private String flag = "";
    /** ����UnitValue */
    private double unitValue = 0D;
    /** ����SumValue */
    private double sumValue = 0D;
    /** ����BuildTime */
    private DateTime buildTime = new DateTime();
    /** ����UseAge */
    private String useAge = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCitemHouseDtoBase����
     */
    public PrpCitemHouseDtoBase(){
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������ItemNo
     * @param itemNo �����õ�����ItemNo��ֵ
     */
    public void setItemNo(long itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ����ItemNo
     * @return ����ItemNo��ֵ
     */
    public long getItemNo(){
        return itemNo;
    }

    /**
     * ��������Structure
     * @param structure �����õ�����Structure��ֵ
     */
    public void setStructure(String structure){
        this.structure = StringUtils.rightTrim(structure);
    }

    /**
     * ��ȡ����Structure
     * @return ����Structure��ֵ
     */
    public String getStructure(){
        return structure;
    }

    /**
     * ��������BuildArea
     * @param buildArea �����õ�����BuildArea��ֵ
     */
    public void setBuildArea(double buildArea){
        this.buildArea = buildArea;
    }

    /**
     * ��ȡ����BuildArea
     * @return ����BuildArea��ֵ
     */
    public double getBuildArea(){
        return buildArea;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
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

    /**
     * ��������UnitValue
     * @param unitValue �����õ�����UnitValue��ֵ
     */
    public void setUnitValue(double unitValue){
        this.unitValue = unitValue;
    }

    /**
     * ��ȡ����UnitValue
     * @return ����UnitValue��ֵ
     */
    public double getUnitValue(){
        return unitValue;
    }

    /**
     * ��������SumValue
     * @param sumValue �����õ�����SumValue��ֵ
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * ��ȡ����SumValue
     * @return ����SumValue��ֵ
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * ��������BuildTime
     * @param buildTime �����õ�����BuildTime��ֵ
     */
    public void setBuildTime(DateTime buildTime){
        this.buildTime = buildTime;
    }

    /**
     * ��ȡ����BuildTime
     * @return ����BuildTime��ֵ
     */
    public DateTime getBuildTime(){
        return buildTime;
    }

    /**
     * ��������UseAge
     * @param useAge �����õ�����UseAge��ֵ
     */
    public void setUseAge(String useAge){
        this.useAge = StringUtils.rightTrim(useAge);
    }

    /**
     * ��ȡ����UseAge
     * @return ����UseAge��ֵ
     */
    public String getUseAge(){
        return useAge;
    }
}
