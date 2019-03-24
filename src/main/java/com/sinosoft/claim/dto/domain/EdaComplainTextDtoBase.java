package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是EdaComplainText投诉文字表的数据传输对象基类<br>
 * 创建于 2005-08-20 17:55:58.210<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaComplainTextDtoBase implements Serializable{
    /** 属性投诉登记号 */
    private double acceptNo = 0d;
    /** 属性文本类型 */
    private String textType = "";
    /** 属性序号 */
    private double serialNo = 0d;
    /** 属性行号 */
    private double lineNo = 0d;
    /** 属性录入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性内容 */
    private String context = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的EdaComplainTextDtoBase对象
     */
    public EdaComplainTextDtoBase(){
    }

    /**
     * 设置属性投诉登记号
     * @param acceptNo 待设置的属性投诉登记号的值
     */
    public void setAcceptNo(double acceptNo){
        this.acceptNo = acceptNo;
    }

    /**
     * 获取属性投诉登记号
     * @return 属性投诉登记号的值
     */
    public double getAcceptNo(){
        return acceptNo;
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
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(double serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public double getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性行号
     * @param lineNo 待设置的属性行号的值
     */
    public void setLineNo(double lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public double getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性录入日期
     * @param inputDate 待设置的属性录入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性录入日期
     * @return 属性录入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
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
