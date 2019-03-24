package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpgroup单证分组的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGroupDtoBase implements Serializable{
    /** 属性合编组 */
    private String groupNo = "";
    /** 属性分编组 */
    private String subGroupNo = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpGroupDtoBase对象
     */
    public PrpGroupDtoBase(){
    }

    /**
     * 设置属性合编组
     * @param groupNo 待设置的属性合编组的值
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * 获取属性合编组
     * @return 属性合编组的值
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * 设置属性分编组
     * @param subGroupNo 待设置的属性分编组的值
     */
    public void setSubGroupNo(String subGroupNo){
        this.subGroupNo = StringUtils.rightTrim(subGroupNo);
    }

    /**
     * 获取属性分编组
     * @return 属性分编组的值
     */
    public String getSubGroupNo(){
        return subGroupNo;
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
