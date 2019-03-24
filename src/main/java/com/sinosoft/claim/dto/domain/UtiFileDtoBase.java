package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utifile打印文件表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiFileDtoBase implements Serializable{
    /** 属性文件名称 */
    private String fileName = "";
    /** 属性行号 */
    private int lineNo = 0;
    /** 属性内容 */
    private String text = "";

    /**
     *  默认构造方法,构造一个默认的UtiFileDtoBase对象
     */
    public UtiFileDtoBase(){
    }

    /**
     * 设置属性文件名称
     * @param fileName 待设置的属性文件名称的值
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * 获取属性文件名称
     * @return 属性文件名称的值
     */
    public String getFileName(){
        return fileName;
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
     * @param text 待设置的属性内容的值
     */
    public void setText(String text){
        this.text = StringUtils.rightTrim(text);
    }

    /**
     * 获取属性内容
     * @return 属性内容的值
     */
    public String getText(){
        return text;
    }
}
