package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdidentifierdesc检验人文本描述表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDescDtoBase implements Serializable{
    /** 属性检验人代码 */
    private String identifierCode = "";
    /** 属性序号 */
    private int lineNo = 0;
    /** 属性检验人信息 */
    private String mark = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDidentifierDescDtoBase对象
     */
    public PrpDidentifierDescDtoBase(){
    }

    /**
     * 设置属性检验人代码
     * @param identifierCode 待设置的属性检验人代码的值
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * 获取属性检验人代码
     * @return 属性检验人代码的值
     */
    public String getIdentifierCode(){
        return identifierCode;
    }

    /**
     * 设置属性序号
     * @param lineNo 待设置的属性序号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * 设置属性检验人信息
     * @param mark 待设置的属性检验人信息的值
     */
    public void setMark(String mark){
        this.mark = StringUtils.rightTrim(mark);
    }

    /**
     * 获取属性检验人信息
     * @return 属性检验人信息的值
     */
    public String getMark(){
        return mark;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
