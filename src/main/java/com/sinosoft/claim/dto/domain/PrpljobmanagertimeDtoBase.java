package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGERTIME的数据传输对象基类<br>
 */
public class PrpljobmanagertimeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性FID */
    private String fid = "";
    /** 属性DATETYPE */
    private String datetype = "";
    /** 属性TIME */
    private String time = "";

    /**
     *  默认构造方法,构造一个默认的PrpljobmanagertimeDtoBase对象
     */
    public PrpljobmanagertimeDtoBase(){
    }

    /**
     * 设置属性FID
     * @param fid 待设置的属性FID的值
     */
    public void setFid(String fid){
        this.fid = StringUtils.rightTrim(fid);
    }

    /**
     * 获取属性FID
     * @return 属性FID的值
     */
    public String getFid(){
        return fid;
    }

    /**
     * 设置属性DATETYPE
     * @param datetype 待设置的属性DATETYPE的值
     */
    public void setDatetype(String datetype){
        this.datetype = StringUtils.rightTrim(datetype);
    }

    /**
     * 获取属性DATETYPE
     * @return 属性DATETYPE的值
     */
    public String getDatetype(){
        return datetype;
    }

    /**
     * 设置属性TIME
     * @param time 待设置的属性TIME的值
     */
    public void setTime(String time){
        this.time = StringUtils.rightTrim(time);
    }

    /**
     * 获取属性TIME
     * @return 属性TIME的值
     */
    public String getTime(){
        return time;
    }
}
