package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdareagroup机动车费率区域分组表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDareaGroupDtoBase implements Serializable{
    /** 属性属于此区域的机构 */
    private String comCode = "";
    /** 属性费率区域组号 */
    private String areaGroup = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDareaGroupDtoBase对象
     */
    public PrpDareaGroupDtoBase(){
    }

    /**
     * 设置属性属于此区域的机构
     * @param comCode 待设置的属性属于此区域的机构的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性属于此区域的机构
     * @return 属性属于此区域的机构的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性费率区域组号
     * @param areaGroup 待设置的属性费率区域组号的值
     */
    public void setAreaGroup(String areaGroup){
        this.areaGroup = StringUtils.rightTrim(areaGroup);
    }

    /**
     * 获取属性费率区域组号
     * @return 属性费率区域组号的值
     */
    public String getAreaGroup(){
        return areaGroup;
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
