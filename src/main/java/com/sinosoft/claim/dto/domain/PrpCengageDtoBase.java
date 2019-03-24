package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcengage特别约定表的数据传输对象基类<br>
 * 创建于 2004-10-20 12:07:31.897<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCengageDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性行序号 */
    private int lineNo = 0;
    /** 属性条款编码 */
    private String clauseCode = "";
    /** 属性条款文字描述 */
    private String clauses = "";
    /** 属性标题标志 */
    private String titleFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCengageDtoBase对象
     */
    public PrpCengageDtoBase(){
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性行序号
     * @param lineNo 待设置的属性行序号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行序号
     * @return 属性行序号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性条款编码
     * @param clauseCode 待设置的属性条款编码的值
     */
    public void setClauseCode(String clauseCode){
        this.clauseCode = StringUtils.rightTrim(clauseCode);
    }

    /**
     * 获取属性条款编码
     * @return 属性条款编码的值
     */
    public String getClauseCode(){
        return clauseCode;
    }

    /**
     * 设置属性条款文字描述
     * @param clauses 待设置的属性条款文字描述的值
     */
    public void setClauses(String clauses){
        this.clauses = StringUtils.rightTrim(clauses);
    }

    /**
     * 获取属性条款文字描述
     * @return 属性条款文字描述的值
     */
    public String getClauses(){
        return clauses;
    }

    /**
     * 设置属性标题标志
     * @param titleFlag 待设置的属性标题标志的值
     */
    public void setTitleFlag(String titleFlag){
        this.titleFlag = StringUtils.rightTrim(titleFlag);
    }

    /**
     * 获取属性标题标志
     * @return 属性标题标志的值
     */
    public String getTitleFlag(){
        return titleFlag;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
