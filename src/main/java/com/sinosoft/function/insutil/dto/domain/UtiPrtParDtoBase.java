package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtpar的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtParDtoBase implements Serializable{
    /** 属性filename */
    private String fileName = "";
    /** 属性labelno */
    private String labelNo = "";
    /** 属性xpos */
    private int xpos = 0;
    /** 属性ypos */
    private int ypos = 0;
    /** 属性len */
    private int len = 0;

    /**
     *  默认构造方法,构造一个默认的UtiPrtParDtoBase对象
     */
    public UtiPrtParDtoBase(){
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
     * 设置属性labelno
     * @param labelNo 待设置的属性labelno的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性labelno
     * @return 属性labelno的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性xpos
     * @param xpos 待设置的属性xpos的值
     */
    public void setXpos(int xpos){
        this.xpos = xpos;
    }

    /**
     * 获取属性xpos
     * @return 属性xpos的值
     */
    public int getXpos(){
        return xpos;
    }

    /**
     * 设置属性ypos
     * @param ypos 待设置的属性ypos的值
     */
    public void setYpos(int ypos){
        this.ypos = ypos;
    }

    /**
     * 获取属性ypos
     * @return 属性ypos的值
     */
    public int getYpos(){
        return ypos;
    }

    /**
     * 设置属性len
     * @param len 待设置的属性len的值
     */
    public void setLen(int len){
        this.len = len;
    }

    /**
     * 获取属性len
     * @return 属性len的值
     */
    public int getLen(){
        return len;
    }
}
