package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utifile的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiFileDtoBase implements Serializable{
    /** 属性filename */
    private String fileName = "";
    /** 属性lineno */
    private int lineNo = 0;
    /** 属性text */
    private String text = "";

    /**
     *  默认构造方法,构造一个默认的UtiFileDtoBase对象
     */
    public UtiFileDtoBase(){
    }

    /**
     * 设置属性filename
     * @param fileName 待设置的属性filename的值
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * 获取属性filename
     * @return 属性filename的值
     */
    public String getFileName(){
        return fileName;
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
     * 设置属性text
     * @param text 待设置的属性text的值
     */
    public void setText(String text){
        this.text = StringUtils.rightTrim(text);
    }

    /**
     * 获取属性text
     * @return 属性text的值
     */
    public String getText(){
        return text;
    }
}
