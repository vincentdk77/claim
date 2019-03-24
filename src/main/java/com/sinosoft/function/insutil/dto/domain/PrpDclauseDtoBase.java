package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdclause�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseDtoBase implements Serializable{
    /** ����clausecode */
    private String clauseCode = "";
    /** ����clausename */
    private String clauseName = "";
    /** ����language */
    private String language = "";
    /** ����titleflag */
    private String titleFlag = "";
    /** ����lineno */
    private int lineNo = 0;
    /** ����context */
    private String context = "";
    /** ����newclausecode */
    private String newClauseCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDclauseDtoBase����
     */
    public PrpDclauseDtoBase(){
    }

    /**
     * ��������clausecode
     * @param clauseCode �����õ�����clausecode��ֵ
     */
    public void setClauseCode(String clauseCode){
        this.clauseCode = StringUtils.rightTrim(clauseCode);
    }

    /**
     * ��ȡ����clausecode
     * @return ����clausecode��ֵ
     */
    public String getClauseCode(){
        return clauseCode;
    }

    /**
     * ��������clausename
     * @param clauseName �����õ�����clausename��ֵ
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * ��ȡ����clausename
     * @return ����clausename��ֵ
     */
    public String getClauseName(){
        return clauseName;
    }

    /**
     * ��������language
     * @param language �����õ�����language��ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ����language
     * @return ����language��ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * ��������titleflag
     * @param titleFlag �����õ�����titleflag��ֵ
     */
    public void setTitleFlag(String titleFlag){
        this.titleFlag = StringUtils.rightTrim(titleFlag);
    }

    /**
     * ��ȡ����titleflag
     * @return ����titleflag��ֵ
     */
    public String getTitleFlag(){
        return titleFlag;
    }

    /**
     * ��������lineno
     * @param lineNo �����õ�����lineno��ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ����lineno
     * @return ����lineno��ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ��������context
     * @param context �����õ�����context��ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ����context
     * @return ����context��ֵ
     */
    public String getContext(){
        return context;
    }

    /**
     * ��������newclausecode
     * @param newClauseCode �����õ�����newclausecode��ֵ
     */
    public void setNewClauseCode(String newClauseCode){
        this.newClauseCode = StringUtils.rightTrim(newClauseCode);
    }

    /**
     * ��ȡ����newclausecode
     * @return ����newclausecode��ֵ
     */
    public String getNewClauseCode(){
        return newClauseCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
