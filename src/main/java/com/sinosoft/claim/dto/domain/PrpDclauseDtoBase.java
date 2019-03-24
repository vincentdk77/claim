package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclause条款代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseDtoBase implements Serializable{
    /** 属性条款代码 */
    private String clauseCode = "";
    /** 属性条款名称 */
    private String clauseName = "";
    /** 属性语种(C/E/…) */
    private String language = "";
    /** 属性行号 */
    private int lineNo = 0;
    /** 属性条款内容 */
    private String context = "";
    /** 属性新条款代码 */
    private String newClauseCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclauseDtoBase对象
     */
    public PrpDclauseDtoBase(){
    }

    /**
     * 设置属性条款代码
     * @param clauseCode 待设置的属性条款代码的值
     */
    public void setClauseCode(String clauseCode){
        this.clauseCode = StringUtils.rightTrim(clauseCode);
    }

    /**
     * 获取属性条款代码
     * @return 属性条款代码的值
     */
    public String getClauseCode(){
        return clauseCode;
    }

    /**
     * 设置属性条款名称
     * @param clauseName 待设置的属性条款名称的值
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * 获取属性条款名称
     * @return 属性条款名称的值
     */
    public String getClauseName(){
        return clauseName;
    }

    /**
     * 设置属性语种(C/E/…)
     * @param language 待设置的属性语种(C/E/…)的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性语种(C/E/…)
     * @return 属性语种(C/E/…)的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性行号
     * @param lineNo 待设置的属性行号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性条款内容
     * @param context 待设置的属性条款内容的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性条款内容
     * @return 属性条款内容的值
     */
    public String getContext(){
        return context;
    }

    /**
     * 设置属性新条款代码
     * @param newClauseCode 待设置的属性新条款代码的值
     */
    public void setNewClauseCode(String newClauseCode){
        this.newClauseCode = StringUtils.rightTrim(newClauseCode);
    }

    /**
     * 获取属性新条款代码
     * @return 属性新条款代码的值
     */
    public String getNewClauseCode(){
        return newClauseCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
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
