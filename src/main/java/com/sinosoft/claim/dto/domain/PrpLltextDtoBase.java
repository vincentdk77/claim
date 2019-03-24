package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLltext-立案文字表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLltextDtoBase implements Serializable{
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告 */
    private String textType = "";
    /** 属性行号 */
    private int lineNo = 0;
    /** 属性文字说明 */
    private String context = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLltextDtoBase对象
     */
    public PrpLltextDtoBase(){
    }

    /**
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @param textType 待设置的属性文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告的值
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * 获取属性文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告
     * @return 属性文字说明类型 ▲
--** 出险摘要/查勘报告/结案报告的值
     */
    public String getTextType(){
        return textType;
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
     * 设置属性文字说明
     * @param context 待设置的属性文字说明的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性文字说明
     * @return 属性文字说明的值
     */
    public String getContext(){
        return context;
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
