package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgroup的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGroupDtoBase implements Serializable{
    /** 属性groupno */
    private String groupNo = "";
    /** 属性subgroupno */
    private String subGroupNo = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGroupDtoBase对象
     */
    public PrpGroupDtoBase(){
    }

    /**
     * 设置属性groupno
     * @param groupNo 待设置的属性groupno的值
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * 获取属性groupno
     * @return 属性groupno的值
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * 设置属性subgroupno
     * @param subGroupNo 待设置的属性subgroupno的值
     */
    public void setSubGroupNo(String subGroupNo){
        this.subGroupNo = StringUtils.rightTrim(subGroupNo);
    }

    /**
     * 获取属性subgroupno
     * @return 属性subgroupno的值
     */
    public String getSubGroupNo(){
        return subGroupNo;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
