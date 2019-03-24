package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpusergrade员工权限表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** 属性员工代码 */
    private String userCode = "";
    /** 属性险类权限 */
    private String power = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpUserGradeDtoBase对象
     */
    public PrpUserGradeDtoBase(){
    }

    /**
     * 设置属性员工代码
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性险类权限
     * @param power 待设置的属性险类权限的值
     */
    public void setPower(String power){
        this.power = StringUtils.rightTrim(power);
    }

    /**
     * 获取属性险类权限
     * @return 属性险类权限的值
     */
    public String getPower(){
        return power;
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
