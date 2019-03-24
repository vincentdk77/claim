package com.gyic.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SETTLEMAINLIST的数据传输对象基类<br>
 */
public class SettlemainlistDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性SETTLELISTCODE */
    private String settlelistcode = "";
    /** 属性FAREACODE */
    private String fareacode = "";
    /** 属性INUSRELISTCODE */
    private String inusrelistcode = "";
    /** 属性REPORTCODE */
    private String reportcode = "";
    /** 属性REGISTERCODE */
    private String registercode = "";
    /** 属性COMPENSATENO */
    private String compensateno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性VALIDITY */
    private String validity = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性UPDATECODE */
    private String updatecode = "";
    /** 属性UPDATEDATE */
    private DateTime updatedate = new DateTime();
    /** 属性OPCODE */
    private String opcode = "";
    /** 属性DAMAGETIME */
    private DateTime damagetime = new DateTime();

    /**
     *  默认构造方法,构造一个默认的SettlemainlistDtoBase对象
     */
    public SettlemainlistDtoBase(){
    }

    /**
     * 设置属性SETTLELISTCODE
     * @param settlelistcode 待设置的属性SETTLELISTCODE的值
     */
    public void setSettlelistcode(String settlelistcode){
        this.settlelistcode = StringUtils.rightTrim(settlelistcode);
    }

    /**
     * 获取属性SETTLELISTCODE
     * @return 属性SETTLELISTCODE的值
     */
    public String getSettlelistcode(){
        return settlelistcode;
    }

    /**
     * 设置属性FAREACODE
     * @param fareacode 待设置的属性FAREACODE的值
     */
    public void setFareacode(String fareacode){
        this.fareacode = StringUtils.rightTrim(fareacode);
    }

    /**
     * 获取属性FAREACODE
     * @return 属性FAREACODE的值
     */
    public String getFareacode(){
        return fareacode;
    }

    /**
     * 设置属性INUSRELISTCODE
     * @param inusrelistcode 待设置的属性INUSRELISTCODE的值
     */
    public void setInusrelistcode(String inusrelistcode){
        this.inusrelistcode = StringUtils.rightTrim(inusrelistcode);
    }

    /**
     * 获取属性INUSRELISTCODE
     * @return 属性INUSRELISTCODE的值
     */
    public String getInusrelistcode(){
        return inusrelistcode;
    }

    /**
     * 设置属性REPORTCODE
     * @param reportcode 待设置的属性REPORTCODE的值
     */
    public void setReportcode(String reportcode){
        this.reportcode = StringUtils.rightTrim(reportcode);
    }

    /**
     * 获取属性REPORTCODE
     * @return 属性REPORTCODE的值
     */
    public String getReportcode(){
        return reportcode;
    }

    /**
     * 设置属性REGISTERCODE
     * @param registercode 待设置的属性REGISTERCODE的值
     */
    public void setRegistercode(String registercode){
        this.registercode = StringUtils.rightTrim(registercode);
    }

    /**
     * 获取属性REGISTERCODE
     * @return 属性REGISTERCODE的值
     */
    public String getRegistercode(){
        return registercode;
    }

    /**
     * 设置属性COMPENSATENO
     * @param compensateno 待设置的属性COMPENSATENO的值
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * 获取属性COMPENSATENO
     * @return 属性COMPENSATENO的值
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * 设置属性POLICYNO
     * @param policyno 待设置的属性POLICYNO的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性POLICYNO
     * @return 属性POLICYNO的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性CLASSCODE
     * @param classcode 待设置的属性CLASSCODE的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性CLASSCODE
     * @return 属性CLASSCODE的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性RISKCODE
     * @param riskcode 待设置的属性RISKCODE的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性RISKCODE
     * @return 属性RISKCODE的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性VALIDITY
     * @param validity 待设置的属性VALIDITY的值
     */
    public void setValidity(String validity){
        this.validity = StringUtils.rightTrim(validity);
    }

    /**
     * 获取属性VALIDITY
     * @return 属性VALIDITY的值
     */
    public String getValidity(){
        return validity;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性UPDATECODE
     * @param updatecode 待设置的属性UPDATECODE的值
     */
    public void setUpdatecode(String updatecode){
        this.updatecode = StringUtils.rightTrim(updatecode);
    }

    /**
     * 获取属性UPDATECODE
     * @return 属性UPDATECODE的值
     */
    public String getUpdatecode(){
        return updatecode;
    }

    /**
     * 设置属性UPDATEDATE
     * @param updatedate 待设置的属性UPDATEDATE的值
     */
    public void setUpdatedate(DateTime updatedate){
        this.updatedate = updatedate;
    }

    /**
     * 获取属性UPDATEDATE
     * @return 属性UPDATEDATE的值
     */
    public DateTime getUpdatedate(){
        return updatedate;
    }

    /**
     * 设置属性OPCODE
     * @param opcode 待设置的属性OPCODE的值
     */
    public void setOpcode(String opcode){
        this.opcode = StringUtils.rightTrim(opcode);
    }

    /**
     * 获取属性OPCODE
     * @return 属性OPCODE的值
     */
    public String getOpcode(){
        return opcode;
    }

    /**
     * 设置属性DAMAGETIME
     * @param damagetime 待设置的属性DAMAGETIME的值
     */
    public void setDamagetime(DateTime damagetime){
        this.damagetime = damagetime;
    }

    /**
     * 获取属性DAMAGETIME
     * @return 属性DAMAGETIME的值
     */
    public DateTime getDamagetime(){
        return damagetime;
    }
}
