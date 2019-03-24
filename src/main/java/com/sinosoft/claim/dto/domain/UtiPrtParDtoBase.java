package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtpar单证打印文件坐标表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtParDtoBase implements Serializable{
    /** 属性文件名称 */
    private String fileName = "";
    /** 属性标号 */
    private String labelNo = "";
    /** 属性行坐标 */
    private int xpos = 0;
    /** 属性列坐标 */
    private int ypos = 0;
    /** 属性长度 */
    private int len = 0;

    /**
     *  默认构造方法,构造一个默认的UtiPrtParDtoBase对象
     */
    public UtiPrtParDtoBase(){
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
     * 设置属性标号
     * @param labelNo 待设置的属性标号的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性标号
     * @return 属性标号的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性行坐标
     * @param xpos 待设置的属性行坐标的值
     */
    public void setXpos(int xpos){
        this.xpos = xpos;
    }

    /**
     * 获取属性行坐标
     * @return 属性行坐标的值
     */
    public int getXpos(){
        return xpos;
    }

    /**
     * 设置属性列坐标
     * @param ypos 待设置的属性列坐标的值
     */
    public void setYpos(int ypos){
        this.ypos = ypos;
    }

    /**
     * 获取属性列坐标
     * @return 属性列坐标的值
     */
    public int getYpos(){
        return ypos;
    }

    /**
     * 设置属性长度
     * @param len 待设置的属性长度的值
     */
    public void setLen(int len){
        this.len = len;
    }

    /**
     * 获取属性长度
     * @return 属性长度的值
     */
    public int getLen(){
        return len;
    }
}
