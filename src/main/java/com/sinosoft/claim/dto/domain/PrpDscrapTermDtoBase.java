package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdscrapterm汽车报废标准表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDscrapTermDtoBase implements Serializable{
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性使用年限 */
    private int useYear = 0;
    /** 属性允许延长年限 */
    private int proLongYear = 0;
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDscrapTermDtoBase对象
     */
    public PrpDscrapTermDtoBase(){
    }

    /**
     * 设置属性车辆种类代码
     * @param carKindCode 待设置的属性车辆种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码
     * @return 属性车辆种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性使用年限
     * @param useYear 待设置的属性使用年限的值
     */
    public void setUseYear(int useYear){
        this.useYear = useYear;
    }

    /**
     * 获取属性使用年限
     * @return 属性使用年限的值
     */
    public int getUseYear(){
        return useYear;
    }

    /**
     * 设置属性允许延长年限
     * @param proLongYear 待设置的属性允许延长年限的值
     */
    public void setProLongYear(int proLongYear){
        this.proLongYear = proLongYear;
    }

    /**
     * 获取属性允许延长年限
     * @return 属性允许延长年限的值
     */
    public int getProLongYear(){
        return proLongYear;
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
