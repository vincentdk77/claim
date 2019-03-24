package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciCheckText--调查文本信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckTextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckTextDtoBase.class.getName().hashCode();
    /** 属性调查号 */
    private String checkNo = "";
    /** 属性文字说明类型 */
    private String textType = "";
    /** 属性行号 */
    private long lineNo = 0L;
    /** 属性文字说明 */
    private String context = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLacciCheckTextDtoBase对象
     */
    public PrpLacciCheckTextDtoBase(){
    }

    /**
     * 设置属性调查号
     * @param checkNo 待设置的属性调查号的值
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * 获取属性调查号
     * @return 属性调查号的值
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * 设置属性文字说明类型
     * @param textType 待设置的属性文字说明类型的值
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * 获取属性文字说明类型
     * @return 属性文字说明类型的值
     */
    public String getTextType(){
        return textType;
    }

    /**
     * 设置属性行号
     * @param lineNo 待设置的属性行号的值
     */
    public void setLineNo(long lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public long getLineNo(){
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
