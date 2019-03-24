package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLregistText-报案文字表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistTextDtoBase implements Serializable{
    /** 属性出险登记号 */
    private String registNo = "";
    /** 属性文本类型 */
    private String textType = "";
    /** 属性行号 */
    private int lineNo = 0;
    /** 属性内容 */
    private String context = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLregistTextDtoBase对象
     */
    public PrpLregistTextDtoBase(){
    }

    /**
     * 设置属性出险登记号
     * @param registNo 待设置的属性出险登记号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性出险登记号
     * @return 属性出险登记号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性文本类型
     * @param textType 待设置的属性文本类型的值
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * 获取属性文本类型
     * @return 属性文本类型的值
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
     * 设置属性内容
     * @param context 待设置的属性内容的值
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * 获取属性内容
     * @return 属性内容的值
     */
    public String getContext(){
        return context;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
