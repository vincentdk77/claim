package com.sinosoft.AgriXZrequest.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CorrectRequest_Temp的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CorrectRequest_TempDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性batchNo */
    private String batchNo = "";
    /** 属性businessNo */
    private String businessNo = "";
    /** 属性flag */
    private String flag = "";
    /** 属性businessType */
    private String businessType = "";

    /**
     *  默认构造方法,构造一个默认的CorrectRequest_TempDtoBase对象
     */
    public CorrectRequest_TempDtoBase(){
    }

    /**
     * 设置属性batchNo
     * @param batchNo 待设置的属性batchNo的值
     */
    public void setBatchNo(String batchNo){
        this.batchNo = StringUtils.rightTrim(batchNo);
    }

    /**
     * 获取属性batchNo
     * @return 属性batchNo的值
     */
    public String getBatchNo(){
        return batchNo;
    }

    /**
     * 设置属性businessNo
     * @param businessNo 待设置的属性businessNo的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性businessNo
     * @return 属性businessNo的值
     */
    public String getBusinessNo(){
        return businessNo;
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

    /**
     * 设置属性businessType
     * @param businessType 待设置的属性businessType的值
     */
    public void setBusinessType(String businessType){
        this.businessType = StringUtils.rightTrim(businessType);
    }

    /**
     * 获取属性businessType
     * @return 属性businessType的值
     */
    public String getBusinessType(){
        return businessType;
    }
}
