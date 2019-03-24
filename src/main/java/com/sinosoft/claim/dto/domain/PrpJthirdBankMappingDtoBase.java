package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpJthirdBankMapping的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpJthirdBankMappingDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性thirdType */
    private String thirdType = "";
    /** 属性thirdbank */
    private String thirdbank = "";
    /** 属性gyBank */
    private String gyBank = "";
    /** 属性validstatus */
    private String validstatus = "";
    /** 属性reMark */
    private String reMark = "";
    /** 属性gyBankCode */
    private String gyBankCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpJthirdBankMappingDtoBase对象
     */
    public PrpJthirdBankMappingDtoBase(){
    }

    /**
     * 设置属性thirdType
     * @param thirdType 待设置的属性thirdType的值
     */
    public void setThirdType(String thirdType){
        this.thirdType = StringUtils.rightTrim(thirdType);
    }

    /**
     * 获取属性thirdType
     * @return 属性thirdType的值
     */
    public String getThirdType(){
        return thirdType;
    }

    /**
     * 设置属性thirdbank
     * @param thirdbank 待设置的属性thirdbank的值
     */
    public void setThirdbank(String thirdbank){
        this.thirdbank = StringUtils.rightTrim(thirdbank);
    }

    /**
     * 获取属性thirdbank
     * @return 属性thirdbank的值
     */
    public String getThirdbank(){
        return thirdbank;
    }

    /**
     * 设置属性gyBank
     * @param gyBank 待设置的属性gyBank的值
     */
    public void setGyBank(String gyBank){
        this.gyBank = StringUtils.rightTrim(gyBank);
    }

    /**
     * 获取属性gyBank
     * @return 属性gyBank的值
     */
    public String getGyBank(){
        return gyBank;
    }

    /**
     * 设置属性validstatus
     * @param validstatus 待设置的属性validstatus的值
     */
    public void setValidstatus(String validstatus){
        this.validstatus = StringUtils.rightTrim(validstatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidstatus(){
        return validstatus;
    }

    /**
     * 设置属性reMark
     * @param reMark 待设置的属性reMark的值
     */
    public void setReMark(String reMark){
        this.reMark = StringUtils.rightTrim(reMark);
    }

    /**
     * 获取属性reMark
     * @return 属性reMark的值
     */
    public String getReMark(){
        return reMark;
    }

    /**
     * 设置属性gyBankCode
     * @param gyBankCode 待设置的属性gyBankCode的值
     */
    public void setGyBankCode(String gyBankCode){
        this.gyBankCode = StringUtils.rightTrim(gyBankCode);
    }

    /**
     * 获取属性gyBankCode
     * @return 属性gyBankCode的值
     */
    public String getGyBankCode(){
        return gyBankCode;
    }
}
