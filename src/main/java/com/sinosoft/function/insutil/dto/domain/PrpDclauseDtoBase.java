package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclause的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseDtoBase implements Serializable{
    /** 属性clausecode */
    private String clauseCode = "";
    /** 属性clausename */
    private String clauseName = "";
    /** 属性language */
    private String language = "";
    /** 属性titleflag */
    private String titleFlag = "";
    /** 属性lineno */
    private int lineNo = 0;
    /** 属性context */
    private String context = "";
    /** 属性newclausecode */
    private String newClauseCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclauseDtoBase对象
     */
    public PrpDclauseDtoBase(){
    }

    /**
     * 设置属性clausecode
     * @param clauseCode 待设置的属性clausecode的值
     */
    public void setClauseCode(String clauseCode){
        this.clauseCode = StringUtils.rightTrim(clauseCode);
    }

    /**
     * 获取属性clausecode
     * @return 属性clausecode的值
     */
    public String getClauseCode(){
        return clauseCode;
    }

    /**
     * 设置属性clausename
     * @param clauseName 待设置的属性clausename的值
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * 获取属性clausename
     * @return 属性clausename的值
     */
    public String getClauseName(){
        return clauseName;
    }

    /**
     * 设置属性language
     * @param language 待设置的属性language的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性language
     * @return 属性language的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性titleflag
     * @param titleFlag 待设置的属性titleflag的值
     */
    public void setTitleFlag(String titleFlag){
        this.titleFlag = StringUtils.rightTrim(titleFlag);
    }

    /**
     * 获取属性titleflag
     * @return 属性titleflag的值
     */
    public String getTitleFlag(){
        return titleFlag;
    }

    /**
     * 设置属性lineno
     * @param lineNo 待设置的属性lineno的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性lineno
     * @return 属性lineno的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性context
     * @param context 待设置的属性context的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性context
     * @return 属性context的值
     */
    public String getContext(){
        return context;
    }

    /**
     * 设置属性newclausecode
     * @param newClauseCode 待设置的属性newclausecode的值
     */
    public void setNewClauseCode(String newClauseCode){
        this.newClauseCode = StringUtils.rightTrim(newClauseCode);
    }

    /**
     * 获取属性newclausecode
     * @return 属性newclausecode的值
     */
    public String getNewClauseCode(){
        return newClauseCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
